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
 *  android.view.MotionEvent
 *  f1.E
 *  i1.f
 *  i1.g
 */
package miui.systemui.dynamicisland.touch.domain.interactor;

import G0.k;
import G0.s;
import K0.d;
import L0.c;
import M0.l;
import U0.o;
import android.view.MotionEvent;
import f1.E;
import i1.f;
import i1.g;
import miui.systemui.dynamicisland.touch.TouchEvent;
import miui.systemui.dynamicisland.touch.domain.interactor.DynamicIslandExternalTouchInteractor;
import miui.systemui.dynamicisland.touch.domain.interactor.DynamicIslandTouchInteractor;

@M0.f(c="miui.systemui.dynamicisland.touch.domain.interactor.DynamicIslandTouchInteractor$handleExternalEvent$1$1", f="DynamicIslandTouchInteractor.kt", l={134}, m="invokeSuspend")
public static final class DynamicIslandTouchInteractor.handleExternalEvent.1.1
extends l
implements o {
    final DynamicIslandExternalTouchInteractor $this_apply;
    int label;
    final DynamicIslandTouchInteractor this$0;

    public DynamicIslandTouchInteractor.handleExternalEvent.1.1(DynamicIslandExternalTouchInteractor dynamicIslandExternalTouchInteractor, DynamicIslandTouchInteractor dynamicIslandTouchInteractor, d d2) {
        this.$this_apply = dynamicIslandExternalTouchInteractor;
        this.this$0 = dynamicIslandTouchInteractor;
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
    public final Object invokeSuspend(Object g2) {
        Object object = c.c();
        int n = this.label;
        if (n != 0) {
            if (n != 1) throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            k.b((Object)g2);
            return s.a;
        } else {
            k.b((Object)g2);
            f f2 = this.$this_apply.getExternalInterceptTouchEvent();
            g2 = new g(this.this$0){
                final DynamicIslandTouchInteractor this$0;
                {
                    this.this$0 = dynamicIslandTouchInteractor;
                }

                public final Object emit(TouchEvent touchEvent, d object) {
                    touchEvent.setResult(DynamicIslandTouchInteractor.access$onInterceptTouchEvent(this.this$0, touchEvent.getEvent(), touchEvent.getSource()));
                    object = this.this$0;
                    MotionEvent motionEvent = touchEvent.getEvent();
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("intercept touch event ");
                    stringBuilder.append(touchEvent);
                    DynamicIslandTouchInteractor.access$logEvent((DynamicIslandTouchInteractor)object, motionEvent, stringBuilder.toString());
                    return s.a;
                }
            };
            this.label = 1;
            if (f2.collect(g2, (d)this) != object) return s.a;
            return object;
        }
    }
}
