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
import miui.systemui.notification.focus.moduleV3.ModuleDecoPortAnimationTextViewHolder;

public final class l
implements H {
    public final ModuleDecoPortAnimationTextViewHolder a;
    public final Template b;

    public /* synthetic */ l(ModuleDecoPortAnimationTextViewHolder moduleDecoPortAnimationTextViewHolder, Template template) {
        this.a = moduleDecoPortAnimationTextViewHolder;
        this.b = template;
    }

    public final void onResult(Object object) {
        ModuleDecoPortAnimationTextViewHolder.c(this.a, this.b, (h)object);
    }
}
