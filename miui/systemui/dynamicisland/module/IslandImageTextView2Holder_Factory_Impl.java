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
import miui.systemui.dynamicisland.module.IslandImageTextView2Holder;
import miui.systemui.dynamicisland.module.IslandImageTextView2Holder_Factory;

public final class IslandImageTextView2Holder_Factory_Impl
implements IslandImageTextView2Holder.Factory {
    private final IslandImageTextView2Holder_Factory delegateFactory;

    public IslandImageTextView2Holder_Factory_Impl(IslandImageTextView2Holder_Factory islandImageTextView2Holder_Factory) {
        this.delegateFactory = islandImageTextView2Holder_Factory;
    }

    public static a create(IslandImageTextView2Holder_Factory islandImageTextView2Holder_Factory) {
        return f.a((Object)new IslandImageTextView2Holder_Factory_Impl(islandImageTextView2Holder_Factory));
    }

    @Override
    public IslandImageTextView2Holder create(ViewGroup viewGroup, o o2) {
        return this.delegateFactory.get(viewGroup, o2);
    }
}
