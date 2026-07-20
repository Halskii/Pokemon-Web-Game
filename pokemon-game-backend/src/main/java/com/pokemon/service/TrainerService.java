package com.pokemon.service;

import com.pokemon.model.Pokemon;
import com.pokemon.repository.PokemonRepository;
import com.pokemon.repository.TrainerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TrainerService {

    @Autowired
    private TrainerRepository trainerRepository;

    @Autowired
    private PokemonRepository pokemonRepository;

    public void addPokemonToCollection(int pokemonId) {
        trainerRepository.addPokemon(pokemonId);
    }

    public List<Pokemon> getCollection() {
        List<Integer> pokemonIds = trainerRepository.getOwnedPokemonIds();

        // Matching pokemon IDs to pokemon objects
        return pokemonIds.stream()
                .map(id -> pokemonRepository.findById(id).orElse(null))
                .filter(pokemon -> pokemon != null)
                .collect(Collectors.toList());
    }
}