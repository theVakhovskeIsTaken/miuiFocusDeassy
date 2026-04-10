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
 */
package miui.systemui.dynamicisland.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import miui.systemui.dynamicisland.R;
import miui.systemui.dynamicisland.window.content.DynamicIslandContentFakeView;

public final class DynamicIslandFakeContentViewBinding
implements ViewBinding {
    @NonNull
    public final DynamicIslandContentFakeView fakeContent;
    @NonNull
    private final DynamicIslandContentFakeView rootView;

    private DynamicIslandFakeContentViewBinding(@NonNull DynamicIslandContentFakeView dynamicIslandContentFakeView, @NonNull DynamicIslandContentFakeView dynamicIslandContentFakeView2) {
        this.rootView = dynamicIslandContentFakeView;
        this.fakeContent = dynamicIslandContentFakeView2;
    }

    @NonNull
    public static DynamicIslandFakeContentViewBinding bind(@NonNull View object) {
        if (object != null) {
            object = (DynamicIslandContentFakeView)((Object)object);
            return new DynamicIslandFakeContentViewBinding((DynamicIslandContentFakeView)((Object)object), (DynamicIslandContentFakeView)((Object)object));
        }
        throw new NullPointerException("rootView");
    }

    @NonNull
    public static DynamicIslandFakeContentViewBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return DynamicIslandFakeContentViewBinding.inflate(layoutInflater, null, false);
    }

    @NonNull
    public static DynamicIslandFakeContentViewBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean bl) {
        layoutInflater = layoutInflater.inflate(R.layout.dynamic_island_fake_content_view, viewGroup, false);
        if (bl) {
            viewGroup.addView((View)layoutInflater);
        }
        return DynamicIslandFakeContentViewBinding.bind((View)layoutInflater);
    }

    @NonNull
    public DynamicIslandContentFakeView getRoot() {
        return this.rootView;
    }
}
