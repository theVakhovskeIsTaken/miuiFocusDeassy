/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.media.MediaPlayer
 *  android.media.MediaPlayer$OnErrorListener
 */
package miui.systemui.notification.focus.moduleV3;

import android.media.MediaPlayer;
import miui.systemui.notification.focus.moduleV3.ModuleNewImageTextViewHolder;

public final class s
implements MediaPlayer.OnErrorListener {
    public final ModuleNewImageTextViewHolder a;

    public /* synthetic */ s(ModuleNewImageTextViewHolder moduleNewImageTextViewHolder) {
        this.a = moduleNewImageTextViewHolder;
    }

    public final boolean onError(MediaPlayer mediaPlayer, int n, int n2) {
        return ModuleNewImageTextViewHolder.c(this.a, mediaPlayer, n, n2);
    }
}
