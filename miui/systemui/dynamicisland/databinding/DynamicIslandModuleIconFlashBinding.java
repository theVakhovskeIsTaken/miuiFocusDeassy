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
 *  com.mi.widget.view.FlashLightIcon
 */
package miui.systemui.dynamicisland.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import com.mi.widget.view.FlashLightIcon;
import miui.systemui.dynamicisland.R;

public final class DynamicIslandModuleIconFlashBinding
implements ViewBinding {
    @NonNull
    public final FlashLightIcon islandFlashIcon;
    @NonNull
    private final FlashLightIcon rootView;

    private DynamicIslandModuleIconFlashBinding(@NonNull FlashLightIcon flashLightIcon, @NonNull FlashLightIcon flashLightIcon2) {
        this.rootView = flashLightIcon;
        this.islandFlashIcon = flashLightIcon2;
    }

    @NonNull
    public static DynamicIslandModuleIconFlashBinding bind(@NonNull View view) {
        if (view != null) {
            view = (FlashLightIcon)view;
            return new DynamicIslandModuleIconFlashBinding((FlashLightIcon)view, (FlashLightIcon)view);
        }
        throw new NullPointerException("rootView");
    }

    @NonNull
    public static DynamicIslandModuleIconFlashBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return DynamicIslandModuleIconFlashBinding.inflate(layoutInflater, null, false);
    }

    @NonNull
    public static DynamicIslandModuleIconFlashBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean bl) {
        layoutInflater = layoutInflater.inflate(R.layout.dynamic_island_module_icon_flash, viewGroup, false);
        if (bl) {
            viewGroup.addView((View)layoutInflater);
        }
        return DynamicIslandModuleIconFlashBinding.bind((View)layoutInflater);
    }

    @NonNull
    public FlashLightIcon getRoot() {
        return this.rootView;
    }
}
