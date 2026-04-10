/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  G0.d
 *  G0.e
 *  G0.k
 *  G0.s
 *  K0.d
 *  K0.g
 *  L0.c
 *  M0.d
 *  U0.a
 *  U0.o
 *  android.animation.Animator
 *  android.animation.Animator$AnimatorListener
 *  android.annotation.SuppressLint
 *  android.content.Context
 *  android.graphics.Bitmap
 *  android.graphics.Outline
 *  android.graphics.drawable.Drawable
 *  android.graphics.drawable.Icon
 *  android.media.MediaPlayer
 *  android.media.MediaPlayer$OnErrorListener
 *  android.media.MediaPlayer$OnPreparedListener
 *  android.net.Uri
 *  android.os.Bundle
 *  android.util.Log
 *  android.view.View
 *  android.view.View$MeasureSpec
 *  android.view.ViewGroup
 *  android.view.ViewGroup$LayoutParams
 *  android.view.ViewOutlineProvider
 *  android.view.ViewStub
 *  android.widget.FrameLayout
 *  android.widget.FrameLayout$LayoutParams
 *  android.widget.ImageView
 *  androidx.core.graphics.ColorUtils
 *  androidx.core.graphics.drawable.DrawableKt
 *  androidx.core.view.OneShotPreDrawListener
 *  com.airbnb.lottie.LottieAnimationView
 *  com.airbnb.lottie.value.c
 *  com.android.systemui.plugins.miui.dynamicisland.DynamicIslandData
 *  com.mi.widget.core.Origin
 *  com.mi.widget.shader.CallingShader
 *  com.mi.widget.view.FlashLightIcon
 *  d.H
 *  d.K
 *  d.h
 *  d.p
 *  f1.E
 *  f1.b0
 *  f1.f
 *  i.e
 *  kotlin.jvm.internal.o
 *  miui.systemui.coroutines.Dispatchers
 *  miui.systemui.util.CommonUtils
 *  miui.systemui.util.LottieResUtils
 *  miui.systemui.util.ShaderUtil
 *  miui.systemui.util.StaticResUtils
 *  miui.systemui.util.VideoResUtils
 *  miui.systemui.widget.TextureVideoView
 *  miuix.mipalette.MiPalette
 */
package miui.systemui.dynamicisland.module;

import G0.k;
import G0.s;
import K0.g;
import U0.a;
import android.animation.Animator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Outline;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Icon;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewOutlineProvider;
import android.view.ViewStub;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.core.graphics.ColorUtils;
import androidx.core.graphics.drawable.DrawableKt;
import androidx.core.view.OneShotPreDrawListener;
import com.airbnb.lottie.LottieAnimationView;
import com.android.systemui.plugins.miui.dynamicisland.DynamicIslandData;
import com.mi.widget.core.Origin;
import com.mi.widget.shader.CallingShader;
import com.mi.widget.view.FlashLightIcon;
import d.H;
import d.K;
import d.h;
import d.p;
import f1.E;
import f1.b0;
import kotlin.jvm.internal.o;
import miui.systemui.coroutines.Dispatchers;
import miui.systemui.dynamicisland.DynamicFeatureConfig;
import miui.systemui.dynamicisland.DynamicIslandUtils;
import miui.systemui.dynamicisland.R;
import miui.systemui.dynamicisland.dagger.qualifiers.DynamicIsland;
import miui.systemui.dynamicisland.event.DynamicIslandEvent;
import miui.systemui.dynamicisland.model.BigIslandArea;
import miui.systemui.dynamicisland.model.ImageTextInfo;
import miui.systemui.dynamicisland.model.IslandTemplate;
import miui.systemui.dynamicisland.model.PicInfo;
import miui.systemui.dynamicisland.model.SmallIslandArea;
import miui.systemui.dynamicisland.module.BaseIslandModuleViewHolder;
import miui.systemui.dynamicisland.module.IslandIconViewHolder;
import miui.systemui.dynamicisland.module.c;
import miui.systemui.dynamicisland.module.d;
import miui.systemui.dynamicisland.module.e;
import miui.systemui.dynamicisland.module.ext.IslandIconViewHolderExtKt;
import miui.systemui.dynamicisland.module.f;
import miui.systemui.dynamicisland.module.utils.MiPaletteUtils;
import miui.systemui.util.CommonUtils;
import miui.systemui.util.LottieResUtils;
import miui.systemui.util.ShaderUtil;
import miui.systemui.util.StaticResUtils;
import miui.systemui.util.VideoResUtils;
import miui.systemui.widget.TextureVideoView;
import miuix.mipalette.MiPalette;

public final class IslandIconViewHolder
extends BaseIslandModuleViewHolder {
    public static final Companion Companion = new Object(null){
        {
            this();
        }

        public final int getGradientBottomColor() {
            return gradientBottomColor;
        }

        public final int getGradientTopColor() {
            return gradientTopColor;
        }

        public final void setGradientBottomColor(int n) {
            gradientBottomColor = n;
        }

        public final void setGradientTopColor(int n) {
            gradientTopColor = n;
        }
    };
    private static final int LOTTIE_COLOR_ALPHA_60_PERCENT = 153;
    private static final String TAG = "IslandIconViewHolder";
    private static final int TONE_INDEX_PRIMARY = 12;
    private static final int TONE_INDEX_TERTIARY = 14;
    private static int gradientBottomColor;
    private static int gradientTopColor;
    private boolean alreadyRemoveFaceRecognition;
    private ImageView appIcon;
    private ViewStub appIconStub;
    private String currentShaderEffectSrc;
    private DynamicIslandData data;
    private boolean effectEnable;
    private ImageView fixIcon;
    private ViewStub fixIconStub;
    private FlashLightIcon flashIcon;
    private ViewStub flashIconStub;
    private ImageView icon;
    private FrameLayout iconContainer;
    private ViewStub iconStub;
    private final E islandScope;
    private TextureVideoView islandVideo;
    private ViewStub islandVideoStub;
    private LottieAnimationView lottieBigView;
    private ImageView lottieBigViewStatic;
    private ViewStub lottieBigViewStaticStub;
    private ViewStub lottieBigViewStub;
    private LottieAnimationView lottieView;
    private ImageView lottieViewStatic;
    private ViewStub lottieViewStaticStub;
    private ViewStub lottieViewStub;
    private float maxFrame;
    private PicInfo picInfo;
    private final G0.d roundedCornerOutlineProvider$delegate;
    private CallingShader<?> shader;
    private ImageView smallIcon;
    private ViewStub smallIconStub;
    private FrameLayout smallTextOverIconContainer;

    static {
        gradientTopColor = -1;
        gradientBottomColor = -1;
    }

    public IslandIconViewHolder(Context context, @DynamicIsland E e2, ViewGroup viewGroup, U0.o o2) {
        o.g((Object)context, (String)"context");
        o.g((Object)e2, (String)"scope");
        o.g((Object)viewGroup, (String)"rootView");
        o.g((Object)o2, (String)"emitEvent");
        super(context, viewGroup, o2);
        this.maxFrame = -1.0f;
        this.effectEnable = true;
        this.roundedCornerOutlineProvider$delegate = G0.e.b((a)new a(context){
            final Context $context;
            {
                this.$context = context;
                super(0);
            }

            public final roundedCornerOutlineProvider.1 invoke() {
                return new ViewOutlineProvider(this.$context){
                    private final float cornerRadius;
                    {
                        this.cornerRadius = context.getResources().getDimension(R.dimen.island_icon_radius);
                    }

                    public void getOutline(View view, Outline outline) {
                        if (outline != null && view != null) {
                            outline.setRoundRect(0, 0, view.getWidth(), view.getHeight(), this.cornerRadius);
                        }
                    }
                };
            }
        });
        this.islandScope = e2;
    }

    public static /* synthetic */ void a(IslandIconViewHolder islandIconViewHolder, MediaPlayer mediaPlayer) {
        IslandIconViewHolder.setMP4Icon$lambda$1(islandIconViewHolder, mediaPlayer);
    }

    public static final /* synthetic */ void access$clearFaceRecognition(IslandIconViewHolder islandIconViewHolder, DynamicIslandData dynamicIslandData) {
        islandIconViewHolder.clearFaceRecognition(dynamicIslandData);
    }

    public static final /* synthetic */ String access$getCurrentShaderEffectSrc$p(IslandIconViewHolder islandIconViewHolder) {
        return islandIconViewHolder.currentShaderEffectSrc;
    }

    public static final /* synthetic */ ImageView access$getIcon$p(IslandIconViewHolder islandIconViewHolder) {
        return islandIconViewHolder.icon;
    }

    public static final /* synthetic */ CallingShader access$getShader$p(IslandIconViewHolder islandIconViewHolder) {
        return islandIconViewHolder.shader;
    }

    public static final /* synthetic */ void access$setCurrentShaderEffectSrc$p(IslandIconViewHolder islandIconViewHolder, String string) {
        islandIconViewHolder.currentShaderEffectSrc = string;
    }

    public static final /* synthetic */ void access$setLottieColor(IslandIconViewHolder islandIconViewHolder, Bitmap bitmap) {
        islandIconViewHolder.setLottieColor(bitmap);
    }

    public static final /* synthetic */ void access$setShader$p(IslandIconViewHolder islandIconViewHolder, CallingShader callingShader) {
        islandIconViewHolder.shader = callingShader;
    }

    public static /* synthetic */ void b(IslandIconViewHolder islandIconViewHolder, h h2) {
        IslandIconViewHolder.playAnimation$lambda$4(islandIconViewHolder, h2);
    }

    public static /* synthetic */ void c(IslandIconViewHolder islandIconViewHolder, DynamicIslandData dynamicIslandData, h h2) {
        IslandIconViewHolder.playBigAnimation$lambda$5(islandIconViewHolder, dynamicIslandData, h2);
    }

    private final void clearFaceRecognition(DynamicIslandData object) {
        Object object2 = this.picInfo;
        object2 = object2 != null ? ((PicInfo)object2).getPic() : null;
        if ((o.c((Object)object2, (Object)"face_recognition_success_small") || o.c((Object)(object2 = (object2 = this.picInfo) != null ? ((PicInfo)object2).getPic() : null), (Object)"face_recognition_failed_small")) && !this.alreadyRemoveFaceRecognition) {
            this.alreadyRemoveFaceRecognition = true;
            Log.d((String)TAG, (String)"clearFaceRecognition destroyBigIsland");
            this.destroyBigIsland((DynamicIslandData)object);
            LottieResUtils.INSTANCE.cancelLottieAnimate(this.lottieBigView, false);
            object = this.picInfo;
            if (object != null) {
                ((PicInfo)object).setPic(null);
            }
        }
    }

    public static /* synthetic */ boolean d(IslandIconViewHolder islandIconViewHolder, MediaPlayer mediaPlayer, int n, int n2) {
        return IslandIconViewHolder.setMP4Icon$lambda$2(islandIconViewHolder, mediaPlayer, n, n2);
    }

    private final void destroyBigIsland(DynamicIslandData dynamicIslandData) {
        super.getEmitEvent().invoke((Object)dynamicIslandData, (Object)DynamicIslandEvent.DeletedDynamicIsland.INSTANCE);
    }

    private final Icon getIconSafe(Bundle bundle, String string) {
        Icon icon = null;
        Object object = icon;
        if (bundle != null) {
            try {
                object = (Icon)bundle.getParcelable(string, Icon.class);
            }
            catch (Exception exception) {
                object = new StringBuilder();
                ((StringBuilder)object).append("getIconSafe failed for key=");
                ((StringBuilder)object).append(string);
                Log.e((String)TAG, (String)((StringBuilder)object).toString(), (Throwable)exception);
                object = icon;
            }
        }
        return object;
    }

    private final roundedCornerOutlineProvider.1 getRoundedCornerOutlineProvider() {
        return (Object)this.roundedCornerOutlineProvider$delegate.getValue();
    }

    private final Drawable loadDrawableSafe(Icon icon, Context context) {
        Drawable drawable;
        Drawable drawable2 = drawable = null;
        if (icon != null) {
            try {
                drawable2 = icon.loadDrawable(context);
            }
            catch (Exception exception) {
                Log.e((String)TAG, (String)"loadDrawableSafe failed", (Throwable)exception);
                drawable2 = drawable;
            }
        }
        return drawable2;
    }

    private final void playAnimation() {
        LottieAnimationView lottieAnimationView = this.lottieView;
        Integer n = null;
        Object object = lottieAnimationView;
        if (lottieAnimationView == null && !((object = (object = this.lottieViewStub) != null ? object.inflate() : null) instanceof LottieAnimationView)) {
            object = null;
        }
        this.lottieView = object;
        object = this.lottieViewStatic;
        if (object != null) {
            object.setVisibility(8);
        }
        object = this.lottieBigView;
        if (object != null) {
            object.setVisibility(8);
        }
        object = this.lottieBigViewStatic;
        if (object != null) {
            object.setVisibility(8);
        }
        object = this.islandVideo;
        if (object != null) {
            object.setVisibility(8);
        }
        object = this.appIcon;
        if (object != null) {
            object.setVisibility(8);
        }
        object = this.icon;
        if (object != null) {
            object.setVisibility(8);
        }
        object = this.fixIcon;
        if (object != null) {
            object.setVisibility(8);
        }
        object = this.smallIcon;
        if (object != null) {
            object.setVisibility(8);
        }
        object = this.flashIcon;
        if (object != null) {
            object.setVisibility(8);
        }
        object = this.shader;
        if (object != null) {
            object.stop();
        }
        if ((object = this.lottieView) != null) {
            object.cancelAnimation();
        }
        if ((object = this.lottieView) != null) {
            object.clearAnimation();
        }
        lottieAnimationView = LottieResUtils.INSTANCE;
        object = this.picInfo;
        object = object != null ? ((PicInfo)object).getPic() : null;
        PicInfo picInfo = this.picInfo;
        if (picInfo != null) {
            n = picInfo.getNumber();
        }
        o.d(n);
        int n2 = lottieAnimationView.getLottieRes((String)object, n.intValue());
        IslandIconViewHolderExtKt.checkRes(n2, (View)this.lottieView);
        p.s((Context)this.getContext(), (int)n2).d((H)new c(this));
    }

    /*
     * Unable to fully structure code
     */
    private static final void playAnimation$lambda$4(IslandIconViewHolder var0, h var1_1) {
        o.g((Object)var0, (String)"this$0");
        var5_2 = var0.lottieView;
        if (var5_2 != null) {
            var5_2.setComposition((h)var1_1);
        }
        var2_3 = (var1_1 = var0.lottieView) != null ? var1_1.getMaxFrame() : 0.0f;
        var0.maxFrame = var2_3;
        var1_1 = var0.picInfo;
        var5_2 = null;
        var1_1 = var1_1 != null ? Integer.valueOf(var1_1.getNumber()) : null;
        var3_4 = true;
        if (var1_1 == null) ** GOTO lbl-1000
        var1_1 = var0.picInfo;
        var1_1 = var1_1 != null ? Integer.valueOf(var1_1.getNumber()) : null;
        o.d((Object)var1_1);
        if (var1_1.intValue() > 0) {
            var6_5 = var0.lottieView;
            if (var6_5 != null) {
                var7_6 = var0.picInfo;
                var1_1 = var5_2;
                if (var7_6 != null) {
                    var1_1 = var7_6.getNumber();
                }
                o.d((Object)var1_1);
                var6_5.setRepeatCount(var1_1.intValue() - 1);
            }
        } else if ((var1_1 = var0.lottieView) != null) {
            var1_1.setRepeatCount(-1);
        }
        var1_1 = var0.lottieView;
        if (var1_1 != null) {
            var1_1.setRepeatMode(1);
        }
        var1_1 = var0.lottieView;
        if (var1_1 != null) {
            var1_1.setProgress(0.0f);
        }
        var1_1 = var0.picInfo;
        var4_7 = var1_1 != null ? o.c((Object)var1_1.getAutoplay(), (Object)Boolean.FALSE) : false;
        if (var4_7) ** GOTO lbl-1000
        if (!CommonUtils.NOT_SUPPORT_LOTTIE) ** GOTO lbl-1000
        var1_1 = var0.picInfo;
        if (var1_1 == null || var1_1.getNumber() != 1) {
            var3_4 = false;
        }
        if (var3_4) lbl-1000:
        // 2 sources

        {
            if ((var1_1 = var0.lottieView) != null) {
                var1_1.playAnimation();
            }
        } else if ((var1_1 = var0.lottieView) != null) {
            var1_1.pauseAnimation();
        }
        var0.registerLottieCallback();
    }

    private final void playBigAnimation(DynamicIslandData dynamicIslandData) {
        LottieAnimationView lottieAnimationView = this.lottieBigView;
        Integer n = null;
        Object object = lottieAnimationView;
        if (lottieAnimationView == null && !((object = (object = this.lottieBigViewStub) != null ? object.inflate() : null) instanceof LottieAnimationView)) {
            object = null;
        }
        this.lottieBigView = object;
        object = this.lottieView;
        if (object != null) {
            object.setVisibility(8);
        }
        object = this.lottieViewStatic;
        if (object != null) {
            object.setVisibility(8);
        }
        object = this.lottieBigViewStatic;
        if (object != null) {
            object.setVisibility(8);
        }
        object = this.islandVideo;
        if (object != null) {
            object.setVisibility(8);
        }
        object = this.appIcon;
        if (object != null) {
            object.setVisibility(8);
        }
        object = this.icon;
        if (object != null) {
            object.setVisibility(8);
        }
        object = this.fixIcon;
        if (object != null) {
            object.setVisibility(8);
        }
        object = this.smallIcon;
        if (object != null) {
            object.setVisibility(8);
        }
        object = this.flashIcon;
        if (object != null) {
            object.setVisibility(8);
        }
        object = this.shader;
        if (object != null) {
            object.stop();
        }
        if ((object = this.lottieBigView) != null) {
            object.removeAllAnimatorListeners();
        }
        if ((object = this.lottieBigView) != null) {
            object.cancelAnimation();
        }
        if ((object = this.lottieBigView) != null) {
            object.clearAnimation();
        }
        lottieAnimationView = LottieResUtils.INSTANCE;
        object = this.picInfo;
        object = object != null ? ((PicInfo)object).getPic() : null;
        PicInfo picInfo = this.picInfo;
        if (picInfo != null) {
            n = picInfo.getNumber();
        }
        o.d(n);
        int n2 = lottieAnimationView.getLottieRes((String)object, n.intValue());
        IslandIconViewHolderExtKt.checkRes(n2, (View)this.lottieBigView);
        p.s((Context)this.getContext(), (int)n2).d((H)new d(this, dynamicIslandData));
    }

    /*
     * Unable to fully structure code
     */
    private static final void playBigAnimation$lambda$5(IslandIconViewHolder var0, DynamicIslandData var1_1, h var2_2) {
        block20: {
            block16: {
                block19: {
                    block18: {
                        block17: {
                            o.g((Object)var0, (String)"this$0");
                            var6_3 = var0.lottieBigView;
                            if (var6_3 != null) {
                                var6_3.setComposition((h)var2_2);
                            }
                            var3_4 = (var2_2 = var0.lottieBigView) != null ? var2_2.getMaxFrame() : 0.0f;
                            var0.maxFrame = var3_4;
                            var2_2 = var0.picInfo;
                            var6_3 = null;
                            var2_2 = var2_2 != null ? Integer.valueOf(var2_2.getNumber()) : null;
                            var4_5 = true;
                            if (var2_2 == null) ** GOTO lbl-1000
                            var2_2 = var0.picInfo;
                            var2_2 = var2_2 != null ? Integer.valueOf(var2_2.getNumber()) : null;
                            o.d((Object)var2_2);
                            if (var2_2.intValue() > 0) {
                                var7_6 = var0.lottieBigView;
                                if (var7_6 != null) {
                                    var2_2 = var0.picInfo;
                                    var2_2 = var2_2 != null ? Integer.valueOf(var2_2.getNumber()) : null;
                                    o.d((Object)var2_2);
                                    var7_6.setRepeatCount(var2_2.intValue() - 1);
                                }
                            } else if ((var2_2 = var0.lottieBigView) != null) {
                                var2_2.setRepeatCount(-1);
                            }
                            if ((var2_2 = var0.lottieBigView) != null) {
                                var2_2.setRepeatMode(1);
                            }
                            var2_2 = var0.lottieBigView;
                            if (var2_2 != null) {
                                var2_2.setProgress(0.0f);
                            }
                            var2_2 = var0.picInfo;
                            var5_7 = var2_2 != null ? o.c((Object)var2_2.getAutoplay(), (Object)Boolean.FALSE) : false;
                            if (var5_7) break block16;
                            if (!CommonUtils.NOT_SUPPORT_LOTTIE) break block17;
                            var2_2 = var0.picInfo;
                            if (var2_2 == null || var2_2.getNumber() != 1) {
                                var4_5 = false;
                            }
                            if (!var4_5) break block16;
                        }
                        if (o.c((Object)(var2_2 = (var2_2 = var0.picInfo) != null ? var2_2.getPic() : null), (Object)"face_recognition_success_small")) break block18;
                        var7_6 = var0.picInfo;
                        var2_2 = var6_3;
                        if (var7_6 != null) {
                            var2_2 = var7_6.getPic();
                        }
                        if (!o.c((Object)var2_2, (Object)"face_recognition_failed_small")) break block19;
                    }
                    if ((var2_2 = var0.lottieBigView) != null) {
                        var2_2.addAnimatorListener(new Animator.AnimatorListener(var0, var1_1){
                            final DynamicIslandData $data;
                            final IslandIconViewHolder this$0;
                            {
                                this.this$0 = islandIconViewHolder;
                                this.$data = dynamicIslandData;
                            }

                            public void onAnimationCancel(Animator animator) {
                                o.g((Object)animator, (String)"animator");
                                IslandIconViewHolder.access$clearFaceRecognition(this.this$0, this.$data);
                            }

                            public void onAnimationEnd(Animator animator) {
                                o.g((Object)animator, (String)"animator");
                                IslandIconViewHolder.access$clearFaceRecognition(this.this$0, this.$data);
                            }

                            public void onAnimationRepeat(Animator animator) {
                                o.g((Object)animator, (String)"animator");
                            }

                            public void onAnimationStart(Animator animator) {
                                o.g((Object)animator, (String)"animator");
                            }
                        });
                    }
                }
                if ((var0 = var0.lottieBigView) != null) {
                    var0.playAnimation();
                }
                break block20;
            }
            if ((var0 = var0.lottieBigView) != null) {
                var0.pauseAnimation();
            }
        }
    }

    private final void registerLottieCallback() {
        LottieResUtils lottieResUtils = LottieResUtils.INSTANCE;
        Object object = this.picInfo;
        object = object != null ? ((PicInfo)object).getPic() : null;
        if (lottieResUtils.isNeedUpdateColor((String)object) && this.lottieView != null) {
            lottieResUtils = new i.e(new String[]{"**", "Gradient Fill 1"});
            object = this.lottieView;
            if (object != null) {
                object.addValueCallback((i.e)lottieResUtils, (Object)K.L, (com.airbnb.lottie.value.c)GradientLottieValueCallback.INSTANCE);
            }
        }
    }

    private final void setAppIcon(DynamicIslandData dynamicIslandData) {
        Object object = this.shader;
        if (object != null) {
            object.stop();
        }
        if (!(o.c((Object)this.getModule(), (Object)"moduleImageText_1") || o.c((Object)this.getModule(), (Object)"moduleImageText_3") || o.c((Object)this.getModule(), (Object)"modulePicSmallIsland") || o.c((Object)this.getModule(), (Object)"moduleCombinePic"))) {
            dynamicIslandData = this.iconContainer;
            if (dynamicIslandData != null) {
                dynamicIslandData.setVisibility(8);
            }
        } else {
            Object object2 = this.appIcon;
            Object var4_4 = null;
            object = object2;
            if (object2 == null && !((object = (object = this.appIconStub) != null ? object.inflate() : null) instanceof ImageView)) {
                object = null;
            }
            this.appIcon = object;
            if (object != null) {
                object.setVisibility(0);
            }
            object = this.icon;
            if (object != null) {
                object.setVisibility(8);
            }
            object = this.lottieView;
            if (object != null) {
                object.setVisibility(8);
            }
            object = this.lottieViewStatic;
            if (object != null) {
                object.setVisibility(8);
            }
            object = this.lottieBigView;
            if (object != null) {
                object.setVisibility(8);
            }
            object = this.lottieBigViewStatic;
            if (object != null) {
                object.setVisibility(8);
            }
            object = this.islandVideo;
            if (object != null) {
                object.setVisibility(8);
            }
            object = this.fixIcon;
            if (object != null) {
                object.setVisibility(8);
            }
            object = this.smallIcon;
            if (object != null) {
                object.setVisibility(8);
            }
            object = this.flashIcon;
            if (object != null) {
                object.setVisibility(8);
            }
            object = dynamicIslandData != null && (object = dynamicIslandData.getExtras()) != null ? object.getString("miui.pkg.name") : null;
            object2 = var4_4;
            if (dynamicIslandData != null) {
                dynamicIslandData = dynamicIslandData.getExtras();
                object2 = var4_4;
                if (dynamicIslandData != null) {
                    object2 = dynamicIslandData.getInt("miui.user.id");
                }
            }
            if ((object = DynamicIslandUtils.INSTANCE.getAppIcon(this.getContext(), (String)object, (Integer)object2)) != null) {
                object.setAutoMirrored(false);
            }
            if (object != null) {
                dynamicIslandData = this.appIcon;
                if (dynamicIslandData != null) {
                    dynamicIslandData.setImageDrawable((Drawable)object);
                }
            } else {
                dynamicIslandData = this.iconContainer;
                if (dynamicIslandData != null) {
                    dynamicIslandData.setVisibility(8);
                }
            }
        }
    }

    private final void setFixIcon(DynamicIslandData object) {
        Object object2 = this.fixIcon;
        Object var5_3 = null;
        Object object3 = object2;
        if (object2 == null && !((object3 = (object3 = this.fixIconStub) != null ? object3.inflate() : null) instanceof ImageView)) {
            object3 = null;
        }
        this.fixIcon = object3;
        if (object3 != null) {
            object3.setVisibility(0);
        }
        object3 = this.lottieView;
        if (object3 != null) {
            object3.setVisibility(8);
        }
        object3 = this.lottieViewStatic;
        if (object3 != null) {
            object3.setVisibility(8);
        }
        object3 = this.lottieBigView;
        if (object3 != null) {
            object3.setVisibility(8);
        }
        object3 = this.lottieBigViewStatic;
        if (object3 != null) {
            object3.setVisibility(8);
        }
        object3 = this.islandVideo;
        if (object3 != null) {
            object3.setVisibility(8);
        }
        object3 = this.appIcon;
        if (object3 != null) {
            object3.setVisibility(8);
        }
        object3 = this.icon;
        if (object3 != null) {
            object3.setVisibility(8);
        }
        object3 = this.smallIcon;
        if (object3 != null) {
            object3.setVisibility(8);
        }
        object3 = this.flashIcon;
        if (object3 != null) {
            object3.setVisibility(8);
        }
        object3 = this.shader;
        if (object3 != null) {
            object3.stop();
        }
        object3 = (object3 = this.picInfo) != null ? ((PicInfo)object3).getPic() : null;
        object2 = this.getBitmapBundle();
        object2 = object2 != null ? this.getIconSafe((Bundle)object2, (String)object3) : null;
        Drawable drawable = object2 != null ? this.loadDrawableSafe((Icon)object2, this.getContext()) : null;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("setFixIcon: key: ");
        stringBuilder.append((String)object3);
        stringBuilder.append(", pic: ");
        stringBuilder.append(object2);
        Log.d((String)TAG, (String)stringBuilder.toString());
        if (object2 != null && drawable != null) {
            drawable.setAutoMirrored(false);
            object = this.fixIcon;
            if (object != null) {
                object.setImageDrawable(drawable);
                object.setOutlineProvider((ViewOutlineProvider)this.getRoundedCornerOutlineProvider());
                object.setClipToOutline(true);
                object.invalidate();
            }
            if (LottieResUtils.INSTANCE.isNeedToGetLottieColor((String)object3)) {
                f1.f.b((E)this.islandScope, null, null, (U0.o)new U0.o(this, drawable, null){
                    final Drawable $drawable;
                    int label;
                    final IslandIconViewHolder this$0;
                    {
                        this.this$0 = islandIconViewHolder;
                        this.$drawable = drawable2;
                        super(2, d2);
                    }

                    public final K0.d create(Object object, K0.d d2) {
                        return new /* invalid duplicate definition of identical inner class */;
                    }

                    public final Object invoke(E e2, K0.d d2) {
                        return (this.create(e2, d2)).invokeSuspend(s.a);
                    }

                    /*
                     * Enabled force condition propagation
                     * Lifted jumps to return sites
                     */
                    public final Object invokeSuspend(Object object) {
                        Object object2 = L0.c.c();
                        int n = this.label;
                        if (n != 0) {
                            if (n != 1) throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            k.b((Object)object);
                            return s.a;
                        } else {
                            k.b((Object)object);
                            b0 b02 = Dispatchers.INSTANCE.getIO();
                            U0.o o2 = new U0.o(this.this$0, this.$drawable, null){
                                final Drawable $drawable;
                                int label;
                                final IslandIconViewHolder this$0;
                                {
                                    this.this$0 = islandIconViewHolder;
                                    this.$drawable = drawable2;
                                    super(2, d2);
                                }

                                public final K0.d create(Object object, K0.d d2) {
                                    return new /* invalid duplicate definition of identical inner class */;
                                }

                                public final Object invoke(E e2, K0.d d2) {
                                    return (this.create(e2, d2)).invokeSuspend(s.a);
                                }

                                public final Object invokeSuspend(Object object) {
                                    L0.c.c();
                                    if (this.label == 0) {
                                        k.b((Object)object);
                                        IslandIconViewHolder.access$setLottieColor(this.this$0, DrawableKt.toBitmap$default((Drawable)this.$drawable, (int)0, (int)0, null, (int)7, null));
                                        return s.a;
                                    }
                                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                }
                            };
                            this.label = 1;
                            if (f1.f.c((g)b02, (U0.o)o2, (K0.d)this) != object2) return s.a;
                            return object2;
                        }
                    }
                }, (int)3, null);
            }
            if ((object3 = this.fixIcon) != null) {
                object2 = this.picInfo;
                object = var5_3;
                if (object2 != null) {
                    object = ((PicInfo)object2).getContentDescription();
                }
                object3.setContentDescription((CharSequence)object);
            }
            return;
        }
        this.setAppIcon((DynamicIslandData)object);
    }

    /*
     * WARNING - void declaration
     * Enabled aggressive block sorting
     */
    private final void setIcon(DynamicIslandData object) {
        Object object2 = this.icon;
        Object var8_11 = null;
        Object object3 = object2;
        if (object2 == null && !((object3 = (object3 = this.iconStub) != null ? object3.inflate() : null) instanceof ImageView)) {
            object3 = null;
        }
        this.icon = object3;
        boolean bl = false;
        if (object3 != null) {
            object3.setVisibility(0);
        }
        object3 = this.lottieView;
        if (object3 != null) {
            object3.setVisibility(8);
        }
        object3 = this.lottieViewStatic;
        if (object3 != null) {
            object3.setVisibility(8);
        }
        object3 = this.lottieBigView;
        if (object3 != null) {
            object3.setVisibility(8);
        }
        object3 = this.lottieBigViewStatic;
        if (object3 != null) {
            object3.setVisibility(8);
        }
        object3 = this.islandVideo;
        if (object3 != null) {
            object3.setVisibility(8);
        }
        object3 = this.appIcon;
        if (object3 != null) {
            object3.setVisibility(8);
        }
        object3 = this.fixIcon;
        if (object3 != null) {
            object3.setVisibility(8);
        }
        object3 = this.smallIcon;
        if (object3 != null) {
            object3.setVisibility(8);
        }
        object3 = this.flashIcon;
        if (object3 != null) {
            object3.setVisibility(8);
        }
        object3 = this.picInfo;
        object3 = object3 != null ? ((PicInfo)object3).getPic() : null;
        object2 = this.getBitmapBundle();
        Icon icon = object2 != null ? this.getIconSafe((Bundle)object2, (String)object3) : null;
        object2 = icon != null ? this.loadDrawableSafe(icon, this.getContext()) : null;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("setIcon: key: ");
        stringBuilder.append((String)object3);
        stringBuilder.append(", pic: ");
        stringBuilder.append(icon);
        Log.d((String)TAG, (String)stringBuilder.toString());
        if (icon != null && object2 != null) {
            void var1_9;
            void var1_5;
            object2.setAutoMirrored(false);
            if (object != null) {
                bl = DynamicIslandUtils.INSTANCE.isDynamicIslandPadNoPropOnce((DynamicIslandData)object);
            }
            float f2 = bl ? this.getContext().getResources().getDimension(R.dimen.island_app_icon_size_pad) : this.getContext().getResources().getDimension(R.dimen.island_fix_icon_size);
            int n = (int)f2;
            n = object2.getIntrinsicWidth() * n / object2.getIntrinsicHeight();
            ImageView imageView = this.icon;
            if (imageView != null) {
                ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
            } else {
                Object var1_4 = null;
            }
            if (var1_5 != null) {
                var1_5.width = n;
            }
            ImageView imageView2 = this.icon;
            if (imageView2 != null) {
                imageView2.setImageDrawable((Drawable)object2);
            }
            if ((object3 = this.icon) == null) {
                return;
            }
            object2 = this.picInfo;
            Object var1_7 = var8_11;
            if (object2 != null) {
                String string = ((PicInfo)object2).getContentDescription();
            }
            object3.setContentDescription((CharSequence)var1_9);
            return;
        }
        this.setAppIcon((DynamicIslandData)object);
    }

    private final void setLottieColor(Bitmap object) {
        int n = MiPalette.getMainColorHCT((Bitmap)object);
        object = MiPaletteUtils.INSTANCE;
        int n2 = ((MiPaletteUtils)object).getPaletteColorSafe(n, "tertiary", 14);
        n = ((MiPaletteUtils)object).getPaletteColorSafe(n, "primary", 12);
        gradientTopColor = ColorUtils.setAlphaComponent((int)n2, (int)153);
        gradientBottomColor = ColorUtils.setAlphaComponent((int)n, (int)153);
    }

    private final void setMP4Icon(DynamicIslandData dynamicIslandData) {
        Object object = this.islandVideo;
        String string = null;
        Object object2 = object;
        if (object == null && !((object2 = (object2 = this.islandVideoStub) != null ? object2.inflate() : null) instanceof TextureVideoView)) {
            object2 = null;
        }
        this.islandVideo = object2;
        if (object2 != null) {
            object2.setVisibility(0);
        }
        object2 = this.lottieView;
        if (object2 != null) {
            object2.setVisibility(8);
        }
        object2 = this.lottieViewStatic;
        if (object2 != null) {
            object2.setVisibility(8);
        }
        object2 = this.lottieBigView;
        if (object2 != null) {
            object2.setVisibility(8);
        }
        object2 = this.lottieBigViewStatic;
        if (object2 != null) {
            object2.setVisibility(8);
        }
        object2 = this.appIcon;
        if (object2 != null) {
            object2.setVisibility(8);
        }
        object2 = this.icon;
        if (object2 != null) {
            object2.setVisibility(8);
        }
        object2 = this.fixIcon;
        if (object2 != null) {
            object2.setVisibility(8);
        }
        object2 = this.smallIcon;
        if (object2 != null) {
            object2.setVisibility(8);
        }
        object2 = this.flashIcon;
        if (object2 != null) {
            object2.setVisibility(8);
        }
        object2 = this.shader;
        if (object2 != null) {
            object2.stop();
        }
        object2 = (object2 = this.picInfo) != null ? ((PicInfo)object2).getPic() : null;
        object = this.picInfo;
        if (object != null) {
            string = ((PicInfo)object).getPic();
        }
        object = new StringBuilder();
        ((StringBuilder)object).append("setMP4Icon: ");
        ((StringBuilder)object).append(string);
        ((StringBuilder)object).append(" ");
        ((StringBuilder)object).append((String)object2);
        Log.d((String)TAG, (String)((StringBuilder)object).toString());
        if (object2 != null) {
            dynamicIslandData = this.islandVideo;
            if (dynamicIslandData != null) {
                dynamicIslandData.setVideoURI(Uri.parse((String)VideoResUtils.INSTANCE.getVideoRes((String)object2, this.getContext())));
            }
            if ((dynamicIslandData = this.islandVideo) != null) {
                dynamicIslandData.setOnPreparedListener((MediaPlayer.OnPreparedListener)new e(this));
            }
            if ((dynamicIslandData = this.islandVideo) != null) {
                dynamicIslandData.setOnErrorListener((MediaPlayer.OnErrorListener)new f(this));
            }
        } else {
            this.setAppIcon(dynamicIslandData);
        }
    }

    private static final void setMP4Icon$lambda$1(IslandIconViewHolder islandIconViewHolder, MediaPlayer mediaPlayer) {
        o.g((Object)islandIconViewHolder, (String)"this$0");
        PicInfo picInfo = islandIconViewHolder.picInfo;
        boolean bl = picInfo != null ? o.c((Object)picInfo.getLoop(), (Object)Boolean.TRUE) : false;
        mediaPlayer.setLooping(bl);
        islandIconViewHolder = islandIconViewHolder.islandVideo;
        if (islandIconViewHolder != null) {
            islandIconViewHolder.start();
        }
    }

    private static final boolean setMP4Icon$lambda$2(IslandIconViewHolder islandIconViewHolder, MediaPlayer mediaPlayer, int n, int n2) {
        o.g((Object)islandIconViewHolder, (String)"this$0");
        islandIconViewHolder = islandIconViewHolder.islandVideo;
        if (islandIconViewHolder != null) {
            islandIconViewHolder.stopPlayback();
        }
        return true;
    }

    private final void setSmallIcon(DynamicIslandData object) {
        Object object2 = this.smallIcon;
        Object var5_3 = null;
        Object object3 = object2;
        if (object2 == null && !((object3 = (object3 = this.smallIconStub) != null ? object3.inflate() : null) instanceof ImageView)) {
            object3 = null;
        }
        this.smallIcon = object3;
        if (object3 != null) {
            object3.setVisibility(0);
        }
        object3 = this.lottieView;
        if (object3 != null) {
            object3.setVisibility(8);
        }
        object3 = this.lottieViewStatic;
        if (object3 != null) {
            object3.setVisibility(8);
        }
        object3 = this.lottieBigView;
        if (object3 != null) {
            object3.setVisibility(8);
        }
        object3 = this.lottieBigViewStatic;
        if (object3 != null) {
            object3.setVisibility(8);
        }
        object3 = this.islandVideo;
        if (object3 != null) {
            object3.setVisibility(8);
        }
        object3 = this.appIcon;
        if (object3 != null) {
            object3.setVisibility(8);
        }
        object3 = this.icon;
        if (object3 != null) {
            object3.setVisibility(8);
        }
        object3 = this.fixIcon;
        if (object3 != null) {
            object3.setVisibility(8);
        }
        object3 = this.flashIcon;
        if (object3 != null) {
            object3.setVisibility(8);
        }
        object3 = this.shader;
        if (object3 != null) {
            object3.stop();
        }
        object3 = (object3 = this.picInfo) != null ? ((PicInfo)object3).getPic() : null;
        object2 = this.getBitmapBundle();
        object2 = object2 != null ? this.getIconSafe((Bundle)object2, (String)object3) : null;
        Drawable drawable = object2 != null ? this.loadDrawableSafe((Icon)object2, this.getContext()) : null;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("setSmallIcon: key: ");
        stringBuilder.append((String)object3);
        stringBuilder.append(", pic: ");
        stringBuilder.append(object2);
        Log.d((String)TAG, (String)stringBuilder.toString());
        if (object2 != null && drawable != null) {
            drawable.setAutoMirrored(false);
            object = this.smallIcon;
            if (object != null) {
                object.setImageDrawable(drawable);
                object.setOutlineProvider((ViewOutlineProvider)this.getRoundedCornerOutlineProvider());
                object.setClipToOutline(true);
                object.invalidate();
            }
            if ((object3 = this.smallIcon) != null) {
                object2 = this.picInfo;
                object = var5_3;
                if (object2 != null) {
                    object = ((PicInfo)object2).getContentDescription();
                }
                object3.setContentDescription((CharSequence)object);
            }
            return;
        }
        this.setAppIcon((DynamicIslandData)object);
    }

    private final void showBigStaticImage(DynamicIslandData object) {
        ImageView imageView = this.lottieBigViewStatic;
        Object var3_3 = null;
        object = imageView;
        if (imageView == null) {
            object = this.lottieBigViewStaticStub;
            object = object != null ? object.inflate() : null;
            object = object instanceof ImageView ? (ImageView)object : null;
        }
        this.lottieBigViewStatic = object;
        object = this.lottieView;
        if (object != null) {
            object.setVisibility(8);
        }
        object = this.lottieViewStatic;
        if (object != null) {
            object.setVisibility(8);
        }
        object = this.lottieBigView;
        if (object != null) {
            object.setVisibility(8);
        }
        object = this.islandVideo;
        if (object != null) {
            object.setVisibility(8);
        }
        object = this.appIcon;
        if (object != null) {
            object.setVisibility(8);
        }
        object = this.icon;
        if (object != null) {
            object.setVisibility(8);
        }
        object = this.fixIcon;
        if (object != null) {
            object.setVisibility(8);
        }
        object = this.smallIcon;
        if (object != null) {
            object.setVisibility(8);
        }
        object = this.flashIcon;
        if (object != null) {
            object.setVisibility(8);
        }
        object = this.shader;
        if (object != null) {
            object.stop();
        }
        if ((object = this.lottieBigView) != null) {
            object.cancelAnimation();
        }
        if ((object = this.lottieBigView) != null) {
            object.clearAnimation();
        }
        imageView = StaticResUtils.INSTANCE;
        PicInfo picInfo = this.picInfo;
        object = var3_3;
        if (picInfo != null) {
            object = picInfo.getPic();
        }
        int n = imageView.getStaticRes((String)object);
        IslandIconViewHolderExtKt.checkRes(n, (View)this.lottieBigViewStatic);
        object = this.lottieBigViewStatic;
        if (object != null) {
            object.setImageResource(n);
        }
    }

    @SuppressLint(value={"UseCompatLoadingForDrawables"})
    private final void showShaderIcon(DynamicIslandData object) {
        Object object2 = this.lottieView;
        if (object2 != null) {
            object2.setVisibility(8);
        }
        object2 = this.lottieViewStatic;
        if (object2 != null) {
            object2.setVisibility(8);
        }
        object2 = this.lottieBigView;
        if (object2 != null) {
            object2.setVisibility(8);
        }
        object2 = this.lottieBigViewStatic;
        if (object2 != null) {
            object2.setVisibility(8);
        }
        object2 = this.islandVideo;
        if (object2 != null) {
            object2.setVisibility(8);
        }
        object2 = this.appIcon;
        if (object2 != null) {
            object2.setVisibility(8);
        }
        object2 = this.fixIcon;
        if (object2 != null) {
            object2.setVisibility(8);
        }
        object2 = this.smallIcon;
        if (object2 != null) {
            object2.setVisibility(8);
        }
        object2 = this.picInfo;
        Object var4_3 = null;
        Object var5_4 = null;
        View view = null;
        object2 = object2 != null ? ((PicInfo)object2).getPic() : null;
        if (o.c((Object)object2, (Object)"flash_light_icon")) {
            object2 = this.flashIcon;
            object = object2;
            if (object2 == null) {
                object = this.flashIconStub;
                object = object != null ? object.inflate() : null;
                object = object instanceof FlashLightIcon ? (FlashLightIcon)object : null;
            }
            this.flashIcon = object;
            if (object != null) {
                object.setVisibility(0);
            }
            object = this.icon;
            if (object != null) {
                object.setVisibility(8);
            }
            if (o.c((Object)this.getModule(), (Object)"modulePicSmallIsland")) {
                object2 = this.picInfo;
                object = view;
                if (object2 != null) {
                    object = ((PicInfo)object2).getPic();
                }
                if (o.c((Object)object, (Object)"flash_light_icon") && (object = this.flashIcon) != null) {
                    CommonUtils.INSTANCE.setMarginStart((View)object, 0, true);
                }
            }
        } else if (o.c((Object)object2, (Object)"call")) {
            object = this.icon;
            if (object == null) {
                object = this.iconStub;
                object2 = object != null ? object.inflate() : null;
                object = var4_3;
                if (object2 instanceof ImageView) {
                    object = (ImageView)object2;
                }
            }
            this.icon = object;
            if (object != null) {
                object.setVisibility(0);
            }
            object = this.flashIcon;
            if (object != null) {
                object.setVisibility(8);
            }
            object = this.icon;
            if (object != null) {
                object.setImageDrawable(this.getContext().getResources().getDrawable(R.drawable.call_icon));
            }
        } else {
            object2 = this.icon;
            if (object2 == null) {
                object2 = this.iconStub;
                view = object2 != null ? object2.inflate() : null;
                object2 = var5_4;
                if (view instanceof ImageView) {
                    object2 = (ImageView)view;
                }
            }
            this.icon = object2;
            if (object2 != null) {
                object2.setVisibility(0);
            }
            object2 = this.flashIcon;
            if (object2 != null) {
                object2.setVisibility(8);
            }
            this.setIcon((DynamicIslandData)object);
        }
        if (this.getRootView().getParent() != null && this.effectEnable) {
            object = this.getRootView().getParent();
            o.e((Object)object, (String)"null cannot be cast to non-null type android.view.ViewGroup");
            object = (ViewGroup)object;
            OneShotPreDrawListener.add((View)object, (Runnable)new Runnable((View)object, this, (ViewGroup)object){
                final ViewGroup $parent$inlined;
                final View $this_doOnPreDraw;
                final IslandIconViewHolder this$0;
                {
                    this.$this_doOnPreDraw = view;
                    this.this$0 = islandIconViewHolder;
                    this.$parent$inlined = viewGroup;
                }

                public final void run() {
                    Object object;
                    if (DynamicFeatureConfig.INSTANCE.getFEATURE_DYNAMIC_ISLAND_SHADER() && (object = this.this$0.getPicInfo()) != null && (object = ((PicInfo)object).getEffectSrc()) != null && (IslandIconViewHolder.access$getShader$p(this.this$0) == null || IslandIconViewHolder.access$getCurrentShaderEffectSrc$p(this.this$0) == null || !o.c((Object)object, (Object)IslandIconViewHolder.access$getCurrentShaderEffectSrc$p(this.this$0)))) {
                        IslandIconViewHolder.access$setCurrentShaderEffectSrc$p(this.this$0, (String)object);
                        boolean bl = o.c((Object)object, (Object)"call");
                        float f2 = 0.0f;
                        float f3 = 0.0f;
                        if (bl) {
                            IslandIconViewHolder islandIconViewHolder = this.this$0;
                            ShaderUtil shaderUtil = ShaderUtil.INSTANCE;
                            ViewGroup viewGroup = this.$parent$inlined;
                            ImageView imageView = IslandIconViewHolder.access$getIcon$p(islandIconViewHolder);
                            float f4 = f3;
                            if (imageView != null) {
                                imageView = imageView.getDrawable();
                                f4 = f3;
                                if (imageView != null) {
                                    imageView = imageView.getBounds();
                                    f4 = f3;
                                    if (imageView != null) {
                                        f4 = imageView.width();
                                    }
                                }
                            }
                            IslandIconViewHolder.access$setShader$p(islandIconViewHolder, shaderUtil.setShader((String)object, (View)viewGroup, f4, this.this$0.getContext().getResources().getDimension(R.dimen.island_area_padding), Origin.START, false));
                            object = IslandIconViewHolder.access$getShader$p(this.this$0);
                            if (object != null) {
                                object.start();
                            }
                        } else {
                            IslandIconViewHolder islandIconViewHolder = this.this$0;
                            ShaderUtil shaderUtil = ShaderUtil.INSTANCE;
                            ViewGroup viewGroup = this.$parent$inlined;
                            ImageView imageView = IslandIconViewHolder.access$getIcon$p(islandIconViewHolder);
                            float f5 = f2;
                            if (imageView != null) {
                                imageView = imageView.getDrawable();
                                f5 = f2;
                                if (imageView != null) {
                                    imageView = imageView.getBounds();
                                    f5 = f2;
                                    if (imageView != null) {
                                        f5 = imageView.width();
                                    }
                                }
                            }
                            IslandIconViewHolder.access$setShader$p(islandIconViewHolder, ShaderUtil.setShader$default((ShaderUtil)shaderUtil, (String)object, (View)viewGroup, (float)f5, (float)this.this$0.getContext().getResources().getDimension(R.dimen.island_area_padding), (Origin)Origin.END, (boolean)false, (int)32, null));
                            object = IslandIconViewHolder.access$getShader$p(this.this$0);
                            if (object != null) {
                                object.start();
                            }
                        }
                    }
                }
            });
        }
    }

    private final void showStaticImage() {
        LottieAnimationView lottieAnimationView = this.lottieViewStatic;
        Object var3_2 = null;
        Object object = lottieAnimationView;
        if (lottieAnimationView == null && !((object = (object = this.lottieViewStaticStub) != null ? object.inflate() : null) instanceof ImageView)) {
            object = null;
        }
        this.lottieViewStatic = object;
        object = this.lottieView;
        if (object != null) {
            object.setVisibility(8);
        }
        object = this.lottieBigView;
        if (object != null) {
            object.setVisibility(8);
        }
        object = this.lottieBigViewStatic;
        if (object != null) {
            object.setVisibility(8);
        }
        object = this.islandVideo;
        if (object != null) {
            object.setVisibility(8);
        }
        object = this.appIcon;
        if (object != null) {
            object.setVisibility(8);
        }
        object = this.icon;
        if (object != null) {
            object.setVisibility(8);
        }
        object = this.fixIcon;
        if (object != null) {
            object.setVisibility(8);
        }
        object = this.smallIcon;
        if (object != null) {
            object.setVisibility(8);
        }
        object = this.flashIcon;
        if (object != null) {
            object.setVisibility(8);
        }
        object = this.shader;
        if (object != null) {
            object.stop();
        }
        if ((object = this.lottieView) != null) {
            object.cancelAnimation();
        }
        if ((object = this.lottieView) != null) {
            object.clearAnimation();
        }
        lottieAnimationView = StaticResUtils.INSTANCE;
        PicInfo picInfo = this.picInfo;
        object = var3_2;
        if (picInfo != null) {
            object = picInfo.getPic();
        }
        int n = lottieAnimationView.getStaticRes((String)object);
        IslandIconViewHolderExtKt.checkRes(n, (View)this.lottieViewStatic);
        object = this.lottieViewStatic;
        if (object != null) {
            object.setImageResource(n);
        }
    }

    @Override
    public void bind(IslandTemplate object, DynamicIslandData object2) {
        Object object3;
        PicInfo picInfo;
        Object var5_5;
        LottieResUtils lottieResUtils;
        block37: {
            block40: {
                block39: {
                    block38: {
                        block34: {
                            block36: {
                                block35: {
                                    o.g((Object)object, (String)"template");
                                    super.bind((IslandTemplate)object, (DynamicIslandData)object2);
                                    lottieResUtils = LottieResUtils.INSTANCE;
                                    lottieResUtils.cancelLottieAnimate(this.lottieBigView, false);
                                    lottieResUtils.cancelLottieAnimate(this.lottieView, false);
                                    this.alreadyRemoveFaceRecognition = false;
                                    this.data = object2;
                                    boolean bl = o.c((Object)this.getModule(), (Object)"modulePicSmallIsland");
                                    var5_5 = null;
                                    picInfo = null;
                                    if (!bl) break block34;
                                    this.effectEnable = false;
                                    object3 = ((IslandTemplate)object).getSmallIslandArea();
                                    if (object3 == null) break block35;
                                    PicInfo picInfo2 = ((SmallIslandArea)object3).getPicInfo();
                                    object3 = picInfo2;
                                    if (picInfo2 != null) break block36;
                                }
                                object = (object = ((IslandTemplate)object).getBigIslandArea()) != null && (object = ((BigIslandArea)object).getImageTextInfoLeft()) != null ? ((ImageTextInfo)object).getPicInfo() : null;
                                object3 = object;
                                if (object == null) {
                                    object3 = new PicInfo();
                                }
                            }
                            this.picInfo = object3;
                            object = this.iconContainer;
                            object = object != null ? object.getLayoutParams() : null;
                            if (object instanceof FrameLayout.LayoutParams) {
                                object = this.iconContainer;
                                object = object != null ? object.getLayoutParams() : null;
                                o.e((Object)object, (String)"null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
                                ((FrameLayout.LayoutParams)object).gravity = 17;
                            }
                            break block37;
                        }
                        if (!o.c((Object)this.getModule(), (Object)"modulePic")) break block38;
                        object = (object = ((IslandTemplate)object).getBigIslandArea()) != null ? ((BigIslandArea)object).getPicInfo() : null;
                        this.picInfo = object;
                        break block37;
                    }
                    if (!o.c((Object)this.getModule(), (Object)"moduleSmallTextOverIcon")) break block37;
                    if ((object = ((IslandTemplate)object).getBigIslandArea()) == null || (object = ((BigIslandArea)object).getImageTextInfoRight()) == null) break block39;
                    object = object3 = ((ImageTextInfo)object).getPicInfo();
                    if (object3 != null) break block40;
                }
                object = new PicInfo();
            }
            this.picInfo = object;
            object = this.smallTextOverIconContainer;
            object = object != null ? object.getLayoutParams() : null;
            if (object instanceof FrameLayout.LayoutParams) {
                object = this.smallTextOverIconContainer;
                object = object != null ? object.getLayoutParams() : null;
                o.e((Object)object, (String)"null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
                ((FrameLayout.LayoutParams)object).gravity = 17;
            }
        }
        if (this.picInfo == null) {
            object = this.iconContainer;
            if (object != null) {
                object.setVisibility(8);
            }
            return;
        }
        object = this.iconContainer;
        if (object != null) {
            object.setVisibility(0);
        }
        object = this.picInfo;
        if (object != null && (object = ((PicInfo)object).getType()) != null && (Integer)object == 1) {
            this.setFixIcon((DynamicIslandData)object2);
        } else {
            object = this.picInfo;
            if (object != null && (object = ((PicInfo)object).getType()) != null && (Integer)object == 2) {
                object = this.picInfo;
                object = object != null ? ((PicInfo)object).getPic() : null;
                object3 = this.picInfo;
                object2 = picInfo;
                if (object3 != null) {
                    object2 = ((PicInfo)object3).getNumber();
                }
                o.d((Object)object2);
                if (lottieResUtils.isNoNeedToGetLottieRes((String)object, ((Integer)object2).intValue())) {
                    this.showStaticImage();
                } else {
                    this.playAnimation();
                }
            } else {
                object = this.picInfo;
                if (object != null && (object = ((PicInfo)object).getType()) != null && (Integer)object == 3) {
                    this.showShaderIcon((DynamicIslandData)object2);
                } else {
                    object = this.picInfo;
                    if (object != null && (object = ((PicInfo)object).getType()) != null && (Integer)object == 4) {
                        this.setIcon((DynamicIslandData)object2);
                    } else {
                        object = this.picInfo;
                        if (object != null && (object = ((PicInfo)object).getType()) != null && (Integer)object == 5) {
                            this.setSmallIcon((DynamicIslandData)object2);
                        } else {
                            object = this.picInfo;
                            if (object != null && (object = ((PicInfo)object).getType()) != null && (Integer)object == 6) {
                                this.setMP4Icon((DynamicIslandData)object2);
                            } else {
                                object = this.picInfo;
                                if (object != null && (object = ((PicInfo)object).getType()) != null && (Integer)object == 7) {
                                    object = this.picInfo;
                                    object = object != null ? ((PicInfo)object).getPic() : null;
                                    picInfo = this.picInfo;
                                    object3 = var5_5;
                                    if (picInfo != null) {
                                        object3 = picInfo.getNumber();
                                    }
                                    o.d((Object)object3);
                                    if (lottieResUtils.isNoNeedToGetLottieRes((String)object, ((Integer)object3).intValue())) {
                                        this.showBigStaticImage((DynamicIslandData)object2);
                                    } else {
                                        this.playBigAnimation((DynamicIslandData)object2);
                                    }
                                } else {
                                    this.setAppIcon((DynamicIslandData)object2);
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    @Override
    public void diff(IslandTemplate islandTemplate, DynamicIslandData dynamicIslandData) {
        o.g((Object)islandTemplate, (String)"template");
        super.diff(islandTemplate, dynamicIslandData);
    }

    public final PicInfo getPicInfo() {
        return this.picInfo;
    }

    public final int getWidth() {
        Object object = this.iconContainer;
        Integer n = null;
        object = object != null ? Integer.valueOf(object.getWidth()) : null;
        Object object2 = this.iconContainer;
        object2 = object2 != null ? Integer.valueOf(object2.getMeasuredWidth()) : null;
        Object object3 = this.iconContainer;
        if (object3 != null) {
            n = object3.getVisibility();
        }
        object3 = new StringBuilder();
        ((StringBuilder)object3).append("getWidth: ");
        ((StringBuilder)object3).append(object);
        ((StringBuilder)object3).append(" ");
        ((StringBuilder)object3).append(object2);
        ((StringBuilder)object3).append(" ");
        ((StringBuilder)object3).append(n);
        Log.d((String)TAG, (String)((StringBuilder)object3).toString());
        object = this.iconContainer;
        if (object == null) {
            return 0;
        }
        if (object.getVisibility() == 8) {
            return 0;
        }
        object2 = this.getContext().getResources();
        int n2 = R.dimen.island_flash_icon_size;
        object.measure(View.MeasureSpec.makeMeasureSpec((int)object2.getDimensionPixelSize(n2), (int)Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec((int)this.getContext().getResources().getDimensionPixelSize(n2), (int)Integer.MIN_VALUE));
        return object.getMeasuredWidth();
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    @Override
    public Object initLayout(View var1_1, String var2_2, K0.d var3_3) {
        if (!(var3_3 /* !! */  instanceof initLayout.1)) ** GOTO lbl-1000
        var5_4 /* !! */  = var3_3 /* !! */ ;
        var4_5 = var5_4 /* !! */ .label;
        if ((var4_5 & -2147483648) != 0) {
            var5_4 /* !! */ .label = var4_5 + -2147483648;
            var3_3 /* !! */  = var5_4 /* !! */ ;
        } else lbl-1000:
        // 2 sources

        {
            var3_3 /* !! */  = new M0.d(this, var3_3 /* !! */ ){
                Object L$0;
                Object L$1;
                Object L$2;
                int label;
                Object result;
                final IslandIconViewHolder this$0;
                {
                    this.this$0 = islandIconViewHolder;
                    super(d2);
                }

                public final Object invokeSuspend(Object object) {
                    this.result = object;
                    this.label |= Integer.MIN_VALUE;
                    return this.this$0.initLayout(null, null, (K0.d)this);
                }
            };
        }
        var8_6 = var3_3 /* !! */ .result;
        var9_7 = L0.c.c();
        var4_5 = var3_3 /* !! */ .label;
        if (var4_5 == 0) ** GOTO lbl20
        if (var4_5 == 1) {
            var7_8 = (String)var3_3 /* !! */ .L$2;
            var6_9 = (View)var3_3 /* !! */ .L$1;
            var5_4 /* !! */  = (IslandIconViewHolder)var3_3 /* !! */ .L$0;
            k.b((Object)var8_6);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
lbl20:
            // 1 sources

            k.b((Object)var8_6);
            var3_3 /* !! */ .L$0 = this;
            var3_3 /* !! */ .L$1 = var1_1;
            var3_3 /* !! */ .L$2 = var2_2;
            var3_3 /* !! */ .label = 1;
            var5_4 /* !! */  = this;
            var6_9 = var1_1;
            var7_8 = var2_2;
            if (super.initLayout(var1_1, var2_2, var3_3 /* !! */ ) == var9_7) {
                return var9_7;
            }
        }
        var5_4 /* !! */ .iconStub = (ViewStub)var6_9.findViewById(R.id.island_icon_stub);
        var5_4 /* !! */ .fixIconStub = (ViewStub)var6_9.findViewById(R.id.island_fix_icon_stub);
        var5_4 /* !! */ .smallIconStub = (ViewStub)var6_9.findViewById(R.id.island_small_icon_stub);
        var5_4 /* !! */ .flashIconStub = (ViewStub)var6_9.findViewById(R.id.island_flash_icon_stub);
        var5_4 /* !! */ .appIconStub = (ViewStub)var6_9.findViewById(R.id.island_app_icon_stub);
        var5_4 /* !! */ .lottieViewStub = (ViewStub)var6_9.findViewById(R.id.island_lottie_stub);
        var5_4 /* !! */ .lottieViewStaticStub = (ViewStub)var6_9.findViewById(R.id.island_lottie_static_stub);
        var5_4 /* !! */ .lottieBigViewStub = (ViewStub)var6_9.findViewById(R.id.island_lottie_bigger_stub);
        var5_4 /* !! */ .lottieBigViewStaticStub = (ViewStub)var6_9.findViewById(R.id.island_lottie_bigger_static_stub);
        var5_4 /* !! */ .islandVideoStub = (ViewStub)var6_9.findViewById(R.id.island_video_stub);
        var5_4 /* !! */ .iconContainer = (FrameLayout)var6_9.findViewById(R.id.island_container_module_icon);
        if (o.c((Object)var7_8, (Object)"moduleSmallTextOverIcon")) {
            var5_4 /* !! */ .smallTextOverIconContainer = (FrameLayout)var6_9.findViewById(R.id.island_container_module_text_over_icon);
        }
        return s.a;
    }

    @Override
    public void onDetach() {
        TextureVideoView textureVideoView = this.shader;
        if (textureVideoView != null) {
            textureVideoView.stop();
        }
        if ((textureVideoView = this.islandVideo) != null) {
            textureVideoView.stopPlayback();
        }
        LottieResUtils.cancelLottieAnimate$default((LottieResUtils)LottieResUtils.INSTANCE, (LottieAnimationView)this.lottieView, (boolean)false, (int)2, null);
    }

    @Override
    public void onHidden() {
        Log.d((String)TAG, (String)"onHidden");
        TextureVideoView textureVideoView = this.lottieView;
        if (textureVideoView != null && textureVideoView.getVisibility() == 0) {
            LottieResUtils.INSTANCE.cancelLottieAnimate(this.lottieView, false);
        }
        this.clearFaceRecognition(this.data);
        textureVideoView = this.islandVideo;
        if (textureVideoView != null && textureVideoView.getVisibility() == 0 && (textureVideoView = this.islandVideo) != null && textureVideoView.isPlaying() && (textureVideoView = this.islandVideo) != null) {
            textureVideoView.pause();
        }
        if ((textureVideoView = this.shader) != null && textureVideoView != null) {
            textureVideoView.stop();
        }
        super.onHidden();
    }

    @Override
    public void onShow() {
        Log.d((String)TAG, (String)"onShow");
        TextureVideoView textureVideoView = this.lottieView;
        if (textureVideoView != null && textureVideoView.getVisibility() == 0 && !CommonUtils.NOT_SUPPORT_LOTTIE) {
            this.playAnimation();
        }
        if ((textureVideoView = this.islandVideo) != null && textureVideoView.getVisibility() == 0 && (textureVideoView = this.islandVideo) != null) {
            textureVideoView.start();
        }
        if ((textureVideoView = this.shader) != null && textureVideoView != null) {
            textureVideoView.start();
        }
        super.onShow();
    }

    public final void setPicInfo(PicInfo picInfo) {
        this.picInfo = picInfo;
    }

    @Override
    public void updatePartial(IslandTemplate islandTemplate, DynamicIslandData dynamicIslandData) {
        o.g((Object)islandTemplate, (String)"template");
        super.updatePartial(islandTemplate, dynamicIslandData);
        this.bind(islandTemplate, dynamicIslandData);
    }
}
