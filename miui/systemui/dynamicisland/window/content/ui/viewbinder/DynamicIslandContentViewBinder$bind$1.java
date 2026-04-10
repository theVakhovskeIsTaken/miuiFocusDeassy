/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  G0.k
 *  G0.s
 *  K0.d
 *  L0.c
 *  M0.f
 *  M0.l
 *  U0.o
 *  f1.E
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
import f1.E;
import i1.g;
import miui.systemui.dynamicisland.window.DynamicIslandViewModel;
import miui.systemui.dynamicisland.window.content.DynamicIslandContentView;

@f(c="miui.systemui.dynamicisland.window.content.ui.viewbinder.DynamicIslandContentViewBinder$bind$1", f="DynamicIslandContentViewBinder.kt", l={16}, m="invokeSuspend")
public static final class DynamicIslandContentViewBinder.bind.1
extends l
implements o {
    final DynamicIslandContentView $view;
    final DynamicIslandViewModel $viewModel;
    int label;

    public DynamicIslandContentViewBinder.bind.1(DynamicIslandViewModel dynamicIslandViewModel, DynamicIslandContentView dynamicIslandContentView, d d2) {
        this.$viewModel = dynamicIslandViewModel;
        this.$view = dynamicIslandContentView;
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
            object = this.$viewModel.isExpanded();
            g g2 = new g(this.$view){
                final DynamicIslandContentView $view;
                {
                    this.$view = dynamicIslandContentView;
                }

                public final Object emit(boolean bl, d d2) {
                    this.$view.setBlockChildrenTouch(bl ^ true);
                    return s.a;
                }
            };
            this.label = 1;
            if (object.collect(g2, (d)this) != object2) return s.a;
            return object2;
        }
    }
}
