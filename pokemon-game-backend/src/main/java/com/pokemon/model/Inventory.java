package com.pokemon.model;

import java.util.HashMap;
import java.util.Map;

public class Inventory {

    private Map<Integer, Integer> itemQuantities;

    public Inventory() {
        this.itemQuantities = new HashMap<>();
    }

    public void add(int itemId, int quantity) {
        itemQuantities.merge(itemId, quantity, Integer::sum);
    }

    // Removes one unit of the given item. Returns false (and makes no change) if none are owned.
    public boolean remove(int itemId, int quantity) {
        int owned = itemQuantities.getOrDefault(itemId, 0);
        if (owned < quantity) {
            return false;
        }
        int remaining = owned - quantity;
        if (remaining == 0) {
            itemQuantities.remove(itemId);
        } else {
            itemQuantities.put(itemId, remaining);
        }
        return true;
    }

    public int getQuantity(int itemId) {
        return itemQuantities.getOrDefault(itemId, 0);
    }

    public Map<Integer, Integer> getItemQuantities() {
        return new HashMap<>(itemQuantities);
    }
}
