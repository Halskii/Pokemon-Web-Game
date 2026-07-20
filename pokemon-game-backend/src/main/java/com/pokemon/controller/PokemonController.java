package com.pokemon.controller;

import com.pokemon.model.Pokemon;
import com.pokemon.repository.PokemonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pokemon")
@CrossOrigin(origins = "http://localhost:3000")
public class PokemonController {
    
    private final PokemonRepository pokemonRepository;
    
    @Autowired
    public PokemonController(PokemonRepository pokemonRepository) {
        this.pokemonRepository = pokemonRepository;
    }
    
    @GetMapping
    public ResponseEntity<List<Pokemon>> getAllPokemon() {
        List<Pokemon> pokemon = pokemonRepository.findAll();
        return ResponseEntity.ok(pokemon);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Pokemon> getPokemonById(@PathVariable int id) {
        return pokemonRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
