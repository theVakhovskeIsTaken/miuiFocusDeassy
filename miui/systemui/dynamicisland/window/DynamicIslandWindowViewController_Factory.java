/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  D0.a
 *  E0.d
 *  E0.e
 *  F0.a
 *  K0.g
 *  android.os.Handler
 *  b.a
 *  com.android.systemui.plugins.miui.settings.SuperSaveModeController
 *  com.android.systemui.plugins.miui.shade.ShadeSwitchController
 *  f1.E
 *  miui.systemui.autodensity.AutoDensityController
 *  miui.systemui.util.concurrency.DelayableExecutor
 */
package miui.systemui.dynamicisland.window;

import D0.a;
import E0.d;
import E0.e;
import K0.g;
import android.os.Handler;
import com.android.systemui.plugins.miui.settings.SuperSaveModeController;
import com.android.systemui.plugins.miui.shade.ShadeSwitchController;
import f1.E;
import miui.systemui.autodensity.AutoDensityController;
import miui.systemui.dynamicisland.DynamicIslandDevicesUtils;
import miui.systemui.dynamicisland.data.repository.DynamicIslandSizeRepository;
import miui.systemui.dynamicisland.window.DynamicIslandDesktopStateController;
import miui.systemui.dynamicisland.window.DynamicIslandSafeguardsController;
import miui.systemui.dynamicisland.window.DynamicIslandWindowState;
import miui.systemui.dynamicisland.window.DynamicIslandWindowView;
import miui.systemui.dynamicisland.window.DynamicIslandWindowViewController;
import miui.systemui.util.concurrency.DelayableExecutor;

public final class DynamicIslandWindowViewController_Factory
implements e {
    private final F0.a autoDensityControllerProvider;
    private final F0.a avoidScreenBurnInHelperProvider;
    private final F0.a bgHandlerProvider;
    private final F0.a devicesUtilsProvider;
    private final F0.a dynamicIslandDesktopStateControllerProvider;
    private final F0.a dynamicIslandSafeguardsControllerProvider;
    private final F0.a externalStateRepositoryProvider;
    private final F0.a externalTouchHandlerProvider;
    private final F0.a hyperDropInfoNotifierServiceProvider;
    private final F0.a inflateContextProvider;
    private final F0.a lottieProgressManagerProvider;
    private final F0.a notificationChronometerManagerProvider;
    private final F0.a scopeProvider;
    private final F0.a shadeSwitchControllerProvider;
    private final F0.a sizeRepositoryProvider;
    private final F0.a superSaveModeControllerProvider;
    private final F0.a uiExecutorProvider;
    private final F0.a uiImmediateContextProvider;
    private final F0.a viewProvider;
    private final F0.a windowStateProvider;
    private final F0.a workBenchModeRepositoryProvider;

    public DynamicIslandWindowViewController_Factory(F0.a a2, F0.a a3, F0.a a4, F0.a a5, F0.a a6, F0.a a7, F0.a a8, F0.a a9, F0.a a10, F0.a a11, F0.a a12, F0.a a13, F0.a a14, F0.a a15, F0.a a16, F0.a a17, F0.a a18, F0.a a19, F0.a a20, F0.a a21, F0.a a22) {
        this.viewProvider = a2;
        this.scopeProvider = a3;
        this.uiExecutorProvider = a4;
        this.notificationChronometerManagerProvider = a5;
        this.avoidScreenBurnInHelperProvider = a6;
        this.windowStateProvider = a7;
        this.externalTouchHandlerProvider = a8;
        this.dynamicIslandDesktopStateControllerProvider = a9;
        this.dynamicIslandSafeguardsControllerProvider = a10;
        this.externalStateRepositoryProvider = a11;
        this.autoDensityControllerProvider = a12;
        this.lottieProgressManagerProvider = a13;
        this.hyperDropInfoNotifierServiceProvider = a14;
        this.sizeRepositoryProvider = a15;
        this.bgHandlerProvider = a16;
        this.inflateContextProvider = a17;
        this.uiImmediateContextProvider = a18;
        this.superSaveModeControllerProvider = a19;
        this.shadeSwitchControllerProvider = a20;
        this.workBenchModeRepositoryProvider = a21;
        this.devicesUtilsProvider = a22;
    }

    public static DynamicIslandWindowViewController_Factory create(F0.a a2, F0.a a3, F0.a a4, F0.a a5, F0.a a6, F0.a a7, F0.a a8, F0.a a9, F0.a a10, F0.a a11, F0.a a12, F0.a a13, F0.a a14, F0.a a15, F0.a a16, F0.a a17, F0.a a18, F0.a a19, F0.a a20, F0.a a21, F0.a a22) {
        return new DynamicIslandWindowViewController_Factory(a2, a3, a4, a5, a6, a7, a8, a9, a10, a11, a12, a13, a14, a15, a16, a17, a18, a19, a20, a21, a22);
    }

    public static DynamicIslandWindowViewController newInstance(DynamicIslandWindowView dynamicIslandWindowView, E e2, DelayableExecutor delayableExecutor, a a2, a a3, DynamicIslandWindowState dynamicIslandWindowState, a a4, DynamicIslandDesktopStateController dynamicIslandDesktopStateController, DynamicIslandSafeguardsController dynamicIslandSafeguardsController, a a5, AutoDensityController autoDensityController, a a6, b.a a7, DynamicIslandSizeRepository dynamicIslandSizeRepository, Handler handler, g g2, g g3, SuperSaveModeController superSaveModeController, ShadeSwitchController shadeSwitchController, a a8, DynamicIslandDevicesUtils dynamicIslandDevicesUtils) {
        return new DynamicIslandWindowViewController(dynamicIslandWindowView, e2, delayableExecutor, a2, a3, dynamicIslandWindowState, a4, dynamicIslandDesktopStateController, dynamicIslandSafeguardsController, a5, autoDensityController, a6, a7, dynamicIslandSizeRepository, handler, g2, g3, superSaveModeController, shadeSwitchController, a8, dynamicIslandDevicesUtils);
    }

    public DynamicIslandWindowViewController get() {
        return DynamicIslandWindowViewController_Factory.newInstance((DynamicIslandWindowView)((Object)this.viewProvider.get()), (E)this.scopeProvider.get(), (DelayableExecutor)this.uiExecutorProvider.get(), d.a((F0.a)this.notificationChronometerManagerProvider), d.a((F0.a)this.avoidScreenBurnInHelperProvider), (DynamicIslandWindowState)this.windowStateProvider.get(), d.a((F0.a)this.externalTouchHandlerProvider), (DynamicIslandDesktopStateController)this.dynamicIslandDesktopStateControllerProvider.get(), (DynamicIslandSafeguardsController)this.dynamicIslandSafeguardsControllerProvider.get(), d.a((F0.a)this.externalStateRepositoryProvider), (AutoDensityController)this.autoDensityControllerProvider.get(), d.a((F0.a)this.lottieProgressManagerProvider), (b.a)this.hyperDropInfoNotifierServiceProvider.get(), (DynamicIslandSizeRepository)this.sizeRepositoryProvider.get(), (Handler)this.bgHandlerProvider.get(), (g)this.inflateContextProvider.get(), (g)this.uiImmediateContextProvider.get(), (SuperSaveModeController)this.superSaveModeControllerProvider.get(), (ShadeSwitchController)this.shadeSwitchControllerProvider.get(), d.a((F0.a)this.workBenchModeRepositoryProvider), (DynamicIslandDevicesUtils)this.devicesUtilsProvider.get());
    }
}
