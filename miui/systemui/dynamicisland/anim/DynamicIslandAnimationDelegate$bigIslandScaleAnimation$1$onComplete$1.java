/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  miuix.animation.listener.TransitionListener
 *  miuix.animation.listener.UpdateInfo
 */
package miui.systemui.dynamicisland.anim;

import java.util.Collection;
import miui.systemui.dynamicisland.anim.DynamicIslandAnimationDelegate;
import miuix.animation.listener.TransitionListener;
import miuix.animation.listener.UpdateInfo;

public static final class DynamicIslandAnimationDelegate.bigIslandScaleAnimation.1.onComplete.1
extends TransitionListener {
    final DynamicIslandAnimationDelegate this$0;

    public DynamicIslandAnimationDelegate.bigIslandScaleAnimation.1.onComplete.1(DynamicIslandAnimationDelegate dynamicIslandAnimationDelegate) {
        this.this$0 = dynamicIslandAnimationDelegate;
    }

    public void onUpdate(Object object, Collection<UpdateInfo> collection) {
        super.onUpdate(object, collection);
        this.this$0.scheduleUpdate();
    }
}
