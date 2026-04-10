/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  G0.s
 *  K0.d
 *  U0.o
 *  android.annotation.SuppressLint
 *  android.content.Context
 *  android.graphics.Color
 *  android.graphics.Typeface
 *  android.graphics.Typeface$Builder
 *  android.os.Bundle
 *  android.os.SystemProperties
 *  android.util.Log
 *  android.view.View
 *  android.view.ViewGroup
 *  android.widget.TextView
 *  androidx.core.graphics.ColorUtils
 *  com.android.systemui.plugins.miui.dynamicisland.DynamicIslandData
 *  kotlin.jvm.internal.o
 *  miui.systemui.animation.FolmeKt
 *  miui.systemui.util.Assert
 *  miui.systemui.util.CommonUtils
 *  miuix.animation.Folme$ObjectFolmeImpl
 *  miuix.animation.FolmeObject
 *  miuix.colorful.texteffect.TimerTextEffectView
 */
package miui.systemui.dynamicisland.module;

import G0.s;
import K0.d;
import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.SystemProperties;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.core.graphics.ColorUtils;
import com.android.systemui.plugins.miui.dynamicisland.DynamicIslandData;
import kotlin.jvm.internal.o;
import miui.systemui.animation.FolmeKt;
import miui.systemui.dynamicisland.R;
import miui.systemui.dynamicisland.model.IslandTemplate;
import miui.systemui.dynamicisland.model.TextInfo;
import miui.systemui.util.Assert;
import miui.systemui.util.CommonUtils;
import miuix.animation.Folme;
import miuix.animation.FolmeObject;
import miuix.colorful.texteffect.TimerTextEffectView;

public class BaseIslandModuleViewHolder
implements FolmeObject {
    public static final Companion Companion;
    private static final Typeface FIXED_FONT;
    private static final String FONT_MI_SANS;
    public static final float MINI_VISIBLE_CHANGE = 0.01f;
    private static final String TAG = "BaseIslandModuleViewHolder";
    private final FolmeObject $$delegate_0;
    private Bundle bitmapBundle;
    private final Context context;
    public DynamicIslandData dynamicIslandData;
    private final U0.o emitEvent;
    private String module;
    private final ViewGroup rootView;
    private View view;

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    static {
        String string;
        Typeface.Builder builder = null;
        Companion = new Object(null){
            {
                this();
            }
        };
        FONT_MI_SANS = string = SystemProperties.get((String)"ro.miui.ui.font.mi_font_path", (String)"/system/fonts/MiSansVF.ttf");
        try {
            Typeface.Builder builder2 = new Typeface.Builder(string);
            builder = builder2 = builder2.setFontVariationSettings("'wght' 450").build();
        }
        catch (Exception exception) {}
        FIXED_FONT = builder;
    }

    public BaseIslandModuleViewHolder(Context context, ViewGroup viewGroup, U0.o o2) {
        o.g((Object)context, (String)"context");
        o.g((Object)viewGroup, (String)"rootView");
        o.g((Object)o2, (String)"emitEvent");
        this.context = context;
        this.rootView = viewGroup;
        this.emitEvent = o2;
        this.$$delegate_0 = FolmeKt.FolmeObject();
    }

    public static /* synthetic */ Object initLayout$suspendImpl(BaseIslandModuleViewHolder baseIslandModuleViewHolder, View view, String string, d d2) {
        baseIslandModuleViewHolder.view = view;
        baseIslandModuleViewHolder.module = string;
        return s.a;
    }

    private final void updateBundle(DynamicIslandData object) {
        object = object != null && (object = object.getExtras()) != null ? object.getBundle("miui.focus.pics") : null;
        this.bitmapBundle = object;
    }

    public void bind(IslandTemplate islandTemplate, DynamicIslandData dynamicIslandData) {
        o.g((Object)islandTemplate, (String)"template");
        if (dynamicIslandData != null) {
            this.setDynamicIslandData(dynamicIslandData);
        }
        this.updateBundle(dynamicIslandData);
    }

    public void diff(IslandTemplate islandTemplate, DynamicIslandData dynamicIslandData) {
        o.g((Object)islandTemplate, (String)"template");
    }

    public Folme.ObjectFolmeImpl folme() {
        return this.$$delegate_0.folme();
    }

    public final Bundle getBitmapBundle() {
        return this.bitmapBundle;
    }

    public final Context getContext() {
        return this.context;
    }

    public final DynamicIslandData getDynamicIslandData() {
        DynamicIslandData dynamicIslandData = this.dynamicIslandData;
        if (dynamicIslandData != null) {
            return dynamicIslandData;
        }
        o.w((String)"dynamicIslandData");
        return null;
    }

    public final U0.o getEmitEvent() {
        return this.emitEvent;
    }

    public final String getModule() {
        return this.module;
    }

    public final ViewGroup getRootView() {
        return this.rootView;
    }

    public final int getTextViewWidth(TextView textView, String string) {
        if (textView != null && string != null) {
            int n = (int)textView.getPaint().measureText(string);
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("getTextViewWidth: ");
            stringBuilder.append(n);
            stringBuilder.append(" ");
            stringBuilder.append(textView);
            stringBuilder.append(" ");
            stringBuilder.append(string);
            Log.e((String)TAG, (String)stringBuilder.toString());
            return (int)textView.getPaint().measureText(string);
        }
        return 0;
    }

    public final View getView() {
        return this.view;
    }

    public Object initLayout(View view, String string, d d2) {
        return BaseIslandModuleViewHolder.initLayout$suspendImpl(this, view, string, d2);
    }

    public void initView(String string) {
        o.g((Object)string, (String)"module");
        Assert.isMainThread();
    }

    public void onDetach() {
    }

    public void onHidden() {
    }

    public void onShow() {
    }

    public final void setBitmapBundle(Bundle bundle) {
        this.bitmapBundle = bundle;
    }

    public final void setContentHighlightColor(IslandTemplate object, Boolean bl, TimerTextEffectView timerTextEffectView, String string) {
        o.g((Object)object, (String)"template");
        Log.e((String)TAG, (String)"setContentHighlightColor");
        object = ((IslandTemplate)object).getHighlightColor() != null ? Integer.valueOf(ColorUtils.setAlphaComponent((int)Color.parseColor((String)((IslandTemplate)object).getHighlightColor()), (int)((int)((double)Color.alpha((int)Color.parseColor((String)((IslandTemplate)object).getHighlightColor())) * 0.8)))) : null;
        if (timerTextEffectView != null) {
            int n = object != null && o.c((Object)bl, (Object)Boolean.TRUE) ? ((Integer)object).intValue() : this.context.getResources().getColor(R.color.content_color);
            timerTextEffectView.updateTextWithNewAppearance((CharSequence)string, Integer.valueOf(n));
        }
    }

    public final void setDynamicIslandData(DynamicIslandData dynamicIslandData) {
        o.g((Object)dynamicIslandData, (String)"<set-?>");
        this.dynamicIslandData = dynamicIslandData;
    }

    public final s setFixedFont(TextView textView) {
        Typeface typeface = FIXED_FONT;
        if (typeface != null) {
            if (textView != null) {
                textView.setTypeface(typeface);
            }
            textView = s.a;
        } else {
            textView = null;
        }
        return textView;
    }

    public void setFolmeImpl(Folme.ObjectFolmeImpl objectFolmeImpl) {
        this.$$delegate_0.setFolmeImpl(objectFolmeImpl);
    }

    public final void setFont(TextInfo textInfo, TextView textView) {
        Boolean bl = textInfo != null ? textInfo.getNarrowFont() : null;
        if (bl != null) {
            if (o.c((Object)textInfo.getNarrowFont(), (Object)Boolean.TRUE)) {
                textInfo = Typeface.create((String)"misans-condensed", (int)0);
                if (textView != null) {
                    textView.setTypeface((Typeface)textInfo);
                }
                if (textView != null) {
                    textView.setFontVariationSettings("'wght' 450, 'wdth' 30");
                }
            } else {
                textInfo = Typeface.create((String)"mipro-demibold", (int)0);
                if (textView != null) {
                    textView.setTypeface((Typeface)textInfo);
                }
            }
        }
    }

    public final void setModule(String string) {
        this.module = string;
    }

    @SuppressLint(value={"UseCompatLoadingForDrawables"})
    public final void setTextShade(View view) {
        if (CommonUtils.isLayoutRtl((Context)this.context)) {
            if (view != null) {
                view.setBackground(this.context.getResources().getDrawable(R.drawable.dynamic_island_shade_rtl));
            }
        } else if (view != null) {
            view.setBackground(this.context.getResources().getDrawable(R.drawable.dynamic_island_shade));
        }
    }

    public final void setTitleHighlightColor(IslandTemplate islandTemplate, Boolean bl, TimerTextEffectView timerTextEffectView, String string) {
        o.g((Object)islandTemplate, (String)"template");
        Log.e((String)TAG, (String)"setTitleHighlightColor");
        if (timerTextEffectView != null) {
            int n = islandTemplate.getHighlightColor() != null && o.c((Object)bl, (Object)Boolean.TRUE) ? Color.parseColor((String)islandTemplate.getHighlightColor()) : -1;
            timerTextEffectView.updateTextWithNewAppearance((CharSequence)string, Integer.valueOf(n));
        }
    }

    public final void setView(View view) {
        this.view = view;
    }

    public final void setupTimer(DynamicIslandData dynamicIslandData, Integer n, Long l, Long l2, Long l3) {
        if (dynamicIslandData != null && (dynamicIslandData = dynamicIslandData.getExtras()) != null) {
            if (n != null) {
                dynamicIslandData.putInt("timerType", ((Number)n).intValue());
            }
            if (l != null) {
                dynamicIslandData.putLong("timerWhen", ((Number)l).longValue());
            }
            if (l2 != null) {
                dynamicIslandData.putLong("timerTotal", ((Number)l2).longValue());
            }
            if (l3 != null) {
                dynamicIslandData.putLong("timerSystemCurrent", ((Number)l3).longValue());
            }
        }
    }

    public void updatePartial(IslandTemplate islandTemplate, DynamicIslandData dynamicIslandData) {
        o.g((Object)islandTemplate, (String)"template");
        this.updateBundle(dynamicIslandData);
    }

    public void updateWidth(int n) {
    }
}
