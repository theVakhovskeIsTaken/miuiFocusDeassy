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
 *  f1.E
 *  kotlin.jvm.internal.o
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
import f1.E;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.jvm.internal.o;
import miui.systemui.dynamicisland.DynamicIslandBackgroundView;
import miui.systemui.dynamicisland.window.DynamicIslandWindowViewController;
import miui.systemui.dynamicisland.window.content.DynamicIslandBaseContentView;
import miui.systemui.dynamicisland.window.content.DynamicIslandContentView;

@f(c="miui.systemui.dynamicisland.window.DynamicIslandWindowViewController$sendWindowAnimEventForLinkage$16", f="DynamicIslandWindowViewController.kt", l={}, m="invokeSuspend")
public static final class DynamicIslandWindowViewController.sendWindowAnimEventForLinkage.16
extends l
implements U0.o {
    final boolean $isFreeform;
    final String $pkg;
    int label;
    final DynamicIslandWindowViewController this$0;

    public DynamicIslandWindowViewController.sendWindowAnimEventForLinkage.16(DynamicIslandWindowViewController dynamicIslandWindowViewController, String string, boolean bl, d d2) {
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
            if (!o.c((Object)this.this$0.fullScreenPkg.getValue(), (Object)this.$pkg)) {
                object = this.$pkg;
                object = object != null ? DynamicIslandWindowViewController.access$getView(this.this$0).getCurrentMiniWindowState((String)object) : null;
                this.this$0.cancelDelayOperate(this.$pkg);
                if (object != null) {
                    DynamicIslandWindowViewController dynamicIslandWindowViewController = this.this$0;
                    String string = this.$pkg;
                    boolean bl = this.$isFreeform;
                    Iterator iterator = object.iterator();
                    while (iterator.hasNext()) {
                        DynamicIslandContentView dynamicIslandContentView = (DynamicIslandContentView)((Object)iterator.next());
                        ArrayList arrayList = dynamicIslandWindowViewController.pinOperateList;
                        object = dynamicIslandContentView.getCurrentIslandData();
                        object = object != null ? object.getKey() : null;
                        if (!u.F((Iterable)arrayList, (Object)object) && (object = dynamicIslandContentView.getCurrentIslandData()) != null && (object = object.getKey()) != null) {
                            b.a((boolean)dynamicIslandWindowViewController.pinOperateList.add(object));
                        }
                        dynamicIslandWindowViewController.getAppCloseRealIslandRect(DynamicIslandWindowViewController.access$getView(dynamicIslandWindowViewController).calculateCollapse(dynamicIslandContentView), dynamicIslandContentView, string, bl);
                        DynamicIslandWindowViewController.access$getView(dynamicIslandWindowViewController).exitMiniWindow(dynamicIslandContentView);
                        object = dynamicIslandContentView.getFakeView();
                        if (object != null) {
                            ((DynamicIslandBaseContentView)((Object)object)).setOpenAppFromIsland(false);
                        }
                        dynamicIslandContentView.setVisibility(0);
                        object = dynamicIslandContentView.getBackgroundView();
                        if (object == null) continue;
                        ((DynamicIslandBackgroundView)((Object)object)).setVisibility(0);
                    }
                }
            }
            return s.a;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
