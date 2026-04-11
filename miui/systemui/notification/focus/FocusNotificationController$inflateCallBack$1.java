/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  G0.k
 *  G0.s
 *  K0.d
 *  L0.c
 *  M0.b
 *  U0.o
 *  android.util.Log
 *  com.android.systemui.plugins.miui.notification.FocusNotificationContent
 *  f1.E
 *  f1.f
 *  kotlin.jvm.internal.o
 */
package miui.systemui.notification.focus;

import G0.k;
import G0.s;
import K0.d;
import L0.c;
import M0.b;
import android.util.Log;
import com.android.systemui.plugins.miui.notification.FocusNotificationContent;
import f1.E;
import f1.f;
import kotlin.jvm.internal.o;
import miui.systemui.notification.focus.FocusNotificationController;
import miui.systemui.notification.focus.InflateAndAuthCallBack;

public static final class FocusNotificationController.inflateCallBack.1
implements InflateAndAuthCallBack {
    final FocusNotificationController this$0;

    public FocusNotificationController.inflateCallBack.1(FocusNotificationController focusNotificationController) {
        this.this$0 = focusNotificationController;
    }

    @Override
    public void onAuthFailed(String string, String string2) {
        o.g((Object)string, (String)"key");
        o.g((Object)string2, (String)"packageName");
        f.b((E)this.this$0.scope, null, null, (U0.o)new U0.o(string, string2, this.this$0, null){
            final String $key;
            final String $packageName;
            int label;
            final FocusNotificationController this$0;
            {
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
                    FocusNotificationController.access$getAuthResult$p(this.this$0).put(this.$key, b.a((boolean)false));
                    FocusNotificationController.inflateFinishCallback$default(this.this$0, this.$key, null, 2, null);
                    return s.a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }, (int)3, null);
    }

    @Override
    public void onAuthFinish(String string, String string2) {
        o.g((Object)string, (String)"key");
        o.g((Object)string2, (String)"packageName");
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("onAuthFinish ");
        stringBuilder.append(string);
        stringBuilder.append(" ");
        stringBuilder.append(string2);
        Log.e((String)"FocusPlugin", (String)stringBuilder.toString());
    }

    @Override
    public void onAuthSuccess(String string, String string2) {
        o.g((Object)string, (String)"key");
        o.g((Object)string2, (String)"packageName");
        f.b((E)this.this$0.scope, null, null, (U0.o)new U0.o(string, string2, this.this$0, null){
            final String $key;
            final String $packageName;
            int label;
            final FocusNotificationController this$0;
            {
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
                    String string = this.$key;
                    object = this.$packageName;
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("onAuthSuccess ");
                    stringBuilder.append(string);
                    stringBuilder.append(" ");
                    stringBuilder.append((String)object);
                    Log.e((String)"FocusPlugin", (String)stringBuilder.toString());
                    FocusNotificationController.access$getAuthResult$p(this.this$0).put(this.$key, b.a((boolean)true));
                    FocusNotificationController.inflateFinishCallback$default(this.this$0, this.$key, null, 2, null);
                    return s.a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }, (int)3, null);
    }

    @Override
    public void onInflateFailed(String string, FocusNotificationContent focusNotificationContent) {
        o.g((Object)string, (String)"key");
        o.g((Object)focusNotificationContent, (String)"content");
        f.b((E)this.this$0.scope, null, null, (U0.o)new U0.o(string, this.this$0, focusNotificationContent, null){
            final FocusNotificationContent $content;
            final String $key;
            int label;
            final FocusNotificationController this$0;
            {
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
                    String string = this.$key;
                    object = new StringBuilder();
                    ((StringBuilder)object).append("onInflateFailed ");
                    ((StringBuilder)object).append(string);
                    Log.e((String)"FocusPlugin", (String)((StringBuilder)object).toString());
                    FocusNotificationController.access$getInflateResult$p(this.this$0).put(this.$key, b.a((boolean)false));
                    FocusNotificationController.access$inflateFinishCallback(this.this$0, this.$key, this.$content);
                    return s.a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }, (int)3, null);
    }

    @Override
    public void onInflateFinish(String string, FocusNotificationContent focusNotificationContent) {
        o.g((Object)string, (String)"key");
        o.g((Object)focusNotificationContent, (String)"content");
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("onInflateFinish ");
        stringBuilder.append(string);
        Log.e((String)"FocusPlugin", (String)stringBuilder.toString());
        this.this$0.onInflateEnd(string, focusNotificationContent);
    }

    @Override
    public void onInflateSuccess(String string, FocusNotificationContent focusNotificationContent) {
        o.g((Object)string, (String)"key");
        o.g((Object)focusNotificationContent, (String)"content");
        f.b((E)this.this$0.scope, null, null, (U0.o)new U0.o(string, this.this$0, focusNotificationContent, null){
            final FocusNotificationContent $content;
            final String $key;
            int label;
            final FocusNotificationController this$0;
            {
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
                    FocusNotificationController.access$getInflateResult$p(this.this$0).put(this.$key, b.a((boolean)true));
                    FocusNotificationController.access$inflateFinishCallback(this.this$0, this.$key, this.$content);
                    return s.a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }, (int)3, null);
    }
}
