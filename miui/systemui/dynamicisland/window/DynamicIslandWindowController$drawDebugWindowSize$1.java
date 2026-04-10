/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  G0.c
 *  G0.k
 *  G0.s
 *  K0.d
 *  L0.c
 *  M0.f
 *  M0.l
 *  U0.o
 *  android.graphics.Canvas
 *  android.graphics.Rect
 *  f1.E
 *  i1.g
 */
package miui.systemui.dynamicisland.window;

import G0.k;
import G0.s;
import K0.d;
import L0.c;
import M0.f;
import M0.l;
import U0.o;
import android.graphics.Canvas;
import android.graphics.Rect;
import f1.E;
import i1.g;
import miui.systemui.dynamicisland.window.DynamicIslandWindowController;

@f(c="miui.systemui.dynamicisland.window.DynamicIslandWindowController$drawDebugWindowSize$1", f="DynamicIslandWindowController.kt", l={156}, m="invokeSuspend")
public static final class DynamicIslandWindowController.drawDebugWindowSize.1
extends l
implements o {
    int label;
    final DynamicIslandWindowController this$0;

    public DynamicIslandWindowController.drawDebugWindowSize.1(DynamicIslandWindowController dynamicIslandWindowController, d d2) {
        this.this$0 = dynamicIslandWindowController;
        super(2, d2);
    }

    public final d create(Object object, d d2) {
        return new /* invalid duplicate definition of identical inner class */;
    }

    public final Object invoke(E e, d d2) {
        return (this.create(e, d2)).invokeSuspend(s.a);
    }

    public final Object invokeSuspend(Object object) {
        Object object2 = c.c();
        int n = this.label;
        if (n != 0) {
            if (n != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            k.b((Object)object);
        } else {
            k.b((Object)object);
            Object object3 = new Rect();
            object = this.this$0.windowView.getDispatchDrawEvent();
            object3 = new g(this.this$0, (Rect)object3){
                final Rect $rect;
                final DynamicIslandWindowController this$0;
                {
                    this.this$0 = dynamicIslandWindowController;
                    this.$rect = rect;
                }

                public final Object emit(Canvas canvas, d d2) {
                    DynamicIslandWindowController.access$getWindowView$p(this.this$0).getDrawingRect(this.$rect);
                    canvas.drawRect(this.$rect, DynamicIslandWindowController.access$getPaint(this.this$0));
                    return s.a;
                }
            };
            this.label = 1;
            if (object.collect((g)object3, (d)this) == object2) {
                return object2;
            }
        }
        throw new G0.c();
    }
}
