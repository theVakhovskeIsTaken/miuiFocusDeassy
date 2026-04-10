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
 *  kotlin.jvm.internal.o
 */
package miui.systemui.dynamicisland.window;

import G0.k;
import G0.s;
import K0.d;
import L0.c;
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

@f(c="miui.systemui.dynamicisland.window.DynamicIslandWindowViewController$sendWindowAnimEventForMiddle$10", f="DynamicIslandWindowViewController.kt", l={}, m="invokeSuspend")
public static final class DynamicIslandWindowViewController.sendWindowAnimEventForMiddle.10
extends l
implements U0.o {
    final String $event;
    final boolean $isFreeform;
    final String $pkg;
    int label;
    final DynamicIslandWindowViewController this$0;

    public DynamicIslandWindowViewController.sendWindowAnimEventForMiddle.10(boolean bl, String string, DynamicIslandWindowViewController dynamicIslandWindowViewController, String string2, d d2) {
        this.$isFreeform = bl;
        this.$pkg = string;
        this.this$0 = dynamicIslandWindowViewController;
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
            k.b((Object)object);
            WindowAnimState.Closed closed = new WindowAnimState.Closed(this.$isFreeform, false, false, 4, null);
            object = this.$pkg;
            object = object != null ? DynamicIslandWindowViewController.access$getView(this.this$0).requestHasIsland((String)object) : null;
            if (object == null || object.isEmpty()) {
                DynamicIslandWindowViewController.access$getView(this.this$0).hideAllElementSurface();
            }
            if (object != null) {
                DynamicIslandWindowViewController dynamicIslandWindowViewController = this.this$0;
                String string = this.$pkg;
                boolean bl = this.$isFreeform;
                String string2 = this.$event;
                Iterator iterator = object.iterator();
                while (iterator.hasNext()) {
                    DynamicIslandContentView dynamicIslandContentView = (DynamicIslandContentView)((Object)iterator.next());
                    object = dynamicIslandContentView != null ? dynamicIslandContentView.getState() : null;
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("sendWindowAnimEventForMiddle: currentState = ");
                    stringBuilder.append(object);
                    Log.d((String)"DynamicIslandAnimDebug", (String)stringBuilder.toString());
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
                    dynamicIslandWindowViewController.getAppCloseRealIslandRect(DynamicIslandWindowViewController.access$getView(dynamicIslandWindowViewController).calculateCollapse(dynamicIslandContentView), dynamicIslandContentView, string, bl);
                    DynamicIslandWindowView.updateViewStateWhenCloseEnd$default(DynamicIslandWindowViewController.access$getView(dynamicIslandWindowViewController), dynamicIslandContentView, bl, null, 4, null);
                    DynamicIslandWindowViewController.access$getView(dynamicIslandWindowViewController).updateIslandWindowAnimRunningState(false, dynamicIslandContentView, bl);
                    DynamicIslandWindowViewController.access$getView(dynamicIslandWindowViewController).onWindowAnimExtendLifetimeEnd(dynamicIslandContentView);
                    if (bl) {
                        DynamicIslandWindowViewController.access$getView(dynamicIslandWindowViewController).exitMiniWindow(dynamicIslandContentView);
                        DynamicIslandWindowViewController.access$getView(dynamicIslandWindowViewController).enterMiniWindowEnd();
                        continue;
                    }
                    if (o.c((Object)string2, (Object)"update_surface_info_finish")) {
                        if (string == null || bl || o.c((Object)dynamicIslandWindowViewController.getTopActivityPkg(), (Object)string) || !dynamicIslandWindowViewController.hasAppState(string)) continue;
                        DynamicIslandSafeguardsController.delayExitApp$default(dynamicIslandWindowViewController.getDynamicIslandSafeguardsController(), dynamicIslandWindowViewController.getTopActivityPkg(), false, 2, null);
                        continue;
                    }
                    DynamicIslandWindowViewController.access$getView(dynamicIslandWindowViewController).appExit(dynamicIslandContentView);
                }
            }
            DynamicIslandWindowViewController.setPositionValue$default(this.this$0, false, false, 2, null);
            return s.a;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
