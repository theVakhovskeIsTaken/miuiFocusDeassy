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
package miui.systemui.dynamicisland.window.domain.interactor;

import G0.k;
import G0.s;
import K0.d;
import L0.c;
import M0.b;
import M0.f;
import M0.l;
import U0.p;
import i1.g;

@f(c="miui.systemui.dynamicisland.window.domain.interactor.DynamicIslandWindowStateInteractor$watchOutsideTouch$lambda$4$$inlined$combine$1$3", f="DynamicIslandWindowStateInteractor.kt", l={234}, m="invokeSuspend")
public static final class DynamicIslandWindowStateInteractor$watchOutsideTouch$lambda$4$.inlined.combine.3
extends l
implements p {
    private Object L$0;
    Object L$1;
    int label;

    public DynamicIslandWindowStateInteractor$watchOutsideTouch$lambda$4$.inlined.combine.3(d d2) {
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
        boolean bl;
        g g2;
        Object object2;
        block4: {
            object2 = c.c();
            int n = this.label;
            if (n != 0) {
                if (n != 1) throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                k.b((Object)object);
                return s.a;
            }
            k.b((Object)object);
            g2 = (g)this.L$0;
            Boolean[] booleanArray = (Boolean[])((Object[])this.L$1);
            int n2 = booleanArray.length;
            bl = false;
            for (n = 0; n < n2; ++n) {
                object = booleanArray[n];
                if (!((Boolean)object).booleanValue()) {
                    continue;
                }
                break block4;
            }
            object = null;
        }
        if (object != null) {
            bl = (Boolean)object;
        }
        object = b.a((boolean)bl);
        this.label = 1;
        if (g2.emit(object, (d)this) != object2) return s.a;
        return object2;
    }
}
