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
import miui.systemui.dynamicisland.module.IslandRightTextViewHolder;

public final class IslandRightTextViewHolder_Factory {
    private final a contextProvider;

    public IslandRightTextViewHolder_Factory(a a2) {
        this.contextProvider = a2;
    }

    public static IslandRightTextViewHolder_Factory create(a a2) {
        return new IslandRightTextViewHolder_Factory(a2);
    }

    public static IslandRightTextViewHolder newInstance(Context context, ViewGroup viewGroup, o o2) {
        return new IslandRightTextViewHolder(context, viewGroup, o2);
    }

    public IslandRightTextViewHolder get(ViewGroup viewGroup, o o2) {
        return IslandRightTextViewHolder_Factory.newInstance((Context)this.contextProvider.get(), viewGroup, o2);
    }
}
