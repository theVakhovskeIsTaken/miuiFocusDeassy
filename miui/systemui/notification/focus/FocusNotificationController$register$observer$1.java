/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.database.ContentObserver
 *  android.net.Uri
 *  android.os.Handler
 *  android.util.Log
 *  kotlin.jvm.internal.o
 */
package miui.systemui.notification.focus;

import android.database.ContentObserver;
import android.net.Uri;
import android.os.Handler;
import android.util.Log;
import kotlin.jvm.internal.o;
import miui.systemui.notification.focus.FocusNotificationController;

public static final class FocusNotificationController.register.observer.1
extends ContentObserver {
    final FocusNotificationController this$0;

    public FocusNotificationController.register.observer.1(FocusNotificationController focusNotificationController, Handler handler) {
        this.this$0 = focusNotificationController;
        super(handler);
    }

    public void onChange(boolean bl, Uri object) {
        block3: {
            o.g((Object)object, (String)"uri");
            String string = object.getQueryParameter("package");
            bl = Boolean.parseBoolean(object.getQueryParameter("canShowFocus"));
            object = new StringBuilder();
            ((StringBuilder)object).append("mCanShowFocusObserver onChange pkg=");
            ((StringBuilder)object).append(string);
            ((StringBuilder)object).append(", canShowFocus=");
            ((StringBuilder)object).append(bl);
            Log.e((String)"FocusPlugin", (String)((StringBuilder)object).toString());
            if (bl) break block3;
            try {
                this.this$0.removeByPkg(string);
            }
            catch (Exception exception) {
                exception.printStackTrace();
            }
        }
    }
}
