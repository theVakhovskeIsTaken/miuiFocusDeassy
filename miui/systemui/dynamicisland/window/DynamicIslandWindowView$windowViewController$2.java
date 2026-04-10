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
import miui.systemui.dynamicisland.window.DynamicIslandWindowViewController;

public static final class DynamicIslandWindowView.windowViewController.2
extends p
implements a {
    final DynamicIslandWindowView this$0;

    public DynamicIslandWindowView.windowViewController.2(DynamicIslandWindowView dynamicIslandWindowView) {
        this.this$0 = dynamicIslandWindowView;
        super(0);
    }

    public final DynamicIslandWindowViewController invoke() {
        return this.this$0.getViewComponent().getDynamicIslandWindowViewController();
    }
}
