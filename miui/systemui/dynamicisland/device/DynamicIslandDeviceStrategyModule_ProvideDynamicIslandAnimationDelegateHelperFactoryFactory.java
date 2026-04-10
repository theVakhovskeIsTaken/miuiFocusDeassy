/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  E0.e
 *  E0.i
 *  F0.a
 */
package miui.systemui.dynamicisland.device;

import E0.e;
import E0.i;
import F0.a;
import miui.systemui.dynamicisland.device.DynamicIslandDeviceStrategyModule;
import miui.systemui.dynamicisland.device.strategy.DynamicIslandAnimationDelegateHelper;
import miui.systemui.dynamicisland.device.strategy.PadDynamicIslandAnimationDelegateHelper;
import miui.systemui.dynamicisland.device.strategy.PhoneDynamicIslandAnimationDelegateHelper;

public final class DynamicIslandDeviceStrategyModule_ProvideDynamicIslandAnimationDelegateHelperFactoryFactory
implements e {
    private final DynamicIslandDeviceStrategyModule module;
    private final a padFactoryProvider;
    private final a phoneFactoryProvider;

    public DynamicIslandDeviceStrategyModule_ProvideDynamicIslandAnimationDelegateHelperFactoryFactory(DynamicIslandDeviceStrategyModule dynamicIslandDeviceStrategyModule, a a2, a a3) {
        this.module = dynamicIslandDeviceStrategyModule;
        this.phoneFactoryProvider = a2;
        this.padFactoryProvider = a3;
    }

    public static DynamicIslandDeviceStrategyModule_ProvideDynamicIslandAnimationDelegateHelperFactoryFactory create(DynamicIslandDeviceStrategyModule dynamicIslandDeviceStrategyModule, a a2, a a3) {
        return new DynamicIslandDeviceStrategyModule_ProvideDynamicIslandAnimationDelegateHelperFactoryFactory(dynamicIslandDeviceStrategyModule, a2, a3);
    }

    public static DynamicIslandAnimationDelegateHelper.Factory provideDynamicIslandAnimationDelegateHelperFactory(DynamicIslandDeviceStrategyModule dynamicIslandDeviceStrategyModule, PhoneDynamicIslandAnimationDelegateHelper.Factory factory, PadDynamicIslandAnimationDelegateHelper.Factory factory2) {
        return (DynamicIslandAnimationDelegateHelper.Factory)i.d((Object)dynamicIslandDeviceStrategyModule.provideDynamicIslandAnimationDelegateHelperFactory(factory, factory2));
    }

    public DynamicIslandAnimationDelegateHelper.Factory get() {
        return DynamicIslandDeviceStrategyModule_ProvideDynamicIslandAnimationDelegateHelperFactoryFactory.provideDynamicIslandAnimationDelegateHelperFactory(this.module, (PhoneDynamicIslandAnimationDelegateHelper.Factory)this.phoneFactoryProvider.get(), (PadDynamicIslandAnimationDelegateHelper.Factory)this.padFactoryProvider.get());
    }
}
