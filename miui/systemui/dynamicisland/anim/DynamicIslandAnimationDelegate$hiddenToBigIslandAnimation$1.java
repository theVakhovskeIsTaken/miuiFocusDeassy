/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.util.Log
 *  miuix.animation.listener.UpdateInfo
 */
package miui.systemui.dynamicisland.anim;

import android.util.Log;
import java.util.Collection;
import miui.systemui.dynamicisland.DynamicIslandScenarioUtils;
import miui.systemui.dynamicisland.anim.DynamicIslandAnimListener;
import miui.systemui.dynamicisland.anim.DynamicIslandAnimationDelegate;
import miui.systemui.dynamicisland.event.DynamicIslandState;
import miui.systemui.dynamicisland.window.content.DynamicIslandContentView;
import miuix.animation.listener.UpdateInfo;

public static final class DynamicIslandAnimationDelegate.hiddenToBigIslandAnimation.1
extends DynamicIslandAnimListener {
    final float $beginX;
    final DynamicIslandContentView $view;
    final DynamicIslandAnimationDelegate this$0;

    public DynamicIslandAnimationDelegate.hiddenToBigIslandAnimation.1(DynamicIslandAnimationDelegate dynamicIslandAnimationDelegate, DynamicIslandContentView dynamicIslandContentView, float f) {
        this.this$0 = dynamicIslandAnimationDelegate;
        this.$view = dynamicIslandContentView;
        this.$beginX = f;
        super(dynamicIslandAnimationDelegate);
    }

    @Override
    public void onBegin(Object object) {
        super.onBegin(object);
        this.this$0.setViewVisible(this.$view, 0);
        DynamicIslandScenarioUtils.INSTANCE.setDynamicIslandScenarioState(434L, true);
        this.this$0.animationDelegateHelper.updateBigIslandContainerBackground(this.$view);
    }

    @Override
    public void onCancel(Object object) {
        super.onCancel(object);
        DynamicIslandScenarioUtils.INSTANCE.setDynamicIslandScenarioState(434L, false);
        if (!this.$view.isExpanded()) {
            object = this.this$0.TAG;
            DynamicIslandState dynamicIslandState = this.$view.getState();
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("hiddenToBigIslandAnimation onCancel: state = ");
            stringBuilder.append(dynamicIslandState);
            Log.d((String)object, (String)stringBuilder.toString());
            object = this.$view.getExpandedView();
            if (object != null) {
                object.setVisibility(4);
            }
        }
    }

    @Override
    public void onComplete(Object object) {
        super.onComplete(object);
        DynamicIslandScenarioUtils.INSTANCE.setDynamicIslandScenarioState(434L, false);
        object = this.$view.getExpandedView();
        if (object != null) {
            object.setVisibility(4);
        }
    }

    @Override
    public void onUpdate(Object object, Collection<UpdateInfo> collection) {
        this.this$0.fixTransX(collection, this.$beginX);
        super.onUpdate(object, collection);
    }
}
