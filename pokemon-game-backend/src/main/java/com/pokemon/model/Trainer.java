package com.pokemon.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Trainer {

    private String id;
    private String name;
    private List<Pokemon> collection = new ArrayList<>();

    public Trainer() {
        this.id = "default";
        this.name = "Default";
    }

    public Trainer(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void addPokemon(Pokemon pokemon) {
        collection.add(new Pokemon(pokemon));
    }
    public List<Pokemon> getCollection() {
        return new ArrayList<>(collection);
    }
}