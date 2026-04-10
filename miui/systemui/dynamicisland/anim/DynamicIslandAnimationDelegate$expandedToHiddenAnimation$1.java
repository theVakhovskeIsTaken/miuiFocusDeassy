/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.internal.o
 */
package miui.systemui.dynamicisland.anim;

import kotlin.jvm.internal.o;
import miui.systemui.dynamicisland.DynamicIslandScenarioUtils;
import miui.systemui.dynamicisland.anim.DynamicIslandAnimListener;
import miui.systemui.dynamicisland.anim.DynamicIslandAnimationCallback;
import miui.systemui.dynamicisland.anim.DynamicIslandAnimationCallbackType;
import miui.systemui.dynamicisland.anim.DynamicIslandAnimationDelegate;
import miui.systemui.dynamicisland.anim.DynamicIslandAnimationType;
import miui.systemui.dynamicisland.device.strategy.DynamicIslandAnimationDelegateHelper;
import miui.systemui.dynamicisland.window.content.DynamicIslandContentFakeView;
import miui.systemui.dynamicisland.window.content.DynamicIslandContentView;

public static final class DynamicIslandAnimationDelegate.expandedToHiddenAnimation.1
extends DynamicIslandAnimListener {
    final boolean $isAppClose;
    final DynamicIslandContentView $view;
    final DynamicIslandAnimationDelegate this$0;

    public DynamicIslandAnimationDelegate.expandedToHiddenAnimation.1(DynamicIslandAnimationDelegate dynamicIslandAnimationDelegate, boolean bl, DynamicIslandContentView dynamicIslandContentView) {
        this.this$0 = dynamicIslandAnimationDelegate;
        this.$isAppClose = bl;
        this.$view = dynamicIslandContentView;
        super(dynamicIslandAnimationDelegate);
    }

    @Override
    public void onBegin(Object object) {
        Object object2;
        super.onBegin(object);
        if (!this.$isAppClose && !this.this$0.getIslandWindowAnimRunning()) {
            this.this$0.setViewVisible(this.$view, 0);
            object2 = this.$view.getFakeView();
            if (object2 != null) {
                ((DynamicIslandContentFakeView)((Object)object2)).setVisibility(4);
            }
        }
        if ((object2 = this.$view.getSmallIslandView()) != null) {
            object2.setVisibility(0);
        }
        Object object3 = this.this$0.animationDelegateHelper;
        object2 = DynamicIslandAnimationType.EXPANDED_TO_HIDDEN;
        ((DynamicIslandAnimationDelegateHelper)object3).requestUpdateHeadsUpLocation((DynamicIslandAnimationType)((Object)object2), this.$view);
        DynamicIslandScenarioUtils.INSTANCE.setDynamicIslandScenarioState(476L, true);
        object3 = this.this$0.dynamicIslandAnimController.getAnimationCallback$miui_dynamicisland_release();
        DynamicIslandAnimationCallbackType dynamicIslandAnimationCallbackType = DynamicIslandAnimationCallbackType.ANIM_START;
        o.e((Object)object, (String)"null cannot be cast to non-null type kotlin.String");
        ((DynamicIslandAnimationCallback)object3).executeCallback((DynamicIslandAnimationType)((Object)object2), dynamicIslandAnimationCallbackType, (String)object);
        this.this$0.animationDelegateHelper.updateBigIslandContainerBackground(this.$view);
    }

    @Override
    public void onCancel(Object object) {
        Object object2 = DynamicIslandScenarioUtils.INSTANCE;
        if (object2.isExpandTracking()) {
            object2.setDynamicIslandScenarioState(496L, false);
            object2.setExpandTracking(false);
        }
        object2.setDynamicIslandScenarioState(476L, false);
        DynamicIslandAnimationCallback dynamicIslandAnimationCallback = this.this$0.dynamicIslandAnimController.getAnimationCallback$miui_dynamicisland_release();
        DynamicIslandAnimationType dynamicIslandAnimationType = DynamicIslandAnimationType.EXPANDED_TO_HIDDEN;
        object2 = DynamicIslandAnimationCallbackType.ANIM_CANCEL;
        o.e((Object)object, (String)"null cannot be cast to non-null type kotlin.String");
        dynamicIslandAnimationCallback.executeCallback(dynamicIslandAnimationType, (DynamicIslandAnimationCallbackType)((Object)object2), (String)object);
        super.onCancel(object);
    }

    @Override
    public void onComplete(Object object) {
        Object object2 = this.$view.getExpandedView();
        if (object2 != null) {
            object2.setVisibility(4);
        }
        object2 = this.$view.getFakeView();
        object2 = object2 != null ? object2.getFakeSmallIsland() : null;
        if (object2 != null) {
            object2.setVisibility(4);
        }
        if (!this.$isAppClose && (object2 = this.$view.getFakeView()) != null) {
            object2.setVisibility(4);
        }
        if ((object2 = DynamicIslandScenarioUtils.INSTANCE).isExpandTracking()) {
            object2.setDynamicIslandScenarioState(496L, false);
            object2.setExpandTracking(false);
        }
        object2.setDynamicIslandScenarioState(476L, false);
        object2 = this.this$0.dynamicIslandAnimController.getAnimationCallback$miui_dynamicisland_release();
        DynamicIslandAnimationType dynamicIslandAnimationType = DynamicIslandAnimationType.EXPANDED_TO_HIDDEN;
        DynamicIslandAnimationCallbackType dynamicIslandAnimationCallbackType = DynamicIslandAnimationCallbackType.ANIM_FINISH;
        o.e((Object)object, (String)"null cannot be cast to non-null type kotlin.String");
        object2.executeCallback(dynamicIslandAnimationType, dynamicIslandAnimationCallbackType, (String)object);
        super.onComplete(object);
    }
}
