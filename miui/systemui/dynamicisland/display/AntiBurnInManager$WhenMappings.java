/*
 * Decompiled with CFR 0.152.
 */
package miui.systemui.dynamicisland.display;

import miui.systemui.dynamicisland.display.AntiBurnInManager;

public final class AntiBurnInManager.WhenMappings {
    public static final int[] $EnumSwitchMapping$0;

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    static {
        int[] nArray = new int[AntiBurnInManager.BurnInStates.values().length];
        try {
            nArray[AntiBurnInManager.BurnInStates.BurnIn.ordinal()] = 1;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray[AntiBurnInManager.BurnInStates.Normal.ordinal()] = 2;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray[AntiBurnInManager.BurnInStates.TempRestore.ordinal()] = 3;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        $EnumSwitchMapping$0 = nArray;
    }
}
