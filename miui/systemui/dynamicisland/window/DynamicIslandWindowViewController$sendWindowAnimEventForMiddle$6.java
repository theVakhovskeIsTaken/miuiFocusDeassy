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
import f1.E;
import miui.systemui.dynamicisland.window.DynamicIslandWindowViewController;
import miui.systemui.dynamicisland.window.content.DynamicIslandContentFakeView;
import miui.systemui.dynamicisland.window.content.DynamicIslandContentView;

@f(c="miui.systemui.dynamicisland.window.DynamicIslandWindowViewController$sendWindowAnimEventForMiddle$6", f="DynamicIslandWindowViewController.kt", l={}, m="invokeSuspend")
public static final class DynamicIslandWindowViewController.sendWindowAnimEventForMiddle.6
extends l
implements o {
    final boolean $isFreeform;
    final String $pkg;
    int label;
    final DynamicIslandWindowViewController this$0;

    public DynamicIslandWindowViewController.sendWindowAnimEventForMiddle.6(DynamicIslandWindowViewController dynamicIslandWindowViewController, String string, boolean bl, d d2) {
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
            object = object != null ? DynamicIslandWindowViewController.access$getView(this.this$0).getCurrentMiniWindowState((String)object) : null;
            if (object != null) {
                boolean bl = this.$isFreeform;
                DynamicIslandWindowViewController dynamicIslandWindowViewController = this.this$0;
                for (DynamicIslandContentView dynamicIslandContentView : object) {
                    object = dynamicIslandContentView.getFakeView();
                    if (object != null) {
                        DynamicIslandContentFakeView.updateViewStateWhenCloseEnd$default(object, bl, null, 2, null);
                    }
                    DynamicIslandWindowViewController.access$getView(dynamicIslandWindowViewController).appEnter(dynamicIslandContentView);
                    DynamicIslandWindowViewController.access$getView(dynamicIslandWindowViewController).onWindowAnimExtendLifetimeEnd(dynamicIslandContentView);
                }
            }
            if (this.this$0.hasAppState(null)) {
                this.this$0.getDynamicIslandSafeguardsController().delayExitApp(this.$pkg, true);
            }
            return s.a;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
