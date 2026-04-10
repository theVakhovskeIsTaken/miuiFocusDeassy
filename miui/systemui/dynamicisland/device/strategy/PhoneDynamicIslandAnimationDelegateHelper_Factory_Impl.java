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
import miui.systemui.dynamicisland.device.strategy.PhoneDynamicIslandAnimationDelegateHelper;
import miui.systemui.dynamicisland.device.strategy.PhoneDynamicIslandAnimationDelegateHelper_Factory;
import miui.systemui.dynamicisland.event.handler.BigIslandStateHandler;
import miui.systemui.dynamicisland.event.handler.ExpandedStateHandler;
import miui.systemui.dynamicisland.event.handler.SmallIslandStateHandler;
import miui.systemui.dynamicisland.window.DynamicIslandWindowView;
import miui.systemui.dynamicisland.window.content.DynamicIslandBaseContentView;

public final class PhoneDynamicIslandAnimationDelegateHelper_Factory_Impl
implements PhoneDynamicIslandAnimationDelegateHelper.Factory {
    private final PhoneDynamicIslandAnimationDelegateHelper_Factory delegateFactory;

    public PhoneDynamicIslandAnimationDelegateHelper_Factory_Impl(PhoneDynamicIslandAnimationDelegateHelper_Factory phoneDynamicIslandAnimationDelegateHelper_Factory) {
        this.delegateFactory = phoneDynamicIslandAnimationDelegateHelper_Factory;
    }

    public static a create(PhoneDynamicIslandAnimationDelegateHelper_Factory phoneDynamicIslandAnimationDelegateHelper_Factory) {
        return f.a((Object)new PhoneDynamicIslandAnimationDelegateHelper_Factory_Impl(phoneDynamicIslandAnimationDelegateHelper_Factory));
    }

    @Override
    public PhoneDynamicIslandAnimationDelegateHelper create(DynamicIslandBaseContentView dynamicIslandBaseContentView, DynamicIslandAnimationController dynamicIslandAnimationController, SmallIslandStateHandler smallIslandStateHandler, BigIslandStateHandler bigIslandStateHandler, ExpandedStateHandler expandedStateHandler, DynamicIslandWindowView dynamicIslandWindowView) {
        return this.delegateFactory.get(dynamicIslandBaseContentView, dynamicIslandAnimationController, smallIslandStateHandler, bigIslandStateHandler, expandedStateHandler, dynamicIslandWindowView);
    }
}
