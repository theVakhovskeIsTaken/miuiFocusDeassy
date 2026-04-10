/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  D0.a
 *  G0.d
 *  G0.k
 *  G0.s
 *  H0.I
 *  K0.d
 *  K0.g
 *  L0.c
 *  U0.o
 *  android.content.Context
 *  android.os.SystemProperties
 *  android.util.Log
 *  c1.c
 *  f1.E
 *  f1.M
 *  f1.Q
 *  f1.f
 *  f1.l0
 *  f1.l0$a
 *  kotlin.jvm.internal.A
 *  kotlin.jvm.internal.o
 *  kotlin.jvm.internal.x
 *  miui.systemui.dagger.qualifiers.Plugin
 *  miui.systemui.notification.NotificationSettingsManager
 *  miui.systemui.util.ConvenienceExtensionsKt
 */
package miui.systemui.dynamicisland.display;

import D0.a;
import G0.k;
import G0.s;
import H0.I;
import K0.d;
import K0.g;
import L0.c;
import android.content.Context;
import android.os.SystemProperties;
import android.util.Log;
import f1.E;
import f1.M;
import f1.Q;
import f1.f;
import f1.l0;
import java.util.Set;
import kotlin.jvm.internal.A;
import kotlin.jvm.internal.o;
import kotlin.jvm.internal.x;
import miui.systemui.dagger.qualifiers.Plugin;
import miui.systemui.dynamicisland.dagger.DynamicIslandScope;
import miui.systemui.dynamicisland.display.AntiBurnInManagerKt;
import miui.systemui.dynamicisland.event.DynamicIslandEvent;
import miui.systemui.dynamicisland.event.DynamicIslandState;
import miui.systemui.dynamicisland.event.handler.BigIslandStateHandler;
import miui.systemui.dynamicisland.event.handler.SmallIslandStateHandler;
import miui.systemui.dynamicisland.window.content.DynamicIslandBaseContentView;
import miui.systemui.dynamicisland.window.content.DynamicIslandContentView;
import miui.systemui.dynamicisland.window.content.DynamicIslandContentViewExtKt;
import miui.systemui.notification.NotificationSettingsManager;
import miui.systemui.util.ConvenienceExtensionsKt;

@DynamicIslandScope
public final class AntiBurnInManager {
    public static final Companion Companion;
    private static final boolean DEBUG_ANTI_BURN_IN;
    private static final boolean DEBUG_ANTI_BURN_IN_CLOUD;
    private static final int ENTER_EXTEND = 3;
    private static final int ENTER_TYPE_EXPOSE = 1;
    private static final int ENTER_TYPE_RESTORE_FINISHED = 2;
    private static final long EXTEND_EXPOSE_TIME;
    private static final long EXTEND_THRESHOLD;
    private static final long MAX_EXPOSE_TIME_OUT;
    private static final String TAG = "DynamicIslandBurnIn";
    private static final long TIME_30_SECONDS = 30000L;
    private static final long TIME_3_MIN = 180000L;
    private final boolean DBG;
    private final G0.d bigIslandHandler$delegate;
    private final Context context;
    private final Set<c1.c> handledEventTypes;
    private DynamicIslandEvent handlingEvent;
    private final E scope;
    private final NotificationSettingsManager settingsManager;
    private final G0.d smallIslandHandler$delegate;
    private boolean supportBurnIn;

    static {
        boolean bl;
        Companion = new Object(null){
            {
                this();
            }

            public final long getEXTEND_EXPOSE_TIME() {
                return EXTEND_EXPOSE_TIME;
            }

            public final long getEXTEND_THRESHOLD() {
                return EXTEND_THRESHOLD;
            }

            public final long getMAX_EXPOSE_TIME_OUT() {
                return MAX_EXPOSE_TIME_OUT;
            }
        };
        boolean bl2 = false;
        DEBUG_ANTI_BURN_IN = bl = SystemProperties.getBoolean((String)"debug.sysui.notif.island.antiburnin", (boolean)false);
        boolean bl3 = bl2;
        if (bl) {
            bl3 = bl2;
            if (SystemProperties.getBoolean((String)"debug.sysui.notif.island.antiburnin.cloud", (boolean)false)) {
                bl3 = true;
            }
        }
        DEBUG_ANTI_BURN_IN_CLOUD = bl3;
        MAX_EXPOSE_TIME_OUT = SystemProperties.getLong((String)"debug.sysui.notif.island.antiburnin.timeout", (long)3600000L);
        EXTEND_EXPOSE_TIME = SystemProperties.getLong((String)"debug.sysui.notif.island.antiburnin.extend", (long)180000L);
        EXTEND_THRESHOLD = SystemProperties.getLong((String)"debug.sysui.notif.island.antiburnin.extend.threshold", (long)30000L);
    }

    public AntiBurnInManager(Context object, a a2, a a3, @Plugin E e, NotificationSettingsManager notificationSettingsManager) {
        o.g((Object)object, (String)"context");
        o.g((Object)a2, (String)"bigIslandStateHandler");
        o.g((Object)a3, (String)"smallIslandStateHandler");
        o.g((Object)e, (String)"scope");
        o.g((Object)notificationSettingsManager, (String)"settingsManager");
        this.context = object;
        this.scope = e;
        this.settingsManager = notificationSettingsManager;
        this.DBG = Log.isLoggable((String)TAG, (int)3);
        long l = MAX_EXPOSE_TIME_OUT;
        long l2 = EXTEND_EXPOSE_TIME;
        long l3 = EXTEND_THRESHOLD;
        object = new StringBuilder();
        ((StringBuilder)object).append("X=");
        ((StringBuilder)object).append(l);
        ((StringBuilder)object).append(", Y=");
        ((StringBuilder)object).append(l2);
        ((StringBuilder)object).append(", Z=");
        ((StringBuilder)object).append(l3);
        Log.i((String)TAG, (String)((StringBuilder)object).toString());
        this.smallIslandHandler$delegate = ConvenienceExtensionsKt.getKotlinLazy((a)a3);
        this.bigIslandHandler$delegate = ConvenienceExtensionsKt.getKotlinLazy((a)a2);
        this.handledEventTypes = I.d((Object[])new c1.c[]{A.b(DynamicIslandEvent.ClickDynamicIsland.class), A.b(DynamicIslandEvent.SwipeRight.class), A.b(DynamicIslandEvent.SwipeLeft.class), A.b(DynamicIslandEvent.IslandLongPressed.class), A.b(DynamicIslandEvent.AutoExpandIsland.class), A.b(DynamicIslandEvent.IslandTempHiddenChanged.class), A.b(DynamicIslandEvent.Collapse.class), A.b(DynamicIslandEvent.AddDynamicIsland.class)});
    }

    public static final /* synthetic */ long access$calculateRemainingTime(AntiBurnInManager antiBurnInManager) {
        return antiBurnInManager.calculateRemainingTime();
    }

    public static final /* synthetic */ void access$enter(AntiBurnInManager antiBurnInManager, int n) {
        antiBurnInManager.enter(n);
    }

    public static final /* synthetic */ BigIslandStateHandler access$getBigIslandHandler(AntiBurnInManager antiBurnInManager) {
        return antiBurnInManager.getBigIslandHandler();
    }

    public static final /* synthetic */ String access$getCurrentState(AntiBurnInManager antiBurnInManager) {
        return antiBurnInManager.getCurrentState();
    }

    public static final /* synthetic */ SmallIslandStateHandler access$getSmallIslandHandler(AntiBurnInManager antiBurnInManager) {
        return antiBurnInManager.getSmallIslandHandler();
    }

    public static final /* synthetic */ void access$log(AntiBurnInManager antiBurnInManager, String string) {
        antiBurnInManager.log(string);
    }

    private final long calculateRemainingTime() {
        long l;
        Object object;
        if (this.getBigIslandHandler().getCurrent() != null) {
            if (this.isDualIsland()) {
                object = this.getSmallIslandHandler().getCurrent();
                o.d((Object)object);
                l = DynamicIslandContentViewExtKt.getRemainingUnitLong(object);
                object = this.getBigIslandHandler().getCurrent();
                o.d((Object)object);
                l = Math.max(l, DynamicIslandContentViewExtKt.getRemainingUnitLong(object));
            } else {
                object = this.getBigIslandHandler().getCurrent();
                o.d((Object)object);
                l = DynamicIslandContentViewExtKt.getRemainingUnitLong(object);
            }
        } else {
            Log.e((String)TAG, (String)"wrong state calculateRemaining");
            l = MAX_EXPOSE_TIME_OUT;
        }
        boolean bl = this.isDualIsland();
        object = this.getBigIslandHandler().getCurrent();
        Boolean bl2 = null;
        object = object != null ? Boolean.valueOf(object.getHasEverBurnedIn()) : null;
        Object object2 = this.getSmallIslandHandler().getCurrent();
        if (object2 != null) {
            bl2 = ((DynamicIslandContentView)((Object)object2)).getHasEverBurnedIn();
        }
        object2 = new StringBuilder();
        ((StringBuilder)object2).append("isDual=");
        ((StringBuilder)object2).append(bl);
        ((StringBuilder)object2).append(", bigEntered=");
        ((StringBuilder)object2).append(object);
        ((StringBuilder)object2).append(", smallEntered=");
        ((StringBuilder)object2).append(bl2);
        ((StringBuilder)object2).append(", remaining: ");
        ((StringBuilder)object2).append(l);
        Log.d((String)TAG, (String)((StringBuilder)object2).toString());
        return l;
    }

    private final BurnInStates currentBurnInState() {
        DynamicIslandContentView dynamicIslandContentView = this.getBigIslandHandler().getCurrent();
        BurnInStates burnInStates = null;
        if (dynamicIslandContentView != null) {
            dynamicIslandContentView = this.getBigIslandHandler().getCurrent();
            if (dynamicIslandContentView != null) {
                burnInStates = dynamicIslandContentView.getBurnInState();
            }
        } else if (this.getSmallIslandHandler().getCurrent() != null) {
            dynamicIslandContentView = this.getSmallIslandHandler().getCurrent();
            if (dynamicIslandContentView != null) {
                burnInStates = dynamicIslandContentView.getBurnInState();
            }
        } else {
            burnInStates = BurnInStates.Normal;
        }
        return burnInStates;
    }

    private final void enter(int n) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("enter ");
        stringBuilder.append(n);
        Log.i((String)TAG, (String)stringBuilder.toString());
        this.getBigIslandHandler().handleEnterBurnIn();
        this.getSmallIslandHandler().handleEnterBurnIn();
    }

    private final boolean enterOrExitApp(DynamicIslandContentView object) {
        String string = object.getPkgName();
        object = this.getBigIslandHandler().getCurrent();
        Object var2_3 = null;
        if (o.c((Object)(object = object != null ? object.getPkgName() : null), (Object)string)) {
            return true;
        }
        DynamicIslandContentView dynamicIslandContentView = this.getSmallIslandHandler().getCurrent();
        object = var2_3;
        if (dynamicIslandContentView != null) {
            object = dynamicIslandContentView.getPkgName();
        }
        return o.c((Object)object, (Object)string);
    }

    private final void exit() {
        this.exitBurnIn();
    }

    private final void exitBurnIn() {
        String string = this.getCurrentState();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("exit current state:");
        stringBuilder.append(string);
        Log.i((String)TAG, (String)stringBuilder.toString());
        this.getBigIslandHandler().handleExitBurnIn();
        this.getSmallIslandHandler().handleExitBurnIn();
    }

    private final void exitUnexpectedState() {
        if (!this.supportBurnIn()) {
            return;
        }
        this.exit();
        Object object = this.getBigIslandHandler().getCurrent();
        BurnInStates burnInStates = null;
        object = object != null ? object.getBurnInState() : null;
        Object object2 = this.getSmallIslandHandler().getCurrent();
        if (object2 != null) {
            burnInStates = ((DynamicIslandContentView)((Object)object2)).getBurnInState();
        }
        object2 = new StringBuilder();
        ((StringBuilder)object2).append("error. current big: ");
        ((StringBuilder)object2).append(object);
        ((StringBuilder)object2).append(", small: ");
        ((StringBuilder)object2).append((Object)burnInStates);
        Log.e((String)TAG, (String)((StringBuilder)object2).toString());
    }

    private final void extendExpose() {
        if (!this.supportBurnIn()) {
            return;
        }
        if (this.getBigIslandHandler().getCurrent() == null) {
            return;
        }
        boolean bl = this.lastMinEvent();
        Object object = this.getBigIslandHandler().getCurrent();
        boolean bl2 = false;
        boolean bl3 = object != null;
        if (this.getSmallIslandHandler().getCurrent() != null) {
            bl2 = true;
        }
        object = new StringBuilder();
        ((StringBuilder)object).append("extend expose=");
        ((StringBuilder)object).append(bl);
        ((StringBuilder)object).append(", cur big:");
        ((StringBuilder)object).append(bl3);
        ((StringBuilder)object).append(", cur small:");
        ((StringBuilder)object).append(bl2);
        this.log(((StringBuilder)object).toString());
        this.exit();
        if (bl) {
            this.updateCurrentExpo(this.getBigIslandHandler().getCurrent());
            this.updateCurrentExpo(this.getSmallIslandHandler().getCurrent());
            this.purgeJobs();
            object = f.b((E)this.scope, (g)Q.c().z(), null, (U0.o)new U0.o(this, null){
                int label;
                final AntiBurnInManager this$0;
                {
                    this.this$0 = antiBurnInManager;
                    super(2, d2);
                }

                public final d create(Object object, d d2) {
                    return new /* invalid duplicate definition of identical inner class */;
                }

                public final Object invoke(E e, d d2) {
                    return (this.create(e, d2)).invokeSuspend(s.a);
                }

                /*
                 * WARNING - void declaration
                 * Enabled force condition propagation
                 * Lifted jumps to return sites
                 */
                public final Object invokeSuspend(Object object) {
                    Object object2 = c.c();
                    int n = this.label;
                    if (n != 0) {
                        if (n != 1) throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        k.b((Object)object);
                    } else {
                        void var1_5;
                        k.b((Object)object);
                        long l2 = AntiBurnInManager.Companion.getEXTEND_EXPOSE_TIME();
                        AntiBurnInManager antiBurnInManager = this.this$0;
                        DynamicIslandContentView dynamicIslandContentView = AntiBurnInManager.access$getBigIslandHandler(antiBurnInManager).getCurrent();
                        BurnInStates burnInStates = null;
                        if (dynamicIslandContentView != null) {
                            BurnInStates burnInStates2 = dynamicIslandContentView.getBurnInState();
                        } else {
                            Object var1_4 = null;
                        }
                        Object object3 = AntiBurnInManager.access$getSmallIslandHandler(this.this$0).getCurrent();
                        if (object3 != null) {
                            burnInStates = ((DynamicIslandContentView)((Object)object3)).getBurnInState();
                        }
                        object3 = new StringBuilder();
                        ((StringBuilder)object3).append("extend (");
                        ((StringBuilder)object3).append(var1_5);
                        ((StringBuilder)object3).append(", ");
                        ((StringBuilder)object3).append((Object)((Object)burnInStates));
                        ((StringBuilder)object3).append(") for ");
                        ((StringBuilder)object3).append(l2);
                        AntiBurnInManager.access$log(antiBurnInManager, ((StringBuilder)object3).toString());
                        this.label = 1;
                        if (M.b((long)l2, (d)this) == object2) {
                            return object2;
                        }
                    }
                    AntiBurnInManager.access$enter(this.this$0, 3);
                    return s.a;
                }
            }, (int)2, null);
            DynamicIslandContentView dynamicIslandContentView = this.getBigIslandHandler().getCurrent();
            if (dynamicIslandContentView != null) {
                dynamicIslandContentView.setExtendJob((l0)object);
            }
            dynamicIslandContentView = this.getSmallIslandHandler().getCurrent();
            if (dynamicIslandContentView != null) {
                dynamicIslandContentView.setExtendJob((l0)object);
            }
        }
    }

    private final BigIslandStateHandler getBigIslandHandler() {
        return (BigIslandStateHandler)this.bigIslandHandler$delegate.getValue();
    }

    private final String getCurrentState() {
        String string = this.getBigIslandHandler().getCurrent() != null && this.getSmallIslandHandler().getCurrent() != null ? "dual" : (this.getBigIslandHandler().getCurrent() != null ? "single" : "wrong");
        return string;
    }

    private final SmallIslandStateHandler getSmallIslandHandler() {
        return (SmallIslandStateHandler)this.smallIslandHandler$delegate.getValue();
    }

    private final boolean isDualIsland() {
        boolean bl = this.getBigIslandHandler().getCurrent() != null && this.getSmallIslandHandler().getCurrent() != null;
        return bl;
    }

    private final boolean lastMinEvent() {
        x x2 = new x();
        Object object = this.getBigIslandHandler().getCurrent();
        CharSequence charSequence = this.getBigIslandHandler().getCurrentKey();
        Object object2 = new StringBuilder();
        object2.append("big_");
        object2.append((String)charSequence);
        AntiBurnInManager.lastMinEvent$checkIsland(this, x2, object, object2.toString());
        object2 = this.getSmallIslandHandler().getCurrent();
        object = this.getSmallIslandHandler().getCurrentKey();
        charSequence = new StringBuilder();
        ((StringBuilder)charSequence).append("small_");
        ((StringBuilder)charSequence).append((String)object);
        AntiBurnInManager.lastMinEvent$checkIsland(this, x2, (DynamicIslandContentView)((Object)object2), ((StringBuilder)charSequence).toString());
        return x2.a;
    }

    private static final void lastMinEvent$checkIsland(AntiBurnInManager antiBurnInManager, x x2, DynamicIslandContentView object, String string) {
        if (object != null) {
            if (DynamicIslandContentViewExtKt.getRemainingUnitExact((DynamicIslandContentView)((Object)object)) >= EXTEND_THRESHOLD) {
                object = null;
            }
            if (object != null) {
                long l2 = DynamicIslandContentViewExtKt.getRemainingUnitLong((DynamicIslandContentView)((Object)object));
                object = new StringBuilder();
                ((StringBuilder)object).append(string);
                ((StringBuilder)object).append(" Island is in last minute, remainingTime: ");
                ((StringBuilder)object).append(l2);
                antiBurnInManager.log(((StringBuilder)object).toString());
                x2.a = true;
            }
        }
    }

    private final void log(String string) {
        if (this.DBG) {
            Log.d((String)TAG, (String)string);
        }
    }

    private final void preHandle(DynamicIslandEvent object, DynamicIslandContentView dynamicIslandContentView) {
        if (object instanceof DynamicIslandEvent.EnterApp && (object = dynamicIslandContentView != null ? dynamicIslandContentView.getBurnInState() : null) == BurnInStates.BurnIn) {
            dynamicIslandContentView.animExitBurnIn();
        }
    }

    private final void purgeForPause(DynamicIslandContentView dynamicIslandContentView) {
        l0 l02 = dynamicIslandContentView.getEnterJob();
        if (l02 != null) {
            l0.a.a((l0)l02, null, (int)1, null);
        }
        if ((l02 = dynamicIslandContentView.getRestoreJob()) != null) {
            l0.a.a((l0)l02, null, (int)1, null);
        }
        if ((l02 = dynamicIslandContentView.getExtendJob()) != null) {
            l0.a.a((l0)l02, null, (int)1, null);
        }
        dynamicIslandContentView.setEnterJob(null);
        dynamicIslandContentView.setRestoreJob(null);
        dynamicIslandContentView.setExtendJob(null);
    }

    private final void purgeJobs() {
        DynamicIslandContentView dynamicIslandContentView = this.getBigIslandHandler().getCurrent();
        if (dynamicIslandContentView != null && (dynamicIslandContentView = dynamicIslandContentView.getEnterJob()) != null) {
            l0.a.a((l0)dynamicIslandContentView, null, (int)1, null);
        }
        if ((dynamicIslandContentView = this.getBigIslandHandler().getCurrent()) != null && (dynamicIslandContentView = dynamicIslandContentView.getExtendJob()) != null) {
            l0.a.a((l0)dynamicIslandContentView, null, (int)1, null);
        }
        if ((dynamicIslandContentView = this.getBigIslandHandler().getCurrent()) != null && (dynamicIslandContentView = dynamicIslandContentView.getRestoreJob()) != null) {
            l0.a.a((l0)dynamicIslandContentView, null, (int)1, null);
        }
        if ((dynamicIslandContentView = this.getSmallIslandHandler().getCurrent()) != null && (dynamicIslandContentView = dynamicIslandContentView.getEnterJob()) != null) {
            l0.a.a((l0)dynamicIslandContentView, null, (int)1, null);
        }
        if ((dynamicIslandContentView = this.getSmallIslandHandler().getCurrent()) != null && (dynamicIslandContentView = dynamicIslandContentView.getExtendJob()) != null) {
            l0.a.a((l0)dynamicIslandContentView, null, (int)1, null);
        }
        if ((dynamicIslandContentView = this.getSmallIslandHandler().getCurrent()) != null && (dynamicIslandContentView = dynamicIslandContentView.getRestoreJob()) != null) {
            l0.a.a((l0)dynamicIslandContentView, null, (int)1, null);
        }
        if ((dynamicIslandContentView = this.getBigIslandHandler().getCurrent()) != null) {
            dynamicIslandContentView.setEnterJob(null);
        }
        dynamicIslandContentView = this.getBigIslandHandler().getCurrent();
        if (dynamicIslandContentView != null) {
            dynamicIslandContentView.setExtendJob(null);
        }
        dynamicIslandContentView = this.getBigIslandHandler().getCurrent();
        if (dynamicIslandContentView != null) {
            dynamicIslandContentView.setRestoreJob(null);
        }
        dynamicIslandContentView = this.getSmallIslandHandler().getCurrent();
        if (dynamicIslandContentView != null) {
            dynamicIslandContentView.setEnterJob(null);
        }
        dynamicIslandContentView = this.getSmallIslandHandler().getCurrent();
        if (dynamicIslandContentView != null) {
            dynamicIslandContentView.setExtendJob(null);
        }
        dynamicIslandContentView = this.getSmallIslandHandler().getCurrent();
        if (dynamicIslandContentView != null) {
            dynamicIslandContentView.setRestoreJob(null);
        }
    }

    private final void scheduleRestore() {
        Log.i((String)TAG, (String)"schedule restore");
        this.exit();
        this.purgeJobs();
        DynamicIslandContentView dynamicIslandContentView = this.getBigIslandHandler().getCurrent();
        if (dynamicIslandContentView != null) {
            dynamicIslandContentView.setBurnInState(BurnInStates.TempRestore);
        }
        dynamicIslandContentView = this.getSmallIslandHandler().getCurrent();
        if (dynamicIslandContentView != null) {
            dynamicIslandContentView.setBurnInState(BurnInStates.TempRestore);
        }
        this.scheduleRestore(this.getBigIslandHandler().getCurrent());
        this.scheduleRestore(this.getSmallIslandHandler().getCurrent());
    }

    private final void scheduleRestore(DynamicIslandContentView dynamicIslandContentView) {
        long l2 = EXTEND_EXPOSE_TIME;
        if (dynamicIslandContentView != null) {
            dynamicIslandContentView.setRestoreJob(f.b((E)this.scope, (g)Q.c().z(), null, (U0.o)new U0.o(l2, dynamicIslandContentView, this, null){
                final long $restoreTimeout;
                final DynamicIslandContentView $view;
                int label;
                final AntiBurnInManager this$0;
                {
                    this.$restoreTimeout = l2;
                    this.$view = dynamicIslandContentView;
                    this.this$0 = antiBurnInManager;
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
                    } else {
                        k.b((Object)object);
                        long l2 = this.$restoreTimeout;
                        object = this.$view;
                        object = object != null && (object = ((DynamicIslandBaseContentView)((Object)object)).getState()) != null ? object.getClass().getSimpleName() : null;
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append("restore burn-in in ");
                        stringBuilder.append(l2);
                        stringBuilder.append(" ms, cur:[");
                        stringBuilder.append((String)object);
                        stringBuilder.append("]");
                        Log.i((String)"DynamicIslandBurnIn", (String)stringBuilder.toString());
                        l2 = this.$restoreTimeout;
                        this.label = 1;
                        if (M.b((long)l2, (d)this) == object2) {
                            return object2;
                        }
                    }
                    AntiBurnInManager.access$enter(this.this$0, 2);
                    return s.a;
                }
            }, (int)2, null));
        }
    }

    private final boolean shouldHandle(DynamicIslandEvent dynamicIslandEvent, DynamicIslandContentView dynamicIslandContentView) {
        return this.handledEventTypes.contains(A.b(dynamicIslandEvent.getClass()));
    }

    public static /* synthetic */ boolean shouldHandle$default(AntiBurnInManager antiBurnInManager, DynamicIslandEvent dynamicIslandEvent, DynamicIslandContentView dynamicIslandContentView, int n, Object object) {
        if ((n & 2) != 0) {
            dynamicIslandContentView = null;
        }
        return antiBurnInManager.shouldHandle(dynamicIslandEvent, dynamicIslandContentView);
    }

    private final boolean shouldHandleApp(DynamicIslandEvent dynamicIslandEvent, DynamicIslandContentView dynamicIslandContentView) {
        boolean bl;
        block6: {
            boolean bl2;
            block5: {
                bl2 = false;
                if (dynamicIslandContentView == null) {
                    return false;
                }
                if (dynamicIslandEvent instanceof DynamicIslandEvent.ExitApp || dynamicIslandEvent instanceof DynamicIslandEvent.EnterApp || dynamicIslandEvent instanceof DynamicIslandEvent.ExitMiniWindow) break block5;
                bl = bl2;
                if (!(dynamicIslandEvent instanceof DynamicIslandEvent.EnterMiniWindow)) break block6;
            }
            bl = bl2;
            if (this.enterOrExitApp(dynamicIslandContentView)) {
                bl = true;
            }
        }
        return bl;
    }

    private final void updateCurrentExpo(DynamicIslandContentView dynamicIslandContentView) {
        if (dynamicIslandContentView == null) {
            return;
        }
        if (dynamicIslandContentView.getHasEverBurnedIn()) {
            dynamicIslandContentView.setBurnInState(BurnInStates.TempRestore);
        } else {
            dynamicIslandContentView.setBurnInState(BurnInStates.Normal);
        }
    }

    public final void alignBurnInStates() {
        if (!this.supportBurnIn()) {
            return;
        }
        Object object = this.getBigIslandHandler().getCurrent();
        Object object2 = null;
        object = object != null ? object.getBurnInState() : null;
        String string = this.getBigIslandHandler().getCurrentKey();
        Object object3 = this.getSmallIslandHandler().getCurrent();
        if (object3 != null) {
            object2 = object3.getBurnInState();
        }
        String string2 = this.getSmallIslandHandler().getCurrentKey();
        object3 = new StringBuilder();
        ((StringBuilder)object3).append("align burnin ");
        ((StringBuilder)object3).append(object);
        ((StringBuilder)object3).append("-");
        ((StringBuilder)object3).append(string);
        ((StringBuilder)object3).append(", ");
        ((StringBuilder)object3).append(object2);
        ((StringBuilder)object3).append("-");
        ((StringBuilder)object3).append(string2);
        this.log(((StringBuilder)object3).toString());
        if (this.getBigIslandHandler().getCurrent() == null) {
            return;
        }
        if (this.getSmallIslandHandler().getCurrent() == null) {
            return;
        }
        object = this.getBigIslandHandler().getCurrent();
        o.d((Object)object);
        object2 = object.getBurnInState();
        object = BurnInStates.BurnIn;
        boolean bl = false;
        boolean bl2 = object2 == object;
        object2 = this.getSmallIslandHandler().getCurrent();
        o.d((Object)object2);
        if (((DynamicIslandContentView)((Object)object2)).getBurnInState() == object) {
            bl = true;
        }
        object = this.getBigIslandHandler().getCurrent();
        o.d((Object)object);
        boolean bl3 = object.inBurnIn();
        object = this.getSmallIslandHandler().getCurrent();
        o.d((Object)object);
        boolean bl4 = object.inBurnIn();
        if (bl2 != bl || bl3 != bl4) {
            Log.w((String)TAG, (String)"burnin state aligned");
            this.exit();
        }
    }

    public final long getBurnInTimeout() {
        long l2 = DEBUG_ANTI_BURN_IN_CLOUD ? MAX_EXPOSE_TIME_OUT : this.settingsManager.getBurnInData().timeout;
        return l2;
    }

    public final void handleEvent(DynamicIslandEvent object, DynamicIslandContentView object2) {
        o.g((Object)object, (String)"event");
        if (!this.supportBurnIn()) {
            return;
        }
        BurnInStates burnInStates = this.currentBurnInState();
        boolean bl = this.shouldHandle((DynamicIslandEvent)object, (DynamicIslandContentView)((Object)object2));
        boolean bl2 = this.shouldHandleApp((DynamicIslandEvent)object, (DynamicIslandContentView)((Object)object2));
        if (bl || bl2) {
            String string = object.getClass().getSimpleName();
            BurnInStates burnInStates2 = null;
            String string2 = object2 != null ? ((DynamicIslandContentView)((Object)object2)).getIslandKey() : null;
            Object object3 = this.getBigIslandHandler().getCurrent();
            object3 = object3 != null ? object3.getBurnInState() : null;
            Object object4 = this.getSmallIslandHandler().getCurrent();
            if (object4 != null) {
                burnInStates2 = object4.getBurnInState();
            }
            object4 = new StringBuilder();
            ((StringBuilder)object4).append("Anti-burn-in handleEvent: ");
            ((StringBuilder)object4).append(string);
            ((StringBuilder)object4).append(", ");
            ((StringBuilder)object4).append(string2);
            ((StringBuilder)object4).append(", \n big in ");
            ((StringBuilder)object4).append(object3);
            ((StringBuilder)object4).append(", small in ");
            ((StringBuilder)object4).append((Object)burnInStates2);
            this.log(((StringBuilder)object4).toString());
        }
        this.handlingEvent = object;
        this.preHandle((DynamicIslandEvent)object, (DynamicIslandContentView)((Object)object2));
        if (!bl && !bl2) {
            object = object.getClass().getSimpleName();
            object2 = new StringBuilder();
            ((StringBuilder)object2).append("event: ");
            ((StringBuilder)object2).append((String)object);
            ((StringBuilder)object2).append(" not anti-burn-in related");
            this.log(((StringBuilder)object2).toString());
        } else {
            int n = burnInStates == null ? -1 : WhenMappings.$EnumSwitchMapping$0[burnInStates.ordinal()];
            if (n != 1) {
                if (n != 2 && n != 3) {
                    this.exitUnexpectedState();
                } else {
                    this.extendExpose();
                }
            } else {
                this.scheduleRestore();
            }
        }
    }

    public final void pauseExpose(DynamicIslandContentView object, long l2, String string) {
        o.g((Object)object, (String)"view");
        o.g((Object)string, (String)"islandKey");
        if (!this.supportBurnIn()) {
            return;
        }
        this.purgeForPause((DynamicIslandContentView)((Object)object));
        int n = AntiBurnInManagerKt.toExposedUnit(l2);
        String string2 = this.getCurrentState();
        Object object2 = ((DynamicIslandBaseContentView)((Object)object)).getState();
        String string3 = null;
        object2 = object2 != null ? object2.getClass().getSimpleName() : null;
        Object object3 = ((DynamicIslandBaseContentView)((Object)object)).getLastState();
        if (object3 != null) {
            string3 = object3.getClass().getSimpleName();
        }
        boolean bl = ((DynamicIslandContentView)((Object)object)).getHasEverBurnedIn();
        object3 = new StringBuilder();
        ((StringBuilder)object3).append("pause for ");
        ((StringBuilder)object3).append(string);
        ((StringBuilder)object3).append(", ");
        ((StringBuilder)object3).append(string2);
        ((StringBuilder)object3).append("\n cur:[");
        ((StringBuilder)object3).append((String)object2);
        ((StringBuilder)object3).append("], last: [");
        ((StringBuilder)object3).append(string3);
        ((StringBuilder)object3).append("], exposed:");
        ((StringBuilder)object3).append(l2);
        ((StringBuilder)object3).append(", inSec:");
        ((StringBuilder)object3).append(n);
        ((StringBuilder)object3).append(" hasBurnIn:");
        ((StringBuilder)object3).append(bl);
        Log.i((String)TAG, (String)((StringBuilder)object3).toString());
        bl = ((DynamicIslandBaseContentView)((Object)object)).getLastState() instanceof DynamicIslandState.BigIsland;
        boolean bl2 = true;
        n = !bl && !(((DynamicIslandBaseContentView)((Object)object)).getLastState() instanceof DynamicIslandState.SmallIsland) ? 0 : 1;
        if (((DynamicIslandBaseContentView)((Object)object)).getState() instanceof DynamicIslandState.BigIsland || ((DynamicIslandBaseContentView)((Object)object)).getState() instanceof DynamicIslandState.SmallIsland) {
            bl2 = false;
        }
        if (n != 0 && bl2) {
            ((DynamicIslandContentView)((Object)object)).setBurnInState(BurnInStates.PauseExpose);
            ((DynamicIslandContentView)((Object)object)).animExitBurnIn();
        }
        if (((DynamicIslandContentView)((Object)object)).getHasEverBurnedIn()) {
            ((DynamicIslandContentView)((Object)object)).setExposedBurnInUnit(((DynamicIslandContentView)((Object)object)).getExposedBurnInUnit() + l2);
            ((DynamicIslandContentView)((Object)object)).setRemainingBurnInUnit(((DynamicIslandContentView)((Object)object)).getRemainingBurnInUnit() - l2);
        } else {
            ((DynamicIslandContentView)((Object)object)).setExposedUnit(((DynamicIslandContentView)((Object)object)).getExposedUnit() + l2);
            ((DynamicIslandContentView)((Object)object)).setRemainingUnit(((DynamicIslandContentView)((Object)object)).getRemainingUnit() - l2);
        }
        bl = ((DynamicIslandContentView)((Object)object)).getHasEverBurnedIn();
        long l3 = ((DynamicIslandContentView)((Object)object)).getExposedBurnInUnit();
        l2 = ((DynamicIslandContentView)((Object)object)).getRemainingBurnInUnit();
        long l4 = ((DynamicIslandContentView)((Object)object)).getExposedUnit();
        long l5 = ((DynamicIslandContentView)((Object)object)).getRemainingUnit();
        object = new StringBuilder();
        ((StringBuilder)object).append("update exposed ");
        ((StringBuilder)object).append(bl);
        ((StringBuilder)object).append(", burnin(");
        ((StringBuilder)object).append(l3);
        ((StringBuilder)object).append(", ");
        ((StringBuilder)object).append(l2);
        ((StringBuilder)object).append("), normal(");
        ((StringBuilder)object).append(l4);
        ((StringBuilder)object).append(", ");
        ((StringBuilder)object).append(l5);
        ((StringBuilder)object).append(")");
        Log.d((String)TAG, (String)((StringBuilder)object).toString());
    }

    public final void scheduleEnter(String string, DynamicIslandContentView object) {
        o.g((Object)string, (String)"key");
        o.g((Object)object, (String)"view");
        if (!this.supportBurnIn()) {
            return;
        }
        object = new StringBuilder();
        ((StringBuilder)object).append("schedule enter ");
        ((StringBuilder)object).append(string);
        this.log(((StringBuilder)object).toString());
        this.updateCurrentExpo(this.getBigIslandHandler().getCurrent());
        this.updateCurrentExpo(this.getSmallIslandHandler().getCurrent());
        this.alignBurnInStates();
        this.purgeJobs();
        string = f.b((E)this.scope, (g)Q.c().z(), null, (U0.o)new U0.o(this, string, null){
            final String $key;
            int label;
            final AntiBurnInManager this$0;
            {
                this.this$0 = antiBurnInManager;
                this.$key = string;
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
                } else {
                    k.b((Object)object);
                    long l2 = AntiBurnInManager.access$calculateRemainingTime(this.this$0);
                    object = this.$key;
                    String string = AntiBurnInManager.access$getCurrentState(this.this$0);
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("enter burn in after:");
                    stringBuilder.append(l2);
                    stringBuilder.append(" for ");
                    stringBuilder.append((String)object);
                    stringBuilder.append(", current:");
                    stringBuilder.append(string);
                    Log.i((String)"DynamicIslandBurnIn", (String)stringBuilder.toString());
                    this.label = 1;
                    if (M.b((long)l2, (d)this) == object2) {
                        return object2;
                    }
                }
                AntiBurnInManager.access$enter(this.this$0, 1);
                return s.a;
            }
        }, (int)2, null);
        object = this.getBigIslandHandler().getCurrent();
        if (object != null) {
            ((DynamicIslandContentView)((Object)object)).setEnterJob((l0)string);
        }
        object = this.getSmallIslandHandler().getCurrent();
        if (object != null) {
            ((DynamicIslandContentView)((Object)object)).setEnterJob((l0)string);
        }
    }

    public final boolean supportBurnIn() {
        boolean bl = this.settingsManager.getBurnInData().support;
        if (bl != this.supportBurnIn) {
            this.supportBurnIn = bl;
            if (!bl) {
                this.exit();
            }
        }
        return this.supportBurnIn;
    }
}
