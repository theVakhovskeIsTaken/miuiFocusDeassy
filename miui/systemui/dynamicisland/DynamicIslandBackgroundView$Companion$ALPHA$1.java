/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.internal.o
 *  miuix.animation.property.FloatProperty
 */
package miui.systemui.dynamicisland;

import kotlin.jvm.internal.o;
import miui.systemui.dynamicisland.DynamicIslandBackgroundView;
import miuix.animation.property.FloatProperty;

public static final class DynamicIslandBackgroundView.ALPHA.1
extends FloatProperty<DynamicIslandBackgroundView> {
    public DynamicIslandBackgroundView.ALPHA.1() {
        super("alpha", 0.1f);
    }

    public float getValue(DynamicIslandBackgroundView dynamicIslandBackgroundView) {
        o.g((Object)((Object)dynamicIslandBackgroundView), (String)"view");
        return dynamicIslandBackgroundView.backgroundAlpha;
    }

    public void setValue(DynamicIslandBackgroundView dynamicIslandBackgroundView, float f) {
        o.g((Object)((Object)dynamicIslandBackgroundView), (String)"view");
        if (Float.isNaN(f)) {
            return;
        }
        dynamicIslandBackgroundView.backgroundAlpha = f;
    }
}
