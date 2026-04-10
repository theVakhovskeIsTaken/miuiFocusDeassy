/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  G0.k
 *  G0.s
 *  K0.d
 *  L0.c
 *  M0.d
 *  M0.f
 *  M0.l
 *  U0.o
 *  android.graphics.Rect
 *  f1.E
 *  i1.f
 *  i1.g
 *  kotlin.jvm.internal.x
 */
package miui.systemui.dynamicisland.window.domain.interactor;

import G0.k;
import G0.s;
import K0.d;
import L0.c;
import M0.l;
import U0.o;
import android.graphics.Rect;
import f1.E;
import i1.f;
import i1.g;
import kotlin.jvm.internal.x;
import miui.systemui.dynamicisland.touch.TouchEvent;
import miui.systemui.dynamicisland.window.domain.interactor.DynamicIslandWindowViewTouchInteractor;
import miui.systemui.dynamicisland.window.domain.interactor.DynamicIslandWindowViewTouchInteractor$start$2$invokeSuspend$;

@M0.f(c="miui.systemui.dynamicisland.window.domain.interactor.DynamicIslandWindowViewTouchInteractor$start$2", f="DynamicIslandWindowViewTouchInteractor.kt", l={89}, m="invokeSuspend")
public static final class DynamicIslandWindowViewTouchInteractor.start.2
extends l
implements o {
    final x $downInStatusBarArea;
    int label;
    final DynamicIslandWindowViewTouchInteractor this$0;

    public DynamicIslandWindowViewTouchInteractor.start.2(DynamicIslandWindowViewTouchInteractor dynamicIslandWindowViewTouchInteractor, x x2, d d2) {
        this.this$0 = dynamicIslandWindowViewTouchInteractor;
        this.$downInStatusBarArea = x2;
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
            object = new f((f)this.this$0.windowView.getOnInterceptTouchEvent()){
                final f $this_unsafeTransform$inlined;
                {
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
                            if (!(var2_2 /* !! */  instanceof invokeSuspend$$inlined$filter$1$2$1)) ** GOTO lbl-1000
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
                                    final invokeSuspend$$inlined$filter$1$2 this$0;
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
                                if (((TouchEvent)var1_1).getEvent().getActionMasked() != 4) {
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
            g g2 = new g(this.$downInStatusBarArea, this.this$0){
                final x $downInStatusBarArea;
                final DynamicIslandWindowViewTouchInteractor this$0;
                {
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
                                                    final 2<T> this$0;
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
            };
            this.label = 1;
            if (object.collect(g2, (d)this) != object2) return s.a;
            return object2;
        }
    }
}
