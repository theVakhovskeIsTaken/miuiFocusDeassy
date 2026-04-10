/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  E0.e
 *  F0.a
 *  android.content.Context
 *  f1.E
 */
package miui.systemui.dynamicisland.touch.domain.interactor;

import E0.e;
import F0.a;
import android.content.Context;
import f1.E;
import miui.systemui.dynamicisland.touch.domain.interactor.DynamicIslandExternalTouchInteractor;
import miui.systemui.dynamicisland.window.domain.interactor.DynamicIslandTouchRegionInteractor;

public final class DynamicIslandExternalTouchInteractor_Factory
implements e {
    private final a contextProvider;
    private final a scopeProvider;
    private final a sysUIContextProvider;
    private final a touchRegionInteractorProvider;

    public DynamicIslandExternalTouchInteractor_Factory(a a2, a a3, a a4, a a5) {
        this.scopeProvider = a2;
        this.contextProvider = a3;
        this.sysUIContextProvider = a4;
        this.touchRegionInteractorProvider = a5;
    }

    public static DynamicIslandExternalTouchInteractor_Factory create(a a2, a a3, a a4, a a5) {
        return new DynamicIslandExternalTouchInteractor_Factory(a2, a3, a4, a5);
    }

    public static DynamicIslandExternalTouchInteractor newInstance(E e2, Context context, Context context2, DynamicIslandTouchRegionInteractor dynamicIslandTouchRegionInteractor) {
        return new DynamicIslandExternalTouchInteractor(e2, context, context2, dynamicIslandTouchRegionInteractor);
    }

    public DynamicIslandExternalTouchInteractor get() {
        return DynamicIslandExternalTouchInteractor_Factory.newInstance((E)this.scopeProvider.get(), (Context)this.contextProvider.get(), (Context)this.sysUIContextProvider.get(), (DynamicIslandTouchRegionInteractor)this.touchRegionInteractorProvider.get());
    }
}
