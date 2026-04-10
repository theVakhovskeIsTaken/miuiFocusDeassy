/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.util.Log
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.o
 *  kotlin.jvm.internal.p
 */
package miui.systemui.dynamicisland.event;

import android.util.Log;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.o;
import kotlin.jvm.internal.p;
import miui.systemui.dynamicisland.event.DynamicIslandEventCoordinator;
import miui.systemui.dynamicisland.view.DynamicIslandExpandedView;
import miui.systemui.dynamicisland.window.content.DynamicIslandBaseContentView;

public static final class DynamicIslandEventCoordinator.initExpandEffectShader.1
extends p
implements Function1 {
    final DynamicIslandEventCoordinator this$0;

    public DynamicIslandEventCoordinator.initExpandEffectShader.1(DynamicIslandEventCoordinator dynamicIslandEventCoordinator) {
        this.this$0 = dynamicIslandEventCoordinator;
        super(1);
    }

    public final void invoke(String object) {
        o.g((Object)object, (String)"it");
        object = this.this$0.getExpandedStateHandler().getCurrent();
        if (object != null && (object = ((DynamicIslandBaseContentView)((Object)object)).getExpandedView()) != null) {
            ((DynamicIslandExpandedView)((Object)object)).startCallingEffectIfNeeded$miui_dynamicisland_release();
        }
        if (this.this$0.getExpandedStateHandler().getCurrent() == null) {
            Log.w((String)"DynamicIslandEventCoordinator", (String)"Anim TO_EXPANDED:ANIM_FINISH expandedStateHandler.current is null");
        }
    }
}
