package com.pokemon.service;

import com.pokemon.model.Inventory;
import com.pokemon.model.InventoryEntry;
import com.pokemon.model.Item;
import com.pokemon.repository.InventoryRepository;
import com.pokemon.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class InventoryService {

    private final InventoryRepository inventoryRepository;
    private final ItemRepository itemRepository;

    @Autowired
    public InventoryService(InventoryRepository inventoryRepository, ItemRepository itemRepository) {
        this.inventoryRepository = inventoryRepository;
        this.itemRepository = itemRepository;
    }

    public List<InventoryEntry> getOwnedItems() {
        Inventory inventory = inventoryRepository.getInventory();
        List<InventoryEntry> entries = new ArrayList<>();

        for (Map.Entry<Integer, Integer> owned : inventory.getItemQuantities().entrySet()) {
            itemRepository.findById(owned.getKey())
                    .ifPresent(item -> entries.add(new InventoryEntry(item, owned.getValue())));
        }
        return entries;
    }

    public boolean hasItem(int itemId) {
        return inventoryRepository.getInventory().getQuantity(itemId) > 0;
    }

    // Consumes one unit of the item. Throws if the item doesn't exist or none are owned.
    public Item useOneItem(int itemId) {
        Item item = itemRepository.findById(itemId)
                .orElseThrow(() -> new IllegalArgumentException("Item not found: " + itemId));

        boolean removed = inventoryRepository.getInventory().remove(itemId, 1);
        if (!removed) {
            throw new IllegalStateException("No " + item.getName() + " left");
        }
        return item;
    }
}
