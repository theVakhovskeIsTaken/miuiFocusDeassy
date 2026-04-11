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
 *  android.widget.TextView$BufferType
 *  com.android.systemui.miui.notification.R$id
 *  com.android.systemui.miui.notification.R$layout
 *  kotlin.jvm.internal.o
 *  miui.systemui.util.CommonUtils
 *  miui.systemui.util.DrawableUtils
 *  miuix.colorful.texteffect.CharChangeProcessor
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
import miui.systemui.notification.focus.model.PicInfo;
import miui.systemui.notification.focus.model.Template;
import miui.systemui.notification.focus.moduleV3.ModuleViewHolder;
import miui.systemui.util.CommonUtils;
import miui.systemui.util.DrawableUtils;
import miuix.colorful.texteffect.CharChangeProcessor;
import miuix.colorful.texteffect.HyperChronometer;

public final class ModuleMarkTextImageViewHolder
extends ModuleViewHolder {
    private View buttonContainer;
    private View container;
    private Icon currentIcon;
    private HyperChronometer focusTitle;
    private final boolean island;
    private ImageView mark;
    private String pic;

    public ModuleMarkTextImageViewHolder(Context context, Context context2, ViewGroup viewGroup, boolean bl, boolean bl2) {
        o.g((Object)context, (String)"ctx");
        o.g((Object)context2, (String)"sysuiCtx");
        o.g((Object)viewGroup, (String)"rootView");
        super(context, context2, viewGroup, bl);
        this.island = bl2;
    }

    private final void showMarkIcon(StatusBarNotification object) {
        Icon icon = this.getIcon(this.pic, (StatusBarNotification)object);
        if (!DrawableUtils.isSameIcon((Icon)icon, (Icon)this.currentIcon)) {
            object = this.getView();
            object = object != null ? (ImageView)object.findViewById(R.id.focus_mark_small_icon) : null;
            if (icon != null) {
                if (object != null) {
                    object.setVisibility(0);
                }
                if (object != null) {
                    object.setImageIcon(icon);
                }
            } else if (object != null) {
                object.setVisibility(8);
            }
            this.currentIcon = icon;
        }
    }

    @Override
    public void bind(Template object, StatusBarNotification statusBarNotification) {
        o.g((Object)object, (String)"template");
        o.g((Object)statusBarNotification, (String)"sbn");
        super.bind((Template)object, statusBarNotification);
        this.initTextAndColor(((Template)object).getPicInfo());
        Object object2 = this.container;
        if (object2 != null) {
            object2.setVisibility(0);
        }
        if (!TextUtils.isEmpty((CharSequence)this.getTitle())) {
            object2 = this.focusTitle;
            if (object2 != null) {
                object2.setVisibility(0);
            }
            object2 = this.focusTitle;
            if (object2 != null) {
                object2.setText((CharSequence)Html.fromHtml((String)this.getTitle()), TextView.BufferType.SPANNABLE);
            }
            if ((object2 = this.getTitleColor()) != null) {
                int n = ((Number)object2).intValue();
                object2 = this.focusTitle;
                if (object2 != null) {
                    object2.updateTextWithNewAppearance((CharSequence)Html.fromHtml((String)this.getTitle()), Integer.valueOf(n));
                }
            }
        } else {
            object2 = this.focusTitle;
            if (object2 != null) {
                object2.setVisibility(8);
            }
        }
        boolean bl = this.isDark();
        object2 = null;
        if (bl) {
            PicInfo picInfo = ((Template)object).getPicInfo();
            object = object2;
            if (picInfo != null) {
                object = picInfo.getPicDark();
            }
        } else {
            PicInfo picInfo = ((Template)object).getPicInfo();
            object = object2;
            if (picInfo != null) {
                object = picInfo.getPic();
            }
        }
        this.pic = object;
        object = this.container;
        if (object != null) {
            object.setVisibility(0);
        }
        this.showMarkIcon(statusBarNotification);
    }

    public final boolean getIsland() {
        return this.island;
    }

    @Override
    public void initView(String string) {
        o.g((Object)string, (String)"module");
        super.initView(string);
        this.setModule(string);
        this.setView(LayoutInflater.from((Context)this.getCtx()).inflate(R.layout.focus_notification_module_mark_text_image, this.getRootView()));
        string = this.getView();
        Object var2_2 = null;
        string = string != null ? string.findViewById(R.id.focus_container_module_mark) : null;
        this.container = string;
        string = this.getView();
        string = string != null ? (HyperChronometer)string.findViewById(R.id.focus_title) : null;
        this.focusTitle = string;
        string = this.getView();
        string = string != null ? (ImageView)string.findViewById(R.id.focus_mark_small_icon) : null;
        this.mark = string;
        View view = this.getView();
        string = var2_2;
        if (view != null) {
            string = view.findViewById(R.id.focus_button_container);
        }
        this.buttonContainer = string;
        string = this.focusTitle;
        if (string != null) {
            string.setTextChangeProcessor(new CharChangeProcessor());
        }
        if ((string = this.focusTitle) != null) {
            string.setEnableEffectWithInit(false);
        }
        string = this.focusTitle;
        if (string != null) {
            string.enableEffect(CommonUtils.NOT_SUPPORT_TEXT_EFFECT ^ true);
        }
    }

    @Override
    public void updatePartial(Template template, StatusBarNotification statusBarNotification) {
        o.g((Object)template, (String)"template");
        o.g((Object)statusBarNotification, (String)"sbn");
        super.updatePartial(template, statusBarNotification);
        this.bind(template, statusBarNotification);
    }
}
