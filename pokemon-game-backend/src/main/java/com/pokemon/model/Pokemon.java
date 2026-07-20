package com.pokemon.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import com.pokemon.model.Type;

public class Pokemon {
    private int id;
    private String name;
    private Type type;
    private int maxHp;
    private int currentHp;
    private int attack;
    private int defense;
    private int speed;
    private String sprite;
    private List<Move> moves;

    public Pokemon() {
        this.moves = new ArrayList<>();
    }

    public Pokemon(int id, String name, Type type, int maxHp, int attack,
                   int defense, int speed, String sprite) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.maxHp = maxHp;
        this.currentHp = maxHp;
        this.attack = attack;
        this.defense = defense;
        this.speed = speed;
        this.sprite = sprite;
        this.moves = new ArrayList<>();
    }

    // Copy constructor for battle instances
    public Pokemon(Pokemon other) {
        this.id = other.id;
        this.name = other.name;
        this.type = other.type;
        this.maxHp = other.maxHp;
        this.currentHp = other.maxHp; // Reset HP for battle
        this.attack = other.attack;
        this.defense = other.defense;
        this.speed = other.speed;
        this.sprite = other.sprite;
        this.moves = new ArrayList<>(other.moves);
    }

    public void addMove(Move move) {
        if (moves.size() < 4) {
            moves.add(move);
        }
    }

    public Move getMove(String moveName) {
        return moves.stream()
                .filter(m -> m.getName().equals(moveName))
                .findFirst()
                .orElse(null);
    }

    public void takeDamage(int damage) {
        this.currentHp = Math.max(0, this.currentHp - damage);
    }

    public boolean isFainted() {
        return this.currentHp <= 0;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public int getMaxHp() {
        return maxHp;
    }

    public void setMaxHp(int maxHp) {
        this.maxHp = maxHp;
    }

    public int getCurrentHp() {
        return currentHp;
    }

    public void setCurrentHp(int currentHp) {
        this.currentHp = currentHp;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public int getDefense() {
        return defense;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public String getSprite() {
        return sprite;
    }

    public void setSprite(String sprite) {
        this.sprite = sprite;
    }

    public List<Move> getMoves() {
        return new ArrayList<>(moves); // Return defensive copy
    }

    public void setMoves(List<Move> moves) {
        this.moves = new ArrayList<>(moves);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pokemon pokemon = (Pokemon) o;
        return id == pokemon.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Pokemon{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", currentHp=" + currentHp +
                ", maxHp=" + maxHp +
                '}';
    }
}
