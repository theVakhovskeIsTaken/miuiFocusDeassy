/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.internal.o
 *  miuix.animation.property.FloatProperty
 */
package miui.systemui.dynamicisland.window.content;

import kotlin.jvm.internal.o;
import miui.systemui.dynamicisland.window.content.DynamicIslandContentView;
import miuix.animation.property.FloatProperty;

public static final class DynamicIslandContentView.SHADOW_ALPHA.1
extends FloatProperty<DynamicIslandContentView> {
    public DynamicIslandContentView.SHADOW_ALPHA.1() {
        super("dynamic_island_shadow_alpha", 0.00390625f);
    }

    public float getValue(DynamicIslandContentView dynamicIslandContentView) {
        o.g((Object)((Object)dynamicIslandContentView), (String)"view");
        return dynamicIslandContentView.shadowAlpha;
    }

    public void setValue(DynamicIslandContentView dynamicIslandContentView, float f) {
        o.g((Object)((Object)dynamicIslandContentView), (String)"view");
        if (Float.isNaN(f)) {
            return;
        }
        dynamicIslandContentView.setShadowAlpha(f);
    }
}
