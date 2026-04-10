/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  androidx.lifecycle.LifecycleCoroutineScope
 *  androidx.lifecycle.LifecycleOwner
 *  f1.E
 */
package miui.systemui.dynamicisland.dagger;

import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.lifecycle.LifecycleOwner;
import f1.E;
import miui.systemui.dynamicisland.dagger.DynamicIslandScope;
import miui.systemui.dynamicisland.dagger.qualifiers.DynamicIsland;
import miui.systemui.dynamicisland.window.DynamicIslandWindowView;

public interface DynamicIslandViewModule {
    public static final Companion Companion = miui.systemui.dynamicisland.dagger.DynamicIslandViewModule$Companion.$$INSTANCE;

    @DynamicIslandScope
    @DynamicIsland
    public E bindsCoroutineScope(@DynamicIsland LifecycleCoroutineScope var1);

    @DynamicIslandScope
    @DynamicIsland
    public LifecycleOwner bindsLifecycleOwner(DynamicIslandWindowView var1);
}
