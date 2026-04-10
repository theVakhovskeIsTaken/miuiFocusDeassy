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
 */
package miui.systemui.dynamicisland.display;

import G0.k;
import G0.s;
import K0.d;
import L0.c;
import M0.f;
import M0.l;
import U0.o;
import miui.systemui.dynamicisland.display.AvoidScreenBurnInHelper;

@f(c="miui.systemui.dynamicisland.display.AvoidScreenBurnInHelper$initCollect$2$1", f="AvoidScreenBurnInHelper.kt", l={}, m="invokeSuspend")
public static final class AvoidScreenBurnInHelper.initCollect.1
extends l
implements o {
    boolean Z$0;
    int label;
    final AvoidScreenBurnInHelper this$0;

    public AvoidScreenBurnInHelper.initCollect.1(AvoidScreenBurnInHelper avoidScreenBurnInHelper, d d2) {
        this.this$0 = avoidScreenBurnInHelper;
        super(2, d2);
    }

    public final d create(Object object, d object2) {
        object2 = new /* invalid duplicate definition of identical inner class */;
        object2.Z$0 = (Boolean)object;
        return object2;
    }

    public final Object invoke(boolean bl, d d2) {
        return (this.create(bl, d2)).invokeSuspend(s.a);
    }

    public final Object invokeSuspend(Object object) {
        c.c();
        if (this.label == 0) {
            k.b((Object)object);
            boolean bl = this.Z$0;
            object = this.this$0;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(" flow notificationPanelExpanded  ");
            stringBuilder.append(bl);
            stringBuilder.append(" ");
            ((AvoidScreenBurnInHelper)object).debugLog("AvoidScreenBurnInHelper", stringBuilder.toString());
            if (bl) {
                this.this$0.stop();
            } else {
                this.this$0.start();
            }
            return s.a;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
