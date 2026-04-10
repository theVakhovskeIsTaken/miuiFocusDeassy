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
import miui.systemui.dynamicisland.event.DynamicIslandEventCoordinator;
import miui.systemui.dynamicisland.window.DynamicIslandWindowView;

@f(c="miui.systemui.dynamicisland.window.DynamicIslandWindowView$initEventCoordinator$2", f="DynamicIslandWindowView.kt", l={333}, m="invokeSuspend")
public static final class DynamicIslandWindowView.initEventCoordinator.2
extends l
implements o {
    int label;
    final DynamicIslandWindowView this$0;

    public DynamicIslandWindowView.initEventCoordinator.2(DynamicIslandWindowView dynamicIslandWindowView, d d2) {
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
            if (object == null || (object = ((DynamicIslandEventCoordinator)object).getBigIslandRegion()) == null) return s.a;
            1 var4_4 = 1.INSTANCE;
            this.label = 1;
            if (object.collect(var4_4, (d)this) != object2) throw new G0.c();
            return object2;
        }
    }
}
