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
 */
package miui.systemui.dynamicisland.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import miui.systemui.dynamicisland.R;
import miui.systemui.dynamicisland.view.DynamicIslandExpandedView;

public final class DynamicIslandExpandedViewBinding
implements ViewBinding {
    @NonNull
    public final DynamicIslandExpandedView expandedView;
    @NonNull
    private final DynamicIslandExpandedView rootView;

    private DynamicIslandExpandedViewBinding(@NonNull DynamicIslandExpandedView dynamicIslandExpandedView, @NonNull DynamicIslandExpandedView dynamicIslandExpandedView2) {
        this.rootView = dynamicIslandExpandedView;
        this.expandedView = dynamicIslandExpandedView2;
    }

    @NonNull
    public static DynamicIslandExpandedViewBinding bind(@NonNull View object) {
        if (object != null) {
            object = (DynamicIslandExpandedView)((Object)object);
            return new DynamicIslandExpandedViewBinding((DynamicIslandExpandedView)((Object)object), (DynamicIslandExpandedView)((Object)object));
        }
        throw new NullPointerException("rootView");
    }

    @NonNull
    public static DynamicIslandExpandedViewBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return DynamicIslandExpandedViewBinding.inflate(layoutInflater, null, false);
    }

    @NonNull
    public static DynamicIslandExpandedViewBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean bl) {
        layoutInflater = layoutInflater.inflate(R.layout.dynamic_island_expanded_view, viewGroup, false);
        if (bl) {
            viewGroup.addView((View)layoutInflater);
        }
        return DynamicIslandExpandedViewBinding.bind((View)layoutInflater);
    }

    @NonNull
    public DynamicIslandExpandedView getRoot() {
        return this.rootView;
    }
}
