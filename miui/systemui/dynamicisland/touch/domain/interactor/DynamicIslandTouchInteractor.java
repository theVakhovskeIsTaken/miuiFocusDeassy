/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  D0.a
 *  G0.c
 *  G0.i
 *  G0.k
 *  G0.s
 *  K0.d
 *  L0.c
 *  M0.b
 *  U0.o
 *  android.content.Context
 *  android.graphics.Rect
 *  android.graphics.Region
 *  android.os.Bundle
 *  android.util.Log
 *  android.view.MotionEvent
 *  android.view.View
 *  com.android.systemui.plugins.miui.dynamicisland.DynamicIslandData
 *  f1.E
 *  f1.f
 *  i1.I
 *  i1.K
 *  i1.f
 *  i1.g
 *  i1.h
 *  i1.u
 *  i1.y
 *  kotlin.jvm.internal.o
 *  miui.systemui.dagger.qualifiers.SystemUI
 *  miui.systemui.util.CommonUtils
 */
package miui.systemui.dynamicisland.touch.domain.interactor;

import D0.a;
import G0.c;
import G0.i;
import G0.k;
import G0.s;
import K0.d;
import M0.b;
import android.content.Context;
import android.graphics.Rect;
import android.graphics.Region;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import com.android.systemui.plugins.miui.dynamicisland.DynamicIslandData;
import f1.E;
import f1.f;
import i1.I;
import i1.K;
import i1.g;
import i1.h;
import i1.u;
import i1.y;
import kotlin.jvm.internal.o;
import miui.systemui.dagger.qualifiers.SystemUI;
import miui.systemui.dynamicisland.DynamicIslandScenarioUtils;
import miui.systemui.dynamicisland.DynamicIslandStartable;
import miui.systemui.dynamicisland.DynamicIslandUtils;
import miui.systemui.dynamicisland.anim.DynamicIslandAnimationController;
import miui.systemui.dynamicisland.dagger.DynamicIslandScope;
import miui.systemui.dynamicisland.dagger.qualifiers.DynamicIsland;
import miui.systemui.dynamicisland.event.DynamicIslandEvent;
import miui.systemui.dynamicisland.event.DynamicIslandEventCoordinator;
import miui.systemui.dynamicisland.event.handler.BigIslandStateHandler;
import miui.systemui.dynamicisland.event.handler.ExpandedStateHandler;
import miui.systemui.dynamicisland.event.handler.ShowOnceIslandHandler;
import miui.systemui.dynamicisland.event.handler.SmallIslandStateHandler;
import miui.systemui.dynamicisland.touch.Direction;
import miui.systemui.dynamicisland.touch.TouchEvent;
import miui.systemui.dynamicisland.touch.data.repository.DynamicIslandTouchConstantsRepository;
import miui.systemui.dynamicisland.touch.domain.interactor.DynamicIslandExternalTouchInteractor;
import miui.systemui.dynamicisland.window.DynamicIslandWindowState;
import miui.systemui.dynamicisland.window.DynamicIslandWindowView;
import miui.systemui.dynamicisland.window.DynamicIslandWindowViewController;
import miui.systemui.dynamicisland.window.content.DynamicIslandBaseContentView;
import miui.systemui.dynamicisland.window.content.DynamicIslandContentFakeView;
import miui.systemui.dynamicisland.window.content.DynamicIslandContentView;
import miui.systemui.dynamicisland.window.domain.interactor.DynamicIslandTouchRegionInteractor;
import miui.systemui.dynamicisland.window.domain.interactor.DynamicIslandWindowViewTouchInteractor;
import miui.systemui.util.CommonUtils;

@DynamicIslandScope
public final class DynamicIslandTouchInteractor
implements DynamicIslandStartable {
    public static final Companion Companion = new Object(null){
        {
            this();
        }
    };
    private static final String TAG = "DynamicIslandTouchInteractor";
    private final u _swipeInfo;
    private final DynamicIslandAnimationController animationController;
    private final a bigIslandStateHandler;
    private final Context context;
    private Direction direction;
    private boolean downInBigIsland;
    private boolean downInBigTempIsland;
    private boolean downInDefault;
    private boolean downInExpanded;
    private boolean downInFreeformAnim;
    private boolean downInMedia;
    private boolean downInSeekBar;
    private boolean downInShowOnceIsland;
    private boolean downInSmallIsland;
    private final a eventCoordinator;
    private final a expandedStateHandler;
    private final DynamicIslandExternalTouchInteractor externalTouchInteractor;
    private float initRawY;
    private float initX;
    private float initY;
    private Boolean intercepted;
    private boolean longClickReceived;
    private final E scope;
    private final a showOnceIslandHandler;
    private final a smallIslandStateHandler;
    private boolean swipeDispatched;
    private final I swipeInfo;
    private final Context sysUIContext;
    private final DynamicIslandTouchConstantsRepository touchConstants;
    private final DynamicIslandTouchRegionInteractor touchRegionInteractor;
    private String trackingPackage;
    private final DynamicIslandWindowState windowState;
    private final DynamicIslandWindowView windowView;
    private final DynamicIslandWindowViewController windowViewController;
    private final DynamicIslandWindowViewTouchInteractor windowViewTouchInteractor;

    public DynamicIslandTouchInteractor(@DynamicIsland E object, Context context, @SystemUI Context context2, DynamicIslandTouchConstantsRepository dynamicIslandTouchConstantsRepository, DynamicIslandWindowView dynamicIslandWindowView, DynamicIslandExternalTouchInteractor dynamicIslandExternalTouchInteractor, DynamicIslandWindowViewTouchInteractor dynamicIslandWindowViewTouchInteractor, a a2, a a3, a a4, a a5, a a6, DynamicIslandWindowState dynamicIslandWindowState, DynamicIslandWindowViewController dynamicIslandWindowViewController, DynamicIslandAnimationController dynamicIslandAnimationController, DynamicIslandTouchRegionInteractor dynamicIslandTouchRegionInteractor) {
        o.g((Object)object, (String)"scope");
        o.g((Object)context, (String)"context");
        o.g((Object)context2, (String)"sysUIContext");
        o.g((Object)dynamicIslandTouchConstantsRepository, (String)"touchConstants");
        o.g((Object)((Object)dynamicIslandWindowView), (String)"windowView");
        o.g((Object)dynamicIslandExternalTouchInteractor, (String)"externalTouchInteractor");
        o.g((Object)dynamicIslandWindowViewTouchInteractor, (String)"windowViewTouchInteractor");
        o.g((Object)a2, (String)"eventCoordinator");
        o.g((Object)a3, (String)"bigIslandStateHandler");
        o.g((Object)a4, (String)"showOnceIslandHandler");
        o.g((Object)a5, (String)"smallIslandStateHandler");
        o.g((Object)a6, (String)"expandedStateHandler");
        o.g((Object)dynamicIslandWindowState, (String)"windowState");
        o.g((Object)dynamicIslandWindowViewController, (String)"windowViewController");
        o.g((Object)dynamicIslandAnimationController, (String)"animationController");
        o.g((Object)dynamicIslandTouchRegionInteractor, (String)"touchRegionInteractor");
        this.scope = object;
        this.context = context;
        this.sysUIContext = context2;
        this.touchConstants = dynamicIslandTouchConstantsRepository;
        this.windowView = dynamicIslandWindowView;
        this.externalTouchInteractor = dynamicIslandExternalTouchInteractor;
        this.windowViewTouchInteractor = dynamicIslandWindowViewTouchInteractor;
        this.eventCoordinator = a2;
        this.bigIslandStateHandler = a3;
        this.showOnceIslandHandler = a4;
        this.smallIslandStateHandler = a5;
        this.expandedStateHandler = a6;
        this.windowState = dynamicIslandWindowState;
        this.windowViewController = dynamicIslandWindowViewController;
        this.animationController = dynamicIslandAnimationController;
        this.touchRegionInteractor = dynamicIslandTouchRegionInteractor;
        this.direction = Direction.UNKNOWN;
        object = Float.valueOf(0.0f);
        object = K.a((Object)new i(object, object));
        this._swipeInfo = object;
        this.swipeInfo = h.b((u)object);
    }

    public static final /* synthetic */ a access$getEventCoordinator$p(DynamicIslandTouchInteractor dynamicIslandTouchInteractor) {
        return dynamicIslandTouchInteractor.eventCoordinator;
    }

    public static final /* synthetic */ DynamicIslandContentFakeView access$getFakeView(DynamicIslandTouchInteractor dynamicIslandTouchInteractor) {
        return dynamicIslandTouchInteractor.getFakeView();
    }

    public static final /* synthetic */ boolean access$getInHeadsUpZone(DynamicIslandTouchInteractor dynamicIslandTouchInteractor, MotionEvent motionEvent) {
        return dynamicIslandTouchInteractor.getInHeadsUpZone(motionEvent);
    }

    public static final /* synthetic */ DynamicIslandWindowView access$getWindowView$p(DynamicIslandTouchInteractor dynamicIslandTouchInteractor) {
        return dynamicIslandTouchInteractor.windowView;
    }

    public static final /* synthetic */ DynamicIslandWindowViewTouchInteractor access$getWindowViewTouchInteractor$p(DynamicIslandTouchInteractor dynamicIslandTouchInteractor) {
        return dynamicIslandTouchInteractor.windowViewTouchInteractor;
    }

    public static final /* synthetic */ void access$logEvent(DynamicIslandTouchInteractor dynamicIslandTouchInteractor, MotionEvent motionEvent, String string) {
        dynamicIslandTouchInteractor.logEvent(motionEvent, string);
    }

    public static final /* synthetic */ Boolean access$onInterceptTouchEvent(DynamicIslandTouchInteractor dynamicIslandTouchInteractor, MotionEvent motionEvent, String string) {
        return dynamicIslandTouchInteractor.onInterceptTouchEvent(motionEvent, string);
    }

    public static final /* synthetic */ Boolean access$onTouchEvent(DynamicIslandTouchInteractor dynamicIslandTouchInteractor, MotionEvent motionEvent, String string) {
        return dynamicIslandTouchInteractor.onTouchEvent(motionEvent, string);
    }

    private final DynamicIslandContentFakeView getFakeView() {
        Object object;
        block6: {
            Object var2_2;
            block5: {
                object = this.trackingPackage;
                var2_2 = null;
                if (object == null || (object = this.windowView.getMiniWindowContentFakeView((String)object)) == null) break block5;
                if (this.downInDefault || this.downInBigIsland || this.downInSmallIsland) {
                    object = null;
                }
                if (object != null) break block6;
            }
            DynamicIslandContentView dynamicIslandContentView = this.windowView.getCurrentExpandedState();
            object = var2_2;
            if (dynamicIslandContentView != null) {
                object = dynamicIslandContentView.getFakeView();
            }
        }
        return object;
    }

    private final boolean getInHeadsUpZone(MotionEvent motionEvent) {
        boolean bl;
        i i2 = (i)((DynamicIslandEventCoordinator)this.eventCoordinator.get()).getHeadsUpZone().getValue();
        boolean bl2 = bl = false;
        if (i2 != null) {
            float f2 = motionEvent.getY();
            bl2 = bl;
            if (((Number)i2.d()).intValue() != 0) {
                bl2 = bl;
                if (((Number)i2.e()).intValue() != 0) {
                    bl2 = bl;
                    if (f2 > (float)((Number)i2.d()).intValue()) {
                        bl2 = bl;
                        if (f2 < (float)((Number)i2.e()).intValue()) {
                            bl2 = true;
                        }
                    }
                }
            }
        }
        return bl2;
    }

    private final DynamicIslandExternalTouchInteractor handleExternalEvent() {
        DynamicIslandExternalTouchInteractor dynamicIslandExternalTouchInteractor = this.externalTouchInteractor;
        f.b((E)this.scope, null, null, (U0.o)new U0.o(dynamicIslandExternalTouchInteractor, this, null){
            final DynamicIslandExternalTouchInteractor $this_apply;
            int label;
            final DynamicIslandTouchInteractor this$0;
            {
                this.$this_apply = dynamicIslandExternalTouchInteractor;
                this.this$0 = dynamicIslandTouchInteractor;
                super(2, d2);
            }

            public final d create(Object object, d d2) {
                return new /* invalid duplicate definition of identical inner class */;
            }

            public final Object invoke(E e, d d2) {
                return (this.create(e, d2)).invokeSuspend(s.a);
            }

            /*
             * Enabled force condition propagation
             * Lifted jumps to return sites
             */
            public final Object invokeSuspend(Object g2) {
                Object object = L0.c.c();
                int n = this.label;
                if (n != 0) {
                    if (n != 1) throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    k.b((Object)g2);
                    return s.a;
                } else {
                    k.b((Object)g2);
                    i1.f f2 = this.$this_apply.getExternalInterceptTouchEvent();
                    g2 = new g(this.this$0){
                        final DynamicIslandTouchInteractor this$0;
                        {
                            this.this$0 = dynamicIslandTouchInteractor;
                        }

                        public final Object emit(TouchEvent touchEvent, d object) {
                            touchEvent.setResult(DynamicIslandTouchInteractor.access$onInterceptTouchEvent(this.this$0, touchEvent.getEvent(), touchEvent.getSource()));
                            object = this.this$0;
                            MotionEvent motionEvent = touchEvent.getEvent();
                            StringBuilder stringBuilder = new StringBuilder();
                            stringBuilder.append("intercept touch event ");
                            stringBuilder.append(touchEvent);
                            DynamicIslandTouchInteractor.access$logEvent((DynamicIslandTouchInteractor)object, motionEvent, stringBuilder.toString());
                            return s.a;
                        }
                    };
                    this.label = 1;
                    if (f2.collect(g2, (d)this) != object) return s.a;
                    return object;
                }
            }
        }, (int)3, null);
        f.b((E)this.scope, null, null, (U0.o)new U0.o(dynamicIslandExternalTouchInteractor, this, null){
            final DynamicIslandExternalTouchInteractor $this_apply;
            int label;
            final DynamicIslandTouchInteractor this$0;
            {
                this.$this_apply = dynamicIslandExternalTouchInteractor;
                this.this$0 = dynamicIslandTouchInteractor;
                super(2, d2);
            }

            public final d create(Object object, d d2) {
                return new /* invalid duplicate definition of identical inner class */;
            }

            public final Object invoke(E e, d d2) {
                return (this.create(e, d2)).invokeSuspend(s.a);
            }

            /*
             * Enabled force condition propagation
             * Lifted jumps to return sites
             */
            public final Object invokeSuspend(Object object) {
                Object object2 = L0.c.c();
                int n = this.label;
                if (n != 0) {
                    if (n != 1) throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    k.b((Object)object);
                    return s.a;
                } else {
                    k.b((Object)object);
                    object = this.$this_apply.getExternalTouchEvent();
                    g g2 = new g(this.this$0){
                        final DynamicIslandTouchInteractor this$0;
                        {
                            this.this$0 = dynamicIslandTouchInteractor;
                        }

                        public final Object emit(TouchEvent touchEvent, d d2) {
                            touchEvent.setResult(DynamicIslandTouchInteractor.access$onTouchEvent(this.this$0, touchEvent.getEvent(), touchEvent.getSource()));
                            DynamicIslandTouchInteractor dynamicIslandTouchInteractor = this.this$0;
                            d2 = touchEvent.getEvent();
                            StringBuilder stringBuilder = new StringBuilder();
                            stringBuilder.append("handle touch event ");
                            stringBuilder.append(touchEvent);
                            DynamicIslandTouchInteractor.access$logEvent(dynamicIslandTouchInteractor, (MotionEvent)d2, stringBuilder.toString());
                            return s.a;
                        }
                    };
                    this.label = 1;
                    if (object.collect(g2, (d)this) != object2) return s.a;
                    return object2;
                }
            }
        }, (int)3, null);
        return dynamicIslandExternalTouchInteractor;
    }

    private final void handleOutsideEvents() {
        f.b((E)this.scope, null, null, (U0.o)new U0.o(this, null){
            int label;
            final DynamicIslandTouchInteractor this$0;
            {
                this.this$0 = dynamicIslandTouchInteractor;
                super(2, d2);
            }

            public final d create(Object object, d d2) {
                return new /* invalid duplicate definition of identical inner class */;
            }

            public final Object invoke(E e, d d2) {
                return (this.create(e, d2)).invokeSuspend(s.a);
            }

            /*
             * Enabled force condition propagation
             * Lifted jumps to return sites
             */
            public final Object invokeSuspend(Object g2) {
                Object object = L0.c.c();
                int n = this.label;
                if (n != 0) {
                    if (n != 1) throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    k.b((Object)g2);
                    return s.a;
                } else {
                    k.b((Object)g2);
                    i1.f f2 = DynamicIslandTouchInteractor.access$getWindowViewTouchInteractor$p(this.this$0).getOutsideTouchEvent();
                    g2 = new g(this.this$0){
                        final DynamicIslandTouchInteractor this$0;
                        {
                            this.this$0 = dynamicIslandTouchInteractor;
                        }

                        public final Object emit(TouchEvent touchEvent, d object) {
                            DynamicIslandTouchInteractor dynamicIslandTouchInteractor = this.this$0;
                            MotionEvent motionEvent = touchEvent.getEvent();
                            object = new StringBuilder();
                            ((StringBuilder)object).append("outside touch event ");
                            ((StringBuilder)object).append(touchEvent);
                            DynamicIslandTouchInteractor.access$logEvent(dynamicIslandTouchInteractor, motionEvent, ((StringBuilder)object).toString());
                            if (DynamicIslandTouchInteractor.access$getInHeadsUpZone(this.this$0, touchEvent.getEvent())) {
                                DynamicIslandTouchInteractor.access$getWindowView$p(this.this$0).setTouchOutsideInHeadsUp(true);
                            }
                            object = DynamicIslandTouchInteractor.access$getFakeView(this.this$0);
                            if (!(!((DynamicIslandEventCoordinator)DynamicIslandTouchInteractor.access$getEventCoordinator$p(this.this$0).get()).getUserExpanded() || ((DynamicIslandEventCoordinator)DynamicIslandTouchInteractor.access$getEventCoordinator$p(this.this$0).get()).getEnterMiniWindow() || object != null && (object = ((DynamicIslandContentFakeView)((Object)object)).getTrackingToOpenMW()) != null && ((Boolean)object.getValue()).booleanValue() || DynamicIslandTouchInteractor.access$getInHeadsUpZone(this.this$0, touchEvent.getEvent()))) {
                                DynamicIslandTouchInteractor.access$getWindowView$p(this.this$0).collapse("outside");
                            }
                            touchEvent.setResult(b.a((boolean)true));
                            return s.a;
                        }
                    };
                    this.label = 1;
                    if (f2.collect(g2, (d)this) != object) return s.a;
                    return object;
                }
            }
        }, (int)3, null);
    }

    private final DynamicIslandWindowViewTouchInteractor handleWindowViewEvent() {
        DynamicIslandWindowViewTouchInteractor dynamicIslandWindowViewTouchInteractor = this.windowViewTouchInteractor;
        f.b((E)this.scope, null, null, (U0.o)new U0.o(dynamicIslandWindowViewTouchInteractor, this, null){
            final DynamicIslandWindowViewTouchInteractor $this_apply;
            int label;
            final DynamicIslandTouchInteractor this$0;
            {
                this.$this_apply = dynamicIslandWindowViewTouchInteractor;
                this.this$0 = dynamicIslandTouchInteractor;
                super(2, d2);
            }

            public final d create(Object object, d d2) {
                return new /* invalid duplicate definition of identical inner class */;
            }

            public final Object invoke(E e, d d2) {
                return (this.create(e, d2)).invokeSuspend(s.a);
            }

            public final Object invokeSuspend(Object object) {
                Object object2 = L0.c.c();
                int n = this.label;
                if (n != 0) {
                    if (n != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    k.b((Object)object);
                } else {
                    k.b((Object)object);
                    object = this.$this_apply.getIslandInterceptTouchEvent();
                    g g2 = new g(this.this$0){
                        final DynamicIslandTouchInteractor this$0;
                        {
                            this.this$0 = dynamicIslandTouchInteractor;
                        }

                        public final Object emit(TouchEvent touchEvent, d object) {
                            touchEvent.setResult(DynamicIslandTouchInteractor.access$onInterceptTouchEvent(this.this$0, touchEvent.getEvent(), touchEvent.getSource()));
                            object = this.this$0;
                            MotionEvent motionEvent = touchEvent.getEvent();
                            StringBuilder stringBuilder = new StringBuilder();
                            stringBuilder.append("intercept touch event ");
                            stringBuilder.append(touchEvent);
                            DynamicIslandTouchInteractor.access$logEvent((DynamicIslandTouchInteractor)object, motionEvent, stringBuilder.toString());
                            return s.a;
                        }
                    };
                    this.label = 1;
                    if (object.collect(g2, (d)this) == object2) {
                        return object2;
                    }
                }
                throw new c();
            }
        }, (int)3, null);
        f.b((E)this.scope, null, null, (U0.o)new U0.o(dynamicIslandWindowViewTouchInteractor, this, null){
            final DynamicIslandWindowViewTouchInteractor $this_apply;
            int label;
            final DynamicIslandTouchInteractor this$0;
            {
                this.$this_apply = dynamicIslandWindowViewTouchInteractor;
                this.this$0 = dynamicIslandTouchInteractor;
                super(2, d2);
            }

            public final d create(Object object, d d2) {
                return new /* invalid duplicate definition of identical inner class */;
            }

            public final Object invoke(E e, d d2) {
                return (this.create(e, d2)).invokeSuspend(s.a);
            }

            public final Object invokeSuspend(Object g2) {
                Object object = L0.c.c();
                int n = this.label;
                if (n != 0) {
                    if (n != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    k.b((Object)g2);
                } else {
                    k.b((Object)g2);
                    y y2 = this.$this_apply.getIslandTouchEvent();
                    g2 = new g(this.this$0){
                        final DynamicIslandTouchInteractor this$0;
                        {
                            this.this$0 = dynamicIslandTouchInteractor;
                        }

                        public final Object emit(TouchEvent touchEvent, d d2) {
                            touchEvent.setResult(DynamicIslandTouchInteractor.access$onTouchEvent(this.this$0, touchEvent.getEvent(), touchEvent.getSource()));
                            DynamicIslandTouchInteractor dynamicIslandTouchInteractor = this.this$0;
                            d2 = touchEvent.getEvent();
                            StringBuilder stringBuilder = new StringBuilder();
                            stringBuilder.append("handle touch event ");
                            stringBuilder.append(touchEvent);
                            DynamicIslandTouchInteractor.access$logEvent(dynamicIslandTouchInteractor, (MotionEvent)d2, stringBuilder.toString());
                            return s.a;
                        }
                    };
                    this.label = 1;
                    if (y2.collect(g2, (d)this) == object) {
                        return object;
                    }
                }
                throw new c();
            }
        }, (int)3, null);
        return dynamicIslandWindowViewTouchInteractor;
    }

    private final void logEvent(MotionEvent motionEvent, String string) {
        if (TouchEvent.Companion.getShouldLog(motionEvent)) {
            Log.d((String)TAG, (String)string);
        }
    }

    /*
     * WARNING - void declaration
     * Enabled aggressive block sorting
     */
    private final Boolean onInterceptTouchEvent(MotionEvent object, String object2) {
        float f2;
        boolean bl;
        int n = object.getActionMasked();
        DynamicIslandContentView dynamicIslandContentView = ((BigIslandStateHandler)this.bigIslandStateHandler.get()).getCurrent();
        Object object3 = ((ShowOnceIslandHandler)this.showOnceIslandHandler.get()).getCurrent();
        DynamicIslandContentView dynamicIslandContentView2 = ((BigIslandStateHandler)this.bigIslandStateHandler.get()).getCurrentTempShow();
        Object object4 = ((SmallIslandStateHandler)this.smallIslandStateHandler.get()).getCurrent();
        DynamicIslandContentView dynamicIslandContentView3 = ((ExpandedStateHandler)this.expandedStateHandler.get()).getCurrent();
        if (n == 0) {
            Rect rect;
            this.initX = object.getX();
            this.initY = object.getY();
            this.initRawY = object.getRawY();
            this.intercepted = null;
            this.swipeDispatched = false;
            this.direction = Direction.UNKNOWN;
            this.longClickReceived = false;
            bl = dynamicIslandContentView != null && (rect = DynamicIslandBaseContentView.getBigIslandRect$default(dynamicIslandContentView, null, 1, null)) != null ? TouchEvent.Companion.inRect((MotionEvent)object, rect) : false;
            this.downInBigIsland = bl;
            bl = dynamicIslandContentView2 != null && (dynamicIslandContentView2 = DynamicIslandBaseContentView.getBigIslandRect$default(dynamicIslandContentView2, null, 1, null)) != null ? TouchEvent.Companion.inRect((MotionEvent)object, (Rect)dynamicIslandContentView2) : false;
            this.downInBigTempIsland = bl;
            if (dynamicIslandContentView == null || object4 == null) {
                bl = false;
            } else {
                f2 = CommonUtils.isLayoutRtl((Context)this.context) ? (float)(DynamicIslandBaseContentView.getCurrentBigIslandX$default(dynamicIslandContentView, null, 1, null) - dynamicIslandContentView.getSpace() - dynamicIslandContentView.getSmallIslandViewWidth()) : (float)(DynamicIslandBaseContentView.getCurrentBigIslandX$default(dynamicIslandContentView, null, 1, null) + DynamicIslandBaseContentView.getCurrentBigIslandWidth$default(dynamicIslandContentView, null, 1, null) + dynamicIslandContentView.getSpace());
                bl = TouchEvent.Companion.inRect((MotionEvent)object, ((DynamicIslandBaseContentView)((Object)object4)).getSmallIslandRect((int)f2));
            }
            this.downInSmallIsland = bl;
            bl = object3 != null && (object3 = ((DynamicIslandBaseContentView)((Object)object3)).getBigIslandRect(Boolean.FALSE)) != null ? TouchEvent.Companion.inRect((MotionEvent)object, (Rect)object3) : false;
            this.downInShowOnceIsland = bl;
            if (bl) {
                this.downInBigIsland = false;
                this.downInSmallIsland = false;
            } else {
                bl = dynamicIslandContentView != null && (object3 = DynamicIslandBaseContentView.getBigIslandRect$default(dynamicIslandContentView, null, 1, null)) != null ? TouchEvent.Companion.inRect((MotionEvent)object, (Rect)object3) : false;
                this.downInBigIsland = bl;
                if (dynamicIslandContentView == null || object4 == null) {
                    bl = false;
                } else {
                    f2 = CommonUtils.isLayoutRtl((Context)this.context) ? (float)(DynamicIslandBaseContentView.getCurrentBigIslandX$default(dynamicIslandContentView, null, 1, null) - dynamicIslandContentView.getSpace() - dynamicIslandContentView.getSmallIslandViewWidth()) : (float)(DynamicIslandBaseContentView.getCurrentBigIslandX$default(dynamicIslandContentView, null, 1, null) + DynamicIslandBaseContentView.getCurrentBigIslandWidth$default(dynamicIslandContentView, null, 1, null) + dynamicIslandContentView.getSpace());
                    bl = TouchEvent.Companion.inRect((MotionEvent)object, ((DynamicIslandBaseContentView)((Object)object4)).getSmallIslandRect((int)f2));
                }
                this.downInSmallIsland = bl;
            }
            bl = dynamicIslandContentView3 != null && (object4 = dynamicIslandContentView3.getExpandedIslandRect()) != null ? TouchEvent.Companion.inRect((MotionEvent)object, (Rect)object4) : false;
            this.downInExpanded = bl;
            this.downInDefault = TouchEvent.Companion.inRegion((MotionEvent)object, ((DynamicIslandEventCoordinator)this.eventCoordinator.get()).getDefaultIslandTouchRegion());
            this.downInFreeformAnim = (Boolean)this.windowViewController.isFreeformAnimRunning().getValue();
            this.downInSeekBar = this.windowView.downInMedia(this.sysUIContext, this.initX, this.initY, (View)dynamicIslandContentView3, true);
            this.downInMedia = bl = DynamicIslandWindowView.downInMedia$default(this.windowView, this.sysUIContext, this.initX, this.initY, (View)dynamicIslandContentView3, false, 16, null);
            if (!bl && !this.windowViewController.windowAnimating()) {
                ((DynamicIslandEventCoordinator)this.eventCoordinator.get()).dispatchPress(this.downInBigIsland, this.downInSmallIsland, this.downInExpanded);
            }
            if ((object4 = this.getFakeView()) != null) {
                ((DynamicIslandContentFakeView)((Object)object4)).resetTrackOpenMW();
            }
            boolean bl2 = this.downInShowOnceIsland;
            bl = this.downInBigIsland;
            boolean bl3 = this.downInSmallIsland;
            boolean bl4 = this.downInExpanded;
            boolean bl5 = this.downInDefault;
            boolean bl6 = this.downInSeekBar;
            boolean bl7 = this.downInMedia;
            boolean bl8 = this.downInBigTempIsland;
            object4 = new StringBuilder();
            ((StringBuilder)object4).append("intercept down,  downInShowOnceIsland: ");
            ((StringBuilder)object4).append(bl2);
            ((StringBuilder)object4).append(", downInBigIsland: ");
            ((StringBuilder)object4).append(bl);
            ((StringBuilder)object4).append(", downInSmallIsland: ");
            ((StringBuilder)object4).append(bl3);
            ((StringBuilder)object4).append(", downInExpanded: ");
            ((StringBuilder)object4).append(bl4);
            ((StringBuilder)object4).append(", downInDefault: ");
            ((StringBuilder)object4).append(bl5);
            ((StringBuilder)object4).append(", downInSeekBar:");
            ((StringBuilder)object4).append(bl6);
            ((StringBuilder)object4).append(", downInMedia ");
            ((StringBuilder)object4).append(bl7);
            ((StringBuilder)object4).append(", downInBigTempIsland: ");
            ((StringBuilder)object4).append(bl8);
            ((StringBuilder)object4).append(".");
            Log.d((String)TAG, (String)((StringBuilder)object4).toString());
        }
        if (o.c((Object)(object4 = this.intercepted), (Object)(object3 = Boolean.TRUE))) {
            return object3;
        }
        Boolean bl9 = this.intercepted;
        object4 = Boolean.FALSE;
        if (o.c((Object)bl9, (Object)object4)) {
            return null;
        }
        if (n == 2) {
            float f3 = object.getX() - this.initX;
            float f4 = object.getY() - this.initY;
            float f5 = Math.abs(f3);
            float f6 = Math.abs(f4);
            float f7 = ((Number)this.touchConstants.getTouchSlop().getValue()).intValue();
            if (f5 > f7 || f6 > f7) {
                void var2_8;
                void var19_25;
                f2 = f5 == f6 ? 0 : (f5 > f6 ? 1 : -1);
                if (f2 > 0 && f3 > 0.0f) {
                    Direction direction = Direction.RIGHT;
                } else if (f2 > 0) {
                    Direction direction = Direction.LEFT;
                } else if (f4 > 0.0f) {
                    Direction direction = Direction.DOWN;
                } else {
                    Direction direction = Direction.UP;
                }
                this.direction = var19_25;
                if (this.downInShowOnceIsland) {
                    object4 = var19_25.isHorizontal();
                } else if (this.downInBigIsland) {
                    object4 = var19_25.isHorizontal();
                } else if (this.downInSmallIsland) {
                    object4 = var19_25.isHorizontal();
                } else if (this.downInSeekBar) {
                    object4 = var19_25.isVertical();
                } else if (this.downInExpanded) {
                    object4 = object3;
                } else if (this.downInDefault) {
                    object4 = var19_25.isHorizontal();
                } else if (this.downInFreeformAnim) {
                    object4 = var19_25.isUp();
                } else if (this.downInBigTempIsland) {
                    object4 = var19_25.isHorizontal();
                }
                this.intercepted = object4;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("intercepted: ");
                stringBuilder.append(object4);
                stringBuilder.append(", source: ");
                stringBuilder.append((String)var2_8);
                stringBuilder.append(".");
                Log.d((String)TAG, (String)stringBuilder.toString());
                ((DynamicIslandEventCoordinator)this.eventCoordinator.get()).resetPress(this.downInBigIsland, this.downInSmallIsland, this.downInExpanded);
                if (this.direction.isHorizontal() && ((bl = this.downInBigIsland) || this.downInSmallIsland)) {
                    DynamicIslandScenarioUtils.INSTANCE.setSwipeIslandStart(bl, this.downInSmallIsland, this.downInShowOnceIsland);
                }
                if (this.downInExpanded && this.direction.isUp()) {
                    DynamicIslandScenarioUtils.INSTANCE.setSwipeExpandStart();
                }
                if (this.downInExpanded && o.c((Object)this.intercepted, (Object)object3)) {
                    DynamicIslandContentFakeView dynamicIslandContentFakeView;
                    void var2_15;
                    Bundle bundle;
                    DynamicIslandData dynamicIslandData;
                    DynamicIslandContentView dynamicIslandContentView4 = this.windowView.getCurrentExpandedState();
                    if (dynamicIslandContentView4 != null && (dynamicIslandData = dynamicIslandContentView4.getCurrentIslandData()) != null && (bundle = dynamicIslandData.getExtras()) != null) {
                        String string = bundle.getString("miui.pkg.name");
                    } else {
                        Object var2_14 = null;
                    }
                    this.trackingPackage = var2_15;
                    MotionEvent motionEvent = MotionEvent.obtain((MotionEvent)object);
                    motionEvent.setAction(0);
                    DynamicIslandContentView dynamicIslandContentView5 = this.windowView.getCurrentExpandedState();
                    if (dynamicIslandContentView5 != null && (dynamicIslandContentFakeView = dynamicIslandContentView5.getFakeView()) != null) {
                        dynamicIslandContentFakeView.handleTouchEvent(motionEvent);
                    }
                    motionEvent.recycle();
                }
            }
        }
        if (n == 1 || n == 3) {
            DynamicIslandContentView dynamicIslandContentView6;
            ((DynamicIslandEventCoordinator)this.eventCoordinator.get()).resetPress(this.downInBigIsland, this.downInSmallIsland, this.downInExpanded);
            if (this.downInBigIsland) {
                DynamicIslandContentView dynamicIslandContentView7 = this.windowView.getCurrentBigIslandState();
                if (dynamicIslandContentView7 != null) {
                    this.windowView.cancelLongPressRunnable(dynamicIslandContentView7);
                }
            } else if (this.downInSmallIsland && (dynamicIslandContentView6 = this.windowView.getCurrentSmallIslandState()) != null) {
                this.windowView.cancelLongPressRunnable(dynamicIslandContentView6);
            }
            if (this.downInMedia && this.downInExpanded) {
                this.windowView.downInWhichButton(this.sysUIContext, this.initX, this.initY, (View)dynamicIslandContentView3);
                DynamicIslandContentView dynamicIslandContentView8 = ((ExpandedStateHandler)this.expandedStateHandler.get()).getCurrent();
                if (dynamicIslandContentView8 != null) {
                    dynamicIslandContentView8.clickOnButtonTrack(true, true);
                }
            }
        }
        if (this.longClickReceived) {
            return object3;
        }
        if (o.c((Object)this.intercepted, (Object)object3)) {
            return object3;
        }
        return null;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private final Boolean onTouchEvent(MotionEvent object, String object2) {
        object2 = this.intercepted;
        Object object3 = Boolean.TRUE;
        boolean bl = o.c((Object)object2, (Object)object3);
        object2 = null;
        if (!bl) {
            return null;
        }
        if (((Region)this.touchRegionInteractor.getWindowViewTouchRegion().getValue()).isEmpty()) {
            return Boolean.FALSE;
        }
        int n = object.getActionMasked();
        float f2 = object.getX() - this.initX;
        float f3 = object.getY() - this.initY;
        if (n != 0) {
            if (n != 1) {
                if (n != 2) {
                    if (n != 3) {
                        return Boolean.FALSE;
                    }
                } else {
                    if (this.windowState.isTinyScreen()) return Boolean.FALSE;
                    bl = this.downInExpanded && !this.direction.isDown();
                    if ((this.downInBigIsland || this.downInSmallIsland || bl || this.downInDefault) && ((ShowOnceIslandHandler)this.showOnceIslandHandler.get()).getCurrent() == null && !this.longClickReceived && !this.windowViewController.windowAnimating()) {
                        this.swipeDispatched = true;
                        this._swipeInfo.setValue((Object)new i((Object)Float.valueOf(f2), (Object)Float.valueOf(f3)));
                        ((DynamicIslandEventCoordinator)this.eventCoordinator.get()).dispatchSwipe(f2, f3, bl);
                    }
                    if (!this.direction.isVertical()) return Boolean.FALSE;
                    object2 = this.windowView.getCurrentExpandedState();
                    if (object2 == null) return Boolean.FALSE;
                    if ((object2 = ((DynamicIslandBaseContentView)((Object)object2)).getFakeView()) == null) return Boolean.FALSE;
                    ((DynamicIslandContentFakeView)((Object)object2)).handleTouchEvent((MotionEvent)object);
                    return Boolean.FALSE;
                }
            }
            this._swipeInfo.setValue((Object)new i((Object)Float.valueOf(0.0f), (Object)Float.valueOf(0.0f)));
            ((DynamicIslandEventCoordinator)this.eventCoordinator.get()).stopSwipe();
            DynamicIslandContentFakeView dynamicIslandContentFakeView = this.getFakeView();
            n = ((Number)this.touchConstants.getSwipeThreshold().getValue()).intValue();
            Direction direction = this.direction;
            float f4 = Math.abs(f2);
            float f5 = Math.abs(f3);
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("handle ACTION_UP: direction: ");
            stringBuilder.append((Object)direction);
            stringBuilder.append(", x:");
            stringBuilder.append(f4);
            stringBuilder.append(", y:");
            stringBuilder.append(f5);
            stringBuilder.append(", threshold:");
            stringBuilder.append(n);
            Log.d((String)TAG, (String)stringBuilder.toString());
            if (this.direction.isHorizontal() && Math.abs(f2) > (float)n && (dynamicIslandContentFakeView == null || (stringBuilder = dynamicIslandContentFakeView.getTrackingToOpenMW()) == null || !((Boolean)stringBuilder.getValue()).booleanValue()) && this.downInShowOnceIsland) {
                this.windowView.isTempShowBigIslandToBeRemoved();
                this.windowView.collapse("outside");
                return object3;
            }
            if (this.direction.isHorizontal() && Math.abs(f2) > (float)n && (dynamicIslandContentFakeView == null || (stringBuilder = dynamicIslandContentFakeView.getTrackingToOpenMW()) == null || !((Boolean)stringBuilder.getValue()).booleanValue())) {
                if (this.downInExpanded) {
                    this.windowView.collapse("swipe horizon");
                    return object3;
                } else {
                    if (!(this.downInBigIsland || this.downInSmallIsland || this.downInDefault)) {
                        if (!this.downInBigTempIsland) return object3;
                    }
                    if (this.windowView.isTempShowBigIslandToBeRemoved()) return object3;
                    if (this.windowState.isTinyScreen()) return object3;
                    if (!this.windowState.canSwipe()) return object3;
                    if (this.windowViewController.windowAnimating()) return object3;
                    object = this.windowView.isSwipeTowardsSmallIsland(f2) ? DynamicIslandEvent.SwipeRight.INSTANCE : DynamicIslandEvent.SwipeLeft.INSTANCE;
                    object2 = this.eventCoordinator.get();
                    o.f((Object)object2, (String)"get(...)");
                    DynamicIslandEventCoordinator.dispatchEvent$default((DynamicIslandEventCoordinator)object2, (DynamicIslandEvent)object, null, 2, null);
                }
                return object3;
            }
            if (this.swipeDispatched) {
                ((DynamicIslandEventCoordinator)this.eventCoordinator.get()).resetSwipe(f2, f3);
            }
            if (dynamicIslandContentFakeView != null && dynamicIslandContentFakeView.handleTouchEvent((MotionEvent)object)) {
                return object3;
            }
            if (!this.direction.isUp()) return Boolean.FALSE;
            if (!(Math.abs(f3) > (float)n)) return Boolean.FALSE;
            if (this.downInExpanded) {
                this.windowView.collapse("swipe up");
                return object3;
            }
            if ((Boolean)this.windowViewController.isFreeformAnimRunning().getValue() == false) return Boolean.FALSE;
            object = this.trackingPackage;
            if (object == null) return Boolean.FALSE;
            if ((object = this.windowView.getMainMiniWindowState((String)object)) == null) return Boolean.FALSE;
            object3 = ((DynamicIslandBaseContentView)((Object)object)).getFakeView();
            object = object2;
            if (object3 == null) return object;
            return ((DynamicIslandContentFakeView)((Object)object3)).freeFormGestureBack();
        }
        Log.wtf((String)TAG, (String)"receiving down event.", (Throwable)new Throwable());
        return Boolean.FALSE;
    }

    private static final void performPressed$press(DynamicIslandTouchInteractor dynamicIslandTouchInteractor, DynamicIslandContentView dynamicIslandContentView, boolean bl) {
        if (bl) {
            dynamicIslandTouchInteractor.animationController.onPress(dynamicIslandContentView);
        } else {
            dynamicIslandTouchInteractor.animationController.resetPress(dynamicIslandContentView);
        }
    }

    public final I getSwipeInfo() {
        return this.swipeInfo;
    }

    public final void notifyLongClickReceived() {
        this.longClickReceived = true;
    }

    public final void performClick() {
        DynamicIslandContentView dynamicIslandContentView;
        if (this.downInShowOnceIsland) {
            DynamicIslandContentView dynamicIslandContentView2 = ((ShowOnceIslandHandler)this.showOnceIslandHandler.get()).getCurrent();
            if (dynamicIslandContentView2 != null) {
                dynamicIslandContentView2.onIslandClick();
            }
        } else if (this.downInExpanded) {
            DynamicIslandContentView dynamicIslandContentView3 = ((ExpandedStateHandler)this.expandedStateHandler.get()).getCurrent();
            if (dynamicIslandContentView3 != null) {
                dynamicIslandContentView3.onIslandClick();
            }
        } else if (this.downInBigIsland) {
            DynamicIslandContentView dynamicIslandContentView4 = ((BigIslandStateHandler)this.bigIslandStateHandler.get()).getCurrent();
            if (dynamicIslandContentView4 != null) {
                dynamicIslandContentView4.onIslandClick();
            }
        } else if (this.downInSmallIsland && (dynamicIslandContentView = ((SmallIslandStateHandler)this.smallIslandStateHandler.get()).getCurrent()) != null) {
            dynamicIslandContentView.onIslandClick();
        }
    }

    public final boolean performLongClick() {
        DynamicIslandContentView dynamicIslandContentView;
        if (CommonUtils.INSTANCE.getIS_TABLET() && this.downInBigIsland) {
            return true;
        }
        if (this.downInExpanded) {
            return false;
        }
        if (((BigIslandStateHandler)this.bigIslandStateHandler.get()).getCurrentTempShow() != null) {
            return true;
        }
        if (DynamicIslandUtils.INSTANCE.isInternationalBuild()) {
            return false;
        }
        this.longClickReceived = true;
        ((DynamicIslandEventCoordinator)this.eventCoordinator.get()).resetPress(this.downInBigIsland, this.downInSmallIsland, this.downInExpanded);
        if (this.downInBigIsland) {
            DynamicIslandContentView dynamicIslandContentView2 = this.windowView.getCurrentBigIslandState();
            if (dynamicIslandContentView2 != null) {
                this.windowView.onLongPress(dynamicIslandContentView2, dynamicIslandContentView2, this.initRawY);
            }
        } else if (this.downInSmallIsland && (dynamicIslandContentView = this.windowView.getCurrentSmallIslandState()) != null) {
            this.windowView.onLongPress(dynamicIslandContentView, dynamicIslandContentView, this.initRawY);
        }
        return true;
    }

    public final void performPressed(boolean bl) {
        if (this.downInExpanded) {
            DynamicIslandTouchInteractor.performPressed$press(this, ((ExpandedStateHandler)this.expandedStateHandler.get()).getCurrent(), bl);
        } else if (this.downInBigIsland) {
            DynamicIslandTouchInteractor.performPressed$press(this, ((BigIslandStateHandler)this.bigIslandStateHandler.get()).getCurrent(), bl);
        } else if (this.downInSmallIsland) {
            DynamicIslandTouchInteractor.performPressed$press(this, ((SmallIslandStateHandler)this.smallIslandStateHandler.get()).getCurrent(), bl);
        }
    }

    @Override
    public void start() {
        this.handleOutsideEvents();
        this.handleExternalEvent();
        this.handleWindowViewEvent();
    }
}
