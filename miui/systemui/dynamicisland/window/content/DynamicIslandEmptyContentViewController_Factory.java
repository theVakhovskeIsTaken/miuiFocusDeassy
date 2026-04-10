/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  E0.e
 *  F0.a
 *  f1.E
 */
package miui.systemui.dynamicisland.window.content;

import E0.e;
import F0.a;
import f1.E;
import miui.systemui.dynamicisland.touch.domain.interactor.DynamicIslandTouchInteractor;
import miui.systemui.dynamicisland.window.DynamicIslandWindowView;
import miui.systemui.dynamicisland.window.content.DynamicIslandEmptyContentViewController;

public final class DynamicIslandEmptyContentViewController_Factory
implements e {
    private final a scopeProvider;
    private final a touchInteractorProvider;
    private final a windowViewProvider;

    public DynamicIslandEmptyContentViewController_Factory(a a2, a a3, a a4) {
        this.windowViewProvider = a2;
        this.scopeProvider = a3;
        this.touchInteractorProvider = a4;
    }

    public static DynamicIslandEmptyContentViewController_Factory create(a a2, a a3, a a4) {
        return new DynamicIslandEmptyContentViewController_Factory(a2, a3, a4);
    }

    public static DynamicIslandEmptyContentViewController newInstance(DynamicIslandWindowView dynamicIslandWindowView, E e2, DynamicIslandTouchInteractor dynamicIslandTouchInteractor) {
        return new DynamicIslandEmptyContentViewController(dynamicIslandWindowView, e2, dynamicIslandTouchInteractor);
    }

    public DynamicIslandEmptyContentViewController get() {
        return DynamicIslandEmptyContentViewController_Factory.newInstance((DynamicIslandWindowView)((Object)this.windowViewProvider.get()), (E)this.scopeProvider.get(), (DynamicIslandTouchInteractor)this.touchInteractorProvider.get());
    }
}
