/*
 * Decompiled with CFR 0.152.
 */
package miui.systemui.dynamicisland.window;

import miui.systemui.dynamicisland.event.DynamicIslandState;
import miui.systemui.dynamicisland.window.content.DynamicIslandContentView;

public static interface DynamicIslandViewModel.DynamicIslandViewStateChangeCallback {
    public void onStateChanged(DynamicIslandState var1, DynamicIslandState var2);

    public void onStateChanged(DynamicIslandContentView var1);
}
