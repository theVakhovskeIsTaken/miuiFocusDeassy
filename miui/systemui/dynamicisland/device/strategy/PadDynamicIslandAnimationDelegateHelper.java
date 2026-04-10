/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  G0.s
 *  H0.I
 *  android.content.Context
 *  android.util.Log
 *  android.view.DisplayCutout
 *  android.view.View
 *  com.android.systemui.plugins.miui.dynamicisland.DynamicIslandData
 *  kotlin.jvm.internal.o
 *  miui.systemui.util.CommonUtils
 *  miui.systemui.util.DeviceUtils
 *  miui.systemui.util.MiBlurCompat
 *  miui.systemui.util.SystemBarUtilsCompat
 */
package miui.systemui.dynamicisland.device.strategy;

import G0.s;
import H0.I;
import android.content.Context;
import android.util.Log;
import android.view.DisplayCutout;
import android.view.View;
import com.android.systemui.plugins.miui.dynamicisland.DynamicIslandData;
import kotlin.jvm.internal.o;
import miui.systemui.dynamicisland.DynamicIslandUtils;
import miui.systemui.dynamicisland.R;
import miui.systemui.dynamicisland.anim.DynamicIslandAnimationController;
import miui.systemui.dynamicisland.anim.DynamicIslandAnimationType;
import miui.systemui.dynamicisland.device.strategy.DynamicIslandAnimationDelegateHelper;
import miui.systemui.dynamicisland.event.handler.BigIslandStateHandler;
import miui.systemui.dynamicisland.event.handler.ExpandedStateHandler;
import miui.systemui.dynamicisland.event.handler.SmallIslandStateHandler;
import miui.systemui.dynamicisland.window.DynamicIslandWindowView;
import miui.systemui.dynamicisland.window.content.DynamicIslandBaseContentView;
import miui.systemui.dynamicisland.window.content.DynamicIslandContentView;
import miui.systemui.util.CommonUtils;
import miui.systemui.util.DeviceUtils;
import miui.systemui.util.MiBlurCompat;
import miui.systemui.util.SystemBarUtilsCompat;

public final class PadDynamicIslandAnimationDelegateHelper
extends DynamicIslandAnimationDelegateHelper {
    public static final Companion Companion = new Object(null){
        {
            this();
        }
    };
    private static final String TAG = "PadDynamicIslandAnimationDelegateHelper";

    public PadDynamicIslandAnimationDelegateHelper(DynamicIslandBaseContentView dynamicIslandBaseContentView, DynamicIslandAnimationController dynamicIslandAnimationController, SmallIslandStateHandler smallIslandStateHandler, BigIslandStateHandler bigIslandStateHandler, ExpandedStateHandler expandedStateHandler, DynamicIslandWindowView dynamicIslandWindowView) {
        o.g((Object)((Object)dynamicIslandBaseContentView), (String)"view");
        o.g((Object)dynamicIslandAnimationController, (String)"dynamicIslandAnimController");
        o.g((Object)smallIslandStateHandler, (String)"smallIslandStateHandler");
        o.g((Object)bigIslandStateHandler, (String)"bigIslandStateHandler");
        o.g((Object)expandedStateHandler, (String)"expandedStateHandler");
        o.g((Object)((Object)dynamicIslandWindowView), (String)"windowView");
        super(dynamicIslandBaseContentView, dynamicIslandAnimationController, smallIslandStateHandler, bigIslandStateHandler, expandedStateHandler, dynamicIslandWindowView);
    }

    private final void decideHeadsUpLocation(DynamicIslandContentView dynamicIslandContentView) {
        DynamicIslandContentView dynamicIslandContentView2 = this.getExpandedStateHandler().getCurrent();
        if (dynamicIslandContentView2 != null) {
            this.updateHeadsUpBelowExpanded(dynamicIslandContentView2);
            dynamicIslandContentView2 = s.a;
        } else {
            dynamicIslandContentView2 = this.getBigIslandStateHandler().getCurrentTempShow();
            if (dynamicIslandContentView2 != null) {
                this.updateHeadsUpBelowDeviceNotification(dynamicIslandContentView2);
                dynamicIslandContentView2 = s.a;
            } else {
                dynamicIslandContentView2 = null;
            }
        }
        if (dynamicIslandContentView2 == null) {
            this.resetHeadsUpLocation(dynamicIslandContentView);
        }
    }

    /*
     * Enabled aggressive block sorting
     */
    private final void resetHeadsUpLocation(DynamicIslandContentView object) {
        Context context = object.getContext();
        DisplayCutout displayCutout = context.getDisplay().getCutout();
        int n = displayCutout != null ? displayCutout.getSafeInsetTop() : 0;
        if (context.getDisplay().getRotation() != 1 || !((DynamicIslandBaseContentView)((Object)object)).hasLargeNotchLikePhone()) {
            object = CommonUtils.INSTANCE;
            o.d((Object)context);
            n = !object.getHorizontal(context) && (object = SystemBarUtilsCompat.INSTANCE.getStatusBarHeightCompat(context)) != null ? (Integer)object : 0;
        }
        this.updateHeadsUpLocation(false, n, 0);
    }

    private final void updateHeadsUpBelowDeviceNotification(DynamicIslandContentView dynamicIslandContentView) {
        this.updateHeadsUpLocation(false, dynamicIslandContentView.getIslandViewMarginTop(), dynamicIslandContentView.getIslandViewHeight());
    }

    private final void updateHeadsUpBelowExpanded(DynamicIslandContentView dynamicIslandContentView) {
        this.updateHeadsUpLocation(true, dynamicIslandContentView.getExpandedViewY(), dynamicIslandContentView.getExpandedViewHeight());
    }

    @Override
    public void requestUpdateHeadsUpLocation(DynamicIslandAnimationType dynamicIslandAnimationType, DynamicIslandContentView dynamicIslandContentView) {
        o.g((Object)((Object)dynamicIslandAnimationType), (String)"type");
        o.g((Object)((Object)dynamicIslandContentView), (String)"view");
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("type:");
        stringBuilder.append((Object)dynamicIslandAnimationType);
        Log.d((String)TAG, (String)stringBuilder.toString());
        if (I.d((Object[])new DynamicIslandAnimationType[]{DynamicIslandAnimationType.EXPANDED_CHANGED, DynamicIslandAnimationType.INIT_TO_BIG, DynamicIslandAnimationType.INIT_TO_EXPANDED, DynamicIslandAnimationType.SMALL_TO_EXPANDED, DynamicIslandAnimationType.BIG_TO_EXPANDED, DynamicIslandAnimationType.EXPANDED_TO_BIG, DynamicIslandAnimationType.EXPANDED_TO_SMALL, DynamicIslandAnimationType.EXPANDED_TO_TEMP_HIDDEN, DynamicIslandAnimationType.EXPANDED_TO_HIDDEN, DynamicIslandAnimationType.EXPANDED_TO_DELETED, DynamicIslandAnimationType.EXPANDED_TO_MINI_WINDOW, DynamicIslandAnimationType.BIG_TO_DELETED}).contains((Object)dynamicIslandAnimationType)) {
            this.decideHeadsUpLocation(dynamicIslandContentView);
        }
    }

    @Override
    public void updateBigIslandContainerBackground(DynamicIslandBaseContentView object) {
        o.g((Object)object, (String)"view");
        DynamicIslandData dynamicIslandData = object.getCurrentIslandData();
        if (dynamicIslandData != null && DynamicIslandUtils.INSTANCE.isDynamicIslandPadNoPropOnce(dynamicIslandData)) {
            int n = (int)((float)50 * object.getContext().getResources().getDisplayMetrics().density);
            dynamicIslandData = object instanceof DynamicIslandContentView ? object.getContainer() : object.getFakeContainer();
            if (dynamicIslandData != null) {
                if (!DeviceUtils.isLowLevel() && !DeviceUtils.isMidLowLevel()) {
                    Context context = dynamicIslandData.getContext();
                    o.f((Object)context, (String)"getContext(...)");
                    if (MiBlurCompat.getBackgroundBlurOpened((Context)context) && object.getParent() != null) {
                        Log.d((String)TAG, (String)"updateBigIslandContainerBackground:PAD - \u9ad8\u7ea7\u6750\u8d28\u6a21\u5f0f");
                        CommonUtils.INSTANCE.clearMiBlurBlendEffect((View)dynamicIslandData);
                        MiBlurCompat.setMiBackgroundBlurModeCompat((View)dynamicIslandData, (int)1);
                        MiBlurCompat.setMiBackgroundBlurRadiusCompat((View)dynamicIslandData, (int)n);
                        MiBlurCompat.setMiViewBlurModeCompat((View)dynamicIslandData, (int)1);
                        object = dynamicIslandData.getResources().getIntArray(R.array.big_island_background_blend_colors);
                        o.f((Object)object, (String)"getIntArray(...)");
                        MiBlurCompat.setMiBackgroundBlendColors$default((View)dynamicIslandData, (int[])object, (float)0.0f, (int)2, null);
                        dynamicIslandData.setBackground(null);
                    } else {
                        Log.d((String)TAG, (String)"updateBigIslandContainerBackground:PAD - \u975e\u9ad8\u7ea7\u6750\u8d28");
                        CommonUtils.INSTANCE.clearMiBlurBlendEffect((View)dynamicIslandData);
                        MiBlurCompat.setMiBackgroundBlurModeCompat((View)dynamicIslandData, (int)1);
                        MiBlurCompat.setMiBackgroundBlurRadiusCompat((View)dynamicIslandData, (int)n);
                    }
                } else {
                    Log.d((String)TAG, (String)"updateBigIslandContainerBackground:PAD - \u7eaf\u8272\u6a21\u5f0f");
                    CommonUtils.INSTANCE.clearMiBlurBlendEffect((View)dynamicIslandData);
                    MiBlurCompat.setMiBackgroundBlurModeCompat((View)dynamicIslandData, (int)0);
                }
            }
        }
    }
}
