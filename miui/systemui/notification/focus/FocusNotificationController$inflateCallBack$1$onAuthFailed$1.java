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
 *  U0.o
 *  android.util.Log
 *  f1.E
 */
package miui.systemui.notification.focus;

import G0.k;
import G0.s;
import K0.d;
import L0.c;
import M0.b;
import M0.f;
import M0.l;
import U0.o;
import android.util.Log;
import f1.E;
import miui.systemui.notification.focus.FocusNotificationController;

@f(c="miui.systemui.notification.focus.FocusNotificationController$inflateCallBack$1$onAuthFailed$1", f="FocusNotificationController.kt", l={}, m="invokeSuspend")
public static final class FocusNotificationController.inflateCallBack.1.onAuthFailed.1
extends l
implements o {
    final String $key;
    final String $packageName;
    int label;
    final FocusNotificationController this$0;

    public FocusNotificationController.inflateCallBack.1.onAuthFailed.1(String string, String string2, FocusNotificationController focusNotificationController, d d2) {
        this.$key = string;
        this.$packageName = string2;
        this.this$0 = focusNotificationController;
        super(2, d2);
    }

    public final d create(Object object, d d2) {
        return new /* invalid duplicate definition of identical inner class */;
    }

    public final Object invoke(E e, d d2) {
        return (this.create(e, d2)).invokeSuspend(s.a);
    }

    public final Object invokeSuspend(Object object) {
        c.c();
        if (this.label == 0) {
            k.b((Object)object);
            object = this.$key;
            String string = this.$packageName;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("onAuthFailed ");
            stringBuilder.append((String)object);
            stringBuilder.append(" ");
            stringBuilder.append(string);
            Log.e((String)"FocusPlugin", (String)stringBuilder.toString());
            this.this$0.authResult.put(this.$key, b.a((boolean)false));
            FocusNotificationController.inflateFinishCallback$default(this.this$0, this.$key, null, 2, null);
            return s.a;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
