package com.pokemon.service;

import com.pokemon.model.Battle;
import com.pokemon.model.Item;
import com.pokemon.model.ItemType;
import com.pokemon.model.Move;
import com.pokemon.model.Type;
import com.pokemon.model.TypeEffectiveness;
import com.pokemon.model.Pokemon;
import com.pokemon.repository.BattleRepository;
import com.pokemon.repository.PokemonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Collectors;

@Service
public class BattleService {

    // Wild encounters are only drawn from the numbered Pokedex (excludes the 999 "Super Pikachu" easter egg).
    private static final int MAX_WILD_POKEMON_ID = 151;

    private final BattleRepository battleRepository;
    private final PokemonRepository pokemonRepository;
    private final InventoryService inventoryService;
    private final TrainerService trainerService;
    private final Random random;

    @Autowired
    public BattleService(BattleRepository battleRepository, PokemonRepository pokemonRepository,
                          InventoryService inventoryService, TrainerService trainerService) {
        this.battleRepository = battleRepository;
        this.pokemonRepository = pokemonRepository;
        this.inventoryService = inventoryService;
        this.trainerService = trainerService;
        this.random = new Random();
    }

    public Battle startBattle(int playerPokemonId) {
        Pokemon playerPokemon = pokemonRepository.findById(playerPokemonId)
                .orElseThrow(() -> new IllegalArgumentException("Player Pokemon not found"));

        Pokemon opponentPokemon = pickRandomWildPokemon();

        Battle battle = new Battle(playerPokemon, opponentPokemon);
        return battleRepository.save(battle);
    }

    private Pokemon pickRandomWildPokemon() {
        List<Pokemon> wildPool = pokemonRepository.findAll().stream()
                .filter(p -> p.getId() <= MAX_WILD_POKEMON_ID)
                .collect(Collectors.toList());
        return wildPool.get(random.nextInt(wildPool.size()));
    }

    // Uses an item mid-battle: HEALING restores the player's Pokemon's HP,
    // POKEBALL attempts to catch the opponent. Either way it consumes the turn
    // unless the catch succeeds, in which case the battle ends immediately.
    public Battle useItem(String battleId, int itemId) {
        Battle battle = battleRepository.findById(battleId)
                .orElseThrow(() -> new IllegalArgumentException("Battle not found"));

        if (battle.isOver()) {
            throw new IllegalStateException("Battle is already over");
        }

        Item item = inventoryService.useOneItem(itemId);

        if (item.getItemType() == ItemType.HEALING) {
            applyHealing(battle, item);
            executeOpponentTurn(battle);
        } else if (item.getItemType() == ItemType.POKEBALL) {
            attemptCatch(battle, item);
            if (!battle.isCaught()) {
                executeOpponentTurn(battle);
            }
        }

        return battleRepository.save(battle);
    }

    private void applyHealing(Battle battle, Item item) {
        Pokemon player = battle.getPlayer();
        int healedHp = Math.min(player.getMaxHp(), player.getCurrentHp() + item.getPotency());
        player.setCurrentHp(healedHp);
        battle.addLogEntry(String.format("%s used %s! Restored HP to %d/%d.",
                player.getName(), item.getName(), healedHp, player.getMaxHp()));
    }

    // Catch chance blends ball quality with how weakened the wild Pokemon is:
    // even at full HP, ball quality alone gives a 30% baseline chance of ballRate,
    // and that climbs to the full ballRate as the opponent's HP nears zero.
    private void attemptCatch(Battle battle, Item item) {
        Pokemon opponent = battle.getOpponent();
        double ballRate = item.getPotency() / 100.0;
        double missingHpFactor = 1 - ((double) opponent.getCurrentHp() / opponent.getMaxHp());
        double chance = Math.max(0, Math.min(1, ballRate * (0.3 + 0.7 * missingHpFactor)));

        boolean success = random.nextDouble() < chance;
        if (success) {
            battle.setCaught(true);
            trainerService.addPokemonToCollection(new Pokemon(opponent));
            battle.addLogEntry(String.format("Gotcha! %s was caught!", opponent.getName()));
        } else {
            battle.addLogEntry(String.format("%s used %s! %s broke free!",
                    battle.getPlayer().getName(), item.getName(), opponent.getName()));
        }
    }

    // Executes the players move in battle.
    public Battle executeMove(String battleId, String moveName) {
        Battle battle = battleRepository.findById(battleId)
                .orElseThrow(() -> new IllegalArgumentException("Battle not found"));
        
        if (battle.isOver()) {
            throw new IllegalStateException("Battle is already over");
        }
        
        // Player's turn
        Move move = battle.getPlayer().getMove(moveName);
        if (move == null) {
            throw new IllegalArgumentException("Invalid move: " + moveName);
        }

        // Calculate and apply damage
        ArrayList<Double> results = new ArrayList<Double>();
        results.addAll(calculateDamage(
                battle.getPlayer().getAttack(),
                battle.getOpponent().getDefense(),
                move.getPower(),
                move.getType(),
                battle.getPlayer().getType(),
                battle.getOpponent().getType(),
                true // Player's turn
        ));

        System.out.println("Player Damage Results[0]: " + results.get(0));
        System.out.println("Player Results[1]: " + results.get(1));
        battle.getOpponent().takeDamage(results.get(0).intValue());
        battle.addLogEntry(String.format("%s used %s! Dealt %d damage.",
                battle.getPlayer().getName(), move.getName(), results.get(0).intValue()));
        battle.addLogEntry(TypeEffectiveness.getMessage(results.get(1)));

        // Check if opponent fainted
        if (battle.getOpponent().isFainted()) {
            battle.addLogEntry(String.format("%s fainted! You win!",
                    battle.getOpponent().getName()));
            return battleRepository.save(battle);
        }
        
        // Opponent's turn (AI)
        executeOpponentTurn(battle);
        
        return battleRepository.save(battle);
    }

    // Executes the opponents turn in battle. This is a simple AI that randomly selects one of the opponent's moves.
    private void executeOpponentTurn(Battle battle) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        List<Move> opponentMoves = battle.getOpponent().getMoves();
        Move opponentMove = opponentMoves.get(random.nextInt(opponentMoves.size()));

        ArrayList<Double> results = new ArrayList<Double>();
        results.addAll(calculateDamage(
                battle.getOpponent().getAttack(),
                battle.getPlayer().getDefense(),
                opponentMove.getPower(),
                opponentMove.getType(),
                battle.getOpponent().getType(),
                battle.getPlayer().getType(),
                false // Opponent's turn
        ));


        System.out.println("Opponent Damage Results[0]: " + results.get(0));
        System.out.println("Opponent Results[1]: " + results.get(1));

        battle.getPlayer().takeDamage(results.get(0).intValue());
        battle.addLogEntry(String.format("%s used %s! Dealt %d damage.",
                battle.getOpponent().getName(), opponentMove.getName(), results.get(0).intValue()));
        battle.addLogEntry(TypeEffectiveness.getMessage(results.get(1)));

        // Check if player fainted
        if (battle.getPlayer().isFainted()) {
            battle.addLogEntry(String.format("%s fainted! You lost!",
                    battle.getPlayer().getName()));
        }
    }
    
    /**
     * Simplified damage calculation based on Pokemon formula
     * Formula: ((2 * Level / 5 + 2) * Power * Attack / Defense) / 50 * RandomFactor
     */
    private ArrayList<Double> calculateDamage(int attack, int defense, int movePower, Type moveType, Type trainerType, Type opponentType, Boolean isPlayer) {
        Type enemyType = null;

        if (movePower == 0) {
            return new ArrayList<>(Arrays.asList(0.0, 0.0));
        }

        if (isPlayer == Boolean.TRUE) {
            enemyType = opponentType;
        }
        else {
            enemyType = trainerType;
        }

        System.out.println("Enemy type: " + enemyType);
        System.out.println("Move type: " + moveType);

        double damage = 0;
        double level = 5; // Assuming all Pokemon are level 5
        double baseDamage = ((((2 * level) / 5) + 2) * movePower * ((double) attack / (double) defense)) / 50 + 2;
        double randomFactor = 0.85 + (random.nextDouble() * 0.15); // 85-100%
        double typeEffectiveness = TypeEffectiveness.getMultiplier(moveType, enemyType);


        if (moveType == trainerType) {
            damage = Math.floor(baseDamage * 1.5);
        }
        else {
            damage = Math.floor(baseDamage * typeEffectiveness);
        }
        return new ArrayList<Double>(Arrays.asList((double) damage, typeEffectiveness));
    }
    
    public Optional<Battle> getBattle(String battleId) {
        return battleRepository.findById(battleId);
    }
}
