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
 *  android.view.ViewGroup
 *  android.view.ViewGroup$LayoutParams
 *  android.view.ViewStub
 *  android.widget.FrameLayout$LayoutParams
 *  android.widget.TextView
 *  com.android.systemui.plugins.miui.dynamicisland.DynamicIslandData
 *  kotlin.jvm.internal.o
 *  miui.systemui.animation.FolmeKt
 *  miui.systemui.util.CommonUtils
 *  miuix.animation.Folme$ObjectFolmeImpl
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
import miui.systemui.dynamicisland.module.IslandTextViewHolder;
import miui.systemui.dynamicisland.module.j;
import miui.systemui.util.CommonUtils;
import miuix.animation.Folme;
import miuix.animation.FolmeObject;
import miuix.animation.base.AnimConfig;
import miuix.animation.controller.AnimState;
import miuix.animation.listener.TransitionListener;
import miuix.animation.listener.UpdateInfo;
import miuix.animation.property.FloatProperty;
import miuix.colorful.texteffect.TextChangeHelper;
import miuix.colorful.texteffect.TextChangeProcessor;
import miuix.colorful.texteffect.TimerTextEffectView;

public class IslandTextViewHolder
extends BaseIslandModuleViewHolder
implements FolmeObject {
    private static final CONTENT_TRANS_X.1 CONTENT_TRANS_X;
    public static final Companion Companion;
    private static final FRONT_TITLE_TRANS_X.1 FRONT_TITLE_TRANS_X;
    public static final String TAG = "IslandTextViewHolder";
    private static final TITLE_SCALE_X.1 TITLE_SCALE_X;
    private static final TITLE_SCALE_Y.1 TITLE_SCALE_Y;
    private static final TITLE_TRANS_X.1 TITLE_TRANS_X;
    private final FolmeObject $$delegate_0;
    private Choreographer choreographer;
    private TimerTextEffectView content;
    private ViewStub contentStub;
    private float contentTransX;
    private String curHighlightColor;
    private final Choreographer.FrameCallback frameCallback;
    private TimerTextEffectView frontTitle;
    private ViewStub frontTitleStub;
    private float frontTitleTransX;
    private int lastWidth;
    private Boolean narrowFont;
    private Boolean showHighlightInfo;
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
        TITLE_TRANS_X = new FloatProperty<IslandTextViewHolder>(){

            public float getValue(IslandTextViewHolder islandTextViewHolder) {
                o.g((Object)islandTextViewHolder, (String)"holder");
                return IslandTextViewHolder.access$getTitleTransX$p(islandTextViewHolder);
            }

            public void setValue(IslandTextViewHolder islandTextViewHolder, float f2) {
                o.g((Object)islandTextViewHolder, (String)"holder");
                if (Float.isNaN(f2)) {
                    return;
                }
                IslandTextViewHolder.access$setTitleTransX$p(islandTextViewHolder, f2);
            }
        };
        CONTENT_TRANS_X = new FloatProperty<IslandTextViewHolder>(){

            public float getValue(IslandTextViewHolder islandTextViewHolder) {
                o.g((Object)islandTextViewHolder, (String)"holder");
                return IslandTextViewHolder.access$getContentTransX$p(islandTextViewHolder);
            }

            public void setValue(IslandTextViewHolder islandTextViewHolder, float f2) {
                o.g((Object)islandTextViewHolder, (String)"holder");
                if (Float.isNaN(f2)) {
                    return;
                }
                IslandTextViewHolder.access$setContentTransX$p(islandTextViewHolder, f2);
            }
        };
        TITLE_SCALE_X = new FloatProperty<IslandTextViewHolder>(){

            public float getValue(IslandTextViewHolder islandTextViewHolder) {
                o.g((Object)islandTextViewHolder, (String)"holder");
                return IslandTextViewHolder.access$getTitleScaleX$p(islandTextViewHolder);
            }

            public void setValue(IslandTextViewHolder islandTextViewHolder, float f2) {
                o.g((Object)islandTextViewHolder, (String)"holder");
                if (Float.isNaN(f2)) {
                    return;
                }
                IslandTextViewHolder.access$setTitleScaleX$p(islandTextViewHolder, f2);
            }
        };
        TITLE_SCALE_Y = new FloatProperty<IslandTextViewHolder>(){

            public float getValue(IslandTextViewHolder islandTextViewHolder) {
                o.g((Object)islandTextViewHolder, (String)"holder");
                return IslandTextViewHolder.access$getTitleScaleY$p(islandTextViewHolder);
            }

            public void setValue(IslandTextViewHolder islandTextViewHolder, float f2) {
                o.g((Object)islandTextViewHolder, (String)"holder");
                if (Float.isNaN(f2)) {
                    return;
                }
                IslandTextViewHolder.access$setTitleScaleY$p(islandTextViewHolder, f2);
            }
        };
        FRONT_TITLE_TRANS_X = new FloatProperty<IslandTextViewHolder>(){

            public float getValue(IslandTextViewHolder islandTextViewHolder) {
                o.g((Object)islandTextViewHolder, (String)"holder");
                return IslandTextViewHolder.access$getFrontTitleTransX$p(islandTextViewHolder);
            }

            public void setValue(IslandTextViewHolder islandTextViewHolder, float f2) {
                o.g((Object)islandTextViewHolder, (String)"holder");
                if (Float.isNaN(f2)) {
                    return;
                }
                IslandTextViewHolder.access$setFrontTitleTransX$p(islandTextViewHolder, f2);
            }
        };
    }

    public IslandTextViewHolder(Context context, ViewGroup viewGroup, U0.o o2) {
        o.g((Object)context, (String)"context");
        o.g((Object)viewGroup, (String)"rootView");
        o.g((Object)o2, (String)"emitEvent");
        super(context, viewGroup, o2);
        this.$$delegate_0 = FolmeKt.FolmeObject();
        this.titleScaleX = 1.0f;
        this.titleScaleY = 1.0f;
        this.frameCallback = new j(this);
    }

    public static /* synthetic */ void a(IslandTextViewHolder islandTextViewHolder, long l) {
        IslandTextViewHolder.frameCallback$lambda$3(islandTextViewHolder, l);
    }

    public static final /* synthetic */ float access$getContentTransX$p(IslandTextViewHolder islandTextViewHolder) {
        return islandTextViewHolder.contentTransX;
    }

    public static final /* synthetic */ float access$getFrontTitleTransX$p(IslandTextViewHolder islandTextViewHolder) {
        return islandTextViewHolder.frontTitleTransX;
    }

    public static final /* synthetic */ float access$getTitleScaleX$p(IslandTextViewHolder islandTextViewHolder) {
        return islandTextViewHolder.titleScaleX;
    }

    public static final /* synthetic */ float access$getTitleScaleY$p(IslandTextViewHolder islandTextViewHolder) {
        return islandTextViewHolder.titleScaleY;
    }

    public static final /* synthetic */ float access$getTitleTransX$p(IslandTextViewHolder islandTextViewHolder) {
        return islandTextViewHolder.titleTransX;
    }

    public static final /* synthetic */ void access$setContentTransX$p(IslandTextViewHolder islandTextViewHolder, float f) {
        islandTextViewHolder.contentTransX = f;
    }

    public static final /* synthetic */ void access$setFrontTitleTransX$p(IslandTextViewHolder islandTextViewHolder, float f) {
        islandTextViewHolder.frontTitleTransX = f;
    }

    public static final /* synthetic */ void access$setTitleScaleX$p(IslandTextViewHolder islandTextViewHolder, float f) {
        islandTextViewHolder.titleScaleX = f;
    }

    public static final /* synthetic */ void access$setTitleScaleY$p(IslandTextViewHolder islandTextViewHolder, float f) {
        islandTextViewHolder.titleScaleY = f;
    }

    public static final /* synthetic */ void access$setTitleTransX$p(IslandTextViewHolder islandTextViewHolder, float f) {
        islandTextViewHolder.titleTransX = f;
    }

    private final void contentAnimation(float f2) {
        FolmeKt.getFolme((FolmeObject)this).to((Object)new AnimState().add((FloatProperty)CONTENT_TRANS_X, f2, new long[0]), new AnimConfig[]{new AnimConfig().addListeners(new TransitionListener[]{new TransitionListener(this){
            final IslandTextViewHolder this$0;
            {
                this.this$0 = islandTextViewHolder;
            }

            public void onUpdate(Object object, Collection<UpdateInfo> collection) {
                this.this$0.scheduleUpdate();
            }
        }})});
    }

    private static final void frameCallback$lambda$3(IslandTextViewHolder islandTextViewHolder, long l) {
        o.g((Object)islandTextViewHolder, (String)"this$0");
        islandTextViewHolder.updateScheduled = false;
        TimerTextEffectView timerTextEffectView = islandTextViewHolder.title;
        if (timerTextEffectView != null) {
            timerTextEffectView.setTranslationX(islandTextViewHolder.titleTransX);
        }
        timerTextEffectView = islandTextViewHolder.title;
        if (timerTextEffectView != null) {
            timerTextEffectView.setScaleX(islandTextViewHolder.titleScaleX);
        }
        timerTextEffectView = islandTextViewHolder.title;
        if (timerTextEffectView != null) {
            timerTextEffectView.setScaleY(islandTextViewHolder.titleScaleY);
        }
        timerTextEffectView = islandTextViewHolder.content;
        if (timerTextEffectView != null) {
            timerTextEffectView.setTranslationX(islandTextViewHolder.contentTransX);
        }
    }

    private final void frontTitleTranXAnimation(float f2) {
        FolmeKt.getFolme((FolmeObject)this).to((Object)new AnimState().add((FloatProperty)FRONT_TITLE_TRANS_X, f2, new long[0]), new AnimConfig[]{new AnimConfig().addListeners(new TransitionListener[]{new TransitionListener(this){
            final IslandTextViewHolder this$0;
            {
                this.this$0 = islandTextViewHolder;
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
    public static /* synthetic */ Object initLayout$suspendImpl(IslandTextViewHolder var0, View var1_1, String var2_2, d var3_3) {
        if (!(var3_3 /* !! */  instanceof initLayout.1)) ** GOTO lbl-1000
        var5_4 /* !! */  = var3_3 /* !! */ ;
        var4_5 = var5_4 /* !! */ .label;
        if ((var4_5 & -2147483648) != 0) {
            var5_4 /* !! */ .label = var4_5 + -2147483648;
            var3_3 /* !! */  = var5_4 /* !! */ ;
        } else lbl-1000:
        // 2 sources

        {
            var3_3 /* !! */  = new M0.d(var0, var3_3 /* !! */ ){
                Object L$0;
                Object L$1;
                int label;
                Object result;
                final IslandTextViewHolder this$0;
                {
                    this.this$0 = islandTextViewHolder;
                    super(d2);
                }

                public final Object invokeSuspend(Object object) {
                    this.result = object;
                    this.label |= Integer.MIN_VALUE;
                    return IslandTextViewHolder.initLayout$suspendImpl(this.this$0, null, null, (d)this);
                }
            };
        }
        var8_6 = var3_3 /* !! */ .result;
        var7_7 = c.c();
        var4_5 = var3_3 /* !! */ .label;
        if (var4_5 == 0) ** GOTO lbl19
        if (var4_5 == 1) {
            var6_8 = (View)var3_3 /* !! */ .L$1;
            var5_4 /* !! */  = (IslandTextViewHolder)var3_3 /* !! */ .L$0;
            k.b((Object)var8_6);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
lbl19:
            // 1 sources

            k.b((Object)var8_6);
            var3_3 /* !! */ .L$0 = var0;
            var3_3 /* !! */ .L$1 = var1_1;
            var3_3 /* !! */ .label = 1;
            var5_4 /* !! */  = var0;
            var6_8 = var1_1;
            if (super.initLayout(var1_1, var2_2, var3_3 /* !! */ ) == var7_7) {
                return var7_7;
            }
        }
        var5_4 /* !! */ .titleContainer = (ViewGroup)var6_8.findViewById(R.id.island_container_module_text);
        var5_4 /* !! */ .titleStub = (ViewStub)var6_8.findViewById(R.id.island_title_stub);
        var5_4 /* !! */ .frontTitleStub = (ViewStub)var6_8.findViewById(R.id.island_front_title_stub);
        var5_4 /* !! */ .contentStub = (ViewStub)var6_8.findViewById(R.id.island_content_stub);
        var5_4 /* !! */ .textShade = var6_8.findViewById(R.id.island_text_shade);
        return s.a;
    }

    private final void resetPosition() {
        this.frontTitleTranXAnimation(0.0f);
        this.titleAnimation(1.0f, 0.0f);
        this.contentAnimation(0.0f);
    }

    private final void scaledPositionAdjust(int n) {
        this.frontTitleTranXAnimation(0.0f);
        this.titleAnimation(0.79f, 0.0f);
        if (!CommonUtils.isLayoutRtl((Context)this.getContext())) {
            this.contentAnimation((float)n * -0.21f);
        } else {
            this.contentAnimation((float)n * 0.21f);
        }
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

    /*
     * Enabled aggressive block sorting
     */
    private final void setTitlePivot(int n) {
        float f2;
        TimerTextEffectView timerTextEffectView = this.title;
        float f3 = 0.0f;
        if (timerTextEffectView != null) {
            f2 = CommonUtils.isLayoutRtl((Context)this.getContext()) ? (float)n : 0.0f;
            timerTextEffectView.setPivotX(f2);
        }
        if (!((timerTextEffectView = this.title) == null || timerTextEffectView.getVisibility() != 0 || (timerTextEffectView = this.content) != null && timerTextEffectView.getVisibility() == 0 || (timerTextEffectView = this.frontTitle) != null && timerTextEffectView.getVisibility() == 0)) {
            timerTextEffectView = this.title;
            if (timerTextEffectView == null) {
                return;
            }
            f2 = f3;
            if (timerTextEffectView != null) {
                f2 = (float)timerTextEffectView.getMeasuredHeight() / 2.0f;
            }
            timerTextEffectView.setPivotY(f2);
            return;
        }
        timerTextEffectView = this.title;
        n = timerTextEffectView != null ? timerTextEffectView.getMeasuredHeight() : this.getContext().getResources().getDimensionPixelSize(R.dimen.island_title_height);
        f2 = n;
        timerTextEffectView = this.title;
        if (timerTextEffectView != null) {
            timerTextEffectView.setPivotY(f2 - (float)this.getContext().getResources().getDimensionPixelSize(R.dimen.island_text_content_margin_bottom));
            return;
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
            final IslandTextViewHolder this$0;
            {
                this.this$0 = islandTextViewHolder;
            }

            public void onUpdate(Object object, Collection<UpdateInfo> collection) {
                this.this$0.scheduleUpdate();
            }
        }})});
    }

    @Override
    public void bind(IslandTemplate islandTemplate, DynamicIslandData object) {
        Object object2;
        Object var9_4;
        boolean bl;
        block37: {
            block36: {
                block35: {
                    block34: {
                        o.g((Object)islandTemplate, (String)"template");
                        super.bind(islandTemplate, (DynamicIslandData)object);
                        this.curHighlightColor = islandTemplate.getHighlightColor();
                        bl = o.c((Object)this.getModule(), (Object)"moduleText");
                        var9_4 = null;
                        if (bl) {
                            object = islandTemplate.getBigIslandArea();
                            object = object != null ? ((BigIslandArea)object).getTextInfo() : null;
                            this.textInfo = object;
                        }
                        if ((object = this.textInfo) == null) break block34;
                        object = object2 = ((TextInfo)object).getNarrowFont();
                        if (object2 != null) break block35;
                    }
                    object = Boolean.FALSE;
                }
                this.narrowFont = object;
                object = this.textInfo;
                if (object == null) break block36;
                object = object2 = ((TextInfo)object).getShowHighlightColor();
                if (object2 != null) break block37;
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
        object = this.titleContainer;
        boolean bl2 = false;
        if (object != null) {
            int n = object3 == null ? 8 : 0;
            object.setVisibility(n);
        }
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
            if ((object4 = this.content) != null) {
                object = this.textInfo;
                bl = bl2;
                if (object != null) {
                    bl = o.c((Object)((TextInfo)object).getTurnAnim(), (Object)Boolean.TRUE);
                }
                object4.enableEffect(bl);
            }
            object4 = this.textInfo;
            object = var9_4;
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

    @Override
    public void diff(IslandTemplate islandTemplate, DynamicIslandData dynamicIslandData) {
        o.g((Object)islandTemplate, (String)"template");
        super.diff(islandTemplate, dynamicIslandData);
    }

    @Override
    public Folme.ObjectFolmeImpl folme() {
        return this.$$delegate_0.folme();
    }

    public final int getLastWidth() {
        return this.lastWidth;
    }

    public final TextInfo getTextInfo() {
        return this.textInfo;
    }

    @Override
    public Object initLayout(View view, String string, d d2) {
        return IslandTextViewHolder.initLayout$suspendImpl(this, view, string, d2);
    }

    @Override
    public void initView(String string) {
        o.g((Object)string, (String)"module");
        super.initView(string);
        string = this.titleContainer;
        if (string != null) {
            FolmeKt.cleanWhenViewDetached((FolmeObject)this, (View)string);
        }
        this.choreographer = Choreographer.getInstance();
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

    @Override
    public void setFolmeImpl(Folme.ObjectFolmeImpl objectFolmeImpl) {
        this.$$delegate_0.setFolmeImpl(objectFolmeImpl);
    }

    public final void setLastWidth(int n) {
        this.lastWidth = n;
    }

    public final void setTextInfo(TextInfo textInfo) {
        this.textInfo = textInfo;
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
        if (!this.textChanged(islandTemplate)) {
            return;
        }
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
        Object object = new StringBuilder();
        ((StringBuilder)object).append("updateWidth: ");
        ((StringBuilder)object).append(n4);
        Log.d((String)TAG, (String)((StringBuilder)object).toString());
        TimerTextEffectView timerTextEffectView = this.frontTitle;
        object = this.textInfo;
        object = object != null ? ((TextInfo)object).getFrontTitle() : null;
        int n5 = this.getTextViewWidth((TextView)timerTextEffectView, (String)object);
        timerTextEffectView = this.title;
        object = this.textInfo;
        object = object != null ? ((TextInfo)object).getTitle() : null;
        int n6 = this.getTextViewWidth((TextView)timerTextEffectView, (String)object);
        timerTextEffectView = this.content;
        object = this.textInfo;
        object = object != null ? ((TextInfo)object).getContent() : null;
        int n7 = this.getTextViewWidth((TextView)timerTextEffectView, (String)object);
        n3 = this.getContext().getResources().getDimensionPixelSize(R.dimen.island_text_padding_inner);
        n2 = n5 + n6;
        int n8 = n2 + n7;
        int n9 = this.getSpaceWidth(n5, n7, n3);
        object = new StringBuilder();
        ((StringBuilder)object).append("originWidth:");
        ((StringBuilder)object).append(n);
        ((StringBuilder)object).append(", updateWidth: ");
        ((StringBuilder)object).append(n4);
        ((StringBuilder)object).append(", totalTextWidth: ");
        ((StringBuilder)object).append(n9 + n8);
        Log.d((String)TAG, (String)((StringBuilder)object).toString());
        if (n4 >= n8 + this.getSpaceWidth(n5, n7, n3)) {
            Log.d((String)TAG, (String)"case1");
            this.setTextVisibility(true, true, true, false);
            this.setTitlePivot(n6);
            this.resetPosition();
        } else {
            float f2 = n4;
            float f3 = n5;
            float f4 = (float)n6 * 0.79f;
            if (f2 >= (float)n7 + (f3 += f4) + (float)this.getSpaceWidth(n5, n7, n3)) {
                Log.d((String)TAG, (String)"case2");
                this.setTextVisibility(true, true, true, false);
                this.setTitlePivot(n6);
                this.scaledPositionAdjust(n6);
            } else if (n4 >= n2 + this.getSpaceWidth(n5, n7, n3)) {
                Log.d((String)TAG, (String)"case3");
                this.setTextVisibility(true, true, false, false);
                this.setTitlePivot(n6);
                this.resetPosition();
            } else if (f2 >= f3 + (float)this.getSpaceWidth(n5, n7, n3)) {
                Log.d((String)TAG, (String)"case4");
                this.setTextVisibility(true, true, false, false);
                this.setTitlePivot(n6);
                this.scaledPositionAdjust(n6);
            } else if (n4 >= n6) {
                Log.d((String)TAG, (String)"case5");
                this.setTextVisibility(false, true, false, false);
                this.setTitlePivot(n6);
                this.resetPosition();
            } else if (f2 >= f4) {
                Log.d((String)TAG, (String)"case6");
                this.setTextVisibility(false, true, false, false);
                this.setTitlePivot(n6);
                this.scaledPositionAdjust(n6);
            } else {
                Log.d((String)TAG, (String)"case7");
                this.setTextVisibility(false, true, false, true);
                this.setTitlePivot(n6);
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
                    this.titleAnimation(0.79f, 0.0f);
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
                    this.titleAnimation(0.79f, f4 - f2);
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
            ((ViewGroup.LayoutParams)object).width = n7;
        }
        object = this.title;
        object = object != null ? object.getLayoutParams() : null;
        if (object != null) {
            ((ViewGroup.LayoutParams)object).width = n6;
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
