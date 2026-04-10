/*
 * Decompiled with CFR 0.152.
 */
package miui.systemui.dynamicisland.device.strategy;

import miui.systemui.dynamicisland.anim.DynamicIslandAnimationType;

public final class PhoneDynamicIslandAnimationDelegateHelper.WhenMappings {
    public static final int[] $EnumSwitchMapping$0;

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    static {
        int[] nArray = new int[DynamicIslandAnimationType.values().length];
        try {
            nArray[DynamicIslandAnimationType.EXPANDED_CHANGED.ordinal()] = 1;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray[DynamicIslandAnimationType.INIT_TO_EXPANDED.ordinal()] = 2;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray[DynamicIslandAnimationType.SMALL_TO_EXPANDED.ordinal()] = 3;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray[DynamicIslandAnimationType.BIG_TO_EXPANDED.ordinal()] = 4;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray[DynamicIslandAnimationType.INIT_TO_BIG.ordinal()] = 5;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray[DynamicIslandAnimationType.EXPANDED_TO_BIG.ordinal()] = 6;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray[DynamicIslandAnimationType.EXPANDED_TO_DELETED.ordinal()] = 7;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray[DynamicIslandAnimationType.EXPANDED_TO_HIDDEN.ordinal()] = 8;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray[DynamicIslandAnimationType.EXPANDED_TO_APP_EXPANDED.ordinal()] = 9;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray[DynamicIslandAnimationType.EXPANDED_TO_MINI_WINDOW.ordinal()] = 10;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray[DynamicIslandAnimationType.EXPANDED_TO_SMALL.ordinal()] = 11;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray[DynamicIslandAnimationType.EXPANDED_TO_TEMP_HIDDEN.ordinal()] = 12;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray[DynamicIslandAnimationType.BIG_TO_DELETED.ordinal()] = 13;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray[DynamicIslandAnimationType.BIG_TO_TEMP_HIDDEN.ordinal()] = 14;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray[DynamicIslandAnimationType.TEMP_HIDDEN_TO_BIG.ordinal()] = 15;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        $EnumSwitchMapping$0 = nArray;
    }
}
