/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  E0.e
 *  F0.a
 *  android.content.Context
 *  f1.E
 */
package miui.systemui.dynamicisland.window;

import E0.e;
import F0.a;
import android.content.Context;
import f1.E;
import miui.systemui.dynamicisland.window.DynamicIslandWindowController;
import miui.systemui.dynamicisland.window.DynamicIslandWindowState;
import miui.systemui.dynamicisland.window.DynamicIslandWindowView;
import miui.systemui.dynamicisland.window.domain.interactor.DynamicIslandWindowStateInteractor;

public final class DynamicIslandWindowController_Factory
implements e {
    private final a contextProvider;
    private final a dynamicIslandWindowStateProvider;
    private final a scopeProvider;
    private final a windowStateInteractorProvider;
    private final a windowViewProvider;

    public DynamicIslandWindowController_Factory(a a2, a a3, a a4, a a5, a a6) {
        this.scopeProvider = a2;
        this.windowViewProvider = a3;
        this.contextProvider = a4;
        this.dynamicIslandWindowStateProvider = a5;
        this.windowStateInteractorProvider = a6;
    }

    public static DynamicIslandWindowController_Factory create(a a2, a a3, a a4, a a5, a a6) {
        return new DynamicIslandWindowController_Factory(a2, a3, a4, a5, a6);
    }

    public static DynamicIslandWindowController newInstance(E e2, DynamicIslandWindowView dynamicIslandWindowView, Context context, DynamicIslandWindowState dynamicIslandWindowState, DynamicIslandWindowStateInteractor dynamicIslandWindowStateInteractor) {
        return new DynamicIslandWindowController(e2, dynamicIslandWindowView, context, dynamicIslandWindowState, dynamicIslandWindowStateInteractor);
    }

    public DynamicIslandWindowController get() {
        return DynamicIslandWindowController_Factory.newInstance((E)this.scopeProvider.get(), (DynamicIslandWindowView)((Object)this.windowViewProvider.get()), (Context)this.contextProvider.get(), (DynamicIslandWindowState)this.dynamicIslandWindowStateProvider.get(), (DynamicIslandWindowStateInteractor)this.windowStateInteractorProvider.get());
    }
}
