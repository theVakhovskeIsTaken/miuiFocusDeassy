/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.graphics.Outline
 *  android.graphics.Rect
 *  android.view.View
 *  android.view.ViewOutlineProvider
 *  kotlin.jvm.internal.o
 */
package miui.systemui.dynamicisland.window.content;

import android.graphics.Outline;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewOutlineProvider;
import kotlin.jvm.internal.o;

public static final class DynamicIslandContentView.updateExpandViewBlur.1.1
extends ViewOutlineProvider {
    final int $bottom;

    public DynamicIslandContentView.updateExpandViewBlur.1.1(int n) {
        this.$bottom = n;
    }

    public void getOutline(View view, Outline outline) {
        o.g((Object)view, (String)"view");
        o.g((Object)outline, (String)"outline");
        view.getRenderNode().setPosition(new Rect(view.getLeft(), view.getTop(), view.getRight(), this.$bottom));
        outline.setRoundRect(0, 0, view.getRight(), this.$bottom, 0.0f);
    }
}
