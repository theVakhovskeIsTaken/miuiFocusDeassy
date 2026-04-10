/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  K0.d
 *  M0.d
 *  M0.f
 */
package miui.systemui.dynamicisland.window;

import K0.d;
import M0.f;
import miui.systemui.dynamicisland.window.DynamicIslandWindowView;

@f(c="miui.systemui.dynamicisland.window.DynamicIslandWindowView", f="DynamicIslandWindowView.kt", l={742, 746, 754, 757, 760, 764}, m="addDynamicIslandDataSuspend")
public static final class DynamicIslandWindowView.addDynamicIslandDataSuspend.1
extends M0.d {
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    boolean Z$0;
    int label;
    Object result;
    final DynamicIslandWindowView this$0;

    public DynamicIslandWindowView.addDynamicIslandDataSuspend.1(DynamicIslandWindowView dynamicIslandWindowView, d d2) {
        this.this$0 = dynamicIslandWindowView;
        super(d2);
    }

    public final Object invokeSuspend(Object object) {
        this.result = object;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.addDynamicIslandDataSuspend(null, false, 0.0f, 0.0f, false, false, (d)this);
    }
}
