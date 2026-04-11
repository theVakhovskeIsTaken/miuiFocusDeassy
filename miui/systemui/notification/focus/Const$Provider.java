/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.net.Uri
 */
package miui.systemui.notification.focus;

import android.net.Uri;

public static class Const.Provider {
    public static final String METHOD_CAN_SHOW_FOCUS = "canShowFocus";
    public static final String NOTIFICATION_FOCUS_PROTOCOL = "notification_focus_protocol";
    public static final String NOTIFICATION_PROVIDER = "content://statusbar.notification";
    public static final String PARM_CAN_SHOW_FOCUS = "canShowFocus";
    public static final String PARM_PACKAGE = "package";
    public static final Uri URI_CAN_SHOW_FOCUS = Uri.parse((String)"content://statusbar.notification/canShowFocus");
}
