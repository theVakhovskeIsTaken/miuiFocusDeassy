/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  D0.a
 *  E0.d
 *  E0.e
 *  F0.a
 *  f1.E
 *  miui.systemui.util.concurrency.DelayableExecutor
 */
package miui.systemui.dynamicisland.window;

import D0.a;
import E0.d;
import E0.e;
import f1.E;
import miui.systemui.dynamicisland.window.DynamicIslandSafeguardsController;
import miui.systemui.dynamicisland.window.DynamicIslandWindowView;
import miui.systemui.util.concurrency.DelayableExecutor;

public final class DynamicIslandSafeguardsController_Factory
implements e {
    private final F0.a scopeProvider;
    private final F0.a uiExecutorProvider;
    private final F0.a windowViewControllerLazyProvider;
    private final F0.a windowViewProvider;

    public DynamicIslandSafeguardsController_Factory(F0.a a2, F0.a a3, F0.a a4, F0.a a5) {
        this.windowViewProvider = a2;
        this.uiExecutorProvider = a3;
        this.scopeProvider = a4;
        this.windowViewControllerLazyProvider = a5;
    }

    public static DynamicIslandSafeguardsController_Factory create(F0.a a2, F0.a a3, F0.a a4, F0.a a5) {
        return new DynamicIslandSafeguardsController_Factory(a2, a3, a4, a5);
    }

    public static DynamicIslandSafeguardsController newInstance(DynamicIslandWindowView dynamicIslandWindowView, DelayableExecutor delayableExecutor, E e2, a a2) {
        return new DynamicIslandSafeguardsController(dynamicIslandWindowView, delayableExecutor, e2, a2);
    }

    public DynamicIslandSafeguardsController get() {
        return DynamicIslandSafeguardsController_Factory.newInstance((DynamicIslandWindowView)((Object)this.windowViewProvider.get()), (DelayableExecutor)this.uiExecutorProvider.get(), (E)this.scopeProvider.get(), d.a((F0.a)this.windowViewControllerLazyProvider));
    }
}
