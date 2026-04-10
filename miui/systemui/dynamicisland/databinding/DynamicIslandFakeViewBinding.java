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

public final class DynamicIslandFakeViewBinding
implements ViewBinding {
    @NonNull
    public final FrameLayout fakeBigIslandView;
    @NonNull
    public final FrameLayout fakeContainer;
    @NonNull
    public final FrameLayout fakeExpandedView;
    @NonNull
    public final View fakeIslandMask;
    @NonNull
    public final FrameLayout fakeSmallIslandView;
    @NonNull
    public final View miniWindowBar;
    @NonNull
    private final FrameLayout rootView;

    private DynamicIslandFakeViewBinding(@NonNull FrameLayout frameLayout, @NonNull FrameLayout frameLayout2, @NonNull FrameLayout frameLayout3, @NonNull FrameLayout frameLayout4, @NonNull View view, @NonNull FrameLayout frameLayout5, @NonNull View view2) {
        this.rootView = frameLayout;
        this.fakeBigIslandView = frameLayout2;
        this.fakeContainer = frameLayout3;
        this.fakeExpandedView = frameLayout4;
        this.fakeIslandMask = view;
        this.fakeSmallIslandView = frameLayout5;
        this.miniWindowBar = view2;
    }

    @NonNull
    public static DynamicIslandFakeViewBinding bind(@NonNull View view) {
        int n = R.id.fake_big_island_view;
        FrameLayout frameLayout = (FrameLayout)ViewBindings.findChildViewById((View)view, (int)n);
        if (frameLayout != null) {
            View view2;
            FrameLayout frameLayout2;
            View view3;
            FrameLayout frameLayout3 = (FrameLayout)view;
            n = R.id.fake_expanded_view;
            FrameLayout frameLayout4 = (FrameLayout)ViewBindings.findChildViewById((View)view, (int)n);
            if (frameLayout4 != null && (view3 = ViewBindings.findChildViewById((View)view, (int)(n = R.id.fake_island_mask))) != null && (frameLayout2 = (FrameLayout)ViewBindings.findChildViewById((View)view, (int)(n = R.id.fake_small_island_view))) != null && (view2 = ViewBindings.findChildViewById((View)view, (int)(n = R.id.mini_window_bar))) != null) {
                return new DynamicIslandFakeViewBinding(frameLayout3, frameLayout, frameLayout3, frameLayout4, view3, frameLayout2, view2);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(n)));
    }

    @NonNull
    public static DynamicIslandFakeViewBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return DynamicIslandFakeViewBinding.inflate(layoutInflater, null, false);
    }

    @NonNull
    public static DynamicIslandFakeViewBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean bl) {
        layoutInflater = layoutInflater.inflate(R.layout.dynamic_island_fake_view, viewGroup, false);
        if (bl) {
            viewGroup.addView((View)layoutInflater);
        }
        return DynamicIslandFakeViewBinding.bind((View)layoutInflater);
    }

    @NonNull
    public FrameLayout getRoot() {
        return this.rootView;
    }
}
