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

public final class i
implements View.OnClickListener {
    public final Notification.Action a;
    public final ModuleDecoLandButtonViewHolder b;
    public final View c;
    public final StatusBarNotification d;

    public /* synthetic */ i(Notification.Action action, ModuleDecoLandButtonViewHolder moduleDecoLandButtonViewHolder, View view, StatusBarNotification statusBarNotification) {
        this.a = action;
        this.b = moduleDecoLandButtonViewHolder;
        this.c = view;
        this.d = statusBarNotification;
    }

    public final void onClick(View view) {
        ModuleDecoLandButtonViewHolder.e(this.a, this.b, this.c, this.d, view);
    }
}
