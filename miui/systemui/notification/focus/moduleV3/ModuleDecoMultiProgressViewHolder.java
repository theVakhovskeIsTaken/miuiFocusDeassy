/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.annotation.SuppressLint
 *  android.content.Context
 *  android.graphics.Color
 *  android.graphics.drawable.Drawable
 *  android.service.notification.StatusBarNotification
 *  android.text.Html
 *  android.text.TextUtils
 *  android.util.Log
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.ViewGroup
 *  android.widget.ProgressBar
 *  android.widget.TextView$BufferType
 *  com.android.systemui.miui.notification.R$drawable
 *  com.android.systemui.miui.notification.R$id
 *  com.android.systemui.miui.notification.R$layout
 *  kotlin.jvm.internal.o
 *  miuix.colorful.texteffect.TextChangeHelper
 *  miuix.colorful.texteffect.TextChangeProcessor
 *  miuix.colorful.texteffect.TimerTextEffectView
 */
package miui.systemui.notification.focus.moduleV3;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.service.notification.StatusBarNotification;
import android.text.Html;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.android.systemui.miui.notification.R;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.o;
import miui.systemui.notification.focus.model.MultiProgressInfo;
import miui.systemui.notification.focus.model.Template;
import miui.systemui.notification.focus.moduleV3.ModuleViewHolder;
import miui.systemui.notification.focus.views.NotificationProgressDrawable;
import miuix.colorful.texteffect.TextChangeHelper;
import miuix.colorful.texteffect.TextChangeProcessor;
import miuix.colorful.texteffect.TimerTextEffectView;

public final class ModuleDecoMultiProgressViewHolder
extends ModuleViewHolder {
    private View container;
    private TimerTextEffectView focusTitle;
    private ProgressBar progressBar;
    private View topContainer;

    public ModuleDecoMultiProgressViewHolder(Context context, Context context2, ViewGroup viewGroup, boolean bl) {
        o.g((Object)context, (String)"ctx");
        o.g((Object)context2, (String)"sysuiCtx");
        o.g((Object)viewGroup, (String)"rootView");
        super(context, context2, viewGroup, bl);
    }

    private final List<NotificationProgressDrawable.Part> convertToDrawableParts(int n, int n2, String object) {
        ArrayList<NotificationProgressDrawable.Part> arrayList = new ArrayList<NotificationProgressDrawable.Part>();
        int n3 = 100;
        if (n2 != 0) {
            n3 = 100 / n2;
        }
        int n4 = n / n3;
        try {
            object = Color.parseColor((String)object);
        }
        catch (Exception exception) {
            object = null;
        }
        int n5 = object != null ? (Integer)object : 0;
        if (n2 == 0) {
            float f2 = n;
            arrayList.add(new NotificationProgressDrawable.Segment((float)n3 * 0.01f, n5, true, f2 * 0.01f));
            return arrayList;
        }
        for (int i = 0; i < n2; ++i) {
            float f3 = i == n4 ? (float)(n - i * n3) * 0.01f : 0.0f;
            float f4 = n3;
            boolean bl = i >= n4;
            arrayList.add(new NotificationProgressDrawable.Segment(f4 * 0.01f, n5, bl, f3));
        }
        object = new StringBuilder();
        ((StringBuilder)object).append(" get Parts=");
        ((StringBuilder)object).append(arrayList);
        Log.d((String)"ModuleViewHolder", (String)((StringBuilder)object).toString());
        return arrayList;
    }

    @SuppressLint(value={"UseCompatLoadingForDrawables"})
    private final void showMultiProgress(Template object, StatusBarNotification statusBarNotification) {
        if ((object = ((Template)object).getMultiProgressInfo()) != null) {
            if (((MultiProgressInfo)object).getProgress() >= 0 && ((MultiProgressInfo)object).getPoints() >= 0) {
                if (((MultiProgressInfo)object).getProgress() > 100) {
                    Log.w((String)"ModuleViewHolder", (String)" multiProgressInfo progress > 100, reduced to 100");
                    ((MultiProgressInfo)object).setProgress(100);
                } else if (((MultiProgressInfo)object).getPoints() > 4) {
                    Log.w((String)"ModuleViewHolder", (String)" multiProgressInfo points > 4, limited to 4");
                    ((MultiProgressInfo)object).setPoints(4);
                }
                statusBarNotification = this.progressBar;
                if (statusBarNotification != null) {
                    Drawable drawable2 = this.getCtx().getDrawable(R.drawable.notification_progress);
                    o.e((Object)drawable2, (String)"null cannot be cast to non-null type miui.systemui.notification.focus.views.NotificationProgressDrawable");
                    drawable2 = (NotificationProgressDrawable)drawable2;
                    drawable2.setParts(this.convertToDrawableParts(((MultiProgressInfo)object).getProgress(), ((MultiProgressInfo)object).getPoints(), ((MultiProgressInfo)object).getColor()));
                    statusBarNotification.setProgress(((MultiProgressInfo)object).getProgress());
                    statusBarNotification.setMax(100);
                    statusBarNotification.setVisibility(0);
                    statusBarNotification.setProgressDrawable(drawable2);
                }
            } else {
                Log.e((String)"ModuleViewHolder", (String)" multiProgressInfo empty or values are negative !!!");
            }
        }
    }

    @Override
    public void bind(Template template, StatusBarNotification statusBarNotification) {
        o.g((Object)template, (String)"template");
        o.g((Object)statusBarNotification, (String)"sbn");
        super.bind(template, statusBarNotification);
        this.initTextAndColor(template.getMultiProgressInfo());
        Object object = this.topContainer;
        if (object != null) {
            object.setVisibility(0);
        }
        object = this.container;
        if (object != null) {
            object.setVisibility(0);
        }
        if (!TextUtils.isEmpty((CharSequence)this.getTitle())) {
            object = this.focusTitle;
            if (object != null) {
                object.setVisibility(0);
            }
            object = this.focusTitle;
            if (object != null) {
                object.setText((CharSequence)Html.fromHtml((String)this.getTitle()), TextView.BufferType.SPANNABLE);
            }
            if ((object = this.getTitleColor()) != null) {
                int n = ((Number)object).intValue();
                object = this.focusTitle;
                if (object != null) {
                    object.updateTextWithNewAppearance((CharSequence)Html.fromHtml((String)this.getTitle()), Integer.valueOf(n));
                }
            }
        } else {
            object = this.focusTitle;
            if (object != null) {
                object.setVisibility(8);
            }
        }
        this.showMultiProgress(template, statusBarNotification);
    }

    @Override
    public void initView(String string) {
        o.g((Object)string, (String)"module");
        super.initView(string);
        Object var2_2 = null;
        this.setView(LayoutInflater.from((Context)ModuleViewHolder.getContext$default(this, false, 1, null)).inflate(R.layout.focus_notification_module_multi_progress, this.getRootView()));
        string = this.getView();
        string = string != null ? string.findViewById(R.id.focus_container_module_multi_progress) : null;
        this.topContainer = string;
        string = this.getView();
        string = string != null ? string.findViewById(R.id.focus_title_container) : null;
        this.container = string;
        string = this.getView();
        string = string != null ? (TimerTextEffectView)string.findViewById(R.id.focus_title) : null;
        this.focusTitle = string;
        View view = this.getView();
        string = var2_2;
        if (view != null) {
            string = (ProgressBar)view.findViewById(R.id.multi_progress);
        }
        this.progressBar = string;
        string = this.focusTitle;
        if (string != null) {
            string.setTextChangeProcessor((TextChangeProcessor)new TextChangeHelper());
        }
        if ((string = this.focusTitle) != null) {
            string.setEnableEffectWithInit(false);
        }
    }

    @Override
    public void updatePartial(Template template, StatusBarNotification statusBarNotification) {
        o.g((Object)template, (String)"template");
        o.g((Object)statusBarNotification, (String)"sbn");
        super.updatePartial(template, statusBarNotification);
        this.initTextAndColor(template.getMultiProgressInfo());
        this.bind(template, statusBarNotification);
    }
}
