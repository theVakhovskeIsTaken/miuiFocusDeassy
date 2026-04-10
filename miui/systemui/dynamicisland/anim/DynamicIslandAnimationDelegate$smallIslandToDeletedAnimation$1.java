/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  miuix.animation.listener.UpdateInfo
 */
package miui.systemui.dynamicisland.anim;

import java.util.Collection;
import miui.systemui.dynamicisland.DynamicIslandScenarioUtils;
import miui.systemui.dynamicisland.anim.DynamicIslandAnimListener;
import miui.systemui.dynamicisland.anim.DynamicIslandAnimationDelegate;
import miui.systemui.dynamicisland.window.content.DynamicIslandContentView;
import miuix.animation.listener.UpdateInfo;

public static final class DynamicIslandAnimationDelegate.smallIslandToDeletedAnimation.1
extends DynamicIslandAnimListener {
    final DynamicIslandContentView $view;
    final DynamicIslandAnimationDelegate this$0;

    public DynamicIslandAnimationDelegate.smallIslandToDeletedAnimation.1(DynamicIslandAnimationDelegate dynamicIslandAnimationDelegate, DynamicIslandContentView dynamicIslandContentView) {
        this.this$0 = dynamicIslandAnimationDelegate;
        this.$view = dynamicIslandContentView;
        super(dynamicIslandAnimationDelegate);
    }

    public void onBegin(Object object, Collection<? extends UpdateInfo> collection) {
        super.onBegin(object, collection);
        DynamicIslandScenarioUtils.INSTANCE.setDynamicIslandScenarioState(439L, true);
    }

    @Override
    public void onCancel(Object object) {
        super.onCancel(object);
        DynamicIslandScenarioUtils.INSTANCE.setDynamicIslandScenarioState(439L, false);
        DynamicIslandAnimationDelegate.removeViewFromWindow$default(this.this$0, this.$view, false, 2, null);
    }

    @Override
    public void onComplete(Object object) {
        super.onComplete(object);
        DynamicIslandScenarioUtils.INSTANCE.setDynamicIslandScenarioState(439L, false);
        DynamicIslandAnimationDelegate.removeViewFromWindow$default(this.this$0, this.$view, false, 2, null);
    }
}
