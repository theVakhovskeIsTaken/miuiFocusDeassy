/*
 * Decompiled with CFR 0.152.
 */
package miui.systemui.dynamicisland.anim;

import miui.systemui.dynamicisland.anim.DynamicIslandAnimListener;
import miui.systemui.dynamicisland.anim.DynamicIslandAnimationDelegate;
import miui.systemui.dynamicisland.window.content.DynamicIslandContentView;

public static final class DynamicIslandAnimationDelegate.bigIslandChangedNoAnimation.1
extends DynamicIslandAnimListener {
    final DynamicIslandContentView $view;

    public DynamicIslandAnimationDelegate.bigIslandChangedNoAnimation.1(DynamicIslandAnimationDelegate dynamicIslandAnimationDelegate, DynamicIslandContentView dynamicIslandContentView) {
        this.$view = dynamicIslandContentView;
        super(dynamicIslandAnimationDelegate);
    }

    @Override
    public void onBegin(Object object) {
        super.onBegin(object);
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
