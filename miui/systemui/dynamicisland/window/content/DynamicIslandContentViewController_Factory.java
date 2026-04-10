/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  F0.a
 *  K0.g
 *  f1.E
 *  miui.systemui.settings.data.repository.WorkBenchModeRepository
 */
package miui.systemui.dynamicisland.window.content;

import F0.a;
import K0.g;
import f1.E;
import miui.systemui.dynamicisland.domain.interactor.DynamicIslandRegionSamplingInteractor;
import miui.systemui.dynamicisland.events.DynamicIslandExposureManager;
import miui.systemui.dynamicisland.template.IslandTemplateFactory;
import miui.systemui.dynamicisland.touch.domain.interactor.DynamicIslandTouchInteractor;
import miui.systemui.dynamicisland.window.DynamicIslandWindowView;
import miui.systemui.dynamicisland.window.content.DynamicIslandContentView;
import miui.systemui.dynamicisland.window.content.DynamicIslandContentViewController;
import miui.systemui.settings.data.repository.WorkBenchModeRepository;

public final class DynamicIslandContentViewController_Factory {
    private final a expoManagerProvider;
    private final a islandTemplateFactoryProvider;
    private final a regionSamplingInteractorProvider;
    private final a scopeProvider;
    private final a touchInteractorProvider;
    private final a uiContextProvider;
    private final a windowViewProvider;
    private final a workBenchModeRepositoryProvider;

    public DynamicIslandContentViewController_Factory(a a2, a a3, a a4, a a5, a a6, a a7, a a8, a a9) {
        this.scopeProvider = a2;
        this.uiContextProvider = a3;
        this.windowViewProvider = a4;
        this.regionSamplingInteractorProvider = a5;
        this.islandTemplateFactoryProvider = a6;
        this.touchInteractorProvider = a7;
        this.expoManagerProvider = a8;
        this.workBenchModeRepositoryProvider = a9;
    }

    public static DynamicIslandContentViewController_Factory create(a a2, a a3, a a4, a a5, a a6, a a7, a a8, a a9) {
        return new DynamicIslandContentViewController_Factory(a2, a3, a4, a5, a6, a7, a8, a9);
    }

    public static DynamicIslandContentViewController newInstance(DynamicIslandContentView dynamicIslandContentView, E e, g g2, DynamicIslandWindowView dynamicIslandWindowView, DynamicIslandRegionSamplingInteractor dynamicIslandRegionSamplingInteractor, IslandTemplateFactory islandTemplateFactory, DynamicIslandTouchInteractor dynamicIslandTouchInteractor, DynamicIslandExposureManager dynamicIslandExposureManager, WorkBenchModeRepository workBenchModeRepository) {
        return new DynamicIslandContentViewController(dynamicIslandContentView, e, g2, dynamicIslandWindowView, dynamicIslandRegionSamplingInteractor, islandTemplateFactory, dynamicIslandTouchInteractor, dynamicIslandExposureManager, workBenchModeRepository);
    }

    public DynamicIslandContentViewController get(DynamicIslandContentView dynamicIslandContentView) {
        return DynamicIslandContentViewController_Factory.newInstance(dynamicIslandContentView, (E)this.scopeProvider.get(), (g)this.uiContextProvider.get(), (DynamicIslandWindowView)((Object)this.windowViewProvider.get()), (DynamicIslandRegionSamplingInteractor)this.regionSamplingInteractorProvider.get(), (IslandTemplateFactory)this.islandTemplateFactoryProvider.get(), (DynamicIslandTouchInteractor)this.touchInteractorProvider.get(), (DynamicIslandExposureManager)this.expoManagerProvider.get(), (WorkBenchModeRepository)this.workBenchModeRepositoryProvider.get());
    }
}
