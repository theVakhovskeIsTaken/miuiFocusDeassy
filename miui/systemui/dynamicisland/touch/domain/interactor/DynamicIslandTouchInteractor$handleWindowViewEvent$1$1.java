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
import miui.systemui.dynamicisland.touch.TouchEvent;
import miui.systemui.dynamicisland.touch.domain.interactor.DynamicIslandTouchInteractor;
import miui.systemui.dynamicisland.window.domain.interactor.DynamicIslandWindowViewTouchInteractor;

@f(c="miui.systemui.dynamicisland.touch.domain.interactor.DynamicIslandTouchInteractor$handleWindowViewEvent$1$1", f="DynamicIslandTouchInteractor.kt", l={149}, m="invokeSuspend")
public static final class DynamicIslandTouchInteractor.handleWindowViewEvent.1.1
extends l
implements o {
    final DynamicIslandWindowViewTouchInteractor $this_apply;
    int label;
    final DynamicIslandTouchInteractor this$0;

    public DynamicIslandTouchInteractor.handleWindowViewEvent.1.1(DynamicIslandWindowViewTouchInteractor dynamicIslandWindowViewTouchInteractor, DynamicIslandTouchInteractor dynamicIslandTouchInteractor, d d2) {
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
            object = this.$this_apply.getIslandInterceptTouchEvent();
            g g2 = new g(this.this$0){
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
            if (object.collect(g2, (d)this) == object2) {
                return object2;
            }
        }
        throw new G0.c();
    }
}
