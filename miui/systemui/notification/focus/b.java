/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.PendingIntent
 *  android.view.View
 *  android.widget.RemoteViews$RemoteResponse
 */
package miui.systemui.notification.focus;

import android.app.PendingIntent;
import android.view.View;
import android.widget.RemoteViews;
import miui.systemui.notification.focus.FocusNotifPreHandler;

public final class b
implements FocusNotifPreHandler.ClickHandler {
    public final FocusNotifPreHandler a;
    public final View b;
    public final PendingIntent c;
    public final RemoteViews.RemoteResponse d;

    public /* synthetic */ b(FocusNotifPreHandler focusNotifPreHandler, View view, PendingIntent pendingIntent, RemoteViews.RemoteResponse remoteResponse) {
        this.a = focusNotifPreHandler;
        this.b = view;
        this.c = pendingIntent;
        this.d = remoteResponse;
    }

    @Override
    public final boolean handleClick() {
        return FocusNotifPreHandler.a(this.a, this.b, this.c, this.d);
    }
}
