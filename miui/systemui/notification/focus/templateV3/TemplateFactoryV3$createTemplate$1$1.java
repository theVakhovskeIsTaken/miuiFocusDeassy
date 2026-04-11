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
 *  android.util.Log
 *  com.android.systemui.plugins.miui.notification.FocusNotificationContent
 *  f1.E
 *  f1.f
 *  kotlin.jvm.internal.o
 *  miui.systemui.util.concurrency.ConcurrencyModule
 *  o1.a
 *  o1.c
 */
package miui.systemui.notification.focus.templateV3;

import G0.k;
import G0.s;
import K0.d;
import M0.l;
import android.service.notification.StatusBarNotification;
import android.util.Log;
import com.android.systemui.plugins.miui.notification.FocusNotificationContent;
import f1.E;
import f1.f;
import kotlin.jvm.internal.o;
import miui.systemui.notification.focus.InflateAndAuthCallBack;
import miui.systemui.notification.focus.model.Template;
import miui.systemui.notification.focus.templateV3.TemplateFactoryV3;
import miui.systemui.util.concurrency.ConcurrencyModule;
import o1.a;
import o1.c;

@M0.f(c="miui.systemui.notification.focus.templateV3.TemplateFactoryV3$createTemplate$1$1", f="TemplateFactoryV3.kt", l={1061, 965, 992}, m="invokeSuspend")
public static final class TemplateFactoryV3.createTemplate.1
extends l
implements U0.o {
    final FocusNotificationContent $focusContent;
    final InflateAndAuthCallBack $inflateCallBack;
    final boolean $isFlip;
    final StatusBarNotification $sbn;
    final Template $template;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    boolean Z$0;
    int label;
    final TemplateFactoryV3 this$0;

    public TemplateFactoryV3.createTemplate.1(TemplateFactoryV3 templateFactoryV3, StatusBarNotification statusBarNotification, Template template, FocusNotificationContent focusNotificationContent, InflateAndAuthCallBack inflateAndAuthCallBack, boolean bl, d d2) {
        this.this$0 = templateFactoryV3;
        this.$sbn = statusBarNotification;
        this.$template = template;
        this.$focusContent = focusNotificationContent;
        this.$inflateCallBack = inflateAndAuthCallBack;
        this.$isFlip = bl;
        super(2, d2);
    }

    public final d create(Object object, d d2) {
        return new /* invalid duplicate definition of identical inner class */;
    }

    public final Object invoke(E e, d d2) {
        return (this.create(e, d2)).invokeSuspend(s.a);
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final Object invokeSuspend(Object var1_1) {
        block29: {
            block23: {
                block28: {
                    block27: {
                        block26: {
                            block24: {
                                block25: {
                                    var10_4 = L0.c.c();
                                    var2_5 = this.label;
                                    if (var2_5 != 0) {
                                        if (var2_5 != 1) {
                                            if (var2_5 != 2) {
                                                if (var2_5 != 3) {
                                                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                                }
                                                var4_7 = var5_6 = (a)this.L$0;
                                                k.b((Object)var1_1);
                                                var1_1 = var5_6;
                                                break block23;
                                            }
                                            var4_7 = var5_6 = (a)this.L$0;
                                            k.b((Object)var1_1);
                                            var1_1 = var5_6;
                                            break block24;
                                        }
                                        var3_9 = this.Z$0;
                                        var5_6 = (InflateAndAuthCallBack)this.L$5;
                                        var6_10 = (FocusNotificationContent)this.L$4;
                                        var4_7 = (StatusBarNotification)this.L$3;
                                        var8_11 = (Template)this.L$2;
                                        var7_13 /* !! */  = (TemplateFactoryV3)this.L$1;
                                        var9_14 = (a)this.L$0;
                                        k.b((Object)var1_1);
                                        var1_1 = var9_14;
                                        break block25;
                                    }
                                    k.b((Object)var1_1);
                                    var5_6 = TemplateFactoryV3.access$getKeyLocks$p(this.this$0);
                                    var6_10 = this.$sbn.getKey();
                                    var1_1 = var4_7 = var5_6.get(var6_10);
                                    if (var4_7 == null && (var4_7 = var5_6.putIfAbsent(var6_10, var1_1 = c.b((boolean)false, (int)1, null))) != null) {
                                        var1_1 = var4_7;
                                    }
                                    var1_1 = (a)var1_1;
                                    try {
                                        o.d((Object)var1_1);
                                        var7_13 /* !! */  = this.this$0;
                                        var8_11 = this.$template;
                                        var4_7 = this.$sbn;
                                        var6_10 = this.$focusContent;
                                        var5_6 = this.$inflateCallBack;
                                        var3_9 = this.$isFlip;
                                        this.L$0 = var1_1;
                                        this.L$1 = var7_13 /* !! */ ;
                                        this.L$2 = var8_11;
                                        this.L$3 = var4_7;
                                        this.L$4 = var6_10;
                                        this.L$5 = var5_6;
                                        this.Z$0 = var3_9;
                                        this.label = 1;
                                        var9_15 = var1_1.a(null, (d)this);
                                        if (var9_15 != var10_4) break block25;
                                        return var10_4;
                                    }
                                    catch (Throwable var1_3) {}
                                }
                                o.d((Object)var8_11);
                                if (!TemplateFactoryV3.access$isBgPicDownloadFail(var7_13 /* !! */ , var8_11, (StatusBarNotification)var4_7)) break block26;
                                Log.e((String)"FocusPlugin", (String)"createTemplateError: BgPicDownloadFail");
                                this.L$0 = var1_1;
                                this.L$1 = null;
                                this.L$2 = null;
                                this.L$3 = null;
                                this.L$4 = null;
                                this.L$5 = null;
                                this.label = 2;
                                var4_7 = TemplateFactoryV3.access$resetErrorNotification(var7_13 /* !! */ , (FocusNotificationContent)var6_10, (StatusBarNotification)var4_7, (InflateAndAuthCallBack)var5_6, (d)this);
                                if (var4_7 != var10_4) break block24;
                                return var10_4;
                            }
                            var4_7 = var1_1;
                            var4_7 = var5_6 = s.a;
                        }
                        if (!var3_9) ** GOTO lbl88
                        try {
                            TemplateFactoryV3.createTinyTemplateView$default(var7_13 /* !! */ , var8_11, (StatusBarNotification)var4_7, false, (FocusNotificationContent)var6_10, 4, null);
                            if (var8_11.getHideDeco()) break block27;
                            TemplateFactoryV3.createDecoTemplateView$default(var7_13 /* !! */ , var8_11, (StatusBarNotification)var4_7, false, (FocusNotificationContent)var6_10, 4, null);
                            TemplateFactoryV3.createDecoLandTemplateView$default(var7_13 /* !! */ , var8_11, (StatusBarNotification)var4_7, false, (FocusNotificationContent)var6_10, 4, null);
                        }
                        catch (Exception var8_12) {
                            break block28;
                        }
                    }
                    TemplateFactoryV3.createStandardTemplateView$default(var7_13 /* !! */ , var8_11, (StatusBarNotification)var4_7, false, (FocusNotificationContent)var6_10, (InflateAndAuthCallBack)var5_6, 4, null);
                    var8_11 = ConcurrencyModule.INSTANCE.getUiScope();
                    var7_13 /* !! */  = new U0.o((InflateAndAuthCallBack)var5_6, (StatusBarNotification)var4_7, (FocusNotificationContent)var6_10, null){
                        final FocusNotificationContent $focusContent;
                        final InflateAndAuthCallBack $inflateCallBack;
                        final StatusBarNotification $sbn;
                        int label;
                        {
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
                            L0.c.c();
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
                    };
                    f.b((E)var8_11, null, null, (U0.o)var7_13 /* !! */ , (int)3, null);
                    var1_1.c(null);
                    TemplateFactoryV3.access$getKeyLocks$p(this.this$0).remove(this.$sbn.getKey());
                    return s.a;
                }
                try {
                    var8_12.printStackTrace();
                    this.L$0 = var1_1;
                    this.L$1 = null;
                    this.L$2 = null;
                    this.L$3 = null;
                    this.L$4 = null;
                    this.L$5 = null;
                    this.label = 3;
                    var4_7 = TemplateFactoryV3.access$resetErrorNotification(var7_13 /* !! */ , (FocusNotificationContent)var6_10, (StatusBarNotification)var4_7, (InflateAndAuthCallBack)var5_6, (d)this);
                    if (var4_7 == var10_4) {
                        return var10_4;
                    }
                    break block23;
                }
                catch (Throwable var4_8) {
                    var5_6 = var1_1;
                    var1_1 = var4_8;
                    var4_7 = var5_6;
                }
                break block29;
            }
            var4_7 = var1_1;
            try {
                var4_7 = var5_6 = s.a;
            }
            catch (Throwable var1_2) {
                break block29;
            }
            var1_1.c(null);
            TemplateFactoryV3.access$getKeyLocks$p(this.this$0).remove(this.$sbn.getKey());
            return var4_7;
        }
        var4_7.c(null);
        throw var1_1;
        TemplateFactoryV3.access$getKeyLocks$p(this.this$0).remove(this.$sbn.getKey());
        throw var1_3;
    }
}
