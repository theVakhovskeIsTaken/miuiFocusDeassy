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
 *  android.view.MotionEvent
 *  f1.E
 *  i1.f
 *  i1.g
 */
package miui.systemui.dynamicisland.window.domain.interactor;

import G0.k;
import G0.s;
import K0.d;
import L0.c;
import M0.l;
import U0.o;
import android.view.MotionEvent;
import f1.E;
import i1.f;
import i1.g;
import miui.systemui.dynamicisland.window.domain.interactor.DynamicIslandWindowViewTouchInteractor;
import miui.systemui.dynamicisland.window.domain.interactor.DynamicIslandWindowViewTouchInteractor$start$1$invokeSuspend$;

@M0.f(c="miui.systemui.dynamicisland.window.domain.interactor.DynamicIslandWindowViewTouchInteractor$start$1", f="DynamicIslandWindowViewTouchInteractor.kt", l={79}, m="invokeSuspend")
public static final class DynamicIslandWindowViewTouchInteractor.start.1
extends l
implements o {
    int label;
    final DynamicIslandWindowViewTouchInteractor this$0;

    public DynamicIslandWindowViewTouchInteractor.start.1(DynamicIslandWindowViewTouchInteractor dynamicIslandWindowViewTouchInteractor, d d2) {
        this.this$0 = dynamicIslandWindowViewTouchInteractor;
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
    public final Object invokeSuspend(Object g2) {
        Object object = c.c();
        int n = this.label;
        if (n != 0) {
            if (n != 1) throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            k.b((Object)g2);
            return s.a;
        } else {
            k.b((Object)g2);
            f f2 = new f((f)this.this$0.windowView.getDispatchTouchEvent()){
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
                                if (((MotionEvent)var1_1).getActionMasked() != 4) {
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
            g2 = new g(this.this$0){
                final DynamicIslandWindowViewTouchInteractor this$0;
                {
                    this.this$0 = dynamicIslandWindowViewTouchInteractor;
                }

                public final Object emit(MotionEvent object, d d2) {
                    object = DynamicIslandWindowViewTouchInteractor.access$get_trackTouchEvent$p(this.this$0).emit(object, d2);
                    if (object == c.c()) {
                        return object;
                    }
                    return s.a;
                }
            };
            this.label = 1;
            if (f2.collect(g2, (d)this) != object) return s.a;
            return object;
        }
    }
}
