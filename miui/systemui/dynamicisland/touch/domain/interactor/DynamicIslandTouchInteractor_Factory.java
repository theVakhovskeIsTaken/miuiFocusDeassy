/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  D0.a
 *  E0.d
 *  E0.e
 *  F0.a
 *  android.content.Context
 *  f1.E
 */
package miui.systemui.dynamicisland.touch.domain.interactor;

import D0.a;
import E0.d;
import E0.e;
import android.content.Context;
import f1.E;
import miui.systemui.dynamicisland.anim.DynamicIslandAnimationController;
import miui.systemui.dynamicisland.touch.data.repository.DynamicIslandTouchConstantsRepository;
import miui.systemui.dynamicisland.touch.domain.interactor.DynamicIslandExternalTouchInteractor;
import miui.systemui.dynamicisland.touch.domain.interactor.DynamicIslandTouchInteractor;
import miui.systemui.dynamicisland.window.DynamicIslandWindowState;
import miui.systemui.dynamicisland.window.DynamicIslandWindowView;
import miui.systemui.dynamicisland.window.DynamicIslandWindowViewController;
import miui.systemui.dynamicisland.window.domain.interactor.DynamicIslandTouchRegionInteractor;
import miui.systemui.dynamicisland.window.domain.interactor.DynamicIslandWindowViewTouchInteractor;

public final class DynamicIslandTouchInteractor_Factory
implements e {
    private final F0.a animationControllerProvider;
    private final F0.a bigIslandStateHandlerProvider;
    private final F0.a contextProvider;
    private final F0.a eventCoordinatorProvider;
    private final F0.a expandedStateHandlerProvider;
    private final F0.a externalTouchInteractorProvider;
    private final F0.a scopeProvider;
    private final F0.a showOnceIslandHandlerProvider;
    private final F0.a smallIslandStateHandlerProvider;
    private final F0.a sysUIContextProvider;
    private final F0.a touchConstantsProvider;
    private final F0.a touchRegionInteractorProvider;
    private final F0.a windowStateProvider;
    private final F0.a windowViewControllerProvider;
    private final F0.a windowViewProvider;
    private final F0.a windowViewTouchInteractorProvider;

    public DynamicIslandTouchInteractor_Factory(F0.a a2, F0.a a3, F0.a a4, F0.a a5, F0.a a6, F0.a a7, F0.a a8, F0.a a9, F0.a a10, F0.a a11, F0.a a12, F0.a a13, F0.a a14, F0.a a15, F0.a a16, F0.a a17) {
        this.scopeProvider = a2;
        this.contextProvider = a3;
        this.sysUIContextProvider = a4;
        this.touchConstantsProvider = a5;
        this.windowViewProvider = a6;
        this.externalTouchInteractorProvider = a7;
        this.windowViewTouchInteractorProvider = a8;
        this.eventCoordinatorProvider = a9;
        this.bigIslandStateHandlerProvider = a10;
        this.showOnceIslandHandlerProvider = a11;
        this.smallIslandStateHandlerProvider = a12;
        this.expandedStateHandlerProvider = a13;
        this.windowStateProvider = a14;
        this.windowViewControllerProvider = a15;
        this.animationControllerProvider = a16;
        this.touchRegionInteractorProvider = a17;
    }

    public static DynamicIslandTouchInteractor_Factory create(F0.a a2, F0.a a3, F0.a a4, F0.a a5, F0.a a6, F0.a a7, F0.a a8, F0.a a9, F0.a a10, F0.a a11, F0.a a12, F0.a a13, F0.a a14, F0.a a15, F0.a a16, F0.a a17) {
        return new DynamicIslandTouchInteractor_Factory(a2, a3, a4, a5, a6, a7, a8, a9, a10, a11, a12, a13, a14, a15, a16, a17);
    }

    public static DynamicIslandTouchInteractor newInstance(E e2, Context context, Context context2, DynamicIslandTouchConstantsRepository dynamicIslandTouchConstantsRepository, DynamicIslandWindowView dynamicIslandWindowView, DynamicIslandExternalTouchInteractor dynamicIslandExternalTouchInteractor, DynamicIslandWindowViewTouchInteractor dynamicIslandWindowViewTouchInteractor, a a2, a a3, a a4, a a5, a a6, DynamicIslandWindowState dynamicIslandWindowState, DynamicIslandWindowViewController dynamicIslandWindowViewController, DynamicIslandAnimationController dynamicIslandAnimationController, DynamicIslandTouchRegionInteractor dynamicIslandTouchRegionInteractor) {
        return new DynamicIslandTouchInteractor(e2, context, context2, dynamicIslandTouchConstantsRepository, dynamicIslandWindowView, dynamicIslandExternalTouchInteractor, dynamicIslandWindowViewTouchInteractor, a2, a3, a4, a5, a6, dynamicIslandWindowState, dynamicIslandWindowViewController, dynamicIslandAnimationController, dynamicIslandTouchRegionInteractor);
    }

    public DynamicIslandTouchInteractor get() {
        return DynamicIslandTouchInteractor_Factory.newInstance((E)this.scopeProvider.get(), (Context)this.contextProvider.get(), (Context)this.sysUIContextProvider.get(), (DynamicIslandTouchConstantsRepository)this.touchConstantsProvider.get(), (DynamicIslandWindowView)((Object)this.windowViewProvider.get()), (DynamicIslandExternalTouchInteractor)this.externalTouchInteractorProvider.get(), (DynamicIslandWindowViewTouchInteractor)this.windowViewTouchInteractorProvider.get(), d.a((F0.a)this.eventCoordinatorProvider), d.a((F0.a)this.bigIslandStateHandlerProvider), d.a((F0.a)this.showOnceIslandHandlerProvider), d.a((F0.a)this.smallIslandStateHandlerProvider), d.a((F0.a)this.expandedStateHandlerProvider), (DynamicIslandWindowState)this.windowStateProvider.get(), (DynamicIslandWindowViewController)this.windowViewControllerProvider.get(), (DynamicIslandAnimationController)this.animationControllerProvider.get(), (DynamicIslandTouchRegionInteractor)this.touchRegionInteractorProvider.get());
    }
}
