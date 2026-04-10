/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.ViewGroup
 *  android.widget.FrameLayout
 *  android.widget.LinearLayout
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
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import miui.systemui.dynamicisland.R;

public final class FakeDynamicBigIslandTemplateBinding
implements ViewBinding {
    @NonNull
    public final FrameLayout fakeAreaCutout;
    @NonNull
    public final FrameLayout fakeAreaLeft;
    @NonNull
    public final FrameLayout fakeAreaRight;
    @NonNull
    public final LinearLayout fakeBigContainer;
    @NonNull
    private final LinearLayout rootView;

    private FakeDynamicBigIslandTemplateBinding(@NonNull LinearLayout linearLayout, @NonNull FrameLayout frameLayout, @NonNull FrameLayout frameLayout2, @NonNull FrameLayout frameLayout3, @NonNull LinearLayout linearLayout2) {
        this.rootView = linearLayout;
        this.fakeAreaCutout = frameLayout;
        this.fakeAreaLeft = frameLayout2;
        this.fakeAreaRight = frameLayout3;
        this.fakeBigContainer = linearLayout2;
    }

    @NonNull
    public static FakeDynamicBigIslandTemplateBinding bind(@NonNull View view) {
        FrameLayout frameLayout;
        FrameLayout frameLayout2;
        int n = R.id.fake_area_cutout;
        FrameLayout frameLayout3 = (FrameLayout)ViewBindings.findChildViewById((View)view, (int)n);
        if (frameLayout3 != null && (frameLayout2 = (FrameLayout)ViewBindings.findChildViewById((View)view, (int)(n = R.id.fake_area_left))) != null && (frameLayout = (FrameLayout)ViewBindings.findChildViewById((View)view, (int)(n = R.id.fake_area_right))) != null) {
            view = (LinearLayout)view;
            return new FakeDynamicBigIslandTemplateBinding((LinearLayout)view, frameLayout3, frameLayout2, frameLayout, (LinearLayout)view);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(n)));
    }

    @NonNull
    public static FakeDynamicBigIslandTemplateBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return FakeDynamicBigIslandTemplateBinding.inflate(layoutInflater, null, false);
    }

    @NonNull
    public static FakeDynamicBigIslandTemplateBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean bl) {
        layoutInflater = layoutInflater.inflate(R.layout.fake_dynamic_big_island_template, viewGroup, false);
        if (bl) {
            viewGroup.addView((View)layoutInflater);
        }
        return FakeDynamicBigIslandTemplateBinding.bind((View)layoutInflater);
    }

    @NonNull
    public LinearLayout getRoot() {
        return this.rootView;
    }
}
