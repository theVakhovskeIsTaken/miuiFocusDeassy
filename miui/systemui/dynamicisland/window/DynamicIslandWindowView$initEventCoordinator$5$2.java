/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  G0.s
 *  K0.d
 *  i1.g
 */
package miui.systemui.dynamicisland.window;

import G0.s;
import K0.d;
import i1.g;
import miui.systemui.dynamicisland.event.DynamicIslandEventCoordinator;
import miui.systemui.dynamicisland.window.DynamicIslandWindowView;

public static final class DynamicIslandWindowView.initEventCoordinator.2<T>
implements g {
    final DynamicIslandWindowView this$0;

    public DynamicIslandWindowView.initEventCoordinator.2(DynamicIslandWindowView dynamicIslandWindowView) {
        this.this$0 = dynamicIslandWindowView;
    }

    public final Object emit(boolean bl, d object) {
        object = this.this$0.getEventCoordinator();
        if (object != null) {
            ((DynamicIslandEventCoordinator)object).updateTouchRegion();
        }
        return s.a;
    }
}
