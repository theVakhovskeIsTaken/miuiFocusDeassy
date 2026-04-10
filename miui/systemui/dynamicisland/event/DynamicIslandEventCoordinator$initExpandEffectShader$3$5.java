/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.o
 *  kotlin.jvm.internal.p
 */
package miui.systemui.dynamicisland.event;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.o;
import kotlin.jvm.internal.p;
import miui.systemui.dynamicisland.event.DynamicIslandEventCoordinator;

public static final class DynamicIslandEventCoordinator.initExpandEffectShader.3.5
extends p
implements Function1 {
    final DynamicIslandEventCoordinator this$0;

    public DynamicIslandEventCoordinator.initExpandEffectShader.3.5(DynamicIslandEventCoordinator dynamicIslandEventCoordinator) {
        this.this$0 = dynamicIslandEventCoordinator;
        super(1);
    }

    public final void invoke(String object) {
        o.g((Object)object, (String)"it");
        if (this.this$0.collapseAnimationRunningCount > 0) {
            object = this.this$0;
            ((DynamicIslandEventCoordinator)object).collapseAnimationRunningCount = ((DynamicIslandEventCoordinator)object).collapseAnimationRunningCount - 1;
        }
        this.this$0.collapseAnimationRunning = false;
    }
}
