/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.annotation.RequiresApi
 *  kotlin.jvm.internal.o
 *  miuix.animation.property.FloatProperty
 */
package miui.systemui.dynamicisland.window.content;

import androidx.annotation.RequiresApi;
import kotlin.jvm.internal.o;
import miui.systemui.dynamicisland.window.content.DynamicIslandContentView;
import miuix.animation.property.FloatProperty;

public static final class DynamicIslandContentView.CONTAINER_BG_ALPHA.1
extends FloatProperty<DynamicIslandContentView> {
    public DynamicIslandContentView.CONTAINER_BG_ALPHA.1() {
        super("container_bg_alpha", 0.4f);
    }

    @RequiresApi(value=19)
    public float getValue(DynamicIslandContentView dynamicIslandContentView) {
        o.g((Object)((Object)dynamicIslandContentView), (String)"view");
        return dynamicIslandContentView.getContainerBgAlpha();
    }

    public void setValue(DynamicIslandContentView dynamicIslandContentView, float f) {
        o.g((Object)((Object)dynamicIslandContentView), (String)"view");
        if (Float.isNaN(f)) {
            return;
        }
        dynamicIslandContentView.setContainerBgAlpha(f);
    }
}
