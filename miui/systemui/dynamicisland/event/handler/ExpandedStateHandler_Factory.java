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
import miui.systemui.dynamicisland.event.handler.ExpandedStateHandler;
import miui.systemui.dynamicisland.touch.domain.interactor.DynamicIslandTouchInteractor;

public final class ExpandedStateHandler_Factory
implements e {
    private final a touchInteractorProvider;

    public ExpandedStateHandler_Factory(a a2) {
        this.touchInteractorProvider = a2;
    }

    public static ExpandedStateHandler_Factory create(a a2) {
        return new ExpandedStateHandler_Factory(a2);
    }

    public static ExpandedStateHandler newInstance(DynamicIslandTouchInteractor dynamicIslandTouchInteractor) {
        return new ExpandedStateHandler(dynamicIslandTouchInteractor);
    }

    public ExpandedStateHandler get() {
        return ExpandedStateHandler_Factory.newInstance((DynamicIslandTouchInteractor)this.touchInteractorProvider.get());
    }
}
