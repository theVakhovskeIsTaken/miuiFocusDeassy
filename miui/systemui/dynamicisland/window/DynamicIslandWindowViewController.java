/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  D0.a
 *  G0.c
 *  G0.d
 *  G0.e
 *  G0.i
 *  G0.k
 *  G0.s
 *  H0.m
 *  H0.u
 *  K0.d
 *  K0.g
 *  L0.c
 *  M0.b
 *  M0.d
 *  U.d
 *  U0.a
 *  U0.o
 *  android.annotation.SuppressLint
 *  android.content.BroadcastReceiver
 *  android.content.ComponentName
 *  android.content.ContentResolver
 *  android.content.Context
 *  android.content.Intent
 *  android.content.IntentFilter
 *  android.content.res.Configuration
 *  android.database.ContentObserver
 *  android.graphics.Rect
 *  android.graphics.Region
 *  android.os.Bundle
 *  android.os.Handler
 *  android.os.Parcelable
 *  android.os.UserHandle
 *  android.provider.Settings$Secure
 *  android.service.notification.StatusBarNotification
 *  android.text.TextUtils
 *  android.util.Log
 *  android.view.AttachedSurfaceControl
 *  android.view.MotionEvent
 *  android.view.View
 *  android.view.ViewGroup
 *  android.view.ViewGroup$OnHierarchyChangeListener
 *  android.widget.FrameLayout
 *  android.window.SurfaceSyncGroup
 *  androidx.core.view.ViewGroupKt
 *  b.a
 *  com.airbnb.lottie.LottieAnimationView
 *  com.android.systemui.plugins.miui.dynamicisland.DynamicIslandContent
 *  com.android.systemui.plugins.miui.dynamicisland.DynamicIslandContent$DynamicIslandViewChangedListener
 *  com.android.systemui.plugins.miui.dynamicisland.DynamicIslandData
 *  com.android.systemui.plugins.miui.dynamicisland.DynamicIslandGlowEffectLayer
 *  com.android.systemui.plugins.miui.settings.SuperSaveModeController
 *  com.android.systemui.plugins.miui.settings.SuperSaveModeController$SuperSaveModeChangeListener
 *  com.android.systemui.plugins.miui.shade.ShadeSwitchController
 *  com.android.systemui.plugins.miui.shade.ShadeSwitchController$OnShadeSwitchChangedListener
 *  d1.e
 *  d1.l
 *  f1.E
 *  f1.F
 *  f1.M
 *  f1.f
 *  f1.l0
 *  f1.l0$a
 *  h1.o
 *  h1.q
 *  i1.E
 *  i1.I
 *  i1.K
 *  i1.f
 *  i1.g
 *  i1.h
 *  i1.u
 *  i1.y
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.E
 *  kotlin.jvm.internal.o
 *  miui.systemui.autodensity.AutoDensityController
 *  miui.systemui.autodensity.AutoDensityController$OnDensityChangeListener
 *  miui.systemui.controlcenter.ConfigUtils
 *  miui.systemui.coroutines.Dispatchers
 *  miui.systemui.dagger.qualifiers.Background
 *  miui.systemui.dagger.qualifiers.Main
 *  miui.systemui.drawable.AppIconsManager
 *  miui.systemui.notification.LottieProgressManager
 *  miui.systemui.notification.LottieProgressManager$LottieProgressSyncHelper
 *  miui.systemui.notification.NotificationChronometerManager
 *  miui.systemui.notification.NotificationTimeKeeper
 *  miui.systemui.notification.TaskStackChangeListener
 *  miui.systemui.notification.TaskStackChangeListeners
 *  miui.systemui.settings.data.repository.WorkBenchModeRepository
 *  miui.systemui.util.CommonUtils
 *  miui.systemui.util.ConvenienceExtensionsKt
 *  miui.systemui.util.DeviceStateManagerCompat
 *  miui.systemui.util.DeviceStateManagerCompat$FoldStateCallback
 *  miui.systemui.util.FlipUtils
 *  miui.systemui.util.FoldUtils
 *  miui.systemui.util.MetadataUtils
 *  miui.systemui.util.OneHandModeUtils
 *  miui.systemui.util.ViewController
 *  miui.systemui.util.concurrency.DelayableExecutor
 *  miui.systemui.util.coroutines.flow.FlowConflatedKt
 *  miuix.colorful.texteffect.HyperChronometer
 */
package miui.systemui.dynamicisland.window;

import D0.a;
import G0.i;
import G0.k;
import G0.s;
import H0.m;
import H0.u;
import L0.c;
import M0.b;
import U.d;
import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.database.ContentObserver;
import android.graphics.Rect;
import android.graphics.Region;
import android.os.Bundle;
import android.os.Handler;
import android.os.Parcelable;
import android.os.UserHandle;
import android.provider.Settings;
import android.service.notification.StatusBarNotification;
import android.text.TextUtils;
import android.util.Log;
import android.view.AttachedSurfaceControl;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.window.SurfaceSyncGroup;
import androidx.core.view.ViewGroupKt;
import com.airbnb.lottie.LottieAnimationView;
import com.android.systemui.plugins.miui.dynamicisland.DynamicIslandContent;
import com.android.systemui.plugins.miui.dynamicisland.DynamicIslandData;
import com.android.systemui.plugins.miui.dynamicisland.DynamicIslandGlowEffectLayer;
import com.android.systemui.plugins.miui.settings.SuperSaveModeController;
import com.android.systemui.plugins.miui.shade.ShadeSwitchController;
import d1.e;
import d1.l;
import f1.F;
import f1.M;
import f1.f;
import f1.l0;
import i1.I;
import i1.K;
import i1.g;
import i1.h;
import i1.y;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.E;
import kotlin.jvm.internal.o;
import miui.systemui.autodensity.AutoDensityController;
import miui.systemui.controlcenter.ConfigUtils;
import miui.systemui.coroutines.Dispatchers;
import miui.systemui.dagger.qualifiers.Background;
import miui.systemui.dagger.qualifiers.Main;
import miui.systemui.drawable.AppIconsManager;
import miui.systemui.dynamicisland.DynamicIslandAnimUtils;
import miui.systemui.dynamicisland.DynamicIslandBackgroundView;
import miui.systemui.dynamicisland.DynamicIslandDevicesUtils;
import miui.systemui.dynamicisland.DynamicIslandScenarioUtils;
import miui.systemui.dynamicisland.DynamicIslandStartable;
import miui.systemui.dynamicisland.DynamicIslandUtils;
import miui.systemui.dynamicisland.R;
import miui.systemui.dynamicisland.concurrency.dagger.qualifiers.IslandInflateThread;
import miui.systemui.dynamicisland.concurrency.dagger.qualifiers.IslandUiImmediateThread;
import miui.systemui.dynamicisland.dagger.DynamicIslandScope;
import miui.systemui.dynamicisland.dagger.qualifiers.DynamicIsland;
import miui.systemui.dynamicisland.data.repository.DynamicIslandExternalStateRepository;
import miui.systemui.dynamicisland.data.repository.DynamicIslandSizeRepository;
import miui.systemui.dynamicisland.display.AvoidScreenBurnInHelper;
import miui.systemui.dynamicisland.event.DynamicIslandEventCoordinator;
import miui.systemui.dynamicisland.event.DynamicIslandState;
import miui.systemui.dynamicisland.event.WindowAnimState;
import miui.systemui.dynamicisland.events.DynamicIslandEventTracker;
import miui.systemui.dynamicisland.model.IslandTemplate;
import miui.systemui.dynamicisland.touch.TouchEvent;
import miui.systemui.dynamicisland.touch.domain.interactor.DynamicIslandExternalTouchInteractor;
import miui.systemui.dynamicisland.view.DynamicIslandBigIslandView;
import miui.systemui.dynamicisland.window.DynamicIslandDesktopStateController;
import miui.systemui.dynamicisland.window.DynamicIslandSafeguardsController;
import miui.systemui.dynamicisland.window.DynamicIslandWindowState;
import miui.systemui.dynamicisland.window.DynamicIslandWindowView;
import miui.systemui.dynamicisland.window.DynamicIslandWindowViewController;
import miui.systemui.dynamicisland.window.DynamicIslandWindowViewController$special$;
import miui.systemui.dynamicisland.window.content.DynamicIslandBaseContentView;
import miui.systemui.dynamicisland.window.content.DynamicIslandContentFakeView;
import miui.systemui.dynamicisland.window.content.DynamicIslandContentView;
import miui.systemui.dynamicisland.window.q;
import miui.systemui.notification.LottieProgressManager;
import miui.systemui.notification.NotificationChronometerManager;
import miui.systemui.notification.NotificationTimeKeeper;
import miui.systemui.notification.TaskStackChangeListener;
import miui.systemui.notification.TaskStackChangeListeners;
import miui.systemui.settings.data.repository.WorkBenchModeRepository;
import miui.systemui.util.CommonUtils;
import miui.systemui.util.ConvenienceExtensionsKt;
import miui.systemui.util.DeviceStateManagerCompat;
import miui.systemui.util.FlipUtils;
import miui.systemui.util.FoldUtils;
import miui.systemui.util.MetadataUtils;
import miui.systemui.util.OneHandModeUtils;
import miui.systemui.util.ViewController;
import miui.systemui.util.concurrency.DelayableExecutor;
import miui.systemui.util.coroutines.flow.FlowConflatedKt;
import miuix.colorful.texteffect.HyperChronometer;

@DynamicIslandScope
@SuppressLint(value={"ClickableViewAccessibility"})
public final class DynamicIslandWindowViewController
extends ViewController<DynamicIslandWindowView>
implements DynamicIslandContent,
DynamicIslandStartable,
AutoDensityController.OnDensityChangeListener {
    private static final String AOD_FULL_SCREEN = "full_screen_aod_on";
    private static final String AOD_MODE = "doze_always_on";
    private static final float COMPATIBILITY_VALUE = -1.0f;
    public static final Companion Companion = new Object(null){
        {
            this();
        }
    };
    private static final long DELAY_TIME = 100L;
    private static final long DELAY_TIME_WHEN_WINDOW_ANIMATION = 1000L;
    private static final double ONE_HEAD_MODE_PRE = 0.4;
    public static final String OPEN_APP_ERROR = "open_app_error";
    private static final String TAG = "DynamicIslandWindowViewController";
    private final i1.u _freeformAnimRegion;
    private final i1.u _isAppAnimRunning;
    private final i1.u _isFreeformAnimRunning;
    private int appAnimSmallX;
    private String appCloseKey;
    private HashMap<String, Rect> appCloseRect;
    private AutoDensityController autoDensityController;
    private a avoidScreenBurnInHelper;
    private final Handler bgHandler;
    private final y children;
    private final BroadcastReceiver collapsedReceiver;
    private Configuration configuration;
    private final ContentResolver contentResolver;
    private final y contentViews;
    private l0 controlCenterPanelHeightChangingJob;
    private int currentHeight;
    private final Object deviceStateManager;
    private final DynamicIslandDevicesUtils devicesUtils;
    private int displayOrientation;
    private DynamicIslandCallback dynamicIslandCallback;
    private DynamicIslandDesktopStateController dynamicIslandDesktopStateController;
    private DynamicIslandGlowEffectLayer dynamicIslandGlowEffectLayer;
    private DynamicIslandSafeguardsController dynamicIslandSafeguardsController;
    private final G0.d externalStateRepository$delegate;
    private final G0.d externalTouchHandler$delegate;
    private final ArrayList<DeviceStateManagerCompat.FoldStateCallback> foldStateCallbacks;
    private final Object foldStateListener;
    private final I freeformAnimRegion;
    private final i1.u fullScreenPkg;
    private b.a hyperDropInfoNotifierService;
    private HashMap<String, Boolean> inSmallWindowMap;
    private final K0.g inflateContext;
    private final f1.E ioScope;
    private boolean isAodOn;
    private final I isAppAnimRunning;
    private final I isFreeformAnimRunning;
    private boolean isFullAodOn;
    private Boolean isMiniState;
    private final G0.d isNotchScreenDevice$delegate;
    private boolean isPendingTopChanged;
    private final G0.d isRealCutoutHeightDevice$delegate;
    private boolean isRegisteredCollapsedReceiver;
    private boolean isSupportFreeformAnim;
    private HashMap<String, DynamicIslandData> islandData;
    private int lastDisplayOrientation;
    private String lastEventKey;
    private String lastTopActivityPkg;
    private DynamicIslandContent.DynamicIslandViewChangedListener listener;
    private a lottieProgressManager;
    private final BroadcastReceiver miPlayShowStateChangedBroadcastReceiver;
    private boolean miPlayShowStateChangedBroadcastRegistered;
    private final G0.d notificationChronometerManager$delegate;
    private l0 notificationPanelHeightChangingJob;
    private String openAppKey;
    private final BroadcastReceiver packagesBroadcastReceiver;
    private boolean packagesBroadcastRegistered;
    private HashMap<DynamicIslandData, Boolean> pendingData;
    private ArrayList<String> pinOperateList;
    private boolean requestPosition;
    private boolean requestPositionByClosePosition;
    private final settingsObserver.1 settingsObserver;
    private final shadeSwitchControlListener.1 shadeSwitchControlListener;
    private final ShadeSwitchController shadeSwitchController;
    private boolean shouldDelayExitApp;
    private final DynamicIslandSizeRepository sizeRepository;
    private final superSaveModeChangeListener.1 superSaveModeChangeListener;
    private final SuperSaveModeController superSaveModeController;
    private boolean supportMediaFreeform;
    private final TaskStackChangeListener taskStackListener;
    private String topActivityPkg;
    private DelayableExecutor uiExecutor;
    private final K0.g uiImmediateContext;
    private final f1.E uiScope;
    private final f1.E uiScopeImmediate;
    private DynamicIslandWindowState windowState;
    private final a workBenchModeRepository;

    public DynamicIslandWindowViewController(DynamicIslandWindowView object, @DynamicIsland f1.E object2, @Main DelayableExecutor object3, a a2, a object4, DynamicIslandWindowState object5, a object6, DynamicIslandDesktopStateController dynamicIslandDesktopStateController, DynamicIslandSafeguardsController dynamicIslandSafeguardsController, a object7, AutoDensityController object8, a object9, b.a a3, DynamicIslandSizeRepository dynamicIslandSizeRepository, @Background Handler handler, @IslandInflateThread K0.g g2, @IslandUiImmediateThread K0.g g3, SuperSaveModeController superSaveModeController, ShadeSwitchController shadeSwitchController, a a4, DynamicIslandDevicesUtils dynamicIslandDevicesUtils) {
        o.g((Object)object, (String)"view");
        o.g((Object)object2, (String)"scope");
        o.g((Object)object3, (String)"uiExecutor");
        o.g((Object)a2, (String)"notificationChronometerManager");
        o.g((Object)object4, (String)"avoidScreenBurnInHelper");
        o.g((Object)object5, (String)"windowState");
        o.g((Object)object6, (String)"externalTouchHandler");
        o.g((Object)dynamicIslandDesktopStateController, (String)"dynamicIslandDesktopStateController");
        o.g((Object)dynamicIslandSafeguardsController, (String)"dynamicIslandSafeguardsController");
        o.g((Object)object7, (String)"externalStateRepository");
        o.g((Object)object8, (String)"autoDensityController");
        o.g((Object)object9, (String)"lottieProgressManager");
        o.g((Object)a3, (String)"hyperDropInfoNotifierService");
        o.g((Object)dynamicIslandSizeRepository, (String)"sizeRepository");
        o.g((Object)handler, (String)"bgHandler");
        o.g((Object)g2, (String)"inflateContext");
        o.g((Object)g3, (String)"uiImmediateContext");
        o.g((Object)superSaveModeController, (String)"superSaveModeController");
        o.g((Object)shadeSwitchController, (String)"shadeSwitchController");
        o.g((Object)a4, (String)"workBenchModeRepository");
        o.g((Object)dynamicIslandDevicesUtils, (String)"devicesUtils");
        super((View)object);
        this.uiExecutor = object3;
        this.avoidScreenBurnInHelper = object4;
        this.windowState = object5;
        this.dynamicIslandDesktopStateController = dynamicIslandDesktopStateController;
        this.dynamicIslandSafeguardsController = dynamicIslandSafeguardsController;
        this.autoDensityController = object8;
        this.lottieProgressManager = object9;
        this.hyperDropInfoNotifierService = a3;
        this.sizeRepository = dynamicIslandSizeRepository;
        this.bgHandler = handler;
        this.inflateContext = g2;
        this.uiImmediateContext = g3;
        this.superSaveModeController = superSaveModeController;
        this.shadeSwitchController = shadeSwitchController;
        this.workBenchModeRepository = a4;
        this.devicesUtils = dynamicIslandDevicesUtils;
        this.externalTouchHandler$delegate = ConvenienceExtensionsKt.getKotlinLazy((a)object6);
        this.externalStateRepository$delegate = ConvenienceExtensionsKt.getKotlinLazy((a)object7);
        this.notificationChronometerManager$delegate = ConvenienceExtensionsKt.getKotlinLazy((a)a2);
        object3 = new ShadeSwitchController.OnShadeSwitchChangedListener((DynamicIslandWindowView)((Object)object), this){
            final DynamicIslandWindowView $view;
            final DynamicIslandWindowViewController this$0;
            {
                this.$view = dynamicIslandWindowView;
                this.this$0 = dynamicIslandWindowViewController;
            }

            public void onSwitchingChanged(boolean bl) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("shade controlCenter switching changed to ");
                stringBuilder.append(bl);
                Log.d((String)"DynamicIslandWindowViewController", (String)stringBuilder.toString());
                if (CommonUtils.INSTANCE.getIS_TABLET() && bl) {
                    this.$view.onIslandTempHide(true, this.this$0.getWindowState().getTempHiddenType());
                }
            }
        };
        this.shadeSwitchControlListener = object3;
        object4 = FlowConflatedKt.conflatedCallbackFlow((U0.o)new U0.o((DynamicIslandWindowView)((Object)object), null){
            final DynamicIslandWindowView $view;
            private Object L$0;
            int label;
            {
                this.$view = dynamicIslandWindowView;
                super(2, d2);
            }

            public final K0.d create(Object object, K0.d object2) {
                object2 = new /* invalid duplicate definition of identical inner class */;
                object2.L$0 = object;
                return object2;
            }

            public final Object invoke(h1.q q2, K0.d d2) {
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
                    object = (h1.q)this.L$0;
                    ViewGroup.OnHierarchyChangeListener onHierarchyChangeListener = new ViewGroup.OnHierarchyChangeListener((h1.q)object, this.$view){
                        final h1.q $$this$conflatedCallbackFlow;
                        final DynamicIslandWindowView $view;
                        {
                            this.$$this$conflatedCallbackFlow = q2;
                            this.$view = dynamicIslandWindowView;
                        }

                        public void onChildViewAdded(View view, View view2) {
                            this.$$this$conflatedCallbackFlow.i((Object)l.r((e)ViewGroupKt.getChildren((ViewGroup)this.$view)));
                        }

                        public void onChildViewRemoved(View view, View view2) {
                            this.$$this$conflatedCallbackFlow.i((Object)l.r((e)ViewGroupKt.getChildren((ViewGroup)this.$view)));
                        }
                    };
                    this.$view.setOnHierarchyChangeListener(onHierarchyChangeListener);
                    U0.a a2 = new U0.a(this.$view){
                        final DynamicIslandWindowView $view;
                        {
                            this.$view = dynamicIslandWindowView;
                            super(0);
                        }

                        public final void invoke() {
                            this.$view.setOnHierarchyChangeListener(null);
                        }
                    };
                    this.label = 1;
                    if (h1.o.a((h1.q)object, (U0.a)a2, (K0.d)this) != object2) return s.a;
                    return object2;
                }
            }
        });
        a2 = i1.E.a;
        object4 = h.z((i1.f)object4, (f1.E)object2, (i1.E)a2.c(), (int)1);
        this.children = object4;
        this.contentViews = h.z((i1.f)h.n((i1.f)new i1.f((i1.f)object4){
            final i1.f $this_unsafeTransform$inlined;
            {
                this.$this_unsafeTransform$inlined = f2;
            }

            public Object collect(g object, K0.d d2) {
                if ((object = this.$this_unsafeTransform$inlined.collect(new g((g)object){
                    final g $this_unsafeFlow;
                    {
                        this.$this_unsafeFlow = g2;
                    }

                    /*
                     * Unable to fully structure code
                     * Could not resolve type clashes
                     */
                    public final Object emit(Object var1_1, K0.d var2_2) {
                        if (!(var2_2 /* !! */  instanceof special$$inlined$map$1$2$1)) ** GOTO lbl-1000
                        var5_3 /* !! */  = var2_2 /* !! */ ;
                        var3_4 = var5_3 /* !! */ .label;
                        if ((var3_4 & -2147483648) != 0) {
                            var5_3 /* !! */ .label = var3_4 + -2147483648;
                            var2_2 /* !! */  = var5_3 /* !! */ ;
                        } else lbl-1000:
                        // 2 sources

                        {
                            var2_2 /* !! */  = new M0.d(this, var2_2 /* !! */ ){
                                Object L$0;
                                int label;
                                Object result;
                                final special$$inlined$map$1$2 this$0;
                                {
                                    this.this$0 = var1_1;
                                    super(d2);
                                }

                                public final Object invokeSuspend(Object object) {
                                    this.result = object;
                                    this.label |= Integer.MIN_VALUE;
                                    return this.this$0.emit(null, (K0.d)this);
                                }
                            };
                        }
                        var5_3 /* !! */  = var2_2 /* !! */ .result;
                        var6_5 = c.c();
                        var3_4 = var2_2 /* !! */ .label;
                        if (var3_4 == 0) ** GOTO lbl17
                        if (var3_4 == 1) {
                            k.b((Object)var5_3 /* !! */ );
                        } else {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
lbl17:
                            // 1 sources

                            k.b((Object)var5_3 /* !! */ );
                            var7_6 = this.$this_unsafeFlow;
                            var1_1 /* !! */  = (List)var1_1 /* !! */ ;
                            var8_7 = new ArrayList<special$$inlined$map$1$2$1>();
                            var9_8 = var1_1 /* !! */ .iterator();
                            while (var9_8.hasNext()) {
                                var1_1 /* !! */  = (View)var9_8.next();
                                var4_9 = var1_1 /* !! */  instanceof DynamicIslandBackgroundView;
                                var5_3 /* !! */  = null;
                                var1_1 /* !! */  = var4_9 != false ? (DynamicIslandBackgroundView)var1_1 /* !! */  : null;
                                if ((var1_1 /* !! */  = var1_1 /* !! */  != null ? var1_1 /* !! */ .getChildAt(0) : null) instanceof DynamicIslandContentView) {
                                    var5_3 /* !! */  = (DynamicIslandContentView)var1_1 /* !! */ ;
                                }
                                if (var5_3 /* !! */  == null) continue;
                                var8_7.add(var5_3 /* !! */ );
                            }
                            var2_2 /* !! */ .label = 1;
                            if (var7_6.emit(var8_7, var2_2 /* !! */ ) == var6_5) {
                                return var6_5;
                            }
                        }
                        return s.a;
                    }
                }, d2)) == c.c()) {
                    return object;
                }
                return s.a;
            }
        }), (f1.E)object2, (i1.E)a2.c(), (int)1);
        a2 = Dispatchers.INSTANCE;
        this.uiScope = F.g((f1.E)object2, (K0.g)a2.getMain());
        this.uiScopeImmediate = F.g((f1.E)object2, (K0.g)a2.getMain().B());
        this.ioScope = F.g((f1.E)object2, (K0.g)a2.getIO());
        this.inSmallWindowMap = new HashMap();
        this.islandData = new HashMap();
        this.pendingData = new HashMap();
        this.fullScreenPkg = K.a((Object)"");
        this.topActivityPkg = "com.miui.home";
        this.lastTopActivityPkg = "com.miui.home";
        object2 = Boolean.FALSE;
        a2 = K.a((Object)object2);
        this._isFreeformAnimRunning = a2;
        this.isFreeformAnimRunning = h.b((i1.u)a2);
        a2 = K.a((Object)new Region());
        this._freeformAnimRegion = a2;
        this.freeformAnimRegion = h.b((i1.u)a2);
        this.isMiniState = object2;
        object2 = K.a((Object)object2);
        this._isAppAnimRunning = object2;
        this.isAppAnimRunning = h.b((i1.u)object2);
        this.appCloseRect = new HashMap();
        this.isSupportFreeformAnim = true;
        object2 = DynamicIslandAnimUtils.INSTANCE;
        a2 = object.getContext();
        o.f((Object)a2, (String)"getContext(...)");
        this.supportMediaFreeform = ((DynamicIslandAnimUtils)object2).getSupportMediaFreeForm((Context)a2);
        object8 = new BroadcastReceiver((DynamicIslandWindowView)((Object)object)){
            final DynamicIslandWindowView $view;
            {
                this.$view = dynamicIslandWindowView;
            }

            public void onReceive(Context object, Intent intent) {
                o.g((Object)object, (String)"context");
                o.g((Object)intent, (String)"intent");
                String string = intent.getAction();
                object = new StringBuilder();
                ((StringBuilder)object).append("onReceive   : ");
                ((StringBuilder)object).append(string);
                Log.d((String)"DynamicIslandWindowViewController", (String)((StringBuilder)object).toString());
                if (o.c((Object)"com.miui.action.ACTION_COLLAPSE_ISLAND", (Object)intent.getAction())) {
                    this.$view.collapse("receive collapse");
                }
            }
        };
        this.collapsedReceiver = object8;
        object9 = new BroadcastReceiver((DynamicIslandWindowView)((Object)object)){
            final DynamicIslandWindowView $view;
            {
                this.$view = dynamicIslandWindowView;
            }

            public void onReceive(Context object, Intent object2) {
                o.g((Object)object, (String)"context");
                o.g((Object)object2, (String)"intent");
                object = object2.getAction();
                if ((o.c((Object)"android.intent.action.PACKAGE_ADDED", (Object)object) || o.c((Object)"android.intent.action.PACKAGE_REPLACED", (Object)object) || o.c((Object)"android.intent.action.PACKAGE_REMOVED", (Object)object)) && (object = object2.getData()) != null) {
                    object = object.getSchemeSpecificPart();
                    object2 = this.$view;
                    o.d((Object)object);
                    ((DynamicIslandWindowView)((Object)object2)).updatePkgSupportFreeform((String)object);
                }
            }
        };
        this.packagesBroadcastReceiver = object9;
        dynamicIslandSafeguardsController = new BroadcastReceiver(this){
            final DynamicIslandWindowViewController this$0;
            {
                this.this$0 = dynamicIslandWindowViewController;
            }

            public void onReceive(Context context, Intent intent) {
                o.g((Object)context, (String)"context");
                o.g((Object)intent, (String)"intent");
                if (o.c((Object)"android.intent.action.MIPLAY_SHOW_STATE_CHANGED", (Object)intent.getAction())) {
                    boolean bl = intent.getBooleanExtra("extra_miplay_show_state", true);
                    DynamicIslandWindowViewController.access$handleMiPlayShowState(this.this$0, bl);
                }
            }
        };
        this.miPlayShowStateChangedBroadcastReceiver = dynamicIslandSafeguardsController;
        dynamicIslandDesktopStateController = DeviceStateManagerCompat.INSTANCE;
        object = dynamicIslandDesktopStateController.getDeviceStateManagerInstance();
        this.deviceStateManager = object;
        this.foldStateCallbacks = new ArrayList();
        object4 = dynamicIslandDesktopStateController.getFoldStateListenerInstance(this.getContext(), new q(this));
        this.foldStateListener = object4;
        object6 = new TaskStackChangeListener(this){
            final DynamicIslandWindowViewController this$0;
            {
                this.this$0 = dynamicIslandWindowViewController;
            }

            public void onLockTaskModeChanged(int n) {
                Object object = this.this$0;
                boolean bl = false;
                boolean bl2 = n == 2;
                ((DynamicIslandWindowViewController)object).screenPinningActive(bl2);
                bl2 = bl;
                if (n == 2) {
                    bl2 = true;
                }
                object = new StringBuilder();
                ((StringBuilder)object).append("onLockTaskModeChanged: screenPinningActive:");
                ((StringBuilder)object).append(bl2);
                Log.d((String)"DynamicIslandWindowViewController", (String)((StringBuilder)object).toString());
            }
        };
        this.taskStackListener = object6;
        this.superSaveModeChangeListener = object5 = new SuperSaveModeController.SuperSaveModeChangeListener(this){
            final DynamicIslandWindowViewController this$0;
            {
                this.this$0 = dynamicIslandWindowViewController;
            }

            public void onSuperSaveModeChange(boolean bl) {
                this.this$0.getWindowState().isSuperSaveMode().setValue((Object)bl);
            }
        };
        this.isNotchScreenDevice$delegate = G0.e.b((U0.a)new U0.a(this){
            final DynamicIslandWindowViewController this$0;
            {
                this.this$0 = dynamicIslandWindowViewController;
                super(0);
            }

            public final Boolean invoke() {
                return DynamicIslandWindowViewController.access$getDevicesUtils$p(this.this$0).isNotchScreenDevice();
            }
        });
        this.isRealCutoutHeightDevice$delegate = G0.e.b((U0.a)new U0.a(this){
            final DynamicIslandWindowViewController this$0;
            {
                this.this$0 = dynamicIslandWindowViewController;
                super(0);
            }

            public final Boolean invoke() {
                return DynamicIslandWindowViewController.access$getDevicesUtils$p(this.this$0).isRealCutoutHeightDevice();
            }
        });
        a2 = this.getContext().getContentResolver();
        this.contentResolver = a2;
        object7 = new ContentObserver(this, handler){
            final DynamicIslandWindowViewController this$0;
            {
                this.this$0 = dynamicIslandWindowViewController;
                super(handler);
            }

            public void onChange(boolean bl) {
                if (bl) {
                    return;
                }
                Object object = DynamicIslandWindowViewController.access$getContentResolver$p(this.this$0);
                boolean bl2 = false;
                bl = Settings.Secure.getInt((ContentResolver)object, (String)"full_screen_aod_on", (int)0) == 1;
                if (Settings.Secure.getInt((ContentResolver)DynamicIslandWindowViewController.access$getContentResolver$p(this.this$0), (String)"doze_always_on", (int)0) == 1) {
                    bl2 = true;
                }
                DynamicIslandWindowViewController.access$setFullAodOn$p(this.this$0, bl);
                DynamicIslandWindowViewController.access$setAodOn$p(this.this$0, bl2);
                bl = DynamicIslandWindowViewController.access$isFullAodOn$p(this.this$0);
                bl2 = DynamicIslandWindowViewController.access$isAodOn$p(this.this$0);
                object = new StringBuilder();
                ((StringBuilder)object).append("isFullAodOn: ");
                ((StringBuilder)object).append(bl);
                ((StringBuilder)object).append(" isAodOn: ");
                ((StringBuilder)object).append(bl2);
                Log.d((String)"DynamicIslandWindowViewController", (String)((StringBuilder)object).toString());
            }
        };
        this.settingsObserver = object7;
        this.configuration = new Configuration(this.getResources().getConfiguration());
        this.updateWindowState();
        a3 = new IntentFilter();
        a3.addAction("com.miui.action.ACTION_COLLAPSE_ISLAND");
        this.isSupportFreeformAnim = MetadataUtils.isSupportFreeFormAnim((Context)this.getContext());
        this.getContext().registerReceiverAsUser((BroadcastReceiver)object8, UserHandle.ALL, (IntentFilter)a3, "com.android.systemui.permission.NOTIFICATION", null, 2);
        this.isRegisteredCollapsedReceiver = true;
        object8 = new IntentFilter();
        object8.addAction("android.intent.action.PACKAGE_ADDED");
        object8.addAction("android.intent.action.PACKAGE_REMOVED");
        object8.addAction("android.intent.action.PACKAGE_REPLACED");
        object8.addDataScheme("package");
        this.getContext().registerReceiver((BroadcastReceiver)object9, (IntentFilter)object8, 2);
        this.packagesBroadcastRegistered = true;
        a3 = this.getContext();
        object8 = new IntentFilter();
        object8.addAction("android.intent.action.MIPLAY_SHOW_STATE_CHANGED");
        object9 = s.a;
        a3.registerReceiver((BroadcastReceiver)dynamicIslandSafeguardsController, (IntentFilter)object8, 4);
        this.miPlayShowStateChangedBroadcastRegistered = true;
        this.dynamicIslandDesktopStateController.start();
        dynamicIslandDesktopStateController.registerCallbackCompat(object, (Executor)this.uiExecutor, object4);
        this.autoDensityController.addOnDensityChangeListener((AutoDensityController.OnDensityChangeListener)this);
        TaskStackChangeListeners.getInstance().registerTaskStackListener((TaskStackChangeListener)object6);
        OneHandModeUtils.INSTANCE.registerOneHandSettingsObserver(this.getContext());
        shadeSwitchController.addOnShadeSwitchChangedListener((ShadeSwitchController.OnShadeSwitchChangedListener)object3);
        this.registerTempHiddenChanged();
        ((DynamicIslandAnimUtils)object2).registerHomeDynamicIslandContentObserver(this.getContext());
        a2.registerContentObserver(Settings.Secure.getUriFor((String)AOD_FULL_SCREEN), true, (ContentObserver)object7);
        boolean bl = Settings.Secure.getInt((ContentResolver)a2, (String)AOD_FULL_SCREEN, (int)0) == 1;
        this.isFullAodOn = bl;
        a2.registerContentObserver(Settings.Secure.getUriFor((String)AOD_MODE), true, (ContentObserver)object7);
        bl = Settings.Secure.getInt((ContentResolver)a2, (String)AOD_MODE, (int)0) == 1;
        this.isAodOn = bl;
        superSaveModeController.addCallback((SuperSaveModeController.SuperSaveModeChangeListener)object5);
        this.pinOperateList = new ArrayList();
    }

    public static /* synthetic */ void a(DynamicIslandWindowViewController dynamicIslandWindowViewController, Boolean bl) {
        DynamicIslandWindowViewController.foldStateListener$lambda$3(dynamicIslandWindowViewController, bl);
    }

    public static final /* synthetic */ void access$cancelDelayOperate(DynamicIslandWindowViewController dynamicIslandWindowViewController, String string) {
        dynamicIslandWindowViewController.cancelDelayOperate(string);
    }

    public static final /* synthetic */ Rect access$getAppCloseRealIslandRect(DynamicIslandWindowViewController dynamicIslandWindowViewController, DynamicIslandState dynamicIslandState, DynamicIslandContentView dynamicIslandContentView, String string, boolean bl) {
        return dynamicIslandWindowViewController.getAppCloseRealIslandRect(dynamicIslandState, dynamicIslandContentView, string, bl);
    }

    public static final /* synthetic */ ContentResolver access$getContentResolver$p(DynamicIslandWindowViewController dynamicIslandWindowViewController) {
        return dynamicIslandWindowViewController.contentResolver;
    }

    public static final /* synthetic */ DynamicIslandDevicesUtils access$getDevicesUtils$p(DynamicIslandWindowViewController dynamicIslandWindowViewController) {
        return dynamicIslandWindowViewController.devicesUtils;
    }

    public static final /* synthetic */ DynamicIslandDesktopStateController access$getDynamicIslandDesktopStateController$p(DynamicIslandWindowViewController dynamicIslandWindowViewController) {
        return dynamicIslandWindowViewController.dynamicIslandDesktopStateController;
    }

    public static final /* synthetic */ DynamicIslandExternalStateRepository access$getExternalStateRepository(DynamicIslandWindowViewController dynamicIslandWindowViewController) {
        return dynamicIslandWindowViewController.getExternalStateRepository();
    }

    public static final /* synthetic */ i1.u access$getFullScreenPkg$p(DynamicIslandWindowViewController dynamicIslandWindowViewController) {
        return dynamicIslandWindowViewController.fullScreenPkg;
    }

    public static final /* synthetic */ ArrayList access$getPinOperateList$p(DynamicIslandWindowViewController dynamicIslandWindowViewController) {
        return dynamicIslandWindowViewController.pinOperateList;
    }

    public static final /* synthetic */ boolean access$getRequestPositionByClosePosition$p(DynamicIslandWindowViewController dynamicIslandWindowViewController) {
        return dynamicIslandWindowViewController.requestPositionByClosePosition;
    }

    public static final /* synthetic */ boolean access$getShouldDelayExitApp$p(DynamicIslandWindowViewController dynamicIslandWindowViewController) {
        return dynamicIslandWindowViewController.shouldDelayExitApp;
    }

    public static final /* synthetic */ DynamicIslandWindowView access$getView(DynamicIslandWindowViewController dynamicIslandWindowViewController) {
        return (DynamicIslandWindowView)dynamicIslandWindowViewController.getView();
    }

    public static final /* synthetic */ a access$getWorkBenchModeRepository$p(DynamicIslandWindowViewController dynamicIslandWindowViewController) {
        return dynamicIslandWindowViewController.workBenchModeRepository;
    }

    public static final /* synthetic */ void access$handleMiPlayShowState(DynamicIslandWindowViewController dynamicIslandWindowViewController, boolean bl) {
        dynamicIslandWindowViewController.handleMiPlayShowState(bl);
    }

    public static final /* synthetic */ boolean access$hasAppState(DynamicIslandWindowViewController dynamicIslandWindowViewController, String string) {
        return dynamicIslandWindowViewController.hasAppState(string);
    }

    public static final /* synthetic */ boolean access$isAodOn$p(DynamicIslandWindowViewController dynamicIslandWindowViewController) {
        return dynamicIslandWindowViewController.isAodOn;
    }

    public static final /* synthetic */ boolean access$isFullAodOn$p(DynamicIslandWindowViewController dynamicIslandWindowViewController) {
        return dynamicIslandWindowViewController.isFullAodOn;
    }

    public static final /* synthetic */ void access$lockScreen(DynamicIslandWindowViewController dynamicIslandWindowViewController, boolean bl) {
        dynamicIslandWindowViewController.lockScreen(bl);
    }

    public static final /* synthetic */ boolean access$needExitMiniWindow(DynamicIslandWindowViewController dynamicIslandWindowViewController, boolean bl, String string) {
        return dynamicIslandWindowViewController.needExitMiniWindow(bl, string);
    }

    public static final /* synthetic */ void access$setAodOn$p(DynamicIslandWindowViewController dynamicIslandWindowViewController, boolean bl) {
        dynamicIslandWindowViewController.isAodOn = bl;
    }

    public static final /* synthetic */ void access$setFullAodOn$p(DynamicIslandWindowViewController dynamicIslandWindowViewController, boolean bl) {
        dynamicIslandWindowViewController.isFullAodOn = bl;
    }

    private final void cancelDelayOperate(String string) {
        this.dynamicIslandSafeguardsController.cancelDelayEnterApp(string);
        this.dynamicIslandSafeguardsController.cancelDelayEnterMiniWindow(string);
        this.dynamicIslandSafeguardsController.cancelDelayExitApp(string);
        this.dynamicIslandSafeguardsController.cancelDelayExitMiniWindow(string);
    }

    private final boolean checkFlipTiny(Integer n) {
        boolean bl;
        boolean bl2 = bl = false;
        if (n != null) {
            bl2 = bl;
            if (FlipUtils.isFlip()) {
                bl2 = bl;
                if (FlipUtils.isFlipTiny()) {
                    bl2 = n == 0 ? bl : true;
                }
            }
        }
        return bl2;
    }

    private final void commandQueueDisable(int n) {
        boolean bl = (n & 0x20000) == 0;
        this.windowState.setTempHiddenType(DynamicIslandWindowState.TempHiddenType.SHOW_NOTIFICATION_ICONS);
        this.windowState.getShowNotificationIcons().setValue((Object)bl);
    }

    private static final void foldStateListener$lambda$3(DynamicIslandWindowViewController object, Boolean bl) {
        o.g((Object)object, (String)"this$0");
        o.g((Object)bl, (String)"folded");
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("onFoldStateChanged: ");
        stringBuilder.append(bl);
        Log.d((String)TAG, (String)stringBuilder.toString());
        if (!((DynamicIslandWindowViewController)object).foldStateCallbacks.isEmpty()) {
            object = ((DynamicIslandWindowViewController)object).foldStateCallbacks.iterator();
            while (object.hasNext()) {
                ((DeviceStateManagerCompat.FoldStateCallback)object.next()).onFoldStateChanged(bl.booleanValue());
            }
        }
    }

    /*
     * WARNING - void declaration
     * Enabled aggressive block sorting
     */
    private final Rect getAppCloseRealIslandRect(DynamicIslandState object, DynamicIslandContentView dynamicIslandContentView, String object2, boolean bl) {
        void var1_38;
        void var3_50;
        block36: {
            void var1_3;
            block31: {
                void var2_39;
                Object var10_55;
                block35: {
                    block34: {
                        void var4_51;
                        void var3_40;
                        Iterator iterator;
                        Object var9_54;
                        Boolean bl2;
                        block32: {
                            void var1_7;
                            block33: {
                                boolean bl3 = object instanceof DynamicIslandState.BigIsland;
                                bl2 = null;
                                var9_54 = null;
                                var10_55 = null;
                                iterator = null;
                                if (!bl3) break block32;
                                if (!((Boolean)this.windowState.getTempHidden().getValue()).booleanValue() && !this.windowState.isShowOnceIsland() || CommonUtils.INSTANCE.getIS_TABLET()) break block33;
                                Rect rect = this.getCutoutRect();
                                break block31;
                            }
                            if (var3_40 != null) {
                                DynamicIslandWindowView dynamicIslandWindowView = (DynamicIslandWindowView)this.getView();
                                int n = var4_51 != false ? dynamicIslandWindowView.getMainMiniWindowTopLeveCount((String)var3_40) : dynamicIslandWindowView.getMainAppExpandedTopLeveCount();
                                Integer n2 = n;
                            } else {
                                Object var1_6 = null;
                            }
                            if (var1_7 != null && var1_7.intValue() == 0) {
                                void var1_14;
                                Boolean bl4 = ((DynamicIslandWindowView)this.getView()).hasOtherBigIsland((DynamicIslandContentView)var2_39);
                                if (o.c((Object)bl4, (Object)(bl2 = Boolean.FALSE))) {
                                    Iterator iterator2 = iterator;
                                }
                                if (CommonUtils.INSTANCE.getIS_TABLET()) {
                                    Boolean bl5 = bl2;
                                } else if (var4_51 != false) {
                                    if (((DynamicIslandWindowView)this.getView()).hasSubMiniWindow((String)var3_40)) {
                                        Boolean bl6 = ((DynamicIslandWindowView)this.getView()).hasSubMiniWindow((String)var3_40);
                                    }
                                } else if (((DynamicIslandWindowView)this.getView()).hasSubAppExpanded((String)var3_40)) {
                                    Boolean bl7 = ((DynamicIslandWindowView)this.getView()).hasSubAppExpanded((String)var3_40);
                                }
                                Rect rect = this.getBigIslandRect((DynamicIslandContentView)var2_39, (Boolean)var1_14);
                                break block31;
                            } else if (var1_7 != null && var1_7.intValue() == 1) {
                                void var1_19;
                                DynamicIslandWindowView dynamicIslandWindowView = (DynamicIslandWindowView)this.getView();
                                if (var4_51 != false) {
                                    DynamicIslandContentView dynamicIslandContentView2 = dynamicIslandWindowView.getMainMiniWindowTopLeve((String)var3_40);
                                } else {
                                    DynamicIslandContentView dynamicIslandContentView3 = dynamicIslandWindowView.getMainAppExpandedTopLeve();
                                }
                                Rect rect = this.getSmallIslandRect((DynamicIslandContentView)var2_39, (DynamicIslandContentView)var1_19);
                                break block31;
                            } else {
                                Rect rect = this.getCutoutRect();
                            }
                            break block31;
                        }
                        if (!(object instanceof DynamicIslandState.SmallIsland)) break block34;
                        if (!((Boolean)this.windowState.getTempHidden().getValue()).booleanValue() && !this.windowState.isShowOnceIsland()) {
                            void var1_25;
                            if (var3_40 != null) {
                                DynamicIslandWindowView dynamicIslandWindowView = (DynamicIslandWindowView)this.getView();
                                int n = var4_51 != false ? dynamicIslandWindowView.getMainMiniWindowTopLeveCount((String)var3_40) : dynamicIslandWindowView.getMainAppExpandedTopLeveCount();
                                Integer n3 = n;
                            } else {
                                Object var1_24 = null;
                            }
                            if (var1_25 != null && var1_25.intValue() == 0) {
                                void var3_47;
                                Object var3_43 = var9_54;
                                if (var4_51 == false) {
                                    iterator = ((DynamicIslandWindowView)this.getView()).getCurrentAppExpandedState().iterator();
                                    Boolean bl8 = bl2;
                                    while (true) {
                                        void var1_27;
                                        void var3_45 = var1_27;
                                        if (!iterator.hasNext()) break;
                                        DynamicIslandContentView dynamicIslandContentView4 = (DynamicIslandContentView)((Object)iterator.next());
                                        if (!(((DynamicIslandWindowView)this.getView()).calculateCollapse(dynamicIslandContentView4) instanceof DynamicIslandState.BigIsland)) continue;
                                        DynamicIslandContentView dynamicIslandContentView5 = dynamicIslandContentView4;
                                    }
                                }
                                Rect rect = this.getSmallIslandRect((DynamicIslandContentView)var2_39, (DynamicIslandContentView)var3_47);
                                break block31;
                            } else {
                                Rect rect = this.getCutoutRect();
                            }
                            break block31;
                        } else {
                            Rect rect = this.getCutoutRect();
                        }
                        break block31;
                    }
                    if (!(object instanceof DynamicIslandState.Expanded)) break block35;
                    Rect rect = this.getExpandedIslandRect((DynamicIslandContentView)var2_39);
                    break block36;
                }
                Object var3_49 = var10_55;
                if (!(object instanceof DynamicIslandState.Hidden)) break block36;
                if (!((Boolean)this.windowState.getTempHidden().getValue()).booleanValue() && !this.windowState.isShowOnceIsland()) {
                    Rect rect = DynamicIslandWindowViewController.getSmallIslandRect$default(this, (DynamicIslandContentView)var2_39, null, 2, null);
                } else {
                    Rect rect = this.getCutoutRect();
                }
            }
            void var3_42 = var1_3;
        }
        void var1_36 = var3_50;
        if (var3_50 == null) {
            Rect rect = this.getCutoutRect();
        }
        return var1_38;
    }

    private final Rect getBigIslandRect(DynamicIslandContentView dynamicIslandContentView, Boolean bl) {
        dynamicIslandContentView = dynamicIslandContentView != null ? dynamicIslandContentView.getBigIslandRect(bl) : null;
        return dynamicIslandContentView;
    }

    public static /* synthetic */ Rect getBigIslandRect$default(DynamicIslandWindowViewController dynamicIslandWindowViewController, DynamicIslandContentView dynamicIslandContentView, Boolean bl, int n, Object object) {
        if ((n & 2) != 0) {
            bl = null;
        }
        return dynamicIslandWindowViewController.getBigIslandRect(dynamicIslandContentView, bl);
    }

    private final Rect getCutoutRect() {
        return ((DynamicIslandWindowView)this.getView()).getCutoutRect();
    }

    public static /* synthetic */ void getCutoutY$annotations() {
    }

    private final Rect getExpandedIslandRect(DynamicIslandContentView dynamicIslandContentView) {
        dynamicIslandContentView = dynamicIslandContentView != null ? dynamicIslandContentView.getExpandedIslandRect() : null;
        return dynamicIslandContentView;
    }

    private final DynamicIslandExternalStateRepository getExternalStateRepository() {
        return (DynamicIslandExternalStateRepository)this.externalStateRepository$delegate.getValue();
    }

    private final DynamicIslandExternalTouchInteractor getExternalTouchHandler() {
        return (DynamicIslandExternalTouchInteractor)this.externalTouchHandler$delegate.getValue();
    }

    private final Rect getFakeExpandedViewRect(DynamicIslandContentView dynamicIslandBaseContentView) {
        dynamicIslandBaseContentView = (dynamicIslandBaseContentView = dynamicIslandBaseContentView.getFakeView()) != null ? ((DynamicIslandContentFakeView)dynamicIslandBaseContentView).getExpandedIslandRect() : null;
        return dynamicIslandBaseContentView;
    }

    public static /* synthetic */ void getIslandMaxWidth$annotations() {
    }

    private final NotificationChronometerManager getNotificationChronometerManager() {
        return (NotificationChronometerManager)this.notificationChronometerManager$delegate.getValue();
    }

    private final Rect getSmallIslandRect(DynamicIslandContentView dynamicIslandContentView, DynamicIslandContentView dynamicIslandContentView2) {
        int n = this.getSmallIslandX(dynamicIslandContentView2);
        dynamicIslandContentView = dynamicIslandContentView != null ? dynamicIslandContentView.getSmallIslandRect(n) : null;
        return dynamicIslandContentView;
    }

    public static /* synthetic */ Rect getSmallIslandRect$default(DynamicIslandWindowViewController dynamicIslandWindowViewController, DynamicIslandContentView dynamicIslandContentView, DynamicIslandContentView dynamicIslandContentView2, int n, Object object) {
        if ((n & 2) != 0) {
            dynamicIslandContentView2 = null;
        }
        return dynamicIslandWindowViewController.getSmallIslandRect(dynamicIslandContentView, dynamicIslandContentView2);
    }

    private final int getSmallIslandX(DynamicIslandContentView dynamicIslandContentView) {
        DynamicIslandContentView dynamicIslandContentView2 = dynamicIslandContentView;
        if (dynamicIslandContentView == null) {
            dynamicIslandContentView2 = ((DynamicIslandWindowView)this.getView()).getCurrentBigIslandState();
        }
        if (dynamicIslandContentView2 != null && (dynamicIslandContentView = dynamicIslandContentView2.getContext()) != null && CommonUtils.isLayoutRtl((Context)dynamicIslandContentView)) {
            int n = dynamicIslandContentView2.getCurrentBigIslandX(Boolean.TRUE);
            int n2 = dynamicIslandContentView2.getSmallIslandViewWidth();
            this.appAnimSmallX = n2 = n - dynamicIslandContentView2.getSpace() - n2;
            return n2;
        }
        int n = 0;
        int n3 = dynamicIslandContentView2 != null ? dynamicIslandContentView2.getCurrentBigIslandX(Boolean.TRUE) : 0;
        int n4 = dynamicIslandContentView2 != null ? dynamicIslandContentView2.getCurrentBigIslandWidth(Boolean.TRUE) : 0;
        if (dynamicIslandContentView2 != null) {
            n = dynamicIslandContentView2.getSpace();
        }
        this.appAnimSmallX = n3 = n3 + n4 + n;
        return n3;
    }

    public static /* synthetic */ int getSmallIslandX$default(DynamicIslandWindowViewController dynamicIslandWindowViewController, DynamicIslandContentView dynamicIslandContentView, int n, Object object) {
        if ((n & 1) != 0) {
            dynamicIslandContentView = null;
        }
        return dynamicIslandWindowViewController.getSmallIslandX(dynamicIslandContentView);
    }

    private final void handleMiPlayShowState(boolean bl) {
        this.notificationMiPlayShow(bl);
        this.getExternalStateRepository().notifyMiPlayShowStateChanged(bl);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("miPlayShowStateChangedBroadcastReceiver: miplayShowState ");
        stringBuilder.append(bl);
        Log.d((String)TAG, (String)stringBuilder.toString());
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private final boolean hasAppState(String string) {
        boolean bl;
        boolean bl2 = true;
        if (string != null) {
            Object object = ((DynamicIslandWindowView)this.getView()).getMainAppExpanded();
            Object var5_4 = null;
            object = object != null ? object.getPkgName() : null;
            bl = bl2;
            if (o.c((Object)object, (Object)string)) return bl;
            DynamicIslandContentView dynamicIslandContentView = ((DynamicIslandWindowView)this.getView()).getSubAppExpanded();
            object = var5_4;
            if (dynamicIslandContentView != null) {
                object = dynamicIslandContentView.getPkgName();
            }
            if (!o.c((Object)object, (Object)string)) return false;
            return bl2;
        }
        bl = bl2;
        if (((DynamicIslandWindowView)this.getView()).getMainAppExpanded() != null) return bl;
        if (((DynamicIslandWindowView)this.getView()).getSubAppExpanded() == null) return false;
        return bl2;
    }

    private final boolean hasMiniWindowState(String string) {
        boolean bl;
        block2: {
            block3: {
                boolean bl2;
                bl = bl2 = false;
                if (string == null) break block2;
                if (((DynamicIslandWindowView)this.getView()).getMainMiniWindow(string) != null) break block3;
                bl = bl2;
                if (((DynamicIslandWindowView)this.getView()).getSubMiniWindow(string) == null) break block2;
            }
            bl = true;
        }
        return bl;
    }

    private final void lockScreen(boolean bl) {
        Object object = this.windowState;
        boolean bl2 = true;
        boolean bl3 = ((DynamicIslandWindowState)object).isTempHidden(1);
        this.windowState.setTempHiddenType(DynamicIslandWindowState.TempHiddenType.SCREEN_LOCKED);
        object = this.windowState;
        if ((Boolean)((DynamicIslandWindowState)object).getScreenLocked().getValue() == bl) {
            bl2 = false;
        }
        ((DynamicIslandWindowState)object).setScreenLockedChange(bl2);
        this.windowState.getScreenLocked().setValue((Object)bl);
        this.windowState.setFullAodOn(this.isFullAodOn);
        this.windowState.setAodOn(this.isAodOn);
        bl2 = this.windowState.getScreenLockedChange();
        object = new StringBuilder();
        ((StringBuilder)object).append("lockScreen: screenLockedChange:");
        ((StringBuilder)object).append(bl2);
        ((StringBuilder)object).append(", lockScreen ");
        ((StringBuilder)object).append(bl);
        Log.d((String)TAG, (String)((StringBuilder)object).toString());
        if (bl) {
            if (bl3) {
                ((DynamicIslandWindowView)this.getView()).collapse("lockscreen");
            }
            ((DynamicIslandWindowView)this.getView()).hideAllElementSurface();
            ((DynamicIslandWindowView)this.getView()).resetHeadsUpLocation();
            this.removeInvalidChildView();
        }
    }

    private final boolean needExitMiniWindow(boolean bl, String string) {
        block3: {
            block2: {
                boolean bl2 = false;
                boolean bl3 = string != null && ((DynamicIslandWindowView)this.getView()).getMainMiniWindow(string) == null && ((DynamicIslandWindowView)this.getView()).getSubMiniWindow(string) != null;
                if (!bl && this.isNotSupportFreeFormAnim()) break block2;
                bl = bl2;
                if (!bl3) break block3;
            }
            bl = true;
        }
        return bl;
    }

    private final void notificationAppearance(boolean bl) {
        ((AvoidScreenBurnInHelper)this.avoidScreenBurnInHelper.get()).updateNotificationPanelExpanded(bl);
        this.windowState.setTempHiddenType(DynamicIslandWindowState.TempHiddenType.NOTIFICATION_APPEARANCE);
        this.windowState.getNotificationAppearance().setValue((Object)bl);
    }

    private final void notificationMiPlayShow(boolean bl) {
        this.windowState.setTempHiddenType(DynamicIslandWindowState.TempHiddenType.MIPLAY_SHOW);
        this.windowState.getMiPlayShow().setValue((Object)bl);
    }

    private final void notificationVisible(boolean bl) {
        this.windowState.setNotificationVisible(bl);
    }

    private final void onConfigurationChanged(Configuration configuration) {
        Configuration configuration2;
        this.updateWindowState();
        if (configuration == null) {
            return;
        }
        ConfigUtils configUtils = ConfigUtils.INSTANCE;
        Configuration configuration3 = configuration2 = this.configuration;
        if (configuration2 == null) {
            o.w((String)"configuration");
            configuration3 = null;
        }
        configUtils.update(configuration3, configuration);
        ((DynamicIslandWindowView)this.getView()).onConfigChanged(configuration);
    }

    private final void onTopActivityChange(ComponentName object3, boolean bl, boolean bl2, boolean bl3, boolean bl4) {
        Object object22 = this.fullScreenPkg.getValue();
        Comparable<StringBuilder> comparable = new StringBuilder();
        comparable.append("onTopActivityChange: topActivity ");
        comparable.append(object3);
        comparable.append(", inSmallWindow ");
        comparable.append(bl);
        comparable.append(", isSupportPip ");
        comparable.append(bl2);
        comparable.append(", isFocus ");
        comparable.append(bl3);
        comparable.append(" fullScreenPkg ");
        comparable.append(object22);
        Log.d((String)TAG, (String)comparable.toString());
        comparable = bl;
        object3 = object3 != null ? object3.getPackageName() : null;
        bl2 = o.c((Object)this.dynamicIslandSafeguardsController.getFullScreenPkg(), (Object)this.fullScreenPkg.getValue());
        this.dynamicIslandSafeguardsController.setFullScreenPkg((String)this.fullScreenPkg.getValue());
        if (!(o.c((Object)object3, (Object)this.topActivityPkg) && bl2 && o.c((Object)comparable, this.inSmallWindowMap.get(object3)))) {
            int n;
            int n2;
            DynamicIslandContentView dynamicIslandContentView;
            this.lastTopActivityPkg = object22 = this.topActivityPkg;
            Boolean bl5 = (Boolean)this.inSmallWindowMap.get(object22);
            this.topActivityPkg = object3;
            this.windowState.setTopActivityPkg((String)object3);
            this.inSmallWindowMap.clear();
            object3 = this.topActivityPkg;
            if (object3 != null) {
                object3 = this.inSmallWindowMap.put((String)object3, o.c((Object)comparable, (Object)Boolean.TRUE));
            }
            if (CommonUtils.INSTANCE.getIS_TABLET()) {
                this.windowState.getKidSpaceShow().setValue((Object)o.c((Object)this.topActivityPkg, (Object)"com.xiaomi.kidspace"));
            }
            object3 = (dynamicIslandContentView = ((DynamicIslandWindowView)this.getView()).getCurrentExpandedState()) != null && (object3 = dynamicIslandContentView.getFakeView()) != null ? Boolean.valueOf(object3.getOpenAppFromIsland()) : null;
            object22 = dynamicIslandContentView != null ? Boolean.valueOf(dynamicIslandContentView.getOpenAppFromIsland()) : null;
            bl = this.requestPosition;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("openAppFromIsland: ");
            stringBuilder.append((Object)dynamicIslandContentView);
            stringBuilder.append(", ");
            stringBuilder.append(object3);
            stringBuilder.append(", ");
            stringBuilder.append(object22);
            stringBuilder.append(" ");
            stringBuilder.append(bl);
            Log.d((String)TAG, (String)stringBuilder.toString());
            this.cancelDelayOperate(this.topActivityPkg);
            this.shouldDelayExitApp = false;
            object3 = new StringBuilder();
            object3.append("lastTopActivityIsSmallWindow ");
            object3.append(bl5);
            Log.d((String)TAG, (String)object3.toString());
            if (o.c((Object)bl5, (Object)Boolean.TRUE)) {
                f.b((f1.E)this.uiScope, null, null, (U0.o)new U0.o(this, null){
                    int label;
                    final DynamicIslandWindowViewController this$0;
                    {
                        this.this$0 = dynamicIslandWindowViewController;
                        super(2, d2);
                    }

                    public final K0.d create(Object object, K0.d d2) {
                        return new /* invalid duplicate definition of identical inner class */;
                    }

                    public final Object invoke(f1.E e2, K0.d d2) {
                        return (this.create(e2, d2)).invokeSuspend(s.a);
                    }

                    public final Object invokeSuspend(Object object) {
                        c.c();
                        if (this.label == 0) {
                            k.b((Object)object);
                            object = this.this$0;
                            boolean bl = ((DynamicIslandWindowViewController)object).isInMiniWindow(((DynamicIslandWindowViewController)object).getLastTopActivityPkg(), b.c((int)DynamicIslandWindowViewController.access$getView(this.this$0).getCurrentUserId()));
                            object = new StringBuilder();
                            ((StringBuilder)object).append("isInMiniWindow ");
                            ((StringBuilder)object).append(bl);
                            Log.d((String)"DynamicIslandWindowViewController", (String)((StringBuilder)object).toString());
                            object = this.this$0;
                            if (DynamicIslandWindowViewController.access$needExitMiniWindow((DynamicIslandWindowViewController)object, bl, ((DynamicIslandWindowViewController)object).getLastTopActivityPkg())) {
                                object = this.this$0;
                                ((DynamicIslandWindowViewController)object).calculateAppClosePosition(((DynamicIslandWindowViewController)object).getLastTopActivityPkg(), true);
                                object = this.this$0.getLastTopActivityPkg();
                                if (object != null) {
                                    DynamicIslandSafeguardsController.delayExitMiniWindow$default(this.this$0.getDynamicIslandSafeguardsController(), (String)object, false, 2, null);
                                }
                            }
                            return s.a;
                        }
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                }, (int)3, null);
            } else if (!o.c((Object)this.lastTopActivityPkg, (Object)this.fullScreenPkg.getValue()) || !bl2) {
                if (!this.requestPosition) {
                    DynamicIslandSafeguardsController.delayExitApp$default(this.dynamicIslandSafeguardsController, this.topActivityPkg, false, 2, null);
                    this.shouldDelayExitApp = false;
                } else {
                    this.shouldDelayExitApp = this.requestPositionByClosePosition;
                }
            }
            if (dynamicIslandContentView != null && (object3 = dynamicIslandContentView.getFakeView()) != null && object3.getOpenAppFromIsland() || dynamicIslandContentView != null && dynamicIslandContentView.getOpenAppFromIsland()) {
                return;
            }
            if (!o.c((Object)this.topActivityPkg, (Object)this.fullScreenPkg.getValue()) && (object3 = ((DynamicIslandWindowView)this.getView()).requestHasIsland((String)this.fullScreenPkg.getValue())) != null && object3.isEmpty() ^ true) {
                n2 = object3.size();
                for (n = 0; n < n2; ++n) {
                    object3 = this.fullScreenPkg;
                    object3 = ((DynamicIslandWindowView)this.getView()).requestHasIsland((String)object3.getValue());
                    if (object3 == null) continue;
                    for (Object object3 : object3) {
                        if (!this.canEnterAppState((DynamicIslandContentView)((Object)object3))) continue;
                        this.dynamicIslandSafeguardsController.delayEnterApp((DynamicIslandContentView)((Object)object3), true);
                    }
                }
            }
            if ((object3 = (object3 = this.topActivityPkg) != null ? ((DynamicIslandWindowView)this.getView()).requestHasIsland((String)object3) : null) != null && object3.isEmpty() ^ true) {
                n2 = object3.size();
                for (n = 0; n < n2; ++n) {
                    object3 = this.topActivityPkg;
                    object3 = object3 != null ? ((DynamicIslandWindowView)this.getView()).requestHasIsland((String)object3) : null;
                    if (object3 != null) {
                        for (Object object22 : object3) {
                            if (o.c((Object)comparable, (Object)Boolean.TRUE)) {
                                if (u.F(this.pinOperateList, (Object)this.topActivityPkg) || (object22 = object22 != null && (object22 = ((DynamicIslandBaseContentView)((Object)object22)).getCurrentIslandData()) != null && (object22 = object22.getExtras()) != null ? object22.getString("miui.pkg.name") : null) == null) continue;
                                this.dynamicIslandSafeguardsController.delayEnterMiniWidow((String)object22);
                                continue;
                            }
                            if (!this.canEnterAppState((DynamicIslandContentView)((Object)object22))) continue;
                            this.dynamicIslandSafeguardsController.delayEnterApp((DynamicIslandContentView)((Object)object22), bl4);
                            DynamicIslandWindowViewController.setPositionValue$default(this, false, false, 2, null);
                        }
                    }
                    if (!o.c((Object)comparable, (Object)Boolean.TRUE)) continue;
                    object22 = this.pinOperateList;
                    object3 = object3 != null && (object3 = (DynamicIslandContentView)((Object)object3.get(n))) != null && (object3 = object3.getCurrentIslandData()) != null ? object3.getKey() : null;
                    E.a((Object)object22).remove(object3);
                }
            }
        }
    }

    public static /* synthetic */ void onTopActivityChange$default(DynamicIslandWindowViewController dynamicIslandWindowViewController, ComponentName componentName, boolean bl, boolean bl2, boolean bl3, boolean bl4, int n, Object object) {
        if ((n & 0x10) != 0) {
            bl4 = false;
        }
        dynamicIslandWindowViewController.onTopActivityChange(componentName, bl, bl2, bl3, bl4);
    }

    private final void openAppError(boolean bl, String string, boolean bl2) {
        f.b((f1.E)this.uiScope, null, null, (U0.o)new U0.o(string, bl2, this, bl, null){
            final boolean $collapse;
            final boolean $freeform;
            final String $pkg;
            int label;
            final DynamicIslandWindowViewController this$0;
            {
                this.$pkg = string;
                this.$collapse = bl;
                this.this$0 = dynamicIslandWindowViewController;
                this.$freeform = bl2;
                super(2, d2);
            }

            public final K0.d create(Object object, K0.d d2) {
                return new /* invalid duplicate definition of identical inner class */;
            }

            public final Object invoke(f1.E e2, K0.d d2) {
                return (this.create(e2, d2)).invokeSuspend(s.a);
            }

            public final Object invokeSuspend(Object object) {
                c.c();
                if (this.label == 0) {
                    Object object2;
                    k.b((Object)object);
                    object = this.$pkg;
                    if (object != null && (object2 = DynamicIslandWindowViewController.access$getView(this.this$0).requestHasIsland((String)object)) != null) {
                        boolean bl = this.$freeform;
                        object = this.this$0;
                        Iterator<T> iterator = object2.iterator();
                        while (iterator.hasNext()) {
                            object2 = (DynamicIslandContentView)((Object)iterator.next());
                            if (bl) {
                                DynamicIslandWindowViewController.access$getView((DynamicIslandWindowViewController)object).cancelExpandViewTrackingAnim((DynamicIslandContentView)((Object)object2));
                                DynamicIslandWindowViewController.access$getView((DynamicIslandWindowViewController)object).updateViewStateWhenCloseEnd((DynamicIslandContentView)((Object)object2), true, "open_app_error");
                                continue;
                            }
                            if (object2 == null) continue;
                            ((DynamicIslandBaseContentView)((Object)object2)).setOpenAppFromIsland(false);
                        }
                    }
                    if (!((Boolean)(object = b.a((boolean)this.$collapse))).booleanValue()) {
                        object = null;
                    }
                    if (object != null) {
                        DynamicIslandWindowViewController.access$getView(this.this$0).collapse("open error");
                    }
                    return s.a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }, (int)3, null);
    }

    public static /* synthetic */ void openAppError$default(DynamicIslandWindowViewController dynamicIslandWindowViewController, boolean bl, String string, boolean bl2, int n, Object object) {
        if ((n & 4) != 0) {
            bl2 = false;
        }
        dynamicIslandWindowViewController.openAppError(bl, string, bl2);
    }

    private final void openAppTimeout(String object, boolean bl) {
        Object object2;
        if (object != null && (object2 = ((DynamicIslandWindowView)this.getView()).requestHasIsland((String)object)) != null) {
            if (object2.isEmpty()) {
                return;
            }
            boolean bl2 = this.isInMiniWindow((String)object, ((DynamicIslandWindowView)this.getView()).getCurrentUserId());
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("openAppTimeout: pkg = ");
            stringBuilder.append((String)object);
            stringBuilder.append("  animating = ");
            stringBuilder.append(bl);
            stringBuilder.append("  isInMiniWindow = ");
            stringBuilder.append(bl2);
            Log.d((String)TAG, (String)stringBuilder.toString());
            object2 = object2.iterator();
            while (object2.hasNext()) {
                object = (DynamicIslandContentView)((Object)object2.next());
                if (object == null) continue;
                if (!bl && bl2 && !(((DynamicIslandBaseContentView)((Object)object)).getState() instanceof DynamicIslandState.MiniWindowExpanded) && !(((DynamicIslandBaseContentView)((Object)object)).getState() instanceof DynamicIslandState.SubMiniWindowExpanded)) {
                    ((DynamicIslandWindowView)this.getView()).enterMiniWindow((DynamicIslandContentView)((Object)object));
                    continue;
                }
                ((DynamicIslandWindowView)this.getView()).cancelExpandViewTrackingAnim((DynamicIslandContentView)((Object)object));
                ((DynamicIslandWindowView)this.getView()).updateViewStateWhenCloseEnd((DynamicIslandContentView)((Object)object), true, OPEN_APP_ERROR);
            }
        }
    }

    private final void registerTempHiddenChanged() {
        f.b((f1.E)this.uiScopeImmediate, null, null, (U0.o)new U0.o(this, null){
            int label;
            final DynamicIslandWindowViewController this$0;
            {
                this.this$0 = dynamicIslandWindowViewController;
                super(2, d2);
            }

            public final K0.d create(Object object, K0.d d2) {
                return new /* invalid duplicate definition of identical inner class */;
            }

            public final Object invoke(f1.E e2, K0.d d2) {
                return (this.create(e2, d2)).invokeSuspend(s.a);
            }

            public final Object invokeSuspend(Object g2) {
                Object object = c.c();
                int n = this.label;
                if (n != 0) {
                    if (n != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    k.b((Object)g2);
                } else {
                    k.b((Object)g2);
                    I i2 = this.this$0.getWindowState().getLockScreenControlCenterCollapse();
                    g2 = new g(this.this$0){
                        final DynamicIslandWindowViewController this$0;
                        {
                            this.this$0 = dynamicIslandWindowViewController;
                        }

                        public final Object emit(boolean bl, K0.d object) {
                            object = new StringBuilder();
                            ((StringBuilder)object).append("lockScreenControlCenterCollapse:");
                            ((StringBuilder)object).append(bl);
                            Log.e((String)"DynamicIslandWindowViewController", (String)((StringBuilder)object).toString());
                            if (CommonUtils.INSTANCE.getIS_TABLET() && bl) {
                                DynamicIslandWindowViewController.access$getView(this.this$0).onIslandTempHide(true, this.this$0.getWindowState().getTempHiddenType());
                            }
                            return s.a;
                        }
                    };
                    this.label = 1;
                    if (i2.collect(g2, (K0.d)this) == object) {
                        return object;
                    }
                }
                throw new G0.c();
            }
        }, (int)3, null);
        f.b((f1.E)this.uiScopeImmediate, null, null, (U0.o)new U0.o(this, null){
            int label;
            final DynamicIslandWindowViewController this$0;
            {
                this.this$0 = dynamicIslandWindowViewController;
                super(2, d2);
            }

            public final K0.d create(Object object, K0.d d2) {
                return new /* invalid duplicate definition of identical inner class */;
            }

            public final Object invoke(f1.E e2, K0.d d2) {
                return (this.create(e2, d2)).invokeSuspend(s.a);
            }

            public final Object invokeSuspend(Object g2) {
                Object object = c.c();
                int n = this.label;
                if (n != 0) {
                    if (n != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    k.b((Object)g2);
                } else {
                    k.b((Object)g2);
                    i1.u u2 = this.this$0.getWindowState().getMiPlayShow();
                    g2 = new g(this.this$0){
                        final DynamicIslandWindowViewController this$0;
                        {
                            this.this$0 = dynamicIslandWindowViewController;
                        }

                        public final Object emit(boolean bl, K0.d object) {
                            DynamicIslandWindowState.TempHiddenType tempHiddenType = this.this$0.getWindowState().getTempHiddenType();
                            object = new StringBuilder();
                            ((StringBuilder)object).append("collect miPlayShow:");
                            ((StringBuilder)object).append(bl);
                            ((StringBuilder)object).append(" ");
                            ((StringBuilder)object).append((Object)((Object)tempHiddenType));
                            Log.e((String)"DynamicIslandWindowViewController", (String)((StringBuilder)object).toString());
                            this.this$0.getWindowState().setTempHiddenChange(b.a((boolean)true));
                            DynamicIslandWindowViewController.access$getView(this.this$0).onIslandTempHide(bl, this.this$0.getWindowState().getTempHiddenType());
                            return s.a;
                        }
                    };
                    this.label = 1;
                    if (u2.collect(g2, (K0.d)this) == object) {
                        return object;
                    }
                }
                throw new G0.c();
            }
        }, (int)3, null);
        f.b((f1.E)this.uiScopeImmediate, null, null, (U0.o)new U0.o(this, null){
            int label;
            final DynamicIslandWindowViewController this$0;
            {
                this.this$0 = dynamicIslandWindowViewController;
                super(2, d2);
            }

            public final K0.d create(Object object, K0.d d2) {
                return new /* invalid duplicate definition of identical inner class */;
            }

            public final Object invoke(f1.E e2, K0.d d2) {
                return (this.create(e2, d2)).invokeSuspend(s.a);
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
                    object = this.this$0.getWindowState().getScreenLocked();
                    g g2 = new g(this.this$0){
                        final DynamicIslandWindowViewController this$0;
                        {
                            this.this$0 = dynamicIslandWindowViewController;
                        }

                        public final Object emit(boolean bl, K0.d object) {
                            this.this$0.getWindowState().isTempHidden(b.c((int)1));
                            object = this.this$0.getWindowState().getTempHiddenType();
                            StringBuilder stringBuilder = new StringBuilder();
                            stringBuilder.append("collect screenLocked:");
                            stringBuilder.append(bl);
                            stringBuilder.append(" ");
                            stringBuilder.append(object);
                            Log.e((String)"DynamicIslandWindowViewController", (String)stringBuilder.toString());
                            if (CommonUtils.INSTANCE.getIS_TABLET()) {
                                this.this$0.getWindowState().setTempHiddenChange(b.a((boolean)true));
                                DynamicIslandWindowViewController.access$getView(this.this$0).onIslandTempHide(bl, this.this$0.getWindowState().getTempHiddenType());
                            }
                            return s.a;
                        }
                    };
                    this.label = 1;
                    if (object.collect(g2, (K0.d)this) == object2) {
                        return object2;
                    }
                }
                throw new G0.c();
            }
        }, (int)3, null);
        f.b((f1.E)this.uiScopeImmediate, null, null, (U0.o)new U0.o(this, null){
            int label;
            final DynamicIslandWindowViewController this$0;
            {
                this.this$0 = dynamicIslandWindowViewController;
                super(2, d2);
            }

            public final K0.d create(Object object, K0.d d2) {
                return new /* invalid duplicate definition of identical inner class */;
            }

            public final Object invoke(f1.E e2, K0.d d2) {
                return (this.create(e2, d2)).invokeSuspend(s.a);
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
                    object = this.this$0.getWindowState().getTempHidden();
                    g g2 = new g(this.this$0){
                        final DynamicIslandWindowViewController this$0;
                        {
                            this.this$0 = dynamicIslandWindowViewController;
                        }

                        public final Object emit(boolean bl, K0.d object) {
                            DynamicIslandWindowState.TempHiddenType tempHiddenType = this.this$0.getWindowState().getTempHiddenType();
                            object = new StringBuilder();
                            ((StringBuilder)object).append("collect tempHidden:");
                            ((StringBuilder)object).append(bl);
                            ((StringBuilder)object).append(" ");
                            ((StringBuilder)object).append((Object)((Object)tempHiddenType));
                            Log.e((String)"DynamicIslandWindowViewController", (String)((StringBuilder)object).toString());
                            this.this$0.getWindowState().setTempHiddenChange(b.a((boolean)true));
                            DynamicIslandWindowViewController.access$getView(this.this$0).onIslandTempHide(bl, this.this$0.getWindowState().getTempHiddenType());
                            return s.a;
                        }
                    };
                    this.label = 1;
                    if (object.collect(g2, (K0.d)this) == object2) {
                        return object2;
                    }
                }
                throw new G0.c();
            }
        }, (int)3, null);
        f.b((f1.E)this.uiScopeImmediate, null, null, (U0.o)new U0.o(this, null){
            int label;
            final DynamicIslandWindowViewController this$0;
            {
                this.this$0 = dynamicIslandWindowViewController;
                super(2, d2);
            }

            public final K0.d create(Object object, K0.d d2) {
                return new /* invalid duplicate definition of identical inner class */;
            }

            public final Object invoke(f1.E e2, K0.d d2) {
                return (this.create(e2, d2)).invokeSuspend(s.a);
            }

            public final Object invokeSuspend(Object g2) {
                Object object = c.c();
                int n = this.label;
                if (n != 0) {
                    if (n != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    k.b((Object)g2);
                } else {
                    k.b((Object)g2);
                    i1.u u2 = this.this$0.getWindowState().getStatusBarViewShowing();
                    g2 = new g(this.this$0){
                        final DynamicIslandWindowViewController this$0;
                        {
                            this.this$0 = dynamicIslandWindowViewController;
                        }

                        public final Object emit(boolean bl, K0.d d2) {
                            this.this$0.getWindowState().setTempHiddenChange(b.a((boolean)true));
                            DynamicIslandWindowViewController.access$getView(this.this$0).onIslandTempHide((Boolean)this.this$0.getWindowState().getTempHidden().getValue(), this.this$0.getWindowState().getTempHiddenType());
                            return s.a;
                        }
                    };
                    this.label = 1;
                    if (u2.collect(g2, (K0.d)this) == object) {
                        return object;
                    }
                }
                throw new G0.c();
            }
        }, (int)3, null);
        f.b((f1.E)this.uiScopeImmediate, null, null, (U0.o)new U0.o(this, null){
            int label;
            final DynamicIslandWindowViewController this$0;
            {
                this.this$0 = dynamicIslandWindowViewController;
                super(2, d2);
            }

            public final K0.d create(Object object, K0.d d2) {
                return new /* invalid duplicate definition of identical inner class */;
            }

            public final Object invoke(f1.E e2, K0.d d2) {
                return (this.create(e2, d2)).invokeSuspend(s.a);
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
                    object = this.this$0.getWindowState().getScreenPinning();
                    g g2 = new g(this.this$0){
                        final DynamicIslandWindowViewController this$0;
                        {
                            this.this$0 = dynamicIslandWindowViewController;
                        }

                        public final Object emit(boolean bl, K0.d object) {
                            object = new StringBuilder();
                            ((StringBuilder)object).append("collect screenPinning:");
                            ((StringBuilder)object).append(bl);
                            Log.e((String)"DynamicIslandWindowViewController", (String)((StringBuilder)object).toString());
                            this.this$0.getWindowState().setTempHiddenChange(b.a((boolean)false));
                            DynamicIslandWindowViewController.access$getView(this.this$0).onIslandTempHide((Boolean)this.this$0.getWindowState().getTempHidden().getValue(), this.this$0.getWindowState().getTempHiddenType());
                            return s.a;
                        }
                    };
                    this.label = 1;
                    if (object.collect(g2, (K0.d)this) == object2) {
                        return object2;
                    }
                }
                throw new G0.c();
            }
        }, (int)3, null);
        f.b((f1.E)this.uiScopeImmediate, null, null, (U0.o)new U0.o(this, null){
            int label;
            final DynamicIslandWindowViewController this$0;
            {
                this.this$0 = dynamicIslandWindowViewController;
                super(2, d2);
            }

            public final K0.d create(Object object, K0.d d2) {
                return new /* invalid duplicate definition of identical inner class */;
            }

            public final Object invoke(f1.E e2, K0.d d2) {
                return (this.create(e2, d2)).invokeSuspend(s.a);
            }

            public final Object invokeSuspend(Object g2) {
                Object object = c.c();
                int n = this.label;
                if (n != 0) {
                    if (n != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    k.b((Object)g2);
                } else {
                    k.b((Object)g2);
                    i1.u u2 = this.this$0.getWindowState().getBouncerShowing();
                    g2 = new g(this.this$0){
                        final DynamicIslandWindowViewController this$0;
                        {
                            this.this$0 = dynamicIslandWindowViewController;
                        }

                        public final Object emit(boolean bl, K0.d object) {
                            object = new StringBuilder();
                            ((StringBuilder)object).append("collect bouncerShowing:");
                            ((StringBuilder)object).append(bl);
                            Log.e((String)"DynamicIslandWindowViewController", (String)((StringBuilder)object).toString());
                            this.this$0.getWindowState().setTempHiddenChange(b.a((boolean)true));
                            DynamicIslandWindowViewController.access$getView(this.this$0).onIslandTempHide((Boolean)this.this$0.getWindowState().getTempHidden().getValue(), this.this$0.getWindowState().getTempHiddenType());
                            return s.a;
                        }
                    };
                    this.label = 1;
                    if (u2.collect(g2, (K0.d)this) == object) {
                        return object;
                    }
                }
                throw new G0.c();
            }
        }, (int)3, null);
        f.b((f1.E)this.uiScopeImmediate, null, null, (U0.o)new U0.o(this, null){
            int label;
            final DynamicIslandWindowViewController this$0;
            {
                this.this$0 = dynamicIslandWindowViewController;
                super(2, d2);
            }

            public final K0.d create(Object object, K0.d d2) {
                return new /* invalid duplicate definition of identical inner class */;
            }

            public final Object invoke(f1.E e2, K0.d d2) {
                return (this.create(e2, d2)).invokeSuspend(s.a);
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
                    object = DynamicIslandWindowViewController.access$getExternalStateRepository(this.this$0).isDeviceInteractive();
                    g g2 = new g(this.this$0){
                        final DynamicIslandWindowViewController this$0;
                        {
                            this.this$0 = dynamicIslandWindowViewController;
                        }

                        public final Object emit(boolean bl, K0.d object) {
                            object = this.this$0.getWindowState().getTempHidden().getValue();
                            StringBuilder stringBuilder = new StringBuilder();
                            stringBuilder.append("collect isDeviceInteractive:");
                            stringBuilder.append(bl);
                            stringBuilder.append(", windowState.tempHidden.value=");
                            stringBuilder.append(object);
                            Log.d((String)"DynamicIslandWindowViewController", (String)stringBuilder.toString());
                            object = this.this$0;
                            DynamicIslandWindowViewController.access$lockScreen((DynamicIslandWindowViewController)object, (Boolean)((DynamicIslandWindowViewController)object).getWindowState().getScreenLocked().getValue());
                            this.this$0.getWindowState().setDeviceInteractive(bl);
                            if (bl) {
                                DynamicIslandWindowViewController.access$getDynamicIslandDesktopStateController$p(this.this$0).getMiniWindowDataRepo().resetData();
                            }
                            return s.a;
                        }
                    };
                    this.label = 1;
                    if (object.collect(g2, (K0.d)this) == object2) {
                        return object2;
                    }
                }
                throw new G0.c();
            }
        }, (int)3, null);
        f.b((f1.E)this.uiScopeImmediate, null, null, (U0.o)new U0.o(this, null){
            int label;
            final DynamicIslandWindowViewController this$0;
            {
                this.this$0 = dynamicIslandWindowViewController;
                super(2, d2);
            }

            public final K0.d create(Object object, K0.d d2) {
                return new /* invalid duplicate definition of identical inner class */;
            }

            public final Object invoke(f1.E e2, K0.d d2) {
                return (this.create(e2, d2)).invokeSuspend(s.a);
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
                    object = DynamicIslandWindowViewController.access$getExternalStateRepository(this.this$0).isKeyguardShowing();
                    g g2 = new g(this.this$0){
                        final DynamicIslandWindowViewController this$0;
                        {
                            this.this$0 = dynamicIslandWindowViewController;
                        }

                        public final Object emit(boolean bl, K0.d object) {
                            Object object2 = this.this$0.getWindowState().getTempHidden().getValue();
                            object = new StringBuilder();
                            ((StringBuilder)object).append("collect isKeyguardShowing:");
                            ((StringBuilder)object).append(bl);
                            ((StringBuilder)object).append(", windowState.tempHidden.value=");
                            ((StringBuilder)object).append(object2);
                            Log.d((String)"DynamicIslandWindowViewController", (String)((StringBuilder)object).toString());
                            this.this$0.getWindowState().setKeyguardShowing(bl);
                            DynamicIslandWindowViewController.access$lockScreen(this.this$0, bl);
                            DynamicIslandWindowViewController.access$getView(this.this$0).onKeyguardShowing(bl);
                            return s.a;
                        }
                    };
                    this.label = 1;
                    if (object.collect(g2, (K0.d)this) == object2) {
                        return object2;
                    }
                }
                throw new G0.c();
            }
        }, (int)3, null);
        f.b((f1.E)this.uiScopeImmediate, null, null, (U0.o)new U0.o(this, null){
            int label;
            final DynamicIslandWindowViewController this$0;
            {
                this.this$0 = dynamicIslandWindowViewController;
                super(2, d2);
            }

            public final K0.d create(Object object, K0.d d2) {
                return new /* invalid duplicate definition of identical inner class */;
            }

            public final Object invoke(f1.E e2, K0.d d2) {
                return (this.create(e2, d2)).invokeSuspend(s.a);
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
                    object = this.this$0.getWindowState().getKidSpaceShow();
                    g g2 = new g(this.this$0){
                        final DynamicIslandWindowViewController this$0;
                        {
                            this.this$0 = dynamicIslandWindowViewController;
                        }

                        public final Object emit(boolean bl, K0.d d2) {
                            if (CommonUtils.INSTANCE.getIS_TABLET() && bl && DynamicIslandWindowViewController.access$getView(this.this$0).getCurrentExpandedState() != null) {
                                DynamicIslandWindowViewController.access$getView(this.this$0).collapse("kidspace");
                            }
                            return s.a;
                        }
                    };
                    this.label = 1;
                    if (object.collect(g2, (K0.d)this) == object2) {
                        return object2;
                    }
                }
                throw new G0.c();
            }
        }, (int)3, null);
        f.b((f1.E)this.uiScopeImmediate, null, null, (U0.o)new U0.o(this, null){
            int label;
            final DynamicIslandWindowViewController this$0;
            {
                this.this$0 = dynamicIslandWindowViewController;
                super(2, d2);
            }

            public final K0.d create(Object object, K0.d d2) {
                return new /* invalid duplicate definition of identical inner class */;
            }

            public final Object invoke(f1.E e2, K0.d d2) {
                return (this.create(e2, d2)).invokeSuspend(s.a);
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
                    object = DynamicIslandWindowViewController.access$getFullScreenPkg$p(this.this$0);
                    g g2 = new g(this.this$0){
                        final DynamicIslandWindowViewController this$0;
                        {
                            this.this$0 = dynamicIslandWindowViewController;
                        }

                        public final Object emit(String string, K0.d object) {
                            DynamicIslandEventCoordinator dynamicIslandEventCoordinator = DynamicIslandWindowViewController.access$getView(this.this$0).getEventCoordinator();
                            if (dynamicIslandEventCoordinator == null) {
                                return s.a;
                            }
                            object = this.this$0;
                            Object object2 = dynamicIslandEventCoordinator.getLastFullScreenActivityPkg();
                            if (((DynamicIslandWindowViewController)object).isInMiniWindow((String)object2, b.c((int)DynamicIslandWindowViewController.access$getView((DynamicIslandWindowViewController)object).getCurrentUserId()))) {
                                Object object3 = new StringBuilder();
                                object3.append("fullscreen_to_mini_freeform state: ");
                                object3.append((String)object2);
                                Log.d((String)"DynamicIslandAnimDebug", (String)object3.toString());
                                DynamicIslandWindowViewController.access$cancelDelayOperate((DynamicIslandWindowViewController)object, (String)object2);
                                object2 = DynamicIslandWindowViewController.access$getView((DynamicIslandWindowViewController)object).requestHasIsland((String)object2);
                                if (object2 != null) {
                                    object2 = object2.iterator();
                                    while (object2.hasNext()) {
                                        object3 = (DynamicIslandContentView)((Object)object2.next());
                                        DynamicIslandWindowView.updateViewStateWhenCloseEnd$default(DynamicIslandWindowViewController.access$getView((DynamicIslandWindowViewController)object), (DynamicIslandContentView)((Object)object3), true, null, 4, null);
                                        DynamicIslandWindowViewController.access$getView((DynamicIslandWindowViewController)object).enterMiniWindow((DynamicIslandContentView)((Object)object3));
                                        DynamicIslandWindowViewController.access$getView((DynamicIslandWindowViewController)object).onWindowAnimExtendLifetimeEnd((DynamicIslandContentView)((Object)object3));
                                    }
                                }
                            }
                            dynamicIslandEventCoordinator.setLastFullScreenActivityPkg(string);
                            object = dynamicIslandEventCoordinator.getExpandedStateHandler().getCurrent();
                            if (object != null) {
                                if (!((DynamicIslandBaseContentView)((Object)object)).getHideByFullScreenPkg()) {
                                    object = null;
                                }
                                if (object != null) {
                                    object2 = new StringBuilder();
                                    ((StringBuilder)object2).append("refresh miniBar by fullScreen pkg = ");
                                    ((StringBuilder)object2).append(string);
                                    Log.d((String)"DynamicIslandWindowViewController", (String)((StringBuilder)object2).toString());
                                    dynamicIslandEventCoordinator.updateMiniBar((DynamicIslandContentView)((Object)object));
                                }
                            }
                            return s.a;
                        }
                    };
                    this.label = 1;
                    if (object.collect(g2, (K0.d)this) == object2) {
                        return object2;
                    }
                }
                throw new G0.c();
            }
        }, (int)3, null);
    }

    private final void removeInvalidChildView() {
        Iterator iterator = l.q((e)l.p((e)ViewGroupKt.getChildren((ViewGroup)((ViewGroup)this.getView())), (Function1)removeInvalidChildView.contentViews.1.INSTANCE), ((DynamicIslandWindowView)this.getView()).getContentViewList()).iterator();
        while (iterator.hasNext()) {
            this.removeInvalidViewFromWindow((DynamicIslandContentView)((Object)iterator.next()));
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private final void removeInvalidViewFromWindow(DynamicIslandContentView dynamicIslandContentView) {
        Exception exception2;
        block7: {
            Object object;
            Object var3_4;
            block6: {
                block5: {
                    var3_4 = null;
                    if (dynamicIslandContentView != null) {
                        try {
                            object = dynamicIslandContentView.getCurrentIslandData();
                            if (object == null) break block5;
                            object = object.getKey();
                            break block6;
                        }
                        catch (Exception exception2) {
                            break block7;
                        }
                    }
                }
                object = null;
            }
            Object object2 = new StringBuilder();
            ((StringBuilder)object2).append("removeInvalidViewFromWindow ");
            ((StringBuilder)object2).append((String)object);
            Log.d((String)TAG, (String)((StringBuilder)object2).toString());
            if (dynamicIslandContentView != null && (object = dynamicIslandContentView.getParent()) != null) {
                ((DynamicIslandWindowView)this.getView()).removeView((View)object);
            }
            object2 = (DynamicIslandWindowView)this.getView();
            object = var3_4;
            if (dynamicIslandContentView != null) {
                object = dynamicIslandContentView.getState();
            }
            ((DynamicIslandWindowView)((Object)object2)).preRemoveDynamicIsland(dynamicIslandContentView, (DynamicIslandState)object);
            return;
        }
        exception2.printStackTrace();
        s s2 = s.a;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("removeInvalidViewFromWindow error + ");
        stringBuilder.append(s2);
        Log.e((String)TAG, (String)stringBuilder.toString());
    }

    private final boolean requestMaxWidth(DynamicIslandData dynamicIslandData, boolean bl) {
        float f2 = (((DynamicIslandWindowView)this.getView()).getViewComponent().getSizeRepository().getIslandWidthParams().getValue()).getMaxWidth();
        CharSequence charSequence = new StringBuilder();
        charSequence.append("requestMaxWidth: ");
        charSequence.append(f2);
        Log.d((String)TAG, (String)charSequence.toString());
        if ((((DynamicIslandWindowView)this.getView()).getViewComponent().getSizeRepository().getIslandWidthParams().getValue()).getMaxWidth() == 0.0f) {
            this.pendingData.put(dynamicIslandData, bl);
            charSequence = dynamicIslandData.getExtras();
            Integer n = null;
            charSequence = charSequence != null ? charSequence.getString("miui.pkg.name") : null;
            Object object = dynamicIslandData.getExtras();
            if (object != null) {
                n = object.getInt("miui.user.id");
            }
            object = dynamicIslandData.getProperties();
            ((DynamicIslandWindowView)this.getView()).notifyAddIsland((String)charSequence, n, dynamicIslandData.getKey(), (Integer)object);
            return true;
        }
        return false;
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    private final Bundle sendWindowAnimEventForLinkage(String var1_1, boolean var2_2, boolean var3_3, Bundle var4_4, boolean var5_5) {
        block163: {
            var9_6 /* !! */  = var4_4 /* !! */  != null ? var4_4 /* !! */ .getString("packageName") : null;
            var11_7 /* !! */  = var4_4 /* !! */  != null ? Boolean.valueOf(var4_4 /* !! */ .getBoolean("ignore")) : null;
            var10_8 /* !! */  = var4_4 /* !! */  != null ? Float.valueOf(var4_4 /* !! */ .getFloat("value")) : null;
            var12_9 /* !! */  = new StringBuilder();
            var12_9 /* !! */ .append("sendWindowAnimEventForLinkage: ");
            var12_9 /* !! */ .append((String)var1_1);
            var12_9 /* !! */ .append(",  isFreeform: ");
            var12_9 /* !! */ .append(var2_2);
            var12_9 /* !! */ .append(", isInterrupted: ");
            var12_9 /* !! */ .append(var3_3);
            var12_9 /* !! */ .append(", packageName: ");
            var12_9 /* !! */ .append((String)var9_6 /* !! */ );
            var12_9 /* !! */ .append(", ignore: ");
            var12_9 /* !! */ .append(var11_7 /* !! */ );
            var12_9 /* !! */ .append(" ");
            Log.d((String)"DynamicIslandAnimDebug", (String)var12_9 /* !! */ .toString());
            var7_10 = var1_1.hashCode();
            var12_9 /* !! */  = " ";
            var8_11 = false;
            var6_12 = 0;
            switch (var7_10) {
                default: {
                    break block163;
                }
                case 1860576095: {
                    if (var1_1.equals("freeform_pin_enter")) {
                        f.b((f1.E)this.uiScope, null, null, (U0.o)new U0.o(this, (String)var9_6 /* !! */ , var2_2, null){
                            final boolean $isFreeform;
                            final String $pkg;
                            int label;
                            final DynamicIslandWindowViewController this$0;
                            {
                                this.this$0 = dynamicIslandWindowViewController;
                                this.$pkg = string;
                                this.$isFreeform = bl;
                                super(2, d2);
                            }

                            public final K0.d create(Object object, K0.d d2) {
                                return new /* invalid duplicate definition of identical inner class */;
                            }

                            public final Object invoke(f1.E e2, K0.d d2) {
                                return (this.create(e2, d2)).invokeSuspend(s.a);
                            }

                            public final Object invokeSuspend(Object object) {
                                c.c();
                                if (this.label == 0) {
                                    k.b((Object)object);
                                    if (!o.c((Object)DynamicIslandWindowViewController.access$getFullScreenPkg$p(this.this$0).getValue(), (Object)this.$pkg)) {
                                        object = this.$pkg;
                                        object = object != null ? DynamicIslandWindowViewController.access$getView(this.this$0).getCurrentMiniWindowState((String)object) : null;
                                        DynamicIslandWindowViewController.access$cancelDelayOperate(this.this$0, this.$pkg);
                                        if (object != null) {
                                            DynamicIslandWindowViewController dynamicIslandWindowViewController = this.this$0;
                                            String string = this.$pkg;
                                            boolean bl = this.$isFreeform;
                                            Iterator<T> iterator = object.iterator();
                                            while (iterator.hasNext()) {
                                                DynamicIslandContentView dynamicIslandContentView = (DynamicIslandContentView)((Object)iterator.next());
                                                ArrayList arrayList = DynamicIslandWindowViewController.access$getPinOperateList$p(dynamicIslandWindowViewController);
                                                object = dynamicIslandContentView.getCurrentIslandData();
                                                object = object != null ? object.getKey() : null;
                                                if (!u.F((Iterable)arrayList, (Object)object) && (object = dynamicIslandContentView.getCurrentIslandData()) != null && (object = object.getKey()) != null) {
                                                    b.a((boolean)DynamicIslandWindowViewController.access$getPinOperateList$p(dynamicIslandWindowViewController).add(object));
                                                }
                                                DynamicIslandWindowViewController.access$getAppCloseRealIslandRect(dynamicIslandWindowViewController, DynamicIslandWindowViewController.access$getView(dynamicIslandWindowViewController).calculateCollapse(dynamicIslandContentView), dynamicIslandContentView, string, bl);
                                                DynamicIslandWindowViewController.access$getView(dynamicIslandWindowViewController).exitMiniWindow(dynamicIslandContentView);
                                                object = dynamicIslandContentView.getFakeView();
                                                if (object != null) {
                                                    ((DynamicIslandBaseContentView)((Object)object)).setOpenAppFromIsland(false);
                                                }
                                                dynamicIslandContentView.setVisibility(0);
                                                object = dynamicIslandContentView.getBackgroundView();
                                                if (object == null) continue;
                                                ((DynamicIslandBackgroundView)((Object)object)).setVisibility(0);
                                            }
                                        }
                                    }
                                    return s.a;
                                }
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                        }, (int)3, null);
                    }
                    break block163;
                }
                case 1814692779: {
                    if (var1_1.equals("app_open_anim_start")) {
                        this.cancelDelayOperate((String)var9_6 /* !! */ );
                        var4_4 /* !! */  = var9_6 /* !! */  != null ? ((DynamicIslandWindowView)this.getView()).requestHasIsland((String)var9_6 /* !! */ ) : null;
                        if (var4_4 /* !! */  != null && var4_4 /* !! */ .isEmpty() ^ true) {
                            for (s var9_6 : var4_4 /* !! */ ) {
                                var4_4 /* !! */  = var9_6 /* !! */  != null && (var4_4 /* !! */  = var9_6 /* !! */ .getCurrentIslandData()) != null ? var4_4 /* !! */ .getKey() : null;
                                if (!o.c((Object)var4_4 /* !! */ , (Object)this.openAppKey)) continue;
                                ((DynamicIslandWindowView)this.getView()).updateViewStateWhenOpenAnimStart((DynamicIslandContentView)var9_6 /* !! */ );
                            }
                        }
                    }
                    break block163;
                }
                case 1784144651: {
                    if (var1_1.equals("split_to_dismiss")) ** GOTO lbl304
                    break block163;
                }
                case 1626083599: {
                    if (var1_1.equals("open_app_start")) {
                        if (var3_3) {
                            this.lastEventKey = var1_1;
                            return null;
                        }
                        if (var2_2) {
                            this._isFreeformAnimRunning.setValue((Object)Boolean.TRUE);
                        } else {
                            this._isAppAnimRunning.setValue((Object)Boolean.TRUE);
                        }
                        ((DynamicIslandWindowView)this.getView()).setAnimRunning(true, var2_2);
                        this.cancelDelayOperate((String)var9_6 /* !! */ );
                        var10_8 /* !! */  = new WindowAnimState(var2_2){
                            private final boolean freeform;
                            {
                                this.freeform = bl;
                            }

                            public static /* synthetic */ WindowAnimState.Opening copy$default(WindowAnimState.Opening opening, boolean bl, int n, Object object) {
                                if ((n & 1) != 0) {
                                    bl = opening.freeform;
                                }
                                return opening.copy(bl);
                            }

                            public final boolean component1() {
                                return this.freeform;
                            }

                            public final WindowAnimState.Opening copy(boolean bl) {
                                return new /* invalid duplicate definition of identical inner class */;
                            }

                            public boolean equals(Object object) {
                                if (this == object) {
                                    return true;
                                }
                                if (!(object instanceof WindowAnimState.Opening)) {
                                    return false;
                                }
                                object = object;
                                return this.freeform == object.freeform;
                            }

                            public final boolean getFreeform() {
                                return this.freeform;
                            }

                            public int hashCode() {
                                return Boolean.hashCode(this.freeform);
                            }

                            public String toString() {
                                boolean bl = this.freeform;
                                StringBuilder stringBuilder = new StringBuilder();
                                stringBuilder.append("Opening(freeform=");
                                stringBuilder.append(bl);
                                stringBuilder.append(")");
                                return stringBuilder.toString();
                            }
                        };
                        var4_4 /* !! */  = var9_6 /* !! */  != null ? ((DynamicIslandWindowView)this.getView()).requestHasIsland((String)var9_6 /* !! */ ) : null;
                        if (var4_4 /* !! */  != null) {
                            for (s var9_6 : var4_4 /* !! */ ) {
                                if (var6_12 < 0) {
                                    m.n();
                                }
                                if ((var9_6 /* !! */  = (DynamicIslandContentView)var9_6 /* !! */ ) != null) {
                                    var9_6 /* !! */ .setWindowAnimState((WindowAnimState)var10_8 /* !! */ );
                                }
                                var11_7 /* !! */  = new StringBuilder();
                                var11_7 /* !! */ .append("state = ");
                                var11_7 /* !! */ .append(var9_6 /* !! */ );
                                Log.d((String)"DynamicIslandAnimDebug", (String)var11_7 /* !! */ .toString());
                                if (var6_12 == 0) {
                                    ((DynamicIslandWindowView)this.getView()).updateIslandWindowAnimRunningState(true, (DynamicIslandContentView)var9_6 /* !! */ , var2_2);
                                }
                                if (var2_2) {
                                    ((DynamicIslandWindowView)this.getView()).cancelExpandViewTrackingAnim((DynamicIslandContentView)var9_6 /* !! */ );
                                    ((DynamicIslandWindowView)this.getView()).enterMiniWindow((DynamicIslandContentView)var9_6 /* !! */ );
                                } else {
                                    ((DynamicIslandWindowView)this.getView()).appEnter((DynamicIslandContentView)var9_6 /* !! */ );
                                }
                                ++var6_12;
                            }
                            var4_4 /* !! */  = s.a;
                        }
                    }
                    break block163;
                }
                case 1613110965: {
                    if (var1_1.equals("open_app_error")) {
                        var3_3 = var4_4 /* !! */  != null && var4_4 /* !! */ .getBoolean("collapse") == true;
                        this.openAppError(var2_2, (String)var9_6 /* !! */ , var3_3);
                    }
                    break block163;
                }
                case 1585499805: {
                    if (var1_1.equals("app_interrupt_anim_position")) {
                        var9_6 /* !! */  = var4_4 /* !! */  != null ? Float.valueOf(var4_4 /* !! */ .getFloat("app_interrupt_anim_left")) : null;
                        var10_8 /* !! */  = var4_4 /* !! */  != null ? Float.valueOf(var4_4 /* !! */ .getFloat("app_interrupt_anim_top")) : null;
                        var11_7 /* !! */  = var4_4 /* !! */  != null ? Float.valueOf(var4_4 /* !! */ .getFloat("app_interrupt_anim_right")) : null;
                        var12_9 /* !! */  = var4_4 /* !! */  != null ? Float.valueOf(var4_4 /* !! */ .getFloat("app_interrupt_anim_bottom")) : null;
                        var13_13 = var4_4 /* !! */  != null ? Float.valueOf(var4_4 /* !! */ .getFloat("app_interrupt_anim_radius")) : null;
                        var4_4 /* !! */  = var4_4 /* !! */  != null ? var4_4 /* !! */ .getString("packageName") : null;
                        if (var9_6 /* !! */  != null && var10_8 /* !! */  != null && var11_7 /* !! */  != null && var12_9 /* !! */  != null && var13_13 != null && var4_4 /* !! */  != null && (var4_4 /* !! */  = ((DynamicIslandWindowView)this.getView()).requestHasIsland((String)var4_4 /* !! */ )) != null && (var14_17 /* !! */  = u.H((Iterable)var4_4 /* !! */ )) != null) {
                            var4_4 /* !! */  = new ArrayList<E>();
                            var14_17 /* !! */  = var14_17 /* !! */ .iterator();
                            while (var14_17 /* !! */ .hasNext()) {
                                var15_20 = var14_17 /* !! */ .next();
                                var16_22 = (DynamicIslandContentView)var15_20;
                                if (var2_2 || !DynamicIslandUtils.INSTANCE.isGlowEffectEnabledForExpandState$miui_dynamicisland_release(var16_22.getCurrentIslandData())) continue;
                                var4_4 /* !! */ .add(var15_20);
                            }
                            var4_4 /* !! */  = var4_4 /* !! */ .iterator();
                            while (var4_4 /* !! */ .hasNext()) {
                                var14_17 /* !! */  = ((DynamicIslandContentView)var4_4 /* !! */ .next()).getExpandedView();
                                if (var14_17 /* !! */  == null) continue;
                                var14_17 /* !! */ .updateInterruptedAnim$miui_dynamicisland_release(var9_6 /* !! */ .floatValue(), var10_8 /* !! */ .floatValue(), var11_7 /* !! */ .floatValue(), var12_9 /* !! */ .floatValue(), var13_13.floatValue());
                                var14_17 /* !! */  = s.a;
                            }
                            var4_4 /* !! */  = s.a;
                        }
                    }
                    break block163;
                }
                case 1069646640: {
                    if (var1_1.equals("freeform_to_fullscreen")) ** GOTO lbl246
                    break block163;
                }
                case 961957696: {
                    if (var1_1.equals("request_close_position")) {
                        this.setPositionValue(true, true);
                        var11_7 /* !! */  = var9_6 /* !! */  != null ? ((DynamicIslandWindowView)this.getView()).requestHasIsland((String)var9_6 /* !! */ ) : null;
                        var4_4 /* !! */  = ((DynamicIslandWindowView)this.getView()).getCutoutRect();
                        var12_9 /* !! */  = new WindowAnimState(var2_2){
                            private final boolean freeform;
                            {
                                this.freeform = bl;
                            }

                            public static /* synthetic */ WindowAnimState.ClosingPosition copy$default(WindowAnimState.ClosingPosition closingPosition, boolean bl, int n, Object object) {
                                if ((n & 1) != 0) {
                                    bl = closingPosition.freeform;
                                }
                                return closingPosition.copy(bl);
                            }

                            public final boolean component1() {
                                return this.freeform;
                            }

                            public final WindowAnimState.ClosingPosition copy(boolean bl) {
                                return new /* invalid duplicate definition of identical inner class */;
                            }

                            public boolean equals(Object object) {
                                if (this == object) {
                                    return true;
                                }
                                if (!(object instanceof WindowAnimState.ClosingPosition)) {
                                    return false;
                                }
                                object = object;
                                return this.freeform == object.freeform;
                            }

                            public final boolean getFreeform() {
                                return this.freeform;
                            }

                            public int hashCode() {
                                return Boolean.hashCode(this.freeform);
                            }

                            public String toString() {
                                boolean bl = this.freeform;
                                StringBuilder stringBuilder = new StringBuilder();
                                stringBuilder.append("ClosingPosition(freeform=");
                                stringBuilder.append(bl);
                                stringBuilder.append(")");
                                return stringBuilder.toString();
                            }
                        };
                        var10_8 /* !! */  = var4_4 /* !! */ ;
                        if (var11_7 /* !! */  != null) {
                            var11_7 /* !! */  = var11_7 /* !! */ .iterator();
                            while (var11_7 /* !! */ .hasNext()) {
                                var13_14 = (DynamicIslandContentView)var11_7 /* !! */ .next();
                                if (var13_14 != null) {
                                    var13_14.setWindowAnimState((WindowAnimState)var12_9 /* !! */ );
                                }
                                var10_8 /* !! */  = var13_14 != null ? var13_14.getState() : null;
                                var14_18 = new StringBuilder();
                                var14_18.append("currentState = ");
                                var14_18.append(var10_8 /* !! */ );
                                Log.d((String)"DynamicIslandAnimDebug", (String)var14_18.toString());
                                if (var2_2) {
                                    var10_8 /* !! */  = var13_14 != null ? var13_14.getState() : null;
                                    if (!(var10_8 /* !! */  instanceof DynamicIslandState.MiniWindowExpanded)) {
                                        continue;
                                    }
                                } else {
                                    var10_8 /* !! */  = var13_14 != null ? var13_14.getState() : null;
                                    if (!(var10_8 /* !! */  instanceof DynamicIslandState.AppExpanded)) {
                                        var10_8 /* !! */  = var13_14 != null && (var10_8 /* !! */  = var13_14.getCurrentIslandData()) != null ? var10_8 /* !! */ .getKey() : null;
                                        this.addAppCloseRect((String)var10_8 /* !! */ , (Rect)var4_4 /* !! */ );
                                        continue;
                                    }
                                }
                                if (var13_14.getState() instanceof DynamicIslandState.MiniWindowExpanded || var13_14.getState() instanceof DynamicIslandState.AppExpanded) {
                                    ((DynamicIslandWindowView)this.getView()).onWindowAnimExtendLifetimeStart(var13_14);
                                }
                                var14_18 = ((DynamicIslandWindowView)this.getView()).calculateCollapse(var13_14);
                                var4_4 /* !! */  = new StringBuilder();
                                var4_4 /* !! */ .append("newState = ");
                                var4_4 /* !! */ .append(var14_18);
                                Log.d((String)"DynamicIslandAnimDebug", (String)var4_4 /* !! */ .toString());
                                var10_8 /* !! */  = this.getAppCloseRealIslandRect((DynamicIslandState)var14_18, var13_14, (String)var9_6 /* !! */ , var2_2);
                                var4_4 /* !! */  = var13_14.getCurrentIslandData();
                                var4_4 /* !! */  = var4_4 /* !! */  != null ? var4_4 /* !! */ .getKey() : null;
                                this.addAppCloseRect((String)var4_4 /* !! */ , (Rect)var10_8 /* !! */ );
                                var4_4 /* !! */  = new StringBuilder();
                                var4_4 /* !! */ .append("newState = ");
                                var4_4 /* !! */ .append(var14_18);
                                var4_4 /* !! */ .append(", rect = ");
                                var4_4 /* !! */ .append(var10_8 /* !! */ );
                                Log.d((String)"DynamicIslandAnimDebug", (String)var4_4 /* !! */ .toString());
                                var4_4 /* !! */  = var10_8 /* !! */ ;
                            }
                            var9_6 /* !! */  = s.a;
                            var10_8 /* !! */  = var4_4 /* !! */ ;
                        }
                        var4_4 /* !! */  = new Bundle();
                        var4_4 /* !! */ .putParcelable("position", (Parcelable)var10_8 /* !! */ );
                        this.lastEventKey = var1_1;
                        return var4_4 /* !! */ ;
                    }
                    break block163;
                }
                case 803204440: {
                    if (var1_1.equals("fullscreen_to_mini_freeform")) {
                        f.b((f1.E)this.uiScope, null, null, (U0.o)new U0.o(this, (String)var9_6 /* !! */ , var2_2, null){
                            final boolean $isFreeform;
                            final String $pkg;
                            int label;
                            final DynamicIslandWindowViewController this$0;
                            {
                                this.this$0 = dynamicIslandWindowViewController;
                                this.$pkg = string;
                                this.$isFreeform = bl;
                                super(2, d2);
                            }

                            public final K0.d create(Object object, K0.d d2) {
                                return new /* invalid duplicate definition of identical inner class */;
                            }

                            public final Object invoke(f1.E e2, K0.d d2) {
                                return (this.create(e2, d2)).invokeSuspend(s.a);
                            }

                            public final Object invokeSuspend(Object list) {
                                c.c();
                                if (this.label == 0) {
                                    k.b((Object)list);
                                    DynamicIslandWindowViewController.access$cancelDelayOperate(this.this$0, this.$pkg);
                                    list = this.$pkg;
                                    list = list != null ? DynamicIslandWindowViewController.access$getView(this.this$0).requestHasIsland((String)((Object)list)) : null;
                                    if (list != null) {
                                        DynamicIslandWindowViewController dynamicIslandWindowViewController = this.this$0;
                                        boolean bl = this.$isFreeform;
                                        for (DynamicIslandContentView dynamicIslandContentView : list) {
                                            list = new StringBuilder();
                                            ((StringBuilder)((Object)list)).append("fullscreen_to_mini_freeform state = ");
                                            ((StringBuilder)((Object)list)).append((Object)((Object)dynamicIslandContentView));
                                            Log.d((String)"DynamicIslandAnimDebug", (String)((StringBuilder)((Object)list)).toString());
                                            DynamicIslandWindowView.updateViewStateWhenCloseEnd$default(DynamicIslandWindowViewController.access$getView(dynamicIslandWindowViewController), dynamicIslandContentView, bl, null, 4, null);
                                            DynamicIslandWindowViewController.access$getView(dynamicIslandWindowViewController).enterMiniWindow(dynamicIslandContentView);
                                            DynamicIslandWindowViewController.access$getView(dynamicIslandWindowViewController).onWindowAnimExtendLifetimeEnd(dynamicIslandContentView);
                                        }
                                    }
                                    return s.a;
                                }
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                        }, (int)3, null);
                    }
                    break block163;
                }
                case 738722817: {
                    if (var1_1.equals("app_to_recent")) {
                        if (var2_2) {
                            this._isFreeformAnimRunning.setValue((Object)Boolean.FALSE);
                        } else {
                            this._isAppAnimRunning.setValue((Object)Boolean.FALSE);
                        }
                        var4_4 /* !! */  = var9_6 /* !! */  != null ? ((DynamicIslandWindowView)this.getView()).requestHasIsland((String)var9_6 /* !! */ ) : null;
                        var9_6 /* !! */  = new WindowAnimState(var2_2, false, false, 4, null){
                            private final boolean byAnimEvent;
                            private final boolean freeform;
                            private final boolean hasAnimate;
                            {
                                this.freeform = bl;
                                this.hasAnimate = bl2;
                                this.byAnimEvent = bl3;
                            }
                            {
                                if ((n & 4) != 0) {
                                    bl3 = true;
                                }
                                this(bl, bl2, bl3);
                            }

                            public static /* synthetic */ WindowAnimState.Closed copy$default(WindowAnimState.Closed closed, boolean bl, boolean bl2, boolean bl3, int n, Object object) {
                                if ((n & 1) != 0) {
                                    bl = closed.freeform;
                                }
                                if ((n & 2) != 0) {
                                    bl2 = closed.hasAnimate;
                                }
                                if ((n & 4) != 0) {
                                    bl3 = closed.byAnimEvent;
                                }
                                return closed.copy(bl, bl2, bl3);
                            }

                            public final boolean component1() {
                                return this.freeform;
                            }

                            public final boolean component2() {
                                return this.hasAnimate;
                            }

                            public final boolean component3() {
                                return this.byAnimEvent;
                            }

                            public final WindowAnimState.Closed copy(boolean bl, boolean bl2, boolean bl3) {
                                return new /* invalid duplicate definition of identical inner class */;
                            }

                            public boolean equals(Object object) {
                                if (this == object) {
                                    return true;
                                }
                                if (!(object instanceof WindowAnimState.Closed)) {
                                    return false;
                                }
                                object = object;
                                if (this.freeform != object.freeform) {
                                    return false;
                                }
                                if (this.hasAnimate != object.hasAnimate) {
                                    return false;
                                }
                                return this.byAnimEvent == object.byAnimEvent;
                            }

                            public final boolean getByAnimEvent() {
                                return this.byAnimEvent;
                            }

                            public final boolean getFreeform() {
                                return this.freeform;
                            }

                            public final boolean getHasAnimate() {
                                return this.hasAnimate;
                            }

                            public int hashCode() {
                                return (Boolean.hashCode(this.freeform) * 31 + Boolean.hashCode(this.hasAnimate)) * 31 + Boolean.hashCode(this.byAnimEvent);
                            }

                            public String toString() {
                                boolean bl = this.freeform;
                                boolean bl2 = this.hasAnimate;
                                boolean bl3 = this.byAnimEvent;
                                StringBuilder stringBuilder = new StringBuilder();
                                stringBuilder.append("Closed(freeform=");
                                stringBuilder.append(bl);
                                stringBuilder.append(", hasAnimate=");
                                stringBuilder.append(bl2);
                                stringBuilder.append(", byAnimEvent=");
                                stringBuilder.append(bl3);
                                stringBuilder.append(")");
                                return stringBuilder.toString();
                            }
                        };
                        if (var4_4 /* !! */  != null) {
                            for (s var10_8 : var4_4 /* !! */ ) {
                                if (var10_8 /* !! */  != null) {
                                    var10_8 /* !! */ .setWindowAnimState((WindowAnimState)var9_6 /* !! */ );
                                }
                                var4_4 /* !! */  = new StringBuilder();
                                var4_4 /* !! */ .append("app_to_recent state = ");
                                var4_4 /* !! */ .append(var10_8 /* !! */ );
                                Log.d((String)"DynamicIslandAnimDebug", (String)var4_4 /* !! */ .toString());
                                if (var10_8 /* !! */  != null) {
                                    var10_8 /* !! */ .setAlpha(1.0f);
                                }
                                if (var10_8 /* !! */  != null) {
                                    var10_8 /* !! */ .setVisibility(0);
                                }
                                var4_4 /* !! */  = var10_8 /* !! */  != null ? var10_8 /* !! */ .getBackgroundView() : null;
                                if (var4_4 /* !! */  != null) {
                                    var4_4 /* !! */ .setVisibility(0);
                                }
                                DynamicIslandWindowView.updateViewStateWhenCloseEnd$default((DynamicIslandWindowView)this.getView(), (DynamicIslandContentView)var10_8 /* !! */ , var2_2, null, 4, null);
                                ((DynamicIslandWindowView)this.getView()).updateIslandWindowAnimRunningState(false, (DynamicIslandContentView)var10_8 /* !! */ , var2_2);
                                ((DynamicIslandWindowView)this.getView()).onWindowAnimExtendLifetimeEnd((DynamicIslandContentView)var10_8 /* !! */ );
                                if (var2_2) {
                                    ((DynamicIslandWindowView)this.getView()).exitMiniWindow((DynamicIslandContentView)var10_8 /* !! */ );
                                    ((DynamicIslandWindowView)this.getView()).enterMiniWindowEnd();
                                    continue;
                                }
                                if (var10_8 /* !! */  != null) {
                                    var10_8 /* !! */ .setOpenAppFromIsland(false);
                                }
                                ((DynamicIslandWindowView)this.getView()).appExit((DynamicIslandContentView)var10_8 /* !! */ );
                            }
                            var4_4 /* !! */  = s.a;
                        }
                        ((DynamicIslandWindowView)this.getView()).setAnimRunning(false, var2_2);
                    }
                    break block163;
                }
                case 512843524: {
                    if (var1_1.equals("open_app_pending")) {
                        DynamicIslandWindowViewController.openAppError$default(this, var2_2, (String)var9_6 /* !! */ , false, 4, null);
                        var1_1 = new Bundle();
                        var1_1.putBoolean("extra_open_error_result", true);
                        return var1_1;
                    }
                    break block163;
                }
                case 399377139: {
                    if (!var1_1.equals("enter_split")) break block163;
lbl246:
                    // 2 sources

                    f.b((f1.E)this.uiScope, null, null, (U0.o)new U0.o(this, (String)var9_6 /* !! */ , var2_2, (String)var1_1, null){
                        final String $event;
                        final boolean $isFreeform;
                        final String $pkg;
                        int label;
                        final DynamicIslandWindowViewController this$0;
                        {
                            this.this$0 = dynamicIslandWindowViewController;
                            this.$pkg = string;
                            this.$isFreeform = bl;
                            this.$event = string2;
                            super(2, d2);
                        }

                        public final K0.d create(Object object, K0.d d2) {
                            return new /* invalid duplicate definition of identical inner class */;
                        }

                        public final Object invoke(f1.E e2, K0.d d2) {
                            return (this.create(e2, d2)).invokeSuspend(s.a);
                        }

                        public final Object invokeSuspend(Object object) {
                            c.c();
                            if (this.label == 0) {
                                DynamicIslandWindowViewController dynamicIslandWindowViewController;
                                k.b((Object)object);
                                DynamicIslandWindowViewController.access$cancelDelayOperate(this.this$0, this.$pkg);
                                object = this.$pkg;
                                object = object != null ? DynamicIslandWindowViewController.access$getView(this.this$0).getCurrentMiniWindowState((String)object) : null;
                                if (object != null) {
                                    boolean bl = this.$isFreeform;
                                    dynamicIslandWindowViewController = this.this$0;
                                    object = object.iterator();
                                    while (object.hasNext()) {
                                        DynamicIslandContentView dynamicIslandContentView = (DynamicIslandContentView)((Object)object.next());
                                        DynamicIslandContentFakeView dynamicIslandContentFakeView = dynamicIslandContentView.getFakeView();
                                        if (dynamicIslandContentFakeView != null) {
                                            DynamicIslandContentFakeView.updateViewStateWhenCloseEnd$default(dynamicIslandContentFakeView, bl, null, 2, null);
                                        }
                                        DynamicIslandWindowViewController.access$getView(dynamicIslandWindowViewController).appEnter(dynamicIslandContentView);
                                        DynamicIslandWindowViewController.access$getView(dynamicIslandWindowViewController).onWindowAnimExtendLifetimeEnd(dynamicIslandContentView);
                                    }
                                }
                                if ((object = this.$pkg) != null) {
                                    if (!o.c((Object)this.$event, (Object)"freeform_to_fullscreen")) {
                                        object = null;
                                    }
                                    if (object != null) {
                                        dynamicIslandWindowViewController = this.this$0;
                                        dynamicIslandWindowViewController.getDynamicIslandSafeguardsController().setFullScreenPkg((String)object);
                                        DynamicIslandWindowViewController.access$getFullScreenPkg$p(dynamicIslandWindowViewController).setValue(object);
                                    }
                                }
                                if (DynamicIslandWindowViewController.access$hasAppState(this.this$0, null)) {
                                    this.this$0.getDynamicIslandSafeguardsController().delayExitApp(this.$pkg, true);
                                }
                                return s.a;
                            }
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                    }, (int)3, null);
                    break block163;
                }
                case -26823218: {
                    if (var1_1.equals("request_open_position")) {
                        this.setPositionValue(true, true);
                        this.lastEventKey = var1_1;
                        var1_1 = var9_6 /* !! */  != null ? ((DynamicIslandWindowView)this.getView()).requestHasIsland((String)var9_6 /* !! */ ) : null;
                        var4_4 /* !! */  = new WindowAnimState(var2_2){
                            private final boolean freeform;
                            {
                                this.freeform = bl;
                            }

                            public static /* synthetic */ WindowAnimState.OpeningPosition copy$default(WindowAnimState.OpeningPosition openingPosition, boolean bl, int n, Object object) {
                                if ((n & 1) != 0) {
                                    bl = openingPosition.freeform;
                                }
                                return openingPosition.copy(bl);
                            }

                            public final boolean component1() {
                                return this.freeform;
                            }

                            public final WindowAnimState.OpeningPosition copy(boolean bl) {
                                return new /* invalid duplicate definition of identical inner class */;
                            }

                            public boolean equals(Object object) {
                                if (this == object) {
                                    return true;
                                }
                                if (!(object instanceof WindowAnimState.OpeningPosition)) {
                                    return false;
                                }
                                object = object;
                                return this.freeform == object.freeform;
                            }

                            public final boolean getFreeform() {
                                return this.freeform;
                            }

                            public int hashCode() {
                                return Boolean.hashCode(this.freeform);
                            }

                            public String toString() {
                                boolean bl = this.freeform;
                                StringBuilder stringBuilder = new StringBuilder();
                                stringBuilder.append("OpeningPosition(freeform=");
                                stringBuilder.append(bl);
                                stringBuilder.append(")");
                                return stringBuilder.toString();
                            }
                        };
                        if (var1_1 != null) {
                            if ((var1_1 = var1_1.iterator()).hasNext()) {
                                var9_6 /* !! */  = (DynamicIslandContentView)var1_1.next();
                                if (var9_6 /* !! */  != null) {
                                    var9_6 /* !! */ .setWindowAnimState((WindowAnimState)var4_4 /* !! */ );
                                }
                                var1_1 = new StringBuilder();
                                var1_1.append("state = ");
                                var1_1.append(var9_6 /* !! */ );
                                Log.d((String)"DynamicIslandAnimDebug", (String)var1_1.toString());
                                var1_1 = var9_6 /* !! */  != null ? var9_6 /* !! */ .getState() : null;
                                var1_1 = var1_1 instanceof DynamicIslandState.Expanded ? (var2_2 ? this.getFakeExpandedViewRect((DynamicIslandContentView)var9_6 /* !! */ ) : this.getExpandedIslandRect((DynamicIslandContentView)var9_6 /* !! */ )) : this.getCutoutRect();
                                var4_4 /* !! */  = var9_6 /* !! */  != null ? var9_6 /* !! */ .getState() : null;
                                var10_8 /* !! */  = new StringBuilder();
                                var10_8 /* !! */ .append("currentState = ");
                                var10_8 /* !! */ .append(var4_4 /* !! */ );
                                var10_8 /* !! */ .append(",  rect = ");
                                var10_8 /* !! */ .append(var1_1);
                                Log.d((String)"DynamicIslandAnimDebug", (String)var10_8 /* !! */ .toString());
                                var4_4 /* !! */  = new Bundle();
                                var4_4 /* !! */ .putParcelable("position", (Parcelable)var1_1);
                                var1_1 = var9_6 /* !! */  != null && (var1_1 = var9_6 /* !! */ .getCurrentIslandData()) != null ? var1_1.getKey() : null;
                                this.openAppKey = var1_1;
                                return var4_4 /* !! */ ;
                            }
                            var1_1 = s.a;
                        }
                        return null;
                    }
                    break block163;
                }
                case -115909572: {
                    if (var1_1.equals("update_surface_info_finish")) {
                        f.b((f1.E)this.uiScope, null, null, (U0.o)new U0.o(var2_2, this, (String)var9_6 /* !! */ , null){
                            final boolean $isFreeform;
                            final String $pkg;
                            int label;
                            final DynamicIslandWindowViewController this$0;
                            {
                                this.$isFreeform = bl;
                                this.this$0 = dynamicIslandWindowViewController;
                                this.$pkg = string;
                                super(2, d2);
                            }

                            public final K0.d create(Object object, K0.d d2) {
                                return new /* invalid duplicate definition of identical inner class */;
                            }

                            public final Object invoke(f1.E e2, K0.d d2) {
                                return (this.create(e2, d2)).invokeSuspend(s.a);
                            }

                            public final Object invokeSuspend(Object object) {
                                c.c();
                                if (this.label == 0) {
                                    k.b((Object)object);
                                    if (this.$isFreeform) {
                                        this.this$0.get_isFreeformAnimRunning().setValue((Object)b.a((boolean)false));
                                    } else {
                                        this.this$0.get_isAppAnimRunning().setValue((Object)b.a((boolean)false));
                                    }
                                    WindowAnimState windowAnimState = new /* invalid duplicate definition of identical inner class */;
                                    object = this.$pkg;
                                    object = object != null ? DynamicIslandWindowViewController.access$getView(this.this$0).requestHasIsland((String)object) : null;
                                    if (object == null || object.isEmpty()) {
                                        DynamicIslandWindowViewController.access$getView(this.this$0).hideAllElementSurface();
                                    }
                                    if (object != null) {
                                        DynamicIslandWindowViewController dynamicIslandWindowViewController = this.this$0;
                                        boolean bl = this.$isFreeform;
                                        Iterator<T> iterator = object.iterator();
                                        while (iterator.hasNext()) {
                                            DynamicIslandContentView dynamicIslandContentView = (DynamicIslandContentView)((Object)iterator.next());
                                            boolean bl2 = DynamicIslandWindowViewController.access$getShouldDelayExitApp$p(dynamicIslandWindowViewController);
                                            boolean bl3 = DynamicIslandWindowViewController.access$getRequestPositionByClosePosition$p(dynamicIslandWindowViewController);
                                            object = new StringBuilder();
                                            ((StringBuilder)object).append("update_surface_info_finish state = ");
                                            ((StringBuilder)object).append((Object)((Object)dynamicIslandContentView));
                                            ((StringBuilder)object).append(", ");
                                            ((StringBuilder)object).append(bl2);
                                            ((StringBuilder)object).append(", ");
                                            ((StringBuilder)object).append(bl3);
                                            Log.d((String)"DynamicIslandAnimDebug", (String)((StringBuilder)object).toString());
                                            if (dynamicIslandContentView != null) {
                                                dynamicIslandContentView.setWindowAnimState(windowAnimState);
                                            }
                                            if (dynamicIslandContentView != null) {
                                                dynamicIslandContentView.setVisibility(0);
                                            }
                                            object = dynamicIslandContentView != null ? dynamicIslandContentView.getBackgroundView() : null;
                                            if (object != null) {
                                                ((DynamicIslandBackgroundView)((Object)object)).setVisibility(0);
                                            }
                                            DynamicIslandWindowView.updateViewStateWhenCloseEnd$default(DynamicIslandWindowViewController.access$getView(dynamicIslandWindowViewController), dynamicIslandContentView, bl, null, 4, null);
                                            DynamicIslandWindowViewController.access$getView(dynamicIslandWindowViewController).updateIslandWindowAnimRunningState(false, dynamicIslandContentView, bl);
                                            DynamicIslandWindowViewController.access$getView(dynamicIslandWindowViewController).onWindowAnimExtendLifetimeEnd(dynamicIslandContentView);
                                            if (dynamicIslandContentView == null) continue;
                                            dynamicIslandContentView.setOpenAppFromIsland(false);
                                        }
                                    }
                                    if (this.$pkg != null && !this.$isFreeform && !o.c((Object)this.this$0.getTopActivityPkg(), (Object)this.$pkg) && DynamicIslandWindowViewController.access$hasAppState(this.this$0, this.$pkg)) {
                                        DynamicIslandSafeguardsController.delayExitApp$default(this.this$0.getDynamicIslandSafeguardsController(), this.this$0.getTopActivityPkg(), false, 2, null);
                                    }
                                    DynamicIslandWindowViewController.setPositionValue$default(this.this$0, false, false, 2, null);
                                    DynamicIslandWindowViewController.access$getView(this.this$0).setAnimRunning(false, this.$isFreeform);
                                    return s.a;
                                }
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                        }, (int)3, null);
                    }
                    break block163;
                }
                case -118480178: {
                    if (var1_1.equals("open_app_timeout")) {
                        var2_2 = var8_11;
                        if (var4_4 /* !! */  != null) {
                            var2_2 = var4_4 /* !! */ .getBoolean("backAnimating", false);
                        }
                        this.openAppTimeout((String)var9_6 /* !! */ , var2_2);
                    }
                    break block163;
                }
                case -274311702: {
                    if (!var1_1.equals("close_app_no_anim")) break block163;
lbl304:
                    // 2 sources

                    f.b((f1.E)this.uiScope, null, null, (U0.o)new U0.o(this, var2_2, (String)var9_6 /* !! */ , null){
                        final boolean $isFreeform;
                        final String $pkg;
                        int label;
                        final DynamicIslandWindowViewController this$0;
                        {
                            this.this$0 = dynamicIslandWindowViewController;
                            this.$isFreeform = bl;
                            this.$pkg = string;
                            super(2, d2);
                        }

                        public final K0.d create(Object object, K0.d d2) {
                            return new /* invalid duplicate definition of identical inner class */;
                        }

                        public final Object invoke(f1.E e2, K0.d d2) {
                            return (this.create(e2, d2)).invokeSuspend(s.a);
                        }

                        public final Object invokeSuspend(Object object) {
                            c.c();
                            if (this.label == 0) {
                                k.b((Object)object);
                                DynamicIslandWindowViewController.setPositionValue$default(this.this$0, false, false, 2, null);
                                if (this.$isFreeform) {
                                    this.this$0.get_isFreeformAnimRunning().setValue((Object)b.a((boolean)false));
                                } else {
                                    this.this$0.get_isAppAnimRunning().setValue((Object)b.a((boolean)false));
                                }
                                object = this.$pkg;
                                object = object != null ? DynamicIslandWindowViewController.access$getView(this.this$0).requestHasIsland((String)object) : null;
                                if (object == null || object.isEmpty()) {
                                    DynamicIslandWindowViewController.access$getView(this.this$0).hideAllElementSurface();
                                }
                                WindowAnimState windowAnimState = new /* invalid duplicate definition of identical inner class */;
                                if (object != null) {
                                    DynamicIslandWindowViewController dynamicIslandWindowViewController = this.this$0;
                                    String string = this.$pkg;
                                    boolean bl = this.$isFreeform;
                                    Iterator<T> iterator = object.iterator();
                                    while (iterator.hasNext()) {
                                        DynamicIslandContentView dynamicIslandContentView = (DynamicIslandContentView)((Object)iterator.next());
                                        object = new StringBuilder();
                                        ((StringBuilder)object).append("close_app_no_anim state = ");
                                        ((StringBuilder)object).append((Object)((Object)dynamicIslandContentView));
                                        Log.d((String)"DynamicIslandAnimDebug", (String)((StringBuilder)object).toString());
                                        if (dynamicIslandContentView != null) {
                                            dynamicIslandContentView.setWindowAnimState(windowAnimState);
                                        }
                                        DynamicIslandWindowViewController.access$getAppCloseRealIslandRect(dynamicIslandWindowViewController, DynamicIslandWindowViewController.access$getView(dynamicIslandWindowViewController).calculateCollapse(dynamicIslandContentView), dynamicIslandContentView, string, bl);
                                        if (dynamicIslandContentView != null) {
                                            dynamicIslandContentView.setVisibility(0);
                                        }
                                        object = dynamicIslandContentView != null ? dynamicIslandContentView.getBackgroundView() : null;
                                        if (object != null) {
                                            ((DynamicIslandBackgroundView)((Object)object)).setVisibility(0);
                                        }
                                        DynamicIslandWindowView.updateViewStateWhenCloseEnd$default(DynamicIslandWindowViewController.access$getView(dynamicIslandWindowViewController), dynamicIslandContentView, bl, null, 4, null);
                                        DynamicIslandWindowViewController.access$getView(dynamicIslandWindowViewController).updateIslandWindowAnimRunningState(false, dynamicIslandContentView, bl);
                                        DynamicIslandWindowViewController.access$getView(dynamicIslandWindowViewController).onWindowAnimExtendLifetimeEnd(dynamicIslandContentView);
                                        if (CommonUtils.INSTANCE.getIS_TABLET() && ((Boolean)((WorkBenchModeRepository)DynamicIslandWindowViewController.access$getWorkBenchModeRepository$p(dynamicIslandWindowViewController).get()).isWorkbenchModeEnabled().getValue()).booleanValue()) {
                                            object = dynamicIslandContentView != null ? dynamicIslandContentView.getState() : null;
                                            if (object instanceof DynamicIslandState.MiniWindowExpanded) {
                                                DynamicIslandWindowViewController.access$getView(dynamicIslandWindowViewController).updateFreeformFakeView(dynamicIslandContentView);
                                                DynamicIslandWindowViewController.access$getView(dynamicIslandWindowViewController).exitMiniWindow(dynamicIslandContentView);
                                                DynamicIslandWindowViewController.access$getView(dynamicIslandWindowViewController).enterMiniWindowEnd();
                                                continue;
                                            }
                                            if (!(object instanceof DynamicIslandState.AppExpanded)) continue;
                                            DynamicIslandWindowViewController.access$getView(dynamicIslandWindowViewController).appExit(dynamicIslandContentView);
                                            object = dynamicIslandContentView.getFakeView();
                                            if (object != null) {
                                                object.setAlpha(1.0f);
                                            }
                                            object = dynamicIslandContentView.getFakeView();
                                            if (object != null) {
                                                object.setVisibility(0);
                                            }
                                            dynamicIslandContentView.setOpenAppFromIsland(false);
                                            continue;
                                        }
                                        if (bl) {
                                            DynamicIslandWindowViewController.access$getView(dynamicIslandWindowViewController).exitMiniWindow(dynamicIslandContentView);
                                            DynamicIslandWindowViewController.access$getView(dynamicIslandWindowViewController).enterMiniWindowEnd();
                                            continue;
                                        }
                                        DynamicIslandWindowViewController.access$getView(dynamicIslandWindowViewController).appExit(dynamicIslandContentView);
                                        if (dynamicIslandContentView == null) continue;
                                        dynamicIslandContentView.setOpenAppFromIsland(false);
                                    }
                                }
                                DynamicIslandWindowViewController.access$getView(this.this$0).setAnimRunning(false, this.$isFreeform);
                                return s.a;
                            }
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                    }, (int)3, null);
                    break block163;
                }
                case -306701112: {
                    if (var1_1.equals("open_app_end")) {
                        if (var2_2) {
                            this._isFreeformAnimRunning.setValue((Object)Boolean.FALSE);
                            ((DynamicIslandWindowView)this.getView()).enterMiniWindowEnd();
                        } else {
                            this._isAppAnimRunning.setValue((Object)Boolean.FALSE);
                        }
                        ((DynamicIslandWindowView)this.getView()).setAnimRunning(false, var2_2);
                        var11_7 /* !! */  = new WindowAnimState(var2_2, true, false, 4, null){
                            private final boolean byAnimEvent;
                            private final boolean freeform;
                            private final boolean hasAnimate;
                            {
                                this.freeform = bl;
                                this.hasAnimate = bl2;
                                this.byAnimEvent = bl3;
                            }
                            {
                                if ((n & 4) != 0) {
                                    bl3 = true;
                                }
                                this(bl, bl2, bl3);
                            }

                            public static /* synthetic */ WindowAnimState.Opened copy$default(WindowAnimState.Opened opened, boolean bl, boolean bl2, boolean bl3, int n, Object object) {
                                if ((n & 1) != 0) {
                                    bl = opened.freeform;
                                }
                                if ((n & 2) != 0) {
                                    bl2 = opened.hasAnimate;
                                }
                                if ((n & 4) != 0) {
                                    bl3 = opened.byAnimEvent;
                                }
                                return opened.copy(bl, bl2, bl3);
                            }

                            public final boolean component1() {
                                return this.freeform;
                            }

                            public final boolean component2() {
                                return this.hasAnimate;
                            }

                            public final boolean component3() {
                                return this.byAnimEvent;
                            }

                            public final WindowAnimState.Opened copy(boolean bl, boolean bl2, boolean bl3) {
                                return new /* invalid duplicate definition of identical inner class */;
                            }

                            public boolean equals(Object object) {
                                if (this == object) {
                                    return true;
                                }
                                if (!(object instanceof WindowAnimState.Opened)) {
                                    return false;
                                }
                                object = object;
                                if (this.freeform != object.freeform) {
                                    return false;
                                }
                                if (this.hasAnimate != object.hasAnimate) {
                                    return false;
                                }
                                return this.byAnimEvent == object.byAnimEvent;
                            }

                            public final boolean getByAnimEvent() {
                                return this.byAnimEvent;
                            }

                            public final boolean getFreeform() {
                                return this.freeform;
                            }

                            public final boolean getHasAnimate() {
                                return this.hasAnimate;
                            }

                            public int hashCode() {
                                return (Boolean.hashCode(this.freeform) * 31 + Boolean.hashCode(this.hasAnimate)) * 31 + Boolean.hashCode(this.byAnimEvent);
                            }

                            public String toString() {
                                boolean bl = this.freeform;
                                boolean bl2 = this.hasAnimate;
                                boolean bl3 = this.byAnimEvent;
                                StringBuilder stringBuilder = new StringBuilder();
                                stringBuilder.append("Opened(freeform=");
                                stringBuilder.append(bl);
                                stringBuilder.append(", hasAnimate=");
                                stringBuilder.append(bl2);
                                stringBuilder.append(", byAnimEvent=");
                                stringBuilder.append(bl3);
                                stringBuilder.append(")");
                                return stringBuilder.toString();
                            }
                        };
                        var4_4 /* !! */  = var9_6 /* !! */  != null ? ((DynamicIslandWindowView)this.getView()).requestHasIsland((String)var9_6 /* !! */ ) : null;
                        if (var4_4 /* !! */  != null) {
                            for (Object var12_9 : var4_4 /* !! */ ) {
                                if (var12_9 /* !! */  != null) {
                                    var12_9 /* !! */ .setWindowAnimState((WindowAnimState)var11_7 /* !! */ );
                                }
                                ((DynamicIslandWindowView)this.getView()).updateIslandWindowAnimRunningState(false, (DynamicIslandContentView)var12_9 /* !! */ , var2_2);
                                if (var2_2) {
                                    var4_4 /* !! */  = var12_9 /* !! */  != null ? var12_9 /* !! */ .getFakeView() : null;
                                    if (var4_4 /* !! */  != null) {
                                        var4_4 /* !! */ .setOpenAppFromIsland(false);
                                    }
                                    var4_4 /* !! */  = var12_9 /* !! */  != null ? var12_9 /* !! */ .getFakeView() : null;
                                    if (var4_4 /* !! */  != null) {
                                        var4_4 /* !! */ .setVisibility(8);
                                    }
                                    var4_4 /* !! */  = var12_9 /* !! */  != null && (var4_4 /* !! */  = var12_9 /* !! */ .getFakeView()) != null ? var4_4 /* !! */ .getFakeExpandedView() : null;
                                    if (var4_4 /* !! */  != null) {
                                        var4_4 /* !! */ .setTranslationY(0.0f);
                                    }
                                    ((DynamicIslandWindowView)this.getView()).updateExpandedViewScaleForFreeform((DynamicIslandContentView)var12_9 /* !! */ , (Float)var10_8 /* !! */ , true);
                                } else {
                                    var4_4 /* !! */  = var12_9 /* !! */  != null ? var12_9 /* !! */ .getFakeView() : null;
                                    if (var4_4 /* !! */  != null) {
                                        var4_4 /* !! */ .setVisibility(4);
                                    }
                                }
                                ((DynamicIslandWindowView)this.getView()).onWindowAnimExtendLifetimeEnd((DynamicIslandContentView)var12_9 /* !! */ );
                            }
                            var4_4 /* !! */  = s.a;
                        }
                        DynamicIslandWindowViewController.setPositionValue$default(this, false, false, 2, null);
                    }
                    break block163;
                }
                case -699077497: {
                    if (var1_1.equals("freeform_anim_width") && (var4_4 /* !! */  = var9_6 /* !! */  != null ? ((DynamicIslandWindowView)this.getView()).getCurrentMiniWindowState((String)var9_6 /* !! */ ) : null) != null) {
                        for (s var9_6 : var4_4 /* !! */ ) {
                            ((DynamicIslandWindowView)this.getView()).updateExpandedViewScaleForFreeform((DynamicIslandContentView)var9_6 /* !! */ , (Float)var10_8 /* !! */ , false);
                        }
                        var4_4 /* !! */  = s.a;
                    }
                    break block163;
                }
                case -750481636: {
                    if (var1_1.equals("anim_paused") && var9_6 /* !! */  != null && (var4_4 /* !! */  = ((DynamicIslandWindowView)this.getView()).requestHasIsland((String)var9_6 /* !! */ )) != null && (var10_8 /* !! */  = u.H((Iterable)var4_4 /* !! */ )) != null) {
                        var4_4 /* !! */  = new ArrayList<E>();
                        for (Iterator<T> var11_7 : var10_8 /* !! */ ) {
                            var12_9 /* !! */  = (DynamicIslandContentView)var11_7 /* !! */ ;
                            if (var2_2 || !DynamicIslandUtils.INSTANCE.isGlowEffectEnabledForExpandState$miui_dynamicisland_release(var12_9 /* !! */ .getCurrentIslandData())) continue;
                            var4_4 /* !! */ .add(var11_7 /* !! */ );
                        }
                        var4_4 /* !! */  = var4_4 /* !! */ .iterator();
                        while (var4_4 /* !! */ .hasNext()) {
                            var10_8 /* !! */  = ((DynamicIslandContentView)var4_4 /* !! */ .next()).getExpandedView();
                            if (var10_8 /* !! */  == null) continue;
                            var10_8 /* !! */ .detachFromInterruptedAnimWithStopGlowEffect$miui_dynamicisland_release((String)var9_6 /* !! */ );
                            var10_8 /* !! */  = s.a;
                        }
                        var4_4 /* !! */  = s.a;
                    }
                    break block163;
                }
                case -901307689: {
                    if (var1_1.equals("fullscreen_to_pip")) {
                        f.b((f1.E)this.uiScope, null, null, (U0.o)new U0.o((String)var9_6 /* !! */ , this, null){
                            final String $pkg;
                            int label;
                            final DynamicIslandWindowViewController this$0;
                            {
                                this.$pkg = string;
                                this.this$0 = dynamicIslandWindowViewController;
                                super(2, d2);
                            }

                            public final K0.d create(Object object, K0.d d2) {
                                return new /* invalid duplicate definition of identical inner class */;
                            }

                            public final Object invoke(f1.E e2, K0.d d2) {
                                return (this.create(e2, d2)).invokeSuspend(s.a);
                            }

                            /*
                             * WARNING - void declaration
                             */
                            public final Object invokeSuspend(Object object2) {
                                c.c();
                                if (this.label == 0) {
                                    void var1_5;
                                    k.b((Object)object2);
                                    String string = this.$pkg;
                                    if (string != null) {
                                        List<DynamicIslandContentView> list = DynamicIslandWindowViewController.access$getView(this.this$0).requestHasIsland(string);
                                    } else {
                                        Object var1_4 = null;
                                    }
                                    if (var1_5 != null) {
                                        DynamicIslandWindowViewController dynamicIslandWindowViewController = this.this$0;
                                        for (DynamicIslandContentView dynamicIslandContentView : var1_5) {
                                            Object object = new StringBuilder();
                                            ((StringBuilder)object).append("fullscreen_to_pip state = ");
                                            ((StringBuilder)object).append((Object)((Object)dynamicIslandContentView));
                                            Log.d((String)"DynamicIslandAnimDebug", (String)((StringBuilder)object).toString());
                                            object = DynamicIslandWindowViewController.access$getView(dynamicIslandWindowViewController).getEventCoordinator();
                                            if (object == null) continue;
                                            ((DynamicIslandEventCoordinator)object).updateMiniBar(dynamicIslandContentView);
                                        }
                                    }
                                    return s.a;
                                }
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                        }, (int)3, null);
                    }
                    break block163;
                }
                case -989809860: {
                    if (var1_1.equals("open_app_no_anim")) {
                        this.cancelDelayOperate((String)var9_6 /* !! */ );
                        var4_4 /* !! */  = var9_6 /* !! */  != null ? ((DynamicIslandWindowView)this.getView()).requestHasIsland((String)var9_6 /* !! */ ) : null;
                        var9_6 /* !! */  = new /* invalid duplicate definition of identical inner class */;
                        if (var4_4 /* !! */  != null) {
                            for (Iterator<T> var11_7 : var4_4 /* !! */ ) {
                                if (var11_7 /* !! */  != null) {
                                    var11_7 /* !! */ .setWindowAnimState((WindowAnimState)var9_6 /* !! */ );
                                }
                                var4_4 /* !! */  = new StringBuilder();
                                var4_4 /* !! */ .append("state = ");
                                var4_4 /* !! */ .append(var11_7 /* !! */ );
                                Log.d((String)"DynamicIslandAnimDebug", (String)var4_4 /* !! */ .toString());
                                if (var2_2) {
                                    var4_4 /* !! */  = var11_7 /* !! */  != null ? var11_7 /* !! */ .getFakeView() : null;
                                    if (var4_4 /* !! */  != null) {
                                        var4_4 /* !! */ .setVisibility(8);
                                    }
                                    var4_4 /* !! */  = var11_7 /* !! */  != null ? var11_7 /* !! */ .getFakeView() : null;
                                    if (var4_4 /* !! */  != null) {
                                        var4_4 /* !! */ .setOpenAppFromIsland(false);
                                    }
                                    ((DynamicIslandWindowView)this.getView()).cancelExpandViewTrackingAnim((DynamicIslandContentView)var11_7 /* !! */ );
                                    ((DynamicIslandWindowView)this.getView()).enterMiniWindow((DynamicIslandContentView)var11_7 /* !! */ );
                                } else {
                                    ((DynamicIslandWindowView)this.getView()).appEnter((DynamicIslandContentView)var11_7 /* !! */ );
                                    if (var11_7 /* !! */  != null) {
                                        var11_7 /* !! */ .setOpenAppFromIsland(false);
                                    }
                                }
                                ((DynamicIslandWindowView)this.getView()).updateIslandWindowAnimRunningState(false, (DynamicIslandContentView)var11_7 /* !! */ , var2_2);
                                ((DynamicIslandWindowView)this.getView()).onWindowAnimExtendLifetimeEnd((DynamicIslandContentView)var11_7 /* !! */ );
                            }
                            var4_4 /* !! */  = s.a;
                        }
                        if (o.c((Object)this.lastEventKey, (Object)"request_close_position") && this.requestPositionByClosePosition) {
                            Log.d((String)"DynamicIslandWindowViewController", (String)"sendWindowAnimEvent: force close for update_surface_info_finish");
                            this.setPositionValue(false, true);
                        } else {
                            DynamicIslandWindowViewController.setPositionValue$default(this, false, false, 2, null);
                        }
                    }
                    break block163;
                }
                case -1048350793: {
                    if (var1_1.equals("freeform_pin_exit")) {
                        f.b((f1.E)this.uiScope, null, null, (U0.o)new U0.o(this, (String)var9_6 /* !! */ , var2_2, null){
                            final boolean $isFreeform;
                            final String $pkg;
                            int label;
                            final DynamicIslandWindowViewController this$0;
                            {
                                this.this$0 = dynamicIslandWindowViewController;
                                this.$pkg = string;
                                this.$isFreeform = bl;
                                super(2, d2);
                            }

                            public final K0.d create(Object object, K0.d d2) {
                                return new /* invalid duplicate definition of identical inner class */;
                            }

                            public final Object invoke(f1.E e2, K0.d d2) {
                                return (this.create(e2, d2)).invokeSuspend(s.a);
                            }

                            public final Object invokeSuspend(Object object) {
                                c.c();
                                if (this.label == 0) {
                                    k.b((Object)object);
                                    DynamicIslandWindowViewController.access$cancelDelayOperate(this.this$0, this.$pkg);
                                    object = this.$pkg;
                                    object = object != null ? DynamicIslandWindowViewController.access$getView(this.this$0).requestHasIsland((String)object) : null;
                                    if (object != null) {
                                        DynamicIslandWindowViewController dynamicIslandWindowViewController = this.this$0;
                                        boolean bl = this.$isFreeform;
                                        Iterator<T> iterator = object.iterator();
                                        while (iterator.hasNext()) {
                                            DynamicIslandContentView dynamicIslandContentView = (DynamicIslandContentView)((Object)iterator.next());
                                            object = new StringBuilder();
                                            ((StringBuilder)object).append("freeform_pin_exit state = ");
                                            ((StringBuilder)object).append((Object)((Object)dynamicIslandContentView));
                                            Log.d((String)"DynamicIslandAnimDebug", (String)((StringBuilder)object).toString());
                                            ArrayList arrayList = DynamicIslandWindowViewController.access$getPinOperateList$p(dynamicIslandWindowViewController);
                                            object = dynamicIslandContentView != null && (object = dynamicIslandContentView.getCurrentIslandData()) != null ? object.getKey() : null;
                                            if (!u.F((Iterable)arrayList, (Object)object) && dynamicIslandContentView != null && (object = dynamicIslandContentView.getCurrentIslandData()) != null && (object = object.getKey()) != null) {
                                                b.a((boolean)DynamicIslandWindowViewController.access$getPinOperateList$p(dynamicIslandWindowViewController).add(object));
                                            }
                                            DynamicIslandWindowView.updateViewStateWhenCloseEnd$default(DynamicIslandWindowViewController.access$getView(dynamicIslandWindowViewController), dynamicIslandContentView, bl, null, 4, null);
                                            DynamicIslandWindowViewController.access$getView(dynamicIslandWindowViewController).enterMiniWindow(dynamicIslandContentView);
                                            DynamicIslandWindowViewController.access$getView(dynamicIslandWindowViewController).onWindowAnimExtendLifetimeEnd(dynamicIslandContentView);
                                        }
                                    }
                                    return s.a;
                                }
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                        }, (int)3, null);
                    }
                    break block163;
                }
                case -1135179971: {
                    if (var1_1.equals("close_app_start")) {
                        if (var2_2) {
                            this._isFreeformAnimRunning.setValue((Object)Boolean.TRUE);
                        } else {
                            this._isAppAnimRunning.setValue((Object)Boolean.TRUE);
                        }
                        var4_4 /* !! */  = var9_6 /* !! */  != null ? ((DynamicIslandWindowView)this.getView()).requestHasIsland((String)var9_6 /* !! */ ) : null;
                        this.cancelDelayOperate((String)var9_6 /* !! */ );
                        var11_7 /* !! */  = new WindowAnimState(var2_2){
                            private final boolean freeform;
                            {
                                this.freeform = bl;
                            }

                            public static /* synthetic */ WindowAnimState.Closing copy$default(WindowAnimState.Closing closing, boolean bl, int n, Object object) {
                                if ((n & 1) != 0) {
                                    bl = closing.freeform;
                                }
                                return closing.copy(bl);
                            }

                            public final boolean component1() {
                                return this.freeform;
                            }

                            public final WindowAnimState.Closing copy(boolean bl) {
                                return new /* invalid duplicate definition of identical inner class */;
                            }

                            public boolean equals(Object object) {
                                if (this == object) {
                                    return true;
                                }
                                if (!(object instanceof WindowAnimState.Closing)) {
                                    return false;
                                }
                                object = object;
                                return this.freeform == object.freeform;
                            }

                            public final boolean getFreeform() {
                                return this.freeform;
                            }

                            public int hashCode() {
                                return Boolean.hashCode(this.freeform);
                            }

                            public String toString() {
                                boolean bl = this.freeform;
                                StringBuilder stringBuilder = new StringBuilder();
                                stringBuilder.append("Closing(freeform=");
                                stringBuilder.append(bl);
                                stringBuilder.append(")");
                                return stringBuilder.toString();
                            }
                        };
                        if (var4_4 /* !! */  != null) {
                            var13_15 = var4_4 /* !! */ .iterator();
                            var4_4 /* !! */  = var12_9 /* !! */ ;
                            while (var13_15.hasNext()) {
                                var12_9 /* !! */  = (DynamicIslandContentView)var13_15.next();
                                if (var12_9 /* !! */  != null) {
                                    var12_9 /* !! */ .setWindowAnimState((WindowAnimState)var11_7 /* !! */ );
                                }
                                var9_6 /* !! */  = var12_9 /* !! */  != null && (var9_6 /* !! */  = var12_9 /* !! */ .getViewModel()) != null && (var9_6 /* !! */  = var9_6 /* !! */ .getState()) != null ? (DynamicIslandState)var9_6 /* !! */ .getValue() : null;
                                var10_8 /* !! */  = var12_9 /* !! */  != null ? var12_9 /* !! */ .getState() : null;
                                if (var10_8 /* !! */  instanceof DynamicIslandState.AppExpanded || (var10_8 /* !! */  = var12_9 /* !! */  != null ? var12_9 /* !! */ .getState() : null) instanceof DynamicIslandState.MiniWindowExpanded) {
                                    if (var12_9 /* !! */ .pkgHasMultIslands((DynamicIslandContentView)var12_9 /* !! */ )) {
                                        var10_8 /* !! */  = var12_9 /* !! */ .getCurrentIslandData();
                                        var10_8 /* !! */  = var10_8 /* !! */  != null ? var10_8 /* !! */ .getKey() : null;
                                        this.appCloseKey = var10_8 /* !! */ ;
                                    }
                                    this.updateAppRect((DynamicIslandContentView)var12_9 /* !! */ , var2_2);
                                }
                                var10_8 /* !! */  = new StringBuilder();
                                var10_8 /* !! */ .append("state = ");
                                var10_8 /* !! */ .append(var12_9 /* !! */ );
                                var10_8 /* !! */ .append((String)var4_4 /* !! */ );
                                var10_8 /* !! */ .append(var9_6 /* !! */ );
                                Log.d((String)"DynamicIslandAnimDebug", (String)var10_8 /* !! */ .toString());
                                var9_6 /* !! */  = var12_9 /* !! */  != null ? var12_9 /* !! */ .getState() : null;
                                if (var9_6 /* !! */  instanceof DynamicIslandState.MiniWindowExpanded || (var9_6 /* !! */  = var12_9 /* !! */  != null ? var12_9 /* !! */ .getState() : null) instanceof DynamicIslandState.AppExpanded) {
                                    ((DynamicIslandWindowView)this.getView()).updateIslandWindowAnimRunningState(true, (DynamicIslandContentView)var12_9 /* !! */ , var2_2);
                                }
                                if (!var2_2 && !((var9_6 /* !! */  = var12_9 /* !! */  != null ? var12_9 /* !! */ .getState() : null) instanceof DynamicIslandState.AppExpanded) && var12_9 /* !! */  != null) {
                                    var12_9 /* !! */ .setAppReturnIslandButNoAppState(true);
                                }
                                if ((var9_6 /* !! */  = var12_9 /* !! */  != null ? var12_9 /* !! */ .getState() : null) instanceof DynamicIslandState.MiniWindowExpanded) {
                                    ((DynamicIslandWindowView)this.getView()).updateFreeformFakeView((DynamicIslandContentView)var12_9 /* !! */ );
                                    ((DynamicIslandWindowView)this.getView()).exitMiniWindow((DynamicIslandContentView)var12_9 /* !! */ );
                                    continue;
                                }
                                var9_6 /* !! */  = var12_9 /* !! */  != null ? var12_9 /* !! */ .getState() : null;
                                if (!(var9_6 /* !! */  instanceof DynamicIslandState.AppExpanded)) continue;
                                ((DynamicIslandWindowView)this.getView()).appExit((DynamicIslandContentView)var12_9 /* !! */ );
                                var9_6 /* !! */  = var12_9 /* !! */ .getFakeView();
                                if (var9_6 /* !! */  != null) {
                                    var9_6 /* !! */ .setAlpha(1.0f);
                                }
                                var9_6 /* !! */  = var12_9 /* !! */ .getFakeView();
                                if (var9_6 /* !! */  == null) continue;
                                var9_6 /* !! */ .setVisibility(0);
                            }
                            var4_4 /* !! */  = s.a;
                        }
                        ((DynamicIslandWindowView)this.getView()).setAnimRunning(true, var2_2);
                    }
                    break block163;
                }
                case -1245051292: {
                    var1_1.equals("app_open_anim_end");
                    break block163;
                }
                case -1310264778: {
                    if (!var1_1.equals("close_to_expanded")) break block163;
                    var4_4 /* !! */  = var9_6 /* !! */  != null ? ((DynamicIslandWindowView)this.getView()).requestHasIsland((String)var9_6 /* !! */ ) : null;
                    var11_7 /* !! */  = WindowAnimState.Interrupting.INSTANCE;
                    if (var4_4 /* !! */  != null) {
                        var12_9 /* !! */  = var4_4 /* !! */ .iterator();
                        var4_4 /* !! */  = null;
                        while (var12_9 /* !! */ .hasNext()) {
                            var10_8 /* !! */  = (DynamicIslandContentView)var12_9 /* !! */ .next();
                            if (var10_8 /* !! */  != null) {
                                var10_8 /* !! */ .setWindowAnimState((WindowAnimState)var11_7 /* !! */ );
                            }
                            if (var10_8 /* !! */  != null) {
                                var10_8 /* !! */ .setOpenAppFromIsland(false);
                            }
                            var4_4 /* !! */  = var10_8 /* !! */  != null ? var10_8 /* !! */ .getFakeView() : null;
                            if (var4_4 /* !! */  != null) {
                                var4_4 /* !! */ .setOpenAppFromIsland(false);
                            }
                            ((DynamicIslandWindowView)this.getView()).onWindowAnimExtendLifetimeEnd((DynamicIslandContentView)var10_8 /* !! */ );
                            var4_4 /* !! */  = var10_8 /* !! */ ;
                        }
                        var10_8 /* !! */  = s.a;
                    } else {
                        var4_4 /* !! */  = null;
                    }
                    ((DynamicIslandWindowView)this.getView()).setClosingToExpanded((DynamicIslandContentView)var4_4 /* !! */ , var2_2, true);
                    if (var2_2 || !(var11_7 /* !! */  = DynamicIslandUtils.INSTANCE).isGlowEffectEnabledForExpandState$miui_dynamicisland_release((DynamicIslandData)(var10_8 /* !! */  = var4_4 /* !! */  != null ? var4_4 /* !! */ .getCurrentIslandData() : null))) ** GOTO lbl525
                    var10_8 /* !! */  = this.dynamicIslandGlowEffectLayer;
                    var11_7 /* !! */  = new StringBuilder();
                    var11_7 /* !! */ .append("attachGlowViewToInterruptedAnim pkg=");
                    var11_7 /* !! */ .append((String)var9_6 /* !! */ );
                    var11_7 /* !! */ .append(", glowEffectSurfaceLayer=");
                    var11_7 /* !! */ .append(var10_8 /* !! */ );
                    Log.i((String)"DynamicIslandWindowViewController", (String)var11_7 /* !! */ .toString());
                    var11_7 /* !! */  = this.dynamicIslandGlowEffectLayer;
                    if (var11_7 /* !! */  == null) ** GOTO lbl525
                    var10_8 /* !! */  = var4_4 /* !! */  != null ? var4_4 /* !! */ .getExpandedView() : null;
                    if (var10_8 /* !! */  == null) ** GOTO lbl524
                    if (var9_6 /* !! */  != null) {
                        var10_8 /* !! */ .attachGlowViewToInterruptedAnim$miui_dynamicisland_release((String)var9_6 /* !! */ , (DynamicIslandGlowEffectLayer)var11_7 /* !! */ );
                        var9_6 /* !! */  = s.a;
                    } else {
                        throw new IllegalStateException("Required value was null.");
lbl524:
                        // 1 sources

                        throw new IllegalStateException("Required value was null.");
                    }
lbl525:
                    // 3 sources

                    if (!var2_2) {
                        if (var4_4 /* !! */  != null) {
                            var4_4 /* !! */ .setVisibility(0);
                        }
                        var9_6 /* !! */  = var4_4 /* !! */  != null ? var4_4 /* !! */ .getBackgroundView() : null;
                        if (var9_6 /* !! */  != null) {
                            var9_6 /* !! */ .setTransitionAlpha(0.0f);
                        }
                        if (var4_4 /* !! */  != null && (var9_6 /* !! */  = var4_4 /* !! */ .getBackgroundView()) != null) {
                            var9_6 /* !! */ .superSetVisibility(0);
                            var9_6 /* !! */  = s.a;
                        }
                        if ((var9_6 /* !! */  = var4_4 /* !! */  != null ? var4_4 /* !! */ .getFakeView() : null) != null) {
                            var9_6 /* !! */ .setVisibility(0);
                        }
                        var9_6 /* !! */  = var4_4 /* !! */  != null && (var9_6 /* !! */  = var4_4 /* !! */ .getFakeView()) != null ? var9_6 /* !! */ .getFakeExpandedView() : null;
                        if (var9_6 /* !! */  != null) {
                            var9_6 /* !! */ .setVisibility(0);
                        }
                    }
                    var4_4 /* !! */  = var4_4 /* !! */  != null ? this.getExpandedIslandRect((DynamicIslandContentView)var4_4 /* !! */ ) : null;
                    var9_6 /* !! */  = new StringBuilder();
                    var9_6 /* !! */ .append("rect = ");
                    var9_6 /* !! */ .append(var4_4 /* !! */ );
                    Log.d((String)"DynamicIslandAnimDebug", (String)var9_6 /* !! */ .toString());
                    var9_6 /* !! */  = new Bundle();
                    var9_6 /* !! */ .putParcelable("position", (Parcelable)var4_4 /* !! */ );
                    this.lastEventKey = var1_1;
                    return var9_6 /* !! */ ;
                }
                case -1543092618: {
                    if (var1_1.equals("close_app_end")) {
                        this.lastEventKey = var1_1;
                        if (o.c((Object)var11_7 /* !! */ , (Object)Boolean.TRUE) && !var2_2) {
                            return null;
                        }
                        if (var2_2) {
                            this._isFreeformAnimRunning.setValue((Object)Boolean.FALSE);
                        } else {
                            this._isAppAnimRunning.setValue((Object)Boolean.FALSE);
                        }
                        var11_7 /* !! */  = new /* invalid duplicate definition of identical inner class */;
                        this.dynamicIslandSafeguardsController.cancelDelayExitApp((String)var9_6 /* !! */ );
                        if (var2_2) {
                            this.dynamicIslandSafeguardsController.removeEnterMiniWindow((String)var9_6 /* !! */ );
                        }
                        if ((var4_4 /* !! */  = var9_6 /* !! */  != null ? ((DynamicIslandWindowView)this.getView()).requestHasIsland((String)var9_6 /* !! */ ) : null) != null) {
                            for (DynamicIslandContentView var15_21 : var4_4 /* !! */ ) {
                                var12_9 /* !! */  = var15_21 != null ? var15_21.getWindowAnimState() : null;
                                if (var15_21 != null) {
                                    var15_21.setWindowAnimState((WindowAnimState)var11_7 /* !! */ );
                                }
                                if (var2_2) {
                                    ((DynamicIslandWindowView)this.getView()).enterMiniWindowEnd();
                                    ((DynamicIslandWindowView)this.getView()).updateExpandedViewScaleForFreeform(var15_21, (Float)var10_8 /* !! */ , true);
                                } else {
                                    if (var15_21 != null) {
                                        var15_21.setOpenAppFromIsland(false);
                                    }
                                    var16_23 = DynamicIslandUtils.INSTANCE;
                                    var13_16 /* !! */  = var15_21 != null ? var15_21.getCurrentIslandData() : null;
                                    if (var16_23.isGlowEffectEnabledForExpandState$miui_dynamicisland_release(var13_16 /* !! */ ) && var15_21 != null && (var13_16 /* !! */  = var15_21.getExpandedView()) != null) {
                                        if (var9_6 /* !! */  != null) {
                                            var13_16 /* !! */ .detachFromInterruptedAnimWithSync$miui_dynamicisland_release((String)var9_6 /* !! */ );
                                            var13_16 /* !! */  = s.a;
                                        } else {
                                            throw new IllegalStateException("Required value was null.");
                                        }
                                    }
                                }
                                if (var15_21 != null) {
                                    var15_21.setVisibility(0);
                                }
                                var13_16 /* !! */  = var15_21 != null ? var15_21.getBackgroundView() : null;
                                if (var13_16 /* !! */  != null) {
                                    var13_16 /* !! */ .setVisibility(0);
                                }
                                DynamicIslandWindowView.updateViewStateWhenCloseEnd$default((DynamicIslandWindowView)this.getView(), var15_21, var2_2, null, 4, null);
                                ((DynamicIslandWindowView)this.getView()).updateIslandWindowAnimRunningState(false, var15_21, var2_2);
                                ((DynamicIslandWindowView)this.getView()).onWindowAnimExtendLifetimeEnd(var15_21);
                                if (var15_21 != null && (var17_24 = var15_21.getExpandedView()) != null) {
                                    var16_23 = new SurfaceSyncGroup("temp");
                                    var13_16 /* !! */  = var15_21.getFakeView();
                                    var13_16 /* !! */  = var13_16 /* !! */  != null ? var13_16 /* !! */ .getRootSurfaceControl() : null;
                                    var16_23.add((AttachedSurfaceControl)var13_16 /* !! */ , null);
                                    var16_23.add(var15_21.getRootSurfaceControl(), null);
                                    var17_24.syncInterruptAnimWithSwitchFromFakeToReal$miui_dynamicisland_release((SurfaceSyncGroup)var16_23);
                                    var13_16 /* !! */  = s.a;
                                }
                                if (!var5_5 || !var2_2 || o.c((Object)this.topActivityPkg, (Object)var9_6 /* !! */ ) || !this.hasMiniWindowState((String)var9_6 /* !! */ ) || !(var12_9 /* !! */  instanceof WindowAnimState.Opened)) continue;
                                Log.d((String)"DynamicIslandWindowViewController", (String)"sendWindowAnimEventForLinkage: force exit miniwindow ");
                                DynamicIslandSafeguardsController.delayExitMiniWindow$default(this.dynamicIslandSafeguardsController, (String)var9_6 /* !! */ , false, 2, null);
                            }
                            var10_8 /* !! */  = s.a;
                        }
                        if (o.c(var9_6 /* !! */ , (Object)"com.miui.securitycenter") && !var2_2 && (var4_4 /* !! */  == null || var4_4 /* !! */ .isEmpty())) {
                            if (this.hasAppState(null)) {
                                Log.d((String)"DynamicIslandWindowViewController", (String)"sendWindowAnimEventForLinkage: lock app close force exit");
                                DynamicIslandSafeguardsController.delayExitApp$default(this.dynamicIslandSafeguardsController, this.topActivityPkg, false, 2, null);
                            }
                        }
                        ((DynamicIslandWindowView)this.getView()).setAnimRunning(false, var2_2);
                        DynamicIslandWindowViewController.setPositionValue$default(this, false, false, 2, null);
                    }
                    break block163;
                }
                case -1605700896: {
                    if (var1_1.equals("anim_finished")) {
                        this.resetWindowAnimationState();
                    }
                    break block163;
                }
                case -2081237304: 
            }
            if (var1_1.equals("freeform_anim_position")) {
                var10_8 /* !! */  = var4_4 /* !! */  != null ? Float.valueOf(var4_4 /* !! */ .getFloat("freeform_anim_left")) : null;
                var11_7 /* !! */  = var4_4 /* !! */  != null ? Float.valueOf(var4_4 /* !! */ .getFloat("freeform_anim_top")) : null;
                var12_9 /* !! */  = var4_4 /* !! */  != null ? Float.valueOf(var4_4 /* !! */ .getFloat("freeform_anim_right")) : null;
                var4_4 /* !! */  = var4_4 /* !! */  != null ? Float.valueOf(var4_4 /* !! */ .getFloat("freeform_anim_bottom")) : null;
                if (var10_8 /* !! */  != null && var11_7 /* !! */  != null && var12_9 /* !! */  != null && var4_4 /* !! */  != null) {
                    this._freeformAnimRegion.setValue((Object)new Region((int)var10_8 /* !! */ .floatValue(), (int)var11_7 /* !! */ .floatValue(), (int)var12_9 /* !! */ .floatValue(), (int)var4_4 /* !! */ .floatValue()));
                }
                if ((var9_6 /* !! */  = var9_6 /* !! */  != null ? ((DynamicIslandWindowView)this.getView()).getCurrentMiniWindowState((String)var9_6 /* !! */ ) : null) != null) {
                    for (s var10_8 : var9_6 /* !! */ ) {
                        if (!(var10_8 /* !! */ .getState() instanceof DynamicIslandState.MiniWindowExpanded)) continue;
                        ((DynamicIslandWindowView)this.getView()).updateFVOffsetYWhenMWAnimating((DynamicIslandContentView)var10_8 /* !! */ , (Float)var4_4 /* !! */ );
                    }
                    var4_4 /* !! */  = s.a;
                }
            }
        }
        this.lastEventKey = var1_1;
        return null;
    }

    public static /* synthetic */ Bundle sendWindowAnimEventForLinkage$default(DynamicIslandWindowViewController dynamicIslandWindowViewController, String string, boolean bl, boolean bl2, Bundle bundle, boolean bl3, int n, Object object) {
        if ((n & 0x10) != 0) {
            bl3 = false;
        }
        return dynamicIslandWindowViewController.sendWindowAnimEventForLinkage(string, bl, bl2, bundle, bl3);
    }

    /*
     * Enabled aggressive block sorting
     */
    private final Bundle sendWindowAnimEventForMiddle(String object, boolean bl, boolean bl2, Bundle object22) {
        Object object3 = object22 != null ? object22.getString("packageName") : null;
        Object object42 = new StringBuilder();
        object42.append("sendWindowAnimEventForMiddle: ");
        object42.append((String)object);
        object42.append(",  isFreeform: ");
        object42.append(bl);
        object42.append(", isInterrupted: ");
        object42.append(bl2);
        object42.append(", packageName: ");
        object42.append((String)object3);
        object42.append(" ");
        Log.d((String)"DynamicIslandAnimDebug", (String)object42.toString());
        int n = -1;
        switch (((String)object).hashCode()) {
            case 1784144651: {
                if (!((String)object).equals("split_to_dismiss")) break;
                n = 1;
                break;
            }
            case 1626083599: {
                if (!((String)object).equals("open_app_start")) break;
                n = 2;
                break;
            }
            case 961957696: {
                if (!((String)object).equals("request_close_position")) break;
                n = 3;
                break;
            }
            case 738722817: {
                if (!((String)object).equals("app_to_recent")) break;
                n = 1;
                break;
            }
            case 450865345: {
                if (!((String)object).equals("freeform_final_position")) break;
                n = 4;
                break;
            }
            case 399377139: {
                if (!((String)object).equals("enter_split")) break;
                n = 5;
                break;
            }
            case -26823218: {
                if (!((String)object).equals("request_open_position")) break;
                n = 3;
                break;
            }
            case -115909572: {
                if (!((String)object).equals("update_surface_info_finish")) break;
                n = 1;
                break;
            }
            case -274311702: {
                if (!((String)object).equals("close_app_no_anim")) break;
                n = 1;
                break;
            }
            case -306701112: {
                if (!((String)object).equals("open_app_end")) break;
                n = 6;
                break;
            }
            case -989809860: {
                if (!((String)object).equals("open_app_no_anim")) break;
                n = 2;
                break;
            }
            case -1135179971: {
                if (!((String)object).equals("close_app_start")) break;
                n = 7;
                break;
            }
            case -1543092618: {
                if (!((String)object).equals("close_app_end")) break;
                n = 8;
                break;
            }
            case -1605700896: {
                if (!((String)object).equals("anim_finished")) break;
                n = 2;
                break;
            }
        }
        switch (n) {
            default: {
                return null;
            }
            case 4: {
                object = object22 != null ? Float.valueOf(object22.getFloat("freeform_final_bottom")) : null;
                object22 = new StringBuilder();
                object22.append("sendWindowAnimEventForMiddle: bottom: ");
                object22.append(object);
                Log.d((String)"DynamicIslandAnimDebug", (String)object22.toString());
                if (object == null) return null;
                object22 = ((DynamicIslandWindowView)this.getView()).getEventCoordinator();
                if (object22 == null) return null;
                object22.updateWindowHeightForFreeform((int)((Float)object).floatValue());
                return null;
            }
            case 5: {
                f.b((f1.E)this.uiScope, null, null, (U0.o)new U0.o(this, (String)object3, bl, null){
                    final boolean $isFreeform;
                    final String $pkg;
                    int label;
                    final DynamicIslandWindowViewController this$0;
                    {
                        this.this$0 = dynamicIslandWindowViewController;
                        this.$pkg = string;
                        this.$isFreeform = bl;
                        super(2, d2);
                    }

                    public final K0.d create(Object object, K0.d d2) {
                        return new /* invalid duplicate definition of identical inner class */;
                    }

                    public final Object invoke(f1.E e2, K0.d d2) {
                        return (this.create(e2, d2)).invokeSuspend(s.a);
                    }

                    public final Object invokeSuspend(Object object) {
                        c.c();
                        if (this.label == 0) {
                            k.b((Object)object);
                            DynamicIslandWindowViewController.access$cancelDelayOperate(this.this$0, this.$pkg);
                            object = this.$pkg;
                            object = object != null ? DynamicIslandWindowViewController.access$getView(this.this$0).getCurrentMiniWindowState((String)object) : null;
                            if (object != null) {
                                boolean bl = this.$isFreeform;
                                DynamicIslandWindowViewController dynamicIslandWindowViewController = this.this$0;
                                for (DynamicIslandContentView dynamicIslandContentView : object) {
                                    object = dynamicIslandContentView.getFakeView();
                                    if (object != null) {
                                        DynamicIslandContentFakeView.updateViewStateWhenCloseEnd$default(object, bl, null, 2, null);
                                    }
                                    DynamicIslandWindowViewController.access$getView(dynamicIslandWindowViewController).appEnter(dynamicIslandContentView);
                                    DynamicIslandWindowViewController.access$getView(dynamicIslandWindowViewController).onWindowAnimExtendLifetimeEnd(dynamicIslandContentView);
                                }
                            }
                            if (DynamicIslandWindowViewController.access$hasAppState(this.this$0, null)) {
                                this.this$0.getDynamicIslandSafeguardsController().delayExitApp(this.$pkg, true);
                            }
                            return s.a;
                        }
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                }, (int)3, null);
                return null;
            }
            case 3: {
                object = o.c((Object)object, (Object)"request_open_position") ? new /* invalid duplicate definition of identical inner class */ : new /* invalid duplicate definition of identical inner class */;
                if (object3 != null && (object22 = ((DynamicIslandWindowView)this.getView()).requestHasIsland((String)object3)) != null) {
                    for (Object object42 : object22) {
                        if (object42 == null) continue;
                        ((DynamicIslandBaseContentView)((Object)object42)).setWindowAnimState((WindowAnimState)object);
                    }
                }
                this.setPositionValue(true, true);
                this.calculateAppClosePosition((String)object3, bl);
                object = ((DynamicIslandWindowView)this.getView()).getCutoutRect();
                object22 = new StringBuilder();
                object22.append("sendWindowAnimEventForMiddle: rect : ");
                object22.append(object);
                object22.append("}");
                Log.d((String)"DynamicIslandAnimDebug", (String)object22.toString());
                object22 = new Bundle();
                object22.putParcelable("position", (Parcelable)object);
                return object22;
            }
            case 1: {
                f.b((f1.E)this.uiScope, null, null, (U0.o)new U0.o(bl, (String)object3, this, (String)object, null){
                    final String $event;
                    final boolean $isFreeform;
                    final String $pkg;
                    int label;
                    final DynamicIslandWindowViewController this$0;
                    {
                        this.$isFreeform = bl;
                        this.$pkg = string;
                        this.this$0 = dynamicIslandWindowViewController;
                        this.$event = string2;
                        super(2, d2);
                    }

                    public final K0.d create(Object object, K0.d d2) {
                        return new /* invalid duplicate definition of identical inner class */;
                    }

                    public final Object invoke(f1.E e2, K0.d d2) {
                        return (this.create(e2, d2)).invokeSuspend(s.a);
                    }

                    public final Object invokeSuspend(Object object) {
                        c.c();
                        if (this.label == 0) {
                            k.b((Object)object);
                            WindowAnimState windowAnimState = new /* invalid duplicate definition of identical inner class */;
                            object = this.$pkg;
                            object = object != null ? DynamicIslandWindowViewController.access$getView(this.this$0).requestHasIsland((String)object) : null;
                            if (object == null || object.isEmpty()) {
                                DynamicIslandWindowViewController.access$getView(this.this$0).hideAllElementSurface();
                            }
                            if (object != null) {
                                DynamicIslandWindowViewController dynamicIslandWindowViewController = this.this$0;
                                String string = this.$pkg;
                                boolean bl = this.$isFreeform;
                                String string2 = this.$event;
                                Iterator<T> iterator = object.iterator();
                                while (iterator.hasNext()) {
                                    DynamicIslandContentView dynamicIslandContentView = (DynamicIslandContentView)((Object)iterator.next());
                                    object = dynamicIslandContentView != null ? dynamicIslandContentView.getState() : null;
                                    StringBuilder stringBuilder = new StringBuilder();
                                    stringBuilder.append("sendWindowAnimEventForMiddle: currentState = ");
                                    stringBuilder.append(object);
                                    Log.d((String)"DynamicIslandAnimDebug", (String)stringBuilder.toString());
                                    if (dynamicIslandContentView != null) {
                                        dynamicIslandContentView.setWindowAnimState(windowAnimState);
                                    }
                                    if (dynamicIslandContentView != null) {
                                        dynamicIslandContentView.setVisibility(0);
                                    }
                                    object = dynamicIslandContentView != null ? dynamicIslandContentView.getBackgroundView() : null;
                                    if (object != null) {
                                        ((DynamicIslandBackgroundView)((Object)object)).setVisibility(0);
                                    }
                                    DynamicIslandWindowViewController.access$getAppCloseRealIslandRect(dynamicIslandWindowViewController, DynamicIslandWindowViewController.access$getView(dynamicIslandWindowViewController).calculateCollapse(dynamicIslandContentView), dynamicIslandContentView, string, bl);
                                    DynamicIslandWindowView.updateViewStateWhenCloseEnd$default(DynamicIslandWindowViewController.access$getView(dynamicIslandWindowViewController), dynamicIslandContentView, bl, null, 4, null);
                                    DynamicIslandWindowViewController.access$getView(dynamicIslandWindowViewController).updateIslandWindowAnimRunningState(false, dynamicIslandContentView, bl);
                                    DynamicIslandWindowViewController.access$getView(dynamicIslandWindowViewController).onWindowAnimExtendLifetimeEnd(dynamicIslandContentView);
                                    if (bl) {
                                        DynamicIslandWindowViewController.access$getView(dynamicIslandWindowViewController).exitMiniWindow(dynamicIslandContentView);
                                        DynamicIslandWindowViewController.access$getView(dynamicIslandWindowViewController).enterMiniWindowEnd();
                                        continue;
                                    }
                                    if (o.c((Object)string2, (Object)"update_surface_info_finish")) {
                                        if (string == null || bl || o.c((Object)dynamicIslandWindowViewController.getTopActivityPkg(), (Object)string) || !DynamicIslandWindowViewController.access$hasAppState(dynamicIslandWindowViewController, string)) continue;
                                        DynamicIslandSafeguardsController.delayExitApp$default(dynamicIslandWindowViewController.getDynamicIslandSafeguardsController(), dynamicIslandWindowViewController.getTopActivityPkg(), false, 2, null);
                                        continue;
                                    }
                                    DynamicIslandWindowViewController.access$getView(dynamicIslandWindowViewController).appExit(dynamicIslandContentView);
                                }
                            }
                            DynamicIslandWindowViewController.setPositionValue$default(this.this$0, false, false, 2, null);
                            return s.a;
                        }
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                }, (int)3, null);
                return null;
            }
            case 6: {
                object = new /* invalid duplicate definition of identical inner class */;
                if (object3 == null) return null;
                object22 = ((DynamicIslandWindowView)this.getView()).requestHasIsland((String)object3);
                if (object22 == null) return null;
                object3 = object22.iterator();
                while (object3.hasNext()) {
                    object22 = (DynamicIslandContentView)((Object)object3.next());
                    if (object22 == null) continue;
                    object22.setWindowAnimState((WindowAnimState)object);
                }
                return null;
            }
            case 7: {
                this.cancelDelayOperate((String)object3);
                object22 = new /* invalid duplicate definition of identical inner class */;
                object = object3 != null ? ((DynamicIslandWindowView)this.getView()).requestHasIsland((String)object3) : null;
                if (object == null) return null;
                object3 = object.iterator();
                while (object3.hasNext()) {
                    object42 = (DynamicIslandContentView)((Object)object3.next());
                    object = object42 != null ? ((DynamicIslandBaseContentView)((Object)object42)).getState() : null;
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("sendWindowAnimEventForMiddle: currentState = ");
                    stringBuilder.append(object);
                    Log.d((String)"DynamicIslandAnimDebug", (String)stringBuilder.toString());
                    if (object42 != null) {
                        ((DynamicIslandBaseContentView)((Object)object42)).setWindowAnimState((WindowAnimState)object22);
                    }
                    object = object42 != null ? ((DynamicIslandBaseContentView)((Object)object42)).getState() : null;
                    if (object instanceof DynamicIslandState.MiniWindowExpanded) {
                        ((DynamicIslandWindowView)this.getView()).exitMiniWindow((DynamicIslandContentView)((Object)object42));
                        ((DynamicIslandWindowView)this.getView()).enterMiniWindowEnd();
                        object = ((DynamicIslandBaseContentView)((Object)object42)).getFakeView();
                        if (object == null) continue;
                        ((DynamicIslandContentFakeView)((Object)object)).setClosingAppFromFreeform(true);
                        continue;
                    }
                    object = object42 != null ? ((DynamicIslandBaseContentView)((Object)object42)).getState() : null;
                    if (!(object instanceof DynamicIslandState.AppExpanded)) continue;
                    ((DynamicIslandWindowView)this.getView()).appExit((DynamicIslandContentView)((Object)object42));
                }
                return null;
            }
            case 8: {
                object22 = new /* invalid duplicate definition of identical inner class */;
                if (object3 == null) return null;
                object = ((DynamicIslandWindowView)this.getView()).requestHasIsland((String)object3);
                if (object == null) return null;
                Iterator iterator = object.iterator();
                while (iterator.hasNext()) {
                    object42 = (DynamicIslandContentView)((Object)iterator.next());
                    object = object42 != null ? ((DynamicIslandBaseContentView)((Object)object42)).getWindowAnimState() : null;
                    if (!o.c((Object)this.topActivityPkg, object3) && this.hasAppState((String)object3) && object instanceof WindowAnimState.Opened) {
                        DynamicIslandSafeguardsController.delayExitApp$default(this.dynamicIslandSafeguardsController, this.topActivityPkg, false, 2, null);
                    }
                    if (object42 == null) continue;
                    ((DynamicIslandBaseContentView)((Object)object42)).setWindowAnimState((WindowAnimState)object22);
                }
                return null;
            }
            case 2: 
        }
        object = o.c((Object)object, (Object)"open_app_start") ? new /* invalid duplicate definition of identical inner class */ : (o.c((Object)object, (Object)"open_app_no_anim") ? new /* invalid duplicate definition of identical inner class */ : null);
        if (object != null && object3 != null && (object22 = ((DynamicIslandWindowView)this.getView()).requestHasIsland((String)object3)) != null) {
            for (Object object22 : object22) {
                if (object22 == null) continue;
                object22.setWindowAnimState((WindowAnimState)object);
            }
        }
        DynamicIslandWindowViewController.setPositionValue$default(this, false, false, 2, null);
        return null;
    }

    private final void setCancelTimeout(DynamicIslandData object, IslandTemplate object2) {
        if (((IslandTemplate)object2).getIslandTimeout() != 0) {
            this.dynamicIslandSafeguardsController.delayDeleted(object.getKey(), ((IslandTemplate)object2).getIslandTimeout());
        } else {
            object2 = this.dynamicIslandSafeguardsController;
            String string = object.getKey();
            long l2 = (object = object.getProperties()) != null && (Integer)object == 0 ? 5L : 3600L;
            ((DynamicIslandSafeguardsController)object2).delayDeleted(string, l2);
        }
    }

    private final void setPositionValue(boolean bl, boolean bl2) {
        this.requestPosition = bl;
        this.requestPositionByClosePosition = bl2;
    }

    public static /* synthetic */ void setPositionValue$default(DynamicIslandWindowViewController dynamicIslandWindowViewController, boolean bl, boolean bl2, int n, Object object) {
        if ((n & 2) != 0) {
            bl2 = false;
        }
        dynamicIslandWindowViewController.setPositionValue(bl, bl2);
    }

    /*
     * Enabled aggressive block sorting
     */
    private final void setScenarioState(String string, boolean bl) {
        int n = -1;
        switch (string.hashCode()) {
            case 1626083599: {
                if (!string.equals("open_app_start")) break;
                n = 1;
                break;
            }
            case -306701112: {
                if (!string.equals("open_app_end")) break;
                n = 2;
                break;
            }
            case -1135179971: {
                if (!string.equals("close_app_start")) break;
                n = 3;
                break;
            }
            case -1543092618: {
                if (!string.equals("close_app_end")) break;
                n = 4;
                break;
            }
        }
        switch (n) {
            default: {
                return;
            }
            case 1: {
                if (bl) {
                    DynamicIslandScenarioUtils.INSTANCE.setDynamicIslandScenarioState(360L, true);
                    return;
                }
                DynamicIslandScenarioUtils.INSTANCE.setDynamicIslandScenarioState(358L, true);
                return;
            }
            case 2: {
                if (bl) {
                    DynamicIslandScenarioUtils.INSTANCE.setDynamicIslandScenarioState(360L, false);
                    return;
                }
                DynamicIslandScenarioUtils.INSTANCE.setDynamicIslandScenarioState(358L, false);
                return;
            }
            case 3: {
                if (bl) {
                    DynamicIslandScenarioUtils.INSTANCE.setDynamicIslandScenarioState(361L, true);
                    return;
                }
                DynamicIslandScenarioUtils.INSTANCE.setDynamicIslandScenarioState(359L, true);
                return;
            }
            case 4: 
        }
        if (bl) {
            DynamicIslandScenarioUtils.INSTANCE.setDynamicIslandScenarioState(361L, false);
            return;
        }
        DynamicIslandScenarioUtils.INSTANCE.setDynamicIslandScenarioState(359L, false);
    }

    private final void statusBarAppearance(boolean bl) {
        this.windowState.setTempHiddenType(DynamicIslandWindowState.TempHiddenType.STATUS_BAR_DISAPPEARANCE);
        this.windowState.getStatusBarDisappearance().setValue((Object)bl);
        ((DynamicIslandWindowView)this.getView()).updateStatusBarVisible(bl ^ true);
    }

    private final void statusBarVisible(Bundle object) {
        boolean bl = object.getBoolean("extra_status_bar_window_visible");
        this.statusBarAppearance(bl ^ true);
        object = new StringBuilder();
        ((StringBuilder)object).append("visible: ");
        ((StringBuilder)object).append(bl);
        Log.d((String)TAG, (String)((StringBuilder)object).toString());
    }

    private final void updateChronometerEffect(StatusBarNotification object, boolean bl) {
        if (CommonUtils.NOT_SUPPORT_TEXT_EFFECT) {
            return;
        }
        object = (NotificationTimeKeeper)this.getNotificationChronometerManager().getTimeKeeperMap().get(object.getKey());
        if (object != null && (object = object.getChronometerVisibleMap()) != null) {
            Iterator iterator = object.entrySet().iterator();
            while (iterator.hasNext()) {
                object = iterator.next().getKey();
                object = object instanceof HyperChronometer ? (HyperChronometer)object : null;
                if (object == null) continue;
                object.enableEffect(bl);
            }
        }
    }

    private final void updateFlipResources() {
        if (CommonUtils.isFlipDevice()) {
            boolean bl = this.windowState.isTinyScreen();
            int n = bl ? DynamicIslandUtils.INSTANCE.getTinyScreenInsetLeft() : 0;
            int n2 = bl ? DynamicIslandUtils.INSTANCE.getTinyScreenInsetRight() : 0;
            int n3 = bl ? DynamicIslandUtils.INSTANCE.getTinyScreenInsetTop() : 0;
            int n4 = bl ? DynamicIslandUtils.INSTANCE.getTinyScreenInsetBottom() : 0;
            ((DynamicIslandWindowView)this.getView()).setPadding(n, 0, n2, 0);
            float f2 = this.getIslandMaxWidth();
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("update flip setPadding ");
            stringBuilder.append(n);
            stringBuilder.append(" ");
            stringBuilder.append(n3);
            stringBuilder.append(" ");
            stringBuilder.append(n2);
            stringBuilder.append(" ");
            stringBuilder.append(n4);
            stringBuilder.append(" islandMaxWidth=");
            stringBuilder.append(f2);
            Log.d((String)TAG, (String)stringBuilder.toString());
        }
    }

    private final void updateLottieAnimState(StatusBarNotification object, boolean bl) {
        if (CommonUtils.NOT_SUPPORT_LOTTIE) {
            return;
        }
        if (!object.getNotification().extras.getBoolean("miui.focus.lottieView.isPlay")) {
            return;
        }
        object = (LottieProgressManager.LottieProgressSyncHelper)((LottieProgressManager)this.lottieProgressManager.get()).getLottieProgressMap().get(object.getKey());
        object = object != null ? object.getLottieSceneMap() : null;
        for (String string : m.j((Object[])new String[]{"lottie_focus_notification", "lottie_focus_notification_dark", "lottie_focus_notification_modal", "lottie_focus_notification_modal_dark"})) {
            string = object != null ? (LottieAnimationView)object.get(string) : null;
            if (bl) {
                if (string == null) continue;
                string.playAnimation();
                continue;
            }
            if (string == null) continue;
            string.pauseAnimation();
        }
    }

    public final void addAppCloseRect(String string, Rect rect) {
        if (rect != null) {
            this.appCloseKey = string;
            string = this.appCloseRect.put(string, rect);
        }
    }

    public void addDynamicIslandGlowEffectLayer(DynamicIslandGlowEffectLayer dynamicIslandGlowEffectLayer) {
        o.g((Object)dynamicIslandGlowEffectLayer, (String)"glowEffectLayer");
        this.dynamicIslandGlowEffectLayer = dynamicIslandGlowEffectLayer;
    }

    public final void addDynamicIslandTimeoutRemovedCallback(DynamicIslandCallback dynamicIslandCallback) {
        o.g((Object)dynamicIslandCallback, (String)"callback");
        this.dynamicIslandCallback = dynamicIslandCallback;
    }

    public void addDynamicIslandView(DynamicIslandData object, boolean bl) {
        o.g((Object)object, (String)"dynamicIslandData");
        Object object2 = this.islandData.get(object.getKey());
        Object object3 = new StringBuilder();
        ((StringBuilder)object3).append("addDynamicIslandView ,key: ");
        ((StringBuilder)object3).append(object2);
        ((StringBuilder)object3).append(" expand:");
        ((StringBuilder)object3).append(bl);
        Log.d((String)TAG, (String)((StringBuilder)object3).toString());
        object3 = object.getExtras();
        if (object3 != null) {
            object3.putString("miui.key", object.getKey());
        }
        if (this.requestMaxWidth((DynamicIslandData)object, bl)) {
            return;
        }
        IslandTemplate islandTemplate = this.getIslandTemplate((DynamicIslandData)object);
        if (islandTemplate == null) {
            object = object.getKey();
            o.d((Object)object);
            this.removeDynamicIslandView((String)object);
            Log.e((String)TAG, (String)"addDynamicIslandView: template is null");
            return;
        }
        object3 = object.getPriority();
        int n = 1;
        int n2 = object3 != null ? (Integer)object3 : 1;
        object3 = object.getProperties();
        if (object3 != null) {
            n = (Integer)object3;
        }
        object2 = islandTemplate.getIslandPriority();
        object3 = object2;
        if (object2 == null) {
            object3 = n2;
        }
        object.setPriority((Integer)object3);
        object2 = islandTemplate.getIslandProperty();
        object3 = object2;
        if (object2 == null) {
            object3 = n;
        }
        object.setProperties((Integer)object3);
        object3 = object.getProperties();
        if (object3 != null && (Integer)object3 == 0 && ((Boolean)this.windowState.getMiPlayShow().getValue()).booleanValue()) {
            return;
        }
        if (CommonUtils.INSTANCE.getIS_TABLET() && ((Boolean)this.windowState.getKidSpaceShow().getValue()).booleanValue() && ((object3 = object.getProperties()) == null || (Integer)object3 != 0)) {
            return;
        }
        if (this.checkFlipTiny(object.getProperties())) {
            Log.d((String)TAG, (String)"addDynamicIslandView: skip in flip tiny");
            return;
        }
        DynamicIslandWindowView.addDynamicIslandData$default((DynamicIslandWindowView)this.getView(), object, bl, this.getIslandMaxWidth(), this.getCutoutY(), false, 16, null);
        object3 = object.getKey();
        if (object3 != null) {
            object3 = this.islandData.put((String)object3, (DynamicIslandData)object);
        }
        if (bl) {
            this.dynamicIslandSafeguardsController.cancelDelayCollapsed();
            if (islandTemplate.getExpandedTime() != 0) {
                this.dynamicIslandSafeguardsController.delayCollapsed(islandTemplate.getExpandedTime());
            } else {
                this.dynamicIslandSafeguardsController.delayCollapsed(5L);
            }
        }
        this.setCancelTimeout((DynamicIslandData)object, islandTemplate);
    }

    public final void addLottieAnimView(DynamicIslandContentView dynamicIslandContentView, DynamicIslandBaseContentView dynamicIslandBaseContentView, String string) {
        Object object;
        if (dynamicIslandContentView == null || (object = dynamicIslandContentView.getCurrentIslandData()) == null || (object = object.getProperties()) == null || object.intValue() != 0) {
            LottieProgressManager lottieProgressManager = (LottieProgressManager)this.lottieProgressManager.get();
            int n = R.id.island_lottie;
            FrameLayout frameLayout = null;
            object = dynamicIslandContentView != null ? dynamicIslandContentView.getBigIslandView() : null;
            dynamicIslandContentView = dynamicIslandContentView != null ? dynamicIslandContentView.getSmallIslandView() : null;
            FrameLayout frameLayout2 = dynamicIslandBaseContentView != null ? dynamicIslandBaseContentView.getFakeBigIsland() : null;
            if (dynamicIslandBaseContentView != null) {
                frameLayout = dynamicIslandBaseContentView.getFakeSmallIsland();
            }
            lottieProgressManager.addIslandLottie(string, n, (View)object, (View)dynamicIslandContentView, (View)frameLayout2, (View)frameLayout);
        }
    }

    public void addOnDynamicIslandViewChangedListener(DynamicIslandContent.DynamicIslandViewChangedListener dynamicIslandViewChangedListener) {
        o.g((Object)dynamicIslandViewChangedListener, (String)"listener");
        this.listener = dynamicIslandViewChangedListener;
        ((DynamicIslandWindowView)this.getView()).addOnDynamicIslandViewChangedListener(dynamicIslandViewChangedListener);
    }

    public final void calculateAppClosePosition(String string, boolean bl) {
        List<DynamicIslandContentView> list = string != null ? ((DynamicIslandWindowView)this.getView()).requestHasIsland(string) : null;
        if (list != null) {
            for (DynamicIslandContentView dynamicIslandContentView : list) {
                if (bl ? !((list = dynamicIslandContentView != null ? dynamicIslandContentView.getState() : null) instanceof DynamicIslandState.MiniWindowExpanded) && !((list = dynamicIslandContentView != null ? dynamicIslandContentView.getState() : null) instanceof DynamicIslandState.Expanded) : !((list = dynamicIslandContentView != null ? dynamicIslandContentView.getState() : null) instanceof DynamicIslandState.AppExpanded) && !((list = dynamicIslandContentView != null ? dynamicIslandContentView.getState() : null) instanceof DynamicIslandState.Expanded)) continue;
                list = ((DynamicIslandWindowView)this.getView()).calculateCollapse(dynamicIslandContentView);
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("newState = ");
                stringBuilder.append(list);
                Log.d((String)"DynamicIslandAnimDebug", (String)stringBuilder.toString());
                this.getAppCloseRealIslandRect((DynamicIslandState)((Object)list), dynamicIslandContentView, string, bl);
            }
        }
    }

    public final boolean canEnterAppState(DynamicIslandContentView object) {
        String string = null;
        String string2 = object != null ? ((DynamicIslandBaseContentView)((Object)object)).getPkgName() : null;
        String string3 = string;
        if (object != null) {
            object = ((DynamicIslandBaseContentView)((Object)object)).getTemplate();
            string3 = string;
            if (object != null) {
                string3 = ((IslandTemplate)object).getBusiness();
            }
        }
        boolean bl = !o.c(string3, (Object)"face_recognition") && !o.c((Object)string2, (Object)"com.miui.personalassistant") && !o.c((Object)string2, (Object)"com.miui.mishare.connectivity") && !o.c((Object)string2, (Object)"com.xiaomi.aon");
        return bl;
    }

    public final void controlCenterExpanded(boolean bl) {
        this.windowState.setTempHiddenType(DynamicIslandWindowState.TempHiddenType.CONTROL_CENTER_EXPANDED);
        this.windowState.getControlCenterExpanded().setValue((Object)bl);
        if (!CommonUtils.INSTANCE.getIS_TABLET()) {
            ((DynamicIslandWindowView)this.getView()).collapse("cc expand");
        }
        ((DynamicIslandWindowView)this.getView()).updateAppAnimatingView(bl);
    }

    public final void controlCenterPanelExpandHeightChanged(i i2) {
        o.g((Object)i2, (String)"expandHeightAndThresh");
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("controlCenterPanelExpandHeightChanged expandHeightAndThresh:");
        stringBuilder.append(i2);
        Log.d((String)TAG, (String)stringBuilder.toString());
        this.windowState.getNotificationPanelHeightChanging().setValue((Object)Boolean.FALSE);
        float f2 = ((Number)i2.d()).floatValue();
        boolean bl = true;
        if (f2 == 0.0f || ((Number)i2.d()).floatValue() == ((Number)i2.e()).floatValue()) {
            stringBuilder = this.controlCenterPanelHeightChangingJob;
            if (stringBuilder != null) {
                l0.a.a((l0)stringBuilder, null, (int)1, null);
            }
            this.controlCenterPanelHeightChangingJob = f.b((f1.E)this.uiScopeImmediate, null, null, (U0.o)new U0.o(this, null){
                int label;
                final DynamicIslandWindowViewController this$0;
                {
                    this.this$0 = dynamicIslandWindowViewController;
                    super(2, d2);
                }

                public final K0.d create(Object object, K0.d d2) {
                    return new /* invalid duplicate definition of identical inner class */;
                }

                public final Object invoke(f1.E e2, K0.d d2) {
                    return (this.create(e2, d2)).invokeSuspend(s.a);
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
                        this.label = 1;
                        if (M.b((long)1000L, (K0.d)this) == object2) {
                            return object2;
                        }
                    }
                    Log.d((String)"DynamicIslandWindowViewController", (String)"controlCenterPanelExpandHeightChanged Completed");
                    this.this$0.getWindowState().getControlCenterPanelHeightChanging().setValue((Object)b.a((boolean)false));
                    return s.a;
                }
            }, (int)3, null);
        } else {
            stringBuilder = this.controlCenterPanelHeightChangingJob;
            if (stringBuilder != null) {
                l0.a.a((l0)stringBuilder, null, (int)1, null);
            }
            this.windowState.getControlCenterPanelHeightChanging().setValue((Object)Boolean.TRUE);
        }
        this.windowState.setTempHiddenType(DynamicIslandWindowState.TempHiddenType.CONTROL_CENTER_SWIPE_TO_APPEARANCE);
        stringBuilder = this.windowState.getControlCenterPanelSwipeToAppearance();
        if (!(((Number)i2.d()).floatValue() > ((Number)i2.e()).floatValue() / (float)20)) {
            bl = false;
        }
        stringBuilder.setValue(bl);
    }

    public final void destroy() {
        if (this.isRegisteredCollapsedReceiver) {
            this.isRegisteredCollapsedReceiver = false;
            this.getContext().unregisterReceiver(this.collapsedReceiver);
        }
        if (this.packagesBroadcastRegistered) {
            this.packagesBroadcastRegistered = false;
            this.getContext().unregisterReceiver(this.packagesBroadcastReceiver);
        }
        if (this.miPlayShowStateChangedBroadcastRegistered) {
            this.miPlayShowStateChangedBroadcastRegistered = false;
            this.getContext().unregisterReceiver(this.miPlayShowStateChangedBroadcastReceiver);
        }
        this.dynamicIslandDesktopStateController.stop();
        DeviceStateManagerCompat.INSTANCE.unregisterCallbackCompat(this.deviceStateManager, this.foldStateListener);
        this.autoDensityController.removeOnDensityChangeListener((AutoDensityController.OnDensityChangeListener)this);
        TaskStackChangeListeners.getInstance().unregisterTaskStackListener(this.taskStackListener);
        AppIconsManager.INSTANCE.clearAllIconCache();
        DynamicIslandEventTracker.Companion.clearAppNameCache();
        this.contentResolver.unregisterContentObserver((ContentObserver)this.settingsObserver);
        this.superSaveModeController.removeCallback((SuperSaveModeController.SuperSaveModeChangeListener)this.superSaveModeChangeListener);
        this.shadeSwitchController.removeOnShadeSwitchChangedListener((ShadeSwitchController.OnShadeSwitchChangedListener)this.shadeSwitchControlListener);
    }

    public final int getAppAnimSmallX() {
        return this.appAnimSmallX;
    }

    public final String getAppCloseKey() {
        return this.appCloseKey;
    }

    public final HashMap<String, Rect> getAppCloseRect() {
        return this.appCloseRect;
    }

    public final float getBatteryWidth() {
        return (this.sizeRepository.getIslandWidthParams().getValue()).getBatteryWidth();
    }

    public final y getChildren() {
        return this.children;
    }

    public final float getClockWidth() {
        return (this.sizeRepository.getIslandWidthParams().getValue()).getClockWidth();
    }

    public final y getContentViews() {
        return this.contentViews;
    }

    public final int getCurrentHeight() {
        return this.currentHeight;
    }

    public final float getCutoutY() {
        return ((Number)this.sizeRepository.getCutoutY().getValue()).floatValue();
    }

    public final int getDisplayOrientation() {
        return this.displayOrientation;
    }

    public final DynamicIslandCallback getDynamicIslandCallback() {
        return this.dynamicIslandCallback;
    }

    public final DynamicIslandSafeguardsController getDynamicIslandSafeguardsController() {
        return this.dynamicIslandSafeguardsController;
    }

    public final I getFreeformAnimRegion() {
        return this.freeformAnimRegion;
    }

    public final b.a getHyperDropInfoNotifierService() {
        return this.hyperDropInfoNotifierService;
    }

    public final HashMap<String, Boolean> getInSmallWindowMap() {
        return this.inSmallWindowMap;
    }

    public final K0.g getInflateContext() {
        return this.inflateContext;
    }

    public final f1.E getIoScope() {
        return this.ioScope;
    }

    public final float getIslandMaxWidth() {
        return (this.sizeRepository.getIslandWidthParams().getValue()).getMaxWidth();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final IslandTemplate getIslandTemplate(DynamicIslandData object) {
        Exception exception2;
        block2: {
            d d2;
            try {
                d2 = new d();
                object = object != null ? object.getTickerData() : null;
            }
            catch (Exception exception2) {
                break block2;
            }
            return (IslandTemplate)d2.j((String)object, IslandTemplate.class);
        }
        object = new StringBuilder();
        ((StringBuilder)object).append("getIslandTemplate: ");
        ((StringBuilder)object).append(exception2);
        Log.e((String)TAG, (String)((StringBuilder)object).toString());
        return null;
    }

    public final int getLastDisplayOrientation() {
        return this.lastDisplayOrientation;
    }

    public final String getLastTopActivityPkg() {
        return this.lastTopActivityPkg;
    }

    public final a getLottieProgressManager() {
        return this.lottieProgressManager;
    }

    public final int getStatusBarDatePosX() {
        return ((Number)this.sizeRepository.getStatusBarDatePosX().getValue()).intValue();
    }

    public final boolean getSupportMediaFreeform() {
        return this.supportMediaFreeform;
    }

    public final String getTopActivityPkg() {
        return this.topActivityPkg;
    }

    public final DelayableExecutor getUiExecutor() {
        return this.uiExecutor;
    }

    public final K0.g getUiImmediateContext() {
        return this.uiImmediateContext;
    }

    public final f1.E getUiScope() {
        return this.uiScope;
    }

    public final f1.E getUiScopeImmediate() {
        return this.uiScopeImmediate;
    }

    public final DynamicIslandWindowState getWindowState() {
        return this.windowState;
    }

    public final i1.u get_isAppAnimRunning() {
        return this._isAppAnimRunning;
    }

    public final i1.u get_isFreeformAnimRunning() {
        return this._isFreeformAnimRunning;
    }

    /*
     * Could not resolve type clashes
     * Unable to fully structure code
     */
    public Bundle handleDynamicIsland(Bundle var1_1) {
        block66: {
            o.g((Object)var1_1, (String)"bundle");
            var11_2 /* !! */  = var1_1.getString("action_key");
            var12_3 = new StringBuilder();
            var12_3.append("handleDynamicIsland: ");
            var12_3.append((String)var11_2 /* !! */ );
            Log.d((String)"DynamicIslandWindowViewController", (String)var12_3.toString());
            var12_3 = new Bundle();
            if (var11_2 /* !! */  == null) break block66;
            var5_4 /* !! */  = var11_2 /* !! */ .hashCode();
            var9_5 = false;
            var6_6 /* !! */  = 0;
            var7_7 = false;
            switch (var5_4 /* !! */ ) {
                default: {
                    break;
                }
                case 2025487220: {
                    if (!var11_2 /* !! */ .equals("action_request_need_return_island")) break;
                    var8_8 = FoldUtils.INSTANCE.isFoldScreenLayoutLarge(this.getView());
                    var1_1 = CommonUtils.INSTANCE;
                    var11_2 /* !! */  = ((DynamicIslandWindowView)this.getView()).getContext();
                    o.f((Object)var11_2 /* !! */ , (String)"getContext(...)");
                    if (var1_1.getInVerticalMode((Context)var11_2 /* !! */ ) || var8_8) {
                        var7_7 = true;
                    }
                    var12_3.putBoolean("extra_need_return_island", var7_7);
                    break;
                }
                case 1786126183: {
                    if (!var11_2 /* !! */ .equals("action_bouncer_showing")) break;
                    var7_7 = var1_1.getBoolean("extra_bouncer_showing");
                    this.windowState.setTempHiddenType(DynamicIslandWindowState.TempHiddenType.BOUNCER_SHOWING);
                    this.windowState.getBouncerShowing().setValue((Object)var7_7);
                    this.getExternalStateRepository().notifyBouncerIsOrWillBeShowing(var7_7);
                    var1_1 = new StringBuilder();
                    var1_1.append("bouncerIsOrWillBeShowing: ");
                    var1_1.append(var7_7);
                    Log.d((String)"DynamicIslandWindowViewController", (String)var1_1.toString());
                    break;
                }
                case 1708099977: {
                    if (!var11_2 /* !! */ .equals("action_update_light")) break;
                    var7_7 = var1_1.getBoolean("extra_is_light");
                    var1_1 = new StringBuilder();
                    var1_1.append("handleDynamicIsland: isLight ");
                    var1_1.append(var7_7);
                    Log.d((String)"DynamicIslandWindowViewController", (String)var1_1.toString());
                    ((DynamicIslandWindowView)this.getView()).updateDarkLightMode(var7_7);
                    break;
                }
                case 1648189172: {
                    if (!var11_2 /* !! */ .equals("action_external_touch")) break;
                    var11_2 /* !! */  = (MotionEvent)var1_1.getParcelable("extra_motion_event", MotionEvent.class);
                    if (var11_2 /* !! */  != null) {
                        if ((var1_1 = var1_1.getString("extra_motion_event_source")) != null) {
                            var12_3.putInt("extra_motion_event_result", TouchEvent.Companion.getToInt(this.getExternalTouchHandler().handleExternalTouch((MotionEvent)var11_2 /* !! */ , (String)var1_1)));
                            break;
                        }
                        throw new IllegalStateException("handling null motion event source.");
                    }
                    throw new IllegalStateException("handling null motion event.");
                }
                case 1372849839: {
                    if (!var11_2 /* !! */ .equals("action_cutout_y")) break;
                    var2_15 = var3_12 = var1_1.getFloat("extra_cutout_y");
                    if (FlipUtils.isFlip()) {
                        var2_15 = var3_12 + (float)DynamicIslandUtils.INSTANCE.getTinyScreenInsetTop();
                    }
                    this.sizeRepository.updateCutoutY(var2_15);
                    break;
                }
                case 1194338499: {
                    if (!var11_2 /* !! */ .equals("action_keyguard_going_away")) break;
                    var7_7 = var1_1.getBoolean("extra_keyguard_going_away");
                    this.getExternalStateRepository().notifyKeyguardGoingAway(var7_7);
                    var1_1 = new StringBuilder();
                    var1_1.append("isKeyguardGoingAway: ");
                    var1_1.append(var7_7);
                    Log.d((String)"DynamicIslandWindowViewController", (String)var1_1.toString());
                    break;
                }
                case 1043971575: {
                    if (!var11_2 /* !! */ .equals("action_external_intercept")) break;
                    var11_2 /* !! */  = (MotionEvent)var1_1.getParcelable("extra_motion_event", MotionEvent.class);
                    if (var11_2 /* !! */  != null) {
                        if ((var1_1 = var1_1.getString("extra_motion_event_source")) != null) {
                            var12_3.putInt("extra_motion_event_result", TouchEvent.Companion.getToInt(this.getExternalTouchHandler().handleExternalIntercept((MotionEvent)var11_2 /* !! */ , (String)var1_1)));
                            break;
                        }
                        throw new IllegalStateException("handling null motion event source.");
                    }
                    throw new IllegalStateException("handling null motion event.");
                }
                case 1030867718: {
                    if (!var11_2 /* !! */ .equals("action_notification_panel_expand_height")) break;
                    var3_13 = var1_1.getFloat("extra_notification_panel_expanded_height");
                    var2_16 = var1_1.getFloat("extra_notification_panel_expanded_height_thresh");
                    if (!CommonUtils.INSTANCE.getIS_TABLET()) break;
                    this.notificationPanelExpandHeightChanged(var3_13, var2_16);
                    break;
                }
                case 793172543: {
                    if (!var11_2 /* !! */ .equals("action_pending_top_activity_changed")) break;
                    var11_2 /* !! */  = var1_1.getString("extra_pending_task", "");
                    var9_5 = var1_1.getBoolean("extra_pending_free_form");
                    var7_7 = var1_1.getBoolean("extra_pending_pip");
                    var8_9 = var1_1.getBoolean("extra_is_pending_task", true);
                    var13_18 /* !! */  = this.fullScreenPkg;
                    var1_1 = var1_1.getString("extra_last_full_screen_activity_pkg", "");
                    o.f((Object)var1_1, (String)"getString(...)");
                    var13_18 /* !! */ .setValue(var1_1);
                    var1_1 = (DynamicIslandWindowView)this.getView();
                    o.d((Object)var11_2 /* !! */ );
                    var1_1 = var1_1.requestHasIsland((String)var11_2 /* !! */ );
                    var5_4 /* !! */  = !(TextUtils.isEmpty((CharSequence)var11_2 /* !! */ ) || o.c((Object)var11_2 /* !! */ , (Object)this.topActivityPkg) || var8_9 && (var1_1 == null || var1_1.isEmpty())) ? 0 : 1;
                    var13_18 /* !! */  = this.topActivityPkg;
                    var14_23 = new StringBuilder();
                    var14_23.append("handleDynamicIsland: top = ");
                    var14_23.append((String)var13_18 /* !! */ );
                    var14_23.append(" pending = ");
                    var14_23.append((String)var11_2 /* !! */ );
                    var14_23.append(" hasIsland = ");
                    var14_23.append(var1_1);
                    Log.d((String)"DynamicIslandWindowViewController", (String)var14_23.toString());
                    var1_1 = var5_4 /* !! */  == 0 ? var11_2 /* !! */  : null;
                    if (var1_1 != null) {
                        var1_1 = new ComponentName((String)var1_1, "");
                        if (var8_9) {
                            this.onTopActivityChange((ComponentName)var1_1, var9_5, var7_7, true, true);
                            this.isPendingTopChanged = true;
                            break;
                        }
                        if (var8_9 || !this.isPendingTopChanged) break;
                        this.onTopActivityChange((ComponentName)var1_1, var9_5, var7_7, true, false);
                        this.isPendingTopChanged = false;
                        break;
                    }
                    this.isPendingTopChanged = false;
                    var1_1 = s.a;
                    break;
                }
                case 753129046: {
                    if (!var11_2 /* !! */ .equals("action_immersive_status_insets")) break;
                    var7_7 = var1_1.getBoolean("extra_action_immersive_status_insets", true);
                    this.windowState.getStatusBarWindowsInsetsShow().setValue((Object)var7_7);
                    break;
                }
                case 578578045: {
                    if (!var11_2 /* !! */ .equals("action_command_queue_disable")) break;
                    var5_4 /* !! */  = var1_1.getInt("extra_command_queue_disable_1");
                    var6_6 /* !! */  = var1_1.getInt("extra_command_queue_disable_2");
                    this.commandQueueDisable(var5_4 /* !! */ );
                    this.getExternalStateRepository().notifyCommandQueueDisableChanged(new i((Object)var5_4 /* !! */ , (Object)var6_6 /* !! */ ));
                    break;
                }
                case 513596501: {
                    if (!var11_2 /* !! */ .equals("action_update_island_dimen_data")) break;
                    var6_6 /* !! */  = var1_1.getInt("expanded_island_width");
                    var5_4 /* !! */  = var1_1.getInt("heads_up_status_bar_padding");
                    this.sizeRepository.updateExpandedIslandWidth(var6_6 /* !! */ );
                    this.sizeRepository.updateHeadsUpStatusBarPadding(var5_4 /* !! */ );
                    var1_1 = new StringBuilder();
                    var1_1.append("handleDynamicIsland: action_update_island_dimen_data: expandedIslandWidth\uff1a");
                    var1_1.append(var6_6 /* !! */ );
                    var1_1.append(", headsUpStatusBarPadding\uff1a");
                    var1_1.append(var5_4 /* !! */ );
                    Log.d((String)"DynamicIslandWindowViewController", (String)var1_1.toString());
                    break;
                }
                case 468393469: {
                    if (!var11_2 /* !! */ .equals("action_enter_modal")) break;
                    var7_7 = var1_1.getBoolean("extra_modal_to_focus", false);
                    var1_1 = var1_1.getString("extra_modal_focus_shift_key");
                    ((LottieProgressManager)this.lottieProgressManager.get()).focusModalShift((String)var1_1, var7_7);
                    break;
                }
                case 403534581: {
                    if (!var11_2 /* !! */ .equals("action_full_screen_update")) break;
                    var11_2 /* !! */  = ((DynamicIslandWindowView)this.getView()).getEventCoordinator();
                    var11_2 /* !! */  = var11_2 /* !! */  != null ? var11_2 /* !! */ .getLastFullScreenActivityPkg() : null;
                    var1_1 = var1_1.getString("extra_last_full_screen_activity_pkg", (String)var11_2 /* !! */ );
                    var11_2 /* !! */  = ((DynamicIslandWindowView)this.getView()).getEventCoordinator();
                    if (var11_2 /* !! */  == null) break;
                    o.d((Object)var1_1);
                    var11_2 /* !! */ .setLastFullScreenActivityPkg((String)var1_1);
                    break;
                }
                case 348121011: {
                    if (!var11_2 /* !! */ .equals("action_request_has_island")) break;
                    var11_2 /* !! */  = var1_1.getString("extra_pkg");
                    var5_4 /* !! */  = var1_1.getInt("miui.user.id");
                    var13_19 = var1_1.getString("extra_request_reason");
                    var7_7 = o.c((Object)var13_19, (Object)"extra_reason_return_from_miniwindow") != false ? o.c((Object)this.fullScreenPkg.getValue(), (Object)var11_2 /* !! */ ) : (o.c((Object)var13_19, (Object)"extra_reason_return_from_app") != false ? this.isInMiniWindow((String)var11_2 /* !! */ , var5_4 /* !! */ ) : false);
                    if (var7_7) {
                        var1_1 = new StringBuilder();
                        var1_1.append("handleDynamicIsland: not back to island: ");
                        var1_1.append((String)var11_2 /* !! */ );
                        Log.i((String)"DynamicIslandWindowViewController", (String)var1_1.toString());
                        var12_3.putBoolean("extra_has_island", false);
                        return var12_3;
                    }
                    var10_24 = this.windowState.isAdaptDesktopAnimation(this.getContext());
                    var8_10 = ((DynamicIslandWindowView)this.getView()).getMainAppExpanded() != null;
                    if (var11_2 /* !! */  != null) {
                        var7_7 = ((DynamicIslandWindowView)this.getView()).getMainMiniWindow((String)var11_2 /* !! */ ) != null;
                        var1_1 = var7_7;
                    } else {
                        var1_1 = null;
                    }
                    this.isMiniState = var1_1;
                    if (this.isWorkbenchModeEnabled() || CommonUtils.INSTANCE.getIS_TABLET() && o.c((Object)var13_19, (Object)"extra_reason_return_from_miniwindow")) ** GOTO lbl261
                    if (var11_2 /* !! */  != null && (var1_1 = ((DynamicIslandWindowView)this.getView()).requestHasIsland((String)var11_2 /* !! */ )) != null) {
                        if (var1_1.isEmpty()) {
                            while (true) {
                                var7_7 = false;
                                break;
                            }
                        } else {
                            var11_2 /* !! */  = var1_1.iterator();
                            do {
                                if (!var11_2 /* !! */ .hasNext()) ** continue;
                            } while ((var5_4 /* !! */  = (var1_1 = (var13_19 = (DynamicIslandContentView)var11_2 /* !! */ .next()) != null ? var13_19.getState() : null) instanceof DynamicIslandState.SubAppExpanded == false && (var1_1 = var13_19 != null ? var13_19.getState() : null) instanceof DynamicIslandState.SubMiniWindowExpanded == false ? 1 : 0) == 0);
                            var7_7 = true;
                        }
                        var1_1 = var7_7;
                    } else {
                        var1_1 = null;
                    }
                    if (var1_1 == null) ** GOTO lbl239
                    if (!var10_24 || !o.c((Object)this.isMiniState, (Object)Boolean.TRUE) || !var8_10) ** GOTO lbl231
                    var7_7 = var1_1.booleanValue();
                    ** GOTO lbl237
lbl231:
                    // 1 sources

                    var7_7 = var9_5;
                    if (!var1_1.booleanValue()) ** GOTO lbl237
                    if (!var10_24) ** GOTO lbl236
                    var7_7 = var9_5;
                    if (var8_10) ** GOTO lbl237
lbl236:
                    // 2 sources

                    var7_7 = true;
lbl237:
                    // 4 sources

                    var11_2 /* !! */  = var7_7;
                    ** GOTO lbl240
lbl239:
                    // 1 sources

                    var11_2 /* !! */  = null;
lbl240:
                    // 2 sources

                    var13_19 = new StringBuilder();
                    var13_19.append("handleDynamicIsland: hasIsland ");
                    var13_19.append(var1_1);
                    var13_19.append(" ");
                    var13_19.append(var10_24);
                    var13_19.append(" ");
                    var13_19.append(var8_10);
                    var13_19.append(" hasIslandResult: ");
                    var13_19.append(var11_2 /* !! */ );
                    Log.d((String)"DynamicIslandWindowViewController", (String)var13_19.toString());
                    var12_3.putBoolean("extra_has_island", o.c((Object)var11_2 /* !! */ , (Object)Boolean.TRUE));
                    break;
lbl261:
                    // 1 sources

                    var12_3.putBoolean("extra_has_island", false);
                    break;
                }
                case 143528042: {
                    if (!var11_2 /* !! */ .equals("action_island_max_width")) break;
                    var4_25 = var1_1.getFloat("extra_island_max_width");
                    var3_14 = var1_1.getFloat("extra_island_clock_width", -1.0f);
                    var2_17 = var1_1.getFloat("extra_island_battery_width", -1.0f);
                    var5_4 /* !! */  = this.getIslandMaxWidth() == var4_25 ? 1 : 0;
                    if (var5_4 /* !! */  != 0 && (var5_4 /* !! */  = this.getClockWidth() == var3_14 ? 1 : 0) != 0) {
                        var5_4 /* !! */  = var6_6 /* !! */ ;
                        if (this.getBatteryWidth() == var2_17) {
                            var5_4 /* !! */  = 1;
                        }
                        if (var5_4 /* !! */  != 0) {
                            return null;
                        }
                    }
                    var1_1 = new StringBuilder();
                    var1_1.append("ACTION_SET_ISLAND_MAX_WIDTH islandMaxWidth: ");
                    var1_1.append(var4_25);
                    var1_1.append(", clockWidth: ");
                    var1_1.append(var3_14);
                    var1_1.append(", batteryWidth: ");
                    var1_1.append(var2_17);
                    Log.d((String)"DynamicIslandWindowViewController", (String)var1_1.toString());
                    this.sizeRepository.updateIslandMaxWidth(var4_25, var3_14, var2_17);
                    if (!this.pendingData.isEmpty() && (this.sizeRepository.getIslandWidthParams().getValue()).getMaxWidth() > 0.0f) {
                        var1_1 = new HashMap<DynamicIslandData, Boolean>(this.pendingData);
                        this.pendingData.clear();
                        for (Object var11_2 : var1_1.entrySet()) {
                            var13_20 /* !! */  = var11_2 /* !! */ .getKey();
                            o.f(var13_20 /* !! */ , (String)"<get-key>(...)");
                            var13_20 /* !! */  = (DynamicIslandData)var13_20 /* !! */ ;
                            var11_2 /* !! */  = var11_2 /* !! */ .getValue();
                            o.f((Object)var11_2 /* !! */ , (String)"<get-value>(...)");
                            this.addDynamicIslandView((DynamicIslandData)var13_20 /* !! */ , (Boolean)var11_2 /* !! */ );
                        }
                    }
                    var1_1 = new StringBuilder();
                    var1_1.append("handleDynamicIsland: islandMaxWidth ");
                    var1_1.append(var4_25);
                    Log.d((String)"DynamicIslandWindowViewController", (String)var1_1.toString());
                    break;
                }
                case 76664370: {
                    if (!var11_2 /* !! */ .equals("action_update_focus_notif_inner_element_anim_state")) break;
                    var7_7 = var1_1.getBoolean("extra_focus_notif_inner_element_anim_state", true);
                    if ((var1_1 = (StatusBarNotification)var1_1.getParcelable("extra_focus_notif_sbn", StatusBarNotification.class)) == null) break;
                    this.updateChronometerEffect((StatusBarNotification)var1_1, var7_7);
                    this.updateLottieAnimState((StatusBarNotification)var1_1, var7_7);
                    var1_1 = s.a;
                    break;
                }
                case -91961204: {
                    if (!var11_2 /* !! */ .equals("action_notification_panel_visible")) break;
                    var7_7 = var1_1.getBoolean("extra_notification_panel_visible");
                    this.notificationVisible(var7_7);
                    this.getExternalStateRepository().notifyNotificationVisibleChanged(var7_7);
                    var1_1 = new StringBuilder();
                    var1_1.append("handleDynamicIsland: notif visible ");
                    var1_1.append(var7_7);
                    Log.d((String)"DynamicIslandWindowViewController", (String)var1_1.toString());
                    break;
                }
                case -151023397: {
                    if (!var11_2 /* !! */ .equals("action_keyguard_occluded")) break;
                    var7_7 = var1_1.getBoolean("extra_keyguard_occluded");
                    this.getExternalStateRepository().notifyKeyguardOccluded(var7_7);
                    var1_1 = new StringBuilder();
                    var1_1.append("isKeyguardOccluded: ");
                    var1_1.append(var7_7);
                    Log.d((String)"DynamicIslandWindowViewController", (String)var1_1.toString());
                    break;
                }
                case -167388683: {
                    if (!var11_2 /* !! */ .equals("action_avoid_screen_burn_in_tran")) break;
                    var5_4 /* !! */  = var1_1.getInt("extra_avoid_screen_burn_in_dir");
                    var7_7 = var1_1.getBoolean("extra_avoid_screen_burn_in_status");
                    ((AvoidScreenBurnInHelper)this.avoidScreenBurnInHelper.get()).updateScreenHelperInfo(var5_4 /* !! */ , var7_7);
                    break;
                }
                case -268543001: {
                    if (!var11_2 /* !! */ .equals("action_remove_island")) break;
                    var11_2 /* !! */  = var1_1.getString("extra_island_deleted_key");
                    var7_7 = var1_1.getBoolean("extra_island_deleted_has_animation");
                    var1_1 = new StringBuilder();
                    var1_1.append("removeIsland: ");
                    var1_1.append((String)var11_2 /* !! */ );
                    var1_1.append(", hasAnimation: ");
                    var1_1.append(var7_7);
                    Log.d((String)"DynamicIslandWindowViewController", (String)var1_1.toString());
                    if (var11_2 /* !! */  == null) break;
                    this.removeDynamicIslandView((String)var11_2 /* !! */ , var7_7 ^ true);
                    var1_1 = s.a;
                    break;
                }
                case -307225225: {
                    if (!var11_2 /* !! */ .equals("action_lock_screen")) break;
                    var7_7 = var1_1.getBoolean("extra_lock_screen");
                    var1_1 = new StringBuilder();
                    var1_1.append("lockScreen: ");
                    var1_1.append(var7_7);
                    Log.d((String)"DynamicIslandWindowViewController", (String)var1_1.toString());
                    this.lockScreen(var7_7);
                    break;
                }
                case -396620393: {
                    if (!var11_2 /* !! */ .equals("action_top_activity_changed")) break;
                    this.isPendingTopChanged = false;
                    var11_2 /* !! */  = (ComponentName)var1_1.getParcelable("extra_top_activity_component_name", ComponentName.class);
                    var8_11 = var1_1.getBoolean("extra_top_activity_in_small_window");
                    var7_7 = var1_1.getBoolean("extra_top_activity_is_focus");
                    var9_5 = var1_1.getBoolean("extra_top_activity_is_support_pip");
                    var13_21 = this.fullScreenPkg;
                    var1_1 = var1_1.getString("extra_last_full_screen_activity_pkg", "");
                    o.f((Object)var1_1, (String)"getString(...)");
                    var13_21.setValue(var1_1);
                    DynamicIslandWindowViewController.onTopActivityChange$default(this, (ComponentName)var11_2 /* !! */ , var8_11, var9_5, var7_7, false, 16, null);
                    break;
                }
                case -700004145: {
                    if (!var11_2 /* !! */ .equals("action_expand_state_monitored_touch") || (var1_1 = (Object)var1_1.getIntArray("extra_expand_state_monitored_touch_coordinator")) == null) break;
                    var5_4 /* !! */  = (int)var1_1[0];
                    var6_6 /* !! */  = (int)var1_1[1];
                    if (OneHandModeUtils.INSTANCE.isOneHandMode()) {
                        var6_6 /* !! */  = (int)((double)var6_6 /* !! */  - (double)DynamicIslandUtils.INSTANCE.getScreenHeightOld(this.getContext()) * 0.4);
                        ((DynamicIslandWindowView)this.getView()).maybeCollapseExpand(var5_4 /* !! */ , var6_6 /* !! */ );
                    } else {
                        ((DynamicIslandWindowView)this.getView()).maybeCollapseExpand(var5_4 /* !! */ , var6_6 /* !! */ );
                    }
                    var1_1 = s.a;
                    break;
                }
                case -761916606: {
                    if (!var11_2 /* !! */ .equals("action_collapse_expanded")) break;
                    ((DynamicIslandWindowView)this.getView()).collapse("action collapse");
                    break;
                }
                case -774194398: {
                    if (!var11_2 /* !! */ .equals("action_device_interactive")) break;
                    var7_7 = var1_1.getBoolean("extra_is_device_interactive");
                    this.getExternalStateRepository().notifyDeviceInteractive(var7_7);
                    var1_1 = new StringBuilder();
                    var1_1.append("isDeviceInteractive: ");
                    var1_1.append(var7_7);
                    Log.d((String)"DynamicIslandWindowViewController", (String)var1_1.toString());
                    break;
                }
                case -819194794: {
                    if (!var11_2 /* !! */ .equals("action_set_status_bar_window_visible")) break;
                    this.statusBarVisible((Bundle)var1_1);
                    break;
                }
                case -1080314869: {
                    if (!var11_2 /* !! */ .equals("action_heads_up_height_changed")) break;
                    var11_2 /* !! */  = var1_1.getString("extra_heads_up_entry");
                    var1_1.getBoolean("extra_has_heads_up");
                    var5_4 /* !! */  = var1_1.getInt("extra_headsup_height");
                    var1_1 = new StringBuilder();
                    var1_1.append("entry: ");
                    var1_1.append((String)var11_2 /* !! */ );
                    var1_1.append(", headsUpHeight: ");
                    var1_1.append(var5_4 /* !! */ );
                    Log.d((String)"DynamicIslandTouchDebug", (String)var1_1.toString());
                    ((DynamicIslandWindowView)this.getView()).updateHeadsUpZone(var5_4 /* !! */ );
                    break;
                }
                case -1151367345: {
                    if (!var11_2 /* !! */ .equals("action_update_status_bar_date_pos")) break;
                    var5_4 /* !! */  = var1_1.getInt("extra_date_margin_top", 0);
                    var6_6 /* !! */  = var1_1.getInt("extra_date_x", 0);
                    if (var5_4 /* !! */  == this.sizeRepository.getStatusBarDateMarginTop() && this.getStatusBarDatePosX() == var6_6 /* !! */ ) {
                        return null;
                    }
                    this.sizeRepository.setStatusBarDateMarginTop(var5_4 /* !! */ );
                    this.sizeRepository.updateStatusBarDatePos(var6_6 /* !! */ );
                    for (Object var11_2 : ((DynamicIslandWindowView)this.getView()).getContentViewList()) {
                        var13_22 = var11_2 /* !! */ .getCurrentIslandData();
                        if (var13_22 == null) continue;
                        DynamicIslandWindowView.updateDynamicIslandView$default((DynamicIslandWindowView)this.getView(), var13_22, false, var11_2 /* !! */ .getMaxWidth(), false, 8, null);
                        var11_2 /* !! */  = s.a;
                    }
                    break;
                }
                case -1174102325: {
                    if (!var11_2 /* !! */ .equals("action_set_status_bar_view_visible")) break;
                    var7_7 = var1_1.getBoolean("extra_status_bar_view_visible", true);
                    if (!var7_7) {
                        this.windowState.setTempHiddenType(DynamicIslandWindowState.TempHiddenType.STATUS_BAR_DISAPPEARANCE);
                    }
                    this.windowState.getStatusBarViewShowing().setValue((Object)var7_7);
                    var1_1 = new StringBuilder();
                    var1_1.append("statusBar view visible: ");
                    var1_1.append(var7_7);
                    Log.d((String)"DynamicIslandWindowViewController", (String)var1_1.toString());
                    break;
                }
                case -1178402593: {
                    if (!var11_2 /* !! */ .equals("action_immersive_status")) break;
                    var7_7 = var1_1.getBoolean("extra_action_immersive_status", false);
                    this.windowState.getStatusBarisTransientShowing().setValue((Object)var7_7);
                    break;
                }
                case -1980753131: {
                    if (!var11_2 /* !! */ .equals("action_keyguard_showing")) break;
                    var7_7 = var1_1.getBoolean("extra_keyguard_showing");
                    this.getExternalStateRepository().notifyKeyguardShowingChanged(var7_7);
                    var1_1 = new StringBuilder();
                    var1_1.append("isKeyguardShowing: ");
                    var1_1.append(var7_7);
                    Log.d((String)"DynamicIslandWindowViewController", (String)var1_1.toString());
                    break;
                }
                case -2078329320: {
                    if (!var11_2 /* !! */ .equals("action_avoid_screen_burn_in_params_update")) break;
                    var5_4 /* !! */  = var1_1.getInt("extra_avoid_screen_burn_in_interval");
                    var6_6 /* !! */  = var1_1.getInt("extra_avoid_screen_burn_in_step");
                    ((AvoidScreenBurnInHelper)this.avoidScreenBurnInHelper.get()).updateTranParams(var5_4 /* !! */ , var6_6 /* !! */ );
                    break;
                }
                case -2079074337: {
                    if (!var11_2 /* !! */ .equals("action_notification_panel_expanded")) break;
                    var7_7 = var1_1.getBoolean("extra_notification_panel_expanded");
                    this.notificationAppearance(var7_7);
                    this.getExternalStateRepository().notifyNotificationAppearanceChanged(var7_7);
                    var1_1 = new StringBuilder();
                    var1_1.append("handleDynamicIsland: notif appearance ");
                    var1_1.append(var7_7);
                    Log.d((String)"DynamicIslandWindowViewController", (String)var1_1.toString());
                }
            }
        }
        return var12_3;
    }

    public final I isAppAnimRunning() {
        return this.isAppAnimRunning;
    }

    public final I isFreeformAnimRunning() {
        return this.isFreeformAnimRunning;
    }

    public final boolean isInMiniWindow(String string, Integer n) {
        if (string != null && n != null) {
            return this.dynamicIslandDesktopStateController.getMiniWindowDataRepo().isInMiniWindow(string, n);
        }
        return false;
    }

    public final boolean isNotSupportFreeFormAnim() {
        boolean bl = DynamicIslandAnimUtils.INSTANCE.featureDynamicIslandNoElementButFreeform() || !this.isSupportFreeformAnim || this.isWorkbenchModeEnabled() || CommonUtils.INSTANCE.getIS_TABLET() && o.c((Object)this.isMiniState, (Object)Boolean.TRUE);
        return bl;
    }

    public final boolean isNotchScreenDevice() {
        return (Boolean)this.isNotchScreenDevice$delegate.getValue();
    }

    public final boolean isRealCutoutHeightDevice() {
        return (Boolean)this.isRealCutoutHeightDevice$delegate.getValue();
    }

    public final boolean isWorkbenchModeEnabled() {
        return (Boolean)((WorkBenchModeRepository)this.workBenchModeRepository.get()).isWorkbenchModeEnabled().getValue();
    }

    public final void notificationPanelExpandHeightChanged(float f2, float f3) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("notificationPanelExpandHeightChanged expandHeight:");
        stringBuilder.append(f2);
        stringBuilder.append(" expandThresh:");
        stringBuilder.append(f3);
        Log.d((String)TAG, (String)stringBuilder.toString());
        this.windowState.getControlCenterPanelHeightChanging().setValue((Object)Boolean.FALSE);
        boolean bl = true;
        if (f2 == 0.0f || f2 == f3) {
            stringBuilder = this.notificationPanelHeightChangingJob;
            if (stringBuilder != null) {
                l0.a.a((l0)stringBuilder, null, (int)1, null);
            }
            this.notificationPanelHeightChangingJob = f.b((f1.E)this.uiScopeImmediate, null, null, (U0.o)new U0.o(this, null){
                int label;
                final DynamicIslandWindowViewController this$0;
                {
                    this.this$0 = dynamicIslandWindowViewController;
                    super(2, d2);
                }

                public final K0.d create(Object object, K0.d d2) {
                    return new /* invalid duplicate definition of identical inner class */;
                }

                public final Object invoke(f1.E e2, K0.d d2) {
                    return (this.create(e2, d2)).invokeSuspend(s.a);
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
                        this.label = 1;
                        if (M.b((long)1000L, (K0.d)this) == object2) {
                            return object2;
                        }
                    }
                    Log.d((String)"DynamicIslandWindowViewController", (String)"notificationPanelExpandHeightChanged Completed");
                    this.this$0.getWindowState().getNotificationPanelHeightChanging().setValue((Object)b.a((boolean)false));
                    return s.a;
                }
            }, (int)3, null);
        } else {
            stringBuilder = this.notificationPanelHeightChangingJob;
            if (stringBuilder != null) {
                l0.a.a((l0)stringBuilder, null, (int)1, null);
            }
            this.windowState.getNotificationPanelHeightChanging().setValue((Object)Boolean.TRUE);
        }
        this.windowState.setTempHiddenType(DynamicIslandWindowState.TempHiddenType.NOTIFICATION_SWIPE_TO_APPEARANCE);
        stringBuilder = this.windowState.getNotificationPanelSwipeToAppearance();
        if (!(f2 > f3 / (float)20)) {
            bl = false;
        }
        stringBuilder.setValue(bl);
    }

    public void onConfigChanged(Configuration configuration) {
        o.g((Object)configuration, (String)"config");
        this.onConfigurationChanged(this.getResources().getConfiguration());
    }

    public void removeDynamicIslandGlowEffectLayer() {
        this.dynamicIslandGlowEffectLayer = null;
    }

    public void removeDynamicIslandView(String string) {
        o.g((Object)string, (String)"key");
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("removeDynamicIslandView key :");
        stringBuilder.append(string);
        Log.d((String)TAG, (String)stringBuilder.toString());
        this.removeDynamicIslandView(string, false);
    }

    public final void removeDynamicIslandView(String string, boolean bl) {
        o.g((Object)string, (String)"key");
        CharSequence charSequence = new StringBuilder();
        charSequence.append("removeDynamicIslandView ");
        charSequence.append(bl);
        charSequence.append(" key:");
        charSequence.append(string);
        Log.d((String)TAG, (String)charSequence.toString());
        DynamicIslandData dynamicIslandData = this.islandData.remove(string);
        charSequence = dynamicIslandData != null && (charSequence = dynamicIslandData.getExtras()) != null ? charSequence.getString("miui.pkg.name") : null;
        DynamicIslandWindowView.removeDynamicIslandData$default((DynamicIslandWindowView)this.getView(), dynamicIslandData, bl, false, 4, null);
        ((LottieProgressManager)this.lottieProgressManager.get()).removeIslandLottie(string);
        this.appCloseRect.remove(string);
        this.pinOperateList.remove(string);
        if (charSequence != null) {
            DynamicIslandEventTracker.Companion.removeAppName((String)charSequence);
        }
    }

    public void removeOnDynamicIslandViewChangedListener(DynamicIslandContent.DynamicIslandViewChangedListener dynamicIslandViewChangedListener) {
        o.g((Object)dynamicIslandViewChangedListener, (String)"listener");
    }

    public Bundle requestDynamicIslandPosition(String string) {
        o.g((Object)string, (String)"key");
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("requestDynamicIslandPosition key = ");
        stringBuilder.append(string);
        Log.d((String)TAG, (String)stringBuilder.toString());
        string = new Bundle();
        string.putParcelable("position", (Parcelable)new Rect(0, 0, 100, 100));
        return string;
    }

    public final void resetWindowAnimationState() {
        i1.u u2 = this._isFreeformAnimRunning;
        Boolean bl = Boolean.FALSE;
        u2.setValue((Object)bl);
        this._isAppAnimRunning.setValue((Object)bl);
        DynamicIslandWindowViewController.setPositionValue$default(this, false, false, 2, null);
        ((DynamicIslandWindowView)this.getView()).setAnimRunning(false, false);
        ((DynamicIslandWindowView)this.getView()).enterMiniWindowEnd();
    }

    public final void runDesktopAnim(boolean bl) {
        this.dynamicIslandDesktopStateController.runDesktopAnim(bl);
    }

    public final void screenPinningActive(boolean bl) {
        this.windowState.setTempHiddenType(DynamicIslandWindowState.TempHiddenType.SCREEN_PINNING_ACTIVE);
        this.windowState.getScreenPinning().setValue((Object)bl);
    }

    public Bundle sendWindowAnimEvent(String string, boolean bl, boolean bl2, Bundle bundle) {
        block38: {
            block35: {
                block36: {
                    block37: {
                        o.g((Object)string, (String)"event");
                        Object object = new StringBuilder();
                        ((StringBuilder)object).append("sendWindowAnimEvent: ");
                        ((StringBuilder)object).append(string);
                        ((StringBuilder)object).append(",  isFreeform: ");
                        ((StringBuilder)object).append(bl);
                        ((StringBuilder)object).append(", isInterrupted: ");
                        ((StringBuilder)object).append(bl2);
                        Log.d((String)"DynamicIslandAnimDebug", (String)((StringBuilder)object).toString());
                        this.setScenarioState(string, bl);
                        if (!bl && DynamicIslandAnimUtils.INSTANCE.supportShowElementAnim() || bl && DynamicIslandAnimUtils.INSTANCE.supportShowElementAndFreeformAnim()) {
                            return DynamicIslandWindowViewController.sendWindowAnimEventForLinkage$default(this, string, bl, bl2, bundle, false, 16, null);
                        }
                        object = DynamicIslandAnimUtils.INSTANCE;
                        if (!((DynamicIslandAnimUtils)object).featureDynamicIslandIsMiddle() && !((DynamicIslandAnimUtils)object).featureDynamicIslandNoElementButFreeform()) break block35;
                        if (!bl) break block36;
                        switch (string.hashCode()) {
                            default: {
                                break;
                            }
                            case 961957696: {
                                if (!string.equals("request_close_position")) {
                                    break;
                                }
                                break block37;
                            }
                            case 450865345: {
                                if (!string.equals("freeform_final_position")) break;
                                break block37;
                            }
                            case -274311702: {
                                if (!string.equals("close_app_no_anim")) {
                                    break;
                                }
                                break block37;
                            }
                            case -1135179971: {
                                if (string.equals("close_app_start")) break block37;
                            }
                        }
                        return this.sendWindowAnimEventForLinkage(string, bl, bl2, bundle, true);
                    }
                    return this.sendWindowAnimEventForMiddle(string, bl, bl2, bundle);
                }
                switch (string.hashCode()) {
                    default: {
                        break;
                    }
                    case 1784144651: {
                        if (!string.equals("split_to_dismiss")) {
                            break;
                        }
                        break block38;
                    }
                    case 1626083599: {
                        if (!string.equals("open_app_start")) {
                            break;
                        }
                        break block38;
                    }
                    case 961957696: {
                        if (!string.equals("request_close_position")) {
                            break;
                        }
                        break block38;
                    }
                    case 738722817: {
                        if (!string.equals("app_to_recent")) {
                            break;
                        }
                        break block38;
                    }
                    case 399377139: {
                        if (!string.equals("enter_split")) break;
                        break block38;
                    }
                    case -26823218: {
                        if (!string.equals("request_open_position")) {
                            break;
                        }
                        break block38;
                    }
                    case -115909572: {
                        if (!string.equals("update_surface_info_finish")) {
                            break;
                        }
                        break block38;
                    }
                    case -274311702: {
                        if (!string.equals("close_app_no_anim")) {
                            break;
                        }
                        break block38;
                    }
                    case -306701112: {
                        if (!string.equals("open_app_end")) {
                            break;
                        }
                        break block38;
                    }
                    case -989809860: {
                        if (!string.equals("open_app_no_anim")) {
                            break;
                        }
                        break block38;
                    }
                    case -1135179971: {
                        if (!string.equals("close_app_start")) {
                            break;
                        }
                        break block38;
                    }
                    case -1543092618: {
                        if (!string.equals("close_app_end")) {
                            break;
                        }
                        break block38;
                    }
                    case -1605700896: {
                        if (string.equals("anim_finished")) break block38;
                    }
                }
            }
            return null;
        }
        return this.sendWindowAnimEventForMiddle(string, bl, bl2, bundle);
    }

    public final void setAppAnimSmallX(int n) {
        this.appAnimSmallX = n;
    }

    public final void setAppCloseKey(String string) {
        this.appCloseKey = string;
    }

    public final void setAppCloseRect(HashMap<String, Rect> hashMap) {
        o.g(hashMap, (String)"<set-?>");
        this.appCloseRect = hashMap;
    }

    public final void setCurrentHeight(int n) {
        int n2 = this.currentHeight;
        if (n != n2) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("currentHeight: ");
            stringBuilder.append(n);
            stringBuilder.append(" ");
            stringBuilder.append(n2);
            Log.e((String)TAG, (String)stringBuilder.toString());
            this.currentHeight = n;
        }
    }

    public final void setDisplayOrientation(int n) {
        this.displayOrientation = n;
    }

    public final void setDynamicIslandCallback(DynamicIslandCallback dynamicIslandCallback) {
        this.dynamicIslandCallback = dynamicIslandCallback;
    }

    public final void setDynamicIslandSafeguardsController(DynamicIslandSafeguardsController dynamicIslandSafeguardsController) {
        o.g((Object)dynamicIslandSafeguardsController, (String)"<set-?>");
        this.dynamicIslandSafeguardsController = dynamicIslandSafeguardsController;
    }

    public final void setHyperDropInfoNotifierService(b.a a2) {
        o.g((Object)a2, (String)"<set-?>");
        this.hyperDropInfoNotifierService = a2;
    }

    public final void setInSmallWindowMap(HashMap<String, Boolean> hashMap) {
        o.g(hashMap, (String)"<set-?>");
        this.inSmallWindowMap = hashMap;
    }

    public final void setLastDisplayOrientation(int n) {
        this.lastDisplayOrientation = n;
    }

    public final void setLastTopActivityPkg(String string) {
        this.lastTopActivityPkg = string;
    }

    public final void setLottieProgressManager(a a2) {
        o.g((Object)a2, (String)"<set-?>");
        this.lottieProgressManager = a2;
    }

    public final void setSupportMediaFreeform(boolean bl) {
        this.supportMediaFreeform = bl;
    }

    public final void setTopActivityPkg(String string) {
        this.topActivityPkg = string;
    }

    public final void setUiExecutor(DelayableExecutor delayableExecutor) {
        o.g((Object)delayableExecutor, (String)"<set-?>");
        this.uiExecutor = delayableExecutor;
    }

    public final void setWindowState(DynamicIslandWindowState dynamicIslandWindowState) {
        o.g((Object)dynamicIslandWindowState, (String)"<set-?>");
        this.windowState = dynamicIslandWindowState;
    }

    @Override
    public void start() {
        this.init();
    }

    public final void updateAppRect(DynamicIslandContentView dynamicIslandContentView, boolean bl) {
        HashMap<String, Rect> hashMap = ((DynamicIslandWindowView)this.getView()).calculateCollapse(dynamicIslandContentView);
        Object var4_4 = null;
        Object object = dynamicIslandContentView != null ? dynamicIslandContentView.getPkgName() : null;
        Rect rect = this.getAppCloseRealIslandRect((DynamicIslandState)((Object)hashMap), dynamicIslandContentView, (String)object, bl);
        object = dynamicIslandContentView != null ? dynamicIslandContentView.getState() : null;
        HashMap<String, Rect> hashMap2 = this.appCloseRect;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("oldState = ");
        stringBuilder.append((Object)dynamicIslandContentView);
        stringBuilder.append(" ");
        stringBuilder.append(object);
        stringBuilder.append(", newState: ");
        stringBuilder.append(hashMap);
        stringBuilder.append(", currentRect = ");
        stringBuilder.append(rect);
        stringBuilder.append(", appCloseRect = ");
        stringBuilder.append(hashMap2);
        Log.d((String)"DynamicIslandAnimDebug", (String)stringBuilder.toString());
        hashMap = this.appCloseKey;
        object = dynamicIslandContentView != null && (object = dynamicIslandContentView.getCurrentIslandData()) != null ? object.getKey() : null;
        if (o.c((Object)hashMap, (Object)object) && (rect == null || !rect.equals((Object)(hashMap = this.appCloseRect).get(object = dynamicIslandContentView != null && (object = dynamicIslandContentView.getCurrentIslandData()) != null ? object.getKey() : null)))) {
            ((DynamicIslandWindowView)this.getView()).updateAppCloseRect(rect, dynamicIslandContentView);
            if (rect != null) {
                object = var4_4;
                if (dynamicIslandContentView != null) {
                    dynamicIslandContentView = dynamicIslandContentView.getCurrentIslandData();
                    object = var4_4;
                    if (dynamicIslandContentView != null) {
                        object = dynamicIslandContentView.getKey();
                    }
                }
                this.addAppCloseRect((String)object, rect);
            }
        }
    }

    public final void updateChronometersIn(DynamicIslandBaseContentView object, DynamicIslandBaseContentView object2, DynamicIslandData dynamicIslandData) {
        o.g((Object)dynamicIslandData, (String)"data");
        if (object != null) {
            String string = dynamicIslandData.getKey();
            int n = R.id.island_chronometer;
            Bundle bundle = dynamicIslandData.getExtras();
            int n2 = 0;
            if (bundle != null) {
                n2 = bundle.getInt("timerType", 0);
            }
            boolean bl = this.getNotificationChronometerManager().needUpdateIslandTimeInfo(string);
            if (n2 != 0) {
                bundle = this.getNotificationChronometerManager();
                DynamicIslandBigIslandView dynamicIslandBigIslandView = object.getBigIslandView();
                object = object2 != null ? object2.getFakeBigIsland() : null;
                bundle.addDynamicIslandChronometer((View)dynamicIslandBigIslandView, (View)object, string, n);
                if (bl) {
                    bundle = this.getNotificationChronometerManager();
                    object = dynamicIslandData.getExtras();
                    object = object != null ? Long.valueOf(object.getLong("timerWhen")) : null;
                    object2 = dynamicIslandData.getExtras();
                    long l2 = object2 != null ? object2.getLong("timerTotal", 0L) : 0L;
                    object2 = dynamicIslandData.getExtras();
                    object2 = object2 != null ? Long.valueOf(object2.getLong("timerSystemCurrent")) : null;
                    bundle.updateTimeKeeperForIsland(string, n2, (Long)object, l2, (Long)object2);
                }
            } else if (bl) {
                this.getNotificationChronometerManager().removeTimeKeeper(string);
            }
        }
    }

    public void updateDynamicIslandView(DynamicIslandData object, boolean bl) {
        o.g((Object)object, (String)"dynamicIslandData");
        Object object2 = object.getKey();
        Object object3 = new StringBuilder();
        ((StringBuilder)object3).append("updateDynamicIslandView, key:");
        ((StringBuilder)object3).append((String)object2);
        ((StringBuilder)object3).append(", expanded:");
        ((StringBuilder)object3).append(bl);
        ((StringBuilder)object3).append(" ");
        Log.d((String)TAG, (String)((StringBuilder)object3).toString());
        object3 = object.getExtras();
        if (object3 != null) {
            object3.putString("miui.key", object.getKey());
        }
        if (this.requestMaxWidth((DynamicIslandData)object, bl)) {
            return;
        }
        IslandTemplate islandTemplate = this.getIslandTemplate((DynamicIslandData)object);
        object3 = islandTemplate != null ? Boolean.valueOf(islandTemplate.getDismissIsland()) : null;
        object2 = new StringBuilder();
        ((StringBuilder)object2).append("updateDynamicIslandView: dismissIsland:");
        ((StringBuilder)object2).append(object3);
        Log.e((String)TAG, (String)((StringBuilder)object2).toString());
        if (islandTemplate == null) {
            if ((object = object.getKey()) != null) {
                this.removeDynamicIslandView((String)object);
            }
            return;
        }
        object3 = object.getKey();
        if (object3 != null) {
            object3 = this.islandData.put((String)object3, (DynamicIslandData)object);
        }
        if (islandTemplate.getDismissIsland()) {
            if ((object = object.getKey()) != null) {
                this.removeDynamicIslandView((String)object);
            }
            return;
        }
        object3 = object.getPriority();
        int n = object3 != null ? (Integer)object3 : 1;
        object3 = object.getProperties();
        int n2 = object3 != null ? (Integer)object3 : 1;
        object3 = object2 = islandTemplate.getIslandPriority();
        if (object2 == null) {
            object3 = n;
        }
        object.setPriority((Integer)object3);
        object3 = object2 = islandTemplate.getIslandProperty();
        if (object2 == null) {
            object3 = n2;
        }
        object.setProperties((Integer)object3);
        if (this.checkFlipTiny(object.getProperties())) {
            Log.d((String)TAG, (String)"updateDynamicIslandView: skip in flip tiny");
            return;
        }
        this.setCancelTimeout((DynamicIslandData)object, islandTemplate);
        ((DynamicIslandWindowView)this.getView()).updateDynamicIslandView((DynamicIslandData)object, bl, this.getIslandMaxWidth(), true);
        if (bl) {
            this.dynamicIslandSafeguardsController.cancelDelayCollapsed();
            if (islandTemplate.getExpandedTime() != 0) {
                this.dynamicIslandSafeguardsController.delayCollapsed(islandTemplate.getExpandedTime());
            } else {
                this.dynamicIslandSafeguardsController.delayCollapsed(5L);
            }
        }
    }

    public final void updateWindowState() {
        Object object = DynamicIslandUtils.INSTANCE;
        ((DynamicIslandUtils)object).updateBoundingRect(this.getContext());
        ((DynamicIslandUtils)object).updateFlipOutInsetRight(this.getContext());
        object = this.windowState;
        ((DynamicIslandWindowState)object).setLastTinyScreenStatus(((DynamicIslandWindowState)object).isTinyScreen());
        this.windowState.setTinyScreen(CommonUtils.isTinyScreen((Context)this.getContext()));
        this.lastDisplayOrientation = this.displayOrientation;
        object = this.getContext().getDisplay();
        if (object != null) {
            this.displayOrientation = object.getRotation();
        }
        this.updateFlipResources();
    }

    public final boolean windowAnimating() {
        boolean bl = ((Boolean)this._isFreeformAnimRunning.getValue()).booleanValue() || ((Boolean)this._isAppAnimRunning.getValue()).booleanValue();
        return bl;
    }
}
