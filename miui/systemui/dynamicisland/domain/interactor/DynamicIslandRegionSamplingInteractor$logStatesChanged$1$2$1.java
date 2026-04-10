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

public static final class DynamicIslandRegionSamplingInteractor.logStatesChanged.1.1<T>
implements g {
    public static final DynamicIslandRegionSamplingInteractor.logStatesChanged.1.1<T> INSTANCE = new /* invalid duplicate definition of identical inner class */;

    public final Object emit(boolean bl, d object) {
        object = new StringBuilder();
        ((StringBuilder)object).append("region dark changed to ");
        ((StringBuilder)object).append(bl);
        Log.d((String)"DynamicIslandRegionSamplingInteractor", (String)((StringBuilder)object).toString());
        return s.a;
    }
}
