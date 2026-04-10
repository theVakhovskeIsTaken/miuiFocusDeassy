/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.util.Log
 *  miui.systemui.notification.TaskStackChangeListener
 */
package miui.systemui.dynamicisland.window;

import android.util.Log;
import miui.systemui.dynamicisland.window.DynamicIslandWindowViewController;
import miui.systemui.notification.TaskStackChangeListener;

public static final class DynamicIslandWindowViewController.taskStackListener.1
implements TaskStackChangeListener {
    final DynamicIslandWindowViewController this$0;

    public DynamicIslandWindowViewController.taskStackListener.1(DynamicIslandWindowViewController dynamicIslandWindowViewController) {
        this.this$0 = dynamicIslandWindowViewController;
    }

    public void onLockTaskModeChanged(int n) {
        Object object = this.this$0;
        boolean bl = false;
        boolean bl2 = n == 2;
        ((DynamicIslandWindowViewController)object).screenPinningActive(bl2);
        bl2 = bl;
        if (n == 2) {
            bl2 = true;
        }
        object = new StringBuilder();
        ((StringBuilder)object).append("onLockTaskModeChanged: screenPinningActive:");
        ((StringBuilder)object).append(bl2);
        Log.d((String)"DynamicIslandWindowViewController", (String)((StringBuilder)object).toString());
    }
}
