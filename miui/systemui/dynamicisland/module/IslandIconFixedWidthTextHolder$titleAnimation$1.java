/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  miuix.animation.listener.TransitionListener
 *  miuix.animation.listener.UpdateInfo
 */
package miui.systemui.dynamicisland.module;

import java.util.Collection;
import miui.systemui.dynamicisland.module.IslandIconFixedWidthTextHolder;
import miuix.animation.listener.TransitionListener;
import miuix.animation.listener.UpdateInfo;

public static final class IslandIconFixedWidthTextHolder.titleAnimation.1
extends TransitionListener {
    final IslandIconFixedWidthTextHolder this$0;

    public IslandIconFixedWidthTextHolder.titleAnimation.1(IslandIconFixedWidthTextHolder islandIconFixedWidthTextHolder) {
        this.this$0 = islandIconFixedWidthTextHolder;
    }

    public void onUpdate(Object object, Collection<UpdateInfo> collection) {
        this.this$0.scheduleUpdate();
    }
}
