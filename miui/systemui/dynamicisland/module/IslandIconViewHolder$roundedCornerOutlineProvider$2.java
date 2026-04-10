/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  U0.a
 *  android.content.Context
 *  android.graphics.Outline
 *  android.view.View
 *  android.view.ViewOutlineProvider
 *  kotlin.jvm.internal.p
 */
package miui.systemui.dynamicisland.module;

import U0.a;
import android.content.Context;
import android.graphics.Outline;
import android.view.View;
import android.view.ViewOutlineProvider;
import kotlin.jvm.internal.p;
import miui.systemui.dynamicisland.R;
import miui.systemui.dynamicisland.module.IslandIconViewHolder;

public static final class IslandIconViewHolder.roundedCornerOutlineProvider.2
extends p
implements a {
    final Context $context;

    public IslandIconViewHolder.roundedCornerOutlineProvider.2(Context context) {
        this.$context = context;
        super(0);
    }

    public final 1 invoke() {
        return new ViewOutlineProvider(this.$context){
            private final float cornerRadius;
            {
                this.cornerRadius = context.getResources().getDimension(R.dimen.island_icon_radius);
            }

            public void getOutline(View view, Outline outline) {
                if (outline != null && view != null) {
                    outline.setRoundRect(0, 0, view.getWidth(), view.getHeight(), this.cornerRadius);
                }
            }
        };
    }
}
