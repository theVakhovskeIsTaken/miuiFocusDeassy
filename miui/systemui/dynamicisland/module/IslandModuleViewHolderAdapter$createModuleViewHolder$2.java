/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  G0.k
 *  G0.s
 *  K0.d
 *  L0.c
 *  M0.f
 *  M0.l
 *  U0.o
 *  android.content.Context
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.ViewGroup
 *  f1.E
 *  kotlin.jvm.internal.z
 */
package miui.systemui.dynamicisland.module;

import G0.k;
import G0.s;
import K0.d;
import L0.c;
import M0.f;
import M0.l;
import U0.o;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import f1.E;
import kotlin.jvm.internal.z;
import miui.systemui.dynamicisland.R;
import miui.systemui.dynamicisland.model.IslandTemplate;
import miui.systemui.dynamicisland.module.BaseIslandModuleViewHolder;
import miui.systemui.dynamicisland.module.IslandModuleViewHolderAdapter;
import miui.systemui.dynamicisland.module.helper.IslandModuleViewLayoutResources;

@f(c="miui.systemui.dynamicisland.module.IslandModuleViewHolderAdapter$createModuleViewHolder$2", f="IslandModuleViewHolderAdapter.kt", l={129}, m="invokeSuspend")
public static final class IslandModuleViewHolderAdapter.createModuleViewHolder.2
extends l
implements o {
    final o $emitEvent;
    final IslandModuleViewLayoutResources $layoutHelper;
    final String $moduleType;
    final z $moduleViewHolder;
    final ViewGroup $rootView;
    final IslandTemplate $template;
    Object L$0;
    int label;
    final IslandModuleViewHolderAdapter this$0;

    public IslandModuleViewHolderAdapter.createModuleViewHolder.2(String string, z z2, IslandModuleViewHolderAdapter islandModuleViewHolderAdapter, ViewGroup viewGroup, o o2, IslandModuleViewLayoutResources islandModuleViewLayoutResources, IslandTemplate islandTemplate, d d2) {
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
}
