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
import miui.systemui.dynamicisland.event.AddEventCoordinator;
import miui.systemui.dynamicisland.event.DynamicIslandEventCoordinator;

public final class AddEventCoordinator_Factory
implements e {
    private final a dynamicIslandEventCoordinatorProvider;

    public AddEventCoordinator_Factory(a a2) {
        this.dynamicIslandEventCoordinatorProvider = a2;
    }

    public static AddEventCoordinator_Factory create(a a2) {
        return new AddEventCoordinator_Factory(a2);
    }

    public static AddEventCoordinator newInstance(DynamicIslandEventCoordinator dynamicIslandEventCoordinator) {
        return new AddEventCoordinator(dynamicIslandEventCoordinator);
    }

    public AddEventCoordinator get() {
        return AddEventCoordinator_Factory.newInstance((DynamicIslandEventCoordinator)this.dynamicIslandEventCoordinatorProvider.get());
    }
}
