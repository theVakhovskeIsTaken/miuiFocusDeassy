/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.android.systemui.plugins.miui.notification.FocusNotificationContent
 */
package miui.systemui.notification.focus;

import com.android.systemui.plugins.miui.notification.FocusNotificationContent;

public interface InflateAndAuthCallBack {
    public void onAuthFailed(String var1, String var2);

    public void onAuthFinish(String var1, String var2);

    public void onAuthSuccess(String var1, String var2);

    public void onInflateFailed(String var1, FocusNotificationContent var2);

    public void onInflateFinish(String var1, FocusNotificationContent var2);

    public void onInflateSuccess(String var1, FocusNotificationContent var2);
}
