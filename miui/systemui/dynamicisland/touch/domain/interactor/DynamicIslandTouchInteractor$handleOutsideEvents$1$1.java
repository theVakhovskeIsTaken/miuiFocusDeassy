/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  G0.s
 *  K0.d
 *  M0.b
 *  android.view.MotionEvent
 *  i1.g
 */
package miui.systemui.dynamicisland.touch.domain.interactor;

import G0.s;
import K0.d;
import M0.b;
import android.view.MotionEvent;
import i1.g;
import miui.systemui.dynamicisland.event.DynamicIslandEventCoordinator;
import miui.systemui.dynamicisland.touch.TouchEvent;
import miui.systemui.dynamicisland.touch.domain.interactor.DynamicIslandTouchInteractor;
import miui.systemui.dynamicisland.window.content.DynamicIslandContentFakeView;

public static final class DynamicIslandTouchInteractor.handleOutsideEvents.1<T>
implements g {
    final DynamicIslandTouchInteractor this$0;

    public DynamicIslandTouchInteractor.handleOutsideEvents.1(DynamicIslandTouchInteractor dynamicIslandTouchInteractor) {
        this.this$0 = dynamicIslandTouchInteractor;
    }

    public final Object emit(TouchEvent touchEvent, d object) {
        DynamicIslandTouchInteractor dynamicIslandTouchInteractor = this.this$0;
        MotionEvent motionEvent = touchEvent.getEvent();
        object = new StringBuilder();
        ((StringBuilder)object).append("outside touch event ");
        ((StringBuilder)object).append(touchEvent);
        dynamicIslandTouchInteractor.logEvent(motionEvent, ((StringBuilder)object).toString());
        if (this.this$0.getInHeadsUpZone(touchEvent.getEvent())) {
            this.this$0.windowView.setTouchOutsideInHeadsUp(true);
        }
        object = this.this$0.getFakeView();
        if (!(!((DynamicIslandEventCoordinator)this.this$0.eventCoordinator.get()).getUserExpanded() || ((DynamicIslandEventCoordinator)this.this$0.eventCoordinator.get()).getEnterMiniWindow() || object != null && (object = ((DynamicIslandContentFakeView)((Object)object)).getTrackingToOpenMW()) != null && ((Boolean)object.getValue()).booleanValue() || this.this$0.getInHeadsUpZone(touchEvent.getEvent()))) {
            this.this$0.windowView.collapse("outside");
        }
        touchEvent.setResult(b.a((boolean)true));
        return s.a;
    }
}
