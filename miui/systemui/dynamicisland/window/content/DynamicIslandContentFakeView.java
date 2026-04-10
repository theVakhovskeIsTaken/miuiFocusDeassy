/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  G0.k
 *  G0.s
 *  K0.d
 *  L0.c
 *  M0.b
 *  M0.d
 *  U0.o
 *  android.content.Context
 *  android.graphics.Outline
 *  android.graphics.Rect
 *  android.os.Bundle
 *  android.os.Parcelable
 *  android.util.AttributeSet
 *  android.util.Log
 *  android.view.Choreographer
 *  android.view.Choreographer$FrameCallback
 *  android.view.MotionEvent
 *  android.view.VelocityTracker
 *  android.view.View
 *  android.view.ViewConfiguration
 *  android.view.ViewGroup
 *  android.view.ViewGroup$LayoutParams
 *  android.view.ViewOutlineProvider
 *  android.widget.FrameLayout
 *  android.widget.FrameLayout$LayoutParams
 *  android.widget.LinearLayout
 *  b1.f
 *  com.android.systemui.plugins.miui.dynamicisland.DynamicIslandData
 *  f1.E
 *  f1.f
 *  i1.I
 *  i1.K
 *  i1.h
 *  i1.u
 *  kotlin.jvm.internal.h
 *  kotlin.jvm.internal.o
 *  kotlin.jvm.internal.y
 *  miui.systemui.animation.FolmeKt
 *  miui.systemui.notification.LottieProgressManager
 *  miui.systemui.util.CommonUtils
 *  miui.systemui.util.MetadataUtils
 *  miui.systemui.util.MiBlurCompat
 *  miuix.animation.FolmeObject
 *  miuix.animation.IFolme
 *  miuix.animation.base.AnimConfig
 *  miuix.animation.listener.TransitionListener
 *  miuix.animation.listener.UpdateInfo
 *  miuix.animation.utils.EaseManager
 *  miuix.animation.utils.EaseManager$EaseStyle
 *  miuix.animation.utils.EaseManager$InterpolateEaseStyle
 *  miuix.core.util.MiShadowUtils
 */
package miui.systemui.dynamicisland.window.content;

import G0.k;
import G0.s;
import K0.d;
import android.content.Context;
import android.graphics.Outline;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.Choreographer;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewOutlineProvider;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import b1.f;
import com.android.systemui.plugins.miui.dynamicisland.DynamicIslandData;
import f1.E;
import i1.I;
import i1.K;
import i1.u;
import java.util.Collection;
import java.util.HashMap;
import kotlin.jvm.internal.h;
import kotlin.jvm.internal.o;
import kotlin.jvm.internal.y;
import miui.systemui.animation.FolmeKt;
import miui.systemui.dynamicisland.DynamicIslandAnimUtils;
import miui.systemui.dynamicisland.DynamicIslandBackgroundView;
import miui.systemui.dynamicisland.R;
import miui.systemui.dynamicisland.event.DynamicIslandEventCoordinator;
import miui.systemui.dynamicisland.event.DynamicIslandState;
import miui.systemui.dynamicisland.event.handler.BigIslandStateHandler;
import miui.systemui.dynamicisland.model.IslandTemplate;
import miui.systemui.dynamicisland.template.IslandTemplateFactory;
import miui.systemui.dynamicisland.window.DynamicIslandWindowState;
import miui.systemui.dynamicisland.window.DynamicIslandWindowView;
import miui.systemui.dynamicisland.window.DynamicIslandWindowViewController;
import miui.systemui.dynamicisland.window.content.DynamicIslandBaseContentView;
import miui.systemui.dynamicisland.window.content.DynamicIslandBaseContentViewController;
import miui.systemui.dynamicisland.window.content.DynamicIslandContentFakeView;
import miui.systemui.dynamicisland.window.content.DynamicIslandContentView;
import miui.systemui.dynamicisland.window.content.FakeViewTrackingParams;
import miui.systemui.dynamicisland.window.content.a;
import miui.systemui.dynamicisland.window.content.b;
import miui.systemui.dynamicisland.window.content.c;
import miui.systemui.notification.LottieProgressManager;
import miui.systemui.util.CommonUtils;
import miui.systemui.util.MetadataUtils;
import miui.systemui.util.MiBlurCompat;
import miuix.animation.FolmeObject;
import miuix.animation.IFolme;
import miuix.animation.base.AnimConfig;
import miuix.animation.listener.TransitionListener;
import miuix.animation.listener.UpdateInfo;
import miuix.animation.utils.EaseManager;
import miuix.core.util.MiShadowUtils;

public final class DynamicIslandContentFakeView
extends DynamicIslandBaseContentView {
    public static final Companion Companion = new Object(null){
        {
            this();
        }
    };
    public static final String TAG = "DynamicIslandContentFakeView";
    private final u _startEnterMiniWindowBeforeAnimation;
    private final u _trackingToOpenMW;
    private boolean appClosingToExpanded;
    private float bigIslandTx;
    private boolean bigIslandViewNeedAnim;
    private boolean blockByError;
    private boolean closingAppFromFreeform;
    private boolean closingToExpanded;
    private final ExpandedTracker contentTracker;
    private IFolme folme;
    private FolmeObject folmeObject;
    private boolean forceUpdateBigIslandView;
    private boolean isLight;
    private final EaseManager.InterpolateEaseStyle mAlphaEease;
    private final AnimConfig mAnimConfig;
    private boolean mCanTrackingEnterMW;
    private int mFakeViewBottom;
    private int mFakeViewHeight;
    private int mFakeViewLeft;
    private int mFakeViewRight;
    private int mFakeViewTop;
    private FakeViewTrackingParams mFakeViewTrackingParams;
    private int mFakeViewWidth;
    private float mInitialTouchY;
    private float mLastTouchY;
    private float mMaxTriggerThreshold;
    private boolean mStartEnterMiniWindow;
    private final int mTouchSlop;
    private final EaseManager.EaseStyle mTrackingEase;
    private float mTriggerThreshold;
    private boolean miniWindowAlreadyOpen;
    private boolean miniWindowClosingToExpanded;
    private boolean needResetState;
    private boolean openFromRealExpandViewRect;
    private final float radius;
    private final I startEnterMiniWindowBeforeAnimation;
    private int startTop;
    private boolean suppressBigIslandLayout;
    private final I trackingToOpenMW;
    private final VelocityTracker velocityTracker;

    public DynamicIslandContentFakeView(Context context, AttributeSet object) {
        u u2;
        o.g((Object)context, (String)"context");
        super(context, (AttributeSet)object);
        this.velocityTracker = VelocityTracker.obtain();
        this.radius = context.getResources().getDimension(R.dimen.island_radius);
        this.contentTracker = new Object(){
            private DynamicIslandEventCoordinator coordinator;
            private String packageName;
            private final Bundle shareBundle = new Bundle();
            private boolean tracked;

            public final void finishTrack() {
                if (!this.tracked) {
                    Log.w((String)DynamicIslandContentFakeView.TAG, (String)"finishTrack: not tracked");
                    return;
                }
                this.tracked = false;
                DynamicIslandEventCoordinator dynamicIslandEventCoordinator = this.coordinator;
                if (dynamicIslandEventCoordinator != null) {
                    Bundle bundle = this.shareBundle;
                    bundle.clear();
                    bundle.putString("miui.pkg.name", this.packageName);
                    dynamicIslandEventCoordinator.finishDropDownExpandedIsland(bundle);
                }
            }

            public final void startTrack(String string, DynamicIslandEventCoordinator dynamicIslandEventCoordinator) {
                if (this.tracked) {
                    Log.e((String)DynamicIslandContentFakeView.TAG, (String)"startTrack: already tracked");
                    return;
                }
                if (string != null && string.length() == 0 || dynamicIslandEventCoordinator == null) {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("startTrack: invalid params pkgName=");
                    stringBuilder.append(string);
                    stringBuilder.append(", coordinator=");
                    stringBuilder.append(dynamicIslandEventCoordinator);
                    Log.e((String)DynamicIslandContentFakeView.TAG, (String)stringBuilder.toString());
                    return;
                }
                this.tracked = true;
                this.packageName = string;
                this.coordinator = dynamicIslandEventCoordinator;
                string = this.shareBundle;
                string.clear();
                string.putString("miui.pkg.name", this.packageName);
                dynamicIslandEventCoordinator = this.coordinator;
                if (dynamicIslandEventCoordinator != null) {
                    dynamicIslandEventCoordinator.startDropDownExpandedIsland((Bundle)string);
                }
            }

            public final void updateTrack(float f) {
                DynamicIslandEventCoordinator dynamicIslandEventCoordinator;
                if (!this.tracked) {
                    Log.w((String)DynamicIslandContentFakeView.TAG, (String)"updateTrack: not tracked");
                    return;
                }
                float f2 = f;
                if (f < 0.0f) {
                    f2 = 0.0f;
                }
                if ((dynamicIslandEventCoordinator = this.coordinator) != null) {
                    Bundle bundle = this.shareBundle;
                    bundle.clear();
                    bundle.putString("miui.pkg.name", this.packageName);
                    bundle.putFloat("pull_down_action_offset_y", f2);
                    dynamicIslandEventCoordinator.updateDropDownExpandedIsland(bundle);
                }
            }
        };
        object = Boolean.FALSE;
        this._trackingToOpenMW = u2 = K.a((Object)object);
        this.trackingToOpenMW = i1.h.b((u)u2);
        this.mTouchSlop = ViewConfiguration.get((Context)this.getContext()).getScaledTouchSlop();
        this.mMaxTriggerThreshold = context.getResources().getDimension(R.dimen.mini_window_max_trigger_threshold);
        this.mTriggerThreshold = context.getResources().getDimension(R.dimen.mini_window_trigger_threshold);
        this.mFakeViewTrackingParams = new FakeViewTrackingParams();
        context = K.a((Object)object);
        this._startEnterMiniWindowBeforeAnimation = context;
        this.startEnterMiniWindowBeforeAnimation = i1.h.b((u)context);
        context = EaseManager.getStyle((int)-2, (float[])new float[]{0.95f, 0.4f});
        o.f((Object)context, (String)"getStyle(...)");
        this.mTrackingEase = context;
        this.mAlphaEease = new EaseManager.InterpolateEaseStyle(15).setDuration(150L);
        this.mAnimConfig = new AnimConfig().addListeners(new TransitionListener[]{new TransitionListener(this){
            final DynamicIslandContentFakeView this$0;
            {
                this.this$0 = dynamicIslandContentFakeView;
            }

            public void onCancel(Object object) {
                super.onCancel(object);
                DynamicIslandContentFakeView.access$setNeedResetState$p(this.this$0, false);
                if (!((Boolean)DynamicIslandContentFakeView.access$get_trackingToOpenMW$p(this.this$0).getValue()).booleanValue()) {
                    DynamicIslandContentFakeView.access$getContentTracker$p(this.this$0).finishTrack();
                }
            }

            public void onComplete(Object object) {
                super.onComplete(object);
                if (DynamicIslandContentFakeView.access$getNeedResetState$p(this.this$0)) {
                    DynamicIslandContentFakeView.access$setNeedResetState$p(this.this$0, false);
                    DynamicIslandContentFakeView.access$onTrackingFakeViewReset(this.this$0);
                }
                DynamicIslandContentFakeView.access$getContentTracker$p(this.this$0).finishTrack();
            }

            public void onUpdate(Object object, Collection<UpdateInfo> updateInfo) {
                super.onUpdate(object, updateInfo);
                UpdateInfo updateInfo2 = UpdateInfo.findByName(updateInfo, (String)"alpha");
                if (updateInfo2 == null) {
                    return;
                }
                object = UpdateInfo.findByName(updateInfo, (String)"top");
                if (object == null) {
                    return;
                }
                if ((updateInfo = UpdateInfo.findByName(updateInfo, (String)"bottom")) == null) {
                    return;
                }
                float f2 = updateInfo2.getFloatValue();
                DynamicIslandContentFakeView.access$getMFakeViewTrackingParams$p(this.this$0).setAlpha(f2);
                DynamicIslandContentFakeView.access$getMFakeViewTrackingParams$p(this.this$0).setTop(object.getIntValue());
                DynamicIslandContentFakeView.access$getMFakeViewTrackingParams$p(this.this$0).setBottom(updateInfo.getIntValue());
                DynamicIslandContentFakeView.access$onFakeViewTrackingParamsUpdated(this.this$0);
            }
        }});
    }

    public /* synthetic */ DynamicIslandContentFakeView(Context context, AttributeSet attributeSet, int n, h h2) {
        if ((n & 2) != 0) {
            attributeSet = null;
        }
        this(context, attributeSet);
    }

    public static /* synthetic */ void a(DynamicIslandContentFakeView dynamicIslandContentFakeView, long l) {
        DynamicIslandContentFakeView.updateViewStateWhenOpenAnimStart$lambda$11(dynamicIslandContentFakeView, l);
    }

    public static final /* synthetic */ ExpandedTracker access$getContentTracker$p(DynamicIslandContentFakeView dynamicIslandContentFakeView) {
        return dynamicIslandContentFakeView.contentTracker;
    }

    public static final /* synthetic */ FakeViewTrackingParams access$getMFakeViewTrackingParams$p(DynamicIslandContentFakeView dynamicIslandContentFakeView) {
        return dynamicIslandContentFakeView.mFakeViewTrackingParams;
    }

    public static final /* synthetic */ boolean access$getNeedResetState$p(DynamicIslandContentFakeView dynamicIslandContentFakeView) {
        return dynamicIslandContentFakeView.needResetState;
    }

    public static final /* synthetic */ float access$getRadius$p(DynamicIslandContentFakeView dynamicIslandContentFakeView) {
        return dynamicIslandContentFakeView.radius;
    }

    public static final /* synthetic */ int access$getScreenHeight(DynamicIslandContentFakeView dynamicIslandContentFakeView, Context context) {
        return dynamicIslandContentFakeView.getScreenHeight(context);
    }

    public static final /* synthetic */ int access$getScreenWidth(DynamicIslandContentFakeView dynamicIslandContentFakeView, Context context) {
        return dynamicIslandContentFakeView.getScreenWidth(context);
    }

    public static final /* synthetic */ u access$get_trackingToOpenMW$p(DynamicIslandContentFakeView dynamicIslandContentFakeView) {
        return dynamicIslandContentFakeView._trackingToOpenMW;
    }

    public static final /* synthetic */ void access$onFakeViewTrackingParamsUpdated(DynamicIslandContentFakeView dynamicIslandContentFakeView) {
        dynamicIslandContentFakeView.onFakeViewTrackingParamsUpdated();
    }

    public static final /* synthetic */ void access$onTrackingFakeViewReset(DynamicIslandContentFakeView dynamicIslandContentFakeView) {
        dynamicIslandContentFakeView.onTrackingFakeViewReset();
    }

    public static final /* synthetic */ void access$setNeedResetState$p(DynamicIslandContentFakeView dynamicIslandContentFakeView, boolean bl) {
        dynamicIslandContentFakeView.needResetState = bl;
    }

    public static final /* synthetic */ void access$updateExpandViewPivot(DynamicIslandContentFakeView dynamicIslandContentFakeView) {
        dynamicIslandContentFakeView.updateExpandViewPivot();
    }

    private final float afterFriction(float f2, float f3) {
        float f4 = f.e((float)(Math.abs(f2) / Math.abs(f3)), (float)f3);
        f2 = f4 * f4;
        return (f2 * f4 / (float)3 - f2 + f4) * f3;
    }

    public static /* synthetic */ void b(DynamicIslandContentFakeView dynamicIslandContentFakeView) {
        DynamicIslandContentFakeView.updateViewStateWhenCloseEnd$lambda$9(dynamicIslandContentFakeView);
    }

    public static /* synthetic */ void c(DynamicIslandContentFakeView dynamicIslandContentFakeView) {
        DynamicIslandContentFakeView.setVisibility$lambda$12(dynamicIslandContentFakeView);
    }

    private final int getScreenHeight(Context context) {
        return context.getResources().getDisplayMetrics().heightPixels;
    }

    private final int getScreenWidth(Context context) {
        return context.getResources().getDisplayMetrics().widthPixels;
    }

    private final void onFakeViewTrackingParamsUpdated() {
        int n = this.mFakeViewTrackingParams.getBottom() - this.mFakeViewTrackingParams.getTop();
        int n2 = this.mFakeViewTrackingParams.getRight();
        int n3 = this.mFakeViewTrackingParams.getLeft();
        float f2 = n - this.mFakeViewHeight;
        this.contentTracker.updateTrack(f2);
        this.updateOutline(n, n2 - n3, false);
    }

    private final void onTrackingFakeViewDown() {
        int n;
        int n2;
        Object object;
        if (this.appClosingToExpanded) {
            object = this.getRealView();
            if (object != null) {
                object.setVisibility(0);
            }
            object = this.getRealView();
            object = object != null ? object.getBackgroundView() : null;
            if (object != null) {
                object.setVisibility(0);
            }
        }
        if ((object = this.getRealView()) != null) {
            this.mFakeViewWidth = object.getExpandedViewWidth();
        }
        if ((object = this.getRealView()) != null) {
            this.mFakeViewHeight = object.getExpandedViewHeight();
        }
        if ((object = this.getRealView()) != null) {
            this.mFakeViewLeft = object.getExpandedViewMarginHorizontal();
        }
        if ((object = this.getRealView()) != null) {
            this.mFakeViewTop = object.getExpandedViewY();
        }
        int n3 = this.mFakeViewLeft;
        int n4 = this.mFakeViewWidth;
        this.mFakeViewRight = n2 = n3 + n4;
        int n5 = this.mFakeViewTop;
        int n6 = this.mFakeViewHeight;
        this.mFakeViewBottom = n = n5 + n6;
        this.blockByError = false;
        object = new StringBuilder();
        object.append("onTrackingFakeViewDown: mFakeViewWidth = ");
        object.append(n4);
        object.append(", mFakeViewHeight = ");
        object.append(n6);
        object.append(", mFakeViewLeft = ");
        object.append(n3);
        object.append(", mFakeViewTop = ");
        object.append(n5);
        object.append(", mFakeViewRight = ");
        object.append(n2);
        object.append(", mFakeViewBottom = ");
        object.append(n);
        Log.d((String)"DynamicIslandAnimDebug", (String)object.toString());
    }

    private final void onTrackingFakeViewEnd() {
        Object object = this._trackingToOpenMW.getValue();
        boolean bl = this.mStartEnterMiniWindow;
        boolean bl2 = this.miniWindowClosingToExpanded;
        Object object2 = new StringBuilder();
        ((StringBuilder)object2).append("onTrackingFakeViewEnd:  _trackingToOpenMW.value:");
        ((StringBuilder)object2).append(object);
        ((StringBuilder)object2).append(", mStartEnterMiniWindow:");
        ((StringBuilder)object2).append(bl);
        ((StringBuilder)object2).append(", miniWindowClosingToExpanded\uff1a");
        ((StringBuilder)object2).append(bl2);
        Log.e((String)"DynamicIslandAnimDebug", (String)((StringBuilder)object2).toString());
        if (((Boolean)this._trackingToOpenMW.getValue()).booleanValue() && (!(bl = this.mStartEnterMiniWindow) || bl && this.miniWindowClosingToExpanded)) {
            this.velocityTracker.computeCurrentVelocity(1000);
            int n = this.mFakeViewTrackingParams.getBottom();
            int n2 = this.mFakeViewTrackingParams.getTop();
            int n3 = this.mFakeViewHeight;
            if (this.velocityTracker.getYVelocity(0) > 1000.0f && (float)(n - n2 - n3) > this.mTriggerThreshold) {
                this.startEnterAndLaunchMiniWindow();
                this.startSpeedAnimation();
            } else {
                object2 = this.getDynamicIslandEventCoordinator();
                if (object2 != null) {
                    object = this.getRealView();
                    object = object != null && (object = ((DynamicIslandBaseContentView)((Object)object)).getCurrentIslandData()) != null ? object.getExtras() : null;
                    ((DynamicIslandEventCoordinator)object2).onWindowAnimExtendLifetimeEnd((Bundle)object);
                }
                this.needResetState = true;
                object = this.folme;
                if (object != null) {
                    object.to(new Object[]{"alpha", Float.valueOf(1.0f), "left", this.mFakeViewTrackingParams.getLeft(), "right", this.mFakeViewTrackingParams.getRight(), "top", this.mFakeViewTop, "bottom", this.mFakeViewTop + this.mFakeViewHeight, this.mAnimConfig.setEase(this.mTrackingEase).setSpecial("alpha", (EaseManager.EaseStyle)this.mAlphaEease, new float[0])});
                }
            }
        } else if (((Boolean)this._trackingToOpenMW.getValue()).booleanValue() && this.mStartEnterMiniWindow && !this.miniWindowAlreadyOpen) {
            this.startSpeedAnimation();
        } else {
            object = this.getDynamicIslandEventCoordinator();
            if (object == null || !((DynamicIslandEventCoordinator)object).islandFreeformAnimating(this.getRealView())) {
                this.contentTracker.finishTrack();
            }
        }
        this.mCanTrackingEnterMW = false;
        this._trackingToOpenMW.setValue((Object)Boolean.FALSE);
        this.velocityTracker.clear();
    }

    private final void onTrackingFakeViewReset() {
        Log.e((String)"DynamicIslandAnimDebug", (String)"onTrackingFakeViewReset");
        this.mStartEnterMiniWindow = false;
        this.updateExpandedFakeViewToReal();
    }

    private final void onTrackingFakeViewStart() {
        Object object;
        Object object2;
        Log.e((String)"DynamicIslandAnimDebug", (String)"onTrackingFakeViewStart");
        this._trackingToOpenMW.setValue((Object)Boolean.TRUE);
        this.mFakeViewTrackingParams.setLeft(this.mFakeViewLeft);
        this.mFakeViewTrackingParams.setTop(this.mFakeViewTop);
        this.mFakeViewTrackingParams.setRight(this.mFakeViewRight);
        this.mFakeViewTrackingParams.setAlpha(1.0f);
        if (this.getRealView() != null) {
            this.updateMiniBar(this.getRealView());
        }
        Object object3 = this.getDynamicIslandEventCoordinator();
        Object var2_2 = null;
        if (object3 != null) {
            object2 = this.getRealView();
            object = this.getRealView();
            object = object != null && (object = object.getCurrentIslandData()) != null ? object.getExtras() : null;
            ((DynamicIslandEventCoordinator)object3).updateFreeformFakeView(this, (DynamicIslandContentView)((Object)object2), (Bundle)object);
        }
        if ((object2 = this.getDynamicIslandEventCoordinator()) != null) {
            object = this.getRealView();
            object = object != null && (object = object.getCurrentIslandData()) != null ? object.getExtras() : null;
            ((DynamicIslandEventCoordinator)object2).onWindowAnimExtendLifetimeStart((Bundle)object);
        }
        if (!this.miniWindowClosingToExpanded) {
            this.syncLottieProgress(false);
            this.setVisibility(0);
            this.setAlpha(1.0f);
            object = this.getRealView();
            object = object != null ? object.getBackgroundView() : null;
            if (object != null) {
                object.setVisibility(4);
            }
            object = this.getRealView();
            if (object != null) {
                object.setVisibility(4);
            }
        }
        object2 = this.contentTracker;
        object3 = this.getRealView();
        object = var2_2;
        if (object3 != null) {
            object3 = ((DynamicIslandBaseContentView)((Object)object3)).getCurrentIslandData();
            object = var2_2;
            if (object3 != null) {
                object3 = object3.getExtras();
                object = var2_2;
                if (object3 != null) {
                    object = object3.getString("miui.pkg.name");
                }
            }
        }
        object2.startTrack((String)object, this.getDynamicIslandEventCoordinator());
    }

    /*
     * Enabled aggressive block sorting
     */
    private final void onTrackingFakeViewUpdate(float f2) {
        float f3 = f2 - 0.0f;
        float f4 = f3 == 0.0f ? 0 : (f3 < 0.0f ? -1 : 1);
        if (f4 < 0) {
            return;
        }
        float f5 = 1.0f - f.h((float)(f2 / this.mMaxTriggerThreshold), (float)0.0f, (float)1.0f);
        Object object = this.getContext();
        o.f((Object)object, (String)"getContext(...)");
        int n = this.getScreenWidth((Context)object);
        object = this.getContext();
        o.f((Object)object, (String)"getContext(...)");
        float f6 = Math.min(n, this.getScreenHeight((Context)object));
        object = this.getContext();
        o.f((Object)object, (String)"getContext(...)");
        n = this.getScreenWidth((Context)object);
        object = this.getContext();
        o.f((Object)object, (String)"getContext(...)");
        float f7 = Math.max(n, this.getScreenHeight((Context)object));
        if (2 != this.getContext().getResources().getConfiguration().orientation) {
            f6 = f7;
        }
        object = f4 == false ? (Number)0 : (Number)Float.valueOf(this.afterFriction(f2, f6) * 0.5f);
        f6 = f4 == false ? 0.0f : this.afterFriction(f2, f6) * 0.5f;
        if (f4 == false) {
            this.startTop = this.mFakeViewTrackingParams.getTop();
        }
        if (f2 > 0.0f) {
            f4 = this.startTop + this.mFakeViewHeight + (int)f.b((float)f6, (float)0.0f);
            n = ((Number)object).intValue();
        } else {
            f4 = this.startTop + this.mFakeViewHeight + (int)f.b((float)f2, (float)0.0f);
            n = ((Number)object).intValue();
        }
        f4 += n;
        n = this.startTop + ((Number)object).intValue();
        object = this.folme;
        if (object != null) {
            object.setTo(new Object[]{"alpha", Float.valueOf(f5), "left", this.mFakeViewTrackingParams.getLeft(), "right", this.mFakeViewTrackingParams.getRight(), "top", n, "bottom", (int)f4});
        }
        this.mFakeViewTrackingParams.setAlpha(f5);
        this.mFakeViewTrackingParams.setTop(n);
        this.mFakeViewTrackingParams.setBottom((int)f4);
        this.onFakeViewTrackingParamsUpdated();
        if (f2 > this.mMaxTriggerThreshold) {
            this.startEnterAndLaunchMiniWindow();
        }
    }

    private final void resetExpandedViewScaleForFreeform() {
        Log.e((String)TAG, (String)"resetExpandedViewScaleForFreeform");
        FrameLayout frameLayout = this.getFakeExpandedView();
        if (frameLayout != null) {
            frameLayout.setPivotX((float)this.mFakeViewWidth / 2.0f);
        }
        frameLayout = this.getFakeExpandedView();
        if (frameLayout != null) {
            frameLayout.setPivotY((float)this.mFakeViewHeight / 2.0f);
        }
        frameLayout = this.getFakeExpandedView();
        if (frameLayout != null) {
            frameLayout.setScaleX(1.0f);
        }
        frameLayout = this.getFakeExpandedView();
        if (frameLayout != null) {
            frameLayout.setScaleY(1.0f);
        }
    }

    private static final void setVisibility$lambda$12(DynamicIslandContentFakeView dynamicIslandBaseContentView) {
        o.g((Object)((Object)dynamicIslandBaseContentView), (String)"this$0");
        DynamicIslandEventCoordinator dynamicIslandEventCoordinator = dynamicIslandBaseContentView.getDynamicIslandEventCoordinator();
        if (dynamicIslandEventCoordinator != null) {
            dynamicIslandBaseContentView = (dynamicIslandBaseContentView = dynamicIslandBaseContentView.getRealView()) != null && (dynamicIslandBaseContentView = dynamicIslandBaseContentView.getCurrentIslandData()) != null ? dynamicIslandBaseContentView.getExtras() : null;
            dynamicIslandEventCoordinator.alreadyCloseAppEnd((Bundle)dynamicIslandBaseContentView);
        }
    }

    private final void startEnterAndLaunchMiniWindow() {
        DynamicIslandEventCoordinator dynamicIslandEventCoordinator;
        boolean bl = this.mStartEnterMiniWindow;
        boolean bl2 = this.miniWindowClosingToExpanded;
        boolean bl3 = this.blockByError;
        Object object = new StringBuilder();
        ((StringBuilder)object).append("startEnterAndLaunchMiniWindow , mStartEnterMiniWindow=");
        ((StringBuilder)object).append(bl);
        ((StringBuilder)object).append(", miniWindowClosingToExpanded:");
        ((StringBuilder)object).append(bl2);
        ((StringBuilder)object).append(", blockError=");
        ((StringBuilder)object).append(bl3);
        Log.e((String)"DynamicIslandAnimDebug", (String)((StringBuilder)object).toString());
        bl3 = this.mStartEnterMiniWindow;
        if (bl3 && !this.miniWindowClosingToExpanded || this.blockByError) {
            return;
        }
        if (bl3 && this.miniWindowClosingToExpanded) {
            this.openFromRealExpandViewRect = true;
        }
        this.miniWindowClosingToExpanded = false;
        this.mStartEnterMiniWindow = true;
        this._startEnterMiniWindowBeforeAnimation.setValue((Object)Boolean.TRUE);
        object = this.getDynamicIslandEventCoordinator();
        if (object != null) {
            ((DynamicIslandEventCoordinator)object).setEnterMiniWindow(true);
        }
        this.setOpenAppFromIsland(true);
        object = this.getDynamicIslandEventCoordinator();
        if (object != null) {
            ((DynamicIslandEventCoordinator)object).setUserExpanded(false);
        }
        object = this.getCurrentIslandData();
        if (object != null && (object = object.getExtras()) != null) {
            object.putBoolean("extra_open_freeform_in_workbench_mode", false);
        }
        if ((dynamicIslandEventCoordinator = this.getDynamicIslandEventCoordinator()) != null) {
            object = this.getRealView();
            object = object != null && (object = ((DynamicIslandBaseContentView)((Object)object)).getCurrentIslandData()) != null ? object.getExtras() : null;
            dynamicIslandEventCoordinator.openFreeForm((Bundle)object);
        }
    }

    private final void startSpeedAnimation() {
        Log.d((String)"DynamicIslandAnimDebug", (String)"startSpeedAnimation");
        Context context = this.getContext();
        o.f((Object)context, (String)"getContext(...)");
        int n = this.getScreenWidth(context);
        context = this.getContext();
        o.f((Object)context, (String)"getContext(...)");
        float f2 = Math.min(n, this.getScreenHeight(context));
        context = this.getContext();
        o.f((Object)context, (String)"getContext(...)");
        n = this.getScreenWidth(context);
        context = this.getContext();
        o.f((Object)context, (String)"getContext(...)");
        float f3 = Math.max(n, this.getScreenHeight(context));
        if (2 != this.getContext().getResources().getConfiguration().orientation) {
            f2 = f3;
        }
        f3 = this.afterFriction(f2, f2);
        f2 = this.afterFriction(f2, f2);
        int n2 = this.startTop;
        int n3 = this.mFakeViewHeight;
        n = (int)f.b((float)(f2 * 0.5f), (float)0.0f);
        int n4 = (int)(f3 * 0.5f);
        int n5 = this.startTop;
        context = this.folme;
        if (context != null) {
            context.to(new Object[]{"alpha", Float.valueOf(0.0f), "left", this.mFakeViewTrackingParams.getLeft(), "right", this.mFakeViewTrackingParams.getRight(), "top", n5 + n4, "bottom", n2 + n3 + n + n4, this.mAnimConfig.setEase(this.mTrackingEase).setSpecial("alpha", (EaseManager.EaseStyle)this.mAlphaEease, new float[0])});
        }
    }

    private final void syncIslandLottieProgress(boolean bl) {
        Object object = this.getRealView();
        LottieProgressManager lottieProgressManager = null;
        LottieProgressManager lottieProgressManager2 = null;
        if ((object = object != null ? ((DynamicIslandBaseContentView)((Object)object)).getState() : null) instanceof DynamicIslandState.BigIsland) {
            object = this.getDynamicIslandEventCoordinator();
            if (object != null && (object = ((DynamicIslandEventCoordinator)object).getWindowView()) != null && (object = ((DynamicIslandWindowView)((Object)object)).getWindowViewController()) != null && (object = ((DynamicIslandWindowViewController)object).getLottieProgressManager()) != null && (lottieProgressManager = (LottieProgressManager)object.get()) != null) {
                DynamicIslandData dynamicIslandData = this.getCurrentIslandData();
                object = lottieProgressManager2;
                if (dynamicIslandData != null) {
                    object = dynamicIslandData.getKey();
                }
                LottieProgressManager.islandShift$default((LottieProgressManager)lottieProgressManager, (String)object, (boolean)true, (boolean)false, (int)4, null);
            }
        } else if (object instanceof DynamicIslandState.SmallIsland && (object = this.getDynamicIslandEventCoordinator()) != null && (object = ((DynamicIslandEventCoordinator)object).getWindowView()) != null && (object = ((DynamicIslandWindowView)((Object)object)).getWindowViewController()) != null && (object = ((DynamicIslandWindowViewController)object).getLottieProgressManager()) != null && (lottieProgressManager2 = (LottieProgressManager)object.get()) != null) {
            DynamicIslandData dynamicIslandData = this.getCurrentIslandData();
            object = lottieProgressManager;
            if (dynamicIslandData != null) {
                object = dynamicIslandData.getKey();
            }
            LottieProgressManager.islandShift$default((LottieProgressManager)lottieProgressManager2, (String)object, (boolean)false, (boolean)false, (int)4, null);
        }
    }

    private final void syncLottieProgress(boolean bl) {
        LottieProgressManager lottieProgressManager;
        Object object = this.getDynamicIslandEventCoordinator();
        if (object != null && (object = ((DynamicIslandEventCoordinator)object).getWindowView()) != null && (object = ((DynamicIslandWindowView)((Object)object)).getWindowViewController()) != null && (object = ((DynamicIslandWindowViewController)object).getLottieProgressManager()) != null && (lottieProgressManager = (LottieProgressManager)object.get()) != null) {
            object = this.getCurrentIslandData();
            object = object != null ? object.getKey() : null;
            lottieProgressManager.islandExpandShift((String)object, bl);
        }
    }

    private final void updateAppAnimatingPosition(DynamicIslandContentView dynamicIslandContentView) {
        DynamicIslandData dynamicIslandData;
        Object object;
        block6: {
            block5: {
                object = dynamicIslandContentView.getDynamicIslandEventCoordinator();
                if (object == null || (object = ((DynamicIslandEventCoordinator)object).getWindowView()) == null) break block5;
                dynamicIslandData = ((DynamicIslandWindowView)((Object)object)).getCutoutRect();
                object = dynamicIslandData;
                if (dynamicIslandData != null) break block6;
            }
            object = this.getCurrentSmallRect(dynamicIslandContentView);
        }
        if ((dynamicIslandData = dynamicIslandContentView.getCurrentIslandData()) != null && (dynamicIslandData = dynamicIslandData.getExtras()) != null) {
            dynamicIslandData.putParcelable("position", (Parcelable)object);
        }
        if ((object = this.getDynamicIslandEventCoordinator()) != null) {
            dynamicIslandContentView = (dynamicIslandContentView = dynamicIslandContentView.getCurrentIslandData()) != null ? dynamicIslandContentView.getExtras() : null;
            ((DynamicIslandEventCoordinator)object).positionChanged((Bundle)dynamicIslandContentView);
        }
    }

    private final void updateExpandViewPivot() {
        DynamicIslandContentView dynamicIslandContentView = this.getRealView();
        int n = 0;
        int n2 = dynamicIslandContentView != null ? dynamicIslandContentView.getExpandedViewWidth() : 0;
        dynamicIslandContentView = this.getRealView();
        if (dynamicIslandContentView != null) {
            n = dynamicIslandContentView.getExpandedViewHeight();
        }
        if ((dynamicIslandContentView = this.getFakeExpandedView()) != null) {
            dynamicIslandContentView.setPivotX((float)n2 / 2.0f);
        }
        dynamicIslandContentView = this.getFakeExpandedView();
        if (dynamicIslandContentView != null) {
            dynamicIslandContentView.setPivotY((float)n / 2.0f);
        }
    }

    private final void updateExpandedFakeViewToReal() {
        Object object;
        this.syncLottieProgress(true);
        Object object2 = this.getDynamicIslandEventCoordinator();
        Object var2_2 = null;
        if (object2 != null) {
            object = this.getRealView();
            object = object != null && (object = object.getCurrentIslandData()) != null ? object.getExtras() : null;
            ((DynamicIslandEventCoordinator)object2).onWindowAnimExtendLifetimeEnd((Bundle)object);
        }
        this.setVisibility(4);
        object = this.getRealView();
        if (object != null) {
            object.setVisibility(0);
        }
        object2 = this.getRealView();
        object = var2_2;
        if (object2 != null) {
            object = ((DynamicIslandBaseContentView)((Object)object2)).getBackgroundView();
        }
        if (object != null) {
            object.setVisibility(0);
        }
        this.updateOutline(this.mFakeViewHeight, this.mFakeViewWidth, true);
    }

    private final void updateOutline(int n, int n2, boolean bl) {
        DynamicIslandContentView dynamicIslandContentView = this.getRealView();
        int n3 = 0;
        n2 = dynamicIslandContentView != null ? dynamicIslandContentView.getExpandedViewMarginHorizontal() : 0;
        dynamicIslandContentView = this.getRealView();
        if (dynamicIslandContentView != null) {
            n3 = dynamicIslandContentView.getIslandViewMarginTop();
        }
        y y2 = new y();
        int n4 = n;
        if (bl) {
            n4 = n + n3;
        }
        y2.a = n4;
        n = this.mFakeViewHeight;
        if (n4 < n + n3) {
            y2.a = n + n3;
        }
        this.setOutlineProvider(new ViewOutlineProvider(this, y2, n2, n3){
            final y $bottom;
            final int $left;
            final int $top;
            final DynamicIslandContentFakeView this$0;
            {
                this.this$0 = dynamicIslandContentFakeView;
                this.$bottom = y2;
                this.$left = n;
                this.$top = n2;
            }

            public void getOutline(View view2, Outline outline) {
                o.g((Object)view2, (String)"view");
                o.g((Object)outline, (String)"outline");
                this.this$0.updateExpandViewBlur(this.$bottom.a, true, false);
                outline.setRoundRect(this.$left, this.$top, DynamicIslandContentFakeView.access$getMFakeViewTrackingParams$p(this.this$0).getRight(), this.$bottom.a, DynamicIslandContentFakeView.access$getRadius$p(this.this$0));
            }
        });
        this.setClipToOutline(true);
        dynamicIslandContentView = this.getMiniBar();
        if (dynamicIslandContentView != null) {
            dynamicIslandContentView.setTranslationY((float)(y2.a - dynamicIslandContentView.getTop()) - this.getMiniBarMarginBottom() - (float)dynamicIslandContentView.getMeasuredHeight());
        }
    }

    public static /* synthetic */ void updateViewStateWhenCloseEnd$default(DynamicIslandContentFakeView dynamicIslandContentFakeView, boolean bl, String string, int n, Object object) {
        if ((n & 1) != 0) {
            bl = false;
        }
        if ((n & 2) != 0) {
            string = "";
        }
        dynamicIslandContentFakeView.updateViewStateWhenCloseEnd(bl, string);
    }

    private static final void updateViewStateWhenCloseEnd$lambda$9(DynamicIslandContentFakeView dynamicIslandBaseContentView) {
        o.g((Object)((Object)dynamicIslandBaseContentView), (String)"this$0");
        DynamicIslandEventCoordinator dynamicIslandEventCoordinator = dynamicIslandBaseContentView.getDynamicIslandEventCoordinator();
        if (dynamicIslandEventCoordinator != null) {
            dynamicIslandBaseContentView = (dynamicIslandBaseContentView = dynamicIslandBaseContentView.getRealView()) != null && (dynamicIslandBaseContentView = dynamicIslandBaseContentView.getCurrentIslandData()) != null ? dynamicIslandBaseContentView.getExtras() : null;
            dynamicIslandEventCoordinator.alreadyCloseAppEnd((Bundle)dynamicIslandBaseContentView);
        }
    }

    private static final void updateViewStateWhenOpenAnimStart$lambda$11(DynamicIslandContentFakeView dynamicIslandContentFakeView, long l) {
        o.g((Object)((Object)dynamicIslandContentFakeView), (String)"this$0");
        Log.e((String)"DynamicIslandAnimDebug", (String)"updateViewStateWhenOpenAnimStart");
        dynamicIslandContentFakeView.setTranslationX(0.0f);
        dynamicIslandContentFakeView.setTranslationY(0.0f);
        FrameLayout frameLayout = dynamicIslandContentFakeView.getFakeExpandedView();
        if (frameLayout != null) {
            frameLayout.setTranslationX(0.0f);
        }
        dynamicIslandContentFakeView.setLeft(0);
        dynamicIslandContentFakeView.setTop(0);
        dynamicIslandContentFakeView.setVisibility(0);
        dynamicIslandContentFakeView.setAlpha(1.0f);
        frameLayout = dynamicIslandContentFakeView.getRealView();
        frameLayout = frameLayout != null ? frameLayout.getBackgroundView() : null;
        if (frameLayout != null) {
            frameLayout.setVisibility(4);
        }
        frameLayout = dynamicIslandContentFakeView.getRealView();
        if (frameLayout != null) {
            frameLayout.setVisibility(4);
        }
        dynamicIslandContentFakeView.setOutlineProvider(new ViewOutlineProvider(dynamicIslandContentFakeView){
            final DynamicIslandContentFakeView this$0;
            {
                this.this$0 = dynamicIslandContentFakeView;
            }

            public void getOutline(View object, Outline outline) {
                o.g((Object)object, (String)"view");
                o.g((Object)outline, (String)"outline");
                DynamicIslandContentFakeView.access$updateExpandViewPivot(this.this$0);
                this.this$0.updateExpandViewBlur(0, false, true);
                object = this.this$0;
                Object object2 = object.getContext();
                o.f((Object)object2, (String)"getContext(...)");
                int n = DynamicIslandContentFakeView.access$getScreenWidth((DynamicIslandContentFakeView)((Object)object), object2);
                object2 = this.this$0;
                object = object2.getContext();
                o.f((Object)object, (String)"getContext(...)");
                outline.setRoundRect(0, 0, n, DynamicIslandContentFakeView.access$getScreenHeight((DynamicIslandContentFakeView)((Object)object2), (Context)object), DynamicIslandContentFakeView.access$getRadius$p(this.this$0));
            }
        });
        dynamicIslandContentFakeView.setClipToOutline(true);
    }

    public final void alreadyOpenApp() {
        Log.e((String)"DynamicIslandAnimDebug", (String)"alreadyOpenApp");
        this.mStartEnterMiniWindow = false;
        this.setOpenAppFromIsland(false);
    }

    public final void cancelExpandViewTrackingAnim() {
        Log.d((String)TAG, (String)"cancelExpandViewTrackingAnim");
        Object object = this.folme;
        if (object != null) {
            object.cancel();
        }
        if ((object = this.getMiniBar()) != null) {
            object.setVisibility(4);
        }
        object = this.getRealView();
        Object var2_2 = null;
        object = object != null ? object.getBackgroundView() : null;
        if (object != null) {
            object.setVisibility(4);
        }
        object = this.getRealView();
        if (object != null) {
            object.setVisibility(4);
        }
        this._startEnterMiniWindowBeforeAnimation.setValue((Object)Boolean.FALSE);
        this.miniWindowAlreadyOpen = true;
        ExpandedTracker expandedTracker = this.contentTracker;
        DynamicIslandContentView dynamicIslandContentView = this.getRealView();
        object = var2_2;
        if (dynamicIslandContentView != null) {
            dynamicIslandContentView = dynamicIslandContentView.getCurrentIslandData();
            object = var2_2;
            if (dynamicIslandContentView != null) {
                dynamicIslandContentView = dynamicIslandContentView.getExtras();
                object = var2_2;
                if (dynamicIslandContentView != null) {
                    object = dynamicIslandContentView.getString("miui.pkg.name");
                }
            }
        }
        expandedTracker.startTrack((String)object, this.getDynamicIslandEventCoordinator());
    }

    @Override
    public void clearShadow() {
        MiShadowUtils.clearMiShadow((View)this);
    }

    public final boolean freeFormGestureBack() {
        if (CommonUtils.INSTANCE.getIS_TABLET()) {
            return false;
        }
        Object object = this.getContext();
        o.f((Object)object, (String)"getContext(...)");
        if (MetadataUtils.isSupportFreeFormAnim((Context)object) && DynamicIslandAnimUtils.INSTANCE.supportShowElementAndFreeformAnim()) {
            Object object2 = this.getWindowState();
            Object var3_3 = null;
            if (object2 != null) {
                object = this.getRealView();
                object = object != null && (object = object.getCurrentIslandData()) != null ? object.getProperties() : null;
                object = ((DynamicIslandWindowState)object2).isTempHidden((Integer)object);
            } else {
                object = null;
            }
            object2 = new StringBuilder();
            ((StringBuilder)object2).append("onTouchEvent: \u5411\u4e0a\u6ed1\u52a8, isIslandTempHidden: ");
            ((StringBuilder)object2).append(object);
            Log.d((String)"DynamicIslandAnimDebug", (String)((StringBuilder)object2).toString());
            this.contentTracker.finishTrack();
            if (object != null) {
                boolean bl = object.booleanValue();
                object = this.getRealView();
                if (object != null && (object = object.getCurrentIslandData()) != null && (object = object.getExtras()) != null) {
                    object.putBoolean("extra_is_island_temp_hidden", bl);
                }
            }
            if ((object2 = this.getDynamicIslandEventCoordinator()) != null) {
                DynamicIslandContentView dynamicIslandContentView = this.getRealView();
                object = var3_3;
                if (dynamicIslandContentView != null) {
                    dynamicIslandContentView = dynamicIslandContentView.getCurrentIslandData();
                    object = var3_3;
                    if (dynamicIslandContentView != null) {
                        object = dynamicIslandContentView.getExtras();
                    }
                }
                ((DynamicIslandEventCoordinator)object2).onDynamicPluginCallback("onDynamicPluginCallback_freefrom_gesture_back", (Bundle)object);
            }
            return true;
        }
        return false;
    }

    public final boolean getAppClosingToExpanded() {
        return this.appClosingToExpanded;
    }

    public final float getBigIslandTx() {
        return this.bigIslandTx;
    }

    public final boolean getBigIslandViewNeedAnim() {
        return this.bigIslandViewNeedAnim;
    }

    public final boolean getClosingAppFromFreeform() {
        return this.closingAppFromFreeform;
    }

    public final boolean getClosingToExpanded() {
        return this.closingToExpanded;
    }

    public final Rect getCurrentSmallRect(DynamicIslandContentView dynamicIslandContentView) {
        int n;
        Object object;
        Object object2;
        block9: {
            block8: {
                o.g((Object)((Object)dynamicIslandContentView), (String)"view");
                DynamicIslandWindowState dynamicIslandWindowState = this.getWindowState();
                object2 = null;
                if (dynamicIslandWindowState != null && dynamicIslandWindowState.isTempHidden((Integer)(object = (object = dynamicIslandContentView.getCurrentIslandData()) != null ? object.getProperties() : null))) {
                    object = this.getDynamicIslandEventCoordinator();
                    dynamicIslandContentView = object2;
                    if (object != null) {
                        object = ((DynamicIslandEventCoordinator)object).getWindowView();
                        dynamicIslandContentView = object2;
                        if (object != null) {
                            dynamicIslandContentView = ((DynamicIslandWindowView)((Object)object)).getCutoutRect();
                        }
                    }
                    return dynamicIslandContentView;
                }
                object = this.getDynamicIslandEventCoordinator();
                if (object == null || (object = ((DynamicIslandEventCoordinator)object).getBigIslandStateHandler()) == null) break block8;
                object2 = ((BigIslandStateHandler)object).getCurrent();
                object = object2;
                if (object2 != null) break block9;
            }
            object = dynamicIslandContentView;
        }
        object2 = this.getContext();
        o.f((Object)object2, (String)"getContext(...)");
        if (CommonUtils.isLayoutRtl((Context)object2)) {
            n = DynamicIslandBaseContentView.getCurrentBigIslandX$default((DynamicIslandBaseContentView)((Object)object), null, 1, null) - dynamicIslandContentView.getSpace() - dynamicIslandContentView.getSmallIslandViewWidth();
        } else {
            object2 = Boolean.TRUE;
            int n2 = ((DynamicIslandBaseContentView)((Object)object)).getCurrentBigIslandX((Boolean)object2);
            n = ((DynamicIslandBaseContentView)((Object)object)).getCurrentBigIslandWidth((Boolean)object2);
            n = dynamicIslandContentView.getSpace() + (n2 + n);
        }
        return dynamicIslandContentView.getSmallIslandRect(n);
    }

    @Override
    public Rect getExpandedIslandRect() {
        Rect rect = new Rect();
        rect.left = this.mFakeViewLeft;
        rect.top = this.mFakeViewTop;
        rect.right = this.mFakeViewTrackingParams.getRight();
        rect.bottom = this.mFakeViewTrackingParams.getBottom();
        if (this.openFromRealExpandViewRect) {
            rect.bottom = this.mFakeViewBottom;
            this.openFromRealExpandViewRect = false;
        }
        return rect;
    }

    @Override
    public Rect getExpandedPosition() {
        Rect rect = new Rect();
        rect.set(this.mFakeViewLeft, this.mFakeViewTop, this.mFakeViewRight, this.mFakeViewTrackingParams.getBottom() - this.mFakeViewTrackingParams.getTop());
        return rect;
    }

    public final boolean getForceUpdateBigIslandView() {
        return this.forceUpdateBigIslandView;
    }

    public final boolean getMStartEnterMiniWindow() {
        return this.mStartEnterMiniWindow;
    }

    public final boolean getMiniWindowAlreadyOpen() {
        return this.miniWindowAlreadyOpen;
    }

    public final boolean getMiniWindowClosingToExpanded() {
        return this.miniWindowClosingToExpanded;
    }

    public final I getStartEnterMiniWindowBeforeAnimation() {
        return this.startEnterMiniWindowBeforeAnimation;
    }

    public final I getTrackingToOpenMW() {
        return this.trackingToOpenMW;
    }

    public final boolean handleTouchEvent(MotionEvent object) {
        this.velocityTracker.addMovement((MotionEvent)object);
        Object object2 = null;
        Object object3 = null;
        Object object4 = object != null ? Integer.valueOf(object.getActionMasked()) : null;
        boolean bl = true;
        if (object4 != null && (Integer)object4 == 0) {
            if (!this.getMiniBarVisible()) {
                return false;
            }
            object4 = DynamicIslandAnimUtils.INSTANCE;
            if ((((DynamicIslandAnimUtils)object4).featureDynamicIslandIsMiddle() || ((DynamicIslandAnimUtils)object4).featureDynamicIslandNoElementButFreeform()) && this.closingAppFromFreeform) {
                return false;
            }
            object2 = this.getDynamicIslandEventCoordinator();
            boolean bl2 = object2 != null && (object2 = ((DynamicIslandEventCoordinator)object2).getWindowView()) != null && (object2 = ((DynamicIslandWindowView)((Object)object2)).getWindowViewController()) != null && (object2 = ((DynamicIslandWindowViewController)object2).isAppAnimRunning()) != null ? (Boolean)object2.getValue() : false;
            object2 = this.getDynamicIslandEventCoordinator();
            bl = object2 != null ? ((DynamicIslandEventCoordinator)object2).islandAppAnimating(this.getRealView()) : false;
            boolean bl3 = bl2 && !bl;
            object2 = new StringBuilder();
            ((StringBuilder)object2).append("isOtherIslandAppAnimRunning : ");
            ((StringBuilder)object2).append(bl2);
            ((StringBuilder)object2).append(",  ");
            ((StringBuilder)object2).append(bl);
            Log.d((String)TAG, (String)((StringBuilder)object2).toString());
            if (bl3) {
                return false;
            }
            object2 = this.getDynamicIslandEventCoordinator();
            bl2 = object2 != null && (object2 = ((DynamicIslandEventCoordinator)object2).getWindowView()) != null && (object2 = ((DynamicIslandWindowView)((Object)object2)).getWindowViewController()) != null && (object2 = ((DynamicIslandWindowViewController)object2).isFreeformAnimRunning()) != null ? (Boolean)object2.getValue() : false;
            object2 = this.getDynamicIslandEventCoordinator();
            bl = object2 != null ? ((DynamicIslandEventCoordinator)object2).islandFreeformAnimating(this.getRealView()) : false;
            boolean bl4 = ((DynamicIslandAnimUtils)object4).getNotSupportInterruptAnim();
            bl3 = bl2 && (!bl || bl4);
            object4 = new StringBuilder();
            ((StringBuilder)object4).append("interceptFreeformAnimRunning : ");
            ((StringBuilder)object4).append(bl2);
            ((StringBuilder)object4).append(",  ");
            ((StringBuilder)object4).append(bl);
            ((StringBuilder)object4).append(", ");
            ((StringBuilder)object4).append(bl4);
            Log.d((String)TAG, (String)((StringBuilder)object4).toString());
            if (bl3) {
                return false;
            }
            this.mLastTouchY = object.getY();
            this.mInitialTouchY = object.getY();
            object4 = this.getRealView();
            object = object3;
            if (object4 != null) {
                object = ((DynamicIslandBaseContentView)((Object)object4)).getState();
            }
            if (object instanceof DynamicIslandState.Expanded && (object = this.getDynamicIslandEventCoordinator()) != null && ((DynamicIslandEventCoordinator)object).canExpandedViewTrack(this.getRealView())) {
                this.mCanTrackingEnterMW = true;
                this._trackingToOpenMW.setValue((Object)Boolean.FALSE);
                this.miniWindowAlreadyOpen = false;
                this.onTrackingFakeViewDown();
            }
            return this.mCanTrackingEnterMW;
        }
        if (object4 != null && (Integer)object4 == 2) {
            float f2 = object.getY() - this.mLastTouchY;
            if (this.mCanTrackingEnterMW && !((Boolean)this._trackingToOpenMW.getValue()).booleanValue() && f2 > (float)this.mTouchSlop) {
                this.mLastTouchY = object.getY();
                if (this.getRealView() != null) {
                    this.updateFakeExpandedViewState();
                }
                this.onTrackingFakeViewStart();
                this.onTrackingFakeViewUpdate(0.0f);
            } else if (((Boolean)this._trackingToOpenMW.getValue()).booleanValue() && !this.miniWindowAlreadyOpen) {
                this.onTrackingFakeViewUpdate(f2);
            }
            return (Boolean)this._trackingToOpenMW.getValue();
        }
        if (object4 != null && (Integer)object4 == 1 || object4 != null && (Integer)object4 == 3) {
            if (!(this.mCanTrackingEnterMW && ((Boolean)this._trackingToOpenMW.getValue()).booleanValue() || !this.mStartEnterMiniWindow)) {
                return false;
            }
            object4 = this.getRealView();
            if (object4 != null && (object4 = ((DynamicIslandBaseContentView)((Object)object4)).getDynamicIslandEventCoordinator()) != null && ((DynamicIslandEventCoordinator)object4).islandFreeformAnimating(this.getRealView()) && this.mInitialTouchY - object.getY() > 100.0f) {
                this.freeFormGestureBack();
            }
            this.onTrackingFakeViewEnd();
            boolean bl5 = this.mStartEnterMiniWindow;
            boolean bl6 = this.needResetState;
            object = new StringBuilder();
            ((StringBuilder)object).append("fakeView handled Touch UP/CANCEL: (");
            ((StringBuilder)object).append(bl5);
            ((StringBuilder)object).append(" || ");
            ((StringBuilder)object).append(bl6);
            ((StringBuilder)object).append(")");
            Log.d((String)TAG, (String)((StringBuilder)object).toString());
            bl6 = bl;
            if (!this.mStartEnterMiniWindow) {
                bl6 = this.needResetState ? bl : false;
            }
            return bl6;
        }
        boolean bl7 = this.mCanTrackingEnterMW;
        object4 = object != null ? Integer.valueOf(object.getAction()) : null;
        object3 = object2;
        if (object != null) {
            object3 = object.getActionMasked();
        }
        object = new StringBuilder();
        ((StringBuilder)object).append("fakeView finally handledTouchEvent: ");
        ((StringBuilder)object).append(bl7);
        ((StringBuilder)object).append(", ");
        ((StringBuilder)object).append(object4);
        ((StringBuilder)object).append(", ");
        ((StringBuilder)object).append(object3);
        Log.e((String)TAG, (String)((StringBuilder)object).toString());
        return false;
    }

    @Override
    public void hideIslandLayout() {
        super.hideIslandLayout();
        this.getController().getIslandTemplateFactory().hideView(this.getCurrentIslandData(), true);
    }

    public final boolean isSameRectForApp(Rect rect) {
        boolean bl;
        Object object = this.getRealView();
        Object object2 = null;
        Object object3 = object2;
        if (object != null) {
            object = object.getCurrentIslandData();
            object3 = object2;
            if (object != null) {
                object = object.getKey();
                object3 = object2;
                if (object != null) {
                    Object object4 = this.getDynamicIslandEventCoordinator();
                    object3 = object2;
                    if (object4 != null) {
                        object4 = ((DynamicIslandEventCoordinator)object4).getWindowView();
                        object3 = object2;
                        if (object4 != null) {
                            object4 = ((DynamicIslandWindowView)((Object)object4)).getWindowViewController();
                            object3 = object2;
                            if (object4 != null) {
                                object4 = ((DynamicIslandWindowViewController)object4).getAppCloseRect();
                                object3 = object2;
                                if (object4 != null) {
                                    object3 = (Rect)((HashMap)object4).get(object);
                                }
                            }
                        }
                    }
                }
            }
        }
        if (!(bl = rect != null ? rect.equals(object3) : false) && (object3 = this.getRealView()) != null && (object3 = object3.getCurrentIslandData()) != null && (object3 = object3.getKey()) != null && (object2 = this.getDynamicIslandEventCoordinator()) != null && (object2 = ((DynamicIslandEventCoordinator)object2).getWindowView()) != null && (object2 = ((DynamicIslandWindowView)((Object)object2)).getWindowViewController()) != null) {
            ((DynamicIslandWindowViewController)object2).addAppCloseRect((String)object3, rect);
        }
        return bl;
    }

    public void onFinishInflate() {
        super.onFinishInflate();
        this.setFakeContainer((FrameLayout)this.findViewById(R.id.fake_container));
        this.setFakeExpandedView((FrameLayout)this.findViewById(R.id.fake_expanded_view));
        this.setFakeBigIsland((FrameLayout)this.findViewById(R.id.fake_big_island_view));
        this.setFakeSmallIsland((FrameLayout)this.findViewById(R.id.fake_small_island_view));
        this.setFakeMask(this.findViewById(R.id.fake_island_mask));
        this.setMiniBar(this.findViewById(R.id.mini_window_bar));
        FrameLayout frameLayout = this.getFakeExpandedView();
        o.e((Object)frameLayout, (String)"null cannot be cast to non-null type android.view.View");
        DynamicIslandBaseContentView.updateBackgroundBg$default(this, (View)frameLayout, false, 2, null);
        if (CommonUtils.INSTANCE.getIS_TABLET()) {
            this.setBackground(null);
        }
    }

    @Override
    public void onIslandClick() {
        super.onIslandClick();
    }

    public final void onStateChanged(DynamicIslandContentView object) {
        block73: {
            DynamicIslandState dynamicIslandState;
            block79: {
                Object var14_15;
                Object object2;
                Object object3;
                int n;
                int n2;
                Object object4;
                block75: {
                    block76: {
                        block78: {
                            block77: {
                                DynamicIslandState dynamicIslandState2;
                                block74: {
                                    Object var8_13;
                                    Object var13_12;
                                    Object var10_11;
                                    block72: {
                                        o.g((Object)object, (String)"view");
                                        object4 = this.getDynamicIslandEventCoordinator();
                                        n2 = object4 != null && ((DynamicIslandEventCoordinator)object4).islandAppAnimating((DynamicIslandContentView)((Object)object)) ? 1 : 0;
                                        object4 = this.getDynamicIslandEventCoordinator();
                                        n = object4 != null && ((DynamicIslandEventCoordinator)object4).islandFreeformAnimating((DynamicIslandContentView)((Object)object)) ? 1 : 0;
                                        dynamicIslandState = ((DynamicIslandBaseContentView)((Object)object)).getState();
                                        if (dynamicIslandState instanceof DynamicIslandState.AppExpanded) {
                                            this.suppressBigIslandLayout = false;
                                        }
                                        dynamicIslandState2 = ((DynamicIslandBaseContentView)((Object)object)).getLastState();
                                        boolean bl = dynamicIslandState2 instanceof DynamicIslandState.SmallIsland;
                                        Object var12_8 = null;
                                        Object var9_9 = null;
                                        object3 = null;
                                        var10_11 = null;
                                        var13_12 = null;
                                        var8_13 = null;
                                        object2 = null;
                                        object4 = null;
                                        var14_15 = null;
                                        Object var11_16 = null;
                                        if (!bl) break block72;
                                        if (dynamicIslandState instanceof DynamicIslandState.BigIsland) {
                                            if (n2 != 0 || n != 0) {
                                                object4 = DynamicIslandBaseContentView.getBigIslandRect$default((DynamicIslandBaseContentView)((Object)object), null, 1, null);
                                                object2 = ((DynamicIslandBaseContentView)((Object)object)).getCurrentIslandData();
                                                if (object2 != null && (object2 = object2.getExtras()) != null) {
                                                    object2.putParcelable("position", (Parcelable)object4);
                                                }
                                                if ((object4 = this.getDynamicIslandEventCoordinator()) != null) {
                                                    object2 = ((DynamicIslandBaseContentView)((Object)object)).getCurrentIslandData();
                                                    object = var11_16;
                                                    if (object2 != null) {
                                                        object = object2.getExtras();
                                                    }
                                                    ((DynamicIslandEventCoordinator)object4).smallToBig((Bundle)object);
                                                }
                                            }
                                        } else if (dynamicIslandState instanceof DynamicIslandState.Expanded) {
                                            if (n2 != 0 || n != 0) {
                                                object4 = ((DynamicIslandContentView)((Object)object)).getExpandedIslandRect();
                                                object2 = ((DynamicIslandBaseContentView)((Object)object)).getCurrentIslandData();
                                                if (object2 != null && (object2 = object2.getExtras()) != null) {
                                                    object2.putParcelable("position", (Parcelable)object4);
                                                }
                                                if ((object4 = this.getDynamicIslandEventCoordinator()) != null) {
                                                    object2 = ((DynamicIslandBaseContentView)((Object)object)).getCurrentIslandData();
                                                    object = var12_8;
                                                    if (object2 != null) {
                                                        object = object2.getExtras();
                                                    }
                                                    ((DynamicIslandEventCoordinator)object4).smallToExpanded((Bundle)object);
                                                }
                                            }
                                        } else if (dynamicIslandState instanceof DynamicIslandState.SmallIsland) {
                                            object4 = ((DynamicIslandBaseContentView)((Object)object)).getWindowState();
                                            if (object4 != null && ((DynamicIslandWindowState)object4).isShowOnceIsland() && n2 != 0) {
                                                this.updateAppAnimatingPosition((DynamicIslandContentView)((Object)object));
                                            } else if ((n != 0 || n2 != 0) && this.pkgHasMultIslands(this.getRealView())) {
                                                object4 = this.getCurrentSmallRect((DynamicIslandContentView)((Object)object));
                                                if (n2 != 0 && this.isSameRectForApp((Rect)object4)) {
                                                    return;
                                                }
                                                object2 = ((DynamicIslandBaseContentView)((Object)object)).getCurrentIslandData();
                                                if (object2 != null && (object2 = object2.getExtras()) != null) {
                                                    object2.putParcelable("position", (Parcelable)object4);
                                                }
                                                if ((object4 = this.getDynamicIslandEventCoordinator()) != null) {
                                                    object2 = ((DynamicIslandBaseContentView)((Object)object)).getCurrentIslandData();
                                                    object = var9_9;
                                                    if (object2 != null) {
                                                        object = object2.getExtras();
                                                    }
                                                    ((DynamicIslandEventCoordinator)object4).positionChanged((Bundle)object);
                                                }
                                            }
                                        } else if (dynamicIslandState instanceof DynamicIslandState.Hidden && (n != 0 || n2 != 0) && this.pkgHasMultIslands(this.getRealView())) {
                                            object4 = ((DynamicIslandBaseContentView)((Object)object)).getDynamicIslandEventCoordinator();
                                            object4 = object4 != null && (object4 = ((DynamicIslandEventCoordinator)object4).getWindowView()) != null ? ((DynamicIslandWindowView)((Object)object4)).getCutoutRect() : null;
                                            if (n2 != 0 && this.isSameRectForApp((Rect)object4)) {
                                                return;
                                            }
                                            object2 = ((DynamicIslandBaseContentView)((Object)object)).getCurrentIslandData();
                                            if (object2 != null && (object2 = object2.getExtras()) != null) {
                                                object2.putParcelable("position", (Parcelable)object4);
                                            }
                                            if ((object4 = this.getDynamicIslandEventCoordinator()) != null) {
                                                object2 = ((DynamicIslandBaseContentView)((Object)object)).getCurrentIslandData();
                                                object = object3;
                                                if (object2 != null) {
                                                    object = object2.getExtras();
                                                }
                                                ((DynamicIslandEventCoordinator)object4).positionChanged((Bundle)object);
                                            }
                                        }
                                        break block73;
                                    }
                                    if (!(dynamicIslandState2 instanceof DynamicIslandState.BigIsland)) break block74;
                                    if (dynamicIslandState instanceof DynamicIslandState.SmallIsland) {
                                        if (n2 != 0 || n != 0) {
                                            object4 = this.getCurrentSmallRect((DynamicIslandContentView)((Object)object));
                                            object2 = ((DynamicIslandBaseContentView)((Object)object)).getCurrentIslandData();
                                            if (object2 != null && (object2 = object2.getExtras()) != null) {
                                                object2.putParcelable("position", (Parcelable)object4);
                                            }
                                            if ((object4 = this.getDynamicIslandEventCoordinator()) != null) {
                                                object2 = ((DynamicIslandBaseContentView)((Object)object)).getCurrentIslandData();
                                                object = var10_11;
                                                if (object2 != null) {
                                                    object = object2.getExtras();
                                                }
                                                ((DynamicIslandEventCoordinator)object4).bigToSmall((Bundle)object);
                                            }
                                            if (n2 != 0) {
                                                this.setClosingToExpanded(false, true);
                                            }
                                        }
                                    } else if (dynamicIslandState instanceof DynamicIslandState.Expanded) {
                                        if (n2 != 0 || n != 0) {
                                            object4 = ((DynamicIslandContentView)((Object)object)).getExpandedIslandRect();
                                            object2 = ((DynamicIslandBaseContentView)((Object)object)).getCurrentIslandData();
                                            if (object2 != null && (object2 = object2.getExtras()) != null) {
                                                object2.putParcelable("position", (Parcelable)object4);
                                            }
                                            if ((object4 = this.getDynamicIslandEventCoordinator()) != null) {
                                                object2 = ((DynamicIslandBaseContentView)((Object)object)).getCurrentIslandData();
                                                object = var13_12;
                                                if (object2 != null) {
                                                    object = object2.getExtras();
                                                }
                                                ((DynamicIslandEventCoordinator)object4).bigToExpanded((Bundle)object);
                                            }
                                        }
                                    } else if (dynamicIslandState instanceof DynamicIslandState.BigIsland) {
                                        object4 = ((DynamicIslandBaseContentView)((Object)object)).getWindowState();
                                        if (object4 != null && ((DynamicIslandWindowState)object4).isShowOnceIsland() && n2 != 0) {
                                            this.updateAppAnimatingPosition((DynamicIslandContentView)((Object)object));
                                        } else if (n != 0 && this.pkgHasMultIslands(this.getRealView())) {
                                            object4 = DynamicIslandBaseContentView.getBigIslandRect$default((DynamicIslandBaseContentView)((Object)object), null, 1, null);
                                            object2 = ((DynamicIslandBaseContentView)((Object)object)).getCurrentIslandData();
                                            if (object2 != null && (object2 = object2.getExtras()) != null) {
                                                object2.putParcelable("position", (Parcelable)object4);
                                            }
                                            if ((object4 = this.getDynamicIslandEventCoordinator()) != null) {
                                                object2 = ((DynamicIslandBaseContentView)((Object)object)).getCurrentIslandData();
                                                object = var8_13;
                                                if (object2 != null) {
                                                    object = object2.getExtras();
                                                }
                                                ((DynamicIslandEventCoordinator)object4).positionChanged((Bundle)object);
                                            }
                                        }
                                    }
                                    break block73;
                                }
                                if (!(dynamicIslandState2 instanceof DynamicIslandState.Expanded)) break block73;
                                if (!(dynamicIslandState instanceof DynamicIslandState.SmallIsland)) break block75;
                                if (n2 == 0 && n == 0) break block76;
                                object4 = this.getDynamicIslandEventCoordinator();
                                if (object4 == null || (object4 = ((DynamicIslandEventCoordinator)object4).getBigIslandStateHandler()) == null) break block77;
                                object4 = object3 = ((BigIslandStateHandler)object4).getCurrent();
                                if (object3 != null) break block78;
                            }
                            object4 = object;
                        }
                        object3 = this.getContext();
                        o.f((Object)object3, (String)"getContext(...)");
                        if (CommonUtils.isLayoutRtl((Context)object3)) {
                            n2 = DynamicIslandBaseContentView.getCurrentBigIslandX$default((DynamicIslandBaseContentView)((Object)object4), null, 1, null) - ((DynamicIslandBaseContentView)((Object)object)).getSpace() - ((DynamicIslandBaseContentView)((Object)object)).getSmallIslandViewWidth();
                        } else {
                            object3 = Boolean.TRUE;
                            n = ((DynamicIslandBaseContentView)((Object)object4)).getCurrentBigIslandX((Boolean)object3);
                            n2 = ((DynamicIslandBaseContentView)((Object)object4)).getCurrentBigIslandWidth((Boolean)object3);
                            n2 = ((DynamicIslandBaseContentView)((Object)object)).getSpace() + (n + n2);
                        }
                        object4 = ((DynamicIslandBaseContentView)((Object)object)).getSmallIslandRect(n2);
                        object3 = ((DynamicIslandBaseContentView)((Object)object)).getCurrentIslandData();
                        if (object3 != null && (object3 = object3.getExtras()) != null) {
                            object3.putParcelable("position", (Parcelable)object4);
                        }
                        if ((object4 = this.getDynamicIslandEventCoordinator()) != null) {
                            object = (object = ((DynamicIslandBaseContentView)((Object)object)).getCurrentIslandData()) != null ? object.getExtras() : null;
                            ((DynamicIslandEventCoordinator)object4).expandedToSmall((Bundle)object);
                        }
                    }
                    if ((object4 = this.getDynamicIslandEventCoordinator()) != null) {
                        object3 = this.getRealView();
                        object = object2;
                        if (object3 != null) {
                            object3 = ((DynamicIslandBaseContentView)((Object)object3)).getCurrentIslandData();
                            object = object2;
                            if (object3 != null) {
                                object = object3.getExtras();
                            }
                        }
                        ((DynamicIslandEventCoordinator)object4).onWindowAnimExtendLifetimeEnd((Bundle)object);
                    }
                    break block79;
                }
                if (dynamicIslandState instanceof DynamicIslandState.BigIsland) {
                    if (n2 != 0 || n != 0) {
                        object2 = DynamicIslandBaseContentView.getBigIslandRect$default((DynamicIslandBaseContentView)((Object)object), null, 1, null);
                        object3 = ((DynamicIslandBaseContentView)((Object)object)).getCurrentIslandData();
                        if (object3 != null && (object3 = object3.getExtras()) != null) {
                            object3.putParcelable("position", (Parcelable)object2);
                        }
                        if ((object2 = this.getDynamicIslandEventCoordinator()) != null) {
                            object = (object = ((DynamicIslandBaseContentView)((Object)object)).getCurrentIslandData()) != null ? object.getExtras() : null;
                            ((DynamicIslandEventCoordinator)object2).expandedToBig((Bundle)object);
                        }
                    }
                    if ((object2 = this.getDynamicIslandEventCoordinator()) != null) {
                        object3 = this.getRealView();
                        object = object4;
                        if (object3 != null) {
                            object3 = ((DynamicIslandBaseContentView)((Object)object3)).getCurrentIslandData();
                            object = object4;
                            if (object3 != null) {
                                object = object3.getExtras();
                            }
                        }
                        ((DynamicIslandEventCoordinator)object2).onWindowAnimExtendLifetimeEnd((Bundle)object);
                    }
                } else if (dynamicIslandState instanceof DynamicIslandState.Hidden && (object4 = this.getDynamicIslandEventCoordinator()) != null) {
                    object2 = this.getRealView();
                    object = var14_15;
                    if (object2 != null) {
                        object2 = ((DynamicIslandBaseContentView)((Object)object2)).getCurrentIslandData();
                        object = var14_15;
                        if (object2 != null) {
                            object = object2.getExtras();
                        }
                    }
                    ((DynamicIslandEventCoordinator)object4).onWindowAnimExtendLifetimeEnd((Bundle)object);
                }
            }
            if (!(dynamicIslandState instanceof DynamicIslandState.Expanded) && !(dynamicIslandState instanceof DynamicIslandState.MiniWindowExpanded) && ((Boolean)this.trackingToOpenMW.getValue()).booleanValue()) {
                Log.d((String)TAG, (String)"tracking intercept by expand state change to other state.");
                this.onTrackingFakeViewEnd();
            }
        }
    }

    public final void resetFakeViewState() {
        FrameLayout frameLayout = this.getFakeBigIsland();
        if (frameLayout != null) {
            frameLayout.setScaleX(1.0f);
        }
        frameLayout = this.getFakeBigIsland();
        if (frameLayout != null) {
            frameLayout.setScaleY(1.0f);
        }
        frameLayout = this.getFakeBigIsland();
        if (frameLayout != null) {
            frameLayout.setTranslationY(0.0f);
        }
        frameLayout = this.getFakeSmallIsland();
        if (frameLayout != null) {
            frameLayout.setScaleX(1.0f);
        }
        frameLayout = this.getFakeSmallIsland();
        if (frameLayout != null) {
            frameLayout.setScaleY(1.0f);
        }
        frameLayout = this.getFakeSmallIsland();
        if (frameLayout != null) {
            frameLayout.setTranslationY(0.0f);
        }
        frameLayout = this.getFakeSmallIsland();
        if (frameLayout != null) {
            frameLayout.setTranslationX(0.0f);
        }
        this.updateExpandViewPivot();
        frameLayout = this.getFakeExpandedView();
        if (frameLayout != null) {
            frameLayout.setScaleX(1.0f);
        }
        frameLayout = this.getFakeExpandedView();
        if (frameLayout != null) {
            frameLayout.setScaleY(1.0f);
        }
        frameLayout = this.getFakeExpandedView();
        if (frameLayout != null) {
            frameLayout.setTranslationX(0.0f);
        }
        frameLayout = this.getFakeExpandedView();
        if (frameLayout != null) {
            frameLayout.setTranslationY(0.0f);
        }
        frameLayout = this.getMiniBar();
        if (frameLayout != null) {
            frameLayout.setScaleX(1.0f);
        }
        frameLayout = this.getMiniBar();
        if (frameLayout != null) {
            frameLayout.setScaleY(1.0f);
        }
    }

    @Override
    public void resetStatus() {
        this.setOpenAppFromIsland(false);
        Object object = this.getRealView();
        if (object != null && (object = object.getState()) != null && !(object instanceof DynamicIslandState.MiniWindowExpanded) && !(object instanceof DynamicIslandState.SubMiniWindowExpanded)) {
            this.mStartEnterMiniWindow = false;
        }
    }

    public final void resetTrackOpenMW() {
        this._trackingToOpenMW.setValue((Object)Boolean.FALSE);
    }

    public final void setAppClosingToExpanded(boolean bl) {
        this.appClosingToExpanded = bl;
    }

    public final void setBigIslandTx(float f2) {
        this.bigIslandTx = f2;
    }

    public final void setBigIslandViewNeedAnim(boolean bl) {
        this.bigIslandViewNeedAnim = bl;
    }

    public final void setClosingAppFromFreeform(boolean bl) {
        this.closingAppFromFreeform = bl;
    }

    public final void setClosingToExpanded(boolean bl) {
        if (this.closingToExpanded == bl) {
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("closingToExpanded: ");
        stringBuilder.append(bl);
        Log.d((String)TAG, (String)stringBuilder.toString());
        this.closingToExpanded = bl;
    }

    public final void setClosingToExpanded(boolean bl, boolean bl2) {
        this.setClosingToExpanded(bl2);
        if (bl) {
            this.miniWindowClosingToExpanded = bl2;
        } else {
            this.appClosingToExpanded = bl2;
        }
    }

    @Override
    public void setController(DynamicIslandBaseContentViewController<?> iFolme) {
        o.g(iFolme, (String)"controller");
        super.setController((DynamicIslandBaseContentViewController<?>)iFolme);
        FolmeObject folmeObject = FolmeKt.FolmeObject();
        E e = iFolme.getScope();
        iFolme = null;
        f1.f.b((E)e, null, null, (U0.o)new U0.o(folmeObject, this, null){
            final FolmeObject $this_apply;
            int label;
            final DynamicIslandContentFakeView this$0;
            {
                this.$this_apply = folmeObject;
                this.this$0 = dynamicIslandContentFakeView;
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
                    FolmeKt.cleanWhenViewDetached((FolmeObject)this.$this_apply, (View)this.this$0);
                    return s.a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }, (int)3, null);
        this.folmeObject = folmeObject;
        if (folmeObject != null) {
            iFolme = FolmeKt.getFolme((FolmeObject)folmeObject);
        }
        this.folme = iFolme;
    }

    public final void setForceUpdateBigIslandView(boolean bl) {
        this.forceUpdateBigIslandView = bl;
    }

    public final void setMiniWindowClosingToExpanded(boolean bl) {
        this.miniWindowClosingToExpanded = bl;
    }

    public void setVisibility(int n) {
        int n2 = this.getVisibility();
        Object object = this.getRealView();
        Object var4_4 = null;
        if ((object = object != null ? object.getState() : null) != null && n2 == 0 && n == 4 && !((object = (object = this.getRealView()) != null ? object.getState() : null) instanceof DynamicIslandState.AppExpanded) && !((object = (object = this.getRealView()) != null ? object.getState() : null) instanceof DynamicIslandState.MiniWindowExpanded) && (object = this.getDynamicIslandEventCoordinator()) != null && ((DynamicIslandEventCoordinator)object).isIslandWindowAnimating(this.getRealView())) {
            DynamicIslandEventCoordinator dynamicIslandEventCoordinator;
            Log.d((String)TAG, (String)"hide surface because fakeView visibility change");
            this.syncIslandLottieProgress(true);
            object = this.getRealView();
            if (object != null) {
                object.setVisibility(0);
            }
            object = this.getRealView();
            object = object != null ? object.getBackgroundView() : null;
            if (object != null) {
                ((DynamicIslandBackgroundView)((Object)object)).setVisibility(0);
            }
            object = this.getRealView();
            if (object != null) {
                object.postDelayed(new c(this), 50L);
            }
            if ((object = this.getRealView()) != null) {
                object.setOpenAppFromIsland(false);
            }
            object = this.getDynamicIslandEventCoordinator();
            if (object != null) {
                ((DynamicIslandEventCoordinator)object).updateIslandWindowAnimRunning(false, this.getRealView(), false);
            }
            if ((dynamicIslandEventCoordinator = this.getDynamicIslandEventCoordinator()) != null) {
                DynamicIslandContentView dynamicIslandContentView = this.getRealView();
                object = var4_4;
                if (dynamicIslandContentView != null) {
                    dynamicIslandContentView = dynamicIslandContentView.getCurrentIslandData();
                    object = var4_4;
                    if (dynamicIslandContentView != null) {
                        object = dynamicIslandContentView.getExtras();
                    }
                }
                dynamicIslandEventCoordinator.onWindowAnimExtendLifetimeEnd((Bundle)object);
            }
        }
        super.setVisibility(n);
    }

    @Override
    public void showIslandLayout() {
        super.showIslandLayout();
        this.getController().getIslandTemplateFactory().showView(this.getCurrentIslandData(), true);
    }

    @Override
    public void showShadowNoANim() {
        this.updateShadow((DynamicIslandBaseContentView)this, this.getContext().getResources().getColor(R.color.shader_color));
    }

    public final void suppressBigIslandChange(boolean bl) {
        this.suppressBigIslandLayout = bl;
    }

    @Override
    public void updateBigIslandLayout() {
        boolean bl = this.suppressBigIslandLayout;
        boolean bl2 = this.bigIslandViewNeedAnim;
        boolean bl3 = this.forceUpdateBigIslandView;
        Object object = new StringBuilder();
        ((StringBuilder)object).append("updateBigIslandLayout,  ");
        ((StringBuilder)object).append(bl);
        ((StringBuilder)object).append(", ");
        ((StringBuilder)object).append(bl2);
        ((StringBuilder)object).append(" ");
        ((StringBuilder)object).append(bl3);
        Log.d((String)TAG, (String)((StringBuilder)object).toString());
        if (this.bigIslandViewNeedAnim && (object = this.getRealView()) != null && ((DynamicIslandBaseContentView)((Object)object)).hasSmallIsland()) {
            this.bigIslandViewNeedAnim = false;
        }
        if ((object = this.getRealView()) != null) {
            int n = ((DynamicIslandBaseContentView)((Object)object)).getBigIslandMarginWidth();
            object = this.getBigIslandAreaMargin();
            object = object != null ? object.getLayoutParams() : null;
            if (object != null) {
                ((ViewGroup.LayoutParams)object).width = n;
            }
        }
        if (this.suppressBigIslandLayout && !this.bigIslandViewNeedAnim && !this.forceUpdateBigIslandView) {
            return;
        }
        this.updateBigIslandLayoutWithAnim(this.getFakeFirstLayout(), this.getFakeSecondLayout(), this.getFakeBigContainer(), this.getFakeBigIsland(), this.getRealView(), true);
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    @Override
    public Object updateBigIslandView(DynamicIslandData var1_1, boolean var2_2, d var3_3) {
        if (!(var3_3 /* !! */  instanceof updateBigIslandView.1)) ** GOTO lbl-1000
        var5_4 /* !! */  = var3_3 /* !! */ ;
        var4_5 = var5_4 /* !! */ .label;
        if ((var4_5 & -2147483648) != 0) {
            var5_4 /* !! */ .label = var4_5 + -2147483648;
            var3_3 /* !! */  = var5_4 /* !! */ ;
        } else lbl-1000:
        // 2 sources

        {
            var3_3 /* !! */  = new M0.d(this, var3_3 /* !! */ ){
                Object L$0;
                int label;
                Object result;
                final DynamicIslandContentFakeView this$0;
                {
                    this.this$0 = dynamicIslandContentFakeView;
                    super(d2);
                }

                public final Object invokeSuspend(Object object) {
                    this.result = object;
                    this.label |= Integer.MIN_VALUE;
                    return this.this$0.updateBigIslandView(null, false, (d)this);
                }
            };
        }
        var5_4 /* !! */  = var3_3 /* !! */ .result;
        var6_6 = L0.c.c();
        var4_5 = var3_3 /* !! */ .label;
        if (var4_5 == 0) ** GOTO lbl19
        if (var4_5 == 1) {
            var1_1 = (DynamicIslandContentFakeView)var3_3 /* !! */ .L$0;
            k.b((Object)var5_4 /* !! */ );
            var3_3 /* !! */  = var5_4 /* !! */ ;
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
lbl19:
            // 1 sources

            k.b((Object)var5_4 /* !! */ );
            Log.e((String)"DynamicIslandContentFakeView", (String)"updateBigIslandView");
            this.setCurrentIslandData((DynamicIslandData)var1_1);
            if (this.getFakeBigIsland() == null) {
                return M0.b.a((boolean)false);
            }
            if (!var2_2 && (var5_4 /* !! */  = this.getFakeBigIsland()) != null) {
                var5_4 /* !! */ .removeAllViews();
            }
            var10_7 = this.getController().getIslandTemplateFactory();
            var5_4 /* !! */  = this.getContext();
            o.f((Object)var5_4 /* !! */ , (String)"getContext(...)");
            var7_8 = this.getTemplate();
            var9_9 = this.getFakeBigIsland();
            o.e((Object)var9_9, (String)"null cannot be cast to non-null type android.view.ViewGroup");
            var8_10 = updateBigIslandView.view.1.INSTANCE;
            var3_3 /* !! */ .L$0 = this;
            var3_3 /* !! */ .label = 1;
            var5_4 /* !! */  = var10_7.createBigIslandTemplate((Context)var5_4 /* !! */ , (DynamicIslandData)var1_1, var7_8, (ViewGroup)var9_9, true, var8_10, var3_3 /* !! */ );
            var1_1 = this;
            var3_3 /* !! */  = var5_4 /* !! */ ;
            if (var5_4 /* !! */  == var6_6) {
                return var6_6;
            }
        }
        if ((View)var3_3 /* !! */  == null) {
            return M0.b.a((boolean)false);
        }
        var3_3 /* !! */  = var1_1.getFakeBigIsland();
        var5_4 /* !! */  = null;
        var3_3 /* !! */  = var3_3 /* !! */  != null ? (LinearLayout)var3_3 /* !! */ .findViewById(R.id.fake_big_container) : null;
        var1_1.setFakeBigContainer((LinearLayout)var3_3 /* !! */ );
        var3_3 /* !! */  = var1_1.getFakeBigIsland();
        var3_3 /* !! */  = var3_3 /* !! */  != null ? (FrameLayout)var3_3 /* !! */ .findViewById(R.id.fake_area_left) : null;
        var1_1.setFakeFirstLayout((FrameLayout)var3_3 /* !! */ );
        var3_3 /* !! */  = var1_1.getFakeBigIsland();
        var3_3 /* !! */  = var3_3 /* !! */  != null ? (FrameLayout)var3_3 /* !! */ .findViewById(R.id.fake_area_right) : null;
        var1_1.setFakeSecondLayout((FrameLayout)var3_3 /* !! */ );
        var3_3 /* !! */  = var1_1.getFakeBigIsland();
        var3_3 /* !! */  = var3_3 /* !! */  != null ? (FrameLayout)var3_3 /* !! */ .findViewById(R.id.area_margin) : null;
        var1_1.setBigIslandAreaMargin((FrameLayout)var3_3 /* !! */ );
        var6_6 = var1_1.getFakeBigIsland();
        var3_3 /* !! */  = var5_4 /* !! */ ;
        if (var6_6 != null) {
            var3_3 /* !! */  = var6_6.getLayoutParams();
        }
        if (var3_3 /* !! */  != null) {
            var3_3 /* !! */ .height = var1_1.getIslandViewHeight();
        }
        return M0.b.a((boolean)true);
    }

    public final void updateExpandViewBlur(int n, boolean bl, boolean bl2) {
        FrameLayout frameLayout = this.getFakeExpandedView();
        if (frameLayout != null) {
            Context context = frameLayout.getContext();
            o.f((Object)context, (String)"getContext(...)");
            if (MiBlurCompat.getBackgroundBlurOpened((Context)context) && frameLayout.getParent() != null) {
                frameLayout.setOutlineProvider(new ViewOutlineProvider(bl, bl2, this, n){
                    final int $bottom;
                    final boolean $isFreeform;
                    final boolean $openApp;
                    final DynamicIslandContentFakeView this$0;
                    {
                        this.$isFreeform = bl;
                        this.$openApp = bl2;
                        this.this$0 = dynamicIslandContentFakeView;
                        this.$bottom = n;
                    }

                    public void getOutline(View view2, Outline outline) {
                        int n;
                        int n2;
                        Context context;
                        DynamicIslandContentFakeView dynamicIslandContentFakeView;
                        o.g((Object)view2, (String)"view");
                        o.g((Object)outline, (String)"outline");
                        if (!this.$isFreeform && this.$openApp) {
                            dynamicIslandContentFakeView = this.this$0;
                            context = dynamicIslandContentFakeView.getContext();
                            o.f((Object)context, (String)"getContext(...)");
                            n2 = DynamicIslandContentFakeView.access$getScreenWidth(dynamicIslandContentFakeView, context);
                        } else {
                            n2 = view2.getRight();
                        }
                        if (this.$isFreeform) {
                            n = this.$bottom;
                        } else if (this.$openApp) {
                            dynamicIslandContentFakeView = this.this$0;
                            context = dynamicIslandContentFakeView.getContext();
                            o.f((Object)context, (String)"getContext(...)");
                            n = DynamicIslandContentFakeView.access$getScreenHeight(dynamicIslandContentFakeView, context);
                        } else {
                            n = view2.getBottom();
                        }
                        view2.getRenderNode().setPosition(new Rect(view2.getLeft(), view2.getTop(), n2, n));
                        outline.setRoundRect(0, 0, n2, n, DynamicIslandContentFakeView.access$getRadius$p(this.this$0));
                    }
                });
            }
        }
    }

    @Override
    public Object updateExpandedView(DynamicIslandData dynamicIslandData, boolean bl, d object) {
        Object object2;
        Object var5_4 = null;
        object = dynamicIslandData != null ? dynamicIslandData.getFakeView() : null;
        object2 = dynamicIslandData != null && (object2 = dynamicIslandData.getFakeView()) != null && (object2 = object2.getLayoutParams()) != null ? M0.b.c((int)object2.width) : null;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("updateExpandedView, islandData?.fakeView=");
        stringBuilder.append(object);
        stringBuilder.append(" ");
        stringBuilder.append(object2);
        Log.e((String)TAG, (String)stringBuilder.toString());
        object = dynamicIslandData != null ? dynamicIslandData.getFakeView() : null;
        if (object == null) {
            return s.a;
        }
        object = dynamicIslandData.getFakeView();
        object = object != null ? object.getLayoutParams() : null;
        if (object == null) {
            object = new FrameLayout.LayoutParams(-1, -2);
            object.gravity = 1;
            object2 = dynamicIslandData.getFakeView();
            if (object2 != null) {
                object2.setLayoutParams((ViewGroup.LayoutParams)object);
            }
        }
        if ((object = (object = dynamicIslandData.getFakeView()) != null ? object.getParent() : null) != null) {
            object = dynamicIslandData.getFakeView();
            object = object != null ? object.getParent() : null;
            o.e((Object)object, (String)"null cannot be cast to non-null type android.view.ViewGroup");
            ((ViewGroup)object).removeView(dynamicIslandData.getFakeView());
        }
        if ((object = dynamicIslandData.getFakeView()) != null && (object = object.getLayoutParams()) != null && object.width == -1) {
            object2 = dynamicIslandData.getFakeView();
            object = var5_4;
            if (object2 != null) {
                object = object2.getLayoutParams();
            }
            if (object != null) {
                object.width = this.getExpandedViewMaxWidth();
            }
        }
        if ((object = this.getFakeExpandedView()) != null) {
            object.removeAllViews();
        }
        if ((object = this.getFakeExpandedView()) != null) {
            object.addView(dynamicIslandData.getFakeView());
        }
        return s.a;
    }

    public final void updateExpandedViewScaleForFreeform(float f2, boolean bl) {
        if (bl) {
            this.resetExpandedViewScaleForFreeform();
            if (this.getState() instanceof DynamicIslandState.MiniWindowExpanded) {
                this.contentTracker.finishTrack();
            }
            return;
        }
        DynamicIslandEventCoordinator dynamicIslandEventCoordinator = this.getDynamicIslandEventCoordinator();
        if (dynamicIslandEventCoordinator != null && dynamicIslandEventCoordinator.islandFreeformAnimating(this.getRealView())) {
            float f3;
            int n = this.mFakeViewWidth;
            float f4 = n;
            float f5 = f3 = 1.0f;
            if (!(f4 <= 0.0f)) {
                if (f2 <= 0.0f) {
                    f5 = f3;
                } else {
                    f5 = f2 / (float)n;
                    if (Float.isInfinite(f5)) {
                        f5 = f3;
                    } else if (Float.isNaN(f5)) {
                        f5 = f3;
                    }
                }
            }
            if ((dynamicIslandEventCoordinator = this.getFakeExpandedView()) != null) {
                dynamicIslandEventCoordinator.setPivotX(0.0f);
            }
            dynamicIslandEventCoordinator = this.getFakeExpandedView();
            if (dynamicIslandEventCoordinator != null) {
                dynamicIslandEventCoordinator.setPivotY(0.0f);
            }
            dynamicIslandEventCoordinator = this.getFakeExpandedView();
            if (dynamicIslandEventCoordinator != null) {
                dynamicIslandEventCoordinator.setScaleX(f5);
            }
            dynamicIslandEventCoordinator = this.getFakeExpandedView();
            if (dynamicIslandEventCoordinator != null) {
                dynamicIslandEventCoordinator.setScaleY(f5);
            }
            this.updateExpandViewBlur(this.getTop() + this.getHeight(), true, false);
        }
    }

    public final void updateFVOffsetYWhenMWAnimating(float f2) {
        this.contentTracker.updateTrack(f2 - (float)this.mFakeViewHeight - (float)this.mFakeViewTop);
    }

    public final void updateFakeExpandedViewState() {
        boolean bl = this.appClosingToExpanded;
        boolean bl2 = this.closingToExpanded;
        Object object = new StringBuilder();
        ((StringBuilder)object).append("updateFakeExpandedViewState: ");
        ((StringBuilder)object).append(bl);
        ((StringBuilder)object).append(", ");
        ((StringBuilder)object).append(bl2);
        Log.d((String)"DynamicIslandAnimDebug", (String)((StringBuilder)object).toString());
        if (this.appClosingToExpanded) {
            this.resetFakeViewState();
            object = this.getDynamicIslandEventCoordinator();
            if (object != null) {
                ((DynamicIslandEventCoordinator)object).resetFakeViewAnimState(this.getRealView(), true);
            }
        }
        if (this.miniWindowClosingToExpanded && (object = this.getDynamicIslandEventCoordinator()) != null) {
            ((DynamicIslandEventCoordinator)object).resetFakeViewAnimState(this.getRealView(), false);
        }
    }

    public final void updateLiveUpdateExpandedView(boolean bl) {
        FrameLayout frameLayout = this.getFakeExpandedView();
        o.e((Object)frameLayout, (String)"null cannot be cast to non-null type android.view.View");
        this.updateBackgroundBg((View)frameLayout, bl);
    }

    @Override
    public void updateMarginTop() {
        this.updateMarginTop((View)this.getFakeExpandedView());
        this.updateMarginTop((View)this.getFakeBigIsland());
        this.updateMarginTop((View)this.getFakeSmallIsland());
        this.updateMarginTop(this.getMiniBar());
    }

    @Override
    public Object updateSmallIslandView(DynamicIslandData object, boolean bl, d d2) {
        Object object2;
        Log.e((String)TAG, (String)"updateSmallIslandView");
        if (!bl && (object2 = this.getFakeSmallIsland()) != null) {
            object2.removeAllViews();
        }
        IslandTemplateFactory islandTemplateFactory = this.getController().getIslandTemplateFactory();
        Context context = this.getContext();
        o.f((Object)context, (String)"getContext(...)");
        object2 = this.getTemplate();
        FrameLayout frameLayout = this.getFakeSmallIsland();
        o.e((Object)frameLayout, (String)"null cannot be cast to non-null type android.view.ViewGroup");
        object = islandTemplateFactory.createSmallIslandTemplate(context, (DynamicIslandData)object, (IslandTemplate)object2, (ViewGroup)frameLayout, true, updateSmallIslandView.2.INSTANCE, d2);
        if (object == L0.c.c()) {
            return object;
        }
        return s.a;
    }

    public final void updateViewStateWhenCloseEnd(boolean bl, String object) {
        o.g((Object)object, (String)"from");
        boolean bl2 = this.appClosingToExpanded;
        Object object2 = this._trackingToOpenMW.getValue();
        boolean bl3 = this.mStartEnterMiniWindow;
        boolean bl4 = this.miniWindowClosingToExpanded;
        Object object3 = new StringBuilder();
        ((StringBuilder)object3).append("updateViewStateWhenCloseEnd: ");
        ((StringBuilder)object3).append(bl);
        ((StringBuilder)object3).append(", ");
        ((StringBuilder)object3).append(bl2);
        ((StringBuilder)object3).append(", ");
        ((StringBuilder)object3).append(object2);
        ((StringBuilder)object3).append(", ");
        ((StringBuilder)object3).append(bl3);
        ((StringBuilder)object3).append("\uff0c ");
        ((StringBuilder)object3).append(bl4);
        Log.d((String)"DynamicIslandAnimDebug", (String)((StringBuilder)object3).toString());
        if (o.c((Object)object, (Object)"open_app_error")) {
            this.blockByError = true;
        }
        if ((object = this.getRealView()) != null) {
            ((DynamicIslandContentView)((Object)object)).setAppReturnIslandButNoAppState(false);
        }
        this.resetFakeViewState();
        if (!bl) {
            this.bigIslandViewNeedAnim = false;
        }
        if ((object = this.getRealView()) != null) {
            ((DynamicIslandBaseContentView)((Object)object)).setOpenAppFromIsland(false);
        }
        this.setOpenAppFromIsland(false);
        this.suppressBigIslandChange(false);
        object2 = null;
        object3 = null;
        if (!bl && this.appClosingToExpanded && (((Boolean)this._trackingToOpenMW.getValue()).booleanValue() || this.mStartEnterMiniWindow)) {
            this.setClosingToExpanded(false);
            this.appClosingToExpanded = false;
            object2 = this.getDynamicIslandEventCoordinator();
            if (object2 != null) {
                DynamicIslandContentView dynamicIslandContentView = this.getRealView();
                object = object3;
                if (dynamicIslandContentView != null) {
                    dynamicIslandContentView = dynamicIslandContentView.getCurrentIslandData();
                    object = object3;
                    if (dynamicIslandContentView != null) {
                        object = dynamicIslandContentView.getExtras();
                    }
                }
                ((DynamicIslandEventCoordinator)object2).alreadyCloseAppEnd((Bundle)object);
            }
            return;
        }
        if (bl && this.closingToExpanded && (((Boolean)this.startEnterMiniWindowBeforeAnimation.getValue()).booleanValue() || (object = (object = this.getRealView()) != null ? ((DynamicIslandBaseContentView)((Object)object)).getState() : null) instanceof DynamicIslandState.MiniWindowExpanded)) {
            this.setClosingToExpanded(false);
            return;
        }
        this.contentTracker.finishTrack();
        this.closingAppFromFreeform = false;
        this.setClosingToExpanded(false);
        this.appClosingToExpanded = false;
        this.miniWindowClosingToExpanded = false;
        object = this.getContext();
        o.f((Object)object, (String)"getContext(...)");
        int n = this.getScreenWidth((Context)object);
        object = this.getContext();
        o.f((Object)object, (String)"getContext(...)");
        this.setLeftTopRightBottom(0, 0, n, this.getScreenHeight((Context)object));
        this.alreadyOpenApp();
        object = this.getDynamicIslandEventCoordinator();
        if (object != null) {
            ((DynamicIslandEventCoordinator)object).resetContainerAlpha(this.getRealView());
        }
        if (!bl) {
            this.syncIslandLottieProgress(true);
            object = this.getRealView();
            if (object != null) {
                ((DynamicIslandContentView)((Object)object)).showShadowWithAnim();
            }
        }
        if ((object = this.getRealView()) != null) {
            object.setVisibility(0);
        }
        object3 = this.getRealView();
        object = object2;
        if (object3 != null) {
            object = ((DynamicIslandBaseContentView)((Object)object3)).getBackgroundView();
        }
        if (object != null) {
            ((DynamicIslandBackgroundView)((Object)object)).setVisibility(0);
        }
        this.setVisibility(4);
        object = this.getRealView();
        if (object != null) {
            object.postDelayed((Runnable)new a(this), 50L);
        }
        if (this.getRealView() != null && (object = this.getDynamicIslandEventCoordinator()) != null) {
            ((DynamicIslandEventCoordinator)object).resetFakeViewAnimState(this.getRealView(), true);
        }
        if (!bl) {
            this.updateExpandViewBlur(0, false, false);
        }
    }

    public final void updateViewStateWhenOpenAnimStart() {
        Choreographer.getInstance().postFrameCallback((Choreographer.FrameCallback)new b(this));
    }
}
