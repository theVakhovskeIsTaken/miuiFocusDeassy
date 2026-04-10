/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.internal.o
 *  miui.systemui.animation.FolmeKt
 *  miui.systemui.util.CommonUtils
 *  miuix.animation.FolmeObject
 *  miuix.animation.base.AnimConfig
 *  miuix.animation.listener.TransitionListener
 *  miuix.animation.listener.UpdateInfo
 */
package miui.systemui.dynamicisland.anim;

import java.util.Collection;
import kotlin.jvm.internal.o;
import miui.systemui.animation.FolmeKt;
import miui.systemui.dynamicisland.anim.DynamicIslandAnimationCallback;
import miui.systemui.dynamicisland.anim.DynamicIslandAnimationCallbackType;
import miui.systemui.dynamicisland.anim.DynamicIslandAnimationDelegate;
import miui.systemui.dynamicisland.anim.DynamicIslandAnimationType;
import miui.systemui.dynamicisland.event.DynamicIslandEventCoordinator;
import miui.systemui.dynamicisland.event.handler.BigIslandStateHandler;
import miui.systemui.dynamicisland.window.content.DynamicIslandContentView;
import miui.systemui.util.CommonUtils;
import miuix.animation.FolmeObject;
import miuix.animation.base.AnimConfig;
import miuix.animation.listener.TransitionListener;
import miuix.animation.listener.UpdateInfo;

public static final class DynamicIslandAnimationDelegate.bigIslandScaleAnimation.1
extends TransitionListener {
    final float $bigIslandLeft;
    final DynamicIslandContentView $view;
    final DynamicIslandAnimationDelegate this$0;

    public DynamicIslandAnimationDelegate.bigIslandScaleAnimation.1(DynamicIslandAnimationDelegate dynamicIslandAnimationDelegate, float f, DynamicIslandContentView dynamicIslandContentView) {
        this.this$0 = dynamicIslandAnimationDelegate;
        this.$bigIslandLeft = f;
        this.$view = dynamicIslandContentView;
    }

    public void onBegin(Object object) {
        super.onBegin(object);
        DynamicIslandAnimationCallback dynamicIslandAnimationCallback = this.this$0.dynamicIslandAnimController.getAnimationCallback$miui_dynamicisland_release();
        DynamicIslandAnimationType dynamicIslandAnimationType = DynamicIslandAnimationType.ALL;
        DynamicIslandAnimationCallbackType dynamicIslandAnimationCallbackType = DynamicIslandAnimationCallbackType.ANIM_START;
        o.e((Object)object, (String)"null cannot be cast to non-null type kotlin.String");
        dynamicIslandAnimationCallback.executeCallback(dynamicIslandAnimationType, dynamicIslandAnimationCallbackType, (String)object);
    }

    public void onCancel(Object object) {
        super.onCancel(object);
        DynamicIslandAnimationCallback dynamicIslandAnimationCallback = this.this$0.dynamicIslandAnimController.getAnimationCallback$miui_dynamicisland_release();
        DynamicIslandAnimationType dynamicIslandAnimationType = DynamicIslandAnimationType.ALL;
        DynamicIslandAnimationCallbackType dynamicIslandAnimationCallbackType = DynamicIslandAnimationCallbackType.ANIM_CANCEL;
        o.e((Object)object, (String)"null cannot be cast to non-null type kotlin.String");
        dynamicIslandAnimationCallback.executeCallback(dynamicIslandAnimationType, dynamicIslandAnimationCallbackType, (String)object);
    }

    public void onComplete(Object object) {
        super.onComplete(object);
        Object object2 = this.$view.getExpandedView();
        if (object2 != null) {
            object2.setVisibility(4);
        }
        DynamicIslandAnimationCallback dynamicIslandAnimationCallback = this.this$0.dynamicIslandAnimController.getAnimationCallback$miui_dynamicisland_release();
        object2 = DynamicIslandAnimationType.ALL;
        DynamicIslandAnimationCallbackType dynamicIslandAnimationCallbackType = DynamicIslandAnimationCallbackType.ANIM_FINISH;
        o.e((Object)object, (String)"null cannot be cast to non-null type kotlin.String");
        dynamicIslandAnimationCallback.executeCallback((DynamicIslandAnimationType)((Object)object2), dynamicIslandAnimationCallbackType, (String)object);
        object = this.$view.getDynamicIslandEventCoordinator();
        object = object != null && (object = ((DynamicIslandEventCoordinator)object).getBigIslandStateHandler()) != null ? ((BigIslandStateHandler)object).getCurrent() : null;
        if (o.c((Object)object, (Object)((Object)this.$view))) {
            object = new AnimConfig();
            object2 = DynamicIslandAnimationDelegate.Companion;
            object = object.setSpecial(object2.getBIG_ISLAND_SCALE(), this.this$0.getEASE_SININOUT_025(), new float[0]).setSpecial(object2.getCONTAINER_CLIP_START_PROGRESS(), this.this$0.getEASE_SININOUT_025(), new float[0]).setSpecial(object2.getCONTAINER_CLIP_END_PROGRESS(), this.this$0.getEASE_SININOUT_025(), new float[0]).setSpecial(object2.getCONTAINER_CLIP_TOP_PROGRESS(), this.this$0.getEASE_SININOUT_025(), new float[0]).setSpecial(object2.getCONTAINER_CLIP_BOTTOM_PROGRESS(), this.this$0.getEASE_SININOUT_025(), new float[0]);
            FolmeKt.getFolme((FolmeObject)this.this$0).to((Object)this.this$0.getBigIslandZoomOutAnimState(), new AnimConfig[]{object.addListeners(new TransitionListener[]{new TransitionListener(this.this$0){
                final DynamicIslandAnimationDelegate this$0;
                {
                    this.this$0 = dynamicIslandAnimationDelegate;
                }

                public void onUpdate(Object object, Collection<UpdateInfo> collection) {
                    super.onUpdate(object, collection);
                    this.this$0.scheduleUpdate();
                }
            }})});
        }
    }

    public void onUpdate(Object object, Collection<UpdateInfo> collection) {
        super.onUpdate(object, collection);
        if (CommonUtils.INSTANCE.getIS_TABLET() && this.this$0.getBigIslandStart() != this.$bigIslandLeft) {
            FolmeKt.getFolme((FolmeObject)this.this$0).cancel();
            object = this.$view.getExpandedView();
            if (object != null) {
                object.setVisibility(4);
            }
            FolmeKt.getFolme((FolmeObject)this.this$0).setTo((Object)this.this$0.getBigIslandAnimState(), new AnimConfig[]{new AnimConfig().addListeners(new TransitionListener[]{new TransitionListener(this.this$0){
                final DynamicIslandAnimationDelegate this$0;
                {
                    this.this$0 = dynamicIslandAnimationDelegate;
                }

                public void onUpdate(Object object, Collection<? extends UpdateInfo> collection) {
                    super.onUpdate(object, collection);
                    this.this$0.scheduleUpdate();
                }
            }})});
        }
        this.this$0.scheduleUpdate();
    }
}
