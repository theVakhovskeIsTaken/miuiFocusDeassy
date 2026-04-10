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
import miui.systemui.dynamicisland.window.content.DynamicIslandBaseContentView;
import miui.systemui.dynamicisland.window.content.DynamicIslandContentFakeView;
import miui.systemui.dynamicisland.window.content.DynamicIslandContentView;
import miuix.animation.listener.TransitionListener;
import miuix.animation.listener.UpdateInfo;

public static final class DynamicIslandAnimationDelegate.animToFakeSmallIslandView.1
extends TransitionListener {
    final DynamicIslandContentView $view;
    final DynamicIslandAnimationDelegate this$0;

    public DynamicIslandAnimationDelegate.animToFakeSmallIslandView.1(DynamicIslandContentView dynamicIslandContentView, DynamicIslandAnimationDelegate dynamicIslandAnimationDelegate) {
        this.$view = dynamicIslandContentView;
        this.this$0 = dynamicIslandAnimationDelegate;
    }

    public void onBegin(Object object) {
        super.onBegin(object);
        object = this.$view.getFakeView();
        Object var2_2 = null;
        object = object != null ? ((DynamicIslandBaseContentView)((Object)object)).getFakeSmallIsland() : null;
        if (object != null) {
            object.setAlpha(0.0f);
        }
        DynamicIslandContentFakeView dynamicIslandContentFakeView = this.$view.getFakeView();
        object = var2_2;
        if (dynamicIslandContentFakeView != null) {
            object = dynamicIslandContentFakeView.getFakeSmallIsland();
        }
        if (object != null) {
            object.setVisibility(0);
        }
    }

    public void onComplete(Object object) {
        super.onComplete(object);
        this.this$0.fakeViewAnimating = false;
        object = this.$view.getFakeView();
        Object var2_2 = null;
        object = object != null ? ((DynamicIslandBaseContentView)((Object)object)).getFakeBigIsland() : null;
        if (object != null) {
            object.setVisibility(4);
        }
        DynamicIslandContentFakeView dynamicIslandContentFakeView = this.$view.getFakeView();
        object = var2_2;
        if (dynamicIslandContentFakeView != null) {
            object = dynamicIslandContentFakeView.getFakeExpandedView();
        }
        if (object != null) {
            object.setVisibility(4);
        }
    }

    public void onUpdate(Object object, Collection<UpdateInfo> collection) {
        super.onUpdate(object, collection);
        this.this$0.scheduleUpdate();
    }
}
