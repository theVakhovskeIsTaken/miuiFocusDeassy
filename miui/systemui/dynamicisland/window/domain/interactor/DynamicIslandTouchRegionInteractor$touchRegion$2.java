/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  U0.a
 *  i1.I
 *  kotlin.jvm.internal.p
 */
package miui.systemui.dynamicisland.window.domain.interactor;

import U0.a;
import i1.I;
import kotlin.jvm.internal.p;
import miui.systemui.dynamicisland.window.domain.interactor.DynamicIslandTouchRegionInteractor;

public static final class DynamicIslandTouchRegionInteractor.touchRegion.2
extends p
implements a {
    final DynamicIslandTouchRegionInteractor this$0;

    public DynamicIslandTouchRegionInteractor.touchRegion.2(DynamicIslandTouchRegionInteractor dynamicIslandTouchRegionInteractor) {
        this.this$0 = dynamicIslandTouchRegionInteractor;
        super(0);
    }

    public final I invoke() {
        return this.this$0.getEventCoordinator().getTouchRegion();
    }
}
