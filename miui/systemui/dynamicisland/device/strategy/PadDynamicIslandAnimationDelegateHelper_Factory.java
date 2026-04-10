/*
 * Decompiled with CFR 0.152.
 */
package miui.systemui.dynamicisland.device.strategy;

import miui.systemui.dynamicisland.anim.DynamicIslandAnimationController;
import miui.systemui.dynamicisland.device.strategy.PadDynamicIslandAnimationDelegateHelper;
import miui.systemui.dynamicisland.event.handler.BigIslandStateHandler;
import miui.systemui.dynamicisland.event.handler.ExpandedStateHandler;
import miui.systemui.dynamicisland.event.handler.SmallIslandStateHandler;
import miui.systemui.dynamicisland.window.DynamicIslandWindowView;
import miui.systemui.dynamicisland.window.content.DynamicIslandBaseContentView;

public final class PadDynamicIslandAnimationDelegateHelper_Factory {
    public static PadDynamicIslandAnimationDelegateHelper_Factory create() {
        return new PadDynamicIslandAnimationDelegateHelper_Factory();
    }

    public static PadDynamicIslandAnimationDelegateHelper newInstance(DynamicIslandBaseContentView dynamicIslandBaseContentView, DynamicIslandAnimationController dynamicIslandAnimationController, SmallIslandStateHandler smallIslandStateHandler, BigIslandStateHandler bigIslandStateHandler, ExpandedStateHandler expandedStateHandler, DynamicIslandWindowView dynamicIslandWindowView) {
        return new PadDynamicIslandAnimationDelegateHelper(dynamicIslandBaseContentView, dynamicIslandAnimationController, smallIslandStateHandler, bigIslandStateHandler, expandedStateHandler, dynamicIslandWindowView);
    }

    public PadDynamicIslandAnimationDelegateHelper get(DynamicIslandBaseContentView dynamicIslandBaseContentView, DynamicIslandAnimationController dynamicIslandAnimationController, SmallIslandStateHandler smallIslandStateHandler, BigIslandStateHandler bigIslandStateHandler, ExpandedStateHandler expandedStateHandler, DynamicIslandWindowView dynamicIslandWindowView) {
        return PadDynamicIslandAnimationDelegateHelper_Factory.newInstance(dynamicIslandBaseContentView, dynamicIslandAnimationController, smallIslandStateHandler, bigIslandStateHandler, expandedStateHandler, dynamicIslandWindowView);
    }
}
