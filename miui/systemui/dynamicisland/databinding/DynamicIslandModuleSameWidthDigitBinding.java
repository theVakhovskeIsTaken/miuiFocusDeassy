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
 *  miui.systemui.notification.HyperChronometerPlugin
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
import miui.systemui.notification.HyperChronometerPlugin;
import miuix.colorful.texteffect.TimerTextEffectView;

public final class DynamicIslandModuleSameWidthDigitBinding
implements ViewBinding {
    @NonNull
    public final HyperChronometerPlugin islandChronometer;
    @NonNull
    public final LinearLayout islandContainerModuleSameWidthDigit;
    @NonNull
    public final FrameLayout islandContainerModuleText;
    @NonNull
    public final TimerTextEffectView islandContent;
    @NonNull
    public final View islandTextShade;
    @NonNull
    public final TimerTextEffectView islandTitle;
    @NonNull
    private final FrameLayout rootView;

    private DynamicIslandModuleSameWidthDigitBinding(@NonNull FrameLayout frameLayout, @NonNull HyperChronometerPlugin hyperChronometerPlugin, @NonNull LinearLayout linearLayout, @NonNull FrameLayout frameLayout2, @NonNull TimerTextEffectView timerTextEffectView, @NonNull View view, @NonNull TimerTextEffectView timerTextEffectView2) {
        this.rootView = frameLayout;
        this.islandChronometer = hyperChronometerPlugin;
        this.islandContainerModuleSameWidthDigit = linearLayout;
        this.islandContainerModuleText = frameLayout2;
        this.islandContent = timerTextEffectView;
        this.islandTextShade = view;
        this.islandTitle = timerTextEffectView2;
    }

    @NonNull
    public static DynamicIslandModuleSameWidthDigitBinding bind(@NonNull View view) {
        LinearLayout linearLayout;
        int n = R.id.island_chronometer;
        HyperChronometerPlugin hyperChronometerPlugin = (HyperChronometerPlugin)ViewBindings.findChildViewById((View)view, (int)n);
        if (hyperChronometerPlugin != null && (linearLayout = (LinearLayout)ViewBindings.findChildViewById((View)view, (int)(n = R.id.island_container_module_same_width_digit))) != null) {
            TimerTextEffectView timerTextEffectView;
            View view2;
            FrameLayout frameLayout = (FrameLayout)view;
            n = R.id.island_content;
            TimerTextEffectView timerTextEffectView2 = (TimerTextEffectView)ViewBindings.findChildViewById((View)view, (int)n);
            if (timerTextEffectView2 != null && (view2 = ViewBindings.findChildViewById((View)view, (int)(n = R.id.island_text_shade))) != null && (timerTextEffectView = (TimerTextEffectView)ViewBindings.findChildViewById((View)view, (int)(n = R.id.island_title))) != null) {
                return new DynamicIslandModuleSameWidthDigitBinding(frameLayout, hyperChronometerPlugin, linearLayout, frameLayout, timerTextEffectView2, view2, timerTextEffectView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(n)));
    }

    @NonNull
    public static DynamicIslandModuleSameWidthDigitBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return DynamicIslandModuleSameWidthDigitBinding.inflate(layoutInflater, null, false);
    }

    @NonNull
    public static DynamicIslandModuleSameWidthDigitBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean bl) {
        layoutInflater = layoutInflater.inflate(R.layout.dynamic_island_module_same_width_digit, viewGroup, false);
        if (bl) {
            viewGroup.addView((View)layoutInflater);
        }
        return DynamicIslandModuleSameWidthDigitBinding.bind((View)layoutInflater);
    }

    @NonNull
    public FrameLayout getRoot() {
        return this.rootView;
    }
}
