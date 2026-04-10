/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  E0.e
 *  F0.a
 *  K0.g
 *  android.content.Context
 */
package miui.systemui.dynamicisland.module;

import E0.e;
import F0.a;
import K0.g;
import android.content.Context;
import miui.systemui.dynamicisland.module.IslandCombineImageViewHolder;
import miui.systemui.dynamicisland.module.IslandFixedWidthDigitViewHolder;
import miui.systemui.dynamicisland.module.IslandIconFixedWidthTextHolder;
import miui.systemui.dynamicisland.module.IslandIconViewHolder;
import miui.systemui.dynamicisland.module.IslandImageTextView2Holder;
import miui.systemui.dynamicisland.module.IslandImageTextView3Holder;
import miui.systemui.dynamicisland.module.IslandImageTextView4Holder;
import miui.systemui.dynamicisland.module.IslandImageTextViewHolder;
import miui.systemui.dynamicisland.module.IslandModuleViewHolderAdapter;
import miui.systemui.dynamicisland.module.IslandProgressTextViewHolder;
import miui.systemui.dynamicisland.module.IslandRightTextViewHolder;
import miui.systemui.dynamicisland.module.IslandSameWidthDigitViewHolder;
import miui.systemui.dynamicisland.module.IslandTextOverIconHolder;

public final class IslandModuleViewHolderAdapter_Factory
implements e {
    private final a combineImageViewHolderFactoryProvider;
    private final a contextProvider;
    private final a fixedWidthDigitViewHolderFactoryProvider;
    private final a iconFixedWidthTextHolderFactoryProvider;
    private final a iconViewHolderFactoryProvider;
    private final a imageTextView2HolderFactoryProvider;
    private final a imageTextView3HolderFactoryProvider;
    private final a imageTextView4HolderFactoryProvider;
    private final a imageTextViewHolderFactoryProvider;
    private final a inflateContextProvider;
    private final a progressTextViewHolderFactoryProvider;
    private final a rightTextViewHolderFactoryProvider;
    private final a sameWidthDigitViewHolderFactoryProvider;
    private final a textOverIconHolderFactoryProvider;

    public IslandModuleViewHolderAdapter_Factory(a a2, a a3, a a4, a a5, a a6, a a7, a a8, a a9, a a10, a a11, a a12, a a13, a a14, a a15) {
        this.contextProvider = a2;
        this.inflateContextProvider = a3;
        this.iconViewHolderFactoryProvider = a4;
        this.imageTextViewHolderFactoryProvider = a5;
        this.imageTextView2HolderFactoryProvider = a6;
        this.imageTextView3HolderFactoryProvider = a7;
        this.imageTextView4HolderFactoryProvider = a8;
        this.progressTextViewHolderFactoryProvider = a9;
        this.rightTextViewHolderFactoryProvider = a10;
        this.fixedWidthDigitViewHolderFactoryProvider = a11;
        this.sameWidthDigitViewHolderFactoryProvider = a12;
        this.combineImageViewHolderFactoryProvider = a13;
        this.iconFixedWidthTextHolderFactoryProvider = a14;
        this.textOverIconHolderFactoryProvider = a15;
    }

    public static IslandModuleViewHolderAdapter_Factory create(a a2, a a3, a a4, a a5, a a6, a a7, a a8, a a9, a a10, a a11, a a12, a a13, a a14, a a15) {
        return new IslandModuleViewHolderAdapter_Factory(a2, a3, a4, a5, a6, a7, a8, a9, a10, a11, a12, a13, a14, a15);
    }

    public static IslandModuleViewHolderAdapter newInstance(Context context, g g2, IslandIconViewHolder.Factory factory, IslandImageTextViewHolder.Factory factory2, IslandImageTextView2Holder.Factory factory3, IslandImageTextView3Holder.Factory factory4, IslandImageTextView4Holder.Factory factory5, IslandProgressTextViewHolder.Factory factory6, IslandRightTextViewHolder.Factory factory7, IslandFixedWidthDigitViewHolder.Factory factory8, IslandSameWidthDigitViewHolder.Factory factory9, IslandCombineImageViewHolder.Factory factory10, IslandIconFixedWidthTextHolder.Factory factory11, IslandTextOverIconHolder.Factory factory12) {
        return new IslandModuleViewHolderAdapter(context, g2, factory, factory2, factory3, factory4, factory5, factory6, factory7, factory8, factory9, factory10, factory11, factory12);
    }

    public IslandModuleViewHolderAdapter get() {
        return IslandModuleViewHolderAdapter_Factory.newInstance((Context)this.contextProvider.get(), (g)this.inflateContextProvider.get(), (IslandIconViewHolder.Factory)this.iconViewHolderFactoryProvider.get(), (IslandImageTextViewHolder.Factory)this.imageTextViewHolderFactoryProvider.get(), (IslandImageTextView2Holder.Factory)this.imageTextView2HolderFactoryProvider.get(), (IslandImageTextView3Holder.Factory)this.imageTextView3HolderFactoryProvider.get(), (IslandImageTextView4Holder.Factory)this.imageTextView4HolderFactoryProvider.get(), (IslandProgressTextViewHolder.Factory)this.progressTextViewHolderFactoryProvider.get(), (IslandRightTextViewHolder.Factory)this.rightTextViewHolderFactoryProvider.get(), (IslandFixedWidthDigitViewHolder.Factory)this.fixedWidthDigitViewHolderFactoryProvider.get(), (IslandSameWidthDigitViewHolder.Factory)this.sameWidthDigitViewHolderFactoryProvider.get(), (IslandCombineImageViewHolder.Factory)this.combineImageViewHolderFactoryProvider.get(), (IslandIconFixedWidthTextHolder.Factory)this.iconFixedWidthTextHolderFactoryProvider.get(), (IslandTextOverIconHolder.Factory)this.textOverIconHolderFactoryProvider.get());
    }
}
