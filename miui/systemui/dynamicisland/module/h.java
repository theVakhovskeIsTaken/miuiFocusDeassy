/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.Choreographer$FrameCallback
 */
package miui.systemui.dynamicisland.module;

import android.view.Choreographer;
import miui.systemui.dynamicisland.module.IslandRightTextViewHolder;

public final class h
implements Choreographer.FrameCallback {
    public final IslandRightTextViewHolder a;

    public /* synthetic */ h(IslandRightTextViewHolder islandRightTextViewHolder) {
        this.a = islandRightTextViewHolder;
    }

    public final void doFrame(long l) {
        IslandRightTextViewHolder.a(this.a, l);
    }
}
