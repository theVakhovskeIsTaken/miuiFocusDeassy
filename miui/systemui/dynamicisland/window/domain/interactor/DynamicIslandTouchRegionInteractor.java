/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  D0.a
 *  G0.c
 *  G0.d
 *  G0.e
 *  G0.k
 *  G0.s
 *  K0.d
 *  L0.c
 *  U0.a
 *  U0.o
 *  U0.q
 *  android.content.Context
 *  android.graphics.Canvas
 *  android.graphics.Paint
 *  android.graphics.Region
 *  android.graphics.Region$Op
 *  android.os.SystemProperties
 *  android.util.Log
 *  android.view.ViewTreeObserver
 *  android.view.ViewTreeObserver$InternalInsetsInfo
 *  android.view.ViewTreeObserver$OnComputeInternalInsetsListener
 *  f1.E
 *  f1.f
 *  h1.h
 *  h1.o
 *  h1.q
 *  i1.E
 *  i1.I
 *  i1.f
 *  i1.g
 *  i1.h
 *  i1.y
 *  kotlin.jvm.internal.o
 *  miui.systemui.util.ConvenienceExtensionsKt
 *  miui.systemui.util.coroutines.flow.FlowConflatedKt
 */
package miui.systemui.dynamicisland.window.domain.interactor;

import D0.a;
import G0.c;
import G0.e;
import G0.k;
import G0.s;
import K0.d;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Region;
import android.os.SystemProperties;
import android.util.Log;
import android.view.ViewTreeObserver;
import f1.E;
import f1.f;
import h1.h;
import h1.o;
import h1.q;
import i1.I;
import i1.g;
import i1.y;
import miui.systemui.dynamicisland.DynamicIslandStartable;
import miui.systemui.dynamicisland.DynamicIslandUtils;
import miui.systemui.dynamicisland.dagger.DynamicIslandScope;
import miui.systemui.dynamicisland.dagger.qualifiers.DynamicIsland;
import miui.systemui.dynamicisland.event.DynamicIslandEventCoordinator;
import miui.systemui.dynamicisland.window.DynamicIslandWindowView;
import miui.systemui.dynamicisland.window.DynamicIslandWindowViewController;
import miui.systemui.dynamicisland.window.domain.interactor.DynamicIslandTouchRegionInteractor;
import miui.systemui.util.ConvenienceExtensionsKt;
import miui.systemui.util.coroutines.flow.FlowConflatedKt;

@DynamicIslandScope
public final class DynamicIslandTouchRegionInteractor
implements DynamicIslandStartable {
    public static final Companion Companion = new Object(null){
        {
            this();
        }
    };
    private static final boolean DEBUG = SystemProperties.getBoolean((String)"debug.sysui.notif.island.touch_region", (boolean)false);
    private static final String TAG = "DynamicIslandTouchRegionInteractor";
    private final i1.f computeInternalInsetsEvent;
    private final Context context;
    private final G0.d eventCoordinator$delegate;
    private final G0.d paint$delegate;
    private final E scope;
    private final G0.d touchRegion$delegate;
    private final DynamicIslandWindowView windowView;
    private final G0.d windowViewController$delegate;
    private final G0.d windowViewTouchRegion$delegate;

    public DynamicIslandTouchRegionInteractor(@DynamicIsland E e2, Context context, DynamicIslandWindowView dynamicIslandWindowView, a a2, a a3) {
        kotlin.jvm.internal.o.g((Object)e2, (String)"scope");
        kotlin.jvm.internal.o.g((Object)context, (String)"context");
        kotlin.jvm.internal.o.g((Object)((Object)dynamicIslandWindowView), (String)"windowView");
        kotlin.jvm.internal.o.g((Object)a2, (String)"windowViewControllerLazy");
        kotlin.jvm.internal.o.g((Object)a3, (String)"eventCoordinatorLazy");
        this.scope = e2;
        this.context = context;
        this.windowView = dynamicIslandWindowView;
        this.windowViewController$delegate = ConvenienceExtensionsKt.getKotlinLazy((a)a2);
        this.eventCoordinator$delegate = ConvenienceExtensionsKt.getKotlinLazy((a)a3);
        this.paint$delegate = e.b((U0.a)paint.2.INSTANCE);
        this.touchRegion$delegate = e.b((U0.a)new U0.a(this){
            final DynamicIslandTouchRegionInteractor this$0;
            {
                this.this$0 = dynamicIslandTouchRegionInteractor;
                super(0);
            }

            public final I invoke() {
                return DynamicIslandTouchRegionInteractor.access$getEventCoordinator(this.this$0).getTouchRegion();
            }
        });
        this.windowViewTouchRegion$delegate = e.b((U0.a)new U0.a(this){
            final DynamicIslandTouchRegionInteractor this$0;
            {
                this.this$0 = dynamicIslandTouchRegionInteractor;
                super(0);
            }

            public final I invoke() {
                I i2 = DynamicIslandTouchRegionInteractor.access$getWindowViewController(this.this$0).isFreeformAnimRunning();
                I i3 = DynamicIslandTouchRegionInteractor.access$getWindowViewController(this.this$0).getFreeformAnimRegion();
                I i4 = this.this$0.getTouchRegion();
                i4 = i1.h.j((i1.f)i2, (i1.f)i3, (i1.f)i4, (U0.q)new U0.q(this.this$0, null){
                    Object L$0;
                    Object L$1;
                    boolean Z$0;
                    int label;
                    final DynamicIslandTouchRegionInteractor this$0;
                    {
                        this.this$0 = dynamicIslandTouchRegionInteractor;
                        super(4, d2);
                    }

                    public final Object invoke(boolean bl, Region region, Region region2, d object) {
                        object = new /* invalid duplicate definition of identical inner class */;
                        object.Z$0 = bl;
                        object.L$0 = region;
                        object.L$1 = region2;
                        return object.invokeSuspend(s.a);
                    }

                    public final Object invokeSuspend(Object object) {
                        L0.c.c();
                        if (this.label == 0) {
                            k.b((Object)object);
                            boolean bl = this.Z$0;
                            Region region = (Region)this.L$0;
                            Region region2 = (Region)this.L$1;
                            object = region2;
                            if (bl) {
                                object = region.isEmpty() ? DynamicIslandTouchRegionInteractor.access$getFullscreenRegion(this.this$0) : DynamicIslandTouchRegionInteractor.access$mergeTouchRegions(this.this$0, region, region2);
                            }
                            return object;
                        }
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                });
                return i1.h.B((i1.f)i4, (E)DynamicIslandTouchRegionInteractor.access$getScope$p(this.this$0), (i1.E)i1.E.a.c(), (Object)new Region());
            }
        });
        this.computeInternalInsetsEvent = FlowConflatedKt.conflatedCallbackFlow((U0.o)new U0.o(this, null){
            private Object L$0;
            int label;
            final DynamicIslandTouchRegionInteractor this$0;
            {
                this.this$0 = dynamicIslandTouchRegionInteractor;
                super(2, d2);
            }

            public final d create(Object object, d object2) {
                object2 = new /* invalid duplicate definition of identical inner class */;
                object2.L$0 = object;
                return object2;
            }

            public final Object invoke(q q2, d d2) {
                return (this.create(q2, d2)).invokeSuspend(s.a);
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
                    object = (q)this.L$0;
                    ViewTreeObserver.OnComputeInternalInsetsListener onComputeInternalInsetsListener2 = new ViewTreeObserver.OnComputeInternalInsetsListener((q)object){
                        final q $$this$conflatedCallbackFlow;
                        {
                            this.$$this$conflatedCallbackFlow = q2;
                        }

                        public void onComputeInternalInsets(ViewTreeObserver.InternalInsetsInfo internalInsetsInfo) {
                            if (internalInsetsInfo != null) {
                                h.b((Object)this.$$this$conflatedCallbackFlow.i((Object)internalInsetsInfo));
                            }
                        }
                    };
                    ViewTreeObserver viewTreeObserver = DynamicIslandTouchRegionInteractor.access$getWindowView$p(this.this$0).getViewTreeObserver();
                    viewTreeObserver.addOnComputeInternalInsetsListener(onComputeInternalInsetsListener2);
                    U0.a a2 = new U0.a(viewTreeObserver, onComputeInternalInsetsListener2){
                        final computeInternalInsetsEvent.onComputeInternalInsetsListener.1 $onComputeInternalInsetsListener;
                        final ViewTreeObserver $viewTreeObserver;
                        {
                            this.$viewTreeObserver = viewTreeObserver;
                            this.$onComputeInternalInsetsListener = var2_2;
                            super(0);
                        }

                        public final void invoke() {
                            if (this.$viewTreeObserver.isAlive()) {
                                ViewTreeObserver viewTreeObserver = this.$viewTreeObserver;
                                computeInternalInsetsEvent.onComputeInternalInsetsListener.1 var1_2 = this.$onComputeInternalInsetsListener;
                                viewTreeObserver.removeOnComputeInternalInsetsListener((ViewTreeObserver.OnComputeInternalInsetsListener)var1_2);
                            }
                        }
                    };
                    this.label = 1;
                    if (o.a((q)object, (U0.a)a2, (d)this) != object2) return s.a;
                    return object2;
                }
            }
        });
    }

    public static final /* synthetic */ i1.f access$getComputeInternalInsetsEvent$p(DynamicIslandTouchRegionInteractor dynamicIslandTouchRegionInteractor) {
        return dynamicIslandTouchRegionInteractor.computeInternalInsetsEvent;
    }

    public static final /* synthetic */ boolean access$getDEBUG$cp() {
        return DEBUG;
    }

    public static final /* synthetic */ DynamicIslandEventCoordinator access$getEventCoordinator(DynamicIslandTouchRegionInteractor dynamicIslandTouchRegionInteractor) {
        return dynamicIslandTouchRegionInteractor.getEventCoordinator();
    }

    public static final /* synthetic */ Region access$getFullscreenRegion(DynamicIslandTouchRegionInteractor dynamicIslandTouchRegionInteractor) {
        return dynamicIslandTouchRegionInteractor.getFullscreenRegion();
    }

    public static final /* synthetic */ Paint access$getPaint(DynamicIslandTouchRegionInteractor dynamicIslandTouchRegionInteractor) {
        return dynamicIslandTouchRegionInteractor.getPaint();
    }

    public static final /* synthetic */ E access$getScope$p(DynamicIslandTouchRegionInteractor dynamicIslandTouchRegionInteractor) {
        return dynamicIslandTouchRegionInteractor.scope;
    }

    public static final /* synthetic */ DynamicIslandWindowView access$getWindowView$p(DynamicIslandTouchRegionInteractor dynamicIslandTouchRegionInteractor) {
        return dynamicIslandTouchRegionInteractor.windowView;
    }

    public static final /* synthetic */ DynamicIslandWindowViewController access$getWindowViewController(DynamicIslandTouchRegionInteractor dynamicIslandTouchRegionInteractor) {
        return dynamicIslandTouchRegionInteractor.getWindowViewController();
    }

    public static final /* synthetic */ Region access$mergeTouchRegions(DynamicIslandTouchRegionInteractor dynamicIslandTouchRegionInteractor, Region ... regionArray) {
        return dynamicIslandTouchRegionInteractor.mergeTouchRegions(regionArray);
    }

    private final void drawDebugTouchRegion() {
        if (DEBUG) {
            f.b((E)this.scope, null, null, (U0.o)new U0.o(this, null){
                int label;
                final DynamicIslandTouchRegionInteractor this$0;
                {
                    this.this$0 = dynamicIslandTouchRegionInteractor;
                    super(2, d2);
                }

                public final d create(Object object, d d2) {
                    return new /* invalid duplicate definition of identical inner class */;
                }

                public final Object invoke(E e2, d d2) {
                    return (this.create(e2, d2)).invokeSuspend(s.a);
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
                        y y2 = DynamicIslandTouchRegionInteractor.access$getWindowView$p(this.this$0).getDispatchDrawEvent();
                        g2 = new g(this.this$0){
                            final DynamicIslandTouchRegionInteractor this$0;
                            {
                                this.this$0 = dynamicIslandTouchRegionInteractor;
                            }

                            public final Object emit(Canvas canvas, d d2) {
                                canvas.drawRect(((Region)this.this$0.getWindowViewTouchRegion().getValue()).getBounds(), DynamicIslandTouchRegionInteractor.access$getPaint(this.this$0));
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
        }
    }

    private final DynamicIslandEventCoordinator getEventCoordinator() {
        return (DynamicIslandEventCoordinator)this.eventCoordinator$delegate.getValue();
    }

    private final Region getFullscreenRegion() {
        int n;
        Object object = DynamicIslandUtils.INSTANCE;
        int n2 = ((DynamicIslandUtils)object).getScreenWidth(this.context);
        int n3 = ((DynamicIslandUtils)object).getScreenHeight(this.context);
        int n4 = n = ((DynamicIslandUtils)object).getNavigationBarFrameHeight();
        if (n == 0) {
            n4 = ((DynamicIslandUtils)object).dpToPx(48, this.context);
        }
        object = new StringBuilder();
        ((StringBuilder)object).append("getFullScreenRegion: ");
        ((StringBuilder)object).append(n2);
        ((StringBuilder)object).append(", ");
        ((StringBuilder)object).append(n3);
        ((StringBuilder)object).append(", ");
        ((StringBuilder)object).append(n4);
        Log.d((String)TAG, (String)((StringBuilder)object).toString());
        return new Region(82, 0, n2 - 82, n3 - n4);
    }

    private final Paint getPaint() {
        return (Paint)this.paint$delegate.getValue();
    }

    private final DynamicIslandWindowViewController getWindowViewController() {
        return (DynamicIslandWindowViewController)this.windowViewController$delegate.getValue();
    }

    private final void listenForTouchRegionChanged() {
        f.b((E)this.scope, null, null, (U0.o)new U0.o(this, null){
            int label;
            final DynamicIslandTouchRegionInteractor this$0;
            {
                this.this$0 = dynamicIslandTouchRegionInteractor;
                super(2, d2);
            }

            public final d create(Object object, d d2) {
                return new /* invalid duplicate definition of identical inner class */;
            }

            public final Object invoke(E e2, d d2) {
                return (this.create(e2, d2)).invokeSuspend(s.a);
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
                    object = this.this$0.getWindowViewTouchRegion();
                    g g2 = new g(this.this$0){
                        final DynamicIslandTouchRegionInteractor this$0;
                        {
                            this.this$0 = dynamicIslandTouchRegionInteractor;
                        }

                        public final Object emit(Region region, d object) {
                            if (DynamicIslandTouchRegionInteractor.access$getDEBUG$cp()) {
                                object = new StringBuilder();
                                ((StringBuilder)object).append("requestApplyInsets ");
                                ((StringBuilder)object).append(region);
                                Log.d((String)"DynamicIslandTouchRegionInteractor", (String)((StringBuilder)object).toString());
                            }
                            DynamicIslandTouchRegionInteractor.access$getWindowView$p(this.this$0).requestApplyInsets();
                            if (DynamicIslandTouchRegionInteractor.access$getDEBUG$cp()) {
                                DynamicIslandTouchRegionInteractor.access$getWindowView$p(this.this$0).invalidate();
                            }
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
    }

    private final Region mergeTouchRegions(Region ... regionArray) {
        Region region = new Region();
        int n = regionArray.length;
        for (int j = 0; j < n; ++j) {
            region.op(regionArray[j], Region.Op.UNION);
        }
        return region;
    }

    private final void updateInternalInsets() {
        f.b((E)this.scope, null, null, (U0.o)new U0.o(this, null){
            int label;
            final DynamicIslandTouchRegionInteractor this$0;
            {
                this.this$0 = dynamicIslandTouchRegionInteractor;
                super(2, d2);
            }

            public final d create(Object object, d d2) {
                return new /* invalid duplicate definition of identical inner class */;
            }

            public final Object invoke(E e2, d d2) {
                return (this.create(e2, d2)).invokeSuspend(s.a);
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
                    object = DynamicIslandTouchRegionInteractor.access$getComputeInternalInsetsEvent$p(this.this$0);
                    g g2 = new g(this.this$0){
                        final DynamicIslandTouchRegionInteractor this$0;
                        {
                            this.this$0 = dynamicIslandTouchRegionInteractor;
                        }

                        public final Object emit(ViewTreeObserver.InternalInsetsInfo internalInsetsInfo, d d2) {
                            if (DynamicIslandTouchRegionInteractor.access$getDEBUG$cp()) {
                                Log.d((String)"DynamicIslandTouchRegionInteractor", (String)"updateInternalInsets");
                            }
                            internalInsetsInfo.setTouchableInsets(3);
                            internalInsetsInfo.touchableRegion.set((Region)this.this$0.getWindowViewTouchRegion().getValue());
                            return s.a;
                        }
                    };
                    this.label = 1;
                    if (object.collect(g2, (d)this) != object2) return s.a;
                    return object2;
                }
            }
        }, (int)3, null);
    }

    public final I getTouchRegion() {
        return (I)this.touchRegion$delegate.getValue();
    }

    public final I getWindowViewTouchRegion() {
        return (I)this.windowViewTouchRegion$delegate.getValue();
    }

    @Override
    public void start() {
        this.listenForTouchRegionChanged();
        this.updateInternalInsets();
        this.drawDebugTouchRegion();
    }
}
