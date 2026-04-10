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
import miui.systemui.dynamicisland.module.IslandProgressViewHolder;

@f(c="miui.systemui.dynamicisland.module.IslandProgressViewHolder", f="IslandProgressViewHolder.kt", l={47}, m="initLayout")
public static final class IslandProgressViewHolder.initLayout.1
extends M0.d {
    Object L$0;
    Object L$1;
    int label;
    Object result;
    final IslandProgressViewHolder this$0;

    public IslandProgressViewHolder.initLayout.1(IslandProgressViewHolder islandProgressViewHolder, d d2) {
        this.this$0 = islandProgressViewHolder;
        super(d2);
    }

    public final Object invokeSuspend(Object object) {
        this.result = object;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.initLayout(null, null, (d)this);
    }
}
