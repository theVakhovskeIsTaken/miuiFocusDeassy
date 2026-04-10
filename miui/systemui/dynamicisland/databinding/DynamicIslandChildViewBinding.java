/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.ViewGroup
 *  android.view.ViewStub
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
import android.view.ViewStub;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import miui.systemui.dynamicisland.R;
import miui.systemui.dynamicisland.view.DynamicIslandBigIslandView;

public final class DynamicIslandChildViewBinding
implements ViewBinding {
    @NonNull
    public final DynamicIslandBigIslandView bigIslandView;
    @NonNull
    public final FrameLayout container;
    @NonNull
    public final ViewStub expandedViewStub;
    @NonNull
    public final View islandMask;
    @NonNull
    public final View miniWindowBar;
    @NonNull
    private final FrameLayout rootView;
    @NonNull
    public final FrameLayout smallIslandView;

    private DynamicIslandChildViewBinding(@NonNull FrameLayout frameLayout, @NonNull DynamicIslandBigIslandView dynamicIslandBigIslandView, @NonNull FrameLayout frameLayout2, @NonNull ViewStub viewStub, @NonNull View view, @NonNull View view2, @NonNull FrameLayout frameLayout3) {
        this.rootView = frameLayout;
        this.bigIslandView = dynamicIslandBigIslandView;
        this.container = frameLayout2;
        this.expandedViewStub = viewStub;
        this.islandMask = view;
        this.miniWindowBar = view2;
        this.smallIslandView = frameLayout3;
    }

    @NonNull
    public static DynamicIslandChildViewBinding bind(@NonNull View view) {
        int n = R.id.big_island_view;
        DynamicIslandBigIslandView dynamicIslandBigIslandView = (DynamicIslandBigIslandView)ViewBindings.findChildViewById((View)view, (int)n);
        if (dynamicIslandBigIslandView != null) {
            FrameLayout frameLayout;
            View view2;
            View view3;
            FrameLayout frameLayout2 = (FrameLayout)view;
            n = R.id.expanded_view_stub;
            ViewStub viewStub = (ViewStub)ViewBindings.findChildViewById((View)view, (int)n);
            if (viewStub != null && (view3 = ViewBindings.findChildViewById((View)view, (int)(n = R.id.island_mask))) != null && (view2 = ViewBindings.findChildViewById((View)view, (int)(n = R.id.mini_window_bar))) != null && (frameLayout = (FrameLayout)ViewBindings.findChildViewById((View)view, (int)(n = R.id.small_island_view))) != null) {
                return new DynamicIslandChildViewBinding(frameLayout2, dynamicIslandBigIslandView, frameLayout2, viewStub, view3, view2, frameLayout);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(n)));
    }

    @NonNull
    public static DynamicIslandChildViewBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return DynamicIslandChildViewBinding.inflate(layoutInflater, null, false);
    }

    @NonNull
    public static DynamicIslandChildViewBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean bl) {
        layoutInflater = layoutInflater.inflate(R.layout.dynamic_island_child_view, viewGroup, false);
        if (bl) {
            viewGroup.addView((View)layoutInflater);
        }
        return DynamicIslandChildViewBinding.bind((View)layoutInflater);
    }

    @NonNull
    public FrameLayout getRoot() {
        return this.rootView;
    }
}
