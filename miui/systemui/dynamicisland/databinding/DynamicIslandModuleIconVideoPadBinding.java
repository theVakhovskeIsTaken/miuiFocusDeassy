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
 *  miui.systemui.widget.TextureVideoView
 */
package miui.systemui.dynamicisland.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import miui.systemui.dynamicisland.R;
import miui.systemui.widget.TextureVideoView;

public final class DynamicIslandModuleIconVideoPadBinding
implements ViewBinding {
    @NonNull
    public final TextureVideoView islandVideo;
    @NonNull
    private final TextureVideoView rootView;

    private DynamicIslandModuleIconVideoPadBinding(@NonNull TextureVideoView textureVideoView, @NonNull TextureVideoView textureVideoView2) {
        this.rootView = textureVideoView;
        this.islandVideo = textureVideoView2;
    }

    @NonNull
    public static DynamicIslandModuleIconVideoPadBinding bind(@NonNull View view) {
        if (view != null) {
            view = (TextureVideoView)view;
            return new DynamicIslandModuleIconVideoPadBinding((TextureVideoView)view, (TextureVideoView)view);
        }
        throw new NullPointerException("rootView");
    }

    @NonNull
    public static DynamicIslandModuleIconVideoPadBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return DynamicIslandModuleIconVideoPadBinding.inflate(layoutInflater, null, false);
    }

    @NonNull
    public static DynamicIslandModuleIconVideoPadBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean bl) {
        layoutInflater = layoutInflater.inflate(R.layout.dynamic_island_module_icon_video_pad, viewGroup, false);
        if (bl) {
            viewGroup.addView((View)layoutInflater);
        }
        return DynamicIslandModuleIconVideoPadBinding.bind((View)layoutInflater);
    }

    @NonNull
    public TextureVideoView getRoot() {
        return this.rootView;
    }
}
