/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
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
 *  U0.a
 *  U0.o
 *  U0.p
 *  android.annotation.SuppressLint
 *  android.app.PendingIntent
 *  android.content.Context
 *  android.content.res.Configuration
 *  android.content.res.MiuiConfiguration
 *  android.content.res.Resources
 *  android.graphics.Canvas
 *  android.graphics.Rect
 *  android.graphics.Region
 *  android.os.Bundle
 *  android.os.Parcelable
 *  android.service.notification.StatusBarNotification
 *  android.text.TextUtils
 *  android.util.AttributeSet
 *  android.util.Log
 *  android.view.LayoutInflater
 *  android.view.MotionEvent
 *  android.view.View
 *  android.view.View$MeasureSpec
 *  android.view.ViewGroup
 *  android.view.ViewGroup$LayoutParams
 *  android.view.ViewTreeObserver
 *  android.view.ViewTreeObserver$OnGlobalLayoutListener
 *  android.view.WindowInsets
 *  android.widget.FrameLayout
 *  androidx.annotation.CallSuper
 *  androidx.lifecycle.Lifecycle$State
 *  androidx.lifecycle.LifecycleOwner
 *  androidx.lifecycle.LifecycleOwnerKt
 *  androidx.lifecycle.LifecycleRegistry
 *  com.android.systemui.plugins.miui.dynamicisland.DynamicIslandContent$DynamicIslandViewChangedListener
 *  com.android.systemui.plugins.miui.dynamicisland.DynamicIslandData
 *  com.android.systemui.settings.UserTracker$Callback
 *  e1.g
 *  e1.o
 *  f1.E
 *  f1.f
 *  i1.A
 *  i1.I
 *  i1.f
 *  i1.g
 *  i1.h
 *  i1.t
 *  i1.y
 *  j1.k
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.E
 *  kotlin.jvm.internal.o
 *  miui.systemui.notification.ActivityManagerWrapper
 *  miui.systemui.util.CommonUtils
 *  miui.systemui.util.FlipUtils
 *  miui.systemui.util.FoldUtils
 *  miui.systemui.util.MiBlurCompat
 *  miui.systemui.util.ReflectBuilderUtil
 *  o1.a
 *  o1.a$a
 *  o1.c
 */
package miui.systemui.dynamicisland.window;

import G0.e;
import G0.i;
import G0.s;
import H0.u;
import K0.d;
import M0.b;
import android.annotation.SuppressLint;
import android.app.PendingIntent;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.MiuiConfiguration;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.Region;
import android.os.Bundle;
import android.os.Parcelable;
import android.service.notification.StatusBarNotification;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.WindowInsets;
import android.widget.FrameLayout;
import androidx.annotation.CallSuper;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.LifecycleRegistry;
import com.android.systemui.plugins.miui.dynamicisland.DynamicIslandContent;
import com.android.systemui.plugins.miui.dynamicisland.DynamicIslandData;
import com.android.systemui.settings.UserTracker;
import f1.f;
import i1.A;
import i1.I;
import i1.g;
import i1.h;
import i1.t;
import i1.y;
import j1.k;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.E;
import miui.systemui.dynamicisland.DynamicIslandAnimUtils;
import miui.systemui.dynamicisland.DynamicIslandBackgroundView;
import miui.systemui.dynamicisland.DynamicIslandScenarioUtils;
import miui.systemui.dynamicisland.DynamicIslandUtils;
import miui.systemui.dynamicisland.R;
import miui.systemui.dynamicisland.anim.DynamicIslandAnimationDelegate;
import miui.systemui.dynamicisland.dagger.DynamicIslandViewComponent;
import miui.systemui.dynamicisland.data.repository.DynamicIslandSizeRepository;
import miui.systemui.dynamicisland.event.DynamicIslandEvent;
import miui.systemui.dynamicisland.event.DynamicIslandEventCoordinator;
import miui.systemui.dynamicisland.event.DynamicIslandState;
import miui.systemui.dynamicisland.event.State;
import miui.systemui.dynamicisland.event.WindowAnimState;
import miui.systemui.dynamicisland.event.handler.AppStateHandler;
import miui.systemui.dynamicisland.event.handler.BigIslandStateHandler;
import miui.systemui.dynamicisland.event.handler.ExpandedStateHandler;
import miui.systemui.dynamicisland.event.handler.MiniWindowStateHandler;
import miui.systemui.dynamicisland.event.handler.SmallIslandStateHandler;
import miui.systemui.dynamicisland.event.handler.StateHandler;
import miui.systemui.dynamicisland.model.IslandTemplate;
import miui.systemui.dynamicisland.touch.TouchEvent;
import miui.systemui.dynamicisland.view.DynamicIslandExpandedView;
import miui.systemui.dynamicisland.window.DynamicIslandWindowState;
import miui.systemui.dynamicisland.window.DynamicIslandWindowView;
import miui.systemui.dynamicisland.window.DynamicIslandWindowViewController;
import miui.systemui.dynamicisland.window.content.DynamicIslandBaseContentView;
import miui.systemui.dynamicisland.window.content.DynamicIslandBaseContentViewController;
import miui.systemui.dynamicisland.window.content.DynamicIslandContentFakeView;
import miui.systemui.dynamicisland.window.content.DynamicIslandContentView;
import miui.systemui.dynamicisland.window.content.DynamicIslandContentViewExtKt;
import miui.systemui.dynamicisland.window.content.ui.viewbinder.DynamicIslandBaseContentViewBinder;
import miui.systemui.dynamicisland.window.l;
import miui.systemui.dynamicisland.window.m;
import miui.systemui.dynamicisland.window.n;
import miui.systemui.dynamicisland.window.o;
import miui.systemui.dynamicisland.window.p;
import miui.systemui.notification.ActivityManagerWrapper;
import miui.systemui.util.CommonUtils;
import miui.systemui.util.FlipUtils;
import miui.systemui.util.FoldUtils;
import miui.systemui.util.MiBlurCompat;
import miui.systemui.util.ReflectBuilderUtil;
import o1.a;
import o1.c;

public final class DynamicIslandWindowView
extends FrameLayout
implements LifecycleOwner,
UserTracker.Callback {
    public static final Companion Companion = new Object(null){
        {
            this();
        }
    };
    private static final int SWIPE_THRESHOLD = 100;
    private static final String TAG = "DynamicIslandWindowViewImpl";
    private final t _dispatchDrawEvent;
    private final t _dispatchTouchEvent;
    private int _headsUpHeight;
    private final t _onInterceptTouchEvent;
    private final t _onTouchEvent;
    private DynamicIslandViewComponent _viewComponent;
    private CopyOnWriteArrayList<DynamicIslandContentView> contentViewList;
    private boolean currentKeyguardShowing;
    private int currentUserId;
    private final y dispatchDrawEvent;
    private final y dispatchTouchEvent;
    private String downInWhichButton;
    private final List<DynamicIslandData> dynamicIslandDataList;
    private DynamicIslandEventCoordinator eventCoordinator;
    private CopyOnWriteArrayList<DynamicIslandContentFakeView> fakeViewList;
    private boolean isLight;
    private final ConcurrentHashMap<String, a> keyLocks;
    private final G0.d lifecycle$delegate;
    private DynamicIslandContent.DynamicIslandViewChangedListener listener;
    private Runnable longPress;
    private ViewGroup mGlowEffectBottomContainer;
    private ViewGroup mGlowEffectTopContainer;
    private final ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener;
    private final y onInterceptTouchEvent;
    private final y onTouchEvent;
    private DynamicIslandContentView pendingMediaView;
    private Configuration previousConfig;
    private boolean supportMiniWindowEndPositionChange;
    private boolean touchOutsideInHeadsUp;
    private final G0.d windowViewController$delegate;

    public DynamicIslandWindowView(Context context, AttributeSet object) {
        t t2;
        kotlin.jvm.internal.o.g((Object)context, (String)"context");
        super(context, object);
        this.windowViewController$delegate = e.b((U0.a)new U0.a(this){
            final DynamicIslandWindowView this$0;
            {
                this.this$0 = dynamicIslandWindowView;
                super(0);
            }

            public final DynamicIslandWindowViewController invoke() {
                return this.this$0.getViewComponent().getDynamicIslandWindowViewController();
            }
        });
        this.contentViewList = new CopyOnWriteArrayList();
        this.fakeViewList = new CopyOnWriteArrayList();
        this.dynamicIslandDataList = new ArrayList<DynamicIslandData>();
        this.currentUserId = ReflectBuilderUtil.getCurrentUserId();
        object = A.b((int)0, (int)0, null, (int)7, null);
        this._dispatchDrawEvent = object;
        this.dispatchDrawEvent = h.a((t)object);
        this.keyLocks = new ConcurrentHashMap();
        this.lifecycle$delegate = e.b((U0.a)new U0.a(this){
            final DynamicIslandWindowView this$0;
            {
                this.this$0 = dynamicIslandWindowView;
                super(0);
            }

            public final LifecycleRegistry invoke() {
                return new LifecycleRegistry((LifecycleOwner)this.this$0);
            }
        });
        object = new n(this);
        this.onGlobalLayoutListener = object;
        this.getLifecycle().setCurrentState(Lifecycle.State.CREATED);
        this.getViewTreeObserver().addOnGlobalLayoutListener((ViewTreeObserver.OnGlobalLayoutListener)object);
        this.previousConfig = new Configuration(this.getResources().getConfiguration());
        this.updateBlurContainer(MiBlurCompat.getBackgroundBlurOpened((Context)context));
        context = A.b((int)0, (int)0, null, (int)7, null);
        this._dispatchTouchEvent = context;
        this._onInterceptTouchEvent = t2 = A.b((int)0, (int)0, null, (int)7, null);
        object = A.b((int)0, (int)0, null, (int)7, null);
        this._onTouchEvent = object;
        this.dispatchTouchEvent = h.a((t)context);
        this.onInterceptTouchEvent = h.a((t)t2);
        this.onTouchEvent = h.a((t)object);
    }

    private static final void _set_headsUpHeight_$lambda$1(DynamicIslandWindowView dynamicIslandWindowView) {
        kotlin.jvm.internal.o.g((Object)((Object)dynamicIslandWindowView), (String)"this$0");
        dynamicIslandWindowView.collapse("heads up");
    }

    public static /* synthetic */ void a(DynamicIslandWindowView dynamicIslandWindowView) {
        DynamicIslandWindowView.maybeCollapseExpand$lambda$12(dynamicIslandWindowView);
    }

    public static final /* synthetic */ Object access$addDynamicIslandDataSuspend(DynamicIslandWindowView dynamicIslandWindowView, DynamicIslandData dynamicIslandData, boolean bl, float f, float f2, boolean bl2, boolean bl3, d d2) {
        return dynamicIslandWindowView.addDynamicIslandDataSuspend(dynamicIslandData, bl, f, f2, bl2, bl3, d2);
    }

    public static final /* synthetic */ Object access$buildDynamicIslandContentView(DynamicIslandWindowView dynamicIslandWindowView, DynamicIslandContentView dynamicIslandContentView, DynamicIslandData dynamicIslandData, d d2) {
        return dynamicIslandWindowView.buildDynamicIslandContentView(dynamicIslandContentView, dynamicIslandData, d2);
    }

    public static final /* synthetic */ Object access$buildDynamicIslandFakeContentView(DynamicIslandWindowView dynamicIslandWindowView, DynamicIslandContentFakeView dynamicIslandContentFakeView, DynamicIslandData dynamicIslandData, d d2) {
        return dynamicIslandWindowView.buildDynamicIslandFakeContentView(dynamicIslandContentFakeView, dynamicIslandData, d2);
    }

    public static final /* synthetic */ List access$getDynamicIslandDataList$p(DynamicIslandWindowView dynamicIslandWindowView) {
        return dynamicIslandWindowView.dynamicIslandDataList;
    }

    public static final /* synthetic */ ConcurrentHashMap access$getKeyLocks$p(DynamicIslandWindowView dynamicIslandWindowView) {
        return dynamicIslandWindowView.keyLocks;
    }

    public static final /* synthetic */ DynamicIslandContent.DynamicIslandViewChangedListener access$getListener$p(DynamicIslandWindowView dynamicIslandWindowView) {
        return dynamicIslandWindowView.listener;
    }

    public static final /* synthetic */ t access$get_dispatchDrawEvent$p(DynamicIslandWindowView dynamicIslandWindowView) {
        return dynamicIslandWindowView._dispatchDrawEvent;
    }

    public static final /* synthetic */ t access$get_dispatchTouchEvent$p(DynamicIslandWindowView dynamicIslandWindowView) {
        return dynamicIslandWindowView._dispatchTouchEvent;
    }

    public static final /* synthetic */ t access$get_onInterceptTouchEvent$p(DynamicIslandWindowView dynamicIslandWindowView) {
        return dynamicIslandWindowView._onInterceptTouchEvent;
    }

    public static final /* synthetic */ t access$get_onTouchEvent$p(DynamicIslandWindowView dynamicIslandWindowView) {
        return dynamicIslandWindowView._onTouchEvent;
    }

    public static final /* synthetic */ boolean access$hasDeviceNotification(DynamicIslandWindowView dynamicIslandWindowView) {
        return dynamicIslandWindowView.hasDeviceNotification();
    }

    public static final /* synthetic */ DynamicIslandContentView access$inflateDynamicIslandContentView(DynamicIslandWindowView dynamicIslandWindowView) {
        return dynamicIslandWindowView.inflateDynamicIslandContentView();
    }

    public static final /* synthetic */ DynamicIslandContentFakeView access$inflateDynamicIslandFakeContentView(DynamicIslandWindowView dynamicIslandWindowView, DynamicIslandData dynamicIslandData) {
        return dynamicIslandWindowView.inflateDynamicIslandFakeContentView(dynamicIslandData);
    }

    public static final /* synthetic */ void access$onDeviceNotificationChanged(DynamicIslandWindowView dynamicIslandWindowView, boolean bl) {
        dynamicIslandWindowView.onDeviceNotificationChanged(bl);
    }

    public static final /* synthetic */ void access$releaseMutexIfIdle(DynamicIslandWindowView dynamicIslandWindowView, String string, a a2) {
        dynamicIslandWindowView.releaseMutexIfIdle(string, a2);
    }

    public static final /* synthetic */ Object access$removeDynamicIslandDataSuspend(DynamicIslandWindowView dynamicIslandWindowView, String string, boolean bl, boolean bl2, boolean bl3, d d2) {
        return dynamicIslandWindowView.removeDynamicIslandDataSuspend(string, bl, bl2, bl3, d2);
    }

    public static final /* synthetic */ Object access$updateDynamicIslandViewSuspend(DynamicIslandWindowView dynamicIslandWindowView, DynamicIslandData dynamicIslandData, boolean bl, float f, boolean bl2, boolean bl3, d d2) {
        return dynamicIslandWindowView.updateDynamicIslandViewSuspend(dynamicIslandData, bl, f, bl2, bl3, d2);
    }

    public static /* synthetic */ void addDynamicIslandData$default(DynamicIslandWindowView dynamicIslandWindowView, DynamicIslandData dynamicIslandData, boolean bl, float f, float f2, boolean bl2, int n, Object object) {
        if ((n & 0x10) != 0) {
            bl2 = true;
        }
        dynamicIslandWindowView.addDynamicIslandData(dynamicIslandData, bl, f, f2, bl2);
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    private final Object addDynamicIslandDataSuspend(DynamicIslandData var1_1, boolean var2_2, float var3_3, float var4_4, boolean var5_5, boolean var6_6, d var7_7) {
        block20: {
            block21: {
                block22: {
                    block23: {
                        block26: {
                            block24: {
                                block25: {
                                    var10_8 /* !! */  = this;
                                    var9_9 /* !! */  = var1_1 /* !! */ ;
                                    if (!(var7_7 instanceof addDynamicIslandDataSuspend.1)) ** GOTO lbl-1000
                                    var11_10 = var7_7;
                                    var8_11 = var11_10.label;
                                    if ((var8_11 & -2147483648) != 0) {
                                        var11_10.label = var8_11 + -2147483648;
                                    } else lbl-1000:
                                    // 2 sources

                                    {
                                        var11_10 = new M0.d(this, (d)var7_7){
                                            Object L$0;
                                            Object L$1;
                                            Object L$2;
                                            Object L$3;
                                            boolean Z$0;
                                            int label;
                                            Object result;
                                            final DynamicIslandWindowView this$0;
                                            {
                                                this.this$0 = dynamicIslandWindowView;
                                                super(d2);
                                            }

                                            public final Object invokeSuspend(Object object) {
                                                this.result = object;
                                                this.label |= Integer.MIN_VALUE;
                                                return DynamicIslandWindowView.access$addDynamicIslandDataSuspend(this.this$0, null, false, 0.0f, 0.0f, false, false, (d)this);
                                            }
                                        };
                                    }
                                    var7_7 = var11_10.result;
                                    var15_12 = L0.c.c();
                                    switch (var11_10.label) {
                                        default: {
                                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                        }
                                        case 6: {
                                            var2_2 = var11_10.Z$0;
                                            var12_13 /* !! */  = (DynamicIslandContentFakeView)var11_10.L$3;
                                            var10_8 /* !! */  = (DynamicIslandContentView)var11_10.L$2;
                                            var13_14 /* !! */  = (DynamicIslandData)var11_10.L$1;
                                            var14_15 /* !! */  = (DynamicIslandWindowView)var11_10.L$0;
                                            G0.k.b((Object)var7_7);
                                            break block20;
                                        }
                                        case 5: {
                                            var2_2 = var11_10.Z$0;
                                            var1_1 /* !! */  = (DynamicIslandContentFakeView)var11_10.L$3;
                                            var10_8 /* !! */  = (DynamicIslandContentView)var11_10.L$2;
                                            var9_9 /* !! */  = (DynamicIslandData)var11_10.L$1;
                                            var12_13 /* !! */  = (DynamicIslandWindowView)var11_10.L$0;
                                            G0.k.b((Object)var7_7);
                                            var13_14 /* !! */  = var7_7;
                                            var7_7 = var12_13 /* !! */ ;
                                            break block21;
                                        }
                                        case 4: {
                                            var2_2 = var11_10.Z$0;
                                            var9_9 /* !! */  = (DynamicIslandContentView)var11_10.L$2;
                                            var1_1 /* !! */  = (DynamicIslandData)var11_10.L$1;
                                            var12_13 /* !! */  = (DynamicIslandWindowView)var11_10.L$0;
                                            G0.k.b((Object)var7_7);
                                            var10_8 /* !! */  = var7_7;
                                            var7_7 = var12_13 /* !! */ ;
                                            break block22;
                                        }
                                        case 3: {
                                            var2_2 = var11_10.Z$0;
                                            var9_9 /* !! */  = (DynamicIslandData)var11_10.L$1;
                                            var1_1 /* !! */  = (DynamicIslandWindowView)var11_10.L$0;
                                            G0.k.b((Object)var7_7);
                                            break block23;
                                        }
                                        case 2: {
                                            G0.k.b((Object)var7_7);
                                            break block24;
                                        }
                                        case 1: {
                                            G0.k.b((Object)var7_7);
                                            break;
                                        }
                                        case 0: {
                                            G0.k.b((Object)var7_7);
                                            var12_13 /* !! */  = var1_1 /* !! */ .getKey();
                                            var7_7 = new StringBuilder();
                                            var7_7.append("addDynamicIslandData begin ");
                                            var7_7.append(var12_13 /* !! */ );
                                            Log.d((String)"DynamicIslandWindowViewImpl", (String)var7_7.toString());
                                            if (var5_5) {
                                                var10_8 /* !! */ .dynamicIslandDataList.add(var1_1 /* !! */ );
                                            }
                                            var7_7 = (var7_7 = var1_1 /* !! */ .getExtras()) != null ? var7_7.getString("miui.pkg.name") : null;
                                            var12_13 /* !! */  = var1_1 /* !! */ .getKey();
                                            var12_13 /* !! */  = var12_13 /* !! */  != null ? this.getViewFromList(var12_13 /* !! */ ) : null;
                                            if ((var12_13 /* !! */  = var12_13 /* !! */  != null ? var12_13 /* !! */ .getState() : null) != null) {
                                                var11_10.label = 1;
                                                if (DynamicIslandWindowView.updateDynamicIslandViewSuspend$default(this, var1_1 /* !! */ , var2_2, var3_3, true, false, (d)var11_10, 16, null) != var15_12) break;
                                                return var15_12;
                                            }
                                            break block25;
                                        }
                                    }
                                    return s.a;
                                }
                                if (this.hasPendingMedia(var1_1 /* !! */ )) {
                                    var11_10.label = 2;
                                    if (DynamicIslandWindowView.updateDynamicIslandViewSuspend$default(this, var1_1 /* !! */ , var2_2, var3_3, false, false, (d)var11_10, 24, null) == var15_12) {
                                        return var15_12;
                                    } else {
                                        ** GOTO lbl82
                                    }
                                }
                                break block26;
                            }
                            return s.a;
                        }
                        var12_13 /* !! */  = var1_1 /* !! */ .getExtras();
                        var12_13 /* !! */  = var12_13 /* !! */  != null ? b.c((int)var12_13 /* !! */ .getInt("miui.user.id")) : null;
                        var13_14 /* !! */  = var1_1 /* !! */ .getProperties();
                        this.notifyAddIsland((String)var7_7, (Integer)var12_13 /* !! */ , var1_1 /* !! */ .getKey(), (Integer)var13_14 /* !! */ );
                        this.requestImmersiveMode();
                        var7_7 = this.getWindowViewController().getInflateContext();
                        var1_1 /* !! */  = new U0.o(this, null){
                            int label;
                            final DynamicIslandWindowView this$0;
                            {
                                this.this$0 = dynamicIslandWindowView;
                                super(2, d2);
                            }

                            public final d create(Object object, d d2) {
                                return new /* invalid duplicate definition of identical inner class */;
                            }

                            public final Object invoke(f1.E e2, d d2) {
                                return (this.create(e2, d2)).invokeSuspend(s.a);
                            }

                            public final Object invokeSuspend(Object object) {
                                L0.c.c();
                                if (this.label == 0) {
                                    G0.k.b((Object)object);
                                    return DynamicIslandWindowView.access$inflateDynamicIslandContentView(this.this$0);
                                }
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                        };
                        var11_10.L$0 = var10_8 /* !! */ ;
                        var11_10.L$1 = var9_9 /* !! */ ;
                        var11_10.Z$0 = var2_2;
                        var11_10.label = 3;
                        var12_13 /* !! */  = f.c((K0.g)var7_7, (U0.o)var1_1 /* !! */ , (d)var11_10);
                        var1_1 /* !! */  = var10_8 /* !! */ ;
                        var7_7 = var12_13 /* !! */ ;
                        if (var12_13 /* !! */  == var15_12) {
                            return var15_12;
                        }
                    }
                    var7_7 = (DynamicIslandContentView)var7_7;
                    var10_8 /* !! */  = var1_1 /* !! */ .getWindowViewController().getInflateContext();
                    var12_13 /* !! */  = new U0.o((DynamicIslandWindowView)var1_1 /* !! */ , var9_9 /* !! */ , null){
                        final DynamicIslandData $dynamicIslandData;
                        int label;
                        final DynamicIslandWindowView this$0;
                        {
                            this.this$0 = dynamicIslandWindowView;
                            this.$dynamicIslandData = dynamicIslandData;
                            super(2, d2);
                        }

                        public final d create(Object object, d d2) {
                            return new /* invalid duplicate definition of identical inner class */;
                        }

                        public final Object invoke(f1.E e2, d d2) {
                            return (this.create(e2, d2)).invokeSuspend(s.a);
                        }

                        public final Object invokeSuspend(Object object) {
                            L0.c.c();
                            if (this.label == 0) {
                                G0.k.b((Object)object);
                                return DynamicIslandWindowView.access$inflateDynamicIslandFakeContentView(this.this$0, this.$dynamicIslandData);
                            }
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                    };
                    var11_10.L$0 = var1_1 /* !! */ ;
                    var11_10.L$1 = var9_9 /* !! */ ;
                    var11_10.L$2 = var7_7;
                    var11_10.Z$0 = var2_2;
                    var11_10.label = 4;
                    var12_13 /* !! */  = f.c((K0.g)var10_8 /* !! */ , (U0.o)var12_13 /* !! */ , (d)var11_10);
                    if (var12_13 /* !! */  == var15_12) {
                        return var15_12;
                    }
                    var10_8 /* !! */  = var9_9 /* !! */ ;
                    var9_9 /* !! */  = var7_7;
                    var7_7 = var1_1 /* !! */ ;
                    var1_1 /* !! */  = var10_8 /* !! */ ;
                    var10_8 /* !! */  = var12_13 /* !! */ ;
                }
                var12_13 /* !! */  = (DynamicIslandContentFakeView)var10_8 /* !! */ ;
                var11_10.L$0 = var7_7;
                var11_10.L$1 = var1_1 /* !! */ ;
                var11_10.L$2 = var9_9 /* !! */ ;
                var11_10.L$3 = var12_13 /* !! */ ;
                var11_10.Z$0 = var2_2;
                var11_10.label = 5;
                var13_14 /* !! */  = super.buildDynamicIslandContentView((DynamicIslandContentView)var9_9 /* !! */ , var1_1 /* !! */ , (d)var11_10);
                if (var13_14 /* !! */  == var15_12) {
                    return var15_12;
                }
                var10_8 /* !! */  = var9_9 /* !! */ ;
                var9_9 /* !! */  = var1_1 /* !! */ ;
                var1_1 /* !! */  = var12_13 /* !! */ ;
            }
            if (!((Boolean)var13_14 /* !! */ ).booleanValue()) {
                return s.a;
            }
            var11_10.L$0 = var7_7;
            var11_10.L$1 = var9_9 /* !! */ ;
            var11_10.L$2 = var10_8 /* !! */ ;
            var11_10.L$3 = var1_1 /* !! */ ;
            var11_10.Z$0 = var2_2;
            var11_10.label = 6;
            var12_13 /* !! */  = var1_1 /* !! */ ;
            var13_14 /* !! */  = var9_9 /* !! */ ;
            var14_15 /* !! */  = var7_7;
            if (super.buildDynamicIslandFakeContentView((DynamicIslandContentFakeView)var1_1 /* !! */ , var9_9 /* !! */ , (d)var11_10) == var15_12) {
                return var15_12;
            }
        }
        var14_15 /* !! */ .handleContentViewAddOperate((DynamicIslandContentView)var10_8 /* !! */ , (DynamicIslandContentFakeView)var12_13 /* !! */ , var13_14 /* !! */ , var2_2);
        return s.a;
    }

    public static /* synthetic */ Object addDynamicIslandDataSuspend$default(DynamicIslandWindowView dynamicIslandWindowView, DynamicIslandData dynamicIslandData, boolean bl, float f, float f2, boolean bl2, boolean bl3, d d2, int n, Object object) {
        block1: {
            if ((n & 0x10) != 0) {
                bl2 = true;
            }
            if ((n & 0x20) == 0) break block1;
            bl3 = false;
        }
        return dynamicIslandWindowView.addDynamicIslandDataSuspend(dynamicIslandData, bl, f, f2, bl2, bl3, d2);
    }

    /*
     * Unable to fully structure code
     */
    private final boolean assertUserSpace(DynamicIslandData var1_1) {
        block4: {
            block5: {
                var1_1 = var1_1 != null && (var1_1 = var1_1.getExtras()) != null ? Integer.valueOf(var1_1.getInt("miui.user.id")) : null;
                var2_2 = this.currentUserId;
                var4_3 = true;
                if (var2_2 != 0) ** GOTO lbl-1000
                if (var1_1 == null) break block5;
                var3_4 = var4_3;
                if (var1_1.intValue() == 0) break block4;
            }
            if (var1_1 != null && var1_1.intValue() == 999) {
                var3_4 = var4_3;
            } else {
                while (true) {
                    var3_4 = false;
                    break block4;
                    break;
                }
            }
lbl-1000:
            // 1 sources

            {
                if (var1_1 == null || var1_1.intValue() != var2_2) ** continue;
                var3_4 = var4_3;
            }
        }
        var2_2 = this.currentUserId;
        var5_5 = new StringBuilder();
        var5_5.append("assert: currentUserId=");
        var5_5.append(var2_2);
        var5_5.append(", appUid=");
        var5_5.append(var1_1);
        var5_5.append(", result=");
        var5_5.append(var3_4);
        Log.e((String)"DynamicIslandWindowViewImpl", (String)var5_5.toString());
        return var3_4;
    }

    public static /* synthetic */ void b(DynamicIslandWindowView dynamicIslandWindowView) {
        DynamicIslandWindowView._set_headsUpHeight_$lambda$1(dynamicIslandWindowView);
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    private final Object buildDynamicIslandContentView(DynamicIslandContentView var1_1, DynamicIslandData var2_2, d var3_3) {
        if (!(var3_3 instanceof buildDynamicIslandContentView.1)) ** GOTO lbl-1000
        var6_4 = var3_3;
        var4_5 = var6_4.label;
        if ((var4_5 & -2147483648) != 0) {
            var6_4.label = var4_5 + -2147483648;
            var3_3 = var6_4;
        } else lbl-1000:
        // 2 sources

        {
            var3_3 = new M0.d(this, (d)var3_3){
                Object L$0;
                Object L$1;
                Object L$2;
                int label;
                Object result;
                final DynamicIslandWindowView this$0;
                {
                    this.this$0 = dynamicIslandWindowView;
                    super(d2);
                }

                public final Object invokeSuspend(Object object) {
                    this.result = object;
                    this.label |= Integer.MIN_VALUE;
                    return DynamicIslandWindowView.access$buildDynamicIslandContentView(this.this$0, null, null, (d)this);
                }
            };
        }
        var6_4 = var3_3.result;
        var9_6 = L0.c.c();
        var4_5 = var3_3.label;
        if (var4_5 == 0) ** GOTO lbl21
        if (var4_5 == 1) {
            var1_1 = (DynamicIslandBackgroundView)var3_3.L$2;
            var7_7 = (DynamicIslandContentView)var3_3.L$1;
            var2_2 /* !! */  = (DynamicIslandWindowView)var3_3.L$0;
            G0.k.b((Object)var6_4);
            var3_3 = var7_7;
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
lbl21:
            // 1 sources

            G0.k.b((Object)var6_4);
            var1_1.setController(this.getViewComponent().getContentViewControllerFactory().create((DynamicIslandContentView)var1_1));
            var6_4 = DynamicIslandUtils.INSTANCE;
            var7_8 /* !! */  = this.getContext();
            kotlin.jvm.internal.o.f((Object)var7_8 /* !! */ , (String)"getContext(...)");
            var1_1.setTranslationX((float)var6_4.getScreenWidthOld(var7_8 /* !! */ ) / 2.0f);
            var7_8 /* !! */  = this.getContext();
            kotlin.jvm.internal.o.f((Object)var7_8 /* !! */ , (String)"getContext(...)");
            var1_1.setTranslationY(-((float)var6_4.getScreenHeightOld(var7_8 /* !! */ )));
            var7_8 /* !! */  = var1_1.getBackgroundView();
            this.addView((View)var7_8 /* !! */ );
            this.contentViewList.removeIf(new p(new Function1(var2_2 /* !! */ , this){
                final DynamicIslandData $dynamicIslandData;
                final DynamicIslandWindowView this$0;
                {
                    this.$dynamicIslandData = dynamicIslandData;
                    this.this$0 = dynamicIslandWindowView;
                    super(1);
                }

                public final Boolean invoke(DynamicIslandContentView dynamicIslandContentView) {
                    Object object = dynamicIslandContentView.getCurrentIslandData();
                    object = object != null ? object.getKey() : null;
                    boolean bl = kotlin.jvm.internal.o.c((Object)object, (Object)this.$dynamicIslandData.getKey());
                    if (bl) {
                        this.this$0.removeView((View)dynamicIslandContentView.getBackgroundView());
                        dynamicIslandContentView.getController().destroy();
                    }
                    return bl;
                }
            }));
            this.contentViewList.add((DynamicIslandContentView)var1_1);
            this.onDynamicIslandDataChanged();
            var6_4 = DynamicIslandBaseContentViewBinder.INSTANCE;
            var8_9 = this.getViewComponent().getSizeRepository();
            var10_10 = var2_2 /* !! */ .getProperties();
            var5_11 = var10_10 != null && var10_10 == 0;
            var6_4.bind((DynamicIslandBaseContentView)var1_1, (DynamicIslandSizeRepository)var8_9, var5_11, var2_2 /* !! */ );
            var1_1.setMaxWidth((this.getViewComponent().getSizeRepository().getIslandWidthParams().getValue()).getMaxWidth(), (this.getViewComponent().getSizeRepository().getIslandWidthParams().getValue()).getClockWidth(), (this.getViewComponent().getSizeRepository().getIslandWidthParams().getValue()).getBatteryWidth());
            var6_4 = this.eventCoordinator;
            if (var6_4 != null) {
                var1_1.setEventHandler((DynamicIslandEventCoordinator)var6_4);
                DynamicIslandContentViewExtKt.initRemainingUnit((DynamicIslandContentView)var1_1, var6_4.getBurnInTimeout());
            }
            var3_3.L$0 = this;
            var3_3.L$1 = var1_1;
            var3_3.L$2 = var7_8 /* !! */ ;
            var3_3.label = 1;
            var8_9 = DynamicIslandBaseContentView.updateView$default((DynamicIslandBaseContentView)var1_1, var2_2 /* !! */ , false, false, (d)var3_3, 4, null);
            var2_2 /* !! */  = this;
            var3_3 = var1_1;
            var6_4 = var8_9;
            var1_1 = var7_8 /* !! */ ;
            if (var8_9 == var9_6) {
                return var9_6;
            }
        }
        if (!((Boolean)var6_4).booleanValue()) {
            var2_2 /* !! */ .contentViewList.remove(var3_3);
            var2_2 /* !! */ .removeView((View)var1_1);
            var3_3.getController().destroy();
            return b.a((boolean)false);
        }
        return b.a((boolean)true);
    }

    private static final boolean buildDynamicIslandContentView$lambda$17(Function1 function1, Object object) {
        kotlin.jvm.internal.o.g((Object)function1, (String)"$tmp0");
        return (Boolean)function1.invoke(object);
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    private final Object buildDynamicIslandFakeContentView(DynamicIslandContentFakeView var1_1, DynamicIslandData var2_2, d var3_3) {
        block7: {
            block6: {
                block4: {
                    block5: {
                        if (!(var3_3 /* !! */  instanceof buildDynamicIslandFakeContentView.1)) ** GOTO lbl-1000
                        var6_4 /* !! */  = var3_3 /* !! */ ;
                        var4_5 = var6_4 /* !! */ .label;
                        if ((var4_5 & -2147483648) != 0) {
                            var6_4 /* !! */ .label = var4_5 + -2147483648;
                            var3_3 /* !! */  = var6_4 /* !! */ ;
                        } else lbl-1000:
                        // 2 sources

                        {
                            var3_3 /* !! */  = new M0.d(this, var3_3 /* !! */ ){
                                Object L$0;
                                Object L$1;
                                int label;
                                Object result;
                                final DynamicIslandWindowView this$0;
                                {
                                    this.this$0 = dynamicIslandWindowView;
                                    super(d2);
                                }

                                public final Object invokeSuspend(Object object) {
                                    this.result = object;
                                    this.label |= Integer.MIN_VALUE;
                                    return DynamicIslandWindowView.access$buildDynamicIslandFakeContentView(this.this$0, null, null, (d)this);
                                }
                            };
                        }
                        var9_6 = var3_3 /* !! */ .result;
                        var8_7 = L0.c.c();
                        var4_5 = var3_3 /* !! */ .label;
                        if (var4_5 == 0) break block4;
                        if (var4_5 != 1) break block5;
                        var7_8 /* !! */  = (DynamicIslandContentFakeView)var3_3 /* !! */ .L$1;
                        var6_4 /* !! */  = (DynamicIslandWindowView)var3_3 /* !! */ .L$0;
                        G0.k.b((Object)var9_6);
                        break block6;
                    }
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                G0.k.b((Object)var9_6);
                if (!DynamicIslandAnimUtils.INSTANCE.featureDynamicIslandNoNeedFakeView() && var2_2.getView() != null && var1_1 != null) {
                    this.addView((View)var1_1);
                    var1_1.setController(this.getViewComponent().getBaseContentViewControllerFactory().create(var1_1));
                    this.fakeViewList.add((DynamicIslandContentFakeView)var1_1);
                    var9_6 = DynamicIslandBaseContentViewBinder.INSTANCE;
                    var7_8 /* !! */  = this.getViewComponent().getSizeRepository();
                    var6_4 /* !! */  = var2_2.getProperties();
                    var5_9 = var6_4 /* !! */  != null && var6_4 /* !! */ .intValue() == 0;
                    var9_6.bind((DynamicIslandBaseContentView)var1_1, (DynamicIslandSizeRepository)var7_8 /* !! */ , var5_9, var2_2);
                    var1_1.setMaxWidth((this.getViewComponent().getSizeRepository().getIslandWidthParams().getValue()).getMaxWidth(), (this.getViewComponent().getSizeRepository().getIslandWidthParams().getValue()).getClockWidth(), (this.getViewComponent().getSizeRepository().getIslandWidthParams().getValue()).getBatteryWidth());
                    var3_3 /* !! */ .L$0 = this;
                    var3_3 /* !! */ .L$1 = var1_1;
                    var3_3 /* !! */ .label = 1;
                    var6_4 /* !! */  = this;
                    var7_8 /* !! */  = var1_1;
                    if (DynamicIslandBaseContentView.updateView$default((DynamicIslandBaseContentView)var1_1, var2_2, false, false, var3_3 /* !! */ , 4, null) == var8_7) {
                        return var8_7;
                    } else {
                        ** GOTO lbl41
                    }
                }
                break block7;
            }
            var1_1 = var6_4 /* !! */ .eventCoordinator;
            kotlin.jvm.internal.o.d((Object)var1_1);
            var7_8 /* !! */ .setEventHandler((DynamicIslandEventCoordinator)var1_1);
            return s.a;
        }
        return s.a;
    }

    public static /* synthetic */ void c(DynamicIslandWindowView dynamicIslandWindowView) {
        DynamicIslandWindowView.onGlobalLayoutListener$lambda$2(dynamicIslandWindowView);
    }

    private final boolean canUpdate(DynamicIslandContentView dynamicIslandContentView, boolean bl) {
        DynamicIslandContentFakeView dynamicIslandContentFakeView;
        if (dynamicIslandContentView != null && (dynamicIslandContentFakeView = dynamicIslandContentView.getFakeView()) != null && (dynamicIslandContentFakeView = dynamicIslandContentFakeView.getTrackingToOpenMW()) != null && ((Boolean)dynamicIslandContentFakeView.getValue()).booleanValue() || dynamicIslandContentView != null && (dynamicIslandContentFakeView = dynamicIslandContentView.getFakeView()) != null && dynamicIslandContentFakeView.getMStartEnterMiniWindow() && dynamicIslandContentView != null && (dynamicIslandContentFakeView = dynamicIslandContentView.getFakeView()) != null && !dynamicIslandContentFakeView.getMiniWindowAlreadyOpen()) {
            return false;
        }
        return dynamicIslandContentView == null || (dynamicIslandContentView = dynamicIslandContentView.getIslandFreeformAnimRunning()) == null || (Boolean)dynamicIslandContentView.getValue() != true || bl;
    }

    public static /* synthetic */ boolean canUpdate$default(DynamicIslandWindowView dynamicIslandWindowView, DynamicIslandContentView dynamicIslandContentView, boolean bl, int n, Object object) {
        if ((n & 2) != 0) {
            bl = false;
        }
        return dynamicIslandWindowView.canUpdate(dynamicIslandContentView, bl);
    }

    public static /* synthetic */ void clearAfterDelete$default(DynamicIslandWindowView dynamicIslandWindowView, DynamicIslandData dynamicIslandData, String string, boolean bl, int n, Object object) {
        if ((n & 4) != 0) {
            bl = true;
        }
        dynamicIslandWindowView.clearAfterDelete(dynamicIslandData, string, bl);
    }

    private final boolean compareConfigurations(Configuration configuration, Configuration configuration2) {
        Object object = configuration.getExtraConfig();
        boolean bl = object instanceof MiuiConfiguration;
        Object var8_5 = null;
        object = bl ? (MiuiConfiguration)object : null;
        int n2 = object != null ? object.themeChanged : 0;
        object = configuration2 != null ? configuration2.getExtraConfig() : null;
        object = object instanceof MiuiConfiguration ? (MiuiConfiguration)object : null;
        int n3 = object != null ? object.themeChanged : 0;
        Locale locale = configuration.locale;
        object = configuration2 != null ? configuration2.locale : null;
        kotlin.jvm.internal.o.c((Object)locale, (Object)object);
        float f2 = configuration.fontScale;
        object = var8_5;
        if (configuration2 != null) {
            object = Float.valueOf(configuration2.fontScale);
        }
        kotlin.jvm.internal.o.a((float)f2, (Float)object);
        if (CommonUtils.INSTANCE.getIS_TABLET() && n2 != 0 && n3 != 0 && n2 != n3) {
            return true;
        }
        return configuration2 == null || configuration.getLayoutDirection() != configuration2.getLayoutDirection() || configuration2 == null || configuration.densityDpi != configuration2.densityDpi;
    }

    public static /* synthetic */ void d(DynamicIslandBaseContentView dynamicIslandBaseContentView, DynamicIslandContentView dynamicIslandContentView, float f) {
        DynamicIslandWindowView.onLongPress$lambda$36(dynamicIslandBaseContentView, dynamicIslandContentView, f);
    }

    private final void dispatchAddEvent(DynamicIslandContentView dynamicIslandContentView, DynamicIslandData object) {
        boolean bl = this.contentViewList.contains((Object)dynamicIslandContentView);
        Object object2 = object.getKey();
        Object object3 = new StringBuilder();
        ((StringBuilder)object3).append("addDynamicIslandData contentViewList ");
        ((StringBuilder)object3).append(bl);
        ((StringBuilder)object3).append(" ");
        ((StringBuilder)object3).append((String)object2);
        Log.e((String)TAG, (String)((StringBuilder)object3).toString());
        if (!this.contentViewList.contains((Object)dynamicIslandContentView)) {
            return;
        }
        this.measureExpandedViewHeight(dynamicIslandContentView);
        if (this.handleAppOrMiniWindowEvent((DynamicIslandData)object, dynamicIslandContentView)) {
            return;
        }
        object2 = this.eventCoordinator;
        if (object2 != null) {
            object3 = DynamicIslandEvent.AddDynamicIsland.INSTANCE;
            bl = (object = object.getProperties()) != null && (Integer)object == 0;
            object3.setTempShow(bl);
            ((DynamicIslandEventCoordinator)object2).dispatchEvent((DynamicIslandEvent)object3, dynamicIslandContentView);
        }
    }

    private final void dispatchUpdateEvent(DynamicIslandData object, boolean bl, float f2, boolean bl2) {
        DynamicIslandContentView dynamicIslandContentView = this.getViewFromList(object.getKey());
        if (dynamicIslandContentView == null) {
            DynamicIslandWindowView.addDynamicIslandData$default(this, (DynamicIslandData)object, bl, f2, this.getWindowViewController().getCutoutY(), false, 16, null);
        } else {
            Object object2;
            this.measureExpandedViewHeight(dynamicIslandContentView);
            Object object3 = dynamicIslandContentView.getState();
            if (object3 != null) {
                object2 = object.getKey();
                kotlin.jvm.internal.o.d((Object)object2);
                ((State)object3).setUpdateKey((String)object2);
            }
            dynamicIslandContentView.setCurrentIslandData((DynamicIslandData)object);
            object2 = this.getWindowViewController().getIslandTemplate((DynamicIslandData)object);
            object2 = object2 != null ? Boolean.valueOf(((IslandTemplate)object2).getIslandOrder()) : null;
            if (bl || kotlin.jvm.internal.o.c((Object)object2, (Object)Boolean.TRUE)) {
                object3 = dynamicIslandContentView.getState();
                if (object3 != null) {
                    ((State)object3).setTime(System.currentTimeMillis());
                }
                DynamicIslandState dynamicIslandState = dynamicIslandContentView.getState();
                if (dynamicIslandState != null) {
                    object3 = object.getExtras();
                    object3 = object3 != null && (object3 = (StatusBarNotification)object3.getParcelable("miui.sbn", StatusBarNotification.class)) != null ? Long.valueOf(object3.getPostTime()) : Long.valueOf(0L);
                    dynamicIslandState.setPostTime((Long)object3);
                }
            }
            if ((object3 = dynamicIslandContentView.getState()) != null) {
                ((State)object3).setUpdateOrder((Boolean)object2);
            }
            object2 = dynamicIslandContentView.getState();
            if (object2 != null) {
                ((State)object2).setExpanded(this.canExpanded(bl, object.getView(), object.getKey()));
            }
            if (!this.canUpdate(dynamicIslandContentView, bl2)) {
                return;
            }
            if ((((Boolean)this.getWindowViewController().isAppAnimRunning().getValue()).booleanValue() || ((Boolean)this.getWindowViewController().isFreeformAnimRunning().getValue()).booleanValue()) && dynamicIslandContentView.getState() instanceof DynamicIslandState.BigIsland) {
                this.getWindowViewController().updateAppRect(dynamicIslandContentView, false);
                object = dynamicIslandContentView.getFakeView();
                if (object != null) {
                    ((DynamicIslandContentFakeView)((Object)object)).setForceUpdateBigIslandView(true);
                }
            }
            if ((object = this.eventCoordinator) != null) {
                ((DynamicIslandEventCoordinator)object).dispatchEvent(DynamicIslandEvent.UpdateDynamicIsland.INSTANCE, dynamicIslandContentView);
            }
            dynamicIslandContentView.updateMiniBarTranslation$miui_dynamicisland_release(dynamicIslandContentView);
            object = dynamicIslandContentView.getFakeView();
            if (object != null) {
                ((DynamicIslandContentFakeView)((Object)object)).setForceUpdateBigIslandView(false);
            }
        }
    }

    public static /* synthetic */ boolean downInMedia$default(DynamicIslandWindowView dynamicIslandWindowView, Context context, float f, float f2, View view, boolean bl, int n, Object object) {
        if ((n & 0x10) != 0) {
            bl = false;
        }
        return dynamicIslandWindowView.downInMedia(context, f, f2, view, bl);
    }

    public static /* synthetic */ boolean e(Function1 function1, Object object) {
        return DynamicIslandWindowView.buildDynamicIslandContentView$lambda$17(function1, object);
    }

    private final int getWindowInsetsRotation(WindowInsets windowInsets) {
        int n2;
        int n3 = n2 = -1;
        if (windowInsets != null) {
            windowInsets = windowInsets.getDisplayCutout();
            n3 = n2;
            if (windowInsets != null) {
                if (windowInsets.getSafeInsetRight() > 0) {
                    n3 = 0;
                } else if (windowInsets.getSafeInsetTop() > 0) {
                    n3 = 1;
                } else if (windowInsets.getSafeInsetLeft() > 0) {
                    n3 = 2;
                } else {
                    n3 = n2;
                    if (windowInsets.getSafeInsetBottom() > 0) {
                        n3 = 3;
                    }
                }
            }
        }
        return n3;
    }

    private final boolean handleAppOrMiniWindowEvent(DynamicIslandData object, DynamicIslandContentView dynamicIslandContentView) {
        Object object2 = object.getExtras();
        Object var6_4 = null;
        String string = object2 != null ? object2.getString("miui.pkg.name") : null;
        Object object3 = this.requestTopActivityPkgName();
        object2 = object3;
        if (object3 == null) {
            Log.e((String)TAG, (String)"requestTopActivityPkgName from systemUi fail");
            object2 = ActivityManagerWrapper.INSTANCE.getFocusedRootTaskInfo();
            object2 = object2 != null && (object2 = object2.topActivity) != null ? object2.getPackageName() : null;
        }
        object3 = this.getWindowViewController();
        Bundle bundle = object.getExtras();
        object = var6_4;
        if (bundle != null) {
            object = bundle.getInt("miui.user.id");
        }
        boolean bl = ((DynamicIslandWindowViewController)object3).isInMiniWindow(string, (Integer)object);
        object = new StringBuilder();
        ((StringBuilder)object).append("appPkg: ");
        ((StringBuilder)object).append(string);
        ((StringBuilder)object).append(", topActivityPkgName: ");
        ((StringBuilder)object).append((String)object2);
        Log.e((String)TAG, (String)((StringBuilder)object).toString());
        return this.shouldEnterAppOrMiniWindow((String)object2, dynamicIslandContentView, string, bl);
    }

    private final void handleContentViewAddOperate(DynamicIslandContentView dynamicIslandContentView, DynamicIslandContentFakeView object, DynamicIslandData dynamicIslandData, boolean bl) {
        this.onDeviceNotificationChanged(this.hasDeviceNotification());
        this.handleInitState(dynamicIslandContentView, (DynamicIslandContentFakeView)((Object)object), dynamicIslandData, bl);
        this.getWindowViewController().updateChronometersIn(dynamicIslandContentView, (DynamicIslandBaseContentView)((Object)object), dynamicIslandData);
        this.getWindowViewController().addLottieAnimView(dynamicIslandContentView, (DynamicIslandBaseContentView)((Object)object), dynamicIslandData.getKey());
        if (this.canExpanded(bl, dynamicIslandData.getView(), dynamicIslandData.getKey())) {
            object = this.eventCoordinator;
            if (object != null) {
                ((DynamicIslandEventCoordinator)object).onHeightChangedFirst();
            }
            if ((object = this.eventCoordinator) != null) {
                ((DynamicIslandEventCoordinator)object).setUserExpanded(false);
            }
        }
        this.scheduleAddDynamicIslandPreDrawOperations(dynamicIslandContentView, dynamicIslandData);
    }

    private final void handleContentViewUpdateOperate(DynamicIslandContentView dynamicIslandContentView, DynamicIslandData dynamicIslandData, boolean bl, float f2, boolean bl2) {
        Object object = this.eventCoordinator;
        if ((object == null || !object.getUserExpanded()) && this.canExpanded(bl, dynamicIslandData.getView(), dynamicIslandData.getKey()) && (object = this.eventCoordinator) != null) {
            object.onHeightChangedFirst();
        }
        this.scheduleUpdateDynamicIslandPreDrawOperations(dynamicIslandContentView, dynamicIslandData, bl, f2, bl2);
        DynamicIslandWindowViewController dynamicIslandWindowViewController = this.getWindowViewController();
        Object var7_8 = null;
        object = dynamicIslandContentView != null ? dynamicIslandContentView.getFakeView() : null;
        dynamicIslandWindowViewController.updateChronometersIn(dynamicIslandContentView, (DynamicIslandBaseContentView)((Object)object), dynamicIslandData);
        dynamicIslandWindowViewController = this.getWindowViewController();
        object = var7_8;
        if (dynamicIslandContentView != null) {
            object = dynamicIslandContentView.getFakeView();
        }
        dynamicIslandWindowViewController.addLottieAnimView(dynamicIslandContentView, (DynamicIslandBaseContentView)((Object)object), dynamicIslandData.getKey());
    }

    private final void handleInitState(DynamicIslandContentView dynamicIslandContentView, DynamicIslandContentFakeView dynamicIslandContentFakeView, DynamicIslandData object, boolean bl) {
        DynamicIslandState dynamicIslandState = new DynamicIslandState(){};
        dynamicIslandState.setTime(System.currentTimeMillis());
        Object object2 = object.getExtras();
        object2 = object2 != null && (object2 = (StatusBarNotification)object2.getParcelable("miui.sbn", StatusBarNotification.class)) != null ? Long.valueOf(object2.getPostTime()) : Long.valueOf(0L);
        dynamicIslandState.setPostTime((Long)object2);
        object = object.getProperties();
        boolean bl2 = object != null && (Integer)object == 0;
        dynamicIslandState.setTempShow(bl2);
        dynamicIslandState.setExpanded(bl);
        dynamicIslandContentView.setState(dynamicIslandState);
        dynamicIslandContentView.setFakeView(dynamicIslandContentFakeView);
        object2 = this.mGlowEffectTopContainer;
        object = object2;
        if (object2 == null) {
            kotlin.jvm.internal.o.w((String)"mGlowEffectTopContainer");
            object = null;
        }
        ViewGroup viewGroup = this.mGlowEffectBottomContainer;
        object2 = viewGroup;
        if (viewGroup == null) {
            kotlin.jvm.internal.o.w((String)"mGlowEffectBottomContainer");
            object2 = null;
        }
        dynamicIslandContentView.initGlowEffect$miui_dynamicisland_release((ViewGroup)object, (ViewGroup)object2);
        if (dynamicIslandContentFakeView != null) {
            dynamicIslandContentFakeView.setRealView(dynamicIslandContentView);
        }
        dynamicIslandContentView.getViewModel().setState(null, dynamicIslandState);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private final boolean hasDeviceNotification() {
        Object object;
        List<DynamicIslandData> list = this.dynamicIslandDataList;
        if (list != null && list.isEmpty()) return false;
        list = list.iterator();
        do {
            if (!list.hasNext()) return false;
        } while ((object = (DynamicIslandData)list.next()) == null || (object = object.getProperties()) == null || (Integer)object != 0);
        list = this.contentViewList;
        if (list != null && list.isEmpty()) return false;
        list = list.iterator();
        do {
            if (!list.hasNext()) return false;
        } while ((object = ((DynamicIslandContentView)((Object)list.next())).getCurrentIslandData()) == null || (object = object.getProperties()) == null || (Integer)object != 0);
        return true;
    }

    private final boolean hasPendingMedia(DynamicIslandData dynamicIslandData) {
        DynamicIslandBaseContentView dynamicIslandBaseContentView;
        if (this.isMediaApp(dynamicIslandData) && (dynamicIslandBaseContentView = this.pendingMediaView) != null) {
            Object object;
            boolean bl = this.contentViewList.contains((Object)dynamicIslandBaseContentView);
            Object var4_4 = null;
            if (!bl) {
                this.contentViewList.add(this.pendingMediaView);
                object = this.fakeViewList;
                dynamicIslandBaseContentView = this.pendingMediaView;
                dynamicIslandBaseContentView = dynamicIslandBaseContentView != null ? dynamicIslandBaseContentView.getFakeView() : null;
                ((CopyOnWriteArrayList)object).add(dynamicIslandBaseContentView);
            }
            if ((dynamicIslandBaseContentView = this.pendingMediaView) != null) {
                dynamicIslandBaseContentView.setCurrentIslandData(dynamicIslandData);
            }
            object = this.pendingMediaView;
            dynamicIslandBaseContentView = var4_4;
            if (object != null) {
                dynamicIslandBaseContentView = ((DynamicIslandBaseContentView)((Object)object)).getFakeView();
            }
            if (dynamicIslandBaseContentView != null) {
                dynamicIslandBaseContentView.setCurrentIslandData(dynamicIslandData);
            }
            return true;
        }
        return false;
    }

    private final boolean hasSamePkgEnterFreeFrom(String object) {
        if ((object = object != null ? this.requestHasIsland((String)object) : null) != null) {
            object = object.iterator();
            while (object.hasNext()) {
                DynamicIslandContentView dynamicIslandContentView = (DynamicIslandContentView)((Object)object.next());
                if (dynamicIslandContentView == null || !(dynamicIslandContentView.getWindowAnimState() instanceof WindowAnimState.Opening)) continue;
                return true;
            }
        }
        return false;
    }

    private final DynamicIslandContentView inflateDynamicIslandContentView() {
        Object object = LayoutInflater.from((Context)this.getContext()).inflate(R.layout.dynamic_island_view, (ViewGroup)this, false);
        kotlin.jvm.internal.o.e((Object)object, (String)"null cannot be cast to non-null type miui.systemui.dynamicisland.DynamicIslandBackgroundView");
        object = (DynamicIslandBackgroundView)((Object)object);
        object.setLayoutDirection(this.getContext().getResources().getConfiguration().getLayoutDirection());
        ((DynamicIslandBackgroundView)((Object)object)).setController(this.getViewComponent().getBackgroundViewControllerFactory().create((DynamicIslandBackgroundView)((Object)object)));
        DynamicIslandContentView dynamicIslandContentView = (DynamicIslandContentView)object.requireViewById(R.id.island_content);
        dynamicIslandContentView.setBackgroundView((DynamicIslandBackgroundView)((Object)object));
        kotlin.jvm.internal.o.d((Object)((Object)dynamicIslandContentView));
        return dynamicIslandContentView;
    }

    private final DynamicIslandContentFakeView inflateDynamicIslandFakeContentView(DynamicIslandData object) {
        if (!DynamicIslandAnimUtils.INSTANCE.featureDynamicIslandNoNeedFakeView() && object.getView() != null) {
            boolean bl = (object = object.getExtras()) != null ? object.getBoolean("miui.focus.isPromoted", false) : false;
            object = LayoutInflater.from((Context)this.getContext()).inflate(R.layout.dynamic_island_fake_content_view, (ViewGroup)this, false);
            kotlin.jvm.internal.o.e((Object)object, (String)"null cannot be cast to non-null type miui.systemui.dynamicisland.window.content.DynamicIslandContentFakeView");
            object = (DynamicIslandContentFakeView)((Object)object);
            ((DynamicIslandContentFakeView)((Object)object)).updateLiveUpdateExpandedView(bl);
            return object;
        }
        return null;
    }

    private final void initEventCoordinator() {
        this.eventCoordinator = this.getViewComponent().getDynamicIslandEventCoordinator();
        f.b((f1.E)LifecycleOwnerKt.getLifecycleScope((LifecycleOwner)this), null, null, (U0.o)new U0.o(this, null){
            int label;
            final DynamicIslandWindowView this$0;
            {
                this.this$0 = dynamicIslandWindowView;
                super(2, d2);
            }

            public final d create(Object object, d d2) {
                return new /* invalid duplicate definition of identical inner class */;
            }

            public final Object invoke(f1.E e2, d d2) {
                return (this.create(e2, d2)).invokeSuspend(s.a);
            }

            /*
             * Enabled force condition propagation
             * Lifted jumps to return sites
             */
            public final Object invokeSuspend(Object object) {
                Object object2 = L0.c.c();
                int n2 = this.label;
                if (n2 != 0) {
                    if (n2 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    G0.k.b((Object)object);
                    throw new G0.c();
                } else {
                    I i2;
                    G0.k.b((Object)object);
                    object = this.this$0.getEventCoordinator();
                    if (object == null || (i2 = ((DynamicIslandEventCoordinator)object).getIslandRegion()) == null) return s.a;
                    object = new g(this.this$0){
                        final DynamicIslandWindowView this$0;
                        {
                            this.this$0 = dynamicIslandWindowView;
                        }

                        public final Object emit(Region region, d object) {
                            boolean bl = this.this$0.getWindowViewController().getWindowState().isToScreenLockNoAnimation();
                            object = new StringBuilder();
                            ((StringBuilder)object).append("islandRegion ");
                            ((StringBuilder)object).append(region);
                            ((StringBuilder)object).append(" ");
                            ((StringBuilder)object).append(bl);
                            Log.e((String)"DynamicIslandWindowViewImpl", (String)((StringBuilder)object).toString());
                            object = new Bundle();
                            object.putString("action_key", "action_back_island_width_changed");
                            object.putBoolean("extra_back_change_island_region_no_anim", bl);
                            object.putParcelable("extra_back_island_region", (Parcelable)region);
                            region = DynamicIslandWindowView.access$getListener$p(this.this$0);
                            if (region != null) {
                                region.onIslandViewChanged((Bundle)object);
                            }
                            return s.a;
                        }
                    };
                    this.label = 1;
                    if (i2.collect((g)object, (d)this) != object2) throw new G0.c();
                    return object2;
                }
            }
        }, (int)3, null);
        f.b((f1.E)LifecycleOwnerKt.getLifecycleScope((LifecycleOwner)this), null, null, (U0.o)new U0.o(this, null){
            int label;
            final DynamicIslandWindowView this$0;
            {
                this.this$0 = dynamicIslandWindowView;
                super(2, d2);
            }

            public final d create(Object object, d d2) {
                return new /* invalid duplicate definition of identical inner class */;
            }

            public final Object invoke(f1.E e2, d d2) {
                return (this.create(e2, d2)).invokeSuspend(s.a);
            }

            /*
             * Enabled force condition propagation
             * Lifted jumps to return sites
             */
            public final Object invokeSuspend(Object object) {
                Object object2 = L0.c.c();
                int n2 = this.label;
                if (n2 != 0) {
                    if (n2 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    G0.k.b((Object)object);
                    throw new G0.c();
                } else {
                    G0.k.b((Object)object);
                    object = this.this$0.getEventCoordinator();
                    if (object == null || (object = ((DynamicIslandEventCoordinator)object).getBigIslandRegion()) == null) return s.a;
                    initEventCoordinator.1<T> var4_4 = initEventCoordinator.1.INSTANCE;
                    this.label = 1;
                    if (object.collect(var4_4, (d)this) != object2) throw new G0.c();
                    return object2;
                }
            }
        }, (int)3, null);
        f.b((f1.E)LifecycleOwnerKt.getLifecycleScope((LifecycleOwner)this), null, null, (U0.o)new U0.o(this, null){
            int label;
            final DynamicIslandWindowView this$0;
            {
                this.this$0 = dynamicIslandWindowView;
                super(2, d2);
            }

            public final d create(Object object, d d2) {
                return new /* invalid duplicate definition of identical inner class */;
            }

            public final Object invoke(f1.E e2, d d2) {
                return (this.create(e2, d2)).invokeSuspend(s.a);
            }

            /*
             * Enabled force condition propagation
             * Lifted jumps to return sites
             */
            public final Object invokeSuspend(Object object) {
                Object object2 = L0.c.c();
                int n2 = this.label;
                if (n2 != 0) {
                    if (n2 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    G0.k.b((Object)object);
                    throw new G0.c();
                } else {
                    I i2;
                    G0.k.b((Object)object);
                    object = this.this$0.getEventCoordinator();
                    if (object == null || (i2 = ((DynamicIslandEventCoordinator)object).getExpandedViewRegion()) == null) return s.a;
                    object = new g(this.this$0){
                        final DynamicIslandWindowView this$0;
                        {
                            this.this$0 = dynamicIslandWindowView;
                        }

                        public final Object emit(Region region, d object) {
                            object = new StringBuilder();
                            ((StringBuilder)object).append("expandedViewRegion ");
                            ((StringBuilder)object).append(region);
                            Log.e((String)"DynamicIslandWindowViewImpl", (String)((StringBuilder)object).toString());
                            object = this.this$0.getEventCoordinator();
                            if (object != null) {
                                ((DynamicIslandEventCoordinator)object).handleExpandGestureListener(region);
                            }
                            return s.a;
                        }
                    };
                    this.label = 1;
                    if (i2.collect((g)object, (d)this) != object2) throw new G0.c();
                    return object2;
                }
            }
        }, (int)3, null);
        f.b((f1.E)LifecycleOwnerKt.getLifecycleScope((LifecycleOwner)this), null, null, (U0.o)new U0.o(this, null){
            int label;
            final DynamicIslandWindowView this$0;
            {
                this.this$0 = dynamicIslandWindowView;
                super(2, d2);
            }

            public final d create(Object object, d d2) {
                return new /* invalid duplicate definition of identical inner class */;
            }

            public final Object invoke(f1.E e2, d d2) {
                return (this.create(e2, d2)).invokeSuspend(s.a);
            }

            /*
             * Enabled force condition propagation
             * Lifted jumps to return sites
             */
            public final Object invokeSuspend(Object object) {
                Object object2 = L0.c.c();
                int n2 = this.label;
                if (n2 != 0) {
                    if (n2 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    G0.k.b((Object)object);
                    throw new G0.c();
                } else {
                    G0.k.b((Object)object);
                    object = this.this$0.getEventCoordinator();
                    if (object == null || (object = ((DynamicIslandEventCoordinator)object).getStatusBarVisible()) == null) return s.a;
                    g g2 = new g(this.this$0){
                        final DynamicIslandWindowView this$0;
                        {
                            this.this$0 = dynamicIslandWindowView;
                        }

                        public final Object emit(Boolean object, d object2) {
                            object2 = this.this$0.getEventCoordinator();
                            if (object2 != null) {
                                ((DynamicIslandEventCoordinator)object2).updateTouchRegion();
                            }
                            if (kotlin.jvm.internal.o.c((Object)object, (Object)b.a((boolean)false)) && this.this$0.getCurrentExpandedState() == null && (object = this.this$0.getEventCoordinator()) != null) {
                                ((DynamicIslandEventCoordinator)object).resetSwipe(0.0f, 0.0f);
                            }
                            return s.a;
                        }
                    };
                    this.label = 1;
                    if (object.collect(g2, (d)this) != object2) throw new G0.c();
                    return object2;
                }
            }
        }, (int)3, null);
        f.b((f1.E)LifecycleOwnerKt.getLifecycleScope((LifecycleOwner)this), null, null, (U0.o)new U0.o(this, null){
            int label;
            final DynamicIslandWindowView this$0;
            {
                this.this$0 = dynamicIslandWindowView;
                super(2, d2);
            }

            public final d create(Object object, d d2) {
                return new /* invalid duplicate definition of identical inner class */;
            }

            public final Object invoke(f1.E e2, d d2) {
                return (this.create(e2, d2)).invokeSuspend(s.a);
            }

            /*
             * Enabled force condition propagation
             * Lifted jumps to return sites
             */
            public final Object invokeSuspend(Object g2) {
                Object object = L0.c.c();
                int n2 = this.label;
                if (n2 != 0) {
                    if (n2 != 1) throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    G0.k.b((Object)g2);
                    return s.a;
                } else {
                    G0.k.b((Object)g2);
                    i1.f f2 = new i1.f(new i1.f[]{this.this$0.getWindowViewController().getWindowState().getNotificationAppearance(), this.this$0.getWindowViewController().getWindowState().getStatusBarDisappearance(), this.this$0.getWindowViewController().getWindowState().getShowNotificationIcons(), this.this$0.getWindowViewController().getWindowState().getBouncerShowing(), this.this$0.getWindowViewController().getWindowState().getControlCenterExpanded(), this.this$0.getWindowViewController().getWindowState().getScreenPinning(), this.this$0.getWindowViewController().getWindowState().getMiPlayShow(), this.this$0.getWindowViewController().getWindowState().isSuperSaveMode()}){
                        final i1.f[] $flows$inlined;
                        {
                            this.$flows$inlined = fArray;
                        }

                        public Object collect(g object, d d2) {
                            i1.f[] fArray = this.$flows$inlined;
                            if ((object = k.a((g)object, (i1.f[])fArray, (U0.a)new U0.a(fArray){
                                final i1.f[] $flows;
                                {
                                    this.$flows = fArray;
                                }

                                public final Boolean[] invoke() {
                                    return new Boolean[this.$flows.length];
                                }
                            }, (U0.p)new U0.p(null){
                                private Object L$0;
                                Object L$1;
                                int label;

                                /*
                                 * Ignored method signature, as it can't be verified against descriptor
                                 */
                                public final Object invoke(g g2, Object[] objectArray, d object) {
                                    object = new /* invalid duplicate definition of identical inner class */;
                                    object.L$0 = g2;
                                    object.L$1 = objectArray;
                                    return object.invokeSuspend(s.a);
                                }

                                /*
                                 * Enabled force condition propagation
                                 * Lifted jumps to return sites
                                 */
                                public final Object invokeSuspend(Object object) {
                                    Object object2 = L0.c.c();
                                    int n2 = this.label;
                                    if (n2 != 0) {
                                        if (n2 != 1) throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                        G0.k.b((Object)object);
                                        return s.a;
                                    } else {
                                        G0.k.b((Object)object);
                                        object = (g)this.L$0;
                                        Boolean[] booleanArray = (Boolean[])((Object[])this.L$1);
                                        boolean bl = false;
                                        boolean bl2 = booleanArray[0];
                                        boolean bl3 = booleanArray[1];
                                        boolean bl4 = booleanArray[2];
                                        boolean bl5 = booleanArray[3];
                                        boolean bl6 = booleanArray[4];
                                        boolean bl7 = booleanArray[5];
                                        boolean bl8 = booleanArray[6];
                                        boolean bl9 = booleanArray[7];
                                        if (bl2 || bl6 || bl3 || bl4 || bl5 || bl7 || bl8 || bl9) {
                                            bl = true;
                                        }
                                        Boolean bl10 = b.a((boolean)bl);
                                        this.label = 1;
                                        if (object.emit((Object)bl10, (d)this) != object2) return s.a;
                                        return object2;
                                    }
                                }
                            }, (d)d2)) == L0.c.c()) {
                                return object;
                            }
                            return s.a;
                        }
                    };
                    g2 = new g(this.this$0){
                        final DynamicIslandWindowView this$0;
                        {
                            this.this$0 = dynamicIslandWindowView;
                        }

                        public final Object emit(boolean bl, d object) {
                            object = this.this$0.getEventCoordinator();
                            if (object != null) {
                                ((DynamicIslandEventCoordinator)object).updateTouchRegion();
                            }
                            return s.a;
                        }
                    };
                    this.label = 1;
                    if (f2.collect(g2, (d)this) != object) return s.a;
                    return object;
                }
            }
        }, (int)3, null);
    }

    private final boolean isBackgroundView(View view, Context context) {
        boolean bl;
        context = context.getResources();
        boolean bl2 = bl = false;
        if (context != null) {
            int n2 = context.getIdentifier("media_bg_view", "id", "com.android.systemui");
            bl2 = bl;
            if (view.getId() == n2) {
                bl2 = true;
            }
        }
        return bl2;
    }

    private final boolean isDisableShare() {
        boolean bl = ((Boolean)this.getWindowViewController().getWindowState().getControlCenterExpanded().getValue()).booleanValue() || this.currentKeyguardShowing;
        return bl;
    }

    private final boolean isDownInMediaChildViews(Context context, float f2, float f3, View view) {
        Resources resources = context.getResources();
        if (resources != null) {
            if ((view = view.findViewById(resources.getIdentifier("mi_media_controls", "id", "com.android.systemui"))) == null) {
                return false;
            }
            if (view instanceof ViewGroup) {
                view = (ViewGroup)view;
                int n2 = view.getChildCount();
                for (int j = 0; j < n2; ++j) {
                    resources = view.getChildAt(j);
                    kotlin.jvm.internal.o.d((Object)resources);
                    if (this.isBackgroundView((View)resources, context) || !this.isPointInView(f2, f3, (View)resources)) continue;
                    return true;
                }
            }
        }
        return false;
    }

    private final boolean isDownInSeekBar(Context context, float f2, float f3, View view) {
        if ((context = context.getResources()) != null) {
            if ((context = view.findViewById(context.getIdentifier("media_progress_bar", "id", "com.android.systemui"))) == null) {
                return false;
            }
            return this.isPointInView(f2, f3, (View)context);
        }
        return false;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private final boolean isPointInView(float f2, float f3, View view) {
        boolean bl;
        Rect rect;
        boolean bl2 = false;
        try {
            rect = new Rect();
            bl = bl2;
        }
        catch (Exception exception) {
            return bl2;
        }
        if (!view.getGlobalVisibleRect(rect)) return bl;
        bl = bl2;
        if (!(f2 >= (float)rect.left)) return bl;
        bl = bl2;
        if (!(f2 <= (float)rect.right)) return bl;
        bl = bl2;
        if (!(f3 >= (float)rect.top)) return bl;
        int n2 = rect.bottom;
        bl = bl2;
        if (!(f3 <= (float)n2)) return bl;
        return true;
    }

    private final boolean isTinyScreen() {
        return this.getWindowViewController().getWindowState().isTinyScreen();
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private final boolean isTouchInView(View view, int n2, float f2, float f3) {
        boolean bl;
        Rect rect;
        boolean bl2 = false;
        if (view == null) {
            return false;
        }
        if ((view = view.findViewById(n2)) == null) {
            return false;
        }
        try {
            rect = new Rect();
            bl = bl2;
        }
        catch (Exception exception) {
            return bl2;
        }
        if (!view.getGlobalVisibleRect(rect)) return bl;
        bl = bl2;
        if (!(f2 >= (float)rect.left)) return bl;
        bl = bl2;
        if (!(f2 <= (float)rect.right)) return bl;
        bl = bl2;
        if (!(f3 >= (float)rect.top)) return bl;
        n2 = rect.bottom;
        bl = bl2;
        if (!(f3 <= (float)n2)) return bl;
        return true;
    }

    private final boolean isTouchInsideRect(float f2, float f3, Rect rect) {
        boolean bl = false;
        if (rect == null) {
            return false;
        }
        boolean bl2 = bl;
        if (f2 >= (float)rect.left) {
            bl2 = bl;
            if (f2 <= (float)rect.right) {
                bl2 = bl;
                if (f3 >= (float)rect.top) {
                    bl2 = bl;
                    if (f3 <= (float)rect.bottom) {
                        bl2 = true;
                    }
                }
            }
        }
        return bl2;
    }

    private static final void maybeCollapseExpand$lambda$12(DynamicIslandWindowView dynamicIslandWindowView) {
        kotlin.jvm.internal.o.g((Object)((Object)dynamicIslandWindowView), (String)"this$0");
        dynamicIslandWindowView.collapse("input monitor");
    }

    private final void measureExpandedViewHeight(DynamicIslandBaseContentView dynamicIslandBaseContentView) {
        Object object = DynamicIslandUtils.INSTANCE;
        Object object2 = this.getContext();
        kotlin.jvm.internal.o.f((Object)object2, (String)"getContext(...)");
        int n2 = View.MeasureSpec.makeMeasureSpec((int)object.getScreenWidthOld((Context)object2), (int)Integer.MIN_VALUE);
        object2 = this.getContext();
        kotlin.jvm.internal.o.f((Object)object2, (String)"getContext(...)");
        int n3 = View.MeasureSpec.makeMeasureSpec((int)object.getScreenHeightOld((Context)object2), (int)Integer.MIN_VALUE);
        object = dynamicIslandBaseContentView.getExpandedView();
        if (object != null) {
            object.measure(n2, n3);
        }
        object = dynamicIslandBaseContentView.getExpandedView();
        Object var8_6 = null;
        object = object != null ? Integer.valueOf(object.getWidth()) : null;
        object2 = dynamicIslandBaseContentView.getExpandedView();
        object2 = object2 != null ? Integer.valueOf(object2.getHeight()) : null;
        Object object3 = dynamicIslandBaseContentView.getExpandedView();
        object3 = object3 != null ? Integer.valueOf(object3.getMeasuredWidth()) : null;
        Object object4 = dynamicIslandBaseContentView.getExpandedView();
        object4 = object4 != null ? Integer.valueOf(object4.getMeasuredHeight()) : null;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("expanded");
        stringBuilder.append(object);
        stringBuilder.append(", ");
        stringBuilder.append(object2);
        stringBuilder.append(",");
        stringBuilder.append(object3);
        stringBuilder.append(", ");
        stringBuilder.append(object4);
        Log.e((String)TAG, (String)stringBuilder.toString());
        object = dynamicIslandBaseContentView.getCurrentIslandData();
        object = object != null ? object.getView() : null;
        if (object != null) {
            object2 = dynamicIslandBaseContentView.getCurrentIslandData();
            object3 = dynamicIslandBaseContentView.getExpandedView();
            object = var8_6;
            if (object3 != null) {
                object = object3.getMeasuredHeight();
            }
            this.updateExpandedView(dynamicIslandBaseContentView, (DynamicIslandData)object2, (Integer)object);
        }
    }

    private final void onDeviceNotificationChanged(boolean bl) {
        Bundle bundle = new Bundle();
        bundle.putString("action_key", "action_island_device_notification_changed");
        bundle.putBoolean("extra_device_notification_add", bl);
        DynamicIslandEventCoordinator dynamicIslandEventCoordinator = this.eventCoordinator;
        if (dynamicIslandEventCoordinator != null && (dynamicIslandEventCoordinator = dynamicIslandEventCoordinator.getDynamicIslandViewChangedListener()) != null) {
            dynamicIslandEventCoordinator.onIslandViewChanged(bundle);
        }
    }

    private final void onDynamicIslandDataChanged() {
        Bundle bundle = new Bundle();
        bundle.putString("action_key", "action_island_data_changed");
        bundle.putInt("extra_data_size", this.contentViewList.size());
        DynamicIslandEventCoordinator dynamicIslandEventCoordinator = this.eventCoordinator;
        if (dynamicIslandEventCoordinator != null && (dynamicIslandEventCoordinator = dynamicIslandEventCoordinator.getDynamicIslandViewChangedListener()) != null) {
            dynamicIslandEventCoordinator.onIslandViewChanged(bundle);
        }
    }

    private static final void onGlobalLayoutListener$lambda$2(DynamicIslandWindowView dynamicIslandWindowView) {
        kotlin.jvm.internal.o.g((Object)((Object)dynamicIslandWindowView), (String)"this$0");
        dynamicIslandWindowView.getWindowViewController().setCurrentHeight(dynamicIslandWindowView.getHeight());
    }

    private static final void onLongPress$lambda$36(DynamicIslandBaseContentView dynamicIslandBaseContentView, DynamicIslandContentView dynamicIslandContentView, float f2) {
        kotlin.jvm.internal.o.g((Object)((Object)dynamicIslandBaseContentView), (String)"$view");
        DynamicIslandBaseContentViewController<?> dynamicIslandBaseContentViewController = dynamicIslandBaseContentView.get_controller();
        if (dynamicIslandBaseContentViewController != null) {
            dynamicIslandContentView = dynamicIslandContentView != null ? dynamicIslandContentView.getCurrentIslandData() : null;
            dynamicIslandBaseContentViewController.onLongPressed(dynamicIslandBaseContentView, (DynamicIslandData)dynamicIslandContentView, f2);
        }
    }

    private final void releaseMutexIfIdle(String string, a a2) {
        if (a.a.a((a)a2, null, (int)1, null)) {
            Log.d((String)TAG, (String)"releaseMutexIfIdle");
            E.d(this.keyLocks).remove(string);
            a.a.b((a)a2, null, (int)1, null);
        }
    }

    public static /* synthetic */ void removeDynamicIslandData$default(DynamicIslandWindowView dynamicIslandWindowView, DynamicIslandData dynamicIslandData, boolean bl, boolean bl2, int n, Object object) {
        if ((n & 2) != 0) {
            bl = false;
        }
        if ((n & 4) != 0) {
            bl2 = true;
        }
        dynamicIslandWindowView.removeDynamicIslandData(dynamicIslandData, bl, bl2);
    }

    private final Object removeDynamicIslandDataSuspend(String string, boolean bl, boolean bl2, boolean bl3, d object) {
        object = new StringBuilder();
        object.append("removeDynamicIslandData: begin ");
        object.append(string);
        object.append(" ");
        object.append(bl3);
        Log.d((String)TAG, (String)object.toString());
        DynamicIslandContentView dynamicIslandContentView = this.getViewFromList(string);
        if (dynamicIslandContentView != null) {
            object = new StringBuilder();
            object.append("has key ");
            object.append(string);
            Log.d((String)TAG, (String)object.toString());
            object = dynamicIslandContentView.getState();
            if (object != null) {
                object.setDeleteNoAnimation(bl2);
            }
            object = dynamicIslandContentView.getBigIslandView();
            if (object != null) {
                object.suppressAdaptiveGlowViewSize$miui_dynamicisland_release();
            }
            if ((object = this.eventCoordinator) != null) {
                object.dispatchEvent(DynamicIslandEvent.DeletedDynamicIsland.INSTANCE, dynamicIslandContentView);
            }
            object = this.isMediaApp(dynamicIslandContentView.getCurrentIslandData()) && !bl2 && dynamicIslandContentView.getState() instanceof DynamicIslandState.Deleted && dynamicIslandContentView.getLastState() instanceof DynamicIslandState.Expanded ? dynamicIslandContentView : null;
            this.pendingMediaView = object;
            this.clearAfterDelete(dynamicIslandContentView.getCurrentIslandData(), string, bl);
            object = s.a;
        } else {
            object = null;
        }
        if (object == null) {
            this.clearAfterDelete(null, string, bl);
        }
        return s.a;
    }

    public static /* synthetic */ Object removeDynamicIslandDataSuspend$default(DynamicIslandWindowView dynamicIslandWindowView, String string, boolean bl, boolean bl2, boolean bl3, d d2, int n, Object object) {
        block2: {
            if ((n & 2) != 0) {
                bl = true;
            }
            if ((n & 4) != 0) {
                bl2 = false;
            }
            if ((n & 8) == 0) break block2;
            bl3 = false;
        }
        return dynamicIslandWindowView.removeDynamicIslandDataSuspend(string, bl, bl2, bl3, d2);
    }

    private final void removeTempShowBigIslandOnFlipTinyChanged() {
        if (!CommonUtils.isFlipDevice()) {
            return;
        }
        if (this.getWindowViewController().getWindowState().isTinyScreen() != this.getWindowViewController().getWindowState().getLastTinyScreenStatus() || this.getWindowViewController().getLastDisplayOrientation() != this.getWindowViewController().getDisplayOrientation()) {
            this.isTempShowBigIslandToBeRemoved();
        }
    }

    private final Float requestCutoutHeight() {
        Bundle bundle = new Bundle();
        bundle.putString("action_key", "action_back_request_cutout_height");
        Object object = this.listener;
        object = object != null ? object.onIslandViewChanged(bundle) : null;
        if (object != null) {
            float f2 = object.getFloat("extra_back_request_cutout_height");
            object = new StringBuilder();
            ((StringBuilder)object).append("requestCutoutHeight ");
            ((StringBuilder)object).append(f2);
            Log.e((String)TAG, (String)((StringBuilder)object).toString());
            return Float.valueOf(f2);
        }
        return null;
    }

    private final Float requestCutoutY() {
        Object object = new Bundle();
        object.putString("action_key", "action_back_request_cutout_y");
        float f2 = this.getContext().getResources().getDimension(R.dimen.island_height);
        DynamicIslandContent.DynamicIslandViewChangedListener dynamicIslandViewChangedListener = this.listener;
        object = dynamicIslandViewChangedListener != null ? dynamicIslandViewChangedListener.onIslandViewChanged((Bundle)object) : null;
        if (object != null) {
            float f3;
            float f4 = f3 = object.getFloat("extra_back_request_cutout_y");
            if (FlipUtils.isFlipTiny()) {
                f4 = f3 + (float)DynamicIslandUtils.INSTANCE.getTinyScreenInsetTop();
            }
            object = new StringBuilder();
            ((StringBuilder)object).append("requestCutoutY ");
            ((StringBuilder)object).append(f4);
            Log.e((String)TAG, (String)((StringBuilder)object).toString());
            object = this.getWindowViewController().isNotchScreenDevice() ? Float.valueOf(f2 / (float)2) : Float.valueOf(f4);
            return object;
        }
        return null;
    }

    private final void requestImmersiveMode() {
        Object object = new Bundle();
        object.putString("action_key", "action_back_request_immersive_mode");
        DynamicIslandContent.DynamicIslandViewChangedListener dynamicIslandViewChangedListener = this.listener;
        object = dynamicIslandViewChangedListener != null ? dynamicIslandViewChangedListener.onIslandViewChanged((Bundle)object) : null;
        if (object != null) {
            boolean bl = object.getBoolean("extra_back_request_immersive_mode");
            object = new StringBuilder();
            ((StringBuilder)object).append("requestImmersiveMode ");
            ((StringBuilder)object).append(bl);
            Log.e((String)TAG, (String)((StringBuilder)object).toString());
        }
    }

    private final Float requestMaxIslandWidth() {
        Object object = new Bundle();
        object.putString("action_key", "action_back_request_max_width");
        DynamicIslandContent.DynamicIslandViewChangedListener dynamicIslandViewChangedListener = this.listener;
        object = dynamicIslandViewChangedListener != null ? dynamicIslandViewChangedListener.onIslandViewChanged((Bundle)object) : null;
        if (object != null) {
            float f2 = object.getFloat("extra_island_max_width");
            object = new StringBuilder();
            ((StringBuilder)object).append("requestMaxIslandWidth ");
            ((StringBuilder)object).append(f2);
            Log.e((String)TAG, (String)((StringBuilder)object).toString());
            return Float.valueOf(f2);
        }
        return null;
    }

    private final void requestSystemUIFeature() {
        Bundle bundle = new Bundle();
        bundle.putString("action_key", "action_request_systemui_feature");
        Object object = this.listener;
        object = object != null ? object.onIslandViewChanged(bundle) : null;
        if (object != null) {
            int n2 = object.getInt("extra_support_miniwindow_end_position_changed");
            boolean bl = true;
            if (n2 != 1) {
                bl = false;
            }
            this.supportMiniWindowEndPositionChange = bl;
            object = new StringBuilder();
            ((StringBuilder)object).append("supportMiniWindowEndPositionChange: ");
            ((StringBuilder)object).append(bl);
            Log.d((String)TAG, (String)((StringBuilder)object).toString());
        }
    }

    private final String requestTopActivityPkgName() {
        Bundle bundle = new Bundle();
        bundle.putString("action_key", "action_request_top_activity_pkg_name");
        Object object = this.listener;
        String string = null;
        object = object != null ? object.onIslandViewChanged(bundle) : null;
        if (object != null) {
            string = object.getString("extra_top_activity_pkg_name");
        }
        return string;
    }

    private final void scheduleAddDynamicIslandPreDrawOperations(DynamicIslandContentView dynamicIslandContentView, DynamicIslandData dynamicIslandData) {
        if (!this.contentViewList.contains((Object)dynamicIslandContentView)) {
            return;
        }
        this.dispatchAddEvent(dynamicIslandContentView, dynamicIslandData);
    }

    private final void scheduleUpdateDynamicIslandPreDrawOperations(DynamicIslandContentView dynamicIslandContentView, DynamicIslandData dynamicIslandData, boolean bl, float f2, boolean bl2) {
        Object object;
        String string = dynamicIslandData.getKey();
        Object object2 = dynamicIslandData.getView();
        StringBuilder stringBuilder = null;
        object2 = object2 != null ? Integer.valueOf(object2.getWidth()) : null;
        Object object3 = dynamicIslandData.getView();
        object3 = object3 != null ? Integer.valueOf(object3.getHeight()) : null;
        object = dynamicIslandContentView != null && (object = dynamicIslandContentView.getExpandedView()) != null ? Integer.valueOf(object.getWidth()) : null;
        Comparable<StringBuilder> comparable = stringBuilder;
        if (dynamicIslandContentView != null) {
            DynamicIslandExpandedView dynamicIslandExpandedView = dynamicIslandContentView.getExpandedView();
            comparable = stringBuilder;
            if (dynamicIslandExpandedView != null) {
                comparable = dynamicIslandExpandedView.getMeasuredHeight();
            }
        }
        stringBuilder = new StringBuilder();
        stringBuilder.append("expanded ");
        stringBuilder.append(string);
        stringBuilder.append(object2);
        stringBuilder.append(", ");
        stringBuilder.append(object3);
        stringBuilder.append(", ");
        stringBuilder.append(object);
        stringBuilder.append(", ");
        stringBuilder.append(comparable);
        Log.e((String)TAG, (String)stringBuilder.toString());
        boolean bl3 = this.contentViewList.contains((Object)dynamicIslandContentView);
        object2 = new StringBuilder();
        ((StringBuilder)object2).append("updateDynamicIslandView contentViewList ");
        ((StringBuilder)object2).append(bl3);
        Log.e((String)TAG, (String)((StringBuilder)object2).toString());
        if (!this.contentViewList.contains((Object)dynamicIslandContentView)) {
            return;
        }
        this.dispatchUpdateEvent(dynamicIslandData, bl, f2, bl2);
    }

    private final void sendExitPendingIntent(Bundle bundle) {
        if (bundle != null && bundle.containsKey("miui.exitFloating")) {
            Log.e((String)TAG, (String)"sendExitPendingIntent: ");
            bundle = bundle.getParcelable("miui.exitFloating");
            if (bundle instanceof PendingIntent) {
                ((PendingIntent)bundle).send();
            }
        }
    }

    private final boolean shouldEnterAppOrMiniWindow(String string, DynamicIslandContentView dynamicIslandContentView, String string2, boolean bl) {
        if (kotlin.jvm.internal.o.c((Object)string2, (Object)string) && this.getWindowViewController().canEnterAppState(dynamicIslandContentView) && (!((Boolean)this.getWindowViewController().isFreeformAnimRunning().getValue()).booleanValue() || ((Boolean)this.getWindowViewController().isFreeformAnimRunning().getValue()).booleanValue() && this.hasSamePkgEnterFreeFrom(string2))) {
            if (kotlin.jvm.internal.o.c(this.getWindowViewController().getInSmallWindowMap().get(string), (Object)Boolean.TRUE)) {
                this.enterMiniWindow(dynamicIslandContentView);
                return true;
            }
            this.appEnter(dynamicIslandContentView);
            return true;
        }
        if (bl && this.getWindowViewController().canEnterAppState(dynamicIslandContentView) && !((Boolean)this.getWindowViewController().isFreeformAnimRunning().getValue()).booleanValue()) {
            this.enterMiniWindow(dynamicIslandContentView);
            return true;
        }
        return false;
    }

    private final void updateBlurContainer(boolean bl) {
        MiBlurCompat.setMiBackgroundBlurModeCompat((View)this, (int)(bl ? 1 : 0));
        int n2 = bl ? 100 : 0;
        MiBlurCompat.setMiBackgroundBlurRadiusCompat((View)this, (int)n2);
        MiBlurCompat.setPassWindowBlurEnabledCompat((View)this, (boolean)bl);
    }

    private final void updateDynamicIslandDataList(DynamicIslandData dynamicIslandData) {
        boolean bl;
        Object object;
        block2: {
            object = this.dynamicIslandDataList.iterator();
            while (object.hasNext()) {
                if (!kotlin.jvm.internal.o.c((Object)object.next().getKey(), (Object)dynamicIslandData.getKey())) continue;
                object.remove();
                bl = true;
                break block2;
            }
            bl = false;
        }
        object = dynamicIslandData.getKey();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("updateDynamicIslandDataList: ");
        stringBuilder.append((String)object);
        stringBuilder.append("   ");
        stringBuilder.append(bl);
        Log.e((String)TAG, (String)stringBuilder.toString());
        if (bl) {
            this.dynamicIslandDataList.add(dynamicIslandData);
        }
        this.onDeviceNotificationChanged(this.hasDeviceNotification());
    }

    public static /* synthetic */ void updateDynamicIslandView$default(DynamicIslandWindowView dynamicIslandWindowView, DynamicIslandData dynamicIslandData, boolean bl, float f, boolean bl2, int n, Object object) {
        if ((n & 8) != 0) {
            bl2 = false;
        }
        dynamicIslandWindowView.updateDynamicIslandView(dynamicIslandData, bl, f, bl2);
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    private final Object updateDynamicIslandViewSuspend(DynamicIslandData var1_1, boolean var2_2, float var3_3, boolean var4_4, boolean var5_5, d var6_6) {
        block32: {
            block25: {
                block31: {
                    block26: {
                        block27: {
                            block28: {
                                block30: {
                                    block29: {
                                        var9_7 = var1_1 /* !! */ ;
                                        if (!(var6_6 /* !! */  instanceof updateDynamicIslandViewSuspend.1)) ** GOTO lbl-1000
                                        var12_8 = var6_6 /* !! */ ;
                                        var8_9 = var12_8.label;
                                        if ((var8_9 & -2147483648) != 0) {
                                            var12_8.label = var8_9 + -2147483648;
                                        } else lbl-1000:
                                        // 2 sources

                                        {
                                            var12_8 = new M0.d(this, var6_6 /* !! */ ){
                                                float F$0;
                                                Object L$0;
                                                Object L$1;
                                                Object L$2;
                                                Object L$3;
                                                boolean Z$0;
                                                boolean Z$1;
                                                int label;
                                                Object result;
                                                final DynamicIslandWindowView this$0;
                                                {
                                                    this.this$0 = dynamicIslandWindowView;
                                                    super(d2);
                                                }

                                                public final Object invokeSuspend(Object object) {
                                                    this.result = object;
                                                    this.label |= Integer.MIN_VALUE;
                                                    return DynamicIslandWindowView.access$updateDynamicIslandViewSuspend(this.this$0, null, false, 0.0f, false, false, (d)this);
                                                }
                                            };
                                        }
                                        var6_6 /* !! */  = var12_8.result;
                                        var15_10 = L0.c.c();
                                        switch (var12_8.label) {
                                            default: {
                                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                            }
                                            case 6: {
                                                var2_2 = var12_8.Z$1;
                                                var3_3 = var12_8.F$0;
                                                var4_4 = var12_8.Z$0;
                                                var1_1 /* !! */  = (DynamicIslandContentView)var12_8.L$2;
                                                var9_7 = (DynamicIslandData)var12_8.L$1;
                                                var11_11 = (DynamicIslandWindowView)var12_8.L$0;
                                                G0.k.b((Object)var6_6 /* !! */ );
                                                var10_13 /* !! */  = var6_6 /* !! */ ;
                                                var6_6 /* !! */  = var11_11;
                                                break block25;
                                            }
                                            case 5: {
                                                var2_2 = var12_8.Z$1;
                                                var3_3 = var12_8.F$0;
                                                var4_4 = var12_8.Z$0;
                                                var13_14 /* !! */  = (DynamicIslandContentFakeView)var12_8.L$3;
                                                var9_7 = (DynamicIslandContentView)var12_8.L$2;
                                                var11_12 /* !! */  = (DynamicIslandData)var12_8.L$1;
                                                var10_13 /* !! */  = (DynamicIslandWindowView)var12_8.L$0;
                                                G0.k.b((Object)var6_6 /* !! */ );
                                                break block26;
                                            }
                                            case 4: {
                                                var2_2 = var12_8.Z$1;
                                                var3_3 = var12_8.F$0;
                                                var4_4 = var12_8.Z$0;
                                                var9_7 = (DynamicIslandContentView)var12_8.L$2;
                                                var1_1 /* !! */  = (DynamicIslandData)var12_8.L$1;
                                                var10_13 /* !! */  = (DynamicIslandWindowView)var12_8.L$0;
                                                G0.k.b((Object)var6_6 /* !! */ );
                                                var11_12 /* !! */  = var6_6 /* !! */ ;
                                                var6_6 /* !! */  = var10_13 /* !! */ ;
                                                break block27;
                                            }
                                            case 3: {
                                                var2_2 = var12_8.Z$1;
                                                var3_3 = var12_8.F$0;
                                                var4_4 = var12_8.Z$0;
                                                var1_1 /* !! */  = (DynamicIslandContentView)var12_8.L$2;
                                                var9_7 = (DynamicIslandData)var12_8.L$1;
                                                var10_13 /* !! */  = (DynamicIslandWindowView)var12_8.L$0;
                                                G0.k.b((Object)var6_6 /* !! */ );
                                                var6_6 /* !! */  = var10_13 /* !! */ ;
                                                break block28;
                                            }
                                            case 2: {
                                                G0.k.b((Object)var6_6 /* !! */ );
                                                break block29;
                                            }
                                            case 1: {
                                                var2_2 = var12_8.Z$0;
                                                var9_7 = (DynamicIslandData)var12_8.L$1;
                                                var1_1 /* !! */  = (DynamicIslandWindowView)var12_8.L$0;
                                                G0.k.b((Object)var6_6 /* !! */ );
                                                var6_6 /* !! */  = var9_7;
                                                break;
                                            }
                                            case 0: {
                                                G0.k.b((Object)var6_6 /* !! */ );
                                                var10_13 /* !! */  = var1_1 /* !! */ .getKey();
                                                var6_6 /* !! */  = new StringBuilder();
                                                var6_6 /* !! */ .append("updateDynamicIslandView begin ");
                                                var6_6 /* !! */ .append(var10_13 /* !! */ );
                                                var6_6 /* !! */ .append(" ");
                                                var6_6 /* !! */ .append(var4_4);
                                                var6_6 /* !! */ .append(", reInflated=");
                                                var6_6 /* !! */ .append(var5_5);
                                                Log.e((String)"DynamicIslandWindowViewImpl", (String)var6_6 /* !! */ .toString());
                                                this.updateDynamicIslandDataList(var1_1 /* !! */ );
                                                if (!this.assertUserSpace(var1_1 /* !! */ )) {
                                                    return s.a;
                                                }
                                                var6_6 /* !! */  = var1_1 /* !! */ .getExtras();
                                                var6_6 /* !! */  = var6_6 /* !! */  != null ? var6_6 /* !! */ .getString("miui.pkg.name") : null;
                                                var11_12 /* !! */  = this.getViewFromList(var1_1 /* !! */ .getKey());
                                                var10_13 /* !! */  = var11_12 /* !! */  != null ? var11_12 /* !! */ .getState() : null;
                                                if (var10_13 /* !! */  == null) {
                                                    if (var11_12 /* !! */  != null) {
                                                        var1_1 /* !! */  = var11_12 /* !! */ .getCurrentIslandData();
                                                        var1_1 /* !! */  = var1_1 /* !! */  != null ? var1_1 /* !! */ .getKey() : null;
                                                        var12_8.L$0 = this;
                                                        var12_8.L$1 = var9_7;
                                                        var12_8.Z$0 = var2_2;
                                                        var12_8.label = 1;
                                                        if (DynamicIslandWindowView.removeDynamicIslandDataSuspend$default(this, (String)var1_1 /* !! */ , false, true, false, (d)var12_8, 8, null) == var15_10) {
                                                            return var15_10;
                                                        }
                                                    }
                                                    var1_1 /* !! */  = this;
                                                    var6_6 /* !! */  = var9_7;
                                                    break;
                                                }
                                                break block30;
                                            }
                                        }
                                        var3_3 = var1_1 /* !! */ .getWindowViewController().getIslandMaxWidth();
                                        var7_15 = var1_1 /* !! */ .getWindowViewController().getCutoutY();
                                        var12_8.L$0 = null;
                                        var12_8.L$1 = null;
                                        var12_8.label = 2;
                                        if (DynamicIslandWindowView.addDynamicIslandDataSuspend$default((DynamicIslandWindowView)var1_1 /* !! */ , (DynamicIslandData)var6_6 /* !! */ , var2_2, var3_3, var7_15, true, false, (d)var12_8, 32, null) == var15_10) {
                                            return var15_10;
                                        }
                                    }
                                    return s.a;
                                }
                                var10_13 /* !! */  = var1_1 /* !! */ .getExtras();
                                var10_13 /* !! */  = var10_13 /* !! */  != null ? b.c((int)var10_13 /* !! */ .getInt("miui.user.id")) : null;
                                var13_14 /* !! */  = var1_1 /* !! */ .getProperties();
                                this.notifyAddIsland((String)var6_6 /* !! */ , (Integer)var10_13 /* !! */ , var1_1 /* !! */ .getKey(), (Integer)var13_14 /* !! */ );
                                var4_4 = this.canUpdate((DynamicIslandContentView)var11_12 /* !! */ , var5_5);
                                var12_8.L$0 = this;
                                var12_8.L$1 = var9_7;
                                var12_8.L$2 = var11_12 /* !! */ ;
                                var12_8.Z$0 = var2_2;
                                var12_8.F$0 = var3_3;
                                var12_8.Z$1 = var5_5;
                                var12_8.label = 3;
                                if (var11_12 /* !! */ .updateView(var1_1 /* !! */ , true, var4_4, (d)var12_8) == var15_10) {
                                    return var15_10;
                                }
                                var1_1 /* !! */  = var11_12 /* !! */ ;
                                var6_6 /* !! */  = this;
                                var4_4 = var2_2;
                                var2_2 = var5_5;
                            }
                            if (var1_1 /* !! */ .getFakeView() != null) break block31;
                            var10_13 /* !! */  = var6_6 /* !! */ .getWindowViewController().getInflateContext();
                            var11_12 /* !! */  = new U0.o((DynamicIslandWindowView)var6_6 /* !! */ , (DynamicIslandData)var9_7, null){
                                final DynamicIslandData $dynamicIslandData;
                                int label;
                                final DynamicIslandWindowView this$0;
                                {
                                    this.this$0 = dynamicIslandWindowView;
                                    this.$dynamicIslandData = dynamicIslandData;
                                    super(2, d2);
                                }

                                public final d create(Object object, d d2) {
                                    return new /* invalid duplicate definition of identical inner class */;
                                }

                                public final Object invoke(f1.E e2, d d2) {
                                    return (this.create(e2, d2)).invokeSuspend(s.a);
                                }

                                public final Object invokeSuspend(Object object) {
                                    L0.c.c();
                                    if (this.label == 0) {
                                        G0.k.b((Object)object);
                                        return DynamicIslandWindowView.access$inflateDynamicIslandFakeContentView(this.this$0, this.$dynamicIslandData);
                                    }
                                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                }
                            };
                            var12_8.L$0 = var6_6 /* !! */ ;
                            var12_8.L$1 = var9_7;
                            var12_8.L$2 = var1_1 /* !! */ ;
                            var12_8.Z$0 = var4_4;
                            var12_8.F$0 = var3_3;
                            var12_8.Z$1 = var2_2;
                            var12_8.label = 4;
                            if ((var11_12 /* !! */  = f.c((K0.g)var10_13 /* !! */ , (U0.o)var11_12 /* !! */ , (d)var12_8)) == var15_10) {
                                return var15_10;
                            }
                            var10_13 /* !! */  = var1_1 /* !! */ ;
                            var1_1 /* !! */  = var9_7;
                            var9_7 = var10_13 /* !! */ ;
                        }
                        var14_16 = (DynamicIslandContentFakeView)var11_12 /* !! */ ;
                        var12_8.L$0 = var6_6 /* !! */ ;
                        var12_8.L$1 = var1_1 /* !! */ ;
                        var12_8.L$2 = var9_7;
                        var12_8.L$3 = var14_16;
                        var12_8.Z$0 = var4_4;
                        var12_8.F$0 = var3_3;
                        var12_8.Z$1 = var2_2;
                        var12_8.label = 5;
                        var13_14 /* !! */  = var14_16;
                        var11_12 /* !! */  = var1_1 /* !! */ ;
                        var10_13 /* !! */  = var6_6 /* !! */ ;
                        if (super.buildDynamicIslandFakeContentView(var14_16, var1_1 /* !! */ , (d)var12_8) == var15_10) {
                            return var15_10;
                        }
                    }
                    var9_7.setFakeView(var13_14 /* !! */ );
                    if (var13_14 /* !! */  != null) {
                        var13_14 /* !! */ .setRealView((DynamicIslandContentView)var9_7);
                    }
                    var1_1 /* !! */  = var9_7;
                    var9_7 = var11_12 /* !! */ ;
                    var6_6 /* !! */  = var10_13 /* !! */ ;
                    break block32;
                }
                var10_13 /* !! */  = var1_1 /* !! */ .getFakeView();
                if (var10_13 /* !! */  != null) {
                    var12_8.L$0 = var6_6 /* !! */ ;
                    var12_8.L$1 = var9_7;
                    var12_8.L$2 = var1_1 /* !! */ ;
                    var12_8.Z$0 = var4_4;
                    var12_8.F$0 = var3_3;
                    var12_8.Z$1 = var2_2;
                    var12_8.label = 6;
                    if ((var10_13 /* !! */  = DynamicIslandBaseContentView.updateView$default((DynamicIslandBaseContentView)var10_13 /* !! */ , (DynamicIslandData)var9_7, true, false, (d)var12_8, 4, null)) == var15_10) {
                        return var15_10;
                    } else {
                        ** GOTO lbl186
                    }
                }
                break block32;
            }
            var10_13 /* !! */  = (Boolean)var10_13 /* !! */ ;
        }
        super.handleContentViewUpdateOperate((DynamicIslandContentView)var1_1 /* !! */ , (DynamicIslandData)var9_7, var4_4, var3_3, var2_2);
        return s.a;
    }

    public static /* synthetic */ Object updateDynamicIslandViewSuspend$default(DynamicIslandWindowView dynamicIslandWindowView, DynamicIslandData dynamicIslandData, boolean bl, float f, boolean bl2, boolean bl3, d d2, int n, Object object) {
        block1: {
            if ((n & 8) != 0) {
                bl2 = false;
            }
            if ((n & 0x10) == 0) break block1;
            bl3 = false;
        }
        return dynamicIslandWindowView.updateDynamicIslandViewSuspend(dynamicIslandData, bl, f, bl2, bl3, d2);
    }

    private final void updateExpandedView(DynamicIslandBaseContentView dynamicIslandBaseContentView, DynamicIslandData dynamicIslandData, Integer object) {
        Object object2;
        int n2 = this.getContext().getResources().getDimensionPixelSize(R.dimen.expanded_min_height);
        Object var8_5 = null;
        object2 = dynamicIslandData != null && (object2 = dynamicIslandData.getView()) != null ? Integer.valueOf(object2.getHeight()) : null;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("height ");
        stringBuilder.append(object);
        stringBuilder.append(" ");
        stringBuilder.append(object2);
        stringBuilder.append(" ");
        stringBuilder.append(n2);
        Log.d((String)TAG, (String)stringBuilder.toString());
        int n3 = object != null ? object : (dynamicIslandData != null && (object = dynamicIslandData.getView()) != null ? object.getHeight() : 0);
        object = var8_5;
        if (dynamicIslandData != null) {
            object = dynamicIslandData.getView();
        }
        if (object != null) {
            if (this.isMediaApp(dynamicIslandData)) {
                if (dynamicIslandBaseContentView != null) {
                    dynamicIslandBaseContentView.updateExpandedSize(dynamicIslandBaseContentView.getExpandedViewMaxWidth(), dynamicIslandBaseContentView.getExpandedViewMaxHeight(), dynamicIslandData);
                }
            } else {
                int n4 = n3 > 0 ? n3 : n2;
                if (n4 < n2) {
                    if (dynamicIslandBaseContentView != null && (object = dynamicIslandBaseContentView.getExpandedView()) != null) {
                        dynamicIslandBaseContentView.updateExpandedSize(object.getMeasuredWidth(), n2, dynamicIslandData);
                    }
                } else if (dynamicIslandBaseContentView != null && (object = dynamicIslandBaseContentView.getExpandedView()) != null) {
                    dynamicIslandBaseContentView.updateExpandedSize(object.getMeasuredWidth(), n3, dynamicIslandData);
                }
            }
        }
    }

    public static /* synthetic */ void updateExpandedView$default(DynamicIslandWindowView dynamicIslandWindowView, DynamicIslandBaseContentView dynamicIslandBaseContentView, DynamicIslandData dynamicIslandData, Integer n, int n2, Object object) {
        if ((n2 & 4) != 0) {
            n = null;
        }
        dynamicIslandWindowView.updateExpandedView(dynamicIslandBaseContentView, dynamicIslandData, n);
    }

    public static /* synthetic */ void updateViewStateWhenCloseEnd$default(DynamicIslandWindowView dynamicIslandWindowView, DynamicIslandContentView dynamicIslandContentView, boolean bl, String string, int n, Object object) {
        if ((n & 4) != 0) {
            string = "";
        }
        dynamicIslandWindowView.updateViewStateWhenCloseEnd(dynamicIslandContentView, bl, string);
    }

    @SuppressLint(value={"ClickableViewAccessibility"})
    public final void addDynamicIslandData(DynamicIslandData dynamicIslandData, boolean bl, float f2, float f3, boolean bl2) {
        kotlin.jvm.internal.o.g((Object)dynamicIslandData, (String)"dynamicIslandData");
        String string = dynamicIslandData.getKey();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("addDynamicIslandData cutoutY=");
        stringBuilder.append(f3);
        stringBuilder.append(" ");
        stringBuilder.append(string);
        Log.d((String)TAG, (String)stringBuilder.toString());
        if (!this.assertUserSpace(dynamicIslandData)) {
            return;
        }
        if (dynamicIslandData.getKey() == null) {
            return;
        }
        f.b((f1.E)this.getWindowViewController().getUiScopeImmediate(), (K0.g)this.getWindowViewController().getUiImmediateContext(), null, (U0.o)new U0.o(this, dynamicIslandData, bl, f2, f3, bl2, null){
            final boolean $addToHistoryList;
            final float $cutoutY;
            final DynamicIslandData $dynamicIslandData;
            final boolean $expanded;
            final float $maxWidth;
            float F$0;
            float F$1;
            Object L$0;
            Object L$1;
            Object L$2;
            Object L$3;
            boolean Z$0;
            boolean Z$1;
            int label;
            final DynamicIslandWindowView this$0;
            {
                this.this$0 = dynamicIslandWindowView;
                this.$dynamicIslandData = dynamicIslandData;
                this.$expanded = bl;
                this.$maxWidth = f2;
                this.$cutoutY = f3;
                this.$addToHistoryList = bl2;
                super(2, d2);
            }

            public final d create(Object object, d d2) {
                return new /* invalid duplicate definition of identical inner class */;
            }

            public final Object invoke(f1.E e2, d d2) {
                return (this.create(e2, d2)).invokeSuspend(s.a);
            }

            /*
             * Unable to fully structure code
             * Enabled aggressive block sorting
             * Enabled unnecessary exception pruning
             * Enabled aggressive exception aggregation
             */
            public final Object invokeSuspend(Object var1_1) {
                block21: {
                    block22: {
                        block19: {
                            block20: {
                                var13_5 = L0.c.c();
                                var5_6 = this.label;
                                if (var5_6 != 0) {
                                    if (var5_6 != 1) {
                                        if (var5_6 != 2) {
                                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                        }
                                        var10_7 /* !! */  = (a)this.L$1;
                                        var11_9 /* !! */  = (a)this.L$0;
                                        var9_10 = var10_7 /* !! */ ;
                                        var8_13 /* !! */  = var11_9 /* !! */ ;
                                        G0.k.b((Object)var1_1);
                                        var1_1 = var11_9 /* !! */ ;
                                        break block19;
                                    }
                                    var7_14 = this.Z$1;
                                    var2_15 = this.F$1;
                                    var3_17 = this.F$0;
                                    var6_18 = this.Z$0;
                                    var10_7 /* !! */  = (DynamicIslandData)this.L$3;
                                    var11_9 /* !! */  = (DynamicIslandWindowView)this.L$2;
                                    var12_19 = (a)this.L$1;
                                    var9_10 = (a)this.L$0;
                                    var8_13 /* !! */  = var9_10;
                                    G0.k.b((Object)var1_1);
                                    var8_13 /* !! */  = var12_19;
                                    var1_1 = var9_10;
                                    var9_10 = var11_9 /* !! */ ;
                                    var4_20 = var2_15;
                                    break block20;
                                }
                                G0.k.b((Object)var1_1);
                                var10_7 /* !! */  = DynamicIslandWindowView.access$getKeyLocks$p(this.this$0);
                                var9_10 = this.$dynamicIslandData.getKey();
                                var8_13 /* !! */  = var10_7 /* !! */ .get(var9_10);
                                var1_1 = var8_13 /* !! */ ;
                                if (var8_13 /* !! */  == null && (var8_13 /* !! */  = var10_7 /* !! */ .putIfAbsent(var9_10, var1_1 = c.b((boolean)false, (int)1, null))) != null) {
                                    var1_1 = var8_13 /* !! */ ;
                                }
                                var1_1 = (a)var1_1;
                                var8_13 /* !! */  = var1_1;
                                try {
                                    kotlin.jvm.internal.o.d((Object)var1_1);
                                    var8_13 /* !! */  = var1_1;
                                    var9_10 = this.this$0;
                                    var8_13 /* !! */  = var1_1;
                                    var10_7 /* !! */  = this.$dynamicIslandData;
                                    var8_13 /* !! */  = var1_1;
                                    var6_18 = this.$expanded;
                                    var8_13 /* !! */  = var1_1;
                                    var2_16 = this.$maxWidth;
                                    var8_13 /* !! */  = var1_1;
                                    var4_20 = this.$cutoutY;
                                    var8_13 /* !! */  = var1_1;
                                    var7_14 = this.$addToHistoryList;
                                    var8_13 /* !! */  = var1_1;
                                    this.L$0 = var1_1;
                                    var8_13 /* !! */  = var1_1;
                                    this.L$1 = var1_1;
                                    var8_13 /* !! */  = var1_1;
                                    this.L$2 = var9_10;
                                    var8_13 /* !! */  = var1_1;
                                    this.L$3 = var10_7 /* !! */ ;
                                    var8_13 /* !! */  = var1_1;
                                    this.Z$0 = var6_18;
                                    var8_13 /* !! */  = var1_1;
                                    this.F$0 = var2_16;
                                    var8_13 /* !! */  = var1_1;
                                    this.F$1 = var4_20;
                                    var8_13 /* !! */  = var1_1;
                                    this.Z$1 = var7_14;
                                    var8_13 /* !! */  = var1_1;
                                    this.label = 1;
                                    var8_13 /* !! */  = var1_1;
                                    var11_9 /* !! */  = var1_1.a(null, (d)this);
                                    if (var11_9 /* !! */  == var13_5) {
                                        return var13_5;
                                    }
                                }
                                catch (Throwable var1_2) {
                                    break block21;
                                }
                                var8_13 /* !! */  = var1_1;
                                var3_17 = var2_16;
                            }
                            this.L$0 = var1_1;
                            this.L$1 = var8_13 /* !! */ ;
                            this.L$2 = null;
                            this.L$3 = null;
                            this.label = 2;
                            var9_10 = DynamicIslandWindowView.addDynamicIslandDataSuspend$default((DynamicIslandWindowView)var9_10, (DynamicIslandData)var10_7 /* !! */ , var6_18, var3_17, var4_20, var7_14, false, (d)this, 32, null);
                            if (var9_10 == var13_5) {
                                return var13_5;
                            }
                            var10_7 /* !! */  = var8_13 /* !! */ ;
                        }
                        var9_10 = var10_7 /* !! */ ;
                        var8_13 /* !! */  = var1_1;
                        try {
                            var11_9 /* !! */  = s.a;
                            var8_13 /* !! */  = var1_1;
                        }
                        catch (Throwable var10_8) {
                            var1_1 = var8_13 /* !! */ ;
                            break block22;
                        }
                        try {
                            var10_7 /* !! */ .c(null);
                        }
                        catch (Throwable var1_3) {}
                        var8_13 /* !! */  = this.$dynamicIslandData.getKey();
                        var9_10 = new StringBuilder();
                        var9_10.append("addDynamicIslandData end ");
                        var9_10.append((String)var8_13 /* !! */ );
                        Log.d((String)"DynamicIslandWindowViewImpl", (String)var9_10.toString());
                        var8_13 /* !! */  = this.this$0;
                        var9_10 = this.$dynamicIslandData.getKey();
                        kotlin.jvm.internal.o.d((Object)var1_1);
                        DynamicIslandWindowView.access$releaseMutexIfIdle(var8_13 /* !! */ , (String)var9_10, (a)var1_1);
                        return s.a;
                        catch (Throwable var9_11) {}
                        ** GOTO lbl-1000
                        catch (Throwable var9_12) {}
lbl-1000:
                        // 2 sources

                        {
                            var10_7 /* !! */  = var9_10;
                            var9_10 = var8_13 /* !! */ ;
                        }
                    }
                    var8_13 /* !! */  = var1_1;
                    var9_10.c(null);
                    var8_13 /* !! */  = var1_1;
                    throw var10_7 /* !! */ ;
                }
                var10_7 /* !! */  = this.$dynamicIslandData.getKey();
                var9_10 = new StringBuilder();
                var9_10.append("addDynamicIslandData end ");
                var9_10.append((String)var10_7 /* !! */ );
                Log.d((String)"DynamicIslandWindowViewImpl", (String)var9_10.toString());
                var9_10 = this.this$0;
                var10_7 /* !! */  = this.$dynamicIslandData.getKey();
                kotlin.jvm.internal.o.d(var8_13 /* !! */ );
                DynamicIslandWindowView.access$releaseMutexIfIdle((DynamicIslandWindowView)var9_10, (String)var10_7 /* !! */ , var8_13 /* !! */ );
                throw var1_4;
            }
        }, (int)2, null);
    }

    public final void addOnDynamicIslandViewChangedListener(DynamicIslandContent.DynamicIslandViewChangedListener dynamicIslandViewChangedListener) {
        kotlin.jvm.internal.o.g((Object)dynamicIslandViewChangedListener, (String)"listener");
        this.listener = dynamicIslandViewChangedListener;
        DynamicIslandEventCoordinator dynamicIslandEventCoordinator = this.eventCoordinator;
        if (dynamicIslandEventCoordinator != null) {
            dynamicIslandEventCoordinator.addDynamicIslandViewChangedListener(dynamicIslandViewChangedListener);
        }
        this.requestSystemUIFeature();
    }

    @CallSuper
    public void addView(View view, int n2, ViewGroup.LayoutParams layoutParams) {
        int n3;
        kotlin.jvm.internal.o.g((Object)view, (String)"child");
        kotlin.jvm.internal.o.g((Object)layoutParams, (String)"params");
        ViewGroup viewGroup = this.mGlowEffectTopContainer;
        if (viewGroup != null) {
            ViewGroup viewGroup2 = viewGroup;
            if (viewGroup == null) {
                kotlin.jvm.internal.o.w((String)"mGlowEffectTopContainer");
                viewGroup2 = null;
            }
            n3 = this.indexOfChild((View)viewGroup2);
        } else {
            n3 = this.getChildCount();
        }
        if (n2 >= 0) {
            n3 = Math.min(n3, n2);
        }
        super.addView(view, n3, layoutParams);
    }

    public final void appEnter(DynamicIslandContentView dynamicIslandContentView) {
        DynamicIslandEventCoordinator dynamicIslandEventCoordinator;
        if (dynamicIslandContentView != null && (dynamicIslandEventCoordinator = this.eventCoordinator) != null) {
            dynamicIslandEventCoordinator.dispatchEvent(DynamicIslandEvent.EnterApp.INSTANCE, dynamicIslandContentView);
        }
    }

    public final void appExit(DynamicIslandContentView dynamicIslandContentView) {
        DynamicIslandEventCoordinator dynamicIslandEventCoordinator;
        if (dynamicIslandContentView != null && (dynamicIslandEventCoordinator = this.eventCoordinator) != null) {
            dynamicIslandEventCoordinator.dispatchEvent(DynamicIslandEvent.ExitApp.INSTANCE, dynamicIslandContentView);
        }
    }

    public final DynamicIslandState calculateCollapse(DynamicIslandContentView object) {
        DynamicIslandEventCoordinator dynamicIslandEventCoordinator = this.eventCoordinator;
        object = dynamicIslandEventCoordinator != null ? dynamicIslandEventCoordinator.calculateCollapse((DynamicIslandContentView)((Object)object)) : null;
        return object;
    }

    /*
     * Enabled aggressive block sorting
     */
    public final boolean canExpanded(boolean bl, View view, String charSequence) {
        boolean bl2 = false;
        boolean bl3 = false;
        if (charSequence != null && e1.o.v((CharSequence)charSequence, (CharSequence)"com.miui.tsmclient", (boolean)false, (int)2, null)) {
            boolean bl4 = bl3;
            if (!bl) return bl4;
            bl4 = bl3;
            if (view == null) return bl4;
            return true;
        }
        boolean bl5 = (Boolean)this.getWindowViewController().getWindowState().getNotificationAppearance().getValue();
        boolean bl6 = (Boolean)this.getWindowViewController().getWindowState().getControlCenterExpanded().getValue();
        bl3 = (Boolean)this.getWindowViewController().getWindowState().getScreenLocked().getValue();
        boolean bl7 = (Boolean)this.getWindowViewController().getWindowState().getMiPlayShow().getValue();
        boolean bl8 = !bl5 || bl3 && bl6;
        boolean bl9 = !CommonUtils.INSTANCE.getIS_TABLET() || !bl7;
        charSequence = new StringBuilder();
        ((StringBuilder)charSequence).append("\n            expanded = ");
        ((StringBuilder)charSequence).append(bl);
        ((StringBuilder)charSequence).append("\n            expandedView = ");
        ((StringBuilder)charSequence).append(view);
        ((StringBuilder)charSequence).append("\n            screenLocked = ");
        ((StringBuilder)charSequence).append(bl3);
        ((StringBuilder)charSequence).append("\n            notificationAppearance = ");
        ((StringBuilder)charSequence).append(bl5);
        ((StringBuilder)charSequence).append("\n            controlCenterExpanded = ");
        ((StringBuilder)charSequence).append(bl6);
        ((StringBuilder)charSequence).append("\n            shadeControllerCondition = ");
        ((StringBuilder)charSequence).append(bl8);
        ((StringBuilder)charSequence).append("\n            miPlayShow = ");
        ((StringBuilder)charSequence).append(bl7);
        ((StringBuilder)charSequence).append("\n            ");
        Log.d((String)TAG, (String)e1.g.e((String)((StringBuilder)charSequence).toString()));
        bl3 = bl2;
        if (!bl) return bl3;
        bl3 = bl2;
        if (!bl8) return bl3;
        bl3 = bl2;
        if (view == null) return bl3;
        bl3 = bl2;
        if (!bl9) return bl3;
        return true;
    }

    public final void cancelExpandViewTrackingAnim(DynamicIslandContentView dynamicIslandBaseContentView) {
        if (dynamicIslandBaseContentView != null && (dynamicIslandBaseContentView = dynamicIslandBaseContentView.getFakeView()) != null) {
            ((DynamicIslandContentFakeView)dynamicIslandBaseContentView).cancelExpandViewTrackingAnim();
        }
    }

    public final void cancelLongPressRunnable(DynamicIslandBaseContentView dynamicIslandBaseContentView) {
        kotlin.jvm.internal.o.g((Object)((Object)dynamicIslandBaseContentView), (String)"view");
        Runnable runnable = this.longPress;
        if (runnable != null) {
            dynamicIslandBaseContentView.removeCallbacks(runnable);
            this.longPress = null;
        }
    }

    /*
     * WARNING - void declaration
     */
    public final void clearAfterDelete(DynamicIslandData object, String string, boolean bl) {
        void var5_16;
        void var4_9;
        Bundle bundle;
        Bundle bundle2;
        StringBuilder object32 = new StringBuilder();
        object32.append("clearAfterDelete ");
        object32.append(string);
        Log.d((String)TAG, (String)object32.toString());
        if (object != null && (bundle2 = object.getExtras()) != null) {
            String string2 = bundle2.getString("miui.pkg.name");
        } else {
            Object var4_8 = null;
        }
        if (object != null && (bundle = object.getExtras()) != null) {
            Integer n2 = bundle.getInt("miui.user.id");
        } else {
            Object var5_15 = null;
        }
        object = object != null ? object.getProperties() : null;
        this.notifyRemoveIsland((String)var4_9, (Integer)var5_16, string, (Integer)object);
        if (string != null) {
            this.getViewComponent().getIslandTemplateFactory().removeTemplate(string);
        }
        for (DynamicIslandContentView dynamicIslandContentView : this.contentViewList) {
            this.onWindowAnimExtendLifetimeEnd(dynamicIslandContentView);
            object = dynamicIslandContentView.getCurrentIslandData();
            if (!kotlin.jvm.internal.o.c((Object)(object = object != null ? object.getKey() : null), (Object)string)) continue;
            this.contentViewList.remove((Object)dynamicIslandContentView);
            this.onDynamicIslandDataChanged();
        }
        if (bl) {
            object = this.dynamicIslandDataList.iterator();
            while (object.hasNext()) {
                if (!TextUtils.equals((CharSequence)((DynamicIslandData)object.next()).getKey(), (CharSequence)string)) continue;
                object.remove();
            }
        }
        this.onDeviceNotificationChanged(this.hasDeviceNotification());
        for (DynamicIslandContentFakeView dynamicIslandContentFakeView : this.fakeViewList) {
            object = dynamicIslandContentFakeView.getCurrentIslandData();
            object = object != null ? object.getKey() : null;
            if (!kotlin.jvm.internal.o.c((Object)object, (Object)string)) continue;
            this.fakeViewList.remove((Object)dynamicIslandContentFakeView);
            this.removeView((View)dynamicIslandContentFakeView);
            dynamicIslandContentFakeView.getController().destroy();
        }
    }

    public final void collapse(String object) {
        kotlin.jvm.internal.o.g((Object)object, (String)"reason");
        Object object2 = this.getCurrentExpandedState();
        boolean bl = true;
        boolean bl2 = object2 != null && (object2 = ((DynamicIslandBaseContentView)((Object)object2)).getFakeView()) != null && ((DynamicIslandBaseContentView)((Object)object2)).getOpenAppFromIsland();
        object2 = this.getCurrentExpandedState();
        boolean bl3 = object2 != null && ((DynamicIslandBaseContentView)((Object)object2)).getOpenAppFromIsland();
        if (this.getCurrentExpandedState() == null) {
            bl = false;
        }
        object2 = new StringBuilder();
        ((StringBuilder)object2).append("skip collapse=(");
        ((StringBuilder)object2).append(bl3);
        ((StringBuilder)object2).append("||");
        ((StringBuilder)object2).append(bl2);
        ((StringBuilder)object2).append("||");
        ((StringBuilder)object2).append(bl);
        ((StringBuilder)object2).append("), reason=");
        ((StringBuilder)object2).append((String)object);
        Log.d((String)TAG, (String)((StringBuilder)object2).toString());
        if (!bl3 && !bl2 && bl) {
            if (kotlin.jvm.internal.o.c((Object)object, (Object)"receive collapse") && (object = this.eventCoordinator) != null && (object = ((DynamicIslandEventCoordinator)object).getExpandedStateHandler()) != null && (object = ((ExpandedStateHandler)object).getCurrent()) != null) {
                ((DynamicIslandContentView)((Object)object)).clickOnButtonTrack(false, false);
            }
            if ((object = this.eventCoordinator) != null) {
                ((DynamicIslandEventCoordinator)object).setUserExpanded(false);
            }
            object = this.getCurrentExpandedState();
            if (object != null && (object = ((DynamicIslandBaseContentView)((Object)object)).getCurrentIslandData()) != null) {
                this.sendExitPendingIntent(object.getExtras());
            }
            if ((object = this.eventCoordinator) != null) {
                DynamicIslandEventCoordinator.dispatchEvent$default((DynamicIslandEventCoordinator)object, DynamicIslandEvent.Collapse.INSTANCE, null, 2, null);
            }
        }
    }

    public final void destroy() {
        this.getLifecycle().setCurrentState(Lifecycle.State.DESTROYED);
        ViewTreeObserver viewTreeObserver = this.getViewTreeObserver();
        if (viewTreeObserver != null) {
            viewTreeObserver.removeOnGlobalLayoutListener(this.onGlobalLayoutListener);
        }
        this.getWindowViewController().destroy();
    }

    public void dispatchDraw(Canvas canvas) {
        kotlin.jvm.internal.o.g((Object)canvas, (String)"canvas");
        super.dispatchDraw(canvas);
        f.b((f1.E)LifecycleOwnerKt.getLifecycleScope((LifecycleOwner)this), null, null, (U0.o)new U0.o(this, canvas, null){
            final Canvas $canvas;
            int label;
            final DynamicIslandWindowView this$0;
            {
                this.this$0 = dynamicIslandWindowView;
                this.$canvas = canvas;
                super(2, d2);
            }

            public final d create(Object object, d d2) {
                return new /* invalid duplicate definition of identical inner class */;
            }

            public final Object invoke(f1.E e2, d d2) {
                return (this.create(e2, d2)).invokeSuspend(s.a);
            }

            /*
             * Enabled force condition propagation
             * Lifted jumps to return sites
             */
            public final Object invokeSuspend(Object object) {
                Object object2 = L0.c.c();
                int n2 = this.label;
                if (n2 != 0) {
                    if (n2 != 1) throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    G0.k.b((Object)object);
                    return s.a;
                } else {
                    G0.k.b((Object)object);
                    t t2 = DynamicIslandWindowView.access$get_dispatchDrawEvent$p(this.this$0);
                    object = this.$canvas;
                    this.label = 1;
                    if (t2.emit(object, (d)this) != object2) return s.a;
                    return object2;
                }
            }
        }, (int)3, null);
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (motionEvent != null) {
            f.b((f1.E)LifecycleOwnerKt.getLifecycleScope((LifecycleOwner)this), null, null, (U0.o)new U0.o(this, motionEvent, null){
                final MotionEvent $nonNullEv;
                int label;
                final DynamicIslandWindowView this$0;
                {
                    this.this$0 = dynamicIslandWindowView;
                    this.$nonNullEv = motionEvent;
                    super(2, d2);
                }

                public final d create(Object object, d d2) {
                    return new /* invalid duplicate definition of identical inner class */;
                }

                public final Object invoke(f1.E e2, d d2) {
                    return (this.create(e2, d2)).invokeSuspend(s.a);
                }

                /*
                 * Enabled force condition propagation
                 * Lifted jumps to return sites
                 */
                public final Object invokeSuspend(Object object) {
                    Object object2 = L0.c.c();
                    int n2 = this.label;
                    if (n2 != 0) {
                        if (n2 != 1) throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        G0.k.b((Object)object);
                        return s.a;
                    } else {
                        G0.k.b((Object)object);
                        object = DynamicIslandWindowView.access$get_dispatchTouchEvent$p(this.this$0);
                        MotionEvent motionEvent = this.$nonNullEv;
                        this.label = 1;
                        if (object.emit((Object)motionEvent, (d)this) != object2) return s.a;
                        return object2;
                    }
                }
            }, (int)3, null);
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public final boolean downInMedia(Context context, float f2, float f3, View view, boolean bl) {
        Object object;
        kotlin.jvm.internal.o.g((Object)context, (String)"sysUIContext");
        if (!(view == null || (object = this.dynamicIslandDataList) != null && object.isEmpty())) {
            object = object.iterator();
            while (object.hasNext()) {
                if (!this.isMediaApp((DynamicIslandData)object.next())) continue;
                bl = bl ? this.isDownInSeekBar(context, f2, f3, view) : this.isDownInMediaChildViews(context, f2, f3, view);
                return bl;
            }
        }
        return false;
    }

    public final void downInWhichButton(Context object, float f2, float f3, View object2) {
        kotlin.jvm.internal.o.g((Object)object, (String)"sysUIContext");
        for (String string : H0.m.j((Object[])new String[]{"action0", "action1", "action2", "action3", "action4"})) {
            block4: {
                block3: {
                    int n2;
                    Resources resources = object.getResources();
                    if (resources == null || !this.isTouchInView((View)object2, n2 = resources.getIdentifier(string, "id", "com.android.systemui"), f2, f3)) continue;
                    if (object2 == null || (object = object2.findViewById(n2)) == null) break block3;
                    object2 = object.getContentDescription();
                    object = object2;
                    if (object2 != null) break block4;
                }
                object = "null";
            }
            this.downInWhichButton = object.toString();
            break;
        }
    }

    public final void enterMiniWindow(DynamicIslandContentView dynamicIslandContentView) {
        DynamicIslandEventCoordinator dynamicIslandEventCoordinator;
        if (dynamicIslandContentView != null && (dynamicIslandEventCoordinator = this.eventCoordinator) != null) {
            dynamicIslandEventCoordinator.dispatchEvent(DynamicIslandEvent.EnterMiniWindow.INSTANCE, dynamicIslandContentView);
        }
    }

    public final void enterMiniWindowEnd() {
        DynamicIslandEventCoordinator dynamicIslandEventCoordinator = this.eventCoordinator;
        if (dynamicIslandEventCoordinator != null) {
            dynamicIslandEventCoordinator.setEnterMiniWindow(false);
        }
    }

    public final void exitMiniWindow(DynamicIslandContentView dynamicIslandContentView) {
        DynamicIslandEventCoordinator dynamicIslandEventCoordinator;
        if (dynamicIslandContentView != null && (dynamicIslandEventCoordinator = this.eventCoordinator) != null) {
            dynamicIslandEventCoordinator.dispatchEvent(DynamicIslandEvent.ExitMiniWindow.INSTANCE, dynamicIslandContentView);
        }
    }

    public final CopyOnWriteArrayList<DynamicIslandContentView> getContentViewList() {
        return this.contentViewList;
    }

    public final List<DynamicIslandContentView> getContentViews() {
        return u.k0(this.contentViewList);
    }

    public final List<DynamicIslandContentView> getCurrentAppExpandedState() {
        Object object = this.eventCoordinator;
        if (object == null || (object = ((DynamicIslandEventCoordinator)object).getAppStateHandler()) == null || (object = ((StateHandler)object).getCurrentList()) == null) {
            object = new ArrayList<DynamicIslandContentView>();
        }
        return object;
    }

    public final DynamicIslandContentView getCurrentBigIslandState() {
        Object object = this.eventCoordinator;
        object = object != null && (object = ((DynamicIslandEventCoordinator)object).getBigIslandStateHandler()) != null ? ((BigIslandStateHandler)object).getCurrent() : null;
        return object;
    }

    public final DynamicIslandContentView getCurrentExpandedState() {
        Object object = this.eventCoordinator;
        object = object != null && (object = ((DynamicIslandEventCoordinator)object).getExpandedStateHandler()) != null ? ((ExpandedStateHandler)object).getCurrent() : null;
        return object;
    }

    public final List<DynamicIslandContentView> getCurrentMiniWindowState(String object) {
        kotlin.jvm.internal.o.g((Object)object, (String)"pkg");
        ArrayList<DynamicIslandContentView> arrayList = new ArrayList<DynamicIslandContentView>();
        HashMap<String, ArrayList<DynamicIslandContentView>> hashMap = this.eventCoordinator;
        if (hashMap != null && (hashMap = ((DynamicIslandEventCoordinator)((Object)hashMap)).getMiniWindowStateHandler()) != null && (hashMap = ((StateHandler)((Object)hashMap)).getCurrentMap()) != null && (object = hashMap.get(object)) != null) {
            arrayList.addAll((Collection<DynamicIslandContentView>)object);
        }
        return arrayList;
    }

    public final DynamicIslandContentView getCurrentSmallIslandState() {
        Object object = this.eventCoordinator;
        object = object != null && (object = ((DynamicIslandEventCoordinator)object).getSmallIslandStateHandler()) != null ? ((SmallIslandStateHandler)object).getCurrent() : null;
        return object;
    }

    public final DynamicIslandContentView getCurrentTempShowBigIslandState() {
        Object object = this.eventCoordinator;
        object = object != null && (object = ((DynamicIslandEventCoordinator)object).getShowOnceIslandHandler()) != null ? ((StateHandler)object).getCurrent() : null;
        return object;
    }

    public final int getCurrentUserId() {
        return this.currentUserId;
    }

    public final int getCutoutHeight() {
        int n2 = this.getContext().getResources().getDimensionPixelSize(R.dimen.island_height);
        return Math.min(this.getCutoutWidth(), (int)((float)n2 * 0.9f));
    }

    public final Rect getCutoutRect() {
        Rect rect = new Rect();
        DynamicIslandUtils dynamicIslandUtils = DynamicIslandUtils.INSTANCE;
        Context context = this.getContext();
        kotlin.jvm.internal.o.f((Object)context, (String)"getContext(...)");
        rect.left = dynamicIslandUtils.getScreenWidthOld(context) / 2 - this.getCutoutWidth() / 2;
        rect.top = (int)this.getWindowViewController().getCutoutY() - this.getCutoutHeight() / 2;
        rect.right = rect.left + this.getCutoutWidth();
        rect.bottom = rect.top + this.getCutoutHeight();
        return rect;
    }

    public final int getCutoutWidth() {
        int n2;
        DynamicIslandUtils dynamicIslandUtils = DynamicIslandUtils.INSTANCE;
        Context context = this.getContext();
        kotlin.jvm.internal.o.f((Object)context, (String)"getContext(...)");
        int n3 = n2 = dynamicIslandUtils.dpToPx(20, context);
        if (!FoldUtils.INSTANCE.isFoldScreenLayoutLarge((View)this)) {
            if (FlipUtils.isFlipTiny()) {
                n3 = n2;
            } else {
                n3 = n2;
                if (dynamicIslandUtils.getCutoutBoundingRectTopWidth() > 0) {
                    n3 = dynamicIslandUtils.getCutoutBoundingRectTopWidth();
                }
            }
        }
        return n3;
    }

    public final y getDispatchDrawEvent() {
        return this.dispatchDrawEvent;
    }

    public final y getDispatchTouchEvent() {
        return this.dispatchTouchEvent;
    }

    public final String getDownInWhichButton() {
        return this.downInWhichButton;
    }

    public final DynamicIslandEventCoordinator getEventCoordinator() {
        return this.eventCoordinator;
    }

    public final List<DynamicIslandContentFakeView> getFakeViews() {
        return u.k0(this.fakeViewList);
    }

    public final int getHeadsUpHeight() {
        return this._headsUpHeight;
    }

    public LifecycleRegistry getLifecycle() {
        return (LifecycleRegistry)this.lifecycle$delegate.getValue();
    }

    public final DynamicIslandContentView getMainAppExpanded() {
        Object object = this.eventCoordinator;
        object = object != null && (object = ((DynamicIslandEventCoordinator)object).getAppStateHandler()) != null ? ((AppStateHandler)object).getMainElement() : null;
        return object;
    }

    public final DynamicIslandContentView getMainAppExpandedTopLeve() {
        Object object = this.eventCoordinator;
        object = object != null && (object = ((DynamicIslandEventCoordinator)object).getAppStateHandler()) != null ? ((AppStateHandler)object).getTopLevel() : null;
        return object;
    }

    public final int getMainAppExpandedTopLeveCount() {
        Object object = this.eventCoordinator;
        int n2 = object != null && (object = ((DynamicIslandEventCoordinator)object).getAppStateHandler()) != null ? ((AppStateHandler)object).getTopLevelCount() : 0;
        return n2;
    }

    public final DynamicIslandContentView getMainMiniWindow(String object) {
        kotlin.jvm.internal.o.g((Object)object, (String)"pkg");
        Object object2 = this.eventCoordinator;
        object = object2 != null && (object2 = ((DynamicIslandEventCoordinator)object2).getMiniWindowStateHandler()) != null ? ((MiniWindowStateHandler)object2).getMainElement((String)object) : null;
        return object;
    }

    public final DynamicIslandContentView getMainMiniWindowState(String object) {
        kotlin.jvm.internal.o.g((Object)object, (String)"pkg");
        Object object2 = this.eventCoordinator;
        object = object2 != null && (object2 = ((DynamicIslandEventCoordinator)object2).getMiniWindowStateHandler()) != null ? ((MiniWindowStateHandler)object2).getMainElement((String)object) : null;
        return object;
    }

    public final DynamicIslandContentView getMainMiniWindowTopLeve(String object) {
        kotlin.jvm.internal.o.g((Object)object, (String)"pkg");
        Object object2 = this.eventCoordinator;
        object = object2 != null && (object2 = ((DynamicIslandEventCoordinator)object2).getMiniWindowStateHandler()) != null ? ((MiniWindowStateHandler)object2).getTopLevel((String)object) : null;
        return object;
    }

    public final int getMainMiniWindowTopLeveCount(String string) {
        kotlin.jvm.internal.o.g((Object)string, (String)"pkg");
        Object object = this.eventCoordinator;
        int n2 = object != null && (object = ((DynamicIslandEventCoordinator)object).getMiniWindowStateHandler()) != null ? ((MiniWindowStateHandler)object).getTopLevelCount(string) : 0;
        return n2;
    }

    public final DynamicIslandContentFakeView getMiniWindowContentFakeView(String object) {
        kotlin.jvm.internal.o.g((Object)object, (String)"pkg");
        Object object2 = this.eventCoordinator;
        object = object2 != null && (object2 = ((DynamicIslandEventCoordinator)object2).getMiniWindowStateHandler()) != null && (object = ((MiniWindowStateHandler)object2).getMainElement((String)object)) != null ? ((DynamicIslandBaseContentView)((Object)object)).getFakeView() : null;
        return object;
    }

    public final y getOnInterceptTouchEvent() {
        return this.onInterceptTouchEvent;
    }

    public final y getOnTouchEvent() {
        return this.onTouchEvent;
    }

    public final DynamicIslandContentView getPendingMediaView() {
        return this.pendingMediaView;
    }

    public final DynamicIslandContentView getSubAppExpanded() {
        Object object = this.eventCoordinator;
        object = object != null && (object = ((DynamicIslandEventCoordinator)object).getAppStateHandler()) != null ? ((AppStateHandler)object).getSubElement() : null;
        return object;
    }

    public final DynamicIslandContentView getSubMiniWindow(String object) {
        kotlin.jvm.internal.o.g((Object)object, (String)"pkg");
        Object object2 = this.eventCoordinator;
        object = object2 != null && (object2 = ((DynamicIslandEventCoordinator)object2).getMiniWindowStateHandler()) != null ? ((MiniWindowStateHandler)object2).getSubElement((String)object) : null;
        return object;
    }

    public final boolean getSupportMiniWindowEndPositionChange() {
        return this.supportMiniWindowEndPositionChange;
    }

    public final boolean getTouchOutsideInHeadsUp() {
        return this.touchOutsideInHeadsUp;
    }

    public final DynamicIslandViewComponent getViewComponent() {
        DynamicIslandViewComponent dynamicIslandViewComponent = this._viewComponent;
        if (dynamicIslandViewComponent != null) {
            return dynamicIslandViewComponent;
        }
        throw new IllegalStateException("DynamicIslandViewComponent was not initialized.");
    }

    public final DynamicIslandContentView getViewFromList(String string) {
        String string2;
        block1: {
            Object t2;
            Iterator iterator = this.contentViewList.iterator();
            do {
                boolean bl = iterator.hasNext();
                string2 = null;
                String string3 = null;
                if (!bl) break block1;
                t2 = iterator.next();
                DynamicIslandData dynamicIslandData = ((DynamicIslandContentView)((Object)t2)).getCurrentIslandData();
                string2 = string3;
                if (dynamicIslandData == null) continue;
                string2 = dynamicIslandData.getKey();
            } while (!kotlin.jvm.internal.o.c((Object)string2, (Object)string));
            string2 = t2;
        }
        return (DynamicIslandContentView)((Object)string2);
    }

    public final DynamicIslandWindowViewController getWindowViewController() {
        return (DynamicIslandWindowViewController)this.windowViewController$delegate.getValue();
    }

    public final boolean hasNoActiveDynamicIsland() {
        return this.dynamicIslandDataList.size() == 0;
    }

    /*
     * WARNING - void declaration
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public final boolean hasOtherBigIsland(DynamicIslandContentView object) {
        void var1_12;
        void var1_6;
        void var3_27;
        DynamicIslandData dynamicIslandData;
        DynamicIslandContentView dynamicIslandContentView;
        BigIslandStateHandler bigIslandStateHandler;
        void var3_19;
        BigIslandStateHandler bigIslandStateHandler2;
        DynamicIslandData dynamicIslandData2;
        Object var4_13 = null;
        if (object != null && (dynamicIslandData2 = ((DynamicIslandBaseContentView)((Object)object)).getCurrentIslandData()) != null) {
            String string = dynamicIslandData2.getKey();
        } else {
            Object var1_5 = null;
        }
        DynamicIslandEventCoordinator dynamicIslandEventCoordinator = this.eventCoordinator;
        if (dynamicIslandEventCoordinator != null && (bigIslandStateHandler2 = dynamicIslandEventCoordinator.getBigIslandStateHandler()) != null) {
            DynamicIslandContentView dynamicIslandContentView2 = bigIslandStateHandler2.getCurrent();
        } else {
            Object var3_18 = null;
        }
        if (var3_19 == null) return false;
        DynamicIslandEventCoordinator dynamicIslandEventCoordinator2 = this.eventCoordinator;
        if (dynamicIslandEventCoordinator2 != null && (bigIslandStateHandler = dynamicIslandEventCoordinator2.getBigIslandStateHandler()) != null && (dynamicIslandContentView = bigIslandStateHandler.getCurrent()) != null && (dynamicIslandData = dynamicIslandContentView.getCurrentIslandData()) != null) {
            String string = dynamicIslandData.getKey();
        } else {
            Object var3_26 = null;
        }
        if (kotlin.jvm.internal.o.c((Object)var3_27, (Object)var1_6)) return false;
        DynamicIslandWindowState dynamicIslandWindowState = this.getWindowViewController().getWindowState();
        Object object2 = this.eventCoordinator;
        Object var1_7 = var4_13;
        if (object2 != null) {
            object2 = ((DynamicIslandEventCoordinator)object2).getBigIslandStateHandler();
            Object var1_8 = var4_13;
            if (object2 != null) {
                object2 = ((BigIslandStateHandler)object2).getCurrent();
                Object var1_9 = var4_13;
                if (object2 != null) {
                    object2 = ((DynamicIslandBaseContentView)((Object)object2)).getCurrentIslandData();
                    Object var1_10 = var4_13;
                    if (object2 != null) {
                        Integer n2 = object2.getProperties();
                    }
                }
            }
        }
        if (dynamicIslandWindowState.isTempHidden((Integer)var1_12)) return false;
        return true;
    }

    public final boolean hasSubAppExpanded(String string) {
        int n2;
        kotlin.jvm.internal.o.g((Object)string, (String)"pkg");
        Object object = this.eventCoordinator;
        boolean bl = false;
        if (object != null && (object = ((DynamicIslandEventCoordinator)object).getAppStateHandler()) != null && (object = ((StateHandler)object).getCurrentList()) != null) {
            ArrayList arrayList = new ArrayList();
            for (Object t2 : object) {
                object = (DynamicIslandContentView)((Object)t2);
                object = object != null ? ((DynamicIslandBaseContentView)((Object)object)).getPkgName() : null;
                if (!kotlin.jvm.internal.o.c((Object)object, (Object)string)) continue;
                arrayList.add(t2);
            }
            n2 = arrayList.size();
        } else {
            n2 = 0;
        }
        if (n2 > 1) {
            bl = true;
        }
        return bl;
    }

    public final boolean hasSubMiniWindow(String object) {
        kotlin.jvm.internal.o.g((Object)object, (String)"pkg");
        HashMap<String, ArrayList<DynamicIslandContentView>> hashMap = this.eventCoordinator;
        boolean bl = false;
        int n2 = hashMap != null && (hashMap = ((DynamicIslandEventCoordinator)((Object)hashMap)).getMiniWindowStateHandler()) != null && (hashMap = ((StateHandler)((Object)hashMap)).getCurrentMap()) != null && (object = hashMap.get(object)) != null ? ((ArrayList)object).size() : 0;
        if (n2 > 1) {
            bl = true;
        }
        return bl;
    }

    public final void hideAllElementSurface() {
        for (DynamicIslandContentView dynamicIslandContentView : this.contentViewList) {
            Object object;
            Object var2_3 = null;
            object = dynamicIslandContentView != null && (object = dynamicIslandContentView.getCurrentIslandData()) != null && (object = object.getExtras()) != null ? object.getString("miui.pkg.name") : null;
            Object object2 = new StringBuilder();
            ((StringBuilder)object2).append("hideAllElementSurface: ");
            ((StringBuilder)object2).append((String)object);
            Log.d((String)TAG, (String)((StringBuilder)object2).toString());
            object2 = this.eventCoordinator;
            if (object2 != null) {
                object = dynamicIslandContentView != null && (object = dynamicIslandContentView.getCurrentIslandData()) != null ? object.getExtras() : null;
                ((DynamicIslandEventCoordinator)object2).alreadyCloseAppEnd((Bundle)object);
            }
            if ((object2 = this.eventCoordinator) != null) {
                object = var2_3;
                if (dynamicIslandContentView != null) {
                    DynamicIslandData dynamicIslandData = dynamicIslandContentView.getCurrentIslandData();
                    object = var2_3;
                    if (dynamicIslandData != null) {
                        object = dynamicIslandData.getExtras();
                    }
                }
                ((DynamicIslandEventCoordinator)object2).onWindowAnimExtendLifetimeEnd((Bundle)object);
            }
            if (dynamicIslandContentView != null) {
                dynamicIslandContentView.resetStatus();
            }
            if (dynamicIslandContentView == null || (object = dynamicIslandContentView.getFakeView()) == null) continue;
            ((DynamicIslandContentFakeView)((Object)object)).resetStatus();
        }
    }

    public final boolean isLight() {
        return this.isLight;
    }

    public final boolean isMediaApp(DynamicIslandData object) {
        object = object != null && (object = object.getExtras()) != null ? (PendingIntent)object.getParcelable("miui.pending.intent", PendingIntent.class) : null;
        boolean bl = object != null;
        return bl;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public final boolean isSwipeTowardsSmallIsland(float f2) {
        Context context = this.getContext();
        kotlin.jvm.internal.o.f((Object)context, (String)"getContext(...)");
        boolean bl = CommonUtils.isLayoutRtl((Context)context);
        boolean bl2 = false;
        if (bl) {
            if (!(f2 <= 0.0f)) return bl2;
            return true;
        }
        if (!(f2 >= 0.0f)) return bl2;
        return true;
    }

    public final boolean isTempShowBigIslandToBeRemoved() {
        DynamicIslandContentView dynamicIslandContentView = this.getCurrentTempShowBigIslandState();
        if (dynamicIslandContentView != null && (dynamicIslandContentView = dynamicIslandContentView.getCurrentIslandData()) != null) {
            DynamicIslandWindowView.removeDynamicIslandData$default(this, (DynamicIslandData)dynamicIslandContentView, false, false, 6, null);
            return true;
        }
        return false;
    }

    public final boolean isUserExpanded() {
        boolean bl;
        DynamicIslandEventCoordinator dynamicIslandEventCoordinator = this.eventCoordinator;
        boolean bl2 = bl = false;
        if (dynamicIslandEventCoordinator != null) {
            bl2 = bl;
            if (dynamicIslandEventCoordinator.getUserExpanded()) {
                bl2 = true;
            }
        }
        return bl2;
    }

    public final void maybeCollapseExpand(int n2, int n3) {
        DynamicIslandEventCoordinator dynamicIslandEventCoordinator = this.eventCoordinator;
        dynamicIslandEventCoordinator = dynamicIslandEventCoordinator != null && (dynamicIslandEventCoordinator = dynamicIslandEventCoordinator.getHeadsUpZone()) != null ? (i)dynamicIslandEventCoordinator.getValue() : null;
        if (dynamicIslandEventCoordinator != null && n3 >= ((Number)dynamicIslandEventCoordinator.d()).intValue() && n3 <= ((Number)dynamicIslandEventCoordinator.e()).intValue()) {
            return;
        }
        dynamicIslandEventCoordinator = this.eventCoordinator;
        if (dynamicIslandEventCoordinator != null && (dynamicIslandEventCoordinator = dynamicIslandEventCoordinator.getTouchRegion()) != null && (dynamicIslandEventCoordinator = (Region)dynamicIslandEventCoordinator.getValue()) != null && dynamicIslandEventCoordinator.contains(n2, n3)) {
            return;
        }
        if (!this.isUserExpanded()) {
            return;
        }
        this.post(new l(this));
    }

    public final boolean needExtendLifetime(String string) {
        kotlin.jvm.internal.o.g((Object)string, (String)"key");
        DynamicIslandEventCoordinator dynamicIslandEventCoordinator = this.eventCoordinator;
        boolean bl = dynamicIslandEventCoordinator != null ? dynamicIslandEventCoordinator.needExtendLifetime(string) : false;
        return bl;
    }

    public final void notifyAddIsland(String string, Integer n2, String string2, Integer n3) {
        Bundle bundle = new Bundle();
        bundle.putString("action_key", "action_back_add_island");
        bundle.putString("extra_back_add_island_pkg", string);
        if (n2 != null) {
            bundle.putInt("extra_back_add_island_uid", ((Number)n2).intValue());
        }
        bundle.putString("extra_back_add_island_key", string2);
        if (n3 != null) {
            bundle.putInt("extra_back_add_island_prop", ((Number)n3).intValue());
        }
        bundle.putFloat("extra_back_add_island_radius", this.getContext().getResources().getDimension(R.dimen.island_radius));
        string = this.listener;
        if (string != null) {
            string.onIslandViewChanged(bundle);
        }
    }

    public final Bundle notifyIslandViewChanged(Bundle object) {
        kotlin.jvm.internal.o.g((Object)object, (String)"bundle");
        DynamicIslandContent.DynamicIslandViewChangedListener dynamicIslandViewChangedListener = this.listener;
        object = dynamicIslandViewChangedListener != null ? dynamicIslandViewChangedListener.onIslandViewChanged(object) : null;
        return object;
    }

    public final void notifyRemoveIsland(String string, Integer n2, String string2, Integer n3) {
        Bundle bundle = new Bundle();
        bundle.putString("action_key", "action_back_remove_island");
        bundle.putString("extra_back_add_island_pkg", string);
        if (n2 != null) {
            bundle.putInt("extra_back_add_island_uid", ((Number)n2).intValue());
        }
        bundle.putString("extra_back_add_island_key", string2);
        if (n3 != null) {
            bundle.putInt("extra_back_add_island_prop", ((Number)n3).intValue());
        }
        if ((string = this.listener) != null) {
            string.onIslandViewChanged(bundle);
        }
    }

    /*
     * Enabled aggressive block sorting
     */
    public WindowInsets onApplyWindowInsets(WindowInsets windowInsets) {
        int n2 = this.getWindowInsetsRotation(windowInsets);
        Object object = new StringBuilder();
        ((StringBuilder)object).append("onApplyWindowInsets r=");
        ((StringBuilder)object).append(n2);
        Log.d((String)TAG, (String)((StringBuilder)object).toString());
        int n3 = this.getWindowViewController().getDisplayOrientation();
        int n4 = 0;
        n3 = !(n3 != 0 ? (n3 != 1 ? (n3 != 2 ? n3 == 3 && n2 == 1 : n2 == 0) : n2 == 3) : n2 == 2) ? 0 : 1;
        n2 = n4;
        if (FlipUtils.isFlipTiny()) {
            n2 = n4;
            if (n3 != 0) {
                n2 = 1;
            }
        }
        if (this.getWindowViewController().isNotchScreenDevice() || n2 != 0 || this.getWindowViewController().isRealCutoutHeightDevice()) {
            float f2;
            this.getWindowViewController().updateWindowState();
            object = this.requestCutoutY();
            if (object != null) {
                f2 = ((Number)object).floatValue();
                this.getViewComponent().getSizeRepository().updateCutoutY(f2);
            }
            if ((object = this.requestCutoutHeight()) != null) {
                f2 = ((Number)object).floatValue();
                this.getViewComponent().getSizeRepository().updateCutoutHeight(f2);
            }
            if (n2 != 0 && (object = this.eventCoordinator) != null && (object = ((DynamicIslandEventCoordinator)object).getTempShow()) != null && !((DynamicIslandBaseContentView)((Object)object)).isAnimating()) {
                DynamicIslandWindowView.removeDynamicIslandData$default(this, ((DynamicIslandBaseContentView)((Object)object)).getCurrentIslandData(), true, false, 4, null);
            }
        }
        windowInsets = super.onApplyWindowInsets(windowInsets);
        kotlin.jvm.internal.o.f((Object)windowInsets, (String)"onApplyWindowInsets(...)");
        return windowInsets;
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (CommonUtils.IS_MULTI_RENDER_THREAD) {
            DynamicIslandScenarioUtils.INSTANCE.setDynamicIslandRenderThreadId((View)this);
        }
    }

    public final void onConfigChanged(Configuration object4) {
        kotlin.jvm.internal.o.g((Object)object4, (String)"newConfig");
        Object object = this.eventCoordinator;
        if (object != null) {
            ((DynamicIslandEventCoordinator)object).updateTouchRegion();
        }
        boolean bl = this.getWindowViewController().getWindowState().isTinyScreen();
        object = new StringBuilder();
        ((StringBuilder)object).append("isTiny=");
        ((StringBuilder)object).append(bl);
        ((StringBuilder)object).append(" config changed to ");
        ((StringBuilder)object).append(object4);
        Log.d((String)TAG, (String)((StringBuilder)object).toString());
        object = this.requestCutoutY();
        if (object != null) {
            float f2 = ((Number)object).floatValue();
            this.getViewComponent().getSizeRepository().updateCutoutY(f2);
        }
        object = (object = this.eventCoordinator) != null ? ((DynamicIslandEventCoordinator)object).getTempShow() : null;
        Configuration configuration = this.previousConfig;
        Object object2 = configuration;
        if (configuration == null) {
            kotlin.jvm.internal.o.w((String)"previousConfig");
            object2 = null;
        }
        bl = object2.isNightModeActive();
        boolean bl2 = object4.isNightModeActive();
        boolean bl3 = true;
        boolean bl4 = bl == bl2;
        if (object != null && bl4) {
            DynamicIslandWindowView.removeDynamicIslandData$default(this, ((DynamicIslandBaseContentView)((Object)object)).getCurrentIslandData(), true, false, 4, null);
        }
        this.getWindowViewController().getWindowState().setConfigChange(Boolean.TRUE);
        object = object2 = this.previousConfig;
        if (object2 == null) {
            kotlin.jvm.internal.o.w((String)"previousConfig");
            object = null;
        }
        if (MiBlurCompat.getBackgroundBlurOpened((Configuration)object) == MiBlurCompat.getBackgroundBlurOpened((Configuration)object4)) {
            bl3 = false;
        }
        if (bl3) {
            this.updateBlurContainer(MiBlurCompat.getBackgroundBlurOpened((Configuration)object4));
        }
        object = object2 = this.previousConfig;
        if (object2 == null) {
            kotlin.jvm.internal.o.w((String)"previousConfig");
            object = null;
        }
        bl = this.compareConfigurations((Configuration)object, (Configuration)object4);
        object = object2 = this.previousConfig;
        if (object2 == null) {
            kotlin.jvm.internal.o.w((String)"previousConfig");
            object = null;
        }
        object.updateFrom((Configuration)object4);
        if (bl) {
            this.getViewComponent().getSizeRepository().updateIslandMaxWidth(0.0f, 0.0f, 0.0f);
            DynamicIslandWindowViewController.DynamicIslandCallback dynamicIslandCallback = this.getWindowViewController().getDynamicIslandCallback();
            if (dynamicIslandCallback != null) {
                dynamicIslandCallback.onDynamicIslandConfigChange();
            }
            this.getWindowViewController().getWindowState().setConfigChange(Boolean.FALSE);
            return;
        }
        for (DynamicIslandContentView dynamicIslandContentView : this.contentViewList) {
            if (dynamicIslandContentView.getCurrentIslandData() != null && ((object2 = dynamicIslandContentView.getCurrentIslandData()) == null || (object2 = object2.getProperties()) == null || (Integer)object2 != 0 || bl4)) {
                dynamicIslandContentView.calculateBigIslandWidth();
                f.b((f1.E)this.getWindowViewController().getUiScopeImmediate(), null, null, (U0.o)new U0.o(dynamicIslandContentView, null){
                    final DynamicIslandContentView $it;
                    int label;
                    {
                        this.$it = dynamicIslandContentView;
                        super(2, d2);
                    }

                    public final d create(Object object, d d2) {
                        return new /* invalid duplicate definition of identical inner class */;
                    }

                    public final Object invoke(f1.E e2, d d2) {
                        return (this.create(e2, d2)).invokeSuspend(s.a);
                    }

                    /*
                     * Enabled force condition propagation
                     * Lifted jumps to return sites
                     */
                    public final Object invokeSuspend(Object object) {
                        Object object2 = L0.c.c();
                        int n2 = this.label;
                        if (n2 != 0) {
                            if (n2 != 1) throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            G0.k.b((Object)object);
                            return s.a;
                        } else {
                            G0.k.b((Object)object);
                            DynamicIslandContentView dynamicIslandContentView = this.$it;
                            object = dynamicIslandContentView.getCurrentIslandData();
                            this.label = 1;
                            if (dynamicIslandContentView.updateView((DynamicIslandData)object, true, false, (d)this) != object2) return s.a;
                            return object2;
                        }
                    }
                }, (int)3, null);
            }
            kotlin.jvm.internal.o.d((Object)((Object)dynamicIslandContentView));
            this.measureExpandedViewHeight(dynamicIslandContentView);
            if (!bl3) continue;
            object2 = dynamicIslandContentView.getExpandedView();
            kotlin.jvm.internal.o.e((Object)object2, (String)"null cannot be cast to non-null type android.view.View");
            DynamicIslandBaseContentView.updateBackgroundBg$default(dynamicIslandContentView, (View)object2, false, 2, null);
        }
        DynamicIslandEventCoordinator dynamicIslandEventCoordinator = this.eventCoordinator;
        if (dynamicIslandEventCoordinator != null) {
            DynamicIslandEventCoordinator.dispatchEvent$default(dynamicIslandEventCoordinator, DynamicIslandEvent.ConfigChanged.INSTANCE, null, 2, null);
        }
        for (DynamicIslandContentFakeView dynamicIslandContentFakeView : this.fakeViewList) {
            if (dynamicIslandContentFakeView.getCurrentIslandData() != null) {
                f.b((f1.E)this.getWindowViewController().getUiScopeImmediate(), null, null, (U0.o)new U0.o(dynamicIslandContentFakeView, null){
                    final DynamicIslandContentFakeView $it;
                    int label;
                    {
                        this.$it = dynamicIslandContentFakeView;
                        super(2, d2);
                    }

                    public final d create(Object object, d d2) {
                        return new /* invalid duplicate definition of identical inner class */;
                    }

                    public final Object invoke(f1.E e2, d d2) {
                        return (this.create(e2, d2)).invokeSuspend(s.a);
                    }

                    /*
                     * Enabled force condition propagation
                     * Lifted jumps to return sites
                     */
                    public final Object invokeSuspend(Object object) {
                        Object object2 = L0.c.c();
                        int n2 = this.label;
                        if (n2 != 0) {
                            if (n2 != 1) throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            G0.k.b((Object)object);
                            return s.a;
                        } else {
                            G0.k.b((Object)object);
                            DynamicIslandContentFakeView dynamicIslandContentFakeView = this.$it;
                            object = dynamicIslandContentFakeView.getCurrentIslandData();
                            this.label = 1;
                            if (dynamicIslandContentFakeView.updateView((DynamicIslandData)object, true, false, (d)this) != object2) return s.a;
                            return object2;
                        }
                    }
                }, (int)3, null);
            }
            bl = (object2 = dynamicIslandContentFakeView.getCurrentIslandData()) != null && (object2 = object2.getExtras()) != null ? object2.getBoolean("miui.focus.isPromoted", false) : false;
            kotlin.jvm.internal.o.d((Object)((Object)dynamicIslandContentFakeView));
            this.measureExpandedViewHeight(dynamicIslandContentFakeView);
            if (!bl3 && !bl) continue;
            object2 = dynamicIslandContentFakeView.getFakeExpandedView();
            kotlin.jvm.internal.o.e((Object)object2, (String)"null cannot be cast to non-null type android.view.View");
            DynamicIslandBaseContentView.updateBackgroundBg$default(dynamicIslandContentFakeView, (View)object2, false, 2, null);
        }
    }

    public void onFinishInflate() {
        super.onFinishInflate();
        View view = this.findViewById(R.id.glow_effect_bottom_container);
        kotlin.jvm.internal.o.f((Object)view, (String)"findViewById(...)");
        this.mGlowEffectBottomContainer = (ViewGroup)view;
        view = this.findViewById(R.id.glow_effect_top_container);
        kotlin.jvm.internal.o.f((Object)view, (String)"findViewById(...)");
        this.mGlowEffectTopContainer = (ViewGroup)view;
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (motionEvent == null) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        Object object = new TouchEvent(motionEvent, "dynamic_island");
        f.b((f1.E)LifecycleOwnerKt.getLifecycleScope((LifecycleOwner)this), null, null, (U0.o)new U0.o(this, (TouchEvent)object, null){
            final TouchEvent $touchEvent;
            int label;
            final DynamicIslandWindowView this$0;
            {
                this.this$0 = dynamicIslandWindowView;
                this.$touchEvent = touchEvent;
                super(2, d2);
            }

            public final d create(Object object, d d2) {
                return new /* invalid duplicate definition of identical inner class */;
            }

            public final Object invoke(f1.E e2, d d2) {
                return (this.create(e2, d2)).invokeSuspend(s.a);
            }

            /*
             * Enabled force condition propagation
             * Lifted jumps to return sites
             */
            public final Object invokeSuspend(Object object) {
                Object object2 = L0.c.c();
                int n2 = this.label;
                if (n2 != 0) {
                    if (n2 != 1) throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    G0.k.b((Object)object);
                    return s.a;
                } else {
                    G0.k.b((Object)object);
                    object = DynamicIslandWindowView.access$get_onInterceptTouchEvent$p(this.this$0);
                    TouchEvent touchEvent = this.$touchEvent;
                    this.label = 1;
                    if (object.emit((Object)touchEvent, (d)this) != object2) return s.a;
                    return object2;
                }
            }
        }, (int)3, null);
        object = ((TouchEvent)object).getResult();
        boolean bl = object != null ? ((Boolean)object).booleanValue() : super.onInterceptTouchEvent(motionEvent);
        return bl;
    }

    public final void onIslandTempHide(boolean bl, DynamicIslandWindowState.TempHiddenType tempHiddenType) {
        DynamicIslandEventCoordinator dynamicIslandEventCoordinator = this.eventCoordinator;
        if (dynamicIslandEventCoordinator != null) {
            DynamicIslandEvent.IslandTempHiddenChanged islandTempHiddenChanged = DynamicIslandEvent.IslandTempHiddenChanged.INSTANCE;
            islandTempHiddenChanged.setHide(bl);
            islandTempHiddenChanged.setType(tempHiddenType);
            DynamicIslandEventCoordinator.dispatchEvent$default(dynamicIslandEventCoordinator, islandTempHiddenChanged, null, 2, null);
        }
    }

    public final void onKeyguardShowing(boolean bl) {
        DynamicIslandEventCoordinator dynamicIslandEventCoordinator = this.eventCoordinator;
        if (dynamicIslandEventCoordinator != null) {
            dynamicIslandEventCoordinator.onKeyguardShowing(bl);
        }
        this.currentKeyguardShowing = bl;
    }

    public final void onLongPress(DynamicIslandBaseContentView object, DynamicIslandContentView object2, float f2) {
        kotlin.jvm.internal.o.g((Object)object, (String)"view");
        if (this.isDisableShare()) {
            object2 = ((DynamicIslandBaseContentView)((Object)object)).getAnimatorDelegate();
            if (object2 != null) {
                object = (object = ((DynamicIslandBaseContentView)((Object)object)).getDynamicIslandEventCoordinator()) != null ? ((DynamicIslandEventCoordinator)object).getBigIsLandAndSmallIsLandList() : null;
                ((DynamicIslandAnimationDelegate)object2).isLandDragShake((List<DynamicIslandContentView>)object);
            }
            return;
        }
        object2 = new o((DynamicIslandBaseContentView)((Object)object), (DynamicIslandContentView)((Object)object2), f2);
        object.postDelayed((Runnable)object2, 20L);
        this.longPress = object2;
    }

    public final void onPanelExpandedRatio(float f2) {
        DynamicIslandEventCoordinator dynamicIslandEventCoordinator = this.eventCoordinator;
        if (dynamicIslandEventCoordinator != null) {
            DynamicIslandEvent.PanelExpandedRatio panelExpandedRatio = DynamicIslandEvent.PanelExpandedRatio.INSTANCE;
            panelExpandedRatio.setBlurRatio(f2);
            DynamicIslandEventCoordinator.dispatchEvent$default(dynamicIslandEventCoordinator, panelExpandedRatio, null, 2, null);
        }
    }

    @SuppressLint(value={"ClickableViewAccessibility"})
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent == null) {
            return super.onTouchEvent(motionEvent);
        }
        Object object = new TouchEvent(motionEvent, "dynamic_island");
        f.b((f1.E)LifecycleOwnerKt.getLifecycleScope((LifecycleOwner)this), null, null, (U0.o)new U0.o(this, (TouchEvent)object, null){
            final TouchEvent $touchEvent;
            int label;
            final DynamicIslandWindowView this$0;
            {
                this.this$0 = dynamicIslandWindowView;
                this.$touchEvent = touchEvent;
                super(2, d2);
            }

            public final d create(Object object, d d2) {
                return new /* invalid duplicate definition of identical inner class */;
            }

            public final Object invoke(f1.E e2, d d2) {
                return (this.create(e2, d2)).invokeSuspend(s.a);
            }

            /*
             * Enabled force condition propagation
             * Lifted jumps to return sites
             */
            public final Object invokeSuspend(Object object) {
                Object object2 = L0.c.c();
                int n2 = this.label;
                if (n2 != 0) {
                    if (n2 != 1) throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    G0.k.b((Object)object);
                    return s.a;
                } else {
                    G0.k.b((Object)object);
                    object = DynamicIslandWindowView.access$get_onTouchEvent$p(this.this$0);
                    TouchEvent touchEvent = this.$touchEvent;
                    this.label = 1;
                    if (object.emit((Object)touchEvent, (d)this) != object2) return s.a;
                    return object2;
                }
            }
        }, (int)3, null);
        object = ((TouchEvent)object).getResult();
        boolean bl = object != null ? ((Boolean)object).booleanValue() : super.onTouchEvent(motionEvent);
        return bl;
    }

    public void onUserChanged(int n2, Context object) {
        kotlin.jvm.internal.o.g((Object)object, (String)"userContext");
        int n3 = this.currentUserId;
        object = new StringBuilder();
        ((StringBuilder)object).append("onUserChanged: ");
        ((StringBuilder)object).append(n3);
        ((StringBuilder)object).append("   ");
        ((StringBuilder)object).append(n2);
        Log.e((String)TAG, (String)((StringBuilder)object).toString());
        f.b((f1.E)this.getWindowViewController().getUiScopeImmediate(), null, null, (U0.o)new U0.o(this, n2, null){
            final int $newUser;
            int label;
            final DynamicIslandWindowView this$0;
            {
                this.this$0 = dynamicIslandWindowView;
                this.$newUser = n2;
                super(2, d2);
            }

            public final d create(Object object, d d2) {
                return new /* invalid duplicate definition of identical inner class */;
            }

            public final Object invoke(f1.E e2, d d2) {
                return (this.create(e2, d2)).invokeSuspend(s.a);
            }

            public final Object invokeSuspend(Object object) {
                L0.c.c();
                if (this.label == 0) {
                    G0.k.b((Object)object);
                    Object object22 = new ArrayList<E>(DynamicIslandWindowView.access$getDynamicIslandDataList$p(this.this$0));
                    object = this.this$0;
                    object22 = object22.iterator();
                    while (object22.hasNext()) {
                        ((DynamicIslandWindowView)((Object)object)).removeDynamicIslandData((DynamicIslandData)object22.next(), CommonUtils.INSTANCE.getIS_TABLET(), false);
                    }
                    this.this$0.setCurrentUserId(this.$newUser);
                    object = DynamicIslandWindowView.access$getDynamicIslandDataList$p(this.this$0).iterator();
                    while (object.hasNext()) {
                        object22 = ((DynamicIslandData)object.next()).getProperties();
                        if (object22 == null || object22.intValue() != 0) continue;
                        object.remove();
                    }
                    object22 = new ArrayList(DynamicIslandWindowView.access$getDynamicIslandDataList$p(this.this$0));
                    object = this.this$0;
                    for (Object object22 : object22) {
                        kotlin.jvm.internal.o.d((Object)object22);
                        ((DynamicIslandWindowView)((Object)object)).addDynamicIslandData((DynamicIslandData)object22, false, ((DynamicIslandWindowView)((Object)object)).getWindowViewController().getIslandMaxWidth(), ((DynamicIslandWindowView)((Object)object)).getWindowViewController().getCutoutY(), false);
                    }
                    object = this.this$0;
                    DynamicIslandWindowView.access$onDeviceNotificationChanged((DynamicIslandWindowView)((Object)object), DynamicIslandWindowView.access$hasDeviceNotification((DynamicIslandWindowView)((Object)object)));
                    return s.a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }, (int)3, null);
    }

    public final void onWindowAnimExtendLifetimeEnd(DynamicIslandContentView dynamicIslandContentView) {
        DynamicIslandEventCoordinator dynamicIslandEventCoordinator = this.eventCoordinator;
        if (dynamicIslandEventCoordinator != null) {
            dynamicIslandContentView = dynamicIslandContentView != null && (dynamicIslandContentView = dynamicIslandContentView.getCurrentIslandData()) != null ? dynamicIslandContentView.getExtras() : null;
            dynamicIslandEventCoordinator.onWindowAnimExtendLifetimeEnd((Bundle)dynamicIslandContentView);
        }
    }

    public final void onWindowAnimExtendLifetimeStart(DynamicIslandContentView dynamicIslandContentView) {
        DynamicIslandEventCoordinator dynamicIslandEventCoordinator = this.eventCoordinator;
        if (dynamicIslandEventCoordinator != null) {
            dynamicIslandContentView = dynamicIslandContentView != null && (dynamicIslandContentView = dynamicIslandContentView.getCurrentIslandData()) != null ? dynamicIslandContentView.getExtras() : null;
            dynamicIslandEventCoordinator.onWindowAnimExtendLifetimeStart((Bundle)dynamicIslandContentView);
        }
    }

    public final void preRemoveDynamicIsland(DynamicIslandContentView dynamicIslandContentView, DynamicIslandState dynamicIslandState) {
        if (dynamicIslandState instanceof DynamicIslandState.Deleted && (dynamicIslandState).getDeleteByAddNew()) {
            dynamicIslandContentView = dynamicIslandContentView != null ? dynamicIslandContentView.getCurrentIslandData() : null;
            DynamicIslandWindowView.removeDynamicIslandData$default(this, (DynamicIslandData)dynamicIslandContentView, false, false, 6, null);
        }
    }

    public final void removeDynamicIslandData(DynamicIslandData dynamicIslandData, boolean bl, boolean bl2) {
        Object var5_4 = null;
        String string = dynamicIslandData != null ? dynamicIslandData.getKey() : null;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("removeDynamicIslandData ");
        stringBuilder.append(string);
        Log.d((String)TAG, (String)stringBuilder.toString());
        string = var5_4;
        if (dynamicIslandData != null) {
            string = dynamicIslandData.getKey();
        }
        if (string == null) {
            return;
        }
        f.b((f1.E)this.getWindowViewController().getUiScopeImmediate(), null, null, (U0.o)new U0.o(this, dynamicIslandData, bl2, bl, null){
            final DynamicIslandData $dynamicIslandData;
            final boolean $noAnimation;
            final boolean $removeFromList;
            Object L$0;
            Object L$1;
            Object L$2;
            Object L$3;
            boolean Z$0;
            boolean Z$1;
            int label;
            final DynamicIslandWindowView this$0;
            {
                this.this$0 = dynamicIslandWindowView;
                this.$dynamicIslandData = dynamicIslandData;
                this.$removeFromList = bl;
                this.$noAnimation = bl2;
                super(2, d2);
            }

            public final d create(Object object, d d2) {
                return new /* invalid duplicate definition of identical inner class */;
            }

            public final Object invoke(f1.E e2, d d2) {
                return (this.create(e2, d2)).invokeSuspend(s.a);
            }

            /*
             * Loose catch block
             * WARNING - void declaration
             * Enabled aggressive block sorting
             * Enabled unnecessary exception pruning
             * Enabled aggressive exception aggregation
             */
            public final Object invokeSuspend(Object object) {
                void var1_4;
                Object object2;
                Object object3;
                Object object4;
                block19: {
                    Object object5;
                    block20: {
                        block17: {
                            boolean bl;
                            boolean bl2;
                            Object object6;
                            block18: {
                                object6 = L0.c.c();
                                int n2 = this.label;
                                if (n2 != 0) {
                                    if (n2 != 1) {
                                        if (n2 != 2) {
                                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                        }
                                        object4 = (a)this.L$1;
                                        object5 = (a)this.L$0;
                                        object3 = object4;
                                        object2 = object5;
                                        G0.k.b((Object)object);
                                        object = object5;
                                        break block17;
                                    }
                                    bl2 = this.Z$1;
                                    bl = this.Z$0;
                                    object4 = (DynamicIslandData)this.L$3;
                                    object5 = (DynamicIslandWindowView)((Object)this.L$2);
                                    a a2 = (a)this.L$1;
                                    object3 = (a)this.L$0;
                                    object2 = object3;
                                    G0.k.b((Object)object);
                                    object2 = a2;
                                    object = object3;
                                    object3 = object5;
                                    break block18;
                                }
                                G0.k.b((Object)object);
                                object3 = DynamicIslandWindowView.access$getKeyLocks$p(this.this$0);
                                object4 = this.$dynamicIslandData.getKey();
                                object2 = object3.get(object4);
                                object = object2;
                                if (object2 == null && (object2 = object3.putIfAbsent(object4, object = c.b((boolean)false, (int)1, null))) != null) {
                                    object = object2;
                                }
                                object = (a)object;
                                object2 = object;
                                try {
                                    kotlin.jvm.internal.o.d((Object)object);
                                    object2 = object;
                                    object5 = this.this$0;
                                    object2 = object;
                                    object3 = this.$dynamicIslandData;
                                    object2 = object;
                                    bl = this.$removeFromList;
                                    object2 = object;
                                    bl2 = this.$noAnimation;
                                    object2 = object;
                                    this.L$0 = object;
                                    object2 = object;
                                    this.L$1 = object;
                                    object2 = object;
                                    this.L$2 = object5;
                                    object2 = object;
                                    this.L$3 = object3;
                                    object2 = object;
                                    this.Z$0 = bl;
                                    object2 = object;
                                    this.Z$1 = bl2;
                                    object2 = object;
                                    this.label = 1;
                                    object2 = object;
                                    object4 = object.a(null, (d)this);
                                    if (object4 == object6) {
                                        return object6;
                                    }
                                }
                                catch (Throwable throwable) {
                                    break block19;
                                }
                                object2 = object;
                                object = object2;
                                object4 = object3;
                                object3 = object5;
                            }
                            object4 = object4.getKey();
                            this.L$0 = object;
                            this.L$1 = object2;
                            this.L$2 = null;
                            this.L$3 = null;
                            this.label = 2;
                            object3 = DynamicIslandWindowView.removeDynamicIslandDataSuspend$default((DynamicIslandWindowView)((Object)object3), (String)object4, bl, bl2, false, (d)this, 8, null);
                            if (object3 == object6) {
                                return object6;
                            }
                            object4 = object2;
                        }
                        object3 = object4;
                        object2 = object;
                        try {
                            object5 = s.a;
                            object2 = object;
                        }
                        catch (Throwable throwable) {
                            object5 = object3;
                            object = object2;
                            break block20;
                        }
                        try {
                            object4.c(null);
                        }
                        catch (Throwable throwable) {}
                        object2 = this.$dynamicIslandData.getKey();
                        object3 = new StringBuilder();
                        ((StringBuilder)object3).append("removeDynamicIslandData: end ");
                        ((StringBuilder)object3).append((String)object2);
                        Log.d((String)"DynamicIslandWindowViewImpl", (String)((StringBuilder)object3).toString());
                        object3 = this.this$0;
                        object2 = this.$dynamicIslandData.getKey();
                        kotlin.jvm.internal.o.d((Object)object);
                        DynamicIslandWindowView.access$releaseMutexIfIdle((DynamicIslandWindowView)((Object)object3), object2, (a)object);
                        return s.a;
                        catch (Throwable throwable) {
                            object5 = object2;
                            object4 = throwable;
                        }
                    }
                    object2 = object;
                    object5.c(null);
                    object2 = object;
                    throw object4;
                }
                object4 = this.$dynamicIslandData.getKey();
                object3 = new StringBuilder();
                ((StringBuilder)object3).append("removeDynamicIslandData: end ");
                ((StringBuilder)object3).append((String)object4);
                Log.d((String)"DynamicIslandWindowViewImpl", (String)((StringBuilder)object3).toString());
                object4 = this.this$0;
                object3 = this.$dynamicIslandData.getKey();
                kotlin.jvm.internal.o.d(object2);
                DynamicIslandWindowView.access$releaseMutexIfIdle((DynamicIslandWindowView)((Object)object4), (String)object3, object2);
                throw var1_4;
            }
        }, (int)3, null);
    }

    public final void removeExtendLifetime(String string) {
        kotlin.jvm.internal.o.g((Object)string, (String)"key");
        DynamicIslandEventCoordinator dynamicIslandEventCoordinator = this.eventCoordinator;
        if (dynamicIslandEventCoordinator != null) {
            dynamicIslandEventCoordinator.removeExtendLifetime(string);
        }
    }

    public final void removeNotification(StatusBarNotification statusBarNotification) {
        kotlin.jvm.internal.o.g((Object)statusBarNotification, (String)"sbn");
        DynamicIslandWindowViewController.DynamicIslandCallback dynamicIslandCallback = this.getWindowViewController().getDynamicIslandCallback();
        if (dynamicIslandCallback != null) {
            dynamicIslandCallback.removeNotification(statusBarNotification);
        }
    }

    public final List<DynamicIslandContentView> requestHasIsland(String list) {
        kotlin.jvm.internal.o.g((Object)list, (String)"pkg");
        DynamicIslandEventCoordinator dynamicIslandEventCoordinator = this.eventCoordinator;
        list = dynamicIslandEventCoordinator != null ? dynamicIslandEventCoordinator.hasIsland((String)((Object)list)) : null;
        return list;
    }

    public final void resetHeadsUpLocation() {
        Log.d((String)TAG, (String)"resetHeadsUpLocation");
        Bundle bundle = new Bundle();
        bundle.putString("action_key", "action_location_changed_for_heads_up");
        bundle.putBoolean("extra_is_expand", false);
        bundle.putInt("extra_island_bottom", 0);
        DynamicIslandContent.DynamicIslandViewChangedListener dynamicIslandViewChangedListener = this.listener;
        if (dynamicIslandViewChangedListener != null) {
            dynamicIslandViewChangedListener.onIslandViewChanged(bundle);
        }
    }

    public final void setAnimRunning(boolean bl, boolean bl2) {
        DynamicIslandEventCoordinator dynamicIslandEventCoordinator = this.eventCoordinator;
        if (dynamicIslandEventCoordinator != null) {
            dynamicIslandEventCoordinator.updateWindowHeightInAnimState(bl, bl2);
        }
        if (!bl && (dynamicIslandEventCoordinator = this.eventCoordinator) != null) {
            dynamicIslandEventCoordinator.onAnimationFinished();
        }
    }

    public final void setClosingToExpanded(DynamicIslandContentView dynamicIslandBaseContentView, boolean bl, boolean bl2) {
        if (dynamicIslandBaseContentView != null && (dynamicIslandBaseContentView = dynamicIslandBaseContentView.getFakeView()) != null) {
            ((DynamicIslandContentFakeView)dynamicIslandBaseContentView).setClosingToExpanded(bl, bl2);
        }
    }

    public final void setContentViewList(CopyOnWriteArrayList<DynamicIslandContentView> copyOnWriteArrayList) {
        kotlin.jvm.internal.o.g(copyOnWriteArrayList, (String)"<set-?>");
        this.contentViewList = copyOnWriteArrayList;
    }

    public final void setCurrentUserId(int n2) {
        this.currentUserId = n2;
    }

    public final void setDownInWhichButton(String string) {
        this.downInWhichButton = string;
    }

    public final void setEffectSize(Rect rect) {
        kotlin.jvm.internal.o.g((Object)rect, (String)"rect");
    }

    public final void setEventCoordinator(DynamicIslandEventCoordinator dynamicIslandEventCoordinator) {
        this.eventCoordinator = dynamicIslandEventCoordinator;
    }

    public final void setHeadsUpHeight(int n2) {
        this._headsUpHeight = n2;
        if (n2 == 0 && this.touchOutsideInHeadsUp) {
            this.post(new m(this));
            this.touchOutsideInHeadsUp = false;
        }
    }

    public final void setLight(boolean bl) {
        this.isLight = bl;
    }

    public final void setPendingMediaView(DynamicIslandContentView dynamicIslandContentView) {
        this.pendingMediaView = dynamicIslandContentView;
    }

    public final void setSupportMiniWindowEndPositionChange(boolean bl) {
        this.supportMiniWindowEndPositionChange = bl;
    }

    public final void setTouchOutsideInHeadsUp(boolean bl) {
        this.touchOutsideInHeadsUp = bl;
    }

    public final void setViewComponent(DynamicIslandViewComponent dynamicIslandViewComponent) {
        kotlin.jvm.internal.o.g((Object)dynamicIslandViewComponent, (String)"value");
        if (this._viewComponent == null) {
            this._viewComponent = dynamicIslandViewComponent;
            this.initEventCoordinator();
            return;
        }
        throw new IllegalStateException("DynamicIslandViewComponent was already initialized.");
    }

    public final boolean touchInHeadsUpZone(int n2) {
        boolean bl;
        DynamicIslandEventCoordinator dynamicIslandEventCoordinator = this.eventCoordinator;
        boolean bl2 = bl = false;
        if (dynamicIslandEventCoordinator != null) {
            dynamicIslandEventCoordinator = dynamicIslandEventCoordinator.getHeadsUpZone();
            bl2 = bl;
            if (dynamicIslandEventCoordinator != null) {
                if ((dynamicIslandEventCoordinator = (i)dynamicIslandEventCoordinator.getValue()) == null) {
                    bl2 = bl;
                } else {
                    bl2 = bl;
                    if (((Number)dynamicIslandEventCoordinator.d()).intValue() != 0) {
                        bl2 = bl;
                        if (((Number)dynamicIslandEventCoordinator.e()).intValue() != 0) {
                            bl2 = bl;
                            if (n2 > ((Number)dynamicIslandEventCoordinator.d()).intValue()) {
                                bl2 = bl;
                                if (n2 < ((Number)dynamicIslandEventCoordinator.e()).intValue()) {
                                    bl2 = true;
                                }
                            }
                        }
                    }
                }
            }
        }
        return bl2;
    }

    public final void updateAppAnimatingView(boolean bl) {
        if (bl) {
            for (DynamicIslandContentView dynamicIslandContentView : this.contentViewList) {
                Object object = this.eventCoordinator;
                if (object == null || !object.islandAppAnimating(dynamicIslandContentView)) continue;
                object = dynamicIslandContentView.getRealView();
                if (object != null) {
                    object.setVisibility(0);
                }
                object = dynamicIslandContentView.getRealView();
                object = object != null ? ((DynamicIslandBaseContentView)((Object)object)).getBackgroundView() : null;
                if (object != null) {
                    ((DynamicIslandBackgroundView)((Object)object)).setVisibility(0);
                }
                object = dynamicIslandContentView.getFakeView();
                if (object == null) continue;
                ((DynamicIslandContentFakeView)((Object)object)).setVisibility(4);
            }
        }
    }

    public final void updateAppCloseRect(Rect object, DynamicIslandContentView dynamicIslandContentView) {
        Object object2 = new StringBuilder();
        ((StringBuilder)object2).append("updateAppCloseRect : ");
        ((StringBuilder)object2).append(object);
        Log.e((String)"DynamicIslandAnimDebug", (String)((StringBuilder)object2).toString());
        if (dynamicIslandContentView != null && (object2 = dynamicIslandContentView.getCurrentIslandData()) != null && (object2 = object2.getExtras()) != null) {
            object2.putParcelable("position", (Parcelable)object);
        }
        if ((object2 = this.eventCoordinator) != null) {
            object = dynamicIslandContentView != null && (object = dynamicIslandContentView.getCurrentIslandData()) != null ? object.getExtras() : null;
            ((DynamicIslandEventCoordinator)object2).positionChanged((Bundle)object);
        }
    }

    @SuppressLint(value={"UseCompatLoadingForDrawables"})
    public final void updateDarkLightMode(boolean bl) {
        this.isLight = bl;
        for (DynamicIslandContentView dynamicIslandContentView : this.contentViewList) {
        }
    }

    public final void updateDynamicIslandView(DynamicIslandData dynamicIslandData, boolean bl, float f2, boolean bl2) {
        kotlin.jvm.internal.o.g((Object)dynamicIslandData, (String)"dynamicIslandData");
        String string = dynamicIslandData.getKey();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("updateDynamicIslandView ");
        stringBuilder.append(string);
        Log.e((String)TAG, (String)stringBuilder.toString());
        if (dynamicIslandData.getKey() == null) {
            return;
        }
        f.b((f1.E)this.getWindowViewController().getUiScopeImmediate(), null, null, (U0.o)new U0.o(this, dynamicIslandData, bl, f2, bl2, null){
            final DynamicIslandData $dynamicIslandData;
            final boolean $expanded;
            final float $maxWidth;
            final boolean $reInflated;
            float F$0;
            Object L$0;
            Object L$1;
            Object L$2;
            Object L$3;
            boolean Z$0;
            boolean Z$1;
            int label;
            final DynamicIslandWindowView this$0;
            {
                this.this$0 = dynamicIslandWindowView;
                this.$dynamicIslandData = dynamicIslandData;
                this.$expanded = bl;
                this.$maxWidth = f2;
                this.$reInflated = bl2;
                super(2, d2);
            }

            public final d create(Object object, d d2) {
                return new /* invalid duplicate definition of identical inner class */;
            }

            public final Object invoke(f1.E e2, d d2) {
                return (this.create(e2, d2)).invokeSuspend(s.a);
            }

            /*
             * Loose catch block
             * WARNING - void declaration
             * Enabled aggressive block sorting
             * Enabled unnecessary exception pruning
             * Enabled aggressive exception aggregation
             */
            public final Object invokeSuspend(Object object) {
                void var1_4;
                Object object2;
                Object object3;
                Object object4;
                block19: {
                    Object object5;
                    block20: {
                        block17: {
                            boolean bl;
                            float f2;
                            boolean bl2;
                            Object object6;
                            block18: {
                                object6 = L0.c.c();
                                int n2 = this.label;
                                if (n2 != 0) {
                                    if (n2 != 1) {
                                        if (n2 != 2) {
                                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                        }
                                        object4 = (a)this.L$1;
                                        object5 = (a)this.L$0;
                                        object3 = object4;
                                        object2 = object5;
                                        G0.k.b((Object)object);
                                        object = object5;
                                        break block17;
                                    }
                                    bl2 = this.Z$1;
                                    f2 = this.F$0;
                                    bl = this.Z$0;
                                    object4 = (DynamicIslandData)this.L$3;
                                    object5 = (DynamicIslandWindowView)((Object)this.L$2);
                                    a a2 = (a)this.L$1;
                                    object3 = (a)this.L$0;
                                    object2 = object3;
                                    G0.k.b((Object)object);
                                    object = object3;
                                    object2 = a2;
                                    object3 = object5;
                                    break block18;
                                }
                                G0.k.b((Object)object);
                                object4 = DynamicIslandWindowView.access$getKeyLocks$p(this.this$0);
                                object3 = this.$dynamicIslandData.getKey();
                                object2 = object4.get(object3);
                                object = object2;
                                if (object2 == null && (object2 = object4.putIfAbsent(object3, object = c.b((boolean)false, (int)1, null))) != null) {
                                    object = object2;
                                }
                                object3 = (a)object;
                                object2 = object3;
                                try {
                                    kotlin.jvm.internal.o.d((Object)object3);
                                    object2 = object3;
                                    object5 = this.this$0;
                                    object2 = object3;
                                    object4 = this.$dynamicIslandData;
                                    object2 = object3;
                                    bl = this.$expanded;
                                    object2 = object3;
                                    f2 = this.$maxWidth;
                                    object2 = object3;
                                    bl2 = this.$reInflated;
                                    object2 = object3;
                                    this.L$0 = object3;
                                    object2 = object3;
                                    this.L$1 = object3;
                                    object2 = object3;
                                    this.L$2 = object5;
                                    object2 = object3;
                                    this.L$3 = object4;
                                    object2 = object3;
                                    this.Z$0 = bl;
                                    object2 = object3;
                                    this.F$0 = f2;
                                    object2 = object3;
                                    this.Z$1 = bl2;
                                    object2 = object3;
                                    this.label = 1;
                                    object2 = object3;
                                    object = object3.a(null, (d)this);
                                    if (object == object6) {
                                        return object6;
                                    }
                                }
                                catch (Throwable throwable) {
                                    break block19;
                                }
                                object = object3;
                                object2 = object3;
                                object3 = object5;
                            }
                            this.L$0 = object;
                            this.L$1 = object2;
                            this.L$2 = null;
                            this.L$3 = null;
                            this.label = 2;
                            object3 = DynamicIslandWindowView.access$updateDynamicIslandViewSuspend((DynamicIslandWindowView)((Object)object3), (DynamicIslandData)object4, bl, f2, false, bl2, (d)this);
                            if (object3 == object6) {
                                return object6;
                            }
                            object4 = object2;
                        }
                        object3 = object4;
                        object2 = object;
                        try {
                            object5 = s.a;
                            object2 = object;
                        }
                        catch (Throwable throwable) {
                            object4 = object3;
                            object = object2;
                            break block20;
                        }
                        try {
                            object4.c(null);
                        }
                        catch (Throwable throwable) {}
                        object2 = this.$dynamicIslandData.getKey();
                        object3 = new StringBuilder();
                        ((StringBuilder)object3).append("updateDynamicIslandView end ");
                        ((StringBuilder)object3).append((String)object2);
                        Log.e((String)"DynamicIslandWindowViewImpl", (String)((StringBuilder)object3).toString());
                        object2 = this.this$0;
                        object3 = this.$dynamicIslandData.getKey();
                        kotlin.jvm.internal.o.d((Object)object);
                        DynamicIslandWindowView.access$releaseMutexIfIdle(object2, (String)object3, (a)object);
                        return s.a;
                        catch (Throwable throwable) {
                            object4 = object2;
                            object5 = throwable;
                        }
                    }
                    object2 = object;
                    object4.c(null);
                    object2 = object;
                    throw object5;
                }
                object4 = this.$dynamicIslandData.getKey();
                object3 = new StringBuilder();
                ((StringBuilder)object3).append("updateDynamicIslandView end ");
                ((StringBuilder)object3).append((String)object4);
                Log.e((String)"DynamicIslandWindowViewImpl", (String)((StringBuilder)object3).toString());
                object3 = this.this$0;
                object4 = this.$dynamicIslandData.getKey();
                kotlin.jvm.internal.o.d(object2);
                DynamicIslandWindowView.access$releaseMutexIfIdle((DynamicIslandWindowView)((Object)object3), (String)object4, object2);
                throw var1_4;
            }
        }, (int)3, null);
    }

    public final void updateExpandedViewScaleForFreeform(DynamicIslandContentView dynamicIslandBaseContentView, Float f2, boolean bl) {
        if (f2 != null) {
            float f3 = ((Number)f2).floatValue();
            if (dynamicIslandBaseContentView != null && (dynamicIslandBaseContentView = dynamicIslandBaseContentView.getFakeView()) != null) {
                ((DynamicIslandContentFakeView)dynamicIslandBaseContentView).updateExpandedViewScaleForFreeform(f3, bl);
            }
        }
    }

    public final void updateFVOffsetYWhenMWAnimating(DynamicIslandContentView dynamicIslandBaseContentView, Float f2) {
        if (f2 != null && dynamicIslandBaseContentView != null && (dynamicIslandBaseContentView = dynamicIslandBaseContentView.getFakeView()) != null) {
            ((DynamicIslandContentFakeView)dynamicIslandBaseContentView).updateFVOffsetYWhenMWAnimating(f2.floatValue());
        }
    }

    public final void updateFreeformFakeView(DynamicIslandContentView dynamicIslandContentView) {
        DynamicIslandEventCoordinator dynamicIslandEventCoordinator = this.eventCoordinator;
        if (dynamicIslandEventCoordinator != null) {
            Bundle bundle = null;
            DynamicIslandContentFakeView dynamicIslandContentFakeView = dynamicIslandContentView != null ? dynamicIslandContentView.getFakeView() : null;
            Bundle bundle2 = bundle;
            if (dynamicIslandContentView != null) {
                DynamicIslandData dynamicIslandData = dynamicIslandContentView.getCurrentIslandData();
                bundle2 = bundle;
                if (dynamicIslandData != null) {
                    bundle2 = dynamicIslandData.getExtras();
                }
            }
            dynamicIslandEventCoordinator.updateFreeformFakeView(dynamicIslandContentFakeView, dynamicIslandContentView, bundle2);
        }
    }

    public final void updateHeadsUpZone(int n2) {
        int n3;
        this.setHeadsUpHeight(n2);
        Object object = this.getCurrentExpandedState();
        if (object != null && n2 != 0) {
            n3 = ((DynamicIslandBaseContentView)((Object)object)).getExpandedViewY();
            int n4 = (int)((float)((DynamicIslandBaseContentView)((Object)object)).getIslandViewHeight() * ((float)((DynamicIslandBaseContentView)((Object)object)).getExpandedViewHeight() / (float)((DynamicIslandBaseContentView)((Object)object)).getIslandViewHeight()));
            object = DynamicIslandUtils.INSTANCE;
            Context context = this.getContext();
            kotlin.jvm.internal.o.f((Object)context, (String)"getContext(...)");
            n3 = n3 + n4 + ((DynamicIslandUtils)object).dpToPx(8, context);
            n4 = n2 + n3;
            n2 = n3;
            n3 = n4;
        } else {
            n2 = 0;
            n3 = 0;
        }
        object = this.eventCoordinator;
        if (object != null) {
            ((DynamicIslandEventCoordinator)object).updateHeadsUpZone(new i((Object)n2, (Object)n3));
        }
    }

    public final void updateIslandWindowAnimRunningState(boolean bl, DynamicIslandContentView dynamicIslandContentView, boolean bl2) {
        DynamicIslandEventCoordinator dynamicIslandEventCoordinator = this.eventCoordinator;
        if (dynamicIslandEventCoordinator != null) {
            dynamicIslandEventCoordinator.updateIslandWindowAnimRunning(bl, dynamicIslandContentView, bl2);
        }
    }

    public final void updatePkgSupportFreeform(String string) {
        kotlin.jvm.internal.o.g((Object)string, (String)"pkg");
        DynamicIslandEventCoordinator dynamicIslandEventCoordinator = this.eventCoordinator;
        if (dynamicIslandEventCoordinator != null) {
            Context context = this.getContext();
            kotlin.jvm.internal.o.f((Object)context, (String)"getContext(...)");
            dynamicIslandEventCoordinator.updatePkgSupportFreeform(string, context);
        }
    }

    public final void updateStatusBarVisible(boolean bl) {
        DynamicIslandEventCoordinator dynamicIslandEventCoordinator = this.eventCoordinator;
        if (dynamicIslandEventCoordinator != null) {
            dynamicIslandEventCoordinator.updateStatusBarVisible(bl);
        }
    }

    public final void updateViewStateWhenCloseEnd(DynamicIslandContentView dynamicIslandContentView, boolean bl, String string) {
        kotlin.jvm.internal.o.g((Object)string, (String)"from");
        f.b((f1.E)this.getWindowViewController().getUiScope(), null, null, (U0.o)new U0.o(dynamicIslandContentView, bl, string, null){
            final String $from;
            final boolean $isFreeform;
            final DynamicIslandContentView $state;
            int label;
            {
                this.$state = dynamicIslandContentView;
                this.$isFreeform = bl;
                this.$from = string;
                super(2, d2);
            }

            public final d create(Object object, d d2) {
                return new /* invalid duplicate definition of identical inner class */;
            }

            public final Object invoke(f1.E e2, d d2) {
                return (this.create(e2, d2)).invokeSuspend(s.a);
            }

            public final Object invokeSuspend(Object object) {
                L0.c.c();
                if (this.label == 0) {
                    G0.k.b((Object)object);
                    object = this.$state;
                    if (object != null) {
                        ((DynamicIslandContentView)((Object)object)).updateViewStateWhenCloseEnd();
                    }
                    if ((object = this.$state) != null && (object = ((DynamicIslandBaseContentView)((Object)object)).getFakeView()) != null) {
                        ((DynamicIslandContentFakeView)((Object)object)).updateViewStateWhenCloseEnd(this.$isFreeform, this.$from);
                    }
                    return s.a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }, (int)3, null);
    }

    public final void updateViewStateWhenOpenAnimStart(DynamicIslandContentView dynamicIslandContentView) {
        Object object;
        if (dynamicIslandContentView != null && (object = dynamicIslandContentView.getFakeView()) != null) {
            ((DynamicIslandContentFakeView)((Object)object)).updateViewStateWhenOpenAnimStart();
        }
        if ((object = this.eventCoordinator) != null) {
            ((DynamicIslandEventCoordinator)object).updateAppExpandedStateWhenAnimStart(dynamicIslandContentView);
        }
    }
}
