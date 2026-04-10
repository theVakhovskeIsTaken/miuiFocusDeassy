/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  D0.a
 *  G0.c
 *  G0.d
 *  G0.i
 *  G0.k
 *  G0.o
 *  G0.s
 *  H0.m
 *  H0.u
 *  K0.d
 *  L0.c
 *  U0.o
 *  android.content.Context
 *  android.content.res.Resources
 *  android.graphics.Region
 *  android.graphics.Region$Op
 *  android.os.Bundle
 *  android.service.notification.StatusBarNotification
 *  android.util.Log
 *  android.view.View
 *  android.view.ViewGroup
 *  android.view.ViewGroup$LayoutParams
 *  android.view.ViewParent
 *  android.widget.FrameLayout
 *  android.widget.FrameLayout$LayoutParams
 *  android.widget.Toast
 *  com.android.systemui.plugins.miui.dynamicisland.DynamicIslandContent$DynamicIslandViewChangedListener
 *  com.android.systemui.plugins.miui.dynamicisland.DynamicIslandData
 *  f1.E
 *  f1.M
 *  f1.f
 *  i1.I
 *  i1.K
 *  i1.h
 *  i1.u
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.E
 *  kotlin.jvm.internal.o
 *  miui.systemui.notification.NotificationSettingsManager
 *  miui.systemui.util.CommonUtils
 *  miui.systemui.util.ConvenienceExtensionsKt
 */
package miui.systemui.dynamicisland.event;

import D0.a;
import G0.i;
import G0.k;
import G0.s;
import H0.m;
import H0.u;
import K0.d;
import L0.c;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Region;
import android.os.Bundle;
import android.service.notification.StatusBarNotification;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.Toast;
import com.android.systemui.plugins.miui.dynamicisland.DynamicIslandContent;
import com.android.systemui.plugins.miui.dynamicisland.DynamicIslandData;
import f1.M;
import f1.f;
import i1.I;
import i1.K;
import i1.h;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentLinkedQueue;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.E;
import kotlin.jvm.internal.o;
import miui.systemui.dynamicisland.DynamicIslandAnimUtils;
import miui.systemui.dynamicisland.DynamicIslandUtils;
import miui.systemui.dynamicisland.anim.DynamicIslandAnimationCallback;
import miui.systemui.dynamicisland.anim.DynamicIslandAnimationCallbackType;
import miui.systemui.dynamicisland.anim.DynamicIslandAnimationController;
import miui.systemui.dynamicisland.anim.DynamicIslandAnimationType;
import miui.systemui.dynamicisland.dagger.DynamicIslandScope;
import miui.systemui.dynamicisland.dagger.qualifiers.DynamicIsland;
import miui.systemui.dynamicisland.display.AntiBurnInManager;
import miui.systemui.dynamicisland.display.AvoidScreenBurnInHelper;
import miui.systemui.dynamicisland.event.AddEventCoordinator;
import miui.systemui.dynamicisland.event.AppEventCoordinator;
import miui.systemui.dynamicisland.event.AvoidScreenBurnInEventCoordinator;
import miui.systemui.dynamicisland.event.ClickEventCoordinator;
import miui.systemui.dynamicisland.event.CollapseEventCoordinator;
import miui.systemui.dynamicisland.event.ConfigChangedEventCoordinator;
import miui.systemui.dynamicisland.event.DeletedEventCoordinator;
import miui.systemui.dynamicisland.event.DynamicIslandEvent;
import miui.systemui.dynamicisland.event.DynamicIslandState;
import miui.systemui.dynamicisland.event.IslandTempHiddenEventCoordinator;
import miui.systemui.dynamicisland.event.MiniWindowEventCoordinator;
import miui.systemui.dynamicisland.event.PanelExpandedEventCoordinator;
import miui.systemui.dynamicisland.event.State;
import miui.systemui.dynamicisland.event.SwipeEventCoordinator;
import miui.systemui.dynamicisland.event.UpdateEventCoordinator;
import miui.systemui.dynamicisland.event.UpdateWidthEventCoordinator;
import miui.systemui.dynamicisland.event.handler.AppStateHandler;
import miui.systemui.dynamicisland.event.handler.BigIslandStateHandler;
import miui.systemui.dynamicisland.event.handler.ExpandedStateHandler;
import miui.systemui.dynamicisland.event.handler.HiddenStateHandler;
import miui.systemui.dynamicisland.event.handler.MiniWindowStateHandler;
import miui.systemui.dynamicisland.event.handler.ShowOnceIslandHandler;
import miui.systemui.dynamicisland.event.handler.SmallIslandStateHandler;
import miui.systemui.dynamicisland.view.DynamicGlowEffectView;
import miui.systemui.dynamicisland.view.DynamicIslandExpandedView;
import miui.systemui.dynamicisland.window.AppLockController;
import miui.systemui.dynamicisland.window.DynamicIslandWindowState;
import miui.systemui.dynamicisland.window.DynamicIslandWindowView;
import miui.systemui.dynamicisland.window.content.DynamicIslandBaseContentView;
import miui.systemui.dynamicisland.window.content.DynamicIslandContentFakeView;
import miui.systemui.dynamicisland.window.content.DynamicIslandContentView;
import miui.systemui.notification.NotificationSettingsManager;
import miui.systemui.util.CommonUtils;
import miui.systemui.util.ConvenienceExtensionsKt;

@DynamicIslandScope
public final class DynamicIslandEventCoordinator
implements DynamicIslandAnimationController.DynamicIslandAnimationCallback {
    public static final Companion Companion = new Object(null){
        {
            this();
        }
    };
    private static final Region NON_INTERACTIVE_REGION = new Region();
    public static final String TAG = "DynamicIslandEventCoordinator";
    public static final String TAG_ERROR = "DynamicIslandEventCoordinator ERROR";
    private final i1.u _bigIslandRegion;
    private final i1.u _expandedState;
    private final i1.u _expandedViewRegion;
    private i1.u _headsUpZone;
    private final i1.u _islandRegion;
    private final i1.u _state;
    private i1.u _stateBarVisible;
    private final i1.u _touchRegion;
    private boolean _userExpanded;
    private final G0.d addEventCoordinator$delegate;
    private final G0.d animationController$delegate;
    private final AntiBurnInManager antiBurnInManager;
    private final G0.d appEventCoordinator$delegate;
    private final AppLockController appLockController;
    private final AppStateHandler appStateHandler;
    private final G0.d avoidScreenBurnInEventCoordinator$delegate;
    private final AvoidScreenBurnInHelper avoidScreenBurnInHelper;
    private final I bigIslandRegion;
    private final BigIslandStateHandler bigIslandStateHandler;
    private final G0.d clickEventCoordinator$delegate;
    private boolean collapseAnimationRunning;
    private int collapseAnimationRunningCount;
    private final G0.d collapseEventCoordinator$delegate;
    private final G0.d configChangedEventCoordinator$delegate;
    private final Context ctx;
    private final G0.d deletedEventCoordinator$delegate;
    private DynamicIslandContent.DynamicIslandViewChangedListener dynamicIslandViewChangedListener;
    private final DynamicIslandWindowState dynamicIslandWindowState;
    private boolean enterMiniWindow;
    private final ConcurrentLinkedQueue<DynamicIslandEvent> eventQueue;
    private final I expandedState;
    private final ExpandedStateHandler expandedStateHandler;
    private final I expandedViewRegion;
    private int freeformBottom;
    private DynamicIslandEvent handlingEvent;
    private boolean hasAppExpandedState;
    private boolean hasResetPress;
    private final I headsUpZone;
    private ArrayList<DynamicIslandContentView> hiddenList;
    private final HiddenStateHandler hiddenStateHandler;
    private boolean horizontalSwipeDispatched;
    private boolean isAnimationRunning;
    private boolean isExpandedChanged;
    private final I islandRegion;
    private final G0.d islandTempHiddenEventCoordinator$delegate;
    private boolean keyguardShowing;
    private int lastBigIslandWidth;
    private String lastFullScreenActivityPkg;
    private boolean lastHasTickerData;
    private final G0.d miniWindowEventCoordinator$delegate;
    private final MiniWindowStateHandler miniWindowStateHandler;
    private HashMap<String, Boolean> needExtendLifetime;
    private final G0.d notifySettingsManager$delegate;
    private final G0.d panelExpandedEventCoordinator$delegate;
    private HashMap<String, Boolean> pkgSupportFreeform;
    private final f1.E scope;
    private final ShowOnceIslandHandler showOnceIslandHandler;
    private final SmallIslandStateHandler smallIslandStateHandler;
    private final I state;
    private final I statusBarVisible;
    private final G0.d swipeEventCoordinator$delegate;
    private boolean swiping;
    private final I touchRegion;
    private final G0.d updateEventCoordinator$delegate;
    private final G0.d updateWidthEventCoordinator$delegate;
    private boolean verticalSwipeDispatched;
    private boolean windowAnimRunning;
    private final DynamicIslandWindowView windowView;

    public DynamicIslandEventCoordinator(@DynamicIsland f1.E e, Context object, DynamicIslandWindowView object2, AvoidScreenBurnInHelper object3, ExpandedStateHandler expandedStateHandler, BigIslandStateHandler bigIslandStateHandler, ShowOnceIslandHandler showOnceIslandHandler, SmallIslandStateHandler smallIslandStateHandler, HiddenStateHandler hiddenStateHandler, AppStateHandler appStateHandler, MiniWindowStateHandler miniWindowStateHandler, DynamicIslandWindowState dynamicIslandWindowState, AppLockController appLockController, AntiBurnInManager antiBurnInManager, a a2, a a3, a a4, a a5, a a6, a a7, a a8, a a9, a a10, a a11, a a12, a a13, a a14, a a15, a a16) {
        o.g((Object)e, (String)"scope");
        o.g((Object)object, (String)"ctx");
        o.g((Object)object2, (String)"windowView");
        o.g((Object)object3, (String)"avoidScreenBurnInHelper");
        o.g((Object)expandedStateHandler, (String)"expandedStateHandler");
        o.g((Object)bigIslandStateHandler, (String)"bigIslandStateHandler");
        o.g((Object)showOnceIslandHandler, (String)"showOnceIslandHandler");
        o.g((Object)smallIslandStateHandler, (String)"smallIslandStateHandler");
        o.g((Object)hiddenStateHandler, (String)"hiddenStateHandler");
        o.g((Object)appStateHandler, (String)"appStateHandler");
        o.g((Object)miniWindowStateHandler, (String)"miniWindowStateHandler");
        o.g((Object)dynamicIslandWindowState, (String)"dynamicIslandWindowState");
        o.g((Object)appLockController, (String)"appLockController");
        o.g((Object)antiBurnInManager, (String)"antiBurnInManager");
        o.g((Object)a2, (String)"addEventCoordinator");
        o.g((Object)a3, (String)"clickEventCoordinator");
        o.g((Object)a4, (String)"deletedEventCoordinator");
        o.g((Object)a5, (String)"collapseEventCoordinator");
        o.g((Object)a6, (String)"swipeEventCoordinator");
        o.g((Object)a7, (String)"updateEventCoordinator");
        o.g((Object)a8, (String)"updateWidthEventCoordinator");
        o.g((Object)a9, (String)"appEventCoordinator");
        o.g((Object)a10, (String)"miniWindowEventCoordinator");
        o.g((Object)a11, (String)"islandTempHiddenEventCoordinator");
        o.g((Object)a12, (String)"configChangedEventCoordinator");
        o.g((Object)a13, (String)"panelExpandedEventCoordinator");
        o.g((Object)a14, (String)"avoidScreenBurnInEventCoordinator");
        o.g((Object)a15, (String)"animController");
        o.g((Object)a16, (String)"notificationSettingsManager");
        this.scope = e;
        this.ctx = object;
        this.windowView = object2;
        this.avoidScreenBurnInHelper = object3;
        this.expandedStateHandler = expandedStateHandler;
        this.bigIslandStateHandler = bigIslandStateHandler;
        this.showOnceIslandHandler = showOnceIslandHandler;
        this.smallIslandStateHandler = smallIslandStateHandler;
        this.hiddenStateHandler = hiddenStateHandler;
        this.appStateHandler = appStateHandler;
        this.miniWindowStateHandler = miniWindowStateHandler;
        this.dynamicIslandWindowState = dynamicIslandWindowState;
        this.appLockController = appLockController;
        this.antiBurnInManager = antiBurnInManager;
        this.addEventCoordinator$delegate = ConvenienceExtensionsKt.getKotlinLazy((a)a2);
        this.clickEventCoordinator$delegate = ConvenienceExtensionsKt.getKotlinLazy((a)a3);
        this.deletedEventCoordinator$delegate = ConvenienceExtensionsKt.getKotlinLazy((a)a4);
        this.collapseEventCoordinator$delegate = ConvenienceExtensionsKt.getKotlinLazy((a)a5);
        this.swipeEventCoordinator$delegate = ConvenienceExtensionsKt.getKotlinLazy((a)a6);
        this.updateEventCoordinator$delegate = ConvenienceExtensionsKt.getKotlinLazy((a)a7);
        this.updateWidthEventCoordinator$delegate = ConvenienceExtensionsKt.getKotlinLazy((a)a8);
        this.appEventCoordinator$delegate = ConvenienceExtensionsKt.getKotlinLazy((a)a9);
        this.miniWindowEventCoordinator$delegate = ConvenienceExtensionsKt.getKotlinLazy((a)a10);
        this.islandTempHiddenEventCoordinator$delegate = ConvenienceExtensionsKt.getKotlinLazy((a)a11);
        this.configChangedEventCoordinator$delegate = ConvenienceExtensionsKt.getKotlinLazy((a)a12);
        this.panelExpandedEventCoordinator$delegate = ConvenienceExtensionsKt.getKotlinLazy((a)a13);
        this.avoidScreenBurnInEventCoordinator$delegate = ConvenienceExtensionsKt.getKotlinLazy((a)a14);
        this.eventQueue = new ConcurrentLinkedQueue();
        this.animationController$delegate = ConvenienceExtensionsKt.getKotlinLazy((a)a15);
        this.notifySettingsManager$delegate = ConvenienceExtensionsKt.getKotlinLazy((a)a16);
        object2 = 0;
        object3 = K.a((Object)object2);
        this._state = object3;
        this.state = h.b((i1.u)object3);
        object3 = K.a((Object)this.getDefaultIslandTouchRegion());
        this._touchRegion = object3;
        this.touchRegion = h.b((i1.u)object3);
        object3 = K.a((Object)new Region());
        this._islandRegion = object3;
        this.islandRegion = h.b((i1.u)object3);
        object3 = K.a((Object)new Region());
        this._bigIslandRegion = object3;
        this.bigIslandRegion = h.b((i1.u)object3);
        object3 = K.a((Object)new Region());
        this._expandedViewRegion = object3;
        this.expandedViewRegion = h.b((i1.u)object3);
        object3 = Boolean.FALSE;
        expandedStateHandler = K.a((Object)object3);
        this._expandedState = expandedStateHandler;
        this.expandedState = h.b((i1.u)expandedStateHandler);
        object2 = K.a((Object)new i(object2, object2));
        this._headsUpZone = object2;
        this.headsUpZone = h.b((i1.u)object2);
        object2 = K.a((Object)object3);
        this._stateBarVisible = object2;
        this.statusBarVisible = h.b((i1.u)object2);
        this.hiddenList = new ArrayList();
        this.pkgSupportFreeform = new HashMap();
        this.needExtendLifetime = new HashMap();
        this.lastBigIslandWidth = -1;
        this.lastFullScreenActivityPkg = "";
        this.initStateHandler();
        object2 = this.hiddenList;
        object = new DynamicIslandContentView((Context)object, null, 2, null);
        ((DynamicIslandBaseContentView)((Object)object)).setState(new DynamicIslandState.Empty());
        ((ArrayList)object2).add(object);
        f.b((f1.E)e, null, null, (U0.o)new U0.o(this, null){
            int label;
            final DynamicIslandEventCoordinator this$0;
            {
                this.this$0 = dynamicIslandEventCoordinator;
                super(2, d2);
            }

            public final d create(Object object, d d2) {
                return new /* invalid duplicate definition of identical inner class */;
            }

            public final Object invoke(f1.E e, d d2) {
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
                    DynamicIslandEventCoordinator.access$getAvoidScreenBurnInHelper$p(this.this$0).setEventCoordinator(this.this$0);
                    this.label = 1;
                    if (M.a((d)this) == object2) {
                        return object2;
                    }
                }
                throw new G0.c();
            }
        }, (int)3, null).k(new Function1(this){
            final DynamicIslandEventCoordinator this$0;
            {
                this.this$0 = dynamicIslandEventCoordinator;
                super(1);
            }

            public final void invoke(Throwable object) {
                DynamicIslandEventCoordinator dynamicIslandEventCoordinator = DynamicIslandEventCoordinator.access$getAvoidScreenBurnInHelper$p(this.this$0).getEventCoordinator();
                if (dynamicIslandEventCoordinator == (object = this.this$0)) {
                    DynamicIslandEventCoordinator.access$getAvoidScreenBurnInHelper$p((DynamicIslandEventCoordinator)object).setEventCoordinator(null);
                }
            }
        });
        appLockController.init();
        this.initExpandEffectShader();
        this.initBigIslandEffectShader();
    }

    public static final /* synthetic */ AvoidScreenBurnInHelper access$getAvoidScreenBurnInHelper$p(DynamicIslandEventCoordinator dynamicIslandEventCoordinator) {
        return dynamicIslandEventCoordinator.avoidScreenBurnInHelper;
    }

    public static final /* synthetic */ int access$getCollapseAnimationRunningCount$p(DynamicIslandEventCoordinator dynamicIslandEventCoordinator) {
        return dynamicIslandEventCoordinator.collapseAnimationRunningCount;
    }

    public static final /* synthetic */ void access$setCollapseAnimationRunning$p(DynamicIslandEventCoordinator dynamicIslandEventCoordinator, boolean bl) {
        dynamicIslandEventCoordinator.collapseAnimationRunning = bl;
    }

    public static final /* synthetic */ void access$setCollapseAnimationRunningCount$p(DynamicIslandEventCoordinator dynamicIslandEventCoordinator, int n) {
        dynamicIslandEventCoordinator.collapseAnimationRunningCount = n;
    }

    /*
     * WARNING - void declaration
     */
    private final void checkError(DynamicIslandEvent dynamicIslandEvent) {
        Object object;
        if (this.smallIslandStateHandler.getCurrent() != null && this.bigIslandStateHandler.getCurrent() == null) {
            StringBuilder object22 = new StringBuilder();
            object22.append("\u5f53\u524d\u4e8b\u4ef6:");
            object22.append(dynamicIslandEvent);
            object22.append(" \u5bfc\u81f4\u72b6\u6001\u9519\u4e71\uff0c\u5355\u72ec\u6709\u5c0f\u5c9b");
            Log.e((String)TAG_ERROR, (String)object22.toString());
            if (CommonUtils.isUserRoot() || CommonUtils.isUserDebug()) {
                Toast.makeText((Context)this.ctx, (CharSequence)"\u51fa\u9519\u4e86\uff0c\u5355\u72ec\u6709\u5c0f\u5c9b, \u622a\u56fe\u6293\u65e5\u5fd7, \u4e4b\u540e\u6d4b\u8bd5\u9700\u91cd\u542fSystemUI", (int)0).show();
            }
        }
        ArrayList<DynamicIslandContentView> arrayList = new ArrayList<DynamicIslandContentView>();
        arrayList.add(this.expandedStateHandler.getCurrent());
        arrayList.add(this.bigIslandStateHandler.getCurrent());
        arrayList.add(this.smallIslandStateHandler.getCurrent());
        arrayList.addAll(this.hiddenList);
        ArrayList<DynamicIslandContentView> arrayList2 = this.appStateHandler.getCurrentList();
        if (arrayList2 != null) {
            arrayList.addAll(arrayList2);
        }
        Object object2 = this.miniWindowStateHandler.getCurrentMap().entrySet().iterator();
        while (object2.hasNext()) {
            ArrayList arrayList3 = (ArrayList)object2.next().getValue();
            if (arrayList3 == null) continue;
            arrayList.addAll(arrayList3);
        }
        if (!(dynamicIslandEvent instanceof DynamicIslandEvent.DeletedDynamicIsland)) {
            for (DynamicIslandContentView dynamicIslandContentView : arrayList) {
                void var2_19;
                void var2_12;
                void var2_9;
                Object object3;
                if (dynamicIslandContentView != null) {
                    Boolean bl = dynamicIslandContentView.isAttachedToWindow();
                } else {
                    Object var2_8 = null;
                }
                object2 = dynamicIslandContentView != null ? dynamicIslandContentView.getParent() : null;
                Object object4 = dynamicIslandContentView != null ? dynamicIslandContentView.getParent() : null;
                object4 = object4 instanceof View ? (View)object4 : null;
                object4 = object4 != null ? object4.getParent() : null;
                object = dynamicIslandContentView != null ? dynamicIslandContentView.getParent() : null;
                object = object instanceof View ? (View)object : null;
                object = object != null ? Boolean.valueOf(object.isAttachedToWindow()) : null;
                object3 = dynamicIslandContentView != null && (object3 = dynamicIslandContentView.getCurrentIslandData()) != null ? object3.getKey() : null;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("checkError ");
                stringBuilder.append(var2_9);
                stringBuilder.append(" ");
                stringBuilder.append(object2);
                stringBuilder.append(" ");
                stringBuilder.append(object4);
                stringBuilder.append(" ");
                stringBuilder.append(object);
                stringBuilder.append(" ");
                stringBuilder.append((String)object3);
                Log.e((String)TAG_ERROR, (String)stringBuilder.toString());
                if (dynamicIslandContentView != null) {
                    ViewParent viewParent = dynamicIslandContentView.getParent();
                } else {
                    Object var2_11 = null;
                }
                if (var2_12 == null) continue;
                ViewParent viewParent = dynamicIslandContentView.getParent();
                o.e((Object)viewParent, (String)"null cannot be cast to non-null type android.view.View");
                if (((View)viewParent).getParent() != null) {
                    ViewParent viewParent2 = dynamicIslandContentView.getParent();
                    o.e((Object)viewParent2, (String)"null cannot be cast to non-null type android.view.View");
                    if (((View)viewParent2).isAttachedToWindow()) continue;
                }
                Log.e((String)TAG_ERROR, (String)"checkError has Error ");
                this.dispatchEvent(DynamicIslandEvent.DeletedDynamicIsland.INSTANCE, dynamicIslandContentView);
                object4 = this.windowView;
                object2 = dynamicIslandContentView.getCurrentIslandData();
                DynamicIslandData dynamicIslandData = dynamicIslandContentView.getCurrentIslandData();
                if (dynamicIslandData != null) {
                    String string = dynamicIslandData.getKey();
                } else {
                    Object var2_18 = null;
                }
                ((DynamicIslandWindowView)((Object)object4)).clearAfterDelete((DynamicIslandData)object2, (String)var2_19, true);
            }
        }
        object2 = new HashSet();
        for (DynamicIslandContentView dynamicIslandContentView : arrayList) {
            void var2_25;
            if (dynamicIslandContentView == null || (object = dynamicIslandContentView.getCurrentIslandData()) == null || (object = object.getKey()) == null || ((HashSet)object2).add(object)) continue;
            DynamicIslandData dynamicIslandData = dynamicIslandContentView.getCurrentIslandData();
            if (dynamicIslandData != null) {
                String string = dynamicIslandData.getKey();
            } else {
                Object var2_24 = null;
            }
            object = new StringBuilder();
            ((StringBuilder)object).append("\u5f53\u524d\u4e8b\u4ef6:");
            ((StringBuilder)object).append(dynamicIslandEvent);
            ((StringBuilder)object).append(" \u5bfc\u81f4\u72b6\u6001\u9519\u4e71\uff0c");
            ((StringBuilder)object).append((String)var2_25);
            ((StringBuilder)object).append(" \u6709\u91cd\u590d\u72b6\u6001");
            Log.e((String)TAG_ERROR, (String)((StringBuilder)object).toString());
            if (!CommonUtils.isUserRoot() && !CommonUtils.isUserDebug()) continue;
            Toast.makeText((Context)this.ctx, (CharSequence)"\u51fa\u9519\u4e86\uff0c\u6709\u91cd\u590d\u72b6\u6001, \u622a\u56fe\u6293\u65e5\u5fd7, \u4e4b\u540e\u6d4b\u8bd5\u9700\u91cd\u542fSystemUI", (int)0).show();
        }
    }

    private final Region createBigIslandRegion(DynamicIslandContentView dynamicIslandContentView, DynamicIslandContentView dynamicIslandContentView2, float f2) {
        int n = DynamicIslandBaseContentView.getCurrentBigIslandX$default(dynamicIslandContentView, null, 1, null);
        int n2 = DynamicIslandBaseContentView.getCurrentBigIslandWidth$default(dynamicIslandContentView, null, 1, null);
        int n3 = dynamicIslandContentView2 != null ? dynamicIslandContentView2.getSmallIslandViewWidth() : 0;
        DynamicIslandUtils dynamicIslandUtils = DynamicIslandUtils.INSTANCE;
        int n4 = dynamicIslandUtils.dpToPx(10, this.ctx);
        dynamicIslandContentView2 = CommonUtils.isLayoutRtl((Context)this.ctx) ? G0.o.a((Object)this.getSmallXInRtl(), (Object)(n + n2)) : G0.o.a((Object)n, (Object)(n + n2 + n3));
        float f3 = Math.abs(((Number)dynamicIslandContentView2.e()).intValue() - ((Number)dynamicIslandContentView2.d()).intValue()) + n4 * 2;
        if (f3 > f2 && f2 > 0.0f) {
            f2 = (f3 - f2) / (float)2;
            dynamicIslandContentView2 = G0.o.a((Object)Float.valueOf(((Number)dynamicIslandContentView2.d()).floatValue() - f2), (Object)Float.valueOf(((Number)dynamicIslandContentView2.e()).floatValue() + f2));
        } else {
            dynamicIslandContentView2 = G0.o.a((Object)(((Number)dynamicIslandContentView2.d()).intValue() - n4), (Object)(((Number)dynamicIslandContentView2.e()).intValue() + n4));
        }
        Object object = dynamicIslandContentView2.a();
        Object object2 = dynamicIslandContentView2.b();
        dynamicIslandContentView2 = new Region();
        dynamicIslandContentView2.set(((Number)object).intValue(), dynamicIslandContentView.getIslandViewMarginTop() - dynamicIslandUtils.dpToPx(4, this.ctx), ((Number)object2).intValue(), dynamicIslandContentView.getIslandViewMarginTop() + dynamicIslandContentView.getIslandViewHeight() + dynamicIslandUtils.dpToPx(4, this.ctx));
        return dynamicIslandContentView2;
    }

    private final Region createDefaultRegion(int n) {
        DynamicIslandUtils dynamicIslandUtils = DynamicIslandUtils.INSTANCE;
        int n2 = dynamicIslandUtils.dpToPx(100, this.ctx);
        int n3 = dynamicIslandUtils.dpToPx(42, this.ctx);
        int n4 = dynamicIslandUtils.dpToPx(10, this.ctx);
        int n5 = dynamicIslandUtils.dpToPx(100, this.ctx);
        dynamicIslandUtils = new Region();
        dynamicIslandUtils.set(n - n2, n4, n + n5, n3);
        return dynamicIslandUtils;
    }

    private final Region createTempIslandRegion(DynamicIslandContentView dynamicIslandContentView, float f2) {
        Object object = Boolean.FALSE;
        int n = dynamicIslandContentView.getCurrentBigIslandX((Boolean)object);
        int n2 = dynamicIslandContentView.getCurrentBigIslandWidth((Boolean)object);
        DynamicIslandUtils dynamicIslandUtils = DynamicIslandUtils.INSTANCE;
        int n3 = dynamicIslandUtils.dpToPx(10, this.ctx);
        object = CommonUtils.isLayoutRtl((Context)this.ctx) ? G0.o.a((Object)this.getShowOnceXInRtl(), (Object)(n + n2)) : G0.o.a((Object)n, (Object)(n + n2));
        float f3 = Math.abs(((Number)object.e()).intValue() - ((Number)object.d()).intValue()) + n3 * 2;
        if (f3 > f2 && f2 > 0.0f) {
            f2 = (f3 - f2) / (float)2;
            object = G0.o.a((Object)Float.valueOf(((Number)object.d()).floatValue() - f2), (Object)Float.valueOf(((Number)object.e()).floatValue() + f2));
        } else {
            object = G0.o.a((Object)(((Number)object.d()).intValue() - n3), (Object)(((Number)object.e()).intValue() + n3));
        }
        Object object2 = object.a();
        object = object.b();
        Region region = new Region();
        region.set(((Number)object2).intValue(), dynamicIslandContentView.getIslandViewMarginTop() - dynamicIslandUtils.dpToPx(4, this.ctx), ((Number)object).intValue(), dynamicIslandContentView.getIslandViewMarginTop() + dynamicIslandContentView.getIslandViewHeight() + dynamicIslandUtils.dpToPx(4, this.ctx));
        return region;
    }

    public static /* synthetic */ void dispatchEvent$default(DynamicIslandEventCoordinator dynamicIslandEventCoordinator, DynamicIslandEvent dynamicIslandEvent, DynamicIslandContentView dynamicIslandContentView, int n, Object object) {
        if ((n & 2) != 0) {
            dynamicIslandContentView = null;
        }
        dynamicIslandEventCoordinator.dispatchEvent(dynamicIslandEvent, dynamicIslandContentView);
    }

    private final AddEventCoordinator getAddEventCoordinator() {
        return (AddEventCoordinator)this.addEventCoordinator$delegate.getValue();
    }

    private final AppEventCoordinator getAppEventCoordinator() {
        return (AppEventCoordinator)this.appEventCoordinator$delegate.getValue();
    }

    private final AvoidScreenBurnInEventCoordinator getAvoidScreenBurnInEventCoordinator() {
        return (AvoidScreenBurnInEventCoordinator)this.avoidScreenBurnInEventCoordinator$delegate.getValue();
    }

    private final Region getBigIslandRegion(DynamicIslandContentView dynamicIslandContentView) {
        Region region = new Region();
        Integer n = dynamicIslandContentView != null ? Integer.valueOf(DynamicIslandBaseContentView.getCurrentBigIslandX$default(dynamicIslandContentView, null, 1, null)) : null;
        o.d(n);
        int n2 = n;
        int n3 = dynamicIslandContentView.getIslandViewMarginTop();
        int n4 = DynamicIslandBaseContentView.getCurrentBigIslandX$default(dynamicIslandContentView, null, 1, null);
        int n5 = DynamicIslandBaseContentView.getCurrentBigIslandWidth$default(dynamicIslandContentView, null, 1, null);
        int n6 = dynamicIslandContentView.getIslandViewMarginTop();
        int n7 = dynamicIslandContentView.getIslandViewHeight();
        region.set(n2, n3, n4 + n5, n6 + n7);
        return region;
    }

    private final ClickEventCoordinator getClickEventCoordinator() {
        return (ClickEventCoordinator)this.clickEventCoordinator$delegate.getValue();
    }

    private final CollapseEventCoordinator getCollapseEventCoordinator() {
        return (CollapseEventCoordinator)this.collapseEventCoordinator$delegate.getValue();
    }

    private final ConfigChangedEventCoordinator getConfigChangedEventCoordinator() {
        return (ConfigChangedEventCoordinator)this.configChangedEventCoordinator$delegate.getValue();
    }

    private final DeletedEventCoordinator getDeletedEventCoordinator() {
        return (DeletedEventCoordinator)this.deletedEventCoordinator$delegate.getValue();
    }

    private final Region getFakeExpandedTrackingRegion(Region object) {
        DynamicIslandContentView dynamicIslandContentView = this.expandedStateHandler.getCurrent();
        Object object2 = null;
        StringBuilder stringBuilder = null;
        if (dynamicIslandContentView != null) {
            object2 = dynamicIslandContentView.getFakeView();
            object2 = object2 != null && (object2 = object2.getTrackingToOpenMW()) != null ? (Boolean)object2.getValue() : null;
            DynamicIslandContentFakeView dynamicIslandContentFakeView = dynamicIslandContentView.getFakeView();
            Comparable<StringBuilder> comparable = stringBuilder;
            if (dynamicIslandContentFakeView != null) {
                dynamicIslandContentFakeView = dynamicIslandContentFakeView.getStartEnterMiniWindowBeforeAnimation();
                comparable = stringBuilder;
                if (dynamicIslandContentFakeView != null) {
                    comparable = (Boolean)dynamicIslandContentFakeView.getValue();
                }
            }
            stringBuilder = new StringBuilder();
            stringBuilder.append("getFakeExpandedTrackingRegion ");
            stringBuilder.append(object2);
            stringBuilder.append(" ");
            stringBuilder.append(comparable);
            Log.d((String)"DynamicIslandTouchDebug", (String)stringBuilder.toString());
            object2 = dynamicIslandContentView.getFakeView();
            object2 = object2 != null && (object2 = object2.getTrackingToOpenMW()) != null && (Boolean)object2.getValue() == true || (object2 = dynamicIslandContentView.getFakeView()) != null && (object2 = object2.getStartEnterMiniWindowBeforeAnimation()) != null && (Boolean)object2.getValue() == true ? this.getFullScreenRegion() : object;
        }
        if (object2 != null) {
            object = object2;
        }
        return object;
    }

    private final IslandTempHiddenEventCoordinator getIslandTempHiddenEventCoordinator() {
        return (IslandTempHiddenEventCoordinator)this.islandTempHiddenEventCoordinator$delegate.getValue();
    }

    private final MiniWindowEventCoordinator getMiniWindowEventCoordinator() {
        return (MiniWindowEventCoordinator)this.miniWindowEventCoordinator$delegate.getValue();
    }

    private final int getNavBarFrameHeight() {
        Exception exception2;
        block4: {
            int n;
            block3: {
                int n2;
                Resources resources;
                n = 0;
                try {
                    resources = Resources.getSystem();
                    o.f((Object)resources, (String)"getSystem(...)");
                    n2 = resources.getIdentifier("navigation_bar_frame_height", "dimen", "android");
                    if (n2 == 0) break block3;
                }
                catch (Exception exception2) {
                    break block4;
                }
                n = resources.getDimensionPixelSize(n2);
            }
            return n;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("getNavBarFrameHeight: ");
        stringBuilder.append(exception2);
        Log.e((String)TAG, (String)stringBuilder.toString());
        return 0;
    }

    private final NotificationSettingsManager getNotifySettingsManager() {
        return (NotificationSettingsManager)this.notifySettingsManager$delegate.getValue();
    }

    private final PanelExpandedEventCoordinator getPanelExpandedEventCoordinator() {
        return (PanelExpandedEventCoordinator)this.panelExpandedEventCoordinator$delegate.getValue();
    }

    private final int getShowOnceXInRtl() {
        DynamicIslandContentView dynamicIslandContentView = this.showOnceIslandHandler.getCurrent();
        int n = dynamicIslandContentView != null ? DynamicIslandBaseContentView.getCurrentBigIslandX$default(dynamicIslandContentView, null, 1, null) : 0;
        return n;
    }

    private final Region getSmallBigIslandRegion() {
        DynamicIslandUtils dynamicIslandUtils = DynamicIslandUtils.INSTANCE;
        int n = dynamicIslandUtils.getScreenWidthOld(this.ctx) / 2;
        float f2 = this.windowView.getWindowViewController().getIslandMaxWidth();
        Object object = this.smallIslandStateHandler.getCurrent();
        Object object2 = this.bigIslandStateHandler.getCurrent();
        DynamicIslandContentView dynamicIslandContentView = this.bigIslandStateHandler.getCurrentTempShow();
        DynamicIslandContentView dynamicIslandContentView2 = this.showOnceIslandHandler.getCurrent();
        DynamicIslandContentView dynamicIslandContentView3 = this.expandedStateHandler.getCurrent();
        Object object3 = this.createDefaultRegion(n);
        if (dynamicIslandContentView2 != null && !CommonUtils.INSTANCE.getIS_TABLET()) {
            object3 = Boolean.FALSE;
            int n2 = dynamicIslandContentView2.getCurrentBigIslandX((Boolean)object3);
            int n3 = dynamicIslandContentView2.getCurrentBigIslandWidth((Boolean)object3);
            n = dynamicIslandUtils.dpToPx(10, this.ctx);
            object3 = CommonUtils.isLayoutRtl((Context)this.ctx) ? G0.o.a((Object)this.getShowOnceXInRtl(), (Object)(n2 + n3)) : G0.o.a((Object)n2, (Object)(n2 + n3));
            float f3 = Math.abs(((Number)object3.e()).intValue() - ((Number)object3.d()).intValue()) + n * 2;
            if (f3 > f2 && f2 > 0.0f) {
                f2 = (f3 - f2) / (float)2;
                object3 = G0.o.a((Object)Float.valueOf(((Number)object3.d()).floatValue() - f2), (Object)Float.valueOf(((Number)object3.e()).floatValue() + f2));
            } else {
                object3 = G0.o.a((Object)(((Number)object3.d()).intValue() - n), (Object)(((Number)object3.e()).intValue() + n));
            }
            object = object3.a();
            object2 = object3.b();
            object3 = new Region();
            object3.set(((Number)object).intValue(), dynamicIslandContentView2.getIslandViewMarginTop() - dynamicIslandUtils.dpToPx(4, this.ctx), ((Number)object2).intValue(), dynamicIslandContentView2.getIslandViewMarginTop() + dynamicIslandContentView2.getIslandViewHeight() + dynamicIslandUtils.dpToPx(4, this.ctx));
            return object3;
        }
        if (dynamicIslandContentView != null && object2 != null) {
            object3 = this.createTempIslandRegion(dynamicIslandContentView, f2);
            object3.op(this.createBigIslandRegion((DynamicIslandContentView)((Object)object2), (DynamicIslandContentView)((Object)object), f2), Region.Op.UNION);
        } else if (dynamicIslandContentView != null) {
            object3 = this.createTempIslandRegion(dynamicIslandContentView, f2);
        } else if (object2 != null) {
            object3 = this.createBigIslandRegion((DynamicIslandContentView)((Object)object2), (DynamicIslandContentView)((Object)object), f2);
        } else {
            if (object != null) {
                Log.e((String)"DynamicIslandTouchDebug", (String)"error small island only");
            }
            if (dynamicIslandContentView3 != null) {
                object3 = new Region();
            }
        }
        return object3;
    }

    private final int getSmallXInRtl() {
        DynamicIslandContentView dynamicIslandContentView = this.bigIslandStateHandler.getCurrent();
        int n = 0;
        int n2 = dynamicIslandContentView != null ? DynamicIslandBaseContentView.getCurrentBigIslandX$default(dynamicIslandContentView, null, 1, null) : 0;
        dynamicIslandContentView = this.smallIslandStateHandler.getCurrent();
        int n3 = dynamicIslandContentView != null ? dynamicIslandContentView.getSmallIslandViewWidth() : 0;
        dynamicIslandContentView = this.bigIslandStateHandler.getCurrent();
        int n4 = dynamicIslandContentView != null ? dynamicIslandContentView.getSpace() : 0;
        if (n3 > 0) {
            n = n4 + n3;
        }
        return n2 - n;
    }

    private final SwipeEventCoordinator getSwipeEventCoordinator() {
        return (SwipeEventCoordinator)this.swipeEventCoordinator$delegate.getValue();
    }

    private final UpdateEventCoordinator getUpdateEventCoordinator() {
        return (UpdateEventCoordinator)this.updateEventCoordinator$delegate.getValue();
    }

    private final UpdateWidthEventCoordinator getUpdateWidthEventCoordinator() {
        return (UpdateWidthEventCoordinator)this.updateWidthEventCoordinator$delegate.getValue();
    }

    private final void handleEvent(DynamicIslandEvent dynamicIslandEvent, DynamicIslandContentView object) {
        Object object2 = this.expandedStateHandler.getCurrent();
        Object var4_4 = null;
        object2 = object2 != null && (object2 = object2.getCurrentIslandData()) != null ? object2.getKey() : null;
        Object object3 = new StringBuilder();
        ((StringBuilder)object3).append("handleEventStart: ");
        ((StringBuilder)object3).append(dynamicIslandEvent);
        Log.e((String)"DynamicIslandEventDebug", (String)((StringBuilder)object3).toString());
        this.preHandleEvent(dynamicIslandEvent);
        this.antiBurnInManager.handleEvent(dynamicIslandEvent, (DynamicIslandContentView)((Object)object));
        this.getAddEventCoordinator().handleAppEvent(dynamicIslandEvent, (DynamicIslandContentView)((Object)object), this.hiddenList);
        this.getClickEventCoordinator().handleAppEvent(dynamicIslandEvent, (DynamicIslandContentView)((Object)object), this.hiddenList);
        this.getCollapseEventCoordinator().handleAppEvent(dynamicIslandEvent, (DynamicIslandContentView)((Object)object), this.hiddenList);
        this.getDeletedEventCoordinator().handleAppEvent(dynamicIslandEvent, (DynamicIslandContentView)((Object)object), this.hiddenList);
        this.getSwipeEventCoordinator().handleAppEvent(dynamicIslandEvent, (DynamicIslandContentView)((Object)object), this.hiddenList);
        this.getUpdateWidthEventCoordinator().handleAppEvent(dynamicIslandEvent, (DynamicIslandContentView)((Object)object), this.hiddenList);
        if (!this.swiping || this.showOnceIslandHandler.getCurrent() != null && object != null && (object3 = ((DynamicIslandBaseContentView)((Object)object)).getState()) != null && ((State)object3).getTempShow()) {
            this.getUpdateEventCoordinator().handleAppEvent(dynamicIslandEvent, (DynamicIslandContentView)((Object)object), this.hiddenList);
        }
        this.getAppEventCoordinator().handleAppEvent(dynamicIslandEvent, (DynamicIslandContentView)((Object)object), this.hiddenList);
        this.getMiniWindowEventCoordinator().handleAppEvent(dynamicIslandEvent, (DynamicIslandContentView)((Object)object), this.hiddenList);
        this.getIslandTempHiddenEventCoordinator().handleAppEvent(dynamicIslandEvent, (DynamicIslandContentView)((Object)object), this.hiddenList);
        this.getConfigChangedEventCoordinator().handleAppEvent(dynamicIslandEvent, (DynamicIslandContentView)((Object)object), this.hiddenList);
        this.getPanelExpandedEventCoordinator().handleAppEvent(dynamicIslandEvent, (DynamicIslandContentView)((Object)object), this.hiddenList);
        this.getAvoidScreenBurnInEventCoordinator().handleAppEvent(dynamicIslandEvent, (DynamicIslandContentView)((Object)object), this.hiddenList);
        this.onBigIslandTickerDataChanged();
        this.printCurrentDynamicIslandSituation(dynamicIslandEvent, (DynamicIslandContentView)((Object)object));
        this.checkError(dynamicIslandEvent);
        object3 = this.expandedStateHandler.getCurrent();
        object = var4_4;
        if (object3 != null) {
            object3 = ((DynamicIslandBaseContentView)((Object)object3)).getCurrentIslandData();
            object = var4_4;
            if (object3 != null) {
                object = object3.getKey();
            }
        }
        this.isExpandedChanged = o.c((Object)object, (Object)object2) ^ true;
        object = new StringBuilder();
        ((StringBuilder)object).append("handleEventStop: ");
        ((StringBuilder)object).append(dynamicIslandEvent);
        Log.e((String)"DynamicIslandEventDebug", (String)((StringBuilder)object).toString());
    }

    private final void initBigIslandEffectShader() {
        DynamicIslandAnimationCallback dynamicIslandAnimationCallback = this.getAnimationController().getAnimationCallback$miui_dynamicisland_release();
        DynamicIslandAnimationType dynamicIslandAnimationType = DynamicIslandAnimationType.INIT_TO_BIG;
        DynamicIslandAnimationCallbackType dynamicIslandAnimationCallbackType = DynamicIslandAnimationCallbackType.ANIM_START;
        dynamicIslandAnimationCallback.addAnimationCallback(dynamicIslandAnimationType, dynamicIslandAnimationCallbackType, new Function1(this){
            final DynamicIslandEventCoordinator this$0;
            {
                this.this$0 = dynamicIslandEventCoordinator;
                super(1);
            }

            public final void invoke(String object) {
                o.g((Object)object, (String)"it");
                object = this.this$0.getBigIslandStateHandler().getCurrentTempShow();
                if (object != null && (object = ((DynamicIslandBaseContentView)((Object)object)).getCurrentIslandData()) != null && (object = object.getProperties()) != null && (Integer)object == 0) {
                    DynamicIslandUtils dynamicIslandUtils = DynamicIslandUtils.INSTANCE;
                    object = this.this$0.getBigIslandStateHandler().getCurrentTempShow();
                    object = object != null ? ((DynamicIslandBaseContentView)((Object)object)).getCurrentIslandData() : null;
                    if (dynamicIslandUtils.isGlowEffectEnabledForBigState$miui_dynamicisland_release((DynamicIslandData)object) && (object = this.this$0.getBigIslandStateHandler().getCurrentTempShow()) != null && (object = ((DynamicIslandBaseContentView)((Object)object)).getBigIslandView()) != null) {
                        ((DynamicGlowEffectView)((Object)object)).startGlowEffect$miui_dynamicisland_release();
                    }
                }
            }
        });
        this.getAnimationController().getAnimationCallback$miui_dynamicisland_release().addAnimationCallback(DynamicIslandAnimationType.BIG_TO_DELETED, dynamicIslandAnimationCallbackType, new Function1(this){
            final DynamicIslandEventCoordinator this$0;
            {
                this.this$0 = dynamicIslandEventCoordinator;
                super(1);
            }

            public final void invoke(String object) {
                o.g((Object)object, (String)"it");
                object = this.this$0.getBigIslandStateHandler().getLastTempShow();
                if (object != null && (object = ((DynamicIslandBaseContentView)((Object)object)).getBigIslandView()) != null) {
                    DynamicGlowEffectView.stopGlowEffect$miui_dynamicisland_release$default((DynamicGlowEffectView)((Object)object), false, 1, null);
                }
                this.this$0.getBigIslandStateHandler().setLastTempShow(null);
            }
        });
    }

    private final void initExpandEffectShader() {
        Object object2 = this.getAnimationController().getAnimationCallback$miui_dynamicisland_release();
        DynamicIslandAnimationType dynamicIslandAnimationType = DynamicIslandAnimationType.TO_EXPANDED;
        object2.addAnimationCallback(dynamicIslandAnimationType, DynamicIslandAnimationCallbackType.ANIM_FINISH, new Function1(this){
            final DynamicIslandEventCoordinator this$0;
            {
                this.this$0 = dynamicIslandEventCoordinator;
                super(1);
            }

            public final void invoke(String object) {
                o.g((Object)object, (String)"it");
                object = this.this$0.getExpandedStateHandler().getCurrent();
                if (object != null && (object = ((DynamicIslandBaseContentView)((Object)object)).getExpandedView()) != null) {
                    ((DynamicIslandExpandedView)((Object)object)).startCallingEffectIfNeeded$miui_dynamicisland_release();
                }
                if (this.this$0.getExpandedStateHandler().getCurrent() == null) {
                    Log.w((String)"DynamicIslandEventCoordinator", (String)"Anim TO_EXPANDED:ANIM_FINISH expandedStateHandler.current is null");
                }
            }
        });
        this.getAnimationController().getAnimationCallback$miui_dynamicisland_release().addAnimationCallback(dynamicIslandAnimationType, DynamicIslandAnimationCallbackType.ANIM_START, new Function1(this){
            final DynamicIslandEventCoordinator this$0;
            {
                this.this$0 = dynamicIslandEventCoordinator;
                super(1);
            }

            public final void invoke(String object) {
                o.g((Object)object, (String)"it");
                DynamicIslandUtils dynamicIslandUtils = DynamicIslandUtils.INSTANCE;
                object = this.this$0.getExpandedStateHandler().getCurrent();
                object = object != null ? ((DynamicIslandBaseContentView)((Object)object)).getCurrentIslandData() : null;
                if (dynamicIslandUtils.isGlowEffectEnabledForExpandState$miui_dynamicisland_release((DynamicIslandData)object) && (object = this.this$0.getExpandedStateHandler().getCurrent()) != null && (object = ((DynamicIslandBaseContentView)((Object)object)).getExpandedView()) != null) {
                    ((DynamicGlowEffectView)((Object)object)).startGlowEffect$miui_dynamicisland_release();
                }
            }
        });
        for (Object object2 : m.j((Object[])new DynamicIslandAnimationType[]{DynamicIslandAnimationType.EXPANDED_TO_BIG, DynamicIslandAnimationType.EXPANDED_TO_SMALL, DynamicIslandAnimationType.EXPANDED_TO_TEMP_HIDDEN, DynamicIslandAnimationType.EXPANDED_TO_HIDDEN, DynamicIslandAnimationType.EXPANDED_TO_DELETED})) {
            if (object2 != DynamicIslandAnimationType.EXPANDED_TO_BIG && object2 != DynamicIslandAnimationType.EXPANDED_TO_SMALL) {
                this.getAnimationController().getAnimationCallback$miui_dynamicisland_release().addAnimationCallback((DynamicIslandAnimationType)((Object)object2), DynamicIslandAnimationCallbackType.ANIM_START, new Function1(this){
                    final DynamicIslandEventCoordinator this$0;
                    {
                        this.this$0 = dynamicIslandEventCoordinator;
                        super(1);
                    }

                    public final void invoke(String object) {
                        o.g((Object)object, (String)"it");
                        object = this.this$0.getExpandedStateHandler().getLastExpandedView();
                        if (object != null && (object = ((DynamicIslandBaseContentView)((Object)object)).getExpandedView()) != null) {
                            ((DynamicGlowEffectView)((Object)object)).stopGlowEffect$miui_dynamicisland_release(true);
                        }
                    }
                });
            } else {
                this.getAnimationController().getAnimationCallback$miui_dynamicisland_release().addAnimationCallback((DynamicIslandAnimationType)((Object)object2), DynamicIslandAnimationCallbackType.ANIM_START, new Function1(this){
                    final DynamicIslandEventCoordinator this$0;
                    {
                        this.this$0 = dynamicIslandEventCoordinator;
                        super(1);
                    }

                    public final void invoke(String object) {
                        o.g((Object)object, (String)"it");
                        object = this.this$0.getExpandedStateHandler().getLastExpandedView();
                        if (object != null && (object = ((DynamicIslandBaseContentView)((Object)object)).getExpandedView()) != null) {
                            DynamicGlowEffectView.stopGlowEffect$miui_dynamicisland_release$default((DynamicGlowEffectView)((Object)object), false, 1, null);
                        }
                    }
                });
            }
            this.getAnimationController().getAnimationCallback$miui_dynamicisland_release().addAnimationCallback((DynamicIslandAnimationType)((Object)object2), DynamicIslandAnimationCallbackType.ANIM_START, new Function1(this){
                final DynamicIslandEventCoordinator this$0;
                {
                    this.this$0 = dynamicIslandEventCoordinator;
                    super(1);
                }

                public final void invoke(String object) {
                    o.g((Object)object, (String)"it");
                    object = this.this$0;
                    DynamicIslandEventCoordinator.access$setCollapseAnimationRunningCount$p((DynamicIslandEventCoordinator)object, DynamicIslandEventCoordinator.access$getCollapseAnimationRunningCount$p((DynamicIslandEventCoordinator)object) + 1);
                    DynamicIslandEventCoordinator.access$setCollapseAnimationRunning$p(this.this$0, true);
                    object = this.this$0.getExpandedStateHandler().getLastExpandedView();
                    if (object != null && (object = ((DynamicIslandBaseContentView)((Object)object)).getExpandedView()) != null) {
                        ((DynamicIslandExpandedView)((Object)object)).stopCallingEffectIfNeeded$miui_dynamicisland_release();
                    }
                }
            });
            this.getAnimationController().getAnimationCallback$miui_dynamicisland_release().addAnimationCallback((DynamicIslandAnimationType)((Object)object2), DynamicIslandAnimationCallbackType.ANIM_FINISH, new Function1(this){
                final DynamicIslandEventCoordinator this$0;
                {
                    this.this$0 = dynamicIslandEventCoordinator;
                    super(1);
                }

                public final void invoke(String object) {
                    o.g((Object)object, (String)"it");
                    if (DynamicIslandEventCoordinator.access$getCollapseAnimationRunningCount$p(this.this$0) > 0) {
                        object = this.this$0;
                        DynamicIslandEventCoordinator.access$setCollapseAnimationRunningCount$p((DynamicIslandEventCoordinator)object, DynamicIslandEventCoordinator.access$getCollapseAnimationRunningCount$p((DynamicIslandEventCoordinator)object) - 1);
                    }
                    DynamicIslandEventCoordinator.access$setCollapseAnimationRunning$p(this.this$0, false);
                    this.this$0.getExpandedStateHandler().setLastView(null);
                }
            });
            this.getAnimationController().getAnimationCallback$miui_dynamicisland_release().addAnimationCallback((DynamicIslandAnimationType)((Object)object2), DynamicIslandAnimationCallbackType.ANIM_CANCEL, new Function1(this){
                final DynamicIslandEventCoordinator this$0;
                {
                    this.this$0 = dynamicIslandEventCoordinator;
                    super(1);
                }

                public final void invoke(String object) {
                    o.g((Object)object, (String)"it");
                    if (DynamicIslandEventCoordinator.access$getCollapseAnimationRunningCount$p(this.this$0) > 0) {
                        object = this.this$0;
                        DynamicIslandEventCoordinator.access$setCollapseAnimationRunningCount$p((DynamicIslandEventCoordinator)object, DynamicIslandEventCoordinator.access$getCollapseAnimationRunningCount$p((DynamicIslandEventCoordinator)object) - 1);
                    }
                    DynamicIslandEventCoordinator.access$setCollapseAnimationRunning$p(this.this$0, false);
                }
            });
        }
    }

    private final void initStateHandler() {
        this.expandedStateHandler.setNext(this.bigIslandStateHandler);
        this.bigIslandStateHandler.setNext(this.smallIslandStateHandler);
        this.smallIslandStateHandler.setNext(this.hiddenStateHandler);
    }

    private final Region mergeTouchRegions(Region ... regionArray) {
        Region region = new Region();
        int n = regionArray.length;
        for (int j = 0; j < n; ++j) {
            region.op(regionArray[j], Region.Op.UNION);
        }
        return region;
    }

    private final void onDynamicIslandAnimationStateChanged(boolean bl) {
        Bundle bundle = new Bundle();
        bundle.putString("action_key", "action_island_anim_state_changed");
        bundle.putBoolean("extra_is_animating", bl);
        DynamicIslandContent.DynamicIslandViewChangedListener dynamicIslandViewChangedListener = this.dynamicIslandViewChangedListener;
        if (dynamicIslandViewChangedListener != null) {
            dynamicIslandViewChangedListener.onIslandViewChanged(bundle);
        }
    }

    private final void preHandleEvent(DynamicIslandEvent dynamicIslandEvent) {
        Object object;
        if (this.avoidScreenBurnInHelper.isFadedBefore()) {
            object = this.bigIslandStateHandler.getCurrent();
            if (object != null) {
                this.avoidScreenBurnInHelper.resetFadedView((DynamicIslandContentView)((Object)object));
            }
            if ((object = this.smallIslandStateHandler.getCurrent()) != null) {
                this.avoidScreenBurnInHelper.resetFadedView((DynamicIslandContentView)((Object)object));
            }
        }
        if (dynamicIslandEvent instanceof DynamicIslandEvent.IslandTempHiddenChanged) {
            DynamicIslandEvent.IslandTempHiddenChanged islandTempHiddenChanged = dynamicIslandEvent;
            DynamicIslandWindowState.TempHiddenType tempHiddenType = islandTempHiddenChanged.getType();
            boolean bl = islandTempHiddenChanged.getHide();
            object = new StringBuilder();
            ((StringBuilder)object).append("event.type: ");
            ((StringBuilder)object).append((Object)tempHiddenType);
            ((StringBuilder)object).append(" ");
            ((StringBuilder)object).append(bl);
            Log.d((String)"DynamicIslandEventDebug", (String)((StringBuilder)object).toString());
            if (islandTempHiddenChanged.getType() != DynamicIslandWindowState.TempHiddenType.SCREEN_LOCKED && islandTempHiddenChanged.getType() != DynamicIslandWindowState.TempHiddenType.SHOW_NOTIFICATION_ICONS) {
                this.dynamicIslandWindowState.setScreenLockedChange(false);
            }
        } else {
            if (!(dynamicIslandEvent instanceof DynamicIslandEvent.Collapse)) {
                this.dynamicIslandWindowState.setScreenLockedChange(false);
            }
            this.dynamicIslandWindowState.setTempHiddenChange(Boolean.FALSE);
        }
        if (!(dynamicIslandEvent instanceof DynamicIslandEvent.ConfigChanged)) {
            this.dynamicIslandWindowState.setConfigChange(Boolean.FALSE);
        }
    }

    private final void printCurrentDynamicIslandSituation(DynamicIslandEvent object, DynamicIslandContentView object2) {
        Object object3;
        Object object4 = object2 != null ? object2.getState() : null;
        object3 = object2 != null && (object3 = object2.getCurrentIslandData()) != null ? object3.getKey() : null;
        object2 = object2 != null && (object2 = object2.getCurrentIslandData()) != null ? object2.getTickerData() : null;
        Object object5 = this.expandedStateHandler.getCurrent();
        object5 = object5 != null && (object5 = object5.getCurrentIslandData()) != null ? object5.getKey() : null;
        Object object6 = this.expandedStateHandler.getCurrent();
        object6 = object6 != null && (object6 = ((DynamicIslandBaseContentView)((Object)object6)).getCurrentIslandData()) != null ? object6.getTickerData() : null;
        Object object7 = this.expandedStateHandler.getCurrent();
        object7 = object7 != null && (object7 = ((DynamicIslandBaseContentView)((Object)object7)).getCurrentIslandData()) != null ? object7.getProperties() : null;
        Object object8 = this.expandedStateHandler.getCurrent();
        object8 = object8 != null && (object8 = ((DynamicIslandBaseContentView)((Object)object8)).getCurrentIslandData()) != null ? object8.getPriority() : null;
        Object object9 = this.expandedStateHandler.getCurrent();
        object9 = object9 != null && (object9 = ((DynamicIslandBaseContentView)((Object)object9)).getState()) != null ? ((State)object9).getTime() : null;
        Object object10 = this.expandedStateHandler.getCurrent();
        object10 = object10 != null ? ((DynamicIslandBaseContentView)((Object)object10)).getState() : null;
        boolean bl = object10 instanceof DynamicIslandState.Empty;
        object10 = this.showOnceIslandHandler.getCurrent();
        object10 = object10 != null && (object10 = ((DynamicIslandBaseContentView)((Object)object10)).getCurrentIslandData()) != null ? object10.getKey() : null;
        Object object11 = this.showOnceIslandHandler.getCurrent();
        object11 = object11 != null && (object11 = object11.getCurrentIslandData()) != null ? object11.getTickerData() : null;
        Object object12 = this.showOnceIslandHandler.getCurrent();
        object12 = object12 != null && (object12 = object12.getCurrentIslandData()) != null ? object12.getProperties() : null;
        Object object13 = this.showOnceIslandHandler.getCurrent();
        object13 = object13 != null && (object13 = object13.getCurrentIslandData()) != null ? object13.getProperties() : null;
        Object object14 = this.showOnceIslandHandler.getCurrent();
        object14 = object14 != null && (object14 = object14.getCurrentIslandData()) != null ? object14.getPriority() : null;
        Object object15 = this.showOnceIslandHandler.getCurrent();
        object15 = object15 != null && (object15 = ((DynamicIslandBaseContentView)((Object)object15)).getState()) != null ? ((State)object15).getTime() : null;
        Object object16 = this.showOnceIslandHandler.getCurrent();
        object16 = object16 != null ? ((DynamicIslandBaseContentView)((Object)object16)).getState() : null;
        boolean bl2 = object16 instanceof DynamicIslandState.Empty;
        object16 = this.showOnceIslandHandler.getCurrentTempShow();
        object16 = object16 != null && (object16 = ((DynamicIslandBaseContentView)((Object)object16)).getCurrentIslandData()) != null ? object16.getKey() : null;
        Object object17 = this.bigIslandStateHandler.getCurrent();
        object17 = object17 != null && (object17 = object17.getCurrentIslandData()) != null ? object17.getKey() : null;
        Object object18 = this.bigIslandStateHandler.getCurrent();
        object18 = object18 != null && (object18 = object18.getCurrentIslandData()) != null ? object18.getTickerData() : null;
        Object object19 = this.bigIslandStateHandler.getCurrent();
        object19 = object19 != null && (object19 = object19.getCurrentIslandData()) != null ? object19.getProperties() : null;
        Object object20 = this.bigIslandStateHandler.getCurrent();
        object20 = object20 != null && (object20 = object20.getCurrentIslandData()) != null ? object20.getProperties() : null;
        Object object21 = this.bigIslandStateHandler.getCurrent();
        object21 = object21 != null && (object21 = object21.getCurrentIslandData()) != null ? object21.getPriority() : null;
        Object object22 = this.bigIslandStateHandler.getCurrent();
        object22 = object22 != null && (object22 = ((DynamicIslandBaseContentView)((Object)object22)).getState()) != null ? ((State)object22).getTime() : null;
        Object object23 = this.bigIslandStateHandler.getCurrent();
        object23 = object23 != null ? ((DynamicIslandBaseContentView)((Object)object23)).getState() : null;
        boolean bl3 = object23 instanceof DynamicIslandState.Empty;
        object23 = this.bigIslandStateHandler.getCurrentTempShow();
        object23 = object23 != null && (object23 = ((DynamicIslandBaseContentView)((Object)object23)).getCurrentIslandData()) != null ? object23.getKey() : null;
        Object object24 = this.smallIslandStateHandler.getCurrent();
        object24 = object24 != null && (object24 = object24.getCurrentIslandData()) != null ? object24.getKey() : null;
        Object object25 = this.smallIslandStateHandler.getCurrent();
        object25 = object25 != null && (object25 = object25.getCurrentIslandData()) != null ? object25.getTickerData() : null;
        Object object26 = this.smallIslandStateHandler.getCurrent();
        object26 = object26 != null && (object26 = object26.getCurrentIslandData()) != null ? object26.getProperties() : null;
        Object object27 = this.smallIslandStateHandler.getCurrent();
        object27 = object27 != null && (object27 = object27.getCurrentIslandData()) != null ? object27.getPriority() : null;
        Object object28 = this.smallIslandStateHandler.getCurrent();
        object28 = object28 != null && (object28 = ((DynamicIslandBaseContentView)((Object)object28)).getState()) != null ? ((State)object28).getTime() : null;
        Object object29 = this.smallIslandStateHandler.getCurrent();
        object29 = object29 != null ? ((DynamicIslandBaseContentView)((Object)object29)).getState() : null;
        boolean bl4 = object29 instanceof DynamicIslandState.Empty;
        object29 = this.hiddenStateHandler.getCurrent();
        object29 = object29 != null && (object29 = ((DynamicIslandBaseContentView)((Object)object29)).getCurrentIslandData()) != null ? object29.getKey() : null;
        Object object30 = this.hiddenStateHandler.getCurrent();
        object30 = object30 != null && (object30 = object30.getCurrentIslandData()) != null ? object30.getTickerData() : null;
        Object object31 = this.hiddenStateHandler.getCurrent();
        object31 = object31 != null && (object31 = object31.getCurrentIslandData()) != null ? object31.getProperties() : null;
        Object object32 = this.hiddenStateHandler.getCurrent();
        object32 = object32 != null && (object32 = object32.getCurrentIslandData()) != null ? object32.getPriority() : null;
        Object object33 = this.hiddenStateHandler.getCurrent();
        object33 = object33 != null && (object33 = ((DynamicIslandBaseContentView)((Object)object33)).getState()) != null ? ((State)object33).getTime() : null;
        int n = this.hiddenList.size();
        Object object34 = this.hiddenStateHandler.getCurrent();
        object34 = object34 != null ? ((DynamicIslandBaseContentView)((Object)object34)).getState() : null;
        boolean bl5 = object34 instanceof DynamicIslandState.Empty;
        int n2 = this.hiddenList.size();
        object34 = new StringBuilder();
        ((StringBuilder)object34).append("\n----------------------------------\u5f53\u524d\u5c9b\u7684\u72b6\u6001----------------------------------------\n\u5f53\u524d\u4e8b\u4ef6:");
        ((StringBuilder)object34).append(object);
        ((StringBuilder)object34).append(", currentEventState:");
        ((StringBuilder)object34).append(object4);
        ((StringBuilder)object34).append("event.state.dynamicIslandData?.key:");
        ((StringBuilder)object34).append((String)object3);
        ((StringBuilder)object34).append(",event.state.dynamicIslandData?.tickerData:");
        ((StringBuilder)object34).append((String)object2);
        ((StringBuilder)object34).append(" \n--------------------------------------------------------------------------\n \u5c55\u5f00\u6001: key : ");
        ((StringBuilder)object34).append((String)object5);
        ((StringBuilder)object34).append(", tickerData : ");
        ((StringBuilder)object34).append((String)object6);
        ((StringBuilder)object34).append(" properties :");
        ((StringBuilder)object34).append(object7);
        ((StringBuilder)object34).append(", priority: ");
        ((StringBuilder)object34).append(object8);
        ((StringBuilder)object34).append(", time: ");
        ((StringBuilder)object34).append(object9);
        ((StringBuilder)object34).append(" isEmpty: ");
        ((StringBuilder)object34).append(bl);
        ((StringBuilder)object34).append("\n--------------------------------------------------------------------------\n \u4e34\u65f6\u5c55\u793a\u6001: key : ");
        ((StringBuilder)object34).append((String)object10);
        ((StringBuilder)object34).append(", tickerData : ");
        ((StringBuilder)object34).append((String)object11);
        ((StringBuilder)object34).append(" properties :");
        ((StringBuilder)object34).append(object12);
        ((StringBuilder)object34).append(", properties :");
        ((StringBuilder)object34).append(object13);
        ((StringBuilder)object34).append(", priority: ");
        ((StringBuilder)object34).append(object14);
        ((StringBuilder)object34).append(", time: ");
        ((StringBuilder)object34).append(object15);
        ((StringBuilder)object34).append(" isEmpty: ");
        ((StringBuilder)object34).append(bl2);
        ((StringBuilder)object34).append(" tempShow: ");
        ((StringBuilder)object34).append((String)object16);
        ((StringBuilder)object34).append("\n--------------------------------------------------------------------------\n \u5927\u5c9b\u6001: key : ");
        ((StringBuilder)object34).append((String)object17);
        ((StringBuilder)object34).append(", tickerData : ");
        ((StringBuilder)object34).append((String)object18);
        ((StringBuilder)object34).append(" properties :");
        ((StringBuilder)object34).append(object19);
        ((StringBuilder)object34).append(", properties :");
        ((StringBuilder)object34).append(object20);
        ((StringBuilder)object34).append(", priority: ");
        ((StringBuilder)object34).append(object21);
        ((StringBuilder)object34).append(", time: ");
        ((StringBuilder)object34).append(object22);
        ((StringBuilder)object34).append(" isEmpty: ");
        ((StringBuilder)object34).append(bl3);
        ((StringBuilder)object34).append(" tempShow: ");
        ((StringBuilder)object34).append((String)object23);
        ((StringBuilder)object34).append("\n--------------------------------------------------------------------------\n \u5c0f\u5c9b\u6001: key : ");
        ((StringBuilder)object34).append((String)object24);
        ((StringBuilder)object34).append(", tickerData : ");
        ((StringBuilder)object34).append((String)object25);
        ((StringBuilder)object34).append(" properties :");
        ((StringBuilder)object34).append(object26);
        ((StringBuilder)object34).append(", priority: ");
        ((StringBuilder)object34).append(object27);
        ((StringBuilder)object34).append(", time: ");
        ((StringBuilder)object34).append(object28);
        ((StringBuilder)object34).append(" isEmpty: ");
        ((StringBuilder)object34).append(bl4);
        ((StringBuilder)object34).append("\n--------------------------------------------------------------------------\n \u9690\u85cf\u6001: key : ");
        ((StringBuilder)object34).append((String)object29);
        ((StringBuilder)object34).append(", tickerData : ");
        ((StringBuilder)object34).append((String)object30);
        ((StringBuilder)object34).append(" properties :");
        ((StringBuilder)object34).append(object31);
        ((StringBuilder)object34).append(", priority: ");
        ((StringBuilder)object34).append(object32);
        ((StringBuilder)object34).append(", time: ");
        ((StringBuilder)object34).append(object33);
        ((StringBuilder)object34).append(", hiddenListSize:");
        ((StringBuilder)object34).append(n);
        ((StringBuilder)object34).append(" isEmpty: ");
        ((StringBuilder)object34).append(bl5);
        ((StringBuilder)object34).append("\n------------------------------------\u5e94\u7528\u6001 \u5c0f\u7a97\u6001 \u9690\u85cf\u5217\u8868\u5927\u5c0f");
        ((StringBuilder)object34).append(n2);
        ((StringBuilder)object34).append(",\u8be6\u8bf7\u5982\u4e0b:--------------------------------------\n");
        Log.d((String)TAG, (String)((StringBuilder)object34).toString());
        object = this.appStateHandler.getCurrentList();
        if (object != null) {
            object = object.iterator();
            n = 0;
            while (object.hasNext()) {
                object2 = object.next();
                if (n < 0) {
                    m.n();
                }
                object2 = (object7 = object2) != null && (object2 = ((DynamicIslandBaseContentView)((Object)object7)).getCurrentIslandData()) != null ? object2.getKey() : null;
                object4 = object7 != null && (object4 = ((DynamicIslandBaseContentView)((Object)object7)).getCurrentIslandData()) != null ? object4.getTickerData() : null;
                object3 = object7 != null && (object3 = ((DynamicIslandBaseContentView)((Object)object7)).getCurrentIslandData()) != null ? object3.getProperties() : null;
                object5 = object7 != null && (object5 = ((DynamicIslandBaseContentView)((Object)object7)).getCurrentIslandData()) != null ? object5.getPriority() : null;
                object6 = object7 != null && (object6 = ((DynamicIslandBaseContentView)((Object)object7)).getState()) != null ? ((State)object6).getTime() : null;
                object7 = object7 != null ? ((DynamicIslandBaseContentView)((Object)object7)).getState() : null;
                bl3 = object7 instanceof DynamicIslandState.Empty;
                object7 = new StringBuilder();
                ((StringBuilder)object7).append(" index : ");
                ((StringBuilder)object7).append(n);
                ((StringBuilder)object7).append(", \u5e94\u7528\u6001 key : ");
                ((StringBuilder)object7).append((String)object2);
                ((StringBuilder)object7).append(", tickerData : ");
                ((StringBuilder)object7).append((String)object4);
                ((StringBuilder)object7).append(", properties :");
                ((StringBuilder)object7).append(object3);
                ((StringBuilder)object7).append(", priority: ");
                ((StringBuilder)object7).append(object5);
                ((StringBuilder)object7).append(", time: ");
                ((StringBuilder)object7).append(object6);
                ((StringBuilder)object7).append(" isEmpty: ");
                ((StringBuilder)object7).append(bl3);
                Log.d((String)TAG, (String)((StringBuilder)object7).toString());
                ++n;
            }
        }
        object = this.miniWindowStateHandler.getCurrentMap().entrySet().iterator();
        while (object.hasNext()) {
            object4 = (ArrayList)((Map.Entry)object.next()).getValue();
            object2 = object;
            if (object4 != null) {
                object4 = object4.iterator();
                n = 0;
                while (true) {
                    object2 = object;
                    if (!object4.hasNext()) break;
                    object2 = object4.next();
                    if (n < 0) {
                        m.n();
                    }
                    object2 = (object8 = object2) != null && (object2 = ((DynamicIslandBaseContentView)((Object)object8)).getCurrentIslandData()) != null ? object2.getKey() : null;
                    object3 = object8 != null && (object3 = ((DynamicIslandBaseContentView)((Object)object8)).getCurrentIslandData()) != null ? object3.getTickerData() : null;
                    object5 = object8 != null && (object5 = ((DynamicIslandBaseContentView)((Object)object8)).getCurrentIslandData()) != null ? object5.getProperties() : null;
                    object6 = object8 != null && (object6 = ((DynamicIslandBaseContentView)((Object)object8)).getCurrentIslandData()) != null ? object6.getPriority() : null;
                    object7 = object8 != null && (object7 = ((DynamicIslandBaseContentView)((Object)object8)).getState()) != null ? ((State)object7).getTime() : null;
                    object8 = object8 != null ? ((DynamicIslandBaseContentView)((Object)object8)).getState() : null;
                    bl3 = object8 instanceof DynamicIslandState.Empty;
                    object8 = new StringBuilder();
                    ((StringBuilder)object8).append(" index : ");
                    ((StringBuilder)object8).append(n);
                    ((StringBuilder)object8).append(", \u5c0f\u7a97\u6001 key : ");
                    ((StringBuilder)object8).append((String)object2);
                    ((StringBuilder)object8).append(", tickerData : ");
                    ((StringBuilder)object8).append((String)object3);
                    ((StringBuilder)object8).append(", properties :");
                    ((StringBuilder)object8).append(object5);
                    ((StringBuilder)object8).append(", priority: ");
                    ((StringBuilder)object8).append(object6);
                    ((StringBuilder)object8).append(", time: ");
                    ((StringBuilder)object8).append(object7);
                    ((StringBuilder)object8).append(" isEmpty: ");
                    ((StringBuilder)object8).append(bl3);
                    Log.d((String)TAG, (String)((StringBuilder)object8).toString());
                    ++n;
                }
            }
            object = object2;
        }
        object = this.hiddenList.iterator();
        n = 0;
        while (object.hasNext()) {
            object2 = object.next();
            if (n < 0) {
                m.n();
            }
            object2 = (object2 = ((DynamicIslandBaseContentView)((Object)(object7 = object2))).getCurrentIslandData()) != null ? object2.getKey() : null;
            object4 = ((DynamicIslandBaseContentView)((Object)object7)).getCurrentIslandData();
            object4 = object4 != null ? object4.getTickerData() : null;
            object3 = ((DynamicIslandBaseContentView)((Object)object7)).getCurrentIslandData();
            object3 = object3 != null ? object3.getProperties() : null;
            object5 = ((DynamicIslandBaseContentView)((Object)object7)).getCurrentIslandData();
            object5 = object5 != null ? object5.getPriority() : null;
            object6 = ((DynamicIslandBaseContentView)((Object)object7)).getState();
            object6 = object6 != null ? ((State)object6).getTime() : null;
            bl3 = ((DynamicIslandBaseContentView)((Object)object7)).getState() instanceof DynamicIslandState.Empty;
            object7 = new StringBuilder();
            ((StringBuilder)object7).append("\u9690\u85cf\u5217\u8868 index : ");
            ((StringBuilder)object7).append(n);
            ((StringBuilder)object7).append(", key : ");
            ((StringBuilder)object7).append((String)object2);
            ((StringBuilder)object7).append(", tickerData : ");
            ((StringBuilder)object7).append((String)object4);
            ((StringBuilder)object7).append(", properties :");
            ((StringBuilder)object7).append(object3);
            ((StringBuilder)object7).append(", priority: ");
            ((StringBuilder)object7).append(object5);
            ((StringBuilder)object7).append(", time: ");
            ((StringBuilder)object7).append(object6);
            ((StringBuilder)object7).append(" isEmpty: ");
            ((StringBuilder)object7).append(bl3);
            Log.d((String)TAG, (String)((StringBuilder)object7).toString());
            ++n;
        }
    }

    private final boolean regionChanged(Region region) {
        region = new Region(region);
        region.op((Region)this._touchRegion.getValue(), Region.Op.XOR);
        return region.isEmpty() ^ true;
    }

    private final void resetStateForExitApp() {
        Iterator<DynamicIslandContentView> iterator = new ArrayList<DynamicIslandContentView>(this.getAppEventCoordinator().getExitAppStateList()).iterator();
        o.f(iterator, (String)"iterator(...)");
        while (iterator.hasNext()) {
            DynamicIslandContentView dynamicIslandContentView = iterator.next();
            Object object = dynamicIslandContentView.getCurrentIslandData();
            object = object != null && (object = object.getExtras()) != null ? object.getString("miui.pkg.name") : null;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("resetStateForExitApp : ");
            stringBuilder.append((String)object);
            Log.d((String)"DynamicIslandAnimDebug", (String)stringBuilder.toString());
            dynamicIslandContentView.setOpenAppFromIsland(false);
            object = dynamicIslandContentView.getFakeView();
            if (object == null) continue;
            DynamicIslandContentFakeView.updateViewStateWhenCloseEnd$default((DynamicIslandContentFakeView)((Object)object), false, null, 3, null);
        }
        this.getAppEventCoordinator().getExitAppStateList().clear();
    }

    private final void setShadow() {
        Object object;
        Object object2 = this.expandedStateHandler.getCurrent();
        if (object2 != null) {
            object2.showShadowNoANim();
            object2 = object2.getFakeView();
            if (object2 != null) {
                ((DynamicIslandContentFakeView)((Object)object2)).showShadowNoANim();
            }
        }
        if (CommonUtils.INSTANCE.getIS_TABLET() && (object2 = this.bigIslandStateHandler.getCurrentTempShow()) != null) {
            object2.showShadowForPad();
            object2 = object2.getFakeView();
            if (object2 != null) {
                object2.showShadowForPad();
            }
        }
        if ((object2 = this.bigIslandStateHandler.getCurrent()) != null) {
            object2.clearShadow();
            object2 = object2.getFakeView();
            if (object2 != null) {
                ((DynamicIslandContentFakeView)((Object)object2)).clearShadow();
            }
        }
        if ((object2 = this.showOnceIslandHandler.getCurrent()) != null) {
            object2.clearShadow();
            object2 = object2.getFakeView();
            if (object2 != null) {
                ((DynamicIslandContentFakeView)((Object)object2)).clearShadow();
            }
        }
        if ((object2 = this.smallIslandStateHandler.getCurrent()) != null) {
            object2.clearShadow();
            object2 = object2.getFakeView();
            if (object2 != null) {
                ((DynamicIslandContentFakeView)((Object)object2)).clearShadow();
            }
        }
        object2 = this.miniWindowStateHandler.getCurrentMap().entrySet().iterator();
        while (object2.hasNext()) {
            object = (ArrayList)((Map.Entry)object2.next()).getValue();
            if (object == null) continue;
            object = object.iterator();
            while (object.hasNext()) {
                DynamicIslandBaseContentView dynamicIslandBaseContentView = (DynamicIslandContentView)((Object)object.next());
                if (dynamicIslandBaseContentView != null) {
                    ((DynamicIslandContentView)dynamicIslandBaseContentView).clearShadow();
                }
                if (dynamicIslandBaseContentView == null || (dynamicIslandBaseContentView = dynamicIslandBaseContentView.getFakeView()) == null) continue;
                ((DynamicIslandContentFakeView)dynamicIslandBaseContentView).clearShadow();
            }
        }
        object2 = this.appStateHandler.getCurrentList();
        if (object2 != null) {
            object2 = object2.iterator();
            while (object2.hasNext()) {
                object = (DynamicIslandContentView)((Object)object2.next());
                if (object != null) {
                    ((DynamicIslandContentView)((Object)object)).clearShadow();
                }
                if (object == null || (object = ((DynamicIslandBaseContentView)((Object)object)).getFakeView()) == null) continue;
                ((DynamicIslandContentFakeView)((Object)object)).clearShadow();
            }
        }
    }

    /*
     * Unable to fully structure code
     */
    private final void updateWindowHeight() {
        block9: {
            block10: {
                block13: {
                    block12: {
                        block11: {
                            block8: {
                                var6_1 = this.bigIslandStateHandler.getCurrent();
                                var7_2 = this.showOnceIslandHandler.getCurrent();
                                var5_3 = this.bigIslandStateHandler.getCurrentTempShow();
                                var8_4 = this.expandedStateHandler.getCurrent();
                                var4_5 = (Boolean)this.getWindowState().getTempHidden().getValue();
                                if (!this.windowAnimRunning) break block8;
                                if (!DynamicIslandAnimUtils.INSTANCE.supportFreeformNotHigh()) {
                                    Log.d((String)"DynamicIslandEventDebug", (String)"windowAnimRunning");
                                    this._state.setValue((Object)DynamicIslandUtils.INSTANCE.getScreenHeightOld(this.ctx));
                                }
                                break block9;
                            }
                            if (this.collapseAnimationRunning || this.collapseAnimationRunningCount > 0) break block10;
                            if (var8_4 == null) break block11;
                            var2_6 = var8_4.getExpandedViewY();
                            var3_11 = var8_4.getExpandedViewHeight();
                            var5_3 = new StringBuilder();
                            var5_3.append("expanded: ");
                            var5_3.append(var2_6 + var3_11);
                            Log.d((String)"DynamicIslandEventDebug", (String)var5_3.toString());
                            this._state.setValue((Object)DynamicIslandUtils.INSTANCE.getScreenHeightOld(this.ctx));
                            break block9;
                        }
                        if (var7_2 == null) break block12;
                        var1_12 = var7_2.getY();
                        var2_7 = var7_2.getHeight();
                        var5_3 = new StringBuilder();
                        var5_3.append("showOnceIsland: ");
                        var5_3.append(var1_12);
                        var5_3.append(" ");
                        var5_3.append(var2_7);
                        Log.d((String)"DynamicIslandEventDebug", (String)var5_3.toString());
                        this._state.setValue((Object)var7_2.getIslandWindowHeight());
                        break block9;
                    }
                    if (var6_1 == null || var4_5) break block13;
                    var1_13 = var6_1.getY();
                    var2_8 = var6_1.getHeight();
                    var7_2 = new StringBuilder();
                    var7_2.append("bigIsland: ");
                    var7_2.append(var1_13);
                    var7_2.append(" ");
                    var7_2.append(var2_8);
                    Log.d((String)"DynamicIslandEventDebug", (String)var7_2.toString());
                    var7_2 = this._state;
                    if (var5_3 == null) ** GOTO lbl-1000
                    var5_3 = var5_3.getIslandWindowHeight();
                    if (!CommonUtils.INSTANCE.getIS_TABLET()) {
                        var5_3 = null;
                    }
                    if (var5_3 != null) {
                        var2_8 = var5_3.intValue();
                    } else lbl-1000:
                    // 2 sources

                    {
                        var2_8 = var6_1.getIslandWindowHeight();
                    }
                    var7_2.setValue((Object)var2_8);
                    break block9;
                }
                if (var5_3 != null) {
                    if (CommonUtils.INSTANCE.getIS_TABLET()) {
                        var1_14 = var5_3.getY();
                        var2_9 = var5_3.getHeight();
                        var5_3 = new StringBuilder();
                        var5_3.append("bigIslandCurrentTempShow: ");
                        var5_3.append(var1_14);
                        var5_3.append(" ");
                        var5_3.append(var2_9);
                        Log.d((String)"DynamicIslandEventDebug", (String)var5_3.toString());
                        this._state.setValue((Object)DynamicIslandUtils.INSTANCE.getScreenHeightOld(this.ctx));
                    } else {
                        var1_15 = var5_3.getY();
                        var2_10 = var5_3.getHeight();
                        var6_1 = new StringBuilder();
                        var6_1.append("bigIslandCurrentTempShow: ");
                        var6_1.append(var1_15);
                        var6_1.append(" ");
                        var6_1.append(var2_10);
                        Log.d((String)"DynamicIslandEventDebug", (String)var6_1.toString());
                        this._state.setValue((Object)var5_3.getIslandWindowHeight());
                    }
                } else {
                    Log.d((String)"DynamicIslandEventDebug", (String)"other");
                    this._state.setValue((Object)0);
                }
                break block9;
            }
            Log.d((String)"DynamicIslandEventDebug", (String)"collapseAnimation");
            this._state.setValue((Object)DynamicIslandUtils.INSTANCE.getScreenHeightOld(this.ctx));
        }
    }

    private final void updateWindowHeightAnimStart(boolean bl, DynamicIslandContentView dynamicIslandContentView) {
        DynamicIslandContentView dynamicIslandContentView2 = this.bigIslandStateHandler.getCurrent();
        DynamicIslandContentView dynamicIslandContentView3 = this.bigIslandStateHandler.getCurrentTempShow();
        DynamicIslandAnimUtils dynamicIslandAnimUtils = DynamicIslandAnimUtils.INSTANCE;
        if ((dynamicIslandAnimUtils.featureDynamicIslandIsMiddle() || dynamicIslandAnimUtils.featureDynamicIslandNoElementButFreeform()) && this.islandFreeformAnimating(dynamicIslandContentView)) {
            this.updateWindowHeightForFreeform(this.freeformBottom);
        } else if (bl || this.collapseAnimationRunningCount > 0 || ((Number)this._state.getValue()).intValue() == 0 && dynamicIslandContentView2 != null || ((Number)this._state.getValue()).intValue() == 0 && dynamicIslandContentView3 != null || CommonUtils.INSTANCE.getIS_TABLET() && dynamicIslandContentView3 != null) {
            this._state.setValue((Object)DynamicIslandUtils.INSTANCE.getScreenHeightOld(this.ctx));
        }
    }

    public final void addDynamicIslandViewChangedListener(DynamicIslandContent.DynamicIslandViewChangedListener dynamicIslandViewChangedListener) {
        o.g((Object)dynamicIslandViewChangedListener, (String)"listener");
        this.dynamicIslandViewChangedListener = dynamicIslandViewChangedListener;
    }

    public final void alignBurnInStates() {
        this.antiBurnInManager.alignBurnInStates();
    }

    public final void alreadyCloseAppEnd(Bundle bundle) {
        DynamicIslandContent.DynamicIslandViewChangedListener dynamicIslandViewChangedListener = this.dynamicIslandViewChangedListener;
        if (dynamicIslandViewChangedListener != null) {
            dynamicIslandViewChangedListener.onDynamicPluginCallback("onDynamicPluginCallback_alreadyCloseAppEnd", bundle);
        }
    }

    public final void bigToExpanded(Bundle bundle) {
        DynamicIslandContent.DynamicIslandViewChangedListener dynamicIslandViewChangedListener = this.dynamicIslandViewChangedListener;
        if (dynamicIslandViewChangedListener != null) {
            dynamicIslandViewChangedListener.onDynamicPluginCallback("onDynamicPluginCallback_bigToExpanded", bundle);
        }
    }

    public final void bigToSmall(Bundle bundle) {
        DynamicIslandContent.DynamicIslandViewChangedListener dynamicIslandViewChangedListener = this.dynamicIslandViewChangedListener;
        if (dynamicIslandViewChangedListener != null) {
            dynamicIslandViewChangedListener.onDynamicPluginCallback("onDynamicPluginCallback_bigToSmall", bundle);
        }
    }

    public final DynamicIslandState calculateCollapse(DynamicIslandContentView dynamicIslandContentView) {
        return this.bigIslandStateHandler.calculateCollapse(dynamicIslandContentView);
    }

    public final boolean canExpanded(boolean bl, View view, String string) {
        return this.windowView.canExpanded(bl, view, string);
    }

    public final boolean canExpandedViewTrack(DynamicIslandContentView dynamicIslandContentView) {
        return this.getAnimationController().canExpandedViewTrack(dynamicIslandContentView);
    }

    public final void collapseStatusBar(Context object) {
        o.g((Object)object, (String)"context");
        try {
            object = object.getSystemService("statusbar");
            object.getClass().getMethod("collapsePanels", null).invoke(object, null);
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    public final void dispatchEvent(DynamicIslandEvent dynamicIslandEvent, DynamicIslandContentView dynamicIslandContentView) {
        o.g((Object)dynamicIslandEvent, (String)"event");
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("dispatchEvent: ");
        stringBuilder.append(dynamicIslandEvent);
        Log.d((String)"DynamicIslandEventDebug", (String)stringBuilder.toString());
        this.handlingEvent = dynamicIslandEvent;
        this.handleEvent(dynamicIslandEvent, dynamicIslandContentView);
    }

    public final void dispatchPress(boolean bl, boolean bl2, boolean bl3) {
        this.hasResetPress = false;
        if (bl) {
            this.getAnimationController().onPress(this.bigIslandStateHandler.getCurrent());
        } else if (bl2) {
            this.getAnimationController().onPress(this.smallIslandStateHandler.getCurrent());
        } else if (bl3) {
            this.getAnimationController().onPress(this.expandedStateHandler.getCurrent());
        }
    }

    public final void dispatchSwipe(float f2, float f3, boolean bl) {
        this.swiping = true;
        if (!this.horizontalSwipeDispatched && !this.verticalSwipeDispatched) {
            if (Math.abs(f2) > Math.abs(f3)) {
                this.horizontalSwipeDispatched = true;
            } else if (Math.abs(f2) < Math.abs(f3)) {
                this.verticalSwipeDispatched = true;
            }
        }
        this.getSwipeEventCoordinator().handleSwipe(f2, f3, bl, this.hiddenList);
    }

    public final void expandedToBig(Bundle bundle) {
        DynamicIslandContent.DynamicIslandViewChangedListener dynamicIslandViewChangedListener = this.dynamicIslandViewChangedListener;
        if (dynamicIslandViewChangedListener != null) {
            dynamicIslandViewChangedListener.onDynamicPluginCallback("onDynamicPluginCallback_expandedToBig", bundle);
        }
    }

    public final void expandedToSmall(Bundle bundle) {
        DynamicIslandContent.DynamicIslandViewChangedListener dynamicIslandViewChangedListener = this.dynamicIslandViewChangedListener;
        if (dynamicIslandViewChangedListener != null) {
            dynamicIslandViewChangedListener.onDynamicPluginCallback("onDynamicPluginCallback_expandedToSmall", bundle);
        }
    }

    public final void finishDropDownExpandedIsland(Bundle bundle) {
        o.g((Object)bundle, (String)"bundle");
        bundle.putString("plugin_callback_type", "pull_down_type_finish");
        DynamicIslandContent.DynamicIslandViewChangedListener dynamicIslandViewChangedListener = this.dynamicIslandViewChangedListener;
        if (dynamicIslandViewChangedListener != null) {
            dynamicIslandViewChangedListener.onDynamicPluginCallback("onDynamicPluginCallback_dropDownExpandedIsland", bundle);
        }
    }

    public final DynamicIslandAnimationController getAnimationController() {
        return (DynamicIslandAnimationController)this.animationController$delegate.getValue();
    }

    public final AppLockController getAppLockController() {
        return this.appLockController;
    }

    public final AppStateHandler getAppStateHandler() {
        return this.appStateHandler;
    }

    public final List<DynamicIslandContentView> getBigIsLandAndSmallIsLandList() {
        ArrayList<DynamicIslandContentView> arrayList = new ArrayList<DynamicIslandContentView>();
        Object object = this.bigIslandStateHandler.getCurrent();
        Object var2_3 = null;
        if ((object = object != null && (object = object.getCurrentIslandData()) != null && (object = object.getExtras()) != null ? object.getString("miui.pkg.name") : null) != null) {
            arrayList.add(this.bigIslandStateHandler.getCurrent());
        }
        DynamicIslandContentView dynamicIslandContentView = this.smallIslandStateHandler.getCurrent();
        object = var2_3;
        if (dynamicIslandContentView != null) {
            dynamicIslandContentView = dynamicIslandContentView.getCurrentIslandData();
            object = var2_3;
            if (dynamicIslandContentView != null) {
                dynamicIslandContentView = dynamicIslandContentView.getExtras();
                object = var2_3;
                if (dynamicIslandContentView != null) {
                    object = dynamicIslandContentView.getString("miui.pkg.name");
                }
            }
        }
        if (object != null) {
            arrayList.add(this.smallIslandStateHandler.getCurrent());
        }
        return arrayList;
    }

    public final I getBigIslandRegion() {
        return this.bigIslandRegion;
    }

    public final BigIslandStateHandler getBigIslandStateHandler() {
        return this.bigIslandStateHandler;
    }

    public final long getBurnInTimeout() {
        return this.antiBurnInManager.getBurnInTimeout();
    }

    public final Region getDefaultIslandTouchRegion() {
        DynamicIslandUtils dynamicIslandUtils = DynamicIslandUtils.INSTANCE;
        int n = dynamicIslandUtils.getScreenWidthOld(this.ctx) / 2;
        return new Region(n - dynamicIslandUtils.dpToPx(100, this.ctx), dynamicIslandUtils.dpToPx(10, this.ctx), n + dynamicIslandUtils.dpToPx(100, this.ctx), dynamicIslandUtils.dpToPx(42, this.ctx));
    }

    public final DynamicIslandContent.DynamicIslandViewChangedListener getDynamicIslandViewChangedListener() {
        return this.dynamicIslandViewChangedListener;
    }

    public final DynamicIslandWindowState getDynamicIslandWindowState() {
        return this.dynamicIslandWindowState;
    }

    public final boolean getEnterMiniWindow() {
        return this.enterMiniWindow;
    }

    public final Region getExpandedIslandRegion() {
        Region region = new Region();
        DynamicIslandContentView dynamicIslandContentView = this.expandedStateHandler.getCurrent();
        if (dynamicIslandContentView != null) {
            region.set(dynamicIslandContentView.getExpandedViewMarginHorizontal(), dynamicIslandContentView.getExpandedViewY(), dynamicIslandContentView.getExpandedViewMarginHorizontal() + dynamicIslandContentView.getExpandedViewWidth(), dynamicIslandContentView.getExpandedViewY() + dynamicIslandContentView.getExpandedViewHeight());
        }
        return region;
    }

    public final I getExpandedState() {
        return this.expandedState;
    }

    public final ExpandedStateHandler getExpandedStateHandler() {
        return this.expandedStateHandler;
    }

    public final I getExpandedViewRegion() {
        return this.expandedViewRegion;
    }

    public final Region getFullScreenRegion() {
        int n;
        Object object = DynamicIslandUtils.INSTANCE;
        int n2 = ((DynamicIslandUtils)object).getScreenWidthOld(this.ctx);
        int n3 = ((DynamicIslandUtils)object).getScreenHeightOld(this.ctx);
        int n4 = n = this.getNavBarFrameHeight();
        if (n == 0) {
            n4 = ((DynamicIslandUtils)object).dpToPx(48, this.ctx);
        }
        object = new StringBuilder();
        ((StringBuilder)object).append("getFullScreenRegion: ");
        ((StringBuilder)object).append(n2);
        ((StringBuilder)object).append(", ");
        ((StringBuilder)object).append(n3);
        ((StringBuilder)object).append(", ");
        ((StringBuilder)object).append(n4);
        Log.d((String)TAG, (String)((StringBuilder)object).toString());
        return new Region(82, 0, n2 - 82, n3 - n4);
    }

    public final DynamicIslandEvent getHandlingEvent() {
        return this.handlingEvent;
    }

    public final boolean getHasAppExpandedState() {
        return this.hasAppExpandedState;
    }

    public final I getHeadsUpZone() {
        return this.headsUpZone;
    }

    public final HiddenStateHandler getHiddenStateHandler() {
        return this.hiddenStateHandler;
    }

    public final boolean getHorizontalSwipeDispatched() {
        return this.horizontalSwipeDispatched;
    }

    public final I getIslandRegion() {
        return this.islandRegion;
    }

    public final boolean getKeyguardShowing() {
        return this.keyguardShowing;
    }

    public final String getLastFullScreenActivityPkg() {
        return this.lastFullScreenActivityPkg;
    }

    public final MiniWindowStateHandler getMiniWindowStateHandler() {
        return this.miniWindowStateHandler;
    }

    public final HashMap<String, Boolean> getPkgSupportFreeform() {
        return this.pkgSupportFreeform;
    }

    public final ShowOnceIslandHandler getShowOnceIslandHandler() {
        return this.showOnceIslandHandler;
    }

    public final SmallIslandStateHandler getSmallIslandStateHandler() {
        return this.smallIslandStateHandler;
    }

    public final I getState() {
        return this.state;
    }

    public final I getStatusBarVisible() {
        return this.statusBarVisible;
    }

    public final boolean getSwiping() {
        return this.swiping;
    }

    public final DynamicIslandContentView getTempShow() {
        return this.showOnceIslandHandler.getCurrent();
    }

    public final I getTouchRegion() {
        return this.touchRegion;
    }

    public final DynamicIslandContentView getUpdateState(String string, String object) {
        DynamicIslandContentView dynamicIslandContentView;
        Object object2;
        Iterator iterator;
        block9: {
            iterator = this.hiddenList.iterator();
            do {
                boolean bl = iterator.hasNext();
                object2 = null;
                if (!bl) break block9;
                dynamicIslandContentView = (DynamicIslandContentView)((Object)iterator.next());
                DynamicIslandData dynamicIslandData = dynamicIslandContentView.getCurrentIslandData();
                if (dynamicIslandData == null) continue;
                object2 = dynamicIslandData.getKey();
            } while (!o.c((Object)object2, (Object)string));
            return dynamicIslandContentView;
        }
        object2 = this.expandedStateHandler.getCurrent();
        object2 = object2 != null && (object2 = object2.getCurrentIslandData()) != null ? object2.getKey() : null;
        if (o.c((Object)object2, (Object)string)) {
            return this.expandedStateHandler.getCurrent();
        }
        object2 = this.bigIslandStateHandler.getCurrent();
        object2 = object2 != null && (object2 = object2.getCurrentIslandData()) != null ? object2.getKey() : null;
        if (o.c((Object)object2, (Object)string)) {
            return this.bigIslandStateHandler.getCurrent();
        }
        object2 = this.bigIslandStateHandler.getCurrentTempShow();
        object2 = object2 != null && (object2 = object2.getCurrentIslandData()) != null ? object2.getKey() : null;
        if (o.c((Object)object2, (Object)string)) {
            return this.bigIslandStateHandler.getCurrentTempShow();
        }
        object2 = this.smallIslandStateHandler.getCurrent();
        object2 = object2 != null && (object2 = object2.getCurrentIslandData()) != null ? object2.getKey() : null;
        if (o.c((Object)object2, (Object)string)) {
            return this.smallIslandStateHandler.getCurrent();
        }
        object2 = this.appStateHandler.getCurrentList();
        if (object2 != null) {
            iterator = object2.iterator();
            while (iterator.hasNext()) {
                dynamicIslandContentView = (DynamicIslandContentView)((Object)iterator.next());
                object2 = dynamicIslandContentView != null && (object2 = dynamicIslandContentView.getCurrentIslandData()) != null ? object2.getKey() : null;
                if (!o.c((Object)object2, (Object)string)) continue;
                return dynamicIslandContentView;
            }
        }
        if ((object = (ArrayList)this.miniWindowStateHandler.getCurrentMap().get(object)) != null) {
            object2 = object.iterator();
            while (object2.hasNext()) {
                dynamicIslandContentView = (DynamicIslandContentView)((Object)object2.next());
                object = dynamicIslandContentView != null && (object = dynamicIslandContentView.getCurrentIslandData()) != null ? object.getKey() : null;
                if (!o.c((Object)object, (Object)string)) continue;
                return dynamicIslandContentView;
            }
        }
        return null;
    }

    public final boolean getUserExpanded() {
        return this._userExpanded;
    }

    public final boolean getVerticalSwipeDispatched() {
        return this.verticalSwipeDispatched;
    }

    public final boolean getWindowAnimRunning() {
        return this.windowAnimRunning;
    }

    public final DynamicIslandWindowState getWindowState() {
        return this.dynamicIslandWindowState;
    }

    public final DynamicIslandWindowView getWindowView() {
        return this.windowView;
    }

    public final void handleExpandGestureListener(Region region) {
        boolean bl;
        Bundle bundle = new Bundle();
        boolean bl2 = bl = false;
        if (region != null) {
            region = region.getBounds();
            bl2 = bl;
            if (region != null) {
                bl2 = bl;
                if (!region.isEmpty()) {
                    bl2 = true;
                }
            }
        }
        bundle.putBoolean("register_miui_gesture_listener", bl2);
        region = this.dynamicIslandViewChangedListener;
        if (region != null) {
            region.onDynamicPluginCallback("onDynamicPluginCallback_handleGesture", bundle);
        }
    }

    public final void handleScreenBurnInStrategy(int n) {
        DynamicIslandContentView dynamicIslandContentView = this.bigIslandStateHandler.getCurrent();
        if (dynamicIslandContentView != null) {
            this.avoidScreenBurnInHelper.updateViewForAvoidingScreenBurnIn(dynamicIslandContentView, n);
        }
        if ((dynamicIslandContentView = this.smallIslandStateHandler.getCurrent()) != null) {
            this.avoidScreenBurnInHelper.updateViewForAvoidingScreenBurnIn(dynamicIslandContentView, n);
        }
    }

    public final List<DynamicIslandContentView> hasIsland(String string) {
        o.g((Object)string, (String)"pkg");
        ArrayList<DynamicIslandContentView> arrayList = new ArrayList<DynamicIslandContentView>();
        Object object = this.appStateHandler.getCurrentList();
        if (object != null) {
            for (Object object2 : object) {
                object = object2 != null && (object = object2.getCurrentIslandData()) != null && (object = object.getExtras()) != null ? object.getString("miui.pkg.name") : null;
                if (!o.c((Object)object, (Object)string)) continue;
                arrayList.add((DynamicIslandContentView)((Object)object2));
            }
        }
        if ((object = this.miniWindowStateHandler.getCurrentMap().get(string)) != null) {
            arrayList.addAll((Collection<DynamicIslandContentView>)object);
        }
        if (o.c((Object)(object = (object = this.expandedStateHandler.getCurrent()) != null && (object = object.getCurrentIslandData()) != null && (object = object.getExtras()) != null ? object.getString("miui.pkg.name") : null), (Object)string)) {
            arrayList.add(this.expandedStateHandler.getCurrent());
        }
        if (o.c((Object)(object = (object = this.bigIslandStateHandler.getCurrent()) != null && (object = object.getCurrentIslandData()) != null && (object = object.getExtras()) != null ? object.getString("miui.pkg.name") : null), (Object)string)) {
            arrayList.add(this.bigIslandStateHandler.getCurrent());
        }
        if (o.c((Object)(object = (object = this.smallIslandStateHandler.getCurrent()) != null && (object = object.getCurrentIslandData()) != null && (object = object.getExtras()) != null ? object.getString("miui.pkg.name") : null), (Object)string)) {
            arrayList.add(this.smallIslandStateHandler.getCurrent());
        }
        for (DynamicIslandContentView dynamicIslandContentView : this.hiddenList) {
            object = dynamicIslandContentView.getCurrentIslandData();
            object = object != null && (object = object.getExtras()) != null ? object.getString("miui.pkg.name") : null;
            if (!o.c((Object)object, (Object)string)) continue;
            arrayList.add(dynamicIslandContentView);
        }
        return arrayList;
    }

    public final boolean hasSamePackageIsland(String string) {
        o.g((Object)string, (String)"pkg");
        int n = this.hasIsland(string).size();
        boolean bl = true;
        if (n <= 1) {
            bl = false;
        }
        return bl;
    }

    public final boolean hasSmallIsland() {
        Object object = this.showOnceIslandHandler.getCurrent();
        boolean bl = false;
        if (object != null) {
            return false;
        }
        boolean bl2 = bl;
        if (this.smallIslandStateHandler.getCurrent() != null) {
            DynamicIslandWindowState dynamicIslandWindowState = this.dynamicIslandWindowState;
            object = this.smallIslandStateHandler.getCurrent();
            object = object != null && (object = object.getCurrentIslandData()) != null ? object.getProperties() : null;
            bl2 = bl;
            if (!dynamicIslandWindowState.isTempHidden((Integer)object)) {
                bl2 = true;
            }
        }
        return bl2;
    }

    public final boolean hasTempShow() {
        boolean bl = this.getTempShow() != null;
        return bl;
    }

    public final boolean isDynamicIslandMiniWindowBlackList(String string) {
        o.g((Object)string, (String)"pkg");
        return this.getNotifySettingsManager().isDynamicIslandMiniWindowBlackList(string);
    }

    public final boolean isExpandedChanged() {
        return this.isExpandedChanged;
    }

    public final boolean isInLockMode(String string, int n) {
        o.g((Object)string, (String)"packageName");
        return this.appLockController.isInLockState(string, n);
    }

    public final boolean isIslandWindowAnimating(DynamicIslandContentView dynamicIslandContentView) {
        return this.getAnimationController().isWindowAnimating(dynamicIslandContentView);
    }

    public final boolean isTempHidden(DynamicIslandContentView object) {
        DynamicIslandWindowState dynamicIslandWindowState = this.dynamicIslandWindowState;
        object = object != null && (object = object.getCurrentIslandData()) != null ? object.getProperties() : null;
        return dynamicIslandWindowState.isTempHidden((Integer)object);
    }

    public final boolean isTinyScreen() {
        return this.dynamicIslandWindowState.isTinyScreen();
    }

    public final boolean islandAppAnimating(DynamicIslandContentView dynamicIslandContentView) {
        return this.getAnimationController().islandAppAnimating(dynamicIslandContentView);
    }

    public final boolean islandFreeformAnimating(DynamicIslandContentView dynamicIslandContentView) {
        return this.getAnimationController().islandFreeformAnimating(dynamicIslandContentView);
    }

    public final boolean lastHiddenListItemIsNull() {
        DynamicIslandContentView dynamicIslandContentView = (DynamicIslandContentView)((Object)u.W(this.hiddenList));
        boolean bl = dynamicIslandContentView != null ? dynamicIslandContentView.getState() instanceof DynamicIslandState.Empty : false;
        return bl;
    }

    public final boolean mediaIslandSupportMiniWindow(String string) {
        o.g((Object)string, (String)"pkg");
        return this.getNotifySettingsManager().mediaIslandSupportMiniWindow(string);
    }

    public final boolean needExtendLifetime(String string) {
        o.g((Object)string, (String)"key");
        return o.c((Object)this.needExtendLifetime.get(string), (Object)Boolean.TRUE);
    }

    @Override
    public void onAnimationCancel() {
        this.onDynamicIslandAnimationStateChanged(false);
    }

    @Override
    public void onAnimationFinished() {
        boolean bl = false;
        this.isAnimationRunning = false;
        Log.e((String)"DynamicIslandAnimDebug", (String)"onAnimationFinished");
        this.updateTouchRegion();
        this.updateWindowHeight();
        this.resetStateForExitApp();
        i1.u u2 = this._expandedState;
        if (this.expandedStateHandler.getCurrent() != null) {
            bl = true;
        }
        u2.setValue((Object)bl);
        this.onDynamicIslandAnimationStateChanged(this.isAnimationRunning);
    }

    @Override
    public void onAnimationStart(boolean bl, DynamicIslandContentView object) {
        int n;
        int n2;
        int n3;
        int n4;
        int n5;
        int n6;
        Object object2;
        int n7;
        Object var13_6;
        Region region;
        Region region2;
        Object object3;
        block22: {
            block24: {
                block25: {
                    block23: {
                        block21: {
                            o.g((Object)object, (String)"view");
                            if (!this.isAnimationRunning || bl) {
                                this.collapseAnimationRunning = bl;
                            }
                            this.isAnimationRunning = true;
                            this.onDynamicIslandAnimationStateChanged(true);
                            this.collapseAnimationRunning = bl;
                            this.updateWindowHeightAnimStart(bl, (DynamicIslandContentView)((Object)object));
                            this.updateTouchRegion();
                            object3 = new Region();
                            region2 = new Region();
                            region = new Region();
                            bl = CommonUtils.isFlipDevice();
                            var13_6 = null;
                            if (bl && CommonUtils.isTinyScreen((Context)this.ctx)) {
                                object = this.bigIslandStateHandler.getCurrentTempShow();
                                if (object != null && !(object.getState() instanceof DynamicIslandState.Deleted)) {
                                    int n8 = DynamicIslandBaseContentView.getCurrentBigIslandX$default(object, null, 1, null);
                                    int n9 = DynamicIslandBaseContentView.getCurrentBigIslandWidth$default(object, null, 1, null);
                                    int n10 = object.getIslandViewMarginTop();
                                    object3.set(n8, n10, n9 + n8, object.getIslandViewHeight() + n10);
                                }
                                this._islandRegion.setValue(object3);
                                this._bigIslandRegion.setValue((Object)region2);
                                this._expandedViewRegion.setValue((Object)region);
                                return;
                            }
                            object = this.bigIslandStateHandler.getCurrent();
                            n7 = 0;
                            if (object != null && !(object2 = this.dynamicIslandWindowState).isTempHidden((Integer)(object = (object = this.bigIslandStateHandler.getCurrent()) != null && (object = object.getCurrentIslandData()) != null ? object.getProperties() : null))) break block21;
                            object = object3;
                            if (this.bigIslandStateHandler.getCurrentTempShow() == null) break block22;
                            object = object3;
                            if (!CommonUtils.INSTANCE.getIS_TABLET()) break block22;
                        }
                        if (this.smallIslandStateHandler.getCurrent() == null || (object2 = this.dynamicIslandWindowState).isTempHidden((Integer)(object = (object = this.smallIslandStateHandler.getCurrent()) != null && (object = object.getCurrentIslandData()) != null ? object.getProperties() : null))) break block23;
                        if (CommonUtils.isLayoutRtl((Context)this.ctx)) {
                            object = this.smallIslandStateHandler.getCurrent();
                            n6 = object != null ? object.getSmallIslandViewWidth() : 0;
                            object = this.bigIslandStateHandler.getCurrent();
                            n5 = object != null ? object.getSpace() : 0;
                            n4 = this.getSmallXInRtl();
                            object = this.bigIslandStateHandler.getCurrent();
                            object = object != null ? Integer.valueOf(object.getIslandViewMarginTop()) : null;
                            o.d((Object)object);
                            n3 = (Integer)object;
                            object = this.bigIslandStateHandler.getCurrent();
                            object = object != null ? Integer.valueOf(DynamicIslandBaseContentView.getCurrentBigIslandWidth$default(object, null, 1, null)) : null;
                            o.d((Object)object);
                            n2 = (Integer)object;
                            object = this.bigIslandStateHandler.getCurrent();
                            object = object != null ? Integer.valueOf(object.getIslandViewMarginTop()) : null;
                            o.d((Object)object);
                            n = (Integer)object;
                            object = this.bigIslandStateHandler.getCurrent();
                            object = object != null ? Integer.valueOf(object.getIslandViewHeight()) : null;
                            o.d((Object)object);
                            object3.set(n4, n3, n5 + n4 + n6 + n2, n + (Integer)object);
                            object = object3;
                        } else {
                            object = this.bigIslandStateHandler.getCurrent();
                            object = object != null ? Integer.valueOf(DynamicIslandBaseContentView.getCurrentBigIslandX$default(object, null, 1, null)) : null;
                            o.d((Object)object);
                            n6 = (Integer)object;
                            object = this.bigIslandStateHandler.getCurrent();
                            object = object != null ? Integer.valueOf(object.getIslandViewMarginTop()) : null;
                            o.d((Object)object);
                            n3 = (Integer)object;
                            object = this.bigIslandStateHandler.getCurrent();
                            object = object != null ? Integer.valueOf(DynamicIslandBaseContentView.getCurrentBigIslandX$default(object, null, 1, null)) : null;
                            o.d((Object)object);
                            int n11 = (Integer)object;
                            object = this.bigIslandStateHandler.getCurrent();
                            object = object != null ? Integer.valueOf(DynamicIslandBaseContentView.getCurrentBigIslandWidth$default(object, null, 1, null)) : null;
                            o.d((Object)object);
                            n2 = (Integer)object;
                            object = this.bigIslandStateHandler.getCurrent();
                            object = object != null ? Integer.valueOf(object.getSpace()) : null;
                            o.d((Object)object);
                            n5 = (Integer)object;
                            object = this.smallIslandStateHandler.getCurrent();
                            object = object != null ? Integer.valueOf(object.getSmallIslandViewWidth()) : null;
                            o.d((Object)object);
                            n4 = (Integer)object;
                            object = this.bigIslandStateHandler.getCurrent();
                            object = object != null ? Integer.valueOf(object.getIslandViewMarginTop()) : null;
                            o.d((Object)object);
                            n = (Integer)object;
                            object = this.bigIslandStateHandler.getCurrent();
                            object = object != null ? Integer.valueOf(object.getIslandViewHeight()) : null;
                            o.d((Object)object);
                            object3.set(n6, n3, n11 + n2 + n5 + n4, n + (Integer)object);
                            object = object3;
                        }
                        break block22;
                    }
                    if (!CommonUtils.INSTANCE.getIS_TABLET()) break block24;
                    object2 = this.bigIslandStateHandler.getCurrent();
                    if (object2 == null) break block25;
                    object3 = this.dynamicIslandWindowState;
                    object = ((DynamicIslandBaseContentView)((Object)object2)).getCurrentIslandData();
                    object = object != null ? object.getProperties() : null;
                    object3 = object3.isTempHidden((Integer)object) ? new Region() : this.getBigIslandRegion((DynamicIslandContentView)((Object)object2));
                    object = object3;
                    if (object3 != null) break block22;
                }
                object = new Region();
                break block22;
            }
            if (this.bigIslandStateHandler.getCurrentTempShow() != null && !((object = (object = this.bigIslandStateHandler.getCurrentTempShow()) != null ? object.getState() : null) instanceof DynamicIslandState.Deleted)) {
                object = this.getBigIslandRegion(this.bigIslandStateHandler.getCurrentTempShow());
            } else {
                object2 = this.bigIslandStateHandler.getCurrent();
                object = object3;
                if (object2 != null && (object = this.getBigIslandRegion((DynamicIslandContentView)((Object)object2))) == null) {
                    object = object3;
                }
            }
        }
        object3 = object;
        if (this.bigIslandStateHandler.getCurrentTempShow() != null) {
            object3 = object;
            if (!CommonUtils.INSTANCE.getIS_TABLET()) {
                if (this.smallIslandStateHandler.getCurrent() != null && !(object2 = this.dynamicIslandWindowState).isTempHidden((Integer)(object3 = (object3 = this.smallIslandStateHandler.getCurrent()) != null && (object3 = object3.getCurrentIslandData()) != null ? object3.getProperties() : null))) {
                    if (CommonUtils.isLayoutRtl((Context)this.ctx)) {
                        object3 = this.smallIslandStateHandler.getCurrent();
                        n6 = object3 != null ? object3.getSmallIslandViewWidth() : 0;
                        object3 = this.showOnceIslandHandler.getCurrent();
                        n5 = n7;
                        if (object3 != null) {
                            n5 = object3.getSpace();
                        }
                        n4 = this.getSmallXInRtl();
                        object3 = this.showOnceIslandHandler.getCurrent();
                        object3 = object3 != null ? Integer.valueOf(object3.getIslandViewMarginTop()) : null;
                        o.d((Object)object3);
                        n2 = object3.intValue();
                        object3 = this.showOnceIslandHandler.getCurrent();
                        object3 = object3 != null ? Integer.valueOf(DynamicIslandBaseContentView.getCurrentBigIslandWidth$default((DynamicIslandBaseContentView)((Object)object3), null, 1, null)) : null;
                        o.d((Object)object3);
                        n7 = object3.intValue();
                        object3 = this.showOnceIslandHandler.getCurrent();
                        object3 = object3 != null ? Integer.valueOf(object3.getIslandViewMarginTop()) : null;
                        o.d((Object)object3);
                        n = object3.intValue();
                        object3 = this.showOnceIslandHandler.getCurrent();
                        object3 = object3 != null ? Integer.valueOf(object3.getIslandViewHeight()) : null;
                        o.d((Object)object3);
                        object.set(n4, n2, n5 + n4 + n6 + n7, n + object3.intValue());
                        object3 = object;
                    } else {
                        object3 = this.showOnceIslandHandler.getCurrent();
                        object3 = object3 != null ? Integer.valueOf(DynamicIslandBaseContentView.getCurrentBigIslandX$default((DynamicIslandBaseContentView)((Object)object3), null, 1, null)) : null;
                        o.d((Object)object3);
                        n5 = object3.intValue();
                        object3 = this.showOnceIslandHandler.getCurrent();
                        object3 = object3 != null ? Integer.valueOf(object3.getIslandViewMarginTop()) : null;
                        o.d((Object)object3);
                        n4 = object3.intValue();
                        object3 = this.showOnceIslandHandler.getCurrent();
                        object3 = object3 != null ? Integer.valueOf(DynamicIslandBaseContentView.getCurrentBigIslandX$default((DynamicIslandBaseContentView)((Object)object3), null, 1, null)) : null;
                        o.d((Object)object3);
                        n = object3.intValue();
                        object3 = this.showOnceIslandHandler.getCurrent();
                        object3 = object3 != null ? Integer.valueOf(DynamicIslandBaseContentView.getCurrentBigIslandWidth$default((DynamicIslandBaseContentView)((Object)object3), null, 1, null)) : null;
                        o.d((Object)object3);
                        n2 = object3.intValue();
                        object3 = this.showOnceIslandHandler.getCurrent();
                        object3 = object3 != null ? Integer.valueOf(object3.getSpace()) : null;
                        o.d((Object)object3);
                        n3 = object3.intValue();
                        object3 = this.smallIslandStateHandler.getCurrent();
                        object3 = object3 != null ? Integer.valueOf(object3.getSmallIslandViewWidth()) : null;
                        o.d((Object)object3);
                        n6 = object3.intValue();
                        object3 = this.showOnceIslandHandler.getCurrent();
                        object3 = object3 != null ? Integer.valueOf(object3.getIslandViewMarginTop()) : null;
                        o.d((Object)object3);
                        n7 = object3.intValue();
                        object3 = this.showOnceIslandHandler.getCurrent();
                        object3 = object3 != null ? Integer.valueOf(object3.getIslandViewHeight()) : null;
                        o.d((Object)object3);
                        object.set(n5, n4, n + n2 + n3 + n6, n7 + object3.intValue());
                        object3 = object;
                    }
                } else {
                    object3 = object;
                    if (this.bigIslandStateHandler.getCurrentTempShow() != null) {
                        object3 = this.bigIslandStateHandler.getCurrentTempShow();
                        object2 = object3 != null ? object3.getState() : null;
                        object3 = object;
                        if (!(object2 instanceof DynamicIslandState.Deleted)) {
                            object3 = this.getBigIslandRegion(this.bigIslandStateHandler.getCurrentTempShow());
                        }
                    }
                }
            }
        }
        if (this.expandedStateHandler.getCurrent() != null) {
            object = this.expandedStateHandler.getCurrent();
            object = object != null ? Integer.valueOf(object.getExpandedViewMarginHorizontal()) : null;
            o.d((Object)object);
            n7 = (Integer)object;
            object = this.expandedStateHandler.getCurrent();
            object = object != null ? Integer.valueOf(object.getExpandedViewY()) : null;
            o.d((Object)object);
            n6 = (Integer)object;
            object = this.expandedStateHandler.getCurrent();
            object = object != null ? Integer.valueOf(object.getExpandedViewMarginHorizontal()) : null;
            o.d((Object)object);
            n = (Integer)object;
            object = this.expandedStateHandler.getCurrent();
            object = object != null ? Integer.valueOf(object.getExpandedViewWidth()) : null;
            o.d((Object)object);
            n2 = (Integer)object;
            object = this.expandedStateHandler.getCurrent();
            object = object != null ? Integer.valueOf(object.getExpandedViewY()) : null;
            o.d((Object)object);
            n5 = (Integer)object;
            object2 = this.expandedStateHandler.getCurrent();
            object = var13_6;
            if (object2 != null) {
                object = ((DynamicIslandBaseContentView)((Object)object2)).getExpandedViewHeight();
            }
            o.d((Object)object);
            region.set(n7, n6, n + n2, n5 + (Integer)object);
        }
        this._islandRegion.setValue(object3);
        this._bigIslandRegion.setValue((Object)region2);
        this._expandedViewRegion.setValue((Object)region);
        this.setShadow();
        object = this.windowView;
        ((DynamicIslandWindowView)((Object)object)).updateDarkLightMode(((DynamicIslandWindowView)((Object)object)).isLight());
    }

    public final void onBigIslandTickerDataChanged() {
        Object object = this.bigIslandStateHandler.getCurrent();
        object = object != null && (object = object.getCurrentIslandData()) != null ? object.getTickerData() : null;
        boolean bl = object != null;
        boolean bl2 = this.lastHasTickerData;
        object = new StringBuilder();
        ((StringBuilder)object).append("onBigIslandTickerDataChanged lastHasTickerData:");
        ((StringBuilder)object).append(bl2);
        ((StringBuilder)object).append(" ,hasTickerData:");
        ((StringBuilder)object).append(bl);
        Log.d((String)"DynamicIslandEventDebug", (String)((StringBuilder)object).toString());
        if (this.lastHasTickerData == bl) {
            return;
        }
        this.lastHasTickerData = bl;
        Bundle bundle = new Bundle();
        bundle.putString("action_key", "action_big_island_ticker_data_changed");
        bundle.putBoolean("extra_has_big_island_ticker_data", bl);
        object = this.dynamicIslandViewChangedListener;
        if (object != null) {
            object.onIslandViewChanged(bundle);
        }
    }

    public final void onDynamicPluginCallback(String string, Bundle bundle) {
        o.g((Object)string, (String)"action");
        DynamicIslandContent.DynamicIslandViewChangedListener dynamicIslandViewChangedListener = this.dynamicIslandViewChangedListener;
        if (dynamicIslandViewChangedListener != null) {
            dynamicIslandViewChangedListener.onDynamicPluginCallback(string, bundle);
        }
    }

    public final void onHeightChangedFirst() {
        this._state.setValue((Object)DynamicIslandUtils.INSTANCE.getScreenHeightOld(this.ctx));
    }

    public final void onKeyguardShowing(boolean bl) {
        this.keyguardShowing = bl;
    }

    public final void onNormalIslandViewCallback(DynamicIslandContentFakeView dynamicIslandContentFakeView, Bundle bundle) {
        DynamicIslandContent.DynamicIslandViewChangedListener dynamicIslandViewChangedListener = this.dynamicIslandViewChangedListener;
        if (dynamicIslandViewChangedListener != null) {
            dynamicIslandViewChangedListener.onNormalIslandViewCallback((View)dynamicIslandContentFakeView, bundle);
        }
    }

    @Override
    public void onShowOnceStateChange() {
        this.dynamicIslandWindowState.updateShowOnceIslandState(this.showOnceIslandHandler.getCurrent());
    }

    /*
     * Enabled aggressive block sorting
     */
    @Override
    public void onStateChange(String string, DynamicIslandContentView dynamicIslandContentView) {
        o.g((Object)string, (String)"type");
        o.g((Object)((Object)dynamicIslandContentView), (String)"view");
        int n = -1;
        switch (string.hashCode()) {
            case 1597750163: {
                if (!string.equals("hidden_to_sub_app")) break;
                n = 1;
                break;
            }
            case 1344768073: {
                if (!string.equals("hidden_to_mini_window")) break;
                n = 1;
                break;
            }
            case 1184965706: {
                if (!string.equals("hidden_to_sub_mini_window")) break;
                n = 1;
                break;
            }
            case 1040440439: {
                if (!string.equals("temp_hidden_to_show")) break;
                n = 2;
                break;
            }
            case 847876465: {
                if (!string.equals("hidden_to_big")) break;
                n = 2;
                break;
            }
            case 847875730: {
                if (!string.equals("hidden_to_app")) break;
                n = 1;
                break;
            }
            case 836144822: {
                if (!string.equals("small_to_hidden")) break;
                n = 1;
                break;
            }
            case 456153936: {
                if (!string.equals("app_to_hidden")) break;
                n = 1;
                break;
            }
            case 16293191: {
                if (!string.equals("mini_window_to_hidden")) return;
                n = 1;
                break;
            }
            case -503419768: {
                if (!string.equals("sub_mini_window_to_hidden")) break;
                n = 1;
                break;
            }
            case -821344717: {
                if (!string.equals("show_to_temp_hidden")) break;
                n = 1;
                break;
            }
            case -1110560792: {
                if (!string.equals("expanded_to_hidden")) break;
                n = 1;
                break;
            }
            case -1218686664: {
                if (!string.equals("hidden_to_small")) break;
                n = 2;
                break;
            }
            case -1502217327: {
                if (!string.equals("sub_app_to_hidden")) break;
                n = 1;
                break;
            }
            case -1748135057: {
                if (!string.equals("big_to_hidden")) break;
                n = 1;
                break;
            }
            case -1868319000: {
                if (!string.equals("hidden_to_expanded")) break;
                n = 2;
                break;
            }
        }
        switch (n) {
            default: {
                return;
            }
            case 1: {
                dynamicIslandContentView.hideIslandLayout();
                return;
            }
            case 2: 
        }
        dynamicIslandContentView.showIslandLayout();
    }

    public final void onWindowAnimExtendLifetimeEnd(Bundle bundle) {
        if (bundle != null) {
            StatusBarNotification statusBarNotification = (StatusBarNotification)bundle.getParcelable("miui.sbn", StatusBarNotification.class);
            HashMap<String, Boolean> hashMap = this.needExtendLifetime;
            StringBuilder stringBuilder = null;
            String string = statusBarNotification != null ? statusBarNotification.getKey() : null;
            if ((Boolean)hashMap.get(string) != null) {
                hashMap = this.needExtendLifetime;
                string = statusBarNotification != null ? statusBarNotification.getKey() : null;
                E.d(hashMap).remove(string);
                string = stringBuilder;
                if (statusBarNotification != null) {
                    string = statusBarNotification.getKey();
                }
                stringBuilder = new StringBuilder();
                stringBuilder.append("onWindowAnimExtendLifetimeEnd ");
                stringBuilder.append(string);
                Log.e((String)"DynamicIslandAnimDebug", (String)stringBuilder.toString());
                string = this.dynamicIslandViewChangedListener;
                if (string != null) {
                    string.onDynamicPluginCallback("onDynamicPluginCallback_onWindowAnimEnd", bundle);
                }
            }
        }
    }

    public final void onWindowAnimExtendLifetimeStart(Bundle bundle) {
        if (bundle != null) {
            Object object = (StatusBarNotification)bundle.getParcelable("miui.sbn", StatusBarNotification.class);
            if (object != null && (object = object.getKey()) != null) {
                o.d((Object)object);
                this.needExtendLifetime.put((String)object, Boolean.TRUE);
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("onWindowAnimExtendLifetimeStart ");
                stringBuilder.append((String)object);
                Log.e((String)"DynamicIslandAnimDebug", (String)stringBuilder.toString());
            }
            bundle.putBoolean("extra_has_force_end_life_extend", true);
            object = this.dynamicIslandViewChangedListener;
            if (object != null) {
                object.onDynamicPluginCallback("onDynamicPluginCallback_onWindowAnimStart", bundle);
            }
        }
    }

    public final void openApp(Bundle bundle) {
        DynamicIslandContent.DynamicIslandViewChangedListener dynamicIslandViewChangedListener = this.dynamicIslandViewChangedListener;
        if (dynamicIslandViewChangedListener != null) {
            dynamicIslandViewChangedListener.onDynamicPluginCallback("onDynamicPluginCallback_openApp", bundle);
        }
    }

    public final void openFreeForm(Bundle bundle) {
        DynamicIslandContent.DynamicIslandViewChangedListener dynamicIslandViewChangedListener = this.dynamicIslandViewChangedListener;
        if (dynamicIslandViewChangedListener != null) {
            dynamicIslandViewChangedListener.onDynamicPluginCallback("onDynamicPluginCallback_openFreeform", bundle);
        }
    }

    public final void positionChanged(Bundle bundle) {
        DynamicIslandContent.DynamicIslandViewChangedListener dynamicIslandViewChangedListener = this.dynamicIslandViewChangedListener;
        if (dynamicIslandViewChangedListener != null) {
            dynamicIslandViewChangedListener.onDynamicPluginCallback("onDynamicPluginCallback_positionChanged", bundle);
        }
    }

    public final void removeExtendLifetime(String string) {
        o.g((Object)string, (String)"key");
        this.needExtendLifetime.remove(string);
    }

    public final void reparentFreeformFakeView(DynamicIslandContentView dynamicIslandBaseContentView) {
        DynamicIslandContentFakeView dynamicIslandContentFakeView;
        if (dynamicIslandBaseContentView != null && (dynamicIslandContentFakeView = dynamicIslandBaseContentView.getFakeView()) != null) {
            Object object = dynamicIslandBaseContentView.getParent();
            Object object2 = null;
            object = object != null ? object.getParent() : null;
            object = object instanceof ViewGroup ? (ViewGroup)object : null;
            if (o.c((Object)dynamicIslandContentFakeView.getParent(), (Object)object)) {
                dynamicIslandBaseContentView = dynamicIslandBaseContentView.getFakeView();
                object = dynamicIslandContentFakeView.getParent();
                object2 = new StringBuilder();
                object2.append("reparentFreeformFakeView: fakeView ");
                object2.append((Object)dynamicIslandBaseContentView);
                object2.append(", parent: ");
                object2.append(object);
                object2.append(", return");
                Log.e((String)"DynamicIslandAnimDebug", (String)object2.toString());
                return;
            }
            dynamicIslandContentFakeView = dynamicIslandBaseContentView.getFakeView();
            Object object3 = dynamicIslandBaseContentView.getFakeView();
            if (object3 != null) {
                object2 = object3.getParent();
            }
            object3 = new StringBuilder();
            ((StringBuilder)object3).append("reparentFreeformFakeView: fakeView ");
            ((StringBuilder)object3).append((Object)dynamicIslandContentFakeView);
            ((StringBuilder)object3).append(", parent: ");
            ((StringBuilder)object3).append(object2);
            Log.e((String)"DynamicIslandAnimDebug", (String)((StringBuilder)object3).toString());
            object2 = dynamicIslandBaseContentView.getFakeView();
            if (object2 != null && (object2 = object2.getParent()) != null) {
                o.d((Object)object2);
                ((ViewGroup)object2).removeView((View)dynamicIslandBaseContentView.getFakeView());
            }
            object2 = new FrameLayout.LayoutParams(-1, -1);
            if (object != null) {
                object.addView((View)dynamicIslandBaseContentView.getFakeView(), (ViewGroup.LayoutParams)object2);
            }
        }
    }

    public final void reparentOpenAppFakeView(DynamicIslandContentFakeView dynamicIslandContentFakeView, Bundle bundle) {
        ViewParent viewParent = dynamicIslandContentFakeView != null ? dynamicIslandContentFakeView.getParent() : null;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("reparentOpenAppFakeView: fakeView ");
        stringBuilder.append((Object)dynamicIslandContentFakeView);
        stringBuilder.append(", parent: ");
        stringBuilder.append(viewParent);
        Log.e((String)"DynamicIslandAnimDebug", (String)stringBuilder.toString());
        if (dynamicIslandContentFakeView != null && (viewParent = dynamicIslandContentFakeView.getParent()) != null) {
            ((ViewGroup)viewParent).removeView((View)dynamicIslandContentFakeView);
        }
        this.updateOpenAppFakeViewCallback(dynamicIslandContentFakeView, bundle);
    }

    public final void resetContainerAlpha(DynamicIslandContentView dynamicIslandContentView) {
        this.getAnimationController().resetContainerAlpha(dynamicIslandContentView);
    }

    public final void resetFakeViewAnimState(DynamicIslandContentView dynamicIslandContentView, boolean bl) {
        this.getAnimationController().resetFakeViewAnimState(dynamicIslandContentView, bl);
    }

    public final void resetPress(boolean bl, boolean bl2, boolean bl3) {
        if (this.hasResetPress) {
            return;
        }
        this.hasResetPress = true;
        if (bl) {
            this.getAnimationController().resetPress(this.bigIslandStateHandler.getCurrent());
        } else if (bl2) {
            this.getAnimationController().resetPress(this.smallIslandStateHandler.getCurrent());
        } else if (bl3) {
            this.getAnimationController().resetPress(this.expandedStateHandler.getCurrent());
        }
    }

    public final void resetSwipe(float f2, float f3) {
        this.getSwipeEventCoordinator().resetSwipe(f2, f3, this.hiddenList);
    }

    public final void setDynamicIslandViewChangedListener(DynamicIslandContent.DynamicIslandViewChangedListener dynamicIslandViewChangedListener) {
        this.dynamicIslandViewChangedListener = dynamicIslandViewChangedListener;
    }

    public final void setEnterMiniWindow(boolean bl) {
        this.enterMiniWindow = bl;
    }

    public final void setExpandedChanged(boolean bl) {
        this.isExpandedChanged = bl;
    }

    public final void setHandlingEvent(DynamicIslandEvent dynamicIslandEvent) {
        this.handlingEvent = dynamicIslandEvent;
    }

    public final void setHasAppExpandedState(boolean bl) {
        this.hasAppExpandedState = bl;
    }

    public final void setHorizontalSwipeDispatched(boolean bl) {
        this.horizontalSwipeDispatched = bl;
    }

    public final void setKeyguardShowing(boolean bl) {
        this.keyguardShowing = bl;
    }

    public final void setLastFullScreenActivityPkg(String string) {
        o.g((Object)string, (String)"<set-?>");
        this.lastFullScreenActivityPkg = string;
    }

    public final void setPkgSupportFreeform(HashMap<String, Boolean> hashMap) {
        o.g(hashMap, (String)"<set-?>");
        this.pkgSupportFreeform = hashMap;
    }

    public final void setSwiping(boolean bl) {
        this.swiping = bl;
    }

    public final void setUserExpanded(boolean bl) {
        this._userExpanded = bl;
        DynamicIslandWindowView dynamicIslandWindowView = this.windowView;
        dynamicIslandWindowView.updateHeadsUpZone(dynamicIslandWindowView.getHeadsUpHeight());
    }

    public final void setVerticalSwipeDispatched(boolean bl) {
        this.verticalSwipeDispatched = bl;
    }

    public final void setWindowAnimRunning(boolean bl) {
        this.windowAnimRunning = bl;
    }

    public final void smallToBig(Bundle bundle) {
        DynamicIslandContent.DynamicIslandViewChangedListener dynamicIslandViewChangedListener = this.dynamicIslandViewChangedListener;
        if (dynamicIslandViewChangedListener != null) {
            dynamicIslandViewChangedListener.onDynamicPluginCallback("onDynamicPluginCallback_smallToBig", bundle);
        }
    }

    public final void smallToExpanded(Bundle bundle) {
        DynamicIslandContent.DynamicIslandViewChangedListener dynamicIslandViewChangedListener = this.dynamicIslandViewChangedListener;
        if (dynamicIslandViewChangedListener != null) {
            dynamicIslandViewChangedListener.onDynamicPluginCallback("onDynamicPluginCallback_smallToExpanded", bundle);
        }
    }

    public final void startDropDownExpandedIsland(Bundle bundle) {
        o.g((Object)bundle, (String)"bundle");
        bundle.putString("plugin_callback_type", "pull_down_type_start");
        DynamicIslandContent.DynamicIslandViewChangedListener dynamicIslandViewChangedListener = this.dynamicIslandViewChangedListener;
        if (dynamicIslandViewChangedListener != null) {
            dynamicIslandViewChangedListener.onDynamicPluginCallback("onDynamicPluginCallback_dropDownExpandedIsland", bundle);
        }
    }

    public final void stopSwipe() {
        this.swiping = false;
        this.horizontalSwipeDispatched = false;
        this.verticalSwipeDispatched = false;
    }

    public final void updateAppExpandedStateWhenAnimStart(DynamicIslandContentView dynamicIslandContentView) {
        this.getAnimationController().updateAppExpandedStateWhenAnimStart(dynamicIslandContentView);
    }

    public final void updateBigIslandWidth(int n) {
        if (this.lastBigIslandWidth == n) {
            return;
        }
        this.lastBigIslandWidth = n;
        Bundle bundle = new Bundle();
        bundle.putString("action_key", "action_big_island_width_changed");
        bundle.putInt("extra_big_island_width", n);
        DynamicIslandContent.DynamicIslandViewChangedListener dynamicIslandViewChangedListener = this.dynamicIslandViewChangedListener;
        if (dynamicIslandViewChangedListener != null) {
            dynamicIslandViewChangedListener.onIslandViewChanged(bundle);
        }
    }

    public final void updateDropDownExpandedIsland(Bundle bundle) {
        o.g((Object)bundle, (String)"bundle");
        bundle.putString("plugin_callback_type", "pull_down_type_update");
        DynamicIslandContent.DynamicIslandViewChangedListener dynamicIslandViewChangedListener = this.dynamicIslandViewChangedListener;
        if (dynamicIslandViewChangedListener != null) {
            dynamicIslandViewChangedListener.onDynamicPluginCallback("onDynamicPluginCallback_dropDownExpandedIsland", bundle);
        }
    }

    public final void updateFreeformFakeView(DynamicIslandContentFakeView dynamicIslandContentFakeView, DynamicIslandContentView dynamicIslandContentView, Bundle bundle) {
        this.reparentFreeformFakeView(dynamicIslandContentView);
        DynamicIslandContent.DynamicIslandViewChangedListener dynamicIslandViewChangedListener = this.dynamicIslandViewChangedListener;
        if (dynamicIslandViewChangedListener != null) {
            FrameLayout frameLayout = null;
            dynamicIslandContentView = dynamicIslandContentFakeView != null ? dynamicIslandContentFakeView.getFakeBigIsland() : null;
            FrameLayout frameLayout2 = dynamicIslandContentFakeView != null ? dynamicIslandContentFakeView.getFakeSmallIsland() : null;
            if (dynamicIslandContentFakeView != null) {
                frameLayout = dynamicIslandContentFakeView.getFakeExpandedView();
            }
            dynamicIslandViewChangedListener.onFreeformFakeViewCallback((View)dynamicIslandContentFakeView, null, (View)dynamicIslandContentView, (View)frameLayout2, (View)frameLayout, bundle);
        }
    }

    public final void updateHeadsUpZone(i i2) {
        o.g((Object)i2, (String)"zone");
        this._headsUpZone.setValue((Object)i2);
    }

    public final void updateIslandWindowAnimRunning(boolean bl, DynamicIslandContentView dynamicIslandContentView, boolean bl2) {
        this.getAnimationController().updateIslandWindowAnimRunning(bl, dynamicIslandContentView, bl2);
    }

    public final void updateMiniBar(DynamicIslandContentView dynamicIslandContentView) {
        this.getAnimationController().updateExpandedViewMiniBar(dynamicIslandContentView);
    }

    public final void updateOpenAppFakeViewCallback(DynamicIslandContentFakeView dynamicIslandContentFakeView, Bundle bundle) {
        DynamicIslandContent.DynamicIslandViewChangedListener dynamicIslandViewChangedListener = this.dynamicIslandViewChangedListener;
        if (dynamicIslandViewChangedListener != null) {
            FrameLayout frameLayout = dynamicIslandContentFakeView != null ? dynamicIslandContentFakeView.getFakeContainer() : null;
            dynamicIslandViewChangedListener.onNormalFakeViewCallback((View)dynamicIslandContentFakeView, (View)frameLayout, bundle);
        }
    }

    public final void updatePkgSupportFreeform(String object, Context object2) {
        o.g((Object)object, (String)"pkg");
        o.g((Object)object2, (String)"context");
        boolean bl = DynamicIslandUtils.INSTANCE.packageSupportFreeform((Context)object2, (String)object);
        object2 = new StringBuilder();
        ((StringBuilder)object2).append("updatePkgSupportFreeform : ");
        ((StringBuilder)object2).append((String)object);
        ((StringBuilder)object2).append(", ");
        ((StringBuilder)object2).append(bl);
        Log.e((String)TAG, (String)((StringBuilder)object2).toString());
        object2 = this.pkgSupportFreeform;
        if (object2 != null) {
            object = ((HashMap)object2).put(object, bl);
        }
    }

    public final void updateStatusBarVisible(boolean bl) {
        this._stateBarVisible.setValue((Object)bl);
    }

    public final void updateTouchRegion() {
        Object object;
        Object object2 = this.windowView.getWindowViewController().getWindowState();
        boolean bl = (Boolean)((DynamicIslandWindowState)object2).getNotificationAppearance().getValue();
        boolean bl2 = ((Boolean)((DynamicIslandWindowState)object2).getStatusBarDisappearance().getValue()).booleanValue() || !((Boolean)((DynamicIslandWindowState)object2).getShowNotificationIcons().getValue()).booleanValue() || ((Boolean)((DynamicIslandWindowState)object2).getBouncerShowing().getValue()).booleanValue();
        boolean bl3 = (Boolean)((DynamicIslandWindowState)object2).getControlCenterExpanded().getValue();
        boolean bl4 = (Boolean)((DynamicIslandWindowState)object2).getScreenPinning().getValue();
        boolean bl5 = (Boolean)((DynamicIslandWindowState)object2).isSuperSaveMode().getValue();
        Region region = this.getExpandedIslandRegion();
        Region region2 = this.getSmallBigIslandRegion();
        object2 = object = this.mergeTouchRegions(region, region2);
        if (bl) {
            object2 = object;
            if (!bl3) {
                object2 = object = NON_INTERACTIVE_REGION;
                if (this.expandedStateHandler.getCurrent() != null) {
                    Object object3 = this.expandedStateHandler.getCurrent();
                    object2 = object;
                    if (object3 != null) {
                        object3 = ((DynamicIslandBaseContentView)((Object)object3)).getState();
                        object2 = object;
                        if (object3 != null) {
                            object2 = object;
                            if (((State)object3).getTempShow()) {
                                object2 = object;
                                if (!CommonUtils.INSTANCE.getIS_TABLET()) {
                                    object2 = region;
                                }
                            }
                        }
                    }
                }
            }
        }
        object = object2;
        if (bl2) {
            object = object2;
            if (!bl4) {
                object = object2;
                if (!bl5) {
                    object = this.expandedStateHandler.getCurrent() != null ? region : NON_INTERACTIVE_REGION;
                }
            }
        }
        if (this.windowView.hasNoActiveDynamicIsland()) {
            object = NON_INTERACTIVE_REGION;
        }
        object2 = object;
        if (object.isEmpty()) {
            object2 = object;
            if (this.hasTempShow()) {
                object2 = region2;
            }
        }
        if (this.regionChanged((Region)(object2 = this.getFakeExpandedTrackingRegion((Region)object2)))) {
            object = new StringBuilder();
            ((StringBuilder)object).append("touchRegion updated to: ");
            ((StringBuilder)object).append(object2);
            ((StringBuilder)object).append("; smallBig:");
            ((StringBuilder)object).append(region2);
            ((StringBuilder)object).append(", expanded: ");
            ((StringBuilder)object).append(region);
            Log.d((String)"DynamicIslandTouchDebug", (String)((StringBuilder)object).toString());
            this._touchRegion.setValue(object2);
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final void updateView(DynamicIslandContentView dynamicIslandContentView) {
        Object object;
        Object var3_4;
        Object object2;
        block6: {
            Throwable throwable2;
            block7: {
                o.g((Object)((Object)dynamicIslandContentView), (String)"view");
                if (!DynamicIslandAnimUtils.INSTANCE.supportShowElementAnim()) {
                    return;
                }
                object2 = this.dynamicIslandViewChangedListener;
                if (object2 != null) {
                    object2.onUpdateAnimView((View)dynamicIslandContentView.getBigIslandView(), (View)dynamicIslandContentView.getSmallIslandView(), (View)dynamicIslandContentView.getExpandedView());
                }
                var3_4 = null;
                try {
                    object = this.dynamicIslandViewChangedListener;
                    if (object != null) {
                        object2 = dynamicIslandContentView.getCurrentIslandData();
                        object2 = object2 != null ? object2.getExtras() : null;
                    }
                    break block6;
                }
                catch (Throwable throwable2) {
                    break block7;
                }
                object.onNormalIslandViewCallback((View)dynamicIslandContentView, (Bundle)object2);
                break block6;
            }
            object = new StringBuilder();
            ((StringBuilder)object).append("onNormalIslandViewCallback: ");
            ((StringBuilder)object).append(throwable2);
            Log.e((String)"DynamicIslandAnimDebug", (String)((StringBuilder)object).toString());
        }
        object2 = dynamicIslandContentView.getFakeView();
        object = dynamicIslandContentView.getCurrentIslandData();
        dynamicIslandContentView = var3_4;
        if (object != null) {
            dynamicIslandContentView = object.getExtras();
        }
        this.reparentOpenAppFakeView((DynamicIslandContentFakeView)((Object)object2), (Bundle)dynamicIslandContentView);
    }

    public final void updateWindowHeightForFreeform(int n) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("freeform bottom: ");
        stringBuilder.append(n);
        Log.d((String)"DynamicIslandEventDebug", (String)stringBuilder.toString());
        this.freeformBottom = n;
        this._state.setValue((Object)n);
    }

    public final void updateWindowHeightInAnimState(boolean bl, boolean bl2) {
        this.windowAnimRunning = bl;
        if (bl && !DynamicIslandAnimUtils.INSTANCE.supportFreeformNotHigh()) {
            this._state.setValue((Object)DynamicIslandUtils.INSTANCE.getScreenHeightOld(this.ctx));
        } else {
            this.updateWindowHeight();
        }
    }
}
