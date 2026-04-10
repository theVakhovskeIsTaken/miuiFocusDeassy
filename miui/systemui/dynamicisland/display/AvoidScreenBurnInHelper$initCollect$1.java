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
 *  i1.g
 */
package miui.systemui.dynamicisland.display;

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
import miui.systemui.dynamicisland.display.AvoidScreenBurnInHelper;
import miui.systemui.dynamicisland.event.DynamicIslandEventCoordinator;

@f(c="miui.systemui.dynamicisland.display.AvoidScreenBurnInHelper$initCollect$1", f="AvoidScreenBurnInHelper.kt", l={235}, m="invokeSuspend")
public static final class AvoidScreenBurnInHelper.initCollect.1
extends l
implements o {
    int label;
    final AvoidScreenBurnInHelper this$0;

    public AvoidScreenBurnInHelper.initCollect.1(AvoidScreenBurnInHelper avoidScreenBurnInHelper, d d2) {
        this.this$0 = avoidScreenBurnInHelper;
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
            object = this.this$0.getScreenBurnInStrategy();
            g g2 = new g(this.this$0){
                final AvoidScreenBurnInHelper this$0;
                {
                    this.this$0 = avoidScreenBurnInHelper;
                }

                public final Object emit(int n, d object) {
                    object = new StringBuilder();
                    ((StringBuilder)object).append(" flow screenBurnInStrategy  ");
                    ((StringBuilder)object).append(n);
                    ((StringBuilder)object).append(" ");
                    Log.d((String)"AvoidScreenBurnInHelper", (String)((StringBuilder)object).toString());
                    object = this.this$0.getEventCoordinator();
                    if (object != null) {
                        ((DynamicIslandEventCoordinator)object).handleScreenBurnInStrategy(n);
                    }
                    return s.a;
                }
            };
            this.label = 1;
            if (object.collect(g2, (d)this) == object2) {
                return object2;
            }
        }
        throw new G0.c();
    }
}
