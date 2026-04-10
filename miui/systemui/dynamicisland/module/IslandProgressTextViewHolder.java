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
import com.android.systemui.plugins.miui.dynamicisland.DynamicIslandData;
import kotlin.jvm.internal.o;
import miui.systemui.dynamicisland.DynamicIslandUtils;
import miui.systemui.dynamicisland.R;
import miui.systemui.dynamicisland.model.BigIslandArea;
import miui.systemui.dynamicisland.model.IslandTemplate;
import miui.systemui.dynamicisland.model.ProgressInfo;
import miui.systemui.dynamicisland.model.ProgressTextInfo;
import miui.systemui.dynamicisland.model.TextInfo;
import miui.systemui.dynamicisland.module.BaseIslandModuleViewHolder;
import miui.systemui.dynamicisland.module.IslandProgressTextViewHolder;
import miui.systemui.dynamicisland.module.IslandProgressViewHolder;
import miui.systemui.dynamicisland.module.IslandRightTextViewHolder;

public final class IslandProgressTextViewHolder
extends BaseIslandModuleViewHolder {
    private final IslandProgressViewHolder progressViewHolder;
    private final IslandRightTextViewHolder textViewHolder;

    public IslandProgressTextViewHolder(Context context, ViewGroup viewGroup, U0.o o2, IslandProgressViewHolder.Factory factory, IslandRightTextViewHolder.Factory factory2) {
        o.g((Object)context, (String)"context");
        o.g((Object)viewGroup, (String)"rootView");
        o.g((Object)o2, (String)"emitEvent");
        o.g((Object)factory, (String)"progressViewHolderFactory");
        o.g((Object)factory2, (String)"rightTextViewHolder");
        super(context, viewGroup, o2);
        this.progressViewHolder = factory.create(viewGroup, o2);
        this.textViewHolder = factory2.create(viewGroup, o2);
    }

    @Override
    public void bind(IslandTemplate islandTemplate, DynamicIslandData dynamicIslandData) {
        o.g((Object)islandTemplate, (String)"template");
        super.bind(islandTemplate, dynamicIslandData);
        BaseIslandModuleViewHolder baseIslandModuleViewHolder = this.textViewHolder;
        Object object = islandTemplate.getBigIslandArea();
        Object var4_5 = null;
        object = object != null && (object = ((BigIslandArea)object).getProgressTextInfo()) != null ? ((ProgressTextInfo)object).getTextInfo() : null;
        ((IslandRightTextViewHolder)baseIslandModuleViewHolder).setTextInfo((TextInfo)object);
        this.textViewHolder.updatePartial(islandTemplate, dynamicIslandData);
        baseIslandModuleViewHolder = this.progressViewHolder;
        Object object2 = islandTemplate.getBigIslandArea();
        object = var4_5;
        if (object2 != null) {
            object2 = ((BigIslandArea)object2).getProgressTextInfo();
            object = var4_5;
            if (object2 != null) {
                object = ((ProgressTextInfo)object2).getProgressInfo();
            }
        }
        ((IslandProgressViewHolder)baseIslandModuleViewHolder).setProgressInfo((ProgressInfo)object);
        this.progressViewHolder.setStrokeWidth(DynamicIslandUtils.INSTANCE.dpToPx(2, this.getContext()));
        this.progressViewHolder.updatePartial(islandTemplate, dynamicIslandData);
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
                                            final IslandProgressTextViewHolder this$0;
                                            {
                                                this.this$0 = islandProgressTextViewHolder;
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
                            var2_2 = (IslandProgressTextViewHolder)var7_4.L$0;
                            k.b((Object)var9_6);
                            break block10;
                        }
                        var6_8 = (String)var7_4.L$2;
                        var3_3 /* !! */  = (View)var7_4.L$1;
                        var5_9 = (IslandProgressTextViewHolder)var7_4.L$0;
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
                var1_1 = var5_9.progressViewHolder;
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
        this.progressViewHolder.initView(string);
        this.textViewHolder.initView(string);
    }

    @Override
    public void updatePartial(IslandTemplate islandTemplate, DynamicIslandData dynamicIslandData) {
        o.g((Object)islandTemplate, (String)"template");
        super.updatePartial(islandTemplate, dynamicIslandData);
        this.bind(islandTemplate, dynamicIslandData);
    }

    @Override
    public void updateWidth(int n) {
        int n2 = DynamicIslandUtils.INSTANCE.isDynamicIslandPadNoPropOnce(this.getDynamicIslandData()) ? this.getContext().getResources().getDimensionPixelSize(R.dimen.progress_size_pad) : this.getContext().getResources().getDimensionPixelSize(R.dimen.progress_size);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("updateWidth: ");
        stringBuilder.append(n);
        stringBuilder.append(" ");
        stringBuilder.append(n2);
        Log.d((String)"IslandProgressTextViewHolder", (String)stringBuilder.toString());
        this.textViewHolder.updateWidth(n - n2);
    }
}
