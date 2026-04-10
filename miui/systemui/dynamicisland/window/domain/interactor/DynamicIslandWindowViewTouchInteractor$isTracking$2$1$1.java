/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  G0.c
 *  G0.k
 *  G0.s
 *  K0.d
 *  L0.c
 *  M0.b
 *  M0.f
 *  M0.l
 *  U0.o
 *  android.view.MotionEvent
 *  f1.E
 *  i1.g
 *  i1.u
 */
package miui.systemui.dynamicisland.window.domain.interactor;

import G0.k;
import G0.s;
import K0.d;
import L0.c;
import M0.b;
import M0.f;
import M0.l;
import U0.o;
import android.view.MotionEvent;
import f1.E;
import i1.g;
import i1.u;
import miui.systemui.dynamicisland.window.domain.interactor.DynamicIslandWindowViewTouchInteractor;

@f(c="miui.systemui.dynamicisland.window.domain.interactor.DynamicIslandWindowViewTouchInteractor$isTracking$2$1$1", f="DynamicIslandWindowViewTouchInteractor.kt", l={64}, m="invokeSuspend")
public static final class DynamicIslandWindowViewTouchInteractor.isTracking.1.1
extends l
implements o {
    final u $isTracking;
    int label;
    final DynamicIslandWindowViewTouchInteractor this$0;

    public DynamicIslandWindowViewTouchInteractor.isTracking.1.1(DynamicIslandWindowViewTouchInteractor dynamicIslandWindowViewTouchInteractor, u u2, d d2) {
        this.this$0 = dynamicIslandWindowViewTouchInteractor;
        this.$isTracking = u2;
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
            object = this.this$0.getTrackTouchEvent();
            g g2 = new g(this.$isTracking){
                final u $isTracking;
                {
                    this.$isTracking = u2;
                }

                public final Object emit(MotionEvent motionEvent, d d2) {
                    this.$isTracking.setValue((Object)b.a((boolean)(DynamicIslandWindowViewTouchInteractor.isTracking.2.access$invoke$lambda$1$isUpOrCancel(motionEvent) ^ true)));
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
