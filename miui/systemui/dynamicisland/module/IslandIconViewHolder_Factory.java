/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  F0.a
 *  U0.o
 *  android.content.Context
 *  android.view.ViewGroup
 *  f1.E
 */
package miui.systemui.dynamicisland.module;

import F0.a;
import U0.o;
import android.content.Context;
import android.view.ViewGroup;
import f1.E;
import miui.systemui.dynamicisland.module.IslandIconViewHolder;

public final class IslandIconViewHolder_Factory {
    private final a contextProvider;
    private final a scopeProvider;

    public IslandIconViewHolder_Factory(a a2, a a3) {
        this.contextProvider = a2;
        this.scopeProvider = a3;
    }

    public static IslandIconViewHolder_Factory create(a a2, a a3) {
        return new IslandIconViewHolder_Factory(a2, a3);
    }

    public static IslandIconViewHolder newInstance(Context context, E e, ViewGroup viewGroup, o o2) {
        return new IslandIconViewHolder(context, e, viewGroup, o2);
    }

    public IslandIconViewHolder get(ViewGroup viewGroup, o o2) {
        return IslandIconViewHolder_Factory.newInstance((Context)this.contextProvider.get(), (E)this.scopeProvider.get(), viewGroup, o2);
    }
}
