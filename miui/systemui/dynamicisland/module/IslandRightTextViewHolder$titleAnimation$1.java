/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  miuix.animation.listener.TransitionListener
 *  miuix.animation.listener.UpdateInfo
 */
package miui.systemui.dynamicisland.module;

import java.util.Collection;
import miui.systemui.dynamicisland.module.IslandRightTextViewHolder;
import miuix.animation.listener.TransitionListener;
import miuix.animation.listener.UpdateInfo;

public static final class IslandRightTextViewHolder.titleAnimation.1
extends TransitionListener {
    final IslandRightTextViewHolder this$0;

    public IslandRightTextViewHolder.titleAnimation.1(IslandRightTextViewHolder islandRightTextViewHolder) {
        this.this$0 = islandRightTextViewHolder;
    }

    public void onUpdate(Object object, Collection<UpdateInfo> collection) {
        this.this$0.scheduleUpdate();
    }
}
