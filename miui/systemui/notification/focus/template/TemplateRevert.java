/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.Notification$Action
 *  android.content.Context
 *  android.os.SystemClock
 *  android.service.notification.StatusBarNotification
 *  android.text.TextUtils
 *  android.util.Log
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.widget.Chronometer
 *  android.widget.TextView
 *  com.android.systemui.miui.notification.R$id
 *  com.android.systemui.miui.notification.R$layout
 *  com.android.systemui.plugins.miui.notification.FocusNotificationContent
 *  kotlin.jvm.internal.o
 *  miui.systemui.util.ContextUtils
 *  org.json.JSONObject
 */
package miui.systemui.notification.focus.template;

import android.app.Notification;
import android.content.Context;
import android.os.SystemClock;
import android.service.notification.StatusBarNotification;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Chronometer;
import android.widget.TextView;
import com.android.systemui.miui.notification.R;
import com.android.systemui.plugins.miui.notification.FocusNotificationContent;
import kotlin.jvm.internal.o;
import miui.systemui.notification.focus.FocusParamsException;
import miui.systemui.notification.focus.template.FocusTemplate;
import miui.systemui.notification.focus.template.SceneName;
import miui.systemui.util.ContextUtils;
import org.json.JSONObject;

@SceneName(sceneNames={"verifyCode", "recorder", "alarm", "timer", "templateRevertScene"})
public final class TemplateRevert
extends FocusTemplate {
    private final String TAG;
    private final int TYPE_HIDE_TIMER;
    private long timerCurrent;
    private long timerSystemCurrent;
    private long timerTotal;
    private final int timerType;
    private long timerWhen;

    public TemplateRevert(JSONObject jSONObject) {
        long l;
        int n;
        o.g((Object)jSONObject, (String)"param");
        super(jSONObject);
        this.TAG = "FocusPlugin_TemplateRevert";
        this.timerType = n = jSONObject.optInt("timerType", this.TYPE_HIDE_TIMER);
        this.timerWhen = jSONObject.optLong("timerWhen", System.currentTimeMillis());
        this.timerTotal = jSONObject.optLong("timerTotal", 0L);
        this.timerSystemCurrent = l = jSONObject.optLong("timerSystemCurrent", System.currentTimeMillis());
        l = n > 0 ? (l -= this.timerWhen) : this.timerWhen - l;
        this.timerCurrent = l;
        if (TextUtils.isEmpty((CharSequence)this.getTitle()) && n == this.TYPE_HIDE_TIMER) {
            throw new FocusParamsException("title is empty");
        }
    }

    private final void adaptTimerDelay() {
        Object object = this.getActionBundle();
        object = object != null ? (Notification.Action)object.getParcelable("miui.focus.action_1") : null;
        if (object != null && o.c((Object)object.getExtras().getString("icon_name"), (Object)"action_pause")) {
            this.calculateTimer();
        }
    }

    private final void calculateTimer() {
        long l;
        long l2 = System.currentTimeMillis();
        if (l2 - (l = this.timerSystemCurrent) > 1000L) {
            CharSequence charSequence = this.TAG;
            CharSequence charSequence2 = new StringBuilder();
            charSequence2.append("Timer delay too large, current:");
            charSequence2.append(l2);
            charSequence2.append(" timerSystemCurrent:");
            charSequence2.append(l);
            Log.d((String)charSequence, (String)charSequence2.toString());
            this.timerSystemCurrent = l2;
            l2 = this.timerType > 0 ? (l2 -= this.timerWhen) : this.timerWhen - l2;
            this.timerCurrent = l2;
            charSequence2 = this.TAG;
            charSequence = new StringBuilder();
            ((StringBuilder)charSequence).append("normalRemoteViewsBuild: calculateTimer :timerCurrent:");
            ((StringBuilder)charSequence).append(l2);
            Log.d((String)charSequence2, (String)((StringBuilder)charSequence).toString());
        }
    }

    private final void normalViewsBuild(Context object, StatusBarNotification statusBarNotification, boolean bl, boolean bl2, boolean bl3, boolean bl4, View view) {
        this.resetViewState(view);
        this.setTextVisibleAndText(view);
        int n = R.id.chronometer;
        Chronometer chronometer = (Chronometer)view.findViewById(n);
        TextView textView = (TextView)view.findViewById(R.id.focus_title);
        TextView textView2 = (TextView)view.findViewById(R.id.focus_content);
        TextView textView3 = (TextView)view.findViewById(R.id.focus_desc);
        if (!o.c((Object)this.getTitle(), (Object)"")) {
            if (chronometer != null) {
                chronometer.setVisibility(8);
            }
            if (textView != null) {
                textView.setVisibility(0);
            }
        } else {
            if (chronometer != null) {
                chronometer.setVisibility(0);
            }
            if (textView != null) {
                textView.setVisibility(8);
            }
        }
        String string = this.TAG;
        long l = this.timerCurrent;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("normalRemoteViewsBuild: :timerCurrent:");
        stringBuilder.append(l);
        Log.d((String)string, (String)stringBuilder.toString());
        if (this.timerType != this.TYPE_HIDE_TIMER) {
            statusBarNotification.getNotification().extras.putInt("timerType", this.timerType);
            statusBarNotification.getNotification().extras.putLong("timerWhen", this.timerWhen);
            statusBarNotification.getNotification().extras.putLong("timerCurrent", this.timerCurrent);
            statusBarNotification.getNotification().extras.putLong("timerTotal", this.timerTotal);
            statusBarNotification.getNotification().extras.putLong("timerSystemCurrent", this.timerSystemCurrent);
            if (chronometer != null) {
                boolean bl5 = this.timerType < 0;
                chronometer.setCountDown(bl5);
            }
            if (chronometer != null) {
                chronometer.setBase(SystemClock.elapsedRealtime() + this.timerWhen - this.timerSystemCurrent);
            }
            statusBarNotification.getNotification().extras.putBoolean("miui.focus.backProgressEnable", false);
            statusBarNotification.getNotification().extras.putInt("miui.focus.chronometerId", n);
            statusBarNotification.getNotification().extras.putInt("miui.focus.action_2", R.id.focus_button_icon2);
            statusBarNotification.getNotification().extras.putInt("miui.focus.action_1", R.id.focus_button_icon1);
        }
        n = R.id.focus_button_icon1;
        stringBuilder = this.getActionBundle();
        stringBuilder = stringBuilder != null ? (Notification.Action)stringBuilder.getParcelable("miui.focus.action_1") : null;
        this.setActionData(view, n, (Notification.Action)stringBuilder, bl2, bl3);
        n = R.id.focus_button_icon2;
        stringBuilder = this.getActionBundle();
        stringBuilder = stringBuilder != null ? (Notification.Action)stringBuilder.getParcelable("miui.focus.action_2") : null;
        this.setActionData(view, n, (Notification.Action)stringBuilder, bl2, bl3);
        FocusTemplate.setRemoteViewsBackground$default(this, (Context)object, view, statusBarNotification, bl, bl4, false, 32, null);
        if (this.isSolidBackground() && !this.isBgPicDownloadFail()) {
            if (this.getTitleColor() != null && textView != null) {
                textView.setTextColor(this.getTitleColor().intValue());
            }
            if ((object = this.getContentColor()) != null) {
                n = ((Number)object).intValue();
                if (textView2 != null) {
                    textView2.setTextColor(n);
                }
            }
            if ((object = this.getDescColor()) != null) {
                n = ((Number)object).intValue();
                if (textView3 != null) {
                    textView3.setTextColor(n);
                }
                if (this.isNotHaveContent() && textView2 != null) {
                    textView2.setTextColor(n);
                }
            }
        }
        this.resetTemplateState();
    }

    public static /* synthetic */ void normalViewsBuild$default(TemplateRevert templateRevert, Context context, StatusBarNotification statusBarNotification, boolean bl, boolean bl2, boolean bl3, boolean bl4, View view, int n, Object object) {
        if ((n & 8) != 0) {
            bl2 = false;
        }
        if ((n & 0x10) != 0) {
            bl3 = false;
        }
        if ((n & 0x20) != 0) {
            bl4 = false;
        }
        templateRevert.normalViewsBuild(context, statusBarNotification, bl, bl2, bl3, bl4, view);
    }

    @Override
    public void buildDecoLandViews(Context context, StatusBarNotification statusBarNotification, FocusNotificationContent focusNotificationContent) {
        View view;
        View view2;
        o.g((Object)context, (String)"ctx");
        o.g((Object)statusBarNotification, (String)"sbn");
        o.g((Object)focusNotificationContent, (String)"focusContent");
        this.adaptTimerDelay();
        View view3 = view2 = focusNotificationContent.getDecoLand();
        if (view2 == null) {
            view3 = LayoutInflater.from((Context)ContextUtils.INSTANCE.getDayContext(context)).inflate(R.layout.focus_notification_template_revert_deco_land, null);
        }
        view2 = view = focusNotificationContent.getDecoLandDark();
        if (view == null) {
            view2 = LayoutInflater.from((Context)ContextUtils.getNightContext$default((ContextUtils)ContextUtils.INSTANCE, (Context)context, (boolean)false, (int)2, null)).inflate(R.layout.focus_notification_template_revert_deco_land, null);
        }
        o.d((Object)view3);
        TemplateRevert.normalViewsBuild$default(this, context, statusBarNotification, true, true, false, false, view3, 48, null);
        o.d((Object)view2);
        TemplateRevert.normalViewsBuild$default(this, context, statusBarNotification, true, true, false, false, view2, 48, null);
        focusNotificationContent.setDecoLand(view3);
        focusNotificationContent.setDecoLandDark(view2);
    }

    @Override
    public void buildDecoPortViews(Context context, StatusBarNotification statusBarNotification, FocusNotificationContent focusNotificationContent) {
        View view;
        View view2;
        o.g((Object)context, (String)"ctx");
        o.g((Object)statusBarNotification, (String)"sbn");
        o.g((Object)focusNotificationContent, (String)"focusContent");
        this.adaptTimerDelay();
        View view3 = view2 = focusNotificationContent.getDeco();
        if (view2 == null) {
            view3 = LayoutInflater.from((Context)ContextUtils.INSTANCE.getDayContext(context)).inflate(R.layout.focus_notification_template_revert_deco_port, null);
        }
        view2 = view = focusNotificationContent.getDecoDark();
        if (view == null) {
            view2 = LayoutInflater.from((Context)ContextUtils.getNightContext$default((ContextUtils)ContextUtils.INSTANCE, (Context)context, (boolean)false, (int)2, null)).inflate(R.layout.focus_notification_template_revert_deco_port, null);
        }
        o.d((Object)view3);
        TemplateRevert.normalViewsBuild$default(this, context, statusBarNotification, true, true, true, false, view3, 32, null);
        o.d((Object)view2);
        TemplateRevert.normalViewsBuild$default(this, context, statusBarNotification, true, true, true, false, view2, 32, null);
        focusNotificationContent.setDeco(view3);
        focusNotificationContent.setDecoDark(view2);
    }

    @Override
    public void buildNormalViews(Context context, StatusBarNotification statusBarNotification, FocusNotificationContent focusNotificationContent) {
        View view;
        View view2;
        View view3;
        o.g((Object)context, (String)"ctx");
        o.g((Object)statusBarNotification, (String)"sbn");
        o.g((Object)focusNotificationContent, (String)"focusContent");
        this.adaptTimerDelay();
        ContextUtils contextUtils = ContextUtils.INSTANCE;
        Context context2 = contextUtils.getDayContext(context);
        Context context3 = ContextUtils.getNightContext$default((ContextUtils)contextUtils, (Context)context, (boolean)false, (int)2, null);
        View view4 = view3 = focusNotificationContent.getFocusNotification();
        if (view3 == null) {
            view4 = LayoutInflater.from((Context)context2).inflate(R.layout.focus_notification_template_revert, null);
        }
        view3 = view2 = focusNotificationContent.getFocusNotificationDark();
        if (view2 == null) {
            view3 = LayoutInflater.from((Context)context3).inflate(R.layout.focus_notification_template_revert, null);
        }
        view2 = view = focusNotificationContent.getFocusNotificationModal();
        if (view == null) {
            view2 = LayoutInflater.from((Context)context2).inflate(R.layout.focus_notification_template_revert, null);
            view2.setTag(R.id.dynamic_island_modal_tag, (Object)Boolean.TRUE);
        }
        context2 = focusNotificationContent.getFocusNotificationDarkModal();
        view = context2;
        if (context2 == null) {
            view = LayoutInflater.from((Context)context3).inflate(R.layout.focus_notification_template_revert, null);
            view.setTag(R.id.dynamic_island_modal_tag, (Object)Boolean.TRUE);
        }
        Context context4 = contextUtils.getNightContext(context, true);
        contextUtils = focusNotificationContent.getIslandExpandedView();
        context2 = contextUtils;
        if (contextUtils == null) {
            context2 = LayoutInflater.from((Context)context4).inflate(R.layout.focus_notification_template_revert, null);
        }
        context3 = focusNotificationContent.getIslandExpandedViewFake();
        contextUtils = context3;
        if (context3 == null) {
            contextUtils = LayoutInflater.from((Context)context4).inflate(R.layout.focus_notification_template_revert, null);
        }
        o.d((Object)view4);
        TemplateRevert.normalViewsBuild$default(this, context, statusBarNotification, false, false, false, false, view4, 56, null);
        o.d((Object)view3);
        TemplateRevert.normalViewsBuild$default(this, context, statusBarNotification, false, false, false, false, view3, 56, null);
        o.d((Object)view2);
        TemplateRevert.normalViewsBuild$default(this, context, statusBarNotification, false, false, false, false, view2, 56, null);
        o.d((Object)view);
        TemplateRevert.normalViewsBuild$default(this, context, statusBarNotification, false, false, false, false, view, 56, null);
        o.d((Object)context2);
        TemplateRevert.normalViewsBuild$default(this, context, statusBarNotification, false, false, false, true, (View)context2, 24, null);
        o.d((Object)contextUtils);
        TemplateRevert.normalViewsBuild$default(this, context, statusBarNotification, false, false, false, true, (View)contextUtils, 24, null);
        focusNotificationContent.setFocusNotification(view4);
        focusNotificationContent.setFocusNotificationDark(view3);
        focusNotificationContent.setFocusNotificationModal(view2);
        focusNotificationContent.setFocusNotificationDarkModal(view);
        focusNotificationContent.setIslandExpandedView((View)context2);
        focusNotificationContent.setIslandExpandedViewFake((View)contextUtils);
        statusBarNotification.getNotification().extras.putBoolean("miui.focus.isFocus", true);
    }

    @Override
    public void buildTinyViews(Context context, StatusBarNotification statusBarNotification, FocusNotificationContent focusNotificationContent) {
        View view;
        View view2;
        View view3;
        o.g((Object)context, (String)"ctx");
        o.g((Object)statusBarNotification, (String)"sbn");
        o.g((Object)focusNotificationContent, (String)"focusContent");
        this.adaptTimerDelay();
        ContextUtils contextUtils = ContextUtils.INSTANCE;
        Context context2 = contextUtils.getDayContext(context);
        Context context3 = ContextUtils.getNightContext$default((ContextUtils)contextUtils, (Context)context, (boolean)false, (int)2, null);
        View view4 = focusNotificationContent.getTinyView();
        contextUtils = view4;
        if (view4 == null) {
            contextUtils = LayoutInflater.from((Context)context2).inflate(R.layout.focus_notification_template_revert_tiny, null);
        }
        view4 = view3 = focusNotificationContent.getTinyKeyguardView();
        if (view3 == null) {
            view4 = LayoutInflater.from((Context)context2).inflate(R.layout.focus_notification_template_revert_tiny, null);
        }
        view3 = view2 = focusNotificationContent.getTinyViewDark();
        if (view2 == null) {
            view3 = LayoutInflater.from((Context)context3).inflate(R.layout.focus_notification_template_revert_tiny, null);
        }
        view2 = view = focusNotificationContent.getTinyViewModal();
        if (view == null) {
            view2 = LayoutInflater.from((Context)context2).inflate(R.layout.focus_notification_template_revert_tiny, null);
        }
        context2 = focusNotificationContent.getTinyViewDarkModal();
        view = context2;
        if (context2 == null) {
            view = LayoutInflater.from((Context)context3).inflate(R.layout.focus_notification_template_revert_tiny, null);
        }
        View view5 = focusNotificationContent.getTinyViewKeyguardDark();
        context2 = view5;
        if (view5 == null) {
            context2 = LayoutInflater.from((Context)context3).inflate(R.layout.focus_notification_template_revert_tiny, null);
        }
        o.d((Object)contextUtils);
        TemplateRevert.normalViewsBuild$default(this, context, statusBarNotification, true, false, false, false, (View)contextUtils, 56, null);
        o.d((Object)view4);
        TemplateRevert.normalViewsBuild$default(this, context, statusBarNotification, true, false, false, false, view4, 56, null);
        o.d((Object)view3);
        TemplateRevert.normalViewsBuild$default(this, context, statusBarNotification, true, false, false, false, view3, 56, null);
        o.d((Object)view2);
        TemplateRevert.normalViewsBuild$default(this, context, statusBarNotification, true, false, false, false, view2, 56, null);
        o.d((Object)view);
        TemplateRevert.normalViewsBuild$default(this, context, statusBarNotification, true, false, false, false, view, 56, null);
        o.d((Object)context2);
        TemplateRevert.normalViewsBuild$default(this, context, statusBarNotification, true, false, false, false, (View)context2, 56, null);
        focusNotificationContent.setTinyView((View)contextUtils);
        focusNotificationContent.setTinyKeyguardView(view4);
        focusNotificationContent.setTinyViewDark(view3);
        focusNotificationContent.setTinyViewModal(view2);
        focusNotificationContent.setTinyViewDarkModal(view);
        focusNotificationContent.setTinyViewKeyguardDark((View)context2);
    }

    public final String getTAG() {
        return this.TAG;
    }

    public final int getTYPE_HIDE_TIMER() {
        return this.TYPE_HIDE_TIMER;
    }

    public final long getTimerCurrent() {
        return this.timerCurrent;
    }

    public final long getTimerSystemCurrent() {
        return this.timerSystemCurrent;
    }

    public final long getTimerTotal() {
        return this.timerTotal;
    }

    public final int getTimerType() {
        return this.timerType;
    }

    public final long getTimerWhen() {
        return this.timerWhen;
    }

    public final void setTimerCurrent(long l) {
        this.timerCurrent = l;
    }

    public final void setTimerSystemCurrent(long l) {
        this.timerSystemCurrent = l;
    }

    public final void setTimerTotal(long l) {
        this.timerTotal = l;
    }

    public final void setTimerWhen(long l) {
        this.timerWhen = l;
    }

    @Override
    public String toString() {
        String string = TemplateRevert.class.getSimpleName();
        String string2 = super.toString();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(string);
        stringBuilder.append(" ");
        stringBuilder.append(string2);
        return stringBuilder.toString();
    }
}
