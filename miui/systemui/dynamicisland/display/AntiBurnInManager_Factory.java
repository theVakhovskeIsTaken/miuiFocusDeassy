/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  D0.a
 *  E0.d
 *  E0.e
 *  F0.a
 *  android.content.Context
 *  f1.E
 *  miui.systemui.notification.NotificationSettingsManager
 */
package miui.systemui.dynamicisland.display;

import D0.a;
import E0.d;
import E0.e;
import android.content.Context;
import f1.E;
import miui.systemui.dynamicisland.display.AntiBurnInManager;
import miui.systemui.notification.NotificationSettingsManager;

public final class AntiBurnInManager_Factory
implements e {
    private final F0.a bigIslandStateHandlerProvider;
    private final F0.a contextProvider;
    private final F0.a scopeProvider;
    private final F0.a settingsManagerProvider;
    private final F0.a smallIslandStateHandlerProvider;

    public AntiBurnInManager_Factory(F0.a a2, F0.a a3, F0.a a4, F0.a a5, F0.a a6) {
        this.contextProvider = a2;
        this.bigIslandStateHandlerProvider = a3;
        this.smallIslandStateHandlerProvider = a4;
        this.scopeProvider = a5;
        this.settingsManagerProvider = a6;
    }

    public static AntiBurnInManager_Factory create(F0.a a2, F0.a a3, F0.a a4, F0.a a5, F0.a a6) {
        return new AntiBurnInManager_Factory(a2, a3, a4, a5, a6);
    }

    public static AntiBurnInManager newInstance(Context context, a a2, a a3, E e2, NotificationSettingsManager notificationSettingsManager) {
        return new AntiBurnInManager(context, a2, a3, e2, notificationSettingsManager);
    }

    public AntiBurnInManager get() {
        return AntiBurnInManager_Factory.newInstance((Context)this.contextProvider.get(), d.a((F0.a)this.bigIslandStateHandlerProvider), d.a((F0.a)this.smallIslandStateHandlerProvider), (E)this.scopeProvider.get(), (NotificationSettingsManager)this.settingsManagerProvider.get());
    }
}
