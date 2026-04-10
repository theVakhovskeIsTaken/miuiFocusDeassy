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
package miui.systemui.dynamicisland.display;

import G0.k;
import G0.s;
import K0.d;
import L0.c;
import M0.b;
import M0.f;
import M0.l;
import U0.p;
import miui.systemui.dynamicisland.display.AvoidScreenBurnInHelper;

@f(c="miui.systemui.dynamicisland.display.AvoidScreenBurnInHelper$screenBurnInStrategy$1", f="AvoidScreenBurnInHelper.kt", l={}, m="invokeSuspend")
public static final class AvoidScreenBurnInHelper.screenBurnInStrategy.1
extends l
implements p {
    int I$0;
    boolean Z$0;
    int label;
    final AvoidScreenBurnInHelper this$0;

    public AvoidScreenBurnInHelper.screenBurnInStrategy.1(AvoidScreenBurnInHelper avoidScreenBurnInHelper, d d2) {
        this.this$0 = avoidScreenBurnInHelper;
        super(3, d2);
    }

    public final Object invoke(int n, boolean bl, d object) {
        object = new /* invalid duplicate definition of identical inner class */;
        object.I$0 = n;
        object.Z$0 = bl;
        return object.invokeSuspend(s.a);
    }

    /*
     * Enabled aggressive block sorting
     */
    public final Object invokeSuspend(Object object) {
        c.c();
        if (this.label != 0) throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        k.b((Object)object);
        int n = this.I$0;
        boolean bl = this.Z$0;
        if (!this.this$0.ready) {
            n = -1;
            return b.c((int)n);
        }
        if (!((Boolean)this.this$0._notificationPanelExpanded.getValue()).booleanValue()) {
            if (bl) {
                n = 5;
                return b.c((int)n);
            }
            if (!this.this$0.recoverBackgroundAlpha) return b.c((int)n);
            this.this$0.recoverBackgroundAlpha = false;
        }
        n = 4;
        return b.c((int)n);
    }
}
