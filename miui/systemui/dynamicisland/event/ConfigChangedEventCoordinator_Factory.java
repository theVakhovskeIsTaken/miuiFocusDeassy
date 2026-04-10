/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  E0.e
 *  F0.a
 */
package miui.systemui.dynamicisland.event;

import E0.e;
import F0.a;
import miui.systemui.dynamicisland.event.ConfigChangedEventCoordinator;
import miui.systemui.dynamicisland.event.DynamicIslandEventCoordinator;

public final class ConfigChangedEventCoordinator_Factory
implements e {
    private final a dynamicIslandEventCoordinatorProvider;

    public ConfigChangedEventCoordinator_Factory(a a2) {
        this.dynamicIslandEventCoordinatorProvider = a2;
    }

    public static ConfigChangedEventCoordinator_Factory create(a a2) {
        return new ConfigChangedEventCoordinator_Factory(a2);
    }

    public static ConfigChangedEventCoordinator newInstance(DynamicIslandEventCoordinator dynamicIslandEventCoordinator) {
        return new ConfigChangedEventCoordinator(dynamicIslandEventCoordinator);
    }

    public ConfigChangedEventCoordinator get() {
        return ConfigChangedEventCoordinator_Factory.newInstance((DynamicIslandEventCoordinator)this.dynamicIslandEventCoordinatorProvider.get());
    }
}
