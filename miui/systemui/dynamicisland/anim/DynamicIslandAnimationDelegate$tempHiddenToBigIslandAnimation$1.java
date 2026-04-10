/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  miui.systemui.animation.FolmeKt
 *  miui.systemui.util.CommonUtils
 *  miuix.animation.FolmeObject
 *  miuix.animation.listener.UpdateInfo
 */
package miui.systemui.dynamicisland.anim;

import java.util.Collection;
import miui.systemui.animation.FolmeKt;
import miui.systemui.dynamicisland.DynamicIslandScenarioUtils;
import miui.systemui.dynamicisland.anim.DynamicIslandAnimListener;
import miui.systemui.dynamicisland.anim.DynamicIslandAnimationDelegate;
import miui.systemui.dynamicisland.anim.DynamicIslandAnimationType;
import miui.systemui.dynamicisland.window.content.DynamicIslandContentView;
import miui.systemui.util.CommonUtils;
import miuix.animation.FolmeObject;
import miuix.animation.listener.UpdateInfo;

public static final class DynamicIslandAnimationDelegate.tempHiddenToBigIslandAnimation.1
extends DynamicIslandAnimListener {
    final float $bigIslandStart;
    final DynamicIslandContentView $view;
    final DynamicIslandAnimationDelegate this$0;

    public DynamicIslandAnimationDelegate.tempHiddenToBigIslandAnimation.1(DynamicIslandAnimationDelegate dynamicIslandAnimationDelegate, DynamicIslandContentView dynamicIslandContentView, float f) {
        this.this$0 = dynamicIslandAnimationDelegate;
        this.$view = dynamicIslandContentView;
        this.$bigIslandStart = f;
        super(dynamicIslandAnimationDelegate);
    }

    @Override
    public void onBegin(Object object) {
        super.onBegin(object);
        object = this.$view.getBigIslandView();
        if (object != null) {
            object.setVisibility(0);
        }
        this.this$0.animationDelegateHelper.requestUpdateHeadsUpLocation(DynamicIslandAnimationType.TEMP_HIDDEN_TO_BIG, this.$view);
        this.this$0.animationDelegateHelper.updateBigIslandContainerBackground(this.$view);
        DynamicIslandScenarioUtils.INSTANCE.setDynamicIslandScenarioState(434L, true);
    }

    @Override
    public void onCancel(Object object) {
        super.onCancel(object);
        if (CommonUtils.INSTANCE.getIS_TABLET() && this.this$0.getBigIslandStart() != this.$bigIslandStart) {
            FolmeKt.getFolme((FolmeObject)this.this$0).setTo((Object)this.this$0.getBigIslandAnimState());
        }
        DynamicIslandScenarioUtils.INSTANCE.setDynamicIslandScenarioState(434L, false);
    }

    @Override
    public void onComplete(Object object) {
        super.onComplete(object);
        DynamicIslandScenarioUtils.INSTANCE.setDynamicIslandScenarioState(434L, false);
    }

    @Override
    public void onUpdate(Object object, Collection<UpdateInfo> collection) {
        if (CommonUtils.INSTANCE.getIS_TABLET() && this.this$0.getBigIslandStart() != this.$bigIslandStart) {
            FolmeKt.getFolme((FolmeObject)this.this$0).cancel();
            FolmeKt.getFolme((FolmeObject)this.this$0).setTo((Object)this.this$0.getBigIslandAnimState());
        }
        super.onUpdate(object, collection);
    }
}
