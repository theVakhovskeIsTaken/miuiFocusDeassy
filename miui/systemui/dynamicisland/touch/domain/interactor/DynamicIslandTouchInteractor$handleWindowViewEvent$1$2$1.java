/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  G0.s
 *  K0.d
 *  android.view.MotionEvent
 *  i1.g
 */
package miui.systemui.dynamicisland.touch.domain.interactor;

import G0.s;
import K0.d;
import android.view.MotionEvent;
import i1.g;
import miui.systemui.dynamicisland.touch.TouchEvent;
import miui.systemui.dynamicisland.touch.domain.interactor.DynamicIslandTouchInteractor;

public static final class DynamicIslandTouchInteractor.handleWindowViewEvent.1.1<T>
implements g {
    final DynamicIslandTouchInteractor this$0;

    public DynamicIslandTouchInteractor.handleWindowViewEvent.1.1(DynamicIslandTouchInteractor dynamicIslandTouchInteractor) {
        this.this$0 = dynamicIslandTouchInteractor;
    }

    public final Object emit(TouchEvent touchEvent, d d2) {
        touchEvent.setResult(this.this$0.onTouchEvent(touchEvent.getEvent(), touchEvent.getSource()));
        DynamicIslandTouchInteractor dynamicIslandTouchInteractor = this.this$0;
        d2 = touchEvent.getEvent();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("handle touch event ");
        stringBuilder.append(touchEvent);
        dynamicIslandTouchInteractor.logEvent((MotionEvent)d2, stringBuilder.toString());
        return s.a;
    }
}
