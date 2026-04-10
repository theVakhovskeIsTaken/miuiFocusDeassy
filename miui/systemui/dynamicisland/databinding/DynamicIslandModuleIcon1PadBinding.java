/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.ViewGroup
 *  android.view.ViewStub
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
import android.view.ViewStub;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import miui.systemui.dynamicisland.R;

public final class DynamicIslandModuleIcon1PadBinding
implements ViewBinding {
    @NonNull
    public final ViewStub islandAppIconStub;
    @NonNull
    public final FrameLayout islandContainerModuleIcon;
    @NonNull
    public final ViewStub islandFixIconStub;
    @NonNull
    public final ViewStub islandFlashIconStub;
    @NonNull
    public final ViewStub islandIconStub;
    @NonNull
    public final ViewStub islandLottieBiggerStaticStub;
    @NonNull
    public final ViewStub islandLottieBiggerStub;
    @NonNull
    public final ViewStub islandLottieStaticStub;
    @NonNull
    public final ViewStub islandLottieStub;
    @NonNull
    public final ViewStub islandSmallIconStub;
    @NonNull
    public final ViewStub islandVideoStub;
    @NonNull
    private final FrameLayout rootView;

    private DynamicIslandModuleIcon1PadBinding(@NonNull FrameLayout frameLayout, @NonNull ViewStub viewStub, @NonNull FrameLayout frameLayout2, @NonNull ViewStub viewStub2, @NonNull ViewStub viewStub3, @NonNull ViewStub viewStub4, @NonNull ViewStub viewStub5, @NonNull ViewStub viewStub6, @NonNull ViewStub viewStub7, @NonNull ViewStub viewStub8, @NonNull ViewStub viewStub9, @NonNull ViewStub viewStub10) {
        this.rootView = frameLayout;
        this.islandAppIconStub = viewStub;
        this.islandContainerModuleIcon = frameLayout2;
        this.islandFixIconStub = viewStub2;
        this.islandFlashIconStub = viewStub3;
        this.islandIconStub = viewStub4;
        this.islandLottieBiggerStaticStub = viewStub5;
        this.islandLottieBiggerStub = viewStub6;
        this.islandLottieStaticStub = viewStub7;
        this.islandLottieStub = viewStub8;
        this.islandSmallIconStub = viewStub9;
        this.islandVideoStub = viewStub10;
    }

    @NonNull
    public static DynamicIslandModuleIcon1PadBinding bind(@NonNull View view) {
        int n = R.id.island_app_icon_stub;
        ViewStub viewStub = (ViewStub)ViewBindings.findChildViewById((View)view, (int)n);
        if (viewStub != null) {
            ViewStub viewStub2;
            ViewStub viewStub3;
            ViewStub viewStub4;
            ViewStub viewStub5;
            ViewStub viewStub6;
            ViewStub viewStub7;
            ViewStub viewStub8;
            ViewStub viewStub9;
            FrameLayout frameLayout = (FrameLayout)view;
            n = R.id.island_fix_icon_stub;
            ViewStub viewStub10 = (ViewStub)ViewBindings.findChildViewById((View)view, (int)n);
            if (viewStub10 != null && (viewStub9 = (ViewStub)ViewBindings.findChildViewById((View)view, (int)(n = R.id.island_flash_icon_stub))) != null && (viewStub8 = (ViewStub)ViewBindings.findChildViewById((View)view, (int)(n = R.id.island_icon_stub))) != null && (viewStub7 = (ViewStub)ViewBindings.findChildViewById((View)view, (int)(n = R.id.island_lottie_bigger_static_stub))) != null && (viewStub6 = (ViewStub)ViewBindings.findChildViewById((View)view, (int)(n = R.id.island_lottie_bigger_stub))) != null && (viewStub5 = (ViewStub)ViewBindings.findChildViewById((View)view, (int)(n = R.id.island_lottie_static_stub))) != null && (viewStub4 = (ViewStub)ViewBindings.findChildViewById((View)view, (int)(n = R.id.island_lottie_stub))) != null && (viewStub3 = (ViewStub)ViewBindings.findChildViewById((View)view, (int)(n = R.id.island_small_icon_stub))) != null && (viewStub2 = (ViewStub)ViewBindings.findChildViewById((View)view, (int)(n = R.id.island_video_stub))) != null) {
                return new DynamicIslandModuleIcon1PadBinding(frameLayout, viewStub, frameLayout, viewStub10, viewStub9, viewStub8, viewStub7, viewStub6, viewStub5, viewStub4, viewStub3, viewStub2);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(n)));
    }

    @NonNull
    public static DynamicIslandModuleIcon1PadBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return DynamicIslandModuleIcon1PadBinding.inflate(layoutInflater, null, false);
    }

    @NonNull
    public static DynamicIslandModuleIcon1PadBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean bl) {
        layoutInflater = layoutInflater.inflate(R.layout.dynamic_island_module_icon_1_pad, viewGroup, false);
        if (bl) {
            viewGroup.addView((View)layoutInflater);
        }
        return DynamicIslandModuleIcon1PadBinding.bind((View)layoutInflater);
    }

    @NonNull
    public FrameLayout getRoot() {
        return this.rootView;
    }
}
