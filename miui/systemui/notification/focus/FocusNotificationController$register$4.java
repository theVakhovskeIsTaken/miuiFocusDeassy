/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.ContentResolver
 *  android.database.ContentObserver
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.p
 */
package miui.systemui.notification.focus;

import android.content.ContentResolver;
import android.database.ContentObserver;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.p;
import miui.systemui.notification.focus.FocusNotificationController;

public static final class FocusNotificationController.register.4
extends p
implements Function1 {
    final ContentResolver $contentResolver;
    final FocusNotificationController.register.observer.1 $observer;

    public FocusNotificationController.register.4(ContentResolver contentResolver, FocusNotificationController.register.observer.1 var2_2) {
        this.$contentResolver = contentResolver;
        this.$observer = var2_2;
        super(1);
    }

    public final void invoke(Throwable throwable) {
        this.$contentResolver.unregisterContentObserver((ContentObserver)this.$observer);
    }
}
