/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  G0.c
 *  G0.k
 *  G0.s
 *  K0.d
 *  L0.c
 *  U0.o
 *  android.os.Bundle
 *  android.os.Parcelable
 *  android.util.Log
 *  android.view.MotionEvent
 *  f1.E
 *  f1.f
 *  i1.g
 *  i1.y
 *  kotlin.jvm.internal.o
 *  miui.systemui.util.MotionEventKt
 */
package miui.systemui.dynamicisland.touch.domain.interactor;

import G0.k;
import G0.s;
import K0.d;
import L0.c;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.view.MotionEvent;
import f1.E;
import f1.f;
import i1.g;
import i1.y;
import kotlin.jvm.internal.o;
import miui.systemui.dynamicisland.DynamicIslandStartable;
import miui.systemui.dynamicisland.dagger.DynamicIslandScope;
import miui.systemui.dynamicisland.dagger.qualifiers.DynamicIsland;
import miui.systemui.dynamicisland.touch.TouchEvent;
import miui.systemui.dynamicisland.window.DynamicIslandWindowView;
import miui.systemui.dynamicisland.window.domain.interactor.DynamicIslandWindowViewTouchInteractor;
import miui.systemui.util.MotionEventKt;

@DynamicIslandScope
public final class DynamicIslandExternalTouchDispatcher
implements DynamicIslandStartable {
    public static final Companion Companion = new Object(null){
        {
            this();
        }
    };
    private static final String TAG = "DynamicIslandExternalTouchDispatcher";
    private final E scope;
    private final DynamicIslandWindowView windowView;
    private final DynamicIslandWindowViewTouchInteractor windowViewTouchInteractor;

    public DynamicIslandExternalTouchDispatcher(@DynamicIsland E e, DynamicIslandWindowView dynamicIslandWindowView, DynamicIslandWindowViewTouchInteractor dynamicIslandWindowViewTouchInteractor) {
        o.g((Object)e, (String)"scope");
        o.g((Object)((Object)dynamicIslandWindowView), (String)"windowView");
        o.g((Object)dynamicIslandWindowViewTouchInteractor, (String)"windowViewTouchInteractor");
        this.scope = e;
        this.windowView = dynamicIslandWindowView;
        this.windowViewTouchInteractor = dynamicIslandWindowViewTouchInteractor;
    }

    public static final /* synthetic */ DynamicIslandWindowView access$getWindowView$p(DynamicIslandExternalTouchDispatcher dynamicIslandExternalTouchDispatcher) {
        return dynamicIslandExternalTouchDispatcher.windowView;
    }

    public static final /* synthetic */ DynamicIslandWindowViewTouchInteractor access$getWindowViewTouchInteractor$p(DynamicIslandExternalTouchDispatcher dynamicIslandExternalTouchDispatcher) {
        return dynamicIslandExternalTouchDispatcher.windowViewTouchInteractor;
    }

    private final void dispatchInterceptTouchEvent() {
        f.b((E)this.scope, null, null, (U0.o)new U0.o(this, null){
            int label;
            final DynamicIslandExternalTouchDispatcher this$0;
            {
                this.this$0 = dynamicIslandExternalTouchDispatcher;
                super(2, d2);
            }

            public final d create(Object object, d d2) {
                return new /* invalid duplicate definition of identical inner class */;
            }

            public final Object invoke(E e, d d2) {
                return (this.create(e, d2)).invokeSuspend(s.a);
            }

            public final Object invokeSuspend(Object g2) {
                Object object = c.c();
                int n = this.label;
                if (n != 0) {
                    if (n != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    k.b((Object)g2);
                } else {
                    k.b((Object)g2);
                    y y2 = DynamicIslandExternalTouchDispatcher.access$getWindowViewTouchInteractor$p(this.this$0).getDispatchInterceptTouchEvent();
                    g2 = new g(this.this$0){
                        final DynamicIslandExternalTouchDispatcher this$0;
                        {
                            this.this$0 = dynamicIslandExternalTouchDispatcher;
                        }

                        public final Object emit(TouchEvent object, d object2) {
                            object2 = new Bundle();
                            object2.putString("action_key", "action_external_intercept");
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
                            Boolean bl = ((TouchEvent)object).getResult();
                            object = new StringBuilder();
                            ((StringBuilder)object).append("dispatch intercept ");
                            ((StringBuilder)object).append((String)object2);
                            ((StringBuilder)object).append(" ");
                            ((StringBuilder)object).append(bl);
                            Log.d((String)"DynamicIslandExternalTouchDispatcher", (String)((StringBuilder)object).toString());
                            return s.a;
                        }
                    };
                    this.label = 1;
                    if (y2.collect(g2, (d)this) == object) {
                        return object;
                    }
                }
                throw new G0.c();
            }
        }, (int)3, null);
    }

    private final void dispatchTouchEvent() {
        f.b((E)this.scope, null, null, (U0.o)new U0.o(this, null){
            int label;
            final DynamicIslandExternalTouchDispatcher this$0;
            {
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
                    object = DynamicIslandExternalTouchDispatcher.access$getWindowViewTouchInteractor$p(this.this$0).getDispatchTouchEvent();
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
        }, (int)3, null);
    }

    @Override
    public void start() {
        this.dispatchInterceptTouchEvent();
        this.dispatchTouchEvent();
    }
}
