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
import miui.systemui.dynamicisland.module.IslandImageTextView4Holder;

public final class IslandImageTextView4Holder_Factory {
    private final a contextProvider;

    public IslandImageTextView4Holder_Factory(a a2) {
        this.contextProvider = a2;
    }

    public static IslandImageTextView4Holder_Factory create(a a2) {
        return new IslandImageTextView4Holder_Factory(a2);
    }

    public static IslandImageTextView4Holder newInstance(Context context, ViewGroup viewGroup, o o2) {
        return new IslandImageTextView4Holder(context, viewGroup, o2);
    }

    public IslandImageTextView4Holder get(ViewGroup viewGroup, o o2) {
        return IslandImageTextView4Holder_Factory.newInstance((Context)this.contextProvider.get(), viewGroup, o2);
    }
}
