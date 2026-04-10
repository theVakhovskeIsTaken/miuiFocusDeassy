/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.graphics.Canvas
 *  android.graphics.Point
 *  android.view.View
 *  android.view.View$DragShadowBuilder
 *  kotlin.jvm.internal.o
 */
package miui.systemui.dynamicisland.window.content;

import android.graphics.Canvas;
import android.graphics.Point;
import android.view.View;
import kotlin.jvm.internal.o;
import miui.systemui.dynamicisland.window.content.DynamicIslandBaseContentViewController;

public static final class DynamicIslandBaseContentViewController.dragShareCard.shadowBuilder.1
extends View.DragShadowBuilder {
    final View $dragView;
    final int $height;
    final int $width;
    final DynamicIslandBaseContentViewController<T> this$0;

    public DynamicIslandBaseContentViewController.dragShareCard.shadowBuilder.1(View view, int n, int n2, DynamicIslandBaseContentViewController<? extends T> dynamicIslandBaseContentViewController) {
        this.$dragView = view;
        this.$width = n;
        this.$height = n2;
        this.this$0 = dynamicIslandBaseContentViewController;
        super(view);
    }

    public void onDrawShadow(Canvas canvas) {
        o.g((Object)canvas, (String)"canvas");
        this.$dragView.draw(canvas);
    }

    public void onProvideShadowMetrics(Point point, Point point2) {
        o.g((Object)point, (String)"outShadowSize");
        o.g((Object)point2, (String)"outShadowTouchPoint");
        super.onProvideShadowMetrics(point, point2);
        point.set(this.$width, this.$height);
        point2.set(this.$width - (int)this.this$0.getMarginCardRight(), this.$height / 2 - (int)this.this$0.getMarginCardTop());
    }
}
