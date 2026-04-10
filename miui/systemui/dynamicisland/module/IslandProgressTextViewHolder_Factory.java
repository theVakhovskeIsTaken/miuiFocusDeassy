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
import miui.systemui.dynamicisland.module.IslandProgressTextViewHolder;
import miui.systemui.dynamicisland.module.IslandProgressViewHolder;
import miui.systemui.dynamicisland.module.IslandRightTextViewHolder;

public final class IslandProgressTextViewHolder_Factory {
    private final a contextProvider;
    private final a progressViewHolderFactoryProvider;
    private final a rightTextViewHolderProvider;

    public IslandProgressTextViewHolder_Factory(a a2, a a3, a a4) {
        this.contextProvider = a2;
        this.progressViewHolderFactoryProvider = a3;
        this.rightTextViewHolderProvider = a4;
    }

    public static IslandProgressTextViewHolder_Factory create(a a2, a a3, a a4) {
        return new IslandProgressTextViewHolder_Factory(a2, a3, a4);
    }

    public static IslandProgressTextViewHolder newInstance(Context context, ViewGroup viewGroup, o o2, IslandProgressViewHolder.Factory factory, IslandRightTextViewHolder.Factory factory2) {
        return new IslandProgressTextViewHolder(context, viewGroup, o2, factory, factory2);
    }

    public IslandProgressTextViewHolder get(ViewGroup viewGroup, o o2) {
        return IslandProgressTextViewHolder_Factory.newInstance((Context)this.contextProvider.get(), viewGroup, o2, (IslandProgressViewHolder.Factory)this.progressViewHolderFactoryProvider.get(), (IslandRightTextViewHolder.Factory)this.rightTextViewHolderProvider.get());
    }
}
