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
import miuix.colorful.texteffect.TimerTextEffectView;

public final class DynamicIslandModuleFixedWidthDigitBinding
implements ViewBinding {
    @NonNull
    public final FrameLayout islandContainerModuleFixWidthDigit;
    @NonNull
    public final LinearLayout islandContainerModuleFixedWidthDigit;
    @NonNull
    public final TimerTextEffectView islandContent;
    @NonNull
    public final TimerTextEffectView islandDigit;
    @NonNull
    public final View islandTextShade;
    @NonNull
    private final FrameLayout rootView;

    private DynamicIslandModuleFixedWidthDigitBinding(@NonNull FrameLayout frameLayout, @NonNull FrameLayout frameLayout2, @NonNull LinearLayout linearLayout, @NonNull TimerTextEffectView timerTextEffectView, @NonNull TimerTextEffectView timerTextEffectView2, @NonNull View view) {
        this.rootView = frameLayout;
        this.islandContainerModuleFixWidthDigit = frameLayout2;
        this.islandContainerModuleFixedWidthDigit = linearLayout;
        this.islandContent = timerTextEffectView;
        this.islandDigit = timerTextEffectView2;
        this.islandTextShade = view;
    }

    @NonNull
    public static DynamicIslandModuleFixedWidthDigitBinding bind(@NonNull View view) {
        View view2;
        TimerTextEffectView timerTextEffectView;
        TimerTextEffectView timerTextEffectView2;
        FrameLayout frameLayout = (FrameLayout)view;
        int n = R.id.island_container_module_fixed_width_digit;
        LinearLayout linearLayout = (LinearLayout)ViewBindings.findChildViewById((View)view, (int)n);
        if (linearLayout != null && (timerTextEffectView2 = (TimerTextEffectView)ViewBindings.findChildViewById((View)view, (int)(n = R.id.island_content))) != null && (timerTextEffectView = (TimerTextEffectView)ViewBindings.findChildViewById((View)view, (int)(n = R.id.island_digit))) != null && (view2 = ViewBindings.findChildViewById((View)view, (int)(n = R.id.island_text_shade))) != null) {
            return new DynamicIslandModuleFixedWidthDigitBinding(frameLayout, frameLayout, linearLayout, timerTextEffectView2, timerTextEffectView, view2);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(n)));
    }

    @NonNull
    public static DynamicIslandModuleFixedWidthDigitBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return DynamicIslandModuleFixedWidthDigitBinding.inflate(layoutInflater, null, false);
    }

    @NonNull
    public static DynamicIslandModuleFixedWidthDigitBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean bl) {
        layoutInflater = layoutInflater.inflate(R.layout.dynamic_island_module_fixed_width_digit, viewGroup, false);
        if (bl) {
            viewGroup.addView((View)layoutInflater);
        }
        return DynamicIslandModuleFixedWidthDigitBinding.bind((View)layoutInflater);
    }

    @NonNull
    public FrameLayout getRoot() {
        return this.rootView;
    }
}
