/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  miuix.animation.listener.TransitionListener
 */
package miui.systemui.dynamicisland.window.content;

import miui.systemui.dynamicisland.window.content.DynamicIslandBaseContentView;
import miuix.animation.listener.TransitionListener;

public static final class DynamicIslandBaseContentView.doBigIslandAnim.showConfig.1
extends TransitionListener {
    final boolean $isFakeView;
    final int $leftWidth;
    final int $rightWidth;
    final DynamicIslandBaseContentView this$0;

    public DynamicIslandBaseContentView.doBigIslandAnim.showConfig.1(DynamicIslandBaseContentView dynamicIslandBaseContentView, boolean bl, int n, int n2) {
        this.this$0 = dynamicIslandBaseContentView;
        this.$isFakeView = bl;
        this.$leftWidth = n;
        this.$rightWidth = n2;
    }

    public void onBegin(Object object) {
        super.onBegin(object);
        this.this$0.getController().getIslandTemplateFactory().updateCutoutWidth(this.this$0.getCurrentIslandData(), this.this$0.getFixedCutoutWidth(), this.$isFakeView);
        this.this$0.getController().getIslandTemplateFactory().updateLeftWidth(this.this$0.getCurrentIslandData(), this.$leftWidth, this.$isFakeView);
        this.this$0.getController().getIslandTemplateFactory().updateRightWidth(this.this$0.getCurrentIslandData(), this.$rightWidth, this.$isFakeView);
    }
}
