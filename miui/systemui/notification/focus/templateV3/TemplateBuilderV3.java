/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  F0.a
 *  G0.k
 *  G0.s
 *  K0.d
 *  L0.c
 *  U0.o
 *  android.content.Context
 *  android.service.notification.StatusBarNotification
 *  android.util.Log
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.ViewGroup
 *  android.widget.FrameLayout
 *  com.android.systemui.miui.notification.R$id
 *  com.android.systemui.miui.notification.R$layout
 *  com.android.systemui.plugins.miui.notification.FocusNotificationContent
 *  f1.E
 *  f1.f
 *  kotlin.jvm.internal.o
 *  miui.systemui.util.concurrency.ConcurrencyModule
 */
package miui.systemui.notification.focus.templateV3;

import F0.a;
import G0.k;
import G0.s;
import K0.d;
import L0.c;
import android.content.Context;
import android.service.notification.StatusBarNotification;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.android.systemui.miui.notification.R;
import com.android.systemui.plugins.miui.notification.FocusNotificationContent;
import f1.E;
import f1.f;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.o;
import miui.systemui.notification.focus.model.IconTextInfo;
import miui.systemui.notification.focus.model.Template;
import miui.systemui.notification.focus.model.TextAndColorInfo;
import miui.systemui.notification.focus.moduleV3.ModuleViewHolderAdapter;
import miui.systemui.util.concurrency.ConcurrencyModule;

public final class TemplateBuilderV3 {
    public static final Companion Companion = new Object(null){
        {
            this();
        }
    };
    public static final String DEBUG_TAG = "EmptyNotif";
    public static final String TAG = "TemplateBuilderV3";
    private final Context context;
    private ModuleViewHolderAdapter focusAdapter;
    private ModuleViewHolderAdapter focusDarkAdapter;
    private View focusDarkLayout;
    private View focusLayout;
    private ModuleViewHolderAdapter focusModalAdapter;
    private ModuleViewHolderAdapter focusModalDarkAdapter;
    private View focusModalDarkLayout;
    private View focusModalLayout;
    private boolean iconTextInfoHasIcon;
    private boolean isFlipDevice;
    private ModuleViewHolderAdapter islandAdapter;
    private ModuleViewHolderAdapter islandFakeAdapter;
    private View islandLayout;
    private View islandLayoutFake;
    private String moduleA;
    private String moduleC;
    private String moduleD;
    private final a moduleViewHolderAdapterProvider;
    private final Map<Integer, View> viewMap;

    public TemplateBuilderV3(Context context, boolean bl, a object) {
        o.g((Object)context, (String)"context");
        o.g((Object)object, (String)"moduleViewHolderAdapterProvider");
        this.context = context;
        this.isFlipDevice = bl;
        this.moduleViewHolderAdapterProvider = object;
        this.viewMap = new LinkedHashMap<Integer, View>();
        this.moduleA = "";
        this.moduleC = "";
        this.moduleD = "";
        this.iconTextInfoHasIcon = true;
        object = LayoutInflater.from((Context)context);
        int n = R.layout.focus_notification_template_standard;
        this.islandLayout = object.inflate(n, null);
        this.islandLayoutFake = LayoutInflater.from((Context)context).inflate(n, null);
        this.focusLayout = LayoutInflater.from((Context)context).inflate(n, null);
        this.focusDarkLayout = LayoutInflater.from((Context)context).inflate(n, null);
        View view = LayoutInflater.from((Context)context).inflate(n, null);
        int n2 = R.id.dynamic_island_modal_tag;
        object = Boolean.TRUE;
        view.setTag(n2, object);
        this.focusModalLayout = view;
        context = LayoutInflater.from((Context)context).inflate(n, null);
        context.setTag(n2, object);
        this.focusModalDarkLayout = context;
    }

    public static final /* synthetic */ View access$getFocusDarkLayout$p(TemplateBuilderV3 templateBuilderV3) {
        return templateBuilderV3.focusDarkLayout;
    }

    public static final /* synthetic */ View access$getFocusLayout$p(TemplateBuilderV3 templateBuilderV3) {
        return templateBuilderV3.focusLayout;
    }

    public static final /* synthetic */ View access$getFocusModalDarkLayout$p(TemplateBuilderV3 templateBuilderV3) {
        return templateBuilderV3.focusModalDarkLayout;
    }

    public static final /* synthetic */ View access$getFocusModalLayout$p(TemplateBuilderV3 templateBuilderV3) {
        return templateBuilderV3.focusModalLayout;
    }

    public static final /* synthetic */ View access$getIslandLayout$p(TemplateBuilderV3 templateBuilderV3) {
        return templateBuilderV3.islandLayout;
    }

    public static final /* synthetic */ View access$getIslandLayoutFake$p(TemplateBuilderV3 templateBuilderV3) {
        return templateBuilderV3.islandLayoutFake;
    }

    private final void addFocusDarkView(int n, String string, boolean bl, Template object, StatusBarNotification statusBarNotification) {
        ModuleViewHolderAdapter moduleViewHolderAdapter;
        Object object2 = this.focusDarkLayout;
        object2 = object2 != null ? (FrameLayout)object2.findViewById(n) : null;
        if (this.focusDarkAdapter == null) {
            this.focusDarkAdapter = (ModuleViewHolderAdapter)this.moduleViewHolderAdapterProvider.get();
        }
        if ((moduleViewHolderAdapter = this.focusDarkAdapter) != null) {
            boolean bl2 = this.isFlipDevice;
            o.e((Object)object2, (String)"null cannot be cast to non-null type android.view.ViewGroup");
            ModuleViewHolderAdapter.createModuleViewHolder$default(moduleViewHolderAdapter, (Template)object, statusBarNotification, string, true, bl, bl2, (ViewGroup)object2, false, false, 384, null);
        }
        if ((object = this.focusDarkAdapter) != null) {
            ((ModuleViewHolderAdapter)object).bindData(string, statusBarNotification);
        }
    }

    private final void addFocusModalDarkView(int n, String string, boolean bl, Template object, StatusBarNotification statusBarNotification) {
        ModuleViewHolderAdapter moduleViewHolderAdapter;
        Object object2 = this.focusModalDarkLayout;
        object2 = object2 != null ? (FrameLayout)object2.findViewById(n) : null;
        if (this.focusModalDarkAdapter == null) {
            this.focusModalDarkAdapter = (ModuleViewHolderAdapter)this.moduleViewHolderAdapterProvider.get();
        }
        if ((moduleViewHolderAdapter = this.focusModalDarkAdapter) != null) {
            boolean bl2 = this.isFlipDevice;
            o.e((Object)object2, (String)"null cannot be cast to non-null type android.view.ViewGroup");
            ModuleViewHolderAdapter.createModuleViewHolder$default(moduleViewHolderAdapter, (Template)object, statusBarNotification, string, true, bl, bl2, (ViewGroup)object2, false, false, 384, null);
        }
        if ((object = this.focusModalDarkAdapter) != null) {
            ((ModuleViewHolderAdapter)object).bindData(string, statusBarNotification);
        }
    }

    private final void addFocusModalView(int n, String string, boolean bl, Template object, StatusBarNotification statusBarNotification) {
        ModuleViewHolderAdapter moduleViewHolderAdapter;
        Object object2 = this.focusModalLayout;
        object2 = object2 != null ? (FrameLayout)object2.findViewById(n) : null;
        if (this.focusModalAdapter == null) {
            this.focusModalAdapter = (ModuleViewHolderAdapter)this.moduleViewHolderAdapterProvider.get();
        }
        if ((moduleViewHolderAdapter = this.focusModalAdapter) != null) {
            boolean bl2 = this.isFlipDevice;
            o.e((Object)object2, (String)"null cannot be cast to non-null type android.view.ViewGroup");
            ModuleViewHolderAdapter.createModuleViewHolder$default(moduleViewHolderAdapter, (Template)object, statusBarNotification, string, false, bl, bl2, (ViewGroup)object2, false, false, 384, null);
        }
        if ((object = this.focusModalAdapter) != null) {
            ((ModuleViewHolderAdapter)object).bindData(string, statusBarNotification);
        }
    }

    private final void addFocusView(int n, String string, boolean bl, Template object, StatusBarNotification statusBarNotification) {
        ModuleViewHolderAdapter moduleViewHolderAdapter;
        Object object2 = this.focusLayout;
        object2 = object2 != null ? (FrameLayout)object2.findViewById(n) : null;
        if (this.focusAdapter == null) {
            this.focusAdapter = (ModuleViewHolderAdapter)this.moduleViewHolderAdapterProvider.get();
        }
        if ((moduleViewHolderAdapter = this.focusAdapter) != null) {
            boolean bl2 = this.isFlipDevice;
            o.e((Object)object2, (String)"null cannot be cast to non-null type android.view.ViewGroup");
            ModuleViewHolderAdapter.createModuleViewHolder$default(moduleViewHolderAdapter, (Template)object, statusBarNotification, string, false, bl, bl2, (ViewGroup)object2, false, false, 384, null);
        }
        if ((object = this.focusAdapter) != null) {
            ((ModuleViewHolderAdapter)object).bindData(string, statusBarNotification);
        }
    }

    private final void addIsLandView(int n, String string, boolean bl, Template object, StatusBarNotification statusBarNotification) {
        ModuleViewHolderAdapter moduleViewHolderAdapter;
        if (o.c((Object)string, (Object)"moduleBackground")) {
            return;
        }
        Object object2 = this.islandLayout;
        object2 = object2 != null ? (FrameLayout)object2.findViewById(n) : null;
        if (this.islandAdapter == null) {
            this.islandAdapter = (ModuleViewHolderAdapter)this.moduleViewHolderAdapterProvider.get();
        }
        if ((moduleViewHolderAdapter = this.islandAdapter) != null) {
            boolean bl2 = this.isFlipDevice;
            o.e((Object)object2, (String)"null cannot be cast to non-null type android.view.ViewGroup");
            ModuleViewHolderAdapter.createModuleViewHolder$default(moduleViewHolderAdapter, (Template)object, statusBarNotification, string, true, bl, bl2, (ViewGroup)object2, true, false, 256, null);
        }
        if ((object = this.islandAdapter) != null) {
            ((ModuleViewHolderAdapter)object).bindData(string, statusBarNotification);
        }
    }

    private final void addIsLandViewFake(int n, String string, boolean bl, Template object, StatusBarNotification statusBarNotification) {
        ModuleViewHolderAdapter moduleViewHolderAdapter;
        if (o.c((Object)string, (Object)"moduleBackground")) {
            return;
        }
        FrameLayout frameLayout = (FrameLayout)this.islandLayoutFake.findViewById(n);
        if (this.islandFakeAdapter == null) {
            this.islandFakeAdapter = (ModuleViewHolderAdapter)this.moduleViewHolderAdapterProvider.get();
        }
        if ((moduleViewHolderAdapter = this.islandFakeAdapter) != null) {
            boolean bl2 = this.isFlipDevice;
            o.d((Object)frameLayout);
            moduleViewHolderAdapter.createModuleViewHolder((Template)object, statusBarNotification, string, true, bl, bl2, (ViewGroup)frameLayout, true, true);
        }
        if ((object = this.islandFakeAdapter) != null) {
            ((ModuleViewHolderAdapter)object).bindData(string, statusBarNotification);
        }
    }

    private final boolean isSameElement(String object, Template template) {
        boolean bl;
        boolean bl2 = o.c((Object)object, (Object)"moduleNewImageText");
        boolean bl3 = bl = false;
        if (bl2) {
            boolean bl4 = this.iconTextInfoHasIcon;
            object = template.getIconTextInfo();
            object = object != null ? ((IconTextInfo)object).getAnimIconInfo() : null;
            bl2 = object != null;
            bl3 = bl;
            if (bl4 != bl2) {
                bl3 = true;
            }
        }
        return bl3 ^ true;
    }

    public final TemplateBuilderV3 addModuleView(int n, String string, boolean bl, Template template, StatusBarNotification statusBarNotification) {
        o.g((Object)string, (String)"moduleType");
        o.g((Object)template, (String)"template");
        o.g((Object)statusBarNotification, (String)"sbn");
        if (n == R.id.area_a) {
            if (o.c((Object)string, (Object)"moduleNewImageText")) {
                TextAndColorInfo textAndColorInfo = template.getIconTextInfo();
                textAndColorInfo = textAndColorInfo != null ? textAndColorInfo.getAnimIconInfo() : null;
                boolean bl2 = textAndColorInfo != null;
                this.iconTextInfoHasIcon = bl2;
            }
            this.moduleA = string;
        } else if (n == R.id.area_c) {
            this.moduleC = string;
        } else if (n == R.id.area_d) {
            this.moduleD = string;
        }
        this.addIsLandView(n, string, bl, template, statusBarNotification);
        this.addIsLandViewFake(n, string, bl, template, statusBarNotification);
        this.addFocusView(n, string, bl, template, statusBarNotification);
        this.addFocusDarkView(n, string, bl, template, statusBarNotification);
        this.addFocusModalView(n, string, bl, template, statusBarNotification);
        this.addFocusModalDarkView(n, string, bl, template, statusBarNotification);
        return this;
    }

    public final void buildView(FocusNotificationContent focusNotificationContent, Template template) {
        o.g((Object)focusNotificationContent, (String)"focusNotificationContent");
        o.g((Object)template, (String)"template");
        template = this.focusLayout;
        String string = Thread.currentThread().getName();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("buildView: ");
        stringBuilder.append(template);
        stringBuilder.append("   ");
        stringBuilder.append(string);
        Log.d((String)DEBUG_TAG, (String)stringBuilder.toString());
        focusNotificationContent.setIslandExpandedView(this.islandLayout);
        focusNotificationContent.setIslandExpandedViewFake(this.islandLayoutFake);
        focusNotificationContent.setFocusNotification(this.focusLayout);
        focusNotificationContent.setFocusNotificationDark(this.focusDarkLayout);
        focusNotificationContent.setFocusNotificationModal(this.focusModalLayout);
        focusNotificationContent.setFocusNotificationDarkModal(this.focusModalDarkLayout);
    }

    public final boolean isSameModuleA(String string, Template template) {
        o.g((Object)string, (String)"moduleType");
        o.g((Object)template, (String)"template");
        boolean bl = this.isSameElement(string, template);
        bl = o.c((Object)string, (Object)this.moduleA) && bl;
        return bl;
    }

    public final boolean isSameModuleC(String string) {
        o.g((Object)string, (String)"moduleType");
        return o.c((Object)string, (Object)this.moduleC);
    }

    public final boolean isSameModuleD(String string) {
        o.g((Object)string, (String)"moduleType");
        return o.c((Object)string, (Object)this.moduleD);
    }

    public final TemplateBuilderV3 removeModuleView(String string) {
        o.g((Object)string, (String)"moduleType");
        ModuleViewHolderAdapter moduleViewHolderAdapter = this.islandAdapter;
        if (moduleViewHolderAdapter != null) {
            moduleViewHolderAdapter.removeView(string);
        }
        if ((moduleViewHolderAdapter = this.islandFakeAdapter) != null) {
            moduleViewHolderAdapter.removeView(string);
        }
        if ((moduleViewHolderAdapter = this.focusAdapter) != null) {
            moduleViewHolderAdapter.removeView(string);
        }
        if ((moduleViewHolderAdapter = this.focusDarkAdapter) != null) {
            moduleViewHolderAdapter.removeView(string);
        }
        if ((moduleViewHolderAdapter = this.focusModalAdapter) != null) {
            moduleViewHolderAdapter.removeView(string);
        }
        if ((moduleViewHolderAdapter = this.focusModalDarkAdapter) != null) {
            moduleViewHolderAdapter.removeView(string);
        }
        return this;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final void removeView(FocusNotificationContent focusNotificationContent) {
        o.g((Object)focusNotificationContent, (String)"focusNotificationContent");
        String string = Thread.currentThread().getName();
        Object object = new StringBuilder();
        ((StringBuilder)object).append("removeView: ");
        ((StringBuilder)object).append(string);
        Log.d((String)DEBUG_TAG, (String)((StringBuilder)object).toString());
        focusNotificationContent.setIslandExpandedView(null);
        focusNotificationContent.setIslandExpandedViewFake(null);
        focusNotificationContent.setFocusNotification(null);
        focusNotificationContent.setFocusNotificationDark(null);
        try {
            object = focusNotificationContent.getFocusNotificationViewMap();
            if (object != null) {
                object.clear();
            }
            focusNotificationContent.setFocusNotificationViewMap(null);
        }
        catch (Throwable throwable) {}
        focusNotificationContent.setFocusNotificationModal(null);
        focusNotificationContent.setFocusNotificationDarkModal(null);
        this.islandLayout = null;
        this.islandLayoutFake = null;
        this.focusLayout = null;
        this.focusDarkLayout = null;
        this.focusModalLayout = null;
        this.focusModalDarkLayout = null;
        this.islandAdapter = null;
        this.islandFakeAdapter = null;
        this.focusAdapter = null;
        this.focusDarkAdapter = null;
        this.focusModalAdapter = null;
        this.focusModalDarkAdapter = null;
    }

    public final TemplateBuilderV3 setAreaViewVisible(int n, int n2) {
        f.b((E)ConcurrencyModule.INSTANCE.getUiScope(), null, null, (U0.o)new U0.o(this, n, n2, null){
            final int $areaId;
            final int $visible;
            int label;
            final TemplateBuilderV3 this$0;
            {
                this.this$0 = templateBuilderV3;
                this.$areaId = n;
                this.$visible = n2;
                super(2, d2);
            }

            public final d create(Object object, d d2) {
                return new /* invalid duplicate definition of identical inner class */;
            }

            public final Object invoke(E e, d d2) {
                return (this.create(e, d2)).invokeSuspend(s.a);
            }

            /*
             * Enabled aggressive block sorting
             * Enabled unnecessary exception pruning
             * Enabled aggressive exception aggregation
             */
            public final Object invokeSuspend(Object object) {
                Exception exception2;
                block9: {
                    Object var2_3;
                    c.c();
                    if (this.label != 0) throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    k.b((Object)object);
                    try {
                        object = TemplateBuilderV3.access$getIslandLayout$p(this.this$0);
                        var2_3 = null;
                        object = object != null ? (FrameLayout)object.findViewById(this.$areaId) : null;
                    }
                    catch (Exception exception2) {
                        break block9;
                    }
                    if (object != null) {
                        object.setVisibility(this.$visible);
                    }
                    object = TemplateBuilderV3.access$getIslandLayoutFake$p(this.this$0);
                    object = object != null ? (FrameLayout)object.findViewById(this.$areaId) : null;
                    if (object != null) {
                        object.setVisibility(this.$visible);
                    }
                    object = TemplateBuilderV3.access$getFocusLayout$p(this.this$0);
                    object = object != null ? (FrameLayout)object.findViewById(this.$areaId) : null;
                    if (object != null) {
                        object.setVisibility(this.$visible);
                    }
                    object = TemplateBuilderV3.access$getFocusDarkLayout$p(this.this$0);
                    object = object != null ? (FrameLayout)object.findViewById(this.$areaId) : null;
                    if (object != null) {
                        object.setVisibility(this.$visible);
                    }
                    object = TemplateBuilderV3.access$getFocusModalLayout$p(this.this$0);
                    object = object != null ? (FrameLayout)object.findViewById(this.$areaId) : null;
                    if (object != null) {
                        object.setVisibility(this.$visible);
                    }
                    View view = TemplateBuilderV3.access$getFocusModalDarkLayout$p(this.this$0);
                    object = var2_3;
                    if (view != null) {
                        object = (FrameLayout)view.findViewById(this.$areaId);
                    }
                    if (object == null) {
                        return s.a;
                    }
                    object.setVisibility(this.$visible);
                    return s.a;
                }
                Log.d((String)"TemplateBuilderV3", (String)((Object)exception2).toString());
                return s.a;
            }
        }, (int)3, null);
        return this;
    }

    public final TemplateBuilderV3 updateModuleView(String string, boolean bl, Template template, StatusBarNotification statusBarNotification) {
        o.g((Object)string, (String)"moduleType");
        o.g((Object)template, (String)"template");
        o.g((Object)statusBarNotification, (String)"sbn");
        ModuleViewHolderAdapter moduleViewHolderAdapter = this.islandAdapter;
        if (moduleViewHolderAdapter != null) {
            moduleViewHolderAdapter.updateView(string, template, statusBarNotification);
        }
        if ((moduleViewHolderAdapter = this.islandFakeAdapter) != null) {
            moduleViewHolderAdapter.updateView(string, template, statusBarNotification);
        }
        if ((moduleViewHolderAdapter = this.focusAdapter) != null) {
            moduleViewHolderAdapter.updateView(string, template, statusBarNotification);
        }
        if ((moduleViewHolderAdapter = this.focusDarkAdapter) != null) {
            moduleViewHolderAdapter.updateView(string, template, statusBarNotification);
        }
        if ((moduleViewHolderAdapter = this.focusModalAdapter) != null) {
            moduleViewHolderAdapter.updateView(string, template, statusBarNotification);
        }
        if ((moduleViewHolderAdapter = this.focusModalDarkAdapter) != null) {
            moduleViewHolderAdapter.updateView(string, template, statusBarNotification);
        }
        return this;
    }
}
