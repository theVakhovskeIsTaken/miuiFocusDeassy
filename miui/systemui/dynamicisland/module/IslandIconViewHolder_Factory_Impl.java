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
import miui.systemui.dynamicisland.module.IslandIconViewHolder;
import miui.systemui.dynamicisland.module.IslandIconViewHolder_Factory;

public final class IslandIconViewHolder_Factory_Impl
implements IslandIconViewHolder.Factory {
    private final IslandIconViewHolder_Factory delegateFactory;

    public IslandIconViewHolder_Factory_Impl(IslandIconViewHolder_Factory islandIconViewHolder_Factory) {
        this.delegateFactory = islandIconViewHolder_Factory;
    }

    public static a create(IslandIconViewHolder_Factory islandIconViewHolder_Factory) {
        return f.a((Object)new IslandIconViewHolder_Factory_Impl(islandIconViewHolder_Factory));
    }

    @Override
    public IslandIconViewHolder create(ViewGroup viewGroup, o o2) {
        return this.delegateFactory.get(viewGroup, o2);
    }
}
