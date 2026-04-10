/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  G0.s
 *  K0.d
 *  android.graphics.Canvas
 *  android.graphics.Region
 *  i1.g
 */
package miui.systemui.dynamicisland.window.domain.interactor;

import G0.s;
import K0.d;
import android.graphics.Canvas;
import android.graphics.Region;
import i1.g;
import miui.systemui.dynamicisland.window.domain.interactor.DynamicIslandTouchRegionInteractor;

public static final class DynamicIslandTouchRegionInteractor.drawDebugTouchRegion.1<T>
implements g {
    final DynamicIslandTouchRegionInteractor this$0;

    public DynamicIslandTouchRegionInteractor.drawDebugTouchRegion.1(DynamicIslandTouchRegionInteractor dynamicIslandTouchRegionInteractor) {
        this.this$0 = dynamicIslandTouchRegionInteractor;
    }

    public final Object emit(Canvas canvas, d d2) {
        canvas.drawRect(((Region)this.this$0.getWindowViewTouchRegion().getValue()).getBounds(), this.this$0.getPaint());
        return s.a;
    }
}
