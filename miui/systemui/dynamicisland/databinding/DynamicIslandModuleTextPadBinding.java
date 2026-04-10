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

public final class DynamicIslandModuleTextPadBinding
implements ViewBinding {
    @NonNull
    public final FrameLayout islandContainerModuleText;
    @NonNull
    public final ViewStub islandContentStub;
    @NonNull
    public final ViewStub islandFrontTitleStub;
    @NonNull
    public final ViewStub islandTitleStub;
    @NonNull
    private final FrameLayout rootView;

    private DynamicIslandModuleTextPadBinding(@NonNull FrameLayout frameLayout, @NonNull FrameLayout frameLayout2, @NonNull ViewStub viewStub, @NonNull ViewStub viewStub2, @NonNull ViewStub viewStub3) {
        this.rootView = frameLayout;
        this.islandContainerModuleText = frameLayout2;
        this.islandContentStub = viewStub;
        this.islandFrontTitleStub = viewStub2;
        this.islandTitleStub = viewStub3;
    }

    @NonNull
    public static DynamicIslandModuleTextPadBinding bind(@NonNull View view) {
        ViewStub viewStub;
        ViewStub viewStub2;
        FrameLayout frameLayout = (FrameLayout)view;
        int n = R.id.island_content_stub;
        ViewStub viewStub3 = (ViewStub)ViewBindings.findChildViewById((View)view, (int)n);
        if (viewStub3 != null && (viewStub2 = (ViewStub)ViewBindings.findChildViewById((View)view, (int)(n = R.id.island_front_title_stub))) != null && (viewStub = (ViewStub)ViewBindings.findChildViewById((View)view, (int)(n = R.id.island_title_stub))) != null) {
            return new DynamicIslandModuleTextPadBinding(frameLayout, frameLayout, viewStub3, viewStub2, viewStub);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(n)));
    }

    @NonNull
    public static DynamicIslandModuleTextPadBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return DynamicIslandModuleTextPadBinding.inflate(layoutInflater, null, false);
    }

    @NonNull
    public static DynamicIslandModuleTextPadBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean bl) {
        layoutInflater = layoutInflater.inflate(R.layout.dynamic_island_module_text_pad, viewGroup, false);
        if (bl) {
            viewGroup.addView((View)layoutInflater);
        }
        return DynamicIslandModuleTextPadBinding.bind((View)layoutInflater);
    }

    @NonNull
    public FrameLayout getRoot() {
        return this.rootView;
    }
}
