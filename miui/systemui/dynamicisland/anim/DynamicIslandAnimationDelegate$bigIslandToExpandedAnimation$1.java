/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.util.Log
 *  kotlin.jvm.internal.o
 *  miuix.animation.listener.UpdateInfo
 */
package miui.systemui.dynamicisland.anim;

import android.util.Log;
import java.util.Collection;
import kotlin.jvm.internal.o;
import miui.systemui.dynamicisland.DynamicIslandScenarioUtils;
import miui.systemui.dynamicisland.anim.DynamicIslandAnimListener;
import miui.systemui.dynamicisland.anim.DynamicIslandAnimationCallback;
import miui.systemui.dynamicisland.anim.DynamicIslandAnimationCallbackType;
import miui.systemui.dynamicisland.anim.DynamicIslandAnimationDelegate;
import miui.systemui.dynamicisland.anim.DynamicIslandAnimationType;
import miui.systemui.dynamicisland.window.content.DynamicIslandBaseContentView;
import miui.systemui.dynamicisland.window.content.DynamicIslandContentView;
import miuix.animation.listener.UpdateInfo;

public static final class DynamicIslandAnimationDelegate.bigIslandToExpandedAnimation.1
extends DynamicIslandAnimListener {
    final DynamicIslandContentView $view;
    final DynamicIslandAnimationDelegate this$0;

    public DynamicIslandAnimationDelegate.bigIslandToExpandedAnimation.1(DynamicIslandAnimationDelegate dynamicIslandAnimationDelegate, DynamicIslandContentView dynamicIslandContentView) {
        this.this$0 = dynamicIslandAnimationDelegate;
        this.$view = dynamicIslandContentView;
        super(dynamicIslandAnimationDelegate);
    }

    @Override
    public void onBegin(Object object) {
        super.onBegin(object);
        this.this$0.isBlockUpdatePosition = true;
        Object object2 = this.$view.getExpandedView();
        if (object2 != null) {
            object2.setVisibility(0);
        }
        this.this$0.animationDelegateHelper.requestUpdateHeadsUpLocation(DynamicIslandAnimationType.BIG_TO_EXPANDED, this.$view);
        DynamicIslandAnimationCallback dynamicIslandAnimationCallback = this.this$0.dynamicIslandAnimController.getAnimationCallback$miui_dynamicisland_release();
        object2 = DynamicIslandAnimationType.TO_EXPANDED;
        Object object3 = DynamicIslandAnimationCallbackType.ANIM_START;
        o.e((Object)object, (String)"null cannot be cast to non-null type kotlin.String");
        dynamicIslandAnimationCallback.executeCallback((DynamicIslandAnimationType)((Object)object2), (DynamicIslandAnimationCallbackType)((Object)object3), (String)object);
        object2 = this.this$0.TAG;
        object3 = new StringBuilder();
        ((StringBuilder)object3).append("bigIslandToExpandedAnimation1 toTag ");
        ((StringBuilder)object3).append(object);
        Log.e((String)object2, (String)((StringBuilder)object3).toString());
        this.this$0.setAnimateExpanding(true);
        DynamicIslandScenarioUtils.INSTANCE.setDynamicIslandScenarioState(437L, true);
    }

    @Override
    public void onCancel(Object object) {
        super.onCancel(object);
        this.this$0.isBlockUpdatePosition = false;
        this.this$0.setAnimateExpanding(false);
        DynamicIslandScenarioUtils.INSTANCE.setDynamicIslandScenarioState(437L, false);
    }

    @Override
    public void onComplete(Object object) {
        super.onComplete(object);
        this.this$0.isBlockUpdatePosition = false;
        Object object2 = this.this$0.TAG;
        Object object3 = new StringBuilder();
        ((StringBuilder)object3).append("bigIslandToExpandedAnimation2 toTag ");
        ((StringBuilder)object3).append(object);
        Log.e((String)object2, (String)((StringBuilder)object3).toString());
        object3 = this.this$0.dynamicIslandAnimController.getAnimationCallback$miui_dynamicisland_release();
        DynamicIslandAnimationType dynamicIslandAnimationType = DynamicIslandAnimationType.TO_EXPANDED;
        object2 = DynamicIslandAnimationCallbackType.ANIM_FINISH;
        o.e((Object)object, (String)"null cannot be cast to non-null type kotlin.String");
        ((DynamicIslandAnimationCallback)object3).executeCallback(dynamicIslandAnimationType, (DynamicIslandAnimationCallbackType)((Object)object2), (String)object);
        this.this$0.setAnimateExpanding(false);
        object = this.$view.getExpandedView();
        if (object != null) {
            object.sendAccessibilityEvent(128);
        }
        DynamicIslandScenarioUtils.INSTANCE.setDynamicIslandScenarioState(437L, false);
    }

    @Override
    public void onUpdate(Object object, Collection<UpdateInfo> updateInfo2) {
        super.onUpdate(object, (Collection<UpdateInfo>)updateInfo2);
        if (updateInfo2 != null) {
            object = this.$view;
            for (UpdateInfo updateInfo2 : updateInfo2) {
                if (!o.c((Object)updateInfo2.property, DynamicIslandAnimationDelegate.Companion.getBIG_ISLAND_SCALE())) continue;
                ((DynamicIslandBaseContentView)((Object)object)).updateShadow((DynamicIslandBaseContentView)((Object)object), updateInfo2.getFloatValue() - 1.0f);
            }
        }
    }
}
