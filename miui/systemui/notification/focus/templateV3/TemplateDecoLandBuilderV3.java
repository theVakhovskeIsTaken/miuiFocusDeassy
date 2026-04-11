/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  F0.a
 *  G0.k
 *  G0.s
 *  K0.d
 *  L0.c
 *  M0.b
 *  U0.o
 *  android.content.Context
 *  android.service.notification.StatusBarNotification
 *  android.util.Log
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.ViewGroup
 *  android.view.ViewGroup$LayoutParams
 *  android.widget.FrameLayout
 *  android.widget.FrameLayout$LayoutParams
 *  android.widget.RelativeLayout
 *  android.widget.RelativeLayout$LayoutParams
 *  com.android.systemui.miui.notification.R$dimen
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
import M0.b;
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
import miui.systemui.notification.focus.model.ProgressInfo;
import miui.systemui.notification.focus.model.Template;
import miui.systemui.notification.focus.moduleV3.ModuleViewHolderAdapter;
import miui.systemui.util.concurrency.ConcurrencyModule;

public final class TemplateDecoLandBuilderV3 {
    public static final Companion Companion = new Object(null){
        {
            this();
        }
    };
    public static final String TAG = "TemplateDecoLandBuilderV3";
    private final Context context;
    private ModuleViewHolderAdapter decoLandAdapter;
    private ModuleViewHolderAdapter decoLandDarkAdapter;
    private final View decoLandDarkLayout;
    private final View decoLandLayout;
    private boolean isFlipDevice;
    private String moduleA;
    private String moduleC;
    private String moduleD;
    private String moduleE;
    private final a moduleViewHolderAdapterProvider;
    private final Template template;

    public TemplateDecoLandBuilderV3(Context context, Template template, boolean bl, a a2) {
        o.g((Object)context, (String)"context");
        o.g((Object)template, (String)"template");
        o.g((Object)a2, (String)"moduleViewHolderAdapterProvider");
        this.context = context;
        this.template = template;
        this.isFlipDevice = bl;
        this.moduleViewHolderAdapterProvider = a2;
        this.moduleA = "";
        this.moduleC = "";
        this.moduleE = "";
        this.moduleD = "";
        template = LayoutInflater.from((Context)context);
        int n = R.layout.focus_notification_template_deco_land;
        this.decoLandDarkLayout = template.inflate(n, null);
        this.decoLandLayout = LayoutInflater.from((Context)context).inflate(n, null);
    }

    public static final /* synthetic */ Context access$getContext$p(TemplateDecoLandBuilderV3 templateDecoLandBuilderV3) {
        return templateDecoLandBuilderV3.context;
    }

    public static final /* synthetic */ View access$getDecoLandDarkLayout$p(TemplateDecoLandBuilderV3 templateDecoLandBuilderV3) {
        return templateDecoLandBuilderV3.decoLandDarkLayout;
    }

    public static final /* synthetic */ View access$getDecoLandLayout$p(TemplateDecoLandBuilderV3 templateDecoLandBuilderV3) {
        return templateDecoLandBuilderV3.decoLandLayout;
    }

    public static final /* synthetic */ Template access$getTemplate$p(TemplateDecoLandBuilderV3 templateDecoLandBuilderV3) {
        return templateDecoLandBuilderV3.template;
    }

    private final void addDecoLandDarkView(int n, String string, boolean bl, Template object, StatusBarNotification statusBarNotification) {
        ModuleViewHolderAdapter moduleViewHolderAdapter;
        FrameLayout frameLayout = (FrameLayout)this.decoLandDarkLayout.findViewById(n);
        if (this.decoLandDarkAdapter == null) {
            this.decoLandDarkAdapter = (ModuleViewHolderAdapter)this.moduleViewHolderAdapterProvider.get();
        }
        if ((moduleViewHolderAdapter = this.decoLandDarkAdapter) != null) {
            o.d((Object)frameLayout);
            moduleViewHolderAdapter.createDecoLandModuleViewHolder((Template)object, string, true, (ViewGroup)frameLayout);
        }
        if ((object = this.decoLandDarkAdapter) != null) {
            ((ModuleViewHolderAdapter)object).bindData(string, statusBarNotification);
        }
    }

    private final void addDecoLandView(int n, String string, boolean bl, Template object, StatusBarNotification statusBarNotification) {
        ModuleViewHolderAdapter moduleViewHolderAdapter;
        FrameLayout frameLayout = (FrameLayout)this.decoLandLayout.findViewById(n);
        if (this.decoLandAdapter == null) {
            this.decoLandAdapter = (ModuleViewHolderAdapter)this.moduleViewHolderAdapterProvider.get();
        }
        if ((moduleViewHolderAdapter = this.decoLandAdapter) != null) {
            o.d((Object)frameLayout);
            moduleViewHolderAdapter.createDecoLandModuleViewHolder((Template)object, string, false, (ViewGroup)frameLayout);
        }
        if ((object = this.decoLandAdapter) != null) {
            ((ModuleViewHolderAdapter)object).bindData(string, statusBarNotification);
        }
    }

    private final void setRemoteViewsPadding(View view) {
        f.b((E)ConcurrencyModule.INSTANCE.getUiScope(), null, null, (U0.o)new U0.o(view, this, null){
            final View $view;
            int label;
            final TemplateDecoLandBuilderV3 this$0;
            {
                this.$view = view;
                this.this$0 = templateDecoLandBuilderV3;
                super(2, d2);
            }

            public final d create(Object object, d d2) {
                return new /* invalid duplicate definition of identical inner class */;
            }

            public final Object invoke(E e, d d2) {
                return (this.create(e, d2)).invokeSuspend(s.a);
            }

            public final Object invokeSuspend(Object object) {
                c.c();
                if (this.label == 0) {
                    float f2;
                    k.b((Object)object);
                    RelativeLayout relativeLayout = (RelativeLayout)this.$view.findViewById(R.id.area_container);
                    object = relativeLayout.getLayoutParams();
                    o.e((Object)object, (String)"null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
                    FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams)object;
                    object = TemplateDecoLandBuilderV3.access$getContext$p(this.this$0).getResources();
                    int n = R.dimen.focus_notify_template_deco_margin;
                    layoutParams.setMarginStart((int)object.getDimension(n));
                    layoutParams.topMargin = (int)TemplateDecoLandBuilderV3.access$getContext$p(this.this$0).getResources().getDimension(n);
                    layoutParams.bottomMargin = (int)TemplateDecoLandBuilderV3.access$getContext$p(this.this$0).getResources().getDimension(n);
                    object = TemplateDecoLandBuilderV3.access$getTemplate$p(this.this$0).getProgressInfo();
                    Object var5_5 = null;
                    object = object != null ? b.c((int)((ProgressInfo)object).getProgress()) : null;
                    if (object != null) {
                        FrameLayout frameLayout = (FrameLayout)this.$view.findViewById(R.id.area_c);
                        object = frameLayout.getLayoutParams();
                        o.e((Object)object, (String)"null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
                        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams)object;
                        object = TemplateDecoLandBuilderV3.access$getTemplate$p(this.this$0).getProgressInfo();
                        object = object != null ? b.c((int)((ProgressInfo)object).getProgress()) : null;
                        o.d((Object)object);
                        if ((Integer)object == 100) {
                            f2 = TemplateDecoLandBuilderV3.access$getContext$p(this.this$0).getResources().getDimension(R.dimen.focus_notify_template_deco_progress_margin);
                            layoutParams2.setMarginEnd((int)TemplateDecoLandBuilderV3.access$getContext$p(this.this$0).getResources().getDimension(R.dimen.focus_notify_template_deco_area_a_margin));
                        } else {
                            ProgressInfo progressInfo = TemplateDecoLandBuilderV3.access$getTemplate$p(this.this$0).getProgressInfo();
                            object = var5_5;
                            if (progressInfo != null) {
                                object = b.c((int)progressInfo.getProgress());
                            }
                            o.d((Object)object);
                            int n2 = (Integer)object;
                            if (51 <= n2 && n2 < 100) {
                                f2 = TemplateDecoLandBuilderV3.access$getContext$p(this.this$0).getResources().getDimension(R.dimen.focus_notify_template_deco_progress_margin_end);
                                layoutParams2.setMarginEnd((int)TemplateDecoLandBuilderV3.access$getContext$p(this.this$0).getResources().getDimension(R.dimen.focus_notify_template_deco_progress_area_a_margin));
                            } else {
                                f2 = TemplateDecoLandBuilderV3.access$getContext$p(this.this$0).getResources().getDimension(n);
                            }
                        }
                        frameLayout.setLayoutParams((ViewGroup.LayoutParams)layoutParams2);
                    } else {
                        f2 = TemplateDecoLandBuilderV3.access$getContext$p(this.this$0).getResources().getDimension(n);
                    }
                    layoutParams.setMarginEnd((int)f2);
                    relativeLayout.setLayoutParams((ViewGroup.LayoutParams)layoutParams);
                    return s.a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }, (int)3, null);
    }

    public final TemplateDecoLandBuilderV3 addModuleView(int n, String string, boolean bl, Template template, StatusBarNotification statusBarNotification) {
        o.g((Object)string, (String)"moduleType");
        o.g((Object)template, (String)"template");
        o.g((Object)statusBarNotification, (String)"sbn");
        if (n == R.id.area_a) {
            this.moduleA = string;
        } else if (n == R.id.area_c) {
            this.moduleC = string;
        } else if (n == R.id.area_d) {
            this.moduleD = string;
        } else if (n == R.id.area_e) {
            this.moduleE = string;
        }
        this.addDecoLandDarkView(n, string, bl, template, statusBarNotification);
        this.addDecoLandView(n, string, bl, template, statusBarNotification);
        return this;
    }

    public final void buildView(FocusNotificationContent focusNotificationContent) {
        o.g((Object)focusNotificationContent, (String)"focusNotificationContent");
        focusNotificationContent.setDecoLand(this.decoLandLayout);
        focusNotificationContent.setDecoLandDark(this.decoLandDarkLayout);
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

    public final boolean isSameModuleE(String string) {
        o.g((Object)string, (String)"moduleType");
        return o.c((Object)string, (Object)this.moduleE);
    }

    public final TemplateDecoLandBuilderV3 removeModuleView(String string) {
        o.g((Object)string, (String)"moduleType");
        ModuleViewHolderAdapter moduleViewHolderAdapter = this.decoLandAdapter;
        if (moduleViewHolderAdapter != null && moduleViewHolderAdapter != null) {
            moduleViewHolderAdapter.removeView(string);
        }
        if ((moduleViewHolderAdapter = this.decoLandDarkAdapter) != null && moduleViewHolderAdapter != null) {
            moduleViewHolderAdapter.removeView(string);
        }
        return this;
    }

    public final void removeView(FocusNotificationContent focusNotificationContent) {
        o.g((Object)focusNotificationContent, (String)"focusNotificationContent");
        focusNotificationContent.setDecoLand(null);
        focusNotificationContent.setDecoLandDark(null);
    }

    public final TemplateDecoLandBuilderV3 setAreaViewVisible(int n, int n2) {
        f.b((E)ConcurrencyModule.INSTANCE.getUiScope(), null, null, (U0.o)new U0.o(this, n, n2, null){
            final int $areaId;
            final int $visible;
            int label;
            final TemplateDecoLandBuilderV3 this$0;
            {
                this.this$0 = templateDecoLandBuilderV3;
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
                    object = (FrameLayout)TemplateDecoLandBuilderV3.access$getDecoLandDarkLayout$p(this.this$0).findViewById(this.$areaId);
                    if (object != null) {
                        object.setVisibility(this.$visible);
                    }
                    object = (FrameLayout)TemplateDecoLandBuilderV3.access$getDecoLandLayout$p(this.this$0).findViewById(this.$areaId);
                    if (object == null) {
                        return s.a;
                    }
                    object.setVisibility(this.$visible);
                    return s.a;
                }
                catch (Exception exception) {
                    Log.e((String)"TemplateDecoLandBuilderV3", (String)((Object)exception).toString());
                }
                return s.a;
            }
        }, (int)3, null);
        return this;
    }

    public final TemplateDecoLandBuilderV3 setViewLayoutPadding() {
        View view = this.decoLandLayout;
        o.f((Object)view, (String)"decoLandLayout");
        this.setRemoteViewsPadding(view);
        view = this.decoLandDarkLayout;
        o.f((Object)view, (String)"decoLandDarkLayout");
        this.setRemoteViewsPadding(view);
        return this;
    }

    public final TemplateDecoLandBuilderV3 updateModuleView(String string, boolean bl, Template template, StatusBarNotification statusBarNotification) {
        o.g((Object)string, (String)"moduleType");
        o.g((Object)template, (String)"template");
        o.g((Object)statusBarNotification, (String)"sbn");
        ModuleViewHolderAdapter moduleViewHolderAdapter = this.decoLandAdapter;
        if (moduleViewHolderAdapter != null && moduleViewHolderAdapter != null) {
            moduleViewHolderAdapter.updateView(string, template, statusBarNotification);
        }
        if ((moduleViewHolderAdapter = this.decoLandDarkAdapter) != null && moduleViewHolderAdapter != null) {
            moduleViewHolderAdapter.updateView(string, template, statusBarNotification);
        }
        return this;
    }
}
