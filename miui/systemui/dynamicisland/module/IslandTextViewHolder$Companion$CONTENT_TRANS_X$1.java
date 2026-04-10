/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.internal.o
 *  miuix.animation.property.FloatProperty
 */
package miui.systemui.dynamicisland.module;

import kotlin.jvm.internal.o;
import miui.systemui.dynamicisland.module.IslandTextViewHolder;
import miuix.animation.property.FloatProperty;

public static final class IslandTextViewHolder.CONTENT_TRANS_X.1
extends FloatProperty<IslandTextViewHolder> {
    public IslandTextViewHolder.CONTENT_TRANS_X.1() {
        super("dynamic_content_trans_x", 0.01f);
    }

    public float getValue(IslandTextViewHolder islandTextViewHolder) {
        o.g((Object)islandTextViewHolder, (String)"holder");
        return islandTextViewHolder.contentTransX;
    }

    public void setValue(IslandTextViewHolder islandTextViewHolder, float f) {
        o.g((Object)islandTextViewHolder, (String)"holder");
        if (Float.isNaN(f)) {
            return;
        }
        islandTextViewHolder.contentTransX = f;
    }
}
