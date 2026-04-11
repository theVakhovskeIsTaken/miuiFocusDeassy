/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.Color
 *  android.service.notification.StatusBarNotification
 *  android.text.Html
 *  android.text.SpannableStringBuilder
 *  android.text.SpannedString
 *  android.text.TextUtils
 *  android.text.style.ForegroundColorSpan
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.ViewGroup
 *  android.widget.TextView
 *  com.android.systemui.miui.notification.R$id
 *  com.android.systemui.miui.notification.R$layout
 *  e1.e
 *  kotlin.jvm.internal.o
 *  miuix.colorful.texteffect.HyperChronometer
 */
package miui.systemui.notification.focus.moduleV3;

import android.content.Context;
import android.graphics.Color;
import android.service.notification.StatusBarNotification;
import android.text.Html;
import android.text.SpannableStringBuilder;
import android.text.SpannedString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.android.systemui.miui.notification.R;
import e1.e;
import kotlin.jvm.internal.o;
import miui.systemui.notification.focus.model.BaseInfo;
import miui.systemui.notification.focus.model.HintInfo;
import miui.systemui.notification.focus.model.Template;
import miui.systemui.notification.focus.model.TimerInfo;
import miui.systemui.notification.focus.moduleV3.ModuleViewHolder;
import miuix.colorful.texteffect.HyperChronometer;

public final class ModuleDecoLandTextButtonViewHolder
extends ModuleViewHolder {
    private HyperChronometer chronometerHint;
    private TextView focusSmallTitle;
    private boolean showContentDivider;
    private TextView smallSubTitle;

    public ModuleDecoLandTextButtonViewHolder(Context context, Context context2, ViewGroup viewGroup, boolean bl) {
        o.g((Object)context, (String)"ctx");
        o.g((Object)context2, (String)"sysuiCtx");
        o.g((Object)viewGroup, (String)"rootView");
        super(context, context2, viewGroup, bl);
    }

    private final Boolean containsHtml(String object) {
        if (object != null) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(".*");
            stringBuilder.append("<(\"[^\"]*\"|'[^']*'|[^'\">])*>");
            stringBuilder.append(".*");
            object = new e(stringBuilder.toString()).a((CharSequence)object);
        } else {
            object = null;
        }
        return object;
    }

    @Override
    public void bind(Template template, StatusBarNotification statusBarNotification) {
        Object object;
        Object object2;
        Object var6_3;
        block17: {
            block16: {
                o.g((Object)template, (String)"template");
                o.g((Object)statusBarNotification, (String)"sbn");
                super.bind(template, statusBarNotification);
                this.initTextAndColor(template.getHintInfo());
                var6_3 = null;
                object2 = template.getHintInfo();
                if (object2 == null) break block16;
                object2 = ((HintInfo)object2).getColorContentBg();
                break block17;
            }
            object2 = null;
        }
        try {
            object2 = Color.parseColor((String)object2);
        }
        catch (Exception exception) {
            object2 = null;
        }
        this.setColorContentBg((Integer)object2);
        object2 = template.getBaseInfo();
        boolean bl = object2 != null ? o.c((Object)((BaseInfo)object2).getShowContentDivider(), (Object)Boolean.TRUE) : false;
        this.showContentDivider = bl;
        object2 = template.getHintInfo();
        object2 = object2 != null ? ((HintInfo)object2).getTimerInfo() : null;
        this.initTimerData((TimerInfo)object2);
        if (!TextUtils.isEmpty((CharSequence)this.getTitle())) {
            object2 = this.chronometerHint;
            if (object2 != null) {
                object2.setVisibility(8);
            }
            object2 = this.focusSmallTitle;
            if (object2 != null) {
                object2.setVisibility(0);
            }
            object2 = new SpannableStringBuilder();
            if (this.getTitleColor() != null) {
                object = this.getTitleColor();
                o.d((Object)object);
                object = new ForegroundColorSpan(((Integer)object).intValue());
                int n = object2.length();
                object2.append((CharSequence)this.getTitle());
                object2.setSpan(object, n, object2.length(), 17);
            } else {
                object2.append((CharSequence)this.getTitle());
            }
            object = new SpannedString((CharSequence)object2);
            TextView textView = this.focusSmallTitle;
            if (textView != null) {
                object2 = object;
                if (o.c((Object)this.containsHtml(object.toString()), (Object)Boolean.TRUE)) {
                    object2 = Html.fromHtml((String)object.toString());
                }
                textView.setText((CharSequence)object2);
            }
        } else {
            object2 = this.chronometerHint;
            if (object2 != null) {
                object2.setVisibility(0);
            }
            object2 = this.focusSmallTitle;
            if (object2 != null) {
                object2.setVisibility(8);
            }
        }
        object = template.getHintInfo();
        object2 = var6_3;
        if (object != null) {
            object2 = ((HintInfo)object).getTimerInfo();
        }
        if (object2 != null) {
            this.setTimerData(R.id.chronometer_hint, statusBarNotification);
        }
        ModuleViewHolder.setActionData$default(this, template, statusBarNotification, false, 4, null);
    }

    @Override
    public void initView(String string) {
        o.g((Object)string, (String)"module");
        super.initView(string);
        Object var2_2 = null;
        this.setView(LayoutInflater.from((Context)ModuleViewHolder.getContext$default(this, false, 1, null)).inflate(R.layout.focus_notification_module_deco_land_button_2, this.getRootView()));
        string = this.getView();
        string = string != null ? (TextView)string.findViewById(R.id.focus_small_title) : null;
        this.focusSmallTitle = string;
        string = this.getView();
        string = string != null ? (HyperChronometer)string.findViewById(R.id.chronometer_hint) : null;
        this.chronometerHint = string;
        View view = this.getView();
        string = var2_2;
        if (view != null) {
            string = (TextView)view.findViewById(R.id.focus_small_subtitle);
        }
        this.smallSubTitle = string;
    }

    @Override
    public void updatePartial(Template template, StatusBarNotification statusBarNotification) {
        o.g((Object)template, (String)"template");
        o.g((Object)statusBarNotification, (String)"sbn");
        super.updatePartial(template, statusBarNotification);
        this.bind(template, statusBarNotification);
    }
}
