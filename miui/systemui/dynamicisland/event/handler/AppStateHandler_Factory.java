/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  E0.e
 *  F0.a
 */
package miui.systemui.dynamicisland.event.handler;

import E0.e;
import F0.a;
import miui.systemui.dynamicisland.event.handler.AppStateHandler;
import miui.systemui.dynamicisland.touch.domain.interactor.DynamicIslandTouchInteractor;

public final class AppStateHandler_Factory
implements e {
    private final a touchInteractorProvider;

    public AppStateHandler_Factory(a a2) {
        this.touchInteractorProvider = a2;
    }

    public static AppStateHandler_Factory create(a a2) {
        return new AppStateHandler_Factory(a2);
    }

    public static AppStateHandler newInstance(DynamicIslandTouchInteractor dynamicIslandTouchInteractor) {
        return new AppStateHandler(dynamicIslandTouchInteractor);
    }

    public AppStateHandler get() {
        return AppStateHandler_Factory.newInstance((DynamicIslandTouchInteractor)this.touchInteractorProvider.get());
    }
}
