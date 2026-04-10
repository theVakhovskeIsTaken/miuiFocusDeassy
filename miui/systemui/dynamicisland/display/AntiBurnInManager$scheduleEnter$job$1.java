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
 *  f1.M
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
import f1.M;
import miui.systemui.dynamicisland.display.AntiBurnInManager;

@f(c="miui.systemui.dynamicisland.display.AntiBurnInManager$scheduleEnter$job$1", f="AntiBurnInManager.kt", l={195}, m="invokeSuspend")
public static final class AntiBurnInManager.scheduleEnter.job.1
extends l
implements o {
    final String $key;
    int label;
    final AntiBurnInManager this$0;

    public AntiBurnInManager.scheduleEnter.job.1(AntiBurnInManager antiBurnInManager, String string, d d2) {
        this.this$0 = antiBurnInManager;
        this.$key = string;
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
        } else {
            k.b((Object)object);
            long l2 = this.this$0.calculateRemainingTime();
            object = this.$key;
            String string = this.this$0.getCurrentState();
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("enter burn in after:");
            stringBuilder.append(l2);
            stringBuilder.append(" for ");
            stringBuilder.append((String)object);
            stringBuilder.append(", current:");
            stringBuilder.append(string);
            Log.i((String)"DynamicIslandBurnIn", (String)stringBuilder.toString());
            this.label = 1;
            if (M.b((long)l2, (d)this) == object2) {
                return object2;
            }
        }
        this.this$0.enter(1);
        return s.a;
    }
}
