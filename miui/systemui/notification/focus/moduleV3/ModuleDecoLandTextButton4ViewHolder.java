/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.annotation.SuppressLint
 *  android.content.Context
 *  android.graphics.Color
 *  android.graphics.drawable.Drawable
 *  android.graphics.drawable.GradientDrawable
 *  android.service.notification.StatusBarNotification
 *  android.text.Html
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.ViewGroup
 *  android.widget.TextView
 *  com.android.systemui.miui.notification.R$drawable
 *  com.android.systemui.miui.notification.R$id
 *  com.android.systemui.miui.notification.R$layout
 *  kotlin.jvm.internal.o
 */
package miui.systemui.notification.focus.moduleV3;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.service.notification.StatusBarNotification;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.android.systemui.miui.notification.R;
import kotlin.jvm.internal.o;
import miui.systemui.notification.focus.model.ActionInfo;
import miui.systemui.notification.focus.model.Template;
import miui.systemui.notification.focus.moduleV3.ModuleViewHolder;

public final class ModuleDecoLandTextButton4ViewHolder
extends ModuleViewHolder {
    private View action1;
    private TextView action1TitleView;
    private View action2;
    private TextView action2TitleView;
    private View container;

    public ModuleDecoLandTextButton4ViewHolder(Context context, Context context2, ViewGroup viewGroup, boolean bl) {
        o.g((Object)context, (String)"ctx");
        o.g((Object)context2, (String)"sysuiCtx");
        o.g((Object)viewGroup, (String)"rootView");
        super(context, context2, viewGroup, bl);
    }

    @SuppressLint(value={"UseCompatLoadingForDrawables"})
    private final void checkAndCompressModuleButton4Views(Template object, StatusBarNotification object2) {
        object2 = ((Template)object).getTextButton();
        String string = null;
        String string2 = null;
        if ((object2 = object2 != null ? Integer.valueOf(object2.size()) : null) != null && (Integer)object2 == 1) {
            object2 = this.action1;
            if (object2 != null) {
                object2.setVisibility(0);
            }
            object2 = this.action2;
            if (object2 != null) {
                object2.setVisibility(8);
            }
            object = ((Template)object).getTextButton();
            object = object != null ? (ActionInfo)object.get(0) : null;
            if (object != null && (string = ((ActionInfo)object).getActionBgColor()) != null) {
                object2 = this.getCtx().getResources().getDrawable(R.drawable.focus_button_background);
                o.e((Object)object2, (String)"null cannot be cast to non-null type android.graphics.drawable.GradientDrawable");
                object2 = (GradientDrawable)object2;
                object2.setColor(Color.parseColor((String)string));
                string = this.action1;
                o.d((Object)string);
                string.setBackground((Drawable)object2);
            }
            if (object != null && (object2 = ((ActionInfo)object).getActionTitleColor()) != null && (string = this.action1TitleView) != null) {
                string.setTextColor(Color.parseColor((String)object2));
            }
            object2 = string2;
            if (object != null) {
                object2 = ((ActionInfo)object).getActionTitle();
            }
            if ((object = this.action1TitleView) != null) {
                object.setText((CharSequence)Html.fromHtml((String)object2));
            }
        } else if (object2 != null && (Integer)object2 == 2) {
            Object object3;
            object2 = this.action1;
            if (object2 != null) {
                object2.setVisibility(0);
            }
            object2 = this.action2;
            if (object2 != null) {
                object2.setVisibility(0);
            }
            object2 = ((Template)object).getTextButton();
            object2 = object2 != null ? (ActionInfo)object2.get(0) : null;
            if (object2 != null && (string2 = ((ActionInfo)object2).getActionBgColor()) != null) {
                object3 = this.getCtx().getResources().getDrawable(R.drawable.focus_button_background);
                o.e((Object)object3, (String)"null cannot be cast to non-null type android.graphics.drawable.GradientDrawable");
                object3 = (GradientDrawable)object3;
                object3.setColor(Color.parseColor((String)string2));
                string2 = this.action1;
                o.d((Object)string2);
                string2.setBackground(object3);
            }
            if ((object = (object = ((Template)object).getTextButton()) != null ? (ActionInfo)object.get(1) : null) != null && (object3 = ((ActionInfo)object).getActionBgColor()) != null) {
                string2 = this.getCtx().getResources().getDrawable(R.drawable.focus_button_background);
                o.e((Object)string2, (String)"null cannot be cast to non-null type android.graphics.drawable.GradientDrawable");
                string2 = (GradientDrawable)string2;
                string2.setColor(Color.parseColor((String)object3));
                object3 = this.action2;
                o.d((Object)object3);
                object3.setBackground((Drawable)string2);
            }
            if (object2 != null && (string2 = ((ActionInfo)object2).getActionTitleColor()) != null && (object3 = this.action2TitleView) != null) {
                object3.setTextColor(Color.parseColor((String)string2));
            }
            object2 = object2 != null ? ((ActionInfo)object2).getActionTitle() : null;
            string2 = this.action1TitleView;
            if (string2 != null) {
                string2.setText((CharSequence)Html.fromHtml((String)object2));
            }
            if (object != null && (object2 = ((ActionInfo)object).getActionTitleColor()) != null && (string2 = this.action2TitleView) != null) {
                string2.setTextColor(Color.parseColor((String)object2));
            }
            object2 = string;
            if (object != null) {
                object2 = ((ActionInfo)object).getActionTitle();
            }
            if ((object = this.action2TitleView) != null) {
                object.setText((CharSequence)Html.fromHtml((String)object2));
            }
        } else {
            object = this.action1;
            if (object != null) {
                object.setVisibility(8);
            }
            object = this.action2;
            if (object != null) {
                object.setVisibility(8);
            }
        }
    }

    @Override
    public void bind(Template template, StatusBarNotification statusBarNotification) {
        o.g((Object)template, (String)"template");
        o.g((Object)statusBarNotification, (String)"sbn");
        super.bind(template, statusBarNotification);
        View view = this.container;
        if (view != null) {
            view.setVisibility(0);
        }
        ModuleViewHolder.setActionData$default(this, template, statusBarNotification, false, 4, null);
        this.checkAndCompressModuleButton4Views(template, statusBarNotification);
    }

    @Override
    public void initView(String string) {
        o.g((Object)string, (String)"module");
        super.initView(string);
        TextView textView = null;
        this.setView(LayoutInflater.from((Context)ModuleViewHolder.getContext$default(this, false, 1, null)).inflate(R.layout.focus_notification_module_deco_land_button_4, this.getRootView()));
        string = this.getView();
        string = string != null ? string.findViewById(R.id.focus_container_module_button_4) : null;
        this.container = string;
        string = this.getView();
        string = string != null ? string.findViewById(R.id.focus_button_container_action1) : null;
        this.action1 = string;
        string = string != null ? (TextView)string.findViewById(R.id.focus_button_title) : null;
        this.action1TitleView = string;
        string = this.getView();
        string = string != null ? string.findViewById(R.id.focus_button_container_action2) : null;
        this.action2 = string;
        if (string != null) {
            textView = (TextView)string.findViewById(R.id.focus_button_title);
        }
        this.action2TitleView = textView;
    }

    @Override
    public void updatePartial(Template template, StatusBarNotification statusBarNotification) {
        o.g((Object)template, (String)"template");
        o.g((Object)statusBarNotification, (String)"sbn");
        super.updatePartial(template, statusBarNotification);
        this.bind(template, statusBarNotification);
    }
}
