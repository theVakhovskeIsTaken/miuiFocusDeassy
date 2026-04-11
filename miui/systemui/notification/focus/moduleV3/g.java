/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.Notification$Action
 *  android.service.notification.StatusBarNotification
 *  android.view.View
 *  android.view.View$OnClickListener
 */
package miui.systemui.notification.focus.moduleV3;

import android.app.Notification;
import android.service.notification.StatusBarNotification;
import android.view.View;
import miui.systemui.notification.focus.moduleV3.ModuleDecoLandButtonViewHolder;

public final class g
implements View.OnClickListener {
    public final Notification.Action a;
    public final ModuleDecoLandButtonViewHolder b;
    public final StatusBarNotification c;

    public /* synthetic */ g(Notification.Action action, ModuleDecoLandButtonViewHolder moduleDecoLandButtonViewHolder, StatusBarNotification statusBarNotification) {
        this.a = action;
        this.b = moduleDecoLandButtonViewHolder;
        this.c = statusBarNotification;
    }

    public final void onClick(View view) {
        ModuleDecoLandButtonViewHolder.d(this.a, this.b, this.c, view);
    }
}
