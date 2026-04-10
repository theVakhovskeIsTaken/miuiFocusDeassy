/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  G0.c
 *  G0.k
 *  G0.s
 *  K0.d
 *  L0.c
 *  M0.f
 *  M0.l
 *  U0.o
 *  android.util.Log
 *  f1.E
 *  i1.I
 *  i1.g
 *  miui.systemui.util.CommonUtils
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
import i1.I;
import i1.g;
import miui.systemui.dynamicisland.window.DynamicIslandWindowController;
import miui.systemui.util.CommonUtils;

@f(c="miui.systemui.dynamicisland.window.DynamicIslandWindowController$listenForVisibility$1", f="DynamicIslandWindowController.kt", l={98}, m="invokeSuspend")
public static final class DynamicIslandWindowController.listenForVisibility.1
extends l
implements o {
    int label;
    final DynamicIslandWindowController this$0;

    public DynamicIslandWindowController.listenForVisibility.1(DynamicIslandWindowController dynamicIslandWindowController, d d2) {
        this.this$0 = dynamicIslandWindowController;
        super(2, d2);
    }

    public final d create(Object object, d d2) {
        return new /* invalid duplicate definition of identical inner class */;
    }

    public final Object invoke(E e, d d2) {
        return (this.create(e, d2)).invokeSuspend(s.a);
    }

    public final Object invokeSuspend(Object g2) {
        Object object = c.c();
        int n = this.label;
        if (n != 0) {
            if (n != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            k.b((Object)g2);
        } else {
            k.b((Object)g2);
            I i = this.this$0.windowStateInteractor.getVisibility();
            g2 = new g(this.this$0){
                final DynamicIslandWindowController this$0;
                {
                    this.this$0 = dynamicIslandWindowController;
                }

                public final Object emit(int n, d object) {
                    object = new StringBuilder();
                    ((StringBuilder)object).append("update window Visibility ");
                    ((StringBuilder)object).append(n);
                    Log.d((String)"DynamicIslandWindowController", (String)((StringBuilder)object).toString());
                    if (CommonUtils.INSTANCE.getIS_TABLET() && ((Boolean)DynamicIslandWindowController.access$getDynamicIslandWindowState$p(this.this$0).getNotificationPanelSwipeToAppearance().getValue()).booleanValue() && ((Boolean)DynamicIslandWindowController.access$getDynamicIslandWindowState$p(this.this$0).getControlCenterPanelSwipeToAppearance().getValue()).booleanValue()) {
                        DynamicIslandWindowController.access$getWindowView$p(this.this$0).setVisibility(4);
                    } else {
                        DynamicIslandWindowController.access$getWindowView$p(this.this$0).setVisibility(n);
                    }
                    return s.a;
                }
            };
            this.label = 1;
            if (i.collect(g2, (d)this) == object) {
                return object;
            }
        }
        throw new G0.c();
    }
}
