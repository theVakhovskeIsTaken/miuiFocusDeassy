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
 *  android.view.ViewGroup$LayoutParams
 *  android.widget.FrameLayout
 *  android.widget.RelativeLayout$LayoutParams
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
import android.widget.RelativeLayout;
import com.android.systemui.miui.notification.R;
import com.android.systemui.plugins.miui.notification.FocusNotificationContent;
import f1.E;
import f1.f;
import kotlin.jvm.internal.o;
import miui.systemui.notification.focus.model.Template;
import miui.systemui.notification.focus.moduleV3.ModuleViewHolderAdapter;
import miui.systemui.util.concurrency.ConcurrencyModule;

public final class TemplateTinyBuilderV3 {
    public static final Companion Companion = new Object(null){
        {
            this();
        }
    };
    public static final String TAG = "TemplateTinyBuilderV3";
    private final Context context;
    private boolean isFlipDevice;
    private String moduleA;
    private String moduleC;
    private String moduleD;
    private final a moduleViewHolderAdapterProvider;
    private ModuleViewHolderAdapter tinyAdapter;
    private ModuleViewHolderAdapter tinyDarkAdapter;
    private final View tinyDarkLayout;
    private ModuleViewHolderAdapter tinyKeyguardAdapter;
    private ModuleViewHolderAdapter tinyKeyguardDarkAdapter;
    private final View tinyKeyguardDarkLayout;
    private final View tinyKeyguardLayout;
    private final View tinyLayout;
    private ModuleViewHolderAdapter tinyModalAdapter;
    private ModuleViewHolderAdapter tinyModalDarkAdapter;
    private final View tinyModalDarkLayout;
    private final View tinyModalLayout;

    public TemplateTinyBuilderV3(Context context, boolean bl, a object) {
        o.g((Object)context, (String)"context");
        o.g((Object)object, (String)"moduleViewHolderAdapterProvider");
        this.context = context;
        this.isFlipDevice = bl;
        this.moduleViewHolderAdapterProvider = object;
        this.moduleA = "";
        this.moduleC = "";
        this.moduleD = "";
        object = LayoutInflater.from((Context)context);
        int n = R.layout.focus_notification_template_tiny;
        this.tinyLayout = object.inflate(n, null);
        this.tinyDarkLayout = LayoutInflater.from((Context)context).inflate(n, null);
        View view = LayoutInflater.from((Context)context).inflate(n, null);
        int n2 = R.id.dynamic_island_modal_tag;
        object = Boolean.TRUE;
        view.setTag(n2, object);
        this.tinyModalLayout = view;
        view = LayoutInflater.from((Context)context).inflate(n, null);
        view.setTag(n2, object);
        this.tinyModalDarkLayout = view;
        this.tinyKeyguardLayout = LayoutInflater.from((Context)context).inflate(n, null);
        this.tinyKeyguardDarkLayout = LayoutInflater.from((Context)context).inflate(n, null);
    }

    public static final /* synthetic */ View access$getTinyDarkLayout$p(TemplateTinyBuilderV3 templateTinyBuilderV3) {
        return templateTinyBuilderV3.tinyDarkLayout;
    }

    public static final /* synthetic */ View access$getTinyKeyguardDarkLayout$p(TemplateTinyBuilderV3 templateTinyBuilderV3) {
        return templateTinyBuilderV3.tinyKeyguardDarkLayout;
    }

    public static final /* synthetic */ View access$getTinyKeyguardLayout$p(TemplateTinyBuilderV3 templateTinyBuilderV3) {
        return templateTinyBuilderV3.tinyKeyguardLayout;
    }

    public static final /* synthetic */ View access$getTinyLayout$p(TemplateTinyBuilderV3 templateTinyBuilderV3) {
        return templateTinyBuilderV3.tinyLayout;
    }

    public static final /* synthetic */ View access$getTinyModalDarkLayout$p(TemplateTinyBuilderV3 templateTinyBuilderV3) {
        return templateTinyBuilderV3.tinyModalDarkLayout;
    }

    public static final /* synthetic */ View access$getTinyModalLayout$p(TemplateTinyBuilderV3 templateTinyBuilderV3) {
        return templateTinyBuilderV3.tinyModalLayout;
    }

    private final void addTinyDarkView(int n, String string, boolean bl, Template object, StatusBarNotification statusBarNotification) {
        ModuleViewHolderAdapter moduleViewHolderAdapter;
        FrameLayout frameLayout = (FrameLayout)this.tinyDarkLayout.findViewById(n);
        if (this.tinyDarkAdapter == null) {
            this.tinyDarkAdapter = (ModuleViewHolderAdapter)this.moduleViewHolderAdapterProvider.get();
        }
        if ((moduleViewHolderAdapter = this.tinyDarkAdapter) != null) {
            o.d((Object)frameLayout);
            moduleViewHolderAdapter.createTinyModuleViewHolder((Template)object, string, true, (ViewGroup)frameLayout, "tiny_dark");
        }
        if ((object = this.tinyDarkAdapter) != null) {
            ((ModuleViewHolderAdapter)object).bindData(string, statusBarNotification);
        }
    }

    private final void addTinyKeyguardDarkView(int n, String string, boolean bl, Template object, StatusBarNotification statusBarNotification) {
        ModuleViewHolderAdapter moduleViewHolderAdapter;
        FrameLayout frameLayout = (FrameLayout)this.tinyKeyguardDarkLayout.findViewById(n);
        if (this.tinyKeyguardDarkAdapter == null) {
            this.tinyKeyguardDarkAdapter = (ModuleViewHolderAdapter)this.moduleViewHolderAdapterProvider.get();
        }
        if ((moduleViewHolderAdapter = this.tinyKeyguardDarkAdapter) != null) {
            o.d((Object)frameLayout);
            moduleViewHolderAdapter.createTinyModuleViewHolder((Template)object, string, true, (ViewGroup)frameLayout, "tiny_keyguard_dark");
        }
        if ((object = this.tinyKeyguardDarkAdapter) != null) {
            ((ModuleViewHolderAdapter)object).bindData(string, statusBarNotification);
        }
    }

    private final void addTinyKeyguardView(int n, String string, boolean bl, Template object, StatusBarNotification statusBarNotification) {
        ModuleViewHolderAdapter moduleViewHolderAdapter;
        FrameLayout frameLayout = (FrameLayout)this.tinyKeyguardLayout.findViewById(n);
        if (this.tinyKeyguardAdapter == null) {
            this.tinyKeyguardAdapter = (ModuleViewHolderAdapter)this.moduleViewHolderAdapterProvider.get();
        }
        if ((moduleViewHolderAdapter = this.tinyKeyguardAdapter) != null) {
            o.d((Object)frameLayout);
            moduleViewHolderAdapter.createTinyModuleViewHolder((Template)object, string, false, (ViewGroup)frameLayout, "tiny_keyguard");
        }
        if ((object = this.tinyKeyguardAdapter) != null) {
            ((ModuleViewHolderAdapter)object).bindData(string, statusBarNotification);
        }
    }

    private final void addTinyModalDarkView(int n, String string, boolean bl, Template object, StatusBarNotification statusBarNotification) {
        ModuleViewHolderAdapter moduleViewHolderAdapter;
        FrameLayout frameLayout = (FrameLayout)this.tinyModalDarkLayout.findViewById(n);
        if (this.tinyModalDarkAdapter == null) {
            this.tinyModalDarkAdapter = (ModuleViewHolderAdapter)this.moduleViewHolderAdapterProvider.get();
        }
        if ((moduleViewHolderAdapter = this.tinyModalDarkAdapter) != null) {
            o.d((Object)frameLayout);
            moduleViewHolderAdapter.createTinyModuleViewHolder((Template)object, string, true, (ViewGroup)frameLayout, "tiny_modal_dark");
        }
        if ((object = this.tinyModalDarkAdapter) != null) {
            ((ModuleViewHolderAdapter)object).bindData(string, statusBarNotification);
        }
    }

    private final void addTinyModalView(int n, String string, boolean bl, Template object, StatusBarNotification statusBarNotification) {
        ModuleViewHolderAdapter moduleViewHolderAdapter;
        FrameLayout frameLayout = (FrameLayout)this.tinyModalLayout.findViewById(n);
        if (this.tinyModalAdapter == null) {
            this.tinyModalAdapter = (ModuleViewHolderAdapter)this.moduleViewHolderAdapterProvider.get();
        }
        if ((moduleViewHolderAdapter = this.tinyModalAdapter) != null) {
            o.d((Object)frameLayout);
            moduleViewHolderAdapter.createTinyModuleViewHolder((Template)object, string, false, (ViewGroup)frameLayout, "tiny_modal");
        }
        if ((object = this.tinyModalAdapter) != null) {
            ((ModuleViewHolderAdapter)object).bindData(string, statusBarNotification);
        }
    }

    private final void addTinyView(int n, String string, boolean bl, Template object, StatusBarNotification statusBarNotification) {
        ModuleViewHolderAdapter moduleViewHolderAdapter;
        FrameLayout frameLayout = (FrameLayout)this.tinyLayout.findViewById(n);
        if (this.tinyAdapter == null) {
            this.tinyAdapter = (ModuleViewHolderAdapter)this.moduleViewHolderAdapterProvider.get();
        }
        if ((moduleViewHolderAdapter = this.tinyAdapter) != null) {
            o.d((Object)frameLayout);
            moduleViewHolderAdapter.createTinyModuleViewHolder((Template)object, string, false, (ViewGroup)frameLayout, "raw_tiny");
        }
        if ((object = this.tinyAdapter) != null) {
            ((ModuleViewHolderAdapter)object).bindData(string, statusBarNotification);
        }
    }

    private final void updateAreaCenterGravity(View view, boolean bl) {
        f.b((E)ConcurrencyModule.INSTANCE.getUiScope(), null, null, (U0.o)new U0.o(view, bl, null){
            final boolean $isCenterVertical;
            final View $parent;
            int label;
            {
                this.$parent = view;
                this.$isCenterVertical = bl;
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
                block5: {
                    boolean bl;
                    FrameLayout frameLayout;
                    c.c();
                    if (this.label != 0) throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    k.b((Object)object);
                    try {
                        frameLayout = (FrameLayout)this.$parent.findViewById(R.id.area_a);
                        if (frameLayout == null) return s.a;
                        bl = this.$isCenterVertical;
                        object = frameLayout.getLayoutParams();
                        object = object instanceof RelativeLayout.LayoutParams ? (RelativeLayout.LayoutParams)object : null;
                    }
                    catch (Exception exception2) {
                        break block5;
                    }
                    if (object == null) {
                        return s.a;
                    }
                    if (bl) {
                        object.addRule(15);
                        object.removeRule(10);
                        object.removeRule(12);
                    } else {
                        object.addRule(10);
                        object.removeRule(15);
                        object.removeRule(12);
                    }
                    frameLayout.setLayoutParams((ViewGroup.LayoutParams)object);
                    return s.a;
                }
                Log.e((String)"TemplateTinyBuilderV3", (String)((Object)exception2).toString());
                return s.a;
            }
        }, (int)3, null);
    }

    private final void updateCenterGravity(View view, boolean bl) {
        f.b((E)ConcurrencyModule.INSTANCE.getUiScope(), null, null, (U0.o)new U0.o(view, bl, null){
            final boolean $isCenterVertical;
            final View $parent;
            int label;
            {
                this.$parent = view;
                this.$isCenterVertical = bl;
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
                block5: {
                    boolean bl;
                    FrameLayout frameLayout;
                    c.c();
                    if (this.label != 0) throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    k.b((Object)object);
                    try {
                        frameLayout = (FrameLayout)this.$parent.findViewById(R.id.area_c);
                        if (frameLayout == null) return s.a;
                        bl = this.$isCenterVertical;
                        object = frameLayout.getLayoutParams();
                        object = object instanceof RelativeLayout.LayoutParams ? (RelativeLayout.LayoutParams)object : null;
                    }
                    catch (Exception exception2) {
                        break block5;
                    }
                    if (object == null) {
                        return s.a;
                    }
                    if (bl) {
                        object.addRule(15);
                        object.removeRule(10);
                        object.removeRule(12);
                    } else {
                        object.addRule(10);
                        object.removeRule(15);
                        object.removeRule(12);
                    }
                    frameLayout.setLayoutParams((ViewGroup.LayoutParams)object);
                    return s.a;
                }
                Log.e((String)"TemplateTinyBuilderV3", (String)((Object)exception2).toString());
                return s.a;
            }
        }, (int)3, null);
    }

    public final TemplateTinyBuilderV3 addModuleView(int n, String string, boolean bl, Template template, StatusBarNotification statusBarNotification) {
        o.g((Object)string, (String)"moduleType");
        o.g((Object)template, (String)"template");
        o.g((Object)statusBarNotification, (String)"sbn");
        if (n == R.id.area_a) {
            this.moduleA = string;
        } else if (n == R.id.area_c) {
            this.moduleC = string;
        } else if (n == R.id.area_d) {
            this.moduleD = string;
        }
        this.addTinyView(n, string, bl, template, statusBarNotification);
        this.addTinyDarkView(n, string, bl, template, statusBarNotification);
        this.addTinyModalView(n, string, bl, template, statusBarNotification);
        this.addTinyModalDarkView(n, string, bl, template, statusBarNotification);
        this.addTinyKeyguardView(n, string, bl, template, statusBarNotification);
        this.addTinyKeyguardDarkView(n, string, bl, template, statusBarNotification);
        return this;
    }

    public final void buildView(FocusNotificationContent focusNotificationContent) {
        o.g((Object)focusNotificationContent, (String)"focusNotificationContent");
        focusNotificationContent.setTinyView(this.tinyLayout);
        focusNotificationContent.setTinyViewDark(this.tinyDarkLayout);
        focusNotificationContent.setTinyKeyguardView(this.tinyKeyguardLayout);
        focusNotificationContent.setTinyViewKeyguardDark(this.tinyKeyguardDarkLayout);
        focusNotificationContent.setTinyViewModal(this.tinyModalLayout);
        focusNotificationContent.setTinyViewDarkModal(this.tinyModalDarkLayout);
    }

    public final boolean isSameModuleA(String string) {
        o.g((Object)string, (String)"moduleType");
        return o.c((Object)string, (Object)this.moduleA);
    }

    public final boolean isSameModuleC(String string) {
        o.g((Object)string, (String)"moduleType");
        return o.c((Object)string, (Object)this.moduleC);
    }

    public final boolean isSameModuleD(String string) {
        o.g((Object)string, (String)"moduleType");
        return o.c((Object)string, (Object)this.moduleD);
    }

    public final TemplateTinyBuilderV3 removeModuleView(String string) {
        o.g((Object)string, (String)"moduleType");
        ModuleViewHolderAdapter moduleViewHolderAdapter = this.tinyAdapter;
        if (moduleViewHolderAdapter != null && moduleViewHolderAdapter != null) {
            moduleViewHolderAdapter.removeView(string);
        }
        if ((moduleViewHolderAdapter = this.tinyDarkAdapter) != null && moduleViewHolderAdapter != null) {
            moduleViewHolderAdapter.removeView(string);
        }
        if ((moduleViewHolderAdapter = this.tinyKeyguardAdapter) != null && moduleViewHolderAdapter != null) {
            moduleViewHolderAdapter.removeView(string);
        }
        if ((moduleViewHolderAdapter = this.tinyKeyguardDarkAdapter) != null && moduleViewHolderAdapter != null) {
            moduleViewHolderAdapter.removeView(string);
        }
        if ((moduleViewHolderAdapter = this.tinyModalAdapter) != null && moduleViewHolderAdapter != null) {
            moduleViewHolderAdapter.removeView(string);
        }
        if ((moduleViewHolderAdapter = this.tinyModalDarkAdapter) != null && moduleViewHolderAdapter != null) {
            moduleViewHolderAdapter.removeView(string);
        }
        return this;
    }

    public final void removeView(FocusNotificationContent focusNotificationContent) {
        o.g((Object)focusNotificationContent, (String)"focusNotificationContent");
        focusNotificationContent.setTinyView(null);
        focusNotificationContent.setTinyViewDark(null);
        focusNotificationContent.setTinyKeyguardView(null);
        focusNotificationContent.setTinyViewKeyguardDark(null);
        focusNotificationContent.setTinyViewModal(null);
        focusNotificationContent.setTinyViewDarkModal(null);
    }

    public final TemplateTinyBuilderV3 setAreaCenterGravity(boolean bl) {
        View view = this.tinyLayout;
        o.f((Object)view, (String)"tinyLayout");
        this.updateAreaCenterGravity(view, bl);
        view = this.tinyDarkLayout;
        o.f((Object)view, (String)"tinyDarkLayout");
        this.updateAreaCenterGravity(view, bl);
        view = this.tinyKeyguardLayout;
        o.f((Object)view, (String)"tinyKeyguardLayout");
        this.updateAreaCenterGravity(view, bl);
        view = this.tinyKeyguardDarkLayout;
        o.f((Object)view, (String)"tinyKeyguardDarkLayout");
        this.updateAreaCenterGravity(view, bl);
        view = this.tinyModalLayout;
        o.f((Object)view, (String)"tinyModalLayout");
        this.updateAreaCenterGravity(view, bl);
        view = this.tinyModalDarkLayout;
        o.f((Object)view, (String)"tinyModalDarkLayout");
        this.updateAreaCenterGravity(view, bl);
        return this;
    }

    public final TemplateTinyBuilderV3 setAreaViewVisible(int n, int n2) {
        f.b((E)ConcurrencyModule.INSTANCE.getUiScope(), null, null, (U0.o)new U0.o(this, n, n2, null){
            final int $areaId;
            final int $visible;
            int label;
            final TemplateTinyBuilderV3 this$0;
            {
                this.this$0 = templateTinyBuilderV3;
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
                c.c();
                if (this.label != 0) throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                k.b((Object)object);
                try {
                    object = (FrameLayout)TemplateTinyBuilderV3.access$getTinyLayout$p(this.this$0).findViewById(this.$areaId);
                    if (object != null) {
                        object.setVisibility(this.$visible);
                    }
                    object = (FrameLayout)TemplateTinyBuilderV3.access$getTinyDarkLayout$p(this.this$0).findViewById(this.$areaId);
                    if (object != null) {
                        object.setVisibility(this.$visible);
                    }
                    object = (FrameLayout)TemplateTinyBuilderV3.access$getTinyKeyguardLayout$p(this.this$0).findViewById(this.$areaId);
                    if (object != null) {
                        object.setVisibility(this.$visible);
                    }
                    object = (FrameLayout)TemplateTinyBuilderV3.access$getTinyKeyguardDarkLayout$p(this.this$0).findViewById(this.$areaId);
                    if (object != null) {
                        object.setVisibility(this.$visible);
                    }
                    object = (FrameLayout)TemplateTinyBuilderV3.access$getTinyModalLayout$p(this.this$0).findViewById(this.$areaId);
                    if (object != null) {
                        object.setVisibility(this.$visible);
                    }
                    object = (FrameLayout)TemplateTinyBuilderV3.access$getTinyModalDarkLayout$p(this.this$0).findViewById(this.$areaId);
                    if (object == null) {
                        return s.a;
                    }
                    object.setVisibility(this.$visible);
                    return s.a;
                }
                catch (Exception exception) {
                    Log.e((String)"TemplateTinyBuilderV3", (String)((Object)exception).toString());
                }
                return s.a;
            }
        }, (int)3, null);
        return this;
    }

    public final TemplateTinyBuilderV3 setArecCenterGravity(boolean bl) {
        View view = this.tinyLayout;
        o.f((Object)view, (String)"tinyLayout");
        this.updateCenterGravity(view, bl);
        view = this.tinyDarkLayout;
        o.f((Object)view, (String)"tinyDarkLayout");
        this.updateCenterGravity(view, bl);
        view = this.tinyKeyguardLayout;
        o.f((Object)view, (String)"tinyKeyguardLayout");
        this.updateCenterGravity(view, bl);
        view = this.tinyKeyguardDarkLayout;
        o.f((Object)view, (String)"tinyKeyguardDarkLayout");
        this.updateCenterGravity(view, bl);
        view = this.tinyModalLayout;
        o.f((Object)view, (String)"tinyModalLayout");
        this.updateCenterGravity(view, bl);
        view = this.tinyModalDarkLayout;
        o.f((Object)view, (String)"tinyModalDarkLayout");
        this.updateCenterGravity(view, bl);
        return this;
    }

    public final TemplateTinyBuilderV3 updateModuleView(String string, boolean bl, Template template, StatusBarNotification statusBarNotification) {
        o.g((Object)string, (String)"moduleType");
        o.g((Object)template, (String)"template");
        o.g((Object)statusBarNotification, (String)"sbn");
        ModuleViewHolderAdapter moduleViewHolderAdapter = this.tinyAdapter;
        if (moduleViewHolderAdapter != null && moduleViewHolderAdapter != null) {
            moduleViewHolderAdapter.updateView(string, template, statusBarNotification);
        }
        if ((moduleViewHolderAdapter = this.tinyDarkAdapter) != null && moduleViewHolderAdapter != null) {
            moduleViewHolderAdapter.updateView(string, template, statusBarNotification);
        }
        if ((moduleViewHolderAdapter = this.tinyKeyguardAdapter) != null && moduleViewHolderAdapter != null) {
            moduleViewHolderAdapter.updateView(string, template, statusBarNotification);
        }
        if ((moduleViewHolderAdapter = this.tinyKeyguardDarkAdapter) != null && moduleViewHolderAdapter != null) {
            moduleViewHolderAdapter.updateView(string, template, statusBarNotification);
        }
        if ((moduleViewHolderAdapter = this.tinyModalAdapter) != null && moduleViewHolderAdapter != null) {
            moduleViewHolderAdapter.updateView(string, template, statusBarNotification);
        }
        if ((moduleViewHolderAdapter = this.tinyModalDarkAdapter) != null && moduleViewHolderAdapter != null) {
            moduleViewHolderAdapter.updateView(string, template, statusBarNotification);
        }
        return this;
    }
}
