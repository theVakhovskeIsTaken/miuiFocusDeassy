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
 *  android.service.notification.StatusBarNotification
 *  com.android.systemui.plugins.miui.notification.FocusNotificationContent
 *  f1.E
 *  kotlin.jvm.internal.o
 */
package miui.systemui.notification.focus.templateV3;

import G0.k;
import G0.s;
import K0.d;
import L0.c;
import M0.f;
import M0.l;
import android.service.notification.StatusBarNotification;
import com.android.systemui.plugins.miui.notification.FocusNotificationContent;
import f1.E;
import kotlin.jvm.internal.o;
import miui.systemui.notification.focus.InflateAndAuthCallBack;

@f(c="miui.systemui.notification.focus.templateV3.TemplateFactoryV3$createTemplate$1$1$1$1", f="TemplateFactoryV3.kt", l={}, m="invokeSuspend")
public static final class TemplateFactoryV3.createTemplate.1.1.1.1
extends l
implements U0.o {
    final FocusNotificationContent $focusContent;
    final InflateAndAuthCallBack $inflateCallBack;
    final StatusBarNotification $sbn;
    int label;

    public TemplateFactoryV3.createTemplate.1.1.1.1(InflateAndAuthCallBack inflateAndAuthCallBack, StatusBarNotification statusBarNotification, FocusNotificationContent focusNotificationContent, d d2) {
        this.$inflateCallBack = inflateAndAuthCallBack;
        this.$sbn = statusBarNotification;
        this.$focusContent = focusNotificationContent;
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
            InflateAndAuthCallBack inflateAndAuthCallBack = this.$inflateCallBack;
            object = this.$sbn.getKey();
            o.f((Object)object, (String)"getKey(...)");
            inflateAndAuthCallBack.onInflateFinish((String)object, this.$focusContent);
            return s.a;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
