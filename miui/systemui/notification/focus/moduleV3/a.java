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
import miui.systemui.notification.focus.moduleV3.ModuleAnimationTextViewHolder;

public final class a
implements H {
    public final ModuleAnimationTextViewHolder a;
    public final Template b;

    public /* synthetic */ a(ModuleAnimationTextViewHolder moduleAnimationTextViewHolder, Template template) {
        this.a = moduleAnimationTextViewHolder;
        this.b = template;
    }

    public final void onResult(Object object) {
        ModuleAnimationTextViewHolder.c(this.a, this.b, (h)object);
    }
}
