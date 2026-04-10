/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.BroadcastReceiver
 *  android.content.Context
 *  android.content.Intent
 *  android.util.Log
 *  kotlin.jvm.internal.o
 */
package miui.systemui.dynamicisland.window;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import kotlin.jvm.internal.o;
import miui.systemui.dynamicisland.window.DynamicIslandWindowView;

public static final class DynamicIslandWindowViewController.collapsedReceiver.1
extends BroadcastReceiver {
    final DynamicIslandWindowView $view;

    public DynamicIslandWindowViewController.collapsedReceiver.1(DynamicIslandWindowView dynamicIslandWindowView) {
        this.$view = dynamicIslandWindowView;
    }

    public void onReceive(Context object, Intent intent) {
        o.g((Object)object, (String)"context");
        o.g((Object)intent, (String)"intent");
        String string = intent.getAction();
        object = new StringBuilder();
        ((StringBuilder)object).append("onReceive   : ");
        ((StringBuilder)object).append(string);
        Log.d((String)"DynamicIslandWindowViewController", (String)((StringBuilder)object).toString());
        if (o.c((Object)"com.miui.action.ACTION_COLLAPSE_ISLAND", (Object)intent.getAction())) {
            this.$view.collapse("receive collapse");
        }
    }
}
