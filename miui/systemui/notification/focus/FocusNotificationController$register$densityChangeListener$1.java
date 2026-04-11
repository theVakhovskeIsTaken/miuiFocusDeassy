/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.Configuration
 *  android.service.notification.StatusBarNotification
 *  android.util.Log
 *  com.android.systemui.plugins.NotificationListenerController$NotificationProvider
 *  kotlin.jvm.internal.o
 *  miui.systemui.autodensity.AutoDensityController$OnDensityChangeListener
 */
package miui.systemui.notification.focus;

import android.content.Context;
import android.content.res.Configuration;
import android.service.notification.StatusBarNotification;
import android.util.Log;
import com.android.systemui.plugins.NotificationListenerController;
import kotlin.jvm.internal.o;
import miui.systemui.autodensity.AutoDensityController;
import miui.systemui.notification.focus.FocusNotificationController;

public static final class FocusNotificationController.register.densityChangeListener.1
implements AutoDensityController.OnDensityChangeListener {
    final FocusNotificationController this$0;

    public FocusNotificationController.register.densityChangeListener.1(FocusNotificationController focusNotificationController) {
        this.this$0 = focusNotificationController;
    }

    public void onConfigChanged(Configuration object) {
        o.g((Object)object, (String)"config");
        if (this.this$0.pluginCtx != null && this.this$0.sysuiCtx != null && this.this$0.mProvider != null) {
            boolean bl = object.isNightModeActive();
            if (this.this$0.isNightModeActiveOrigin() == bl) {
                Log.i((String)"FocusPlugin", (String)"uiMode is not change");
                return;
            }
            Log.i((String)"FocusPlugin", (String)"promoted notification uiMode change");
            this.this$0.setNightModeActiveOrigin(bl);
            StatusBarNotification statusBarNotification2 = this.this$0.sbnMap.values();
            object = this.this$0;
            for (StatusBarNotification statusBarNotification2 : statusBarNotification2) {
                if (!statusBarNotification2.getNotification().extras.getBoolean("miui.focus.isPromoted", false)) continue;
                Context context = ((FocusNotificationController)object).pluginCtx;
                o.d((Object)context);
                Context context2 = ((FocusNotificationController)object).sysuiCtx;
                o.d((Object)context2);
                NotificationListenerController.NotificationProvider notificationProvider = ((FocusNotificationController)object).mProvider;
                o.d((Object)notificationProvider);
                ((FocusNotificationController)object).onNotificationPosted(statusBarNotification2, context, context2, notificationProvider);
            }
            return;
        }
        Log.i((String)"FocusPlugin", (String)"context or provider is null: ");
    }
}
