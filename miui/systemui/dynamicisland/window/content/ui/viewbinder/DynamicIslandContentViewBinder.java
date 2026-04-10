/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  G0.k
 *  G0.s
 *  K0.d
 *  L0.c
 *  U0.o
 *  f1.E
 *  f1.f
 *  i1.g
 *  kotlin.jvm.internal.o
 */
package miui.systemui.dynamicisland.window.content.ui.viewbinder;

import G0.k;
import G0.s;
import K0.d;
import L0.c;
import f1.E;
import f1.f;
import i1.g;
import kotlin.jvm.internal.o;
import miui.systemui.dynamicisland.window.DynamicIslandViewModel;
import miui.systemui.dynamicisland.window.content.DynamicIslandContentView;

public final class DynamicIslandContentViewBinder {
    public static final DynamicIslandContentViewBinder INSTANCE = new DynamicIslandContentViewBinder();

    private DynamicIslandContentViewBinder() {
    }

    public final void bind(DynamicIslandContentView dynamicIslandContentView, E e, DynamicIslandViewModel dynamicIslandViewModel) {
        o.g((Object)((Object)dynamicIslandContentView), (String)"view");
        o.g((Object)e, (String)"scope");
        o.g((Object)dynamicIslandViewModel, (String)"viewModel");
        f.b((E)e, null, null, (U0.o)new U0.o(dynamicIslandViewModel, dynamicIslandContentView, null){
            final DynamicIslandContentView $view;
            final DynamicIslandViewModel $viewModel;
            int label;
            {
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
        }, (int)3, null);
    }
}
