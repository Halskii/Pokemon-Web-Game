package com.pokemon.repository;

import com.pokemon.model.Pokemon;
import com.pokemon.model.Trainer;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;

@Repository
public class TrainerRepository {
    private final Trainer player;

    public TrainerRepository() {
        this.player = new Trainer("Player1", "Ash");
    }

    public Trainer getPlayer() {
        return player;
    }

    public void addPokemon(Pokemon pokemon) {
        player.addPokemon(pokemon);
    }

    public List<Integer> getOwnedPokemonIds() {
        return new ArrayList<>(player.getCollection().stream()
                .map(pokemon -> pokemon.getId())
                .toList());
    }

    public void clearCollection() {
        player.clearCollection();
    }
}