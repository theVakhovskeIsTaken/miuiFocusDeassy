/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  d.H
 *  d.h
 */
package miui.systemui.notification.focus.moduleV3;

import d.H;
import d.h;
import miui.systemui.notification.focus.model.Template;
import miui.systemui.notification.focus.moduleV3.ModuleDecoLandAnimationTextViewHolder;

public final class f
implements H {
    public final ModuleDecoLandAnimationTextViewHolder a;
    public final Template b;

    public /* synthetic */ f(ModuleDecoLandAnimationTextViewHolder moduleDecoLandAnimationTextViewHolder, Template template) {
        this.a = moduleDecoLandAnimationTextViewHolder;
        this.b = template;
    }

    public final void onResult(Object object) {
        ModuleDecoLandAnimationTextViewHolder.c(this.a, this.b, (h)object);
    }
}
