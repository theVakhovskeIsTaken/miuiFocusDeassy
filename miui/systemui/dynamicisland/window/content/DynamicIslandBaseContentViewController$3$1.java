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
package miui.systemui.dynamicisland.window.content;

import G0.k;
import G0.s;
import K0.d;
import L0.c;
import M0.b;
import M0.f;
import M0.l;
import U0.p;

@f(c="miui.systemui.dynamicisland.window.content.DynamicIslandBaseContentViewController$3$1", f="DynamicIslandBaseContentViewController.kt", l={}, m="invokeSuspend")
public static final class DynamicIslandBaseContentViewController.1
extends l
implements p {
    boolean Z$0;
    boolean Z$1;
    int label;

    public DynamicIslandBaseContentViewController.1(d d2) {
    }

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
}
