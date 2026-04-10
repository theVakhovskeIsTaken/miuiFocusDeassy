/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  E0.f
 *  F0.a
 *  U0.o
 *  android.view.ViewGroup
 *  com.android.systemui.plugins.miui.dynamicisland.DynamicIslandData
 */
package miui.systemui.dynamicisland.template;

import E0.f;
import F0.a;
import U0.o;
import android.view.ViewGroup;
import com.android.systemui.plugins.miui.dynamicisland.DynamicIslandData;
import miui.systemui.dynamicisland.template.IslandTemplateBuilder;
import miui.systemui.dynamicisland.template.IslandTemplateBuilder_Factory;

public final class IslandTemplateBuilder_Factory_Impl
implements IslandTemplateBuilder.Factory {
    private final IslandTemplateBuilder_Factory delegateFactory;

    public IslandTemplateBuilder_Factory_Impl(IslandTemplateBuilder_Factory islandTemplateBuilder_Factory) {
        this.delegateFactory = islandTemplateBuilder_Factory;
    }

    public static a create(IslandTemplateBuilder_Factory islandTemplateBuilder_Factory) {
        return f.a((Object)new IslandTemplateBuilder_Factory_Impl(islandTemplateBuilder_Factory));
    }

    @Override
    public IslandTemplateBuilder create(ViewGroup viewGroup, boolean bl, boolean bl2, o o2, DynamicIslandData dynamicIslandData) {
        return this.delegateFactory.get(viewGroup, bl, bl2, o2, dynamicIslandData);
    }
}
