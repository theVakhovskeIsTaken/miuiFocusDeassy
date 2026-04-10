/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  G0.c
 *  G0.k
 *  G0.s
 *  K0.d
 *  L0.c
 *  M0.f
 *  M0.l
 *  U0.o
 *  android.os.Bundle
 *  android.os.Parcelable
 *  android.util.Log
 *  android.view.MotionEvent
 *  f1.E
 *  i1.g
 *  miui.systemui.util.MotionEventKt
 */
package miui.systemui.dynamicisland.touch.domain.interactor;

import G0.k;
import G0.s;
import K0.d;
import L0.c;
import M0.f;
import M0.l;
import U0.o;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.view.MotionEvent;
import f1.E;
import i1.g;
import miui.systemui.dynamicisland.touch.TouchEvent;
import miui.systemui.dynamicisland.touch.domain.interactor.DynamicIslandExternalTouchDispatcher;
import miui.systemui.util.MotionEventKt;

@f(c="miui.systemui.dynamicisland.touch.domain.interactor.DynamicIslandExternalTouchDispatcher$dispatchTouchEvent$1", f="DynamicIslandExternalTouchDispatcher.kt", l={55}, m="invokeSuspend")
public static final class DynamicIslandExternalTouchDispatcher.dispatchTouchEvent.1
extends l
implements o {
    int label;
    final DynamicIslandExternalTouchDispatcher this$0;

    public DynamicIslandExternalTouchDispatcher.dispatchTouchEvent.1(DynamicIslandExternalTouchDispatcher dynamicIslandExternalTouchDispatcher, d d2) {
        this.this$0 = dynamicIslandExternalTouchDispatcher;
        super(2, d2);
    }

    public final d create(Object object, d d2) {
        return new /* invalid duplicate definition of identical inner class */;
    }

    public final Object invoke(E e, d d2) {
        return (this.create(e, d2)).invokeSuspend(s.a);
    }

    public final Object invokeSuspend(Object object) {
        Object object2 = c.c();
        int n = this.label;
        if (n != 0) {
            if (n != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            k.b((Object)object);
        } else {
            k.b((Object)object);
            object = this.this$0.windowViewTouchInteractor.getDispatchTouchEvent();
            g g2 = new g(this.this$0){
                final DynamicIslandExternalTouchDispatcher this$0;
                {
                    this.this$0 = dynamicIslandExternalTouchDispatcher;
                }

                public final Object emit(TouchEvent object, d object2) {
                    object2 = new Bundle();
                    object2.putString("action_key", "action_external_touch");
                    object2.putParcelable("extra_motion_event", (Parcelable)((TouchEvent)object).getEvent());
                    object2.putString("extra_motion_event_source", ((TouchEvent)object).getSource());
                    object2 = DynamicIslandExternalTouchDispatcher.access$getWindowView$p(this.this$0).notifyIslandViewChanged((Bundle)object2);
                    if (object2 != null) {
                        int n = object2.getInt("extra_motion_event_result", -1);
                        object2 = TouchEvent.Companion.getToNullableBoolean(n);
                    } else {
                        object2 = null;
                    }
                    ((TouchEvent)object).setResult((Boolean)object2);
                    object2 = MotionEventKt.getMotionEventAction((MotionEvent)((TouchEvent)object).getEvent());
                    object = ((TouchEvent)object).getResult();
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("dispatch touch ");
                    stringBuilder.append((String)object2);
                    stringBuilder.append(" ");
                    stringBuilder.append(object);
                    Log.d((String)"DynamicIslandExternalTouchDispatcher", (String)stringBuilder.toString());
                    return s.a;
                }
            };
            this.label = 1;
            if (object.collect(g2, (d)this) == object2) {
                return object2;
            }
        }
        throw new G0.c();
    }
}
