/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  U0.a
 *  android.util.Log
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.p
 *  miui.systemui.util.AlarmScheduler
 *  miui.systemui.util.AlarmScheduler$Factory
 */
package miui.systemui.notification.focus;

import U0.a;
import android.util.Log;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.p;
import miui.systemui.notification.focus.HideDeletedFocusController;
import miui.systemui.util.AlarmScheduler;

public static final class HideDeletedFocusController.alarmScheduler.2
extends p
implements a {
    final AlarmScheduler.Factory $alarmSchedulerFactory;
    final HideDeletedFocusController this$0;

    public HideDeletedFocusController.alarmScheduler.2(AlarmScheduler.Factory factory, HideDeletedFocusController hideDeletedFocusController) {
        this.$alarmSchedulerFactory = factory;
        this.this$0 = hideDeletedFocusController;
        super(0);
    }

    public final AlarmScheduler invoke() {
        return this.$alarmSchedulerFactory.create("miui.intent.action.FOCUS_NOTIFICATION_DELETE_TIMEOUT", new Function1(this.this$0){
            final HideDeletedFocusController this$0;
            {
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
        });
    }
}
