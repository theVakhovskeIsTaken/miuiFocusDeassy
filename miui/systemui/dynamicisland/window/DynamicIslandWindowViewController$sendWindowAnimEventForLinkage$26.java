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
 *  kotlin.jvm.internal.o
 */
package miui.systemui.dynamicisland.window;

import G0.k;
import G0.s;
import K0.d;
import L0.c;
import M0.b;
import M0.f;
import M0.l;
import android.util.Log;
import f1.E;
import java.util.Iterator;
import kotlin.jvm.internal.o;
import miui.systemui.dynamicisland.DynamicIslandBackgroundView;
import miui.systemui.dynamicisland.event.WindowAnimState;
import miui.systemui.dynamicisland.window.DynamicIslandSafeguardsController;
import miui.systemui.dynamicisland.window.DynamicIslandWindowView;
import miui.systemui.dynamicisland.window.DynamicIslandWindowViewController;
import miui.systemui.dynamicisland.window.content.DynamicIslandContentView;

@f(c="miui.systemui.dynamicisland.window.DynamicIslandWindowViewController$sendWindowAnimEventForLinkage$26", f="DynamicIslandWindowViewController.kt", l={}, m="invokeSuspend")
public static final class DynamicIslandWindowViewController.sendWindowAnimEventForLinkage.26
extends l
implements U0.o {
    final boolean $isFreeform;
    final String $pkg;
    int label;
    final DynamicIslandWindowViewController this$0;

    public DynamicIslandWindowViewController.sendWindowAnimEventForLinkage.26(boolean bl, DynamicIslandWindowViewController dynamicIslandWindowViewController, String string, d d2) {
        this.$isFreeform = bl;
        this.this$0 = dynamicIslandWindowViewController;
        this.$pkg = string;
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
            if (this.$isFreeform) {
                this.this$0.get_isFreeformAnimRunning().setValue((Object)b.a((boolean)false));
            } else {
                this.this$0.get_isAppAnimRunning().setValue((Object)b.a((boolean)false));
            }
            WindowAnimState.Closed closed = new WindowAnimState.Closed(this.$isFreeform, false, false, 4, null);
            object = this.$pkg;
            object = object != null ? DynamicIslandWindowViewController.access$getView(this.this$0).requestHasIsland((String)object) : null;
            if (object == null || object.isEmpty()) {
                DynamicIslandWindowViewController.access$getView(this.this$0).hideAllElementSurface();
            }
            if (object != null) {
                DynamicIslandWindowViewController dynamicIslandWindowViewController = this.this$0;
                boolean bl = this.$isFreeform;
                Iterator iterator = object.iterator();
                while (iterator.hasNext()) {
                    DynamicIslandContentView dynamicIslandContentView = (DynamicIslandContentView)((Object)iterator.next());
                    boolean bl2 = dynamicIslandWindowViewController.shouldDelayExitApp;
                    boolean bl3 = dynamicIslandWindowViewController.requestPositionByClosePosition;
                    object = new StringBuilder();
                    ((StringBuilder)object).append("update_surface_info_finish state = ");
                    ((StringBuilder)object).append((Object)dynamicIslandContentView);
                    ((StringBuilder)object).append(", ");
                    ((StringBuilder)object).append(bl2);
                    ((StringBuilder)object).append(", ");
                    ((StringBuilder)object).append(bl3);
                    Log.d((String)"DynamicIslandAnimDebug", (String)((StringBuilder)object).toString());
                    if (dynamicIslandContentView != null) {
                        dynamicIslandContentView.setWindowAnimState(closed);
                    }
                    if (dynamicIslandContentView != null) {
                        dynamicIslandContentView.setVisibility(0);
                    }
                    object = dynamicIslandContentView != null ? dynamicIslandContentView.getBackgroundView() : null;
                    if (object != null) {
                        ((DynamicIslandBackgroundView)((Object)object)).setVisibility(0);
                    }
                    DynamicIslandWindowView.updateViewStateWhenCloseEnd$default(DynamicIslandWindowViewController.access$getView(dynamicIslandWindowViewController), dynamicIslandContentView, bl, null, 4, null);
                    DynamicIslandWindowViewController.access$getView(dynamicIslandWindowViewController).updateIslandWindowAnimRunningState(false, dynamicIslandContentView, bl);
                    DynamicIslandWindowViewController.access$getView(dynamicIslandWindowViewController).onWindowAnimExtendLifetimeEnd(dynamicIslandContentView);
                    if (dynamicIslandContentView == null) continue;
                    dynamicIslandContentView.setOpenAppFromIsland(false);
                }
            }
            if (this.$pkg != null && !this.$isFreeform && !o.c((Object)this.this$0.getTopActivityPkg(), (Object)this.$pkg) && this.this$0.hasAppState(this.$pkg)) {
                DynamicIslandSafeguardsController.delayExitApp$default(this.this$0.getDynamicIslandSafeguardsController(), this.this$0.getTopActivityPkg(), false, 2, null);
            }
            DynamicIslandWindowViewController.setPositionValue$default(this.this$0, false, false, 2, null);
            DynamicIslandWindowViewController.access$getView(this.this$0).setAnimRunning(false, this.$isFreeform);
            return s.a;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
