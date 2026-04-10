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
import miui.systemui.dynamicisland.anim.DynamicIslandAnimListener;
import miui.systemui.dynamicisland.anim.DynamicIslandAnimationDelegate;
import miui.systemui.util.CommonUtils;
import miuix.animation.FolmeObject;
import miuix.animation.listener.UpdateInfo;

public static final class DynamicIslandAnimationDelegate.resetPress.2
extends DynamicIslandAnimListener {
    final float $bigIslandStart;
    final DynamicIslandAnimationDelegate this$0;

    public DynamicIslandAnimationDelegate.resetPress.2(DynamicIslandAnimationDelegate dynamicIslandAnimationDelegate, float f) {
        this.this$0 = dynamicIslandAnimationDelegate;
        this.$bigIslandStart = f;
        super(dynamicIslandAnimationDelegate);
    }

    @Override
    public void onBegin(Object object) {
    }

    @Override
    public void onCancel(Object object) {
    }

    @Override
    public void onComplete(Object object) {
    }

    @Override
    public void onUpdate(Object object, Collection<UpdateInfo> collection) {
        super.onUpdate(object, collection);
        if (CommonUtils.INSTANCE.getIS_TABLET() && this.this$0.getBigIslandStart() != this.$bigIslandStart) {
            FolmeKt.getFolme((FolmeObject)this.this$0).cancel();
            FolmeKt.getFolme((FolmeObject)this.this$0).setTo((Object)this.this$0.getBigIslandAnimState());
        }
    }
}
