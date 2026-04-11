/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.animation.Animator
 *  android.animation.Animator$AnimatorListener
 *  android.service.notification.StatusBarNotification
 *  androidx.annotation.NonNull
 *  com.airbnb.lottie.LottieAnimationView
 *  com.android.systemui.plugins.NotificationListenerController$NotificationProvider
 */
package miui.systemui.notification.focus;

import android.animation.Animator;
import android.service.notification.StatusBarNotification;
import androidx.annotation.NonNull;
import com.airbnb.lottie.LottieAnimationView;
import com.android.systemui.plugins.NotificationListenerController;
import miui.systemui.notification.focus.FocusNotifPreHandler;

public class FocusNotifPreHandler.2
implements Animator.AnimatorListener {
    final FocusNotifPreHandler this$0;
    final NotificationListenerController.NotificationProvider val$provider;
    final StatusBarNotification val$sbn;
    final String val$type;
    final LottieAnimationView val$view;

    public FocusNotifPreHandler.2() {
        this.this$0 = focusNotifPreHandler;
        this.val$sbn = statusBarNotification;
        this.val$type = string;
        this.val$view = lottieAnimationView;
        this.val$provider = notificationProvider;
    }

    public void onAnimationCancel(@NonNull Animator animator) {
        this.this$0.clearFaceRecognition(this.val$sbn, this.val$type, this.val$view, this.val$provider);
    }

    public void onAnimationEnd(@NonNull Animator animator) {
        this.this$0.clearFaceRecognition(this.val$sbn, this.val$type, this.val$view, this.val$provider);
    }

    public void onAnimationRepeat(@NonNull Animator animator) {
    }

    public void onAnimationStart(@NonNull Animator animator) {
    }
}
