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
 *  com.mi.widget.view.LottieView
 */
package miui.systemui.dynamicisland.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import com.mi.widget.view.LottieView;
import miui.systemui.dynamicisland.R;

public final class DynamicIslandModuleIconLottieBiggerBinding
implements ViewBinding {
    @NonNull
    public final LottieView islandLottieBigger;
    @NonNull
    private final LottieView rootView;

    private DynamicIslandModuleIconLottieBiggerBinding(@NonNull LottieView lottieView, @NonNull LottieView lottieView2) {
        this.rootView = lottieView;
        this.islandLottieBigger = lottieView2;
    }

    @NonNull
    public static DynamicIslandModuleIconLottieBiggerBinding bind(@NonNull View view) {
        if (view != null) {
            view = (LottieView)view;
            return new DynamicIslandModuleIconLottieBiggerBinding((LottieView)view, (LottieView)view);
        }
        throw new NullPointerException("rootView");
    }

    @NonNull
    public static DynamicIslandModuleIconLottieBiggerBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return DynamicIslandModuleIconLottieBiggerBinding.inflate(layoutInflater, null, false);
    }

    @NonNull
    public static DynamicIslandModuleIconLottieBiggerBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean bl) {
        layoutInflater = layoutInflater.inflate(R.layout.dynamic_island_module_icon_lottie_bigger, viewGroup, false);
        if (bl) {
            viewGroup.addView((View)layoutInflater);
        }
        return DynamicIslandModuleIconLottieBiggerBinding.bind((View)layoutInflater);
    }

    @NonNull
    public LottieView getRoot() {
        return this.rootView;
    }
}
