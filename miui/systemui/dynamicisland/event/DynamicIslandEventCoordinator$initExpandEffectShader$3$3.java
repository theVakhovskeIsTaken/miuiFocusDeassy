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
import miui.systemui.dynamicisland.view.DynamicIslandExpandedView;
import miui.systemui.dynamicisland.window.content.DynamicIslandBaseContentView;

public static final class DynamicIslandEventCoordinator.initExpandEffectShader.3.3
extends p
implements Function1 {
    final DynamicIslandEventCoordinator this$0;

    public DynamicIslandEventCoordinator.initExpandEffectShader.3.3(DynamicIslandEventCoordinator dynamicIslandEventCoordinator) {
        this.this$0 = dynamicIslandEventCoordinator;
        super(1);
    }

    public final void invoke(String object) {
        o.g((Object)object, (String)"it");
        object = this.this$0;
        ((DynamicIslandEventCoordinator)object).collapseAnimationRunningCount = ((DynamicIslandEventCoordinator)object).collapseAnimationRunningCount + 1;
        this.this$0.collapseAnimationRunning = true;
        object = this.this$0.getExpandedStateHandler().getLastExpandedView();
        if (object != null && (object = ((DynamicIslandBaseContentView)((Object)object)).getExpandedView()) != null) {
            ((DynamicIslandExpandedView)((Object)object)).stopCallingEffectIfNeeded$miui_dynamicisland_release();
        }
    }
}
