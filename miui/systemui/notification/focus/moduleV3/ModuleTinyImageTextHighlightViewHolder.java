/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.drawable.Icon
 *  android.service.notification.StatusBarNotification
 *  android.text.Html
 *  android.text.TextUtils
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.ViewGroup
 *  android.widget.ImageView
 *  android.widget.TextView
 *  com.android.systemui.miui.notification.R$id
 *  com.android.systemui.miui.notification.R$layout
 *  kotlin.jvm.internal.o
 *  miuix.colorful.texteffect.HyperChronometer
 */
package miui.systemui.notification.focus.moduleV3;

import android.content.Context;
import android.graphics.drawable.Icon;
import android.service.notification.StatusBarNotification;
import android.text.Html;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.android.systemui.miui.notification.R;
import kotlin.jvm.internal.o;
import miui.systemui.notification.focus.FocusParamsException;
import miui.systemui.notification.focus.model.HighlightInfo;
import miui.systemui.notification.focus.model.Template;
import miui.systemui.notification.focus.model.TextAndColorInfo;
import miui.systemui.notification.focus.model.TimerInfo;
import miui.systemui.notification.focus.moduleV3.ModuleViewHolder;
import miuix.colorful.texteffect.HyperChronometer;

public final class ModuleTinyImageTextHighlightViewHolder
extends ModuleViewHolder {
    private HyperChronometer chronometer;
    private View container;
    private TextView focusContent;
    private ImageView focusIcon;
    private TextView focusSubContent;
    private TextView focusTitle;

    public ModuleTinyImageTextHighlightViewHolder(Context context, Context context2, ViewGroup viewGroup, boolean bl) {
        o.g((Object)context, (String)"ctx");
        o.g((Object)context2, (String)"sysuiCtx");
        o.g((Object)viewGroup, (String)"rootView");
        super(context, context2, viewGroup, bl);
    }

    private final void showFocusIcon(Template object, StatusBarNotification statusBarNotification) {
        Object object2;
        boolean bl = this.isDark();
        Object var5_4 = null;
        if (bl) {
            object2 = ((Template)object).getHighlightInfo();
            object2 = object2 != null ? ((HighlightInfo)object2).getPicFunctionDark() : null;
            Icon icon = this.getIcon((String)object2, statusBarNotification);
            object2 = icon;
            if (icon == null) {
                object = (object = ((Template)object).getHighlightInfo()) != null ? ((HighlightInfo)object).getPicFunction() : null;
                object2 = this.getIcon((String)object, statusBarNotification);
            }
        } else {
            object = (object = ((Template)object).getHighlightInfo()) != null ? ((HighlightInfo)object).getPicFunction() : null;
            object2 = this.getIcon((String)object, statusBarNotification);
        }
        statusBarNotification = this.getView();
        object = var5_4;
        if (statusBarNotification != null) {
            object = (ImageView)statusBarNotification.findViewById(R.id.focus_function_icon);
        }
        if (object2 != null) {
            if (object != null) {
                object.setVisibility(0);
            }
            if (object != null) {
                object.setImageIcon((Icon)object2);
            }
        }
    }

    @Override
    public void bind(Template template, StatusBarNotification statusBarNotification) {
        int n;
        o.g((Object)template, (String)"template");
        o.g((Object)statusBarNotification, (String)"sbn");
        super.bind(template, statusBarNotification);
        this.initTextAndColor(template.getHighlightInfo());
        Object object = template.getHighlightInfo();
        object = object != null ? ((HighlightInfo)object).getTimerInfo() : null;
        this.initTimerData((TimerInfo)object);
        this.adaptTimerDelay();
        object = this.container;
        if (object != null) {
            object.setVisibility(0);
        }
        if (!TextUtils.isEmpty((CharSequence)this.getTitle())) {
            object = this.chronometer;
            if (object != null) {
                object.setVisibility(8);
            }
            object = this.focusTitle;
            if (object != null) {
                object.setVisibility(0);
            }
            object = this.focusTitle;
            if (object != null) {
                object.setText((CharSequence)Html.fromHtml((String)this.getTitle()));
            }
            object = this.getTitleColor();
            if (object != null) {
                n = ((Number)object).intValue();
                object = this.focusTitle;
                if (object != null) {
                    object.setTextColor(n);
                }
            }
        } else {
            object = this.chronometer;
            if (object != null) {
                object.setVisibility(0);
            }
            object = this.focusTitle;
            if (object != null) {
                object.setVisibility(8);
            }
            object = this.getTitleColor();
            if (object != null) {
                n = ((Number)object).intValue();
                object = this.chronometer;
                if (object != null) {
                    object.setTextColor(n);
                }
            }
        }
        if ((object = this.getContent()) != null && object.length() > 0) {
            object = this.focusContent;
            if (object != null) {
                object.setVisibility(0);
            }
            object = this.focusContent;
            if (object != null) {
                object.setText((CharSequence)Html.fromHtml((String)this.getContent()));
            }
            object = this.getContentColor();
            if (object != null) {
                n = ((Number)object).intValue();
                object = this.focusContent;
                if (object != null) {
                    object.setTextColor(n);
                }
            }
        }
        if ((object = this.getSubContent()) != null && object.length() > 0) {
            object = this.focusSubContent;
            if (object != null) {
                object.setVisibility(0);
            }
            object = this.focusSubContent;
            if (object != null) {
                object.setText((CharSequence)Html.fromHtml((String)this.getSubContent()));
            }
            object = this.getSubContentColor();
            if (object != null) {
                n = ((Number)object).intValue();
                object = this.focusSubContent;
                if (object != null) {
                    object.setTextColor(n);
                }
            }
        }
        if ((object = (object = template.getHighlightInfo()) != null ? ((HighlightInfo)object).getTimerInfo() : null) != null) {
            ModuleViewHolder.setTimerData$default(this, 0, statusBarNotification, 1, null);
        }
        this.showFocusIcon(template, statusBarNotification);
    }

    @Override
    public void checkParams(Template object) {
        o.g((Object)object, (String)"template");
        super.checkParams((Template)object);
        Object object2 = ((Template)object).getHighlightInfo();
        Object var3_3 = null;
        object2 = object2 != null ? ((TextAndColorInfo)object2).getTitle() : null;
        if (TextUtils.isEmpty((CharSequence)object2)) {
            Object object3 = ((Template)object).getHighlightInfo();
            object2 = var3_3;
            if (object3 != null) {
                object3 = ((HighlightInfo)object3).getTimerInfo();
                object2 = var3_3;
                if (object3 != null) {
                    object2 = ((TimerInfo)object3).getTimerType();
                }
            }
            if (object2 == null || (object = ((Template)object).getHighlightInfo().getTimerInfo()) != null && ((TimerInfo)object).getTimerType() == 0) {
                throw new FocusParamsException("title is empty");
            }
        }
    }

    @Override
    public void initView(String string) {
        o.g((Object)string, (String)"module");
        super.initView(string);
        boolean bl = o.c((Object)string, (Object)"moduleImageTextHighlightTime");
        Object var3_3 = null;
        string = bl ? LayoutInflater.from((Context)ModuleViewHolder.getContext$default(this, false, 1, null)).inflate(R.layout.focus_notification_module_tiny_image_text_highlight_timer, this.getRootView()) : LayoutInflater.from((Context)ModuleViewHolder.getContext$default(this, false, 1, null)).inflate(R.layout.focus_notification_module_tiny_image_text_highlight_sport, this.getRootView());
        this.setView((View)string);
        string = this.getView();
        string = string != null ? string.findViewById(R.id.focus_container_module_image_text_highlight) : null;
        this.container = string;
        string = this.getView();
        string = string != null ? (HyperChronometer)string.findViewById(R.id.chronometer) : null;
        this.chronometer = string;
        string = this.getView();
        string = string != null ? (TextView)string.findViewById(R.id.focus_title) : null;
        this.focusTitle = string;
        string = this.getView();
        string = string != null ? (TextView)string.findViewById(R.id.focus_content) : null;
        this.focusContent = string;
        string = this.getView();
        string = string != null ? (TextView)string.findViewById(R.id.focus_sub_content) : null;
        this.focusSubContent = string;
        View view = this.getView();
        string = var3_3;
        if (view != null) {
            string = (ImageView)view.findViewById(R.id.focus_function_icon);
        }
        this.focusIcon = string;
    }

    @Override
    public void updatePartial(Template template, StatusBarNotification statusBarNotification) {
        o.g((Object)template, (String)"template");
        o.g((Object)statusBarNotification, (String)"sbn");
        super.updatePartial(template, statusBarNotification);
        this.initTextAndColor(template.getHighlightInfo());
        this.bind(template, statusBarNotification);
    }
}
