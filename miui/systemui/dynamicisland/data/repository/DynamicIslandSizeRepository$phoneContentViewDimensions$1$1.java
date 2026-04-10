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
 *  U0.o
 *  i1.g
 */
package miui.systemui.dynamicisland.data.repository;

import G0.k;
import G0.s;
import K0.d;
import L0.c;
import M0.f;
import M0.l;
import U0.o;
import i1.g;

@f(c="miui.systemui.dynamicisland.data.repository.DynamicIslandSizeRepository$phoneContentViewDimensions$1$1", f="DynamicIslandSizeRepository.kt", l={75}, m="invokeSuspend")
public static final class DynamicIslandSizeRepository.phoneContentViewDimensions.1.1
extends l
implements o {
    private Object L$0;
    int label;

    public DynamicIslandSizeRepository.phoneContentViewDimensions.1.1(d d2) {
    }

    public final d create(Object object, d object2) {
        object2 = new /* invalid duplicate definition of identical inner class */;
        object2.L$0 = object;
        return object2;
    }

    public final Object invoke(g g2, d d2) {
        return (this.create(g2, d2)).invokeSuspend(s.a);
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
            s s2 = s.a;
            this.label = 1;
            if (object.emit((Object)s2, (d)this) != object2) return s.a;
            return object2;
        }
    }
}
