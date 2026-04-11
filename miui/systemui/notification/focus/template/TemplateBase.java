/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.Notification$Action
 *  android.content.Context
 *  android.service.notification.StatusBarNotification
 *  android.view.LayoutInflater
 *  android.view.View
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
import android.service.notification.StatusBarNotification;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import com.android.systemui.miui.notification.R;
import com.android.systemui.plugins.miui.notification.FocusNotificationContent;
import kotlin.jvm.internal.o;
import miui.systemui.notification.focus.template.FocusTemplate;
import miui.systemui.notification.focus.template.SceneName;
import miui.systemui.util.ContextUtils;
import org.json.JSONObject;

@SceneName(sceneNames={"smartHomeAlert", "sos", "missedCalls", "templateBaseScene"})
public final class TemplateBase
extends FocusTemplate {
    public TemplateBase(JSONObject jSONObject) {
        o.g((Object)jSONObject, (String)"param");
        super(jSONObject);
    }

    private final void normalViewsBuild(Context context, StatusBarNotification statusBarNotification, boolean bl, boolean bl2, boolean bl3, boolean bl4, View object) {
        int n;
        Object object2;
        this.resetViewState((View)object);
        this.setTextVisibleAndText((View)object);
        if (bl2 && bl3) {
            Object object3 = this.getParam().optString("content");
            o.d((Object)object3);
            if (object3.length() > 0) {
                object2 = (TextView)object.findViewById(R.id.focus_content_sos);
                if (object2 != null) {
                    object2.setVisibility(0);
                }
                if (object2 != null) {
                    object2.setText((CharSequence)object3);
                }
                object3 = this.getContentColor();
                if (object3 != null) {
                    n = ((Number)object3).intValue();
                    if (object2 != null) {
                        object2.setTextColor(n);
                    }
                }
            }
            if (this.getDesc1().length() > 0) {
                object3 = (TextView)object.findViewById(R.id.focus_desc1);
                if (object3 != null) {
                    object3.setVisibility(0);
                }
                if (object3 != null) {
                    object3.setText((CharSequence)this.getDesc1());
                }
                object2 = this.getDescColor();
                if (object2 != null) {
                    n = ((Number)object2).intValue();
                    if (object3 != null) {
                        object3.setTextColor(n);
                    }
                }
            }
            if (this.getDesc2().length() > 0) {
                object3 = (TextView)object.findViewById(R.id.focus_desc2);
                if (object3 != null) {
                    object3.setVisibility(0);
                }
                if (object3 != null) {
                    object3.setText((CharSequence)this.getDesc2());
                }
                object2 = this.getDescColor();
                if (object2 != null) {
                    n = ((Number)object2).intValue();
                    if (object3 != null) {
                        object3.setTextColor(n);
                    }
                }
            }
        }
        if (bl2 && !bl3 && (object2 = (TextView)object.findViewById(R.id.focus_title)) != null) {
            object2.setMaxLines(1);
        }
        n = R.id.focus_button_icon1;
        object2 = this.getActionBundle();
        object2 = object2 != null ? (Notification.Action)object2.getParcelable("miui.focus.action_1") : null;
        this.setActionData((View)object, n, (Notification.Action)object2, bl2, bl3);
        n = R.id.focus_button_icon2;
        object2 = this.getActionBundle();
        object2 = object2 != null ? (Notification.Action)object2.getParcelable("miui.focus.action_2") : null;
        this.setActionData((View)object, n, (Notification.Action)object2, bl2, bl3);
        FocusTemplate.setRemoteViewsBackground$default(this, context, (View)object, statusBarNotification, bl, bl4, false, 32, null);
        if (this.isSolidBackground() && !this.isBgPicDownloadFail()) {
            object2 = (TextView)object.findViewById(R.id.focus_title);
            context = (TextView)object.findViewById(R.id.focus_content);
            statusBarNotification = (TextView)object.findViewById(R.id.focus_desc);
            object = this.getTitleColor();
            if (object != null) {
                n = ((Number)object).intValue();
                if (object2 != null) {
                    object2.setTextColor(n);
                }
            }
            if ((object = this.getContentColor()) != null) {
                n = ((Number)object).intValue();
                if (context != null) {
                    context.setTextColor(n);
                }
            }
            if ((object = this.getDescColor()) != null) {
                n = ((Number)object).intValue();
                if (statusBarNotification != null) {
                    statusBarNotification.setTextColor(n);
                }
                if (this.isNotHaveContent() && context != null) {
                    context.setTextColor(n);
                }
            }
        }
        this.resetTemplateState();
    }

    public static /* synthetic */ void normalViewsBuild$default(TemplateBase templateBase, Context context, StatusBarNotification statusBarNotification, boolean bl, boolean bl2, boolean bl3, boolean bl4, View view, int n, Object object) {
        if ((n & 8) != 0) {
            bl2 = false;
        }
        if ((n & 0x10) != 0) {
            bl3 = false;
        }
        if ((n & 0x20) != 0) {
            bl4 = false;
        }
        templateBase.normalViewsBuild(context, statusBarNotification, bl, bl2, bl3, bl4, view);
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
            view3 = LayoutInflater.from((Context)ContextUtils.INSTANCE.getDayContext(context)).inflate(R.layout.focus_notification_template_base_deco_land, null);
        }
        view2 = view = focusNotificationContent.getDecoLandDark();
        if (view == null) {
            view2 = LayoutInflater.from((Context)ContextUtils.getNightContext$default((ContextUtils)ContextUtils.INSTANCE, (Context)context, (boolean)false, (int)2, null)).inflate(R.layout.focus_notification_template_base_deco_land, null);
        }
        o.d((Object)view3);
        TemplateBase.normalViewsBuild$default(this, context, statusBarNotification, true, true, false, false, view3, 48, null);
        o.d((Object)view2);
        TemplateBase.normalViewsBuild$default(this, context, statusBarNotification, true, true, false, false, view2, 48, null);
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
            view3 = LayoutInflater.from((Context)ContextUtils.INSTANCE.getDayContext(context)).inflate(R.layout.focus_notification_template_base_deco_prot, null);
        }
        view2 = view = focusNotificationContent.getDecoDark();
        if (view == null) {
            view2 = LayoutInflater.from((Context)ContextUtils.getNightContext$default((ContextUtils)ContextUtils.INSTANCE, (Context)context, (boolean)false, (int)2, null)).inflate(R.layout.focus_notification_template_base_deco_prot, null);
        }
        o.d((Object)view3);
        TemplateBase.normalViewsBuild$default(this, context, statusBarNotification, true, true, true, false, view3, 32, null);
        o.d((Object)view2);
        TemplateBase.normalViewsBuild$default(this, context, statusBarNotification, true, true, true, false, view2, 32, null);
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
            view4 = LayoutInflater.from((Context)context2).inflate(R.layout.focus_notification_template_base, null);
        }
        view3 = view2 = focusNotificationContent.getFocusNotificationDark();
        if (view2 == null) {
            view3 = LayoutInflater.from((Context)context3).inflate(R.layout.focus_notification_template_base, null);
        }
        view2 = view = focusNotificationContent.getFocusNotificationModal();
        if (view == null) {
            view2 = LayoutInflater.from((Context)context2).inflate(R.layout.focus_notification_template_base, null);
            view2.setTag(R.id.dynamic_island_modal_tag, (Object)Boolean.TRUE);
        }
        context2 = focusNotificationContent.getFocusNotificationDarkModal();
        view = context2;
        if (context2 == null) {
            view = LayoutInflater.from((Context)context3).inflate(R.layout.focus_notification_template_base, null);
            view.setTag(R.id.dynamic_island_modal_tag, (Object)Boolean.TRUE);
        }
        Context context4 = contextUtils.getNightContext(context, true);
        contextUtils = focusNotificationContent.getIslandExpandedView();
        context2 = contextUtils;
        if (contextUtils == null) {
            context2 = LayoutInflater.from((Context)context4).inflate(R.layout.focus_notification_template_base, null);
        }
        context3 = focusNotificationContent.getIslandExpandedViewFake();
        contextUtils = context3;
        if (context3 == null) {
            contextUtils = LayoutInflater.from((Context)context4).inflate(R.layout.focus_notification_template_base, null);
        }
        o.d((Object)view4);
        TemplateBase.normalViewsBuild$default(this, context, statusBarNotification, false, false, false, false, view4, 56, null);
        o.d((Object)view3);
        TemplateBase.normalViewsBuild$default(this, context, statusBarNotification, false, false, false, false, view3, 56, null);
        o.d((Object)view2);
        TemplateBase.normalViewsBuild$default(this, context, statusBarNotification, false, false, false, false, view2, 56, null);
        o.d((Object)view);
        TemplateBase.normalViewsBuild$default(this, context, statusBarNotification, false, false, false, false, view, 56, null);
        o.d((Object)context2);
        TemplateBase.normalViewsBuild$default(this, context, statusBarNotification, false, false, false, true, (View)context2, 24, null);
        o.d((Object)contextUtils);
        TemplateBase.normalViewsBuild$default(this, context, statusBarNotification, false, false, false, true, (View)contextUtils, 24, null);
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
            contextUtils = LayoutInflater.from((Context)context2).inflate(R.layout.focus_notification_template_base_tiny, null);
        }
        view4 = view3 = focusNotificationContent.getTinyKeyguardView();
        if (view3 == null) {
            view4 = LayoutInflater.from((Context)context2).inflate(R.layout.focus_notification_template_base_tiny, null);
        }
        view3 = view2 = focusNotificationContent.getTinyViewDark();
        if (view2 == null) {
            view3 = LayoutInflater.from((Context)context3).inflate(R.layout.focus_notification_template_base_tiny, null);
        }
        view2 = view = focusNotificationContent.getTinyViewModal();
        if (view == null) {
            view2 = LayoutInflater.from((Context)context2).inflate(R.layout.focus_notification_template_base_tiny, null);
        }
        context2 = focusNotificationContent.getTinyViewDarkModal();
        view = context2;
        if (context2 == null) {
            view = LayoutInflater.from((Context)context3).inflate(R.layout.focus_notification_template_base_tiny, null);
        }
        View view5 = focusNotificationContent.getTinyViewKeyguardDark();
        context2 = view5;
        if (view5 == null) {
            context2 = LayoutInflater.from((Context)context3).inflate(R.layout.focus_notification_template_base_tiny, null);
        }
        o.d((Object)contextUtils);
        TemplateBase.normalViewsBuild$default(this, context, statusBarNotification, true, false, false, false, (View)contextUtils, 56, null);
        o.d((Object)view4);
        TemplateBase.normalViewsBuild$default(this, context, statusBarNotification, true, false, false, false, view4, 56, null);
        o.d((Object)view3);
        TemplateBase.normalViewsBuild$default(this, context, statusBarNotification, true, false, false, false, view3, 56, null);
        o.d((Object)view2);
        TemplateBase.normalViewsBuild$default(this, context, statusBarNotification, true, false, false, false, view2, 56, null);
        o.d((Object)view);
        TemplateBase.normalViewsBuild$default(this, context, statusBarNotification, true, false, false, false, view, 56, null);
        o.d((Object)context2);
        TemplateBase.normalViewsBuild$default(this, context, statusBarNotification, true, false, false, false, (View)context2, 56, null);
        focusNotificationContent.setTinyView((View)contextUtils);
        focusNotificationContent.setTinyKeyguardView(view4);
        focusNotificationContent.setTinyViewDark(view3);
        focusNotificationContent.setTinyViewModal(view2);
        focusNotificationContent.setTinyViewDarkModal(view);
        focusNotificationContent.setTinyViewKeyguardDark((View)context2);
    }

    @Override
    public String toString() {
        String string = TemplateBase.class.getSimpleName();
        String string2 = super.toString();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(string);
        stringBuilder.append(" ");
        stringBuilder.append(string2);
        return stringBuilder.toString();
    }
}
