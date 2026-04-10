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
import miui.systemui.dynamicisland.module.IslandCombineImageViewHolder;
import miui.systemui.dynamicisland.module.IslandCombineImageViewHolder_Factory;

public final class IslandCombineImageViewHolder_Factory_Impl
implements IslandCombineImageViewHolder.Factory {
    private final IslandCombineImageViewHolder_Factory delegateFactory;

    public IslandCombineImageViewHolder_Factory_Impl(IslandCombineImageViewHolder_Factory islandCombineImageViewHolder_Factory) {
        this.delegateFactory = islandCombineImageViewHolder_Factory;
    }

    public static a create(IslandCombineImageViewHolder_Factory islandCombineImageViewHolder_Factory) {
        return f.a((Object)new IslandCombineImageViewHolder_Factory_Impl(islandCombineImageViewHolder_Factory));
    }

    @Override
    public IslandCombineImageViewHolder create(ViewGroup viewGroup, o o2) {
        return this.delegateFactory.get(viewGroup, o2);
    }
}
