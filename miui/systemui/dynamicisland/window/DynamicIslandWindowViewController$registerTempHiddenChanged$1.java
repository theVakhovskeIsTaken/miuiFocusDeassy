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
import miui.systemui.dynamicisland.window.DynamicIslandWindowViewController;
import miui.systemui.util.CommonUtils;

@f(c="miui.systemui.dynamicisland.window.DynamicIslandWindowViewController$registerTempHiddenChanged$1", f="DynamicIslandWindowViewController.kt", l={426}, m="invokeSuspend")
public static final class DynamicIslandWindowViewController.registerTempHiddenChanged.1
extends l
implements o {
    int label;
    final DynamicIslandWindowViewController this$0;

    public DynamicIslandWindowViewController.registerTempHiddenChanged.1(DynamicIslandWindowViewController dynamicIslandWindowViewController, d d2) {
        this.this$0 = dynamicIslandWindowViewController;
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
            I i2 = this.this$0.getWindowState().getLockScreenControlCenterCollapse();
            g2 = new g(this.this$0){
                final DynamicIslandWindowViewController this$0;
                {
                    this.this$0 = dynamicIslandWindowViewController;
                }

                public final Object emit(boolean bl, d object) {
                    object = new StringBuilder();
                    ((StringBuilder)object).append("lockScreenControlCenterCollapse:");
                    ((StringBuilder)object).append(bl);
                    Log.e((String)"DynamicIslandWindowViewController", (String)((StringBuilder)object).toString());
                    if (CommonUtils.INSTANCE.getIS_TABLET() && bl) {
                        DynamicIslandWindowViewController.access$getView(this.this$0).onIslandTempHide(true, this.this$0.getWindowState().getTempHiddenType());
                    }
                    return s.a;
                }
            };
            this.label = 1;
            if (i2.collect(g2, (d)this) == object) {
                return object;
            }
        }
        throw new G0.c();
    }
}
