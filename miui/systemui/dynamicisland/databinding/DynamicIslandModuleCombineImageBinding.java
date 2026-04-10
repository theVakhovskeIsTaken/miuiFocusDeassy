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
 *  miui.systemui.widget.CircularProgressBar
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
import miui.systemui.widget.CircularProgressBar;

public final class DynamicIslandModuleCombineImageBinding
implements ViewBinding {
    @NonNull
    public final FrameLayout islandContainerModuleImageText1;
    @NonNull
    public final DynamicIslandModuleIcon1Binding islandIcon1;
    @NonNull
    public final DynamicIslandModuleIcon1Binding islandIcon2;
    @NonNull
    public final CircularProgressBar islandProgress;
    @NonNull
    private final FrameLayout rootView;

    private DynamicIslandModuleCombineImageBinding(@NonNull FrameLayout frameLayout, @NonNull FrameLayout frameLayout2, @NonNull DynamicIslandModuleIcon1Binding dynamicIslandModuleIcon1Binding, @NonNull DynamicIslandModuleIcon1Binding dynamicIslandModuleIcon1Binding2, @NonNull CircularProgressBar circularProgressBar) {
        this.rootView = frameLayout;
        this.islandContainerModuleImageText1 = frameLayout2;
        this.islandIcon1 = dynamicIslandModuleIcon1Binding;
        this.islandIcon2 = dynamicIslandModuleIcon1Binding2;
        this.islandProgress = circularProgressBar;
    }

    @NonNull
    public static DynamicIslandModuleCombineImageBinding bind(@NonNull View view) {
        FrameLayout frameLayout = (FrameLayout)view;
        int n = R.id.island_icon_1;
        Object object = ViewBindings.findChildViewById((View)view, (int)n);
        if (object != null) {
            object = DynamicIslandModuleIcon1Binding.bind(object);
            n = R.id.island_icon_2;
            View view2 = ViewBindings.findChildViewById((View)view, (int)n);
            if (view2 != null) {
                DynamicIslandModuleIcon1Binding dynamicIslandModuleIcon1Binding = DynamicIslandModuleIcon1Binding.bind(view2);
                n = R.id.island_progress;
                view2 = (CircularProgressBar)ViewBindings.findChildViewById((View)view, (int)n);
                if (view2 != null) {
                    return new DynamicIslandModuleCombineImageBinding(frameLayout, frameLayout, (DynamicIslandModuleIcon1Binding)object, dynamicIslandModuleIcon1Binding, (CircularProgressBar)view2);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(n)));
    }

    @NonNull
    public static DynamicIslandModuleCombineImageBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return DynamicIslandModuleCombineImageBinding.inflate(layoutInflater, null, false);
    }

    @NonNull
    public static DynamicIslandModuleCombineImageBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean bl) {
        layoutInflater = layoutInflater.inflate(R.layout.dynamic_island_module_combine_image, viewGroup, false);
        if (bl) {
            viewGroup.addView((View)layoutInflater);
        }
        return DynamicIslandModuleCombineImageBinding.bind((View)layoutInflater);
    }

    @NonNull
    public FrameLayout getRoot() {
        return this.rootView;
    }
}
