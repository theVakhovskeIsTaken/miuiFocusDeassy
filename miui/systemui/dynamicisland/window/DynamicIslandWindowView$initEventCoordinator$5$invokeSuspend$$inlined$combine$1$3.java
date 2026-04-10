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
 *  i1.g
 */
package miui.systemui.dynamicisland.window;

import G0.k;
import G0.s;
import K0.d;
import L0.c;
import M0.b;
import M0.f;
import M0.l;
import U0.p;
import i1.g;

@f(c="miui.systemui.dynamicisland.window.DynamicIslandWindowView$initEventCoordinator$5$invokeSuspend$$inlined$combine$1$3", f="DynamicIslandWindowView.kt", l={234}, m="invokeSuspend")
public static final class DynamicIslandWindowView$initEventCoordinator$5$invokeSuspend$.inlined.combine.3
extends l
implements p {
    private Object L$0;
    Object L$1;
    int label;

    public DynamicIslandWindowView$initEventCoordinator$5$invokeSuspend$.inlined.combine.3(d d2) {
    }

    /*
     * Ignored method signature, as it can't be verified against descriptor
     */
    public final Object invoke(g g2, Object[] objectArray, d object) {
        object = new /* invalid duplicate definition of identical inner class */;
        object.L$0 = g2;
        object.L$1 = objectArray;
        return object.invokeSuspend(s.a);
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
            object = (g)this.L$0;
            Boolean[] booleanArray = (Boolean[])((Object[])this.L$1);
            boolean bl = false;
            boolean bl2 = booleanArray[0];
            boolean bl3 = booleanArray[1];
            boolean bl4 = booleanArray[2];
            boolean bl5 = booleanArray[3];
            boolean bl6 = booleanArray[4];
            boolean bl7 = booleanArray[5];
            boolean bl8 = booleanArray[6];
            boolean bl9 = booleanArray[7];
            if (bl2 || bl6 || bl3 || bl4 || bl5 || bl7 || bl8 || bl9) {
                bl = true;
            }
            Boolean bl10 = b.a((boolean)bl);
            this.label = 1;
            if (object.emit((Object)bl10, (d)this) != object2) return s.a;
            return object2;
        }
    }
}
