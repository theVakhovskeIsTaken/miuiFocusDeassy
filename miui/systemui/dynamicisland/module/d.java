/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.android.systemui.plugins.miui.dynamicisland.DynamicIslandData
 *  d.H
 *  d.h
 */
package miui.systemui.dynamicisland.module;

import com.android.systemui.plugins.miui.dynamicisland.DynamicIslandData;
import d.H;
import d.h;
import miui.systemui.dynamicisland.module.IslandIconViewHolder;

public final class d
implements H {
    public final IslandIconViewHolder a;
    public final DynamicIslandData b;

    public /* synthetic */ d(IslandIconViewHolder islandIconViewHolder, DynamicIslandData dynamicIslandData) {
        this.a = islandIconViewHolder;
        this.b = dynamicIslandData;
    }

    public final void onResult(Object object) {
        IslandIconViewHolder.c(this.a, this.b, (h)object);
    }
}
