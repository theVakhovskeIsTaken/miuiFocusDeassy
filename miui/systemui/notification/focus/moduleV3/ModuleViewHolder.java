/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  G0.k
 *  G0.s
 *  K0.d
 *  K0.g
 *  L0.c
 *  M0.b
 *  U0.a
 *  U0.o
 *  U0.p
 *  android.app.Notification$Action
 *  android.app.Notification$Action$Builder
 *  android.app.PendingIntent
 *  android.app.PendingIntent$CanceledException
 *  android.content.Context
 *  android.content.Intent
 *  android.content.res.ColorStateList
 *  android.content.res.Configuration
 *  android.graphics.Color
 *  android.graphics.drawable.Icon
 *  android.os.Bundle
 *  android.os.SystemClock
 *  android.os.UserHandle
 *  android.service.notification.StatusBarNotification
 *  android.text.Html
 *  android.text.TextUtils
 *  android.util.Log
 *  android.view.View
 *  android.view.View$OnAttachStateChangeListener
 *  android.view.View$OnClickListener
 *  android.view.ViewGroup
 *  android.view.ViewGroup$LayoutParams
 *  android.view.ViewTreeObserver$OnPreDrawListener
 *  android.widget.Button
 *  android.widget.FrameLayout
 *  android.widget.FrameLayout$LayoutParams
 *  android.widget.ImageView
 *  android.widget.LinearLayout$LayoutParams
 *  android.widget.TextView
 *  android.widget.TextView$BufferType
 *  androidx.core.view.AccessibilityDelegateCompat
 *  androidx.core.view.ViewCompat
 *  androidx.core.view.accessibility.AccessibilityNodeInfoCompat
 *  com.android.systemui.miui.notification.R$dimen
 *  com.android.systemui.miui.notification.R$drawable
 *  com.android.systemui.miui.notification.R$id
 *  f1.E
 *  f1.F
 *  f1.Q
 *  f1.f
 *  i1.K
 *  i1.f
 *  i1.g
 *  i1.h
 *  i1.u
 *  kotlin.jvm.internal.o
 *  miui.systemui.autodensity.AutoDensityController
 *  miui.systemui.autodensity.AutoDensityController$OnDensityChangeListener
 *  miui.systemui.dynamicisland.events.DynamicIslandEventTracker
 *  miui.systemui.dynamicisland.events.DynamicIslandEventTracker$Companion
 *  miui.systemui.util.CommonUtils
 *  miui.systemui.util.ContextUtils
 *  miui.systemui.widget.StatusProgressLayout
 *  miuix.colorful.texteffect.CharChangeProcessor
 *  miuix.colorful.texteffect.HyperChronometer
 *  miuix.colorful.texteffect.TextChangeHelper
 *  miuix.colorful.texteffect.TextChangeProcessor
 *  miuix.colorful.texteffect.TimerTextEffectView
 *  systemui.plugin.eventtracking.EventTracker
 */
package miui.systemui.notification.focus.moduleV3;

import G0.k;
import G0.s;
import K0.d;
import L0.c;
import M0.b;
import U0.a;
import U0.p;
import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.graphics.Color;
import android.graphics.drawable.Icon;
import android.os.Bundle;
import android.os.SystemClock;
import android.os.UserHandle;
import android.service.notification.StatusBarNotification;
import android.text.Html;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import com.android.systemui.miui.notification.R;
import f1.F;
import f1.Q;
import f1.f;
import i1.K;
import i1.g;
import i1.h;
import i1.u;
import kotlin.jvm.internal.o;
import miui.systemui.autodensity.AutoDensityController;
import miui.systemui.dynamicisland.events.DynamicIslandEventTracker;
import miui.systemui.notification.focus.FocusIconCache;
import miui.systemui.notification.focus.model.ActionInfo;
import miui.systemui.notification.focus.model.BgInfo;
import miui.systemui.notification.focus.model.HighlightInfoV3;
import miui.systemui.notification.focus.model.HintInfo;
import miui.systemui.notification.focus.model.Template;
import miui.systemui.notification.focus.model.TextAndColorInfo;
import miui.systemui.notification.focus.model.TimerInfo;
import miui.systemui.notification.focus.moduleV3.C;
import miui.systemui.notification.focus.moduleV3.D;
import miui.systemui.notification.focus.moduleV3.E;
import miui.systemui.notification.focus.moduleV3.ModuleViewHolder;
import miui.systemui.notification.focus.moduleV3.ext.ModuleViewHolderExtKt;
import miui.systemui.notification.focus.templateV3.TemplateFactoryV3;
import miui.systemui.util.CommonUtils;
import miui.systemui.util.ContextUtils;
import miui.systemui.widget.StatusProgressLayout;
import miuix.colorful.texteffect.CharChangeProcessor;
import miuix.colorful.texteffect.HyperChronometer;
import miuix.colorful.texteffect.TextChangeHelper;
import miuix.colorful.texteffect.TextChangeProcessor;
import miuix.colorful.texteffect.TimerTextEffectView;
import systemui.plugin.eventtracking.EventTracker;

public class ModuleViewHolder
implements AutoDensityController.OnDensityChangeListener {
    public static final Companion Companion = new Object(null){
        {
            this();
        }

        public final boolean isContinuousClick(String string) {
            if (string == null) {
                return true;
            }
            long l = System.currentTimeMillis();
            long l2 = l - lastClickTime;
            if (0L <= l2 && l2 < 100L && TextUtils.equals((CharSequence)lastClickNotif, (CharSequence)string)) {
                return true;
            }
            lastClickNotif = string;
            lastClickTime = l;
            return false;
        }
    };
    private static final long INTERNAL = 100L;
    public static final String TAG = "ModuleViewHolder";
    public static final int TYPE_HIDE_TIMER = 0;
    public static final int TYPE_NEGATIVE_PAUSE = -2;
    public static final int TYPE_NEGATIVE_RUN = -1;
    public static final int TYPE_POSITIVE_PAUSE = 2;
    public static final int TYPE_POSITIVE_RUN = 1;
    private static String lastClickNotif = "";
    private static long lastClickTime;
    private Bundle actionBundle;
    private ActionInfo actionInfo;
    private Bundle bitmapBundle;
    private Integer colorContentBg;
    private final i1.f compressChanged;
    private String content;
    private Integer contentColor;
    private Integer contentColorDark;
    private final Context ctx;
    private final u dataChanged;
    private String extraTitle;
    private Integer extraTitleColor;
    private Integer extraTitleColorDark;
    private String highLightText;
    private Integer highLightTextColor;
    private Integer highLightTextColorDark;
    private Integer highLightbgColor;
    private Integer highLightbgColorDark;
    private boolean ignoreTextColor;
    private final boolean isDark;
    private int lastWidth;
    private String module;
    private View.OnAttachStateChangeListener onAttachStateChangeListener;
    private ViewTreeObserver.OnPreDrawListener onPreDrawListener;
    private Integer primaryColor;
    private Integer primaryColorDark;
    private String primaryText;
    private final ViewGroup rootView;
    private StatusBarNotification sbn;
    private f1.E scope;
    private Integer secondaryColor;
    private Integer secondaryColorDark;
    private String secondaryText;
    private Boolean showSecondaryLine;
    private String specialTitle;
    private Integer specialTitleColor;
    private Integer specialTitleColorDark;
    private String subContent;
    private Integer subContentColor;
    private Integer subContentColorDark;
    private Integer subTitleColor;
    private Integer subTitleColorDark;
    private String subtitle;
    private final Context sysuiCtx;
    private Template template;
    private Long timerCurrent;
    private boolean timerInitialized;
    private Long timerSystemCurrent;
    private Long timerTotal;
    private Integer timerType;
    private Long timerWhen;
    private String title;
    private Integer titleColor;
    private Integer titleColorDark;
    private View view;
    private final u widthChanged;

    public ModuleViewHolder(Context context, Context object, ViewGroup viewGroup, boolean bl) {
        o.g((Object)context, (String)"ctx");
        o.g((Object)object, (String)"sysuiCtx");
        o.g((Object)viewGroup, (String)"rootView");
        this.ctx = context;
        this.sysuiCtx = object;
        this.rootView = viewGroup;
        this.isDark = bl;
        object = Boolean.FALSE;
        this.showSecondaryLine = object;
        this.timerType = 0;
        this.timerWhen = System.currentTimeMillis();
        this.timerTotal = 0L;
        this.timerSystemCurrent = System.currentTimeMillis();
        this.scope = F.a((K0.g)Q.c().z());
        context = K.a((Object)object);
        this.dataChanged = context;
        object = K.a((Object)object);
        this.widthChanged = object;
        this.compressChanged = h.i((i1.f)context, (i1.f)object, (p)new p(null){
            boolean Z$0;
            boolean Z$1;
            int label;

            public final Object invoke(boolean bl, boolean bl2, d object) {
                object = new /* invalid duplicate definition of identical inner class */;
                object.Z$0 = bl;
                object.Z$1 = bl2;
                return object.invokeSuspend(s.a);
            }

            public final Object invokeSuspend(Object object) {
                c.c();
                if (this.label == 0) {
                    k.b((Object)object);
                    boolean bl = this.Z$0;
                    boolean bl2 = this.Z$1;
                    bl2 = bl || bl2;
                    return b.a((boolean)bl2);
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        });
    }

    public static /* synthetic */ void a(Notification.Action action, ModuleViewHolder moduleViewHolder, boolean bl, StatusBarNotification statusBarNotification, View view) {
        ModuleViewHolder.setAction$lambda$15(action, moduleViewHolder, bl, statusBarNotification, view);
    }

    public static final /* synthetic */ ViewTreeObserver.OnPreDrawListener access$getOnPreDrawListener$p(ModuleViewHolder moduleViewHolder) {
        return moduleViewHolder.onPreDrawListener;
    }

    public static final /* synthetic */ void access$setOnPreDrawListener$p(ModuleViewHolder moduleViewHolder, ViewTreeObserver.OnPreDrawListener onPreDrawListener) {
        moduleViewHolder.onPreDrawListener = onPreDrawListener;
    }

    public static /* synthetic */ void b(Notification.Action action, ModuleViewHolder moduleViewHolder, boolean bl, StatusBarNotification statusBarNotification, View view) {
        ModuleViewHolder.setAction$lambda$18(action, moduleViewHolder, bl, statusBarNotification, view);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private final Notification.Action buildAction(ActionInfo actionInfo, StatusBarNotification statusBarNotification, boolean bl) {
        Object object;
        block19: {
            Exception exception2;
            block17: {
                Object object2;
                block16: {
                    String string;
                    block15: {
                        int n;
                        block20: {
                            block18: {
                                string = actionInfo.getAction();
                                object = null;
                                object2 = null;
                                if (string == null) break block18;
                                statusBarNotification = this.actionBundle;
                                if (statusBarNotification != null) {
                                    object = (Notification.Action)statusBarNotification.getParcelable(string);
                                }
                                break block19;
                            }
                            if (actionInfo.getActionTitle() == null) break block19;
                            object = actionInfo.getActionIntentType();
                            n = object != null ? (Integer)object : 1;
                            string = actionInfo.getActionIntent();
                            object = string;
                            if (string == null) {
                                object = "";
                            }
                            object = Intent.parseUri((String)object, (int)1);
                            if (n == 1) break block20;
                            if (n != 2) {
                                if (n != 3) {
                                    object = object2;
                                    break block15;
                                } else {
                                    object2 = statusBarNotification.getUser();
                                    o.f((Object)object2, (String)"getUser(...)");
                                    object2 = ModuleViewHolderExtKt.getContextAsUser(object2, this.sysuiCtx);
                                    n = (int)statusBarNotification.getPostTime();
                                    object = PendingIntent.getService((Context)object2, (int)n, (Intent)object, (int)0xC000000);
                                }
                                break block15;
                            } else {
                                object2 = statusBarNotification.getUser();
                                o.f((Object)object2, (String)"getUser(...)");
                                object2 = ModuleViewHolderExtKt.getContextAsUser(object2, this.sysuiCtx);
                                n = (int)statusBarNotification.getPostTime();
                                object = PendingIntent.getBroadcast((Context)object2, (int)n, (Intent)object, (int)0xC000000);
                            }
                            break block15;
                        }
                        object2 = statusBarNotification.getUser();
                        o.f((Object)object2, (String)"getUser(...)");
                        object2 = ModuleViewHolderExtKt.getContextAsUser(object2, this.sysuiCtx);
                        n = (int)statusBarNotification.getPostTime();
                        object = PendingIntent.getActivity((Context)object2, (int)n, (Intent)object, (int)0xC000000);
                    }
                    if (bl) {
                        string = this.getIcon(actionInfo.getActionIconDark(), statusBarNotification);
                        object2 = string;
                        if (string == null) {
                            object2 = this.getIcon(actionInfo.getActionIcon(), statusBarNotification);
                        }
                    } else {
                        object2 = this.getIcon(actionInfo.getActionIcon(), statusBarNotification);
                    }
                    statusBarNotification = new Notification.Action.Builder((Icon)object2, (CharSequence)actionInfo.getActionTitle(), (PendingIntent)object);
                    statusBarNotification = statusBarNotification.build();
                    try {
                        statusBarNotification.title = actionInfo.getActionTitle();
                        object = statusBarNotification.getExtras();
                        if (object == null) break block16;
                        object.putString("colorTitle", actionInfo.getActionTitleColor());
                    }
                    catch (Exception exception2) {
                        break block17;
                    }
                }
                if ((object = statusBarNotification.getExtras()) != null) {
                    object.putString("colorBg", actionInfo.getActionBgColor());
                }
                if ((object = statusBarNotification.getExtras()) != null) {
                    object.putString("colorTitleDark", actionInfo.getActionTitleColorDark());
                }
                object2 = statusBarNotification.getExtras();
                object = statusBarNotification;
                if (object2 != null) {
                    object2.putString("colorBgDark", actionInfo.getActionBgColorDark());
                    object = statusBarNotification;
                }
                break block19;
            }
            exception2.printStackTrace();
            object = statusBarNotification;
        }
        bl = actionInfo.getClickWithCollapse();
        if (object != null && (actionInfo = object.getExtras()) != null) {
            actionInfo.putBoolean("click_with_collapse", bl);
        }
        return object;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private final Notification.Action buildAction(Template object, StatusBarNotification object2, boolean bl) {
        Object object3;
        block25: {
            Exception exception2;
            block23: {
                Object var7_7;
                Object object4;
                block22: {
                    int n;
                    block28: {
                        block27: {
                            block26: {
                                block24: {
                                    object4 = ((Template)object).getHintInfo();
                                    object3 = null;
                                    var7_7 = null;
                                    if ((object4 = object4 != null && (object4 = ((HintInfo)object4).getActionInfo()) != null ? ((ActionInfo)object4).getAction() : null) == null) break block24;
                                    object = this.actionBundle;
                                    if (object != null) {
                                        object3 = (Notification.Action)object.getParcelable((String)object4);
                                    }
                                    break block25;
                                }
                                object4 = ((Template)object).getHintInfo();
                                object4 = object4 != null && (object4 = ((HintInfo)object4).getActionInfo()) != null ? ((ActionInfo)object4).getActionTitle() : null;
                                if (object4 == null) break block25;
                                object3 = ((Template)object).getHintInfo().getActionInfo();
                                n = object3 != null && (object3 = ((ActionInfo)object3).getActionIntentType()) != null ? (Integer)object3 : 1;
                                object3 = ((Template)object).getHintInfo().getActionInfo();
                                if (object3 == null) break block26;
                                object3 = object4 = ((ActionInfo)object3).getActionIntent();
                                if (object4 != null) break block27;
                            }
                            object3 = "";
                        }
                        object3 = Intent.parseUri((String)object3, (int)1);
                        if (n == 1) break block28;
                        if (n != 2) {
                            if (n != 3) {
                                object3 = null;
                                break block22;
                            } else {
                                object4 = object2.getUser();
                                o.f((Object)object4, (String)"getUser(...)");
                                object4 = ModuleViewHolderExtKt.getContextAsUser((UserHandle)object4, this.sysuiCtx);
                                n = (int)object2.getPostTime();
                                object3 = PendingIntent.getService((Context)object4, (int)n, (Intent)object3, (int)0xC000000);
                            }
                            break block22;
                        } else {
                            object4 = object2.getUser();
                            o.f((Object)object4, (String)"getUser(...)");
                            object4 = ModuleViewHolderExtKt.getContextAsUser((UserHandle)object4, this.sysuiCtx);
                            n = (int)object2.getPostTime();
                            object3 = PendingIntent.getBroadcast((Context)object4, (int)n, (Intent)object3, (int)0xC000000);
                        }
                        break block22;
                    }
                    object4 = object2.getUser();
                    o.f((Object)object4, (String)"getUser(...)");
                    object4 = ModuleViewHolderExtKt.getContextAsUser((UserHandle)object4, this.sysuiCtx);
                    n = (int)object2.getPostTime();
                    object3 = PendingIntent.getActivity((Context)object4, (int)n, (Intent)object3, (int)0xC000000);
                }
                if (bl) {
                    object4 = ((Template)object).getHintInfo().getActionInfo();
                    object4 = object4 != null ? ((ActionInfo)object4).getActionIconDark() : null;
                    Icon icon = this.getIcon((String)object4, (StatusBarNotification)object2);
                    object4 = icon;
                    if (icon == null) {
                        object4 = ((Template)object).getHintInfo().getActionInfo();
                        object4 = object4 != null ? ((ActionInfo)object4).getActionIcon() : null;
                        object4 = this.getIcon((String)object4, (StatusBarNotification)object2);
                    }
                } else {
                    object4 = ((Template)object).getHintInfo().getActionInfo();
                    object4 = object4 != null ? ((ActionInfo)object4).getActionIcon() : null;
                    object4 = this.getIcon((String)object4, (StatusBarNotification)object2);
                }
                object2 = (object2 = ((Template)object).getHintInfo().getActionInfo()) != null ? ((ActionInfo)object2).getActionTitle() : null;
                object2 = new Notification.Action.Builder((Icon)object4, (CharSequence)object2, (PendingIntent)object3);
                object3 = object2.build();
                try {
                    object2 = ((Template)object).getHintInfo().getActionInfo();
                    object2 = object2 != null ? ((ActionInfo)object2).getActionTitle() : null;
                }
                catch (Exception exception2) {
                    break block23;
                }
                ((Notification.Action)object3).title = object2;
                object4 = object3.getExtras();
                if (object4 != null) {
                    object2 = ((Template)object).getHintInfo().getActionInfo();
                    object2 = object2 != null ? ((ActionInfo)object2).getActionTitleColor() : null;
                    object4.putString("colorTitle", (String)object2);
                }
                if ((object4 = object3.getExtras()) != null) {
                    object2 = ((Template)object).getHintInfo().getActionInfo();
                    object2 = object2 != null ? ((ActionInfo)object2).getActionBgColor() : null;
                    object4.putString("colorBg", (String)object2);
                }
                if ((object4 = object3.getExtras()) != null) {
                    object2 = ((Template)object).getHintInfo().getActionInfo();
                    object2 = object2 != null ? ((ActionInfo)object2).getActionTitleColorDark() : null;
                    object4.putString("colorTitleDark", (String)object2);
                }
                if ((object2 = object3.getExtras()) != null) {
                    object4 = ((Template)object).getHintInfo().getActionInfo();
                    object = var7_7;
                    if (object4 != null) {
                        object = ((ActionInfo)object4).getActionBgColorDark();
                    }
                    object2.putString("colorBgDark", (String)object);
                }
                break block25;
            }
            exception2.printStackTrace();
        }
        if ((object = this.actionInfo) != null) {
            bl = ((ActionInfo)object).getClickWithCollapse();
            if (object3 != null && (object = object3.getExtras()) != null) {
                object.putBoolean("click_with_collapse", bl);
            }
        }
        return object3;
    }

    public static /* synthetic */ Notification.Action buildAction$default(ModuleViewHolder moduleViewHolder, ActionInfo actionInfo, StatusBarNotification statusBarNotification, boolean bl, int n, Object object) {
        if (object == null) {
            if ((n & 4) != 0) {
                bl = false;
            }
            return moduleViewHolder.buildAction(actionInfo, statusBarNotification, bl);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: buildAction");
    }

    public static /* synthetic */ Notification.Action buildAction$default(ModuleViewHolder moduleViewHolder, Template template, StatusBarNotification statusBarNotification, boolean bl, int n, Object object) {
        if (object == null) {
            if ((n & 4) != 0) {
                bl = false;
            }
            return moduleViewHolder.buildAction(template, statusBarNotification, bl);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: buildAction");
    }

    private final void calculateTimer() {
        long l2 = System.currentTimeMillis();
        Comparable<Long> comparable = this.timerSystemCurrent;
        o.d((Object)comparable);
        if (l2 - (Long)comparable > 1000L) {
            Comparable<Long> comparable2 = this.timerSystemCurrent;
            comparable = new StringBuilder();
            ((StringBuilder)comparable).append("Timer delay too large, current:");
            ((StringBuilder)comparable).append(l2);
            ((StringBuilder)comparable).append(" timerSystemCurrent:");
            ((StringBuilder)comparable).append(comparable2);
            Log.d((String)TAG, (String)((StringBuilder)comparable).toString());
            this.timerSystemCurrent = l2;
            comparable = this.timerType;
            o.d(comparable);
            if ((Integer)comparable > 0) {
                comparable = this.timerSystemCurrent;
                o.d(comparable);
                l2 = (Long)comparable;
                comparable = this.timerWhen;
                o.d(comparable);
                comparable = l2 - (Long)comparable;
            } else {
                comparable = this.timerWhen;
                o.d(comparable);
                l2 = (Long)comparable;
                comparable = this.timerSystemCurrent;
                o.d(comparable);
                comparable = l2 - (Long)comparable;
            }
            this.timerCurrent = comparable;
            comparable2 = new StringBuilder();
            ((StringBuilder)comparable2).append("normalRemoteViewsBuild: calculateTimer :timerCurrent:");
            ((StringBuilder)comparable2).append(comparable);
            Log.d((String)TAG, (String)((StringBuilder)comparable2).toString());
        }
    }

    public static /* synthetic */ Context getContext$default(ModuleViewHolder moduleViewHolder, boolean bl, int n, Object object) {
        if (object == null) {
            if ((n & 1) != 0) {
                bl = false;
            }
            return moduleViewHolder.getContext(bl);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getContext");
    }

    public static /* synthetic */ void handleBtnClick$default(ModuleViewHolder moduleViewHolder, PendingIntent pendingIntent, Notification.Action action, Context context, View view, boolean bl, StatusBarNotification statusBarNotification, boolean bl2, int n, Object object) {
        if (object == null) {
            if ((n & 0x40) != 0) {
                bl2 = true;
            }
            moduleViewHolder.handleBtnClick(pendingIntent, action, context, view, bl, statusBarNotification, bl2);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: handleBtnClick");
    }

    private final void listenWidthChanged() {
        View.OnAttachStateChangeListener onAttachStateChangeListener;
        View view = this.view;
        if (view != null) {
            view.removeOnAttachStateChangeListener(this.onAttachStateChangeListener);
        }
        this.onAttachStateChangeListener = onAttachStateChangeListener = new View.OnAttachStateChangeListener(this){
            final ModuleViewHolder this$0;
            {
                this.this$0 = moduleViewHolder;
            }

            public static /* synthetic */ boolean a(ModuleViewHolder moduleViewHolder) {
                return listenWidthChanged.1.onViewAttachedToWindow$lambda$0(moduleViewHolder);
            }

            private static final boolean onViewAttachedToWindow$lambda$0(ModuleViewHolder moduleViewHolder) {
                o.g((Object)moduleViewHolder, (String)"this$0");
                View view = moduleViewHolder.getView();
                if (view != null && moduleViewHolder.getLastWidth() == view.getMeasuredWidth()) {
                    moduleViewHolder.getWidthChanged().setValue((Object)Boolean.FALSE);
                    return true;
                }
                moduleViewHolder.getWidthChanged().setValue((Object)Boolean.TRUE);
                view = moduleViewHolder.getView();
                int n = view != null ? view.getMeasuredWidth() : 0;
                moduleViewHolder.setLastWidth(n);
                return true;
            }

            public void onViewAttachedToWindow(View object) {
                o.g((Object)object, (String)"p0");
                object = this.this$0.getView();
                if (object != null && (object = object.getViewTreeObserver()) != null) {
                    object.removeOnPreDrawListener(ModuleViewHolder.access$getOnPreDrawListener$p(this.this$0));
                }
                object = this.this$0;
                ModuleViewHolder.access$setOnPreDrawListener$p((ModuleViewHolder)object, (ViewTreeObserver.OnPreDrawListener)new E((ModuleViewHolder)object));
                object = this.this$0.getView();
                if (object != null && (object = object.getViewTreeObserver()) != null) {
                    object.addOnPreDrawListener(ModuleViewHolder.access$getOnPreDrawListener$p(this.this$0));
                }
            }

            public void onViewDetachedFromWindow(View view) {
                o.g((Object)view, (String)"p0");
                view = this.this$0.getView();
                if (view != null && (view = view.getViewTreeObserver()) != null) {
                    view.removeOnPreDrawListener(ModuleViewHolder.access$getOnPreDrawListener$p(this.this$0));
                }
            }
        };
        view = this.view;
        if (view != null) {
            view.addOnAttachStateChangeListener(onAttachStateChangeListener);
        }
    }

    /*
     * WARNING - void declaration
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private final Integer parseColorFromExtras(Bundle object, String string) {
        String string2;
        Integer n;
        Integer n2 = n = null;
        if (object == null) return n2;
        try {
            void var2_4;
            string2 = object.getString((String)var2_4);
            n2 = n;
            if (string2 == null) return n2;
        }
        catch (Exception exception) {
            return n;
        }
        return Color.parseColor((String)string2);
    }

    private static final void setAction$lambda$15(Notification.Action action, ModuleViewHolder moduleViewHolder, boolean bl, StatusBarNotification statusBarNotification, View view) {
        block5: {
            o.g((Object)moduleViewHolder, (String)"this$0");
            o.g((Object)statusBarNotification, (String)"$sbn");
            PendingIntent pendingIntent = action.actionIntent;
            if (pendingIntent != null) {
                view = moduleViewHolder.view;
                if (view == null) break block5;
                try {
                    if (ModuleViewHolderExtKt.sendWithCollapse(pendingIntent, action, moduleViewHolder.sysuiCtx, view, bl, statusBarNotification)) {
                        moduleViewHolder.track(bl, action);
                    }
                }
                catch (PendingIntent.CanceledException canceledException) {
                    Log.e((String)TAG, (String)"PendingIntent.send() failed", (Throwable)canceledException);
                }
            }
        }
    }

    private static final void setAction$lambda$18(Notification.Action action, ModuleViewHolder moduleViewHolder, boolean bl, StatusBarNotification statusBarNotification, View view) {
        block5: {
            o.g((Object)moduleViewHolder, (String)"this$0");
            o.g((Object)statusBarNotification, (String)"$sbn");
            PendingIntent pendingIntent = action.actionIntent;
            if (pendingIntent != null) {
                view = moduleViewHolder.view;
                if (view == null) break block5;
                try {
                    if (ModuleViewHolderExtKt.sendWithCollapse(pendingIntent, action, moduleViewHolder.sysuiCtx, view, bl, statusBarNotification)) {
                        moduleViewHolder.track(bl, action);
                    }
                }
                catch (PendingIntent.CanceledException canceledException) {
                    Log.e((String)TAG, (String)"PendingIntent.send() failed", (Throwable)canceledException);
                }
            }
        }
    }

    public static /* synthetic */ void setActionData$default(ModuleViewHolder moduleViewHolder, Template template, StatusBarNotification statusBarNotification, boolean bl, int n, Object object) {
        if (object == null) {
            if ((n & 4) != 0) {
                bl = false;
            }
            moduleViewHolder.setActionData(template, statusBarNotification, bl);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setActionData");
    }

    private final void setButtonAccessibilityDelegate(View view) {
        if (view != null) {
            ViewCompat.setAccessibilityDelegate((View)view, (AccessibilityDelegateCompat)new AccessibilityDelegateCompat(){

                public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
                    o.g((Object)view, (String)"host");
                    o.g((Object)accessibilityNodeInfoCompat, (String)"info");
                    super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
                    accessibilityNodeInfoCompat.setClassName((CharSequence)Button.class.getName());
                }
            });
        }
    }

    /*
     * Unable to fully structure code
     */
    private final void setButtonContainerBackground(Notification.Action var1_1, boolean var2_3) {
        block13: {
            block12: {
                block11: {
                    block10: {
                        var4_4 = null;
                        if (!var2_3) ** GOTO lbl15
                        var1_1 = var1_1.getExtras();
                        if (var1_1 == null) break block10;
                        var1_1 = var1_1.getString("colorBgDark");
                        break block11;
                    }
                    var1_1 = null;
                }
                var3_5 = Color.parseColor((String)var1_1);
                ** GOTO lbl24
lbl15:
                // 1 sources

                if ((var1_1 = var1_1.getExtras()) == null) break block12;
                var1_1 = var1_1.getString("colorBg");
                break block13;
            }
            var1_1 = null;
        }
        try {
            var3_5 = Color.parseColor((String)var1_1);
lbl24:
            // 2 sources

            var1_1 = var3_5;
        }
        catch (Exception var1_2) {
            var1_1 = null;
        }
        var5_6 = this.view;
        if (var5_6 != null) {
            var4_4 = (FrameLayout)var5_6.findViewById(R.id.focus_button_container);
        }
        if (var1_1 != null) {
            if (var4_4 != null) {
                var4_4.setBackgroundResource(R.drawable.focus_button_background_no_alpha);
            }
            if (var4_4 != null) {
                var4_4.setBackgroundTintList(ColorStateList.valueOf((int)var1_1.intValue()));
            }
        }
    }

    public static /* synthetic */ void setButtonContainerBackground$default(ModuleViewHolder moduleViewHolder, Notification.Action action, boolean bl, int n, Object object) {
        if (object == null) {
            if ((n & 2) != 0) {
                bl = false;
            }
            moduleViewHolder.setButtonContainerBackground(action, bl);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setButtonContainerBackground");
    }

    public static /* synthetic */ void setTimerData$default(ModuleViewHolder moduleViewHolder, int n, StatusBarNotification statusBarNotification, int n2, Object object) {
        if (object == null) {
            if ((n2 & 1) != 0) {
                n = R.id.chronometer;
            }
            moduleViewHolder.setTimerData(n, statusBarNotification);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setTimerData");
    }

    private final void track(boolean bl, Notification.Action object) {
        block4: {
            Boolean bl2;
            String string;
            StatusBarNotification statusBarNotification;
            Context context;
            DynamicIslandEventTracker.Companion companion;
            CharSequence charSequence;
            block6: {
                block5: {
                    String string2 = null;
                    charSequence = object != null ? object.title : null;
                    if (!bl) break block4;
                    companion = DynamicIslandEventTracker.Companion;
                    context = this.ctx;
                    statusBarNotification = this.sbn;
                    string = EventTracker.Companion.getScreenType(context);
                    bl2 = Boolean.FALSE;
                    StatusBarNotification statusBarNotification2 = this.sbn;
                    object = string2;
                    if (statusBarNotification2 != null) {
                        object = statusBarNotification2.getOpPkg();
                    }
                    if (charSequence == null) break block5;
                    string2 = ((Object)charSequence).toString();
                    charSequence = string2;
                    if (string2 != null) break block6;
                }
                charSequence = "null";
            }
            companion.trackExpandedClick(context, statusBarNotification, string, bl2, (String)object, (String)charSequence, true);
        }
    }

    private final void updateBundle(StatusBarNotification statusBarNotification) {
        this.actionBundle = statusBarNotification.getNotification().extras.getBundle("miui.focus.actions");
        this.bitmapBundle = statusBarNotification.getNotification().extras.getBundle("miui.focus.pics");
    }

    private final void updateButtonView(Notification.Action action, boolean bl, StatusBarNotification object, Template object2) {
        Object var8_5 = null;
        Object var7_6 = null;
        if (bl) {
            object2 = (object2 = ((Template)object2).getHintInfo()) != null && (object2 = ((HintInfo)object2).getActionInfo()) != null ? ((ActionInfo)object2).getActionIconDark() : null;
            object2 = this.getIcon((String)object2, (StatusBarNotification)object);
            object = object2;
            if (object2 == null) {
                object = action.getIcon();
            }
        } else {
            object2 = (object2 = ((Template)object2).getHintInfo()) != null && (object2 = ((HintInfo)object2).getActionInfo()) != null ? ((ActionInfo)object2).getActionIcon() : null;
            object2 = this.getIcon((String)object2, (StatusBarNotification)object);
            object = object2;
            if (object2 == null) {
                object = action.getIcon();
            }
        }
        Object object3 = (object2 = this.view) != null ? (ImageView)object2.findViewById(R.id.button_icon) : null;
        object2 = this.view;
        TextView textView = object2 != null ? (TextView)object2.findViewById(R.id.focus_button_title) : null;
        if (object3 != null) {
            object2 = textView != null ? textView.getLayoutParams() : null;
            if (object != null) {
                object3.setVisibility(0);
                object3.setImageIcon((Icon)object);
                object3 = textView != null ? textView.getLayoutParams() : null;
                object = object2;
                if (object3 instanceof LinearLayout.LayoutParams) {
                    object = textView.getLayoutParams();
                    o.e((Object)object, (String)"null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
                    object = (LinearLayout.LayoutParams)object;
                    object.setMarginStart((int)this.ctx.getResources().getDimension(R.dimen.focus_notify_button_with_icon_margin_start));
                }
                object2 = var7_6;
                if (textView != null) {
                    object2 = textView.getLayoutParams();
                }
                if (object2 instanceof FrameLayout.LayoutParams) {
                    object = textView.getLayoutParams();
                    o.e((Object)object, (String)"null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
                    object = (FrameLayout.LayoutParams)object;
                    object.setMarginStart((int)this.ctx.getResources().getDimension(R.dimen.focus_notify_button_with_icon_margin_start));
                }
            } else {
                object3.setVisibility(8);
                object3 = textView != null ? textView.getLayoutParams() : null;
                object = object2;
                if (object3 instanceof LinearLayout.LayoutParams) {
                    object = textView.getLayoutParams();
                    o.e((Object)object, (String)"null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
                    object = (LinearLayout.LayoutParams)object;
                    object.setMarginStart((int)this.ctx.getResources().getDimension(R.dimen.focus_notify_button_without_icon_margin_start));
                }
                object2 = var8_5;
                if (textView != null) {
                    object2 = textView.getLayoutParams();
                }
                if (object2 instanceof FrameLayout.LayoutParams) {
                    object = textView.getLayoutParams();
                    o.e((Object)object, (String)"null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
                    object = (FrameLayout.LayoutParams)object;
                    object.setMarginStart((int)this.ctx.getResources().getDimension(R.dimen.focus_notify_button_without_icon_margin_start));
                }
            }
            if (textView != null) {
                textView.setLayoutParams((ViewGroup.LayoutParams)object);
            }
        }
        this.setButtonContainerBackground(action, bl);
    }

    public static /* synthetic */ void updateButtonView$default(ModuleViewHolder moduleViewHolder, Notification.Action action, boolean bl, StatusBarNotification statusBarNotification, Template template, int n, Object object) {
        if (object == null) {
            if ((n & 2) != 0) {
                bl = false;
            }
            moduleViewHolder.updateButtonView(action, bl, statusBarNotification, template);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: updateButtonView");
    }

    public final void adaptTimerDelay() {
        boolean bl;
        Object object = this.actionBundle;
        object = object != null ? (Notification.Action)object.getParcelable("miui.focus.action_1") : null;
        if (object != null && (bl = o.c((Object)(object = object.getExtras().getString("icon_name")), (Object)"action_pause") ? true : o.c((Object)object, (Object)"action_pause_timer"))) {
            this.calculateTimer();
        }
    }

    public void bind(Template template, StatusBarNotification statusBarNotification) {
        o.g((Object)template, (String)"template");
        o.g((Object)statusBarNotification, (String)"sbn");
        this.template = template;
        this.sbn = statusBarNotification;
        this.updateBundle(statusBarNotification);
        this.ignoreTextColor = TemplateFactoryV3.Companion.isBgPicDownloadFailStatic(template, statusBarNotification);
        this.dataChanged.setValue((Object)Boolean.FALSE);
        this.listenWidthChanged();
    }

    public void checkParams(Template template) {
        o.g((Object)template, (String)"template");
    }

    public void diff(Template template, StatusBarNotification statusBarNotification) {
        o.g((Object)template, (String)"template");
        o.g((Object)statusBarNotification, (String)"sbn");
    }

    public final Bundle getActionBundle() {
        return this.actionBundle;
    }

    public final ActionInfo getActionInfo() {
        return this.actionInfo;
    }

    public final Bundle getBitmapBundle() {
        return this.bitmapBundle;
    }

    public final Integer getColorContentBg() {
        return this.colorContentBg;
    }

    public final i1.f getCompressChanged() {
        return this.compressChanged;
    }

    public final String getContent() {
        return this.content;
    }

    public final Integer getContentColor() {
        return this.contentColor;
    }

    public final Integer getContentColorDark() {
        return this.contentColorDark;
    }

    public final Context getContext(boolean bl) {
        if (bl) {
            return ContextUtils.INSTANCE.getNightContext(this.ctx, true);
        }
        Context context = this.isDark ? ContextUtils.getNightContext$default((ContextUtils)ContextUtils.INSTANCE, (Context)this.ctx, (boolean)false, (int)2, null) : ContextUtils.INSTANCE.getDayContext(this.ctx);
        return context;
    }

    public final Context getCtx() {
        return this.ctx;
    }

    public final u getDataChanged() {
        return this.dataChanged;
    }

    public final String getExtraTitle() {
        return this.extraTitle;
    }

    public final Integer getExtraTitleColor() {
        return this.extraTitleColor;
    }

    public final Integer getExtraTitleColorDark() {
        return this.extraTitleColorDark;
    }

    public final String getHighLightText() {
        return this.highLightText;
    }

    public final Integer getHighLightTextColor() {
        return this.highLightTextColor;
    }

    public final Integer getHighLightTextColorDark() {
        return this.highLightTextColorDark;
    }

    public final Integer getHighLightbgColor() {
        return this.highLightbgColor;
    }

    public final Integer getHighLightbgColorDark() {
        return this.highLightbgColorDark;
    }

    public final Icon getIcon(String string, StatusBarNotification object) {
        Object object2;
        block3: {
            block2: {
                o.g((Object)object, (String)"sbn");
                object2 = this.bitmapBundle;
                if (object2 == null) break block2;
                Icon icon = (Icon)object2.getParcelable(string);
                object2 = icon;
                if (icon != null) break block3;
            }
            object2 = FocusIconCache.INSTANCE;
            object = object.getKey();
            o.f((Object)object, (String)"getKey(...)");
            object2 = ((FocusIconCache)object2).get((String)object, string);
        }
        return object2;
    }

    public final boolean getIgnoreTextColor() {
        return this.ignoreTextColor;
    }

    public final int getLastWidth() {
        return this.lastWidth;
    }

    public final String getModule() {
        return this.module;
    }

    public final Integer getPrimaryColor() {
        return this.primaryColor;
    }

    public final Integer getPrimaryColorDark() {
        return this.primaryColorDark;
    }

    public final String getPrimaryText() {
        return this.primaryText;
    }

    public final ViewGroup getRootView() {
        return this.rootView;
    }

    public final StatusBarNotification getSbn() {
        return this.sbn;
    }

    public final f1.E getScope() {
        return this.scope;
    }

    public final Integer getSecondaryColor() {
        return this.secondaryColor;
    }

    public final Integer getSecondaryColorDark() {
        return this.secondaryColorDark;
    }

    public final String getSecondaryText() {
        return this.secondaryText;
    }

    public final Boolean getShowSecondaryLine() {
        return this.showSecondaryLine;
    }

    public final String getSpecialTitle() {
        return this.specialTitle;
    }

    public final Integer getSpecialTitleColor() {
        return this.specialTitleColor;
    }

    public final Integer getSpecialTitleColorDark() {
        return this.specialTitleColorDark;
    }

    public final String getSubContent() {
        return this.subContent;
    }

    public final Integer getSubContentColor() {
        return this.subContentColor;
    }

    public final Integer getSubContentColorDark() {
        return this.subContentColorDark;
    }

    public final Integer getSubTitleColor() {
        return this.subTitleColor;
    }

    public final Integer getSubTitleColorDark() {
        return this.subTitleColorDark;
    }

    public final String getSubtitle() {
        return this.subtitle;
    }

    public final Context getSysuiCtx() {
        return this.sysuiCtx;
    }

    public final int getTextViewWidth(TextView textView) {
        if (textView == null) {
            return 0;
        }
        return this.getTextViewWidth(textView, ((Object)textView.getText()).toString());
    }

    public final int getTextViewWidth(TextView textView, String string) {
        if (textView != null && string != null && string.length() != 0) {
            int n = (int)textView.getPaint().measureText(string);
            int n2 = textView.getWidth();
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("getTextViewWidth ");
            stringBuilder.append(textView);
            stringBuilder.append(" ");
            stringBuilder.append(string);
            stringBuilder.append(" ");
            stringBuilder.append(n);
            stringBuilder.append(" ");
            stringBuilder.append(n2);
            Log.d((String)TAG, (String)stringBuilder.toString());
            return n;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("getTextViewWidth ");
        stringBuilder.append(textView);
        stringBuilder.append(" ");
        stringBuilder.append(string);
        Log.e((String)TAG, (String)stringBuilder.toString());
        return 0;
    }

    public final Long getTimerCurrent() {
        return this.timerCurrent;
    }

    public final boolean getTimerInitialized() {
        return this.timerInitialized;
    }

    public final Long getTimerSystemCurrent() {
        return this.timerSystemCurrent;
    }

    public final Long getTimerTotal() {
        return this.timerTotal;
    }

    public final Integer getTimerType() {
        return this.timerType;
    }

    public final Long getTimerWhen() {
        return this.timerWhen;
    }

    public final String getTitle() {
        return this.title;
    }

    public final Integer getTitleColor() {
        return this.titleColor;
    }

    public final Integer getTitleColorDark() {
        return this.titleColorDark;
    }

    public final View getView() {
        return this.view;
    }

    public final u getWidthChanged() {
        return this.widthChanged;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final void handleBtnClick(PendingIntent pendingIntent, Notification.Action action, Context context, View view, boolean bl, StatusBarNotification statusBarNotification, boolean bl2) {
        PendingIntent.CanceledException canceledException2;
        o.g((Object)pendingIntent, (String)"intent");
        o.g((Object)action, (String)"action");
        o.g((Object)context, (String)"context");
        o.g((Object)statusBarNotification, (String)"sbn");
        if (!bl2) {
            try {
                pendingIntent.send();
                return;
            }
            catch (PendingIntent.CanceledException canceledException2) {}
        } else {
            if (view == null) return;
            if (!ModuleViewHolderExtKt.sendWithCollapse(pendingIntent, action, context, view, bl, statusBarNotification)) return;
            this.track(bl, action);
            return;
        }
        Log.e((String)TAG, (String)"PendingIntent.send() failed", (Throwable)canceledException2);
    }

    public final boolean hasCustomBackground(Template object, StatusBarNotification statusBarNotification) {
        boolean bl;
        block11: {
            boolean bl2;
            Object object2;
            block10: {
                Object var7_3;
                block9: {
                    block8: {
                        o.g((Object)object, (String)"template");
                        o.g((Object)statusBarNotification, (String)"sbn");
                        var7_3 = null;
                        object2 = ((Template)object).getBgInfo();
                        if (object2 == null) break block8;
                        object2 = ((BgInfo)object2).getColorBg();
                        break block9;
                    }
                    object2 = null;
                }
                try {
                    object2 = Color.parseColor((String)object2);
                }
                catch (Exception exception) {
                    object2 = null;
                }
                Object object3 = ((Template)object).getBgInfo();
                object3 = object3 != null ? ((BgInfo)object3).getPicBg() : null;
                statusBarNotification = this.getIcon((String)object3, statusBarNotification);
                object3 = this.bitmapBundle;
                bl2 = true;
                if (object3 == null) break block10;
                BgInfo bgInfo = ((Template)object).getBgInfo();
                object = var7_3;
                if (bgInfo != null) {
                    object = bgInfo.getPicBg();
                }
                if (!object3.containsKey((String)object)) break block10;
                bl = bl2;
                if (statusBarNotification != null) break block11;
            }
            bl = object2 != null ? bl2 : false;
        }
        return bl;
    }

    /*
     * Unable to fully structure code
     */
    public final void initTextAndColor(TextAndColorInfo var1_1) {
        var2_11 = var1_1 instanceof HighlightInfoV3;
        var5_12 = null;
        var3_13 = var2_11 != false ? (HighlightInfoV3)var1_1 : null;
        var4_14 = var1_1 != null ? var1_1.getTitle() : null;
        this.title = var4_14;
        var4_14 = var1_1 != null ? var1_1.getSubTitle() : null;
        this.subtitle = var4_14;
        var4_14 = var1_1 != null ? var1_1.getExtraTitle() : null;
        this.extraTitle = var4_14;
        var4_14 = var1_1 != null ? var1_1.getSpecialTitle() : null;
        this.specialTitle = var4_14;
        var4_14 = var1_1 != null ? var1_1.getContent() : null;
        this.content = var4_14;
        var4_14 = var1_1 != null ? var1_1.getSubContent() : null;
        this.subContent = var4_14;
        var4_14 = var3_13 != null ? var3_13.getPrimaryText() : null;
        this.primaryText = var4_14;
        var4_14 = var3_13 != null ? var3_13.getSecondaryText() : null;
        this.secondaryText = var4_14;
        var4_14 = var3_13 != null ? var3_13.getShowSecondaryLine() : null;
        this.showSecondaryLine = var4_14;
        var4_14 = var3_13 != null ? var3_13.getHighLightText() : null;
        this.highLightText = var4_14;
        if (this.ignoreTextColor) {
            return;
        }
        if (var1_1 != null) {
            var4_14 = var1_1.getColorTitle();
        } else {
            var4_14 = null;
        }
        try {
            var4_14 = Color.parseColor((String)var4_14);
        }
        catch (Exception var4_15) {
            var4_14 = null;
        }
        this.titleColor = var4_14;
        if (var1_1 != null) {
            var4_14 = var1_1.getColorTitleDark();
        } else {
            var4_14 = null;
        }
        try {
            var4_14 = Color.parseColor((String)var4_14);
        }
        catch (Exception var4_16) {
            var4_14 = this.titleColor;
        }
        this.titleColorDark = var4_14;
        if (var1_1 != null) {
            var4_14 = var1_1.getColorSubTitle();
        } else {
            var4_14 = null;
        }
        try {
            var4_14 = Color.parseColor((String)var4_14);
        }
        catch (Exception var4_17) {
            var4_14 = null;
        }
        this.subTitleColor = var4_14;
        if (var1_1 != null) {
            var4_14 = var1_1.getColorSubTitleDark();
        } else {
            var4_14 = null;
        }
        try {
            var4_14 = Color.parseColor((String)var4_14);
        }
        catch (Exception var4_18) {
            var4_14 = this.subTitleColor;
        }
        this.subTitleColorDark = var4_14;
        if (var1_1 != null) {
            var4_14 = var1_1.getColorExtraTitle();
        } else {
            var4_14 = null;
        }
        try {
            var4_14 = Color.parseColor((String)var4_14);
        }
        catch (Exception var4_19) {
            var4_14 = null;
        }
        this.extraTitleColor = var4_14;
        if (var1_1 != null) {
            var4_14 = var1_1.getColorExtraTitleDark();
        } else {
            var4_14 = null;
        }
        try {
            var4_14 = Color.parseColor((String)var4_14);
        }
        catch (Exception var4_20) {
            var4_14 = this.extraTitleColor;
        }
        this.extraTitleColorDark = var4_14;
        if (var1_1 != null) {
            var4_14 = var1_1.getColorSpecialTitle();
        } else {
            var4_14 = null;
        }
        try {
            var4_14 = Color.parseColor((String)var4_14);
        }
        catch (Exception var4_21) {
            var4_14 = null;
        }
        this.specialTitleColor = var4_14;
        if (var1_1 != null) {
            var4_14 = var1_1.getColorSpecialTitleDark();
        } else {
            var4_14 = null;
        }
        try {
            var4_14 = Color.parseColor((String)var4_14);
        }
        catch (Exception var4_22) {
            var4_14 = this.specialTitleColor;
        }
        this.specialTitleColorDark = var4_14;
        if (var1_1 != null) {
            var4_14 = var1_1.getColorContent();
        } else {
            var4_14 = null;
        }
        try {
            var4_14 = Color.parseColor((String)var4_14);
        }
        catch (Exception var4_23) {
            var4_14 = null;
        }
        this.contentColor = var4_14;
        if (var1_1 != null) {
            var4_14 = var1_1.getColorContentDark();
        } else {
            var4_14 = null;
        }
        try {
            var4_14 = Color.parseColor((String)var4_14);
        }
        catch (Exception var4_24) {
            var4_14 = this.contentColor;
        }
        this.contentColorDark = var4_14;
        if (var1_1 != null) {
            var4_14 = var1_1.getColorSubContent();
        } else {
            var4_14 = null;
        }
        try {
            var4_14 = Color.parseColor((String)var4_14);
        }
        catch (Exception var4_25) {
            var4_14 = null;
        }
        this.subContentColor = var4_14;
        if (var1_1 != null) {
            var1_1 = var1_1.getColorSubContentDark();
        } else {
            var1_1 = null;
        }
        try {
            var1_1 = Color.parseColor((String)var1_1);
        }
        catch (Exception var1_2) {
            var1_1 = this.subContentColor;
        }
        this.subContentColorDark = var1_1;
        if (var3_13 != null) {
            var1_1 = var3_13.getPrimaryColor();
        } else {
            var1_1 = null;
        }
        try {
            var1_1 = Color.parseColor((String)var1_1);
        }
        catch (Exception var1_3) {
            var1_1 = null;
        }
        this.primaryColor = var1_1;
        if (var3_13 != null) {
            var1_1 = var3_13.getPrimaryColorDark();
        } else {
            var1_1 = null;
        }
        try {
            var1_1 = Color.parseColor((String)var1_1);
        }
        catch (Exception var1_4) {
            var1_1 = this.primaryColor;
        }
        this.primaryColorDark = var1_1;
        if (var3_13 != null) {
            var1_1 = var3_13.getSecondaryColor();
        } else {
            var1_1 = null;
        }
        try {
            var1_1 = Color.parseColor((String)var1_1);
        }
        catch (Exception var1_5) {
            var1_1 = null;
        }
        this.secondaryColor = var1_1;
        if (var3_13 != null) {
            var1_1 = var3_13.getSecondaryColorDark();
        } else {
            var1_1 = null;
        }
        try {
            var1_1 = Color.parseColor((String)var1_1);
        }
        catch (Exception var1_6) {
            var1_1 = this.secondaryColor;
        }
        this.secondaryColorDark = var1_1;
        if (var3_13 != null) {
            var1_1 = var3_13.getHighLightTextColor();
        } else {
            var1_1 = null;
        }
        try {
            var1_1 = Color.parseColor((String)var1_1);
        }
        catch (Exception var1_7) {
            var1_1 = null;
        }
        this.highLightTextColor = var1_1;
        if (var3_13 != null) {
            var1_1 = var3_13.getHighLightTextColorDark();
        } else {
            var1_1 = null;
        }
        try {
            var1_1 = Color.parseColor((String)var1_1);
        }
        catch (Exception var1_8) {
            var1_1 = this.highLightTextColor;
        }
        this.highLightTextColorDark = var1_1;
        if (var3_13 != null) {
            var1_1 = var3_13.getHighLightbgColor();
        } else {
            var1_1 = null;
        }
        try {
            var1_1 = Color.parseColor((String)var1_1);
        }
        catch (Exception var1_9) {
            var1_1 = null;
        }
        this.highLightbgColor = var1_1;
        var1_1 = var5_12;
        if (var3_13 == null) ** GOTO lbl239
        try {
            var1_1 = var3_13.getHighLightbgColorDark();
lbl239:
            // 2 sources

            var1_1 = Color.parseColor((String)var1_1);
        }
        catch (Exception var1_10) {
            var1_1 = this.highLightbgColor;
        }
        this.highLightbgColorDark = var1_1;
        var2_11 = this.isDark;
        var3_13 = var2_11 == true ? this.titleColorDark : this.titleColor;
        this.titleColor = var3_13;
        var3_13 = var2_11 == true ? this.subTitleColorDark : this.subTitleColor;
        this.subTitleColor = var3_13;
        var3_13 = var2_11 == true ? this.extraTitleColorDark : this.extraTitleColor;
        this.extraTitleColor = var3_13;
        var3_13 = var2_11 == true ? this.specialTitleColorDark : this.specialTitleColor;
        this.specialTitleColor = var3_13;
        var3_13 = var2_11 == true ? this.contentColorDark : this.contentColor;
        this.contentColor = var3_13;
        var3_13 = var2_11 == true ? this.subContentColorDark : this.subContentColor;
        this.subContentColor = var3_13;
        var3_13 = var2_11 == true ? this.primaryColorDark : this.primaryColor;
        this.primaryColor = var3_13;
        var3_13 = var2_11 == true ? this.secondaryColorDark : this.secondaryColor;
        this.secondaryColor = var3_13;
        var3_13 = var2_11 == true ? this.highLightTextColorDark : this.highLightTextColor;
        this.highLightTextColor = var3_13;
        if (!var2_11) {
            var1_1 = this.highLightbgColor;
        }
        this.highLightbgColor = var1_1;
    }

    public final void initTimerData(TimerInfo object) {
        if (object != null) {
            Long l2;
            this.timerType = ((TimerInfo)object).getTimerType();
            Long l3 = l2 = ((TimerInfo)object).getTimerWhen();
            if (l2 == null) {
                l3 = System.currentTimeMillis();
            }
            this.timerWhen = l3;
            this.timerTotal = ((TimerInfo)object).getTimerTotal();
            l3 = ((TimerInfo)object).getTimerSystemCurrent();
            object = l3;
            if (l3 == null) {
                object = System.currentTimeMillis();
            }
            this.timerSystemCurrent = object;
            object = this.timerType;
            o.d((Object)object);
            if ((Integer)object > 0) {
                object = this.timerSystemCurrent;
                o.d((Object)object);
                long l4 = (Long)object;
                object = this.timerWhen;
                o.d((Object)object);
                object = l4 - (Long)object;
            } else {
                object = this.timerWhen;
                o.d((Object)object);
                long l5 = (Long)object;
                object = this.timerSystemCurrent;
                o.d((Object)object);
                object = l5 - (Long)object;
            }
            this.timerCurrent = object;
        }
    }

    public void initView(String string) {
        o.g((Object)string, (String)"module");
        AutoDensityController.Companion.addOnDensityChangeListener((AutoDensityController.OnDensityChangeListener)this);
    }

    public final boolean isDark() {
        return this.isDark;
    }

    public final void notifyDataChanged() {
        this.dataChanged.setValue((Object)Boolean.TRUE);
    }

    public void onConfigChanged(Configuration configuration) {
        o.g((Object)configuration, (String)"config");
        Template template = this.template;
        if (template != null && (configuration = this.sbn) != null) {
            this.bind(template, (StatusBarNotification)configuration);
        }
    }

    public void onDetach() {
        AutoDensityController.Companion.removeOnDensityChangeListener((AutoDensityController.OnDensityChangeListener)this);
        View view = this.view;
        if (view != null) {
            view.removeOnAttachStateChangeListener(this.onAttachStateChangeListener);
        }
        if ((view = this.view) != null && (view = view.getViewTreeObserver()) != null) {
            view.removeOnPreDrawListener(this.onPreDrawListener);
        }
        F.e((f1.E)this.scope, null, (int)1, null);
    }

    public final void registerCompressChanged(a a2) {
        o.g((Object)a2, (String)"action");
        f.b((f1.E)this.scope, null, null, (U0.o)new U0.o(this, a2, null){
            final a $action;
            int label;
            final ModuleViewHolder this$0;
            {
                this.this$0 = moduleViewHolder;
                this.$action = a2;
                super(2, d2);
            }

            public final d create(Object object, d d2) {
                return new /* invalid duplicate definition of identical inner class */;
            }

            public final Object invoke(f1.E e2, d d2) {
                return (this.create(e2, d2)).invokeSuspend(s.a);
            }

            /*
             * Enabled force condition propagation
             * Lifted jumps to return sites
             */
            public final Object invokeSuspend(Object g2) {
                Object object = c.c();
                int n = this.label;
                if (n != 0) {
                    if (n != 1) throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    k.b((Object)g2);
                    return s.a;
                } else {
                    k.b((Object)g2);
                    i1.f f2 = this.this$0.getCompressChanged();
                    g2 = new g(this.$action){
                        final a $action;
                        {
                            this.$action = a2;
                        }

                        public final Object emit(boolean bl, d d2) {
                            this.$action.invoke();
                            return s.a;
                        }
                    };
                    this.label = 1;
                    if (f2.collect(g2, (d)this) != object) return s.a;
                    return object;
                }
            }
        }, (int)3, null);
    }

    public final void setAction(View view, Notification.Action action, StatusBarNotification statusBarNotification, boolean bl, boolean bl2, Template template) {
        int n;
        o.g((Object)statusBarNotification, (String)"sbn");
        o.g((Object)template, (String)"template");
        TextView textView = null;
        View view2 = view != null ? view.findViewById(R.id.focus_button_container) : null;
        if (action == null) {
            if (bl) {
                if (view2 != null) {
                    view2.setVisibility(4);
                }
            } else if (view != null) {
                view.setVisibility(4);
            }
            return;
        }
        Integer n2 = this.isDark ? this.parseColorFromExtras(action.getExtras(), "colorTitleDark") : this.parseColorFromExtras(action.getExtras(), "colorTitle");
        if (view != null) {
            textView = (TextView)view.findViewById(R.id.focus_button_title);
        }
        if (textView != null) {
            textView.setVisibility(0);
        }
        if (textView != null) {
            textView.setText((CharSequence)Html.fromHtml((String)((Object)action.title).toString()));
        }
        if (textView instanceof TimerTextEffectView && !TextUtils.isEmpty((CharSequence)action.title)) {
            TimerTextEffectView timerTextEffectView = (TimerTextEffectView)textView;
            timerTextEffectView.setTextChangeProcessor((TextChangeProcessor)new TextChangeHelper());
            timerTextEffectView.setEnableEffectWithInit(false);
            timerTextEffectView.setText((CharSequence)Html.fromHtml((String)((Object)action.title).toString()), TextView.BufferType.SPANNABLE);
            if (this.isDark) {
                Integer n3 = this.titleColorDark;
                if (n3 != null) {
                    n = n3;
                    timerTextEffectView.updateTextWithNewAppearance((CharSequence)Html.fromHtml((String)((Object)action.title).toString()), Integer.valueOf(n));
                }
            } else if (n2 != null) {
                n = n2;
                timerTextEffectView.updateTextWithNewAppearance((CharSequence)Html.fromHtml((String)((Object)action.title).toString()), Integer.valueOf(n));
            }
        }
        if (n2 != null) {
            n = n2;
            if (textView != null) {
                textView.setTextColor(n);
            }
        }
        statusBarNotification.getNotification().extras.putInt("miui.focus.moduleButtonId", R.id.focus_button_container);
        if (bl) {
            if (view2 != null) {
                view2.setOnClickListener((View.OnClickListener)new C(action, this, bl2, statusBarNotification));
            }
            if (view2 != null) {
                view2.setVisibility(0);
            }
            if (view2 != null) {
                view2.setContentDescription(action.title);
            }
            this.updateButtonView(action, this.isDark, statusBarNotification, template);
            this.setButtonAccessibilityDelegate(view2);
        } else {
            if (view != null) {
                view.setOnClickListener((View.OnClickListener)new D(action, this, bl2, statusBarNotification));
            }
            if (view != null) {
                view.setVisibility(0);
            }
            if (view != null) {
                view.setContentDescription(action.title);
            }
            this.setButtonAccessibilityDelegate(view);
        }
    }

    public final void setActionBundle(Bundle bundle) {
        this.actionBundle = bundle;
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    public final void setActionData(Template var1_1, StatusBarNotification var2_2, boolean var3_3) {
        block4: {
            o.g((Object)var1_1, (String)"template");
            o.g((Object)var2_2, (String)"sbn");
            var6_4 = ModuleViewHolder.buildAction$default(this, var1_1, var2_2, false, 4, null);
            this.setAction(this.view, (Notification.Action)var6_4, var2_2, true, var3_3, var1_1);
            if (var1_1.getTextButton() == null) break block4;
            var6_4 = var1_1.getTextButton();
            o.d((Object)var6_4);
            if (var6_4.isEmpty()) break block4;
            var6_4 = var1_1.getTextButton();
            o.d((Object)var6_4);
            var5_5 = var6_4.size();
            for (var4_6 = 0; var4_6 < var5_5; ++var4_6) {
                block3: {
                    block5: {
                        block6: {
                            block8: {
                                block7: {
                                    var6_4 = var1_1.getTextButton();
                                    o.d((Object)var6_4);
                                    var7_7 /* !! */  = this.buildAction((ActionInfo)var6_4.get(var4_6), var2_2, true);
                                    if (var4_6 == 0) break block5;
                                    if (var4_6 == 1) break block6;
                                    if (var4_6 == 2) break block7;
                                    var6_4 = null;
                                    break block3;
                                }
                                var6_4 = this.view;
                                if (var6_4 == null) break block8;
                                var6_4 = var6_4.findViewById(R.id.focus_button_container_action3);
                                break block3;
                            }
lbl27:
                            // 3 sources

                            while (true) {
                                var6_4 = null;
                                break block3;
                                break;
                            }
                        }
                        var6_4 = this.view;
                        if (var6_4 == null) ** GOTO lbl27
                        var6_4 = var6_4.findViewById(R.id.focus_button_container_action2);
                        break block3;
                    }
                    if ((var6_4 = this.view) == null) ** continue;
                    var6_4 = var6_4.findViewById(R.id.focus_button_container_action1);
                }
                this.setAction((View)var6_4, (Notification.Action)var7_7 /* !! */ , var2_2, false, var3_3, var1_1);
            }
        }
        if ((var6_4 = (var6_4 = var1_1.getHighlightInfoV3()) != null ? var6_4.getActionInfo() : null) != null) {
            var6_4 = var1_1.getHighlightInfoV3().getActionInfo();
            var6_4 = var6_4 != null ? this.buildAction((ActionInfo)var6_4, var2_2, true) : null;
            var7_7 /* !! */  = this.view;
            var7_7 /* !! */  = var7_7 /* !! */  != null ? var7_7 /* !! */ .findViewById(R.id.focus_button_container_action) : null;
            this.setAction(var7_7 /* !! */ , (Notification.Action)var6_4, var2_2, false, var3_3, var1_1);
        }
    }

    public final void setActionInfo(ActionInfo actionInfo) {
        this.actionInfo = actionInfo;
    }

    public final void setBitmapBundle(Bundle bundle) {
        this.bitmapBundle = bundle;
    }

    public final void setColorContentBg(Integer n) {
        this.colorContentBg = n;
    }

    public final void setContent(String string) {
        this.content = string;
    }

    public final void setContentColor(Integer n) {
        this.contentColor = n;
    }

    public final void setContentColorDark(Integer n) {
        this.contentColorDark = n;
    }

    public final void setExtraTitle(String string) {
        this.extraTitle = string;
    }

    public final void setExtraTitleColor(Integer n) {
        this.extraTitleColor = n;
    }

    public final void setExtraTitleColorDark(Integer n) {
        this.extraTitleColorDark = n;
    }

    public final void setHighLightText(String string) {
        this.highLightText = string;
    }

    public final void setHighLightTextColor(Integer n) {
        this.highLightTextColor = n;
    }

    public final void setHighLightTextColorDark(Integer n) {
        this.highLightTextColorDark = n;
    }

    public final void setHighLightbgColor(Integer n) {
        this.highLightbgColor = n;
    }

    public final void setHighLightbgColorDark(Integer n) {
        this.highLightbgColorDark = n;
    }

    public final void setIgnoreTextColor(boolean bl) {
        this.ignoreTextColor = bl;
    }

    public final void setLastWidth(int n) {
        this.lastWidth = n;
    }

    public final void setModule(String string) {
        this.module = string;
    }

    public final void setPrimaryColor(Integer n) {
        this.primaryColor = n;
    }

    public final void setPrimaryColorDark(Integer n) {
        this.primaryColorDark = n;
    }

    public final void setPrimaryText(String string) {
        this.primaryText = string;
    }

    public final void setProgressData(int n, StatusBarNotification statusBarNotification, Boolean bl) {
        Object object;
        o.g((Object)statusBarNotification, (String)"sbn");
        if (o.c((Object)bl, (Object)Boolean.TRUE) && (object = (object = this.view) != null ? (StatusProgressLayout)object.findViewById(n) : null) != null) {
            statusBarNotification.getNotification().extras.putInt("StatusProgressLayout", n);
            statusBarNotification.getNotification().extras.putBoolean("isAutoProgress", bl.booleanValue());
        }
    }

    public final void setSbn(StatusBarNotification statusBarNotification) {
        this.sbn = statusBarNotification;
    }

    public final void setScope(f1.E e) {
        o.g((Object)e, (String)"<set-?>");
        this.scope = e;
    }

    public final void setSecondaryColor(Integer n) {
        this.secondaryColor = n;
    }

    public final void setSecondaryColorDark(Integer n) {
        this.secondaryColorDark = n;
    }

    public final void setSecondaryText(String string) {
        this.secondaryText = string;
    }

    public final void setShowSecondaryLine(Boolean bl) {
        this.showSecondaryLine = bl;
    }

    public final void setSpecialTitle(String string) {
        this.specialTitle = string;
    }

    public final void setSpecialTitleColor(Integer n) {
        this.specialTitleColor = n;
    }

    public final void setSpecialTitleColorDark(Integer n) {
        this.specialTitleColorDark = n;
    }

    public final void setSubContent(String string) {
        this.subContent = string;
    }

    public final void setSubContentColor(Integer n) {
        this.subContentColor = n;
    }

    public final void setSubContentColorDark(Integer n) {
        this.subContentColorDark = n;
    }

    public final void setSubTitleColor(Integer n) {
        this.subTitleColor = n;
    }

    public final void setSubTitleColorDark(Integer n) {
        this.subTitleColorDark = n;
    }

    public final void setSubtitle(String string) {
        this.subtitle = string;
    }

    public final void setTimerCurrent(Long l2) {
        this.timerCurrent = l2;
    }

    public final void setTimerData(int n, StatusBarNotification object) {
        o.g((Object)object, (String)"sbn");
        Integer n2 = this.timerType;
        if (n2 == null || n2 != 0) {
            long l2;
            n2 = this.view;
            n2 = n2 != null ? (HyperChronometer)n2.findViewById(n) : null;
            if (n2 != null) {
                n2.setEnableEffectWithInit(false);
            }
            Number number = this.timerType;
            if (number != null) {
                int n3 = number.intValue();
                object.getNotification().extras.putInt("timerType", n3);
                if (n2 != null) {
                    boolean bl = n3 < 0;
                    if (bl != n2.isCountDown()) {
                        n2.setCountDown(bl);
                    }
                    if (bl) {
                        if (n3 == -1) {
                            n2.enableEffect(CommonUtils.NOT_SUPPORT_TEXT_EFFECT ^ true);
                            n2.setTextChangeProcessor(new CharChangeProcessor());
                        } else {
                            n2.enableEffect(false);
                        }
                    }
                }
            }
            if ((number = this.timerWhen) != null) {
                l2 = number.longValue();
                object.getNotification().extras.putLong("timerWhen", l2);
            }
            if ((number = this.timerCurrent) != null) {
                l2 = number.longValue();
                object.getNotification().extras.putLong("timerCurrent", l2);
            }
            if ((number = this.timerTotal) != null) {
                l2 = number.longValue();
                object.getNotification().extras.putLong("timerTotal", l2);
            }
            if ((number = this.timerSystemCurrent) != null) {
                l2 = number.longValue();
                object.getNotification().extras.putLong("timerSystemCurrent", l2);
            }
            object.getNotification().extras.putInt("miui.focus.chronometerId", n);
            if (!this.timerInitialized) {
                if (n2 != null) {
                    long l3 = SystemClock.elapsedRealtime();
                    object = this.timerWhen;
                    o.d((Object)object);
                    l2 = (Long)object;
                    object = this.timerSystemCurrent;
                    o.d((Object)object);
                    n2.setBase(l3 + l2 - (Long)object);
                }
                if (n2 != null) {
                    n2.setFontFeatureSettings("ss01");
                }
                this.timerInitialized = true;
            }
        }
    }

    public final void setTimerInitialized(boolean bl) {
        this.timerInitialized = bl;
    }

    public final void setTimerSystemCurrent(Long l2) {
        this.timerSystemCurrent = l2;
    }

    public final void setTimerTotal(Long l2) {
        this.timerTotal = l2;
    }

    public final void setTimerType(Integer n) {
        this.timerType = n;
    }

    public final void setTimerWhen(Long l2) {
        this.timerWhen = l2;
    }

    public final void setTitle(String string) {
        this.title = string;
    }

    public final void setTitleColor(Integer n) {
        this.titleColor = n;
    }

    public final void setTitleColorDark(Integer n) {
        this.titleColorDark = n;
    }

    public final void setView(View view) {
        this.view = view;
    }

    public final void setViewWidth(TextView textView, int n, int n2) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("setViewWidth ");
        stringBuilder.append(n);
        stringBuilder.append(" ");
        stringBuilder.append(textView);
        stringBuilder.append(" ");
        stringBuilder.append(n2);
        Log.i((String)TAG, (String)stringBuilder.toString());
        n = Math.max(n, n2);
        if (textView != null && textView.getWidth() != n) {
            textView.setVisibility(0);
            stringBuilder = textView.getLayoutParams();
            ((ViewGroup.LayoutParams)stringBuilder).width = n;
            textView.setLayoutParams((ViewGroup.LayoutParams)stringBuilder);
            if (textView.getResources().getConfiguration().getLayoutDirection() == 1) {
                textView.setLayoutDirection(1);
            } else {
                textView.setLayoutDirection(0);
            }
            textView.requestLayout();
        }
    }

    public void updatePartial(Template template, StatusBarNotification statusBarNotification) {
        o.g((Object)template, (String)"template");
        o.g((Object)statusBarNotification, (String)"sbn");
        this.updateBundle(statusBarNotification);
    }

    public final void updateTextSizeForTextView(TimerTextEffectView timerTextEffectView, int n) {
        if (timerTextEffectView != null) {
            timerTextEffectView.setTextSize(0, this.ctx.getResources().getDimension(n));
        }
    }
}
