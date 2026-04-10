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
import miui.systemui.dynamicisland.event.CollapseEventCoordinator;
import miui.systemui.dynamicisland.event.DynamicIslandEventCoordinator;

public final class CollapseEventCoordinator_Factory
implements e {
    private final a dynamicIslandEventCoordinatorProvider;

    public CollapseEventCoordinator_Factory(a a2) {
        this.dynamicIslandEventCoordinatorProvider = a2;
    }

    public static CollapseEventCoordinator_Factory create(a a2) {
        return new CollapseEventCoordinator_Factory(a2);
    }

    public static CollapseEventCoordinator newInstance(DynamicIslandEventCoordinator dynamicIslandEventCoordinator) {
        return new CollapseEventCoordinator(dynamicIslandEventCoordinator);
    }

    public CollapseEventCoordinator get() {
        return CollapseEventCoordinator_Factory.newInstance((DynamicIslandEventCoordinator)this.dynamicIslandEventCoordinatorProvider.get());
    }
}
