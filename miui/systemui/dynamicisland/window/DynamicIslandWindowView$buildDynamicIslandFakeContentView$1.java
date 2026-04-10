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

@f(c="miui.systemui.dynamicisland.window.DynamicIslandWindowView", f="DynamicIslandWindowView.kt", l={635}, m="buildDynamicIslandFakeContentView")
public static final class DynamicIslandWindowView.buildDynamicIslandFakeContentView.1
extends M0.d {
    Object L$0;
    Object L$1;
    int label;
    Object result;
    final DynamicIslandWindowView this$0;

    public DynamicIslandWindowView.buildDynamicIslandFakeContentView.1(DynamicIslandWindowView dynamicIslandWindowView, d d2) {
        this.this$0 = dynamicIslandWindowView;
        super(d2);
    }

    public final Object invokeSuspend(Object object) {
        this.result = object;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.buildDynamicIslandFakeContentView(null, null, (d)this);
    }
}
