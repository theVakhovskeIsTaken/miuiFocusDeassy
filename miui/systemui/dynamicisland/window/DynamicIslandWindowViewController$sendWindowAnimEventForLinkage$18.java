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
import miui.systemui.dynamicisland.window.DynamicIslandWindowView;
import miui.systemui.dynamicisland.window.DynamicIslandWindowViewController;
import miui.systemui.dynamicisland.window.content.DynamicIslandContentView;

@f(c="miui.systemui.dynamicisland.window.DynamicIslandWindowViewController$sendWindowAnimEventForLinkage$18", f="DynamicIslandWindowViewController.kt", l={}, m="invokeSuspend")
public static final class DynamicIslandWindowViewController.sendWindowAnimEventForLinkage.18
extends l
implements o {
    final boolean $isFreeform;
    final String $pkg;
    int label;
    final DynamicIslandWindowViewController this$0;

    public DynamicIslandWindowViewController.sendWindowAnimEventForLinkage.18(DynamicIslandWindowViewController dynamicIslandWindowViewController, String string, boolean bl, d d2) {
        this.this$0 = dynamicIslandWindowViewController;
        this.$pkg = string;
        this.$isFreeform = bl;
        super(2, d2);
    }

    public final d create(Object object, d d2) {
        return new /* invalid duplicate definition of identical inner class */;
    }

    public final Object invoke(E e, d d2) {
        return (this.create(e, d2)).invokeSuspend(s.a);
    }

    public final Object invokeSuspend(Object list) {
        c.c();
        if (this.label == 0) {
            k.b((Object)list);
            this.this$0.cancelDelayOperate(this.$pkg);
            list = this.$pkg;
            list = list != null ? DynamicIslandWindowViewController.access$getView(this.this$0).requestHasIsland((String)((Object)list)) : null;
            if (list != null) {
                DynamicIslandWindowViewController dynamicIslandWindowViewController = this.this$0;
                boolean bl = this.$isFreeform;
                for (DynamicIslandContentView dynamicIslandContentView : list) {
                    list = new StringBuilder();
                    ((StringBuilder)((Object)list)).append("fullscreen_to_mini_freeform state = ");
                    ((StringBuilder)((Object)list)).append((Object)dynamicIslandContentView);
                    Log.d((String)"DynamicIslandAnimDebug", (String)((StringBuilder)((Object)list)).toString());
                    DynamicIslandWindowView.updateViewStateWhenCloseEnd$default(DynamicIslandWindowViewController.access$getView(dynamicIslandWindowViewController), dynamicIslandContentView, bl, null, 4, null);
                    DynamicIslandWindowViewController.access$getView(dynamicIslandWindowViewController).enterMiniWindow(dynamicIslandContentView);
                    DynamicIslandWindowViewController.access$getView(dynamicIslandWindowViewController).onWindowAnimExtendLifetimeEnd(dynamicIslandContentView);
                }
            }
            return s.a;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
