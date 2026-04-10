/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.service.notification.StatusBarNotification
 */
package miui.systemui.dynamicisland.window;

import android.service.notification.StatusBarNotification;

public static interface DynamicIslandWindowViewController.DynamicIslandCallback {
    public void onDynamicIslandConfigChange();

    public void onDynamicIslandTimeoutRemoved(String var1);

    public void removeNotification(StatusBarNotification var1);
}
