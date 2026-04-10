/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  miui.systemui.util.CommonUtils
 */
package miui.systemui.dynamicisland.anim;

import miui.systemui.dynamicisland.anim.DynamicIslandAnimListener;
import miui.systemui.dynamicisland.anim.DynamicIslandAnimationDelegate;
import miui.systemui.dynamicisland.anim.DynamicIslandAnimationType;
import miui.systemui.dynamicisland.window.content.DynamicIslandContentView;
import miui.systemui.util.CommonUtils;

public static final class DynamicIslandAnimationDelegate.moveUpAnimation.1
extends DynamicIslandAnimListener {
    final DynamicIslandContentView $view;
    final DynamicIslandAnimationDelegate this$0;

    public DynamicIslandAnimationDelegate.moveUpAnimation.1(DynamicIslandAnimationDelegate dynamicIslandAnimationDelegate, DynamicIslandContentView dynamicIslandContentView) {
        this.this$0 = dynamicIslandAnimationDelegate;
        this.$view = dynamicIslandContentView;
        super(dynamicIslandAnimationDelegate);
    }

    @Override
    public void onBegin(Object object) {
        super.onBegin(object);
        object = this.$view.getBigIslandView();
        if (object != null) {
            object.setVisibility(0);
        }
        this.this$0.animationDelegateHelper.requestUpdateHeadsUpLocation(DynamicIslandAnimationType.TEMP_HIDDEN_TO_BIG, this.$view);
    }

    @Override
    public void onCancel(Object object) {
        super.onCancel(object);
        boolean bl = (Boolean)this.this$0.dynamicIslandAnimController.getDynamicIslandWindowState().getStatusBarWindowsInsetsShow().getValue();
        if (CommonUtils.INSTANCE.getIS_TABLET() && !bl) {
            this.this$0.setViewVisible(this.$view, 8);
        }
        this.this$0.isMoveUpAnimating = false;
    }

    @Override
    public void onComplete(Object object) {
        super.onComplete(object);
        this.this$0.setViewVisible(this.$view, 4);
        this.this$0.isMoveUpAnimating = false;
    }
}
