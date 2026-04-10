/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.media.MediaPlayer
 *  android.media.MediaPlayer$OnPreparedListener
 */
package miui.systemui.dynamicisland.module;

import android.media.MediaPlayer;
import miui.systemui.dynamicisland.module.IslandIconViewHolder;

public final class e
implements MediaPlayer.OnPreparedListener {
    public final IslandIconViewHolder a;

    public /* synthetic */ e(IslandIconViewHolder islandIconViewHolder) {
        this.a = islandIconViewHolder;
    }

    public final void onPrepared(MediaPlayer mediaPlayer) {
        IslandIconViewHolder.a(this.a, mediaPlayer);
    }
}
