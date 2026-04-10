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
 *  i1.f
 *  i1.h
 */
package miui.systemui.dynamicisland.display;

import G0.k;
import G0.s;
import K0.d;
import L0.c;
import M0.l;
import U0.o;
import f1.E;
import i1.f;
import i1.h;
import miui.systemui.dynamicisland.display.AvoidScreenBurnInHelper;

@M0.f(c="miui.systemui.dynamicisland.display.AvoidScreenBurnInHelper$initCollect$2", f="AvoidScreenBurnInHelper.kt", l={241}, m="invokeSuspend")
public static final class AvoidScreenBurnInHelper.initCollect.2
extends l
implements o {
    int label;
    final AvoidScreenBurnInHelper this$0;

    public AvoidScreenBurnInHelper.initCollect.2(AvoidScreenBurnInHelper avoidScreenBurnInHelper, d d2) {
        this.this$0 = avoidScreenBurnInHelper;
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
            object = this.this$0.getNotificationPanelExpanded();
            o o2 = new o(this.this$0, null){
                boolean Z$0;
                int label;
                final AvoidScreenBurnInHelper this$0;
                {
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
                        AvoidScreenBurnInHelper.access$debugLog((AvoidScreenBurnInHelper)object, "AvoidScreenBurnInHelper", stringBuilder.toString());
                        if (bl) {
                            this.this$0.stop();
                        } else {
                            this.this$0.start();
                        }
                        return s.a;
                    }
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            };
            this.label = 1;
            if (h.h((f)object, (o)o2, (d)this) != object2) return s.a;
            return object2;
        }
    }
}
