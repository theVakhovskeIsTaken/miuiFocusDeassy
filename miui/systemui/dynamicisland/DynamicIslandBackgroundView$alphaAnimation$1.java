/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  miuix.animation.listener.TransitionListener
 *  miuix.animation.listener.UpdateInfo
 */
package miui.systemui.dynamicisland;

import java.util.Collection;
import miui.systemui.dynamicisland.DynamicIslandBackgroundView;
import miuix.animation.listener.TransitionListener;
import miuix.animation.listener.UpdateInfo;

public static final class DynamicIslandBackgroundView.alphaAnimation.1
extends TransitionListener {
    final DynamicIslandBackgroundView this$0;

    public DynamicIslandBackgroundView.alphaAnimation.1(DynamicIslandBackgroundView dynamicIslandBackgroundView) {
        this.this$0 = dynamicIslandBackgroundView;
    }

    public void onUpdate(Object object, Collection<UpdateInfo> collection) {
        this.this$0.scheduleUpdate();
    }
}
