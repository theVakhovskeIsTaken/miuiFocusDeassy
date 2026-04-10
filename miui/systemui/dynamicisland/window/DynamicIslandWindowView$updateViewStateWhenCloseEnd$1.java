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
 */
package miui.systemui.dynamicisland.window;

import G0.k;
import G0.s;
import K0.d;
import L0.c;
import M0.f;
import M0.l;
import U0.o;
import f1.E;
import miui.systemui.dynamicisland.window.content.DynamicIslandBaseContentView;
import miui.systemui.dynamicisland.window.content.DynamicIslandContentFakeView;
import miui.systemui.dynamicisland.window.content.DynamicIslandContentView;

@f(c="miui.systemui.dynamicisland.window.DynamicIslandWindowView$updateViewStateWhenCloseEnd$1", f="DynamicIslandWindowView.kt", l={}, m="invokeSuspend")
public static final class DynamicIslandWindowView.updateViewStateWhenCloseEnd.1
extends l
implements o {
    final String $from;
    final boolean $isFreeform;
    final DynamicIslandContentView $state;
    int label;

    public DynamicIslandWindowView.updateViewStateWhenCloseEnd.1(DynamicIslandContentView dynamicIslandContentView, boolean bl, String string, d d2) {
        this.$state = dynamicIslandContentView;
        this.$isFreeform = bl;
        this.$from = string;
        super(2, d2);
    }

    public final d create(Object object, d d2) {
        return new /* invalid duplicate definition of identical inner class */;
    }

    public final Object invoke(E e, d d2) {
        return (this.create(e, d2)).invokeSuspend(s.a);
    }

    public final Object invokeSuspend(Object object) {
        c.c();
        if (this.label == 0) {
            k.b((Object)object);
            object = this.$state;
            if (object != null) {
                ((DynamicIslandContentView)((Object)object)).updateViewStateWhenCloseEnd();
            }
            if ((object = this.$state) != null && (object = ((DynamicIslandBaseContentView)((Object)object)).getFakeView()) != null) {
                ((DynamicIslandContentFakeView)((Object)object)).updateViewStateWhenCloseEnd(this.$isFreeform, this.$from);
            }
            return s.a;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
