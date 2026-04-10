/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  E0.e
 *  F0.a
 *  miui.systemui.settings.data.repository.WorkBenchModeRepository
 */
package miui.systemui.dynamicisland.event;

import E0.e;
import F0.a;
import miui.systemui.dynamicisland.event.AppEventCoordinator;
import miui.systemui.dynamicisland.event.DynamicIslandEventCoordinator;
import miui.systemui.settings.data.repository.WorkBenchModeRepository;

public final class AppEventCoordinator_Factory
implements e {
    private final a dynamicIslandEventCoordinatorProvider;
    private final a workBenchModeRepositoryProvider;

    public AppEventCoordinator_Factory(a a2, a a3) {
        this.dynamicIslandEventCoordinatorProvider = a2;
        this.workBenchModeRepositoryProvider = a3;
    }

    public static AppEventCoordinator_Factory create(a a2, a a3) {
        return new AppEventCoordinator_Factory(a2, a3);
    }

    public static AppEventCoordinator newInstance(DynamicIslandEventCoordinator dynamicIslandEventCoordinator, WorkBenchModeRepository workBenchModeRepository) {
        return new AppEventCoordinator(dynamicIslandEventCoordinator, workBenchModeRepository);
    }

    public AppEventCoordinator get() {
        return AppEventCoordinator_Factory.newInstance((DynamicIslandEventCoordinator)this.dynamicIslandEventCoordinatorProvider.get(), (WorkBenchModeRepository)this.workBenchModeRepositoryProvider.get());
    }
}
