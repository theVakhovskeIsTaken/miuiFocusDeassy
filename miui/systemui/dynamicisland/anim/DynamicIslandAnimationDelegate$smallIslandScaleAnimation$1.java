/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.internal.o
 *  miui.systemui.animation.FolmeKt
 *  miuix.animation.FolmeEase
 *  miuix.animation.FolmeObject
 *  miuix.animation.base.AnimConfig
 *  miuix.animation.controller.AnimState
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
import miui.systemui.dynamicisland.event.handler.SmallIslandStateHandler;
import miui.systemui.dynamicisland.window.content.DynamicIslandContentView;
import miuix.animation.FolmeEase;
import miuix.animation.FolmeObject;
import miuix.animation.base.AnimConfig;
import miuix.animation.controller.AnimState;
import miuix.animation.listener.TransitionListener;
import miuix.animation.listener.UpdateInfo;

public static final class DynamicIslandAnimationDelegate.smallIslandScaleAnimation.1
extends TransitionListener {
    final DynamicIslandContentView $view;
    final DynamicIslandAnimationDelegate this$0;

    public DynamicIslandAnimationDelegate.smallIslandScaleAnimation.1(DynamicIslandAnimationDelegate dynamicIslandAnimationDelegate, DynamicIslandContentView dynamicIslandContentView) {
        this.this$0 = dynamicIslandAnimationDelegate;
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
        Object object2 = this.this$0.dynamicIslandAnimController.getAnimationCallback$miui_dynamicisland_release();
        DynamicIslandAnimationType dynamicIslandAnimationType = DynamicIslandAnimationType.ALL;
        DynamicIslandAnimationCallbackType dynamicIslandAnimationCallbackType = DynamicIslandAnimationCallbackType.ANIM_FINISH;
        o.e((Object)object, (String)"null cannot be cast to non-null type kotlin.String");
        ((DynamicIslandAnimationCallback)object2).executeCallback(dynamicIslandAnimationType, dynamicIslandAnimationCallbackType, (String)object);
        object = this.$view.getDynamicIslandEventCoordinator();
        object = object != null && (object = ((DynamicIslandEventCoordinator)object).getSmallIslandStateHandler()) != null ? ((SmallIslandStateHandler)object).getCurrent() : null;
        if (o.c((Object)object, (Object)((Object)this.$view))) {
            object = FolmeKt.getFolme((FolmeObject)this.this$0);
            dynamicIslandAnimationType = new AnimState();
            object2 = DynamicIslandAnimationDelegate.Companion;
            object.to((Object)dynamicIslandAnimationType.add(object2.getSMALL_ISLAND_SCALE(), 1.0f, new long[0]).add(object2.getCONTAINER_CLIP_START_PROGRESS(), this.this$0.getSmallIslandStart(), new long[0]).add(object2.getCONTAINER_CLIP_END_PROGRESS(), this.this$0.getSmallIslandEnd(), new long[0]).add(object2.getCONTAINER_CLIP_TOP_PROGRESS(), this.this$0.getSmallIslandTop(), new long[0]).add(object2.getCONTAINER_CLIP_BOTTOM_PROGRESS(), this.this$0.getSmallIslandBottom(), new long[0]), new AnimConfig[]{new AnimConfig().setSpecial(object2.getSMALL_ISLAND_SCALE(), FolmeEase.sinInOut((long)200L), 100L, new float[0]).setSpecial(object2.getCONTAINER_CLIP_START_PROGRESS(), FolmeEase.sinInOut((long)200L), 100L, new float[0]).setSpecial(object2.getCONTAINER_CLIP_END_PROGRESS(), FolmeEase.sinInOut((long)200L), 100L, new float[0]).setSpecial(object2.getCONTAINER_CLIP_TOP_PROGRESS(), FolmeEase.sinInOut((long)200L), 100L, new float[0]).setSpecial(object2.getCONTAINER_CLIP_BOTTOM_PROGRESS(), FolmeEase.sinInOut((long)200L), 100L, new float[0]).addListeners(new TransitionListener[]{new TransitionListener(this.this$0){
                final DynamicIslandAnimationDelegate this$0;
                {
                    this.this$0 = dynamicIslandAnimationDelegate;
                }

                public void onComplete(Object object) {
                    super.onComplete(object);
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
        this.this$0.scheduleUpdate();
    }
}
