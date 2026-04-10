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
import miui.systemui.dynamicisland.event.PanelExpandedEventCoordinator;

public final class PanelExpandedEventCoordinator_Factory
implements e {
    private final a dynamicIslandEventCoordinatorProvider;

    public PanelExpandedEventCoordinator_Factory(a a2) {
        this.dynamicIslandEventCoordinatorProvider = a2;
    }

    public static PanelExpandedEventCoordinator_Factory create(a a2) {
        return new PanelExpandedEventCoordinator_Factory(a2);
    }

    public static PanelExpandedEventCoordinator newInstance(DynamicIslandEventCoordinator dynamicIslandEventCoordinator) {
        return new PanelExpandedEventCoordinator(dynamicIslandEventCoordinator);
    }

    public PanelExpandedEventCoordinator get() {
        return PanelExpandedEventCoordinator_Factory.newInstance((DynamicIslandEventCoordinator)this.dynamicIslandEventCoordinatorProvider.get());
    }
}
