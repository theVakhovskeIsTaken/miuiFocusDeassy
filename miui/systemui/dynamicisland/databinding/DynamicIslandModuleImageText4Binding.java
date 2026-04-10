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
 *  androidx.viewbinding.ViewBindings
 *  com.mi.widget.view.ChargerView
 *  com.mi.widget.view.PowerSaveView
 */
package miui.systemui.dynamicisland.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.mi.widget.view.ChargerView;
import com.mi.widget.view.PowerSaveView;
import miui.systemui.dynamicisland.R;

public final class DynamicIslandModuleImageText4Binding
implements ViewBinding {
    @NonNull
    public final ChargerView chargeView;
    @NonNull
    public final FrameLayout islandContainerModuleImageText1;
    @NonNull
    public final PowerSaveView powerSaveView;
    @NonNull
    private final FrameLayout rootView;

    private DynamicIslandModuleImageText4Binding(@NonNull FrameLayout frameLayout, @NonNull ChargerView chargerView, @NonNull FrameLayout frameLayout2, @NonNull PowerSaveView powerSaveView) {
        this.rootView = frameLayout;
        this.chargeView = chargerView;
        this.islandContainerModuleImageText1 = frameLayout2;
        this.powerSaveView = powerSaveView;
    }

    @NonNull
    public static DynamicIslandModuleImageText4Binding bind(@NonNull View view) {
        int n = R.id.charge_view;
        ChargerView chargerView = (ChargerView)ViewBindings.findChildViewById((View)view, (int)n);
        if (chargerView != null) {
            FrameLayout frameLayout = (FrameLayout)view;
            n = R.id.power_save_view;
            PowerSaveView powerSaveView = (PowerSaveView)ViewBindings.findChildViewById((View)view, (int)n);
            if (powerSaveView != null) {
                return new DynamicIslandModuleImageText4Binding(frameLayout, chargerView, frameLayout, powerSaveView);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(n)));
    }

    @NonNull
    public static DynamicIslandModuleImageText4Binding inflate(@NonNull LayoutInflater layoutInflater) {
        return DynamicIslandModuleImageText4Binding.inflate(layoutInflater, null, false);
    }

    @NonNull
    public static DynamicIslandModuleImageText4Binding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean bl) {
        layoutInflater = layoutInflater.inflate(R.layout.dynamic_island_module_image_text_4, viewGroup, false);
        if (bl) {
            viewGroup.addView((View)layoutInflater);
        }
        return DynamicIslandModuleImageText4Binding.bind((View)layoutInflater);
    }

    @NonNull
    public FrameLayout getRoot() {
        return this.rootView;
    }
}
