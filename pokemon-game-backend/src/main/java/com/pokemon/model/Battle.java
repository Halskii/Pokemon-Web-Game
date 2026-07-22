package com.pokemon.model;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Battle {
    private String id;
    private Pokemon player;
    private Pokemon opponent;
    private String turn;
    private List<String> log;
    private boolean caught;

    public Battle() {
        this.id = UUID.randomUUID().toString();
        this.log = new ArrayList<>();
    }
    
    public Battle(Pokemon player, Pokemon opponent) {
        this.id = UUID.randomUUID().toString();
        this.player = new Pokemon(player); // Create battle copy
        this.opponent = new Pokemon(opponent); // Create battle copy
        this.turn = "player";
        this.log = new ArrayList<>();
        this.log.add(String.format("Battle started! %s vs %s!", 
                                    player.getName(), opponent.getName()));
    }
    
    public void addLogEntry(String entry) {
        if (entry != null && !entry.isEmpty()) {
            this.log.add(entry);
        }
        else return;
    }
    
    public boolean isOver() {
        return player.isFainted() || opponent.isFainted() || caught;
    }

    public String getWinner() {
        if (caught) {
            return "player";
        } else if (opponent.isFainted() && !player.isFainted()) {
            return "player";
        } else if (player.isFainted() && !opponent.isFainted()) {
            return "opponent";
        }
        return "none";
    }
    
    // Getters and Setters
    public String getId() {
        return id;
    }
    
    public void setId(String id) {
        this.id = id;
    }
    
    public Pokemon getPlayer() {
        return player;
    }
    
    public void setPlayer(Pokemon player) {
        this.player = player;
    }
    
    public Pokemon getOpponent() {
        return opponent;
    }
    
    public void setOpponent(Pokemon opponent) {
        this.opponent = opponent;
    }
    
    public String getTurn() {
        return turn;
    }
    
    public void setTurn(String turn) {
        this.turn = turn;
    }
    
    public List<String> getLog() {
        return new ArrayList<>(log); // Return defensive copy
    }
    
    public void setLog(List<String> log) {
        this.log = new ArrayList<>(log);
    }

    public boolean isCaught() {
        return caught;
    }

    public void setCaught(boolean caught) {
        this.caught = caught;
    }
}
