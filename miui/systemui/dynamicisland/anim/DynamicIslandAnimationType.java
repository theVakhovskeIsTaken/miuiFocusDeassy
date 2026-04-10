/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  N0.a
 *  N0.b
 */
package miui.systemui.dynamicisland.anim;

import N0.a;
import N0.b;

public final class DynamicIslandAnimationType
extends Enum<DynamicIslandAnimationType> {
    private static final a $ENTRIES;
    private static final DynamicIslandAnimationType[] $VALUES;
    public static final /* enum */ DynamicIslandAnimationType ALL;
    public static final /* enum */ DynamicIslandAnimationType BIG_CHANGED;
    public static final /* enum */ DynamicIslandAnimationType BIG_TO_DELETED;
    public static final /* enum */ DynamicIslandAnimationType BIG_TO_EXPANDED;
    public static final /* enum */ DynamicIslandAnimationType BIG_TO_HIDDEN;
    public static final /* enum */ DynamicIslandAnimationType BIG_TO_SMALL;
    public static final /* enum */ DynamicIslandAnimationType BIG_TO_TEMP_HIDDEN;
    public static final /* enum */ DynamicIslandAnimationType EXPANDED_CHANGED;
    public static final /* enum */ DynamicIslandAnimationType EXPANDED_TO_APP_EXPANDED;
    public static final /* enum */ DynamicIslandAnimationType EXPANDED_TO_BIG;
    public static final /* enum */ DynamicIslandAnimationType EXPANDED_TO_DELETED;
    public static final /* enum */ DynamicIslandAnimationType EXPANDED_TO_HIDDEN;
    public static final /* enum */ DynamicIslandAnimationType EXPANDED_TO_MINI_WINDOW;
    public static final /* enum */ DynamicIslandAnimationType EXPANDED_TO_SMALL;
    public static final /* enum */ DynamicIslandAnimationType EXPANDED_TO_TEMP_HIDDEN;
    public static final /* enum */ DynamicIslandAnimationType HIDDEN_TO_BIG;
    public static final /* enum */ DynamicIslandAnimationType HIDDEN_TO_SMALL;
    public static final /* enum */ DynamicIslandAnimationType INIT_TO_BIG;
    public static final /* enum */ DynamicIslandAnimationType INIT_TO_EXPANDED;
    public static final /* enum */ DynamicIslandAnimationType INIT_TO_HIDDEN;
    public static final /* enum */ DynamicIslandAnimationType INIT_TO_SMALL;
    public static final /* enum */ DynamicIslandAnimationType INIT_TO_TEMP_HIDDEN;
    public static final /* enum */ DynamicIslandAnimationType SMALL_CHANGED;
    public static final /* enum */ DynamicIslandAnimationType SMALL_TO_BIG;
    public static final /* enum */ DynamicIslandAnimationType SMALL_TO_DELETED;
    public static final /* enum */ DynamicIslandAnimationType SMALL_TO_EXPANDED;
    public static final /* enum */ DynamicIslandAnimationType SMALL_TO_HIDDEN;
    public static final /* enum */ DynamicIslandAnimationType SMALL_TO_TEMP_HIDDEN;
    public static final /* enum */ DynamicIslandAnimationType TEMP_HIDDEN_TO_BIG;
    public static final /* enum */ DynamicIslandAnimationType TEMP_HIDDEN_TO_SMALL;
    public static final /* enum */ DynamicIslandAnimationType TO_EXPANDED;

    private static final /* synthetic */ DynamicIslandAnimationType[] $values() {
        return new DynamicIslandAnimationType[]{ALL, TO_EXPANDED, EXPANDED_TO_BIG, EXPANDED_TO_SMALL, EXPANDED_TO_TEMP_HIDDEN, EXPANDED_TO_HIDDEN, EXPANDED_TO_DELETED, EXPANDED_TO_MINI_WINDOW, EXPANDED_TO_APP_EXPANDED, EXPANDED_CHANGED, INIT_TO_BIG, INIT_TO_SMALL, INIT_TO_TEMP_HIDDEN, INIT_TO_HIDDEN, INIT_TO_EXPANDED, SMALL_TO_BIG, SMALL_TO_EXPANDED, SMALL_TO_HIDDEN, SMALL_TO_TEMP_HIDDEN, SMALL_TO_DELETED, SMALL_CHANGED, BIG_TO_SMALL, BIG_TO_EXPANDED, BIG_TO_HIDDEN, BIG_TO_TEMP_HIDDEN, BIG_TO_DELETED, BIG_CHANGED, HIDDEN_TO_BIG, HIDDEN_TO_SMALL, TEMP_HIDDEN_TO_BIG, TEMP_HIDDEN_TO_SMALL};
    }

    static {
        ALL = new DynamicIslandAnimationType();
        TO_EXPANDED = new DynamicIslandAnimationType();
        EXPANDED_TO_BIG = new DynamicIslandAnimationType();
        EXPANDED_TO_SMALL = new DynamicIslandAnimationType();
        EXPANDED_TO_TEMP_HIDDEN = new DynamicIslandAnimationType();
        EXPANDED_TO_HIDDEN = new DynamicIslandAnimationType();
        EXPANDED_TO_DELETED = new DynamicIslandAnimationType();
        EXPANDED_TO_MINI_WINDOW = new DynamicIslandAnimationType();
        EXPANDED_TO_APP_EXPANDED = new DynamicIslandAnimationType();
        EXPANDED_CHANGED = new DynamicIslandAnimationType();
        INIT_TO_BIG = new DynamicIslandAnimationType();
        INIT_TO_SMALL = new DynamicIslandAnimationType();
        INIT_TO_TEMP_HIDDEN = new DynamicIslandAnimationType();
        INIT_TO_HIDDEN = new DynamicIslandAnimationType();
        INIT_TO_EXPANDED = new DynamicIslandAnimationType();
        SMALL_TO_BIG = new DynamicIslandAnimationType();
        SMALL_TO_EXPANDED = new DynamicIslandAnimationType();
        SMALL_TO_HIDDEN = new DynamicIslandAnimationType();
        SMALL_TO_TEMP_HIDDEN = new DynamicIslandAnimationType();
        SMALL_TO_DELETED = new DynamicIslandAnimationType();
        SMALL_CHANGED = new DynamicIslandAnimationType();
        BIG_TO_SMALL = new DynamicIslandAnimationType();
        BIG_TO_EXPANDED = new DynamicIslandAnimationType();
        BIG_TO_HIDDEN = new DynamicIslandAnimationType();
        BIG_TO_TEMP_HIDDEN = new DynamicIslandAnimationType();
        BIG_TO_DELETED = new DynamicIslandAnimationType();
        BIG_CHANGED = new DynamicIslandAnimationType();
        HIDDEN_TO_BIG = new DynamicIslandAnimationType();
        HIDDEN_TO_SMALL = new DynamicIslandAnimationType();
        TEMP_HIDDEN_TO_BIG = new DynamicIslandAnimationType();
        TEMP_HIDDEN_TO_SMALL = new DynamicIslandAnimationType();
        Enum[] enumArray = DynamicIslandAnimationType.$values();
        $VALUES = enumArray;
        $ENTRIES = b.a((Enum[])enumArray);
    }

    public static a getEntries() {
        return $ENTRIES;
    }

    public static DynamicIslandAnimationType valueOf(String string) {
        return Enum.valueOf(DynamicIslandAnimationType.class, string);
    }

    public static DynamicIslandAnimationType[] values() {
        return (DynamicIslandAnimationType[])$VALUES.clone();
    }
}
