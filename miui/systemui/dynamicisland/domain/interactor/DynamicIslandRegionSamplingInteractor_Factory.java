/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  E0.e
 *  F0.a
 *  android.content.Context
 *  f1.E
 *  miui.systemui.controlcenter.data.repository.ControlCenterExpandRepository
 *  miui.systemui.handles.RegionSamplingHelperRefactor$Factory
 *  miui.systemui.statusbar.data.repository.StatusBarAreaRepository
 *  miui.systemui.statusbar.data.repository.StatusBarStateRepository
 */
package miui.systemui.dynamicisland.domain.interactor;

import E0.e;
import F0.a;
import android.content.Context;
import f1.E;
import miui.systemui.controlcenter.data.repository.ControlCenterExpandRepository;
import miui.systemui.dynamicisland.data.repository.DynamicIslandExternalStateRepository;
import miui.systemui.dynamicisland.domain.interactor.DynamicIslandRegionSamplingInteractor;
import miui.systemui.dynamicisland.window.DynamicIslandWindowView;
import miui.systemui.dynamicisland.window.domain.interactor.DynamicIslandWindowStateInteractor;
import miui.systemui.handles.RegionSamplingHelperRefactor;
import miui.systemui.statusbar.data.repository.StatusBarAreaRepository;
import miui.systemui.statusbar.data.repository.StatusBarStateRepository;

public final class DynamicIslandRegionSamplingInteractor_Factory
implements e {
    private final a contextProvider;
    private final a controlCenterExpandRepositoryProvider;
    private final a externalStateRepositoryProvider;
    private final a regionSamplingHelperFactoryProvider;
    private final a scopeProvider;
    private final a statusBarAreaRepositoryProvider;
    private final a statusBarStateRepositoryProvider;
    private final a windowStateInteractorProvider;
    private final a windowViewProvider;

    public DynamicIslandRegionSamplingInteractor_Factory(a a2, a a3, a a4, a a5, a a6, a a7, a a8, a a9, a a10) {
        this.scopeProvider = a2;
        this.windowViewProvider = a3;
        this.contextProvider = a4;
        this.windowStateInteractorProvider = a5;
        this.regionSamplingHelperFactoryProvider = a6;
        this.statusBarAreaRepositoryProvider = a7;
        this.statusBarStateRepositoryProvider = a8;
        this.controlCenterExpandRepositoryProvider = a9;
        this.externalStateRepositoryProvider = a10;
    }

    public static DynamicIslandRegionSamplingInteractor_Factory create(a a2, a a3, a a4, a a5, a a6, a a7, a a8, a a9, a a10) {
        return new DynamicIslandRegionSamplingInteractor_Factory(a2, a3, a4, a5, a6, a7, a8, a9, a10);
    }

    public static DynamicIslandRegionSamplingInteractor newInstance(E e2, DynamicIslandWindowView dynamicIslandWindowView, Context context, DynamicIslandWindowStateInteractor dynamicIslandWindowStateInteractor, RegionSamplingHelperRefactor.Factory factory, StatusBarAreaRepository statusBarAreaRepository, StatusBarStateRepository statusBarStateRepository, ControlCenterExpandRepository controlCenterExpandRepository, DynamicIslandExternalStateRepository dynamicIslandExternalStateRepository) {
        return new DynamicIslandRegionSamplingInteractor(e2, dynamicIslandWindowView, context, dynamicIslandWindowStateInteractor, factory, statusBarAreaRepository, statusBarStateRepository, controlCenterExpandRepository, dynamicIslandExternalStateRepository);
    }

    public DynamicIslandRegionSamplingInteractor get() {
        return DynamicIslandRegionSamplingInteractor_Factory.newInstance((E)this.scopeProvider.get(), (DynamicIslandWindowView)((Object)this.windowViewProvider.get()), (Context)this.contextProvider.get(), (DynamicIslandWindowStateInteractor)this.windowStateInteractorProvider.get(), (RegionSamplingHelperRefactor.Factory)this.regionSamplingHelperFactoryProvider.get(), (StatusBarAreaRepository)this.statusBarAreaRepositoryProvider.get(), (StatusBarStateRepository)this.statusBarStateRepositoryProvider.get(), (ControlCenterExpandRepository)this.controlCenterExpandRepositoryProvider.get(), (DynamicIslandExternalStateRepository)this.externalStateRepositoryProvider.get());
    }
}
