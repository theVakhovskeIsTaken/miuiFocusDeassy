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
import miui.systemui.dynamicisland.event.DynamicIslandEventCoordinator;
import miui.systemui.dynamicisland.event.IslandTempHiddenEventCoordinator;

public final class IslandTempHiddenEventCoordinator_Factory
implements e {
    private final a dynamicIslandEventCoordinatorProvider;

    public IslandTempHiddenEventCoordinator_Factory(a a2) {
        this.dynamicIslandEventCoordinatorProvider = a2;
    }

    public static IslandTempHiddenEventCoordinator_Factory create(a a2) {
        return new IslandTempHiddenEventCoordinator_Factory(a2);
    }

    public static IslandTempHiddenEventCoordinator newInstance(DynamicIslandEventCoordinator dynamicIslandEventCoordinator) {
        return new IslandTempHiddenEventCoordinator(dynamicIslandEventCoordinator);
    }

    public IslandTempHiddenEventCoordinator get() {
        return IslandTempHiddenEventCoordinator_Factory.newInstance((DynamicIslandEventCoordinator)this.dynamicIslandEventCoordinatorProvider.get());
    }
}
