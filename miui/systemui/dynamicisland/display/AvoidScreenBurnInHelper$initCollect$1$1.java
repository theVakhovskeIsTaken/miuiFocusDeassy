/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  G0.s
 *  K0.d
 *  android.util.Log
 *  i1.g
 */
package miui.systemui.dynamicisland.display;

import G0.s;
import K0.d;
import android.util.Log;
import i1.g;
import miui.systemui.dynamicisland.display.AvoidScreenBurnInHelper;
import miui.systemui.dynamicisland.event.DynamicIslandEventCoordinator;

public static final class AvoidScreenBurnInHelper.initCollect.1<T>
implements g {
    final AvoidScreenBurnInHelper this$0;

    public AvoidScreenBurnInHelper.initCollect.1(AvoidScreenBurnInHelper avoidScreenBurnInHelper) {
        this.this$0 = avoidScreenBurnInHelper;
    }

    public final Object emit(int n, d object) {
        object = new StringBuilder();
        ((StringBuilder)object).append(" flow screenBurnInStrategy  ");
        ((StringBuilder)object).append(n);
        ((StringBuilder)object).append(" ");
        Log.d((String)"AvoidScreenBurnInHelper", (String)((StringBuilder)object).toString());
        object = this.this$0.getEventCoordinator();
        if (object != null) {
            ((DynamicIslandEventCoordinator)object).handleScreenBurnInStrategy(n);
        }
        return s.a;
    }
}
