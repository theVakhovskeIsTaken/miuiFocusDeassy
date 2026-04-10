/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  E0.f
 *  F0.a
 */
package miui.systemui.dynamicisland.device.strategy;

import E0.f;
import F0.a;
import miui.systemui.dynamicisland.anim.DynamicIslandAnimationController;
import miui.systemui.dynamicisland.device.strategy.PadDynamicIslandAnimationDelegateHelper;
import miui.systemui.dynamicisland.device.strategy.PadDynamicIslandAnimationDelegateHelper_Factory;
import miui.systemui.dynamicisland.event.handler.BigIslandStateHandler;
import miui.systemui.dynamicisland.event.handler.ExpandedStateHandler;
import miui.systemui.dynamicisland.event.handler.SmallIslandStateHandler;
import miui.systemui.dynamicisland.window.DynamicIslandWindowView;
import miui.systemui.dynamicisland.window.content.DynamicIslandBaseContentView;

public final class PadDynamicIslandAnimationDelegateHelper_Factory_Impl
implements PadDynamicIslandAnimationDelegateHelper.Factory {
    private final PadDynamicIslandAnimationDelegateHelper_Factory delegateFactory;

    public PadDynamicIslandAnimationDelegateHelper_Factory_Impl(PadDynamicIslandAnimationDelegateHelper_Factory padDynamicIslandAnimationDelegateHelper_Factory) {
        this.delegateFactory = padDynamicIslandAnimationDelegateHelper_Factory;
    }

    public static a create(PadDynamicIslandAnimationDelegateHelper_Factory padDynamicIslandAnimationDelegateHelper_Factory) {
        return f.a((Object)new PadDynamicIslandAnimationDelegateHelper_Factory_Impl(padDynamicIslandAnimationDelegateHelper_Factory));
    }

    @Override
    public PadDynamicIslandAnimationDelegateHelper create(DynamicIslandBaseContentView dynamicIslandBaseContentView, DynamicIslandAnimationController dynamicIslandAnimationController, SmallIslandStateHandler smallIslandStateHandler, BigIslandStateHandler bigIslandStateHandler, ExpandedStateHandler expandedStateHandler, DynamicIslandWindowView dynamicIslandWindowView) {
        return this.delegateFactory.get(dynamicIslandBaseContentView, dynamicIslandAnimationController, smallIslandStateHandler, bigIslandStateHandler, expandedStateHandler, dynamicIslandWindowView);
    }
}
