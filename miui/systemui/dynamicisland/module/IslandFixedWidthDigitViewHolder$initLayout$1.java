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
import miui.systemui.dynamicisland.module.IslandFixedWidthDigitViewHolder;

@f(c="miui.systemui.dynamicisland.module.IslandFixedWidthDigitViewHolder", f="IslandFixedWidthDigitViewHolder.kt", l={59}, m="initLayout$suspendImpl")
public static final class IslandFixedWidthDigitViewHolder.initLayout.1
extends M0.d {
    Object L$0;
    Object L$1;
    int label;
    Object result;
    final IslandFixedWidthDigitViewHolder this$0;

    public IslandFixedWidthDigitViewHolder.initLayout.1(IslandFixedWidthDigitViewHolder islandFixedWidthDigitViewHolder, d d2) {
        this.this$0 = islandFixedWidthDigitViewHolder;
        super(d2);
    }

    public final Object invokeSuspend(Object object) {
        this.result = object;
        this.label |= Integer.MIN_VALUE;
        return IslandFixedWidthDigitViewHolder.initLayout$suspendImpl(this.this$0, null, null, (d)this);
    }
}
