package com.pokemon.controller;

import com.pokemon.model.Battle;
import com.pokemon.service.BattleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/battle")
@CrossOrigin(origins = "http://localhost:3000")
public class BattleController {
    
    private final BattleService battleService;
    
    @Autowired
    public BattleController(BattleService battleService) {
        this.battleService = battleService;
    }
    
    @PostMapping("/start")
    public ResponseEntity<Battle> startBattle(@RequestBody Map<String, Integer> request) {
        int playerPokemonId = request.get("playerPokemonId");
        int opponentPokemonId = request.get("opponentPokemonId");
        
        try {
            Battle battle = battleService.startBattle(playerPokemonId, opponentPokemonId);
            return ResponseEntity.ok(battle);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().build();
        }
    }
    
    @PostMapping("/{battleId}/move")
    public ResponseEntity<Battle> executeMove(
            @PathVariable String battleId,
            @RequestBody Map<String, String> request) {
        
        String moveName = request.get("moveName");
        
        try {
            Battle battle = battleService.executeMove(battleId, moveName);
            return ResponseEntity.ok(battle);
        } catch (IllegalArgumentException | IllegalStateException e) {
            return ResponseEntity.badRequest().build();
        }
    }
    
    @GetMapping("/{battleId}")
    public ResponseEntity<Battle> getBattle(@PathVariable String battleId) {
        return battleService.getBattle(battleId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
