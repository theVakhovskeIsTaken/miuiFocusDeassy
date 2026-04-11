/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.ColorStateList
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
 *  com.android.systemui.miui.notification.R$drawable
 *  com.android.systemui.miui.notification.R$id
 *  com.android.systemui.miui.notification.R$layout
 *  e1.e
 *  kotlin.jvm.internal.o
 */
package miui.systemui.notification.focus.moduleV3;

import android.content.Context;
import android.content.res.ColorStateList;
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
import miui.systemui.notification.focus.model.Template;
import miui.systemui.notification.focus.model.TextAndColorInfo;
import miui.systemui.notification.focus.moduleV3.ModuleViewHolder;

public final class ModuleDecoLandTextViewHolder
extends ModuleViewHolder {
    public static final Companion Companion = new Object(null){
        {
            this();
        }
    };
    public static final String TAG = "ModuleDecoLandTextViewHolder";
    private Integer colorSpecialBg;
    private TextView focusContentView;
    private TextView focusTitleView;
    private boolean showContentDivider;
    private boolean showDivider;
    private TextView specialTitleView;
    private TextView subContentView;

    public ModuleDecoLandTextViewHolder(Context context, Context context2, ViewGroup viewGroup, boolean bl) {
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

    private final void setContentTxt() {
        Object object;
        int n;
        Integer n2;
        Object object2 = this.focusContentView;
        if (object2 != null) {
            object2.setVisibility(0);
        }
        object2 = new SpannableStringBuilder();
        object2.append((CharSequence)this.getContent());
        if (this.getContentColor() != null) {
            n2 = this.getContentColor();
            o.d((Object)n2);
            n2 = new ForegroundColorSpan(n2.intValue());
            n = object2.length();
            object2.append((CharSequence)String.valueOf(this.getContent()));
            object2.setSpan((Object)n2, n, object2.length(), 17);
        } else {
            object2.append((CharSequence)String.valueOf(this.getContent()));
        }
        n2 = new SpannedString((CharSequence)object2);
        if (n2.length() > 0) {
            object = this.focusContentView;
            if (object != null) {
                object2 = n2;
                if (o.c((Object)this.containsHtml(((Object)n2).toString()), (Object)Boolean.TRUE)) {
                    object2 = Html.fromHtml((String)((Object)n2).toString());
                }
                object.setText((CharSequence)object2);
            }
        } else {
            object2 = this.focusContentView;
            if (object2 != null) {
                object2.setVisibility(8);
            }
            object2 = this.focusTitleView;
            if (object2 != null) {
                object2.setMaxLines(2);
            }
        }
        object2 = this.getSubContent();
        if (object2 != null && object2.length() > 0) {
            object2 = this.subContentView;
            if (object2 != null) {
                object2.setVisibility(0);
            }
            n2 = new SpannableStringBuilder();
            if (this.getSubContentColor() != null) {
                object2 = this.getSubContentColor();
                o.d((Object)object2);
                object = new ForegroundColorSpan(((Integer)object2).intValue());
                n = n2.length();
                if (this.showContentDivider) {
                    object2 = this.getSubContent();
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append(" | ");
                    stringBuilder.append((String)object2);
                    object2 = stringBuilder.toString();
                } else {
                    object2 = String.valueOf(this.getSubContent());
                }
                n2.append((CharSequence)object2);
                n2.setSpan(object, n, n2.length(), 17);
            } else {
                if (this.showContentDivider) {
                    object2 = this.getSubContent();
                    object = new StringBuilder();
                    ((StringBuilder)object).append(" | ");
                    ((StringBuilder)object).append((String)object2);
                    object2 = ((StringBuilder)object).toString();
                } else {
                    object2 = String.valueOf(this.getSubContent());
                }
                n2.append((CharSequence)object2);
            }
            n2 = new SpannedString((CharSequence)((Object)n2));
            object = this.subContentView;
            if (object != null) {
                object2 = n2;
                if (o.c((Object)this.containsHtml(((Object)n2).toString()), (Object)Boolean.TRUE)) {
                    object2 = Html.fromHtml((String)((Object)n2).toString());
                }
                object.setText((CharSequence)object2);
            }
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private final void setTextContainerBackground(Template object) {
        TextView textView = null;
        try {
            object = ((Template)object).getBaseInfo();
            object = object != null ? ((TextAndColorInfo)object).getColorSpecialBg() : null;
            object = Color.parseColor((String)object);
        }
        catch (Exception exception) {
            object = textView;
        }
        if (object == null) return;
        textView = this.specialTitleView;
        if (textView != null) {
            textView.setBackgroundResource(R.drawable.focus_text_background_no_alpha);
        }
        if ((textView = this.specialTitleView) == null) {
            return;
        }
        textView.setBackgroundTintList(ColorStateList.valueOf((int)((Integer)object)));
    }

    private final void setTitleTxt() {
        CharSequence charSequence;
        StringBuilder stringBuilder;
        int n;
        Object object = this.focusTitleView;
        if (object != null) {
            object.setVisibility(0);
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (this.getTitleColor() != null) {
            object = this.getTitleColor();
            o.d((Object)object);
            object = new ForegroundColorSpan(((Integer)object).intValue());
            n = spannableStringBuilder.length();
            spannableStringBuilder.append((CharSequence)String.valueOf(this.getTitle()));
            spannableStringBuilder.setSpan(object, n, spannableStringBuilder.length(), 17);
        } else {
            spannableStringBuilder.append((CharSequence)String.valueOf(this.getTitle()));
        }
        object = this.getSubtitle();
        if (object != null) {
            boolean bl = object.length() > 0;
            object = bl;
        } else {
            object = null;
        }
        o.d((Object)object);
        if (((Boolean)object).booleanValue()) {
            if (this.getSubTitleColor() != null) {
                object = this.getSubTitleColor();
                o.d((Object)object);
                stringBuilder = new ForegroundColorSpan(((Integer)object).intValue());
                n = spannableStringBuilder.length();
                if (this.showDivider) {
                    charSequence = this.getSubtitle();
                    object = new StringBuilder();
                    ((StringBuilder)object).append(" | ");
                    ((StringBuilder)object).append((String)charSequence);
                    object = ((StringBuilder)object).toString();
                } else {
                    object = String.valueOf(this.getSubtitle());
                }
                spannableStringBuilder.append((CharSequence)object);
                spannableStringBuilder.setSpan((Object)stringBuilder, n, spannableStringBuilder.length(), 17);
            } else {
                if (this.showDivider) {
                    object = this.getSubtitle();
                    stringBuilder = new StringBuilder();
                    stringBuilder.append(" | ");
                    stringBuilder.append((String)object);
                    object = stringBuilder.toString();
                } else {
                    object = String.valueOf(this.getSubtitle());
                }
                spannableStringBuilder.append((CharSequence)object);
            }
        }
        if ((object = this.getExtraTitle()) != null && object.length() > 0 && this.getExtraTitleColor() != null) {
            object = this.getExtraTitleColor();
            o.d((Object)object);
            stringBuilder = new ForegroundColorSpan(((Integer)object).intValue());
            n = spannableStringBuilder.length();
            if (this.showDivider) {
                object = this.getExtraTitle();
                charSequence = new StringBuilder();
                ((StringBuilder)charSequence).append(" | ");
                ((StringBuilder)charSequence).append((String)object);
                object = ((StringBuilder)charSequence).toString();
            } else {
                object = String.valueOf(this.getExtraTitle());
            }
            spannableStringBuilder.append((CharSequence)object);
            spannableStringBuilder.setSpan((Object)stringBuilder, n, spannableStringBuilder.length(), 17);
        }
        spannableStringBuilder = new SpannedString((CharSequence)spannableStringBuilder);
        stringBuilder = this.focusTitleView;
        if (stringBuilder != null) {
            object = spannableStringBuilder;
            if (o.c((Object)this.containsHtml(spannableStringBuilder.toString()), (Object)Boolean.TRUE)) {
                object = Html.fromHtml((String)spannableStringBuilder.toString());
            }
            stringBuilder.setText((CharSequence)object);
        }
        if (!TextUtils.isEmpty((CharSequence)this.getSpecialTitle())) {
            object = this.specialTitleView;
            if (object != null) {
                object.setVisibility(0);
            }
            object = this.specialTitleView;
            if (object != null) {
                object.setText((CharSequence)Html.fromHtml((String)this.getSpecialTitle()));
            }
            object = this.getSpecialTitleColor();
            if (object != null) {
                n = ((Number)object).intValue();
                object = this.specialTitleView;
                if (object != null) {
                    object.setTextColor(n);
                }
            }
        } else {
            object = this.specialTitleView;
            if (object != null) {
                object.setVisibility(4);
            }
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    @Override
    public void bind(Template template, StatusBarNotification object) {
        o.g((Object)template, (String)"template");
        o.g((Object)object, (String)"sbn");
        super.bind(template, (StatusBarNotification)object);
        this.initTextAndColor(template.getBaseInfo());
        object = template.getBaseInfo();
        boolean bl = false;
        boolean bl2 = object != null ? o.c((Object)((BaseInfo)object).getShowDivider(), (Object)Boolean.TRUE) : false;
        this.showDivider = bl2;
        object = template.getBaseInfo();
        bl2 = bl;
        if (object != null) {
            bl2 = o.c((Object)((BaseInfo)object).getShowContentDivider(), (Object)Boolean.TRUE);
        }
        this.showContentDivider = bl2;
        Object var5_6 = null;
        try {
            object = template.getBaseInfo();
            object = object != null ? ((TextAndColorInfo)object).getColorSpecialBg() : null;
            object = Color.parseColor((String)object);
        }
        catch (Exception exception) {
            object = var5_6;
        }
        this.colorSpecialBg = object;
        this.setTitleTxt();
        this.setContentTxt();
        this.setTextContainerBackground(template);
    }

    @Override
    public void initView(String string) {
        o.g((Object)string, (String)"module");
        super.initView(string);
        boolean bl = o.c((Object)string, (Object)"moduleText1");
        Object var3_3 = null;
        string = bl ? LayoutInflater.from((Context)ModuleViewHolder.getContext$default(this, false, 1, null)).inflate(R.layout.focus_notification_module_deco_land_text_1, this.getRootView()) : LayoutInflater.from((Context)ModuleViewHolder.getContext$default(this, false, 1, null)).inflate(R.layout.focus_notification_module_deco_land_text_2, this.getRootView());
        this.setView((View)string);
        string = this.getView();
        string = string != null ? (TextView)string.findViewById(R.id.focus_content) : null;
        this.focusContentView = string;
        string = this.getView();
        string = string != null ? (TextView)string.findViewById(R.id.focus_sub_content) : null;
        this.subContentView = string;
        string = this.getView();
        string = string != null ? (TextView)string.findViewById(R.id.focus_title) : null;
        this.focusTitleView = string;
        View view = this.getView();
        string = var3_3;
        if (view != null) {
            string = (TextView)view.findViewById(R.id.focus_special_title);
        }
        this.specialTitleView = string;
    }

    @Override
    public void updatePartial(Template template, StatusBarNotification statusBarNotification) {
        o.g((Object)template, (String)"template");
        o.g((Object)statusBarNotification, (String)"sbn");
        super.updatePartial(template, statusBarNotification);
        this.initTextAndColor(template.getBaseInfo());
        this.bind(template, statusBarNotification);
    }
}
