/*
 * Decompiled with CFR 0.152.
 */
package miui.systemui.dynamicisland.device.strategy;

import miui.systemui.dynamicisland.anim.DynamicIslandAnimationController;
import miui.systemui.dynamicisland.device.strategy.PhoneDynamicIslandAnimationDelegateHelper;
import miui.systemui.dynamicisland.event.handler.BigIslandStateHandler;
import miui.systemui.dynamicisland.event.handler.ExpandedStateHandler;
import miui.systemui.dynamicisland.event.handler.SmallIslandStateHandler;
import miui.systemui.dynamicisland.window.DynamicIslandWindowView;
import miui.systemui.dynamicisland.window.content.DynamicIslandBaseContentView;

public final class PhoneDynamicIslandAnimationDelegateHelper_Factory {
    public static PhoneDynamicIslandAnimationDelegateHelper_Factory create() {
        return new PhoneDynamicIslandAnimationDelegateHelper_Factory();
    }

    public static PhoneDynamicIslandAnimationDelegateHelper newInstance(DynamicIslandBaseContentView dynamicIslandBaseContentView, DynamicIslandAnimationController dynamicIslandAnimationController, SmallIslandStateHandler smallIslandStateHandler, BigIslandStateHandler bigIslandStateHandler, ExpandedStateHandler expandedStateHandler, DynamicIslandWindowView dynamicIslandWindowView) {
        return new PhoneDynamicIslandAnimationDelegateHelper(dynamicIslandBaseContentView, dynamicIslandAnimationController, smallIslandStateHandler, bigIslandStateHandler, expandedStateHandler, dynamicIslandWindowView);
    }

    public PhoneDynamicIslandAnimationDelegateHelper get(DynamicIslandBaseContentView dynamicIslandBaseContentView, DynamicIslandAnimationController dynamicIslandAnimationController, SmallIslandStateHandler smallIslandStateHandler, BigIslandStateHandler bigIslandStateHandler, ExpandedStateHandler expandedStateHandler, DynamicIslandWindowView dynamicIslandWindowView) {
        return PhoneDynamicIslandAnimationDelegateHelper_Factory.newInstance(dynamicIslandBaseContentView, dynamicIslandAnimationController, smallIslandStateHandler, bigIslandStateHandler, expandedStateHandler, dynamicIslandWindowView);
    }
}
