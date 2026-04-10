/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  G0.c
 *  G0.k
 *  G0.s
 *  K0.d
 *  L0.c
 *  M0.b
 *  M0.d
 *  U0.o
 *  U0.r
 *  U0.s
 *  android.content.Context
 *  android.graphics.Rect
 *  android.os.SystemProperties
 *  android.util.Log
 *  android.view.View
 *  f1.E
 *  f1.f
 *  i1.E
 *  i1.E$a
 *  i1.I
 *  i1.f
 *  i1.g
 *  i1.h
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.o
 *  miui.systemui.controlcenter.data.repository.ControlCenterExpandRepository
 *  miui.systemui.handles.RegionSamplingHelperRefactor
 *  miui.systemui.handles.RegionSamplingHelperRefactor$Factory
 *  miui.systemui.statusbar.data.repository.StatusBarAreaRepository
 *  miui.systemui.statusbar.data.repository.StatusBarStateRepository
 */
package miui.systemui.dynamicisland.domain.interactor;

import G0.c;
import G0.k;
import G0.s;
import K0.d;
import M0.b;
import U0.r;
import android.content.Context;
import android.graphics.Rect;
import android.os.SystemProperties;
import android.util.Log;
import android.view.View;
import f1.E;
import f1.f;
import i1.E;
import i1.I;
import i1.g;
import i1.h;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.o;
import miui.systemui.controlcenter.data.repository.ControlCenterExpandRepository;
import miui.systemui.dynamicisland.DynamicIslandStartable;
import miui.systemui.dynamicisland.dagger.DynamicIslandScope;
import miui.systemui.dynamicisland.dagger.qualifiers.DynamicIsland;
import miui.systemui.dynamicisland.data.repository.DynamicIslandExternalStateRepository;
import miui.systemui.dynamicisland.domain.interactor.DynamicIslandRegionSamplingInteractor;
import miui.systemui.dynamicisland.domain.interactor.DynamicIslandRegionSamplingInteractor$special$;
import miui.systemui.dynamicisland.window.DynamicIslandWindowView;
import miui.systemui.dynamicisland.window.domain.interactor.DynamicIslandWindowStateInteractor;
import miui.systemui.handles.RegionSamplingHelperRefactor;
import miui.systemui.statusbar.data.repository.StatusBarAreaRepository;
import miui.systemui.statusbar.data.repository.StatusBarStateRepository;

@DynamicIslandScope
public final class DynamicIslandRegionSamplingInteractor
implements DynamicIslandStartable {
    public static final Companion Companion = new Object(null){
        {
            this();
        }
    };
    private static final boolean DEBUG = SystemProperties.getBoolean((String)"debug.sysui.notif.island.region_sampling", (boolean)false);
    private static final String TAG = "DynamicIslandRegionSamplingInteractor";
    private static final float THRESHOLD = (float)SystemProperties.getInt((String)"debug.sysui.notif.island.region_sampling.threshold", (int)12) / 100.0f;
    private final Context context;
    private final ControlCenterExpandRepository controlCenterExpandRepository;
    private final DynamicIslandExternalStateRepository externalStateRepository;
    private final I isRegionDark;
    private final I medianLuma;
    private final I regionSampling;
    private final RegionSamplingHelperRefactor regionSamplingHelper;
    private final E scope;
    private final StatusBarAreaRepository statusBarAreaRepository;
    private final StatusBarStateRepository statusBarStateRepository;
    private final DynamicIslandWindowStateInteractor windowStateInteractor;

    public DynamicIslandRegionSamplingInteractor(@DynamicIsland E e, DynamicIslandWindowView object, Context context, DynamicIslandWindowStateInteractor dynamicIslandWindowStateInteractor, RegionSamplingHelperRefactor.Factory factory, StatusBarAreaRepository statusBarAreaRepository, StatusBarStateRepository statusBarStateRepository, ControlCenterExpandRepository controlCenterExpandRepository, DynamicIslandExternalStateRepository dynamicIslandExternalStateRepository) {
        o.g((Object)e, (String)"scope");
        o.g((Object)object, (String)"windowView");
        o.g((Object)context, (String)"context");
        o.g((Object)dynamicIslandWindowStateInteractor, (String)"windowStateInteractor");
        o.g((Object)factory, (String)"regionSamplingHelperFactory");
        o.g((Object)statusBarAreaRepository, (String)"statusBarAreaRepository");
        o.g((Object)statusBarStateRepository, (String)"statusBarStateRepository");
        o.g((Object)controlCenterExpandRepository, (String)"controlCenterExpandRepository");
        o.g((Object)dynamicIslandExternalStateRepository, (String)"externalStateRepository");
        this.scope = e;
        this.context = context;
        this.windowStateInteractor = dynamicIslandWindowStateInteractor;
        this.statusBarAreaRepository = statusBarAreaRepository;
        this.statusBarStateRepository = statusBarStateRepository;
        this.controlCenterExpandRepository = controlCenterExpandRepository;
        this.externalStateRepository = dynamicIslandExternalStateRepository;
        context = factory.create((View)object, new Function1(this){
            final DynamicIslandRegionSamplingInteractor this$0;
            {
                this.this$0 = dynamicIslandRegionSamplingInteractor;
                super(1);
            }

            public final Rect invoke(View view) {
                o.g((Object)view, (String)"$this$create");
                return (Rect)DynamicIslandRegionSamplingInteractor.access$getStatusBarAreaRepository$p(this.this$0).getStatusBarArea().getValue();
            }
        });
        this.regionSamplingHelper = context;
        factory = h.l((i1.f)dynamicIslandWindowStateInteractor.getVisible(), (i1.f)controlCenterExpandRepository.isVisible(), (i1.f)dynamicIslandExternalStateRepository.getNotificationVisible(), (i1.f)statusBarStateRepository.getState(), (i1.f)dynamicIslandWindowStateInteractor.isAppAnimRunning(), (U0.s)new U0.s(null){
            int I$0;
            boolean Z$0;
            boolean Z$1;
            boolean Z$2;
            boolean Z$3;
            int label;

            public final Object invoke(boolean bl, boolean bl2, boolean bl3, int n, boolean bl4, d object) {
                object = new /* invalid duplicate definition of identical inner class */;
                object.Z$0 = bl;
                object.Z$1 = bl2;
                object.Z$2 = bl3;
                object.I$0 = n;
                object.Z$3 = bl4;
                return object.invokeSuspend(s.a);
            }

            /*
             * Enabled aggressive block sorting
             */
            public final Object invokeSuspend(Object object) {
                L0.c.c();
                if (this.label != 0) throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                k.b((Object)object);
                boolean bl = this.Z$0;
                boolean bl2 = this.Z$1;
                boolean bl3 = this.Z$2;
                int n = this.I$0;
                boolean bl4 = this.Z$3;
                if (bl && !bl4 && !bl2) {
                    bl2 = bl = true;
                    if (!bl3) return b.a((boolean)bl2);
                    if (n == 1) {
                        bl2 = bl;
                        return b.a((boolean)bl2);
                    }
                }
                bl2 = false;
                return b.a((boolean)bl2);
            }
        });
        dynamicIslandWindowStateInteractor = i1.E.a;
        statusBarAreaRepository = dynamicIslandWindowStateInteractor.c();
        object = Boolean.FALSE;
        this.regionSampling = h.B((i1.f)factory, (E)e, (i1.E)statusBarAreaRepository, (Object)object);
        context = context.getMedianLuma();
        this.medianLuma = context;
        this.isRegionDark = h.B((i1.f)h.k((i1.f)new i1.f((i1.f)context){
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
                        if (!(var2_2 /* !! */  instanceof special$$inlined$map$1$2$1)) ** GOTO lbl-1000
                        var5_3 /* !! */  = var2_2 /* !! */ ;
                        var3_4 = var5_3 /* !! */ .label;
                        if ((var3_4 & -2147483648) != 0) {
                            var5_3 /* !! */ .label = var3_4 + -2147483648;
                            var2_2 /* !! */  = var5_3 /* !! */ ;
                        } else lbl-1000:
                        // 2 sources

                        {
                            var2_2 /* !! */  = new M0.d(this, var2_2 /* !! */ ){
                                Object L$0;
                                int label;
                                Object result;
                                final special$$inlined$map$1$2 this$0;
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
                        var6_5 = var2_2 /* !! */ .result;
                        var5_3 /* !! */  = L0.c.c();
                        var3_4 = var2_2 /* !! */ .label;
                        if (var3_4 == 0) ** GOTO lbl17
                        if (var3_4 == 1) {
                            k.b((Object)var6_5);
                        } else {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
lbl17:
                            // 1 sources

                            k.b((Object)var6_5);
                            var6_5 = this.$this_unsafeFlow;
                            var4_6 = ((Number)var1_1).floatValue() < DynamicIslandRegionSamplingInteractor.access$getTHRESHOLD$cp();
                            var1_1 = b.a((boolean)var4_6);
                            var2_2 /* !! */ .label = 1;
                            if (var6_5.emit(var1_1, var2_2 /* !! */ ) == var5_3 /* !! */ ) {
                                return var5_3 /* !! */ ;
                            }
                        }
                        return s.a;
                    }
                }, d2)) == L0.c.c()) {
                    return object;
                }
                return s.a;
            }
        }, (i1.f)controlCenterExpandRepository.getAppearance(), (i1.f)dynamicIslandExternalStateRepository.getNotificationAppearance(), (i1.f)statusBarStateRepository.getState(), (r)new r(null){
            int I$0;
            boolean Z$0;
            boolean Z$1;
            boolean Z$2;
            int label;

            public final Object invoke(boolean bl, boolean bl2, boolean bl3, int n, d object) {
                object = new /* invalid duplicate definition of identical inner class */;
                object.Z$0 = bl;
                object.Z$1 = bl2;
                object.Z$2 = bl3;
                object.I$0 = n;
                return object.invokeSuspend(s.a);
            }

            /*
             * Enabled aggressive block sorting
             */
            public final Object invokeSuspend(Object object) {
                L0.c.c();
                if (this.label != 0) throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                k.b((Object)object);
                boolean bl = this.Z$0;
                boolean bl2 = this.Z$1;
                boolean bl3 = this.Z$2;
                int n = this.I$0;
                if (bl && !bl2) {
                    bl = bl2 = true;
                    if (!bl3) return b.a((boolean)bl);
                    if (n == 1) {
                        bl = bl2;
                        return b.a((boolean)bl);
                    }
                }
                bl = false;
                return b.a((boolean)bl);
            }
        }), (E)e, (i1.E)E.a.b((E.a)dynamicIslandWindowStateInteractor, (long)0L, (long)0L, (int)3, null), (Object)object);
    }

    public static final /* synthetic */ boolean access$getDEBUG$cp() {
        return DEBUG;
    }

    public static final /* synthetic */ I access$getRegionSampling$p(DynamicIslandRegionSamplingInteractor dynamicIslandRegionSamplingInteractor) {
        return dynamicIslandRegionSamplingInteractor.regionSampling;
    }

    public static final /* synthetic */ RegionSamplingHelperRefactor access$getRegionSamplingHelper$p(DynamicIslandRegionSamplingInteractor dynamicIslandRegionSamplingInteractor) {
        return dynamicIslandRegionSamplingInteractor.regionSamplingHelper;
    }

    public static final /* synthetic */ StatusBarAreaRepository access$getStatusBarAreaRepository$p(DynamicIslandRegionSamplingInteractor dynamicIslandRegionSamplingInteractor) {
        return dynamicIslandRegionSamplingInteractor.statusBarAreaRepository;
    }

    public static final /* synthetic */ float access$getTHRESHOLD$cp() {
        return THRESHOLD;
    }

    private final void listenForRegionSampling() {
        f.b((E)this.scope, null, null, (U0.o)new U0.o(this, null){
            int label;
            final DynamicIslandRegionSamplingInteractor this$0;
            {
                this.this$0 = dynamicIslandRegionSamplingInteractor;
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
                    object = DynamicIslandRegionSamplingInteractor.access$getRegionSampling$p(this.this$0);
                    g g2 = new g(this.this$0){
                        final DynamicIslandRegionSamplingInteractor this$0;
                        {
                            this.this$0 = dynamicIslandRegionSamplingInteractor;
                        }

                        public final Object emit(boolean bl, d object) {
                            if (DynamicIslandRegionSamplingInteractor.access$getDEBUG$cp()) {
                                object = new StringBuilder();
                                ((StringBuilder)object).append("region sampling changed to ");
                                ((StringBuilder)object).append(bl);
                                Log.d((String)"DynamicIslandRegionSamplingInteractor", (String)((StringBuilder)object).toString());
                            }
                            DynamicIslandRegionSamplingInteractor.access$getRegionSamplingHelper$p(this.this$0).setRegionSampling(bl);
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

    private final void listenForSamplingAreaChanged() {
        f.b((E)this.scope, null, null, (U0.o)new U0.o(this, null){
            int label;
            final DynamicIslandRegionSamplingInteractor this$0;
            {
                this.this$0 = dynamicIslandRegionSamplingInteractor;
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
                    object = DynamicIslandRegionSamplingInteractor.access$getStatusBarAreaRepository$p(this.this$0).getStatusBarArea();
                    g g2 = new g(this.this$0){
                        final DynamicIslandRegionSamplingInteractor this$0;
                        {
                            this.this$0 = dynamicIslandRegionSamplingInteractor;
                        }

                        public final Object emit(Rect rect, d object) {
                            if (DynamicIslandRegionSamplingInteractor.access$getDEBUG$cp()) {
                                object = new StringBuilder();
                                ((StringBuilder)object).append("sampling area changed to ");
                                ((StringBuilder)object).append(rect);
                                Log.d((String)"DynamicIslandRegionSamplingInteractor", (String)((StringBuilder)object).toString());
                            }
                            DynamicIslandRegionSamplingInteractor.access$getRegionSamplingHelper$p(this.this$0).updateSamplingRect();
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

    private final void logStatesChanged() {
        if (DEBUG) {
            E e = this.scope;
            f.b((E)e, null, null, (U0.o)new U0.o(this, null){
                int label;
                final DynamicIslandRegionSamplingInteractor this$0;
                {
                    this.this$0 = dynamicIslandRegionSamplingInteractor;
                    super(2, d2);
                }

                public final d create(Object object, d d2) {
                    return new /* invalid duplicate definition of identical inner class */;
                }

                public final Object invoke(E e, d d2) {
                    return (this.create(e, d2)).invokeSuspend(s.a);
                }

                public final Object invokeSuspend(Object var1_1) {
                    Object object = L0.c.c();
                    int n = this.label;
                    if (n != 0) {
                        if (n != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        k.b((Object)var1_1);
                    } else {
                        k.b((Object)var1_1);
                        I i2 = this.this$0.getMedianLuma();
                        var1_1 = logStatesChanged.1.1.INSTANCE;
                        this.label = 1;
                        if (i2.collect(var1_1, (d)this) == object) {
                            return object;
                        }
                    }
                    throw new c();
                }
            }, (int)3, null);
            f.b((E)e, null, null, (U0.o)new U0.o(this, null){
                int label;
                final DynamicIslandRegionSamplingInteractor this$0;
                {
                    this.this$0 = dynamicIslandRegionSamplingInteractor;
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
                        object = this.this$0.isRegionDark();
                        logStatesChanged.1.1<T> var4_4 = logStatesChanged.1.1.INSTANCE;
                        this.label = 1;
                        if (object.collect(var4_4, (d)this) == object2) {
                            return object2;
                        }
                    }
                    throw new c();
                }
            }, (int)3, null);
        }
    }

    public final I getMedianLuma() {
        return this.medianLuma;
    }

    public final I isRegionDark() {
        return this.isRegionDark;
    }

    @Override
    public void start() {
        this.listenForSamplingAreaChanged();
        this.listenForRegionSampling();
        this.logStatesChanged();
    }
}
