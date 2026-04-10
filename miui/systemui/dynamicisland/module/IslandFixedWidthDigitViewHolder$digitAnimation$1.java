/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  miuix.animation.listener.TransitionListener
 *  miuix.animation.listener.UpdateInfo
 */
package miui.systemui.dynamicisland.module;

import java.util.Collection;
import miui.systemui.dynamicisland.module.IslandFixedWidthDigitViewHolder;
import miuix.animation.listener.TransitionListener;
import miuix.animation.listener.UpdateInfo;

public static final class IslandFixedWidthDigitViewHolder.digitAnimation.1
extends TransitionListener {
    final IslandFixedWidthDigitViewHolder this$0;

    public IslandFixedWidthDigitViewHolder.digitAnimation.1(IslandFixedWidthDigitViewHolder islandFixedWidthDigitViewHolder) {
        this.this$0 = islandFixedWidthDigitViewHolder;
    }

    public void onUpdate(Object object, Collection<UpdateInfo> collection) {
        this.this$0.scheduleUpdate();
    }
}
