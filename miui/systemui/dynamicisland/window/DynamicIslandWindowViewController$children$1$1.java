/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  U0.a
 *  kotlin.jvm.internal.p
 */
package miui.systemui.dynamicisland.window;

import U0.a;
import kotlin.jvm.internal.p;
import miui.systemui.dynamicisland.window.DynamicIslandWindowView;

public static final class DynamicIslandWindowViewController.children.1
extends p
implements a {
    final DynamicIslandWindowView $view;

    public DynamicIslandWindowViewController.children.1(DynamicIslandWindowView dynamicIslandWindowView) {
        this.$view = dynamicIslandWindowView;
        super(0);
    }

    public final void invoke() {
        this.$view.setOnHierarchyChangeListener(null);
    }
}
