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
 *  miuix.colorful.texteffect.TimerTextEffectView
 */
package miui.systemui.dynamicisland.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import miui.systemui.dynamicisland.R;
import miuix.colorful.texteffect.TimerTextEffectView;

public final class DynamicIslandModuleLeftContentPadBinding
implements ViewBinding {
    @NonNull
    public final TimerTextEffectView islandContent;
    @NonNull
    private final TimerTextEffectView rootView;

    private DynamicIslandModuleLeftContentPadBinding(@NonNull TimerTextEffectView timerTextEffectView, @NonNull TimerTextEffectView timerTextEffectView2) {
        this.rootView = timerTextEffectView;
        this.islandContent = timerTextEffectView2;
    }

    @NonNull
    public static DynamicIslandModuleLeftContentPadBinding bind(@NonNull View view) {
        if (view != null) {
            view = (TimerTextEffectView)view;
            return new DynamicIslandModuleLeftContentPadBinding((TimerTextEffectView)view, (TimerTextEffectView)view);
        }
        throw new NullPointerException("rootView");
    }

    @NonNull
    public static DynamicIslandModuleLeftContentPadBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return DynamicIslandModuleLeftContentPadBinding.inflate(layoutInflater, null, false);
    }

    @NonNull
    public static DynamicIslandModuleLeftContentPadBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean bl) {
        layoutInflater = layoutInflater.inflate(R.layout.dynamic_island_module_left_content_pad, viewGroup, false);
        if (bl) {
            viewGroup.addView((View)layoutInflater);
        }
        return DynamicIslandModuleLeftContentPadBinding.bind((View)layoutInflater);
    }

    @NonNull
    public TimerTextEffectView getRoot() {
        return this.rootView;
    }
}
