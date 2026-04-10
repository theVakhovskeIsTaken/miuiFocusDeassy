/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  D0.a
 *  E0.d
 *  E0.e
 *  F0.a
 *  android.content.Context
 *  f1.E
 */
package miui.systemui.dynamicisland.event;

import D0.a;
import E0.d;
import E0.e;
import android.content.Context;
import f1.E;
import miui.systemui.dynamicisland.display.AntiBurnInManager;
import miui.systemui.dynamicisland.display.AvoidScreenBurnInHelper;
import miui.systemui.dynamicisland.event.DynamicIslandEventCoordinator;
import miui.systemui.dynamicisland.event.handler.AppStateHandler;
import miui.systemui.dynamicisland.event.handler.BigIslandStateHandler;
import miui.systemui.dynamicisland.event.handler.ExpandedStateHandler;
import miui.systemui.dynamicisland.event.handler.HiddenStateHandler;
import miui.systemui.dynamicisland.event.handler.MiniWindowStateHandler;
import miui.systemui.dynamicisland.event.handler.ShowOnceIslandHandler;
import miui.systemui.dynamicisland.event.handler.SmallIslandStateHandler;
import miui.systemui.dynamicisland.window.AppLockController;
import miui.systemui.dynamicisland.window.DynamicIslandWindowState;
import miui.systemui.dynamicisland.window.DynamicIslandWindowView;

public final class DynamicIslandEventCoordinator_Factory
implements e {
    private final F0.a addEventCoordinatorProvider;
    private final F0.a animControllerProvider;
    private final F0.a antiBurnInManagerProvider;
    private final F0.a appEventCoordinatorProvider;
    private final F0.a appLockControllerProvider;
    private final F0.a appStateHandlerProvider;
    private final F0.a avoidScreenBurnInEventCoordinatorProvider;
    private final F0.a avoidScreenBurnInHelperProvider;
    private final F0.a bigIslandStateHandlerProvider;
    private final F0.a clickEventCoordinatorProvider;
    private final F0.a collapseEventCoordinatorProvider;
    private final F0.a configChangedEventCoordinatorProvider;
    private final F0.a ctxProvider;
    private final F0.a deletedEventCoordinatorProvider;
    private final F0.a dynamicIslandWindowStateProvider;
    private final F0.a expandedStateHandlerProvider;
    private final F0.a hiddenStateHandlerProvider;
    private final F0.a islandTempHiddenEventCoordinatorProvider;
    private final F0.a miniWindowEventCoordinatorProvider;
    private final F0.a miniWindowStateHandlerProvider;
    private final F0.a notificationSettingsManagerProvider;
    private final F0.a panelExpandedEventCoordinatorProvider;
    private final F0.a scopeProvider;
    private final F0.a showOnceIslandHandlerProvider;
    private final F0.a smallIslandStateHandlerProvider;
    private final F0.a swipeEventCoordinatorProvider;
    private final F0.a updateEventCoordinatorProvider;
    private final F0.a updateWidthEventCoordinatorProvider;
    private final F0.a windowViewProvider;

    public DynamicIslandEventCoordinator_Factory(F0.a a2, F0.a a3, F0.a a4, F0.a a5, F0.a a6, F0.a a7, F0.a a8, F0.a a9, F0.a a10, F0.a a11, F0.a a12, F0.a a13, F0.a a14, F0.a a15, F0.a a16, F0.a a17, F0.a a18, F0.a a19, F0.a a20, F0.a a21, F0.a a22, F0.a a23, F0.a a24, F0.a a25, F0.a a26, F0.a a27, F0.a a28, F0.a a29, F0.a a30) {
        this.scopeProvider = a2;
        this.ctxProvider = a3;
        this.windowViewProvider = a4;
        this.avoidScreenBurnInHelperProvider = a5;
        this.expandedStateHandlerProvider = a6;
        this.bigIslandStateHandlerProvider = a7;
        this.showOnceIslandHandlerProvider = a8;
        this.smallIslandStateHandlerProvider = a9;
        this.hiddenStateHandlerProvider = a10;
        this.appStateHandlerProvider = a11;
        this.miniWindowStateHandlerProvider = a12;
        this.dynamicIslandWindowStateProvider = a13;
        this.appLockControllerProvider = a14;
        this.antiBurnInManagerProvider = a15;
        this.addEventCoordinatorProvider = a16;
        this.clickEventCoordinatorProvider = a17;
        this.deletedEventCoordinatorProvider = a18;
        this.collapseEventCoordinatorProvider = a19;
        this.swipeEventCoordinatorProvider = a20;
        this.updateEventCoordinatorProvider = a21;
        this.updateWidthEventCoordinatorProvider = a22;
        this.appEventCoordinatorProvider = a23;
        this.miniWindowEventCoordinatorProvider = a24;
        this.islandTempHiddenEventCoordinatorProvider = a25;
        this.configChangedEventCoordinatorProvider = a26;
        this.panelExpandedEventCoordinatorProvider = a27;
        this.avoidScreenBurnInEventCoordinatorProvider = a28;
        this.animControllerProvider = a29;
        this.notificationSettingsManagerProvider = a30;
    }

    public static DynamicIslandEventCoordinator_Factory create(F0.a a2, F0.a a3, F0.a a4, F0.a a5, F0.a a6, F0.a a7, F0.a a8, F0.a a9, F0.a a10, F0.a a11, F0.a a12, F0.a a13, F0.a a14, F0.a a15, F0.a a16, F0.a a17, F0.a a18, F0.a a19, F0.a a20, F0.a a21, F0.a a22, F0.a a23, F0.a a24, F0.a a25, F0.a a26, F0.a a27, F0.a a28, F0.a a29, F0.a a30) {
        return new DynamicIslandEventCoordinator_Factory(a2, a3, a4, a5, a6, a7, a8, a9, a10, a11, a12, a13, a14, a15, a16, a17, a18, a19, a20, a21, a22, a23, a24, a25, a26, a27, a28, a29, a30);
    }

    public static DynamicIslandEventCoordinator newInstance(E e2, Context context, DynamicIslandWindowView dynamicIslandWindowView, AvoidScreenBurnInHelper avoidScreenBurnInHelper, ExpandedStateHandler expandedStateHandler, BigIslandStateHandler bigIslandStateHandler, ShowOnceIslandHandler showOnceIslandHandler, SmallIslandStateHandler smallIslandStateHandler, HiddenStateHandler hiddenStateHandler, AppStateHandler appStateHandler, MiniWindowStateHandler miniWindowStateHandler, DynamicIslandWindowState dynamicIslandWindowState, AppLockController appLockController, AntiBurnInManager antiBurnInManager, a a2, a a3, a a4, a a5, a a6, a a7, a a8, a a9, a a10, a a11, a a12, a a13, a a14, a a15, a a16) {
        return new DynamicIslandEventCoordinator(e2, context, dynamicIslandWindowView, avoidScreenBurnInHelper, expandedStateHandler, bigIslandStateHandler, showOnceIslandHandler, smallIslandStateHandler, hiddenStateHandler, appStateHandler, miniWindowStateHandler, dynamicIslandWindowState, appLockController, antiBurnInManager, a2, a3, a4, a5, a6, a7, a8, a9, a10, a11, a12, a13, a14, a15, a16);
    }

    public DynamicIslandEventCoordinator get() {
        return DynamicIslandEventCoordinator_Factory.newInstance((E)this.scopeProvider.get(), (Context)this.ctxProvider.get(), (DynamicIslandWindowView)((Object)this.windowViewProvider.get()), (AvoidScreenBurnInHelper)this.avoidScreenBurnInHelperProvider.get(), (ExpandedStateHandler)this.expandedStateHandlerProvider.get(), (BigIslandStateHandler)this.bigIslandStateHandlerProvider.get(), (ShowOnceIslandHandler)this.showOnceIslandHandlerProvider.get(), (SmallIslandStateHandler)this.smallIslandStateHandlerProvider.get(), (HiddenStateHandler)this.hiddenStateHandlerProvider.get(), (AppStateHandler)this.appStateHandlerProvider.get(), (MiniWindowStateHandler)this.miniWindowStateHandlerProvider.get(), (DynamicIslandWindowState)this.dynamicIslandWindowStateProvider.get(), (AppLockController)this.appLockControllerProvider.get(), (AntiBurnInManager)this.antiBurnInManagerProvider.get(), d.a((F0.a)this.addEventCoordinatorProvider), d.a((F0.a)this.clickEventCoordinatorProvider), d.a((F0.a)this.deletedEventCoordinatorProvider), d.a((F0.a)this.collapseEventCoordinatorProvider), d.a((F0.a)this.swipeEventCoordinatorProvider), d.a((F0.a)this.updateEventCoordinatorProvider), d.a((F0.a)this.updateWidthEventCoordinatorProvider), d.a((F0.a)this.appEventCoordinatorProvider), d.a((F0.a)this.miniWindowEventCoordinatorProvider), d.a((F0.a)this.islandTempHiddenEventCoordinatorProvider), d.a((F0.a)this.configChangedEventCoordinatorProvider), d.a((F0.a)this.panelExpandedEventCoordinatorProvider), d.a((F0.a)this.avoidScreenBurnInEventCoordinatorProvider), d.a((F0.a)this.animControllerProvider), d.a((F0.a)this.notificationSettingsManagerProvider));
    }
}
