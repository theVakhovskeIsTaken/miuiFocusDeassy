/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  F0.a
 *  K0.g
 *  U0.o
 *  android.content.Context
 *  android.view.ViewGroup
 *  com.android.systemui.plugins.miui.dynamicisland.DynamicIslandData
 */
package miui.systemui.dynamicisland.template;

import F0.a;
import K0.g;
import U0.o;
import android.content.Context;
import android.view.ViewGroup;
import com.android.systemui.plugins.miui.dynamicisland.DynamicIslandData;
import miui.systemui.dynamicisland.module.IslandModuleViewHolderAdapter;
import miui.systemui.dynamicisland.template.IslandTemplateBuilder;

public final class IslandTemplateBuilder_Factory {
    private final a contextProvider;
    private final a inflateContextProvider;
    private final a islandAdapterProvider;
    private final a uiImmediateProvider;

    public IslandTemplateBuilder_Factory(a a2, a a3, a a4, a a5) {
        this.contextProvider = a2;
        this.uiImmediateProvider = a3;
        this.inflateContextProvider = a4;
        this.islandAdapterProvider = a5;
    }

    public static IslandTemplateBuilder_Factory create(a a2, a a3, a a4, a a5) {
        return new IslandTemplateBuilder_Factory(a2, a3, a4, a5);
    }

    public static IslandTemplateBuilder newInstance(Context context, g g2, g g3, ViewGroup viewGroup, boolean bl, boolean bl2, o o2, IslandModuleViewHolderAdapter islandModuleViewHolderAdapter, DynamicIslandData dynamicIslandData) {
        return new IslandTemplateBuilder(context, g2, g3, viewGroup, bl, bl2, o2, islandModuleViewHolderAdapter, dynamicIslandData);
    }

    public IslandTemplateBuilder get(ViewGroup viewGroup, boolean bl, boolean bl2, o o2, DynamicIslandData dynamicIslandData) {
        return IslandTemplateBuilder_Factory.newInstance((Context)this.contextProvider.get(), (g)this.uiImmediateProvider.get(), (g)this.inflateContextProvider.get(), viewGroup, bl, bl2, o2, (IslandModuleViewHolderAdapter)this.islandAdapterProvider.get(), dynamicIslandData);
    }
}
