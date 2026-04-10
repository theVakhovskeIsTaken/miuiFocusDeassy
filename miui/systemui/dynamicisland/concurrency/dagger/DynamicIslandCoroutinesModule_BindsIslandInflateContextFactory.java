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

public final class DynamicIslandCoroutinesModule_BindsIslandInflateContextFactory
implements e {
    private final a uiContextProvider;

    public DynamicIslandCoroutinesModule_BindsIslandInflateContextFactory(a a2) {
        this.uiContextProvider = a2;
    }

    public static g bindsIslandInflateContext(g g2) {
        return (g)i.d((Object)DynamicIslandCoroutinesModule.INSTANCE.bindsIslandInflateContext(g2));
    }

    public static DynamicIslandCoroutinesModule_BindsIslandInflateContextFactory create(a a2) {
        return new DynamicIslandCoroutinesModule_BindsIslandInflateContextFactory(a2);
    }

    public g get() {
        return DynamicIslandCoroutinesModule_BindsIslandInflateContextFactory.bindsIslandInflateContext((g)this.uiContextProvider.get());
    }
}
