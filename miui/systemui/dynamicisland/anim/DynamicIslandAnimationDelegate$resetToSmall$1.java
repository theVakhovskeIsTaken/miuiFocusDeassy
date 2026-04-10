/*
 * Decompiled with CFR 0.152.
 */
package miui.systemui.dynamicisland.anim;

import miui.systemui.dynamicisland.DynamicIslandScenarioUtils;
import miui.systemui.dynamicisland.anim.DynamicIslandAnimListener;
import miui.systemui.dynamicisland.anim.DynamicIslandAnimationDelegate;

public static final class DynamicIslandAnimationDelegate.resetToSmall.1
extends DynamicIslandAnimListener {
    public DynamicIslandAnimationDelegate.resetToSmall.1(DynamicIslandAnimationDelegate dynamicIslandAnimationDelegate) {
        super(dynamicIslandAnimationDelegate);
    }

    @Override
    public void onCancel(Object object) {
        DynamicIslandScenarioUtils dynamicIslandScenarioUtils = DynamicIslandScenarioUtils.INSTANCE;
        if (dynamicIslandScenarioUtils.isSmallTracking()) {
            dynamicIslandScenarioUtils.setDynamicIslandScenarioState(495L, false);
            dynamicIslandScenarioUtils.setSmallTracking(false);
        }
        super.onCancel(object);
    }

    @Override
    public void onComplete(Object object) {
        DynamicIslandScenarioUtils dynamicIslandScenarioUtils = DynamicIslandScenarioUtils.INSTANCE;
        if (dynamicIslandScenarioUtils.isSmallTracking()) {
            dynamicIslandScenarioUtils.setDynamicIslandScenarioState(495L, false);
            dynamicIslandScenarioUtils.setSmallTracking(false);
        }
        super.onComplete(object);
    }
}
