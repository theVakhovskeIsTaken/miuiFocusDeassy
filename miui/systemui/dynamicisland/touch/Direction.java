/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  N0.a
 *  N0.b
 */
package miui.systemui.dynamicisland.touch;

import N0.a;
import N0.b;

public final class Direction
extends Enum<Direction> {
    private static final a $ENTRIES;
    private static final Direction[] $VALUES;
    public static final /* enum */ Direction DOWN;
    public static final /* enum */ Direction LEFT;
    public static final /* enum */ Direction RIGHT;
    public static final /* enum */ Direction UNKNOWN;
    public static final /* enum */ Direction UP;

    private static final /* synthetic */ Direction[] $values() {
        return new Direction[]{UNKNOWN, UP, DOWN, LEFT, RIGHT};
    }

    static {
        UNKNOWN = new Direction();
        UP = new Direction();
        DOWN = new Direction();
        LEFT = new Direction();
        RIGHT = new Direction();
        Enum[] enumArray = Direction.$values();
        $VALUES = enumArray;
        $ENTRIES = b.a((Enum[])enumArray);
    }

    public static a getEntries() {
        return $ENTRIES;
    }

    public static Direction valueOf(String string) {
        return Enum.valueOf(Direction.class, string);
    }

    public static Direction[] values() {
        return (Direction[])$VALUES.clone();
    }

    public final boolean isDown() {
        boolean bl = this == DOWN;
        return bl;
    }

    public final boolean isHorizontal() {
        boolean bl = this == LEFT || this == RIGHT;
        return bl;
    }

    public final boolean isLeft() {
        boolean bl = this == LEFT;
        return bl;
    }

    public final boolean isRight() {
        boolean bl = this == RIGHT;
        return bl;
    }

    public final boolean isUp() {
        boolean bl = this == UP;
        return bl;
    }

    public final boolean isVertical() {
        boolean bl = this == UP || this == DOWN;
        return bl;
    }
}
