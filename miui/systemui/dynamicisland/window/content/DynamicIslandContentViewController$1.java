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
 *  U0.p
 *  android.view.View
 *  f1.E
 */
package miui.systemui.dynamicisland.window.content;

import G0.k;
import G0.s;
import K0.d;
import L0.c;
import M0.f;
import M0.l;
import U0.p;
import android.view.View;
import f1.E;
import miui.systemui.dynamicisland.window.content.DynamicIslandBaseContentView;
import miui.systemui.dynamicisland.window.content.DynamicIslandContentView;
import miui.systemui.dynamicisland.window.content.DynamicIslandContentViewController;
import miui.systemui.dynamicisland.window.content.ui.viewbinder.DynamicIslandContentViewBinder;

@f(c="miui.systemui.dynamicisland.window.content.DynamicIslandContentViewController$1", f="DynamicIslandContentViewController.kt", l={}, m="invokeSuspend")
public static final class DynamicIslandContentViewController.1
extends l
implements p {
    final DynamicIslandContentView $view;
    private Object L$0;
    int label;
    final DynamicIslandContentViewController this$0;

    public DynamicIslandContentViewController.1(DynamicIslandContentViewController dynamicIslandContentViewController, DynamicIslandContentView dynamicIslandContentView, d d2) {
        this.this$0 = dynamicIslandContentViewController;
        this.$view = dynamicIslandContentView;
        super(3, d2);
    }

    public final Object invoke(E e, View object, d d2) {
        object = new /* invalid duplicate definition of identical inner class */;
        object.L$0 = e;
        return object.invokeSuspend(s.a);
    }

    public final Object invokeSuspend(Object object) {
        c.c();
        if (this.label == 0) {
            k.b((Object)object);
            E e = (E)this.L$0;
            this.this$0.listenForPressed(e);
            DynamicIslandContentViewBinder dynamicIslandContentViewBinder = DynamicIslandContentViewBinder.INSTANCE;
            object = this.$view;
            dynamicIslandContentViewBinder.bind((DynamicIslandContentView)((Object)object), e, ((DynamicIslandBaseContentView)((Object)object)).getViewModel());
            return s.a;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
