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
import miui.systemui.dynamicisland.databinding.DynamicIslandModuleRightTextBinding;

public final class DynamicIslandModuleImageText3Binding
implements ViewBinding {
    @NonNull
    public final DynamicIslandModuleIcon1Binding islandContainerModuleIcon;
    @NonNull
    public final FrameLayout islandContainerModuleImageText3;
    @NonNull
    public final DynamicIslandModuleRightTextBinding islandContainerModuleText;
    @NonNull
    private final FrameLayout rootView;

    private DynamicIslandModuleImageText3Binding(@NonNull FrameLayout frameLayout, @NonNull DynamicIslandModuleIcon1Binding dynamicIslandModuleIcon1Binding, @NonNull FrameLayout frameLayout2, @NonNull DynamicIslandModuleRightTextBinding dynamicIslandModuleRightTextBinding) {
        this.rootView = frameLayout;
        this.islandContainerModuleIcon = dynamicIslandModuleIcon1Binding;
        this.islandContainerModuleImageText3 = frameLayout2;
        this.islandContainerModuleText = dynamicIslandModuleRightTextBinding;
    }

    @NonNull
    public static DynamicIslandModuleImageText3Binding bind(@NonNull View view) {
        int n = R.id.island_container_module_icon;
        Object object = ViewBindings.findChildViewById((View)view, (int)n);
        if (object != null) {
            object = DynamicIslandModuleIcon1Binding.bind(object);
            FrameLayout frameLayout = (FrameLayout)view;
            n = R.id.island_container_module_text;
            View view2 = ViewBindings.findChildViewById((View)view, (int)n);
            if (view2 != null) {
                return new DynamicIslandModuleImageText3Binding(frameLayout, (DynamicIslandModuleIcon1Binding)object, frameLayout, DynamicIslandModuleRightTextBinding.bind(view2));
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(n)));
    }

    @NonNull
    public static DynamicIslandModuleImageText3Binding inflate(@NonNull LayoutInflater layoutInflater) {
        return DynamicIslandModuleImageText3Binding.inflate(layoutInflater, null, false);
    }

    @NonNull
    public static DynamicIslandModuleImageText3Binding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean bl) {
        layoutInflater = layoutInflater.inflate(R.layout.dynamic_island_module_image_text_3, viewGroup, false);
        if (bl) {
            viewGroup.addView((View)layoutInflater);
        }
        return DynamicIslandModuleImageText3Binding.bind((View)layoutInflater);
    }

    @NonNull
    public FrameLayout getRoot() {
        return this.rootView;
    }
}
