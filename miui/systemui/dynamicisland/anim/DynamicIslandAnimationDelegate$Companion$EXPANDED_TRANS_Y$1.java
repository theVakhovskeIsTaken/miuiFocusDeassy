/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.internal.o
 *  miuix.animation.property.FloatProperty
 */
package miui.systemui.dynamicisland.anim;

import kotlin.jvm.internal.o;
import miui.systemui.dynamicisland.anim.DynamicIslandAnimationDelegate;
import miuix.animation.property.FloatProperty;

public static final class DynamicIslandAnimationDelegate.EXPANDED_TRANS_Y.1
extends FloatProperty<DynamicIslandAnimationDelegate> {
    public DynamicIslandAnimationDelegate.EXPANDED_TRANS_Y.1() {
        super("dynamic_expanded_trans_y", 1.0f);
    }

    public float getValue(DynamicIslandAnimationDelegate dynamicIslandAnimationDelegate) {
        o.g((Object)dynamicIslandAnimationDelegate, (String)"holder");
        return dynamicIslandAnimationDelegate.expandedTransY;
    }

    public void setValue(DynamicIslandAnimationDelegate dynamicIslandAnimationDelegate, float f) {
        o.g((Object)dynamicIslandAnimationDelegate, (String)"holder");
        if (Float.isNaN(f)) {
            return;
        }
        dynamicIslandAnimationDelegate.expandedTransY = f;
    }
}
