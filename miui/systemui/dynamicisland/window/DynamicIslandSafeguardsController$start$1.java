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
 *  android.util.Log
 *  f1.E
 *  i1.I
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
import i1.I;
import i1.g;
import miui.systemui.dynamicisland.window.DynamicIslandSafeguardsController;

@f(c="miui.systemui.dynamicisland.window.DynamicIslandSafeguardsController$start$1", f="DynamicIslandSafeguardsController.kt", l={69}, m="invokeSuspend")
public static final class DynamicIslandSafeguardsController.start.1
extends l
implements o {
    int label;
    final DynamicIslandSafeguardsController this$0;

    public DynamicIslandSafeguardsController.start.1(DynamicIslandSafeguardsController dynamicIslandSafeguardsController, d d2) {
        this.this$0 = dynamicIslandSafeguardsController;
        super(2, d2);
    }

    public final d create(Object object, d d2) {
        return new /* invalid duplicate definition of identical inner class */;
    }

    public final Object invoke(E e, d d2) {
        return (this.create(e, d2)).invokeSuspend(s.a);
    }

    public final Object invokeSuspend(Object g2) {
        Object object = c.c();
        int n = this.label;
        if (n != 0) {
            if (n != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            k.b((Object)g2);
        } else {
            k.b((Object)g2);
            I i2 = this.this$0.getWindowViewController().isFreeformAnimRunning();
            g2 = new g(this.this$0){
                final DynamicIslandSafeguardsController this$0;
                {
                    this.this$0 = dynamicIslandSafeguardsController;
                }

                public final Object emit(boolean bl, d object) {
                    object = new StringBuilder();
                    ((StringBuilder)object).append("isFreeformAnimRunning ");
                    ((StringBuilder)object).append(bl);
                    Log.d((String)"DynamicIslandSafeguardsController", (String)((StringBuilder)object).toString());
                    if (bl) {
                        this.this$0.delayResetWindowAnimation(5L);
                    } else {
                        this.this$0.cancelDelayResetWindowAnimation();
                    }
                    return s.a;
                }
            };
            this.label = 1;
            if (i2.collect(g2, (d)this) == object) {
                return object;
            }
        }
        throw new G0.c();
    }
}
