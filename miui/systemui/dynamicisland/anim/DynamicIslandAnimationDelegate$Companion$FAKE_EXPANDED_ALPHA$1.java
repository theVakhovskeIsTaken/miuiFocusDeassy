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

public static final class DynamicIslandAnimationDelegate.FAKE_EXPANDED_ALPHA.1
extends FloatProperty<DynamicIslandAnimationDelegate> {
    public DynamicIslandAnimationDelegate.FAKE_EXPANDED_ALPHA.1() {
        super("dynamic_fake_expanded_alpha", 0.00390625f);
    }

    public float getValue(DynamicIslandAnimationDelegate dynamicIslandAnimationDelegate) {
        o.g((Object)dynamicIslandAnimationDelegate, (String)"holder");
        return dynamicIslandAnimationDelegate.fakeExpandedAlpha;
    }

    public void setValue(DynamicIslandAnimationDelegate dynamicIslandAnimationDelegate, float f) {
        o.g((Object)dynamicIslandAnimationDelegate, (String)"holder");
        if (Float.isNaN(f)) {
            return;
        }
        dynamicIslandAnimationDelegate.fakeExpandedAlpha = f;
    }
}
