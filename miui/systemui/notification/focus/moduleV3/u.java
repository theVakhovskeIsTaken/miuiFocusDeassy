/*
 * Decompiled with CFR 0.152.
 */
package miui.systemui.notification.focus.moduleV3;

import miui.systemui.notification.focus.moduleV3.ModuleTinyAnimationTextViewHolder;

public final class u
implements Runnable {
    public final ModuleTinyAnimationTextViewHolder a;

    public /* synthetic */ u(ModuleTinyAnimationTextViewHolder moduleTinyAnimationTextViewHolder) {
        this.a = moduleTinyAnimationTextViewHolder;
    }

    @Override
    public final void run() {
        ModuleTinyAnimationTextViewHolder.initView.1.c(this.a);
    }
}
