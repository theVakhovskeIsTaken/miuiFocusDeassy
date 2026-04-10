/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.Outline
 *  android.view.View
 *  android.view.ViewOutlineProvider
 */
package miui.systemui.dynamicisland.module;

import android.content.Context;
import android.graphics.Outline;
import android.view.View;
import android.view.ViewOutlineProvider;
import miui.systemui.dynamicisland.R;

public static final class IslandIconViewHolder.roundedCornerOutlineProvider.1
extends ViewOutlineProvider {
    private final float cornerRadius;

    public IslandIconViewHolder.roundedCornerOutlineProvider.1(Context context) {
        this.cornerRadius = context.getResources().getDimension(R.dimen.island_icon_radius);
    }

    public void getOutline(View view, Outline outline) {
        if (outline != null && view != null) {
            outline.setRoundRect(0, 0, view.getWidth(), view.getHeight(), this.cornerRadius);
        }
    }
}
