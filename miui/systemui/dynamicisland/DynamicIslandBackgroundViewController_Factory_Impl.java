/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  E0.f
 *  F0.a
 */
package miui.systemui.dynamicisland;

import E0.f;
import F0.a;
import miui.systemui.dynamicisland.DynamicIslandBackgroundView;
import miui.systemui.dynamicisland.DynamicIslandBackgroundViewController;
import miui.systemui.dynamicisland.DynamicIslandBackgroundViewController_Factory;

public final class DynamicIslandBackgroundViewController_Factory_Impl
implements DynamicIslandBackgroundViewController.Factory {
    private final DynamicIslandBackgroundViewController_Factory delegateFactory;

    public DynamicIslandBackgroundViewController_Factory_Impl(DynamicIslandBackgroundViewController_Factory dynamicIslandBackgroundViewController_Factory) {
        this.delegateFactory = dynamicIslandBackgroundViewController_Factory;
    }

    public static a create(DynamicIslandBackgroundViewController_Factory dynamicIslandBackgroundViewController_Factory) {
        return f.a((Object)new DynamicIslandBackgroundViewController_Factory_Impl(dynamicIslandBackgroundViewController_Factory));
    }

    @Override
    public DynamicIslandBackgroundViewController create(DynamicIslandBackgroundView dynamicIslandBackgroundView) {
        return this.delegateFactory.get(dynamicIslandBackgroundView);
    }
}
