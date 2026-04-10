/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  F0.a
 *  U0.o
 *  android.content.Context
 *  android.view.ViewGroup
 */
package miui.systemui.dynamicisland.module;

import F0.a;
import U0.o;
import android.content.Context;
import android.view.ViewGroup;
import miui.systemui.dynamicisland.module.IslandCombineImageViewHolder;
import miui.systemui.dynamicisland.module.IslandIconViewHolder;
import miui.systemui.dynamicisland.module.IslandProgressViewHolder;

public final class IslandCombineImageViewHolder_Factory {
    private final a contextProvider;
    private final a iconViewHolderFactoryProvider;
    private final a progressViewHolderFactoryProvider;

    public IslandCombineImageViewHolder_Factory(a a2, a a3, a a4) {
        this.contextProvider = a2;
        this.progressViewHolderFactoryProvider = a3;
        this.iconViewHolderFactoryProvider = a4;
    }

    public static IslandCombineImageViewHolder_Factory create(a a2, a a3, a a4) {
        return new IslandCombineImageViewHolder_Factory(a2, a3, a4);
    }

    public static IslandCombineImageViewHolder newInstance(Context context, ViewGroup viewGroup, o o2, IslandProgressViewHolder.Factory factory, IslandIconViewHolder.Factory factory2) {
        return new IslandCombineImageViewHolder(context, viewGroup, o2, factory, factory2);
    }

    public IslandCombineImageViewHolder get(ViewGroup viewGroup, o o2) {
        return IslandCombineImageViewHolder_Factory.newInstance((Context)this.contextProvider.get(), viewGroup, o2, (IslandProgressViewHolder.Factory)this.progressViewHolderFactoryProvider.get(), (IslandIconViewHolder.Factory)this.iconViewHolderFactoryProvider.get());
    }
}
