/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  G0.c
 *  G0.k
 *  G0.s
 *  K0.d
 *  K0.g
 *  L0.c
 *  M0.b
 *  U0.o
 *  U0.p
 *  android.os.Handler
 *  android.os.Looper
 *  android.os.Message
 *  android.util.Log
 *  f1.E
 *  f1.F
 *  f1.f
 *  i1.E
 *  i1.I
 *  i1.K
 *  i1.f
 *  i1.g
 *  i1.h
 *  i1.u
 *  kotlin.jvm.internal.o
 *  miui.systemui.coroutines.Dispatchers
 *  miui.systemui.dagger.qualifiers.Plugin
 */
package miui.systemui.dynamicisland.display;

import G0.k;
import G0.s;
import K0.d;
import L0.c;
import M0.b;
import U0.p;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import f1.E;
import f1.F;
import f1.f;
import i1.I;
import i1.K;
import i1.g;
import i1.h;
import i1.u;
import kotlin.jvm.internal.o;
import miui.systemui.coroutines.Dispatchers;
import miui.systemui.dagger.qualifiers.Plugin;
import miui.systemui.dynamicisland.DynamicFeatureConfig;
import miui.systemui.dynamicisland.DynamicIslandBackgroundView;
import miui.systemui.dynamicisland.event.DynamicIslandEvent;
import miui.systemui.dynamicisland.event.DynamicIslandEventCoordinator;
import miui.systemui.dynamicisland.event.DynamicIslandState;
import miui.systemui.dynamicisland.window.content.DynamicIslandContentView;

public final class AvoidScreenBurnInHelper {
    public static final int AVOID_SCREEN_BURN_IN_COUNT = 4;
    public static final int AVOID_SCREEN_BURN_IN_DOWN = 3;
    public static final int AVOID_SCREEN_BURN_IN_FADED = 5;
    public static final long AVOID_SCREEN_BURN_IN_FADE_INTERVAL = 600000L;
    public static final int AVOID_SCREEN_BURN_IN_LEFT = 0;
    public static final int AVOID_SCREEN_BURN_IN_RIGHT = 2;
    public static final int AVOID_SCREEN_BURN_IN_TRAN_INTERVAL = 60000;
    public static final int AVOID_SCREEN_BURN_IN_UP = 1;
    public static final int AVOID_SCREEN_BURN_PAUSED = -1;
    private static final int CONSTANT_STEP_PX = 4;
    public static final Companion Companion = new Object(null){
        {
            this();
        }
    };
    private static final int MSG_ALPHA = 11;
    private static final int MSG_TRAN = 10;
    private static final String TAG = "AvoidScreenBurnInHelper";
    private final u _dynamicIsLandFaded;
    private final u _notificationPanelExpanded;
    private final u _screenBurnInGuard;
    private final boolean debugEnabled;
    private DynamicIslandEventCoordinator eventCoordinator;
    private final Handler handler;
    private boolean initialized;
    private final E mainScope;
    private boolean mode;
    private final I notificationPanelExpanded;
    private boolean ready;
    private boolean recoverBackgroundAlpha;
    private final I screenBurnInStrategy;
    private long translationInterval;
    private int translationStep;

    public AvoidScreenBurnInHelper(@Plugin E object) {
        boolean bl;
        u u2;
        u u3;
        o.g((Object)object, (String)"scope");
        object = F.g((E)object, (K0.g)Dispatchers.INSTANCE.getMain());
        this.mainScope = object;
        Integer n = -1;
        this._screenBurnInGuard = u3 = K.a((Object)n);
        Boolean bl2 = Boolean.FALSE;
        this._dynamicIsLandFaded = u2 = K.a((Object)bl2);
        bl2 = K.a((Object)bl2);
        this._notificationPanelExpanded = bl2;
        this.notificationPanelExpanded = h.b((u)bl2);
        this.debugEnabled = bl = DynamicFeatureConfig.INSTANCE.getDEBUG_AVOID_SCREEN_BURN_IN();
        this.translationInterval = 60000L;
        this.translationStep = 4;
        this.screenBurnInStrategy = h.B((i1.f)h.n((i1.f)h.i((i1.f)u3, (i1.f)u2, (p)new p(this, null){
            int I$0;
            boolean Z$0;
            int label;
            final AvoidScreenBurnInHelper this$0;
            {
                this.this$0 = avoidScreenBurnInHelper;
                super(3, d2);
            }

            public final Object invoke(int n, boolean bl, d object) {
                object = new /* invalid duplicate definition of identical inner class */;
                object.I$0 = n;
                object.Z$0 = bl;
                return object.invokeSuspend(s.a);
            }

            /*
             * Enabled aggressive block sorting
             */
            public final Object invokeSuspend(Object object) {
                c.c();
                if (this.label != 0) throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                k.b((Object)object);
                int n = this.I$0;
                boolean bl = this.Z$0;
                if (!AvoidScreenBurnInHelper.access$getReady$p(this.this$0)) {
                    n = -1;
                    return b.c((int)n);
                }
                if (!((Boolean)AvoidScreenBurnInHelper.access$get_notificationPanelExpanded$p(this.this$0).getValue()).booleanValue()) {
                    if (bl) {
                        n = 5;
                        return b.c((int)n);
                    }
                    if (!AvoidScreenBurnInHelper.access$getRecoverBackgroundAlpha$p(this.this$0)) return b.c((int)n);
                    AvoidScreenBurnInHelper.access$setRecoverBackgroundAlpha$p(this.this$0, false);
                }
                n = 4;
                return b.c((int)n);
            }
        })), (E)object, (i1.E)i1.E.a.c(), (Object)n);
        this.handler = new Handler(Looper.getMainLooper()){

            public void handleMessage(Message message) {
                o.g((Object)message, (String)"msg");
                int n = message.what;
            }
        };
        int n2 = this.translationStep;
        long l2 = this.translationInterval;
        object = new StringBuilder();
        ((StringBuilder)object).append("init AvoidScreenBurnInHelper debug=");
        ((StringBuilder)object).append(bl);
        ((StringBuilder)object).append(" tranParams=(");
        ((StringBuilder)object).append(n2);
        ((StringBuilder)object).append("/");
        ((StringBuilder)object).append(l2);
        ((StringBuilder)object).append(")");
        Log.d((String)TAG, (String)((StringBuilder)object).toString());
    }

    public static final /* synthetic */ void access$debugLog(AvoidScreenBurnInHelper avoidScreenBurnInHelper, String string, String string2) {
        avoidScreenBurnInHelper.debugLog(string, string2);
    }

    public static final /* synthetic */ boolean access$getReady$p(AvoidScreenBurnInHelper avoidScreenBurnInHelper) {
        return avoidScreenBurnInHelper.ready;
    }

    public static final /* synthetic */ boolean access$getRecoverBackgroundAlpha$p(AvoidScreenBurnInHelper avoidScreenBurnInHelper) {
        return avoidScreenBurnInHelper.recoverBackgroundAlpha;
    }

    public static final /* synthetic */ u access$get_notificationPanelExpanded$p(AvoidScreenBurnInHelper avoidScreenBurnInHelper) {
        return avoidScreenBurnInHelper._notificationPanelExpanded;
    }

    public static final /* synthetic */ void access$setRecoverBackgroundAlpha$p(AvoidScreenBurnInHelper avoidScreenBurnInHelper, boolean bl) {
        avoidScreenBurnInHelper.recoverBackgroundAlpha = bl;
    }

    private final void debugLog(String string, String string2) {
        if (this.debugEnabled) {
            Log.d((String)string, (String)string2);
        }
    }

    private final void fadeBackground() {
        this.setMode(true);
        this._dynamicIsLandFaded.setValue((Object)Boolean.TRUE);
    }

    private final void initCollect() {
        f.b((E)this.mainScope, null, null, (U0.o)new U0.o(this, null){
            int label;
            final AvoidScreenBurnInHelper this$0;
            {
                this.this$0 = avoidScreenBurnInHelper;
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
                    object = this.this$0.getScreenBurnInStrategy();
                    g g2 = new g(this.this$0){
                        final AvoidScreenBurnInHelper this$0;
                        {
                            this.this$0 = avoidScreenBurnInHelper;
                        }

                        public final Object emit(int n, d object) {
                            object = new StringBuilder();
                            ((StringBuilder)object).append(" flow screenBurnInStrategy  ");
                            ((StringBuilder)object).append(n);
                            ((StringBuilder)object).append(" ");
                            Log.d((String)"AvoidScreenBurnInHelper", (String)((StringBuilder)object).toString());
                            object = this.this$0.getEventCoordinator();
                            if (object != null) {
                                ((DynamicIslandEventCoordinator)object).handleScreenBurnInStrategy(n);
                            }
                            return s.a;
                        }
                    };
                    this.label = 1;
                    if (object.collect(g2, (d)this) == object2) {
                        return object2;
                    }
                }
                throw new G0.c();
            }
        }, (int)3, null);
        f.b((E)this.mainScope, null, null, (U0.o)new U0.o(this, null){
            int label;
            final AvoidScreenBurnInHelper this$0;
            {
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
                    U0.o o2 = new U0.o(this.this$0, null){
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
                    if (h.h((i1.f)object, (U0.o)o2, (d)this) != object2) return s.a;
                    return object2;
                }
            }
        }, (int)3, null);
    }

    private final void reset() {
        this.stop();
        this._screenBurnInGuard.setValue((Object)-1);
    }

    private final void resetView() {
        DynamicIslandEventCoordinator dynamicIslandEventCoordinator = this.eventCoordinator;
        if (dynamicIslandEventCoordinator != null) {
            DynamicIslandEventCoordinator.dispatchEvent$default(dynamicIslandEventCoordinator, DynamicIslandEvent.AvoidScreenReset.INSTANCE, null, 2, null);
        }
    }

    private final void setMode(boolean bl) {
        this.mode = bl;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("switch to FadeBackground Mode=");
        stringBuilder.append(bl);
        Log.d((String)TAG, (String)stringBuilder.toString());
    }

    private final void updateAlpha(DynamicIslandContentView frameLayout, float f2) {
        if (frameLayout != null) {
            frameLayout.setTransitionAlpha(f2);
        }
        if (frameLayout != null && (frameLayout = frameLayout.getBackgroundView()) != null) {
            frameLayout.setTransitionAlpha(f2);
        }
    }

    private final void updateTranslationX(DynamicIslandContentView frameLayout, boolean bl) {
        DynamicIslandBackgroundView dynamicIslandBackgroundView;
        int n;
        int n2;
        if (frameLayout != null) {
            n = n2 = this.translationStep;
            if (bl) {
                n = -n2;
            }
            frameLayout.setTranslationX(frameLayout.getTranslationX() + (float)n);
        }
        if (frameLayout != null && (dynamicIslandBackgroundView = frameLayout.getBackgroundView()) != null) {
            n = n2 = this.translationStep;
            if (bl) {
                n = -n2;
            }
            n2 = dynamicIslandBackgroundView.getActualLeft();
            dynamicIslandBackgroundView = frameLayout.getBackgroundView();
            if (dynamicIslandBackgroundView != null) {
                dynamicIslandBackgroundView.setActualLeft(n2 + n);
            }
            if ((dynamicIslandBackgroundView = frameLayout.getBackgroundView()) != null) {
                DynamicIslandBackgroundView dynamicIslandBackgroundView2 = frameLayout.getBackgroundView();
                n = dynamicIslandBackgroundView2 != null ? dynamicIslandBackgroundView2.getActualWidth() + n : 0;
                dynamicIslandBackgroundView.setActualWidth(n);
            }
            if ((frameLayout = frameLayout.getBackgroundView()) != null) {
                frameLayout.invalidate();
            }
        }
    }

    private final void updateTranslationY(DynamicIslandContentView frameLayout, boolean bl) {
        DynamicIslandBackgroundView dynamicIslandBackgroundView;
        int n;
        int n2;
        if (frameLayout != null) {
            n = n2 = this.translationStep;
            if (bl) {
                n = -n2;
            }
            frameLayout.setTranslationY(frameLayout.getTranslationY() + (float)n);
        }
        if (frameLayout != null && (dynamicIslandBackgroundView = frameLayout.getBackgroundView()) != null) {
            n = n2 = this.translationStep;
            if (bl) {
                n = -n2;
            }
            n2 = dynamicIslandBackgroundView.getActualTop();
            dynamicIslandBackgroundView = frameLayout.getBackgroundView();
            if (dynamicIslandBackgroundView != null) {
                dynamicIslandBackgroundView.setActualTop(n2 + n);
            }
            if ((dynamicIslandBackgroundView = frameLayout.getBackgroundView()) != null) {
                DynamicIslandBackgroundView dynamicIslandBackgroundView2 = frameLayout.getBackgroundView();
                n = dynamicIslandBackgroundView2 != null ? dynamicIslandBackgroundView2.getActualHeight() + n : 0;
                dynamicIslandBackgroundView.setActualHeight(n);
            }
            if ((frameLayout = frameLayout.getBackgroundView()) != null) {
                frameLayout.invalidate();
            }
        }
    }

    public final DynamicIslandEventCoordinator getEventCoordinator() {
        return this.eventCoordinator;
    }

    public final I getNotificationPanelExpanded() {
        return this.notificationPanelExpanded;
    }

    public final I getScreenBurnInStrategy() {
        return this.screenBurnInStrategy;
    }

    public final boolean isFadedBefore() {
        if (this.mode) {
            this.recoverBackgroundAlpha = true;
            this.setMode(false);
            this._dynamicIsLandFaded.setValue((Object)Boolean.FALSE);
            this.start();
            return true;
        }
        if (this.handler.hasMessages(11)) {
            this.handler.removeMessages(11);
            this.handler.sendEmptyMessageDelayed(11, 600000L);
        }
        return false;
    }

    public final void resetFadedView(DynamicIslandContentView dynamicIslandContentView) {
        if (dynamicIslandContentView != null) {
            this.updateAlpha(dynamicIslandContentView, 1.0f);
        }
    }

    public final void setEventCoordinator(DynamicIslandEventCoordinator dynamicIslandEventCoordinator) {
        this.eventCoordinator = dynamicIslandEventCoordinator;
        if (dynamicIslandEventCoordinator != null && !this.initialized) {
            this.initCollect();
            this.initialized = true;
        }
    }

    public final void start() {
        this.debugLog(TAG, "start");
    }

    public final void stop() {
        this.debugLog(TAG, "stop");
    }

    public final void updateNotificationPanelExpanded(boolean bl) {
        this._notificationPanelExpanded.setValue((Object)bl);
    }

    public final void updateScreenHelperInfo(int n, boolean bl) {
        this.ready = bl;
        this._screenBurnInGuard.setValue((Object)n);
    }

    public final void updateTranParams(int n, int n2) {
        long l2;
        this.translationInterval = l2 = (long)n;
        this.translationStep = n2;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("updateTranParams   : ");
        stringBuilder.append(l2);
        stringBuilder.append(" ");
        stringBuilder.append(n2);
        this.debugLog(TAG, stringBuilder.toString());
    }

    public final void updateViewForAvoidingScreenBurnIn(DynamicIslandContentView dynamicIslandContentView, int n) {
        if (dynamicIslandContentView != null && (dynamicIslandContentView.getState() instanceof DynamicIslandState.BigIsland || dynamicIslandContentView.getState() instanceof DynamicIslandState.SmallIsland)) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("avoidScreenBurnInAnimation ");
            stringBuilder.append(n);
            this.debugLog(TAG, stringBuilder.toString());
            if (n != -1) {
                if (n != 0) {
                    if (n != 1) {
                        if (n != 2) {
                            if (n != 3) {
                                if (n == 5) {
                                    this.updateAlpha(dynamicIslandContentView, 0.5f);
                                }
                            } else {
                                this.updateTranslationY(dynamicIslandContentView, false);
                            }
                        } else {
                            this.updateTranslationX(dynamicIslandContentView, false);
                        }
                    } else {
                        this.updateTranslationY(dynamicIslandContentView, true);
                    }
                } else {
                    this.updateTranslationX(dynamicIslandContentView, true);
                }
            } else {
                this.resetView();
            }
        }
    }
}
