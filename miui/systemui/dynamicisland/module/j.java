/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.Choreographer$FrameCallback
 */
package miui.systemui.dynamicisland.module;

import android.view.Choreographer;
import miui.systemui.dynamicisland.module.IslandTextViewHolder;

public final class j
implements Choreographer.FrameCallback {
    public final IslandTextViewHolder a;

    public /* synthetic */ j(IslandTextViewHolder islandTextViewHolder) {
        this.a = islandTextViewHolder;
    }

    public final void doFrame(long l) {
        IslandTextViewHolder.a(this.a, l);
    }
}
