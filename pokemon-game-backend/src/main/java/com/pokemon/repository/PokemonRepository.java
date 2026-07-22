package com.pokemon.repository;

import com.pokemon.model.Pokemon;
import com.pokemon.model.Move;
import com.pokemon.model.Type;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class PokemonRepository {
    
    private final Map<Integer, Pokemon> pokemonDatabase;

    private static final String SPRITE_URL =
            "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/%d.png";

    public PokemonRepository() {
        this.pokemonDatabase = new HashMap<>();
        initializePokemon();
    }

    // Pokemon initialization method to populate the database with Pokemon data.
    // Signature for a new pokemon object is
    // Pokemon(int id, String name, int level, Type type, int hp, int attack, int defense, int speed, String spriteUrl)
    private void initializePokemon() {
        // Super Pikachu Rare Boss
        Pokemon superPikachu = new Pokemon(999, "Super Pikachu", 75, Type.ELECTRIC, 100, 100, 100, 100,
                SPRITE_URL.formatted(25));
        superPikachu.addMove(new Move("Gigazap", 150, Type.ELECTRIC));
        superPikachu.addMove(new Move("Aura Farm", 0, Type.NORMAL));
        superPikachu.addMove(new Move("Wrath of The Rat", 200, Type.FIGHTING));
        superPikachu.addMove(new Move("Splash", 0, Type.WATER));
        pokemonDatabase.put(999, superPikachu);

        // #001 Bulbasaur
        Pokemon bulbasaur = new Pokemon(1, "Bulbasaur", 5, Type.GRASS, 45, 49, 49, 45,
                SPRITE_URL.formatted(1));
        bulbasaur.addMove(new Move("Tackle", 40, Type.NORMAL));
        bulbasaur.addMove(new Move("Vine Whip", 45, Type.GRASS));
        bulbasaur.addMove(new Move("Growth", 0, Type.NORMAL));
        bulbasaur.addMove(new Move("Razor Leaf", 55, Type.GRASS));
        pokemonDatabase.put(1, bulbasaur);

        // #002 Ivysaur
        Pokemon ivysaur = new Pokemon(2, "Ivysaur", 16, Type.GRASS, 60, 62, 63, 60,
                SPRITE_URL.formatted(2));
        ivysaur.addMove(new Move("Tackle", 40, Type.NORMAL));
        ivysaur.addMove(new Move("Vine Whip", 45, Type.GRASS));
        ivysaur.addMove(new Move("Growth", 0, Type.NORMAL));
        ivysaur.addMove(new Move("Razor Leaf", 55, Type.GRASS));
        pokemonDatabase.put(2, ivysaur);

        // #003 Venusaur
        Pokemon venusaur = new Pokemon(3, "Venusaur", 32, Type.GRASS, 80, 82, 83, 80,
                SPRITE_URL.formatted(3));
        venusaur.addMove(new Move("Tackle", 40, Type.NORMAL));
        venusaur.addMove(new Move("Vine Whip", 45, Type.GRASS));
        venusaur.addMove(new Move("Growth", 0, Type.NORMAL));
        venusaur.addMove(new Move("Razor Leaf", 55, Type.GRASS));
        pokemonDatabase.put(3, venusaur);

        // #004 Charmander
        Pokemon charmander = new Pokemon(4, "Charmander", 5, Type.FIRE, 39, 52, 43, 65,
                SPRITE_URL.formatted(4));
        charmander.addMove(new Move("Scratch", 40, Type.NORMAL));
        charmander.addMove(new Move("Ember", 40, Type.FIRE));
        charmander.addMove(new Move("Growl", 0, Type.NORMAL));
        charmander.addMove(new Move("Flamethrower", 90, Type.FIRE));
        pokemonDatabase.put(4, charmander);

        // #005 Charmeleon
        Pokemon charmeleon = new Pokemon(5, "Charmeleon", 16, Type.FIRE, 58, 64, 58, 80,
                SPRITE_URL.formatted(5));
        charmeleon.addMove(new Move("Scratch", 40, Type.NORMAL));
        charmeleon.addMove(new Move("Ember", 40, Type.FIRE));
        charmeleon.addMove(new Move("Smokescreen", 0, Type.NORMAL));
        charmeleon.addMove(new Move("Flamethrower", 90, Type.FIRE));
        pokemonDatabase.put(5, charmeleon);

        // #006 Charizard
        Pokemon charizard = new Pokemon(6, "Charizard", 36, Type.FIRE, 78, 84, 78, 100,
                SPRITE_URL.formatted(6));
        charizard.addMove(new Move("Scratch", 40, Type.NORMAL));
        charizard.addMove(new Move("Ember", 40, Type.FIRE));
        charizard.addMove(new Move("Smokescreen", 0, Type.NORMAL));
        charizard.addMove(new Move("Flamethrower", 90, Type.FIRE));
        pokemonDatabase.put(6, charizard);

        // #007 Squirtle
        Pokemon squirtle = new Pokemon(7, "Squirtle", 5, Type.WATER, 44, 48, 65, 43,
                SPRITE_URL.formatted(7));
        squirtle.addMove(new Move("Tackle", 40, Type.NORMAL));
        squirtle.addMove(new Move("Water Gun", 40, Type.WATER));
        squirtle.addMove(new Move("Tail Whip", 0, Type.NORMAL));
        squirtle.addMove(new Move("Hydro Pump", 110, Type.WATER));
        pokemonDatabase.put(7, squirtle);

        // #008 Wartortle
        Pokemon wartortle = new Pokemon(8, "Wartortle", 16, Type.WATER, 59, 63, 80, 58,
                SPRITE_URL.formatted(8));
        wartortle.addMove(new Move("Tackle", 40, Type.NORMAL));
        wartortle.addMove(new Move("Water Gun", 40, Type.WATER));
        wartortle.addMove(new Move("Tail Whip", 0, Type.NORMAL));
        wartortle.addMove(new Move("Hydro Pump", 110, Type.WATER));
        pokemonDatabase.put(8, wartortle);

        // #009 Blastoise
        Pokemon blastoise = new Pokemon(9, "Blastoise", 36, Type.WATER, 79, 83, 100, 78,
                SPRITE_URL.formatted(9));
        blastoise.addMove(new Move("Tackle", 40, Type.NORMAL));
        blastoise.addMove(new Move("Water Gun", 40, Type.WATER));
        blastoise.addMove(new Move("Tail Whip", 0, Type.NORMAL));
        blastoise.addMove(new Move("Hydro Pump", 110, Type.WATER));
        pokemonDatabase.put(9, blastoise);

        // #010 Caterpie
        Pokemon caterpie = new Pokemon(10, "Caterpie", 3, Type.BUG, 45, 30, 35, 45,
                SPRITE_URL.formatted(10));
        caterpie.addMove(new Move("Tackle", 40, Type.NORMAL));
        caterpie.addMove(new Move("String Shot", 0, Type.BUG));
        caterpie.addMove(new Move("Bug Bite", 60, Type.BUG));
        caterpie.addMove(new Move("Electroweb", 55, Type.ELECTRIC));
        pokemonDatabase.put(10, caterpie);

        // #011 Metapod
        Pokemon metapod = new Pokemon(11, "Metapod", 10, Type.BUG, 50, 20, 55, 30,
                SPRITE_URL.formatted(11));
        metapod.addMove(new Move("Harden", 0, Type.NORMAL));
        metapod.addMove(new Move("Iron Defense", 0, Type.STEEL));
        metapod.addMove(new Move("Bug Bite", 60, Type.BUG));
        metapod.addMove(new Move("Tackle", 40, Type.NORMAL));
        pokemonDatabase.put(11, metapod);

        // #012 Butterfree
        Pokemon butterfree = new Pokemon(12, "Butterfree", 16, Type.BUG, 60, 45, 50, 70,
                SPRITE_URL.formatted(12));
        butterfree.addMove(new Move("Tackle", 40, Type.NORMAL));
        butterfree.addMove(new Move("Bug Bite", 60, Type.BUG));
        butterfree.addMove(new Move("String Shot", 0, Type.BUG));
        butterfree.addMove(new Move("X-Scissor", 80, Type.BUG));
        pokemonDatabase.put(12, butterfree);

        // #013 Weedle
        Pokemon weedle = new Pokemon(13, "Weedle", 3, Type.BUG, 40, 35, 30, 50,
                SPRITE_URL.formatted(13));
        weedle.addMove(new Move("Poison Sting", 15, Type.POISON));
        weedle.addMove(new Move("String Shot", 0, Type.BUG));
        weedle.addMove(new Move("Bug Bite", 60, Type.BUG));
        weedle.addMove(new Move("Electroweb", 55, Type.ELECTRIC));
        pokemonDatabase.put(13, weedle);

        // #014 Kakuna
        Pokemon kakuna = new Pokemon(14, "Kakuna", 10, Type.BUG, 45, 25, 50, 35,
                SPRITE_URL.formatted(14));
        kakuna.addMove(new Move("Harden", 0, Type.NORMAL));
        kakuna.addMove(new Move("Iron Defense", 0, Type.STEEL));
        kakuna.addMove(new Move("Bug Bite", 60, Type.BUG));
        kakuna.addMove(new Move("Tackle", 40, Type.NORMAL));
        pokemonDatabase.put(14, kakuna);

        // #015 Beedrill
        Pokemon beedrill = new Pokemon(15, "Beedrill", 16, Type.BUG, 65, 90, 40, 75,
                SPRITE_URL.formatted(15));
        beedrill.addMove(new Move("Tackle", 40, Type.NORMAL));
        beedrill.addMove(new Move("Bug Bite", 60, Type.BUG));
        beedrill.addMove(new Move("String Shot", 0, Type.BUG));
        beedrill.addMove(new Move("X-Scissor", 80, Type.BUG));
        pokemonDatabase.put(15, beedrill);

        // #016 Pidgey
        Pokemon pidgey = new Pokemon(16, "Pidgey", 3, Type.NORMAL, 40, 45, 40, 56,
                SPRITE_URL.formatted(16));
        pidgey.addMove(new Move("Tackle", 40, Type.NORMAL));
        pidgey.addMove(new Move("Quick Attack", 40, Type.NORMAL));
        pidgey.addMove(new Move("Bite", 60, Type.DARK));
        pidgey.addMove(new Move("Body Slam", 85, Type.NORMAL));
        pokemonDatabase.put(16, pidgey);

        // #017 Pidgeotto
        Pokemon pidgeotto = new Pokemon(17, "Pidgeotto", 18, Type.NORMAL, 63, 60, 55, 71,
                SPRITE_URL.formatted(17));
        pidgeotto.addMove(new Move("Tackle", 40, Type.NORMAL));
        pidgeotto.addMove(new Move("Quick Attack", 40, Type.NORMAL));
        pidgeotto.addMove(new Move("Bite", 60, Type.DARK));
        pidgeotto.addMove(new Move("Body Slam", 85, Type.NORMAL));
        pokemonDatabase.put(17, pidgeotto);

        // #018 Pidgeot
        Pokemon pidgeot = new Pokemon(18, "Pidgeot", 36, Type.NORMAL, 83, 80, 75, 101,
                SPRITE_URL.formatted(18));
        pidgeot.addMove(new Move("Tackle", 40, Type.NORMAL));
        pidgeot.addMove(new Move("Quick Attack", 40, Type.NORMAL));
        pidgeot.addMove(new Move("Bite", 60, Type.DARK));
        pidgeot.addMove(new Move("Body Slam", 85, Type.NORMAL));
        pokemonDatabase.put(18, pidgeot);

        // #019 Rattata
        Pokemon rattata = new Pokemon(19, "Rattata", 3, Type.NORMAL, 30, 56, 35, 72,
                SPRITE_URL.formatted(19));
        rattata.addMove(new Move("Tackle", 40, Type.NORMAL));
        rattata.addMove(new Move("Quick Attack", 40, Type.NORMAL));
        rattata.addMove(new Move("Bite", 60, Type.DARK));
        rattata.addMove(new Move("Body Slam", 85, Type.NORMAL));
        pokemonDatabase.put(19, rattata);

        // #020 Raticate
        Pokemon raticate = new Pokemon(20, "Raticate", 20, Type.NORMAL, 55, 81, 60, 97,
                SPRITE_URL.formatted(20));
        raticate.addMove(new Move("Tackle", 40, Type.NORMAL));
        raticate.addMove(new Move("Quick Attack", 40, Type.NORMAL));
        raticate.addMove(new Move("Bite", 60, Type.DARK));
        raticate.addMove(new Move("Body Slam", 85, Type.NORMAL));
        pokemonDatabase.put(20, raticate);

        // #021 Spearow
        Pokemon spearow = new Pokemon(21, "Spearow", 3, Type.NORMAL, 40, 60, 30, 70,
                SPRITE_URL.formatted(21));
        spearow.addMove(new Move("Tackle", 40, Type.NORMAL));
        spearow.addMove(new Move("Quick Attack", 40, Type.NORMAL));
        spearow.addMove(new Move("Bite", 60, Type.DARK));
        spearow.addMove(new Move("Body Slam", 85, Type.NORMAL));
        pokemonDatabase.put(21, spearow);

        // #022 Fearow
        Pokemon fearow = new Pokemon(22, "Fearow", 20, Type.NORMAL, 65, 90, 65, 100,
                SPRITE_URL.formatted(22));
        fearow.addMove(new Move("Tackle", 40, Type.NORMAL));
        fearow.addMove(new Move("Quick Attack", 40, Type.NORMAL));
        fearow.addMove(new Move("Bite", 60, Type.DARK));
        fearow.addMove(new Move("Body Slam", 85, Type.NORMAL));
        pokemonDatabase.put(22, fearow);

        // #023 Ekans
        Pokemon ekans = new Pokemon(23, "Ekans", 5, Type.POISON, 35, 60, 44, 55,
                SPRITE_URL.formatted(23));
        ekans.addMove(new Move("Tackle", 40, Type.NORMAL));
        ekans.addMove(new Move("Acid", 40, Type.POISON));
        ekans.addMove(new Move("Poison Gas", 0, Type.POISON));
        ekans.addMove(new Move("Sludge Bomb", 90, Type.POISON));
        pokemonDatabase.put(23, ekans);

        // #024 Arbok
        Pokemon arbok = new Pokemon(24, "Arbok", 22, Type.POISON, 60, 95, 69, 80,
                SPRITE_URL.formatted(24));
        arbok.addMove(new Move("Tackle", 40, Type.NORMAL));
        arbok.addMove(new Move("Acid", 40, Type.POISON));
        arbok.addMove(new Move("Poison Gas", 0, Type.POISON));
        arbok.addMove(new Move("Sludge Bomb", 90, Type.POISON));
        pokemonDatabase.put(24, arbok);

        // #025 Pikachu
        Pokemon pikachu = new Pokemon(25, "Pikachu", 5, Type.ELECTRIC, 35, 55, 40, 90,
                SPRITE_URL.formatted(25));
        pikachu.addMove(new Move("Quick Attack", 40, Type.NORMAL));
        pikachu.addMove(new Move("Thunder Shock", 40, Type.ELECTRIC));
        pikachu.addMove(new Move("Tail Whip", 0, Type.NORMAL));
        pikachu.addMove(new Move("Thunderbolt", 90, Type.ELECTRIC));
        pokemonDatabase.put(25, pikachu);

        // #026 Raichu
        Pokemon raichu = new Pokemon(26, "Raichu", 30, Type.ELECTRIC, 60, 90, 55, 110,
                SPRITE_URL.formatted(26));
        raichu.addMove(new Move("Quick Attack", 40, Type.NORMAL));
        raichu.addMove(new Move("Thunder Shock", 40, Type.ELECTRIC));
        raichu.addMove(new Move("Thunder Wave", 0, Type.ELECTRIC));
        raichu.addMove(new Move("Thunderbolt", 90, Type.ELECTRIC));
        pokemonDatabase.put(26, raichu);

        // #027 Sandshrew
        Pokemon sandshrew = new Pokemon(27, "Sandshrew", 8, Type.GROUND, 50, 75, 85, 40,
                SPRITE_URL.formatted(27));
        sandshrew.addMove(new Move("Scratch", 40, Type.NORMAL));
        sandshrew.addMove(new Move("Mud-Slap", 20, Type.GROUND));
        sandshrew.addMove(new Move("Sand Attack", 0, Type.GROUND));
        sandshrew.addMove(new Move("Earthquake", 100, Type.GROUND));
        pokemonDatabase.put(27, sandshrew);

        // #028 Sandslash
        Pokemon sandslash = new Pokemon(28, "Sandslash", 32, Type.GROUND, 75, 100, 110, 65,
                SPRITE_URL.formatted(28));
        sandslash.addMove(new Move("Scratch", 40, Type.NORMAL));
        sandslash.addMove(new Move("Mud-Slap", 20, Type.GROUND));
        sandslash.addMove(new Move("Sand Attack", 0, Type.GROUND));
        sandslash.addMove(new Move("Earthquake", 100, Type.GROUND));
        pokemonDatabase.put(28, sandslash);

        // #029 Nidoran♀
        Pokemon nidoranF = new Pokemon(29, "Nidoran♀", 6, Type.POISON, 55, 47, 52, 41,
                SPRITE_URL.formatted(29));
        nidoranF.addMove(new Move("Tackle", 40, Type.NORMAL));
        nidoranF.addMove(new Move("Acid", 40, Type.POISON));
        nidoranF.addMove(new Move("Poison Gas", 0, Type.POISON));
        nidoranF.addMove(new Move("Sludge Bomb", 90, Type.POISON));
        pokemonDatabase.put(29, nidoranF);

        // #030 Nidorina
        Pokemon nidorina = new Pokemon(30, "Nidorina", 16, Type.POISON, 70, 62, 67, 56,
                SPRITE_URL.formatted(30));
        nidorina.addMove(new Move("Tackle", 40, Type.NORMAL));
        nidorina.addMove(new Move("Acid", 40, Type.POISON));
        nidorina.addMove(new Move("Poison Gas", 0, Type.POISON));
        nidorina.addMove(new Move("Sludge Bomb", 90, Type.POISON));
        pokemonDatabase.put(30, nidorina);

        // #031 Nidoqueen
        Pokemon nidoqueen = new Pokemon(31, "Nidoqueen", 32, Type.POISON, 90, 92, 87, 76,
                SPRITE_URL.formatted(31));
        nidoqueen.addMove(new Move("Tackle", 40, Type.NORMAL));
        nidoqueen.addMove(new Move("Acid", 40, Type.POISON));
        nidoqueen.addMove(new Move("Poison Gas", 0, Type.POISON));
        nidoqueen.addMove(new Move("Sludge Bomb", 90, Type.POISON));
        pokemonDatabase.put(31, nidoqueen);

        // #032 Nidoran♂
        Pokemon nidoranM = new Pokemon(32, "Nidoran♂", 6, Type.POISON, 46, 57, 40, 50,
                SPRITE_URL.formatted(32));
        nidoranM.addMove(new Move("Tackle", 40, Type.NORMAL));
        nidoranM.addMove(new Move("Acid", 40, Type.POISON));
        nidoranM.addMove(new Move("Poison Gas", 0, Type.POISON));
        nidoranM.addMove(new Move("Sludge Bomb", 90, Type.POISON));
        pokemonDatabase.put(32, nidoranM);

        // #033 Nidorino
        Pokemon nidorino = new Pokemon(33, "Nidorino", 16, Type.POISON, 61, 72, 57, 65,
                SPRITE_URL.formatted(33));
        nidorino.addMove(new Move("Tackle", 40, Type.NORMAL));
        nidorino.addMove(new Move("Acid", 40, Type.POISON));
        nidorino.addMove(new Move("Poison Gas", 0, Type.POISON));
        nidorino.addMove(new Move("Sludge Bomb", 90, Type.POISON));
        pokemonDatabase.put(33, nidorino);

        // #034 Nidoking
        Pokemon nidoking = new Pokemon(34, "Nidoking", 32, Type.POISON, 81, 102, 77, 85,
                SPRITE_URL.formatted(34));
        nidoking.addMove(new Move("Tackle", 40, Type.NORMAL));
        nidoking.addMove(new Move("Acid", 40, Type.POISON));
        nidoking.addMove(new Move("Poison Gas", 0, Type.POISON));
        nidoking.addMove(new Move("Sludge Bomb", 90, Type.POISON));
        pokemonDatabase.put(34, nidoking);

        // #035 Clefairy
        Pokemon clefairy = new Pokemon(35, "Clefairy", 10, Type.FAIRY, 70, 45, 48, 35,
                SPRITE_URL.formatted(35));
        clefairy.addMove(new Move("Pound", 40, Type.NORMAL));
        clefairy.addMove(new Move("Disarming Voice", 40, Type.FAIRY));
        clefairy.addMove(new Move("Sing", 0, Type.NORMAL));
        clefairy.addMove(new Move("Moonblast", 95, Type.FAIRY));
        pokemonDatabase.put(35, clefairy);

        // #036 Clefable
        Pokemon clefable = new Pokemon(36, "Clefable", 30, Type.FAIRY, 95, 70, 73, 60,
                SPRITE_URL.formatted(36));
        clefable.addMove(new Move("Pound", 40, Type.NORMAL));
        clefable.addMove(new Move("Disarming Voice", 40, Type.FAIRY));
        clefable.addMove(new Move("Sing", 0, Type.NORMAL));
        clefable.addMove(new Move("Moonblast", 95, Type.FAIRY));
        pokemonDatabase.put(36, clefable);

        // #037 Vulpix
        Pokemon vulpix = new Pokemon(37, "Vulpix", 8, Type.FIRE, 38, 41, 40, 65,
                SPRITE_URL.formatted(37));
        vulpix.addMove(new Move("Scratch", 40, Type.NORMAL));
        vulpix.addMove(new Move("Ember", 40, Type.FIRE));
        vulpix.addMove(new Move("Smokescreen", 0, Type.NORMAL));
        vulpix.addMove(new Move("Flamethrower", 90, Type.FIRE));
        pokemonDatabase.put(37, vulpix);

        // #038 Ninetales
        Pokemon ninetales = new Pokemon(38, "Ninetales", 30, Type.FIRE, 73, 76, 75, 100,
                SPRITE_URL.formatted(38));
        ninetales.addMove(new Move("Scratch", 40, Type.NORMAL));
        ninetales.addMove(new Move("Ember", 40, Type.FIRE));
        ninetales.addMove(new Move("Smokescreen", 0, Type.NORMAL));
        ninetales.addMove(new Move("Flamethrower", 90, Type.FIRE));
        pokemonDatabase.put(38, ninetales);

        // #039 Jigglypuff
        Pokemon jigglypuff = new Pokemon(39, "Jigglypuff", 10, Type.NORMAL, 115, 45, 20, 20,
                SPRITE_URL.formatted(39));
        jigglypuff.addMove(new Move("Tackle", 40, Type.NORMAL));
        jigglypuff.addMove(new Move("Quick Attack", 40, Type.NORMAL));
        jigglypuff.addMove(new Move("Bite", 60, Type.DARK));
        jigglypuff.addMove(new Move("Body Slam", 85, Type.NORMAL));
        pokemonDatabase.put(39, jigglypuff);

        // #040 Wigglytuff
        Pokemon wigglytuff = new Pokemon(40, "Wigglytuff", 30, Type.NORMAL, 140, 70, 45, 45,
                SPRITE_URL.formatted(40));
        wigglytuff.addMove(new Move("Tackle", 40, Type.NORMAL));
        wigglytuff.addMove(new Move("Quick Attack", 40, Type.NORMAL));
        wigglytuff.addMove(new Move("Bite", 60, Type.DARK));
        wigglytuff.addMove(new Move("Body Slam", 85, Type.NORMAL));
        pokemonDatabase.put(40, wigglytuff);

        // #041 Zubat
        Pokemon zubat = new Pokemon(41, "Zubat", 4, Type.POISON, 40, 45, 35, 55,
                SPRITE_URL.formatted(41));
        zubat.addMove(new Move("Tackle", 40, Type.NORMAL));
        zubat.addMove(new Move("Acid", 40, Type.POISON));
        zubat.addMove(new Move("Poison Gas", 0, Type.POISON));
        zubat.addMove(new Move("Sludge Bomb", 90, Type.POISON));
        pokemonDatabase.put(41, zubat);

        // #042 Golbat
        Pokemon golbat = new Pokemon(42, "Golbat", 22, Type.POISON, 75, 80, 70, 90,
                SPRITE_URL.formatted(42));
        golbat.addMove(new Move("Tackle", 40, Type.NORMAL));
        golbat.addMove(new Move("Acid", 40, Type.POISON));
        golbat.addMove(new Move("Poison Gas", 0, Type.POISON));
        golbat.addMove(new Move("Sludge Bomb", 90, Type.POISON));
        pokemonDatabase.put(42, golbat);

        // #043 Oddish
        Pokemon oddish = new Pokemon(43, "Oddish", 7, Type.GRASS, 45, 50, 55, 30,
                SPRITE_URL.formatted(43));
        oddish.addMove(new Move("Tackle", 40, Type.NORMAL));
        oddish.addMove(new Move("Vine Whip", 45, Type.GRASS));
        oddish.addMove(new Move("Growth", 0, Type.NORMAL));
        oddish.addMove(new Move("Razor Leaf", 55, Type.GRASS));
        pokemonDatabase.put(43, oddish);

        // #044 Gloom
        Pokemon gloom = new Pokemon(44, "Gloom", 16, Type.GRASS, 60, 65, 70, 40,
                SPRITE_URL.formatted(44));
        gloom.addMove(new Move("Tackle", 40, Type.NORMAL));
        gloom.addMove(new Move("Vine Whip", 45, Type.GRASS));
        gloom.addMove(new Move("Growth", 0, Type.NORMAL));
        gloom.addMove(new Move("Razor Leaf", 55, Type.GRASS));
        pokemonDatabase.put(44, gloom);

        // #045 Vileplume
        Pokemon vileplume = new Pokemon(45, "Vileplume", 32, Type.GRASS, 75, 80, 85, 50,
                SPRITE_URL.formatted(45));
        vileplume.addMove(new Move("Tackle", 40, Type.NORMAL));
        vileplume.addMove(new Move("Vine Whip", 45, Type.GRASS));
        vileplume.addMove(new Move("Growth", 0, Type.NORMAL));
        vileplume.addMove(new Move("Razor Leaf", 55, Type.GRASS));
        pokemonDatabase.put(45, vileplume);

        // #046 Paras
        Pokemon paras = new Pokemon(46, "Paras", 9, Type.BUG, 35, 70, 55, 25,
                SPRITE_URL.formatted(46));
        paras.addMove(new Move("Tackle", 40, Type.NORMAL));
        paras.addMove(new Move("Bug Bite", 60, Type.BUG));
        paras.addMove(new Move("String Shot", 0, Type.BUG));
        paras.addMove(new Move("X-Scissor", 80, Type.BUG));
        pokemonDatabase.put(46, paras);

        // #047 Parasect
        Pokemon parasect = new Pokemon(47, "Parasect", 24, Type.BUG, 60, 95, 80, 30,
                SPRITE_URL.formatted(47));
        parasect.addMove(new Move("Tackle", 40, Type.NORMAL));
        parasect.addMove(new Move("Bug Bite", 60, Type.BUG));
        parasect.addMove(new Move("String Shot", 0, Type.BUG));
        parasect.addMove(new Move("X-Scissor", 80, Type.BUG));
        pokemonDatabase.put(47, parasect);

        // #048 Venonat
        Pokemon venonat = new Pokemon(48, "Venonat", 9, Type.BUG, 60, 55, 50, 45,
                SPRITE_URL.formatted(48));
        venonat.addMove(new Move("Tackle", 40, Type.NORMAL));
        venonat.addMove(new Move("Bug Bite", 60, Type.BUG));
        venonat.addMove(new Move("String Shot", 0, Type.BUG));
        venonat.addMove(new Move("X-Scissor", 80, Type.BUG));
        pokemonDatabase.put(48, venonat);

        // #049 Venomoth
        Pokemon venomoth = new Pokemon(49, "Venomoth", 31, Type.BUG, 70, 65, 60, 90,
                SPRITE_URL.formatted(49));
        venomoth.addMove(new Move("Tackle", 40, Type.NORMAL));
        venomoth.addMove(new Move("Bug Bite", 60, Type.BUG));
        venomoth.addMove(new Move("String Shot", 0, Type.BUG));
        venomoth.addMove(new Move("X-Scissor", 80, Type.BUG));
        pokemonDatabase.put(49, venomoth);

        // #050 Diglett
        Pokemon diglett = new Pokemon(50, "Diglett", 6, Type.GROUND, 26, 55, 25, 95,
                SPRITE_URL.formatted(50));
        diglett.addMove(new Move("Scratch", 40, Type.NORMAL));
        diglett.addMove(new Move("Mud-Slap", 20, Type.GROUND));
        diglett.addMove(new Move("Sand Attack", 0, Type.GROUND));
        diglett.addMove(new Move("Earthquake", 100, Type.GROUND));
        pokemonDatabase.put(50, diglett);

        // #051 Dugtrio
        Pokemon dugtrio = new Pokemon(51, "Dugtrio", 26, Type.GROUND, 35, 100, 50, 120,
                SPRITE_URL.formatted(51));
        dugtrio.addMove(new Move("Scratch", 40, Type.NORMAL));
        dugtrio.addMove(new Move("Mud-Slap", 20, Type.GROUND));
        dugtrio.addMove(new Move("Sand Attack", 0, Type.GROUND));
        dugtrio.addMove(new Move("Earthquake", 100, Type.GROUND));
        pokemonDatabase.put(51, dugtrio);

        // #052 Meowth
        Pokemon meowth = new Pokemon(52, "Meowth", 6, Type.NORMAL, 40, 45, 35, 90,
                SPRITE_URL.formatted(52));
        meowth.addMove(new Move("Tackle", 40, Type.NORMAL));
        meowth.addMove(new Move("Quick Attack", 40, Type.NORMAL));
        meowth.addMove(new Move("Bite", 60, Type.DARK));
        meowth.addMove(new Move("Body Slam", 85, Type.NORMAL));
        pokemonDatabase.put(52, meowth);

        // #053 Persian
        Pokemon persian = new Pokemon(53, "Persian", 28, Type.NORMAL, 65, 70, 60, 115,
                SPRITE_URL.formatted(53));
        persian.addMove(new Move("Tackle", 40, Type.NORMAL));
        persian.addMove(new Move("Quick Attack", 40, Type.NORMAL));
        persian.addMove(new Move("Bite", 60, Type.DARK));
        persian.addMove(new Move("Body Slam", 85, Type.NORMAL));
        pokemonDatabase.put(53, persian);

        // #054 Psyduck
        Pokemon psyduck = new Pokemon(54, "Psyduck", 9, Type.WATER, 50, 52, 48, 55,
                SPRITE_URL.formatted(54));
        psyduck.addMove(new Move("Tackle", 40, Type.NORMAL));
        psyduck.addMove(new Move("Water Gun", 40, Type.WATER));
        psyduck.addMove(new Move("Tail Whip", 0, Type.NORMAL));
        psyduck.addMove(new Move("Hydro Pump", 110, Type.WATER));
        pokemonDatabase.put(54, psyduck);

        // #055 Golduck
        Pokemon golduck = new Pokemon(55, "Golduck", 30, Type.WATER, 80, 82, 78, 85,
                SPRITE_URL.formatted(55));
        golduck.addMove(new Move("Tackle", 40, Type.NORMAL));
        golduck.addMove(new Move("Water Gun", 40, Type.WATER));
        golduck.addMove(new Move("Tail Whip", 0, Type.NORMAL));
        golduck.addMove(new Move("Hydro Pump", 110, Type.WATER));
        pokemonDatabase.put(55, golduck);

        // #056 Mankey
        Pokemon mankey = new Pokemon(56, "Mankey", 8, Type.FIGHTING, 40, 80, 35, 70,
                SPRITE_URL.formatted(56));
        mankey.addMove(new Move("Scratch", 40, Type.NORMAL));
        mankey.addMove(new Move("Karate Chop", 50, Type.FIGHTING));
        mankey.addMove(new Move("Focus Energy", 0, Type.NORMAL));
        mankey.addMove(new Move("Brick Break", 75, Type.FIGHTING));
        pokemonDatabase.put(56, mankey);

        // #057 Primeape
        Pokemon primeape = new Pokemon(57, "Primeape", 28, Type.FIGHTING, 65, 105, 60, 95,
                SPRITE_URL.formatted(57));
        primeape.addMove(new Move("Scratch", 40, Type.NORMAL));
        primeape.addMove(new Move("Karate Chop", 50, Type.FIGHTING));
        primeape.addMove(new Move("Focus Energy", 0, Type.NORMAL));
        primeape.addMove(new Move("Brick Break", 75, Type.FIGHTING));
        pokemonDatabase.put(57, primeape);

        // #058 Growlithe
        Pokemon growlithe = new Pokemon(58, "Growlithe", 9, Type.FIRE, 55, 70, 45, 60,
                SPRITE_URL.formatted(58));
        growlithe.addMove(new Move("Scratch", 40, Type.NORMAL));
        growlithe.addMove(new Move("Ember", 40, Type.FIRE));
        growlithe.addMove(new Move("Smokescreen", 0, Type.NORMAL));
        growlithe.addMove(new Move("Flamethrower", 90, Type.FIRE));
        pokemonDatabase.put(58, growlithe);

        // #059 Arcanine
        Pokemon arcanine = new Pokemon(59, "Arcanine", 34, Type.FIRE, 90, 110, 80, 95,
                SPRITE_URL.formatted(59));
        arcanine.addMove(new Move("Scratch", 40, Type.NORMAL));
        arcanine.addMove(new Move("Ember", 40, Type.FIRE));
        arcanine.addMove(new Move("Smokescreen", 0, Type.NORMAL));
        arcanine.addMove(new Move("Flamethrower", 90, Type.FIRE));
        pokemonDatabase.put(59, arcanine);

        // #060 Poliwag
        Pokemon poliwag = new Pokemon(60, "Poliwag", 6, Type.WATER, 40, 50, 40, 90,
                SPRITE_URL.formatted(60));
        poliwag.addMove(new Move("Tackle", 40, Type.NORMAL));
        poliwag.addMove(new Move("Water Gun", 40, Type.WATER));
        poliwag.addMove(new Move("Tail Whip", 0, Type.NORMAL));
        poliwag.addMove(new Move("Hydro Pump", 110, Type.WATER));
        pokemonDatabase.put(60, poliwag);

        // #061 Poliwhirl
        Pokemon poliwhirl = new Pokemon(61, "Poliwhirl", 25, Type.WATER, 65, 65, 65, 90,
                SPRITE_URL.formatted(61));
        poliwhirl.addMove(new Move("Tackle", 40, Type.NORMAL));
        poliwhirl.addMove(new Move("Water Gun", 40, Type.WATER));
        poliwhirl.addMove(new Move("Tail Whip", 0, Type.NORMAL));
        poliwhirl.addMove(new Move("Hydro Pump", 110, Type.WATER));
        pokemonDatabase.put(61, poliwhirl);

        // #062 Poliwrath
        Pokemon poliwrath = new Pokemon(62, "Poliwrath", 41, Type.WATER, 90, 95, 95, 70,
                SPRITE_URL.formatted(62));
        poliwrath.addMove(new Move("Tackle", 40, Type.NORMAL));
        poliwrath.addMove(new Move("Water Gun", 40, Type.WATER));
        poliwrath.addMove(new Move("Tail Whip", 0, Type.NORMAL));
        poliwrath.addMove(new Move("Hydro Pump", 110, Type.WATER));
        pokemonDatabase.put(62, poliwrath);

        // #063 Abra
        Pokemon abra = new Pokemon(63, "Abra", 5, Type.PSYCHIC, 25, 20, 15, 90,
                SPRITE_URL.formatted(63));
        abra.addMove(new Move("Teleport", 0, Type.PSYCHIC));
        abra.addMove(new Move("Confusion", 50, Type.PSYCHIC));
        abra.addMove(new Move("Reflect", 0, Type.PSYCHIC));
        abra.addMove(new Move("Psychic", 90, Type.PSYCHIC));
        pokemonDatabase.put(63, abra);

        // #064 Kadabra
        Pokemon kadabra = new Pokemon(64, "Kadabra", 16, Type.PSYCHIC, 40, 35, 30, 105,
                SPRITE_URL.formatted(64));
        kadabra.addMove(new Move("Pound", 40, Type.NORMAL));
        kadabra.addMove(new Move("Confusion", 50, Type.PSYCHIC));
        kadabra.addMove(new Move("Calm Mind", 0, Type.PSYCHIC));
        kadabra.addMove(new Move("Psychic", 90, Type.PSYCHIC));
        pokemonDatabase.put(64, kadabra);

        // #065 Alakazam
        Pokemon alakazam = new Pokemon(65, "Alakazam", 36, Type.PSYCHIC, 55, 50, 45, 120,
                SPRITE_URL.formatted(65));
        alakazam.addMove(new Move("Pound", 40, Type.NORMAL));
        alakazam.addMove(new Move("Confusion", 50, Type.PSYCHIC));
        alakazam.addMove(new Move("Calm Mind", 0, Type.PSYCHIC));
        alakazam.addMove(new Move("Psychic", 90, Type.PSYCHIC));
        pokemonDatabase.put(65, alakazam);

        // #066 Machop
        Pokemon machop = new Pokemon(66, "Machop", 8, Type.FIGHTING, 70, 80, 50, 35,
                SPRITE_URL.formatted(66));
        machop.addMove(new Move("Scratch", 40, Type.NORMAL));
        machop.addMove(new Move("Karate Chop", 50, Type.FIGHTING));
        machop.addMove(new Move("Focus Energy", 0, Type.NORMAL));
        machop.addMove(new Move("Brick Break", 75, Type.FIGHTING));
        pokemonDatabase.put(66, machop);

        // #067 Machoke
        Pokemon machoke = new Pokemon(67, "Machoke", 28, Type.FIGHTING, 80, 100, 70, 45,
                SPRITE_URL.formatted(67));
        machoke.addMove(new Move("Scratch", 40, Type.NORMAL));
        machoke.addMove(new Move("Karate Chop", 50, Type.FIGHTING));
        machoke.addMove(new Move("Focus Energy", 0, Type.NORMAL));
        machoke.addMove(new Move("Brick Break", 75, Type.FIGHTING));
        pokemonDatabase.put(67, machoke);

        // #068 Machamp
        Pokemon machamp = new Pokemon(68, "Machamp", 43, Type.FIGHTING, 90, 130, 80, 55,
                SPRITE_URL.formatted(68));
        machamp.addMove(new Move("Scratch", 40, Type.NORMAL));
        machamp.addMove(new Move("Karate Chop", 50, Type.FIGHTING));
        machamp.addMove(new Move("Focus Energy", 0, Type.NORMAL));
        machamp.addMove(new Move("Brick Break", 75, Type.FIGHTING));
        pokemonDatabase.put(68, machamp);

        // #069 Bellsprout
        Pokemon bellsprout = new Pokemon(69, "Bellsprout", 7, Type.GRASS, 50, 75, 35, 40,
                SPRITE_URL.formatted(69));
        bellsprout.addMove(new Move("Tackle", 40, Type.NORMAL));
        bellsprout.addMove(new Move("Vine Whip", 45, Type.GRASS));
        bellsprout.addMove(new Move("Growth", 0, Type.NORMAL));
        bellsprout.addMove(new Move("Razor Leaf", 55, Type.GRASS));
        pokemonDatabase.put(69, bellsprout);

        // #070 Weepinbell
        Pokemon weepinbell = new Pokemon(70, "Weepinbell", 21, Type.GRASS, 65, 90, 50, 55,
                SPRITE_URL.formatted(70));
        weepinbell.addMove(new Move("Tackle", 40, Type.NORMAL));
        weepinbell.addMove(new Move("Vine Whip", 45, Type.GRASS));
        weepinbell.addMove(new Move("Growth", 0, Type.NORMAL));
        weepinbell.addMove(new Move("Razor Leaf", 55, Type.GRASS));
        pokemonDatabase.put(70, weepinbell);

        // #071 Victreebel
        Pokemon victreebel = new Pokemon(71, "Victreebel", 40, Type.GRASS, 80, 105, 65, 70,
                SPRITE_URL.formatted(71));
        victreebel.addMove(new Move("Tackle", 40, Type.NORMAL));
        victreebel.addMove(new Move("Vine Whip", 45, Type.GRASS));
        victreebel.addMove(new Move("Growth", 0, Type.NORMAL));
        victreebel.addMove(new Move("Razor Leaf", 55, Type.GRASS));
        pokemonDatabase.put(71, victreebel);

        // #072 Tentacool
        Pokemon tentacool = new Pokemon(72, "Tentacool", 5, Type.WATER, 40, 40, 35, 70,
                SPRITE_URL.formatted(72));
        tentacool.addMove(new Move("Tackle", 40, Type.NORMAL));
        tentacool.addMove(new Move("Water Gun", 40, Type.WATER));
        tentacool.addMove(new Move("Tail Whip", 0, Type.NORMAL));
        tentacool.addMove(new Move("Hydro Pump", 110, Type.WATER));
        pokemonDatabase.put(72, tentacool);

        // #073 Tentacruel
        Pokemon tentacruel = new Pokemon(73, "Tentacruel", 30, Type.WATER, 80, 70, 65, 100,
                SPRITE_URL.formatted(73));
        tentacruel.addMove(new Move("Tackle", 40, Type.NORMAL));
        tentacruel.addMove(new Move("Water Gun", 40, Type.WATER));
        tentacruel.addMove(new Move("Tail Whip", 0, Type.NORMAL));
        tentacruel.addMove(new Move("Hydro Pump", 110, Type.WATER));
        pokemonDatabase.put(73, tentacruel);

        // #074 Geodude
        Pokemon geodude = new Pokemon(74, "Geodude", 7, Type.ROCK, 40, 80, 100, 20,
                SPRITE_URL.formatted(74));
        geodude.addMove(new Move("Tackle", 40, Type.NORMAL));
        geodude.addMove(new Move("Rock Throw", 50, Type.ROCK));
        geodude.addMove(new Move("Harden", 0, Type.NORMAL));
        geodude.addMove(new Move("Rock Slide", 75, Type.ROCK));
        pokemonDatabase.put(74, geodude);

        // #075 Graveler
        Pokemon graveler = new Pokemon(75, "Graveler", 25, Type.ROCK, 55, 95, 115, 35,
                SPRITE_URL.formatted(75));
        graveler.addMove(new Move("Tackle", 40, Type.NORMAL));
        graveler.addMove(new Move("Rock Throw", 50, Type.ROCK));
        graveler.addMove(new Move("Harden", 0, Type.NORMAL));
        graveler.addMove(new Move("Rock Slide", 75, Type.ROCK));
        pokemonDatabase.put(75, graveler);

        // #076 Golem
        Pokemon golem = new Pokemon(76, "Golem", 40, Type.ROCK, 80, 120, 130, 45,
                SPRITE_URL.formatted(76));
        golem.addMove(new Move("Tackle", 40, Type.NORMAL));
        golem.addMove(new Move("Rock Throw", 50, Type.ROCK));
        golem.addMove(new Move("Harden", 0, Type.NORMAL));
        golem.addMove(new Move("Rock Slide", 75, Type.ROCK));
        pokemonDatabase.put(76, golem);

        // #077 Ponyta
        Pokemon ponyta = new Pokemon(77, "Ponyta", 8, Type.FIRE, 50, 85, 55, 90,
                SPRITE_URL.formatted(77));
        ponyta.addMove(new Move("Scratch", 40, Type.NORMAL));
        ponyta.addMove(new Move("Ember", 40, Type.FIRE));
        ponyta.addMove(new Move("Smokescreen", 0, Type.NORMAL));
        ponyta.addMove(new Move("Flamethrower", 90, Type.FIRE));
        pokemonDatabase.put(77, ponyta);

        // #078 Rapidash
        Pokemon rapidash = new Pokemon(78, "Rapidash", 40, Type.FIRE, 65, 100, 70, 105,
                SPRITE_URL.formatted(78));
        rapidash.addMove(new Move("Scratch", 40, Type.NORMAL));
        rapidash.addMove(new Move("Ember", 40, Type.FIRE));
        rapidash.addMove(new Move("Smokescreen", 0, Type.NORMAL));
        rapidash.addMove(new Move("Flamethrower", 90, Type.FIRE));
        pokemonDatabase.put(78, rapidash);

        // #079 Slowpoke
        Pokemon slowpoke = new Pokemon(79, "Slowpoke", 10, Type.WATER, 90, 65, 65, 15,
                SPRITE_URL.formatted(79));
        slowpoke.addMove(new Move("Tackle", 40, Type.NORMAL));
        slowpoke.addMove(new Move("Water Gun", 40, Type.WATER));
        slowpoke.addMove(new Move("Tail Whip", 0, Type.NORMAL));
        slowpoke.addMove(new Move("Hydro Pump", 110, Type.WATER));
        pokemonDatabase.put(79, slowpoke);

        // #080 Slowbro
        Pokemon slowbro = new Pokemon(80, "Slowbro", 37, Type.WATER, 95, 75, 110, 30,
                SPRITE_URL.formatted(80));
        slowbro.addMove(new Move("Tackle", 40, Type.NORMAL));
        slowbro.addMove(new Move("Water Gun", 40, Type.WATER));
        slowbro.addMove(new Move("Tail Whip", 0, Type.NORMAL));
        slowbro.addMove(new Move("Hydro Pump", 110, Type.WATER));
        pokemonDatabase.put(80, slowbro);

        // #081 Magnemite
        Pokemon magnemite = new Pokemon(81, "Magnemite", 6, Type.ELECTRIC, 25, 35, 70, 45,
                SPRITE_URL.formatted(81));
        magnemite.addMove(new Move("Quick Attack", 40, Type.NORMAL));
        magnemite.addMove(new Move("Thunder Shock", 40, Type.ELECTRIC));
        magnemite.addMove(new Move("Thunder Wave", 0, Type.ELECTRIC));
        magnemite.addMove(new Move("Thunderbolt", 90, Type.ELECTRIC));
        pokemonDatabase.put(81, magnemite);

        // #082 Magneton
        Pokemon magneton = new Pokemon(82, "Magneton", 30, Type.ELECTRIC, 50, 60, 95, 70,
                SPRITE_URL.formatted(82));
        magneton.addMove(new Move("Quick Attack", 40, Type.NORMAL));
        magneton.addMove(new Move("Thunder Shock", 40, Type.ELECTRIC));
        magneton.addMove(new Move("Thunder Wave", 0, Type.ELECTRIC));
        magneton.addMove(new Move("Thunderbolt", 90, Type.ELECTRIC));
        pokemonDatabase.put(82, magneton);

        // #083 Farfetch'd
        Pokemon farfetchd = new Pokemon(83, "Farfetch'd", 15, Type.NORMAL, 52, 90, 55, 60,
                SPRITE_URL.formatted(83));
        farfetchd.addMove(new Move("Tackle", 40, Type.NORMAL));
        farfetchd.addMove(new Move("Quick Attack", 40, Type.NORMAL));
        farfetchd.addMove(new Move("Bite", 60, Type.DARK));
        farfetchd.addMove(new Move("Body Slam", 85, Type.NORMAL));
        pokemonDatabase.put(83, farfetchd);

        // #084 Doduo
        Pokemon doduo = new Pokemon(84, "Doduo", 7, Type.NORMAL, 35, 85, 45, 75,
                SPRITE_URL.formatted(84));
        doduo.addMove(new Move("Tackle", 40, Type.NORMAL));
        doduo.addMove(new Move("Quick Attack", 40, Type.NORMAL));
        doduo.addMove(new Move("Bite", 60, Type.DARK));
        doduo.addMove(new Move("Body Slam", 85, Type.NORMAL));
        pokemonDatabase.put(84, doduo);

        // #085 Dodrio
        Pokemon dodrio = new Pokemon(85, "Dodrio", 34, Type.NORMAL, 60, 110, 70, 110,
                SPRITE_URL.formatted(85));
        dodrio.addMove(new Move("Tackle", 40, Type.NORMAL));
        dodrio.addMove(new Move("Quick Attack", 40, Type.NORMAL));
        dodrio.addMove(new Move("Bite", 60, Type.DARK));
        dodrio.addMove(new Move("Body Slam", 85, Type.NORMAL));
        pokemonDatabase.put(85, dodrio);

        // #086 Seel
        Pokemon seel = new Pokemon(86, "Seel", 9, Type.WATER, 65, 45, 55, 45,
                SPRITE_URL.formatted(86));
        seel.addMove(new Move("Tackle", 40, Type.NORMAL));
        seel.addMove(new Move("Water Gun", 40, Type.WATER));
        seel.addMove(new Move("Tail Whip", 0, Type.NORMAL));
        seel.addMove(new Move("Hydro Pump", 110, Type.WATER));
        pokemonDatabase.put(86, seel);

        // #087 Dewgong
        Pokemon dewgong = new Pokemon(87, "Dewgong", 34, Type.WATER, 90, 70, 80, 70,
                SPRITE_URL.formatted(87));
        dewgong.addMove(new Move("Tackle", 40, Type.NORMAL));
        dewgong.addMove(new Move("Water Gun", 40, Type.WATER));
        dewgong.addMove(new Move("Tail Whip", 0, Type.NORMAL));
        dewgong.addMove(new Move("Hydro Pump", 110, Type.WATER));
        pokemonDatabase.put(87, dewgong);

        // #088 Grimer
        Pokemon grimer = new Pokemon(88, "Grimer", 8, Type.POISON, 80, 80, 50, 25,
                SPRITE_URL.formatted(88));
        grimer.addMove(new Move("Tackle", 40, Type.NORMAL));
        grimer.addMove(new Move("Acid", 40, Type.POISON));
        grimer.addMove(new Move("Poison Gas", 0, Type.POISON));
        grimer.addMove(new Move("Sludge Bomb", 90, Type.POISON));
        pokemonDatabase.put(88, grimer);

        // #089 Muk
        Pokemon muk = new Pokemon(89, "Muk", 30, Type.POISON, 105, 105, 75, 50,
                SPRITE_URL.formatted(89));
        muk.addMove(new Move("Tackle", 40, Type.NORMAL));
        muk.addMove(new Move("Acid", 40, Type.POISON));
        muk.addMove(new Move("Poison Gas", 0, Type.POISON));
        muk.addMove(new Move("Sludge Bomb", 90, Type.POISON));
        pokemonDatabase.put(89, muk);

        // #090 Shellder
        Pokemon shellder = new Pokemon(90, "Shellder", 7, Type.WATER, 30, 65, 100, 40,
                SPRITE_URL.formatted(90));
        shellder.addMove(new Move("Tackle", 40, Type.NORMAL));
        shellder.addMove(new Move("Water Gun", 40, Type.WATER));
        shellder.addMove(new Move("Tail Whip", 0, Type.NORMAL));
        shellder.addMove(new Move("Hydro Pump", 110, Type.WATER));
        pokemonDatabase.put(90, shellder);

        // #091 Cloyster
        Pokemon cloyster = new Pokemon(91, "Cloyster", 30, Type.WATER, 50, 95, 180, 70,
                SPRITE_URL.formatted(91));
        cloyster.addMove(new Move("Tackle", 40, Type.NORMAL));
        cloyster.addMove(new Move("Water Gun", 40, Type.WATER));
        cloyster.addMove(new Move("Tail Whip", 0, Type.NORMAL));
        cloyster.addMove(new Move("Hydro Pump", 110, Type.WATER));
        pokemonDatabase.put(91, cloyster);

        // #092 Gastly
        Pokemon gastly = new Pokemon(92, "Gastly", 5, Type.GHOST, 30, 35, 30, 80,
                SPRITE_URL.formatted(92));
        gastly.addMove(new Move("Lick", 30, Type.GHOST));
        gastly.addMove(new Move("Confuse Ray", 0, Type.GHOST));
        gastly.addMove(new Move("Hypnosis", 0, Type.PSYCHIC));
        gastly.addMove(new Move("Shadow Ball", 80, Type.GHOST));
        pokemonDatabase.put(92, gastly);

        // #093 Haunter
        Pokemon haunter = new Pokemon(93, "Haunter", 25, Type.GHOST, 45, 50, 45, 95,
                SPRITE_URL.formatted(93));
        haunter.addMove(new Move("Lick", 30, Type.GHOST));
        haunter.addMove(new Move("Confuse Ray", 0, Type.GHOST));
        haunter.addMove(new Move("Hypnosis", 0, Type.PSYCHIC));
        haunter.addMove(new Move("Shadow Ball", 80, Type.GHOST));
        pokemonDatabase.put(93, haunter);

        // #094 Gengar
        Pokemon gengar = new Pokemon(94, "Gengar", 42, Type.GHOST, 60, 65, 60, 110,
                SPRITE_URL.formatted(94));
        gengar.addMove(new Move("Lick", 30, Type.GHOST));
        gengar.addMove(new Move("Confuse Ray", 0, Type.GHOST));
        gengar.addMove(new Move("Hypnosis", 0, Type.PSYCHIC));
        gengar.addMove(new Move("Shadow Ball", 80, Type.GHOST));
        pokemonDatabase.put(94, gengar);

        // #095 Onix
        Pokemon onix = new Pokemon(95, "Onix", 14, Type.ROCK, 35, 45, 160, 70,
                SPRITE_URL.formatted(95));
        onix.addMove(new Move("Tackle", 40, Type.NORMAL));
        onix.addMove(new Move("Rock Throw", 50, Type.ROCK));
        onix.addMove(new Move("Harden", 0, Type.NORMAL));
        onix.addMove(new Move("Rock Slide", 75, Type.ROCK));
        pokemonDatabase.put(95, onix);

        // #096 Drowzee
        Pokemon drowzee = new Pokemon(96, "Drowzee", 12, Type.PSYCHIC, 60, 48, 45, 42,
                SPRITE_URL.formatted(96));
        drowzee.addMove(new Move("Pound", 40, Type.NORMAL));
        drowzee.addMove(new Move("Confusion", 50, Type.PSYCHIC));
        drowzee.addMove(new Move("Calm Mind", 0, Type.PSYCHIC));
        drowzee.addMove(new Move("Psychic", 90, Type.PSYCHIC));
        pokemonDatabase.put(96, drowzee);

        // #097 Hypno
        Pokemon hypno = new Pokemon(97, "Hypno", 26, Type.PSYCHIC, 85, 73, 70, 67,
                SPRITE_URL.formatted(97));
        hypno.addMove(new Move("Pound", 40, Type.NORMAL));
        hypno.addMove(new Move("Confusion", 50, Type.PSYCHIC));
        hypno.addMove(new Move("Calm Mind", 0, Type.PSYCHIC));
        hypno.addMove(new Move("Psychic", 90, Type.PSYCHIC));
        pokemonDatabase.put(97, hypno);

        // #098 Krabby
        Pokemon krabby = new Pokemon(98, "Krabby", 8, Type.WATER, 30, 105, 90, 50,
                SPRITE_URL.formatted(98));
        krabby.addMove(new Move("Tackle", 40, Type.NORMAL));
        krabby.addMove(new Move("Water Gun", 40, Type.WATER));
        krabby.addMove(new Move("Tail Whip", 0, Type.NORMAL));
        krabby.addMove(new Move("Hydro Pump", 110, Type.WATER));
        pokemonDatabase.put(98, krabby);

        // #099 Kingler
        Pokemon kingler = new Pokemon(99, "Kingler", 30, Type.WATER, 55, 130, 115, 75,
                SPRITE_URL.formatted(99));
        kingler.addMove(new Move("Tackle", 40, Type.NORMAL));
        kingler.addMove(new Move("Water Gun", 40, Type.WATER));
        kingler.addMove(new Move("Tail Whip", 0, Type.NORMAL));
        kingler.addMove(new Move("Hydro Pump", 110, Type.WATER));
        pokemonDatabase.put(99, kingler);

        // #100 Voltorb
        Pokemon voltorb = new Pokemon(100, "Voltorb", 6, Type.ELECTRIC, 40, 30, 50, 100,
                SPRITE_URL.formatted(100));
        voltorb.addMove(new Move("Quick Attack", 40, Type.NORMAL));
        voltorb.addMove(new Move("Thunder Shock", 40, Type.ELECTRIC));
        voltorb.addMove(new Move("Thunder Wave", 0, Type.ELECTRIC));
        voltorb.addMove(new Move("Thunderbolt", 90, Type.ELECTRIC));
        pokemonDatabase.put(100, voltorb);

        // #101 Electrode
        Pokemon electrode = new Pokemon(101, "Electrode", 30, Type.ELECTRIC, 60, 50, 70, 150,
                SPRITE_URL.formatted(101));
        electrode.addMove(new Move("Quick Attack", 40, Type.NORMAL));
        electrode.addMove(new Move("Thunder Shock", 40, Type.ELECTRIC));
        electrode.addMove(new Move("Thunder Wave", 0, Type.ELECTRIC));
        electrode.addMove(new Move("Thunderbolt", 90, Type.ELECTRIC));
        pokemonDatabase.put(101, electrode);

        // #102 Exeggcute
        Pokemon exeggcute = new Pokemon(102, "Exeggcute", 9, Type.GRASS, 60, 40, 80, 40,
                SPRITE_URL.formatted(102));
        exeggcute.addMove(new Move("Tackle", 40, Type.NORMAL));
        exeggcute.addMove(new Move("Vine Whip", 45, Type.GRASS));
        exeggcute.addMove(new Move("Growth", 0, Type.NORMAL));
        exeggcute.addMove(new Move("Razor Leaf", 55, Type.GRASS));
        pokemonDatabase.put(102, exeggcute);

        // #103 Exeggutor
        Pokemon exeggutor = new Pokemon(103, "Exeggutor", 32, Type.GRASS, 95, 95, 85, 55,
                SPRITE_URL.formatted(103));
        exeggutor.addMove(new Move("Tackle", 40, Type.NORMAL));
        exeggutor.addMove(new Move("Vine Whip", 45, Type.GRASS));
        exeggutor.addMove(new Move("Growth", 0, Type.NORMAL));
        exeggutor.addMove(new Move("Razor Leaf", 55, Type.GRASS));
        pokemonDatabase.put(103, exeggutor);

        // #104 Cubone
        Pokemon cubone = new Pokemon(104, "Cubone", 8, Type.GROUND, 50, 50, 95, 35,
                SPRITE_URL.formatted(104));
        cubone.addMove(new Move("Scratch", 40, Type.NORMAL));
        cubone.addMove(new Move("Mud-Slap", 20, Type.GROUND));
        cubone.addMove(new Move("Sand Attack", 0, Type.GROUND));
        cubone.addMove(new Move("Earthquake", 100, Type.GROUND));
        pokemonDatabase.put(104, cubone);

        // #105 Marowak
        Pokemon marowak = new Pokemon(105, "Marowak", 28, Type.GROUND, 60, 80, 110, 45,
                SPRITE_URL.formatted(105));
        marowak.addMove(new Move("Scratch", 40, Type.NORMAL));
        marowak.addMove(new Move("Mud-Slap", 20, Type.GROUND));
        marowak.addMove(new Move("Sand Attack", 0, Type.GROUND));
        marowak.addMove(new Move("Earthquake", 100, Type.GROUND));
        pokemonDatabase.put(105, marowak);

        // #106 Hitmonlee
        Pokemon hitmonlee = new Pokemon(106, "Hitmonlee", 20, Type.FIGHTING, 50, 120, 53, 87,
                SPRITE_URL.formatted(106));
        hitmonlee.addMove(new Move("Scratch", 40, Type.NORMAL));
        hitmonlee.addMove(new Move("Karate Chop", 50, Type.FIGHTING));
        hitmonlee.addMove(new Move("Focus Energy", 0, Type.NORMAL));
        hitmonlee.addMove(new Move("Brick Break", 75, Type.FIGHTING));
        pokemonDatabase.put(106, hitmonlee);

        // #107 Hitmonchan
        Pokemon hitmonchan = new Pokemon(107, "Hitmonchan", 20, Type.FIGHTING, 50, 105, 79, 76,
                SPRITE_URL.formatted(107));
        hitmonchan.addMove(new Move("Scratch", 40, Type.NORMAL));
        hitmonchan.addMove(new Move("Karate Chop", 50, Type.FIGHTING));
        hitmonchan.addMove(new Move("Focus Energy", 0, Type.NORMAL));
        hitmonchan.addMove(new Move("Brick Break", 75, Type.FIGHTING));
        pokemonDatabase.put(107, hitmonchan);

        // #108 Lickitung
        Pokemon lickitung = new Pokemon(108, "Lickitung", 12, Type.NORMAL, 90, 55, 75, 30,
                SPRITE_URL.formatted(108));
        lickitung.addMove(new Move("Tackle", 40, Type.NORMAL));
        lickitung.addMove(new Move("Quick Attack", 40, Type.NORMAL));
        lickitung.addMove(new Move("Bite", 60, Type.DARK));
        lickitung.addMove(new Move("Body Slam", 85, Type.NORMAL));
        pokemonDatabase.put(108, lickitung);

        // #109 Koffing
        Pokemon koffing = new Pokemon(109, "Koffing", 8, Type.POISON, 40, 65, 95, 35,
                SPRITE_URL.formatted(109));
        koffing.addMove(new Move("Tackle", 40, Type.NORMAL));
        koffing.addMove(new Move("Acid", 40, Type.POISON));
        koffing.addMove(new Move("Poison Gas", 0, Type.POISON));
        koffing.addMove(new Move("Sludge Bomb", 90, Type.POISON));
        pokemonDatabase.put(109, koffing);

        // #110 Weezing
        Pokemon weezing = new Pokemon(110, "Weezing", 35, Type.POISON, 65, 90, 120, 60,
                SPRITE_URL.formatted(110));
        weezing.addMove(new Move("Tackle", 40, Type.NORMAL));
        weezing.addMove(new Move("Acid", 40, Type.POISON));
        weezing.addMove(new Move("Poison Gas", 0, Type.POISON));
        weezing.addMove(new Move("Sludge Bomb", 90, Type.POISON));
        pokemonDatabase.put(110, weezing);

        // #111 Rhyhorn
        Pokemon rhyhorn = new Pokemon(111, "Rhyhorn", 12, Type.GROUND, 80, 85, 95, 25,
                SPRITE_URL.formatted(111));
        rhyhorn.addMove(new Move("Scratch", 40, Type.NORMAL));
        rhyhorn.addMove(new Move("Mud-Slap", 20, Type.GROUND));
        rhyhorn.addMove(new Move("Sand Attack", 0, Type.GROUND));
        rhyhorn.addMove(new Move("Earthquake", 100, Type.GROUND));
        pokemonDatabase.put(111, rhyhorn);

        // #112 Rhydon
        Pokemon rhydon = new Pokemon(112, "Rhydon", 42, Type.GROUND, 105, 130, 120, 40,
                SPRITE_URL.formatted(112));
        rhydon.addMove(new Move("Scratch", 40, Type.NORMAL));
        rhydon.addMove(new Move("Mud-Slap", 20, Type.GROUND));
        rhydon.addMove(new Move("Sand Attack", 0, Type.GROUND));
        rhydon.addMove(new Move("Earthquake", 100, Type.GROUND));
        pokemonDatabase.put(112, rhydon);

        // #113 Chansey
        Pokemon chansey = new Pokemon(113, "Chansey", 25, Type.NORMAL, 250, 45, 66, 50,
                SPRITE_URL.formatted(113));
        chansey.addMove(new Move("Tackle", 40, Type.NORMAL));
        chansey.addMove(new Move("Quick Attack", 40, Type.NORMAL));
        chansey.addMove(new Move("Bite", 60, Type.DARK));
        chansey.addMove(new Move("Body Slam", 85, Type.NORMAL));
        pokemonDatabase.put(113, chansey);

        // #114 Tangela
        Pokemon tangela = new Pokemon(114, "Tangela", 13, Type.GRASS, 65, 55, 115, 60,
                SPRITE_URL.formatted(114));
        tangela.addMove(new Move("Tackle", 40, Type.NORMAL));
        tangela.addMove(new Move("Vine Whip", 45, Type.GRASS));
        tangela.addMove(new Move("Growth", 0, Type.NORMAL));
        tangela.addMove(new Move("Razor Leaf", 55, Type.GRASS));
        pokemonDatabase.put(114, tangela);

        // #115 Kangaskhan
        Pokemon kangaskhan = new Pokemon(115, "Kangaskhan", 20, Type.NORMAL, 105, 95, 80, 90,
                SPRITE_URL.formatted(115));
        kangaskhan.addMove(new Move("Tackle", 40, Type.NORMAL));
        kangaskhan.addMove(new Move("Quick Attack", 40, Type.NORMAL));
        kangaskhan.addMove(new Move("Bite", 60, Type.DARK));
        kangaskhan.addMove(new Move("Body Slam", 85, Type.NORMAL));
        pokemonDatabase.put(115, kangaskhan);

        // #116 Horsea
        Pokemon horsea = new Pokemon(116, "Horsea", 8, Type.WATER, 30, 40, 70, 60,
                SPRITE_URL.formatted(116));
        horsea.addMove(new Move("Tackle", 40, Type.NORMAL));
        horsea.addMove(new Move("Water Gun", 40, Type.WATER));
        horsea.addMove(new Move("Tail Whip", 0, Type.NORMAL));
        horsea.addMove(new Move("Hydro Pump", 110, Type.WATER));
        pokemonDatabase.put(116, horsea);

        // #117 Seadra
        Pokemon seadra = new Pokemon(117, "Seadra", 32, Type.WATER, 55, 65, 95, 85,
                SPRITE_URL.formatted(117));
        seadra.addMove(new Move("Tackle", 40, Type.NORMAL));
        seadra.addMove(new Move("Water Gun", 40, Type.WATER));
        seadra.addMove(new Move("Tail Whip", 0, Type.NORMAL));
        seadra.addMove(new Move("Hydro Pump", 110, Type.WATER));
        pokemonDatabase.put(117, seadra);

        // #118 Goldeen
        Pokemon goldeen = new Pokemon(118, "Goldeen", 10, Type.WATER, 45, 67, 60, 63,
                SPRITE_URL.formatted(118));
        goldeen.addMove(new Move("Tackle", 40, Type.NORMAL));
        goldeen.addMove(new Move("Water Gun", 40, Type.WATER));
        goldeen.addMove(new Move("Tail Whip", 0, Type.NORMAL));
        goldeen.addMove(new Move("Hydro Pump", 110, Type.WATER));
        pokemonDatabase.put(118, goldeen);

        // #119 Seaking
        Pokemon seaking = new Pokemon(119, "Seaking", 33, Type.WATER, 80, 92, 65, 68,
                SPRITE_URL.formatted(119));
        seaking.addMove(new Move("Tackle", 40, Type.NORMAL));
        seaking.addMove(new Move("Water Gun", 40, Type.WATER));
        seaking.addMove(new Move("Tail Whip", 0, Type.NORMAL));
        seaking.addMove(new Move("Hydro Pump", 110, Type.WATER));
        pokemonDatabase.put(119, seaking);

        // #120 Staryu
        Pokemon staryu = new Pokemon(120, "Staryu", 10, Type.WATER, 30, 45, 55, 85,
                SPRITE_URL.formatted(120));
        staryu.addMove(new Move("Tackle", 40, Type.NORMAL));
        staryu.addMove(new Move("Water Gun", 40, Type.WATER));
        staryu.addMove(new Move("Tail Whip", 0, Type.NORMAL));
        staryu.addMove(new Move("Hydro Pump", 110, Type.WATER));
        pokemonDatabase.put(120, staryu);

        // #121 Starmie
        Pokemon starmie = new Pokemon(121, "Starmie", 32, Type.WATER, 60, 75, 85, 115,
                SPRITE_URL.formatted(121));
        starmie.addMove(new Move("Tackle", 40, Type.NORMAL));
        starmie.addMove(new Move("Water Gun", 40, Type.WATER));
        starmie.addMove(new Move("Tail Whip", 0, Type.NORMAL));
        starmie.addMove(new Move("Hydro Pump", 110, Type.WATER));
        pokemonDatabase.put(121, starmie);

        // #122 Mr. Mime
        Pokemon mrmime = new Pokemon(122, "Mr. Mime", 25, Type.PSYCHIC, 40, 45, 65, 90,
                SPRITE_URL.formatted(122));
        mrmime.addMove(new Move("Pound", 40, Type.NORMAL));
        mrmime.addMove(new Move("Confusion", 50, Type.PSYCHIC));
        mrmime.addMove(new Move("Calm Mind", 0, Type.PSYCHIC));
        mrmime.addMove(new Move("Psychic", 90, Type.PSYCHIC));
        pokemonDatabase.put(122, mrmime);

        // #123 Scyther
        Pokemon scyther = new Pokemon(123, "Scyther", 20, Type.BUG, 70, 110, 80, 105,
                SPRITE_URL.formatted(123));
        scyther.addMove(new Move("Tackle", 40, Type.NORMAL));
        scyther.addMove(new Move("Bug Bite", 60, Type.BUG));
        scyther.addMove(new Move("String Shot", 0, Type.BUG));
        scyther.addMove(new Move("X-Scissor", 80, Type.BUG));
        pokemonDatabase.put(123, scyther);

        // #124 Jynx
        Pokemon jynx = new Pokemon(124, "Jynx", 30, Type.ICE, 65, 50, 35, 95,
                SPRITE_URL.formatted(124));
        jynx.addMove(new Move("Pound", 40, Type.NORMAL));
        jynx.addMove(new Move("Ice Shard", 40, Type.ICE));
        jynx.addMove(new Move("Mist", 0, Type.ICE));
        jynx.addMove(new Move("Ice Beam", 90, Type.ICE));
        pokemonDatabase.put(124, jynx);

        // #125 Electabuzz
        Pokemon electabuzz = new Pokemon(125, "Electabuzz", 29, Type.ELECTRIC, 65, 83, 57, 105,
                SPRITE_URL.formatted(125));
        electabuzz.addMove(new Move("Quick Attack", 40, Type.NORMAL));
        electabuzz.addMove(new Move("Thunder Shock", 40, Type.ELECTRIC));
        electabuzz.addMove(new Move("Thunder Wave", 0, Type.ELECTRIC));
        electabuzz.addMove(new Move("Thunderbolt", 90, Type.ELECTRIC));
        pokemonDatabase.put(125, electabuzz);

        // #126 Magmar
        Pokemon magmar = new Pokemon(126, "Magmar", 30, Type.FIRE, 65, 95, 57, 93,
                SPRITE_URL.formatted(126));
        magmar.addMove(new Move("Scratch", 40, Type.NORMAL));
        magmar.addMove(new Move("Ember", 40, Type.FIRE));
        magmar.addMove(new Move("Smokescreen", 0, Type.NORMAL));
        magmar.addMove(new Move("Flamethrower", 90, Type.FIRE));
        pokemonDatabase.put(126, magmar);

        // #127 Pinsir
        Pokemon pinsir = new Pokemon(127, "Pinsir", 25, Type.BUG, 65, 125, 100, 85,
                SPRITE_URL.formatted(127));
        pinsir.addMove(new Move("Tackle", 40, Type.NORMAL));
        pinsir.addMove(new Move("Bug Bite", 60, Type.BUG));
        pinsir.addMove(new Move("String Shot", 0, Type.BUG));
        pinsir.addMove(new Move("X-Scissor", 80, Type.BUG));
        pokemonDatabase.put(127, pinsir);

        // #128 Tauros
        Pokemon tauros = new Pokemon(128, "Tauros", 18, Type.NORMAL, 75, 100, 95, 110,
                SPRITE_URL.formatted(128));
        tauros.addMove(new Move("Tackle", 40, Type.NORMAL));
        tauros.addMove(new Move("Quick Attack", 40, Type.NORMAL));
        tauros.addMove(new Move("Bite", 60, Type.DARK));
        tauros.addMove(new Move("Body Slam", 85, Type.NORMAL));
        pokemonDatabase.put(128, tauros);

        // #129 Magikarp
        Pokemon magikarp = new Pokemon(129, "Magikarp", 3, Type.WATER, 20, 10, 55, 80,
                SPRITE_URL.formatted(129));
        magikarp.addMove(new Move("Splash", 0, Type.NORMAL));
        magikarp.addMove(new Move("Tackle", 40, Type.NORMAL));
        magikarp.addMove(new Move("Flail", 0, Type.NORMAL));
        magikarp.addMove(new Move("Bounce", 85, Type.FLYING));
        pokemonDatabase.put(129, magikarp);

        // #130 Gyarados
        Pokemon gyarados = new Pokemon(130, "Gyarados", 20, Type.WATER, 95, 125, 79, 81,
                SPRITE_URL.formatted(130));
        gyarados.addMove(new Move("Bite", 60, Type.DARK));
        gyarados.addMove(new Move("Waterfall", 80, Type.WATER));
        gyarados.addMove(new Move("Dragon Dance", 0, Type.DRAGON));
        gyarados.addMove(new Move("Hydro Pump", 110, Type.WATER));
        pokemonDatabase.put(130, gyarados);

        // #131 Lapras
        Pokemon lapras = new Pokemon(131, "Lapras", 40, Type.WATER, 130, 85, 80, 60,
                SPRITE_URL.formatted(131));
        lapras.addMove(new Move("Tackle", 40, Type.NORMAL));
        lapras.addMove(new Move("Water Gun", 40, Type.WATER));
        lapras.addMove(new Move("Tail Whip", 0, Type.NORMAL));
        lapras.addMove(new Move("Hydro Pump", 110, Type.WATER));
        pokemonDatabase.put(131, lapras);

        // #132 Ditto
        Pokemon ditto = new Pokemon(132, "Ditto", 12, Type.NORMAL, 48, 48, 48, 48,
                SPRITE_URL.formatted(132));
        ditto.addMove(new Move("Transform", 0, Type.NORMAL));
        ditto.addMove(new Move("Transform", 0, Type.NORMAL));
        ditto.addMove(new Move("Transform", 0, Type.NORMAL));
        ditto.addMove(new Move("Transform", 0, Type.NORMAL));
        pokemonDatabase.put(132, ditto);

        // #133 Eevee
        Pokemon eevee = new Pokemon(133, "Eevee", 12, Type.NORMAL, 55, 55, 50, 55,
                SPRITE_URL.formatted(133));
        eevee.addMove(new Move("Tackle", 40, Type.NORMAL));
        eevee.addMove(new Move("Quick Attack", 40, Type.NORMAL));
        eevee.addMove(new Move("Sand Attack", 0, Type.GROUND));
        eevee.addMove(new Move("Swift", 60, Type.NORMAL));
        pokemonDatabase.put(133, eevee);

        // #134 Vaporeon
        Pokemon vaporeon = new Pokemon(134, "Vaporeon", 25, Type.WATER, 130, 65, 60, 65,
                SPRITE_URL.formatted(134));
        vaporeon.addMove(new Move("Tackle", 40, Type.NORMAL));
        vaporeon.addMove(new Move("Water Gun", 40, Type.WATER));
        vaporeon.addMove(new Move("Tail Whip", 0, Type.NORMAL));
        vaporeon.addMove(new Move("Hydro Pump", 110, Type.WATER));
        pokemonDatabase.put(134, vaporeon);

        // #135 Jolteon
        Pokemon jolteon = new Pokemon(135, "Jolteon", 25, Type.ELECTRIC, 65, 65, 60, 130,
                SPRITE_URL.formatted(135));
        jolteon.addMove(new Move("Quick Attack", 40, Type.NORMAL));
        jolteon.addMove(new Move("Thunder Shock", 40, Type.ELECTRIC));
        jolteon.addMove(new Move("Thunder Wave", 0, Type.ELECTRIC));
        jolteon.addMove(new Move("Thunderbolt", 90, Type.ELECTRIC));
        pokemonDatabase.put(135, jolteon);

        // #136 Flareon
        Pokemon flareon = new Pokemon(136, "Flareon", 25, Type.FIRE, 65, 130, 60, 65,
                SPRITE_URL.formatted(136));
        flareon.addMove(new Move("Scratch", 40, Type.NORMAL));
        flareon.addMove(new Move("Ember", 40, Type.FIRE));
        flareon.addMove(new Move("Smokescreen", 0, Type.NORMAL));
        flareon.addMove(new Move("Flamethrower", 90, Type.FIRE));
        pokemonDatabase.put(136, flareon);

        // #137 Porygon
        Pokemon porygon = new Pokemon(137, "Porygon", 18, Type.NORMAL, 65, 60, 70, 40,
                SPRITE_URL.formatted(137));
        porygon.addMove(new Move("Tackle", 40, Type.NORMAL));
        porygon.addMove(new Move("Quick Attack", 40, Type.NORMAL));
        porygon.addMove(new Move("Bite", 60, Type.DARK));
        porygon.addMove(new Move("Body Slam", 85, Type.NORMAL));
        pokemonDatabase.put(137, porygon);

        // #138 Omanyte
        Pokemon omanyte = new Pokemon(138, "Omanyte", 20, Type.ROCK, 35, 40, 100, 35,
                SPRITE_URL.formatted(138));
        omanyte.addMove(new Move("Tackle", 40, Type.NORMAL));
        omanyte.addMove(new Move("Rock Throw", 50, Type.ROCK));
        omanyte.addMove(new Move("Harden", 0, Type.NORMAL));
        omanyte.addMove(new Move("Rock Slide", 75, Type.ROCK));
        pokemonDatabase.put(138, omanyte);

        // #139 Omastar
        Pokemon omastar = new Pokemon(139, "Omastar", 40, Type.ROCK, 70, 60, 125, 55,
                SPRITE_URL.formatted(139));
        omastar.addMove(new Move("Tackle", 40, Type.NORMAL));
        omastar.addMove(new Move("Rock Throw", 50, Type.ROCK));
        omastar.addMove(new Move("Harden", 0, Type.NORMAL));
        omastar.addMove(new Move("Rock Slide", 75, Type.ROCK));
        pokemonDatabase.put(139, omastar);

        // #140 Kabuto
        Pokemon kabuto = new Pokemon(140, "Kabuto", 20, Type.ROCK, 30, 80, 90, 55,
                SPRITE_URL.formatted(140));
        kabuto.addMove(new Move("Tackle", 40, Type.NORMAL));
        kabuto.addMove(new Move("Rock Throw", 50, Type.ROCK));
        kabuto.addMove(new Move("Harden", 0, Type.NORMAL));
        kabuto.addMove(new Move("Rock Slide", 75, Type.ROCK));
        pokemonDatabase.put(140, kabuto);

        // #141 Kabutops
        Pokemon kabutops = new Pokemon(141, "Kabutops", 40, Type.ROCK, 60, 115, 105, 80,
                SPRITE_URL.formatted(141));
        kabutops.addMove(new Move("Tackle", 40, Type.NORMAL));
        kabutops.addMove(new Move("Rock Throw", 50, Type.ROCK));
        kabutops.addMove(new Move("Harden", 0, Type.NORMAL));
        kabutops.addMove(new Move("Rock Slide", 75, Type.ROCK));
        pokemonDatabase.put(141, kabutops);

        // #142 Aerodactyl
        Pokemon aerodactyl = new Pokemon(142, "Aerodactyl", 45, Type.ROCK, 80, 105, 65, 130,
                SPRITE_URL.formatted(142));
        aerodactyl.addMove(new Move("Tackle", 40, Type.NORMAL));
        aerodactyl.addMove(new Move("Rock Throw", 50, Type.ROCK));
        aerodactyl.addMove(new Move("Harden", 0, Type.NORMAL));
        aerodactyl.addMove(new Move("Rock Slide", 75, Type.ROCK));
        pokemonDatabase.put(142, aerodactyl);

        // #143 Snorlax
        Pokemon snorlax = new Pokemon(143, "Snorlax", 30, Type.NORMAL, 160, 110, 65, 30,
                SPRITE_URL.formatted(143));
        snorlax.addMove(new Move("Tackle", 40, Type.NORMAL));
        snorlax.addMove(new Move("Rest", 0, Type.PSYCHIC));
        snorlax.addMove(new Move("Body Slam", 85, Type.NORMAL));
        snorlax.addMove(new Move("Hyper Beam", 150, Type.NORMAL));
        pokemonDatabase.put(143, snorlax);

        // #144 Articuno
        Pokemon articuno = new Pokemon(144, "Articuno", 50, Type.ICE, 90, 85, 100, 85,
                SPRITE_URL.formatted(144));
        articuno.addMove(new Move("Pound", 40, Type.NORMAL));
        articuno.addMove(new Move("Ice Shard", 40, Type.ICE));
        articuno.addMove(new Move("Mist", 0, Type.ICE));
        articuno.addMove(new Move("Ice Beam", 90, Type.ICE));
        pokemonDatabase.put(144, articuno);

        // #145 Zapdos
        Pokemon zapdos = new Pokemon(145, "Zapdos", 50, Type.ELECTRIC, 90, 90, 85, 100,
                SPRITE_URL.formatted(145));
        zapdos.addMove(new Move("Quick Attack", 40, Type.NORMAL));
        zapdos.addMove(new Move("Thunder Shock", 40, Type.ELECTRIC));
        zapdos.addMove(new Move("Thunder Wave", 0, Type.ELECTRIC));
        zapdos.addMove(new Move("Thunderbolt", 90, Type.ELECTRIC));
        pokemonDatabase.put(145, zapdos);

        // #146 Moltres
        Pokemon moltres = new Pokemon(146, "Moltres", 50, Type.FIRE, 90, 100, 90, 90,
                SPRITE_URL.formatted(146));
        moltres.addMove(new Move("Scratch", 40, Type.NORMAL));
        moltres.addMove(new Move("Ember", 40, Type.FIRE));
        moltres.addMove(new Move("Smokescreen", 0, Type.NORMAL));
        moltres.addMove(new Move("Flamethrower", 90, Type.FIRE));
        pokemonDatabase.put(146, moltres);

        // #147 Dratini
        Pokemon dratini = new Pokemon(147, "Dratini", 10, Type.DRAGON, 41, 64, 45, 50,
                SPRITE_URL.formatted(147));
        dratini.addMove(new Move("Wrap", 15, Type.NORMAL));
        dratini.addMove(new Move("Twister", 40, Type.DRAGON));
        dratini.addMove(new Move("Dragon Dance", 0, Type.DRAGON));
        dratini.addMove(new Move("Dragon Pulse", 85, Type.DRAGON));
        pokemonDatabase.put(147, dratini);

        // #148 Dragonair
        Pokemon dragonair = new Pokemon(148, "Dragonair", 30, Type.DRAGON, 61, 84, 65, 70,
                SPRITE_URL.formatted(148));
        dragonair.addMove(new Move("Wrap", 15, Type.NORMAL));
        dragonair.addMove(new Move("Twister", 40, Type.DRAGON));
        dragonair.addMove(new Move("Dragon Dance", 0, Type.DRAGON));
        dragonair.addMove(new Move("Dragon Pulse", 85, Type.DRAGON));
        pokemonDatabase.put(148, dragonair);

        // #149 Dragonite
        Pokemon dragonite = new Pokemon(149, "Dragonite", 55, Type.DRAGON, 91, 134, 95, 80,
                SPRITE_URL.formatted(149));
        dragonite.addMove(new Move("Wrap", 15, Type.NORMAL));
        dragonite.addMove(new Move("Twister", 40, Type.DRAGON));
        dragonite.addMove(new Move("Dragon Dance", 0, Type.DRAGON));
        dragonite.addMove(new Move("Dragon Pulse", 85, Type.DRAGON));
        pokemonDatabase.put(149, dragonite);

        // #150 Mewtwo
        Pokemon mewtwo = new Pokemon(150, "Mewtwo", 70, Type.PSYCHIC, 106, 110, 90, 130,
                SPRITE_URL.formatted(150));
        mewtwo.addMove(new Move("Confusion", 50, Type.PSYCHIC));
        mewtwo.addMove(new Move("Recover", 0, Type.NORMAL));
        mewtwo.addMove(new Move("Psychic", 90, Type.PSYCHIC));
        mewtwo.addMove(new Move("Psystrike", 100, Type.PSYCHIC));
        pokemonDatabase.put(150, mewtwo);

        // #151 Mew
        Pokemon mew = new Pokemon(151, "Mew", 70, Type.PSYCHIC, 100, 100, 100, 100,
                SPRITE_URL.formatted(151));
        mew.addMove(new Move("Pound", 40, Type.NORMAL));
        mew.addMove(new Move("Transform", 0, Type.NORMAL));
        mew.addMove(new Move("Psychic", 90, Type.PSYCHIC));
        mew.addMove(new Move("Ancient Power", 60, Type.ROCK));
        pokemonDatabase.put(151, mew);
    }

    public List<Pokemon> findAll() {
        return new ArrayList<>(pokemonDatabase.values());
    }
    
    public Optional<Pokemon> findById(int id) {
        return Optional.ofNullable(pokemonDatabase.get(id));
    }
}
