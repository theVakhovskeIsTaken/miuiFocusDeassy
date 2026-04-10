/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.internal.o
 */
package miui.systemui.dynamicisland.anim;

import kotlin.jvm.internal.o;
import miui.systemui.dynamicisland.anim.DynamicIslandAnimListener;
import miui.systemui.dynamicisland.anim.DynamicIslandAnimationCallback;
import miui.systemui.dynamicisland.anim.DynamicIslandAnimationCallbackType;
import miui.systemui.dynamicisland.anim.DynamicIslandAnimationDelegate;
import miui.systemui.dynamicisland.anim.DynamicIslandAnimationType;
import miui.systemui.dynamicisland.device.strategy.DynamicIslandAnimationDelegateHelper;
import miui.systemui.dynamicisland.window.content.DynamicIslandContentView;

public static final class DynamicIslandAnimationDelegate.expandedToSmallIslandNoAnimation.1
extends DynamicIslandAnimListener {
    final DynamicIslandContentView $view;
    final DynamicIslandAnimationDelegate this$0;

    public DynamicIslandAnimationDelegate.expandedToSmallIslandNoAnimation.1(DynamicIslandAnimationDelegate dynamicIslandAnimationDelegate, DynamicIslandContentView dynamicIslandContentView) {
        this.this$0 = dynamicIslandAnimationDelegate;
        this.$view = dynamicIslandContentView;
        super(dynamicIslandAnimationDelegate);
    }

    @Override
    public void onBegin(Object object) {
        super.onBegin(object);
        Object object2 = this.$view.getSmallIslandView();
        if (object2 != null) {
            object2.setVisibility(0);
        }
        Object object3 = this.this$0.animationDelegateHelper;
        object2 = DynamicIslandAnimationType.EXPANDED_TO_SMALL;
        ((DynamicIslandAnimationDelegateHelper)object3).requestUpdateHeadsUpLocation((DynamicIslandAnimationType)((Object)object2), this.$view);
        object3 = this.this$0.dynamicIslandAnimController.getAnimationCallback$miui_dynamicisland_release();
        DynamicIslandAnimationCallbackType dynamicIslandAnimationCallbackType = DynamicIslandAnimationCallbackType.ANIM_START;
        o.e((Object)object, (String)"null cannot be cast to non-null type kotlin.String");
        ((DynamicIslandAnimationCallback)object3).executeCallback((DynamicIslandAnimationType)((Object)object2), dynamicIslandAnimationCallbackType, (String)object);
    }

    @Override
    public void onCancel(Object object) {
        DynamicIslandAnimationCallback dynamicIslandAnimationCallback = this.this$0.dynamicIslandAnimController.getAnimationCallback$miui_dynamicisland_release();
        DynamicIslandAnimationType dynamicIslandAnimationType = DynamicIslandAnimationType.EXPANDED_TO_SMALL;
        DynamicIslandAnimationCallbackType dynamicIslandAnimationCallbackType = DynamicIslandAnimationCallbackType.ANIM_CANCEL;
        o.e((Object)object, (String)"null cannot be cast to non-null type kotlin.String");
        dynamicIslandAnimationCallback.executeCallback(dynamicIslandAnimationType, dynamicIslandAnimationCallbackType, (String)object);
        super.onCancel(object);
    }

    @Override
    public void onComplete(Object object) {
        Object object2 = this.$view.getExpandedView();
        if (object2 != null) {
            object2.setVisibility(4);
        }
        object2 = this.this$0.dynamicIslandAnimController.getAnimationCallback$miui_dynamicisland_release();
        DynamicIslandAnimationType dynamicIslandAnimationType = DynamicIslandAnimationType.EXPANDED_TO_SMALL;
        DynamicIslandAnimationCallbackType dynamicIslandAnimationCallbackType = DynamicIslandAnimationCallbackType.ANIM_FINISH;
        o.e((Object)object, (String)"null cannot be cast to non-null type kotlin.String");
        ((DynamicIslandAnimationCallback)object2).executeCallback(dynamicIslandAnimationType, dynamicIslandAnimationCallbackType, (String)object);
        super.onComplete(object);
    }
}
