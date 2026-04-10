/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  F0.a
 *  f1.E
 *  miui.systemui.settings.data.repository.WorkBenchModeRepository
 */
package miui.systemui.dynamicisland.window.content;

import F0.a;
import f1.E;
import miui.systemui.dynamicisland.domain.interactor.DynamicIslandRegionSamplingInteractor;
import miui.systemui.dynamicisland.template.IslandTemplateFactory;
import miui.systemui.dynamicisland.touch.domain.interactor.DynamicIslandTouchInteractor;
import miui.systemui.dynamicisland.window.content.DynamicIslandBaseContentView;
import miui.systemui.dynamicisland.window.content.DynamicIslandBaseContentViewController;
import miui.systemui.settings.data.repository.WorkBenchModeRepository;

public final class DynamicIslandBaseContentViewController_Factory<T extends DynamicIslandBaseContentView> {
    private final a islandTemplateFactoryProvider;
    private final a regionSamplingInteractorProvider;
    private final a scopeProvider;
    private final a touchInteractorProvider;
    private final a workBenchModeRepositoryProvider;

    public DynamicIslandBaseContentViewController_Factory(a a2, a a3, a a4, a a5, a a6) {
        this.scopeProvider = a2;
        this.regionSamplingInteractorProvider = a3;
        this.islandTemplateFactoryProvider = a4;
        this.touchInteractorProvider = a5;
        this.workBenchModeRepositoryProvider = a6;
    }

    public static <T extends DynamicIslandBaseContentView> DynamicIslandBaseContentViewController_Factory<T> create(a a2, a a3, a a4, a a5, a a6) {
        return new DynamicIslandBaseContentViewController_Factory<T>(a2, a3, a4, a5, a6);
    }

    public static <T extends DynamicIslandBaseContentView> DynamicIslandBaseContentViewController<T> newInstance(T t, E e, DynamicIslandRegionSamplingInteractor dynamicIslandRegionSamplingInteractor, IslandTemplateFactory islandTemplateFactory, DynamicIslandTouchInteractor dynamicIslandTouchInteractor, WorkBenchModeRepository workBenchModeRepository) {
        return new DynamicIslandBaseContentViewController<T>(t, e, dynamicIslandRegionSamplingInteractor, islandTemplateFactory, dynamicIslandTouchInteractor, workBenchModeRepository);
    }

    public DynamicIslandBaseContentViewController<T> get(T t) {
        return DynamicIslandBaseContentViewController_Factory.newInstance(t, (E)this.scopeProvider.get(), (DynamicIslandRegionSamplingInteractor)this.regionSamplingInteractorProvider.get(), (IslandTemplateFactory)this.islandTemplateFactoryProvider.get(), (DynamicIslandTouchInteractor)this.touchInteractorProvider.get(), (WorkBenchModeRepository)this.workBenchModeRepositoryProvider.get());
    }
}
