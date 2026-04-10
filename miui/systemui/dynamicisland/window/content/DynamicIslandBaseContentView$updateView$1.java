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
import miui.systemui.dynamicisland.window.content.DynamicIslandBaseContentView;

@f(c="miui.systemui.dynamicisland.window.content.DynamicIslandBaseContentView", f="DynamicIslandBaseContentView.kt", l={481, 482, 484}, m="updateView")
public static final class DynamicIslandBaseContentView.updateView.1
extends M0.d {
    Object L$0;
    Object L$1;
    boolean Z$0;
    boolean Z$1;
    boolean Z$2;
    int label;
    Object result;
    final DynamicIslandBaseContentView this$0;

    public DynamicIslandBaseContentView.updateView.1(DynamicIslandBaseContentView dynamicIslandBaseContentView, d d2) {
        this.this$0 = dynamicIslandBaseContentView;
        super(d2);
    }

    public final Object invokeSuspend(Object object) {
        this.result = object;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.updateView(null, false, false, (d)this);
    }
}
