/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  U0.a
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

import U0.a;
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
import miui.systemui.notification.focus.moduleV3.ext.ModuleViewHolderExtKt;

public final class ModuleTextViewHolder
extends ModuleViewHolder {
    public static final Companion Companion = new Object(null){
        {
            this();
        }
    };
    public static final String TAG = "ModuleTextViewHolder";
    private LinearLayout contentContainer;
    private int extra;
    private TextView extraTitleDivider;
    private TextView extraTitleView;
    private TextView focusContent;
    private TextView focusTitle;
    private TextView functionIconDivider;
    private ImageView functionIconView;
    private final boolean island;
    private TextView specialTitleView;
    private TextView subContentDivider;
    private TextView subContentView;
    private TextView subTitleDivider;
    private TextView subTitleView;
    private LinearLayout titleContainer;

    public ModuleTextViewHolder(Context context, Context context2, ViewGroup viewGroup, boolean bl, boolean bl2) {
        o.g((Object)context, (String)"ctx");
        o.g((Object)context2, (String)"sysuiCtx");
        o.g((Object)viewGroup, (String)"rootView");
        super(context, context2, viewGroup, bl);
        this.island = bl2;
        this.extra = DynamicIslandUtils.INSTANCE.dpToPx(2, context);
    }

    public static final /* synthetic */ void access$checkAndCompressContentViews(ModuleTextViewHolder moduleTextViewHolder) {
        moduleTextViewHolder.checkAndCompressContentViews();
    }

    public static final /* synthetic */ void access$checkAndCompressTitleViews(ModuleTextViewHolder moduleTextViewHolder) {
        moduleTextViewHolder.checkAndCompressTitleViews();
    }

    private final void checkAndCompressContentViews() {
        if (this.getView() == null) {
            return;
        }
        int n = this.getContentViewsTotalWidth();
        Object object = this.getView();
        int n2 = object != null ? object.getMeasuredWidth() : 0;
        object = this.getView();
        object = object != null ? object.getContext() : null;
        int n3 = ModuleViewHolderExtKt.dpToPx((Context)object, 84);
        if (n <= (n2 -= this.extra)) {
            object = this.focusContent;
            this.setViewWidth((TextView)object, this.getTextViewWidth((TextView)object), Math.min(this.getTextViewWidth(this.focusContent), n3));
            if (!TextUtils.isEmpty((CharSequence)this.getSubContent())) {
                object = this.subContentView;
                this.setViewWidth((TextView)object, this.getTextViewWidth((TextView)object), Math.min(this.getTextViewWidth(this.subContentView), n3));
            }
            return;
        }
        int n4 = n - n2;
        int n5 = this.getTextViewWidth(this.focusContent);
        int n6 = this.getTextViewWidth(this.subContentView);
        object = new StringBuilder();
        ((StringBuilder)object).append("checkAndCompressContentViews: excessWidth ");
        ((StringBuilder)object).append(n4);
        Log.d((String)TAG, (String)((StringBuilder)object).toString());
        if (n4 > 0) {
            int n7;
            n2 = n5 > n3 ? 1 : 0;
            n = n2;
            if (n6 > n3) {
                n = n2 + 1;
            }
            if (n == 2) {
                n2 = n4 / n;
                n7 = n3 - (n5 - n2);
                n2 = n3 - (n6 - n2);
            } else {
                n2 = 0;
                n7 = 0;
            }
            if (n5 > n3) {
                this.setViewWidth(this.focusContent, n5 - n4 / n - Math.max(n2, 0), n3);
            }
            if (n6 > n3) {
                this.setViewWidth(this.subContentView, n6 - n4 / n - Math.max(n7, 0), n3);
            }
        }
    }

    private final void checkAndCompressTitleViews() {
        this.compressTitleViewsStep1(false);
        this.compressTitleViewsStep2();
        this.compressTitleViewsStep1(true);
        this.compressTitleViewsStep1(true);
    }

    private final void compressTitleViewsStep1(boolean bl) {
        int n;
        int n2;
        int n3;
        if (this.getView() == null) {
            return;
        }
        int n4 = this.getTitleViewsTotalWidthAfterCompress();
        if (!bl) {
            n4 = this.getTitleViewsTotalWidth();
        }
        Object object = this.getView();
        int n5 = object != null ? object.getMeasuredWidth() : 0;
        object = this.getView();
        Object var10_5 = null;
        object = object != null ? object.getContext() : null;
        int n6 = ModuleViewHolderExtKt.dpToPx((Context)object, 80);
        if (n4 <= (n5 -= this.extra)) {
            if (!bl) {
                object = this.focusTitle;
                this.setViewWidth((TextView)object, this.getTextViewWidth((TextView)object), Math.min(this.getTextViewWidth(this.focusTitle), n6));
                object = this.subTitleView;
                this.setViewWidth((TextView)object, this.getTextViewWidth((TextView)object), Math.min(this.getTextViewWidth(this.subTitleView), n6));
                object = this.extraTitleView;
                this.setViewWidth((TextView)object, this.getTextViewWidth((TextView)object), Math.min(this.getTextViewWidth(this.extraTitleView), 0));
            }
            return;
        }
        int n7 = n4 - n5;
        object = new StringBuilder();
        ((StringBuilder)object).append("compressTitleViewsStep1 excessWidth ");
        ((StringBuilder)object).append(n7);
        ((StringBuilder)object).append(" ");
        ((StringBuilder)object).append(bl);
        Log.i((String)TAG, (String)((StringBuilder)object).toString());
        object = this.focusTitle;
        if (bl) {
            object = object != null && (object = object.getLayoutParams()) != null ? Integer.valueOf(((ViewGroup.LayoutParams)object).width) : null;
            o.d((Object)object);
            n3 = (Integer)object;
        } else {
            n3 = this.getTextViewWidth((TextView)object);
        }
        object = this.subTitleView;
        if (bl) {
            object = object != null && (object = object.getLayoutParams()) != null ? Integer.valueOf(((ViewGroup.LayoutParams)object).width) : null;
            o.d((Object)object);
            n2 = (Integer)object;
        } else {
            n2 = this.getTextViewWidth((TextView)object);
        }
        if (bl) {
            TextView textView = this.extraTitleView;
            object = var10_5;
            if (textView != null) {
                textView = textView.getLayoutParams();
                object = var10_5;
                if (textView != null) {
                    object = textView.width;
                }
            }
            o.d((Object)object);
            n = (Integer)object;
        } else {
            n = this.getTextViewWidth(this.extraTitleView);
        }
        if (n7 > 0) {
            object = new StringBuilder();
            ((StringBuilder)object).append("compressTitleViewsStep1 focusTitle ");
            ((StringBuilder)object).append(n3);
            ((StringBuilder)object).append(" ");
            ((StringBuilder)object).append(n6);
            Log.i((String)TAG, (String)((StringBuilder)object).toString());
            n5 = n3 > n6 ? 1 : 0;
            object = new StringBuilder();
            ((StringBuilder)object).append("compressTitleViewsStep1 subTitleView ");
            ((StringBuilder)object).append(n2);
            ((StringBuilder)object).append(" ");
            ((StringBuilder)object).append(n6);
            Log.i((String)TAG, (String)((StringBuilder)object).toString());
            n4 = n5;
            if (n2 > n6) {
                n4 = n5 + 1;
            }
            object = new StringBuilder();
            ((StringBuilder)object).append("compressTitleViewsStep1 extraTitleView ");
            ((StringBuilder)object).append(n);
            ((StringBuilder)object).append(" ");
            ((StringBuilder)object).append(n6);
            Log.i((String)TAG, (String)((StringBuilder)object).toString());
            n5 = n4;
            if (n > n6) {
                n5 = n4 + 1;
            }
            if (n5 > 0) {
                n4 = n7;
                if (n7 >= n5) {
                    n4 = n7 / n5;
                }
                if (n3 > n6) {
                    this.setViewWidth(this.focusTitle, n3 - n4, n6);
                } else {
                    object = this.focusTitle;
                    this.setViewWidth((TextView)object, this.getTextViewWidth((TextView)object), Math.min(this.getTextViewWidth(this.focusTitle), n6));
                }
                if (n2 > n6) {
                    this.setViewWidth(this.subTitleView, n2 - n4, n6);
                } else {
                    object = this.subTitleView;
                    this.setViewWidth((TextView)object, this.getTextViewWidth((TextView)object), Math.min(this.getTextViewWidth(this.subTitleView), n6));
                }
                if (n > n6) {
                    this.setViewWidth(this.extraTitleView, n - n4, n6);
                    object = this.subTitleDivider;
                    if (object != null && object.getVisibility() == 0 && (object = this.extraTitleView) != null && object.getVisibility() == 0 && (object = this.extraTitleDivider) != null) {
                        object.setVisibility(0);
                    }
                } else {
                    object = this.extraTitleView;
                    this.setViewWidth((TextView)object, this.getTextViewWidth((TextView)object), Math.min(this.getTextViewWidth(this.extraTitleView), 0));
                }
            }
        }
    }

    private final void compressTitleViewsStep2() {
        if (this.getView() == null) {
            return;
        }
        int n = this.getTitleViewsTotalWidthAfterCompress();
        Object object = this.getView();
        int n2 = object != null ? object.getMeasuredWidth() : 0;
        if (n <= (n2 -= this.extra)) {
            return;
        }
        n2 = n - n2;
        object = new StringBuilder();
        ((StringBuilder)object).append("compressTitleViewsStep2 excessWidth ");
        ((StringBuilder)object).append(n2);
        Log.i((String)TAG, (String)((StringBuilder)object).toString());
        if (n2 > 0) {
            object = this.extraTitleView;
            Object var4_4 = null;
            object = object != null && (object = object.getLayoutParams()) != null ? Integer.valueOf(((ViewGroup.LayoutParams)object).width) : null;
            o.d((Object)object);
            if ((Integer)object > 0) {
                object = this.getView();
                object = object != null ? object.getContext() : null;
                n = ModuleViewHolderExtKt.dpToPx((Context)object, 45);
                TextView textView = this.extraTitleView;
                TextView textView2 = this.extraTitleDivider;
                object = var4_4;
                if (textView != null) {
                    ViewGroup.LayoutParams layoutParams = textView.getLayoutParams();
                    object = var4_4;
                    if (layoutParams != null) {
                        object = layoutParams.width;
                    }
                }
                o.d((Object)object);
                this.setViewWidthMinZero(textView, (View)textView2, (Integer)object - n2, n);
            } else {
                object = this.getView();
                if (object != null) {
                    object.requestLayout();
                }
            }
        }
    }

    private final int getContentViewsTotalWidth() {
        Object object = this.getView();
        int n = 0;
        if (object == null) {
            return 0;
        }
        object = this.getView();
        Integer n2 = null;
        object = object != null ? object.getContext() : null;
        int n3 = ModuleViewHolderExtKt.dpToPx((Context)object, 8);
        int n4 = this.getTextViewWidth(this.focusContent);
        object = this.subContentDivider;
        object = object != null ? Integer.valueOf(object.getWidth()) : null;
        o.d((Object)object);
        int n5 = (Integer)object;
        object = this.subContentDivider;
        object = object != null ? Integer.valueOf(object.getWidth()) : null;
        o.d((Object)object);
        int n6 = (Integer)object > 0 ? n3 : 0;
        int n7 = this.getTextViewWidth(this.subContentView);
        int n8 = this.getTextViewWidth(this.subContentView) > 0 ? n3 : 0;
        object = this.functionIconDivider;
        object = object != null ? Integer.valueOf(object.getWidth()) : null;
        o.d((Object)object);
        int n9 = (Integer)object;
        object = this.functionIconDivider;
        object = object != null ? Integer.valueOf(object.getWidth()) : null;
        o.d((Object)object);
        int n10 = (Integer)object > 0 ? n3 : 0;
        object = this.functionIconView;
        object = object != null ? Integer.valueOf(object.getWidth()) : null;
        o.d((Object)object);
        int n11 = (Integer)object;
        object = this.functionIconView;
        object = object != null ? Integer.valueOf(object.getWidth()) : null;
        o.d((Object)object);
        if ((Integer)object > 0) {
            n = n3;
        }
        n6 = n4 + n5 + n6 + n7 + n8 + n9 + n10 + n11 + n;
        n10 = this.getTextViewWidth(this.focusContent);
        object = this.subContentDivider;
        object = object != null ? Integer.valueOf(object.getWidth()) : null;
        n8 = this.getTextViewWidth(this.subContentView);
        Object object2 = this.functionIconDivider;
        object2 = object2 != null ? Integer.valueOf(object2.getWidth()) : null;
        Object object3 = this.functionIconView;
        if (object3 != null) {
            n2 = object3.getVisibility();
        }
        object3 = new StringBuilder();
        ((StringBuilder)object3).append("getContentViewsTotalWidth: ");
        ((StringBuilder)object3).append(n6);
        ((StringBuilder)object3).append(" ");
        ((StringBuilder)object3).append(n10);
        ((StringBuilder)object3).append(" ");
        ((StringBuilder)object3).append(object);
        ((StringBuilder)object3).append(" ");
        ((StringBuilder)object3).append(n8);
        ((StringBuilder)object3).append(" ");
        ((StringBuilder)object3).append(object2);
        ((StringBuilder)object3).append(" ");
        ((StringBuilder)object3).append(n2);
        ((StringBuilder)object3).append(" ");
        ((StringBuilder)object3).append(n3);
        Log.d((String)TAG, (String)((StringBuilder)object3).toString());
        return n6;
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
        int n4 = ModuleViewHolderExtKt.dpToPx((Context)object, 8);
        int n5 = this.getTextViewWidth(this.focusTitle);
        object = this.subTitleDivider;
        object = object != null ? Integer.valueOf(object.getWidth()) : null;
        o.d((Object)object);
        int n6 = (Integer)object;
        object = this.subTitleDivider;
        object = object != null ? Integer.valueOf(object.getWidth()) : null;
        o.d((Object)object);
        int n7 = (Integer)object > 0 ? n4 : 0;
        int n8 = this.getTextViewWidth(this.subTitleView);
        int n9 = this.getTextViewWidth(this.subTitleView) > 0 ? n4 : 0;
        object = this.extraTitleDivider;
        object = object != null ? Integer.valueOf(object.getWidth()) : null;
        o.d((Object)object);
        int n10 = (Integer)object;
        object = this.extraTitleDivider;
        object = object != null ? Integer.valueOf(object.getWidth()) : null;
        o.d((Object)object);
        int n11 = (Integer)object > 0 ? n4 : 0;
        int n12 = this.getTextViewWidth(this.extraTitleView);
        int n13 = this.getTextViewWidth(this.extraTitleView) > 0 ? n4 : 0;
        object = this.specialTitleView;
        if (object != null && object.getVisibility() == 0) {
            object = this.specialTitleView;
            object = object != null ? Integer.valueOf(object.getWidth()) : null;
            o.d((Object)object);
            n = (Integer)object;
        } else {
            object = this.specialTitleView;
            n = n2;
            if (object != null) {
                n = n2;
                if (object.getVisibility() == 0) {
                    n = n4;
                }
            }
        }
        n = n5 + n6 + n7 + n8 + n9 + n10 + n11 + n12 + n13 + n;
        object = this.focusTitle;
        object = object != null ? Integer.valueOf(object.getWidth()) : null;
        Object object2 = this.subTitleDivider;
        object2 = object2 != null ? Integer.valueOf(object2.getWidth()) : null;
        Object object3 = this.subTitleView;
        object3 = object3 != null ? Integer.valueOf(object3.getWidth()) : null;
        Object object4 = this.extraTitleView;
        object4 = object4 != null ? Integer.valueOf(object4.getWidth()) : null;
        Object object5 = this.specialTitleView;
        object5 = object5 != null ? Integer.valueOf(object5.getVisibility()) : null;
        Object object6 = this.specialTitleView;
        if (object6 != null) {
            n3 = object6.getWidth();
        }
        object6 = new StringBuilder();
        ((StringBuilder)object6).append("getTitleViewsTotalWidth: ");
        ((StringBuilder)object6).append(n);
        ((StringBuilder)object6).append(" ");
        ((StringBuilder)object6).append(object);
        ((StringBuilder)object6).append(" ");
        ((StringBuilder)object6).append(object2);
        ((StringBuilder)object6).append(" ");
        ((StringBuilder)object6).append(object3);
        ((StringBuilder)object6).append(" ");
        ((StringBuilder)object6).append(object4);
        ((StringBuilder)object6).append(" ");
        ((StringBuilder)object6).append(object5);
        ((StringBuilder)object6).append(" ");
        ((StringBuilder)object6).append(n3);
        ((StringBuilder)object6).append(" ");
        ((StringBuilder)object6).append(n4);
        Log.d((String)TAG, (String)((StringBuilder)object6).toString());
        return n;
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    private final int getTitleViewsTotalWidthAfterCompress() {
        block20: {
            block19: {
                block18: {
                    var14_1 = this.getView();
                    var7_2 = 0;
                    if (var14_1 == null) {
                        return 0;
                    }
                    var14_1 = this.getView();
                    var16_3 = null;
                    var14_1 = var14_1 != null ? var14_1.getContext() : null;
                    var1_4 = ModuleViewHolderExtKt.dpToPx((Context)var14_1, 8);
                    var14_1 = this.focusTitle;
                    var14_1 = var14_1 != null && (var14_1 = var14_1.getLayoutParams()) != null ? Integer.valueOf(var14_1.width) : null;
                    o.d((Object)var14_1);
                    if (var14_1.intValue() >= 0) {
                        var14_1 = this.focusTitle;
                        if (var14_1 != null && (var14_1 = var14_1.getLayoutParams()) != null) {
                            var2_5 = var14_1.width;
lbl16:
                            // 2 sources

                            while (true) {
                                var14_1 = var2_5;
                                break block18;
                                break;
                            }
                        }
lbl19:
                        // 3 sources

                        while (true) {
                            var14_1 = null;
                            break block18;
                            break;
                        }
                    }
                    ** while ((var14_1 = this.focusTitle) == null)
lbl23:
                    // 1 sources

                    var2_5 = var14_1.getWidth();
                    ** while (true)
                }
                o.d((Object)var14_1);
                var8_6 = var14_1.intValue();
                var14_1 = this.subTitleView;
                var14_1 = var14_1 != null && (var14_1 = var14_1.getLayoutParams()) != null ? Integer.valueOf(var14_1.width) : null;
                o.d((Object)var14_1);
                if (var14_1.intValue() >= 0) {
                    var14_1 = this.subTitleView;
                    if (var14_1 != null && (var14_1 = var14_1.getLayoutParams()) != null) {
                        var2_5 = var14_1.width;
lbl35:
                        // 2 sources

                        while (true) {
                            var14_1 = var2_5;
                            break block19;
                            break;
                        }
                    }
lbl38:
                    // 3 sources

                    while (true) {
                        var14_1 = null;
                        break block19;
                        break;
                    }
                }
                ** while ((var14_1 = this.subTitleView) == null)
lbl42:
                // 1 sources

                var2_5 = var14_1.getWidth();
                ** while (true)
            }
            o.d((Object)var14_1);
            var9_7 = var14_1.intValue();
            var14_1 = this.extraTitleView;
            var14_1 = var14_1 != null && (var14_1 = var14_1.getLayoutParams()) != null ? Integer.valueOf(var14_1.width) : null;
            o.d((Object)var14_1);
            if (var14_1.intValue() >= 0) {
                var14_1 = this.extraTitleView;
                if (var14_1 != null && (var14_1 = var14_1.getLayoutParams()) != null) {
                    var2_5 = var14_1.width;
lbl54:
                    // 2 sources

                    while (true) {
                        var14_1 = var2_5;
                        break block20;
                        break;
                    }
                }
lbl57:
                // 3 sources

                while (true) {
                    var14_1 = null;
                    break block20;
                    break;
                }
            }
            ** while ((var14_1 = this.extraTitleView) == null)
lbl61:
            // 1 sources

            var2_5 = var14_1.getWidth();
            ** while (true)
        }
        o.d((Object)var14_1);
        var10_8 = var14_1.intValue();
        var14_1 = this.subTitleDivider;
        var14_1 = var14_1 != null ? Integer.valueOf(var14_1.getWidth()) : null;
        o.d((Object)var14_1);
        var11_9 = var14_1.intValue();
        var14_1 = this.subTitleDivider;
        var14_1 = var14_1 != null ? Integer.valueOf(var14_1.getWidth()) : null;
        o.d((Object)var14_1);
        var3_10 = var14_1.intValue() > 0 ? var1_4 : 0;
        var4_11 = var9_7 > 0 ? var1_4 : 0;
        var14_1 = this.extraTitleDivider;
        var14_1 = var14_1 != null ? Integer.valueOf(var14_1.getWidth()) : null;
        o.d((Object)var14_1);
        var12_12 = var14_1.intValue();
        var14_1 = this.extraTitleDivider;
        var14_1 = var14_1 != null ? Integer.valueOf(var14_1.getWidth()) : null;
        o.d((Object)var14_1);
        var5_13 = var14_1.intValue() > 0 ? var1_4 : 0;
        var13_14 = Math.max(var10_8, 0);
        var6_15 = var10_8 > 0 ? var1_4 : 0;
        var14_1 = this.specialTitleView;
        if (var14_1 != null && var14_1.getVisibility() == 0) {
            var14_1 = this.specialTitleView;
            var14_1 = var14_1 != null ? Integer.valueOf(var14_1.getWidth()) : null;
            o.d((Object)var14_1);
            var2_5 = var14_1.intValue();
        } else {
            var14_1 = this.specialTitleView;
            var2_5 = var7_2;
            if (var14_1 != null) {
                var2_5 = var7_2;
                if (var14_1.getVisibility() == 0) {
                    var2_5 = var1_4;
                }
            }
        }
        var2_5 = var11_9 + var8_6 + var3_10 + var9_7 + var4_11 + var12_12 + var5_13 + var13_14 + var6_15 + var2_5;
        var14_1 = this.subTitleDivider;
        var14_1 = var14_1 != null ? Integer.valueOf(var14_1.getWidth()) : null;
        var15_16 /* !! */  = this.specialTitleView;
        var15_16 /* !! */  = var15_16 /* !! */  != null ? Integer.valueOf(var15_16 /* !! */ .getVisibility()) : null;
        var17_17 = this.specialTitleView;
        if (var17_17 != null) {
            var16_3 = var17_17.getWidth();
        }
        var17_17 = new StringBuilder();
        var17_17.append("getTitleViewsTotalWidthAfterCompress: ");
        var17_17.append(var2_5);
        var17_17.append(" ");
        var17_17.append(var8_6);
        var17_17.append(" ");
        var17_17.append(var14_1);
        var17_17.append(" ");
        var17_17.append(var9_7);
        var17_17.append(" ");
        var17_17.append(var10_8);
        var17_17.append(" ");
        var17_17.append(var15_16 /* !! */ );
        var17_17.append(" ");
        var17_17.append(var16_3);
        var17_17.append(" ");
        var17_17.append(var1_4);
        Log.d((String)"ModuleTextViewHolder", (String)var17_17.toString());
        return var2_5;
    }

    private final void resetViewLayoutParam(View object) {
        if ((object = object != null ? object.getLayoutParams() : null) != null) {
            object.width = -2;
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

    private final void setViewWidthMinZero(TextView textView, View view, int n, int n2) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("setViewWidthMinZero ");
        stringBuilder.append(n);
        stringBuilder.append(" ");
        stringBuilder.append(textView);
        Log.i((String)TAG, (String)stringBuilder.toString());
        if (textView == null) {
            return;
        }
        stringBuilder = textView.getLayoutParams();
        int n3 = n < n2 ? 0 : n;
        ((ViewGroup.LayoutParams)stringBuilder).width = (int)Math.max((double)n3, 0.0);
        if (n < n2) {
            textView.setVisibility(8);
            if (view != null) {
                view.setVisibility(8);
            }
        }
        textView.setLayoutParams((ViewGroup.LayoutParams)stringBuilder);
        textView.requestLayout();
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
                object.setVisibility(8);
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
        if (!TextUtils.isEmpty((CharSequence)this.getTitle())) {
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
        } else {
            object2 = this.focusTitle;
            if (object2 != null) {
                object2.setVisibility(8);
            }
        }
        if (!TextUtils.isEmpty((CharSequence)this.getContent())) {
            object2 = this.contentContainer;
            if (object2 != null) {
                object2.setVisibility(0);
            }
            object2 = this.focusContent;
            if (object2 != null) {
                object2.setVisibility(0);
            }
            object2 = this.focusContent;
            if (object2 != null) {
                object2.setText((CharSequence)Html.fromHtml((String)this.getContent()));
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
                ((LinearLayout.LayoutParams)object2).topMargin = (int)this.getCtx().getResources().getDimension(R.dimen.focus_notify_button_without_icon_margin_start);
            }
            if (bl3 = (object = template.getBaseInfo()) != null ? o.c((Object)((BaseInfo)object).getSetMarginBottom(), (Object)Boolean.TRUE) : false) {
                ((LinearLayout.LayoutParams)object2).bottomMargin = (int)this.getCtx().getResources().getDimension(R.dimen.focus_notify_button_without_icon_margin_start);
            }
            if ((object = this.titleContainer) != null) {
                object.setLayoutParams((ViewGroup.LayoutParams)object2);
            }
        }
        if (!TextUtils.isEmpty((CharSequence)this.getSubtitle())) {
            object2 = this.subTitleView;
            if (object2 != null) {
                object2.setVisibility(0);
            }
            object2 = this.subTitleView;
            if (object2 != null) {
                object2.setText((CharSequence)Html.fromHtml((String)this.getSubtitle()));
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
        if (!TextUtils.isEmpty((CharSequence)this.getSubContent())) {
            object2 = this.subContentView;
            if (object2 != null) {
                object2.setVisibility(0);
            }
            object2 = this.subContentView;
            if (object2 != null) {
                object2.setText((CharSequence)Html.fromHtml((String)this.getSubContent()));
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
        if (!TextUtils.isEmpty((CharSequence)this.getExtraTitle())) {
            object2 = this.extraTitleView;
            if (object2 != null) {
                object2.setVisibility(0);
            }
            object2 = this.extraTitleView;
            if (object2 != null) {
                object2.setText((CharSequence)Html.fromHtml((String)this.getExtraTitle()));
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
        object2 = this.getSpecialTitle();
        object = new StringBuilder();
        ((StringBuilder)object).append("specialTitle ");
        ((StringBuilder)object).append((String)object2);
        Log.e((String)TAG, (String)((StringBuilder)object).toString());
        if (!TextUtils.isEmpty((CharSequence)this.getSpecialTitle())) {
            object2 = this.getSpecialTitle();
            object = new StringBuilder();
            ((StringBuilder)object).append("specialTitle1 ");
            ((StringBuilder)object).append((String)object2);
            Log.e((String)TAG, (String)((StringBuilder)object).toString());
            object2 = this.specialTitleView;
            if (object2 != null) {
                object2.setVisibility(0);
            }
            object2 = this.specialTitleView;
            if (object2 != null) {
                object2.setText((CharSequence)Html.fromHtml((String)this.getSpecialTitle()));
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
            Log.e((String)TAG, (String)((StringBuilder)object2).toString());
            object2 = this.specialTitleView;
            if (object2 != null) {
                object2.setVisibility(8);
            }
        }
        this.showFocusIcon(template, statusBarNotification);
        this.setTextContainerBackground(template);
        this.notifyDataChanged();
    }

    public final boolean getIsland() {
        return this.island;
    }

    @Override
    public void initView(String string) {
        o.g((Object)string, (String)"module");
        super.initView(string);
        if (o.c((Object)string, (Object)"moduleText1")) {
            this.setView(LayoutInflater.from((Context)this.getContext(this.island)).inflate(R.layout.focus_notification_module_text_1, this.getRootView()));
        } else {
            this.setView(LayoutInflater.from((Context)this.getContext(this.island)).inflate(R.layout.focus_notification_module_text_2, this.getRootView()));
        }
        string = this.getView();
        Object var2_2 = null;
        string = string != null ? (TextView)string.findViewById(R.id.focus_title) : null;
        this.focusTitle = string;
        string = this.getView();
        string = string != null ? (LinearLayout)string.findViewById(R.id.content_container) : null;
        this.contentContainer = string;
        string = this.getView();
        string = string != null ? (TextView)string.findViewById(R.id.focus_content) : null;
        this.focusContent = string;
        string = this.getView();
        string = string != null ? (LinearLayout)string.findViewById(R.id.title_container) : null;
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
        string = var2_2;
        if (view != null) {
            string = (TextView)view.findViewById(R.id.focus_function_icon_divider);
        }
        this.functionIconDivider = string;
        this.registerCompressChanged(new a(this){
            final ModuleTextViewHolder this$0;
            {
                this.this$0 = moduleTextViewHolder;
                super(0);
            }

            public final void invoke() {
                ModuleTextViewHolder.access$checkAndCompressTitleViews(this.this$0);
                ModuleTextViewHolder.access$checkAndCompressContentViews(this.this$0);
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
        this.initTextAndColor(template.getBaseInfo());
        this.bind(template, statusBarNotification);
    }
}
