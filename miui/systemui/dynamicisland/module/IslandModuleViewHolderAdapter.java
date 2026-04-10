/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  G0.k
 *  G0.s
 *  K0.d
 *  K0.g
 *  L0.c
 *  U0.o
 *  android.content.Context
 *  android.util.Log
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.ViewGroup
 *  com.android.systemui.plugins.miui.dynamicisland.DynamicIslandData
 *  f1.E
 *  f1.f
 *  kotlin.jvm.internal.o
 *  kotlin.jvm.internal.z
 */
package miui.systemui.dynamicisland.module;

import G0.k;
import G0.s;
import K0.d;
import K0.g;
import L0.c;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.android.systemui.plugins.miui.dynamicisland.DynamicIslandData;
import f1.E;
import f1.f;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.o;
import kotlin.jvm.internal.z;
import miui.systemui.dynamicisland.DynamicIslandUtils;
import miui.systemui.dynamicisland.R;
import miui.systemui.dynamicisland.concurrency.dagger.qualifiers.IslandInflateThread;
import miui.systemui.dynamicisland.model.IslandTemplate;
import miui.systemui.dynamicisland.module.BaseIslandModuleViewHolder;
import miui.systemui.dynamicisland.module.IslandCombineImageViewHolder;
import miui.systemui.dynamicisland.module.IslandFixedWidthDigitViewHolder;
import miui.systemui.dynamicisland.module.IslandIconFixedWidthTextHolder;
import miui.systemui.dynamicisland.module.IslandIconViewHolder;
import miui.systemui.dynamicisland.module.IslandImageTextView2Holder;
import miui.systemui.dynamicisland.module.IslandImageTextView3Holder;
import miui.systemui.dynamicisland.module.IslandImageTextView4Holder;
import miui.systemui.dynamicisland.module.IslandImageTextViewHolder;
import miui.systemui.dynamicisland.module.IslandProgressTextViewHolder;
import miui.systemui.dynamicisland.module.IslandRightTextViewHolder;
import miui.systemui.dynamicisland.module.IslandSameWidthDigitViewHolder;
import miui.systemui.dynamicisland.module.IslandTextOverIconHolder;
import miui.systemui.dynamicisland.module.helper.IslandModuleViewLayoutResources;
import miui.systemui.dynamicisland.module.helper.PadIslandModuleViewLayoutResources;
import miui.systemui.dynamicisland.module.helper.PhoneIslandModuleViewLayoutResources;

public final class IslandModuleViewHolderAdapter {
    public static final Companion Companion = new Object(null){
        {
            this();
        }
    };
    private static final String TAG = "IslandModuleViewHolderAdapter";
    private final IslandCombineImageViewHolder.Factory combineImageViewHolderFactory;
    private final Context context;
    private final Map<String, IslandTemplate> dataMap;
    private final IslandFixedWidthDigitViewHolder.Factory fixedWidthDigitViewHolderFactory;
    private final Map<String, BaseIslandModuleViewHolder> holders;
    private final IslandIconFixedWidthTextHolder.Factory iconFixedWidthTextHolderFactory;
    private final IslandIconViewHolder.Factory iconViewHolderFactory;
    private final IslandImageTextView2Holder.Factory imageTextView2HolderFactory;
    private final IslandImageTextView3Holder.Factory imageTextView3HolderFactory;
    private final IslandImageTextView4Holder.Factory imageTextView4HolderFactory;
    private final IslandImageTextViewHolder.Factory imageTextViewHolderFactory;
    private final g inflateContext;
    private final IslandProgressTextViewHolder.Factory progressTextViewHolderFactory;
    private final IslandRightTextViewHolder.Factory rightTextViewHolderFactory;
    private final IslandSameWidthDigitViewHolder.Factory sameWidthDigitViewHolderFactory;
    private final IslandTextOverIconHolder.Factory textOverIconHolderFactory;

    public IslandModuleViewHolderAdapter(Context context, @IslandInflateThread g g2, IslandIconViewHolder.Factory factory, IslandImageTextViewHolder.Factory factory2, IslandImageTextView2Holder.Factory factory3, IslandImageTextView3Holder.Factory factory4, IslandImageTextView4Holder.Factory factory5, IslandProgressTextViewHolder.Factory factory6, IslandRightTextViewHolder.Factory factory7, IslandFixedWidthDigitViewHolder.Factory factory8, IslandSameWidthDigitViewHolder.Factory factory9, IslandCombineImageViewHolder.Factory factory10, IslandIconFixedWidthTextHolder.Factory factory11, IslandTextOverIconHolder.Factory factory12) {
        o.g((Object)context, (String)"context");
        o.g((Object)g2, (String)"inflateContext");
        o.g((Object)factory, (String)"iconViewHolderFactory");
        o.g((Object)factory2, (String)"imageTextViewHolderFactory");
        o.g((Object)factory3, (String)"imageTextView2HolderFactory");
        o.g((Object)factory4, (String)"imageTextView3HolderFactory");
        o.g((Object)factory5, (String)"imageTextView4HolderFactory");
        o.g((Object)factory6, (String)"progressTextViewHolderFactory");
        o.g((Object)factory7, (String)"rightTextViewHolderFactory");
        o.g((Object)factory8, (String)"fixedWidthDigitViewHolderFactory");
        o.g((Object)factory9, (String)"sameWidthDigitViewHolderFactory");
        o.g((Object)factory10, (String)"combineImageViewHolderFactory");
        o.g((Object)factory11, (String)"iconFixedWidthTextHolderFactory");
        o.g((Object)factory12, (String)"textOverIconHolderFactory");
        this.context = context;
        this.inflateContext = g2;
        this.iconViewHolderFactory = factory;
        this.imageTextViewHolderFactory = factory2;
        this.imageTextView2HolderFactory = factory3;
        this.imageTextView3HolderFactory = factory4;
        this.imageTextView4HolderFactory = factory5;
        this.progressTextViewHolderFactory = factory6;
        this.rightTextViewHolderFactory = factory7;
        this.fixedWidthDigitViewHolderFactory = factory8;
        this.sameWidthDigitViewHolderFactory = factory9;
        this.combineImageViewHolderFactory = factory10;
        this.iconFixedWidthTextHolderFactory = factory11;
        this.textOverIconHolderFactory = factory12;
        this.holders = new LinkedHashMap<String, BaseIslandModuleViewHolder>();
        this.dataMap = new LinkedHashMap<String, IslandTemplate>();
    }

    public static final /* synthetic */ IslandCombineImageViewHolder.Factory access$getCombineImageViewHolderFactory$p(IslandModuleViewHolderAdapter islandModuleViewHolderAdapter) {
        return islandModuleViewHolderAdapter.combineImageViewHolderFactory;
    }

    public static final /* synthetic */ Context access$getContext$p(IslandModuleViewHolderAdapter islandModuleViewHolderAdapter) {
        return islandModuleViewHolderAdapter.context;
    }

    public static final /* synthetic */ Map access$getDataMap$p(IslandModuleViewHolderAdapter islandModuleViewHolderAdapter) {
        return islandModuleViewHolderAdapter.dataMap;
    }

    public static final /* synthetic */ IslandFixedWidthDigitViewHolder.Factory access$getFixedWidthDigitViewHolderFactory$p(IslandModuleViewHolderAdapter islandModuleViewHolderAdapter) {
        return islandModuleViewHolderAdapter.fixedWidthDigitViewHolderFactory;
    }

    public static final /* synthetic */ Map access$getHolders$p(IslandModuleViewHolderAdapter islandModuleViewHolderAdapter) {
        return islandModuleViewHolderAdapter.holders;
    }

    public static final /* synthetic */ IslandIconFixedWidthTextHolder.Factory access$getIconFixedWidthTextHolderFactory$p(IslandModuleViewHolderAdapter islandModuleViewHolderAdapter) {
        return islandModuleViewHolderAdapter.iconFixedWidthTextHolderFactory;
    }

    public static final /* synthetic */ IslandIconViewHolder.Factory access$getIconViewHolderFactory$p(IslandModuleViewHolderAdapter islandModuleViewHolderAdapter) {
        return islandModuleViewHolderAdapter.iconViewHolderFactory;
    }

    public static final /* synthetic */ IslandImageTextView2Holder.Factory access$getImageTextView2HolderFactory$p(IslandModuleViewHolderAdapter islandModuleViewHolderAdapter) {
        return islandModuleViewHolderAdapter.imageTextView2HolderFactory;
    }

    public static final /* synthetic */ IslandImageTextView3Holder.Factory access$getImageTextView3HolderFactory$p(IslandModuleViewHolderAdapter islandModuleViewHolderAdapter) {
        return islandModuleViewHolderAdapter.imageTextView3HolderFactory;
    }

    public static final /* synthetic */ IslandImageTextView4Holder.Factory access$getImageTextView4HolderFactory$p(IslandModuleViewHolderAdapter islandModuleViewHolderAdapter) {
        return islandModuleViewHolderAdapter.imageTextView4HolderFactory;
    }

    public static final /* synthetic */ IslandImageTextViewHolder.Factory access$getImageTextViewHolderFactory$p(IslandModuleViewHolderAdapter islandModuleViewHolderAdapter) {
        return islandModuleViewHolderAdapter.imageTextViewHolderFactory;
    }

    public static final /* synthetic */ IslandProgressTextViewHolder.Factory access$getProgressTextViewHolderFactory$p(IslandModuleViewHolderAdapter islandModuleViewHolderAdapter) {
        return islandModuleViewHolderAdapter.progressTextViewHolderFactory;
    }

    public static final /* synthetic */ IslandRightTextViewHolder.Factory access$getRightTextViewHolderFactory$p(IslandModuleViewHolderAdapter islandModuleViewHolderAdapter) {
        return islandModuleViewHolderAdapter.rightTextViewHolderFactory;
    }

    public static final /* synthetic */ IslandSameWidthDigitViewHolder.Factory access$getSameWidthDigitViewHolderFactory$p(IslandModuleViewHolderAdapter islandModuleViewHolderAdapter) {
        return islandModuleViewHolderAdapter.sameWidthDigitViewHolderFactory;
    }

    public static final /* synthetic */ IslandTextOverIconHolder.Factory access$getTextOverIconHolderFactory$p(IslandModuleViewHolderAdapter islandModuleViewHolderAdapter) {
        return islandModuleViewHolderAdapter.textOverIconHolderFactory;
    }

    private final IslandModuleViewLayoutResources selectLayoutHelper(DynamicIslandData object) {
        if (object != null && DynamicIslandUtils.INSTANCE.isDynamicIslandPadNoPropOnce((DynamicIslandData)object)) {
            Log.d((String)TAG, (String)"createModuleViewHolder:isPad 1/2");
            object = PadIslandModuleViewLayoutResources.INSTANCE;
        } else {
            Log.d((String)TAG, (String)"createModuleViewHolder:isPhone or isPad 0");
            object = PhoneIslandModuleViewLayoutResources.INSTANCE;
        }
        return object;
    }

    public final void bindData(String object, DynamicIslandData dynamicIslandData) {
        o.g((Object)object, (String)"moduleType");
        int n = this.holders.size();
        Object object2 = new StringBuilder();
        ((StringBuilder)object2).append("bindData ");
        ((StringBuilder)object2).append((String)object);
        ((StringBuilder)object2).append(n);
        Log.e((String)TAG, (String)((StringBuilder)object2).toString());
        object2 = this.dataMap.get(object);
        if (object2 != null && (object = this.holders.get(object)) != null) {
            ((BaseIslandModuleViewHolder)object).bind((IslandTemplate)object2, dynamicIslandData);
        }
    }

    public final Object createModuleViewHolder(IslandTemplate islandTemplate, String string, ViewGroup viewGroup, U0.o o2, DynamicIslandData object, d d2) {
        IslandModuleViewLayoutResources islandModuleViewLayoutResources = this.selectLayoutHelper((DynamicIslandData)object);
        z z2 = new z();
        object = new StringBuilder();
        ((StringBuilder)object).append("createModuleViewHolder ");
        ((StringBuilder)object).append(string);
        Log.e((String)TAG, (String)((StringBuilder)object).toString());
        return f.c((g)this.inflateContext, (U0.o)new U0.o(string, z2, this, viewGroup, o2, islandModuleViewLayoutResources, islandTemplate, null){
            final U0.o $emitEvent;
            final IslandModuleViewLayoutResources $layoutHelper;
            final String $moduleType;
            final z $moduleViewHolder;
            final ViewGroup $rootView;
            final IslandTemplate $template;
            Object L$0;
            int label;
            final IslandModuleViewHolderAdapter this$0;
            {
                this.$moduleType = string;
                this.$moduleViewHolder = z2;
                this.this$0 = islandModuleViewHolderAdapter;
                this.$rootView = viewGroup;
                this.$emitEvent = o2;
                this.$layoutHelper = islandModuleViewLayoutResources;
                this.$template = islandTemplate;
                super(2, d2);
            }

            public final d create(Object object, d d2) {
                return new /* invalid duplicate definition of identical inner class */;
            }

            public final Object invoke(E e, d d2) {
                return (this.create(e, d2)).invokeSuspend(s.a);
            }

            /*
             * Unable to fully structure code
             * Could not resolve type clashes
             */
            public final Object invokeSuspend(Object var1_1) {
                block26: {
                    block23: {
                        block24: {
                            block25: {
                                block21: {
                                    block22: {
                                        var5_2 = c.c();
                                        var2_3 = this.label;
                                        var4_4 = null;
                                        if (var2_3 == 0) break block21;
                                        if (var2_3 != 1) break block22;
                                        var3_5 /* !! */  = (View)this.L$0;
                                        k.b((Object)var1_1);
                                        var1_1 = var3_5 /* !! */ ;
                                        break block23;
                                    }
                                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                }
                                k.b((Object)var1_1);
                                var1_1 = this.$moduleType;
                                switch (var1_1.hashCode()) {
                                    default: {
                                        break;
                                    }
                                    case 1453082694: {
                                        if (!var1_1.equals("moduleTextOverIcon")) break;
                                        this.$moduleViewHolder.a = IslandModuleViewHolderAdapter.access$getTextOverIconHolderFactory$p(this.this$0).create(this.$rootView, this.$emitEvent);
                                        var1_1 = LayoutInflater.from((Context)IslandModuleViewHolderAdapter.access$getContext$p(this.this$0)).inflate(R.layout.dynamic_island_module_text_over_icon, this.$rootView, false);
                                        break block24;
                                    }
                                    case 1434791964: {
                                        if (!var1_1.equals("moduleImageText")) break;
                                        this.$moduleViewHolder.a = IslandModuleViewHolderAdapter.access$getProgressTextViewHolderFactory$p(this.this$0).create(this.$rootView, this.$emitEvent);
                                        var1_1 = LayoutInflater.from((Context)IslandModuleViewHolderAdapter.access$getContext$p(this.this$0)).inflate(this.$layoutHelper.getModuleProgressText(), this.$rootView, false);
                                        break block24;
                                    }
                                    case 1279391119: {
                                        if (!var1_1.equals("moduleFixedWidthDigit")) break;
                                        this.$moduleViewHolder.a = IslandModuleViewHolderAdapter.access$getFixedWidthDigitViewHolderFactory$p(this.this$0).create(this.$rootView, this.$emitEvent);
                                        var1_1 = LayoutInflater.from((Context)IslandModuleViewHolderAdapter.access$getContext$p(this.this$0)).inflate(this.$layoutHelper.getModuleFixedWidthDigit(), this.$rootView, false);
                                        break block24;
                                    }
                                    case 1170007381: {
                                        if (!var1_1.equals("moduleSmallTextOverIcon")) break;
                                        this.$moduleViewHolder.a = IslandModuleViewHolderAdapter.access$getTextOverIconHolderFactory$p(this.this$0).create(this.$rootView, this.$emitEvent);
                                        var1_1 = LayoutInflater.from((Context)IslandModuleViewHolderAdapter.access$getContext$p(this.this$0)).inflate(R.layout.dynamic_island_module_text_over_icon, this.$rootView, false);
                                        break block24;
                                    }
                                    case 496193380: {
                                        if (!var1_1.equals("moduleIconFixedWidthText")) break;
                                        this.$moduleViewHolder.a = IslandModuleViewHolderAdapter.access$getIconFixedWidthTextHolderFactory$p(this.this$0).create(this.$rootView, this.$emitEvent);
                                        var1_1 = LayoutInflater.from((Context)IslandModuleViewHolderAdapter.access$getContext$p(this.this$0)).inflate(this.$layoutHelper.getModuleIconFixedWidthText(), this.$rootView, false);
                                        break block24;
                                    }
                                    case 150578385: {
                                        if (!var1_1.equals("moduleImageText_4")) break;
                                        this.$moduleViewHolder.a = IslandModuleViewHolderAdapter.access$getImageTextView4HolderFactory$p(this.this$0).create(this.$rootView, this.$emitEvent);
                                        var1_1 = LayoutInflater.from((Context)IslandModuleViewHolderAdapter.access$getContext$p(this.this$0)).inflate(R.layout.dynamic_island_module_image_text_4, this.$rootView, false);
                                        break block24;
                                    }
                                    case 150578384: {
                                        if (!var1_1.equals("moduleImageText_3")) break;
                                        this.$moduleViewHolder.a = IslandModuleViewHolderAdapter.access$getImageTextView3HolderFactory$p(this.this$0).create(this.$rootView, this.$emitEvent);
                                        var1_1 = LayoutInflater.from((Context)IslandModuleViewHolderAdapter.access$getContext$p(this.this$0)).inflate(this.$layoutHelper.getModuleImageText3(), this.$rootView, false);
                                        break block24;
                                    }
                                    case 150578383: {
                                        if (!var1_1.equals("moduleImageText_2")) break;
                                        this.$moduleViewHolder.a = IslandModuleViewHolderAdapter.access$getImageTextView2HolderFactory$p(this.this$0).create(this.$rootView, this.$emitEvent);
                                        var1_1 = LayoutInflater.from((Context)IslandModuleViewHolderAdapter.access$getContext$p(this.this$0)).inflate(this.$layoutHelper.getModuleImageText2(), this.$rootView, false);
                                        break block24;
                                    }
                                    case 150578382: {
                                        if (!var1_1.equals("moduleImageText_1")) break;
                                        this.$moduleViewHolder.a = IslandModuleViewHolderAdapter.access$getImageTextViewHolderFactory$p(this.this$0).create(this.$rootView, this.$emitEvent);
                                        var1_1 = LayoutInflater.from((Context)IslandModuleViewHolderAdapter.access$getContext$p(this.this$0)).inflate(this.$layoutHelper.getModuleImageText1(), this.$rootView, false);
                                        break block24;
                                    }
                                    case -870168135: {
                                        if (!var1_1.equals("moduleText")) break;
                                        this.$moduleViewHolder.a = IslandModuleViewHolderAdapter.access$getRightTextViewHolderFactory$p(this.this$0).create(this.$rootView, this.$emitEvent);
                                        var1_1 = LayoutInflater.from((Context)IslandModuleViewHolderAdapter.access$getContext$p(this.this$0)).inflate(this.$layoutHelper.getModuleRightText(), this.$rootView, false);
                                        break block24;
                                    }
                                    case -962289255: {
                                        if (!var1_1.equals("moduleSameWidthDigit")) break;
                                        this.$moduleViewHolder.a = IslandModuleViewHolderAdapter.access$getSameWidthDigitViewHolderFactory$p(this.this$0).create(this.$rootView, this.$emitEvent);
                                        var1_1 = LayoutInflater.from((Context)IslandModuleViewHolderAdapter.access$getContext$p(this.this$0)).inflate(this.$layoutHelper.getModuleSameWidthDigit(), this.$rootView, false);
                                        break block24;
                                    }
                                    case -1472124073: {
                                        if (!var1_1.equals("moduleCombinePic")) break;
                                        this.$moduleViewHolder.a = IslandModuleViewHolderAdapter.access$getCombineImageViewHolderFactory$p(this.this$0).create(this.$rootView, this.$emitEvent);
                                        var1_1 = LayoutInflater.from((Context)IslandModuleViewHolderAdapter.access$getContext$p(this.this$0)).inflate(R.layout.dynamic_island_module_combine_image, this.$rootView, false);
                                        break block24;
                                    }
                                    case -1552094338: {
                                        if (!var1_1.equals("modulePic")) break;
                                        this.$moduleViewHolder.a = IslandModuleViewHolderAdapter.access$getIconViewHolderFactory$p(this.this$0).create(this.$rootView, this.$emitEvent);
                                        var1_1 = LayoutInflater.from((Context)IslandModuleViewHolderAdapter.access$getContext$p(this.this$0)).inflate(this.$layoutHelper.getModulePic(), this.$rootView, false);
                                        break block24;
                                    }
                                    case -1848403042: {
                                        if (var1_1.equals("modulePicSmallIsland")) break block25;
                                    }
                                }
                                var1_1 = null;
                                break block24;
                            }
                            this.$moduleViewHolder.a = IslandModuleViewHolderAdapter.access$getIconViewHolderFactory$p(this.this$0).create(this.$rootView, this.$emitEvent);
                            var1_1 = LayoutInflater.from((Context)IslandModuleViewHolderAdapter.access$getContext$p(this.this$0)).inflate(this.$layoutHelper.getModulePic(), this.$rootView, false);
                        }
                        var3_5 /* !! */  = var1_1;
                        if (var1_1 != null) {
                            var3_5 /* !! */  = this.$moduleViewHolder;
                            var6_6 = this.$moduleType;
                            var7_7 = (BaseIslandModuleViewHolder)var3_5 /* !! */ .a;
                            var3_5 /* !! */  = var1_1;
                            if (var7_7 != null) {
                                this.L$0 = var1_1;
                                this.label = 1;
                                if (var7_7.initLayout((View)var1_1, var6_6, (d)this) == var5_2) {
                                    return var5_2;
                                } else {
                                    ** GOTO lbl103
                                }
                            }
                        }
                        break block26;
                    }
                    var3_5 /* !! */  = var1_1;
                }
                var5_2 = (BaseIslandModuleViewHolder)this.$moduleViewHolder.a;
                var1_1 = var4_4;
                if (var5_2 != null) {
                    var1_1 = var5_2.getView();
                }
                if (var1_1 != null) {
                    var1_1.setLayoutDirection(IslandModuleViewHolderAdapter.access$getContext$p(this.this$0).getResources().getConfiguration().getLayoutDirection());
                }
                IslandModuleViewHolderAdapter.access$getHolders$p(this.this$0).put(this.$moduleType, this.$moduleViewHolder.a);
                IslandModuleViewHolderAdapter.access$getDataMap$p(this.this$0).put(this.$moduleType, this.$template);
                return var3_5 /* !! */ ;
            }
        }, (d)d2);
    }

    public final void hiddenView(String object) {
        if ((object = this.holders.get(object)) != null) {
            ((BaseIslandModuleViewHolder)object).onHidden();
        }
    }

    public final void initView(String string) {
        o.g((Object)string, (String)"moduleType");
        int n = this.holders.size();
        Object object = new StringBuilder();
        ((StringBuilder)object).append("initView ");
        ((StringBuilder)object).append(string);
        ((StringBuilder)object).append(n);
        Log.e((String)TAG, (String)((StringBuilder)object).toString());
        object = this.holders.get(string);
        if (object != null) {
            ((BaseIslandModuleViewHolder)object).initView(string);
        }
    }

    public final void removeView(String object) {
        o.g((Object)object, (String)"moduleType");
        object = this.holders.remove(object);
        if (object != null) {
            ((BaseIslandModuleViewHolder)object).onDetach();
        }
    }

    public final void showView(String object) {
        if ((object = this.holders.get(object)) != null) {
            ((BaseIslandModuleViewHolder)object).onShow();
        }
    }

    public final void updateLeftWidth(String object, int n) {
        int n2 = this.holders.size();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("updateLeftWidth:");
        stringBuilder.append((String)object);
        stringBuilder.append(", holders.size:");
        stringBuilder.append(n2);
        stringBuilder.append(", width:");
        stringBuilder.append(n);
        Log.d((String)TAG, (String)stringBuilder.toString());
        object = this.holders.get(object);
        if (object != null) {
            ((BaseIslandModuleViewHolder)object).updateWidth(n);
        }
    }

    public final void updateRightWidth(String object, int n) {
        int n2 = this.holders.size();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("updateRightWidth:");
        stringBuilder.append((String)object);
        stringBuilder.append(", holders.size:");
        stringBuilder.append(n2);
        stringBuilder.append(", width:");
        stringBuilder.append(n);
        Log.d((String)TAG, (String)stringBuilder.toString());
        object = this.holders.get(object);
        if (object != null) {
            ((BaseIslandModuleViewHolder)object).updateWidth(n);
        }
    }

    public final void updateView(String string, IslandTemplate object, DynamicIslandData dynamicIslandData) {
        o.g((Object)string, (String)"moduleType");
        o.g((Object)object, (String)"template");
        this.dataMap.put(string, (IslandTemplate)object);
        BaseIslandModuleViewHolder baseIslandModuleViewHolder = this.holders.get(string);
        if (baseIslandModuleViewHolder != null) {
            baseIslandModuleViewHolder.updatePartial((IslandTemplate)object, dynamicIslandData);
        }
        int n = this.holders.size();
        object = new StringBuilder();
        ((StringBuilder)object).append("updateView");
        ((StringBuilder)object).append(string);
        ((StringBuilder)object).append(n);
        Log.e((String)TAG, (String)((StringBuilder)object).toString());
    }
}
