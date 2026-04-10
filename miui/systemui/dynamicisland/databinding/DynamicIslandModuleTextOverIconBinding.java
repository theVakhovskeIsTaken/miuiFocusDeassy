/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.ViewGroup
 *  android.widget.FrameLayout
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
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import miui.systemui.dynamicisland.R;
import miui.systemui.dynamicisland.databinding.DynamicIslandModuleIcon1Binding;
import miuix.colorful.texteffect.TimerTextEffectView;

public final class DynamicIslandModuleTextOverIconBinding
implements ViewBinding {
    @NonNull
    public final DynamicIslandModuleIcon1Binding islandContainerModuleIcon;
    @NonNull
    public final FrameLayout islandContainerModuleTextOverIcon;
    @NonNull
    public final TimerTextEffectView islandTitle;
    @NonNull
    private final FrameLayout rootView;

    private DynamicIslandModuleTextOverIconBinding(@NonNull FrameLayout frameLayout, @NonNull DynamicIslandModuleIcon1Binding dynamicIslandModuleIcon1Binding, @NonNull FrameLayout frameLayout2, @NonNull TimerTextEffectView timerTextEffectView) {
        this.rootView = frameLayout;
        this.islandContainerModuleIcon = dynamicIslandModuleIcon1Binding;
        this.islandContainerModuleTextOverIcon = frameLayout2;
        this.islandTitle = timerTextEffectView;
    }

    @NonNull
    public static DynamicIslandModuleTextOverIconBinding bind(@NonNull View view) {
        int n = R.id.island_container_module_icon;
        View view2 = ViewBindings.findChildViewById((View)view, (int)n);
        if (view2 != null) {
            DynamicIslandModuleIcon1Binding dynamicIslandModuleIcon1Binding = DynamicIslandModuleIcon1Binding.bind(view2);
            view2 = (FrameLayout)view;
            n = R.id.island_title;
            TimerTextEffectView timerTextEffectView = (TimerTextEffectView)ViewBindings.findChildViewById((View)view, (int)n);
            if (timerTextEffectView != null) {
                return new DynamicIslandModuleTextOverIconBinding((FrameLayout)view2, dynamicIslandModuleIcon1Binding, (FrameLayout)view2, timerTextEffectView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(n)));
    }

    @NonNull
    public static DynamicIslandModuleTextOverIconBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return DynamicIslandModuleTextOverIconBinding.inflate(layoutInflater, null, false);
    }

    @NonNull
    public static DynamicIslandModuleTextOverIconBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean bl) {
        layoutInflater = layoutInflater.inflate(R.layout.dynamic_island_module_text_over_icon, viewGroup, false);
        if (bl) {
            viewGroup.addView((View)layoutInflater);
        }
        return DynamicIslandModuleTextOverIconBinding.bind((View)layoutInflater);
    }

    @NonNull
    public FrameLayout getRoot() {
        return this.rootView;
    }
}
