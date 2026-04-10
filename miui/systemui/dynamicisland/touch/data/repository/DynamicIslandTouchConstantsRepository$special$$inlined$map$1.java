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
 *  android.content.Context
 *  android.view.ViewConfiguration
 *  i1.f
 *  i1.g
 */
package miui.systemui.dynamicisland.touch.data.repository;

import G0.k;
import G0.s;
import K0.d;
import L0.c;
import M0.b;
import android.content.Context;
import android.view.ViewConfiguration;
import i1.f;
import i1.g;
import miui.systemui.dynamicisland.touch.data.repository.DynamicIslandTouchConstantsRepository;
import miui.systemui.dynamicisland.touch.data.repository.DynamicIslandTouchConstantsRepository$special$;

public static final class DynamicIslandTouchConstantsRepository$special$.inlined.map.1
implements f {
    final f $this_unsafeTransform$inlined;
    final DynamicIslandTouchConstantsRepository this$0;

    public DynamicIslandTouchConstantsRepository$special$.inlined.map.1(f f2, DynamicIslandTouchConstantsRepository dynamicIslandTouchConstantsRepository) {
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
}
