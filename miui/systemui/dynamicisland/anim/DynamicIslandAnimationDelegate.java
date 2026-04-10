/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  G0.s
 *  android.animation.Animator
 *  android.animation.AnimatorSet
 *  android.animation.ObjectAnimator
 *  android.animation.TimeInterpolator
 *  android.content.Context
 *  android.graphics.Outline
 *  android.graphics.drawable.ColorDrawable
 *  android.os.Bundle
 *  android.util.Log
 *  android.view.View
 *  android.view.ViewOutlineProvider
 *  android.view.animation.PathInterpolator
 *  android.widget.FrameLayout
 *  b1.f
 *  com.android.systemui.plugins.miui.dynamicisland.DynamicIslandData
 *  kotlin.jvm.internal.o
 *  kotlin.jvm.internal.x
 *  miui.systemui.animation.FolmeKt
 *  miui.systemui.util.CommonUtils
 *  miui.systemui.util.DeviceUtils
 *  miui.systemui.util.FoldUtils
 *  miui.systemui.util.MiBlurCompat
 *  miui.systemui.util.OneHandModeUtils
 *  miui.systemui.util.ThreadUtils
 *  miuix.animation.Folme$ObjectFolmeImpl
 *  miuix.animation.FolmeEase
 *  miuix.animation.FolmeObject
 *  miuix.animation.IFolme
 *  miuix.animation.IStateStyle
 *  miuix.animation.base.AnimConfig
 *  miuix.animation.controller.AnimState
 *  miuix.animation.listener.TransitionListener
 *  miuix.animation.listener.UpdateInfo
 *  miuix.animation.property.ColorProperty
 *  miuix.animation.property.FloatProperty
 *  miuix.animation.property.ViewProperty
 *  miuix.animation.utils.EaseManager$EaseStyle
 */
package miui.systemui.dynamicisland.anim;

import G0.s;
import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.graphics.Outline;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewOutlineProvider;
import android.view.animation.PathInterpolator;
import android.widget.FrameLayout;
import b1.f;
import com.android.systemui.plugins.miui.dynamicisland.DynamicIslandData;
import java.util.Collection;
import java.util.List;
import kotlin.jvm.internal.o;
import kotlin.jvm.internal.x;
import miui.systemui.animation.FolmeKt;
import miui.systemui.dynamicisland.DynamicIslandAnimUtils;
import miui.systemui.dynamicisland.DynamicIslandBackgroundView;
import miui.systemui.dynamicisland.DynamicIslandScenarioUtils;
import miui.systemui.dynamicisland.DynamicIslandUtils;
import miui.systemui.dynamicisland.R;
import miui.systemui.dynamicisland.anim.DynamicIslandAnimListener;
import miui.systemui.dynamicisland.anim.DynamicIslandAnimationCallback;
import miui.systemui.dynamicisland.anim.DynamicIslandAnimationCallbackType;
import miui.systemui.dynamicisland.anim.DynamicIslandAnimationController;
import miui.systemui.dynamicisland.anim.DynamicIslandAnimationType;
import miui.systemui.dynamicisland.device.strategy.DynamicIslandAnimationDelegateHelper;
import miui.systemui.dynamicisland.event.DynamicIslandEvent;
import miui.systemui.dynamicisland.event.DynamicIslandEventCoordinator;
import miui.systemui.dynamicisland.event.DynamicIslandState;
import miui.systemui.dynamicisland.event.handler.BigIslandStateHandler;
import miui.systemui.dynamicisland.event.handler.ExpandedStateHandler;
import miui.systemui.dynamicisland.event.handler.SmallIslandStateHandler;
import miui.systemui.dynamicisland.view.DynamicIslandBigIslandView;
import miui.systemui.dynamicisland.view.DynamicIslandExpandedView;
import miui.systemui.dynamicisland.window.DynamicIslandWindowState;
import miui.systemui.dynamicisland.window.DynamicIslandWindowView;
import miui.systemui.dynamicisland.window.DynamicIslandWindowViewController;
import miui.systemui.dynamicisland.window.content.DynamicIslandBaseContentView;
import miui.systemui.dynamicisland.window.content.DynamicIslandContentFakeView;
import miui.systemui.dynamicisland.window.content.DynamicIslandContentView;
import miui.systemui.util.CommonUtils;
import miui.systemui.util.DeviceUtils;
import miui.systemui.util.FoldUtils;
import miui.systemui.util.MiBlurCompat;
import miui.systemui.util.OneHandModeUtils;
import miui.systemui.util.ThreadUtils;
import miuix.animation.Folme;
import miuix.animation.FolmeEase;
import miuix.animation.FolmeObject;
import miuix.animation.IFolme;
import miuix.animation.IStateStyle;
import miuix.animation.base.AnimConfig;
import miuix.animation.controller.AnimState;
import miuix.animation.listener.TransitionListener;
import miuix.animation.listener.UpdateInfo;
import miuix.animation.property.ColorProperty;
import miuix.animation.property.FloatProperty;
import miuix.animation.property.ViewProperty;
import miuix.animation.utils.EaseManager;

public final class DynamicIslandAnimationDelegate
implements FolmeObject {
    private static final FloatProperty<DynamicIslandAnimationDelegate> BIG_ISLAND_ALPHA;
    private static final FloatProperty<DynamicIslandAnimationDelegate> BIG_ISLAND_AREA_LEFT_TRANS_X;
    private static final FloatProperty<DynamicIslandAnimationDelegate> BIG_ISLAND_AREA_RIGHT_TRANS_X;
    private static final FloatProperty<DynamicIslandAnimationDelegate> BIG_ISLAND_BLUR;
    private static final FloatProperty<DynamicIslandAnimationDelegate> BIG_ISLAND_SCALE;
    private static final FloatProperty<DynamicIslandAnimationDelegate> BIG_ISLAND_TRANS_X;
    private static final FloatProperty<DynamicIslandAnimationDelegate> BIG_ISLAND_TRANS_Y;
    private static final FloatProperty<DynamicIslandAnimationDelegate> BIG_ISLAND_X;
    private static final FloatProperty<DynamicIslandAnimationDelegate> CONTAINER_ALPHA;
    private static final ColorProperty<DynamicIslandAnimationDelegate> CONTAINER_BACKGROUND_COLOR;
    private static final FloatProperty<DynamicIslandAnimationDelegate> CONTAINER_BLUR;
    private static final FloatProperty<DynamicIslandAnimationDelegate> CONTAINER_CLIP_BOTTOM_PROGRESS;
    private static final FloatProperty<DynamicIslandAnimationDelegate> CONTAINER_CLIP_END_PROGRESS;
    private static final FloatProperty<DynamicIslandAnimationDelegate> CONTAINER_CLIP_START_PROGRESS;
    private static final FloatProperty<DynamicIslandAnimationDelegate> CONTAINER_CLIP_TOP_PROGRESS;
    private static final FloatProperty<DynamicIslandAnimationDelegate> CONTAINER_TRANS_Y;
    private static final FloatProperty<DynamicIslandAnimationDelegate> CONTAINER_X;
    public static final Companion Companion;
    private static final EaseManager.EaseStyle EASE_FAST_OUT_SLOW_IN;
    private static final FloatProperty<DynamicIslandAnimationDelegate> EXPANDED_ALPHA;
    private static final FloatProperty<DynamicIslandAnimationDelegate> EXPANDED_BLUR;
    private static final FloatProperty<DynamicIslandAnimationDelegate> EXPANDED_SCALE_X;
    private static final FloatProperty<DynamicIslandAnimationDelegate> EXPANDED_SCALE_Y;
    private static final FloatProperty<DynamicIslandAnimationDelegate> EXPANDED_TRANS_X;
    private static final FloatProperty<DynamicIslandAnimationDelegate> EXPANDED_TRANS_Y;
    private static final FloatProperty<DynamicIslandAnimationDelegate> FAKE_BIG_ALPHA;
    private static final FloatProperty<DynamicIslandAnimationDelegate> FAKE_BIG_BLUR;
    private static final FloatProperty<DynamicIslandAnimationDelegate> FAKE_EXPANDED_ALPHA;
    private static final FloatProperty<DynamicIslandAnimationDelegate> FAKE_EXPANDED_BLUR;
    private static final FloatProperty<DynamicIslandAnimationDelegate> FAKE_SMALL_ALPHA;
    private static final FloatProperty<DynamicIslandAnimationDelegate> FAKE_SMALL_BLUR;
    private static final FloatProperty<DynamicIslandAnimationDelegate> SMALL_ISLAND_ALPHA;
    private static final FloatProperty<DynamicIslandAnimationDelegate> SMALL_ISLAND_BLUR;
    private static final FloatProperty<DynamicIslandAnimationDelegate> SMALL_ISLAND_SCALE;
    private static final FloatProperty<DynamicIslandAnimationDelegate> SMALL_ISLAND_TRANS_X;
    private static final FloatProperty<DynamicIslandAnimationDelegate> SMALL_ISLAND_TRANS_Y;
    private static final long UNLOCK_DELAY_ANIM_TIME = 200L;
    private final FolmeObject $$delegate_0;
    private final EaseManager.EaseStyle ALPHA_EASE;
    private final EaseManager.EaseStyle APPEAR_EASE;
    private final EaseManager.EaseStyle CHANGE_EASE;
    private final int COLOR_BIG_ISLAND;
    private final int COLOR_BLACK;
    private final int COLOR_EXPANDED;
    private final EaseManager.EaseStyle EASE_SININOUT_025;
    private final EaseManager.EaseStyle EASE_SPRING_083_042;
    private final EaseManager.EaseStyle EASE_SPRING_095_015;
    private final EaseManager.EaseStyle EASE_SPRING_095_035;
    private final EaseManager.EaseStyle FAKE_ALPHA_EASE;
    private final EaseManager.EaseStyle HIDDEN_EASE;
    private final EaseManager.EaseStyle PAD_BOTTOM_ISLAND_HIDDEN_EASE;
    private final EaseManager.EaseStyle PAD_CHANGE_EASE;
    private final EaseManager.EaseStyle PAD_HIGHT_HIDDEN_EASE;
    private final EaseManager.EaseStyle PAD_NORMAL_HIDDEN_EASE;
    private final EaseManager.EaseStyle PAD_SHOW_EASE;
    private final EaseManager.EaseStyle SCALE_EASE;
    private final EaseManager.EaseStyle SHOW_EASE;
    private final String TAG;
    private final DynamicIslandAnimationDelegateHelper animationDelegateHelper;
    private final DynamicIslandAnimationDelegateHelper.Factory animationDelegateHelperFactory;
    private boolean appClose;
    private float beginExpandedScaleX;
    private float bigIslandAlpha;
    private float bigIslandAreaLeft;
    private float bigIslandAreaRight;
    private float bigIslandBlur;
    private float bigIslandScale;
    private final BigIslandStateHandler bigIslandStateHandler;
    private float bigIslandTransX;
    private float bigIslandTransY;
    private float bigIslandX;
    private float containerAlpha;
    private int containerBackgroundColor;
    private float containerBlur;
    private float containerClipBottomProgress;
    private float containerClipEndProgress;
    private float containerClipStartProgress;
    private float containerClipTopProgress;
    private float containerTransY;
    private float containerX;
    private int currentExpandHeight;
    private final float debugIslandAnimScale;
    private final DynamicIslandAnimationController dynamicIslandAnimController;
    private float expandedAlpha;
    private float expandedBlur;
    private float expandedScaleX;
    private float expandedScaleY;
    private final ExpandedStateHandler expandedStateHandler;
    private boolean expandedToTempHiddenAnimating;
    private float expandedTransX;
    private float expandedTransY;
    private float expandedViewAnimatingProgress;
    private boolean expandedViewHadScaled;
    private float fakeBigAlpha;
    private float fakeBigBlur;
    private float fakeExpandedAlpha;
    private float fakeExpandedBlur;
    private float fakeSmallAlpha;
    private float fakeSmallBlur;
    private boolean fakeViewAnimating;
    private DynamicIslandState hiddenStateFrom;
    private boolean isAnimateExpanding;
    private boolean isAnimating;
    private boolean isAppClosing;
    private boolean isBlockUpdatePosition;
    private boolean isMoveDownAnimating;
    private volatile boolean isMoveUpAnimating;
    private final boolean isTableMiddleIsland;
    private final boolean isTableSummaryIsland;
    private boolean islandAppAnimRunning;
    private boolean islandFreeformAnimRunning;
    private boolean islandStateChanged;
    private float lastBigIslandStart;
    private int lastExpandHeight;
    private boolean needResetContainerAlpha;
    private boolean shouldBlockScale;
    private float smallIslandAlpha;
    private float smallIslandBlur;
    private float smallIslandScale;
    private final SmallIslandStateHandler smallIslandStateHandler;
    private float smallIslandTransX;
    private float smallIslandTransY;
    private final boolean supportBlur;
    private final DynamicIslandBaseContentView view;
    private final DynamicIslandWindowView windowView;

    static {
        Companion = new Object(null){
            {
                this();
            }

            public final FloatProperty<DynamicIslandAnimationDelegate> getBIG_ISLAND_ALPHA() {
                return BIG_ISLAND_ALPHA;
            }

            public final FloatProperty<DynamicIslandAnimationDelegate> getBIG_ISLAND_AREA_LEFT_TRANS_X() {
                return BIG_ISLAND_AREA_LEFT_TRANS_X;
            }

            public final FloatProperty<DynamicIslandAnimationDelegate> getBIG_ISLAND_AREA_RIGHT_TRANS_X() {
                return BIG_ISLAND_AREA_RIGHT_TRANS_X;
            }

            public final FloatProperty<DynamicIslandAnimationDelegate> getBIG_ISLAND_BLUR() {
                return BIG_ISLAND_BLUR;
            }

            public final FloatProperty<DynamicIslandAnimationDelegate> getBIG_ISLAND_SCALE() {
                return BIG_ISLAND_SCALE;
            }

            public final FloatProperty<DynamicIslandAnimationDelegate> getBIG_ISLAND_TRANS_X() {
                return BIG_ISLAND_TRANS_X;
            }

            public final FloatProperty<DynamicIslandAnimationDelegate> getBIG_ISLAND_TRANS_Y() {
                return BIG_ISLAND_TRANS_Y;
            }

            public final FloatProperty<DynamicIslandAnimationDelegate> getBIG_ISLAND_X() {
                return BIG_ISLAND_X;
            }

            public final FloatProperty<DynamicIslandAnimationDelegate> getCONTAINER_ALPHA() {
                return CONTAINER_ALPHA;
            }

            public final ColorProperty<DynamicIslandAnimationDelegate> getCONTAINER_BACKGROUND_COLOR() {
                return CONTAINER_BACKGROUND_COLOR;
            }

            public final FloatProperty<DynamicIslandAnimationDelegate> getCONTAINER_BLUR() {
                return CONTAINER_BLUR;
            }

            public final FloatProperty<DynamicIslandAnimationDelegate> getCONTAINER_CLIP_BOTTOM_PROGRESS() {
                return CONTAINER_CLIP_BOTTOM_PROGRESS;
            }

            public final FloatProperty<DynamicIslandAnimationDelegate> getCONTAINER_CLIP_END_PROGRESS() {
                return CONTAINER_CLIP_END_PROGRESS;
            }

            public final FloatProperty<DynamicIslandAnimationDelegate> getCONTAINER_CLIP_START_PROGRESS() {
                return CONTAINER_CLIP_START_PROGRESS;
            }

            public final FloatProperty<DynamicIslandAnimationDelegate> getCONTAINER_CLIP_TOP_PROGRESS() {
                return CONTAINER_CLIP_TOP_PROGRESS;
            }

            public final FloatProperty<DynamicIslandAnimationDelegate> getCONTAINER_TRANS_Y() {
                return CONTAINER_TRANS_Y;
            }

            public final FloatProperty<DynamicIslandAnimationDelegate> getCONTAINER_X() {
                return CONTAINER_X;
            }

            public final EaseManager.EaseStyle getEASE_FAST_OUT_SLOW_IN() {
                return EASE_FAST_OUT_SLOW_IN;
            }

            public final FloatProperty<DynamicIslandAnimationDelegate> getEXPANDED_ALPHA() {
                return EXPANDED_ALPHA;
            }

            public final FloatProperty<DynamicIslandAnimationDelegate> getEXPANDED_BLUR() {
                return EXPANDED_BLUR;
            }

            public final FloatProperty<DynamicIslandAnimationDelegate> getEXPANDED_SCALE_X() {
                return EXPANDED_SCALE_X;
            }

            public final FloatProperty<DynamicIslandAnimationDelegate> getEXPANDED_SCALE_Y() {
                return EXPANDED_SCALE_Y;
            }

            public final FloatProperty<DynamicIslandAnimationDelegate> getEXPANDED_TRANS_X() {
                return EXPANDED_TRANS_X;
            }

            public final FloatProperty<DynamicIslandAnimationDelegate> getEXPANDED_TRANS_Y() {
                return EXPANDED_TRANS_Y;
            }

            public final FloatProperty<DynamicIslandAnimationDelegate> getFAKE_BIG_ALPHA() {
                return FAKE_BIG_ALPHA;
            }

            public final FloatProperty<DynamicIslandAnimationDelegate> getFAKE_BIG_BLUR() {
                return FAKE_BIG_BLUR;
            }

            public final FloatProperty<DynamicIslandAnimationDelegate> getFAKE_EXPANDED_ALPHA() {
                return FAKE_EXPANDED_ALPHA;
            }

            public final FloatProperty<DynamicIslandAnimationDelegate> getFAKE_EXPANDED_BLUR() {
                return FAKE_EXPANDED_BLUR;
            }

            public final FloatProperty<DynamicIslandAnimationDelegate> getFAKE_SMALL_ALPHA() {
                return FAKE_SMALL_ALPHA;
            }

            public final FloatProperty<DynamicIslandAnimationDelegate> getFAKE_SMALL_BLUR() {
                return FAKE_SMALL_BLUR;
            }

            public final FloatProperty<DynamicIslandAnimationDelegate> getSMALL_ISLAND_ALPHA() {
                return SMALL_ISLAND_ALPHA;
            }

            public final FloatProperty<DynamicIslandAnimationDelegate> getSMALL_ISLAND_BLUR() {
                return SMALL_ISLAND_BLUR;
            }

            public final FloatProperty<DynamicIslandAnimationDelegate> getSMALL_ISLAND_SCALE() {
                return SMALL_ISLAND_SCALE;
            }

            public final FloatProperty<DynamicIslandAnimationDelegate> getSMALL_ISLAND_TRANS_X() {
                return SMALL_ISLAND_TRANS_X;
            }

            public final FloatProperty<DynamicIslandAnimationDelegate> getSMALL_ISLAND_TRANS_Y() {
                return SMALL_ISLAND_TRANS_Y;
            }
        };
        CONTAINER_BLUR = new FloatProperty<DynamicIslandAnimationDelegate>(){

            public float getValue(DynamicIslandAnimationDelegate dynamicIslandAnimationDelegate) {
                o.g((Object)dynamicIslandAnimationDelegate, (String)"holder");
                return DynamicIslandAnimationDelegate.access$getContainerBlur$p(dynamicIslandAnimationDelegate);
            }

            public void setValue(DynamicIslandAnimationDelegate dynamicIslandAnimationDelegate, float f2) {
                o.g((Object)dynamicIslandAnimationDelegate, (String)"holder");
                if (Float.isNaN(f2)) {
                    return;
                }
                DynamicIslandAnimationDelegate.access$setContainerBlur$p(dynamicIslandAnimationDelegate, f2);
            }
        };
        CONTAINER_X = new FloatProperty<DynamicIslandAnimationDelegate>(){

            public float getValue(DynamicIslandAnimationDelegate dynamicIslandAnimationDelegate) {
                o.g((Object)dynamicIslandAnimationDelegate, (String)"holder");
                return DynamicIslandAnimationDelegate.access$getContainerX$p(dynamicIslandAnimationDelegate);
            }

            public void setValue(DynamicIslandAnimationDelegate dynamicIslandAnimationDelegate, float f2) {
                o.g((Object)dynamicIslandAnimationDelegate, (String)"holder");
                if (Float.isNaN(f2)) {
                    return;
                }
                DynamicIslandAnimationDelegate.access$setContainerX$p(dynamicIslandAnimationDelegate, f2);
            }
        };
        CONTAINER_TRANS_Y = new FloatProperty<DynamicIslandAnimationDelegate>(){

            public float getValue(DynamicIslandAnimationDelegate dynamicIslandAnimationDelegate) {
                o.g((Object)dynamicIslandAnimationDelegate, (String)"holder");
                return DynamicIslandAnimationDelegate.access$getContainerTransY$p(dynamicIslandAnimationDelegate);
            }

            public void setValue(DynamicIslandAnimationDelegate dynamicIslandAnimationDelegate, float f2) {
                o.g((Object)dynamicIslandAnimationDelegate, (String)"holder");
                if (Float.isNaN(f2)) {
                    return;
                }
                DynamicIslandAnimationDelegate.access$setContainerTransY$p(dynamicIslandAnimationDelegate, f2);
            }
        };
        CONTAINER_ALPHA = new FloatProperty<DynamicIslandAnimationDelegate>(){

            public float getValue(DynamicIslandAnimationDelegate dynamicIslandAnimationDelegate) {
                o.g((Object)dynamicIslandAnimationDelegate, (String)"holder");
                return DynamicIslandAnimationDelegate.access$getContainerAlpha$p(dynamicIslandAnimationDelegate);
            }

            public void setValue(DynamicIslandAnimationDelegate dynamicIslandAnimationDelegate, float f2) {
                o.g((Object)dynamicIslandAnimationDelegate, (String)"holder");
                if (Float.isNaN(f2)) {
                    return;
                }
                DynamicIslandAnimationDelegate.access$setContainerAlpha$p(dynamicIslandAnimationDelegate, f2);
            }
        };
        CONTAINER_CLIP_START_PROGRESS = new FloatProperty<DynamicIslandAnimationDelegate>(){

            public float getValue(DynamicIslandAnimationDelegate dynamicIslandAnimationDelegate) {
                o.g((Object)dynamicIslandAnimationDelegate, (String)"holder");
                return DynamicIslandAnimationDelegate.access$getContainerClipStartProgress$p(dynamicIslandAnimationDelegate);
            }

            public void setValue(DynamicIslandAnimationDelegate dynamicIslandAnimationDelegate, float f2) {
                o.g((Object)dynamicIslandAnimationDelegate, (String)"holder");
                if (Float.isNaN(f2)) {
                    return;
                }
                DynamicIslandAnimationDelegate.access$setContainerClipStartProgress$p(dynamicIslandAnimationDelegate, f2);
            }
        };
        CONTAINER_CLIP_END_PROGRESS = new FloatProperty<DynamicIslandAnimationDelegate>(){

            public float getValue(DynamicIslandAnimationDelegate dynamicIslandAnimationDelegate) {
                o.g((Object)dynamicIslandAnimationDelegate, (String)"holder");
                return DynamicIslandAnimationDelegate.access$getContainerClipEndProgress$p(dynamicIslandAnimationDelegate);
            }

            public void setValue(DynamicIslandAnimationDelegate dynamicIslandAnimationDelegate, float f2) {
                o.g((Object)dynamicIslandAnimationDelegate, (String)"holder");
                if (Float.isNaN(f2)) {
                    return;
                }
                DynamicIslandAnimationDelegate.access$setContainerClipEndProgress$p(dynamicIslandAnimationDelegate, f2);
            }
        };
        CONTAINER_CLIP_TOP_PROGRESS = new FloatProperty<DynamicIslandAnimationDelegate>(){

            public float getValue(DynamicIslandAnimationDelegate dynamicIslandAnimationDelegate) {
                o.g((Object)dynamicIslandAnimationDelegate, (String)"holder");
                return DynamicIslandAnimationDelegate.access$getContainerClipTopProgress$p(dynamicIslandAnimationDelegate);
            }

            public void setValue(DynamicIslandAnimationDelegate dynamicIslandAnimationDelegate, float f2) {
                o.g((Object)dynamicIslandAnimationDelegate, (String)"holder");
                if (Float.isNaN(f2)) {
                    return;
                }
                DynamicIslandAnimationDelegate.access$setContainerClipTopProgress$p(dynamicIslandAnimationDelegate, f2);
            }
        };
        CONTAINER_CLIP_BOTTOM_PROGRESS = new FloatProperty<DynamicIslandAnimationDelegate>(){

            public float getValue(DynamicIslandAnimationDelegate dynamicIslandAnimationDelegate) {
                o.g((Object)dynamicIslandAnimationDelegate, (String)"holder");
                return DynamicIslandAnimationDelegate.access$getContainerClipBottomProgress$p(dynamicIslandAnimationDelegate);
            }

            public void setValue(DynamicIslandAnimationDelegate dynamicIslandAnimationDelegate, float f2) {
                o.g((Object)dynamicIslandAnimationDelegate, (String)"holder");
                if (Float.isNaN(f2)) {
                    return;
                }
                DynamicIslandAnimationDelegate.access$setContainerClipBottomProgress$p(dynamicIslandAnimationDelegate, f2);
            }
        };
        CONTAINER_BACKGROUND_COLOR = new ColorProperty<DynamicIslandAnimationDelegate>(){

            public void setIntValue(DynamicIslandAnimationDelegate dynamicIslandAnimationDelegate, int n) {
                o.g((Object)dynamicIslandAnimationDelegate, (String)"holder");
                super.setIntValue((Object)dynamicIslandAnimationDelegate, n);
                DynamicIslandAnimationDelegate.access$setContainerBackgroundColor$p(dynamicIslandAnimationDelegate, n);
            }
        };
        EXPANDED_ALPHA = new FloatProperty<DynamicIslandAnimationDelegate>(){

            public float getValue(DynamicIslandAnimationDelegate dynamicIslandAnimationDelegate) {
                o.g((Object)dynamicIslandAnimationDelegate, (String)"holder");
                return DynamicIslandAnimationDelegate.access$getExpandedAlpha$p(dynamicIslandAnimationDelegate);
            }

            public void setValue(DynamicIslandAnimationDelegate dynamicIslandAnimationDelegate, float f2) {
                o.g((Object)dynamicIslandAnimationDelegate, (String)"holder");
                if (Float.isNaN(f2)) {
                    return;
                }
                DynamicIslandAnimationDelegate.access$setExpandedAlpha$p(dynamicIslandAnimationDelegate, f2);
            }
        };
        EXPANDED_SCALE_X = new FloatProperty<DynamicIslandAnimationDelegate>(){

            public float getValue(DynamicIslandAnimationDelegate dynamicIslandAnimationDelegate) {
                o.g((Object)dynamicIslandAnimationDelegate, (String)"holder");
                return DynamicIslandAnimationDelegate.access$getExpandedScaleX$p(dynamicIslandAnimationDelegate);
            }

            public void setValue(DynamicIslandAnimationDelegate dynamicIslandAnimationDelegate, float f2) {
                o.g((Object)dynamicIslandAnimationDelegate, (String)"holder");
                if (Float.isNaN(f2)) {
                    return;
                }
                DynamicIslandAnimationDelegate.access$setExpandedScaleX$p(dynamicIslandAnimationDelegate, f2);
            }
        };
        EXPANDED_SCALE_Y = new FloatProperty<DynamicIslandAnimationDelegate>(){

            public float getValue(DynamicIslandAnimationDelegate dynamicIslandAnimationDelegate) {
                o.g((Object)dynamicIslandAnimationDelegate, (String)"holder");
                return DynamicIslandAnimationDelegate.access$getExpandedScaleY$p(dynamicIslandAnimationDelegate);
            }

            public void setValue(DynamicIslandAnimationDelegate dynamicIslandAnimationDelegate, float f2) {
                o.g((Object)dynamicIslandAnimationDelegate, (String)"holder");
                if (Float.isNaN(f2)) {
                    return;
                }
                DynamicIslandAnimationDelegate.access$setExpandedScaleY$p(dynamicIslandAnimationDelegate, f2);
            }
        };
        EXPANDED_TRANS_Y = new FloatProperty<DynamicIslandAnimationDelegate>(){

            public float getValue(DynamicIslandAnimationDelegate dynamicIslandAnimationDelegate) {
                o.g((Object)dynamicIslandAnimationDelegate, (String)"holder");
                return DynamicIslandAnimationDelegate.access$getExpandedTransY$p(dynamicIslandAnimationDelegate);
            }

            public void setValue(DynamicIslandAnimationDelegate dynamicIslandAnimationDelegate, float f2) {
                o.g((Object)dynamicIslandAnimationDelegate, (String)"holder");
                if (Float.isNaN(f2)) {
                    return;
                }
                DynamicIslandAnimationDelegate.access$setExpandedTransY$p(dynamicIslandAnimationDelegate, f2);
            }
        };
        EXPANDED_TRANS_X = new FloatProperty<DynamicIslandAnimationDelegate>(){

            public float getValue(DynamicIslandAnimationDelegate dynamicIslandAnimationDelegate) {
                o.g((Object)dynamicIslandAnimationDelegate, (String)"holder");
                return DynamicIslandAnimationDelegate.access$getExpandedTransX$p(dynamicIslandAnimationDelegate);
            }

            public void setValue(DynamicIslandAnimationDelegate dynamicIslandAnimationDelegate, float f2) {
                o.g((Object)dynamicIslandAnimationDelegate, (String)"holder");
                if (Float.isNaN(f2)) {
                    return;
                }
                DynamicIslandAnimationDelegate.access$setExpandedTransX$p(dynamicIslandAnimationDelegate, f2);
            }
        };
        BIG_ISLAND_ALPHA = new FloatProperty<DynamicIslandAnimationDelegate>(){

            public float getValue(DynamicIslandAnimationDelegate dynamicIslandAnimationDelegate) {
                o.g((Object)dynamicIslandAnimationDelegate, (String)"holder");
                return DynamicIslandAnimationDelegate.access$getBigIslandAlpha$p(dynamicIslandAnimationDelegate);
            }

            public void setValue(DynamicIslandAnimationDelegate dynamicIslandAnimationDelegate, float f2) {
                o.g((Object)dynamicIslandAnimationDelegate, (String)"holder");
                if (Float.isNaN(f2)) {
                    return;
                }
                DynamicIslandAnimationDelegate.access$setBigIslandAlpha$p(dynamicIslandAnimationDelegate, f2);
            }
        };
        BIG_ISLAND_TRANS_X = new FloatProperty<DynamicIslandAnimationDelegate>(){

            public float getValue(DynamicIslandAnimationDelegate dynamicIslandAnimationDelegate) {
                o.g((Object)dynamicIslandAnimationDelegate, (String)"holder");
                return DynamicIslandAnimationDelegate.access$getBigIslandTransX$p(dynamicIslandAnimationDelegate);
            }

            public void setValue(DynamicIslandAnimationDelegate dynamicIslandAnimationDelegate, float f2) {
                o.g((Object)dynamicIslandAnimationDelegate, (String)"holder");
                if (Float.isNaN(f2)) {
                    return;
                }
                DynamicIslandAnimationDelegate.access$setBigIslandTransX$p(dynamicIslandAnimationDelegate, f2);
            }
        };
        BIG_ISLAND_SCALE = new FloatProperty<DynamicIslandAnimationDelegate>(){

            public float getValue(DynamicIslandAnimationDelegate dynamicIslandAnimationDelegate) {
                o.g((Object)dynamicIslandAnimationDelegate, (String)"holder");
                return DynamicIslandAnimationDelegate.access$getBigIslandScale$p(dynamicIslandAnimationDelegate);
            }

            public void setValue(DynamicIslandAnimationDelegate dynamicIslandAnimationDelegate, float f2) {
                o.g((Object)dynamicIslandAnimationDelegate, (String)"holder");
                if (Float.isNaN(f2)) {
                    return;
                }
                DynamicIslandAnimationDelegate.access$setBigIslandScale$p(dynamicIslandAnimationDelegate, f2);
            }
        };
        BIG_ISLAND_X = new FloatProperty<DynamicIslandAnimationDelegate>(){

            public float getValue(DynamicIslandAnimationDelegate dynamicIslandAnimationDelegate) {
                o.g((Object)dynamicIslandAnimationDelegate, (String)"holder");
                return DynamicIslandAnimationDelegate.access$getBigIslandX$p(dynamicIslandAnimationDelegate);
            }

            public void setValue(DynamicIslandAnimationDelegate dynamicIslandAnimationDelegate, float f2) {
                o.g((Object)dynamicIslandAnimationDelegate, (String)"holder");
                if (Float.isNaN(f2)) {
                    return;
                }
                DynamicIslandAnimationDelegate.access$setBigIslandX$p(dynamicIslandAnimationDelegate, f2);
            }
        };
        BIG_ISLAND_TRANS_Y = new FloatProperty<DynamicIslandAnimationDelegate>(){

            public float getValue(DynamicIslandAnimationDelegate dynamicIslandAnimationDelegate) {
                o.g((Object)dynamicIslandAnimationDelegate, (String)"holder");
                return DynamicIslandAnimationDelegate.access$getBigIslandTransY$p(dynamicIslandAnimationDelegate);
            }

            public void setValue(DynamicIslandAnimationDelegate dynamicIslandAnimationDelegate, float f2) {
                o.g((Object)dynamicIslandAnimationDelegate, (String)"holder");
                if (Float.isNaN(f2)) {
                    return;
                }
                DynamicIslandAnimationDelegate.access$setBigIslandTransY$p(dynamicIslandAnimationDelegate, f2);
            }
        };
        BIG_ISLAND_AREA_LEFT_TRANS_X = new FloatProperty<DynamicIslandAnimationDelegate>(){

            public float getValue(DynamicIslandAnimationDelegate dynamicIslandAnimationDelegate) {
                o.g((Object)dynamicIslandAnimationDelegate, (String)"holder");
                return DynamicIslandAnimationDelegate.access$getBigIslandAreaLeft$p(dynamicIslandAnimationDelegate);
            }

            public void setValue(DynamicIslandAnimationDelegate dynamicIslandAnimationDelegate, float f2) {
                o.g((Object)dynamicIslandAnimationDelegate, (String)"holder");
                if (Float.isNaN(f2)) {
                    return;
                }
                DynamicIslandAnimationDelegate.access$setBigIslandAreaLeft$p(dynamicIslandAnimationDelegate, f2);
            }
        };
        BIG_ISLAND_AREA_RIGHT_TRANS_X = new FloatProperty<DynamicIslandAnimationDelegate>(){

            public float getValue(DynamicIslandAnimationDelegate dynamicIslandAnimationDelegate) {
                o.g((Object)dynamicIslandAnimationDelegate, (String)"holder");
                return DynamicIslandAnimationDelegate.access$getBigIslandAreaRight$p(dynamicIslandAnimationDelegate);
            }

            public void setValue(DynamicIslandAnimationDelegate dynamicIslandAnimationDelegate, float f2) {
                o.g((Object)dynamicIslandAnimationDelegate, (String)"holder");
                if (Float.isNaN(f2)) {
                    return;
                }
                DynamicIslandAnimationDelegate.access$setBigIslandAreaRight$p(dynamicIslandAnimationDelegate, f2);
            }
        };
        SMALL_ISLAND_ALPHA = new FloatProperty<DynamicIslandAnimationDelegate>(){

            public float getValue(DynamicIslandAnimationDelegate dynamicIslandAnimationDelegate) {
                o.g((Object)dynamicIslandAnimationDelegate, (String)"holder");
                return DynamicIslandAnimationDelegate.access$getSmallIslandAlpha$p(dynamicIslandAnimationDelegate);
            }

            public void setValue(DynamicIslandAnimationDelegate dynamicIslandAnimationDelegate, float f2) {
                o.g((Object)dynamicIslandAnimationDelegate, (String)"holder");
                if (Float.isNaN(f2)) {
                    return;
                }
                DynamicIslandAnimationDelegate.access$setSmallIslandAlpha$p(dynamicIslandAnimationDelegate, f2);
            }
        };
        SMALL_ISLAND_SCALE = new FloatProperty<DynamicIslandAnimationDelegate>(){

            public float getValue(DynamicIslandAnimationDelegate dynamicIslandAnimationDelegate) {
                o.g((Object)dynamicIslandAnimationDelegate, (String)"holder");
                return DynamicIslandAnimationDelegate.access$getSmallIslandScale$p(dynamicIslandAnimationDelegate);
            }

            public void setValue(DynamicIslandAnimationDelegate dynamicIslandAnimationDelegate, float f2) {
                o.g((Object)dynamicIslandAnimationDelegate, (String)"holder");
                if (Float.isNaN(f2)) {
                    return;
                }
                DynamicIslandAnimationDelegate.access$setSmallIslandScale$p(dynamicIslandAnimationDelegate, f2);
            }
        };
        SMALL_ISLAND_TRANS_X = new FloatProperty<DynamicIslandAnimationDelegate>(){

            public float getValue(DynamicIslandAnimationDelegate dynamicIslandAnimationDelegate) {
                o.g((Object)dynamicIslandAnimationDelegate, (String)"holder");
                return DynamicIslandAnimationDelegate.access$getSmallIslandTransX$p(dynamicIslandAnimationDelegate);
            }

            public void setValue(DynamicIslandAnimationDelegate dynamicIslandAnimationDelegate, float f2) {
                o.g((Object)dynamicIslandAnimationDelegate, (String)"holder");
                if (Float.isNaN(f2)) {
                    return;
                }
                DynamicIslandAnimationDelegate.access$setSmallIslandTransX$p(dynamicIslandAnimationDelegate, f2);
            }
        };
        SMALL_ISLAND_TRANS_Y = new FloatProperty<DynamicIslandAnimationDelegate>(){

            public float getValue(DynamicIslandAnimationDelegate dynamicIslandAnimationDelegate) {
                o.g((Object)dynamicIslandAnimationDelegate, (String)"holder");
                return DynamicIslandAnimationDelegate.access$getSmallIslandTransY$p(dynamicIslandAnimationDelegate);
            }

            public void setValue(DynamicIslandAnimationDelegate dynamicIslandAnimationDelegate, float f2) {
                o.g((Object)dynamicIslandAnimationDelegate, (String)"holder");
                if (Float.isNaN(f2)) {
                    return;
                }
                DynamicIslandAnimationDelegate.access$setSmallIslandTransY$p(dynamicIslandAnimationDelegate, f2);
            }
        };
        SMALL_ISLAND_BLUR = new FloatProperty<DynamicIslandAnimationDelegate>(){

            public float getValue(DynamicIslandAnimationDelegate dynamicIslandAnimationDelegate) {
                o.g((Object)dynamicIslandAnimationDelegate, (String)"holder");
                return DynamicIslandAnimationDelegate.access$getSmallIslandBlur$p(dynamicIslandAnimationDelegate);
            }

            public void setValue(DynamicIslandAnimationDelegate dynamicIslandAnimationDelegate, float f2) {
                o.g((Object)dynamicIslandAnimationDelegate, (String)"holder");
                if (Float.isNaN(f2)) {
                    return;
                }
                DynamicIslandAnimationDelegate.access$setSmallIslandBlur$p(dynamicIslandAnimationDelegate, f2);
            }
        };
        BIG_ISLAND_BLUR = new FloatProperty<DynamicIslandAnimationDelegate>(){

            public float getValue(DynamicIslandAnimationDelegate dynamicIslandAnimationDelegate) {
                o.g((Object)dynamicIslandAnimationDelegate, (String)"holder");
                return DynamicIslandAnimationDelegate.access$getBigIslandBlur$p(dynamicIslandAnimationDelegate);
            }

            public void setValue(DynamicIslandAnimationDelegate dynamicIslandAnimationDelegate, float f2) {
                o.g((Object)dynamicIslandAnimationDelegate, (String)"holder");
                if (Float.isNaN(f2)) {
                    return;
                }
                DynamicIslandAnimationDelegate.access$setBigIslandBlur$p(dynamicIslandAnimationDelegate, f2);
            }
        };
        EXPANDED_BLUR = new FloatProperty<DynamicIslandAnimationDelegate>(){

            public float getValue(DynamicIslandAnimationDelegate dynamicIslandAnimationDelegate) {
                o.g((Object)dynamicIslandAnimationDelegate, (String)"holder");
                return DynamicIslandAnimationDelegate.access$getExpandedBlur$p(dynamicIslandAnimationDelegate);
            }

            public void setValue(DynamicIslandAnimationDelegate dynamicIslandAnimationDelegate, float f2) {
                o.g((Object)dynamicIslandAnimationDelegate, (String)"holder");
                if (Float.isNaN(f2)) {
                    return;
                }
                DynamicIslandAnimationDelegate.access$setExpandedBlur$p(dynamicIslandAnimationDelegate, f2);
            }
        };
        FAKE_EXPANDED_BLUR = new FloatProperty<DynamicIslandAnimationDelegate>(){

            public float getValue(DynamicIslandAnimationDelegate dynamicIslandAnimationDelegate) {
                o.g((Object)dynamicIslandAnimationDelegate, (String)"holder");
                return DynamicIslandAnimationDelegate.access$getFakeExpandedBlur$p(dynamicIslandAnimationDelegate);
            }

            public void setValue(DynamicIslandAnimationDelegate dynamicIslandAnimationDelegate, float f2) {
                o.g((Object)dynamicIslandAnimationDelegate, (String)"holder");
                if (Float.isNaN(f2)) {
                    return;
                }
                DynamicIslandAnimationDelegate.access$setFakeExpandedBlur$p(dynamicIslandAnimationDelegate, f2);
            }
        };
        FAKE_EXPANDED_ALPHA = new FloatProperty<DynamicIslandAnimationDelegate>(){

            public float getValue(DynamicIslandAnimationDelegate dynamicIslandAnimationDelegate) {
                o.g((Object)dynamicIslandAnimationDelegate, (String)"holder");
                return DynamicIslandAnimationDelegate.access$getFakeExpandedAlpha$p(dynamicIslandAnimationDelegate);
            }

            public void setValue(DynamicIslandAnimationDelegate dynamicIslandAnimationDelegate, float f2) {
                o.g((Object)dynamicIslandAnimationDelegate, (String)"holder");
                if (Float.isNaN(f2)) {
                    return;
                }
                DynamicIslandAnimationDelegate.access$setFakeExpandedAlpha$p(dynamicIslandAnimationDelegate, f2);
            }
        };
        FAKE_BIG_BLUR = new FloatProperty<DynamicIslandAnimationDelegate>(){

            public float getValue(DynamicIslandAnimationDelegate dynamicIslandAnimationDelegate) {
                o.g((Object)dynamicIslandAnimationDelegate, (String)"holder");
                return DynamicIslandAnimationDelegate.access$getFakeBigBlur$p(dynamicIslandAnimationDelegate);
            }

            public void setValue(DynamicIslandAnimationDelegate dynamicIslandAnimationDelegate, float f2) {
                o.g((Object)dynamicIslandAnimationDelegate, (String)"holder");
                if (Float.isNaN(f2)) {
                    return;
                }
                DynamicIslandAnimationDelegate.access$setFakeBigBlur$p(dynamicIslandAnimationDelegate, f2);
            }
        };
        FAKE_BIG_ALPHA = new FloatProperty<DynamicIslandAnimationDelegate>(){

            public float getValue(DynamicIslandAnimationDelegate dynamicIslandAnimationDelegate) {
                o.g((Object)dynamicIslandAnimationDelegate, (String)"holder");
                return DynamicIslandAnimationDelegate.access$getFakeBigAlpha$p(dynamicIslandAnimationDelegate);
            }

            public void setValue(DynamicIslandAnimationDelegate dynamicIslandAnimationDelegate, float f2) {
                o.g((Object)dynamicIslandAnimationDelegate, (String)"holder");
                if (Float.isNaN(f2)) {
                    return;
                }
                DynamicIslandAnimationDelegate.access$setFakeBigAlpha$p(dynamicIslandAnimationDelegate, f2);
            }
        };
        FAKE_SMALL_BLUR = new FloatProperty<DynamicIslandAnimationDelegate>(){

            public float getValue(DynamicIslandAnimationDelegate dynamicIslandAnimationDelegate) {
                o.g((Object)dynamicIslandAnimationDelegate, (String)"holder");
                return DynamicIslandAnimationDelegate.access$getFakeSmallBlur$p(dynamicIslandAnimationDelegate);
            }

            public void setValue(DynamicIslandAnimationDelegate dynamicIslandAnimationDelegate, float f2) {
                o.g((Object)dynamicIslandAnimationDelegate, (String)"holder");
                if (Float.isNaN(f2)) {
                    return;
                }
                DynamicIslandAnimationDelegate.access$setFakeSmallBlur$p(dynamicIslandAnimationDelegate, f2);
            }
        };
        FAKE_SMALL_ALPHA = new FloatProperty<DynamicIslandAnimationDelegate>(){

            public float getValue(DynamicIslandAnimationDelegate dynamicIslandAnimationDelegate) {
                o.g((Object)dynamicIslandAnimationDelegate, (String)"holder");
                return DynamicIslandAnimationDelegate.access$getFakeSmallAlpha$p(dynamicIslandAnimationDelegate);
            }

            public void setValue(DynamicIslandAnimationDelegate dynamicIslandAnimationDelegate, float f2) {
                o.g((Object)dynamicIslandAnimationDelegate, (String)"holder");
                if (Float.isNaN(f2)) {
                    return;
                }
                DynamicIslandAnimationDelegate.access$setFakeSmallAlpha$p(dynamicIslandAnimationDelegate, f2);
            }
        };
        EASE_FAST_OUT_SLOW_IN = FolmeEase.bezier((float)0.4f, (float)0.0f, (float)0.2f, (float)1.0f, (long)250L);
    }

    public DynamicIslandAnimationDelegate(DynamicIslandBaseContentView dynamicIslandBaseContentView, DynamicIslandAnimationController object, SmallIslandStateHandler object2, BigIslandStateHandler bigIslandStateHandler, ExpandedStateHandler expandedStateHandler, DynamicIslandWindowView dynamicIslandWindowView, DynamicIslandAnimationDelegateHelper.Factory factory) {
        float f;
        int n;
        o.g((Object)((Object)dynamicIslandBaseContentView), (String)"view");
        o.g((Object)object, (String)"dynamicIslandAnimController");
        o.g((Object)object2, (String)"smallIslandStateHandler");
        o.g((Object)bigIslandStateHandler, (String)"bigIslandStateHandler");
        o.g((Object)expandedStateHandler, (String)"expandedStateHandler");
        o.g((Object)((Object)dynamicIslandWindowView), (String)"windowView");
        o.g((Object)factory, (String)"animationDelegateHelperFactory");
        this.view = dynamicIslandBaseContentView;
        this.dynamicIslandAnimController = object;
        this.smallIslandStateHandler = object2;
        this.bigIslandStateHandler = bigIslandStateHandler;
        this.expandedStateHandler = expandedStateHandler;
        this.windowView = dynamicIslandWindowView;
        this.animationDelegateHelperFactory = factory;
        this.$$delegate_0 = FolmeKt.FolmeObject();
        this.TAG = "DynamicIslandAnimationDelegate";
        this.animationDelegateHelper = factory.create(dynamicIslandBaseContentView, (DynamicIslandAnimationController)object, (SmallIslandStateHandler)object2, bigIslandStateHandler, expandedStateHandler, dynamicIslandWindowView);
        boolean bl = DeviceUtils.isLowEndDevice();
        boolean bl2 = false;
        bl = !bl && !DeviceUtils.isLowLevel() && !DeviceUtils.isMidLowLevel() && !DeviceUtils.isSubMidLevel() && !DeviceUtils.isNormalLevel();
        this.supportBlur = bl;
        object = CommonUtils.INSTANCE;
        bl = object.getIS_TABLET() && ((object2 = dynamicIslandBaseContentView.getCurrentIslandData()) == null || (object2 = object2.getProperties()) == null || (Integer)object2 != 0);
        this.isTableSummaryIsland = bl;
        bl = bl2;
        if (object.getIS_TABLET()) {
            object = dynamicIslandBaseContentView.getCurrentIslandData();
            bl = bl2;
            if (object != null) {
                if ((object = object.getProperties()) == null) {
                    bl = bl2;
                } else {
                    bl = bl2;
                    if ((Integer)object == 0) {
                        bl = true;
                    }
                }
            }
        }
        this.isTableMiddleIsland = bl;
        this.COLOR_EXPANDED = dynamicIslandBaseContentView.getContext().getColor(R.color.expended_island_background_color);
        this.COLOR_BIG_ISLAND = dynamicIslandBaseContentView.getContext().getColor(R.color.big_island_background_color);
        this.COLOR_BLACK = n = dynamicIslandBaseContentView.getContext().getColor(R.color.island_background_default_color);
        this.containerAlpha = 1.0f;
        this.containerBackgroundColor = n;
        this.bigIslandAlpha = 1.0f;
        this.bigIslandScale = 1.0f;
        this.smallIslandAlpha = 1.0f;
        this.smallIslandScale = 1.0f;
        this.expandedAlpha = 1.0f;
        this.expandedScaleX = 1.0f;
        this.expandedScaleY = 1.0f;
        this.fakeExpandedAlpha = 1.0f;
        this.fakeBigAlpha = 1.0f;
        this.fakeSmallAlpha = 1.0f;
        this.lastExpandHeight = dynamicIslandBaseContentView.getExpandedViewHeight();
        this.currentExpandHeight = dynamicIslandBaseContentView.getExpandedViewHeight();
        this.lastBigIslandStart = this.getBigIslandStart();
        FolmeKt.cleanWhenViewDetached((FolmeObject)this, (View)dynamicIslandBaseContentView);
        object = DynamicIslandUtils.INSTANCE;
        dynamicIslandBaseContentView = dynamicIslandBaseContentView.getContext();
        o.f((Object)((Object)dynamicIslandBaseContentView), (String)"getContext(...)");
        this.debugIslandAnimScale = f = ((DynamicIslandUtils)object).getDebugIslandAnimScale((Context)dynamicIslandBaseContentView);
        this.CHANGE_EASE = FolmeEase.spring((float)0.82f, (float)(f * 0.4f));
        dynamicIslandBaseContentView = FolmeEase.spring((float)0.95f, (float)(f * 0.35f));
        this.SHOW_EASE = dynamicIslandBaseContentView;
        this.HIDDEN_EASE = FolmeEase.spring((float)1.0f, (float)(0.2f * f));
        this.APPEAR_EASE = FolmeEase.spring((float)0.7f, (float)(0.5f * f));
        this.SCALE_EASE = FolmeEase.spring((float)1.0f, (float)(f * 1.0f));
        this.ALPHA_EASE = FolmeEase.spring((float)0.95f, (float)(f * 0.15f));
        this.FAKE_ALPHA_EASE = FolmeEase.spring((float)1.0f, (float)(f * 0.1f));
        this.PAD_CHANGE_EASE = FolmeEase.spring((float)0.86f, (float)(0.4f * f));
        this.PAD_SHOW_EASE = dynamicIslandBaseContentView;
        this.PAD_HIGHT_HIDDEN_EASE = FolmeEase.spring((float)0.95f, (float)(f * 0.15f));
        this.PAD_NORMAL_HIDDEN_EASE = FolmeEase.spring((float)1.0f, (float)(0.1f * f));
        this.PAD_BOTTOM_ISLAND_HIDDEN_EASE = FolmeEase.spring((float)0.95f, (float)(f * 0.35f));
        this.EASE_SPRING_083_042 = FolmeEase.spring((float)0.83f, (float)(0.42f * f));
        this.EASE_SPRING_095_015 = FolmeEase.spring((float)0.95f, (float)(0.15f * f));
        this.EASE_SPRING_095_035 = FolmeEase.spring((float)0.95f, (float)(f * 0.35f));
        this.EASE_SININOUT_025 = FolmeEase.sinInOut((long)250L);
    }

    public static final /* synthetic */ void access$fixTransX(DynamicIslandAnimationDelegate dynamicIslandAnimationDelegate, Collection collection, float f) {
        dynamicIslandAnimationDelegate.fixTransX(collection, f);
    }

    public static final /* synthetic */ DynamicIslandAnimationDelegateHelper access$getAnimationDelegateHelper$p(DynamicIslandAnimationDelegate dynamicIslandAnimationDelegate) {
        return dynamicIslandAnimationDelegate.animationDelegateHelper;
    }

    public static final /* synthetic */ float access$getBeginExpandedScaleX$p(DynamicIslandAnimationDelegate dynamicIslandAnimationDelegate) {
        return dynamicIslandAnimationDelegate.beginExpandedScaleX;
    }

    public static final /* synthetic */ float access$getBigIslandAlpha$p(DynamicIslandAnimationDelegate dynamicIslandAnimationDelegate) {
        return dynamicIslandAnimationDelegate.bigIslandAlpha;
    }

    public static final /* synthetic */ AnimState access$getBigIslandAnimState(DynamicIslandAnimationDelegate dynamicIslandAnimationDelegate) {
        return dynamicIslandAnimationDelegate.getBigIslandAnimState();
    }

    public static final /* synthetic */ float access$getBigIslandAreaLeft$p(DynamicIslandAnimationDelegate dynamicIslandAnimationDelegate) {
        return dynamicIslandAnimationDelegate.bigIslandAreaLeft;
    }

    public static final /* synthetic */ float access$getBigIslandAreaRight$p(DynamicIslandAnimationDelegate dynamicIslandAnimationDelegate) {
        return dynamicIslandAnimationDelegate.bigIslandAreaRight;
    }

    public static final /* synthetic */ float access$getBigIslandBlur$p(DynamicIslandAnimationDelegate dynamicIslandAnimationDelegate) {
        return dynamicIslandAnimationDelegate.bigIslandBlur;
    }

    public static final /* synthetic */ float access$getBigIslandScale$p(DynamicIslandAnimationDelegate dynamicIslandAnimationDelegate) {
        return dynamicIslandAnimationDelegate.bigIslandScale;
    }

    public static final /* synthetic */ float access$getBigIslandTransX$p(DynamicIslandAnimationDelegate dynamicIslandAnimationDelegate) {
        return dynamicIslandAnimationDelegate.bigIslandTransX;
    }

    public static final /* synthetic */ float access$getBigIslandTransY$p(DynamicIslandAnimationDelegate dynamicIslandAnimationDelegate) {
        return dynamicIslandAnimationDelegate.bigIslandTransY;
    }

    public static final /* synthetic */ float access$getBigIslandX$p(DynamicIslandAnimationDelegate dynamicIslandAnimationDelegate) {
        return dynamicIslandAnimationDelegate.bigIslandX;
    }

    public static final /* synthetic */ AnimState access$getBigIslandZoomOutAnimState(DynamicIslandAnimationDelegate dynamicIslandAnimationDelegate) {
        return dynamicIslandAnimationDelegate.getBigIslandZoomOutAnimState();
    }

    public static final /* synthetic */ float access$getContainerAlpha$p(DynamicIslandAnimationDelegate dynamicIslandAnimationDelegate) {
        return dynamicIslandAnimationDelegate.containerAlpha;
    }

    public static final /* synthetic */ float access$getContainerBlur$p(DynamicIslandAnimationDelegate dynamicIslandAnimationDelegate) {
        return dynamicIslandAnimationDelegate.containerBlur;
    }

    public static final /* synthetic */ float access$getContainerClipBottomProgress$p(DynamicIslandAnimationDelegate dynamicIslandAnimationDelegate) {
        return dynamicIslandAnimationDelegate.containerClipBottomProgress;
    }

    public static final /* synthetic */ float access$getContainerClipEndProgress$p(DynamicIslandAnimationDelegate dynamicIslandAnimationDelegate) {
        return dynamicIslandAnimationDelegate.containerClipEndProgress;
    }

    public static final /* synthetic */ float access$getContainerClipStartProgress$p(DynamicIslandAnimationDelegate dynamicIslandAnimationDelegate) {
        return dynamicIslandAnimationDelegate.containerClipStartProgress;
    }

    public static final /* synthetic */ float access$getContainerClipTopProgress$p(DynamicIslandAnimationDelegate dynamicIslandAnimationDelegate) {
        return dynamicIslandAnimationDelegate.containerClipTopProgress;
    }

    public static final /* synthetic */ float access$getContainerTransY$p(DynamicIslandAnimationDelegate dynamicIslandAnimationDelegate) {
        return dynamicIslandAnimationDelegate.containerTransY;
    }

    public static final /* synthetic */ float access$getContainerX$p(DynamicIslandAnimationDelegate dynamicIslandAnimationDelegate) {
        return dynamicIslandAnimationDelegate.containerX;
    }

    public static final /* synthetic */ DynamicIslandAnimationController access$getDynamicIslandAnimController$p(DynamicIslandAnimationDelegate dynamicIslandAnimationDelegate) {
        return dynamicIslandAnimationDelegate.dynamicIslandAnimController;
    }

    public static final /* synthetic */ float access$getExpandedAlpha$p(DynamicIslandAnimationDelegate dynamicIslandAnimationDelegate) {
        return dynamicIslandAnimationDelegate.expandedAlpha;
    }

    public static final /* synthetic */ float access$getExpandedBlur$p(DynamicIslandAnimationDelegate dynamicIslandAnimationDelegate) {
        return dynamicIslandAnimationDelegate.expandedBlur;
    }

    public static final /* synthetic */ float access$getExpandedScaleX$p(DynamicIslandAnimationDelegate dynamicIslandAnimationDelegate) {
        return dynamicIslandAnimationDelegate.expandedScaleX;
    }

    public static final /* synthetic */ float access$getExpandedScaleY$p(DynamicIslandAnimationDelegate dynamicIslandAnimationDelegate) {
        return dynamicIslandAnimationDelegate.expandedScaleY;
    }

    public static final /* synthetic */ ExpandedStateHandler access$getExpandedStateHandler$p(DynamicIslandAnimationDelegate dynamicIslandAnimationDelegate) {
        return dynamicIslandAnimationDelegate.expandedStateHandler;
    }

    public static final /* synthetic */ float access$getExpandedTransX$p(DynamicIslandAnimationDelegate dynamicIslandAnimationDelegate) {
        return dynamicIslandAnimationDelegate.expandedTransX;
    }

    public static final /* synthetic */ float access$getExpandedTransY$p(DynamicIslandAnimationDelegate dynamicIslandAnimationDelegate) {
        return dynamicIslandAnimationDelegate.expandedTransY;
    }

    public static final /* synthetic */ float access$getFakeBigAlpha$p(DynamicIslandAnimationDelegate dynamicIslandAnimationDelegate) {
        return dynamicIslandAnimationDelegate.fakeBigAlpha;
    }

    public static final /* synthetic */ float access$getFakeBigBlur$p(DynamicIslandAnimationDelegate dynamicIslandAnimationDelegate) {
        return dynamicIslandAnimationDelegate.fakeBigBlur;
    }

    public static final /* synthetic */ float access$getFakeExpandedAlpha$p(DynamicIslandAnimationDelegate dynamicIslandAnimationDelegate) {
        return dynamicIslandAnimationDelegate.fakeExpandedAlpha;
    }

    public static final /* synthetic */ float access$getFakeExpandedBlur$p(DynamicIslandAnimationDelegate dynamicIslandAnimationDelegate) {
        return dynamicIslandAnimationDelegate.fakeExpandedBlur;
    }

    public static final /* synthetic */ float access$getFakeSmallAlpha$p(DynamicIslandAnimationDelegate dynamicIslandAnimationDelegate) {
        return dynamicIslandAnimationDelegate.fakeSmallAlpha;
    }

    public static final /* synthetic */ float access$getFakeSmallBlur$p(DynamicIslandAnimationDelegate dynamicIslandAnimationDelegate) {
        return dynamicIslandAnimationDelegate.fakeSmallBlur;
    }

    public static final /* synthetic */ DynamicIslandContentFakeView access$getFakeView(DynamicIslandAnimationDelegate dynamicIslandAnimationDelegate) {
        return dynamicIslandAnimationDelegate.getFakeView();
    }

    public static final /* synthetic */ boolean access$getPanelHeightChanging(DynamicIslandAnimationDelegate dynamicIslandAnimationDelegate) {
        return dynamicIslandAnimationDelegate.getPanelHeightChanging();
    }

    public static final /* synthetic */ boolean access$getShouldBlockScale$p(DynamicIslandAnimationDelegate dynamicIslandAnimationDelegate) {
        return dynamicIslandAnimationDelegate.shouldBlockScale;
    }

    public static final /* synthetic */ float access$getSmallIslandAlpha$p(DynamicIslandAnimationDelegate dynamicIslandAnimationDelegate) {
        return dynamicIslandAnimationDelegate.smallIslandAlpha;
    }

    public static final /* synthetic */ float access$getSmallIslandBlur$p(DynamicIslandAnimationDelegate dynamicIslandAnimationDelegate) {
        return dynamicIslandAnimationDelegate.smallIslandBlur;
    }

    public static final /* synthetic */ float access$getSmallIslandScale$p(DynamicIslandAnimationDelegate dynamicIslandAnimationDelegate) {
        return dynamicIslandAnimationDelegate.smallIslandScale;
    }

    public static final /* synthetic */ float access$getSmallIslandTransX$p(DynamicIslandAnimationDelegate dynamicIslandAnimationDelegate) {
        return dynamicIslandAnimationDelegate.smallIslandTransX;
    }

    public static final /* synthetic */ float access$getSmallIslandTransY$p(DynamicIslandAnimationDelegate dynamicIslandAnimationDelegate) {
        return dynamicIslandAnimationDelegate.smallIslandTransY;
    }

    public static final /* synthetic */ String access$getTAG$p(DynamicIslandAnimationDelegate dynamicIslandAnimationDelegate) {
        return dynamicIslandAnimationDelegate.TAG;
    }

    public static final /* synthetic */ DynamicIslandBaseContentView access$getView$p(DynamicIslandAnimationDelegate dynamicIslandAnimationDelegate) {
        return dynamicIslandAnimationDelegate.view;
    }

    public static final /* synthetic */ DynamicIslandWindowView access$getWindowView$p(DynamicIslandAnimationDelegate dynamicIslandAnimationDelegate) {
        return dynamicIslandAnimationDelegate.windowView;
    }

    public static final /* synthetic */ boolean access$isMoveDownAnimating$p(DynamicIslandAnimationDelegate dynamicIslandAnimationDelegate) {
        return dynamicIslandAnimationDelegate.isMoveDownAnimating;
    }

    public static final /* synthetic */ void access$setAnimateExpanding(DynamicIslandAnimationDelegate dynamicIslandAnimationDelegate, boolean bl) {
        dynamicIslandAnimationDelegate.setAnimateExpanding(bl);
    }

    public static final /* synthetic */ void access$setBeginExpandedScaleX$p(DynamicIslandAnimationDelegate dynamicIslandAnimationDelegate, float f) {
        dynamicIslandAnimationDelegate.beginExpandedScaleX = f;
    }

    public static final /* synthetic */ void access$setBigIslandAlpha$p(DynamicIslandAnimationDelegate dynamicIslandAnimationDelegate, float f) {
        dynamicIslandAnimationDelegate.bigIslandAlpha = f;
    }

    public static final /* synthetic */ void access$setBigIslandAreaLeft$p(DynamicIslandAnimationDelegate dynamicIslandAnimationDelegate, float f) {
        dynamicIslandAnimationDelegate.bigIslandAreaLeft = f;
    }

    public static final /* synthetic */ void access$setBigIslandAreaRight$p(DynamicIslandAnimationDelegate dynamicIslandAnimationDelegate, float f) {
        dynamicIslandAnimationDelegate.bigIslandAreaRight = f;
    }

    public static final /* synthetic */ void access$setBigIslandBlur$p(DynamicIslandAnimationDelegate dynamicIslandAnimationDelegate, float f) {
        dynamicIslandAnimationDelegate.bigIslandBlur = f;
    }

    public static final /* synthetic */ void access$setBigIslandScale$p(DynamicIslandAnimationDelegate dynamicIslandAnimationDelegate, float f) {
        dynamicIslandAnimationDelegate.bigIslandScale = f;
    }

    public static final /* synthetic */ void access$setBigIslandTransX$p(DynamicIslandAnimationDelegate dynamicIslandAnimationDelegate, float f) {
        dynamicIslandAnimationDelegate.bigIslandTransX = f;
    }

    public static final /* synthetic */ void access$setBigIslandTransY$p(DynamicIslandAnimationDelegate dynamicIslandAnimationDelegate, float f) {
        dynamicIslandAnimationDelegate.bigIslandTransY = f;
    }

    public static final /* synthetic */ void access$setBigIslandX$p(DynamicIslandAnimationDelegate dynamicIslandAnimationDelegate, float f) {
        dynamicIslandAnimationDelegate.bigIslandX = f;
    }

    public static final /* synthetic */ void access$setBlockUpdatePosition$p(DynamicIslandAnimationDelegate dynamicIslandAnimationDelegate, boolean bl) {
        dynamicIslandAnimationDelegate.isBlockUpdatePosition = bl;
    }

    public static final /* synthetic */ void access$setContainerAlpha$p(DynamicIslandAnimationDelegate dynamicIslandAnimationDelegate, float f) {
        dynamicIslandAnimationDelegate.containerAlpha = f;
    }

    public static final /* synthetic */ void access$setContainerBackgroundColor$p(DynamicIslandAnimationDelegate dynamicIslandAnimationDelegate, int n) {
        dynamicIslandAnimationDelegate.containerBackgroundColor = n;
    }

    public static final /* synthetic */ void access$setContainerBlur$p(DynamicIslandAnimationDelegate dynamicIslandAnimationDelegate, float f) {
        dynamicIslandAnimationDelegate.containerBlur = f;
    }

    public static final /* synthetic */ void access$setContainerClipBottomProgress$p(DynamicIslandAnimationDelegate dynamicIslandAnimationDelegate, float f) {
        dynamicIslandAnimationDelegate.containerClipBottomProgress = f;
    }

    public static final /* synthetic */ void access$setContainerClipEndProgress$p(DynamicIslandAnimationDelegate dynamicIslandAnimationDelegate, float f) {
        dynamicIslandAnimationDelegate.containerClipEndProgress = f;
    }

    public static final /* synthetic */ void access$setContainerClipStartProgress$p(DynamicIslandAnimationDelegate dynamicIslandAnimationDelegate, float f) {
        dynamicIslandAnimationDelegate.containerClipStartProgress = f;
    }

    public static final /* synthetic */ void access$setContainerClipTopProgress$p(DynamicIslandAnimationDelegate dynamicIslandAnimationDelegate, float f) {
        dynamicIslandAnimationDelegate.containerClipTopProgress = f;
    }

    public static final /* synthetic */ void access$setContainerTransY$p(DynamicIslandAnimationDelegate dynamicIslandAnimationDelegate, float f) {
        dynamicIslandAnimationDelegate.containerTransY = f;
    }

    public static final /* synthetic */ void access$setContainerX$p(DynamicIslandAnimationDelegate dynamicIslandAnimationDelegate, float f) {
        dynamicIslandAnimationDelegate.containerX = f;
    }

    public static final /* synthetic */ void access$setExpandedAlpha$p(DynamicIslandAnimationDelegate dynamicIslandAnimationDelegate, float f) {
        dynamicIslandAnimationDelegate.expandedAlpha = f;
    }

    public static final /* synthetic */ void access$setExpandedBlur$p(DynamicIslandAnimationDelegate dynamicIslandAnimationDelegate, float f) {
        dynamicIslandAnimationDelegate.expandedBlur = f;
    }

    public static final /* synthetic */ void access$setExpandedScaleX$p(DynamicIslandAnimationDelegate dynamicIslandAnimationDelegate, float f) {
        dynamicIslandAnimationDelegate.expandedScaleX = f;
    }

    public static final /* synthetic */ void access$setExpandedScaleY$p(DynamicIslandAnimationDelegate dynamicIslandAnimationDelegate, float f) {
        dynamicIslandAnimationDelegate.expandedScaleY = f;
    }

    public static final /* synthetic */ void access$setExpandedTransX$p(DynamicIslandAnimationDelegate dynamicIslandAnimationDelegate, float f) {
        dynamicIslandAnimationDelegate.expandedTransX = f;
    }

    public static final /* synthetic */ void access$setExpandedTransY$p(DynamicIslandAnimationDelegate dynamicIslandAnimationDelegate, float f) {
        dynamicIslandAnimationDelegate.expandedTransY = f;
    }

    public static final /* synthetic */ void access$setFakeBigAlpha$p(DynamicIslandAnimationDelegate dynamicIslandAnimationDelegate, float f) {
        dynamicIslandAnimationDelegate.fakeBigAlpha = f;
    }

    public static final /* synthetic */ void access$setFakeBigBlur$p(DynamicIslandAnimationDelegate dynamicIslandAnimationDelegate, float f) {
        dynamicIslandAnimationDelegate.fakeBigBlur = f;
    }

    public static final /* synthetic */ void access$setFakeExpandedAlpha$p(DynamicIslandAnimationDelegate dynamicIslandAnimationDelegate, float f) {
        dynamicIslandAnimationDelegate.fakeExpandedAlpha = f;
    }

    public static final /* synthetic */ void access$setFakeExpandedBlur$p(DynamicIslandAnimationDelegate dynamicIslandAnimationDelegate, float f) {
        dynamicIslandAnimationDelegate.fakeExpandedBlur = f;
    }

    public static final /* synthetic */ void access$setFakeSmallAlpha$p(DynamicIslandAnimationDelegate dynamicIslandAnimationDelegate, float f) {
        dynamicIslandAnimationDelegate.fakeSmallAlpha = f;
    }

    public static final /* synthetic */ void access$setFakeSmallBlur$p(DynamicIslandAnimationDelegate dynamicIslandAnimationDelegate, float f) {
        dynamicIslandAnimationDelegate.fakeSmallBlur = f;
    }

    public static final /* synthetic */ void access$setFakeViewAnimating$p(DynamicIslandAnimationDelegate dynamicIslandAnimationDelegate, boolean bl) {
        dynamicIslandAnimationDelegate.fakeViewAnimating = bl;
    }

    public static final /* synthetic */ void access$setMoveDownAnimating$p(DynamicIslandAnimationDelegate dynamicIslandAnimationDelegate, boolean bl) {
        dynamicIslandAnimationDelegate.isMoveDownAnimating = bl;
    }

    public static final /* synthetic */ void access$setMoveUpAnimating$p(DynamicIslandAnimationDelegate dynamicIslandAnimationDelegate, boolean bl) {
        dynamicIslandAnimationDelegate.isMoveUpAnimating = bl;
    }

    public static final /* synthetic */ void access$setShouldBlockScale$p(DynamicIslandAnimationDelegate dynamicIslandAnimationDelegate, boolean bl) {
        dynamicIslandAnimationDelegate.shouldBlockScale = bl;
    }

    public static final /* synthetic */ void access$setSmallIslandAlpha$p(DynamicIslandAnimationDelegate dynamicIslandAnimationDelegate, float f) {
        dynamicIslandAnimationDelegate.smallIslandAlpha = f;
    }

    public static final /* synthetic */ void access$setSmallIslandBlur$p(DynamicIslandAnimationDelegate dynamicIslandAnimationDelegate, float f) {
        dynamicIslandAnimationDelegate.smallIslandBlur = f;
    }

    public static final /* synthetic */ void access$setSmallIslandScale$p(DynamicIslandAnimationDelegate dynamicIslandAnimationDelegate, float f) {
        dynamicIslandAnimationDelegate.smallIslandScale = f;
    }

    public static final /* synthetic */ void access$setSmallIslandTransX$p(DynamicIslandAnimationDelegate dynamicIslandAnimationDelegate, float f) {
        dynamicIslandAnimationDelegate.smallIslandTransX = f;
    }

    public static final /* synthetic */ void access$setSmallIslandTransY$p(DynamicIslandAnimationDelegate dynamicIslandAnimationDelegate, float f) {
        dynamicIslandAnimationDelegate.smallIslandTransY = f;
    }

    public static final /* synthetic */ void access$setViewVisible(DynamicIslandAnimationDelegate dynamicIslandAnimationDelegate, DynamicIslandBaseContentView dynamicIslandBaseContentView, int n) {
        dynamicIslandAnimationDelegate.setViewVisible(dynamicIslandBaseContentView, n);
    }

    private final void animToFakeBigIslandView(DynamicIslandContentView dynamicIslandContentView) {
        AnimState animState;
        Log.d((String)"DynamicIslandAnimDebug", (String)"animToFakeBigIslandView");
        DynamicIslandState dynamicIslandState = dynamicIslandContentView.getLastState();
        if (dynamicIslandState instanceof DynamicIslandState.SmallIsland) {
            dynamicIslandState = new AnimState();
            animState = FAKE_SMALL_BLUR;
            dynamicIslandState = dynamicIslandState.add((FloatProperty)animState, 0.0f, new long[0]);
            FloatProperty<DynamicIslandAnimationDelegate> floatProperty = FAKE_SMALL_ALPHA;
            dynamicIslandState = dynamicIslandState.add(floatProperty, 1.0f, new long[0]);
            FloatProperty<DynamicIslandAnimationDelegate> floatProperty2 = FAKE_BIG_BLUR;
            dynamicIslandState = dynamicIslandState.add(floatProperty2, 1.0f, new long[0]);
            FloatProperty<DynamicIslandAnimationDelegate> floatProperty3 = FAKE_BIG_ALPHA;
            dynamicIslandState = dynamicIslandState.add(floatProperty3, 0.0f, new long[0]);
            FloatProperty<DynamicIslandAnimationDelegate> floatProperty4 = FAKE_EXPANDED_BLUR;
            dynamicIslandState = dynamicIslandState.add(floatProperty4, 0.0f, new long[0]);
            FloatProperty<DynamicIslandAnimationDelegate> floatProperty5 = FAKE_EXPANDED_ALPHA;
            dynamicIslandState = dynamicIslandState.add(floatProperty5, 0.0f, new long[0]);
            animState = new AnimState().add(animState, 1.0f, new long[0]).add(floatProperty, 0.0f, new long[0]).add(floatProperty2, 0.0f, new long[0]).add(floatProperty3, 1.0f, new long[0]).add(floatProperty4, 0.0f, new long[0]).add(floatProperty5, 0.0f, new long[0]);
        } else if (dynamicIslandState instanceof DynamicIslandState.Expanded) {
            dynamicIslandState = new AnimState();
            animState = FAKE_EXPANDED_BLUR;
            dynamicIslandState = dynamicIslandState.add((FloatProperty)animState, 0.0f, new long[0]);
            FloatProperty<DynamicIslandAnimationDelegate> floatProperty = FAKE_EXPANDED_ALPHA;
            dynamicIslandState = dynamicIslandState.add(floatProperty, 1.0f, new long[0]);
            FloatProperty<DynamicIslandAnimationDelegate> floatProperty6 = FAKE_BIG_BLUR;
            dynamicIslandState = dynamicIslandState.add(floatProperty6, 1.0f, new long[0]);
            FloatProperty<DynamicIslandAnimationDelegate> floatProperty7 = FAKE_BIG_ALPHA;
            dynamicIslandState = dynamicIslandState.add(floatProperty7, 0.0f, new long[0]);
            FloatProperty<DynamicIslandAnimationDelegate> floatProperty8 = FAKE_SMALL_BLUR;
            dynamicIslandState = dynamicIslandState.add(floatProperty8, 0.0f, new long[0]);
            FloatProperty<DynamicIslandAnimationDelegate> floatProperty9 = FAKE_SMALL_ALPHA;
            dynamicIslandState = dynamicIslandState.add(floatProperty9, 0.0f, new long[0]);
            animState = new AnimState().add(animState, 1.0f, new long[0]).add(floatProperty, 0.0f, new long[0]).add(floatProperty6, 0.0f, new long[0]).add(floatProperty7, 1.0f, new long[0]).add(floatProperty8, 0.0f, new long[0]).add(floatProperty9, 0.0f, new long[0]);
        } else {
            dynamicIslandState = null;
            animState = null;
        }
        if (dynamicIslandState != null && animState != null) {
            this.fakeViewAnimating = true;
            FolmeKt.getFolme((FolmeObject)this).setTo((Object)dynamicIslandState).to(animState, new AnimConfig[]{new AnimConfig().setSpecial(FAKE_SMALL_ALPHA, this.FAKE_ALPHA_EASE, new float[0]).setSpecial(FAKE_EXPANDED_ALPHA, this.FAKE_ALPHA_EASE, new float[0]).setSpecial(FAKE_BIG_ALPHA, null, 50L, new float[0]).addListeners(new TransitionListener[]{new TransitionListener(dynamicIslandContentView, this){
                final DynamicIslandContentView $view;
                final DynamicIslandAnimationDelegate this$0;
                {
                    this.$view = dynamicIslandContentView;
                    this.this$0 = dynamicIslandAnimationDelegate;
                }

                public void onBegin(Object object) {
                    super.onBegin(object);
                    object = this.$view.getFakeView();
                    Object var2_2 = null;
                    object = object != null ? ((DynamicIslandBaseContentView)((Object)object)).getFakeBigIsland() : null;
                    if (object != null) {
                        object.setAlpha(0.0f);
                    }
                    DynamicIslandContentFakeView dynamicIslandContentFakeView = this.$view.getFakeView();
                    object = var2_2;
                    if (dynamicIslandContentFakeView != null) {
                        object = dynamicIslandContentFakeView.getFakeBigIsland();
                    }
                    if (object != null) {
                        object.setVisibility(0);
                    }
                }

                public void onComplete(Object object) {
                    super.onComplete(object);
                    DynamicIslandAnimationDelegate.access$setFakeViewAnimating$p(this.this$0, false);
                    object = this.$view.getFakeView();
                    Object var2_2 = null;
                    object = object != null ? ((DynamicIslandBaseContentView)((Object)object)).getFakeSmallIsland() : null;
                    if (object != null) {
                        object.setVisibility(4);
                    }
                    DynamicIslandContentFakeView dynamicIslandContentFakeView = this.$view.getFakeView();
                    object = var2_2;
                    if (dynamicIslandContentFakeView != null) {
                        object = dynamicIslandContentFakeView.getFakeExpandedView();
                    }
                    if (object != null) {
                        object.setVisibility(4);
                    }
                }

                public void onUpdate(Object object, Collection<UpdateInfo> collection) {
                    super.onUpdate(object, collection);
                    this.this$0.scheduleUpdate();
                }
            }})});
        }
    }

    private final void animToFakeExpandedView(DynamicIslandContentView dynamicIslandContentView) {
        Context context;
        Object object;
        Object object2;
        Log.d((String)"DynamicIslandAnimDebug", (String)"animToFakeExpandedView");
        if (this.islandAppAnimRunning && (object2 = dynamicIslandContentView.getFakeView()) != null && (object2 = ((DynamicIslandBaseContentView)((Object)object2)).getMiniBar()) != null) {
            float f;
            int n = dynamicIslandContentView.getExpandedViewWidth();
            object = DynamicIslandUtils.INSTANCE;
            context = dynamicIslandContentView.getContext();
            o.f((Object)context, (String)"getContext(...)");
            float f2 = ((DynamicIslandUtils)object).getScreenWidthOld(context);
            float f3 = f = (float)n;
            if (f == 0.0f) {
                context = dynamicIslandContentView.getContext();
                o.f((Object)context, (String)"getContext(...)");
                f3 = ((DynamicIslandUtils)object).getScreenWidthOld(context);
            }
            f = (float)object2.getHeight() * ((f2 /= f3) - 1.0f) / (float)2;
            f3 = object2.getTranslationY();
            object = new StringBuilder();
            ((StringBuilder)object).append("animToFakeExpandedView, fraction=");
            ((StringBuilder)object).append(f2);
            ((StringBuilder)object).append(", init transY=");
            ((StringBuilder)object).append(f3);
            ((StringBuilder)object).append(", deltaTransY=");
            ((StringBuilder)object).append(f);
            Log.d((String)"DynamicIslandAnimDebug", (String)((StringBuilder)object).toString());
            object2.setTranslationY(object2.getTranslationY() * f2 - (float)dynamicIslandContentView.getIslandViewMarginTop() + f);
        }
        if ((object2 = dynamicIslandContentView.getLastState()) instanceof DynamicIslandState.SmallIsland) {
            object2 = new AnimState();
            object = FAKE_SMALL_BLUR;
            object2 = object2.add(object, 0.0f, new long[0]);
            context = FAKE_SMALL_ALPHA;
            object2 = object2.add(context, 1.0f, new long[0]);
            FloatProperty<DynamicIslandAnimationDelegate> floatProperty = FAKE_EXPANDED_BLUR;
            object2 = object2.add(floatProperty, 1.0f, new long[0]);
            FloatProperty<DynamicIslandAnimationDelegate> floatProperty2 = FAKE_EXPANDED_ALPHA;
            object2 = object2.add(floatProperty2, 0.0f, new long[0]);
            FloatProperty<DynamicIslandAnimationDelegate> floatProperty3 = FAKE_BIG_BLUR;
            object2 = object2.add(floatProperty3, 0.0f, new long[0]);
            FloatProperty<DynamicIslandAnimationDelegate> floatProperty4 = FAKE_BIG_ALPHA;
            object2 = object2.add(floatProperty4, 0.0f, new long[0]);
            object = new AnimState().add((FloatProperty)object, 1.0f, new long[0]).add((FloatProperty)context, 0.0f, new long[0]).add(floatProperty, 0.0f, new long[0]).add(floatProperty2, 1.0f, new long[0]).add(floatProperty3, 0.0f, new long[0]).add(floatProperty4, 0.0f, new long[0]);
        } else if (object2 instanceof DynamicIslandState.BigIsland) {
            object2 = new AnimState();
            object = FAKE_EXPANDED_BLUR;
            object2 = object2.add(object, 1.0f, new long[0]);
            context = FAKE_EXPANDED_ALPHA;
            object2 = object2.add(context, 0.0f, new long[0]);
            FloatProperty<DynamicIslandAnimationDelegate> floatProperty = FAKE_BIG_BLUR;
            object2 = object2.add(floatProperty, 0.0f, new long[0]);
            FloatProperty<DynamicIslandAnimationDelegate> floatProperty5 = FAKE_BIG_ALPHA;
            object2 = object2.add(floatProperty5, 1.0f, new long[0]);
            FloatProperty<DynamicIslandAnimationDelegate> floatProperty6 = FAKE_SMALL_BLUR;
            object2 = object2.add(floatProperty6, 0.0f, new long[0]);
            FloatProperty<DynamicIslandAnimationDelegate> floatProperty7 = FAKE_SMALL_ALPHA;
            object2 = object2.add(floatProperty7, 0.0f, new long[0]);
            object = new AnimState().add((FloatProperty)object, 0.0f, new long[0]).add((FloatProperty)context, 1.0f, new long[0]).add(floatProperty, 1.0f, new long[0]).add(floatProperty5, 0.0f, new long[0]).add(floatProperty6, 0.0f, new long[0]).add(floatProperty7, 0.0f, new long[0]);
        } else {
            object2 = null;
            object = null;
        }
        if (object2 != null && object != null) {
            this.fakeViewAnimating = true;
            FolmeKt.getFolme((FolmeObject)this).setTo(object2).to(object, new AnimConfig[]{new AnimConfig().setSpecial(FAKE_SMALL_ALPHA, this.FAKE_ALPHA_EASE, new float[0]).setSpecial(FAKE_BIG_ALPHA, this.FAKE_ALPHA_EASE, new float[0]).setSpecial(FAKE_EXPANDED_ALPHA, null, 50L, new float[0]).addListeners(new TransitionListener[]{new TransitionListener(dynamicIslandContentView, this){
                final DynamicIslandContentView $view;
                final DynamicIslandAnimationDelegate this$0;
                {
                    this.$view = dynamicIslandContentView;
                    this.this$0 = dynamicIslandAnimationDelegate;
                }

                public void onBegin(Object object) {
                    super.onBegin(object);
                    object = this.$view.getFakeView();
                    Object var2_2 = null;
                    object = object != null ? ((DynamicIslandBaseContentView)((Object)object)).getFakeExpandedView() : null;
                    if (object != null) {
                        object.setAlpha(0.0f);
                    }
                    DynamicIslandContentFakeView dynamicIslandContentFakeView = this.$view.getFakeView();
                    object = var2_2;
                    if (dynamicIslandContentFakeView != null) {
                        object = dynamicIslandContentFakeView.getFakeExpandedView();
                    }
                    if (object != null) {
                        object.setVisibility(0);
                    }
                }

                public void onComplete(Object object) {
                    super.onComplete(object);
                    DynamicIslandAnimationDelegate.access$setFakeViewAnimating$p(this.this$0, false);
                    object = this.$view.getFakeView();
                    Object var2_2 = null;
                    object = object != null ? ((DynamicIslandBaseContentView)((Object)object)).getFakeBigIsland() : null;
                    if (object != null) {
                        object.setVisibility(4);
                    }
                    DynamicIslandContentFakeView dynamicIslandContentFakeView = this.$view.getFakeView();
                    object = var2_2;
                    if (dynamicIslandContentFakeView != null) {
                        object = dynamicIslandContentFakeView.getFakeSmallIsland();
                    }
                    if (object != null) {
                        object.setVisibility(4);
                    }
                }

                public void onUpdate(Object object, Collection<UpdateInfo> collection) {
                    super.onUpdate(object, collection);
                    this.this$0.scheduleUpdate();
                }
            }})});
        }
    }

    private final void animToFakeSmallIslandView(DynamicIslandContentView dynamicIslandContentView) {
        AnimState animState;
        Log.d((String)"DynamicIslandAnimDebug", (String)"animToFakeSmallIslandView");
        DynamicIslandState dynamicIslandState = dynamicIslandContentView.getLastState();
        if (dynamicIslandState instanceof DynamicIslandState.BigIsland) {
            dynamicIslandState = new AnimState();
            animState = FAKE_BIG_BLUR;
            dynamicIslandState = dynamicIslandState.add((FloatProperty)animState, 0.0f, new long[0]);
            FloatProperty<DynamicIslandAnimationDelegate> floatProperty = FAKE_BIG_ALPHA;
            dynamicIslandState = dynamicIslandState.add(floatProperty, 1.0f, new long[0]);
            FloatProperty<DynamicIslandAnimationDelegate> floatProperty2 = FAKE_SMALL_BLUR;
            dynamicIslandState = dynamicIslandState.add(floatProperty2, 1.0f, new long[0]);
            FloatProperty<DynamicIslandAnimationDelegate> floatProperty3 = FAKE_SMALL_ALPHA;
            dynamicIslandState = dynamicIslandState.add(floatProperty3, 0.0f, new long[0]);
            FloatProperty<DynamicIslandAnimationDelegate> floatProperty4 = FAKE_EXPANDED_BLUR;
            dynamicIslandState = dynamicIslandState.add(floatProperty4, 0.0f, new long[0]);
            FloatProperty<DynamicIslandAnimationDelegate> floatProperty5 = FAKE_EXPANDED_ALPHA;
            dynamicIslandState = dynamicIslandState.add(floatProperty5, 0.0f, new long[0]);
            animState = new AnimState().add(animState, 1.0f, new long[0]).add(floatProperty, 0.0f, new long[0]).add(floatProperty2, 0.0f, new long[0]).add(floatProperty3, 1.0f, new long[0]).add(floatProperty4, 0.0f, new long[0]).add(floatProperty5, 0.0f, new long[0]);
        } else if (dynamicIslandState instanceof DynamicIslandState.Expanded) {
            dynamicIslandState = new AnimState();
            animState = FAKE_SMALL_BLUR;
            dynamicIslandState = dynamicIslandState.add((FloatProperty)animState, 1.0f, new long[0]);
            FloatProperty<DynamicIslandAnimationDelegate> floatProperty = FAKE_SMALL_ALPHA;
            dynamicIslandState = dynamicIslandState.add(floatProperty, 0.0f, new long[0]);
            FloatProperty<DynamicIslandAnimationDelegate> floatProperty6 = FAKE_EXPANDED_BLUR;
            dynamicIslandState = dynamicIslandState.add(floatProperty6, 0.0f, new long[0]);
            FloatProperty<DynamicIslandAnimationDelegate> floatProperty7 = FAKE_EXPANDED_ALPHA;
            dynamicIslandState = dynamicIslandState.add(floatProperty7, 1.0f, new long[0]);
            FloatProperty<DynamicIslandAnimationDelegate> floatProperty8 = FAKE_BIG_BLUR;
            dynamicIslandState = dynamicIslandState.add(floatProperty8, 0.0f, new long[0]);
            FloatProperty<DynamicIslandAnimationDelegate> floatProperty9 = FAKE_BIG_ALPHA;
            dynamicIslandState = dynamicIslandState.add(floatProperty9, 0.0f, new long[0]);
            animState = new AnimState().add(animState, 0.0f, new long[0]).add(floatProperty, 1.0f, new long[0]).add(floatProperty6, 1.0f, new long[0]).add(floatProperty7, 0.0f, new long[0]).add(floatProperty8, 0.0f, new long[0]).add(floatProperty9, 0.0f, new long[0]);
        } else {
            dynamicIslandState = null;
            animState = null;
        }
        if (dynamicIslandState != null && animState != null) {
            this.fakeViewAnimating = true;
            FolmeKt.getFolme((FolmeObject)this).setTo((Object)dynamicIslandState).to(animState, new AnimConfig[]{new AnimConfig().setSpecial(FAKE_EXPANDED_ALPHA, this.FAKE_ALPHA_EASE, new float[0]).setSpecial(FAKE_BIG_ALPHA, this.FAKE_ALPHA_EASE, new float[0]).setSpecial(FAKE_SMALL_ALPHA, null, 50L, new float[0]).addListeners(new TransitionListener[]{new TransitionListener(dynamicIslandContentView, this){
                final DynamicIslandContentView $view;
                final DynamicIslandAnimationDelegate this$0;
                {
                    this.$view = dynamicIslandContentView;
                    this.this$0 = dynamicIslandAnimationDelegate;
                }

                public void onBegin(Object object) {
                    super.onBegin(object);
                    object = this.$view.getFakeView();
                    Object var2_2 = null;
                    object = object != null ? ((DynamicIslandBaseContentView)((Object)object)).getFakeSmallIsland() : null;
                    if (object != null) {
                        object.setAlpha(0.0f);
                    }
                    DynamicIslandContentFakeView dynamicIslandContentFakeView = this.$view.getFakeView();
                    object = var2_2;
                    if (dynamicIslandContentFakeView != null) {
                        object = dynamicIslandContentFakeView.getFakeSmallIsland();
                    }
                    if (object != null) {
                        object.setVisibility(0);
                    }
                }

                public void onComplete(Object object) {
                    super.onComplete(object);
                    DynamicIslandAnimationDelegate.access$setFakeViewAnimating$p(this.this$0, false);
                    object = this.$view.getFakeView();
                    Object var2_2 = null;
                    object = object != null ? ((DynamicIslandBaseContentView)((Object)object)).getFakeBigIsland() : null;
                    if (object != null) {
                        object.setVisibility(4);
                    }
                    DynamicIslandContentFakeView dynamicIslandContentFakeView = this.$view.getFakeView();
                    object = var2_2;
                    if (dynamicIslandContentFakeView != null) {
                        object = dynamicIslandContentFakeView.getFakeExpandedView();
                    }
                    if (object != null) {
                        object.setVisibility(4);
                    }
                }

                public void onUpdate(Object object, Collection<UpdateInfo> collection) {
                    super.onUpdate(object, collection);
                    this.this$0.scheduleUpdate();
                }
            }})});
        }
    }

    private final float calculateSwipeAlpha(float f) {
        float f2;
        f = f2 = f * -0.8f / 0.14f + 1.0f;
        if (f2 < 0.2f) {
            f = 0.2f;
        }
        return f;
    }

    public static /* synthetic */ void expandedToTempHiddenAnimation$default(DynamicIslandAnimationDelegate dynamicIslandAnimationDelegate, DynamicIslandContentView dynamicIslandContentView, boolean bl, int n, Object object) {
        if ((n & 2) != 0) {
            bl = false;
        }
        dynamicIslandAnimationDelegate.expandedToTempHiddenAnimation(dynamicIslandContentView, bl);
    }

    private final void fixTransX(Collection<UpdateInfo> updateInfo, float f) {
        float f2;
        if (CommonUtils.INSTANCE.getIS_TABLET() && updateInfo != null && this.shouldUpdateTransX(f, f2 = this.getExpandedShouldTransX())) {
            UpdateInfo updateInfo2 = UpdateInfo.findBy(updateInfo, BIG_ISLAND_TRANS_X);
            if (updateInfo2 == null) {
                return;
            }
            UpdateInfo updateInfo3 = UpdateInfo.findBy(updateInfo, EXPANDED_TRANS_X);
            UpdateInfo updateInfo4 = UpdateInfo.findBy(updateInfo, CONTAINER_CLIP_START_PROGRESS);
            updateInfo = UpdateInfo.findBy(updateInfo, CONTAINER_CLIP_END_PROGRESS);
            f = updateInfo2.getFloatValue() / f * (f2 - f);
            FloatProperty floatProperty = updateInfo2.property;
            if (floatProperty != null) {
                floatProperty.set((Object)this, Float.valueOf(updateInfo2.getFloatValue() + f));
            }
            if (updateInfo3 != null && (updateInfo2 = updateInfo3.property) != null) {
                updateInfo2.set((Object)this, Float.valueOf(updateInfo3.getFloatValue() + f));
            }
            if (updateInfo4 != null && (updateInfo3 = updateInfo4.property) != null) {
                updateInfo3.set((Object)this, Float.valueOf(updateInfo4.getFloatValue() + f));
            }
            if (updateInfo != null && (updateInfo4 = updateInfo.property) != null) {
                updateInfo4.set((Object)this, Float.valueOf(f + updateInfo.getFloatValue()));
            }
        }
    }

    private final int getAppAnimSmallX() {
        int n = this.windowView.getWindowViewController().getAppAnimSmallX();
        if (this.bigIslandStateHandler.getCurrent() == null && n != 0) {
            DynamicIslandUtils dynamicIslandUtils = DynamicIslandUtils.INSTANCE;
            Context context = this.view.getContext();
            o.f((Object)context, (String)"getContext(...)");
            return n - dynamicIslandUtils.getScreenWidthOld(context) / 2 + this.view.getSmallIslandViewWidth() / 2;
        }
        return 0;
    }

    private final AnimState getBigIslandAnimState() {
        DynamicIslandBackgroundView dynamicIslandBackgroundView = this.view.getBackgroundView();
        if (dynamicIslandBackgroundView != null) {
            dynamicIslandBackgroundView.setZ(3.0f);
        }
        dynamicIslandBackgroundView = new AnimState().add(CONTAINER_X, 0.0f, new long[0]).add(CONTAINER_TRANS_Y, 0.0f, new long[0]).add(CONTAINER_BLUR, 0.0f, new long[0]).add(CONTAINER_ALPHA, 1.0f, new long[0]).add(CONTAINER_CLIP_START_PROGRESS, this.getBigIslandStart(), new long[0]).add(CONTAINER_CLIP_END_PROGRESS, this.getBigIslandEnd(), new long[0]).add(CONTAINER_CLIP_TOP_PROGRESS, this.getBigIslandTop(), new long[0]).add(CONTAINER_CLIP_BOTTOM_PROGRESS, this.getBigIslandBottom(), new long[0]).add(SMALL_ISLAND_ALPHA, 0.0f, new long[0]).add(SMALL_ISLAND_SCALE, 1.0f, new long[0]).add(SMALL_ISLAND_BLUR, 0.0f, new long[0]).add(SMALL_ISLAND_TRANS_X, this.getSmallTransXToBig(), new long[0]).add(SMALL_ISLAND_TRANS_Y, 0.0f, new long[0]).add(BIG_ISLAND_ALPHA, 1.0f, new long[0]).add(BIG_ISLAND_SCALE, 1.0f, new long[0]).add(BIG_ISLAND_BLUR, 0.0f, new long[0]).add(BIG_ISLAND_TRANS_Y, 0.0f, new long[0]).add(BIG_ISLAND_AREA_LEFT_TRANS_X, 0.0f, new long[0]).add(BIG_ISLAND_AREA_RIGHT_TRANS_X, 0.0f, new long[0]).add(EXPANDED_ALPHA, 0.0f, new long[0]).add(EXPANDED_SCALE_X, (float)this.view.getBigIslandViewWidth() / (float)this.view.getExpandedViewWidth(), new long[0]).add(EXPANDED_SCALE_Y, (float)this.view.getBigIslandViewWidth() / (float)this.view.getExpandedViewWidth(), new long[0]).add(EXPANDED_BLUR, 1.0f, new long[0]).add(EXPANDED_TRANS_Y, -this.getExpandedTransYToBig(), new long[0]);
        if (CommonUtils.INSTANCE.getIS_TABLET()) {
            dynamicIslandBackgroundView.add(EXPANDED_TRANS_X, this.getExpandedShouldTransX(), new long[0]);
            dynamicIslandBackgroundView.add(BIG_ISLAND_TRANS_X, this.getExpandedShouldTransX(), new long[0]);
            Context context = this.view.getContext();
            o.f((Object)context, (String)"getContext(...)");
            if (!MiBlurCompat.getBackgroundBlurOpened((Context)context) && (context = this.view.getCurrentIslandData()) != null && DynamicIslandUtils.INSTANCE.isDynamicIslandPadNoPropOnce((DynamicIslandData)context)) {
                if (this.isDiffContainerBackgroundColor(this.COLOR_BIG_ISLAND)) {
                    dynamicIslandBackgroundView.add((FloatProperty)CONTAINER_BACKGROUND_COLOR, this.COLOR_BIG_ISLAND, new long[0]);
                }
            } else if (this.isDiffContainerBackgroundColor(this.COLOR_BLACK)) {
                dynamicIslandBackgroundView.add((FloatProperty)CONTAINER_BACKGROUND_COLOR, this.COLOR_BLACK, new long[0]);
            }
        }
        o.f((Object)((Object)dynamicIslandBackgroundView), (String)"apply(...)");
        return dynamicIslandBackgroundView;
    }

    private final AnimState getBigIslandHiddenAnimState() {
        AnimState animState = this.getBigIslandAnimState().add(CONTAINER_ALPHA, 0.0f, new long[0]).add(CONTAINER_CLIP_START_PROGRESS, this.getBigIslandStart() + (float)this.view.getBigIslandViewWidth() * 0.1f, new long[0]).add(CONTAINER_CLIP_END_PROGRESS, this.getBigIslandEnd() - (float)this.view.getBigIslandViewWidth() * 0.1f, new long[0]).add(CONTAINER_CLIP_TOP_PROGRESS, this.getBigIslandTop() + (float)this.view.getIslandViewHeight() * 0.1f, new long[0]).add(CONTAINER_CLIP_BOTTOM_PROGRESS, this.getBigIslandBottom() - (float)this.view.getIslandViewHeight() * 0.1f, new long[0]).add(BIG_ISLAND_ALPHA, 0.0f, new long[0]).add(BIG_ISLAND_SCALE, 0.8f, new long[0]).add(BIG_ISLAND_BLUR, 1.0f, new long[0]).add(BIG_ISLAND_TRANS_X, this.getExpandedShouldTransX(), new long[0]).add(EXPANDED_TRANS_X, this.getExpandedShouldTransX(), new long[0]);
        o.f((Object)animState, (String)"add(...)");
        return animState;
    }

    private final AnimState getBigIslandZoomInAnimState() {
        return new AnimState().add(BIG_ISLAND_SCALE, 1.1f, new long[0]).add(CONTAINER_CLIP_START_PROGRESS, this.getBigIslandStart() - (float)DynamicIslandBaseContentView.getCurrentBigIslandWidth$default(this.view, null, 1, null) * 0.05f, new long[0]).add(CONTAINER_CLIP_END_PROGRESS, this.getBigIslandEnd() + (float)DynamicIslandBaseContentView.getCurrentBigIslandWidth$default(this.view, null, 1, null) * 0.05f, new long[0]).add(CONTAINER_CLIP_TOP_PROGRESS, this.getBigIslandTop() - (float)this.view.getIslandViewHeight() * 0.05f, new long[0]).add(CONTAINER_CLIP_BOTTOM_PROGRESS, this.getBigIslandBottom() + (float)this.view.getIslandViewHeight() * 0.05f, new long[0]);
    }

    private final AnimState getBigIslandZoomOutAnimState() {
        return new AnimState().add(BIG_ISLAND_SCALE, 1.0f, new long[0]).add(CONTAINER_CLIP_START_PROGRESS, this.getBigIslandStart(), new long[0]).add(CONTAINER_CLIP_END_PROGRESS, this.getBigIslandEnd(), new long[0]).add(CONTAINER_CLIP_TOP_PROGRESS, this.getBigIslandTop(), new long[0]).add(CONTAINER_CLIP_BOTTOM_PROGRESS, this.getBigIslandBottom(), new long[0]);
    }

    private final AnimState getCutoutAnimState() {
        DynamicIslandBackgroundView dynamicIslandBackgroundView = this.view.getBackgroundView();
        if (dynamicIslandBackgroundView != null) {
            dynamicIslandBackgroundView.setZ(0.0f);
        }
        if (this.isTableSummaryIsland) {
            return this.getHiddenAnimStatePad();
        }
        float f = this.isTableMiddleIsland ? this.getBigIslandTop() + (float)this.view.getContext().getResources().getDimensionPixelSize(R.dimen.big_island_margin_top) : this.getCutoutTop();
        float f2 = this.isTableMiddleIsland ? this.getBigIslandTop() + (float)this.view.getContext().getResources().getDimensionPixelSize(R.dimen.island_height_final_height) : this.getCutoutBottom();
        dynamicIslandBackgroundView = new AnimState().add(CONTAINER_X, 0.0f, new long[0]).add(CONTAINER_TRANS_Y, 0.0f, new long[0]).add(CONTAINER_ALPHA, 0.0f, new long[0]).add(CONTAINER_BLUR, 0.0f, new long[0]).add(CONTAINER_CLIP_START_PROGRESS, this.getCutoutStart(), new long[0]).add(CONTAINER_CLIP_END_PROGRESS, this.getCutoutEnd(), new long[0]).add(CONTAINER_CLIP_TOP_PROGRESS, f, new long[0]).add(CONTAINER_CLIP_BOTTOM_PROGRESS, f2, new long[0]).add(SMALL_ISLAND_ALPHA, 0.0f, new long[0]).add(SMALL_ISLAND_SCALE, (float)this.view.getFixedCutoutWidth() / (float)this.view.getIslandViewHeight(), new long[0]).add(SMALL_ISLAND_BLUR, 1.0f, new long[0]).add(SMALL_ISLAND_TRANS_X, 0.0f, new long[0]).add(SMALL_ISLAND_TRANS_Y, 0.0f, new long[0]).add(BIG_ISLAND_ALPHA, 0.0f, new long[0]).add(BIG_ISLAND_SCALE, 1.0f, new long[0]).add(BIG_ISLAND_BLUR, 1.0f, new long[0]).add(BIG_ISLAND_TRANS_Y, 0.0f, new long[0]).add(BIG_ISLAND_AREA_LEFT_TRANS_X, this.getAreaLeftCollapseTransX(), new long[0]).add(BIG_ISLAND_AREA_RIGHT_TRANS_X, this.getAreaRightCollapseTransX(), new long[0]).add(EXPANDED_ALPHA, 0.0f, new long[0]).add(EXPANDED_SCALE_X, (float)this.view.getFixedCutoutWidth() / (float)this.view.getExpandedViewWidth(), new long[0]).add(EXPANDED_SCALE_Y, (float)this.view.getFixedCutoutWidth() / (float)this.view.getExpandedViewWidth(), new long[0]).add(EXPANDED_BLUR, 1.0f, new long[0]).add(EXPANDED_TRANS_Y, -this.getExpandedTransYToCutout(), new long[0]);
        if (CommonUtils.INSTANCE.getIS_TABLET()) {
            f = this.getExpandedShouldTransX();
            dynamicIslandBackgroundView.add(BIG_ISLAND_TRANS_X, f, new long[0]);
            dynamicIslandBackgroundView.add(EXPANDED_TRANS_X, f, new long[0]);
        }
        o.f((Object)((Object)dynamicIslandBackgroundView), (String)"apply(...)");
        return dynamicIslandBackgroundView;
    }

    private final AnimState getExpandedAnimState() {
        DynamicIslandBackgroundView dynamicIslandBackgroundView = this.view.getBackgroundView();
        if (dynamicIslandBackgroundView != null) {
            dynamicIslandBackgroundView.setZ(2.0f);
        }
        dynamicIslandBackgroundView = new AnimState().add(CONTAINER_X, 0.0f, new long[0]).add(CONTAINER_TRANS_Y, this.view.getExpandedViewY() - this.view.getIslandViewMarginTop(), new long[0]).add(CONTAINER_ALPHA, 1.0f, new long[0]).add(CONTAINER_BLUR, 0.0f, new long[0]).add(CONTAINER_CLIP_START_PROGRESS, this.getExpandedStart(), new long[0]).add(CONTAINER_CLIP_END_PROGRESS, this.getExpandedEnd(), new long[0]).add(CONTAINER_CLIP_TOP_PROGRESS, this.getExpandedTop(), new long[0]).add(CONTAINER_CLIP_BOTTOM_PROGRESS, this.getExpandedBottom(), new long[0]).add(SMALL_ISLAND_ALPHA, 0.0f, new long[0]).add(SMALL_ISLAND_SCALE, 1.0f, new long[0]).add(SMALL_ISLAND_BLUR, 0.0f, new long[0]).add(SMALL_ISLAND_TRANS_X, this.getSmallTransXToExpanded(), new long[0]).add(SMALL_ISLAND_TRANS_Y, this.getSmallTransYToExpanded(), new long[0]).add(BIG_ISLAND_ALPHA, 0.0f, new long[0]);
        Context context = BIG_ISLAND_SCALE;
        dynamicIslandBackgroundView = dynamicIslandBackgroundView.add((FloatProperty)context, (float)this.view.getExpandedViewWidth() / (float)this.view.getBigIslandViewWidth(), new long[0]).add(BIG_ISLAND_BLUR, 1.0f, new long[0]).add(BIG_ISLAND_TRANS_Y, this.getBigTransYToExpanded(), new long[0]).add(BIG_ISLAND_AREA_LEFT_TRANS_X, 0.0f, new long[0]).add(BIG_ISLAND_AREA_RIGHT_TRANS_X, 0.0f, new long[0]).add(EXPANDED_ALPHA, 1.0f, new long[0]).add(EXPANDED_SCALE_X, 1.0f, new long[0]).add(EXPANDED_SCALE_Y, 1.0f, new long[0]).add(EXPANDED_BLUR, 0.0f, new long[0]).add(EXPANDED_TRANS_Y, 0.0f, new long[0]);
        if (CommonUtils.INSTANCE.getIS_TABLET()) {
            dynamicIslandBackgroundView.add(EXPANDED_TRANS_X, 0.0f, new long[0]);
            dynamicIslandBackgroundView.add(BIG_ISLAND_TRANS_X, 0.0f, new long[0]);
            dynamicIslandBackgroundView.add((FloatProperty)context, (float)this.view.getExpandedViewHeight() / (float)this.view.getIslandViewHeight(), new long[0]);
            dynamicIslandBackgroundView.add((FloatProperty)context, this.view.getExpandedViewHeight() / this.view.getIslandViewHeight(), new long[0]);
            context = this.view.getContext();
            o.f((Object)context, (String)"getContext(...)");
            if (!MiBlurCompat.getBackgroundBlurOpened((Context)context) && this.isDiffContainerBackgroundColor(this.COLOR_EXPANDED)) {
                dynamicIslandBackgroundView.add((FloatProperty)CONTAINER_BACKGROUND_COLOR, this.COLOR_EXPANDED, new long[0]);
            } else {
                context = this.view.getContext();
                o.f((Object)context, (String)"getContext(...)");
                if (MiBlurCompat.getBackgroundBlurOpened((Context)context) && this.isDiffContainerBackgroundColor(this.COLOR_BLACK)) {
                    dynamicIslandBackgroundView.add((FloatProperty)CONTAINER_BACKGROUND_COLOR, this.COLOR_BLACK, new long[0]);
                }
            }
        }
        o.f((Object)((Object)dynamicIslandBackgroundView), (String)"apply(...)");
        return dynamicIslandBackgroundView;
    }

    private final DynamicIslandContentFakeView getFakeView() {
        return this.view.getFakeView();
    }

    private final AnimState getHiddenAnimState() {
        DynamicIslandBackgroundView dynamicIslandBackgroundView = this.view.getBackgroundView();
        if (dynamicIslandBackgroundView != null) {
            dynamicIslandBackgroundView.setZ(0.0f);
        }
        dynamicIslandBackgroundView = new AnimState().add(CONTAINER_X, this.getSmallIslandX(), new long[0]).add(CONTAINER_TRANS_Y, 0.0f, new long[0]).add(CONTAINER_ALPHA, 0.0f, new long[0]).add(CONTAINER_CLIP_START_PROGRESS, this.getSmallIslandStart() + (float)this.view.getSmallIslandViewWidth() * 0.2f, new long[0]).add(CONTAINER_CLIP_END_PROGRESS, this.getSmallIslandEnd() - (float)this.view.getSmallIslandViewWidth() * 0.2f, new long[0]).add(CONTAINER_CLIP_TOP_PROGRESS, this.getSmallIslandTop() + (float)this.view.getIslandViewHeight() * 0.2f, new long[0]).add(CONTAINER_CLIP_BOTTOM_PROGRESS, this.getSmallIslandBottom() - (float)this.view.getIslandViewHeight() * 0.2f, new long[0]).add(SMALL_ISLAND_ALPHA, 1.0f, new long[0]).add(SMALL_ISLAND_SCALE, 0.6f, new long[0]).add(SMALL_ISLAND_BLUR, 0.0f, new long[0]).add(SMALL_ISLAND_TRANS_X, 0.0f, new long[0]).add(SMALL_ISLAND_TRANS_Y, 0.0f, new long[0]).add(BIG_ISLAND_ALPHA, 0.0f, new long[0]).add(BIG_ISLAND_SCALE, 1.0f, new long[0]).add(BIG_ISLAND_BLUR, 0.0f, new long[0]).add(BIG_ISLAND_TRANS_Y, 0.0f, new long[0]).add(BIG_ISLAND_AREA_LEFT_TRANS_X, this.getAreaLeftCollapseTransX(), new long[0]).add(BIG_ISLAND_AREA_RIGHT_TRANS_X, this.getAreaRightCollapseTransX(), new long[0]).add(EXPANDED_ALPHA, 0.0f, new long[0]).add(EXPANDED_SCALE_X, (float)this.view.getSmallIslandViewWidth() / (float)this.view.getExpandedViewWidth(), new long[0]).add(EXPANDED_SCALE_Y, (float)this.view.getSmallIslandViewWidth() / (float)this.view.getExpandedViewWidth(), new long[0]).add(EXPANDED_BLUR, 1.0f, new long[0]).add(EXPANDED_TRANS_Y, -this.getExpandedTransYToSmall(), new long[0]);
        o.f((Object)((Object)dynamicIslandBackgroundView), (String)"add(...)");
        return dynamicIslandBackgroundView;
    }

    private final AnimState getHiddenAnimStatePad() {
        DynamicIslandBackgroundView dynamicIslandBackgroundView = this.view.getBackgroundView();
        if (dynamicIslandBackgroundView != null) {
            dynamicIslandBackgroundView.setZ(0.0f);
        }
        float f = this.getExpandedShouldTransX();
        dynamicIslandBackgroundView = new AnimState().add(CONTAINER_TRANS_Y, 0.0f, new long[0]).add(CONTAINER_ALPHA, 0.0f, new long[0]).add(CONTAINER_BLUR, 0.0f, new long[0]).add(CONTAINER_CLIP_START_PROGRESS, this.getBigIslandStart() + (float)DynamicIslandBaseContentView.getCurrentBigIslandWidth$default(this.view, null, 1, null) * 0.1f, new long[0]).add(CONTAINER_CLIP_END_PROGRESS, this.getBigIslandEnd() - (float)DynamicIslandBaseContentView.getCurrentBigIslandWidth$default(this.view, null, 1, null) * 0.1f, new long[0]).add(CONTAINER_CLIP_TOP_PROGRESS, this.getBigIslandTop() + (float)this.view.getIslandViewHeight() * 0.1f, new long[0]).add(CONTAINER_CLIP_BOTTOM_PROGRESS, this.getBigIslandBottom() - (float)this.view.getIslandViewHeight() * 0.1f, new long[0]).add(EXPANDED_TRANS_X, f, new long[0]).add(EXPANDED_TRANS_Y, -this.getExpandedTransYToBig(), new long[0]).add(EXPANDED_ALPHA, 0.0f, new long[0]).add(EXPANDED_SCALE_X, (float)this.view.getBigIslandViewWidth() / (float)this.view.getExpandedViewWidth(), new long[0]).add(EXPANDED_SCALE_Y, (float)this.view.getBigIslandViewWidth() / (float)this.view.getExpandedViewWidth(), new long[0]).add(EXPANDED_BLUR, 40.0f, new long[0]).add(BIG_ISLAND_TRANS_X, f, new long[0]).add(BIG_ISLAND_TRANS_Y, 0.0f, new long[0]).add(BIG_ISLAND_ALPHA, 0.0f, new long[0]).add(BIG_ISLAND_SCALE, 0.8f, new long[0]).add(BIG_ISLAND_BLUR, 0.0f, new long[0]);
        Context context = this.view.getContext();
        o.f((Object)context, (String)"getContext(...)");
        if (!MiBlurCompat.getBackgroundBlurOpened((Context)context) && (context = this.view.getCurrentIslandData()) != null && DynamicIslandUtils.INSTANCE.isDynamicIslandPadNoPropOnce((DynamicIslandData)context)) {
            if (this.isDiffContainerBackgroundColor(this.COLOR_BIG_ISLAND)) {
                dynamicIslandBackgroundView.add((FloatProperty)CONTAINER_BACKGROUND_COLOR, this.COLOR_BIG_ISLAND, new long[0]);
            }
        } else if (this.isDiffContainerBackgroundColor(this.COLOR_BLACK)) {
            dynamicIslandBackgroundView.add((FloatProperty)CONTAINER_BACKGROUND_COLOR, this.COLOR_BLACK, new long[0]);
        }
        o.f((Object)((Object)dynamicIslandBackgroundView), (String)"apply(...)");
        return dynamicIslandBackgroundView;
    }

    private final AnimState getMultiTopIslandAnimState(DynamicIslandContentView animState) {
        boolean bl = this.windowView.hasOtherBigIsland((DynamicIslandContentView)animState);
        AnimState animState2 = new AnimState().add(CONTAINER_ALPHA, 0.0f, new long[0]).add(CONTAINER_BLUR, 0.0f, new long[0]);
        AnimState animState3 = CONTAINER_CLIP_START_PROGRESS;
        float f = this.getBigIslandStart();
        int n = animState.getBigIslandViewWidth();
        float f2 = !bl ? (float)n * 0.05f : (float)(-n) * 0.1f;
        animState3 = animState2.add(animState3, f - f2, new long[0]);
        animState2 = CONTAINER_CLIP_END_PROGRESS;
        f = this.getBigIslandEnd();
        n = animState.getBigIslandViewWidth();
        f2 = !bl ? (float)n * 0.05f : (float)(-n) * 0.1f;
        animState2 = animState3.add(animState2, f + f2, new long[0]);
        animState3 = CONTAINER_CLIP_TOP_PROGRESS;
        f = this.getBigIslandTop();
        n = animState.getIslandViewHeight();
        f2 = !bl ? (float)n * 0.05f : (float)(-n) * 0.1f;
        animState2 = animState2.add(animState3, f - f2, new long[0]);
        animState3 = CONTAINER_CLIP_BOTTOM_PROGRESS;
        f = this.getBigIslandBottom();
        n = animState.getIslandViewHeight();
        f2 = !bl ? (float)n * 0.05f : (float)(-n) * 0.1f;
        animState3 = animState2.add(animState3, f + f2, new long[0]).add(BIG_ISLAND_ALPHA, 0.0f, new long[0]);
        animState = BIG_ISLAND_SCALE;
        f2 = !bl ? 1.1f : 0.8f;
        animState = animState3.add(animState, f2, new long[0]).add(BIG_ISLAND_BLUR, 1.0f, new long[0]).add(BIG_ISLAND_TRANS_X, this.getExpandedShouldTransX(), new long[0]).add(EXPANDED_TRANS_X, this.getExpandedShouldTransX(), new long[0]);
        o.f((Object)animState, (String)"add(...)");
        return animState;
    }

    private final boolean getPanelHeightChanging() {
        return this.dynamicIslandAnimController.getDynamicIslandWindowState().getPanelHeightChanging();
    }

    private final AnimState getSlideOffAnimStatePad() {
        DynamicIslandBackgroundView dynamicIslandBackgroundView = this.view.getBackgroundView();
        if (dynamicIslandBackgroundView != null) {
            dynamicIslandBackgroundView.setZ(0.0f);
        }
        dynamicIslandBackgroundView = this.getExpandedAnimState().add(CONTAINER_TRANS_Y, -this.getExpandedBottom(), new long[0]);
        o.f((Object)((Object)dynamicIslandBackgroundView), (String)"add(...)");
        return dynamicIslandBackgroundView;
    }

    private final AnimState getSmallIslandAnimState() {
        DynamicIslandBackgroundView dynamicIslandBackgroundView = this.view.getBackgroundView();
        if (dynamicIslandBackgroundView != null) {
            dynamicIslandBackgroundView.setZ(1.0f);
        }
        dynamicIslandBackgroundView = new AnimState().add(CONTAINER_X, this.getSmallIslandX(), new long[0]).add(CONTAINER_TRANS_Y, 0.0f, new long[0]).add(CONTAINER_ALPHA, 1.0f, new long[0]).add(CONTAINER_CLIP_START_PROGRESS, this.getSmallIslandStart(), new long[0]).add(CONTAINER_CLIP_END_PROGRESS, this.getSmallIslandEnd(), new long[0]).add(CONTAINER_CLIP_TOP_PROGRESS, this.getSmallIslandTop(), new long[0]).add(CONTAINER_CLIP_BOTTOM_PROGRESS, this.getSmallIslandBottom(), new long[0]).add(SMALL_ISLAND_ALPHA, 1.0f, new long[0]).add(SMALL_ISLAND_SCALE, 1.0f, new long[0]).add(SMALL_ISLAND_BLUR, 0.0f, new long[0]).add(SMALL_ISLAND_TRANS_X, 0.0f, new long[0]).add(SMALL_ISLAND_TRANS_Y, 0.0f, new long[0]).add(BIG_ISLAND_ALPHA, 0.0f, new long[0]).add(BIG_ISLAND_SCALE, 1.0f, new long[0]).add(BIG_ISLAND_BLUR, 0.0f, new long[0]).add(BIG_ISLAND_TRANS_Y, 0.0f, new long[0]).add(BIG_ISLAND_AREA_LEFT_TRANS_X, this.getAreaLeftCollapseTransX(), new long[0]).add(BIG_ISLAND_AREA_RIGHT_TRANS_X, this.getAreaRightCollapseTransX(), new long[0]).add(EXPANDED_ALPHA, 0.0f, new long[0]).add(EXPANDED_SCALE_X, (float)this.view.getSmallIslandViewWidth() / (float)this.view.getExpandedViewWidth(), new long[0]).add(EXPANDED_SCALE_Y, (float)this.view.getSmallIslandViewWidth() / (float)this.view.getExpandedViewWidth(), new long[0]).add(EXPANDED_BLUR, 1.0f, new long[0]).add(EXPANDED_TRANS_Y, -this.getExpandedTransYToSmall(), new long[0]);
        o.f((Object)((Object)dynamicIslandBackgroundView), (String)"add(...)");
        return dynamicIslandBackgroundView;
    }

    private final int getSmallIslandX() {
        int n = this.dynamicIslandAnimController.getSmallIslandX();
        DynamicIslandUtils dynamicIslandUtils = DynamicIslandUtils.INSTANCE;
        Context context = this.view.getContext();
        o.f((Object)context, (String)"getContext(...)");
        return n - dynamicIslandUtils.getScreenWidthOld(context) / 2 + this.view.getSmallIslandViewWidth() / 2;
    }

    /*
     * Unable to fully structure code
     */
    private final float getSupposedContainerAlpha() {
        var3_1 = FoldUtils.INSTANCE.isFoldScreenLayoutLarge((View)this.view);
        if (!CommonUtils.isFlipDevice()) ** GOTO lbl-1000
        var4_2 = this.view.getContext();
        o.f((Object)var4_2, (String)"getContext(...)");
        if (CommonUtils.isTinyScreen((Context)var4_2)) {
            var2_3 = true;
        } else lbl-1000:
        // 2 sources

        {
            var2_3 = false;
        }
        var4_2 = CommonUtils.INSTANCE;
        var5_4 = this.view.getContext();
        o.f((Object)var5_4, (String)"getContext(...)");
        var1_5 = var4_2.getInVerticalMode(var5_4) != false && var3_1 == false && var2_3 == false && OneHandModeUtils.INSTANCE.isOneHandMode() == false && var4_2.getIS_TABLET() == false ? 1.0f : 0.0f;
        return var1_5;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private final float getSwipeLeftAreaTransX(float f) {
        int n;
        if (this.isRtlLayout()) {
            n = -this.view.getBigIslandViewWidth();
            return (float)((double)((float)n * f) * 0.5);
        }
        n = this.view.getBigIslandViewWidth();
        return (float)((double)((float)n * f) * 0.5);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private final float getSwipeRightAreaTransX(float f) {
        int n;
        if (this.isRtlLayout()) {
            n = this.view.getBigIslandViewWidth();
            return (float)((double)((float)n * f) * 0.5);
        }
        n = -this.view.getBigIslandViewWidth();
        return (float)((double)((float)n * f) * 0.5);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private final float getSwipeSmallToBigX(float f) {
        double d2;
        int n = this.getSmallIslandX();
        Integer n2 = this.view.getCurrentBigIslandViewWidth();
        int n3 = n2 != null ? n2 : 0;
        if (this.isRtlLayout()) {
            d2 = (double)n + (double)((float)n3 * f) * 0.25;
            return (float)d2;
        }
        d2 = (double)n - (double)((float)n3 * f) * 0.25;
        return (float)d2;
    }

    private final AnimState getTempHiddenCompleteAnimStatePad() {
        AnimState animState = this.getBigIslandAnimState().add(CONTAINER_ALPHA, 0.0f, new long[0]).add(BIG_ISLAND_ALPHA, 0.0f, new long[0]);
        o.f((Object)animState, (String)"add(...)");
        return animState;
    }

    private final boolean hasSmallIsland() {
        return this.view.hasSmallIsland();
    }

    private final void initToHiddenNoAnim(DynamicIslandContentView dynamicIslandContentView) {
        dynamicIslandContentView.updateBigIslandLayout();
        IFolme iFolme = FolmeKt.getFolme((FolmeObject)this);
        dynamicIslandContentView = CommonUtils.INSTANCE.getIS_TABLET() ? this.getHiddenAnimStatePad() : this.getCutoutAnimState();
        iFolme.setTo((Object)dynamicIslandContentView, new AnimConfig[]{new AnimConfig().addListeners(new TransitionListener[]{new DynamicIslandAnimListener(this){}})});
    }

    private final boolean isDiffContainerBackgroundColor(int n) {
        boolean bl;
        Object object = this.view.getContainer();
        ColorDrawable colorDrawable = null;
        if ((object = object != null ? object.getBackground() : null) instanceof ColorDrawable) {
            colorDrawable = (ColorDrawable)object;
        }
        boolean bl2 = bl = false;
        if (colorDrawable != null) {
            bl2 = bl;
            if (colorDrawable.getColor() == n) {
                bl2 = true;
            }
        }
        return bl2 ^ true;
    }

    private final boolean isRtlLayout() {
        Context context = this.view.getContext();
        o.f((Object)context, (String)"getContext(...)");
        return CommonUtils.isLayoutRtl((Context)context);
    }

    private final void onSwipeBigToSmallAnimation(DynamicIslandContentView dynamicIslandContentView, float f) {
        DynamicIslandUtils dynamicIslandUtils = DynamicIslandUtils.INSTANCE;
        Context context = dynamicIslandContentView.getContext();
        o.f((Object)context, (String)"getContext(...)");
        f = Math.abs(this.ratio(dynamicIslandUtils.getScreenWidthOld(context) / 2, (int)f));
        int n = DynamicIslandBaseContentView.getCurrentBigIslandX$default(dynamicIslandContentView, null, 1, null);
        int n2 = this.isRtlLayout() ? this.getSmallIslandX() : this.dynamicIslandAnimController.getSmallIslandX();
        FolmeKt.getFolme((FolmeObject)this).to((Object)new AnimState().add(CONTAINER_X, (float)(n2 - n) * f, new long[0]).add(CONTAINER_TRANS_Y, 0.0f, new long[0]).add(CONTAINER_CLIP_START_PROGRESS, (double)this.getBigIslandStart() + (double)((float)dynamicIslandContentView.getBigIslandViewWidth() * f) * 0.5).add(CONTAINER_CLIP_END_PROGRESS, (double)this.getBigIslandEnd() - (double)((float)dynamicIslandContentView.getBigIslandViewWidth() * f) * 0.5).add(CONTAINER_CLIP_TOP_PROGRESS, this.getBigIslandTop(), new long[0]).add(CONTAINER_CLIP_BOTTOM_PROGRESS, this.getBigIslandBottom(), new long[0]).add(BIG_ISLAND_AREA_LEFT_TRANS_X, this.getSwipeLeftAreaTransX(f), new long[0]).add(BIG_ISLAND_AREA_RIGHT_TRANS_X, this.getSwipeRightAreaTransX(f), new long[0]).add(CONTAINER_ALPHA, 1.0f, new long[0]).add(BIG_ISLAND_ALPHA, this.calculateSwipeAlpha(f), new long[0]), new AnimConfig[]{new AnimConfig().addListeners(new TransitionListener[]{new DynamicIslandAnimListener(this){}})});
    }

    private final void onSwipeExpandedToBig(float f, float f2) {
        if (Math.abs(f) > Math.abs(f2)) {
            this.swipeLeftExpandedAnimation(f);
        } else if (Math.abs(f) < Math.abs(f2) && f2 < 0.0f) {
            this.swipeUpExpandedAnimation(f2);
        } else {
            Log.e((String)"DynamicIslandSwipeDebug", (String)"error on swipe expandedState");
        }
    }

    private final void onSwipeSmallIslandToHiddenAnimation(DynamicIslandContentView dynamicIslandContentView, float f) {
        DynamicIslandUtils dynamicIslandUtils = DynamicIslandUtils.INSTANCE;
        Context context = dynamicIslandContentView.getContext();
        o.f((Object)context, (String)"getContext(...)");
        f = Math.abs(this.ratio(dynamicIslandUtils.getScreenWidthOld(context) / 2, (int)f));
        FolmeKt.getFolme((FolmeObject)this).to((Object)new AnimState().add(CONTAINER_ALPHA, 0.8f, new long[0]).add(CONTAINER_CLIP_START_PROGRESS, (double)this.getSmallIslandStart() + (double)((float)dynamicIslandContentView.getSmallIslandViewWidth() * f) * 0.5).add(CONTAINER_CLIP_END_PROGRESS, (double)this.getSmallIslandEnd() - (double)((float)dynamicIslandContentView.getSmallIslandViewWidth() * f) * 0.5).add(CONTAINER_CLIP_TOP_PROGRESS, (double)this.getSmallIslandTop() + (double)((float)dynamicIslandContentView.getIslandViewHeight() * f) * 0.5).add(CONTAINER_CLIP_BOTTOM_PROGRESS, (double)this.getSmallIslandBottom() - (double)((float)dynamicIslandContentView.getIslandViewHeight() * f) * 0.5).add(SMALL_ISLAND_ALPHA, this.calculateSwipeAlpha(f), new long[0]).add(SMALL_ISLAND_SCALE, 0.8f, new long[0]), new AnimConfig[]{new AnimConfig().addListeners(new TransitionListener[]{new DynamicIslandAnimListener(this){}})});
    }

    private final void onSwipeSmallToTempHidden(float f) {
        double d2;
        if (this.view.getCurrentBigIslandViewWidth() == null) {
            return;
        }
        Object object = this.bigIslandStateHandler.getCurrent();
        object = object != null ? Integer.valueOf(object.getBigIslandViewWidth()) : null;
        if (object == null) {
            return;
        }
        object = DynamicIslandUtils.INSTANCE;
        Context context = this.view.getContext();
        o.f((Object)context, (String)"getContext(...)");
        f = Math.abs(this.ratio(((DynamicIslandUtils)object).getScreenWidthOld(context) / 2, (int)f));
        if (this.isRtlLayout()) {
            d2 = this.getSmallIslandX();
            object = this.view.getCurrentBigIslandViewWidth();
            int n = object != null ? (Integer)object : 0;
            d2 += (double)((float)n * f) * 0.5;
        } else {
            d2 = this.getSmallIslandX();
            object = this.view.getCurrentBigIslandViewWidth();
            int n = object != null ? (Integer)object : 0;
            d2 -= (double)((float)n * f) * 0.5;
        }
        FolmeKt.getFolme((FolmeObject)this).to((Object)new AnimState().add(CONTAINER_X, d2).add(CONTAINER_ALPHA, 1.0f, new long[0]).add(SMALL_ISLAND_ALPHA, this.calculateSwipeAlpha(f), new long[0]), new AnimConfig[]{new AnimConfig().addListeners(new TransitionListener[]{new DynamicIslandAnimListener(this){}})});
    }

    private final float ratio(int n, int n2) {
        return Math.abs((float)n2 / (float)n) * 0.14f;
    }

    public static /* synthetic */ void removeViewFromWindow$default(DynamicIslandAnimationDelegate dynamicIslandAnimationDelegate, DynamicIslandContentView dynamicIslandContentView, boolean bl, int n, Object object) {
        if ((n & 2) != 0) {
            bl = false;
        }
        dynamicIslandAnimationDelegate.removeViewFromWindow(dynamicIslandContentView, bl);
    }

    private final void resetToBig(DynamicIslandContentView dynamicIslandContentView) {
        FolmeKt.getFolme((FolmeObject)this).to((Object)this.getBigIslandAnimState(), new AnimConfig[]{new AnimConfig().addListeners(new TransitionListener[]{new DynamicIslandAnimListener(this){

            public void onCancel(Object object) {
                DynamicIslandScenarioUtils dynamicIslandScenarioUtils = DynamicIslandScenarioUtils.INSTANCE;
                if (dynamicIslandScenarioUtils.isBigTracking()) {
                    dynamicIslandScenarioUtils.setDynamicIslandScenarioState(494L, false);
                    dynamicIslandScenarioUtils.setBigTracking(false);
                }
                super.onCancel(object);
            }

            public void onComplete(Object object) {
                DynamicIslandScenarioUtils dynamicIslandScenarioUtils = DynamicIslandScenarioUtils.INSTANCE;
                if (dynamicIslandScenarioUtils.isBigTracking()) {
                    dynamicIslandScenarioUtils.setDynamicIslandScenarioState(494L, false);
                    dynamicIslandScenarioUtils.setBigTracking(false);
                }
                super.onComplete(object);
            }
        }})});
    }

    private final void resetToExpanded(DynamicIslandContentView dynamicIslandContentView) {
        FolmeKt.getFolme((FolmeObject)this).to((Object)this.getExpandedAnimState(), new AnimConfig[]{new AnimConfig().addListeners(new TransitionListener[]{new DynamicIslandAnimListener(this){
            final DynamicIslandAnimationDelegate this$0;
            {
                this.this$0 = dynamicIslandAnimationDelegate;
                super(dynamicIslandAnimationDelegate);
            }

            public void onBegin(Object object) {
                super.onBegin(object);
                DynamicIslandAnimationCallback dynamicIslandAnimationCallback = DynamicIslandAnimationDelegate.access$getDynamicIslandAnimController$p(this.this$0).getAnimationCallback$miui_dynamicisland_release();
                DynamicIslandAnimationType dynamicIslandAnimationType = DynamicIslandAnimationType.TO_EXPANDED;
                DynamicIslandAnimationCallbackType dynamicIslandAnimationCallbackType = DynamicIslandAnimationCallbackType.ANIM_START;
                o.e((Object)object, (String)"null cannot be cast to non-null type kotlin.String");
                dynamicIslandAnimationCallback.executeCallback(dynamicIslandAnimationType, dynamicIslandAnimationCallbackType, (String)object);
                DynamicIslandAnimationDelegate.access$setAnimateExpanding(this.this$0, true);
            }

            public void onCancel(Object object) {
                super.onCancel(object);
                object = DynamicIslandScenarioUtils.INSTANCE;
                if (((DynamicIslandScenarioUtils)object).isExpandTracking()) {
                    ((DynamicIslandScenarioUtils)object).setDynamicIslandScenarioState(496L, false);
                    ((DynamicIslandScenarioUtils)object).setExpandTracking(false);
                }
                DynamicIslandAnimationDelegate.access$setAnimateExpanding(this.this$0, false);
            }

            public void onComplete(Object object) {
                super.onComplete(object);
                DynamicIslandAnimationCallback dynamicIslandAnimationCallback = DynamicIslandAnimationDelegate.access$getDynamicIslandAnimController$p(this.this$0).getAnimationCallback$miui_dynamicisland_release();
                DynamicIslandAnimationType dynamicIslandAnimationType = DynamicIslandAnimationType.TO_EXPANDED;
                DynamicIslandAnimationCallbackType dynamicIslandAnimationCallbackType = DynamicIslandAnimationCallbackType.ANIM_FINISH;
                o.e((Object)object, (String)"null cannot be cast to non-null type kotlin.String");
                dynamicIslandAnimationCallback.executeCallback(dynamicIslandAnimationType, dynamicIslandAnimationCallbackType, (String)object);
                object = DynamicIslandScenarioUtils.INSTANCE;
                if (((DynamicIslandScenarioUtils)object).isExpandTracking()) {
                    ((DynamicIslandScenarioUtils)object).setDynamicIslandScenarioState(496L, false);
                    ((DynamicIslandScenarioUtils)object).setExpandTracking(false);
                }
                DynamicIslandAnimationDelegate.access$setAnimateExpanding(this.this$0, false);
            }
        }})});
    }

    private final void resetToHidden(DynamicIslandContentView dynamicIslandContentView) {
        FolmeKt.getFolme((FolmeObject)this).to((Object)this.getCutoutAnimState(), new AnimConfig[]{new AnimConfig().addListeners(new TransitionListener[]{new DynamicIslandAnimListener(this){}})});
    }

    private final void resetToSmall(DynamicIslandContentView dynamicIslandContentView) {
        FolmeKt.getFolme((FolmeObject)this).to((Object)this.getSmallIslandAnimState(), new AnimConfig[]{new AnimConfig().addListeners(new TransitionListener[]{new DynamicIslandAnimListener(this){

            public void onCancel(Object object) {
                DynamicIslandScenarioUtils dynamicIslandScenarioUtils = DynamicIslandScenarioUtils.INSTANCE;
                if (dynamicIslandScenarioUtils.isSmallTracking()) {
                    dynamicIslandScenarioUtils.setDynamicIslandScenarioState(495L, false);
                    dynamicIslandScenarioUtils.setSmallTracking(false);
                }
                super.onCancel(object);
            }

            public void onComplete(Object object) {
                DynamicIslandScenarioUtils dynamicIslandScenarioUtils = DynamicIslandScenarioUtils.INSTANCE;
                if (dynamicIslandScenarioUtils.isSmallTracking()) {
                    dynamicIslandScenarioUtils.setDynamicIslandScenarioState(495L, false);
                    dynamicIslandScenarioUtils.setSmallTracking(false);
                }
                super.onComplete(object);
            }
        }})});
    }

    private final void setAnimateExpanding(boolean bl) {
        if (this.isAnimateExpanding == bl) {
            return;
        }
        this.isAnimateExpanding = bl;
        DynamicIslandExpandedView dynamicIslandExpandedView = this.view.getExpandedView();
        if (dynamicIslandExpandedView != null) {
            dynamicIslandExpandedView.setTag(R.id.dynamic_island_animate_expanding_tag, bl);
        }
    }

    private final void setViewVisible(DynamicIslandBaseContentView frameLayout, int n) {
        if (frameLayout != null) {
            frameLayout.setVisibility(n);
        }
        frameLayout = frameLayout != null ? frameLayout.getBackgroundView() : null;
        if (frameLayout != null) {
            frameLayout.setVisibility(n);
        }
    }

    private final boolean shouldUpdateTransX(float f, float f2) {
        boolean bl = f != 0.0f && !Float.isNaN(f2) && f2 != f;
        return bl;
    }

    private final void smallIslandToHiddenAnimation(DynamicIslandContentView dynamicIslandContentView, boolean bl, boolean bl2) {
        if (this.bigIslandStateHandler.getCurrent() != null && !this.dynamicIslandAnimController.getDynamicIslandWindowState().isToScreenLockNoAnimation()) {
            this.hiddenStateFrom = new DynamicIslandState(){};
            IFolme iFolme = FolmeKt.getFolme((FolmeObject)this);
            AnimState animState = this.getHiddenAnimState();
            AnimConfig animConfig = new AnimConfig().setSpecial(CONTAINER_ALPHA, this.HIDDEN_EASE, new float[0]);
            animConfig = animConfig.setSpecial(SMALL_ISLAND_SCALE, this.HIDDEN_EASE, new float[0]);
            animConfig = animConfig.setSpecial(CONTAINER_CLIP_START_PROGRESS, this.HIDDEN_EASE, new float[0]);
            animConfig = animConfig.setSpecial(CONTAINER_CLIP_END_PROGRESS, this.HIDDEN_EASE, new float[0]);
            animConfig = animConfig.setSpecial(CONTAINER_CLIP_TOP_PROGRESS, this.HIDDEN_EASE, new float[0]);
            animConfig = animConfig.setSpecial(CONTAINER_CLIP_BOTTOM_PROGRESS, this.HIDDEN_EASE, new float[0]);
            animConfig = animConfig.addListeners(new TransitionListener[]{new DynamicIslandAnimListener(this){

                public void onBegin(Object object) {
                    super.onBegin(object);
                    DynamicIslandScenarioUtils.INSTANCE.setDynamicIslandScenarioState(439L, true);
                }

                public void onCancel(Object object) {
                    super.onCancel(object);
                    object = DynamicIslandScenarioUtils.INSTANCE;
                    if (((DynamicIslandScenarioUtils)object).isSmallTracking()) {
                        ((DynamicIslandScenarioUtils)object).setDynamicIslandScenarioState(495L, false);
                        ((DynamicIslandScenarioUtils)object).setSmallTracking(false);
                    }
                    ((DynamicIslandScenarioUtils)object).setDynamicIslandScenarioState(439L, false);
                }

                public void onComplete(Object object) {
                    super.onComplete(object);
                    object = DynamicIslandScenarioUtils.INSTANCE;
                    if (((DynamicIslandScenarioUtils)object).isSmallTracking()) {
                        ((DynamicIslandScenarioUtils)object).setDynamicIslandScenarioState(495L, false);
                        ((DynamicIslandScenarioUtils)object).setSmallTracking(false);
                    }
                    ((DynamicIslandScenarioUtils)object).setDynamicIslandScenarioState(439L, false);
                }
            }});
            iFolme.to((Object)animState, new AnimConfig[]{animConfig});
        } else {
            this.smallIslandToTempHiddenAnimation(dynamicIslandContentView);
        }
        if (bl2) {
            this.fakeViewToHidden(dynamicIslandContentView, bl);
        }
    }

    private final void smallIslandToTempHiddenNoAnimation(DynamicIslandContentView dynamicIslandBaseContentView) {
        FolmeKt.getFolme((FolmeObject)this).setTo((Object)this.getCutoutAnimState(), new AnimConfig[]{new AnimConfig().addListeners(new TransitionListener[]{new DynamicIslandAnimListener(this){

            public void onBegin(Object object) {
                super.onBegin(object);
            }
        }})});
        dynamicIslandBaseContentView = dynamicIslandBaseContentView.getFakeView();
        if (dynamicIslandBaseContentView != null) {
            ((DynamicIslandContentFakeView)dynamicIslandBaseContentView).setVisibility(8);
        }
    }

    private final void swipeLeftExpandedAnimation(float f) {
        float f2 = Math.abs(this.ratio(this.view.getExpandedViewWidth(), (int)f));
        IFolme iFolme = FolmeKt.getFolme((FolmeObject)this);
        AnimState animState = new AnimState().add(CONTAINER_X, 0.0f, new long[0]).add(CONTAINER_TRANS_Y, this.view.getExpandedViewY() - this.view.getIslandViewMarginTop(), new long[0]).add(CONTAINER_CLIP_START_PROGRESS, this.getExpandedStart() + (float)this.view.getExpandedViewWidth() * f2 * 0.5f, new long[0]).add(CONTAINER_CLIP_END_PROGRESS, this.getExpandedEnd() - (float)this.view.getExpandedViewWidth() * f2 * 0.5f, new long[0]).add(CONTAINER_CLIP_TOP_PROGRESS, this.getExpandedTop(), new long[0]).add(CONTAINER_CLIP_BOTTOM_PROGRESS, this.getExpandedBottom(), new long[0]);
        FloatProperty<DynamicIslandAnimationDelegate> floatProperty = EXPANDED_SCALE_X;
        f = 1.0f;
        iFolme.to((Object)animState.add(floatProperty, f - Math.abs(f2), new long[0]).add(EXPANDED_SCALE_Y, 1.0f, new long[0]).add(EXPANDED_ALPHA, this.calculateSwipeAlpha(f2), new long[0]).add(EXPANDED_BLUR, f - this.calculateSwipeAlpha(f2), new long[0]), new AnimConfig[]{new AnimConfig().addListeners(new TransitionListener[]{new DynamicIslandAnimListener(this){}})});
    }

    private final void swipeUpExpandedAnimation(float f) {
        f = Math.abs(this.ratio(this.view.getExpandedViewHeight(), (int)f));
        IFolme iFolme = FolmeKt.getFolme((FolmeObject)this);
        AnimState animState = new AnimState().add(CONTAINER_X, 0.0f, new long[0]).add(CONTAINER_TRANS_Y, this.view.getExpandedViewY() - this.view.getIslandViewMarginTop(), new long[0]).add(CONTAINER_CLIP_START_PROGRESS, this.getExpandedStart(), new long[0]).add(CONTAINER_CLIP_END_PROGRESS, this.getExpandedEnd(), new long[0]).add(CONTAINER_CLIP_TOP_PROGRESS, this.getExpandedTop(), new long[0]).add(CONTAINER_CLIP_BOTTOM_PROGRESS, this.getExpandedBottom() - (float)this.view.getExpandedViewHeight() * f, new long[0]).add(EXPANDED_ALPHA, this.calculateSwipeAlpha(f), new long[0]).add(EXPANDED_SCALE_X, 1.0f, new long[0]);
        FloatProperty<DynamicIslandAnimationDelegate> floatProperty = EXPANDED_SCALE_Y;
        float f2 = 1.0f;
        iFolme.to((Object)animState.add(floatProperty, f2 - f, new long[0]).add(EXPANDED_TRANS_Y, (double)((float)(-this.view.getExpandedViewHeight()) * f) * 0.5).add(EXPANDED_BLUR, f2 - this.calculateSwipeAlpha(f), new long[0]), new AnimConfig[]{new AnimConfig().addListeners(new TransitionListener[]{new DynamicIslandAnimListener(this){}})});
    }

    public static /* synthetic */ void tempHiddenToBigIslandAnimation$default(DynamicIslandAnimationDelegate dynamicIslandAnimationDelegate, DynamicIslandContentView dynamicIslandContentView, boolean bl, int n, Object object) {
        if ((n & 2) != 0) {
            bl = false;
        }
        dynamicIslandAnimationDelegate.tempHiddenToBigIslandAnimation(dynamicIslandContentView, bl);
    }

    private final void tempHiddenToBigIslandNoAnimation(DynamicIslandContentView dynamicIslandContentView) {
        this.setViewVisible(dynamicIslandContentView, 0);
        dynamicIslandContentView.updateBigIslandLayout();
        AnimConfig animConfig = CommonUtils.INSTANCE.getIS_TABLET() ? new AnimConfig() : new AnimConfig().setSpecial(CONTAINER_CLIP_START_PROGRESS, this.APPEAR_EASE, new float[0]).setSpecial(CONTAINER_CLIP_END_PROGRESS, this.APPEAR_EASE, new float[0]).setSpecial(BIG_ISLAND_SCALE, this.APPEAR_EASE, new float[0]).setSpecial(BIG_ISLAND_ALPHA, this.HIDDEN_EASE, 100L, new float[0]).setSpecial(BIG_ISLAND_AREA_LEFT_TRANS_X, this.APPEAR_EASE, new float[0]).setSpecial(BIG_ISLAND_AREA_RIGHT_TRANS_X, this.APPEAR_EASE, new float[0]);
        FolmeKt.getFolme((FolmeObject)this).setTo((Object)this.getBigIslandAnimState(), new AnimConfig[]{animConfig.addListeners(new TransitionListener[]{new DynamicIslandAnimListener(this, dynamicIslandContentView){
            final DynamicIslandContentView $view;
            final DynamicIslandAnimationDelegate this$0;
            {
                this.this$0 = dynamicIslandAnimationDelegate;
                this.$view = dynamicIslandContentView;
                super(dynamicIslandAnimationDelegate);
            }

            public void onBegin(Object object) {
                super.onBegin(object);
                object = this.$view.getBigIslandView();
                if (object != null) {
                    object.setVisibility(0);
                }
                DynamicIslandAnimationDelegate.access$getAnimationDelegateHelper$p(this.this$0).requestUpdateHeadsUpLocation(DynamicIslandAnimationType.TEMP_HIDDEN_TO_BIG, this.$view);
                DynamicIslandAnimationDelegate.access$getAnimationDelegateHelper$p(this.this$0).updateBigIslandContainerBackground(this.$view);
            }
        }})});
    }

    public static /* synthetic */ void tempHiddenToSmallIslandAnimation$default(DynamicIslandAnimationDelegate dynamicIslandAnimationDelegate, DynamicIslandContentView dynamicIslandContentView, boolean bl, int n, Object object) {
        if ((n & 2) != 0) {
            bl = false;
        }
        dynamicIslandAnimationDelegate.tempHiddenToSmallIslandAnimation(dynamicIslandContentView, bl);
    }

    private final void tempHiddenToSmallIslandNoAnimation(DynamicIslandContentView dynamicIslandContentView) {
        this.setViewVisible(dynamicIslandContentView, 0);
        FolmeKt.getFolme((FolmeObject)this).setTo((Object)this.getSmallIslandAnimState(), new AnimConfig[]{new AnimConfig().setSpecial(CONTAINER_X, this.APPEAR_EASE, new float[0]).setSpecial(CONTAINER_CLIP_START_PROGRESS, this.APPEAR_EASE, new float[0]).setSpecial(CONTAINER_CLIP_END_PROGRESS, this.APPEAR_EASE, new float[0]).setSpecial(SMALL_ISLAND_SCALE, this.APPEAR_EASE, new float[0]).setSpecial(SMALL_ISLAND_ALPHA, this.HIDDEN_EASE, 100L, new float[0]).addListeners(new TransitionListener[]{new DynamicIslandAnimListener(this, dynamicIslandContentView){
            final DynamicIslandContentView $view;
            {
                this.$view = dynamicIslandContentView;
                super(dynamicIslandAnimationDelegate);
            }

            public void onBegin(Object object) {
                super.onBegin(object);
                object = this.$view.getSmallIslandView();
                if (object != null) {
                    object.setVisibility(0);
                }
            }
        }})});
    }

    public static /* synthetic */ void updateFakeViewStateForAppAnim$default(DynamicIslandAnimationDelegate dynamicIslandAnimationDelegate, int n, int n2, int n3, int n4, DynamicIslandContentView dynamicIslandContentView, boolean bl, boolean bl2, int n5, Object object) {
        if ((n5 & 0x40) != 0) {
            bl2 = false;
        }
        dynamicIslandAnimationDelegate.updateFakeViewStateForAppAnim(n, n2, n3, n4, dynamicIslandContentView, bl, bl2);
    }

    private final void updateSmallTx() {
        DynamicIslandContentFakeView dynamicIslandContentFakeView;
        int n = this.getSmallIslandX();
        int n2 = this.getAppAnimSmallX();
        if (n2 != 0) {
            n = n2;
        }
        if ((dynamicIslandContentFakeView = (dynamicIslandContentFakeView = this.getFakeView()) != null ? dynamicIslandContentFakeView.getFakeSmallIsland() : null) != null) {
            dynamicIslandContentFakeView.setTranslationX(n);
        }
    }

    public final void appExpandedToAppExpandedAnimation(DynamicIslandContentView dynamicIslandContentView) {
        o.g((Object)((Object)dynamicIslandContentView), (String)"view");
    }

    public final DynamicIslandAnimListener appExpandedToBigIslandAnimListener(DynamicIslandContentView dynamicIslandContentView, boolean bl) {
        o.g((Object)((Object)dynamicIslandContentView), (String)"view");
        return new DynamicIslandAnimListener(this, dynamicIslandContentView, bl){
            final boolean $isAppClose;
            final DynamicIslandContentView $view;
            final DynamicIslandAnimationDelegate this$0;
            {
                this.this$0 = dynamicIslandAnimationDelegate;
                this.$view = dynamicIslandContentView;
                this.$isAppClose = bl;
                super(dynamicIslandAnimationDelegate);
            }

            public void onBegin(Object object) {
                this.this$0.setAppClosing(true);
                super.onBegin(object);
                object = this.$view.getExpandedView();
                if (object != null) {
                    object.setVisibility(4);
                }
                object = this.$view.getBigIslandView();
                if (object != null) {
                    object.setVisibility(0);
                }
                if (!this.this$0.getIslandWindowAnimRunning()) {
                    DynamicIslandAnimationDelegate.access$setViewVisible(this.this$0, this.$view, 0);
                    object = this.$view.getFakeView();
                    if (object != null) {
                        ((DynamicIslandContentFakeView)((Object)object)).setVisibility(4);
                    }
                } else {
                    if (!this.this$0.getExpandedToTempHiddenAnimating()) {
                        DynamicIslandAnimationDelegate.access$setViewVisible(this.this$0, this.$view, 4);
                    }
                    if ((object = DynamicIslandAnimationDelegate.access$getFakeView(this.this$0)) != null) {
                        ((DynamicIslandContentFakeView)((Object)object)).setVisibility(0);
                    }
                }
                DynamicIslandAnimationDelegate.access$getAnimationDelegateHelper$p(this.this$0).updateBigIslandContainerBackground(this.$view);
                DynamicIslandScenarioUtils.INSTANCE.setDynamicIslandScenarioState(434L, true);
            }

            public void onCancel(Object object) {
                this.this$0.setAppClosing(false);
                super.onCancel(object);
                if (this.this$0.getExpandedToTempHiddenAnimating()) {
                    if (this.this$0.getIslandWindowAnimRunning()) {
                        DynamicIslandAnimationDelegate.access$setViewVisible(this.this$0, this.$view, 4);
                    }
                    this.this$0.setExpandedToTempHiddenAnimating(false);
                }
                DynamicIslandScenarioUtils.INSTANCE.setDynamicIslandScenarioState(434L, false);
                if (this.this$0.getIslandWindowAnimRunning() && !this.$isAppClose) {
                    if (!DynamicIslandAnimationDelegate.access$getWindowView$p(this.this$0).getSupportMiniWindowEndPositionChange() || !((DynamicIslandBaseContentView)((Object)(object = this.$view))).pkgHasMultIslands((DynamicIslandContentView)((Object)object)) || this.this$0.getIslandStateChanged() && !(this.$view.getState() instanceof DynamicIslandState.SmallIsland)) {
                        DynamicIslandAnimationDelegate.access$setViewVisible(this.this$0, this.$view, 0);
                        object = this.$view.getFakeView();
                        if (object != null) {
                            ((DynamicIslandContentFakeView)((Object)object)).setVisibility(4);
                        }
                    }
                    if ((object = this.$view.getBigIslandView()) != null) {
                        object.setVisibility(0);
                    }
                }
            }

            public void onComplete(Object object) {
                this.this$0.setAppClosing(false);
                super.onComplete(object);
                if (this.this$0.getExpandedToTempHiddenAnimating()) {
                    if (this.this$0.getIslandWindowAnimRunning()) {
                        DynamicIslandAnimationDelegate.access$setViewVisible(this.this$0, this.$view, 4);
                    }
                    this.this$0.resetContainerAlpha();
                    this.this$0.setExpandedToTempHiddenAnimating(false);
                }
                if (this.this$0.getIslandWindowAnimRunning() && !this.$isAppClose) {
                    DynamicIslandAnimationDelegate.access$setViewVisible(this.this$0, this.$view, 0);
                    object = this.$view.getBigIslandView();
                    if (object != null) {
                        object.setVisibility(0);
                    }
                    object = this.$view.getFakeView();
                    if (object != null) {
                        ((DynamicIslandContentFakeView)((Object)object)).setVisibility(4);
                    }
                }
                DynamicIslandScenarioUtils.INSTANCE.setDynamicIslandScenarioState(434L, false);
            }
        };
    }

    public final void appExpandedToBigIslandAnimation(DynamicIslandContentView dynamicIslandContentView) {
        o.g((Object)((Object)dynamicIslandContentView), (String)"view");
        this.appExpandedToBigIslandAnimation(dynamicIslandContentView, true);
    }

    public final void appExpandedToBigIslandAnimation(DynamicIslandContentView dynamicIslandContentView, boolean bl) {
        o.g((Object)((Object)dynamicIslandContentView), (String)"view");
        dynamicIslandContentView.updateBigIslandLayout();
        DynamicIslandContentFakeView dynamicIslandContentFakeView = this.getFakeView();
        if (dynamicIslandContentFakeView != null) {
            dynamicIslandContentFakeView.suppressBigIslandChange(true);
        }
        dynamicIslandContentFakeView = this.getBigIslandAnimState();
        if (this.expandedToTempHiddenAnimating) {
            dynamicIslandContentFakeView.add(CONTAINER_ALPHA, 0.0f, new long[0]);
            this.needResetContainerAlpha = true;
        }
        if (CommonUtils.INSTANCE.getIS_TABLET()) {
            long l = this.windowView.hasOtherBigIsland(dynamicIslandContentView) ? 0L : 50L;
            IStateStyle iStateStyle = FolmeKt.getFolme((FolmeObject)this).setTo((Object)this.getMultiTopIslandAnimState(dynamicIslandContentView));
            dynamicIslandContentFakeView = this.getBigIslandAnimState();
            AnimConfig animConfig = new AnimConfig().setSpecial(CONTAINER_ALPHA, this.SHOW_EASE, l, new float[0]);
            animConfig = animConfig.setSpecial(CONTAINER_BLUR, this.SHOW_EASE, l, new float[0]);
            animConfig = animConfig.setSpecial(CONTAINER_CLIP_START_PROGRESS, this.SHOW_EASE, l, new float[0]);
            animConfig = animConfig.setSpecial(CONTAINER_CLIP_END_PROGRESS, this.SHOW_EASE, l, new float[0]);
            animConfig = animConfig.setSpecial(CONTAINER_CLIP_TOP_PROGRESS, this.SHOW_EASE, l, new float[0]);
            animConfig = animConfig.setSpecial(CONTAINER_CLIP_BOTTOM_PROGRESS, this.SHOW_EASE, l, new float[0]);
            animConfig = animConfig.setSpecial(BIG_ISLAND_SCALE, this.SHOW_EASE, l, new float[0]);
            animConfig = animConfig.setSpecial(BIG_ISLAND_ALPHA, this.SHOW_EASE, l, new float[0]);
            animConfig = animConfig.setSpecial(BIG_ISLAND_BLUR, this.SHOW_EASE, l, new float[0]);
            animConfig = animConfig.addListeners(new TransitionListener[]{this.appExpandedToBigIslandAnimListener(dynamicIslandContentView, bl)});
            iStateStyle.to((Object)dynamicIslandContentFakeView, new AnimConfig[]{animConfig});
        } else {
            IFolme iFolme = FolmeKt.getFolme((FolmeObject)this);
            AnimConfig animConfig = new AnimConfig().setSpecial(CONTAINER_CLIP_START_PROGRESS, this.APPEAR_EASE, new float[0]);
            animConfig = animConfig.setSpecial(CONTAINER_CLIP_END_PROGRESS, this.APPEAR_EASE, new float[0]);
            animConfig = animConfig.setSpecial(CONTAINER_ALPHA, FolmeEase.linear((long)1L), new float[0]);
            animConfig = animConfig.setSpecial(BIG_ISLAND_SCALE, this.APPEAR_EASE, new float[0]);
            animConfig = animConfig.setSpecial(BIG_ISLAND_ALPHA, this.HIDDEN_EASE, 100L, new float[0]);
            animConfig = animConfig.setSpecial(BIG_ISLAND_AREA_LEFT_TRANS_X, this.APPEAR_EASE, new float[0]);
            animConfig = animConfig.setSpecial(BIG_ISLAND_AREA_RIGHT_TRANS_X, this.APPEAR_EASE, new float[0]);
            animConfig = animConfig.addListeners(new TransitionListener[]{this.appExpandedToBigIslandAnimListener(dynamicIslandContentView, bl)});
            iFolme.to((Object)dynamicIslandContentFakeView, new AnimConfig[]{animConfig});
        }
        this.fakeViewToBigIsland(dynamicIslandContentView, bl);
    }

    public final void appExpandedToHiddenAnimation(DynamicIslandContentView dynamicIslandContentView) {
        o.g((Object)((Object)dynamicIslandContentView), (String)"view");
        this.expandedToHiddenAnimation(dynamicIslandContentView, true);
    }

    public final void appExpandedToMiniWindowExpandedAnimation(DynamicIslandContentView dynamicIslandContentView) {
        DynamicIslandEventCoordinator dynamicIslandEventCoordinator;
        o.g((Object)((Object)dynamicIslandContentView), (String)"view");
        this.setViewVisible(dynamicIslandContentView, 4);
        DynamicIslandContentFakeView dynamicIslandContentFakeView = dynamicIslandContentView.getFakeView();
        if (dynamicIslandContentFakeView != null && (dynamicIslandEventCoordinator = dynamicIslandContentFakeView.getDynamicIslandEventCoordinator()) != null) {
            DynamicIslandContentFakeView dynamicIslandContentFakeView2 = dynamicIslandContentView.getFakeView();
            dynamicIslandContentFakeView = dynamicIslandContentView.getCurrentIslandData();
            dynamicIslandContentFakeView = dynamicIslandContentFakeView != null ? dynamicIslandContentFakeView.getExtras() : null;
            dynamicIslandEventCoordinator.updateFreeformFakeView(dynamicIslandContentFakeView2, dynamicIslandContentView, (Bundle)dynamicIslandContentFakeView);
        }
    }

    public final void appExpandedToSmallIslandAnimation(DynamicIslandContentView dynamicIslandContentView) {
        o.g((Object)((Object)dynamicIslandContentView), (String)"view");
        this.appExpandedToSmallIslandAnimation(dynamicIslandContentView, true);
    }

    public final void appExpandedToSmallIslandAnimation(DynamicIslandContentView dynamicIslandContentView, boolean bl) {
        o.g((Object)((Object)dynamicIslandContentView), (String)"view");
        dynamicIslandContentView.updateBigIslandLayout();
        AnimState animState = this.getSmallIslandAnimState();
        int n = this.getAppAnimSmallX();
        if (n != 0) {
            animState.add(CONTAINER_X, n, new long[0]);
        }
        if (this.expandedToTempHiddenAnimating) {
            animState.add(CONTAINER_ALPHA, 0.0f, new long[0]);
            this.needResetContainerAlpha = true;
        }
        IFolme iFolme = FolmeKt.getFolme((FolmeObject)this);
        AnimConfig animConfig = new AnimConfig().addListeners(new TransitionListener[]{new DynamicIslandAnimListener(this, dynamicIslandContentView, bl){
            final boolean $isAppClose;
            final DynamicIslandContentView $view;
            final DynamicIslandAnimationDelegate this$0;
            {
                this.this$0 = dynamicIslandAnimationDelegate;
                this.$view = dynamicIslandContentView;
                this.$isAppClose = bl;
                super(dynamicIslandAnimationDelegate);
            }

            public void onBegin(Object object) {
                this.this$0.setAppClosing(true);
                super.onBegin(object);
                object = this.$view.getExpandedView();
                if (object != null) {
                    object.setVisibility(4);
                }
                if (!this.this$0.getIslandWindowAnimRunning()) {
                    DynamicIslandAnimationDelegate.access$setViewVisible(this.this$0, this.$view, 0);
                    object = this.$view.getSmallIslandView();
                    if (object != null) {
                        object.setVisibility(0);
                    }
                    object = this.$view.getFakeView();
                    if (object != null) {
                        ((DynamicIslandContentFakeView)((Object)object)).setVisibility(4);
                    }
                } else {
                    if (!this.this$0.getExpandedToTempHiddenAnimating()) {
                        DynamicIslandAnimationDelegate.access$setViewVisible(this.this$0, this.$view, 4);
                    }
                    if ((object = DynamicIslandAnimationDelegate.access$getFakeView(this.this$0)) != null) {
                        ((DynamicIslandContentFakeView)((Object)object)).setVisibility(0);
                    }
                }
                DynamicIslandScenarioUtils.INSTANCE.setDynamicIslandScenarioState(438L, true);
            }

            public void onCancel(Object object) {
                this.this$0.setAppClosing(false);
                super.onCancel(object);
                if (this.this$0.getExpandedToTempHiddenAnimating()) {
                    if (this.this$0.getIslandWindowAnimRunning()) {
                        DynamicIslandAnimationDelegate.access$setViewVisible(this.this$0, this.$view, 4);
                    }
                    this.this$0.setExpandedToTempHiddenAnimating(false);
                }
                if (this.this$0.getIslandWindowAnimRunning() && !this.$isAppClose) {
                    if (!DynamicIslandAnimationDelegate.access$getWindowView$p(this.this$0).getSupportMiniWindowEndPositionChange() || !((DynamicIslandBaseContentView)((Object)(object = this.$view))).pkgHasMultIslands((DynamicIslandContentView)((Object)object)) || this.this$0.getIslandStateChanged() && !(this.$view.getState() instanceof DynamicIslandState.Hidden)) {
                        DynamicIslandAnimationDelegate.access$setViewVisible(this.this$0, this.$view, 0);
                        object = this.$view.getFakeView();
                        if (object != null) {
                            ((DynamicIslandContentFakeView)((Object)object)).setVisibility(4);
                        }
                    }
                    if ((object = this.$view.getSmallIslandView()) != null) {
                        object.setVisibility(0);
                    }
                }
                DynamicIslandScenarioUtils.INSTANCE.setDynamicIslandScenarioState(438L, false);
            }

            public void onComplete(Object object) {
                this.this$0.setAppClosing(false);
                super.onComplete(object);
                if (this.this$0.getExpandedToTempHiddenAnimating()) {
                    if (this.this$0.getIslandWindowAnimRunning()) {
                        DynamicIslandAnimationDelegate.access$setViewVisible(this.this$0, this.$view, 4);
                    }
                    this.this$0.resetContainerAlpha();
                    this.this$0.setExpandedToTempHiddenAnimating(false);
                }
                if (this.this$0.getIslandWindowAnimRunning() && !this.$isAppClose) {
                    DynamicIslandAnimationDelegate.access$setViewVisible(this.this$0, this.$view, 0);
                    object = this.$view.getSmallIslandView();
                    if (object != null) {
                        object.setVisibility(0);
                    }
                    object = this.$view.getFakeView();
                    if (object != null) {
                        ((DynamicIslandContentFakeView)((Object)object)).setVisibility(4);
                    }
                }
                DynamicIslandScenarioUtils.INSTANCE.setDynamicIslandScenarioState(438L, false);
            }
        }});
        iFolme.to((Object)animState, new AnimConfig[]{animConfig});
        this.fakeViewToSmallIsland(dynamicIslandContentView, bl);
    }

    public final void appExpandedToTempHiddenAnimation(DynamicIslandContentView dynamicIslandContentView) {
        o.g((Object)((Object)dynamicIslandContentView), (String)"view");
        DynamicIslandAnimationDelegate.expandedToTempHiddenAnimation$default(this, dynamicIslandContentView, false, 2, null);
    }

    public final void beforeBigIslandToTempHiddenAnimation(DynamicIslandContentView dynamicIslandBaseContentView) {
        o.g((Object)((Object)dynamicIslandBaseContentView), (String)"view");
        this.setViewVisible(dynamicIslandBaseContentView, 8);
        dynamicIslandBaseContentView = dynamicIslandBaseContentView.getFakeView();
        if (dynamicIslandBaseContentView != null) {
            ((DynamicIslandContentFakeView)dynamicIslandBaseContentView).setVisibility(8);
        }
    }

    public final void beforeSmallIslandToTempHiddenAnimation(DynamicIslandContentView dynamicIslandBaseContentView) {
        o.g((Object)((Object)dynamicIslandBaseContentView), (String)"view");
        this.setViewVisible(dynamicIslandBaseContentView, 8);
        dynamicIslandBaseContentView = dynamicIslandBaseContentView.getFakeView();
        if (dynamicIslandBaseContentView != null) {
            ((DynamicIslandContentFakeView)dynamicIslandBaseContentView).setVisibility(8);
        }
    }

    public final void bigIslandChangedAnimation(DynamicIslandContentView dynamicIslandContentView) {
        boolean bl;
        DynamicIslandWindowState dynamicIslandWindowState;
        boolean bl2;
        boolean bl3 = true;
        o.g((Object)((Object)dynamicIslandContentView), (String)"view");
        Object object = CommonUtils.INSTANCE;
        if (object.getIS_TABLET() && (bl2 = (dynamicIslandWindowState = dynamicIslandContentView.getWindowState()) != null ? o.c((Object)dynamicIslandWindowState.getConfigChange(), (Object)Boolean.TRUE) : false)) {
            FolmeKt.getFolme((FolmeObject)this).cancel();
        }
        if (object.getIS_TABLET() && !(bl = this.lastBigIslandStart == this.getBigIslandStart())) {
            Log.i((String)"DynamicIslandAnimDebug", (String)"bigIslandChangedAnimation: bigIslandStart is change");
            this.bigIslandChangedNoAnimation(dynamicIslandContentView);
            return;
        }
        dynamicIslandContentView.updateBigIslandLayout();
        FolmeKt.getFolme((FolmeObject)this).to((Object)this.getBigIslandAnimState(), new AnimConfig[]{new AnimConfig().addListeners(new TransitionListener[]{new DynamicIslandAnimListener(this, dynamicIslandContentView){
            final DynamicIslandContentView $view;
            {
                this.$view = dynamicIslandContentView;
                super(dynamicIslandAnimationDelegate);
            }

            public void onBegin(Object object) {
                super.onBegin(object);
            }

            public void onComplete(Object object) {
                super.onComplete(object);
                object = this.$view.getExpandedView();
                if (object != null) {
                    object.setVisibility(4);
                }
            }
        }})});
        if (!this.getIslandWindowAnimRunning() || (bl = (object = this.getFakeView()) != null && ((DynamicIslandContentFakeView)((Object)object)).getBigIslandViewNeedAnim()) || (bl = (object = this.getFakeView()) != null && ((DynamicIslandContentFakeView)((Object)object)).getForceUpdateBigIslandView() ? bl3 : false)) {
            this.fakeViewToBigIsland(dynamicIslandContentView, false);
        }
    }

    public final void bigIslandChangedNoAnimation(DynamicIslandContentView dynamicIslandContentView) {
        boolean bl;
        DynamicIslandWindowState dynamicIslandWindowState;
        boolean bl2;
        o.g((Object)((Object)dynamicIslandContentView), (String)"view");
        dynamicIslandContentView.updateBigIslandLayout();
        CommonUtils commonUtils = CommonUtils.INSTANCE;
        if (commonUtils.getIS_TABLET() && (bl2 = (dynamicIslandWindowState = dynamicIslandContentView.getWindowState()) != null ? o.c((Object)dynamicIslandWindowState.getConfigChange(), (Object)Boolean.TRUE) : false)) {
            FolmeKt.getFolme((FolmeObject)this).cancel();
        }
        if (commonUtils.getIS_TABLET() && !(bl = this.lastBigIslandStart == this.getBigIslandStart())) {
            this.lastBigIslandStart = this.getBigIslandStart();
            FolmeKt.getFolme((FolmeObject)this).cancel();
        }
        FolmeKt.getFolme((FolmeObject)this).setTo((Object)this.getBigIslandAnimState(), new AnimConfig[]{new AnimConfig().addListeners(new TransitionListener[]{new DynamicIslandAnimListener(this, dynamicIslandContentView){
            final DynamicIslandContentView $view;
            {
                this.$view = dynamicIslandContentView;
                super(dynamicIslandAnimationDelegate);
            }

            public void onBegin(Object object) {
                super.onBegin(object);
            }

            public void onComplete(Object object) {
                super.onComplete(object);
                object = this.$view.getExpandedView();
                if (object != null) {
                    object.setVisibility(4);
                }
            }
        }})});
        if (!this.getIslandWindowAnimRunning()) {
            this.fakeViewToBigIsland(dynamicIslandContentView, false);
        }
    }

    public final void bigIslandScaleAnimation(DynamicIslandContentView dynamicIslandContentView, long l) {
        o.g((Object)((Object)dynamicIslandContentView), (String)"view");
        if (this.shouldBlockScale) {
            Log.w((String)"DynamicIslandAnimDebug", (String)"bigIslandScaleAnimation: Cancelled because of block scale.");
            return;
        }
        Log.i((String)"DynamicIslandAnimDebug", (String)"bigIslandScaleAnimation");
        float f = this.getBigIslandStart();
        AnimConfig animConfig = new AnimConfig().setSpecial(BIG_ISLAND_SCALE, this.EASE_SININOUT_025, l, new float[0]).setSpecial(CONTAINER_CLIP_START_PROGRESS, this.EASE_SININOUT_025, l, new float[0]).setSpecial(CONTAINER_CLIP_END_PROGRESS, this.EASE_SININOUT_025, l, new float[0]).setSpecial(CONTAINER_CLIP_TOP_PROGRESS, this.EASE_SININOUT_025, l, new float[0]).setSpecial(CONTAINER_CLIP_BOTTOM_PROGRESS, this.EASE_SININOUT_025, l, new float[0]);
        FolmeKt.getFolme((FolmeObject)this).to((Object)this.getBigIslandZoomInAnimState(), new AnimConfig[]{animConfig.addListeners(new TransitionListener[]{new TransitionListener(this, f, dynamicIslandContentView){
            final float $bigIslandLeft;
            final DynamicIslandContentView $view;
            final DynamicIslandAnimationDelegate this$0;
            {
                this.this$0 = dynamicIslandAnimationDelegate;
                this.$bigIslandLeft = f2;
                this.$view = dynamicIslandContentView;
            }

            public void onBegin(Object object) {
                super.onBegin(object);
                DynamicIslandAnimationCallback dynamicIslandAnimationCallback = DynamicIslandAnimationDelegate.access$getDynamicIslandAnimController$p(this.this$0).getAnimationCallback$miui_dynamicisland_release();
                DynamicIslandAnimationType dynamicIslandAnimationType = DynamicIslandAnimationType.ALL;
                DynamicIslandAnimationCallbackType dynamicIslandAnimationCallbackType = DynamicIslandAnimationCallbackType.ANIM_START;
                o.e((Object)object, (String)"null cannot be cast to non-null type kotlin.String");
                dynamicIslandAnimationCallback.executeCallback(dynamicIslandAnimationType, dynamicIslandAnimationCallbackType, (String)object);
            }

            public void onCancel(Object object) {
                super.onCancel(object);
                DynamicIslandAnimationCallback dynamicIslandAnimationCallback = DynamicIslandAnimationDelegate.access$getDynamicIslandAnimController$p(this.this$0).getAnimationCallback$miui_dynamicisland_release();
                DynamicIslandAnimationType dynamicIslandAnimationType = DynamicIslandAnimationType.ALL;
                DynamicIslandAnimationCallbackType dynamicIslandAnimationCallbackType = DynamicIslandAnimationCallbackType.ANIM_CANCEL;
                o.e((Object)object, (String)"null cannot be cast to non-null type kotlin.String");
                dynamicIslandAnimationCallback.executeCallback(dynamicIslandAnimationType, dynamicIslandAnimationCallbackType, (String)object);
            }

            public void onComplete(Object object) {
                super.onComplete(object);
                Object object2 = this.$view.getExpandedView();
                if (object2 != null) {
                    object2.setVisibility(4);
                }
                DynamicIslandAnimationCallback dynamicIslandAnimationCallback = DynamicIslandAnimationDelegate.access$getDynamicIslandAnimController$p(this.this$0).getAnimationCallback$miui_dynamicisland_release();
                object2 = DynamicIslandAnimationType.ALL;
                DynamicIslandAnimationCallbackType dynamicIslandAnimationCallbackType = DynamicIslandAnimationCallbackType.ANIM_FINISH;
                o.e((Object)object, (String)"null cannot be cast to non-null type kotlin.String");
                dynamicIslandAnimationCallback.executeCallback((DynamicIslandAnimationType)((Object)object2), dynamicIslandAnimationCallbackType, (String)object);
                object = this.$view.getDynamicIslandEventCoordinator();
                object = object != null && (object = ((DynamicIslandEventCoordinator)object).getBigIslandStateHandler()) != null ? ((BigIslandStateHandler)object).getCurrent() : null;
                if (o.c((Object)object, (Object)((Object)this.$view))) {
                    object = new AnimConfig();
                    object2 = DynamicIslandAnimationDelegate.Companion;
                    object = object.setSpecial(object2.getBIG_ISLAND_SCALE(), this.this$0.getEASE_SININOUT_025(), new float[0]).setSpecial(object2.getCONTAINER_CLIP_START_PROGRESS(), this.this$0.getEASE_SININOUT_025(), new float[0]).setSpecial(object2.getCONTAINER_CLIP_END_PROGRESS(), this.this$0.getEASE_SININOUT_025(), new float[0]).setSpecial(object2.getCONTAINER_CLIP_TOP_PROGRESS(), this.this$0.getEASE_SININOUT_025(), new float[0]).setSpecial(object2.getCONTAINER_CLIP_BOTTOM_PROGRESS(), this.this$0.getEASE_SININOUT_025(), new float[0]);
                    FolmeKt.getFolme((FolmeObject)this.this$0).to((Object)DynamicIslandAnimationDelegate.access$getBigIslandZoomOutAnimState(this.this$0), new AnimConfig[]{object.addListeners(new TransitionListener[]{new TransitionListener(this.this$0){
                        final DynamicIslandAnimationDelegate this$0;
                        {
                            this.this$0 = dynamicIslandAnimationDelegate;
                        }

                        public void onUpdate(Object object, Collection<UpdateInfo> collection) {
                            super.onUpdate(object, collection);
                            this.this$0.scheduleUpdate();
                        }
                    }})});
                }
            }

            public void onUpdate(Object object, Collection<UpdateInfo> collection) {
                super.onUpdate(object, collection);
                if (CommonUtils.INSTANCE.getIS_TABLET() && this.this$0.getBigIslandStart() != this.$bigIslandLeft) {
                    FolmeKt.getFolme((FolmeObject)this.this$0).cancel();
                    object = this.$view.getExpandedView();
                    if (object != null) {
                        object.setVisibility(4);
                    }
                    FolmeKt.getFolme((FolmeObject)this.this$0).setTo((Object)DynamicIslandAnimationDelegate.access$getBigIslandAnimState(this.this$0), new AnimConfig[]{new AnimConfig().addListeners(new TransitionListener[]{new TransitionListener(this.this$0){
                        final DynamicIslandAnimationDelegate this$0;
                        {
                            this.this$0 = dynamicIslandAnimationDelegate;
                        }

                        public void onUpdate(Object object, Collection<? extends UpdateInfo> collection) {
                            super.onUpdate(object, collection);
                            this.this$0.scheduleUpdate();
                        }
                    }})});
                }
                this.this$0.scheduleUpdate();
            }
        }})});
    }

    public final void bigIslandScheduleUpdate() {
        FrameLayout frameLayout;
        if (CommonUtils.INSTANCE.getIS_TABLET() && (frameLayout = this.view.getBigIslandView()) != null) {
            frameLayout.setTranslationX(this.bigIslandTransX);
        }
        if ((frameLayout = this.view.getBigIslandView()) != null) {
            frameLayout.setScaleX(this.bigIslandScale);
        }
        frameLayout = this.view.getBigIslandView();
        if (frameLayout != null) {
            frameLayout.setScaleY(this.bigIslandScale);
        }
        frameLayout = this.view.getBigIslandView();
        if (frameLayout != null) {
            frameLayout.setAlpha(this.bigIslandAlpha);
        }
        frameLayout = this.view.getBigIslandView();
        if (frameLayout != null) {
            frameLayout.setTranslationY(this.bigIslandTransY);
        }
        frameLayout = this.view.getBigIslandAreaLeft();
        if (frameLayout != null) {
            frameLayout.setTranslationX(this.bigIslandAreaLeft);
        }
        frameLayout = this.view.getBigIslandAreaRight();
        if (frameLayout != null) {
            frameLayout.setTranslationX(this.bigIslandAreaRight);
        }
        DynamicIslandBigIslandView dynamicIslandBigIslandView = this.view.getBigIslandView();
        if (dynamicIslandBigIslandView != null) {
            float f = this.containerClipStartProgress;
            float f2 = this.containerX;
            float f3 = this.containerClipTopProgress;
            float f4 = this.containerTransY;
            dynamicIslandBigIslandView.updateGlowEffectAnim$miui_dynamicisland_release(f + f2, f3 + f4, this.containerClipEndProgress + f2, this.containerClipBottomProgress + f4, this.containerClipRadius());
            frameLayout = this.view.getBackgroundView();
            f = frameLayout != null ? frameLayout.getZ() : 0.0f;
            dynamicIslandBigIslandView.setZOrderOfGlowEffect$miui_dynamicisland_release(f);
            dynamicIslandBigIslandView.setAlphaOfGlowEffect$miui_dynamicisland_release(this.bigIslandAlpha);
        }
        if (this.supportBlur && (frameLayout = this.view.getBigIslandView()) != null) {
            this.updateContentBlur((View)frameLayout, this.bigIslandBlur);
        }
    }

    public final void bigIslandToAppExpandedAnimation(DynamicIslandContentView dynamicIslandContentView) {
        o.g((Object)((Object)dynamicIslandContentView), (String)"view");
        this.bigIslandToHiddenAnimation(dynamicIslandContentView, false);
        DynamicIslandEventCoordinator dynamicIslandEventCoordinator = dynamicIslandContentView.getDynamicIslandEventCoordinator();
        if (dynamicIslandEventCoordinator != null) {
            dynamicIslandEventCoordinator.updateView(dynamicIslandContentView);
        }
    }

    public final void bigIslandToAppExpandedNoAnimation(DynamicIslandContentView dynamicIslandContentView) {
        o.g((Object)((Object)dynamicIslandContentView), (String)"view");
        this.bigIslandToHiddenNoAnimation(dynamicIslandContentView);
        DynamicIslandEventCoordinator dynamicIslandEventCoordinator = dynamicIslandContentView.getDynamicIslandEventCoordinator();
        if (dynamicIslandEventCoordinator != null) {
            dynamicIslandEventCoordinator.updateView(dynamicIslandContentView);
        }
    }

    public final void bigIslandToDeletedAnimation(DynamicIslandContentView dynamicIslandContentView) {
        Object object;
        o.g((Object)((Object)dynamicIslandContentView), (String)"view");
        EaseManager.EaseStyle easeStyle = this.SHOW_EASE;
        if (this.dynamicIslandAnimController.getDynamicIslandWindowState().isToScreenLockNoAnimation() || !DynamicIslandAnimUtils.INSTANCE.supportShowElementAnim()) {
            easeStyle = this.HIDDEN_EASE;
        }
        if (CommonUtils.INSTANCE.getIS_TABLET() && ((object = dynamicIslandContentView.getCurrentIslandData()) == null || (object = object.getProperties()) == null || (Integer)object != 0)) {
            easeStyle = new AnimConfig().setSpecial(CONTAINER_CLIP_START_PROGRESS, this.ALPHA_EASE, new float[0]).setSpecial(CONTAINER_CLIP_END_PROGRESS, this.ALPHA_EASE, new float[0]).setSpecial(CONTAINER_ALPHA, this.ALPHA_EASE, new float[0]).setSpecial(BIG_ISLAND_SCALE, this.ALPHA_EASE, new float[0]).setSpecial(BIG_ISLAND_ALPHA, this.ALPHA_EASE, new float[0]).setSpecial(BIG_ISLAND_BLUR, this.ALPHA_EASE, new float[0]);
            o.f((Object)easeStyle, (String)"setSpecial(...)");
        } else {
            AnimConfig animConfig = new AnimConfig().setSpecial(CONTAINER_CLIP_START_PROGRESS, easeStyle, new float[0]).setSpecial(CONTAINER_CLIP_END_PROGRESS, easeStyle, new float[0]);
            FloatProperty<DynamicIslandAnimationDelegate> floatProperty = CONTAINER_ALPHA;
            object = this.getSupposedContainerAlpha() == 0.0f ? easeStyle : FolmeEase.linear((long)100L);
            long l = this.getSupposedContainerAlpha() == 0.0f ? 100L : 400L;
            easeStyle = animConfig.setSpecial(floatProperty, (EaseManager.EaseStyle)object, l, new float[0]).setSpecial(BIG_ISLAND_SCALE, easeStyle, new float[0]).setSpecial(BIG_ISLAND_ALPHA, this.ALPHA_EASE, new float[0]).setSpecial(BIG_ISLAND_BLUR, this.ALPHA_EASE, new float[0]).setSpecial(BIG_ISLAND_AREA_LEFT_TRANS_X, easeStyle, new float[0]).setSpecial(BIG_ISLAND_AREA_RIGHT_TRANS_X, easeStyle, new float[0]);
            o.f((Object)easeStyle, (String)"setSpecial(...)");
        }
        FolmeKt.getFolme((FolmeObject)this).to((Object)this.getCutoutAnimState(), new AnimConfig[]{easeStyle.addListeners(new TransitionListener[]{new DynamicIslandAnimListener(this, dynamicIslandContentView){
            final DynamicIslandContentView $view;
            final DynamicIslandAnimationDelegate this$0;
            {
                this.this$0 = dynamicIslandAnimationDelegate;
                this.$view = dynamicIslandContentView;
                super(dynamicIslandAnimationDelegate);
            }

            public void onBegin(Object object) {
                super.onBegin(object);
                DynamicIslandScenarioUtils.INSTANCE.setDynamicIslandScenarioState(435L, true);
                DynamicIslandAnimationCallback dynamicIslandAnimationCallback = DynamicIslandAnimationDelegate.access$getDynamicIslandAnimController$p(this.this$0).getAnimationCallback$miui_dynamicisland_release();
                DynamicIslandAnimationType dynamicIslandAnimationType = DynamicIslandAnimationType.BIG_TO_DELETED;
                DynamicIslandAnimationCallbackType dynamicIslandAnimationCallbackType = DynamicIslandAnimationCallbackType.ANIM_START;
                o.e((Object)object, (String)"null cannot be cast to non-null type kotlin.String");
                dynamicIslandAnimationCallback.executeCallback(dynamicIslandAnimationType, dynamicIslandAnimationCallbackType, (String)object);
            }

            public void onCancel(Object object) {
                super.onCancel(object);
                DynamicIslandScenarioUtils.INSTANCE.setDynamicIslandScenarioState(435L, false);
                DynamicIslandAnimationDelegate.removeViewFromWindow$default(this.this$0, this.$view, false, 2, null);
            }

            public void onComplete(Object object) {
                super.onComplete(object);
                DynamicIslandScenarioUtils.INSTANCE.setDynamicIslandScenarioState(435L, false);
                DynamicIslandAnimationDelegate.removeViewFromWindow$default(this.this$0, this.$view, false, 2, null);
                DynamicIslandAnimationDelegate.access$getAnimationDelegateHelper$p(this.this$0).requestUpdateHeadsUpLocation(DynamicIslandAnimationType.BIG_TO_DELETED, this.$view);
            }
        }})});
        this.fakeViewToDeleted(dynamicIslandContentView);
    }

    public final void bigIslandToDeletedNoAnimation(DynamicIslandContentView dynamicIslandContentView) {
        o.g((Object)((Object)dynamicIslandContentView), (String)"view");
        FolmeKt.getFolme((FolmeObject)this).setTo((Object)this.getCutoutAnimState(), new AnimConfig[]{new AnimConfig().addListeners(new TransitionListener[]{new DynamicIslandAnimListener(this, dynamicIslandContentView){
            final DynamicIslandContentView $view;
            final DynamicIslandAnimationDelegate this$0;
            {
                this.this$0 = dynamicIslandAnimationDelegate;
                this.$view = dynamicIslandContentView;
                super(dynamicIslandAnimationDelegate);
            }

            public void onBegin(Object object) {
                super.onBegin(object);
                DynamicIslandAnimationCallback dynamicIslandAnimationCallback = DynamicIslandAnimationDelegate.access$getDynamicIslandAnimController$p(this.this$0).getAnimationCallback$miui_dynamicisland_release();
                DynamicIslandAnimationType dynamicIslandAnimationType = DynamicIslandAnimationType.BIG_TO_DELETED;
                DynamicIslandAnimationCallbackType dynamicIslandAnimationCallbackType = DynamicIslandAnimationCallbackType.ANIM_START;
                o.e((Object)object, (String)"null cannot be cast to non-null type kotlin.String");
                dynamicIslandAnimationCallback.executeCallback(dynamicIslandAnimationType, dynamicIslandAnimationCallbackType, (String)object);
                DynamicIslandAnimationDelegate.access$getAnimationDelegateHelper$p(this.this$0).requestUpdateHeadsUpLocation(dynamicIslandAnimationType, this.$view);
                this.this$0.removeViewFromWindow(this.$view, true);
            }
        }})});
        this.fakeViewToDeleted(dynamicIslandContentView);
    }

    /*
     * Unable to fully structure code
     */
    public final void bigIslandToExpandedAnimation(DynamicIslandContentView var1_1) {
        block3: {
            block2: {
                o.g((Object)var1_1, (String)"view");
                var5_2 = this.getExpandedAnimState();
                if (!CommonUtils.INSTANCE.getIS_TABLET()) break block2;
                var4_3 = this.PAD_NORMAL_HIDDEN_EASE;
                this.setViewVisible(var1_1, 0);
                if (!this.supportBlur) ** GOTO lbl-1000
                var6_4 = var1_1.getContext();
                o.f((Object)var6_4, (String)"getContext(...)");
                if (MiBlurCompat.getBackgroundBlurOpened((Context)var6_4)) {
                    var4_3 = this.PAD_HIGHT_HIDDEN_EASE;
                    var2_5 = 50L;
                } else lbl-1000:
                // 2 sources

                {
                    var2_5 = 70L;
                }
                var1_1.cancelTransXAnim(this.bigIslandTransX);
                var4_3 = new AnimConfig().setSpecial(DynamicIslandAnimationDelegate.CONTAINER_TRANS_Y, this.PAD_CHANGE_EASE, new float[0]).setSpecial(DynamicIslandAnimationDelegate.CONTAINER_X, this.PAD_CHANGE_EASE, new float[0]).setSpecial(DynamicIslandAnimationDelegate.CONTAINER_CLIP_BOTTOM_PROGRESS, this.PAD_CHANGE_EASE, new float[0]).setSpecial(DynamicIslandAnimationDelegate.CONTAINER_CLIP_END_PROGRESS, this.PAD_CHANGE_EASE, new float[0]).setSpecial(DynamicIslandAnimationDelegate.CONTAINER_CLIP_START_PROGRESS, this.PAD_CHANGE_EASE, new float[0]).setSpecial(DynamicIslandAnimationDelegate.CONTAINER_CLIP_TOP_PROGRESS, this.PAD_CHANGE_EASE, new float[0]).setSpecial(DynamicIslandAnimationDelegate.EXPANDED_SCALE_X, this.PAD_CHANGE_EASE, new float[0]).setSpecial(DynamicIslandAnimationDelegate.EXPANDED_SCALE_Y, this.PAD_CHANGE_EASE, new float[0]).setSpecial(DynamicIslandAnimationDelegate.EXPANDED_ALPHA, this.PAD_SHOW_EASE, var2_5, new float[0]).setSpecial(DynamicIslandAnimationDelegate.EXPANDED_BLUR, this.PAD_SHOW_EASE, var2_5, new float[0]).setSpecial(DynamicIslandAnimationDelegate.BIG_ISLAND_SCALE, this.PAD_CHANGE_EASE, new float[0]).setSpecial(DynamicIslandAnimationDelegate.BIG_ISLAND_BLUR, var4_3, new float[0]).setSpecial(DynamicIslandAnimationDelegate.BIG_ISLAND_ALPHA, var4_3, new float[0]).setSpecial(DynamicIslandAnimationDelegate.BIG_ISLAND_TRANS_X, this.PAD_CHANGE_EASE, new float[0]).setSpecial(DynamicIslandAnimationDelegate.EXPANDED_TRANS_Y, this.PAD_CHANGE_EASE, new float[0]).setSpecial(DynamicIslandAnimationDelegate.BIG_ISLAND_TRANS_Y, this.PAD_CHANGE_EASE, new float[0]).setSpecial(DynamicIslandAnimationDelegate.EXPANDED_TRANS_X, this.PAD_CHANGE_EASE, new float[0]);
                break block3;
            }
            var4_3 = new AnimConfig().setSpecial(DynamicIslandAnimationDelegate.CONTAINER_TRANS_Y, this.CHANGE_EASE, new float[0]).setSpecial(DynamicIslandAnimationDelegate.CONTAINER_CLIP_BOTTOM_PROGRESS, this.CHANGE_EASE, new float[0]).setSpecial(DynamicIslandAnimationDelegate.CONTAINER_CLIP_END_PROGRESS, this.CHANGE_EASE, new float[0]).setSpecial(DynamicIslandAnimationDelegate.CONTAINER_CLIP_START_PROGRESS, this.CHANGE_EASE, new float[0]).setSpecial(DynamicIslandAnimationDelegate.CONTAINER_CLIP_TOP_PROGRESS, this.CHANGE_EASE, new float[0]).setSpecial(DynamicIslandAnimationDelegate.EXPANDED_SCALE_X, this.CHANGE_EASE, new float[0]).setSpecial(DynamicIslandAnimationDelegate.EXPANDED_SCALE_Y, this.CHANGE_EASE, new float[0]).setSpecial(DynamicIslandAnimationDelegate.EXPANDED_ALPHA, this.SHOW_EASE, 50L, new float[0]).setSpecial(DynamicIslandAnimationDelegate.EXPANDED_BLUR, this.SHOW_EASE, 50L, new float[0]).setSpecial(DynamicIslandAnimationDelegate.BIG_ISLAND_SCALE, this.CHANGE_EASE, new float[0]).setSpecial(DynamicIslandAnimationDelegate.BIG_ISLAND_ALPHA, this.HIDDEN_EASE, new float[0]).setSpecial(DynamicIslandAnimationDelegate.BIG_ISLAND_BLUR, this.HIDDEN_EASE, new float[0]).setSpecial(DynamicIslandAnimationDelegate.EXPANDED_TRANS_Y, this.CHANGE_EASE, new float[0]).setSpecial(DynamicIslandAnimationDelegate.BIG_ISLAND_TRANS_Y, this.CHANGE_EASE, new float[0]);
        }
        FolmeKt.getFolme((FolmeObject)this).to((Object)var5_2, new AnimConfig[]{var4_3.addListeners(new TransitionListener[]{new DynamicIslandAnimListener(this, var1_1){
            final DynamicIslandContentView $view;
            final DynamicIslandAnimationDelegate this$0;
            {
                this.this$0 = dynamicIslandAnimationDelegate;
                this.$view = dynamicIslandContentView;
                super(dynamicIslandAnimationDelegate);
            }

            public void onBegin(Object object) {
                super.onBegin(object);
                DynamicIslandAnimationDelegate.access$setBlockUpdatePosition$p(this.this$0, true);
                Object object2 = this.$view.getExpandedView();
                if (object2 != null) {
                    object2.setVisibility(0);
                }
                DynamicIslandAnimationDelegate.access$getAnimationDelegateHelper$p(this.this$0).requestUpdateHeadsUpLocation(DynamicIslandAnimationType.BIG_TO_EXPANDED, this.$view);
                DynamicIslandAnimationCallback dynamicIslandAnimationCallback = DynamicIslandAnimationDelegate.access$getDynamicIslandAnimController$p(this.this$0).getAnimationCallback$miui_dynamicisland_release();
                object2 = DynamicIslandAnimationType.TO_EXPANDED;
                Object object3 = DynamicIslandAnimationCallbackType.ANIM_START;
                o.e((Object)object, (String)"null cannot be cast to non-null type kotlin.String");
                dynamicIslandAnimationCallback.executeCallback((DynamicIslandAnimationType)((Object)object2), (DynamicIslandAnimationCallbackType)((Object)object3), (String)object);
                object2 = DynamicIslandAnimationDelegate.access$getTAG$p(this.this$0);
                object3 = new StringBuilder();
                ((StringBuilder)object3).append("bigIslandToExpandedAnimation1 toTag ");
                ((StringBuilder)object3).append(object);
                Log.e((String)object2, (String)((StringBuilder)object3).toString());
                DynamicIslandAnimationDelegate.access$setAnimateExpanding(this.this$0, true);
                DynamicIslandScenarioUtils.INSTANCE.setDynamicIslandScenarioState(437L, true);
            }

            public void onCancel(Object object) {
                super.onCancel(object);
                DynamicIslandAnimationDelegate.access$setBlockUpdatePosition$p(this.this$0, false);
                DynamicIslandAnimationDelegate.access$setAnimateExpanding(this.this$0, false);
                DynamicIslandScenarioUtils.INSTANCE.setDynamicIslandScenarioState(437L, false);
            }

            public void onComplete(Object object) {
                super.onComplete(object);
                DynamicIslandAnimationDelegate.access$setBlockUpdatePosition$p(this.this$0, false);
                Object object2 = DynamicIslandAnimationDelegate.access$getTAG$p(this.this$0);
                Object object3 = new StringBuilder();
                ((StringBuilder)object3).append("bigIslandToExpandedAnimation2 toTag ");
                ((StringBuilder)object3).append(object);
                Log.e((String)object2, (String)((StringBuilder)object3).toString());
                object3 = DynamicIslandAnimationDelegate.access$getDynamicIslandAnimController$p(this.this$0).getAnimationCallback$miui_dynamicisland_release();
                DynamicIslandAnimationType dynamicIslandAnimationType = DynamicIslandAnimationType.TO_EXPANDED;
                object2 = DynamicIslandAnimationCallbackType.ANIM_FINISH;
                o.e((Object)object, (String)"null cannot be cast to non-null type kotlin.String");
                ((DynamicIslandAnimationCallback)object3).executeCallback(dynamicIslandAnimationType, (DynamicIslandAnimationCallbackType)((Object)object2), (String)object);
                DynamicIslandAnimationDelegate.access$setAnimateExpanding(this.this$0, false);
                object = this.$view.getExpandedView();
                if (object != null) {
                    object.sendAccessibilityEvent(128);
                }
                DynamicIslandScenarioUtils.INSTANCE.setDynamicIslandScenarioState(437L, false);
            }

            public void onUpdate(Object object, Collection<UpdateInfo> updateInfo2) {
                super.onUpdate(object, (Collection<UpdateInfo>)updateInfo2);
                if (updateInfo2 != null) {
                    object = this.$view;
                    for (UpdateInfo updateInfo2 : updateInfo2) {
                        if (!o.c((Object)updateInfo2.property, DynamicIslandAnimationDelegate.Companion.getBIG_ISLAND_SCALE())) continue;
                        ((DynamicIslandBaseContentView)((Object)object)).updateShadow((DynamicIslandBaseContentView)((Object)object), updateInfo2.getFloatValue() - 1.0f);
                    }
                }
            }
        }})});
        this.fakeViewToExpanded(var1_1, false);
    }

    public final void bigIslandToHiddenAnimation(DynamicIslandContentView dynamicIslandContentView) {
        o.g((Object)((Object)dynamicIslandContentView), (String)"view");
        this.bigIslandToHiddenAnimation(dynamicIslandContentView, true);
    }

    public final void bigIslandToHiddenAnimation(DynamicIslandContentView dynamicIslandContentView, boolean bl) {
        o.g((Object)((Object)dynamicIslandContentView), (String)"view");
        Object object = this.SHOW_EASE;
        if (this.dynamicIslandAnimController.getDynamicIslandWindowState().isToScreenLockNoAnimation() || !DynamicIslandAnimUtils.INSTANCE.supportShowElementAnim()) {
            object = this.HIDDEN_EASE;
        }
        if (CommonUtils.INSTANCE.getIS_TABLET()) {
            boolean bl2 = this.windowView.hasOtherBigIsland(dynamicIslandContentView);
            if (DeviceUtils.isLowLevel() && bl2 && o.c((Object)(object = (object = dynamicIslandContentView.getDynamicIslandEventCoordinator()) != null ? ((DynamicIslandEventCoordinator)object).getHandlingEvent() : null), (Object)DynamicIslandEvent.ConfigChanged.INSTANCE)) {
                FolmeKt.getFolme((FolmeObject)this).setTo((Object)this.getMultiTopIslandAnimState(dynamicIslandContentView));
                this.setViewVisible(dynamicIslandContentView, 8);
            } else {
                IFolme iFolme = FolmeKt.getFolme((FolmeObject)this);
                AnimState animState = this.getMultiTopIslandAnimState(dynamicIslandContentView);
                AnimConfig animConfig = new AnimConfig();
                FloatProperty<DynamicIslandAnimationDelegate> floatProperty = CONTAINER_ALPHA;
                object = bl2 ? this.PAD_BOTTOM_ISLAND_HIDDEN_EASE : this.ALPHA_EASE;
                floatProperty = animConfig.setSpecial(floatProperty, (EaseManager.EaseStyle)object, new float[0]);
                animConfig = CONTAINER_BLUR;
                object = bl2 ? this.PAD_BOTTOM_ISLAND_HIDDEN_EASE : this.ALPHA_EASE;
                floatProperty = floatProperty.setSpecial(animConfig, (EaseManager.EaseStyle)object, new float[0]);
                animConfig = CONTAINER_CLIP_START_PROGRESS;
                object = bl2 ? this.PAD_BOTTOM_ISLAND_HIDDEN_EASE : this.ALPHA_EASE;
                animConfig = floatProperty.setSpecial(animConfig, (EaseManager.EaseStyle)object, new float[0]);
                floatProperty = CONTAINER_CLIP_END_PROGRESS;
                object = bl2 ? this.PAD_BOTTOM_ISLAND_HIDDEN_EASE : this.ALPHA_EASE;
                floatProperty = animConfig.setSpecial(floatProperty, (EaseManager.EaseStyle)object, new float[0]);
                animConfig = CONTAINER_CLIP_TOP_PROGRESS;
                object = bl2 ? this.PAD_BOTTOM_ISLAND_HIDDEN_EASE : this.ALPHA_EASE;
                floatProperty = floatProperty.setSpecial(animConfig, (EaseManager.EaseStyle)object, new float[0]);
                animConfig = CONTAINER_CLIP_BOTTOM_PROGRESS;
                object = bl2 ? this.PAD_BOTTOM_ISLAND_HIDDEN_EASE : this.ALPHA_EASE;
                animConfig = floatProperty.setSpecial(animConfig, (EaseManager.EaseStyle)object, new float[0]);
                floatProperty = BIG_ISLAND_SCALE;
                object = bl2 ? this.PAD_BOTTOM_ISLAND_HIDDEN_EASE : this.ALPHA_EASE;
                animConfig = animConfig.setSpecial(floatProperty, (EaseManager.EaseStyle)object, new float[0]);
                floatProperty = BIG_ISLAND_ALPHA;
                object = bl2 ? this.PAD_BOTTOM_ISLAND_HIDDEN_EASE : this.ALPHA_EASE;
                floatProperty = animConfig.setSpecial(floatProperty, (EaseManager.EaseStyle)object, new float[0]);
                animConfig = BIG_ISLAND_BLUR;
                object = bl2 ? this.PAD_BOTTOM_ISLAND_HIDDEN_EASE : this.ALPHA_EASE;
                floatProperty = floatProperty.setSpecial(animConfig, (EaseManager.EaseStyle)object, new float[0]);
                animConfig = BIG_ISLAND_TRANS_X;
                object = bl2 ? this.PAD_BOTTOM_ISLAND_HIDDEN_EASE : this.ALPHA_EASE;
                animConfig = floatProperty.setSpecial(animConfig, (EaseManager.EaseStyle)object, new float[0]);
                floatProperty = BIG_ISLAND_TRANS_Y;
                object = bl2 ? this.PAD_BOTTOM_ISLAND_HIDDEN_EASE : this.ALPHA_EASE;
                object = animConfig.setSpecial(floatProperty, (EaseManager.EaseStyle)object, new float[0]);
                object = object.addListeners(new TransitionListener[]{new DynamicIslandAnimListener(this, dynamicIslandContentView){
                    final DynamicIslandContentView $view;
                    final DynamicIslandAnimationDelegate this$0;
                    {
                        this.this$0 = dynamicIslandAnimationDelegate;
                        this.$view = dynamicIslandContentView;
                        super(dynamicIslandAnimationDelegate);
                    }

                    public void onBegin(Object object) {
                        super.onBegin(object);
                        DynamicIslandAnimationDelegate.access$setViewVisible(this.this$0, this.$view, 0);
                        object = DynamicIslandAnimationDelegate.access$getFakeView(this.this$0);
                        if (object != null) {
                            ((DynamicIslandContentFakeView)((Object)object)).setVisibility(4);
                        }
                        DynamicIslandScenarioUtils.INSTANCE.setDynamicIslandScenarioState(435L, true);
                    }

                    public void onCancel(Object object) {
                        super.onCancel(object);
                        object = DynamicIslandScenarioUtils.INSTANCE;
                        if (((DynamicIslandScenarioUtils)object).isBigTracking()) {
                            ((DynamicIslandScenarioUtils)object).setDynamicIslandScenarioState(494L, false);
                            ((DynamicIslandScenarioUtils)object).setBigTracking(false);
                        }
                        ((DynamicIslandScenarioUtils)object).setDynamicIslandScenarioState(435L, false);
                    }

                    public void onComplete(Object object) {
                        super.onComplete(object);
                        object = DynamicIslandScenarioUtils.INSTANCE;
                        if (((DynamicIslandScenarioUtils)object).isBigTracking()) {
                            ((DynamicIslandScenarioUtils)object).setDynamicIslandScenarioState(494L, false);
                            ((DynamicIslandScenarioUtils)object).setBigTracking(false);
                        }
                        ((DynamicIslandScenarioUtils)object).setDynamicIslandScenarioState(435L, false);
                    }
                }});
                iFolme.to((Object)animState, new AnimConfig[]{object});
            }
        } else {
            IFolme iFolme = FolmeKt.getFolme((FolmeObject)this);
            AnimState animState = this.getCutoutAnimState();
            Object object2 = new AnimConfig().setSpecial(CONTAINER_CLIP_START_PROGRESS, (EaseManager.EaseStyle)object, new float[0]);
            AnimConfig animConfig = object2.setSpecial(CONTAINER_CLIP_END_PROGRESS, (EaseManager.EaseStyle)object, new float[0]);
            FloatProperty<DynamicIslandAnimationDelegate> floatProperty = CONTAINER_ALPHA;
            object2 = this.getSupposedContainerAlpha() == 0.0f ? object : FolmeEase.linear((long)100L);
            long l = this.getSupposedContainerAlpha() == 0.0f ? 100L : 400L;
            object2 = animConfig.setSpecial(floatProperty, (EaseManager.EaseStyle)object2, l, new float[0]);
            object2 = object2.setSpecial(BIG_ISLAND_SCALE, (EaseManager.EaseStyle)object, new float[0]).setSpecial(BIG_ISLAND_ALPHA, this.ALPHA_EASE, new float[0]);
            object2 = object2.setSpecial(BIG_ISLAND_BLUR, this.ALPHA_EASE, new float[0]);
            object2 = object2.setSpecial(BIG_ISLAND_AREA_LEFT_TRANS_X, (EaseManager.EaseStyle)object, new float[0]);
            object = object2.setSpecial(BIG_ISLAND_AREA_RIGHT_TRANS_X, (EaseManager.EaseStyle)object, new float[0]);
            object = object.addListeners(new TransitionListener[]{new DynamicIslandAnimListener(this, dynamicIslandContentView){
                final DynamicIslandContentView $view;
                final DynamicIslandAnimationDelegate this$0;
                {
                    this.this$0 = dynamicIslandAnimationDelegate;
                    this.$view = dynamicIslandContentView;
                    super(dynamicIslandAnimationDelegate);
                }

                public void onBegin(Object object) {
                    super.onBegin(object);
                    DynamicIslandAnimationDelegate.access$setViewVisible(this.this$0, this.$view, 0);
                    object = DynamicIslandAnimationDelegate.access$getFakeView(this.this$0);
                    if (object != null) {
                        ((DynamicIslandContentFakeView)((Object)object)).setVisibility(4);
                    }
                    DynamicIslandScenarioUtils.INSTANCE.setDynamicIslandScenarioState(435L, true);
                }

                public void onCancel(Object object) {
                    super.onCancel(object);
                    object = DynamicIslandScenarioUtils.INSTANCE;
                    if (((DynamicIslandScenarioUtils)object).isBigTracking()) {
                        ((DynamicIslandScenarioUtils)object).setDynamicIslandScenarioState(494L, false);
                        ((DynamicIslandScenarioUtils)object).setBigTracking(false);
                    }
                    ((DynamicIslandScenarioUtils)object).setDynamicIslandScenarioState(435L, false);
                }

                public void onComplete(Object object) {
                    super.onComplete(object);
                    object = DynamicIslandScenarioUtils.INSTANCE;
                    if (((DynamicIslandScenarioUtils)object).isBigTracking()) {
                        ((DynamicIslandScenarioUtils)object).setDynamicIslandScenarioState(494L, false);
                        ((DynamicIslandScenarioUtils)object).setBigTracking(false);
                    }
                    ((DynamicIslandScenarioUtils)object).setDynamicIslandScenarioState(435L, false);
                }
            }});
            iFolme.to((Object)animState, new AnimConfig[]{object});
        }
        if (bl) {
            this.fakeViewToHidden(dynamicIslandContentView, false);
        }
    }

    public final void bigIslandToHiddenNoAnimation(DynamicIslandContentView dynamicIslandContentView) {
        o.g((Object)((Object)dynamicIslandContentView), (String)"view");
        this.hiddenStateFrom = new DynamicIslandState(){};
        if (CommonUtils.INSTANCE.getIS_TABLET()) {
            FolmeKt.getFolme((FolmeObject)this).setTo((Object)this.getMultiTopIslandAnimState(dynamicIslandContentView));
            this.setViewVisible(dynamicIslandContentView, 8);
            this.scheduleUpdate();
        }
    }

    public final void bigIslandToMiniWindowExpandedAnimation(DynamicIslandContentView dynamicIslandContentView) {
        DynamicIslandEventCoordinator dynamicIslandEventCoordinator;
        o.g((Object)((Object)dynamicIslandContentView), (String)"view");
        this.bigIslandToHiddenAnimation(dynamicIslandContentView, false);
        DynamicIslandContentFakeView dynamicIslandContentFakeView = dynamicIslandContentView.getFakeView();
        if (dynamicIslandContentFakeView != null && (dynamicIslandEventCoordinator = dynamicIslandContentFakeView.getDynamicIslandEventCoordinator()) != null) {
            DynamicIslandContentFakeView dynamicIslandContentFakeView2 = dynamicIslandContentView.getFakeView();
            dynamicIslandContentFakeView = dynamicIslandContentView.getCurrentIslandData();
            dynamicIslandContentFakeView = dynamicIslandContentFakeView != null ? dynamicIslandContentFakeView.getExtras() : null;
            dynamicIslandEventCoordinator.updateFreeformFakeView(dynamicIslandContentFakeView2, dynamicIslandContentView, (Bundle)dynamicIslandContentFakeView);
        }
    }

    public final void bigIslandToSmallIslandAnimation(DynamicIslandContentView dynamicIslandContentView) {
        o.g((Object)((Object)dynamicIslandContentView), (String)"view");
        FrameLayout frameLayout = dynamicIslandContentView.getSmallIslandView();
        if (frameLayout != null) {
            frameLayout.setVisibility(0);
        }
        frameLayout = dynamicIslandContentView.getExpandedView();
        if (frameLayout != null) {
            frameLayout.setVisibility(4);
        }
        if (!dynamicIslandContentView.pkgHasMultIslands(dynamicIslandContentView)) {
            this.setViewVisible(dynamicIslandContentView, 0);
            frameLayout = dynamicIslandContentView.getFakeView();
            if (frameLayout != null) {
                frameLayout.setVisibility(4);
            }
        }
        FolmeKt.getFolme((FolmeObject)this).to((Object)this.getSmallIslandAnimState(), new AnimConfig[]{new AnimConfig().setSpecial(CONTAINER_CLIP_START_PROGRESS, this.CHANGE_EASE, new float[0]).setSpecial(CONTAINER_CLIP_END_PROGRESS, this.CHANGE_EASE, new float[0]).setSpecial(BIG_ISLAND_AREA_LEFT_TRANS_X, this.CHANGE_EASE, new float[0]).setSpecial(BIG_ISLAND_AREA_RIGHT_TRANS_X, this.CHANGE_EASE, new float[0]).setSpecial(CONTAINER_X, this.CHANGE_EASE, new float[0]).setSpecial(SMALL_ISLAND_TRANS_X, this.CHANGE_EASE, new float[0]).addListeners(new TransitionListener[]{new DynamicIslandAnimListener(this){

            public void onBegin(Object object) {
                super.onBegin(object);
                DynamicIslandScenarioUtils.INSTANCE.setDynamicIslandScenarioState(436L, true);
            }

            public void onCancel(Object object) {
                super.onCancel(object);
                object = DynamicIslandScenarioUtils.INSTANCE;
                if (((DynamicIslandScenarioUtils)object).isBigTracking()) {
                    ((DynamicIslandScenarioUtils)object).setDynamicIslandScenarioState(494L, false);
                    ((DynamicIslandScenarioUtils)object).setBigTracking(false);
                }
                ((DynamicIslandScenarioUtils)object).setDynamicIslandScenarioState(436L, false);
            }

            public void onComplete(Object object) {
                super.onComplete(object);
                object = DynamicIslandScenarioUtils.INSTANCE;
                if (((DynamicIslandScenarioUtils)object).isBigTracking()) {
                    ((DynamicIslandScenarioUtils)object).setDynamicIslandScenarioState(494L, false);
                    ((DynamicIslandScenarioUtils)object).setBigTracking(false);
                }
                ((DynamicIslandScenarioUtils)object).setDynamicIslandScenarioState(436L, false);
            }
        }})});
        this.fakeViewToSmallIsland(dynamicIslandContentView, false);
    }

    public final void bigIslandToSmallIslandNoAnimation(DynamicIslandContentView dynamicIslandContentView) {
        o.g((Object)((Object)dynamicIslandContentView), (String)"view");
        FolmeKt.getFolme((FolmeObject)this).setTo((Object)this.getSmallIslandAnimState(), new AnimConfig[]{new AnimConfig().setSpecial(CONTAINER_CLIP_START_PROGRESS, this.CHANGE_EASE, new float[0]).setSpecial(CONTAINER_CLIP_END_PROGRESS, this.CHANGE_EASE, new float[0]).setSpecial(BIG_ISLAND_AREA_LEFT_TRANS_X, this.CHANGE_EASE, new float[0]).setSpecial(BIG_ISLAND_AREA_RIGHT_TRANS_X, this.CHANGE_EASE, new float[0]).setSpecial(CONTAINER_X, this.CHANGE_EASE, new float[0]).setSpecial(SMALL_ISLAND_TRANS_X, this.CHANGE_EASE, new float[0]).addListeners(new TransitionListener[]{new DynamicIslandAnimListener(this, dynamicIslandContentView){
            final DynamicIslandContentView $view;
            {
                this.$view = dynamicIslandContentView;
                super(dynamicIslandAnimationDelegate);
            }

            public void onComplete(Object object) {
                super.onComplete(object);
                object = this.$view.getSmallIslandView();
                if (object != null) {
                    object.setVisibility(0);
                }
                object = this.$view.getExpandedView();
                if (object != null) {
                    object.setVisibility(4);
                }
            }
        }})});
        this.fakeViewToSmallIsland(dynamicIslandContentView, false);
    }

    public final void bigIslandToTempHiddenAnimation(DynamicIslandContentView dynamicIslandBaseContentView) {
        Object object;
        AnimState animState;
        o.g((Object)((Object)dynamicIslandBaseContentView), (String)"view");
        if (CommonUtils.INSTANCE.getIS_TABLET()) {
            animState = this.getBigIslandHiddenAnimState();
            object = new AnimConfig().setSpecial(CONTAINER_CLIP_START_PROGRESS, this.PAD_HIGHT_HIDDEN_EASE, new float[0]).setSpecial(CONTAINER_CLIP_END_PROGRESS, this.PAD_HIGHT_HIDDEN_EASE, new float[0]).setSpecial(CONTAINER_CLIP_TOP_PROGRESS, this.PAD_HIGHT_HIDDEN_EASE, new float[0]).setSpecial(CONTAINER_CLIP_BOTTOM_PROGRESS, this.PAD_HIGHT_HIDDEN_EASE, new float[0]).setSpecial(BIG_ISLAND_SCALE, this.PAD_HIGHT_HIDDEN_EASE, new float[0]).setSpecial(BIG_ISLAND_ALPHA, this.PAD_HIGHT_HIDDEN_EASE, new float[0]).setSpecial(BIG_ISLAND_BLUR, this.PAD_HIGHT_HIDDEN_EASE, new float[0]).setSpecial(BIG_ISLAND_TRANS_X, this.PAD_HIGHT_HIDDEN_EASE, new float[0]).setSpecial(EXPANDED_TRANS_X, this.PAD_HIGHT_HIDDEN_EASE, new float[0]).setSpecial(EXPANDED_SCALE_X, this.PAD_HIGHT_HIDDEN_EASE, new float[0]).setSpecial(EXPANDED_SCALE_Y, this.PAD_HIGHT_HIDDEN_EASE, new float[0]).setSpecial(EXPANDED_ALPHA, this.PAD_HIGHT_HIDDEN_EASE, new float[0]);
            o.f((Object)object, (String)"setSpecial(...)");
        } else {
            animState = this.SHOW_EASE;
            if (this.dynamicIslandAnimController.getDynamicIslandWindowState().isToScreenLockNoAnimation() || !DynamicIslandAnimUtils.INSTANCE.supportShowElementAnim()) {
                animState = this.HIDDEN_EASE;
            }
            AnimState animState2 = this.getCutoutAnimState();
            AnimConfig animConfig = new AnimConfig().setSpecial(CONTAINER_CLIP_START_PROGRESS, (EaseManager.EaseStyle)animState, new float[0]).setSpecial(CONTAINER_CLIP_END_PROGRESS, (EaseManager.EaseStyle)animState, new float[0]);
            FloatProperty<DynamicIslandAnimationDelegate> floatProperty = CONTAINER_ALPHA;
            object = this.getSupposedContainerAlpha() == 0.0f ? animState : FolmeEase.linear((long)100L);
            long l = this.getSupposedContainerAlpha() == 0.0f ? 100L : 400L;
            object = animConfig.setSpecial(floatProperty, (EaseManager.EaseStyle)object, l, new float[0]).setSpecial(BIG_ISLAND_SCALE, (EaseManager.EaseStyle)animState, new float[0]).setSpecial(BIG_ISLAND_ALPHA, this.ALPHA_EASE, new float[0]).setSpecial(BIG_ISLAND_BLUR, this.ALPHA_EASE, new float[0]).setSpecial(BIG_ISLAND_AREA_LEFT_TRANS_X, (EaseManager.EaseStyle)animState, new float[0]).setSpecial(BIG_ISLAND_AREA_RIGHT_TRANS_X, (EaseManager.EaseStyle)animState, new float[0]);
            o.f((Object)object, (String)"setSpecial(...)");
            animState = animState2;
        }
        FolmeKt.getFolme((FolmeObject)this).to((Object)animState, new AnimConfig[]{object.addListeners(new TransitionListener[]{new DynamicIslandAnimListener(this, (DynamicIslandContentView)dynamicIslandBaseContentView){
            final DynamicIslandContentView $view;
            final DynamicIslandAnimationDelegate this$0;
            {
                this.this$0 = dynamicIslandAnimationDelegate;
                this.$view = dynamicIslandContentView;
                super(dynamicIslandAnimationDelegate);
            }

            public void onBegin(Object object) {
                super.onBegin(object);
                object = this.$view.getWindowState();
                if (!(object == null || ((DynamicIslandWindowState)object).getKeyguardShowing() || (object = this.$view.getWindowState()) == null || (object = ((DynamicIslandWindowState)object).getScreenPinning()) == null || ((Boolean)object.getValue()).booleanValue() || this.this$0.getIslandWindowAnimRunning())) {
                    DynamicIslandAnimationDelegate.access$setViewVisible(this.this$0, this.$view, 0);
                }
                DynamicIslandAnimationDelegate.access$getAnimationDelegateHelper$p(this.this$0).requestUpdateHeadsUpLocation(DynamicIslandAnimationType.BIG_TO_TEMP_HIDDEN, this.$view);
                DynamicIslandScenarioUtils.INSTANCE.setDynamicIslandScenarioState(435L, true);
            }

            public void onCancel(Object object) {
                super.onCancel(object);
                DynamicIslandScenarioUtils.INSTANCE.setDynamicIslandScenarioState(435L, false);
            }

            public void onComplete(Object object) {
                super.onComplete(object);
                object = this.$view.getExpandedView();
                if (object != null) {
                    object.setVisibility(4);
                }
                DynamicIslandScenarioUtils.INSTANCE.setDynamicIslandScenarioState(435L, false);
            }
        }})});
        if (this.getIslandWindowAnimRunning()) {
            this.fakeViewToHidden((DynamicIslandContentView)dynamicIslandBaseContentView, true);
        } else if ((dynamicIslandBaseContentView = dynamicIslandBaseContentView.getFakeView()) != null) {
            ((DynamicIslandContentFakeView)dynamicIslandBaseContentView).setVisibility(8);
        }
    }

    public final void bigIslandToTempHiddenNoAnimation(DynamicIslandContentView dynamicIslandBaseContentView) {
        o.g((Object)((Object)dynamicIslandBaseContentView), (String)"view");
        IFolme iFolme = FolmeKt.getFolme((FolmeObject)this);
        AnimState animState = CommonUtils.INSTANCE.getIS_TABLET() ? this.getBigIslandHiddenAnimState() : this.getCutoutAnimState();
        iFolme.setTo((Object)animState, new AnimConfig[]{new AnimConfig().addListeners(new TransitionListener[]{new DynamicIslandAnimListener(this, (DynamicIslandContentView)dynamicIslandBaseContentView){
            final DynamicIslandContentView $view;
            final DynamicIslandAnimationDelegate this$0;
            {
                this.this$0 = dynamicIslandAnimationDelegate;
                this.$view = dynamicIslandContentView;
                super(dynamicIslandAnimationDelegate);
            }

            public void onBegin(Object object) {
                super.onBegin(object);
                DynamicIslandAnimationDelegate.access$getAnimationDelegateHelper$p(this.this$0).requestUpdateHeadsUpLocation(DynamicIslandAnimationType.BIG_TO_TEMP_HIDDEN, this.$view);
            }

            public void onComplete(Object object) {
                super.onComplete(object);
                object = this.$view.getExpandedView();
                if (object != null) {
                    object.setVisibility(4);
                }
            }
        }})});
        dynamicIslandBaseContentView = dynamicIslandBaseContentView.getFakeView();
        if (dynamicIslandBaseContentView != null) {
            ((DynamicIslandContentFakeView)dynamicIslandBaseContentView).setVisibility(8);
        }
    }

    public final float containerClipRadius() {
        return f.e((float)((this.containerClipBottomProgress - this.containerClipTopProgress) / 2.0f), (float)this.view.getContext().getResources().getDimension(R.dimen.island_radius));
    }

    public final void containerScheduleUpdate() {
        boolean bl;
        this.view.setTranslationX(this.containerX);
        this.view.setTranslationY(this.containerTransY);
        this.view.setAlpha(this.containerAlpha);
        this.expandedViewAnimatingProgress = this.containerClipBottomProgress / this.getExpandedBottom();
        Object object = this.view.getCurrentIslandData();
        boolean bl2 = bl = false;
        if (object != null) {
            object = object.getExtras();
            bl2 = bl;
            if (object != null) {
                bl2 = object.getBoolean("miui.focus.isPromoted", false);
            }
        }
        if (CommonUtils.INSTANCE.getIS_TABLET()) {
            object = this.view.getContext();
            o.f((Object)object, (String)"getContext(...)");
            if (!MiBlurCompat.getBackgroundBlurOpened((Context)object) && (object = this.view.getContainer()) != null) {
                object.setBackgroundColor(this.containerBackgroundColor);
            }
        }
        if (bl2) {
            if (this.view.getState() instanceof DynamicIslandState.Expanded) {
                object = this.view.getContainer();
                if (object != null) {
                    object.setBackgroundDrawable(this.view.getContext().getResources().getDrawable(R.drawable.dynamic_island_liveupdate_background));
                }
            } else {
                object = this.view.getContainer();
                if (object != null) {
                    object.setBackgroundDrawable(this.view.getContext().getResources().getDrawable(R.drawable.dynamic_island_background));
                }
            }
        }
        this.view.setOutlineProvider(new ViewOutlineProvider(this){
            final DynamicIslandAnimationDelegate this$0;
            {
                this.this$0 = dynamicIslandAnimationDelegate;
            }

            public void getOutline(View view, Outline outline) {
                o.g((Object)view, (String)"view");
                o.g((Object)outline, (String)"outline");
                if (DynamicIslandAnimationDelegate.access$getView$p(this.this$0).getBackgroundView() != null) {
                    DynamicIslandBackgroundView dynamicIslandBackgroundView = DynamicIslandAnimationDelegate.access$getView$p(this.this$0).getBackgroundView();
                    if (dynamicIslandBackgroundView != null) {
                        dynamicIslandBackgroundView.setActualWidth((int)(DynamicIslandAnimationDelegate.access$getContainerX$p(this.this$0) + DynamicIslandAnimationDelegate.access$getContainerClipEndProgress$p(this.this$0)));
                    }
                    if (dynamicIslandBackgroundView != null) {
                        dynamicIslandBackgroundView.setActualHeight((int)(DynamicIslandAnimationDelegate.access$getContainerTransY$p(this.this$0) + DynamicIslandAnimationDelegate.access$getContainerClipBottomProgress$p(this.this$0)));
                    }
                    if (dynamicIslandBackgroundView != null) {
                        dynamicIslandBackgroundView.setActualLeft((int)(DynamicIslandAnimationDelegate.access$getContainerX$p(this.this$0) + DynamicIslandAnimationDelegate.access$getContainerClipStartProgress$p(this.this$0)));
                    }
                    if (dynamicIslandBackgroundView != null) {
                        dynamicIslandBackgroundView.setActualTop((int)(DynamicIslandAnimationDelegate.access$getContainerTransY$p(this.this$0) + DynamicIslandAnimationDelegate.access$getContainerClipTopProgress$p(this.this$0)));
                    }
                    if (ThreadUtils.isMainThread()) {
                        view = view.getParent();
                        o.e((Object)view, (String)"null cannot be cast to non-null type miui.systemui.dynamicisland.DynamicIslandBackgroundView");
                        ((DynamicIslandBackgroundView)view).invalidate();
                    } else {
                        view = view.getParent();
                        o.e((Object)view, (String)"null cannot be cast to non-null type miui.systemui.dynamicisland.DynamicIslandBackgroundView");
                        ((DynamicIslandBackgroundView)view).postInvalidate();
                    }
                }
                outline.setRoundRect((int)DynamicIslandAnimationDelegate.access$getContainerClipStartProgress$p(this.this$0), (int)DynamicIslandAnimationDelegate.access$getContainerClipTopProgress$p(this.this$0), (int)DynamicIslandAnimationDelegate.access$getContainerClipEndProgress$p(this.this$0), (int)DynamicIslandAnimationDelegate.access$getContainerClipBottomProgress$p(this.this$0), this.this$0.containerClipRadius());
                view = DynamicIslandAnimationDelegate.access$getView$p(this.this$0).getRoundedRect();
                if (view != null) {
                    view.set(DynamicIslandAnimationDelegate.access$getContainerClipStartProgress$p(this.this$0), DynamicIslandAnimationDelegate.access$getContainerClipTopProgress$p(this.this$0), DynamicIslandAnimationDelegate.access$getContainerClipEndProgress$p(this.this$0), DynamicIslandAnimationDelegate.access$getContainerClipBottomProgress$p(this.this$0));
                }
            }
        });
        this.view.setClipToOutline(true);
        if (this.supportBlur && (object = this.view.getBackgroundView()) != null) {
            this.updateContentBlur((View)object, this.containerBlur);
        }
    }

    public final void expandedChangedAnimation(DynamicIslandContentView dynamicIslandContentView) {
        o.g((Object)((Object)dynamicIslandContentView), (String)"view");
        this.lastExpandHeight = this.currentExpandHeight;
        this.currentExpandHeight = dynamicIslandContentView.getExpandedViewHeight();
        x x2 = new x();
        if (!this.isAnimateExpanding && this.lastExpandHeight != this.currentExpandHeight) {
            x2.a = true;
            dynamicIslandContentView.updateExpandViewBlur((int)(this.getExpandedBottom() + (float)dynamicIslandContentView.getExpandedViewY() - (float)dynamicIslandContentView.getIslandViewMarginTop()));
        }
        FolmeKt.getFolme((FolmeObject)this).to((Object)this.getExpandedAnimState(), new AnimConfig[]{new AnimConfig().addListeners(new TransitionListener[]{new DynamicIslandAnimListener(this, dynamicIslandContentView, x2){
            final x $needUpdateExpandViewBlur;
            final DynamicIslandContentView $view;
            final DynamicIslandAnimationDelegate this$0;
            {
                this.this$0 = dynamicIslandAnimationDelegate;
                this.$view = dynamicIslandContentView;
                this.$needUpdateExpandViewBlur = x2;
                super(dynamicIslandAnimationDelegate);
            }

            public void onBegin(Object object) {
                super.onBegin(object);
                Object object2 = this.$view.getExpandedView();
                if (object2 != null) {
                    object2.setVisibility(0);
                }
                object2 = this.$view.getBigIslandView();
                if (object2 != null) {
                    object2.setVisibility(4);
                }
                object2 = this.$view.getSmallIslandView();
                if (object2 != null) {
                    object2.setVisibility(4);
                }
                object2 = this.$view.getMask();
                if (object2 != null) {
                    object2.setVisibility(4);
                }
                DynamicIslandAnimationCallback dynamicIslandAnimationCallback = DynamicIslandAnimationDelegate.access$getDynamicIslandAnimController$p(this.this$0).getAnimationCallback$miui_dynamicisland_release();
                object2 = DynamicIslandAnimationType.TO_EXPANDED;
                DynamicIslandAnimationCallbackType dynamicIslandAnimationCallbackType = DynamicIslandAnimationCallbackType.ANIM_START;
                o.e((Object)object, (String)"null cannot be cast to non-null type kotlin.String");
                dynamicIslandAnimationCallback.executeCallback((DynamicIslandAnimationType)((Object)object2), dynamicIslandAnimationCallbackType, (String)object);
                DynamicIslandAnimationDelegate.access$setAnimateExpanding(this.this$0, true);
                DynamicIslandAnimationDelegate.access$getAnimationDelegateHelper$p(this.this$0).requestUpdateHeadsUpLocation(DynamicIslandAnimationType.EXPANDED_CHANGED, this.$view);
            }

            public void onCancel(Object object) {
                super.onCancel(object);
                DynamicIslandAnimationDelegate.access$setAnimateExpanding(this.this$0, false);
                if (!this.$needUpdateExpandViewBlur.a) {
                    object = this.$view.getExpandedView();
                    if (object != null) {
                        object.setOutlineProvider(null);
                    }
                    object = this.$view.getExpandedView();
                    if (object != null) {
                        object.invalidateOutline();
                    }
                }
            }

            public void onComplete(Object object) {
                super.onComplete(object);
                DynamicIslandAnimationCallback dynamicIslandAnimationCallback = DynamicIslandAnimationDelegate.access$getDynamicIslandAnimController$p(this.this$0).getAnimationCallback$miui_dynamicisland_release();
                DynamicIslandAnimationType dynamicIslandAnimationType = DynamicIslandAnimationType.TO_EXPANDED;
                DynamicIslandAnimationCallbackType dynamicIslandAnimationCallbackType = DynamicIslandAnimationCallbackType.ANIM_FINISH;
                o.e((Object)object, (String)"null cannot be cast to non-null type kotlin.String");
                dynamicIslandAnimationCallback.executeCallback(dynamicIslandAnimationType, dynamicIslandAnimationCallbackType, (String)object);
                DynamicIslandAnimationDelegate.access$setAnimateExpanding(this.this$0, false);
                object = this.$view.getExpandedView();
                if (object != null) {
                    object.setOutlineProvider(null);
                }
                object = this.$view.getExpandedView();
                if (object != null) {
                    object.invalidateOutline();
                }
            }
        }})});
        if (!this.getIslandWindowAnimRunning()) {
            this.fakeViewToExpanded(dynamicIslandContentView, false);
        }
    }

    public final void expandedScheduleUpdate() {
        DynamicIslandExpandedView dynamicIslandExpandedView = this.view.getExpandedView();
        if (dynamicIslandExpandedView != null) {
            dynamicIslandExpandedView.setScaleX(this.expandedScaleX);
        }
        dynamicIslandExpandedView = this.view.getExpandedView();
        if (dynamicIslandExpandedView != null) {
            dynamicIslandExpandedView.setScaleY(this.expandedScaleY);
        }
        dynamicIslandExpandedView = this.view.getExpandedView();
        if (dynamicIslandExpandedView != null) {
            dynamicIslandExpandedView.setAlpha(this.expandedAlpha);
        }
        dynamicIslandExpandedView = this.view.getExpandedView();
        if (dynamicIslandExpandedView != null) {
            dynamicIslandExpandedView.setTranslationY(this.expandedTransY);
        }
        dynamicIslandExpandedView = this.view.getExpandedView();
        if (dynamicIslandExpandedView != null) {
            dynamicIslandExpandedView.setTranslationX(this.expandedTransX);
        }
        if (CommonUtils.INSTANCE.getIS_TABLET() && (dynamicIslandExpandedView = this.view.getMiniBar()) != null) {
            dynamicIslandExpandedView.setTranslationX(this.expandedTransX);
        }
        if ((dynamicIslandExpandedView = this.view.getExpandedView()) != null) {
            float f2 = this.containerClipStartProgress;
            float f3 = this.containerX;
            float f4 = this.containerClipTopProgress;
            float f5 = this.containerTransY;
            dynamicIslandExpandedView.updateGlowEffectAnim$miui_dynamicisland_release(f2 + f3, f4 + f5, this.containerClipEndProgress + f3, this.containerClipBottomProgress + f5, this.containerClipRadius());
            DynamicIslandBackgroundView dynamicIslandBackgroundView = this.view.getBackgroundView();
            f5 = dynamicIslandBackgroundView != null ? dynamicIslandBackgroundView.getZ() : 0.0f;
            dynamicIslandExpandedView.setZOrderOfGlowEffect$miui_dynamicisland_release(f5);
            dynamicIslandExpandedView.setAlphaOfGlowEffect$miui_dynamicisland_release(this.containerAlpha);
        }
        if (this.supportBlur && (dynamicIslandExpandedView = this.view.getExpandedView()) != null) {
            this.updateContentBlur((View)dynamicIslandExpandedView, this.expandedBlur);
        }
    }

    public final void expandedToAppExpandedAnimation(DynamicIslandContentView dynamicIslandContentView) {
        o.g((Object)((Object)dynamicIslandContentView), (String)"view");
        if (!this.getIslandWindowAnimRunning()) {
            DynamicIslandEventCoordinator dynamicIslandEventCoordinator = dynamicIslandContentView.getDynamicIslandEventCoordinator();
            if (dynamicIslandEventCoordinator != null) {
                dynamicIslandEventCoordinator.updateView(dynamicIslandContentView);
            }
            this.expandedToTempHiddenAnimation(dynamicIslandContentView, true);
        } else {
            FolmeKt.getFolme((FolmeObject)this).cancel();
            DynamicIslandExpandedView dynamicIslandExpandedView = dynamicIslandContentView.getExpandedView();
            if (dynamicIslandExpandedView != null) {
                dynamicIslandExpandedView.stopGlowEffect$miui_dynamicisland_release(true);
            }
        }
        this.animationDelegateHelper.requestUpdateHeadsUpLocation(DynamicIslandAnimationType.EXPANDED_TO_APP_EXPANDED, dynamicIslandContentView);
        this.fakeViewToExpanded(dynamicIslandContentView, true);
    }

    /*
     * Unable to fully structure code
     */
    public final void expandedToBigIslandAnimation(DynamicIslandContentView var1_1) {
        block4: {
            block3: {
                o.g((Object)var1_1, (String)"view");
                this.isBlockUpdatePosition = true;
                var1_1.updateBigIslandLayout();
                var6_2 = new x();
                var6_2.a = (Boolean)this.dynamicIslandAnimController.getDynamicIslandWindowState().getStatusBarDisappearance().getValue();
                var7_3 = this.getBigIslandAnimState();
                var2_4 = this.getExpandedShouldTransX();
                if (!CommonUtils.INSTANCE.getIS_TABLET()) break block3;
                if (this.bigIslandTransX == var2_4) {
                    this.bigIslandTransX = 0.0f;
                }
                var5_5 = this.PAD_NORMAL_HIDDEN_EASE;
                if (!this.supportBlur) ** GOTO lbl-1000
                var8_6 = var1_1.getContext();
                o.f((Object)var8_6, (String)"getContext(...)");
                if (MiBlurCompat.getBackgroundBlurOpened((Context)var8_6)) {
                    var5_5 = this.PAD_HIGHT_HIDDEN_EASE;
                    var3_7 = 50L;
                } else lbl-1000:
                // 2 sources

                {
                    var3_7 = 70L;
                }
                var5_5 = new AnimConfig().setSpecial(DynamicIslandAnimationDelegate.CONTAINER_TRANS_Y, this.PAD_CHANGE_EASE, new float[0]).setSpecial(DynamicIslandAnimationDelegate.CONTAINER_CLIP_TOP_PROGRESS, this.PAD_CHANGE_EASE, new float[0]).setSpecial(DynamicIslandAnimationDelegate.CONTAINER_CLIP_BOTTOM_PROGRESS, this.PAD_CHANGE_EASE, new float[0]).setSpecial(DynamicIslandAnimationDelegate.CONTAINER_CLIP_START_PROGRESS, this.PAD_CHANGE_EASE, new float[0]).setSpecial(DynamicIslandAnimationDelegate.CONTAINER_CLIP_END_PROGRESS, this.PAD_CHANGE_EASE, new float[0]).setSpecial(DynamicIslandAnimationDelegate.EXPANDED_SCALE_X, this.PAD_CHANGE_EASE, new float[0]).setSpecial(DynamicIslandAnimationDelegate.EXPANDED_SCALE_Y, this.PAD_CHANGE_EASE, new float[0]).setSpecial(DynamicIslandAnimationDelegate.EXPANDED_ALPHA, var5_5, new float[0]).setSpecial(DynamicIslandAnimationDelegate.EXPANDED_BLUR, var5_5, new float[0]).setSpecial(DynamicIslandAnimationDelegate.BIG_ISLAND_SCALE, this.PAD_CHANGE_EASE, new float[0]).setSpecial(DynamicIslandAnimationDelegate.BIG_ISLAND_ALPHA, this.PAD_SHOW_EASE, var3_7, new float[0]).setSpecial(DynamicIslandAnimationDelegate.BIG_ISLAND_BLUR, this.PAD_SHOW_EASE, var3_7, new float[0]).setSpecial(DynamicIslandAnimationDelegate.BIG_ISLAND_TRANS_X, this.PAD_CHANGE_EASE, new float[0]).setSpecial(DynamicIslandAnimationDelegate.EXPANDED_TRANS_Y, this.PAD_CHANGE_EASE, new float[0]).setSpecial(DynamicIslandAnimationDelegate.BIG_ISLAND_TRANS_Y, this.PAD_CHANGE_EASE, new float[0]).setSpecial(DynamicIslandAnimationDelegate.EXPANDED_TRANS_X, this.PAD_CHANGE_EASE, new float[0]);
                break block4;
            }
            var5_5 = new AnimConfig().setSpecial(DynamicIslandAnimationDelegate.CONTAINER_TRANS_Y, this.CHANGE_EASE, new float[0]).setSpecial(DynamicIslandAnimationDelegate.CONTAINER_CLIP_TOP_PROGRESS, this.CHANGE_EASE, new float[0]).setSpecial(DynamicIslandAnimationDelegate.CONTAINER_CLIP_BOTTOM_PROGRESS, this.CHANGE_EASE, new float[0]).setSpecial(DynamicIslandAnimationDelegate.CONTAINER_CLIP_START_PROGRESS, this.CHANGE_EASE, new float[0]).setSpecial(DynamicIslandAnimationDelegate.CONTAINER_CLIP_END_PROGRESS, this.CHANGE_EASE, new float[0]).setSpecial(DynamicIslandAnimationDelegate.EXPANDED_SCALE_X, this.CHANGE_EASE, new float[0]).setSpecial(DynamicIslandAnimationDelegate.EXPANDED_SCALE_Y, this.CHANGE_EASE, new float[0]).setSpecial(DynamicIslandAnimationDelegate.EXPANDED_ALPHA, this.HIDDEN_EASE, new float[0]).setSpecial(DynamicIslandAnimationDelegate.EXPANDED_BLUR, this.HIDDEN_EASE, new float[0]).setSpecial(DynamicIslandAnimationDelegate.BIG_ISLAND_SCALE, this.CHANGE_EASE, new float[0]).setSpecial(DynamicIslandAnimationDelegate.BIG_ISLAND_ALPHA, this.SHOW_EASE, 50L, new float[0]).setSpecial(DynamicIslandAnimationDelegate.BIG_ISLAND_BLUR, this.SHOW_EASE, 50L, new float[0]).setSpecial(DynamicIslandAnimationDelegate.EXPANDED_TRANS_Y, this.CHANGE_EASE, new float[0]).setSpecial(DynamicIslandAnimationDelegate.BIG_ISLAND_TRANS_Y, this.CHANGE_EASE, new float[0]);
        }
        FolmeKt.getFolme((FolmeObject)this).to((Object)var7_3, new AnimConfig[]{var5_5.addListeners(new TransitionListener[]{new DynamicIslandAnimListener(this, var1_1, var2_4, var6_2){
            final x $isStatusBarToHidden;
            final float $transX;
            final DynamicIslandContentView $view;
            final DynamicIslandAnimationDelegate this$0;
            {
                this.this$0 = dynamicIslandAnimationDelegate;
                this.$view = dynamicIslandContentView;
                this.$transX = f2;
                this.$isStatusBarToHidden = x2;
                super(dynamicIslandAnimationDelegate);
            }

            public void onBegin(Object object) {
                super.onBegin(object);
                DynamicIslandAnimationDelegate.access$setBlockUpdatePosition$p(this.this$0, true);
                DynamicIslandAnimationDelegate.access$setShouldBlockScale$p(this.this$0, true);
                DynamicIslandAnimationDelegate.access$setBeginExpandedScaleX$p(this.this$0, (float)this.$view.getBigIslandViewWidth() / (float)this.$view.getExpandedViewWidth());
                DynamicIslandAnimationDelegate.access$setViewVisible(this.this$0, this.$view, 0);
                Object object2 = DynamicIslandAnimationDelegate.access$getFakeView(this.this$0);
                if (object2 != null) {
                    object2.setVisibility(4);
                }
                object2 = this.$view.getBigIslandView();
                if (object2 != null) {
                    object2.setVisibility(0);
                }
                object2 = this.$view.getSmallIslandView();
                if (object2 != null) {
                    object2.setVisibility(4);
                }
                Object object3 = DynamicIslandAnimationDelegate.access$getAnimationDelegateHelper$p(this.this$0);
                object2 = DynamicIslandAnimationType.EXPANDED_TO_BIG;
                ((DynamicIslandAnimationDelegateHelper)object3).requestUpdateHeadsUpLocation((DynamicIslandAnimationType)((Object)object2), this.$view);
                object3 = DynamicIslandAnimationDelegate.access$getDynamicIslandAnimController$p(this.this$0).getAnimationCallback$miui_dynamicisland_release();
                DynamicIslandAnimationCallbackType dynamicIslandAnimationCallbackType = DynamicIslandAnimationCallbackType.ANIM_START;
                o.e((Object)object, (String)"null cannot be cast to non-null type kotlin.String");
                ((DynamicIslandAnimationCallback)object3).executeCallback((DynamicIslandAnimationType)((Object)object2), dynamicIslandAnimationCallbackType, (String)object);
                DynamicIslandScenarioUtils.INSTANCE.setDynamicIslandScenarioState(477L, true);
                DynamicIslandAnimationDelegate.access$getAnimationDelegateHelper$p(this.this$0).updateBigIslandContainerBackground(this.$view);
            }

            public void onCancel(Object object) {
                DynamicIslandAnimationDelegate.access$setBlockUpdatePosition$p(this.this$0, false);
                DynamicIslandAnimationDelegate.access$setShouldBlockScale$p(this.this$0, false);
                Object object2 = DynamicIslandScenarioUtils.INSTANCE;
                if (object2.isExpandTracking()) {
                    object2.setDynamicIslandScenarioState(496L, false);
                    object2.setExpandTracking(false);
                }
                object2.setDynamicIslandScenarioState(477L, false);
                DynamicIslandAnimationCallback dynamicIslandAnimationCallback = DynamicIslandAnimationDelegate.access$getDynamicIslandAnimController$p(this.this$0).getAnimationCallback$miui_dynamicisland_release();
                object2 = DynamicIslandAnimationType.EXPANDED_TO_BIG;
                DynamicIslandAnimationCallbackType dynamicIslandAnimationCallbackType = DynamicIslandAnimationCallbackType.ANIM_CANCEL;
                o.e((Object)object, (String)"null cannot be cast to non-null type kotlin.String");
                dynamicIslandAnimationCallback.executeCallback((DynamicIslandAnimationType)((Object)object2), dynamicIslandAnimationCallbackType, (String)object);
                super.onCancel(object);
            }

            public void onComplete(Object object) {
                DynamicIslandAnimationDelegate.access$setBlockUpdatePosition$p(this.this$0, false);
                DynamicIslandAnimationDelegate.access$setShouldBlockScale$p(this.this$0, false);
                Object object2 = this.$view.getExpandedView();
                if (object2 != null) {
                    object2.setVisibility(4);
                }
                object2 = DynamicIslandScenarioUtils.INSTANCE;
                if (((DynamicIslandScenarioUtils)object2).isExpandTracking()) {
                    ((DynamicIslandScenarioUtils)object2).setDynamicIslandScenarioState(496L, false);
                    ((DynamicIslandScenarioUtils)object2).setExpandTracking(false);
                }
                ((DynamicIslandScenarioUtils)object2).setDynamicIslandScenarioState(477L, false);
                object2 = DynamicIslandAnimationDelegate.access$getDynamicIslandAnimController$p(this.this$0).getAnimationCallback$miui_dynamicisland_release();
                DynamicIslandAnimationType dynamicIslandAnimationType = DynamicIslandAnimationType.EXPANDED_TO_BIG;
                DynamicIslandAnimationCallbackType dynamicIslandAnimationCallbackType = DynamicIslandAnimationCallbackType.ANIM_FINISH;
                o.e((Object)object, (String)"null cannot be cast to non-null type kotlin.String");
                ((DynamicIslandAnimationCallback)object2).executeCallback(dynamicIslandAnimationType, dynamicIslandAnimationCallbackType, (String)object);
                super.onComplete(object);
            }

            public void onUpdate(Object object, Collection<UpdateInfo> updateInfo2) {
                Object object2;
                DynamicIslandAnimationDelegate.access$fixTransX(this.this$0, updateInfo2, this.$transX);
                super.onUpdate(object, (Collection<UpdateInfo>)updateInfo2);
                object = CommonUtils.INSTANCE;
                if (object.getIS_TABLET() && (object2 = UpdateInfo.findByName(updateInfo2, (String)"dynamic_expanded_scale_x")) != null && f.h((float)object2.getFloatValue(), (float)0.0f, (float)1.0f) < DynamicIslandAnimationDelegate.access$getBeginExpandedScaleX$p(this.this$0) * 1.1f && DynamicIslandAnimationDelegate.access$getShouldBlockScale$p(this.this$0)) {
                    DynamicIslandAnimationDelegate.access$setShouldBlockScale$p(this.this$0, false);
                }
                boolean bl = (Boolean)DynamicIslandAnimationDelegate.access$getDynamicIslandAnimController$p(this.this$0).getDynamicIslandWindowState().getStatusBarDisappearance().getValue();
                if (object.getIS_TABLET()) {
                    object = this.$isStatusBarToHidden;
                    if (bl != ((x)object).a) {
                        ((x)object).a = bl;
                        if (!DynamicIslandAnimationDelegate.access$isMoveDownAnimating$p(this.this$0)) {
                            object = FolmeKt.getFolme((FolmeObject)this.this$0);
                            object2 = DynamicIslandAnimationDelegate.Companion;
                            object.cancel(new FloatProperty[]{object2.getCONTAINER_TRANS_Y(), object2.getEXPANDED_TRANS_Y(), object2.getBIG_ISLAND_TRANS_Y()});
                            FolmeKt.getFolme((FolmeObject)this.this$0).to((Object)new AnimState().add(object2.getCONTAINER_ALPHA(), 0.0f, new long[0]).add(object2.getEXPANDED_ALPHA(), 0.0f, new long[0]).add(object2.getBIG_ISLAND_ALPHA(), 0.0f, new long[0]), new AnimConfig[]{new AnimConfig().setSpecial(object2.getCONTAINER_ALPHA(), this.this$0.getPAD_SHOW_EASE(), new float[0]).setSpecial(object2.getEXPANDED_ALPHA(), this.this$0.getPAD_SHOW_EASE(), new float[0]).setSpecial(object2.getBIG_ISLAND_ALPHA(), this.this$0.getPAD_SHOW_EASE(), new float[0])});
                        }
                    }
                }
                if (updateInfo2 != null) {
                    object = this.$view;
                    for (UpdateInfo updateInfo2 : updateInfo2) {
                        if (!o.c((Object)updateInfo2.property, DynamicIslandAnimationDelegate.Companion.getBIG_ISLAND_SCALE())) continue;
                        ((DynamicIslandBaseContentView)((Object)object)).updateShadow((DynamicIslandBaseContentView)((Object)object), updateInfo2.getFloatValue() - 1.0f);
                    }
                }
            }
        }})});
        this.fakeViewToBigIsland(var1_1, false);
    }

    /*
     * Unable to fully structure code
     */
    public final void expandedToBigIslandNoAnimation(DynamicIslandContentView var1_1) {
        o.g((Object)var1_1, (String)"view");
        var6_2 = CommonUtils.INSTANCE;
        if (var6_2.getIS_TABLET() && !((Boolean)this.dynamicIslandAnimController.getDynamicIslandWindowState().getStatusBarWindowsInsetsShow().getValue()).booleanValue()) {
            FolmeKt.getFolme((FolmeObject)this).setTo((Object)this.getTempHiddenCompleteAnimStatePad());
            this.animationDelegateHelper.requestUpdateHeadsUpLocation(DynamicIslandAnimationType.EXPANDED_TO_TEMP_HIDDEN, (DynamicIslandContentView)var1_1);
            var5_3 = var1_1.getExpandedView();
            if (var5_3 != null) {
                var5_3.setVisibility(4);
            }
            var1_1 = var1_1.getFakeView();
            if (var1_1 != null) {
                var1_1.setVisibility(8);
            }
            return;
        }
        var5_4 = this.PAD_NORMAL_HIDDEN_EASE;
        if (!this.supportBlur) ** GOTO lbl-1000
        var7_5 = var1_1.getContext();
        o.f((Object)var7_5, (String)"getContext(...)");
        if (MiBlurCompat.getBackgroundBlurOpened((Context)var7_5)) {
            var5_4 = this.PAD_HIGHT_HIDDEN_EASE;
            var3_6 = 50L;
        } else lbl-1000:
        // 2 sources

        {
            var3_6 = 70L;
        }
        this.isBlockUpdatePosition = true;
        var1_1.updateBigIslandLayout();
        var7_5 = this.getBigIslandAnimState();
        var2_7 = this.getExpandedShouldTransX();
        var5_4 = var6_2.getIS_TABLET() != false ? new AnimConfig().setSpecial(DynamicIslandAnimationDelegate.CONTAINER_TRANS_Y, this.PAD_CHANGE_EASE, new float[0]).setSpecial(DynamicIslandAnimationDelegate.CONTAINER_CLIP_TOP_PROGRESS, this.PAD_CHANGE_EASE, new float[0]).setSpecial(DynamicIslandAnimationDelegate.CONTAINER_CLIP_BOTTOM_PROGRESS, this.PAD_CHANGE_EASE, new float[0]).setSpecial(DynamicIslandAnimationDelegate.CONTAINER_CLIP_START_PROGRESS, this.PAD_CHANGE_EASE, new float[0]).setSpecial(DynamicIslandAnimationDelegate.CONTAINER_CLIP_END_PROGRESS, this.PAD_CHANGE_EASE, new float[0]).setSpecial(DynamicIslandAnimationDelegate.EXPANDED_SCALE_X, this.PAD_CHANGE_EASE, new float[0]).setSpecial(DynamicIslandAnimationDelegate.EXPANDED_SCALE_Y, this.PAD_CHANGE_EASE, new float[0]).setSpecial(DynamicIslandAnimationDelegate.EXPANDED_ALPHA, var5_4, new float[0]).setSpecial(DynamicIslandAnimationDelegate.EXPANDED_BLUR, var5_4, new float[0]).setSpecial(DynamicIslandAnimationDelegate.BIG_ISLAND_SCALE, this.PAD_CHANGE_EASE, new float[0]).setSpecial(DynamicIslandAnimationDelegate.BIG_ISLAND_ALPHA, this.PAD_SHOW_EASE, var3_6, new float[0]).setSpecial(DynamicIslandAnimationDelegate.BIG_ISLAND_BLUR, this.PAD_SHOW_EASE, var3_6, new float[0]).setSpecial(DynamicIslandAnimationDelegate.BIG_ISLAND_TRANS_X, this.PAD_CHANGE_EASE, new float[0]).setSpecial(DynamicIslandAnimationDelegate.EXPANDED_TRANS_Y, this.PAD_CHANGE_EASE, new float[0]).setSpecial(DynamicIslandAnimationDelegate.BIG_ISLAND_TRANS_Y, this.PAD_CHANGE_EASE, new float[0]).setSpecial(DynamicIslandAnimationDelegate.EXPANDED_TRANS_X, this.PAD_CHANGE_EASE, new float[0]) : new AnimConfig().setSpecial(DynamicIslandAnimationDelegate.CONTAINER_TRANS_Y, this.CHANGE_EASE, new float[0]).setSpecial(DynamicIslandAnimationDelegate.CONTAINER_CLIP_TOP_PROGRESS, this.CHANGE_EASE, new float[0]).setSpecial(DynamicIslandAnimationDelegate.CONTAINER_CLIP_BOTTOM_PROGRESS, this.CHANGE_EASE, new float[0]).setSpecial(DynamicIslandAnimationDelegate.CONTAINER_CLIP_START_PROGRESS, this.CHANGE_EASE, new float[0]).setSpecial(DynamicIslandAnimationDelegate.CONTAINER_CLIP_END_PROGRESS, this.CHANGE_EASE, new float[0]).setSpecial(DynamicIslandAnimationDelegate.EXPANDED_SCALE_X, this.CHANGE_EASE, new float[0]).setSpecial(DynamicIslandAnimationDelegate.EXPANDED_SCALE_Y, this.CHANGE_EASE, new float[0]).setSpecial(DynamicIslandAnimationDelegate.EXPANDED_ALPHA, this.HIDDEN_EASE, new float[0]).setSpecial(DynamicIslandAnimationDelegate.EXPANDED_BLUR, this.HIDDEN_EASE, new float[0]).setSpecial(DynamicIslandAnimationDelegate.BIG_ISLAND_SCALE, this.CHANGE_EASE, new float[0]).setSpecial(DynamicIslandAnimationDelegate.BIG_ISLAND_ALPHA, this.SHOW_EASE, 50L, new float[0]).setSpecial(DynamicIslandAnimationDelegate.BIG_ISLAND_BLUR, this.SHOW_EASE, 50L, new float[0]).setSpecial(DynamicIslandAnimationDelegate.EXPANDED_TRANS_Y, this.CHANGE_EASE, new float[0]).setSpecial(DynamicIslandAnimationDelegate.BIG_ISLAND_TRANS_Y, this.CHANGE_EASE, new float[0]);
        FolmeKt.getFolme((FolmeObject)this).setTo((Object)var7_5, new AnimConfig[]{var5_4.addListeners(new TransitionListener[]{new DynamicIslandAnimListener(this, (DynamicIslandContentView)var1_1, var2_7){
            final float $beginX;
            final DynamicIslandContentView $view;
            final DynamicIslandAnimationDelegate this$0;
            {
                this.this$0 = dynamicIslandAnimationDelegate;
                this.$view = dynamicIslandContentView;
                this.$beginX = f2;
                super(dynamicIslandAnimationDelegate);
            }

            public void onBegin(Object object) {
                super.onBegin(object);
                DynamicIslandAnimationDelegate.access$setBlockUpdatePosition$p(this.this$0, true);
                DynamicIslandAnimationDelegate.access$setViewVisible(this.this$0, this.$view, 0);
                Object object2 = DynamicIslandAnimationDelegate.access$getFakeView(this.this$0);
                if (object2 != null) {
                    object2.setVisibility(4);
                }
                object2 = this.$view.getBigIslandView();
                if (object2 != null) {
                    object2.setVisibility(0);
                }
                object2 = this.$view.getSmallIslandView();
                if (object2 != null) {
                    object2.setVisibility(4);
                }
                Object object3 = DynamicIslandAnimationDelegate.access$getAnimationDelegateHelper$p(this.this$0);
                object2 = DynamicIslandAnimationType.EXPANDED_TO_BIG;
                ((DynamicIslandAnimationDelegateHelper)object3).requestUpdateHeadsUpLocation((DynamicIslandAnimationType)((Object)object2), this.$view);
                object3 = DynamicIslandAnimationDelegate.access$getDynamicIslandAnimController$p(this.this$0).getAnimationCallback$miui_dynamicisland_release();
                DynamicIslandAnimationCallbackType dynamicIslandAnimationCallbackType = DynamicIslandAnimationCallbackType.ANIM_START;
                o.e((Object)object, (String)"null cannot be cast to non-null type kotlin.String");
                ((DynamicIslandAnimationCallback)object3).executeCallback((DynamicIslandAnimationType)((Object)object2), dynamicIslandAnimationCallbackType, (String)object);
                DynamicIslandAnimationDelegate.access$getAnimationDelegateHelper$p(this.this$0).updateBigIslandContainerBackground(this.$view);
            }

            public void onCancel(Object object) {
                DynamicIslandAnimationDelegate.access$setBlockUpdatePosition$p(this.this$0, false);
                DynamicIslandAnimationCallback dynamicIslandAnimationCallback = DynamicIslandAnimationDelegate.access$getDynamicIslandAnimController$p(this.this$0).getAnimationCallback$miui_dynamicisland_release();
                DynamicIslandAnimationType dynamicIslandAnimationType = DynamicIslandAnimationType.EXPANDED_TO_BIG;
                DynamicIslandAnimationCallbackType dynamicIslandAnimationCallbackType = DynamicIslandAnimationCallbackType.ANIM_CANCEL;
                o.e((Object)object, (String)"null cannot be cast to non-null type kotlin.String");
                dynamicIslandAnimationCallback.executeCallback(dynamicIslandAnimationType, dynamicIslandAnimationCallbackType, (String)object);
                super.onCancel(object);
            }

            public void onComplete(Object object) {
                DynamicIslandAnimationDelegate.access$setBlockUpdatePosition$p(this.this$0, false);
                Object object2 = this.$view.getExpandedView();
                if (object2 != null) {
                    object2.setVisibility(4);
                }
                DynamicIslandAnimationCallback dynamicIslandAnimationCallback = DynamicIslandAnimationDelegate.access$getDynamicIslandAnimController$p(this.this$0).getAnimationCallback$miui_dynamicisland_release();
                object2 = DynamicIslandAnimationType.EXPANDED_TO_BIG;
                DynamicIslandAnimationCallbackType dynamicIslandAnimationCallbackType = DynamicIslandAnimationCallbackType.ANIM_FINISH;
                o.e((Object)object, (String)"null cannot be cast to non-null type kotlin.String");
                dynamicIslandAnimationCallback.executeCallback((DynamicIslandAnimationType)((Object)object2), dynamicIslandAnimationCallbackType, (String)object);
                super.onComplete(object);
            }

            public void onUpdate(Object object, Collection<UpdateInfo> collection) {
                DynamicIslandAnimationDelegate.access$fixTransX(this.this$0, collection, this.$beginX);
                super.onUpdate(object, collection);
            }
        }})});
        this.fakeViewToBigIsland((DynamicIslandContentView)var1_1, false);
    }

    public final void expandedToDeletedAnimation(DynamicIslandContentView dynamicIslandContentView) {
        o.g((Object)((Object)dynamicIslandContentView), (String)"view");
        EaseManager.EaseStyle easeStyle = this.SHOW_EASE;
        if (this.dynamicIslandAnimController.getDynamicIslandWindowState().isToScreenLockNoAnimation() || !DynamicIslandAnimUtils.INSTANCE.supportShowElementAnim()) {
            easeStyle = this.HIDDEN_EASE;
        }
        AnimState animState = CommonUtils.INSTANCE.getIS_TABLET() && !this.getPanelHeightChanging() ? this.getSlideOffAnimStatePad() : this.getCutoutAnimState();
        IFolme iFolme = FolmeKt.getFolme((FolmeObject)this);
        AnimConfig animConfig = new AnimConfig().setSpecial(CONTAINER_TRANS_Y, easeStyle, new float[0]).setSpecial(CONTAINER_CLIP_START_PROGRESS, easeStyle, new float[0]).setSpecial(CONTAINER_CLIP_END_PROGRESS, easeStyle, new float[0]).setSpecial(CONTAINER_CLIP_TOP_PROGRESS, easeStyle, new float[0]).setSpecial(CONTAINER_CLIP_BOTTOM_PROGRESS, easeStyle, new float[0]);
        FloatProperty<DynamicIslandAnimationDelegate> floatProperty = CONTAINER_ALPHA;
        EaseManager.EaseStyle easeStyle2 = this.getSupposedContainerAlpha() == 0.0f ? easeStyle : FolmeEase.linear((long)100L);
        long l = this.getSupposedContainerAlpha() == 0.0f ? 100L : 400L;
        iFolme.to((Object)animState, new AnimConfig[]{animConfig.setSpecial(floatProperty, easeStyle2, l, new float[0]).setSpecial(EXPANDED_TRANS_Y, easeStyle, new float[0]).setSpecial(EXPANDED_SCALE_X, easeStyle, new float[0]).setSpecial(EXPANDED_SCALE_Y, easeStyle, new float[0]).setSpecial(EXPANDED_ALPHA, easeStyle, new float[0]).setSpecial(EXPANDED_BLUR, easeStyle, new float[0]).addListeners(new TransitionListener[]{new DynamicIslandAnimListener(this, dynamicIslandContentView){
            final DynamicIslandContentView $view;
            final DynamicIslandAnimationDelegate this$0;
            {
                this.this$0 = dynamicIslandAnimationDelegate;
                this.$view = dynamicIslandContentView;
                super(dynamicIslandAnimationDelegate);
            }

            public void onBegin(Object object) {
                super.onBegin(object);
                Object object2 = DynamicIslandAnimationDelegate.access$getAnimationDelegateHelper$p(this.this$0);
                DynamicIslandAnimationType dynamicIslandAnimationType = DynamicIslandAnimationType.EXPANDED_TO_DELETED;
                ((DynamicIslandAnimationDelegateHelper)object2).requestUpdateHeadsUpLocation(dynamicIslandAnimationType, this.$view);
                object2 = DynamicIslandAnimationDelegate.access$getDynamicIslandAnimController$p(this.this$0).getAnimationCallback$miui_dynamicisland_release();
                DynamicIslandAnimationCallbackType dynamicIslandAnimationCallbackType = DynamicIslandAnimationCallbackType.ANIM_START;
                o.e((Object)object, (String)"null cannot be cast to non-null type kotlin.String");
                ((DynamicIslandAnimationCallback)object2).executeCallback(dynamicIslandAnimationType, dynamicIslandAnimationCallbackType, (String)object);
                DynamicIslandScenarioUtils.INSTANCE.setDynamicIslandScenarioState(476L, true);
            }

            public void onCancel(Object object) {
                DynamicIslandAnimationDelegate.removeViewFromWindow$default(this.this$0, this.$view, false, 2, null);
                DynamicIslandAnimationCallback dynamicIslandAnimationCallback = DynamicIslandAnimationDelegate.access$getDynamicIslandAnimController$p(this.this$0).getAnimationCallback$miui_dynamicisland_release();
                DynamicIslandAnimationType dynamicIslandAnimationType = DynamicIslandAnimationType.EXPANDED_TO_DELETED;
                DynamicIslandAnimationCallbackType dynamicIslandAnimationCallbackType = DynamicIslandAnimationCallbackType.ANIM_CANCEL;
                o.e((Object)object, (String)"null cannot be cast to non-null type kotlin.String");
                dynamicIslandAnimationCallback.executeCallback(dynamicIslandAnimationType, dynamicIslandAnimationCallbackType, (String)object);
                DynamicIslandScenarioUtils.INSTANCE.setDynamicIslandScenarioState(476L, false);
                super.onCancel(object);
            }

            public void onComplete(Object object) {
                DynamicIslandAnimationDelegate.removeViewFromWindow$default(this.this$0, this.$view, false, 2, null);
                DynamicIslandAnimationCallback dynamicIslandAnimationCallback = DynamicIslandAnimationDelegate.access$getDynamicIslandAnimController$p(this.this$0).getAnimationCallback$miui_dynamicisland_release();
                DynamicIslandAnimationType dynamicIslandAnimationType = DynamicIslandAnimationType.EXPANDED_TO_DELETED;
                DynamicIslandAnimationCallbackType dynamicIslandAnimationCallbackType = DynamicIslandAnimationCallbackType.ANIM_FINISH;
                o.e((Object)object, (String)"null cannot be cast to non-null type kotlin.String");
                dynamicIslandAnimationCallback.executeCallback(dynamicIslandAnimationType, dynamicIslandAnimationCallbackType, (String)object);
                DynamicIslandScenarioUtils.INSTANCE.setDynamicIslandScenarioState(476L, false);
                super.onComplete(object);
            }
        }})});
        this.fakeViewToDeleted(dynamicIslandContentView);
    }

    public final void expandedToDeletedNoAnimation(DynamicIslandContentView dynamicIslandContentView) {
        o.g((Object)((Object)dynamicIslandContentView), (String)"view");
        IFolme iFolme = FolmeKt.getFolme((FolmeObject)this);
        AnimState animState = CommonUtils.INSTANCE.getIS_TABLET() && !this.getPanelHeightChanging() ? this.getSlideOffAnimStatePad() : this.getCutoutAnimState();
        AnimConfig animConfig = new AnimConfig();
        FloatProperty<DynamicIslandAnimationDelegate> floatProperty = CONTAINER_ALPHA;
        EaseManager.EaseStyle easeStyle = this.getSupposedContainerAlpha() == 0.0f ? this.SHOW_EASE : FolmeEase.linear((long)100L);
        long l = this.getSupposedContainerAlpha() == 0.0f ? 100L : 400L;
        iFolme.setTo((Object)animState, new AnimConfig[]{animConfig.setSpecial(floatProperty, easeStyle, l, new float[0]).addListeners(new TransitionListener[]{new DynamicIslandAnimListener(this, dynamicIslandContentView){
            final DynamicIslandContentView $view;
            final DynamicIslandAnimationDelegate this$0;
            {
                this.this$0 = dynamicIslandAnimationDelegate;
                this.$view = dynamicIslandContentView;
                super(dynamicIslandAnimationDelegate);
            }

            public void onBegin(Object object) {
                super.onBegin(object);
                Object object2 = DynamicIslandAnimationDelegate.access$getAnimationDelegateHelper$p(this.this$0);
                DynamicIslandAnimationType dynamicIslandAnimationType = DynamicIslandAnimationType.EXPANDED_TO_DELETED;
                object2.requestUpdateHeadsUpLocation(dynamicIslandAnimationType, this.$view);
                DynamicIslandAnimationCallback dynamicIslandAnimationCallback = DynamicIslandAnimationDelegate.access$getDynamicIslandAnimController$p(this.this$0).getAnimationCallback$miui_dynamicisland_release();
                object2 = DynamicIslandAnimationCallbackType.ANIM_START;
                o.e((Object)object, (String)"null cannot be cast to non-null type kotlin.String");
                dynamicIslandAnimationCallback.executeCallback(dynamicIslandAnimationType, (DynamicIslandAnimationCallbackType)((Object)object2), (String)object);
            }

            public void onCancel(Object object) {
                DynamicIslandAnimationDelegate.removeViewFromWindow$default(this.this$0, this.$view, false, 2, null);
                DynamicIslandAnimationCallback dynamicIslandAnimationCallback = DynamicIslandAnimationDelegate.access$getDynamicIslandAnimController$p(this.this$0).getAnimationCallback$miui_dynamicisland_release();
                DynamicIslandAnimationType dynamicIslandAnimationType = DynamicIslandAnimationType.EXPANDED_TO_DELETED;
                DynamicIslandAnimationCallbackType dynamicIslandAnimationCallbackType = DynamicIslandAnimationCallbackType.ANIM_CANCEL;
                o.e((Object)object, (String)"null cannot be cast to non-null type kotlin.String");
                dynamicIslandAnimationCallback.executeCallback(dynamicIslandAnimationType, dynamicIslandAnimationCallbackType, (String)object);
                super.onCancel(object);
            }

            public void onComplete(Object object) {
                DynamicIslandAnimationDelegate.removeViewFromWindow$default(this.this$0, this.$view, false, 2, null);
                DynamicIslandAnimationCallback dynamicIslandAnimationCallback = DynamicIslandAnimationDelegate.access$getDynamicIslandAnimController$p(this.this$0).getAnimationCallback$miui_dynamicisland_release();
                DynamicIslandAnimationType dynamicIslandAnimationType = DynamicIslandAnimationType.EXPANDED_TO_DELETED;
                DynamicIslandAnimationCallbackType dynamicIslandAnimationCallbackType = DynamicIslandAnimationCallbackType.ANIM_FINISH;
                o.e((Object)object, (String)"null cannot be cast to non-null type kotlin.String");
                dynamicIslandAnimationCallback.executeCallback(dynamicIslandAnimationType, dynamicIslandAnimationCallbackType, (String)object);
                super.onComplete(object);
            }
        }})});
        this.fakeViewToDeleted(dynamicIslandContentView);
    }

    public final void expandedToHiddenAnimation(DynamicIslandContentView dynamicIslandContentView, boolean bl) {
        o.g((Object)((Object)dynamicIslandContentView), (String)"view");
        this.hiddenStateFrom = new DynamicIslandState(){};
        CommonUtils commonUtils = CommonUtils.INSTANCE;
        Object object = commonUtils.getIS_TABLET() ? this.getHiddenAnimStatePad() : this.getHiddenAnimState();
        AnimConfig animConfig = commonUtils.getIS_TABLET() ? new AnimConfig().setSpecial(CONTAINER_CLIP_END_PROGRESS, this.EASE_SPRING_083_042, new float[0]).setSpecial(CONTAINER_CLIP_TOP_PROGRESS, this.EASE_SPRING_083_042, new float[0]).setSpecial(CONTAINER_CLIP_START_PROGRESS, this.EASE_SPRING_083_042, new float[0]).setSpecial(CONTAINER_CLIP_BOTTOM_PROGRESS, this.EASE_SPRING_083_042, new float[0]).setSpecial(CONTAINER_X, this.EASE_SPRING_083_042, new float[0]).setSpecial(CONTAINER_TRANS_Y, this.EASE_SPRING_083_042, new float[0]).setSpecial(EXPANDED_ALPHA, this.EASE_SPRING_095_015, new float[0]).setSpecial(EXPANDED_SCALE_X, this.EASE_SPRING_083_042, new float[0]).setSpecial(EXPANDED_SCALE_Y, this.EASE_SPRING_083_042, new float[0]).setSpecial(EXPANDED_BLUR, this.EASE_SPRING_095_015, new float[0]).setSpecial(BIG_ISLAND_ALPHA, this.EASE_SPRING_095_035, 100L, new float[0]).setSpecial(BIG_ISLAND_SCALE, this.EASE_SPRING_083_042, new float[0]).setSpecial(BIG_ISLAND_BLUR, this.EASE_SPRING_095_035, new float[0]).setSpecial(CONTAINER_ALPHA, this.EASE_SPRING_095_015, 150L, new float[0]).setSpecial(EXPANDED_TRANS_X, this.EASE_SPRING_083_042, new float[0]).setSpecial(EXPANDED_TRANS_Y, this.EASE_SPRING_083_042, new float[0]) : new AnimConfig().setSpecial(CONTAINER_CLIP_END_PROGRESS, this.CHANGE_EASE, new float[0]).setSpecial(CONTAINER_CLIP_TOP_PROGRESS, this.CHANGE_EASE, new float[0]).setSpecial(CONTAINER_CLIP_START_PROGRESS, this.CHANGE_EASE, new float[0]).setSpecial(CONTAINER_X, this.CHANGE_EASE, new float[0]).setSpecial(CONTAINER_CLIP_BOTTOM_PROGRESS, this.CHANGE_EASE, new float[0]).setSpecial(CONTAINER_TRANS_Y, this.CHANGE_EASE, new float[0]).setSpecial(CONTAINER_ALPHA, this.HIDDEN_EASE, 150L, new float[0]).setSpecial(SMALL_ISLAND_SCALE, this.CHANGE_EASE, new float[0]);
        FolmeKt.getFolme((FolmeObject)this).to(object, new AnimConfig[]{animConfig.addListeners(new TransitionListener[]{new DynamicIslandAnimListener(this, bl, dynamicIslandContentView){
            final boolean $isAppClose;
            final DynamicIslandContentView $view;
            final DynamicIslandAnimationDelegate this$0;
            {
                this.this$0 = dynamicIslandAnimationDelegate;
                this.$isAppClose = bl;
                this.$view = dynamicIslandContentView;
                super(dynamicIslandAnimationDelegate);
            }

            public void onBegin(Object object) {
                Object object2;
                super.onBegin(object);
                if (!this.$isAppClose && !this.this$0.getIslandWindowAnimRunning()) {
                    DynamicIslandAnimationDelegate.access$setViewVisible(this.this$0, this.$view, 0);
                    object2 = this.$view.getFakeView();
                    if (object2 != null) {
                        ((DynamicIslandContentFakeView)((Object)object2)).setVisibility(4);
                    }
                }
                if ((object2 = this.$view.getSmallIslandView()) != null) {
                    object2.setVisibility(0);
                }
                Object object3 = DynamicIslandAnimationDelegate.access$getAnimationDelegateHelper$p(this.this$0);
                object2 = DynamicIslandAnimationType.EXPANDED_TO_HIDDEN;
                ((DynamicIslandAnimationDelegateHelper)object3).requestUpdateHeadsUpLocation((DynamicIslandAnimationType)((Object)object2), this.$view);
                DynamicIslandScenarioUtils.INSTANCE.setDynamicIslandScenarioState(476L, true);
                object3 = DynamicIslandAnimationDelegate.access$getDynamicIslandAnimController$p(this.this$0).getAnimationCallback$miui_dynamicisland_release();
                DynamicIslandAnimationCallbackType dynamicIslandAnimationCallbackType = DynamicIslandAnimationCallbackType.ANIM_START;
                o.e((Object)object, (String)"null cannot be cast to non-null type kotlin.String");
                ((DynamicIslandAnimationCallback)object3).executeCallback((DynamicIslandAnimationType)((Object)object2), dynamicIslandAnimationCallbackType, (String)object);
                DynamicIslandAnimationDelegate.access$getAnimationDelegateHelper$p(this.this$0).updateBigIslandContainerBackground(this.$view);
            }

            public void onCancel(Object object) {
                Object object2 = DynamicIslandScenarioUtils.INSTANCE;
                if (object2.isExpandTracking()) {
                    object2.setDynamicIslandScenarioState(496L, false);
                    object2.setExpandTracking(false);
                }
                object2.setDynamicIslandScenarioState(476L, false);
                DynamicIslandAnimationCallback dynamicIslandAnimationCallback = DynamicIslandAnimationDelegate.access$getDynamicIslandAnimController$p(this.this$0).getAnimationCallback$miui_dynamicisland_release();
                DynamicIslandAnimationType dynamicIslandAnimationType = DynamicIslandAnimationType.EXPANDED_TO_HIDDEN;
                object2 = DynamicIslandAnimationCallbackType.ANIM_CANCEL;
                o.e((Object)object, (String)"null cannot be cast to non-null type kotlin.String");
                dynamicIslandAnimationCallback.executeCallback(dynamicIslandAnimationType, (DynamicIslandAnimationCallbackType)((Object)object2), (String)object);
                super.onCancel(object);
            }

            public void onComplete(Object object) {
                Object object2 = this.$view.getExpandedView();
                if (object2 != null) {
                    object2.setVisibility(4);
                }
                object2 = this.$view.getFakeView();
                object2 = object2 != null ? object2.getFakeSmallIsland() : null;
                if (object2 != null) {
                    object2.setVisibility(4);
                }
                if (!this.$isAppClose && (object2 = this.$view.getFakeView()) != null) {
                    object2.setVisibility(4);
                }
                if ((object2 = DynamicIslandScenarioUtils.INSTANCE).isExpandTracking()) {
                    object2.setDynamicIslandScenarioState(496L, false);
                    object2.setExpandTracking(false);
                }
                object2.setDynamicIslandScenarioState(476L, false);
                object2 = DynamicIslandAnimationDelegate.access$getDynamicIslandAnimController$p(this.this$0).getAnimationCallback$miui_dynamicisland_release();
                DynamicIslandAnimationType dynamicIslandAnimationType = DynamicIslandAnimationType.EXPANDED_TO_HIDDEN;
                DynamicIslandAnimationCallbackType dynamicIslandAnimationCallbackType = DynamicIslandAnimationCallbackType.ANIM_FINISH;
                o.e((Object)object, (String)"null cannot be cast to non-null type kotlin.String");
                object2.executeCallback(dynamicIslandAnimationType, dynamicIslandAnimationCallbackType, (String)object);
                super.onComplete(object);
            }
        }})});
        if (commonUtils.getIS_TABLET() && bl) {
            object = this.getFakeView();
            if (object != null && (animConfig = FolmeKt.getFolme((View)object)) != null) {
                commonUtils = new AnimState();
                object = ViewProperty.ALPHA;
                animConfig.to((Object)commonUtils.add((ViewProperty)object, 0.0f, new long[0]), new AnimConfig[]{new AnimConfig().setSpecial((FloatProperty)object, 100L, new float[0])});
            }
            this.fakeViewToBigIsland(dynamicIslandContentView, bl);
        } else {
            this.fakeViewToHidden(dynamicIslandContentView, bl);
        }
    }

    public final void expandedToHiddenNoAnim(DynamicIslandContentView dynamicIslandContentView) {
        o.g((Object)((Object)dynamicIslandContentView), (String)"view");
        IFolme iFolme = FolmeKt.getFolme((FolmeObject)this);
        AnimState animState = CommonUtils.INSTANCE.getIS_TABLET() ? this.getHiddenAnimStatePad() : this.getCutoutAnimState();
        iFolme.setTo((Object)animState, new AnimConfig[]{new AnimConfig().addListeners(new TransitionListener[]{new DynamicIslandAnimListener(this, dynamicIslandContentView){
            final DynamicIslandContentView $view;
            final DynamicIslandAnimationDelegate this$0;
            {
                this.this$0 = dynamicIslandAnimationDelegate;
                this.$view = dynamicIslandContentView;
                super(dynamicIslandAnimationDelegate);
            }

            public void onBegin(Object object) {
                super.onBegin(object);
                Object object2 = DynamicIslandAnimationDelegate.access$getAnimationDelegateHelper$p(this.this$0);
                DynamicIslandAnimationType dynamicIslandAnimationType = DynamicIslandAnimationType.EXPANDED_TO_HIDDEN;
                object2.requestUpdateHeadsUpLocation(dynamicIslandAnimationType, this.$view);
                DynamicIslandAnimationCallback dynamicIslandAnimationCallback = DynamicIslandAnimationDelegate.access$getDynamicIslandAnimController$p(this.this$0).getAnimationCallback$miui_dynamicisland_release();
                object2 = DynamicIslandAnimationCallbackType.ANIM_START;
                o.e((Object)object, (String)"null cannot be cast to non-null type kotlin.String");
                dynamicIslandAnimationCallback.executeCallback(dynamicIslandAnimationType, (DynamicIslandAnimationCallbackType)((Object)object2), (String)object);
                DynamicIslandAnimationDelegate.access$getAnimationDelegateHelper$p(this.this$0).updateBigIslandContainerBackground(this.$view);
            }

            public void onCancel(Object object) {
                DynamicIslandAnimationCallback dynamicIslandAnimationCallback = DynamicIslandAnimationDelegate.access$getDynamicIslandAnimController$p(this.this$0).getAnimationCallback$miui_dynamicisland_release();
                DynamicIslandAnimationType dynamicIslandAnimationType = DynamicIslandAnimationType.EXPANDED_TO_HIDDEN;
                DynamicIslandAnimationCallbackType dynamicIslandAnimationCallbackType = DynamicIslandAnimationCallbackType.ANIM_CANCEL;
                o.e((Object)object, (String)"null cannot be cast to non-null type kotlin.String");
                dynamicIslandAnimationCallback.executeCallback(dynamicIslandAnimationType, dynamicIslandAnimationCallbackType, (String)object);
                super.onCancel(object);
            }

            public void onComplete(Object object) {
                DynamicIslandAnimationCallback dynamicIslandAnimationCallback = DynamicIslandAnimationDelegate.access$getDynamicIslandAnimController$p(this.this$0).getAnimationCallback$miui_dynamicisland_release();
                DynamicIslandAnimationType dynamicIslandAnimationType = DynamicIslandAnimationType.EXPANDED_TO_HIDDEN;
                DynamicIslandAnimationCallbackType dynamicIslandAnimationCallbackType = DynamicIslandAnimationCallbackType.ANIM_FINISH;
                o.e((Object)object, (String)"null cannot be cast to non-null type kotlin.String");
                dynamicIslandAnimationCallback.executeCallback(dynamicIslandAnimationType, dynamicIslandAnimationCallbackType, (String)object);
                super.onComplete(object);
            }
        }})});
    }

    public final void expandedToMiniWindowAnimation(DynamicIslandContentView dynamicIslandContentView) {
        o.g((Object)((Object)dynamicIslandContentView), (String)"view");
        Object object = dynamicIslandContentView.getDynamicIslandEventCoordinator();
        boolean bl = object != null && (object = ((DynamicIslandEventCoordinator)object).getWindowView()) != null && (object = ((DynamicIslandWindowView)((Object)object)).getWindowViewController()) != null && ((DynamicIslandWindowViewController)object).isWorkbenchModeEnabled();
        if (CommonUtils.INSTANCE.getIS_TABLET() && bl) {
            object = dynamicIslandContentView.getDynamicIslandEventCoordinator();
            if (object != null) {
                ((DynamicIslandEventCoordinator)object).updateView(dynamicIslandContentView);
            }
            this.expandedToTempHiddenAnimation(dynamicIslandContentView, true);
        } else {
            FolmeKt.getFolme((FolmeObject)this).setTo((Object)this.getCutoutAnimState(), new AnimConfig[]{new AnimConfig().addListeners(new TransitionListener[]{new DynamicIslandAnimListener(this, dynamicIslandContentView){
                final DynamicIslandContentView $view;
                final DynamicIslandAnimationDelegate this$0;
                {
                    this.this$0 = dynamicIslandAnimationDelegate;
                    this.$view = dynamicIslandContentView;
                    super(dynamicIslandAnimationDelegate);
                }

                public void onBegin(Object object) {
                    super.onBegin(object);
                    Object object2 = DynamicIslandAnimationDelegate.access$getAnimationDelegateHelper$p(this.this$0);
                    DynamicIslandAnimationType dynamicIslandAnimationType = DynamicIslandAnimationType.EXPANDED_TO_BIG;
                    ((DynamicIslandAnimationDelegateHelper)object2).requestUpdateHeadsUpLocation(dynamicIslandAnimationType, this.$view);
                    object2 = DynamicIslandAnimationDelegate.access$getDynamicIslandAnimController$p(this.this$0).getAnimationCallback$miui_dynamicisland_release();
                    DynamicIslandAnimationCallbackType dynamicIslandAnimationCallbackType = DynamicIslandAnimationCallbackType.ANIM_START;
                    o.e((Object)object, (String)"null cannot be cast to non-null type kotlin.String");
                    ((DynamicIslandAnimationCallback)object2).executeCallback(dynamicIslandAnimationType, dynamicIslandAnimationCallbackType, (String)object);
                }

                public void onCancel(Object object) {
                    DynamicIslandAnimationCallback dynamicIslandAnimationCallback = DynamicIslandAnimationDelegate.access$getDynamicIslandAnimController$p(this.this$0).getAnimationCallback$miui_dynamicisland_release();
                    DynamicIslandAnimationType dynamicIslandAnimationType = DynamicIslandAnimationType.EXPANDED_TO_BIG;
                    DynamicIslandAnimationCallbackType dynamicIslandAnimationCallbackType = DynamicIslandAnimationCallbackType.ANIM_CANCEL;
                    o.e((Object)object, (String)"null cannot be cast to non-null type kotlin.String");
                    dynamicIslandAnimationCallback.executeCallback(dynamicIslandAnimationType, dynamicIslandAnimationCallbackType, (String)object);
                    super.onCancel(object);
                }

                public void onComplete(Object object) {
                    DynamicIslandAnimationCallback dynamicIslandAnimationCallback = DynamicIslandAnimationDelegate.access$getDynamicIslandAnimController$p(this.this$0).getAnimationCallback$miui_dynamicisland_release();
                    DynamicIslandAnimationType dynamicIslandAnimationType = DynamicIslandAnimationType.EXPANDED_TO_BIG;
                    DynamicIslandAnimationCallbackType dynamicIslandAnimationCallbackType = DynamicIslandAnimationCallbackType.ANIM_FINISH;
                    o.e((Object)object, (String)"null cannot be cast to non-null type kotlin.String");
                    dynamicIslandAnimationCallback.executeCallback(dynamicIslandAnimationType, dynamicIslandAnimationCallbackType, (String)object);
                    super.onComplete(object);
                }
            }})});
            this.scheduleUpdate();
            this.setViewVisible(dynamicIslandContentView, 4);
        }
        this.animationDelegateHelper.requestUpdateHeadsUpLocation(DynamicIslandAnimationType.EXPANDED_TO_MINI_WINDOW, dynamicIslandContentView);
    }

    public final void expandedToSmallIslandAnimation(DynamicIslandContentView dynamicIslandContentView) {
        o.g((Object)((Object)dynamicIslandContentView), (String)"view");
        FolmeKt.getFolme((FolmeObject)this).to((Object)this.getSmallIslandAnimState(), new AnimConfig[]{new AnimConfig().setSpecial(CONTAINER_CLIP_END_PROGRESS, this.CHANGE_EASE, new float[0]).setSpecial(CONTAINER_CLIP_START_PROGRESS, this.CHANGE_EASE, new float[0]).setSpecial(CONTAINER_X, this.CHANGE_EASE, new float[0]).setSpecial(CONTAINER_CLIP_BOTTOM_PROGRESS, this.CHANGE_EASE, new float[0]).setSpecial(CONTAINER_TRANS_Y, this.CHANGE_EASE, new float[0]).setSpecial(EXPANDED_SCALE_X, this.CHANGE_EASE, new float[0]).setSpecial(EXPANDED_SCALE_Y, this.CHANGE_EASE, new float[0]).setSpecial(EXPANDED_TRANS_Y, this.CHANGE_EASE, new float[0]).setSpecial(EXPANDED_ALPHA, this.HIDDEN_EASE, new float[0]).setSpecial(SMALL_ISLAND_TRANS_X, this.CHANGE_EASE, new float[0]).setSpecial(SMALL_ISLAND_TRANS_Y, this.CHANGE_EASE, new float[0]).setSpecial(SMALL_ISLAND_ALPHA, this.SHOW_EASE, 50L, new float[0]).addListeners(new TransitionListener[]{new DynamicIslandAnimListener(this, dynamicIslandContentView){
            final DynamicIslandContentView $view;
            final DynamicIslandAnimationDelegate this$0;
            {
                this.this$0 = dynamicIslandAnimationDelegate;
                this.$view = dynamicIslandContentView;
                super(dynamicIslandAnimationDelegate);
            }

            public void onBegin(Object object) {
                super.onBegin(object);
                DynamicIslandAnimationDelegate.access$setViewVisible(this.this$0, this.$view, 0);
                Object object2 = this.$view.getFakeView();
                if (object2 != null) {
                    object2.setVisibility(4);
                }
                object2 = this.$view.getSmallIslandView();
                if (object2 != null) {
                    object2.setVisibility(0);
                }
                Object object3 = DynamicIslandAnimationDelegate.access$getAnimationDelegateHelper$p(this.this$0);
                object2 = DynamicIslandAnimationType.EXPANDED_TO_SMALL;
                ((DynamicIslandAnimationDelegateHelper)object3).requestUpdateHeadsUpLocation((DynamicIslandAnimationType)((Object)object2), this.$view);
                object3 = DynamicIslandAnimationDelegate.access$getDynamicIslandAnimController$p(this.this$0).getAnimationCallback$miui_dynamicisland_release();
                DynamicIslandAnimationCallbackType dynamicIslandAnimationCallbackType = DynamicIslandAnimationCallbackType.ANIM_START;
                o.e((Object)object, (String)"null cannot be cast to non-null type kotlin.String");
                ((DynamicIslandAnimationCallback)object3).executeCallback((DynamicIslandAnimationType)((Object)object2), dynamicIslandAnimationCallbackType, (String)object);
                DynamicIslandScenarioUtils.INSTANCE.setDynamicIslandScenarioState(478L, true);
            }

            public void onCancel(Object object) {
                DynamicIslandAnimationCallback dynamicIslandAnimationCallback = DynamicIslandAnimationDelegate.access$getDynamicIslandAnimController$p(this.this$0).getAnimationCallback$miui_dynamicisland_release();
                DynamicIslandAnimationType dynamicIslandAnimationType = DynamicIslandAnimationType.EXPANDED_TO_SMALL;
                DynamicIslandAnimationCallbackType dynamicIslandAnimationCallbackType = DynamicIslandAnimationCallbackType.ANIM_CANCEL;
                o.e((Object)object, (String)"null cannot be cast to non-null type kotlin.String");
                dynamicIslandAnimationCallback.executeCallback(dynamicIslandAnimationType, dynamicIslandAnimationCallbackType, (String)object);
                super.onCancel(object);
                object = DynamicIslandScenarioUtils.INSTANCE;
                if (((DynamicIslandScenarioUtils)object).isExpandTracking()) {
                    ((DynamicIslandScenarioUtils)object).setDynamicIslandScenarioState(496L, false);
                    ((DynamicIslandScenarioUtils)object).setExpandTracking(false);
                }
                ((DynamicIslandScenarioUtils)object).setDynamicIslandScenarioState(478L, false);
            }

            public void onComplete(Object object) {
                Object object2 = this.$view.getExpandedView();
                if (object2 != null) {
                    object2.setVisibility(4);
                }
                object2 = DynamicIslandAnimationDelegate.access$getDynamicIslandAnimController$p(this.this$0).getAnimationCallback$miui_dynamicisland_release();
                DynamicIslandAnimationType dynamicIslandAnimationType = DynamicIslandAnimationType.EXPANDED_TO_SMALL;
                DynamicIslandAnimationCallbackType dynamicIslandAnimationCallbackType = DynamicIslandAnimationCallbackType.ANIM_FINISH;
                o.e((Object)object, (String)"null cannot be cast to non-null type kotlin.String");
                ((DynamicIslandAnimationCallback)object2).executeCallback(dynamicIslandAnimationType, dynamicIslandAnimationCallbackType, (String)object);
                super.onComplete(object);
                object = DynamicIslandScenarioUtils.INSTANCE;
                if (((DynamicIslandScenarioUtils)object).isExpandTracking()) {
                    ((DynamicIslandScenarioUtils)object).setDynamicIslandScenarioState(496L, false);
                    ((DynamicIslandScenarioUtils)object).setExpandTracking(false);
                }
                ((DynamicIslandScenarioUtils)object).setDynamicIslandScenarioState(478L, false);
            }
        }})});
        this.fakeViewToSmallIsland(dynamicIslandContentView, false);
    }

    public final void expandedToSmallIslandNoAnimation(DynamicIslandContentView dynamicIslandContentView) {
        o.g((Object)((Object)dynamicIslandContentView), (String)"view");
        FolmeKt.getFolme((FolmeObject)this).setTo((Object)this.getSmallIslandAnimState(), new AnimConfig[]{new AnimConfig().setSpecial(CONTAINER_CLIP_END_PROGRESS, this.CHANGE_EASE, new float[0]).setSpecial(CONTAINER_CLIP_START_PROGRESS, this.CHANGE_EASE, new float[0]).setSpecial(CONTAINER_X, this.CHANGE_EASE, new float[0]).setSpecial(CONTAINER_CLIP_BOTTOM_PROGRESS, this.CHANGE_EASE, new float[0]).setSpecial(CONTAINER_TRANS_Y, this.CHANGE_EASE, new float[0]).addListeners(new TransitionListener[]{new DynamicIslandAnimListener(this, dynamicIslandContentView){
            final DynamicIslandContentView $view;
            final DynamicIslandAnimationDelegate this$0;
            {
                this.this$0 = dynamicIslandAnimationDelegate;
                this.$view = dynamicIslandContentView;
                super(dynamicIslandAnimationDelegate);
            }

            public void onBegin(Object object) {
                super.onBegin(object);
                Object object2 = this.$view.getSmallIslandView();
                if (object2 != null) {
                    object2.setVisibility(0);
                }
                Object object3 = DynamicIslandAnimationDelegate.access$getAnimationDelegateHelper$p(this.this$0);
                object2 = DynamicIslandAnimationType.EXPANDED_TO_SMALL;
                ((DynamicIslandAnimationDelegateHelper)object3).requestUpdateHeadsUpLocation((DynamicIslandAnimationType)((Object)object2), this.$view);
                object3 = DynamicIslandAnimationDelegate.access$getDynamicIslandAnimController$p(this.this$0).getAnimationCallback$miui_dynamicisland_release();
                DynamicIslandAnimationCallbackType dynamicIslandAnimationCallbackType = DynamicIslandAnimationCallbackType.ANIM_START;
                o.e((Object)object, (String)"null cannot be cast to non-null type kotlin.String");
                ((DynamicIslandAnimationCallback)object3).executeCallback((DynamicIslandAnimationType)((Object)object2), dynamicIslandAnimationCallbackType, (String)object);
            }

            public void onCancel(Object object) {
                DynamicIslandAnimationCallback dynamicIslandAnimationCallback = DynamicIslandAnimationDelegate.access$getDynamicIslandAnimController$p(this.this$0).getAnimationCallback$miui_dynamicisland_release();
                DynamicIslandAnimationType dynamicIslandAnimationType = DynamicIslandAnimationType.EXPANDED_TO_SMALL;
                DynamicIslandAnimationCallbackType dynamicIslandAnimationCallbackType = DynamicIslandAnimationCallbackType.ANIM_CANCEL;
                o.e((Object)object, (String)"null cannot be cast to non-null type kotlin.String");
                dynamicIslandAnimationCallback.executeCallback(dynamicIslandAnimationType, dynamicIslandAnimationCallbackType, (String)object);
                super.onCancel(object);
            }

            public void onComplete(Object object) {
                Object object2 = this.$view.getExpandedView();
                if (object2 != null) {
                    object2.setVisibility(4);
                }
                object2 = DynamicIslandAnimationDelegate.access$getDynamicIslandAnimController$p(this.this$0).getAnimationCallback$miui_dynamicisland_release();
                DynamicIslandAnimationType dynamicIslandAnimationType = DynamicIslandAnimationType.EXPANDED_TO_SMALL;
                DynamicIslandAnimationCallbackType dynamicIslandAnimationCallbackType = DynamicIslandAnimationCallbackType.ANIM_FINISH;
                o.e((Object)object, (String)"null cannot be cast to non-null type kotlin.String");
                ((DynamicIslandAnimationCallback)object2).executeCallback(dynamicIslandAnimationType, dynamicIslandAnimationCallbackType, (String)object);
                super.onComplete(object);
            }
        }})});
        this.fakeViewToSmallIsland(dynamicIslandContentView, false);
    }

    public final void expandedToTempHiddenAnimation(DynamicIslandContentView dynamicIslandBaseContentView, boolean bl) {
        CommonUtils commonUtils;
        o.g((Object)((Object)dynamicIslandBaseContentView), (String)"view");
        EaseManager.EaseStyle easeStyle = this.SHOW_EASE;
        if (this.dynamicIslandAnimController.getDynamicIslandWindowState().isToScreenLockNoAnimation() || !DynamicIslandAnimUtils.INSTANCE.supportShowElementAnim()) {
            easeStyle = this.HIDDEN_EASE;
        }
        if (DynamicIslandAnimUtils.INSTANCE.supportShowElementAnim()) {
            this.expandedToTempHiddenAnimating = true;
        }
        if (this.getExpandedShouldTransX() == 0.0f) {
            ((DynamicIslandContentView)dynamicIslandBaseContentView).updateBigIslandLayout();
        }
        AnimState animState = (commonUtils = CommonUtils.INSTANCE).getIS_TABLET() && (bl || !this.getPanelHeightChanging()) ? this.getSlideOffAnimStatePad() : this.getCutoutAnimState();
        IFolme iFolme = FolmeKt.getFolme((FolmeObject)this);
        AnimConfig animConfig = new AnimConfig().setSpecial(CONTAINER_TRANS_Y, easeStyle, new float[0]).setSpecial(CONTAINER_CLIP_START_PROGRESS, easeStyle, new float[0]).setSpecial(CONTAINER_CLIP_END_PROGRESS, easeStyle, new float[0]).setSpecial(CONTAINER_CLIP_TOP_PROGRESS, easeStyle, new float[0]).setSpecial(CONTAINER_CLIP_BOTTOM_PROGRESS, easeStyle, new float[0]);
        FloatProperty<DynamicIslandAnimationDelegate> floatProperty = CONTAINER_ALPHA;
        EaseManager.EaseStyle easeStyle2 = this.getSupposedContainerAlpha() == 0.0f ? easeStyle : FolmeEase.linear((long)100L);
        long l = this.getSupposedContainerAlpha() == 0.0f ? 100L : 400L;
        easeStyle2 = animConfig.setSpecial(floatProperty, easeStyle2, l, new float[0]).setSpecial(EXPANDED_TRANS_Y, easeStyle, new float[0]).setSpecial(EXPANDED_SCALE_X, easeStyle, new float[0]).setSpecial(EXPANDED_SCALE_Y, easeStyle, new float[0]).setSpecial(EXPANDED_ALPHA, easeStyle, new float[0]).setSpecial(EXPANDED_BLUR, easeStyle, new float[0]);
        if (commonUtils.getIS_TABLET()) {
            easeStyle2.setSpecial(EXPANDED_TRANS_X, easeStyle, new float[0]);
            easeStyle2.setSpecial(BIG_ISLAND_TRANS_X, easeStyle, new float[0]);
        }
        easeStyle = s.a;
        iFolme.to((Object)animState, new AnimConfig[]{easeStyle2.addListeners(new TransitionListener[]{new DynamicIslandAnimListener(this, (DynamicIslandContentView)dynamicIslandBaseContentView, bl){
            final boolean $forceSlideOffPad;
            final DynamicIslandContentView $view;
            final DynamicIslandAnimationDelegate this$0;
            {
                this.this$0 = dynamicIslandAnimationDelegate;
                this.$view = dynamicIslandContentView;
                this.$forceSlideOffPad = bl;
                super(dynamicIslandAnimationDelegate);
            }

            public void onBegin(Object object) {
                super.onBegin(object);
                Object object2 = this.$view.getWindowState();
                if (!(object2 == null || ((DynamicIslandWindowState)object2).getKeyguardShowing() || (object2 = this.$view.getWindowState()) == null || ((DynamicIslandWindowState)object2).getNotificationVisible() || (object2 = this.$view.getWindowState()) == null || (object2 = ((DynamicIslandWindowState)object2).getScreenPinning()) == null || ((Boolean)object2.getValue()).booleanValue())) {
                    DynamicIslandAnimationDelegate.access$setViewVisible(this.this$0, this.$view, 0);
                }
                Object object3 = DynamicIslandAnimationDelegate.access$getAnimationDelegateHelper$p(this.this$0);
                object2 = DynamicIslandAnimationType.EXPANDED_TO_TEMP_HIDDEN;
                object3.requestUpdateHeadsUpLocation((DynamicIslandAnimationType)((Object)object2), this.$view);
                DynamicIslandAnimationCallback dynamicIslandAnimationCallback = DynamicIslandAnimationDelegate.access$getDynamicIslandAnimController$p(this.this$0).getAnimationCallback$miui_dynamicisland_release();
                object3 = DynamicIslandAnimationCallbackType.ANIM_START;
                o.e((Object)object, (String)"null cannot be cast to non-null type kotlin.String");
                dynamicIslandAnimationCallback.executeCallback((DynamicIslandAnimationType)((Object)object2), (DynamicIslandAnimationCallbackType)((Object)object3), (String)object);
                DynamicIslandScenarioUtils.INSTANCE.setDynamicIslandScenarioState(476L, true);
            }

            public void onCancel(Object object) {
                Object object2 = DynamicIslandScenarioUtils.INSTANCE;
                if (object2.isExpandTracking()) {
                    object2.setDynamicIslandScenarioState(496L, false);
                    object2.setExpandTracking(false);
                }
                object2.setDynamicIslandScenarioState(476L, false);
                DynamicIslandAnimationCallback dynamicIslandAnimationCallback = DynamicIslandAnimationDelegate.access$getDynamicIslandAnimController$p(this.this$0).getAnimationCallback$miui_dynamicisland_release();
                DynamicIslandAnimationType dynamicIslandAnimationType = DynamicIslandAnimationType.EXPANDED_TO_TEMP_HIDDEN;
                object2 = DynamicIslandAnimationCallbackType.ANIM_CANCEL;
                o.e((Object)object, (String)"null cannot be cast to non-null type kotlin.String");
                dynamicIslandAnimationCallback.executeCallback(dynamicIslandAnimationType, (DynamicIslandAnimationCallbackType)((Object)object2), (String)object);
                super.onCancel(object);
            }

            public void onComplete(Object object) {
                Object object2 = this.$view.getExpandedView();
                if (object2 != null) {
                    object2.setVisibility(4);
                }
                this.this$0.setExpandedToTempHiddenAnimating(false);
                object2 = DynamicIslandScenarioUtils.INSTANCE;
                if (((DynamicIslandScenarioUtils)object2).isExpandTracking()) {
                    ((DynamicIslandScenarioUtils)object2).setDynamicIslandScenarioState(496L, false);
                    ((DynamicIslandScenarioUtils)object2).setExpandTracking(false);
                }
                ((DynamicIslandScenarioUtils)object2).setDynamicIslandScenarioState(476L, false);
                DynamicIslandAnimationCallback dynamicIslandAnimationCallback = DynamicIslandAnimationDelegate.access$getDynamicIslandAnimController$p(this.this$0).getAnimationCallback$miui_dynamicisland_release();
                object2 = DynamicIslandAnimationType.EXPANDED_TO_TEMP_HIDDEN;
                DynamicIslandAnimationCallbackType dynamicIslandAnimationCallbackType = DynamicIslandAnimationCallbackType.ANIM_FINISH;
                o.e((Object)object, (String)"null cannot be cast to non-null type kotlin.String");
                dynamicIslandAnimationCallback.executeCallback((DynamicIslandAnimationType)((Object)object2), dynamicIslandAnimationCallbackType, (String)object);
                super.onComplete(object);
                if (CommonUtils.INSTANCE.getIS_TABLET() && (this.$forceSlideOffPad || !DynamicIslandAnimationDelegate.access$getPanelHeightChanging(this.this$0))) {
                    this.this$0.expandedToTempHiddenNoAnimation(this.$view);
                }
            }
        }})});
        dynamicIslandBaseContentView = dynamicIslandBaseContentView.getFakeView();
        if (dynamicIslandBaseContentView != null) {
            ((DynamicIslandContentFakeView)dynamicIslandBaseContentView).setVisibility(8);
        }
    }

    public final void expandedToTempHiddenNoAnimation(DynamicIslandContentView dynamicIslandBaseContentView) {
        o.g((Object)((Object)dynamicIslandBaseContentView), (String)"view");
        IFolme iFolme = FolmeKt.getFolme((FolmeObject)this);
        AnimState animState = CommonUtils.INSTANCE.getIS_TABLET() ? this.getTempHiddenCompleteAnimStatePad() : this.getCutoutAnimState();
        iFolme.setTo((Object)animState, new AnimConfig[]{new AnimConfig().addListeners(new TransitionListener[]{new DynamicIslandAnimListener(this, (DynamicIslandContentView)dynamicIslandBaseContentView){
            final DynamicIslandContentView $view;
            final DynamicIslandAnimationDelegate this$0;
            {
                this.this$0 = dynamicIslandAnimationDelegate;
                this.$view = dynamicIslandContentView;
                super(dynamicIslandAnimationDelegate);
            }

            public void onBegin(Object object) {
                super.onBegin(object);
                Object object2 = DynamicIslandAnimationDelegate.access$getAnimationDelegateHelper$p(this.this$0);
                DynamicIslandAnimationType dynamicIslandAnimationType = DynamicIslandAnimationType.EXPANDED_TO_TEMP_HIDDEN;
                object2.requestUpdateHeadsUpLocation(dynamicIslandAnimationType, this.$view);
                if (o.c((Object)((Object)DynamicIslandAnimationDelegate.access$getExpandedStateHandler$p(this.this$0).getLastExpandedView()), (Object)((Object)this.$view)) && DynamicIslandAnimationDelegate.access$getExpandedStateHandler$p(this.this$0).getCurrent() == null) {
                    DynamicIslandAnimationCallback dynamicIslandAnimationCallback = DynamicIslandAnimationDelegate.access$getDynamicIslandAnimController$p(this.this$0).getAnimationCallback$miui_dynamicisland_release();
                    object2 = DynamicIslandAnimationCallbackType.ANIM_START;
                    o.e((Object)object, (String)"null cannot be cast to non-null type kotlin.String");
                    dynamicIslandAnimationCallback.executeCallback(dynamicIslandAnimationType, (DynamicIslandAnimationCallbackType)((Object)object2), (String)object);
                }
            }

            public void onCancel(Object object) {
                DynamicIslandAnimationCallback dynamicIslandAnimationCallback = DynamicIslandAnimationDelegate.access$getDynamicIslandAnimController$p(this.this$0).getAnimationCallback$miui_dynamicisland_release();
                DynamicIslandAnimationType dynamicIslandAnimationType = DynamicIslandAnimationType.EXPANDED_TO_TEMP_HIDDEN;
                DynamicIslandAnimationCallbackType dynamicIslandAnimationCallbackType = DynamicIslandAnimationCallbackType.ANIM_CANCEL;
                o.e((Object)object, (String)"null cannot be cast to non-null type kotlin.String");
                dynamicIslandAnimationCallback.executeCallback(dynamicIslandAnimationType, dynamicIslandAnimationCallbackType, (String)object);
                super.onCancel(object);
            }

            public void onComplete(Object object) {
                Object object2 = this.$view.getExpandedView();
                if (object2 != null) {
                    object2.setVisibility(4);
                }
                object2 = DynamicIslandAnimationDelegate.access$getDynamicIslandAnimController$p(this.this$0).getAnimationCallback$miui_dynamicisland_release();
                DynamicIslandAnimationType dynamicIslandAnimationType = DynamicIslandAnimationType.EXPANDED_TO_TEMP_HIDDEN;
                DynamicIslandAnimationCallbackType dynamicIslandAnimationCallbackType = DynamicIslandAnimationCallbackType.ANIM_FINISH;
                o.e((Object)object, (String)"null cannot be cast to non-null type kotlin.String");
                ((DynamicIslandAnimationCallback)object2).executeCallback(dynamicIslandAnimationType, dynamicIslandAnimationCallbackType, (String)object);
                super.onComplete(object);
            }
        }})});
        dynamicIslandBaseContentView = dynamicIslandBaseContentView.getFakeView();
        if (dynamicIslandBaseContentView != null) {
            ((DynamicIslandContentFakeView)dynamicIslandBaseContentView).setVisibility(8);
        }
    }

    public final void fakeViewScheduleUpdate() {
        if (this.fakeViewAnimating) {
            this.updateFakeViewAnimState();
        }
    }

    public final void fakeViewToBigIsland(DynamicIslandContentView dynamicIslandBaseContentView, boolean bl) {
        Object object;
        o.g((Object)((Object)dynamicIslandBaseContentView), (String)"view");
        Object object2 = dynamicIslandBaseContentView.getFakeView();
        boolean bl2 = object2 != null ? object2.getClosingToExpanded() : false;
        boolean bl3 = this.getIslandWindowAnimRunning();
        object2 = new StringBuilder();
        ((StringBuilder)object2).append("fakeViewToBigIsland: windowAnimRunning: ");
        ((StringBuilder)object2).append(bl3);
        ((StringBuilder)object2).append(", isAppClose: ");
        ((StringBuilder)object2).append(bl);
        ((StringBuilder)object2).append(", isClosingToExpanded: ");
        ((StringBuilder)object2).append(bl2);
        Log.d((String)"DynamicIslandAnimDebug", (String)((StringBuilder)object2).toString());
        object2 = null;
        DynamicIslandContentFakeView dynamicIslandContentFakeView = null;
        int n = DynamicIslandBaseContentView.getCurrentBigIslandX$default(dynamicIslandBaseContentView, null, 1, null);
        int n2 = DynamicIslandBaseContentView.getCurrentBigIslandWidth$default(dynamicIslandBaseContentView, null, 1, null);
        int n3 = dynamicIslandBaseContentView.getIslandViewMarginTop();
        int n4 = dynamicIslandBaseContentView.getIslandViewHeight();
        if (CommonUtils.INSTANCE.getIS_TABLET()) {
            object = dynamicIslandBaseContentView.getContext();
            o.f((Object)object, (String)"getContext(...)");
            if (!MiBlurCompat.getBackgroundBlurOpened((Context)object) && (object = this.getFakeView()) != null && (object = object.getFakeContainer()) != null) {
                object.setBackgroundColor(this.COLOR_BIG_ISLAND);
            }
        }
        if ((object = this.getFakeView()) != null) {
            this.animationDelegateHelper.updateBigIslandContainerBackground((DynamicIslandBaseContentView)((Object)object));
        }
        if (dynamicIslandBaseContentView.getLastState() instanceof DynamicIslandState.SmallIsland && this.getIslandWindowAnimRunning()) {
            if (bl) {
                DynamicIslandAnimationDelegate.updateFakeViewStateForAppAnim$default(this, n, n3, n2, n4, dynamicIslandBaseContentView, false, false, 64, null);
            } else if (!this.islandAppAnimRunning) {
                if (dynamicIslandBaseContentView.getLastState() instanceof DynamicIslandState.SmallIsland) {
                    this.setViewVisible(dynamicIslandBaseContentView, 0);
                    object2 = dynamicIslandBaseContentView.getFakeView();
                    if (object2 != null) {
                        object2.setVisibility(4);
                    }
                    object2 = this.getFakeView();
                    object2 = object2 != null ? object2.getFakeBigIsland() : null;
                    if (object2 != null) {
                        float f2 = n;
                        object = this.getFakeView();
                        float f3 = object != null ? object.getBigIslandTx() : 0.0f;
                        object2.setTranslationX(-(f2 + Math.abs(f3)));
                    }
                    object = this.getFakeView();
                    object2 = dynamicIslandContentFakeView;
                    if (object != null) {
                        object2 = object.getFakeBigIsland();
                    }
                    if (object2 != null) {
                        object2.setTranslationY(-((float)n3));
                    }
                }
                this.updateFakeViewState(0, 0, n, n2, n3, n4, (DynamicIslandContentView)dynamicIslandBaseContentView);
            }
            this.animToFakeBigIslandView((DynamicIslandContentView)dynamicIslandBaseContentView);
        } else {
            if (bl && this.getIslandWindowAnimRunning() || this.islandAppAnimRunning && ((dynamicIslandContentFakeView = this.getFakeView()) != null && dynamicIslandContentFakeView.getBigIslandViewNeedAnim() || (dynamicIslandContentFakeView = this.getFakeView()) != null && dynamicIslandContentFakeView.getForceUpdateBigIslandView())) {
                DynamicIslandAnimationDelegate.updateFakeViewStateForAppAnim$default(this, n, n3, n2, n4, dynamicIslandBaseContentView, true, false, 64, null);
            } else {
                this.updateFakeViewState(0, 0, n, n2, n3, n4, (DynamicIslandContentView)dynamicIslandBaseContentView);
            }
            dynamicIslandBaseContentView = this.getFakeView();
            dynamicIslandBaseContentView = dynamicIslandBaseContentView != null ? dynamicIslandBaseContentView.getFakeBigIsland() : null;
            if (dynamicIslandBaseContentView != null) {
                dynamicIslandBaseContentView.setVisibility(0);
            }
            dynamicIslandBaseContentView = this.getFakeView();
            dynamicIslandBaseContentView = dynamicIslandBaseContentView != null ? dynamicIslandBaseContentView.getFakeSmallIsland() : null;
            if (dynamicIslandBaseContentView != null) {
                dynamicIslandBaseContentView.setVisibility(4);
            }
            dynamicIslandContentFakeView = this.getFakeView();
            dynamicIslandBaseContentView = object2;
            if (dynamicIslandContentFakeView != null) {
                dynamicIslandBaseContentView = dynamicIslandContentFakeView.getFakeExpandedView();
            }
            if (dynamicIslandBaseContentView != null) {
                dynamicIslandBaseContentView.setVisibility(4);
            }
        }
    }

    public final void fakeViewToDeleted(DynamicIslandContentView dynamicIslandBaseContentView) {
        o.g((Object)((Object)dynamicIslandBaseContentView), (String)"view");
        Context context = dynamicIslandBaseContentView.getContext();
        int n = context != null ? DynamicIslandUtils.INSTANCE.getScreenWidthOld(context) / 2 : 0;
        this.updateFakeViewState(n, 0, 0, 0, dynamicIslandBaseContentView.getIslandViewMarginTop(), 1, (DynamicIslandContentView)dynamicIslandBaseContentView);
        dynamicIslandBaseContentView = this.getFakeView();
        if (dynamicIslandBaseContentView != null) {
            ((DynamicIslandContentFakeView)dynamicIslandBaseContentView).setVisibility(4);
        }
        dynamicIslandBaseContentView = this.getFakeView();
        context = null;
        dynamicIslandBaseContentView = dynamicIslandBaseContentView != null ? dynamicIslandBaseContentView.getFakeBigIsland() : null;
        if (dynamicIslandBaseContentView != null) {
            dynamicIslandBaseContentView.setVisibility(4);
        }
        dynamicIslandBaseContentView = this.getFakeView();
        dynamicIslandBaseContentView = dynamicIslandBaseContentView != null ? dynamicIslandBaseContentView.getFakeSmallIsland() : null;
        if (dynamicIslandBaseContentView != null) {
            dynamicIslandBaseContentView.setVisibility(4);
        }
        DynamicIslandContentFakeView dynamicIslandContentFakeView = this.getFakeView();
        dynamicIslandBaseContentView = context;
        if (dynamicIslandContentFakeView != null) {
            dynamicIslandBaseContentView = dynamicIslandContentFakeView.getFakeExpandedView();
        }
        if (dynamicIslandBaseContentView != null) {
            dynamicIslandBaseContentView.setVisibility(4);
        }
    }

    public final void fakeViewToExpanded(DynamicIslandContentView object, boolean bl) {
        o.g((Object)object, (String)"view");
        boolean bl2 = this.islandAppAnimRunning;
        Object object2 = new StringBuilder();
        ((StringBuilder)object2).append("fakeViewToExpanded: islandAppAnimRunning: ");
        ((StringBuilder)object2).append(bl2);
        ((StringBuilder)object2).append(", isAppOpen: ");
        ((StringBuilder)object2).append(bl);
        Log.d((String)"DynamicIslandAnimDebug", (String)((StringBuilder)object2).toString());
        int n = object.getExpandedViewY();
        int n2 = object.getIslandViewMarginTop();
        int n3 = object.getExpandedViewMarginHorizontal();
        int n4 = object.getExpandedViewWidth();
        int n5 = object.getIslandViewMarginTop();
        int n6 = object.getExpandedViewHeight();
        if (this.islandAppAnimRunning && !bl) {
            if (CommonUtils.INSTANCE.getIS_TABLET()) {
                object2 = object.getContext();
                o.f((Object)object2, (String)"getContext(...)");
                if (!MiBlurCompat.getBackgroundBlurOpened((Context)object2) && (object2 = this.getFakeView()) != null && (object2 = ((DynamicIslandBaseContentView)((Object)object2)).getFakeContainer()) != null) {
                    object2.setBackgroundColor(this.COLOR_BIG_ISLAND);
                }
            }
            this.updateFakeViewStateForAppAnim(n3, n5, n4, n6, (DynamicIslandContentView)((Object)object), false, bl);
            this.animToFakeExpandedView((DynamicIslandContentView)((Object)object));
        } else {
            if (CommonUtils.INSTANCE.getIS_TABLET()) {
                object2 = object.getContext();
                o.f((Object)object2, (String)"getContext(...)");
                if (!MiBlurCompat.getBackgroundBlurOpened((Context)object2) && (object2 = this.getFakeView()) != null && (object2 = ((DynamicIslandBaseContentView)((Object)object2)).getFakeContainer()) != null) {
                    object2.setBackgroundColor(this.COLOR_EXPANDED);
                }
            }
            if (this.islandAppAnimRunning) {
                this.updateFakeViewStateForAppAnim(n3, n5, n4, n6, (DynamicIslandContentView)((Object)object), true, bl);
            } else {
                this.updateFakeViewState(0, n - n2, n3, n4, n5, n6, (DynamicIslandContentView)((Object)object));
            }
            object = this.getFakeView();
            object2 = null;
            object = object != null ? object.getFakeBigIsland() : null;
            if (object != null) {
                object.setVisibility(4);
            }
            object = this.getFakeView();
            object = object != null ? object.getFakeSmallIsland() : null;
            if (object != null) {
                object.setVisibility(4);
            }
            DynamicIslandContentFakeView dynamicIslandContentFakeView = this.getFakeView();
            object = object2;
            if (dynamicIslandContentFakeView != null) {
                object = dynamicIslandContentFakeView.getFakeExpandedView();
            }
            if (object != null) {
                object.setVisibility(0);
            }
        }
    }

    public final void fakeViewToHidden(DynamicIslandContentView object, boolean bl) {
        o.g((Object)object, (String)"view");
        Object object2 = object.getContext();
        int n = object2 != null ? DynamicIslandUtils.INSTANCE.getScreenWidthOld((Context)object2) / 2 : 0;
        float f2 = (float)(n - object.getSmallIslandViewWidth() / 2) + (float)object.getSmallIslandViewWidth() * 0.2f;
        n = object.getSmallIslandViewWidth();
        float f3 = (float)object.getIslandViewMarginTop() + (float)object.getIslandViewHeight() * 0.2f;
        float f4 = (float)object.getIslandViewHeight() * 0.6f;
        if (CommonUtils.INSTANCE.getIS_TABLET()) {
            object2 = object.getContext();
            o.f((Object)object2, (String)"getContext(...)");
            if (!MiBlurCompat.getBackgroundBlurOpened((Context)object2) && (object2 = this.getFakeView()) != null && (object2 = ((DynamicIslandBaseContentView)((Object)object2)).getFakeContainer()) != null) {
                object2.setBackgroundColor(this.COLOR_BIG_ISLAND);
            }
        }
        if ((object2 = this.getFakeView()) != null) {
            this.animationDelegateHelper.updateBigIslandContainerBackground((DynamicIslandBaseContentView)((Object)object2));
        }
        if (bl && this.getIslandWindowAnimRunning()) {
            DynamicIslandAnimationDelegate.updateFakeViewStateForAppAnim$default(this, (int)f2, (int)f3, n, (int)f4, object, true, false, 64, null);
        } else {
            this.updateFakeViewState(0, 0, (int)f2, n, (int)f3, (int)f4, (DynamicIslandContentView)((Object)object));
        }
        object = this.getFakeView();
        object2 = null;
        object = object != null ? object.getFakeSmallIsland() : null;
        if (object != null) {
            object.setVisibility(4);
        }
        object = this.getFakeView();
        object = object != null ? object.getFakeBigIsland() : null;
        if (object != null) {
            object.setVisibility(4);
        }
        DynamicIslandContentFakeView dynamicIslandContentFakeView = this.getFakeView();
        object = object2;
        if (dynamicIslandContentFakeView != null) {
            object = dynamicIslandContentFakeView.getFakeExpandedView();
        }
        if (object != null) {
            object.setVisibility(4);
        }
    }

    public final void fakeViewToNormalExpanded(DynamicIslandContentView dynamicIslandBaseContentView) {
        o.g((Object)((Object)dynamicIslandBaseContentView), (String)"view");
        this.updateFakeViewState(0, dynamicIslandBaseContentView.getExpandedViewY() - dynamicIslandBaseContentView.getIslandViewMarginTop(), dynamicIslandBaseContentView.getExpandedViewMarginHorizontal(), dynamicIslandBaseContentView.getExpandedViewWidth(), dynamicIslandBaseContentView.getIslandViewMarginTop(), dynamicIslandBaseContentView.getExpandedViewHeight(), (DynamicIslandContentView)dynamicIslandBaseContentView);
        this.expandedViewHadScaled = false;
        dynamicIslandBaseContentView = this.getFakeView();
        Object var2_2 = null;
        dynamicIslandBaseContentView = dynamicIslandBaseContentView != null ? dynamicIslandBaseContentView.getFakeBigIsland() : null;
        if (dynamicIslandBaseContentView != null) {
            dynamicIslandBaseContentView.setVisibility(4);
        }
        dynamicIslandBaseContentView = this.getFakeView();
        dynamicIslandBaseContentView = dynamicIslandBaseContentView != null ? dynamicIslandBaseContentView.getFakeSmallIsland() : null;
        if (dynamicIslandBaseContentView != null) {
            dynamicIslandBaseContentView.setVisibility(4);
        }
        DynamicIslandContentFakeView dynamicIslandContentFakeView = this.getFakeView();
        dynamicIslandBaseContentView = var2_2;
        if (dynamicIslandContentFakeView != null) {
            dynamicIslandBaseContentView = dynamicIslandContentFakeView.getFakeExpandedView();
        }
        if (dynamicIslandBaseContentView != null) {
            dynamicIslandBaseContentView.setVisibility(0);
        }
    }

    public final void fakeViewToSmallIsland(DynamicIslandContentView dynamicIslandBaseContentView, boolean bl) {
        o.g((Object)((Object)dynamicIslandBaseContentView), (String)"view");
        Object object = dynamicIslandBaseContentView.getFakeView();
        boolean bl2 = object != null ? object.getClosingToExpanded() : false;
        boolean bl3 = this.getIslandWindowAnimRunning();
        boolean bl4 = this.fakeViewAnimating;
        object = new StringBuilder();
        ((StringBuilder)object).append("fakeViewToSmallIsland: windowAnimRunning: ");
        ((StringBuilder)object).append(bl3);
        ((StringBuilder)object).append(", isAppClose: ");
        ((StringBuilder)object).append(bl);
        ((StringBuilder)object).append(", isClosingToExpanded: ");
        ((StringBuilder)object).append(bl2);
        ((StringBuilder)object).append(", fakeViewAnimating: ");
        ((StringBuilder)object).append(bl4);
        Log.d((String)"DynamicIslandAnimDebug", (String)((StringBuilder)object).toString());
        object = dynamicIslandBaseContentView.getContext();
        int n = object != null ? DynamicIslandUtils.INSTANCE.getScreenWidthOld((Context)object) / 2 : 0;
        int n2 = n - dynamicIslandBaseContentView.getSmallIslandViewWidth() / 2;
        int n3 = dynamicIslandBaseContentView.getSmallIslandViewWidth();
        n = dynamicIslandBaseContentView.getIslandViewMarginTop();
        int n4 = dynamicIslandBaseContentView.getIslandViewHeight();
        if (this.islandAppAnimRunning && dynamicIslandBaseContentView.getLastState() instanceof DynamicIslandState.BigIsland) {
            DynamicIslandAnimationDelegate.updateFakeViewStateForAppAnim$default(this, n2, n, n3, n4, dynamicIslandBaseContentView, false, false, 64, null);
            this.animToFakeSmallIslandView((DynamicIslandContentView)dynamicIslandBaseContentView);
        } else {
            Object var11_11 = null;
            if (bl && this.getIslandWindowAnimRunning()) {
                object = this.getFakeView();
                object = object != null ? object.getFakeSmallIsland() : null;
                if (object != null) {
                    object.setTranslationX(0.0f);
                }
                DynamicIslandAnimationDelegate.updateFakeViewStateForAppAnim$default(this, n2, n, n3, n4, dynamicIslandBaseContentView, true, false, 64, null);
            } else {
                if (this.getIslandWindowAnimRunning()) {
                    this.updateSmallTx();
                }
                this.updateFakeViewState(0, 0, n2, n3, n, n4, (DynamicIslandContentView)dynamicIslandBaseContentView);
            }
            dynamicIslandBaseContentView = this.getFakeView();
            dynamicIslandBaseContentView = dynamicIslandBaseContentView != null ? dynamicIslandBaseContentView.getFakeBigIsland() : null;
            if (dynamicIslandBaseContentView != null) {
                dynamicIslandBaseContentView.setVisibility(4);
            }
            dynamicIslandBaseContentView = this.getFakeView();
            dynamicIslandBaseContentView = dynamicIslandBaseContentView != null ? dynamicIslandBaseContentView.getFakeSmallIsland() : null;
            if (dynamicIslandBaseContentView != null) {
                dynamicIslandBaseContentView.setVisibility(0);
            }
            object = this.getFakeView();
            dynamicIslandBaseContentView = var11_11;
            if (object != null) {
                dynamicIslandBaseContentView = object.getFakeExpandedView();
            }
            if (dynamicIslandBaseContentView != null) {
                dynamicIslandBaseContentView.setVisibility(4);
            }
        }
    }

    public final void fakeViewToTempHiddenAnimation(DynamicIslandContentView dynamicIslandContentView) {
        IStateStyle iStateStyle;
        o.g((Object)((Object)dynamicIslandContentView), (String)"view");
        DynamicIslandContentFakeView dynamicIslandContentFakeView = dynamicIslandContentView.getFakeView();
        if (dynamicIslandContentFakeView != null && (dynamicIslandContentFakeView = dynamicIslandContentFakeView.getFakeContainer()) != null && (dynamicIslandContentFakeView = FolmeKt.getFolme((View)dynamicIslandContentFakeView)) != null && (iStateStyle = dynamicIslandContentFakeView.state()) != null) {
            dynamicIslandContentFakeView = new AnimState();
            ViewProperty viewProperty = ViewProperty.ALPHA;
            AnimState animState = dynamicIslandContentFakeView.add(viewProperty, 0.0f, new long[0]);
            AnimConfig animConfig = new AnimConfig();
            float f2 = this.getSupposedContainerAlpha();
            long l = 100L;
            dynamicIslandContentFakeView = f2 == 0.0f ? this.SHOW_EASE : FolmeEase.linear((long)100L);
            if (this.getSupposedContainerAlpha() != 0.0f) {
                l = 400L;
            }
            iStateStyle.to((Object)animState, new AnimConfig[]{animConfig.setSpecial((FloatProperty)viewProperty, (EaseManager.EaseStyle)dynamicIslandContentFakeView, l, new float[0]).addListeners(new TransitionListener[]{new TransitionListener(dynamicIslandContentView){
                final DynamicIslandContentView $view;
                {
                    this.$view = dynamicIslandContentView;
                }

                public void onComplete(Object object) {
                    super.onComplete(object);
                    object = this.$view.getFakeView();
                    if (object != null) {
                        ((DynamicIslandContentFakeView)((Object)object)).setVisibility(4);
                    }
                    object = this.$view.getFakeView();
                    object = object != null ? ((DynamicIslandBaseContentView)((Object)object)).getFakeContainer() : null;
                    if (object != null) {
                        object.setAlpha(1.0f);
                    }
                }
            }})});
        }
    }

    public Folme.ObjectFolmeImpl folme() {
        return this.$$delegate_0.folme();
    }

    public final EaseManager.EaseStyle getALPHA_EASE() {
        return this.ALPHA_EASE;
    }

    public final EaseManager.EaseStyle getAPPEAR_EASE() {
        return this.APPEAR_EASE;
    }

    public final boolean getAppClose() {
        return this.appClose;
    }

    public final float getAreaLeftCollapseTransX() {
        Context context = this.view.getContext();
        o.f((Object)context, (String)"getContext(...)");
        boolean bl = CommonUtils.isLayoutRtl((Context)context);
        float f2 = 0.0f;
        float f3 = 0.0f;
        if (bl) {
            context = this.view.getBigIslandAreaLeft();
            f2 = f3;
            if (context != null) {
                f2 = context.getWidth();
            }
            f2 = -f2;
        } else {
            context = this.view.getBigIslandAreaLeft();
            if (context != null) {
                f2 = context.getWidth();
            }
        }
        return f2;
    }

    public final float getAreaRightCollapseTransX() {
        Context context = this.view.getContext();
        o.f((Object)context, (String)"getContext(...)");
        boolean bl = CommonUtils.isLayoutRtl((Context)context);
        float f2 = 0.0f;
        float f3 = 0.0f;
        if (bl) {
            context = this.view.getBigIslandAreaRight();
            f3 = f2;
            if (context != null) {
                f3 = context.getWidth();
            }
        } else {
            context = this.view.getBigIslandAreaRight();
            if (context != null) {
                f3 = context.getWidth();
            }
            f3 = -f3;
        }
        return f3;
    }

    public final float getBigIslandBottom() {
        return (float)this.view.getIslandViewHeight() + this.getBigIslandTop();
    }

    public final float getBigIslandEnd() {
        float f2 = DynamicIslandBaseContentView.getCurrentBigIslandWidth$default(this.view, null, 1, null);
        float f3 = (float)this.view.getBigIslandViewWidth() == 0.0f ? 1.0f : (float)this.view.getBigIslandViewWidth();
        return f2 / f3 * (float)this.view.getBigIslandViewWidth() + this.getBigIslandStart();
    }

    public final float getBigIslandStart() {
        return DynamicIslandBaseContentView.getCurrentBigIslandX$default(this.view, null, 1, null);
    }

    public final float getBigIslandTop() {
        return this.view.getIslandViewMarginTop();
    }

    public final float getBigTransYToExpanded() {
        return (float)(this.view.getExpandedViewHeight() - this.view.getIslandViewHeight()) / 2.0f;
    }

    public final EaseManager.EaseStyle getCHANGE_EASE() {
        return this.CHANGE_EASE;
    }

    public final float getCutoutBottom() {
        return (float)this.view.getCutoutHeight() / (float)this.view.getIslandViewHeight() * (float)this.view.getIslandViewHeight() + this.getCutoutTop();
    }

    public final float getCutoutEnd() {
        int n = !this.windowView.getWindowViewController().isNotchScreenDevice() ? this.view.getFixedCutoutWidth() : this.view.getCutoutHeight();
        float f2 = (float)this.view.getBigIslandViewWidth() == 0.0f ? 1.0f : (float)this.view.getBigIslandViewWidth();
        return (float)n / f2 * (float)this.view.getBigIslandViewWidth() + this.getCutoutStart();
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public final float getCutoutStart() {
        int n;
        DynamicIslandUtils dynamicIslandUtils = DynamicIslandUtils.INSTANCE;
        Object object = this.view.getContext();
        o.f((Object)object, (String)"getContext(...)");
        float f2 = (float)dynamicIslandUtils.getScreenWidthOld((Context)object) / 2.0f;
        boolean bl = this.windowView.getWindowViewController().isNotchScreenDevice();
        object = this.view;
        if (!bl) {
            n = ((DynamicIslandBaseContentView)((Object)object)).getFixedCutoutWidth();
            return f2 - (float)(n /= 2);
        } else {
            n = ((DynamicIslandBaseContentView)((Object)object)).getCutoutHeight();
            return f2 - (float)(n /= 2);
        }
    }

    public final float getCutoutTop() {
        if (this.windowView.getWindowViewController().isNotchScreenDevice()) {
            return 0.0f;
        }
        return this.view.getCutoutY() - (float)(this.view.getCutoutHeight() / 2);
    }

    public final float getDebugIslandAnimScale() {
        return this.debugIslandAnimScale;
    }

    public final EaseManager.EaseStyle getEASE_SININOUT_025() {
        return this.EASE_SININOUT_025;
    }

    public final EaseManager.EaseStyle getEASE_SPRING_083_042() {
        return this.EASE_SPRING_083_042;
    }

    public final EaseManager.EaseStyle getEASE_SPRING_095_015() {
        return this.EASE_SPRING_095_015;
    }

    public final EaseManager.EaseStyle getEASE_SPRING_095_035() {
        return this.EASE_SPRING_095_035;
    }

    public final float getExpandedBottom() {
        return (float)this.view.getExpandedViewHeight() / (float)this.view.getIslandViewHeight() * (float)this.view.getIslandViewHeight() + this.getExpandedTop();
    }

    public final float getExpandedEnd() {
        float f2 = this.view.getExpandedViewWidth();
        float f3 = (float)this.view.getBigIslandViewWidth() == 0.0f ? 1.0f : (float)this.view.getBigIslandViewWidth();
        return f2 / f3 * (float)this.view.getBigIslandViewWidth() + this.getExpandedStart();
    }

    public final float getExpandedShouldTransX() {
        return this.view.getPadIslandTransX();
    }

    public final float getExpandedStart() {
        return this.view.getExpandedViewMarginHorizontal();
    }

    public final boolean getExpandedToTempHiddenAnimating() {
        return this.expandedToTempHiddenAnimating;
    }

    public final float getExpandedTop() {
        return this.view.getIslandViewMarginTop();
    }

    public final float getExpandedTransYToBig() {
        float f2 = (float)this.view.getBigIslandViewWidth() / (float)this.view.getExpandedViewWidth();
        return ((float)this.view.getExpandedViewHeight() - (float)this.view.getExpandedViewHeight() * f2) / (float)2 + f2 * (float)this.view.getIslandViewMarginTop();
    }

    public final float getExpandedTransYToCutout() {
        float f2 = (float)this.view.getFixedCutoutWidth() / (float)this.view.getExpandedViewWidth();
        return ((float)this.view.getExpandedViewHeight() - f2 * (float)this.view.getExpandedViewHeight()) / 2.0f - this.getCutoutTop() - (float)this.view.getIslandViewMarginTop() / 2.0f;
    }

    public final float getExpandedTransYToSmall() {
        float f2 = (float)this.view.getSmallIslandViewWidth() / (float)this.view.getExpandedViewWidth();
        return ((float)this.view.getExpandedViewHeight() - f2 * (float)this.view.getExpandedViewHeight()) / 2.0f - (float)this.view.getIslandViewMarginTop() * 2.0f;
    }

    public final float getExpandedViewAnimatingProgress() {
        return this.expandedViewAnimatingProgress;
    }

    public final EaseManager.EaseStyle getFAKE_ALPHA_EASE() {
        return this.FAKE_ALPHA_EASE;
    }

    public final EaseManager.EaseStyle getHIDDEN_EASE() {
        return this.HIDDEN_EASE;
    }

    public final DynamicIslandState getHiddenStateFrom() {
        return this.hiddenStateFrom;
    }

    public final boolean getIslandAppAnimRunning() {
        return this.islandAppAnimRunning;
    }

    public final boolean getIslandFreeformAnimRunning() {
        return this.islandFreeformAnimRunning;
    }

    public final boolean getIslandStateChanged() {
        return this.islandStateChanged;
    }

    public final boolean getIslandWindowAnimRunning() {
        boolean bl = this.islandFreeformAnimRunning || this.islandAppAnimRunning;
        return bl;
    }

    public final EaseManager.EaseStyle getPAD_BOTTOM_ISLAND_HIDDEN_EASE() {
        return this.PAD_BOTTOM_ISLAND_HIDDEN_EASE;
    }

    public final EaseManager.EaseStyle getPAD_CHANGE_EASE() {
        return this.PAD_CHANGE_EASE;
    }

    public final EaseManager.EaseStyle getPAD_HIGHT_HIDDEN_EASE() {
        return this.PAD_HIGHT_HIDDEN_EASE;
    }

    public final EaseManager.EaseStyle getPAD_NORMAL_HIDDEN_EASE() {
        return this.PAD_NORMAL_HIDDEN_EASE;
    }

    public final EaseManager.EaseStyle getPAD_SHOW_EASE() {
        return this.PAD_SHOW_EASE;
    }

    public final EaseManager.EaseStyle getSCALE_EASE() {
        return this.SCALE_EASE;
    }

    public final EaseManager.EaseStyle getSHOW_EASE() {
        return this.SHOW_EASE;
    }

    public final float getSmallIslandBottom() {
        return (float)this.view.getIslandViewHeight() + this.getSmallIslandTop();
    }

    public final float getSmallIslandEnd() {
        float f2 = this.view.getSmallIslandViewWidth();
        float f3 = (float)this.view.getBigIslandViewWidth() == 0.0f ? 1.0f : (float)this.view.getBigIslandViewWidth();
        return f2 / f3 * (float)this.view.getBigIslandViewWidth() + this.getSmallIslandStart();
    }

    public final float getSmallIslandStart() {
        DynamicIslandUtils dynamicIslandUtils = DynamicIslandUtils.INSTANCE;
        Context context = this.view.getContext();
        o.f((Object)context, (String)"getContext(...)");
        return (float)dynamicIslandUtils.getScreenWidthOld(context) / 2.0f - (float)(this.view.getSmallIslandViewWidth() / 2);
    }

    public final float getSmallIslandTop() {
        return this.view.getIslandViewMarginTop();
    }

    public final float getSmallTransXToBig() {
        Object object = this.view.getBigIslandAreaLeft();
        float f2 = object != null ? (float)object.getWidth() : 0.0f;
        object = this.view.getContext();
        o.f((Object)object, (String)"getContext(...)");
        if (CommonUtils.isLayoutRtl((Context)object)) {
            object = DynamicIslandUtils.INSTANCE;
            Context context = this.view.getContext();
            o.f((Object)context, (String)"getContext(...)");
            f2 -= (float)((DynamicIslandUtils)object).dpToPx(8, context);
        } else {
            f2 = -f2;
            DynamicIslandUtils dynamicIslandUtils = DynamicIslandUtils.INSTANCE;
            object = this.view.getContext();
            o.f((Object)object, (String)"getContext(...)");
            f2 += (float)dynamicIslandUtils.dpToPx(8, (Context)object);
        }
        return f2;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public final float getSmallTransXToExpanded() {
        float f2;
        Context context = this.view.getContext();
        o.f((Object)context, (String)"getContext(...)");
        if (CommonUtils.isLayoutRtl((Context)context)) {
            f2 = this.view.getExpandedViewWidth() - this.view.getSmallIslandViewWidth();
            return f2 /= 2.0f;
        } else {
            f2 = -(this.view.getExpandedViewWidth() - this.view.getSmallIslandViewWidth());
            return f2 /= 2.0f;
        }
    }

    public final float getSmallTransYToExpanded() {
        return (float)(this.view.getExpandedViewHeight() - this.view.getIslandViewHeight()) / 2.0f;
    }

    public final void hiddenChangedAnimation(DynamicIslandContentView object) {
        o.g((Object)object, (String)"view");
        Object object2 = new AnimConfig();
        DynamicIslandWindowState dynamicIslandWindowState = ((DynamicIslandBaseContentView)((Object)object)).getWindowState();
        long l = dynamicIslandWindowState != null && dynamicIslandWindowState.isNeedDelayUnLockAnimation() ? 200L : 0L;
        dynamicIslandWindowState = object2.setDelay(l).addListeners(new TransitionListener[]{new DynamicIslandAnimListener(this){}});
        object2 = this.hiddenStateFrom;
        if (!(object2 instanceof DynamicIslandState.Expanded) && !(object2 instanceof DynamicIslandState.SmallIsland)) {
            FolmeKt.getFolme((FolmeObject)this).to((Object)this.getCutoutAnimState(), new AnimConfig[]{dynamicIslandWindowState});
        } else {
            object = CommonUtils.INSTANCE.getIS_TABLET() && ((object = ((DynamicIslandBaseContentView)((Object)object)).getCurrentIslandData()) == null || (object = object.getProperties()) == null || (Integer)object != 0) ? this.getHiddenAnimStatePad() : this.getHiddenAnimState();
            FolmeKt.getFolme((FolmeObject)this).to(object, new AnimConfig[]{dynamicIslandWindowState});
        }
    }

    public final void hiddenChangedNoAnimation(DynamicIslandContentView object) {
        o.g((Object)object, (String)"view");
        AnimConfig animConfig2 = new AnimConfig().addListeners(new TransitionListener[]{new DynamicIslandAnimListener(this){}});
        DynamicIslandState dynamicIslandState = this.hiddenStateFrom;
        if (!(dynamicIslandState instanceof DynamicIslandState.Expanded) && !(dynamicIslandState instanceof DynamicIslandState.SmallIsland)) {
            FolmeKt.getFolme((FolmeObject)this).setTo((Object)this.getCutoutAnimState(), new AnimConfig[]{animConfig2});
        } else {
            object = CommonUtils.INSTANCE.getIS_TABLET() && ((object = ((DynamicIslandBaseContentView)((Object)object)).getCurrentIslandData()) == null || (object = object.getProperties()) == null || (Integer)object != 0) ? this.getHiddenAnimStatePad() : this.getHiddenAnimState();
            FolmeKt.getFolme((FolmeObject)this).setTo(object, new AnimConfig[]{animConfig2});
        }
    }

    public final void hiddenToAppExpandedAnimation(DynamicIslandContentView dynamicIslandContentView) {
        o.g((Object)((Object)dynamicIslandContentView), (String)"view");
        Object object = dynamicIslandContentView.getFakeView();
        if (object != null) {
            ((DynamicIslandContentFakeView)((Object)object)).updateBigIslandLayout();
        }
        if ((object = dynamicIslandContentView.getDynamicIslandEventCoordinator()) != null) {
            ((DynamicIslandEventCoordinator)object).updateView(dynamicIslandContentView);
        }
    }

    public final void hiddenToBigIslandAnimation(DynamicIslandContentView dynamicIslandContentView) {
        o.g((Object)((Object)dynamicIslandContentView), (String)"view");
        dynamicIslandContentView.updateBigIslandLayout();
        String string = this.TAG;
        Object object = dynamicIslandContentView.getBigIslandView();
        object = object != null ? object.getContentDescription() : null;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("hiddenToBigIslandAnimation: ");
        stringBuilder.append(object);
        Log.d((String)string, (String)stringBuilder.toString());
        if (CommonUtils.INSTANCE.getIS_TABLET()) {
            float f2 = this.getExpandedShouldTransX();
            FolmeKt.getFolme((FolmeObject)this).to((Object)this.getBigIslandAnimState(), new AnimConfig[]{new AnimConfig().setSpecial(CONTAINER_ALPHA, this.SHOW_EASE, new float[0]).setSpecial(CONTAINER_CLIP_START_PROGRESS, this.SHOW_EASE, new float[0]).setSpecial(CONTAINER_CLIP_END_PROGRESS, this.SHOW_EASE, new float[0]).setSpecial(BIG_ISLAND_SCALE, this.SHOW_EASE, new float[0]).setSpecial(BIG_ISLAND_ALPHA, this.SHOW_EASE, new float[0]).setSpecial(BIG_ISLAND_BLUR, this.SHOW_EASE, new float[0]).setSpecial(BIG_ISLAND_TRANS_X, this.SHOW_EASE, new float[0]).setSpecial(BIG_ISLAND_TRANS_Y, this.SHOW_EASE, new float[0]).addListeners(new TransitionListener[]{new DynamicIslandAnimListener(this, dynamicIslandContentView, f2){
                final float $beginX;
                final DynamicIslandContentView $view;
                final DynamicIslandAnimationDelegate this$0;
                {
                    this.this$0 = dynamicIslandAnimationDelegate;
                    this.$view = dynamicIslandContentView;
                    this.$beginX = f2;
                    super(dynamicIslandAnimationDelegate);
                }

                public void onBegin(Object object) {
                    super.onBegin(object);
                    DynamicIslandAnimationDelegate.access$setViewVisible(this.this$0, this.$view, 0);
                    DynamicIslandScenarioUtils.INSTANCE.setDynamicIslandScenarioState(434L, true);
                    DynamicIslandAnimationDelegate.access$getAnimationDelegateHelper$p(this.this$0).updateBigIslandContainerBackground(this.$view);
                }

                public void onCancel(Object object) {
                    super.onCancel(object);
                    DynamicIslandScenarioUtils.INSTANCE.setDynamicIslandScenarioState(434L, false);
                    if (!this.$view.isExpanded()) {
                        object = DynamicIslandAnimationDelegate.access$getTAG$p(this.this$0);
                        DynamicIslandState dynamicIslandState = this.$view.getState();
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append("hiddenToBigIslandAnimation onCancel: state = ");
                        stringBuilder.append(dynamicIslandState);
                        Log.d((String)object, (String)stringBuilder.toString());
                        object = this.$view.getExpandedView();
                        if (object != null) {
                            object.setVisibility(4);
                        }
                    }
                }

                public void onComplete(Object object) {
                    super.onComplete(object);
                    DynamicIslandScenarioUtils.INSTANCE.setDynamicIslandScenarioState(434L, false);
                    object = this.$view.getExpandedView();
                    if (object != null) {
                        object.setVisibility(4);
                    }
                }

                public void onUpdate(Object object, Collection<UpdateInfo> collection) {
                    DynamicIslandAnimationDelegate.access$fixTransX(this.this$0, collection, this.$beginX);
                    super.onUpdate(object, collection);
                }
            }})});
        } else {
            FolmeKt.getFolme((FolmeObject)this).setTo((Object)this.getCutoutAnimState()).to((Object)this.getBigIslandAnimState(), new AnimConfig[]{new AnimConfig().setSpecial(CONTAINER_CLIP_START_PROGRESS, this.APPEAR_EASE, new float[0]).setSpecial(CONTAINER_CLIP_END_PROGRESS, this.APPEAR_EASE, new float[0]).setSpecial(CONTAINER_ALPHA, FolmeEase.linear((long)1L), new float[0]).setSpecial(BIG_ISLAND_SCALE, this.APPEAR_EASE, new float[0]).setSpecial(BIG_ISLAND_ALPHA, this.HIDDEN_EASE, 100L, new float[0]).setSpecial(BIG_ISLAND_AREA_LEFT_TRANS_X, this.APPEAR_EASE, new float[0]).setSpecial(BIG_ISLAND_AREA_RIGHT_TRANS_X, this.APPEAR_EASE, new float[0]).addListeners(new TransitionListener[]{new DynamicIslandAnimListener(this, dynamicIslandContentView){
                final DynamicIslandContentView $view;
                final DynamicIslandAnimationDelegate this$0;
                {
                    this.this$0 = dynamicIslandAnimationDelegate;
                    this.$view = dynamicIslandContentView;
                    super(dynamicIslandAnimationDelegate);
                }

                public void onBegin(Object object) {
                    super.onBegin(object);
                    DynamicIslandAnimationDelegate.access$setViewVisible(this.this$0, this.$view, 0);
                    DynamicIslandScenarioUtils.INSTANCE.setDynamicIslandScenarioState(434L, true);
                }

                public void onCancel(Object object) {
                    super.onCancel(object);
                    DynamicIslandScenarioUtils.INSTANCE.setDynamicIslandScenarioState(434L, false);
                }

                public void onComplete(Object object) {
                    super.onComplete(object);
                    DynamicIslandScenarioUtils.INSTANCE.setDynamicIslandScenarioState(434L, false);
                }
            }})});
        }
        this.fakeViewToBigIsland(dynamicIslandContentView, false);
    }

    public final void hiddenToDeletedAnimation(DynamicIslandContentView dynamicIslandContentView) {
        o.g((Object)((Object)dynamicIslandContentView), (String)"view");
        this.removeViewFromWindow(dynamicIslandContentView, true);
    }

    public final void hiddenToMiniWindowExpandedAnimation(DynamicIslandContentView dynamicIslandContentView) {
        DynamicIslandEventCoordinator dynamicIslandEventCoordinator;
        o.g((Object)((Object)dynamicIslandContentView), (String)"view");
        this.setViewVisible(dynamicIslandContentView, 4);
        DynamicIslandContentFakeView dynamicIslandContentFakeView = dynamicIslandContentView.getFakeView();
        if (dynamicIslandContentFakeView != null) {
            dynamicIslandContentFakeView.updateBigIslandLayout();
        }
        if ((dynamicIslandContentFakeView = dynamicIslandContentView.getFakeView()) != null && (dynamicIslandEventCoordinator = dynamicIslandContentFakeView.getDynamicIslandEventCoordinator()) != null) {
            DynamicIslandContentFakeView dynamicIslandContentFakeView2 = dynamicIslandContentView.getFakeView();
            dynamicIslandContentFakeView = dynamicIslandContentView.getCurrentIslandData();
            dynamicIslandContentFakeView = dynamicIslandContentFakeView != null ? dynamicIslandContentFakeView.getExtras() : null;
            dynamicIslandEventCoordinator.updateFreeformFakeView(dynamicIslandContentFakeView2, dynamicIslandContentView, (Bundle)dynamicIslandContentFakeView);
        }
    }

    public final void hiddenToSmallIslandAnimation(DynamicIslandContentView dynamicIslandContentView) {
        o.g((Object)((Object)dynamicIslandContentView), (String)"view");
        FolmeKt.getFolme((FolmeObject)this).to((Object)this.getSmallIslandAnimState(), new AnimConfig[]{new AnimConfig().setSpecial(CONTAINER_X, this.APPEAR_EASE, new float[0]).setSpecial(CONTAINER_ALPHA, FolmeEase.linear((long)1L), new float[0]).setSpecial(SMALL_ISLAND_SCALE, this.APPEAR_EASE, new float[0]).setSpecial(CONTAINER_CLIP_START_PROGRESS, this.APPEAR_EASE, new float[0]).setSpecial(CONTAINER_CLIP_END_PROGRESS, this.APPEAR_EASE, new float[0]).setSpecial(CONTAINER_CLIP_TOP_PROGRESS, this.APPEAR_EASE, new float[0]).setSpecial(CONTAINER_CLIP_BOTTOM_PROGRESS, this.APPEAR_EASE, new float[0]).addListeners(new TransitionListener[]{new DynamicIslandAnimListener(this, dynamicIslandContentView){
            final DynamicIslandContentView $view;
            final DynamicIslandAnimationDelegate this$0;
            {
                this.this$0 = dynamicIslandAnimationDelegate;
                this.$view = dynamicIslandContentView;
                super(dynamicIslandAnimationDelegate);
            }

            public void onBegin(Object object) {
                super.onBegin(object);
                DynamicIslandAnimationDelegate.access$setViewVisible(this.this$0, this.$view, 0);
                object = DynamicIslandAnimationDelegate.access$getFakeView(this.this$0);
                if (object != null) {
                    ((DynamicIslandContentFakeView)((Object)object)).setVisibility(4);
                }
                DynamicIslandScenarioUtils.INSTANCE.setDynamicIslandScenarioState(438L, true);
            }

            public void onCancel(Object object) {
                super.onCancel(object);
                DynamicIslandScenarioUtils.INSTANCE.setDynamicIslandScenarioState(438L, false);
            }

            public void onComplete(Object object) {
                super.onComplete(object);
                DynamicIslandScenarioUtils.INSTANCE.setDynamicIslandScenarioState(438L, false);
            }
        }})});
        this.fakeViewToSmallIsland(dynamicIslandContentView, false);
    }

    public final void hiddenToTempHiddenAnimation(DynamicIslandContentView object) {
        o.g((Object)object, (String)"view");
        object = CommonUtils.INSTANCE.getIS_TABLET() && ((object = ((DynamicIslandBaseContentView)((Object)object)).getCurrentIslandData()) == null || (object = object.getProperties()) == null || (Integer)object != 0) ? this.getHiddenAnimStatePad() : this.getCutoutAnimState();
        FolmeKt.getFolme((FolmeObject)this).to(object, new AnimConfig[]{new AnimConfig().addListeners(new TransitionListener[]{new DynamicIslandAnimListener(this){}})});
    }

    public final void hiddenToTempHiddenNoAnimation(DynamicIslandContentView dynamicIslandContentView) {
        o.g((Object)((Object)dynamicIslandContentView), (String)"view");
        FolmeKt.getFolme((FolmeObject)this).setTo((Object)this.getCutoutAnimState(), new AnimConfig[]{new AnimConfig().addListeners(new TransitionListener[]{new DynamicIslandAnimListener(this){}})});
    }

    public final void immersiveAlphaAnimation(DynamicIslandContentView dynamicIslandContentView) {
        o.g((Object)((Object)dynamicIslandContentView), (String)"view");
        if (this.expandedToTempHiddenAnimating) {
            FolmeKt.getFolme((FolmeObject)this).cancel();
            FolmeKt.getFolme((FolmeObject)this).setTo((Object)this.getTempHiddenCompleteAnimStatePad());
            this.scheduleUpdate();
            this.expandedToTempHiddenAnimating = false;
        }
        this.setViewVisible(dynamicIslandContentView, 0);
        dynamicIslandContentView.updateBigIslandLayout();
        if (((Boolean)this.dynamicIslandAnimController.getDynamicIslandWindowState().getStatusBarWindowsInsetsShow().getValue()).booleanValue()) {
            FolmeKt.getFolme((FolmeObject)this).setTo((Object)new AnimState().add(CONTAINER_TRANS_Y, 0.0f, new long[0]));
        } else {
            FolmeKt.getFolme((FolmeObject)this).setTo((Object)new AnimState().add(CONTAINER_TRANS_Y, 0.0f, new long[0]).add(CONTAINER_ALPHA, 0.0f, new long[0]));
        }
        EaseManager.EaseStyle easeStyle = FolmeEase.bezier((float)0.3f, (float)0.0f, (float)1.0f, (float)1.0f, (long)300L);
        easeStyle = new AnimConfig().setSpecial(CONTAINER_ALPHA, easeStyle, new float[0]);
        FolmeKt.getFolme((FolmeObject)this).to((Object)this.getBigIslandAnimState(), new AnimConfig[]{easeStyle.addListeners(new TransitionListener[]{new DynamicIslandAnimListener(this, dynamicIslandContentView){
            final DynamicIslandContentView $view;
            final DynamicIslandAnimationDelegate this$0;
            {
                this.this$0 = dynamicIslandAnimationDelegate;
                this.$view = dynamicIslandContentView;
                super(dynamicIslandAnimationDelegate);
            }

            public void onBegin(Object object) {
                object = this.$view.getBigIslandView();
                if (object != null) {
                    object.setVisibility(0);
                }
                DynamicIslandAnimationDelegate.access$getAnimationDelegateHelper$p(this.this$0).requestUpdateHeadsUpLocation(DynamicIslandAnimationType.TEMP_HIDDEN_TO_BIG, this.$view);
            }
        }})});
    }

    public final void initToAppExpandedAnimation(DynamicIslandContentView dynamicIslandContentView) {
        DynamicIslandEventCoordinator dynamicIslandEventCoordinator;
        o.g((Object)((Object)dynamicIslandContentView), (String)"view");
        this.initToHiddenNoAnim(dynamicIslandContentView);
        this.setViewVisible(dynamicIslandContentView, 4);
        if (dynamicIslandContentView.getState() instanceof DynamicIslandState.AppExpanded && (dynamicIslandEventCoordinator = dynamicIslandContentView.getDynamicIslandEventCoordinator()) != null) {
            dynamicIslandEventCoordinator.updateView(dynamicIslandContentView);
        }
    }

    public final void initToBigIslandAnimation(DynamicIslandContentView dynamicIslandContentView) {
        Object object;
        AnimConfig animConfig2;
        Object object2;
        o.g((Object)((Object)dynamicIslandContentView), (String)"view");
        dynamicIslandContentView.updateBigIslandLayout();
        CommonUtils commonUtils = CommonUtils.INSTANCE;
        if (commonUtils.getIS_TABLET()) {
            object2 = dynamicIslandContentView.getCurrentIslandData();
            object2 = object2 != null && (object2 = object2.getProperties()) != null && object2.intValue() == 0 ? this.getCutoutAnimState() : this.getBigIslandHiddenAnimState();
            animConfig2 = new AnimConfig().setSpecial(CONTAINER_ALPHA, this.PAD_SHOW_EASE, 100L, new float[0]).setSpecial(CONTAINER_CLIP_START_PROGRESS, this.PAD_SHOW_EASE, 100L, new float[0]).setSpecial(CONTAINER_CLIP_END_PROGRESS, this.PAD_SHOW_EASE, 100L, new float[0]).setSpecial(BIG_ISLAND_SCALE, this.PAD_SHOW_EASE, 100L, new float[0]).setSpecial(BIG_ISLAND_ALPHA, this.PAD_SHOW_EASE, 100L, new float[0]).setSpecial(BIG_ISLAND_BLUR, this.PAD_SHOW_EASE, new float[0]);
            o.f((Object)animConfig2, (String)"setSpecial(...)");
            object = object2;
        } else {
            object = this.getCutoutAnimState();
            animConfig2 = new AnimConfig().setSpecial(CONTAINER_ALPHA, FolmeEase.linear((long)1L), new float[0]).setSpecial(CONTAINER_CLIP_START_PROGRESS, this.APPEAR_EASE, new float[0]).setSpecial(CONTAINER_CLIP_END_PROGRESS, this.APPEAR_EASE, new float[0]).setSpecial(BIG_ISLAND_SCALE, this.APPEAR_EASE, new float[0]).setSpecial(BIG_ISLAND_ALPHA, this.HIDDEN_EASE, 100L, new float[0]).setSpecial(BIG_ISLAND_AREA_LEFT_TRANS_X, this.APPEAR_EASE, new float[0]).setSpecial(BIG_ISLAND_AREA_RIGHT_TRANS_X, this.APPEAR_EASE, new float[0]);
            o.f((Object)animConfig2, (String)"setSpecial(...)");
        }
        Object object3 = this.getBigIslandAnimState();
        object2 = object3;
        if (commonUtils.getIS_TABLET()) {
            object2 = object3;
            if (!((Boolean)this.dynamicIslandAnimController.getDynamicIslandWindowState().getStatusBarWindowsInsetsShow().getValue()).booleanValue()) {
                object2 = dynamicIslandContentView.getCurrentIslandData();
                object2 = object2 != null && (object2 = object2.getProperties()) != null && object2.intValue() == 0 ? object3 : null;
            }
        }
        object3 = object2;
        if (object2 == null) {
            object3 = this.getBigIslandAnimState().add(CONTAINER_ALPHA, 0.0f, new long[0]).add(BIG_ISLAND_ALPHA, 0.0f, new long[0]);
        }
        this.setViewVisible(dynamicIslandContentView, 0);
        object2 = dynamicIslandContentView.getExpandedView();
        if (object2 != null) {
            object2.setVisibility(4);
        }
        object2 = dynamicIslandContentView.getBigIslandView();
        if (object2 != null) {
            object2.setAlpha(0.0f);
        }
        object2 = dynamicIslandContentView.getBigIslandView();
        if (object2 != null) {
            object2.setVisibility(0);
        }
        object2 = dynamicIslandContentView.getSmallIslandView();
        if (object2 != null) {
            object2.setVisibility(4);
        }
        FolmeKt.getFolme((FolmeObject)this).setTo(object).to(object3, new AnimConfig[]{animConfig2.addListeners(new TransitionListener[]{new DynamicIslandAnimListener(this, dynamicIslandContentView){
            final DynamicIslandContentView $view;
            final DynamicIslandAnimationDelegate this$0;
            {
                this.this$0 = dynamicIslandAnimationDelegate;
                this.$view = dynamicIslandContentView;
                super(dynamicIslandAnimationDelegate);
            }

            public void onBegin(Object object) {
                super.onBegin(object);
                DynamicIslandAnimationCallback dynamicIslandAnimationCallback = DynamicIslandAnimationDelegate.access$getDynamicIslandAnimController$p(this.this$0).getAnimationCallback$miui_dynamicisland_release();
                DynamicIslandAnimationType dynamicIslandAnimationType = DynamicIslandAnimationType.INIT_TO_BIG;
                DynamicIslandAnimationCallbackType dynamicIslandAnimationCallbackType = DynamicIslandAnimationCallbackType.ANIM_START;
                o.e((Object)object, (String)"null cannot be cast to non-null type kotlin.String");
                dynamicIslandAnimationCallback.executeCallback(dynamicIslandAnimationType, dynamicIslandAnimationCallbackType, (String)object);
                DynamicIslandScenarioUtils.INSTANCE.setDynamicIslandScenarioState(434L, true);
                DynamicIslandAnimationDelegate.access$getAnimationDelegateHelper$p(this.this$0).requestUpdateHeadsUpLocation(dynamicIslandAnimationType, this.$view);
                DynamicIslandAnimationDelegate.access$getAnimationDelegateHelper$p(this.this$0).updateBigIslandContainerBackground(this.$view);
            }

            public void onCancel(Object object) {
                super.onCancel(object);
                DynamicIslandScenarioUtils.INSTANCE.setDynamicIslandScenarioState(434L, false);
            }

            public void onComplete(Object object) {
                super.onComplete(object);
                DynamicIslandScenarioUtils.INSTANCE.setDynamicIslandScenarioState(434L, false);
            }
        }})});
        this.fakeViewToBigIsland(dynamicIslandContentView, false);
    }

    public final void initToExpandedAnimation(DynamicIslandContentView dynamicIslandContentView) {
        o.g((Object)((Object)dynamicIslandContentView), (String)"view");
        CommonUtils commonUtils = CommonUtils.INSTANCE;
        AnimState animState = commonUtils.getIS_TABLET() && !this.getPanelHeightChanging() ? this.getSlideOffAnimStatePad() : this.getCutoutAnimState();
        AnimConfig animConfig2 = new AnimConfig();
        if (commonUtils.getIS_TABLET()) {
            animConfig2.setSpecial(CONTAINER_TRANS_Y, EASE_FAST_OUT_SLOW_IN, new float[0]);
        } else {
            animConfig2.setSpecial(CONTAINER_ALPHA, FolmeEase.linear((long)1L), new float[0]);
        }
        FolmeKt.getFolme((FolmeObject)this).setTo((Object)animState).to((Object)this.getExpandedAnimState(), new AnimConfig[]{animConfig2.addListeners(new TransitionListener[]{new DynamicIslandAnimListener(this, dynamicIslandContentView){
            final DynamicIslandContentView $view;
            final DynamicIslandAnimationDelegate this$0;
            {
                this.this$0 = dynamicIslandAnimationDelegate;
                this.$view = dynamicIslandContentView;
                super(dynamicIslandAnimationDelegate);
            }

            public void onBegin(Object object) {
                super.onBegin(object);
                Object object2 = this.$view.getExpandedView();
                if (object2 != null) {
                    object2.setVisibility(0);
                }
                object2 = this.$view.getBigIslandView();
                if (object2 != null) {
                    object2.setVisibility(4);
                }
                object2 = this.$view.getSmallIslandView();
                if (object2 != null) {
                    object2.setVisibility(4);
                }
                DynamicIslandAnimationDelegate.access$setViewVisible(this.this$0, this.$view, 0);
                object2 = this.$view.getMask();
                if (object2 != null) {
                    object2.setVisibility(4);
                }
                DynamicIslandAnimationDelegate.access$getAnimationDelegateHelper$p(this.this$0).requestUpdateHeadsUpLocation(DynamicIslandAnimationType.INIT_TO_EXPANDED, this.$view);
                DynamicIslandAnimationCallback dynamicIslandAnimationCallback = DynamicIslandAnimationDelegate.access$getDynamicIslandAnimController$p(this.this$0).getAnimationCallback$miui_dynamicisland_release();
                object2 = DynamicIslandAnimationType.TO_EXPANDED;
                DynamicIslandAnimationCallbackType dynamicIslandAnimationCallbackType = DynamicIslandAnimationCallbackType.ANIM_START;
                o.e((Object)object, (String)"null cannot be cast to non-null type kotlin.String");
                dynamicIslandAnimationCallback.executeCallback((DynamicIslandAnimationType)((Object)object2), dynamicIslandAnimationCallbackType, (String)object);
                DynamicIslandScenarioUtils.INSTANCE.setDynamicIslandScenarioState(475L, true);
                DynamicIslandAnimationDelegate.access$setAnimateExpanding(this.this$0, true);
            }

            public void onCancel(Object object) {
                super.onCancel(object);
                DynamicIslandScenarioUtils.INSTANCE.setDynamicIslandScenarioState(475L, false);
                DynamicIslandAnimationDelegate.access$setAnimateExpanding(this.this$0, false);
            }

            public void onComplete(Object object) {
                super.onComplete(object);
                DynamicIslandAnimationCallback dynamicIslandAnimationCallback = DynamicIslandAnimationDelegate.access$getDynamicIslandAnimController$p(this.this$0).getAnimationCallback$miui_dynamicisland_release();
                DynamicIslandAnimationType dynamicIslandAnimationType = DynamicIslandAnimationType.TO_EXPANDED;
                DynamicIslandAnimationCallbackType dynamicIslandAnimationCallbackType = DynamicIslandAnimationCallbackType.ANIM_FINISH;
                o.e((Object)object, (String)"null cannot be cast to non-null type kotlin.String");
                dynamicIslandAnimationCallback.executeCallback(dynamicIslandAnimationType, dynamicIslandAnimationCallbackType, (String)object);
                DynamicIslandScenarioUtils.INSTANCE.setDynamicIslandScenarioState(475L, false);
                DynamicIslandAnimationDelegate.access$setAnimateExpanding(this.this$0, false);
            }
        }})});
        this.fakeViewToExpanded(dynamicIslandContentView, false);
    }

    public final void initToHiddenNoAnimation(DynamicIslandContentView dynamicIslandContentView) {
        o.g((Object)((Object)dynamicIslandContentView), (String)"view");
        this.setViewVisible(dynamicIslandContentView, 4);
        this.initToHiddenNoAnim(dynamicIslandContentView);
    }

    public final void initToMiniWindowExpandedAnimation(DynamicIslandContentView dynamicIslandContentView) {
        DynamicIslandEventCoordinator dynamicIslandEventCoordinator;
        DynamicIslandContentFakeView dynamicIslandContentFakeView;
        o.g((Object)((Object)dynamicIslandContentView), (String)"view");
        this.initToHiddenNoAnim(dynamicIslandContentView);
        this.setViewVisible(dynamicIslandContentView, 4);
        if (dynamicIslandContentView.getState() instanceof DynamicIslandState.MiniWindowExpanded && (dynamicIslandContentFakeView = dynamicIslandContentView.getFakeView()) != null && (dynamicIslandEventCoordinator = dynamicIslandContentFakeView.getDynamicIslandEventCoordinator()) != null) {
            DynamicIslandContentFakeView dynamicIslandContentFakeView2 = dynamicIslandContentView.getFakeView();
            dynamicIslandContentFakeView = dynamicIslandContentView.getCurrentIslandData();
            dynamicIslandContentFakeView = dynamicIslandContentFakeView != null ? dynamicIslandContentFakeView.getExtras() : null;
            dynamicIslandEventCoordinator.updateFreeformFakeView(dynamicIslandContentFakeView2, dynamicIslandContentView, (Bundle)dynamicIslandContentFakeView);
        }
    }

    public final void initToSmallIslandAnimation(DynamicIslandContentView dynamicIslandContentView) {
        o.g((Object)((Object)dynamicIslandContentView), (String)"view");
        FolmeKt.getFolme((FolmeObject)this).setTo((Object)this.getCutoutAnimState()).to((Object)this.getSmallIslandAnimState(), new AnimConfig[]{new AnimConfig().setSpecial(CONTAINER_ALPHA, FolmeEase.linear((long)1L), new float[0]).setSpecial(CONTAINER_X, this.APPEAR_EASE, new float[0]).setSpecial(CONTAINER_CLIP_START_PROGRESS, this.APPEAR_EASE, new float[0]).setSpecial(CONTAINER_CLIP_END_PROGRESS, this.APPEAR_EASE, new float[0]).setSpecial(SMALL_ISLAND_SCALE, this.APPEAR_EASE, new float[0]).setSpecial(SMALL_ISLAND_ALPHA, this.HIDDEN_EASE, 100L, new float[0]).addListeners(new TransitionListener[]{new DynamicIslandAnimListener(this, dynamicIslandContentView){
            final DynamicIslandContentView $view;
            final DynamicIslandAnimationDelegate this$0;
            {
                this.this$0 = dynamicIslandAnimationDelegate;
                this.$view = dynamicIslandContentView;
                super(dynamicIslandAnimationDelegate);
            }

            public void onBegin(Object object) {
                super.onBegin(object);
                object = this.$view.getExpandedView();
                if (object != null) {
                    object.setVisibility(4);
                }
                object = this.$view.getBigIslandView();
                if (object != null) {
                    object.setVisibility(4);
                }
                object = this.$view.getSmallIslandView();
                if (object != null) {
                    object.setVisibility(0);
                }
                DynamicIslandAnimationDelegate.access$setViewVisible(this.this$0, this.$view, 0);
                object = this.$view.getMask();
                if (object != null) {
                    object.setVisibility(8);
                }
                DynamicIslandScenarioUtils.INSTANCE.setDynamicIslandScenarioState(438L, true);
            }

            public void onCancel(Object object) {
                super.onCancel(object);
                DynamicIslandScenarioUtils.INSTANCE.setDynamicIslandScenarioState(438L, false);
            }

            public void onComplete(Object object) {
                super.onComplete(object);
                DynamicIslandScenarioUtils.INSTANCE.setDynamicIslandScenarioState(438L, false);
            }
        }})});
        this.fakeViewToSmallIsland(dynamicIslandContentView, false);
    }

    public final void initToTempHiddenAnimation(DynamicIslandContentView dynamicIslandBaseContentView) {
        o.g((Object)((Object)dynamicIslandBaseContentView), (String)"view");
        ((DynamicIslandContentView)dynamicIslandBaseContentView).setAlpha(0.0f);
        DynamicIslandContentFakeView dynamicIslandContentFakeView = dynamicIslandBaseContentView.getFakeView();
        if (dynamicIslandContentFakeView != null) {
            dynamicIslandContentFakeView.setAlpha(0.0f);
        }
        IFolme iFolme = FolmeKt.getFolme((FolmeObject)this);
        dynamicIslandContentFakeView = CommonUtils.INSTANCE.getIS_TABLET() ? this.getBigIslandHiddenAnimState() : this.getCutoutAnimState();
        iFolme.setTo((Object)dynamicIslandContentFakeView, new AnimConfig[]{new AnimConfig().addListeners(new TransitionListener[]{new DynamicIslandAnimListener(this){}})});
        dynamicIslandBaseContentView = dynamicIslandBaseContentView.getFakeView();
        if (dynamicIslandBaseContentView != null) {
            ((DynamicIslandContentFakeView)dynamicIslandBaseContentView).setVisibility(8);
        }
    }

    public final boolean isAnimating() {
        return this.isAnimating;
    }

    public final boolean isAppClosing() {
        return this.isAppClosing;
    }

    public final boolean isBlockUpdatePosition() {
        return this.isBlockUpdatePosition;
    }

    public final void isLandDragShake(List<DynamicIslandContentView> object) {
        Object object2 = this.TAG;
        Number number = object != null ? Integer.valueOf(object.size()) : null;
        Object object3 = new StringBuilder();
        ((StringBuilder)object3).append("isLandDragShake: from.size ");
        ((StringBuilder)object3).append(number);
        Log.i((String)object2, (String)((StringBuilder)object3).toString());
        float f2 = this.view.getContext().getResources().getDimension(R.dimen.isLand_drag_shake_to_left);
        float f3 = this.view.getContext().getResources().getDimension(R.dimen.isLand_drag_shake_to_right);
        float f4 = this.view.getContext().getResources().getDimension(R.dimen.isLand_drag_shake_to_original_position);
        if (object != null) {
            object3 = object.iterator();
            while (object3.hasNext()) {
                float f5;
                DynamicIslandContentView dynamicIslandContentView = (DynamicIslandContentView)((Object)object3.next());
                object2 = dynamicIslandContentView != null && (object = dynamicIslandContentView.getBackgroundView()) != null ? Float.valueOf(object.getX()) : null;
                object = object2 != null ? Float.valueOf(((Float)object2).floatValue() + f2) : null;
                number = object2 != null ? Float.valueOf(((Float)object2).floatValue() + f3) : null;
                object2 = object2 != null ? Float.valueOf(((Float)object2).floatValue() + f4) : null;
                if (object != null) {
                    f5 = ((Number)object).floatValue();
                    object = ObjectAnimator.ofFloat((Object)((Object)dynamicIslandContentView.getBackgroundView()), (String)"x", (float[])new float[]{f5});
                    object.setDuration(100L);
                    object.setInterpolator((TimeInterpolator)new PathInterpolator(0.1f, 0.1f, 0.9f, 0.9f));
                } else {
                    object = null;
                }
                if (number != null) {
                    f5 = number.floatValue();
                    number = ObjectAnimator.ofFloat((Object)((Object)dynamicIslandContentView.getBackgroundView()), (String)"x", (float[])new float[]{f5});
                    number.setDuration(100L);
                    number.setInterpolator((TimeInterpolator)new PathInterpolator(0.1f, 0.1f, 0.9f, 0.9f));
                } else {
                    number = null;
                }
                if (object2 != null) {
                    f5 = ((Number)object2).floatValue();
                    object2 = ObjectAnimator.ofFloat((Object)((Object)dynamicIslandContentView.getBackgroundView()), (String)"x", (float[])new float[]{f5});
                    object2.setDuration(200L);
                    object2.setInterpolator((TimeInterpolator)new PathInterpolator(0.2f, 0.2f, 0.8f, 0.8f));
                } else {
                    object2 = null;
                }
                dynamicIslandContentView = new AnimatorSet();
                dynamicIslandContentView.playSequentially(new Animator[]{object, number, object2});
                dynamicIslandContentView.start();
            }
        }
    }

    public final void miniWindowToAppExpanded(DynamicIslandContentView dynamicIslandContentView) {
        o.g((Object)((Object)dynamicIslandContentView), (String)"view");
        this.setViewVisible(dynamicIslandContentView, 0);
        Object object = dynamicIslandContentView.getFakeView();
        if (object != null) {
            object.setAlpha(1.0f);
        }
        object = dynamicIslandContentView.getDynamicIslandEventCoordinator();
        if (object != null) {
            ((DynamicIslandEventCoordinator)object).updateView(dynamicIslandContentView);
        }
    }

    public final void miniWindowToBigIslandAnimation(DynamicIslandContentView dynamicIslandContentView) {
        o.g((Object)((Object)dynamicIslandContentView), (String)"view");
        this.appExpandedToBigIslandAnimation(dynamicIslandContentView, false);
    }

    public final void miniWindowToSmallIslandAnimation(DynamicIslandContentView dynamicIslandContentView) {
        o.g((Object)((Object)dynamicIslandContentView), (String)"view");
        this.appExpandedToSmallIslandAnimation(dynamicIslandContentView, false);
    }

    public final void miniWindowToTempHiddenAnimation(DynamicIslandContentView dynamicIslandContentView) {
        o.g((Object)((Object)dynamicIslandContentView), (String)"view");
        FolmeKt.getFolme((FolmeObject)this).setTo((Object)this.getCutoutAnimState(), new AnimConfig[]{new AnimConfig().addListeners(new TransitionListener[]{new DynamicIslandAnimListener(this){}})});
        dynamicIslandContentView.setAlpha(0.0f);
        DynamicIslandContentFakeView dynamicIslandContentFakeView = dynamicIslandContentView.getFakeView();
        dynamicIslandContentFakeView = dynamicIslandContentFakeView != null ? dynamicIslandContentFakeView.getFakeExpandedView() : null;
        if (dynamicIslandContentFakeView != null) {
            dynamicIslandContentFakeView.setVisibility(4);
        }
        this.fakeViewToTempHiddenAnimation(dynamicIslandContentView);
    }

    public final void miniWindowToTempHiddenNoAnimation(DynamicIslandContentView dynamicIslandBaseContentView) {
        o.g((Object)((Object)dynamicIslandBaseContentView), (String)"view");
        this.setViewVisible(dynamicIslandBaseContentView, 8);
        dynamicIslandBaseContentView = dynamicIslandBaseContentView.getFakeView();
        if (dynamicIslandBaseContentView != null) {
            ((DynamicIslandContentFakeView)dynamicIslandBaseContentView).setVisibility(8);
        }
    }

    public final void moveDownAnimation(DynamicIslandContentView dynamicIslandContentView) {
        o.g((Object)((Object)dynamicIslandContentView), (String)"view");
        this.isMoveDownAnimating = true;
        this.setViewVisible(dynamicIslandContentView, 0);
        dynamicIslandContentView.updateBigIslandLayout();
        float f2 = -((float)dynamicIslandContentView.getStatusBarHeight());
        AnimState animState = new AnimState();
        AnimState animState2 = new AnimState();
        AnimConfig animConfig2 = new AnimConfig();
        if (DeviceUtils.isLowLevel()) {
            FloatProperty<DynamicIslandAnimationDelegate> floatProperty = CONTAINER_TRANS_Y;
            FloatProperty<DynamicIslandAnimationDelegate> floatProperty2 = animState.add(floatProperty, f2, new long[0]);
            FloatProperty<DynamicIslandAnimationDelegate> floatProperty3 = CONTAINER_ALPHA;
            AnimState animState3 = floatProperty2.add(floatProperty3, 0.0f, new long[0]);
            floatProperty2 = BIG_ISLAND_ALPHA;
            animState3.add(floatProperty2, 0.0f, new long[0]);
            animState2.add(floatProperty, 0.0f, new long[0]).add(floatProperty3, 1.0f, new long[0]).add(floatProperty2, 1.0f, new long[0]);
            animConfig2.setSpecial(floatProperty, FolmeEase.bezier((float)0.4f, (float)0.0f, (float)0.2f, (float)1.0f, (long)250L), new float[0]).setSpecial(floatProperty3, FolmeEase.bezier((float)0.4f, (float)0.0f, (float)0.2f, (float)1.0f, (long)250L), new float[0]).setSpecial(floatProperty2, FolmeEase.bezier((float)0.4f, (float)0.0f, (float)0.2f, (float)1.0f, (long)250L), new float[0]);
        } else {
            if (CommonUtils.INSTANCE.getIS_TABLET()) {
                animState.set(this.getTempHiddenCompleteAnimStatePad());
            }
            FloatProperty<DynamicIslandAnimationDelegate> floatProperty = CONTAINER_TRANS_Y;
            animState.add(floatProperty, f2, new long[0]).add(CONTAINER_ALPHA, 1.0f, new long[0]).add(BIG_ISLAND_ALPHA, 1.0f, new long[0]);
            animState2.add(floatProperty, 0.0f, new long[0]);
            animConfig2.setSpecial(floatProperty, FolmeEase.bezier((float)0.4f, (float)0.0f, (float)0.2f, (float)1.0f, (long)250L), new float[0]);
        }
        FolmeKt.getFolme((FolmeObject)this).setTo((Object)animState).to((Object)animState2, new AnimConfig[]{animConfig2.addListeners(new TransitionListener[]{new DynamicIslandAnimListener(this, dynamicIslandContentView){
            final DynamicIslandContentView $view;
            final DynamicIslandAnimationDelegate this$0;
            {
                this.this$0 = dynamicIslandAnimationDelegate;
                this.$view = dynamicIslandContentView;
                super(dynamicIslandAnimationDelegate);
            }

            public void onBegin(Object object) {
                object = this.$view.getBigIslandView();
                if (object != null) {
                    object.setVisibility(0);
                }
                DynamicIslandAnimationDelegate.access$getAnimationDelegateHelper$p(this.this$0).requestUpdateHeadsUpLocation(DynamicIslandAnimationType.TEMP_HIDDEN_TO_BIG, this.$view);
            }

            public void onCancel(Object object) {
                super.onCancel(object);
                DynamicIslandAnimationDelegate.access$setMoveDownAnimating$p(this.this$0, false);
            }

            public void onComplete(Object object) {
                super.onComplete(object);
                DynamicIslandAnimationDelegate.access$setMoveDownAnimating$p(this.this$0, false);
            }
        }})});
    }

    public final void moveUpAnimation(DynamicIslandContentView dynamicIslandContentView) {
        o.g((Object)((Object)dynamicIslandContentView), (String)"view");
        if (this.isMoveUpAnimating) {
            return;
        }
        this.isMoveUpAnimating = true;
        this.setViewVisible(dynamicIslandContentView, 0);
        float f2 = -((float)dynamicIslandContentView.getStatusBarHeight());
        AnimState animState = new AnimState();
        AnimState animState2 = new AnimState();
        AnimConfig animConfig2 = new AnimConfig();
        if (DeviceUtils.isLowLevel()) {
            FloatProperty<DynamicIslandAnimationDelegate> floatProperty = CONTAINER_TRANS_Y;
            AnimState animState3 = animState.add(floatProperty, 0.0f, new long[0]);
            FloatProperty<DynamicIslandAnimationDelegate> floatProperty2 = CONTAINER_ALPHA;
            animState3 = animState3.add(floatProperty2, 1.0f, new long[0]);
            FloatProperty<DynamicIslandAnimationDelegate> floatProperty3 = BIG_ISLAND_ALPHA;
            animState3.add(floatProperty3, 1.0f, new long[0]);
            animState2.add(floatProperty, f2, new long[0]).add(floatProperty2, 0.0f, new long[0]).add(floatProperty3, 0.0f, new long[0]);
            animConfig2.setSpecial(floatProperty, FolmeEase.bezier((float)0.4f, (float)0.0f, (float)0.2f, (float)1.0f, (long)230L), new float[0]).setSpecial(floatProperty2, FolmeEase.bezier((float)0.4f, (float)0.0f, (float)0.2f, (float)1.0f, (long)150L), new float[0]).setSpecial(floatProperty3, FolmeEase.bezier((float)0.4f, (float)0.0f, (float)0.2f, (float)1.0f, (long)150L), new float[0]);
        } else {
            FloatProperty<DynamicIslandAnimationDelegate> floatProperty = CONTAINER_TRANS_Y;
            animState.add(floatProperty, 0.0f, new long[0]);
            animState2.add(floatProperty, f2, new long[0]);
            animConfig2.setSpecial(floatProperty, FolmeEase.bezier((float)0.4f, (float)0.0f, (float)0.2f, (float)1.0f, (long)230L), new float[0]);
        }
        FolmeKt.getFolme((FolmeObject)this).setTo((Object)animState).to((Object)animState2, new AnimConfig[]{animConfig2.addListeners(new TransitionListener[]{new DynamicIslandAnimListener(this, dynamicIslandContentView){
            final DynamicIslandContentView $view;
            final DynamicIslandAnimationDelegate this$0;
            {
                this.this$0 = dynamicIslandAnimationDelegate;
                this.$view = dynamicIslandContentView;
                super(dynamicIslandAnimationDelegate);
            }

            public void onBegin(Object object) {
                super.onBegin(object);
                object = this.$view.getBigIslandView();
                if (object != null) {
                    object.setVisibility(0);
                }
                DynamicIslandAnimationDelegate.access$getAnimationDelegateHelper$p(this.this$0).requestUpdateHeadsUpLocation(DynamicIslandAnimationType.TEMP_HIDDEN_TO_BIG, this.$view);
            }

            public void onCancel(Object object) {
                super.onCancel(object);
                boolean bl = (Boolean)DynamicIslandAnimationDelegate.access$getDynamicIslandAnimController$p(this.this$0).getDynamicIslandWindowState().getStatusBarWindowsInsetsShow().getValue();
                if (CommonUtils.INSTANCE.getIS_TABLET() && !bl) {
                    DynamicIslandAnimationDelegate.access$setViewVisible(this.this$0, this.$view, 8);
                }
                DynamicIslandAnimationDelegate.access$setMoveUpAnimating$p(this.this$0, false);
            }

            public void onComplete(Object object) {
                super.onComplete(object);
                DynamicIslandAnimationDelegate.access$setViewVisible(this.this$0, this.$view, 4);
                DynamicIslandAnimationDelegate.access$setMoveUpAnimating$p(this.this$0, false);
            }
        }})});
    }

    public final void onBegin(Object object) {
        DynamicIslandAnimationCallback dynamicIslandAnimationCallback = this.dynamicIslandAnimController.getAnimationCallback$miui_dynamicisland_release();
        DynamicIslandAnimationType dynamicIslandAnimationType = DynamicIslandAnimationType.ALL;
        DynamicIslandAnimationCallbackType dynamicIslandAnimationCallbackType = DynamicIslandAnimationCallbackType.ANIM_START;
        o.e((Object)object, (String)"null cannot be cast to non-null type kotlin.String");
        dynamicIslandAnimationCallback.executeCallback(dynamicIslandAnimationType, dynamicIslandAnimationCallbackType, (String)object);
    }

    public final void onCancel(Object object) {
        DynamicIslandAnimationCallback dynamicIslandAnimationCallback = this.dynamicIslandAnimController.getAnimationCallback$miui_dynamicisland_release();
        DynamicIslandAnimationType dynamicIslandAnimationType = DynamicIslandAnimationType.ALL;
        DynamicIslandAnimationCallbackType dynamicIslandAnimationCallbackType = DynamicIslandAnimationCallbackType.ANIM_CANCEL;
        o.e((Object)object, (String)"null cannot be cast to non-null type kotlin.String");
        dynamicIslandAnimationCallback.executeCallback(dynamicIslandAnimationType, dynamicIslandAnimationCallbackType, (String)object);
    }

    public final void onComplete(Object object) {
        DynamicIslandAnimationCallback dynamicIslandAnimationCallback = this.dynamicIslandAnimController.getAnimationCallback$miui_dynamicisland_release();
        DynamicIslandAnimationType dynamicIslandAnimationType = DynamicIslandAnimationType.ALL;
        DynamicIslandAnimationCallbackType dynamicIslandAnimationCallbackType = DynamicIslandAnimationCallbackType.ANIM_FINISH;
        o.e((Object)object, (String)"null cannot be cast to non-null type kotlin.String");
        dynamicIslandAnimationCallback.executeCallback(dynamicIslandAnimationType, dynamicIslandAnimationCallbackType, (String)object);
    }

    public final void onPress(DynamicIslandContentView floatProperty) {
        o.g((Object)floatProperty, (String)"view");
        FloatProperty<DynamicIslandAnimationDelegate> floatProperty2 = this.dynamicIslandAnimController.getDynamicIslandWindowState();
        Object object = floatProperty.getCurrentIslandData();
        FloatProperty<DynamicIslandAnimationDelegate> floatProperty3 = null;
        object = object != null ? object.getProperties() : null;
        if (floatProperty2.isTempHidden((Integer)object)) {
            return;
        }
        floatProperty2 = floatProperty.getCurrentIslandData();
        object = floatProperty3;
        if (floatProperty2 != null) {
            object = floatProperty2.getKey();
        }
        floatProperty3 = new FloatProperty<DynamicIslandAnimationDelegate>();
        floatProperty3.append("press: ");
        floatProperty3.append((String)object);
        Log.d((String)"DynamicIslandSwipeDebug", (String)floatProperty3.toString());
        if (o.c((Object)((Object)this.smallIslandStateHandler.getCurrent()), (Object)floatProperty)) {
            floatProperty3 = FolmeKt.getFolme((FolmeObject)this);
            floatProperty2 = new AnimState().add(CONTAINER_X, this.getSmallIslandX(), new long[0]).add(CONTAINER_TRANS_Y, 0.0f, new long[0]);
            object = CONTAINER_CLIP_START_PROGRESS;
            FloatProperty<DynamicIslandAnimationDelegate> floatProperty4 = floatProperty2.add(object, this.getSmallIslandStart() + (float)floatProperty.getSmallIslandViewWidth() * 0.05f, new long[0]);
            floatProperty2 = CONTAINER_CLIP_END_PROGRESS;
            AnimState animState = floatProperty4.add(floatProperty2, this.getSmallIslandEnd() - (float)floatProperty.getSmallIslandViewWidth() * 0.05f, new long[0]);
            floatProperty4 = CONTAINER_CLIP_TOP_PROGRESS;
            animState = animState.add(floatProperty4, this.getSmallIslandTop() + (float)floatProperty.getIslandViewHeight() * 0.05f, new long[0]);
            FloatProperty<DynamicIslandAnimationDelegate> floatProperty5 = CONTAINER_CLIP_BOTTOM_PROGRESS;
            floatProperty3.to((Object)animState.add(floatProperty5, this.getSmallIslandBottom() - (float)floatProperty.getIslandViewHeight() * 0.05f, new long[0]).add(SMALL_ISLAND_SCALE, 0.9f, new long[0]), new AnimConfig[]{new AnimConfig().setSpecial(object, this.SCALE_EASE, new float[0]).setSpecial(floatProperty2, this.SCALE_EASE, new float[0]).setSpecial(floatProperty4, this.SCALE_EASE, new float[0]).setSpecial(floatProperty5, this.SCALE_EASE, new float[0]).setSpecial(BIG_ISLAND_SCALE, this.SCALE_EASE, new float[0]).addListeners(new TransitionListener[]{new DynamicIslandAnimListener(this){

                public void onBegin(Object object) {
                }

                public void onCancel(Object object) {
                }

                public void onComplete(Object object) {
                }
            }})});
        } else if (o.c((Object)((Object)this.bigIslandStateHandler.getCurrent()), (Object)floatProperty)) {
            float f2 = this.getBigIslandStart();
            object = FolmeKt.getFolme((FolmeObject)this);
            floatProperty2 = new AnimState().add(CONTAINER_X, 0.0f, new long[0]).add(CONTAINER_TRANS_Y, 0.0f, new long[0]);
            floatProperty3 = CONTAINER_CLIP_START_PROGRESS;
            FloatProperty<DynamicIslandAnimationDelegate> floatProperty6 = floatProperty2.add(floatProperty3, this.getBigIslandStart() + (float)floatProperty.getBigIslandViewWidth() * 0.025f, new long[0]);
            floatProperty2 = CONTAINER_CLIP_END_PROGRESS;
            FloatProperty<DynamicIslandAnimationDelegate> floatProperty7 = floatProperty6.add(floatProperty2, this.getBigIslandEnd() - (float)floatProperty.getBigIslandViewWidth() * 0.025f, new long[0]);
            floatProperty6 = CONTAINER_CLIP_TOP_PROGRESS;
            AnimState animState = floatProperty7.add(floatProperty6, this.getBigIslandTop() + (float)floatProperty.getIslandViewHeight() * 0.025f, new long[0]);
            floatProperty7 = CONTAINER_CLIP_BOTTOM_PROGRESS;
            animState = animState.add(floatProperty7, this.getBigIslandBottom() - (float)floatProperty.getIslandViewHeight() * 0.025f, new long[0]);
            floatProperty = BIG_ISLAND_SCALE;
            object.to((Object)animState.add(floatProperty, 0.95f, new long[0]), new AnimConfig[]{new AnimConfig().setSpecial(floatProperty3, this.SCALE_EASE, new float[0]).setSpecial(floatProperty2, this.SCALE_EASE, new float[0]).setSpecial(floatProperty6, this.SCALE_EASE, new float[0]).setSpecial(floatProperty7, this.SCALE_EASE, new float[0]).setSpecial(floatProperty, this.SCALE_EASE, new float[0]).addListeners(new TransitionListener[]{new DynamicIslandAnimListener(this, f2){
                final float $bigIslandStart;
                final DynamicIslandAnimationDelegate this$0;
                {
                    this.this$0 = dynamicIslandAnimationDelegate;
                    this.$bigIslandStart = f2;
                    super(dynamicIslandAnimationDelegate);
                }

                public void onBegin(Object object) {
                }

                public void onCancel(Object object) {
                }

                public void onComplete(Object object) {
                }

                public void onUpdate(Object object, Collection<UpdateInfo> animState) {
                    super.onUpdate(object, (Collection<UpdateInfo>)animState);
                    if (CommonUtils.INSTANCE.getIS_TABLET() && this.this$0.getBigIslandStart() != this.$bigIslandStart) {
                        FolmeKt.getFolme((FolmeObject)this.this$0).cancel();
                        object = FolmeKt.getFolme((FolmeObject)this.this$0);
                        animState = new AnimState();
                        Companion companion = DynamicIslandAnimationDelegate.Companion;
                        object.setTo((Object)animState.add(companion.getCONTAINER_X(), 0.0f, new long[0]).add(companion.getCONTAINER_TRANS_Y(), 0.0f, new long[0]).add(companion.getCONTAINER_CLIP_START_PROGRESS(), this.this$0.getBigIslandStart(), new long[0]).add(companion.getCONTAINER_CLIP_END_PROGRESS(), this.this$0.getBigIslandEnd(), new long[0]).add(companion.getCONTAINER_CLIP_TOP_PROGRESS(), this.this$0.getBigIslandTop(), new long[0]).add(companion.getCONTAINER_CLIP_BOTTOM_PROGRESS(), this.this$0.getBigIslandBottom(), new long[0]).add(companion.getBIG_ISLAND_SCALE(), 1.0f, new long[0]));
                    }
                }
            }})});
        } else if (o.c((Object)((Object)this.expandedStateHandler.getCurrent()), (Object)floatProperty)) {
            object = FolmeKt.getFolme((FolmeObject)this);
            floatProperty2 = new AnimState().add(CONTAINER_X, 0.0f, new long[0]).add(CONTAINER_TRANS_Y, floatProperty.getExpandedViewY() - floatProperty.getIslandViewMarginTop(), new long[0]);
            floatProperty3 = CONTAINER_CLIP_START_PROGRESS;
            FloatProperty<DynamicIslandAnimationDelegate> floatProperty8 = floatProperty2.add(floatProperty3, this.getExpandedStart() + (float)floatProperty.getExpandedViewWidth() * 0.025f, new long[0]);
            floatProperty2 = CONTAINER_CLIP_END_PROGRESS;
            FloatProperty<DynamicIslandAnimationDelegate> floatProperty9 = floatProperty8.add(floatProperty2, this.getExpandedEnd() - (float)floatProperty.getExpandedViewWidth() * 0.025f, new long[0]);
            floatProperty8 = CONTAINER_CLIP_TOP_PROGRESS;
            AnimState animState = floatProperty9.add(floatProperty8, this.getExpandedTop() + (float)floatProperty.getExpandedViewHeight() * 0.025f, new long[0]);
            floatProperty9 = CONTAINER_CLIP_BOTTOM_PROGRESS;
            animState = animState.add(floatProperty9, this.getExpandedBottom() - (float)floatProperty.getExpandedViewHeight() * 0.025f, new long[0]);
            floatProperty = EXPANDED_SCALE_X;
            animState = animState.add(floatProperty, 0.95f, new long[0]);
            FloatProperty<DynamicIslandAnimationDelegate> floatProperty10 = EXPANDED_SCALE_Y;
            object.to((Object)animState.add(floatProperty10, 0.95f, new long[0]), new AnimConfig[]{new AnimConfig().setSpecial(floatProperty3, this.SCALE_EASE, new float[0]).setSpecial(floatProperty2, this.SCALE_EASE, new float[0]).setSpecial(floatProperty8, this.SCALE_EASE, new float[0]).setSpecial(floatProperty9, this.SCALE_EASE, new float[0]).setSpecial(floatProperty, this.SCALE_EASE, new float[0]).setSpecial(floatProperty10, this.SCALE_EASE, new float[0]).addListeners(new TransitionListener[]{new DynamicIslandAnimListener(this){

                public void onBegin(Object object) {
                }

                public void onCancel(Object object) {
                }

                public void onComplete(Object object) {
                }
            }})});
        }
    }

    public final void onSwipe(DynamicIslandContentView dynamicIslandContentView, DynamicIslandState object, DynamicIslandState dynamicIslandState, float f2, float f3) {
        boolean bl;
        o.g((Object)((Object)dynamicIslandContentView), (String)"view");
        Object object2 = dynamicIslandContentView.getLastState();
        Object var9_7 = null;
        object2 = object2 != null ? object2.getClass().getSimpleName() : null;
        Object object3 = dynamicIslandContentView.getState();
        object3 = object3 != null ? object3.getClass().getSimpleName() : null;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("onSwipe:  ");
        stringBuilder.append((String)object2);
        stringBuilder.append(" -> ");
        stringBuilder.append((String)object3);
        Log.d((String)"DynamicIslandSwipeDebug", (String)stringBuilder.toString());
        object3 = this.dynamicIslandAnimController.getDynamicIslandWindowState();
        stringBuilder = dynamicIslandContentView.getCurrentIslandData();
        object2 = var9_7;
        if (stringBuilder != null) {
            object2 = stringBuilder.getProperties();
        }
        if (((DynamicIslandWindowState)object3).isTempHidden((Integer)object2)) {
            return;
        }
        if (object instanceof DynamicIslandState.Expanded && dynamicIslandState instanceof DynamicIslandState.BigIsland) {
            this.onSwipeExpandedToBig(f2, f3);
        }
        if (object instanceof DynamicIslandState.Hidden && dynamicIslandState instanceof DynamicIslandState.BigIsland) {
            this.onSwipeHiddenToBig(dynamicIslandContentView, f2);
        }
        if ((bl = object instanceof DynamicIslandState.BigIsland) && dynamicIslandState instanceof DynamicIslandState.SmallIsland) {
            this.onSwipeBigToSmallAnimation(dynamicIslandContentView, f2);
        }
        if (bl && dynamicIslandState instanceof DynamicIslandState.Hidden) {
            this.onSwipeBigToHiddenAnimation(dynamicIslandContentView, f2);
        }
        if ((bl = object instanceof DynamicIslandState.SmallIsland) && dynamicIslandState instanceof DynamicIslandState.BigIsland) {
            this.onSwipeSmallIslandToBigIslandAnimation(dynamicIslandContentView, f2);
        }
        if (bl && dynamicIslandState instanceof DynamicIslandState.Hidden) {
            object = dynamicIslandContentView.getDynamicIslandEventCoordinator();
            if (object != null && ((DynamicIslandEventCoordinator)object).lastHiddenListItemIsNull()) {
                this.onSwipeSmallToTempHidden(f2);
            } else {
                this.onSwipeSmallIslandToHiddenAnimation(dynamicIslandContentView, f2);
            }
        }
    }

    public final void onSwipeBigToHiddenAnimation(DynamicIslandContentView dynamicIslandContentView, float f2) {
        o.g((Object)((Object)dynamicIslandContentView), (String)"view");
        DynamicIslandUtils dynamicIslandUtils = DynamicIslandUtils.INSTANCE;
        Context context = dynamicIslandContentView.getContext();
        o.f((Object)context, (String)"getContext(...)");
        f2 = Math.abs(this.ratio(dynamicIslandUtils.getScreenWidthOld(context) / 2, (int)f2));
        FolmeKt.getFolme((FolmeObject)this).to((Object)new AnimState().add(CONTAINER_X, 0, new long[0]).add(CONTAINER_TRANS_Y, 0.0f, new long[0]).add(CONTAINER_CLIP_START_PROGRESS, (double)this.getBigIslandStart() + (double)((float)dynamicIslandContentView.getBigIslandViewWidth() * f2) * 0.5).add(CONTAINER_CLIP_END_PROGRESS, (double)this.getBigIslandEnd() - (double)((float)dynamicIslandContentView.getBigIslandViewWidth() * f2) * 0.5).add(CONTAINER_CLIP_TOP_PROGRESS, this.getBigIslandTop(), new long[0]).add(CONTAINER_CLIP_BOTTOM_PROGRESS, this.getBigIslandBottom(), new long[0]).add(BIG_ISLAND_AREA_LEFT_TRANS_X, this.getSwipeLeftAreaTransX(f2), new long[0]).add(BIG_ISLAND_AREA_RIGHT_TRANS_X, this.getSwipeRightAreaTransX(f2), new long[0]).add(CONTAINER_ALPHA, 1.0f, new long[0]).add(BIG_ISLAND_ALPHA, this.calculateSwipeAlpha(f2), new long[0]), new AnimConfig[]{new AnimConfig().addListeners(new TransitionListener[]{new DynamicIslandAnimListener(this){}})});
    }

    public final void onSwipeHiddenToBig(DynamicIslandContentView dynamicIslandContentView, float f2) {
        o.g((Object)((Object)dynamicIslandContentView), (String)"view");
        dynamicIslandContentView.updateBigIslandLayout();
        FloatProperty<DynamicIslandAnimationDelegate> floatProperty = DynamicIslandUtils.INSTANCE;
        Context context = dynamicIslandContentView.getContext();
        o.f((Object)context, (String)"getContext(...)");
        f2 = Math.abs(this.ratio(floatProperty.getScreenWidthOld(context) / 2, (int)f2));
        IFolme iFolme = FolmeKt.getFolme((FolmeObject)this);
        context = new AnimState();
        floatProperty = CONTAINER_X;
        iFolme.setTo((Object)context.add(floatProperty, 0.0f, new long[0])).to((Object)new AnimState().add(floatProperty, 0.0f, new long[0]).add(CONTAINER_TRANS_Y, 0.0f, new long[0]).add(CONTAINER_CLIP_START_PROGRESS, (double)this.getCutoutStart() - (double)((float)dynamicIslandContentView.getBigIslandViewWidth() * f2) * 0.5).add(CONTAINER_CLIP_END_PROGRESS, (double)this.getCutoutEnd() + (double)((float)dynamicIslandContentView.getBigIslandViewWidth() * f2) * 0.5).add(CONTAINER_CLIP_TOP_PROGRESS, (double)this.getCutoutTop() - (double)((float)dynamicIslandContentView.getIslandViewHeight() * f2) * 0.5).add(CONTAINER_CLIP_BOTTOM_PROGRESS, (double)this.getCutoutBottom() + (double)((float)dynamicIslandContentView.getIslandViewHeight() * f2) * 0.5).add(CONTAINER_ALPHA, 1.0f, new long[0]).add(BIG_ISLAND_ALPHA, 0.0f, new long[0]), new AnimConfig[]{new AnimConfig().addListeners(new TransitionListener[]{new DynamicIslandAnimListener(this){}})});
    }

    public final void onSwipeSmallIslandToBigIslandAnimation(DynamicIslandContentView object, float f2) {
        o.g((Object)object, (String)"view");
        if (((DynamicIslandBaseContentView)((Object)object)).getCurrentBigIslandViewWidth() == null) {
            return;
        }
        this.getSmallIslandX();
        DynamicIslandUtils dynamicIslandUtils = DynamicIslandUtils.INSTANCE;
        FloatProperty<DynamicIslandAnimationDelegate> floatProperty = object.getContext();
        o.f((Object)floatProperty, (String)"getContext(...)");
        f2 = Math.abs(this.ratio(dynamicIslandUtils.getScreenWidthOld((Context)floatProperty) / 2, (int)f2));
        object = ((DynamicIslandBaseContentView)((Object)object)).getCurrentBigIslandViewWidth();
        int n = object != null ? (Integer)object : 0;
        object = FolmeKt.getFolme((FolmeObject)this);
        dynamicIslandUtils = new AnimState().add(CONTAINER_X, this.getSwipeSmallToBigX(f2), new long[0]).add(CONTAINER_TRANS_Y, 0.0f, new long[0]);
        floatProperty = CONTAINER_CLIP_START_PROGRESS;
        double d2 = this.getSmallIslandStart();
        double d3 = (double)((float)n * f2) * 0.25;
        object.to((Object)dynamicIslandUtils.add(floatProperty, d2 - d3).add(CONTAINER_CLIP_END_PROGRESS, (double)this.getSmallIslandEnd() + d3).add(CONTAINER_CLIP_TOP_PROGRESS, this.getBigIslandTop(), new long[0]).add(CONTAINER_CLIP_BOTTOM_PROGRESS, this.getBigIslandBottom(), new long[0]).add(SMALL_ISLAND_ALPHA, 0.8f, new long[0]), new AnimConfig[]{new AnimConfig().addListeners(new TransitionListener[]{new DynamicIslandAnimListener(this){}})});
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final void removeViewFromWindow(DynamicIslandContentView object, boolean bl) {
        Exception exception2;
        block4: {
            Object object2;
            int n;
            o.g((Object)object, (String)"view");
            try {
                n = R.id.dynamic_island_removing;
                object2 = object.getTag(n);
                object2 = object2 instanceof Boolean ? (Boolean)object2 : null;
            }
            catch (Exception exception2) {
                break block4;
            }
            Boolean bl2 = Boolean.TRUE;
            if (o.c((Object)object2, (Object)bl2)) {
                return;
            }
            object.setTag(n, (Object)bl2);
            object2 = object.getParent();
            if (!(object2 == null || this.windowView.getContentViewList().contains(object) && this.windowView.isMediaApp(((DynamicIslandBaseContentView)((Object)object)).getCurrentIslandData()) && !bl)) {
                Log.d((String)this.TAG, (String)"removeViewFromWindow");
                this.windowView.removeView((View)object2);
                this.windowView.setPendingMediaView(null);
            }
            this.windowView.preRemoveDynamicIsland((DynamicIslandContentView)((Object)object), ((DynamicIslandBaseContentView)((Object)object)).getState());
            object.setTag(n, null);
            return;
        }
        object = this.TAG;
        exception2.printStackTrace();
        s s2 = s.a;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("removeViewFromWindow error + ");
        stringBuilder.append(s2);
        Log.e((String)object, (String)stringBuilder.toString());
    }

    public final void resetContainerAlpha() {
        Object object;
        DynamicIslandWindowState dynamicIslandWindowState;
        if (this.needResetContainerAlpha && !(dynamicIslandWindowState = this.dynamicIslandAnimController.getDynamicIslandWindowState()).isTempHidden((Integer)(object = (object = this.view.getCurrentIslandData()) != null ? object.getProperties() : null))) {
            FolmeKt.getFolme((FolmeObject)this).setTo((Object)new AnimState().add(CONTAINER_ALPHA, 1.0f, new long[0]));
            this.view.setAlpha(1.0f);
            this.needResetContainerAlpha = false;
        }
    }

    public final void resetFakeViewAnimState() {
        Log.d((String)"DynamicIslandAnimDebug", (String)"resetFakeViewAnimState");
        if (this.fakeViewAnimating) {
            IFolme iFolme = FolmeKt.getFolme((FolmeObject)this);
            FloatProperty<DynamicIslandAnimationDelegate> floatProperty = FAKE_SMALL_BLUR;
            FloatProperty<DynamicIslandAnimationDelegate> floatProperty2 = FAKE_SMALL_ALPHA;
            FloatProperty<DynamicIslandAnimationDelegate> floatProperty3 = FAKE_BIG_BLUR;
            FloatProperty<DynamicIslandAnimationDelegate> floatProperty4 = FAKE_BIG_ALPHA;
            FloatProperty<DynamicIslandAnimationDelegate> floatProperty5 = FAKE_EXPANDED_BLUR;
            FloatProperty<DynamicIslandAnimationDelegate> floatProperty6 = FAKE_EXPANDED_ALPHA;
            iFolme.end(new Object[]{floatProperty, floatProperty2, floatProperty3, floatProperty4, floatProperty5, floatProperty6});
            this.fakeViewAnimating = false;
        }
        this.fakeSmallAlpha = 1.0f;
        this.fakeBigAlpha = 1.0f;
        this.fakeExpandedAlpha = 1.0f;
        this.fakeSmallBlur = 0.0f;
        this.fakeBigBlur = 0.0f;
        this.fakeExpandedBlur = 0.0f;
        this.updateFakeViewAnimState();
    }

    public final void resetFakeViewAnimState(DynamicIslandContentView dynamicIslandContentView, boolean bl) {
        o.g((Object)((Object)dynamicIslandContentView), (String)"view");
        this.resetFakeViewAnimState();
        if (bl) {
            this.fakeViewToNormalExpanded(dynamicIslandContentView);
        }
    }

    public final void resetPadTranslationX(float f2) {
        if (!this.isBlockUpdatePosition && !this.view.isExpandedShowing()) {
            this.bigIslandTransX = f2;
            this.expandedTransX = f2;
        }
    }

    public final void resetPress(DynamicIslandContentView object) {
        o.g((Object)object, (String)"view");
        Object object2 = this.dynamicIslandAnimController.getDynamicIslandWindowState();
        Object object3 = object.getCurrentIslandData();
        Object var4_4 = null;
        object3 = object3 != null ? object3.getProperties() : null;
        if (((DynamicIslandWindowState)object2).isTempHidden((Integer)object3)) {
            return;
        }
        object3 = object.getCurrentIslandData();
        object3 = object3 != null ? object3.getKey() : null;
        object2 = new StringBuilder();
        ((StringBuilder)object2).append("resetPress: ");
        ((StringBuilder)object2).append((String)object3);
        Log.d((String)"DynamicIslandSwipeDebug", (String)((StringBuilder)object2).toString());
        if (o.c((Object)((Object)this.smallIslandStateHandler.getCurrent()), (Object)object)) {
            FolmeKt.getFolme((FolmeObject)this).to((Object)this.getSmallIslandAnimState(), new AnimConfig[]{new AnimConfig().setSpecial(CONTAINER_CLIP_START_PROGRESS, this.SHOW_EASE, new float[0]).setSpecial(CONTAINER_CLIP_END_PROGRESS, this.SHOW_EASE, new float[0]).setSpecial(CONTAINER_CLIP_TOP_PROGRESS, this.SHOW_EASE, new float[0]).setSpecial(CONTAINER_CLIP_BOTTOM_PROGRESS, this.SHOW_EASE, new float[0]).setSpecial(BIG_ISLAND_SCALE, this.SHOW_EASE, new float[0]).addListeners(new TransitionListener[]{new DynamicIslandAnimListener(this){

                public void onBegin(Object object) {
                }

                public void onCancel(Object object) {
                }

                public void onComplete(Object object) {
                }
            }})});
        } else if (o.c((Object)((Object)this.bigIslandStateHandler.getCurrent()), (Object)object)) {
            object3 = object.getBigIslandView();
            object = var4_4;
            if (object3 != null) {
                object = Float.valueOf(object3.getScaleX());
            }
            if (o.b((Float)object, (float)1.0f)) {
                Log.d((String)this.TAG, (String)"bigIsland scale is already 1f when reset press , return");
                return;
            }
            float f2 = this.getBigIslandStart();
            FolmeKt.getFolme((FolmeObject)this).to((Object)this.getBigIslandAnimState(), new AnimConfig[]{new AnimConfig().setSpecial(CONTAINER_CLIP_START_PROGRESS, this.SHOW_EASE, new float[0]).setSpecial(CONTAINER_CLIP_END_PROGRESS, this.SHOW_EASE, new float[0]).setSpecial(CONTAINER_CLIP_TOP_PROGRESS, this.SHOW_EASE, new float[0]).setSpecial(CONTAINER_CLIP_BOTTOM_PROGRESS, this.SHOW_EASE, new float[0]).setSpecial(BIG_ISLAND_SCALE, this.SHOW_EASE, new float[0]).addListeners(new TransitionListener[]{new DynamicIslandAnimListener(this, f2){
                final float $bigIslandStart;
                final DynamicIslandAnimationDelegate this$0;
                {
                    this.this$0 = dynamicIslandAnimationDelegate;
                    this.$bigIslandStart = f2;
                    super(dynamicIslandAnimationDelegate);
                }

                public void onBegin(Object object) {
                }

                public void onCancel(Object object) {
                }

                public void onComplete(Object object) {
                }

                public void onUpdate(Object object, Collection<UpdateInfo> collection) {
                    super.onUpdate(object, collection);
                    if (CommonUtils.INSTANCE.getIS_TABLET() && this.this$0.getBigIslandStart() != this.$bigIslandStart) {
                        FolmeKt.getFolme((FolmeObject)this.this$0).cancel();
                        FolmeKt.getFolme((FolmeObject)this.this$0).setTo((Object)DynamicIslandAnimationDelegate.access$getBigIslandAnimState(this.this$0));
                    }
                }
            }})});
        } else if (o.c((Object)((Object)this.expandedStateHandler.getCurrent()), (Object)object)) {
            FolmeKt.getFolme((FolmeObject)this).to((Object)this.getExpandedAnimState(), new AnimConfig[]{new AnimConfig().setSpecial(CONTAINER_CLIP_START_PROGRESS, this.SHOW_EASE, new float[0]).setSpecial(CONTAINER_CLIP_END_PROGRESS, this.SHOW_EASE, new float[0]).setSpecial(CONTAINER_CLIP_TOP_PROGRESS, this.SHOW_EASE, new float[0]).setSpecial(CONTAINER_CLIP_BOTTOM_PROGRESS, this.SHOW_EASE, new float[0]).setSpecial(EXPANDED_SCALE_X, this.SHOW_EASE, new float[0]).setSpecial(EXPANDED_SCALE_Y, this.SHOW_EASE, new float[0]).addListeners(new TransitionListener[]{new DynamicIslandAnimListener(this){

                public void onBegin(Object object) {
                }

                public void onCancel(Object object) {
                }

                public void onComplete(Object object) {
                }
            }})});
        }
    }

    public final void resetSwipe(DynamicIslandContentView dynamicIslandContentView) {
        o.g((Object)((Object)dynamicIslandContentView), (String)"view");
        DynamicIslandWindowState dynamicIslandWindowState = this.dynamicIslandAnimController.getDynamicIslandWindowState();
        Object object = dynamicIslandContentView.getCurrentIslandData();
        object = object != null ? object.getProperties() : null;
        if (dynamicIslandWindowState.isTempHidden((Integer)object)) {
            return;
        }
        if (dynamicIslandContentView.getState() instanceof DynamicIslandState.BigIsland) {
            if (this.isMoveUpAnimating) {
                return;
            }
            this.resetToBig(dynamicIslandContentView);
        }
        if (dynamicIslandContentView.getState() instanceof DynamicIslandState.SmallIsland) {
            this.resetToSmall(dynamicIslandContentView);
        }
        if (dynamicIslandContentView.getState() instanceof DynamicIslandState.Hidden) {
            this.resetToHidden(dynamicIslandContentView);
        }
        if (dynamicIslandContentView.getState() instanceof DynamicIslandState.Expanded) {
            this.resetToExpanded(dynamicIslandContentView);
        }
    }

    public final void scheduleUpdate() {
        this.containerScheduleUpdate();
        this.bigIslandScheduleUpdate();
        this.smallIslandScheduleUpdate();
        this.expandedScheduleUpdate();
        this.fakeViewScheduleUpdate();
    }

    public final void setAnimating(boolean bl) {
        if (this.isAnimating == bl) {
            return;
        }
        this.isAnimating = bl;
        DynamicIslandExpandedView dynamicIslandExpandedView = this.view.getExpandedView();
        if (dynamicIslandExpandedView != null) {
            dynamicIslandExpandedView.setTag(R.id.dynamic_island_animating_tag, bl);
        }
    }

    public final void setAppClose(boolean bl) {
        this.appClose = bl;
    }

    public final void setAppClosing(boolean bl) {
        this.isAppClosing = bl;
    }

    public final void setExpandedToTempHiddenAnimating(boolean bl) {
        this.expandedToTempHiddenAnimating = bl;
    }

    public final void setExpandedViewAnimatingProgress(float f2) {
        this.expandedViewAnimatingProgress = f2;
    }

    public void setFolmeImpl(Folme.ObjectFolmeImpl objectFolmeImpl) {
        this.$$delegate_0.setFolmeImpl(objectFolmeImpl);
    }

    public final void setHiddenStateFrom(DynamicIslandState dynamicIslandState) {
        this.hiddenStateFrom = dynamicIslandState;
    }

    public final void setIslandAppAnimRunning(boolean bl) {
        this.islandAppAnimRunning = bl;
    }

    public final void setIslandFreeformAnimRunning(boolean bl) {
        this.islandFreeformAnimRunning = bl;
    }

    public final void setIslandStateChanged(boolean bl) {
        this.islandStateChanged = bl;
    }

    public final void smallIslandChangedAnimation(DynamicIslandContentView dynamicIslandContentView) {
        o.g((Object)((Object)dynamicIslandContentView), (String)"view");
        FolmeKt.getFolme((FolmeObject)this).to((Object)this.getSmallIslandAnimState(), new AnimConfig[]{new AnimConfig().addListeners(new TransitionListener[]{new DynamicIslandAnimListener(this){}})});
        if (!this.getIslandWindowAnimRunning()) {
            this.fakeViewToSmallIsland(dynamicIslandContentView, false);
        } else if (this.islandFreeformAnimRunning) {
            this.updateSmallTx();
        }
    }

    public final void smallIslandChangedNoAnimation(DynamicIslandContentView dynamicIslandContentView) {
        o.g((Object)((Object)dynamicIslandContentView), (String)"view");
        FolmeKt.getFolme((FolmeObject)this).setTo((Object)this.getSmallIslandAnimState(), new AnimConfig[]{new AnimConfig().addListeners(new TransitionListener[]{new DynamicIslandAnimListener(this){}})});
        if (!this.getIslandWindowAnimRunning()) {
            this.fakeViewToSmallIsland(dynamicIslandContentView, false);
        }
    }

    public final void smallIslandScaleAnimation(DynamicIslandContentView dynamicIslandContentView) {
        o.g((Object)((Object)dynamicIslandContentView), (String)"view");
        IStateStyle iStateStyle = FolmeKt.getFolme((FolmeObject)this).setTo((Object)this.getSmallIslandAnimState());
        FloatProperty<DynamicIslandAnimationDelegate> floatProperty = new FloatProperty<DynamicIslandAnimationDelegate>();
        FloatProperty<DynamicIslandAnimationDelegate> floatProperty2 = SMALL_ISLAND_SCALE;
        FloatProperty<DynamicIslandAnimationDelegate> floatProperty3 = floatProperty.add(floatProperty2, 1.1f, new long[0]);
        floatProperty = CONTAINER_CLIP_START_PROGRESS;
        FloatProperty<DynamicIslandAnimationDelegate> floatProperty4 = floatProperty3.add(floatProperty, this.getSmallIslandStart() - (float)dynamicIslandContentView.getSmallIslandViewWidth() * 0.05f, new long[0]);
        floatProperty3 = CONTAINER_CLIP_END_PROGRESS;
        AnimState animState = floatProperty4.add(floatProperty3, this.getSmallIslandEnd() + (float)dynamicIslandContentView.getSmallIslandViewWidth() * 0.05f, new long[0]);
        floatProperty4 = CONTAINER_CLIP_TOP_PROGRESS;
        animState = animState.add(floatProperty4, this.getSmallIslandTop() - (float)dynamicIslandContentView.getIslandViewHeight() * 0.05f, new long[0]);
        FloatProperty<DynamicIslandAnimationDelegate> floatProperty5 = CONTAINER_CLIP_BOTTOM_PROGRESS;
        iStateStyle.to((Object)animState.add(floatProperty5, this.getSmallIslandBottom() + (float)dynamicIslandContentView.getIslandViewHeight() * 0.05f, new long[0]), new AnimConfig[]{new AnimConfig().setSpecial(floatProperty2, FolmeEase.sinInOut((long)200L), 100L, new float[0]).setSpecial(floatProperty, FolmeEase.sinInOut((long)200L), 100L, new float[0]).setSpecial(floatProperty3, FolmeEase.sinInOut((long)200L), 100L, new float[0]).setSpecial(floatProperty4, FolmeEase.sinInOut((long)200L), 100L, new float[0]).setSpecial(floatProperty5, FolmeEase.sinInOut((long)200L), 100L, new float[0]).addListeners(new TransitionListener[]{new TransitionListener(this, dynamicIslandContentView){
            final DynamicIslandContentView $view;
            final DynamicIslandAnimationDelegate this$0;
            {
                this.this$0 = dynamicIslandAnimationDelegate;
                this.$view = dynamicIslandContentView;
            }

            public void onBegin(Object object) {
                super.onBegin(object);
                DynamicIslandAnimationCallback dynamicIslandAnimationCallback = DynamicIslandAnimationDelegate.access$getDynamicIslandAnimController$p(this.this$0).getAnimationCallback$miui_dynamicisland_release();
                DynamicIslandAnimationType dynamicIslandAnimationType = DynamicIslandAnimationType.ALL;
                DynamicIslandAnimationCallbackType dynamicIslandAnimationCallbackType = DynamicIslandAnimationCallbackType.ANIM_START;
                o.e((Object)object, (String)"null cannot be cast to non-null type kotlin.String");
                dynamicIslandAnimationCallback.executeCallback(dynamicIslandAnimationType, dynamicIslandAnimationCallbackType, (String)object);
            }

            public void onCancel(Object object) {
                super.onCancel(object);
                DynamicIslandAnimationCallback dynamicIslandAnimationCallback = DynamicIslandAnimationDelegate.access$getDynamicIslandAnimController$p(this.this$0).getAnimationCallback$miui_dynamicisland_release();
                DynamicIslandAnimationType dynamicIslandAnimationType = DynamicIslandAnimationType.ALL;
                DynamicIslandAnimationCallbackType dynamicIslandAnimationCallbackType = DynamicIslandAnimationCallbackType.ANIM_CANCEL;
                o.e((Object)object, (String)"null cannot be cast to non-null type kotlin.String");
                dynamicIslandAnimationCallback.executeCallback(dynamicIslandAnimationType, dynamicIslandAnimationCallbackType, (String)object);
            }

            public void onComplete(Object object) {
                super.onComplete(object);
                Object object2 = DynamicIslandAnimationDelegate.access$getDynamicIslandAnimController$p(this.this$0).getAnimationCallback$miui_dynamicisland_release();
                DynamicIslandAnimationType dynamicIslandAnimationType = DynamicIslandAnimationType.ALL;
                DynamicIslandAnimationCallbackType dynamicIslandAnimationCallbackType = DynamicIslandAnimationCallbackType.ANIM_FINISH;
                o.e((Object)object, (String)"null cannot be cast to non-null type kotlin.String");
                ((DynamicIslandAnimationCallback)object2).executeCallback(dynamicIslandAnimationType, dynamicIslandAnimationCallbackType, (String)object);
                object = this.$view.getDynamicIslandEventCoordinator();
                object = object != null && (object = ((DynamicIslandEventCoordinator)object).getSmallIslandStateHandler()) != null ? ((SmallIslandStateHandler)object).getCurrent() : null;
                if (o.c((Object)object, (Object)((Object)this.$view))) {
                    object = FolmeKt.getFolme((FolmeObject)this.this$0);
                    dynamicIslandAnimationType = new AnimState();
                    object2 = DynamicIslandAnimationDelegate.Companion;
                    object.to((Object)dynamicIslandAnimationType.add(object2.getSMALL_ISLAND_SCALE(), 1.0f, new long[0]).add(object2.getCONTAINER_CLIP_START_PROGRESS(), this.this$0.getSmallIslandStart(), new long[0]).add(object2.getCONTAINER_CLIP_END_PROGRESS(), this.this$0.getSmallIslandEnd(), new long[0]).add(object2.getCONTAINER_CLIP_TOP_PROGRESS(), this.this$0.getSmallIslandTop(), new long[0]).add(object2.getCONTAINER_CLIP_BOTTOM_PROGRESS(), this.this$0.getSmallIslandBottom(), new long[0]), new AnimConfig[]{new AnimConfig().setSpecial(object2.getSMALL_ISLAND_SCALE(), FolmeEase.sinInOut((long)200L), 100L, new float[0]).setSpecial(object2.getCONTAINER_CLIP_START_PROGRESS(), FolmeEase.sinInOut((long)200L), 100L, new float[0]).setSpecial(object2.getCONTAINER_CLIP_END_PROGRESS(), FolmeEase.sinInOut((long)200L), 100L, new float[0]).setSpecial(object2.getCONTAINER_CLIP_TOP_PROGRESS(), FolmeEase.sinInOut((long)200L), 100L, new float[0]).setSpecial(object2.getCONTAINER_CLIP_BOTTOM_PROGRESS(), FolmeEase.sinInOut((long)200L), 100L, new float[0]).addListeners(new TransitionListener[]{new TransitionListener(this.this$0){
                        final DynamicIslandAnimationDelegate this$0;
                        {
                            this.this$0 = dynamicIslandAnimationDelegate;
                        }

                        public void onComplete(Object object) {
                            super.onComplete(object);
                        }

                        public void onUpdate(Object object, Collection<UpdateInfo> collection) {
                            super.onUpdate(object, collection);
                            this.this$0.scheduleUpdate();
                        }
                    }})});
                }
            }

            public void onUpdate(Object object, Collection<UpdateInfo> collection) {
                super.onUpdate(object, collection);
                this.this$0.scheduleUpdate();
            }
        }})});
    }

    public final void smallIslandScheduleUpdate() {
        FrameLayout frameLayout = this.view.getSmallIslandView();
        if (frameLayout != null) {
            frameLayout.setScaleX(this.smallIslandScale);
        }
        frameLayout = this.view.getSmallIslandView();
        if (frameLayout != null) {
            frameLayout.setScaleY(this.smallIslandScale);
        }
        frameLayout = this.view.getSmallIslandView();
        if (frameLayout != null) {
            frameLayout.setAlpha(this.smallIslandAlpha);
        }
        frameLayout = this.view.getSmallIslandView();
        if (frameLayout != null) {
            frameLayout.setTranslationX(this.smallIslandTransX);
        }
        frameLayout = this.view.getSmallIslandView();
        if (frameLayout != null) {
            frameLayout.setTranslationY(this.smallIslandTransY);
        }
        if (this.supportBlur && (frameLayout = this.view.getSmallIslandView()) != null) {
            this.updateContentBlur((View)frameLayout, this.smallIslandBlur);
        }
    }

    public final void smallIslandToAppExpandedAnimation(DynamicIslandContentView dynamicIslandContentView) {
        o.g((Object)((Object)dynamicIslandContentView), (String)"view");
        this.smallIslandToTempHiddenAnimation(dynamicIslandContentView);
        DynamicIslandEventCoordinator dynamicIslandEventCoordinator = dynamicIslandContentView.getDynamicIslandEventCoordinator();
        if (dynamicIslandEventCoordinator != null) {
            dynamicIslandEventCoordinator.updateView(dynamicIslandContentView);
        }
    }

    public final void smallIslandToBigIslandAnimation(DynamicIslandContentView dynamicIslandContentView, boolean bl) {
        o.g((Object)((Object)dynamicIslandContentView), (String)"view");
        dynamicIslandContentView.updateBigIslandLayout();
        FolmeKt.getFolme((FolmeObject)this).to((Object)this.getBigIslandAnimState(), new AnimConfig[]{new AnimConfig().setSpecial(CONTAINER_CLIP_START_PROGRESS, this.CHANGE_EASE, new float[0]).setSpecial(CONTAINER_CLIP_END_PROGRESS, this.CHANGE_EASE, new float[0]).setSpecial(BIG_ISLAND_AREA_LEFT_TRANS_X, this.CHANGE_EASE, new float[0]).setSpecial(BIG_ISLAND_AREA_RIGHT_TRANS_X, this.CHANGE_EASE, new float[0]).setSpecial(CONTAINER_X, this.CHANGE_EASE, new float[0]).setSpecial(SMALL_ISLAND_TRANS_X, this.CHANGE_EASE, new float[0]).addListeners(new TransitionListener[]{new DynamicIslandAnimListener(this, dynamicIslandContentView){
            final DynamicIslandContentView $view;
            {
                this.$view = dynamicIslandContentView;
                super(dynamicIslandAnimationDelegate);
            }

            public void onBegin(Object object) {
                super.onBegin(object);
                object = this.$view.getBigIslandView();
                if (object != null) {
                    object.setVisibility(0);
                }
                DynamicIslandScenarioUtils.INSTANCE.setDynamicIslandScenarioState(440L, true);
            }

            public void onCancel(Object object) {
                super.onCancel(object);
                object = DynamicIslandScenarioUtils.INSTANCE;
                if (((DynamicIslandScenarioUtils)object).isSmallTracking()) {
                    ((DynamicIslandScenarioUtils)object).setDynamicIslandScenarioState(495L, false);
                    ((DynamicIslandScenarioUtils)object).setSmallTracking(false);
                }
                ((DynamicIslandScenarioUtils)object).setDynamicIslandScenarioState(440L, false);
            }

            public void onComplete(Object object) {
                super.onComplete(object);
                object = DynamicIslandScenarioUtils.INSTANCE;
                if (((DynamicIslandScenarioUtils)object).isSmallTracking()) {
                    ((DynamicIslandScenarioUtils)object).setDynamicIslandScenarioState(495L, false);
                    ((DynamicIslandScenarioUtils)object).setSmallTracking(false);
                }
                ((DynamicIslandScenarioUtils)object).setDynamicIslandScenarioState(440L, false);
            }
        }})});
        this.fakeViewToBigIsland(dynamicIslandContentView, bl);
    }

    public final void smallIslandToDeletedAnimation(DynamicIslandContentView dynamicIslandContentView) {
        o.g((Object)((Object)dynamicIslandContentView), (String)"view");
        EaseManager.EaseStyle easeStyle = this.SHOW_EASE;
        if (this.dynamicIslandAnimController.getDynamicIslandWindowState().isToScreenLockNoAnimation() || !DynamicIslandAnimUtils.INSTANCE.supportShowElementAnim()) {
            easeStyle = this.HIDDEN_EASE;
        }
        IFolme iFolme = FolmeKt.getFolme((FolmeObject)this);
        AnimState animState = this.getCutoutAnimState();
        AnimConfig animConfig2 = new AnimConfig().setSpecial(CONTAINER_X, easeStyle, new float[0]).setSpecial(CONTAINER_CLIP_START_PROGRESS, easeStyle, new float[0]).setSpecial(CONTAINER_CLIP_END_PROGRESS, easeStyle, new float[0]);
        FloatProperty<DynamicIslandAnimationDelegate> floatProperty = CONTAINER_ALPHA;
        EaseManager.EaseStyle easeStyle2 = this.getSupposedContainerAlpha() == 0.0f ? easeStyle : FolmeEase.linear((long)100L);
        long l = this.getSupposedContainerAlpha() == 0.0f ? 100L : 400L;
        iFolme.to((Object)animState, new AnimConfig[]{animConfig2.setSpecial(floatProperty, easeStyle2, l, new float[0]).setSpecial(SMALL_ISLAND_SCALE, easeStyle, new float[0]).setSpecial(SMALL_ISLAND_ALPHA, this.HIDDEN_EASE, new float[0]).setSpecial(SMALL_ISLAND_BLUR, this.HIDDEN_EASE, new float[0]).setSpecial(BIG_ISLAND_SCALE, easeStyle, new float[0]).setSpecial(BIG_ISLAND_AREA_LEFT_TRANS_X, easeStyle, new float[0]).setSpecial(BIG_ISLAND_AREA_RIGHT_TRANS_X, easeStyle, new float[0]).addListeners(new TransitionListener[]{new DynamicIslandAnimListener(this, dynamicIslandContentView){
            final DynamicIslandContentView $view;
            final DynamicIslandAnimationDelegate this$0;
            {
                this.this$0 = dynamicIslandAnimationDelegate;
                this.$view = dynamicIslandContentView;
                super(dynamicIslandAnimationDelegate);
            }

            public void onBegin(Object object, Collection<? extends UpdateInfo> collection) {
                super.onBegin(object, collection);
                DynamicIslandScenarioUtils.INSTANCE.setDynamicIslandScenarioState(439L, true);
            }

            public void onCancel(Object object) {
                super.onCancel(object);
                DynamicIslandScenarioUtils.INSTANCE.setDynamicIslandScenarioState(439L, false);
                DynamicIslandAnimationDelegate.removeViewFromWindow$default(this.this$0, this.$view, false, 2, null);
            }

            public void onComplete(Object object) {
                super.onComplete(object);
                DynamicIslandScenarioUtils.INSTANCE.setDynamicIslandScenarioState(439L, false);
                DynamicIslandAnimationDelegate.removeViewFromWindow$default(this.this$0, this.$view, false, 2, null);
            }
        }})});
        this.fakeViewToDeleted(dynamicIslandContentView);
    }

    public final void smallIslandToDeletedNoAnimation(DynamicIslandContentView dynamicIslandContentView) {
        o.g((Object)((Object)dynamicIslandContentView), (String)"view");
        FolmeKt.getFolme((FolmeObject)this).setTo((Object)this.getCutoutAnimState(), new AnimConfig[]{new AnimConfig().addListeners(new TransitionListener[]{new DynamicIslandAnimListener(this, dynamicIslandContentView){
            final DynamicIslandContentView $view;
            final DynamicIslandAnimationDelegate this$0;
            {
                this.this$0 = dynamicIslandAnimationDelegate;
                this.$view = dynamicIslandContentView;
                super(dynamicIslandAnimationDelegate);
            }

            public void onBegin(Object object) {
                super.onBegin(object);
                this.this$0.removeViewFromWindow(this.$view, true);
            }
        }})});
        this.fakeViewToDeleted(dynamicIslandContentView);
    }

    public final void smallIslandToExpandedAnimation(DynamicIslandContentView dynamicIslandContentView) {
        o.g((Object)((Object)dynamicIslandContentView), (String)"view");
        FolmeKt.getFolme((FolmeObject)this).to((Object)this.getExpandedAnimState(), new AnimConfig[]{new AnimConfig().setSpecial(CONTAINER_CLIP_END_PROGRESS, this.CHANGE_EASE, new float[0]).setSpecial(CONTAINER_CLIP_START_PROGRESS, this.CHANGE_EASE, new float[0]).setSpecial(CONTAINER_X, this.CHANGE_EASE, new float[0]).setSpecial(CONTAINER_CLIP_BOTTOM_PROGRESS, this.CHANGE_EASE, new float[0]).setSpecial(CONTAINER_TRANS_Y, this.CHANGE_EASE, new float[0]).setSpecial(EXPANDED_SCALE_X, this.CHANGE_EASE, new float[0]).setSpecial(EXPANDED_SCALE_Y, this.CHANGE_EASE, new float[0]).setSpecial(EXPANDED_TRANS_Y, this.CHANGE_EASE, new float[0]).setSpecial(EXPANDED_ALPHA, this.SHOW_EASE, 50L, new float[0]).setSpecial(SMALL_ISLAND_TRANS_X, this.CHANGE_EASE, new float[0]).setSpecial(SMALL_ISLAND_TRANS_Y, this.CHANGE_EASE, new float[0]).setSpecial(SMALL_ISLAND_ALPHA, this.HIDDEN_EASE, new float[0]).addListeners(new TransitionListener[]{new DynamicIslandAnimListener(this, dynamicIslandContentView){
            final DynamicIslandContentView $view;
            final DynamicIslandAnimationDelegate this$0;
            {
                this.this$0 = dynamicIslandAnimationDelegate;
                this.$view = dynamicIslandContentView;
                super(dynamicIslandAnimationDelegate);
            }

            public void onBegin(Object object) {
                super.onBegin(object);
                Object object2 = this.$view.getExpandedView();
                if (object2 != null) {
                    object2.setVisibility(0);
                }
                object2 = this.$view.getBigIslandView();
                if (object2 != null) {
                    object2.setVisibility(4);
                }
                object2 = this.$view.getSmallIslandView();
                if (object2 != null) {
                    object2.performAccessibilityAction(128, null);
                }
                DynamicIslandAnimationDelegate.access$getAnimationDelegateHelper$p(this.this$0).requestUpdateHeadsUpLocation(DynamicIslandAnimationType.SMALL_TO_EXPANDED, this.$view);
                DynamicIslandAnimationCallback dynamicIslandAnimationCallback = DynamicIslandAnimationDelegate.access$getDynamicIslandAnimController$p(this.this$0).getAnimationCallback$miui_dynamicisland_release();
                DynamicIslandAnimationType dynamicIslandAnimationType = DynamicIslandAnimationType.TO_EXPANDED;
                object2 = DynamicIslandAnimationCallbackType.ANIM_START;
                o.e((Object)object, (String)"null cannot be cast to non-null type kotlin.String");
                dynamicIslandAnimationCallback.executeCallback(dynamicIslandAnimationType, (DynamicIslandAnimationCallbackType)((Object)object2), (String)object);
                DynamicIslandAnimationDelegate.access$setAnimateExpanding(this.this$0, true);
                DynamicIslandScenarioUtils.INSTANCE.setDynamicIslandScenarioState(474L, true);
            }

            public void onCancel(Object object) {
                super.onCancel(object);
                DynamicIslandAnimationDelegate.access$setAnimateExpanding(this.this$0, false);
                DynamicIslandScenarioUtils.INSTANCE.setDynamicIslandScenarioState(474L, false);
            }

            public void onComplete(Object object) {
                super.onComplete(object);
                DynamicIslandAnimationCallback dynamicIslandAnimationCallback = DynamicIslandAnimationDelegate.access$getDynamicIslandAnimController$p(this.this$0).getAnimationCallback$miui_dynamicisland_release();
                DynamicIslandAnimationType dynamicIslandAnimationType = DynamicIslandAnimationType.TO_EXPANDED;
                DynamicIslandAnimationCallbackType dynamicIslandAnimationCallbackType = DynamicIslandAnimationCallbackType.ANIM_FINISH;
                o.e((Object)object, (String)"null cannot be cast to non-null type kotlin.String");
                dynamicIslandAnimationCallback.executeCallback(dynamicIslandAnimationType, dynamicIslandAnimationCallbackType, (String)object);
                DynamicIslandAnimationDelegate.access$setAnimateExpanding(this.this$0, false);
                object = this.$view.getExpandedView();
                if (object != null) {
                    object.sendAccessibilityEvent(128);
                }
                DynamicIslandScenarioUtils.INSTANCE.setDynamicIslandScenarioState(474L, false);
            }
        }})});
        this.fakeViewToExpanded(dynamicIslandContentView, false);
    }

    public final void smallIslandToHiddenAnimation(DynamicIslandContentView dynamicIslandContentView, boolean bl) {
        o.g((Object)((Object)dynamicIslandContentView), (String)"view");
        this.smallIslandToHiddenAnimation(dynamicIslandContentView, bl, true);
    }

    public final void smallIslandToHiddenNoAnimation(DynamicIslandContentView dynamicIslandContentView) {
        o.g((Object)((Object)dynamicIslandContentView), (String)"view");
        this.smallIslandToHiddenNoAnimation(dynamicIslandContentView, true);
    }

    public final void smallIslandToHiddenNoAnimation(DynamicIslandContentView dynamicIslandContentView, boolean bl) {
        o.g((Object)((Object)dynamicIslandContentView), (String)"view");
        this.hiddenStateFrom = new /* invalid duplicate definition of identical inner class */;
        IFolme iFolme = FolmeKt.getFolme((FolmeObject)this);
        AnimState animState = this.getHiddenAnimState();
        AnimConfig animConfig2 = new AnimConfig().setSpecial(CONTAINER_ALPHA, this.HIDDEN_EASE, new float[0]);
        animConfig2 = animConfig2.setSpecial(SMALL_ISLAND_SCALE, this.HIDDEN_EASE, new float[0]);
        animConfig2 = animConfig2.setSpecial(CONTAINER_CLIP_START_PROGRESS, this.HIDDEN_EASE, new float[0]);
        animConfig2 = animConfig2.setSpecial(CONTAINER_CLIP_END_PROGRESS, this.HIDDEN_EASE, new float[0]);
        animConfig2 = animConfig2.setSpecial(CONTAINER_CLIP_TOP_PROGRESS, this.HIDDEN_EASE, new float[0]);
        animConfig2 = animConfig2.setSpecial(CONTAINER_CLIP_BOTTOM_PROGRESS, this.HIDDEN_EASE, new float[0]);
        animConfig2 = animConfig2.addListeners(new TransitionListener[]{new DynamicIslandAnimListener(this){}});
        iFolme.setTo((Object)animState, new AnimConfig[]{animConfig2});
        if (bl) {
            this.fakeViewToHidden(dynamicIslandContentView, false);
        }
    }

    public final void smallIslandToMiniWindowExpandedAnimation(DynamicIslandContentView dynamicIslandContentView) {
        DynamicIslandEventCoordinator dynamicIslandEventCoordinator;
        o.g((Object)((Object)dynamicIslandContentView), (String)"view");
        this.smallIslandToTempHiddenAnimation(dynamicIslandContentView);
        DynamicIslandContentFakeView dynamicIslandContentFakeView = dynamicIslandContentView.getFakeView();
        if (dynamicIslandContentFakeView != null && (dynamicIslandEventCoordinator = dynamicIslandContentFakeView.getDynamicIslandEventCoordinator()) != null) {
            DynamicIslandContentFakeView dynamicIslandContentFakeView2 = dynamicIslandContentView.getFakeView();
            dynamicIslandContentFakeView = dynamicIslandContentView.getCurrentIslandData();
            dynamicIslandContentFakeView = dynamicIslandContentFakeView != null ? dynamicIslandContentFakeView.getExtras() : null;
            dynamicIslandEventCoordinator.updateFreeformFakeView(dynamicIslandContentFakeView2, dynamicIslandContentView, (Bundle)dynamicIslandContentFakeView);
        }
    }

    public final void smallIslandToTempHiddenAnimation(DynamicIslandContentView dynamicIslandBaseContentView) {
        o.g((Object)((Object)dynamicIslandBaseContentView), (String)"view");
        EaseManager.EaseStyle easeStyle = this.SHOW_EASE;
        if (this.dynamicIslandAnimController.getDynamicIslandWindowState().isToScreenLockNoAnimation() || !DynamicIslandAnimUtils.INSTANCE.supportShowElementAnim()) {
            easeStyle = this.HIDDEN_EASE;
        }
        IFolme iFolme = FolmeKt.getFolme((FolmeObject)this);
        AnimState animState = this.getCutoutAnimState();
        AnimConfig animConfig2 = new AnimConfig().setSpecial(CONTAINER_X, easeStyle, new float[0]).setSpecial(CONTAINER_CLIP_START_PROGRESS, easeStyle, new float[0]).setSpecial(CONTAINER_CLIP_END_PROGRESS, easeStyle, new float[0]);
        FloatProperty<DynamicIslandAnimationDelegate> floatProperty = CONTAINER_ALPHA;
        EaseManager.EaseStyle easeStyle2 = this.getSupposedContainerAlpha() == 0.0f ? easeStyle : FolmeEase.linear((long)100L);
        long l = this.getSupposedContainerAlpha() == 0.0f ? 100L : 400L;
        iFolme.to((Object)animState, new AnimConfig[]{animConfig2.setSpecial(floatProperty, easeStyle2, l, new float[0]).setSpecial(SMALL_ISLAND_SCALE, easeStyle, new float[0]).setSpecial(SMALL_ISLAND_ALPHA, this.HIDDEN_EASE, new float[0]).setSpecial(SMALL_ISLAND_BLUR, this.HIDDEN_EASE, new float[0]).setSpecial(BIG_ISLAND_SCALE, easeStyle, new float[0]).setSpecial(BIG_ISLAND_AREA_LEFT_TRANS_X, easeStyle, new float[0]).setSpecial(BIG_ISLAND_AREA_RIGHT_TRANS_X, easeStyle, new float[0]).addListeners(new TransitionListener[]{new DynamicIslandAnimListener(this, (DynamicIslandContentView)dynamicIslandBaseContentView){
            final DynamicIslandContentView $view;
            final DynamicIslandAnimationDelegate this$0;
            {
                this.this$0 = dynamicIslandAnimationDelegate;
                this.$view = dynamicIslandContentView;
                super(dynamicIslandAnimationDelegate);
            }

            public void onBegin(Object object) {
                super.onBegin(object);
                object = this.$view.getWindowState();
                if (!(object == null || ((DynamicIslandWindowState)object).getKeyguardShowing() || (object = this.$view.getWindowState()) == null || (object = ((DynamicIslandWindowState)object).getScreenPinning()) == null || ((Boolean)object.getValue()).booleanValue() || this.this$0.getIslandWindowAnimRunning())) {
                    DynamicIslandAnimationDelegate.access$setViewVisible(this.this$0, this.$view, 0);
                }
                DynamicIslandScenarioUtils.INSTANCE.setDynamicIslandScenarioState(439L, true);
            }

            public void onCancel(Object object) {
                super.onCancel(object);
                DynamicIslandScenarioUtils.INSTANCE.setDynamicIslandScenarioState(439L, false);
            }

            public void onComplete(Object object) {
                super.onComplete(object);
                DynamicIslandScenarioUtils.INSTANCE.setDynamicIslandScenarioState(439L, false);
            }
        }})});
        if (this.getIslandWindowAnimRunning()) {
            this.fakeViewToHidden((DynamicIslandContentView)dynamicIslandBaseContentView, true);
        } else if ((dynamicIslandBaseContentView = dynamicIslandBaseContentView.getFakeView()) != null) {
            ((DynamicIslandContentFakeView)dynamicIslandBaseContentView).setVisibility(4);
        }
    }

    public final void tempHiddenToBigIslandAnimation(DynamicIslandContentView dynamicIslandContentView, boolean bl) {
        DynamicIslandWindowState dynamicIslandWindowState;
        o.g((Object)((Object)dynamicIslandContentView), (String)"view");
        if (bl) {
            this.tempHiddenToBigIslandNoAnimation(dynamicIslandContentView);
            return;
        }
        this.setViewVisible(dynamicIslandContentView, 0);
        dynamicIslandContentView.updateBigIslandLayout();
        if (CommonUtils.INSTANCE.getIS_TABLET()) {
            dynamicIslandWindowState = new AnimConfig().setSpecial(CONTAINER_CLIP_START_PROGRESS, this.PAD_SHOW_EASE, new float[0]).setSpecial(CONTAINER_CLIP_END_PROGRESS, this.PAD_SHOW_EASE, new float[0]).setSpecial(BIG_ISLAND_SCALE, this.PAD_SHOW_EASE, new float[0]).setSpecial(BIG_ISLAND_ALPHA, this.PAD_SHOW_EASE, new float[0]).setSpecial(BIG_ISLAND_BLUR, this.PAD_SHOW_EASE, new float[0]).setSpecial(BIG_ISLAND_TRANS_X, this.PAD_SHOW_EASE, new float[0]).setSpecial(EXPANDED_TRANS_X, this.PAD_SHOW_EASE, new float[0]).setSpecial(EXPANDED_SCALE_X, this.PAD_SHOW_EASE, new float[0]).setSpecial(EXPANDED_SCALE_Y, this.PAD_SHOW_EASE, new float[0]).setSpecial(EXPANDED_ALPHA, this.PAD_SHOW_EASE, new float[0]);
            o.f((Object)dynamicIslandWindowState, (String)"setSpecial(...)");
        } else {
            AnimConfig animConfig2 = new AnimConfig();
            dynamicIslandWindowState = dynamicIslandContentView.getWindowState();
            long l = dynamicIslandWindowState != null && dynamicIslandWindowState.isNeedDelayUnLockAnimation() ? 200L : 0L;
            dynamicIslandWindowState = animConfig2.setDelay(l).setSpecial(CONTAINER_CLIP_START_PROGRESS, this.APPEAR_EASE, new float[0]).setSpecial(CONTAINER_CLIP_END_PROGRESS, this.APPEAR_EASE, new float[0]).setSpecial(CONTAINER_ALPHA, FolmeEase.linear((long)1L), new float[0]).setSpecial(BIG_ISLAND_SCALE, this.APPEAR_EASE, new float[0]).setSpecial(BIG_ISLAND_ALPHA, this.HIDDEN_EASE, 100L, new float[0]).setSpecial(BIG_ISLAND_AREA_LEFT_TRANS_X, this.APPEAR_EASE, new float[0]).setSpecial(BIG_ISLAND_AREA_RIGHT_TRANS_X, this.APPEAR_EASE, new float[0]);
            o.f((Object)dynamicIslandWindowState, (String)"setSpecial(...)");
        }
        float f2 = this.getBigIslandStart();
        FolmeKt.getFolme((FolmeObject)this).to((Object)this.getBigIslandAnimState(), new AnimConfig[]{dynamicIslandWindowState.addListeners(new TransitionListener[]{new DynamicIslandAnimListener(this, dynamicIslandContentView, f2){
            final float $bigIslandStart;
            final DynamicIslandContentView $view;
            final DynamicIslandAnimationDelegate this$0;
            {
                this.this$0 = dynamicIslandAnimationDelegate;
                this.$view = dynamicIslandContentView;
                this.$bigIslandStart = f2;
                super(dynamicIslandAnimationDelegate);
            }

            public void onBegin(Object object) {
                super.onBegin(object);
                object = this.$view.getBigIslandView();
                if (object != null) {
                    object.setVisibility(0);
                }
                DynamicIslandAnimationDelegate.access$getAnimationDelegateHelper$p(this.this$0).requestUpdateHeadsUpLocation(DynamicIslandAnimationType.TEMP_HIDDEN_TO_BIG, this.$view);
                DynamicIslandAnimationDelegate.access$getAnimationDelegateHelper$p(this.this$0).updateBigIslandContainerBackground(this.$view);
                DynamicIslandScenarioUtils.INSTANCE.setDynamicIslandScenarioState(434L, true);
            }

            public void onCancel(Object object) {
                super.onCancel(object);
                if (CommonUtils.INSTANCE.getIS_TABLET() && this.this$0.getBigIslandStart() != this.$bigIslandStart) {
                    FolmeKt.getFolme((FolmeObject)this.this$0).setTo((Object)DynamicIslandAnimationDelegate.access$getBigIslandAnimState(this.this$0));
                }
                DynamicIslandScenarioUtils.INSTANCE.setDynamicIslandScenarioState(434L, false);
            }

            public void onComplete(Object object) {
                super.onComplete(object);
                DynamicIslandScenarioUtils.INSTANCE.setDynamicIslandScenarioState(434L, false);
            }

            public void onUpdate(Object object, Collection<UpdateInfo> collection) {
                if (CommonUtils.INSTANCE.getIS_TABLET() && this.this$0.getBigIslandStart() != this.$bigIslandStart) {
                    FolmeKt.getFolme((FolmeObject)this.this$0).cancel();
                    FolmeKt.getFolme((FolmeObject)this.this$0).setTo((Object)DynamicIslandAnimationDelegate.access$getBigIslandAnimState(this.this$0));
                }
                super.onUpdate(object, collection);
            }
        }})});
    }

    public final void tempHiddenToSmallIslandAnimation(DynamicIslandContentView dynamicIslandContentView, boolean bl) {
        o.g((Object)((Object)dynamicIslandContentView), (String)"view");
        if (bl) {
            this.tempHiddenToSmallIslandNoAnimation(dynamicIslandContentView);
            return;
        }
        this.setViewVisible(dynamicIslandContentView, 0);
        IFolme iFolme = FolmeKt.getFolme((FolmeObject)this);
        AnimState animState = this.getSmallIslandAnimState();
        AnimConfig animConfig2 = new AnimConfig();
        DynamicIslandWindowState dynamicIslandWindowState = dynamicIslandContentView.getWindowState();
        long l = dynamicIslandWindowState != null && dynamicIslandWindowState.isNeedDelayUnLockAnimation() ? 200L : 0L;
        iFolme.to((Object)animState, new AnimConfig[]{animConfig2.setDelay(l).setSpecial(CONTAINER_X, this.APPEAR_EASE, new float[0]).setSpecial(CONTAINER_CLIP_START_PROGRESS, this.APPEAR_EASE, new float[0]).setSpecial(CONTAINER_CLIP_END_PROGRESS, this.APPEAR_EASE, new float[0]).setSpecial(CONTAINER_ALPHA, FolmeEase.linear((long)1L), new float[0]).setSpecial(SMALL_ISLAND_SCALE, this.APPEAR_EASE, new float[0]).setSpecial(SMALL_ISLAND_ALPHA, this.HIDDEN_EASE, 100L, new float[0]).addListeners(new TransitionListener[]{new DynamicIslandAnimListener(this, dynamicIslandContentView){
            final DynamicIslandContentView $view;
            {
                this.$view = dynamicIslandContentView;
                super(dynamicIslandAnimationDelegate);
            }

            public void onBegin(Object object) {
                super.onBegin(object);
                object = this.$view.getSmallIslandView();
                if (object != null) {
                    object.setVisibility(0);
                }
                DynamicIslandScenarioUtils.INSTANCE.setDynamicIslandScenarioState(438L, true);
            }

            public void onCancel(Object object) {
                super.onCancel(object);
                DynamicIslandScenarioUtils.INSTANCE.setDynamicIslandScenarioState(438L, false);
            }

            public void onComplete(Object object) {
                super.onComplete(object);
                DynamicIslandScenarioUtils.INSTANCE.setDynamicIslandScenarioState(438L, false);
            }
        }})});
    }

    public final void updateBigIslandPosition() {
        this.view.calculateBigIslandY();
        if (this.getBigIslandStart() != 0.0f && !this.isBlockUpdatePosition && !this.view.isExpandedShowing()) {
            this.containerClipStartProgress = this.getBigIslandStart();
            this.containerClipEndProgress = this.getBigIslandEnd();
            this.containerClipTopProgress = this.getBigIslandTop();
            this.containerClipBottomProgress = this.getBigIslandBottom();
        }
    }

    public final void updateBigIslandWidth(DynamicIslandContentView dynamicIslandContentView) {
        o.g((Object)((Object)dynamicIslandContentView), (String)"view");
        DynamicIslandEventCoordinator dynamicIslandEventCoordinator = dynamicIslandContentView.getDynamicIslandEventCoordinator();
        if (dynamicIslandEventCoordinator != null) {
            dynamicIslandEventCoordinator.updateBigIslandWidth(dynamicIslandContentView.getBigIslandViewWidth());
        }
    }

    public final void updateContentBlur(View view, float f2) {
        o.g((Object)view, (String)"view");
        Context context = view.getContext();
        o.f((Object)context, (String)"getContext(...)");
        if (MiBlurCompat.getBackgroundBlurOpened((Context)context)) {
            DynamicIslandAnimationController.Companion.setMiSelfBlurCompat(view, (int)((float)40 * f2));
        } else {
            DynamicIslandAnimationController.Companion.setMiSelfBlurCompat(view, 0);
        }
    }

    public final void updateFakeViewAnimState() {
        DynamicIslandContentFakeView dynamicIslandContentFakeView = this.getFakeView();
        DynamicIslandContentFakeView dynamicIslandContentFakeView2 = null;
        if ((dynamicIslandContentFakeView = dynamicIslandContentFakeView != null ? dynamicIslandContentFakeView.getFakeSmallIsland() : null) != null) {
            dynamicIslandContentFakeView.setAlpha(this.fakeSmallAlpha);
        }
        dynamicIslandContentFakeView = this.getFakeView();
        dynamicIslandContentFakeView = dynamicIslandContentFakeView != null ? dynamicIslandContentFakeView.getFakeBigIsland() : null;
        if (dynamicIslandContentFakeView != null) {
            dynamicIslandContentFakeView.setAlpha(this.fakeBigAlpha);
        }
        dynamicIslandContentFakeView = this.getFakeView();
        dynamicIslandContentFakeView = dynamicIslandContentFakeView != null ? dynamicIslandContentFakeView.getFakeExpandedView() : null;
        if (dynamicIslandContentFakeView != null) {
            dynamicIslandContentFakeView.setAlpha(this.fakeExpandedAlpha);
        }
        if (this.supportBlur) {
            dynamicIslandContentFakeView = this.getFakeView();
            if (dynamicIslandContentFakeView != null && (dynamicIslandContentFakeView = dynamicIslandContentFakeView.getFakeSmallIsland()) != null) {
                this.updateContentBlur((View)dynamicIslandContentFakeView, this.fakeSmallBlur);
            }
            if ((dynamicIslandContentFakeView = this.getFakeView()) != null && (dynamicIslandContentFakeView = dynamicIslandContentFakeView.getFakeBigIsland()) != null) {
                this.updateContentBlur((View)dynamicIslandContentFakeView, this.fakeBigBlur);
            }
            if ((dynamicIslandContentFakeView = this.getFakeView()) != null && (dynamicIslandContentFakeView = dynamicIslandContentFakeView.getFakeExpandedView()) != null) {
                this.updateContentBlur((View)dynamicIslandContentFakeView, this.fakeExpandedBlur);
            }
        }
        if (this.islandFreeformAnimRunning) {
            DynamicIslandContentFakeView dynamicIslandContentFakeView3;
            float f2;
            dynamicIslandContentFakeView = this.view.getMiniBar();
            if (dynamicIslandContentFakeView != null) {
                f2 = dynamicIslandContentFakeView.getTranslationY();
                dynamicIslandContentFakeView = this.getFakeView();
                dynamicIslandContentFakeView = dynamicIslandContentFakeView != null ? dynamicIslandContentFakeView.getMiniBar() : null;
                if (dynamicIslandContentFakeView != null) {
                    dynamicIslandContentFakeView3 = this.getFakeView();
                    if (dynamicIslandContentFakeView3 == null || dynamicIslandContentFakeView3.getTop() != this.view.getTop()) {
                        f2 -= (float)this.view.getIslandViewMarginTop();
                    }
                    dynamicIslandContentFakeView.setTranslationY(f2);
                }
            }
            if ((dynamicIslandContentFakeView = this.view.getMiniBar()) != null) {
                f2 = dynamicIslandContentFakeView.getTranslationX();
                dynamicIslandContentFakeView3 = this.getFakeView();
                dynamicIslandContentFakeView = dynamicIslandContentFakeView2;
                if (dynamicIslandContentFakeView3 != null) {
                    dynamicIslandContentFakeView = dynamicIslandContentFakeView3.getMiniBar();
                }
                if (dynamicIslandContentFakeView != null) {
                    dynamicIslandContentFakeView2 = this.getFakeView();
                    if (dynamicIslandContentFakeView2 == null || dynamicIslandContentFakeView2.getLeft() != this.view.getLeft()) {
                        f2 -= (float)this.view.getExpandedViewMarginHorizontal();
                    }
                    dynamicIslandContentFakeView.setTranslationX(f2);
                }
            }
        }
    }

    public final void updateFakeViewState(int n, int n2, int n3, int n4, int n5, int n6, DynamicIslandContentView dynamicIslandBaseContentView) {
        o.g((Object)((Object)dynamicIslandBaseContentView), (String)"view");
        Object object = new StringBuilder();
        object.append("updateFakeViewState: left:");
        object.append(n3);
        object.append(", top:");
        object.append(n5);
        object.append(", width:");
        object.append(n4);
        object.append(", height:");
        object.append(n6);
        Log.e((String)"DynamicIslandAnimDebug", (String)object.toString());
        object = dynamicIslandBaseContentView.getFakeView();
        if (object != null) {
            object.setTranslationX(n);
        }
        object = dynamicIslandBaseContentView.getFakeView();
        if (object != null) {
            object.setTranslationY(n2);
        }
        object = dynamicIslandBaseContentView.getFakeView();
        if (object != null) {
            object.setOutlineProvider(new ViewOutlineProvider(n3, n5, n4, n6, this){
                final int $height;
                final int $left;
                final int $top;
                final int $width;
                final DynamicIslandAnimationDelegate this$0;
                {
                    this.$left = n;
                    this.$top = n2;
                    this.$width = n3;
                    this.$height = n4;
                    this.this$0 = dynamicIslandAnimationDelegate;
                }

                public void getOutline(View object, Outline outline) {
                    o.g((Object)object, (String)"view");
                    o.g((Object)outline, (String)"outline");
                    float f2 = object.getContext().getResources().getDimension(R.dimen.island_radius);
                    int n = this.$left;
                    int n2 = this.$top;
                    outline.setRoundRect(n, n2, this.$width + n, this.$height + n2, f2);
                    object = DynamicIslandAnimationDelegate.access$getFakeView(this.this$0);
                    if (object != null && (object = ((DynamicIslandBaseContentView)((Object)object)).getRoundedRect()) != null) {
                        n = this.$left;
                        f2 = n;
                        n2 = this.$top;
                        object.set(f2, (float)n2, (float)(this.$width + n), (float)(this.$height + n2));
                    }
                }
            });
        }
        dynamicIslandBaseContentView = dynamicIslandBaseContentView.getFakeView();
        if (dynamicIslandBaseContentView != null) {
            dynamicIslandBaseContentView.setClipToOutline(true);
        }
    }

    public final void updateFakeViewStateForAppAnim(int n, int n2, int n3, int n4, DynamicIslandContentView dynamicIslandBaseContentView, boolean bl, boolean bl2) {
        float f2;
        o.g((Object)((Object)dynamicIslandBaseContentView), (String)"view");
        Object object = dynamicIslandBaseContentView.getFakeView();
        Object var16_9 = null;
        DynamicIslandContentFakeView dynamicIslandContentFakeView = null;
        Object var15_11 = null;
        Object object2 = null;
        object = object != null ? Boolean.valueOf(object.getClosingToExpanded()) : null;
        boolean bl3 = this.expandedViewHadScaled;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("updateFakeViewStateForAppAnim: left:");
        stringBuilder.append(n);
        stringBuilder.append(", top:");
        stringBuilder.append(n2);
        stringBuilder.append(", width:");
        stringBuilder.append(n3);
        stringBuilder.append(", height:");
        stringBuilder.append(n4);
        stringBuilder.append(", isClosingToExpanded: ");
        stringBuilder.append(object);
        stringBuilder.append(", isAppOpen: ");
        stringBuilder.append(bl2);
        stringBuilder.append(", needReset: ");
        stringBuilder.append(bl);
        stringBuilder.append(", expandedViewHadScaled: ");
        stringBuilder.append(bl3);
        Log.d((String)"DynamicIslandAnimDebug", (String)stringBuilder.toString());
        if (bl) {
            this.resetFakeViewAnimState();
        }
        object = DynamicIslandUtils.INSTANCE;
        stringBuilder = dynamicIslandBaseContentView.getContext();
        o.f((Object)stringBuilder, (String)"getContext(...)");
        float f3 = ((DynamicIslandUtils)object).getScreenWidthOld((Context)stringBuilder);
        float f4 = n3;
        if (f4 == 0.0f) {
            stringBuilder = dynamicIslandBaseContentView.getContext();
            o.f((Object)stringBuilder, (String)"getContext(...)");
            f2 = ((DynamicIslandUtils)object).getScreenWidthOld((Context)stringBuilder);
        } else {
            f2 = f4;
        }
        f2 = f3 / f2;
        f3 = n4;
        f3 = f3 / 2.0f + (float)n2 - f3 * f2 / 2.0f;
        f4 = f4 / 2.0f + (float)n - f4 * f2 / 2.0f;
        if (dynamicIslandBaseContentView.getState() instanceof DynamicIslandState.BigIsland) {
            object = this.getFakeView();
            if (object != null && object.getBigIslandViewNeedAnim()) {
                object = this.getFakeView();
                if (object != null && (object = object.getFakeBigIsland()) != null && (object = FolmeKt.getFolme((View)object)) != null && (object = object.state()) != null) {
                    object.to(new AnimState().add(ViewProperty.SCALE_X, f2, new long[0]).add(ViewProperty.SCALE_Y, f2, new long[0]).add(ViewProperty.TRANSLATION_Y, -f3, new long[0]), new AnimConfig[]{new AnimConfig()});
                }
            } else {
                object = dynamicIslandBaseContentView.getFakeView();
                if (object != null && (object = object.getFakeBigIsland()) != null && (object = FolmeKt.getFolme((View)object)) != null && (object = object.state()) != null) {
                    object.cancel();
                }
                if ((object = (object = dynamicIslandBaseContentView.getFakeView()) != null ? object.getFakeBigIsland() : null) != null) {
                    object.setScaleX(f2);
                }
                object = dynamicIslandBaseContentView.getFakeView();
                object = object != null ? object.getFakeBigIsland() : null;
                if (object != null) {
                    object.setScaleY(f2);
                }
                object = dynamicIslandBaseContentView.getFakeView();
                object = object != null ? object.getFakeBigIsland() : null;
                if (object != null) {
                    object.setTranslationY(-f3);
                }
                dynamicIslandContentFakeView = dynamicIslandBaseContentView.getFakeView();
                object = object2;
                if (dynamicIslandContentFakeView != null) {
                    object = dynamicIslandContentFakeView.getFakeBigIsland();
                }
                if (object != null) {
                    dynamicIslandContentFakeView = dynamicIslandBaseContentView.getFakeView();
                    f2 = dynamicIslandContentFakeView != null ? dynamicIslandContentFakeView.getBigIslandTx() - f4 : 0.0f;
                    object.setTranslationX(f2);
                }
            }
        } else if (dynamicIslandBaseContentView.getState() instanceof DynamicIslandState.SmallIsland) {
            object = dynamicIslandBaseContentView.getFakeView();
            object = object != null ? object.getFakeSmallIsland() : null;
            if (object != null) {
                object.setScaleX(f2);
            }
            object = dynamicIslandBaseContentView.getFakeView();
            object = object != null ? object.getFakeSmallIsland() : null;
            if (object != null) {
                object.setScaleY(f2);
            }
            dynamicIslandContentFakeView = dynamicIslandBaseContentView.getFakeView();
            object = var16_9;
            if (dynamicIslandContentFakeView != null) {
                object = dynamicIslandContentFakeView.getFakeSmallIsland();
            }
            if (object != null) {
                object.setTranslationY(Math.abs(f3));
            }
        } else if (!this.expandedViewHadScaled && (dynamicIslandBaseContentView.getState() instanceof DynamicIslandState.Expanded || bl2 && dynamicIslandBaseContentView.getLastState() instanceof DynamicIslandState.Expanded)) {
            object = dynamicIslandBaseContentView.getFakeView();
            object = object != null ? object.getFakeExpandedView() : null;
            if (object != null) {
                object.setScaleX(f2);
            }
            object = dynamicIslandBaseContentView.getFakeView();
            object = object != null ? object.getFakeExpandedView() : null;
            if (object != null) {
                object.setScaleY(f2);
            }
            if (bl2 && dynamicIslandBaseContentView.getLastState() instanceof DynamicIslandState.Expanded) {
                this.expandedViewHadScaled = true;
                object = dynamicIslandBaseContentView.getFakeView();
                object = object != null ? object.getFakeExpandedView() : null;
                if (object != null) {
                    object.setTranslationY(-f3);
                }
            } else {
                this.expandedViewHadScaled = true;
                object2 = new int[]{0, 0};
                object = dynamicIslandBaseContentView.getFakeView();
                if (object != null && (object = object.getFakeExpandedView()) != null) {
                    object.getLocationInSurface(object2);
                }
                if ((object = (object = dynamicIslandBaseContentView.getFakeView()) != null ? object.getFakeExpandedView() : null) != null) {
                    object.setTranslationY(-((float)object2[1]));
                }
            }
            object = dynamicIslandBaseContentView.getFakeView();
            object = object != null ? object.getMiniBar() : null;
            if (object != null) {
                object.setScaleX(f2);
            }
            object2 = (Object)dynamicIslandBaseContentView.getFakeView();
            object = dynamicIslandContentFakeView;
            if (object2 != null) {
                object = object2.getMiniBar();
            }
            if (object != null) {
                object.setScaleY(f2);
            }
        } else if (CommonUtils.INSTANCE.getIS_TABLET() && dynamicIslandBaseContentView.getState() instanceof DynamicIslandState.Hidden) {
            object = dynamicIslandBaseContentView.getFakeView();
            if (object != null && (object = object.getFakeBigIsland()) != null && (object = FolmeKt.getFolme((View)object)) != null && (object = object.state()) != null) {
                object.cancel();
            }
            if ((object = (object = dynamicIslandBaseContentView.getFakeView()) != null ? object.getFakeBigIsland() : null) != null) {
                object.setScaleX(f2);
            }
            object = dynamicIslandBaseContentView.getFakeView();
            object = object != null ? object.getFakeBigIsland() : null;
            if (object != null) {
                object.setScaleY(f2);
            }
            object = dynamicIslandBaseContentView.getFakeView();
            object = object != null ? object.getFakeBigIsland() : null;
            if (object != null) {
                object.setTranslationY(-f3);
            }
            dynamicIslandContentFakeView = dynamicIslandBaseContentView.getFakeView();
            object = var15_11;
            if (dynamicIslandContentFakeView != null) {
                object = dynamicIslandContentFakeView.getFakeBigIsland();
            }
            if (object != null) {
                dynamicIslandContentFakeView = dynamicIslandBaseContentView.getFakeView();
                f2 = dynamicIslandContentFakeView != null ? dynamicIslandContentFakeView.getBigIslandTx() - f4 : 0.0f;
                object.setTranslationX(f2);
            }
        }
        if ((object = dynamicIslandBaseContentView.getFakeView()) != null) {
            object.setTranslationX(0.0f);
        }
        object = dynamicIslandBaseContentView.getFakeView();
        if (object != null) {
            object.setTranslationY(0.0f);
        }
        object = dynamicIslandBaseContentView.getFakeView();
        if (object != null) {
            object.setOutlineProvider(new ViewOutlineProvider(){

                public void getOutline(View view, Outline outline) {
                    o.g((Object)view, (String)"view");
                    o.g((Object)outline, (String)"outline");
                    float f2 = view.getContext().getResources().getDimension(R.dimen.island_radius);
                    DynamicIslandUtils dynamicIslandUtils = DynamicIslandUtils.INSTANCE;
                    Context context = view.getContext();
                    o.f((Object)context, (String)"getContext(...)");
                    int n = dynamicIslandUtils.getScreenWidthOld(context);
                    view = view.getContext();
                    o.f((Object)view, (String)"getContext(...)");
                    outline.setRoundRect(0, 0, n, dynamicIslandUtils.getScreenHeightOld((Context)view), f2);
                }
            });
        }
        dynamicIslandBaseContentView = dynamicIslandBaseContentView.getFakeView();
        if (dynamicIslandBaseContentView != null) {
            dynamicIslandBaseContentView.setClipToOutline(true);
        }
    }

    public final void updateOrientationBigIslandToTempHiddenNoAnimation(DynamicIslandContentView dynamicIslandBaseContentView) {
        o.g((Object)((Object)dynamicIslandBaseContentView), (String)"view");
        FolmeKt.getFolme((FolmeObject)this).setTo((Object)this.getCutoutAnimState(), new AnimConfig[]{new AnimConfig().setSpecial(CONTAINER_CLIP_START_PROGRESS, this.SHOW_EASE, new float[0]).setSpecial(CONTAINER_CLIP_END_PROGRESS, this.SHOW_EASE, new float[0]).setSpecial(BIG_ISLAND_SCALE, this.SHOW_EASE, new float[0]).setSpecial(BIG_ISLAND_ALPHA, this.HIDDEN_EASE, new float[0]).addListeners(new TransitionListener[]{new DynamicIslandAnimListener(this, (DynamicIslandContentView)dynamicIslandBaseContentView){
            final DynamicIslandContentView $view;
            final DynamicIslandAnimationDelegate this$0;
            {
                this.this$0 = dynamicIslandAnimationDelegate;
                this.$view = dynamicIslandContentView;
                super(dynamicIslandAnimationDelegate);
            }

            public void onBegin(Object object) {
                super.onBegin(object);
                object = this.$view.getWindowState();
                if (object != null && !((DynamicIslandWindowState)object).getKeyguardShowing()) {
                    DynamicIslandAnimationDelegate.access$setViewVisible(this.this$0, this.$view, 0);
                }
            }

            public void onComplete(Object object) {
                super.onComplete(object);
            }
        }})});
        dynamicIslandBaseContentView = dynamicIslandBaseContentView.getFakeView();
        if (dynamicIslandBaseContentView != null) {
            ((DynamicIslandContentFakeView)dynamicIslandBaseContentView).setVisibility(8);
        }
    }

    public final void updateOrientationSmallIslandToTempHiddenAnimation(DynamicIslandContentView dynamicIslandContentView) {
        o.g((Object)((Object)dynamicIslandContentView), (String)"view");
        FolmeKt.getFolme((FolmeObject)this).setTo((Object)this.getCutoutAnimState(), new AnimConfig[]{new AnimConfig().setSpecial(CONTAINER_CLIP_START_PROGRESS, this.APPEAR_EASE, new float[0]).setSpecial(CONTAINER_CLIP_END_PROGRESS, this.APPEAR_EASE, new float[0]).setSpecial(BIG_ISLAND_SCALE, this.APPEAR_EASE, new float[0]).setSpecial(BIG_ISLAND_ALPHA, this.HIDDEN_EASE, new float[0]).addListeners(new TransitionListener[]{new DynamicIslandAnimListener(this){}})});
    }
}
