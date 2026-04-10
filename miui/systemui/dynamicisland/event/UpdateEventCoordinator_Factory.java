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
import miui.systemui.dynamicisland.event.UpdateEventCoordinator;

public final class UpdateEventCoordinator_Factory
implements e {
    private final a dynamicIslandEventCoordinatorProvider;

    public UpdateEventCoordinator_Factory(a a2) {
        this.dynamicIslandEventCoordinatorProvider = a2;
    }

    public static UpdateEventCoordinator_Factory create(a a2) {
        return new UpdateEventCoordinator_Factory(a2);
    }

    public static UpdateEventCoordinator newInstance(DynamicIslandEventCoordinator dynamicIslandEventCoordinator) {
        return new UpdateEventCoordinator(dynamicIslandEventCoordinator);
    }

    public UpdateEventCoordinator get() {
        return UpdateEventCoordinator_Factory.newInstance((DynamicIslandEventCoordinator)this.dynamicIslandEventCoordinatorProvider.get());
    }
}
