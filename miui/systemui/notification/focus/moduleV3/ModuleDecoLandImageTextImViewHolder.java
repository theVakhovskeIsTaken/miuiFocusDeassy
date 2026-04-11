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
import miui.systemui.notification.focus.model.ChatInfo;
import miui.systemui.notification.focus.model.Template;
import miui.systemui.notification.focus.model.TextAndColorInfo;
import miui.systemui.notification.focus.model.TimerInfo;
import miui.systemui.notification.focus.moduleV3.ModuleViewHolder;
import miuix.colorful.texteffect.HyperChronometer;

public final class ModuleDecoLandImageTextImViewHolder
extends ModuleViewHolder {
    private HyperChronometer chronometer;
    private View container;
    private TextView focusContent;
    private TextView focusTitle;
    private TextView spaceTextViewCenter1;
    private TextView spaceTextViewCenter2;

    public ModuleDecoLandImageTextImViewHolder(Context context, Context context2, ViewGroup viewGroup, boolean bl) {
        o.g((Object)context, (String)"ctx");
        o.g((Object)context2, (String)"sysuiCtx");
        o.g((Object)viewGroup, (String)"rootView");
        super(context, context2, viewGroup, bl);
    }

    private final void showProfilePicture(Template object, StatusBarNotification statusBarNotification) {
        boolean bl = this.isDark();
        Object var4_4 = null;
        if (bl) {
            ChatInfo chatInfo = ((Template)object).getChatInfo();
            object = var4_4;
            if (chatInfo != null) {
                object = chatInfo.getPicProfileDark();
            }
        } else {
            ChatInfo chatInfo = ((Template)object).getChatInfo();
            object = var4_4;
            if (chatInfo != null) {
                object = chatInfo.getPicProfile();
            }
        }
        if ((object = this.getIcon((String)object, statusBarNotification)) != null && (statusBarNotification = this.getView()) != null && (statusBarNotification = (ImageView)statusBarNotification.findViewById(R.id.focus_profile)) != null) {
            statusBarNotification.setImageIcon((Icon)object);
        }
    }

    @Override
    public void bind(Template template, StatusBarNotification statusBarNotification) {
        int n;
        o.g((Object)template, (String)"template");
        o.g((Object)statusBarNotification, (String)"sbn");
        super.bind(template, statusBarNotification);
        this.initTextAndColor(template.getChatInfo());
        Object object = template.getChatInfo();
        object = object != null ? ((ChatInfo)object).getTimerInfo() : null;
        this.initTimerData((TimerInfo)object);
        object = this.container;
        if (object != null) {
            object.setVisibility(0);
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
        if (!TextUtils.isEmpty((CharSequence)this.getContent())) {
            object = this.chronometer;
            if (object != null) {
                object.setVisibility(8);
            }
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
            if ((object = this.spaceTextViewCenter1) != null) {
                object.setVisibility(8);
            }
            object = this.spaceTextViewCenter2;
            if (object != null) {
                object.setVisibility(8);
            }
        } else {
            object = this.chronometer;
            if (object != null) {
                object.setVisibility(0);
            }
            object = this.focusContent;
            if (object != null) {
                object.setVisibility(8);
            }
            object = this.getContentColor();
            if (object != null) {
                n = ((Number)object).intValue();
                object = this.chronometer;
                if (object != null) {
                    object.setTextColor(n);
                }
            }
            if ((object = this.spaceTextViewCenter1) != null) {
                object.setVisibility(0);
            }
            object = this.spaceTextViewCenter2;
            if (object != null) {
                object.setVisibility(0);
            }
        }
        object = template.getChatInfo();
        object = object != null ? ((ChatInfo)object).getTimerInfo() : null;
        if (object != null) {
            ModuleViewHolder.setTimerData$default(this, 0, statusBarNotification, 1, null);
        }
        this.showProfilePicture(template, statusBarNotification);
    }

    @Override
    public void checkParams(Template object) {
        o.g((Object)object, (String)"template");
        super.checkParams((Template)object);
        Object object2 = ((Template)object).getChatInfo();
        Object var3_3 = null;
        object2 = object2 != null ? ((TextAndColorInfo)object2).getContent() : null;
        if (TextUtils.isEmpty((CharSequence)object2)) {
            Object object3 = ((Template)object).getChatInfo();
            object2 = var3_3;
            if (object3 != null) {
                object3 = ((ChatInfo)object3).getTimerInfo();
                object2 = var3_3;
                if (object3 != null) {
                    object2 = ((TimerInfo)object3).getTimerType();
                }
            }
            if (object2 == null || (object = ((Template)object).getChatInfo().getTimerInfo()) != null && ((TimerInfo)object).getTimerType() == 0) {
                throw new FocusParamsException("content is empty");
            }
        }
    }

    @Override
    public void initView(String string) {
        o.g((Object)string, (String)"module");
        super.initView(string);
        Object var2_2 = null;
        this.setView(LayoutInflater.from((Context)ModuleViewHolder.getContext$default(this, false, 1, null)).inflate(R.layout.focus_notification_module_deco_land_image_text_im, this.getRootView()));
        string = this.getView();
        string = string != null ? string.findViewById(R.id.focus_container_module_image_text_im) : null;
        this.container = string;
        string = this.getView();
        string = string != null ? (TextView)string.findViewById(R.id.focus_title) : null;
        this.focusTitle = string;
        string = this.getView();
        string = string != null ? (HyperChronometer)string.findViewById(R.id.chronometer) : null;
        this.chronometer = string;
        string = this.getView();
        string = string != null ? (TextView)string.findViewById(R.id.focus_content) : null;
        this.focusContent = string;
        string = this.getView();
        string = string != null ? (TextView)string.findViewById(R.id.spaceTextViewCenter1) : null;
        this.spaceTextViewCenter1 = string;
        View view = this.getView();
        string = var2_2;
        if (view != null) {
            string = (TextView)view.findViewById(R.id.spaceTextViewCenter2);
        }
        this.spaceTextViewCenter2 = string;
    }

    @Override
    public void updatePartial(Template template, StatusBarNotification statusBarNotification) {
        o.g((Object)template, (String)"template");
        o.g((Object)statusBarNotification, (String)"sbn");
        super.updatePartial(template, statusBarNotification);
        this.initTextAndColor(template.getChatInfo());
        this.bind(template, statusBarNotification);
    }
}
