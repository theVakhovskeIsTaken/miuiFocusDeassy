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
import miui.systemui.notification.focus.moduleV3.ModuleTinyButtonViewHolder;

public final class z
implements View.OnClickListener {
    public final Notification.Action a;
    public final ModuleTinyButtonViewHolder b;
    public final View c;
    public final StatusBarNotification d;

    public /* synthetic */ z(Notification.Action action, ModuleTinyButtonViewHolder moduleTinyButtonViewHolder, View view, StatusBarNotification statusBarNotification) {
        this.a = action;
        this.b = moduleTinyButtonViewHolder;
        this.c = view;
        this.d = statusBarNotification;
    }

    public final void onClick(View view) {
        ModuleTinyButtonViewHolder.d(this.a, this.b, this.c, this.d, view);
    }
}
