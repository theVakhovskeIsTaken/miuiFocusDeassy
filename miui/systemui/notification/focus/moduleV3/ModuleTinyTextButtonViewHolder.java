/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.ColorStateList
 *  android.graphics.drawable.Icon
 *  android.service.notification.StatusBarNotification
 *  android.text.Html
 *  android.text.TextUtils
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.ViewGroup
 *  android.view.ViewGroup$LayoutParams
 *  android.widget.FrameLayout
 *  android.widget.ImageView
 *  android.widget.LinearLayout
 *  android.widget.LinearLayout$LayoutParams
 *  android.widget.TextView
 *  com.android.systemui.miui.notification.R$color
 *  com.android.systemui.miui.notification.R$dimen
 *  com.android.systemui.miui.notification.R$drawable
 *  com.android.systemui.miui.notification.R$id
 *  com.android.systemui.miui.notification.R$layout
 *  kotlin.jvm.internal.o
 *  miuix.colorful.texteffect.HyperChronometer
 */
package miui.systemui.notification.focus.moduleV3;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Icon;
import android.service.notification.StatusBarNotification;
import android.text.Html;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.android.systemui.miui.notification.R;
import kotlin.jvm.internal.o;
import miui.systemui.notification.focus.model.HintInfo;
import miui.systemui.notification.focus.model.Template;
import miui.systemui.notification.focus.moduleV3.ModuleViewHolder;
import miuix.colorful.texteffect.HyperChronometer;

public final class ModuleTinyTextButtonViewHolder
extends ModuleViewHolder {
    private HyperChronometer chronometerHint;
    private TextView focusSmallTitle;
    private TextView frontContent;
    private TextView frontSubContent;
    private ImageView functionIconView;
    private LinearLayout layout;
    private TextView smallSubTitle;
    private TextView specialTitleView;

    public ModuleTinyTextButtonViewHolder(Context context, Context context2, ViewGroup viewGroup, boolean bl) {
        o.g((Object)context, (String)"ctx");
        o.g((Object)context2, (String)"sysuiCtx");
        o.g((Object)viewGroup, (String)"rootView");
        super(context, context2, viewGroup, bl);
    }

    private final void setLineColor(Template template, StatusBarNotification statusBarNotification) {
        if (this.hasCustomBackground(template, statusBarNotification) && (template = this.getView()) != null && (template = (FrameLayout)template.findViewById(R.id.line)) != null) {
            template.setBackgroundColor(this.getCtx().getResources().getColor(R.color.lineColorDark));
        }
    }

    private final void setSpecialTextContainerData(Template object, StatusBarNotification statusBarNotification) {
        Object object2 = this.getView();
        Object var5_4 = null;
        object2 = object2 != null ? (FrameLayout)object2.findViewById(R.id.focus_text_container) : null;
        if (TextUtils.isEmpty((CharSequence)this.getContent())) {
            if (object2 != null) {
                object2.setVisibility(8);
            }
            return;
        }
        Object object3 = this.specialTitleView;
        if (object3 != null) {
            object3.setVisibility(0);
        }
        object3 = this.specialTitleView;
        if (object3 != null) {
            object3.setText((CharSequence)Html.fromHtml((String)this.getContent()));
        }
        object3 = this.getContentColor();
        if (object3 != null) {
            int n = ((Number)object3).intValue();
            object3 = this.specialTitleView;
            if (object3 != null) {
                object3.setTextColor(n);
            }
        }
        if (object2 != null) {
            object2.setVisibility(0);
        }
        object = ((Template)object).getHintInfo();
        object = object != null ? ((HintInfo)object).getPicContent() : null;
        statusBarNotification = this.getIcon((String)object, statusBarNotification);
        object2 = this.specialTitleView;
        if (object2 != null) {
            object = var5_4;
            if (object2 != null) {
                object = object2.getLayoutParams();
            }
            o.e((Object)object, (String)"null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
            object = (LinearLayout.LayoutParams)object;
            if (statusBarNotification != null) {
                object2 = this.functionIconView;
                if (object2 != null) {
                    object2.setVisibility(0);
                }
                object2 = this.functionIconView;
                if (object2 != null) {
                    object2.setImageIcon((Icon)statusBarNotification);
                }
                object.setMarginStart((int)this.getCtx().getResources().getDimension(R.dimen.focus_notify_text_with_icon_margin_start));
            } else {
                statusBarNotification = this.functionIconView;
                if (statusBarNotification != null) {
                    statusBarNotification.setVisibility(8);
                }
                object.setMarginStart((int)this.getCtx().getResources().getDimension(R.dimen.focus_notify_text_without_icon_margin_start));
            }
            statusBarNotification = this.specialTitleView;
            if (statusBarNotification != null) {
                statusBarNotification.setLayoutParams((ViewGroup.LayoutParams)object);
            }
        }
        this.setTextContainerBackground();
    }

    private final void setTextContainerBackground() {
        if (this.getColorContentBg() != null) {
            Object object = this.getView();
            object = object != null ? (FrameLayout)object.findViewById(R.id.focus_text_container) : null;
            if (object != null) {
                object.setBackgroundResource(R.drawable.focus_text_background_no_alpha);
            }
            if (object != null) {
                Integer n = this.getColorContentBg();
                o.d((Object)n);
                object.setBackgroundTintList(ColorStateList.valueOf((int)n));
            }
        }
    }

    @Override
    public void bind(Template template, StatusBarNotification statusBarNotification) {
        TextView textView;
        int n;
        Object object;
        o.g((Object)template, (String)"template");
        o.g((Object)statusBarNotification, (String)"sbn");
        super.bind(template, statusBarNotification);
        this.initTextAndColor(template.getHintInfo());
        if (!TextUtils.isEmpty((CharSequence)this.getTitle())) {
            object = this.chronometerHint;
            if (object != null) {
                object.setVisibility(8);
            }
            object = this.focusSmallTitle;
            if (object != null) {
                object.setVisibility(0);
            }
            object = this.focusSmallTitle;
            if (object != null) {
                object.setText((CharSequence)Html.fromHtml((String)this.getTitle()));
            }
            object = this.getTitleColor();
            if (object != null) {
                n = ((Number)object).intValue();
                object = this.focusSmallTitle;
                if (object != null) {
                    object.setTextColor(n);
                }
            }
        } else {
            object = this.chronometerHint;
            if (object != null) {
                object.setVisibility(0);
            }
            object = this.focusSmallTitle;
            if (object != null) {
                object.setVisibility(8);
            }
            object = this.getTitleColor();
            if (object != null) {
                n = ((Number)object).intValue();
                object = this.chronometerHint;
                if (object != null) {
                    object.setTextColor(n);
                }
            }
        }
        if ((object = this.frontContent) != null) {
            object.setVisibility(0);
        }
        object = this.frontContent;
        if (object != null) {
            object.setText((CharSequence)Html.fromHtml((String)this.getContent()));
        }
        object = this.getContentColor();
        if (object != null) {
            n = ((Number)object).intValue();
            object = this.frontContent;
            if (object != null) {
                object.setTextColor(n);
            }
        }
        if ((object = this.getSubtitle()) != null && !TextUtils.isEmpty((CharSequence)object)) {
            textView = this.smallSubTitle;
            if (textView != null) {
                textView.setVisibility(0);
            }
            textView = this.smallSubTitle;
            if (textView != null) {
                textView.setText((CharSequence)Html.fromHtml((String)object));
            }
            object = this.getSubTitleColor();
            if (object != null) {
                n = ((Number)object).intValue();
                object = this.smallSubTitle;
                if (object != null) {
                    object.setTextColor(n);
                }
            }
        }
        if ((object = this.getSubContent()) != null && !TextUtils.isEmpty((CharSequence)object)) {
            textView = this.frontSubContent;
            if (textView != null) {
                textView.setVisibility(0);
            }
            textView = this.frontSubContent;
            if (textView != null) {
                textView.setText((CharSequence)Html.fromHtml((String)object));
            }
            object = this.getSubContentColor();
            if (object != null) {
                n = ((Number)object).intValue();
                object = this.frontSubContent;
                if (object != null) {
                    object.setTextColor(n);
                }
            }
        }
        if (TextUtils.isEmpty((CharSequence)this.getSubtitle()) || TextUtils.isEmpty((CharSequence)this.getSubContent())) {
            object = this.smallSubTitle;
            if (object != null) {
                object.setVisibility(8);
            }
            object = this.frontSubContent;
            if (object != null) {
                object.setVisibility(8);
            }
        }
        if ((object = (object = template.getHintInfo()) != null ? ((HintInfo)object).getTimerInfo() : null) != null) {
            this.setTimerData(R.id.chronometer_hint, statusBarNotification);
        }
        ModuleViewHolder.setActionData$default(this, template, statusBarNotification, false, 4, null);
        this.setSpecialTextContainerData(template, statusBarNotification);
        this.setLineColor(template, statusBarNotification);
    }

    @Override
    public void initView(String string) {
        o.g((Object)string, (String)"module");
        super.initView(string);
        boolean bl = o.c((Object)string, (Object)"moduleButton2");
        Object var3_3 = null;
        string = bl ? LayoutInflater.from((Context)ModuleViewHolder.getContext$default(this, false, 1, null)).inflate(R.layout.focus_notification_module_tiny_button_2, this.getRootView()) : LayoutInflater.from((Context)ModuleViewHolder.getContext$default(this, false, 1, null)).inflate(R.layout.focus_notification_module_tiny_button_3, this.getRootView());
        this.setView((View)string);
        string = this.getView();
        string = string != null ? (LinearLayout)string.findViewById(R.id.layout_hint) : null;
        this.layout = string;
        string = this.getView();
        string = string != null ? (HyperChronometer)string.findViewById(R.id.chronometer_hint) : null;
        this.chronometerHint = string;
        string = this.getView();
        string = string != null ? (TextView)string.findViewById(R.id.focus_small_title) : null;
        this.focusSmallTitle = string;
        string = this.getView();
        string = string != null ? (TextView)string.findViewById(R.id.focus_front_content) : null;
        this.frontContent = string;
        string = this.getView();
        string = string != null ? (TextView)string.findViewById(R.id.focus_small_subtitle) : null;
        this.smallSubTitle = string;
        string = this.getView();
        string = string != null ? (TextView)string.findViewById(R.id.focus_front_sub_content) : null;
        this.frontSubContent = string;
        string = this.getView();
        string = string != null ? (ImageView)string.findViewById(R.id.text_icon) : null;
        this.functionIconView = string;
        View view = this.getView();
        string = var3_3;
        if (view != null) {
            string = (TextView)view.findViewById(R.id.focus_text_title);
        }
        this.specialTitleView = string;
    }

    @Override
    public void updatePartial(Template template, StatusBarNotification statusBarNotification) {
        o.g((Object)template, (String)"template");
        o.g((Object)statusBarNotification, (String)"sbn");
        super.updatePartial(template, statusBarNotification);
        this.bind(template, statusBarNotification);
    }
}
