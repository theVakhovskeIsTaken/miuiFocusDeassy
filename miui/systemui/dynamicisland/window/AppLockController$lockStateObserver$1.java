/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  G0.j
 *  G0.k
 *  android.content.ContentResolver
 *  android.database.ContentObserver
 *  android.os.Handler
 *  android.provider.Settings$Secure
 *  android.util.Log
 */
package miui.systemui.dynamicisland.window;

import G0.j;
import G0.k;
import android.content.ContentResolver;
import android.database.ContentObserver;
import android.os.Handler;
import android.provider.Settings;
import android.util.Log;
import miui.systemui.dynamicisland.window.AppLockController;

public static final class AppLockController.lockStateObserver.1
extends ContentObserver {
    final AppLockController this$0;

    public AppLockController.lockStateObserver.1(AppLockController appLockController, Handler handler) {
        this.this$0 = appLockController;
        super(handler);
    }

    public void onChange(boolean bl) {
        Object object;
        AppLockController appLockController = this.this$0;
        try {
            object = j.a;
            object = j.a((Object)Settings.Secure.getIntForUser((ContentResolver)appLockController.context.getContentResolver(), (String)"access_control_lock_enabled", (int)-1, (int)appLockController.userTracker.getUserId()));
        }
        catch (Throwable throwable) {
            object = j.a;
            object = j.a((Object)k.a((Throwable)throwable));
        }
        if (j.b((Object)object) != null) {
            object = -1;
        }
        int n = ((Number)object).intValue();
        object = this.this$0;
        bl = true;
        if (n != 1) {
            bl = false;
        }
        ((AppLockController)object).lockEnable = bl;
        if (this.this$0.lockEnable) {
            this.this$0.provider.updateUser();
        } else {
            this.this$0.provider.clearCache();
        }
        int n2 = this.this$0.userTracker.getUserId();
        object = new StringBuilder();
        ((StringBuilder)object).append("onChange: ");
        ((StringBuilder)object).append(n);
        ((StringBuilder)object).append(" user = ");
        ((StringBuilder)object).append(n2);
        Log.d((String)"AppLockController", (String)((StringBuilder)object).toString());
    }
}
