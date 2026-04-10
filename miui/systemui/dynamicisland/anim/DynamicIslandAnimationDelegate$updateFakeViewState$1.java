/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.graphics.Outline
 *  android.view.View
 *  android.view.ViewOutlineProvider
 *  kotlin.jvm.internal.o
 */
package miui.systemui.dynamicisland.anim;

import android.graphics.Outline;
import android.view.View;
import android.view.ViewOutlineProvider;
import kotlin.jvm.internal.o;
import miui.systemui.dynamicisland.R;
import miui.systemui.dynamicisland.anim.DynamicIslandAnimationDelegate;
import miui.systemui.dynamicisland.window.content.DynamicIslandBaseContentView;

public static final class DynamicIslandAnimationDelegate.updateFakeViewState.1
extends ViewOutlineProvider {
    final int $height;
    final int $left;
    final int $top;
    final int $width;
    final DynamicIslandAnimationDelegate this$0;

    public DynamicIslandAnimationDelegate.updateFakeViewState.1(int n, int n2, int n3, int n4, DynamicIslandAnimationDelegate dynamicIslandAnimationDelegate) {
        this.$left = n;
        this.$top = n2;
        this.$width = n3;
        this.$height = n4;
        this.this$0 = dynamicIslandAnimationDelegate;
    }

    public void getOutline(View object, Outline outline) {
        o.g((Object)object, (String)"view");
        o.g((Object)outline, (String)"outline");
        float f = object.getContext().getResources().getDimension(R.dimen.island_radius);
        int n = this.$left;
        int n2 = this.$top;
        outline.setRoundRect(n, n2, this.$width + n, this.$height + n2, f);
        object = this.this$0.getFakeView();
        if (object != null && (object = ((DynamicIslandBaseContentView)((Object)object)).getRoundedRect()) != null) {
            n = this.$left;
            f = n;
            n2 = this.$top;
            object.set(f, (float)n2, (float)(this.$width + n), (float)(this.$height + n2));
        }
    }
}
