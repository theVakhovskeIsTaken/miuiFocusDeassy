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
 *  i1.g
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
import i1.g;
import miui.systemui.dynamicisland.window.DynamicIslandWindowViewController;

@f(c="miui.systemui.dynamicisland.window.DynamicIslandWindowViewController$registerTempHiddenChanged$8", f="DynamicIslandWindowViewController.kt", l={477}, m="invokeSuspend")
public static final class DynamicIslandWindowViewController.registerTempHiddenChanged.8
extends l
implements o {
    int label;
    final DynamicIslandWindowViewController this$0;

    public DynamicIslandWindowViewController.registerTempHiddenChanged.8(DynamicIslandWindowViewController dynamicIslandWindowViewController, d d2) {
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
        Object object2 = c.c();
        int n = this.label;
        if (n != 0) {
            if (n != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            k.b((Object)object);
        } else {
            k.b((Object)object);
            object = this.this$0.getExternalStateRepository().isDeviceInteractive();
            g g2 = new g(this.this$0){
                final DynamicIslandWindowViewController this$0;
                {
                    this.this$0 = dynamicIslandWindowViewController;
                }

                public final Object emit(boolean bl, d object) {
                    object = this.this$0.getWindowState().getTempHidden().getValue();
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("collect isDeviceInteractive:");
                    stringBuilder.append(bl);
                    stringBuilder.append(", windowState.tempHidden.value=");
                    stringBuilder.append(object);
                    Log.d((String)"DynamicIslandWindowViewController", (String)stringBuilder.toString());
                    object = this.this$0;
                    DynamicIslandWindowViewController.access$lockScreen((DynamicIslandWindowViewController)object, (Boolean)((DynamicIslandWindowViewController)object).getWindowState().getScreenLocked().getValue());
                    this.this$0.getWindowState().setDeviceInteractive(bl);
                    if (bl) {
                        DynamicIslandWindowViewController.access$getDynamicIslandDesktopStateController$p(this.this$0).getMiniWindowDataRepo().resetData();
                    }
                    return s.a;
                }
            };
            this.label = 1;
            if (object.collect(g2, (d)this) == object2) {
                return object2;
            }
        }
        throw new G0.c();
    }
}
