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
 *  miui.systemui.animation.FolmeKt
 */
package miui.systemui.dynamicisland;

import G0.k;
import G0.s;
import K0.d;
import L0.c;
import M0.f;
import M0.l;
import U0.o;
import android.view.View;
import f1.E;
import miui.systemui.animation.FolmeKt;
import miui.systemui.dynamicisland.DynamicIslandBackgroundView;

@f(c="miui.systemui.dynamicisland.DynamicIslandBackgroundView$setController$1", f="DynamicIslandBackgroundView.kt", l={}, m="invokeSuspend")
public static final class DynamicIslandBackgroundView.setController.1
extends l
implements o {
    int label;
    final DynamicIslandBackgroundView this$0;

    public DynamicIslandBackgroundView.setController.1(DynamicIslandBackgroundView dynamicIslandBackgroundView, d d2) {
        this.this$0 = dynamicIslandBackgroundView;
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
            FolmeKt.cleanFolmeWhenDetached((View)this.this$0);
            return s.a;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
