/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  b1.f
 *  kotlin.jvm.internal.o
 *  kotlin.jvm.internal.x
 *  miui.systemui.animation.FolmeKt
 *  miui.systemui.util.CommonUtils
 *  miuix.animation.FolmeObject
 *  miuix.animation.base.AnimConfig
 *  miuix.animation.controller.AnimState
 *  miuix.animation.listener.UpdateInfo
 *  miuix.animation.property.FloatProperty
 */
package miui.systemui.dynamicisland.anim;

import b1.f;
import java.util.Collection;
import kotlin.jvm.internal.o;
import kotlin.jvm.internal.x;
import miui.systemui.animation.FolmeKt;
import miui.systemui.dynamicisland.DynamicIslandScenarioUtils;
import miui.systemui.dynamicisland.anim.DynamicIslandAnimListener;
import miui.systemui.dynamicisland.anim.DynamicIslandAnimationCallback;
import miui.systemui.dynamicisland.anim.DynamicIslandAnimationCallbackType;
import miui.systemui.dynamicisland.anim.DynamicIslandAnimationDelegate;
import miui.systemui.dynamicisland.anim.DynamicIslandAnimationType;
import miui.systemui.dynamicisland.device.strategy.DynamicIslandAnimationDelegateHelper;
import miui.systemui.dynamicisland.window.content.DynamicIslandBaseContentView;
import miui.systemui.dynamicisland.window.content.DynamicIslandContentView;
import miui.systemui.util.CommonUtils;
import miuix.animation.FolmeObject;
import miuix.animation.base.AnimConfig;
import miuix.animation.controller.AnimState;
import miuix.animation.listener.UpdateInfo;
import miuix.animation.property.FloatProperty;

public static final class DynamicIslandAnimationDelegate.expandedToBigIslandAnimation.1
extends DynamicIslandAnimListener {
    final x $isStatusBarToHidden;
    final float $transX;
    final DynamicIslandContentView $view;
    final DynamicIslandAnimationDelegate this$0;

    public DynamicIslandAnimationDelegate.expandedToBigIslandAnimation.1(DynamicIslandAnimationDelegate dynamicIslandAnimationDelegate, DynamicIslandContentView dynamicIslandContentView, float f, x x2) {
        this.this$0 = dynamicIslandAnimationDelegate;
        this.$view = dynamicIslandContentView;
        this.$transX = f;
        this.$isStatusBarToHidden = x2;
        super(dynamicIslandAnimationDelegate);
    }

    @Override
    public void onBegin(Object object) {
        super.onBegin(object);
        this.this$0.isBlockUpdatePosition = true;
        this.this$0.shouldBlockScale = true;
        this.this$0.beginExpandedScaleX = (float)this.$view.getBigIslandViewWidth() / (float)this.$view.getExpandedViewWidth();
        this.this$0.setViewVisible(this.$view, 0);
        Object object2 = this.this$0.getFakeView();
        if (object2 != null) {
            object2.setVisibility(4);
        }
        object2 = this.$view.getBigIslandView();
        if (object2 != null) {
            object2.setVisibility(0);
        }
        object2 = this.$view.getSmallIslandView();
        if (object2 != null) {
            object2.setVisibility(4);
        }
        Object object3 = this.this$0.animationDelegateHelper;
        object2 = DynamicIslandAnimationType.EXPANDED_TO_BIG;
        ((DynamicIslandAnimationDelegateHelper)object3).requestUpdateHeadsUpLocation((DynamicIslandAnimationType)((Object)object2), this.$view);
        object3 = this.this$0.dynamicIslandAnimController.getAnimationCallback$miui_dynamicisland_release();
        DynamicIslandAnimationCallbackType dynamicIslandAnimationCallbackType = DynamicIslandAnimationCallbackType.ANIM_START;
        o.e((Object)object, (String)"null cannot be cast to non-null type kotlin.String");
        ((DynamicIslandAnimationCallback)object3).executeCallback((DynamicIslandAnimationType)((Object)object2), dynamicIslandAnimationCallbackType, (String)object);
        DynamicIslandScenarioUtils.INSTANCE.setDynamicIslandScenarioState(477L, true);
        this.this$0.animationDelegateHelper.updateBigIslandContainerBackground(this.$view);
    }

    @Override
    public void onCancel(Object object) {
        this.this$0.isBlockUpdatePosition = false;
        this.this$0.shouldBlockScale = false;
        Object object2 = DynamicIslandScenarioUtils.INSTANCE;
        if (object2.isExpandTracking()) {
            object2.setDynamicIslandScenarioState(496L, false);
            object2.setExpandTracking(false);
        }
        object2.setDynamicIslandScenarioState(477L, false);
        DynamicIslandAnimationCallback dynamicIslandAnimationCallback = this.this$0.dynamicIslandAnimController.getAnimationCallback$miui_dynamicisland_release();
        object2 = DynamicIslandAnimationType.EXPANDED_TO_BIG;
        DynamicIslandAnimationCallbackType dynamicIslandAnimationCallbackType = DynamicIslandAnimationCallbackType.ANIM_CANCEL;
        o.e((Object)object, (String)"null cannot be cast to non-null type kotlin.String");
        dynamicIslandAnimationCallback.executeCallback((DynamicIslandAnimationType)((Object)object2), dynamicIslandAnimationCallbackType, (String)object);
        super.onCancel(object);
    }

    @Override
    public void onComplete(Object object) {
        this.this$0.isBlockUpdatePosition = false;
        this.this$0.shouldBlockScale = false;
        Object object2 = this.$view.getExpandedView();
        if (object2 != null) {
            object2.setVisibility(4);
        }
        object2 = DynamicIslandScenarioUtils.INSTANCE;
        if (((DynamicIslandScenarioUtils)object2).isExpandTracking()) {
            ((DynamicIslandScenarioUtils)object2).setDynamicIslandScenarioState(496L, false);
            ((DynamicIslandScenarioUtils)object2).setExpandTracking(false);
        }
        ((DynamicIslandScenarioUtils)object2).setDynamicIslandScenarioState(477L, false);
        object2 = this.this$0.dynamicIslandAnimController.getAnimationCallback$miui_dynamicisland_release();
        DynamicIslandAnimationType dynamicIslandAnimationType = DynamicIslandAnimationType.EXPANDED_TO_BIG;
        DynamicIslandAnimationCallbackType dynamicIslandAnimationCallbackType = DynamicIslandAnimationCallbackType.ANIM_FINISH;
        o.e((Object)object, (String)"null cannot be cast to non-null type kotlin.String");
        ((DynamicIslandAnimationCallback)object2).executeCallback(dynamicIslandAnimationType, dynamicIslandAnimationCallbackType, (String)object);
        super.onComplete(object);
    }

    @Override
    public void onUpdate(Object object, Collection<UpdateInfo> updateInfo2) {
        Object object2;
        this.this$0.fixTransX(updateInfo2, this.$transX);
        super.onUpdate(object, (Collection<UpdateInfo>)updateInfo2);
        object = CommonUtils.INSTANCE;
        if (object.getIS_TABLET() && (object2 = UpdateInfo.findByName(updateInfo2, (String)"dynamic_expanded_scale_x")) != null && f.h((float)object2.getFloatValue(), (float)0.0f, (float)1.0f) < this.this$0.beginExpandedScaleX * 1.1f && this.this$0.shouldBlockScale) {
            this.this$0.shouldBlockScale = false;
        }
        boolean bl = (Boolean)this.this$0.dynamicIslandAnimController.getDynamicIslandWindowState().getStatusBarDisappearance().getValue();
        if (object.getIS_TABLET()) {
            object = this.$isStatusBarToHidden;
            if (bl != ((x)object).a) {
                ((x)object).a = bl;
                if (!this.this$0.isMoveDownAnimating) {
                    object = FolmeKt.getFolme((FolmeObject)this.this$0);
                    object2 = DynamicIslandAnimationDelegate.Companion;
                    object.cancel(new FloatProperty[]{object2.getCONTAINER_TRANS_Y(), object2.getEXPANDED_TRANS_Y(), object2.getBIG_ISLAND_TRANS_Y()});
                    FolmeKt.getFolme((FolmeObject)this.this$0).to((Object)new AnimState().add(object2.getCONTAINER_ALPHA(), 0.0f, new long[0]).add(object2.getEXPANDED_ALPHA(), 0.0f, new long[0]).add(object2.getBIG_ISLAND_ALPHA(), 0.0f, new long[0]), new AnimConfig[]{new AnimConfig().setSpecial(object2.getCONTAINER_ALPHA(), this.this$0.getPAD_SHOW_EASE(), new float[0]).setSpecial(object2.getEXPANDED_ALPHA(), this.this$0.getPAD_SHOW_EASE(), new float[0]).setSpecial(object2.getBIG_ISLAND_ALPHA(), this.this$0.getPAD_SHOW_EASE(), new float[0])});
                }
            }
        }
        if (updateInfo2 != null) {
            object = this.$view;
            for (UpdateInfo updateInfo2 : updateInfo2) {
                if (!o.c((Object)updateInfo2.property, DynamicIslandAnimationDelegate.Companion.getBIG_ISLAND_SCALE())) continue;
                ((DynamicIslandBaseContentView)((Object)object)).updateShadow((DynamicIslandBaseContentView)((Object)object), updateInfo2.getFloatValue() - 1.0f);
            }
        }
    }
}
