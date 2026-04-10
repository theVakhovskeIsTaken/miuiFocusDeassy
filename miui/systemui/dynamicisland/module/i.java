/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.Choreographer$FrameCallback
 */
package miui.systemui.dynamicisland.module;

import android.view.Choreographer;
import miui.systemui.dynamicisland.module.IslandSameWidthDigitViewHolder;

public final class i
implements Choreographer.FrameCallback {
    public final IslandSameWidthDigitViewHolder a;

    public /* synthetic */ i(IslandSameWidthDigitViewHolder islandSameWidthDigitViewHolder) {
        this.a = islandSameWidthDigitViewHolder;
    }

    public final void doFrame(long l) {
        IslandSameWidthDigitViewHolder.a(this.a, l);
    }
}
