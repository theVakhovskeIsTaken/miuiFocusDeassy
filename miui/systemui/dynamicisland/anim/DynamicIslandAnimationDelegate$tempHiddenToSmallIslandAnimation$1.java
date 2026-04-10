/*
 * Decompiled with CFR 0.152.
 */
package miui.systemui.dynamicisland.anim;

import miui.systemui.dynamicisland.DynamicIslandScenarioUtils;
import miui.systemui.dynamicisland.anim.DynamicIslandAnimListener;
import miui.systemui.dynamicisland.anim.DynamicIslandAnimationDelegate;
import miui.systemui.dynamicisland.window.content.DynamicIslandContentView;

public static final class DynamicIslandAnimationDelegate.tempHiddenToSmallIslandAnimation.1
extends DynamicIslandAnimListener {
    final DynamicIslandContentView $view;

    public DynamicIslandAnimationDelegate.tempHiddenToSmallIslandAnimation.1(DynamicIslandAnimationDelegate dynamicIslandAnimationDelegate, DynamicIslandContentView dynamicIslandContentView) {
        this.$view = dynamicIslandContentView;
        super(dynamicIslandAnimationDelegate);
    }

    @Override
    public void onBegin(Object object) {
        super.onBegin(object);
        object = this.$view.getSmallIslandView();
        if (object != null) {
            object.setVisibility(0);
        }
        DynamicIslandScenarioUtils.INSTANCE.setDynamicIslandScenarioState(438L, true);
    }

    @Override
    public void onCancel(Object object) {
        super.onCancel(object);
        DynamicIslandScenarioUtils.INSTANCE.setDynamicIslandScenarioState(438L, false);
    }

    @Override
    public void onComplete(Object object) {
        super.onComplete(object);
        DynamicIslandScenarioUtils.INSTANCE.setDynamicIslandScenarioState(438L, false);
    }
}
