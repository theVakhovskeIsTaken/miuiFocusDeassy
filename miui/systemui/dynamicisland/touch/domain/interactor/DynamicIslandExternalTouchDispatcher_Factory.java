/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  E0.e
 *  F0.a
 *  f1.E
 */
package miui.systemui.dynamicisland.touch.domain.interactor;

import E0.e;
import F0.a;
import f1.E;
import miui.systemui.dynamicisland.touch.domain.interactor.DynamicIslandExternalTouchDispatcher;
import miui.systemui.dynamicisland.window.DynamicIslandWindowView;
import miui.systemui.dynamicisland.window.domain.interactor.DynamicIslandWindowViewTouchInteractor;

public final class DynamicIslandExternalTouchDispatcher_Factory
implements e {
    private final a scopeProvider;
    private final a windowViewProvider;
    private final a windowViewTouchInteractorProvider;

    public DynamicIslandExternalTouchDispatcher_Factory(a a2, a a3, a a4) {
        this.scopeProvider = a2;
        this.windowViewProvider = a3;
        this.windowViewTouchInteractorProvider = a4;
    }

    public static DynamicIslandExternalTouchDispatcher_Factory create(a a2, a a3, a a4) {
        return new DynamicIslandExternalTouchDispatcher_Factory(a2, a3, a4);
    }

    public static DynamicIslandExternalTouchDispatcher newInstance(E e2, DynamicIslandWindowView dynamicIslandWindowView, DynamicIslandWindowViewTouchInteractor dynamicIslandWindowViewTouchInteractor) {
        return new DynamicIslandExternalTouchDispatcher(e2, dynamicIslandWindowView, dynamicIslandWindowViewTouchInteractor);
    }

    public DynamicIslandExternalTouchDispatcher get() {
        return DynamicIslandExternalTouchDispatcher_Factory.newInstance((E)this.scopeProvider.get(), (DynamicIslandWindowView)((Object)this.windowViewProvider.get()), (DynamicIslandWindowViewTouchInteractor)this.windowViewTouchInteractorProvider.get());
    }
}
