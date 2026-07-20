package com.pokemon.repository;

import com.pokemon.model.Battle;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Repository
public class BattleRepository {
    
    private final Map<String, Battle> activeBattles;
    
    public BattleRepository() {
        this.activeBattles = new HashMap<>();
    }
    
    public Battle save(Battle battle) {
        activeBattles.put(battle.getId(), battle);
        return battle;
    }
    
    public Optional<Battle> findById(String id) {
        return Optional.ofNullable(activeBattles.get(id));
    }
    
    public void deleteById(String id) {
        activeBattles.remove(id);
    }
    
    public int getActiveBattleCount() {
        return activeBattles.size();
    }
}
