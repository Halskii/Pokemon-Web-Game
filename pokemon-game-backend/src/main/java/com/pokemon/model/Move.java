package com.pokemon.model;

import java.util.Objects;
import com.pokemon.model.Type;

public class Move {
    private String name;
    private int power;
    private Type type;
    
    public Move() {
    }
    
    public Move(String name, int power, Type type) {
        this.name = name;
        this.power = power;
        this.type = type;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public int getPower() {
        return power;
    }
    
    public void setPower(int power) {
        this.power = power;
    }
    
    public Type getType() {
        return type;
    }
    
    public void setType(Type type) {
        this.type = type;
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Move move = (Move) o;
        return power == move.power && 
               Objects.equals(name, move.name) && 
               Objects.equals(type, move.type);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(name, power, type);
    }
    
    @Override
    public String toString() {
        return "Move{" +
                "name='" + name + '\'' +
                ", power=" + power +
                ", type='" + type + '\'' +
                '}';
    }
}
