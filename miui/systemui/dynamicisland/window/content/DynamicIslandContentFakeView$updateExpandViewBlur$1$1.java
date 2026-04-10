/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.Outline
 *  android.graphics.Rect
 *  android.view.View
 *  android.view.ViewOutlineProvider
 *  kotlin.jvm.internal.o
 */
package miui.systemui.dynamicisland.window.content;

import android.content.Context;
import android.graphics.Outline;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewOutlineProvider;
import kotlin.jvm.internal.o;
import miui.systemui.dynamicisland.window.content.DynamicIslandContentFakeView;

public static final class DynamicIslandContentFakeView.updateExpandViewBlur.1.1
extends ViewOutlineProvider {
    final int $bottom;
    final boolean $isFreeform;
    final boolean $openApp;
    final DynamicIslandContentFakeView this$0;

    public DynamicIslandContentFakeView.updateExpandViewBlur.1.1(boolean bl, boolean bl2, DynamicIslandContentFakeView dynamicIslandContentFakeView, int n) {
        this.$isFreeform = bl;
        this.$openApp = bl2;
        this.this$0 = dynamicIslandContentFakeView;
        this.$bottom = n;
    }

    public void getOutline(View view, Outline outline) {
        int n;
        int n2;
        Context context;
        DynamicIslandContentFakeView dynamicIslandContentFakeView;
        o.g((Object)view, (String)"view");
        o.g((Object)outline, (String)"outline");
        if (!this.$isFreeform && this.$openApp) {
            dynamicIslandContentFakeView = this.this$0;
            context = dynamicIslandContentFakeView.getContext();
            o.f((Object)context, (String)"getContext(...)");
            n2 = dynamicIslandContentFakeView.getScreenWidth(context);
        } else {
            n2 = view.getRight();
        }
        if (this.$isFreeform) {
            n = this.$bottom;
        } else if (this.$openApp) {
            dynamicIslandContentFakeView = this.this$0;
            context = dynamicIslandContentFakeView.getContext();
            o.f((Object)context, (String)"getContext(...)");
            n = dynamicIslandContentFakeView.getScreenHeight(context);
        } else {
            n = view.getBottom();
        }
        view.getRenderNode().setPosition(new Rect(view.getLeft(), view.getTop(), n2, n));
        outline.setRoundRect(0, 0, n2, n, this.this$0.radius);
    }
}
