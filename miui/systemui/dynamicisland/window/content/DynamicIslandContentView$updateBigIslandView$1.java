/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  K0.d
 *  M0.d
 *  M0.f
 */
package miui.systemui.dynamicisland.window.content;

import K0.d;
import M0.f;
import miui.systemui.dynamicisland.window.content.DynamicIslandContentView;

@f(c="miui.systemui.dynamicisland.window.content.DynamicIslandContentView", f="DynamicIslandContentView.kt", l={414}, m="updateBigIslandView")
public static final class DynamicIslandContentView.updateBigIslandView.1
extends M0.d {
    Object L$0;
    Object L$1;
    int label;
    Object result;
    final DynamicIslandContentView this$0;

    public DynamicIslandContentView.updateBigIslandView.1(DynamicIslandContentView dynamicIslandContentView, d d2) {
        this.this$0 = dynamicIslandContentView;
        super(d2);
    }

    public final Object invokeSuspend(Object object) {
        this.result = object;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.updateBigIslandView(null, false, (d)this);
    }
}
