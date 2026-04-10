/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  G0.k
 *  G0.s
 *  K0.d
 *  L0.c
 *  M0.d
 *  U0.o
 *  android.content.Context
 *  android.graphics.Region
 *  android.view.MotionEvent
 *  f1.E
 *  f1.f
 *  i1.A
 *  i1.f
 *  i1.g
 *  i1.t
 *  kotlin.jvm.internal.o
 *  miui.systemui.dagger.qualifiers.SystemUI
 */
package miui.systemui.dynamicisland.touch.domain.interactor;

import G0.k;
import G0.s;
import K0.d;
import L0.c;
import android.content.Context;
import android.graphics.Region;
import android.view.MotionEvent;
import f1.E;
import f1.f;
import i1.A;
import i1.g;
import i1.t;
import kotlin.jvm.internal.o;
import miui.systemui.dagger.qualifiers.SystemUI;
import miui.systemui.dynamicisland.dagger.DynamicIslandScope;
import miui.systemui.dynamicisland.dagger.qualifiers.DynamicIsland;
import miui.systemui.dynamicisland.touch.TouchEvent;
import miui.systemui.dynamicisland.touch.domain.interactor.DynamicIslandExternalTouchInteractor$special$;
import miui.systemui.dynamicisland.window.domain.interactor.DynamicIslandTouchRegionInteractor;

@DynamicIslandScope
public final class DynamicIslandExternalTouchInteractor {
    public static final Companion Companion = new Object(null){
        {
            this();
        }
    };
    private static final String TAG = "DynamicIslandExternalTouchHandler";
    private final t _externalInterceptTouchEvent;
    private final t _externalTouchEvent;
    private final Context context;
    private boolean downInTouchRegion;
    private final i1.f externalInterceptTouchEvent;
    private final i1.f externalTouchEvent;
    private final E scope;
    private final Context sysUIContext;
    private final DynamicIslandTouchRegionInteractor touchRegionInteractor;

    public DynamicIslandExternalTouchInteractor(@DynamicIsland E e, Context context, @SystemUI Context context2, DynamicIslandTouchRegionInteractor dynamicIslandTouchRegionInteractor) {
        o.g((Object)e, (String)"scope");
        o.g((Object)context, (String)"context");
        o.g((Object)context2, (String)"sysUIContext");
        o.g((Object)dynamicIslandTouchRegionInteractor, (String)"touchRegionInteractor");
        this.scope = e;
        this.context = context;
        this.sysUIContext = context2;
        this.touchRegionInteractor = dynamicIslandTouchRegionInteractor;
        e = A.b((int)0, (int)0, null, (int)7, null);
        this._externalInterceptTouchEvent = e;
        context = A.b((int)0, (int)0, null, (int)7, null);
        this._externalTouchEvent = context;
        this.externalInterceptTouchEvent = new i1.f((i1.f)e, this){
            final i1.f $this_unsafeTransform$inlined;
            final DynamicIslandExternalTouchInteractor this$0;
            {
                this.$this_unsafeTransform$inlined = f2;
                this.this$0 = dynamicIslandExternalTouchInteractor;
            }

            public Object collect(g object, d d2) {
                if ((object = this.$this_unsafeTransform$inlined.collect(new g((g)object, this.this$0){
                    final g $this_unsafeFlow;
                    final DynamicIslandExternalTouchInteractor this$0;
                    {
                        this.$this_unsafeFlow = g2;
                        this.this$0 = dynamicIslandExternalTouchInteractor;
                    }

                    /*
                     * Unable to fully structure code
                     * Could not resolve type clashes
                     */
                    public final Object emit(Object var1_1, d var2_2) {
                        if (!(var2_2 /* !! */  instanceof special$$inlined$filter$1$2$1)) ** GOTO lbl-1000
                        var6_3 /* !! */  = var2_2 /* !! */ ;
                        var3_4 = var6_3 /* !! */ .label;
                        if ((var3_4 & -2147483648) != 0) {
                            var6_3 /* !! */ .label = var3_4 + -2147483648;
                            var2_2 /* !! */  = var6_3 /* !! */ ;
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
                        var7_5 = var2_2 /* !! */ .result;
                        var6_3 /* !! */  = c.c();
                        var3_4 = var2_2 /* !! */ .label;
                        if (var3_4 == 0) ** GOTO lbl17
                        if (var3_4 == 1) {
                            k.b((Object)var7_5);
                        } else {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
lbl17:
                            // 1 sources

                            k.b((Object)var7_5);
                            var7_5 = this.$this_unsafeFlow;
                            var8_6 = (TouchEvent)var1_1;
                            var5_7 = o.c((Object)var8_6.getSource(), (Object)"dynamic_island");
                            var4_8 = false;
                            if (!var5_7 && var8_6.getEvent().getActionMasked() != 4) {
                                if (var8_6.getEvent().getActionMasked() == 0) {
                                    DynamicIslandExternalTouchInteractor.access$setDownInTouchRegion$p(this.this$0, TouchEvent.Companion.inRegion(var8_6.getEvent(), (Region)DynamicIslandExternalTouchInteractor.access$getTouchRegionInteractor$p(this.this$0).getTouchRegion().getValue()));
                                }
                                var4_8 = DynamicIslandExternalTouchInteractor.access$getDownInTouchRegion$p(this.this$0);
                            }
                            if (var4_8) {
                                var2_2 /* !! */ .label = 1;
                                if (var7_5.emit(var1_1, var2_2 /* !! */ ) == var6_3 /* !! */ ) {
                                    return var6_3 /* !! */ ;
                                }
                            }
                        }
                        return s.a;
                    }
                }, d2)) == c.c()) {
                    return object;
                }
                return s.a;
            }
        };
        this.externalTouchEvent = new i1.f((i1.f)context, this){
            final i1.f $this_unsafeTransform$inlined;
            final DynamicIslandExternalTouchInteractor this$0;
            {
                this.$this_unsafeTransform$inlined = f2;
                this.this$0 = dynamicIslandExternalTouchInteractor;
            }

            public Object collect(g object, d d2) {
                if ((object = this.$this_unsafeTransform$inlined.collect(new g((g)object, this.this$0){
                    final g $this_unsafeFlow;
                    final DynamicIslandExternalTouchInteractor this$0;
                    {
                        this.$this_unsafeFlow = g2;
                        this.this$0 = dynamicIslandExternalTouchInteractor;
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
                        var4_3 /* !! */  = c.c();
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
                            if (!o.c((Object)((TouchEvent)var1_1).getSource(), (Object)"dynamic_island") && DynamicIslandExternalTouchInteractor.access$getDownInTouchRegion$p(this.this$0)) {
                                var2_2 /* !! */ .label = 1;
                                if (var5_5.emit(var1_1, var2_2 /* !! */ ) == var4_3 /* !! */ ) {
                                    return var4_3 /* !! */ ;
                                }
                            }
                        }
                        return s.a;
                    }
                }, d2)) == c.c()) {
                    return object;
                }
                return s.a;
            }
        };
    }

    public static final /* synthetic */ boolean access$getDownInTouchRegion$p(DynamicIslandExternalTouchInteractor dynamicIslandExternalTouchInteractor) {
        return dynamicIslandExternalTouchInteractor.downInTouchRegion;
    }

    public static final /* synthetic */ DynamicIslandTouchRegionInteractor access$getTouchRegionInteractor$p(DynamicIslandExternalTouchInteractor dynamicIslandExternalTouchInteractor) {
        return dynamicIslandExternalTouchInteractor.touchRegionInteractor;
    }

    public static final /* synthetic */ t access$get_externalInterceptTouchEvent$p(DynamicIslandExternalTouchInteractor dynamicIslandExternalTouchInteractor) {
        return dynamicIslandExternalTouchInteractor._externalInterceptTouchEvent;
    }

    public static final /* synthetic */ t access$get_externalTouchEvent$p(DynamicIslandExternalTouchInteractor dynamicIslandExternalTouchInteractor) {
        return dynamicIslandExternalTouchInteractor._externalTouchEvent;
    }

    public static final /* synthetic */ void access$setDownInTouchRegion$p(DynamicIslandExternalTouchInteractor dynamicIslandExternalTouchInteractor, boolean bl) {
        dynamicIslandExternalTouchInteractor.downInTouchRegion = bl;
    }

    public final i1.f getExternalInterceptTouchEvent() {
        return this.externalInterceptTouchEvent;
    }

    public final i1.f getExternalTouchEvent() {
        return this.externalTouchEvent;
    }

    public final Boolean handleExternalIntercept(MotionEvent object, String string) {
        o.g((Object)object, (String)"event");
        o.g((Object)string, (String)"source");
        object = new TouchEvent((MotionEvent)object, string);
        f.b((E)this.scope, null, null, (U0.o)new U0.o(this, (TouchEvent)object, null){
            final TouchEvent $touchEvent;
            int label;
            final DynamicIslandExternalTouchInteractor this$0;
            {
                this.this$0 = dynamicIslandExternalTouchInteractor;
                this.$touchEvent = touchEvent;
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
                Object object2 = c.c();
                int n = this.label;
                if (n != 0) {
                    if (n != 1) throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    k.b((Object)object);
                    return s.a;
                } else {
                    k.b((Object)object);
                    t t2 = DynamicIslandExternalTouchInteractor.access$get_externalInterceptTouchEvent$p(this.this$0);
                    object = this.$touchEvent;
                    this.label = 1;
                    if (t2.emit(object, (d)this) != object2) return s.a;
                    return object2;
                }
            }
        }, (int)3, null);
        return ((TouchEvent)object).getResult();
    }

    public final Boolean handleExternalTouch(MotionEvent object, String string) {
        o.g((Object)object, (String)"event");
        o.g((Object)string, (String)"source");
        object = new TouchEvent((MotionEvent)object, string);
        f.b((E)this.scope, null, null, (U0.o)new U0.o(this, (TouchEvent)object, null){
            final TouchEvent $touchEvent;
            int label;
            final DynamicIslandExternalTouchInteractor this$0;
            {
                this.this$0 = dynamicIslandExternalTouchInteractor;
                this.$touchEvent = touchEvent;
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
                Object object2 = c.c();
                int n = this.label;
                if (n != 0) {
                    if (n != 1) throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    k.b((Object)object);
                    return s.a;
                } else {
                    k.b((Object)object);
                    t t2 = DynamicIslandExternalTouchInteractor.access$get_externalTouchEvent$p(this.this$0);
                    object = this.$touchEvent;
                    this.label = 1;
                    if (t2.emit(object, (d)this) != object2) return s.a;
                    return object2;
                }
            }
        }, (int)3, null);
        return ((TouchEvent)object).getResult();
    }
}
