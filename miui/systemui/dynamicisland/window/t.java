/*
 * Decompiled with CFR 0.152.
 */
package miui.systemui.dynamicisland.window;

import miui.systemui.dynamicisland.window.DynamicMiniWindowDataRepo;

public final class t
implements Runnable {
    public final DynamicMiniWindowDataRepo a;

    public /* synthetic */ t(DynamicMiniWindowDataRepo dynamicMiniWindowDataRepo) {
        this.a = dynamicMiniWindowDataRepo;
    }

    @Override
    public final void run() {
        DynamicMiniWindowDataRepo.a(this.a);
    }
}
