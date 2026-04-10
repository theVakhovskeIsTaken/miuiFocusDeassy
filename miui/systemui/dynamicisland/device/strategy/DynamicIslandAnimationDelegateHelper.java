/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 *  android.util.Log
 *  kotlin.jvm.internal.o
 */
package miui.systemui.dynamicisland.device.strategy;

import android.os.Bundle;
import android.util.Log;
import kotlin.jvm.internal.o;
import miui.systemui.dynamicisland.anim.DynamicIslandAnimationController;
import miui.systemui.dynamicisland.anim.DynamicIslandAnimationType;
import miui.systemui.dynamicisland.event.DynamicIslandEventCoordinator;
import miui.systemui.dynamicisland.event.handler.BigIslandStateHandler;
import miui.systemui.dynamicisland.event.handler.ExpandedStateHandler;
import miui.systemui.dynamicisland.event.handler.SmallIslandStateHandler;
import miui.systemui.dynamicisland.window.DynamicIslandWindowView;
import miui.systemui.dynamicisland.window.content.DynamicIslandBaseContentView;
import miui.systemui.dynamicisland.window.content.DynamicIslandContentView;

public abstract class DynamicIslandAnimationDelegateHelper {
    private final BigIslandStateHandler bigIslandStateHandler;
    private final DynamicIslandAnimationController dynamicIslandAnimController;
    private final ExpandedStateHandler expandedStateHandler;
    private final SmallIslandStateHandler smallIslandStateHandler;
    private final DynamicIslandBaseContentView view;
    private final DynamicIslandWindowView windowView;

    public DynamicIslandAnimationDelegateHelper(DynamicIslandBaseContentView dynamicIslandBaseContentView, DynamicIslandAnimationController dynamicIslandAnimationController, SmallIslandStateHandler smallIslandStateHandler, BigIslandStateHandler bigIslandStateHandler, ExpandedStateHandler expandedStateHandler, DynamicIslandWindowView dynamicIslandWindowView) {
        o.g((Object)((Object)dynamicIslandBaseContentView), (String)"view");
        o.g((Object)dynamicIslandAnimationController, (String)"dynamicIslandAnimController");
        o.g((Object)smallIslandStateHandler, (String)"smallIslandStateHandler");
        o.g((Object)bigIslandStateHandler, (String)"bigIslandStateHandler");
        o.g((Object)expandedStateHandler, (String)"expandedStateHandler");
        o.g((Object)((Object)dynamicIslandWindowView), (String)"windowView");
        this.view = dynamicIslandBaseContentView;
        this.dynamicIslandAnimController = dynamicIslandAnimationController;
        this.smallIslandStateHandler = smallIslandStateHandler;
        this.bigIslandStateHandler = bigIslandStateHandler;
        this.expandedStateHandler = expandedStateHandler;
        this.windowView = dynamicIslandWindowView;
    }

    public final BigIslandStateHandler getBigIslandStateHandler() {
        return this.bigIslandStateHandler;
    }

    public final DynamicIslandAnimationController getDynamicIslandAnimController() {
        return this.dynamicIslandAnimController;
    }

    public final ExpandedStateHandler getExpandedStateHandler() {
        return this.expandedStateHandler;
    }

    public final SmallIslandStateHandler getSmallIslandStateHandler() {
        return this.smallIslandStateHandler;
    }

    public final DynamicIslandBaseContentView getView() {
        return this.view;
    }

    public final DynamicIslandWindowView getWindowView() {
        return this.windowView;
    }

    public abstract void requestUpdateHeadsUpLocation(DynamicIslandAnimationType var1, DynamicIslandContentView var2);

    public abstract void updateBigIslandContainerBackground(DynamicIslandBaseContentView var1);

    public final void updateHeadsUpLocation(boolean bl, int n, int n2) {
        Object object = this.view;
        int n3 = bl ? ((DynamicIslandBaseContentView)((Object)object)).getPadMultiNotificationMargin() : ((DynamicIslandBaseContentView)((Object)object)).getHeadsUpStatusBarPadding();
        int n4 = n + n2 + n3;
        object = new StringBuilder();
        ((StringBuilder)object).append("isExpand:");
        ((StringBuilder)object).append(bl);
        ((StringBuilder)object).append(", islandBottom:");
        ((StringBuilder)object).append(n4);
        ((StringBuilder)object).append(", transY:");
        ((StringBuilder)object).append(n);
        ((StringBuilder)object).append(", height:");
        ((StringBuilder)object).append(n2);
        ((StringBuilder)object).append(", headsUpTopPadding:");
        ((StringBuilder)object).append(n3);
        Log.d((String)"updateHeadsUpLocation", (String)((StringBuilder)object).toString());
        object = new Bundle();
        object.putString("action_key", "action_location_changed_for_heads_up");
        object.putBoolean("extra_is_expand", bl);
        object.putInt("extra_island_bottom", n4);
        DynamicIslandEventCoordinator dynamicIslandEventCoordinator = this.view.getDynamicIslandEventCoordinator();
        if (dynamicIslandEventCoordinator != null && (dynamicIslandEventCoordinator = dynamicIslandEventCoordinator.getDynamicIslandViewChangedListener()) != null) {
            dynamicIslandEventCoordinator.onIslandViewChanged((Bundle)object);
        }
    }
}
