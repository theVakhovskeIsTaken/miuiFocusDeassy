/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  E0.e
 *  F0.a
 *  miui.systemui.notification.NotificationSettingsManager
 *  miui.systemui.util.AlarmScheduler$Factory
 */
package miui.systemui.notification.focus;

import E0.e;
import F0.a;
import miui.systemui.notification.NotificationSettingsManager;
import miui.systemui.notification.focus.HideDeletedFocusController;
import miui.systemui.util.AlarmScheduler;

public final class HideDeletedFocusController_Factory
implements e {
    private final a alarmSchedulerFactoryProvider;
    private final a notificationSettingsManagerProvider;

    public HideDeletedFocusController_Factory(a a2, a a3) {
        this.alarmSchedulerFactoryProvider = a2;
        this.notificationSettingsManagerProvider = a3;
    }

    public static HideDeletedFocusController_Factory create(a a2, a a3) {
        return new HideDeletedFocusController_Factory(a2, a3);
    }

    public static HideDeletedFocusController newInstance(AlarmScheduler.Factory factory, NotificationSettingsManager notificationSettingsManager) {
        return new HideDeletedFocusController(factory, notificationSettingsManager);
    }

    public HideDeletedFocusController get() {
        return HideDeletedFocusController_Factory.newInstance((AlarmScheduler.Factory)this.alarmSchedulerFactoryProvider.get(), (NotificationSettingsManager)this.notificationSettingsManagerProvider.get());
    }
}
