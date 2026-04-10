/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  G0.k
 *  G0.s
 *  K0.d
 *  L0.c
 *  M0.d
 *  i1.g
 *  kotlin.jvm.internal.x
 */
package miui.systemui.dynamicisland.window.domain.interactor;

import G0.k;
import G0.s;
import K0.d;
import L0.c;
import i1.g;
import kotlin.jvm.internal.x;
import miui.systemui.dynamicisland.touch.TouchEvent;
import miui.systemui.dynamicisland.window.domain.interactor.DynamicIslandWindowViewTouchInteractor;

public static final class DynamicIslandWindowViewTouchInteractor.start.2<T>
implements g {
    final x $downInStatusBarArea;
    final DynamicIslandWindowViewTouchInteractor this$0;

    public DynamicIslandWindowViewTouchInteractor.start.2(DynamicIslandWindowViewTouchInteractor dynamicIslandWindowViewTouchInteractor, x x2) {
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
                                if (!(var2_2 /* !! */  instanceof emit.1)) ** GOTO lbl-1000
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
                                        final DynamicIslandWindowViewTouchInteractor.start.2<T> this$0;
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
                                var6_6 = c.c();
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
}
