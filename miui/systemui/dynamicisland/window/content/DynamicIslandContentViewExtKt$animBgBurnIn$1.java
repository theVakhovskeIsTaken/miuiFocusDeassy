/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  miuix.animation.listener.TransitionListener
 *  miuix.animation.listener.UpdateInfo
 */
package miui.systemui.dynamicisland.window.content;

import java.util.Collection;
import miui.systemui.dynamicisland.window.content.DynamicIslandContentView;
import miui.systemui.dynamicisland.window.content.DynamicIslandContentViewExtKt;
import miuix.animation.listener.TransitionListener;
import miuix.animation.listener.UpdateInfo;

public static final class DynamicIslandContentViewExtKt.animBgBurnIn.1
extends TransitionListener {
    final DynamicIslandContentView $this_animBgBurnIn;
    final float $to;

    public DynamicIslandContentViewExtKt.animBgBurnIn.1(DynamicIslandContentView dynamicIslandContentView, float f) {
        this.$this_animBgBurnIn = dynamicIslandContentView;
        this.$to = f;
    }

    public void onComplete(Object object) {
        super.onComplete(object);
        if (this.$to == 0.6f) {
            DynamicIslandContentViewExtKt.hideTextShade(this.$this_animBgBurnIn);
        } else {
            DynamicIslandContentViewExtKt.restoreShade(this.$this_animBgBurnIn);
        }
    }

    public void onUpdate(Object object, Collection<UpdateInfo> collection) {
        object = this.$this_animBgBurnIn.getContainer();
        object = object != null ? object.getBackground() : null;
        if (object != null) {
            object.setAlpha((int)((float)255 * this.$this_animBgBurnIn.getContainerBgAlpha()));
        }
        this.$this_animBgBurnIn.invalidate();
    }
}
