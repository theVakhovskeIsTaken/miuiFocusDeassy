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
import miui.systemui.dynamicisland.event.DynamicIslandEventCoordinator;
import miui.systemui.dynamicisland.window.content.DynamicIslandBaseContentView;
import miui.systemui.dynamicisland.window.content.DynamicIslandBaseContentViewController;

public static final class DynamicIslandBaseContentViewController.2<T>
implements g {
    final DynamicIslandBaseContentViewController<T> this$0;

    public DynamicIslandBaseContentViewController.2(DynamicIslandBaseContentViewController<? extends T> dynamicIslandBaseContentViewController) {
        this.this$0 = dynamicIslandBaseContentViewController;
    }

    public final Object emit(boolean bl, d object) {
        object = ((DynamicIslandBaseContentView)((Object)this.this$0.getView())).getDynamicIslandEventCoordinator();
        if (object != null) {
            ((DynamicIslandEventCoordinator)object).updateTouchRegion();
        }
        return s.a;
    }
}
