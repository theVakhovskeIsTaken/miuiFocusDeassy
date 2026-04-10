/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  K0.d
 *  M0.d
 *  M0.f
 */
package miui.systemui.dynamicisland.module;

import K0.d;
import M0.f;
import miui.systemui.dynamicisland.module.IslandIconFixedWidthTextHolder;

@f(c="miui.systemui.dynamicisland.module.IslandIconFixedWidthTextHolder", f="IslandIconFixedWidthTextHolder.kt", l={57, 58}, m="initLayout")
public static final class IslandIconFixedWidthTextHolder.initLayout.1
extends M0.d {
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    Object result;
    final IslandIconFixedWidthTextHolder this$0;

    public IslandIconFixedWidthTextHolder.initLayout.1(IslandIconFixedWidthTextHolder islandIconFixedWidthTextHolder, d d2) {
        this.this$0 = islandIconFixedWidthTextHolder;
        super(d2);
    }

    public final Object invokeSuspend(Object object) {
        this.result = object;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.initLayout(null, null, (d)this);
    }
}
