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
import miui.systemui.dynamicisland.module.IslandProgressTextViewHolder;
import miui.systemui.dynamicisland.module.IslandProgressTextViewHolder_Factory;

public final class IslandProgressTextViewHolder_Factory_Impl
implements IslandProgressTextViewHolder.Factory {
    private final IslandProgressTextViewHolder_Factory delegateFactory;

    public IslandProgressTextViewHolder_Factory_Impl(IslandProgressTextViewHolder_Factory islandProgressTextViewHolder_Factory) {
        this.delegateFactory = islandProgressTextViewHolder_Factory;
    }

    public static a create(IslandProgressTextViewHolder_Factory islandProgressTextViewHolder_Factory) {
        return f.a((Object)new IslandProgressTextViewHolder_Factory_Impl(islandProgressTextViewHolder_Factory));
    }

    @Override
    public IslandProgressTextViewHolder create(ViewGroup viewGroup, o o2) {
        return this.delegateFactory.get(viewGroup, o2);
    }
}
