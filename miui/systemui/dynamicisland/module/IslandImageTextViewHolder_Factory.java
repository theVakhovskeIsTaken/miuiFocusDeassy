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
import miui.systemui.dynamicisland.module.IslandIconViewHolder;
import miui.systemui.dynamicisland.module.IslandImageTextViewHolder;
import miui.systemui.dynamicisland.module.IslandTextViewHolder;

public final class IslandImageTextViewHolder_Factory {
    private final a contextProvider;
    private final a iconViewHolderFactoryProvider;
    private final a textViewHolderFactoryProvider;

    public IslandImageTextViewHolder_Factory(a a2, a a3, a a4) {
        this.contextProvider = a2;
        this.iconViewHolderFactoryProvider = a3;
        this.textViewHolderFactoryProvider = a4;
    }

    public static IslandImageTextViewHolder_Factory create(a a2, a a3, a a4) {
        return new IslandImageTextViewHolder_Factory(a2, a3, a4);
    }

    public static IslandImageTextViewHolder newInstance(Context context, ViewGroup viewGroup, o o2, IslandIconViewHolder.Factory factory, IslandTextViewHolder.Factory factory2) {
        return new IslandImageTextViewHolder(context, viewGroup, o2, factory, factory2);
    }

    public IslandImageTextViewHolder get(ViewGroup viewGroup, o o2) {
        return IslandImageTextViewHolder_Factory.newInstance((Context)this.contextProvider.get(), viewGroup, o2, (IslandIconViewHolder.Factory)this.iconViewHolderFactoryProvider.get(), (IslandTextViewHolder.Factory)this.textViewHolderFactoryProvider.get());
    }
}
