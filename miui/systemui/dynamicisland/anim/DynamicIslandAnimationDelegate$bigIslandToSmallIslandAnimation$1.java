/*
 * Decompiled with CFR 0.152.
 */
package miui.systemui.dynamicisland.anim;

import miui.systemui.dynamicisland.DynamicIslandScenarioUtils;
import miui.systemui.dynamicisland.anim.DynamicIslandAnimListener;
import miui.systemui.dynamicisland.anim.DynamicIslandAnimationDelegate;

public static final class DynamicIslandAnimationDelegate.bigIslandToSmallIslandAnimation.1
extends DynamicIslandAnimListener {
    public DynamicIslandAnimationDelegate.bigIslandToSmallIslandAnimation.1(DynamicIslandAnimationDelegate dynamicIslandAnimationDelegate) {
        super(dynamicIslandAnimationDelegate);
    }

    @Override
    public void onBegin(Object object) {
        super.onBegin(object);
        DynamicIslandScenarioUtils.INSTANCE.setDynamicIslandScenarioState(436L, true);
    }

    @Override
    public void onCancel(Object object) {
        super.onCancel(object);
        object = DynamicIslandScenarioUtils.INSTANCE;
        if (((DynamicIslandScenarioUtils)object).isBigTracking()) {
            ((DynamicIslandScenarioUtils)object).setDynamicIslandScenarioState(494L, false);
            ((DynamicIslandScenarioUtils)object).setBigTracking(false);
        }
        ((DynamicIslandScenarioUtils)object).setDynamicIslandScenarioState(436L, false);
    }

    @Override
    public void onComplete(Object object) {
        super.onComplete(object);
        object = DynamicIslandScenarioUtils.INSTANCE;
        if (((DynamicIslandScenarioUtils)object).isBigTracking()) {
            ((DynamicIslandScenarioUtils)object).setDynamicIslandScenarioState(494L, false);
            ((DynamicIslandScenarioUtils)object).setBigTracking(false);
        }
        ((DynamicIslandScenarioUtils)object).setDynamicIslandScenarioState(436L, false);
    }
}
