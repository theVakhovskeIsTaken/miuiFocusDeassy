/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  miuix.animation.listener.TransitionListener
 */
package miui.systemui.dynamicisland.anim;

import miui.systemui.dynamicisland.window.content.DynamicIslandBaseContentView;
import miui.systemui.dynamicisland.window.content.DynamicIslandContentFakeView;
import miui.systemui.dynamicisland.window.content.DynamicIslandContentView;
import miuix.animation.listener.TransitionListener;

public static final class DynamicIslandAnimationDelegate.fakeViewToTempHiddenAnimation.1
extends TransitionListener {
    final DynamicIslandContentView $view;

    public DynamicIslandAnimationDelegate.fakeViewToTempHiddenAnimation.1(DynamicIslandContentView dynamicIslandContentView) {
        this.$view = dynamicIslandContentView;
    }

    public void onComplete(Object object) {
        super.onComplete(object);
        object = this.$view.getFakeView();
        if (object != null) {
            ((DynamicIslandContentFakeView)((Object)object)).setVisibility(4);
        }
        object = this.$view.getFakeView();
        object = object != null ? ((DynamicIslandBaseContentView)((Object)object)).getFakeContainer() : null;
        if (object != null) {
            object.setAlpha(1.0f);
        }
    }
}
