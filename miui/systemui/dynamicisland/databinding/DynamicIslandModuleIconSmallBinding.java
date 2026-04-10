/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.ViewGroup
 *  android.widget.ImageView
 *  androidx.annotation.NonNull
 *  androidx.annotation.Nullable
 *  androidx.viewbinding.ViewBinding
 */
package miui.systemui.dynamicisland.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import miui.systemui.dynamicisland.R;

public final class DynamicIslandModuleIconSmallBinding
implements ViewBinding {
    @NonNull
    public final ImageView islandSmallIcon;
    @NonNull
    private final ImageView rootView;

    private DynamicIslandModuleIconSmallBinding(@NonNull ImageView imageView, @NonNull ImageView imageView2) {
        this.rootView = imageView;
        this.islandSmallIcon = imageView2;
    }

    @NonNull
    public static DynamicIslandModuleIconSmallBinding bind(@NonNull View view) {
        if (view != null) {
            view = (ImageView)view;
            return new DynamicIslandModuleIconSmallBinding((ImageView)view, (ImageView)view);
        }
        throw new NullPointerException("rootView");
    }

    @NonNull
    public static DynamicIslandModuleIconSmallBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return DynamicIslandModuleIconSmallBinding.inflate(layoutInflater, null, false);
    }

    @NonNull
    public static DynamicIslandModuleIconSmallBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean bl) {
        layoutInflater = layoutInflater.inflate(R.layout.dynamic_island_module_icon_small, viewGroup, false);
        if (bl) {
            viewGroup.addView((View)layoutInflater);
        }
        return DynamicIslandModuleIconSmallBinding.bind((View)layoutInflater);
    }

    @NonNull
    public ImageView getRoot() {
        return this.rootView;
    }
}
