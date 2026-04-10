/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  G0.s
 *  K0.d
 *  android.graphics.Canvas
 *  android.graphics.Rect
 *  i1.g
 */
package miui.systemui.dynamicisland.window;

import G0.s;
import K0.d;
import android.graphics.Canvas;
import android.graphics.Rect;
import i1.g;
import miui.systemui.dynamicisland.window.DynamicIslandWindowController;

public static final class DynamicIslandWindowController.drawDebugWindowSize.1<T>
implements g {
    final Rect $rect;
    final DynamicIslandWindowController this$0;

    public DynamicIslandWindowController.drawDebugWindowSize.1(DynamicIslandWindowController dynamicIslandWindowController, Rect rect) {
        this.this$0 = dynamicIslandWindowController;
        this.$rect = rect;
    }

    public final Object emit(Canvas canvas, d d2) {
        this.this$0.windowView.getDrawingRect(this.$rect);
        canvas.drawRect(this.$rect, this.this$0.getPaint());
        return s.a;
    }
}
