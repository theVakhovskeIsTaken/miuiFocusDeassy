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
 *  U0.s
 */
package miui.systemui.dynamicisland.domain.interactor;

import G0.k;
import K0.d;
import L0.c;
import M0.b;
import M0.f;
import M0.l;
import U0.s;

@f(c="miui.systemui.dynamicisland.domain.interactor.DynamicIslandRegionSamplingInteractor$regionSampling$1", f="DynamicIslandRegionSamplingInteractor.kt", l={}, m="invokeSuspend")
public static final class DynamicIslandRegionSamplingInteractor.regionSampling.1
extends l
implements s {
    int I$0;
    boolean Z$0;
    boolean Z$1;
    boolean Z$2;
    boolean Z$3;
    int label;

    public DynamicIslandRegionSamplingInteractor.regionSampling.1(d d2) {
    }

    public final Object invoke(boolean bl, boolean bl2, boolean bl3, int n, boolean bl4, d object) {
        object = new /* invalid duplicate definition of identical inner class */;
        object.Z$0 = bl;
        object.Z$1 = bl2;
        object.Z$2 = bl3;
        object.I$0 = n;
        object.Z$3 = bl4;
        return object.invokeSuspend(G0.s.a);
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
        boolean bl4 = this.Z$3;
        if (bl && !bl4 && !bl2) {
            bl2 = bl = true;
            if (!bl3) return b.a((boolean)bl2);
            if (n == 1) {
                bl2 = bl;
                return b.a((boolean)bl2);
            }
        }
        bl2 = false;
        return b.a((boolean)bl2);
    }
}
