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
import miui.systemui.dynamicisland.module.IslandTextViewHolder;

@f(c="miui.systemui.dynamicisland.module.IslandTextViewHolder", f="IslandTextViewHolder.kt", l={72}, m="initLayout$suspendImpl")
public static final class IslandTextViewHolder.initLayout.1
extends M0.d {
    Object L$0;
    Object L$1;
    int label;
    Object result;
    final IslandTextViewHolder this$0;

    public IslandTextViewHolder.initLayout.1(IslandTextViewHolder islandTextViewHolder, d d2) {
        this.this$0 = islandTextViewHolder;
        super(d2);
    }

    public final Object invokeSuspend(Object object) {
        this.result = object;
        this.label |= Integer.MIN_VALUE;
        return IslandTextViewHolder.initLayout$suspendImpl(this.this$0, null, null, (d)this);
    }
}
