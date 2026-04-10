/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  N0.a
 *  N0.b
 */
package miui.systemui.dynamicisland.display;

import N0.a;
import N0.b;

public static final class AntiBurnInManager.BurnInStates
extends Enum<AntiBurnInManager.BurnInStates> {
    private static final a $ENTRIES;
    private static final AntiBurnInManager.BurnInStates[] $VALUES;
    public static final /* enum */ AntiBurnInManager.BurnInStates BurnIn;
    public static final /* enum */ AntiBurnInManager.BurnInStates Normal;
    public static final /* enum */ AntiBurnInManager.BurnInStates PauseExpose;
    public static final /* enum */ AntiBurnInManager.BurnInStates Stop;
    public static final /* enum */ AntiBurnInManager.BurnInStates TempRestore;

    private static final /* synthetic */ AntiBurnInManager.BurnInStates[] $values() {
        return new AntiBurnInManager.BurnInStates[]{Normal, BurnIn, TempRestore, PauseExpose, Stop};
    }

    static {
        Normal = new AntiBurnInManager.BurnInStates();
        BurnIn = new AntiBurnInManager.BurnInStates();
        TempRestore = new AntiBurnInManager.BurnInStates();
        PauseExpose = new AntiBurnInManager.BurnInStates();
        Stop = new AntiBurnInManager.BurnInStates();
        Enum[] enumArray = AntiBurnInManager.BurnInStates.$values();
        $VALUES = enumArray;
        $ENTRIES = b.a((Enum[])enumArray);
    }

    public static a getEntries() {
        return $ENTRIES;
    }

    public static AntiBurnInManager.BurnInStates valueOf(String string) {
        return Enum.valueOf(AntiBurnInManager.BurnInStates.class, string);
    }

    public static AntiBurnInManager.BurnInStates[] values() {
        return (AntiBurnInManager.BurnInStates[])$VALUES.clone();
    }
}
