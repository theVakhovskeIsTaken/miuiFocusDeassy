/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  E0.f
 *  F0.a
 *  U0.o
 *  android.view.ViewGroup
 */
package miui.systemui.dynamicisland.module;

import E0.f;
import F0.a;
import U0.o;
import android.view.ViewGroup;
import miui.systemui.dynamicisland.module.IslandIconFixedWidthTextHolder;
import miui.systemui.dynamicisland.module.IslandIconFixedWidthTextHolder_Factory;

public final class IslandIconFixedWidthTextHolder_Factory_Impl
implements IslandIconFixedWidthTextHolder.Factory {
    private final IslandIconFixedWidthTextHolder_Factory delegateFactory;

    public IslandIconFixedWidthTextHolder_Factory_Impl(IslandIconFixedWidthTextHolder_Factory islandIconFixedWidthTextHolder_Factory) {
        this.delegateFactory = islandIconFixedWidthTextHolder_Factory;
    }

    public static a create(IslandIconFixedWidthTextHolder_Factory islandIconFixedWidthTextHolder_Factory) {
        return f.a((Object)new IslandIconFixedWidthTextHolder_Factory_Impl(islandIconFixedWidthTextHolder_Factory));
    }

    @Override
    public IslandIconFixedWidthTextHolder create(ViewGroup viewGroup, o o2) {
        return this.delegateFactory.get(viewGroup, o2);
    }
}
