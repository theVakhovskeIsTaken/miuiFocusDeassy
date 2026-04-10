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
import miui.systemui.dynamicisland.databinding.DynamicIslandModuleRightTextPadBinding;

public final class DynamicIslandModuleImageText2PadBinding
implements ViewBinding {
    @NonNull
    public final FrameLayout islandContainerModuleImageText2;
    @NonNull
    public final DynamicIslandModuleRightTextPadBinding islandContainerModuleText;
    @NonNull
    private final FrameLayout rootView;

    private DynamicIslandModuleImageText2PadBinding(@NonNull FrameLayout frameLayout, @NonNull FrameLayout frameLayout2, @NonNull DynamicIslandModuleRightTextPadBinding dynamicIslandModuleRightTextPadBinding) {
        this.rootView = frameLayout;
        this.islandContainerModuleImageText2 = frameLayout2;
        this.islandContainerModuleText = dynamicIslandModuleRightTextPadBinding;
    }

    @NonNull
    public static DynamicIslandModuleImageText2PadBinding bind(@NonNull View view) {
        FrameLayout frameLayout = (FrameLayout)view;
        int n = R.id.island_container_module_text;
        View view2 = ViewBindings.findChildViewById((View)view, (int)n);
        if (view2 != null) {
            return new DynamicIslandModuleImageText2PadBinding(frameLayout, frameLayout, DynamicIslandModuleRightTextPadBinding.bind(view2));
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(n)));
    }

    @NonNull
    public static DynamicIslandModuleImageText2PadBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return DynamicIslandModuleImageText2PadBinding.inflate(layoutInflater, null, false);
    }

    @NonNull
    public static DynamicIslandModuleImageText2PadBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean bl) {
        layoutInflater = layoutInflater.inflate(R.layout.dynamic_island_module_image_text_2_pad, viewGroup, false);
        if (bl) {
            viewGroup.addView((View)layoutInflater);
        }
        return DynamicIslandModuleImageText2PadBinding.bind((View)layoutInflater);
    }

    @NonNull
    public FrameLayout getRoot() {
        return this.rootView;
    }
}
