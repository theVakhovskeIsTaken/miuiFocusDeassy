/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.Parcelable
 *  android.service.notification.StatusBarNotification
 *  android.text.TextUtils
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.widget.ImageView
 *  android.widget.RemoteViews
 *  android.widget.TextView
 *  com.android.systemui.miui.notification.R$id
 *  com.android.systemui.miui.notification.R$layout
 *  com.android.systemui.plugins.miui.notification.FocusNotificationContent
 *  kotlin.jvm.internal.o
 *  miui.systemui.util.ContextUtils
 *  org.json.JSONObject
 */
package miui.systemui.notification.focus.template;

import android.content.Context;
import android.os.Parcelable;
import android.service.notification.StatusBarNotification;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RemoteViews;
import android.widget.TextView;
import com.android.systemui.miui.notification.R;
import com.android.systemui.plugins.miui.notification.FocusNotificationContent;
import kotlin.jvm.internal.o;
import miui.systemui.notification.focus.template.FocusTemplate;
import miui.systemui.notification.focus.template.SceneName;
import miui.systemui.util.ContextUtils;
import org.json.JSONObject;

@SceneName(sceneNames={"carHailing", "events", "templateBaseProgressScene"})
public final class TemplateBaseProgress
extends FocusTemplate {
    private final int progress;
    private final int progressCount;
    private final boolean showSmallIcon;

    public TemplateBaseProgress(JSONObject jSONObject) {
        o.g((Object)jSONObject, (String)"param");
        super(jSONObject);
        this.progress = jSONObject.optInt("progress", -1);
        this.progressCount = jSONObject.optInt("progressCount", 1);
        this.showSmallIcon = jSONObject.optBoolean("showSmallIcon", true);
    }

    private final void normalViewsBuild(Context context, StatusBarNotification statusBarNotification, boolean bl, boolean bl2, boolean bl3, boolean bl4, View view) {
        int n;
        this.resetViewState(view);
        this.setTextVisibleAndText(view);
        FocusTemplate.setRemoteViewsBackground$default(this, context, view, statusBarNotification, bl, bl4, false, 32, null);
        TextView textView = (TextView)view.findViewById(R.id.focus_content);
        TextView textView2 = (TextView)view.findViewById(R.id.focus_title);
        if (bl2) {
            textView2.setMaxLines(3);
            if (this.getTitle().length() > 10 && textView != null) {
                textView.setMaxLines(2);
            }
            if (5 <= (n = this.getTitle().length()) && n < 11 && textView != null) {
                textView.setMaxLines(3);
            }
            if (1 <= (n = this.getTitle().length()) && n < 6 && textView != null) {
                textView.setMaxLines(4);
            }
        }
        if (this.isSolidBackground() && !this.isBgPicDownloadFail()) {
            Integer n2 = this.getTitleColor();
            if (n2 != null) {
                n = n2;
                if (textView2 != null) {
                    textView2.setTextColor(n);
                }
            }
            if ((n2 = this.getContentColor()) != null) {
                n = n2;
                if (textView != null) {
                    textView.setTextColor(n);
                }
            }
            if (this.getDescColor() != null) {
                this.setDescTextColor(view, this.getDescColor());
            }
        }
        FocusTemplate.setRemoteViewsProgress$default(this, context, view, this.progress, this.progressCount, bl, bl2, bl3, bl4, 0, statusBarNotification, false, 1280, null);
        if (!this.showSmallIcon) {
            context = view.findViewById(R.id.focus_small_icon);
            if (context != null) {
                context.setVisibility(8);
            }
        } else if ((view = (ImageView)view.findViewById(R.id.focus_small_icon)) != null) {
            view.setVisibility(0);
            this.showAppIcon(context, (ImageView)view, statusBarNotification);
        }
    }

    public static /* synthetic */ void normalViewsBuild$default(TemplateBaseProgress templateBaseProgress, Context context, StatusBarNotification statusBarNotification, boolean bl, boolean bl2, boolean bl3, boolean bl4, View view, int n, Object object) {
        if ((n & 8) != 0) {
            bl2 = false;
        }
        if ((n & 0x10) != 0) {
            bl3 = false;
        }
        if ((n & 0x20) != 0) {
            bl4 = false;
        }
        templateBaseProgress.normalViewsBuild(context, statusBarNotification, bl, bl2, bl3, bl4, view);
    }

    @Override
    public void buildDecoLandViews(Context context, StatusBarNotification statusBarNotification, FocusNotificationContent focusNotificationContent) {
        View view;
        View view2;
        o.g((Object)context, (String)"ctx");
        o.g((Object)statusBarNotification, (String)"sbn");
        o.g((Object)focusNotificationContent, (String)"focusContent");
        View view3 = view2 = focusNotificationContent.getDecoLand();
        if (view2 == null) {
            view3 = LayoutInflater.from((Context)ContextUtils.INSTANCE.getDayContext(context)).inflate(R.layout.focus_notification_template_base_progress_deco_land, null);
        }
        view2 = view = focusNotificationContent.getDecoLandDark();
        if (view == null) {
            view2 = LayoutInflater.from((Context)ContextUtils.getNightContext$default((ContextUtils)ContextUtils.INSTANCE, (Context)context, (boolean)false, (int)2, null)).inflate(R.layout.focus_notification_template_base_progress_deco_land, null);
        }
        o.d((Object)view3);
        TemplateBaseProgress.normalViewsBuild$default(this, context, statusBarNotification, false, false, true, false, view3, 40, null);
        o.d((Object)view2);
        TemplateBaseProgress.normalViewsBuild$default(this, context, statusBarNotification, false, false, true, false, view2, 40, null);
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
        View view3 = view2 = focusNotificationContent.getDeco();
        if (view2 == null) {
            view3 = LayoutInflater.from((Context)ContextUtils.INSTANCE.getDayContext(context)).inflate(R.layout.focus_notification_template_base_progress_deco_port, null);
        }
        view2 = view = focusNotificationContent.getDecoDark();
        if (view == null) {
            view2 = LayoutInflater.from((Context)ContextUtils.getNightContext$default((ContextUtils)ContextUtils.INSTANCE, (Context)context, (boolean)false, (int)2, null)).inflate(R.layout.focus_notification_template_base_progress_deco_port, null);
        }
        o.d((Object)view3);
        TemplateBaseProgress.normalViewsBuild$default(this, context, statusBarNotification, false, true, false, false, view3, 48, null);
        o.d((Object)view2);
        TemplateBaseProgress.normalViewsBuild$default(this, context, statusBarNotification, false, true, false, false, view2, 48, null);
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
        ContextUtils contextUtils = ContextUtils.INSTANCE;
        Context context2 = contextUtils.getDayContext(context);
        Context context3 = ContextUtils.getNightContext$default((ContextUtils)contextUtils, (Context)context, (boolean)false, (int)2, null);
        View view4 = view3 = focusNotificationContent.getFocusNotification();
        if (view3 == null) {
            view4 = LayoutInflater.from((Context)context2).inflate(R.layout.focus_notification_template_base_progress, null);
        }
        view3 = view2 = focusNotificationContent.getFocusNotificationDark();
        if (view2 == null) {
            view3 = LayoutInflater.from((Context)context3).inflate(R.layout.focus_notification_template_base_progress, null);
        }
        view2 = view = focusNotificationContent.getFocusNotificationModal();
        if (view == null) {
            view2 = LayoutInflater.from((Context)context2).inflate(R.layout.focus_notification_template_base_progress, null);
            view2.setTag(R.id.dynamic_island_modal_tag, (Object)Boolean.TRUE);
        }
        context2 = focusNotificationContent.getFocusNotificationDarkModal();
        view = context2;
        if (context2 == null) {
            view = LayoutInflater.from((Context)context3).inflate(R.layout.focus_notification_template_base_progress, null);
            view.setTag(R.id.dynamic_island_modal_tag, (Object)Boolean.TRUE);
        }
        Context context4 = contextUtils.getNightContext(context, true);
        contextUtils = focusNotificationContent.getIslandExpandedView();
        context2 = contextUtils;
        if (contextUtils == null) {
            context2 = LayoutInflater.from((Context)context4).inflate(R.layout.focus_notification_template_base_progress, null);
        }
        context3 = focusNotificationContent.getIslandExpandedViewFake();
        contextUtils = context3;
        if (context3 == null) {
            contextUtils = LayoutInflater.from((Context)context4).inflate(R.layout.focus_notification_template_base_progress, null);
        }
        o.d((Object)view4);
        TemplateBaseProgress.normalViewsBuild$default(this, context, statusBarNotification, false, false, false, false, view4, 56, null);
        o.d((Object)view3);
        TemplateBaseProgress.normalViewsBuild$default(this, context, statusBarNotification, false, false, false, false, view3, 56, null);
        o.d((Object)view2);
        TemplateBaseProgress.normalViewsBuild$default(this, context, statusBarNotification, false, false, false, false, view2, 56, null);
        o.d((Object)view);
        TemplateBaseProgress.normalViewsBuild$default(this, context, statusBarNotification, false, false, false, false, view, 56, null);
        o.d((Object)context2);
        TemplateBaseProgress.normalViewsBuild$default(this, context, statusBarNotification, false, false, false, true, (View)context2, 24, null);
        o.d((Object)contextUtils);
        TemplateBaseProgress.normalViewsBuild$default(this, context, statusBarNotification, false, false, false, true, (View)contextUtils, 24, null);
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
        ContextUtils contextUtils = ContextUtils.INSTANCE;
        Context context2 = contextUtils.getDayContext(context);
        Context context3 = ContextUtils.getNightContext$default((ContextUtils)contextUtils, (Context)context, (boolean)false, (int)2, null);
        View view4 = focusNotificationContent.getTinyView();
        contextUtils = view4;
        if (view4 == null) {
            contextUtils = LayoutInflater.from((Context)context2).inflate(R.layout.focus_notification_template_base_progress_tiny, null);
        }
        view4 = view3 = focusNotificationContent.getTinyKeyguardView();
        if (view3 == null) {
            view4 = LayoutInflater.from((Context)context2).inflate(R.layout.focus_notification_template_base_progress_tiny, null);
        }
        view3 = view2 = focusNotificationContent.getTinyViewDark();
        if (view2 == null) {
            view3 = LayoutInflater.from((Context)context3).inflate(R.layout.focus_notification_template_base_progress_tiny, null);
        }
        view2 = view = focusNotificationContent.getTinyViewModal();
        if (view == null) {
            view2 = LayoutInflater.from((Context)context2).inflate(R.layout.focus_notification_template_base_progress_tiny, null);
        }
        context2 = focusNotificationContent.getTinyViewDarkModal();
        view = context2;
        if (context2 == null) {
            view = LayoutInflater.from((Context)context3).inflate(R.layout.focus_notification_template_base_progress_tiny, null);
        }
        View view5 = focusNotificationContent.getTinyViewKeyguardDark();
        context2 = view5;
        if (view5 == null) {
            context2 = LayoutInflater.from((Context)context3).inflate(R.layout.focus_notification_template_base_progress_tiny, null);
        }
        o.d((Object)contextUtils);
        TemplateBaseProgress.normalViewsBuild$default(this, context, statusBarNotification, true, false, false, false, (View)contextUtils, 56, null);
        o.d((Object)view4);
        TemplateBaseProgress.normalViewsBuild$default(this, context, statusBarNotification, true, false, false, false, view4, 56, null);
        o.d((Object)view3);
        TemplateBaseProgress.normalViewsBuild$default(this, context, statusBarNotification, true, false, false, false, view3, 56, null);
        o.d((Object)view2);
        TemplateBaseProgress.normalViewsBuild$default(this, context, statusBarNotification, true, false, false, false, view2, 56, null);
        o.d((Object)view);
        TemplateBaseProgress.normalViewsBuild$default(this, context, statusBarNotification, true, false, false, false, view, 56, null);
        o.d((Object)context2);
        TemplateBaseProgress.normalViewsBuild$default(this, context, statusBarNotification, true, false, false, false, (View)context2, 56, null);
        focusNotificationContent.setTinyView((View)contextUtils);
        focusNotificationContent.setTinyKeyguardView(view4);
        focusNotificationContent.setTinyViewDark(view3);
        focusNotificationContent.setTinyViewModal(view2);
        focusNotificationContent.setTinyViewDarkModal(view);
        focusNotificationContent.setTinyViewKeyguardDark((View)context2);
    }

    @Override
    public void handleAodAndStatusBar(StatusBarNotification statusBarNotification, Context context) {
        o.g((Object)statusBarNotification, (String)"sbn");
        o.g((Object)context, (String)"ctx");
        if (this.getAodTitle() != null && !TextUtils.isEmpty((CharSequence)this.getAodTitle())) {
            super.handleAodAndStatusBar(statusBarNotification, context);
        } else if (o.c((Object)this.getScene(), (Object)"carHailing")) {
            statusBarNotification.getNotification().extras.putString("miui.focus.ticker", this.getTicker());
            context = new RemoteViews(context.getPackageName(), R.layout.focus_notification_template_aod_v2);
            this.setAodTextVisibleAndText((RemoteViews)context, this.getTitle());
            statusBarNotification.getNotification().extras.putInt("miui.focus.aodIconId", R.id.focus_aod_icon);
            statusBarNotification.getNotification().extras.putParcelable("miui.focus.rvAod", (Parcelable)context);
        }
    }

    @Override
    public String toString() {
        String string = TemplateBaseProgress.class.getSimpleName();
        String string2 = super.toString();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(string);
        stringBuilder.append(" ");
        stringBuilder.append(string2);
        return stringBuilder.toString();
    }
}
