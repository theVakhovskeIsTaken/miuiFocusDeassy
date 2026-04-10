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

public final class DynamicIslandModuleRightTextBinding
implements ViewBinding {
    @NonNull
    public final FrameLayout islandContainerModuleRightText;
    @NonNull
    public final ViewStub islandContentStub;
    @NonNull
    public final ViewStub islandFrontTitleStub;
    @NonNull
    public final View islandTextShade;
    @NonNull
    public final ViewStub islandTitleStub;
    @NonNull
    private final FrameLayout rootView;

    private DynamicIslandModuleRightTextBinding(@NonNull FrameLayout frameLayout, @NonNull FrameLayout frameLayout2, @NonNull ViewStub viewStub, @NonNull ViewStub viewStub2, @NonNull View view, @NonNull ViewStub viewStub3) {
        this.rootView = frameLayout;
        this.islandContainerModuleRightText = frameLayout2;
        this.islandContentStub = viewStub;
        this.islandFrontTitleStub = viewStub2;
        this.islandTextShade = view;
        this.islandTitleStub = viewStub3;
    }

    @NonNull
    public static DynamicIslandModuleRightTextBinding bind(@NonNull View view) {
        ViewStub viewStub;
        View view2;
        ViewStub viewStub2;
        FrameLayout frameLayout = (FrameLayout)view;
        int n = R.id.island_content_stub;
        ViewStub viewStub3 = (ViewStub)ViewBindings.findChildViewById((View)view, (int)n);
        if (viewStub3 != null && (viewStub2 = (ViewStub)ViewBindings.findChildViewById((View)view, (int)(n = R.id.island_front_title_stub))) != null && (view2 = ViewBindings.findChildViewById((View)view, (int)(n = R.id.island_text_shade))) != null && (viewStub = (ViewStub)ViewBindings.findChildViewById((View)view, (int)(n = R.id.island_title_stub))) != null) {
            return new DynamicIslandModuleRightTextBinding(frameLayout, frameLayout, viewStub3, viewStub2, view2, viewStub);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(n)));
    }

    @NonNull
    public static DynamicIslandModuleRightTextBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return DynamicIslandModuleRightTextBinding.inflate(layoutInflater, null, false);
    }

    @NonNull
    public static DynamicIslandModuleRightTextBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean bl) {
        layoutInflater = layoutInflater.inflate(R.layout.dynamic_island_module_right_text, viewGroup, false);
        if (bl) {
            viewGroup.addView((View)layoutInflater);
        }
        return DynamicIslandModuleRightTextBinding.bind((View)layoutInflater);
    }

    @NonNull
    public FrameLayout getRoot() {
        return this.rootView;
    }
}
