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
import f1.E;
import java.util.Iterator;
import miui.systemui.dynamicisland.window.DynamicIslandWindowViewController;
import miui.systemui.dynamicisland.window.content.DynamicIslandBaseContentView;
import miui.systemui.dynamicisland.window.content.DynamicIslandContentView;

@f(c="miui.systemui.dynamicisland.window.DynamicIslandWindowViewController$openAppError$1", f="DynamicIslandWindowViewController.kt", l={}, m="invokeSuspend")
public static final class DynamicIslandWindowViewController.openAppError.1
extends l
implements o {
    final boolean $collapse;
    final boolean $freeform;
    final String $pkg;
    int label;
    final DynamicIslandWindowViewController this$0;

    public DynamicIslandWindowViewController.openAppError.1(String string, boolean bl, DynamicIslandWindowViewController dynamicIslandWindowViewController, boolean bl2, d d2) {
        this.$pkg = string;
        this.$collapse = bl;
        this.this$0 = dynamicIslandWindowViewController;
        this.$freeform = bl2;
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
            Object object2;
            k.b((Object)object);
            object = this.$pkg;
            if (object != null && (object2 = DynamicIslandWindowViewController.access$getView(this.this$0).requestHasIsland((String)object)) != null) {
                boolean bl = this.$freeform;
                object = this.this$0;
                Iterator iterator = object2.iterator();
                while (iterator.hasNext()) {
                    object2 = (DynamicIslandContentView)((Object)iterator.next());
                    if (bl) {
                        DynamicIslandWindowViewController.access$getView((DynamicIslandWindowViewController)object).cancelExpandViewTrackingAnim((DynamicIslandContentView)((Object)object2));
                        DynamicIslandWindowViewController.access$getView((DynamicIslandWindowViewController)object).updateViewStateWhenCloseEnd((DynamicIslandContentView)((Object)object2), true, "open_app_error");
                        continue;
                    }
                    if (object2 == null) continue;
                    ((DynamicIslandBaseContentView)((Object)object2)).setOpenAppFromIsland(false);
                }
            }
            if (!((Boolean)(object = b.a((boolean)this.$collapse))).booleanValue()) {
                object = null;
            }
            if (object != null) {
                DynamicIslandWindowViewController.access$getView(this.this$0).collapse("open error");
            }
            return s.a;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
