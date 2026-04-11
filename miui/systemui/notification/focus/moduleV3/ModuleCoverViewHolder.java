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
 *  miuix.colorful.texteffect.TextChangeHelper
 *  miuix.colorful.texteffect.TextChangeProcessor
 *  miuix.colorful.texteffect.TimerTextEffectView
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
import miui.systemui.notification.focus.model.CoverInfo;
import miui.systemui.notification.focus.model.Template;
import miui.systemui.notification.focus.model.TextAndColorInfo;
import miui.systemui.notification.focus.moduleV3.ModuleViewHolder;
import miuix.colorful.texteffect.TextChangeHelper;
import miuix.colorful.texteffect.TextChangeProcessor;
import miuix.colorful.texteffect.TimerTextEffectView;

public final class ModuleCoverViewHolder
extends ModuleViewHolder {
    private View container;
    private TimerTextEffectView focusContent;
    private TimerTextEffectView focusSubContent;
    private TimerTextEffectView focusTitle;
    private final boolean island;

    public ModuleCoverViewHolder(Context context, Context context2, ViewGroup viewGroup, boolean bl, boolean bl2) {
        o.g((Object)context, (String)"ctx");
        o.g((Object)context2, (String)"sysuiCtx");
        o.g((Object)viewGroup, (String)"rootView");
        super(context, context2, viewGroup, bl);
        this.island = bl2;
    }

    private final void showCover(Template object, StatusBarNotification statusBarNotification) {
        object = (object = ((Template)object).getCoverInfo()) != null ? ((CoverInfo)object).getPicCover() : null;
        object = this.getIcon((String)object, statusBarNotification);
        if (object != null && (statusBarNotification = this.getView()) != null && (statusBarNotification = (ImageView)statusBarNotification.findViewById(R.id.focus_profile)) != null) {
            statusBarNotification.setImageIcon((Icon)object);
        }
    }

    @Override
    public void bind(Template template, StatusBarNotification statusBarNotification) {
        int n;
        o.g((Object)template, (String)"template");
        o.g((Object)statusBarNotification, (String)"sbn");
        super.bind(template, statusBarNotification);
        this.initTextAndColor(template.getCoverInfo());
        Object object = this.container;
        if (object != null) {
            object.setVisibility(0);
        }
        object = this.focusTitle;
        if (object != null) {
            object.setVisibility(0);
        }
        object = this.focusTitle;
        if (object != null) {
            object.setText((CharSequence)Html.fromHtml((String)this.getTitle()), TextView.BufferType.SPANNABLE);
        }
        if ((object = this.getTitleColor()) != null) {
            n = ((Number)object).intValue();
            object = this.focusTitle;
            if (object != null) {
                object.updateTextWithNewAppearance((CharSequence)Html.fromHtml((String)this.getTitle()), Integer.valueOf(n));
            }
        }
        if (!TextUtils.isEmpty((CharSequence)this.getContent())) {
            object = this.focusContent;
            if (object != null) {
                object.setVisibility(0);
            }
            object = this.focusContent;
            if (object != null) {
                object.setText((CharSequence)Html.fromHtml((String)this.getContent()), TextView.BufferType.SPANNABLE);
            }
            if ((object = this.getContentColor()) != null) {
                n = ((Number)object).intValue();
                object = this.focusContent;
                if (object != null) {
                    object.updateTextWithNewAppearance((CharSequence)Html.fromHtml((String)this.getContent()), Integer.valueOf(n));
                }
            }
        }
        if (!TextUtils.isEmpty((CharSequence)this.getSubContent())) {
            object = this.focusSubContent;
            if (object != null) {
                object.setVisibility(0);
            }
            object = this.focusSubContent;
            if (object != null) {
                object.setText((CharSequence)Html.fromHtml((String)this.getSubContent()), TextView.BufferType.SPANNABLE);
            }
            if ((object = this.getSubContentColor()) != null) {
                n = ((Number)object).intValue();
                object = this.focusSubContent;
                if (object != null) {
                    object.updateTextWithNewAppearance((CharSequence)Html.fromHtml((String)this.getSubContent()), Integer.valueOf(n));
                }
            }
        } else {
            object = this.focusContent;
            if (object != null) {
                object.setVisibility(8);
            }
            object = this.focusSubContent;
            if (object != null) {
                object.setVisibility(8);
            }
        }
        this.showCover(template, statusBarNotification);
    }

    @Override
    public void checkParams(Template object) {
        o.g((Object)object, (String)"template");
        super.checkParams((Template)object);
        object = ((Template)object).getCoverInfo();
        object = object != null ? ((TextAndColorInfo)object).getTitle() : null;
        if (!TextUtils.isEmpty((CharSequence)object)) {
            return;
        }
        throw new FocusParamsException("title is empty");
    }

    public final boolean getIsland() {
        return this.island;
    }

    @Override
    public void initView(String string) {
        o.g((Object)string, (String)"module");
        super.initView(string);
        this.setView(LayoutInflater.from((Context)this.getContext(this.island)).inflate(R.layout.focus_notification_module_cover, this.getRootView()));
        string = this.getView();
        Object var2_2 = null;
        string = string != null ? string.findViewById(R.id.focus_container_module_cover) : null;
        this.container = string;
        string = this.getView();
        string = string != null ? (TimerTextEffectView)string.findViewById(R.id.focus_title) : null;
        this.focusTitle = string;
        string = this.getView();
        string = string != null ? (TimerTextEffectView)string.findViewById(R.id.focus_content) : null;
        this.focusContent = string;
        View view = this.getView();
        string = var2_2;
        if (view != null) {
            string = (TimerTextEffectView)view.findViewById(R.id.focus_sub_content);
        }
        this.focusSubContent = string;
        string = this.focusTitle;
        if (string != null) {
            string.setTextChangeProcessor((TextChangeProcessor)new TextChangeHelper());
        }
        if ((string = this.focusTitle) != null) {
            string.setEnableEffectWithInit(false);
        }
        string = this.focusContent;
        if (string != null) {
            string.setTextChangeProcessor((TextChangeProcessor)new TextChangeHelper());
        }
        if ((string = this.focusContent) != null) {
            string.setEnableEffectWithInit(false);
        }
        string = this.focusSubContent;
        if (string != null) {
            string.setTextChangeProcessor((TextChangeProcessor)new TextChangeHelper());
        }
        if ((string = this.focusSubContent) != null) {
            string.setEnableEffectWithInit(false);
        }
    }

    @Override
    public void updatePartial(Template template, StatusBarNotification statusBarNotification) {
        o.g((Object)template, (String)"template");
        o.g((Object)statusBarNotification, (String)"sbn");
        super.updatePartial(template, statusBarNotification);
        this.initTextAndColor(template.getCoverInfo());
        this.bind(template, statusBarNotification);
    }
}
