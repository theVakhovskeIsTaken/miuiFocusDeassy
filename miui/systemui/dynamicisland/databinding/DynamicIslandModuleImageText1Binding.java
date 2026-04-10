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
 */
package miui.systemui.dynamicisland.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import miui.systemui.dynamicisland.R;

public final class DynamicIslandModuleImageText1Binding
implements ViewBinding {
    @NonNull
    public final FrameLayout islandContainerModuleImageText1;
    @NonNull
    private final FrameLayout rootView;

    private DynamicIslandModuleImageText1Binding(@NonNull FrameLayout frameLayout, @NonNull FrameLayout frameLayout2) {
        this.rootView = frameLayout;
        this.islandContainerModuleImageText1 = frameLayout2;
    }

    @NonNull
    public static DynamicIslandModuleImageText1Binding bind(@NonNull View view) {
        if (view != null) {
            view = (FrameLayout)view;
            return new DynamicIslandModuleImageText1Binding((FrameLayout)view, (FrameLayout)view);
        }
        throw new NullPointerException("rootView");
    }

    @NonNull
    public static DynamicIslandModuleImageText1Binding inflate(@NonNull LayoutInflater layoutInflater) {
        return DynamicIslandModuleImageText1Binding.inflate(layoutInflater, null, false);
    }

    @NonNull
    public static DynamicIslandModuleImageText1Binding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean bl) {
        layoutInflater = layoutInflater.inflate(R.layout.dynamic_island_module_image_text_1, viewGroup, false);
        if (bl) {
            viewGroup.addView((View)layoutInflater);
        }
        return DynamicIslandModuleImageText1Binding.bind((View)layoutInflater);
    }

    @NonNull
    public FrameLayout getRoot() {
        return this.rootView;
    }
}
