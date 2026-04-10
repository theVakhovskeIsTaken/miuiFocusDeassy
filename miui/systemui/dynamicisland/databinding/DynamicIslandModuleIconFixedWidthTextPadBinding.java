/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.ViewGroup
 *  android.widget.FrameLayout
 *  android.widget.LinearLayout
 *  androidx.annotation.NonNull
 *  androidx.annotation.Nullable
 *  androidx.viewbinding.ViewBinding
 *  androidx.viewbinding.ViewBindings
 *  miuix.colorful.texteffect.TimerTextEffectView
 */
package miui.systemui.dynamicisland.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import miui.systemui.dynamicisland.R;
import miui.systemui.dynamicisland.databinding.DynamicIslandModuleIcon1PadBinding;
import miuix.colorful.texteffect.TimerTextEffectView;

public final class DynamicIslandModuleIconFixedWidthTextPadBinding
implements ViewBinding {
    @NonNull
    public final FrameLayout fixedContainer;
    @NonNull
    public final TimerTextEffectView fixedWidthText;
    @NonNull
    public final LinearLayout iconFixedWidthTextLayout;
    @NonNull
    public final DynamicIslandModuleIcon1PadBinding islandContainerModuleIcon;
    @NonNull
    public final View islandTextShade;
    @NonNull
    public final View islandTextShadeEnd;
    @NonNull
    private final LinearLayout rootView;
    @NonNull
    public final TimerTextEffectView unitText;

    private DynamicIslandModuleIconFixedWidthTextPadBinding(@NonNull LinearLayout linearLayout, @NonNull FrameLayout frameLayout, @NonNull TimerTextEffectView timerTextEffectView, @NonNull LinearLayout linearLayout2, @NonNull DynamicIslandModuleIcon1PadBinding dynamicIslandModuleIcon1PadBinding, @NonNull View view, @NonNull View view2, @NonNull TimerTextEffectView timerTextEffectView2) {
        this.rootView = linearLayout;
        this.fixedContainer = frameLayout;
        this.fixedWidthText = timerTextEffectView;
        this.iconFixedWidthTextLayout = linearLayout2;
        this.islandContainerModuleIcon = dynamicIslandModuleIcon1PadBinding;
        this.islandTextShade = view;
        this.islandTextShadeEnd = view2;
        this.unitText = timerTextEffectView2;
    }

    @NonNull
    public static DynamicIslandModuleIconFixedWidthTextPadBinding bind(@NonNull View view) {
        TimerTextEffectView timerTextEffectView;
        int n = R.id.fixed_container;
        FrameLayout frameLayout = (FrameLayout)ViewBindings.findChildViewById((View)view, (int)n);
        if (frameLayout != null && (timerTextEffectView = (TimerTextEffectView)ViewBindings.findChildViewById((View)view, (int)(n = R.id.fixed_width_text))) != null) {
            LinearLayout linearLayout = (LinearLayout)view;
            n = R.id.island_container_module_icon;
            View view2 = ViewBindings.findChildViewById((View)view, (int)n);
            if (view2 != null) {
                View view3;
                DynamicIslandModuleIcon1PadBinding dynamicIslandModuleIcon1PadBinding = DynamicIslandModuleIcon1PadBinding.bind(view2);
                n = R.id.island_text_shade;
                View view4 = ViewBindings.findChildViewById((View)view, (int)n);
                if (view4 != null && (view3 = ViewBindings.findChildViewById((View)view, (int)(n = R.id.island_text_shade_end))) != null && (view2 = (TimerTextEffectView)ViewBindings.findChildViewById((View)view, (int)(n = R.id.unit_text))) != null) {
                    return new DynamicIslandModuleIconFixedWidthTextPadBinding(linearLayout, frameLayout, timerTextEffectView, linearLayout, dynamicIslandModuleIcon1PadBinding, view4, view3, (TimerTextEffectView)view2);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(n)));
    }

    @NonNull
    public static DynamicIslandModuleIconFixedWidthTextPadBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return DynamicIslandModuleIconFixedWidthTextPadBinding.inflate(layoutInflater, null, false);
    }

    @NonNull
    public static DynamicIslandModuleIconFixedWidthTextPadBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean bl) {
        layoutInflater = layoutInflater.inflate(R.layout.dynamic_island_module_icon_fixed_width_text_pad, viewGroup, false);
        if (bl) {
            viewGroup.addView((View)layoutInflater);
        }
        return DynamicIslandModuleIconFixedWidthTextPadBinding.bind((View)layoutInflater);
    }

    @NonNull
    public LinearLayout getRoot() {
        return this.rootView;
    }
}
