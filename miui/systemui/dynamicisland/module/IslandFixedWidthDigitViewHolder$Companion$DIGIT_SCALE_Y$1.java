/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.internal.o
 *  miuix.animation.property.FloatProperty
 */
package miui.systemui.dynamicisland.module;

import kotlin.jvm.internal.o;
import miui.systemui.dynamicisland.module.IslandFixedWidthDigitViewHolder;
import miuix.animation.property.FloatProperty;

public static final class IslandFixedWidthDigitViewHolder.DIGIT_SCALE_Y.1
extends FloatProperty<IslandFixedWidthDigitViewHolder> {
    public IslandFixedWidthDigitViewHolder.DIGIT_SCALE_Y.1() {
        super("dynamic_digit_scale_y", 0.01f);
    }

    public float getValue(IslandFixedWidthDigitViewHolder islandFixedWidthDigitViewHolder) {
        o.g((Object)islandFixedWidthDigitViewHolder, (String)"holder");
        return islandFixedWidthDigitViewHolder.digitScaleY;
    }

    public void setValue(IslandFixedWidthDigitViewHolder islandFixedWidthDigitViewHolder, float f) {
        o.g((Object)islandFixedWidthDigitViewHolder, (String)"holder");
        if (Float.isNaN(f)) {
            return;
        }
        islandFixedWidthDigitViewHolder.digitScaleY = f;
    }
}
