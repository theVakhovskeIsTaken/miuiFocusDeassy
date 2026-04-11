/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  G0.d
 *  G0.e
 *  U0.a
 *  android.os.SystemClock
 *  android.service.notification.StatusBarNotification
 *  android.text.TextUtils
 *  android.util.Log
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.o
 *  miui.systemui.notification.NotificationSettingsManager
 *  miui.systemui.notification.NotificationUtil
 *  miui.systemui.util.AlarmScheduler
 *  miui.systemui.util.AlarmScheduler$Factory
 */
package miui.systemui.notification.focus;

import G0.d;
import G0.e;
import U0.a;
import android.os.SystemClock;
import android.service.notification.StatusBarNotification;
import android.text.TextUtils;
import android.util.Log;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.o;
import miui.systemui.notification.NotificationSettingsManager;
import miui.systemui.notification.NotificationUtil;
import miui.systemui.util.AlarmScheduler;

public final class HideDeletedFocusController {
    public static final String ACTION_NOTIFICATION_TIMEOUT = "miui.intent.action.FOCUS_NOTIFICATION_DELETE_TIMEOUT";
    public static final Companion Companion = new Object(null){
        {
            this();
        }
    };
    public static final String TAG = "HideDeletedFocusController";
    public static final int TIMEOUT = 86400000;
    public static final int TIMEOUT_DEBUG = 60000;
    private final d alarmScheduler$delegate;
    private Map<String, Boolean> mDeletedNotifs;
    private final NotificationSettingsManager notificationSettingsManager;

    public HideDeletedFocusController(AlarmScheduler.Factory factory, NotificationSettingsManager notificationSettingsManager) {
        o.g((Object)factory, (String)"alarmSchedulerFactory");
        o.g((Object)notificationSettingsManager, (String)"notificationSettingsManager");
        this.notificationSettingsManager = notificationSettingsManager;
        this.alarmScheduler$delegate = e.b((a)new a(factory, this){
            final AlarmScheduler.Factory $alarmSchedulerFactory;
            final HideDeletedFocusController this$0;
            {
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
        });
        this.mDeletedNotifs = new LinkedHashMap<String, Boolean>(this){
            final HideDeletedFocusController this$0;
            {
                this.this$0 = hideDeletedFocusController;
            }

            public boolean removeEldestEntry(Map.Entry<String, Boolean> entry) {
                String string;
                boolean bl = this.size() > 50;
                if (bl && (string = entry != null ? entry.getKey() : null) != null) {
                    HideDeletedFocusController.access$cancelAlarm(this.this$0, entry.getKey());
                }
                return bl;
            }
        };
    }

    public static final /* synthetic */ void access$cancelAlarm(HideDeletedFocusController hideDeletedFocusController, String string) {
        hideDeletedFocusController.cancelAlarm(string);
    }

    private final void cancelAlarm(String string) {
        if (string != null) {
            this.getAlarmScheduler().cancelAlarm(string);
        }
    }

    private final AlarmScheduler getAlarmScheduler() {
        return (AlarmScheduler)this.alarmScheduler$delegate.getValue();
    }

    private final void scheduleFocusDeletedTimeout(StatusBarNotification object) {
        String string = object.getKey();
        int n = object.getKey().hashCode();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("scheduleFocusDeletedTimeout: entry.getKey() ");
        stringBuilder.append(string);
        stringBuilder.append(" entry.getKey().hashCode() ");
        stringBuilder.append(n);
        Log.i((String)TAG, (String)stringBuilder.toString());
        n = NotificationUtil.DEBUG ? 60000 : 86400000;
        if (object.getKey() != null) {
            string = this.getAlarmScheduler();
            object = object.getKey();
            o.f((Object)object, (String)"getKey(...)");
            string.addAlarm((String)object, SystemClock.elapsedRealtime() + (long)n);
        }
    }

    public final Map<String, Boolean> getMDeletedNotifs() {
        return this.mDeletedNotifs;
    }

    public final void onNotificationRemoved(StatusBarNotification object, Integer object2) {
        if (object != null && (object2 == null || (Integer)object2 != 12)) {
            String string = object.getKey();
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("onNotificationRemoved ");
            stringBuilder.append(object2);
            stringBuilder.append(" ");
            stringBuilder.append(string);
            Log.d((String)TAG, (String)stringBuilder.toString());
            if (object2 != null && (Integer)object2 == 2) {
                if (!this.notificationSettingsManager.isFocusNotificationDeletedBlackList(object.getPackageName())) {
                    if (!this.mDeletedNotifs.containsKey(object.getKey())) {
                        this.mDeletedNotifs.put(object.getKey(), Boolean.TRUE);
                        this.scheduleFocusDeletedTimeout((StatusBarNotification)object);
                    }
                } else {
                    object2 = object.getPackageName();
                    string = object.getKey();
                    object = new StringBuilder();
                    ((StringBuilder)object).append("isFocusNotificationDeletedBlackList ");
                    ((StringBuilder)object).append((String)object2);
                    ((StringBuilder)object).append(" ");
                    ((StringBuilder)object).append(string);
                    Log.d((String)TAG, (String)((StringBuilder)object).toString());
                }
            } else {
                this.mDeletedNotifs.remove(object.getKey());
                this.cancelAlarm(object.getKey());
            }
        }
    }

    public final void setMDeletedNotifs(Map<String, Boolean> map) {
        o.g(map, (String)"<set-?>");
        this.mDeletedNotifs = map;
    }

    public final boolean suppressDeletedFocus(StatusBarNotification statusBarNotification) {
        o.g((Object)statusBarNotification, (String)"sbn");
        if (this.mDeletedNotifs.containsKey(statusBarNotification.getKey()) && statusBarNotification.getNotification().extras.containsKey("miui.focus.reopen")) {
            String string = statusBarNotification.getNotification().extras.getString("miui.focus.reopen");
            String string2 = statusBarNotification.getKey();
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("filter out extraReopen=");
            stringBuilder.append(string);
            stringBuilder.append(" ");
            stringBuilder.append(string2);
            Log.d((String)TAG, (String)stringBuilder.toString());
            if (TextUtils.equals((CharSequence)"reopen", (CharSequence)string)) {
                this.mDeletedNotifs.remove(statusBarNotification.getKey());
                this.cancelAlarm(statusBarNotification.getKey());
                return false;
            }
            if (TextUtils.equals((CharSequence)"close", (CharSequence)string)) {
                return true;
            }
        }
        return false;
    }
}
