/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  E0.e
 *  F0.a
 *  f1.E
 *  miui.systemui.controlcenter.data.repository.ControlCenterExpandRepository
 */
package miui.systemui.dynamicisland.domain.interactor;

import E0.e;
import F0.a;
import f1.E;
import miui.systemui.controlcenter.data.repository.ControlCenterExpandRepository;
import miui.systemui.dynamicisland.domain.interactor.DynamicIslandStateInteractor;
import miui.systemui.dynamicisland.window.DynamicIslandWindowViewController;

public final class DynamicIslandStateInteractor_Factory
implements e {
    private final a controlCenterExpandRepositoryProvider;
    private final a dynamicIslandWindowViewControllerProvider;
    private final a scopeProvider;

    public DynamicIslandStateInteractor_Factory(a a2, a a3, a a4) {
        this.scopeProvider = a2;
        this.dynamicIslandWindowViewControllerProvider = a3;
        this.controlCenterExpandRepositoryProvider = a4;
    }

    public static DynamicIslandStateInteractor_Factory create(a a2, a a3, a a4) {
        return new DynamicIslandStateInteractor_Factory(a2, a3, a4);
    }

    public static DynamicIslandStateInteractor newInstance(E e2, DynamicIslandWindowViewController dynamicIslandWindowViewController, ControlCenterExpandRepository controlCenterExpandRepository) {
        return new DynamicIslandStateInteractor(e2, dynamicIslandWindowViewController, controlCenterExpandRepository);
    }

    public DynamicIslandStateInteractor get() {
        return DynamicIslandStateInteractor_Factory.newInstance((E)this.scopeProvider.get(), (DynamicIslandWindowViewController)this.dynamicIslandWindowViewControllerProvider.get(), (ControlCenterExpandRepository)this.controlCenterExpandRepositoryProvider.get());
    }
}
