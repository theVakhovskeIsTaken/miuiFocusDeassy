/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.android.systemui.plugins.miui.dynamicisland.DynamicIslandData
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.o
 *  kotlin.jvm.internal.p
 */
package miui.systemui.dynamicisland.event;

import com.android.systemui.plugins.miui.dynamicisland.DynamicIslandData;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.o;
import kotlin.jvm.internal.p;
import miui.systemui.dynamicisland.DynamicIslandUtils;
import miui.systemui.dynamicisland.event.DynamicIslandEventCoordinator;
import miui.systemui.dynamicisland.view.DynamicGlowEffectView;
import miui.systemui.dynamicisland.window.content.DynamicIslandBaseContentView;

public static final class DynamicIslandEventCoordinator.initExpandEffectShader.2
extends p
implements Function1 {
    final DynamicIslandEventCoordinator this$0;

    public DynamicIslandEventCoordinator.initExpandEffectShader.2(DynamicIslandEventCoordinator dynamicIslandEventCoordinator) {
        this.this$0 = dynamicIslandEventCoordinator;
        super(1);
    }

    public final void invoke(String object) {
        o.g((Object)object, (String)"it");
        DynamicIslandUtils dynamicIslandUtils = DynamicIslandUtils.INSTANCE;
        object = this.this$0.getExpandedStateHandler().getCurrent();
        object = object != null ? ((DynamicIslandBaseContentView)((Object)object)).getCurrentIslandData() : null;
        if (dynamicIslandUtils.isGlowEffectEnabledForExpandState$miui_dynamicisland_release((DynamicIslandData)object) && (object = this.this$0.getExpandedStateHandler().getCurrent()) != null && (object = ((DynamicIslandBaseContentView)((Object)object)).getExpandedView()) != null) {
            ((DynamicGlowEffectView)((Object)object)).startGlowEffect$miui_dynamicisland_release();
        }
    }
}
