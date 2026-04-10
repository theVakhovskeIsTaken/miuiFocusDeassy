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
import miui.systemui.dynamicisland.module.IslandProgressTextViewHolder;

@f(c="miui.systemui.dynamicisland.module.IslandProgressTextViewHolder", f="IslandProgressTextViewHolder.kt", l={40, 41, 42}, m="initLayout")
public static final class IslandProgressTextViewHolder.initLayout.1
extends M0.d {
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    Object result;
    final IslandProgressTextViewHolder this$0;

    public IslandProgressTextViewHolder.initLayout.1(IslandProgressTextViewHolder islandProgressTextViewHolder, d d2) {
        this.this$0 = islandProgressTextViewHolder;
        super(d2);
    }

    public final Object invokeSuspend(Object object) {
        this.result = object;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.initLayout(null, null, (d)this);
    }
}
