package com.pokemon.model;

import java.util.Objects;

public class Item {
    private int id;
    private String name;
    private String icon;
    private int price;
    private ItemType itemType;
    private int potency; // HEALING: HP restored. POKEBALL: catch rate (0-100).

    public Item() {
    }

    public Item(int id, String name, String icon, int price, ItemType itemType, int potency) {
        this.id = id;
        this.name = name;
        this.icon = icon;
        this.price = price;
        this.itemType = itemType;
        this.potency = potency;
    }

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

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public ItemType getItemType() {
        return itemType;
    }

    public void setItemType(ItemType itemType) {
        this.itemType = itemType;
    }

    public int getPotency() {
        return potency;
    }

    public void setPotency(int potency) {
        this.potency = potency;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return id == item.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", itemType=" + itemType +
                ", potency=" + potency +
                '}';
    }
}
