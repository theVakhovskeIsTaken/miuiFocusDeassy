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
import miui.systemui.dynamicisland.module.IslandSameWidthDigitViewHolder;
import miui.systemui.dynamicisland.module.IslandSameWidthDigitViewHolder_Factory;

public final class IslandSameWidthDigitViewHolder_Factory_Impl
implements IslandSameWidthDigitViewHolder.Factory {
    private final IslandSameWidthDigitViewHolder_Factory delegateFactory;

    public IslandSameWidthDigitViewHolder_Factory_Impl(IslandSameWidthDigitViewHolder_Factory islandSameWidthDigitViewHolder_Factory) {
        this.delegateFactory = islandSameWidthDigitViewHolder_Factory;
    }

    public static a create(IslandSameWidthDigitViewHolder_Factory islandSameWidthDigitViewHolder_Factory) {
        return f.a((Object)new IslandSameWidthDigitViewHolder_Factory_Impl(islandSameWidthDigitViewHolder_Factory));
    }

    @Override
    public IslandSameWidthDigitViewHolder create(ViewGroup viewGroup, o o2) {
        return this.delegateFactory.get(viewGroup, o2);
    }
}
