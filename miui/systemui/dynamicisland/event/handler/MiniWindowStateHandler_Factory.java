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
import miui.systemui.dynamicisland.event.handler.MiniWindowStateHandler;
import miui.systemui.dynamicisland.touch.domain.interactor.DynamicIslandTouchInteractor;

public final class MiniWindowStateHandler_Factory
implements e {
    private final a touchInteractorProvider;

    public MiniWindowStateHandler_Factory(a a2) {
        this.touchInteractorProvider = a2;
    }

    public static MiniWindowStateHandler_Factory create(a a2) {
        return new MiniWindowStateHandler_Factory(a2);
    }

    public static MiniWindowStateHandler newInstance(DynamicIslandTouchInteractor dynamicIslandTouchInteractor) {
        return new MiniWindowStateHandler(dynamicIslandTouchInteractor);
    }

    public MiniWindowStateHandler get() {
        return MiniWindowStateHandler_Factory.newInstance((DynamicIslandTouchInteractor)this.touchInteractorProvider.get());
    }
}
