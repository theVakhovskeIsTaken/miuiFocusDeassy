/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.ColorStateList
 *  android.graphics.Color
 *  android.graphics.drawable.Icon
 *  android.service.notification.StatusBarNotification
 *  android.text.Html
 *  android.text.TextUtils
 *  android.util.Log
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.ViewGroup
 *  android.view.ViewGroup$LayoutParams
 *  android.widget.ImageView
 *  android.widget.LinearLayout
 *  android.widget.LinearLayout$LayoutParams
 *  android.widget.TextView
 *  com.android.systemui.miui.notification.R$dimen
 *  com.android.systemui.miui.notification.R$drawable
 *  com.android.systemui.miui.notification.R$id
 *  com.android.systemui.miui.notification.R$layout
 *  kotlin.jvm.internal.o
 *  miui.systemui.dynamicisland.DynamicIslandUtils
 */
package miui.systemui.notification.focus.moduleV3;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.drawable.Icon;
import android.service.notification.StatusBarNotification;
import android.text.Html;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.android.systemui.miui.notification.R;
import kotlin.jvm.internal.o;
import miui.systemui.dynamicisland.DynamicIslandUtils;
import miui.systemui.notification.focus.model.BaseInfo;
import miui.systemui.notification.focus.model.Template;
import miui.systemui.notification.focus.model.TextAndColorInfo;
import miui.systemui.notification.focus.moduleV3.ModuleViewHolder;

public final class ModuleTinyTextViewHolder
extends ModuleViewHolder {
    public static final Companion Companion = new Object(null){
        {
            this();
        }
    };
    public static final String TAG = "ModuleTinyTextViewHolder";
    private LinearLayout contentContainer;
    private int extra;
    private TextView extraTitleDivider;
    private TextView extraTitleView;
    private TextView focusContent;
    private TextView focusTitle;
    private TextView functionIconDivider;
    private ImageView functionIconView;
    private TextView specialTitleView;
    private TextView subContentDivider;
    private TextView subContentView;
    private TextView subTitleDivider;
    private TextView subTitleView;
    private LinearLayout titleContainer;

    public ModuleTinyTextViewHolder(Context context, Context context2, ViewGroup viewGroup, boolean bl) {
        o.g((Object)context, (String)"ctx");
        o.g((Object)context2, (String)"sysuiCtx");
        o.g((Object)viewGroup, (String)"rootView");
        super(context, context2, viewGroup, bl);
        this.extra = DynamicIslandUtils.INSTANCE.dpToPx(2, context);
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

    private final void showFocusIcon(Template object, StatusBarNotification statusBarNotification) {
        Object object2 = ((Template)object).getBaseInfo();
        object2 = object2 != null ? ((BaseInfo)object2).getPicFunction() : null;
        statusBarNotification = this.getIcon((String)object2, statusBarNotification);
        object = ((Template)object).getBaseInfo();
        boolean bl = object != null ? o.c((Object)((BaseInfo)object).getShowContentDivider(), (Object)Boolean.TRUE) : false;
        if (statusBarNotification != null) {
            object = this.functionIconView;
            if (object != null) {
                object.setImageIcon((Icon)statusBarNotification);
            }
            if ((object = this.functionIconView) != null) {
                object.setVisibility(0);
            }
            if (bl) {
                object = this.functionIconDivider;
                if (object != null) {
                    object.setVisibility(0);
                }
                object = this.getSubContentColor();
                if (object != null) {
                    int n = ((Number)object).intValue();
                    object = this.functionIconDivider;
                    if (object != null) {
                        object.setTextColor(n);
                    }
                }
            } else {
                object = this.functionIconDivider;
                if (object != null) {
                    object.setVisibility(8);
                }
            }
        } else {
            object = this.functionIconView;
            if (object != null) {
                object.setVisibility(4);
            }
            object = this.functionIconDivider;
            if (object != null) {
                object.setVisibility(8);
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
        this.initTextAndColor(template.getBaseInfo());
        Object object2 = template.getBaseInfo();
        boolean bl = object2 != null ? o.c((Object)((BaseInfo)object2).getShowDivider(), (Object)Boolean.TRUE) : false;
        object2 = template.getBaseInfo();
        boolean bl2 = object2 != null ? o.c((Object)((BaseInfo)object2).getShowContentDivider(), (Object)Boolean.TRUE) : false;
        object2 = this.focusTitle;
        if (object2 != null) {
            object2.setVisibility(0);
        }
        object2 = this.focusTitle;
        if (object2 != null) {
            object2.setText((CharSequence)Html.fromHtml((String)this.getTitle()));
        }
        object2 = this.getTitleColor();
        if (object2 != null) {
            n = ((Number)object2).intValue();
            object2 = this.focusTitle;
            if (object2 != null) {
                object2.setTextColor(n);
            }
        }
        object2 = this.getContent();
        Object var8_7 = null;
        if (object2 != null) {
            if (!TextUtils.isEmpty((CharSequence)object2)) {
                object = this.contentContainer;
                if (object != null) {
                    object.setVisibility(0);
                }
                object = this.focusContent;
                if (object != null) {
                    object.setVisibility(0);
                }
                object = this.focusContent;
                if (object != null) {
                    object.setText((CharSequence)Html.fromHtml((String)object2));
                }
                object2 = this.getContentColor();
                if (object2 != null) {
                    n = ((Number)object2).intValue();
                    object2 = this.focusContent;
                    if (object2 != null) {
                        object2.setTextColor(n);
                    }
                }
            } else {
                object2 = this.contentContainer;
                if (object2 != null) {
                    object2.setVisibility(8);
                }
                object2 = this.titleContainer;
                object2 = object2 != null ? object2.getLayoutParams() : null;
                o.e((Object)object2, (String)"null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
                object2 = (LinearLayout.LayoutParams)object2;
                object = template.getBaseInfo();
                boolean bl3 = object != null ? o.c((Object)((BaseInfo)object).getSetMarginTop(), (Object)Boolean.TRUE) : false;
                if (bl3) {
                    ((LinearLayout.LayoutParams)object2).topMargin = (int)this.getCtx().getResources().getDimension(R.dimen.focus_notify_tiny_button_without_icon_margin_start);
                }
                bl3 = (object = template.getBaseInfo()) != null ? o.c((Object)((BaseInfo)object).getSetMarginBottom(), (Object)Boolean.TRUE) : false;
                ((LinearLayout.LayoutParams)object2).bottomMargin = bl3 ? (int)this.getCtx().getResources().getDimension(R.dimen.focus_notify_tiny_button_without_icon_margin_start) : (int)this.getCtx().getResources().getDimension(R.dimen.focus_notify_tiny_button_margin_start);
                object = this.titleContainer;
                if (object != null) {
                    object.setLayoutParams((ViewGroup.LayoutParams)object2);
                }
            }
        }
        if ((object2 = this.getSubtitle()) != null) {
            if (!TextUtils.isEmpty((CharSequence)object2)) {
                object = this.subTitleView;
                if (object != null) {
                    object.setVisibility(0);
                }
                object = this.subTitleView;
                if (object != null) {
                    object.setText((CharSequence)Html.fromHtml((String)object2));
                }
                object2 = this.getSubTitleColor();
                if (object2 != null) {
                    n = ((Number)object2).intValue();
                    object2 = this.subTitleView;
                    if (object2 != null) {
                        object2.setTextColor(n);
                    }
                }
                if (bl) {
                    object2 = this.subTitleDivider;
                    if (object2 != null) {
                        object2.setVisibility(0);
                    }
                    object2 = this.getSubTitleColor();
                    if (object2 != null) {
                        n = ((Number)object2).intValue();
                        object2 = this.subTitleDivider;
                        if (object2 != null) {
                            object2.setTextColor(n);
                        }
                    }
                } else {
                    object2 = this.subTitleDivider;
                    if (object2 != null) {
                        object2.setVisibility(8);
                    }
                }
            } else {
                object2 = this.subTitleView;
                if (object2 != null) {
                    object2.setVisibility(8);
                }
                object2 = this.subTitleDivider;
                if (object2 != null) {
                    object2.setVisibility(8);
                }
            }
        }
        if ((object2 = this.getSubContent()) != null) {
            if (!TextUtils.isEmpty((CharSequence)object2)) {
                object = this.subContentView;
                if (object != null) {
                    object.setVisibility(0);
                }
                object = this.subContentView;
                if (object != null) {
                    object.setText((CharSequence)Html.fromHtml((String)object2));
                }
                object2 = this.getSubContentColor();
                if (object2 != null) {
                    n = ((Number)object2).intValue();
                    object2 = this.subContentView;
                    if (object2 != null) {
                        object2.setTextColor(n);
                    }
                }
                if (bl2) {
                    object2 = this.subContentDivider;
                    if (object2 != null) {
                        object2.setVisibility(0);
                    }
                    object2 = this.getSubContentColor();
                    if (object2 != null) {
                        n = ((Number)object2).intValue();
                        object2 = this.subContentDivider;
                        if (object2 != null) {
                            object2.setTextColor(n);
                        }
                    }
                } else {
                    object2 = this.subContentDivider;
                    if (object2 != null) {
                        object2.setVisibility(8);
                    }
                }
            } else {
                object2 = this.subContentView;
                if (object2 != null) {
                    object2.setVisibility(8);
                }
                object2 = this.subContentDivider;
                if (object2 != null) {
                    object2.setVisibility(8);
                }
            }
        }
        if ((object2 = this.getExtraTitle()) != null) {
            if (!TextUtils.isEmpty((CharSequence)object2)) {
                object = this.extraTitleView;
                if (object != null) {
                    object.setVisibility(0);
                }
                object = this.extraTitleView;
                if (object != null) {
                    object.setText((CharSequence)Html.fromHtml((String)object2));
                }
                object2 = this.getExtraTitleColor();
                if (object2 != null) {
                    n = ((Number)object2).intValue();
                    object2 = this.extraTitleView;
                    if (object2 != null) {
                        object2.setTextColor(n);
                    }
                }
                if (bl) {
                    object2 = this.getExtraTitleColor();
                    if (object2 != null) {
                        n = ((Number)object2).intValue();
                        object2 = this.extraTitleDivider;
                        if (object2 != null) {
                            object2.setTextColor(n);
                        }
                    }
                    if ((object2 = this.extraTitleDivider) != null) {
                        object2.setVisibility(0);
                    }
                } else {
                    object2 = this.extraTitleDivider;
                    if (object2 != null) {
                        object2.setVisibility(8);
                    }
                }
            } else {
                object2 = this.extraTitleView;
                if (object2 != null) {
                    object2.setVisibility(8);
                }
                object2 = this.extraTitleDivider;
                if (object2 != null) {
                    object2.setVisibility(8);
                }
            }
        }
        object = this.getSpecialTitle();
        object2 = new StringBuilder();
        ((StringBuilder)object2).append("specialTitle ");
        ((StringBuilder)object2).append((String)object);
        Log.e((String)"ModuleTextViewHolder", (String)((StringBuilder)object2).toString());
        object2 = this.getSpecialTitle();
        if (object2 != null) {
            if (!TextUtils.isEmpty((CharSequence)object2)) {
                String string = this.getSpecialTitle();
                object = new StringBuilder();
                ((StringBuilder)object).append("specialTitle1 ");
                ((StringBuilder)object).append(string);
                Log.e((String)"ModuleTextViewHolder", (String)((StringBuilder)object).toString());
                object = this.specialTitleView;
                if (object != null) {
                    object.setVisibility(0);
                }
                object = this.specialTitleView;
                if (object != null) {
                    object.setText((CharSequence)Html.fromHtml((String)object2));
                }
                object2 = this.getSpecialTitleColor();
                if (object2 != null) {
                    n = ((Number)object2).intValue();
                    object2 = this.specialTitleView;
                    if (object2 != null) {
                        object2.setTextColor(n);
                    }
                }
            } else {
                object = this.getSpecialTitle();
                object2 = new StringBuilder();
                ((StringBuilder)object2).append("specialTitle2 ");
                ((StringBuilder)object2).append((String)object);
                Log.e((String)"ModuleTextViewHolder", (String)((StringBuilder)object2).toString());
                object2 = this.specialTitleView;
                if (object2 != null) {
                    object2.setVisibility(8);
                }
            }
        }
        object2 = (object2 = this.getSpecialTitle()) != null ? Integer.valueOf(((String)object2).length()) : null;
        o.d((Object)object2);
        if ((Integer)object2 > 0) {
            object2 = this.focusTitle;
            if (object2 != null) {
                object2.setMaxEms(6);
            }
        } else {
            object2 = this.focusTitle;
            if (object2 != null) {
                object2.setMaxEms(10);
            }
        }
        object = this.getSubContent();
        object2 = var8_7;
        if (object != null) {
            object2 = ((String)object).length();
        }
        o.d((Object)object2);
        if ((Integer)object2 > 3) {
            object2 = this.focusContent;
            if (object2 != null) {
                object2.setMaxEms(6);
            }
        } else {
            object2 = this.focusContent;
            if (object2 != null) {
                object2.setMaxEms(10);
            }
        }
        this.showFocusIcon(template, statusBarNotification);
        this.setTextContainerBackground(template);
    }

    @Override
    public void initView(String string) {
        o.g((Object)string, (String)"module");
        super.initView(string);
        boolean bl = o.c((Object)string, (Object)"moduleText1");
        Object var3_3 = null;
        if (bl) {
            this.setView(LayoutInflater.from((Context)ModuleViewHolder.getContext$default(this, false, 1, null)).inflate(R.layout.focus_notification_module_tiny_text_1, this.getRootView()));
        } else {
            this.setView(LayoutInflater.from((Context)ModuleViewHolder.getContext$default(this, false, 1, null)).inflate(R.layout.focus_notification_module_tiny_text_2, this.getRootView()));
        }
        string = this.getView();
        string = string != null ? (TextView)string.findViewById(R.id.focus_title) : null;
        this.focusTitle = string;
        string = this.getView();
        string = string != null ? (LinearLayout)string.findViewById(R.id.tiny_content_container) : null;
        this.contentContainer = string;
        string = this.getView();
        string = string != null ? (TextView)string.findViewById(R.id.focus_content) : null;
        this.focusContent = string;
        string = this.getView();
        string = string != null ? (LinearLayout)string.findViewById(R.id.tiny_title_container) : null;
        this.titleContainer = string;
        string = this.getView();
        string = string != null ? (TextView)string.findViewById(R.id.focus_subtitle) : null;
        this.subTitleView = string;
        string = this.getView();
        string = string != null ? (TextView)string.findViewById(R.id.focus_subtitle_divider) : null;
        this.subTitleDivider = string;
        string = this.getView();
        string = string != null ? (TextView)string.findViewById(R.id.focus_sub_content) : null;
        this.subContentView = string;
        string = this.getView();
        string = string != null ? (TextView)string.findViewById(R.id.focus_sub_content_divider) : null;
        this.subContentDivider = string;
        string = this.getView();
        string = string != null ? (TextView)string.findViewById(R.id.focus_extra_title) : null;
        this.extraTitleView = string;
        string = this.getView();
        string = string != null ? (TextView)string.findViewById(R.id.focus_extra_title_divider) : null;
        this.extraTitleDivider = string;
        string = this.getView();
        string = string != null ? (TextView)string.findViewById(R.id.focus_special_title) : null;
        this.specialTitleView = string;
        string = this.getView();
        string = string != null ? (ImageView)string.findViewById(R.id.focus_function_icon) : null;
        this.functionIconView = string;
        View view = this.getView();
        string = var3_3;
        if (view != null) {
            string = (TextView)view.findViewById(R.id.focus_function_icon_divider);
        }
        this.functionIconDivider = string;
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
        this.initTextAndColor(template.getBaseInfo());
        this.bind(template, statusBarNotification);
    }
}
