/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.Choreographer$FrameCallback
 */
package miui.systemui.dynamicisland.module;

import android.view.Choreographer;
import miui.systemui.dynamicisland.module.IslandIconFixedWidthTextHolder;

public final class b
implements Choreographer.FrameCallback {
    public final IslandIconFixedWidthTextHolder a;

    public /* synthetic */ b(IslandIconFixedWidthTextHolder islandIconFixedWidthTextHolder) {
        this.a = islandIconFixedWidthTextHolder;
    }

    public final void doFrame(long l) {
        IslandIconFixedWidthTextHolder.a(this.a, l);
    }
}
