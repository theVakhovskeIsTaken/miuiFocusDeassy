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
package miui.systemui.dynamicisland.window.domain.interactor;

import G0.s;
import K0.d;
import android.graphics.Region;
import android.util.Log;
import i1.g;
import miui.systemui.dynamicisland.window.domain.interactor.DynamicIslandTouchRegionInteractor;

public static final class DynamicIslandTouchRegionInteractor.listenForTouchRegionChanged.1<T>
implements g {
    final DynamicIslandTouchRegionInteractor this$0;

    public DynamicIslandTouchRegionInteractor.listenForTouchRegionChanged.1(DynamicIslandTouchRegionInteractor dynamicIslandTouchRegionInteractor) {
        this.this$0 = dynamicIslandTouchRegionInteractor;
    }

    public final Object emit(Region region, d object) {
        if (DEBUG) {
            object = new StringBuilder();
            ((StringBuilder)object).append("requestApplyInsets ");
            ((StringBuilder)object).append(region);
            Log.d((String)"DynamicIslandTouchRegionInteractor", (String)((StringBuilder)object).toString());
        }
        this.this$0.windowView.requestApplyInsets();
        if (DEBUG) {
            this.this$0.windowView.invalidate();
        }
        return s.a;
    }
}
