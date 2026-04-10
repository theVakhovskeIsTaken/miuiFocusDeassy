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
 *  kotlin.jvm.internal.o
 */
package miui.systemui.dynamicisland.window;

import G0.k;
import G0.s;
import K0.d;
import L0.c;
import M0.f;
import M0.l;
import f1.E;
import kotlin.jvm.internal.o;
import miui.systemui.dynamicisland.window.DynamicIslandWindowViewController;
import miui.systemui.dynamicisland.window.content.DynamicIslandContentFakeView;
import miui.systemui.dynamicisland.window.content.DynamicIslandContentView;

@f(c="miui.systemui.dynamicisland.window.DynamicIslandWindowViewController$sendWindowAnimEventForLinkage$20", f="DynamicIslandWindowViewController.kt", l={}, m="invokeSuspend")
public static final class DynamicIslandWindowViewController.sendWindowAnimEventForLinkage.20
extends l
implements U0.o {
    final String $event;
    final boolean $isFreeform;
    final String $pkg;
    int label;
    final DynamicIslandWindowViewController this$0;

    public DynamicIslandWindowViewController.sendWindowAnimEventForLinkage.20(DynamicIslandWindowViewController dynamicIslandWindowViewController, String string, boolean bl, String string2, d d2) {
        this.this$0 = dynamicIslandWindowViewController;
        this.$pkg = string;
        this.$isFreeform = bl;
        this.$event = string2;
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
            DynamicIslandWindowViewController dynamicIslandWindowViewController;
            k.b((Object)object);
            this.this$0.cancelDelayOperate(this.$pkg);
            object = this.$pkg;
            object = object != null ? DynamicIslandWindowViewController.access$getView(this.this$0).getCurrentMiniWindowState((String)object) : null;
            if (object != null) {
                boolean bl = this.$isFreeform;
                dynamicIslandWindowViewController = this.this$0;
                object = object.iterator();
                while (object.hasNext()) {
                    DynamicIslandContentView dynamicIslandContentView = (DynamicIslandContentView)((Object)object.next());
                    DynamicIslandContentFakeView dynamicIslandContentFakeView = dynamicIslandContentView.getFakeView();
                    if (dynamicIslandContentFakeView != null) {
                        DynamicIslandContentFakeView.updateViewStateWhenCloseEnd$default(dynamicIslandContentFakeView, bl, null, 2, null);
                    }
                    DynamicIslandWindowViewController.access$getView(dynamicIslandWindowViewController).appEnter(dynamicIslandContentView);
                    DynamicIslandWindowViewController.access$getView(dynamicIslandWindowViewController).onWindowAnimExtendLifetimeEnd(dynamicIslandContentView);
                }
            }
            if ((object = this.$pkg) != null) {
                if (!o.c((Object)this.$event, (Object)"freeform_to_fullscreen")) {
                    object = null;
                }
                if (object != null) {
                    dynamicIslandWindowViewController = this.this$0;
                    dynamicIslandWindowViewController.getDynamicIslandSafeguardsController().setFullScreenPkg((String)object);
                    dynamicIslandWindowViewController.fullScreenPkg.setValue(object);
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
