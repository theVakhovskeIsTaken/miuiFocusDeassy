/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  G0.s
 *  K0.d
 *  android.graphics.Region
 *  android.util.Log
 *  android.view.ViewTreeObserver$InternalInsetsInfo
 *  i1.g
 */
package miui.systemui.dynamicisland.window.domain.interactor;

import G0.s;
import K0.d;
import android.graphics.Region;
import android.util.Log;
import android.view.ViewTreeObserver;
import i1.g;
import miui.systemui.dynamicisland.window.domain.interactor.DynamicIslandTouchRegionInteractor;

public static final class DynamicIslandTouchRegionInteractor.updateInternalInsets.1<T>
implements g {
    final DynamicIslandTouchRegionInteractor this$0;

    public DynamicIslandTouchRegionInteractor.updateInternalInsets.1(DynamicIslandTouchRegionInteractor dynamicIslandTouchRegionInteractor) {
        this.this$0 = dynamicIslandTouchRegionInteractor;
    }

    public final Object emit(ViewTreeObserver.InternalInsetsInfo internalInsetsInfo, d d2) {
        if (DEBUG) {
            Log.d((String)"DynamicIslandTouchRegionInteractor", (String)"updateInternalInsets");
        }
        internalInsetsInfo.setTouchableInsets(3);
        internalInsetsInfo.touchableRegion.set((Region)this.this$0.getWindowViewTouchRegion().getValue());
        return s.a;
    }
}
