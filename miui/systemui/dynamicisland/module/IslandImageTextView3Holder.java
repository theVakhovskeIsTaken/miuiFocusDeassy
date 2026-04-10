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
 *  android.widget.FrameLayout
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
import android.widget.FrameLayout;
import android.widget.TextView;
import com.android.systemui.plugins.miui.dynamicisland.DynamicIslandData;
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
import miui.systemui.dynamicisland.module.IslandIconViewHolder;
import miui.systemui.dynamicisland.module.IslandImageTextView3Holder;
import miui.systemui.dynamicisland.module.IslandRightTextViewHolder;
import miui.systemui.dynamicisland.module.g;
import miui.systemui.util.CommonUtils;
import miuix.animation.FolmeObject;
import miuix.animation.base.AnimConfig;
import miuix.animation.controller.AnimState;
import miuix.animation.listener.TransitionListener;
import miuix.animation.listener.UpdateInfo;
import miuix.animation.property.FloatProperty;
import miuix.colorful.texteffect.TimerTextEffectView;

public final class IslandImageTextView3Holder
extends BaseIslandModuleViewHolder {
    public static final Companion Companion = new Object(null){
        {
            this();
        }
    };
    private static final ICON_TRANS_X.1 ICON_TRANS_X = new FloatProperty<IslandImageTextView3Holder>(){

        public float getValue(IslandImageTextView3Holder islandImageTextView3Holder) {
            o.g((Object)islandImageTextView3Holder, (String)"holder");
            return IslandImageTextView3Holder.access$getIconTransX$p(islandImageTextView3Holder);
        }

        public void setValue(IslandImageTextView3Holder islandImageTextView3Holder, float f2) {
            o.g((Object)islandImageTextView3Holder, (String)"holder");
            if (Float.isNaN(f2)) {
                return;
            }
            IslandImageTextView3Holder.access$setIconTransX$p(islandImageTextView3Holder, f2);
        }
    };
    private static final String TAG = "IslandImageTextView3Holder";
    private Choreographer choreographer;
    private final Choreographer.FrameCallback frameCallback;
    private FrameLayout iconLayout;
    private float iconTransX;
    private final IslandIconViewHolder iconViewHolder;
    private String text;
    private final IslandRightTextViewHolder textViewHolder;
    private TimerTextEffectView titleView;
    private boolean updateScheduled;

    public IslandImageTextView3Holder(Context context, ViewGroup viewGroup, U0.o o2, IslandIconViewHolder.Factory factory, IslandRightTextViewHolder.Factory factory2) {
        o.g((Object)context, (String)"context");
        o.g((Object)viewGroup, (String)"rootView");
        o.g((Object)o2, (String)"emitEvent");
        o.g((Object)factory, (String)"iconViewHolderFactory");
        o.g((Object)factory2, (String)"rightTextViewHolderFactory");
        super(context, viewGroup, o2);
        this.iconViewHolder = factory.create(viewGroup, o2);
        this.textViewHolder = factory2.create(viewGroup, o2);
        this.frameCallback = new g(this);
    }

    public static /* synthetic */ void a(IslandImageTextView3Holder islandImageTextView3Holder, long l) {
        IslandImageTextView3Holder.frameCallback$lambda$0(islandImageTextView3Holder, l);
    }

    public static final /* synthetic */ float access$getIconTransX$p(IslandImageTextView3Holder islandImageTextView3Holder) {
        return islandImageTextView3Holder.iconTransX;
    }

    public static final /* synthetic */ void access$setIconTransX$p(IslandImageTextView3Holder islandImageTextView3Holder, float f) {
        islandImageTextView3Holder.iconTransX = f;
    }

    private static final void frameCallback$lambda$0(IslandImageTextView3Holder islandImageTextView3Holder, long l) {
        o.g((Object)islandImageTextView3Holder, (String)"this$0");
        islandImageTextView3Holder.updateScheduled = false;
        islandImageTextView3Holder.iconScheduleUpdate();
    }

    private final void iconAnimation(float f) {
        FolmeKt.getFolme((FolmeObject)this).to((Object)new AnimState().add((FloatProperty)ICON_TRANS_X, f, new long[0]), new AnimConfig[]{new AnimConfig().addListeners(new TransitionListener[]{new TransitionListener(this){
            final IslandImageTextView3Holder this$0;
            {
                this.this$0 = islandImageTextView3Holder;
            }

            public void onUpdate(Object object, Collection<UpdateInfo> collection) {
                this.this$0.scheduleUpdate();
            }
        }})});
    }

    private final void iconScheduleUpdate() {
        FrameLayout frameLayout = this.iconLayout;
        if (frameLayout != null) {
            frameLayout.setTranslationX(this.iconTransX);
        }
    }

    @Override
    public void bind(IslandTemplate islandTemplate, DynamicIslandData dynamicIslandData) {
        o.g((Object)islandTemplate, (String)"template");
        super.bind(islandTemplate, dynamicIslandData);
        BaseIslandModuleViewHolder baseIslandModuleViewHolder = this.textViewHolder;
        Object object = islandTemplate.getBigIslandArea();
        Object var6_5 = null;
        Object var5_6 = null;
        object = object != null && (object = ((BigIslandArea)object).getImageTextInfoRight()) != null ? ((ImageTextInfo)object).getTextInfo() : null;
        ((IslandRightTextViewHolder)baseIslandModuleViewHolder).setTextInfo((TextInfo)object);
        this.textViewHolder.updatePartial(islandTemplate, dynamicIslandData);
        object = islandTemplate.getBigIslandArea();
        object = object != null && (object = ((BigIslandArea)object).getImageTextInfoRight()) != null && (object = ((ImageTextInfo)object).getTextInfo()) != null ? ((TextInfo)object).getTitle() : null;
        this.text = object;
        object = this.getView();
        object = object != null ? (TimerTextEffectView)object.findViewById(R.id.island_title) : null;
        this.titleView = object;
        baseIslandModuleViewHolder = this.iconViewHolder;
        object = islandTemplate.getBigIslandArea();
        object = object != null && (object = ((BigIslandArea)object).getImageTextInfoRight()) != null ? ((ImageTextInfo)object).getPicInfo() : null;
        ((IslandIconViewHolder)baseIslandModuleViewHolder).setPicInfo((PicInfo)object);
        this.iconViewHolder.updatePartial(islandTemplate, dynamicIslandData);
        if (this.iconViewHolder.getPicInfo() != null) {
            islandTemplate = this.getView();
            islandTemplate = islandTemplate != null ? islandTemplate.findViewById(R.id.island_container_module_text) : null;
            if (islandTemplate == null) {
                return;
            }
            object = islandTemplate.getLayoutParams();
            dynamicIslandData = var5_6;
            if (object instanceof FrameLayout.LayoutParams) {
                dynamicIslandData = (FrameLayout.LayoutParams)object;
            }
            if (dynamicIslandData == null) {
                return;
            }
            int n = this.iconViewHolder.getWidth();
            object = new StringBuilder();
            ((StringBuilder)object).append("marginStart:");
            ((StringBuilder)object).append(n);
            Log.d((String)TAG, (String)((StringBuilder)object).toString());
            dynamicIslandData.setMarginStart(n);
            islandTemplate.setLayoutParams((ViewGroup.LayoutParams)dynamicIslandData);
        } else {
            islandTemplate = this.getView();
            islandTemplate = islandTemplate != null ? islandTemplate.findViewById(R.id.island_container_module_text) : null;
            if (islandTemplate == null) {
                return;
            }
            object = islandTemplate.getLayoutParams();
            dynamicIslandData = var6_5;
            if (object instanceof FrameLayout.LayoutParams) {
                dynamicIslandData = (FrameLayout.LayoutParams)object;
            }
            if (dynamicIslandData == null) {
                return;
            }
            dynamicIslandData.setMarginStart(0);
            islandTemplate.setLayoutParams((ViewGroup.LayoutParams)dynamicIslandData);
        }
    }

    @Override
    public void diff(IslandTemplate islandTemplate, DynamicIslandData dynamicIslandData) {
        o.g((Object)islandTemplate, (String)"template");
        super.diff(islandTemplate, dynamicIslandData);
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    @Override
    public Object initLayout(View var1_1, String var2_2, d var3_3) {
        block9: {
            block10: {
                block11: {
                    block5: {
                        block6: {
                            block7: {
                                block8: {
                                    if (!(var3_3 /* !! */  instanceof initLayout.1)) ** GOTO lbl-1000
                                    var7_4 = var3_3 /* !! */ ;
                                    var4_5 = var7_4.label;
                                    if ((var4_5 & -2147483648) != 0) {
                                        var7_4.label = var4_5 + -2147483648;
                                    } else lbl-1000:
                                    // 2 sources

                                    {
                                        var7_4 = new M0.d(this, var3_3 /* !! */ ){
                                            Object L$0;
                                            Object L$1;
                                            Object L$2;
                                            int label;
                                            Object result;
                                            final IslandImageTextView3Holder this$0;
                                            {
                                                this.this$0 = islandImageTextView3Holder;
                                                super(d2);
                                            }

                                            public final Object invokeSuspend(Object object) {
                                                this.result = object;
                                                this.label |= Integer.MIN_VALUE;
                                                return this.this$0.initLayout(null, null, (d)this);
                                            }
                                        };
                                    }
                                    var9_6 = var7_4.result;
                                    var8_7 = c.c();
                                    var4_5 = var7_4.label;
                                    if (var4_5 == 0) break block5;
                                    if (var4_5 == 1) break block6;
                                    if (var4_5 == 2) break block7;
                                    if (var4_5 != 3) break block8;
                                    var5_8 = (View)var7_4.L$1;
                                    var2_2 = (IslandImageTextView3Holder)var7_4.L$0;
                                    k.b((Object)var9_6);
                                    break block9;
                                }
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            var3_3 /* !! */  = (String)var7_4.L$2;
                            var1_1 = (View)var7_4.L$1;
                            var2_2 = (IslandImageTextView3Holder)var7_4.L$0;
                            k.b((Object)var9_6);
                            break block10;
                        }
                        var3_3 /* !! */  = (String)var7_4.L$2;
                        var5_8 = (View)var7_4.L$1;
                        var6_9 = (IslandImageTextView3Holder)var7_4.L$0;
                        k.b((Object)var9_6);
                        break block11;
                    }
                    k.b((Object)var9_6);
                    var7_4.L$0 = this;
                    var7_4.L$1 = var1_1;
                    var7_4.L$2 = var2_2;
                    var7_4.label = 1;
                    var6_9 = this;
                    var5_8 = var1_1;
                    var3_3 /* !! */  = var2_2;
                    if (super.initLayout((View)var1_1, (String)var2_2, (d)var7_4) == var8_7) {
                        return var8_7;
                    }
                }
                var1_1 = var6_9.iconViewHolder;
                var7_4.L$0 = var6_9;
                var7_4.L$1 = var5_8;
                var7_4.L$2 = var3_3 /* !! */ ;
                var7_4.label = 2;
                if (var1_1.initLayout(var5_8, (String)var3_3 /* !! */ , (d)var7_4) == var8_7) {
                    return var8_7;
                }
                var2_2 = var6_9;
                var1_1 = var5_8;
            }
            var6_9 = var2_2.textViewHolder;
            var7_4.L$0 = var2_2;
            var7_4.L$1 = var1_1;
            var7_4.L$2 = null;
            var7_4.label = 3;
            var5_8 = var1_1;
            if (var6_9.initLayout((View)var1_1, (String)var3_3 /* !! */ , (d)var7_4) == var8_7) {
                return var8_7;
            }
        }
        var2_2.iconLayout = (FrameLayout)var5_8.findViewById(R.id.island_container_module_icon);
        return s.a;
    }

    @Override
    public void initView(String string) {
        o.g((Object)string, (String)"module");
        super.initView(string);
        this.choreographer = Choreographer.getInstance();
        this.iconViewHolder.initView(string);
        this.textViewHolder.initView(string);
    }

    @Override
    public void onDetach() {
        super.onDetach();
        this.iconViewHolder.onDetach();
    }

    @Override
    public void onHidden() {
        super.onHidden();
        this.iconViewHolder.onHidden();
    }

    @Override
    public void onShow() {
        super.onShow();
        this.iconViewHolder.onShow();
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
    public void updatePartial(IslandTemplate islandTemplate, DynamicIslandData dynamicIslandData) {
        o.g((Object)islandTemplate, (String)"template");
        super.updatePartial(islandTemplate, dynamicIslandData);
        this.bind(islandTemplate, dynamicIslandData);
    }

    @Override
    public void updateWidth(int n) {
        Object object = new StringBuilder();
        ((StringBuilder)object).append("originWidth:");
        ((StringBuilder)object).append(n);
        Log.d((String)TAG, (String)((StringBuilder)object).toString());
        int n2 = DynamicIslandUtils.INSTANCE.isDynamicIslandPadNoPropOnce(this.getDynamicIslandData()) ? this.getContext().getResources().getDimensionPixelSize(R.dimen.text_padding_pad) : this.getContext().getResources().getDimensionPixelSize(R.dimen.text_padding);
        int n3 = this.getContext().getResources().getDimensionPixelSize(R.dimen.island_area_padding_cutout);
        int n4 = this.iconViewHolder.getWidth();
        int n5 = this.getContext().getResources().getDimensionPixelSize(R.dimen.island_area_padding);
        int n6 = this.getTextViewWidth((TextView)this.titleView, this.text);
        int n7 = n - n3 - n4;
        n3 = n7 - n2 - n5;
        float f2 = n3;
        float f3 = (float)n6 * 0.79f;
        if (f2 >= f3 && n3 < n6) {
            f3 = !CommonUtils.isLayoutRtl((Context)this.getContext()) ? (float)n7 - f3 - (float)n5 - (float)n2 : -((float)n7 - f3 - (float)n5 - (float)n2);
            object = new StringBuilder();
            ((StringBuilder)object).append("iconTranX:");
            ((StringBuilder)object).append(f3);
            Log.d((String)TAG, (String)((StringBuilder)object).toString());
            this.iconAnimation(f3);
        } else {
            this.iconAnimation(0.0f);
        }
        n2 = this.iconViewHolder.getWidth();
        object = new StringBuilder();
        ((StringBuilder)object).append("iconWidth:");
        ((StringBuilder)object).append(n2);
        Log.d((String)TAG, (String)((StringBuilder)object).toString());
        object = this.textViewHolder;
        if (object != null) {
            ((IslandRightTextViewHolder)object).updateWidth(n - n4);
        }
    }
}
