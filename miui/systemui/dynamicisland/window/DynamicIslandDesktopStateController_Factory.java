/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  D0.a
 *  E0.d
 *  E0.e
 *  F0.a
 *  android.content.Context
 *  android.os.Handler
 *  f1.E
 *  miui.systemui.util.concurrency.DelayableExecutor
 */
package miui.systemui.dynamicisland.window;

import D0.a;
import E0.d;
import E0.e;
import android.content.Context;
import android.os.Handler;
import f1.E;
import miui.systemui.dynamicisland.window.DynamicIslandDesktopStateController;
import miui.systemui.dynamicisland.window.DynamicIslandWindowView;
import miui.systemui.util.concurrency.DelayableExecutor;

public final class DynamicIslandDesktopStateController_Factory
implements e {
    private final F0.a contextProvider;
    private final F0.a handlerProvider;
    private final F0.a scopeProvider;
    private final F0.a sysUIContextProvider;
    private final F0.a uiExecutorProvider;
    private final F0.a windowViewProvider;
    private final F0.a workBenchModeRepositoryProvider;

    public DynamicIslandDesktopStateController_Factory(F0.a a2, F0.a a3, F0.a a4, F0.a a5, F0.a a6, F0.a a7, F0.a a8) {
        this.contextProvider = a2;
        this.sysUIContextProvider = a3;
        this.windowViewProvider = a4;
        this.uiExecutorProvider = a5;
        this.scopeProvider = a6;
        this.handlerProvider = a7;
        this.workBenchModeRepositoryProvider = a8;
    }

    public static DynamicIslandDesktopStateController_Factory create(F0.a a2, F0.a a3, F0.a a4, F0.a a5, F0.a a6, F0.a a7, F0.a a8) {
        return new DynamicIslandDesktopStateController_Factory(a2, a3, a4, a5, a6, a7, a8);
    }

    public static DynamicIslandDesktopStateController newInstance(Context context, Context context2, DynamicIslandWindowView dynamicIslandWindowView, DelayableExecutor delayableExecutor, E e2, Handler handler, a a2) {
        return new DynamicIslandDesktopStateController(context, context2, dynamicIslandWindowView, delayableExecutor, e2, handler, a2);
    }

    public DynamicIslandDesktopStateController get() {
        return DynamicIslandDesktopStateController_Factory.newInstance((Context)this.contextProvider.get(), (Context)this.sysUIContextProvider.get(), (DynamicIslandWindowView)((Object)this.windowViewProvider.get()), (DelayableExecutor)this.uiExecutorProvider.get(), (E)this.scopeProvider.get(), (Handler)this.handlerProvider.get(), d.a((F0.a)this.workBenchModeRepositoryProvider));
    }
}
