/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.media.MediaPlayer
 *  android.media.MediaPlayer$OnPreparedListener
 */
package miui.systemui.notification.focus.moduleV3;

import android.media.MediaPlayer;
import miui.systemui.notification.focus.moduleV3.ModuleDecoPortNewImageTextViewHolder;

public final class p
implements MediaPlayer.OnPreparedListener {
    public final ModuleDecoPortNewImageTextViewHolder a;

    public /* synthetic */ p(ModuleDecoPortNewImageTextViewHolder moduleDecoPortNewImageTextViewHolder) {
        this.a = moduleDecoPortNewImageTextViewHolder;
    }

    public final void onPrepared(MediaPlayer mediaPlayer) {
        ModuleDecoPortNewImageTextViewHolder.d(this.a, mediaPlayer);
    }
}
