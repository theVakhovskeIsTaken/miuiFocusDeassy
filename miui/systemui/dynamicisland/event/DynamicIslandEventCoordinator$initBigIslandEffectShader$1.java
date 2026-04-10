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

public static final class DynamicIslandEventCoordinator.initBigIslandEffectShader.1
extends p
implements Function1 {
    final DynamicIslandEventCoordinator this$0;

    public DynamicIslandEventCoordinator.initBigIslandEffectShader.1(DynamicIslandEventCoordinator dynamicIslandEventCoordinator) {
        this.this$0 = dynamicIslandEventCoordinator;
        super(1);
    }

    public final void invoke(String object) {
        o.g((Object)object, (String)"it");
        object = this.this$0.getBigIslandStateHandler().getCurrentTempShow();
        if (object != null && (object = ((DynamicIslandBaseContentView)((Object)object)).getCurrentIslandData()) != null && (object = object.getProperties()) != null && (Integer)object == 0) {
            DynamicIslandUtils dynamicIslandUtils = DynamicIslandUtils.INSTANCE;
            object = this.this$0.getBigIslandStateHandler().getCurrentTempShow();
            object = object != null ? ((DynamicIslandBaseContentView)((Object)object)).getCurrentIslandData() : null;
            if (dynamicIslandUtils.isGlowEffectEnabledForBigState$miui_dynamicisland_release((DynamicIslandData)object) && (object = this.this$0.getBigIslandStateHandler().getCurrentTempShow()) != null && (object = ((DynamicIslandBaseContentView)((Object)object)).getBigIslandView()) != null) {
                ((DynamicGlowEffectView)((Object)object)).startGlowEffect$miui_dynamicisland_release();
            }
        }
    }
}
