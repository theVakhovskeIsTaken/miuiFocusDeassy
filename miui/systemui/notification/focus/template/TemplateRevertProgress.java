/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.service.notification.StatusBarNotification
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.widget.ImageView
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
import android.service.notification.StatusBarNotification;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.android.systemui.miui.notification.R;
import com.android.systemui.plugins.miui.notification.FocusNotificationContent;
import kotlin.jvm.internal.o;
import miui.systemui.notification.focus.template.FocusTemplate;
import miui.systemui.notification.focus.template.SceneName;
import miui.systemui.util.ContextUtils;
import org.json.JSONObject;

@SceneName(sceneNames={"foodDelivery", "templateRevertProgressScene"})
public final class TemplateRevertProgress
extends FocusTemplate {
    private final int progress;
    private final int progressCount;
    private final boolean showSmallIcon;
    private final String subtitle;

    public TemplateRevertProgress(JSONObject jSONObject) {
        o.g((Object)jSONObject, (String)"param");
        super(jSONObject);
        this.subtitle = jSONObject.optString("subTitle");
        this.progress = jSONObject.optInt("progress", -1);
        this.progressCount = jSONObject.optInt("progressCount", 0);
        this.showSmallIcon = jSONObject.optBoolean("showSmallIcon", true);
    }

    private final void normalViewsBuild(Context context, StatusBarNotification statusBarNotification, boolean bl, boolean bl2, boolean bl3, boolean bl4, View view) {
        int n;
        this.resetViewState(view);
        TextView textView = (TextView)view.findViewById(R.id.focus_title);
        Object object = (TextView)view.findViewById(R.id.focus_subtitle);
        TextView textView2 = (TextView)view.findViewById(R.id.focus_content);
        if (textView != null) {
            textView.setMaxEms(10);
        }
        this.setTextVisibleAndText(view);
        String string = this.subtitle;
        if (string != null && string.length() > 0 && bl3 && textView != null) {
            textView.setSingleLine();
        }
        if ((string = this.subtitle) != null && !o.c((Object)string, (Object)"")) {
            if (object != null) {
                object.setVisibility(0);
            }
            if (object != null) {
                object.setText((CharSequence)string);
            }
            this.setHaveSubTitle(true);
        }
        if (bl2) {
            if (textView != null) {
                textView.setMaxLines(3);
            }
            if (object != null) {
                object.setSingleLine();
            }
            if (this.getTitle().length() > 10) {
                string = this.subtitle;
                o.d((Object)string);
                if (string.length() == 0 && textView2 != null) {
                    textView2.setMaxLines(2);
                }
            }
            if (this.getTitle().length() > 10) {
                string = this.subtitle;
                o.d((Object)string);
                if (string.length() > 0 && textView2 != null) {
                    textView2.setMaxLines(1);
                }
            }
            if (5 <= (n = this.getTitle().length()) && n < 11) {
                string = this.subtitle;
                o.d((Object)string);
                if (string.length() == 0 && textView2 != null) {
                    textView2.setMaxLines(3);
                }
            }
            if (5 <= (n = this.getTitle().length()) && n < 11) {
                string = this.subtitle;
                o.d((Object)string);
                if (string.length() > 0 && textView2 != null) {
                    textView2.setMaxLines(2);
                }
            }
            if (1 <= (n = this.getTitle().length()) && n < 6) {
                string = this.subtitle;
                o.d((Object)string);
                if (string.length() == 0 && textView2 != null) {
                    textView2.setMaxLines(4);
                }
            }
            if (1 <= (n = this.getTitle().length()) && n < 6) {
                string = this.subtitle;
                o.d((Object)string);
                if (string.length() > 0 && textView2 != null) {
                    textView2.setMaxLines(3);
                }
            }
        }
        this.setRemoteViewsBackground(context, view, statusBarNotification, bl, bl4, false);
        this.setRemoteViewsProfilePicture(context, view, statusBarNotification, bl, bl4);
        if (this.isSolidBackground() && !this.isBgPicDownloadFail()) {
            if (this.getTitleColor() != null) {
                if (textView != null) {
                    textView.setTextColor(this.getTitleColor().intValue());
                }
                if (object != null) {
                    object.setTextColor(this.getTitleColor().intValue());
                }
            }
            if ((object = this.getContentColor()) != null) {
                n = ((Number)object).intValue();
                if (textView2 != null) {
                    textView2.setTextColor(n);
                }
            }
            if (this.getDescColor() != null) {
                this.setDescTextColor(view, this.getDescColor());
            }
        }
        FocusTemplate.setRemoteViewsProgress$default(this, context, view, this.progress, this.progressCount, bl, bl2, bl3, bl4, 0, statusBarNotification, false, 256, null);
        if (!this.showSmallIcon) {
            context = (ImageView)view.findViewById(R.id.focus_small_icon);
            if (context != null) {
                context.setVisibility(8);
            }
        } else if ((view = (ImageView)view.findViewById(R.id.focus_small_icon)) != null) {
            view.setVisibility(0);
            this.showAppIcon(context, (ImageView)view, statusBarNotification);
        }
        this.resetTemplateState();
    }

    public static /* synthetic */ void normalViewsBuild$default(TemplateRevertProgress templateRevertProgress, Context context, StatusBarNotification statusBarNotification, boolean bl, boolean bl2, boolean bl3, boolean bl4, View view, int n, Object object) {
        if ((n & 8) != 0) {
            bl2 = false;
        }
        if ((n & 0x10) != 0) {
            bl3 = false;
        }
        if ((n & 0x20) != 0) {
            bl4 = false;
        }
        templateRevertProgress.normalViewsBuild(context, statusBarNotification, bl, bl2, bl3, bl4, view);
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
            view3 = LayoutInflater.from((Context)ContextUtils.INSTANCE.getDayContext(context)).inflate(R.layout.focus_notification_template_revert_progress_deco_land, null);
        }
        view2 = view = focusNotificationContent.getDecoLandDark();
        if (view == null) {
            view2 = LayoutInflater.from((Context)ContextUtils.getNightContext$default((ContextUtils)ContextUtils.INSTANCE, (Context)context, (boolean)false, (int)2, null)).inflate(R.layout.focus_notification_template_revert_progress_deco_land, null);
        }
        o.d((Object)view3);
        TemplateRevertProgress.normalViewsBuild$default(this, context, statusBarNotification, false, false, true, false, view3, 40, null);
        o.d((Object)view2);
        TemplateRevertProgress.normalViewsBuild$default(this, context, statusBarNotification, false, false, true, false, view2, 40, null);
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
            view3 = LayoutInflater.from((Context)ContextUtils.INSTANCE.getDayContext(context)).inflate(R.layout.focus_notification_template_revert_progress_deco_port, null);
        }
        view2 = view = focusNotificationContent.getDecoDark();
        if (view == null) {
            view2 = LayoutInflater.from((Context)ContextUtils.getNightContext$default((ContextUtils)ContextUtils.INSTANCE, (Context)context, (boolean)false, (int)2, null)).inflate(R.layout.focus_notification_template_revert_progress_deco_port, null);
        }
        o.d((Object)view3);
        TemplateRevertProgress.normalViewsBuild$default(this, context, statusBarNotification, false, true, false, false, view3, 48, null);
        o.d((Object)view2);
        TemplateRevertProgress.normalViewsBuild$default(this, context, statusBarNotification, false, true, false, false, view2, 48, null);
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
            view4 = LayoutInflater.from((Context)context2).inflate(R.layout.focus_notification_template_revert_progress, null);
        }
        view3 = view2 = focusNotificationContent.getFocusNotificationDark();
        if (view2 == null) {
            view3 = LayoutInflater.from((Context)context3).inflate(R.layout.focus_notification_template_revert_progress, null);
        }
        view2 = view = focusNotificationContent.getFocusNotificationModal();
        if (view == null) {
            view2 = LayoutInflater.from((Context)context2).inflate(R.layout.focus_notification_template_revert_progress, null);
            view2.setTag(R.id.dynamic_island_modal_tag, (Object)Boolean.TRUE);
        }
        context2 = focusNotificationContent.getFocusNotificationDarkModal();
        view = context2;
        if (context2 == null) {
            view = LayoutInflater.from((Context)context3).inflate(R.layout.focus_notification_template_revert_progress, null);
            view.setTag(R.id.dynamic_island_modal_tag, (Object)Boolean.TRUE);
        }
        Context context4 = contextUtils.getNightContext(context, true);
        contextUtils = focusNotificationContent.getIslandExpandedView();
        context2 = contextUtils;
        if (contextUtils == null) {
            context2 = LayoutInflater.from((Context)context4).inflate(R.layout.focus_notification_template_revert_progress, null);
        }
        context3 = focusNotificationContent.getIslandExpandedViewFake();
        contextUtils = context3;
        if (context3 == null) {
            contextUtils = LayoutInflater.from((Context)context4).inflate(R.layout.focus_notification_template_revert_progress, null);
        }
        o.d((Object)view4);
        TemplateRevertProgress.normalViewsBuild$default(this, context, statusBarNotification, false, false, false, false, view4, 56, null);
        o.d((Object)view3);
        TemplateRevertProgress.normalViewsBuild$default(this, context, statusBarNotification, false, false, false, false, view3, 56, null);
        o.d((Object)view2);
        TemplateRevertProgress.normalViewsBuild$default(this, context, statusBarNotification, false, false, false, false, view2, 56, null);
        o.d((Object)view);
        TemplateRevertProgress.normalViewsBuild$default(this, context, statusBarNotification, false, false, false, false, view, 56, null);
        o.d((Object)context2);
        TemplateRevertProgress.normalViewsBuild$default(this, context, statusBarNotification, false, false, false, true, (View)context2, 24, null);
        o.d((Object)contextUtils);
        TemplateRevertProgress.normalViewsBuild$default(this, context, statusBarNotification, false, false, false, true, (View)contextUtils, 24, null);
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
            contextUtils = LayoutInflater.from((Context)context2).inflate(R.layout.focus_notification_template_revert_progress_tiny, null);
        }
        view4 = view3 = focusNotificationContent.getTinyKeyguardView();
        if (view3 == null) {
            view4 = LayoutInflater.from((Context)context2).inflate(R.layout.focus_notification_template_revert_progress_tiny, null);
        }
        view3 = view2 = focusNotificationContent.getTinyViewDark();
        if (view2 == null) {
            view3 = LayoutInflater.from((Context)context3).inflate(R.layout.focus_notification_template_revert_progress_tiny, null);
        }
        view2 = view = focusNotificationContent.getTinyViewModal();
        if (view == null) {
            view2 = LayoutInflater.from((Context)context2).inflate(R.layout.focus_notification_template_revert_progress_tiny, null);
            view2.setTag(R.id.dynamic_island_modal_tag, (Object)Boolean.TRUE);
        }
        context2 = focusNotificationContent.getTinyViewDarkModal();
        view = context2;
        if (context2 == null) {
            view = LayoutInflater.from((Context)context3).inflate(R.layout.focus_notification_template_revert_progress_tiny, null);
            view.setTag(R.id.dynamic_island_modal_tag, (Object)Boolean.TRUE);
        }
        View view5 = focusNotificationContent.getTinyViewKeyguardDark();
        context2 = view5;
        if (view5 == null) {
            context2 = LayoutInflater.from((Context)context3).inflate(R.layout.focus_notification_template_revert_progress_tiny, null);
        }
        o.d((Object)contextUtils);
        TemplateRevertProgress.normalViewsBuild$default(this, context, statusBarNotification, true, false, false, false, (View)contextUtils, 56, null);
        o.d((Object)view4);
        TemplateRevertProgress.normalViewsBuild$default(this, context, statusBarNotification, true, false, false, false, view4, 56, null);
        o.d((Object)view3);
        TemplateRevertProgress.normalViewsBuild$default(this, context, statusBarNotification, true, false, false, false, view3, 56, null);
        o.d((Object)view2);
        TemplateRevertProgress.normalViewsBuild$default(this, context, statusBarNotification, true, false, false, false, view2, 56, null);
        o.d((Object)view);
        TemplateRevertProgress.normalViewsBuild$default(this, context, statusBarNotification, true, false, false, false, view, 56, null);
        o.d((Object)context2);
        TemplateRevertProgress.normalViewsBuild$default(this, context, statusBarNotification, true, false, false, false, (View)context2, 56, null);
        focusNotificationContent.setTinyView((View)contextUtils);
        focusNotificationContent.setTinyKeyguardView(view4);
        focusNotificationContent.setTinyViewDark(view3);
        focusNotificationContent.setTinyViewModal(view2);
        focusNotificationContent.setTinyViewDarkModal(view);
        focusNotificationContent.setTinyViewKeyguardDark((View)context2);
    }

    @Override
    public String toString() {
        String string = TemplateRevertProgress.class.getSimpleName();
        String string2 = super.toString();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(string);
        stringBuilder.append(" ");
        stringBuilder.append(string2);
        return stringBuilder.toString();
    }
}
