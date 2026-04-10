/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.internal.o
 *  miui.systemui.util.CommonUtils
 */
package miui.systemui.dynamicisland.device;

import kotlin.jvm.internal.o;
import miui.systemui.dynamicisland.device.strategy.DynamicIslandAnimationDelegateHelper;
import miui.systemui.dynamicisland.device.strategy.PadDynamicIslandAnimationDelegateHelper;
import miui.systemui.dynamicisland.device.strategy.PhoneDynamicIslandAnimationDelegateHelper;
import miui.systemui.util.CommonUtils;

public final class DynamicIslandDeviceStrategyModule {
    public final DynamicIslandAnimationDelegateHelper.Factory provideDynamicIslandAnimationDelegateHelperFactory(PhoneDynamicIslandAnimationDelegateHelper.Factory factory, PadDynamicIslandAnimationDelegateHelper.Factory factory2) {
        o.g((Object)factory, (String)"phoneFactory");
        o.g((Object)factory2, (String)"padFactory");
        if (CommonUtils.INSTANCE.getIS_TABLET()) {
            factory = factory2;
        }
        return factory;
    }
}
