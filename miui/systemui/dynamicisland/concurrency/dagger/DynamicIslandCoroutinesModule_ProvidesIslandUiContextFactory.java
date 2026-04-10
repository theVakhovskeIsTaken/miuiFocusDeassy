/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  E0.e
 *  E0.i
 *  F0.a
 *  K0.g
 */
package miui.systemui.dynamicisland.concurrency.dagger;

import E0.e;
import E0.i;
import F0.a;
import K0.g;
import miui.systemui.dynamicisland.concurrency.dagger.DynamicIslandCoroutinesModule;

public final class DynamicIslandCoroutinesModule_ProvidesIslandUiContextFactory
implements e {
    private final a islandContextProvider;

    public DynamicIslandCoroutinesModule_ProvidesIslandUiContextFactory(a a2) {
        this.islandContextProvider = a2;
    }

    public static DynamicIslandCoroutinesModule_ProvidesIslandUiContextFactory create(a a2) {
        return new DynamicIslandCoroutinesModule_ProvidesIslandUiContextFactory(a2);
    }

    public static g providesIslandUiContext(g g2) {
        return (g)i.d((Object)DynamicIslandCoroutinesModule.INSTANCE.providesIslandUiContext(g2));
    }

    public g get() {
        return DynamicIslandCoroutinesModule_ProvidesIslandUiContextFactory.providesIslandUiContext((g)this.islandContextProvider.get());
    }
}
