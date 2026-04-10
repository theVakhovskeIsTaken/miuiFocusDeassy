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
 */
package miui.systemui.dynamicisland.data.repository;

import G0.k;
import G0.s;
import K0.d;
import L0.c;
import i1.f;
import i1.g;
import miui.systemui.dynamicisland.data.repository.DynamicIslandSizeRepository;
import miui.systemui.dynamicisland.data.repository.DynamicIslandSizeRepository$phoneContentViewDimensions$lambda$1$;

public static final class DynamicIslandSizeRepository$phoneContentViewDimensions$lambda$1$.inlined.map.1
implements f {
    final f $this_unsafeTransform$inlined;
    final DynamicIslandSizeRepository this$0;

    public DynamicIslandSizeRepository$phoneContentViewDimensions$lambda$1$.inlined.map.1(f f2, DynamicIslandSizeRepository dynamicIslandSizeRepository) {
        this.$this_unsafeTransform$inlined = f2;
        this.this$0 = dynamicIslandSizeRepository;
    }

    public Object collect(g object, d d2) {
        if ((object = this.$this_unsafeTransform$inlined.collect(new g((g)object, this.this$0){
            final g $this_unsafeFlow;
            final DynamicIslandSizeRepository this$0;
            {
                this.$this_unsafeFlow = g2;
                this.this$0 = dynamicIslandSizeRepository;
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
                    var1_1 = DynamicIslandSizeRepository.access$phoneContentViewDimensions$lambda$1$load(this.this$0);
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
