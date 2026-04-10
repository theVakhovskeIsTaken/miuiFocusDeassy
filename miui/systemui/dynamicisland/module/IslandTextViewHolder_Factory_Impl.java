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
import miui.systemui.dynamicisland.module.IslandTextViewHolder;
import miui.systemui.dynamicisland.module.IslandTextViewHolder_Factory;

public final class IslandTextViewHolder_Factory_Impl
implements IslandTextViewHolder.Factory {
    private final IslandTextViewHolder_Factory delegateFactory;

    public IslandTextViewHolder_Factory_Impl(IslandTextViewHolder_Factory islandTextViewHolder_Factory) {
        this.delegateFactory = islandTextViewHolder_Factory;
    }

    public static a create(IslandTextViewHolder_Factory islandTextViewHolder_Factory) {
        return f.a((Object)new IslandTextViewHolder_Factory_Impl(islandTextViewHolder_Factory));
    }

    @Override
    public IslandTextViewHolder create(ViewGroup viewGroup, o o2) {
        return this.delegateFactory.get(viewGroup, o2);
    }
}
