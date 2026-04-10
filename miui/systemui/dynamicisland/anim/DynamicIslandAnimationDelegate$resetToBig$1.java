/*
 * Decompiled with CFR 0.152.
 */
package miui.systemui.dynamicisland.anim;

import miui.systemui.dynamicisland.DynamicIslandScenarioUtils;
import miui.systemui.dynamicisland.anim.DynamicIslandAnimListener;
import miui.systemui.dynamicisland.anim.DynamicIslandAnimationDelegate;

public static final class DynamicIslandAnimationDelegate.resetToBig.1
extends DynamicIslandAnimListener {
    public DynamicIslandAnimationDelegate.resetToBig.1(DynamicIslandAnimationDelegate dynamicIslandAnimationDelegate) {
        super(dynamicIslandAnimationDelegate);
    }

    @Override
    public void onCancel(Object object) {
        DynamicIslandScenarioUtils dynamicIslandScenarioUtils = DynamicIslandScenarioUtils.INSTANCE;
        if (dynamicIslandScenarioUtils.isBigTracking()) {
            dynamicIslandScenarioUtils.setDynamicIslandScenarioState(494L, false);
            dynamicIslandScenarioUtils.setBigTracking(false);
        }
        super.onCancel(object);
    }

    @Override
    public void onComplete(Object object) {
        DynamicIslandScenarioUtils dynamicIslandScenarioUtils = DynamicIslandScenarioUtils.INSTANCE;
        if (dynamicIslandScenarioUtils.isBigTracking()) {
            dynamicIslandScenarioUtils.setDynamicIslandScenarioState(494L, false);
            dynamicIslandScenarioUtils.setBigTracking(false);
        }
        super.onComplete(object);
    }
}
