/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.android.systemui.plugins.miui.notification.FocusNotificationContent
 *  miui.systemui.notification.FullAodStatusManager
 */
package miui.systemui.notification.focus;

import com.android.systemui.plugins.miui.notification.FocusNotificationContent;
import miui.systemui.notification.FullAodStatusManager;

public final class FocusNotificationContentImpl
extends FocusNotificationContent {
    public static final Companion Companion = new Object(null){
        {
            this();
        }
    };
    private static final String TAG = "FocusNotificationContentImpl";

    public void updateFullAod(boolean bl) {
        FullAodStatusManager.INSTANCE.updateFullAod(bl);
    }
}
