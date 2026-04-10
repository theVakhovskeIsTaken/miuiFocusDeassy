/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  G0.s
 *  K0.d
 *  M0.b
 *  android.view.MotionEvent
 *  i1.g
 *  i1.u
 */
package miui.systemui.dynamicisland.window.domain.interactor;

import G0.s;
import K0.d;
import M0.b;
import android.view.MotionEvent;
import i1.g;
import i1.u;
import miui.systemui.dynamicisland.window.domain.interactor.DynamicIslandWindowViewTouchInteractor;

public static final class DynamicIslandWindowViewTouchInteractor.isTracking.1.1<T>
implements g {
    final u $isTracking;

    public DynamicIslandWindowViewTouchInteractor.isTracking.1.1(u u2) {
        this.$isTracking = u2;
    }

    public final Object emit(MotionEvent motionEvent, d d2) {
        this.$isTracking.setValue((Object)b.a((boolean)(DynamicIslandWindowViewTouchInteractor.isTracking.2.invoke$lambda$1$isUpOrCancel(motionEvent) ^ true)));
        return s.a;
    }
}
