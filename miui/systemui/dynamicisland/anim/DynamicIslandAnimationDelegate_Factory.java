/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  F0.a
 */
package miui.systemui.dynamicisland.anim;

import F0.a;
import miui.systemui.dynamicisland.anim.DynamicIslandAnimationController;
import miui.systemui.dynamicisland.anim.DynamicIslandAnimationDelegate;
import miui.systemui.dynamicisland.device.strategy.DynamicIslandAnimationDelegateHelper;
import miui.systemui.dynamicisland.event.handler.BigIslandStateHandler;
import miui.systemui.dynamicisland.event.handler.ExpandedStateHandler;
import miui.systemui.dynamicisland.event.handler.SmallIslandStateHandler;
import miui.systemui.dynamicisland.window.DynamicIslandWindowView;
import miui.systemui.dynamicisland.window.content.DynamicIslandBaseContentView;

public final class DynamicIslandAnimationDelegate_Factory {
    private final a animationDelegateHelperFactoryProvider;
    private final a bigIslandStateHandlerProvider;
    private final a dynamicIslandAnimControllerProvider;
    private final a expandedStateHandlerProvider;
    private final a smallIslandStateHandlerProvider;
    private final a windowViewProvider;

    public DynamicIslandAnimationDelegate_Factory(a a2, a a3, a a4, a a5, a a6, a a7) {
        this.dynamicIslandAnimControllerProvider = a2;
        this.smallIslandStateHandlerProvider = a3;
        this.bigIslandStateHandlerProvider = a4;
        this.expandedStateHandlerProvider = a5;
        this.windowViewProvider = a6;
        this.animationDelegateHelperFactoryProvider = a7;
    }

    public static DynamicIslandAnimationDelegate_Factory create(a a2, a a3, a a4, a a5, a a6, a a7) {
        return new DynamicIslandAnimationDelegate_Factory(a2, a3, a4, a5, a6, a7);
    }

    public static DynamicIslandAnimationDelegate newInstance(DynamicIslandBaseContentView dynamicIslandBaseContentView, DynamicIslandAnimationController dynamicIslandAnimationController, SmallIslandStateHandler smallIslandStateHandler, BigIslandStateHandler bigIslandStateHandler, ExpandedStateHandler expandedStateHandler, DynamicIslandWindowView dynamicIslandWindowView, DynamicIslandAnimationDelegateHelper.Factory factory) {
        return new DynamicIslandAnimationDelegate(dynamicIslandBaseContentView, dynamicIslandAnimationController, smallIslandStateHandler, bigIslandStateHandler, expandedStateHandler, dynamicIslandWindowView, factory);
    }

    public DynamicIslandAnimationDelegate get(DynamicIslandBaseContentView dynamicIslandBaseContentView) {
        return DynamicIslandAnimationDelegate_Factory.newInstance(dynamicIslandBaseContentView, (DynamicIslandAnimationController)this.dynamicIslandAnimControllerProvider.get(), (SmallIslandStateHandler)this.smallIslandStateHandlerProvider.get(), (BigIslandStateHandler)this.bigIslandStateHandlerProvider.get(), (ExpandedStateHandler)this.expandedStateHandlerProvider.get(), (DynamicIslandWindowView)((Object)this.windowViewProvider.get()), (DynamicIslandAnimationDelegateHelper.Factory)this.animationDelegateHelperFactoryProvider.get());
    }
}
