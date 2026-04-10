/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  D0.a
 *  E0.d
 *  E0.e
 *  F0.a
 */
package miui.systemui.dynamicisland.anim;

import D0.a;
import E0.d;
import E0.e;
import miui.systemui.dynamicisland.anim.DynamicIslandAnimationController;
import miui.systemui.dynamicisland.anim.DynamicIslandAnimationDelegate;
import miui.systemui.dynamicisland.data.repository.DynamicIslandExternalStateRepository;
import miui.systemui.dynamicisland.window.DynamicIslandWindowState;

public final class DynamicIslandAnimationController_Factory
implements e {
    private final F0.a animationDelegateFactoryProvider;
    private final F0.a dynamicIslandWindowStateProvider;
    private final F0.a eventCoordinatorProvider;
    private final F0.a externalStateRepositoryProvider;

    public DynamicIslandAnimationController_Factory(F0.a a2, F0.a a3, F0.a a4, F0.a a5) {
        this.eventCoordinatorProvider = a2;
        this.dynamicIslandWindowStateProvider = a3;
        this.animationDelegateFactoryProvider = a4;
        this.externalStateRepositoryProvider = a5;
    }

    public static DynamicIslandAnimationController_Factory create(F0.a a2, F0.a a3, F0.a a4, F0.a a5) {
        return new DynamicIslandAnimationController_Factory(a2, a3, a4, a5);
    }

    public static DynamicIslandAnimationController newInstance(a a2, DynamicIslandWindowState dynamicIslandWindowState, DynamicIslandAnimationDelegate.Factory factory, DynamicIslandExternalStateRepository dynamicIslandExternalStateRepository) {
        return new DynamicIslandAnimationController(a2, dynamicIslandWindowState, factory, dynamicIslandExternalStateRepository);
    }

    public DynamicIslandAnimationController get() {
        return DynamicIslandAnimationController_Factory.newInstance(d.a((F0.a)this.eventCoordinatorProvider), (DynamicIslandWindowState)this.dynamicIslandWindowStateProvider.get(), (DynamicIslandAnimationDelegate.Factory)this.animationDelegateFactoryProvider.get(), (DynamicIslandExternalStateRepository)this.externalStateRepositoryProvider.get());
    }
}
