/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  G0.s
 *  K0.d
 *  android.os.Bundle
 *  android.os.Parcelable
 *  android.util.Log
 *  android.view.MotionEvent
 *  i1.g
 *  miui.systemui.util.MotionEventKt
 */
package miui.systemui.dynamicisland.touch.domain.interactor;

import G0.s;
import K0.d;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.view.MotionEvent;
import i1.g;
import miui.systemui.dynamicisland.touch.TouchEvent;
import miui.systemui.dynamicisland.touch.domain.interactor.DynamicIslandExternalTouchDispatcher;
import miui.systemui.util.MotionEventKt;

public static final class DynamicIslandExternalTouchDispatcher.dispatchInterceptTouchEvent.1<T>
implements g {
    final DynamicIslandExternalTouchDispatcher this$0;

    public DynamicIslandExternalTouchDispatcher.dispatchInterceptTouchEvent.1(DynamicIslandExternalTouchDispatcher dynamicIslandExternalTouchDispatcher) {
        this.this$0 = dynamicIslandExternalTouchDispatcher;
    }

    public final Object emit(TouchEvent object, d object2) {
        object2 = new Bundle();
        object2.putString("action_key", "action_external_intercept");
        object2.putParcelable("extra_motion_event", (Parcelable)((TouchEvent)object).getEvent());
        object2.putString("extra_motion_event_source", ((TouchEvent)object).getSource());
        object2 = this.this$0.windowView.notifyIslandViewChanged((Bundle)object2);
        if (object2 != null) {
            int n = object2.getInt("extra_motion_event_result", -1);
            object2 = TouchEvent.Companion.getToNullableBoolean(n);
        } else {
            object2 = null;
        }
        ((TouchEvent)object).setResult((Boolean)object2);
        object2 = MotionEventKt.getMotionEventAction((MotionEvent)((TouchEvent)object).getEvent());
        Boolean bl = ((TouchEvent)object).getResult();
        object = new StringBuilder();
        ((StringBuilder)object).append("dispatch intercept ");
        ((StringBuilder)object).append((String)object2);
        ((StringBuilder)object).append(" ");
        ((StringBuilder)object).append(bl);
        Log.d((String)"DynamicIslandExternalTouchDispatcher", (String)((StringBuilder)object).toString());
        return s.a;
    }
}
