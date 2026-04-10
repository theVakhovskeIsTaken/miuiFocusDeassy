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
 *  f1.M
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
import f1.M;
import miui.systemui.dynamicisland.window.AppLockController;

@f(c="miui.systemui.dynamicisland.window.AppLockController$init$1", f="AppLockController.kt", l={70}, m="invokeSuspend")
public static final class AppLockController.init.1
extends l
implements o {
    int label;
    final AppLockController this$0;

    public AppLockController.init.1(AppLockController appLockController, d d2) {
        this.this$0 = appLockController;
        super(2, d2);
    }

    public final d create(Object object, d d2) {
        return new /* invalid duplicate definition of identical inner class */;
    }

    public final Object invoke(E e, d d2) {
        return (this.create(e, d2)).invokeSuspend(s.a);
    }

    public final Object invokeSuspend(Object object) {
        Object object2 = c.c();
        int n = this.label;
        if (n != 0) {
            if (n != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            k.b((Object)object);
        } else {
            k.b((Object)object);
            this.this$0.start();
            this.this$0.provider.start();
            this.label = 1;
            if (M.a((d)this) == object2) {
                return object2;
            }
        }
        throw new G0.c();
    }
}
