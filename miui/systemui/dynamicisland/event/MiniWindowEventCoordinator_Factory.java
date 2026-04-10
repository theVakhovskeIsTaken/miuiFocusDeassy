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
import miui.systemui.dynamicisland.event.MiniWindowEventCoordinator;

public final class MiniWindowEventCoordinator_Factory
implements e {
    private final a dynamicIslandEventCoordinatorProvider;

    public MiniWindowEventCoordinator_Factory(a a2) {
        this.dynamicIslandEventCoordinatorProvider = a2;
    }

    public static MiniWindowEventCoordinator_Factory create(a a2) {
        return new MiniWindowEventCoordinator_Factory(a2);
    }

    public static MiniWindowEventCoordinator newInstance(DynamicIslandEventCoordinator dynamicIslandEventCoordinator) {
        return new MiniWindowEventCoordinator(dynamicIslandEventCoordinator);
    }

    public MiniWindowEventCoordinator get() {
        return MiniWindowEventCoordinator_Factory.newInstance((DynamicIslandEventCoordinator)this.dynamicIslandEventCoordinatorProvider.get());
    }
}
