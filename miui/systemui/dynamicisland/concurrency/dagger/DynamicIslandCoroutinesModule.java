/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  K0.g
 *  f1.p0
 *  kotlin.jvm.internal.o
 *  miui.systemui.coroutines.Dispatchers
 *  miui.systemui.dagger.qualifiers.Main
 */
package miui.systemui.dynamicisland.concurrency.dagger;

import K0.g;
import f1.p0;
import kotlin.jvm.internal.o;
import miui.systemui.coroutines.Dispatchers;
import miui.systemui.dagger.qualifiers.Main;
import miui.systemui.dynamicisland.concurrency.dagger.qualifiers.IslandInflateThread;
import miui.systemui.dynamicisland.concurrency.dagger.qualifiers.IslandUiImmediateThread;
import miui.systemui.dynamicisland.concurrency.dagger.qualifiers.IslandUiThread;
import miui.systemui.dynamicisland.dagger.DynamicIslandScope;

public final class DynamicIslandCoroutinesModule {
    public static final DynamicIslandCoroutinesModule INSTANCE = new DynamicIslandCoroutinesModule();
    private static final boolean USE_INFLATE_THREAD = true;

    private DynamicIslandCoroutinesModule() {
    }

    @IslandInflateThread
    @DynamicIslandScope
    public final g bindsIslandInflateContext(@IslandUiThread g g2) {
        o.g((Object)g2, (String)"uiContext");
        return g2.plus((g)Dispatchers.INSTANCE.getInflate());
    }

    @IslandUiImmediateThread
    @DynamicIslandScope
    public final g bindsIslandUiImmediateContext(@IslandUiThread g g2) {
        o.g((Object)g2, (String)"uiContext");
        return g2.plus((g)Dispatchers.INSTANCE.getMain().B());
    }

    @IslandUiThread
    @DynamicIslandScope
    public final g providesIslandUiContext(@Main g g2) {
        o.g((Object)g2, (String)"islandContext");
        return g2.plus((g)p0.b(null, (int)1, null));
    }
}
