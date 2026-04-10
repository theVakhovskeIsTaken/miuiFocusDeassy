/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  f1.E
 *  kotlin.jvm.internal.o
 */
package miui.systemui.dynamicisland;

import f1.E;
import kotlin.jvm.internal.o;
import miui.systemui.dynamicisland.DynamicIslandBackgroundView;
import miui.systemui.dynamicisland.dagger.qualifiers.DynamicIsland;

public final class DynamicIslandBackgroundViewController {
    private final E scope;

    public DynamicIslandBackgroundViewController(DynamicIslandBackgroundView dynamicIslandBackgroundView, @DynamicIsland E e) {
        o.g((Object)((Object)dynamicIslandBackgroundView), (String)"view");
        o.g((Object)e, (String)"scope");
        this.scope = e;
    }

    public final E getScope() {
        return this.scope;
    }
}
