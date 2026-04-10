/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.ViewGroup
 *  android.widget.ImageView
 *  android.widget.LinearLayout
 *  android.widget.TextView
 *  androidx.annotation.NonNull
 *  androidx.annotation.Nullable
 *  androidx.viewbinding.ViewBinding
 *  androidx.viewbinding.ViewBindings
 */
package miui.systemui.dynamicisland.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import miui.systemui.dynamicisland.R;

public final class DynamicIslandShareViewBinding
implements ViewBinding {
    @NonNull
    private final LinearLayout rootView;
    @NonNull
    public final TextView shareContent;
    @NonNull
    public final ImageView shareIcon;
    @NonNull
    public final TextView shareTitle;

    private DynamicIslandShareViewBinding(@NonNull LinearLayout linearLayout, @NonNull TextView textView, @NonNull ImageView imageView, @NonNull TextView textView2) {
        this.rootView = linearLayout;
        this.shareContent = textView;
        this.shareIcon = imageView;
        this.shareTitle = textView2;
    }

    @NonNull
    public static DynamicIslandShareViewBinding bind(@NonNull View view) {
        TextView textView;
        ImageView imageView;
        int n = R.id.share_content;
        TextView textView2 = (TextView)ViewBindings.findChildViewById((View)view, (int)n);
        if (textView2 != null && (imageView = (ImageView)ViewBindings.findChildViewById((View)view, (int)(n = R.id.share_icon))) != null && (textView = (TextView)ViewBindings.findChildViewById((View)view, (int)(n = R.id.share_title))) != null) {
            return new DynamicIslandShareViewBinding((LinearLayout)view, textView2, imageView, textView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(n)));
    }

    @NonNull
    public static DynamicIslandShareViewBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return DynamicIslandShareViewBinding.inflate(layoutInflater, null, false);
    }

    @NonNull
    public static DynamicIslandShareViewBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean bl) {
        layoutInflater = layoutInflater.inflate(R.layout.dynamic_island_share_view, viewGroup, false);
        if (bl) {
            viewGroup.addView((View)layoutInflater);
        }
        return DynamicIslandShareViewBinding.bind((View)layoutInflater);
    }

    @NonNull
    public LinearLayout getRoot() {
        return this.rootView;
    }
}
