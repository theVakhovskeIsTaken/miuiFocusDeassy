/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  D0.a
 *  G0.c
 *  G0.d
 *  G0.k
 *  G0.s
 *  K0.d
 *  K0.g
 *  L0.c
 *  M0.b
 *  U0.o
 *  android.app.Notification
 *  android.app.PendingIntent
 *  android.content.ContentResolver
 *  android.content.Context
 *  android.content.res.Configuration
 *  android.database.ContentObserver
 *  android.net.Uri
 *  android.os.Bundle
 *  android.os.Handler
 *  android.os.Parcelable
 *  android.service.notification.StatusBarNotification
 *  android.util.Log
 *  android.view.View
 *  com.android.systemui.miui.notification.R$id
 *  com.android.systemui.plugins.NotificationListenerController$NotificationProvider
 *  com.android.systemui.plugins.miui.dynamicisland.DynamicIslandContent
 *  com.android.systemui.plugins.miui.dynamicisland.DynamicIslandData
 *  com.android.systemui.plugins.miui.notification.FocusNotificationContent
 *  com.android.systemui.plugins.miui.notification.NotificationDynamicIslandPlugin$FocusInflationCallback
 *  f1.E
 *  f1.F
 *  f1.M
 *  f1.f
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.E
 *  kotlin.jvm.internal.o
 *  miui.systemui.autodensity.AutoDensityController
 *  miui.systemui.autodensity.AutoDensityController$OnDensityChangeListener
 *  miui.systemui.coroutines.Dispatchers
 *  miui.systemui.dagger.qualifiers.Plugin
 *  miui.systemui.dynamicisland.DynamicFeatureConfig
 *  miui.systemui.dynamicisland.window.DynamicIslandWindowView
 *  miui.systemui.dynamicisland.window.DynamicIslandWindowViewController$DynamicIslandCallback
 *  miui.systemui.dynamicisland.window.DynamicIslandWindowViewCreator
 *  miui.systemui.notification.LottieProgressManager
 *  miui.systemui.notification.NotificationChronometerManager
 *  miui.systemui.notification.NotificationSettingsManager
 *  miui.systemui.notification.NotificationUtil
 *  miui.systemui.notification.auth.AuthManager
 *  miui.systemui.util.CommonUtils
 *  miui.systemui.util.ConvenienceExtensionsKt
 *  miui.systemui.util.LoggerKt
 *  miui.systemui.util.MetadataUtils
 *  miui.systemui.util.concurrency.ConcurrencyModule
 *  miui.systemui.util.liveupdate.PromotedNotificationParamUtils
 *  org.json.JSONObject
 */
package miui.systemui.notification.focus;

import D0.a;
import G0.c;
import G0.k;
import G0.s;
import K0.d;
import K0.g;
import M0.b;
import android.app.Notification;
import android.app.PendingIntent;
import android.content.ContentResolver;
import android.content.Context;
import android.content.res.Configuration;
import android.database.ContentObserver;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Parcelable;
import android.service.notification.StatusBarNotification;
import android.util.Log;
import android.view.View;
import com.android.systemui.miui.notification.R;
import com.android.systemui.plugins.NotificationListenerController;
import com.android.systemui.plugins.miui.dynamicisland.DynamicIslandContent;
import com.android.systemui.plugins.miui.dynamicisland.DynamicIslandData;
import com.android.systemui.plugins.miui.notification.FocusNotificationContent;
import com.android.systemui.plugins.miui.notification.NotificationDynamicIslandPlugin;
import f1.F;
import f1.M;
import f1.f;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.E;
import kotlin.jvm.internal.o;
import miui.systemui.autodensity.AutoDensityController;
import miui.systemui.coroutines.Dispatchers;
import miui.systemui.dagger.qualifiers.Plugin;
import miui.systemui.dynamicisland.DynamicFeatureConfig;
import miui.systemui.dynamicisland.window.DynamicIslandWindowView;
import miui.systemui.dynamicisland.window.DynamicIslandWindowViewController;
import miui.systemui.dynamicisland.window.DynamicIslandWindowViewCreator;
import miui.systemui.notification.LottieProgressManager;
import miui.systemui.notification.NotificationChronometerManager;
import miui.systemui.notification.NotificationSettingsManager;
import miui.systemui.notification.NotificationUtil;
import miui.systemui.notification.auth.AuthManager;
import miui.systemui.notification.focus.Const;
import miui.systemui.notification.focus.FocusNotifPreHandler;
import miui.systemui.notification.focus.FocusNotifUtils;
import miui.systemui.notification.focus.FocusNotificationContentImpl;
import miui.systemui.notification.focus.FocusNotificationController;
import miui.systemui.notification.focus.HideDeletedFocusController;
import miui.systemui.notification.focus.InflateAndAuthCallBack;
import miui.systemui.notification.focus.SignatureChecker;
import miui.systemui.util.CommonUtils;
import miui.systemui.util.ConvenienceExtensionsKt;
import miui.systemui.util.LoggerKt;
import miui.systemui.util.MetadataUtils;
import miui.systemui.util.concurrency.ConcurrencyModule;
import miui.systemui.util.liveupdate.PromotedNotificationParamUtils;
import org.json.JSONObject;

public final class FocusNotificationController {
    private boolean addCallback;
    private Map<String, Boolean> authResult;
    private final AutoDensityController autoDensityController;
    private Map<String, NotificationDynamicIslandPlugin.FocusInflationCallback> callbackMap;
    private final Context context;
    private DynamicIslandContent dynamicIslandContent;
    private final FocusNotifPreHandler focusNotifPreHandler;
    private final FocusNotifUtils focusNotifUtils;
    private final HideDeletedFocusController hideDeletedFocusController;
    private final f1.E immediateUiScope;
    private final inflateCallBack.1 inflateCallBack;
    private Map<String, Boolean> inflateResult;
    private boolean isFlipDevice;
    private boolean isNightModeActiveOrigin;
    private Map<String, DynamicIslandData> islandShowingMap;
    private final ArrayList<String> islandTimeoutRemovedList;
    private final a lottieProgressManager;
    private NotificationListenerController.NotificationProvider mProvider;
    private final Handler mainHandler;
    private final G0.d notificationChronometerManager$delegate;
    private Map<String, FocusNotificationContent> notificationMap;
    private final NotificationSettingsManager notificationSettingsManager;
    private Context pluginCtx;
    private Map<String, StatusBarNotification> sbnMap;
    private final f1.E scope;
    private final SignatureChecker signatureChecker;
    private Context sysuiCtx;
    private final a windowViewCreator;

    public FocusNotificationController(@Plugin f1.E e, Context context, Handler handler, a a2, HideDeletedFocusController hideDeletedFocusController, a a3, NotificationSettingsManager notificationSettingsManager, FocusNotifPreHandler focusNotifPreHandler, a a4, FocusNotifUtils focusNotifUtils, SignatureChecker signatureChecker, AutoDensityController autoDensityController) {
        o.g((Object)e, (String)"scope");
        o.g((Object)context, (String)"context");
        o.g((Object)handler, (String)"mainHandler");
        o.g((Object)a2, (String)"windowViewCreator");
        o.g((Object)hideDeletedFocusController, (String)"hideDeletedFocusController");
        o.g((Object)a3, (String)"notificationChronometerManager");
        o.g((Object)notificationSettingsManager, (String)"notificationSettingsManager");
        o.g((Object)focusNotifPreHandler, (String)"focusNotifPreHandler");
        o.g((Object)a4, (String)"lottieProgressManager");
        o.g((Object)focusNotifUtils, (String)"focusNotifUtils");
        o.g((Object)signatureChecker, (String)"signatureChecker");
        o.g((Object)autoDensityController, (String)"autoDensityController");
        this.scope = e;
        this.context = context;
        this.mainHandler = handler;
        this.windowViewCreator = a2;
        this.hideDeletedFocusController = hideDeletedFocusController;
        this.notificationSettingsManager = notificationSettingsManager;
        this.focusNotifPreHandler = focusNotifPreHandler;
        this.lottieProgressManager = a4;
        this.focusNotifUtils = focusNotifUtils;
        this.signatureChecker = signatureChecker;
        this.autoDensityController = autoDensityController;
        this.notificationChronometerManager$delegate = ConvenienceExtensionsKt.getKotlinLazy((a)a3);
        this.notificationMap = new LinkedHashMap<String, FocusNotificationContent>();
        this.islandShowingMap = new LinkedHashMap<String, DynamicIslandData>();
        this.islandTimeoutRemovedList = new ArrayList();
        this.sbnMap = new LinkedHashMap<String, StatusBarNotification>();
        this.callbackMap = new LinkedHashMap<String, NotificationDynamicIslandPlugin.FocusInflationCallback>();
        this.immediateUiScope = F.g((f1.E)ConcurrencyModule.INSTANCE.getUiScope(), (g)Dispatchers.INSTANCE.getMain().B());
        this.inflateResult = new LinkedHashMap<String, Boolean>();
        this.authResult = new LinkedHashMap<String, Boolean>();
        this.isFlipDevice = CommonUtils.isFlipDevice();
        this.register();
        this.inflateCallBack = new InflateAndAuthCallBack(this){
            final FocusNotificationController this$0;
            {
                this.this$0 = focusNotificationController;
            }

            public void onAuthFailed(String string, String string2) {
                o.g((Object)string, (String)"key");
                o.g((Object)string2, (String)"packageName");
                f.b((f1.E)FocusNotificationController.access$getScope$p(this.this$0), null, null, (U0.o)new U0.o(string, string2, this.this$0, null){
                    final String $key;
                    final String $packageName;
                    int label;
                    final FocusNotificationController this$0;
                    {
                        this.$key = string;
                        this.$packageName = string2;
                        this.this$0 = focusNotificationController;
                        super(2, d2);
                    }

                    public final d create(Object object, d d2) {
                        return new /* invalid duplicate definition of identical inner class */;
                    }

                    public final Object invoke(f1.E e, d d2) {
                        return (this.create(e, d2)).invokeSuspend(s.a);
                    }

                    public final Object invokeSuspend(Object object) {
                        L0.c.c();
                        if (this.label == 0) {
                            k.b((Object)object);
                            object = this.$key;
                            String string = this.$packageName;
                            StringBuilder stringBuilder = new StringBuilder();
                            stringBuilder.append("onAuthFailed ");
                            stringBuilder.append((String)object);
                            stringBuilder.append(" ");
                            stringBuilder.append(string);
                            Log.e((String)"FocusPlugin", (String)stringBuilder.toString());
                            FocusNotificationController.access$getAuthResult$p(this.this$0).put(this.$key, b.a((boolean)false));
                            FocusNotificationController.inflateFinishCallback$default(this.this$0, this.$key, null, 2, null);
                            return s.a;
                        }
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                }, (int)3, null);
            }

            public void onAuthFinish(String string, String string2) {
                o.g((Object)string, (String)"key");
                o.g((Object)string2, (String)"packageName");
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("onAuthFinish ");
                stringBuilder.append(string);
                stringBuilder.append(" ");
                stringBuilder.append(string2);
                Log.e((String)"FocusPlugin", (String)stringBuilder.toString());
            }

            public void onAuthSuccess(String string, String string2) {
                o.g((Object)string, (String)"key");
                o.g((Object)string2, (String)"packageName");
                f.b((f1.E)FocusNotificationController.access$getScope$p(this.this$0), null, null, (U0.o)new U0.o(string, string2, this.this$0, null){
                    final String $key;
                    final String $packageName;
                    int label;
                    final FocusNotificationController this$0;
                    {
                        this.$key = string;
                        this.$packageName = string2;
                        this.this$0 = focusNotificationController;
                        super(2, d2);
                    }

                    public final d create(Object object, d d2) {
                        return new /* invalid duplicate definition of identical inner class */;
                    }

                    public final Object invoke(f1.E e, d d2) {
                        return (this.create(e, d2)).invokeSuspend(s.a);
                    }

                    public final Object invokeSuspend(Object object) {
                        L0.c.c();
                        if (this.label == 0) {
                            k.b((Object)object);
                            String string = this.$key;
                            object = this.$packageName;
                            StringBuilder stringBuilder = new StringBuilder();
                            stringBuilder.append("onAuthSuccess ");
                            stringBuilder.append(string);
                            stringBuilder.append(" ");
                            stringBuilder.append((String)object);
                            Log.e((String)"FocusPlugin", (String)stringBuilder.toString());
                            FocusNotificationController.access$getAuthResult$p(this.this$0).put(this.$key, b.a((boolean)true));
                            FocusNotificationController.inflateFinishCallback$default(this.this$0, this.$key, null, 2, null);
                            return s.a;
                        }
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                }, (int)3, null);
            }

            public void onInflateFailed(String string, FocusNotificationContent focusNotificationContent) {
                o.g((Object)string, (String)"key");
                o.g((Object)focusNotificationContent, (String)"content");
                f.b((f1.E)FocusNotificationController.access$getScope$p(this.this$0), null, null, (U0.o)new U0.o(string, this.this$0, focusNotificationContent, null){
                    final FocusNotificationContent $content;
                    final String $key;
                    int label;
                    final FocusNotificationController this$0;
                    {
                        this.$key = string;
                        this.this$0 = focusNotificationController;
                        this.$content = focusNotificationContent;
                        super(2, d2);
                    }

                    public final d create(Object object, d d2) {
                        return new /* invalid duplicate definition of identical inner class */;
                    }

                    public final Object invoke(f1.E e, d d2) {
                        return (this.create(e, d2)).invokeSuspend(s.a);
                    }

                    public final Object invokeSuspend(Object object) {
                        L0.c.c();
                        if (this.label == 0) {
                            k.b((Object)object);
                            String string = this.$key;
                            object = new StringBuilder();
                            ((StringBuilder)object).append("onInflateFailed ");
                            ((StringBuilder)object).append(string);
                            Log.e((String)"FocusPlugin", (String)((StringBuilder)object).toString());
                            FocusNotificationController.access$getInflateResult$p(this.this$0).put(this.$key, b.a((boolean)false));
                            FocusNotificationController.access$inflateFinishCallback(this.this$0, this.$key, this.$content);
                            return s.a;
                        }
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                }, (int)3, null);
            }

            public void onInflateFinish(String string, FocusNotificationContent focusNotificationContent) {
                o.g((Object)string, (String)"key");
                o.g((Object)focusNotificationContent, (String)"content");
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("onInflateFinish ");
                stringBuilder.append(string);
                Log.e((String)"FocusPlugin", (String)stringBuilder.toString());
                FocusNotificationController.access$onInflateEnd(this.this$0, string, focusNotificationContent);
            }

            public void onInflateSuccess(String string, FocusNotificationContent focusNotificationContent) {
                o.g((Object)string, (String)"key");
                o.g((Object)focusNotificationContent, (String)"content");
                f.b((f1.E)FocusNotificationController.access$getScope$p(this.this$0), null, null, (U0.o)new U0.o(string, this.this$0, focusNotificationContent, null){
                    final FocusNotificationContent $content;
                    final String $key;
                    int label;
                    final FocusNotificationController this$0;
                    {
                        this.$key = string;
                        this.this$0 = focusNotificationController;
                        this.$content = focusNotificationContent;
                        super(2, d2);
                    }

                    public final d create(Object object, d d2) {
                        return new /* invalid duplicate definition of identical inner class */;
                    }

                    public final Object invoke(f1.E e, d d2) {
                        return (this.create(e, d2)).invokeSuspend(s.a);
                    }

                    public final Object invokeSuspend(Object object) {
                        L0.c.c();
                        if (this.label == 0) {
                            k.b((Object)object);
                            object = this.$key;
                            StringBuilder stringBuilder = new StringBuilder();
                            stringBuilder.append("onInflateSuccess ");
                            stringBuilder.append((String)object);
                            Log.e((String)"FocusPlugin", (String)stringBuilder.toString());
                            FocusNotificationController.access$getInflateResult$p(this.this$0).put(this.$key, b.a((boolean)true));
                            FocusNotificationController.access$inflateFinishCallback(this.this$0, this.$key, this.$content);
                            return s.a;
                        }
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                }, (int)3, null);
            }
        };
    }

    public static final /* synthetic */ Map access$getAuthResult$p(FocusNotificationController focusNotificationController) {
        return focusNotificationController.authResult;
    }

    public static final /* synthetic */ AutoDensityController access$getAutoDensityController$p(FocusNotificationController focusNotificationController) {
        return focusNotificationController.autoDensityController;
    }

    public static final /* synthetic */ Map access$getCallbackMap$p(FocusNotificationController focusNotificationController) {
        return focusNotificationController.callbackMap;
    }

    public static final /* synthetic */ Context access$getContext$p(FocusNotificationController focusNotificationController) {
        return focusNotificationController.context;
    }

    public static final /* synthetic */ FocusNotifUtils access$getFocusNotifUtils$p(FocusNotificationController focusNotificationController) {
        return focusNotificationController.focusNotifUtils;
    }

    public static final /* synthetic */ Map access$getInflateResult$p(FocusNotificationController focusNotificationController) {
        return focusNotificationController.inflateResult;
    }

    public static final /* synthetic */ Map access$getIslandShowingMap$p(FocusNotificationController focusNotificationController) {
        return focusNotificationController.islandShowingMap;
    }

    public static final /* synthetic */ ArrayList access$getIslandTimeoutRemovedList$p(FocusNotificationController focusNotificationController) {
        return focusNotificationController.islandTimeoutRemovedList;
    }

    public static final /* synthetic */ NotificationListenerController.NotificationProvider access$getMProvider$p(FocusNotificationController focusNotificationController) {
        return focusNotificationController.mProvider;
    }

    public static final /* synthetic */ NotificationChronometerManager access$getNotificationChronometerManager(FocusNotificationController focusNotificationController) {
        return focusNotificationController.getNotificationChronometerManager();
    }

    public static final /* synthetic */ Map access$getNotificationMap$p(FocusNotificationController focusNotificationController) {
        return focusNotificationController.notificationMap;
    }

    public static final /* synthetic */ Context access$getPluginCtx$p(FocusNotificationController focusNotificationController) {
        return focusNotificationController.pluginCtx;
    }

    public static final /* synthetic */ Map access$getSbnMap$p(FocusNotificationController focusNotificationController) {
        return focusNotificationController.sbnMap;
    }

    public static final /* synthetic */ f1.E access$getScope$p(FocusNotificationController focusNotificationController) {
        return focusNotificationController.scope;
    }

    public static final /* synthetic */ Context access$getSysuiCtx$p(FocusNotificationController focusNotificationController) {
        return focusNotificationController.sysuiCtx;
    }

    public static final /* synthetic */ void access$inflateFinishCallback(FocusNotificationController focusNotificationController, String string, FocusNotificationContent focusNotificationContent) {
        focusNotificationController.inflateFinishCallback(string, focusNotificationContent);
    }

    public static final /* synthetic */ void access$onInflateEnd(FocusNotificationController focusNotificationController, String string, FocusNotificationContent focusNotificationContent) {
        focusNotificationController.onInflateEnd(string, focusNotificationContent);
    }

    public static final /* synthetic */ void access$removeByKey(FocusNotificationController focusNotificationController, String string) {
        focusNotificationController.removeByKey(string);
    }

    public static final /* synthetic */ void access$removeByPkg(FocusNotificationController focusNotificationController, String string) {
        focusNotificationController.removeByPkg(string);
    }

    private final void addDynamicIslandView(FocusNotificationContent object, StatusBarNotification statusBarNotification) {
        boolean bl = statusBarNotification.getNotification().extras.getBoolean("miui.focus.isFocus");
        boolean bl2 = this.hideDeletedFocusController.suppressDeletedFocus(statusBarNotification);
        boolean bl3 = this.focusNotifUtils.canShowFocus(this.context, statusBarNotification.getPackageName(), statusBarNotification.getUserId());
        Object var7_6 = null;
        Object object2 = object != null ? object.getIslandExpandedView() : null;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("addDynamicIslandView  ");
        stringBuilder.append(object2);
        stringBuilder.append(", (");
        stringBuilder.append(bl);
        stringBuilder.append(" && ");
        stringBuilder.append(bl2);
        stringBuilder.append(") || ");
        stringBuilder.append(bl3 ^ true);
        Log.d((String)"FocusPlugin", (String)stringBuilder.toString());
        if (bl && bl2 || !bl3) {
            return;
        }
        stringBuilder = new DynamicIslandData();
        stringBuilder.setKey(statusBarNotification.getKey());
        object2 = object != null ? object.getIslandExpandedView() : null;
        stringBuilder.setView((View)object2);
        object2 = var7_6;
        if (object != null) {
            object2 = object.getIslandExpandedViewFake();
        }
        stringBuilder.setFakeView((View)object2);
        stringBuilder.setTickerData(this.parseIslandData(statusBarNotification, (FocusNotificationContent)object));
        statusBarNotification.getNotification().extras.putString("miui.ticker.data", stringBuilder.getTickerData());
        if (stringBuilder.getView() == null && ((object = stringBuilder.getTickerData()) == null || object.length() == 0)) {
            object = statusBarNotification.getKey();
            o.f((Object)object, (String)"getKey(...)");
            this.removeByKey((String)object);
            return;
        }
        stringBuilder.setExtras(this.setUpDynamicIslandDataBundle(statusBarNotification));
        object = this.islandShowingMap;
        object2 = statusBarNotification.getKey();
        o.f((Object)object2, (String)"getKey(...)");
        object.put(object2, stringBuilder);
        if (((DynamicIslandWindowViewCreator)this.windowViewCreator.get()).getWindowView() == null) {
            this.dynamicIslandContent = ((DynamicIslandWindowViewCreator)this.windowViewCreator.get()).createView();
        }
        bl2 = statusBarNotification.getNotification().extras.getBoolean("miui.island.updateNoFloat", false);
        bl2 = statusBarNotification.getNotification().extras.getBoolean("miui.island.firstFloat", true) && !bl2;
        statusBarNotification.getNotification().extras.putBoolean("miui.island.updateNoFloat", false);
        object = ((DynamicIslandWindowViewCreator)this.windowViewCreator.get()).getWindowView();
        if (object != null && (object = object.getWindowViewController()) != null) {
            object.addDynamicIslandView((DynamicIslandData)stringBuilder, bl2);
        }
        if (!this.addCallback) {
            this.addCallback = true;
            object = (DynamicIslandWindowViewCreator)this.windowViewCreator.get();
            if (object != null && (object = object.getWindowView()) != null && (object = object.getWindowViewController()) != null) {
                object.addDynamicIslandTimeoutRemovedCallback(new DynamicIslandWindowViewController.DynamicIslandCallback(this){
                    final FocusNotificationController this$0;
                    {
                        this.this$0 = focusNotificationController;
                    }

                    public void onDynamicIslandConfigChange() {
                        Object object = new HashMap(FocusNotificationController.access$getIslandShowingMap$p(this.this$0));
                        FocusNotificationController focusNotificationController = this.this$0;
                        for (Map.Entry<K, V> entry : object.entrySet()) {
                            Object object2;
                            Notification notification;
                            if (FocusNotificationController.access$getIslandTimeoutRemovedList$p(focusNotificationController).contains(entry.getKey())) continue;
                            object = (FocusNotificationContent)FocusNotificationController.access$getNotificationMap$p(focusNotificationController).get(entry.getKey());
                            object = object != null ? object.getSbn() : null;
                            if (object != null && (notification = object.getNotification()) != null && (notification = notification.extras) != null) {
                                notification.putBoolean("miui.island.updateNoFloat", true);
                            }
                            notification = (NotificationDynamicIslandPlugin.FocusInflationCallback)FocusNotificationController.access$getCallbackMap$p(focusNotificationController).get(entry.getKey());
                            FocusNotificationController.access$getNotificationChronometerManager(focusNotificationController).saveTempTimeKeeperStatus((StatusBarNotification)object);
                            FocusNotificationController.onNotificationRemoved$default(focusNotificationController, (StatusBarNotification)object, false, 2, null);
                            if (object != null && (object2 = object.getKey()) != null) {
                                o.d((Object)object2);
                                object2 = (Long)((AbstractMap)FocusNotificationController.access$getFocusNotifUtils$p(focusNotificationController).getMaxSeq()).remove(object2);
                            }
                            if (notification != null) {
                                object2 = FocusNotificationController.access$getCallbackMap$p(focusNotificationController);
                                K k2 = entry.getKey();
                                o.f(k2, (String)"<get-key>(...)");
                                NotificationDynamicIslandPlugin.FocusInflationCallback focusInflationCallback = (NotificationDynamicIslandPlugin.FocusInflationCallback)object2.put(k2, notification);
                            }
                            if (object == null) continue;
                            Context context = FocusNotificationController.access$getContext$p(focusNotificationController);
                            object2 = FocusNotificationController.access$getSysuiCtx$p(focusNotificationController);
                            o.d((Object)object2);
                            notification = FocusNotificationController.access$getMProvider$p(focusNotificationController);
                            o.d((Object)notification);
                            focusNotificationController.onNotificationPosted((StatusBarNotification)object, context, (Context)object2, (NotificationListenerController.NotificationProvider)notification);
                        }
                    }

                    public void onDynamicIslandTimeoutRemoved(String string) {
                        o.g((Object)string, (String)"key");
                        boolean bl = FocusNotificationController.access$getNotificationMap$p(this.this$0).get(string) != null;
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append("onDynamicIslandTimeoutRemoved, key=");
                        stringBuilder.append(string);
                        stringBuilder.append(", hasFocusNotification=");
                        stringBuilder.append(bl);
                        Log.e((String)"FocusPlugin", (String)stringBuilder.toString());
                        if (bl) {
                            FocusNotificationController.access$getIslandTimeoutRemovedList$p(this.this$0).add(string);
                        } else {
                            FocusNotificationController.access$removeByKey(this.this$0, string);
                        }
                    }

                    public void removeNotification(StatusBarNotification statusBarNotification) {
                        o.g((Object)statusBarNotification, (String)"sbn");
                        NotificationListenerController.NotificationProvider notificationProvider = FocusNotificationController.access$getMProvider$p(this.this$0);
                        if (notificationProvider != null) {
                            notificationProvider.removeNotification(statusBarNotification);
                        }
                    }
                });
            }
        }
    }

    private final void fetchAuthResult(Context object, StatusBarNotification statusBarNotification, String string, Bundle bundle, InflateAndAuthCallBack inflateAndAuthCallBack) {
        if (!DynamicFeatureConfig.INSTANCE.getISLAND_XMS_SWITCHER() && !this.notificationSettingsManager.canPassXMSPermission(string)) {
            if (NotificationUtil.IS_INTERNATIONAL_BUILD) {
                Log.i((String)"FocusPlugin", (String)"is international build");
                object = statusBarNotification.getKey();
                o.f((Object)object, (String)"getKey(...)");
                inflateAndAuthCallBack.onAuthSuccess((String)object, string);
                return;
            }
            if (this.focusNotifUtils.hasCustomFocusView(statusBarNotification)) {
                if (!this.notificationSettingsManager.canCustomFocus(statusBarNotification.getPackageName()) && !PromotedNotificationParamUtils.isNotificationPromotedOngoing((StatusBarNotification)statusBarNotification)) {
                    this.focusNotifUtils.resetAllParam(bundle);
                    object = statusBarNotification.getKey();
                    o.f((Object)object, (String)"getKey(...)");
                    inflateAndAuthCallBack.onAuthFailed((String)object, string);
                    return;
                }
                object = statusBarNotification.getKey();
                o.f((Object)object, (String)"getKey(...)");
                inflateAndAuthCallBack.onAuthSuccess((String)object, string);
                return;
            }
            if (this.signatureChecker.checkSignatures(string)) {
                object = statusBarNotification.getKey();
                o.f((Object)object, (String)"getKey(...)");
                inflateAndAuthCallBack.onAuthSuccess((String)object, string);
                return;
            }
            AuthManager.INSTANCE.auth((Context)object, statusBarNotification.getKey(), string, inflateAndAuthCallBack);
            return;
        }
        object = new StringBuilder();
        ((StringBuilder)object).append("pass xms permission ");
        ((StringBuilder)object).append(string);
        Log.e((String)"FocusPlugin", (String)((StringBuilder)object).toString());
        object = statusBarNotification.getKey();
        o.f((Object)object, (String)"getKey(...)");
        inflateAndAuthCallBack.onAuthSuccess((String)object, string);
    }

    private final NotificationChronometerManager getNotificationChronometerManager() {
        return (NotificationChronometerManager)this.notificationChronometerManager$delegate.getValue();
    }

    private final void inflateFinishCallback(String string, FocusNotificationContent object) {
        if (this.shouldSkipInflateAuth(string)) {
            return;
        }
        FocusNotificationContent focusNotificationContent = this.notificationMap.get(string);
        if (object != null && !o.c((Object)object, (Object)focusNotificationContent)) {
            return;
        }
        Object var4_4 = null;
        object = focusNotificationContent != null ? focusNotificationContent.getFocusNotification() : null;
        Object object2 = focusNotificationContent != null ? focusNotificationContent.getKey() : null;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("inflateFinishCallback: ");
        stringBuilder.append(object);
        stringBuilder.append("  ");
        stringBuilder.append((String)object2);
        Log.d((String)"EmptyNotif", (String)stringBuilder.toString());
        object2 = this.authResult.get(string);
        object = Boolean.FALSE;
        if (o.c((Object)object2, (Object)object) || o.c((Object)this.inflateResult.get(string), (Object)object)) {
            object = this.sbnMap.get(string);
            if (object != null && (object = object.getNotification()) != null && (object = object.extras) != null) {
                this.focusNotifUtils.resetAllParam((Bundle)object);
            }
            if (focusNotificationContent != null) {
                focusNotificationContent.reset();
                object = this.callbackMap.get(string);
                if (object != null) {
                    object.onFocusInflationFinished(focusNotificationContent);
                }
                this.removeByKey(string);
                return;
            }
        }
        if ((object = focusNotificationContent != null ? focusNotificationContent.getFocusNotification() : null) == null) {
            object = var4_4;
            if (focusNotificationContent != null) {
                object = focusNotificationContent.getIslandExpandedView();
            }
            if (object == null && !this.focusNotifUtils.hasIslandData(this.sbnMap.get(string))) {
                this.removeByKey(string);
                return;
            }
        }
        if (this.islandShowingMap.containsKey(string)) {
            Log.e((String)"FocusPlugin", (String)"updateDynamicIslandView");
            object = this.sbnMap.get(string);
            if (object != null) {
                this.updateDynamicIslandView(focusNotificationContent, (StatusBarNotification)object);
            }
        } else {
            object = this.sbnMap.get(string);
            if (object != null) {
                this.addDynamicIslandView(focusNotificationContent, (StatusBarNotification)object);
            }
        }
        if (focusNotificationContent != null && focusNotificationContent.getFocusNotification() != null && (string = this.callbackMap.get(string)) != null) {
            string.onFocusInflationFinished(focusNotificationContent);
        }
    }

    public static /* synthetic */ void inflateFinishCallback$default(FocusNotificationController focusNotificationController, String string, FocusNotificationContent focusNotificationContent, int n, Object object) {
        if ((n & 2) != 0) {
            focusNotificationContent = null;
        }
        focusNotificationController.inflateFinishCallback(string, focusNotificationContent);
    }

    private final void onInflateEnd(String string, FocusNotificationContent focusNotificationContent) {
        Log.d((String)"FocusPlugin", (String)"inflation Ended");
        FocusNotificationContent focusNotificationContent2 = this.notificationMap.get(string);
        if (!o.c((Object)focusNotificationContent2, (Object)focusNotificationContent)) {
            return;
        }
        if (focusNotificationContent2 != null && focusNotificationContent2.getFocusNotification() != null && (focusNotificationContent = this.sbnMap.get(string)) != null) {
            this.getNotificationChronometerManager().updateTimeKeeper((StatusBarNotification)focusNotificationContent, focusNotificationContent2);
            ((LottieProgressManager)this.lottieProgressManager.get()).addLottie(string, focusNotificationContent2, R.id.focus_animation);
        }
    }

    public static /* synthetic */ boolean onNotificationRemoved$default(FocusNotificationController focusNotificationController, StatusBarNotification statusBarNotification, boolean bl, int n, Object object) {
        if ((n & 2) != 0) {
            bl = true;
        }
        return focusNotificationController.onNotificationRemoved(statusBarNotification, bl);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private final String parseIslandData(StatusBarNotification object, FocusNotificationContent focusNotificationContent) {
        Exception exception2;
        block6: {
            try {
                if (this.focusNotifUtils.hasCustomFocusView((StatusBarNotification)object)) {
                    return this.focusNotifUtils.parseCustomIslandData((StatusBarNotification)object);
                }
            }
            catch (Exception exception2) {
                break block6;
            }
            String string = object.getNotification().extras.getString("miui.focus.param");
            Object object2 = string != null ? new JSONObject(string) : null;
            if (object2 == null) {
                if (focusNotificationContent != null) {
                    focusNotificationContent.reset();
                }
                object2 = object.getKey();
                o.f((Object)object2, (String)"getKey(...)");
                this.removeByKey((String)object2);
                return "";
            }
            string = object2.optJSONObject("param_v2");
            if (string == null) return this.focusNotifUtils.parseOS1DefaultIslandData((JSONObject)object2, (StatusBarNotification)object);
            return this.focusNotifUtils.parseOS2DefaultIslandData((JSONObject)string, (StatusBarNotification)object);
        }
        exception2.printStackTrace();
        if (focusNotificationContent != null) {
            focusNotificationContent.reset();
        }
        object = object.getKey();
        o.f((Object)object, (String)"getKey(...)");
        this.removeByKey((String)object);
        return "";
    }

    private final void register() {
        boolean bl;
        Object object = this.context.getResources().getConfiguration();
        boolean bl2 = bl = false;
        if (object != null) {
            bl2 = bl;
            if ((object.uiMode & 0x30) == 32) {
                bl2 = true;
            }
        }
        this.isNightModeActiveOrigin = bl2;
        object = new AutoDensityController.OnDensityChangeListener(this){
            final FocusNotificationController this$0;
            {
                this.this$0 = focusNotificationController;
            }

            public void onConfigChanged(Configuration object) {
                o.g((Object)object, (String)"config");
                if (FocusNotificationController.access$getPluginCtx$p(this.this$0) != null && FocusNotificationController.access$getSysuiCtx$p(this.this$0) != null && FocusNotificationController.access$getMProvider$p(this.this$0) != null) {
                    boolean bl = object.isNightModeActive();
                    if (this.this$0.isNightModeActiveOrigin() == bl) {
                        Log.i((String)"FocusPlugin", (String)"uiMode is not change");
                        return;
                    }
                    Log.i((String)"FocusPlugin", (String)"promoted notification uiMode change");
                    this.this$0.setNightModeActiveOrigin(bl);
                    StatusBarNotification statusBarNotification2 = FocusNotificationController.access$getSbnMap$p(this.this$0).values();
                    object = this.this$0;
                    for (StatusBarNotification statusBarNotification2 : statusBarNotification2) {
                        if (!statusBarNotification2.getNotification().extras.getBoolean("miui.focus.isPromoted", false)) continue;
                        Context context = FocusNotificationController.access$getPluginCtx$p((FocusNotificationController)object);
                        o.d((Object)context);
                        Context context2 = FocusNotificationController.access$getSysuiCtx$p((FocusNotificationController)object);
                        o.d((Object)context2);
                        NotificationListenerController.NotificationProvider notificationProvider = FocusNotificationController.access$getMProvider$p((FocusNotificationController)object);
                        o.d((Object)notificationProvider);
                        ((FocusNotificationController)object).onNotificationPosted(statusBarNotification2, context, context2, notificationProvider);
                    }
                    return;
                }
                Log.i((String)"FocusPlugin", (String)"context or provider is null: ");
            }
        };
        f.b((f1.E)this.scope, null, null, (U0.o)new U0.o(this, object, null){
            final register.densityChangeListener.1 $densityChangeListener;
            int label;
            final FocusNotificationController this$0;
            {
                this.this$0 = focusNotificationController;
                this.$densityChangeListener = var2_2;
                super(2, d2);
            }

            public final d create(Object object, d d2) {
                return new /* invalid duplicate definition of identical inner class */;
            }

            public final Object invoke(f1.E e, d d2) {
                return (this.create(e, d2)).invokeSuspend(s.a);
            }

            public final Object invokeSuspend(Object object) {
                Object object2 = L0.c.c();
                int n = this.label;
                if (n != 0) {
                    if (n != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    k.b((Object)object);
                } else {
                    k.b((Object)object);
                    FocusNotificationController.access$getAutoDensityController$p(this.this$0).addOnDensityChangeListener((AutoDensityController.OnDensityChangeListener)this.$densityChangeListener);
                    this.label = 1;
                    if (M.a((d)this) == object2) {
                        return object2;
                    }
                }
                throw new c();
            }
        }, (int)3, null).k(new Function1(this, object){
            final register.densityChangeListener.1 $densityChangeListener;
            final FocusNotificationController this$0;
            {
                this.this$0 = focusNotificationController;
                this.$densityChangeListener = var2_2;
                super(1);
            }

            public final void invoke(Throwable throwable) {
                FocusNotificationController.access$getAutoDensityController$p(this.this$0).removeOnDensityChangeListener((AutoDensityController.OnDensityChangeListener)this.$densityChangeListener);
            }
        });
        ContentResolver contentResolver = this.context.getContentResolver();
        object = new ContentObserver(this, this.mainHandler){
            final FocusNotificationController this$0;
            {
                this.this$0 = focusNotificationController;
                super(handler);
            }

            public void onChange(boolean bl, Uri object) {
                block3: {
                    o.g((Object)object, (String)"uri");
                    String string = object.getQueryParameter("package");
                    bl = Boolean.parseBoolean(object.getQueryParameter("canShowFocus"));
                    object = new StringBuilder();
                    ((StringBuilder)object).append("mCanShowFocusObserver onChange pkg=");
                    ((StringBuilder)object).append(string);
                    ((StringBuilder)object).append(", canShowFocus=");
                    ((StringBuilder)object).append(bl);
                    Log.e((String)"FocusPlugin", (String)((StringBuilder)object).toString());
                    if (bl) break block3;
                    try {
                        FocusNotificationController.access$removeByPkg(this.this$0, string);
                    }
                    catch (Exception exception) {
                        exception.printStackTrace();
                    }
                }
            }
        };
        f.b((f1.E)this.scope, null, null, (U0.o)new U0.o(this, (Object)object, null){
            final register.observer.1 $observer;
            int label;
            final FocusNotificationController this$0;
            {
                this.this$0 = focusNotificationController;
                this.$observer = var2_2;
                super(2, d2);
            }

            public final d create(Object object, d d2) {
                return new /* invalid duplicate definition of identical inner class */;
            }

            public final Object invoke(f1.E e, d d2) {
                return (this.create(e, d2)).invokeSuspend(s.a);
            }

            public final Object invokeSuspend(Object object) {
                Object object2 = L0.c.c();
                int n = this.label;
                if (n != 0) {
                    if (n != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    k.b((Object)object);
                } else {
                    k.b((Object)object);
                    FocusNotificationController.access$getContext$p(this.this$0).getContentResolver().registerContentObserver(Const.Provider.URI_CAN_SHOW_FOCUS, false, (ContentObserver)this.$observer, -1);
                    this.label = 1;
                    if (M.a((d)this) == object2) {
                        return object2;
                    }
                }
                throw new c();
            }
        }, (int)3, null).k(new Function1(contentResolver, (Object)object){
            final ContentResolver $contentResolver;
            final register.observer.1 $observer;
            {
                this.$contentResolver = contentResolver;
                this.$observer = var2_2;
                super(1);
            }

            public final void invoke(Throwable throwable) {
                this.$contentResolver.unregisterContentObserver((ContentObserver)this.$observer);
            }
        });
    }

    private final void removeByKey(String string) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("removeByKey ");
        stringBuilder.append(string);
        Log.i((String)"FocusPlugin", (String)stringBuilder.toString());
        if (this.notificationMap.containsKey(string)) {
            this.notificationMap.remove(string);
        }
        if (this.islandShowingMap.containsKey(string)) {
            this.islandShowingMap.remove(string);
            stringBuilder = (DynamicIslandWindowViewCreator)this.windowViewCreator.get();
            stringBuilder = stringBuilder != null ? stringBuilder.getWindowView() : null;
            if (stringBuilder != null) {
                boolean bl;
                stringBuilder = this.sbnMap.get(string);
                boolean bl2 = bl = false;
                if (stringBuilder != null) {
                    stringBuilder = stringBuilder.getNotification();
                    bl2 = bl;
                    if (stringBuilder != null) {
                        stringBuilder = ((Notification)stringBuilder).extras;
                        bl2 = bl;
                        if (stringBuilder != null) {
                            bl2 = stringBuilder.getBoolean("miui.island.updateNoFloat", false);
                        }
                    }
                }
                if ((stringBuilder = (DynamicIslandWindowViewCreator)this.windowViewCreator.get()) != null && (stringBuilder = stringBuilder.getWindowView()) != null && (stringBuilder = stringBuilder.getWindowViewController()) != null) {
                    stringBuilder.removeDynamicIslandView(string, bl2);
                }
            }
        }
        if (this.sbnMap.containsKey(string)) {
            this.sbnMap.remove(string);
            this.getNotificationChronometerManager().removeTimeKeeper(string);
            ((LottieProgressManager)this.lottieProgressManager.get()).removeLottie(string);
        }
        if (this.callbackMap.containsKey(string)) {
            this.callbackMap.remove(string);
        }
        if (this.inflateResult.containsKey(string)) {
            this.inflateResult.remove(string);
        }
        if (this.authResult.containsKey(string)) {
            this.authResult.remove(string);
        }
    }

    private final void removeByPkg(String string) {
        Object object = this.notificationMap.values();
        ArrayList arrayList = new ArrayList();
        Iterator iterator = object.iterator();
        while (iterator.hasNext()) {
            Object t = iterator.next();
            object = ((FocusNotificationContent)t).getSbn();
            object = object != null ? object.getPackageName() : null;
            if (!o.c((Object)object, (Object)string)) continue;
            arrayList.add(t);
        }
        object = arrayList.iterator();
        while (object.hasNext()) {
            string = ((FocusNotificationContent)object.next()).getKey();
            if (string == null) continue;
            this.removeByKey(string);
        }
    }

    private final Bundle setUpDynamicIslandDataBundle(StatusBarNotification statusBarNotification) {
        Bundle bundle = new Bundle();
        bundle.putString("miui.pkg.name", NotificationUtil.getSbnTargetPkg((Context)this.sysuiCtx, (StatusBarNotification)statusBarNotification));
        bundle.putInt("miui.user.id", statusBarNotification.getUser().getIdentifier());
        bundle.putParcelable("miui.sbn", (Parcelable)statusBarNotification);
        bundle.putString("miui.effect.src", statusBarNotification.getNotification().extras.getString("miui.effect.src"));
        bundle.putString("miui.effect.color", statusBarNotification.getNotification().extras.getString("miui.effect.color"));
        bundle.putBundle("miui.focus.pics", statusBarNotification.getNotification().extras.getBundle("miui.focus.pics"));
        bundle.putInt("miui.focus.lottieView.id", statusBarNotification.getNotification().extras.getInt("miui.focus.lottieView.id"));
        bundle.putInt("miui.focus.lottieView.fake.id", statusBarNotification.getNotification().extras.getInt("miui.focus.lottieView.fake.id"));
        bundle.putBoolean("miui.focus.lottieView.isPlay", statusBarNotification.getNotification().extras.getBoolean("miui.focus.lottieView.isPlay"));
        bundle.putBoolean("miui.focus.isPromoted", statusBarNotification.getNotification().extras.getBoolean("miui.focus.isPromoted"));
        if (statusBarNotification.getNotification().extras.containsKey("miui.exitFloating")) {
            statusBarNotification = statusBarNotification.getNotification().extras.getParcelable("miui.exitFloating");
            if (statusBarNotification != null && statusBarNotification instanceof PendingIntent) {
                bundle.putParcelable("miui.exitFloating", (Parcelable)statusBarNotification);
            }
        } else {
            bundle.putParcelable("miui.exitFloating", (Parcelable)statusBarNotification.getNotification().extraNotification.getExitFloatingIntent());
        }
        return bundle;
    }

    private final boolean shouldSkipInflateAuth(String string) {
        Map<String, Boolean> map = this.authResult;
        Map<String, Boolean> map2 = this.inflateResult;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("inflateFinishCallback ");
        stringBuilder.append(string);
        stringBuilder.append(" ");
        stringBuilder.append(map);
        stringBuilder.append(" ");
        stringBuilder.append(map2);
        Log.d((String)"FocusPlugin", (String)stringBuilder.toString());
        boolean bl = this.authResult.get(string) == null || this.inflateResult.get(string) == null;
        return bl;
    }

    private final void updateDynamicIslandView(FocusNotificationContent focusNotificationContent, StatusBarNotification statusBarNotification) {
        Object var5_3 = null;
        Object object = focusNotificationContent != null ? focusNotificationContent.getIslandExpandedView() : null;
        String string = statusBarNotification.getKey();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("updateDynamicIslandView: islandExpandedView");
        stringBuilder.append(object);
        stringBuilder.append(" , key: ");
        stringBuilder.append(string);
        Log.e((String)"FocusPlugin", (String)stringBuilder.toString());
        if (statusBarNotification.getNotification().extras.getBoolean("miui.focus.isFocus") && this.hideDeletedFocusController.suppressDeletedFocus(statusBarNotification)) {
            return;
        }
        this.islandTimeoutRemovedList.remove(statusBarNotification.getKey());
        string = new DynamicIslandData();
        object = focusNotificationContent != null ? focusNotificationContent.getKey() : null;
        string.setKey((String)object);
        object = focusNotificationContent != null ? focusNotificationContent.getIslandExpandedView() : null;
        string.setView(object);
        object = var5_3;
        if (focusNotificationContent != null) {
            object = focusNotificationContent.getIslandExpandedViewFake();
        }
        string.setFakeView(object);
        string.setTickerData(this.parseIslandData(statusBarNotification, focusNotificationContent));
        statusBarNotification.getNotification().extras.putString("miui.ticker.data", string.getTickerData());
        string.setExtras(this.setUpDynamicIslandDataBundle(statusBarNotification));
        boolean bl = statusBarNotification.getNotification().extras.getBoolean("miui.island.updateNoFloat", false);
        bl = statusBarNotification.getNotification().extras.getBoolean("miui.enableFloat", false) && !bl;
        statusBarNotification.getNotification().extras.putBoolean("miui.island.updateNoFloat", false);
        focusNotificationContent = ((DynamicIslandWindowViewCreator)this.windowViewCreator.get()).getWindowView();
        if (focusNotificationContent != null && (focusNotificationContent = focusNotificationContent.getWindowViewController()) != null) {
            focusNotificationContent.updateDynamicIslandView((DynamicIslandData)string, bl);
        }
    }

    public final void getFocusNotificationContent(StatusBarNotification object, NotificationDynamicIslandPlugin.FocusInflationCallback focusInflationCallback) {
        o.g((Object)object, (String)"sbn");
        o.g((Object)focusInflationCallback, (String)"focusInflationCallback");
        Object object2 = this.inflateResult;
        Map<String, Boolean> map = this.authResult;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("getFocusNotificationContent inflateFinish value: ");
        stringBuilder.append(object2);
        stringBuilder.append("  authResult:");
        stringBuilder.append(map);
        Log.d((String)"FocusPlugin", (String)stringBuilder.toString());
        map = this.callbackMap;
        object2 = object.getKey();
        o.f((Object)object2, (String)"getKey(...)");
        map.put((String)object2, (Boolean)focusInflationCallback);
        object = object.getKey();
        o.f((Object)object, (String)"getKey(...)");
        FocusNotificationController.inflateFinishCallback$default(this, (String)object, null, 2, null);
    }

    public final boolean isNightModeActiveOrigin() {
        return this.isNightModeActiveOrigin;
    }

    public final boolean needExtendLifetime(String string) {
        o.g((Object)string, (String)"key");
        DynamicIslandWindowView dynamicIslandWindowView = ((DynamicIslandWindowViewCreator)this.windowViewCreator.get()).getWindowView();
        boolean bl = dynamicIslandWindowView != null ? dynamicIslandWindowView.needExtendLifetime(string) : false;
        return bl;
    }

    public final boolean onNotificationPosted(StatusBarNotification object, Context object2, Context context, NotificationListenerController.NotificationProvider notificationProvider) {
        Object object3;
        o.g((Object)object, (String)"sbn");
        o.g((Object)object2, (String)"pluginCtx");
        o.g((Object)context, (String)"sysuiCtx");
        o.g((Object)notificationProvider, (String)"mProvider");
        this.sysuiCtx = context;
        this.pluginCtx = object2;
        this.mProvider = notificationProvider;
        Object object4 = object.getKey();
        String string = NotificationUtil.getSbnTargetPkg((Context)context, (StatusBarNotification)object);
        Object object5 = new StringBuilder();
        ((StringBuilder)object5).append("plugin onNotificationPosted: ");
        ((StringBuilder)object5).append((String)object4);
        ((StringBuilder)object5).append(" ");
        ((StringBuilder)object5).append(string);
        LoggerKt.logfileAsync$default((Context)context, (String)"FocusPlugin", (String)((StringBuilder)object5).toString(), (boolean)false, (int)8, null);
        Bundle bundle = object.getNotification().extras;
        if (this.focusNotifUtils.isFocusFsiInterrupt((StatusBarNotification)object)) {
            return false;
        }
        boolean bl = !this.notificationSettingsManager.isDynamicIslandLiveUpdateBlackList(string) && MetadataUtils.isSupportLiveUpdate((Context)context) && PromotedNotificationParamUtils.isNotificationPromotedOngoing((StatusBarNotification)object);
        if (!(this.focusNotifUtils.hasCustomFocusView((StatusBarNotification)object) || bundle.containsKey("miui.focus.param") && bundle.get("miui.focus.param") != null || bl)) {
            bl = object.getNotification().isMediaNotification();
            object = new StringBuilder();
            ((StringBuilder)object).append((String)object4);
            ((StringBuilder)object).append(" is not focus notification, isMedia: ");
            ((StringBuilder)object).append(bl);
            NotificationUtil.debugLog((String)"FocusPlugin", (String)((StringBuilder)object).toString());
            if (o.c((Object)this.inflateResult.get(object4), (Object)Boolean.TRUE)) {
                object = this.inflateResult;
                o.d((Object)object4);
                object.put(object4, Boolean.FALSE);
            }
            if ((object2 = this.sbnMap.get(object4)) != null) {
                object = this.focusNotifUtils;
                o.d((Object)bundle);
                ((FocusNotifUtils)object).resetAllParam(bundle);
                object = this.notificationMap.get(object4);
                if (object != null) {
                    object.reset();
                    o.d((Object)object4);
                    this.inflateFinishCallback((String)object4, (FocusNotificationContent)object);
                }
                if (!bl && (object = (object = (DynamicIslandWindowViewCreator)this.windowViewCreator.get()) != null ? object.getWindowView() : null) != null) {
                    object = object2.getNotification();
                    bl = object != null && (object = ((Notification)object).extras) != null ? object.getBoolean("miui.island.updateNoFloat", false) : false;
                    object = (DynamicIslandWindowViewCreator)this.windowViewCreator.get();
                    if (object != null && (object = object.getWindowView()) != null && (object = object.getWindowViewController()) != null) {
                        o.d((Object)object4);
                        object.removeDynamicIslandView((String)object4, bl);
                    }
                }
            }
            return false;
        }
        bundle.putBoolean("miui.focus.isPromoted", bl);
        if (bl) {
            object5 = this.focusNotifUtils;
            o.d((Object)bundle);
            ((FocusNotifUtils)object5).resetAllParam(bundle);
            PromotedNotificationParamUtils.INSTANCE.updatePromotedNotificationBundle(this.context, bundle, (StatusBarNotification)object, false);
        }
        if (!this.notificationMap.containsKey(object4)) {
            object5 = new FocusNotificationContentImpl();
            object5.setKey((String)object4);
            object5.setSbn((StatusBarNotification)object);
            object3 = this.notificationMap;
            o.d((Object)object4);
            object3.put(object4, object5);
        } else {
            object5 = this.notificationMap.get(object4);
            if (object5 != null) {
                object5.setSbn((StatusBarNotification)object);
            }
        }
        object4 = this.sbnMap;
        object3 = object.getKey();
        o.f((Object)object3, (String)"getKey(...)");
        object4.put(object3, object);
        bl = this.focusNotifPreHandler.onNotificationPosted((StatusBarNotification)object, this.isFlipDevice, (Context)object2, context, (FocusNotificationContent)object5, this.inflateCallBack, notificationProvider);
        o.d((Object)string);
        o.d((Object)bundle);
        this.fetchAuthResult(context, (StatusBarNotification)object, string, bundle, this.inflateCallBack);
        if (object.getNotification().extras.getBoolean("miui.focus.isFocus") && this.hideDeletedFocusController.suppressDeletedFocus((StatusBarNotification)object)) {
            return true;
        }
        if (!object.getNotification().extras.getBoolean("show_notification", true)) {
            return true;
        }
        object2 = this.inflateResult;
        object = new StringBuilder();
        ((StringBuilder)object).append("onNotificationPosted ");
        ((StringBuilder)object).append(object2);
        ((StringBuilder)object).append(" ");
        ((StringBuilder)object).append(string);
        Log.e((String)"FocusPlugin", (String)((StringBuilder)object).toString());
        return bl;
    }

    public final boolean onNotificationRemoved(StatusBarNotification statusBarNotification, boolean bl) {
        Object var6_3 = null;
        String string = statusBarNotification != null ? statusBarNotification.getKey() : null;
        Object object = this.notificationMap;
        Object object2 = statusBarNotification != null ? statusBarNotification.getKey() : null;
        object = object.get(object2);
        object2 = new StringBuilder();
        ((StringBuilder)object2).append("onNotificationRemoved ");
        ((StringBuilder)object2).append(string);
        ((StringBuilder)object2).append(", content: ");
        ((StringBuilder)object2).append(object);
        Log.i((String)"FocusPlugin", (String)((StringBuilder)object2).toString());
        if (statusBarNotification != null && (string = statusBarNotification.getKey()) != null && (string = this.notificationMap.get(string)) != null) {
            this.focusNotifPreHandler.onNotificationRemoved(statusBarNotification, (FocusNotificationContent)string);
            this.focusNotifUtils.onNotificationRemoved(statusBarNotification);
        }
        object2 = statusBarNotification != null && (string = statusBarNotification.getNotification()) != null && (string = ((Notification)string).extras) != null ? Integer.valueOf(string.getInt("miui.focus.removeReason")) : null;
        string = statusBarNotification != null ? statusBarNotification.getKey() : null;
        object = string;
        if (string == null) {
            object = "";
        }
        this.removeByKey((String)object);
        if (bl) {
            object = this.islandTimeoutRemovedList;
            string = var6_3;
            if (statusBarNotification != null) {
                string = statusBarNotification.getKey();
            }
            E.a((Object)object).remove(string);
        }
        this.hideDeletedFocusController.onNotificationRemoved(statusBarNotification, (Integer)object2);
        return false;
    }

    public final void removeExtendLifetime(String string) {
        o.g((Object)string, (String)"key");
        DynamicIslandWindowView dynamicIslandWindowView = ((DynamicIslandWindowViewCreator)this.windowViewCreator.get()).getWindowView();
        if (dynamicIslandWindowView != null) {
            dynamicIslandWindowView.removeExtendLifetime(string);
        }
    }

    public final void setNightModeActiveOrigin(boolean bl) {
        this.isNightModeActiveOrigin = bl;
    }
}
