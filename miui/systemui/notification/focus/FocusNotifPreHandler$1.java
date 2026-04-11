/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.airbnb.lottie.LottieAnimationView
 *  d.H
 *  d.h
 */
package miui.systemui.notification.focus;

import com.airbnb.lottie.LottieAnimationView;
import d.H;
import d.h;

public class FocusNotifPreHandler.1
implements H {
    final String val$type;
    final LottieAnimationView val$view;

    public FocusNotifPreHandler.1() {
        this.val$view = lottieAnimationView;
        this.val$type = string;
    }

    public void onResult(h h2) {
        this.val$view.setComposition(h2);
        if (this.val$type.equals("face_recognition")) {
            this.val$view.setRepeatCount(-1);
            this.val$view.setRepeatMode(1);
        } else {
            this.val$view.setRepeatCount(0);
        }
        this.val$view.setProgress(0.0f);
    }
}
