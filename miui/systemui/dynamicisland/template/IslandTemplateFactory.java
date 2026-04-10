/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  G0.k
 *  K0.d
 *  K0.g
 *  L0.c
 *  M0.d
 *  U0.o
 *  android.annotation.SuppressLint
 *  android.content.Context
 *  android.text.TextUtils
 *  android.util.Log
 *  android.view.View
 *  android.view.ViewGroup
 *  com.android.systemui.plugins.miui.dynamicisland.DynamicIslandData
 *  f1.E
 *  f1.F
 *  kotlin.jvm.internal.o
 *  miui.systemui.coroutines.Dispatchers
 *  miui.systemui.util.CommonUtils
 *  miuix.mipalette.MiPalette
 */
package miui.systemui.dynamicisland.template;

import G0.k;
import K0.d;
import K0.g;
import L0.c;
import android.annotation.SuppressLint;
import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import com.android.systemui.plugins.miui.dynamicisland.DynamicIslandData;
import f1.E;
import f1.F;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.o;
import miui.systemui.coroutines.Dispatchers;
import miui.systemui.dynamicisland.IslandParamsException;
import miui.systemui.dynamicisland.R;
import miui.systemui.dynamicisland.dagger.DynamicIslandScope;
import miui.systemui.dynamicisland.dagger.qualifiers.DynamicIsland;
import miui.systemui.dynamicisland.model.BigIslandArea;
import miui.systemui.dynamicisland.model.ImageTextInfo;
import miui.systemui.dynamicisland.model.IslandTemplate;
import miui.systemui.dynamicisland.model.SmallIslandArea;
import miui.systemui.dynamicisland.template.IslandTemplateBuilder;
import miui.systemui.dynamicisland.template.IslandTemplateFactory;
import miui.systemui.util.CommonUtils;
import miuix.mipalette.MiPalette;

@DynamicIslandScope
public final class IslandTemplateFactory {
    private static final String AREA_LEFT = "area_left";
    private static final String AREA_RIGHT = "area_right";
    private static final String AREA_SMALL = "area_small";
    public static final Companion Companion = new Object(null){
        {
            this();
        }
    };
    private static final String TAG = "IslandTemplateFactory";
    private final Map<String, IslandTemplateBuilder> bigIslandBuilderMap;
    private final Map<String, IslandTemplateBuilder> fakeBigIslandBuilderMap;
    private final Map<String, IslandTemplateBuilder> fakeSmallIslandBuilderMap;
    private final IslandTemplateBuilder.Factory islandTemplateBuilderFactory;
    private final Map<String, IslandTemplateBuilder> smallIslandBuilderMap;
    private final Map<String, IslandTemplate> templateMap;
    private final E uiScope;

    public IslandTemplateFactory(@DynamicIsland E e, IslandTemplateBuilder.Factory factory) {
        o.g((Object)e, (String)"scope");
        o.g((Object)factory, (String)"islandTemplateBuilderFactory");
        this.islandTemplateBuilderFactory = factory;
        this.uiScope = F.g((E)e, (g)Dispatchers.INSTANCE.getMain());
        this.bigIslandBuilderMap = new LinkedHashMap<String, IslandTemplateBuilder>();
        this.smallIslandBuilderMap = new LinkedHashMap<String, IslandTemplateBuilder>();
        this.templateMap = new LinkedHashMap<String, IslandTemplate>();
        this.fakeBigIslandBuilderMap = new LinkedHashMap<String, IslandTemplateBuilder>();
        this.fakeSmallIslandBuilderMap = new LinkedHashMap<String, IslandTemplateBuilder>();
        MiPalette.init();
    }

    public static final /* synthetic */ Object access$createBigIslandTemplateView(IslandTemplateFactory islandTemplateFactory, Context context, IslandTemplate islandTemplate, DynamicIslandData dynamicIslandData, ViewGroup viewGroup, boolean bl, U0.o o2, d d2) {
        return islandTemplateFactory.createBigIslandTemplateView(context, islandTemplate, dynamicIslandData, viewGroup, bl, o2, d2);
    }

    public static final /* synthetic */ Object access$createSmallIslandTemplateView(IslandTemplateFactory islandTemplateFactory, Context context, IslandTemplate islandTemplate, DynamicIslandData dynamicIslandData, ViewGroup viewGroup, boolean bl, U0.o o2, d d2) {
        return islandTemplateFactory.createSmallIslandTemplateView(context, islandTemplate, dynamicIslandData, viewGroup, bl, o2, d2);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private final String chooseModule(IslandTemplate object, String object2) {
        BigIslandArea bigIslandArea = ((IslandTemplate)object).getBigIslandArea();
        SmallIslandArea smallIslandArea = ((IslandTemplate)object).getSmallIslandArea();
        int n = ((String)object2).hashCode();
        Object var4_6 = null;
        Object var5_7 = null;
        object = null;
        if (n != -100870023) {
            if (n != 1173657578) {
                if (n != 1174694613 || !((String)object2).equals(AREA_SMALL)) return "";
                if (smallIslandArea != null) {
                    object = smallIslandArea.getCombinePicInfo();
                }
                if (object != null) {
                    return "moduleCombinePic";
                }
                if (bigIslandArea == null || (object = bigIslandArea.getImageTextInfoRight()) == null || (object = ((ImageTextInfo)object).getType()) == null || (Integer)object != 6) return "modulePicSmallIsland";
                return "moduleSmallTextOverIcon";
            }
            if (!((String)object2).equals(AREA_RIGHT)) return "";
            object = bigIslandArea != null ? bigIslandArea.getImageTextInfoRight() : null;
            if (!(object == null || (object2 = ((ImageTextInfo)object).getType()) != null && (Integer)object2 == 1 || (object = ((ImageTextInfo)object).getType()) != null && (Integer)object == 5)) {
                object = bigIslandArea.getImageTextInfoRight();
                object = object != null ? ((ImageTextInfo)object).getType() : null;
                if (object != null && (Integer)object == 2) {
                    return "moduleImageText_2";
                }
                if (object != null && (Integer)object == 3) {
                    return "moduleImageText_3";
                }
                if (object != null && (Integer)object == 4) {
                    return "moduleImageText_4";
                }
                if (object != null && (Integer)object == 6) {
                    return "moduleTextOverIcon";
                }
            }
            if ((object = bigIslandArea != null ? bigIslandArea.getFixedWidthDigitInfo() : null) != null) {
                return "moduleFixedWidthDigit";
            }
            object = bigIslandArea != null ? bigIslandArea.getSameWidthDigitInfo() : null;
            if (object != null) {
                return "moduleSameWidthDigit";
            }
            object = bigIslandArea != null ? bigIslandArea.getProgressTextInfo() : null;
            if (object != null) {
                return "moduleImageText";
            }
            object = bigIslandArea != null ? bigIslandArea.getTextInfo() : null;
            if (object != null) {
                return "moduleText";
            }
            object = var4_6;
            if (bigIslandArea != null) {
                object = bigIslandArea.getPicInfo();
            }
            if (object == null) return "";
            return "modulePic";
        }
        if (!((String)object2).equals(AREA_LEFT)) return "";
        object = bigIslandArea != null ? bigIslandArea.getImageTextInfoLeft() : null;
        object2 = var5_7;
        if (object != null) {
            object2 = ((ImageTextInfo)object).getType();
        }
        if (object2 == null || ((object2 = ((ImageTextInfo)object).getType()) == null || (Integer)object2 != 1) && ((object2 = ((ImageTextInfo)object).getType()) == null || (Integer)object2 != 5)) throw new IslandParamsException("bigIslandArea.imageTextInfoLeft.type is null or not 1 or 5");
        object2 = ((ImageTextInfo)object).getType();
        if (object2 != null && (Integer)object2 == 1) {
            return "moduleImageText_1";
        }
        if ((object = ((ImageTextInfo)object).getType()) == null || (Integer)object != 5) return "";
        return "moduleIconFixedWidthText";
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    @SuppressLint(value={"SuspiciousIndentation"})
    private final Object createBigIslandTemplateView(Context var1_1, IslandTemplate var2_2, DynamicIslandData var3_3, ViewGroup var4_4, boolean var5_5, U0.o var6_6, d var7_7) {
        block32: {
            block33: {
                block34: {
                    block37: {
                        block35: {
                            block36: {
                                var12_8 = this;
                                var1_1 = var3_3;
                                if (!(var7_7 /* !! */  instanceof createBigIslandTemplateView.1)) ** GOTO lbl-1000
                                var13_9 = var7_7 /* !! */ ;
                                var8_10 = var13_9.label;
                                if ((var8_10 & -2147483648) != 0) {
                                    var13_9.label = var8_10 + -2147483648;
                                    var7_7 /* !! */  = var13_9;
                                } else lbl-1000:
                                // 2 sources

                                {
                                    var7_7 /* !! */  = new M0.d((IslandTemplateFactory)var12_8, var7_7 /* !! */ ){
                                        Object L$0;
                                        Object L$1;
                                        Object L$2;
                                        Object L$3;
                                        Object L$4;
                                        Object L$5;
                                        int label;
                                        Object result;
                                        final IslandTemplateFactory this$0;
                                        {
                                            this.this$0 = islandTemplateFactory;
                                            super(d2);
                                        }

                                        public final Object invokeSuspend(Object object) {
                                            this.result = object;
                                            this.label |= Integer.MIN_VALUE;
                                            return IslandTemplateFactory.access$createBigIslandTemplateView(this.this$0, null, null, null, null, false, null, (d)this);
                                        }
                                    };
                                }
                                var13_9 = var7_7 /* !! */ .result;
                                var18_11 = c.c();
                                var9_12 = var7_7 /* !! */ .label;
                                var8_10 = 4;
                                var16_13 = null;
                                var17_14 = null;
                                switch (var9_12) {
                                    default: {
                                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                    }
                                    case 6: {
                                        var1_1 = (IslandTemplateBuilder)var7_7 /* !! */ .L$2;
                                        var2_2 = (DynamicIslandData)var7_7 /* !! */ .L$1;
                                        var3_3 = (IslandTemplateFactory)var7_7 /* !! */ .L$0;
                                        k.b((Object)var13_9);
                                        break block32;
                                    }
                                    case 5: {
                                        var1_1 = (IslandTemplateBuilder)var7_7 /* !! */ .L$4;
                                        var2_2 = (String)var7_7 /* !! */ .L$3;
                                        var4_4 = (DynamicIslandData)var7_7 /* !! */ .L$2;
                                        var14_15 /* !! */  = (IslandTemplate)var7_7 /* !! */ .L$1;
                                        var3_3 = (IslandTemplateFactory)var7_7 /* !! */ .L$0;
                                        k.b((Object)var13_9);
                                        var12_8 = var2_2;
                                        break block33;
                                    }
                                    case 4: {
                                        var3_3 = (IslandTemplateBuilder)var7_7 /* !! */ .L$5;
                                        var4_4 = (String)var7_7 /* !! */ .L$4;
                                        var6_6 /* !! */  = (String)var7_7 /* !! */ .L$3;
                                        var1_1 = (DynamicIslandData)var7_7 /* !! */ .L$2;
                                        var2_2 = (IslandTemplate)var7_7 /* !! */ .L$1;
                                        var12_8 = (IslandTemplateFactory)var7_7 /* !! */ .L$0;
                                        k.b((Object)var13_9);
                                        break block34;
                                    }
                                    case 3: {
                                        var1_1 = (IslandTemplateBuilder)var7_7 /* !! */ .L$2;
                                        var2_2 = (DynamicIslandData)var7_7 /* !! */ .L$1;
                                        var3_3 = (IslandTemplateFactory)var7_7 /* !! */ .L$0;
                                        k.b((Object)var13_9);
                                        break block35;
                                    }
                                    case 2: {
                                        var1_1 = (IslandTemplateBuilder)var7_7 /* !! */ .L$4;
                                        var2_2 = (String)var7_7 /* !! */ .L$3;
                                        var4_4 = (DynamicIslandData)var7_7 /* !! */ .L$2;
                                        var12_8 = (IslandTemplate)var7_7 /* !! */ .L$1;
                                        var3_3 = (IslandTemplateFactory)var7_7 /* !! */ .L$0;
                                        k.b((Object)var13_9);
                                        var14_15 /* !! */  = var13_9;
                                        var6_6 /* !! */  = var2_2;
                                        break block36;
                                    }
                                    case 1: {
                                        var3_3 = (IslandTemplateBuilder)var7_7 /* !! */ .L$5;
                                        var4_4 = (String)var7_7 /* !! */ .L$4;
                                        var6_6 /* !! */  = (String)var7_7 /* !! */ .L$3;
                                        var1_1 = (DynamicIslandData)var7_7 /* !! */ .L$2;
                                        var2_2 = (IslandTemplate)var7_7 /* !! */ .L$1;
                                        var12_8 = (IslandTemplateFactory)var7_7 /* !! */ .L$0;
                                        k.b((Object)var13_9);
                                        break;
                                    }
                                    case 0: {
                                        k.b((Object)var13_9);
                                        var13_9 = var12_8.chooseModule((IslandTemplate)var2_2, "area_left");
                                        var14_15 /* !! */  = var12_8.chooseModule((IslandTemplate)var2_2, "area_right");
                                        var19_16 = var12_8.bigIslandBuilderMap;
                                        var15_17 = var1_1 != null ? var3_3.getKey() : null;
                                        var19_16 = var19_16.get(var15_17);
                                        var11_18 = var19_16 != null && var19_16.isSameModuleLeft((String)var13_9) == true && var19_16.isSameModuleRight((String)var14_15 /* !! */ ) != false;
                                        var15_17 = new StringBuilder();
                                        var15_17.append("isSameModule: ");
                                        var15_17.append(var11_18);
                                        Log.d((String)"IslandTemplateFactory", (String)var15_17.toString());
                                        if (var19_16 != null && !var11_18 && var1_1 != null && (var15_17 = var3_3.getKey()) != null) {
                                            var12_8.removeTemplate((String)var15_17);
                                        }
                                        var19_16 = var12_8.templateMap;
                                        var15_17 = var1_1 != null ? var3_3.getKey() : null;
                                        o.d((Object)var15_17);
                                        var19_16.put((String)var15_17, (IslandTemplate)var2_2);
                                        if (var5_5) {
                                            var16_13 = var12_8.fakeBigIslandBuilderMap;
                                            var15_17 = var1_1 != null ? var3_3.getKey() : null;
                                            if (var16_13.containsKey(var15_17)) {
                                                var4_4 = var12_8.fakeBigIslandBuilderMap;
                                                var3_3 = var1_1 != null ? var3_3.getKey() : null;
                                                if ((var3_3 = (IslandTemplateBuilder)var4_4.get(var3_3)) != null && (var4_4 = var3_3.setIslandAreaViewVisible(var10_19 = R.id.fake_area_left, var9_12 = TextUtils.isEmpty((CharSequence)var13_9) == false ? 0 : 8, var12_8.uiScope)) != null) {
                                                    var9_12 = R.id.fake_area_right;
                                                    if (!TextUtils.isEmpty((CharSequence)var14_15 /* !! */ )) {
                                                        var8_10 = 0;
                                                    }
                                                    if ((var4_4 = var4_4.setIslandAreaViewVisible(var9_12, var8_10, var12_8.uiScope)) != null && (var4_4 = var4_4.updateModuleView((String)var13_9, (IslandTemplate)var2_2, (DynamicIslandData)var1_1)) != null) {
                                                        var4_4.updateModuleView((String)var14_15 /* !! */ , (IslandTemplate)var2_2, (DynamicIslandData)var1_1);
                                                    }
                                                }
                                                var1_1 = var17_14;
                                                if (var3_3 != null) {
                                                    var1_1 = var3_3.buildIslandView();
                                                }
                                                return var1_1;
                                            }
                                            var15_17 = var12_8.islandTemplateBuilderFactory;
                                            var15_17 = var15_17.create((ViewGroup)var4_4, true, true, var6_6 /* !! */ , (DynamicIslandData)var3_3);
                                            var7_7 /* !! */ .L$0 = var12_8;
                                            var7_7 /* !! */ .L$1 = var2_2;
                                            var7_7 /* !! */ .L$2 = var1_1;
                                            var7_7 /* !! */ .L$3 = var13_9;
                                            var7_7 /* !! */ .L$4 = var14_15 /* !! */ ;
                                            var7_7 /* !! */ .L$5 = var15_17;
                                            var7_7 /* !! */ .label = 1;
                                            var3_3 = var15_17;
                                            var4_4 = var14_15 /* !! */ ;
                                            var6_6 /* !! */  = var13_9;
                                            if (var15_17.initLayout(var7_7 /* !! */ ) != var18_11) break;
                                            return var18_11;
                                        }
                                        break block37;
                                    }
                                }
                                var10_20 = R.id.fake_area_left;
                                var9_12 = TextUtils.isEmpty((CharSequence)var6_6 /* !! */ ) == false ? 0 : 8;
                                var13_9 = var3_3.setIslandAreaViewVisible(var10_20, var9_12, var12_8.uiScope);
                                var9_12 = R.id.fake_area_right;
                                if (!TextUtils.isEmpty((CharSequence)var4_4)) {
                                    var8_10 = 0;
                                }
                                var13_9 = var13_9.setIslandAreaViewVisible(var9_12, var8_10, var12_8.uiScope);
                                var7_7 /* !! */ .L$0 = var12_8;
                                var7_7 /* !! */ .L$1 = var2_2;
                                var7_7 /* !! */ .L$2 = var1_1;
                                var7_7 /* !! */ .L$3 = var4_4;
                                var7_7 /* !! */ .L$4 = var3_3;
                                var7_7 /* !! */ .L$5 = null;
                                var7_7 /* !! */ .label = 2;
                                var14_15 /* !! */  = var13_9.addIslandModuleView(var10_20, (String)var6_6 /* !! */ , (IslandTemplate)var2_2, (DynamicIslandData)var1_1, var7_7 /* !! */ );
                                if (var14_15 /* !! */  == var18_11) {
                                    return var18_11;
                                }
                                var13_9 = var3_3;
                                var6_6 /* !! */  = var4_4;
                                var4_4 = var1_1;
                                var3_3 = var12_8;
                                var12_8 = var2_2;
                                var1_1 = var13_9;
                            }
                            var2_2 = (IslandTemplateBuilder)var14_15 /* !! */ ;
                            var8_10 = R.id.fake_area_right;
                            var7_7 /* !! */ .L$0 = var3_3;
                            var7_7 /* !! */ .L$1 = var4_4;
                            var7_7 /* !! */ .L$2 = var1_1;
                            var7_7 /* !! */ .L$3 = null;
                            var7_7 /* !! */ .L$4 = null;
                            var7_7 /* !! */ .label = 3;
                            if (var2_2.addIslandModuleView(var8_10, (String)var6_6 /* !! */ , (IslandTemplate)var12_8, (DynamicIslandData)var4_4, var7_7 /* !! */ ) == var18_11) {
                                return var18_11;
                            }
                            var2_2 = var4_4;
                        }
                        if (var2_2 != null && (var2_2 = var2_2.getKey()) != null) {
                            var2_2 = var3_3.fakeBigIslandBuilderMap.put((String)var2_2, (IslandTemplateBuilder)var1_1);
                        }
                        return var1_1.buildIslandView();
                    }
                    var17_14 = var12_8.bigIslandBuilderMap;
                    var15_17 = var1_1 != null ? var3_3.getKey() : null;
                    if (var17_14.containsKey(var15_17)) {
                        var4_4 = var12_8.bigIslandBuilderMap;
                        var3_3 = var1_1 != null ? var3_3.getKey() : null;
                        if ((var3_3 = (IslandTemplateBuilder)var4_4.get(var3_3)) != null && (var4_4 = var3_3.setIslandAreaViewVisible(var10_21 = R.id.area_left, var9_12 = TextUtils.isEmpty((CharSequence)var13_9) == false ? 0 : 8, var12_8.uiScope)) != null) {
                            var9_12 = R.id.area_right;
                            if (!TextUtils.isEmpty((CharSequence)var14_15 /* !! */ )) {
                                var8_10 = 0;
                            }
                            if ((var4_4 = var4_4.setIslandAreaViewVisible(var9_12, var8_10, var12_8.uiScope)) != null && (var4_4 = var4_4.updateModuleView((String)var13_9, (IslandTemplate)var2_2, (DynamicIslandData)var1_1)) != null) {
                                var4_4.updateModuleView((String)var14_15 /* !! */ , (IslandTemplate)var2_2, (DynamicIslandData)var1_1);
                            }
                        }
                        var1_1 = var16_13;
                        if (var3_3 != null) {
                            var1_1 = var3_3.buildIslandView();
                        }
                        return var1_1;
                    }
                    var15_17 = var12_8.islandTemplateBuilderFactory.create((ViewGroup)var4_4, true, false, var6_6 /* !! */ , (DynamicIslandData)var3_3);
                    var7_7 /* !! */ .L$0 = var12_8;
                    var7_7 /* !! */ .L$1 = var2_2;
                    var7_7 /* !! */ .L$2 = var1_1;
                    var7_7 /* !! */ .L$3 = var13_9;
                    var7_7 /* !! */ .L$4 = var14_15 /* !! */ ;
                    var7_7 /* !! */ .L$5 = var15_17;
                    var7_7 /* !! */ .label = 4;
                    var3_3 = var15_17;
                    var4_4 = var14_15 /* !! */ ;
                    var6_6 /* !! */  = var13_9;
                    if (var15_17.initLayout(var7_7 /* !! */ ) == var18_11) {
                        return var18_11;
                    }
                }
                var10_22 = R.id.area_left;
                var9_12 = TextUtils.isEmpty((CharSequence)var6_6 /* !! */ ) == false ? 0 : 8;
                var13_9 = var3_3.setIslandAreaViewVisible(var10_22, var9_12, var12_8.uiScope);
                var9_12 = R.id.area_right;
                if (!TextUtils.isEmpty((CharSequence)var4_4)) {
                    var8_10 = 0;
                }
                var13_9 = var13_9.setIslandAreaViewVisible(var9_12, var8_10, var12_8.uiScope);
                var7_7 /* !! */ .L$0 = var12_8;
                var7_7 /* !! */ .L$1 = var2_2;
                var7_7 /* !! */ .L$2 = var1_1;
                var7_7 /* !! */ .L$3 = var4_4;
                var7_7 /* !! */ .L$4 = var3_3;
                var7_7 /* !! */ .L$5 = null;
                var7_7 /* !! */ .label = 5;
                var14_15 /* !! */  = var13_9.addIslandModuleView(var10_22, (String)var6_6 /* !! */ , (IslandTemplate)var2_2, (DynamicIslandData)var1_1, var7_7 /* !! */ );
                if (var14_15 /* !! */  == var18_11) {
                    return var18_11;
                }
                var13_9 = var12_8;
                var6_6 /* !! */  = var3_3;
                var12_8 = var4_4;
                var4_4 = var1_1;
                var3_3 = var13_9;
                var13_9 = var14_15 /* !! */ ;
                var14_15 /* !! */  = var2_2;
                var1_1 = var6_6 /* !! */ ;
            }
            var2_2 = (IslandTemplateBuilder)var13_9;
            var8_10 = R.id.area_right;
            var7_7 /* !! */ .L$0 = var3_3;
            var7_7 /* !! */ .L$1 = var4_4;
            var7_7 /* !! */ .L$2 = var1_1;
            var7_7 /* !! */ .L$3 = null;
            var7_7 /* !! */ .L$4 = null;
            var7_7 /* !! */ .label = 6;
            if (var2_2.addIslandModuleView(var8_10, (String)var12_8, (IslandTemplate)var14_15 /* !! */ , (DynamicIslandData)var4_4, var7_7 /* !! */ ) == var18_11) {
                return var18_11;
            }
            var2_2 = var4_4;
        }
        if (var2_2 != null && (var2_2 = var2_2.getKey()) != null) {
            var2_2 = var3_3.bigIslandBuilderMap.put((String)var2_2, (IslandTemplateBuilder)var1_1);
        }
        return var1_1.buildIslandView();
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    private final Object createSmallIslandTemplateView(Context var1_1, IslandTemplate var2_2, DynamicIslandData var3_3, ViewGroup var4_4, boolean var5_5, U0.o var6_6, d var7_7) {
        block23: {
            block24: {
                block27: {
                    block25: {
                        block26: {
                            block18: {
                                block19: {
                                    block20: {
                                        block21: {
                                            block22: {
                                                var11_8 = this;
                                                var1_1 = var3_3 /* !! */ ;
                                                if (!(var7_7 /* !! */  instanceof createSmallIslandTemplateView.1)) ** GOTO lbl-1000
                                                var12_9 /* !! */  = var7_7 /* !! */ ;
                                                var8_10 = var12_9 /* !! */ .label;
                                                if ((var8_10 & -2147483648) != 0) {
                                                    var12_9 /* !! */ .label = var8_10 + -2147483648;
                                                    var7_7 /* !! */  = var12_9 /* !! */ ;
                                                } else lbl-1000:
                                                // 2 sources

                                                {
                                                    var7_7 /* !! */  = new M0.d(var11_8, var7_7 /* !! */ ){
                                                        Object L$0;
                                                        Object L$1;
                                                        Object L$2;
                                                        Object L$3;
                                                        Object L$4;
                                                        int label;
                                                        Object result;
                                                        final IslandTemplateFactory this$0;
                                                        {
                                                            this.this$0 = islandTemplateFactory;
                                                            super(d2);
                                                        }

                                                        public final Object invokeSuspend(Object object) {
                                                            this.result = object;
                                                            this.label |= Integer.MIN_VALUE;
                                                            return IslandTemplateFactory.access$createSmallIslandTemplateView(this.this$0, null, null, null, null, false, null, (d)this);
                                                        }
                                                    };
                                                }
                                                var12_9 /* !! */  = var7_7 /* !! */ .result;
                                                var16_11 = c.c();
                                                var8_10 = var7_7 /* !! */ .label;
                                                var14_12 = null;
                                                var15_13 = null;
                                                if (var8_10 == 0) break block18;
                                                if (var8_10 == 1) break block19;
                                                if (var8_10 == 2) break block20;
                                                if (var8_10 == 3) break block21;
                                                if (var8_10 != 4) break block22;
                                                var1_1 = (IslandTemplateBuilder)var7_7 /* !! */ .L$2;
                                                var4_4 /* !! */  = (DynamicIslandData)var7_7 /* !! */ .L$1;
                                                var2_2 = (IslandTemplateFactory)var7_7 /* !! */ .L$0;
                                                k.b((Object)var12_9 /* !! */ );
                                                break block23;
                                            }
                                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                        }
                                        var2_2 = (IslandTemplateBuilder)var7_7 /* !! */ .L$4;
                                        var3_3 /* !! */  = (String)var7_7 /* !! */ .L$3;
                                        var1_1 = (DynamicIslandData)var7_7 /* !! */ .L$2;
                                        var4_4 /* !! */  = (IslandTemplate)var7_7 /* !! */ .L$1;
                                        var11_8 = (IslandTemplateFactory)var7_7 /* !! */ .L$0;
                                        k.b((Object)var12_9 /* !! */ );
                                        break block24;
                                    }
                                    var1_1 = (IslandTemplateBuilder)var7_7 /* !! */ .L$2;
                                    var4_4 /* !! */  = (DynamicIslandData)var7_7 /* !! */ .L$1;
                                    var2_2 = (IslandTemplateFactory)var7_7 /* !! */ .L$0;
                                    k.b((Object)var12_9 /* !! */ );
                                    break block25;
                                }
                                var2_2 = (IslandTemplateBuilder)var7_7 /* !! */ .L$4;
                                var3_3 /* !! */  = (String)var7_7 /* !! */ .L$3;
                                var1_1 = (DynamicIslandData)var7_7 /* !! */ .L$2;
                                var4_4 /* !! */  = (IslandTemplate)var7_7 /* !! */ .L$1;
                                var11_8 = (IslandTemplateFactory)var7_7 /* !! */ .L$0;
                                k.b((Object)var12_9 /* !! */ );
                                break block26;
                            }
                            k.b((Object)var12_9 /* !! */ );
                            var12_9 /* !! */  = var11_8.chooseModule((IslandTemplate)var2_2, "area_small");
                            var17_14 = var11_8.smallIslandBuilderMap;
                            var13_15 = var1_1 != null ? var3_3 /* !! */ .getKey() : null;
                            var13_15 = var17_14.get(var13_15);
                            var9_17 = var10_16 = false;
                            if (var13_15 != null) {
                                var9_17 = var10_16;
                                if (var13_15.isSameModuleSmall((String)var12_9 /* !! */ )) {
                                    var9_17 = true;
                                }
                            }
                            var17_14 = new StringBuilder();
                            var17_14.append("isSameModule: ");
                            var17_14.append(var9_17);
                            Log.d((String)"IslandTemplateFactory", (String)var17_14.toString());
                            if (var13_15 != null && !var9_17 && var1_1 != null && (var13_15 = var3_3 /* !! */ .getKey()) != null) {
                                var11_8.removeTemplate((String)var13_15);
                            }
                            if (var5_5) {
                                var14_12 = var11_8.fakeSmallIslandBuilderMap;
                                var13_15 = var1_1 != null ? var3_3 /* !! */ .getKey() : null;
                                if (var14_12.containsKey(var13_15)) {
                                    var4_4 /* !! */  = var11_8.fakeSmallIslandBuilderMap;
                                    var3_3 /* !! */  = var1_1 != null ? var3_3 /* !! */ .getKey() : null;
                                    if ((var3_3 /* !! */  = (IslandTemplateBuilder)var4_4 /* !! */ .get(var3_3 /* !! */ )) != null) {
                                        var3_3 /* !! */ .updateModuleView((String)var12_9 /* !! */ , (IslandTemplate)var2_2, (DynamicIslandData)var1_1);
                                    }
                                    var1_1 = var15_13;
                                    if (var3_3 /* !! */  != null) {
                                        var1_1 = var3_3 /* !! */ .buildIslandView();
                                    }
                                    return var1_1;
                                }
                                var13_15 = var11_8.islandTemplateBuilderFactory;
                                var6_6 = var13_15.create(var4_4 /* !! */ , false, true, (U0.o)var6_6, var3_3 /* !! */ );
                                var7_7 /* !! */ .L$0 = var11_8;
                                var7_7 /* !! */ .L$1 = var2_2;
                                var7_7 /* !! */ .L$2 = var1_1;
                                var7_7 /* !! */ .L$3 = var12_9 /* !! */ ;
                                var7_7 /* !! */ .L$4 = var6_6;
                                var7_7 /* !! */ .label = 1;
                                var4_4 /* !! */  = var2_2;
                                var2_2 = var6_6;
                                var3_3 /* !! */  = var12_9 /* !! */ ;
                                if (var6_6.initLayout(var7_7 /* !! */ ) == var16_11) {
                                    return var16_11;
                                } else {
                                    ** GOTO lbl97
                                }
                            }
                            break block27;
                        }
                        var8_10 = R.id.fake_small_container;
                        var7_7 /* !! */ .L$0 = var11_8;
                        var7_7 /* !! */ .L$1 = var1_1;
                        var7_7 /* !! */ .L$2 = var2_2;
                        var7_7 /* !! */ .L$3 = null;
                        var7_7 /* !! */ .L$4 = null;
                        var7_7 /* !! */ .label = 2;
                        if (var2_2.addIslandModuleView(var8_10, (String)var3_3 /* !! */ , (IslandTemplate)var4_4 /* !! */ , (DynamicIslandData)var1_1, var7_7 /* !! */ ) == var16_11) {
                            return var16_11;
                        }
                        var3_3 /* !! */  = var2_2;
                        var2_2 = var11_8;
                        var4_4 /* !! */  = var1_1;
                        var1_1 = var3_3 /* !! */ ;
                    }
                    if (var4_4 /* !! */  != null && (var3_3 /* !! */  = var4_4 /* !! */ .getKey()) != null) {
                        var2_2 = var2_2.fakeSmallIslandBuilderMap.put((String)var3_3 /* !! */ , (IslandTemplateBuilder)var1_1);
                    }
                    return var1_1.buildIslandView();
                }
                var15_13 = var11_8.smallIslandBuilderMap;
                var13_15 = var1_1 != null ? var3_3 /* !! */ .getKey() : null;
                if (var15_13.containsKey(var13_15)) {
                    var4_4 /* !! */  = var11_8.smallIslandBuilderMap;
                    var3_3 /* !! */  = var1_1 != null ? var3_3 /* !! */ .getKey() : null;
                    if ((var3_3 /* !! */  = (IslandTemplateBuilder)var4_4 /* !! */ .get(var3_3 /* !! */ )) != null) {
                        var3_3 /* !! */ .updateModuleView((String)var12_9 /* !! */ , (IslandTemplate)var2_2, (DynamicIslandData)var1_1);
                    }
                    var1_1 = var14_12;
                    if (var3_3 /* !! */  != null) {
                        var1_1 = var3_3 /* !! */ .buildIslandView();
                    }
                    return var1_1;
                }
                var6_6 = var11_8.islandTemplateBuilderFactory.create(var4_4 /* !! */ , false, false, (U0.o)var6_6, var3_3 /* !! */ );
                var7_7 /* !! */ .L$0 = var11_8;
                var7_7 /* !! */ .L$1 = var2_2;
                var7_7 /* !! */ .L$2 = var1_1;
                var7_7 /* !! */ .L$3 = var12_9 /* !! */ ;
                var7_7 /* !! */ .L$4 = var6_6;
                var7_7 /* !! */ .label = 3;
                var4_4 /* !! */  = var2_2;
                var2_2 = var6_6;
                var3_3 /* !! */  = var12_9 /* !! */ ;
                if (var6_6.initLayout(var7_7 /* !! */ ) == var16_11) {
                    return var16_11;
                }
            }
            var8_10 = R.id.small_container;
            var7_7 /* !! */ .L$0 = var11_8;
            var7_7 /* !! */ .L$1 = var1_1;
            var7_7 /* !! */ .L$2 = var2_2;
            var7_7 /* !! */ .L$3 = null;
            var7_7 /* !! */ .L$4 = null;
            var7_7 /* !! */ .label = 4;
            if (var2_2.addIslandModuleView(var8_10, (String)var3_3 /* !! */ , (IslandTemplate)var4_4 /* !! */ , (DynamicIslandData)var1_1, var7_7 /* !! */ ) == var16_11) {
                return var16_11;
            }
            var3_3 /* !! */  = var2_2;
            var2_2 = var11_8;
            var4_4 /* !! */  = var1_1;
            var1_1 = var3_3 /* !! */ ;
        }
        if (var4_4 /* !! */  != null && (var3_3 /* !! */  = var4_4 /* !! */ .getKey()) != null) {
            var2_2 = var2_2.smallIslandBuilderMap.put((String)var3_3 /* !! */ , (IslandTemplateBuilder)var1_1);
        }
        return var1_1.buildIslandView();
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final Object createBigIslandTemplate(Context var1_1, DynamicIslandData var2_3, IslandTemplate var3_4, ViewGroup var4_5, boolean var5_6, U0.o var6_7, d var7_8) {
        block8: {
            if (!(var7_8 /* !! */  instanceof createBigIslandTemplate.1)) ** GOTO lbl-1000
            var9_9 = var7_8 /* !! */ ;
            var8_10 = var9_9.label;
            if ((var8_10 & -2147483648) != 0) {
                var9_9.label = var8_10 + -2147483648;
                var7_8 /* !! */  = var9_9;
            } else lbl-1000:
            // 2 sources

            {
                var7_8 /* !! */  = new M0.d(this, var7_8 /* !! */ ){
                    int label;
                    Object result;
                    final IslandTemplateFactory this$0;
                    {
                        this.this$0 = islandTemplateFactory;
                        super(d2);
                    }

                    public final Object invokeSuspend(Object object) {
                        this.result = object;
                        this.label |= Integer.MIN_VALUE;
                        return this.this$0.createBigIslandTemplate(null, null, null, null, false, null, (d)this);
                    }
                };
            }
            var9_9 = var7_8 /* !! */ .result;
            var11_11 = c.c();
            var8_10 = var7_8 /* !! */ .label;
            var10_12 = null;
            if (var8_10 != 0) {
                if (var8_10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                try {
                    k.b((Object)var9_9);
                    var1_1 /* !! */  = var9_9;
                    return (View)var1_1 /* !! */ ;
                }
                catch (Exception var1_2) {
                    break block8;
                }
            }
            k.b((Object)var9_9);
            var9_9 = var2_3 /* !! */  != null ? var2_3 /* !! */ .getTickerData() : null;
            {
                var12_13 = CommonUtils.encodeDataToBase64((String)var9_9);
                var9_9 = new StringBuilder();
                var9_9.append("createBigIslandTemplate: ");
                var9_9.append(var12_13);
                Log.d((String)"IslandTemplateFactory", (String)var9_9.toString());
                var9_9 = var10_12;
                if (var3_4 == null) return var9_9;
                var7_8 /* !! */ .label = 1;
                var2_3 /* !! */  = this.createBigIslandTemplateView(var1_1 /* !! */ , var3_4, var2_3 /* !! */ , var4_5, var5_6, var6_7, var7_8 /* !! */ );
                var1_1 /* !! */  = var2_3 /* !! */ ;
                if (var2_3 /* !! */  != var11_11) return (View)var1_1 /* !! */ ;
                return var11_11;
            }
        }
        var1_2.printStackTrace();
        return null;
    }

    public final Object createSmallIslandTemplate(Context object, DynamicIslandData dynamicIslandData, IslandTemplate islandTemplate, ViewGroup viewGroup, boolean bl, U0.o o2, d d2) {
        if (islandTemplate != null) {
            if ((object = this.createSmallIslandTemplateView((Context)object, islandTemplate, dynamicIslandData, viewGroup, bl, o2, d2)) == c.c()) {
                return object;
            }
            object = (View)object;
        } else {
            object = null;
        }
        return object;
    }

    public final void hideView(DynamicIslandData object, boolean bl) {
        Object var6_3 = null;
        Object var5_4 = null;
        Object object2 = object != null ? object.getKey() : null;
        Map<String, IslandTemplateBuilder> map = object != null ? object.getProperties() : null;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("hideView ");
        stringBuilder.append((String)object2);
        stringBuilder.append(", prop ");
        stringBuilder.append(map);
        Log.d((String)TAG, (String)stringBuilder.toString());
        if (object == null || (object2 = object.getProperties()) == null || (Integer)object2 != 0) {
            if (bl) {
                map = this.fakeBigIslandBuilderMap;
                object2 = object != null ? object.getKey() : null;
                if (map.containsKey(object2)) {
                    map = this.fakeBigIslandBuilderMap;
                    object2 = object != null ? object.getKey() : null;
                    if ((object2 = map.get(object2)) != null) {
                        ((IslandTemplateBuilder)object2).hideModuleView();
                    }
                }
                if ((map = this.fakeSmallIslandBuilderMap).containsKey(object2 = object != null ? object.getKey() : null)) {
                    map = this.fakeSmallIslandBuilderMap;
                    object2 = var5_4;
                    if (object != null) {
                        object2 = object.getKey();
                    }
                    if ((object = map.get(object2)) != null) {
                        ((IslandTemplateBuilder)object).hideModuleView();
                    }
                }
            } else {
                map = this.bigIslandBuilderMap;
                object2 = object != null ? object.getKey() : null;
                if (map.containsKey(object2)) {
                    map = this.bigIslandBuilderMap;
                    object2 = object != null ? object.getKey() : null;
                    if ((object2 = map.get(object2)) != null) {
                        ((IslandTemplateBuilder)object2).hideModuleView();
                    }
                }
                if ((map = this.smallIslandBuilderMap).containsKey(object2 = object != null ? object.getKey() : null)) {
                    map = this.smallIslandBuilderMap;
                    object2 = var6_3;
                    if (object != null) {
                        object2 = object.getKey();
                    }
                    if ((object = map.get(object2)) != null) {
                        ((IslandTemplateBuilder)object).hideModuleView();
                    }
                }
            }
        }
    }

    public final void removeTemplate(String string) {
        Object object;
        Object object2;
        IslandTemplateBuilder islandTemplateBuilder;
        o.g((Object)string, (String)"key");
        if (this.bigIslandBuilderMap.containsKey(string)) {
            IslandTemplateBuilder islandTemplateBuilder2 = this.bigIslandBuilderMap.get(string);
            islandTemplateBuilder = this.fakeBigIslandBuilderMap.get(string);
            object2 = this.templateMap.get(string);
            if (object2 != null) {
                object = this.chooseModule((IslandTemplate)object2, AREA_LEFT);
                object2 = this.chooseModule((IslandTemplate)object2, AREA_RIGHT);
                if (islandTemplateBuilder2 != null && (islandTemplateBuilder2 = islandTemplateBuilder2.removeModuleView((String)object)) != null && (islandTemplateBuilder2 = islandTemplateBuilder2.removeModuleView((String)object2)) != null) {
                    islandTemplateBuilder2.removeIslandView();
                }
                if (islandTemplateBuilder != null && (islandTemplateBuilder = islandTemplateBuilder.removeModuleView((String)object)) != null && (object2 = islandTemplateBuilder.removeModuleView((String)object2)) != null) {
                    ((IslandTemplateBuilder)object2).removeIslandView();
                }
            }
        }
        this.bigIslandBuilderMap.remove(string);
        this.fakeBigIslandBuilderMap.remove(string);
        if (this.smallIslandBuilderMap.containsKey(string)) {
            islandTemplateBuilder = this.smallIslandBuilderMap.get(string);
            object2 = this.fakeSmallIslandBuilderMap.get(string);
            object = this.templateMap.get(string);
            if (object != null) {
                object = this.chooseModule((IslandTemplate)object, AREA_SMALL);
                if (islandTemplateBuilder != null && (islandTemplateBuilder = islandTemplateBuilder.removeModuleView((String)object)) != null) {
                    islandTemplateBuilder.removeIslandView();
                }
                if (object2 != null && (object2 = ((IslandTemplateBuilder)object2).removeModuleView((String)object)) != null) {
                    ((IslandTemplateBuilder)object2).removeIslandView();
                }
            }
        }
        this.smallIslandBuilderMap.remove(string);
        this.fakeSmallIslandBuilderMap.remove(string);
        this.templateMap.remove(string);
    }

    public final void showView(DynamicIslandData object, boolean bl) {
        Object var6_3 = null;
        Object var5_4 = null;
        Object object2 = object != null ? object.getKey() : null;
        Map<String, IslandTemplateBuilder> map = object != null ? object.getProperties() : null;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("showView ");
        stringBuilder.append((String)object2);
        stringBuilder.append(", prop ");
        stringBuilder.append(map);
        Log.d((String)TAG, (String)stringBuilder.toString());
        if (object == null || (object2 = object.getProperties()) == null || (Integer)object2 != 0) {
            if (bl) {
                map = this.fakeBigIslandBuilderMap;
                object2 = object != null ? object.getKey() : null;
                if (map.containsKey(object2)) {
                    map = this.fakeBigIslandBuilderMap;
                    object2 = object != null ? object.getKey() : null;
                    if ((object2 = map.get(object2)) != null) {
                        ((IslandTemplateBuilder)object2).showModuleView();
                    }
                }
                if ((map = this.fakeSmallIslandBuilderMap).containsKey(object2 = object != null ? object.getKey() : null)) {
                    map = this.fakeSmallIslandBuilderMap;
                    object2 = var5_4;
                    if (object != null) {
                        object2 = object.getKey();
                    }
                    if ((object = map.get(object2)) != null) {
                        ((IslandTemplateBuilder)object).showModuleView();
                    }
                }
            } else {
                map = this.bigIslandBuilderMap;
                object2 = object != null ? object.getKey() : null;
                if (map.containsKey(object2)) {
                    map = this.bigIslandBuilderMap;
                    object2 = object != null ? object.getKey() : null;
                    if ((object2 = map.get(object2)) != null) {
                        ((IslandTemplateBuilder)object2).showModuleView();
                    }
                }
                if ((map = this.smallIslandBuilderMap).containsKey(object2 = object != null ? object.getKey() : null)) {
                    map = this.smallIslandBuilderMap;
                    object2 = var6_3;
                    if (object != null) {
                        object2 = object.getKey();
                    }
                    if ((object = map.get(object2)) != null) {
                        ((IslandTemplateBuilder)object).showModuleView();
                    }
                }
            }
        }
    }

    public final void updateCutoutWidth(DynamicIslandData object, int n, boolean bl) {
        Object object2 = new StringBuilder();
        ((StringBuilder)object2).append("updateCutoutWidth ");
        ((StringBuilder)object2).append(n);
        ((StringBuilder)object2).append(" ");
        ((StringBuilder)object2).append(bl);
        Log.d((String)TAG, (String)((StringBuilder)object2).toString());
        Map<String, IslandTemplateBuilder> map = null;
        Map<String, IslandTemplateBuilder> map2 = null;
        if (bl) {
            map = this.fakeBigIslandBuilderMap;
            object2 = object != null ? object.getKey() : null;
            if (map.containsKey(object2)) {
                map = this.fakeBigIslandBuilderMap;
                object2 = map2;
                if (object != null) {
                    object2 = object.getKey();
                }
                if ((object = map.get(object2)) != null) {
                    ((IslandTemplateBuilder)object).updateCutoutWidth(n);
                }
            }
        } else {
            map2 = this.bigIslandBuilderMap;
            object2 = object != null ? object.getKey() : null;
            if (map2.containsKey(object2)) {
                map2 = this.bigIslandBuilderMap;
                object2 = map;
                if (object != null) {
                    object2 = object.getKey();
                }
                if ((object = map2.get(object2)) != null) {
                    ((IslandTemplateBuilder)object).updateCutoutWidth(n);
                }
            }
        }
    }

    public final void updateLeftWidth(DynamicIslandData object, int n, boolean bl) {
        Object object2 = new StringBuilder();
        ((StringBuilder)object2).append("updateLeftWidth ");
        ((StringBuilder)object2).append(n);
        Log.d((String)TAG, (String)((StringBuilder)object2).toString());
        Map<String, IslandTemplateBuilder> map = null;
        Map<String, IslandTemplateBuilder> map2 = null;
        if (bl) {
            map = this.fakeBigIslandBuilderMap;
            object2 = object != null ? object.getKey() : null;
            if (map.containsKey(object2)) {
                map = this.fakeBigIslandBuilderMap;
                object2 = map2;
                if (object != null) {
                    object2 = object.getKey();
                }
                if ((object = map.get(object2)) != null) {
                    ((IslandTemplateBuilder)object).updateLeftWidth(n);
                }
            }
        } else {
            map2 = this.bigIslandBuilderMap;
            object2 = object != null ? object.getKey() : null;
            if (map2.containsKey(object2)) {
                map2 = this.bigIslandBuilderMap;
                object2 = map;
                if (object != null) {
                    object2 = object.getKey();
                }
                if ((object = map2.get(object2)) != null) {
                    ((IslandTemplateBuilder)object).updateLeftWidth(n);
                }
            }
        }
    }

    public final void updateRightWidth(DynamicIslandData object, int n, boolean bl) {
        Object object2 = new StringBuilder();
        ((StringBuilder)object2).append("updateRightWidth ");
        ((StringBuilder)object2).append(n);
        Log.d((String)TAG, (String)((StringBuilder)object2).toString());
        Map<String, IslandTemplateBuilder> map = null;
        Map<String, IslandTemplateBuilder> map2 = null;
        if (bl) {
            map = this.fakeBigIslandBuilderMap;
            object2 = object != null ? object.getKey() : null;
            if (map.containsKey(object2)) {
                map = this.fakeBigIslandBuilderMap;
                object2 = map2;
                if (object != null) {
                    object2 = object.getKey();
                }
                if ((object = map.get(object2)) != null) {
                    ((IslandTemplateBuilder)object).updateRightWidth(n);
                }
            }
        } else {
            map2 = this.bigIslandBuilderMap;
            object2 = object != null ? object.getKey() : null;
            if (map2.containsKey(object2)) {
                map2 = this.bigIslandBuilderMap;
                object2 = map;
                if (object != null) {
                    object2 = object.getKey();
                }
                if ((object = map2.get(object2)) != null) {
                    ((IslandTemplateBuilder)object).updateRightWidth(n);
                }
            }
        }
    }
}
