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
import miui.systemui.dynamicisland.module.IslandSameWidthDigitViewHolder;

@f(c="miui.systemui.dynamicisland.module.IslandSameWidthDigitViewHolder", f="IslandSameWidthDigitViewHolder.kt", l={91}, m="initLayout$suspendImpl")
public static final class IslandSameWidthDigitViewHolder.initLayout.1
extends M0.d {
    Object L$0;
    Object L$1;
    int label;
    Object result;
    final IslandSameWidthDigitViewHolder this$0;

    public IslandSameWidthDigitViewHolder.initLayout.1(IslandSameWidthDigitViewHolder islandSameWidthDigitViewHolder, d d2) {
        this.this$0 = islandSameWidthDigitViewHolder;
        super(d2);
    }

    public final Object invokeSuspend(Object object) {
        this.result = object;
        this.label |= Integer.MIN_VALUE;
        return IslandSameWidthDigitViewHolder.initLayout$suspendImpl(this.this$0, null, null, (d)this);
    }
}
