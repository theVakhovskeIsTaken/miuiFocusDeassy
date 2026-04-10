/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.internal.o
 *  miuix.animation.property.FloatProperty
 */
package miui.systemui.dynamicisland.module;

import kotlin.jvm.internal.o;
import miui.systemui.dynamicisland.module.IslandIconFixedWidthTextHolder;
import miuix.animation.property.FloatProperty;

public static final class IslandIconFixedWidthTextHolder.CONTENT_TRANS_Y.1
extends FloatProperty<IslandIconFixedWidthTextHolder> {
    public IslandIconFixedWidthTextHolder.CONTENT_TRANS_Y.1() {
        super("dynamic_content_trans_y", 0.01f);
    }

    public float getValue(IslandIconFixedWidthTextHolder islandIconFixedWidthTextHolder) {
        o.g((Object)islandIconFixedWidthTextHolder, (String)"holder");
        return islandIconFixedWidthTextHolder.contentTransY;
    }

    public void setValue(IslandIconFixedWidthTextHolder islandIconFixedWidthTextHolder, float f) {
        o.g((Object)islandIconFixedWidthTextHolder, (String)"holder");
        if (Float.isNaN(f)) {
            return;
        }
        islandIconFixedWidthTextHolder.contentTransY = f;
    }
}
