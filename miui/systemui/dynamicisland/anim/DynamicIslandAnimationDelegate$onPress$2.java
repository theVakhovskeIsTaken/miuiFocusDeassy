/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  miui.systemui.animation.FolmeKt
 *  miui.systemui.util.CommonUtils
 *  miuix.animation.FolmeObject
 *  miuix.animation.controller.AnimState
 *  miuix.animation.listener.UpdateInfo
 */
package miui.systemui.dynamicisland.anim;

import java.util.Collection;
import miui.systemui.animation.FolmeKt;
import miui.systemui.dynamicisland.anim.DynamicIslandAnimListener;
import miui.systemui.dynamicisland.anim.DynamicIslandAnimationDelegate;
import miui.systemui.util.CommonUtils;
import miuix.animation.FolmeObject;
import miuix.animation.controller.AnimState;
import miuix.animation.listener.UpdateInfo;

public static final class DynamicIslandAnimationDelegate.onPress.2
extends DynamicIslandAnimListener {
    final float $bigIslandStart;
    final DynamicIslandAnimationDelegate this$0;

    public DynamicIslandAnimationDelegate.onPress.2(DynamicIslandAnimationDelegate dynamicIslandAnimationDelegate, float f) {
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
    public void onUpdate(Object object, Collection<UpdateInfo> animState) {
        super.onUpdate(object, (Collection<UpdateInfo>)animState);
        if (CommonUtils.INSTANCE.getIS_TABLET() && this.this$0.getBigIslandStart() != this.$bigIslandStart) {
            FolmeKt.getFolme((FolmeObject)this.this$0).cancel();
            object = FolmeKt.getFolme((FolmeObject)this.this$0);
            animState = new AnimState();
            DynamicIslandAnimationDelegate.Companion companion = DynamicIslandAnimationDelegate.Companion;
            object.setTo((Object)animState.add(companion.getCONTAINER_X(), 0.0f, new long[0]).add(companion.getCONTAINER_TRANS_Y(), 0.0f, new long[0]).add(companion.getCONTAINER_CLIP_START_PROGRESS(), this.this$0.getBigIslandStart(), new long[0]).add(companion.getCONTAINER_CLIP_END_PROGRESS(), this.this$0.getBigIslandEnd(), new long[0]).add(companion.getCONTAINER_CLIP_TOP_PROGRESS(), this.this$0.getBigIslandTop(), new long[0]).add(companion.getCONTAINER_CLIP_BOTTOM_PROGRESS(), this.this$0.getBigIslandBottom(), new long[0]).add(companion.getBIG_ISLAND_SCALE(), 1.0f, new long[0]));
        }
    }
}
