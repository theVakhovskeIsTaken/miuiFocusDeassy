/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  U0.a
 *  android.content.Context
 *  android.graphics.drawable.Icon
 *  android.service.notification.StatusBarNotification
 *  android.text.Html
 *  android.text.TextUtils
 *  android.util.Log
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

import U0.a;
import android.content.Context;
import android.graphics.drawable.Icon;
import android.service.notification.StatusBarNotification;
import android.text.Html;
import android.text.TextUtils;
import android.util.Log;
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
import miui.systemui.notification.focus.moduleV3.ext.ModuleViewHolderExtKt;
import miuix.colorful.texteffect.HyperChronometer;

public final class ModuleImageTextHighlightViewHolder
extends ModuleViewHolder {
    public static final Companion Companion = new Object(null){
        {
            this();
        }
    };
    public static final String TAG = "ModuleImageTextHighlightViewHolder";
    private HyperChronometer chronometer;
    private View container;
    private TextView currentTitleView;
    private int extra;
    private TextView focusContent;
    private ImageView focusIcon;
    private TextView focusSubContent;
    private TextView focusTitle;
    private final boolean island;

    public ModuleImageTextHighlightViewHolder(Context context, Context context2, ViewGroup viewGroup, boolean bl, boolean bl2) {
        o.g((Object)context, (String)"ctx");
        o.g((Object)context2, (String)"sysuiCtx");
        o.g((Object)viewGroup, (String)"rootView");
        super(context, context2, viewGroup, bl);
        this.island = bl2;
    }

    public static final /* synthetic */ void access$adaptTitleContentViews(ModuleImageTextHighlightViewHolder moduleImageTextHighlightViewHolder) {
        moduleImageTextHighlightViewHolder.adaptTitleContentViews();
    }

    private final void adaptTitleContentViews() {
        this.checkAndCompressTitleViews();
    }

    private final void checkAndCompressTitleViews() {
        this.compressTitleViewsStep1();
        this.compressTitleViewsStep2();
    }

    private final void compressTitleViewsStep1() {
        int n = this.getTitleViewsTotalWidth();
        if (n != 0 && this.getView() != null && this.currentTitleView != null) {
            Object object = this.getView();
            Object object2 = null;
            StringBuilder stringBuilder = null;
            object = object != null ? Integer.valueOf(object.getWidth()) : null;
            o.d((Object)object);
            int n2 = (Integer)object - this.extra;
            object = new StringBuilder();
            ((StringBuilder)object).append("compressTitleViewsStep1 totalWidth ");
            ((StringBuilder)object).append(n);
            ((StringBuilder)object).append(" layoutWidth ");
            ((StringBuilder)object).append(n2);
            Log.i((String)TAG, (String)((StringBuilder)object).toString());
            object = this.getView();
            object = object != null ? object.getContext() : null;
            int n3 = ModuleViewHolderExtKt.dpToPx((Context)object, 30);
            if (n <= n2) {
                n = this.getTextViewWidth(this.currentTitleView);
                object2 = this.currentTitleView;
                object = stringBuilder;
                if (object2 != null) {
                    object = object2.getWidth();
                }
                o.d((Object)object);
                if (n > (Integer)object) {
                    object = this.currentTitleView;
                    this.setViewWidth((TextView)object, this.getTextViewWidth((TextView)object), 0);
                }
                object = this.focusContent;
                this.setViewWidth((TextView)object, this.getTextViewWidth((TextView)object), 0);
                object = this.focusSubContent;
                this.setViewWidth((TextView)object, this.getTextViewWidth((TextView)object), 0);
                return;
            }
            int n4 = n - n2;
            object = new StringBuilder();
            ((StringBuilder)object).append("compressTitleViewsStep1 excessWidth ");
            ((StringBuilder)object).append(n4);
            Log.i((String)TAG, (String)((StringBuilder)object).toString());
            int n5 = this.getTextViewWidth(this.focusContent);
            int n6 = this.getTextViewWidth(this.focusSubContent);
            if (n4 > 0) {
                int n7;
                object = this.currentTitleView;
                object = object != null ? Integer.valueOf(object.getWidth()) : null;
                stringBuilder = new StringBuilder();
                stringBuilder.append("compressTitleViewsStep1 focusContent ");
                stringBuilder.append(object);
                stringBuilder.append(" ");
                stringBuilder.append(n3);
                Log.i((String)TAG, (String)stringBuilder.toString());
                n = n5 > n3 ? 1 : 0;
                stringBuilder = this.focusSubContent;
                object = object2;
                if (stringBuilder != null) {
                    object = stringBuilder.getWidth();
                }
                object2 = new StringBuilder();
                ((StringBuilder)object2).append("compressTitleViewsStep1 focusSubContent ");
                ((StringBuilder)object2).append(object);
                ((StringBuilder)object2).append(" ");
                ((StringBuilder)object2).append(n3);
                Log.i((String)TAG, (String)((StringBuilder)object2).toString());
                n2 = n;
                if (n6 > 0) {
                    n2 = n + 1;
                }
                if (n2 == 2) {
                    n = n4 / n2;
                    n7 = n3 - (n5 - n);
                    n = -(n6 - n);
                } else {
                    n = 0;
                    n7 = 0;
                }
                if (n5 > n3) {
                    this.setViewWidth(this.focusContent, n3 - n4 / n2 - Math.max(n, 0), n3);
                }
                if (n6 > 0) {
                    this.setViewWidth(this.focusSubContent, n6 - n4 / n2 - Math.max(n7, 0), n3);
                }
            }
        }
    }

    private final void compressTitleViewsStep2() {
        int n = this.getTitleViewsTotalWidthAfterCompress();
        if (n != 0 && this.getView() != null) {
            Object object = this.getView();
            Object var5_3 = null;
            object = object != null ? Integer.valueOf(object.getWidth()) : null;
            o.d((Object)object);
            int n2 = (Integer)object - this.extra;
            object = new StringBuilder();
            ((StringBuilder)object).append("compressTitleViewsStep2 totalWidth ");
            ((StringBuilder)object).append(n);
            ((StringBuilder)object).append(" layoutWidth ");
            ((StringBuilder)object).append(n2);
            Log.i((String)TAG, (String)((StringBuilder)object).toString());
            if (n <= n2) {
                return;
            }
            View view = this.getView();
            object = var5_3;
            if (view != null) {
                object = view.getContext();
            }
            int n3 = ModuleViewHolderExtKt.dpToPx((Context)object, 100);
            if ((n -= n2) > 0 && this.getTextViewWidth(this.currentTitleView) > n3) {
                object = this.currentTitleView;
                this.setViewWidth((TextView)object, this.getTextViewWidth((TextView)object) - n, n3);
            }
            if ((object = this.getView()) != null) {
                object.requestLayout();
            }
        }
    }

    private final int getTitleViewsTotalWidth() {
        int n;
        Object object = this.getView();
        int n2 = 0;
        if (object == null) {
            return 0;
        }
        object = this.getView();
        Integer n3 = null;
        object = object != null ? object.getContext() : null;
        int n4 = ModuleViewHolderExtKt.dpToPx((Context)object, 4);
        int n5 = this.getTextViewWidth(this.currentTitleView);
        int n6 = this.getTextViewWidth(this.focusContent);
        int n7 = this.getTextViewWidth(this.focusContent) > 0 ? n4 : 0;
        object = this.focusIcon;
        if (object != null && object.getVisibility() == 0) {
            object = this.focusIcon;
            object = object != null ? Integer.valueOf(object.getWidth()) : null;
            o.d((Object)object);
            n = (Integer)object;
        } else {
            n = 0;
        }
        object = this.focusIcon;
        object = object != null ? Integer.valueOf(object.getWidth()) : null;
        o.d((Object)object);
        int n8 = (Integer)object > 0 ? n4 : 0;
        int n9 = this.getTextViewWidth(this.focusSubContent);
        if (this.getTextViewWidth(this.focusSubContent) > 0) {
            n2 = n4;
        }
        n6 = n5 + n6 + n7 + n + n8 + n9 + n2 + n4;
        n2 = this.getTextViewWidth(this.currentTitleView);
        n = this.getTextViewWidth(this.focusContent);
        n7 = this.getTextViewWidth(this.focusContent);
        object = this.focusIcon;
        object = object != null ? Integer.valueOf(object.getVisibility()) : null;
        Object object2 = this.focusIcon;
        if (object2 != null) {
            n3 = object2.getWidth();
        }
        n8 = this.getTextViewWidth(this.focusSubContent);
        object2 = new StringBuilder();
        ((StringBuilder)object2).append("getTitleViewsTotalWidth: ");
        ((StringBuilder)object2).append(n6);
        ((StringBuilder)object2).append(" ");
        ((StringBuilder)object2).append(n2);
        ((StringBuilder)object2).append(" ");
        ((StringBuilder)object2).append(n);
        ((StringBuilder)object2).append(" ");
        ((StringBuilder)object2).append(n7);
        ((StringBuilder)object2).append("  ");
        ((StringBuilder)object2).append(object);
        ((StringBuilder)object2).append(" ");
        ((StringBuilder)object2).append(n3);
        ((StringBuilder)object2).append(" ");
        ((StringBuilder)object2).append(n8);
        ((StringBuilder)object2).append(" ");
        ((StringBuilder)object2).append(n4);
        Log.d((String)TAG, (String)((StringBuilder)object2).toString());
        return n6;
    }

    /*
     * Unable to fully structure code
     */
    private final int getTitleViewsTotalWidthAfterCompress() {
        block14: {
            block13: {
                var9_1 = this.getView();
                var5_2 = 0;
                if (var9_1 == null) {
                    return 0;
                }
                var9_1 = this.getView();
                var10_3 = null;
                var9_1 = var9_1 != null ? var9_1.getContext() : null;
                var1_4 = ModuleViewHolderExtKt.dpToPx((Context)var9_1, 4);
                var9_1 = this.focusContent;
                var9_1 = var9_1 != null && (var9_1 = var9_1.getLayoutParams()) != null ? Integer.valueOf(var9_1.width) : null;
                o.d((Object)var9_1);
                if (var9_1.intValue() > 0) {
                    var9_1 = this.focusContent;
                    if (var9_1 != null && (var9_1 = var9_1.getLayoutParams()) != null) {
                        var2_5 = var9_1.width;
lbl16:
                        // 2 sources

                        while (true) {
                            var9_1 = var2_5;
                            break block13;
                            break;
                        }
                    }
lbl19:
                    // 3 sources

                    while (true) {
                        var9_1 = null;
                        break block13;
                        break;
                    }
                }
                ** while ((var9_1 = this.focusContent) == null)
lbl23:
                // 1 sources

                var2_5 = var9_1.getWidth();
                ** while (true)
            }
            o.d((Object)var9_1);
            var6_6 = var9_1.intValue();
            var9_1 = this.focusSubContent;
            var9_1 = var9_1 != null && (var9_1 = var9_1.getLayoutParams()) != null ? Integer.valueOf(var9_1.width) : null;
            o.d((Object)var9_1);
            if (var9_1.intValue() > 0) {
                var9_1 = this.focusSubContent;
                if (var9_1 != null && (var9_1 = var9_1.getLayoutParams()) != null) {
                    var2_5 = var9_1.width;
lbl35:
                    // 2 sources

                    while (true) {
                        var9_1 = var2_5;
                        break block14;
                        break;
                    }
                }
lbl38:
                // 3 sources

                while (true) {
                    var9_1 = null;
                    break block14;
                    break;
                }
            }
            ** while ((var9_1 = this.focusSubContent) == null)
lbl42:
            // 1 sources

            var2_5 = var9_1.getWidth();
            ** while (true)
        }
        o.d((Object)var9_1);
        var7_7 = var9_1.intValue();
        var8_8 = this.getTextViewWidth(this.currentTitleView);
        var2_5 = var6_6 > 0 ? var1_4 : 0;
        var9_1 = this.focusIcon;
        if (var9_1 != null && var9_1.getVisibility() == 0) {
            var9_1 = this.focusIcon;
            var9_1 = var9_1 != null ? Integer.valueOf(var9_1.getWidth()) : null;
            o.d((Object)var9_1);
            var3_9 = var9_1.intValue();
        } else {
            var3_9 = 0;
        }
        var9_1 = this.focusIcon;
        var9_1 = var9_1 != null ? Integer.valueOf(var9_1.getWidth()) : null;
        o.d((Object)var9_1);
        var4_10 = var9_1.intValue() > 0 ? var1_4 : 0;
        if (var7_7 > 0) {
            var5_2 = var1_4;
        }
        var2_5 = var8_8 + var6_6 + var2_5 + var3_9 + var4_10 + var7_7 + var5_2;
        var3_9 = this.getTextViewWidth(this.currentTitleView);
        var11_11 = this.focusIcon;
        var9_1 = var10_3;
        if (var11_11 != null) {
            var9_1 = var11_11.getWidth();
        }
        var10_3 = new StringBuilder();
        var10_3.append("getTitleViewsTotalWidthAfterCompress: ");
        var10_3.append(var2_5);
        var10_3.append(" ");
        var10_3.append(var3_9);
        var10_3.append(" ");
        var10_3.append(var6_6);
        var10_3.append(" ");
        var10_3.append(var9_1);
        var10_3.append(" ");
        var10_3.append(var7_7);
        var10_3.append(" ");
        var10_3.append(var1_4);
        Log.d((String)"ModuleImageTextHighlightViewHolder", (String)var10_3.toString());
        return var2_5;
    }

    private final void showFocusIcon(Template object, StatusBarNotification statusBarNotification) {
        boolean bl = this.isDark();
        Object object2 = null;
        HighlightInfo highlightInfo = null;
        if (bl) {
            object2 = ((Template)object).getHighlightInfo();
            object2 = object2 != null ? ((HighlightInfo)object2).getPicFunctionDark() : null;
            Icon icon = this.getIcon((String)object2, statusBarNotification);
            object2 = icon;
            if (icon == null) {
                object2 = ((Template)object).getHighlightInfo();
                object = highlightInfo;
                if (object2 != null) {
                    object = ((HighlightInfo)object2).getPicFunction();
                }
                object2 = this.getIcon((String)object, statusBarNotification);
            }
        } else {
            highlightInfo = ((Template)object).getHighlightInfo();
            object = object2;
            if (highlightInfo != null) {
                object = highlightInfo.getPicFunction();
            }
            object2 = this.getIcon((String)object, statusBarNotification);
        }
        if (object2 != null) {
            object = this.focusIcon;
            if (object != null) {
                object.setVisibility(0);
            }
            object = this.focusIcon;
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
            this.currentTitleView = this.focusTitle;
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
            this.currentTitleView = this.chronometer;
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
        if ((object = this.getSubContent()) != null && !TextUtils.isEmpty((CharSequence)object)) {
            TextView textView = this.focusSubContent;
            if (textView != null) {
                textView.setVisibility(0);
            }
            textView = this.focusSubContent;
            if (textView != null) {
                textView.setText((CharSequence)Html.fromHtml((String)object));
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
        this.notifyDataChanged();
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

    public final boolean getIsland() {
        return this.island;
    }

    @Override
    public void initView(String string) {
        o.g((Object)string, (String)"module");
        super.initView(string);
        this.setView(LayoutInflater.from((Context)this.getContext(this.island)).inflate(R.layout.focus_notification_module_image_text_highlight, this.getRootView()));
        string = this.getView();
        Object var2_2 = null;
        string = string != null ? string.findViewById(R.id.focus_container_module_image_text_highlight) : null;
        this.container = string;
        string = this.getView();
        string = string != null ? (HyperChronometer)string.findViewById(R.id.chronometer) : null;
        this.chronometer = string;
        if (string != null) {
            string.setEnableEffectWithInit(false);
        }
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
        string = var2_2;
        if (view != null) {
            string = (ImageView)view.findViewById(R.id.focus_function_icon);
        }
        this.focusIcon = string;
        this.registerCompressChanged(new a(this){
            final ModuleImageTextHighlightViewHolder this$0;
            {
                this.this$0 = moduleImageTextHighlightViewHolder;
                super(0);
            }

            public final void invoke() {
                ModuleImageTextHighlightViewHolder.access$adaptTitleContentViews(this.this$0);
            }
        });
    }

    @Override
    public void onDetach() {
        super.onDetach();
        this.getRootView().removeView(this.getView());
        this.setView(null);
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
