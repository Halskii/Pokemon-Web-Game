package com.pokemon.repository;

import com.pokemon.model.Item;
import com.pokemon.model.ItemType;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Repository
public class ItemRepository {

    private final Map<Integer, Item> itemDatabase;

    private static final String ITEM_SPRITE_URL =
            "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/items/%s.png";

    public ItemRepository() {
        this.itemDatabase = new HashMap<>();
        initializeItems();
    }

    private void initializeItems() {
        itemDatabase.put(1, new Item(1, "Potion", ITEM_SPRITE_URL.formatted("potion"), 50, ItemType.HEALING, 20));
        itemDatabase.put(2, new Item(2, "Super Potion", ITEM_SPRITE_URL.formatted("super-potion"), 150, ItemType.HEALING, 50));
        itemDatabase.put(3, new Item(3, "Poke Ball", ITEM_SPRITE_URL.formatted("poke-ball"), 100, ItemType.POKEBALL, 30));
        itemDatabase.put(4, new Item(4, "Great Ball", ITEM_SPRITE_URL.formatted("great-ball"), 200, ItemType.POKEBALL, 50));
        itemDatabase.put(5, new Item(5, "Ultra Ball", ITEM_SPRITE_URL.formatted("ultra-ball"), 300, ItemType.POKEBALL, 70));
    }

    public List<Item> findAll() {
        return List.copyOf(itemDatabase.values());
    }

    public Optional<Item> findById(int id) {
        return Optional.ofNullable(itemDatabase.get(id));
    }
}
