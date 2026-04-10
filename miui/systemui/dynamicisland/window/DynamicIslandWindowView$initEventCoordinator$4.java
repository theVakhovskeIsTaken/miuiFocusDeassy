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
 *  f1.E
 *  i1.g
 *  kotlin.jvm.internal.o
 */
package miui.systemui.dynamicisland.window;

import G0.k;
import G0.s;
import K0.d;
import L0.c;
import M0.b;
import M0.f;
import M0.l;
import f1.E;
import i1.g;
import kotlin.jvm.internal.o;
import miui.systemui.dynamicisland.event.DynamicIslandEventCoordinator;
import miui.systemui.dynamicisland.window.DynamicIslandWindowView;

@f(c="miui.systemui.dynamicisland.window.DynamicIslandWindowView$initEventCoordinator$4", f="DynamicIslandWindowView.kt", l={344}, m="invokeSuspend")
public static final class DynamicIslandWindowView.initEventCoordinator.4
extends l
implements U0.o {
    int label;
    final DynamicIslandWindowView this$0;

    public DynamicIslandWindowView.initEventCoordinator.4(DynamicIslandWindowView dynamicIslandWindowView, d d2) {
        this.this$0 = dynamicIslandWindowView;
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
            if (n != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            k.b((Object)object);
            throw new G0.c();
        } else {
            k.b((Object)object);
            object = this.this$0.getEventCoordinator();
            if (object == null || (object = ((DynamicIslandEventCoordinator)object).getStatusBarVisible()) == null) return s.a;
            g g2 = new g(this.this$0){
                final DynamicIslandWindowView this$0;
                {
                    this.this$0 = dynamicIslandWindowView;
                }

                public final Object emit(Boolean object, d object2) {
                    object2 = this.this$0.getEventCoordinator();
                    if (object2 != null) {
                        ((DynamicIslandEventCoordinator)object2).updateTouchRegion();
                    }
                    if (o.c((Object)object, (Object)b.a((boolean)false)) && this.this$0.getCurrentExpandedState() == null && (object = this.this$0.getEventCoordinator()) != null) {
                        ((DynamicIslandEventCoordinator)object).resetSwipe(0.0f, 0.0f);
                    }
                    return s.a;
                }
            };
            this.label = 1;
            if (object.collect(g2, (d)this) != object2) throw new G0.c();
            return object2;
        }
    }
}
