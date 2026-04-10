/*
 * Decompiled with CFR 0.152.
 */
package miui.systemui.dynamicisland.anim;

import miui.systemui.dynamicisland.anim.DynamicIslandAnimListener;
import miui.systemui.dynamicisland.anim.DynamicIslandAnimationDelegate;
import miui.systemui.dynamicisland.anim.DynamicIslandAnimationType;
import miui.systemui.dynamicisland.window.content.DynamicIslandContentView;

public static final class DynamicIslandAnimationDelegate.bigIslandToTempHiddenNoAnimation.1
extends DynamicIslandAnimListener {
    final DynamicIslandContentView $view;
    final DynamicIslandAnimationDelegate this$0;

    public DynamicIslandAnimationDelegate.bigIslandToTempHiddenNoAnimation.1(DynamicIslandAnimationDelegate dynamicIslandAnimationDelegate, DynamicIslandContentView dynamicIslandContentView) {
        this.this$0 = dynamicIslandAnimationDelegate;
        this.$view = dynamicIslandContentView;
        super(dynamicIslandAnimationDelegate);
    }

    @Override
    public void onBegin(Object object) {
        super.onBegin(object);
        this.this$0.animationDelegateHelper.requestUpdateHeadsUpLocation(DynamicIslandAnimationType.BIG_TO_TEMP_HIDDEN, this.$view);
    }

    @Override
    public void onComplete(Object object) {
        super.onComplete(object);
        object = this.$view.getExpandedView();
        if (object != null) {
            object.setVisibility(4);
        }
    }
}
