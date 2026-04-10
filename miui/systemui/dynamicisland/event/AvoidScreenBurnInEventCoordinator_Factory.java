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
import miui.systemui.dynamicisland.event.AvoidScreenBurnInEventCoordinator;
import miui.systemui.dynamicisland.event.DynamicIslandEventCoordinator;

public final class AvoidScreenBurnInEventCoordinator_Factory
implements e {
    private final a dynamicIslandEventCoordinatorProvider;

    public AvoidScreenBurnInEventCoordinator_Factory(a a2) {
        this.dynamicIslandEventCoordinatorProvider = a2;
    }

    public static AvoidScreenBurnInEventCoordinator_Factory create(a a2) {
        return new AvoidScreenBurnInEventCoordinator_Factory(a2);
    }

    public static AvoidScreenBurnInEventCoordinator newInstance(DynamicIslandEventCoordinator dynamicIslandEventCoordinator) {
        return new AvoidScreenBurnInEventCoordinator(dynamicIslandEventCoordinator);
    }

    public AvoidScreenBurnInEventCoordinator get() {
        return AvoidScreenBurnInEventCoordinator_Factory.newInstance((DynamicIslandEventCoordinator)this.dynamicIslandEventCoordinatorProvider.get());
    }
}
