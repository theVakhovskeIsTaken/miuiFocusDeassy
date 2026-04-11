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
 *  android.widget.ImageView
 *  android.widget.TextView$BufferType
 *  com.airbnb.lottie.LottieAnimationView
 *  com.android.systemui.miui.notification.R$dimen
 *  com.android.systemui.miui.notification.R$id
 *  com.android.systemui.miui.notification.R$layout
 *  com.mi.widget.view.LottieView
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
 *  miui.systemui.util.StaticResUtils
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
import android.widget.ImageView;
import android.widget.TextView;
import com.airbnb.lottie.LottieAnimationView;
import com.android.systemui.miui.notification.R;
import com.mi.widget.view.LottieView;
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
import miui.systemui.notification.focus.model.TextAndColorInfo;
import miui.systemui.notification.focus.model.TimerInfo;
import miui.systemui.notification.focus.moduleV3.ModuleViewHolder;
import miui.systemui.notification.focus.moduleV3.a;
import miui.systemui.util.CommonUtils;
import miui.systemui.util.LottieResUtils;
import miui.systemui.util.StaticResUtils;
import miuix.colorful.texteffect.HyperChronometer;
import miuix.colorful.texteffect.TextChangeHelper;
import miuix.colorful.texteffect.TextChangeProcessor;
import miuix.colorful.texteffect.TimerTextEffectView;

public final class ModuleAnimationTextViewHolder
extends ModuleViewHolder
implements FullAodStatusManager.IFullAodStatusObserver {
    private HyperChronometer chronometer;
    private View container;
    private final boolean dynamicIsland;
    private final boolean fakeDynamicIsland;
    private LottieAnimationView focusAnimation;
    private ImageView focusAnimationStatic;
    private TimerTextEffectView focusContent;
    private TimerTextEffectView focusTitle;
    private boolean fullAodStatus;
    private boolean isAutoPlay;
    private float maxFrame;

    public ModuleAnimationTextViewHolder(Context context, Context context2, ViewGroup viewGroup, boolean bl, boolean bl2, boolean bl3) {
        o.g((Object)context, (String)"ctx");
        o.g((Object)context2, (String)"sysuiCtx");
        o.g((Object)viewGroup, (String)"rootView");
        super(context, context2, viewGroup, bl);
        this.dynamicIsland = bl2;
        this.fakeDynamicIsland = bl3;
        this.maxFrame = -1.0f;
    }

    public static final /* synthetic */ LottieAnimationView access$getFocusAnimation$p(ModuleAnimationTextViewHolder moduleAnimationTextViewHolder) {
        return moduleAnimationTextViewHolder.focusAnimation;
    }

    public static final /* synthetic */ boolean access$isAutoPlay$p(ModuleAnimationTextViewHolder moduleAnimationTextViewHolder) {
        return moduleAnimationTextViewHolder.isAutoPlay;
    }

    public static /* synthetic */ void c(ModuleAnimationTextViewHolder moduleAnimationTextViewHolder, Template template, h h2) {
        ModuleAnimationTextViewHolder.playAnimation$lambda$2(moduleAnimationTextViewHolder, template, h2);
    }

    private final void playAnimation(Template object, StatusBarNotification object2) {
        object2 = this.focusAnimation;
        boolean bl = false;
        if (object2 != null) {
            object2.setVisibility(0);
        }
        object2 = this.focusAnimationStatic;
        if (object2 != null) {
            object2.setVisibility(8);
        }
        object2 = this.focusAnimation;
        if (object2 != null) {
            object2.cancelAnimation();
        }
        if ((object2 = this.focusAnimation) != null) {
            object2.clearAnimation();
        }
        LottieResUtils lottieResUtils = LottieResUtils.INSTANCE;
        object2 = ((Template)object).getAnimTextInfo();
        object2 = object2 != null && (object2 = ((AnimTextInfo)object2).getAnimIconInfo()) != null ? ((AnimIconInfo)object2).getSrc() : null;
        Object object3 = ((Template)object).getAnimTextInfo();
        object3 = object3 != null && (object3 = ((AnimTextInfo)object3).getAnimIconInfo()) != null ? Integer.valueOf(((AnimIconInfo)object3).getNumber()) : null;
        o.d((Object)object3);
        int n = lottieResUtils.getLottieRes((String)object2, ((Integer)object3).intValue());
        p.s((Context)ModuleViewHolder.getContext$default(this, false, 1, null), (int)n).d((H)new a(this, (Template)object));
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
        } else if (!this.fullAodStatus && (object = this.focusAnimation) != null) {
            object.resumeAnimation();
        }
    }

    /*
     * Unable to fully structure code
     */
    private static final void playAnimation$lambda$2(ModuleAnimationTextViewHolder var0, Template var1_1, h var2_2) {
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

    private final void showStaticImage(Template object, StatusBarNotification statusBarNotification) {
        statusBarNotification = this.focusAnimation;
        if (statusBarNotification != null) {
            statusBarNotification.setVisibility(8);
        }
        statusBarNotification = this.focusAnimationStatic;
        if (statusBarNotification != null) {
            statusBarNotification.setVisibility(0);
        }
        ImageView imageView = this.focusAnimationStatic;
        if (imageView != null) {
            statusBarNotification = StaticResUtils.INSTANCE;
            object = (object = ((Template)object).getAnimTextInfo()) != null && (object = ((AnimTextInfo)object).getAnimIconInfo()) != null ? ((AnimIconInfo)object).getSrc() : null;
            imageView.setImageResource(statusBarNotification.getStaticRes((String)object));
        }
    }

    @Override
    public void bind(Template template, StatusBarNotification statusBarNotification) {
        int n;
        Object object;
        o.g((Object)template, (String)"template");
        o.g((Object)statusBarNotification, (String)"sbn");
        super.bind(template, statusBarNotification);
        this.initTextAndColor(template.getAnimTextInfo());
        Object object2 = template.getAnimTextInfo();
        Object var7_4 = null;
        object2 = object2 != null ? ((AnimTextInfo)object2).getTimerInfo() : null;
        this.initTimerData((TimerInfo)object2);
        if (this.fakeDynamicIsland) {
            statusBarNotification.getNotification().extras.putInt("miui.focus.lottieView.fake.id", R.id.focus_animation);
            object2 = statusBarNotification.getNotification().extras;
            object = template.getAnimTextInfo();
            boolean bl = object != null && (object = ((AnimTextInfo)object).getAnimIconInfo()) != null ? o.c((Object)((AnimIconInfo)object).getAutoplay(), (Object)Boolean.TRUE) : false;
            object2.putBoolean("miui.focus.lottieView.isPlay", bl);
        } else if (this.dynamicIsland) {
            statusBarNotification.getNotification().extras.putInt("miui.focus.lottieView.id", R.id.focus_animation);
            object2 = statusBarNotification.getNotification().extras;
            object = template.getAnimTextInfo();
            boolean bl = object != null && (object = ((AnimTextInfo)object).getAnimIconInfo()) != null ? o.c((Object)((AnimIconInfo)object).getAutoplay(), (Object)Boolean.TRUE) : false;
            object2.putBoolean("miui.focus.lottieView.isPlay", bl);
        }
        object2 = this.container;
        if (object2 != null) {
            object2.setVisibility(0);
        }
        this.adaptTimerDelay();
        if (!TextUtils.isEmpty((CharSequence)this.getTitle())) {
            object2 = this.focusTitle;
            if (object2 != null) {
                object2.setVisibility(0);
            }
            object2 = this.focusTitle;
            if (object2 != null) {
                object2.setText((CharSequence)Html.fromHtml((String)this.getTitle()), TextView.BufferType.SPANNABLE);
            }
            if ((object2 = this.getTitleColor()) != null) {
                n = ((Number)object2).intValue();
                object2 = this.focusTitle;
                if (object2 != null) {
                    object2.updateTextWithNewAppearance((CharSequence)Html.fromHtml((String)this.getTitle()), Integer.valueOf(n));
                }
            }
            this.updateTextSizeForTextView(this.focusTitle, R.dimen.focus_notify_title_text_size_v2);
        } else {
            object2 = this.focusTitle;
            if (object2 != null) {
                object2.setVisibility(8);
            }
        }
        if (!TextUtils.isEmpty((CharSequence)this.getContent())) {
            object2 = this.focusContent;
            if (object2 != null) {
                object2.setVisibility(0);
            }
            object2 = this.focusContent;
            if (object2 != null) {
                object2.setText((CharSequence)Html.fromHtml((String)this.getContent()), TextView.BufferType.SPANNABLE);
            }
            if ((object2 = this.getContentColor()) != null) {
                n = ((Number)object2).intValue();
                object2 = this.focusContent;
                if (object2 != null) {
                    object2.updateTextWithNewAppearance((CharSequence)Html.fromHtml((String)this.getContent()), Integer.valueOf(n));
                }
            }
            this.updateTextSizeForTextView(this.focusContent, R.dimen.focus_notify_content_text_size_v2);
        } else {
            object2 = this.focusContent;
            if (object2 != null) {
                object2.setVisibility(8);
            }
        }
        object2 = template.getAnimTextInfo();
        object2 = object2 != null ? ((AnimTextInfo)object2).getTimerInfo() : null;
        if (object2 != null) {
            object2 = this.chronometer;
            if (object2 != null) {
                object2.setVisibility(0);
            }
            ModuleViewHolder.setTimerData$default(this, 0, statusBarNotification, 1, null);
        } else {
            object2 = this.chronometer;
            if (object2 != null) {
                object2.setVisibility(8);
            }
        }
        LottieResUtils lottieResUtils = LottieResUtils.INSTANCE;
        object2 = template.getAnimTextInfo();
        object2 = object2 != null && (object2 = ((AnimTextInfo)object2).getAnimIconInfo()) != null ? ((AnimIconInfo)object2).getSrc() : null;
        TextAndColorInfo textAndColorInfo = template.getAnimTextInfo();
        object = var7_4;
        if (textAndColorInfo != null) {
            textAndColorInfo = ((AnimTextInfo)textAndColorInfo).getAnimIconInfo();
            object = var7_4;
            if (textAndColorInfo != null) {
                object = ((AnimIconInfo)textAndColorInfo).getNumber();
            }
        }
        o.d((Object)object);
        if (lottieResUtils.isNoNeedToGetLottieRes((String)object2, ((Integer)object).intValue())) {
            this.showStaticImage(template, statusBarNotification);
        } else {
            this.playAnimation(template, statusBarNotification);
        }
    }

    public void fullAodStatusChanged(boolean bl) {
        this.fullAodStatus = bl;
        f.b((E)this.getScope(), null, null, (U0.o)new U0.o(this, bl, null){
            final boolean $fullAodStatus;
            int label;
            final ModuleAnimationTextViewHolder this$0;
            {
                this.this$0 = moduleAnimationTextViewHolder;
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
                    if (ModuleAnimationTextViewHolder.access$getFocusAnimation$p(this.this$0) != null && !CommonUtils.NOT_SUPPORT_LOTTIE) {
                        if (this.$fullAodStatus) {
                            object = ModuleAnimationTextViewHolder.access$getFocusAnimation$p(this.this$0);
                            if (object != null) {
                                object.setProgress(1.0f);
                            }
                            object = ModuleAnimationTextViewHolder.access$getFocusAnimation$p(this.this$0);
                            if (object != null) {
                                object.pauseAnimation();
                            }
                        } else if (ModuleAnimationTextViewHolder.access$isAutoPlay$p(this.this$0) && (object = ModuleAnimationTextViewHolder.access$getFocusAnimation$p(this.this$0)) != null) {
                            object.resumeAnimation();
                        }
                        return s.a;
                    }
                    return s.a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }, (int)3, null);
    }

    public final boolean getDynamicIsland() {
        return this.dynamicIsland;
    }

    public final boolean getFakeDynamicIsland() {
        return this.fakeDynamicIsland;
    }

    @Override
    public void initView(String string) {
        o.g((Object)string, (String)"module");
        super.initView(string);
        this.setView(LayoutInflater.from((Context)this.getContext(this.dynamicIsland)).inflate(R.layout.focus_notification_module_animation_text, this.getRootView()));
        string = this.getView();
        Object var2_2 = null;
        string = string != null ? string.findViewById(R.id.focus_container_module_animation_text) : null;
        this.container = string;
        string = this.getView();
        string = string != null ? (LottieAnimationView)string.findViewById(R.id.focus_animation) : null;
        this.focusAnimation = string;
        string = this.getView();
        string = string != null ? (ImageView)string.findViewById(R.id.focus_animation_static) : null;
        this.focusAnimationStatic = string;
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
        if (string != null) {
            string.setEnableEffectWithInit(false);
        }
        string = this.focusTitle;
        if (string != null) {
            string.setTextChangeProcessor((TextChangeProcessor)new TextChangeHelper());
        }
        if ((string = this.focusTitle) != null) {
            string.setEnableEffectWithInit(false);
        }
        string = this.focusContent;
        if (string != null) {
            string.setTextChangeProcessor((TextChangeProcessor)new TextChangeHelper());
        }
        if ((string = this.focusContent) != null) {
            string.setEnableEffectWithInit(false);
        }
        FullAodStatusManager.INSTANCE.addObserver((FullAodStatusManager.IFullAodStatusObserver)this);
        if (this.dynamicIsland || this.fakeDynamicIsland) {
            string = this.focusAnimation;
            o.e((Object)string, (String)"null cannot be cast to non-null type com.mi.widget.view.LottieView");
            ((LottieView)string).setAdaptiveFrameRate(true);
        }
    }

    @Override
    public void onDetach() {
        FullAodStatusManager.INSTANCE.removeObserver((FullAodStatusManager.IFullAodStatusObserver)this);
        f.b((E)this.getScope(), null, null, (U0.o)new U0.o(this, null){
            int label;
            final ModuleAnimationTextViewHolder this$0;
            {
                this.this$0 = moduleAnimationTextViewHolder;
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
                    LottieResUtils.cancelLottieAnimate$default((LottieResUtils)LottieResUtils.INSTANCE, (LottieAnimationView)ModuleAnimationTextViewHolder.access$getFocusAnimation$p(this.this$0), (boolean)false, (int)2, null);
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
