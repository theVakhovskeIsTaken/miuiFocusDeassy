/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  G0.k
 *  G0.s
 *  K0.d
 *  L0.c
 *  M0.b
 *  M0.f
 *  M0.l
 *  U0.p
 *  android.view.View
 *  f1.E
 *  i1.f
 *  i1.g
 *  i1.h
 */
package miui.systemui.dynamicisland.window.content;

import G0.k;
import G0.s;
import K0.d;
import L0.c;
import M0.b;
import M0.l;
import U0.p;
import android.view.View;
import f1.E;
import i1.f;
import i1.g;
import i1.h;
import miui.systemui.dynamicisland.event.DynamicIslandEventCoordinator;
import miui.systemui.dynamicisland.window.content.DynamicIslandBaseContentView;
import miui.systemui.dynamicisland.window.content.DynamicIslandBaseContentViewController;
import miui.systemui.dynamicisland.window.content.DynamicIslandContentFakeView;

@M0.f(c="miui.systemui.dynamicisland.window.content.DynamicIslandBaseContentViewController$3", f="DynamicIslandBaseContentViewController.kt", l={104}, m="invokeSuspend")
public static final class DynamicIslandBaseContentViewController.3
extends l
implements p {
    int label;
    final DynamicIslandBaseContentViewController<T> this$0;

    public DynamicIslandBaseContentViewController.3(DynamicIslandBaseContentViewController<? extends T> dynamicIslandBaseContentViewController, d d2) {
        this.this$0 = dynamicIslandBaseContentViewController;
        super(3, d2);
    }

    public final Object invoke(E e, View view, d d2) {
        return new /* invalid duplicate definition of identical inner class */.invokeSuspend(s.a);
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
            if (!(this.this$0.getView() instanceof DynamicIslandContentFakeView)) return s.a;
            object = h.i((f)((DynamicIslandContentFakeView)((Object)this.this$0.getView())).getTrackingToOpenMW(), (f)((DynamicIslandContentFakeView)((Object)this.this$0.getView())).getStartEnterMiniWindowBeforeAnimation(), (p)new p(null){
                boolean Z$0;
                boolean Z$1;
                int label;

                public final Object invoke(boolean bl, boolean bl2, d object) {
                    object = new /* invalid duplicate definition of identical inner class */;
                    object.Z$0 = bl;
                    object.Z$1 = bl2;
                    return object.invokeSuspend(s.a);
                }

                public final Object invokeSuspend(Object object) {
                    c.c();
                    if (this.label == 0) {
                        k.b((Object)object);
                        boolean bl = this.Z$0;
                        boolean bl2 = this.Z$1;
                        bl = bl || bl2;
                        return b.a((boolean)bl);
                    }
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            });
            g g2 = new g(this.this$0){
                final DynamicIslandBaseContentViewController<T> this$0;
                {
                    this.this$0 = dynamicIslandBaseContentViewController;
                }

                public final Object emit(boolean bl, d object) {
                    object = ((DynamicIslandBaseContentView)((Object)this.this$0.getView())).getDynamicIslandEventCoordinator();
                    if (object != null) {
                        ((DynamicIslandEventCoordinator)object).updateTouchRegion();
                    }
                    return s.a;
                }
            };
            this.label = 1;
            if (object.collect(g2, (d)this) != object2) return s.a;
            return object2;
        }
    }
}
