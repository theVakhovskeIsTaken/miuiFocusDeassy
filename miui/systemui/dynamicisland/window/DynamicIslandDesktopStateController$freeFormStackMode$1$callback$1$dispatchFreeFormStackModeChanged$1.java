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
 *  miui.app.MiuiFreeFormManager$MiuiFreeFormStackInfo
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
import miui.app.MiuiFreeFormManager;
import miui.systemui.dynamicisland.window.DynamicIslandDesktopStateController;
import miui.systemui.dynamicisland.window.DynamicMiniWindowDataRepo;

@f(c="miui.systemui.dynamicisland.window.DynamicIslandDesktopStateController$freeFormStackMode$1$callback$1$dispatchFreeFormStackModeChanged$1", f="DynamicIslandDesktopStateController.kt", l={118}, m="invokeSuspend")
public static final class DynamicIslandDesktopStateController.freeFormStackMode.1.callback.1.dispatchFreeFormStackModeChanged.1
extends l
implements o {
    final boolean $forceDelete;
    final MiuiFreeFormManager.MiuiFreeFormStackInfo $stackInfo;
    int label;
    final DynamicIslandDesktopStateController this$0;

    public DynamicIslandDesktopStateController.freeFormStackMode.1.callback.1.dispatchFreeFormStackModeChanged.1(DynamicIslandDesktopStateController dynamicIslandDesktopStateController, MiuiFreeFormManager.MiuiFreeFormStackInfo miuiFreeFormStackInfo, boolean bl, d d2) {
        this.this$0 = dynamicIslandDesktopStateController;
        this.$stackInfo = miuiFreeFormStackInfo;
        this.$forceDelete = bl;
        super(2, d2);
    }

    public final d create(Object object, d d2) {
        return new /* invalid duplicate definition of identical inner class */;
    }

    public final Object invoke(E e, d d2) {
        return (this.create(e, d2)).invokeSuspend(s.a);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public final Object invokeSuspend(Object object) {
        Object object2 = c.c();
        int n = this.label;
        if (n != 0) {
            if (n != 1) throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            k.b((Object)object);
        } else {
            k.b((Object)object);
            DynamicMiniWindowDataRepo dynamicMiniWindowDataRepo = this.this$0.getMiniWindowDataRepo();
            object = this.$stackInfo;
            boolean bl = this.$forceDelete;
            this.label = 1;
            if (dynamicMiniWindowDataRepo.postDataInfo((MiuiFreeFormManager.MiuiFreeFormStackInfo)object, bl, (d)this) == object2) {
                return object2;
            }
        }
        this.this$0.exitFreeFrom(this.$stackInfo, this.$forceDelete);
        return s.a;
    }
}
