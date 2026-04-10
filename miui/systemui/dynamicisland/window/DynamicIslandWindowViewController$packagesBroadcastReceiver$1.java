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
import miui.systemui.dynamicisland.window.DynamicIslandWindowView;

public static final class DynamicIslandWindowViewController.packagesBroadcastReceiver.1
extends BroadcastReceiver {
    final DynamicIslandWindowView $view;

    public DynamicIslandWindowViewController.packagesBroadcastReceiver.1(DynamicIslandWindowView dynamicIslandWindowView) {
        this.$view = dynamicIslandWindowView;
    }

    public void onReceive(Context object, Intent object2) {
        o.g((Object)object, (String)"context");
        o.g((Object)object2, (String)"intent");
        object = object2.getAction();
        if ((o.c((Object)"android.intent.action.PACKAGE_ADDED", (Object)object) || o.c((Object)"android.intent.action.PACKAGE_REPLACED", (Object)object) || o.c((Object)"android.intent.action.PACKAGE_REMOVED", (Object)object)) && (object = object2.getData()) != null) {
            object = object.getSchemeSpecificPart();
            object2 = this.$view;
            o.d((Object)object);
            ((DynamicIslandWindowView)((Object)object2)).updatePkgSupportFreeform((String)object);
        }
    }
}
