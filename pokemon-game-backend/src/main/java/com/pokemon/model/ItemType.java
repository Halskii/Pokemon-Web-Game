package com.pokemon.model;

public enum ItemType {
    HEALING(true, true),    // usable both in and out of battle
    POKEBALL(true, false);  // battle only

    private final boolean usableInBattle;
    private final boolean usableOutsideBattle;

    ItemType(boolean usableInBattle, boolean usableOutsideBattle) {
        this.usableInBattle = usableInBattle;
        this.usableOutsideBattle = usableOutsideBattle;
    }

    public boolean isUsableInBattle() { return usableInBattle; }
    public boolean isUsableOutsideBattle() { return usableOutsideBattle; }
}