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
import miui.systemui.dynamicisland.module.IslandImageTextView3Holder;
import miui.systemui.dynamicisland.module.IslandImageTextView3Holder_Factory;

public final class IslandImageTextView3Holder_Factory_Impl
implements IslandImageTextView3Holder.Factory {
    private final IslandImageTextView3Holder_Factory delegateFactory;

    public IslandImageTextView3Holder_Factory_Impl(IslandImageTextView3Holder_Factory islandImageTextView3Holder_Factory) {
        this.delegateFactory = islandImageTextView3Holder_Factory;
    }

    public static a create(IslandImageTextView3Holder_Factory islandImageTextView3Holder_Factory) {
        return f.a((Object)new IslandImageTextView3Holder_Factory_Impl(islandImageTextView3Holder_Factory));
    }

    @Override
    public IslandImageTextView3Holder create(ViewGroup viewGroup, o o2) {
        return this.delegateFactory.get(viewGroup, o2);
    }
}
