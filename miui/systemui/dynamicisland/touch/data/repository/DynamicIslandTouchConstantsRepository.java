/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  G0.k
 *  G0.s
 *  K0.d
 *  L0.c
 *  M0.b
 *  M0.d
 *  U0.a
 *  U0.o
 *  android.content.Context
 *  android.content.res.Configuration
 *  android.view.ViewConfiguration
 *  f1.E
 *  h1.o
 *  h1.q
 *  i1.E
 *  i1.E$a
 *  i1.I
 *  i1.f
 *  i1.g
 *  i1.h
 *  kotlin.jvm.internal.o
 *  miui.systemui.autodensity.AutoDensityController
 *  miui.systemui.autodensity.AutoDensityController$OnDensityChangeListener
 *  miui.systemui.util.coroutines.flow.FlowConflatedKt
 */
package miui.systemui.dynamicisland.touch.data.repository;

import G0.k;
import G0.s;
import K0.d;
import L0.c;
import M0.b;
import U0.a;
import android.content.Context;
import android.content.res.Configuration;
import android.view.ViewConfiguration;
import f1.E;
import h1.o;
import h1.q;
import i1.E;
import i1.I;
import i1.f;
import i1.g;
import i1.h;
import miui.systemui.autodensity.AutoDensityController;
import miui.systemui.dynamicisland.R;
import miui.systemui.dynamicisland.dagger.DynamicIslandScope;
import miui.systemui.dynamicisland.dagger.qualifiers.DynamicIsland;
import miui.systemui.dynamicisland.touch.data.repository.DynamicIslandTouchConstantsRepository;
import miui.systemui.dynamicisland.touch.data.repository.DynamicIslandTouchConstantsRepository$special$;
import miui.systemui.util.coroutines.flow.FlowConflatedKt;

@DynamicIslandScope
public final class DynamicIslandTouchConstantsRepository {
    private final AutoDensityController autoDensityController;
    private final Context context;
    private final f densityChanged;
    private final E scope;
    private final I swipeThreshold;
    private final I touchSlop;

    public DynamicIslandTouchConstantsRepository(@DynamicIsland E e, Context context, AutoDensityController object) {
        kotlin.jvm.internal.o.g((Object)e, (String)"scope");
        kotlin.jvm.internal.o.g((Object)context, (String)"context");
        kotlin.jvm.internal.o.g((Object)object, (String)"autoDensityController");
        this.scope = e;
        this.context = context;
        this.autoDensityController = object;
        context = FlowConflatedKt.conflatedCallbackFlow((U0.o)new U0.o(this, null){
            private Object L$0;
            Object L$1;
            int label;
            final DynamicIslandTouchConstantsRepository this$0;
            {
                this.this$0 = dynamicIslandTouchConstantsRepository;
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

            public final Object invokeSuspend(Object object) {
                block5: {
                    densityChanged.listener.1 var3_4;
                    Object object2;
                    block6: {
                        block2: {
                            block3: {
                                block4: {
                                    object2 = c.c();
                                    int n = this.label;
                                    if (n == 0) break block2;
                                    if (n == 1) break block3;
                                    if (n != 2) break block4;
                                    k.b((Object)object);
                                    break block5;
                                }
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            var3_4 = this.L$1;
                            q q2 = (q)this.L$0;
                            k.b((Object)object);
                            object = q2;
                            break block6;
                        }
                        k.b((Object)object);
                        object = (q)this.L$0;
                        var3_4 = new AutoDensityController.OnDensityChangeListener((q)object){
                            final q $$this$conflatedCallbackFlow;
                            {
                                this.$$this$conflatedCallbackFlow = q2;
                            }

                            public void onConfigChanged(Configuration configuration) {
                                kotlin.jvm.internal.o.g((Object)configuration, (String)"config");
                                this.$$this$conflatedCallbackFlow.i((Object)s.a);
                            }
                        };
                        s s2 = s.a;
                        this.L$0 = object;
                        this.L$1 = var3_4;
                        this.label = 1;
                        if (object.j((Object)s2, (d)this) == object2) {
                            return object2;
                        }
                    }
                    DynamicIslandTouchConstantsRepository.access$getAutoDensityController$p(this.this$0).addOnDensityChangeListener((AutoDensityController.OnDensityChangeListener)var3_4);
                    var3_4 = new a(this.this$0, var3_4){
                        final densityChanged.listener.1 $listener;
                        final DynamicIslandTouchConstantsRepository this$0;
                        {
                            this.this$0 = dynamicIslandTouchConstantsRepository;
                            this.$listener = var2_2;
                            super(0);
                        }

                        public final void invoke() {
                            DynamicIslandTouchConstantsRepository.access$getAutoDensityController$p(this.this$0).removeOnDensityChangeListener((AutoDensityController.OnDensityChangeListener)this.$listener);
                        }
                    };
                    this.L$0 = null;
                    this.L$1 = null;
                    this.label = 2;
                    if (o.a((q)object, (a)var3_4, (d)this) == object2) {
                        return object2;
                    }
                }
                return s.a;
            }
        });
        this.densityChanged = context;
        object = new f((f)context, this){
            final f $this_unsafeTransform$inlined;
            final DynamicIslandTouchConstantsRepository this$0;
            {
                this.$this_unsafeTransform$inlined = f2;
                this.this$0 = dynamicIslandTouchConstantsRepository;
            }

            public Object collect(g object, d d2) {
                if ((object = this.$this_unsafeTransform$inlined.collect(new g((g)object, this.this$0){
                    final g $this_unsafeFlow;
                    final DynamicIslandTouchConstantsRepository this$0;
                    {
                        this.$this_unsafeFlow = g2;
                        this.this$0 = dynamicIslandTouchConstantsRepository;
                    }

                    /*
                     * Unable to fully structure code
                     * Could not resolve type clashes
                     */
                    public final Object emit(Object var1_1, d var2_2) {
                        if (!(var2_2 /* !! */  instanceof special$$inlined$map$1$2$1)) ** GOTO lbl-1000
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
                            var1_1 = (s)var1_1;
                            var1_1 = b.c((int)ViewConfiguration.get((Context)DynamicIslandTouchConstantsRepository.access$getContext$p(this.this$0)).getScaledTouchSlop());
                            var2_2 /* !! */ .label = 1;
                            if (var5_5.emit(var1_1, var2_2 /* !! */ ) == var4_3 /* !! */ ) {
                                return var4_3 /* !! */ ;
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
        E.a a2 = i1.E.a;
        i1.E e2 = a2.c();
        Integer n = Integer.MIN_VALUE;
        this.touchSlop = h.B((f)object, (E)e, (i1.E)e2, (Object)n);
        this.swipeThreshold = h.B((f)new f((f)context, this){
            final f $this_unsafeTransform$inlined;
            final DynamicIslandTouchConstantsRepository this$0;
            {
                this.$this_unsafeTransform$inlined = f2;
                this.this$0 = dynamicIslandTouchConstantsRepository;
            }

            public Object collect(g object, d d2) {
                if ((object = this.$this_unsafeTransform$inlined.collect(new g((g)object, this.this$0){
                    final g $this_unsafeFlow;
                    final DynamicIslandTouchConstantsRepository this$0;
                    {
                        this.$this_unsafeFlow = g2;
                        this.this$0 = dynamicIslandTouchConstantsRepository;
                    }

                    /*
                     * Unable to fully structure code
                     * Could not resolve type clashes
                     */
                    public final Object emit(Object var1_1, d var2_2) {
                        if (!(var2_2 /* !! */  instanceof special$$inlined$map$2$2$1)) ** GOTO lbl-1000
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
                                int label;
                                Object result;
                                final special$$inlined$map$2$2 this$0;
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
                            var1_1 = (s)var1_1;
                            var1_1 = b.c((int)DynamicIslandTouchConstantsRepository.access$getContext$p(this.this$0).getResources().getDimensionPixelSize(R.dimen.island_swipe_threshold));
                            var2_2 /* !! */ .label = 1;
                            if (var5_5.emit(var1_1, var2_2 /* !! */ ) == var4_3 /* !! */ ) {
                                return var4_3 /* !! */ ;
                            }
                        }
                        return s.a;
                    }
                }, d2)) == c.c()) {
                    return object;
                }
                return s.a;
            }
        }, (E)e, (i1.E)a2.c(), (Object)n);
    }

    public static final /* synthetic */ AutoDensityController access$getAutoDensityController$p(DynamicIslandTouchConstantsRepository dynamicIslandTouchConstantsRepository) {
        return dynamicIslandTouchConstantsRepository.autoDensityController;
    }

    public static final /* synthetic */ Context access$getContext$p(DynamicIslandTouchConstantsRepository dynamicIslandTouchConstantsRepository) {
        return dynamicIslandTouchConstantsRepository.context;
    }

    public final I getSwipeThreshold() {
        return this.swipeThreshold;
    }

    public final I getTouchSlop() {
        return this.touchSlop;
    }
}
