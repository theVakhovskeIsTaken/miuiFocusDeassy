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
import miui.systemui.dynamicisland.event.ClickEventCoordinator;
import miui.systemui.dynamicisland.event.DynamicIslandEventCoordinator;

public final class ClickEventCoordinator_Factory
implements e {
    private final a dynamicIslandEventCoordinatorProvider;

    public ClickEventCoordinator_Factory(a a2) {
        this.dynamicIslandEventCoordinatorProvider = a2;
    }

    public static ClickEventCoordinator_Factory create(a a2) {
        return new ClickEventCoordinator_Factory(a2);
    }

    public static ClickEventCoordinator newInstance(DynamicIslandEventCoordinator dynamicIslandEventCoordinator) {
        return new ClickEventCoordinator(dynamicIslandEventCoordinator);
    }

    public ClickEventCoordinator get() {
        return ClickEventCoordinator_Factory.newInstance((DynamicIslandEventCoordinator)this.dynamicIslandEventCoordinatorProvider.get());
    }
}
