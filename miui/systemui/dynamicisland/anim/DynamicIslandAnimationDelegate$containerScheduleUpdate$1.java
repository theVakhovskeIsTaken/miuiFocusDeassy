/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.graphics.Outline
 *  android.view.View
 *  android.view.ViewOutlineProvider
 *  kotlin.jvm.internal.o
 *  miui.systemui.util.ThreadUtils
 */
package miui.systemui.dynamicisland.anim;

import android.graphics.Outline;
import android.view.View;
import android.view.ViewOutlineProvider;
import kotlin.jvm.internal.o;
import miui.systemui.dynamicisland.DynamicIslandBackgroundView;
import miui.systemui.dynamicisland.anim.DynamicIslandAnimationDelegate;
import miui.systemui.util.ThreadUtils;

public static final class DynamicIslandAnimationDelegate.containerScheduleUpdate.1
extends ViewOutlineProvider {
    final DynamicIslandAnimationDelegate this$0;

    public DynamicIslandAnimationDelegate.containerScheduleUpdate.1(DynamicIslandAnimationDelegate dynamicIslandAnimationDelegate) {
        this.this$0 = dynamicIslandAnimationDelegate;
    }

    public void getOutline(View view, Outline outline) {
        o.g((Object)view, (String)"view");
        o.g((Object)outline, (String)"outline");
        if (this.this$0.view.getBackgroundView() != null) {
            DynamicIslandBackgroundView dynamicIslandBackgroundView = this.this$0.view.getBackgroundView();
            if (dynamicIslandBackgroundView != null) {
                dynamicIslandBackgroundView.setActualWidth((int)(this.this$0.containerX + this.this$0.containerClipEndProgress));
            }
            if (dynamicIslandBackgroundView != null) {
                dynamicIslandBackgroundView.setActualHeight((int)(this.this$0.containerTransY + this.this$0.containerClipBottomProgress));
            }
            if (dynamicIslandBackgroundView != null) {
                dynamicIslandBackgroundView.setActualLeft((int)(this.this$0.containerX + this.this$0.containerClipStartProgress));
            }
            if (dynamicIslandBackgroundView != null) {
                dynamicIslandBackgroundView.setActualTop((int)(this.this$0.containerTransY + this.this$0.containerClipTopProgress));
            }
            if (ThreadUtils.isMainThread()) {
                view = view.getParent();
                o.e((Object)view, (String)"null cannot be cast to non-null type miui.systemui.dynamicisland.DynamicIslandBackgroundView");
                ((DynamicIslandBackgroundView)view).invalidate();
            } else {
                view = view.getParent();
                o.e((Object)view, (String)"null cannot be cast to non-null type miui.systemui.dynamicisland.DynamicIslandBackgroundView");
                ((DynamicIslandBackgroundView)view).postInvalidate();
            }
        }
        outline.setRoundRect((int)this.this$0.containerClipStartProgress, (int)this.this$0.containerClipTopProgress, (int)this.this$0.containerClipEndProgress, (int)this.this$0.containerClipBottomProgress, this.this$0.containerClipRadius());
        view = this.this$0.view.getRoundedRect();
        if (view != null) {
            view.set(this.this$0.containerClipStartProgress, this.this$0.containerClipTopProgress, this.this$0.containerClipEndProgress, this.this$0.containerClipBottomProgress);
        }
    }
}
