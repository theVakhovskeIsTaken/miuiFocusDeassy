/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.service.notification.StatusBarNotification
 *  android.view.LayoutInflater
 *  android.view.View
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
import com.android.systemui.miui.notification.R;
import com.android.systemui.plugins.miui.notification.FocusNotificationContent;
import kotlin.jvm.internal.o;
import miui.systemui.notification.focus.template.FocusTemplate;
import miui.systemui.notification.focus.template.SceneName;
import miui.systemui.util.ContextUtils;
import org.json.JSONObject;

@SceneName(sceneNames={"anniversary", "templateRevertOversizeScene"})
public final class TemplateRevertOversize
extends FocusTemplate {
    public TemplateRevertOversize(JSONObject jSONObject) {
        o.g((Object)jSONObject, (String)"param");
        super(jSONObject);
    }

    private final void normalViewsBuild(Context context, StatusBarNotification statusBarNotification, boolean bl, boolean bl2, View view) {
        this.setTextVisibleAndText(view);
        FocusTemplate.setRemoteViewsBackground$default(this, context, view, statusBarNotification, bl, bl2, false, 32, null);
    }

    public static /* synthetic */ void normalViewsBuild$default(TemplateRevertOversize templateRevertOversize, Context context, StatusBarNotification statusBarNotification, boolean bl, boolean bl2, View view, int n, Object object) {
        if ((n & 8) != 0) {
            bl2 = false;
        }
        templateRevertOversize.normalViewsBuild(context, statusBarNotification, bl, bl2, view);
    }

    @Override
    public void buildDecoLandViews(Context context, StatusBarNotification statusBarNotification, FocusNotificationContent focusNotificationContent) {
        o.g((Object)context, (String)"ctx");
        o.g((Object)statusBarNotification, (String)"sbn");
        o.g((Object)focusNotificationContent, (String)"focusContent");
    }

    @Override
    public void buildDecoPortViews(Context context, StatusBarNotification statusBarNotification, FocusNotificationContent focusNotificationContent) {
        o.g((Object)context, (String)"ctx");
        o.g((Object)statusBarNotification, (String)"sbn");
        o.g((Object)focusNotificationContent, (String)"focusContent");
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
            view4 = LayoutInflater.from((Context)context2).inflate(R.layout.focus_notification_template_revert_oversize, null);
        }
        view3 = view2 = focusNotificationContent.getFocusNotificationDark();
        if (view2 == null) {
            view3 = LayoutInflater.from((Context)context3).inflate(R.layout.focus_notification_template_revert_oversize, null);
        }
        view2 = view = focusNotificationContent.getFocusNotificationModal();
        if (view == null) {
            view2 = LayoutInflater.from((Context)context2).inflate(R.layout.focus_notification_template_revert_oversize, null);
            view2.setTag(R.id.dynamic_island_modal_tag, (Object)Boolean.TRUE);
        }
        context2 = focusNotificationContent.getFocusNotificationDarkModal();
        view = context2;
        if (context2 == null) {
            view = LayoutInflater.from((Context)context3).inflate(R.layout.focus_notification_template_revert_oversize, null);
            view.setTag(R.id.dynamic_island_modal_tag, (Object)Boolean.TRUE);
        }
        Context context4 = contextUtils.getNightContext(context, true);
        contextUtils = focusNotificationContent.getIslandExpandedView();
        context2 = contextUtils;
        if (contextUtils == null) {
            context2 = LayoutInflater.from((Context)context4).inflate(R.layout.focus_notification_template_revert_oversize, null);
        }
        context3 = focusNotificationContent.getIslandExpandedViewFake();
        contextUtils = context3;
        if (context3 == null) {
            contextUtils = LayoutInflater.from((Context)context4).inflate(R.layout.focus_notification_template_revert_oversize, null);
        }
        o.d((Object)view4);
        TemplateRevertOversize.normalViewsBuild$default(this, context, statusBarNotification, false, false, view4, 8, null);
        o.d((Object)view3);
        TemplateRevertOversize.normalViewsBuild$default(this, context, statusBarNotification, false, false, view3, 8, null);
        o.d((Object)view2);
        TemplateRevertOversize.normalViewsBuild$default(this, context, statusBarNotification, false, false, view2, 8, null);
        o.d((Object)view);
        TemplateRevertOversize.normalViewsBuild$default(this, context, statusBarNotification, false, false, view, 8, null);
        o.d((Object)context2);
        this.normalViewsBuild(context, statusBarNotification, false, true, (View)context2);
        o.d((Object)contextUtils);
        this.normalViewsBuild(context, statusBarNotification, false, true, (View)contextUtils);
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
            contextUtils = LayoutInflater.from((Context)context2).inflate(R.layout.focus_notification_template_revert_oversize, null);
        }
        view4 = view3 = focusNotificationContent.getTinyKeyguardView();
        if (view3 == null) {
            view4 = LayoutInflater.from((Context)context2).inflate(R.layout.focus_notification_template_revert_oversize, null);
        }
        view3 = view2 = focusNotificationContent.getTinyViewDark();
        if (view2 == null) {
            view3 = LayoutInflater.from((Context)context3).inflate(R.layout.focus_notification_template_revert_oversize, null);
        }
        view2 = view = focusNotificationContent.getTinyViewModal();
        if (view == null) {
            view2 = LayoutInflater.from((Context)context2).inflate(R.layout.focus_notification_template_revert_oversize, null);
        }
        context2 = focusNotificationContent.getTinyViewDarkModal();
        view = context2;
        if (context2 == null) {
            view = LayoutInflater.from((Context)context3).inflate(R.layout.focus_notification_template_revert_oversize, null);
        }
        View view5 = focusNotificationContent.getTinyViewKeyguardDark();
        context2 = view5;
        if (view5 == null) {
            context2 = LayoutInflater.from((Context)context3).inflate(R.layout.focus_notification_template_revert_oversize, null);
        }
        o.d((Object)contextUtils);
        TemplateRevertOversize.normalViewsBuild$default(this, context, statusBarNotification, true, false, (View)contextUtils, 8, null);
        o.d((Object)view4);
        TemplateRevertOversize.normalViewsBuild$default(this, context, statusBarNotification, true, false, view4, 8, null);
        o.d((Object)view3);
        TemplateRevertOversize.normalViewsBuild$default(this, context, statusBarNotification, true, false, view3, 8, null);
        o.d((Object)view2);
        TemplateRevertOversize.normalViewsBuild$default(this, context, statusBarNotification, true, false, view2, 8, null);
        o.d((Object)view);
        TemplateRevertOversize.normalViewsBuild$default(this, context, statusBarNotification, true, false, view, 8, null);
        o.d((Object)context2);
        TemplateRevertOversize.normalViewsBuild$default(this, context, statusBarNotification, true, false, (View)context2, 8, null);
        focusNotificationContent.setTinyView((View)contextUtils);
        focusNotificationContent.setTinyKeyguardView(view4);
        focusNotificationContent.setTinyViewDark(view3);
        focusNotificationContent.setTinyViewModal(view2);
        focusNotificationContent.setTinyViewDarkModal(view);
        focusNotificationContent.setTinyViewKeyguardDark((View)context2);
    }

    @Override
    public String toString() {
        String string = TemplateRevertOversize.class.getSimpleName();
        String string2 = super.toString();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(string);
        stringBuilder.append(" ");
        stringBuilder.append(string2);
        return stringBuilder.toString();
    }
}
