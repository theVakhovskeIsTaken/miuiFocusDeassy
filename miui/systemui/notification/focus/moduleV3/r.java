/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.media.MediaPlayer
 *  android.media.MediaPlayer$OnPreparedListener
 */
package miui.systemui.notification.focus.moduleV3;

import android.media.MediaPlayer;
import miui.systemui.notification.focus.moduleV3.ModuleNewImageTextViewHolder;

public final class r
implements MediaPlayer.OnPreparedListener {
    public final ModuleNewImageTextViewHolder a;

    public /* synthetic */ r(ModuleNewImageTextViewHolder moduleNewImageTextViewHolder) {
        this.a = moduleNewImageTextViewHolder;
    }

    public final void onPrepared(MediaPlayer mediaPlayer) {
        ModuleNewImageTextViewHolder.d(this.a, mediaPlayer);
    }
}
