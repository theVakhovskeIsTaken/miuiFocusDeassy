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
import miui.systemui.dynamicisland.window.content.DynamicIslandContentView;

public static final class DynamicIslandAnimationDelegate.smallIslandToExpandedAnimation.1
extends DynamicIslandAnimListener {
    final DynamicIslandContentView $view;
    final DynamicIslandAnimationDelegate this$0;

    public DynamicIslandAnimationDelegate.smallIslandToExpandedAnimation.1(DynamicIslandAnimationDelegate dynamicIslandAnimationDelegate, DynamicIslandContentView dynamicIslandContentView) {
        this.this$0 = dynamicIslandAnimationDelegate;
        this.$view = dynamicIslandContentView;
        super(dynamicIslandAnimationDelegate);
    }

    @Override
    public void onBegin(Object object) {
        super.onBegin(object);
        Object object2 = this.$view.getExpandedView();
        if (object2 != null) {
            object2.setVisibility(0);
        }
        object2 = this.$view.getBigIslandView();
        if (object2 != null) {
            object2.setVisibility(4);
        }
        object2 = this.$view.getSmallIslandView();
        if (object2 != null) {
            object2.performAccessibilityAction(128, null);
        }
        this.this$0.animationDelegateHelper.requestUpdateHeadsUpLocation(DynamicIslandAnimationType.SMALL_TO_EXPANDED, this.$view);
        DynamicIslandAnimationCallback dynamicIslandAnimationCallback = this.this$0.dynamicIslandAnimController.getAnimationCallback$miui_dynamicisland_release();
        DynamicIslandAnimationType dynamicIslandAnimationType = DynamicIslandAnimationType.TO_EXPANDED;
        object2 = DynamicIslandAnimationCallbackType.ANIM_START;
        o.e((Object)object, (String)"null cannot be cast to non-null type kotlin.String");
        dynamicIslandAnimationCallback.executeCallback(dynamicIslandAnimationType, (DynamicIslandAnimationCallbackType)((Object)object2), (String)object);
        this.this$0.setAnimateExpanding(true);
        DynamicIslandScenarioUtils.INSTANCE.setDynamicIslandScenarioState(474L, true);
    }

    @Override
    public void onCancel(Object object) {
        super.onCancel(object);
        this.this$0.setAnimateExpanding(false);
        DynamicIslandScenarioUtils.INSTANCE.setDynamicIslandScenarioState(474L, false);
    }

    @Override
    public void onComplete(Object object) {
        super.onComplete(object);
        DynamicIslandAnimationCallback dynamicIslandAnimationCallback = this.this$0.dynamicIslandAnimController.getAnimationCallback$miui_dynamicisland_release();
        DynamicIslandAnimationType dynamicIslandAnimationType = DynamicIslandAnimationType.TO_EXPANDED;
        DynamicIslandAnimationCallbackType dynamicIslandAnimationCallbackType = DynamicIslandAnimationCallbackType.ANIM_FINISH;
        o.e((Object)object, (String)"null cannot be cast to non-null type kotlin.String");
        dynamicIslandAnimationCallback.executeCallback(dynamicIslandAnimationType, dynamicIslandAnimationCallbackType, (String)object);
        this.this$0.setAnimateExpanding(false);
        object = this.$view.getExpandedView();
        if (object != null) {
            object.sendAccessibilityEvent(128);
        }
        DynamicIslandScenarioUtils.INSTANCE.setDynamicIslandScenarioState(474L, false);
    }
}
