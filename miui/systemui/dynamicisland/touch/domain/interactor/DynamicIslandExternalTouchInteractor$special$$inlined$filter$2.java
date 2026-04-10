/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  G0.k
 *  G0.s
 *  K0.d
 *  L0.c
 *  M0.d
 *  i1.f
 *  i1.g
 *  kotlin.jvm.internal.o
 */
package miui.systemui.dynamicisland.touch.domain.interactor;

import G0.k;
import G0.s;
import K0.d;
import L0.c;
import i1.f;
import i1.g;
import kotlin.jvm.internal.o;
import miui.systemui.dynamicisland.touch.TouchEvent;
import miui.systemui.dynamicisland.touch.domain.interactor.DynamicIslandExternalTouchInteractor;
import miui.systemui.dynamicisland.touch.domain.interactor.DynamicIslandExternalTouchInteractor$special$;

public static final class DynamicIslandExternalTouchInteractor$special$.inlined.filter.2
implements f {
    final f $this_unsafeTransform$inlined;
    final DynamicIslandExternalTouchInteractor this$0;

    public DynamicIslandExternalTouchInteractor$special$.inlined.filter.2(f f2, DynamicIslandExternalTouchInteractor dynamicIslandExternalTouchInteractor) {
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
                if (!(var2_2 /* !! */  instanceof 1)) ** GOTO lbl-1000
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
                        final 2 this$0;
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
}
