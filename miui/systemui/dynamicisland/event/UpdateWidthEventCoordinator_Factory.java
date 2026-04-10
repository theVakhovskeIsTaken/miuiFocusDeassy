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
import miui.systemui.dynamicisland.event.UpdateWidthEventCoordinator;

public final class UpdateWidthEventCoordinator_Factory
implements e {
    private final a dynamicIslandEventCoordinatorProvider;

    public UpdateWidthEventCoordinator_Factory(a a2) {
        this.dynamicIslandEventCoordinatorProvider = a2;
    }

    public static UpdateWidthEventCoordinator_Factory create(a a2) {
        return new UpdateWidthEventCoordinator_Factory(a2);
    }

    public static UpdateWidthEventCoordinator newInstance(DynamicIslandEventCoordinator dynamicIslandEventCoordinator) {
        return new UpdateWidthEventCoordinator(dynamicIslandEventCoordinator);
    }

    public UpdateWidthEventCoordinator get() {
        return UpdateWidthEventCoordinator_Factory.newInstance((DynamicIslandEventCoordinator)this.dynamicIslandEventCoordinatorProvider.get());
    }
}
