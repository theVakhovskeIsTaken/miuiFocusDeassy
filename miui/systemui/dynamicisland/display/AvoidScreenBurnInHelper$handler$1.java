/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Handler
 *  android.os.Looper
 *  android.os.Message
 *  kotlin.jvm.internal.o
 */
package miui.systemui.dynamicisland.display;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import kotlin.jvm.internal.o;

public static final class AvoidScreenBurnInHelper.handler.1
extends Handler {
    public AvoidScreenBurnInHelper.handler.1(Looper looper) {
        super(looper);
    }

    public void handleMessage(Message message) {
        o.g((Object)message, (String)"msg");
        int n = message.what;
    }
}
