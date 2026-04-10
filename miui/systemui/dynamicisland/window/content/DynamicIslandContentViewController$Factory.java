/*
 * Decompiled with CFR 0.152.
 */
package miui.systemui.dynamicisland.window.content;

import miui.systemui.dynamicisland.window.content.DynamicIslandBaseContentViewController;
import miui.systemui.dynamicisland.window.content.DynamicIslandContentView;
import miui.systemui.dynamicisland.window.content.DynamicIslandContentViewController;

public static interface DynamicIslandContentViewController.Factory
extends DynamicIslandBaseContentViewController.Factory<DynamicIslandContentView> {
    public DynamicIslandContentViewController create(DynamicIslandContentView var1);
}
