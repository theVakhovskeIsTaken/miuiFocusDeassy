/*
 * Decompiled with CFR 0.152.
 */
package miui.systemui.dynamicisland.anim;

import miui.systemui.dynamicisland.DynamicIslandScenarioUtils;
import miui.systemui.dynamicisland.anim.DynamicIslandAnimListener;
import miui.systemui.dynamicisland.anim.DynamicIslandAnimationDelegate;
import miui.systemui.dynamicisland.event.DynamicIslandState;
import miui.systemui.dynamicisland.window.content.DynamicIslandBaseContentView;
import miui.systemui.dynamicisland.window.content.DynamicIslandContentFakeView;
import miui.systemui.dynamicisland.window.content.DynamicIslandContentView;

public static final class DynamicIslandAnimationDelegate.appExpandedToBigIslandAnimListener.1
extends DynamicIslandAnimListener {
    final boolean $isAppClose;
    final DynamicIslandContentView $view;
    final DynamicIslandAnimationDelegate this$0;

    public DynamicIslandAnimationDelegate.appExpandedToBigIslandAnimListener.1(DynamicIslandAnimationDelegate dynamicIslandAnimationDelegate, DynamicIslandContentView dynamicIslandContentView, boolean bl) {
        this.this$0 = dynamicIslandAnimationDelegate;
        this.$view = dynamicIslandContentView;
        this.$isAppClose = bl;
        super(dynamicIslandAnimationDelegate);
    }

    @Override
    public void onBegin(Object object) {
        this.this$0.setAppClosing(true);
        super.onBegin(object);
        object = this.$view.getExpandedView();
        if (object != null) {
            object.setVisibility(4);
        }
        object = this.$view.getBigIslandView();
        if (object != null) {
            object.setVisibility(0);
        }
        if (!this.this$0.getIslandWindowAnimRunning()) {
            this.this$0.setViewVisible(this.$view, 0);
            object = this.$view.getFakeView();
            if (object != null) {
                ((DynamicIslandContentFakeView)((Object)object)).setVisibility(4);
            }
        } else {
            if (!this.this$0.getExpandedToTempHiddenAnimating()) {
                this.this$0.setViewVisible(this.$view, 4);
            }
            if ((object = this.this$0.getFakeView()) != null) {
                ((DynamicIslandContentFakeView)((Object)object)).setVisibility(0);
            }
        }
        this.this$0.animationDelegateHelper.updateBigIslandContainerBackground(this.$view);
        DynamicIslandScenarioUtils.INSTANCE.setDynamicIslandScenarioState(434L, true);
    }

    @Override
    public void onCancel(Object object) {
        this.this$0.setAppClosing(false);
        super.onCancel(object);
        if (this.this$0.getExpandedToTempHiddenAnimating()) {
            if (this.this$0.getIslandWindowAnimRunning()) {
                this.this$0.setViewVisible(this.$view, 4);
            }
            this.this$0.setExpandedToTempHiddenAnimating(false);
        }
        DynamicIslandScenarioUtils.INSTANCE.setDynamicIslandScenarioState(434L, false);
        if (this.this$0.getIslandWindowAnimRunning() && !this.$isAppClose) {
            if (!this.this$0.windowView.getSupportMiniWindowEndPositionChange() || !((DynamicIslandBaseContentView)((Object)(object = this.$view))).pkgHasMultIslands((DynamicIslandContentView)((Object)object)) || this.this$0.getIslandStateChanged() && !(this.$view.getState() instanceof DynamicIslandState.SmallIsland)) {
                this.this$0.setViewVisible(this.$view, 0);
                object = this.$view.getFakeView();
                if (object != null) {
                    ((DynamicIslandContentFakeView)((Object)object)).setVisibility(4);
                }
            }
            if ((object = this.$view.getBigIslandView()) != null) {
                object.setVisibility(0);
            }
        }
    }

    @Override
    public void onComplete(Object object) {
        this.this$0.setAppClosing(false);
        super.onComplete(object);
        if (this.this$0.getExpandedToTempHiddenAnimating()) {
            if (this.this$0.getIslandWindowAnimRunning()) {
                this.this$0.setViewVisible(this.$view, 4);
            }
            this.this$0.resetContainerAlpha();
            this.this$0.setExpandedToTempHiddenAnimating(false);
        }
        if (this.this$0.getIslandWindowAnimRunning() && !this.$isAppClose) {
            this.this$0.setViewVisible(this.$view, 0);
            object = this.$view.getBigIslandView();
            if (object != null) {
                object.setVisibility(0);
            }
            object = this.$view.getFakeView();
            if (object != null) {
                ((DynamicIslandContentFakeView)((Object)object)).setVisibility(4);
            }
        }
        DynamicIslandScenarioUtils.INSTANCE.setDynamicIslandScenarioState(434L, false);
    }
}
