/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.animation.Animator
 *  android.animation.Animator$AnimatorListener
 *  android.app.ActivityManager
 *  android.app.Notification
 *  android.app.PendingIntent
 *  android.content.Context
 *  android.content.pm.PackageManager$NameNotFoundException
 *  android.graphics.drawable.Icon
 *  android.os.Bundle
 *  android.os.Parcelable
 *  android.os.RemoteException
 *  android.os.UserHandle
 *  android.service.notification.StatusBarNotification
 *  android.text.TextUtils
 *  android.util.Log
 *  android.util.Pair
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.ViewGroup
 *  android.view.ViewGroup$LayoutParams
 *  android.widget.FrameLayout
 *  android.widget.RemoteViews
 *  android.widget.RemoteViews$InteractionHandler
 *  android.widget.RemoteViews$RemoteResponse
 *  android.widget.TextView
 *  androidx.annotation.NonNull
 *  com.airbnb.lottie.LottieAnimationView
 *  com.android.systemui.miui.notification.R$dimen
 *  com.android.systemui.miui.notification.R$id
 *  com.android.systemui.miui.notification.R$layout
 *  com.android.systemui.plugins.ActivityStarter
 *  com.android.systemui.plugins.NotificationListenerController$NotificationProvider
 *  com.android.systemui.plugins.miui.notification.FocusNotificationContent
 *  d.H
 *  d.h
 *  d.p
 *  miui.systemui.controlcenter.data.repository.ControlCenterExpandRepository
 *  miui.systemui.notification.NotificationSettingsManager
 *  miui.systemui.notification.NotificationUtil
 *  miui.systemui.util.LottieResUtils
 *  miui.systemui.util.ReflectUtil
 *  miui.systemui.util.liveupdate.PromotedNotificationParamUtils
 *  org.json.JSONException
 *  org.json.JSONObject
 */
package miui.systemui.notification.focus;

import android.animation.Animator;
import android.app.ActivityManager;
import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.drawable.Icon;
import android.os.Bundle;
import android.os.Parcelable;
import android.os.RemoteException;
import android.os.UserHandle;
import android.service.notification.StatusBarNotification;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RemoteViews;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.airbnb.lottie.LottieAnimationView;
import com.android.systemui.miui.notification.R;
import com.android.systemui.plugins.ActivityStarter;
import com.android.systemui.plugins.NotificationListenerController;
import com.android.systemui.plugins.miui.notification.FocusNotificationContent;
import d.H;
import d.h;
import d.p;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.AbstractMap;
import java.util.HashMap;
import java.util.Map;
import miui.systemui.controlcenter.data.repository.ControlCenterExpandRepository;
import miui.systemui.notification.NotificationSettingsManager;
import miui.systemui.notification.NotificationUtil;
import miui.systemui.notification.focus.FocusNotifUtils;
import miui.systemui.notification.focus.FocusParamsException;
import miui.systemui.notification.focus.InflateAndAuthCallBack;
import miui.systemui.notification.focus.a;
import miui.systemui.notification.focus.b;
import miui.systemui.notification.focus.moduleV3.ext.ModuleViewHolderExtKt;
import miui.systemui.notification.focus.template.FocusTemplate;
import miui.systemui.notification.focus.template.FocusTemplateKt;
import miui.systemui.notification.focus.templateV3.TemplateFactoryV3;
import miui.systemui.util.LottieResUtils;
import miui.systemui.util.ReflectUtil;
import miui.systemui.util.liveupdate.PromotedNotificationParamUtils;
import org.json.JSONException;
import org.json.JSONObject;

public class FocusNotifPreHandler {
    private static final String TAG = "FocusNotifPreHandler";
    private final ActivityStarter mActivityStarter;
    private final ControlCenterExpandRepository mCenterExpandRepository;
    private final FocusNotifUtils mFocusNotifUtils;
    private NotificationSettingsManager mNotificationSettingsManager;
    private final TemplateFactoryV3 mTemplateFactoryV3;
    private Context pluginContext;

    public FocusNotifPreHandler(NotificationSettingsManager notificationSettingsManager, Context context, ActivityStarter activityStarter, TemplateFactoryV3 templateFactoryV3, FocusNotifUtils focusNotifUtils, ControlCenterExpandRepository controlCenterExpandRepository) {
        this.mNotificationSettingsManager = notificationSettingsManager;
        this.pluginContext = context;
        this.mActivityStarter = activityStarter;
        this.mTemplateFactoryV3 = templateFactoryV3;
        this.mFocusNotifUtils = focusNotifUtils;
        this.mCenterExpandRepository = controlCenterExpandRepository;
    }

    public static /* synthetic */ boolean a(FocusNotifPreHandler focusNotifPreHandler, View view, PendingIntent pendingIntent, RemoteViews.RemoteResponse remoteResponse) {
        return focusNotifPreHandler.lambda$createInteractionHandler$0(view, pendingIntent, remoteResponse);
    }

    private void addFaceRecognitionLottie(Context context, StatusBarNotification statusBarNotification, View object, int n, String string, NotificationListenerController.NotificationProvider notificationProvider) {
        if (object == null) {
            return;
        }
        if (!((object = object.findViewById(n)) instanceof ViewGroup)) {
            return;
        }
        object = (ViewGroup)object;
        object.removeAllViews();
        LayoutInflater layoutInflater = LayoutInflater.from((Context)context);
        n = R.layout.focus_notification_module_face_recognition;
        Object var7_9 = null;
        View view = layoutInflater.inflate(n, null);
        layoutInflater = context.getResources();
        n = R.dimen.focus_notify_face_recognition_width;
        object.addView(view, new ViewGroup.LayoutParams(layoutInflater.getDimensionPixelSize(n), context.getResources().getDimensionPixelSize(n)));
        layoutInflater = (LottieAnimationView)view.findViewById(R.id.focus_animation);
        object = var7_9;
        if (statusBarNotification != null) {
            try {
                object = context.getPackageManager().getApplicationLabel(context.getPackageManager().getApplicationInfo(statusBarNotification.getPackageName(), 0));
            }
            catch (Exception exception) {
                Log.d((String)TAG, (String)"Get application label error", (Throwable)exception);
                object = var7_9;
            }
        }
        if (!TextUtils.isEmpty((CharSequence)object)) {
            layoutInflater.setContentDescription((CharSequence)object);
        }
        this.playAnimation(context, statusBarNotification, string, (LottieAnimationView)layoutInflater, notificationProvider);
    }

    private View applyInteractionHandler(RemoteViews remoteViews, Context context, ViewGroup viewGroup) {
        try {
            Object object = this.createInteractionHandler(RemoteViews.InteractionHandler.class);
            remoteViews = (View)ReflectUtil.callObjectMethod((Object)remoteViews, View.class, (String)"apply", (Class[])new Class[]{Context.class, ViewGroup.class, RemoteViews.InteractionHandler.class}, (Object[])new Object[]{context, viewGroup, object});
            return remoteViews;
        }
        catch (Exception exception) {
            Log.e((String)TAG, (String)"error get method RemoteViews.apply");
            return null;
        }
    }

    public static /* synthetic */ Object b(FocusNotifPreHandler focusNotifPreHandler, Object object, Method method, Object[] objectArray) {
        return focusNotifPreHandler.lambda$createInteractionHandler$1(object, method, objectArray);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private boolean buildNoParamsFocusNotification(StatusBarNotification statusBarNotification, String charSequence, Context context, Context context2, FocusNotificationContent focusNotificationContent, InflateAndAuthCallBack inflateAndAuthCallBack, NotificationListenerController.NotificationProvider notificationProvider) {
        if (!this.mFocusNotifUtils.hasCustomFocusView(statusBarNotification)) {
            return false;
        }
        Notification notification = statusBarNotification.getNotification();
        Bundle bundle = notification.extras;
        JSONObject jSONObject = this.mFocusNotifUtils.parseFocusParam(context2, statusBarNotification, "miui.focus.param.custom", focusNotificationContent);
        if (this.canRemoveFocusNotification(jSONObject, statusBarNotification, notificationProvider, "remove custom focus notification")) {
            return true;
        }
        boolean bl = jSONObject != null && jSONObject.optBoolean("filterWhenNoPermission", false);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("RemoteViews isSkipWhenNoFocusPermission: ");
        stringBuilder.append(bl);
        NotificationUtil.debugLog((String)TAG, (String)stringBuilder.toString());
        if (!this.mFocusNotifUtils.canShowFocus(context, (String)charSequence, statusBarNotification.getUser().getIdentifier())) {
            Log.e((String)TAG, (String)"the app can not show focus notification");
            this.mFocusNotifUtils.resetAllParam(bundle);
            statusBarNotification.getNotification().extras.putBoolean("filterWhenNoPermission", bl);
            return bl;
        }
        try {
            this.createCustomView(statusBarNotification, context2, context, focusNotificationContent, jSONObject, notificationProvider);
        }
        catch (Exception exception) {
            charSequence = new StringBuilder();
            ((StringBuilder)charSequence).append("createCustomView has some exception: ");
            ((StringBuilder)charSequence).append(exception.getMessage());
            Log.e((String)TAG, (String)((StringBuilder)charSequence).toString());
            inflateAndAuthCallBack.onInflateFailed(statusBarNotification.getKey(), focusNotificationContent);
            return false;
        }
        bundle.putBoolean("miui.customHideBorder", true);
        this.fillCustomViewNotifiParams(statusBarNotification, context, jSONObject, notification, bundle);
        inflateAndAuthCallBack.onInflateSuccess(statusBarNotification.getKey(), focusNotificationContent);
        return false;
    }

    private boolean buildParamsFocusNotification(StatusBarNotification statusBarNotification, JSONObject jSONObject, Context context, Context context2, String string, boolean bl, FocusNotificationContent focusNotificationContent, InflateAndAuthCallBack inflateAndAuthCallBack, NotificationListenerController.NotificationProvider notificationProvider) {
        boolean bl2 = jSONObject.optBoolean("filterWhenNoPermission", false);
        JSONObject jSONObject2 = jSONObject.optJSONObject("param_v2");
        if (jSONObject2 != null) {
            bl2 = jSONObject2.optBoolean("filterWhenNoPermission", false);
        }
        if (this.isNoPermission(context2, statusBarNotification.getNotification().extras, jSONObject, string, statusBarNotification.getUser().getIdentifier())) {
            statusBarNotification.getNotification().extras.putBoolean("filterWhenNoPermission", bl2);
            return bl2;
        }
        return this.fillParamsFocusNotification(context2, context, statusBarNotification, jSONObject, bl, bl2, focusNotificationContent, inflateAndAuthCallBack, notificationProvider);
    }

    public static /* bridge */ /* synthetic */ void c(FocusNotifPreHandler focusNotifPreHandler, StatusBarNotification statusBarNotification, String string, LottieAnimationView lottieAnimationView, NotificationListenerController.NotificationProvider notificationProvider) {
        focusNotifPreHandler.clearFaceRecognition(statusBarNotification, string, lottieAnimationView, notificationProvider);
    }

    private boolean canRemoveFocusNotification(JSONObject jSONObject, StatusBarNotification statusBarNotification, NotificationListenerController.NotificationProvider notificationProvider, String string) {
        boolean bl;
        boolean bl2 = bl = false;
        if (jSONObject != null) {
            bl2 = bl;
            if (jSONObject.optBoolean("cancel", false)) {
                Log.e((String)TAG, (String)string);
                notificationProvider.removeNotification(statusBarNotification);
                bl2 = true;
            }
        }
        return bl2;
    }

    private void clearFaceRecognition(StatusBarNotification statusBarNotification, String string, LottieAnimationView lottieAnimationView, NotificationListenerController.NotificationProvider notificationProvider) {
        if (string.equals("face_recognition_success") || string.equals("face_recognition_failed")) {
            LottieResUtils.INSTANCE.cancelLottieAnimate(lottieAnimationView, false);
            notificationProvider.removeNotification(statusBarNotification);
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void createCustomView(StatusBarNotification object, Context context, Context object2, FocusNotificationContent focusNotificationContent, JSONObject jSONObject, NotificationListenerController.NotificationProvider object3) {
        JSONException jSONException2;
        block19: {
            TextView textView;
            boolean bl;
            String string;
            View view;
            FrameLayout frameLayout;
            Context context2;
            RemoteViews remoteViews;
            RemoteViews remoteViews2;
            block18: {
                remoteViews2 = (RemoteViews)object.getNotification().extras.getParcelable("miui.focus.rv");
                remoteViews = (RemoteViews)object.getNotification().extras.getParcelable("miui.focus.rv.island.expand");
                if (remoteViews == null) {
                    if (remoteViews2 == null) throw new FocusParamsException("remoteviews is null");
                }
                context2 = remoteViews != null ? this.getRemoteViewsContext((Context)object2, remoteViews) : this.getRemoteViewsContext((Context)object2, remoteViews2);
                frameLayout = new FrameLayout(context2);
                context2 = remoteViews != null ? this.applyInteractionHandler(remoteViews, context, (ViewGroup)frameLayout) : this.applyInteractionHandler(remoteViews2, context, (ViewGroup)frameLayout);
                view = remoteViews != null ? this.applyInteractionHandler(remoteViews, context, (ViewGroup)frameLayout) : this.applyInteractionHandler(remoteViews2, context, (ViewGroup)frameLayout);
                if (jSONObject != null) {
                    try {
                        if (!"face_recognition".equals(jSONObject.optString("scene"))) break block18;
                        int n = object.getNotification().extras.getInt("face_id");
                        string = jSONObject.getString("face_type");
                        context2.getLayoutParams().width = -2;
                        view.getLayoutParams().width = -2;
                        this.addFaceRecognitionLottie((Context)object2, (StatusBarNotification)object, (View)context2, n, string, (NotificationListenerController.NotificationProvider)object3);
                    }
                    catch (JSONException jSONException2) {
                        break block19;
                    }
                }
            }
            if ((bl = object.getNotification().extras.containsKey("effect_id")) && object.getNotification().extras.containsKey("effect_type")) {
                Log.d((String)TAG, (String)"handle custom shader");
                string = new FrameLayout(object2);
                object3 = context2.getLayoutParams() != null ? new ViewGroup.LayoutParams(context2.getLayoutParams().width, context2.getLayoutParams().height) : null;
                textView = new TextView(object2);
                if (object3 != null) {
                    string.setLayoutParams((ViewGroup.LayoutParams)object3);
                }
                string.addView((View)textView);
                string.addView((View)context2);
                focusNotificationContent.setIslandExpandedView((View)string);
                string.setTag(R.id.custom_view_shader_id, (Object)object.getNotification().extras.getInt("effect_id"));
                string.setTag(R.id.custom_view_shader_type, (Object)object.getNotification().extras.getString("effect_type"));
                focusNotificationContent.setIslandExpandedView((View)string);
                object3 = new FrameLayout(object2);
                object2 = context2.getLayoutParams() != null ? new ViewGroup.LayoutParams(context2.getLayoutParams().width, context2.getLayoutParams().height) : null;
                if (object2 != null) {
                    object3.setLayoutParams((ViewGroup.LayoutParams)object2);
                }
                object3.addView(view);
                focusNotificationContent.setIslandExpandedViewFake((View)object3);
            } else {
                focusNotificationContent.setIslandExpandedView((View)context2);
                focusNotificationContent.setIslandExpandedViewFake(view);
            }
            object.getNotification().extras.putBoolean("miui.focus.isFocus", true);
            if (jSONObject != null && !jSONObject.optBoolean("isShowNotification", true)) {
                focusNotificationContent.setFocusNotification(null);
                focusNotificationContent.setFocusNotificationDark(null);
                focusNotificationContent.setFocusNotificationModal(null);
                focusNotificationContent.setFocusNotificationDarkModal(null);
                focusNotificationContent.setTinyView(null);
                focusNotificationContent.setTinyViewDark(null);
                focusNotificationContent.setDeco(null);
                focusNotificationContent.setDecoDark(null);
                focusNotificationContent.setDecoLand(null);
                focusNotificationContent.setDecoLandDark(null);
                focusNotificationContent.setTinyKeyguardView(null);
                focusNotificationContent.setTinyViewKeyguardDark(null);
                try {
                    if (focusNotificationContent.getFocusNotificationViewMap() != null) {
                        focusNotificationContent.getFocusNotificationViewMap().clear();
                    }
                    focusNotificationContent.setFocusNotificationViewMap(null);
                    return;
                }
                catch (Throwable throwable) {
                    Log.e((String)TAG, (String)"getFocusNotificationViewMap error");
                }
                return;
            }
            string = (RemoteViews)object.getNotification().extras.getParcelable("miui.focus.rvNight");
            textView = (RemoteViews)object.getNotification().extras.getParcelable("miui.focus.rv.fullAod");
            object2 = object.getNotification().extras.getParcelable("miui.focus.rv.tiny") != null ? (RemoteViews)object.getNotification().extras.getParcelable("miui.focus.rv.tiny") : remoteViews2;
            jSONObject = object.getNotification().extras.getParcelable("miui.focus.rv.tinyNight") != null ? (RemoteViews)object.getNotification().extras.getParcelable("miui.focus.rv.tinyNight") : remoteViews;
            remoteViews = (RemoteViews)object.getNotification().extras.getParcelable("miui.focus.rv.deco.port");
            view = (RemoteViews)object.getNotification().extras.getParcelable("miui.focus.rv.deco.port.night");
            object3 = (RemoteViews)object.getNotification().extras.getParcelable("miui.focus.rv.deco.land");
            context2 = (RemoteViews)object.getNotification().extras.getParcelable("miui.focus.rv.deco.land.night");
            if (remoteViews2 == null) {
                return;
            }
            focusNotificationContent.setFocusNotification(this.applyInteractionHandler(remoteViews2, context, (ViewGroup)frameLayout));
            object = string != null ? this.applyInteractionHandler((RemoteViews)string, context, (ViewGroup)frameLayout) : this.applyInteractionHandler(remoteViews2, context, (ViewGroup)frameLayout);
            focusNotificationContent.setFocusNotificationDark((View)object);
            try {
                if (focusNotificationContent.getFocusNotificationViewMap() == null) {
                    object = new HashMap();
                    focusNotificationContent.setFocusNotificationViewMap((Map)object);
                }
                Map map = focusNotificationContent.getFocusNotificationViewMap();
                object = textView != null ? this.applyInteractionHandler((RemoteViews)textView, context, (ViewGroup)frameLayout) : this.applyInteractionHandler(remoteViews2, context, (ViewGroup)frameLayout);
                map.put("miui.focus.rv.fullAod", object);
            }
            catch (Throwable throwable) {
                Log.e((String)TAG, (String)"getFocusNotificationViewMap error");
            }
            focusNotificationContent.setFocusNotificationModal(this.applyInteractionHandler(remoteViews2, context, (ViewGroup)frameLayout));
            object = string != null ? this.applyInteractionHandler((RemoteViews)string, context, (ViewGroup)frameLayout) : this.applyInteractionHandler(remoteViews2, context, (ViewGroup)frameLayout);
            focusNotificationContent.setFocusNotificationDarkModal((View)object);
            if (object2 == null) {
                return;
            }
            focusNotificationContent.setTinyView(this.applyInteractionHandler((RemoteViews)object2, context, (ViewGroup)frameLayout));
            object = jSONObject != null ? this.applyInteractionHandler((RemoteViews)jSONObject, context, (ViewGroup)frameLayout) : this.applyInteractionHandler((RemoteViews)object2, context, (ViewGroup)frameLayout);
            focusNotificationContent.setTinyViewDark((View)object);
            focusNotificationContent.setTinyViewModal(this.applyInteractionHandler((RemoteViews)object2, context, (ViewGroup)frameLayout));
            object = jSONObject != null ? this.applyInteractionHandler((RemoteViews)jSONObject, context, (ViewGroup)frameLayout) : this.applyInteractionHandler((RemoteViews)object2, context, (ViewGroup)frameLayout);
            focusNotificationContent.setTinyViewDarkModal((View)object);
            focusNotificationContent.setTinyKeyguardView(this.applyInteractionHandler((RemoteViews)object2, context, (ViewGroup)frameLayout));
            object = jSONObject != null ? this.applyInteractionHandler((RemoteViews)jSONObject, context, (ViewGroup)frameLayout) : this.applyInteractionHandler((RemoteViews)object2, context, (ViewGroup)frameLayout);
            focusNotificationContent.setTinyViewKeyguardDark((View)object);
            if (remoteViews == null) return;
            if (object3 == null) {
                return;
            }
            focusNotificationContent.setDeco(this.applyInteractionHandler(remoteViews, context, (ViewGroup)frameLayout));
            object = view != null ? this.applyInteractionHandler((RemoteViews)view, context, (ViewGroup)frameLayout) : this.applyInteractionHandler(remoteViews, context, (ViewGroup)frameLayout);
            focusNotificationContent.setDecoDark((View)object);
            focusNotificationContent.setDecoLand(this.applyInteractionHandler((RemoteViews)object3, context, (ViewGroup)frameLayout));
            object = context2 != null ? this.applyInteractionHandler((RemoteViews)context2, context, (ViewGroup)frameLayout) : this.applyInteractionHandler((RemoteViews)object3, context, (ViewGroup)frameLayout);
            focusNotificationContent.setDecoLandDark((View)object);
            return;
        }
        object = new StringBuilder();
        ((StringBuilder)object).append("json exception: ");
        ((StringBuilder)object).append(jSONException2.getMessage());
        throw new FocusParamsException(((StringBuilder)object).toString());
    }

    private Object createInteractionHandler(Class<?> clazz) {
        ClassLoader classLoader = clazz.getClassLoader();
        a a2 = new a(this);
        return Proxy.newProxyInstance(classLoader, new Class[]{clazz}, a2);
    }

    private void fillCustomViewNotifiParams(StatusBarNotification statusBarNotification, Context object, JSONObject jSONObject, Notification notification, Bundle bundle) {
        if (jSONObject == null) {
            return;
        }
        boolean bl = (notification.flags & 0x10) != 0;
        this.handleAodAndStatusBar(notification, (Context)object, jSONObject);
        int n = jSONObject.optInt("timeout", 720);
        long l = n < 0 ? 5000L : 60000L * (long)n;
        boolean bl2 = jSONObject.optBoolean("enableFloat", false);
        boolean bl3 = jSONObject.optBoolean("islandFirstFloat", true);
        boolean bl4 = jSONObject.optBoolean("updatable", false);
        object = jSONObject.optString("outEffectSrc");
        String string = jSONObject.optString("reopen", "close");
        bundle.putBoolean("miui.enableFloat", bl2);
        bundle.putBoolean("miui.island.firstFloat", bl3);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("timeoutMs: ");
        stringBuilder.append(n);
        stringBuilder.append(" ");
        stringBuilder.append(l);
        stringBuilder.append("ms, ,enableFloat: ");
        stringBuilder.append(bl2);
        stringBuilder.append(", updatable: ");
        stringBuilder.append(bl4);
        stringBuilder.append(",reopen: ");
        stringBuilder.append(string);
        stringBuilder.append(",islandFirstFloat:");
        stringBuilder.append(bl3);
        NotificationUtil.debugLog((String)TAG, (String)stringBuilder.toString());
        bundle.putLong("miui.timeout", l);
        bundle.putString("miui.effect.src", (String)object);
        bundle.putBoolean("show_notification", jSONObject.optBoolean("isShowNotification", true));
        if (bl4) {
            bundle.putString("miui.focus.reopen", string);
            bundle.putBoolean("miui.focus.enableAlert", bl2);
            notification.flags &= 0xFFFFFFEF;
        } else {
            bundle.remove("miui.focus.reopen");
            notification.flags |= 0x10;
        }
        if (PromotedNotificationParamUtils.isNotificationPromotedOngoing((StatusBarNotification)statusBarNotification)) {
            notification.flags = bl ? (notification.flags |= 0x10) : (notification.flags &= 0xFFFFFFEF);
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private boolean fillParamsFocusNotification(Context object, Context object2, StatusBarNotification statusBarNotification, JSONObject object3, boolean bl, boolean bl2, FocusNotificationContent focusNotificationContent, InflateAndAuthCallBack inflateAndAuthCallBack, NotificationListenerController.NotificationProvider notificationProvider) {
        Exception exception2;
        block16: {
            if (object3 == null) {
                return true;
            }
            JSONObject jSONObject = object3.optJSONObject("param_v2");
            JSONObject jSONObject2 = object3.optJSONObject("param_voip_v2");
            if (jSONObject != null) {
                object3 = jSONObject;
            } else if (jSONObject2 != null) {
                object3 = jSONObject2;
            }
            if (object3.has("sequence")) {
                Long l = this.mFocusNotifUtils.getMaxSeq().getOrDefault(statusBarNotification.getKey(), Long.MIN_VALUE);
                long l2 = object3.optLong("sequence", Long.MIN_VALUE);
                if (l2 <= l) {
                    object = new StringBuilder();
                    ((StringBuilder)object).append("filterOut old ");
                    ((StringBuilder)object).append(statusBarNotification.getKey());
                    ((StringBuilder)object).append(", ");
                    ((StringBuilder)object).append(l2);
                    ((StringBuilder)object).append("<");
                    ((StringBuilder)object).append(l);
                    Log.w((String)TAG, (String)((StringBuilder)object).toString());
                    return true;
                }
                ((AbstractMap)this.mFocusNotifUtils.getMaxSeq()).put(statusBarNotification.getKey(), l2);
            }
            if (jSONObject == null && jSONObject2 == null) {
                block15: {
                    block14: {
                        try {
                            if (this.canRemoveFocusNotification((JSONObject)object3, statusBarNotification, notificationProvider, "remove focus notification v1")) {
                                return true;
                            }
                            object2 = FocusTemplateKt.covert((JSONObject)object3, bl);
                            if (!this.mFocusNotifUtils.getOS1Template().containsKey(statusBarNotification.getKey())) break block14;
                            if (!this.isSameSceneOrPic((FocusTemplate)object2, this.mFocusNotifUtils.getOS1Template().get(statusBarNotification.getKey()))) {
                                focusNotificationContent.reset();
                            }
                            break block15;
                        }
                        catch (Exception exception2) {
                            break block16;
                        }
                    }
                    focusNotificationContent.reset();
                }
                this.mFocusNotifUtils.getOS1Template().put(statusBarNotification.getKey(), (FocusTemplate)object2);
                if (object2 == null) return false;
                object3 = new StringBuilder();
                ((StringBuilder)object3).append("focusScene=");
                ((StringBuilder)object3).append(object2);
                NotificationUtil.debugLog((String)TAG, (String)((StringBuilder)object3).toString());
                if (((FocusTemplate)object2).bgPicDownloadFail(statusBarNotification.getNotification().extras.getBundle("miui.focus.pics"))) {
                    Log.e((String)TAG, (String)"bgPicDownloadFail filterOut");
                    return true;
                }
                ((FocusTemplate)object2).wrapNotification((Context)object, statusBarNotification, focusNotificationContent);
                inflateAndAuthCallBack.onInflateSuccess(statusBarNotification.getKey(), focusNotificationContent);
                inflateAndAuthCallBack.onInflateFinish(statusBarNotification.getKey(), focusNotificationContent);
                return false;
            }
            if (this.canRemoveFocusNotification((JSONObject)object3, statusBarNotification, notificationProvider, "remove focus notification v2")) {
                return true;
            }
            this.mTemplateFactoryV3.createTemplate((Context)object, (Context)object2, (JSONObject)object3, statusBarNotification, bl, focusNotificationContent, inflateAndAuthCallBack);
            return false;
        }
        exception2.printStackTrace();
        Log.e((String)TAG, (String)"error focusScene=", (Throwable)exception2);
        inflateAndAuthCallBack.onInflateFailed(statusBarNotification.getKey(), focusNotificationContent);
        return false;
    }

    private Context getRemoteViewsContext(Context context, RemoteViews remoteViews) {
        remoteViews = remoteViews.mApplication;
        if (remoteViews != null) {
            String string = context.getPackageName();
            String string2 = remoteViews.packageName;
            int n = context.getUserId();
            int n2 = UserHandle.getUserId((int)remoteViews.uid);
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("packageName: ");
            stringBuilder.append(string);
            stringBuilder.append(", applicationPackageName: ");
            stringBuilder.append(string2);
            stringBuilder.append(", packageUserId: ");
            stringBuilder.append(n);
            stringBuilder.append(", applicationUserId: ");
            stringBuilder.append(n2);
            Log.i((String)TAG, (String)stringBuilder.toString());
            if (n == n2 && TextUtils.equals((CharSequence)string, (CharSequence)string2)) {
                return context;
            }
            try {
                string2 = remoteViews.packageName;
                stringBuilder = new UserHandle(n2);
                context = context.createPackageContextAsUser(string2, 4, (UserHandle)stringBuilder);
                return context;
            }
            catch (PackageManager.NameNotFoundException nameNotFoundException) {
                StringBuilder stringBuilder2 = new StringBuilder();
                stringBuilder2.append("Package name ");
                stringBuilder2.append(remoteViews.packageName);
                stringBuilder2.append(" not found");
                Log.e((String)TAG, (String)stringBuilder2.toString());
                throw new FocusParamsException("cann`t create package context");
            }
        }
        throw new FocusParamsException("cann`t get application info");
    }

    private void handleAodAndStatusBar(Notification notification, Context context, JSONObject object) {
        String string = object.optString("ticker");
        String string2 = object.optString("tickerPic");
        String string3 = object.optString("tickerPicDark");
        String string4 = object.optString("aodTitle");
        notification.extras.putString("miui.focus.ticker", string);
        notification.extras.putString("miui.focus.pic_ticker", string2);
        notification.extras.putString("miui.focus.pic_ticker_dark", string3);
        context = new RemoteViews(context.getPackageName(), R.layout.focus_notification_template_aod_v2);
        if (string4 != null && !string4.isEmpty()) {
            int n = R.id.focus_aod_title;
            context.setViewVisibility(n, 0);
            context.setTextViewText(n, (CharSequence)string4);
            n = R.id.focus_aod_icon;
            context.setViewVisibility(n, 0);
            string4 = notification.extras.getBundle("miui.focus.pics");
            object = object.optString("aodPic");
            if (string4 != null && object != null && !((String)object).isEmpty()) {
                context.setImageViewIcon(n, (Icon)string4.getParcelable((String)object));
            } else {
                notification.extras.putInt("miui.focus.aodIconId", n);
            }
            notification.extras.putParcelable("miui.focus.rvAod", (Parcelable)context);
        }
    }

    private void handleNullParam(StatusBarNotification statusBarNotification, String string, boolean bl) {
        Bundle bundle = statusBarNotification.getNotification().extras;
        if (!this.mNotificationSettingsManager.canCustomFocus(string)) {
            this.mFocusNotifUtils.resetAllParam(bundle);
        } else if (this.mFocusNotifUtils.hasCustomFocusView(statusBarNotification)) {
            if (bl) {
                bundle.putBoolean("miui.customHideBorder", true);
            } else {
                this.mFocusNotifUtils.resetAllParam(bundle);
            }
        }
    }

    private void handleProgressStyle(Context context, Bundle bundle, StatusBarNotification statusBarNotification, boolean bl) {
    }

    private boolean handleRemoteViewClick(View view, PendingIntent pendingIntent, ClickHandler clickHandler) {
        if (pendingIntent.isActivity()) {
            this.mActivityStarter.postStartActivityDismissingKeyguard(pendingIntent.getIntent(), 0);
            ModuleViewHolderExtKt.sendCollapseBroadcast(view.getContext());
            return true;
        }
        return clickHandler.handleClick();
    }

    private boolean isNoPermission(Context context, Bundle bundle, JSONObject jSONObject, String string, int n) {
        if (!this.mFocusNotifUtils.canShowFocus(context, string, n)) {
            this.mFocusNotifUtils.resetAllParam(bundle);
            if (jSONObject.optBoolean("updatable", false) || jSONObject.optString("scene", "").equals("foodDelivery") || jSONObject.optString("scene", "").equals("carHailing")) {
                bundle.putBoolean("miui.focus.enableAlert", false);
            }
            return true;
        }
        return false;
    }

    private boolean isSameSceneOrPic(FocusTemplate focusTemplate, FocusTemplate focusTemplate2) {
        boolean bl;
        boolean bl2 = bl = false;
        if (focusTemplate != null) {
            if (focusTemplate2 == null) {
                bl2 = bl;
            } else {
                Object object = focusTemplate.getParam();
                Object object2 = focusTemplate2.getParam();
                bl2 = bl;
                if (object != null) {
                    if (object2 == null) {
                        bl2 = bl;
                    } else {
                        bl2 = object.has("profilePicture");
                        if (bl2 != object2.has("profilePicture")) {
                            return false;
                        }
                        if (bl2) {
                            object = object.optString("profilePicture", null);
                            object2 = object2.optString("profilePicture", null);
                            if (!TextUtils.isEmpty((CharSequence)object) && !TextUtils.isEmpty((CharSequence)object2)) {
                                if (!((String)object).equals(object2)) {
                                    return false;
                                }
                            } else {
                                return TextUtils.equals((CharSequence)object, (CharSequence)object2);
                            }
                        }
                        bl2 = focusTemplate.getClass().equals(focusTemplate2.getClass());
                    }
                }
            }
        }
        return bl2;
    }

    private /* synthetic */ boolean lambda$createInteractionHandler$0(View view, PendingIntent object, RemoteViews.RemoteResponse remoteResponse) {
        boolean bl = this.startPendingIntent(view, (PendingIntent)object, remoteResponse);
        boolean bl2 = (Boolean)this.mCenterExpandRepository.getAppearance().getValue();
        object = new StringBuilder();
        ((StringBuilder)object).append("Focus notification remote view PendingIntent started: ");
        ((StringBuilder)object).append(bl);
        ((StringBuilder)object).append(" ,appearance: ");
        ((StringBuilder)object).append(bl2);
        ((StringBuilder)object).append(", clicked view: ");
        ((StringBuilder)object).append(view);
        Log.d((String)TAG, (String)((StringBuilder)object).toString());
        if (bl2) {
            try {
                Runtime.getRuntime().exec("cmd statusbar collapse");
            }
            catch (Exception exception) {
                Log.e((String)TAG, (String)"createInteractionHandler: ", (Throwable)exception);
            }
        }
        return bl;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private /* synthetic */ Object lambda$createInteractionHandler$1(Object object, Method method, Object[] objectArray) {
        if (!"onInteraction".equals(method.getName())) {
            object = new StringBuilder();
            ((StringBuilder)object).append("Unsupported method creating interaction handler: ");
            ((StringBuilder)object).append(method.getName());
            throw new UnsupportedOperationException(((StringBuilder)object).toString());
        }
        method = (View)objectArray[0];
        object = (PendingIntent)objectArray[1];
        RemoteViews.RemoteResponse remoteResponse = (RemoteViews.RemoteResponse)objectArray[2];
        Log.i((String)TAG, (String)"focus remoteview handles interaction");
        try {
            ActivityManager.getService().resumeAppSwitches();
        }
        catch (RemoteException remoteException) {}
        boolean bl = this.handleRemoteViewClick((View)method, (PendingIntent)object, new b(this, (View)method, (PendingIntent)object, remoteResponse));
        object = new StringBuilder();
        ((StringBuilder)object).append("Focus notification remote view interaction handled: ");
        ((StringBuilder)object).append(bl);
        Log.d((String)TAG, (String)((StringBuilder)object).toString());
        return bl;
    }

    private void playAnimation(Context context, StatusBarNotification statusBarNotification, String string, LottieAnimationView lottieAnimationView, NotificationListenerController.NotificationProvider notificationProvider) {
        if (lottieAnimationView == null) {
            return;
        }
        p.s((Context)context, (int)LottieResUtils.INSTANCE.getLottieRes(string, -1)).d(new H(){
            final String val$type;
            final LottieAnimationView val$view;
            {
                this.val$view = lottieAnimationView;
                this.val$type = string;
            }

            public void onResult(h h2) {
                this.val$view.setComposition(h2);
                if (this.val$type.equals("face_recognition")) {
                    this.val$view.setRepeatCount(-1);
                    this.val$view.setRepeatMode(1);
                } else {
                    this.val$view.setRepeatCount(0);
                }
                this.val$view.setProgress(0.0f);
            }
        });
        lottieAnimationView.playAnimation();
        if (string.equals("face_recognition_success") || string.equals("face_recognition_failed")) {
            lottieAnimationView.addAnimatorListener(new Animator.AnimatorListener(){
                final FocusNotifPreHandler this$0;
                final NotificationListenerController.NotificationProvider val$provider;
                final StatusBarNotification val$sbn;
                final String val$type;
                final LottieAnimationView val$view;
                {
                    this.this$0 = focusNotifPreHandler;
                    this.val$sbn = statusBarNotification;
                    this.val$type = string;
                    this.val$view = lottieAnimationView;
                    this.val$provider = notificationProvider;
                }

                public void onAnimationCancel(@NonNull Animator animator) {
                    FocusNotifPreHandler.c(this.this$0, this.val$sbn, this.val$type, this.val$view, this.val$provider);
                }

                public void onAnimationEnd(@NonNull Animator animator) {
                    FocusNotifPreHandler.c(this.this$0, this.val$sbn, this.val$type, this.val$view, this.val$provider);
                }

                public void onAnimationRepeat(@NonNull Animator animator) {
                }

                public void onAnimationStart(@NonNull Animator animator) {
                }
            });
        }
    }

    private boolean startPendingIntent(View view, PendingIntent pendingIntent, RemoteViews.RemoteResponse remoteResponse) {
        try {
            remoteResponse = (Pair)ReflectUtil.callObjectMethod((Object)remoteResponse, Pair.class, (String)"getLaunchOptions", (Class[])new Class[]{View.class}, (Object[])new Object[]{view});
            boolean bl = (Boolean)ReflectUtil.callStaticObjectMethod(Class.forName("android.widget.RemoteViews"), Boolean.class, (String)"startPendingIntent", (Class[])new Class[]{View.class, PendingIntent.class, Pair.class}, (Object[])new Object[]{view, pendingIntent, remoteResponse});
            return bl;
        }
        catch (Exception exception) {
            Log.e((String)TAG, (String)"error FocusNotif startPendingIntent ");
            exception.printStackTrace();
            return false;
        }
    }

    public boolean onNotificationPosted(StatusBarNotification statusBarNotification, boolean bl, Context context, Context context2, FocusNotificationContent focusNotificationContent, InflateAndAuthCallBack inflateAndAuthCallBack, NotificationListenerController.NotificationProvider notificationProvider) {
        CharSequence charSequence = new StringBuilder();
        charSequence.append("plugin preHandleFocusNotification ");
        charSequence.append(statusBarNotification.getKey());
        NotificationUtil.debugLog((String)TAG, (String)charSequence.toString());
        if (!this.mFocusNotifUtils.isSupportFocusNotification(context)) {
            return false;
        }
        charSequence = NotificationUtil.getSbnTargetPkg((Context)context2, (StatusBarNotification)statusBarNotification);
        Bundle bundle = statusBarNotification.getNotification().extras;
        if (statusBarNotification.getNotification().extras.containsKey("android.progressSegments") && !PromotedNotificationParamUtils.isNotificationPromotedOngoing((StatusBarNotification)statusBarNotification)) {
            this.handleProgressStyle(context, bundle, statusBarNotification, bl);
            return false;
        }
        this.mFocusNotifUtils.resetParam(bundle, "miui.focus.enableAlert");
        if (this.mFocusNotifUtils.hasCustomFocusView(statusBarNotification)) {
            return this.buildNoParamsFocusNotification(statusBarNotification, (String)charSequence, context, context2, focusNotificationContent, inflateAndAuthCallBack, notificationProvider);
        }
        bundle = this.mFocusNotifUtils.parseFocusParam(context2, statusBarNotification, "miui.focus.param", focusNotificationContent);
        if (bundle == null) {
            return false;
        }
        return this.buildParamsFocusNotification(statusBarNotification, (JSONObject)bundle, context2, context, (String)charSequence, bl, focusNotificationContent, inflateAndAuthCallBack, notificationProvider);
    }

    public void onNotificationRemoved(StatusBarNotification statusBarNotification, FocusNotificationContent focusNotificationContent) {
        this.mTemplateFactoryV3.removeTemplate(statusBarNotification, focusNotificationContent);
    }
}
