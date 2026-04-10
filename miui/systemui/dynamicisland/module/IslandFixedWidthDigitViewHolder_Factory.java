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
import miui.systemui.dynamicisland.module.IslandFixedWidthDigitViewHolder;

public final class IslandFixedWidthDigitViewHolder_Factory {
    private final a contextProvider;

    public IslandFixedWidthDigitViewHolder_Factory(a a2) {
        this.contextProvider = a2;
    }

    public static IslandFixedWidthDigitViewHolder_Factory create(a a2) {
        return new IslandFixedWidthDigitViewHolder_Factory(a2);
    }

    public static IslandFixedWidthDigitViewHolder newInstance(Context context, ViewGroup viewGroup, o o2) {
        return new IslandFixedWidthDigitViewHolder(context, viewGroup, o2);
    }

    public IslandFixedWidthDigitViewHolder get(ViewGroup viewGroup, o o2) {
        return IslandFixedWidthDigitViewHolder_Factory.newInstance((Context)this.contextProvider.get(), viewGroup, o2);
    }
}
