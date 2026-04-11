/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.graphics.Outline
 *  android.view.View
 *  android.view.ViewOutlineProvider
 */
package miui.systemui.notification.focus.moduleV3.ext;

import android.graphics.Outline;
import android.view.View;
import android.view.ViewOutlineProvider;

public static final class ModuleViewHolderExtKt.roundedCornerOutlineProvider.1
extends ViewOutlineProvider {
    final float $cornerRadius;

    public ModuleViewHolderExtKt.roundedCornerOutlineProvider.1(float f) {
        this.$cornerRadius = f;
    }

    public void getOutline(View view, Outline outline) {
        if (outline != null && view != null) {
            outline.setRoundRect(0, 0, view.getWidth(), view.getHeight(), this.$cornerRadius);
        }
    }
}
