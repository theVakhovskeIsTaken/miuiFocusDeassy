/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.internal.o
 *  miuix.animation.property.FloatProperty
 */
package miui.systemui.dynamicisland.module;

import kotlin.jvm.internal.o;
import miui.systemui.dynamicisland.module.IslandImageTextView3Holder;
import miuix.animation.property.FloatProperty;

public static final class IslandImageTextView3Holder.ICON_TRANS_X.1
extends FloatProperty<IslandImageTextView3Holder> {
    public IslandImageTextView3Holder.ICON_TRANS_X.1() {
        super("dynamic_icon_trans_x", 0.01f);
    }

    public float getValue(IslandImageTextView3Holder islandImageTextView3Holder) {
        o.g((Object)islandImageTextView3Holder, (String)"holder");
        return islandImageTextView3Holder.iconTransX;
    }

    public void setValue(IslandImageTextView3Holder islandImageTextView3Holder, float f) {
        o.g((Object)islandImageTextView3Holder, (String)"holder");
        if (Float.isNaN(f)) {
            return;
        }
        islandImageTextView3Holder.iconTransX = f;
    }
}
