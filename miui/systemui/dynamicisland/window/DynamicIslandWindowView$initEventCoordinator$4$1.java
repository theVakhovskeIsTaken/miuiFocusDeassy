/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  G0.s
 *  K0.d
 *  M0.b
 *  i1.g
 *  kotlin.jvm.internal.o
 */
package miui.systemui.dynamicisland.window;

import G0.s;
import K0.d;
import M0.b;
import i1.g;
import kotlin.jvm.internal.o;
import miui.systemui.dynamicisland.event.DynamicIslandEventCoordinator;
import miui.systemui.dynamicisland.window.DynamicIslandWindowView;

public static final class DynamicIslandWindowView.initEventCoordinator.1<T>
implements g {
    final DynamicIslandWindowView this$0;

    public DynamicIslandWindowView.initEventCoordinator.1(DynamicIslandWindowView dynamicIslandWindowView) {
        this.this$0 = dynamicIslandWindowView;
    }

    public final Object emit(Boolean object, d object2) {
        object2 = this.this$0.getEventCoordinator();
        if (object2 != null) {
            ((DynamicIslandEventCoordinator)object2).updateTouchRegion();
        }
        if (o.c((Object)object, (Object)b.a((boolean)false)) && this.this$0.getCurrentExpandedState() == null && (object = this.this$0.getEventCoordinator()) != null) {
            ((DynamicIslandEventCoordinator)object).resetSwipe(0.0f, 0.0f);
        }
        return s.a;
    }
}
