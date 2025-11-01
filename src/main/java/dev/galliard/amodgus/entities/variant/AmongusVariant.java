package dev.galliard.amodgus.entities.variant;

import java.util.Arrays;
import java.util.Comparator;

public enum AmongusVariant {
    RED(0),
    YELLOW(1),
    ORANGE(2),
    GREEN(3),
    LIME(4),
    PURPLE(5),
    MAGENTA(6),
    PINK(7),
    WHITE(8),
    BLACK(9),
    BROWN(10),
    BLUE(11),
    CYAN(12);

    private static final AmongusVariant[] BY_ID = Arrays.stream(values()).sorted(Comparator.
            comparingInt(AmongusVariant::getId)).toArray(AmongusVariant[]::new);
    private final int id;

    AmongusVariant(int id) {
        this.id = id;
    }

    public int getId() {
        return this.id;
    }

    public static AmongusVariant byId(int id) {
        return BY_ID[id % BY_ID.length];
    }
}
