/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.media.MediaPlayer
 *  android.media.MediaPlayer$OnPreparedListener
 */
package miui.systemui.notification.focus.moduleV3;

import android.media.MediaPlayer;
import miui.systemui.notification.focus.moduleV3.ModuleDecoLandNewImageTextViewHolder;

public final class j
implements MediaPlayer.OnPreparedListener {
    public final ModuleDecoLandNewImageTextViewHolder a;

    public /* synthetic */ j(ModuleDecoLandNewImageTextViewHolder moduleDecoLandNewImageTextViewHolder) {
        this.a = moduleDecoLandNewImageTextViewHolder;
    }

    public final void onPrepared(MediaPlayer mediaPlayer) {
        ModuleDecoLandNewImageTextViewHolder.d(this.a, mediaPlayer);
    }
}
