/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  G0.k
 *  G0.s
 *  K0.d
 *  L0.c
 *  U0.o
 *  android.content.Context
 *  android.service.notification.StatusBarNotification
 *  android.text.Html
 *  android.text.TextUtils
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.ViewGroup
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
 *  miui.systemui.util.LottieResUtils
 *  miuix.colorful.texteffect.HyperChronometer
 *  miuix.colorful.texteffect.TextChangeHelper
 *  miuix.colorful.texteffect.TextChangeProcessor
 *  miuix.colorful.texteffect.TimerTextEffectView
 */
package miui.systemui.notification.focus.moduleV3;

import G0.k;
import G0.s;
import K0.d;
import L0.c;
import android.content.Context;
import android.service.notification.StatusBarNotification;
import android.text.Html;
import android.text.TextUtils;
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
import kotlin.jvm.internal.o;
import miui.systemui.notification.FullAodStatusManager;
import miui.systemui.notification.focus.model.AnimIconInfo;
import miui.systemui.notification.focus.model.AnimTextInfo;
import miui.systemui.notification.focus.model.Template;
import miui.systemui.notification.focus.model.TimerInfo;
import miui.systemui.notification.focus.moduleV3.ModuleViewHolder;
import miui.systemui.notification.focus.moduleV3.f;
import miui.systemui.util.LottieResUtils;
import miuix.colorful.texteffect.HyperChronometer;
import miuix.colorful.texteffect.TextChangeHelper;
import miuix.colorful.texteffect.TextChangeProcessor;
import miuix.colorful.texteffect.TimerTextEffectView;

public final class ModuleDecoLandAnimationTextViewHolder
extends ModuleViewHolder
implements FullAodStatusManager.IFullAodStatusObserver {
    private HyperChronometer chronometer;
    private View container;
    private LottieAnimationView focusAnimation;
    private TimerTextEffectView focusContent;
    private TimerTextEffectView focusTitle;
    private boolean isAutoPlay;
    private float maxFrame;

    public ModuleDecoLandAnimationTextViewHolder(Context context, Context context2, ViewGroup viewGroup, boolean bl) {
        o.g((Object)context, (String)"ctx");
        o.g((Object)context2, (String)"sysuiCtx");
        o.g((Object)viewGroup, (String)"rootView");
        super(context, context2, viewGroup, bl);
        this.maxFrame = -1.0f;
    }

    public static final /* synthetic */ LottieAnimationView access$getFocusAnimation$p(ModuleDecoLandAnimationTextViewHolder moduleDecoLandAnimationTextViewHolder) {
        return moduleDecoLandAnimationTextViewHolder.focusAnimation;
    }

    public static final /* synthetic */ boolean access$isAutoPlay$p(ModuleDecoLandAnimationTextViewHolder moduleDecoLandAnimationTextViewHolder) {
        return moduleDecoLandAnimationTextViewHolder.isAutoPlay;
    }

    public static /* synthetic */ void c(ModuleDecoLandAnimationTextViewHolder moduleDecoLandAnimationTextViewHolder, Template template, h h2) {
        ModuleDecoLandAnimationTextViewHolder.playAnimation$lambda$2(moduleDecoLandAnimationTextViewHolder, template, h2);
    }

    private final void playAnimation(Template object, StatusBarNotification object2) {
        LottieResUtils lottieResUtils = LottieResUtils.INSTANCE;
        object2 = ((Template)object).getAnimTextInfo();
        object2 = object2 != null && (object2 = ((AnimTextInfo)object2).getAnimIconInfo()) != null ? ((AnimIconInfo)object2).getSrc() : null;
        boolean bl = false;
        int n = LottieResUtils.getLottieRes$default((LottieResUtils)lottieResUtils, (String)object2, (int)0, (int)2, null);
        p.s((Context)ModuleViewHolder.getContext$default(this, false, 1, null), (int)n).d((H)new f(this, (Template)object));
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
    private static final void playAnimation$lambda$2(ModuleDecoLandAnimationTextViewHolder var0, Template var1_1, h var2_2) {
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
                    object.updateTextWithNewAppearance((CharSequence)Html.fromHtml((String)this.getTitle()), Integer.valueOf(n));
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
                    object.updateTextWithNewAppearance((CharSequence)Html.fromHtml((String)this.getContent()), Integer.valueOf(n));
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
        f1.f.b((E)this.getScope(), null, null, (U0.o)new U0.o(this, bl, null){
            final boolean $fullAodStatus;
            int label;
            final ModuleDecoLandAnimationTextViewHolder this$0;
            {
                this.this$0 = moduleDecoLandAnimationTextViewHolder;
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
                    if (ModuleDecoLandAnimationTextViewHolder.access$getFocusAnimation$p(this.this$0) == null) {
                        return s.a;
                    }
                    if (this.$fullAodStatus) {
                        object = ModuleDecoLandAnimationTextViewHolder.access$getFocusAnimation$p(this.this$0);
                        if (object != null) {
                            object.setProgress(1.0f);
                        }
                        object = ModuleDecoLandAnimationTextViewHolder.access$getFocusAnimation$p(this.this$0);
                        if (object != null) {
                            object.pauseAnimation();
                        }
                    } else if (ModuleDecoLandAnimationTextViewHolder.access$isAutoPlay$p(this.this$0) && (object = ModuleDecoLandAnimationTextViewHolder.access$getFocusAnimation$p(this.this$0)) != null) {
                        object.resumeAnimation();
                    }
                    return s.a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }, (int)3, null);
    }

    @Override
    public void initView(String string) {
        o.g((Object)string, (String)"module");
        super.initView(string);
        Object var2_2 = null;
        this.setView(LayoutInflater.from((Context)ModuleViewHolder.getContext$default(this, false, 1, null)).inflate(R.layout.focus_notification_module_deco_land_animation_text, this.getRootView()));
        string = this.getView();
        string = string != null ? string.findViewById(R.id.focus_container_module_animation_text) : null;
        this.container = string;
        string = this.getView();
        string = string != null ? (LottieAnimationView)string.findViewById(R.id.focus_animation) : null;
        this.focusAnimation = string;
        string = this.getView();
        string = string != null ? (TimerTextEffectView)string.findViewById(R.id.focus_title) : null;
        this.focusTitle = string;
        string = this.getView();
        string = string != null ? (TimerTextEffectView)string.findViewById(R.id.focus_content) : null;
        this.focusContent = string;
        View view = this.getView();
        string = var2_2;
        if (view != null) {
            string = (HyperChronometer)view.findViewById(R.id.chronometer);
        }
        this.chronometer = string;
        string = this.focusTitle;
        if (string != null) {
            string.setTextChangeProcessor((TextChangeProcessor)new TextChangeHelper());
        }
        if ((string = this.focusContent) != null) {
            string.setTextChangeProcessor((TextChangeProcessor)new TextChangeHelper());
        }
        FullAodStatusManager.INSTANCE.addObserver((FullAodStatusManager.IFullAodStatusObserver)this);
        string = this.focusTitle;
        if (string != null) {
            string.setEnableEffectWithInit(false);
        }
        string = this.focusContent;
        if (string != null) {
            string.setEnableEffectWithInit(false);
        }
    }

    @Override
    public void onDetach() {
        FullAodStatusManager.INSTANCE.removeObserver((FullAodStatusManager.IFullAodStatusObserver)this);
        f1.f.b((E)this.getScope(), null, null, (U0.o)new U0.o(this, null){
            int label;
            final ModuleDecoLandAnimationTextViewHolder this$0;
            {
                this.this$0 = moduleDecoLandAnimationTextViewHolder;
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
                    LottieResUtils.cancelLottieAnimate$default((LottieResUtils)LottieResUtils.INSTANCE, (LottieAnimationView)ModuleDecoLandAnimationTextViewHolder.access$getFocusAnimation$p(this.this$0), (boolean)false, (int)2, null);
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
