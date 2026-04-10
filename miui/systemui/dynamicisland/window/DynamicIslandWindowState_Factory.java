/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  E0.e
 *  F0.a
 *  android.content.Context
 *  f1.E
 */
package miui.systemui.dynamicisland.window;

import E0.e;
import F0.a;
import android.content.Context;
import f1.E;
import miui.systemui.dynamicisland.data.repository.DynamicIslandExternalStateRepository;
import miui.systemui.dynamicisland.window.DynamicIslandWindowState;

public final class DynamicIslandWindowState_Factory
implements e {
    private final a externalRepositoryProvider;
    private final a scopeProvider;
    private final a sysUIContextProvider;

    public DynamicIslandWindowState_Factory(a a2, a a3, a a4) {
        this.scopeProvider = a2;
        this.externalRepositoryProvider = a3;
        this.sysUIContextProvider = a4;
    }

    public static DynamicIslandWindowState_Factory create(a a2, a a3, a a4) {
        return new DynamicIslandWindowState_Factory(a2, a3, a4);
    }

    public static DynamicIslandWindowState newInstance(E e2, DynamicIslandExternalStateRepository dynamicIslandExternalStateRepository, Context context) {
        return new DynamicIslandWindowState(e2, dynamicIslandExternalStateRepository, context);
    }

    public DynamicIslandWindowState get() {
        return DynamicIslandWindowState_Factory.newInstance((E)this.scopeProvider.get(), (DynamicIslandExternalStateRepository)this.externalRepositoryProvider.get(), (Context)this.sysUIContextProvider.get());
    }
}
