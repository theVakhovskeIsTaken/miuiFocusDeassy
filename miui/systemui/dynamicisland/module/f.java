/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.media.MediaPlayer
 *  android.media.MediaPlayer$OnErrorListener
 */
package miui.systemui.dynamicisland.module;

import android.media.MediaPlayer;
import miui.systemui.dynamicisland.module.IslandIconViewHolder;

public final class f
implements MediaPlayer.OnErrorListener {
    public final IslandIconViewHolder a;

    public /* synthetic */ f(IslandIconViewHolder islandIconViewHolder) {
        this.a = islandIconViewHolder;
    }

    public final boolean onError(MediaPlayer mediaPlayer, int n, int n2) {
        return IslandIconViewHolder.d(this.a, mediaPlayer, n, n2);
    }
}
