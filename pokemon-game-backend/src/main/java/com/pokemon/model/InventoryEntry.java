package com.pokemon.model;

// Pairs a catalog Item with how many the trainer owns, for API responses.
public class InventoryEntry {
    private Item item;
    private int quantity;

    public InventoryEntry(Item item, int quantity) {
        this.item = item;
        this.quantity = quantity;
    }

    public Item getItem() {
        return item;
    }

    public int getQuantity() {
        return quantity;
    }
}
