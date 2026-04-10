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
 *  com.android.systemui.plugins.miui.dynamicisland.DynamicIslandData
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
import com.android.systemui.plugins.miui.dynamicisland.DynamicIslandData;
import f1.E;
import miui.systemui.dynamicisland.window.DynamicIslandWindowView;

@f(c="miui.systemui.dynamicisland.window.DynamicIslandWindowView$updateDynamicIslandViewSuspend$fakeView$1", f="DynamicIslandWindowView.kt", l={}, m="invokeSuspend")
public static final class DynamicIslandWindowView.updateDynamicIslandViewSuspend.fakeView.1
extends l
implements o {
    final DynamicIslandData $dynamicIslandData;
    int label;
    final DynamicIslandWindowView this$0;

    public DynamicIslandWindowView.updateDynamicIslandViewSuspend.fakeView.1(DynamicIslandWindowView dynamicIslandWindowView, DynamicIslandData dynamicIslandData, d d2) {
        this.this$0 = dynamicIslandWindowView;
        this.$dynamicIslandData = dynamicIslandData;
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
            return this.this$0.inflateDynamicIslandFakeContentView(this.$dynamicIslandData);
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
