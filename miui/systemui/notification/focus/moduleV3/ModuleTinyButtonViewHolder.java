/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  G0.i
 *  G0.k
 *  G0.o
 *  G0.s
 *  H0.G
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
 *  android.os.UserHandle
 *  android.service.notification.StatusBarNotification
 *  android.text.Html
 *  android.util.Log
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.view.ViewGroup
 *  android.widget.LinearLayout
 *  android.widget.TextView
 *  android.widget.TextView$BufferType
 *  b1.f
 *  com.android.systemui.miui.notification.R$drawable
 *  com.android.systemui.miui.notification.R$id
 *  com.android.systemui.miui.notification.R$layout
 *  d1.e
 *  d1.l
 *  f1.E
 *  f1.f
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.o
 *  miui.systemui.widget.AnimateImageView
 *  miui.systemui.widget.StatusProgressLayout
 */
package miui.systemui.notification.focus.moduleV3;

import G0.i;
import G0.k;
import G0.o;
import G0.s;
import H0.G;
import H0.u;
import K0.d;
import L0.c;
import android.annotation.SuppressLint;
import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.Icon;
import android.os.UserHandle;
import android.service.notification.StatusBarNotification;
import android.text.Html;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import b1.f;
import com.android.systemui.miui.notification.R;
import d1.e;
import d1.l;
import f1.E;
import java.util.List;
import java.util.Map;
import kotlin.jvm.functions.Function1;
import miui.systemui.notification.focus.model.ActionInfo;
import miui.systemui.notification.focus.model.ProgressInfo;
import miui.systemui.notification.focus.model.Template;
import miui.systemui.notification.focus.moduleV3.ModuleViewHolder;
import miui.systemui.notification.focus.moduleV3.ext.ModuleViewHolderExtKt;
import miui.systemui.notification.focus.moduleV3.x;
import miui.systemui.notification.focus.moduleV3.y;
import miui.systemui.notification.focus.moduleV3.z;
import miui.systemui.widget.AnimateImageView;
import miui.systemui.widget.StatusProgressLayout;

public final class ModuleTinyButtonViewHolder
extends ModuleViewHolder {
    public static final Companion Companion = new Object(null){
        {
            this();
        }
    };
    private static final Map<String, Integer> MAP = G.h((i[])new i[]{o.a((Object)"action_pause", (Object)R.drawable.pause), o.a((Object)"action_pause_timer", (Object)R.drawable.pause_timer_tiny_v3), o.a((Object)"action_pause_record", (Object)R.drawable.pause_tiny), o.a((Object)"action_restart", (Object)R.drawable.restart_tiny), o.a((Object)"action_restart_timer", (Object)R.drawable.restart_timer_tiny_v3), o.a((Object)"action_copy", (Object)R.drawable.copy_tiny), o.a((Object)"action_done", (Object)R.drawable.done_tiny_v3), o.a((Object)"action_later", (Object)R.drawable.later_v2_tiny), o.a((Object)"action_close", (Object)R.drawable.close_tiny), o.a((Object)"action_end", (Object)R.drawable.end_tiny), o.a((Object)"action_record_end", (Object)R.drawable.record_tiny_end_v3), o.a((Object)"action_hangup", (Object)R.drawable.hangup_tiny), o.a((Object)"action_speaker", (Object)R.drawable.speaker_v2_tiny), o.a((Object)"action_mark_timer", (Object)R.drawable.mark_timer_tiny)});
    private List<ActionInfo> actions;
    private AnimateImageView image;
    private StatusProgressLayout statusProgressLayout;

    public ModuleTinyButtonViewHolder(Context context, Context context2, ViewGroup viewGroup, boolean bl) {
        kotlin.jvm.internal.o.g((Object)context, (String)"ctx");
        kotlin.jvm.internal.o.g((Object)context2, (String)"sysuiCtx");
        kotlin.jvm.internal.o.g((Object)viewGroup, (String)"rootView");
        super(context, context2, viewGroup, bl);
    }

    public static final /* synthetic */ AnimateImageView access$getImage$p(ModuleTinyButtonViewHolder moduleTinyButtonViewHolder) {
        return moduleTinyButtonViewHolder.image;
    }

    public static final /* synthetic */ StatusProgressLayout access$getStatusProgressLayout$p(ModuleTinyButtonViewHolder moduleTinyButtonViewHolder) {
        return moduleTinyButtonViewHolder.statusProgressLayout;
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

    public static /* synthetic */ void c(Notification.Action action, ModuleTinyButtonViewHolder moduleTinyButtonViewHolder, StatusBarNotification statusBarNotification, View view) {
        ModuleTinyButtonViewHolder.setActionData$lambda$14(action, moduleTinyButtonViewHolder, statusBarNotification, view);
    }

    public static /* synthetic */ void d(Notification.Action action, ModuleTinyButtonViewHolder moduleTinyButtonViewHolder, View view, StatusBarNotification statusBarNotification, View view2) {
        ModuleTinyButtonViewHolder.setActionTextData$lambda$12(action, moduleTinyButtonViewHolder, view, statusBarNotification, view2);
    }

    public static /* synthetic */ void e(Notification.Action action, ModuleTinyButtonViewHolder moduleTinyButtonViewHolder, StatusBarNotification statusBarNotification, View view) {
        ModuleTinyButtonViewHolder.setActionProgressData$lambda$6(action, moduleTinyButtonViewHolder, statusBarNotification, view);
    }

    private final void resetViews(ViewGroup viewGroup2) {
        int n = viewGroup2 != null ? viewGroup2.getChildCount() : 0;
        for (ViewGroup viewGroup2 : l.o((e)u.E((Iterable)f.m((int)0, (int)n)), (Function1)new Function1(viewGroup2){
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

    private final void setActionData(int n, Notification.Action action, StatusBarNotification statusBarNotification) {
        if (action == null) {
            return;
        }
        Object object = this.getView();
        object = object != null ? (AnimateImageView)object.findViewById(n) : null;
        this.image = object;
        object = action.getExtras().getString("icon_name");
        Integer n2 = MAP.get(object);
        n = n2 != null ? n2 : 0;
        n2 = this.image;
        if (n2 != null) {
            n2.updateImageResource((String)object, n, action.getIcon());
        }
        if ((object = this.image) != null) {
            object.setContentDescription(action.title);
        }
        object = this.image;
        if (object != null) {
            object.setOnClickListener((View.OnClickListener)new y(action, this, statusBarNotification));
        }
        if ((action = this.image) != null) {
            action.setVisibility(0);
        }
    }

    private static final void setActionData$lambda$14(Notification.Action action, ModuleTinyButtonViewHolder moduleTinyButtonViewHolder, StatusBarNotification statusBarNotification, View view) {
        kotlin.jvm.internal.o.g((Object)moduleTinyButtonViewHolder, (String)"this$0");
        kotlin.jvm.internal.o.g((Object)statusBarNotification, (String)"$sbn");
        view = action.actionIntent;
        if (view != null) {
            moduleTinyButtonViewHolder.handleBtnClick((PendingIntent)view, action, moduleTinyButtonViewHolder.getSysuiCtx(), moduleTinyButtonViewHolder.getView(), false, statusBarNotification, false);
        }
    }

    private final void setActionProgressData(int n, Notification.Action action, ActionInfo object, StatusBarNotification statusBarNotification) {
        if (action == null) {
            return;
        }
        Object object2 = this.getView();
        StatusProgressLayout statusProgressLayout = null;
        object2 = object2 != null ? (StatusProgressLayout)object2.findViewById(n) : null;
        this.statusProgressLayout = object2;
        object2 = object != null && (object2 = ((ActionInfo)object).getProgressInfo()) != null ? Boolean.valueOf(((ProgressInfo)object2).isAutoProgress()) : null;
        this.setProgressData(n, statusBarNotification, (Boolean)object2);
        String string = action.getExtras().getString("icon_name");
        object2 = MAP.get(string);
        n = object2 != null ? (Integer)object2 : 0;
        object2 = statusProgressLayout;
        if (n == 0) {
            object2 = action.getIcon();
        }
        if ((statusProgressLayout = this.statusProgressLayout) != null) {
            statusProgressLayout.updateStatusIcon(string, n, (Icon)object2);
        }
        if ((statusProgressLayout = this.statusProgressLayout) != null) {
            if (object == null || (object2 = ((ActionInfo)object).getActionTitle()) == null) {
                object2 = action.title;
            }
            statusProgressLayout.setContentDescription((CharSequence)object2);
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
        if (object != null && (object2 = ((ActionInfo)object).getProgressInfo()) != null && (object2 = ((ProgressInfo)object2).getColorProgress()) != null && (statusProgressLayout = this.statusProgressLayout) != null) {
            statusProgressLayout.updateColor(-1, -1, Color.parseColor((String)object2));
        }
        if (object != null && (object = ((ActionInfo)object).getProgressInfo()) != null && (object = ((ProgressInfo)object).getColorProgressEnd()) != null && (object2 = this.statusProgressLayout) != null) {
            object2.updateColor(-1, Color.parseColor((String)object), -1);
        }
        if ((object = this.statusProgressLayout) != null) {
            object.setOnClickListener((View.OnClickListener)new x(action, this, statusBarNotification));
        }
        if ((action = this.statusProgressLayout) != null) {
            action.setVisibility(0);
        }
    }

    private static final void setActionProgressData$lambda$6(Notification.Action action, ModuleTinyButtonViewHolder moduleTinyButtonViewHolder, StatusBarNotification statusBarNotification, View view) {
        kotlin.jvm.internal.o.g((Object)moduleTinyButtonViewHolder, (String)"this$0");
        kotlin.jvm.internal.o.g((Object)statusBarNotification, (String)"$sbn");
        view = action.actionIntent;
        if (view != null) {
            moduleTinyButtonViewHolder.handleBtnClick((PendingIntent)view, action, moduleTinyButtonViewHolder.getSysuiCtx(), moduleTinyButtonViewHolder.getView(), false, statusBarNotification, false);
        }
    }

    @SuppressLint(value={"UseCompatLoadingForDrawables"})
    private final void setActionTextData(int n, Notification.Action action, ActionInfo object, StatusBarNotification statusBarNotification) {
        if (action == null) {
            return;
        }
        Object object2 = this.getView();
        String string = null;
        TextView textView = (object2 = object2 != null ? object2.findViewById(n) : null) != null ? (TextView)object2.findViewById(R.id.focus_button_title) : null;
        if (textView != null) {
            if (object != null) {
                string = ((ActionInfo)object).getActionTitle();
            }
            textView.setText((CharSequence)Html.fromHtml((String)string), TextView.BufferType.SPANNABLE);
        }
        if (this.isDark()) {
            if (object != null && (string = ((ActionInfo)object).getActionTitleColorDark()) != null && textView != null) {
                textView.setTextColor(Color.parseColor((String)string));
            }
        } else if (object != null && (string = ((ActionInfo)object).getActionTitleColor()) != null && textView != null) {
            textView.setTextColor(Color.parseColor((String)string));
        }
        if (this.isDark()) {
            if (object != null && (object = ((ActionInfo)object).getActionBgColorDark()) != null) {
                textView = this.getCtx().getResources().getDrawable(R.drawable.focus_button_background);
                kotlin.jvm.internal.o.e((Object)textView, (String)"null cannot be cast to non-null type android.graphics.drawable.GradientDrawable");
                textView = (GradientDrawable)textView;
                textView.setColor(Color.parseColor((String)object));
                if (object2 != null) {
                    object2.setBackground((Drawable)textView);
                }
            }
        } else if (object != null && (object = ((ActionInfo)object).getActionBgColor()) != null) {
            textView = this.getCtx().getResources().getDrawable(R.drawable.focus_button_background);
            kotlin.jvm.internal.o.e((Object)textView, (String)"null cannot be cast to non-null type android.graphics.drawable.GradientDrawable");
            textView = (GradientDrawable)textView;
            textView.setColor(Color.parseColor((String)object));
            if (object2 != null) {
                object2.setBackground((Drawable)textView);
            }
        }
        if (object2 != null) {
            object2.setOnClickListener((View.OnClickListener)new z(action, this, (View)object2, statusBarNotification));
        }
        if (object2 != null) {
            object2.setVisibility(0);
        }
    }

    private static final void setActionTextData$lambda$12(Notification.Action action, ModuleTinyButtonViewHolder moduleTinyButtonViewHolder, View view, StatusBarNotification statusBarNotification, View view2) {
        kotlin.jvm.internal.o.g((Object)moduleTinyButtonViewHolder, (String)"this$0");
        kotlin.jvm.internal.o.g((Object)statusBarNotification, (String)"$sbn");
        view2 = action.actionIntent;
        if (view2 != null) {
            ModuleViewHolder.handleBtnClick$default(moduleTinyButtonViewHolder, (PendingIntent)view2, action, moduleTinyButtonViewHolder.getSysuiCtx(), view, false, statusBarNotification, false, 64, null);
        }
    }

    @Override
    public void bind(Template list, StatusBarNotification statusBarNotification) {
        int n;
        kotlin.jvm.internal.o.g((Object)list, (String)"template");
        kotlin.jvm.internal.o.g((Object)statusBarNotification, (String)"sbn");
        super.bind((Template)((Object)list), statusBarNotification);
        Object object = ((Template)((Object)list)).getActions();
        Object var5_4 = null;
        Object var7_5 = null;
        Object var6_6 = null;
        object = object != null ? Integer.valueOf(object.size()) : null;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("ModuleTinyButtonViewHolder bind: ");
        stringBuilder.append(object);
        Log.d((String)"ModuleViewHolder", (String)stringBuilder.toString());
        this.actions = ((Template)((Object)list)).getActions();
        list = this.getView();
        list = list != null ? (LinearLayout)list.findViewById(R.id.focus_container_module_button) : null;
        if (list != null) {
            list.setVisibility(0);
        }
        this.resetViews((ViewGroup)list);
        list = this.actions;
        list = list != null ? Integer.valueOf(list.size()) : null;
        if (list != null) {
            list = this.actions;
            list = list != null ? Integer.valueOf(list.size()) : null;
            kotlin.jvm.internal.o.d(list);
            if ((Integer)((Object)list) > 0) {
                list = this.actions;
                list = list != null && (list = list.get(0)) != null ? ((ActionInfo)((Object)list)).getType() : null;
                if (list != null && (Integer)((Object)list) == 1) {
                    n = R.id.focus_button_progress1;
                    list = this.actions;
                    list = list != null ? list.get(0) : null;
                    list = this.buildAction((ActionInfo)((Object)list), statusBarNotification);
                    object = this.actions;
                    kotlin.jvm.internal.o.d((Object)object);
                    this.setActionProgressData(n, (Notification.Action)list, (ActionInfo)object.get(0), statusBarNotification);
                } else if (list != null && (Integer)((Object)list) == 2) {
                    n = R.id.focus_button_container_action;
                    list = this.actions;
                    list = list != null ? list.get(0) : null;
                    object = this.buildAction((ActionInfo)((Object)list), statusBarNotification);
                    list = this.actions;
                    kotlin.jvm.internal.o.d(list);
                    this.setActionTextData(n, (Notification.Action)object, (ActionInfo)list.get(0), statusBarNotification);
                } else {
                    n = R.id.focus_button_icon1;
                    list = this.actions;
                    list = list != null ? list.get(0) : null;
                    this.setActionData(n, this.buildAction((ActionInfo)((Object)list), statusBarNotification), statusBarNotification);
                }
            }
        }
        if ((list = (list = this.actions) != null ? Integer.valueOf(list.size()) : null) != null) {
            list = this.actions;
            list = list != null ? Integer.valueOf(list.size()) : null;
            kotlin.jvm.internal.o.d(list);
            if ((Integer)((Object)list) > 1) {
                list = this.actions;
                list = list != null && (list = list.get(1)) != null ? ((ActionInfo)((Object)list)).getType() : null;
                if (list != null && (Integer)((Object)list) == 1) {
                    n = R.id.focus_button_progress2;
                    object = this.actions;
                    list = var6_6;
                    if (object != null) {
                        list = (ActionInfo)object.get(1);
                    }
                    list = this.buildAction((ActionInfo)((Object)list), statusBarNotification);
                    object = this.actions;
                    kotlin.jvm.internal.o.d((Object)object);
                    this.setActionProgressData(n, (Notification.Action)list, (ActionInfo)object.get(1), statusBarNotification);
                } else if (list != null && (Integer)((Object)list) == 2) {
                    n = R.id.focus_button_container_action;
                    object = this.actions;
                    list = var5_4;
                    if (object != null) {
                        list = (ActionInfo)object.get(1);
                    }
                    object = this.buildAction((ActionInfo)((Object)list), statusBarNotification);
                    list = this.actions;
                    kotlin.jvm.internal.o.d(list);
                    this.setActionTextData(n, (Notification.Action)object, list.get(1), statusBarNotification);
                } else {
                    n = R.id.focus_button_icon2;
                    object = this.actions;
                    list = var7_5;
                    if (object != null) {
                        list = (ActionInfo)object.get(1);
                    }
                    this.setActionData(n, this.buildAction((ActionInfo)((Object)list), statusBarNotification), statusBarNotification);
                }
            }
        }
    }

    @Override
    public void initView(String string) {
        kotlin.jvm.internal.o.g((Object)string, (String)"module");
        super.initView(string);
        this.setView(LayoutInflater.from((Context)ModuleViewHolder.getContext$default(this, false, 1, null)).inflate(R.layout.focus_notification_module_tiny_button_1, this.getRootView()));
    }

    @Override
    public void onDetach() {
        f1.f.b((E)this.getScope(), null, null, (U0.o)new U0.o(this, null){
            int label;
            final ModuleTinyButtonViewHolder this$0;
            {
                this.this$0 = moduleTinyButtonViewHolder;
                super(2, d2);
            }

            public final d create(Object object, d d2) {
                return new /* invalid duplicate definition of identical inner class */;
            }

            public final Object invoke(E e2, d d2) {
                return (this.create(e2, d2)).invokeSuspend(s.a);
            }

            public final Object invokeSuspend(Object object) {
                c.c();
                if (this.label == 0) {
                    k.b((Object)object);
                    object = ModuleTinyButtonViewHolder.access$getImage$p(this.this$0);
                    if (object != null) {
                        object.cancelAnimation();
                    }
                    if ((object = ModuleTinyButtonViewHolder.access$getStatusProgressLayout$p(this.this$0)) != null) {
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
