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
import miui.systemui.dynamicisland.module.IslandTextOverIconHolder;
import miui.systemui.dynamicisland.module.IslandTextOverIconHolder_Factory;

public final class IslandTextOverIconHolder_Factory_Impl
implements IslandTextOverIconHolder.Factory {
    private final IslandTextOverIconHolder_Factory delegateFactory;

    public IslandTextOverIconHolder_Factory_Impl(IslandTextOverIconHolder_Factory islandTextOverIconHolder_Factory) {
        this.delegateFactory = islandTextOverIconHolder_Factory;
    }

    public static a create(IslandTextOverIconHolder_Factory islandTextOverIconHolder_Factory) {
        return f.a((Object)new IslandTextOverIconHolder_Factory_Impl(islandTextOverIconHolder_Factory));
    }

    @Override
    public IslandTextOverIconHolder create(ViewGroup viewGroup, o o2) {
        return this.delegateFactory.get(viewGroup, o2);
    }
}
