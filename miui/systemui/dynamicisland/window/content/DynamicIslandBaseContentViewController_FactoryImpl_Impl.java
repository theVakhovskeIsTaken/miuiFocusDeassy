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
import miui.systemui.dynamicisland.window.content.DynamicIslandBaseContentView;
import miui.systemui.dynamicisland.window.content.DynamicIslandBaseContentViewController;
import miui.systemui.dynamicisland.window.content.DynamicIslandBaseContentViewController_Factory;

public final class DynamicIslandBaseContentViewController_FactoryImpl_Impl
implements DynamicIslandBaseContentViewController.FactoryImpl {
    private final DynamicIslandBaseContentViewController_Factory<DynamicIslandBaseContentView> delegateFactory;

    public DynamicIslandBaseContentViewController_FactoryImpl_Impl(DynamicIslandBaseContentViewController_Factory<DynamicIslandBaseContentView> dynamicIslandBaseContentViewController_Factory) {
        this.delegateFactory = dynamicIslandBaseContentViewController_Factory;
    }

    public static <T extends DynamicIslandBaseContentView> a create(DynamicIslandBaseContentViewController_Factory<DynamicIslandBaseContentView> dynamicIslandBaseContentViewController_Factory) {
        return f.a((Object)new DynamicIslandBaseContentViewController_FactoryImpl_Impl(dynamicIslandBaseContentViewController_Factory));
    }

    @Override
    public DynamicIslandBaseContentViewController<DynamicIslandBaseContentView> create(DynamicIslandBaseContentView dynamicIslandBaseContentView) {
        return this.delegateFactory.get(dynamicIslandBaseContentView);
    }
}
