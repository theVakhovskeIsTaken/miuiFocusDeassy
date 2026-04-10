/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  G0.j
 *  G0.j$a
 *  G0.k
 *  G0.s
 *  K0.d
 *  L0.c
 *  M0.b
 *  M0.d
 *  U0.a
 *  U0.o
 *  android.app.ActivityManager$RunningTaskInfo
 *  android.app.Notification
 *  android.app.PendingIntent
 *  android.app.TaskInfo
 *  android.content.Context
 *  android.graphics.Color
 *  android.graphics.Outline
 *  android.graphics.Rect
 *  android.os.Bundle
 *  android.os.Parcelable
 *  android.service.notification.StatusBarNotification
 *  android.util.AttributeSet
 *  android.util.Log
 *  android.view.MotionEvent
 *  android.view.View
 *  android.view.View$AccessibilityDelegate
 *  android.view.View$MeasureSpec
 *  android.view.View$OnAttachStateChangeListener
 *  android.view.View$OnHoverListener
 *  android.view.ViewGroup
 *  android.view.ViewGroup$LayoutParams
 *  android.view.ViewOutlineProvider
 *  android.view.ViewParent
 *  android.view.ViewStub
 *  android.view.ViewTreeObserver$OnPreDrawListener
 *  android.view.accessibility.AccessibilityNodeInfo
 *  android.view.accessibility.AccessibilityNodeInfo$AccessibilityAction
 *  android.widget.FrameLayout
 *  android.widget.FrameLayout$LayoutParams
 *  android.widget.LinearLayout
 *  android.widget.TextView
 *  androidx.annotation.RequiresApi
 *  androidx.core.view.ViewGroupKt
 *  com.android.systemui.plugins.miui.dynamicisland.DynamicIslandData
 *  e1.n
 *  f1.l0
 *  f1.l0$a
 *  kotlin.jvm.internal.d
 *  kotlin.jvm.internal.h
 *  kotlin.jvm.internal.o
 *  miui.systemui.animation.FolmeKt
 *  miui.systemui.notification.ActivityManagerWrapper
 *  miui.systemui.util.CommonUtils
 *  miui.systemui.util.FoldUtils
 *  miui.systemui.util.IActivityTaskManagerCompat
 *  miui.systemui.widget.CircularProgressBar
 *  miuix.animation.Folme
 *  miuix.animation.FolmeEase
 *  miuix.animation.property.FloatProperty
 *  miuix.animation.utils.EaseManager$EaseStyle
 *  miuix.colorful.texteffect.TimerTextEffectView
 *  miuix.core.util.MiShadowUtils
 *  systemui.plugin.eventtracking.EventTracker
 *  systemui.plugin.eventtracking.EventTracker$Companion
 */
package miui.systemui.dynamicisland.window.content;

import G0.j;
import G0.k;
import G0.s;
import L0.c;
import M0.b;
import U0.a;
import android.app.ActivityManager;
import android.app.Notification;
import android.app.PendingIntent;
import android.app.TaskInfo;
import android.content.Context;
import android.graphics.Color;
import android.graphics.Outline;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Parcelable;
import android.service.notification.StatusBarNotification;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewOutlineProvider;
import android.view.ViewParent;
import android.view.ViewStub;
import android.view.ViewTreeObserver;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.RequiresApi;
import androidx.core.view.ViewGroupKt;
import com.android.systemui.plugins.miui.dynamicisland.DynamicIslandData;
import e1.n;
import f1.l0;
import java.util.Arrays;
import java.util.WeakHashMap;
import kotlin.jvm.internal.h;
import kotlin.jvm.internal.o;
import miui.systemui.animation.FolmeKt;
import miui.systemui.dynamicisland.DynamicIslandAnimUtils;
import miui.systemui.dynamicisland.DynamicIslandBackgroundView;
import miui.systemui.dynamicisland.DynamicIslandUtils;
import miui.systemui.dynamicisland.R;
import miui.systemui.dynamicisland.anim.DynamicIslandAnimationController;
import miui.systemui.dynamicisland.display.AntiBurnInManager;
import miui.systemui.dynamicisland.event.DynamicIslandEvent;
import miui.systemui.dynamicisland.event.DynamicIslandEventCoordinator;
import miui.systemui.dynamicisland.event.DynamicIslandState;
import miui.systemui.dynamicisland.event.State;
import miui.systemui.dynamicisland.event.handler.BigIslandStateHandler;
import miui.systemui.dynamicisland.event.handler.ExpandedStateHandler;
import miui.systemui.dynamicisland.event.handler.SmallIslandStateHandler;
import miui.systemui.dynamicisland.event.handler.StateHandler;
import miui.systemui.dynamicisland.events.DynamicIslandEventTracker;
import miui.systemui.dynamicisland.model.IslandContentViewCalculationParams;
import miui.systemui.dynamicisland.model.IslandContentViewCalculationResult;
import miui.systemui.dynamicisland.model.IslandContentViewHolder;
import miui.systemui.dynamicisland.model.IslandTemplate;
import miui.systemui.dynamicisland.template.IslandTemplateFactory;
import miui.systemui.dynamicisland.view.DynamicGlowEffectView;
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
import miui.systemui.dynamicisland.window.content.DynamicIslandContentViewController;
import miui.systemui.dynamicisland.window.content.DynamicIslandContentViewExtKt;
import miui.systemui.dynamicisland.window.content.d;
import miui.systemui.notification.ActivityManagerWrapper;
import miui.systemui.util.CommonUtils;
import miui.systemui.util.FoldUtils;
import miui.systemui.util.IActivityTaskManagerCompat;
import miui.systemui.widget.CircularProgressBar;
import miuix.animation.Folme;
import miuix.animation.FolmeEase;
import miuix.animation.property.FloatProperty;
import miuix.animation.utils.EaseManager;
import miuix.colorful.texteffect.TimerTextEffectView;
import miuix.core.util.MiShadowUtils;
import systemui.plugin.eventtracking.EventTracker;

public final class DynamicIslandContentView
extends DynamicIslandBaseContentView {
    private static final EaseManager.EaseStyle ANTI_BURN_IN_EASE;
    public static final float BG_ANTI_BURN_IN_ALPHA = 0.6f;
    public static final float BG_NORMAL_ALPHA = 1.0f;
    public static final int BIG_ISLAND_ANTI_BURN_IN_ALPHA = 0;
    public static final int BIG_ISLAND_NORMAL_ALPHA = 255;
    private static final FloatProperty<DynamicIslandContentView> CONTAINER_BG_ALPHA;
    public static final Companion Companion;
    public static final String TAG = "DynamicIslandContentView";
    private final SHADOW_ALPHA.1 SHADOW_ALPHA;
    private boolean appReturnIslandButNoAppState;
    private boolean blockChildrenTouch;
    private boolean blockChildrenTouchOnDown;
    private AntiBurnInManager.BurnInStates burnInState;
    private float containerBgAlpha;
    private l0 enterJob;
    private final exposeListener.1 exposeListener;
    private long exposedBurnInUnit;
    private long exposedUnit;
    private l0 extendJob;
    private boolean hasEverBurnedIn;
    private int mixedColor;
    private long remainingBurnInUnit;
    private long remainingUnit;
    private boolean remainingUnitInited;
    private l0 restoreJob;
    private final WeakHashMap<View, Integer> shadeBackUp;
    private float shadowAlpha;

    static {
        Companion = new Object(null){
            {
                this();
            }

            public final EaseManager.EaseStyle getANTI_BURN_IN_EASE() {
                return ANTI_BURN_IN_EASE;
            }

            public final FloatProperty<DynamicIslandContentView> getCONTAINER_BG_ALPHA() {
                return CONTAINER_BG_ALPHA;
            }
        };
        ANTI_BURN_IN_EASE = FolmeEase.spring((float)1.0f, (float)0.2f);
        CONTAINER_BG_ALPHA = new FloatProperty<DynamicIslandContentView>(){

            @RequiresApi(value=19)
            public float getValue(DynamicIslandContentView dynamicIslandContentView) {
                o.g((Object)((Object)dynamicIslandContentView), (String)"view");
                return dynamicIslandContentView.getContainerBgAlpha();
            }

            public void setValue(DynamicIslandContentView dynamicIslandContentView, float f2) {
                o.g((Object)((Object)dynamicIslandContentView), (String)"view");
                if (Float.isNaN(f2)) {
                    return;
                }
                dynamicIslandContentView.setContainerBgAlpha(f2);
            }
        };
    }

    public DynamicIslandContentView(Context context, AttributeSet object) {
        o.g((Object)context, (String)"context");
        super(context, (AttributeSet)object);
        object = AntiBurnInManager.Companion;
        this.remainingUnit = object.getMAX_EXPOSE_TIME_OUT();
        this.remainingBurnInUnit = object.getEXTEND_EXPOSE_TIME();
        this.containerBgAlpha = 1.0f;
        this.burnInState = AntiBurnInManager.BurnInStates.Normal;
        this.shadeBackUp = new WeakHashMap();
        this.mixedColor = context.getColor(R.color.big_island_background_color_hover);
        this.exposeListener = new ViewTreeObserver.OnPreDrawListener(this){
            final DynamicIslandContentView this$0;
            {
                this.this$0 = dynamicIslandContentView;
            }

            public boolean onPreDraw() {
                ((DynamicIslandContentViewController)this.this$0.getController()).onPreDraw();
                return true;
            }
        };
        this.SHADOW_ALPHA = new FloatProperty<DynamicIslandContentView>(){

            public float getValue(DynamicIslandContentView dynamicIslandContentView) {
                o.g((Object)((Object)dynamicIslandContentView), (String)"view");
                return DynamicIslandContentView.access$getShadowAlpha$p(dynamicIslandContentView);
            }

            public void setValue(DynamicIslandContentView dynamicIslandContentView, float f2) {
                o.g((Object)((Object)dynamicIslandContentView), (String)"view");
                if (Float.isNaN(f2)) {
                    return;
                }
                DynamicIslandContentView.access$setShadowAlpha(dynamicIslandContentView, f2);
            }
        };
    }

    public /* synthetic */ DynamicIslandContentView(Context context, AttributeSet attributeSet, int n, h h2) {
        if ((n & 2) != 0) {
            attributeSet = null;
        }
        this(context, attributeSet);
    }

    public static /* synthetic */ boolean a(DynamicIslandContentView dynamicIslandContentView, View view, MotionEvent motionEvent) {
        return DynamicIslandContentView.initBigIslandHoverEffect$lambda$3(dynamicIslandContentView, view, motionEvent);
    }

    public static final /* synthetic */ float access$getShadowAlpha$p(DynamicIslandContentView dynamicIslandContentView) {
        return dynamicIslandContentView.shadowAlpha;
    }

    public static final /* synthetic */ void access$setShadowAlpha(DynamicIslandContentView dynamicIslandContentView, float f) {
        dynamicIslandContentView.setShadowAlpha(f);
    }

    public static final /* synthetic */ void access$updateContentDescriptionIfNeed(DynamicIslandContentView dynamicIslandContentView, View view, DynamicIslandData dynamicIslandData) {
        dynamicIslandContentView.updateContentDescriptionIfNeed(view, dynamicIslandData);
    }

    private final void addOnAttachStateChangeListenerSafe(View view, View.OnAttachStateChangeListener onAttachStateChangeListener) {
        if (view != null && onAttachStateChangeListener != null) {
            view.removeOnAttachStateChangeListener(onAttachStateChangeListener);
            view.addOnAttachStateChangeListener(onAttachStateChangeListener);
        }
    }

    private final void applyPreMeasureMode(ViewGroup viewGroup, boolean bl) {
        int n = viewGroup.getChildCount();
        for (int j = 0; j < n; ++j) {
            View view = viewGroup.getChildAt(j);
            if (view instanceof TimerTextEffectView) {
                ((TimerTextEffectView)view).enablePreMeasureMode(bl);
            }
            if (!(view instanceof ViewGroup)) continue;
            this.applyPreMeasureMode((ViewGroup)view, bl);
        }
    }

    private final boolean canBigIslandClick(DynamicIslandState object) {
        boolean bl;
        boolean bl2;
        object = this.getCurrentIslandData();
        Object var8_2 = null;
        object = object != null && (object = object.getExtras()) != null ? object.getString("miui.pkg.name") : null;
        Object object2 = this.getDynamicIslandEventCoordinator();
        object2 = object2 != null && (object2 = ((DynamicIslandEventCoordinator)object2).getSmallIslandStateHandler()) != null ? ((SmallIslandStateHandler)object2).getCurrent() : null;
        Object object3 = object2 != null ? ((DynamicIslandBaseContentView)((Object)object2)).getPkgName() : null;
        Object object4 = this.getDynamicIslandEventCoordinator();
        object4 = object4 != null && (object4 = ((DynamicIslandEventCoordinator)object4).getHiddenStateHandler()) != null ? ((StateHandler)object4).getCurrent() : null;
        String string = object4 != null ? ((DynamicIslandBaseContentView)((Object)object4)).getPkgName() : null;
        if (o.c((Object)object, (Object)object3)) {
            object3 = this.getDynamicIslandEventCoordinator();
            if (object3 != null && ((DynamicIslandEventCoordinator)object3).isIslandWindowAnimating(this)) {
                Log.w((String)TAG, (String)"case1: can not click on big island -> big island animating");
                return false;
            }
            if (object2 != null) {
                object3 = this.getDynamicIslandEventCoordinator();
                object2 = object3 != null ? Boolean.valueOf(((DynamicIslandEventCoordinator)object3).isIslandWindowAnimating((DynamicIslandContentView)((Object)object2))) : null;
                bl2 = o.c((Object)object2, (Object)Boolean.TRUE);
            } else {
                bl2 = false;
            }
            if (bl2) {
                Log.w((String)TAG, (String)"can not click on big island -> small island animating");
                return false;
            }
        }
        if (o.c((Object)object, (Object)string)) {
            object2 = this.getDynamicIslandEventCoordinator();
            bl = object2 != null && ((DynamicIslandEventCoordinator)object2).isIslandWindowAnimating(this);
            if (bl) {
                Log.w((String)TAG, (String)"case2: can not click on big island -> big island animating");
                return false;
            }
            if (object4 != null) {
                object2 = this.getDynamicIslandEventCoordinator();
                object2 = object2 != null ? Boolean.valueOf(((DynamicIslandEventCoordinator)object2).isIslandWindowAnimating((DynamicIslandContentView)((Object)object4))) : null;
                bl2 = o.c((Object)object2, (Object)Boolean.TRUE);
            } else {
                bl2 = false;
            }
            if (bl2) {
                Log.w((String)TAG, (String)"can not click on big island -> hidden island animating");
                return false;
            }
        }
        object2 = (object2 = this.getDynamicIslandEventCoordinator()) != null && (object2 = ((DynamicIslandEventCoordinator)object2).getExpandedStateHandler()) != null ? ((ExpandedStateHandler)object2).getCurrent() : null;
        object4 = var8_2;
        if (object2 != null) {
            object3 = ((DynamicIslandBaseContentView)((Object)object2)).getCurrentIslandData();
            object4 = var8_2;
            if (object3 != null) {
                object3 = object3.getExtras();
                object4 = var8_2;
                if (object3 != null) {
                    object4 = object3.getString("miui.pkg.name");
                }
            }
        }
        if (object2 != null && (bl = (object3 = this.getDynamicIslandEventCoordinator()) != null && ((DynamicIslandEventCoordinator)object3).isIslandWindowAnimating((DynamicIslandContentView)((Object)object2))) && o.c((Object)object, (Object)object4)) {
            Log.w((String)TAG, (String)"can not click on big island -> expanded island animating");
            return false;
        }
        return true;
    }

    private final boolean canClick(DynamicIslandState object) {
        Object object2 = this.getCurrentIslandData();
        object2 = object2 != null ? object2.getKey() : null;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("try perform click on ");
        stringBuilder.append((String)object2);
        Log.i((String)TAG, (String)stringBuilder.toString());
        object2 = this.getDynamicIslandEventCoordinator();
        if (object2 != null && ((DynamicIslandEventCoordinator)object2).isTempHidden(this)) {
            Log.w((String)TAG, (String)"can not click on tempHiddenIsland");
            return false;
        }
        if (DynamicIslandContentViewExtKt.pkgHasOtherIslandWindowAnimating(this)) {
            Log.w((String)TAG, (String)"can not click on pkgHasOtherIslandWindowAnimating");
            return false;
        }
        if (this.appReturnIslandButNoAppState) {
            Log.w((String)TAG, (String)"can not click: appReturnIslandButNoAppState");
            return false;
        }
        if (CommonUtils.INSTANCE.getIS_TABLET() && object instanceof DynamicIslandState.BigIsland && (object = this.getDynamicIslandEventCoordinator()) != null && ((DynamicIslandEventCoordinator)object).getWindowAnimRunning()) {
            Log.w((String)TAG, (String)"can not click: TABLET windowAnimRunning");
            return false;
        }
        return true;
    }

    private final boolean canSmallIslandClick(DynamicIslandState object) {
        DynamicIslandEventCoordinator dynamicIslandEventCoordinator;
        Object object2;
        object = this.getCurrentIslandData();
        DynamicIslandEventCoordinator dynamicIslandEventCoordinator2 = null;
        object = object != null && (object = object.getExtras()) != null ? object.getString("miui.pkg.name") : null;
        Object object3 = this.getDynamicIslandEventCoordinator();
        object3 = object3 != null && (object3 = ((DynamicIslandEventCoordinator)object3).getBigIslandStateHandler()) != null ? ((BigIslandStateHandler)object3).getCurrent() : null;
        object2 = object3 != null && (object2 = ((DynamicIslandBaseContentView)((Object)object3)).getCurrentIslandData()) != null && (object2 = object2.getExtras()) != null ? object2.getString("miui.pkg.name") : null;
        if (object3 != null && (dynamicIslandEventCoordinator = this.getDynamicIslandEventCoordinator()) != null && dynamicIslandEventCoordinator.isIslandWindowAnimating((DynamicIslandContentView)((Object)object3)) && o.c((Object)object2, (Object)object)) {
            Log.w((String)TAG, (String)"can not click on small island -> big island animating");
            return false;
        }
        object3 = this.getDynamicIslandEventCoordinator();
        object3 = object3 != null && (object3 = ((DynamicIslandEventCoordinator)object3).getExpandedStateHandler()) != null ? ((ExpandedStateHandler)object3).getCurrent() : null;
        object2 = dynamicIslandEventCoordinator2;
        if (object3 != null) {
            dynamicIslandEventCoordinator = ((DynamicIslandBaseContentView)((Object)object3)).getCurrentIslandData();
            object2 = dynamicIslandEventCoordinator2;
            if (dynamicIslandEventCoordinator != null) {
                dynamicIslandEventCoordinator = dynamicIslandEventCoordinator.getExtras();
                object2 = dynamicIslandEventCoordinator2;
                if (dynamicIslandEventCoordinator != null) {
                    object2 = dynamicIslandEventCoordinator.getString("miui.pkg.name");
                }
            }
        }
        if (object3 != null && (dynamicIslandEventCoordinator2 = this.getDynamicIslandEventCoordinator()) != null && dynamicIslandEventCoordinator2.isIslandWindowAnimating((DynamicIslandContentView)((Object)object3)) && o.c((Object)object, (Object)object2)) {
            Log.w((String)TAG, (String)"can not click on small island -> expanded island animating");
            return false;
        }
        return true;
    }

    private final String collectAllText4Accessibility(View object, DynamicIslandData dynamicIslandData) {
        if (object == null) {
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder();
        DynamicIslandUtils dynamicIslandUtils = DynamicIslandUtils.INSTANCE;
        Context context = this.getContext();
        o.f((Object)context, (String)"getContext(...)");
        boolean bl = dynamicIslandUtils.getAppName(context, dynamicIslandData) != null;
        DynamicIslandContentView.collectAllText4Accessibility$traverse(this, stringBuilder, bl, object);
        object = stringBuilder.toString();
        o.f((Object)object, (String)"toString(...)");
        return object;
    }

    /*
     * Enabled aggressive block sorting
     */
    private static final void collectAllText4Accessibility$traverse(DynamicIslandContentView object, StringBuilder stringBuilder, boolean bl, View object2) {
        block22: {
            CircularProgressBar circularProgressBar;
            block21: {
                block18: {
                    block20: {
                        TextView textView;
                        block19: {
                            if (object2.getVisibility() != 0) {
                                return;
                            }
                            if (object2 instanceof ViewGroup) {
                                object2 = ViewGroupKt.getChildren((ViewGroup)((ViewGroup)object2)).iterator();
                                while (object2.hasNext()) {
                                    DynamicIslandContentView.collectAllText4Accessibility$traverse((DynamicIslandContentView)((Object)object), stringBuilder, bl, (View)object2.next());
                                }
                                return;
                            }
                            if (!(object2 instanceof TextView)) break block18;
                            textView = (TextView)object2;
                            object = textView.getContentDescription();
                            object2 = null;
                            if (object == null) break block19;
                            String string = object.toString();
                            object = string;
                            if (string != null) break block20;
                        }
                        object = (object = textView.getText()) != null ? object.toString() : null;
                    }
                    if (object == null) return;
                    if (!n.n((CharSequence)object)) {
                        object2 = object;
                    }
                    if (object2 == null) return;
                    if (stringBuilder.length() > 0) {
                        stringBuilder.append(",");
                    } else if (bl) {
                        stringBuilder.append(":");
                    }
                    stringBuilder.append((String)object2);
                    return;
                }
                if (!(object2 instanceof CircularProgressBar)) return;
                circularProgressBar = (CircularProgressBar)object2;
                object = circularProgressBar.getContentDescription();
                if (object == null) break block21;
                object = object2 = object.toString();
                if (object2 != null) break block22;
            }
            if (circularProgressBar.getMaxProgress() == 0.0f || circularProgressBar.getTargetProgress() == 0.0f) {
                object = "0.0%";
            } else {
                object = String.format("%.1f%%", Arrays.copyOf(new Object[]{Float.valueOf(circularProgressBar.getTargetProgress() / circularProgressBar.getMaxProgress() * (float)100)}, 1));
                o.f((Object)object, (String)"format(...)");
            }
        }
        if (stringBuilder.length() > 0) {
            stringBuilder.append(",");
        } else if (bl) {
            stringBuilder.append(":");
        }
        stringBuilder.append((String)object);
    }

    private final void handleOpenApp(StatusBarNotification statusBarNotification) {
        Object object;
        Object object2 = this.getCurrentIslandData();
        if (object2 != null && (object2 = object2.getExtras()) != null) {
            object2.putBoolean("extra_open_freeform_in_workbench_mode", false);
        }
        if (DynamicIslandAnimUtils.INSTANCE.supportShowElementAnim()) {
            this.setOpenAppFromIsland(true);
        } else {
            object2 = this.getDynamicIslandEventCoordinator();
            if (object2 != null && (object2 = ((DynamicIslandEventCoordinator)object2).getWindowView()) != null) {
                ((DynamicIslandWindowView)((Object)object2)).appEnter(this);
            }
        }
        object2 = this.getDynamicIslandEventCoordinator();
        if (object2 != null) {
            object = this.getContext();
            o.f((Object)object, (String)"getContext(...)");
            ((DynamicIslandEventCoordinator)object2).collapseStatusBar((Context)object);
        }
        if ((object2 = this.getDynamicIslandEventCoordinator()) != null) {
            ((DynamicIslandEventCoordinator)object2).setUserExpanded(false);
        }
        object = this.getDynamicIslandEventCoordinator();
        if (object != null) {
            object2 = this.getCurrentIslandData();
            object2 = object2 != null ? object2.getExtras() : null;
            ((DynamicIslandEventCoordinator)object).openApp((Bundle)object2);
        }
        if (statusBarNotification != null) {
            DynamicIslandUtils.INSTANCE.clearIslandNotification(statusBarNotification);
        }
    }

    private final <T extends View> T inheritViewWidth(T object, a a2) {
        int n2 = object != null ? object.getWidth() : 0;
        if ((a2 = (View)a2.invoke()) != null) {
            object = !o.c(object, (Object)a2) && n2 > 0 ? a2 : null;
            if (object != null && (object = object.getLayoutParams()) != null) {
                object.width = n2;
            }
        }
        return (T)a2;
    }

    private final void inheritWidth() {
        this.setBigContainer(this.inheritViewWidth(this.getBigContainer(), new a(this){
            final DynamicIslandContentView this$0;
            {
                this.this$0 = dynamicIslandContentView;
                super(0);
            }

            public final LinearLayout invoke() {
                DynamicIslandBigIslandView dynamicIslandBigIslandView = this.this$0.getBigIslandView();
                dynamicIslandBigIslandView = dynamicIslandBigIslandView != null ? (LinearLayout)dynamicIslandBigIslandView.findViewById(R.id.big_container) : null;
                return dynamicIslandBigIslandView;
            }
        }));
        this.setSmallContainer(this.inheritViewWidth(this.getSmallContainer(), new a(this){
            final DynamicIslandContentView this$0;
            {
                this.this$0 = dynamicIslandContentView;
                super(0);
            }

            public final FrameLayout invoke() {
                Object object = this.this$0.getSmallIslandView();
                object = object != null ? (FrameLayout)object.findViewById(R.id.small_container) : null;
                return object;
            }
        }));
        this.setBigIslandAreaLeft(this.inheritViewWidth(this.getBigIslandAreaLeft(), new a(this){
            final DynamicIslandContentView this$0;
            {
                this.this$0 = dynamicIslandContentView;
                super(0);
            }

            public final FrameLayout invoke() {
                DynamicIslandBigIslandView dynamicIslandBigIslandView = this.this$0.getBigIslandView();
                dynamicIslandBigIslandView = dynamicIslandBigIslandView != null ? (FrameLayout)dynamicIslandBigIslandView.findViewById(R.id.area_left) : null;
                return dynamicIslandBigIslandView;
            }
        }));
        this.setBigIslandAreaRight(this.inheritViewWidth(this.getBigIslandAreaRight(), new a(this){
            final DynamicIslandContentView this$0;
            {
                this.this$0 = dynamicIslandContentView;
                super(0);
            }

            public final FrameLayout invoke() {
                DynamicIslandBigIslandView dynamicIslandBigIslandView = this.this$0.getBigIslandView();
                dynamicIslandBigIslandView = dynamicIslandBigIslandView != null ? (FrameLayout)dynamicIslandBigIslandView.findViewById(R.id.area_right) : null;
                return dynamicIslandBigIslandView;
            }
        }));
    }

    private final void initBigIslandHoverEffect(View view) {
        view.setOnHoverListener((View.OnHoverListener)new d(this));
    }

    private static final boolean initBigIslandHoverEffect$lambda$3(DynamicIslandContentView dynamicIslandContentView, View view, MotionEvent motionEvent) {
        boolean bl;
        o.g((Object)((Object)dynamicIslandContentView), (String)"this$0");
        int n2 = motionEvent.getAction();
        if (n2 != 9) {
            bl = false;
            if (n2 == 10) {
                view.setBackground(null);
            }
        } else {
            view.setBackgroundColor(dynamicIslandContentView.mixedColor);
            bl = true;
        }
        return bl;
    }

    private final void initViewModel() {
        this.getViewModel().registerDynamicIslandViewStateChangeCallback(new DynamicIslandViewModel.DynamicIslandViewStateChangeCallback(this){
            final DynamicIslandContentView this$0;
            {
                this.this$0 = dynamicIslandContentView;
            }

            public void onStateChanged(DynamicIslandState object, DynamicIslandState object2) {
                Object var5_3 = null;
                Object var6_4 = null;
                Object object3 = object != null ? Boolean.valueOf(((State)object).getTempShow()) : null;
                Boolean bl = object2 != null ? Boolean.valueOf(((State)object2).getTempShow()) : null;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("initViewModel1 state: ");
                stringBuilder.append(object);
                stringBuilder.append(" ");
                stringBuilder.append(object3);
                stringBuilder.append(" ->");
                stringBuilder.append(object2);
                stringBuilder.append(" ");
                stringBuilder.append(bl);
                Log.e((String)"DynamicIslandContentView", (String)stringBuilder.toString());
                if (object2 instanceof DynamicIslandState.BigIsland) {
                    object3 = this.this$0.getDynamicIslandEventCoordinator();
                    object2 = var6_4;
                    if (object3 != null) {
                        object2 = ((DynamicIslandEventCoordinator)object3).getAnimationController();
                    }
                    if (object2 != null) {
                        ((DynamicIslandAnimationController)object2).setCurrentBigIsland((DynamicIslandState)object);
                    }
                } else if (object2 instanceof DynamicIslandState.Expanded) {
                    DynamicIslandContentViewExtKt.dispatchAutoExpand(this.this$0);
                    object2 = this.this$0.getDynamicIslandEventCoordinator();
                    object2 = object2 != null ? ((DynamicIslandEventCoordinator)object2).getAnimationController() : null;
                    if (object2 != null) {
                        object3 = this.this$0.getDynamicIslandEventCoordinator();
                        object3 = object3 != null && (object3 = ((DynamicIslandEventCoordinator)object3).getAnimationController()) != null ? ((DynamicIslandAnimationController)object3).getCurrentExpanded() : null;
                        ((DynamicIslandAnimationController)object2).setLastExpanded((DynamicIslandState)object3);
                    }
                    object3 = this.this$0.getDynamicIslandEventCoordinator();
                    object2 = var5_3;
                    if (object3 != null) {
                        object2 = ((DynamicIslandEventCoordinator)object3).getAnimationController();
                    }
                    if (object2 != null) {
                        ((DynamicIslandAnimationController)object2).setCurrentExpanded((DynamicIslandState)object);
                    }
                } else if (object2 instanceof DynamicIslandState.Deleted) {
                    object = (object2).getDeleteKey();
                    this.this$0.getController().getIslandTemplateFactory().removeTemplate((String)object);
                }
            }

            public void onStateChanged(DynamicIslandContentView dynamicIslandContentView) {
                Object object;
                Object object2;
                Object var6_2 = null;
                Object object3 = dynamicIslandContentView != null ? dynamicIslandContentView.getLastState() : null;
                object2 = dynamicIslandContentView != null && (object2 = dynamicIslandContentView.getLastState()) != null ? Boolean.valueOf(((State)object2).getTempShow()) : null;
                DynamicIslandState dynamicIslandState = dynamicIslandContentView != null ? dynamicIslandContentView.getState() : null;
                object = dynamicIslandContentView != null && (object = dynamicIslandContentView.getState()) != null ? Boolean.valueOf(((State)object).getTempShow()) : null;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("initViewModel2 state: ");
                stringBuilder.append(object3);
                stringBuilder.append(" ");
                stringBuilder.append(object2);
                stringBuilder.append(" ->");
                stringBuilder.append(dynamicIslandState);
                stringBuilder.append(" ");
                stringBuilder.append(object);
                Log.e((String)"DynamicIslandContentView", (String)stringBuilder.toString());
                ((DynamicIslandContentViewController)this.this$0.getController()).onStateChange();
                object3 = var6_2;
                if (dynamicIslandContentView != null) {
                    object3 = dynamicIslandContentView.getState();
                }
                if (object3 instanceof DynamicIslandState.Deleted && (object3 = this.this$0.getState()) != null && (object3 = ((State)object3).getDeleteKey()) != null) {
                    this.this$0.getController().getIslandTemplateFactory().removeTemplate((String)object3);
                }
                if ((object3 = this.this$0.getDynamicIslandEventCoordinator()) != null) {
                    ((DynamicIslandEventCoordinator)object3).alignBurnInStates();
                }
                if ((object3 = this.this$0.getDynamicIslandEventCoordinator()) != null && (object3 = ((DynamicIslandEventCoordinator)object3).getAnimationController()) != null) {
                    ((DynamicIslandAnimationController)object3).onStateChange(dynamicIslandContentView);
                }
            }
        });
    }

    private final void removeByError() {
        block7: {
            this.removeAllViews();
            ViewParent viewParent = null;
            this.setState(null);
            Object object = this.getParent();
            object = object instanceof View ? (View)object : null;
            if (object != null) {
                if (object.getParent() != null) {
                    viewParent = object;
                }
                if (viewParent != null) {
                    object = this.getDynamicIslandEventCoordinator();
                    if (object == null) break block7;
                    object = object.getWindowView();
                    if (object == null) break block7;
                    try {
                        object.removeView((View)viewParent);
                        object = s.a;
                    }
                    catch (Exception exception) {
                        Log.w((String)TAG, (String)"Error removing container view", (Throwable)exception);
                    }
                }
            }
        }
    }

    private final void resetOpenAppFromIsland() {
        this.setOpenAppFromIsland(false);
    }

    private final void setShadowAlpha(float f2) {
        if (this.shadowAlpha == f2) {
            return;
        }
        this.shadowAlpha = f2;
        this.updateShadow((DynamicIslandBaseContentView)this, Color.argb((int)Math.round(f2 * (float)115), (int)0, (int)0, (int)0));
    }

    private final void updateContentDescriptionIfNeed(View view, DynamicIslandData object) {
        Object object2 = this.getTemplate();
        Object object3 = object2 != null ? ((IslandTemplate)object2).getAppContentDescription() : null;
        object2 = object3;
        if (object3 == null) {
            object3 = DynamicIslandUtils.INSTANCE;
            object2 = this.getContext();
            o.f((Object)object2, (String)"getContext(...)");
            object2 = object3 = ((DynamicIslandUtils)object3).getAppName((Context)object2, (DynamicIslandData)object);
            if (object3 == null) {
                object2 = "";
            }
        }
        if (view != null) {
            object = this.collectAllText4Accessibility(view, (DynamicIslandData)object);
            object3 = new StringBuilder();
            ((StringBuilder)object3).append((String)object2);
            ((StringBuilder)object3).append((String)object);
            view.setContentDescription((CharSequence)((StringBuilder)object3).toString());
        }
    }

    public final void animBigIslandBurnIn(DynamicIslandContentView dynamicIslandContentView) {
        DynamicIslandContentViewExtKt.animEnterBurnIn(this, dynamicIslandContentView, true);
    }

    public final void animBigIslandExitBurn() {
        DynamicIslandContentViewExtKt.animExitBurnIn(this, true);
    }

    public final void animExitBurnIn() {
        DynamicIslandContentViewExtKt.animBgBurnIn(this, 0.0f, 1.0f);
    }

    public final void animSmallIslandBurnIn(DynamicIslandContentView dynamicIslandContentView) {
        DynamicIslandContentViewExtKt.animEnterBurnIn(this, dynamicIslandContentView, false);
    }

    public final void animSmallIslandExitBurn() {
        DynamicIslandContentViewExtKt.animExitBurnIn(this, false);
    }

    @Override
    public void calculateBigIslandWidth() {
        Object object = new StringBuilder();
        ((StringBuilder)object).append("calculateBigIslandWidth ");
        ((StringBuilder)object).append((Object)this);
        Log.e((String)TAG, (String)((StringBuilder)object).toString());
        if (this.getListener() != null) {
            object = this.getBigContainer();
            if (object != null) {
                this.addOnAttachStateChangeListenerSafe((View)object, this.getListener());
            }
            if ((object = this.getBigIslandAreaLeft()) != null) {
                this.addOnAttachStateChangeListenerSafe((View)object, this.getListener());
            }
            if ((object = this.getBigIslandAreaRight()) != null) {
                this.addOnAttachStateChangeListenerSafe((View)object, this.getListener());
            }
        }
        if ((object = this.getBigIslandView()) != null) {
            this.applyPreMeasureMode((ViewGroup)object, true);
        }
        object = DynamicIslandUtils.INSTANCE;
        Object object2 = this.getContext();
        o.f((Object)object2, (String)"getContext(...)");
        int n2 = View.MeasureSpec.makeMeasureSpec((int)(((DynamicIslandUtils)object).getScreenWidthOld((Context)object2) / 2), (int)Integer.MIN_VALUE);
        int n3 = View.MeasureSpec.makeMeasureSpec((int)this.getIslandViewHeight(), (int)Integer.MIN_VALUE);
        object2 = this.getBigIslandAreaLeft();
        if (object2 != null) {
            object2.measure(n2, n3);
        }
        if ((object2 = this.getBigIslandAreaRight()) != null) {
            object2.measure(n2, n3);
        }
        object2 = this.getBigIslandView();
        n2 = 0;
        if (object2 != null) {
            this.applyPreMeasureMode((ViewGroup)object2, false);
        }
        if (this.getBigIslandAreaLeft() != null && this.getBigIslandAreaRight() != null) {
            object2 = this.getHelper();
            if (object2 == null) {
                return;
            }
            FrameLayout frameLayout = this.getBigIslandAreaLeft();
            n3 = frameLayout != null ? frameLayout.getMeasuredWidth() : 0;
            frameLayout = this.getBigIslandAreaRight();
            if (frameLayout != null) {
                n2 = frameLayout.getMeasuredWidth();
            }
            int n4 = this.getBigIslandLeftWidth();
            int n5 = this.getBigIslandRightWidth();
            float f2 = this.getMaxWidth();
            float f3 = this.getClockWidth();
            float f4 = this.getBatteryWidth();
            int n6 = this.getFixedCutoutWidth();
            frameLayout = this.getContext();
            o.f((Object)frameLayout, (String)"getContext(...)");
            int n7 = ((DynamicIslandUtils)object).getScreenWidthOld((Context)frameLayout);
            frameLayout = this.getContext();
            o.f((Object)frameLayout, (String)"getContext(...)");
            int n8 = ((DynamicIslandUtils)object).getScreenHeightOld((Context)frameLayout);
            int n9 = this.getSmallIslandViewWidth();
            int n10 = this.getSpace();
            object = this.getContext();
            o.f((Object)object, (String)"getContext(...)");
            object = object2.calculateBigIslandWidth(new IslandContentViewCalculationParams(n3, n2, n4, n5, f2, f3, f4, n6, n7, n8, n9, n10, CommonUtils.isLayoutRtl((Context)object), FoldUtils.INSTANCE.isFoldScreenLayoutLarge((View)this), this.getBigIslandViewWidthHasSmallIsland(), this.getBigIslandXHasSmallIsland()));
            this.setBigIslandViewWidth(((IslandContentViewCalculationResult)object).getBigIslandViewWidth());
            this.setBigIslandLeftWidth(((IslandContentViewCalculationResult)object).getBigIslandLeftWidth());
            this.setBigIslandRightWidth(((IslandContentViewCalculationResult)object).getBigIslandRightWidth());
            this.setBigIslandMarginWidth(((IslandContentViewCalculationResult)object).getBigIslandMarginWidth());
            this.setBigIslandX(((IslandContentViewCalculationResult)object).getBigIslandX());
            this.setBigIslandViewWidthHasSmallIsland(((IslandContentViewCalculationResult)object).getBigIslandViewWidthHasSmallIsland());
            this.setBigIslandLeftWidthHasSmallIsland(((IslandContentViewCalculationResult)object).getBigIslandLeftWidthHasSmallIsland());
            this.setBigIslandRightWidthHasSmallIsland(((IslandContentViewCalculationResult)object).getBigIslandRightWidthHasSmallIsland());
            this.setBigIslandXHasSmallIsland(((IslandContentViewCalculationResult)object).getBigIslandXHasSmallIsland());
            n3 = this.getBigIslandViewWidth();
            n4 = this.getBigIslandLeftWidth();
            n2 = this.getBigIslandRightWidth();
            n5 = this.getBigIslandX();
            object = new StringBuilder();
            ((StringBuilder)object).append("calculateBigIslandWidth result: bigIslandViewWidth=");
            ((StringBuilder)object).append(n3);
            ((StringBuilder)object).append(", bigIslandLeftWidth=");
            ((StringBuilder)object).append(n4);
            ((StringBuilder)object).append(", bigIslandRightWidth=");
            ((StringBuilder)object).append(n2);
            ((StringBuilder)object).append(", bigIslandX=");
            ((StringBuilder)object).append(n5);
            Log.d((String)TAG, (String)((StringBuilder)object).toString());
            this.updateBigIslandLayout();
            return;
        }
        object = this.getBigIslandAreaLeft();
        FrameLayout frameLayout = this.getBigIslandAreaRight();
        object2 = this.getBigIslandView();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("calculateBigIslandWidth error ");
        stringBuilder.append(object);
        stringBuilder.append(" ");
        stringBuilder.append(frameLayout);
        stringBuilder.append(" ");
        stringBuilder.append(object2);
        Log.e((String)TAG, (String)stringBuilder.toString());
        this.removeByError();
    }

    @Override
    public void clearShadow() {
        FolmeKt.getFolme((View)this).cancel(new FloatProperty[]{this.SHADOW_ALPHA});
        this.setShowShade(false);
        MiShadowUtils.clearMiShadow((View)this);
    }

    public final void clickOnButtonTrack(boolean bl, boolean bl2) {
        Object object;
        Object object2;
        Object object3;
        Object object4;
        block6: {
            block5: {
                object4 = this.getCurrentIslandData();
                object3 = null;
                object4 = object4 != null && (object4 = object4.getExtras()) != null ? (StatusBarNotification)object4.getParcelable("miui.sbn", StatusBarNotification.class) : null;
                object2 = this.getCurrentIslandData();
                object = object3;
                if (object2 != null) {
                    object2 = object2.getExtras();
                    object = object3;
                    if (object2 != null) {
                        object = object2.getString("miui.pkg.name");
                    }
                }
                if ((object3 = this.getDynamicIslandEventCoordinator()) == null || (object3 = ((DynamicIslandEventCoordinator)object3).getWindowView()) == null) break block5;
                object3 = object2 = ((DynamicIslandWindowView)((Object)object3)).getDownInWhichButton();
                if (object2 != null) break block6;
            }
            object3 = "\u5c9b";
        }
        object2 = DynamicIslandEventTracker.Companion;
        Context context = this.getContext();
        o.f((Object)context, (String)"getContext(...)");
        EventTracker.Companion companion = EventTracker.Companion;
        Context context2 = this.getContext();
        o.f((Object)context2, (String)"getContext(...)");
        object2.trackExpandedClick(context, (StatusBarNotification)object4, companion.getScreenType(context2), bl, (String)object, (String)object3, bl2);
    }

    public final boolean emitEvent(DynamicIslandData object, DynamicIslandEvent object2) {
        o.g((Object)object2, (String)"event");
        Object object3 = new StringBuilder();
        ((StringBuilder)object3).append("emitEvent ");
        ((StringBuilder)object3).append(object2);
        Log.d((String)TAG, (String)((StringBuilder)object3).toString());
        if (object2 instanceof DynamicIslandEvent.DeletedDynamicIsland) {
            object2 = this.getDynamicIslandEventCoordinator();
            if (object2 != null && (object2 = ((DynamicIslandEventCoordinator)object2).getWindowView()) != null) {
                DynamicIslandWindowView.removeDynamicIslandData$default((DynamicIslandWindowView)((Object)object2), object, false, false, 6, null);
            }
            if ((object = object != null && (object = object.getExtras()) != null ? (StatusBarNotification)object.getParcelable("miui.sbn", StatusBarNotification.class) : null) != null && (object2 = this.getDynamicIslandEventCoordinator()) != null && (object2 = ((DynamicIslandEventCoordinator)object2).getWindowView()) != null) {
                ((DynamicIslandWindowView)((Object)object2)).removeNotification((StatusBarNotification)object);
            }
            return true;
        }
        if (object2 instanceof DynamicIslandEvent.UpdateDynamicIsland && object != null && (object2 = this.getDynamicIslandEventCoordinator()) != null && (object2 = ((DynamicIslandEventCoordinator)object2).getWindowView()) != null) {
            object3 = this.getDynamicIslandEventCoordinator();
            float f2 = object3 != null && (object3 = ((DynamicIslandEventCoordinator)object3).getWindowView()) != null && (object3 = ((DynamicIslandWindowView)((Object)object3)).getWindowViewController()) != null ? ((DynamicIslandWindowViewController)object3).getIslandMaxWidth() : 0.0f;
            DynamicIslandWindowView.updateDynamicIslandView$default((DynamicIslandWindowView)((Object)object2), object, false, f2, false, 8, null);
        }
        return false;
    }

    public final boolean getAppReturnIslandButNoAppState() {
        return this.appReturnIslandButNoAppState;
    }

    @Override
    public Rect getBigIslandPosition() {
        Rect rect = new Rect();
        rect.set(this.getBigIslandX(), this.getIslandViewMarginTop(), this.getBigIslandX() + this.getBigIslandViewWidth(), this.getIslandViewMarginTop() + this.getIslandViewHeight());
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("getBigIslandPosition ");
        stringBuilder.append(rect);
        Log.e((String)TAG, (String)stringBuilder.toString());
        return rect;
    }

    public final boolean getBlockChildrenTouch() {
        return this.blockChildrenTouch;
    }

    public final AntiBurnInManager.BurnInStates getBurnInState() {
        return this.burnInState;
    }

    public final float getContainerBgAlpha() {
        return this.containerBgAlpha;
    }

    public DynamicIslandContentViewController getController() {
        DynamicIslandBaseContentViewController<?> dynamicIslandBaseContentViewController = super.getController();
        o.e(dynamicIslandBaseContentViewController, (String)"null cannot be cast to non-null type miui.systemui.dynamicisland.window.content.DynamicIslandContentViewController");
        return (DynamicIslandContentViewController)dynamicIslandBaseContentViewController;
    }

    public final l0 getEnterJob() {
        return this.enterJob;
    }

    @Override
    public Rect getExpandedIslandRect() {
        Rect rect = new Rect();
        rect.left = this.getExpandedViewMarginHorizontal();
        rect.top = this.getExpandedViewY();
        rect.right = rect.left + this.getExpandedViewWidth();
        rect.bottom = rect.top + this.getExpandedViewHeight();
        return rect;
    }

    @Override
    public Rect getExpandedPosition() {
        Rect rect = new Rect();
        rect.set(this.getExpandedViewMarginHorizontal(), this.getExpandedViewY(), this.getExpandedViewMarginHorizontal() + this.getExpandedViewWidth(), this.getExpandedViewY() + this.getExpandedViewHeight());
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("getExpandedPosition ");
        stringBuilder.append(rect);
        Log.e((String)TAG, (String)stringBuilder.toString());
        return rect;
    }

    public final long getExposedBurnInUnit() {
        return this.exposedBurnInUnit;
    }

    public final long getExposedUnit() {
        return this.exposedUnit;
    }

    public final l0 getExtendJob() {
        return this.extendJob;
    }

    public final boolean getHasEverBurnedIn() {
        return this.hasEverBurnedIn;
    }

    public final String getIslandKey() {
        Object object = this.getCurrentIslandData();
        object = object != null ? object.getKey() : null;
        return object;
    }

    public final Integer getIslandProp() {
        Object object = this.getCurrentIslandData();
        object = object != null ? object.getProperties() : null;
        return object;
    }

    public final long getRemainingBurnInUnit() {
        return this.remainingBurnInUnit;
    }

    public final long getRemainingUnit() {
        return this.remainingUnit;
    }

    public final boolean getRemainingUnitInited() {
        return this.remainingUnitInited;
    }

    public final l0 getRestoreJob() {
        return this.restoreJob;
    }

    public final WeakHashMap<View, Integer> getShadeBackUp() {
        return this.shadeBackUp;
    }

    public boolean hasOverlappingRendering() {
        return false;
    }

    @Override
    public void hideIslandLayout() {
        super.hideIslandLayout();
        DynamicIslandContentFakeView dynamicIslandContentFakeView = this.getFakeView();
        if (dynamicIslandContentFakeView != null) {
            dynamicIslandContentFakeView.hideIslandLayout();
        }
        this.getController().getIslandTemplateFactory().hideView(this.getCurrentIslandData(), false);
    }

    public final boolean inBurnIn() {
        boolean bl = this.containerBgAlpha == 1.0f;
        return bl ^ true;
    }

    public final void initBigIslandView() {
        Object object = this.getHelper();
        if (object == null) {
            return;
        }
        object = object.findAndInitViews((View)this.getBigIslandView(), (View)this.getSmallIslandView());
        this.setBigContainer(((IslandContentViewHolder)object).getBigContainer());
        this.setSmallContainer(((IslandContentViewHolder)object).getSmallContainer());
        this.setBigIslandAreaLeft(((IslandContentViewHolder)object).getBigIslandAreaLeft());
        this.setBigIslandAreaRight(((IslandContentViewHolder)object).getBigIslandAreaRight());
        this.setBigIslandAreaMargin(((IslandContentViewHolder)object).getBigIslandAreaMargin());
        object = this.getBigIslandView();
        object = object != null ? object.getLayoutParams() : null;
        if (object != null) {
            ((ViewGroup.LayoutParams)object).height = this.getIslandViewHeight();
        }
        if (CommonUtils.INSTANCE.getIS_TABLET() && (object = this.getBigContainer()) != null) {
            this.initBigIslandHoverEffect((View)object);
        }
    }

    public final void initGlowEffect$miui_dynamicisland_release(ViewGroup viewGroup, ViewGroup viewGroup2) {
        o.g((Object)viewGroup, (String)"topContainer");
        o.g((Object)viewGroup2, (String)"bottomContainer");
        DynamicGlowEffectView dynamicGlowEffectView = this.getExpandedView();
        if (dynamicGlowEffectView != null) {
            dynamicGlowEffectView.initGlowEffect$miui_dynamicisland_release(viewGroup, viewGroup2);
        }
        if ((dynamicGlowEffectView = this.getBigIslandView()) != null) {
            dynamicGlowEffectView.initGlowEffect$miui_dynamicisland_release(viewGroup, viewGroup2);
        }
    }

    public void onAttachedToWindow() {
        ((DynamicIslandContentViewController)this.getController()).onViewAttached(true);
        this.getViewTreeObserver().addOnPreDrawListener((ViewTreeObserver.OnPreDrawListener)this.exposeListener);
        super.onAttachedToWindow();
    }

    @Override
    public void onDetachedFromWindow() {
        ((DynamicIslandContentViewController)this.getController()).onViewAttached(false);
        this.getViewTreeObserver().removeOnPreDrawListener((ViewTreeObserver.OnPreDrawListener)this.exposeListener);
        l0 l02 = this.enterJob;
        if (l02 != null) {
            l0.a.a((l0)l02, null, (int)1, null);
        }
        if ((l02 = this.restoreJob) != null) {
            l0.a.a((l0)l02, null, (int)1, null);
        }
        if ((l02 = this.extendJob) != null) {
            l0.a.a((l0)l02, null, (int)1, null);
        }
        super.onDetachedFromWindow();
    }

    public void onFinishInflate() {
        super.onFinishInflate();
        this.setContainer((FrameLayout)this.findViewById(R.id.container));
        this.setExpandedViewStub((ViewStub)this.findViewById(R.id.expanded_view_stub));
        this.setBigIslandView((DynamicIslandBigIslandView)this.findViewById(R.id.big_island_view));
        this.setSmallIslandView((FrameLayout)this.findViewById(R.id.small_island_view));
        this.setMask(this.findViewById(R.id.island_mask));
        this.setMiniBar(this.findViewById(R.id.mini_window_bar));
        this.setListener(new View.OnAttachStateChangeListener(){

            public void onViewAttachedToWindow(View view2) {
                o.g((Object)view2, (String)"v");
            }

            public void onViewDetachedFromWindow(View view2) {
                o.g((Object)view2, (String)"v");
                Folme.clean((View)view2);
            }
        });
        DynamicIslandBigIslandView dynamicIslandBigIslandView = this.getBigIslandView();
        if (dynamicIslandBigIslandView != null) {
            this.addOnAttachStateChangeListenerSafe((View)dynamicIslandBigIslandView, this.getListener());
        }
        this.initViewModel();
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (motionEvent != null && motionEvent.getActionMasked() == 0) {
            this.blockChildrenTouchOnDown = this.blockChildrenTouch;
        }
        boolean bl = this.blockChildrenTouchOnDown ? true : super.onInterceptTouchEvent(motionEvent);
        return bl;
    }

    @Override
    public void onIslandClick() {
        boolean bl = this.canClick(this.getState());
        Object object = this.getState();
        Object object2 = this.getCurrentIslandData();
        Object object3 = null;
        Object object4 = null;
        Context context = null;
        object2 = object2 != null ? object2.getKey() : null;
        Object object5 = this.getDynamicIslandEventCoordinator();
        object5 = object5 != null ? Boolean.valueOf(((DynamicIslandEventCoordinator)object5).getWindowAnimRunning()) : null;
        Object object6 = this.getCurrentIslandData();
        object6 = object6 != null ? object6.getView() : null;
        int n2 = 0;
        int n3 = 0;
        boolean bl2 = object6 == null;
        object6 = new StringBuilder();
        object6.append("onIslandClick ");
        object6.append(object);
        object6.append(", ");
        object6.append((String)object2);
        object6.append("  animRunning: ");
        object6.append(object5);
        object6.append(". \ncanExpand=");
        object6.append(bl);
        object6.append(", currentViewIsNull:");
        object6.append(bl2);
        Log.d((String)TAG, (String)object6.toString());
        object2 = this.getCurrentIslandData();
        object2 = object2 != null && (object2 = object2.getExtras()) != null ? (StatusBarNotification)object2.getParcelable("miui.sbn", StatusBarNotification.class) : null;
        object5 = this.getDynamicIslandEventCoordinator();
        object5 = object5 != null && (object5 = ((DynamicIslandEventCoordinator)object5).getWindowView()) != null ? Boolean.valueOf(((DynamicIslandWindowView)((Object)object5)).isMediaApp(this.getCurrentIslandData())) : null;
        object6 = this.getCurrentIslandData();
        object6 = object6 != null && (object6 = object6.getExtras()) != null ? object6.getString("miui.pkg.name") : null;
        object = this.getState();
        if (object instanceof DynamicIslandState.Expanded) {
            object4 = this.getCurrentIslandData();
            object4 = object4 != null ? object4.getKey() : null;
            object = new StringBuilder();
            ((StringBuilder)object).append("onIslandClick: click open app");
            ((StringBuilder)object).append((String)object4);
            Log.e((String)TAG, (String)((StringBuilder)object).toString());
            object4 = this.getCurrentIslandData();
            object = object4 != null && (object4 = object4.getExtras()) != null ? (PendingIntent)object4.getParcelable("miui.pending.intent", PendingIntent.class) : null;
            object4 = this.getCurrentIslandData();
            object4 = object4 != null && (object4 = object4.getExtras()) != null ? object4.getString("miui.pkg.name") : null;
            object3 = new StringBuilder();
            ((StringBuilder)object3).append("onIslandClick: click open app ");
            ((StringBuilder)object3).append((String)object4);
            Log.e((String)TAG, (String)((StringBuilder)object3).toString());
            object3 = object2 != null && (object3 = object2.getNotification()) != null ? ((Notification)object3).contentIntent : null;
            if (object3 == null && object == null) {
                return;
            }
            object = this.getWindowState();
            if (object != null && (object = ((DynamicIslandWindowState)object).getScreenPinning()) != null && ((Boolean)object.getValue()).booleanValue()) {
                object2 = new StringBuilder();
                object2.append("onIslandClick: click open app ");
                object2.append((String)object4);
                object2.append(" but screen pinning is active");
                Log.e((String)TAG, (String)object2.toString());
                object2 = this.getDynamicIslandEventCoordinator();
                if (object2 != null) {
                    object2.setUserExpanded(false);
                }
                object2 = this.getDynamicIslandEventCoordinator();
                if (object2 != null) {
                    DynamicIslandEventCoordinator.dispatchEvent$default((DynamicIslandEventCoordinator)object2, DynamicIslandEvent.Collapse.INSTANCE, null, 2, null);
                }
                return;
            }
            DynamicIslandEventTracker.Companion companion = DynamicIslandEventTracker.Companion;
            Context context2 = this.getContext();
            o.f((Object)context2, (String)"getContext(...)");
            object3 = EventTracker.Companion;
            object = this.getContext();
            o.f((Object)object, (String)"getContext(...)");
            DynamicIslandEventTracker.Companion.trackExpandedClick$default(companion, context2, (StatusBarNotification)object2, object3.getScreenType((Context)object), (Boolean)object5, (String)object6, "\u5c9b", false, 64, null);
            object5 = this.getDynamicIslandEventCoordinator();
            if (object5 != null && (object5 = ((DynamicIslandEventCoordinator)object5).getWindowView()) != null && (object5 = ((DynamicIslandWindowView)((Object)object5)).getWindowViewController()) != null && (object5 = ((DynamicIslandWindowViewController)object5).getWindowState()) != null) {
                object6 = this.getContext();
                o.f((Object)object6, (String)"getContext(...)");
                if (((DynamicIslandWindowState)object5).isAdaptDesktopAnimation((Context)object6)) {
                    object5 = this.getDynamicIslandEventCoordinator();
                    if (object5 != null && (object5 = ((DynamicIslandEventCoordinator)object5).getWindowView()) != null && (object5 = ((DynamicIslandWindowView)((Object)object5)).getWindowViewController()) != null) {
                        ((DynamicIslandWindowViewController)object5).runDesktopAnim(true);
                    }
                    if ((object5 = this.getDynamicIslandEventCoordinator()) != null && (object5 = ((DynamicIslandEventCoordinator)object5).getWindowView()) != null && (object5 = ((DynamicIslandWindowView)((Object)object5)).getWindowViewController()) != null) {
                        ((DynamicIslandWindowViewController)object5).runDesktopAnim(false);
                    }
                }
            }
            if ((object5 = this.getDynamicIslandEventCoordinator()) != null) {
                ((DynamicIslandEventCoordinator)object5).updateView(this);
            }
            int n4 = (object5 = this.getDynamicIslandEventCoordinator()) != null && (object5 = ((DynamicIslandEventCoordinator)object5).getWindowView()) != null && (object5 = ((DynamicIslandWindowView)((Object)object5)).getWindowViewController()) != null && ((DynamicIslandWindowViewController)object5).isWorkbenchModeEnabled() ? 1 : 0;
            if (CommonUtils.INSTANCE.getIS_TABLET() && n4 != 0) {
                object5 = ActivityManagerWrapper.INSTANCE.getRunningTaskInfoList();
                n4 = n2;
                if (object5 != null) {
                    block40: {
                        object = object5.iterator();
                        while (object.hasNext()) {
                            object6 = object.next();
                            object5 = ((ActivityManager.RunningTaskInfo)object6).baseActivity;
                            object5 = object5 != null ? object5.getPackageName() : null;
                            if (!o.c((Object)object5, (Object)object4)) continue;
                            object5 = object6;
                            break block40;
                        }
                        object5 = null;
                    }
                    object5 = (ActivityManager.RunningTaskInfo)object5;
                    n4 = n2;
                    if (object5 != null) {
                        object5 = IActivityTaskManagerCompat.INSTANCE.getWindowingModeCompat((TaskInfo)object5);
                        n4 = n3;
                        if (object5 != null) {
                            n4 = (Integer)object5;
                        }
                        object5 = new StringBuilder();
                        ((StringBuilder)object5).append("onIslandClick: windowMode:");
                        ((StringBuilder)object5).append(n4);
                        Log.d((String)TAG, (String)((StringBuilder)object5).toString());
                    }
                }
                if (n4 == 5) {
                    Log.d((String)TAG, (String)"onIslandClick: click open FreeForm in workBenchMode");
                    object2 = this.getCurrentIslandData();
                    if (object2 != null && (object2 = object2.getExtras()) != null) {
                        object2.putBoolean("extra_open_freeform_in_workbench_mode", true);
                    }
                    if ((object5 = this.getDynamicIslandEventCoordinator()) != null) {
                        object6 = this.getCurrentIslandData();
                        object2 = context;
                        if (object6 != null) {
                            object2 = object6.getExtras();
                        }
                        ((DynamicIslandEventCoordinator)object5).openFreeForm((Bundle)object2);
                    }
                } else {
                    this.handleOpenApp((StatusBarNotification)object2);
                }
            } else {
                this.handleOpenApp((StatusBarNotification)object2);
            }
        } else if (object instanceof DynamicIslandState.SmallIsland) {
            if (!bl) {
                return;
            }
            this.resetOpenAppFromIsland();
            object4 = this.getDynamicIslandEventCoordinator();
            object4 = object4 != null && (object4 = object4.getBigIslandStateHandler()) != null ? object4.getCurrent() : null;
            object = this.getDynamicIslandEventCoordinator();
            boolean bl3 = object != null && ((DynamicIslandEventCoordinator)object).islandAppAnimating((DynamicIslandContentView)((Object)object4));
            if (bl3 && (object = object4 != null ? object4.getFakeView() : null) != null) {
                ((DynamicIslandContentFakeView)((Object)object)).setBigIslandViewNeedAnim(true);
            }
            if ((object = (object = this.getCurrentIslandData()) != null ? object.getView() : null) != null) {
                object = this.getDynamicIslandEventCoordinator();
                if (object != null) {
                    ((DynamicIslandEventCoordinator)object).dispatchEvent(DynamicIslandEvent.ClickDynamicIsland.INSTANCE, this);
                }
                DynamicIslandEventTracker.Companion companion = DynamicIslandEventTracker.Companion;
                context = this.getContext();
                o.f((Object)context, (String)"getContext(...)");
                object = EventTracker.Companion;
                Context context3 = this.getContext();
                o.f((Object)context3, (String)"getContext(...)");
                companion.trackSummaryClick(context, (StatusBarNotification)object2, "\u5c0f", object.getScreenType(context3), (Boolean)object5, (String)object6);
                object2 = this.getDynamicIslandEventCoordinator();
                if (object2 != null) {
                    object2.setUserExpanded(true);
                }
            }
            if (bl3 = object4 != null && (object2 = object4.getFakeView()) != null && object2.getBigIslandViewNeedAnim()) {
                object2 = object4.getFakeView();
                if (object2 != null) {
                    object2.setBigIslandViewNeedAnim(false);
                }
                object2 = DynamicIslandBaseContentView.getBigIslandRect$default((DynamicIslandBaseContentView)((Object)object4), null, 1, null);
                object5 = object4.getCurrentIslandData();
                if (object5 != null && (object5 = object5.getExtras()) != null) {
                    object5.putParcelable("position", (Parcelable)object2);
                }
                object5 = new StringBuilder();
                ((StringBuilder)object5).append("smallToExpand, big positionChanged: ");
                ((StringBuilder)object5).append(object2);
                Log.d((String)TAG, (String)((StringBuilder)object5).toString());
                object5 = object4.getDynamicIslandEventCoordinator();
                if (object5 != null) {
                    object6 = object4.getCurrentIslandData();
                    object2 = object3;
                    if (object6 != null) {
                        object2 = object6.getExtras();
                    }
                    ((DynamicIslandEventCoordinator)object5).positionChanged((Bundle)object2);
                }
            }
        } else {
            bl2 = object instanceof DynamicIslandState.BigIsland ? true : object instanceof DynamicIslandState.ShowOnceBigIsland;
            if (bl2) {
                if (!bl) {
                    return;
                }
                this.resetOpenAppFromIsland();
                object = this.getCurrentIslandData();
                if (object != null) {
                    object4 = object.getView();
                }
                if (object4 != null) {
                    object4 = this.getDynamicIslandEventCoordinator();
                    if (object4 != null) {
                        object4.dispatchEvent(DynamicIslandEvent.ClickDynamicIsland.INSTANCE, this);
                    }
                    object = DynamicIslandEventTracker.Companion;
                    object4 = this.getContext();
                    o.f((Object)object4, (String)"getContext(...)");
                    object3 = EventTracker.Companion;
                    context = this.getContext();
                    o.f((Object)context, (String)"getContext(...)");
                    object.trackSummaryClick((Context)object4, (StatusBarNotification)object2, "\u5927", object3.getScreenType(context), (Boolean)object5, (String)object6);
                    object2 = this.getDynamicIslandEventCoordinator();
                    if (object2 != null) {
                        object2.setUserExpanded(true);
                    }
                }
            }
        }
    }

    public void onVisibilityAggregated(boolean bl) {
        ((DynamicIslandContentViewController)this.getController()).onVisAggregated(bl);
        super.onVisibilityAggregated(bl);
    }

    public void onWindowFocusChanged(boolean bl) {
        ((DynamicIslandContentViewController)this.getController()).onWindowFocusChanged(bl);
        super.onWindowFocusChanged(bl);
    }

    @Override
    public void resetStatus() {
        this.setOpenAppFromIsland(false);
    }

    public void setAlpha(float f2) {
        super.setAlpha(f2);
        DynamicIslandBackgroundView dynamicIslandBackgroundView = this.getBackgroundView();
        if (dynamicIslandBackgroundView != null) {
            dynamicIslandBackgroundView.setAlpha(f2);
        }
    }

    public final void setAppReturnIslandButNoAppState(boolean bl) {
        this.appReturnIslandButNoAppState = bl;
    }

    public final void setBlockChildrenTouch(boolean bl) {
        this.blockChildrenTouch = bl;
    }

    public final void setBurnInState(AntiBurnInManager.BurnInStates burnInStates) {
        o.g((Object)((Object)burnInStates), (String)"<set-?>");
        this.burnInState = burnInStates;
    }

    public final void setContainerBgAlpha(float f2) {
        this.containerBgAlpha = f2;
    }

    @Override
    public void setController(DynamicIslandBaseContentViewController<?> dynamicIslandBaseContentViewController) {
        o.g(dynamicIslandBaseContentViewController, (String)"controller");
        if (dynamicIslandBaseContentViewController instanceof DynamicIslandContentViewController) {
            super.setController(dynamicIslandBaseContentViewController);
            return;
        }
        throw new IllegalAccessException("setting controller is not DynamicIslandContentViewController.");
    }

    public final void setEnterJob(l0 l02) {
        this.enterJob = l02;
    }

    public final void setExposedBurnInUnit(long l) {
        this.exposedBurnInUnit = l;
    }

    public final void setExposedUnit(long l) {
        this.exposedUnit = l;
    }

    public final void setExtendJob(l0 l02) {
        this.extendJob = l02;
    }

    public final void setHasEverBurnedIn(boolean bl) {
        this.hasEverBurnedIn = bl;
    }

    public final void setRemainingBurnInUnit(long l) {
        this.remainingBurnInUnit = l;
    }

    public final void setRemainingUnit(long l) {
        this.remainingUnit = l;
    }

    public final void setRemainingUnitInited(boolean bl) {
        this.remainingUnitInited = bl;
    }

    public final void setRestoreJob(l0 l02) {
        this.restoreJob = l02;
    }

    @Override
    public void showIslandLayout() {
        super.showIslandLayout();
        DynamicIslandContentFakeView dynamicIslandContentFakeView = this.getFakeView();
        if (dynamicIslandContentFakeView != null) {
            dynamicIslandContentFakeView.showIslandLayout();
        }
        this.getController().getIslandTemplateFactory().showView(this.getCurrentIslandData(), false);
    }

    @Override
    public void showShadowNoANim() {
        if (this.getShowShade()) {
            return;
        }
        DynamicIslandEventCoordinator dynamicIslandEventCoordinator = this.getDynamicIslandEventCoordinator();
        if (dynamicIslandEventCoordinator != null && !dynamicIslandEventCoordinator.islandAppAnimating(this)) {
            FolmeKt.getFolme((View)this).cancel(new FloatProperty[]{this.SHADOW_ALPHA});
            this.setShowShade(true);
            this.updateShadow((DynamicIslandBaseContentView)this, this.getContext().getResources().getColor(R.color.shader_color));
        }
    }

    public final void showShadowWithAnim() {
        if (this.getShowShade()) {
            return;
        }
        if (this.getState() instanceof DynamicIslandState.Expanded) {
            this.setShowShade(true);
            FolmeKt.getFolme((View)this).setTo(new Object[]{this.SHADOW_ALPHA, Float.valueOf(0.0f)}).to(new Object[]{this.SHADOW_ALPHA, Float.valueOf(1.0f)});
        }
    }

    @Override
    public void updateAccessibility(DynamicIslandData object) {
        Object object2 = this.getTemplate();
        object2 = object2 != null ? ((IslandTemplate)object2).getAppContentDescription() : null;
        FrameLayout frameLayout = this.getSmallIslandView();
        if (frameLayout != null) {
            if (object2 == null) {
                DynamicIslandUtils dynamicIslandUtils = DynamicIslandUtils.INSTANCE;
                object2 = this.getContext();
                o.f((Object)object2, (String)"getContext(...)");
                object2 = dynamicIslandUtils.getAppName((Context)object2, (DynamicIslandData)object);
            }
            frameLayout.setContentDescription((CharSequence)object2);
        }
        this.updateContentDescriptionIfNeed((View)this.getBigIslandView(), (DynamicIslandData)object);
        object2 = this.getSmallIslandView();
        if (object2 != null) {
            object2.setAccessibilityDelegate(new View.AccessibilityDelegate(){

                public void onInitializeAccessibilityNodeInfo(View view2, AccessibilityNodeInfo accessibilityNodeInfo) {
                    o.g((Object)view2, (String)"host");
                    o.g((Object)accessibilityNodeInfo, (String)"info");
                    super.onInitializeAccessibilityNodeInfo(view2, accessibilityNodeInfo);
                    accessibilityNodeInfo.setClickable(true);
                }
            });
        }
        object2 = this.getBigIslandView();
        if (object2 != null) {
            object2.setAccessibilityDelegate(new View.AccessibilityDelegate(this, (DynamicIslandData)object){
                final DynamicIslandData $islandData;
                final DynamicIslandContentView this$0;
                {
                    this.this$0 = dynamicIslandContentView;
                    this.$islandData = dynamicIslandData;
                }

                public void onInitializeAccessibilityNodeInfo(View object, AccessibilityNodeInfo accessibilityNodeInfo) {
                    o.g((Object)object, (String)"host");
                    o.g((Object)accessibilityNodeInfo, (String)"info");
                    super.onInitializeAccessibilityNodeInfo((View)object, accessibilityNodeInfo);
                    accessibilityNodeInfo.setClickable(true);
                    object = this.this$0;
                    DynamicIslandContentView.access$updateContentDescriptionIfNeed((DynamicIslandContentView)((Object)object), (View)((DynamicIslandBaseContentView)((Object)object)).getBigIslandView(), this.$islandData);
                }
            });
        }
        object = this.getExpandedView();
        if (object != null) {
            object.setAccessibilityDelegate(new View.AccessibilityDelegate(this){
                final DynamicIslandContentView this$0;
                {
                    this.this$0 = dynamicIslandContentView;
                }

                public void onInitializeAccessibilityNodeInfo(View view2, AccessibilityNodeInfo accessibilityNodeInfo) {
                    o.g((Object)view2, (String)"host");
                    o.g((Object)accessibilityNodeInfo, (String)"info");
                    super.onInitializeAccessibilityNodeInfo(view2, accessibilityNodeInfo);
                    accessibilityNodeInfo.setClickable(true);
                    accessibilityNodeInfo.addAction(AccessibilityNodeInfo.AccessibilityAction.ACTION_CLICK);
                }

                /*
                 * Enabled aggressive block sorting
                 * Enabled unnecessary exception pruning
                 * Enabled aggressive exception aggregation
                 */
                public boolean performAccessibilityAction(View object, int n2, Bundle object2) {
                    block6: {
                        Throwable throwable2;
                        block5: {
                            boolean bl;
                            block4: {
                                block3: {
                                    o.g((Object)object, (String)"host");
                                    DynamicIslandContentView dynamicIslandContentView = this.this$0;
                                    try {
                                        j.a a2 = j.a;
                                        if (n2 != 16) break block3;
                                        dynamicIslandContentView.onIslandClick();
                                        bl = true;
                                        break block4;
                                    }
                                    catch (Throwable throwable2) {
                                        break block5;
                                    }
                                }
                                bl = super.performAccessibilityAction((View)object, n2, object2);
                            }
                            object = j.a((Object)bl);
                            break block6;
                        }
                        object = j.a;
                        object = j.a((Object)k.a((Throwable)throwable2));
                    }
                    object2 = j.b((Object)object);
                    if (object2 == null) {
                        return (Boolean)object;
                    }
                    object = new StringBuilder();
                    ((StringBuilder)object).append("performAccessibilityAction error: action=");
                    ((StringBuilder)object).append(n2);
                    Log.e((String)"DynamicIslandContentView", (String)((StringBuilder)object).toString(), (Throwable)object2);
                    object = Boolean.FALSE;
                    return (Boolean)object;
                }
            });
        }
    }

    @Override
    public void updateBigIslandLayout() {
        int n2 = this.getBigIslandViewWidth();
        int n3 = this.getBigIslandViewWidthHasSmallIsland();
        int n4 = this.getRealCutoutWidth();
        int n5 = this.getFixedCutoutWidth();
        int n6 = this.getBigIslandMarginWidth();
        Object object = new StringBuilder();
        ((StringBuilder)object).append("updateBigIslandLayout,  bigIslandViewWidth: ");
        ((StringBuilder)object).append(n2);
        ((StringBuilder)object).append(", bigIslandViewWidthHasSmallIsland: ");
        ((StringBuilder)object).append(n3);
        ((StringBuilder)object).append(", getRealCutoutWidth : ");
        ((StringBuilder)object).append(n4);
        ((StringBuilder)object).append(", getFixedCutoutWidth : ");
        ((StringBuilder)object).append(n5);
        ((StringBuilder)object).append(", bigIslandMarginWidth:");
        ((StringBuilder)object).append(n6);
        Log.e((String)TAG, (String)((StringBuilder)object).toString());
        object = this.getBigIslandAreaMargin();
        object = object != null ? object.getLayoutParams() : null;
        if (object != null) {
            ((ViewGroup.LayoutParams)object).width = this.getBigIslandMarginWidth();
        }
        this.updateBigIslandLayoutWithAnim(this.getBigIslandAreaLeft(), this.getBigIslandAreaRight(), this.getBigContainer(), this.getBigIslandView(), this, false);
        object = this.getFakeView();
        if (object != null) {
            ((DynamicIslandContentFakeView)((Object)object)).updateBigIslandLayout();
        }
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    @Override
    public Object updateBigIslandView(DynamicIslandData var1_1, boolean var2_2, K0.d var3_3) {
        block12: {
            block11: {
                block9: {
                    block10: {
                        if (!(var3_3 /* !! */  instanceof updateBigIslandView.1)) ** GOTO lbl-1000
                        var7_4 /* !! */  = var3_3 /* !! */ ;
                        var4_5 = var7_4 /* !! */ .label;
                        if ((var4_5 & -2147483648) != 0) {
                            var7_4 /* !! */ .label = var4_5 + -2147483648;
                            var3_3 /* !! */  = var7_4 /* !! */ ;
                        } else lbl-1000:
                        // 2 sources

                        {
                            var3_3 /* !! */  = new M0.d(this, var3_3 /* !! */ ){
                                Object L$0;
                                Object L$1;
                                int label;
                                Object result;
                                final DynamicIslandContentView this$0;
                                {
                                    this.this$0 = dynamicIslandContentView;
                                    super(d2);
                                }

                                public final Object invokeSuspend(Object object) {
                                    this.result = object;
                                    this.label |= Integer.MIN_VALUE;
                                    return this.this$0.updateBigIslandView(null, false, (K0.d)this);
                                }
                            };
                        }
                        var7_4 /* !! */  = var3_3 /* !! */ .result;
                        var9_6 = c.c();
                        var4_5 = var3_3 /* !! */ .label;
                        if (var4_5 == 0) break block9;
                        if (var4_5 != 1) break block10;
                        var1_1 /* !! */  = (DynamicIslandData)var3_3 /* !! */ .L$1;
                        var3_3 /* !! */  = (DynamicIslandContentView)var3_3 /* !! */ .L$0;
                        k.b((Object)var7_4 /* !! */ );
                        break block11;
                    }
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                k.b((Object)var7_4 /* !! */ );
                var7_4 /* !! */  = this.getBigIslandView();
                var4_5 = this.getStatusBarHeight();
                var6_7 = this.getIslandWindowHeight();
                var5_8 = this.getIslandViewHeight();
                var8_9 = new StringBuilder();
                var8_9.append("updateBigIslandView ");
                var8_9.append((Object)var7_4 /* !! */ );
                var8_9.append(" ");
                var8_9.append(var4_5);
                var8_9.append(" ");
                var8_9.append(var6_7);
                var8_9.append(" ");
                var8_9.append(var5_8);
                Log.e((String)"DynamicIslandContentView", (String)var8_9.toString());
                this.setCurrentIslandData(var1_1 /* !! */ );
                if (!var2_2) {
                    var7_4 /* !! */  = this.getBigIslandView();
                    if (var7_4 /* !! */  != null && (var7_4 /* !! */  = var7_4 /* !! */ .getContentView$miui_dynamicisland_release()) != null) {
                        var7_4 /* !! */ .removeAllViews();
                    }
                    if (var1_1 /* !! */  != null && (var7_4 /* !! */  = var1_1 /* !! */ .getKey()) != null) {
                        this.getController().getIslandTemplateFactory().removeTemplate((String)var7_4 /* !! */ );
                    }
                }
                var8_9 = this.getController().getIslandTemplateFactory();
                var10_10 = this.getContext();
                o.f((Object)var10_10, (String)"getContext(...)");
                var11_11 = this.getTemplate();
                var7_4 /* !! */  = this.getBigIslandView();
                var7_4 /* !! */  = var7_4 /* !! */  != null ? var7_4 /* !! */ .getContentView$miui_dynamicisland_release() : null;
                if (var7_4 /* !! */  != null) {
                    var12_12 = new U0.o((Object)this){

                        public final Boolean invoke(DynamicIslandData object, DynamicIslandEvent object2) {
                            boolean bl;
                            o.g((Object)object2, (String)"p1");
                            Object object3 = (DynamicIslandContentView)((Object)((kotlin.jvm.internal.d)this).receiver);
                            StringBuilder stringBuilder = new StringBuilder();
                            stringBuilder.append("emitEvent ");
                            stringBuilder.append(object2);
                            Log.d((String)"DynamicIslandContentView", (String)stringBuilder.toString());
                            if (object2 instanceof DynamicIslandEvent.DeletedDynamicIsland) {
                                object2 = ((DynamicIslandBaseContentView)((Object)object3)).getDynamicIslandEventCoordinator();
                                if (object2 != null && (object2 = ((DynamicIslandEventCoordinator)object2).getWindowView()) != null) {
                                    DynamicIslandWindowView.removeDynamicIslandData$default((DynamicIslandWindowView)((Object)object2), object, false, false, 6, null);
                                }
                                if ((object = object != null && (object = object.getExtras()) != null ? (StatusBarNotification)object.getParcelable("miui.sbn", StatusBarNotification.class) : null) != null && (object2 = ((DynamicIslandBaseContentView)((Object)object3)).getDynamicIslandEventCoordinator()) != null && (object2 = ((DynamicIslandEventCoordinator)object2).getWindowView()) != null) {
                                    ((DynamicIslandWindowView)((Object)object2)).removeNotification((StatusBarNotification)object);
                                }
                                bl = true;
                            } else {
                                if (object2 instanceof DynamicIslandEvent.UpdateDynamicIsland && object != null && (object2 = ((DynamicIslandBaseContentView)((Object)object3)).getDynamicIslandEventCoordinator()) != null && (object2 = ((DynamicIslandEventCoordinator)object2).getWindowView()) != null) {
                                    float f2 = (object3 = ((DynamicIslandBaseContentView)((Object)object3)).getDynamicIslandEventCoordinator()) != null && (object3 = ((DynamicIslandEventCoordinator)object3).getWindowView()) != null && (object3 = ((DynamicIslandWindowView)((Object)object3)).getWindowViewController()) != null ? ((DynamicIslandWindowViewController)object3).getIslandMaxWidth() : 0.0f;
                                    DynamicIslandWindowView.updateDynamicIslandView$default((DynamicIslandWindowView)((Object)object2), object, false, f2, false, 8, null);
                                }
                                bl = false;
                            }
                            return bl;
                        }
                    };
                    var3_3 /* !! */ .L$0 = this;
                    var3_3 /* !! */ .L$1 = var1_1 /* !! */ ;
                    var3_3 /* !! */ .label = 1;
                    var8_9 = var8_9.createBigIslandTemplate(var10_10, var1_1 /* !! */ , var11_11, (ViewGroup)var7_4 /* !! */ , false, var12_12, var3_3 /* !! */ );
                    var3_3 /* !! */  = this;
                    var7_4 /* !! */  = var8_9;
                    if (var8_9 == var9_6) {
                        return var9_6;
                    } else {
                        ** GOTO lbl69
                    }
                }
                break block12;
            }
            if ((View)var7_4 /* !! */  == null) {
                if (var1_1 /* !! */  != null && (var1_1 /* !! */  = var1_1 /* !! */ .getKey()) != null) {
                    var3_3 /* !! */ .getController().getIslandTemplateFactory().removeTemplate((String)var1_1 /* !! */ );
                }
                super.removeByError();
                return b.a((boolean)false);
            }
            super.inheritWidth();
            var3_3 /* !! */ .initBigIslandView();
            var3_3 /* !! */ .calculateBigIslandWidth();
            return b.a((boolean)true);
        }
        throw new IllegalStateException("Required value was null.");
    }

    @Override
    public void updateBigIslandViewWidth() {
        if (this.getBigIslandAreaLeft() == null) {
            return;
        }
        if (this.getBigIslandAreaRight() == null) {
            return;
        }
        Object object = new StringBuilder();
        ((StringBuilder)object).append("updateBigIslandViewWidth: ");
        ((StringBuilder)object).append((Object)this);
        Log.d((String)TAG, (String)((StringBuilder)object).toString());
        this.calculateBigIslandWidth();
        object = this.getDynamicIslandEventCoordinator();
        if (object != null) {
            ((DynamicIslandEventCoordinator)object).dispatchEvent(DynamicIslandEvent.UpdateDynamicIslandWidth.INSTANCE, this);
        }
    }

    @Override
    public void updateExpandViewBlur(int n2) {
        DynamicIslandExpandedView dynamicIslandExpandedView = this.getExpandedView();
        if (dynamicIslandExpandedView != null && dynamicIslandExpandedView.getParent() != null) {
            dynamicIslandExpandedView.setOutlineProvider(new ViewOutlineProvider(n2){
                final int $bottom;
                {
                    this.$bottom = n2;
                }

                public void getOutline(View view2, Outline outline) {
                    o.g((Object)view2, (String)"view");
                    o.g((Object)outline, (String)"outline");
                    view2.getRenderNode().setPosition(new Rect(view2.getLeft(), view2.getTop(), view2.getRight(), this.$bottom));
                    outline.setRoundRect(0, 0, view2.getRight(), this.$bottom, 0.0f);
                }
            });
        }
    }

    @Override
    public Object updateExpandedView(DynamicIslandData dynamicIslandData, boolean bl, K0.d object) {
        Object object2;
        Object object3;
        Object object4;
        Object object5;
        Object object6;
        object = dynamicIslandData != null && (object = dynamicIslandData.getView()) != null && (object = object.getLayoutParams()) != null ? b.c((int)object.height) : null;
        object6 = dynamicIslandData != null && (object6 = dynamicIslandData.getView()) != null ? b.c((int)object6.getHeight()) : null;
        object5 = dynamicIslandData != null && (object5 = dynamicIslandData.getView()) != null ? b.c((int)object5.getMeasuredHeight()) : null;
        object4 = dynamicIslandData != null && (object4 = dynamicIslandData.getView()) != null && (object4 = object4.getLayoutParams()) != null ? b.c((int)object4.width) : null;
        object3 = dynamicIslandData != null && (object3 = dynamicIslandData.getView()) != null ? b.c((int)object3.getWidth()) : null;
        object2 = dynamicIslandData != null && (object2 = dynamicIslandData.getView()) != null ? b.c((int)object2.getMeasuredWidth()) : null;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("updateExpandedView\uff1a islandData?.view=");
        stringBuilder.append(object);
        stringBuilder.append(", ");
        stringBuilder.append(object6);
        stringBuilder.append(" ");
        stringBuilder.append(object5);
        stringBuilder.append(" ");
        stringBuilder.append(object4);
        stringBuilder.append(", ");
        stringBuilder.append(object3);
        stringBuilder.append(" ");
        stringBuilder.append(object2);
        Log.e((String)TAG, (String)stringBuilder.toString());
        object = dynamicIslandData != null ? dynamicIslandData.getView() : null;
        if (object == null) {
            return s.a;
        }
        object = dynamicIslandData.getView();
        object = object != null ? object.getLayoutParams() : null;
        if (object == null) {
            object6 = new FrameLayout.LayoutParams(-1, -2);
            object6.gravity = 1;
            object = dynamicIslandData.getView();
            if (object != null) {
                object.setLayoutParams((ViewGroup.LayoutParams)object6);
            }
        }
        if ((object = (object = dynamicIslandData.getView()) != null ? object.getParent() : null) != null) {
            object = dynamicIslandData.getView();
            object = object != null ? object.getParent() : null;
            o.e((Object)object, (String)"null cannot be cast to non-null type android.view.ViewGroup");
            ((ViewGroup)object).removeView(dynamicIslandData.getView());
        }
        if ((object = dynamicIslandData.getView()) != null && (object = object.getLayoutParams()) != null && object.width == -1 && (object = (object = dynamicIslandData.getView()) != null ? object.getLayoutParams() : null) != null) {
            object.width = this.getExpandedViewMaxWidth();
        }
        object6 = this.getExpandedView();
        object = object6;
        if (object6 == null) {
            object = this.getExpandedViewStub();
            object = object != null ? object.inflate() : null;
            object = object instanceof DynamicIslandExpandedView ? (DynamicIslandExpandedView)((Object)object) : null;
        }
        this.setExpandedView((DynamicIslandExpandedView)((Object)object));
        if (this.getExpandedView() != null) {
            object = this.getExpandedView();
            o.e((Object)object, (String)"null cannot be cast to non-null type android.view.View");
            DynamicIslandBaseContentView.updateBackgroundBg$default(this, (View)object, false, 2, null);
        }
        this.updateMarginTop((View)this.getExpandedView());
        object = this.getExpandedView();
        if (object != null) {
            object.removeContentView$miui_dynamicisland_release();
        }
        if ((object = this.getExpandedView()) != null) {
            object.setContentView$miui_dynamicisland_release(dynamicIslandData.getView());
        }
        return s.a;
    }

    @Override
    public void updateMarginTop() {
        this.updateMarginTop((View)this.getSmallIslandView());
        this.updateMarginTop((View)this.getBigIslandView());
        this.updateMarginTop((View)this.getExpandedView());
        this.updateMarginTop(this.getMiniBar());
    }

    @Override
    public Object updateSmallIslandView(DynamicIslandData object, boolean bl, K0.d d2) {
        Integer n2;
        if (object != null && (n2 = object.getProperties()) != null && n2 == 0) {
            return s.a;
        }
        if (!bl && (n2 = this.getSmallIslandView()) != null) {
            n2.removeAllViews();
        }
        IslandTemplateFactory islandTemplateFactory = this.getController().getIslandTemplateFactory();
        n2 = this.getContext();
        o.f((Object)n2, (String)"getContext(...)");
        IslandTemplate islandTemplate = this.getTemplate();
        FrameLayout frameLayout = this.getSmallIslandView();
        o.e((Object)frameLayout, (String)"null cannot be cast to non-null type android.view.ViewGroup");
        object = islandTemplateFactory.createSmallIslandTemplate((Context)n2, (DynamicIslandData)object, islandTemplate, (ViewGroup)frameLayout, false, new U0.o((Object)this){

            public final Boolean invoke(DynamicIslandData object, DynamicIslandEvent object2) {
                boolean bl;
                o.g((Object)object2, (String)"p1");
                Object object3 = (DynamicIslandContentView)((Object)((kotlin.jvm.internal.d)this).receiver);
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("emitEvent ");
                stringBuilder.append(object2);
                Log.d((String)"DynamicIslandContentView", (String)stringBuilder.toString());
                if (object2 instanceof DynamicIslandEvent.DeletedDynamicIsland) {
                    object2 = ((DynamicIslandBaseContentView)((Object)object3)).getDynamicIslandEventCoordinator();
                    if (object2 != null && (object2 = ((DynamicIslandEventCoordinator)object2).getWindowView()) != null) {
                        DynamicIslandWindowView.removeDynamicIslandData$default((DynamicIslandWindowView)((Object)object2), object, false, false, 6, null);
                    }
                    if ((object = object != null && (object = object.getExtras()) != null ? (StatusBarNotification)object.getParcelable("miui.sbn", StatusBarNotification.class) : null) != null && (object2 = ((DynamicIslandBaseContentView)((Object)object3)).getDynamicIslandEventCoordinator()) != null && (object2 = ((DynamicIslandEventCoordinator)object2).getWindowView()) != null) {
                        ((DynamicIslandWindowView)((Object)object2)).removeNotification((StatusBarNotification)object);
                    }
                    bl = true;
                } else {
                    if (object2 instanceof DynamicIslandEvent.UpdateDynamicIsland && object != null && (object2 = ((DynamicIslandBaseContentView)((Object)object3)).getDynamicIslandEventCoordinator()) != null && (object2 = ((DynamicIslandEventCoordinator)object2).getWindowView()) != null) {
                        float f2 = (object3 = ((DynamicIslandBaseContentView)((Object)object3)).getDynamicIslandEventCoordinator()) != null && (object3 = ((DynamicIslandEventCoordinator)object3).getWindowView()) != null && (object3 = ((DynamicIslandWindowView)((Object)object3)).getWindowViewController()) != null ? ((DynamicIslandWindowViewController)object3).getIslandMaxWidth() : 0.0f;
                        DynamicIslandWindowView.updateDynamicIslandView$default((DynamicIslandWindowView)((Object)object2), object, false, f2, false, 8, null);
                    }
                    bl = false;
                }
                return bl;
            }
        }, d2);
        if (object == c.c()) {
            return object;
        }
        return s.a;
    }

    public final void updateViewStateWhenCloseEnd() {
        FrameLayout frameLayout;
        this.setVisibility(0);
        if (this.getState() instanceof DynamicIslandState.BigIsland) {
            DynamicIslandBigIslandView dynamicIslandBigIslandView = this.getBigIslandView();
            if (dynamicIslandBigIslandView != null) {
                dynamicIslandBigIslandView.setVisibility(0);
            }
        } else if (this.getState() instanceof DynamicIslandState.SmallIsland && (frameLayout = this.getSmallIslandView()) != null) {
            frameLayout.setVisibility(0);
        }
    }
}
