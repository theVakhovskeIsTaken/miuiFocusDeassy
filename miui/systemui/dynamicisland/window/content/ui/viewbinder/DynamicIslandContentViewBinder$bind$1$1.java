/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  G0.s
 *  K0.d
 *  i1.g
 */
package miui.systemui.dynamicisland.window.content.ui.viewbinder;

import G0.s;
import K0.d;
import i1.g;
import miui.systemui.dynamicisland.window.content.DynamicIslandContentView;

public static final class DynamicIslandContentViewBinder.bind.1<T>
implements g {
    final DynamicIslandContentView $view;

    public DynamicIslandContentViewBinder.bind.1(DynamicIslandContentView dynamicIslandContentView) {
        this.$view = dynamicIslandContentView;
    }

    public final Object emit(boolean bl, d d2) {
        this.$view.setBlockChildrenTouch(bl ^ true);
        return s.a;
    }
}
