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
 *  U0.a
 *  U0.o
 *  f1.E
 *  f1.f
 *  h1.o
 *  h1.q
 *  h1.t
 *  h1.t$a
 *  kotlin.jvm.internal.o
 *  miui.app.IFreeformCallback
 *  miui.app.IFreeformCallback$Stub
 *  miui.app.MiuiFreeFormManager
 *  miui.app.MiuiFreeFormManager$MiuiFreeFormStackInfo
 *  miui.systemui.dynamicisland.window.DynamicIslandDesktopStateController$freeFormStackMode$1$callback$1$dispatchFreeFormStackModeChanged$1
 *  miui.systemui.util.CommonUtils
 */
package miui.systemui.dynamicisland.window;

import G0.k;
import G0.s;
import K0.d;
import L0.c;
import M0.l;
import U0.a;
import f1.E;
import f1.f;
import h1.o;
import h1.q;
import h1.t;
import miui.app.IFreeformCallback;
import miui.app.MiuiFreeFormManager;
import miui.systemui.dynamicisland.window.DynamicIslandDesktopStateController;
import miui.systemui.util.CommonUtils;

@M0.f(c="miui.systemui.dynamicisland.window.DynamicIslandDesktopStateController$freeFormStackMode$1", f="DynamicIslandDesktopStateController.kt", l={127}, m="invokeSuspend")
public static final class DynamicIslandDesktopStateController.freeFormStackMode.1
extends l
implements U0.o {
    private Object L$0;
    int label;
    final DynamicIslandDesktopStateController this$0;

    public DynamicIslandDesktopStateController.freeFormStackMode.1(DynamicIslandDesktopStateController dynamicIslandDesktopStateController, d d2) {
        this.this$0 = dynamicIslandDesktopStateController;
        super(2, d2);
    }

    public final d create(Object object, d object2) {
        object2 = new /* invalid duplicate definition of identical inner class */;
        object2.L$0 = object;
        return object2;
    }

    public final Object invoke(q q2, d d2) {
        return (this.create(q2, d2)).invokeSuspend(s.a);
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
            object = (q)this.L$0;
            if (MiuiFreeFormManager.getMiuiFreeformVersion() != 3) {
                this.this$0.getMiniWindowDataRepo().setSupport(false);
                t.a.a((t)object, null, (int)1, null);
                return s.a;
            }
            IFreeformCallback.Stub stub = new IFreeformCallback.Stub((q)object, this.this$0){
                final q $$this$conflatedCallbackFlow;
                final DynamicIslandDesktopStateController this$0;
                {
                    this.$$this$conflatedCallbackFlow = q2;
                    this.this$0 = dynamicIslandDesktopStateController;
                }

                public void dispatchFreeFormStackModeChanged(int n, MiuiFreeFormManager.MiuiFreeFormStackInfo miuiFreeFormStackInfo) {
                    kotlin.jvm.internal.o.g((Object)miuiFreeFormStackInfo, (String)"stackInfo");
                    this.$$this$conflatedCallbackFlow.i((Object)n);
                    if (n != 2 && n != 4) {
                        boolean bl = CommonUtils.INSTANCE.getIS_TABLET() && n == DynamicIslandDesktopStateController.access$getACTION_FREEFORM_TO_FULLSCREEN$p(this.this$0);
                        f.b((E)DynamicIslandDesktopStateController.access$getScope$p(this.this$0), null, null, (U0.o)new callback.dispatchFreeFormStackModeChanged.1(this.this$0, miuiFreeFormStackInfo, bl, null), (int)3, null);
                    }
                }
            };
            this.this$0.getMiniWindowDataRepo().setSupport(true);
            MiuiFreeFormManager.registerFreeformCallback((IFreeformCallback)stub);
            a a2 = new a(stub){
                final callback.1 $callback;
                {
                    this.$callback = var1_1;
                    super(0);
                }

                public final void invoke() {
                    MiuiFreeFormManager.unregisterFreeformCallback((IFreeformCallback)this.$callback);
                }
            };
            this.label = 1;
            if (o.a((q)object, (a)a2, (d)this) != object2) return s.a;
            return object2;
        }
    }
}
