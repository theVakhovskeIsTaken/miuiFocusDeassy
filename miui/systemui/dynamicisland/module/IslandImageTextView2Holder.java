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
 *  android.view.View
 *  android.view.ViewGroup
 *  android.view.ViewGroup$LayoutParams
 *  android.widget.FrameLayout$LayoutParams
 *  com.android.systemui.plugins.miui.dynamicisland.DynamicIslandData
 *  kotlin.jvm.internal.o
 */
package miui.systemui.dynamicisland.module;

import G0.k;
import G0.s;
import K0.d;
import L0.c;
import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.android.systemui.plugins.miui.dynamicisland.DynamicIslandData;
import kotlin.jvm.internal.o;
import miui.systemui.dynamicisland.R;
import miui.systemui.dynamicisland.model.BigIslandArea;
import miui.systemui.dynamicisland.model.ImageTextInfo;
import miui.systemui.dynamicisland.model.IslandTemplate;
import miui.systemui.dynamicisland.model.PicInfo;
import miui.systemui.dynamicisland.model.TextInfo;
import miui.systemui.dynamicisland.module.BaseIslandModuleViewHolder;
import miui.systemui.dynamicisland.module.IslandIconViewHolder;
import miui.systemui.dynamicisland.module.IslandImageTextView2Holder;
import miui.systemui.dynamicisland.module.IslandRightTextViewHolder;

public final class IslandImageTextView2Holder
extends BaseIslandModuleViewHolder {
    public static final Companion Companion = new Object(null){
        {
            this();
        }
    };
    private static final String TAG = "IslandImageTextViewHolder2";
    private final IslandIconViewHolder iconViewHolder;
    private final IslandRightTextViewHolder textViewHolder;

    public IslandImageTextView2Holder(Context context, ViewGroup viewGroup, U0.o o2, IslandIconViewHolder.Factory factory, IslandRightTextViewHolder.Factory factory2) {
        o.g((Object)context, (String)"context");
        o.g((Object)viewGroup, (String)"rootView");
        o.g((Object)o2, (String)"emitEvent");
        o.g((Object)factory, (String)"iconViewHolderFactory");
        o.g((Object)factory2, (String)"rightTextViewHolderFactory");
        super(context, viewGroup, o2);
        this.iconViewHolder = factory.create(viewGroup, o2);
        this.textViewHolder = factory2.create(viewGroup, o2);
    }

    @Override
    public void bind(IslandTemplate islandTemplate, DynamicIslandData dynamicIslandData) {
        IslandIconViewHolder islandIconViewHolder;
        Object var5_6;
        Object var6_5;
        Object object;
        block12: {
            block10: {
                block11: {
                    o.g((Object)islandTemplate, (String)"template");
                    Object object2 = this.textViewHolder;
                    object = islandTemplate.getBigIslandArea();
                    var6_5 = null;
                    var5_6 = null;
                    object = object != null && (object = ((BigIslandArea)object).getImageTextInfoRight()) != null ? ((ImageTextInfo)object).getTextInfo() : null;
                    ((IslandRightTextViewHolder)object2).setTextInfo((TextInfo)object);
                    this.textViewHolder.updatePartial(islandTemplate, dynamicIslandData);
                    islandIconViewHolder = this.iconViewHolder;
                    if (!o.c((Object)this.getModule(), (Object)"moduleImageText_1")) break block10;
                    object = islandTemplate.getBigIslandArea();
                    if (object == null || (object = ((BigIslandArea)object).getImageTextInfoLeft()) == null) break block11;
                    object = object2 = ((ImageTextInfo)object).getPicInfo();
                    if (object2 != null) break block12;
                }
                object = new PicInfo();
                break block12;
            }
            object = islandTemplate.getBigIslandArea();
            object = object != null && (object = ((BigIslandArea)object).getImageTextInfoRight()) != null ? ((ImageTextInfo)object).getPicInfo() : null;
        }
        islandIconViewHolder.setPicInfo((PicInfo)object);
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
            ((StringBuilder)object).append("marginEnd:");
            ((StringBuilder)object).append(n);
            Log.d((String)TAG, (String)((StringBuilder)object).toString());
            dynamicIslandData.setMarginEnd(n);
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
            dynamicIslandData.setMarginEnd(0);
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
                                            final IslandImageTextView2Holder this$0;
                                            {
                                                this.this$0 = islandImageTextView2Holder;
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
                                    k.b((Object)var9_6);
                                    break block9;
                                }
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            var1_1 = (String)var7_4.L$2;
                            var3_3 /* !! */  = (View)var7_4.L$1;
                            var2_2 = (IslandImageTextView2Holder)var7_4.L$0;
                            k.b((Object)var9_6);
                            break block10;
                        }
                        var6_8 = (String)var7_4.L$2;
                        var3_3 /* !! */  = (View)var7_4.L$1;
                        var5_9 = (IslandImageTextView2Holder)var7_4.L$0;
                        k.b((Object)var9_6);
                        break block11;
                    }
                    k.b((Object)var9_6);
                    var7_4.L$0 = this;
                    var7_4.L$1 = var1_1;
                    var7_4.L$2 = var2_2;
                    var7_4.label = 1;
                    var5_9 = this;
                    var3_3 /* !! */  = var1_1;
                    var6_8 = var2_2;
                    if (super.initLayout((View)var1_1, (String)var2_2, (d)var7_4) == var8_7) {
                        return var8_7;
                    }
                }
                var1_1 = var5_9.iconViewHolder;
                var7_4.L$0 = var5_9;
                var7_4.L$1 = var3_3 /* !! */ ;
                var7_4.L$2 = var6_8;
                var7_4.label = 2;
                if (var1_1.initLayout((View)var3_3 /* !! */ , (String)var6_8, (d)var7_4) == var8_7) {
                    return var8_7;
                }
                var2_2 = var5_9;
                var1_1 = var6_8;
            }
            var2_2 = var2_2.textViewHolder;
            var7_4.L$0 = null;
            var7_4.L$1 = null;
            var7_4.L$2 = null;
            var7_4.label = 3;
            if (var2_2.initLayout((View)var3_3 /* !! */ , (String)var1_1, (d)var7_4) == var8_7) {
                return var8_7;
            }
        }
        return s.a;
    }

    @Override
    public void initView(String string) {
        o.g((Object)string, (String)"module");
        super.initView(string);
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

    @Override
    public void updatePartial(IslandTemplate islandTemplate, DynamicIslandData dynamicIslandData) {
        o.g((Object)islandTemplate, (String)"template");
        super.updatePartial(islandTemplate, dynamicIslandData);
        this.bind(islandTemplate, dynamicIslandData);
    }

    @Override
    public void updateWidth(int n) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("updateWidth: ");
        stringBuilder.append(n);
        Log.d((String)TAG, (String)stringBuilder.toString());
        this.textViewHolder.updateWidth(n - this.iconViewHolder.getWidth());
    }
}
