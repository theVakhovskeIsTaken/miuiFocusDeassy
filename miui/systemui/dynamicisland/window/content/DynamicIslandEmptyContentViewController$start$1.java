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
 *  android.view.View
 *  f1.E
 *  i1.f
 *  i1.g
 *  kotlin.jvm.internal.o
 *  miui.systemui.util.coroutines.flow.ViewUtilsKt
 */
package miui.systemui.dynamicisland.window.content;

import G0.k;
import G0.s;
import K0.d;
import L0.c;
import M0.l;
import android.view.View;
import f1.E;
import i1.f;
import i1.g;
import kotlin.jvm.internal.o;
import miui.systemui.dynamicisland.window.content.DynamicIslandEmptyContentView;
import miui.systemui.dynamicisland.window.content.DynamicIslandEmptyContentViewController;
import miui.systemui.util.coroutines.flow.ViewUtilsKt;

@M0.f(c="miui.systemui.dynamicisland.window.content.DynamicIslandEmptyContentViewController$start$1", f="DynamicIslandEmptyContentViewController.kt", l={34}, m="invokeSuspend")
public static final class DynamicIslandEmptyContentViewController.start.1
extends l
implements U0.o {
    int label;
    final DynamicIslandEmptyContentViewController this$0;

    public DynamicIslandEmptyContentViewController.start.1(DynamicIslandEmptyContentViewController dynamicIslandEmptyContentViewController, d d2) {
        this.this$0 = dynamicIslandEmptyContentViewController;
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
            DynamicIslandEmptyContentView dynamicIslandEmptyContentView = this.this$0.view;
            o.f((Object)((Object)dynamicIslandEmptyContentView), (String)"access$getView$p(...)");
            f f2 = ViewUtilsKt.getOnClick((View)dynamicIslandEmptyContentView);
            g g2 = new g(this.this$0){
                final DynamicIslandEmptyContentViewController this$0;
                {
                    this.this$0 = dynamicIslandEmptyContentViewController;
                }

                public final Object emit(s s2, d d2) {
                    DynamicIslandEmptyContentViewController.access$getTouchInteractor$p(this.this$0).performClick();
                    return s.a;
                }
            };
            this.label = 1;
            if (f2.collect(g2, (d)this) != object2) return s.a;
            return object2;
        }
    }
}
