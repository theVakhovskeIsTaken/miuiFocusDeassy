/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.internal.o
 *  kotlin.jvm.internal.x
 */
package miui.systemui.dynamicisland.anim;

import kotlin.jvm.internal.o;
import kotlin.jvm.internal.x;
import miui.systemui.dynamicisland.anim.DynamicIslandAnimListener;
import miui.systemui.dynamicisland.anim.DynamicIslandAnimationCallback;
import miui.systemui.dynamicisland.anim.DynamicIslandAnimationCallbackType;
import miui.systemui.dynamicisland.anim.DynamicIslandAnimationDelegate;
import miui.systemui.dynamicisland.anim.DynamicIslandAnimationType;
import miui.systemui.dynamicisland.window.content.DynamicIslandContentView;

public static final class DynamicIslandAnimationDelegate.expandedChangedAnimation.1
extends DynamicIslandAnimListener {
    final x $needUpdateExpandViewBlur;
    final DynamicIslandContentView $view;
    final DynamicIslandAnimationDelegate this$0;

    public DynamicIslandAnimationDelegate.expandedChangedAnimation.1(DynamicIslandAnimationDelegate dynamicIslandAnimationDelegate, DynamicIslandContentView dynamicIslandContentView, x x2) {
        this.this$0 = dynamicIslandAnimationDelegate;
        this.$view = dynamicIslandContentView;
        this.$needUpdateExpandViewBlur = x2;
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
            object2.setVisibility(4);
        }
        object2 = this.$view.getMask();
        if (object2 != null) {
            object2.setVisibility(4);
        }
        DynamicIslandAnimationCallback dynamicIslandAnimationCallback = this.this$0.dynamicIslandAnimController.getAnimationCallback$miui_dynamicisland_release();
        object2 = DynamicIslandAnimationType.TO_EXPANDED;
        DynamicIslandAnimationCallbackType dynamicIslandAnimationCallbackType = DynamicIslandAnimationCallbackType.ANIM_START;
        o.e((Object)object, (String)"null cannot be cast to non-null type kotlin.String");
        dynamicIslandAnimationCallback.executeCallback((DynamicIslandAnimationType)((Object)object2), dynamicIslandAnimationCallbackType, (String)object);
        this.this$0.setAnimateExpanding(true);
        this.this$0.animationDelegateHelper.requestUpdateHeadsUpLocation(DynamicIslandAnimationType.EXPANDED_CHANGED, this.$view);
    }

    @Override
    public void onCancel(Object object) {
        super.onCancel(object);
        this.this$0.setAnimateExpanding(false);
        if (!this.$needUpdateExpandViewBlur.a) {
            object = this.$view.getExpandedView();
            if (object != null) {
                object.setOutlineProvider(null);
            }
            object = this.$view.getExpandedView();
            if (object != null) {
                object.invalidateOutline();
            }
        }
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
            object.setOutlineProvider(null);
        }
        object = this.$view.getExpandedView();
        if (object != null) {
            object.invalidateOutline();
        }
    }
}
