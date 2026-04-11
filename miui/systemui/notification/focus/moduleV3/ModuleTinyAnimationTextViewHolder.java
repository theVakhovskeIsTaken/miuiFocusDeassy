/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  G0.k
 *  G0.s
 *  K0.d
 *  L0.c
 *  U0.a
 *  U0.o
 *  android.content.Context
 *  android.service.notification.StatusBarNotification
 *  android.text.Html
 *  android.text.TextUtils
 *  android.util.Log
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.ViewGroup
 *  android.view.ViewGroup$LayoutParams
 *  android.widget.TextView
 *  android.widget.TextView$BufferType
 *  com.airbnb.lottie.LottieAnimationView
 *  com.android.systemui.miui.notification.R$id
 *  com.android.systemui.miui.notification.R$layout
 *  d.H
 *  d.h
 *  d.p
 *  f1.E
 *  f1.f
 *  kotlin.jvm.internal.o
 *  miui.systemui.notification.FullAodStatusManager
 *  miui.systemui.notification.FullAodStatusManager$IFullAodStatusObserver
 *  miui.systemui.util.CommonUtils
 *  miui.systemui.util.LottieResUtils
 *  miuix.colorful.texteffect.HyperChronometer
 */
package miui.systemui.notification.focus.moduleV3;

import G0.k;
import G0.s;
import K0.d;
import L0.c;
import U0.a;
import android.content.Context;
import android.service.notification.StatusBarNotification;
import android.text.Html;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.airbnb.lottie.LottieAnimationView;
import com.android.systemui.miui.notification.R;
import d.H;
import d.h;
import d.p;
import f1.E;
import f1.f;
import kotlin.jvm.internal.o;
import miui.systemui.notification.FullAodStatusManager;
import miui.systemui.notification.focus.model.AnimIconInfo;
import miui.systemui.notification.focus.model.AnimTextInfo;
import miui.systemui.notification.focus.model.Template;
import miui.systemui.notification.focus.model.TimerInfo;
import miui.systemui.notification.focus.moduleV3.ModuleTinyAnimationTextViewHolder;
import miui.systemui.notification.focus.moduleV3.ModuleViewHolder;
import miui.systemui.notification.focus.moduleV3.t;
import miui.systemui.notification.focus.moduleV3.u;
import miui.systemui.notification.focus.moduleV3.v;
import miui.systemui.util.CommonUtils;
import miui.systemui.util.LottieResUtils;
import miuix.colorful.texteffect.HyperChronometer;

public final class ModuleTinyAnimationTextViewHolder
extends ModuleViewHolder
implements FullAodStatusManager.IFullAodStatusObserver {
    public static final Companion Companion = new Object(null){
        {
            this();
        }
    };
    public static final String LONGEST_TIME_STR = "88:88:88";
    public static final String TAG = "ModuleTinyAnimationTextViewHolder";
    private HyperChronometer chronometer;
    private View container;
    private LottieAnimationView focusAnimation;
    private TextView focusContent;
    private TextView focusTitle;
    private boolean isAutoPlay;
    private int lastTitleContainerWidth;
    private float maxFrame;
    private final String refType;
    private View titleContainer;

    public ModuleTinyAnimationTextViewHolder(Context context, Context context2, ViewGroup viewGroup, boolean bl, String string) {
        o.g((Object)context, (String)"ctx");
        o.g((Object)context2, (String)"sysuiCtx");
        o.g((Object)viewGroup, (String)"rootView");
        o.g((Object)string, (String)"refType");
        super(context, context2, viewGroup, bl);
        this.refType = string;
        this.maxFrame = -1.0f;
    }

    public static final /* synthetic */ HyperChronometer access$getChronometer$p(ModuleTinyAnimationTextViewHolder moduleTinyAnimationTextViewHolder) {
        return moduleTinyAnimationTextViewHolder.chronometer;
    }

    public static final /* synthetic */ LottieAnimationView access$getFocusAnimation$p(ModuleTinyAnimationTextViewHolder moduleTinyAnimationTextViewHolder) {
        return moduleTinyAnimationTextViewHolder.focusAnimation;
    }

    public static final /* synthetic */ int access$getLastTitleContainerWidth$p(ModuleTinyAnimationTextViewHolder moduleTinyAnimationTextViewHolder) {
        return moduleTinyAnimationTextViewHolder.lastTitleContainerWidth;
    }

    public static final /* synthetic */ View access$getTitleContainer$p(ModuleTinyAnimationTextViewHolder moduleTinyAnimationTextViewHolder) {
        return moduleTinyAnimationTextViewHolder.titleContainer;
    }

    public static final /* synthetic */ boolean access$isAutoPlay$p(ModuleTinyAnimationTextViewHolder moduleTinyAnimationTextViewHolder) {
        return moduleTinyAnimationTextViewHolder.isAutoPlay;
    }

    public static final /* synthetic */ void access$setLastTitleContainerWidth$p(ModuleTinyAnimationTextViewHolder moduleTinyAnimationTextViewHolder, int n) {
        moduleTinyAnimationTextViewHolder.lastTitleContainerWidth = n;
    }

    public static /* synthetic */ void c(ModuleTinyAnimationTextViewHolder moduleTinyAnimationTextViewHolder, Template template, h h2) {
        ModuleTinyAnimationTextViewHolder.playAnimation$lambda$2(moduleTinyAnimationTextViewHolder, template, h2);
    }

    private final void playAnimation(Template object, StatusBarNotification object2) {
        LottieResUtils lottieResUtils = LottieResUtils.INSTANCE;
        object2 = ((Template)object).getAnimTextInfo();
        object2 = object2 != null && (object2 = ((AnimTextInfo)object2).getAnimIconInfo()) != null ? ((AnimIconInfo)object2).getSrc() : null;
        boolean bl = false;
        int n = LottieResUtils.getLottieRes$default((LottieResUtils)lottieResUtils, (String)object2, (int)0, (int)2, null);
        p.s((Context)ModuleViewHolder.getContext$default(this, false, 1, null), (int)n).d((H)new t(this, (Template)object));
        object = ((Template)object).getAnimTextInfo();
        boolean bl2 = bl;
        if (object != null) {
            object = ((AnimTextInfo)object).getAnimIconInfo();
            bl2 = bl;
            if (object != null) {
                bl2 = o.c((Object)((AnimIconInfo)object).getAutoplay(), (Object)Boolean.TRUE);
            }
        }
        this.isAutoPlay = bl2;
        if (!bl2) {
            object = this.focusAnimation;
            if (object != null) {
                object.pauseAnimation();
            }
        } else {
            object = this.focusAnimation;
            if (object != null) {
                object.playAnimation();
            }
        }
    }

    /*
     * Unable to fully structure code
     */
    private static final void playAnimation$lambda$2(ModuleTinyAnimationTextViewHolder var0, Template var1_1, h var2_2) {
        block6: {
            o.g((Object)var0, (String)"this$0");
            o.g((Object)var1_1, (String)"$template");
            var5_3 = var0.focusAnimation;
            if (var5_3 != null) {
                var5_3.setComposition((h)var2_2);
            }
            var3_4 = (var2_2 = var0.focusAnimation) != null ? var2_2.getMaxFrame() : 0.0f;
            var0.maxFrame = var3_4;
            var6_5 = var0.focusAnimation;
            if (var6_5 == null) break block6;
            var2_2 = var1_1.getAnimTextInfo();
            var5_3 = null;
            if ((var2_2 = var2_2 != null && (var2_2 = var2_2.getAnimIconInfo()) != null ? Integer.valueOf(var2_2.getNumber()) : null) == null) ** GOTO lbl-1000
            var2_2 = var1_1.getAnimTextInfo().getAnimIconInfo();
            var2_2 = var2_2 != null ? Integer.valueOf(var2_2.getNumber()) : null;
            o.d((Object)var2_2);
            if (var2_2.intValue() > 0) {
                var2_2 = var1_1.getAnimTextInfo().getAnimIconInfo();
                var1_1 = var5_3;
                if (var2_2 != null) {
                    var1_1 = var2_2.getNumber();
                }
                o.d((Object)var1_1);
                var4_6 = var1_1.intValue();
            } else lbl-1000:
            // 2 sources

            {
                var4_6 = -1;
            }
            var6_5.setRepeatCount(var4_6);
        }
        var1_1 = var0.focusAnimation;
        if (var1_1 != null) {
            var1_1.setRepeatMode(1);
        }
        var0 = var0.focusAnimation;
        if (var0 != null) {
            var0.setProgress(0.0f);
        }
    }

    @Override
    public void bind(Template template, StatusBarNotification statusBarNotification) {
        int n;
        o.g((Object)template, (String)"template");
        o.g((Object)statusBarNotification, (String)"sbn");
        super.bind(template, statusBarNotification);
        this.initTextAndColor(template.getAnimTextInfo());
        Object object = template.getAnimTextInfo();
        object = object != null ? ((AnimTextInfo)object).getTimerInfo() : null;
        this.initTimerData((TimerInfo)object);
        object = this.container;
        if (object != null) {
            object.setVisibility(0);
        }
        if (!TextUtils.isEmpty((CharSequence)this.getTitle())) {
            object = this.focusTitle;
            if (object != null) {
                object.setVisibility(0);
            }
            object = this.focusTitle;
            if (object != null) {
                object.setText((CharSequence)Html.fromHtml((String)this.getTitle()), TextView.BufferType.SPANNABLE);
            }
            if ((object = this.getTitleColor()) != null) {
                n = ((Number)object).intValue();
                object = this.focusTitle;
                if (object != null) {
                    object.setTextColor(n);
                }
            }
        } else {
            object = this.focusTitle;
            if (object != null) {
                object.setVisibility(8);
            }
        }
        if (!TextUtils.isEmpty((CharSequence)this.getContent())) {
            object = this.focusContent;
            if (object != null) {
                object.setVisibility(0);
            }
            object = this.focusContent;
            if (object != null) {
                object.setText((CharSequence)Html.fromHtml((String)this.getContent()), TextView.BufferType.SPANNABLE);
            }
            if ((object = this.getContentColor()) != null) {
                n = ((Number)object).intValue();
                object = this.focusContent;
                if (object != null) {
                    object.setTextColor(n);
                }
            }
        } else {
            object = this.focusContent;
            if (object != null) {
                object.setVisibility(8);
            }
        }
        if ((object = (object = template.getAnimTextInfo()) != null ? ((AnimTextInfo)object).getTimerInfo() : null) != null) {
            object = this.chronometer;
            if (object != null) {
                object.setVisibility(0);
            }
            ModuleViewHolder.setTimerData$default(this, 0, statusBarNotification, 1, null);
        } else {
            object = this.chronometer;
            if (object != null) {
                object.setVisibility(8);
            }
        }
        this.playAnimation(template, statusBarNotification);
    }

    public void fullAodStatusChanged(boolean bl) {
        f.b((E)this.getScope(), null, null, (U0.o)new U0.o(this, bl, null){
            final boolean $fullAodStatus;
            int label;
            final ModuleTinyAnimationTextViewHolder this$0;
            {
                this.this$0 = moduleTinyAnimationTextViewHolder;
                this.$fullAodStatus = bl;
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
                    if (ModuleTinyAnimationTextViewHolder.access$getFocusAnimation$p(this.this$0) == null) {
                        return s.a;
                    }
                    if (this.$fullAodStatus) {
                        object = ModuleTinyAnimationTextViewHolder.access$getFocusAnimation$p(this.this$0);
                        if (object != null) {
                            object.setProgress(1.0f);
                        }
                        object = ModuleTinyAnimationTextViewHolder.access$getFocusAnimation$p(this.this$0);
                        if (object != null) {
                            object.pauseAnimation();
                        }
                    } else if (ModuleTinyAnimationTextViewHolder.access$isAutoPlay$p(this.this$0) && (object = ModuleTinyAnimationTextViewHolder.access$getFocusAnimation$p(this.this$0)) != null) {
                        object.resumeAnimation();
                    }
                    return s.a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }, (int)3, null);
    }

    public final String getRefType() {
        return this.refType;
    }

    @Override
    public void initView(String string) {
        o.g((Object)string, (String)"module");
        super.initView(string);
        Object var2_2 = null;
        this.setView(LayoutInflater.from((Context)ModuleViewHolder.getContext$default(this, false, 1, null)).inflate(R.layout.focus_notification_module_tiny_animation_text, this.getRootView()));
        string = this.getView();
        string = string != null ? string.findViewById(R.id.focus_container_module_animation_text) : null;
        this.container = string;
        string = this.getView();
        string = string != null ? (LottieAnimationView)string.findViewById(R.id.focus_animation) : null;
        this.focusAnimation = string;
        string = this.getView();
        string = string != null ? (TextView)string.findViewById(R.id.focus_title) : null;
        this.focusTitle = string;
        string = this.getView();
        string = string != null ? (TextView)string.findViewById(R.id.focus_content) : null;
        this.focusContent = string;
        string = this.getView();
        string = string != null ? (HyperChronometer)string.findViewById(R.id.chronometer) : null;
        this.chronometer = string;
        View view = this.getView();
        string = var2_2;
        if (view != null) {
            string = view.findViewById(R.id.focus_title_container);
        }
        this.titleContainer = string;
        FullAodStatusManager.INSTANCE.addObserver((FullAodStatusManager.IFullAodStatusObserver)this);
        this.registerCompressChanged(new a(this){
            final ModuleTinyAnimationTextViewHolder this$0;
            {
                this.this$0 = moduleTinyAnimationTextViewHolder;
                super(0);
            }

            public static /* synthetic */ void b(ModuleTinyAnimationTextViewHolder moduleTinyAnimationTextViewHolder) {
                initView.1.invoke$lambda$1(moduleTinyAnimationTextViewHolder);
            }

            public static /* synthetic */ void c(ModuleTinyAnimationTextViewHolder moduleTinyAnimationTextViewHolder) {
                initView.1.invoke$lambda$0(moduleTinyAnimationTextViewHolder);
            }

            private static final void invoke$lambda$0(ModuleTinyAnimationTextViewHolder moduleTinyAnimationTextViewHolder) {
                o.g((Object)moduleTinyAnimationTextViewHolder, (String)"this$0");
                moduleTinyAnimationTextViewHolder = ModuleTinyAnimationTextViewHolder.access$getChronometer$p(moduleTinyAnimationTextViewHolder);
                if (moduleTinyAnimationTextViewHolder != null) {
                    moduleTinyAnimationTextViewHolder.requestLayout();
                }
            }

            private static final void invoke$lambda$1(ModuleTinyAnimationTextViewHolder moduleTinyAnimationTextViewHolder) {
                o.g((Object)moduleTinyAnimationTextViewHolder, (String)"this$0");
                moduleTinyAnimationTextViewHolder = ModuleTinyAnimationTextViewHolder.access$getChronometer$p(moduleTinyAnimationTextViewHolder);
                if (moduleTinyAnimationTextViewHolder != null) {
                    moduleTinyAnimationTextViewHolder.requestLayout();
                }
            }

            public final void invoke() {
                Object object = ModuleTinyAnimationTextViewHolder.access$getTitleContainer$p(this.this$0);
                int n = object != null ? object.getWidth() : 0;
                if (n > 0 && n != ModuleTinyAnimationTextViewHolder.access$getLastTitleContainerWidth$p(this.this$0)) {
                    ModuleTinyAnimationTextViewHolder.access$setLastTitleContainerWidth$p(this.this$0, n);
                    object = this.this$0;
                    int n2 = ((ModuleViewHolder)object).getTextViewWidth((TextView)ModuleTinyAnimationTextViewHolder.access$getChronometer$p((ModuleTinyAnimationTextViewHolder)object), "88:88:88");
                    Object object2 = null;
                    object = null;
                    if (n2 > n) {
                        float f2 = n;
                        float f3 = n2;
                        float f4 = f2 / f3;
                        f3 = f2 = f3 * (f4 - 1.0f) / (float)2;
                        if (CommonUtils.isLayoutRtl((Context)ModuleViewHolder.getContext$default(this.this$0, false, 1, null))) {
                            f3 = f2 * (float)-1;
                        }
                        if ((object2 = ModuleTinyAnimationTextViewHolder.access$getChronometer$p(this.this$0)) != null) {
                            object = object2.getLayoutParams();
                        }
                        if (object != null) {
                            ((ViewGroup.LayoutParams)object).width = n2;
                        }
                        object = ModuleTinyAnimationTextViewHolder.access$getChronometer$p(this.this$0);
                        if (object != null) {
                            object.setScaleX(f4);
                        }
                        object = ModuleTinyAnimationTextViewHolder.access$getChronometer$p(this.this$0);
                        if (object != null) {
                            object.setScaleY(f4);
                        }
                        object = ModuleTinyAnimationTextViewHolder.access$getChronometer$p(this.this$0);
                        if (object != null) {
                            object.setTranslationX(f3);
                        }
                        object = ModuleTinyAnimationTextViewHolder.access$getChronometer$p(this.this$0);
                        if (object != null) {
                            object.post((Runnable)new u(this.this$0));
                        }
                        object = this.this$0.getRefType();
                        object2 = new StringBuilder();
                        ((StringBuilder)object2).append(" adjust chronometer for ");
                        ((StringBuilder)object2).append((String)object);
                        ((StringBuilder)object2).append(", scale to ");
                        ((StringBuilder)object2).append(f4);
                        ((StringBuilder)object2).append(", transX to ");
                        ((StringBuilder)object2).append(f3);
                        Log.d((String)"ModuleTinyAnimationTextViewHolder", (String)((StringBuilder)object2).toString());
                    } else {
                        object = ModuleTinyAnimationTextViewHolder.access$getChronometer$p(this.this$0);
                        object = object != null ? Float.valueOf(object.getTranslationX()) : null;
                        if (!o.b((Float)object, (float)0.0f)) {
                            Log.d((String)"ModuleTinyAnimationTextViewHolder", (String)" reset chronometer state");
                            HyperChronometer hyperChronometer = ModuleTinyAnimationTextViewHolder.access$getChronometer$p(this.this$0);
                            object = object2;
                            if (hyperChronometer != null) {
                                object = hyperChronometer.getLayoutParams();
                            }
                            if (object != null) {
                                ((ViewGroup.LayoutParams)object).width = -2;
                            }
                            object = ModuleTinyAnimationTextViewHolder.access$getChronometer$p(this.this$0);
                            if (object != null) {
                                object.setScaleX(1.0f);
                            }
                            object = ModuleTinyAnimationTextViewHolder.access$getChronometer$p(this.this$0);
                            if (object != null) {
                                object.setScaleY(1.0f);
                            }
                            object = ModuleTinyAnimationTextViewHolder.access$getChronometer$p(this.this$0);
                            if (object != null) {
                                object.setTranslationX(0.0f);
                            }
                            object = ModuleTinyAnimationTextViewHolder.access$getChronometer$p(this.this$0);
                            if (object != null) {
                                object.post((Runnable)new v(this.this$0));
                            }
                        }
                    }
                }
            }
        });
    }

    @Override
    public void onDetach() {
        FullAodStatusManager.INSTANCE.removeObserver((FullAodStatusManager.IFullAodStatusObserver)this);
        f.b((E)this.getScope(), null, null, (U0.o)new U0.o(this, null){
            int label;
            final ModuleTinyAnimationTextViewHolder this$0;
            {
                this.this$0 = moduleTinyAnimationTextViewHolder;
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
                    LottieResUtils.cancelLottieAnimate$default((LottieResUtils)LottieResUtils.INSTANCE, (LottieAnimationView)ModuleTinyAnimationTextViewHolder.access$getFocusAnimation$p(this.this$0), (boolean)false, (int)2, null);
                    return s.a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }, (int)3, null);
        super.onDetach();
    }

    @Override
    public void updatePartial(Template template, StatusBarNotification statusBarNotification) {
        o.g((Object)template, (String)"template");
        o.g((Object)statusBarNotification, (String)"sbn");
        super.updatePartial(template, statusBarNotification);
        this.initTextAndColor(template.getAnimTextInfo());
        this.bind(template, statusBarNotification);
    }
}
