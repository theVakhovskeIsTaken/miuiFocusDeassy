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
import miui.systemui.dynamicisland.module.IslandIconFixedWidthTextHolder;
import miui.systemui.dynamicisland.module.IslandIconViewHolder;

public final class IslandIconFixedWidthTextHolder_Factory {
    private final a contextProvider;
    private final a iconViewHolderFactoryProvider;

    public IslandIconFixedWidthTextHolder_Factory(a a2, a a3) {
        this.contextProvider = a2;
        this.iconViewHolderFactoryProvider = a3;
    }

    public static IslandIconFixedWidthTextHolder_Factory create(a a2, a a3) {
        return new IslandIconFixedWidthTextHolder_Factory(a2, a3);
    }

    public static IslandIconFixedWidthTextHolder newInstance(Context context, ViewGroup viewGroup, o o2, IslandIconViewHolder.Factory factory) {
        return new IslandIconFixedWidthTextHolder(context, viewGroup, o2, factory);
    }

    public IslandIconFixedWidthTextHolder get(ViewGroup viewGroup, o o2) {
        return IslandIconFixedWidthTextHolder_Factory.newInstance((Context)this.contextProvider.get(), viewGroup, o2, (IslandIconViewHolder.Factory)this.iconViewHolderFactoryProvider.get());
    }
}
