/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  U0.a
 *  android.content.Context
 *  android.content.res.ColorStateList
 *  android.graphics.drawable.Icon
 *  android.service.notification.StatusBarNotification
 *  android.text.Html
 *  android.text.TextUtils
 *  android.util.Log
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.View$AccessibilityDelegate
 *  android.view.ViewGroup
 *  android.view.ViewGroup$LayoutParams
 *  android.view.accessibility.AccessibilityNodeInfo
 *  android.widget.Button
 *  android.widget.Chronometer
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
 *  miui.systemui.dynamicisland.DynamicIslandUtils
 */
package miui.systemui.notification.focus.moduleV3;

import U0.a;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Icon;
import android.service.notification.StatusBarNotification;
import android.text.Html;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.android.systemui.miui.notification.R;
import kotlin.jvm.internal.o;
import miui.systemui.dynamicisland.DynamicIslandUtils;
import miui.systemui.notification.focus.model.HintInfo;
import miui.systemui.notification.focus.model.Template;
import miui.systemui.notification.focus.model.TimerInfo;
import miui.systemui.notification.focus.moduleV3.ModuleViewHolder;
import miui.systemui.notification.focus.moduleV3.ext.ModuleViewHolderExtKt;

public final class ModuleTextButtonViewHolder
extends ModuleViewHolder {
    public static final Companion Companion = new Object(null){
        {
            this();
        }
    };
    private static final String TAG = "ModuleTextButtonViewHolder";
    private Chronometer chronometerHint;
    private FrameLayout focusButtonContainer;
    private TextView focusSmallTitle;
    private TextView frontContent;
    private TextView frontSubContent;
    private ImageView functionIconView;
    private final boolean island;
    private LinearLayout layout;
    private TextView smallSubTitle;
    private TextView specialTitleView;

    public ModuleTextButtonViewHolder(Context context, Context context2, ViewGroup viewGroup, boolean bl, boolean bl2) {
        o.g((Object)context, (String)"ctx");
        o.g((Object)context2, (String)"sysuiCtx");
        o.g((Object)viewGroup, (String)"rootView");
        super(context, context2, viewGroup, bl);
        this.island = bl2;
    }

    public static final /* synthetic */ void access$adaptModuleButton2Views(ModuleTextButtonViewHolder moduleTextButtonViewHolder) {
        moduleTextButtonViewHolder.adaptModuleButton2Views();
    }

    public static final /* synthetic */ void access$adaptModuleButton3Views(ModuleTextButtonViewHolder moduleTextButtonViewHolder) {
        moduleTextButtonViewHolder.adaptModuleButton3Views();
    }

    private final void adaptModuleButton2Views() {
        Log.d((String)TAG, (String)"adaptModuleButton2Views");
        this.checkAndCompressModuleButton2Views();
    }

    private final void adaptModuleButton3Views() {
        Log.d((String)TAG, (String)"adaptModuleButton3Views");
        this.checkAndCompressModuleButton3Views();
    }

    private final void checkAndCompressModuleButton2Views() {
        Object object = this.layout;
        Object var12_2 = null;
        object = object != null ? Integer.valueOf(object.getWidth()) : null;
        o.d((Object)object);
        int n = (Integer)object;
        object = this.getView();
        object = object != null ? object.getContext() : null;
        int n2 = ModuleViewHolderExtKt.dpToPx((Context)object, 25);
        View view = this.getView();
        object = var12_2;
        if (view != null) {
            object = view.getContext();
        }
        int n3 = ModuleViewHolderExtKt.dpToPx((Context)object, 80);
        int n4 = DynamicIslandUtils.INSTANCE.dpToPx(30, this.getCtx());
        int n5 = this.getTextViewWidth(this.frontContent);
        int n6 = this.getTextViewWidth(this.focusSmallTitle);
        int n7 = this.getTextViewWidth(this.frontSubContent);
        int n8 = this.getTextViewWidth(this.smallSubTitle);
        int n9 = Math.max(n5, n6);
        n8 = Math.max(n7, n8);
        if (n7 <= 0) {
            n4 = 0;
        }
        n4 = n9 + n8 + n4;
        object = new StringBuilder();
        ((StringBuilder)object).append("checkAndCompressModuleButton2Views: totalWidth ");
        ((StringBuilder)object).append(n4);
        ((StringBuilder)object).append(" layoutWidth ");
        ((StringBuilder)object).append(n);
        Log.d((String)TAG, (String)((StringBuilder)object).toString());
        if (n4 <= n) {
            object = this.frontContent;
            this.setViewWidth((TextView)object, this.getTextViewWidth((TextView)object), Math.min(this.getTextViewWidth(this.frontContent), n3));
            object = this.focusSmallTitle;
            this.setViewWidth((TextView)object, this.getTextViewWidth((TextView)object), Math.min(this.getTextViewWidth(this.focusSmallTitle), n3));
            this.setViewWidth(this.frontSubContent, n7, n2);
            this.setViewWidth(this.smallSubTitle, n6, n3);
            return;
        }
        n = n4 - n;
        object = new StringBuilder();
        ((StringBuilder)object).append("checkAndCompressContentViews: excessWidth ");
        ((StringBuilder)object).append(n);
        Log.d((String)"ModuleTextViewHolder", (String)((StringBuilder)object).toString());
        if (n > 0) {
            n4 = n9 > n3 ? 1 : 0;
            if (n8 > n3) {
                ++n4;
            } else {
                this.setViewWidth(this.frontSubContent, n7, n2);
                this.setViewWidth(this.smallSubTitle, n6, n3);
            }
            if (n4 == 2) {
                int n10 = n / n4;
                n7 = n3 - (n9 - n10);
                n2 -= n8 - n10;
            } else {
                n2 = 0;
                n7 = 0;
            }
            object = new StringBuilder();
            ((StringBuilder)object).append("ComplexHintTitleViews extra1 ");
            ((StringBuilder)object).append(n7);
            ((StringBuilder)object).append(" extra2 ");
            ((StringBuilder)object).append(n2);
            Log.i((String)TAG, (String)((StringBuilder)object).toString());
            if (n9 > n3) {
                n2 = n9 - n / n4 - Math.max(n2, 0);
                n9 = n3 - n2;
                n2 = (int)Math.max((double)n2, (double)n3);
                this.setViewWidth(this.frontContent, n2, Math.min(n5, n3));
                this.setViewWidth(this.focusSmallTitle, n2, n3);
            } else {
                n9 = 0;
                n2 = 0;
            }
            if (n8 > n3) {
                n4 = n8 - n / n4 - Math.max(n7, 0) - Math.max(n9, 0);
                n7 = n3 - n4;
                this.setViewWidth(this.frontSubContent, Math.max(n4, n3), Math.min(n5, n3));
                this.setViewWidth(this.smallSubTitle, n4, n3);
                if (n7 > 0) {
                    object = this.frontContent;
                    n4 = n2 - n7;
                    this.setViewWidth((TextView)object, n4, Math.min(n5, n3));
                    this.setViewWidth(this.focusSmallTitle, n4, Math.min(n6, n3));
                }
            }
        }
    }

    private final void checkAndCompressModuleButton3Views() {
        Object object;
        Object object2 = DynamicIslandUtils.INSTANCE;
        int n = object2.dpToPx(70, this.getCtx());
        int n2 = object2.dpToPx(8, this.getCtx());
        object2 = this.specialTitleView;
        int n3 = object2 != null && object2.getVisibility() == 0 ? this.getTextViewWidth(this.specialTitleView) : 0;
        int n4 = Math.min(n3, n);
        this.setViewWidth(this.specialTitleView, n4, 0);
        object2 = this.layout;
        Object var7_6 = null;
        object2 = object2 != null ? Integer.valueOf(object2.getWidth()) : null;
        o.d((Object)object2);
        n = (Integer)object2;
        if (n4 > 0) {
            object = this.functionIconView;
            if (object != null && object.getVisibility() == 0) {
                object = this.functionIconView;
                object = object != null ? Integer.valueOf(object.getWidth()) : null;
                o.d((Object)object);
                n3 = (Integer)object + n2;
            } else {
                n3 = 0;
            }
            n3 = n2 * 3 + n3;
        } else {
            n3 = 0;
        }
        n3 = n - n4 - n3;
        object = new StringBuilder();
        ((StringBuilder)object).append("checkAndCompressModuleButton3Views layoutWidth ");
        ((StringBuilder)object).append(object2);
        ((StringBuilder)object).append(" titleMaxWidth ");
        ((StringBuilder)object).append(n3);
        Log.i((String)TAG, (String)((StringBuilder)object).toString());
        if ((Integer)object2 == 0) {
            return;
        }
        object = this.focusSmallTitle;
        object2 = var7_6;
        if (object != null) {
            object2 = object.getMeasuredWidth();
        }
        o.d((Object)object2);
        if ((Integer)object2 > n3) {
            this.setViewWidth(this.focusSmallTitle, n3, 0);
        }
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
        Object object;
        int n;
        o.g((Object)template, (String)"template");
        o.g((Object)statusBarNotification, (String)"sbn");
        super.bind(template, statusBarNotification);
        this.initTextAndColor(template.getHintInfo());
        Object object2 = template.getHintInfo();
        Object var5_4 = null;
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
            object2 = this.focusSmallTitle;
            if (object2 != null) {
                object2.setText((CharSequence)Html.fromHtml((String)this.getTitle()));
            }
            object2 = this.getTitleColor();
            if (object2 != null) {
                n = ((Number)object2).intValue();
                object2 = this.focusSmallTitle;
                if (object2 != null) {
                    object2.setTextColor(n);
                }
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
            object2 = this.getTitleColor();
            if (object2 != null) {
                n = ((Number)object2).intValue();
                object2 = this.chronometerHint;
                if (object2 != null) {
                    object2.setTextColor(n);
                }
            }
        }
        if ((object2 = this.frontContent) != null) {
            object2.setVisibility(0);
        }
        object2 = this.frontContent;
        if (object2 != null) {
            object2.setText((CharSequence)Html.fromHtml((String)this.getContent()));
        }
        object2 = this.getContentColor();
        if (object2 != null) {
            n = ((Number)object2).intValue();
            object2 = this.frontContent;
            if (object2 != null) {
                object2.setTextColor(n);
            }
        }
        if ((object2 = this.getSubtitle()) != null && !TextUtils.isEmpty((CharSequence)object2)) {
            object = this.smallSubTitle;
            if (object != null) {
                object.setVisibility(0);
            }
            object = this.smallSubTitle;
            if (object != null) {
                object.setText((CharSequence)Html.fromHtml((String)object2));
            }
            object2 = this.getSubTitleColor();
            if (object2 != null) {
                n = ((Number)object2).intValue();
                object2 = this.smallSubTitle;
                if (object2 != null) {
                    object2.setTextColor(n);
                }
            }
        }
        if ((object2 = this.getSubContent()) != null && !TextUtils.isEmpty((CharSequence)object2)) {
            object = this.frontSubContent;
            if (object != null) {
                object.setVisibility(0);
            }
            object = this.frontSubContent;
            if (object != null) {
                object.setText((CharSequence)Html.fromHtml((String)object2));
            }
            object2 = this.getSubContentColor();
            if (object2 != null) {
                n = ((Number)object2).intValue();
                object2 = this.frontSubContent;
                if (object2 != null) {
                    object2.setTextColor(n);
                }
            }
        }
        if (TextUtils.isEmpty((CharSequence)this.getSubtitle()) || TextUtils.isEmpty((CharSequence)this.getSubContent())) {
            object2 = this.smallSubTitle;
            if (object2 != null) {
                object2.setVisibility(8);
            }
            object2 = this.frontSubContent;
            if (object2 != null) {
                object2.setVisibility(8);
            }
        }
        object = template.getHintInfo();
        object2 = var5_4;
        if (object != null) {
            object2 = ((HintInfo)object).getTimerInfo();
        }
        if (object2 != null) {
            this.setTimerData(R.id.chronometer_hint, statusBarNotification);
        }
        this.setActionData(template, statusBarNotification, this.island);
        this.setSpecialTextContainerData(template, statusBarNotification);
        this.setLineColor(template, statusBarNotification);
        this.notifyDataChanged();
    }

    public final boolean getIsland() {
        return this.island;
    }

    @Override
    public void initView(String string) {
        o.g((Object)string, (String)"module");
        super.initView(string);
        this.setModule(string);
        if (o.c((Object)string, (Object)"moduleButton2")) {
            this.setView(LayoutInflater.from((Context)this.getContext(this.island)).inflate(R.layout.focus_notification_module_button_2, this.getRootView()));
        } else if (o.c((Object)string, (Object)"moduleButton3")) {
            this.setView(LayoutInflater.from((Context)this.getContext(this.island)).inflate(R.layout.focus_notification_module_button_3, this.getRootView()));
        }
        Object object = this.getView();
        Object var3_3 = null;
        object = object != null ? (LinearLayout)object.findViewById(R.id.layout_hint) : null;
        this.layout = object;
        object = this.getView();
        object = object != null ? (Chronometer)object.findViewById(R.id.chronometer_hint) : null;
        this.chronometerHint = object;
        object = this.getView();
        object = object != null ? (TextView)object.findViewById(R.id.focus_small_title) : null;
        this.focusSmallTitle = object;
        object = this.getView();
        object = object != null ? (TextView)object.findViewById(R.id.focus_front_content) : null;
        this.frontContent = object;
        object = this.getView();
        object = object != null ? (TextView)object.findViewById(R.id.focus_small_subtitle) : null;
        this.smallSubTitle = object;
        object = this.getView();
        object = object != null ? (TextView)object.findViewById(R.id.focus_front_sub_content) : null;
        this.frontSubContent = object;
        object = this.getView();
        object = object != null ? (ImageView)object.findViewById(R.id.text_icon) : null;
        this.functionIconView = object;
        object = this.getView();
        object = object != null ? (TextView)object.findViewById(R.id.focus_text_title) : null;
        this.specialTitleView = object;
        View view = this.getView();
        object = var3_3;
        if (view != null) {
            object = (FrameLayout)view.findViewById(R.id.focus_button_container);
        }
        this.focusButtonContainer = object;
        if (object != null) {
            object.setAccessibilityDelegate(new View.AccessibilityDelegate(){

                public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfo accessibilityNodeInfo) {
                    o.g((Object)view, (String)"host");
                    o.g((Object)accessibilityNodeInfo, (String)"info");
                    super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfo);
                    accessibilityNodeInfo.setClassName((CharSequence)Button.class.getName());
                }
            });
        }
        this.registerCompressChanged(new a(string, this){
            final String $module;
            final ModuleTextButtonViewHolder this$0;
            {
                this.$module = string;
                this.this$0 = moduleTextButtonViewHolder;
                super(0);
            }

            public final void invoke() {
                String string = this.$module;
                if (o.c((Object)string, (Object)"moduleButton2")) {
                    ModuleTextButtonViewHolder.access$adaptModuleButton2Views(this.this$0);
                } else if (o.c((Object)string, (Object)"moduleButton3")) {
                    ModuleTextButtonViewHolder.access$adaptModuleButton3Views(this.this$0);
                }
            }
        });
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    @Override
    public void updatePartial(Template template, StatusBarNotification statusBarNotification) {
        o.g((Object)template, (String)"template");
        o.g((Object)statusBarNotification, (String)"sbn");
        super.updatePartial(template, statusBarNotification);
        this.initTextAndColor(template.getHintInfo());
        this.bind(template, statusBarNotification);
    }
}
