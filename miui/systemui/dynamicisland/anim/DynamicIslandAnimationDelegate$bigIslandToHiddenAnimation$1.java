/*
 * Decompiled with CFR 0.152.
 */
package miui.systemui.dynamicisland.anim;

import miui.systemui.dynamicisland.DynamicIslandScenarioUtils;
import miui.systemui.dynamicisland.anim.DynamicIslandAnimListener;
import miui.systemui.dynamicisland.anim.DynamicIslandAnimationDelegate;
import miui.systemui.dynamicisland.window.content.DynamicIslandContentFakeView;
import miui.systemui.dynamicisland.window.content.DynamicIslandContentView;

public static final class DynamicIslandAnimationDelegate.bigIslandToHiddenAnimation.1
extends DynamicIslandAnimListener {
    final DynamicIslandContentView $view;
    final DynamicIslandAnimationDelegate this$0;

    public DynamicIslandAnimationDelegate.bigIslandToHiddenAnimation.1(DynamicIslandAnimationDelegate dynamicIslandAnimationDelegate, DynamicIslandContentView dynamicIslandContentView) {
        this.this$0 = dynamicIslandAnimationDelegate;
        this.$view = dynamicIslandContentView;
        super(dynamicIslandAnimationDelegate);
    }

    @Override
    public void onBegin(Object object) {
        super.onBegin(object);
        this.this$0.setViewVisible(this.$view, 0);
        object = this.this$0.getFakeView();
        if (object != null) {
            ((DynamicIslandContentFakeView)((Object)object)).setVisibility(4);
        }
        DynamicIslandScenarioUtils.INSTANCE.setDynamicIslandScenarioState(435L, true);
    }

    @Override
    public void onCancel(Object object) {
        super.onCancel(object);
        object = DynamicIslandScenarioUtils.INSTANCE;
        if (((DynamicIslandScenarioUtils)object).isBigTracking()) {
            ((DynamicIslandScenarioUtils)object).setDynamicIslandScenarioState(494L, false);
            ((DynamicIslandScenarioUtils)object).setBigTracking(false);
        }
        ((DynamicIslandScenarioUtils)object).setDynamicIslandScenarioState(435L, false);
    }

    @Override
    public void onComplete(Object object) {
        super.onComplete(object);
        object = DynamicIslandScenarioUtils.INSTANCE;
        if (((DynamicIslandScenarioUtils)object).isBigTracking()) {
            ((DynamicIslandScenarioUtils)object).setDynamicIslandScenarioState(494L, false);
            ((DynamicIslandScenarioUtils)object).setBigTracking(false);
        }
        ((DynamicIslandScenarioUtils)object).setDynamicIslandScenarioState(435L, false);
    }
}
