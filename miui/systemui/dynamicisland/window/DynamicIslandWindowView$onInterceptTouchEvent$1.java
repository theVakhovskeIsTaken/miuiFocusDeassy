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
 *  f1.E
 */
package miui.systemui.dynamicisland.window;

import G0.k;
import G0.s;
import K0.d;
import L0.c;
import M0.f;
import M0.l;
import U0.o;
import f1.E;
import miui.systemui.dynamicisland.touch.TouchEvent;
import miui.systemui.dynamicisland.window.DynamicIslandWindowView;

@f(c="miui.systemui.dynamicisland.window.DynamicIslandWindowView$onInterceptTouchEvent$1", f="DynamicIslandWindowView.kt", l={1391}, m="invokeSuspend")
public static final class DynamicIslandWindowView.onInterceptTouchEvent.1
extends l
implements o {
    final TouchEvent $touchEvent;
    int label;
    final DynamicIslandWindowView this$0;

    public DynamicIslandWindowView.onInterceptTouchEvent.1(DynamicIslandWindowView dynamicIslandWindowView, TouchEvent touchEvent, d d2) {
        this.this$0 = dynamicIslandWindowView;
        this.$touchEvent = touchEvent;
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
            object = this.this$0._onInterceptTouchEvent;
            TouchEvent touchEvent = this.$touchEvent;
            this.label = 1;
            if (object.emit((Object)touchEvent, (d)this) != object2) return s.a;
            return object2;
        }
    }
}
