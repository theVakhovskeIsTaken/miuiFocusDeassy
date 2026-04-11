/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.Notification$Action
 *  android.service.notification.StatusBarNotification
 *  android.view.View
 *  android.view.View$OnClickListener
 *  miui.systemui.widget.StatusProgressLayout
 */
package miui.systemui.notification.focus.moduleV3;

import android.app.Notification;
import android.service.notification.StatusBarNotification;
import android.view.View;
import miui.systemui.notification.focus.moduleV3.ModuleButtonViewHolder;
import miui.systemui.widget.StatusProgressLayout;

public final class c
implements View.OnClickListener {
    public final Notification.Action a;
    public final ModuleButtonViewHolder b;
    public final StatusBarNotification c;
    public final String d;
    public final StatusProgressLayout e;
    public final int f;

    public /* synthetic */ c(Notification.Action action, ModuleButtonViewHolder moduleButtonViewHolder, StatusBarNotification statusBarNotification, String string, StatusProgressLayout statusProgressLayout, int n) {
        this.a = action;
        this.b = moduleButtonViewHolder;
        this.c = statusBarNotification;
        this.d = string;
        this.e = statusProgressLayout;
        this.f = n;
    }

    public final void onClick(View view) {
        ModuleButtonViewHolder.d(this.a, this.b, this.c, this.d, this.e, this.f, view);
    }
}
