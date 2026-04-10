/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  G0.k
 *  G0.s
 *  K0.d
 *  L0.c
 *  M0.d
 *  U0.o
 *  android.content.Context
 *  android.graphics.Color
 *  android.util.Log
 *  android.view.Choreographer
 *  android.view.Choreographer$FrameCallback
 *  android.view.View
 *  android.view.View$OnAttachStateChangeListener
 *  android.view.ViewGroup
 *  android.view.ViewGroup$LayoutParams
 *  android.widget.FrameLayout
 *  android.widget.FrameLayout$LayoutParams
 *  android.widget.TextView
 *  com.android.systemui.plugins.miui.dynamicisland.DynamicIslandData
 *  e1.e
 *  kotlin.jvm.internal.o
 *  miui.systemui.animation.FolmeKt
 *  miui.systemui.util.CommonUtils
 *  miuix.animation.FolmeObject
 *  miuix.animation.base.AnimConfig
 *  miuix.animation.controller.AnimState
 *  miuix.animation.listener.TransitionListener
 *  miuix.animation.listener.UpdateInfo
 *  miuix.animation.property.FloatProperty
 *  miuix.colorful.texteffect.TimerTextEffectView
 */
package miui.systemui.dynamicisland.module;

import G0.k;
import G0.s;
import K0.d;
import L0.c;
import android.content.Context;
import android.graphics.Color;
import android.util.Log;
import android.view.Choreographer;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.android.systemui.plugins.miui.dynamicisland.DynamicIslandData;
import e1.e;
import java.util.Collection;
import kotlin.jvm.internal.o;
import miui.systemui.animation.FolmeKt;
import miui.systemui.dynamicisland.DynamicIslandUtils;
import miui.systemui.dynamicisland.R;
import miui.systemui.dynamicisland.model.BigIslandArea;
import miui.systemui.dynamicisland.model.ImageTextInfo;
import miui.systemui.dynamicisland.model.IslandTemplate;
import miui.systemui.dynamicisland.model.PicInfo;
import miui.systemui.dynamicisland.model.TextInfo;
import miui.systemui.dynamicisland.module.BaseIslandModuleViewHolder;
import miui.systemui.dynamicisland.module.IslandIconFixedWidthTextHolder;
import miui.systemui.dynamicisland.module.IslandIconViewHolder;
import miui.systemui.dynamicisland.module.b;
import miui.systemui.util.CommonUtils;
import miuix.animation.FolmeObject;
import miuix.animation.base.AnimConfig;
import miuix.animation.controller.AnimState;
import miuix.animation.listener.TransitionListener;
import miuix.animation.listener.UpdateInfo;
import miuix.animation.property.FloatProperty;
import miuix.colorful.texteffect.TimerTextEffectView;

public final class IslandIconFixedWidthTextHolder
extends BaseIslandModuleViewHolder {
    private static final CONTENT_TRANS_X.1 CONTENT_TRANS_X;
    private static final CONTENT_TRANS_Y.1 CONTENT_TRANS_Y;
    public static final Companion Companion;
    private static final String TAG = "IslandIconFixedWidthTextHolder";
    private static final TITLE_SCALE_X.1 TITLE_SCALE_X;
    private static final TITLE_SCALE_Y.1 TITLE_SCALE_Y;
    private static final TITLE_TRANS_X.1 TITLE_TRANS_X;
    private Choreographer choreographer;
    private TimerTextEffectView content;
    private String contentText;
    private float contentTransX;
    private float contentTransY;
    private FrameLayout fixedContainer;
    private final Choreographer.FrameCallback frameCallback;
    private final IslandIconViewHolder iconViewHolder;
    private TextInfo textInfo;
    private View textShade;
    private View textShadeEnd;
    private TimerTextEffectView title;
    private float titleScaleX;
    private float titleScaleY;
    private String titleText;
    private float titleTransX;
    private boolean updateScheduled;

    static {
        Companion = new Object(null){
            {
                this();
            }
        };
        TITLE_TRANS_X = new FloatProperty<IslandIconFixedWidthTextHolder>(){

            public float getValue(IslandIconFixedWidthTextHolder islandIconFixedWidthTextHolder) {
                o.g((Object)islandIconFixedWidthTextHolder, (String)"holder");
                return IslandIconFixedWidthTextHolder.access$getTitleTransX$p(islandIconFixedWidthTextHolder);
            }

            public void setValue(IslandIconFixedWidthTextHolder islandIconFixedWidthTextHolder, float f2) {
                o.g((Object)islandIconFixedWidthTextHolder, (String)"holder");
                if (Float.isNaN(f2)) {
                    return;
                }
                IslandIconFixedWidthTextHolder.access$setTitleTransX$p(islandIconFixedWidthTextHolder, f2);
            }
        };
        CONTENT_TRANS_X = new FloatProperty<IslandIconFixedWidthTextHolder>(){

            public float getValue(IslandIconFixedWidthTextHolder islandIconFixedWidthTextHolder) {
                o.g((Object)islandIconFixedWidthTextHolder, (String)"holder");
                return IslandIconFixedWidthTextHolder.access$getContentTransX$p(islandIconFixedWidthTextHolder);
            }

            public void setValue(IslandIconFixedWidthTextHolder islandIconFixedWidthTextHolder, float f2) {
                o.g((Object)islandIconFixedWidthTextHolder, (String)"holder");
                if (Float.isNaN(f2)) {
                    return;
                }
                IslandIconFixedWidthTextHolder.access$setContentTransX$p(islandIconFixedWidthTextHolder, f2);
            }
        };
        CONTENT_TRANS_Y = new FloatProperty<IslandIconFixedWidthTextHolder>(){

            public float getValue(IslandIconFixedWidthTextHolder islandIconFixedWidthTextHolder) {
                o.g((Object)islandIconFixedWidthTextHolder, (String)"holder");
                return IslandIconFixedWidthTextHolder.access$getContentTransY$p(islandIconFixedWidthTextHolder);
            }

            public void setValue(IslandIconFixedWidthTextHolder islandIconFixedWidthTextHolder, float f2) {
                o.g((Object)islandIconFixedWidthTextHolder, (String)"holder");
                if (Float.isNaN(f2)) {
                    return;
                }
                IslandIconFixedWidthTextHolder.access$setContentTransY$p(islandIconFixedWidthTextHolder, f2);
            }
        };
        TITLE_SCALE_X = new FloatProperty<IslandIconFixedWidthTextHolder>(){

            public float getValue(IslandIconFixedWidthTextHolder islandIconFixedWidthTextHolder) {
                o.g((Object)islandIconFixedWidthTextHolder, (String)"holder");
                return IslandIconFixedWidthTextHolder.access$getTitleScaleX$p(islandIconFixedWidthTextHolder);
            }

            public void setValue(IslandIconFixedWidthTextHolder islandIconFixedWidthTextHolder, float f2) {
                o.g((Object)islandIconFixedWidthTextHolder, (String)"holder");
                if (Float.isNaN(f2)) {
                    return;
                }
                IslandIconFixedWidthTextHolder.access$setTitleScaleX$p(islandIconFixedWidthTextHolder, f2);
            }
        };
        TITLE_SCALE_Y = new FloatProperty<IslandIconFixedWidthTextHolder>(){

            public float getValue(IslandIconFixedWidthTextHolder islandIconFixedWidthTextHolder) {
                o.g((Object)islandIconFixedWidthTextHolder, (String)"holder");
                return IslandIconFixedWidthTextHolder.access$getTitleScaleY$p(islandIconFixedWidthTextHolder);
            }

            public void setValue(IslandIconFixedWidthTextHolder islandIconFixedWidthTextHolder, float f2) {
                o.g((Object)islandIconFixedWidthTextHolder, (String)"holder");
                if (Float.isNaN(f2)) {
                    return;
                }
                IslandIconFixedWidthTextHolder.access$setTitleScaleY$p(islandIconFixedWidthTextHolder, f2);
            }
        };
    }

    public IslandIconFixedWidthTextHolder(Context context, ViewGroup viewGroup, U0.o o2, IslandIconViewHolder.Factory factory) {
        o.g((Object)context, (String)"context");
        o.g((Object)viewGroup, (String)"rootView");
        o.g((Object)o2, (String)"emitEvent");
        o.g((Object)factory, (String)"iconViewHolderFactory");
        super(context, viewGroup, o2);
        this.iconViewHolder = factory.create(viewGroup, o2);
        this.titleScaleX = 1.0f;
        this.titleScaleY = 1.0f;
        this.frameCallback = new b(this);
    }

    public static /* synthetic */ void a(IslandIconFixedWidthTextHolder islandIconFixedWidthTextHolder, long l) {
        IslandIconFixedWidthTextHolder.frameCallback$lambda$3(islandIconFixedWidthTextHolder, l);
    }

    public static final /* synthetic */ void access$contentScheduleUpdate(IslandIconFixedWidthTextHolder islandIconFixedWidthTextHolder) {
        islandIconFixedWidthTextHolder.contentScheduleUpdate();
    }

    public static final /* synthetic */ float access$getContentTransX$p(IslandIconFixedWidthTextHolder islandIconFixedWidthTextHolder) {
        return islandIconFixedWidthTextHolder.contentTransX;
    }

    public static final /* synthetic */ float access$getContentTransY$p(IslandIconFixedWidthTextHolder islandIconFixedWidthTextHolder) {
        return islandIconFixedWidthTextHolder.contentTransY;
    }

    public static final /* synthetic */ float access$getTitleScaleX$p(IslandIconFixedWidthTextHolder islandIconFixedWidthTextHolder) {
        return islandIconFixedWidthTextHolder.titleScaleX;
    }

    public static final /* synthetic */ float access$getTitleScaleY$p(IslandIconFixedWidthTextHolder islandIconFixedWidthTextHolder) {
        return islandIconFixedWidthTextHolder.titleScaleY;
    }

    public static final /* synthetic */ float access$getTitleTransX$p(IslandIconFixedWidthTextHolder islandIconFixedWidthTextHolder) {
        return islandIconFixedWidthTextHolder.titleTransX;
    }

    public static final /* synthetic */ void access$setContentTransX$p(IslandIconFixedWidthTextHolder islandIconFixedWidthTextHolder, float f) {
        islandIconFixedWidthTextHolder.contentTransX = f;
    }

    public static final /* synthetic */ void access$setContentTransY$p(IslandIconFixedWidthTextHolder islandIconFixedWidthTextHolder, float f) {
        islandIconFixedWidthTextHolder.contentTransY = f;
    }

    public static final /* synthetic */ void access$setTitleScaleX$p(IslandIconFixedWidthTextHolder islandIconFixedWidthTextHolder, float f) {
        islandIconFixedWidthTextHolder.titleScaleX = f;
    }

    public static final /* synthetic */ void access$setTitleScaleY$p(IslandIconFixedWidthTextHolder islandIconFixedWidthTextHolder, float f) {
        islandIconFixedWidthTextHolder.titleScaleY = f;
    }

    public static final /* synthetic */ void access$setTitleTransX$p(IslandIconFixedWidthTextHolder islandIconFixedWidthTextHolder, float f) {
        islandIconFixedWidthTextHolder.titleTransX = f;
    }

    public static final /* synthetic */ void access$titleScheduleUpdate(IslandIconFixedWidthTextHolder islandIconFixedWidthTextHolder) {
        islandIconFixedWidthTextHolder.titleScheduleUpdate();
    }

    private final void attach() {
        FrameLayout frameLayout = this.fixedContainer;
        if (frameLayout != null) {
            frameLayout.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener(this){
                final IslandIconFixedWidthTextHolder this$0;
                {
                    this.this$0 = islandIconFixedWidthTextHolder;
                }

                public void onViewAttachedToWindow(View view) {
                    o.g((Object)view, (String)"p0");
                    Log.d((String)"IslandIconFixedWidthTextHolder", (String)"onViewAttachedToWindow");
                }

                public void onViewDetachedFromWindow(View view) {
                    o.g((Object)view, (String)"p0");
                    Log.d((String)"IslandIconFixedWidthTextHolder", (String)"onViewDetachedFromWindow");
                    FolmeKt.getFolme((FolmeObject)this.this$0).end(new Object[]{"dynamic_title_trans_x", "dynamic_content_trans_x", "dynamic_content_trans_y", "dynamic_title_scale_x", "dynamic_title_scale_y"});
                    FolmeKt.getFolme((FolmeObject)this.this$0).clean();
                    IslandIconFixedWidthTextHolder.access$titleScheduleUpdate(this.this$0);
                    IslandIconFixedWidthTextHolder.access$contentScheduleUpdate(this.this$0);
                }
            });
        }
    }

    private final void contentAnimation(float f, float f2) {
        FolmeKt.getFolme((FolmeObject)this).to((Object)new AnimState().add((FloatProperty)CONTENT_TRANS_X, f, new long[0]).add((FloatProperty)CONTENT_TRANS_Y, f2, new long[0]), new AnimConfig[]{new AnimConfig().addListeners(new TransitionListener[]{new TransitionListener(this){
            final IslandIconFixedWidthTextHolder this$0;
            {
                this.this$0 = islandIconFixedWidthTextHolder;
            }

            public void onUpdate(Object object, Collection<UpdateInfo> collection) {
                this.this$0.scheduleUpdate();
            }
        }})});
    }

    private final void contentScheduleUpdate() {
        TimerTextEffectView timerTextEffectView = this.content;
        if (timerTextEffectView != null) {
            timerTextEffectView.setTranslationX(this.contentTransX);
        }
        timerTextEffectView = this.content;
        if (timerTextEffectView != null) {
            timerTextEffectView.setTranslationY(this.contentTransY);
        }
    }

    private static final void frameCallback$lambda$3(IslandIconFixedWidthTextHolder islandIconFixedWidthTextHolder, long l) {
        o.g((Object)islandIconFixedWidthTextHolder, (String)"this$0");
        islandIconFixedWidthTextHolder.updateScheduled = false;
        islandIconFixedWidthTextHolder.titleScheduleUpdate();
        islandIconFixedWidthTextHolder.contentScheduleUpdate();
    }

    private final boolean isPureNumber(String string) {
        return new e("\\d+(\\.\\d+)?").a((CharSequence)string);
    }

    private final void titleAnimation(float f, float f2) {
        FolmeKt.getFolme((FolmeObject)this).to((Object)new AnimState().add((FloatProperty)TITLE_SCALE_X, f, new long[0]).add((FloatProperty)TITLE_SCALE_Y, f, new long[0]).add((FloatProperty)TITLE_TRANS_X, f2, new long[0]), new AnimConfig[]{new AnimConfig().addListeners(new TransitionListener[]{new TransitionListener(this){
            final IslandIconFixedWidthTextHolder this$0;
            {
                this.this$0 = islandIconFixedWidthTextHolder;
            }

            public void onUpdate(Object object, Collection<UpdateInfo> collection) {
                this.this$0.scheduleUpdate();
            }
        }})});
    }

    private final void titleScheduleUpdate() {
        TimerTextEffectView timerTextEffectView = this.title;
        if (timerTextEffectView != null) {
            timerTextEffectView.setTranslationX(this.titleTransX);
        }
        timerTextEffectView = this.title;
        if (timerTextEffectView != null) {
            timerTextEffectView.setScaleX(this.titleScaleX);
        }
        timerTextEffectView = this.title;
        if (timerTextEffectView != null) {
            timerTextEffectView.setScaleY(this.titleScaleY);
        }
    }

    @Override
    public void bind(IslandTemplate islandTemplate, DynamicIslandData dynamicIslandData) {
        int n;
        Object object;
        boolean bl;
        int n2;
        o.g((Object)islandTemplate, (String)"template");
        super.bind(islandTemplate, dynamicIslandData);
        Object object2 = islandTemplate.getBigIslandArea();
        Object var12_4 = null;
        object2 = object2 != null && (object2 = ((BigIslandArea)object2).getImageTextInfoLeft()) != null ? ((ImageTextInfo)object2).getTextInfo() : null;
        this.textInfo = object2;
        object2 = islandTemplate.getBigIslandArea();
        object2 = object2 != null && (object2 = ((BigIslandArea)object2).getImageTextInfoLeft()) != null && (object2 = ((ImageTextInfo)object2).getTextInfo()) != null ? ((TextInfo)object2).getTitle() : null;
        this.titleText = object2;
        object2 = islandTemplate.getBigIslandArea();
        object2 = object2 != null && (object2 = ((BigIslandArea)object2).getImageTextInfoLeft()) != null && (object2 = ((ImageTextInfo)object2).getTextInfo()) != null ? ((TextInfo)object2).getContent() : null;
        this.contentText = object2;
        this.setFixedFont((TextView)this.title);
        object2 = this.titleText;
        int n3 = 1;
        int n4 = object2 != null && this.isPureNumber((String)object2) ? 1 : 0;
        object2 = this.title;
        int n5 = 8;
        if (object2 != null) {
            n2 = this.titleText == null ? 8 : 0;
            object2.setVisibility(n2);
        }
        object2 = this.titleText;
        int n6 = -1;
        if (object2 != null && (object2 = this.title) != null && object2.getVisibility() == 0) {
            object2 = this.title;
            if (object2 != null) {
                object2.setText((CharSequence)this.titleText);
            }
            n2 = islandTemplate.getHighlightColor() != null && (bl = (object2 = this.textInfo) != null ? o.c((Object)((TextInfo)object2).getShowHighlightColor(), (Object)Boolean.TRUE) : false) ? Color.parseColor((String)islandTemplate.getHighlightColor()) : -1;
            object2 = this.title;
            if (object2 != null) {
                object2.setTextColor(n2);
            }
        }
        if ((object2 = this.content) != null) {
            n2 = n5;
            if (n4 != 0) {
                object = this.contentText;
                n = object != null && object.length() != 0 ? 0 : 1;
                n2 = n5;
                if (n == 0) {
                    n2 = 0;
                }
            }
            object2.setVisibility(n2);
        }
        if (this.contentText != null && (n2 = (object2 = this.content) != null && object2.getVisibility() == 0 ? 1 : 0) != 0) {
            object2 = this.content;
            if (object2 != null) {
                object2.setText((CharSequence)this.contentText);
            }
            n2 = n6;
            if (islandTemplate.getHighlightColor() != null) {
                object2 = this.textInfo;
                bl = object2 != null ? o.c((Object)((TextInfo)object2).getShowHighlightColor(), (Object)Boolean.TRUE) : false;
                n2 = n6;
                if (bl) {
                    n2 = Color.parseColor((String)islandTemplate.getHighlightColor());
                }
            }
            if ((object2 = this.content) != null) {
                object2.setTextColor(n2);
            }
        }
        n2 = this.getTextViewWidth((TextView)this.title, this.titleText);
        n = this.getTextViewWidth((TextView)this.content, this.contentText);
        float f = this.getContext().getResources().getDisplayMetrics().density;
        bl = dynamicIslandData != null ? DynamicIslandUtils.INSTANCE.isDynamicIslandPadNoPropOnce(dynamicIslandData) : false;
        if (n4 != 0 && (n4 = (object2 = this.content) != null && object2.getVisibility() == 0 ? n3 : 0) != 0) {
            n4 = bl ? 26 : 32;
            n4 = (int)Math.ceil((float)n4 * f);
            object2 = new StringBuilder();
            ((StringBuilder)object2).append("numberMaxWidth:");
            ((StringBuilder)object2).append(n4);
            ((StringBuilder)object2).append(", titleWidth:");
            ((StringBuilder)object2).append(n2);
            ((StringBuilder)object2).append(", contentWidth:");
            ((StringBuilder)object2).append(n);
            Log.d((String)TAG, (String)((StringBuilder)object2).toString());
            object2 = this.title;
            if (object2 != null) {
                object2.setMaxWidth(n4);
            }
        } else {
            n4 = bl ? 50 : 56;
            n4 = (int)Math.ceil((float)n4 * f);
            object2 = this.title;
            if (object2 != null) {
                object2.setMaxWidth(n4);
            }
        }
        object = this.iconViewHolder;
        Object object3 = islandTemplate.getBigIslandArea();
        object2 = var12_4;
        if (object3 != null) {
            object3 = ((BigIslandArea)object3).getImageTextInfoLeft();
            object2 = var12_4;
            if (object3 != null) {
                object2 = ((ImageTextInfo)object3).getPicInfo();
            }
        }
        ((IslandIconViewHolder)object).setPicInfo((PicInfo)object2);
        this.iconViewHolder.updatePartial(islandTemplate, dynamicIslandData);
    }

    @Override
    public void diff(IslandTemplate islandTemplate, DynamicIslandData dynamicIslandData) {
        o.g((Object)islandTemplate, (String)"template");
        super.diff(islandTemplate, dynamicIslandData);
    }

    public final Choreographer getChoreographer() {
        return this.choreographer;
    }

    public final boolean getUpdateScheduled() {
        return this.updateScheduled;
    }

    /*
     * Unable to fully structure code
     */
    @Override
    public Object initLayout(View var1_1, String var2_2, d var3_3) {
        block7: {
            block8: {
                block4: {
                    block5: {
                        block6: {
                            if (!(var3_3 /* !! */  instanceof initLayout.1)) ** GOTO lbl-1000
                            var6_4 = var3_3 /* !! */ ;
                            var4_5 = var6_4.label;
                            if ((var4_5 & -2147483648) != 0) {
                                var6_4.label = var4_5 + -2147483648;
                            } else lbl-1000:
                            // 2 sources

                            {
                                var6_4 = new M0.d(this, var3_3 /* !! */ ){
                                    Object L$0;
                                    Object L$1;
                                    Object L$2;
                                    int label;
                                    Object result;
                                    final IslandIconFixedWidthTextHolder this$0;
                                    {
                                        this.this$0 = islandIconFixedWidthTextHolder;
                                        super(d2);
                                    }

                                    public final Object invokeSuspend(Object object) {
                                        this.result = object;
                                        this.label |= Integer.MIN_VALUE;
                                        return this.this$0.initLayout(null, null, (d)this);
                                    }
                                };
                            }
                            var9_6 = var6_4.result;
                            var8_7 = c.c();
                            var4_5 = var6_4.label;
                            if (var4_5 == 0) break block4;
                            if (var4_5 == 1) break block5;
                            if (var4_5 != 2) break block6;
                            var2_2 = (View)var6_4.L$1;
                            var1_1 = (IslandIconFixedWidthTextHolder)var6_4.L$0;
                            k.b((Object)var9_6);
                            break block7;
                        }
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    var7_8 = (String)var6_4.L$2;
                    var3_3 /* !! */  = (View)var6_4.L$1;
                    var5_9 = (IslandIconFixedWidthTextHolder)var6_4.L$0;
                    k.b((Object)var9_6);
                    break block8;
                }
                k.b((Object)var9_6);
                var6_4.L$0 = this;
                var6_4.L$1 = var1_1;
                var6_4.L$2 = var2_2;
                var6_4.label = 1;
                var5_9 = this;
                var3_3 /* !! */  = var1_1;
                var7_8 = var2_2;
                if (super.initLayout((View)var1_1, var2_2, (d)var6_4) == var8_7) {
                    return var8_7;
                }
            }
            var1_1 = var5_9.iconViewHolder;
            var6_4.L$0 = var5_9;
            var6_4.L$1 = var3_3 /* !! */ ;
            var6_4.L$2 = null;
            var6_4.label = 2;
            if (var1_1.initLayout((View)var3_3 /* !! */ , var7_8, (d)var6_4) == var8_7) {
                return var8_7;
            }
            var1_1 = var5_9;
            var2_2 = var3_3 /* !! */ ;
        }
        var1_1.fixedContainer = (FrameLayout)var2_2.findViewById(R.id.fixed_container);
        var1_1.title = (TimerTextEffectView)var2_2.findViewById(R.id.fixed_width_text);
        var1_1.content = (TimerTextEffectView)var2_2.findViewById(R.id.unit_text);
        var1_1.textShade = var2_2.findViewById(R.id.island_text_shade);
        var1_1.textShadeEnd = var2_2.findViewById(R.id.island_text_shade_end);
        return s.a;
    }

    @Override
    public void initView(String string) {
        o.g((Object)string, (String)"module");
        super.initView(string);
        this.iconViewHolder.initView(string);
        string = this.title;
        if (string != null) {
            string.setEnableEffectWithInit(false);
        }
        string = this.content;
        if (string != null) {
            string.setEnableEffectWithInit(false);
        }
        this.choreographer = Choreographer.getInstance();
        this.attach();
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    public final void scheduleUpdate() {
        if (this.updateScheduled) {
            return;
        }
        this.updateScheduled = true;
        Choreographer choreographer = this.choreographer;
        if (choreographer != null) {
            choreographer.postFrameCallback(this.frameCallback);
        }
    }

    public final void setChoreographer(Choreographer choreographer) {
        this.choreographer = choreographer;
    }

    public final void setUpdateScheduled(boolean bl) {
        this.updateScheduled = bl;
    }

    @Override
    public void updatePartial(IslandTemplate islandTemplate, DynamicIslandData dynamicIslandData) {
        o.g((Object)islandTemplate, (String)"template");
        super.updatePartial(islandTemplate, dynamicIslandData);
        this.bind(islandTemplate, dynamicIslandData);
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    @Override
    public void updateWidth(int var1_1) {
        if (DynamicIslandUtils.INSTANCE.isDynamicIslandPadNoPropOnce(this.getDynamicIslandData())) {
            return;
        }
        var6_2 = this.getContext().getResources().getDimensionPixelSize(R.dimen.island_area_padding);
        var7_3 = this.getContext().getResources().getDimensionPixelSize(R.dimen.island_text_padding_inner);
        var9_4 = var1_1 - this.iconViewHolder.getWidth() - var6_2 - var7_3;
        var10_5 /* !! */  = new StringBuilder();
        var10_5 /* !! */ .append("originWidth=");
        var10_5 /* !! */ .append(var1_1);
        var10_5 /* !! */ .append(", realWidth=");
        var10_5 /* !! */ .append(var9_4);
        Log.i((String)"IslandIconFixedWidthTextHolder", (String)var10_5 /* !! */ .toString());
        this.setFixedFont((TextView)this.title);
        var10_5 /* !! */  = this.title;
        var6_2 = var10_5 /* !! */  != null ? var10_5 /* !! */ .getMeasuredWidth() : 0;
        var7_3 = this.getContext().getResources().getDimensionPixelSize(R.dimen.text_padding);
        var10_5 /* !! */  = this.content;
        var1_1 = var7_3;
        if (var10_5 /* !! */  == null) ** GOTO lbl-1000
        var1_1 = var7_3;
        if (var10_5 /* !! */ .getVisibility() != 0) ** GOTO lbl-1000
        var10_5 /* !! */  = this.content;
        var1_1 = var7_3 += this.getContext().getResources().getDimensionPixelSize(R.dimen.island_text_content_margin);
        if (var10_5 /* !! */  != null) {
            var8_6 = var10_5 /* !! */ .getMeasuredWidth();
            var1_1 = var7_3;
            var7_3 = var8_6;
        } else lbl-1000:
        // 3 sources

        {
            var7_3 = 0;
        }
        var10_5 /* !! */  = new StringBuilder();
        var10_5 /* !! */ .append("titleWidth=");
        var10_5 /* !! */ .append(var6_2);
        var10_5 /* !! */ .append(", contentWidth=");
        var10_5 /* !! */ .append(var7_3);
        Log.i((String)"IslandIconFixedWidthTextHolder", (String)var10_5 /* !! */ .toString());
        var8_6 = var6_2 + var7_3 + var1_1;
        var10_5 /* !! */  = new StringBuilder();
        var10_5 /* !! */ .append("totalTextWidth=");
        var10_5 /* !! */ .append(var8_6);
        Log.d((String)"IslandIconFixedWidthTextHolder", (String)var10_5 /* !! */ .toString());
        var3_7 = this.getContext().getResources().getDisplayMetrics().density;
        if (var9_4 < var8_6) {
            var10_5 /* !! */  = this.textShade;
            if (var10_5 /* !! */  != null) {
                var4_8 = var6_2;
                var2_9 = var7_3;
                var5_11 = var1_1;
                if ((float)var9_4 < var4_8 * 0.79f + var2_9 + var5_11) {
                    Log.d((String)"IslandIconFixedWidthTextHolder", (String)"text shade show");
                    var11_12 = this.textShade;
                    if (var11_12 != null) {
                        var11_12.setVisibility(0);
                    }
                    var11_12 = this.textShadeEnd;
                    if (var11_12 != null) {
                        var11_12.setVisibility(0);
                    }
                    var7_3 = var10_5 /* !! */ .getContext().getResources().getDimensionPixelSize(R.dimen.island_area_left_fixed_width) - var9_4;
                    var11_12 = var10_5 /* !! */ .getLayoutParams();
                    o.e((Object)var11_12, (String)"null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
                    var12_13 = (FrameLayout.LayoutParams)var11_12;
                    var11_12 = var10_5 /* !! */ .getContext();
                    o.f((Object)var11_12, (String)"getContext(...)");
                    var1_1 = CommonUtils.isLayoutRtl((Context)var11_12) != false ? R.drawable.dynamic_island_shade_rtl : R.drawable.dynamic_island_shade;
                    var10_5 /* !! */ .setBackgroundResource(var1_1);
                    var12_13.setMarginEnd(var7_3);
                    var10_5 /* !! */ .setLayoutParams((ViewGroup.LayoutParams)var12_13);
                    var10_5 /* !! */  = this.textShadeEnd;
                    var11_12 = null;
                    var10_5 /* !! */  = var10_5 /* !! */  != null ? var10_5 /* !! */ .getLayoutParams() : null;
                    if (var10_5 /* !! */  instanceof FrameLayout.LayoutParams) {
                        var11_12 = (FrameLayout.LayoutParams)var10_5 /* !! */ ;
                    }
                    if (var11_12 != null) {
                        var11_12.width = var7_3;
                        var10_5 /* !! */  = this.textShadeEnd;
                        if (var10_5 /* !! */  != null) {
                            var10_5 /* !! */ .setLayoutParams((ViewGroup.LayoutParams)var11_12);
                        }
                    }
                } else {
                    if (var10_5 /* !! */  != null) {
                        var10_5 /* !! */ .setVisibility(8);
                    }
                    var10_5 /* !! */  = this.textShadeEnd;
                    if (var10_5 /* !! */  != null) {
                        var10_5 /* !! */ .setVisibility(8);
                    }
                }
            }
            if ((var10_5 /* !! */  = this.title) != null) {
                var2_9 = CommonUtils.isLayoutRtl((Context)this.getContext()) == false ? 0.0f : (float)var6_2;
                var10_5 /* !! */ .setPivotX(var2_9);
            }
            if ((var10_5 /* !! */  = this.title) != null) {
                var10_5 /* !! */ .setPivotY((float)Math.ceil(19.0f * var3_7) / (float)2);
            }
            this.titleAnimation(0.79f, 0.0f);
            var2_9 = CommonUtils.isLayoutRtl((Context)this.getContext()) == false ? -0.21f : 0.21f;
            this.contentAnimation(var2_9 * (float)var6_2, (float)Math.ceil(var3_7 * -1.0f));
        } else {
            var10_5 /* !! */  = this.textShade;
            if (var10_5 /* !! */  != null) {
                var10_5 /* !! */ .setVisibility(8);
            }
            var10_5 /* !! */  = this.textShadeEnd;
            if (var10_5 /* !! */  != null) {
                var10_5 /* !! */ .setVisibility(8);
            }
            var10_5 /* !! */  = this.title;
            if (var10_5 /* !! */  != null) {
                var2_10 = CommonUtils.isLayoutRtl((Context)this.getContext()) == false ? 0.0f : (float)var6_2;
                var10_5 /* !! */ .setPivotX(var2_10);
            }
            if ((var10_5 /* !! */  = this.title) != null) {
                var10_5 /* !! */ .setPivotY((float)Math.ceil(var3_7 * 19.0f) / (float)2);
            }
            this.titleAnimation(1.0f, 0.0f);
            this.contentAnimation(0.0f, 0.0f);
        }
    }
}
