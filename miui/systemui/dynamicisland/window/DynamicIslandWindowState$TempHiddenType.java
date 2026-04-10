/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  N0.a
 *  N0.b
 */
package miui.systemui.dynamicisland.window;

import N0.a;
import N0.b;

public static final class DynamicIslandWindowState.TempHiddenType
extends Enum<DynamicIslandWindowState.TempHiddenType> {
    private static final a $ENTRIES;
    private static final DynamicIslandWindowState.TempHiddenType[] $VALUES;
    public static final /* enum */ DynamicIslandWindowState.TempHiddenType BOUNCER_SHOWING;
    public static final /* enum */ DynamicIslandWindowState.TempHiddenType CONTROL_CENTER_EXPANDED;
    public static final /* enum */ DynamicIslandWindowState.TempHiddenType CONTROL_CENTER_SWIPE_TO_APPEARANCE;
    public static final /* enum */ DynamicIslandWindowState.TempHiddenType DESKTOP_ANIMATING;
    public static final /* enum */ DynamicIslandWindowState.TempHiddenType MIPLAY_SHOW;
    public static final /* enum */ DynamicIslandWindowState.TempHiddenType NOTIFICATION_APPEARANCE;
    public static final /* enum */ DynamicIslandWindowState.TempHiddenType NOTIFICATION_SWIPE_TO_APPEARANCE;
    public static final /* enum */ DynamicIslandWindowState.TempHiddenType SCREEN_LOCKED;
    public static final /* enum */ DynamicIslandWindowState.TempHiddenType SCREEN_PINNING_ACTIVE;
    public static final /* enum */ DynamicIslandWindowState.TempHiddenType SHOW_NOTIFICATION_ICONS;
    public static final /* enum */ DynamicIslandWindowState.TempHiddenType SHOW_ONCE_PROP_ISLAND;
    public static final /* enum */ DynamicIslandWindowState.TempHiddenType STATUS_BAR_DISAPPEARANCE;

    private static final /* synthetic */ DynamicIslandWindowState.TempHiddenType[] $values() {
        return new DynamicIslandWindowState.TempHiddenType[]{SCREEN_LOCKED, NOTIFICATION_APPEARANCE, NOTIFICATION_SWIPE_TO_APPEARANCE, MIPLAY_SHOW, CONTROL_CENTER_EXPANDED, CONTROL_CENTER_SWIPE_TO_APPEARANCE, STATUS_BAR_DISAPPEARANCE, DESKTOP_ANIMATING, SCREEN_PINNING_ACTIVE, SHOW_NOTIFICATION_ICONS, SHOW_ONCE_PROP_ISLAND, BOUNCER_SHOWING};
    }

    static {
        SCREEN_LOCKED = new DynamicIslandWindowState.TempHiddenType();
        NOTIFICATION_APPEARANCE = new DynamicIslandWindowState.TempHiddenType();
        NOTIFICATION_SWIPE_TO_APPEARANCE = new DynamicIslandWindowState.TempHiddenType();
        MIPLAY_SHOW = new DynamicIslandWindowState.TempHiddenType();
        CONTROL_CENTER_EXPANDED = new DynamicIslandWindowState.TempHiddenType();
        CONTROL_CENTER_SWIPE_TO_APPEARANCE = new DynamicIslandWindowState.TempHiddenType();
        STATUS_BAR_DISAPPEARANCE = new DynamicIslandWindowState.TempHiddenType();
        DESKTOP_ANIMATING = new DynamicIslandWindowState.TempHiddenType();
        SCREEN_PINNING_ACTIVE = new DynamicIslandWindowState.TempHiddenType();
        SHOW_NOTIFICATION_ICONS = new DynamicIslandWindowState.TempHiddenType();
        SHOW_ONCE_PROP_ISLAND = new DynamicIslandWindowState.TempHiddenType();
        BOUNCER_SHOWING = new DynamicIslandWindowState.TempHiddenType();
        Enum[] enumArray = DynamicIslandWindowState.TempHiddenType.$values();
        $VALUES = enumArray;
        $ENTRIES = b.a((Enum[])enumArray);
    }

    public static a getEntries() {
        return $ENTRIES;
    }

    public static DynamicIslandWindowState.TempHiddenType valueOf(String string) {
        return Enum.valueOf(DynamicIslandWindowState.TempHiddenType.class, string);
    }

    public static DynamicIslandWindowState.TempHiddenType[] values() {
        return (DynamicIslandWindowState.TempHiddenType[])$VALUES.clone();
    }
}
