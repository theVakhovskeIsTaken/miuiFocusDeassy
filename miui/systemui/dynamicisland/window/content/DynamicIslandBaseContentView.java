/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  G0.i
 *  G0.k
 *  G0.s
 *  H0.r
 *  H0.u
 *  K0.d
 *  L0.c
 *  M0.b
 *  M0.d
 *  U.d
 *  android.annotation.SuppressLint
 *  android.app.Notification
 *  android.app.PendingIntent
 *  android.app.WindowConfiguration
 *  android.content.Context
 *  android.content.Intent
 *  android.content.res.Configuration
 *  android.graphics.Color
 *  android.graphics.Rect
 *  android.graphics.RectF
 *  android.graphics.drawable.Drawable
 *  android.graphics.drawable.GradientDrawable
 *  android.os.Bundle
 *  android.service.notification.StatusBarNotification
 *  android.text.TextUtils
 *  android.util.AttributeSet
 *  android.util.Log
 *  android.util.MiuiMultiWindowUtils
 *  android.view.DisplayCutout
 *  android.view.View
 *  android.view.View$OnAttachStateChangeListener
 *  android.view.ViewGroup$LayoutParams
 *  android.view.ViewGroup$MarginLayoutParams
 *  android.view.ViewStub
 *  android.widget.FrameLayout
 *  android.widget.LinearLayout
 *  androidx.annotation.CallSuper
 *  androidx.core.graphics.ColorUtils
 *  b1.f
 *  com.airbnb.lottie.LottieAnimationView
 *  com.android.systemui.plugins.miui.dynamicisland.DynamicIslandData
 *  i1.I
 *  i1.K
 *  i1.h
 *  i1.u
 *  kotlin.jvm.internal.h
 *  kotlin.jvm.internal.o
 *  miui.systemui.animation.FolmeKt
 *  miui.systemui.controlcenter.ConfigUtils
 *  miui.systemui.util.CommonUtils
 *  miui.systemui.util.MiBlurCompat
 *  miui.systemui.util.SystemBarUtilsCompat
 *  miui.systemui.util.WindowConfigurationCompat
 *  miui.systemui.util.liveupdate.PromotedNotificationParamUtils
 *  miuix.animation.base.AnimConfig
 *  miuix.animation.controller.AnimState
 *  miuix.animation.listener.TransitionListener
 *  miuix.animation.property.ViewProperty
 *  miuix.core.util.MiShadowUtils
 */
package miui.systemui.dynamicisland.window.content;

import G0.i;
import G0.k;
import G0.s;
import H0.r;
import H0.u;
import L0.c;
import M0.b;
import U.d;
import android.annotation.SuppressLint;
import android.app.Notification;
import android.app.PendingIntent;
import android.app.WindowConfiguration;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.service.notification.StatusBarNotification;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.util.MiuiMultiWindowUtils;
import android.view.DisplayCutout;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.annotation.CallSuper;
import androidx.core.graphics.ColorUtils;
import b1.f;
import com.airbnb.lottie.LottieAnimationView;
import com.android.systemui.plugins.miui.dynamicisland.DynamicIslandData;
import i1.I;
import i1.K;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import kotlin.jvm.internal.h;
import kotlin.jvm.internal.o;
import miui.systemui.animation.FolmeKt;
import miui.systemui.controlcenter.ConfigUtils;
import miui.systemui.dynamicisland.DynamicIslandAnimUtils;
import miui.systemui.dynamicisland.DynamicIslandBackgroundView;
import miui.systemui.dynamicisland.DynamicIslandUtils;
import miui.systemui.dynamicisland.R;
import miui.systemui.dynamicisland.anim.DynamicIslandAnimationDelegate;
import miui.systemui.dynamicisland.data.repository.DynamicIslandSizeRepository;
import miui.systemui.dynamicisland.event.DynamicIslandEventCoordinator;
import miui.systemui.dynamicisland.event.DynamicIslandState;
import miui.systemui.dynamicisland.event.WindowAnimState;
import miui.systemui.dynamicisland.event.handler.BigIslandStateHandler;
import miui.systemui.dynamicisland.event.handler.ExpandedStateHandler;
import miui.systemui.dynamicisland.model.IslandTemplate;
import miui.systemui.dynamicisland.view.DynamicIslandBigIslandView;
import miui.systemui.dynamicisland.view.DynamicIslandExpandedView;
import miui.systemui.dynamicisland.window.DynamicIslandViewModel;
import miui.systemui.dynamicisland.window.DynamicIslandWindowState;
import miui.systemui.dynamicisland.window.DynamicIslandWindowView;
import miui.systemui.dynamicisland.window.DynamicIslandWindowViewController;
import miui.systemui.dynamicisland.window.content.DynamicIslandBaseContentView;
import miui.systemui.dynamicisland.window.content.DynamicIslandBaseContentViewController;
import miui.systemui.dynamicisland.window.content.DynamicIslandContentFakeView;
import miui.systemui.dynamicisland.window.content.DynamicIslandContentView;
import miui.systemui.dynamicisland.window.content.helpers.DynamicIslandContentViewBaseHelper;
import miui.systemui.dynamicisland.window.content.helpers.DynamicIslandContentViewPadHelper;
import miui.systemui.dynamicisland.window.content.helpers.DynamicIslandContentViewPhoneHelper;
import miui.systemui.util.CommonUtils;
import miui.systemui.util.MiBlurCompat;
import miui.systemui.util.SystemBarUtilsCompat;
import miui.systemui.util.WindowConfigurationCompat;
import miui.systemui.util.liveupdate.PromotedNotificationParamUtils;
import miuix.animation.base.AnimConfig;
import miuix.animation.controller.AnimState;
import miuix.animation.listener.TransitionListener;
import miuix.animation.property.ViewProperty;
import miuix.core.util.MiShadowUtils;

public class DynamicIslandBaseContentView
extends FrameLayout {
    public static final Companion Companion = new Object(null){
        {
            this();
        }
    };
    private static final int DISABLE_TRAN_X = 2;
    private static final int DISABLE_TRAN_X_ANIMATION = 1;
    private static final int ENABLE_TRAN_X_ANIMATION = 0;
    private static final String TAG = "DynamicIslandBaseContentView";
    private DynamicIslandBaseContentViewController<?> _controller;
    private final i1.u _highlightColor;
    private final i1.u _isPressed;
    private final i1.u _islandAppAnimRunning;
    private final i1.u _islandFreeformAnimRunning;
    private DynamicIslandAnimationDelegate animatorDelegate;
    private DynamicIslandBackgroundView backgroundView;
    private float batteryWidth;
    private LinearLayout bigContainer;
    private FrameLayout bigIslandAreaLeft;
    private FrameLayout bigIslandAreaMargin;
    private FrameLayout bigIslandAreaRight;
    private int bigIslandLeftWidth;
    private int bigIslandLeftWidthHasSmallIsland;
    private int bigIslandMarginWidth;
    private int bigIslandMinWidth;
    private int bigIslandRightWidth;
    private int bigIslandRightWidthHasSmallIsland;
    private int bigIslandTransX;
    private DynamicIslandBigIslandView bigIslandView;
    private int bigIslandViewWidth;
    private int bigIslandViewWidthHasSmallIsland;
    private int bigIslandX;
    private int bigIslandXHasSmallIsland;
    private float clockWidth;
    private FrameLayout container;
    private DynamicIslandData currentIslandData;
    private float cutoutHeight;
    private int cutoutWidth;
    private float cutoutY;
    private int defaultCutoutWidth;
    private DynamicIslandEventCoordinator dynamicIslandEventCoordinator;
    private int expandedIslandWidth;
    private LottieAnimationView expandedLottieView;
    private DynamicIslandExpandedView expandedView;
    private int expandedViewHeight;
    private int expandedViewMarginHorizontal;
    private int expandedViewMaxHeight;
    private int expandedViewMaxWidth;
    private ViewStub expandedViewStub;
    private int expandedViewWidth;
    private int expandedViewY;
    private LinearLayout fakeBigContainer;
    private FrameLayout fakeBigIsland;
    private FrameLayout fakeContainer;
    private FrameLayout fakeExpandedView;
    private FrameLayout fakeFirstLayout;
    private View fakeMask;
    private FrameLayout fakeSecondLayout;
    private FrameLayout fakeSmallIsland;
    private DynamicIslandContentFakeView fakeView;
    private int headsUpStatusBarPadding;
    private boolean hideByFullScreenPkg;
    private final I highlightColor;
    private final I isPressed;
    private final I islandAppAnimRunning;
    private final I islandFreeformAnimRunning;
    private int islandViewHeight;
    private int islandViewMarginTop;
    private int islandWindowHeight;
    private DynamicIslandState lastState;
    private View.OnAttachStateChangeListener listener;
    private View mask;
    private float maxWidth;
    private float maxWidthTiny;
    private View miniBar;
    private final float miniBarHeight;
    private final float miniBarMarginBottom;
    private boolean miniBarVisible;
    private boolean openAppFromIsland;
    private float padIslandTransX;
    private int padMultiNotificationMargin;
    private Float pendingCutoutY;
    private DynamicIslandContentView realView;
    private final RectF roundedRect;
    private boolean showShade;
    private DynamicIslandSizeRepository sizeRepository;
    private FrameLayout smallContainer;
    private FrameLayout smallIslandView;
    private int smallIslandViewWidth;
    private final int space;
    private DynamicIslandState state;
    private int statusBarDatePosX;
    private int statusBarHeight;
    private float swipeDiffX;
    private i swipeInfo;
    private IslandTemplate template;
    private List<String> unsupportedExpandedViewSlidePackages;
    private final DynamicIslandViewModel viewModel;
    private WindowAnimState windowAnimState;

    public DynamicIslandBaseContentView(Context objectArray, AttributeSet object) {
        i1.u u2;
        i1.u u3;
        o.g((Object)objectArray, (String)"context");
        super((Context)objectArray, object);
        this.viewModel = new DynamicIslandViewModel();
        object = Float.valueOf(0.0f);
        this.swipeInfo = new i(object, object);
        this.expandedViewMaxWidth = objectArray.getResources().getDimensionPixelSize(R.dimen.expanded_max_width);
        this.expandedViewMaxHeight = objectArray.getResources().getDimensionPixelSize(R.dimen.expanded_max_height);
        this.smallIslandViewWidth = objectArray.getResources().getDimensionPixelSize(R.dimen.small_island_width);
        this.islandViewHeight = objectArray.getResources().getDimensionPixelSize(R.dimen.island_height);
        this.space = objectArray.getResources().getDimensionPixelSize(R.dimen.island_space);
        this.padMultiNotificationMargin = objectArray.getResources().getDimensionPixelSize(R.dimen.island_pad_multi_notification_margin);
        this.windowAnimState = WindowAnimState.Idle.INSTANCE;
        object = Boolean.FALSE;
        this._isPressed = u3 = K.a((Object)object);
        this._highlightColor = u2 = K.a(null);
        this.isPressed = i1.h.b((i1.u)u3);
        this.highlightColor = i1.h.b((i1.u)u2);
        this._islandFreeformAnimRunning = u2 = K.a((Object)object);
        this.islandFreeformAnimRunning = i1.h.b((i1.u)u2);
        object = K.a((Object)object);
        this._islandAppAnimRunning = object;
        this.islandAppAnimRunning = i1.h.b((i1.u)object);
        this.unsupportedExpandedViewSlidePackages = new ArrayList<String>();
        this.defaultCutoutWidth = objectArray.getResources().getDimensionPixelSize(R.dimen.cutout_width);
        object = this.unsupportedExpandedViewSlidePackages;
        objectArray = objectArray.getResources().getStringArray(R.array.unsupported_expanded_view_slide_packages);
        o.f((Object)objectArray, (String)"getStringArray(...)");
        r.u((Collection)object, (Object[])objectArray);
        this.roundedRect = new RectF(0.0f, 0.0f, (float)this.bigIslandViewWidth, (float)this.islandViewHeight);
        this.miniBarMarginBottom = this.getResources().getDimension(R.dimen.mini_window_bar_marginBottom);
        this.miniBarHeight = this.getResources().getDimension(R.dimen.mini_window_bar_height);
    }

    public /* synthetic */ DynamicIslandBaseContentView(Context context, AttributeSet attributeSet, int n, h h2) {
        if ((n & 2) != 0) {
            attributeSet = null;
        }
        this(context, attributeSet);
    }

    private final float calculateSwipeRatio(float f2) {
        float f3 = 1.0f;
        DynamicIslandUtils dynamicIslandUtils = DynamicIslandUtils.INSTANCE;
        Context context = this.getContext();
        o.f((Object)context, (String)"getContext(...)");
        return f3 - Math.max(0.0f, f3 - Math.min(1.0f, Math.abs(f2 / (float)dynamicIslandUtils.getScreenWidthOld(context))));
    }

    private final boolean canExpandedViewSlide(DynamicIslandContentView object) {
        int n;
        Object object2;
        Object var9_2 = null;
        Object object3 = object != null ? ((DynamicIslandBaseContentView)((Object)object)).getState() : null;
        if (!(object3 instanceof DynamicIslandState.Expanded)) {
            Log.d((String)TAG, (String)"can not Slide: state not expanded");
            return false;
        }
        object3 = this.dynamicIslandEventCoordinator;
        if (object3 != null && ((DynamicIslandEventCoordinator)object3).getKeyguardShowing()) {
            Log.d((String)TAG, (String)"can not Slide: keyguardShowing");
            return false;
        }
        object3 = this.dynamicIslandEventCoordinator;
        if (object3 != null && (object3 = ((DynamicIslandEventCoordinator)object3).getWindowView()) != null && (object3 = ((DynamicIslandWindowView)((Object)object3)).getWindowViewController()) != null && (object3 = ((DynamicIslandWindowViewController)object3).getWindowState()) != null && (object3 = ((DynamicIslandWindowState)object3).getControlCenterExpanded()) != null && ((Boolean)object3.getValue()).booleanValue()) {
            Log.d((String)TAG, (String)"can not Slide: controlCenterExpanded");
            return false;
        }
        object3 = ((DynamicIslandBaseContentView)((Object)object)).getCurrentIslandData();
        object3 = object3 != null && (object3 = object3.getExtras()) != null ? object3.getString("miui.pkg.name") : null;
        Object object4 = this.currentIslandData;
        Integer n2 = object4 != null && (object4 = object4.getExtras()) != null ? Integer.valueOf(object4.getInt("miui.user.id")) : null;
        object4 = this.currentIslandData;
        Object object5 = object4 != null && (object4 = object4.getExtras()) != null ? (StatusBarNotification)object4.getParcelable("miui.sbn", StatusBarNotification.class) : null;
        if (PromotedNotificationParamUtils.isNotificationPromotedOngoing(object5)) {
            Log.d((String)TAG, (String)"can not Slide: isNotificationPromotedOngoing");
            return false;
        }
        object = (object = ((DynamicIslandBaseContentView)((Object)object)).getCurrentIslandData()) != null && (object = object.getExtras()) != null ? (PendingIntent)object.getParcelable("miui.pending.intent", PendingIntent.class) : null;
        object4 = object5 != null ? ((object4 = object5.getNotification()) != null ? ((Notification)object4).contentIntent : null) : object;
        Intent intent = object4 != null ? object4.getIntent() : null;
        object4 = object3;
        if (intent != null) {
            object4 = DynamicIslandUtils.INSTANCE;
            object2 = this.getContext();
            o.f((Object)object2, (String)"getContext(...)");
            object4 = ((DynamicIslandUtils)object4).isIntentActivityExist((Context)object2, intent, (String)object3);
            object2 = new StringBuilder();
            ((StringBuilder)object2).append("pkg: ");
            ((StringBuilder)object2).append((String)object3);
            ((StringBuilder)object2).append(", pakName: ");
            ((StringBuilder)object2).append((String)object4);
            Log.d((String)TAG, (String)((StringBuilder)object2).toString());
        }
        if (u.F(this.unsupportedExpandedViewSlidePackages, (Object)object4)) {
            Log.d((String)TAG, (String)"can not Slide: smartHome or aliPayGPhone");
            return false;
        }
        object3 = this.getContext();
        o.f((Object)object3, (String)"getContext(...)");
        if (CommonUtils.isTinyScreen((Context)object3)) {
            Log.d((String)TAG, (String)"can not Slide: isTinyScreen");
            return false;
        }
        if (((Boolean)this.getController().getWorkBenchModeState().isWorkbenchModeEnabled().getValue()).booleanValue()) {
            Log.d((String)TAG, (String)"can not Slide: WorkbenchMode");
            return false;
        }
        object3 = this.dynamicIslandEventCoordinator;
        object3 = object3 != null ? ((DynamicIslandEventCoordinator)object3).getLastFullScreenActivityPkg() : null;
        if (o.c((Object)object3, (Object)object4)) {
            object = new StringBuilder();
            ((StringBuilder)object).append("can not Slide: lastFullScreenActivityPkg ");
            ((StringBuilder)object).append((String)object4);
            Log.d((String)TAG, (String)((StringBuilder)object).toString());
            this.hideByFullScreenPkg = true;
            return false;
        }
        object3 = this.dynamicIslandEventCoordinator;
        if (object3 != null && (object3 = ((DynamicIslandEventCoordinator)object3).getWindowView()) != null && (object3 = ((DynamicIslandWindowView)((Object)object3)).getWindowViewController()) != null && (object3 = ((DynamicIslandWindowViewController)object3).getWindowState()) != null && (object3 = ((DynamicIslandWindowState)object3).getScreenPinning()) != null && ((Boolean)object3.getValue()).booleanValue()) {
            Log.d((String)TAG, (String)"can not Slide: screenPinningActive");
            return false;
        }
        if (!DynamicIslandAnimUtils.INSTANCE.getSUPPORT_FREEFORM()) {
            Log.d((String)TAG, (String)"can not Slide: device not support freeform");
            return false;
        }
        if (!MiuiMultiWindowUtils.multiFreeFormSupported((Context)this.getContext())) {
            object3 = WindowConfigurationCompat.INSTANCE;
            object2 = this.getContext().getResources().getConfiguration();
            o.f((Object)object2, (String)"getConfiguration(...)");
            object2 = object3.getWindowConfigurationCompat((Configuration)object2);
            n = object2 != null && (object2 = object3.getWindowingModeCompat((WindowConfiguration)object2)) != null ? (Integer)object2 : 0;
            if (o.c((Object)object3.inMultiWindowMode(n), (Object)Boolean.TRUE)) {
                object = new StringBuilder();
                ((StringBuilder)object).append("can not Slide: inMultiWindowMode ");
                ((StringBuilder)object).append(n);
                Log.d((String)TAG, (String)((StringBuilder)object).toString());
                return false;
            }
        }
        boolean bl = (object3 = this.dynamicIslandEventCoordinator) != null && (object3 = ((DynamicIslandEventCoordinator)object3).getWindowView()) != null && (object3 = ((DynamicIslandWindowView)((Object)object3)).getWindowViewController()) != null ? ((DynamicIslandWindowViewController)object3).getSupportMediaFreeform() : false;
        if (object != null && object4 != null) {
            if (!bl) {
                Log.d((String)TAG, (String)"can not Slide: systemui not SupportMediaFreeform");
                return false;
            }
            object3 = this.dynamicIslandEventCoordinator;
            if (object3 != null && !((DynamicIslandEventCoordinator)object3).mediaIslandSupportMiniWindow((String)object4)) {
                object = new StringBuilder();
                ((StringBuilder)object).append("can not Slide: mediaIsland not supportMiniWindow, ");
                ((StringBuilder)object).append((String)object4);
                Log.d((String)TAG, (String)((StringBuilder)object).toString());
                return false;
            }
        }
        if ((object3 = object5 != null && (object3 = object5.getNotification()) != null ? ((Notification)object3).contentIntent : null) == null && object == null) {
            Log.d((String)TAG, (String)"can not Slide: intent is null");
            return false;
        }
        object3 = object5 != null && (object3 = object5.getNotification()) != null ? ((Notification)object3).contentIntent : null;
        if (object3 != null && (object3 = object5.getNotification()) != null && (object3 = ((Notification)object3).contentIntent) != null && !object3.isActivity()) {
            Log.d((String)TAG, (String)"can not Slide: contentIntent is not activity");
            return false;
        }
        if (object != null && !object.isActivity()) {
            Log.d((String)TAG, (String)"can not Slide: pendingIntent is not activity");
            return false;
        }
        object = new Bundle();
        object.putString("action_key", "action_has_pip_in_screen");
        object3 = this.dynamicIslandEventCoordinator;
        object = object3 != null && (object3 = ((DynamicIslandEventCoordinator)object3).getDynamicIslandViewChangedListener()) != null ? object3.onIslandViewChanged((Bundle)object) : null;
        object = object != null ? object.getString("extra_package_pip_in_screen") : null;
        if (o.c((Object)object, (Object)object4)) {
            Log.d((String)TAG, (String)"can not Slide: in pip state");
            return false;
        }
        object3 = DynamicIslandUtils.INSTANCE;
        object = this.getContext();
        o.f((Object)object, (String)"getContext(...)");
        if (((DynamicIslandUtils)object3).isSplitPkg((String)object4, (Context)object)) {
            object = new StringBuilder();
            ((StringBuilder)object).append("can not Slide: isSplitPkg ");
            ((StringBuilder)object).append((String)object4);
            Log.d((String)TAG, (String)((StringBuilder)object).toString());
            return false;
        }
        if (((DynamicIslandUtils)object3).isPinMode((String)object4, intent)) {
            Log.d((String)TAG, (String)"can not Slide: isPinMode");
            return false;
        }
        this.packageSupportFreeform((String)object4);
        object = this.dynamicIslandEventCoordinator;
        bl = object != null && (object = ((DynamicIslandEventCoordinator)object).getPkgSupportFreeform()) != null ? o.c(object.get(object4), (Object)Boolean.TRUE) : false;
        if (!bl) {
            object = new StringBuilder();
            ((StringBuilder)object).append("can not Slide: pkg notSupportFreeform: ");
            ((StringBuilder)object).append((String)object4);
            Log.d((String)TAG, (String)((StringBuilder)object).toString());
            return false;
        }
        object = var9_2;
        if (object4 != null) {
            object5 = this.dynamicIslandEventCoordinator;
            object = var9_2;
            if (object5 != null) {
                object = ((DynamicIslandEventCoordinator)object5).isDynamicIslandMiniWindowBlackList((String)object4);
            }
        }
        if (o.c((Object)object, (Object)Boolean.TRUE)) {
            object = this.getContext();
            o.f((Object)object, (String)"getContext(...)");
            if (!((DynamicIslandUtils)object3).activitySupportFreeform((Context)object, intent)) {
                Log.d((String)TAG, (String)"blackList and activity not isResizeableMode");
                return false;
            }
        }
        object = this.getContext();
        o.f((Object)object, (String)"getContext(...)");
        if (!((DynamicIslandUtils)object3).isAppInstalledForUser((Context)object, (String)object4, n2)) {
            Log.d((String)TAG, (String)"can not Slide: not isAppInstalledForUser");
            return false;
        }
        if (object4 != null && n2 != null && (n = (object = this.dynamicIslandEventCoordinator) != null && ((DynamicIslandEventCoordinator)object).isInLockMode((String)object4, n2) ? 1 : 0) != 0) {
            Log.d((String)TAG, (String)"can not Slide: in Locked ");
            return false;
        }
        return true;
    }

    private final float computeBigIslandTx(int n, int n2, int n3, int n4) {
        int n5;
        int n6;
        Object object;
        block5: {
            float f2;
            block6: {
                object = this.getHelper();
                object = object != null ? Integer.valueOf(object.getIslandHeight()) : null;
                Object object2 = this.dynamicIslandEventCoordinator;
                int n7 = 0;
                boolean bl = object2 != null && (object2 = ((DynamicIslandEventCoordinator)object2).getWindowView()) != null && (object2 = ((DynamicIslandWindowView)((Object)object2)).getWindowViewController()) != null ? ((DynamicIslandWindowViewController)object2).isRealCutoutHeightDevice() : false;
                f2 = this.getContext().getResources().getDimension(R.dimen.delta_padding);
                n6 = this.getContext().getResources().getDimensionPixelSize(R.dimen.island_area_padding);
                n5 = n7;
                if (!bl) break block5;
                int n8 = this.islandViewHeight;
                if (object == null) break block6;
                n5 = n7;
                if (n8 == (Integer)object) break block5;
            }
            n5 = (int)f2;
        }
        n5 = n6 + n5;
        object = this.getContext();
        o.f((Object)object, (String)"getContext(...)");
        if (CommonUtils.isLayoutRtl((Context)object)) {
            n3 = n + n2 - (n3 + n4);
            n = n2 == n4 ? -n3 : (n3 != 0 ? n5 : Math.min(n5, n2 - n4));
            object = new StringBuilder();
            ((StringBuilder)object).append("Rtl updateBigIslandLayout,  diff: ");
            ((StringBuilder)object).append(n3);
            ((StringBuilder)object).append(", padding: ");
            ((StringBuilder)object).append(n5);
            ((StringBuilder)object).append(", translationX: ");
            ((StringBuilder)object).append(n);
            Log.d((String)TAG, (String)((StringBuilder)object).toString());
        } else {
            n = (n3 = n - n3) != 0 ? -n5 : (n2 == n4 ? -n3 : -Math.min(n5, n2 - n4));
            object = new StringBuilder();
            ((StringBuilder)object).append("updateBigIslandLayout,  diff: ");
            ((StringBuilder)object).append(n3);
            ((StringBuilder)object).append(", padding: ");
            ((StringBuilder)object).append(n5);
            ((StringBuilder)object).append(", translationX: ");
            ((StringBuilder)object).append(n);
            Log.d((String)TAG, (String)((StringBuilder)object).toString());
        }
        return n;
    }

    private final void doBigIslandAnim(int n, int n2, int n3, float f2, FrameLayout frameLayout, FrameLayout frameLayout2, LinearLayout linearLayout, FrameLayout frameLayout3, DynamicIslandContentView dynamicIslandContentView, boolean bl, int n4) {
        DynamicIslandContentFakeView dynamicIslandContentFakeView;
        AnimConfig animConfig = new AnimConfig();
        AnimConfig animConfig2 = new AnimConfig().addListeners(new TransitionListener[]{new TransitionListener(this, bl, n, n2){
            final boolean $isFakeView;
            final int $leftWidth;
            final int $rightWidth;
            final DynamicIslandBaseContentView this$0;
            {
                this.this$0 = dynamicIslandBaseContentView;
                this.$isFakeView = bl;
                this.$leftWidth = n;
                this.$rightWidth = n2;
            }

            public void onBegin(Object object) {
                super.onBegin(object);
                this.this$0.getController().getIslandTemplateFactory().updateCutoutWidth(this.this$0.getCurrentIslandData(), this.this$0.getFixedCutoutWidth(), this.$isFakeView);
                this.this$0.getController().getIslandTemplateFactory().updateLeftWidth(this.this$0.getCurrentIslandData(), this.$leftWidth, this.$isFakeView);
                this.this$0.getController().getIslandTemplateFactory().updateRightWidth(this.this$0.getCurrentIslandData(), this.$rightWidth, this.$isFakeView);
            }
        }});
        if (bl && (dynamicIslandContentView == null || (dynamicIslandContentFakeView = dynamicIslandContentView.getFakeView()) == null || dynamicIslandContentFakeView.getVisibility() != 0)) {
            if (frameLayout != null && (frameLayout = FolmeKt.getFolme((View)frameLayout)) != null && (frameLayout = frameLayout.state()) != null) {
                frameLayout.setTo((Object)new AnimState().add(ViewProperty.WIDTH, n, new long[0]), new AnimConfig[]{animConfig});
            }
            if (frameLayout2 != null && (frameLayout = FolmeKt.getFolme((View)frameLayout2)) != null && (frameLayout = frameLayout.state()) != null) {
                frameLayout.setTo((Object)new AnimState().add(ViewProperty.WIDTH, n2, new long[0]), new AnimConfig[]{animConfig2});
            }
            if (linearLayout != null && (frameLayout = FolmeKt.getFolme((View)linearLayout)) != null && (frameLayout = frameLayout.state()) != null) {
                frameLayout.setTo((Object)new AnimState().add(ViewProperty.WIDTH, n3, new long[0]), new AnimConfig[]{animConfig});
            }
            if (n4 != 0) {
                if (n4 == 1 && frameLayout3 != null && (frameLayout = FolmeKt.getFolme((View)frameLayout3)) != null && (frameLayout = frameLayout.state()) != null) {
                    frameLayout.resetTo(new Object[]{ViewProperty.TRANSLATION_X, Float.valueOf(f2)});
                }
            } else if (frameLayout3 != null && (frameLayout = FolmeKt.getFolme((View)frameLayout3)) != null && (frameLayout = frameLayout.state()) != null) {
                frameLayout.setTo((Object)new AnimState().add(ViewProperty.TRANSLATION_X, f2, new long[0]), new AnimConfig[]{animConfig});
            }
        } else {
            if (frameLayout != null && (frameLayout = FolmeKt.getFolme((View)frameLayout)) != null && (frameLayout = frameLayout.state()) != null) {
                frameLayout.to((Object)new AnimState().add(ViewProperty.WIDTH, n, new long[0]), new AnimConfig[]{animConfig});
            }
            if (frameLayout2 != null && (frameLayout = FolmeKt.getFolme((View)frameLayout2)) != null && (frameLayout = frameLayout.state()) != null) {
                frameLayout.to((Object)new AnimState().add(ViewProperty.WIDTH, n2, new long[0]), new AnimConfig[]{animConfig2});
            }
            if (linearLayout != null && (frameLayout = FolmeKt.getFolme((View)linearLayout)) != null && (frameLayout = frameLayout.state()) != null) {
                frameLayout.to((Object)new AnimState().add(ViewProperty.WIDTH, n3, new long[0]), new AnimConfig[]{animConfig});
            }
            if (n4 != 0) {
                if (n4 == 1 && frameLayout3 != null && (frameLayout = FolmeKt.getFolme((View)frameLayout3)) != null && (frameLayout = frameLayout.state()) != null) {
                    frameLayout.resetTo(new Object[]{ViewProperty.TRANSLATION_X, Float.valueOf(f2)});
                }
            } else if (frameLayout3 != null && (frameLayout = FolmeKt.getFolme((View)frameLayout3)) != null && (frameLayout = frameLayout.state()) != null) {
                frameLayout.to((Object)new AnimState().add(ViewProperty.TRANSLATION_X, f2, new long[0]), new AnimConfig[]{animConfig});
            }
        }
        if ((frameLayout = dynamicIslandContentView != null ? dynamicIslandContentView.getFakeView() : null) != null) {
            frameLayout.setBigIslandTx(f2);
        }
    }

    public static /* synthetic */ Rect getBigIslandRect$default(DynamicIslandBaseContentView dynamicIslandBaseContentView, Boolean bl, int n, Object object) {
        if (object == null) {
            if ((n & 1) != 0) {
                bl = null;
            }
            return dynamicIslandBaseContentView.getBigIslandRect(bl);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getBigIslandRect");
    }

    public static /* synthetic */ int getCurrentBigIslandWidth$default(DynamicIslandBaseContentView dynamicIslandBaseContentView, Boolean bl, int n, Object object) {
        if (object == null) {
            if ((n & 1) != 0) {
                bl = null;
            }
            return dynamicIslandBaseContentView.getCurrentBigIslandWidth(bl);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getCurrentBigIslandWidth");
    }

    public static /* synthetic */ int getCurrentBigIslandX$default(DynamicIslandBaseContentView dynamicIslandBaseContentView, Boolean bl, int n, Object object) {
        if (object == null) {
            if ((n & 1) != 0) {
                bl = null;
            }
            return dynamicIslandBaseContentView.getCurrentBigIslandX(bl);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getCurrentBigIslandX");
    }

    private final void hideExpandedLottie() {
        LottieAnimationView lottieAnimationView = this.expandedLottieView;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("hideIslandLayout ");
        stringBuilder.append(lottieAnimationView);
        Log.d((String)TAG, (String)stringBuilder.toString());
        stringBuilder = this.expandedLottieView;
        if (stringBuilder != null) {
            stringBuilder.pauseAnimation();
        }
    }

    private final void packageSupportFreeform(String string) {
        if (string != null) {
            Object object = this.dynamicIslandEventCoordinator;
            object = object != null && (object = ((DynamicIslandEventCoordinator)object).getPkgSupportFreeform()) != null ? (Boolean)((HashMap)object).get(string) : null;
            if (object == null && (object = this.dynamicIslandEventCoordinator) != null) {
                Context context = this.getContext();
                o.f((Object)context, (String)"getContext(...)");
                ((DynamicIslandEventCoordinator)object).updatePkgSupportFreeform(string, context);
            }
        }
    }

    private final void reset() {
        Object object = this.getHelper();
        if (object == null) {
            return;
        }
        this.defaultCutoutWidth = this.getContext().getResources().getDimensionPixelSize(R.dimen.cutout_width);
        int n = object.getIslandHeight();
        int n2 = this.getContext().getResources().getDimensionPixelSize(R.dimen.small_island_width);
        float f2 = this.getContext().getResources().getDimension(R.dimen.delta_height);
        object = this.dynamicIslandEventCoordinator;
        boolean bl = object != null && (object = ((DynamicIslandEventCoordinator)object).getWindowView()) != null && (object = ((DynamicIslandWindowView)((Object)object)).getWindowViewController()) != null ? ((DynamicIslandWindowViewController)object).isRealCutoutHeightDevice() : false;
        this.expandedViewMaxWidth = this.getContext().getResources().getDimensionPixelSize(R.dimen.expanded_max_width);
        this.expandedViewMaxHeight = this.getContext().getResources().getDimensionPixelSize(R.dimen.expanded_max_height);
        int n3 = n;
        if (bl) {
            n3 = f.c((int)n, (int)((int)(this.cutoutHeight + f2)));
        }
        this.islandViewHeight = n3;
        n3 = n2;
        if (bl) {
            n3 = f.c((int)n2, (int)((int)(this.cutoutHeight + f2)));
        }
        this.smallIslandViewWidth = n3;
        object = this.smallIslandView;
        Object var7_7 = null;
        if ((object = object != null ? object.getLayoutParams() : null) != null) {
            ((ViewGroup.LayoutParams)object).width = this.smallIslandViewWidth;
        }
        object = this.smallIslandView;
        object = object != null ? object.getLayoutParams() : null;
        if (object != null) {
            ((ViewGroup.LayoutParams)object).height = this.smallIslandViewWidth;
        }
        object = this.bigIslandView;
        object = object != null ? object.getLayoutParams() : null;
        if (object != null) {
            ((ViewGroup.LayoutParams)object).height = this.islandViewHeight;
        }
        FrameLayout frameLayout = this.fakeBigIsland;
        object = var7_7;
        if (frameLayout != null) {
            object = frameLayout.getLayoutParams();
        }
        if (object != null) {
            ((ViewGroup.LayoutParams)object).height = this.islandViewHeight;
        }
    }

    private final void showExpandedLottie() {
        Object object = this.currentIslandData;
        object = object != null && (object = object.getExtras()) != null ? Boolean.valueOf(object.getBoolean("miui.focus.lottieView.isPlay")) : null;
        LottieAnimationView lottieAnimationView = this.expandedLottieView;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("showExpandedLottie ");
        stringBuilder.append(lottieAnimationView);
        Log.d((String)TAG, (String)stringBuilder.toString());
        if (o.c((Object)object, (Object)Boolean.TRUE) && (object = this.expandedLottieView) != null) {
            object.playAnimation();
        }
    }

    public static /* synthetic */ void updateBackgroundBg$default(DynamicIslandBaseContentView dynamicIslandBaseContentView, View view, boolean bl, int n, Object object) {
        if (object == null) {
            if ((n & 2) != 0) {
                bl = false;
            }
            dynamicIslandBaseContentView.updateBackgroundBg(view, bl);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: updateBackgroundBg");
    }

    public static /* synthetic */ Object updateBigIslandView$suspendImpl(DynamicIslandBaseContentView dynamicIslandBaseContentView, DynamicIslandData dynamicIslandData, boolean bl, K0.d d2) {
        return b.a((boolean)false);
    }

    private final void updateExpandedLottieView() {
        Object object = this.currentIslandData;
        LottieAnimationView lottieAnimationView = null;
        object = object != null && (object = object.getExtras()) != null ? Integer.valueOf(object.getInt("miui.focus.lottieView.id")) : ((object = this.currentIslandData) != null && (object = object.getExtras()) != null ? Integer.valueOf(object.getInt("miui.focus.lottieView.fake.id")) : null);
        LottieAnimationView lottieAnimationView2 = lottieAnimationView;
        if (object != null) {
            int n = object.intValue();
            object = this.expandedView;
            if (object == null) {
                object = this.fakeExpandedView;
            }
            lottieAnimationView2 = lottieAnimationView;
            if (object != null) {
                lottieAnimationView2 = (LottieAnimationView)object.findViewById(n);
            }
        }
        this.expandedLottieView = lottieAnimationView2;
    }

    public static /* synthetic */ Object updateExpandedView$suspendImpl(DynamicIslandBaseContentView dynamicIslandBaseContentView, DynamicIslandData dynamicIslandData, boolean bl, K0.d d2) {
        return s.a;
    }

    private static final int updateMedianLuma$getStrokeColor(DynamicIslandBaseContentView dynamicIslandBaseContentView, float f2) {
        int n = dynamicIslandBaseContentView.getContext().getResources().getColor(R.color.stroke_color);
        f2 = f.h((float)(1.0f - f2), (float)0.0f, (float)1.0f);
        return ColorUtils.setAlphaComponent((int)n, (int)((int)((float)Color.alpha((int)n) * f2)));
    }

    public static /* synthetic */ Object updateSmallIslandView$suspendImpl(DynamicIslandBaseContentView dynamicIslandBaseContentView, DynamicIslandData dynamicIslandData, boolean bl, K0.d d2) {
        return s.a;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private final void updateTemplate(DynamicIslandData object) {
        Exception exception2;
        block2: {
            try {
                d d2 = new d();
                object = object != null && (object = object.getTickerData()) != null ? (IslandTemplate)d2.j((String)object, IslandTemplate.class) : null;
            }
            catch (Exception exception2) {
                break block2;
            }
            if (object == null) return;
            this.template = object;
            this._highlightColor.setValue((Object)object.getHighlightColor());
            return;
        }
        exception2.printStackTrace();
    }

    public static /* synthetic */ Object updateView$default(DynamicIslandBaseContentView dynamicIslandBaseContentView, DynamicIslandData dynamicIslandData, boolean bl, boolean bl2, K0.d d2, int n, Object object) {
        if (object == null) {
            if ((n & 4) != 0) {
                bl2 = true;
            }
            return dynamicIslandBaseContentView.updateView(dynamicIslandData, bl, bl2, d2);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: updateView");
    }

    private final void updateViewLayoutParams(View view, int n, int n2) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.width = n;
            layoutParams.height = n2;
            view.setLayoutParams(layoutParams);
        }
    }

    public void calculateBigIslandWidth() {
    }

    /*
     * WARNING - void declaration
     * Enabled aggressive block sorting
     */
    public final void calculateBigIslandY() {
        void var10_15;
        boolean bl;
        int n;
        int n2;
        int n3;
        int n4;
        Context context;
        int n5;
        int n6;
        CommonUtils commonUtils;
        Object object;
        block16: {
            block17: {
                block15: {
                    this.reset();
                    object = this.getResources();
                    commonUtils = CommonUtils.INSTANCE;
                    n6 = commonUtils.getIS_TABLET() ? R.dimen.island_pad_mini_y : R.dimen.island_mini_y;
                    n5 = object.getDimensionPixelSize(n6);
                    object = this.getResources();
                    context = this.getContext();
                    o.f((Object)context, (String)"getContext(...)");
                    n6 = commonUtils.getHorizontal(context) ? R.dimen.island_attribute_horizontal : R.dimen.island_attribute_vertical;
                    n4 = object.getDimensionPixelSize(n6);
                    n3 = this.getContext().getDisplay().getRotation();
                    object = this.dynamicIslandEventCoordinator;
                    n2 = 0;
                    n = 0;
                    bl = object != null && (object = ((DynamicIslandEventCoordinator)object).getWindowView()) != null && (object = ((DynamicIslandWindowView)((Object)object)).getWindowViewController()) != null ? ((DynamicIslandWindowViewController)object).isNotchScreenDevice() : false;
                    object = SystemBarUtilsCompat.INSTANCE;
                    context = this.getContext();
                    o.f((Object)context, (String)"getContext(...)");
                    object = object.getStatusBarHeightCompat(context);
                    n6 = object != null ? (Integer)object : 0;
                    this.statusBarHeight = n6;
                    if (!commonUtils.getIS_TABLET() || (object = this.currentIslandData) == null || (object = object.getProperties()) == null || (Integer)object != 0) break block15;
                    object = this.getContext();
                    o.f((Object)object, (String)"getContext(...)");
                    if (commonUtils.getHorizontal((Context)object)) break block15;
                    n6 = f.c((int)(this.statusBarHeight + n4), (int)n5);
                    break block16;
                }
                if (!commonUtils.getIS_TABLET() || (object = this.currentIslandData) == null || (object = object.getProperties()) == null || (Integer)object != 0) break block17;
                object = this.getContext();
                o.f((Object)object, (String)"getContext(...)");
                if (!commonUtils.getHorizontal((Context)object)) break block17;
                n6 = n4;
                if (n3 == 1) {
                    n6 = n4;
                    if (this.hasLargeNotchLikePhone()) {
                        n6 = f.c((int)((int)(this.cutoutY - (float)(this.islandViewHeight / 2))), (int)n5);
                    }
                }
                break block16;
            }
            if (commonUtils.getIS_TABLET()) {
                n4 = this.statusBarHeight;
                object = this.sizeRepository;
                n6 = object != null ? ((DynamicIslandSizeRepository)object).getStatusBarDateMarginTop() : 0;
                n6 = f.c((int)((n4 + n6 - this.islandViewHeight) / 2), (int)n5);
            } else {
                n6 = !bl ? f.c((int)((int)(this.cutoutY - (float)(this.islandViewHeight / 2))), (int)n5) : 0;
            }
        }
        this.islandViewMarginTop = n6;
        n3 = this.statusBarHeight;
        n4 = this.islandViewHeight;
        n6 = n3 > n6 + n4 ? n3 + this.getResources().getDimensionPixelSize(R.dimen.island_expanded_padding_top) : this.getResources().getDimensionPixelSize(R.dimen.island_expanded_padding_top_1) + (n6 + n4);
        this.expandedViewY = n6;
        if (commonUtils.getIS_TABLET() && (object = this.currentIslandData) != null && (object = object.getProperties()) != null && (Integer)object == 0) {
            object = DynamicIslandUtils.INSTANCE;
            context = this.getContext();
            o.f((Object)context, (String)"getContext(...)");
            n6 = ((DynamicIslandUtils)object).getScreenHeightOld(context);
        } else {
            n6 = this.expandedViewY;
        }
        this.islandWindowHeight = n6;
        bl = commonUtils.getIS_TABLET();
        object = null;
        if (bl) {
            DynamicIslandEventCoordinator dynamicIslandEventCoordinator = this.dynamicIslandEventCoordinator;
            if (dynamicIslandEventCoordinator != null && dynamicIslandEventCoordinator.hasTempShow()) {
                void var10_9;
                BigIslandStateHandler bigIslandStateHandler;
                DynamicIslandEventCoordinator dynamicIslandEventCoordinator2 = this.dynamicIslandEventCoordinator;
                if (dynamicIslandEventCoordinator2 != null && (bigIslandStateHandler = dynamicIslandEventCoordinator2.getBigIslandStateHandler()) != null) {
                    DynamicIslandContentView dynamicIslandContentView = bigIslandStateHandler.getCurrentTempShow();
                } else {
                    Object var10_8 = null;
                }
                n6 = var10_9 != null ? var10_9.getIslandViewMarginTop() : 0;
                if (var10_9 != null) {
                    n = var10_9.getIslandViewHeight();
                }
                this.expandedViewY = n6 + n + this.getResources().getDimensionPixelSize(R.dimen.island_pad_multi_notification_margin);
            } else {
                ConfigUtils configUtils = ConfigUtils.INSTANCE;
                context = this.getContext();
                o.f((Object)context, (String)"getContext(...)");
                if (configUtils.isLandscape(context)) {
                    DisplayCutout displayCutout = this.getContext().getDisplay().getCutout();
                    n6 = n2;
                    if (displayCutout != null) {
                        n6 = displayCutout.getSafeInsetTop();
                    }
                    this.expandedViewY = this.getResources().getDimensionPixelSize(R.dimen.island_pad_landscape_margin_top) + n5 + n6;
                }
            }
        }
        float f2 = this.cutoutY;
        float f3 = this.cutoutHeight;
        n = this.statusBarHeight;
        n2 = this.islandWindowHeight;
        n4 = this.islandViewHeight;
        n5 = this.islandViewMarginTop;
        n6 = this.expandedViewY;
        context = this.currentIslandData;
        Object object2 = object;
        if (context != null) {
            Integer n7 = context.getProperties();
        }
        object = new StringBuilder();
        ((StringBuilder)object).append("calculateBigIslandY ");
        ((StringBuilder)object).append(f2);
        ((StringBuilder)object).append(" ");
        ((StringBuilder)object).append(f3);
        ((StringBuilder)object).append(" ");
        ((StringBuilder)object).append(n);
        ((StringBuilder)object).append(" ");
        ((StringBuilder)object).append(n2);
        ((StringBuilder)object).append(" ");
        ((StringBuilder)object).append(n4);
        ((StringBuilder)object).append(" ");
        ((StringBuilder)object).append(n5);
        ((StringBuilder)object).append("  ");
        ((StringBuilder)object).append(n6);
        ((StringBuilder)object).append(" ");
        ((StringBuilder)object).append(var10_15);
        Log.e((String)TAG, (String)((StringBuilder)object).toString());
        this.updateMarginTop();
    }

    public final void cancelTransXAnim(float f2) {
        DynamicIslandBigIslandView dynamicIslandBigIslandView = this.bigIslandView;
        if (dynamicIslandBigIslandView != null && (dynamicIslandBigIslandView = FolmeKt.getFolme((View)dynamicIslandBigIslandView)) != null && (dynamicIslandBigIslandView = dynamicIslandBigIslandView.state()) != null) {
            dynamicIslandBigIslandView.resetTo(new Object[]{ViewProperty.TRANSLATION_X, Float.valueOf(f2)});
        }
    }

    public void clearShadow() {
    }

    public final DynamicIslandAnimationDelegate getAnimator(DynamicIslandAnimationDelegate.Factory factory) {
        o.g((Object)factory, (String)"factory");
        if (this.animatorDelegate == null) {
            this.animatorDelegate = factory.create(this);
        }
        return this.animatorDelegate;
    }

    public final DynamicIslandAnimationDelegate getAnimatorDelegate() {
        return this.animatorDelegate;
    }

    public final DynamicIslandBackgroundView getBackgroundView() {
        return this.backgroundView;
    }

    public final float getBatteryWidth() {
        return this.batteryWidth;
    }

    public final LinearLayout getBigContainer() {
        return this.bigContainer;
    }

    public final FrameLayout getBigIslandAreaLeft() {
        return this.bigIslandAreaLeft;
    }

    public final FrameLayout getBigIslandAreaMargin() {
        return this.bigIslandAreaMargin;
    }

    public final FrameLayout getBigIslandAreaRight() {
        return this.bigIslandAreaRight;
    }

    public final int getBigIslandLeftWidth() {
        return this.bigIslandLeftWidth;
    }

    public final int getBigIslandLeftWidthHasSmallIsland() {
        return this.bigIslandLeftWidthHasSmallIsland;
    }

    public final int getBigIslandMarginWidth() {
        return this.bigIslandMarginWidth;
    }

    public Rect getBigIslandPosition() {
        return new Rect();
    }

    public final Rect getBigIslandRect(Boolean bl) {
        int n;
        Rect rect = new Rect();
        rect.left = n = this.getCurrentBigIslandX(bl);
        rect.top = this.islandViewMarginTop;
        rect.right = n + this.getCurrentBigIslandWidth(bl);
        rect.bottom = rect.top + this.islandViewHeight;
        return rect;
    }

    public final int getBigIslandRightWidth() {
        return this.bigIslandRightWidth;
    }

    public final int getBigIslandRightWidthHasSmallIsland() {
        return this.bigIslandRightWidthHasSmallIsland;
    }

    public final int getBigIslandTransX() {
        return this.bigIslandTransX;
    }

    public final DynamicIslandBigIslandView getBigIslandView() {
        return this.bigIslandView;
    }

    public final int getBigIslandViewWidth() {
        return this.bigIslandViewWidth;
    }

    public final int getBigIslandViewWidthHasSmallIsland() {
        return this.bigIslandViewWidthHasSmallIsland;
    }

    public final int getBigIslandX() {
        return this.bigIslandX;
    }

    public final int getBigIslandXHasSmallIsland() {
        return this.bigIslandXHasSmallIsland;
    }

    public final float getClockWidth() {
        return this.clockWidth;
    }

    public final FrameLayout getContainer() {
        return this.container;
    }

    public DynamicIslandBaseContentViewController<?> getController() {
        DynamicIslandBaseContentViewController<?> dynamicIslandBaseContentViewController = this._controller;
        if (dynamicIslandBaseContentViewController != null) {
            return dynamicIslandBaseContentViewController;
        }
        throw new IllegalStateException("Accessing controller when not initialized.");
    }

    public final Integer getCurrentBigIslandViewWidth() {
        Object object = this.dynamicIslandEventCoordinator;
        object = object != null && (object = ((DynamicIslandEventCoordinator)object).getBigIslandStateHandler()) != null && (object = ((BigIslandStateHandler)object).getCurrent()) != null ? Integer.valueOf(((DynamicIslandBaseContentView)((Object)object)).getBigIslandViewWidth()) : null;
        return object;
    }

    public final int getCurrentBigIslandWidth(Boolean bl) {
        boolean bl2 = bl != null ? bl.booleanValue() : this.hasSmallIsland();
        int n = bl2 ? this.bigIslandViewWidthHasSmallIsland : this.bigIslandViewWidth;
        return n;
    }

    public final int getCurrentBigIslandX(Boolean comparable) {
        if (CommonUtils.INSTANCE.getIS_TABLET()) {
            int n;
            comparable = this.currentIslandData;
            if (comparable != null && (comparable = comparable.getProperties()) != null && (Integer)comparable == 0) {
                n = this.bigIslandX;
            } else {
                n = this.bigIslandX;
                n = this.bigIslandTransX + n;
            }
            return n;
        }
        boolean bl = comparable != null ? ((Boolean)comparable).booleanValue() : this.hasSmallIsland();
        int n = bl ? this.bigIslandXHasSmallIsland : this.bigIslandX;
        return n;
    }

    public final DynamicIslandData getCurrentIslandData() {
        return this.currentIslandData;
    }

    public final int getCutoutHeight() {
        int n = this.getContext().getResources().getDimensionPixelSize(R.dimen.cutout_height);
        Object object = this.dynamicIslandEventCoordinator;
        int n2 = n;
        if (object != null) {
            object = ((DynamicIslandEventCoordinator)object).getWindowView();
            n2 = n;
            if (object != null) {
                n2 = ((DynamicIslandWindowView)((Object)object)).getCutoutHeight();
            }
        }
        boolean bl = (object = this.dynamicIslandEventCoordinator) != null && (object = ((DynamicIslandEventCoordinator)object).getWindowView()) != null && (object = ((DynamicIslandWindowView)((Object)object)).getWindowViewController()) != null ? ((DynamicIslandWindowViewController)object).isNotchScreenDevice() : false;
        n = n2;
        if (bl) {
            n = (int)((double)n2 * 0.5);
        }
        return n;
    }

    public final float getCutoutRealHeight() {
        return this.cutoutHeight;
    }

    public final float getCutoutY() {
        return this.cutoutY;
    }

    public final DynamicIslandEventCoordinator getDynamicIslandEventCoordinator() {
        return this.dynamicIslandEventCoordinator;
    }

    public Rect getExpandedIslandRect() {
        return new Rect();
    }

    public final int getExpandedIslandWidth() {
        return this.expandedIslandWidth;
    }

    public final LottieAnimationView getExpandedLottieView() {
        return this.expandedLottieView;
    }

    public Rect getExpandedPosition() {
        return new Rect();
    }

    public final DynamicIslandExpandedView getExpandedView() {
        return this.expandedView;
    }

    public final int getExpandedViewHeight() {
        return this.expandedViewHeight;
    }

    public final int getExpandedViewMarginHorizontal() {
        return this.expandedViewMarginHorizontal;
    }

    public final int getExpandedViewMaxHeight() {
        return this.expandedViewMaxHeight;
    }

    public final int getExpandedViewMaxWidth() {
        return this.expandedViewMaxWidth;
    }

    public final ViewStub getExpandedViewStub() {
        return this.expandedViewStub;
    }

    public final int getExpandedViewWidth() {
        return this.expandedViewWidth;
    }

    public final int getExpandedViewY() {
        return this.expandedViewY;
    }

    public final LinearLayout getFakeBigContainer() {
        return this.fakeBigContainer;
    }

    public final FrameLayout getFakeBigIsland() {
        return this.fakeBigIsland;
    }

    public final FrameLayout getFakeContainer() {
        return this.fakeContainer;
    }

    public final FrameLayout getFakeExpandedView() {
        return this.fakeExpandedView;
    }

    public final FrameLayout getFakeFirstLayout() {
        return this.fakeFirstLayout;
    }

    public final View getFakeMask() {
        return this.fakeMask;
    }

    public final FrameLayout getFakeSecondLayout() {
        return this.fakeSecondLayout;
    }

    public final FrameLayout getFakeSmallIsland() {
        return this.fakeSmallIsland;
    }

    public final DynamicIslandContentFakeView getFakeView() {
        return this.fakeView;
    }

    public final int getFixedCutoutWidth() {
        int n = CommonUtils.INSTANCE.getIS_TABLET() && this.hasLargeNotchLikePhone() ? this.defaultCutoutWidth : this.getRealCutoutWidth();
        return n;
    }

    public final int getHeadsUpStatusBarPadding() {
        return this.headsUpStatusBarPadding;
    }

    public final DynamicIslandContentViewBaseHelper getHelper() {
        Object object = this.sizeRepository;
        if (object == null) {
            Log.e((String)TAG, (String)"sizeRepository \u4e3a\u7a7a.");
            return null;
        }
        DynamicIslandData dynamicIslandData = this.currentIslandData;
        boolean bl = dynamicIslandData != null ? DynamicIslandUtils.INSTANCE.isDynamicIslandPadNoPropOnce(dynamicIslandData) : false;
        if (bl) {
            Log.d((String)TAG, (String)"init helper Pad 1/2");
            dynamicIslandData = this.getContext();
            o.f((Object)dynamicIslandData, (String)"getContext(...)");
            object = new DynamicIslandContentViewPadHelper((Context)dynamicIslandData, (DynamicIslandSizeRepository)object);
        } else {
            Log.d((String)TAG, (String)"init helper Phone or Pad 0");
            dynamicIslandData = this.getContext();
            o.f((Object)dynamicIslandData, (String)"getContext(...)");
            object = new DynamicIslandContentViewPhoneHelper((Context)dynamicIslandData, (DynamicIslandSizeRepository)object);
        }
        return object;
    }

    public final boolean getHideByFullScreenPkg() {
        return this.hideByFullScreenPkg;
    }

    public final I getHighlightColor() {
        return this.highlightColor;
    }

    public final I getIslandAppAnimRunning() {
        return this.islandAppAnimRunning;
    }

    public final I getIslandFreeformAnimRunning() {
        return this.islandFreeformAnimRunning;
    }

    public final int getIslandViewHeight() {
        return this.islandViewHeight;
    }

    public final int getIslandViewMarginTop() {
        return this.islandViewMarginTop;
    }

    public final int getIslandWindowHeight() {
        return this.islandWindowHeight;
    }

    public final DynamicIslandState getLastState() {
        return this.lastState;
    }

    public final View.OnAttachStateChangeListener getListener() {
        return this.listener;
    }

    public final View getMask() {
        return this.mask;
    }

    public final float getMaxWidth() {
        return this.maxWidth;
    }

    public final View getMiniBar() {
        return this.miniBar;
    }

    public final float getMiniBarMarginBottom() {
        return this.miniBarMarginBottom;
    }

    public final boolean getMiniBarVisible() {
        return this.miniBarVisible;
    }

    public final boolean getOpenAppFromIsland() {
        return this.openAppFromIsland;
    }

    public final float getPadIslandTransX() {
        return this.padIslandTransX;
    }

    public final int getPadMultiNotificationMargin() {
        return this.padMultiNotificationMargin;
    }

    public final String getPkgName() {
        Object object = this.currentIslandData;
        object = object != null && (object = object.getExtras()) != null ? object.getString("miui.pkg.name") : null;
        return object;
    }

    public final int getRealCutoutWidth() {
        Object object = this.dynamicIslandEventCoordinator;
        int n = object != null && (object = ((DynamicIslandEventCoordinator)object).getWindowView()) != null ? ((DynamicIslandWindowView)((Object)object)).getCutoutWidth() : this.defaultCutoutWidth;
        return n;
    }

    public final DynamicIslandContentView getRealView() {
        return this.realView;
    }

    public final RectF getRoundedRect() {
        return this.roundedRect;
    }

    public final boolean getShowShade() {
        return this.showShade;
    }

    public final FrameLayout getSmallContainer() {
        return this.smallContainer;
    }

    public final Rect getSmallIslandRect(int n) {
        int n2;
        if (CommonUtils.INSTANCE.getIS_TABLET()) {
            return this.getBigIslandRect(Boolean.FALSE);
        }
        Rect rect = new Rect();
        rect.left = n;
        rect.top = n2 = this.islandViewMarginTop;
        rect.right = n + this.smallIslandViewWidth;
        rect.bottom = n2 + this.islandViewHeight;
        return rect;
    }

    public final FrameLayout getSmallIslandView() {
        return this.smallIslandView;
    }

    public final int getSmallIslandViewWidth() {
        return this.smallIslandViewWidth;
    }

    public final int getSpace() {
        return this.space;
    }

    public final DynamicIslandState getState() {
        return this.state;
    }

    public final int getStatusBarDatePosX() {
        return this.statusBarDatePosX;
    }

    public final int getStatusBarHeight() {
        return this.statusBarHeight;
    }

    public final float getSwipeDiffX() {
        return this.swipeDiffX;
    }

    public final i getSwipeInfo() {
        return this.swipeInfo;
    }

    public final IslandTemplate getTemplate() {
        return this.template;
    }

    public final Integer getUserId() {
        Object object = this.currentIslandData;
        object = object != null && (object = object.getExtras()) != null ? Integer.valueOf(object.getInt("miui.user.id")) : null;
        return object;
    }

    public final DynamicIslandViewModel getViewModel() {
        return this.viewModel;
    }

    public final WindowAnimState getWindowAnimState() {
        return this.windowAnimState;
    }

    public final DynamicIslandWindowState getWindowState() {
        Object object = this.dynamicIslandEventCoordinator;
        object = object != null && (object = ((DynamicIslandEventCoordinator)object).getWindowView()) != null && (object = ((DynamicIslandWindowView)((Object)object)).getWindowViewController()) != null ? ((DynamicIslandWindowViewController)object).getWindowState() : null;
        return object;
    }

    public final DynamicIslandBaseContentViewController<?> get_controller() {
        return this._controller;
    }

    public final i1.u get_islandAppAnimRunning() {
        return this._islandAppAnimRunning;
    }

    public final i1.u get_islandFreeformAnimRunning() {
        return this._islandFreeformAnimRunning;
    }

    public final boolean hasLargeNotchLikePhone() {
        int n = this.getRealCutoutWidth();
        int n2 = this.getCutoutHeight();
        int n3 = this.getContext().getResources().getDimensionPixelSize(R.dimen.large_notch_width_threshold);
        boolean bl = n >= n3;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("hasLargeNotchLikePhone - width: ");
        stringBuilder.append(n);
        stringBuilder.append(", height: ");
        stringBuilder.append(n2);
        stringBuilder.append(", threshold: ");
        stringBuilder.append(n3);
        stringBuilder.append(", result: ");
        stringBuilder.append(bl);
        Log.d((String)TAG, (String)stringBuilder.toString());
        return bl;
    }

    public final Boolean hasMulti() {
        Object object;
        block1: {
            Object object2;
            block2: {
                Object object3;
                object2 = this.getPkgName();
                Object var3_2 = null;
                object2 = object2 != null && (object = this.dynamicIslandEventCoordinator) != null && (object = ((DynamicIslandEventCoordinator)object).getWindowView()) != null ? Boolean.valueOf(((DynamicIslandWindowView)((Object)object)).hasSubMiniWindow((String)object2)) : null;
                object = this.getPkgName();
                if (o.c((Object)(object = object != null && (object3 = this.dynamicIslandEventCoordinator) != null && (object3 = ((DynamicIslandEventCoordinator)object3).getWindowView()) != null ? Boolean.valueOf(((DynamicIslandWindowView)((Object)object3)).hasSubAppExpanded((String)object)) : null), (Object)(object3 = Boolean.FALSE)) && o.c((Object)object2, (Object)object3)) {
                    return null;
                }
                object3 = this.lastState;
                if (object3 instanceof DynamicIslandState.AppExpanded || object3 instanceof DynamicIslandState.SubAppExpanded) break block1;
                if (object3 instanceof DynamicIslandState.MiniWindowExpanded) break block2;
                object = var3_2;
                if (!(object3 instanceof DynamicIslandState.SubMiniWindowExpanded)) break block1;
            }
            object = object2;
        }
        return object;
    }

    public final boolean hasSmallIsland() {
        boolean bl;
        if (CommonUtils.INSTANCE.getIS_TABLET()) {
            bl = false;
        } else {
            Boolean bl2 = this.hasMulti();
            Object object = bl2;
            if (bl2 == null) {
                object = this.dynamicIslandEventCoordinator;
                object = object != null ? Boolean.valueOf(((DynamicIslandEventCoordinator)object).hasSmallIsland()) : null;
            }
            bl = o.c((Object)object, (Object)Boolean.TRUE);
        }
        return bl;
    }

    public void hideIslandLayout() {
        this.hideExpandedLottie();
    }

    public final boolean isAnimating() {
        boolean bl;
        DynamicIslandAnimationDelegate dynamicIslandAnimationDelegate = this.animatorDelegate;
        boolean bl2 = bl = false;
        if (dynamicIslandAnimationDelegate != null) {
            bl2 = bl;
            if (dynamicIslandAnimationDelegate.isAnimating()) {
                bl2 = true;
            }
        }
        return bl2;
    }

    public final boolean isExpanded() {
        Object object = this.dynamicIslandEventCoordinator;
        object = object != null && (object = ((DynamicIslandEventCoordinator)object).getExpandedStateHandler()) != null ? ((ExpandedStateHandler)object).getCurrent() : null;
        return o.c((Object)object, (Object)((Object)this));
    }

    public final boolean isExpandedShowing() {
        DynamicIslandExpandedView dynamicIslandExpandedView;
        boolean bl = this.getWindowVisibility() == 0 && this.getVisibility() == 0 && (dynamicIslandExpandedView = this.expandedView) != null && dynamicIslandExpandedView.getVisibility() == 0;
        return bl;
    }

    public final I isPressed() {
        return this.isPressed;
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this._isPressed.setValue((Object)Boolean.FALSE);
    }

    public void onIslandClick() {
    }

    public final void onSwipe(float f2, float f3, DynamicIslandContentView dynamicIslandContentView, DynamicIslandState dynamicIslandState, DynamicIslandState dynamicIslandState2) {
        o.g((Object)((Object)dynamicIslandContentView), (String)"view");
        this.calculateSwipeRatio(((Number)this.swipeInfo.d()).floatValue());
        DynamicIslandAnimationDelegate dynamicIslandAnimationDelegate = this.animatorDelegate;
        if (dynamicIslandAnimationDelegate != null) {
            dynamicIslandAnimationDelegate.onSwipe(dynamicIslandContentView, dynamicIslandState, dynamicIslandState2, f2, f3);
        }
    }

    public final boolean pkgHasMultIslands(DynamicIslandContentView object) {
        boolean bl;
        String string;
        if (object != null && (string = ((DynamicIslandBaseContentView)((Object)object)).getPkgName()) != null) {
            object = (object = ((DynamicIslandBaseContentView)((Object)object)).getDynamicIslandEventCoordinator()) != null ? Boolean.valueOf(((DynamicIslandEventCoordinator)object).hasSamePackageIsland(string)) : null;
            bl = o.c((Object)object, (Object)Boolean.TRUE);
        } else {
            bl = false;
        }
        return bl;
    }

    public void resetStatus() {
    }

    public final s resetSwipe(DynamicIslandContentView dynamicIslandContentView) {
        o.g((Object)((Object)dynamicIslandContentView), (String)"view");
        DynamicIslandAnimationDelegate dynamicIslandAnimationDelegate = this.animatorDelegate;
        if (dynamicIslandAnimationDelegate != null) {
            dynamicIslandAnimationDelegate.resetSwipe(dynamicIslandContentView);
            dynamicIslandContentView = s.a;
        } else {
            dynamicIslandContentView = null;
        }
        return dynamicIslandContentView;
    }

    public final void setAnimatorDelegate(DynamicIslandAnimationDelegate dynamicIslandAnimationDelegate) {
        this.animatorDelegate = dynamicIslandAnimationDelegate;
    }

    public final void setBackgroundView(DynamicIslandBackgroundView dynamicIslandBackgroundView) {
        this.backgroundView = dynamicIslandBackgroundView;
    }

    public final void setBigContainer(LinearLayout linearLayout) {
        this.bigContainer = linearLayout;
    }

    public final void setBigIslandAreaLeft(FrameLayout frameLayout) {
        this.bigIslandAreaLeft = frameLayout;
    }

    public final void setBigIslandAreaMargin(FrameLayout frameLayout) {
        this.bigIslandAreaMargin = frameLayout;
    }

    public final void setBigIslandAreaRight(FrameLayout frameLayout) {
        this.bigIslandAreaRight = frameLayout;
    }

    public final void setBigIslandLeftWidth(int n) {
        this.bigIslandLeftWidth = n;
    }

    public final void setBigIslandLeftWidthHasSmallIsland(int n) {
        this.bigIslandLeftWidthHasSmallIsland = n;
    }

    public final void setBigIslandMarginWidth(int n) {
        this.bigIslandMarginWidth = n;
    }

    public final void setBigIslandRightWidth(int n) {
        this.bigIslandRightWidth = n;
    }

    public final void setBigIslandRightWidthHasSmallIsland(int n) {
        this.bigIslandRightWidthHasSmallIsland = n;
    }

    public final void setBigIslandTransX(int n) {
        this.bigIslandTransX = n;
    }

    public final void setBigIslandView(DynamicIslandBigIslandView dynamicIslandBigIslandView) {
        this.bigIslandView = dynamicIslandBigIslandView;
    }

    public final void setBigIslandViewWidth(int n) {
        this.bigIslandViewWidth = n;
    }

    public final void setBigIslandViewWidthHasSmallIsland(int n) {
        this.bigIslandViewWidthHasSmallIsland = n;
    }

    public final void setBigIslandX(int n) {
        this.bigIslandX = n;
    }

    public final void setBigIslandXHasSmallIsland(int n) {
        this.bigIslandXHasSmallIsland = n;
    }

    public final void setContainer(FrameLayout frameLayout) {
        this.container = frameLayout;
    }

    @CallSuper
    public void setController(DynamicIslandBaseContentViewController<?> dynamicIslandBaseContentViewController) {
        o.g(dynamicIslandBaseContentViewController, (String)"controller");
        this._controller = dynamicIslandBaseContentViewController;
    }

    public final void setCurrentIslandData(DynamicIslandData dynamicIslandData) {
        this.currentIslandData = dynamicIslandData;
    }

    public final void setCutoutHeight(float f2) {
        this.cutoutHeight = f2;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("setCutoutHeight ");
        stringBuilder.append(f2);
        Log.e((String)TAG, (String)stringBuilder.toString());
    }

    public final void setCutoutY(float f2) {
        this.cutoutY = f2;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("setCutoutY ");
        stringBuilder.append(f2);
        Log.e((String)TAG, (String)stringBuilder.toString());
        if (this.currentIslandData != null) {
            this.calculateBigIslandY();
        } else {
            this.pendingCutoutY = Float.valueOf(f2);
            Log.d((String)TAG, (String)"setCutoutY: data not ready, defer calculation");
        }
    }

    public final void setDynamicIslandEventCoordinator(DynamicIslandEventCoordinator dynamicIslandEventCoordinator) {
        this.dynamicIslandEventCoordinator = dynamicIslandEventCoordinator;
    }

    public final void setEventHandler(DynamicIslandEventCoordinator dynamicIslandEventCoordinator) {
        o.g((Object)dynamicIslandEventCoordinator, (String)"eventHandler");
        this.dynamicIslandEventCoordinator = dynamicIslandEventCoordinator;
    }

    public final void setExpandedIslandWidth(int n) {
        this.expandedIslandWidth = n;
    }

    public final void setExpandedLottieView(LottieAnimationView lottieAnimationView) {
        this.expandedLottieView = lottieAnimationView;
    }

    public final void setExpandedView(DynamicIslandExpandedView dynamicIslandExpandedView) {
        this.expandedView = dynamicIslandExpandedView;
    }

    public final void setExpandedViewHeight(int n) {
        this.expandedViewHeight = n;
    }

    public final void setExpandedViewMarginHorizontal(int n) {
        this.expandedViewMarginHorizontal = n;
    }

    public final void setExpandedViewMaxHeight(int n) {
        this.expandedViewMaxHeight = n;
    }

    public final void setExpandedViewMaxWidth(int n) {
        this.expandedViewMaxWidth = n;
    }

    public final void setExpandedViewStub(ViewStub viewStub) {
        this.expandedViewStub = viewStub;
    }

    public final void setExpandedViewWidth(int n) {
        this.expandedViewWidth = n;
    }

    public final void setExpandedViewY(int n) {
        this.expandedViewY = n;
    }

    public final void setFakeBigContainer(LinearLayout linearLayout) {
        this.fakeBigContainer = linearLayout;
    }

    public final void setFakeBigIsland(FrameLayout frameLayout) {
        this.fakeBigIsland = frameLayout;
    }

    public final void setFakeContainer(FrameLayout frameLayout) {
        this.fakeContainer = frameLayout;
    }

    public final void setFakeExpandedView(FrameLayout frameLayout) {
        this.fakeExpandedView = frameLayout;
    }

    public final void setFakeFirstLayout(FrameLayout frameLayout) {
        this.fakeFirstLayout = frameLayout;
    }

    public final void setFakeMask(View view) {
        this.fakeMask = view;
    }

    public final void setFakeSecondLayout(FrameLayout frameLayout) {
        this.fakeSecondLayout = frameLayout;
    }

    public final void setFakeSmallIsland(FrameLayout frameLayout) {
        this.fakeSmallIsland = frameLayout;
    }

    public final void setFakeView(DynamicIslandContentFakeView dynamicIslandContentFakeView) {
        this.fakeView = dynamicIslandContentFakeView;
    }

    public final void setHeadsUpStatusBarPadding(int n) {
        this.headsUpStatusBarPadding = n;
    }

    public final void setIslandViewHeight(int n) {
        this.islandViewHeight = n;
    }

    public final void setIslandViewMarginTop(int n) {
        this.islandViewMarginTop = n;
    }

    public final void setIslandWindowHeight(int n) {
        this.islandWindowHeight = n;
    }

    public final void setLastState(DynamicIslandState dynamicIslandState) {
        this.lastState = dynamicIslandState;
    }

    public final void setListener(View.OnAttachStateChangeListener onAttachStateChangeListener) {
        this.listener = onAttachStateChangeListener;
    }

    public final void setMask(View view) {
        this.mask = view;
    }

    public final void setMaxWidth(float f2, float f3, float f4) {
        boolean bl = f2 > 0.0f && f3 > 0.0f && f4 > 0.0f;
        this.maxWidth = f2;
        this.clockWidth = f3;
        this.batteryWidth = f4;
        if (bl) {
            this.updateBigIslandViewWidth();
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("setMaxWidth maxWidth: ");
        stringBuilder.append(f2);
        stringBuilder.append(", clockWidth: ");
        stringBuilder.append(f3);
        stringBuilder.append(", batteryWidth: ");
        stringBuilder.append(f4);
        Log.e((String)TAG, (String)stringBuilder.toString());
    }

    public final void setMiniBar(View view) {
        this.miniBar = view;
    }

    public final void setMiniBarVisible(boolean bl) {
        this.miniBarVisible = bl;
    }

    public final void setOpenAppFromIsland(boolean bl) {
        this.openAppFromIsland = bl;
    }

    public final void setPadIslandTransX(float f2) {
        this.padIslandTransX = f2;
    }

    public final void setPadMultiNotificationMargin(int n) {
        this.padMultiNotificationMargin = n;
    }

    public void setPressed(boolean bl) {
        super.setPressed(bl);
        this._isPressed.setValue((Object)bl);
    }

    public final void setRealView(DynamicIslandContentView dynamicIslandContentView) {
        this.realView = dynamicIslandContentView;
    }

    public final void setShowShade(boolean bl) {
        this.showShade = bl;
    }

    public final void setSizeRepository$miui_dynamicisland_release(DynamicIslandSizeRepository dynamicIslandSizeRepository) {
        o.g((Object)dynamicIslandSizeRepository, (String)"repository");
        this.sizeRepository = dynamicIslandSizeRepository;
    }

    public final void setSmallContainer(FrameLayout frameLayout) {
        this.smallContainer = frameLayout;
    }

    public final void setSmallIslandView(FrameLayout frameLayout) {
        this.smallIslandView = frameLayout;
    }

    public final void setSmallIslandViewWidth(int n) {
        this.smallIslandViewWidth = n;
    }

    public final void setState(DynamicIslandState dynamicIslandState) {
        if (!o.c((Object)this.state, (Object)dynamicIslandState)) {
            this.state = dynamicIslandState;
        }
    }

    public final void setStatusBarDatePosX(int n) {
        this.statusBarDatePosX = n;
    }

    public final void setStatusBarHeight(int n) {
        this.statusBarHeight = n;
    }

    public final void setSwipeDiffX(float f2) {
        this.swipeDiffX = f2;
    }

    public final void setSwipeInfo(i i2) {
        o.g((Object)i2, (String)"<set-?>");
        this.swipeInfo = i2;
    }

    public final void setTemplate(IslandTemplate islandTemplate) {
        this.template = islandTemplate;
    }

    public final void setWindowAnimState(WindowAnimState windowAnimState) {
        o.g((Object)windowAnimState, (String)"<set-?>");
        this.windowAnimState = windowAnimState;
    }

    public final void set_controller(DynamicIslandBaseContentViewController<?> dynamicIslandBaseContentViewController) {
        this._controller = dynamicIslandBaseContentViewController;
    }

    public void showIslandLayout() {
        this.showExpandedLottie();
    }

    public void showShadowForPad() {
        this.updateShadowForPad(this, this.getContext().getResources().getColor(R.color.shader_color));
    }

    public void showShadowNoANim() {
    }

    public void updateAccessibility(DynamicIslandData dynamicIslandData) {
    }

    public final void updateBackgroundBg(View view, boolean bl) {
        o.g((Object)view, (String)"view");
        Object object = this.currentIslandData;
        object = object != null && (object = object.getExtras()) != null ? (StatusBarNotification)object.getParcelable("miui.sbn", StatusBarNotification.class) : null;
        bl = PromotedNotificationParamUtils.isNotificationPromotedOngoing((StatusBarNotification)object) || bl;
        object = view.getContext();
        o.f((Object)object, (String)"getContext(...)");
        if (MiBlurCompat.getBackgroundBlurOpened((Context)object) && view.getParent() != null) {
            int n;
            int n2;
            int n3;
            int n4;
            int n5;
            int n6;
            if (bl) {
                n6 = this.getContext().getResources().getColor(R.color.liveupdate_island_element_blend_shade_color_1);
                n5 = this.getContext().getResources().getColor(R.color.liveupdate_island_element_blend_shade_color_2);
                n4 = this.getContext().getResources().getColor(R.color.liveupdate_island_element_blend_shade_color_3);
                n3 = this.getResources().getInteger(R.integer.blur_mode_linear_light);
                n2 = this.getResources().getInteger(R.integer.blur_mode_lab);
                n = this.getResources().getInteger(R.integer.blur_mode_pure);
            } else {
                n6 = this.getContext().getResources().getColor(R.color.island_element_blend_shade_color_1);
                n5 = this.getContext().getResources().getColor(R.color.island_element_blend_shade_color_2);
                n4 = this.getContext().getResources().getColor(R.color.island_element_blend_shade_color_3);
                n3 = 100;
                n2 = 106;
                n = 3;
            }
            object = new StringBuilder();
            ((StringBuilder)object).append("updateBackgroundBg isPromoted ");
            ((StringBuilder)object).append(bl);
            ((StringBuilder)object).append(", color&mode:(");
            ((StringBuilder)object).append(n6);
            ((StringBuilder)object).append("-");
            ((StringBuilder)object).append(n3);
            ((StringBuilder)object).append("), (");
            ((StringBuilder)object).append(n5);
            ((StringBuilder)object).append("-");
            ((StringBuilder)object).append(n2);
            ((StringBuilder)object).append("), (");
            ((StringBuilder)object).append(n4);
            ((StringBuilder)object).append("-");
            ((StringBuilder)object).append(n);
            ((StringBuilder)object).append(")");
            Log.i((String)TAG, (String)((StringBuilder)object).toString());
            MiBlurCompat.setMiViewBlurModeCompat((View)view, (int)1);
            MiBlurCompat.clearMiBackgroundBlendColorCompat((View)view);
            MiBlurCompat.setMiBackgroundBlendColors$default((View)view, (int[])new int[]{n6, n3, n5, n2, n4, n}, (float)0.0f, (int)2, null);
            view.setBackgroundDrawable(null);
        } else {
            object = CommonUtils.INSTANCE;
            if (object.getIS_TABLET()) {
                object.clearMiBlurBlendEffect(view);
                view.setBackground(null);
            } else {
                MiBlurCompat.setMiViewBlurModeCompat((View)view, (int)0);
                MiBlurCompat.clearMiBackgroundBlendColorCompat((View)view);
                if (bl) {
                    view.setBackgroundDrawable(this.getContext().getResources().getDrawable(R.drawable.dynamic_island_liveupdate_background));
                } else {
                    view.setBackgroundDrawable(this.getContext().getResources().getDrawable(R.drawable.dynamic_island_background));
                }
            }
        }
    }

    public void updateBigIslandLayout() {
    }

    /*
     * Exception decompiling
     */
    public final void updateBigIslandLayoutWithAnim(FrameLayout var1_1, FrameLayout var2_2, LinearLayout var3_3, FrameLayout var4_4, DynamicIslandContentView var5_5, boolean var6_6) {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * 
         * org.benf.cfr.reader.util.ConfusedCFRException: Statement already marked as first in another block
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op03SimpleStatement.markFirstStatementInBlock(Op03SimpleStatement.java:461)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.op3rewriters.Misc.markWholeBlock(Misc.java:251)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.op3rewriters.ConditionalRewriter.considerAsSimpleIf(ConditionalRewriter.java:673)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.op3rewriters.ConditionalRewriter.identifyNonjumpingConditionals(ConditionalRewriter.java:56)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:722)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisOrWrapFail(CodeAnalyser.java:278)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysis(CodeAnalyser.java:201)
         *     at org.benf.cfr.reader.entities.attributes.AttributeCode.analyse(AttributeCode.java:94)
         *     at org.benf.cfr.reader.entities.Method.analyse(Method.java:531)
         *     at org.benf.cfr.reader.entities.ClassFile.analyseMid(ClassFile.java:1055)
         *     at org.benf.cfr.reader.entities.ClassFile.analyseTop(ClassFile.java:942)
         *     at org.benf.cfr.reader.Driver.doClass(Driver.java:84)
         *     at org.benf.cfr.reader.CfrDriverImpl.analyse(CfrDriverImpl.java:78)
         *     at org.benf.cfr.reader.Main.main(Main.java:54)
         */
        throw new IllegalStateException("Decompilation failed");
    }

    public Object updateBigIslandView(DynamicIslandData dynamicIslandData, boolean bl, K0.d d2) {
        return DynamicIslandBaseContentView.updateBigIslandView$suspendImpl(this, dynamicIslandData, bl, d2);
    }

    public void updateBigIslandViewWidth() {
    }

    @SuppressLint(value={"UseCompatLoadingForDrawables"})
    public final void updateDarkLightMode(DynamicIslandState object, String object2, boolean bl, boolean bl2) {
        block22: {
            boolean bl3;
            Object object3;
            Object object4;
            block24: {
                block23: {
                    if (this.backgroundView == null || object == null || this.template == null) break block22;
                    object4 = this.currentIslandData;
                    if (object4 == null) break block23;
                    object3 = DynamicIslandUtils.INSTANCE;
                    boolean bl4 = object3.isDynamicIslandPadNoPropOnce((DynamicIslandData)object4);
                    bl3 = true;
                    if (bl4 && object3.isBigOrDeletedOrHidden((DynamicIslandState)object)) break block24;
                }
                bl3 = false;
            }
            if (!bl && !bl3) {
                object3 = this.getContext().getResources().getDrawable(R.drawable.dynamic_island_background_big_island_dark);
                object4 = this.backgroundView;
                if (object4 != null) {
                    object4.setDrawable((Drawable)object3);
                }
                if (object instanceof DynamicIslandState.Expanded) {
                    if (object3 instanceof GradientDrawable) {
                        ((GradientDrawable)object3).setStroke(this.getContext().getResources().getDimensionPixelSize(R.dimen.island_stroke), this.getContext().getResources().getColor(R.color.stroke_color));
                    }
                } else if (TextUtils.isEmpty((CharSequence)object2)) {
                    if (object3 instanceof GradientDrawable) {
                        ((GradientDrawable)object3).setStroke(this.getContext().getResources().getDimensionPixelSize(R.dimen.island_stroke), this.getContext().getResources().getColor(R.color.stroke_color));
                    }
                } else {
                    object2 = object2 != null ? Integer.valueOf(ColorUtils.setAlphaComponent((int)Color.parseColor((String)object2), (int)((int)((double)Color.alpha((int)Color.parseColor((String)object2)) * 0.2)))) : null;
                    if (object3 instanceof GradientDrawable && object2 != null) {
                        ((GradientDrawable)object3).setStroke(this.getContext().getResources().getDimensionPixelSize(R.dimen.island_stroke), ((Integer)object2).intValue());
                    }
                }
            } else {
                object2 = this.getContext().getResources().getDrawable(R.drawable.dynamic_island_background_island);
                object3 = this.backgroundView;
                if (object3 != null) {
                    ((DynamicIslandBackgroundView)((Object)object3)).setDrawable((Drawable)object2);
                }
            }
            if (object instanceof DynamicIslandState.Hidden) {
                object = this.backgroundView;
                if (object != null) {
                    ((DynamicIslandBackgroundView)((Object)object)).alphaAnimation(0.0f);
                }
            } else if (!bl2) {
                object = this.backgroundView;
                if (object != null) {
                    ((DynamicIslandBackgroundView)((Object)object)).alphaAnimation(1.0f);
                }
            } else {
                object = this.backgroundView;
                if (object != null) {
                    ((DynamicIslandBackgroundView)((Object)object)).alphaAnimation(0.0f);
                }
            }
        }
    }

    public void updateExpandViewBlur(int n) {
    }

    public final void updateExpandedSize(int n, int n2, DynamicIslandData dynamicIslandData) {
        int n3;
        Object object;
        int n4 = this.getContext().getResources().getDimensionPixelSize(R.dimen.expanded_min_width);
        n4 = CommonUtils.INSTANCE.getIS_TABLET() ? this.expandedIslandWidth : (n == 0 ? this.expandedViewMaxWidth : Math.max(Math.min(n, this.expandedViewMaxWidth), n4));
        this.expandedViewWidth = n4;
        n4 = this.getContext().getResources().getDimensionPixelSize(R.dimen.expanded_min_height);
        StringBuilder stringBuilder = null;
        object = dynamicIslandData != null && (object = dynamicIslandData.getExtras()) != null ? Boolean.valueOf(object.getBoolean("miui.focus.isPromoted", false)) : null;
        n4 = o.c((Object)object, (Object)Boolean.TRUE) ? Math.max(n2, n4) : Math.max(Math.min(n2, this.expandedViewMaxHeight), n4);
        this.expandedViewHeight = n4;
        DynamicIslandUtils dynamicIslandUtils = DynamicIslandUtils.INSTANCE;
        object = this.getContext();
        o.f((Object)object, (String)"getContext(...)");
        int n5 = dynamicIslandUtils.getScreenWidthOld((Context)object);
        n4 = this.expandedViewWidth;
        this.expandedViewMarginHorizontal = n3 = (n5 - n4) / 2;
        n5 = this.expandedViewHeight;
        object = stringBuilder;
        if (dynamicIslandData != null) {
            dynamicIslandUtils = dynamicIslandData.getView();
            object = stringBuilder;
            if (dynamicIslandUtils != null) {
                object = dynamicIslandUtils.getHeight();
            }
        }
        stringBuilder = new StringBuilder();
        stringBuilder.append("updateExpandedViewWidth ");
        stringBuilder.append(n3);
        stringBuilder.append(" ");
        stringBuilder.append(n4);
        stringBuilder.append(" ");
        stringBuilder.append(n);
        stringBuilder.append(" ");
        stringBuilder.append(n5);
        stringBuilder.append(" ");
        stringBuilder.append(n2);
        stringBuilder.append(" ");
        stringBuilder.append(object);
        Log.e((String)TAG, (String)stringBuilder.toString());
        if (dynamicIslandData != null && (object = dynamicIslandData.getView()) != null) {
            this.updateViewLayoutParams((View)object, this.expandedViewWidth, this.expandedViewHeight);
        }
        if (dynamicIslandData != null && (dynamicIslandData = dynamicIslandData.getFakeView()) != null) {
            this.updateViewLayoutParams((View)dynamicIslandData, this.expandedViewWidth, this.expandedViewHeight);
        }
    }

    public Object updateExpandedView(DynamicIslandData dynamicIslandData, boolean bl, K0.d d2) {
        return DynamicIslandBaseContentView.updateExpandedView$suspendImpl(this, dynamicIslandData, bl, d2);
    }

    public void updateMarginTop() {
    }

    public final void updateMarginTop(View view) {
        ViewGroup.LayoutParams layoutParams = view != null ? view.getLayoutParams() : null;
        if (layoutParams == null) {
            return;
        }
        if (view.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            ((ViewGroup.MarginLayoutParams)layoutParams).topMargin = this.islandViewMarginTop;
        }
        ((ViewGroup.MarginLayoutParams)layoutParams).topMargin = this.islandViewMarginTop;
        view.setLayoutParams(layoutParams);
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    public final void updateMedianLuma(float var1_1) {
        block12: {
            block13: {
                block11: {
                    var7_2 = this.getContext().getResources().getDrawable(R.drawable.dynamic_island_background_big_island_dark);
                    var4_3 /* !! */  = this.backgroundView;
                    if (var4_3 /* !! */  != null) {
                        var4_3 /* !! */ .setDrawable(var7_2);
                    }
                    var3_4 = this.isExpanded();
                    var5_5 = null;
                    var6_6 = null;
                    var4_3 /* !! */  = null;
                    if (!var3_4) break block11;
                    if (var7_2 instanceof GradientDrawable) {
                        var4_3 /* !! */  = (GradientDrawable)var7_2;
                    }
                    if (var4_3 /* !! */  != null) {
                        var4_3 /* !! */ .setStroke(this.getContext().getResources().getDimensionPixelSize(R.dimen.expanded_stroke), DynamicIslandBaseContentView.updateMedianLuma$getStrokeColor(this, var1_1));
                    }
                    break block12;
                }
                var4_3 /* !! */  = this.template;
                var4_3 /* !! */  = var4_3 /* !! */  != null ? var4_3 /* !! */ .getHighlightColor() : null;
                if (var4_3 /* !! */  != null) break block13;
                var4_3 /* !! */  = var5_5;
                if (var7_2 instanceof GradientDrawable) {
                    var4_3 /* !! */  = (GradientDrawable)var7_2;
                }
                if (var4_3 /* !! */  != null) {
                    var4_3 /* !! */ .setStroke(this.getContext().getResources().getDimensionPixelSize(R.dimen.island_stroke), DynamicIslandBaseContentView.updateMedianLuma$getStrokeColor(this, var1_1));
                }
                break block12;
            }
            var4_3 /* !! */  = this.template;
            var4_3 /* !! */  = var4_3 /* !! */  != null && (var4_3 /* !! */  = var4_3 /* !! */ .getHighlightColor()) != null ? Integer.valueOf(Color.parseColor((String)var4_3 /* !! */ )) : null;
            var1_1 = f.h((float)((float)true - var1_1), (float)0.0f, (float)1.0f);
            var5_5 = var4_3 /* !! */  != null ? Float.valueOf((float)Color.alpha((int)var4_3 /* !! */ .intValue()) * var1_1) : null;
            if (var4_3 /* !! */  == null) ** GOTO lbl-1000
            var2_7 = var4_3 /* !! */ .intValue();
            if (var5_5 != null) {
                var4_3 /* !! */  = Integer.valueOf(ColorUtils.setAlphaComponent((int)var2_7, (int)((int)var5_5.floatValue())));
            } else lbl-1000:
            // 2 sources

            {
                var4_3 /* !! */  = null;
            }
            if (var4_3 /* !! */  != null) {
                var5_5 = var6_6;
                if (var7_2 instanceof GradientDrawable) {
                    var5_5 = (GradientDrawable)var7_2;
                }
                if (var5_5 != null) {
                    var5_5.setStroke(this.getContext().getResources().getDimensionPixelSize(R.dimen.island_stroke), var4_3 /* !! */ .intValue());
                }
            }
        }
        if ((var4_3 /* !! */  = this.backgroundView) != null) {
            var4_3 /* !! */ .invalidate();
        }
    }

    public final void updateMiniBar(DynamicIslandContentView dynamicIslandContentView) {
        Object object;
        int n = 0;
        this.hideByFullScreenPkg = false;
        boolean bl = this.fakeView != null ? this.canExpandedViewSlide(dynamicIslandContentView) : (object = this.realView) != null && ((DynamicIslandBaseContentView)((Object)object)).getMiniBarVisible();
        this.miniBarVisible = bl;
        object = new StringBuilder();
        ((StringBuilder)object).append("updateMiniBar visible: ");
        ((StringBuilder)object).append(bl);
        Log.d((String)TAG, (String)((StringBuilder)object).toString());
        object = this.miniBar;
        if (object != null) {
            if (!bl) {
                n = 8;
            }
            object.setVisibility(n);
        }
        if (bl) {
            this.updateMiniBarTranslation$miui_dynamicisland_release(dynamicIslandContentView);
        }
    }

    public final void updateMiniBarTranslation$miui_dynamicisland_release(DynamicIslandContentView dynamicIslandBaseContentView) {
        View view = this.miniBar;
        if (view != null) {
            int n = dynamicIslandBaseContentView != null ? dynamicIslandBaseContentView.getExpandedViewHeight() : 0;
            view.setTranslationX(0.0f);
            DynamicIslandContentFakeView dynamicIslandContentFakeView = dynamicIslandBaseContentView != null ? dynamicIslandBaseContentView.getFakeView() : null;
            if (dynamicIslandContentFakeView == null || (dynamicIslandBaseContentView = dynamicIslandBaseContentView.getFakeView()) != null && (dynamicIslandBaseContentView = ((DynamicIslandContentFakeView)dynamicIslandBaseContentView).getTrackingToOpenMW()) != null && !((Boolean)dynamicIslandBaseContentView.getValue()).booleanValue()) {
                view.setTranslationY((float)n - this.miniBarMarginBottom - this.miniBarHeight);
            }
        }
    }

    public final void updateShadow(DynamicIslandBaseContentView dynamicIslandBaseContentView, float f2) {
        Object object;
        o.g((Object)((Object)dynamicIslandBaseContentView), (String)"view");
        f2 = f.h((float)f2, (float)0.0f, (float)1.0f);
        int n = this.getContext().getResources().getColor(R.color.shader_color);
        int n2 = (int)(f2 * (float)Color.alpha((int)n));
        n2 = ColorUtils.setAlphaComponent((int)n, (int)n2);
        if (CommonUtils.INSTANCE.getIS_TABLET() && ((object = this.currentIslandData) == null || (object = object.getProperties()) == null || (Integer)object != 0)) {
            float f3 = this.getContext().getResources().getDimensionPixelSize(R.dimen.island_shadow_y);
            f2 = this.getContext().getResources().getDimensionPixelSize(R.dimen.island_shadow_radius);
            MiShadowUtils.setMiShadow((View)dynamicIslandBaseContentView, (int)n2, (float)0.0f, (float)f3, (float)f2, (float)1.0f, (boolean)true);
        }
    }

    public final void updateShadow(DynamicIslandBaseContentView dynamicIslandBaseContentView, int n) {
        Object object;
        o.g((Object)((Object)dynamicIslandBaseContentView), (String)"view");
        if (!CommonUtils.INSTANCE.getIS_TABLET() || (object = this.currentIslandData) != null && (object = object.getProperties()) != null && (Integer)object == 0) {
            float f2 = this.getContext().getResources().getDimensionPixelSize(R.dimen.island_shadow_y);
            float f3 = this.getContext().getResources().getDimensionPixelSize(R.dimen.island_shadow_radius);
            MiShadowUtils.setMiShadow((View)dynamicIslandBaseContentView, (int)n, (float)0.0f, (float)f2, (float)f3, (float)1.0f, (boolean)true);
        }
    }

    public final void updateShadowForPad(DynamicIslandBaseContentView dynamicIslandBaseContentView, int n) {
        o.g((Object)((Object)dynamicIslandBaseContentView), (String)"view");
        MiShadowUtils.setMiShadow((View)dynamicIslandBaseContentView, (int)n, (float)0.0f, (float)this.getContext().getResources().getDimensionPixelSize(R.dimen.pad_island_shadow_y), (float)this.getContext().getResources().getDimensionPixelSize(R.dimen.pad_island_shadow_radius), (float)1.0f, (boolean)true);
    }

    public Object updateSmallIslandView(DynamicIslandData dynamicIslandData, boolean bl, K0.d d2) {
        return DynamicIslandBaseContentView.updateSmallIslandView$suspendImpl(this, dynamicIslandData, bl, d2);
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    public final Object updateView(DynamicIslandData var1_1, boolean var2_2, boolean var3_3, K0.d var4_4) {
        block14: {
            block11: {
                block12: {
                    block13: {
                        block7: {
                            block8: {
                                block9: {
                                    block10: {
                                        if (!(var4_4 /* !! */  instanceof updateView.1)) ** GOTO lbl-1000
                                        var8_5 = var4_4 /* !! */ ;
                                        var5_6 = var8_5.label;
                                        if ((var5_6 & -2147483648) != 0) {
                                            var8_5.label = var5_6 + -2147483648;
                                        } else lbl-1000:
                                        // 2 sources

                                        {
                                            var8_5 = new M0.d(this, var4_4 /* !! */ ){
                                                Object L$0;
                                                Object L$1;
                                                boolean Z$0;
                                                boolean Z$1;
                                                boolean Z$2;
                                                int label;
                                                Object result;
                                                final DynamicIslandBaseContentView this$0;
                                                {
                                                    this.this$0 = dynamicIslandBaseContentView;
                                                    super(d2);
                                                }

                                                public final Object invokeSuspend(Object object) {
                                                    this.result = object;
                                                    this.label |= Integer.MIN_VALUE;
                                                    return this.this$0.updateView(null, false, false, (K0.d)this);
                                                }
                                            };
                                        }
                                        var9_7 = var8_5.result;
                                        var11_8 = c.c();
                                        var5_6 = var8_5.label;
                                        if (var5_6 == 0) break block7;
                                        if (var5_6 == 1) break block8;
                                        if (var5_6 == 2) break block9;
                                        if (var5_6 != 3) break block10;
                                        var2_2 = var8_5.Z$0;
                                        var4_4 /* !! */  = (DynamicIslandData)var8_5.L$1;
                                        var1_1 = (DynamicIslandBaseContentView)var8_5.L$0;
                                        k.b((Object)var9_7);
                                        break block11;
                                    }
                                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                }
                                var2_2 = var8_5.Z$2;
                                var3_3 = var8_5.Z$1;
                                var7_9 = var8_5.Z$0;
                                var4_4 /* !! */  = (DynamicIslandData)var8_5.L$1;
                                var1_1 = (DynamicIslandBaseContentView)var8_5.L$0;
                                k.b((Object)var9_7);
                                break block12;
                            }
                            var3_3 = var8_5.Z$1;
                            var2_2 = var8_5.Z$0;
                            var1_1 = (DynamicIslandData)var8_5.L$1;
                            var4_4 /* !! */  = (DynamicIslandBaseContentView)var8_5.L$0;
                            k.b((Object)var9_7);
                            break block13;
                        }
                        k.b((Object)var9_7);
                        var4_4 /* !! */  = new StringBuilder();
                        var4_4 /* !! */ .append("updateView: ");
                        var4_4 /* !! */ .append(var1_1);
                        var4_4 /* !! */ .append(" ");
                        var4_4 /* !! */ .append(var2_2);
                        Log.e((String)"DynamicIslandTemplateDebug", (String)var4_4 /* !! */ .toString());
                        this.currentIslandData = var1_1;
                        if (this.pendingCutoutY != null || var1_1 != null) {
                            this.calculateBigIslandY();
                            this.pendingCutoutY = null;
                        }
                        this.updateTemplate((DynamicIslandData)var1_1);
                        var8_5.L$0 = this;
                        var8_5.L$1 = var1_1;
                        var8_5.Z$0 = var2_2;
                        var8_5.Z$1 = var3_3;
                        var8_5.label = 1;
                        var10_10 = this.updateBigIslandView((DynamicIslandData)var1_1, var2_2, (K0.d)var8_5);
                        var4_4 /* !! */  = this;
                        var9_7 = var10_10;
                        if (var10_10 == var11_8) {
                            return var11_8;
                        }
                    }
                    var6_11 = (Boolean)var9_7;
                    var8_5.L$0 = var4_4 /* !! */ ;
                    var8_5.L$1 = var1_1;
                    var8_5.Z$0 = var2_2;
                    var8_5.Z$1 = var3_3;
                    var8_5.Z$2 = var6_11;
                    var8_5.label = 2;
                    if (var4_4 /* !! */ .updateSmallIslandView((DynamicIslandData)var1_1, var2_2, (K0.d)var8_5) == var11_8) {
                        return var11_8;
                    }
                    var9_7 = var4_4 /* !! */ ;
                    var7_9 = var2_2;
                    var4_4 /* !! */  = var1_1;
                    var1_1 = var9_7;
                    var2_2 = var6_11;
                }
                var6_11 = var2_2;
                var10_10 = var1_1;
                var9_7 = var4_4 /* !! */ ;
                if (var3_3) {
                    var8_5.L$0 = var1_1;
                    var8_5.L$1 = var4_4 /* !! */ ;
                    var8_5.Z$0 = var2_2;
                    var8_5.label = 3;
                    if (var1_1.updateExpandedView((DynamicIslandData)var4_4 /* !! */ , var7_9, (K0.d)var8_5) == var11_8) {
                        return var11_8;
                    } else {
                        ** GOTO lbl92
                    }
                }
                break block14;
            }
            super.updateExpandedLottieView();
            var9_7 = var4_4 /* !! */ ;
            var10_10 = var1_1;
            var6_11 = var2_2;
        }
        var10_10.updateAccessibility((DynamicIslandData)var9_7);
        return b.a((boolean)var6_11);
    }
}
