/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  miuix.animation.listener.TransitionListener
 *  miuix.animation.listener.UpdateInfo
 */
package miui.systemui.dynamicisland.module;

import java.util.Collection;
import miui.systemui.dynamicisland.module.IslandTextViewHolder;
import miuix.animation.listener.TransitionListener;
import miuix.animation.listener.UpdateInfo;

public static final class IslandTextViewHolder.contentAnimation.1
extends TransitionListener {
    final IslandTextViewHolder this$0;

    public IslandTextViewHolder.contentAnimation.1(IslandTextViewHolder islandTextViewHolder) {
        this.this$0 = islandTextViewHolder;
    }

    public void onUpdate(Object object, Collection<UpdateInfo> collection) {
        this.this$0.scheduleUpdate();
    }
}
