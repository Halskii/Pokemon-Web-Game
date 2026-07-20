package com.pokemon.model;

import java.util.EnumMap;
import java.util.Map;

public final class TypeEffectiveness {

    private static final Map<Type, Map<Type, Double>> CHART =
            new EnumMap<>(Type.class);

    static {
        for (Type attackingType : Type.values()) {
            CHART.put(attackingType, new EnumMap<>(Type.class));
        }

        // NORMAL
        resistant(Type.NORMAL,
                Type.ROCK,
                Type.STEEL);
        immune(Type.NORMAL,
                Type.GHOST);

        // FIRE
        superEffective(Type.FIRE,
                Type.GRASS,
                Type.ICE,
                Type.BUG,
                Type.STEEL);
        resistant(Type.FIRE,
                Type.FIRE,
                Type.WATER,
                Type.ROCK,
                Type.DRAGON);

        // WATER
        superEffective(Type.WATER,
                Type.FIRE,
                Type.GROUND,
                Type.ROCK);
        resistant(Type.WATER,
                Type.WATER,
                Type.GRASS,
                Type.DRAGON);

        // ELECTRIC
        superEffective(Type.ELECTRIC,
                Type.WATER,
                Type.FLYING);
        resistant(Type.ELECTRIC,
                Type.ELECTRIC,
                Type.GRASS,
                Type.DRAGON);
        immune(Type.ELECTRIC,
                Type.GROUND);

        // GRASS
        superEffective(Type.GRASS,
                Type.WATER,
                Type.GROUND,
                Type.ROCK);
        resistant(Type.GRASS,
                Type.FIRE,
                Type.GRASS,
                Type.POISON,
                Type.FLYING,
                Type.BUG,
                Type.DRAGON,
                Type.STEEL);

        // ICE
        superEffective(Type.ICE,
                Type.GRASS,
                Type.GROUND,
                Type.FLYING,
                Type.DRAGON);
        resistant(Type.ICE,
                Type.FIRE,
                Type.WATER,
                Type.ICE,
                Type.STEEL);

        // FIGHTING
        superEffective(Type.FIGHTING,
                Type.NORMAL,
                Type.ICE,
                Type.ROCK,
                Type.DARK,
                Type.STEEL);
        resistant(Type.FIGHTING,
                Type.POISON,
                Type.FLYING,
                Type.PSYCHIC,
                Type.BUG,
                Type.FAIRY);
        immune(Type.FIGHTING,
                Type.GHOST);

        // POISON
        superEffective(Type.POISON,
                Type.GRASS,
                Type.FAIRY);
        resistant(Type.POISON,
                Type.POISON,
                Type.GROUND,
                Type.ROCK,
                Type.GHOST);
        immune(Type.POISON,
                Type.STEEL);

        // GROUND
        superEffective(Type.GROUND,
                Type.FIRE,
                Type.ELECTRIC,
                Type.POISON,
                Type.ROCK,
                Type.STEEL);
        resistant(Type.GROUND,
                Type.GRASS,
                Type.BUG);
        immune(Type.GROUND,
                Type.FLYING);

        // FLYING
        superEffective(Type.FLYING,
                Type.GRASS,
                Type.FIGHTING,
                Type.BUG);
        resistant(Type.FLYING,
                Type.ELECTRIC,
                Type.ROCK,
                Type.STEEL);

        // PSYCHIC
        superEffective(Type.PSYCHIC,
                Type.FIGHTING,
                Type.POISON);
        resistant(Type.PSYCHIC,
                Type.PSYCHIC,
                Type.STEEL);
        immune(Type.PSYCHIC,
                Type.DARK);

        // BUG
        superEffective(Type.BUG,
                Type.GRASS,
                Type.PSYCHIC,
                Type.DARK);
        resistant(Type.BUG,
                Type.FIRE,
                Type.FIGHTING,
                Type.POISON,
                Type.FLYING,
                Type.GHOST,
                Type.STEEL,
                Type.FAIRY);

        // ROCK
        superEffective(Type.ROCK,
                Type.FIRE,
                Type.ICE,
                Type.FLYING,
                Type.BUG);
        resistant(Type.ROCK,
                Type.FIGHTING,
                Type.GROUND,
                Type.STEEL);

        // GHOST
        superEffective(Type.GHOST,
                Type.PSYCHIC,
                Type.GHOST);
        resistant(Type.GHOST,
                Type.DARK);
        immune(Type.GHOST,
                Type.NORMAL);

        // DRAGON
        superEffective(Type.DRAGON,
                Type.DRAGON);
        resistant(Type.DRAGON,
                Type.STEEL);
        immune(Type.DRAGON,
                Type.FAIRY);

        // DARK
        superEffective(Type.DARK,
                Type.PSYCHIC,
                Type.GHOST);
        resistant(Type.DARK,
                Type.FIGHTING,
                Type.DARK,
                Type.FAIRY);

        // STEEL
        superEffective(Type.STEEL,
                Type.ICE,
                Type.ROCK,
                Type.FAIRY);
        resistant(Type.STEEL,
                Type.FIRE,
                Type.WATER,
                Type.ELECTRIC,
                Type.STEEL);

        // FAIRY
        superEffective(Type.FAIRY,
                Type.FIGHTING,
                Type.DRAGON,
                Type.DARK);
        resistant(Type.FAIRY,
                Type.FIRE,
                Type.POISON,
                Type.STEEL);
    }

    private TypeEffectiveness() {
    }

    /**
     * Returns the damage multiplier for an attacking type against a defending type.
     */
    public static double getMultiplier(Type attackingType, Type defendingType) {
        if (attackingType == null || defendingType == null) {
            throw new IllegalArgumentException(
                    "Attacking and defending types cannot be null."
            );
        }

        System.out.println("Attacking type: " + attackingType);
        System.out.println("Defending type: " + defendingType);
        double multiplier = CHART
                .get(attackingType)
                .getOrDefault(defendingType, 1.0);
        System.out.println("Chart Multiplier: " + multiplier); //This one is accurate
        return multiplier;
    }

    public static boolean isSuperEffective(
            Type attackingType,
            Type defendingType
    ) {
        return getMultiplier(attackingType, defendingType) > 1.0;
    }

    public static boolean isResisted(
            Type attackingType,
            Type defendingType
    ) {
        double multiplier = getMultiplier(attackingType, defendingType);
        return multiplier > 0.0 && multiplier < 1.0;
    }

    public static boolean hasNoEffect(
            Type attackingType,
            Type defendingType
    ) {
        return getMultiplier(attackingType, defendingType) == 0.0;
    }

    // This multiplier value is incorrect
    public static String getMessage(double multiplier) {
        System.out.println("Multiplier: " + multiplier);

        if (multiplier > 1.0) {
            return "It's super effective!";
        }
        else if (multiplier == 0.0) {
            return "It had no effect.";
        }
        else if (multiplier < 1.0) {
            return "It's not very effective.";
        }
        return "";
    }

    private static void superEffective(Type attackingType, Type... defendingTypes) {
        setAll(attackingType, 2.0, defendingTypes);
    }

    private static void resistant(Type attackingType, Type... defendingTypes) {
        setAll(attackingType, 0.5, defendingTypes);
    }

    private static void immune(Type attackingType, Type... defendingTypes) {
        setAll(attackingType, 0.0, defendingTypes);
    }

    private static void setAll(
            Type attackingType,
            double multiplier,
            Type... defendingTypes
    ) {
        Map<Type, Double> matchups = CHART.get(attackingType);

        for (Type defendingType : defendingTypes) {
            matchups.put(defendingType, multiplier);
        }
    }
}