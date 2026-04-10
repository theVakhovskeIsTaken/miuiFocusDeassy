/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.internal.o
 *  miuix.animation.property.FloatProperty
 */
package miui.systemui.dynamicisland.module;

import kotlin.jvm.internal.o;
import miui.systemui.dynamicisland.module.IslandRightTextViewHolder;
import miuix.animation.property.FloatProperty;

public static final class IslandRightTextViewHolder.CONTENT_TRANS_X.1
extends FloatProperty<IslandRightTextViewHolder> {
    public IslandRightTextViewHolder.CONTENT_TRANS_X.1() {
        super("dynamic_content_trans_x", 0.01f);
    }

    public float getValue(IslandRightTextViewHolder islandRightTextViewHolder) {
        o.g((Object)islandRightTextViewHolder, (String)"holder");
        return islandRightTextViewHolder.contentTransX;
    }

    public void setValue(IslandRightTextViewHolder islandRightTextViewHolder, float f) {
        o.g((Object)islandRightTextViewHolder, (String)"holder");
        if (Float.isNaN(f)) {
            return;
        }
        islandRightTextViewHolder.contentTransX = f;
    }
}
