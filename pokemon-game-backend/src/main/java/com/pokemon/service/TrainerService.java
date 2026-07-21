package com.pokemon.service;

import com.pokemon.model.Pokemon;
import com.pokemon.repository.PokemonRepository;
import com.pokemon.repository.TrainerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class TrainerService {

    // Bulbasaur, Charmander, Squirtle, Pikachu
    private static final Set<Integer> STARTER_IDS = Set.of(1, 4, 7, 25);

    @Autowired
    private TrainerRepository trainerRepository;

    @Autowired
    private PokemonRepository pokemonRepository;

    public void addPokemonToCollection(int pokemonId) {
        Pokemon pokemon = pokemonRepository.findById(pokemonId)
                .orElseThrow(() -> new IllegalArgumentException("Pokemon not found: " + pokemonId));
        trainerRepository.addPokemon(pokemon);
    }

    public void addPokemonToCollection(Pokemon pokemon) {
        trainerRepository.addPokemon(pokemon);
    }

    public List<Pokemon> getCollection() {
        List<Integer> pokemonIds = trainerRepository.getOwnedPokemonIds();

        // Matching pokemon IDs to pokemon objects
        return pokemonIds.stream()
                .map(id -> pokemonRepository.findById(id).orElse(null))
                .filter(pokemon -> pokemon != null)
                .collect(Collectors.toList());
    }

    public void chooseStarter(int pokemonId) {
        if (!STARTER_IDS.contains(pokemonId)) {
            throw new IllegalArgumentException("Not a valid starter: " + pokemonId);
        }
        if (!getCollection().isEmpty()) {
            throw new IllegalStateException("Starter has already been chosen");
        }
        addPokemonToCollection(pokemonId);
    }

    public void reset() {
        trainerRepository.clearCollection();
    }
}