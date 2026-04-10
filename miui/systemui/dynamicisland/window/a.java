/*
 * Decompiled with CFR 0.152.
 */
package miui.systemui.dynamicisland.window;

import miui.systemui.dynamicisland.window.AppLockController;

public final class a
implements Runnable {
    public final AppLockController a;

    public /* synthetic */ a(AppLockController appLockController) {
        this.a = appLockController;
    }

    @Override
    public final void run() {
        AppLockController.a(this.a);
    }
}
