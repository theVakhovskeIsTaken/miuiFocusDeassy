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
 *  android.util.Log
 *  f1.E
 *  f1.M
 */
package miui.systemui.dynamicisland.window;

import G0.k;
import G0.s;
import K0.d;
import L0.c;
import M0.b;
import M0.f;
import M0.l;
import U0.o;
import android.util.Log;
import f1.E;
import f1.M;
import miui.systemui.dynamicisland.window.DynamicIslandWindowViewController;

@f(c="miui.systemui.dynamicisland.window.DynamicIslandWindowViewController$controlCenterPanelExpandHeightChanged$1", f="DynamicIslandWindowViewController.kt", l={1377}, m="invokeSuspend")
public static final class DynamicIslandWindowViewController.controlCenterPanelExpandHeightChanged.1
extends l
implements o {
    int label;
    final DynamicIslandWindowViewController this$0;

    public DynamicIslandWindowViewController.controlCenterPanelExpandHeightChanged.1(DynamicIslandWindowViewController dynamicIslandWindowViewController, d d2) {
        this.this$0 = dynamicIslandWindowViewController;
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
        } else {
            k.b((Object)object);
            this.label = 1;
            if (M.b((long)1000L, (d)this) == object2) {
                return object2;
            }
        }
        Log.d((String)"DynamicIslandWindowViewController", (String)"controlCenterPanelExpandHeightChanged Completed");
        this.this$0.getWindowState().getControlCenterPanelHeightChanging().setValue((Object)b.a((boolean)false));
        return s.a;
    }
}
