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
import miui.systemui.notification.focus.moduleV3.ModuleTinyAnimationTextViewHolder;

public final class t
implements H {
    public final ModuleTinyAnimationTextViewHolder a;
    public final Template b;

    public /* synthetic */ t(ModuleTinyAnimationTextViewHolder moduleTinyAnimationTextViewHolder, Template template) {
        this.a = moduleTinyAnimationTextViewHolder;
        this.b = template;
    }

    public final void onResult(Object object) {
        ModuleTinyAnimationTextViewHolder.c(this.a, this.b, (h)object);
    }
}
