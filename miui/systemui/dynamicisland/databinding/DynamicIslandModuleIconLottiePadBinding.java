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

public final class DynamicIslandModuleIconLottiePadBinding
implements ViewBinding {
    @NonNull
    public final LottieView islandLottie;
    @NonNull
    private final LottieView rootView;

    private DynamicIslandModuleIconLottiePadBinding(@NonNull LottieView lottieView, @NonNull LottieView lottieView2) {
        this.rootView = lottieView;
        this.islandLottie = lottieView2;
    }

    @NonNull
    public static DynamicIslandModuleIconLottiePadBinding bind(@NonNull View view) {
        if (view != null) {
            view = (LottieView)view;
            return new DynamicIslandModuleIconLottiePadBinding((LottieView)view, (LottieView)view);
        }
        throw new NullPointerException("rootView");
    }

    @NonNull
    public static DynamicIslandModuleIconLottiePadBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return DynamicIslandModuleIconLottiePadBinding.inflate(layoutInflater, null, false);
    }

    @NonNull
    public static DynamicIslandModuleIconLottiePadBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean bl) {
        layoutInflater = layoutInflater.inflate(R.layout.dynamic_island_module_icon_lottie_pad, viewGroup, false);
        if (bl) {
            viewGroup.addView((View)layoutInflater);
        }
        return DynamicIslandModuleIconLottiePadBinding.bind((View)layoutInflater);
    }

    @NonNull
    public LottieView getRoot() {
        return this.rootView;
    }
}
