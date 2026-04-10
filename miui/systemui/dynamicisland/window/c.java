/*
 * Decompiled with CFR 0.152.
 */
package miui.systemui.dynamicisland.window;

import miui.systemui.dynamicisland.window.DynamicIslandDesktopStateController;

public final class c
implements Runnable {
    public final DynamicIslandDesktopStateController a;

    public /* synthetic */ c(DynamicIslandDesktopStateController dynamicIslandDesktopStateController) {
        this.a = dynamicIslandDesktopStateController;
    }

    @Override
    public final void run() {
        DynamicIslandDesktopStateController.a(this.a);
    }
}
