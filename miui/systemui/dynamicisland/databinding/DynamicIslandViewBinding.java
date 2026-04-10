/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.ViewGroup
 *  androidx.annotation.NonNull
 *  androidx.annotation.Nullable
 *  androidx.viewbinding.ViewBinding
 *  androidx.viewbinding.ViewBindings
 */
package miui.systemui.dynamicisland.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import miui.systemui.dynamicisland.DynamicIslandBackgroundView;
import miui.systemui.dynamicisland.R;
import miui.systemui.dynamicisland.window.content.DynamicIslandContentView;

public final class DynamicIslandViewBinding
implements ViewBinding {
    @NonNull
    public final DynamicIslandBackgroundView islandContainer;
    @NonNull
    public final DynamicIslandContentView islandContent;
    @NonNull
    private final DynamicIslandBackgroundView rootView;

    private DynamicIslandViewBinding(@NonNull DynamicIslandBackgroundView dynamicIslandBackgroundView, @NonNull DynamicIslandBackgroundView dynamicIslandBackgroundView2, @NonNull DynamicIslandContentView dynamicIslandContentView) {
        this.rootView = dynamicIslandBackgroundView;
        this.islandContainer = dynamicIslandBackgroundView2;
        this.islandContent = dynamicIslandContentView;
    }

    @NonNull
    public static DynamicIslandViewBinding bind(@NonNull View view) {
        DynamicIslandBackgroundView dynamicIslandBackgroundView = (DynamicIslandBackgroundView)view;
        int n = R.id.island_content;
        DynamicIslandContentView dynamicIslandContentView = (DynamicIslandContentView)ViewBindings.findChildViewById((View)view, (int)n);
        if (dynamicIslandContentView != null) {
            return new DynamicIslandViewBinding(dynamicIslandBackgroundView, dynamicIslandBackgroundView, dynamicIslandContentView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(n)));
    }

    @NonNull
    public static DynamicIslandViewBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return DynamicIslandViewBinding.inflate(layoutInflater, null, false);
    }

    @NonNull
    public static DynamicIslandViewBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean bl) {
        layoutInflater = layoutInflater.inflate(R.layout.dynamic_island_view, viewGroup, false);
        if (bl) {
            viewGroup.addView((View)layoutInflater);
        }
        return DynamicIslandViewBinding.bind((View)layoutInflater);
    }

    @NonNull
    public DynamicIslandBackgroundView getRoot() {
        return this.rootView;
    }
}
