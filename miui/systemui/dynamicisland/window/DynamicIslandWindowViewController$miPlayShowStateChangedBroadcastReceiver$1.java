/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.BroadcastReceiver
 *  android.content.Context
 *  android.content.Intent
 *  kotlin.jvm.internal.o
 */
package miui.systemui.dynamicisland.window;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import kotlin.jvm.internal.o;
import miui.systemui.dynamicisland.window.DynamicIslandWindowViewController;

public static final class DynamicIslandWindowViewController.miPlayShowStateChangedBroadcastReceiver.1
extends BroadcastReceiver {
    final DynamicIslandWindowViewController this$0;

    public DynamicIslandWindowViewController.miPlayShowStateChangedBroadcastReceiver.1(DynamicIslandWindowViewController dynamicIslandWindowViewController) {
        this.this$0 = dynamicIslandWindowViewController;
    }

    public void onReceive(Context context, Intent intent) {
        o.g((Object)context, (String)"context");
        o.g((Object)intent, (String)"intent");
        if (o.c((Object)"android.intent.action.MIPLAY_SHOW_STATE_CHANGED", (Object)intent.getAction())) {
            boolean bl = intent.getBooleanExtra("extra_miplay_show_state", true);
            this.this$0.handleMiPlayShowState(bl);
        }
    }
}
