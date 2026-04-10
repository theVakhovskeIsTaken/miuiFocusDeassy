/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.animation.Animator
 *  android.animation.Animator$AnimatorListener
 *  com.android.systemui.plugins.miui.dynamicisland.DynamicIslandData
 *  kotlin.jvm.internal.o
 */
package miui.systemui.dynamicisland.module;

import android.animation.Animator;
import com.android.systemui.plugins.miui.dynamicisland.DynamicIslandData;
import kotlin.jvm.internal.o;
import miui.systemui.dynamicisland.module.IslandIconViewHolder;

public static final class IslandIconViewHolder.playBigAnimation.1.1
implements Animator.AnimatorListener {
    final DynamicIslandData $data;
    final IslandIconViewHolder this$0;

    public IslandIconViewHolder.playBigAnimation.1.1(IslandIconViewHolder islandIconViewHolder, DynamicIslandData dynamicIslandData) {
        this.this$0 = islandIconViewHolder;
        this.$data = dynamicIslandData;
    }

    public void onAnimationCancel(Animator animator) {
        o.g((Object)animator, (String)"animator");
        this.this$0.clearFaceRecognition(this.$data);
    }

    public void onAnimationEnd(Animator animator) {
        o.g((Object)animator, (String)"animator");
        this.this$0.clearFaceRecognition(this.$data);
    }

    public void onAnimationRepeat(Animator animator) {
        o.g((Object)animator, (String)"animator");
    }

    public void onAnimationStart(Animator animator) {
        o.g((Object)animator, (String)"animator");
    }
}
