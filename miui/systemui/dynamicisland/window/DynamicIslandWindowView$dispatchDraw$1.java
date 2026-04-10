/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  G0.k
 *  G0.s
 *  K0.d
 *  L0.c
 *  M0.f
 *  M0.l
 *  U0.o
 *  android.graphics.Canvas
 *  f1.E
 *  i1.t
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
import f1.E;
import i1.t;
import miui.systemui.dynamicisland.window.DynamicIslandWindowView;

@f(c="miui.systemui.dynamicisland.window.DynamicIslandWindowView$dispatchDraw$1", f="DynamicIslandWindowView.kt", l={1560}, m="invokeSuspend")
public static final class DynamicIslandWindowView.dispatchDraw.1
extends l
implements o {
    final Canvas $canvas;
    int label;
    final DynamicIslandWindowView this$0;

    public DynamicIslandWindowView.dispatchDraw.1(DynamicIslandWindowView dynamicIslandWindowView, Canvas canvas, d d2) {
        this.this$0 = dynamicIslandWindowView;
        this.$canvas = canvas;
        super(2, d2);
    }

    public final d create(Object object, d d2) {
        return new /* invalid duplicate definition of identical inner class */;
    }

    public final Object invoke(E e, d d2) {
        return (this.create(e, d2)).invokeSuspend(s.a);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public final Object invokeSuspend(Object object) {
        Object object2 = c.c();
        int n = this.label;
        if (n != 0) {
            if (n != 1) throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            k.b((Object)object);
            return s.a;
        } else {
            k.b((Object)object);
            t t2 = this.this$0._dispatchDrawEvent;
            object = this.$canvas;
            this.label = 1;
            if (t2.emit(object, (d)this) != object2) return s.a;
            return object2;
        }
    }
}
