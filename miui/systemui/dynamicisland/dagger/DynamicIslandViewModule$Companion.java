/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.lifecycle.Lifecycle
 *  androidx.lifecycle.LifecycleCoroutineScope
 *  androidx.lifecycle.LifecycleOwner
 *  androidx.lifecycle.LifecycleOwnerKt
 *  kotlin.jvm.internal.o
 */
package miui.systemui.dynamicisland.dagger;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import kotlin.jvm.internal.o;
import miui.systemui.dynamicisland.dagger.DynamicIslandScope;
import miui.systemui.dynamicisland.dagger.qualifiers.DynamicIsland;

public static final class DynamicIslandViewModule.Companion {
    static final DynamicIslandViewModule.Companion $$INSTANCE = new DynamicIslandViewModule.Companion();

    private DynamicIslandViewModule.Companion() {
    }

    @DynamicIslandScope
    @DynamicIsland
    public final Lifecycle providesLifecycle(@DynamicIsland LifecycleOwner lifecycleOwner) {
        o.g((Object)lifecycleOwner, (String)"lifecycleOwner");
        return lifecycleOwner.getLifecycle();
    }

    @DynamicIslandScope
    @DynamicIsland
    public final LifecycleCoroutineScope providesLifecycleCoroutineScope(@DynamicIsland LifecycleOwner lifecycleOwner) {
        o.g((Object)lifecycleOwner, (String)"lifecycleOwner");
        return LifecycleOwnerKt.getLifecycleScope((LifecycleOwner)lifecycleOwner);
    }
}
