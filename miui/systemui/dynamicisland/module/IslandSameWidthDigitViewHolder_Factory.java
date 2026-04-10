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
import miui.systemui.dynamicisland.module.IslandSameWidthDigitViewHolder;

public final class IslandSameWidthDigitViewHolder_Factory {
    private final a contextProvider;

    public IslandSameWidthDigitViewHolder_Factory(a a2) {
        this.contextProvider = a2;
    }

    public static IslandSameWidthDigitViewHolder_Factory create(a a2) {
        return new IslandSameWidthDigitViewHolder_Factory(a2);
    }

    public static IslandSameWidthDigitViewHolder newInstance(Context context, ViewGroup viewGroup, o o2) {
        return new IslandSameWidthDigitViewHolder(context, viewGroup, o2);
    }

    public IslandSameWidthDigitViewHolder get(ViewGroup viewGroup, o o2) {
        return IslandSameWidthDigitViewHolder_Factory.newInstance((Context)this.contextProvider.get(), viewGroup, o2);
    }
}
