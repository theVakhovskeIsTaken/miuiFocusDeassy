/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.internal.o
 *  miuix.animation.listener.UpdateInfo
 */
package miui.systemui.dynamicisland.anim;

import java.util.Collection;
import kotlin.jvm.internal.o;
import miui.systemui.dynamicisland.anim.DynamicIslandAnimListener;
import miui.systemui.dynamicisland.anim.DynamicIslandAnimationCallback;
import miui.systemui.dynamicisland.anim.DynamicIslandAnimationCallbackType;
import miui.systemui.dynamicisland.anim.DynamicIslandAnimationDelegate;
import miui.systemui.dynamicisland.anim.DynamicIslandAnimationType;
import miui.systemui.dynamicisland.device.strategy.DynamicIslandAnimationDelegateHelper;
import miui.systemui.dynamicisland.window.content.DynamicIslandContentView;
import miuix.animation.listener.UpdateInfo;

public static final class DynamicIslandAnimationDelegate.expandedToBigIslandNoAnimation.1
extends DynamicIslandAnimListener {
    final float $beginX;
    final DynamicIslandContentView $view;
    final DynamicIslandAnimationDelegate this$0;

    public DynamicIslandAnimationDelegate.expandedToBigIslandNoAnimation.1(DynamicIslandAnimationDelegate dynamicIslandAnimationDelegate, DynamicIslandContentView dynamicIslandContentView, float f) {
        this.this$0 = dynamicIslandAnimationDelegate;
        this.$view = dynamicIslandContentView;
        this.$beginX = f;
        super(dynamicIslandAnimationDelegate);
    }

    @Override
    public void onBegin(Object object) {
        super.onBegin(object);
        this.this$0.isBlockUpdatePosition = true;
        this.this$0.setViewVisible(this.$view, 0);
        Object object2 = this.this$0.getFakeView();
        if (object2 != null) {
            object2.setVisibility(4);
        }
        object2 = this.$view.getBigIslandView();
        if (object2 != null) {
            object2.setVisibility(0);
        }
        object2 = this.$view.getSmallIslandView();
        if (object2 != null) {
            object2.setVisibility(4);
        }
        Object object3 = this.this$0.animationDelegateHelper;
        object2 = DynamicIslandAnimationType.EXPANDED_TO_BIG;
        ((DynamicIslandAnimationDelegateHelper)object3).requestUpdateHeadsUpLocation((DynamicIslandAnimationType)((Object)object2), this.$view);
        object3 = this.this$0.dynamicIslandAnimController.getAnimationCallback$miui_dynamicisland_release();
        DynamicIslandAnimationCallbackType dynamicIslandAnimationCallbackType = DynamicIslandAnimationCallbackType.ANIM_START;
        o.e((Object)object, (String)"null cannot be cast to non-null type kotlin.String");
        ((DynamicIslandAnimationCallback)object3).executeCallback((DynamicIslandAnimationType)((Object)object2), dynamicIslandAnimationCallbackType, (String)object);
        this.this$0.animationDelegateHelper.updateBigIslandContainerBackground(this.$view);
    }

    @Override
    public void onCancel(Object object) {
        this.this$0.isBlockUpdatePosition = false;
        DynamicIslandAnimationCallback dynamicIslandAnimationCallback = this.this$0.dynamicIslandAnimController.getAnimationCallback$miui_dynamicisland_release();
        DynamicIslandAnimationType dynamicIslandAnimationType = DynamicIslandAnimationType.EXPANDED_TO_BIG;
        DynamicIslandAnimationCallbackType dynamicIslandAnimationCallbackType = DynamicIslandAnimationCallbackType.ANIM_CANCEL;
        o.e((Object)object, (String)"null cannot be cast to non-null type kotlin.String");
        dynamicIslandAnimationCallback.executeCallback(dynamicIslandAnimationType, dynamicIslandAnimationCallbackType, (String)object);
        super.onCancel(object);
    }

    @Override
    public void onComplete(Object object) {
        this.this$0.isBlockUpdatePosition = false;
        Object object2 = this.$view.getExpandedView();
        if (object2 != null) {
            object2.setVisibility(4);
        }
        DynamicIslandAnimationCallback dynamicIslandAnimationCallback = this.this$0.dynamicIslandAnimController.getAnimationCallback$miui_dynamicisland_release();
        object2 = DynamicIslandAnimationType.EXPANDED_TO_BIG;
        DynamicIslandAnimationCallbackType dynamicIslandAnimationCallbackType = DynamicIslandAnimationCallbackType.ANIM_FINISH;
        o.e((Object)object, (String)"null cannot be cast to non-null type kotlin.String");
        dynamicIslandAnimationCallback.executeCallback((DynamicIslandAnimationType)((Object)object2), dynamicIslandAnimationCallbackType, (String)object);
        super.onComplete(object);
    }

    @Override
    public void onUpdate(Object object, Collection<UpdateInfo> collection) {
        this.this$0.fixTransX(collection, this.$beginX);
        super.onUpdate(object, collection);
    }
}
