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
 *  miui.systemui.dynamicisland.DynamicIslandUtils
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
import miui.systemui.dynamicisland.DynamicIslandUtils;
import miui.systemui.notification.focus.FocusParamsException;
import miui.systemui.notification.focus.model.ChatInfo;
import miui.systemui.notification.focus.model.Template;
import miui.systemui.notification.focus.model.TextAndColorInfo;
import miui.systemui.notification.focus.model.TimerInfo;
import miui.systemui.notification.focus.moduleV3.ModuleViewHolder;
import miuix.colorful.texteffect.HyperChronometer;

public final class ModuleTinyImageTextImViewHolder
extends ModuleViewHolder {
    private HyperChronometer chronometer;
    private View container;
    private TextView focusContent;
    private TextView focusTitle;

    public ModuleTinyImageTextImViewHolder(Context context, Context context2, ViewGroup viewGroup, boolean bl) {
        o.g((Object)context, (String)"ctx");
        o.g((Object)context2, (String)"sysuiCtx");
        o.g((Object)viewGroup, (String)"rootView");
        super(context, context2, viewGroup, bl);
    }

    /*
     * Unable to fully structure code
     */
    private final void showProfilePicture(Template var1_1, StatusBarNotification var2_2) {
        block19: {
            block18: {
                block17: {
                    var3_3 = this.isDark();
                    var6_4 = null;
                    if (!var3_3) ** GOTO lbl11
                    var4_5 = var1_1.getChatInfo();
                    if (var4_5 != null) {
                        var4_5 = var4_5.getPicProfileDark();
                    } else {
                        while (true) {
                            var4_5 = null;
                            break block17;
                            break;
                        }
lbl11:
                        // 1 sources

                        if ((var4_5 = var1_1.getChatInfo()) == null) ** continue;
                        var4_5 = var4_5.getPicProfile();
                    }
                }
                var5_6 = var1_1.getChatInfo();
                if (var5_6 == null) break block18;
                var7_7 = var5_6.getAppIconPkg();
                var5_6 = var7_7;
                if (var7_7 != null) break block19;
            }
            var5_6 = var2_2.getPackageName();
        }
        if ((var4_5 = this.getIcon((String)var4_5, var2_2)) != null) {
            var7_7 = this.getView();
            if (var7_7 != null && (var7_7 = (ImageView)var7_7.findViewById(R.id.focus_profile)) != null) {
                var7_7.setImageIcon((Icon)var4_5);
            }
            var1_1 = (var1_1 = var1_1.getChatInfo()) != null ? var1_1.getAppIconPkg() : null;
            var4_5 = this.getIcon((String)var1_1, var2_2);
            var7_7 = this.getView();
            var1_1 = var6_4;
            if (var7_7 != null) {
                var1_1 = (ImageView)var7_7.findViewById(R.id.focus_app_icon);
            }
            if (var4_5 != null) {
                if (var1_1 != null) {
                    var1_1.setImageIcon((Icon)var4_5);
                }
            } else if (var1_1 != null) {
                var1_1.setImageDrawable(DynamicIslandUtils.INSTANCE.getAppIcon(this.getCtx(), (String)var5_6, Integer.valueOf(var2_2.getUser().getIdentifier())));
            }
        } else {
            var1_1 = this.getView();
            if (var1_1 != null && (var1_1 = (ImageView)var1_1.findViewById(R.id.focus_profile)) != null) {
                var1_1.setImageDrawable(DynamicIslandUtils.INSTANCE.getAppIcon(this.getCtx(), (String)var5_6, Integer.valueOf(var2_2.getUser().getIdentifier())));
            }
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
        }
        if ((object = (object = template.getChatInfo()) != null ? ((ChatInfo)object).getTimerInfo() : null) != null) {
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
        this.setView(LayoutInflater.from((Context)ModuleViewHolder.getContext$default(this, false, 1, null)).inflate(R.layout.focus_notification_module_tiny_image_text_im, this.getRootView()));
        string = this.getView();
        string = string != null ? string.findViewById(R.id.focus_container_module_image_text_im) : null;
        this.container = string;
        string = this.getView();
        string = string != null ? (TextView)string.findViewById(R.id.focus_title) : null;
        this.focusTitle = string;
        string = this.getView();
        string = string != null ? (HyperChronometer)string.findViewById(R.id.chronometer) : null;
        this.chronometer = string;
        View view = this.getView();
        string = var2_2;
        if (view != null) {
            string = (TextView)view.findViewById(R.id.focus_content);
        }
        this.focusContent = string;
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
