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
 *  X0.b
 *  android.content.Context
 *  android.graphics.Color
 *  android.view.View
 *  android.view.ViewGroup
 *  android.widget.ImageView
 *  com.android.systemui.plugins.miui.dynamicisland.DynamicIslandData
 *  com.mi.widget.view.ChargerView
 *  com.mi.widget.view.ChargerView$ChargerType
 *  com.mi.widget.view.PowerSaveView
 *  kotlin.jvm.internal.o
 */
package miui.systemui.dynamicisland.module;

import G0.k;
import G0.s;
import K0.d;
import L0.c;
import X0.b;
import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.android.systemui.plugins.miui.dynamicisland.DynamicIslandData;
import com.mi.widget.view.ChargerView;
import com.mi.widget.view.PowerSaveView;
import kotlin.jvm.internal.o;
import miui.systemui.dynamicisland.R;
import miui.systemui.dynamicisland.model.BigIslandArea;
import miui.systemui.dynamicisland.model.ImageTextInfo;
import miui.systemui.dynamicisland.model.IslandTemplate;
import miui.systemui.dynamicisland.model.PicInfo;
import miui.systemui.dynamicisland.model.TextInfo;
import miui.systemui.dynamicisland.module.BaseIslandModuleViewHolder;
import miui.systemui.dynamicisland.module.IslandImageTextView4Holder;

public final class IslandImageTextView4Holder
extends BaseIslandModuleViewHolder {
    private ChargerView chargeView;
    private ImageView icon;
    private PicInfo picInfo;
    private PowerSaveView powerSaveView;
    private TextInfo textInfo;

    public IslandImageTextView4Holder(Context context, ViewGroup viewGroup, U0.o o2) {
        o.g((Object)context, (String)"context");
        o.g((Object)viewGroup, (String)"rootView");
        o.g((Object)o2, (String)"emitEvent");
        super(context, viewGroup, o2);
    }

    /*
     * Enabled aggressive block sorting
     */
    private final void showShaderIcon() {
        Object object = this.picInfo;
        object = object != null ? ((PicInfo)object).getPic() : null;
        if (object != null) {
            int n = ((String)object).hashCode();
            if (n != 657873003) {
                if (n != 1347797526) {
                    if (n == 2135799044 && ((String)object).equals("charger_mode")) {
                        object = this.powerSaveView;
                        if (object != null) {
                            object.setVisibility(8);
                        }
                        object = this.chargeView;
                        if (object != null) {
                            object.setVisibility(0);
                        }
                        object = this.chargeView;
                        if (object == null) {
                            return;
                        }
                        object.setChargerType(ChargerView.ChargerType.NORMAL);
                        return;
                    }
                } else if (((String)object).equals("quick_charger_mode")) {
                    object = this.powerSaveView;
                    if (object != null) {
                        object.setVisibility(8);
                    }
                    object = this.chargeView;
                    if (object != null) {
                        object.setVisibility(0);
                    }
                    object = this.chargeView;
                    if (object == null) {
                        return;
                    }
                    object.setChargerType(ChargerView.ChargerType.FAST);
                    return;
                }
            } else if (((String)object).equals("power_save_mode")) {
                object = this.chargeView;
                if (object != null) {
                    object.setVisibility(8);
                }
                object = this.powerSaveView;
                if (object == null) {
                    return;
                }
                object.setVisibility(0);
                return;
            }
        }
        if ((object = this.chargeView) != null) {
            object.setVisibility(8);
        }
        object = this.powerSaveView;
        if (object == null) {
            return;
        }
        object.setVisibility(8);
    }

    @Override
    public void bind(IslandTemplate islandTemplate, DynamicIslandData object) {
        boolean bl;
        o.g((Object)islandTemplate, (String)"template");
        super.bind(islandTemplate, (DynamicIslandData)object);
        object = islandTemplate.getBigIslandArea();
        Object var6_3 = null;
        object = object != null && (object = ((BigIslandArea)object).getImageTextInfoRight()) != null ? ((ImageTextInfo)object).getPicInfo() : null;
        this.picInfo = object;
        object = islandTemplate.getBigIslandArea();
        object = object != null && (object = ((BigIslandArea)object).getImageTextInfoRight()) != null ? ((ImageTextInfo)object).getTextInfo() : null;
        this.textInfo = object;
        float f = this.getContext().getResources().getDisplayMetrics().density;
        f = b.b((float)((float)14 * f));
        PowerSaveView powerSaveView = this.powerSaveView;
        boolean bl2 = false;
        if (powerSaveView != null) {
            object = this.textInfo;
            object = object != null ? ((TextInfo)object).getTitle() : null;
            powerSaveView.setText((CharSequence)String.valueOf(object));
            powerSaveView.setTextSize(f);
            object = this.textInfo;
            bl = object != null ? o.c((Object)((TextInfo)object).getShowHighlightColor(), (Object)Boolean.TRUE) : false;
            if (bl) {
                powerSaveView.setTextColor(Color.parseColor((String)islandTemplate.getHighlightColor()));
            }
        }
        if ((object = this.chargeView) != null && (powerSaveView = object.getTextView()) != null) {
            TextInfo textInfo = this.textInfo;
            object = var6_3;
            if (textInfo != null) {
                object = textInfo.getTitle();
            }
            powerSaveView.setText((CharSequence)String.valueOf(object));
            powerSaveView.setTextSize(0, f);
            object = this.textInfo;
            bl = bl2;
            if (object != null) {
                bl = o.c((Object)((TextInfo)object).getShowHighlightColor(), (Object)Boolean.TRUE);
            }
            if (bl) {
                powerSaveView.setTextColor(Color.parseColor((String)islandTemplate.getHighlightColor()));
            }
        }
        this.showShaderIcon();
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
                final IslandImageTextView4Holder this$0;
                {
                    this.this$0 = islandImageTextView4Holder;
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
            var5_4 /* !! */  = (IslandImageTextView4Holder)var3_3 /* !! */ .L$0;
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
        var5_4 /* !! */ .icon = (ImageView)var6_8.findViewById(R.id.island_icon);
        var5_4 /* !! */ .powerSaveView = (PowerSaveView)var6_8.findViewById(R.id.power_save_view);
        var5_4 /* !! */ .chargeView = (ChargerView)var6_8.findViewById(R.id.charge_view);
        return s.a;
    }

    @Override
    public void initView(String string) {
        o.g((Object)string, (String)"module");
        super.initView(string);
        string = this.powerSaveView;
        if (string != null) {
            string.setVisibility(8);
        }
        string = this.chargeView;
        if (string != null) {
            string.setVisibility(8);
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    @Override
    public void updatePartial(IslandTemplate islandTemplate, DynamicIslandData dynamicIslandData) {
        o.g((Object)islandTemplate, (String)"template");
        super.updatePartial(islandTemplate, dynamicIslandData);
        this.bind(islandTemplate, dynamicIslandData);
    }

    @Override
    public void updateWidth(int n) {
    }
}
