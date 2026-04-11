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
 *  android.widget.LinearLayout
 *  android.widget.TextView
 *  com.android.systemui.miui.notification.R$drawable
 *  com.android.systemui.miui.notification.R$id
 *  com.android.systemui.miui.notification.R$layout
 *  e1.e
 *  kotlin.jvm.internal.o
 *  miui.systemui.dynamicisland.DynamicIslandUtils
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
import android.widget.LinearLayout;
import android.widget.TextView;
import com.android.systemui.miui.notification.R;
import e1.e;
import kotlin.jvm.internal.o;
import miui.systemui.dynamicisland.DynamicIslandUtils;
import miui.systemui.notification.focus.model.BaseInfo;
import miui.systemui.notification.focus.model.HintInfo;
import miui.systemui.notification.focus.model.Template;
import miui.systemui.notification.focus.model.TextAndColorInfo;
import miui.systemui.notification.focus.moduleV3.ModuleViewHolder;

public final class ModuleDecoPortTextViewHolder
extends ModuleViewHolder {
    public static final Companion Companion = new Object(null){
        {
            this();
        }
    };
    public static final String TAG = "ModuleDecoPortTextViewHolder";
    private Integer colorSpecialBg;
    private int extra;
    private LinearLayout focusContainerModuleText1;
    private LinearLayout focusContainerModuleText2;
    private TextView focusContentView;
    private TextView focusSpecialTitleView;
    private TextView focusSubContentView;
    private TextView focusTitleView;
    private boolean showContentDivider;
    private boolean showDivider;

    public ModuleDecoPortTextViewHolder(Context context, Context context2, ViewGroup viewGroup, boolean bl) {
        o.g((Object)context, (String)"ctx");
        o.g((Object)context2, (String)"sysuiCtx");
        o.g((Object)viewGroup, (String)"rootView");
        super(context, context2, viewGroup, bl);
        this.extra = DynamicIslandUtils.INSTANCE.dpToPx(2, context);
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
        textView = this.focusSpecialTitleView;
        if (textView != null) {
            textView.setBackgroundResource(R.drawable.focus_text_background_no_alpha);
        }
        if ((textView = this.focusSpecialTitleView) == null) {
            return;
        }
        textView.setBackgroundTintList(ColorStateList.valueOf((int)((Integer)object)));
    }

    @Override
    public void bind(Template template, StatusBarNotification object) {
        int n;
        Object object2;
        boolean bl;
        block73: {
            block72: {
                o.g((Object)template, (String)"template");
                o.g((Object)object, (String)"sbn");
                super.bind(template, (StatusBarNotification)object);
                this.initTextAndColor(template.getBaseInfo());
                object = template.getBaseInfo();
                bl = object != null ? o.c((Object)((BaseInfo)object).getShowDivider(), (Object)Boolean.TRUE) : false;
                this.showDivider = bl;
                object = template.getBaseInfo();
                bl = object != null ? o.c((Object)((BaseInfo)object).getShowContentDivider(), (Object)Boolean.TRUE) : false;
                this.showContentDivider = bl;
                object2 = null;
                object = template.getBaseInfo();
                if (object == null) break block72;
                object = ((TextAndColorInfo)object).getColorSpecialBg();
                break block73;
            }
            object = null;
        }
        try {
            object = Color.parseColor((String)object);
        }
        catch (Exception exception) {
            object = null;
        }
        this.colorSpecialBg = object;
        object = this.focusTitleView;
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
        CharSequence charSequence = this.getSubtitle();
        object = object2;
        if (charSequence != null) {
            bl = charSequence.length() > 0;
            object = bl;
        }
        o.d((Object)object);
        if (((Boolean)object).booleanValue()) {
            if (this.getSubTitleColor() != null) {
                object = this.getSubTitleColor();
                o.d((Object)object);
                object2 = new ForegroundColorSpan(((Integer)object).intValue());
                n = spannableStringBuilder.length();
                if (this.showDivider) {
                    object = this.getSubtitle();
                    charSequence = new StringBuilder();
                    ((StringBuilder)charSequence).append(" | ");
                    ((StringBuilder)charSequence).append((String)object);
                    object = ((StringBuilder)charSequence).toString();
                } else {
                    object = String.valueOf(this.getSubtitle());
                }
                spannableStringBuilder.append((CharSequence)object);
                spannableStringBuilder.setSpan(object2, n, spannableStringBuilder.length(), 17);
            } else {
                if (this.showDivider) {
                    object2 = this.getSubtitle();
                    object = new StringBuilder();
                    ((StringBuilder)object).append(" | ");
                    ((StringBuilder)object).append((String)object2);
                    object = ((StringBuilder)object).toString();
                } else {
                    object = String.valueOf(this.getSubtitle());
                }
                spannableStringBuilder.append((CharSequence)object);
            }
        }
        if ((object = this.getExtraTitle()) != null && object.length() > 0 && this.getExtraTitleColor() != null) {
            object = this.getExtraTitleColor();
            o.d((Object)object);
            object2 = new ForegroundColorSpan(((Integer)object).intValue());
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
            spannableStringBuilder.setSpan(object2, n, spannableStringBuilder.length(), 17);
        }
        object2 = new SpannedString((CharSequence)spannableStringBuilder);
        int n2 = object2.length();
        spannableStringBuilder = this.focusTitleView;
        if (spannableStringBuilder != null) {
            object = object2;
            if (o.c((Object)this.containsHtml(object2.toString()), (Object)Boolean.TRUE)) {
                object = Html.fromHtml((String)object2.toString());
            }
            spannableStringBuilder.setText((CharSequence)object);
        }
        if (!TextUtils.isEmpty((CharSequence)this.getSpecialTitle())) {
            object = this.focusSpecialTitleView;
            if (object != null) {
                object.setVisibility(0);
            }
            object = this.focusSpecialTitleView;
            if (object != null) {
                object.setText((CharSequence)Html.fromHtml((String)this.getSpecialTitle()));
            }
            object = this.getSpecialTitleColor();
            if (object != null) {
                n = ((Number)object).intValue();
                object = this.focusSpecialTitleView;
                if (object != null) {
                    object.setTextColor(n);
                }
            }
        } else {
            object = this.focusSpecialTitleView;
            if (object != null) {
                object.setVisibility(8);
            }
        }
        if (!TextUtils.isEmpty((CharSequence)this.getContent())) {
            object = this.focusContentView;
            if (object != null) {
                object.setVisibility(0);
            }
            object = this.getContentColor();
            if (object != null) {
                n = ((Number)object).intValue();
                object = this.focusContentView;
                if (object != null) {
                    object.setTextColor(n);
                }
            }
            if ((object = this.focusContentView) != null) {
                object.setText((CharSequence)Html.fromHtml((String)this.getContent()));
            }
            if (!TextUtils.isEmpty((CharSequence)this.getSubContent())) {
                object = this.focusSubContentView;
                if (object != null) {
                    object.setVisibility(0);
                }
                object = new SpannableStringBuilder();
                if (this.getSubContentColor() != null) {
                    object2 = this.getSubContentColor();
                    o.d((Object)object2);
                    object2 = new ForegroundColorSpan(((Integer)object2).intValue());
                    n = object.length();
                    object.append((CharSequence)String.valueOf(this.getSubContent()));
                    object.setSpan(object2, n, object.length(), 17);
                } else {
                    object.append((CharSequence)String.valueOf(this.getSubContent()));
                }
                object2 = new SpannedString((CharSequence)object);
                spannableStringBuilder = this.focusSubContentView;
                if (spannableStringBuilder != null) {
                    object = object2;
                    if (o.c((Object)this.containsHtml(object2.toString()), (Object)Boolean.TRUE)) {
                        object = Html.fromHtml((String)object2.toString());
                    }
                    spannableStringBuilder.setText((CharSequence)object);
                }
            }
        }
        object = this.getSpecialTitle();
        n = 3;
        if (object != null && object.length() > 0) {
            if (n2 > 14) {
                object = this.focusTitleView;
                if (object != null) {
                    object.setMaxLines(3);
                }
                object = this.focusContentView;
                if (object != null) {
                    object.setMaxLines(1);
                }
                object = this.focusSubContentView;
                if (object != null) {
                    object.setVisibility(8);
                }
            } else {
                object = this.focusSubContentView;
                if (object != null) {
                    object.setVisibility(0);
                }
                object = this.focusTitleView;
                if (object != null) {
                    object.setMaxLines(2);
                }
                object = this.focusContentView;
                if (object != null) {
                    object.setMaxLines(1);
                }
                object = this.focusSubContentView;
                if (object != null) {
                    object.setMaxLines(1);
                }
            }
        } else {
            object = this.getSubContent();
            if (object != null && object.length() > 0) {
                object = this.focusSubContentView;
                if (object != null) {
                    object.setMaxLines(1);
                }
            } else {
                n = 4;
            }
            if (1 <= n2 && n2 < 6) {
                object = this.focusTitleView;
                if (object != null) {
                    object.setMaxLines(1);
                }
                object = template.getHintInfo();
                if (object != null && ((HintInfo)object).getTitleLineCount() == 2) {
                    object = this.focusContentView;
                    if (object != null) {
                        object.setMaxLines(n - 2);
                    }
                } else {
                    object = this.focusContentView;
                    if (object != null) {
                        object.setMaxLines(n - 1);
                    }
                }
            } else if (5 <= n2 && n2 < 15) {
                object = template.getHintInfo();
                if (object != null && ((HintInfo)object).getTitleLineCount() == 2) {
                    object = this.focusContentView;
                    if (object != null) {
                        object.setMaxLines(1);
                    }
                    object = this.focusTitleView;
                    if (object != null) {
                        object.setMaxLines(n - 2);
                    }
                } else {
                    object = this.focusTitleView;
                    if (object != null) {
                        object.setMaxLines(2);
                    }
                    object = this.focusContentView;
                    if (object != null) {
                        object.setMaxLines(n - 2);
                    }
                }
            } else {
                object = template.getHintInfo();
                if (object != null && ((HintInfo)object).getTitleLineCount() == 2) {
                    object = this.focusTitleView;
                    if (object != null) {
                        object.setMaxLines(n - 2);
                    }
                } else {
                    object = this.focusTitleView;
                    if (object != null) {
                        object.setMaxLines(n - 1);
                    }
                }
                object = this.focusContentView;
                if (object != null) {
                    object.setMaxLines(1);
                }
            }
        }
        this.setTextContainerBackground(template);
    }

    @Override
    public void initView(String string) {
        o.g((Object)string, (String)"module");
        super.initView(string);
        boolean bl = o.c((Object)string, (Object)"moduleText1");
        Object var4_3 = null;
        Object object = bl ? LayoutInflater.from((Context)ModuleViewHolder.getContext$default(this, false, 1, null)).inflate(R.layout.focus_notification_module_deco_port_text_1, this.getRootView()) : LayoutInflater.from((Context)ModuleViewHolder.getContext$default(this, false, 1, null)).inflate(R.layout.focus_notification_module_deco_port_text_2, this.getRootView());
        this.setView((View)object);
        object = this.getView();
        object = object != null ? (LinearLayout)object.findViewById(R.id.focus_container_module_text_1) : null;
        this.focusContainerModuleText1 = object;
        object = this.getView();
        object = object != null ? (LinearLayout)object.findViewById(R.id.focus_container_module_text_2) : null;
        this.focusContainerModuleText2 = object;
        object = this.getView();
        object = object != null ? (TextView)object.findViewById(R.id.focus_content) : null;
        this.focusContentView = object;
        object = this.getView();
        object = object != null ? (TextView)object.findViewById(R.id.focus_sub_content) : null;
        this.focusSubContentView = object;
        object = this.getView();
        object = object != null ? (TextView)object.findViewById(R.id.focus_special_title) : null;
        this.focusSpecialTitleView = object;
        View view = this.getView();
        object = var4_3;
        if (view != null) {
            object = (TextView)view.findViewById(R.id.focus_title);
        }
        this.focusTitleView = object;
        if (o.c((Object)string, (Object)"moduleText1")) {
            string = this.focusContainerModuleText1;
            if (string != null) {
                string.setVisibility(0);
            }
        } else {
            string = this.focusContainerModuleText2;
            if (string != null) {
                string.setVisibility(0);
            }
        }
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
