/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.graphics.Outline
 *  android.view.View
 *  android.view.ViewOutlineProvider
 *  kotlin.jvm.internal.o
 *  kotlin.jvm.internal.y
 */
package miui.systemui.dynamicisland.window.content;

import android.graphics.Outline;
import android.view.View;
import android.view.ViewOutlineProvider;
import kotlin.jvm.internal.o;
import kotlin.jvm.internal.y;
import miui.systemui.dynamicisland.window.content.DynamicIslandContentFakeView;

public static final class DynamicIslandContentFakeView.updateOutline.1
extends ViewOutlineProvider {
    final y $bottom;
    final int $left;
    final int $top;
    final DynamicIslandContentFakeView this$0;

    public DynamicIslandContentFakeView.updateOutline.1(DynamicIslandContentFakeView dynamicIslandContentFakeView, y y2, int n, int n2) {
        this.this$0 = dynamicIslandContentFakeView;
        this.$bottom = y2;
        this.$left = n;
        this.$top = n2;
    }

    public void getOutline(View view, Outline outline) {
        o.g((Object)view, (String)"view");
        o.g((Object)outline, (String)"outline");
        this.this$0.updateExpandViewBlur(this.$bottom.a, true, false);
        outline.setRoundRect(this.$left, this.$top, this.this$0.mFakeViewTrackingParams.getRight(), this.$bottom.a, this.this$0.radius);
    }
}
