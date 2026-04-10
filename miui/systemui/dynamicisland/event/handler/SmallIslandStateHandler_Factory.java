/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  E0.e
 *  F0.a
 *  android.content.Context
 */
package miui.systemui.dynamicisland.event.handler;

import E0.e;
import F0.a;
import android.content.Context;
import miui.systemui.dynamicisland.event.handler.SmallIslandStateHandler;
import miui.systemui.dynamicisland.touch.domain.interactor.DynamicIslandTouchInteractor;

public final class SmallIslandStateHandler_Factory
implements e {
    private final a contextProvider;
    private final a touchInteractorProvider;

    public SmallIslandStateHandler_Factory(a a2, a a3) {
        this.touchInteractorProvider = a2;
        this.contextProvider = a3;
    }

    public static SmallIslandStateHandler_Factory create(a a2, a a3) {
        return new SmallIslandStateHandler_Factory(a2, a3);
    }

    public static SmallIslandStateHandler newInstance(DynamicIslandTouchInteractor dynamicIslandTouchInteractor, Context context) {
        return new SmallIslandStateHandler(dynamicIslandTouchInteractor, context);
    }

    public SmallIslandStateHandler get() {
        return SmallIslandStateHandler_Factory.newInstance((DynamicIslandTouchInteractor)this.touchInteractorProvider.get(), (Context)this.contextProvider.get());
    }
}
