/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.media.MediaPlayer
 *  android.media.MediaPlayer$OnErrorListener
 */
package miui.systemui.notification.focus.moduleV3;

import android.media.MediaPlayer;
import miui.systemui.notification.focus.moduleV3.ModuleDecoPortNewImageTextViewHolder;

public final class q
implements MediaPlayer.OnErrorListener {
    public final ModuleDecoPortNewImageTextViewHolder a;

    public /* synthetic */ q(ModuleDecoPortNewImageTextViewHolder moduleDecoPortNewImageTextViewHolder) {
        this.a = moduleDecoPortNewImageTextViewHolder;
    }

    public final boolean onError(MediaPlayer mediaPlayer, int n, int n2) {
        return ModuleDecoPortNewImageTextViewHolder.c(this.a, mediaPlayer, n, n2);
    }
}
