/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  E0.e
 *  E0.i
 *  F0.a
 *  androidx.lifecycle.Lifecycle
 *  androidx.lifecycle.LifecycleOwner
 */
package miui.systemui.dynamicisland.dagger;

import E0.e;
import E0.i;
import F0.a;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import miui.systemui.dynamicisland.dagger.DynamicIslandViewModule;

public final class DynamicIslandViewModule_Companion_ProvidesLifecycleFactory
implements e {
    private final a lifecycleOwnerProvider;

    public DynamicIslandViewModule_Companion_ProvidesLifecycleFactory(a a2) {
        this.lifecycleOwnerProvider = a2;
    }

    public static DynamicIslandViewModule_Companion_ProvidesLifecycleFactory create(a a2) {
        return new DynamicIslandViewModule_Companion_ProvidesLifecycleFactory(a2);
    }

    public static Lifecycle providesLifecycle(LifecycleOwner lifecycleOwner) {
        return (Lifecycle)i.d((Object)DynamicIslandViewModule.Companion.providesLifecycle(lifecycleOwner));
    }

    public Lifecycle get() {
        return DynamicIslandViewModule_Companion_ProvidesLifecycleFactory.providesLifecycle((LifecycleOwner)this.lifecycleOwnerProvider.get());
    }
}
