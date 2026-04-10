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

public final class DynamicSmallIslandTemplateStandardBinding
implements ViewBinding {
    @NonNull
    private final FrameLayout rootView;
    @NonNull
    public final FrameLayout smallContainer;

    private DynamicSmallIslandTemplateStandardBinding(@NonNull FrameLayout frameLayout, @NonNull FrameLayout frameLayout2) {
        this.rootView = frameLayout;
        this.smallContainer = frameLayout2;
    }

    @NonNull
    public static DynamicSmallIslandTemplateStandardBinding bind(@NonNull View view) {
        if (view != null) {
            view = (FrameLayout)view;
            return new DynamicSmallIslandTemplateStandardBinding((FrameLayout)view, (FrameLayout)view);
        }
        throw new NullPointerException("rootView");
    }

    @NonNull
    public static DynamicSmallIslandTemplateStandardBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return DynamicSmallIslandTemplateStandardBinding.inflate(layoutInflater, null, false);
    }

    @NonNull
    public static DynamicSmallIslandTemplateStandardBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean bl) {
        layoutInflater = layoutInflater.inflate(R.layout.dynamic_small_island_template_standard, viewGroup, false);
        if (bl) {
            viewGroup.addView((View)layoutInflater);
        }
        return DynamicSmallIslandTemplateStandardBinding.bind((View)layoutInflater);
    }

    @NonNull
    public FrameLayout getRoot() {
        return this.rootView;
    }
}
