/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.o
 *  kotlin.jvm.internal.p
 */
package miui.systemui.dynamicisland.anim;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.o;
import kotlin.jvm.internal.p;
import miui.systemui.dynamicisland.anim.DynamicIslandAnimationController;

public static final class DynamicIslandAnimationController.animationCallback.1.1
extends p
implements Function1 {
    final DynamicIslandAnimationController this$0;

    public DynamicIslandAnimationController.animationCallback.1.1(DynamicIslandAnimationController dynamicIslandAnimationController) {
        this.this$0 = dynamicIslandAnimationController;
        super(1);
    }

    public final void invoke(String string) {
        o.g((Object)string, (String)"it");
        this.this$0.setAnimatorRunning(true);
        this.this$0.animatorSet.add(string);
    }
}
