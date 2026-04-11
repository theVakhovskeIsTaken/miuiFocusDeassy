/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  G0.i
 *  G0.k
 *  G0.o
 *  G0.s
 *  H0.G
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
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.view.ViewGroup
 *  android.widget.LinearLayout
 *  android.widget.TextView
 *  android.widget.TextView$BufferType
 *  com.android.systemui.miui.notification.R$dimen
 *  com.android.systemui.miui.notification.R$drawable
 *  com.android.systemui.miui.notification.R$id
 *  com.android.systemui.miui.notification.R$layout
 *  f1.E
 *  f1.f
 *  kotlin.jvm.internal.o
 *  miui.systemui.util.CommonUtils
 *  miui.systemui.widget.AnimateImageView
 *  miui.systemui.widget.StatusProgressLayout
 */
package miui.systemui.notification.focus.moduleV3;

import G0.k;
import G0.o;
import G0.s;
import H0.G;
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
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.android.systemui.miui.notification.R;
import f1.E;
import f1.f;
import java.util.List;
import java.util.Map;
import miui.systemui.notification.focus.model.ActionInfo;
import miui.systemui.notification.focus.model.ProgressInfo;
import miui.systemui.notification.focus.model.Template;
import miui.systemui.notification.focus.moduleV3.ModuleViewHolder;
import miui.systemui.notification.focus.moduleV3.ext.ModuleViewHolderExtKt;
import miui.systemui.notification.focus.moduleV3.g;
import miui.systemui.notification.focus.moduleV3.h;
import miui.systemui.notification.focus.moduleV3.i;
import miui.systemui.util.CommonUtils;
import miui.systemui.widget.AnimateImageView;
import miui.systemui.widget.StatusProgressLayout;

public final class ModuleDecoLandButtonViewHolder
extends ModuleViewHolder {
    public static final Companion Companion = new Object(null){
        {
            this();
        }
    };
    private static final Map<String, Integer> MAP = G.h((G0.i[])new G0.i[]{o.a((Object)"action_pause", (Object)R.drawable.pause_deco), o.a((Object)"action_pause_timer", (Object)R.drawable.pause_timer_deco_land_v3), o.a((Object)"action_pause_record", (Object)R.drawable.pause_deco_land_v2), o.a((Object)"action_restart", (Object)R.drawable.restart_deco), o.a((Object)"action_restart_timer", (Object)R.drawable.restart_timer_deco_land_v3), o.a((Object)"action_restart_record", (Object)R.drawable.restart_deco_land_v2), o.a((Object)"action_copy", (Object)R.drawable.copy_deco_land), o.a((Object)"action_done", (Object)R.drawable.done_deco_v3), o.a((Object)"action_later", (Object)R.drawable.later_deco), o.a((Object)"action_later_timer", (Object)R.drawable.later_deco_land_v2), o.a((Object)"action_close", (Object)R.drawable.close_big_deco_land_v2), o.a((Object)"action_end", (Object)R.drawable.end_deco_land_v2), o.a((Object)"action_record_end", (Object)R.drawable.record_end_deco_land_v3), o.a((Object)"action_hangup", (Object)R.drawable.hangup_deco_land_v2), o.a((Object)"action_speaker", (Object)R.drawable.speaker_deco_land_v2), o.a((Object)"action_mark_timer", (Object)R.drawable.mark_timer_deco_land)});
    private List<ActionInfo> actions;
    private final String close;
    private final String done;
    private View focusButtonContainerAction;
    private AnimateImageView focusButtonIcon1;
    private AnimateImageView focusButtonIcon2;
    private StatusProgressLayout focusButtonProgress1;
    private StatusProgressLayout focusButtonProgress2;
    private View focusButtonSpace;
    private LinearLayout focusContainerModuleButton;
    private AnimateImageView image;
    private AnimateImageView imageDone;
    private StatusProgressLayout statusProgressLayout;

    public ModuleDecoLandButtonViewHolder(Context context, Context context2, ViewGroup viewGroup, boolean bl) {
        kotlin.jvm.internal.o.g((Object)context, (String)"ctx");
        kotlin.jvm.internal.o.g((Object)context2, (String)"sysuiCtx");
        kotlin.jvm.internal.o.g((Object)viewGroup, (String)"rootView");
        super(context, context2, viewGroup, bl);
        this.done = "action_done";
        this.close = "action_close";
    }

    public static final /* synthetic */ AnimateImageView access$getImage$p(ModuleDecoLandButtonViewHolder moduleDecoLandButtonViewHolder) {
        return moduleDecoLandButtonViewHolder.image;
    }

    public static final /* synthetic */ AnimateImageView access$getImageDone$p(ModuleDecoLandButtonViewHolder moduleDecoLandButtonViewHolder) {
        return moduleDecoLandButtonViewHolder.imageDone;
    }

    public static final /* synthetic */ StatusProgressLayout access$getStatusProgressLayout$p(ModuleDecoLandButtonViewHolder moduleDecoLandButtonViewHolder) {
        return moduleDecoLandButtonViewHolder.statusProgressLayout;
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

    public static /* synthetic */ void c(Notification.Action action, ModuleDecoLandButtonViewHolder moduleDecoLandButtonViewHolder, StatusBarNotification statusBarNotification, View view) {
        ModuleDecoLandButtonViewHolder.setActionProgressData$lambda$10(action, moduleDecoLandButtonViewHolder, statusBarNotification, view);
    }

    public static /* synthetic */ void d(Notification.Action action, ModuleDecoLandButtonViewHolder moduleDecoLandButtonViewHolder, StatusBarNotification statusBarNotification, View view) {
        ModuleDecoLandButtonViewHolder.setActionData$lambda$13$lambda$12(action, moduleDecoLandButtonViewHolder, statusBarNotification, view);
    }

    public static /* synthetic */ void e(Notification.Action action, ModuleDecoLandButtonViewHolder moduleDecoLandButtonViewHolder, View view, StatusBarNotification statusBarNotification, View view2) {
        ModuleDecoLandButtonViewHolder.setActionTextData$lambda$5(action, moduleDecoLandButtonViewHolder, view, statusBarNotification, view2);
    }

    private final void setActionData(int n, Notification.Action action, StatusBarNotification statusBarNotification) {
        Object object;
        int n2;
        if (action == null) {
            return;
        }
        String string = action.getExtras().getString("icon_name");
        n2 = kotlin.jvm.internal.o.c((Object)string, (Object)"action_close") && (n2 = (object = this.actions) != null ? object.size() : 0) > 1 ? R.drawable.close_deco_land_v2 : ((object = MAP.get(string)) != null ? (Integer)object : 0);
        boolean bl = kotlin.jvm.internal.o.c((Object)string, (Object)"action_done");
        LinearLayout linearLayout = null;
        object = null;
        if (bl) {
            linearLayout = this.focusContainerModuleButton;
            if (linearLayout != null) {
                linearLayout.setVisibility(8);
            }
            if (this.imageDone == null) {
                linearLayout = this.getView();
                if (linearLayout != null) {
                    object = (AnimateImageView)linearLayout.findViewById(R.id.focus_button_icon_done);
                }
                this.imageDone = object;
            }
            object = this.imageDone;
        } else {
            View view = this.getView();
            object = linearLayout;
            if (view != null) {
                object = (AnimateImageView)view.findViewById(n);
            }
        }
        this.image = object;
        if (object != null) {
            object.updateImageResource(string, n2, action.getIcon());
            object.setContentDescription(action.title);
            object.setOnClickListener((View.OnClickListener)new g(action, this, statusBarNotification));
            object.setVisibility(0);
        }
    }

    private static final void setActionData$lambda$13$lambda$12(Notification.Action action, ModuleDecoLandButtonViewHolder moduleDecoLandButtonViewHolder, StatusBarNotification statusBarNotification, View view) {
        kotlin.jvm.internal.o.g((Object)moduleDecoLandButtonViewHolder, (String)"this$0");
        kotlin.jvm.internal.o.g((Object)statusBarNotification, (String)"$sbn");
        view = action.actionIntent;
        if (view != null) {
            moduleDecoLandButtonViewHolder.handleBtnClick((PendingIntent)view, action, moduleDecoLandButtonViewHolder.getSysuiCtx(), moduleDecoLandButtonViewHolder.getView(), false, statusBarNotification, false);
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
        String string = action.getExtras().getString("icon_name");
        n = kotlin.jvm.internal.o.c((Object)string, (Object)"action_close") && (n = (object2 = this.actions) != null ? object2.size() : 0) > 1 ? R.drawable.close_deco_land_v2 : ((object2 = MAP.get(string)) != null ? (Integer)object2 : 0);
        object2 = n != 0 ? statusProgressLayout : action.getIcon();
        statusProgressLayout = this.statusProgressLayout;
        if (statusProgressLayout != null) {
            statusProgressLayout.updateStatusIcon(string, n, (Icon)object2);
        }
        if ((statusProgressLayout = this.statusProgressLayout) != null) {
            if (object == null || (object2 = ((ActionInfo)object).getActionTitle()) == null) {
                object2 = action.title;
            }
            statusProgressLayout.setContentDescription((CharSequence)object2);
        }
        if (object != null && (object2 = ((ActionInfo)object).getProgressInfo()) != null) {
            n = ((ProgressInfo)object2).getProgress();
            object2 = this.statusProgressLayout;
            if (object2 != null) {
                object2.setProgress((float)n);
            }
        }
        if (object != null && (object2 = ((ActionInfo)object).getProgressInfo()) != null && (object2 = ((ProgressInfo)object2).getColorProgress()) != null && (statusProgressLayout = this.statusProgressLayout) != null) {
            statusProgressLayout.updateColor(-1, -1, Color.parseColor((String)object2));
        }
        if (object != null && (object = ((ActionInfo)object).getProgressInfo()) != null && (object2 = ((ProgressInfo)object).getColorProgressEnd()) != null && (object = this.statusProgressLayout) != null) {
            object.updateColor(-1, Color.parseColor((String)object2), -1);
        }
        if ((object = this.statusProgressLayout) != null) {
            object.setOnClickListener((View.OnClickListener)new h(action, this, statusBarNotification));
        }
        if ((action = this.statusProgressLayout) != null) {
            action.setVisibility(0);
        }
    }

    private static final void setActionProgressData$lambda$10(Notification.Action action, ModuleDecoLandButtonViewHolder moduleDecoLandButtonViewHolder, StatusBarNotification statusBarNotification, View view) {
        kotlin.jvm.internal.o.g((Object)moduleDecoLandButtonViewHolder, (String)"this$0");
        kotlin.jvm.internal.o.g((Object)statusBarNotification, (String)"$sbn");
        view = action.actionIntent;
        if (view != null) {
            moduleDecoLandButtonViewHolder.handleBtnClick((PendingIntent)view, action, moduleDecoLandButtonViewHolder.getSysuiCtx(), moduleDecoLandButtonViewHolder.getView(), false, statusBarNotification, false);
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
            object2.setOnClickListener((View.OnClickListener)new i(action, this, (View)object2, statusBarNotification));
        }
        if (object2 != null) {
            object2.setVisibility(0);
        }
    }

    private static final void setActionTextData$lambda$5(Notification.Action action, ModuleDecoLandButtonViewHolder moduleDecoLandButtonViewHolder, View view, StatusBarNotification statusBarNotification, View view2) {
        kotlin.jvm.internal.o.g((Object)moduleDecoLandButtonViewHolder, (String)"this$0");
        kotlin.jvm.internal.o.g((Object)statusBarNotification, (String)"$sbn");
        view2 = action.actionIntent;
        if (view2 != null) {
            ModuleViewHolder.handleBtnClick$default(moduleDecoLandButtonViewHolder, (PendingIntent)view2, action, moduleDecoLandButtonViewHolder.getSysuiCtx(), view, false, statusBarNotification, false, 64, null);
        }
    }

    @Override
    public void bind(Template object, StatusBarNotification statusBarNotification) {
        kotlin.jvm.internal.o.g((Object)object, (String)"template");
        kotlin.jvm.internal.o.g((Object)statusBarNotification, (String)"sbn");
        super.bind((Template)object, statusBarNotification);
        this.actions = ((Template)object).getActions();
        object = this.focusContainerModuleButton;
        if (object != null) {
            object.setVisibility(0);
        }
        object = this.imageDone;
        if (object != null) {
            object.setVisibility(8);
        }
        object = this.actions;
        int n = object != null ? object.size() : 0;
        List<ActionInfo> list = null;
        Object var7_5 = null;
        Object object2 = null;
        List<ActionInfo> list2 = null;
        List<ActionInfo> list3 = null;
        if (n == 1) {
            object = this.focusButtonSpace;
            if (object != null) {
                object.setVisibility(8);
            }
            object = this.focusButtonIcon2;
            if (object != null) {
                object.setVisibility(8);
            }
            object = this.focusButtonProgress2;
            if (object != null) {
                object.setVisibility(8);
            }
            object = this.actions;
            object = object != null && (object = (ActionInfo)object.get(0)) != null ? ((ActionInfo)object).getType() : null;
            if (object != null && (Integer)object == 1) {
                object = this.focusButtonIcon1;
                if (object != null) {
                    object.setVisibility(8);
                }
                object = this.focusButtonProgress1;
                if (object != null) {
                    object.setVisibility(0);
                }
                object = this.focusButtonContainerAction;
                if (object != null) {
                    object.setVisibility(8);
                }
                object = this.focusButtonProgress1;
                if (object != null) {
                    CommonUtils.setLayoutWidth$default((CommonUtils)CommonUtils.INSTANCE, (View)object, (int)-1, (boolean)false, (int)2, null);
                }
                int n2 = R.id.focus_button_progress1;
                object = this.actions;
                object = object != null ? (ActionInfo)object.get(0) : null;
                object = this.buildAction((ActionInfo)object, statusBarNotification);
                list3 = this.actions;
                kotlin.jvm.internal.o.d(list3);
                this.setActionProgressData(n2, (Notification.Action)object, list3.get(0), statusBarNotification);
            } else {
                if (object != null && (Integer)object == 2) {
                    object = this.focusButtonIcon1;
                    if (object != null) {
                        object.setVisibility(8);
                    }
                    object = this.focusButtonProgress1;
                    if (object != null) {
                        object.setVisibility(8);
                    }
                    object = this.focusButtonContainerAction;
                    if (object != null) {
                        object.setVisibility(0);
                    }
                    n = R.id.focus_button_container_action;
                    object2 = this.actions;
                    object = list3;
                    if (object2 != null) {
                        object = (ActionInfo)object2.get(0);
                    }
                    object = this.buildAction((ActionInfo)object, statusBarNotification);
                    object2 = this.actions;
                    kotlin.jvm.internal.o.d((Object)object2);
                    this.setActionTextData(n, (Notification.Action)object, (ActionInfo)object2.get(0), statusBarNotification);
                    return;
                }
                object = this.focusButtonIcon1;
                if (object != null) {
                    CommonUtils.setLayoutWidth$default((CommonUtils)CommonUtils.INSTANCE, (View)object, (int)-1, (boolean)false, (int)2, null);
                }
                if ((object = this.focusButtonProgress1) != null) {
                    object.setVisibility(8);
                }
                object = this.focusButtonContainerAction;
                if (object != null) {
                    object.setVisibility(8);
                }
                int n3 = R.id.focus_button_icon1;
                object = this.actions;
                object = object != null ? (ActionInfo)object.get(0) : null;
                this.setActionData(n3, this.buildAction((ActionInfo)object, statusBarNotification), statusBarNotification);
            }
        }
        if (n > 1) {
            object = this.focusButtonSpace;
            if (object != null) {
                object.setVisibility(0);
            }
            object = this.actions;
            object = object != null && (object = (ActionInfo)object.get(0)) != null ? ((ActionInfo)object).getType() : null;
            if (object != null && (Integer)object == 1) {
                object = this.focusButtonProgress1;
                if (object != null) {
                    CommonUtils.setLayoutWidth$default((CommonUtils)CommonUtils.INSTANCE, (View)object, (int)((int)this.getCtx().getResources().getDimension(R.dimen.focus_notify_deco_land_action_width)), (boolean)false, (int)2, null);
                }
                n = R.id.focus_button_progress1;
                object = this.actions;
                object = object != null ? (ActionInfo)object.get(0) : null;
                object = this.buildAction((ActionInfo)object, statusBarNotification);
                list = this.actions;
                kotlin.jvm.internal.o.d(list);
                this.setActionProgressData(n, (Notification.Action)object, list.get(0), statusBarNotification);
            } else {
                if (object != null && (Integer)object == 2) {
                    n = R.id.focus_button_container_action;
                    object2 = this.actions;
                    object = list;
                    if (object2 != null) {
                        object = object2.get(0);
                    }
                    object2 = this.buildAction((ActionInfo)object, statusBarNotification);
                    object = this.actions;
                    kotlin.jvm.internal.o.d((Object)object);
                    this.setActionTextData(n, (Notification.Action)object2, (ActionInfo)object.get(0), statusBarNotification);
                    return;
                }
                object = this.focusButtonIcon1;
                if (object != null) {
                    CommonUtils.setLayoutWidth$default((CommonUtils)CommonUtils.INSTANCE, (View)object, (int)((int)this.getCtx().getResources().getDimension(R.dimen.focus_notify_deco_land_action_width)), (boolean)false, (int)2, null);
                }
                n = R.id.focus_button_icon1;
                object = this.actions;
                object = object != null ? (ActionInfo)object.get(0) : null;
                this.setActionData(n, this.buildAction((ActionInfo)object, statusBarNotification), statusBarNotification);
            }
            object = this.actions;
            object = object != null && (object = (ActionInfo)object.get(1)) != null ? ((ActionInfo)object).getType() : null;
            if (object != null && (Integer)object == 1) {
                n = R.id.focus_button_progress2;
                object2 = this.actions;
                object = var7_5;
                if (object2 != null) {
                    object = (ActionInfo)object2.get(1);
                }
                object2 = this.buildAction((ActionInfo)object, statusBarNotification);
                object = this.actions;
                kotlin.jvm.internal.o.d((Object)object);
                this.setActionProgressData(n, (Notification.Action)object2, (ActionInfo)object.get(1), statusBarNotification);
            } else {
                if (object != null && (Integer)object == 2) {
                    n = R.id.focus_button_container_action;
                    list2 = this.actions;
                    object = object2;
                    if (list2 != null) {
                        object = list2.get(1);
                    }
                    object2 = this.buildAction((ActionInfo)object, statusBarNotification);
                    object = this.actions;
                    kotlin.jvm.internal.o.d((Object)object);
                    this.setActionTextData(n, (Notification.Action)object2, (ActionInfo)object.get(1), statusBarNotification);
                    return;
                }
                n = R.id.focus_button_icon2;
                object2 = this.actions;
                object = list2;
                if (object2 != null) {
                    object = (ActionInfo)object2.get(1);
                }
                this.setActionData(n, this.buildAction((ActionInfo)object, statusBarNotification), statusBarNotification);
            }
        }
    }

    @Override
    public void initView(String string) {
        kotlin.jvm.internal.o.g((Object)string, (String)"module");
        super.initView(string);
        Object var2_2 = null;
        this.setView(LayoutInflater.from((Context)ModuleViewHolder.getContext$default(this, false, 1, null)).inflate(R.layout.focus_notification_module_deco_land_button_1, this.getRootView()));
        string = this.getView();
        string = string != null ? (LinearLayout)string.findViewById(R.id.focus_container_module_button) : null;
        this.focusContainerModuleButton = string;
        string = this.getView();
        string = string != null ? (AnimateImageView)string.findViewById(R.id.focus_button_icon1) : null;
        this.focusButtonIcon1 = string;
        string = this.getView();
        string = string != null ? (StatusProgressLayout)string.findViewById(R.id.focus_button_progress1) : null;
        this.focusButtonProgress1 = string;
        string = this.getView();
        string = string != null ? (AnimateImageView)string.findViewById(R.id.focus_button_icon2) : null;
        this.focusButtonIcon2 = string;
        string = this.getView();
        string = string != null ? (StatusProgressLayout)string.findViewById(R.id.focus_button_progress2) : null;
        this.focusButtonProgress2 = string;
        string = this.getView();
        string = string != null ? string.findViewById(R.id.focus_button_container_action) : null;
        this.focusButtonContainerAction = string;
        View view = this.getView();
        string = var2_2;
        if (view != null) {
            string = view.findViewById(R.id.focus_button_space);
        }
        this.focusButtonSpace = string;
    }

    @Override
    public void onDetach() {
        f.b((E)this.getScope(), null, null, (U0.o)new U0.o(this, null){
            int label;
            final ModuleDecoLandButtonViewHolder this$0;
            {
                this.this$0 = moduleDecoLandButtonViewHolder;
                super(2, d2);
            }

            public final d create(Object object, d d2) {
                return new /* invalid duplicate definition of identical inner class */;
            }

            public final Object invoke(E e, d d2) {
                return (this.create(e, d2)).invokeSuspend(s.a);
            }

            public final Object invokeSuspend(Object object) {
                c.c();
                if (this.label == 0) {
                    k.b((Object)object);
                    object = ModuleDecoLandButtonViewHolder.access$getImage$p(this.this$0);
                    if (object != null) {
                        object.cancelAnimation();
                    }
                    if ((object = ModuleDecoLandButtonViewHolder.access$getImageDone$p(this.this$0)) != null) {
                        object.cancelAnimation();
                    }
                    if ((object = ModuleDecoLandButtonViewHolder.access$getStatusProgressLayout$p(this.this$0)) != null) {
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
