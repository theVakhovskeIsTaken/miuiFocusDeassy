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
 *  U0.a
 *  U0.o
 *  android.view.ViewTreeObserver
 *  android.view.ViewTreeObserver$InternalInsetsInfo
 *  android.view.ViewTreeObserver$OnComputeInternalInsetsListener
 *  h1.h
 *  h1.o
 *  h1.q
 */
package miui.systemui.dynamicisland.window.domain.interactor;

import G0.k;
import G0.s;
import K0.d;
import L0.c;
import M0.f;
import M0.l;
import U0.a;
import android.view.ViewTreeObserver;
import h1.h;
import h1.o;
import h1.q;
import miui.systemui.dynamicisland.window.domain.interactor.DynamicIslandTouchRegionInteractor;

@f(c="miui.systemui.dynamicisland.window.domain.interactor.DynamicIslandTouchRegionInteractor$computeInternalInsetsEvent$1", f="DynamicIslandTouchRegionInteractor.kt", l={84}, m="invokeSuspend")
public static final class DynamicIslandTouchRegionInteractor.computeInternalInsetsEvent.1
extends l
implements U0.o {
    private Object L$0;
    int label;
    final DynamicIslandTouchRegionInteractor this$0;

    public DynamicIslandTouchRegionInteractor.computeInternalInsetsEvent.1(DynamicIslandTouchRegionInteractor dynamicIslandTouchRegionInteractor, d d2) {
        this.this$0 = dynamicIslandTouchRegionInteractor;
        super(2, d2);
    }

    public final d create(Object object, d object2) {
        object2 = new /* invalid duplicate definition of identical inner class */;
        object2.L$0 = object;
        return object2;
    }

    public final Object invoke(q q2, d d2) {
        return (this.create(q2, d2)).invokeSuspend(s.a);
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
            object = (q)this.L$0;
            ViewTreeObserver.OnComputeInternalInsetsListener onComputeInternalInsetsListener2 = new ViewTreeObserver.OnComputeInternalInsetsListener((q)object){
                final q $$this$conflatedCallbackFlow;
                {
                    this.$$this$conflatedCallbackFlow = q2;
                }

                public void onComputeInternalInsets(ViewTreeObserver.InternalInsetsInfo internalInsetsInfo) {
                    if (internalInsetsInfo != null) {
                        h.b((Object)this.$$this$conflatedCallbackFlow.i((Object)internalInsetsInfo));
                    }
                }
            };
            ViewTreeObserver viewTreeObserver = this.this$0.windowView.getViewTreeObserver();
            viewTreeObserver.addOnComputeInternalInsetsListener(onComputeInternalInsetsListener2);
            a a2 = new a(viewTreeObserver, onComputeInternalInsetsListener2){
                final onComputeInternalInsetsListener.1 $onComputeInternalInsetsListener;
                final ViewTreeObserver $viewTreeObserver;
                {
                    this.$viewTreeObserver = viewTreeObserver;
                    this.$onComputeInternalInsetsListener = var2_2;
                    super(0);
                }

                public final void invoke() {
                    if (this.$viewTreeObserver.isAlive()) {
                        ViewTreeObserver viewTreeObserver = this.$viewTreeObserver;
                        onComputeInternalInsetsListener.1 var1_2 = this.$onComputeInternalInsetsListener;
                        viewTreeObserver.removeOnComputeInternalInsetsListener((ViewTreeObserver.OnComputeInternalInsetsListener)var1_2);
                    }
                }
            };
            this.label = 1;
            if (o.a((q)object, (a)a2, (d)this) != object2) return s.a;
            return object2;
        }
    }
}
