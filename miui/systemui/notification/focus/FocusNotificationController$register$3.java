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
 *  android.database.ContentObserver
 *  f1.E
 *  f1.M
 */
package miui.systemui.notification.focus;

import G0.k;
import G0.s;
import K0.d;
import L0.c;
import M0.f;
import M0.l;
import U0.o;
import android.database.ContentObserver;
import f1.E;
import f1.M;
import miui.systemui.notification.focus.Const;
import miui.systemui.notification.focus.FocusNotificationController;

@f(c="miui.systemui.notification.focus.FocusNotificationController$register$3", f="FocusNotificationController.kt", l={166}, m="invokeSuspend")
public static final class FocusNotificationController.register.3
extends l
implements o {
    final FocusNotificationController.register.observer.1 $observer;
    int label;
    final FocusNotificationController this$0;

    public FocusNotificationController.register.3(FocusNotificationController focusNotificationController, FocusNotificationController.register.observer.1 var2_2, d d2) {
        this.this$0 = focusNotificationController;
        this.$observer = var2_2;
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
            this.this$0.context.getContentResolver().registerContentObserver(Const.Provider.URI_CAN_SHOW_FOCUS, false, (ContentObserver)this.$observer, -1);
            this.label = 1;
            if (M.a((d)this) == object2) {
                return object2;
            }
        }
        throw new G0.c();
    }
}
