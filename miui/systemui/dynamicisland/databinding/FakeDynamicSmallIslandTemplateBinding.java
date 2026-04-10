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

public final class FakeDynamicSmallIslandTemplateBinding
implements ViewBinding {
    @NonNull
    public final FrameLayout fakeSmallContainer;
    @NonNull
    private final FrameLayout rootView;

    private FakeDynamicSmallIslandTemplateBinding(@NonNull FrameLayout frameLayout, @NonNull FrameLayout frameLayout2) {
        this.rootView = frameLayout;
        this.fakeSmallContainer = frameLayout2;
    }

    @NonNull
    public static FakeDynamicSmallIslandTemplateBinding bind(@NonNull View view) {
        if (view != null) {
            view = (FrameLayout)view;
            return new FakeDynamicSmallIslandTemplateBinding((FrameLayout)view, (FrameLayout)view);
        }
        throw new NullPointerException("rootView");
    }

    @NonNull
    public static FakeDynamicSmallIslandTemplateBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return FakeDynamicSmallIslandTemplateBinding.inflate(layoutInflater, null, false);
    }

    @NonNull
    public static FakeDynamicSmallIslandTemplateBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean bl) {
        layoutInflater = layoutInflater.inflate(R.layout.fake_dynamic_small_island_template, viewGroup, false);
        if (bl) {
            viewGroup.addView((View)layoutInflater);
        }
        return FakeDynamicSmallIslandTemplateBinding.bind((View)layoutInflater);
    }

    @NonNull
    public FrameLayout getRoot() {
        return this.rootView;
    }
}
