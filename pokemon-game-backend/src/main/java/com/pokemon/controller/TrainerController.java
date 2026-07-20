package com.pokemon.controller;

import com.pokemon.model.Pokemon;
import com.pokemon.service.TrainerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/trainer")
@CrossOrigin(origins = "http://localhost:3000")
public class TrainerController {

    @Autowired
    private TrainerService trainerService;

    @PostMapping("/collection/add/{pokemonid}")
    public ResponseEntity<String> addPokemonToCollection(@PathVariable int pokemonid) {
        try {
            trainerService.addPokemonToCollection(pokemonid);
            return ResponseEntity.ok("Trainer has caught a pokemon!");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/collection")
    public ResponseEntity<List<Pokemon>> getTrainerCollection() {
        List<Pokemon> collection = trainerService.getCollection();
        return ResponseEntity.ok(collection);
    }

    @PostMapping("/starter/{pokemonId}")
    public ResponseEntity<String> chooseStarter(@PathVariable int pokemonId) {
        try {
            trainerService.chooseStarter(pokemonId);
            return ResponseEntity.ok("Starter chosen!");
        } catch (IllegalArgumentException | IllegalStateException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}