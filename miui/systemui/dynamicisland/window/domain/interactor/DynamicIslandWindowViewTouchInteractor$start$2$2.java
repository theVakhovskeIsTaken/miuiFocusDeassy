/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  G0.k
 *  G0.s
 *  K0.d
 *  L0.c
 *  M0.d
 *  android.graphics.Rect
 *  i1.g
 *  kotlin.jvm.internal.x
 */
package miui.systemui.dynamicisland.window.domain.interactor;

import G0.k;
import G0.s;
import K0.d;
import L0.c;
import android.graphics.Rect;
import i1.g;
import kotlin.jvm.internal.x;
import miui.systemui.dynamicisland.touch.TouchEvent;
import miui.systemui.dynamicisland.window.domain.interactor.DynamicIslandWindowViewTouchInteractor;

public static final class DynamicIslandWindowViewTouchInteractor.start.2<T>
implements g {
    final x $downInStatusBarArea;
    final DynamicIslandWindowViewTouchInteractor this$0;

    public DynamicIslandWindowViewTouchInteractor.start.2(x x2, DynamicIslandWindowViewTouchInteractor dynamicIslandWindowViewTouchInteractor) {
        this.$downInStatusBarArea = x2;
        this.this$0 = dynamicIslandWindowViewTouchInteractor;
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    public final Object emit(TouchEvent var1_1, d var2_2) {
        block12: {
            block10: {
                block11: {
                    block7: {
                        block8: {
                            block9: {
                                if (!(var2_2 /* !! */  instanceof emit.1)) ** GOTO lbl-1000
                                var5_3 = var2_2 /* !! */ ;
                                var3_4 = var5_3.label;
                                if ((var3_4 & -2147483648) != 0) {
                                    var5_3.label = var3_4 + -2147483648;
                                    var2_2 /* !! */  = var5_3;
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
                                var8_5 = var2_2 /* !! */ .result;
                                var7_6 = c.c();
                                var3_4 = var2_2 /* !! */ .label;
                                if (var3_4 == 0) break block7;
                                if (var3_4 == 1) break block8;
                                if (var3_4 != 2) break block9;
                                k.b((Object)var8_5);
                                break block10;
                            }
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        var5_3 = (TouchEvent)var2_2 /* !! */ .L$1;
                        var6_7 = var2_2 /* !! */ .L$0;
                        k.b((Object)var8_5);
                        break block11;
                    }
                    k.b((Object)var8_5);
                    if (var1_1.getEvent().getActionMasked() == 0) {
                        var5_3 = this.$downInStatusBarArea;
                        var5_3.a = var4_8 = TouchEvent.Companion.inRect(var1_1.getEvent(), (Rect)DynamicIslandWindowViewTouchInteractor.access$getStatusBarAreaRepository$p(this.this$0).getStatusBarArea().getValue());
                    }
                    var8_5 = DynamicIslandWindowViewTouchInteractor.access$get_islandInterceptTouchEvent$p(this.this$0);
                    var2_2 /* !! */ .L$0 = this;
                    var2_2 /* !! */ .L$1 = var1_1;
                    var2_2 /* !! */ .label = 1;
                    var6_7 = this;
                    var5_3 = var1_1;
                    if (var8_5.emit((Object)var1_1, var2_2 /* !! */ ) == var7_6) {
                        return var7_6;
                    }
                }
                if (var5_3.getResult() != null) {
                    return s.a;
                }
                if (var6_7.$downInStatusBarArea.a) {
                    var5_3.setResult(null);
                    var1_1 = DynamicIslandWindowViewTouchInteractor.access$get_dispatchInterceptTouchEvent$p(var6_7.this$0);
                    var2_2 /* !! */ .L$0 = null;
                    var2_2 /* !! */ .L$1 = null;
                    var2_2 /* !! */ .label = 2;
                    if (var1_1.emit(var5_3, var2_2 /* !! */ ) == var7_6) {
                        return var7_6;
                    } else {
                        ** GOTO lbl49
                    }
                }
                break block12;
            }
            return s.a;
        }
        return s.a;
    }
}
