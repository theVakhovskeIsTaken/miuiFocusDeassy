/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  E0.e
 *  E0.i
 *  F0.a
 *  androidx.lifecycle.LifecycleCoroutineScope
 *  androidx.lifecycle.LifecycleOwner
 */
package miui.systemui.dynamicisland.dagger;

import E0.e;
import E0.i;
import F0.a;
import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.lifecycle.LifecycleOwner;
import miui.systemui.dynamicisland.dagger.DynamicIslandViewModule;

public final class DynamicIslandViewModule_Companion_ProvidesLifecycleCoroutineScopeFactory
implements e {
    private final a lifecycleOwnerProvider;

    public DynamicIslandViewModule_Companion_ProvidesLifecycleCoroutineScopeFactory(a a2) {
        this.lifecycleOwnerProvider = a2;
    }

    public static DynamicIslandViewModule_Companion_ProvidesLifecycleCoroutineScopeFactory create(a a2) {
        return new DynamicIslandViewModule_Companion_ProvidesLifecycleCoroutineScopeFactory(a2);
    }

    public static LifecycleCoroutineScope providesLifecycleCoroutineScope(LifecycleOwner lifecycleOwner) {
        return (LifecycleCoroutineScope)i.d((Object)DynamicIslandViewModule.Companion.providesLifecycleCoroutineScope(lifecycleOwner));
    }

    public LifecycleCoroutineScope get() {
        return DynamicIslandViewModule_Companion_ProvidesLifecycleCoroutineScopeFactory.providesLifecycleCoroutineScope((LifecycleOwner)this.lifecycleOwnerProvider.get());
    }
}
