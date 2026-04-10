/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  E0.e
 *  F0.a
 *  f1.E
 */
package miui.systemui.dynamicisland.window.domain.interactor;

import E0.e;
import F0.a;
import f1.E;
import miui.systemui.dynamicisland.event.DynamicIslandEventCoordinator;
import miui.systemui.dynamicisland.window.DynamicIslandWindowViewController;
import miui.systemui.dynamicisland.window.domain.interactor.DynamicIslandWindowStateInteractor;
import miui.systemui.dynamicisland.window.domain.interactor.DynamicIslandWindowViewTouchInteractor;

public final class DynamicIslandWindowStateInteractor_Factory
implements e {
    private final a eventCoordinatorProvider;
    private final a scopeProvider;
    private final a windowViewControllerProvider;
    private final a windowViewTouchInteractorProvider;

    public DynamicIslandWindowStateInteractor_Factory(a a2, a a3, a a4, a a5) {
        this.scopeProvider = a2;
        this.eventCoordinatorProvider = a3;
        this.windowViewControllerProvider = a4;
        this.windowViewTouchInteractorProvider = a5;
    }

    public static DynamicIslandWindowStateInteractor_Factory create(a a2, a a3, a a4, a a5) {
        return new DynamicIslandWindowStateInteractor_Factory(a2, a3, a4, a5);
    }

    public static DynamicIslandWindowStateInteractor newInstance(E e2, DynamicIslandEventCoordinator dynamicIslandEventCoordinator, DynamicIslandWindowViewController dynamicIslandWindowViewController, DynamicIslandWindowViewTouchInteractor dynamicIslandWindowViewTouchInteractor) {
        return new DynamicIslandWindowStateInteractor(e2, dynamicIslandEventCoordinator, dynamicIslandWindowViewController, dynamicIslandWindowViewTouchInteractor);
    }

    public DynamicIslandWindowStateInteractor get() {
        return DynamicIslandWindowStateInteractor_Factory.newInstance((E)this.scopeProvider.get(), (DynamicIslandEventCoordinator)this.eventCoordinatorProvider.get(), (DynamicIslandWindowViewController)this.windowViewControllerProvider.get(), (DynamicIslandWindowViewTouchInteractor)this.windowViewTouchInteractorProvider.get());
    }
}
