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
import miui.systemui.dynamicisland.databinding.DynamicIslandModuleIcon1PadBinding;
import miui.systemui.dynamicisland.databinding.DynamicIslandModuleRightTextPadBinding;

public final class DynamicIslandModuleImageText3PadBinding
implements ViewBinding {
    @NonNull
    public final DynamicIslandModuleIcon1PadBinding islandContainerModuleIcon;
    @NonNull
    public final FrameLayout islandContainerModuleImageText3;
    @NonNull
    public final DynamicIslandModuleRightTextPadBinding islandContainerModuleText;
    @NonNull
    private final FrameLayout rootView;

    private DynamicIslandModuleImageText3PadBinding(@NonNull FrameLayout frameLayout, @NonNull DynamicIslandModuleIcon1PadBinding dynamicIslandModuleIcon1PadBinding, @NonNull FrameLayout frameLayout2, @NonNull DynamicIslandModuleRightTextPadBinding dynamicIslandModuleRightTextPadBinding) {
        this.rootView = frameLayout;
        this.islandContainerModuleIcon = dynamicIslandModuleIcon1PadBinding;
        this.islandContainerModuleImageText3 = frameLayout2;
        this.islandContainerModuleText = dynamicIslandModuleRightTextPadBinding;
    }

    @NonNull
    public static DynamicIslandModuleImageText3PadBinding bind(@NonNull View view) {
        int n = R.id.island_container_module_icon;
        View view2 = ViewBindings.findChildViewById((View)view, (int)n);
        if (view2 != null) {
            DynamicIslandModuleIcon1PadBinding dynamicIslandModuleIcon1PadBinding = DynamicIslandModuleIcon1PadBinding.bind(view2);
            FrameLayout frameLayout = (FrameLayout)view;
            n = R.id.island_container_module_text;
            view2 = ViewBindings.findChildViewById((View)view, (int)n);
            if (view2 != null) {
                return new DynamicIslandModuleImageText3PadBinding(frameLayout, dynamicIslandModuleIcon1PadBinding, frameLayout, DynamicIslandModuleRightTextPadBinding.bind(view2));
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(n)));
    }

    @NonNull
    public static DynamicIslandModuleImageText3PadBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return DynamicIslandModuleImageText3PadBinding.inflate(layoutInflater, null, false);
    }

    @NonNull
    public static DynamicIslandModuleImageText3PadBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean bl) {
        layoutInflater = layoutInflater.inflate(R.layout.dynamic_island_module_image_text_3_pad, viewGroup, false);
        if (bl) {
            viewGroup.addView((View)layoutInflater);
        }
        return DynamicIslandModuleImageText3PadBinding.bind((View)layoutInflater);
    }

    @NonNull
    public FrameLayout getRoot() {
        return this.rootView;
    }
}
