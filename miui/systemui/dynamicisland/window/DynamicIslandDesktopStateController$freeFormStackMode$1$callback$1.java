/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  U0.o
 *  f1.E
 *  f1.f
 *  h1.q
 *  kotlin.jvm.internal.o
 *  miui.app.IFreeformCallback$Stub
 *  miui.app.MiuiFreeFormManager$MiuiFreeFormStackInfo
 *  miui.systemui.dynamicisland.window.DynamicIslandDesktopStateController$freeFormStackMode$1$callback$1$dispatchFreeFormStackModeChanged$1
 *  miui.systemui.util.CommonUtils
 */
package miui.systemui.dynamicisland.window;

import f1.E;
import f1.f;
import h1.q;
import kotlin.jvm.internal.o;
import miui.app.IFreeformCallback;
import miui.app.MiuiFreeFormManager;
import miui.systemui.dynamicisland.window.DynamicIslandDesktopStateController;
import miui.systemui.util.CommonUtils;

public static final class DynamicIslandDesktopStateController.freeFormStackMode.1.callback.1
extends IFreeformCallback.Stub {
    final q $$this$conflatedCallbackFlow;
    final DynamicIslandDesktopStateController this$0;

    public DynamicIslandDesktopStateController.freeFormStackMode.1.callback.1(q q2, DynamicIslandDesktopStateController dynamicIslandDesktopStateController) {
        this.$$this$conflatedCallbackFlow = q2;
        this.this$0 = dynamicIslandDesktopStateController;
    }

    public void dispatchFreeFormStackModeChanged(int n, MiuiFreeFormManager.MiuiFreeFormStackInfo miuiFreeFormStackInfo) {
        o.g((Object)miuiFreeFormStackInfo, (String)"stackInfo");
        this.$$this$conflatedCallbackFlow.i((Object)n);
        if (n != 2 && n != 4) {
            boolean bl = CommonUtils.INSTANCE.getIS_TABLET() && n == this.this$0.ACTION_FREEFORM_TO_FULLSCREEN;
            f.b((E)this.this$0.scope, null, null, (U0.o)new dispatchFreeFormStackModeChanged.1(this.this$0, miuiFreeFormStackInfo, bl, null), (int)3, null);
        }
    }
}
