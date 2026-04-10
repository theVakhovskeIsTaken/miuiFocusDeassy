/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  G0.k
 *  G0.s
 *  K0.d
 *  L0.c
 *  M0.b
 *  M0.f
 *  M0.l
 *  U0.o
 *  f1.E
 *  i1.g
 *  kotlin.jvm.functions.Function1
 *  miui.systemui.util.coroutines.flow.ViewUtilsKt
 */
package miui.systemui.dynamicisland.window.content;

import G0.k;
import G0.s;
import K0.d;
import L0.c;
import M0.b;
import M0.f;
import M0.l;
import U0.o;
import f1.E;
import i1.g;
import kotlin.jvm.functions.Function1;
import miui.systemui.dynamicisland.window.content.DynamicIslandContentViewController;
import miui.systemui.util.coroutines.flow.ViewUtilsKt;

@f(c="miui.systemui.dynamicisland.window.content.DynamicIslandContentViewController$listenForLongClick$1", f="DynamicIslandContentViewController.kt", l={171}, m="invokeSuspend")
public static final class DynamicIslandContentViewController.listenForLongClick.1
extends l
implements o {
    int label;
    final DynamicIslandContentViewController this$0;

    public DynamicIslandContentViewController.listenForLongClick.1(DynamicIslandContentViewController dynamicIslandContentViewController, d d2) {
        this.this$0 = dynamicIslandContentViewController;
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
            object = ViewUtilsKt.getOnLongClick(this.this$0.getView());
            g g2 = new g(this.this$0){
                final DynamicIslandContentViewController this$0;
                {
                    this.this$0 = dynamicIslandContentViewController;
                }

                public final Object emit(Function1 function1, d d2) {
                    function1.invoke((Object)b.a((boolean)DynamicIslandContentViewController.access$getTouchInteractor$p(this.this$0).performLongClick()));
                    return s.a;
                }
            };
            this.label = 1;
            if (object.collect(g2, (d)this) != object2) return s.a;
            return object2;
        }
    }
}
