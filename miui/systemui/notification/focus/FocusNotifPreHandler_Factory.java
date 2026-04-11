/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  E0.e
 *  F0.a
 *  android.content.Context
 *  com.android.systemui.plugins.ActivityStarter
 *  miui.systemui.controlcenter.data.repository.ControlCenterExpandRepository
 *  miui.systemui.notification.NotificationSettingsManager
 */
package miui.systemui.notification.focus;

import E0.e;
import F0.a;
import android.content.Context;
import com.android.systemui.plugins.ActivityStarter;
import miui.systemui.controlcenter.data.repository.ControlCenterExpandRepository;
import miui.systemui.notification.NotificationSettingsManager;
import miui.systemui.notification.focus.FocusNotifPreHandler;
import miui.systemui.notification.focus.FocusNotifUtils;
import miui.systemui.notification.focus.templateV3.TemplateFactoryV3;

public final class FocusNotifPreHandler_Factory
implements e {
    private final a activityStarterProvider;
    private final a contextProvider;
    private final a controlCenterExpandRepositoryProvider;
    private final a factoryV3Provider;
    private final a settingsManagerProvider;
    private final a utilsProvider;

    public FocusNotifPreHandler_Factory(a a2, a a3, a a4, a a5, a a6, a a7) {
        this.settingsManagerProvider = a2;
        this.contextProvider = a3;
        this.activityStarterProvider = a4;
        this.factoryV3Provider = a5;
        this.utilsProvider = a6;
        this.controlCenterExpandRepositoryProvider = a7;
    }

    public static FocusNotifPreHandler_Factory create(a a2, a a3, a a4, a a5, a a6, a a7) {
        return new FocusNotifPreHandler_Factory(a2, a3, a4, a5, a6, a7);
    }

    public static FocusNotifPreHandler newInstance(NotificationSettingsManager notificationSettingsManager, Context context, ActivityStarter activityStarter, TemplateFactoryV3 templateFactoryV3, FocusNotifUtils focusNotifUtils, ControlCenterExpandRepository controlCenterExpandRepository) {
        return new FocusNotifPreHandler(notificationSettingsManager, context, activityStarter, templateFactoryV3, focusNotifUtils, controlCenterExpandRepository);
    }

    public FocusNotifPreHandler get() {
        return FocusNotifPreHandler_Factory.newInstance((NotificationSettingsManager)this.settingsManagerProvider.get(), (Context)this.contextProvider.get(), (ActivityStarter)this.activityStarterProvider.get(), (TemplateFactoryV3)this.factoryV3Provider.get(), (FocusNotifUtils)this.utilsProvider.get(), (ControlCenterExpandRepository)this.controlCenterExpandRepositoryProvider.get());
    }
}
