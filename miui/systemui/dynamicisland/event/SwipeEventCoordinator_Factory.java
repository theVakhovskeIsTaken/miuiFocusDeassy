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
import miui.systemui.dynamicisland.event.SwipeEventCoordinator;

public final class SwipeEventCoordinator_Factory
implements e {
    private final a dynamicIslandEventCoordinatorProvider;

    public SwipeEventCoordinator_Factory(a a2) {
        this.dynamicIslandEventCoordinatorProvider = a2;
    }

    public static SwipeEventCoordinator_Factory create(a a2) {
        return new SwipeEventCoordinator_Factory(a2);
    }

    public static SwipeEventCoordinator newInstance(DynamicIslandEventCoordinator dynamicIslandEventCoordinator) {
        return new SwipeEventCoordinator(dynamicIslandEventCoordinator);
    }

    public SwipeEventCoordinator get() {
        return SwipeEventCoordinator_Factory.newInstance((DynamicIslandEventCoordinator)this.dynamicIslandEventCoordinatorProvider.get());
    }
}
