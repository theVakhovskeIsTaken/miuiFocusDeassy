/*
 * Decompiled with CFR 0.152.
 */
package miui.systemui.dynamicisland.window;

import miui.systemui.dynamicisland.window.DynamicMiniWindowDataRepo;

public final class r
implements Runnable {
    public final DynamicMiniWindowDataRepo a;

    public /* synthetic */ r(DynamicMiniWindowDataRepo dynamicMiniWindowDataRepo) {
        this.a = dynamicMiniWindowDataRepo;
    }

    @Override
    public final void run() {
        DynamicMiniWindowDataRepo.c(this.a);
    }
}
