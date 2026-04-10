/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  G0.s
 *  K0.d
 *  android.graphics.Region
 *  android.util.Log
 *  i1.g
 */
package miui.systemui.dynamicisland.window;

import G0.s;
import K0.d;
import android.graphics.Region;
import android.util.Log;
import i1.g;

public static final class DynamicIslandWindowView.initEventCoordinator.1<T>
implements g {
    public static final DynamicIslandWindowView.initEventCoordinator.1<T> INSTANCE = new /* invalid duplicate definition of identical inner class */;

    public final Object emit(Region region, d object) {
        object = new StringBuilder();
        ((StringBuilder)object).append("bigIslandRegion ");
        ((StringBuilder)object).append(region);
        Log.e((String)"DynamicIslandWindowViewImpl", (String)((StringBuilder)object).toString());
        return s.a;
    }
}
