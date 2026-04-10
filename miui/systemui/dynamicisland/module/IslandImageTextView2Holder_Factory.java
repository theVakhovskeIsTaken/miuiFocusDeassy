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
import miui.systemui.dynamicisland.module.IslandImageTextView2Holder;
import miui.systemui.dynamicisland.module.IslandRightTextViewHolder;

public final class IslandImageTextView2Holder_Factory {
    private final a contextProvider;
    private final a iconViewHolderFactoryProvider;
    private final a rightTextViewHolderFactoryProvider;

    public IslandImageTextView2Holder_Factory(a a2, a a3, a a4) {
        this.contextProvider = a2;
        this.iconViewHolderFactoryProvider = a3;
        this.rightTextViewHolderFactoryProvider = a4;
    }

    public static IslandImageTextView2Holder_Factory create(a a2, a a3, a a4) {
        return new IslandImageTextView2Holder_Factory(a2, a3, a4);
    }

    public static IslandImageTextView2Holder newInstance(Context context, ViewGroup viewGroup, o o2, IslandIconViewHolder.Factory factory, IslandRightTextViewHolder.Factory factory2) {
        return new IslandImageTextView2Holder(context, viewGroup, o2, factory, factory2);
    }

    public IslandImageTextView2Holder get(ViewGroup viewGroup, o o2) {
        return IslandImageTextView2Holder_Factory.newInstance((Context)this.contextProvider.get(), viewGroup, o2, (IslandIconViewHolder.Factory)this.iconViewHolderFactoryProvider.get(), (IslandRightTextViewHolder.Factory)this.rightTextViewHolderFactoryProvider.get());
    }
}
