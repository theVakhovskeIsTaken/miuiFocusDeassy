/*
 * Decompiled with CFR 0.152.
 */
package miui.systemui.dynamicisland.anim;

import miui.systemui.dynamicisland.DynamicIslandScenarioUtils;
import miui.systemui.dynamicisland.anim.DynamicIslandAnimListener;
import miui.systemui.dynamicisland.anim.DynamicIslandAnimationDelegate;

public static final class DynamicIslandAnimationDelegate.smallIslandToHiddenAnimation.1
extends DynamicIslandAnimListener {
    public DynamicIslandAnimationDelegate.smallIslandToHiddenAnimation.1(DynamicIslandAnimationDelegate dynamicIslandAnimationDelegate) {
        super(dynamicIslandAnimationDelegate);
    }

    @Override
    public void onBegin(Object object) {
        super.onBegin(object);
        DynamicIslandScenarioUtils.INSTANCE.setDynamicIslandScenarioState(439L, true);
    }

    @Override
    public void onCancel(Object object) {
        super.onCancel(object);
        object = DynamicIslandScenarioUtils.INSTANCE;
        if (((DynamicIslandScenarioUtils)object).isSmallTracking()) {
            ((DynamicIslandScenarioUtils)object).setDynamicIslandScenarioState(495L, false);
            ((DynamicIslandScenarioUtils)object).setSmallTracking(false);
        }
        ((DynamicIslandScenarioUtils)object).setDynamicIslandScenarioState(439L, false);
    }

    @Override
    public void onComplete(Object object) {
        super.onComplete(object);
        object = DynamicIslandScenarioUtils.INSTANCE;
        if (((DynamicIslandScenarioUtils)object).isSmallTracking()) {
            ((DynamicIslandScenarioUtils)object).setDynamicIslandScenarioState(495L, false);
            ((DynamicIslandScenarioUtils)object).setSmallTracking(false);
        }
        ((DynamicIslandScenarioUtils)object).setDynamicIslandScenarioState(439L, false);
    }
}
