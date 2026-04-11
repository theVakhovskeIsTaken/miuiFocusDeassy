/*
 * Decompiled with CFR 0.152.
 */
package miui.systemui.notification.focus.moduleV3;

import miui.systemui.notification.focus.moduleV3.ModuleTinyAnimationTextViewHolder;

public final class v
implements Runnable {
    public final ModuleTinyAnimationTextViewHolder a;

    public /* synthetic */ v(ModuleTinyAnimationTextViewHolder moduleTinyAnimationTextViewHolder) {
        this.a = moduleTinyAnimationTextViewHolder;
    }

    @Override
    public final void run() {
        ModuleTinyAnimationTextViewHolder.initView.1.b(this.a);
    }
}
