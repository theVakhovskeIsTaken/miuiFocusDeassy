/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  E0.f
 *  F0.a
 *  U0.o
 *  android.view.ViewGroup
 */
package miui.systemui.dynamicisland.module;

import E0.f;
import F0.a;
import U0.o;
import android.view.ViewGroup;
import miui.systemui.dynamicisland.module.IslandFixedWidthDigitViewHolder;
import miui.systemui.dynamicisland.module.IslandFixedWidthDigitViewHolder_Factory;

public final class IslandFixedWidthDigitViewHolder_Factory_Impl
implements IslandFixedWidthDigitViewHolder.Factory {
    private final IslandFixedWidthDigitViewHolder_Factory delegateFactory;

    public IslandFixedWidthDigitViewHolder_Factory_Impl(IslandFixedWidthDigitViewHolder_Factory islandFixedWidthDigitViewHolder_Factory) {
        this.delegateFactory = islandFixedWidthDigitViewHolder_Factory;
    }

    public static a create(IslandFixedWidthDigitViewHolder_Factory islandFixedWidthDigitViewHolder_Factory) {
        return f.a((Object)new IslandFixedWidthDigitViewHolder_Factory_Impl(islandFixedWidthDigitViewHolder_Factory));
    }

    @Override
    public IslandFixedWidthDigitViewHolder create(ViewGroup viewGroup, o o2) {
        return this.delegateFactory.get(viewGroup, o2);
    }
}
