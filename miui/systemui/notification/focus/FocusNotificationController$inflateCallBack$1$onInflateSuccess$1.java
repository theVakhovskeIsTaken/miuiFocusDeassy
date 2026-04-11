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
 *  com.android.systemui.plugins.miui.notification.FocusNotificationContent
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
import com.android.systemui.plugins.miui.notification.FocusNotificationContent;
import f1.E;
import miui.systemui.notification.focus.FocusNotificationController;

@f(c="miui.systemui.notification.focus.FocusNotificationController$inflateCallBack$1$onInflateSuccess$1", f="FocusNotificationController.kt", l={}, m="invokeSuspend")
public static final class FocusNotificationController.inflateCallBack.1.onInflateSuccess.1
extends l
implements o {
    final FocusNotificationContent $content;
    final String $key;
    int label;
    final FocusNotificationController this$0;

    public FocusNotificationController.inflateCallBack.1.onInflateSuccess.1(String string, FocusNotificationController focusNotificationController, FocusNotificationContent focusNotificationContent, d d2) {
        this.$key = string;
        this.this$0 = focusNotificationController;
        this.$content = focusNotificationContent;
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
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("onInflateSuccess ");
            stringBuilder.append((String)object);
            Log.e((String)"FocusPlugin", (String)stringBuilder.toString());
            this.this$0.inflateResult.put(this.$key, b.a((boolean)true));
            this.this$0.inflateFinishCallback(this.$key, this.$content);
            return s.a;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
