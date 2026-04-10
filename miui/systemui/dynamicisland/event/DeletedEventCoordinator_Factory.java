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
import miui.systemui.dynamicisland.event.DeletedEventCoordinator;
import miui.systemui.dynamicisland.event.DynamicIslandEventCoordinator;

public final class DeletedEventCoordinator_Factory
implements e {
    private final a dynamicIslandEventCoordinatorProvider;

    public DeletedEventCoordinator_Factory(a a2) {
        this.dynamicIslandEventCoordinatorProvider = a2;
    }

    public static DeletedEventCoordinator_Factory create(a a2) {
        return new DeletedEventCoordinator_Factory(a2);
    }

    public static DeletedEventCoordinator newInstance(DynamicIslandEventCoordinator dynamicIslandEventCoordinator) {
        return new DeletedEventCoordinator(dynamicIslandEventCoordinator);
    }

    public DeletedEventCoordinator get() {
        return DeletedEventCoordinator_Factory.newInstance((DynamicIslandEventCoordinator)this.dynamicIslandEventCoordinatorProvider.get());
    }
}
