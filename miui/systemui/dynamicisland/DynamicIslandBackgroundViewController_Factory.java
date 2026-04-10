/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  F0.a
 *  f1.E
 */
package miui.systemui.dynamicisland;

import F0.a;
import f1.E;
import miui.systemui.dynamicisland.DynamicIslandBackgroundView;
import miui.systemui.dynamicisland.DynamicIslandBackgroundViewController;

public final class DynamicIslandBackgroundViewController_Factory {
    private final a scopeProvider;

    public DynamicIslandBackgroundViewController_Factory(a a2) {
        this.scopeProvider = a2;
    }

    public static DynamicIslandBackgroundViewController_Factory create(a a2) {
        return new DynamicIslandBackgroundViewController_Factory(a2);
    }

    public static DynamicIslandBackgroundViewController newInstance(DynamicIslandBackgroundView dynamicIslandBackgroundView, E e) {
        return new DynamicIslandBackgroundViewController(dynamicIslandBackgroundView, e);
    }

    public DynamicIslandBackgroundViewController get(DynamicIslandBackgroundView dynamicIslandBackgroundView) {
        return DynamicIslandBackgroundViewController_Factory.newInstance(dynamicIslandBackgroundView, (E)this.scopeProvider.get());
    }
}
