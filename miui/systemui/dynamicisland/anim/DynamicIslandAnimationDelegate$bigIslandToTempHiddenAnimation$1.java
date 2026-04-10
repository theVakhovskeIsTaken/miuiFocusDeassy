/*
 * Decompiled with CFR 0.152.
 */
package miui.systemui.dynamicisland.anim;

import miui.systemui.dynamicisland.DynamicIslandScenarioUtils;
import miui.systemui.dynamicisland.anim.DynamicIslandAnimListener;
import miui.systemui.dynamicisland.anim.DynamicIslandAnimationDelegate;
import miui.systemui.dynamicisland.anim.DynamicIslandAnimationType;
import miui.systemui.dynamicisland.window.DynamicIslandWindowState;
import miui.systemui.dynamicisland.window.content.DynamicIslandContentView;

public static final class DynamicIslandAnimationDelegate.bigIslandToTempHiddenAnimation.1
extends DynamicIslandAnimListener {
    final DynamicIslandContentView $view;
    final DynamicIslandAnimationDelegate this$0;

    public DynamicIslandAnimationDelegate.bigIslandToTempHiddenAnimation.1(DynamicIslandAnimationDelegate dynamicIslandAnimationDelegate, DynamicIslandContentView dynamicIslandContentView) {
        this.this$0 = dynamicIslandAnimationDelegate;
        this.$view = dynamicIslandContentView;
        super(dynamicIslandAnimationDelegate);
    }

    @Override
    public void onBegin(Object object) {
        super.onBegin(object);
        object = this.$view.getWindowState();
        if (!(object == null || ((DynamicIslandWindowState)object).getKeyguardShowing() || (object = this.$view.getWindowState()) == null || (object = ((DynamicIslandWindowState)object).getScreenPinning()) == null || ((Boolean)object.getValue()).booleanValue() || this.this$0.getIslandWindowAnimRunning())) {
            this.this$0.setViewVisible(this.$view, 0);
        }
        this.this$0.animationDelegateHelper.requestUpdateHeadsUpLocation(DynamicIslandAnimationType.BIG_TO_TEMP_HIDDEN, this.$view);
        DynamicIslandScenarioUtils.INSTANCE.setDynamicIslandScenarioState(435L, true);
    }

    @Override
    public void onCancel(Object object) {
        super.onCancel(object);
        DynamicIslandScenarioUtils.INSTANCE.setDynamicIslandScenarioState(435L, false);
    }

    @Override
    public void onComplete(Object object) {
        super.onComplete(object);
        object = this.$view.getExpandedView();
        if (object != null) {
            object.setVisibility(4);
        }
        DynamicIslandScenarioUtils.INSTANCE.setDynamicIslandScenarioState(435L, false);
    }
}
