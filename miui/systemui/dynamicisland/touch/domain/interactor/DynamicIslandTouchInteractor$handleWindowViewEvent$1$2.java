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
 *  android.view.MotionEvent
 *  f1.E
 *  i1.g
 *  i1.y
 */
package miui.systemui.dynamicisland.touch.domain.interactor;

import G0.k;
import G0.s;
import K0.d;
import L0.c;
import M0.f;
import M0.l;
import U0.o;
import android.view.MotionEvent;
import f1.E;
import i1.g;
import i1.y;
import miui.systemui.dynamicisland.touch.TouchEvent;
import miui.systemui.dynamicisland.touch.domain.interactor.DynamicIslandTouchInteractor;
import miui.systemui.dynamicisland.window.domain.interactor.DynamicIslandWindowViewTouchInteractor;

@f(c="miui.systemui.dynamicisland.touch.domain.interactor.DynamicIslandTouchInteractor$handleWindowViewEvent$1$2", f="DynamicIslandTouchInteractor.kt", l={155}, m="invokeSuspend")
public static final class DynamicIslandTouchInteractor.handleWindowViewEvent.1.2
extends l
implements o {
    final DynamicIslandWindowViewTouchInteractor $this_apply;
    int label;
    final DynamicIslandTouchInteractor this$0;

    public DynamicIslandTouchInteractor.handleWindowViewEvent.1.2(DynamicIslandWindowViewTouchInteractor dynamicIslandWindowViewTouchInteractor, DynamicIslandTouchInteractor dynamicIslandTouchInteractor, d d2) {
        this.$this_apply = dynamicIslandWindowViewTouchInteractor;
        this.this$0 = dynamicIslandTouchInteractor;
        super(2, d2);
    }

    public final d create(Object object, d d2) {
        return new /* invalid duplicate definition of identical inner class */;
    }

    public final Object invoke(E e, d d2) {
        return (this.create(e, d2)).invokeSuspend(s.a);
    }

    public final Object invokeSuspend(Object g2) {
        Object object = c.c();
        int n = this.label;
        if (n != 0) {
            if (n != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            k.b((Object)g2);
        } else {
            k.b((Object)g2);
            y y2 = this.$this_apply.getIslandTouchEvent();
            g2 = new g(this.this$0){
                final DynamicIslandTouchInteractor this$0;
                {
                    this.this$0 = dynamicIslandTouchInteractor;
                }

                public final Object emit(TouchEvent touchEvent, d d2) {
                    touchEvent.setResult(DynamicIslandTouchInteractor.access$onTouchEvent(this.this$0, touchEvent.getEvent(), touchEvent.getSource()));
                    DynamicIslandTouchInteractor dynamicIslandTouchInteractor = this.this$0;
                    d2 = touchEvent.getEvent();
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("handle touch event ");
                    stringBuilder.append(touchEvent);
                    DynamicIslandTouchInteractor.access$logEvent(dynamicIslandTouchInteractor, (MotionEvent)d2, stringBuilder.toString());
                    return s.a;
                }
            };
            this.label = 1;
            if (y2.collect(g2, (d)this) == object) {
                return object;
            }
        }
        throw new G0.c();
    }
}
