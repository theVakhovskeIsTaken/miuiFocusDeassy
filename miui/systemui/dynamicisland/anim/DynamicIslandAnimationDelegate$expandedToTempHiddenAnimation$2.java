/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.internal.o
 *  miui.systemui.util.CommonUtils
 */
package miui.systemui.dynamicisland.anim;

import kotlin.jvm.internal.o;
import miui.systemui.dynamicisland.DynamicIslandScenarioUtils;
import miui.systemui.dynamicisland.anim.DynamicIslandAnimListener;
import miui.systemui.dynamicisland.anim.DynamicIslandAnimationCallback;
import miui.systemui.dynamicisland.anim.DynamicIslandAnimationCallbackType;
import miui.systemui.dynamicisland.anim.DynamicIslandAnimationDelegate;
import miui.systemui.dynamicisland.anim.DynamicIslandAnimationType;
import miui.systemui.dynamicisland.window.DynamicIslandWindowState;
import miui.systemui.dynamicisland.window.content.DynamicIslandContentView;
import miui.systemui.util.CommonUtils;

public static final class DynamicIslandAnimationDelegate.expandedToTempHiddenAnimation.2
extends DynamicIslandAnimListener {
    final boolean $forceSlideOffPad;
    final DynamicIslandContentView $view;
    final DynamicIslandAnimationDelegate this$0;

    public DynamicIslandAnimationDelegate.expandedToTempHiddenAnimation.2(DynamicIslandAnimationDelegate dynamicIslandAnimationDelegate, DynamicIslandContentView dynamicIslandContentView, boolean bl) {
        this.this$0 = dynamicIslandAnimationDelegate;
        this.$view = dynamicIslandContentView;
        this.$forceSlideOffPad = bl;
        super(dynamicIslandAnimationDelegate);
    }

    @Override
    public void onBegin(Object object) {
        super.onBegin(object);
        Object object2 = this.$view.getWindowState();
        if (!(object2 == null || ((DynamicIslandWindowState)object2).getKeyguardShowing() || (object2 = this.$view.getWindowState()) == null || ((DynamicIslandWindowState)object2).getNotificationVisible() || (object2 = this.$view.getWindowState()) == null || (object2 = ((DynamicIslandWindowState)object2).getScreenPinning()) == null || ((Boolean)object2.getValue()).booleanValue())) {
            this.this$0.setViewVisible(this.$view, 0);
        }
        Object object3 = this.this$0.animationDelegateHelper;
        object2 = DynamicIslandAnimationType.EXPANDED_TO_TEMP_HIDDEN;
        object3.requestUpdateHeadsUpLocation((DynamicIslandAnimationType)((Object)object2), this.$view);
        DynamicIslandAnimationCallback dynamicIslandAnimationCallback = this.this$0.dynamicIslandAnimController.getAnimationCallback$miui_dynamicisland_release();
        object3 = DynamicIslandAnimationCallbackType.ANIM_START;
        o.e((Object)object, (String)"null cannot be cast to non-null type kotlin.String");
        dynamicIslandAnimationCallback.executeCallback((DynamicIslandAnimationType)((Object)object2), (DynamicIslandAnimationCallbackType)((Object)object3), (String)object);
        DynamicIslandScenarioUtils.INSTANCE.setDynamicIslandScenarioState(476L, true);
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
        DynamicIslandAnimationType dynamicIslandAnimationType = DynamicIslandAnimationType.EXPANDED_TO_TEMP_HIDDEN;
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
        this.this$0.setExpandedToTempHiddenAnimating(false);
        object2 = DynamicIslandScenarioUtils.INSTANCE;
        if (((DynamicIslandScenarioUtils)object2).isExpandTracking()) {
            ((DynamicIslandScenarioUtils)object2).setDynamicIslandScenarioState(496L, false);
            ((DynamicIslandScenarioUtils)object2).setExpandTracking(false);
        }
        ((DynamicIslandScenarioUtils)object2).setDynamicIslandScenarioState(476L, false);
        DynamicIslandAnimationCallback dynamicIslandAnimationCallback = this.this$0.dynamicIslandAnimController.getAnimationCallback$miui_dynamicisland_release();
        object2 = DynamicIslandAnimationType.EXPANDED_TO_TEMP_HIDDEN;
        DynamicIslandAnimationCallbackType dynamicIslandAnimationCallbackType = DynamicIslandAnimationCallbackType.ANIM_FINISH;
        o.e((Object)object, (String)"null cannot be cast to non-null type kotlin.String");
        dynamicIslandAnimationCallback.executeCallback((DynamicIslandAnimationType)((Object)object2), dynamicIslandAnimationCallbackType, (String)object);
        super.onComplete(object);
        if (CommonUtils.INSTANCE.getIS_TABLET() && (this.$forceSlideOffPad || !this.this$0.getPanelHeightChanging())) {
            this.this$0.expandedToTempHiddenNoAnimation(this.$view);
        }
    }
}
