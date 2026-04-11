/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.Notification
 *  android.content.Context
 *  android.service.notification.StatusBarNotification
 *  android.util.Log
 *  com.android.systemui.plugins.NotificationListenerController$NotificationProvider
 *  com.android.systemui.plugins.miui.notification.FocusNotificationContent
 *  com.android.systemui.plugins.miui.notification.NotificationDynamicIslandPlugin$FocusInflationCallback
 *  kotlin.jvm.internal.o
 *  miui.systemui.dynamicisland.window.DynamicIslandWindowViewController$DynamicIslandCallback
 */
package miui.systemui.notification.focus;

import android.app.Notification;
import android.content.Context;
import android.service.notification.StatusBarNotification;
import android.util.Log;
import com.android.systemui.plugins.NotificationListenerController;
import com.android.systemui.plugins.miui.notification.FocusNotificationContent;
import com.android.systemui.plugins.miui.notification.NotificationDynamicIslandPlugin;
import java.util.AbstractMap;
import java.util.HashMap;
import java.util.Map;
import kotlin.jvm.internal.o;
import miui.systemui.dynamicisland.window.DynamicIslandWindowViewController;
import miui.systemui.notification.focus.FocusNotificationController;

public static final class FocusNotificationController.addDynamicIslandView.1
implements DynamicIslandWindowViewController.DynamicIslandCallback {
    final FocusNotificationController this$0;

    public FocusNotificationController.addDynamicIslandView.1(FocusNotificationController focusNotificationController) {
        this.this$0 = focusNotificationController;
    }

    public void onDynamicIslandConfigChange() {
        Object object = new HashMap(this.this$0.islandShowingMap);
        FocusNotificationController focusNotificationController = this.this$0;
        for (Map.Entry entry : object.entrySet()) {
            Object object2;
            Notification notification;
            if (focusNotificationController.islandTimeoutRemovedList.contains(entry.getKey())) continue;
            object = (FocusNotificationContent)focusNotificationController.notificationMap.get(entry.getKey());
            object = object != null ? object.getSbn() : null;
            if (object != null && (notification = object.getNotification()) != null && (notification = notification.extras) != null) {
                notification.putBoolean("miui.island.updateNoFloat", true);
            }
            notification = (NotificationDynamicIslandPlugin.FocusInflationCallback)focusNotificationController.callbackMap.get(entry.getKey());
            focusNotificationController.getNotificationChronometerManager().saveTempTimeKeeperStatus((StatusBarNotification)object);
            FocusNotificationController.onNotificationRemoved$default(focusNotificationController, (StatusBarNotification)object, false, 2, null);
            if (object != null && (object2 = object.getKey()) != null) {
                o.d((Object)object2);
                object2 = (Long)((AbstractMap)focusNotificationController.focusNotifUtils.getMaxSeq()).remove(object2);
            }
            if (notification != null) {
                object2 = focusNotificationController.callbackMap;
                Object k = entry.getKey();
                o.f(k, (String)"<get-key>(...)");
                NotificationDynamicIslandPlugin.FocusInflationCallback focusInflationCallback = (NotificationDynamicIslandPlugin.FocusInflationCallback)object2.put(k, notification);
            }
            if (object == null) continue;
            Context context = focusNotificationController.context;
            object2 = focusNotificationController.sysuiCtx;
            o.d((Object)object2);
            notification = focusNotificationController.mProvider;
            o.d((Object)notification);
            focusNotificationController.onNotificationPosted((StatusBarNotification)object, context, (Context)object2, (NotificationListenerController.NotificationProvider)notification);
        }
    }

    public void onDynamicIslandTimeoutRemoved(String string) {
        o.g((Object)string, (String)"key");
        boolean bl = this.this$0.notificationMap.get(string) != null;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("onDynamicIslandTimeoutRemoved, key=");
        stringBuilder.append(string);
        stringBuilder.append(", hasFocusNotification=");
        stringBuilder.append(bl);
        Log.e((String)"FocusPlugin", (String)stringBuilder.toString());
        if (bl) {
            this.this$0.islandTimeoutRemovedList.add(string);
        } else {
            this.this$0.removeByKey(string);
        }
    }

    public void removeNotification(StatusBarNotification statusBarNotification) {
        o.g((Object)statusBarNotification, (String)"sbn");
        NotificationListenerController.NotificationProvider notificationProvider = this.this$0.mProvider;
        if (notificationProvider != null) {
            notificationProvider.removeNotification(statusBarNotification);
        }
    }
}
