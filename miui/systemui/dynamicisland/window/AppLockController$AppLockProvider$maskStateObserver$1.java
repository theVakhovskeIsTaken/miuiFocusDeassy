/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.database.ContentObserver
 *  android.os.Handler
 */
package miui.systemui.dynamicisland.window;

import android.database.ContentObserver;
import android.os.Handler;
import miui.systemui.dynamicisland.window.AppLockController;

public static final class AppLockController.maskStateObserver.1
extends ContentObserver {
    final AppLockController.AppLockProvider this$0;
    final AppLockController this$1;

    public AppLockController.maskStateObserver.1(AppLockController.AppLockProvider appLockProvider, AppLockController appLockController, Handler handler) {
        this.this$0 = appLockProvider;
        this.this$1 = appLockController;
        super(handler);
    }

    public void onChange(boolean bl) {
        if (this.this$0.getMethod() != null && this.this$1.lockEnable) {
            AppLockController.AppLockProvider.refreshMaskMap$default(this.this$0, false, 1, null);
        }
    }
}
