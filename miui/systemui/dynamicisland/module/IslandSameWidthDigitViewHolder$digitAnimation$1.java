/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  miuix.animation.listener.TransitionListener
 *  miuix.animation.listener.UpdateInfo
 */
package miui.systemui.dynamicisland.module;

import java.util.Collection;
import miui.systemui.dynamicisland.module.IslandSameWidthDigitViewHolder;
import miuix.animation.listener.TransitionListener;
import miuix.animation.listener.UpdateInfo;

public static final class IslandSameWidthDigitViewHolder.digitAnimation.1
extends TransitionListener {
    final IslandSameWidthDigitViewHolder this$0;

    public IslandSameWidthDigitViewHolder.digitAnimation.1(IslandSameWidthDigitViewHolder islandSameWidthDigitViewHolder) {
        this.this$0 = islandSameWidthDigitViewHolder;
    }

    public void onUpdate(Object object, Collection<UpdateInfo> collection) {
        this.this$0.scheduleUpdate();
    }
}
