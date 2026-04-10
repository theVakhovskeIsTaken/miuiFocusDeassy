/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.p
 */
package miui.systemui.dynamicisland.event;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.p;
import miui.systemui.dynamicisland.event.DynamicIslandEventCoordinator;

public static final class DynamicIslandEventCoordinator.3
extends p
implements Function1 {
    final DynamicIslandEventCoordinator this$0;

    public DynamicIslandEventCoordinator.3(DynamicIslandEventCoordinator dynamicIslandEventCoordinator) {
        this.this$0 = dynamicIslandEventCoordinator;
        super(1);
    }

    public final void invoke(Throwable object) {
        DynamicIslandEventCoordinator dynamicIslandEventCoordinator = this.this$0.avoidScreenBurnInHelper.getEventCoordinator();
        if (dynamicIslandEventCoordinator == (object = this.this$0)) {
            ((DynamicIslandEventCoordinator)object).avoidScreenBurnInHelper.setEventCoordinator(null);
        }
    }
}
