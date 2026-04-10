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
import miui.systemui.dynamicisland.event.handler.HiddenStateHandler;
import miui.systemui.dynamicisland.touch.domain.interactor.DynamicIslandTouchInteractor;

public final class HiddenStateHandler_Factory
implements e {
    private final a touchInteractorProvider;

    public HiddenStateHandler_Factory(a a2) {
        this.touchInteractorProvider = a2;
    }

    public static HiddenStateHandler_Factory create(a a2) {
        return new HiddenStateHandler_Factory(a2);
    }

    public static HiddenStateHandler newInstance(DynamicIslandTouchInteractor dynamicIslandTouchInteractor) {
        return new HiddenStateHandler(dynamicIslandTouchInteractor);
    }

    public HiddenStateHandler get() {
        return HiddenStateHandler_Factory.newInstance((DynamicIslandTouchInteractor)this.touchInteractorProvider.get());
    }
}
