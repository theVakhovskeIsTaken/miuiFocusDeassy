/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  com.android.systemui.settings.UserTracker$Callback
 *  kotlin.jvm.internal.o
 */
package miui.systemui.dynamicisland.window;

import android.content.Context;
import com.android.systemui.settings.UserTracker;
import kotlin.jvm.internal.o;
import miui.systemui.dynamicisland.window.AppLockController;

public static final class AppLockController.userCallback.1
implements UserTracker.Callback {
    final AppLockController this$0;

    public AppLockController.userCallback.1(AppLockController appLockController) {
        this.this$0 = appLockController;
    }

    public void onUserChanged(int n, Context context) {
        o.g((Object)context, (String)"userContext");
        this.this$0.lockStateObserver.onChange(false);
    }
}
