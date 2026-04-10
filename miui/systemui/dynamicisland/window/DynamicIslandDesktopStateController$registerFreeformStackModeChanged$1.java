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
 *  android.util.Log
 *  f1.E
 *  i1.g
 */
package miui.systemui.dynamicisland.window;

import G0.k;
import G0.s;
import K0.d;
import L0.c;
import M0.f;
import M0.l;
import U0.o;
import android.util.Log;
import f1.E;
import i1.g;
import miui.systemui.dynamicisland.window.DynamicIslandDesktopStateController;

@f(c="miui.systemui.dynamicisland.window.DynamicIslandDesktopStateController$registerFreeformStackModeChanged$1", f="DynamicIslandDesktopStateController.kt", l={135}, m="invokeSuspend")
public static final class DynamicIslandDesktopStateController.registerFreeformStackModeChanged.1
extends l
implements o {
    int label;
    final DynamicIslandDesktopStateController this$0;

    public DynamicIslandDesktopStateController.registerFreeformStackModeChanged.1(DynamicIslandDesktopStateController dynamicIslandDesktopStateController, d d2) {
        this.this$0 = dynamicIslandDesktopStateController;
        super(2, d2);
    }

    public final d create(Object object, d d2) {
        return new /* invalid duplicate definition of identical inner class */;
    }

    public final Object invoke(E e, d d2) {
        return (this.create(e, d2)).invokeSuspend(s.a);
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
            object = this.this$0.freeFormStackMode;
            g g2 = new g(this.this$0){
                final DynamicIslandDesktopStateController this$0;
                {
                    this.this$0 = dynamicIslandDesktopStateController;
                }

                public final Object emit(int n, d object) {
                    String string = DynamicIslandDesktopStateController.access$getTAG$p(this.this$0);
                    object = new StringBuilder();
                    ((StringBuilder)object).append("registerFreeformStackModeChanged it:");
                    ((StringBuilder)object).append(n);
                    Log.d((String)string, (String)((StringBuilder)object).toString());
                    if (n == 0 || n == 10) {
                        this.this$0.runDesktopAnim(false);
                    }
                    return s.a;
                }
            };
            this.label = 1;
            if (object.collect(g2, (d)this) != object2) return s.a;
            return object2;
        }
    }
}
