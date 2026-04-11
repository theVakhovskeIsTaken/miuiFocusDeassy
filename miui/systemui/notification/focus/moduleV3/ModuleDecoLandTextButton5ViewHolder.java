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
 *  android.text.TextUtils
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.ViewGroup
 *  android.widget.TextView$BufferType
 *  com.android.systemui.miui.notification.R$drawable
 *  com.android.systemui.miui.notification.R$id
 *  com.android.systemui.miui.notification.R$layout
 *  kotlin.jvm.internal.o
 *  miuix.colorful.texteffect.TextChangeHelper
 *  miuix.colorful.texteffect.TextChangeProcessor
 *  miuix.colorful.texteffect.TimerTextEffectView
 */
package miui.systemui.notification.focus.moduleV3;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.service.notification.StatusBarNotification;
import android.text.Html;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.android.systemui.miui.notification.R;
import kotlin.jvm.internal.o;
import miui.systemui.notification.focus.model.ActionInfo;
import miui.systemui.notification.focus.model.HighlightInfoV3;
import miui.systemui.notification.focus.model.Template;
import miui.systemui.notification.focus.moduleV3.ModuleViewHolder;
import miuix.colorful.texteffect.TextChangeHelper;
import miuix.colorful.texteffect.TextChangeProcessor;
import miuix.colorful.texteffect.TimerTextEffectView;

public final class ModuleDecoLandTextButton5ViewHolder
extends ModuleViewHolder {
    private View action;
    private TimerTextEffectView actionTitleView;
    private View container;
    private TimerTextEffectView primaryTextView;

    public ModuleDecoLandTextButton5ViewHolder(Context context, Context context2, ViewGroup viewGroup, boolean bl) {
        o.g((Object)context, (String)"ctx");
        o.g((Object)context2, (String)"sysuiCtx");
        o.g((Object)viewGroup, (String)"rootView");
        super(context, context2, viewGroup, bl);
    }

    @Override
    @SuppressLint(value={"UseCompatLoadingForDrawables"})
    public void bind(Template object, StatusBarNotification object2) {
        o.g((Object)object, (String)"template");
        o.g((Object)object2, (String)"sbn");
        super.bind((Template)object, (StatusBarNotification)object2);
        this.initTextAndColor(((Template)object).getHighlightInfoV3());
        Object object3 = this.container;
        if (object3 != null) {
            object3.setVisibility(0);
        }
        ModuleViewHolder.setActionData$default(this, (Template)object, object2, false, 4, null);
        object2 = this.getPrimaryText();
        if (object2 != null && !TextUtils.isEmpty((CharSequence)object2)) {
            object3 = this.primaryTextView;
            if (object3 != null) {
                object3.setVisibility(0);
            }
            object3 = this.primaryTextView;
            if (object3 != null) {
                object3.setText((CharSequence)Html.fromHtml((String)object2), TextView.BufferType.SPANNABLE);
            }
            if ((object3 = this.getPrimaryColor()) != null) {
                int n = ((Number)object3).intValue();
                object3 = this.primaryTextView;
                if (object3 != null) {
                    object3.updateTextWithNewAppearance((CharSequence)Html.fromHtml((String)object2), Integer.valueOf(n));
                }
            }
        }
        if ((object = ((Template)object).getHighlightInfoV3()) != null && (object = ((HighlightInfoV3)object).getActionInfo()) != null && !TextUtils.isEmpty((CharSequence)((ActionInfo)object).getAction())) {
            object2 = this.actionTitleView;
            if (object2 != null) {
                object2.setVisibility(0);
            }
            object2 = this.actionTitleView;
            if (object2 != null) {
                object2.setText((CharSequence)Html.fromHtml((String)((ActionInfo)object).getActionTitle()), TextView.BufferType.SPANNABLE);
            }
            if ((object2 = ((ActionInfo)object).getActionTitleColor()) != null && (object3 = this.actionTitleView) != null) {
                object3.updateTextWithNewAppearance((CharSequence)Html.fromHtml((String)((ActionInfo)object).getActionTitle()), Integer.valueOf(Color.parseColor((String)object2)));
            }
            if ((object2 = ((ActionInfo)object).getActionBgColor()) != null) {
                object = this.getCtx().getResources().getDrawable(R.drawable.focus_button_background);
                o.e((Object)object, (String)"null cannot be cast to non-null type android.graphics.drawable.GradientDrawable");
                object = (GradientDrawable)object;
                object.setColor(Color.parseColor((String)object2));
                object2 = this.action;
                o.d((Object)object2);
                object2.setBackground((Drawable)object);
            }
        }
    }

    @Override
    public void initView(String string) {
        o.g((Object)string, (String)"module");
        super.initView(string);
        TimerTextEffectView timerTextEffectView = null;
        this.setView(LayoutInflater.from((Context)ModuleViewHolder.getContext$default(this, false, 1, null)).inflate(R.layout.focus_notification_module_deco_land_button_5, this.getRootView()));
        string = this.getView();
        string = string != null ? string.findViewById(R.id.focus_container_module_button_5) : null;
        this.container = string;
        string = this.getView();
        string = string != null ? (TimerTextEffectView)string.findViewById(R.id.focus_primary_text) : null;
        this.primaryTextView = string;
        string = this.getView();
        string = string != null ? string.findViewById(R.id.focus_button_container_action) : null;
        this.action = string;
        if (string != null) {
            timerTextEffectView = (TimerTextEffectView)string.findViewById(R.id.focus_button_title);
        }
        this.actionTitleView = timerTextEffectView;
        string = this.primaryTextView;
        if (string != null) {
            string.setTextChangeProcessor((TextChangeProcessor)new TextChangeHelper());
        }
        if ((string = this.actionTitleView) != null) {
            string.setTextChangeProcessor((TextChangeProcessor)new TextChangeHelper());
        }
        if ((string = this.primaryTextView) != null) {
            string.setEnableEffectWithInit(false);
        }
        string = this.actionTitleView;
        if (string != null) {
            string.setEnableEffectWithInit(false);
        }
    }

    @Override
    public void updatePartial(Template template, StatusBarNotification statusBarNotification) {
        o.g((Object)template, (String)"template");
        o.g((Object)statusBarNotification, (String)"sbn");
        super.updatePartial(template, statusBarNotification);
        this.initTextAndColor(template.getHighlightInfoV3());
        this.bind(template, statusBarNotification);
    }
}
