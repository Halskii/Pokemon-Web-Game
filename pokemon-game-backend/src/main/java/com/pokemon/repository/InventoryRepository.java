package com.pokemon.repository;

import com.pokemon.model.Inventory;
import org.springframework.stereotype.Repository;

@Repository
public class InventoryRepository {

    private final Inventory inventory;

    public InventoryRepository() {
        this.inventory = new Inventory();
        // Starting stock so battling/catching can be tested without a shop flow yet.
        inventory.add(3, 5); // Poke Ball
        inventory.add(4, 2); // Great Ball
        inventory.add(1, 3); // Potion
    }

    public Inventory getInventory() {
        return inventory;
    }
}
