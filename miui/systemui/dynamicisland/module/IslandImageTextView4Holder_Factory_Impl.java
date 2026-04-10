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
import miui.systemui.dynamicisland.module.IslandImageTextView4Holder;
import miui.systemui.dynamicisland.module.IslandImageTextView4Holder_Factory;

public final class IslandImageTextView4Holder_Factory_Impl
implements IslandImageTextView4Holder.Factory {
    private final IslandImageTextView4Holder_Factory delegateFactory;

    public IslandImageTextView4Holder_Factory_Impl(IslandImageTextView4Holder_Factory islandImageTextView4Holder_Factory) {
        this.delegateFactory = islandImageTextView4Holder_Factory;
    }

    public static a create(IslandImageTextView4Holder_Factory islandImageTextView4Holder_Factory) {
        return f.a((Object)new IslandImageTextView4Holder_Factory_Impl(islandImageTextView4Holder_Factory));
    }

    @Override
    public IslandImageTextView4Holder create(ViewGroup viewGroup, o o2) {
        return this.delegateFactory.get(viewGroup, o2);
    }
}
