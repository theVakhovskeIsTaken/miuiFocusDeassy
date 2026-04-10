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
 *  U0.a
 *  U0.o
 *  android.view.MotionEvent
 *  f1.E
 *  f1.f
 *  i1.I
 *  i1.K
 *  i1.g
 *  i1.h
 *  i1.u
 *  kotlin.jvm.internal.p
 */
package miui.systemui.dynamicisland.window.domain.interactor;

import G0.k;
import G0.s;
import K0.d;
import L0.c;
import M0.b;
import U0.a;
import U0.o;
import android.view.MotionEvent;
import f1.E;
import f1.f;
import i1.I;
import i1.K;
import i1.g;
import i1.h;
import i1.u;
import kotlin.jvm.internal.p;
import miui.systemui.dynamicisland.window.domain.interactor.DynamicIslandWindowViewTouchInteractor;

public static final class DynamicIslandWindowViewTouchInteractor.isTracking.2
extends p
implements a {
    final DynamicIslandWindowViewTouchInteractor this$0;

    public DynamicIslandWindowViewTouchInteractor.isTracking.2(DynamicIslandWindowViewTouchInteractor dynamicIslandWindowViewTouchInteractor) {
        this.this$0 = dynamicIslandWindowViewTouchInteractor;
        super(0);
    }

    public static final /* synthetic */ boolean access$invoke$lambda$1$isUpOrCancel(MotionEvent motionEvent) {
        return DynamicIslandWindowViewTouchInteractor.isTracking.2.invoke$lambda$1$isUpOrCancel(motionEvent);
    }

    private static final boolean invoke$lambda$1$isUpOrCancel(MotionEvent motionEvent) {
        boolean bl;
        int n = motionEvent.getActionMasked();
        boolean bl2 = bl = true;
        if (n != 1) {
            bl2 = n == 3 ? bl : false;
        }
        return bl2;
    }

    public final I invoke() {
        DynamicIslandWindowViewTouchInteractor dynamicIslandWindowViewTouchInteractor = this.this$0;
        u u2 = K.a((Object)Boolean.FALSE);
        f.b((E)dynamicIslandWindowViewTouchInteractor.scope, null, null, (o)new o(dynamicIslandWindowViewTouchInteractor, u2, null){
            final u $isTracking;
            int label;
            final DynamicIslandWindowViewTouchInteractor this$0;
            {
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
        }, (int)3, null);
        return h.b((u)u2);
    }
}
