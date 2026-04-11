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
 *  android.text.TextUtils
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.ViewGroup
 *  android.view.ViewGroup$LayoutParams
 *  android.widget.FrameLayout$LayoutParams
 *  android.widget.ImageView
 *  android.widget.LinearLayout$LayoutParams
 *  android.widget.TextView$BufferType
 *  com.android.systemui.miui.notification.R$dimen
 *  com.android.systemui.miui.notification.R$drawable
 *  com.android.systemui.miui.notification.R$id
 *  com.android.systemui.miui.notification.R$layout
 *  kotlin.jvm.internal.o
 *  miui.systemui.util.PaletteUtils
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
import android.graphics.drawable.StateListDrawable;
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
import miui.systemui.notification.focus.model.ActionInfo;
import miui.systemui.notification.focus.model.HighlightInfoV3;
import miui.systemui.notification.focus.model.Template;
import miui.systemui.notification.focus.moduleV3.ModuleViewHolder;
import miui.systemui.util.PaletteUtils;
import miuix.colorful.texteffect.TextChangeHelper;
import miuix.colorful.texteffect.TextChangeProcessor;
import miuix.colorful.texteffect.TimerTextEffectView;

public final class ModuleTextButton5ViewHolder
extends ModuleViewHolder {
    private View action;
    private ImageView actionButtonIcon;
    private TimerTextEffectView actionTitleView;
    private View container;
    private View focusSubTextContainer;
    private TimerTextEffectView highLightTextView;
    private final boolean island;
    private TimerTextEffectView primaryTextView;
    private TimerTextEffectView secondaryTextView;

    public ModuleTextButton5ViewHolder(Context context, Context context2, ViewGroup viewGroup, boolean bl, boolean bl2) {
        o.g((Object)context, (String)"ctx");
        o.g((Object)context2, (String)"sysuiCtx");
        o.g((Object)viewGroup, (String)"rootView");
        super(context, context2, viewGroup, bl);
        this.island = bl2;
    }

    private final void updateParams() {
        LinearLayout.LayoutParams layoutParams;
        Object object = this.actionButtonIcon;
        if (object != null) {
            object.setVisibility(8);
        }
        object = this.actionTitleView;
        TimerTextEffectView timerTextEffectView = null;
        object = object != null ? object.getLayoutParams() : null;
        if (object instanceof LinearLayout.LayoutParams) {
            object = this.actionTitleView;
            object = object != null ? object.getLayoutParams() : null;
            o.e((Object)object, (String)"null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
            layoutParams = (LinearLayout.LayoutParams)object;
            layoutParams.setMarginStart((int)this.getCtx().getResources().getDimension(R.dimen.focus_notify_button_without_icon_margin_start));
            object = this.actionTitleView;
            if (object != null) {
                object.setLayoutParams((ViewGroup.LayoutParams)layoutParams);
            }
        }
        if ((object = (object = this.actionTitleView) != null ? object.getLayoutParams() : null) instanceof FrameLayout.LayoutParams) {
            layoutParams = this.actionTitleView;
            object = timerTextEffectView;
            if (layoutParams != null) {
                object = layoutParams.getLayoutParams();
            }
            o.e((Object)object, (String)"null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
            object = (FrameLayout.LayoutParams)object;
            object.setMarginStart((int)this.getCtx().getResources().getDimension(R.dimen.focus_notify_button_without_icon_margin_start));
            timerTextEffectView = this.actionTitleView;
            if (timerTextEffectView != null) {
                timerTextEffectView.setLayoutParams((ViewGroup.LayoutParams)object);
            }
        }
    }

    @Override
    @SuppressLint(value={"UseCompatLoadingForDrawables"})
    public void bind(Template object, StatusBarNotification object2) {
        int n;
        o.g((Object)object, (String)"template");
        o.g((Object)object2, (String)"sbn");
        super.bind((Template)object, (StatusBarNotification)object2);
        this.initTextAndColor(((Template)object).getHighlightInfoV3());
        Object object3 = this.container;
        if (object3 != null) {
            object3.setVisibility(0);
        }
        this.setActionData((Template)object, (StatusBarNotification)object2, this.island);
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
                n = ((Number)object3).intValue();
                object3 = this.primaryTextView;
                if (object3 != null) {
                    object3.updateTextWithNewAppearance((CharSequence)Html.fromHtml((String)object2), Integer.valueOf(n));
                }
            }
        }
        if ((object2 = this.getSecondaryText()) != null && !TextUtils.isEmpty((CharSequence)object2)) {
            object3 = this.secondaryTextView;
            if (object3 != null) {
                object3.setVisibility(0);
            }
            object3 = this.secondaryTextView;
            if (object3 != null) {
                object3.setText((CharSequence)Html.fromHtml((String)object2), TextView.BufferType.SPANNABLE);
            }
            if (o.c((Object)this.getShowSecondaryLine(), (Object)Boolean.TRUE) && (object3 = this.secondaryTextView) != null) {
                n = object3 != null ? object3.getPaintFlags() | 0x10 : 0;
                object3.setPaintFlags(n);
            }
            if ((object3 = this.getSecondaryColor()) != null) {
                n = ((Number)object3).intValue();
                object3 = this.secondaryTextView;
                if (object3 != null) {
                    object3.updateTextWithNewAppearance((CharSequence)Html.fromHtml((String)object2), Integer.valueOf(n));
                }
            }
        }
        if ((object2 = this.getHighLightText()) != null && !TextUtils.isEmpty((CharSequence)object2)) {
            object3 = this.highLightTextView;
            if (object3 != null) {
                object3.setVisibility(0);
            }
            object3 = this.highLightTextView;
            if (object3 != null) {
                object3.setText((CharSequence)Html.fromHtml((String)object2), TextView.BufferType.SPANNABLE);
            }
            if ((object3 = this.getHighLightTextColor()) != null) {
                n = ((Number)object3).intValue();
                object3 = this.highLightTextView;
                if (object3 != null) {
                    object3.updateTextWithNewAppearance((CharSequence)Html.fromHtml((String)object2), Integer.valueOf(n));
                }
            }
            if ((object2 = this.getHighLightbgColor()) != null) {
                n = ((Number)object2).intValue();
                object2 = this.getCtx().getResources().getDrawable(R.drawable.focus_tiny_text_background);
                o.e((Object)object2, (String)"null cannot be cast to non-null type android.graphics.drawable.GradientDrawable");
                object2 = (GradientDrawable)object2;
                object2.setColor(n);
                object3 = this.focusSubTextContainer;
                o.d((Object)object3);
                object3.setBackground((Drawable)object2);
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
            if ((object2 = ((ActionInfo)object).getActionTitleColor(this.isDark())) != null && (object3 = this.actionTitleView) != null) {
                object3.updateTextWithNewAppearance((CharSequence)Html.fromHtml((String)((ActionInfo)object).getActionTitle()), Integer.valueOf(Color.parseColor((String)object2)));
            }
            if ((object3 = ((ActionInfo)object).getActionBgColor(this.isDark())) != null) {
                object2 = this.getCtx().getResources().getDrawable(R.drawable.focus_button_background_n).mutate();
                o.e((Object)object2, (String)"null cannot be cast to non-null type android.graphics.drawable.GradientDrawable");
                GradientDrawable gradientDrawable = (GradientDrawable)object2;
                gradientDrawable.setColor(Color.parseColor((String)object3));
                object2 = new StateListDrawable();
                Drawable drawable2 = this.getCtx().getResources().getDrawable(R.drawable.focus_button_background_p).mutate();
                o.e((Object)drawable2, (String)"null cannot be cast to non-null type android.graphics.drawable.GradientDrawable");
                drawable2 = (GradientDrawable)drawable2;
                drawable2.setColor(PaletteUtils.blendWithColor((int)Color.parseColor((String)object3), (boolean)this.isDark()));
                object3 = ((ActionInfo)object).getActionBgPressColor(this.isDark());
                if (object3 != null) {
                    drawable2.setColor(Color.parseColor((String)object3));
                }
                object2.addState(new int[]{16842919}, drawable2);
                object2.addState(new int[0], (Drawable)gradientDrawable);
                object3 = this.action;
                if (object3 != null) {
                    object3.setBackground((Drawable)object2);
                }
            }
            if (((ActionInfo)object).getActionIcon() != null) {
                object = this.actionButtonIcon;
                if (object != null) {
                    object.setVisibility(0);
                }
            } else {
                this.updateParams();
            }
        }
    }

    public final boolean getIsland() {
        return this.island;
    }

    @Override
    public void initView(String string) {
        o.g((Object)string, (String)"module");
        super.initView(string);
        this.setView(LayoutInflater.from((Context)this.getContext(this.island)).inflate(R.layout.focus_notification_module_button_5, this.getRootView()));
        string = this.getView();
        Object var2_2 = null;
        string = string != null ? string.findViewById(R.id.focus_container_module_button_5) : null;
        this.container = string;
        string = this.getView();
        string = string != null ? (TimerTextEffectView)string.findViewById(R.id.focus_primary_text) : null;
        this.primaryTextView = string;
        string = this.getView();
        string = string != null ? (TimerTextEffectView)string.findViewById(R.id.focus_secondary_text) : null;
        this.secondaryTextView = string;
        string = this.getView();
        string = string != null ? (TimerTextEffectView)string.findViewById(R.id.focus_highLight_text) : null;
        this.highLightTextView = string;
        string = this.getView();
        string = string != null ? string.findViewById(R.id.focus_sub_text_container) : null;
        this.focusSubTextContainer = string;
        string = this.getView();
        string = string != null ? string.findViewById(R.id.focus_button_container_action) : null;
        this.action = string;
        string = string != null ? (TimerTextEffectView)string.findViewById(R.id.focus_button_title) : null;
        this.actionTitleView = string;
        View view = this.action;
        string = var2_2;
        if (view != null) {
            string = (ImageView)view.findViewById(R.id.button_icon);
        }
        this.actionButtonIcon = string;
        string = this.primaryTextView;
        if (string != null) {
            string.setTextChangeProcessor((TextChangeProcessor)new TextChangeHelper());
        }
        if ((string = this.primaryTextView) != null) {
            string.setEnableEffectWithInit(false);
        }
        string = this.secondaryTextView;
        if (string != null) {
            string.setTextChangeProcessor((TextChangeProcessor)new TextChangeHelper());
        }
        if ((string = this.secondaryTextView) != null) {
            string.setEnableEffectWithInit(false);
        }
        string = this.highLightTextView;
        if (string != null) {
            string.setTextChangeProcessor((TextChangeProcessor)new TextChangeHelper());
        }
        if ((string = this.highLightTextView) != null) {
            string.setEnableEffectWithInit(false);
        }
        string = this.actionTitleView;
        if (string != null) {
            string.setTextChangeProcessor((TextChangeProcessor)new TextChangeHelper());
        }
        if ((string = this.actionTitleView) != null) {
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
