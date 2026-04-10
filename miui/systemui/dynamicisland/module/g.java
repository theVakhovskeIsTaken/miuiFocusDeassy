/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.Choreographer$FrameCallback
 */
package miui.systemui.dynamicisland.module;

import android.view.Choreographer;
import miui.systemui.dynamicisland.module.IslandImageTextView3Holder;

public final class g
implements Choreographer.FrameCallback {
    public final IslandImageTextView3Holder a;

    public /* synthetic */ g(IslandImageTextView3Holder islandImageTextView3Holder) {
        this.a = islandImageTextView3Holder;
    }

    public final void doFrame(long l) {
        IslandImageTextView3Holder.a(this.a, l);
    }
}
