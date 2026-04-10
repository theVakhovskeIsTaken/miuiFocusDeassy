/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  G0.i
 *  G0.s
 *  K0.d
 *  i1.g
 */
package miui.systemui.dynamicisland.window.content;

import G0.i;
import G0.s;
import K0.d;
import i1.g;
import miui.systemui.dynamicisland.window.content.DynamicIslandBaseContentView;
import miui.systemui.dynamicisland.window.content.DynamicIslandBaseContentViewController;

public static final class DynamicIslandBaseContentViewController.1<T>
implements g {
    final DynamicIslandBaseContentViewController<T> this$0;

    public DynamicIslandBaseContentViewController.1(DynamicIslandBaseContentViewController<? extends T> dynamicIslandBaseContentViewController) {
        this.this$0 = dynamicIslandBaseContentViewController;
    }

    public final Object emit(i i2, d d2) {
        ((DynamicIslandBaseContentView)((Object)this.this$0.getView())).setSwipeInfo(i2);
        return s.a;
    }
}
