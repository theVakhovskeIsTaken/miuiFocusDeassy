/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  E0.e
 *  F0.a
 *  android.content.Context
 */
package miui.systemui.dynamicisland.events;

import E0.e;
import F0.a;
import android.content.Context;
import miui.systemui.dynamicisland.display.AntiBurnInManager;
import miui.systemui.dynamicisland.event.DynamicIslandEventCoordinator;
import miui.systemui.dynamicisland.events.DynamicIslandExposureManager;

public final class DynamicIslandExposureManager_Factory
implements e {
    private final a antiBurnInManProvider;
    private final a contextProvider;
    private final a eventCoordinatorProvider;

    public DynamicIslandExposureManager_Factory(a a2, a a3, a a4) {
        this.contextProvider = a2;
        this.eventCoordinatorProvider = a3;
        this.antiBurnInManProvider = a4;
    }

    public static DynamicIslandExposureManager_Factory create(a a2, a a3, a a4) {
        return new DynamicIslandExposureManager_Factory(a2, a3, a4);
    }

    public static DynamicIslandExposureManager newInstance(Context context, DynamicIslandEventCoordinator dynamicIslandEventCoordinator, AntiBurnInManager antiBurnInManager) {
        return new DynamicIslandExposureManager(context, dynamicIslandEventCoordinator, antiBurnInManager);
    }

    public DynamicIslandExposureManager get() {
        return DynamicIslandExposureManager_Factory.newInstance((Context)this.contextProvider.get(), (DynamicIslandEventCoordinator)this.eventCoordinatorProvider.get(), (AntiBurnInManager)this.antiBurnInManProvider.get());
    }
}
