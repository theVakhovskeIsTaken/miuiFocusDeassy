/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  G0.k
 *  G0.s
 *  H0.u
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
import H0.u;
import K0.d;
import L0.c;
import M0.b;
import M0.f;
import M0.l;
import U0.o;
import android.util.Log;
import f1.E;
import java.util.ArrayList;
import java.util.Iterator;
import miui.systemui.dynamicisland.window.DynamicIslandWindowView;
import miui.systemui.dynamicisland.window.DynamicIslandWindowViewController;
import miui.systemui.dynamicisland.window.content.DynamicIslandContentView;

@f(c="miui.systemui.dynamicisland.window.DynamicIslandWindowViewController$sendWindowAnimEventForLinkage$17", f="DynamicIslandWindowViewController.kt", l={}, m="invokeSuspend")
public static final class DynamicIslandWindowViewController.sendWindowAnimEventForLinkage.17
extends l
implements o {
    final boolean $isFreeform;
    final String $pkg;
    int label;
    final DynamicIslandWindowViewController this$0;

    public DynamicIslandWindowViewController.sendWindowAnimEventForLinkage.17(DynamicIslandWindowViewController dynamicIslandWindowViewController, String string, boolean bl, d d2) {
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

    public final Object invokeSuspend(Object object) {
        c.c();
        if (this.label == 0) {
            k.b((Object)object);
            this.this$0.cancelDelayOperate(this.$pkg);
            object = this.$pkg;
            object = object != null ? DynamicIslandWindowViewController.access$getView(this.this$0).requestHasIsland((String)object) : null;
            if (object != null) {
                DynamicIslandWindowViewController dynamicIslandWindowViewController = this.this$0;
                boolean bl = this.$isFreeform;
                Iterator iterator = object.iterator();
                while (iterator.hasNext()) {
                    DynamicIslandContentView dynamicIslandContentView = (DynamicIslandContentView)((Object)iterator.next());
                    object = new StringBuilder();
                    ((StringBuilder)object).append("freeform_pin_exit state = ");
                    ((StringBuilder)object).append((Object)dynamicIslandContentView);
                    Log.d((String)"DynamicIslandAnimDebug", (String)((StringBuilder)object).toString());
                    ArrayList arrayList = dynamicIslandWindowViewController.pinOperateList;
                    object = dynamicIslandContentView != null && (object = dynamicIslandContentView.getCurrentIslandData()) != null ? object.getKey() : null;
                    if (!u.F((Iterable)arrayList, (Object)object) && dynamicIslandContentView != null && (object = dynamicIslandContentView.getCurrentIslandData()) != null && (object = object.getKey()) != null) {
                        b.a((boolean)dynamicIslandWindowViewController.pinOperateList.add(object));
                    }
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
