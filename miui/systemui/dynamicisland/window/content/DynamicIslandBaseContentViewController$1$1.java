/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  G0.k
 *  G0.s
 *  H0.m
 *  K0.d
 *  L0.c
 *  M0.b
 *  M0.f
 *  M0.l
 *  U0.s
 */
package miui.systemui.dynamicisland.window.content;

import G0.k;
import G0.s;
import H0.m;
import K0.d;
import L0.c;
import M0.b;
import M0.f;
import M0.l;

@f(c="miui.systemui.dynamicisland.window.content.DynamicIslandBaseContentViewController$1$1", f="DynamicIslandBaseContentViewController.kt", l={}, m="invokeSuspend")
public static final class DynamicIslandBaseContentViewController.1
extends l
implements U0.s {
    Object L$0;
    Object L$1;
    boolean Z$0;
    boolean Z$1;
    boolean Z$2;
    int label;

    public DynamicIslandBaseContentViewController.1(d d2) {
    }

    public final Object invoke(String string, String string2, boolean bl, boolean bl2, boolean bl3, d object) {
        object = new /* invalid duplicate definition of identical inner class */;
        object.L$0 = string;
        object.L$1 = string2;
        object.Z$0 = bl;
        object.Z$1 = bl2;
        object.Z$2 = bl3;
        return object.invokeSuspend(s.a);
    }

    public final Object invokeSuspend(Object object) {
        c.c();
        if (this.label == 0) {
            k.b((Object)object);
            object = (String)this.L$0;
            String string = (String)this.L$1;
            boolean bl = this.Z$0;
            boolean bl2 = this.Z$1;
            boolean bl3 = this.Z$2;
            return m.f((Object[])new Object[]{object, string, b.a((boolean)(bl ^ true)), b.a((boolean)bl2), b.a((boolean)bl3)});
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
