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
 *  i1.g
 */
package miui.systemui.dynamicisland.touch.data.repository;

import G0.k;
import G0.s;
import K0.d;
import L0.c;
import M0.b;
import i1.g;
import miui.systemui.dynamicisland.R;
import miui.systemui.dynamicisland.touch.data.repository.DynamicIslandTouchConstantsRepository;
import miui.systemui.dynamicisland.touch.data.repository.DynamicIslandTouchConstantsRepository$special$;

public static final class DynamicIslandTouchConstantsRepository$special$.inlined.map.2<T>
implements g {
    final g $this_unsafeFlow;
    final DynamicIslandTouchConstantsRepository this$0;

    public DynamicIslandTouchConstantsRepository$special$.inlined.map.2(g g2, DynamicIslandTouchConstantsRepository dynamicIslandTouchConstantsRepository) {
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
                final DynamicIslandTouchConstantsRepository$special$.inlined.map.2 this$0;
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
}
