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
import miui.systemui.dynamicisland.model.IslandTemplate;
import miui.systemui.dynamicisland.model.PicInfo;
import miui.systemui.dynamicisland.model.TextInfo;
import miui.systemui.dynamicisland.module.BaseIslandModuleViewHolder;
import miui.systemui.dynamicisland.module.IslandIconViewHolder;
import miui.systemui.dynamicisland.module.IslandImageTextViewHolder;
import miui.systemui.dynamicisland.module.IslandTextViewHolder;

public final class IslandImageTextViewHolder
extends BaseIslandModuleViewHolder {
    public static final Companion Companion = new Object(null){
        {
            this();
        }
    };
    private static final String TAG = "IslandImageTextViewHolder";
    private final IslandIconViewHolder iconViewHolder;
    private final IslandTextViewHolder textViewHolder;

    public IslandImageTextViewHolder(Context context, ViewGroup viewGroup, U0.o o2, IslandIconViewHolder.Factory factory, IslandTextViewHolder.Factory factory2) {
        o.g((Object)context, (String)"context");
        o.g((Object)viewGroup, (String)"rootView");
        o.g((Object)o2, (String)"emitEvent");
        o.g((Object)factory, (String)"iconViewHolderFactory");
        o.g((Object)factory2, (String)"textViewHolderFactory");
        super(context, viewGroup, o2);
        this.iconViewHolder = factory.create(viewGroup, o2);
        this.textViewHolder = factory2.create(viewGroup, o2);
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    @Override
    public void bind(IslandTemplate var1_1, DynamicIslandData var2_2) {
        block11: {
            o.g((Object)var1_1, (String)"template");
            var7_3 = this.textViewHolder;
            var4_4 = var1_1.getBigIslandArea();
            var6_5 = null;
            var5_6 = null;
            var4_4 = var4_4 != null && (var4_4 = var4_4.getImageTextInfoLeft()) != null ? var4_4.getTextInfo() : null;
            var7_3.setTextInfo((TextInfo)var4_4);
            this.textViewHolder.updatePartial(var1_1, var2_2);
            var7_3 = this.iconViewHolder;
            if (!o.c((Object)this.getModule(), (Object)"moduleImageText_1")) ** GOTO lbl18
            var4_4 = var1_1.getBigIslandArea();
            if (var4_4 != null && (var4_4 = var4_4.getImageTextInfoLeft()) != null) {
                var4_4 = var4_4.getPicInfo();
            } else {
                while (true) {
                    var4_4 = null;
                    break block11;
                    break;
                }
lbl18:
                // 1 sources

                if ((var4_4 = var1_1.getBigIslandArea()) == null || (var4_4 = var4_4.getImageTextInfoRight()) == null) ** continue;
                var4_4 = var4_4.getPicInfo();
            }
        }
        var7_3.setPicInfo((PicInfo)var4_4);
        this.iconViewHolder.updatePartial(var1_1, var2_2);
        if (this.iconViewHolder.getPicInfo() != null) {
            var1_1 = this.getView();
            var1_1 = var1_1 != null ? var1_1.findViewById(R.id.island_container_module_text) : null;
            if (var1_1 == null) {
                return;
            }
            var4_4 = var1_1.getLayoutParams();
            var2_2 = var5_6;
            if (var4_4 instanceof FrameLayout.LayoutParams) {
                var2_2 = (FrameLayout.LayoutParams)var4_4;
            }
            if (var2_2 == null) {
                return;
            }
            var3_7 = this.iconViewHolder.getWidth();
            var4_4 = new StringBuilder();
            var4_4.append("marginStart:");
            var4_4.append(var3_7);
            Log.d((String)"IslandImageTextViewHolder", (String)var4_4.toString());
            var2_2.setMarginStart(var3_7);
            var1_1.setLayoutParams((ViewGroup.LayoutParams)var2_2);
        } else {
            var1_1 = this.getView();
            var1_1 = var1_1 != null ? var1_1.findViewById(R.id.island_container_module_text) : null;
            if (var1_1 == null) {
                return;
            }
            var4_4 = var1_1.getLayoutParams();
            var2_2 = var6_5;
            if (var4_4 instanceof FrameLayout.LayoutParams) {
                var2_2 = (FrameLayout.LayoutParams)var4_4;
            }
            if (var2_2 == null) {
                return;
            }
            var2_2.setMarginStart(0);
            var1_1.setLayoutParams((ViewGroup.LayoutParams)var2_2);
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
                                            final IslandImageTextViewHolder this$0;
                                            {
                                                this.this$0 = islandImageTextViewHolder;
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
                            var2_2 = (IslandImageTextViewHolder)var7_4.L$0;
                            k.b((Object)var9_6);
                            break block10;
                        }
                        var6_8 = (String)var7_4.L$2;
                        var3_3 /* !! */  = (View)var7_4.L$1;
                        var5_9 = (IslandImageTextViewHolder)var7_4.L$0;
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
