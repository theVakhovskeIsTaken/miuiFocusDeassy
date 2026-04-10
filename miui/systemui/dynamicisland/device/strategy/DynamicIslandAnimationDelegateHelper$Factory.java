/*
 * Decompiled with CFR 0.152.
 */
package miui.systemui.dynamicisland.device.strategy;

import miui.systemui.dynamicisland.anim.DynamicIslandAnimationController;
import miui.systemui.dynamicisland.device.strategy.DynamicIslandAnimationDelegateHelper;
import miui.systemui.dynamicisland.event.handler.BigIslandStateHandler;
import miui.systemui.dynamicisland.event.handler.ExpandedStateHandler;
import miui.systemui.dynamicisland.event.handler.SmallIslandStateHandler;
import miui.systemui.dynamicisland.window.DynamicIslandWindowView;
import miui.systemui.dynamicisland.window.content.DynamicIslandBaseContentView;

public static interface DynamicIslandAnimationDelegateHelper.Factory {
    public DynamicIslandAnimationDelegateHelper create(DynamicIslandBaseContentView var1, DynamicIslandAnimationController var2, SmallIslandStateHandler var3, BigIslandStateHandler var4, ExpandedStateHandler var5, DynamicIslandWindowView var6);
}
