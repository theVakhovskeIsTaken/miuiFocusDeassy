/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  G0.s
 *  K0.d
 *  android.util.Log
 *  i1.g
 */
package miui.systemui.dynamicisland.domain.interactor;

import G0.s;
import K0.d;
import android.util.Log;
import i1.g;
import miui.systemui.dynamicisland.domain.interactor.DynamicIslandRegionSamplingInteractor;

public static final class DynamicIslandRegionSamplingInteractor.listenForRegionSampling.1<T>
implements g {
    final DynamicIslandRegionSamplingInteractor this$0;

    public DynamicIslandRegionSamplingInteractor.listenForRegionSampling.1(DynamicIslandRegionSamplingInteractor dynamicIslandRegionSamplingInteractor) {
        this.this$0 = dynamicIslandRegionSamplingInteractor;
    }

    public final Object emit(boolean bl, d object) {
        if (DEBUG) {
            object = new StringBuilder();
            ((StringBuilder)object).append("region sampling changed to ");
            ((StringBuilder)object).append(bl);
            Log.d((String)"DynamicIslandRegionSamplingInteractor", (String)((StringBuilder)object).toString());
        }
        this.this$0.regionSamplingHelper.setRegionSampling(bl);
        return s.a;
    }
}
