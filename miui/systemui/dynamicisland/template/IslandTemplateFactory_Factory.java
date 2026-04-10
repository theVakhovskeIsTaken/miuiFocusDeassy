/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  E0.e
 *  F0.a
 *  f1.E
 */
package miui.systemui.dynamicisland.template;

import E0.e;
import F0.a;
import f1.E;
import miui.systemui.dynamicisland.template.IslandTemplateBuilder;
import miui.systemui.dynamicisland.template.IslandTemplateFactory;

public final class IslandTemplateFactory_Factory
implements e {
    private final a islandTemplateBuilderFactoryProvider;
    private final a scopeProvider;

    public IslandTemplateFactory_Factory(a a2, a a3) {
        this.scopeProvider = a2;
        this.islandTemplateBuilderFactoryProvider = a3;
    }

    public static IslandTemplateFactory_Factory create(a a2, a a3) {
        return new IslandTemplateFactory_Factory(a2, a3);
    }

    public static IslandTemplateFactory newInstance(E e2, IslandTemplateBuilder.Factory factory) {
        return new IslandTemplateFactory(e2, factory);
    }

    public IslandTemplateFactory get() {
        return IslandTemplateFactory_Factory.newInstance((E)this.scopeProvider.get(), (IslandTemplateBuilder.Factory)this.islandTemplateBuilderFactoryProvider.get());
    }
}
