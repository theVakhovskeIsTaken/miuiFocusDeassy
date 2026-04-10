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
import miui.systemui.dynamicisland.module.IslandProgressViewHolder;
import miui.systemui.dynamicisland.module.IslandProgressViewHolder_Factory;

public final class IslandProgressViewHolder_Factory_Impl
implements IslandProgressViewHolder.Factory {
    private final IslandProgressViewHolder_Factory delegateFactory;

    public IslandProgressViewHolder_Factory_Impl(IslandProgressViewHolder_Factory islandProgressViewHolder_Factory) {
        this.delegateFactory = islandProgressViewHolder_Factory;
    }

    public static a create(IslandProgressViewHolder_Factory islandProgressViewHolder_Factory) {
        return f.a((Object)new IslandProgressViewHolder_Factory_Impl(islandProgressViewHolder_Factory));
    }

    @Override
    public IslandProgressViewHolder create(ViewGroup viewGroup, o o2) {
        return this.delegateFactory.get(viewGroup, o2);
    }
}
