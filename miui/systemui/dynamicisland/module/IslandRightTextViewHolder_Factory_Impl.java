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
import miui.systemui.dynamicisland.module.IslandRightTextViewHolder;
import miui.systemui.dynamicisland.module.IslandRightTextViewHolder_Factory;

public final class IslandRightTextViewHolder_Factory_Impl
implements IslandRightTextViewHolder.Factory {
    private final IslandRightTextViewHolder_Factory delegateFactory;

    public IslandRightTextViewHolder_Factory_Impl(IslandRightTextViewHolder_Factory islandRightTextViewHolder_Factory) {
        this.delegateFactory = islandRightTextViewHolder_Factory;
    }

    public static a create(IslandRightTextViewHolder_Factory islandRightTextViewHolder_Factory) {
        return f.a((Object)new IslandRightTextViewHolder_Factory_Impl(islandRightTextViewHolder_Factory));
    }

    @Override
    public IslandRightTextViewHolder create(ViewGroup viewGroup, o o2) {
        return this.delegateFactory.get(viewGroup, o2);
    }
}
