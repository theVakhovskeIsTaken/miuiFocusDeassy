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
import miui.systemui.dynamicisland.window.content.DynamicIslandContentFakeView;

@f(c="miui.systemui.dynamicisland.window.content.DynamicIslandContentFakeView", f="DynamicIslandContentFakeView.kt", l={111}, m="updateBigIslandView")
public static final class DynamicIslandContentFakeView.updateBigIslandView.1
extends M0.d {
    Object L$0;
    int label;
    Object result;
    final DynamicIslandContentFakeView this$0;

    public DynamicIslandContentFakeView.updateBigIslandView.1(DynamicIslandContentFakeView dynamicIslandContentFakeView, d d2) {
        this.this$0 = dynamicIslandContentFakeView;
        super(d2);
    }

    public final Object invokeSuspend(Object object) {
        this.result = object;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.updateBigIslandView(null, false, (d)this);
    }
}
