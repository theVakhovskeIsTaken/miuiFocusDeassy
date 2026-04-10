/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  G0.s
 *  android.content.res.Configuration
 *  h1.q
 *  kotlin.jvm.internal.o
 *  miui.systemui.autodensity.AutoDensityController$OnDensityChangeListener
 */
package miui.systemui.dynamicisland.touch.data.repository;

import G0.s;
import android.content.res.Configuration;
import h1.q;
import kotlin.jvm.internal.o;
import miui.systemui.autodensity.AutoDensityController;

public static final class DynamicIslandTouchConstantsRepository.densityChanged.1.listener.1
implements AutoDensityController.OnDensityChangeListener {
    final q $$this$conflatedCallbackFlow;

    public DynamicIslandTouchConstantsRepository.densityChanged.1.listener.1(q q2) {
        this.$$this$conflatedCallbackFlow = q2;
    }

    public void onConfigChanged(Configuration configuration) {
        o.g((Object)configuration, (String)"config");
        this.$$this$conflatedCallbackFlow.i((Object)s.a);
    }
}
