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

@f(c="miui.systemui.dynamicisland.window.domain.interactor.DynamicIslandWindowStateInteractor$visible$1", f="DynamicIslandWindowStateInteractor.kt", l={}, m="invokeSuspend")
public static final class DynamicIslandWindowStateInteractor.visible.1
extends l
implements p {
    int I$0;
    boolean Z$0;
    int label;

    public DynamicIslandWindowStateInteractor.visible.1(d d2) {
    }

    public final Object invoke(int n, boolean bl, d object) {
        object = new /* invalid duplicate definition of identical inner class */;
        object.I$0 = n;
        object.Z$0 = bl;
        return object.invokeSuspend(s.a);
    }

    public final Object invokeSuspend(Object object) {
        c.c();
        if (this.label == 0) {
            k.b((Object)object);
            int n = this.I$0;
            boolean bl = this.Z$0;
            bl = n > 0 || bl;
            return b.a((boolean)bl);
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
