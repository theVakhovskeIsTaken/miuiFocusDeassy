/*
 * Decompiled with CFR 0.152.
 */
package miui.systemui.dynamicisland.window;

import miui.systemui.dynamicisland.window.AppLockController;

public final class b
implements Runnable {
    public final AppLockController.AppLockProvider a;

    public /* synthetic */ b(AppLockController.AppLockProvider appLockProvider) {
        this.a = appLockProvider;
    }

    @Override
    public final void run() {
        AppLockController.AppLockProvider.a(this.a);
    }
}
