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
 *  android.util.Log
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
import android.util.Log;
import f1.E;
import java.util.List;
import miui.systemui.dynamicisland.event.DynamicIslandEventCoordinator;
import miui.systemui.dynamicisland.window.DynamicIslandWindowViewController;
import miui.systemui.dynamicisland.window.content.DynamicIslandContentView;

@f(c="miui.systemui.dynamicisland.window.DynamicIslandWindowViewController$sendWindowAnimEventForLinkage$27", f="DynamicIslandWindowViewController.kt", l={}, m="invokeSuspend")
public static final class DynamicIslandWindowViewController.sendWindowAnimEventForLinkage.27
extends l
implements o {
    final String $pkg;
    int label;
    final DynamicIslandWindowViewController this$0;

    public DynamicIslandWindowViewController.sendWindowAnimEventForLinkage.27(String string, DynamicIslandWindowViewController dynamicIslandWindowViewController, d d2) {
        this.$pkg = string;
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
     * WARNING - void declaration
     */
    public final Object invokeSuspend(Object object2) {
        c.c();
        if (this.label == 0) {
            void var1_5;
            k.b((Object)object2);
            String string = this.$pkg;
            if (string != null) {
                List<DynamicIslandContentView> list = DynamicIslandWindowViewController.access$getView(this.this$0).requestHasIsland(string);
            } else {
                Object var1_4 = null;
            }
            if (var1_5 != null) {
                DynamicIslandWindowViewController dynamicIslandWindowViewController = this.this$0;
                for (DynamicIslandContentView dynamicIslandContentView : var1_5) {
                    Object object = new StringBuilder();
                    ((StringBuilder)object).append("fullscreen_to_pip state = ");
                    ((StringBuilder)object).append((Object)dynamicIslandContentView);
                    Log.d((String)"DynamicIslandAnimDebug", (String)((StringBuilder)object).toString());
                    object = DynamicIslandWindowViewController.access$getView(dynamicIslandWindowViewController).getEventCoordinator();
                    if (object == null) continue;
                    ((DynamicIslandEventCoordinator)object).updateMiniBar(dynamicIslandContentView);
                }
            }
            return s.a;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
