/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  G0.k
 *  G0.s
 *  K0.d
 *  L0.c
 *  M0.d
 *  android.graphics.Region
 *  i1.f
 *  i1.g
 *  kotlin.jvm.internal.o
 */
package miui.systemui.dynamicisland.touch.domain.interactor;

import G0.k;
import G0.s;
import K0.d;
import L0.c;
import android.graphics.Region;
import i1.f;
import i1.g;
import kotlin.jvm.internal.o;
import miui.systemui.dynamicisland.touch.TouchEvent;
import miui.systemui.dynamicisland.touch.domain.interactor.DynamicIslandExternalTouchInteractor;
import miui.systemui.dynamicisland.touch.domain.interactor.DynamicIslandExternalTouchInteractor$special$;

public static final class DynamicIslandExternalTouchInteractor$special$.inlined.filter.1
implements f {
    final f $this_unsafeTransform$inlined;
    final DynamicIslandExternalTouchInteractor this$0;

    public DynamicIslandExternalTouchInteractor$special$.inlined.filter.1(f f2, DynamicIslandExternalTouchInteractor dynamicIslandExternalTouchInteractor) {
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
}
