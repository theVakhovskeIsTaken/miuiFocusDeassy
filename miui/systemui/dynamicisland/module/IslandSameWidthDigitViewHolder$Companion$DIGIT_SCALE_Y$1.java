/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.internal.o
 *  miuix.animation.property.FloatProperty
 */
package miui.systemui.dynamicisland.module;

import kotlin.jvm.internal.o;
import miui.systemui.dynamicisland.module.IslandSameWidthDigitViewHolder;
import miuix.animation.property.FloatProperty;

public static final class IslandSameWidthDigitViewHolder.DIGIT_SCALE_Y.1
extends FloatProperty<IslandSameWidthDigitViewHolder> {
    public IslandSameWidthDigitViewHolder.DIGIT_SCALE_Y.1() {
        super("dynamic_digit_scale_y", 0.01f);
    }

    public float getValue(IslandSameWidthDigitViewHolder islandSameWidthDigitViewHolder) {
        o.g((Object)islandSameWidthDigitViewHolder, (String)"holder");
        return islandSameWidthDigitViewHolder.digitScaleY;
    }

    public void setValue(IslandSameWidthDigitViewHolder islandSameWidthDigitViewHolder, float f) {
        o.g((Object)islandSameWidthDigitViewHolder, (String)"holder");
        if (Float.isNaN(f)) {
            return;
        }
        islandSameWidthDigitViewHolder.digitScaleY = f;
    }
}
