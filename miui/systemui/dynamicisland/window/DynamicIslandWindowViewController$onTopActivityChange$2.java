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
import miui.systemui.dynamicisland.window.DynamicIslandSafeguardsController;
import miui.systemui.dynamicisland.window.DynamicIslandWindowViewController;

@f(c="miui.systemui.dynamicisland.window.DynamicIslandWindowViewController$onTopActivityChange$2", f="DynamicIslandWindowViewController.kt", l={}, m="invokeSuspend")
public static final class DynamicIslandWindowViewController.onTopActivityChange.2
extends l
implements o {
    int label;
    final DynamicIslandWindowViewController this$0;

    public DynamicIslandWindowViewController.onTopActivityChange.2(DynamicIslandWindowViewController dynamicIslandWindowViewController, d d2) {
        this.this$0 = dynamicIslandWindowViewController;
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
            object = this.this$0;
            boolean bl = ((DynamicIslandWindowViewController)object).isInMiniWindow(((DynamicIslandWindowViewController)object).getLastTopActivityPkg(), b.c((int)DynamicIslandWindowViewController.access$getView(this.this$0).getCurrentUserId()));
            object = new StringBuilder();
            ((StringBuilder)object).append("isInMiniWindow ");
            ((StringBuilder)object).append(bl);
            Log.d((String)"DynamicIslandWindowViewController", (String)((StringBuilder)object).toString());
            object = this.this$0;
            if (((DynamicIslandWindowViewController)object).needExitMiniWindow(bl, ((DynamicIslandWindowViewController)object).getLastTopActivityPkg())) {
                object = this.this$0;
                ((DynamicIslandWindowViewController)object).calculateAppClosePosition(((DynamicIslandWindowViewController)object).getLastTopActivityPkg(), true);
                object = this.this$0.getLastTopActivityPkg();
                if (object != null) {
                    DynamicIslandSafeguardsController.delayExitMiniWindow$default(this.this$0.getDynamicIslandSafeguardsController(), (String)object, false, 2, null);
                }
            }
            return s.a;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
