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
 *  android.widget.LinearLayout
 *  android.widget.LinearLayout$LayoutParams
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
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.android.systemui.miui.notification.R;
import com.android.systemui.plugins.miui.notification.FocusNotificationContent;
import f1.E;
import f1.f;
import kotlin.jvm.internal.o;
import miui.systemui.notification.focus.model.IconTextInfo;
import miui.systemui.notification.focus.model.ProgressInfo;
import miui.systemui.notification.focus.model.Template;
import miui.systemui.notification.focus.moduleV3.ModuleViewHolderAdapter;
import miui.systemui.util.concurrency.ConcurrencyModule;

public final class TemplateDecoBuilderV3 {
    public static final Companion Companion = new Object(null){
        {
            this();
        }
    };
    public static final String TAG = "TemplateDecoBuilderV3";
    private final Context context;
    private ModuleViewHolderAdapter decoAdapter;
    private ModuleViewHolderAdapter decoDarkAdapter;
    private View decoDarkLayout;
    private View decoLayout;
    private boolean isFlipDevice;
    private String moduleA;
    private String moduleC;
    private String moduleD;
    private String moduleE;
    private final a moduleViewHolderAdapterProvider;
    private final Template template;

    public TemplateDecoBuilderV3(Context context, Template template, boolean bl, a a2) {
        o.g((Object)context, (String)"context");
        o.g((Object)template, (String)"template");
        o.g((Object)a2, (String)"moduleViewHolderAdapterProvider");
        this.context = context;
        this.template = template;
        this.isFlipDevice = bl;
        this.moduleViewHolderAdapterProvider = a2;
        template = LayoutInflater.from((Context)context);
        int n = R.layout.focus_notification_template_deco_port_center;
        this.decoLayout = template.inflate(n, null);
        this.decoDarkLayout = LayoutInflater.from((Context)context).inflate(n, null);
        this.moduleA = "";
        this.moduleC = "";
        this.moduleE = "";
        this.moduleD = "";
    }

    public static final /* synthetic */ Context access$getContext$p(TemplateDecoBuilderV3 templateDecoBuilderV3) {
        return templateDecoBuilderV3.context;
    }

    public static final /* synthetic */ View access$getDecoDarkLayout$p(TemplateDecoBuilderV3 templateDecoBuilderV3) {
        return templateDecoBuilderV3.decoDarkLayout;
    }

    public static final /* synthetic */ View access$getDecoLayout$p(TemplateDecoBuilderV3 templateDecoBuilderV3) {
        return templateDecoBuilderV3.decoLayout;
    }

    public static final /* synthetic */ Template access$getTemplate$p(TemplateDecoBuilderV3 templateDecoBuilderV3) {
        return templateDecoBuilderV3.template;
    }

    private final void addDecoDarkView(int n, String string, boolean bl, Template object, StatusBarNotification statusBarNotification) {
        ModuleViewHolderAdapter moduleViewHolderAdapter;
        FrameLayout frameLayout = (FrameLayout)this.decoDarkLayout.findViewById(n);
        if (this.decoDarkAdapter == null) {
            this.decoDarkAdapter = (ModuleViewHolderAdapter)this.moduleViewHolderAdapterProvider.get();
        }
        if ((moduleViewHolderAdapter = this.decoDarkAdapter) != null) {
            o.d((Object)frameLayout);
            moduleViewHolderAdapter.createDecoModuleViewHolder((Template)object, string, true, (ViewGroup)frameLayout);
        }
        if ((object = this.decoDarkAdapter) != null) {
            ((ModuleViewHolderAdapter)object).bindData(string, statusBarNotification);
        }
    }

    private final void addDecoView(int n, String string, boolean bl, Template object, StatusBarNotification statusBarNotification) {
        ModuleViewHolderAdapter moduleViewHolderAdapter;
        FrameLayout frameLayout = (FrameLayout)this.decoLayout.findViewById(n);
        if (this.decoAdapter == null) {
            this.decoAdapter = (ModuleViewHolderAdapter)this.moduleViewHolderAdapterProvider.get();
        }
        if ((moduleViewHolderAdapter = this.decoAdapter) != null) {
            o.d((Object)frameLayout);
            moduleViewHolderAdapter.createDecoModuleViewHolder((Template)object, string, false, (ViewGroup)frameLayout);
        }
        if ((object = this.decoAdapter) != null) {
            ((ModuleViewHolderAdapter)object).bindData(string, statusBarNotification);
        }
    }

    private final void setRemoteViewsPadding(View view) {
        f.b((E)ConcurrencyModule.INSTANCE.getUiScope(), null, null, (U0.o)new U0.o(view, this, null){
            final View $view;
            int label;
            final TemplateDecoBuilderV3 this$0;
            {
                this.$view = view;
                this.this$0 = templateDecoBuilderV3;
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
                    object = TemplateDecoBuilderV3.access$getContext$p(this.this$0).getResources();
                    int n = R.dimen.focus_notify_template_deco_margin;
                    layoutParams.setMarginStart((int)object.getDimension(n));
                    layoutParams.topMargin = (int)TemplateDecoBuilderV3.access$getContext$p(this.this$0).getResources().getDimension(n);
                    layoutParams.bottomMargin = (int)TemplateDecoBuilderV3.access$getContext$p(this.this$0).getResources().getDimension(n);
                    object = TemplateDecoBuilderV3.access$getTemplate$p(this.this$0).getProgressInfo();
                    Object var5_5 = null;
                    object = object != null ? b.c((int)((ProgressInfo)object).getProgress()) : null;
                    if (object != null) {
                        FrameLayout frameLayout = (FrameLayout)this.$view.findViewById(R.id.area_a);
                        object = frameLayout.getLayoutParams();
                        o.e((Object)object, (String)"null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
                        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams)object;
                        object = TemplateDecoBuilderV3.access$getTemplate$p(this.this$0).getProgressInfo();
                        object = object != null ? b.c((int)((ProgressInfo)object).getProgress()) : null;
                        o.d((Object)object);
                        if ((Integer)object == 100) {
                            f2 = TemplateDecoBuilderV3.access$getContext$p(this.this$0).getResources().getDimension(R.dimen.focus_notify_template_deco_progress_margin);
                            layoutParams2.setMarginEnd((int)TemplateDecoBuilderV3.access$getContext$p(this.this$0).getResources().getDimension(R.dimen.focus_notify_template_deco_area_a_margin));
                        } else {
                            ProgressInfo progressInfo = TemplateDecoBuilderV3.access$getTemplate$p(this.this$0).getProgressInfo();
                            object = var5_5;
                            if (progressInfo != null) {
                                object = b.c((int)progressInfo.getProgress());
                            }
                            o.d((Object)object);
                            int n2 = (Integer)object;
                            if (51 <= n2 && n2 < 100) {
                                f2 = TemplateDecoBuilderV3.access$getContext$p(this.this$0).getResources().getDimension(R.dimen.focus_notify_template_deco_progress_margin_end);
                                layoutParams2.setMarginEnd((int)TemplateDecoBuilderV3.access$getContext$p(this.this$0).getResources().getDimension(R.dimen.focus_notify_template_deco_progress_area_a_margin));
                            } else {
                                f2 = TemplateDecoBuilderV3.access$getContext$p(this.this$0).getResources().getDimension(n);
                            }
                        }
                        frameLayout.setLayoutParams((ViewGroup.LayoutParams)layoutParams2);
                    } else {
                        f2 = TemplateDecoBuilderV3.access$getContext$p(this.this$0).getResources().getDimension(n);
                    }
                    layoutParams.setMarginEnd((int)f2);
                    relativeLayout.setLayoutParams((ViewGroup.LayoutParams)layoutParams);
                    return s.a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }, (int)3, null);
    }

    private final void updateTopGravity(View view, boolean bl) {
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

            public final Object invokeSuspend(Object object) {
                c.c();
                if (this.label == 0) {
                    k.b((Object)object);
                    object = (LinearLayout)this.$parent.findViewById(R.id.area_top);
                    if (object != null) {
                        boolean bl = this.$isCenterVertical;
                        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
                        layoutParams.addRule(2, R.id.area_bottom);
                        object.setLayoutParams((ViewGroup.LayoutParams)layoutParams);
                        int n = bl ? 16 : 48;
                        object.setGravity(n);
                    }
                    return s.a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }, (int)3, null);
    }

    public final TemplateDecoBuilderV3 addModuleView(int n, String string, boolean bl, Template template, StatusBarNotification statusBarNotification) {
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
        this.addDecoView(n, string, bl, template, statusBarNotification);
        this.addDecoDarkView(n, string, bl, template, statusBarNotification);
        return this;
    }

    public final void buildView(FocusNotificationContent focusNotificationContent) {
        o.g((Object)focusNotificationContent, (String)"focusNotificationContent");
        focusNotificationContent.setDeco(this.decoLayout);
        focusNotificationContent.setDecoDark(this.decoDarkLayout);
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

    public final TemplateDecoBuilderV3 removeModuleView(String string) {
        o.g((Object)string, (String)"moduleType");
        ModuleViewHolderAdapter moduleViewHolderAdapter = this.decoAdapter;
        if (moduleViewHolderAdapter != null && moduleViewHolderAdapter != null) {
            moduleViewHolderAdapter.removeView(string);
        }
        if ((moduleViewHolderAdapter = this.decoDarkAdapter) != null && moduleViewHolderAdapter != null) {
            moduleViewHolderAdapter.removeView(string);
        }
        return this;
    }

    public final void removeView(FocusNotificationContent focusNotificationContent) {
        o.g((Object)focusNotificationContent, (String)"focusNotificationContent");
        focusNotificationContent.setDeco(null);
        focusNotificationContent.setDecoDark(null);
    }

    public final TemplateDecoBuilderV3 setAreaTopGravity() {
        boolean bl;
        Object object = this.template.getIconTextInfo();
        boolean bl2 = bl = false;
        if (object != null) {
            if ((object = ((IconTextInfo)object).getType()) == null) {
                bl2 = bl;
            } else {
                bl2 = bl;
                if ((Integer)object == 1) {
                    bl2 = true;
                }
            }
        }
        object = this.decoLayout;
        o.f((Object)object, (String)"decoLayout");
        this.updateTopGravity((View)object, bl2);
        object = this.decoDarkLayout;
        o.f((Object)object, (String)"decoDarkLayout");
        this.updateTopGravity((View)object, bl2);
        return this;
    }

    public final TemplateDecoBuilderV3 setAreaViewVisible(int n, int n2) {
        f.b((E)ConcurrencyModule.INSTANCE.getUiScope(), null, null, (U0.o)new U0.o(this, n, n2, null){
            final int $areaId;
            final int $visible;
            int label;
            final TemplateDecoBuilderV3 this$0;
            {
                this.this$0 = templateDecoBuilderV3;
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
                    object = (FrameLayout)TemplateDecoBuilderV3.access$getDecoLayout$p(this.this$0).findViewById(this.$areaId);
                    if (object != null) {
                        object.setVisibility(this.$visible);
                    }
                    object = (FrameLayout)TemplateDecoBuilderV3.access$getDecoDarkLayout$p(this.this$0).findViewById(this.$areaId);
                    if (object == null) {
                        return s.a;
                    }
                    object.setVisibility(this.$visible);
                    return s.a;
                }
                catch (Exception exception) {
                    Log.e((String)"TemplateDecoBuilderV3", (String)((Object)exception).toString());
                }
                return s.a;
            }
        }, (int)3, null);
        return this;
    }

    public final TemplateDecoBuilderV3 setViewLayoutPadding() {
        View view = this.decoLayout;
        o.f((Object)view, (String)"decoLayout");
        this.setRemoteViewsPadding(view);
        view = this.decoDarkLayout;
        o.f((Object)view, (String)"decoDarkLayout");
        this.setRemoteViewsPadding(view);
        return this;
    }

    public final TemplateDecoBuilderV3 updateModuleView(String string, boolean bl, Template template, StatusBarNotification statusBarNotification) {
        o.g((Object)string, (String)"moduleType");
        o.g((Object)template, (String)"template");
        o.g((Object)statusBarNotification, (String)"sbn");
        ModuleViewHolderAdapter moduleViewHolderAdapter = this.decoAdapter;
        if (moduleViewHolderAdapter != null && moduleViewHolderAdapter != null) {
            moduleViewHolderAdapter.updateView(string, template, statusBarNotification);
        }
        if ((moduleViewHolderAdapter = this.decoDarkAdapter) != null && moduleViewHolderAdapter != null) {
            moduleViewHolderAdapter.updateView(string, template, statusBarNotification);
        }
        return this;
    }
}
