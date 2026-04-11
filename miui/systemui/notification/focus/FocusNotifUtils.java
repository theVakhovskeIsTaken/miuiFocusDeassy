/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.ContentResolver
 *  android.content.Context
 *  android.content.pm.PackageManager$NameNotFoundException
 *  android.net.Uri
 *  android.os.Bundle
 *  android.os.UserHandle
 *  android.provider.Settings$System
 *  android.service.notification.StatusBarNotification
 *  android.text.TextUtils
 *  android.util.Log
 *  android.widget.RemoteViews
 *  com.android.systemui.plugins.miui.notification.FocusNotificationContent
 *  com.android.systemui.plugins.miui.settings.SuperSaveModeController
 *  kotlin.jvm.internal.E
 *  kotlin.jvm.internal.o
 *  miui.systemui.notification.NotificationUtil
 *  miui.systemui.util.CommonUtils
 *  miui.systemui.util.LoggerKt
 *  org.json.JSONException
 *  org.json.JSONObject
 */
package miui.systemui.notification.focus;

import android.content.ContentResolver;
import android.content.Context;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.UserHandle;
import android.provider.Settings;
import android.service.notification.StatusBarNotification;
import android.text.TextUtils;
import android.util.Log;
import android.widget.RemoteViews;
import com.android.systemui.plugins.miui.notification.FocusNotificationContent;
import com.android.systemui.plugins.miui.settings.SuperSaveModeController;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.E;
import kotlin.jvm.internal.o;
import miui.systemui.notification.NotificationUtil;
import miui.systemui.notification.focus.template.FocusTemplate;
import miui.systemui.util.CommonUtils;
import miui.systemui.util.LoggerKt;
import org.json.JSONException;
import org.json.JSONObject;

public final class FocusNotifUtils {
    public static final Companion Companion = new Object(null){
        {
            this();
        }
    };
    public static final int MAX_SEQ_SIZE = 50;
    public static final String TAG = "FocusNotifUtils";
    private final Map<String, FocusTemplate> OS1Template;
    private final LinkedHashMap<String, Long> maxSeq;
    private final SuperSaveModeController superSaveModeController;

    public FocusNotifUtils(SuperSaveModeController superSaveModeController) {
        o.g((Object)superSaveModeController, (String)"superSaveModeController");
        this.superSaveModeController = superSaveModeController;
        this.OS1Template = new LinkedHashMap<String, FocusTemplate>();
        this.maxSeq = new LinkedHashMap<String, Long>(){

            public boolean removeEldestEntry(Map.Entry<String, Long> entry) {
                o.g(entry, (String)"eldest");
                boolean bl = this.size() > 50;
                return bl;
            }
        };
    }

    /*
     * WARNING - void declaration
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private final Context getContextForUser(Context context, int n) {
        void var3_6;
        Context context2 = context;
        if (n < 0) return var3_6;
        try {
            String string = context.getPackageName();
            UserHandle userHandle = new UserHandle(n);
            Context context3 = context.createPackageContextAsUser(string, 4, userHandle);
            o.f((Object)context3, (String)"createPackageContextAsUser(...)");
            return var3_6;
        }
        catch (PackageManager.NameNotFoundException nameNotFoundException) {
            Context context4 = context;
            return var3_6;
        }
    }

    private final JSONObject parseFocusParamObject(Context context, StatusBarNotification object, String string) {
        if (!object.getNotification().extras.containsKey(string)) {
            return null;
        }
        String string2 = object.getNotification().extras.getString(string, "");
        object = !CommonUtils.isUserRoot() && !CommonUtils.isUserDebug() ? CommonUtils.encodeDataToBase64((String)string2) : string2;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(string);
        stringBuilder.append(" plugin param= ");
        stringBuilder.append((String)object);
        LoggerKt.logfileAsync$default((Context)context, (String)TAG, (String)stringBuilder.toString(), (boolean)false, (int)8, null);
        if (TextUtils.isEmpty((CharSequence)string2)) {
            NotificationUtil.debugLog((String)TAG, (String)"params is empty");
            return null;
        }
        context = new JSONObject(string2);
        if (context.length() >= 1) {
            return context;
        }
        return null;
    }

    public final Bundle call(Context context, String charSequence, Bundle bundle) {
        o.g((Object)context, (String)"context");
        o.g((Object)charSequence, (String)"method");
        try {
            context = context.getContentResolver().call(Uri.parse((String)"content://statusbar.notification"), (String)charSequence, null, bundle);
            return context;
        }
        catch (Exception exception) {
            charSequence = new StringBuilder();
            ((StringBuilder)charSequence).append("Error call ");
            ((StringBuilder)charSequence).append(exception);
            Log.e((String)TAG, (String)((StringBuilder)charSequence).toString());
            return null;
        }
    }

    public final boolean canShowFocus(Context object, String string, int n) {
        boolean bl;
        o.g((Object)object, (String)"context");
        Bundle bundle = new Bundle();
        bundle.putString("package", string);
        object = this.call(this.getContextForUser((Context)object, n), "canShowFocus", bundle);
        boolean bl2 = bl = false;
        if (object != null) {
            bl2 = bl;
            if (object.getBoolean("canShowFocus", false)) {
                bl2 = true;
            }
        }
        object = new StringBuilder();
        ((StringBuilder)object).append("canShowFocus: ");
        ((StringBuilder)object).append(bl2);
        NotificationUtil.debugLog((String)TAG, (String)((StringBuilder)object).toString());
        return bl2;
    }

    public final LinkedHashMap<String, Long> getMaxSeq() {
        return this.maxSeq;
    }

    public final Map<String, FocusTemplate> getOS1Template() {
        return this.OS1Template;
    }

    public final int getScreenWidth(Context context) {
        o.g((Object)context, (String)"context");
        return context.getResources().getDisplayMetrics().widthPixels;
    }

    public final boolean hasCustomFocusView(StatusBarNotification statusBarNotification) {
        o.g((Object)statusBarNotification, (String)"sbn");
        try {
            boolean bl = statusBarNotification.getNotification().extras.getParcelable("miui.focus.rv") instanceof RemoteViews;
            return bl;
        }
        catch (Exception exception) {
            return false;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final boolean hasIslandData(StatusBarNotification object) {
        Exception exception2;
        block7: {
            JSONObject jSONObject;
            Object var8_5;
            Object object2;
            boolean bl = false;
            if (object == null) {
                return false;
            }
            try {
                object2 = object.getNotification();
                var8_5 = null;
                jSONObject = object2 != null && (object2 = object2.extras) != null && (object2 = object2.getString("miui.focus.param")) != null ? new JSONObject((String)object2) : null;
            }
            catch (Exception exception2) {
                break block7;
            }
            JSONObject jSONObject2 = jSONObject != null ? jSONObject.optJSONObject("param_v2") : null;
            object2 = jSONObject;
            if (jSONObject2 == null) {
                object2 = jSONObject;
                if (this.hasCustomFocusView((StatusBarNotification)object)) {
                    object = object.getNotification().extras.getString("miui.focus.param.custom");
                    object2 = object != null ? new JSONObject((String)object) : null;
                }
            }
            object = jSONObject2;
            if (jSONObject2 == null) {
                object = object2;
            }
            object2 = var8_5;
            if (object != null) {
                object2 = object.optJSONObject("param_island");
            }
            boolean bl2 = bl;
            if (object2 == null) return bl2;
            object = object2.toString();
            o.f((Object)object, (String)"toString(...)");
            int n = object.length();
            bl2 = bl;
            if (n <= 0) return bl2;
            return true;
        }
        exception2.printStackTrace();
        return false;
    }

    public final boolean isFocusFsiInterrupt(StatusBarNotification statusBarNotification) {
        o.g((Object)statusBarNotification, (String)"sbn");
        if (statusBarNotification.getNotification().fullScreenIntent == null) {
            return false;
        }
        if (this.superSaveModeController.isActive()) {
            Log.i((String)TAG, (String)"interrupted with super save mode is active");
            return true;
        }
        return false;
    }

    public final boolean isSupportFocusNotification(Context context) {
        o.g((Object)context, (String)"context");
        context = context.getContentResolver();
        boolean bl = false;
        if (Settings.System.getInt((ContentResolver)context, (String)"notification_focus_protocol", (int)0) > 0) {
            bl = true;
        }
        return bl;
    }

    public final void onNotificationRemoved(StatusBarNotification object) {
        Map<String, FocusTemplate> map = this.OS1Template;
        object = object != null ? object.getKey() : null;
        E.d(map).remove(object);
    }

    public final String parseCustomIslandData(StatusBarNotification object) {
        o.g((Object)object, (String)"sbn");
        Log.d((String)"FocusPlugin", (String)"parseCustomIslandData");
        object = object.getNotification().extras.getString("miui.focus.param.custom");
        JSONObject jSONObject = null;
        object = object != null ? new JSONObject((String)object) : null;
        if (object != null && object.has("param_island")) {
            if (object != null) {
                jSONObject = object.getJSONObject("param_island");
            }
            return String.valueOf(jSONObject);
        }
        jSONObject = new JSONObject();
        jSONObject.put("islandProperty", 1);
        jSONObject.put("islandPriority", 1);
        object = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("picInfo", (Object)new JSONObject());
        jSONObject2.put("type", 1);
        object.put("imageTextInfoLeft", (Object)jSONObject2);
        jSONObject.put("bigIslandArea", object);
        object = jSONObject.toString();
        o.f((Object)object, (String)"toString(...)");
        return object;
    }

    public final JSONObject parseFocusParam(Context context, StatusBarNotification statusBarNotification, String string, FocusNotificationContent focusNotificationContent) {
        o.g((Object)context, (String)"sysuiCtx");
        o.g((Object)statusBarNotification, (String)"sbn");
        o.g((Object)string, (String)"type");
        try {
            context = this.parseFocusParamObject(context, statusBarNotification, string);
        }
        catch (JSONException jSONException) {
            statusBarNotification = statusBarNotification.getNotification().extras;
            o.f((Object)statusBarNotification, (String)"extras");
            this.resetAllParam((Bundle)statusBarNotification);
            if (focusNotificationContent != null) {
                focusNotificationContent.reset();
            }
            NotificationUtil.debugLog((String)TAG, (String)((Object)((Object)jSONException)).toString());
            jSONException.printStackTrace();
            context = null;
        }
        return context;
    }

    public final String parseOS1DefaultIslandData(JSONObject object, StatusBarNotification object2) {
        o.g((Object)object, (String)"focusJsonParams");
        o.g((Object)object2, (String)"sbn");
        Log.d((String)"FocusPlugin", (String)"parseOS1DefaultIslandData");
        Object object3 = object.optJSONObject("param_island");
        if (object3 != null) {
            object = object3.toString();
            o.d((Object)object);
        } else {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("islandProperty", 1);
            jSONObject.put("islandPriority", 1);
            JSONObject jSONObject2 = new JSONObject();
            object3 = new JSONObject();
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("pic", (Object)object2.getNotification().extras.getString("miui.focus.pic_ticker"));
            jSONObject3.put("type", 1);
            object3.put("picInfo", (Object)jSONObject3);
            object3.put("type", 1);
            jSONObject2.put("imageTextInfoLeft", object3);
            if (object.has("timerType") && object.has("timerWhen")) {
                object2 = new JSONObject();
                object2.put("timerType", object.optInt("timerType"));
                object2.put("timerWhen", object.optLong("timerWhen"));
                object2.put("timerTotal", object.optLong("timerTotal"));
                object2.put("timerSystemCurrent", object.optLong("timerSystemCurrent"));
                object = new JSONObject();
                object.put("timerInfo", object2);
                jSONObject2.put("sameWidthDigitInfo", object);
            } else {
                JSONObject jSONObject4 = new JSONObject();
                jSONObject3 = new JSONObject();
                object3 = object.optString("ticker");
                object2 = object3;
                if (TextUtils.isEmpty((CharSequence)object3)) {
                    object2 = object.optString("title");
                }
                jSONObject3.put("title", object2);
                jSONObject4.put("textInfo", (Object)jSONObject3);
                jSONObject4.put("type", 2);
                jSONObject2.put("imageTextInfoRight", (Object)jSONObject4);
            }
            jSONObject.put("bigIslandArea", (Object)jSONObject2);
            object = jSONObject.toString();
            o.d((Object)object);
        }
        return object;
    }

    public final String parseOS2DefaultIslandData(JSONObject object, StatusBarNotification statusBarNotification) {
        o.g((Object)object, (String)"focusJsonParams");
        o.g((Object)statusBarNotification, (String)"sbn");
        Log.d((String)"FocusPlugin", (String)"parseOS2DefaultIslandData");
        JSONObject jSONObject = object.optJSONObject("param_island");
        if (jSONObject != null) {
            object = jSONObject.toString();
            o.d((Object)object);
        } else {
            jSONObject = new JSONObject();
            JSONObject jSONObject2 = new JSONObject();
            JSONObject jSONObject3 = new JSONObject();
            JSONObject jSONObject4 = new JSONObject();
            jSONObject4.put("type", 1);
            jSONObject4.put("pic", (Object)statusBarNotification.getNotification().extras.getString("miui.focus.pic_ticker"));
            jSONObject3.put("picInfo", (Object)jSONObject4);
            jSONObject3.put("type", 1);
            jSONObject2.put("imageTextInfoLeft", (Object)jSONObject3);
            object = object.optJSONObject("highlightInfo");
            object = object != null ? object.optJSONObject("timerInfo") : null;
            if (object != null) {
                statusBarNotification = new JSONObject();
                statusBarNotification.put("timerInfo", object);
                jSONObject2.put("sameWidthDigitInfo", (Object)statusBarNotification);
            } else {
                object = new JSONObject();
                jSONObject4 = new JSONObject();
                jSONObject4.put("title", (Object)statusBarNotification.getNotification().extras.getString("miui.focus.ticker"));
                object.put("textInfo", (Object)jSONObject4);
                object.put("type", 2);
                jSONObject2.put("imageTextInfoRight", object);
            }
            jSONObject.put("islandProperty", 1);
            jSONObject.put("islandPriority", 1);
            jSONObject.put("bigIslandArea", (Object)jSONObject2);
            object = jSONObject.toString();
            o.d((Object)object);
        }
        return object;
    }

    public final void resetAllParam(Bundle bundle) {
        o.g((Object)bundle, (String)"extras");
        this.resetParam(bundle, "miui.focus.rv");
        this.resetParam(bundle, "miui.focus.rvNight");
        this.resetParam(bundle, "miui.focus.rvAod");
        this.resetParam(bundle, "miui.focus.rv.fullAod");
        this.resetParam(bundle, "miui.focus.ticker");
        this.resetParam(bundle, "miui.focus.isFocus");
        this.resetParam(bundle, "miui.focus.rv.island.expand");
    }

    public final void resetParam(Bundle bundle, String string) {
        o.g((Object)bundle, (String)"bundle");
        o.g((Object)string, (String)"param");
        bundle.remove(string);
    }
}
