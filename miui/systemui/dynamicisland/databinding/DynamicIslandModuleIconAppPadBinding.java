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

public final class DynamicIslandModuleIconAppPadBinding
implements ViewBinding {
    @NonNull
    public final ImageView islandAppIcon;
    @NonNull
    private final ImageView rootView;

    private DynamicIslandModuleIconAppPadBinding(@NonNull ImageView imageView, @NonNull ImageView imageView2) {
        this.rootView = imageView;
        this.islandAppIcon = imageView2;
    }

    @NonNull
    public static DynamicIslandModuleIconAppPadBinding bind(@NonNull View view) {
        if (view != null) {
            view = (ImageView)view;
            return new DynamicIslandModuleIconAppPadBinding((ImageView)view, (ImageView)view);
        }
        throw new NullPointerException("rootView");
    }

    @NonNull
    public static DynamicIslandModuleIconAppPadBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return DynamicIslandModuleIconAppPadBinding.inflate(layoutInflater, null, false);
    }

    @NonNull
    public static DynamicIslandModuleIconAppPadBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean bl) {
        layoutInflater = layoutInflater.inflate(R.layout.dynamic_island_module_icon_app_pad, viewGroup, false);
        if (bl) {
            viewGroup.addView((View)layoutInflater);
        }
        return DynamicIslandModuleIconAppPadBinding.bind((View)layoutInflater);
    }

    @NonNull
    public ImageView getRoot() {
        return this.rootView;
    }
}
