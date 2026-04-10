/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  G0.k
 *  G0.s
 *  K0.d
 *  L0.c
 *  M0.d
 *  android.view.View
 *  i1.f
 *  i1.g
 */
package miui.systemui.dynamicisland.window;

import G0.k;
import G0.s;
import K0.d;
import L0.c;
import android.view.View;
import i1.f;
import i1.g;
import java.util.ArrayList;
import java.util.List;
import miui.systemui.dynamicisland.DynamicIslandBackgroundView;
import miui.systemui.dynamicisland.window.DynamicIslandWindowViewController$special$;
import miui.systemui.dynamicisland.window.content.DynamicIslandContentView;

public static final class DynamicIslandWindowViewController$special$.inlined.map.1
implements f {
    final f $this_unsafeTransform$inlined;

    public DynamicIslandWindowViewController$special$.inlined.map.1(f f2) {
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
                if (!(var2_2 /* !! */  instanceof 1)) ** GOTO lbl-1000
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
                var5_3 /* !! */  = var2_2 /* !! */ .result;
                var6_5 = c.c();
                var3_4 = var2_2 /* !! */ .label;
                if (var3_4 == 0) ** GOTO lbl17
                if (var3_4 == 1) {
                    k.b((Object)var5_3 /* !! */ );
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
lbl17:
                    // 1 sources

                    k.b((Object)var5_3 /* !! */ );
                    var7_6 = this.$this_unsafeFlow;
                    var1_1 /* !! */  = (List)var1_1 /* !! */ ;
                    var8_7 = new ArrayList<1>();
                    var9_8 = var1_1 /* !! */ .iterator();
                    while (var9_8.hasNext()) {
                        var1_1 /* !! */  = (View)var9_8.next();
                        var4_9 = var1_1 /* !! */  instanceof DynamicIslandBackgroundView;
                        var5_3 /* !! */  = null;
                        var1_1 /* !! */  = var4_9 != false ? (DynamicIslandBackgroundView)var1_1 /* !! */  : null;
                        if ((var1_1 /* !! */  = var1_1 /* !! */  != null ? var1_1 /* !! */ .getChildAt(0) : null) instanceof DynamicIslandContentView) {
                            var5_3 /* !! */  = (DynamicIslandContentView)var1_1 /* !! */ ;
                        }
                        if (var5_3 /* !! */  == null) continue;
                        var8_7.add(var5_3 /* !! */ );
                    }
                    var2_2 /* !! */ .label = 1;
                    if (var7_6.emit(var8_7, var2_2 /* !! */ ) == var6_5) {
                        return var6_5;
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
