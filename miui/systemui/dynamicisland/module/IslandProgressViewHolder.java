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
 *  android.view.View
 *  android.view.ViewGroup
 *  com.android.systemui.plugins.miui.dynamicisland.DynamicIslandData
 *  kotlin.jvm.internal.o
 *  miui.systemui.widget.CircularProgressBar
 */
package miui.systemui.dynamicisland.module;

import G0.k;
import G0.s;
import K0.d;
import L0.c;
import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import com.android.systemui.plugins.miui.dynamicisland.DynamicIslandData;
import kotlin.jvm.internal.o;
import miui.systemui.dynamicisland.R;
import miui.systemui.dynamicisland.model.IslandTemplate;
import miui.systemui.dynamicisland.model.ProgressInfo;
import miui.systemui.dynamicisland.module.BaseIslandModuleViewHolder;
import miui.systemui.dynamicisland.module.IslandProgressViewHolder;
import miui.systemui.widget.CircularProgressBar;

public final class IslandProgressViewHolder
extends BaseIslandModuleViewHolder {
    private final String defaultReachColor;
    private final String defaultUnReachColor;
    private CircularProgressBar progress;
    private ProgressInfo progressInfo;
    private int strokeWidth;

    public IslandProgressViewHolder(Context context, ViewGroup viewGroup, U0.o o2) {
        o.g((Object)context, (String)"context");
        o.g((Object)viewGroup, (String)"rootView");
        o.g((Object)o2, (String)"emitEvent");
        super(context, viewGroup, o2);
        this.defaultReachColor = "#4788FF";
        this.defaultUnReachColor = "#33FFFFFF";
    }

    /*
     * Unable to fully structure code
     */
    @Override
    public void bind(IslandTemplate var1_1, DynamicIslandData var2_4) {
        o.g((Object)var1_1, (String)"template");
        super.bind((IslandTemplate)var1_1, (DynamicIslandData)var2_4);
        var1_1 = this.progressInfo;
        if (var1_1 == null) {
            var1_1 = this.progress;
            if (var1_1 != null) {
                var1_1.setVisibility(8);
            }
            return;
        }
        var2_4 = null;
        if (var1_1 != null) {
            var1_1 = var1_1.getColorReach();
        } else {
            var1_1 = null;
        }
        try {
            var4_5 = Color.parseColor((String)var1_1);
        }
        catch (Exception var1_2) {
            var4_5 = Color.parseColor((String)this.defaultReachColor);
        }
        var7_6 = this.progressInfo;
        var1_1 = var2_4;
        if (var7_6 == null) ** GOTO lbl26
        try {
            var1_1 = var7_6.getColorUnReach();
lbl26:
            // 2 sources

            var5_7 = Color.parseColor((String)var1_1);
        }
        catch (Exception var1_3) {
            var5_7 = Color.parseColor((String)this.defaultUnReachColor);
        }
        var1_1 = this.progress;
        if (var1_1 != null) {
            var1_1.setUp(this.strokeWidth, var5_7, var4_5, 100.0f);
        }
        if ((var1_1 = this.progress) != null) {
            var2_4 = this.progressInfo;
            var6_8 = var2_4 != null && (var2_4 = var2_4.isCCW()) != null ? var2_4.booleanValue() : false;
            var1_1.isCCW(var6_8);
        }
        if ((var1_1 = this.progress) != null) {
            var2_4 = this.progressInfo;
            var3_9 = var2_4 != null && (var2_4 = var2_4.getProgress()) != null ? (float)var2_4.intValue() : 0.0f;
            var1_1.setProgress(var3_9);
        }
    }

    @Override
    public void diff(IslandTemplate islandTemplate, DynamicIslandData dynamicIslandData) {
        o.g((Object)islandTemplate, (String)"template");
        super.diff(islandTemplate, dynamicIslandData);
    }

    public final ProgressInfo getProgressInfo() {
        return this.progressInfo;
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    @Override
    public Object initLayout(View var1_1, String var2_2, d var3_3) {
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
                int label;
                Object result;
                final IslandProgressViewHolder this$0;
                {
                    this.this$0 = islandProgressViewHolder;
                    super(d2);
                }

                public final Object invokeSuspend(Object object) {
                    this.result = object;
                    this.label |= Integer.MIN_VALUE;
                    return this.this$0.initLayout(null, null, (d)this);
                }
            };
        }
        var8_6 = var3_3 /* !! */ .result;
        var7_7 = c.c();
        var4_5 = var3_3 /* !! */ .label;
        if (var4_5 == 0) ** GOTO lbl19
        if (var4_5 == 1) {
            var6_8 = (View)var3_3 /* !! */ .L$1;
            var5_4 /* !! */  = (IslandProgressViewHolder)var3_3 /* !! */ .L$0;
            k.b((Object)var8_6);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
lbl19:
            // 1 sources

            k.b((Object)var8_6);
            var3_3 /* !! */ .L$0 = this;
            var3_3 /* !! */ .L$1 = var1_1;
            var3_3 /* !! */ .label = 1;
            var5_4 /* !! */  = this;
            var6_8 = var1_1;
            if (super.initLayout(var1_1, var2_2, var3_3 /* !! */ ) == var7_7) {
                return var7_7;
            }
        }
        var5_4 /* !! */ .progress = (CircularProgressBar)var6_8.findViewById(R.id.island_progress);
        return s.a;
    }

    @Override
    public void initView(String string) {
        o.g((Object)string, (String)"module");
        super.initView(string);
    }

    public final void setProgressInfo(ProgressInfo progressInfo) {
        this.progressInfo = progressInfo;
    }

    public final void setStrokeWidth(int n) {
        this.strokeWidth = n;
    }

    @Override
    public void updatePartial(IslandTemplate islandTemplate, DynamicIslandData dynamicIslandData) {
        o.g((Object)islandTemplate, (String)"template");
        super.updatePartial(islandTemplate, dynamicIslandData);
        this.bind(islandTemplate, dynamicIslandData);
    }
}
