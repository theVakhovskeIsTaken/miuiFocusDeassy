/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  G0.c
 *  G0.i
 *  G0.k
 *  G0.s
 *  K0.d
 *  L0.c
 *  M0.f
 *  M0.l
 *  U0.p
 *  android.view.View
 *  f1.E
 *  i1.I
 *  i1.g
 */
package miui.systemui.dynamicisland.window.content;

import G0.i;
import G0.k;
import G0.s;
import K0.d;
import L0.c;
import M0.f;
import M0.l;
import U0.p;
import android.view.View;
import f1.E;
import i1.I;
import i1.g;
import miui.systemui.dynamicisland.window.content.DynamicIslandBaseContentView;
import miui.systemui.dynamicisland.window.content.DynamicIslandBaseContentViewController;

@f(c="miui.systemui.dynamicisland.window.content.DynamicIslandBaseContentViewController$2", f="DynamicIslandBaseContentViewController.kt", l={97}, m="invokeSuspend")
public static final class DynamicIslandBaseContentViewController.2
extends l
implements p {
    int label;
    final DynamicIslandBaseContentViewController<T> this$0;

    public DynamicIslandBaseContentViewController.2(DynamicIslandBaseContentViewController<? extends T> dynamicIslandBaseContentViewController, d d2) {
        this.this$0 = dynamicIslandBaseContentViewController;
        super(3, d2);
    }

    public final Object invoke(E e, View view, d d2) {
        return new /* invalid duplicate definition of identical inner class */.invokeSuspend(s.a);
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
            I i2 = this.this$0.touchInteractor.getSwipeInfo();
            g2 = new g(this.this$0){
                final DynamicIslandBaseContentViewController<T> this$0;
                {
                    this.this$0 = dynamicIslandBaseContentViewController;
                }

                public final Object emit(i i2, d d2) {
                    ((DynamicIslandBaseContentView)((Object)this.this$0.getView())).setSwipeInfo(i2);
                    return s.a;
                }
            };
            this.label = 1;
            if (i2.collect(g2, (d)this) == object) {
                return object;
            }
        }
        throw new G0.c();
    }
}
