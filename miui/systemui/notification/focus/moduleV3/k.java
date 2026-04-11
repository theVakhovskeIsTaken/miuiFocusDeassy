/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.media.MediaPlayer
 *  android.media.MediaPlayer$OnErrorListener
 */
package miui.systemui.notification.focus.moduleV3;

import android.media.MediaPlayer;
import miui.systemui.notification.focus.moduleV3.ModuleDecoLandNewImageTextViewHolder;

public final class k
implements MediaPlayer.OnErrorListener {
    public final ModuleDecoLandNewImageTextViewHolder a;

    public /* synthetic */ k(ModuleDecoLandNewImageTextViewHolder moduleDecoLandNewImageTextViewHolder) {
        this.a = moduleDecoLandNewImageTextViewHolder;
    }

    public final boolean onError(MediaPlayer mediaPlayer, int n, int n2) {
        return ModuleDecoLandNewImageTextViewHolder.c(this.a, mediaPlayer, n, n2);
    }
}
