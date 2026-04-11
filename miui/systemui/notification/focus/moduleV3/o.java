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
import miui.systemui.notification.focus.moduleV3.ModuleDecoPortButtonViewHolder;

public final class o
implements View.OnClickListener {
    public final Notification.Action a;
    public final ModuleDecoPortButtonViewHolder b;
    public final View c;
    public final StatusBarNotification d;

    public /* synthetic */ o(Notification.Action action, ModuleDecoPortButtonViewHolder moduleDecoPortButtonViewHolder, View view, StatusBarNotification statusBarNotification) {
        this.a = action;
        this.b = moduleDecoPortButtonViewHolder;
        this.c = view;
        this.d = statusBarNotification;
    }

    public final void onClick(View view) {
        ModuleDecoPortButtonViewHolder.c(this.a, this.b, this.c, this.d, view);
    }
}
