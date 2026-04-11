/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  G0.i
 *  G0.k
 *  G0.o
 *  G0.s
 *  H0.G
 *  H0.m
 *  H0.u
 *  K0.d
 *  L0.c
 *  U0.o
 *  android.annotation.SuppressLint
 *  android.app.Notification$Action
 *  android.app.Notification$Action$Builder
 *  android.app.PendingIntent
 *  android.content.Context
 *  android.content.Intent
 *  android.graphics.Color
 *  android.graphics.drawable.Drawable
 *  android.graphics.drawable.GradientDrawable
 *  android.graphics.drawable.Icon
 *  android.graphics.drawable.StateListDrawable
 *  android.os.UserHandle
 *  android.service.notification.StatusBarNotification
 *  android.text.Html
 *  android.util.Log
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.View$AccessibilityDelegate
 *  android.view.View$OnClickListener
 *  android.view.ViewGroup
 *  android.view.ViewParent
 *  android.view.accessibility.AccessibilityNodeInfo
 *  android.widget.Button
 *  android.widget.LinearLayout
 *  android.widget.TextView
 *  android.widget.TextView$BufferType
 *  androidx.core.view.OneShotPreDrawListener
 *  b1.f
 *  com.android.systemui.miui.notification.R$dimen
 *  com.android.systemui.miui.notification.R$drawable
 *  com.android.systemui.miui.notification.R$id
 *  com.android.systemui.miui.notification.R$layout
 *  com.android.systemui.miui.notification.R$raw
 *  com.mi.widget.core.Origin
 *  com.mi.widget.shader.CallingShader
 *  d1.e
 *  d1.l
 *  f1.E
 *  f1.f
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.o
 *  miui.systemui.dynamicisland.DynamicFeatureConfig
 *  miui.systemui.dynamicisland.R$id
 *  miui.systemui.util.CommonUtils
 *  miui.systemui.util.PaletteUtils
 *  miui.systemui.util.ShaderUtil
 *  miui.systemui.widget.AnimateImageView
 *  miui.systemui.widget.StatusProgressLayout
 */
package miui.systemui.notification.focus.moduleV3;

import G0.i;
import G0.k;
import G0.o;
import G0.s;
import H0.G;
import H0.m;
import H0.u;
import android.annotation.SuppressLint;
import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.Icon;
import android.graphics.drawable.StateListDrawable;
import android.os.UserHandle;
import android.service.notification.StatusBarNotification;
import android.text.Html;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.OneShotPreDrawListener;
import b1.f;
import com.android.systemui.miui.notification.R;
import com.mi.widget.core.Origin;
import com.mi.widget.shader.CallingShader;
import d1.l;
import f1.E;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.jvm.functions.Function1;
import miui.systemui.dynamicisland.DynamicFeatureConfig;
import miui.systemui.dynamicisland.R;
import miui.systemui.notification.focus.model.ActionInfo;
import miui.systemui.notification.focus.model.ProgressInfo;
import miui.systemui.notification.focus.model.Template;
import miui.systemui.notification.focus.moduleV3.ModuleButtonViewHolder;
import miui.systemui.notification.focus.moduleV3.ModuleViewHolder;
import miui.systemui.notification.focus.moduleV3.c;
import miui.systemui.notification.focus.moduleV3.d;
import miui.systemui.notification.focus.moduleV3.e;
import miui.systemui.notification.focus.moduleV3.ext.ModuleViewHolderExtKt;
import miui.systemui.util.CommonUtils;
import miui.systemui.util.PaletteUtils;
import miui.systemui.util.ShaderUtil;
import miui.systemui.widget.AnimateImageView;
import miui.systemui.widget.StatusProgressLayout;

public final class ModuleButtonViewHolder
extends ModuleViewHolder {
    private static final Map<String, Integer> ACTIONS_RESOURCE_MAP;
    public static final Companion Companion;
    private static final Map<String, Integer> LOTTIE_RES_MAP_NEXT;
    private List<ActionInfo> actions;
    private final buttonAccessibilityDelegate.1 buttonAccessibilityDelegate;
    private AnimateImageView image;
    private final boolean isDynamicIsland;
    private CallingShader<?> shader;
    private StatusProgressLayout statusProgressLayout;

    static {
        Companion = new Object(null){
            {
                this();
            }
        };
        ACTIONS_RESOURCE_MAP = G.h((i[])new i[]{o.a((Object)"action_pause", (Object)R.drawable.pause), o.a((Object)"action_pause_timer", (Object)R.drawable.pause_timer_v3), o.a((Object)"action_pause_record", (Object)R.drawable.pause_v3), o.a((Object)"action_restart", (Object)R.drawable.restart), o.a((Object)"action_restart_timer", (Object)R.drawable.restart_timer_v3), o.a((Object)"action_restart_record", (Object)R.drawable.restart_v3), o.a((Object)"action_mark_timer", (Object)R.drawable.mark_timer), o.a((Object)"action_done", (Object)R.drawable.done_v3), o.a((Object)"action_end", (Object)R.drawable.end_v3), o.a((Object)"action_record_end", (Object)R.drawable.record_end_v3), o.a((Object)"action_copy", (Object)R.drawable.copy_v2), o.a((Object)"action_close", (Object)R.drawable.close_v3), o.a((Object)"action_later", (Object)R.drawable.later_v3), o.a((Object)"action_answer", (Object)R.drawable.answer), o.a((Object)"action_hangup", (Object)R.drawable.hangup_v2), o.a((Object)"action_speaker", (Object)R.drawable.speaker_v2), o.a((Object)"action_speaker_during", (Object)R.drawable.speaker_during_v2), o.a((Object)"action_call", (Object)R.drawable.call), o.a((Object)"action_request_audio", (Object)R.drawable.request_audio_v2), o.a((Object)"action_audio", (Object)R.drawable.audio_v2), o.a((Object)"action_audio_during", (Object)R.drawable.audio_during_v2), o.a((Object)"action_request_video", (Object)R.drawable.request_video_v2), o.a((Object)"action_video", (Object)R.drawable.video_v2), o.a((Object)"action_video_during", (Object)R.drawable.video_during_v2), o.a((Object)"action_retry", (Object)R.drawable.retry)});
        int n = R.raw.play_island;
        i i2 = o.a((Object)"action_pause", (Object)n);
        i i3 = o.a((Object)"action_pause_timer", (Object)R.raw.play_island_blue);
        i i4 = o.a((Object)"action_pause_record", (Object)n);
        n = R.raw.pause_island;
        LOTTIE_RES_MAP_NEXT = G.h((i[])new i[]{i2, i3, i4, o.a((Object)"action_restart", (Object)n), o.a((Object)"action_restart_timer", (Object)R.raw.pause_island_blue), o.a((Object)"action_restart_record", (Object)n)});
    }

    public ModuleButtonViewHolder(Context context, Context context2, ViewGroup viewGroup, boolean bl, boolean bl2) {
        kotlin.jvm.internal.o.g((Object)context, (String)"ctx");
        kotlin.jvm.internal.o.g((Object)context2, (String)"sysuiCtx");
        kotlin.jvm.internal.o.g((Object)viewGroup, (String)"rootView");
        super(context, context2, viewGroup, bl);
        this.isDynamicIsland = bl2;
        this.buttonAccessibilityDelegate = new View.AccessibilityDelegate(){

            public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfo accessibilityNodeInfo) {
                kotlin.jvm.internal.o.g((Object)view, (String)"host");
                kotlin.jvm.internal.o.g((Object)accessibilityNodeInfo, (String)"info");
                super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfo);
                accessibilityNodeInfo.setClassName((CharSequence)Button.class.getName());
            }
        };
    }

    public static final /* synthetic */ AnimateImageView access$getImage$p(ModuleButtonViewHolder moduleButtonViewHolder) {
        return moduleButtonViewHolder.image;
    }

    public static final /* synthetic */ CallingShader access$getShader$p(ModuleButtonViewHolder moduleButtonViewHolder) {
        return moduleButtonViewHolder.shader;
    }

    public static final /* synthetic */ StatusProgressLayout access$getStatusProgressLayout$p(ModuleButtonViewHolder moduleButtonViewHolder) {
        return moduleButtonViewHolder.statusProgressLayout;
    }

    public static final /* synthetic */ void access$setShader$p(ModuleButtonViewHolder moduleButtonViewHolder, CallingShader callingShader) {
        moduleButtonViewHolder.shader = callingShader;
    }

    /*
     * WARNING - void declaration
     * Enabled aggressive block sorting
     */
    private final Notification.Action buildAction(ActionInfo actionInfo, StatusBarNotification object) {
        Object object2;
        block24: {
            void var2_14;
            Object object3;
            block37: {
                block38: {
                    Object var8_15;
                    block36: {
                        String string;
                        void var2_7;
                        block35: {
                            Object object4;
                            block29: {
                                block31: {
                                    block33: {
                                        block34: {
                                            Object var9_16;
                                            block32: {
                                                block30: {
                                                    block28: {
                                                        block25: {
                                                            String string2;
                                                            block26: {
                                                                block27: {
                                                                    var8_15 = null;
                                                                    var9_16 = null;
                                                                    object3 = actionInfo != null ? actionInfo.getAction() : null;
                                                                    if (this.isDark()) {
                                                                        object2 = actionInfo != null ? actionInfo.getActionIconDark() : null;
                                                                        object2 = object4 = this.getIcon((String)object2, (StatusBarNotification)object);
                                                                        if (object4 == null) {
                                                                            object2 = actionInfo != null ? actionInfo.getActionIcon() : null;
                                                                            object2 = this.getIcon((String)object2, (StatusBarNotification)object);
                                                                        }
                                                                    } else {
                                                                        object2 = actionInfo != null ? actionInfo.getActionIcon() : null;
                                                                        object2 = this.getIcon((String)object2, (StatusBarNotification)object);
                                                                    }
                                                                    if ((object4 = actionInfo != null ? actionInfo.getActionIntent() : null) == null) break block25;
                                                                    object4 = actionInfo.getActionIntentType();
                                                                    int n = object4 != null ? (Integer)object4 : 1;
                                                                    string2 = actionInfo.getActionIntent();
                                                                    object4 = string2;
                                                                    if (string2 == null) {
                                                                        object4 = "";
                                                                    }
                                                                    object4 = Intent.parseUri((String)object4, (int)1);
                                                                    if (n == 1) break block26;
                                                                    if (n == 2) break block27;
                                                                    if (n != 3) break block25;
                                                                    string2 = object.getUser();
                                                                    kotlin.jvm.internal.o.f((Object)string2, (String)"getUser(...)");
                                                                    PendingIntent pendingIntent = PendingIntent.getService((Context)ModuleViewHolderExtKt.getContextAsUser((UserHandle)string2, this.getSysuiCtx()), (int)((int)object.getPostTime()), (Intent)object4, (int)0xC000000);
                                                                    break block28;
                                                                }
                                                                string2 = object.getUser();
                                                                kotlin.jvm.internal.o.f((Object)string2, (String)"getUser(...)");
                                                                PendingIntent pendingIntent = PendingIntent.getBroadcast((Context)ModuleViewHolderExtKt.getContextAsUser((UserHandle)string2, this.getSysuiCtx()), (int)((int)object.getPostTime()), (Intent)object4, (int)0xC000000);
                                                                break block28;
                                                            }
                                                            string2 = object.getUser();
                                                            kotlin.jvm.internal.o.f((Object)string2, (String)"getUser(...)");
                                                            PendingIntent pendingIntent = PendingIntent.getActivity((Context)ModuleViewHolderExtKt.getContextAsUser((UserHandle)string2, this.getSysuiCtx()), (int)((int)object.getPostTime()), (Intent)object4, (int)0xC000000);
                                                            break block28;
                                                        }
                                                        Object var2_6 = null;
                                                    }
                                                    if (object3 == null) break block29;
                                                    object4 = this.getActionBundle();
                                                    object4 = object4 != null ? (Notification.Action)object4.getParcelable(actionInfo.getAction()) : null;
                                                    if (object4 != null) break block30;
                                                    object2 = new Notification.Action.Builder((Icon)object2, (CharSequence)"", (PendingIntent)var2_7).build();
                                                    object2.getExtras().putString("icon_name", (String)object3);
                                                    object3 = object2;
                                                    break block31;
                                                }
                                                object3 = object4;
                                                if (object2 != null) {
                                                    object3 = new Notification.Action.Builder((Icon)object2, (CharSequence)actionInfo.getActionTitle(), ((Notification.Action)object4).actionIntent).build();
                                                }
                                                if ((object2 = actionInfo != null ? actionInfo.getActionIcon() : null) == null && (object2 = actionInfo != null ? actionInfo.getActionIconDark() : null) == null || object3 == null || (object4 = object3.getExtras()) == null) break block31;
                                                if (!this.isDark()) break block32;
                                                if (actionInfo != null && (object2 = actionInfo.getActionIconDark()) != null) break block33;
                                                object2 = var9_16;
                                                if (actionInfo == null) break block33;
                                                break block34;
                                            }
                                            object2 = var9_16;
                                            if (actionInfo == null) break block33;
                                        }
                                        object2 = actionInfo.getActionIcon();
                                    }
                                    object4.putString("icon_name", (String)object2);
                                }
                                object2 = object3;
                                if (var2_7 != null) {
                                    if (object3 == null) {
                                        object2 = object3;
                                        break block24;
                                    } else {
                                        ((Notification.Action)object3).actionIntent = var2_7;
                                        object2 = object3;
                                    }
                                }
                                break block24;
                            }
                            if (object2 == null && (actionInfo == null || (object3 = actionInfo.getType()) == null || (Integer)object3 != 2)) {
                                object3 = null;
                            } else {
                                object3 = actionInfo != null ? actionInfo.getActionTitle() : null;
                                object3 = new Notification.Action.Builder((Icon)object2, (CharSequence)object3, (PendingIntent)var2_7).build();
                            }
                            if (object2 == null || actionInfo != null && (object4 = actionInfo.getType()) != null && (Integer)object4 == 0 || actionInfo != null && (object4 = actionInfo.getType()) != null && (Integer)object4 == 1) break block35;
                            object2 = object3;
                            break block24;
                        }
                        object3 = actionInfo != null ? actionInfo.getActionTitle() : null;
                        object2 = new Notification.Action.Builder((Icon)object2, (CharSequence)object3, (PendingIntent)var2_7).build();
                        object3 = object2.getExtras();
                        if (!this.isDark()) break block36;
                        if (actionInfo != null && (string = actionInfo.getActionIconDark()) != null) break block37;
                        Object var2_10 = var8_15;
                        if (actionInfo == null) break block37;
                        break block38;
                    }
                    Object var2_13 = var8_15;
                    if (actionInfo == null) break block37;
                }
                String string = actionInfo.getActionIcon();
            }
            object3.putString("icon_name", (String)var2_14);
        }
        if (actionInfo != null) {
            boolean bl = actionInfo.getClickWithCollapse();
            if (object2 != null && (actionInfo = object2.getExtras()) != null) {
                actionInfo.putBoolean("click_with_collapse", bl);
            }
        }
        return object2;
    }

    public static /* synthetic */ void c(Notification.Action action, ModuleButtonViewHolder moduleButtonViewHolder, View view, StatusBarNotification statusBarNotification, View view2) {
        ModuleButtonViewHolder.setActionTextData$lambda$23(action, moduleButtonViewHolder, view, statusBarNotification, view2);
    }

    public static /* synthetic */ void d(Notification.Action action, ModuleButtonViewHolder moduleButtonViewHolder, StatusBarNotification statusBarNotification, String string, StatusProgressLayout statusProgressLayout, int n, View view) {
        ModuleButtonViewHolder.setActionProgressData$lambda$17$lambda$16(action, moduleButtonViewHolder, statusBarNotification, string, statusProgressLayout, n, view);
    }

    public static /* synthetic */ void e(Notification.Action action, ModuleButtonViewHolder moduleButtonViewHolder, StatusBarNotification statusBarNotification, String string, AnimateImageView animateImageView, int n, View view) {
        ModuleButtonViewHolder.setActionNormalData$lambda$6$lambda$5(action, moduleButtonViewHolder, statusBarNotification, string, animateImageView, n, view);
    }

    private final void resetViews(ViewGroup viewGroup2) {
        int n = viewGroup2 != null ? viewGroup2.getChildCount() : 0;
        for (ViewGroup viewGroup2 : l.o((d1.e)u.E((Iterable)f.m((int)0, (int)n)), (Function1)new Function1(viewGroup2){
            final ViewGroup $focusContainer;
            {
                this.$focusContainer = viewGroup;
                super(1);
            }

            public final View invoke(int n) {
                Object object = this.$focusContainer;
                object = object != null ? object.getChildAt(n) : null;
                return object;
            }
        })) {
            if (viewGroup2 == null) continue;
            viewGroup2.setVisibility(8);
        }
    }

    @SuppressLint(value={"ClickableViewAccessibility"})
    private final void setActionNormalData(int n, Notification.Action action, ActionInfo object, StatusBarNotification statusBarNotification) {
        if (action == null) {
            return;
        }
        object = action.getExtras();
        Icon icon = null;
        object = object != null ? object.getString("icon_name") : null;
        Object object2 = this.getView();
        object2 = object2 != null ? (AnimateImageView)object2.findViewById(n) : null;
        Integer n2 = ACTIONS_RESOURCE_MAP.get(object);
        n = n2 != null ? n2 : 0;
        if (n == 0) {
            icon = action.getIcon();
        }
        n2 = LOTTIE_RES_MAP_NEXT.get(object);
        int n3 = n2 != null ? n2 : -1;
        if (object2 != null) {
            if (this.shouldAnimLottie((String)object)) {
                object2.updateAndPauseAnimation(n3, this.getContext(this.isDynamicIsland));
            } else {
                object2.clearLottieFrame();
                object2.updateImageResource((String)object, n, icon);
            }
            object2.setContentDescription(action.title);
            object2.setAccessibilityDelegate((View.AccessibilityDelegate)this.buttonAccessibilityDelegate);
            object2.setOnClickListener((View.OnClickListener)new d(action, this, statusBarNotification, (String)object, (AnimateImageView)object2, n3));
            object2.setVisibility(0);
        }
        if (kotlin.jvm.internal.o.c((Object)object, (Object)"action_answer") && this.isDynamicIsland && object2 != null) {
            this.showShaderIcon((View)object2);
        }
    }

    private static final void setActionNormalData$lambda$6$lambda$5(Notification.Action action, ModuleButtonViewHolder moduleButtonViewHolder, StatusBarNotification statusBarNotification, String string, AnimateImageView animateImageView, int n, View view) {
        kotlin.jvm.internal.o.g((Object)moduleButtonViewHolder, (String)"this$0");
        kotlin.jvm.internal.o.g((Object)statusBarNotification, (String)"$sbn");
        kotlin.jvm.internal.o.g((Object)animateImageView, (String)"$this_apply");
        view = action.actionIntent;
        if (view != null) {
            ModuleViewHolder.handleBtnClick$default(moduleButtonViewHolder, (PendingIntent)view, action, moduleButtonViewHolder.getSysuiCtx(), moduleButtonViewHolder.getView(), moduleButtonViewHolder.isDynamicIsland, statusBarNotification, false, 64, null);
            if (moduleButtonViewHolder.shouldAnimLottie(string)) {
                animateImageView.handleLottieAnim(n);
            }
        }
    }

    private final void setActionProgressData(int n, Notification.Action action, ActionInfo object, StatusBarNotification statusBarNotification) {
        Object object2;
        if (action == null) {
            return;
        }
        Object object3 = action.getExtras();
        Object object4 = null;
        object3 = object3 != null ? object3.getString("icon_name") : null;
        object2 = object != null && (object2 = ((ActionInfo)object).getProgressInfo()) != null ? Boolean.valueOf(((ProgressInfo)object2).isAutoProgress()) : null;
        this.setProgressData(n, statusBarNotification, (Boolean)object2);
        object2 = this.getView();
        object2 = object2 != null ? (StatusProgressLayout)object2.findViewById(n) : null;
        this.statusProgressLayout = object2;
        object2 = ACTIONS_RESOURCE_MAP.get(object3);
        n = object2 != null ? (Integer)object2 : 0;
        object2 = object4;
        if (n == 0) {
            object2 = action.getIcon();
        }
        int n2 = (object4 = LOTTIE_RES_MAP_NEXT.get(object3)) != null ? (Integer)object4 : -1;
        object4 = this.statusProgressLayout;
        if (object4 != null) {
            if (this.shouldAnimLottie((String)object3)) {
                object4.updateAndPauseAnimation(n2, this.getContext(this.isDynamicIsland));
            } else {
                object4.clearLottieFrame();
                object4.updateStatusIcon((String)object3, n, (Icon)object2);
            }
            if (object == null || (object2 = ((ActionInfo)object).getActionTitle()) == null) {
                object2 = action.title;
            }
            object4.setContentDescription((CharSequence)object2);
            object4.setAccessibilityDelegate((View.AccessibilityDelegate)this.buttonAccessibilityDelegate);
        }
        if (object != null && (object2 = ((ActionInfo)object).getProgressInfo()) != null) {
            boolean bl = ((ProgressInfo)object2).isCCW();
            object2 = this.statusProgressLayout;
            if (object2 != null) {
                object2.setCCW(bl);
            }
        }
        if (object != null && (object2 = ((ActionInfo)object).getProgressInfo()) != null) {
            n = ((ProgressInfo)object2).getProgress();
            object2 = ((ActionInfo)object).getProgressInfo();
            if (object2 != null && !((ProgressInfo)object2).isAutoProgress() && (object2 = this.statusProgressLayout) != null) {
                object2.setProgress((float)n);
            }
        }
        if (this.isDark()) {
            if (object != null && (object2 = ((ActionInfo)object).getProgressInfo()) != null && (object4 = ((ProgressInfo)object2).getColorProgressDark()) != null && (object2 = this.statusProgressLayout) != null) {
                object2.updateColor(-1, -1, Color.parseColor((String)object4));
            }
            if (object != null && (object = ((ActionInfo)object).getProgressInfo()) != null && (object = ((ProgressInfo)object).getColorProgressEndDark()) != null && (object2 = this.statusProgressLayout) != null) {
                object2.updateColor(-1, Color.parseColor((String)object), -1);
            }
        } else {
            if (object != null && (object2 = ((ActionInfo)object).getProgressInfo()) != null && (object4 = ((ProgressInfo)object2).getColorProgress()) != null && (object2 = this.statusProgressLayout) != null) {
                object2.updateColor(-1, -1, Color.parseColor((String)object4));
            }
            if (object != null && (object = ((ActionInfo)object).getProgressInfo()) != null && (object = ((ProgressInfo)object).getColorProgressEnd()) != null && (object2 = this.statusProgressLayout) != null) {
                object2.updateColor(-1, Color.parseColor((String)object), -1);
            }
        }
        if ((object = this.statusProgressLayout) != null) {
            object.setOnClickListener((View.OnClickListener)new c(action, this, statusBarNotification, (String)object3, (StatusProgressLayout)object, n2));
            object.setVisibility(0);
        }
    }

    private static final void setActionProgressData$lambda$17$lambda$16(Notification.Action action, ModuleButtonViewHolder moduleButtonViewHolder, StatusBarNotification statusBarNotification, String string, StatusProgressLayout statusProgressLayout, int n, View view) {
        kotlin.jvm.internal.o.g((Object)moduleButtonViewHolder, (String)"this$0");
        kotlin.jvm.internal.o.g((Object)statusBarNotification, (String)"$sbn");
        kotlin.jvm.internal.o.g((Object)statusProgressLayout, (String)"$this_apply");
        view = action.actionIntent;
        if (view != null) {
            ModuleViewHolder.handleBtnClick$default(moduleButtonViewHolder, (PendingIntent)view, action, moduleButtonViewHolder.getSysuiCtx(), moduleButtonViewHolder.getView(), moduleButtonViewHolder.isDynamicIsland, statusBarNotification, false, 64, null);
            if (moduleButtonViewHolder.shouldAnimLottie(string)) {
                statusProgressLayout.handleLottieAnim(n);
            }
        }
    }

    @SuppressLint(value={"UseCompatLoadingForDrawables"})
    private final void setActionTextData(int n, Notification.Action action, ActionInfo object, StatusBarNotification statusBarNotification) {
        if (action == null) {
            return;
        }
        String string = statusBarNotification.getKey();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("setActionTextData ");
        stringBuilder.append(string);
        Log.i((String)"ClickImageDebug", (String)stringBuilder.toString());
        string = this.getView();
        String string2 = null;
        string = string != null ? string.findViewById(n) : null;
        stringBuilder = string != null ? (TextView)string.findViewById(R.id.focus_button_title) : null;
        if (stringBuilder != null) {
            if (object != null) {
                string2 = ((ActionInfo)object).getActionTitle();
            }
            stringBuilder.setText((CharSequence)Html.fromHtml((String)string2), TextView.BufferType.SPANNABLE);
        }
        if (this.isDark()) {
            if (object != null && (string2 = ((ActionInfo)object).getActionTitleColorDark()) != null && stringBuilder != null) {
                stringBuilder.setTextColor(Color.parseColor((String)string2));
            }
        } else if (object != null && (string2 = ((ActionInfo)object).getActionTitleColor()) != null && stringBuilder != null) {
            stringBuilder.setTextColor(Color.parseColor((String)string2));
        }
        if (object != null && (string2 = ((ActionInfo)object).getActionBgColor(this.isDark())) != null) {
            stringBuilder = this.getCtx().getResources().getDrawable(R.drawable.focus_button_background_n).mutate();
            kotlin.jvm.internal.o.e((Object)stringBuilder, (String)"null cannot be cast to non-null type android.graphics.drawable.GradientDrawable");
            stringBuilder = (GradientDrawable)stringBuilder;
            stringBuilder.setColor(Color.parseColor((String)string2));
            StateListDrawable stateListDrawable = new StateListDrawable();
            Drawable drawable2 = this.getCtx().getResources().getDrawable(R.drawable.focus_button_background_p).mutate();
            kotlin.jvm.internal.o.e((Object)drawable2, (String)"null cannot be cast to non-null type android.graphics.drawable.GradientDrawable");
            drawable2 = (GradientDrawable)drawable2;
            drawable2.setColor(PaletteUtils.blendWithColor((int)Color.parseColor((String)string2), (boolean)this.isDark()));
            object = ((ActionInfo)object).getActionBgPressColor(this.isDark());
            if (object != null) {
                drawable2.setColor(Color.parseColor((String)object));
            }
            stateListDrawable.addState(new int[]{16842919}, drawable2);
            stateListDrawable.addState(new int[0], (Drawable)stringBuilder);
            if (string != null) {
                string.setBackground((Drawable)stateListDrawable);
            }
        }
        if (string != null) {
            string.setOnClickListener((View.OnClickListener)new e(action, this, (View)string, statusBarNotification));
        }
        if (string != null) {
            string.setVisibility(0);
        }
    }

    private static final void setActionTextData$lambda$23(Notification.Action action, ModuleButtonViewHolder moduleButtonViewHolder, View view, StatusBarNotification statusBarNotification, View view2) {
        kotlin.jvm.internal.o.g((Object)moduleButtonViewHolder, (String)"this$0");
        kotlin.jvm.internal.o.g((Object)statusBarNotification, (String)"$sbn");
        view2 = action.actionIntent;
        if (view2 != null) {
            ModuleViewHolder.handleBtnClick$default(moduleButtonViewHolder, (PendingIntent)view2, action, moduleButtonViewHolder.getSysuiCtx(), view, moduleButtonViewHolder.isDynamicIsland, statusBarNotification, false, 64, null);
        }
    }

    private final boolean shouldAnimLottie(String string) {
        boolean bl = false;
        boolean bl2 = string != null && LOTTIE_RES_MAP_NEXT.get(string) != null;
        boolean bl3 = this.isDynamicIsland && (string = this.getView()) != null && ModuleViewHolderExtKt.findViewByTagId((View)string, R.id.dynamic_island_animating_tag);
        boolean bl4 = CommonUtils.NOT_SUPPORT_LOTTIE;
        boolean bl5 = bl;
        if (!bl3) {
            bl5 = bl;
            if (bl2) {
                bl5 = bl;
                if (!bl4) {
                    bl5 = true;
                }
            }
        }
        return bl5;
    }

    private final void showShaderIcon(View view) {
        ViewParent viewParent = this.getRootView().getParent().getParent();
        kotlin.jvm.internal.o.e((Object)viewParent, (String)"null cannot be cast to non-null type android.view.ViewGroup");
        viewParent = (ViewGroup)viewParent;
        OneShotPreDrawListener.add((View)viewParent, (Runnable)new Runnable((View)viewParent, this, (ViewGroup)viewParent, view){
            final ViewGroup $parent$inlined;
            final View $this_doOnPreDraw;
            final View $view$inlined;
            final ModuleButtonViewHolder this$0;
            {
                this.$this_doOnPreDraw = view;
                this.this$0 = moduleButtonViewHolder;
                this.$parent$inlined = viewGroup;
                this.$view$inlined = view2;
            }

            public final void run() {
                if (DynamicFeatureConfig.INSTANCE.getFEATURE_DYNAMIC_ISLAND_SHADER()) {
                    ModuleButtonViewHolder.access$setShader$p(this.this$0, ShaderUtil.setShader$default((ShaderUtil)ShaderUtil.INSTANCE, (String)"call", (View)this.$parent$inlined, (float)this.$view$inlined.getWidth(), (float)this.this$0.getCtx().getResources().getDimension(R.dimen.focus_notify_template_margin), (Origin)Origin.END, (boolean)false, (int)32, null));
                    CallingShader callingShader = ModuleButtonViewHolder.access$getShader$p(this.this$0);
                    if (callingShader != null) {
                        callingShader.start();
                    }
                }
            }
        });
    }

    @Override
    public void bind(Template object, StatusBarNotification statusBarNotification) {
        kotlin.jvm.internal.o.g((Object)object, (String)"template");
        kotlin.jvm.internal.o.g((Object)statusBarNotification, (String)"sbn");
        super.bind((Template)object, statusBarNotification);
        this.actions = ((Template)object).getActions();
        object = this.getView();
        Iterator iterator = null;
        object = object != null ? (LinearLayout)object.findViewById(R.id.focus_container_module_button) : null;
        if (object != null) {
            object.setVisibility(0);
        }
        this.resetViews((ViewGroup)object);
        Object object2 = statusBarNotification.getKey();
        object = this.actions;
        object = object != null ? Integer.valueOf(object.size()) : null;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append((String)object2);
        stringBuilder.append(", ");
        stringBuilder.append(object);
        Log.d((String)"ClickImageDebug", (String)stringBuilder.toString());
        object2 = this.actions;
        if (object2 != null) {
            object = iterator;
            if (!object2.isEmpty()) {
                object = object2;
            }
            if (object != null) {
                iterator = u.i0((Iterable)object, (int)3).iterator();
                int n = 0;
                while (iterator.hasNext()) {
                    object = iterator.next();
                    if (n < 0) {
                        m.n();
                    }
                    object2 = (ActionInfo)object;
                    object = n != 0 ? (n != 1 ? o.a((Object)R.id.focus_button_progress3, (Object)R.id.focus_button_icon3) : o.a((Object)R.id.focus_button_progress2, (Object)R.id.focus_button_icon2)) : o.a((Object)R.id.focus_button_progress1, (Object)R.id.focus_button_icon1);
                    int n2 = ((Number)object.a()).intValue();
                    int n3 = ((Number)object.b()).intValue();
                    object = ((ActionInfo)object2).getType();
                    int n4 = object != null ? (Integer)object : 0;
                    if (n4 != 1) {
                        if (n4 != 2) {
                            this.setActionNormalData(n3, this.buildAction((ActionInfo)object2, statusBarNotification), (ActionInfo)object2, statusBarNotification);
                        } else {
                            this.setActionTextData(R.id.focus_button_container_action, this.buildAction((ActionInfo)object2, statusBarNotification), (ActionInfo)object2, statusBarNotification);
                        }
                    } else {
                        this.setActionProgressData(n2, this.buildAction((ActionInfo)object2, statusBarNotification), (ActionInfo)object2, statusBarNotification);
                    }
                    ++n;
                }
            }
        }
    }

    @Override
    public void initView(String string) {
        kotlin.jvm.internal.o.g((Object)string, (String)"module");
        super.initView(string);
        this.setView(LayoutInflater.from((Context)this.getContext(this.isDynamicIsland)).inflate(R.layout.focus_notification_module_button_1, this.getRootView()));
    }

    public final boolean isDynamicIsland() {
        return this.isDynamicIsland;
    }

    @Override
    public void onDetach() {
        CallingShader<?> callingShader = this.shader;
        if (callingShader != null) {
            callingShader.stop();
        }
        f1.f.b((E)this.getScope(), null, null, (U0.o)new U0.o(this, null){
            int label;
            final ModuleButtonViewHolder this$0;
            {
                this.this$0 = moduleButtonViewHolder;
                super(2, d2);
            }

            public final K0.d create(Object object, K0.d d2) {
                return new /* invalid duplicate definition of identical inner class */;
            }

            public final Object invoke(E e2, K0.d d2) {
                return (this.create(e2, d2)).invokeSuspend(s.a);
            }

            public final Object invokeSuspend(Object object) {
                L0.c.c();
                if (this.label == 0) {
                    k.b((Object)object);
                    object = ModuleButtonViewHolder.access$getImage$p(this.this$0);
                    if (object != null) {
                        object.cancelAnimation();
                    }
                    if ((object = ModuleButtonViewHolder.access$getStatusProgressLayout$p(this.this$0)) != null) {
                        object.cancelAnimation();
                    }
                    return s.a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }, (int)3, null);
        super.onDetach();
    }

    @Override
    public void updatePartial(Template template, StatusBarNotification statusBarNotification) {
        kotlin.jvm.internal.o.g((Object)template, (String)"template");
        kotlin.jvm.internal.o.g((Object)statusBarNotification, (String)"sbn");
        super.updatePartial(template, statusBarNotification);
        this.bind(template, statusBarNotification);
    }
}
