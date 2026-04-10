/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  G0.c
 *  G0.d
 *  G0.e
 *  G0.k
 *  G0.s
 *  K0.d
 *  L0.c
 *  M0.b
 *  M0.d
 *  U0.a
 *  U0.o
 *  android.content.Context
 *  android.graphics.Rect
 *  android.view.MotionEvent
 *  f1.E
 *  f1.f
 *  i1.A
 *  i1.I
 *  i1.K
 *  i1.f
 *  i1.g
 *  i1.h
 *  i1.t
 *  i1.u
 *  i1.y
 *  kotlin.jvm.internal.o
 *  kotlin.jvm.internal.x
 *  miui.systemui.statusbar.data.repository.StatusBarAreaRepository
 */
package miui.systemui.dynamicisland.window.domain.interactor;

import G0.c;
import G0.e;
import G0.k;
import G0.s;
import K0.d;
import M0.b;
import U0.a;
import android.content.Context;
import android.graphics.Rect;
import android.view.MotionEvent;
import f1.E;
import f1.f;
import i1.A;
import i1.I;
import i1.K;
import i1.g;
import i1.h;
import i1.t;
import i1.u;
import i1.y;
import kotlin.jvm.internal.o;
import kotlin.jvm.internal.x;
import miui.systemui.dynamicisland.DynamicIslandStartable;
import miui.systemui.dynamicisland.dagger.DynamicIslandScope;
import miui.systemui.dynamicisland.dagger.qualifiers.DynamicIsland;
import miui.systemui.dynamicisland.touch.TouchEvent;
import miui.systemui.dynamicisland.window.DynamicIslandWindowView;
import miui.systemui.dynamicisland.window.domain.interactor.DynamicIslandWindowViewTouchInteractor;
import miui.systemui.dynamicisland.window.domain.interactor.DynamicIslandWindowViewTouchInteractor$special$;
import miui.systemui.dynamicisland.window.domain.interactor.DynamicIslandWindowViewTouchInteractor$start$1$invokeSuspend$;
import miui.systemui.dynamicisland.window.domain.interactor.DynamicIslandWindowViewTouchInteractor$start$2$invokeSuspend$;
import miui.systemui.dynamicisland.window.domain.interactor.DynamicIslandWindowViewTouchInteractor$start$3$invokeSuspend$;
import miui.systemui.statusbar.data.repository.StatusBarAreaRepository;

@DynamicIslandScope
public final class DynamicIslandWindowViewTouchInteractor
implements DynamicIslandStartable {
    public static final Companion Companion = new Object(null){
        {
            this();
        }
    };
    private static final String TAG = "DynamicIslandWindowViewTouchHandler";
    private final t _dispatchInterceptTouchEvent;
    private final t _dispatchTouchEvent;
    private final t _islandInterceptTouchEvent;
    private final t _islandTouchEvent;
    private final t _trackTouchEvent;
    private final Context context;
    private final y dispatchInterceptTouchEvent;
    private final y dispatchTouchEvent;
    private final G0.d isTracking$delegate;
    private final y islandInterceptTouchEvent;
    private final y islandTouchEvent;
    private final i1.f outsideInterceptTouchEvent;
    private final i1.f outsideTouchEvent;
    private final E scope;
    private final StatusBarAreaRepository statusBarAreaRepository;
    private final y trackTouchEvent;
    private final DynamicIslandWindowView windowView;

    public DynamicIslandWindowViewTouchInteractor(@DynamicIsland E e2, Context context, DynamicIslandWindowView dynamicIslandWindowView, StatusBarAreaRepository statusBarAreaRepository) {
        t t2;
        t t3;
        o.g((Object)e2, (String)"scope");
        o.g((Object)context, (String)"context");
        o.g((Object)((Object)dynamicIslandWindowView), (String)"windowView");
        o.g((Object)statusBarAreaRepository, (String)"statusBarAreaRepository");
        this.scope = e2;
        this.context = context;
        this.windowView = dynamicIslandWindowView;
        this.statusBarAreaRepository = statusBarAreaRepository;
        statusBarAreaRepository = A.b((int)0, (int)0, null, (int)7, null);
        this._trackTouchEvent = statusBarAreaRepository;
        e2 = A.b((int)0, (int)0, null, (int)7, null);
        this._islandInterceptTouchEvent = e2;
        context = A.b((int)0, (int)0, null, (int)7, null);
        this._islandTouchEvent = context;
        this._dispatchInterceptTouchEvent = t3 = A.b((int)0, (int)0, null, (int)7, null);
        this._dispatchTouchEvent = t2 = A.b((int)0, (int)0, null, (int)7, null);
        this.outsideInterceptTouchEvent = new i1.f((i1.f)dynamicIslandWindowView.getOnInterceptTouchEvent()){
            final i1.f $this_unsafeTransform$inlined;
            {
                this.$this_unsafeTransform$inlined = f2;
            }

            public Object collect(g object, d d2) {
                if ((object = this.$this_unsafeTransform$inlined.collect(new g((g)object){
                    final g $this_unsafeFlow;
                    {
                        this.$this_unsafeFlow = g2;
                    }

                    /*
                     * Unable to fully structure code
                     * Could not resolve type clashes
                     */
                    public final Object emit(Object var1_1, d var2_2) {
                        if (!(var2_2 /* !! */  instanceof special$$inlined$filter$1$2$1)) ** GOTO lbl-1000
                        var4_3 /* !! */  = var2_2 /* !! */ ;
                        var3_4 = var4_3 /* !! */ .label;
                        if ((var3_4 & -2147483648) != 0) {
                            var4_3 /* !! */ .label = var3_4 + -2147483648;
                            var2_2 /* !! */  = var4_3 /* !! */ ;
                        } else lbl-1000:
                        // 2 sources

                        {
                            var2_2 /* !! */  = new M0.d(this, var2_2 /* !! */ ){
                                Object L$0;
                                Object L$1;
                                int label;
                                Object result;
                                final special$$inlined$filter$1$2 this$0;
                                {
                                    this.this$0 = var1_1;
                                    super(d2);
                                }

                                public final Object invokeSuspend(Object object) {
                                    this.result = object;
                                    this.label |= Integer.MIN_VALUE;
                                    return this.this$0.emit(null, (d)this);
                                }
                            };
                        }
                        var5_5 = var2_2 /* !! */ .result;
                        var4_3 /* !! */  = L0.c.c();
                        var3_4 = var2_2 /* !! */ .label;
                        if (var3_4 == 0) ** GOTO lbl17
                        if (var3_4 == 1) {
                            k.b((Object)var5_5);
                        } else {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
lbl17:
                            // 1 sources

                            k.b((Object)var5_5);
                            var5_5 = this.$this_unsafeFlow;
                            if (((TouchEvent)var1_1).getEvent().getActionMasked() == 4) {
                                var2_2 /* !! */ .label = 1;
                                if (var5_5.emit(var1_1, var2_2 /* !! */ ) == var4_3 /* !! */ ) {
                                    return var4_3 /* !! */ ;
                                }
                            }
                        }
                        return s.a;
                    }
                }, d2)) == L0.c.c()) {
                    return object;
                }
                return s.a;
            }
        };
        this.outsideTouchEvent = new i1.f((i1.f)dynamicIslandWindowView.getOnTouchEvent()){
            final i1.f $this_unsafeTransform$inlined;
            {
                this.$this_unsafeTransform$inlined = f2;
            }

            public Object collect(g object, d d2) {
                if ((object = this.$this_unsafeTransform$inlined.collect(new g((g)object){
                    final g $this_unsafeFlow;
                    {
                        this.$this_unsafeFlow = g2;
                    }

                    /*
                     * Unable to fully structure code
                     * Could not resolve type clashes
                     */
                    public final Object emit(Object var1_1, d var2_2) {
                        if (!(var2_2 /* !! */  instanceof special$$inlined$filter$2$2$1)) ** GOTO lbl-1000
                        var4_3 /* !! */  = var2_2 /* !! */ ;
                        var3_4 = var4_3 /* !! */ .label;
                        if ((var3_4 & -2147483648) != 0) {
                            var4_3 /* !! */ .label = var3_4 + -2147483648;
                            var2_2 /* !! */  = var4_3 /* !! */ ;
                        } else lbl-1000:
                        // 2 sources

                        {
                            var2_2 /* !! */  = new M0.d(this, var2_2 /* !! */ ){
                                Object L$0;
                                Object L$1;
                                int label;
                                Object result;
                                final special$$inlined$filter$2$2 this$0;
                                {
                                    this.this$0 = var1_1;
                                    super(d2);
                                }

                                public final Object invokeSuspend(Object object) {
                                    this.result = object;
                                    this.label |= Integer.MIN_VALUE;
                                    return this.this$0.emit(null, (d)this);
                                }
                            };
                        }
                        var5_5 = var2_2 /* !! */ .result;
                        var4_3 /* !! */  = L0.c.c();
                        var3_4 = var2_2 /* !! */ .label;
                        if (var3_4 == 0) ** GOTO lbl17
                        if (var3_4 == 1) {
                            k.b((Object)var5_5);
                        } else {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
lbl17:
                            // 1 sources

                            k.b((Object)var5_5);
                            var5_5 = this.$this_unsafeFlow;
                            if (((TouchEvent)var1_1).getEvent().getActionMasked() == 4) {
                                var2_2 /* !! */ .label = 1;
                                if (var5_5.emit(var1_1, var2_2 /* !! */ ) == var4_3 /* !! */ ) {
                                    return var4_3 /* !! */ ;
                                }
                            }
                        }
                        return s.a;
                    }
                }, d2)) == L0.c.c()) {
                    return object;
                }
                return s.a;
            }
        };
        this.trackTouchEvent = h.a((t)statusBarAreaRepository);
        this.islandInterceptTouchEvent = h.a((t)e2);
        this.islandTouchEvent = h.a((t)context);
        this.dispatchInterceptTouchEvent = h.a((t)t3);
        this.dispatchTouchEvent = h.a((t)t2);
        this.isTracking$delegate = e.b((a)new a(this){
            final DynamicIslandWindowViewTouchInteractor this$0;
            {
                this.this$0 = dynamicIslandWindowViewTouchInteractor;
                super(0);
            }

            public static final /* synthetic */ boolean access$invoke$lambda$1$isUpOrCancel(MotionEvent motionEvent) {
                return isTracking.2.invoke$lambda$1$isUpOrCancel(motionEvent);
            }

            private static final boolean invoke$lambda$1$isUpOrCancel(MotionEvent motionEvent) {
                boolean bl;
                int n = motionEvent.getActionMasked();
                boolean bl2 = bl = true;
                if (n != 1) {
                    bl2 = n == 3 ? bl : false;
                }
                return bl2;
            }

            public final I invoke() {
                DynamicIslandWindowViewTouchInteractor dynamicIslandWindowViewTouchInteractor = this.this$0;
                u u2 = K.a((Object)Boolean.FALSE);
                f.b((E)DynamicIslandWindowViewTouchInteractor.access$getScope$p(dynamicIslandWindowViewTouchInteractor), null, null, (U0.o)new U0.o(dynamicIslandWindowViewTouchInteractor, u2, null){
                    final u $isTracking;
                    int label;
                    final DynamicIslandWindowViewTouchInteractor this$0;
                    {
                        this.this$0 = dynamicIslandWindowViewTouchInteractor;
                        this.$isTracking = u2;
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
                            object = this.this$0.getTrackTouchEvent();
                            g g2 = new g(this.$isTracking){
                                final u $isTracking;
                                {
                                    this.$isTracking = u2;
                                }

                                public final Object emit(MotionEvent motionEvent, d d2) {
                                    this.$isTracking.setValue((Object)b.a((boolean)(isTracking.2.access$invoke$lambda$1$isUpOrCancel(motionEvent) ^ true)));
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
                return h.b((u)u2);
            }
        });
    }

    public static final /* synthetic */ E access$getScope$p(DynamicIslandWindowViewTouchInteractor dynamicIslandWindowViewTouchInteractor) {
        return dynamicIslandWindowViewTouchInteractor.scope;
    }

    public static final /* synthetic */ StatusBarAreaRepository access$getStatusBarAreaRepository$p(DynamicIslandWindowViewTouchInteractor dynamicIslandWindowViewTouchInteractor) {
        return dynamicIslandWindowViewTouchInteractor.statusBarAreaRepository;
    }

    public static final /* synthetic */ DynamicIslandWindowView access$getWindowView$p(DynamicIslandWindowViewTouchInteractor dynamicIslandWindowViewTouchInteractor) {
        return dynamicIslandWindowViewTouchInteractor.windowView;
    }

    public static final /* synthetic */ t access$get_dispatchInterceptTouchEvent$p(DynamicIslandWindowViewTouchInteractor dynamicIslandWindowViewTouchInteractor) {
        return dynamicIslandWindowViewTouchInteractor._dispatchInterceptTouchEvent;
    }

    public static final /* synthetic */ t access$get_dispatchTouchEvent$p(DynamicIslandWindowViewTouchInteractor dynamicIslandWindowViewTouchInteractor) {
        return dynamicIslandWindowViewTouchInteractor._dispatchTouchEvent;
    }

    public static final /* synthetic */ t access$get_islandInterceptTouchEvent$p(DynamicIslandWindowViewTouchInteractor dynamicIslandWindowViewTouchInteractor) {
        return dynamicIslandWindowViewTouchInteractor._islandInterceptTouchEvent;
    }

    public static final /* synthetic */ t access$get_islandTouchEvent$p(DynamicIslandWindowViewTouchInteractor dynamicIslandWindowViewTouchInteractor) {
        return dynamicIslandWindowViewTouchInteractor._islandTouchEvent;
    }

    public static final /* synthetic */ t access$get_trackTouchEvent$p(DynamicIslandWindowViewTouchInteractor dynamicIslandWindowViewTouchInteractor) {
        return dynamicIslandWindowViewTouchInteractor._trackTouchEvent;
    }

    public final y getDispatchInterceptTouchEvent() {
        return this.dispatchInterceptTouchEvent;
    }

    public final y getDispatchTouchEvent() {
        return this.dispatchTouchEvent;
    }

    public final y getIslandInterceptTouchEvent() {
        return this.islandInterceptTouchEvent;
    }

    public final y getIslandTouchEvent() {
        return this.islandTouchEvent;
    }

    public final i1.f getOutsideInterceptTouchEvent() {
        return this.outsideInterceptTouchEvent;
    }

    public final i1.f getOutsideTouchEvent() {
        return this.outsideTouchEvent;
    }

    public final y getTrackTouchEvent() {
        return this.trackTouchEvent;
    }

    public final I isTracking() {
        return (I)this.isTracking$delegate.getValue();
    }

    @Override
    public void start() {
        x x2 = new x();
        f.b((E)this.scope, null, null, (U0.o)new U0.o(this, null){
            int label;
            final DynamicIslandWindowViewTouchInteractor this$0;
            {
                this.this$0 = dynamicIslandWindowViewTouchInteractor;
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
            public final Object invokeSuspend(Object g2) {
                Object object = L0.c.c();
                int n = this.label;
                if (n != 0) {
                    if (n != 1) throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    k.b((Object)g2);
                    return s.a;
                } else {
                    k.b((Object)g2);
                    i1.f f2 = new i1.f((i1.f)DynamicIslandWindowViewTouchInteractor.access$getWindowView$p(this.this$0).getDispatchTouchEvent()){
                        final i1.f $this_unsafeTransform$inlined;
                        {
                            this.$this_unsafeTransform$inlined = f2;
                        }

                        public Object collect(g object, d d2) {
                            if ((object = this.$this_unsafeTransform$inlined.collect(new g((g)object){
                                final g $this_unsafeFlow;
                                {
                                    this.$this_unsafeFlow = g2;
                                }

                                /*
                                 * Unable to fully structure code
                                 * Could not resolve type clashes
                                 */
                                public final Object emit(Object var1_1, d var2_2) {
                                    if (!(var2_2 /* !! */  instanceof start$1$invokeSuspend$$inlined$filter$1$2$1)) ** GOTO lbl-1000
                                    var4_3 /* !! */  = var2_2 /* !! */ ;
                                    var3_4 = var4_3 /* !! */ .label;
                                    if ((var3_4 & -2147483648) != 0) {
                                        var4_3 /* !! */ .label = var3_4 + -2147483648;
                                        var2_2 /* !! */  = var4_3 /* !! */ ;
                                    } else lbl-1000:
                                    // 2 sources

                                    {
                                        var2_2 /* !! */  = new M0.d(this, var2_2 /* !! */ ){
                                            Object L$0;
                                            Object L$1;
                                            int label;
                                            Object result;
                                            final start$1$invokeSuspend$$inlined$filter$1$2 this$0;
                                            {
                                                this.this$0 = var1_1;
                                                super(d2);
                                            }

                                            public final Object invokeSuspend(Object object) {
                                                this.result = object;
                                                this.label |= Integer.MIN_VALUE;
                                                return this.this$0.emit(null, (d)this);
                                            }
                                        };
                                    }
                                    var5_5 = var2_2 /* !! */ .result;
                                    var4_3 /* !! */  = L0.c.c();
                                    var3_4 = var2_2 /* !! */ .label;
                                    if (var3_4 == 0) ** GOTO lbl17
                                    if (var3_4 == 1) {
                                        k.b((Object)var5_5);
                                    } else {
                                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
lbl17:
                                        // 1 sources

                                        k.b((Object)var5_5);
                                        var5_5 = this.$this_unsafeFlow;
                                        if (((MotionEvent)var1_1).getActionMasked() != 4) {
                                            var2_2 /* !! */ .label = 1;
                                            if (var5_5.emit(var1_1, var2_2 /* !! */ ) == var4_3 /* !! */ ) {
                                                return var4_3 /* !! */ ;
                                            }
                                        }
                                    }
                                    return s.a;
                                }
                            }, d2)) == L0.c.c()) {
                                return object;
                            }
                            return s.a;
                        }
                    };
                    g2 = new g(this.this$0){
                        final DynamicIslandWindowViewTouchInteractor this$0;
                        {
                            this.this$0 = dynamicIslandWindowViewTouchInteractor;
                        }

                        public final Object emit(MotionEvent object, d d2) {
                            object = DynamicIslandWindowViewTouchInteractor.access$get_trackTouchEvent$p(this.this$0).emit(object, d2);
                            if (object == L0.c.c()) {
                                return object;
                            }
                            return s.a;
                        }
                    };
                    this.label = 1;
                    if (f2.collect(g2, (d)this) != object) return s.a;
                    return object;
                }
            }
        }, (int)3, null);
        f.b((E)this.scope, null, null, (U0.o)new U0.o(this, x2, null){
            final x $downInStatusBarArea;
            int label;
            final DynamicIslandWindowViewTouchInteractor this$0;
            {
                this.this$0 = dynamicIslandWindowViewTouchInteractor;
                this.$downInStatusBarArea = x2;
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
                    object = new i1.f((i1.f)DynamicIslandWindowViewTouchInteractor.access$getWindowView$p(this.this$0).getOnInterceptTouchEvent()){
                        final i1.f $this_unsafeTransform$inlined;
                        {
                            this.$this_unsafeTransform$inlined = f2;
                        }

                        public Object collect(g object, d d2) {
                            if ((object = this.$this_unsafeTransform$inlined.collect(new g((g)object){
                                final g $this_unsafeFlow;
                                {
                                    this.$this_unsafeFlow = g2;
                                }

                                /*
                                 * Unable to fully structure code
                                 * Could not resolve type clashes
                                 */
                                public final Object emit(Object var1_1, d var2_2) {
                                    if (!(var2_2 /* !! */  instanceof start$2$invokeSuspend$$inlined$filter$1$2$1)) ** GOTO lbl-1000
                                    var4_3 /* !! */  = var2_2 /* !! */ ;
                                    var3_4 = var4_3 /* !! */ .label;
                                    if ((var3_4 & -2147483648) != 0) {
                                        var4_3 /* !! */ .label = var3_4 + -2147483648;
                                        var2_2 /* !! */  = var4_3 /* !! */ ;
                                    } else lbl-1000:
                                    // 2 sources

                                    {
                                        var2_2 /* !! */  = new M0.d(this, var2_2 /* !! */ ){
                                            Object L$0;
                                            Object L$1;
                                            int label;
                                            Object result;
                                            final start$2$invokeSuspend$$inlined$filter$1$2 this$0;
                                            {
                                                this.this$0 = var1_1;
                                                super(d2);
                                            }

                                            public final Object invokeSuspend(Object object) {
                                                this.result = object;
                                                this.label |= Integer.MIN_VALUE;
                                                return this.this$0.emit(null, (d)this);
                                            }
                                        };
                                    }
                                    var5_5 = var2_2 /* !! */ .result;
                                    var4_3 /* !! */  = L0.c.c();
                                    var3_4 = var2_2 /* !! */ .label;
                                    if (var3_4 == 0) ** GOTO lbl17
                                    if (var3_4 == 1) {
                                        k.b((Object)var5_5);
                                    } else {
                                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
lbl17:
                                        // 1 sources

                                        k.b((Object)var5_5);
                                        var5_5 = this.$this_unsafeFlow;
                                        if (((TouchEvent)var1_1).getEvent().getActionMasked() != 4) {
                                            var2_2 /* !! */ .label = 1;
                                            if (var5_5.emit(var1_1, var2_2 /* !! */ ) == var4_3 /* !! */ ) {
                                                return var4_3 /* !! */ ;
                                            }
                                        }
                                    }
                                    return s.a;
                                }
                            }, d2)) == L0.c.c()) {
                                return object;
                            }
                            return s.a;
                        }
                    };
                    g g2 = new g(this.$downInStatusBarArea, this.this$0){
                        final x $downInStatusBarArea;
                        final DynamicIslandWindowViewTouchInteractor this$0;
                        {
                            this.$downInStatusBarArea = x2;
                            this.this$0 = dynamicIslandWindowViewTouchInteractor;
                        }

                        /*
                         * Unable to fully structure code
                         * Could not resolve type clashes
                         */
                        public final Object emit(TouchEvent var1_1, d var2_2) {
                            block12: {
                                block10: {
                                    block11: {
                                        block7: {
                                            block8: {
                                                block9: {
                                                    if (!(var2_2 /* !! */  instanceof start.emit.1)) ** GOTO lbl-1000
                                                    var5_3 = var2_2 /* !! */ ;
                                                    var3_4 = var5_3.label;
                                                    if ((var3_4 & -2147483648) != 0) {
                                                        var5_3.label = var3_4 + -2147483648;
                                                        var2_2 /* !! */  = var5_3;
                                                    } else lbl-1000:
                                                    // 2 sources

                                                    {
                                                        var2_2 /* !! */  = new M0.d(this, var2_2 /* !! */ ){
                                                            Object L$0;
                                                            Object L$1;
                                                            int label;
                                                            Object result;
                                                            final start.2<T> this$0;
                                                            {
                                                                this.this$0 = var1_1;
                                                                super(d2);
                                                            }

                                                            public final Object invokeSuspend(Object object) {
                                                                this.result = object;
                                                                this.label |= Integer.MIN_VALUE;
                                                                return this.this$0.emit(null, (d)this);
                                                            }
                                                        };
                                                    }
                                                    var8_5 = var2_2 /* !! */ .result;
                                                    var7_6 = L0.c.c();
                                                    var3_4 = var2_2 /* !! */ .label;
                                                    if (var3_4 == 0) break block7;
                                                    if (var3_4 == 1) break block8;
                                                    if (var3_4 != 2) break block9;
                                                    k.b((Object)var8_5);
                                                    break block10;
                                                }
                                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                            }
                                            var5_3 = (TouchEvent)var2_2 /* !! */ .L$1;
                                            var6_7 = var2_2 /* !! */ .L$0;
                                            k.b((Object)var8_5);
                                            break block11;
                                        }
                                        k.b((Object)var8_5);
                                        if (var1_1.getEvent().getActionMasked() == 0) {
                                            var5_3 = this.$downInStatusBarArea;
                                            var5_3.a = var4_8 = TouchEvent.Companion.inRect(var1_1.getEvent(), (Rect)DynamicIslandWindowViewTouchInteractor.access$getStatusBarAreaRepository$p(this.this$0).getStatusBarArea().getValue());
                                        }
                                        var8_5 = DynamicIslandWindowViewTouchInteractor.access$get_islandInterceptTouchEvent$p(this.this$0);
                                        var2_2 /* !! */ .L$0 = this;
                                        var2_2 /* !! */ .L$1 = var1_1;
                                        var2_2 /* !! */ .label = 1;
                                        var6_7 = this;
                                        var5_3 = var1_1;
                                        if (var8_5.emit((Object)var1_1, var2_2 /* !! */ ) == var7_6) {
                                            return var7_6;
                                        }
                                    }
                                    if (var5_3.getResult() != null) {
                                        return s.a;
                                    }
                                    if (var6_7.$downInStatusBarArea.a) {
                                        var5_3.setResult(null);
                                        var1_1 = DynamicIslandWindowViewTouchInteractor.access$get_dispatchInterceptTouchEvent$p(var6_7.this$0);
                                        var2_2 /* !! */ .L$0 = null;
                                        var2_2 /* !! */ .L$1 = null;
                                        var2_2 /* !! */ .label = 2;
                                        if (var1_1.emit(var5_3, var2_2 /* !! */ ) == var7_6) {
                                            return var7_6;
                                        } else {
                                            ** GOTO lbl49
                                        }
                                    }
                                    break block12;
                                }
                                return s.a;
                            }
                            return s.a;
                        }
                    };
                    this.label = 1;
                    if (object.collect(g2, (d)this) != object2) return s.a;
                    return object2;
                }
            }
        }, (int)3, null);
        f.b((E)this.scope, null, null, (U0.o)new U0.o(this, x2, null){
            final x $downInStatusBarArea;
            int label;
            final DynamicIslandWindowViewTouchInteractor this$0;
            {
                this.this$0 = dynamicIslandWindowViewTouchInteractor;
                this.$downInStatusBarArea = x2;
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
            public final Object invokeSuspend(Object g2) {
                Object object = L0.c.c();
                int n = this.label;
                if (n != 0) {
                    if (n != 1) throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    k.b((Object)g2);
                    return s.a;
                } else {
                    k.b((Object)g2);
                    i1.f f2 = new i1.f((i1.f)DynamicIslandWindowViewTouchInteractor.access$getWindowView$p(this.this$0).getOnTouchEvent()){
                        final i1.f $this_unsafeTransform$inlined;
                        {
                            this.$this_unsafeTransform$inlined = f2;
                        }

                        public Object collect(g object, d d2) {
                            if ((object = this.$this_unsafeTransform$inlined.collect(new g((g)object){
                                final g $this_unsafeFlow;
                                {
                                    this.$this_unsafeFlow = g2;
                                }

                                /*
                                 * Unable to fully structure code
                                 * Could not resolve type clashes
                                 */
                                public final Object emit(Object var1_1, d var2_2) {
                                    if (!(var2_2 /* !! */  instanceof start$3$invokeSuspend$$inlined$filter$1$2$1)) ** GOTO lbl-1000
                                    var4_3 /* !! */  = var2_2 /* !! */ ;
                                    var3_4 = var4_3 /* !! */ .label;
                                    if ((var3_4 & -2147483648) != 0) {
                                        var4_3 /* !! */ .label = var3_4 + -2147483648;
                                        var2_2 /* !! */  = var4_3 /* !! */ ;
                                    } else lbl-1000:
                                    // 2 sources

                                    {
                                        var2_2 /* !! */  = new M0.d(this, var2_2 /* !! */ ){
                                            Object L$0;
                                            Object L$1;
                                            int label;
                                            Object result;
                                            final start$3$invokeSuspend$$inlined$filter$1$2 this$0;
                                            {
                                                this.this$0 = var1_1;
                                                super(d2);
                                            }

                                            public final Object invokeSuspend(Object object) {
                                                this.result = object;
                                                this.label |= Integer.MIN_VALUE;
                                                return this.this$0.emit(null, (d)this);
                                            }
                                        };
                                    }
                                    var5_5 = var2_2 /* !! */ .result;
                                    var4_3 /* !! */  = L0.c.c();
                                    var3_4 = var2_2 /* !! */ .label;
                                    if (var3_4 == 0) ** GOTO lbl17
                                    if (var3_4 == 1) {
                                        k.b((Object)var5_5);
                                    } else {
                                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
lbl17:
                                        // 1 sources

                                        k.b((Object)var5_5);
                                        var5_5 = this.$this_unsafeFlow;
                                        if (((TouchEvent)var1_1).getEvent().getActionMasked() != 4) {
                                            var2_2 /* !! */ .label = 1;
                                            if (var5_5.emit(var1_1, var2_2 /* !! */ ) == var4_3 /* !! */ ) {
                                                return var4_3 /* !! */ ;
                                            }
                                        }
                                    }
                                    return s.a;
                                }
                            }, d2)) == L0.c.c()) {
                                return object;
                            }
                            return s.a;
                        }
                    };
                    g2 = new g(this.this$0, this.$downInStatusBarArea){
                        final x $downInStatusBarArea;
                        final DynamicIslandWindowViewTouchInteractor this$0;
                        {
                            this.this$0 = dynamicIslandWindowViewTouchInteractor;
                            this.$downInStatusBarArea = x2;
                        }

                        /*
                         * Unable to fully structure code
                         * Could not resolve type clashes
                         */
                        public final Object emit(TouchEvent var1_1, d var2_2) {
                            block11: {
                                block9: {
                                    block10: {
                                        block6: {
                                            block7: {
                                                block8: {
                                                    if (!(var2_2 /* !! */  instanceof start.emit.1)) ** GOTO lbl-1000
                                                    var4_3 = var2_2 /* !! */ ;
                                                    var3_4 = var4_3.label;
                                                    if ((var3_4 & -2147483648) != 0) {
                                                        var4_3.label = var3_4 + -2147483648;
                                                        var2_2 /* !! */  = var4_3;
                                                    } else lbl-1000:
                                                    // 2 sources

                                                    {
                                                        var2_2 /* !! */  = new M0.d(this, var2_2 /* !! */ ){
                                                            Object L$0;
                                                            Object L$1;
                                                            int label;
                                                            Object result;
                                                            final start.2<T> this$0;
                                                            {
                                                                this.this$0 = var1_1;
                                                                super(d2);
                                                            }

                                                            public final Object invokeSuspend(Object object) {
                                                                this.result = object;
                                                                this.label |= Integer.MIN_VALUE;
                                                                return this.this$0.emit(null, (d)this);
                                                            }
                                                        };
                                                    }
                                                    var7_5 = var2_2 /* !! */ .result;
                                                    var6_6 = L0.c.c();
                                                    var3_4 = var2_2 /* !! */ .label;
                                                    if (var3_4 == 0) break block6;
                                                    if (var3_4 == 1) break block7;
                                                    if (var3_4 != 2) break block8;
                                                    k.b((Object)var7_5);
                                                    break block9;
                                                }
                                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                            }
                                            var4_3 = (TouchEvent)var2_2 /* !! */ .L$1;
                                            var5_7 = var2_2 /* !! */ .L$0;
                                            k.b((Object)var7_5);
                                            break block10;
                                        }
                                        k.b((Object)var7_5);
                                        if (var1_1.getResult() != null) {
                                            return s.a;
                                        }
                                        var7_5 = DynamicIslandWindowViewTouchInteractor.access$get_islandTouchEvent$p(this.this$0);
                                        var2_2 /* !! */ .L$0 = this;
                                        var2_2 /* !! */ .L$1 = var1_1;
                                        var2_2 /* !! */ .label = 1;
                                        var5_7 = this;
                                        var4_3 = var1_1;
                                        if (var7_5.emit((Object)var1_1, var2_2 /* !! */ ) == var6_6) {
                                            return var6_6;
                                        }
                                    }
                                    if (var5_7.$downInStatusBarArea.a) {
                                        var4_3.setResult(null);
                                        var1_1 = DynamicIslandWindowViewTouchInteractor.access$get_dispatchTouchEvent$p(var5_7.this$0);
                                        var2_2 /* !! */ .L$0 = null;
                                        var2_2 /* !! */ .L$1 = null;
                                        var2_2 /* !! */ .label = 2;
                                        if (var1_1.emit(var4_3, var2_2 /* !! */ ) == var6_6) {
                                            return var6_6;
                                        } else {
                                            ** GOTO lbl46
                                        }
                                    }
                                    break block11;
                                }
                                return s.a;
                            }
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
}
