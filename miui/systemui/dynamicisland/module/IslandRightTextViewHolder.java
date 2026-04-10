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
 *  android.util.Log
 *  android.view.Choreographer
 *  android.view.Choreographer$FrameCallback
 *  android.view.View
 *  android.view.View$OnAttachStateChangeListener
 *  android.view.ViewGroup
 *  android.view.ViewGroup$LayoutParams
 *  android.view.ViewStub
 *  android.widget.FrameLayout$LayoutParams
 *  android.widget.TextView
 *  com.android.systemui.plugins.miui.dynamicisland.DynamicIslandData
 *  kotlin.jvm.internal.o
 *  miui.systemui.animation.FolmeKt
 *  miui.systemui.util.CommonUtils
 *  miuix.animation.FolmeObject
 *  miuix.animation.base.AnimConfig
 *  miuix.animation.controller.AnimState
 *  miuix.animation.listener.TransitionListener
 *  miuix.animation.listener.UpdateInfo
 *  miuix.animation.property.FloatProperty
 *  miuix.colorful.texteffect.TextChangeHelper
 *  miuix.colorful.texteffect.TextChangeProcessor
 *  miuix.colorful.texteffect.TimerTextEffectView
 */
package miui.systemui.dynamicisland.module;

import G0.k;
import G0.s;
import K0.d;
import L0.c;
import android.content.Context;
import android.util.Log;
import android.view.Choreographer;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.android.systemui.plugins.miui.dynamicisland.DynamicIslandData;
import java.util.Collection;
import kotlin.jvm.internal.o;
import miui.systemui.animation.FolmeKt;
import miui.systemui.dynamicisland.DynamicIslandUtils;
import miui.systemui.dynamicisland.R;
import miui.systemui.dynamicisland.model.BigIslandArea;
import miui.systemui.dynamicisland.model.IslandTemplate;
import miui.systemui.dynamicisland.model.TextInfo;
import miui.systemui.dynamicisland.module.BaseIslandModuleViewHolder;
import miui.systemui.dynamicisland.module.IslandRightTextViewHolder;
import miui.systemui.dynamicisland.module.h;
import miui.systemui.util.CommonUtils;
import miuix.animation.FolmeObject;
import miuix.animation.base.AnimConfig;
import miuix.animation.controller.AnimState;
import miuix.animation.listener.TransitionListener;
import miuix.animation.listener.UpdateInfo;
import miuix.animation.property.FloatProperty;
import miuix.colorful.texteffect.TextChangeHelper;
import miuix.colorful.texteffect.TextChangeProcessor;
import miuix.colorful.texteffect.TimerTextEffectView;

public class IslandRightTextViewHolder
extends BaseIslandModuleViewHolder {
    private static final CONTENT_TRANS_X.1 CONTENT_TRANS_X;
    public static final Companion Companion;
    private static final FRONT_TITLE_TRANS_X.1 FRONT_TITLE_TRANS_X;
    public static final String TAG = "IslandRightTextViewHolder";
    private static final TITLE_SCALE_X.1 TITLE_SCALE_X;
    private static final TITLE_SCALE_Y.1 TITLE_SCALE_Y;
    private static final TITLE_TRANS_X.1 TITLE_TRANS_X;
    private Choreographer choreographer;
    private TimerTextEffectView content;
    private ViewStub contentStub;
    private float contentTransX;
    private String curHighlightColor;
    private final Choreographer.FrameCallback frameCallback;
    private TimerTextEffectView frontTitle;
    private ViewStub frontTitleStub;
    private float frontTitleTransX;
    private boolean lastRtl;
    private int lastWidth;
    private Boolean narrowFont;
    private boolean scaleChanged;
    private Boolean showHighlightInfo;
    private boolean textChanged;
    private TextInfo textInfo;
    private View textShade;
    private TimerTextEffectView title;
    private ViewGroup titleContainer;
    private float titleScaleX;
    private float titleScaleY;
    private ViewStub titleStub;
    private float titleTransX;
    private boolean updateScheduled;

    static {
        Companion = new Object(null){
            {
                this();
            }
        };
        TITLE_TRANS_X = new FloatProperty<IslandRightTextViewHolder>(){

            public float getValue(IslandRightTextViewHolder islandRightTextViewHolder) {
                o.g((Object)islandRightTextViewHolder, (String)"holder");
                return IslandRightTextViewHolder.access$getTitleTransX$p(islandRightTextViewHolder);
            }

            public void setValue(IslandRightTextViewHolder islandRightTextViewHolder, float f2) {
                o.g((Object)islandRightTextViewHolder, (String)"holder");
                if (Float.isNaN(f2)) {
                    return;
                }
                IslandRightTextViewHolder.access$setTitleTransX$p(islandRightTextViewHolder, f2);
            }
        };
        CONTENT_TRANS_X = new FloatProperty<IslandRightTextViewHolder>(){

            public float getValue(IslandRightTextViewHolder islandRightTextViewHolder) {
                o.g((Object)islandRightTextViewHolder, (String)"holder");
                return IslandRightTextViewHolder.access$getContentTransX$p(islandRightTextViewHolder);
            }

            public void setValue(IslandRightTextViewHolder islandRightTextViewHolder, float f2) {
                o.g((Object)islandRightTextViewHolder, (String)"holder");
                if (Float.isNaN(f2)) {
                    return;
                }
                IslandRightTextViewHolder.access$setContentTransX$p(islandRightTextViewHolder, f2);
            }
        };
        FRONT_TITLE_TRANS_X = new FloatProperty<IslandRightTextViewHolder>(){

            public float getValue(IslandRightTextViewHolder islandRightTextViewHolder) {
                o.g((Object)islandRightTextViewHolder, (String)"holder");
                return IslandRightTextViewHolder.access$getFrontTitleTransX$p(islandRightTextViewHolder);
            }

            public void setValue(IslandRightTextViewHolder islandRightTextViewHolder, float f2) {
                o.g((Object)islandRightTextViewHolder, (String)"holder");
                if (Float.isNaN(f2)) {
                    return;
                }
                IslandRightTextViewHolder.access$setFrontTitleTransX$p(islandRightTextViewHolder, f2);
            }
        };
        TITLE_SCALE_X = new FloatProperty<IslandRightTextViewHolder>(){

            public float getValue(IslandRightTextViewHolder islandRightTextViewHolder) {
                o.g((Object)islandRightTextViewHolder, (String)"holder");
                return IslandRightTextViewHolder.access$getTitleScaleX$p(islandRightTextViewHolder);
            }

            public void setValue(IslandRightTextViewHolder islandRightTextViewHolder, float f2) {
                o.g((Object)islandRightTextViewHolder, (String)"holder");
                if (Float.isNaN(f2)) {
                    return;
                }
                IslandRightTextViewHolder.access$setTitleScaleX$p(islandRightTextViewHolder, f2);
            }
        };
        TITLE_SCALE_Y = new FloatProperty<IslandRightTextViewHolder>(){

            public float getValue(IslandRightTextViewHolder islandRightTextViewHolder) {
                o.g((Object)islandRightTextViewHolder, (String)"holder");
                return IslandRightTextViewHolder.access$getTitleScaleY$p(islandRightTextViewHolder);
            }

            public void setValue(IslandRightTextViewHolder islandRightTextViewHolder, float f2) {
                o.g((Object)islandRightTextViewHolder, (String)"holder");
                if (Float.isNaN(f2)) {
                    return;
                }
                IslandRightTextViewHolder.access$setTitleScaleY$p(islandRightTextViewHolder, f2);
            }
        };
    }

    public IslandRightTextViewHolder(Context context, ViewGroup viewGroup, U0.o o2) {
        o.g((Object)context, (String)"context");
        o.g((Object)viewGroup, (String)"rootView");
        o.g((Object)o2, (String)"emitEvent");
        super(context, viewGroup, o2);
        this.titleScaleX = 1.0f;
        this.titleScaleY = 1.0f;
        this.frameCallback = new h(this);
    }

    public static /* synthetic */ void a(IslandRightTextViewHolder islandRightTextViewHolder, long l) {
        IslandRightTextViewHolder.frameCallback$lambda$2(islandRightTextViewHolder, l);
    }

    public static final /* synthetic */ void access$contentScheduleUpdate(IslandRightTextViewHolder islandRightTextViewHolder) {
        islandRightTextViewHolder.contentScheduleUpdate();
    }

    public static final /* synthetic */ void access$frontTitleScheduleUpdate(IslandRightTextViewHolder islandRightTextViewHolder) {
        islandRightTextViewHolder.frontTitleScheduleUpdate();
    }

    public static final /* synthetic */ float access$getContentTransX$p(IslandRightTextViewHolder islandRightTextViewHolder) {
        return islandRightTextViewHolder.contentTransX;
    }

    public static final /* synthetic */ float access$getFrontTitleTransX$p(IslandRightTextViewHolder islandRightTextViewHolder) {
        return islandRightTextViewHolder.frontTitleTransX;
    }

    public static final /* synthetic */ float access$getTitleScaleX$p(IslandRightTextViewHolder islandRightTextViewHolder) {
        return islandRightTextViewHolder.titleScaleX;
    }

    public static final /* synthetic */ float access$getTitleScaleY$p(IslandRightTextViewHolder islandRightTextViewHolder) {
        return islandRightTextViewHolder.titleScaleY;
    }

    public static final /* synthetic */ float access$getTitleTransX$p(IslandRightTextViewHolder islandRightTextViewHolder) {
        return islandRightTextViewHolder.titleTransX;
    }

    public static final /* synthetic */ void access$setContentTransX$p(IslandRightTextViewHolder islandRightTextViewHolder, float f) {
        islandRightTextViewHolder.contentTransX = f;
    }

    public static final /* synthetic */ void access$setFrontTitleTransX$p(IslandRightTextViewHolder islandRightTextViewHolder, float f) {
        islandRightTextViewHolder.frontTitleTransX = f;
    }

    public static final /* synthetic */ void access$setTitleScaleX$p(IslandRightTextViewHolder islandRightTextViewHolder, float f) {
        islandRightTextViewHolder.titleScaleX = f;
    }

    public static final /* synthetic */ void access$setTitleScaleY$p(IslandRightTextViewHolder islandRightTextViewHolder, float f) {
        islandRightTextViewHolder.titleScaleY = f;
    }

    public static final /* synthetic */ void access$setTitleTransX$p(IslandRightTextViewHolder islandRightTextViewHolder, float f) {
        islandRightTextViewHolder.titleTransX = f;
    }

    public static final /* synthetic */ void access$titleScheduleUpdate(IslandRightTextViewHolder islandRightTextViewHolder) {
        islandRightTextViewHolder.titleScheduleUpdate();
    }

    private final void attach() {
        ViewGroup viewGroup = this.titleContainer;
        if (viewGroup != null) {
            viewGroup.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener(this){
                final IslandRightTextViewHolder this$0;
                {
                    this.this$0 = islandRightTextViewHolder;
                }

                public void onViewAttachedToWindow(View view) {
                    o.g((Object)view, (String)"p0");
                    Log.d((String)"IslandRightTextViewHolder", (String)"onViewAttachedToWindow");
                }

                public void onViewDetachedFromWindow(View view) {
                    o.g((Object)view, (String)"p0");
                    Log.d((String)"IslandRightTextViewHolder", (String)"onViewDetachedFromWindow");
                    FolmeKt.getFolme((FolmeObject)this.this$0).end(new Object[]{"dynamic_title_trans_x", "dynamic_content_trans_x", "dynamic_front_title_trans_x", "dynamic_title_scale_x", "dynamic_title_scale_y"});
                    FolmeKt.getFolme((FolmeObject)this.this$0).clean();
                    IslandRightTextViewHolder.access$titleScheduleUpdate(this.this$0);
                    IslandRightTextViewHolder.access$contentScheduleUpdate(this.this$0);
                    IslandRightTextViewHolder.access$frontTitleScheduleUpdate(this.this$0);
                }
            });
        }
    }

    private final void contentAnimation(float f2) {
        FolmeKt.getFolme((FolmeObject)this).to((Object)new AnimState().add((FloatProperty)CONTENT_TRANS_X, f2, new long[0]), new AnimConfig[]{new AnimConfig().addListeners(new TransitionListener[]{new TransitionListener(this){
            final IslandRightTextViewHolder this$0;
            {
                this.this$0 = islandRightTextViewHolder;
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
    }

    private static final void frameCallback$lambda$2(IslandRightTextViewHolder islandRightTextViewHolder, long l) {
        o.g((Object)islandRightTextViewHolder, (String)"this$0");
        islandRightTextViewHolder.updateScheduled = false;
        islandRightTextViewHolder.titleScheduleUpdate();
        islandRightTextViewHolder.contentScheduleUpdate();
        islandRightTextViewHolder.frontTitleScheduleUpdate();
    }

    private final void frontTitleScheduleUpdate() {
        TimerTextEffectView timerTextEffectView = this.frontTitle;
        if (timerTextEffectView != null) {
            timerTextEffectView.setTranslationX(this.frontTitleTransX);
        }
    }

    private final void frontTitleTranXAnimation(float f2) {
        FolmeKt.getFolme((FolmeObject)this).to((Object)new AnimState().add((FloatProperty)FRONT_TITLE_TRANS_X, f2, new long[0]), new AnimConfig[]{new AnimConfig().addListeners(new TransitionListener[]{new TransitionListener(this){
            final IslandRightTextViewHolder this$0;
            {
                this.this$0 = islandRightTextViewHolder;
            }

            public void onUpdate(Object object, Collection<UpdateInfo> collection) {
                this.this$0.scheduleUpdate();
            }
        }})});
    }

    private final int getSpaceWidth(int n, int n2, int n3) {
        int n4;
        if (n > 0 && n2 > 0) {
            n4 = n3 * 2;
        } else {
            n4 = n3;
            if (n <= 0) {
                n4 = n2 > 0 ? n3 : 0;
            }
        }
        return n4;
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    public static /* synthetic */ Object initLayout$suspendImpl(IslandRightTextViewHolder var0, View var1_1, String var2_2, d var3_3) {
        if (!(var3_3 /* !! */  instanceof initLayout.1)) ** GOTO lbl-1000
        var6_4 = var3_3 /* !! */ ;
        var4_5 = var6_4.label;
        if ((var4_5 & -2147483648) != 0) {
            var6_4.label = var4_5 + -2147483648;
        } else lbl-1000:
        // 2 sources

        {
            var6_4 = new M0.d(var0, var3_3 /* !! */ ){
                Object L$0;
                Object L$1;
                int label;
                Object result;
                final IslandRightTextViewHolder this$0;
                {
                    this.this$0 = islandRightTextViewHolder;
                    super(d2);
                }

                public final Object invokeSuspend(Object object) {
                    this.result = object;
                    this.label |= Integer.MIN_VALUE;
                    return IslandRightTextViewHolder.initLayout$suspendImpl(this.this$0, null, null, (d)this);
                }
            };
        }
        var8_6 = var6_4.result;
        var7_7 = c.c();
        var4_5 = var6_4.label;
        if (var4_5 == 0) ** GOTO lbl18
        if (var4_5 == 1) {
            var5_8 = (View)var6_4.L$1;
            var3_3 /* !! */  = (IslandRightTextViewHolder)var6_4.L$0;
            k.b((Object)var8_6);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
lbl18:
            // 1 sources

            k.b((Object)var8_6);
            var6_4.L$0 = var0;
            var6_4.L$1 = var1_1;
            var6_4.label = 1;
            var3_3 /* !! */  = var0;
            var5_8 = var1_1;
            if (super.initLayout(var1_1, var2_2, (d)var6_4) == var7_7) {
                return var7_7;
            }
        }
        var1_1 = null;
        var0 = var5_8 != null ? (ViewGroup)var5_8.findViewById(R.id.island_container_module_right_text) : null;
        var3_3 /* !! */ .titleContainer = var0;
        var0 = var5_8 != null ? (ViewStub)var5_8.findViewById(R.id.island_title_stub) : null;
        var3_3 /* !! */ .titleStub = var0;
        var0 = var5_8 != null ? (ViewStub)var5_8.findViewById(R.id.island_front_title_stub) : null;
        var3_3 /* !! */ .frontTitleStub = var0;
        var0 = var5_8 != null ? (ViewStub)var5_8.findViewById(R.id.island_content_stub) : null;
        var3_3 /* !! */ .contentStub = var0;
        var0 = var1_1;
        if (var5_8 != null) {
            var0 = var5_8.findViewById(R.id.island_text_shade);
        }
        var3_3 /* !! */ .textShade = var0;
        return s.a;
    }

    private final void resetPosition() {
        this.frontTitleTranXAnimation(0.0f);
        this.titleAnimation(1.0f, 0.0f);
        this.contentAnimation(0.0f);
    }

    private final void scaleChanged(float f2) {
        Object object = this.title;
        object = object != null ? Float.valueOf(object.getScaleX()) : null;
        if (!o.a((float)f2, (Float)object)) {
            this.scaleChanged = true;
        }
    }

    private final void scaledPositionAdjust(int n) {
        if (!CommonUtils.isLayoutRtl((Context)this.getContext())) {
            this.frontTitleTranXAnimation((float)n * 0.21f);
        } else {
            this.frontTitleTranXAnimation((float)n * -0.21f);
        }
        this.titleAnimation(0.79f, 0.0f);
        this.contentAnimation(0.0f);
    }

    private final void setTextVisibility(boolean bl, boolean bl2, boolean bl3, boolean bl4) {
        Object object;
        if (bl2 && (object = this.textInfo) != null && (object = ((TextInfo)object).getTitle()) != null && object.length() > 0) {
            object = this.title;
            if (object != null) {
                object.setVisibility(0);
            }
        } else {
            object = this.title;
            if (object != null) {
                object.setVisibility(8);
            }
        }
        if (bl && (object = this.textInfo) != null && (object = ((TextInfo)object).getFrontTitle()) != null && object.length() > 0 && (object = this.title) != null && object.getVisibility() == 0) {
            object = this.frontTitle;
            if (object != null) {
                object.setVisibility(0);
            }
        } else {
            object = this.frontTitle;
            if (object != null) {
                object.setVisibility(8);
            }
        }
        if (bl3 && (object = this.textInfo) != null && (object = ((TextInfo)object).getContent()) != null && object.length() > 0 && (object = this.title) != null && object.getVisibility() == 0) {
            object = this.content;
            if (object != null) {
                object.setVisibility(0);
            }
        } else {
            object = this.content;
            if (object != null) {
                object.setVisibility(8);
            }
        }
        if (bl4) {
            object = this.textShade;
            if (object != null) {
                object.setVisibility(0);
            }
        } else {
            object = this.textShade;
            if (object != null) {
                object.setVisibility(8);
            }
        }
    }

    private final void setTitlePivot(int n) {
        float f2;
        TimerTextEffectView timerTextEffectView = this.title;
        if (timerTextEffectView != null) {
            f2 = !CommonUtils.isLayoutRtl((Context)this.getContext()) ? (float)n : 0.0f;
            timerTextEffectView.setPivotX(f2);
        }
        f2 = (timerTextEffectView = this.title) != null ? (float)timerTextEffectView.getMeasuredHeight() : 0.0f;
        float f3 = f2;
        if (f2 == 0.0f) {
            f3 = this.getContext().getResources().getDimensionPixelSize(R.dimen.island_title_height);
        }
        if (!((timerTextEffectView = this.title) == null || timerTextEffectView.getVisibility() != 0 || (timerTextEffectView = this.content) != null && timerTextEffectView.getVisibility() == 0 || (timerTextEffectView = this.frontTitle) != null && timerTextEffectView.getVisibility() == 0)) {
            timerTextEffectView = this.title;
            if (timerTextEffectView != null) {
                timerTextEffectView.setPivotY(f3 / 2.0f);
            }
        } else {
            timerTextEffectView = this.title;
            if (timerTextEffectView != null) {
                timerTextEffectView.setPivotY(f3 - (float)this.getContext().getResources().getDimensionPixelSize(R.dimen.island_text_content_margin_bottom));
            }
        }
    }

    private final boolean textChanged(IslandTemplate object) {
        block7: {
            block8: {
                Boolean bl;
                Object object2 = this.textInfo;
                Object var3_3 = null;
                if ((object2 = object2 != null ? ((TextInfo)object2).getNarrowFont() : null) != null && !o.c((Object)(bl = this.narrowFont), (Object)(object2 = (object2 = this.textInfo) != null ? ((TextInfo)object2).getNarrowFont() : null))) {
                    return true;
                }
                object2 = this.textInfo;
                object2 = object2 != null ? ((TextInfo)object2).getShowHighlightColor() : null;
                if (object2 != null && !o.c((Object)(bl = this.showHighlightInfo), (Object)(object2 = (object2 = this.textInfo) != null ? ((TextInfo)object2).getShowHighlightColor() : null))) {
                    return true;
                }
                if (!o.c((Object)((IslandTemplate)object).getHighlightColor(), (Object)this.curHighlightColor)) {
                    return true;
                }
                object = this.textInfo;
                object = object != null ? ((TextInfo)object).getTitle() : null;
                object2 = this.title;
                if (!o.c((Object)object, (Object)String.valueOf(object2 = object2 != null ? object2.getText() : null))) break block7;
                object = this.textInfo;
                object = object != null ? ((TextInfo)object).getFrontTitle() : null;
                object2 = this.frontTitle;
                if (!o.c((Object)object, (Object)String.valueOf(object2 = object2 != null ? object2.getText() : null)) && ((object = (object = this.textInfo) != null ? ((TextInfo)object).getFrontTitle() : null) != null || (object = this.frontTitle) != null && String.valueOf(object = object != null ? object.getText() : null).length() != 0)) break block7;
                object = this.textInfo;
                object = object != null ? ((TextInfo)object).getContent() : null;
                object2 = this.content;
                if (o.c((Object)object, (Object)String.valueOf(object2 = object2 != null ? object2.getText() : null))) break block8;
                object = this.textInfo;
                object = object != null ? ((TextInfo)object).getContent() : null;
                if (object != null) break block7;
                object2 = this.content;
                if (object2 == null) break block8;
                object = var3_3;
                if (object2 != null) {
                    object = object2.getText();
                }
                if (String.valueOf(object).length() != 0) break block7;
            }
            return false;
        }
        return true;
    }

    private final void titleAnimation(float f2, float f3) {
        FolmeKt.getFolme((FolmeObject)this).to((Object)new AnimState().add((FloatProperty)TITLE_SCALE_X, f2, new long[0]).add((FloatProperty)TITLE_SCALE_Y, f2, new long[0]).add((FloatProperty)TITLE_TRANS_X, f3, new long[0]), new AnimConfig[]{new AnimConfig().addListeners(new TransitionListener[]{new TransitionListener(this){
            final IslandRightTextViewHolder this$0;
            {
                this.this$0 = islandRightTextViewHolder;
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
    public void bind(IslandTemplate islandTemplate, DynamicIslandData object) {
        Object object2;
        Object var8_4;
        boolean bl;
        block36: {
            block35: {
                block34: {
                    block33: {
                        o.g((Object)islandTemplate, (String)"template");
                        super.bind(islandTemplate, (DynamicIslandData)object);
                        this.curHighlightColor = islandTemplate.getHighlightColor();
                        bl = o.c((Object)this.getModule(), (Object)"moduleText");
                        var8_4 = null;
                        if (bl) {
                            object = islandTemplate.getBigIslandArea();
                            object = object != null ? ((BigIslandArea)object).getTextInfo() : null;
                            this.textInfo = object;
                        }
                        if ((object = this.textInfo) == null) break block33;
                        object = object2 = ((TextInfo)object).getNarrowFont();
                        if (object2 != null) break block34;
                    }
                    object = Boolean.FALSE;
                }
                this.narrowFont = object;
                object = this.textInfo;
                if (object == null) break block35;
                object = object2 = ((TextInfo)object).getShowHighlightColor();
                if (object2 != null) break block36;
            }
            object = Boolean.FALSE;
        }
        this.showHighlightInfo = object;
        this.setFont(this.textInfo, (TextView)this.title);
        this.setFont(this.textInfo, (TextView)this.frontTitle);
        this.setFont(this.textInfo, (TextView)this.content);
        object = this.textInfo;
        Object object3 = object != null ? ((TextInfo)object).getTitle() : null;
        object = this.textInfo;
        Object object4 = object != null ? ((TextInfo)object).getFrontTitle() : null;
        object = this.textInfo;
        object2 = object != null ? ((TextInfo)object).getContent() : null;
        boolean bl2 = false;
        if (object3 != null && object3.length() > 0) {
            Object object5;
            object = object5 = this.title;
            if (object5 == null) {
                object = this.titleStub;
                object = object != null ? object.inflate() : null;
                object = object instanceof TimerTextEffectView ? (TimerTextEffectView)object : null;
            }
            this.title = object;
            if (object != null) {
                object.setVisibility(0);
            }
            object = this.title;
            if (object != null) {
                object.setTextChangeProcessor((TextChangeProcessor)new TextChangeHelper());
            }
            if ((object = this.title) != null) {
                object5 = this.textInfo;
                bl = object5 != null ? o.c((Object)((TextInfo)object5).getTurnAnim(), (Object)Boolean.TRUE) : false;
                object.enableEffect(bl);
            }
            object = (object = this.textInfo) != null ? ((TextInfo)object).getShowHighlightColor() : null;
            this.setTitleHighlightColor(islandTemplate, (Boolean)object, this.title, (String)object3);
        } else {
            object = this.title;
            if (object != null) {
                object.setVisibility(8);
            }
            object = this.title;
            if (object != null) {
                object.setText((CharSequence)object3);
            }
        }
        if (object4 != null && object4.length() > 0 && (object = this.title) != null && object.getVisibility() == 0) {
            object = object3 = this.frontTitle;
            if (object3 == null) {
                object = this.frontTitleStub;
                object = object != null ? object.inflate() : null;
                object = object instanceof TimerTextEffectView ? (TimerTextEffectView)object : null;
            }
            this.frontTitle = object;
            if (object != null) {
                object.setVisibility(0);
            }
            object = this.frontTitle;
            if (object != null) {
                object.setTextChangeProcessor((TextChangeProcessor)new TextChangeHelper());
            }
            if ((object = this.frontTitle) != null) {
                object3 = this.textInfo;
                bl = object3 != null ? o.c((Object)((TextInfo)object3).getTurnAnim(), (Object)Boolean.TRUE) : false;
                object.enableEffect(bl);
            }
            object = (object = this.textInfo) != null ? ((TextInfo)object).getShowHighlightColor() : null;
            this.setContentHighlightColor(islandTemplate, (Boolean)object, this.frontTitle, (String)object4);
        } else {
            object = this.frontTitle;
            if (object != null) {
                object.setVisibility(8);
            }
            object = this.frontTitle;
            if (object != null) {
                object.setText((CharSequence)object4);
            }
        }
        if (object2 != null && object2.length() > 0 && (object = this.title) != null && object.getVisibility() == 0) {
            object = object4 = this.content;
            if (object4 == null) {
                object = this.contentStub;
                object = object != null ? object.inflate() : null;
                object = object instanceof TimerTextEffectView ? (TimerTextEffectView)object : null;
            }
            this.content = object;
            if (object != null) {
                object.setVisibility(0);
            }
            object = this.content;
            if (object != null) {
                object.setTextChangeProcessor((TextChangeProcessor)new TextChangeHelper());
            }
            if ((object = this.content) != null) {
                object4 = this.textInfo;
                bl = bl2;
                if (object4 != null) {
                    bl = o.c((Object)((TextInfo)object4).getTurnAnim(), (Object)Boolean.TRUE);
                }
                object.enableEffect(bl);
            }
            object4 = this.textInfo;
            object = var8_4;
            if (object4 != null) {
                object = ((TextInfo)object4).getShowHighlightColor();
            }
            this.setContentHighlightColor(islandTemplate, (Boolean)object, this.content, (String)object2);
        } else {
            islandTemplate = this.content;
            if (islandTemplate != null) {
                islandTemplate.setVisibility(8);
            }
            islandTemplate = this.content;
            if (islandTemplate != null) {
                islandTemplate.setText((CharSequence)object2);
            }
        }
    }

    public final Choreographer getChoreographer() {
        return this.choreographer;
    }

    public final TextInfo getTextInfo() {
        return this.textInfo;
    }

    public final boolean getUpdateScheduled() {
        return this.updateScheduled;
    }

    @Override
    public Object initLayout(View view, String string, d d2) {
        return IslandRightTextViewHolder.initLayout$suspendImpl(this, view, string, d2);
    }

    @Override
    public void initView(String string) {
        o.g((Object)string, (String)"module");
        super.initView(string);
        this.choreographer = Choreographer.getInstance();
        this.attach();
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

    public final void setTextInfo(TextInfo textInfo) {
        this.textInfo = textInfo;
    }

    public final void setUpdateScheduled(boolean bl) {
        this.updateScheduled = bl;
    }

    @Override
    public void updatePartial(IslandTemplate islandTemplate, DynamicIslandData dynamicIslandData) {
        Object object;
        o.g((Object)islandTemplate, (String)"template");
        super.updatePartial(islandTemplate, dynamicIslandData);
        boolean bl = o.c((Object)this.getModule(), (Object)"moduleText");
        Object var5_4 = null;
        if (bl) {
            object = islandTemplate.getBigIslandArea();
            object = object != null ? ((BigIslandArea)object).getTextInfo() : null;
            this.textInfo = object;
        }
        if (!this.textChanged && !this.textChanged(islandTemplate)) {
            this.textChanged = false;
            return;
        }
        this.textChanged = true;
        object = this.frontTitle;
        object = object != null ? object.getLayoutParams() : null;
        if (object != null) {
            ((ViewGroup.LayoutParams)object).width = -2;
        }
        object = this.content;
        object = object != null ? object.getLayoutParams() : null;
        if (object != null) {
            ((ViewGroup.LayoutParams)object).width = -2;
        }
        TimerTextEffectView timerTextEffectView = this.title;
        object = var5_4;
        if (timerTextEffectView != null) {
            object = timerTextEffectView.getLayoutParams();
        }
        if (object != null) {
            ((ViewGroup.LayoutParams)object).width = -2;
        }
        this.bind(islandTemplate, dynamicIslandData);
    }

    /*
     * Enabled aggressive block sorting
     */
    @Override
    public void updateWidth(int n) {
        int n2;
        int n3;
        if (DynamicIslandUtils.INSTANCE.isDynamicIslandPadNoPropOnce(this.getDynamicIslandData())) {
            n3 = n - this.getContext().getResources().getDimensionPixelSize(R.dimen.island_area_padding) - this.getContext().getResources().getDimensionPixelSize(R.dimen.text_padding_pad);
            n2 = this.getContext().getResources().getDimensionPixelSize(R.dimen.island_area_padding_cutout);
        } else {
            n3 = n - this.getContext().getResources().getDimensionPixelSize(R.dimen.island_area_padding) - this.getContext().getResources().getDimensionPixelSize(R.dimen.text_padding);
            n2 = this.getContext().getResources().getDimensionPixelSize(R.dimen.island_area_padding_cutout);
        }
        int n4 = n3 - n2;
        TimerTextEffectView timerTextEffectView = this.frontTitle;
        Object object = this.textInfo;
        object = object != null ? ((TextInfo)object).getFrontTitle() : null;
        int n5 = this.getTextViewWidth((TextView)timerTextEffectView, (String)object);
        timerTextEffectView = this.title;
        object = this.textInfo;
        object = object != null ? ((TextInfo)object).getTitle() : null;
        n2 = this.getTextViewWidth((TextView)timerTextEffectView, (String)object);
        timerTextEffectView = this.content;
        object = this.textInfo;
        object = object != null ? ((TextInfo)object).getContent() : null;
        int n6 = this.getTextViewWidth((TextView)timerTextEffectView, (String)object);
        int n7 = this.getContext().getResources().getDimensionPixelSize(R.dimen.island_text_padding_inner);
        int n8 = n5 + n2;
        int n9 = n8 + n6;
        n3 = this.getSpaceWidth(n5, n6, n7) + n9;
        object = new StringBuilder();
        ((StringBuilder)object).append("originWidth:");
        ((StringBuilder)object).append(n);
        ((StringBuilder)object).append(", updateWidth: ");
        ((StringBuilder)object).append(n4);
        ((StringBuilder)object).append(", totalTextWidth: ");
        ((StringBuilder)object).append(n3);
        Log.d((String)TAG, (String)((StringBuilder)object).toString());
        float f2 = n3 > n4 ? 0.79f : 1.0f;
        this.scaleChanged(f2);
        if (n4 == this.lastWidth && !this.textChanged && CommonUtils.isLayoutRtl((Context)this.getContext()) == this.lastRtl && !this.scaleChanged) {
            return;
        }
        this.textChanged = false;
        this.scaleChanged = false;
        this.lastWidth = n4;
        this.lastRtl = CommonUtils.isLayoutRtl((Context)this.getContext());
        if (n4 >= n9 + this.getSpaceWidth(n5, n6, n7)) {
            Log.d((String)TAG, (String)"case1");
            this.setTextVisibility(true, true, true, false);
            this.setTitlePivot(n2);
            this.resetPosition();
        } else {
            f2 = n4;
            float f3 = n5;
            float f4 = (float)n2 * 0.79f;
            if (f2 >= (float)n6 + (f3 += f4) + (float)this.getSpaceWidth(n5, n6, n7)) {
                Log.d((String)TAG, (String)"case2");
                this.setTextVisibility(true, true, true, false);
                this.setTitlePivot(n2);
                this.scaledPositionAdjust(n2);
            } else if (n4 >= n8 + this.getSpaceWidth(n5, n6, n7)) {
                Log.d((String)TAG, (String)"case3");
                this.setTextVisibility(true, true, false, false);
                this.setTitlePivot(n2);
                this.resetPosition();
            } else if (f2 >= f3 + (float)this.getSpaceWidth(n5, n6, n7)) {
                Log.d((String)TAG, (String)"case4");
                this.setTextVisibility(true, true, false, false);
                this.setTitlePivot(n2);
                this.scaledPositionAdjust(n2);
            } else if (n4 >= n2) {
                Log.d((String)TAG, (String)"case5");
                this.setTextVisibility(false, true, false, false);
                this.setTitlePivot(n2);
                this.resetPosition();
            } else if (f2 >= f4) {
                Log.d((String)TAG, (String)"case6");
                this.setTextVisibility(false, true, false, false);
                this.setTitlePivot(n2);
                this.scaledPositionAdjust(n2);
            } else {
                Log.d((String)TAG, (String)"case7");
                this.setTextVisibility(false, true, false, true);
                this.setTitlePivot(n2);
                if (!CommonUtils.isLayoutRtl((Context)this.getContext())) {
                    object = this.textShade;
                    object = object != null ? object.getLayoutParams() : null;
                    if ((object = object instanceof FrameLayout.LayoutParams ? (FrameLayout.LayoutParams)object : null) != null) {
                        ((FrameLayout.LayoutParams)object).gravity = 8388629;
                        timerTextEffectView = this.textShade;
                        if (timerTextEffectView != null) {
                            timerTextEffectView.setLayoutParams((ViewGroup.LayoutParams)object);
                        }
                    }
                    this.titleAnimation(0.79f, f4 - f2);
                } else {
                    object = this.textShade;
                    object = object != null ? object.getLayoutParams() : null;
                    if ((object = object instanceof FrameLayout.LayoutParams ? (FrameLayout.LayoutParams)object : null) != null) {
                        ((FrameLayout.LayoutParams)object).gravity = 8388627;
                        timerTextEffectView = this.textShade;
                        if (timerTextEffectView != null) {
                            timerTextEffectView.setLayoutParams((ViewGroup.LayoutParams)object);
                        }
                    }
                    this.titleAnimation(0.79f, 0.0f);
                }
            }
        }
        object = this.frontTitle;
        object = object != null ? object.getLayoutParams() : null;
        if (object != null) {
            ((ViewGroup.LayoutParams)object).width = n5;
        }
        object = this.content;
        object = object != null ? object.getLayoutParams() : null;
        if (object != null) {
            ((ViewGroup.LayoutParams)object).width = n6;
        }
        object = this.title;
        object = object != null ? object.getLayoutParams() : null;
        if (object != null) {
            ((ViewGroup.LayoutParams)object).width = n2;
        }
        object = this.frontTitle;
        if (object != null) {
            object.requestLayout();
        }
        if ((object = this.content) != null) {
            object.requestLayout();
        }
        if ((object = this.title) != null) {
            object.requestLayout();
        }
        super.updateWidth(n4);
    }
}
