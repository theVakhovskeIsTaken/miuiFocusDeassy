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
 *  U0.r
 */
package miui.systemui.dynamicisland.domain.interactor;

import G0.k;
import G0.s;
import K0.d;
import L0.c;
import M0.b;
import M0.f;
import M0.l;
import U0.r;

@f(c="miui.systemui.dynamicisland.domain.interactor.DynamicIslandRegionSamplingInteractor$isRegionDark$2", f="DynamicIslandRegionSamplingInteractor.kt", l={}, m="invokeSuspend")
public static final class DynamicIslandRegionSamplingInteractor.isRegionDark.2
extends l
implements r {
    int I$0;
    boolean Z$0;
    boolean Z$1;
    boolean Z$2;
    int label;

    public DynamicIslandRegionSamplingInteractor.isRegionDark.2(d d2) {
    }

    public final Object invoke(boolean bl, boolean bl2, boolean bl3, int n, d object) {
        object = new /* invalid duplicate definition of identical inner class */;
        object.Z$0 = bl;
        object.Z$1 = bl2;
        object.Z$2 = bl3;
        object.I$0 = n;
        return object.invokeSuspend(s.a);
    }

    /*
     * Enabled aggressive block sorting
     */
    public final Object invokeSuspend(Object object) {
        c.c();
        if (this.label != 0) throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        k.b((Object)object);
        boolean bl = this.Z$0;
        boolean bl2 = this.Z$1;
        boolean bl3 = this.Z$2;
        int n = this.I$0;
        if (bl && !bl2) {
            bl = bl2 = true;
            if (!bl3) return b.a((boolean)bl);
            if (n == 1) {
                bl = bl2;
                return b.a((boolean)bl);
            }
        }
        bl = false;
        return b.a((boolean)bl);
    }
}
