/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.util.Log
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.p
 */
package miui.systemui.notification.focus;

import android.util.Log;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.p;
import miui.systemui.notification.focus.HideDeletedFocusController;

public static final class HideDeletedFocusController.alarmScheduler.1
extends p
implements Function1 {
    final HideDeletedFocusController this$0;

    public HideDeletedFocusController.alarmScheduler.1(HideDeletedFocusController hideDeletedFocusController) {
        this.this$0 = hideDeletedFocusController;
        super(1);
    }

    public final void invoke(String string) {
        CharSequence charSequence = new StringBuilder();
        charSequence.append("onReceive, key=");
        charSequence.append(string);
        charSequence = charSequence.toString();
        Log.d((String)"HideDeletedFocusController", (String)charSequence);
        this.this$0.getMDeletedNotifs().remove(string);
    }
}
