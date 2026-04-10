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
import miui.systemui.dynamicisland.event.DynamicIslandEventCoordinator;
import miui.systemui.dynamicisland.window.DynamicIslandWindowView;

public static final class DynamicIslandWindowView.initEventCoordinator.1<T>
implements g {
    final DynamicIslandWindowView this$0;

    public DynamicIslandWindowView.initEventCoordinator.1(DynamicIslandWindowView dynamicIslandWindowView) {
        this.this$0 = dynamicIslandWindowView;
    }

    public final Object emit(Region region, d object) {
        object = new StringBuilder();
        ((StringBuilder)object).append("expandedViewRegion ");
        ((StringBuilder)object).append(region);
        Log.e((String)"DynamicIslandWindowViewImpl", (String)((StringBuilder)object).toString());
        object = this.this$0.getEventCoordinator();
        if (object != null) {
            ((DynamicIslandEventCoordinator)object).handleExpandGestureListener(region);
        }
        return s.a;
    }
}
