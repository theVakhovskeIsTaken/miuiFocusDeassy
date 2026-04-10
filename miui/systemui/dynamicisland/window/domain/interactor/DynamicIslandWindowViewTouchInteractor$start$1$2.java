/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  G0.s
 *  K0.d
 *  L0.c
 *  android.view.MotionEvent
 *  i1.g
 */
package miui.systemui.dynamicisland.window.domain.interactor;

import G0.s;
import K0.d;
import L0.c;
import android.view.MotionEvent;
import i1.g;
import miui.systemui.dynamicisland.window.domain.interactor.DynamicIslandWindowViewTouchInteractor;

public static final class DynamicIslandWindowViewTouchInteractor.start.2<T>
implements g {
    final DynamicIslandWindowViewTouchInteractor this$0;

    public DynamicIslandWindowViewTouchInteractor.start.2(DynamicIslandWindowViewTouchInteractor dynamicIslandWindowViewTouchInteractor) {
        this.this$0 = dynamicIslandWindowViewTouchInteractor;
    }

    public final Object emit(MotionEvent object, d d2) {
        object = this.this$0._trackTouchEvent.emit(object, d2);
        if (object == c.c()) {
            return object;
        }
        return s.a;
    }
}
