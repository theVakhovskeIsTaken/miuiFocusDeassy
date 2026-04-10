/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  G0.s
 *  K0.d
 *  i1.g
 */
package miui.systemui.dynamicisland.window.content;

import G0.s;
import K0.d;
import i1.g;
import miui.systemui.dynamicisland.window.content.DynamicIslandContentViewController;

public static final class DynamicIslandContentViewController.listenForClick.1<T>
implements g {
    final DynamicIslandContentViewController this$0;

    public DynamicIslandContentViewController.listenForClick.1(DynamicIslandContentViewController dynamicIslandContentViewController) {
        this.this$0 = dynamicIslandContentViewController;
    }

    public final Object emit(s s2, d d2) {
        this.this$0.touchInteractor.performClick();
        return s.a;
    }
}
