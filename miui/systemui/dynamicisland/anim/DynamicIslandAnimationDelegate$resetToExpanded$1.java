/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.internal.o
 */
package miui.systemui.dynamicisland.anim;

import kotlin.jvm.internal.o;
import miui.systemui.dynamicisland.DynamicIslandScenarioUtils;
import miui.systemui.dynamicisland.anim.DynamicIslandAnimListener;
import miui.systemui.dynamicisland.anim.DynamicIslandAnimationCallback;
import miui.systemui.dynamicisland.anim.DynamicIslandAnimationCallbackType;
import miui.systemui.dynamicisland.anim.DynamicIslandAnimationDelegate;
import miui.systemui.dynamicisland.anim.DynamicIslandAnimationType;

public static final class DynamicIslandAnimationDelegate.resetToExpanded.1
extends DynamicIslandAnimListener {
    final DynamicIslandAnimationDelegate this$0;

    public DynamicIslandAnimationDelegate.resetToExpanded.1(DynamicIslandAnimationDelegate dynamicIslandAnimationDelegate) {
        this.this$0 = dynamicIslandAnimationDelegate;
        super(dynamicIslandAnimationDelegate);
    }

    @Override
    public void onBegin(Object object) {
        super.onBegin(object);
        DynamicIslandAnimationCallback dynamicIslandAnimationCallback = this.this$0.dynamicIslandAnimController.getAnimationCallback$miui_dynamicisland_release();
        DynamicIslandAnimationType dynamicIslandAnimationType = DynamicIslandAnimationType.TO_EXPANDED;
        DynamicIslandAnimationCallbackType dynamicIslandAnimationCallbackType = DynamicIslandAnimationCallbackType.ANIM_START;
        o.e((Object)object, (String)"null cannot be cast to non-null type kotlin.String");
        dynamicIslandAnimationCallback.executeCallback(dynamicIslandAnimationType, dynamicIslandAnimationCallbackType, (String)object);
        this.this$0.setAnimateExpanding(true);
    }

    @Override
    public void onCancel(Object object) {
        super.onCancel(object);
        object = DynamicIslandScenarioUtils.INSTANCE;
        if (((DynamicIslandScenarioUtils)object).isExpandTracking()) {
            ((DynamicIslandScenarioUtils)object).setDynamicIslandScenarioState(496L, false);
            ((DynamicIslandScenarioUtils)object).setExpandTracking(false);
        }
        this.this$0.setAnimateExpanding(false);
    }

    @Override
    public void onComplete(Object object) {
        super.onComplete(object);
        DynamicIslandAnimationCallback dynamicIslandAnimationCallback = this.this$0.dynamicIslandAnimController.getAnimationCallback$miui_dynamicisland_release();
        DynamicIslandAnimationType dynamicIslandAnimationType = DynamicIslandAnimationType.TO_EXPANDED;
        DynamicIslandAnimationCallbackType dynamicIslandAnimationCallbackType = DynamicIslandAnimationCallbackType.ANIM_FINISH;
        o.e((Object)object, (String)"null cannot be cast to non-null type kotlin.String");
        dynamicIslandAnimationCallback.executeCallback(dynamicIslandAnimationType, dynamicIslandAnimationCallbackType, (String)object);
        object = DynamicIslandScenarioUtils.INSTANCE;
        if (((DynamicIslandScenarioUtils)object).isExpandTracking()) {
            ((DynamicIslandScenarioUtils)object).setDynamicIslandScenarioState(496L, false);
            ((DynamicIslandScenarioUtils)object).setExpandTracking(false);
        }
        this.this$0.setAnimateExpanding(false);
    }
}
