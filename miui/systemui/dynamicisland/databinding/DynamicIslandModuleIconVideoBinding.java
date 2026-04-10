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

public final class DynamicIslandModuleIconVideoBinding
implements ViewBinding {
    @NonNull
    public final TextureVideoView islandVideo;
    @NonNull
    private final TextureVideoView rootView;

    private DynamicIslandModuleIconVideoBinding(@NonNull TextureVideoView textureVideoView, @NonNull TextureVideoView textureVideoView2) {
        this.rootView = textureVideoView;
        this.islandVideo = textureVideoView2;
    }

    @NonNull
    public static DynamicIslandModuleIconVideoBinding bind(@NonNull View view) {
        if (view != null) {
            view = (TextureVideoView)view;
            return new DynamicIslandModuleIconVideoBinding((TextureVideoView)view, (TextureVideoView)view);
        }
        throw new NullPointerException("rootView");
    }

    @NonNull
    public static DynamicIslandModuleIconVideoBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return DynamicIslandModuleIconVideoBinding.inflate(layoutInflater, null, false);
    }

    @NonNull
    public static DynamicIslandModuleIconVideoBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean bl) {
        layoutInflater = layoutInflater.inflate(R.layout.dynamic_island_module_icon_video, viewGroup, false);
        if (bl) {
            viewGroup.addView((View)layoutInflater);
        }
        return DynamicIslandModuleIconVideoBinding.bind((View)layoutInflater);
    }

    @NonNull
    public TextureVideoView getRoot() {
        return this.rootView;
    }
}
