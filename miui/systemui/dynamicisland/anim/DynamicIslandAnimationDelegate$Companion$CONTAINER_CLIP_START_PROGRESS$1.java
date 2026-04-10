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

public static final class DynamicIslandAnimationDelegate.CONTAINER_CLIP_START_PROGRESS.1
extends FloatProperty<DynamicIslandAnimationDelegate> {
    public DynamicIslandAnimationDelegate.CONTAINER_CLIP_START_PROGRESS.1() {
        super("dynamic_container_clip_start_progress", 1.0f);
    }

    public float getValue(DynamicIslandAnimationDelegate dynamicIslandAnimationDelegate) {
        o.g((Object)dynamicIslandAnimationDelegate, (String)"holder");
        return dynamicIslandAnimationDelegate.containerClipStartProgress;
    }

    public void setValue(DynamicIslandAnimationDelegate dynamicIslandAnimationDelegate, float f) {
        o.g((Object)dynamicIslandAnimationDelegate, (String)"holder");
        if (Float.isNaN(f)) {
            return;
        }
        dynamicIslandAnimationDelegate.containerClipStartProgress = f;
    }
}
