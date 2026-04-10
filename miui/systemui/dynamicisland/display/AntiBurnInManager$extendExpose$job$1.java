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
import f1.E;
import f1.M;
import miui.systemui.dynamicisland.display.AntiBurnInManager;
import miui.systemui.dynamicisland.window.content.DynamicIslandContentView;

@f(c="miui.systemui.dynamicisland.display.AntiBurnInManager$extendExpose$job$1", f="AntiBurnInManager.kt", l={278}, m="invokeSuspend")
public static final class AntiBurnInManager.extendExpose.job.1
extends l
implements o {
    int label;
    final AntiBurnInManager this$0;

    public AntiBurnInManager.extendExpose.job.1(AntiBurnInManager antiBurnInManager, d d2) {
        this.this$0 = antiBurnInManager;
        super(2, d2);
    }

    public final d create(Object object, d d2) {
        return new /* invalid duplicate definition of identical inner class */;
    }

    public final Object invoke(E e, d d2) {
        return (this.create(e, d2)).invokeSuspend(s.a);
    }

    /*
     * WARNING - void declaration
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
            void var1_5;
            k.b((Object)object);
            long l2 = AntiBurnInManager.Companion.getEXTEND_EXPOSE_TIME();
            AntiBurnInManager antiBurnInManager = this.this$0;
            DynamicIslandContentView dynamicIslandContentView = antiBurnInManager.getBigIslandHandler().getCurrent();
            AntiBurnInManager.BurnInStates burnInStates = null;
            if (dynamicIslandContentView != null) {
                AntiBurnInManager.BurnInStates burnInStates2 = dynamicIslandContentView.getBurnInState();
            } else {
                Object var1_4 = null;
            }
            Object object3 = this.this$0.getSmallIslandHandler().getCurrent();
            if (object3 != null) {
                burnInStates = ((DynamicIslandContentView)((Object)object3)).getBurnInState();
            }
            object3 = new StringBuilder();
            ((StringBuilder)object3).append("extend (");
            ((StringBuilder)object3).append(var1_5);
            ((StringBuilder)object3).append(", ");
            ((StringBuilder)object3).append((Object)burnInStates);
            ((StringBuilder)object3).append(") for ");
            ((StringBuilder)object3).append(l2);
            antiBurnInManager.log(((StringBuilder)object3).toString());
            this.label = 1;
            if (M.b((long)l2, (d)this) == object2) {
                return object2;
            }
        }
        this.this$0.enter(3);
        return s.a;
    }
}
