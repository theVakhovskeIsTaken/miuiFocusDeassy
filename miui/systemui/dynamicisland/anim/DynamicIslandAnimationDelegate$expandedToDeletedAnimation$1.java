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
import miui.systemui.dynamicisland.window.content.DynamicIslandContentView;

public static final class DynamicIslandAnimationDelegate.expandedToDeletedAnimation.1
extends DynamicIslandAnimListener {
    final DynamicIslandContentView $view;
    final DynamicIslandAnimationDelegate this$0;

    public DynamicIslandAnimationDelegate.expandedToDeletedAnimation.1(DynamicIslandAnimationDelegate dynamicIslandAnimationDelegate, DynamicIslandContentView dynamicIslandContentView) {
        this.this$0 = dynamicIslandAnimationDelegate;
        this.$view = dynamicIslandContentView;
        super(dynamicIslandAnimationDelegate);
    }

    @Override
    public void onBegin(Object object) {
        super.onBegin(object);
        Object object2 = this.this$0.animationDelegateHelper;
        DynamicIslandAnimationType dynamicIslandAnimationType = DynamicIslandAnimationType.EXPANDED_TO_DELETED;
        ((DynamicIslandAnimationDelegateHelper)object2).requestUpdateHeadsUpLocation(dynamicIslandAnimationType, this.$view);
        object2 = this.this$0.dynamicIslandAnimController.getAnimationCallback$miui_dynamicisland_release();
        DynamicIslandAnimationCallbackType dynamicIslandAnimationCallbackType = DynamicIslandAnimationCallbackType.ANIM_START;
        o.e((Object)object, (String)"null cannot be cast to non-null type kotlin.String");
        ((DynamicIslandAnimationCallback)object2).executeCallback(dynamicIslandAnimationType, dynamicIslandAnimationCallbackType, (String)object);
        DynamicIslandScenarioUtils.INSTANCE.setDynamicIslandScenarioState(476L, true);
    }

    @Override
    public void onCancel(Object object) {
        DynamicIslandAnimationDelegate.removeViewFromWindow$default(this.this$0, this.$view, false, 2, null);
        DynamicIslandAnimationCallback dynamicIslandAnimationCallback = this.this$0.dynamicIslandAnimController.getAnimationCallback$miui_dynamicisland_release();
        DynamicIslandAnimationType dynamicIslandAnimationType = DynamicIslandAnimationType.EXPANDED_TO_DELETED;
        DynamicIslandAnimationCallbackType dynamicIslandAnimationCallbackType = DynamicIslandAnimationCallbackType.ANIM_CANCEL;
        o.e((Object)object, (String)"null cannot be cast to non-null type kotlin.String");
        dynamicIslandAnimationCallback.executeCallback(dynamicIslandAnimationType, dynamicIslandAnimationCallbackType, (String)object);
        DynamicIslandScenarioUtils.INSTANCE.setDynamicIslandScenarioState(476L, false);
        super.onCancel(object);
    }

    @Override
    public void onComplete(Object object) {
        DynamicIslandAnimationDelegate.removeViewFromWindow$default(this.this$0, this.$view, false, 2, null);
        DynamicIslandAnimationCallback dynamicIslandAnimationCallback = this.this$0.dynamicIslandAnimController.getAnimationCallback$miui_dynamicisland_release();
        DynamicIslandAnimationType dynamicIslandAnimationType = DynamicIslandAnimationType.EXPANDED_TO_DELETED;
        DynamicIslandAnimationCallbackType dynamicIslandAnimationCallbackType = DynamicIslandAnimationCallbackType.ANIM_FINISH;
        o.e((Object)object, (String)"null cannot be cast to non-null type kotlin.String");
        dynamicIslandAnimationCallback.executeCallback(dynamicIslandAnimationType, dynamicIslandAnimationCallbackType, (String)object);
        DynamicIslandScenarioUtils.INSTANCE.setDynamicIslandScenarioState(476L, false);
        super.onComplete(object);
    }
}
