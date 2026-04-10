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
import miui.systemui.dynamicisland.databinding.DynamicIslandModuleIcon1Binding;
import miuix.colorful.texteffect.TimerTextEffectView;

public final class DynamicIslandModuleIconFixedWidthTextBinding
implements ViewBinding {
    @NonNull
    public final FrameLayout fixedContainer;
    @NonNull
    public final TimerTextEffectView fixedWidthText;
    @NonNull
    public final LinearLayout iconFixedWidthTextLayout;
    @NonNull
    public final DynamicIslandModuleIcon1Binding islandContainerModuleIcon;
    @NonNull
    public final View islandTextShade;
    @NonNull
    public final View islandTextShadeEnd;
    @NonNull
    private final LinearLayout rootView;
    @NonNull
    public final TimerTextEffectView unitText;

    private DynamicIslandModuleIconFixedWidthTextBinding(@NonNull LinearLayout linearLayout, @NonNull FrameLayout frameLayout, @NonNull TimerTextEffectView timerTextEffectView, @NonNull LinearLayout linearLayout2, @NonNull DynamicIslandModuleIcon1Binding dynamicIslandModuleIcon1Binding, @NonNull View view, @NonNull View view2, @NonNull TimerTextEffectView timerTextEffectView2) {
        this.rootView = linearLayout;
        this.fixedContainer = frameLayout;
        this.fixedWidthText = timerTextEffectView;
        this.iconFixedWidthTextLayout = linearLayout2;
        this.islandContainerModuleIcon = dynamicIslandModuleIcon1Binding;
        this.islandTextShade = view;
        this.islandTextShadeEnd = view2;
        this.unitText = timerTextEffectView2;
    }

    @NonNull
    public static DynamicIslandModuleIconFixedWidthTextBinding bind(@NonNull View view) {
        TimerTextEffectView timerTextEffectView;
        int n = R.id.fixed_container;
        FrameLayout frameLayout = (FrameLayout)ViewBindings.findChildViewById((View)view, (int)n);
        if (frameLayout != null && (timerTextEffectView = (TimerTextEffectView)ViewBindings.findChildViewById((View)view, (int)(n = R.id.fixed_width_text))) != null) {
            LinearLayout linearLayout = (LinearLayout)view;
            n = R.id.island_container_module_icon;
            View view2 = ViewBindings.findChildViewById((View)view, (int)n);
            if (view2 != null) {
                TimerTextEffectView timerTextEffectView2;
                View view3;
                DynamicIslandModuleIcon1Binding dynamicIslandModuleIcon1Binding = DynamicIslandModuleIcon1Binding.bind(view2);
                n = R.id.island_text_shade;
                view2 = ViewBindings.findChildViewById((View)view, (int)n);
                if (view2 != null && (view3 = ViewBindings.findChildViewById((View)view, (int)(n = R.id.island_text_shade_end))) != null && (timerTextEffectView2 = (TimerTextEffectView)ViewBindings.findChildViewById((View)view, (int)(n = R.id.unit_text))) != null) {
                    return new DynamicIslandModuleIconFixedWidthTextBinding(linearLayout, frameLayout, timerTextEffectView, linearLayout, dynamicIslandModuleIcon1Binding, view2, view3, timerTextEffectView2);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(n)));
    }

    @NonNull
    public static DynamicIslandModuleIconFixedWidthTextBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return DynamicIslandModuleIconFixedWidthTextBinding.inflate(layoutInflater, null, false);
    }

    @NonNull
    public static DynamicIslandModuleIconFixedWidthTextBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean bl) {
        layoutInflater = layoutInflater.inflate(R.layout.dynamic_island_module_icon_fixed_width_text, viewGroup, false);
        if (bl) {
            viewGroup.addView((View)layoutInflater);
        }
        return DynamicIslandModuleIconFixedWidthTextBinding.bind((View)layoutInflater);
    }

    @NonNull
    public LinearLayout getRoot() {
        return this.rootView;
    }
}
