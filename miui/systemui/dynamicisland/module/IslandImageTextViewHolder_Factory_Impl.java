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
import miui.systemui.dynamicisland.module.IslandImageTextViewHolder;
import miui.systemui.dynamicisland.module.IslandImageTextViewHolder_Factory;

public final class IslandImageTextViewHolder_Factory_Impl
implements IslandImageTextViewHolder.Factory {
    private final IslandImageTextViewHolder_Factory delegateFactory;

    public IslandImageTextViewHolder_Factory_Impl(IslandImageTextViewHolder_Factory islandImageTextViewHolder_Factory) {
        this.delegateFactory = islandImageTextViewHolder_Factory;
    }

    public static a create(IslandImageTextViewHolder_Factory islandImageTextViewHolder_Factory) {
        return f.a((Object)new IslandImageTextViewHolder_Factory_Impl(islandImageTextViewHolder_Factory));
    }

    @Override
    public IslandImageTextViewHolder create(ViewGroup viewGroup, o o2) {
        return this.delegateFactory.get(viewGroup, o2);
    }
}
