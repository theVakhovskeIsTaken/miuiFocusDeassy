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
 *  android.widget.TextView
 *  com.android.systemui.plugins.miui.dynamicisland.DynamicIslandData
 *  e1.e
 *  kotlin.jvm.internal.o
 *  miuix.colorful.texteffect.TimerTextEffectView
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
import android.widget.TextView;
import com.android.systemui.plugins.miui.dynamicisland.DynamicIslandData;
import e1.e;
import kotlin.jvm.internal.o;
import miui.systemui.dynamicisland.R;
import miui.systemui.dynamicisland.model.IslandTemplate;
import miui.systemui.dynamicisland.model.PicInfo;
import miui.systemui.dynamicisland.model.TextInfo;
import miui.systemui.dynamicisland.module.BaseIslandModuleViewHolder;
import miui.systemui.dynamicisland.module.IslandIconViewHolder;
import miui.systemui.dynamicisland.module.IslandTextOverIconHolder;
import miuix.colorful.texteffect.TimerTextEffectView;

public final class IslandTextOverIconHolder
extends BaseIslandModuleViewHolder {
    private final IslandIconViewHolder iconViewHolder;
    private TextInfo textInfo;
    private TimerTextEffectView title;
    private String titleText;

    public IslandTextOverIconHolder(Context context, ViewGroup viewGroup, U0.o o2, IslandIconViewHolder.Factory factory) {
        o.g((Object)context, (String)"context");
        o.g((Object)viewGroup, (String)"rootView");
        o.g((Object)o2, (String)"emitEvent");
        o.g((Object)factory, (String)"iconViewHolderFactory");
        super(context, viewGroup, o2);
        this.iconViewHolder = factory.create(viewGroup, o2);
    }

    private final boolean isPureInteger(String string) {
        return new e("^\\d+$").a((CharSequence)string);
    }

    /*
     * Unable to fully structure code
     */
    @Override
    public void bind(IslandTemplate var1_1, DynamicIslandData var2_2) {
        block20: {
            block19: {
                block18: {
                    block17: {
                        block16: {
                            o.g((Object)var1_1, (String)"template");
                            super.bind(var1_1, var2_2);
                            var9_3 = var1_1.getBigIslandArea();
                            var10_4 = null;
                            var9_3 = var9_3 != null && (var9_3 = var9_3.getImageTextInfoRight()) != null ? var9_3.getTextInfo() : null;
                            this.textInfo = var9_3;
                            this.setFont((TextInfo)var9_3, (TextView)this.title);
                            var9_3 = var1_1.getBigIslandArea();
                            var7_5 = false;
                            if (var9_3 == null || (var9_3 = var9_3.getImageTextInfoRight()) == null || (var9_3 = var9_3.getTextInfo()) == null || (var9_3 = var9_3.getTitle()) == null) break block16;
                            var8_6 = this.isPureInteger((String)var9_3);
                            var4_7 = 1;
                            if (var8_6) break block17;
                        }
                        var4_7 = 0;
                    }
                    var9_3 = var1_1.getBigIslandArea();
                    if (var9_3 == null || (var9_3 = var9_3.getImageTextInfoRight()) == null || (var9_3 = var9_3.getTextInfo()) == null || (var11_8 = var9_3.getTitle()) == null) break block18;
                    var9_3 = new StringBuilder();
                    var6_9 = var11_8.length();
                    for (var5_10 = 0; var5_10 < var6_9; ++var5_10) {
                        var3_11 = var11_8.charAt(var5_10);
                        if (!Character.isDigit(var3_11)) continue;
                        var9_3.append(var3_11);
                    }
                    if ((var9_3 = var9_3.toString()) == null) break block18;
                    if (var9_3.length() > 3) {
                        var9_3 = null;
                    }
                    if (var9_3 != null) break block19;
                }
                var9_3 = "";
            }
            this.titleText = var9_3;
            var11_8 = this.title;
            if (var11_8 != null) {
                var4_7 = var9_3.length() == 0 || var4_7 == 0 ? 8 : 0;
                var11_8.setVisibility(var4_7);
            }
            if ((var9_3 = this.titleText) == null || var9_3.length() == 0 || (var9_3 = this.title) == null || var9_3.getVisibility() != 0) break block20;
            var9_3 = this.title;
            if (var9_3 != null) {
                var9_3.setText((CharSequence)this.titleText);
            }
            if (var1_1.getHighlightColor() == null) ** GOTO lbl-1000
            var9_3 = this.textInfo;
            if (var9_3 != null) {
                var7_5 = o.c((Object)var9_3.getShowHighlightColor(), (Object)Boolean.TRUE);
            }
            if (var7_5) {
                var4_7 = Color.parseColor((String)var1_1.getHighlightColor());
            } else lbl-1000:
            // 2 sources

            {
                var4_7 = -1;
            }
            var9_3 = this.title;
            if (var9_3 != null) {
                var9_3.setTextColor(var4_7);
            }
        }
        var11_8 = this.iconViewHolder;
        var12_12 = var1_1.getBigIslandArea();
        var9_3 = var10_4;
        if (var12_12 != null) {
            var12_12 = var12_12.getImageTextInfoRight();
            var9_3 = var10_4;
            if (var12_12 != null) {
                var9_3 = var12_12.getPicInfo();
            }
        }
        var11_8.setPicInfo((PicInfo)var9_3);
        this.iconViewHolder.updatePartial(var1_1, var2_2);
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
                                    final IslandTextOverIconHolder this$0;
                                    {
                                        this.this$0 = islandTextOverIconHolder;
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
                            var1_1 = (View)var6_4.L$1;
                            var5_8 = (IslandTextOverIconHolder)var6_4.L$0;
                            k.b((Object)var9_6);
                            break block7;
                        }
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    var7_9 = (String)var6_4.L$2;
                    var3_3 /* !! */  = (View)var6_4.L$1;
                    var5_8 = (IslandTextOverIconHolder)var6_4.L$0;
                    k.b((Object)var9_6);
                    break block8;
                }
                k.b((Object)var9_6);
                var6_4.L$0 = this;
                var6_4.L$1 = var1_1;
                var6_4.L$2 = var2_2;
                var6_4.label = 1;
                var5_8 = this;
                var3_3 /* !! */  = var1_1;
                var7_9 = var2_2;
                if (super.initLayout((View)var1_1, var2_2, (d)var6_4) == var8_7) {
                    return var8_7;
                }
            }
            var1_1 = var5_8.iconViewHolder;
            var6_4.L$0 = var5_8;
            var6_4.L$1 = var3_3 /* !! */ ;
            var6_4.L$2 = null;
            var6_4.label = 2;
            if (var1_1.initLayout((View)var3_3 /* !! */ , var7_9, (d)var6_4) == var8_7) {
                return var8_7;
            }
            var1_1 = var3_3 /* !! */ ;
        }
        var5_8.title = (TimerTextEffectView)var1_1.findViewById(R.id.island_title);
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
