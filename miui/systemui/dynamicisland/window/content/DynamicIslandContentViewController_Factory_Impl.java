/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  E0.f
 *  F0.a
 */
package miui.systemui.dynamicisland.window.content;

import E0.f;
import F0.a;
import miui.systemui.dynamicisland.window.content.DynamicIslandContentView;
import miui.systemui.dynamicisland.window.content.DynamicIslandContentViewController;
import miui.systemui.dynamicisland.window.content.DynamicIslandContentViewController_Factory;

public final class DynamicIslandContentViewController_Factory_Impl
implements DynamicIslandContentViewController.Factory {
    private final DynamicIslandContentViewController_Factory delegateFactory;

    public DynamicIslandContentViewController_Factory_Impl(DynamicIslandContentViewController_Factory dynamicIslandContentViewController_Factory) {
        this.delegateFactory = dynamicIslandContentViewController_Factory;
    }

    public static a create(DynamicIslandContentViewController_Factory dynamicIslandContentViewController_Factory) {
        return f.a((Object)new DynamicIslandContentViewController_Factory_Impl(dynamicIslandContentViewController_Factory));
    }

    @Override
    public DynamicIslandContentViewController create(DynamicIslandContentView dynamicIslandContentView) {
        return this.delegateFactory.get(dynamicIslandContentView);
    }
}
