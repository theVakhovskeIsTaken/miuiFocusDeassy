/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.internal.o
 *  miuix.animation.property.ColorProperty
 */
package miui.systemui.dynamicisland.anim;

import kotlin.jvm.internal.o;
import miui.systemui.dynamicisland.anim.DynamicIslandAnimationDelegate;
import miuix.animation.property.ColorProperty;

public static final class DynamicIslandAnimationDelegate.CONTAINER_BACKGROUND_COLOR.1
extends ColorProperty<DynamicIslandAnimationDelegate> {
    public DynamicIslandAnimationDelegate.CONTAINER_BACKGROUND_COLOR.1() {
        super("dynamic_container_background_color");
    }

    public void setIntValue(DynamicIslandAnimationDelegate dynamicIslandAnimationDelegate, int n) {
        o.g((Object)dynamicIslandAnimationDelegate, (String)"holder");
        super.setIntValue((Object)dynamicIslandAnimationDelegate, n);
        dynamicIslandAnimationDelegate.containerBackgroundColor = n;
    }
}
