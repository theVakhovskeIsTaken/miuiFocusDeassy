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
import miui.systemui.dynamicisland.event.handler.BigIslandStateHandler;
import miui.systemui.dynamicisland.event.handler.ShowOnceIslandHandler;
import miui.systemui.dynamicisland.touch.domain.interactor.DynamicIslandTouchInteractor;

public final class ShowOnceIslandHandler_Factory
implements e {
    private final a bigIslandStateHandlerProvider;
    private final a touchInteractorProvider;

    public ShowOnceIslandHandler_Factory(a a2, a a3) {
        this.touchInteractorProvider = a2;
        this.bigIslandStateHandlerProvider = a3;
    }

    public static ShowOnceIslandHandler_Factory create(a a2, a a3) {
        return new ShowOnceIslandHandler_Factory(a2, a3);
    }

    public static ShowOnceIslandHandler newInstance(DynamicIslandTouchInteractor dynamicIslandTouchInteractor, BigIslandStateHandler bigIslandStateHandler) {
        return new ShowOnceIslandHandler(dynamicIslandTouchInteractor, bigIslandStateHandler);
    }

    public ShowOnceIslandHandler get() {
        return ShowOnceIslandHandler_Factory.newInstance((DynamicIslandTouchInteractor)this.touchInteractorProvider.get(), (BigIslandStateHandler)this.bigIslandStateHandlerProvider.get());
    }
}
