/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.annotation.SuppressLint
 *  android.app.Notification$Action
 *  android.content.Context
 *  android.content.res.ColorStateList
 *  android.graphics.Bitmap
 *  android.graphics.Bitmap$Config
 *  android.graphics.BlendMode
 *  android.graphics.Canvas
 *  android.graphics.Color
 *  android.graphics.drawable.Drawable
 *  android.graphics.drawable.Icon
 *  android.os.Bundle
 *  android.os.Parcelable
 *  android.service.notification.StatusBarNotification
 *  android.text.TextUtils
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.view.ViewGroup
 *  android.view.ViewGroup$LayoutParams
 *  android.widget.FrameLayout$LayoutParams
 *  android.widget.ImageView
 *  android.widget.LinearLayout$LayoutParams
 *  android.widget.ProgressBar
 *  android.widget.RemoteViews
 *  android.widget.TextView
 *  b1.f
 *  com.android.systemui.miui.notification.R$dimen
 *  com.android.systemui.miui.notification.R$drawable
 *  com.android.systemui.miui.notification.R$id
 *  com.android.systemui.miui.notification.R$layout
 *  com.android.systemui.plugins.miui.notification.FocusNotificationContent
 *  kotlin.jvm.internal.o
 *  miui.systemui.dynamicisland.DynamicIslandUtils
 *  miui.systemui.notification.NotificationUtil
 *  org.json.JSONObject
 *  z1.a
 */
package miui.systemui.notification.focus.template;

import android.annotation.SuppressLint;
import android.app.Notification;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.BlendMode;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Icon;
import android.os.Bundle;
import android.os.Parcelable;
import android.service.notification.StatusBarNotification;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RemoteViews;
import android.widget.TextView;
import b1.f;
import com.android.systemui.miui.notification.R;
import com.android.systemui.plugins.miui.notification.FocusNotificationContent;
import java.util.ArrayList;
import kotlin.jvm.internal.o;
import miui.systemui.dynamicisland.DynamicIslandUtils;
import miui.systemui.notification.NotificationUtil;
import miui.systemui.notification.focus.FocusParamsException;
import miui.systemui.notification.focus.template.FocusTemplateKt;
import miui.systemui.notification.focus.template.TemplateRevert;
import org.json.JSONObject;
import z1.a;

public abstract class FocusTemplate {
    private final String IS_FLIP_DEVICE;
    private Bundle actionBundle;
    private final String answer;
    private String aodPic;
    private String aodTitle;
    private Bundle bitmapBundle;
    private final String call;
    private final String close;
    private final Integer colorBg;
    private String content;
    private Integer contentColor;
    private Integer contentColorDark;
    private final String copy;
    private final String desc;
    private final String desc1;
    private final String desc2;
    private final Integer descColor;
    private final Integer descColorDark;
    private final String done;
    private final boolean enableFloat;
    private final String end;
    private final String hangup;
    private boolean haveSubTitle;
    private boolean isBgPicDownloadFail;
    private boolean isNotHaveContent;
    private boolean isOnlyActionButton;
    private boolean isSolidBackground;
    private final String later;
    private boolean padding;
    private final JSONObject param;
    private final String pause;
    private int protocol;
    private String reopen;
    private final String restart;
    private String scene;
    private final String speaker;
    private String ticker;
    private String tickerPic;
    private String tickerPicDark;
    private int timeoutMin;
    private String title;
    private final Integer titleColor;
    private final Integer titleColorDark;
    private final boolean updatable;

    /*
     * WARNING - void declaration
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public FocusTemplate(JSONObject object) {
        void var1_30;
        void var1_27;
        void var1_25;
        void var1_21;
        void var1_17;
        void var1_13;
        void var1_9;
        void var1_5;
        o.g((Object)object, (String)"param");
        this.param = object;
        Object object2 = object.get("protocol");
        o.e((Object)object2, (String)"null cannot be cast to non-null type kotlin.Int");
        this.protocol = (Integer)object2;
        object2 = object.get("scene");
        o.e((Object)object2, (String)"null cannot be cast to non-null type kotlin.String");
        this.scene = (String)object2;
        this.title = object.optString("title").toString();
        object2 = NotificationUtil.DEBUG ? "noTicker" : "";
        this.ticker = object.optString("ticker", (String)object2);
        this.tickerPic = object.optString("tickerPic", "");
        this.tickerPicDark = object.optString("tickerPicDark", "");
        this.aodTitle = object.optString("aodTitle", "");
        this.aodPic = object.optString("aodPic", "");
        this.timeoutMin = object.optInt("timeout", 720);
        String string = object.optString("desc1");
        o.f((Object)string, (String)"optString(...)");
        this.desc1 = string;
        object2 = object.optString("desc2");
        o.f((Object)object2, (String)"optString(...)");
        this.desc2 = object2;
        if (!o.c((Object)string, (Object)"") && !o.c((Object)object2, (Object)"")) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(string);
            stringBuilder.append("\u4e28");
            stringBuilder.append((String)object2);
            object2 = stringBuilder.toString();
        } else {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(string);
            stringBuilder.append((String)object2);
            object2 = stringBuilder.toString();
        }
        this.desc = object2;
        object2 = null;
        try {
            Integer n = Color.parseColor((String)object.optString("colorBg"));
        }
        catch (Exception exception) {
            Object var1_4 = null;
        }
        this.colorBg = var1_5;
        try {
            Integer n = Color.parseColor((String)this.param.optString("colorTitle"));
        }
        catch (Exception exception) {
            Object var1_8 = null;
        }
        this.titleColor = var1_9;
        try {
            Integer n = Color.parseColor((String)this.param.optString("colorTitleDark"));
        }
        catch (Exception exception) {
            Object var1_12 = null;
        }
        this.titleColorDark = var1_13;
        try {
            Integer n = Color.parseColor((String)this.param.optString("colorContent"));
        }
        catch (Exception exception) {
            Object var1_16 = null;
        }
        this.contentColor = var1_17;
        try {
            Integer n = Color.parseColor((String)this.param.optString("colorContentDark"));
        }
        catch (Exception exception) {
            Object var1_20 = null;
        }
        this.contentColorDark = var1_21;
        try {
            Integer n = Color.parseColor((String)this.param.optString("colorDesc"));
        }
        catch (Exception exception) {
            Object var1_24 = null;
        }
        this.descColor = var1_25;
        try {
            Integer n = Color.parseColor((String)this.param.optString("colorDescDark"));
        }
        catch (Exception exception) {
            Object object3 = object2;
        }
        this.descColorDark = var1_27;
        object2 = this.param.optString("content");
        o.f((Object)object2, (String)"optString(...)");
        int n = object2.length();
        boolean bl = true;
        boolean bl2 = n == 0;
        this.isNotHaveContent = bl2;
        if (!bl2) {
            String string2 = this.param.optString("content");
            o.d((Object)string2);
        } else {
            if (TextUtils.isEmpty((CharSequence)this.desc)) {
                throw new FocusParamsException("Both content and desc are null");
            }
            this.contentColor = this.descColor;
            this.contentColorDark = var1_27;
            String string3 = this.desc;
        }
        this.content = var1_30;
        bl2 = (this.param.optBoolean("updatable", false) || o.c((Object)this.scene, (Object)"foodDelivery") || o.c((Object)this.scene, (Object)"carHailing")) && this.hasPermission() ? bl : false;
        this.updatable = bl2;
        this.enableFloat = this.param.optBoolean("enableFloat", false);
        this.padding = this.param.optBoolean("padding", false);
        this.reopen = this.param.optString("reopen", "close");
        if (TextUtils.isEmpty((CharSequence)this.title) && !(this instanceof TemplateRevert)) {
            throw new FocusParamsException("title is empty");
        }
        this.pause = "action_pause";
        this.restart = "action_restart";
        this.done = "action_done";
        this.later = "action_later";
        this.close = "action_close";
        this.end = "action_end";
        this.copy = "action_copy";
        this.answer = "action_answer";
        this.hangup = "action_hangup";
        this.speaker = "action_speaker";
        this.call = "action_call";
        this.IS_FLIP_DEVICE = "is_flip_device";
    }

    public static /* synthetic */ void a(Notification.Action action, View view) {
        FocusTemplate.setActionData$lambda$1(action, view);
    }

    private final void buildRemoteViews(Context context, StatusBarNotification statusBarNotification, FocusNotificationContent focusNotificationContent) {
        this.buildNormalViews(context, statusBarNotification, focusNotificationContent);
        this.handleAodAndStatusBar(statusBarNotification, context);
        if (!FocusTemplateKt.access$isFlipDevice$p()) {
            return;
        }
        this.buildTinyViews(context, statusBarNotification, focusNotificationContent);
        this.buildDecoPortViews(context, statusBarNotification, focusNotificationContent);
        this.buildDecoLandViews(context, statusBarNotification, focusNotificationContent);
    }

    private final int getIconResourceId(String string, boolean bl, boolean bl2) {
        int n = o.c((Object)string, (Object)this.pause) ? (bl ? (bl2 ? R.drawable.pause_deco_port : R.drawable.pause_deco) : R.drawable.pause) : (o.c((Object)string, (Object)this.restart) ? (bl ? (bl2 ? R.drawable.restart_deco_port : R.drawable.restart_deco) : R.drawable.restart) : (o.c((Object)string, (Object)this.done) ? (bl ? (bl2 ? R.drawable.done_deco_port : R.drawable.done_deco) : R.drawable.done) : (o.c((Object)string, (Object)this.end) ? (bl ? (bl2 ? R.drawable.end_deco_port : R.drawable.end_deco) : R.drawable.end) : (o.c((Object)string, (Object)this.copy) ? (bl ? (bl2 ? R.drawable.copy_deco_port : R.drawable.copy_deco) : R.drawable.copy) : (o.c((Object)string, (Object)this.close) ? (bl ? (bl2 ? R.drawable.close_deco_port : R.drawable.close_deco) : R.drawable.close) : (o.c((Object)string, (Object)this.later) ? (bl ? (bl2 ? R.drawable.later_deco_port : R.drawable.later_deco) : R.drawable.later) : (o.c((Object)string, (Object)this.answer) ? (bl ? R.drawable.answer_deco : R.drawable.answer) : (o.c((Object)string, (Object)this.hangup) ? (bl ? R.drawable.hangup_deco : R.drawable.hangup) : (o.c((Object)string, (Object)this.speaker) ? (bl ? (bl2 ? R.drawable.speaker_deco_port : R.drawable.speaker_deco) : R.drawable.speaker) : (o.c((Object)string, (Object)this.call) ? R.drawable.call : -1))))))))));
        return n;
    }

    public static /* synthetic */ void setActionData$default(FocusTemplate focusTemplate, View view, int n, Notification.Action action, boolean bl, boolean bl2, int n2, Object object) {
        if (object == null) {
            if ((n2 & 8) != 0) {
                bl = false;
            }
            if ((n2 & 0x10) != 0) {
                bl2 = false;
            }
            focusTemplate.setActionData(view, n, action, bl, bl2);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setActionData");
    }

    public static /* synthetic */ void setActionData$default(FocusTemplate focusTemplate, RemoteViews remoteViews, int n, Notification.Action action, boolean bl, boolean bl2, int n2, Object object) {
        if (object == null) {
            if ((n2 & 8) != 0) {
                bl = false;
            }
            if ((n2 & 0x10) != 0) {
                bl2 = false;
            }
            focusTemplate.setActionData(remoteViews, n, action, bl, bl2);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setActionData");
    }

    private static final void setActionData$lambda$1(Notification.Action action, View view) {
        action = action.actionIntent;
        if (action != null) {
            action.send();
        }
    }

    public static /* synthetic */ void setRemoteViewsBackground$default(FocusTemplate focusTemplate, Context context, View view, StatusBarNotification statusBarNotification, boolean bl, boolean bl2, boolean bl3, int n, Object object) {
        if (object == null) {
            if ((n & 0x10) != 0) {
                bl2 = false;
            }
            if ((n & 0x20) != 0) {
                bl3 = true;
            }
            focusTemplate.setRemoteViewsBackground(context, view, statusBarNotification, bl, bl2, bl3);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setRemoteViewsBackground");
    }

    public static /* synthetic */ void setRemoteViewsProfilePicture$default(FocusTemplate focusTemplate, Context context, View view, StatusBarNotification statusBarNotification, boolean bl, boolean bl2, int n, Object object) {
        if (object == null) {
            if ((n & 0x10) != 0) {
                bl2 = false;
            }
            focusTemplate.setRemoteViewsProfilePicture(context, view, statusBarNotification, bl, bl2);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setRemoteViewsProfilePicture");
    }

    public static /* synthetic */ void setRemoteViewsProgress$default(FocusTemplate focusTemplate, Context context, View view, int n, int n2, boolean bl, boolean bl2, boolean bl3, boolean bl4, int n3, StatusBarNotification statusBarNotification, boolean bl5, int n4, Object object) {
        if (object == null) {
            if ((n4 & 0x10) != 0) {
                bl = false;
            }
            if ((n4 & 0x20) != 0) {
                bl2 = false;
            }
            if ((n4 & 0x40) != 0) {
                bl3 = false;
            }
            if ((n4 & 0x80) != 0) {
                bl4 = false;
            }
            if ((n4 & 0x100) != 0) {
                n3 = R.drawable.point_unselect;
            }
            if ((n4 & 0x400) != 0) {
                bl5 = true;
            }
            focusTemplate.setRemoteViewsProgress(context, view, n, n2, bl, bl2, bl3, bl4, n3, statusBarNotification, bl5);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setRemoteViewsProgress");
    }

    public final boolean bgPicDownloadFail(Bundle bundle) {
        boolean bl;
        block3: {
            block2: {
                Icon icon = bundle != null ? (Icon)bundle.getParcelable("miui.focus.pic_bg") : null;
                if (bundle == null) break block2;
                boolean bl2 = bundle.containsKey("miui.focus.pic_bg");
                bl = true;
                if (bl2 && icon == null) break block3;
            }
            bl = false;
        }
        return bl;
    }

    public abstract void buildDecoLandViews(Context var1, StatusBarNotification var2, FocusNotificationContent var3);

    public abstract void buildDecoPortViews(Context var1, StatusBarNotification var2, FocusNotificationContent var3);

    public abstract void buildNormalViews(Context var1, StatusBarNotification var2, FocusNotificationContent var3);

    public abstract void buildTinyViews(Context var1, StatusBarNotification var2, FocusNotificationContent var3);

    public void checkPermission() {
    }

    public final Bundle getActionBundle() {
        return this.actionBundle;
    }

    public final String getAodPic() {
        return this.aodPic;
    }

    public final String getAodTitle() {
        return this.aodTitle;
    }

    public final Bundle getBitmapBundle() {
        return this.bitmapBundle;
    }

    public final Integer getColorBg() {
        return this.colorBg;
    }

    public final String getContent() {
        return this.content;
    }

    public final Integer getContentColor() {
        return this.contentColor;
    }

    public final Integer getContentColorDark() {
        return this.contentColorDark;
    }

    public final String getDesc() {
        return this.desc;
    }

    public final String getDesc1() {
        return this.desc1;
    }

    public final String getDesc2() {
        return this.desc2;
    }

    public final Integer getDescColor() {
        return this.descColor;
    }

    public final Integer getDescColorDark() {
        return this.descColorDark;
    }

    public final boolean getEnableFloat() {
        return this.enableFloat;
    }

    public final boolean getHaveSubTitle() {
        return this.haveSubTitle;
    }

    public final boolean getPadding() {
        return this.padding;
    }

    public final JSONObject getParam() {
        return this.param;
    }

    public final int getProtocol() {
        return this.protocol;
    }

    public final String getReopen() {
        return this.reopen;
    }

    public final String getScene() {
        return this.scene;
    }

    public final String getTicker() {
        return this.ticker;
    }

    public final String getTickerPic() {
        return this.tickerPic;
    }

    public final String getTickerPicDark() {
        return this.tickerPicDark;
    }

    public final int getTimeoutMin() {
        return this.timeoutMin;
    }

    public final String getTitle() {
        return this.title;
    }

    public final Integer getTitleColor() {
        return this.titleColor;
    }

    public final Integer getTitleColorDark() {
        return this.titleColorDark;
    }

    public final boolean getUpdatable() {
        return this.updatable;
    }

    /*
     * Unable to fully structure code
     */
    public void handleAodAndStatusBar(StatusBarNotification var1_1, Context var2_2) {
        block2: {
            o.g((Object)var1_1, (String)"sbn");
            o.g((Object)var2_2, (String)"ctx");
            var1_1.getNotification().extras.putString("miui.focus.ticker", this.ticker);
            var1_1.getNotification().extras.putString("miui.focus.pic_ticker", this.tickerPic);
            var1_1.getNotification().extras.putString("miui.focus.pic_ticker_dark", this.tickerPicDark);
            var4_3 = new RemoteViews(var2_2.getPackageName(), R.layout.focus_notification_template_aod_v2);
            var2_2 = this.aodTitle;
            if (var2_2 == null || TextUtils.isEmpty((CharSequence)var2_2)) break block2;
            this.setAodTextVisibleAndText(var4_3, this.aodTitle);
            var3_4 = R.id.focus_aod_icon;
            var4_3.setViewVisibility(var3_4, 0);
            var2_2 = this.aodPic;
            if (var2_2 == null) ** GOTO lbl-1000
            o.d((Object)var2_2);
            if (var2_2.length() > 0) {
                var2_2 = this.bitmapBundle;
                var2_2 = var2_2 != null ? (Icon)var2_2.getParcelable(this.aodPic) : null;
                var4_3.setImageViewIcon(var3_4, (Icon)var2_2);
            } else lbl-1000:
            // 2 sources

            {
                var1_1.getNotification().extras.putInt("miui.focus.aodIconId", var3_4);
            }
            var1_1.getNotification().extras.putParcelable("miui.focus.rvAod", (Parcelable)var4_3);
        }
    }

    public void handleTimeout(StatusBarNotification statusBarNotification, int n) {
        o.g((Object)statusBarNotification, (String)"sbn");
        long l = n < 0 ? 5000L : 60000L * (long)n;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("handleTimeout ");
        stringBuilder.append(l);
        NotificationUtil.debugLog((String)"FocusPlugin", (String)stringBuilder.toString());
        statusBarNotification.getNotification().extras.putLong("miui.timeout", l);
    }

    public final boolean hasPermission() {
        return true;
    }

    public final boolean isBgPicDownloadFail() {
        return this.isBgPicDownloadFail;
    }

    public final boolean isNotHaveContent() {
        return this.isNotHaveContent;
    }

    public final boolean isOnlyActionButton() {
        return this.isOnlyActionButton;
    }

    public final boolean isSolidBackground() {
        return this.isSolidBackground;
    }

    public final void resetTemplateState() {
        this.haveSubTitle = false;
        this.isOnlyActionButton = false;
        this.isSolidBackground = false;
        this.isBgPicDownloadFail = false;
    }

    public final void resetViewState(View view) {
        o.g((Object)view, (String)"v");
        TextView textView = (TextView)view.findViewById(R.id.focus_title);
        if (textView != null) {
            textView.setText(null);
        }
        textView = (TextView)view.findViewById(R.id.focus_content);
        if (textView != null) {
            textView.setText(null);
        }
        textView = (TextView)view.findViewById(R.id.focus_desc);
        if (textView != null) {
            textView.setVisibility(8);
        }
        textView = view.findViewById(R.id.progressbar_container);
        if (textView != null) {
            textView.setVisibility(8);
        }
        textView = view.findViewById(R.id.progress_point2);
        if (textView != null) {
            textView.setVisibility(8);
        }
        textView = view.findViewById(R.id.focus_progress_info2);
        if (textView != null) {
            textView.setVisibility(8);
        }
        int n = R.id.focus_large_icon;
        textView = view.findViewById(n);
        if (textView != null) {
            textView.setVisibility(8);
        }
        textView = (ImageView)view.findViewById(n);
        if (textView != null) {
            textView.setImageBitmap(null);
        }
        if ((textView = (ImageView)view.findViewById(n = R.id.focus_small_icon)) != null) {
            textView.setImageBitmap(null);
        }
        if ((textView = (ImageView)view.findViewById(n)) != null) {
            textView.setVisibility(0);
        }
        textView = (ImageView)view.findViewById(R.id.focus_button_icon1);
        if (textView != null) {
            textView.setVisibility(8);
        }
        textView = (ImageView)view.findViewById(R.id.focus_button_icon2);
        if (textView != null) {
            textView.setVisibility(8);
        }
        view = (TextView)view.findViewById(R.id.focus_subtitle);
        if (view != null) {
            view.setVisibility(8);
        }
    }

    public final void setActionBundle(Bundle bundle) {
        this.actionBundle = bundle;
    }

    public final void setActionData(View view, int n, Notification.Action action, boolean bl, boolean bl2) {
        o.g((Object)view, (String)"v");
        if (action == null) {
            return;
        }
        String string = action.getExtras().getString("icon_name");
        if (string == null) {
            return;
        }
        int n2 = this.getIconResourceId(string, bl, bl2);
        view = (ImageView)view.findViewById(n);
        if (n2 != -1 && view != null) {
            view.setImageResource(n2);
        }
        if (view != null) {
            view.setContentDescription(action.title);
        }
        if (view != null) {
            view.setOnClickListener((View.OnClickListener)new a(action));
        }
        if (view != null) {
            view.setVisibility(0);
        }
        this.isOnlyActionButton = true;
    }

    public final void setActionData(RemoteViews remoteViews, int n, Notification.Action action, boolean bl, boolean bl2) {
        o.g((Object)remoteViews, (String)"v");
        if (action == null) {
            return;
        }
        String string = action.getExtras().getString("icon_name");
        if (string == null) {
            return;
        }
        int n2 = this.getIconResourceId(string, bl, bl2);
        if (n2 != -1) {
            remoteViews.setImageViewResource(n, n2);
        }
        remoteViews.setContentDescription(n, action.title);
        remoteViews.setOnClickPendingIntent(n, action.actionIntent);
        remoteViews.setViewVisibility(n, 0);
        this.isOnlyActionButton = true;
    }

    public final void setAodPic(String string) {
        this.aodPic = string;
    }

    public final void setAodTextVisibleAndText(RemoteViews remoteViews, String string) {
        o.g((Object)remoteViews, (String)"v");
        int n = R.id.focus_aod_title;
        remoteViews.setViewVisibility(n, 0);
        remoteViews.setTextViewText(n, (CharSequence)string);
    }

    public final void setAodTitle(String string) {
        this.aodTitle = string;
    }

    public final void setBgPicDownloadFail(boolean bl) {
        this.isBgPicDownloadFail = bl;
    }

    public final void setBitmapBundle(Bundle bundle) {
        this.bitmapBundle = bundle;
    }

    public final void setContent(String string) {
        o.g((Object)string, (String)"<set-?>");
        this.content = string;
    }

    public final void setContentColor(Integer n) {
        this.contentColor = n;
    }

    public final void setContentColorDark(Integer n) {
        this.contentColorDark = n;
    }

    public final void setDescTextColor(View view, int n) {
        o.g((Object)view, (String)"v");
        TextView textView = (TextView)view.findViewById(R.id.focus_desc);
        if (textView != null) {
            textView.setTextColor(n);
        }
        if (this.isNotHaveContent && (textView = (TextView)view.findViewById(R.id.focus_content)) != null) {
            textView.setTextColor(n);
        }
        if ((textView = (ProgressBar)view.findViewById(R.id.focus_progress_info1)) != null) {
            textView.setProgressTintList(ColorStateList.valueOf((int)n));
        }
        textView = (ProgressBar)view.findViewById(R.id.focus_progress_info2);
        if (textView != null) {
            textView.setProgressTintList(ColorStateList.valueOf((int)n));
        }
        textView = (ImageView)view.findViewById(R.id.progress_point1);
        if (textView != null) {
            textView.setImageTintList(ColorStateList.valueOf((int)n));
        }
        view = (ImageView)view.findViewById(R.id.progress_point2);
        if (view != null) {
            view.setImageTintList(ColorStateList.valueOf((int)n));
        }
    }

    public final void setHaveSubTitle(boolean bl) {
        this.haveSubTitle = bl;
    }

    public final void setNotHaveContent(boolean bl) {
        this.isNotHaveContent = bl;
    }

    public final void setOnlyActionButton(boolean bl) {
        this.isOnlyActionButton = bl;
    }

    public final void setPadding(boolean bl) {
        this.padding = bl;
    }

    public final void setProtocol(int n) {
        this.protocol = n;
    }

    /*
     * WARNING - void declaration
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public final void setRemoteViewsBackground(Context context, View view, StatusBarNotification object, boolean bl, boolean bl2, boolean bl3) {
        void var12_17;
        int n;
        Bundle bundle;
        Object object2;
        block27: {
            block30: {
                block32: {
                    Error error2;
                    block29: {
                        block31: {
                            void var12_10;
                            o.g((Object)context, (String)"ctx");
                            o.g((Object)view, (String)"v");
                            o.g((Object)object, (String)"sbn");
                            Bundle bundle2 = this.bitmapBundle;
                            object2 = null;
                            if (bundle2 != null) {
                                Icon icon = (Icon)bundle2.getParcelable("miui.focus.pic_bg");
                            } else {
                                Object var12_9 = null;
                            }
                            bundle = this.bitmapBundle;
                            boolean bl4 = bundle != null && bundle.containsKey("miui.focus.pic_bg") && var12_10 == null;
                            this.isBgPicDownloadFail = bl4;
                            bundle = (ImageView)view.findViewById(R.id.focus_notify_bg_image);
                            if (this.isBgPicDownloadFail || bl2) break block30;
                            if (var12_10 == null) break block31;
                            object.getNotification().extras.putBoolean("miui.focus.hasCustomBg", true);
                            if (bundle != null) {
                                bundle.setImageIcon((Icon)var12_10);
                            }
                            break block27;
                        }
                        if (this.colorBg == null) break block32;
                        Bitmap bitmap = Bitmap.createBitmap((int)1, (int)1, (Bitmap.Config)Bitmap.Config.RGB_565);
                        Canvas canvas = new Canvas(bitmap);
                        canvas.drawColor(this.colorBg.intValue());
                        object.getNotification().extras.putBoolean("miui.focus.hasCustomBg", true);
                        if (bundle == null) break block27;
                        try {
                            bundle.setImageBitmap(bitmap);
                            break block27;
                        }
                        catch (Exception exception) {
                        }
                        catch (Error error2) {
                            break block29;
                        }
                        exception.printStackTrace();
                        break block27;
                    }
                    error2.printStackTrace();
                    break block27;
                }
                this.isSolidBackground = true;
                break block27;
            }
            this.isSolidBackground = true;
        }
        object.getNotification().extras.putBoolean("miui.focus.isSolidBg", this.isSolidBackground);
        if (!this.isSolidBackground) {
            if (!TextUtils.isEmpty((CharSequence)this.title) && this.titleColor == null) {
                throw new FocusParamsException("The color of title is null");
            }
            if (!TextUtils.isEmpty((CharSequence)this.content) && this.contentColor == null) {
                throw new FocusParamsException("The color of content is null");
            }
            if (!TextUtils.isEmpty((CharSequence)this.desc) && this.descColor == null) {
                throw new FocusParamsException("The color of desc is null");
            }
            object = this.titleColor;
            if (object != null) {
                n = ((Number)object).intValue();
                object = (TextView)view.findViewById(R.id.focus_title);
                if (object != null) {
                    object.setTextColor(n);
                }
                if ((object = (TextView)view.findViewById(R.id.focus_subtitle)) != null) {
                    object.setTextColor(n);
                }
            }
            if ((object = this.contentColor) != null) {
                n = ((Number)object).intValue();
                object = (TextView)view.findViewById(R.id.focus_content);
                if (object != null) {
                    object.setTextColor(n);
                }
            }
            if ((object = this.descColor) != null) {
                this.setDescTextColor(view, ((Number)object).intValue());
            }
        }
        if (this.isOnlyActionButton) return;
        object = this.bitmapBundle;
        object = object != null ? (Icon)object.getParcelable("miui.focus.pic_large") : null;
        bundle = (ImageView)view.findViewById(R.id.focus_large_icon);
        Drawable drawable2 = object2;
        if (bundle != null) {
            ViewGroup.LayoutParams layoutParams = bundle.getLayoutParams();
        }
        if (var12_17 == null) {
            return;
        }
        if (!bl) {
            float f2 = context.getResources().getDimension(R.dimen.focus_notify_large_pic_height);
            if (object == null) return;
            object2 = object.loadDrawable(context);
            if (object2 == null) return;
            n = object2.getIntrinsicWidth();
            object2 = object.loadDrawable(context);
            if (object2 == null) return;
            int n2 = object2.getIntrinsicHeight();
            float f3 = f.h((float)((float)n / (float)n2), (float)1.0f, (float)1.7f);
            object2 = new StringBuilder();
            ((StringBuilder)object2).append("LargeIconData ");
            ((StringBuilder)object2).append(n);
            ((StringBuilder)object2).append(" , ");
            ((StringBuilder)object2).append(n2);
            ((StringBuilder)object2).append(" , ");
            ((StringBuilder)object2).append(f3);
            NotificationUtil.debugLog((String)"FocusPlugin", (String)((StringBuilder)object2).toString());
            if (this.padding) {
                f2 = context.getResources().getDimension(R.dimen.focus_notify_large_pic_padding_height);
                if (bundle.getLayoutParams() instanceof LinearLayout.LayoutParams) {
                    object2 = (LinearLayout.LayoutParams)var12_17;
                    object2.setMarginEnd((int)context.getResources().getDimension(R.dimen.focus_notify_large_icon_margin_end));
                    if (bl3) {
                        ((LinearLayout.LayoutParams)object2).topMargin = (int)context.getResources().getDimension(R.dimen.focus_notify_large_icon_margin_top);
                    }
                }
                if (bundle.getLayoutParams() instanceof FrameLayout.LayoutParams) {
                    object2 = (FrameLayout.LayoutParams)var12_17;
                    object2.setMarginEnd((int)context.getResources().getDimension(R.dimen.focus_notify_large_icon_margin_end));
                    if (bl3) {
                        ((FrameLayout.LayoutParams)object2).topMargin = (int)context.getResources().getDimension(R.dimen.focus_notify_large_icon_margin_top);
                    }
                }
                var12_17.height = (int)f2;
            }
            var12_17.width = (int)(f2 * f3);
            bundle.setLayoutParams((ViewGroup.LayoutParams)var12_17);
            bundle.setImageIcon((Icon)object);
            bundle.setVisibility(0);
            if (!this.haveSubTitle) return;
            ((TextView)view.findViewById(R.id.focus_title)).setMaxEms(5);
            return;
        } else {
            float f4 = o.c((Object)this.scene, (Object)"sos") ? context.getResources().getDimension(R.dimen.focus_notify_tiny_large_pic_mini_height) : context.getResources().getDimension(R.dimen.focus_notify_tiny_large_pic_height);
            if (object != null) {
                var12_17.height = n = (int)f4;
                var12_17.width = n;
                bundle.setLayoutParams((ViewGroup.LayoutParams)var12_17);
                bundle.setImageIcon((Icon)object);
                bundle.setVisibility(0);
            }
            if (!this.haveSubTitle) return;
            ((TextView)view.findViewById(R.id.focus_title)).setMaxEms(4);
        }
    }

    public final void setRemoteViewsProfilePicture(Context context, View view, StatusBarNotification statusBarNotification, boolean bl, boolean bl2) {
        o.g((Object)context, (String)"ctx");
        o.g((Object)view, (String)"v");
        o.g((Object)statusBarNotification, (String)"sbn");
        String string = this.param.optString("profilePicture");
        statusBarNotification = this.bitmapBundle;
        Object var7_7 = null;
        context = var7_7;
        if (statusBarNotification != null) {
            if (string == null || string.length() <= 0) {
                statusBarNotification = null;
            }
            context = var7_7;
            if (statusBarNotification != null) {
                context = (Icon)statusBarNotification.getParcelable(string);
            }
        }
        statusBarNotification = (ViewGroup)view.findViewById(R.id.focus_icon_container);
        view = (ImageView)view.findViewById(R.id.focus_profile);
        int n = context != null ? 0 : 8;
        if (statusBarNotification != null) {
            statusBarNotification.setVisibility(n);
        }
        if (view != null) {
            view.setVisibility(n);
        }
        if (context != null && view != null) {
            view.setImageIcon((Icon)context);
        }
    }

    public final void setRemoteViewsProgress(Context context, View view, int n, int n2, boolean bl, boolean bl2, boolean bl3, boolean bl4, int n3, StatusBarNotification object, boolean bl5) {
        o.g((Object)context, (String)"ctx");
        o.g((Object)view, (String)"v");
        o.g((Object)object, (String)"sbn");
        if (n >= 0) {
            int n4;
            object = view.findViewById(R.id.progressbar_container);
            if (object != null) {
                object.setVisibility(0);
            }
            int n5 = R.dimen.focus_notify_extend_height;
            TextView textView = (TextView)view.findViewById(R.id.focus_content);
            ProgressBar progressBar = null;
            object = textView != null ? textView.getLayoutParams() : null;
            object = object instanceof LinearLayout.LayoutParams ? (LinearLayout.LayoutParams)object : null;
            if (bl2) {
                n4 = R.dimen.focus_notify_deco_port_height;
            } else if (bl3) {
                n4 = n5;
            } else if (bl) {
                n4 = n5 = R.dimen.focus_notify_tiny_extend_height;
                if (bl5) {
                    if (object == null) {
                        n4 = n5;
                    } else {
                        object.bottomMargin = context.getResources().getDimensionPixelSize(R.dimen.focus_notify_tiny_margin_gap_template_progress);
                        n4 = n5;
                    }
                }
            } else {
                TextView textView2 = (TextView)view.findViewById(R.id.focus_desc);
                if (textView2 != null) {
                    textView2.setVisibility(0);
                }
                if (textView2 != null) {
                    textView2.setText((CharSequence)this.desc);
                }
                n4 = n5;
                if (bl5) {
                    if (object == null) {
                        n4 = n5;
                    } else {
                        object.bottomMargin = context.getResources().getDimensionPixelSize(R.dimen.focus_notify_margin_bottom_normal_os2);
                        n4 = n5;
                    }
                }
            }
            if (textView != null) {
                textView.setLayoutParams((ViewGroup.LayoutParams)object);
            }
            textView = view.findViewById(R.id.focus_container);
            object = progressBar;
            if (textView != null) {
                object = textView.getLayoutParams();
            }
            if (object != null) {
                object.height = context.getResources().getDimensionPixelSize(n4);
            }
            context = (ProgressBar)view.findViewById(R.id.focus_progress_info1);
            object = (ImageView)view.findViewById(R.id.progress_point1);
            if (context != null) {
                context.setMax(100);
            }
            if (context != null) {
                context.setProgress(n);
            }
            n4 = R.drawable.point_select;
            n5 = R.drawable.point_done;
            progressBar = (ProgressBar)view.findViewById(R.id.focus_progress_info2);
            view = (ImageView)view.findViewById(R.id.progress_point2);
            if (n == 100 && n2 == 1 && object != null) {
                object.setImageResource(n4);
            }
            if (n2 > 1) {
                if (progressBar != null) {
                    progressBar.setVisibility(0);
                }
                if (view != null) {
                    view.setVisibility(0);
                }
                if (context != null) {
                    context.setMax(50);
                }
                if (context != null) {
                    context.setProgress(n);
                }
                if (progressBar != null) {
                    progressBar.setMax(50);
                }
                if (progressBar != null) {
                    progressBar.setProgress(n - 50);
                }
                if (n < 50) {
                    if (object != null) {
                        object.setImageResource(n3);
                    }
                    if (object != null) {
                        object.setImageTintBlendMode(BlendMode.DST);
                    }
                } else if (n == 50) {
                    if (object != null) {
                        object.setImageResource(n4);
                    }
                    if (object != null) {
                        object.setImageTintBlendMode(BlendMode.SRC_IN);
                    }
                } else if (n >= 51) {
                    if (object != null) {
                        object.setImageResource(n5);
                    }
                    if (object != null) {
                        object.setImageTintBlendMode(BlendMode.SRC_IN);
                    }
                }
                if (n < 99) {
                    if (view != null) {
                        view.setImageResource(n3);
                    }
                    if (view != null) {
                        view.setImageTintBlendMode(BlendMode.DST);
                    }
                } else if (n >= 100) {
                    if (view != null) {
                        view.setImageResource(n4);
                    }
                    if (view != null) {
                        view.setImageTintBlendMode(BlendMode.SRC_IN);
                    }
                }
            }
        } else {
            n = bl4 ? R.dimen.dynamic_island_height : (bl2 ? R.dimen.focus_notify_deco_port_height : (bl3 ? R.dimen.focus_notify_deco_port_width : (bl ? R.dimen.focus_notify_normal_height_tiny : R.dimen.focus_notify_normal_height)));
            n2 = context.getResources().getDimensionPixelSize(n);
            context = view.findViewById(R.id.focus_container);
            if (context != null && (context = context.getLayoutParams()) != null) {
                n = context.height;
                if (n == -1) {
                    return;
                }
                if (n == n2) {
                    return;
                }
                context.height = n2;
            }
        }
    }

    public final void setReopen(String string) {
        this.reopen = string;
    }

    public final void setScene(String string) {
        o.g((Object)string, (String)"<set-?>");
        this.scene = string;
    }

    public final void setSolidBackground(boolean bl) {
        this.isSolidBackground = bl;
    }

    @SuppressLint(value={"CutPasteId"})
    public final void setTextVisibleAndText(View view) {
        o.g((Object)view, (String)"v");
        int n = R.id.focus_title;
        TextView textView = (TextView)view.findViewById(n);
        if (textView != null) {
            textView.setVisibility(0);
        }
        textView = (TextView)view.findViewById(n);
        if (textView != null) {
            textView.setText((CharSequence)this.title);
        }
        n = R.id.focus_content;
        textView = (TextView)view.findViewById(n);
        if (textView != null) {
            textView.setVisibility(0);
        }
        view = (TextView)view.findViewById(n);
        if (view != null) {
            view.setText((CharSequence)this.content);
        }
    }

    public final void setTicker(String string) {
        this.ticker = string;
    }

    public final void setTickerPic(String string) {
        this.tickerPic = string;
    }

    public final void setTickerPicDark(String string) {
        this.tickerPicDark = string;
    }

    public final void setTimeoutMin(int n) {
        this.timeoutMin = n;
    }

    public final void setTitle(String string) {
        o.g((Object)string, (String)"<set-?>");
        this.title = string;
    }

    public final void showAppIcon(Context context, ImageView imageView, StatusBarNotification statusBarNotification) {
        o.g((Object)context, (String)"ctx");
        o.g((Object)statusBarNotification, (String)"sbn");
        String string = NotificationUtil.getSbnTargetPkg((Context)context, (StatusBarNotification)statusBarNotification);
        if (imageView != null) {
            imageView.setImageDrawable(DynamicIslandUtils.INSTANCE.getAppIcon(context, string, Integer.valueOf(statusBarNotification.getUser().getIdentifier())));
        }
    }

    public String toString() {
        int n = this.protocol;
        String string = this.scene;
        String string2 = this.title;
        String string3 = this.content;
        String string4 = this.desc;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("v");
        stringBuilder.append(n);
        stringBuilder.append(":");
        stringBuilder.append(string);
        stringBuilder.append(" t:");
        stringBuilder.append(string2);
        stringBuilder.append(" c:");
        stringBuilder.append(string3);
        stringBuilder.append(" des:");
        stringBuilder.append(string4);
        return stringBuilder.toString();
    }

    public void wrapNotification(Context context, StatusBarNotification statusBarNotification, FocusNotificationContent focusNotificationContent) {
        o.g((Object)context, (String)"ctx");
        o.g((Object)statusBarNotification, (String)"sbn");
        o.g((Object)focusNotificationContent, (String)"focusContent");
        this.bitmapBundle = statusBarNotification.getNotification().extras.getBundle("miui.focus.pics");
        this.actionBundle = statusBarNotification.getNotification().extras.getBundle("miui.focus.actions");
        this.handleAodAndStatusBar(statusBarNotification, context);
        this.handleTimeout(statusBarNotification, this.timeoutMin);
        statusBarNotification.getNotification().extras.putBoolean("miui.customHideBorder", true);
        statusBarNotification.getNotification().extras.putBoolean("miui.enableFloat", this.enableFloat);
        statusBarNotification.getNotification().extras.putString("scene", this.scene);
        if (this.updatable) {
            statusBarNotification.getNotification().extras.putString("miui.focus.reopen", this.reopen);
            statusBarNotification.getNotification().extras.putBoolean("miui.focus.enableAlert", this.enableFloat);
            statusBarNotification.getNotification().flags &= 0xFFFFFFEF;
        } else {
            statusBarNotification.getNotification().extras.remove("miui.focus.reopen");
            statusBarNotification.getNotification().flags |= 0x10;
        }
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        arrayList.add(R.id.focus_title);
        arrayList.add(R.id.focus_subtitle);
        arrayList.add(R.id.focus_content);
        statusBarNotification.getNotification().extras.putIntegerArrayList("miui.focus.textIds", arrayList);
        this.buildRemoteViews(context, statusBarNotification, focusNotificationContent);
    }
}
