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
 *  U0.a
 *  U0.o
 *  android.view.View
 *  android.view.ViewGroup
 *  android.view.ViewGroup$OnHierarchyChangeListener
 *  androidx.core.view.ViewGroupKt
 *  d1.e
 *  d1.l
 *  h1.o
 *  h1.q
 */
package miui.systemui.dynamicisland.window;

import G0.k;
import G0.s;
import K0.d;
import L0.c;
import M0.f;
import M0.l;
import U0.a;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.ViewGroupKt;
import d1.e;
import h1.o;
import h1.q;
import miui.systemui.dynamicisland.window.DynamicIslandWindowView;

@f(c="miui.systemui.dynamicisland.window.DynamicIslandWindowViewController$children$1", f="DynamicIslandWindowViewController.kt", l={171}, m="invokeSuspend")
public static final class DynamicIslandWindowViewController.children.1
extends l
implements U0.o {
    final DynamicIslandWindowView $view;
    private Object L$0;
    int label;

    public DynamicIslandWindowViewController.children.1(DynamicIslandWindowView dynamicIslandWindowView, d d2) {
        this.$view = dynamicIslandWindowView;
        super(2, d2);
    }

    public final d create(Object object, d object2) {
        object2 = new /* invalid duplicate definition of identical inner class */;
        object2.L$0 = object;
        return object2;
    }

    public final Object invoke(q q2, d d2) {
        return (this.create(q2, d2)).invokeSuspend(s.a);
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
            object = (q)this.L$0;
            ViewGroup.OnHierarchyChangeListener onHierarchyChangeListener = new ViewGroup.OnHierarchyChangeListener((q)object, this.$view){
                final q $$this$conflatedCallbackFlow;
                final DynamicIslandWindowView $view;
                {
                    this.$$this$conflatedCallbackFlow = q2;
                    this.$view = dynamicIslandWindowView;
                }

                public void onChildViewAdded(View view, View view2) {
                    this.$$this$conflatedCallbackFlow.i((Object)d1.l.r((e)ViewGroupKt.getChildren((ViewGroup)this.$view)));
                }

                public void onChildViewRemoved(View view, View view2) {
                    this.$$this$conflatedCallbackFlow.i((Object)d1.l.r((e)ViewGroupKt.getChildren((ViewGroup)this.$view)));
                }
            };
            this.$view.setOnHierarchyChangeListener(onHierarchyChangeListener);
            a a2 = new a(this.$view){
                final DynamicIslandWindowView $view;
                {
                    this.$view = dynamicIslandWindowView;
                    super(0);
                }

                public final void invoke() {
                    this.$view.setOnHierarchyChangeListener(null);
                }
            };
            this.label = 1;
            if (o.a((q)object, (a)a2, (d)this) != object2) return s.a;
            return object2;
        }
    }
}
