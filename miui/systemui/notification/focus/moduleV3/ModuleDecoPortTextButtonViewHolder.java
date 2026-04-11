/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.Color
 *  android.service.notification.StatusBarNotification
 *  android.text.Html
 *  android.text.TextUtils
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.ViewGroup
 *  android.widget.FrameLayout
 *  android.widget.LinearLayout
 *  android.widget.TextView
 *  com.android.systemui.miui.notification.R$color
 *  com.android.systemui.miui.notification.R$id
 *  com.android.systemui.miui.notification.R$layout
 *  kotlin.jvm.internal.o
 *  miuix.colorful.texteffect.HyperChronometer
 */
package miui.systemui.notification.focus.moduleV3;

import android.content.Context;
import android.graphics.Color;
import android.service.notification.StatusBarNotification;
import android.text.Html;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.android.systemui.miui.notification.R;
import kotlin.jvm.internal.o;
import miui.systemui.notification.focus.model.HintInfo;
import miui.systemui.notification.focus.model.Template;
import miui.systemui.notification.focus.model.TimerInfo;
import miui.systemui.notification.focus.moduleV3.ModuleViewHolder;
import miuix.colorful.texteffect.HyperChronometer;

public final class ModuleDecoPortTextButtonViewHolder
extends ModuleViewHolder {
    private HyperChronometer chronometerHintView;
    private FrameLayout focusButtonContainer;
    private TextView focusButtonTitleView;
    private TextView focusSmallSubtitleView;
    private TextView focusSmallTitleView;
    private TextView focusTextTitleView;
    private LinearLayout hintLayout;
    private FrameLayout line;
    private FrameLayout titleHintLayout;

    public ModuleDecoPortTextButtonViewHolder(Context context, Context context2, ViewGroup viewGroup, boolean bl) {
        o.g((Object)context, (String)"ctx");
        o.g((Object)context2, (String)"sysuiCtx");
        o.g((Object)viewGroup, (String)"rootView");
        super(context, context2, viewGroup, bl);
    }

    private final void setLineColor(Template template, StatusBarNotification statusBarNotification) {
        if (this.hasCustomBackground(template, statusBarNotification) && (template = this.line) != null) {
            template.setBackgroundColor(this.getCtx().getResources().getColor(R.color.lineColorDark));
        }
    }

    @Override
    public void bind(Template template, StatusBarNotification statusBarNotification) {
        int n;
        Object object;
        Object var5_3;
        block29: {
            block28: {
                o.g((Object)template, (String)"template");
                o.g((Object)statusBarNotification, (String)"sbn");
                super.bind(template, statusBarNotification);
                this.initTextAndColor(template.getHintInfo());
                var5_3 = null;
                object = template.getHintInfo();
                if (object == null) break block28;
                object = ((HintInfo)object).getColorContentBg();
                break block29;
            }
            object = null;
        }
        try {
            object = Color.parseColor((String)object);
        }
        catch (Exception exception) {
            object = null;
        }
        this.setColorContentBg((Integer)object);
        object = template.getHintInfo();
        object = object != null ? ((HintInfo)object).getTimerInfo() : null;
        this.initTimerData((TimerInfo)object);
        if (!TextUtils.isEmpty((CharSequence)this.getTitle())) {
            object = this.chronometerHintView;
            if (object != null) {
                object.setVisibility(8);
            }
            object = this.focusSmallTitleView;
            if (object != null) {
                object.setVisibility(0);
            }
            object = this.focusSmallTitleView;
            if (object != null) {
                object.setText((CharSequence)Html.fromHtml((String)this.getTitle()));
            }
            object = this.getTitleColor();
            if (object != null) {
                n = ((Number)object).intValue();
                object = this.focusSmallTitleView;
                if (object != null) {
                    object.setTextColor(n);
                }
            }
            object = (object = this.getTitle()) != null ? Integer.valueOf(((String)object).length()) : null;
            o.d((Object)object);
            if ((Integer)object > 6 && (object = this.getSubtitle()) != null && object.length() == 0) {
                object = template.getHintInfo();
                if (object != null) {
                    ((HintInfo)object).setTitleLineCount(2);
                }
                object = this.focusSmallTitleView;
                if (object != null) {
                    object.setMaxLines(2);
                }
            } else {
                object = template.getHintInfo();
                if (object != null) {
                    ((HintInfo)object).setTitleLineCount(1);
                }
                object = this.focusSmallTitleView;
                if (object != null) {
                    object.setMaxLines(1);
                }
            }
        } else {
            object = this.chronometerHintView;
            if (object != null) {
                object.setVisibility(0);
            }
            object = this.focusSmallTitleView;
            if (object != null) {
                object.setVisibility(8);
            }
        }
        if (!TextUtils.isEmpty((CharSequence)this.getSubtitle())) {
            object = this.focusSmallSubtitleView;
            if (object != null) {
                object.setVisibility(0);
            }
            object = this.focusSmallSubtitleView;
            if (object != null) {
                object.setText((CharSequence)Html.fromHtml((String)this.getSubtitle()));
            }
            object = template.getHintInfo();
            if (object != null) {
                ((HintInfo)object).setTitleLineCount(2);
            }
            object = this.focusSmallSubtitleView;
            if (object != null) {
                object.setMaxLines(1);
            }
            object = this.getSubTitleColor();
            if (object != null) {
                n = ((Number)object).intValue();
                object = this.focusSmallSubtitleView;
                if (object != null) {
                    object.setTextColor(n);
                }
            }
        }
        HintInfo hintInfo = template.getHintInfo();
        object = var5_3;
        if (hintInfo != null) {
            object = hintInfo.getTimerInfo();
        }
        if (object != null) {
            this.setTimerData(R.id.chronometer_hint, statusBarNotification);
        }
        ModuleViewHolder.setActionData$default(this, template, statusBarNotification, false, 4, null);
        this.setLineColor(template, statusBarNotification);
    }

    @Override
    public void initView(String string) {
        o.g((Object)string, (String)"module");
        super.initView(string);
        Object var2_2 = null;
        this.setView(LayoutInflater.from((Context)ModuleViewHolder.getContext$default(this, false, 1, null)).inflate(R.layout.focus_notification_module_deco_port_button_2, this.getRootView()));
        string = this.getView();
        string = string != null ? (FrameLayout)string.findViewById(R.id.line) : null;
        this.line = string;
        string = this.getView();
        string = string != null ? (LinearLayout)string.findViewById(R.id.layout_hint) : null;
        this.hintLayout = string;
        string = this.getView();
        string = string != null ? (FrameLayout)string.findViewById(R.id.title_hint) : null;
        this.titleHintLayout = string;
        string = this.getView();
        string = string != null ? (TextView)string.findViewById(R.id.focus_small_title) : null;
        this.focusSmallTitleView = string;
        string = this.getView();
        string = string != null ? (HyperChronometer)string.findViewById(R.id.chronometer_hint) : null;
        this.chronometerHintView = string;
        string = this.getView();
        string = string != null ? (TextView)string.findViewById(R.id.focus_small_subtitle) : null;
        this.focusSmallSubtitleView = string;
        string = this.getView();
        string = string != null ? (TextView)string.findViewById(R.id.focus_text_title) : null;
        this.focusTextTitleView = string;
        string = this.getView();
        string = string != null ? (FrameLayout)string.findViewById(R.id.focus_button_container) : null;
        this.focusButtonContainer = string;
        View view = this.getView();
        string = var2_2;
        if (view != null) {
            string = (TextView)view.findViewById(R.id.focus_button_title);
        }
        this.focusButtonTitleView = string;
    }

    @Override
    public void updatePartial(Template template, StatusBarNotification statusBarNotification) {
        o.g((Object)template, (String)"template");
        o.g((Object)statusBarNotification, (String)"sbn");
        super.updatePartial(template, statusBarNotification);
        this.bind(template, statusBarNotification);
    }
}
