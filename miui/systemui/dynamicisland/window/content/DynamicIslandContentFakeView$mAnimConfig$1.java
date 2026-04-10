/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  miuix.animation.listener.TransitionListener
 *  miuix.animation.listener.UpdateInfo
 */
package miui.systemui.dynamicisland.window.content;

import java.util.Collection;
import miui.systemui.dynamicisland.window.content.DynamicIslandContentFakeView;
import miuix.animation.listener.TransitionListener;
import miuix.animation.listener.UpdateInfo;

public static final class DynamicIslandContentFakeView.mAnimConfig.1
extends TransitionListener {
    final DynamicIslandContentFakeView this$0;

    public DynamicIslandContentFakeView.mAnimConfig.1(DynamicIslandContentFakeView dynamicIslandContentFakeView) {
        this.this$0 = dynamicIslandContentFakeView;
    }

    public void onCancel(Object object) {
        super.onCancel(object);
        this.this$0.needResetState = false;
        if (!((Boolean)this.this$0._trackingToOpenMW.getValue()).booleanValue()) {
            this.this$0.contentTracker.finishTrack();
        }
    }

    public void onComplete(Object object) {
        super.onComplete(object);
        if (this.this$0.needResetState) {
            this.this$0.needResetState = false;
            this.this$0.onTrackingFakeViewReset();
        }
        this.this$0.contentTracker.finishTrack();
    }

    public void onUpdate(Object object, Collection<UpdateInfo> updateInfo) {
        super.onUpdate(object, updateInfo);
        UpdateInfo updateInfo2 = UpdateInfo.findByName(updateInfo, (String)"alpha");
        if (updateInfo2 == null) {
            return;
        }
        object = UpdateInfo.findByName(updateInfo, (String)"top");
        if (object == null) {
            return;
        }
        if ((updateInfo = UpdateInfo.findByName(updateInfo, (String)"bottom")) == null) {
            return;
        }
        float f = updateInfo2.getFloatValue();
        this.this$0.mFakeViewTrackingParams.setAlpha(f);
        this.this$0.mFakeViewTrackingParams.setTop(object.getIntValue());
        this.this$0.mFakeViewTrackingParams.setBottom(updateInfo.getIntValue());
        this.this$0.onFakeViewTrackingParamsUpdated();
    }
}
