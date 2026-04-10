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
import miui.systemui.widget.CircularProgressBar;

public final class DynamicIslandModuleProgressTextBinding
implements ViewBinding {
    @NonNull
    public final FrameLayout islandContainerModuleImageText2;
    @NonNull
    public final CircularProgressBar islandProgress;
    @NonNull
    private final FrameLayout rootView;

    private DynamicIslandModuleProgressTextBinding(@NonNull FrameLayout frameLayout, @NonNull FrameLayout frameLayout2, @NonNull CircularProgressBar circularProgressBar) {
        this.rootView = frameLayout;
        this.islandContainerModuleImageText2 = frameLayout2;
        this.islandProgress = circularProgressBar;
    }

    @NonNull
    public static DynamicIslandModuleProgressTextBinding bind(@NonNull View view) {
        FrameLayout frameLayout = (FrameLayout)view;
        int n = R.id.island_progress;
        CircularProgressBar circularProgressBar = (CircularProgressBar)ViewBindings.findChildViewById((View)view, (int)n);
        if (circularProgressBar != null) {
            return new DynamicIslandModuleProgressTextBinding(frameLayout, frameLayout, circularProgressBar);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(n)));
    }

    @NonNull
    public static DynamicIslandModuleProgressTextBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return DynamicIslandModuleProgressTextBinding.inflate(layoutInflater, null, false);
    }

    @NonNull
    public static DynamicIslandModuleProgressTextBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean bl) {
        layoutInflater = layoutInflater.inflate(R.layout.dynamic_island_module_progress_text, viewGroup, false);
        if (bl) {
            viewGroup.addView((View)layoutInflater);
        }
        return DynamicIslandModuleProgressTextBinding.bind((View)layoutInflater);
    }

    @NonNull
    public FrameLayout getRoot() {
        return this.rootView;
    }
}
