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
import miui.systemui.dynamicisland.window.DynamicIslandWindowView;
import miui.systemui.dynamicisland.window.content.DynamicIslandEmptyContentView;

public final class DynamicIslandWindowViewBinding
implements ViewBinding {
    @NonNull
    public final DynamicIslandEmptyContentView emptyContentView;
    @NonNull
    public final FrameLayout glowEffectBottomContainer;
    @NonNull
    public final FrameLayout glowEffectTopContainer;
    @NonNull
    private final DynamicIslandWindowView rootView;

    private DynamicIslandWindowViewBinding(@NonNull DynamicIslandWindowView dynamicIslandWindowView, @NonNull DynamicIslandEmptyContentView dynamicIslandEmptyContentView, @NonNull FrameLayout frameLayout, @NonNull FrameLayout frameLayout2) {
        this.rootView = dynamicIslandWindowView;
        this.emptyContentView = dynamicIslandEmptyContentView;
        this.glowEffectBottomContainer = frameLayout;
        this.glowEffectTopContainer = frameLayout2;
    }

    @NonNull
    public static DynamicIslandWindowViewBinding bind(@NonNull View view) {
        FrameLayout frameLayout;
        FrameLayout frameLayout2;
        int n = R.id.empty_content_view;
        DynamicIslandEmptyContentView dynamicIslandEmptyContentView = (DynamicIslandEmptyContentView)ViewBindings.findChildViewById((View)view, (int)n);
        if (dynamicIslandEmptyContentView != null && (frameLayout2 = (FrameLayout)ViewBindings.findChildViewById((View)view, (int)(n = R.id.glow_effect_bottom_container))) != null && (frameLayout = (FrameLayout)ViewBindings.findChildViewById((View)view, (int)(n = R.id.glow_effect_top_container))) != null) {
            return new DynamicIslandWindowViewBinding((DynamicIslandWindowView)view, dynamicIslandEmptyContentView, frameLayout2, frameLayout);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(n)));
    }

    @NonNull
    public static DynamicIslandWindowViewBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return DynamicIslandWindowViewBinding.inflate(layoutInflater, null, false);
    }

    @NonNull
    public static DynamicIslandWindowViewBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean bl) {
        layoutInflater = layoutInflater.inflate(R.layout.dynamic_island_window_view, viewGroup, false);
        if (bl) {
            viewGroup.addView((View)layoutInflater);
        }
        return DynamicIslandWindowViewBinding.bind((View)layoutInflater);
    }

    @NonNull
    public DynamicIslandWindowView getRoot() {
        return this.rootView;
    }
}
