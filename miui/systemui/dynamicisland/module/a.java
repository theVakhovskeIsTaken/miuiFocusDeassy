/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.Choreographer$FrameCallback
 */
package miui.systemui.dynamicisland.module;

import android.view.Choreographer;
import miui.systemui.dynamicisland.module.IslandFixedWidthDigitViewHolder;

public final class a
implements Choreographer.FrameCallback {
    public final IslandFixedWidthDigitViewHolder a;

    public /* synthetic */ a(IslandFixedWidthDigitViewHolder islandFixedWidthDigitViewHolder) {
        this.a = islandFixedWidthDigitViewHolder;
    }

    public final void doFrame(long l) {
        IslandFixedWidthDigitViewHolder.a(this.a, l);
    }
}
