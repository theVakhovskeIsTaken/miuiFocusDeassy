/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  D0.a
 *  G0.k
 *  G0.s
 *  K0.d
 *  L0.c
 *  U0.a
 *  U0.o
 *  android.content.BroadcastReceiver
 *  android.content.Context
 *  android.content.Intent
 *  android.content.IntentFilter
 *  android.os.Handler
 *  android.util.Log
 *  androidx.annotation.UiThread
 *  f1.E
 *  f1.f
 *  f1.l0
 *  f1.l0$a
 *  h1.o
 *  h1.q
 *  h1.t
 *  h1.t$a
 *  i1.f
 *  i1.g
 *  kotlin.jvm.internal.o
 *  miui.app.IFreeformCallback
 *  miui.app.IFreeformCallback$Stub
 *  miui.app.MiuiFreeFormManager
 *  miui.app.MiuiFreeFormManager$MiuiFreeFormStackInfo
 *  miui.systemui.dagger.qualifiers.Background
 *  miui.systemui.dagger.qualifiers.Main
 *  miui.systemui.dagger.qualifiers.SystemUI
 *  miui.systemui.dynamicisland.window.DynamicIslandDesktopStateController$freeFormStackMode$1$callback$1$dispatchFreeFormStackModeChanged$1
 *  miui.systemui.util.CommonUtils
 *  miui.systemui.util.concurrency.DelayableExecutor
 *  miui.systemui.util.coroutines.flow.FlowConflatedKt
 */
package miui.systemui.dynamicisland.window;

import D0.a;
import G0.k;
import G0.s;
import K0.d;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.util.Log;
import androidx.annotation.UiThread;
import f1.E;
import f1.f;
import f1.l0;
import h1.o;
import h1.q;
import h1.t;
import i1.g;
import java.lang.ref.WeakReference;
import miui.app.IFreeformCallback;
import miui.app.MiuiFreeFormManager;
import miui.systemui.dagger.qualifiers.Background;
import miui.systemui.dagger.qualifiers.Main;
import miui.systemui.dagger.qualifiers.SystemUI;
import miui.systemui.dynamicisland.DynamicIslandAnimUtils;
import miui.systemui.dynamicisland.dagger.DynamicIslandScope;
import miui.systemui.dynamicisland.dagger.qualifiers.DynamicIsland;
import miui.systemui.dynamicisland.window.DynamicIslandDesktopStateController;
import miui.systemui.dynamicisland.window.DynamicIslandSafeguardsController;
import miui.systemui.dynamicisland.window.DynamicIslandWindowState;
import miui.systemui.dynamicisland.window.DynamicIslandWindowView;
import miui.systemui.dynamicisland.window.DynamicIslandWindowViewController;
import miui.systemui.dynamicisland.window.DynamicMiniWindowDataRepo;
import miui.systemui.dynamicisland.window.c;
import miui.systemui.util.CommonUtils;
import miui.systemui.util.concurrency.DelayableExecutor;
import miui.systemui.util.coroutines.flow.FlowConflatedKt;

@DynamicIslandScope
public final class DynamicIslandDesktopStateController {
    private final int ACTION_FREEFORM_TO_FULLSCREEN;
    private final String TAG;
    private final DynamicMiniWindowDataRepo _miniWindowDataRepo;
    private final Context context;
    private final desktopReceiver.1 desktopReceiver;
    private boolean desktopRegistered;
    private final i1.f freeFormStackMode;
    private final Handler handler;
    private l0 registerJob;
    private final E scope;
    private final Context sysUIContext;
    private DelayableExecutor uiExecutor;
    private final DynamicIslandWindowView windowView;
    private final WeakReference<DynamicIslandWindowView> windowViewWeakReference;
    private final a workBenchModeRepository;

    public DynamicIslandDesktopStateController(Context context, @SystemUI Context context2, DynamicIslandWindowView dynamicIslandWindowView, @Main DelayableExecutor delayableExecutor, @DynamicIsland E e, @Background Handler handler, a a2) {
        kotlin.jvm.internal.o.g((Object)context, (String)"context");
        kotlin.jvm.internal.o.g((Object)context2, (String)"sysUIContext");
        kotlin.jvm.internal.o.g((Object)((Object)dynamicIslandWindowView), (String)"windowView");
        kotlin.jvm.internal.o.g((Object)delayableExecutor, (String)"uiExecutor");
        kotlin.jvm.internal.o.g((Object)e, (String)"scope");
        kotlin.jvm.internal.o.g((Object)handler, (String)"handler");
        kotlin.jvm.internal.o.g((Object)a2, (String)"workBenchModeRepository");
        this.context = context;
        this.sysUIContext = context2;
        this.windowView = dynamicIslandWindowView;
        this.uiExecutor = delayableExecutor;
        this.scope = e;
        this.handler = handler;
        this.workBenchModeRepository = a2;
        this.TAG = "DesktopStateController";
        this.windowViewWeakReference = new WeakReference<DynamicIslandWindowView>(dynamicIslandWindowView);
        this.ACTION_FREEFORM_TO_FULLSCREEN = 22;
        this._miniWindowDataRepo = new DynamicMiniWindowDataRepo(handler);
        this.desktopReceiver = new BroadcastReceiver(this){
            final DynamicIslandDesktopStateController this$0;
            {
                this.this$0 = dynamicIslandDesktopStateController;
            }

            /*
             * Enabled aggressive block sorting
             */
            public void onReceive(Context object, Intent object2) {
                Object object3;
                String string = null;
                String string2 = null;
                if (object != null && ((object3 = (DynamicIslandWindowView)((Object)DynamicIslandDesktopStateController.access$getWindowViewWeakReference$p(this.this$0).get())) == null || (object3 = ((DynamicIslandWindowView)((Object)object3)).getWindowViewController()) == null || (object3 = ((DynamicIslandWindowViewController)object3).getWindowState()) == null || ((DynamicIslandWindowState)object3).isAdaptDesktopAnimation((Context)object))) {
                    object = object2 != null ? object2.getStringExtra("state") : null;
                    string = DynamicIslandDesktopStateController.access$getTAG$p(this.this$0);
                    if (object2 != null) {
                        string2 = object2.getAction();
                    }
                    object2 = new StringBuilder();
                    ((StringBuilder)object2).append("onReceive : ");
                    ((StringBuilder)object2).append(string2);
                    ((StringBuilder)object2).append(" state : ");
                    ((StringBuilder)object2).append((String)object);
                    Log.d((String)string, (String)((StringBuilder)object2).toString());
                    if (object != null) {
                        int n = -1;
                        switch (((String)object).hashCode()) {
                            case 1100051139: {
                                if (!((String)object).equals("toCurrentApp")) break;
                                n = 1;
                                break;
                            }
                            case 277236744: {
                                if (!((String)object).equals("closeWindow")) break;
                                n = 2;
                                break;
                            }
                            case -39374310: {
                                if (!((String)object).equals("crossSafeArea")) break;
                                n = 3;
                                break;
                            }
                            case -580919683: {
                                if (!((String)object).equals("toRecents")) break;
                                n = 4;
                                break;
                            }
                            case -869219846: {
                                if (!((String)object).equals("toHome")) break;
                                n = 5;
                                break;
                            }
                            case -1315693975: {
                                if (!((String)object).equals("taskSnapshot")) break;
                                n = 3;
                                break;
                            }
                            case -1546330858: {
                                if (!((String)object).equals("startControlAppWindow")) break;
                                n = 3;
                                break;
                            }
                            case -2115549959: {
                                if (!((String)object).equals("toAnotherApp")) break;
                                n = 6;
                                break;
                            }
                        }
                        switch (n) {
                            default: {
                                break;
                            }
                            case 1: {
                                this.this$0.runDesktopAnim(false);
                                return;
                            }
                            case 2: {
                                this.this$0.runDesktopAnim(true);
                                this.this$0.runDesktopAnim(false);
                                return;
                            }
                            case 4: {
                                this.this$0.runDesktopAnim(false);
                                return;
                            }
                            case 5: {
                                this.this$0.runDesktopAnim(false);
                                return;
                            }
                            case 3: {
                                this.this$0.runDesktopAnim(true);
                                return;
                            }
                            case 6: {
                                this.this$0.runDesktopAnim(false);
                                return;
                            }
                        }
                    }
                    this.this$0.runDesktopAnim(false);
                    return;
                }
                object2 = (DynamicIslandWindowView)((Object)DynamicIslandDesktopStateController.access$getWindowViewWeakReference$p(this.this$0).get());
                object = string;
                if (object2 != null) {
                    object2 = ((DynamicIslandWindowView)((Object)object2)).getWindowViewController();
                    object = string;
                    if (object2 != null) {
                        object2 = ((DynamicIslandWindowViewController)object2).getWindowState();
                        object = string;
                        if (object2 != null) {
                            object = ((DynamicIslandWindowState)object2).getDeskTopAnimating();
                        }
                    }
                }
                if (object == null) {
                    return;
                }
                object.setValue((Object)Boolean.FALSE);
            }
        };
        this.freeFormStackMode = FlowConflatedKt.conflatedCallbackFlow((U0.o)new U0.o(this, null){
            private Object L$0;
            int label;
            final DynamicIslandDesktopStateController this$0;
            {
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
                Object object2 = L0.c.c();
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
                                f.b((E)DynamicIslandDesktopStateController.access$getScope$p(this.this$0), null, null, (U0.o)new freeFormStackMode.callback.dispatchFreeFormStackModeChanged.1(this.this$0, miuiFreeFormStackInfo, bl, null), (int)3, null);
                            }
                        }
                    };
                    this.this$0.getMiniWindowDataRepo().setSupport(true);
                    MiuiFreeFormManager.registerFreeformCallback((IFreeformCallback)stub);
                    U0.a a2 = new U0.a(stub){
                        final freeFormStackMode.callback.1 $callback;
                        {
                            this.$callback = var1_1;
                            super(0);
                        }

                        public final void invoke() {
                            MiuiFreeFormManager.unregisterFreeformCallback((IFreeformCallback)this.$callback);
                        }
                    };
                    this.label = 1;
                    if (o.a((q)object, (U0.a)a2, (d)this) != object2) return s.a;
                    return object2;
                }
            }
        });
    }

    public static /* synthetic */ void a(DynamicIslandDesktopStateController dynamicIslandDesktopStateController) {
        DynamicIslandDesktopStateController.runDesktopAnim$lambda$1(dynamicIslandDesktopStateController);
    }

    public static final /* synthetic */ void access$exitFreeFrom(DynamicIslandDesktopStateController dynamicIslandDesktopStateController, MiuiFreeFormManager.MiuiFreeFormStackInfo miuiFreeFormStackInfo, boolean bl) {
        dynamicIslandDesktopStateController.exitFreeFrom(miuiFreeFormStackInfo, bl);
    }

    public static final /* synthetic */ int access$getACTION_FREEFORM_TO_FULLSCREEN$p(DynamicIslandDesktopStateController dynamicIslandDesktopStateController) {
        return dynamicIslandDesktopStateController.ACTION_FREEFORM_TO_FULLSCREEN;
    }

    public static final /* synthetic */ i1.f access$getFreeFormStackMode$p(DynamicIslandDesktopStateController dynamicIslandDesktopStateController) {
        return dynamicIslandDesktopStateController.freeFormStackMode;
    }

    public static final /* synthetic */ E access$getScope$p(DynamicIslandDesktopStateController dynamicIslandDesktopStateController) {
        return dynamicIslandDesktopStateController.scope;
    }

    public static final /* synthetic */ String access$getTAG$p(DynamicIslandDesktopStateController dynamicIslandDesktopStateController) {
        return dynamicIslandDesktopStateController.TAG;
    }

    public static final /* synthetic */ WeakReference access$getWindowViewWeakReference$p(DynamicIslandDesktopStateController dynamicIslandDesktopStateController) {
        return dynamicIslandDesktopStateController.windowViewWeakReference;
    }

    @UiThread
    private final void exitFreeFrom(MiuiFreeFormManager.MiuiFreeFormStackInfo object, boolean bl) {
        boolean bl2 = true;
        bl = bl || object != null && !object.isInFreeFormMode() && !object.isInMiniFreeFormMode();
        Object object2 = (DynamicIslandWindowView)((Object)this.windowViewWeakReference.get());
        object2 = object2 != null && (object2 = ((DynamicIslandWindowView)((Object)object2)).getWindowViewController()) != null ? Boolean.valueOf(((DynamicIslandWindowViewController)object2).isNotSupportFreeFormAnim()) : null;
        if (!CommonUtils.INSTANCE.getIS_TABLET() || !DynamicIslandAnimUtils.INSTANCE.supportShowElementAndFreeformAnim()) {
            bl2 = false;
        }
        String string = this.TAG;
        String string2 = object != null ? object.packageName : null;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("exitFreeFrom ");
        stringBuilder.append(bl);
        stringBuilder.append(" ");
        stringBuilder.append(string2);
        stringBuilder.append(" ");
        stringBuilder.append(object2);
        stringBuilder.append(" ");
        stringBuilder.append(bl2);
        Log.d((String)string, (String)stringBuilder.toString());
        if (bl && (kotlin.jvm.internal.o.c((Object)object2, (Object)Boolean.TRUE) || bl2) && object != null && (object2 = object.packageName) != null && (object = !this.getMiniWindowDataRepo().isInMiniWindow((String)object2, object.userId) ? object2 : null) != null && (object2 = (DynamicIslandWindowView)((Object)this.windowViewWeakReference.get())) != null && (object2 = ((DynamicIslandWindowView)((Object)object2)).getWindowViewController()) != null && (object2 = ((DynamicIslandWindowViewController)object2).getDynamicIslandSafeguardsController()) != null) {
            DynamicIslandSafeguardsController.delayExitMiniWindow$default((DynamicIslandSafeguardsController)object2, (String)object, false, 2, null);
        }
    }

    private final void registerFreeformStackModeChanged() {
        l0 l02 = this.registerJob;
        if (l02 != null && l02.isActive()) {
            return;
        }
        this.registerJob = f.b((E)this.scope, null, null, (U0.o)new U0.o(this, null){
            int label;
            final DynamicIslandDesktopStateController this$0;
            {
                this.this$0 = dynamicIslandDesktopStateController;
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
                Object object2 = L0.c.c();
                int n = this.label;
                if (n != 0) {
                    if (n != 1) throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    k.b((Object)object);
                    return s.a;
                } else {
                    k.b((Object)object);
                    object = DynamicIslandDesktopStateController.access$getFreeFormStackMode$p(this.this$0);
                    g g2 = new g(this.this$0){
                        final DynamicIslandDesktopStateController this$0;
                        {
                            this.this$0 = dynamicIslandDesktopStateController;
                        }

                        public final Object emit(int n, d object) {
                            String string = DynamicIslandDesktopStateController.access$getTAG$p(this.this$0);
                            object = new StringBuilder();
                            ((StringBuilder)object).append("registerFreeformStackModeChanged it:");
                            ((StringBuilder)object).append(n);
                            Log.d((String)string, (String)((StringBuilder)object).toString());
                            if (n == 0 || n == 10) {
                                this.this$0.runDesktopAnim(false);
                            }
                            return s.a;
                        }
                    };
                    this.label = 1;
                    if (object.collect(g2, (d)this) != object2) return s.a;
                    return object2;
                }
            }
        }, (int)3, null);
    }

    private static final void runDesktopAnim$lambda$1(DynamicIslandDesktopStateController object) {
        kotlin.jvm.internal.o.g((Object)object, (String)"this$0");
        object = (DynamicIslandWindowView)((Object)((DynamicIslandDesktopStateController)object).windowViewWeakReference.get());
        object = object != null && (object = ((DynamicIslandWindowView)((Object)object)).getWindowViewController()) != null && (object = ((DynamicIslandWindowViewController)object).getWindowState()) != null ? ((DynamicIslandWindowState)object).getDeskTopAnimating() : null;
        if (object != null) {
            object.setValue((Object)Boolean.FALSE);
        }
    }

    public final DynamicMiniWindowDataRepo getMiniWindowDataRepo() {
        return this._miniWindowDataRepo;
    }

    public final DelayableExecutor getUiExecutor() {
        return this.uiExecutor;
    }

    public final void runDesktopAnim(boolean bl) {
        Object object = (DynamicIslandWindowView)((Object)this.windowViewWeakReference.get());
        Object var3_3 = null;
        if ((object = object != null && (object = ((DynamicIslandWindowView)((Object)object)).getWindowViewController()) != null ? ((DynamicIslandWindowViewController)object).getWindowState() : null) != null) {
            ((DynamicIslandWindowState)object).setTempHiddenType(DynamicIslandWindowState.TempHiddenType.DESKTOP_ANIMATING);
        }
        if (bl) {
            Object object2 = (DynamicIslandWindowView)((Object)this.windowViewWeakReference.get());
            object = var3_3;
            if (object2 != null) {
                object2 = ((DynamicIslandWindowView)((Object)object2)).getWindowViewController();
                object = var3_3;
                if (object2 != null) {
                    object2 = ((DynamicIslandWindowViewController)object2).getWindowState();
                    object = var3_3;
                    if (object2 != null) {
                        object = ((DynamicIslandWindowState)object2).getDeskTopAnimating();
                    }
                }
            }
            if (object != null) {
                object.setValue((Object)Boolean.TRUE);
            }
        } else {
            this.uiExecutor.executeDelayed((Runnable)new c(this), 1000L);
        }
    }

    public final void setUiExecutor(DelayableExecutor delayableExecutor) {
        kotlin.jvm.internal.o.g((Object)delayableExecutor, (String)"<set-?>");
        this.uiExecutor = delayableExecutor;
    }

    public final void start() {
        if (this.desktopRegistered) {
            return;
        }
        this.getMiniWindowDataRepo().start();
        Context context = this.sysUIContext;
        desktopReceiver.1 var1_2 = this.desktopReceiver;
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.miui.fullscreen_state_change");
        intentFilter.addAction("com.miui.powerkeeper.RECENT_TASK");
        s s2 = s.a;
        context.registerReceiver((BroadcastReceiver)var1_2, intentFilter, 2);
        this.desktopRegistered = true;
        this.registerFreeformStackModeChanged();
    }

    public final void stop() {
        l0 l02 = this.registerJob;
        if (l02 != null) {
            l0.a.a((l0)l02, null, (int)1, null);
        }
        this.registerJob = null;
        if (this.desktopRegistered) {
            this.getMiniWindowDataRepo().stop();
            this.desktopRegistered = false;
            this.sysUIContext.unregisterReceiver((BroadcastReceiver)this.desktopReceiver);
        }
    }
}
