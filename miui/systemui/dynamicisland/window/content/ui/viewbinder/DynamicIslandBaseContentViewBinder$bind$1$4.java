/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  G0.c
 *  G0.k
 *  G0.s
 *  K0.d
 *  L0.c
 *  M0.f
 *  M0.l
 *  U0.o
 *  android.util.Log
 *  f1.E
 *  i1.I
 *  i1.g
 */
package miui.systemui.dynamicisland.window.content.ui.viewbinder;

import G0.k;
import G0.s;
import K0.d;
import L0.c;
import M0.f;
import M0.l;
import U0.o;
import android.util.Log;
import f1.E;
import i1.I;
import i1.g;
import miui.systemui.dynamicisland.anim.DynamicIslandAnimationDelegate;
import miui.systemui.dynamicisland.data.repository.DynamicIslandSizeRepository;
import miui.systemui.dynamicisland.event.DynamicIslandEventCoordinator;
import miui.systemui.dynamicisland.event.DynamicIslandState;
import miui.systemui.dynamicisland.window.content.DynamicIslandBaseContentView;

@f(c="miui.systemui.dynamicisland.window.content.ui.viewbinder.DynamicIslandBaseContentViewBinder$bind$1$4", f="DynamicIslandBaseContentViewBinder.kt", l={44}, m="invokeSuspend")
public static final class DynamicIslandBaseContentViewBinder.bind.4
extends l
implements o {
    final boolean $propOnce;
    final DynamicIslandSizeRepository $sizeRepository;
    final DynamicIslandBaseContentView $view;
    int label;

    public DynamicIslandBaseContentViewBinder.bind.4(DynamicIslandSizeRepository dynamicIslandSizeRepository, boolean bl, DynamicIslandBaseContentView dynamicIslandBaseContentView, d d2) {
        this.$sizeRepository = dynamicIslandSizeRepository;
        this.$propOnce = bl;
        this.$view = dynamicIslandBaseContentView;
        super(2, d2);
    }

    public final d create(Object object, d d2) {
        return new /* invalid duplicate definition of identical inner class */;
    }

    public final Object invoke(E e, d d2) {
        return (this.create(e, d2)).invokeSuspend(s.a);
    }

    public final Object invokeSuspend(Object g2) {
        Object object = c.c();
        int n = this.label;
        if (n != 0) {
            if (n != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            k.b((Object)g2);
        } else {
            k.b((Object)g2);
            I i = this.$sizeRepository.getStatusBarDatePosX();
            g2 = new g(this.$propOnce, this.$view){
                final boolean $propOnce;
                final DynamicIslandBaseContentView $view;
                {
                    this.$propOnce = bl;
                    this.$view = dynamicIslandBaseContentView;
                }

                public final Object emit(int n, d object) {
                    object = new StringBuilder();
                    ((StringBuilder)object).append("statusBarDatePosX change to ");
                    ((StringBuilder)object).append(n);
                    Log.d((String)"DynamicIslandContentView", (String)((StringBuilder)object).toString());
                    if (this.$propOnce) {
                        return s.a;
                    }
                    if (n != this.$view.getStatusBarDatePosX()) {
                        this.$view.setStatusBarDatePosX(n);
                        this.$view.updateBigIslandLayout();
                        object = this.$view.getDynamicIslandEventCoordinator();
                        if (object != null) {
                            ((DynamicIslandEventCoordinator)object).updateTouchRegion();
                        }
                        if (this.$view.getState() instanceof DynamicIslandState.BigIsland) {
                            object = this.$view.getAnimatorDelegate();
                            if (object != null) {
                                ((DynamicIslandAnimationDelegate)object).updateBigIslandPosition();
                            }
                            if ((object = this.$view.getAnimatorDelegate()) != null) {
                                ((DynamicIslandAnimationDelegate)object).containerScheduleUpdate();
                            }
                        }
                    }
                    return s.a;
                }
            };
            this.label = 1;
            if (i.collect(g2, (d)this) == object) {
                return object;
            }
        }
        throw new G0.c();
    }
}
