/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  U0.a
 *  kotlin.jvm.internal.p
 *  miui.systemui.autodensity.AutoDensityController$OnDensityChangeListener
 */
package miui.systemui.dynamicisland.touch.data.repository;

import U0.a;
import kotlin.jvm.internal.p;
import miui.systemui.autodensity.AutoDensityController;
import miui.systemui.dynamicisland.touch.data.repository.DynamicIslandTouchConstantsRepository;

public static final class DynamicIslandTouchConstantsRepository.densityChanged.1
extends p
implements a {
    final DynamicIslandTouchConstantsRepository.densityChanged.listener.1 $listener;
    final DynamicIslandTouchConstantsRepository this$0;

    public DynamicIslandTouchConstantsRepository.densityChanged.1(DynamicIslandTouchConstantsRepository dynamicIslandTouchConstantsRepository, DynamicIslandTouchConstantsRepository.densityChanged.listener.1 var2_2) {
        this.this$0 = dynamicIslandTouchConstantsRepository;
        this.$listener = var2_2;
        super(0);
    }

    public final void invoke() {
        this.this$0.autoDensityController.removeOnDensityChangeListener((AutoDensityController.OnDensityChangeListener)this.$listener);
    }
}
