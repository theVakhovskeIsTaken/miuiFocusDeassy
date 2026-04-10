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
import miui.systemui.dynamicisland.window.content.DynamicIslandContentFakeView;

@f(c="miui.systemui.dynamicisland.window.DynamicIslandWindowView$onConfigChanged$3$1", f="DynamicIslandWindowView.kt", l={237}, m="invokeSuspend")
public static final class DynamicIslandWindowView.onConfigChanged.3.1
extends l
implements o {
    final DynamicIslandContentFakeView $it;
    int label;

    public DynamicIslandWindowView.onConfigChanged.3.1(DynamicIslandContentFakeView dynamicIslandContentFakeView, d d2) {
        this.$it = dynamicIslandContentFakeView;
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
            DynamicIslandContentFakeView dynamicIslandContentFakeView = this.$it;
            object = dynamicIslandContentFakeView.getCurrentIslandData();
            this.label = 1;
            if (dynamicIslandContentFakeView.updateView((DynamicIslandData)object, true, false, (d)this) != object2) return s.a;
            return object2;
        }
    }
}
