/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  E0.f
 *  F0.a
 */
package miui.systemui.dynamicisland.anim;

import E0.f;
import F0.a;
import miui.systemui.dynamicisland.anim.DynamicIslandAnimationDelegate;
import miui.systemui.dynamicisland.anim.DynamicIslandAnimationDelegate_Factory;
import miui.systemui.dynamicisland.window.content.DynamicIslandBaseContentView;

public final class DynamicIslandAnimationDelegate_Factory_Impl
implements DynamicIslandAnimationDelegate.Factory {
    private final DynamicIslandAnimationDelegate_Factory delegateFactory;

    public DynamicIslandAnimationDelegate_Factory_Impl(DynamicIslandAnimationDelegate_Factory dynamicIslandAnimationDelegate_Factory) {
        this.delegateFactory = dynamicIslandAnimationDelegate_Factory;
    }

    public static a create(DynamicIslandAnimationDelegate_Factory dynamicIslandAnimationDelegate_Factory) {
        return f.a((Object)new DynamicIslandAnimationDelegate_Factory_Impl(dynamicIslandAnimationDelegate_Factory));
    }

    @Override
    public DynamicIslandAnimationDelegate create(DynamicIslandBaseContentView dynamicIslandBaseContentView) {
        return this.delegateFactory.get(dynamicIslandBaseContentView);
    }
}
