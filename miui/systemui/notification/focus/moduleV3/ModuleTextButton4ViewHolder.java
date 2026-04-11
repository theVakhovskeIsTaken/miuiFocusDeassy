/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.annotation.SuppressLint
 *  android.content.Context
 *  android.graphics.Color
 *  android.graphics.drawable.Drawable
 *  android.graphics.drawable.GradientDrawable
 *  android.graphics.drawable.StateListDrawable
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
 *  miui.systemui.util.PaletteUtils
 */
package miui.systemui.notification.focus.moduleV3;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;
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
import miui.systemui.util.PaletteUtils;

public final class ModuleTextButton4ViewHolder
extends ModuleViewHolder {
    private View action1;
    private TextView action1TitleView;
    private View action2;
    private TextView action2TitleView;
    private View action3;
    private TextView action3TitleView;
    private View container;
    private final boolean island;

    public ModuleTextButton4ViewHolder(Context context, Context context2, ViewGroup viewGroup, boolean bl, boolean bl2) {
        o.g((Object)context, (String)"ctx");
        o.g((Object)context2, (String)"sysuiCtx");
        o.g((Object)viewGroup, (String)"rootView");
        super(context, context2, viewGroup, bl);
        this.island = bl2;
    }

    @SuppressLint(value={"UseCompatLoadingForDrawables"})
    private final void checkAndCompressModuleButton4Views(Template object, StatusBarNotification object2) {
        object2 = ((Template)object).getTextButton();
        Object object3 = null;
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
            object2 = this.action3;
            if (object2 != null) {
                object2.setVisibility(8);
            }
            object = ((Template)object).getTextButton();
            object = object != null ? (ActionInfo)object.get(0) : null;
            if (object != null && (string = ((ActionInfo)object).getActionBgColor(this.isDark())) != null) {
                object2 = this.getCtx().getResources().getDrawable(R.drawable.focus_button_background_n).mutate();
                o.e((Object)object2, (String)"null cannot be cast to non-null type android.graphics.drawable.GradientDrawable");
                object3 = (GradientDrawable)object2;
                object3.setColor(Color.parseColor((String)string));
                object2 = new StateListDrawable();
                Drawable drawable2 = this.getCtx().getResources().getDrawable(R.drawable.focus_button_background_p).mutate();
                o.e((Object)drawable2, (String)"null cannot be cast to non-null type android.graphics.drawable.GradientDrawable");
                drawable2 = (GradientDrawable)drawable2;
                drawable2.setColor(PaletteUtils.blendWithColor((int)Color.parseColor((String)string), (boolean)this.isDark()));
                string = ((ActionInfo)object).getActionBgPressColor(this.isDark());
                if (string != null) {
                    drawable2.setColor(Color.parseColor((String)string));
                }
                object2.addState(new int[]{16842919}, drawable2);
                object2.addState(new int[0], (Drawable)object3);
                object3 = this.action1;
                o.d((Object)object3);
                object3.setBackground((Drawable)object2);
            }
            if (object != null && (object3 = ((ActionInfo)object).getActionTitleColor(this.isDark())) != null && (object2 = this.action1TitleView) != null) {
                object2.setTextColor(Color.parseColor((String)object3));
            }
            object2 = string2;
            if (object != null) {
                object2 = ((ActionInfo)object).getActionTitle();
            }
            if ((object = this.action1TitleView) != null) {
                object.setText((CharSequence)Html.fromHtml((String)object2));
            }
        } else if (object2 != null && (Integer)object2 == 2) {
            Drawable drawable3;
            String string3;
            object2 = this.action1;
            if (object2 != null) {
                object2.setVisibility(0);
            }
            object2 = this.action2;
            if (object2 != null) {
                object2.setVisibility(0);
            }
            object2 = this.action3;
            if (object2 != null) {
                object2.setVisibility(8);
            }
            object2 = ((Template)object).getTextButton();
            object2 = object2 != null ? (ActionInfo)object2.get(0) : null;
            if (object2 != null && (string2 = ((ActionInfo)object2).getActionBgColor(this.isDark())) != null) {
                string = this.getCtx().getResources().getDrawable(R.drawable.focus_button_background_n).mutate();
                o.e((Object)string, (String)"null cannot be cast to non-null type android.graphics.drawable.GradientDrawable");
                string3 = (GradientDrawable)string;
                string3.setColor(Color.parseColor((String)string2));
                string = new StateListDrawable();
                drawable3 = this.getCtx().getResources().getDrawable(R.drawable.focus_button_background_p).mutate();
                o.e((Object)drawable3, (String)"null cannot be cast to non-null type android.graphics.drawable.GradientDrawable");
                drawable3 = (GradientDrawable)drawable3;
                drawable3.setColor(PaletteUtils.blendWithColor((int)Color.parseColor((String)string2), (boolean)this.isDark()));
                string2 = ((ActionInfo)object2).getActionBgPressColor(this.isDark());
                if (string2 != null) {
                    drawable3.setColor(Color.parseColor((String)string2));
                }
                string.addState(new int[]{16842919}, drawable3);
                string.addState(new int[0], (Drawable)string3);
                string2 = this.action1;
                o.d((Object)string2);
                string2.setBackground((Drawable)string);
            }
            if ((object = (object = ((Template)object).getTextButton()) != null ? (ActionInfo)object.get(1) : null) != null && (string3 = ((ActionInfo)object).getActionBgColor(this.isDark())) != null) {
                string = this.getCtx().getResources().getDrawable(R.drawable.focus_button_background_n).mutate();
                o.e((Object)string, (String)"null cannot be cast to non-null type android.graphics.drawable.GradientDrawable");
                string2 = (GradientDrawable)string;
                string2.setColor(Color.parseColor((String)string3));
                string = new StateListDrawable();
                drawable3 = this.getCtx().getResources().getDrawable(R.drawable.focus_button_background_p).mutate();
                o.e((Object)drawable3, (String)"null cannot be cast to non-null type android.graphics.drawable.GradientDrawable");
                drawable3 = (GradientDrawable)drawable3;
                drawable3.setColor(PaletteUtils.blendWithColor((int)Color.parseColor((String)string3), (boolean)this.isDark()));
                string3 = ((ActionInfo)object).getActionBgPressColor(this.isDark());
                if (string3 != null) {
                    drawable3.setColor(Color.parseColor((String)string3));
                }
                string.addState(new int[]{16842919}, drawable3);
                string.addState(new int[0], (Drawable)string2);
                string2 = this.action2;
                o.d((Object)string2);
                string2.setBackground((Drawable)string);
            }
            if (object2 != null && (string2 = ((ActionInfo)object2).getActionTitleColor(this.isDark())) != null && (string = this.action1TitleView) != null) {
                string.setTextColor(Color.parseColor((String)string2));
            }
            if (object != null && (string = ((ActionInfo)object).getActionTitleColor(this.isDark())) != null && (string2 = this.action2TitleView) != null) {
                string2.setTextColor(Color.parseColor((String)string));
            }
            object2 = object2 != null ? ((ActionInfo)object2).getActionTitle() : null;
            string = this.action1TitleView;
            if (string != null) {
                string.setText((CharSequence)Html.fromHtml((String)object2));
            }
            object2 = object3;
            if (object != null) {
                object2 = ((ActionInfo)object).getActionTitle();
            }
            if ((object = this.action2TitleView) != null) {
                object.setText((CharSequence)Html.fromHtml((String)object2));
            }
        } else if (object2 != null && (Integer)object2 == 3) {
            Drawable drawable4;
            String string4;
            String string5;
            object2 = this.action1;
            if (object2 != null) {
                object2.setVisibility(0);
            }
            object2 = this.action2;
            if (object2 != null) {
                object2.setVisibility(0);
            }
            object2 = this.action3;
            if (object2 != null) {
                object2.setVisibility(0);
            }
            object2 = ((Template)object).getTextButton();
            object2 = object2 != null ? (ActionInfo)object2.get(0) : null;
            if (object2 != null && (string2 = ((ActionInfo)object2).getActionBgColor(this.isDark())) != null) {
                object3 = this.getCtx().getResources().getDrawable(R.drawable.focus_button_background_n).mutate();
                o.e((Object)object3, (String)"null cannot be cast to non-null type android.graphics.drawable.GradientDrawable");
                string5 = (GradientDrawable)object3;
                string5.setColor(Color.parseColor((String)string2));
                object3 = new StateListDrawable();
                string4 = this.getCtx().getResources().getDrawable(R.drawable.focus_button_background_p).mutate();
                o.e((Object)string4, (String)"null cannot be cast to non-null type android.graphics.drawable.GradientDrawable");
                string4 = (GradientDrawable)string4;
                string4.setColor(PaletteUtils.blendWithColor((int)Color.parseColor((String)string2), (boolean)this.isDark()));
                string2 = ((ActionInfo)object2).getActionBgPressColor(this.isDark());
                if (string2 != null) {
                    string4.setColor(Color.parseColor((String)string2));
                }
                object3.addState(new int[]{16842919}, (Drawable)string4);
                object3.addState(new int[0], (Drawable)string5);
                string2 = this.action1;
                o.d((Object)string2);
                string2.setBackground((Drawable)object3);
            }
            if ((object3 = (object3 = ((Template)object).getTextButton()) != null ? (ActionInfo)object3.get(1) : null) != null && (string5 = ((ActionInfo)object3).getActionBgColor(this.isDark())) != null) {
                string2 = this.getCtx().getResources().getDrawable(R.drawable.focus_button_background_n).mutate();
                o.e((Object)string2, (String)"null cannot be cast to non-null type android.graphics.drawable.GradientDrawable");
                string4 = (GradientDrawable)string2;
                string4.setColor(Color.parseColor((String)string5));
                string2 = new StateListDrawable();
                drawable4 = this.getCtx().getResources().getDrawable(R.drawable.focus_button_background_p).mutate();
                o.e((Object)drawable4, (String)"null cannot be cast to non-null type android.graphics.drawable.GradientDrawable");
                drawable4 = (GradientDrawable)drawable4;
                drawable4.setColor(PaletteUtils.blendWithColor((int)Color.parseColor((String)string5), (boolean)this.isDark()));
                string5 = ((ActionInfo)object3).getActionBgPressColor(this.isDark());
                if (string5 != null) {
                    drawable4.setColor(Color.parseColor((String)string5));
                }
                string2.addState(new int[]{16842919}, drawable4);
                string2.addState(new int[0], (Drawable)string4);
                string5 = this.action2;
                o.d((Object)string5);
                string5.setBackground((Drawable)string2);
            }
            if ((object = (object = ((Template)object).getTextButton()) != null ? (ActionInfo)object.get(2) : null) != null && (string4 = ((ActionInfo)object).getActionBgColor(this.isDark())) != null) {
                string2 = this.getCtx().getResources().getDrawable(R.drawable.focus_button_background_n).mutate();
                o.e((Object)string2, (String)"null cannot be cast to non-null type android.graphics.drawable.GradientDrawable");
                string5 = (GradientDrawable)string2;
                string5.setColor(Color.parseColor((String)string4));
                string2 = new StateListDrawable();
                drawable4 = this.getCtx().getResources().getDrawable(R.drawable.focus_button_background_p).mutate();
                o.e((Object)drawable4, (String)"null cannot be cast to non-null type android.graphics.drawable.GradientDrawable");
                drawable4 = (GradientDrawable)drawable4;
                drawable4.setColor(PaletteUtils.blendWithColor((int)Color.parseColor((String)string4), (boolean)this.isDark()));
                string4 = ((ActionInfo)object).getActionBgPressColor(this.isDark());
                if (string4 != null) {
                    drawable4.setColor(Color.parseColor((String)string4));
                }
                string2.addState(new int[]{16842919}, drawable4);
                string2.addState(new int[0], (Drawable)string5);
                string5 = this.action3;
                o.d((Object)string5);
                string5.setBackground((Drawable)string2);
            }
            if (object2 != null && (string2 = ((ActionInfo)object2).getActionTitleColor(this.isDark())) != null && (string5 = this.action1TitleView) != null) {
                string5.setTextColor(Color.parseColor((String)string2));
            }
            if (object3 != null && (string2 = ((ActionInfo)object3).getActionTitleColor(this.isDark())) != null && (string5 = this.action2TitleView) != null) {
                string5.setTextColor(Color.parseColor((String)string2));
            }
            if (object != null && (string2 = ((ActionInfo)object).getActionTitleColor(this.isDark())) != null && (string5 = this.action3TitleView) != null) {
                string5.setTextColor(Color.parseColor((String)string2));
            }
            object2 = object2 != null ? ((ActionInfo)object2).getActionTitle() : null;
            string2 = this.action1TitleView;
            if (string2 != null) {
                string2.setText((CharSequence)Html.fromHtml((String)object2));
            }
            object2 = object3 != null ? ((ActionInfo)object3).getActionTitle() : null;
            object3 = this.action2TitleView;
            if (object3 != null) {
                object3.setText((CharSequence)Html.fromHtml((String)object2));
            }
            object2 = string;
            if (object != null) {
                object2 = ((ActionInfo)object).getActionTitle();
            }
            if ((object = this.action3TitleView) != null) {
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
            object = this.action3;
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
        this.setActionData(template, statusBarNotification, this.island);
        this.checkAndCompressModuleButton4Views(template, statusBarNotification);
    }

    public final boolean getIsland() {
        return this.island;
    }

    @Override
    public void initView(String string) {
        o.g((Object)string, (String)"module");
        super.initView(string);
        this.setView(LayoutInflater.from((Context)this.getContext(this.island)).inflate(R.layout.focus_notification_module_button_4, this.getRootView()));
        string = this.getView();
        TextView textView = null;
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
        string = string != null ? (TextView)string.findViewById(R.id.focus_button_title) : null;
        this.action2TitleView = string;
        string = this.getView();
        string = string != null ? string.findViewById(R.id.focus_button_container_action3) : null;
        this.action3 = string;
        if (string != null) {
            textView = (TextView)string.findViewById(R.id.focus_button_title);
        }
        this.action3TitleView = textView;
    }

    @Override
    public void updatePartial(Template template, StatusBarNotification statusBarNotification) {
        o.g((Object)template, (String)"template");
        o.g((Object)statusBarNotification, (String)"sbn");
        super.updatePartial(template, statusBarNotification);
        this.bind(template, statusBarNotification);
    }
}
