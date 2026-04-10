/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  G0.j
 *  G0.j$a
 *  G0.k
 *  H0.i
 *  H0.u
 *  android.app.ActivityManager
 *  android.app.INotificationManager
 *  android.app.INotificationManager$Stub
 *  android.app.WindowConfiguration
 *  android.content.ContentResolver
 *  android.content.Context
 *  android.content.ContextWrapper
 *  android.content.Intent
 *  android.content.pm.ActivityInfo
 *  android.content.pm.ApplicationInfo
 *  android.content.pm.PackageManager
 *  android.content.pm.PackageManager$NameNotFoundException
 *  android.content.pm.ResolveInfo
 *  android.content.res.Configuration
 *  android.content.res.Resources
 *  android.graphics.drawable.Drawable
 *  android.os.Build
 *  android.os.Bundle
 *  android.os.IBinder
 *  android.os.ServiceManager
 *  android.provider.Settings$Global
 *  android.service.notification.StatusBarNotification
 *  android.text.TextUtils
 *  android.util.Log
 *  android.util.MiuiMultiWindowUtils
 *  android.view.Display
 *  android.view.DisplayCutout
 *  android.widget.RemoteViews
 *  b1.f
 *  com.android.systemui.plugins.miui.dynamicisland.DynamicIslandData
 *  e1.o
 *  kotlin.jvm.internal.o
 *  miui.app.MiuiFreeFormManager
 *  miui.app.MiuiFreeFormManager$MiuiFreeFormStackInfo
 *  miui.systemui.drawable.AppIconsManager
 *  miui.systemui.util.CommonUtils
 *  miui.systemui.util.ReflectUtil
 *  miui.systemui.util.WindowConfigurationCompat
 *  miui.systemui.util.liveupdate.PromotedNotificationParamUtils
 *  miuix.os.Build
 *  org.json.JSONException
 *  org.json.JSONObject
 */
package miui.systemui.dynamicisland;

import G0.j;
import G0.k;
import H0.i;
import H0.u;
import android.app.ActivityManager;
import android.app.INotificationManager;
import android.app.WindowConfiguration;
import android.content.ContentResolver;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.IBinder;
import android.os.ServiceManager;
import android.provider.Settings;
import android.service.notification.StatusBarNotification;
import android.text.TextUtils;
import android.util.Log;
import android.util.MiuiMultiWindowUtils;
import android.view.Display;
import android.view.DisplayCutout;
import android.widget.RemoteViews;
import b1.f;
import com.android.systemui.plugins.miui.dynamicisland.DynamicIslandData;
import e1.o;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Method;
import java.util.List;
import miui.app.MiuiFreeFormManager;
import miui.systemui.drawable.AppIconsManager;
import miui.systemui.dynamicisland.R;
import miui.systemui.dynamicisland.event.DynamicIslandState;
import miui.systemui.util.CommonUtils;
import miui.systemui.util.ReflectUtil;
import miui.systemui.util.WindowConfigurationCompat;
import miui.systemui.util.liveupdate.PromotedNotificationParamUtils;
import miuix.os.Build;
import org.json.JSONException;
import org.json.JSONObject;

public final class DynamicIslandUtils {
    public static final DynamicIslandUtils INSTANCE = new DynamicIslandUtils();
    private static final String ISLAND_ANIM_DURATION_SCALE;
    public static final String TAG = "DynamicIslandUtils";
    private static float animDurationScale;
    private static int cutoutBoundingRectTopWidth;
    private static String[] cutoutNeedWidenDeviceList;
    private static final boolean isInternationalBuild;
    private static Context onlyApplicationContext;
    private static int tinyScreenInsetBottom;
    private static int tinyScreenInsetLeft;
    private static int tinyScreenInsetRight;
    private static int tinyScreenInsetTop;
    private static final int traceCookie;
    private static final String traceName;

    static {
        traceName = "DynamicIslandAnimation#IslandAnimRunning";
        traceCookie = "DynamicIslandAnimation#IslandAnimRunning".hashCode();
        isInternationalBuild = Build.IS_INTERNATIONAL_BUILD;
        ISLAND_ANIM_DURATION_SCALE = "island_animator_duration_scale";
        animDurationScale = -1.0f;
    }

    private DynamicIslandUtils() {
    }

    public static final /* synthetic */ Context access$getOnlyApplicationContext$p() {
        return onlyApplicationContext;
    }

    private final Context buildOnlyApplicationContext(Context context) {
        return new ContextWrapper(context){
            final Context $context;
            {
                this.$context = context;
                super(context);
            }

            public Context getApplicationContext() {
                return this;
            }

            public Resources getResources() {
                Resources resources = this.$context.getResources();
                kotlin.jvm.internal.o.f((Object)resources, (String)"getResources(...)");
                return resources;
            }
        };
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private final void cancelNotification(StatusBarNotification object) {
        Exception exception2;
        block4: {
            String string;
            String string2;
            Class<Integer> clazz;
            INotificationManager iNotificationManager;
            block3: {
                block2: {
                    iNotificationManager = INotificationManager.Stub.asInterface((IBinder)ServiceManager.getService((String)"notification"));
                    try {
                        clazz = Integer.TYPE;
                        if (object.getKey() != null) break block2;
                        string2 = object.getPackageName();
                        break block3;
                    }
                    catch (Exception exception2) {
                        break block4;
                    }
                }
                string2 = object.getKey();
                kotlin.jvm.internal.o.f((Object)string2, (String)"getKey(...)");
                string = object.getPackageName();
                kotlin.jvm.internal.o.f((Object)string, (String)"getPackageName(...)");
                string2 = o.v((CharSequence)string2, (CharSequence)string, (boolean)false, (int)2, null) ? object.getPackageName() : object.getOpPkg();
            }
            string = object.getTag();
            int n = object.getId();
            int n2 = object.getUserId();
            ReflectUtil.callObjectMethod((Object)iNotificationManager, Void.class, (String)"cancelNotificationWithTag", (Class[])new Class[]{String.class, String.class, String.class, clazz, clazz}, (Object[])new Object[]{string2, "com.android.systemui", string, n, n2});
            return;
        }
        object = object.getKey();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("cancelNotification: ");
        stringBuilder.append((String)object);
        Log.e((String)TAG, (String)stringBuilder.toString(), (Throwable)exception2);
    }

    private final Context contextWrapper(Context context) {
        if (onlyApplicationContext == null) {
            onlyApplicationContext = this.buildOnlyApplicationContext(context);
        }
        return new ContextWrapper(context){
            final Context $context;
            {
                this.$context = context;
                super(context);
            }

            public Context getApplicationContext() {
                return DynamicIslandUtils.access$getOnlyApplicationContext$p();
            }

            public Resources getResources() {
                Resources resources = this.$context.getResources();
                kotlin.jvm.internal.o.f((Object)resources, (String)"getResources(...)");
                return resources;
            }
        };
    }

    private final List<String> getTopSplitPackageNames(Context object) {
        try {
            object = MiuiMultiWindowUtils.class.getMethod("getTopSplitPackageNames", Context.class).invoke(null, object);
            kotlin.jvm.internal.o.e((Object)object, (String)"null cannot be cast to non-null type kotlin.collections.List<kotlin.String>");
            object = (List)object;
            int n = object.size();
            if (n > 0) {
                return object;
            }
        }
        catch (Exception exception) {
            Log.e((String)TAG, (String)"getTopSplitPackageNames");
        }
        return null;
    }

    private final boolean hasCustomFocusView(StatusBarNotification statusBarNotification) {
        boolean bl;
        try {
            bl = statusBarNotification.getNotification().extras.getParcelable("miui.focus.rv") instanceof RemoteViews;
        }
        catch (Exception exception) {
            bl = false;
        }
        return bl;
    }

    private final boolean shouldCancelNotification(StatusBarNotification statusBarNotification) {
        boolean bl = PromotedNotificationParamUtils.isNotificationPromotedOngoing((StatusBarNotification)statusBarNotification);
        boolean bl2 = true;
        if (bl) {
            if ((statusBarNotification.getNotification().flags & 0x10) == 0) {
                bl2 = false;
            }
            return bl2;
        }
        if (this.hasCustomFocusView(statusBarNotification)) {
            return false;
        }
        return (statusBarNotification = this.resolveFocusParam(statusBarNotification)) != null && !statusBarNotification.optBoolean("updatable", false);
    }

    public final boolean activitySupportFreeform(Context context, Intent intent) {
        kotlin.jvm.internal.o.g((Object)context, (String)"context");
        boolean bl = true;
        if (intent == null) {
            return true;
        }
        if ((context = context.getPackageManager().resolveActivity(intent, 0)) != null) {
            bl = ActivityInfo.isResizeableMode((int)context.activityInfo.resizeMode);
        }
        return bl;
    }

    public final void clearIslandNotification(StatusBarNotification statusBarNotification) {
        kotlin.jvm.internal.o.g((Object)statusBarNotification, (String)"sbn");
        if (this.shouldCancelNotification(statusBarNotification)) {
            String string = statusBarNotification.getKey();
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("notification_cancel clear ");
            stringBuilder.append(string);
            stringBuilder.append(" on island.");
            Log.w((String)TAG, (String)stringBuilder.toString());
            this.cancelNotification(statusBarNotification);
        }
    }

    public final int dpToPx(int n, Context context) {
        kotlin.jvm.internal.o.g((Object)context, (String)"context");
        float f = context.getResources().getDisplayMetrics().density;
        return (int)((float)n * f);
    }

    public final Drawable getAppIcon(Context context, String string, Integer n) {
        ApplicationInfo applicationInfo;
        kotlin.jvm.internal.o.g((Object)context, (String)"pluginContext");
        ApplicationInfo applicationInfo2 = applicationInfo = null;
        if (n != null) {
            if (string == null) {
                applicationInfo2 = applicationInfo;
            } else {
                try {
                    context = this.contextWrapper(context);
                    applicationInfo2 = context.getPackageManager().getApplicationInfo(string, 128);
                    applicationInfo2 = AppIconsManager.INSTANCE.getAppIcon(string, n.intValue(), applicationInfo2, context.getPackageManager(), context);
                }
                catch (Exception exception) {
                    Log.e((String)TAG, (String)"error when getAppIcon");
                    applicationInfo2 = applicationInfo;
                }
                catch (PackageManager.NameNotFoundException nameNotFoundException) {
                    Log.e((String)TAG, (String)"error when getAppIcon caught NameNotFoundException");
                    applicationInfo2 = applicationInfo;
                }
            }
        }
        return applicationInfo2;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final String getAppName(Context object, DynamicIslandData object2) {
        Exception exception2;
        block2: {
            PackageManager packageManager;
            kotlin.jvm.internal.o.g((Object)object, (String)"context");
            Object var3_4 = null;
            try {
                packageManager = object.getPackageManager();
                object = object2 != null && (object = object2.getExtras()) != null ? object.getString("miui.pkg.name") : null;
            }
            catch (Exception exception2) {
                break block2;
            }
            object = object != null ? packageManager.getApplicationInfo((String)object, 0) : null;
            object2 = var3_4;
            if (object == null) return object2;
            return ((Object)packageManager.getApplicationLabel((ApplicationInfo)object)).toString();
        }
        exception2.printStackTrace();
        return null;
    }

    public final int getCutoutBoundingRectTopWidth() {
        return cutoutBoundingRectTopWidth;
    }

    public final float getDebugIslandAnimScale(Context context) {
        kotlin.jvm.internal.o.g((Object)context, (String)"ctx");
        if (animDurationScale < 0.0f) {
            animDurationScale = f.h((float)Settings.Global.getFloat((ContentResolver)context.getContentResolver(), (String)ISLAND_ANIM_DURATION_SCALE, (float)1.0f), (float)0.1f, (float)10.0f);
        }
        return animDurationScale;
    }

    public final List<MiuiFreeFormManager.MiuiFreeFormStackInfo> getFreeFormList() {
        Object object;
        block4: {
            Throwable throwable2;
            Object var2_1;
            block3: {
                List list;
                block2: {
                    var2_1 = null;
                    list = null;
                    try {
                        Object object2 = j.a;
                        object2 = MiuiFreeFormManager.class.getMethod("getAllFreeFormStackInfosOnDisplay", Integer.TYPE);
                        kotlin.jvm.internal.o.f((Object)object2, (String)"getMethod(...)");
                        object2 = ((Method)object2).invoke(null, 0);
                        if (!(object2 instanceof List)) break block2;
                        list = (List)object2;
                    }
                    catch (Throwable throwable2) {
                        break block3;
                    }
                }
                return list;
            }
            j.a a2 = j.a;
            object = j.a((Object)k.a((Throwable)throwable2));
            if (!j.c((Object)object)) break block4;
            object = var2_1;
        }
        return (List)object;
    }

    public final String getISLAND_ANIM_DURATION_SCALE() {
        return ISLAND_ANIM_DURATION_SCALE;
    }

    public final int getNavigationBarFrameHeight() {
        int n;
        block3: {
            n = 0;
            Resources resources = Resources.getSystem();
            int n2 = resources.getIdentifier("navigation_bar_frame_height", "dimen", "android");
            if (n2 == 0) break block3;
            try {
                n = n2 = resources.getDimensionPixelSize(n2);
            }
            catch (Throwable throwable) {
                Log.e((String)TAG, (String)"get navigation_bar_frame_height failed.", (Throwable)throwable);
            }
        }
        return n;
    }

    public final int getScreenHeight(Context context) {
        kotlin.jvm.internal.o.g((Object)context, (String)"<this>");
        return this.getScreenHeightOld(context);
    }

    public final int getScreenHeightOld(Context context) {
        kotlin.jvm.internal.o.g((Object)context, (String)"context");
        return context.getResources().getDisplayMetrics().heightPixels;
    }

    public final int getScreenWidth(Context context) {
        kotlin.jvm.internal.o.g((Object)context, (String)"<this>");
        return this.getScreenWidthOld(context);
    }

    public final int getScreenWidthOld(Context context) {
        kotlin.jvm.internal.o.g((Object)context, (String)"context");
        WindowConfigurationCompat windowConfigurationCompat = WindowConfigurationCompat.INSTANCE;
        context = context.getResources().getConfiguration();
        kotlin.jvm.internal.o.f((Object)context, (String)"getConfiguration(...)");
        context = windowConfigurationCompat.getWindowConfigurationCompat((Configuration)context);
        if (context != null && (context = windowConfigurationCompat.getMaxBoundsCompat((WindowConfiguration)context)) != null) {
            return context.width() - tinyScreenInsetLeft - tinyScreenInsetRight;
        }
        return 0;
    }

    public final int getTinyScreenInsetBottom() {
        return tinyScreenInsetBottom;
    }

    public final int getTinyScreenInsetLeft() {
        return tinyScreenInsetLeft;
    }

    public final int getTinyScreenInsetRight() {
        return tinyScreenInsetRight;
    }

    public final int getTinyScreenInsetTop() {
        return tinyScreenInsetTop;
    }

    public final int getTraceCookie() {
        return traceCookie;
    }

    public final String getTraceName() {
        return traceName;
    }

    public final boolean isAppInstalledForUser(Context context, String string, Integer n) {
        kotlin.jvm.internal.o.g((Object)context, (String)"context");
        try {
            context = context.getPackageManager();
            kotlin.jvm.internal.o.d((Object)string);
            context.getPackageInfo(string, 1);
            return true;
        }
        catch (PackageManager.NameNotFoundException nameNotFoundException) {
            return false;
        }
    }

    public final boolean isBigOrDeletedOrHidden(DynamicIslandState dynamicIslandState) {
        kotlin.jvm.internal.o.g((Object)dynamicIslandState, (String)"<this>");
        boolean bl = dynamicIslandState instanceof DynamicIslandState.BigIsland || dynamicIslandState instanceof DynamicIslandState.Deleted || dynamicIslandState instanceof DynamicIslandState.Hidden;
        return bl;
    }

    public final boolean isDynamicIslandPadNoPropOnce(DynamicIslandData object) {
        kotlin.jvm.internal.o.g((Object)object, (String)"<this>");
        boolean bl = CommonUtils.INSTANCE.getIS_TABLET() && ((object = object.getProperties()) == null || (Integer)object != 0);
        return bl;
    }

    public final boolean isGlowEffectEnabledForBigState$miui_dynamicisland_release(DynamicIslandData object) {
        boolean bl = (object = object != null && (object = object.getExtras()) != null ? object.getString("miui.bigIsland.effect.src") : null) == null || object.length() == 0;
        return bl ^ true;
    }

    public final boolean isGlowEffectEnabledForExpandState$miui_dynamicisland_release(DynamicIslandData object) {
        boolean bl = (object = object != null && (object = object.getExtras()) != null ? object.getString("miui.effect.src") : null) == null || object.length() == 0;
        return bl ^ true;
    }

    public final String isIntentActivityExist(Context object, Intent object2, String string) {
        block6: {
            kotlin.jvm.internal.o.g((Object)object, (String)"context");
            kotlin.jvm.internal.o.g((Object)object2, (String)"intent");
            PackageManager packageManager = object.getPackageManager();
            object = string;
            if (packageManager == null) break block6;
            object2 = packageManager.queryIntentActivities((Intent)object2, 786432);
            object = string;
            if (object2 == null) break block6;
            object = string;
            if (object2.size() <= 0) break block6;
            object = object2.iterator();
            while (object.hasNext()) {
                if (!TextUtils.equals((CharSequence)((ResolveInfo)object.next()).activityInfo.packageName, (CharSequence)string)) continue;
                return string;
            }
            try {
                object = ((ResolveInfo)object2.get((int)0)).activityInfo.packageName;
            }
            catch (Exception exception) {
                Log.e((String)TAG, (String)"error get resolve info");
                object = string;
            }
        }
        return object;
    }

    public final boolean isInternationalBuild() {
        return isInternationalBuild;
    }

    public final boolean isPinMode(String string, Intent intent) {
        block6: {
            Object object = null;
            Object object2 = MiuiFreeFormManager.class.getMethod("hasMiuiFreeformOnShellFeature", null).invoke(null, null);
            kotlin.jvm.internal.o.e((Object)object2, (String)"null cannot be cast to non-null type kotlin.Boolean");
            boolean bl = (Boolean)object2;
            object2 = MiuiFreeFormManager.class.getMethod("getAllFreeFormStackInfosOnDisplay", Integer.TYPE);
            kotlin.jvm.internal.o.f((Object)object2, (String)"getMethod(...)");
            object2 = ((Method)object2).invoke(null, 0);
            if (object2 instanceof List) {
                object = (List)object2;
            }
            if (!bl || object == null) break block6;
            if (object.isEmpty() || intent == null) break block6;
            try {
                object = object.iterator();
                while (object.hasNext()) {
                    intent = (MiuiFreeFormManager.MiuiFreeFormStackInfo)object.next();
                    if (!TextUtils.equals((CharSequence)intent.packageName, (CharSequence)string) || !(bl = intent.inPinMode)) continue;
                    return true;
                }
            }
            catch (Exception exception) {
                Log.w((String)TAG, (String)"getAllFreeFormStackInfosOnDisplay");
                return false;
            }
        }
        return false;
    }

    public final boolean isSplitPkg(String string, Context object) {
        kotlin.jvm.internal.o.g((Object)object, (String)"context");
        boolean bl = ActivityManager.isInSplitScreenWindowingMode();
        object = this.getTopSplitPackageNames((Context)object);
        bl = bl && object != null && u.F((Iterable)object, (Object)string);
        return bl;
    }

    public final boolean packageSupportFreeform(Context object, String string) {
        kotlin.jvm.internal.o.g((Object)object, (String)"context");
        try {
            Method method = MiuiMultiWindowUtils.class.getDeclaredMethod("packageSupportFreeform", Context.class, String.class);
            kotlin.jvm.internal.o.f((Object)method, (String)"getDeclaredMethod(...)");
            ((AccessibleObject)method).setAccessible(true);
            object = method.invoke(null, object, string);
            kotlin.jvm.internal.o.e((Object)object, (String)"null cannot be cast to non-null type kotlin.Boolean");
            boolean bl = (Boolean)object;
            return bl;
        }
        catch (Exception exception) {
            exception.printStackTrace();
            return false;
        }
    }

    /*
     * WARNING - void declaration
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final JSONObject resolveFocusParam(StatusBarNotification object) {
        void var1_6;
        kotlin.jvm.internal.o.g((Object)object, (String)"sbn");
        Bundle bundle = object.getNotification().extras;
        String string = this.hasCustomFocusView((StatusBarNotification)object) ? "miui.focus.param.custom" : "miui.focus.param";
        String string2 = bundle.getString(string);
        bundle = null;
        string = bundle;
        if (string2 != null) {
            try {
                string = new JSONObject(string2);
            }
            catch (JSONException jSONException) {
                string = bundle;
            }
        }
        if (this.hasCustomFocusView((StatusBarNotification)object)) {
            String string3 = string;
            return var1_6;
        }
        String string4 = string;
        if (string == null) return var1_6;
        JSONObject jSONObject = string.optJSONObject("param_v2");
        if (jSONObject != null) return var1_6;
        String string5 = string;
        return var1_6;
    }

    public final void setCutoutBoundingRectTopWidth(int n) {
        cutoutBoundingRectTopWidth = n;
    }

    public final void setTinyScreenInsetBottom(int n) {
        tinyScreenInsetBottom = n;
    }

    public final void setTinyScreenInsetLeft(int n) {
        tinyScreenInsetLeft = n;
    }

    public final void setTinyScreenInsetRight(int n) {
        tinyScreenInsetRight = n;
    }

    public final void setTinyScreenInsetTop(int n) {
        tinyScreenInsetTop = n;
    }

    public final void updateBoundingRect(Context context) {
        kotlin.jvm.internal.o.g((Object)context, (String)"context");
        DisplayCutout displayCutout = context.getDisplay().getCutout();
        if (displayCutout != null && (displayCutout = displayCutout.getBoundingRectTop()) != null) {
            int n;
            String string;
            Object object;
            if (cutoutNeedWidenDeviceList == null) {
                cutoutNeedWidenDeviceList = context.getResources().getStringArray(R.array.cutout_need_widen_device_list);
            }
            if ((object = cutoutNeedWidenDeviceList) != null && i.w((Object[])object, (Object)(string = android.os.Build.DEVICE))) {
                object = new StringBuilder();
                ((StringBuilder)object).append("cutout of ");
                ((StringBuilder)object).append(string);
                ((StringBuilder)object).append(" need widen");
                Log.d((String)TAG, (String)((StringBuilder)object).toString());
                n = INSTANCE.dpToPx(4, context);
            } else {
                n = 0;
            }
            cutoutBoundingRectTopWidth = displayCutout.width() + n;
        }
    }

    public final void updateFlipOutInsetRight(Context context) {
        kotlin.jvm.internal.o.g((Object)context, (String)"context");
        boolean bl = CommonUtils.isFlipDevice();
        int n = 0;
        if (bl && CommonUtils.isTinyScreen((Context)context)) {
            Display display = context.getDisplay();
            int n2 = display != null && (display = display.getCutout()) != null ? display.getSafeInsetLeft() : 0;
            tinyScreenInsetLeft = n2;
            display = context.getDisplay();
            n2 = display != null && (display = display.getCutout()) != null ? display.getSafeInsetRight() : 0;
            tinyScreenInsetRight = n2;
            display = context.getDisplay();
            n2 = display != null && (display = display.getCutout()) != null ? display.getSafeInsetTop() : 0;
            tinyScreenInsetTop = n2;
            context = context.getDisplay();
            n2 = n;
            if (context != null) {
                context = context.getCutout();
                n2 = n;
                if (context != null) {
                    n2 = context.getSafeInsetBottom();
                }
            }
            tinyScreenInsetBottom = n2;
        } else {
            tinyScreenInsetLeft = 0;
            tinyScreenInsetRight = 0;
            tinyScreenInsetTop = 0;
            tinyScreenInsetBottom = 0;
        }
    }
}
