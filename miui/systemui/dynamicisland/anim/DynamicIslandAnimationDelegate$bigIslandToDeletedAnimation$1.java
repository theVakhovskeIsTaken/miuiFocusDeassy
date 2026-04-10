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

public static final class DynamicIslandAnimationDelegate.bigIslandToDeletedAnimation.1
extends DynamicIslandAnimListener {
    final DynamicIslandContentView $view;
    final DynamicIslandAnimationDelegate this$0;

    public DynamicIslandAnimationDelegate.bigIslandToDeletedAnimation.1(DynamicIslandAnimationDelegate dynamicIslandAnimationDelegate, DynamicIslandContentView dynamicIslandContentView) {
        this.this$0 = dynamicIslandAnimationDelegate;
        this.$view = dynamicIslandContentView;
        super(dynamicIslandAnimationDelegate);
    }

    @Override
    public void onBegin(Object object) {
        super.onBegin(object);
        DynamicIslandScenarioUtils.INSTANCE.setDynamicIslandScenarioState(435L, true);
        DynamicIslandAnimationCallback dynamicIslandAnimationCallback = this.this$0.dynamicIslandAnimController.getAnimationCallback$miui_dynamicisland_release();
        DynamicIslandAnimationType dynamicIslandAnimationType = DynamicIslandAnimationType.BIG_TO_DELETED;
        DynamicIslandAnimationCallbackType dynamicIslandAnimationCallbackType = DynamicIslandAnimationCallbackType.ANIM_START;
        o.e((Object)object, (String)"null cannot be cast to non-null type kotlin.String");
        dynamicIslandAnimationCallback.executeCallback(dynamicIslandAnimationType, dynamicIslandAnimationCallbackType, (String)object);
    }

    @Override
    public void onCancel(Object object) {
        super.onCancel(object);
        DynamicIslandScenarioUtils.INSTANCE.setDynamicIslandScenarioState(435L, false);
        DynamicIslandAnimationDelegate.removeViewFromWindow$default(this.this$0, this.$view, false, 2, null);
    }

    @Override
    public void onComplete(Object object) {
        super.onComplete(object);
        DynamicIslandScenarioUtils.INSTANCE.setDynamicIslandScenarioState(435L, false);
        DynamicIslandAnimationDelegate.removeViewFromWindow$default(this.this$0, this.$view, false, 2, null);
        this.this$0.animationDelegateHelper.requestUpdateHeadsUpLocation(DynamicIslandAnimationType.BIG_TO_DELETED, this.$view);
    }
}
