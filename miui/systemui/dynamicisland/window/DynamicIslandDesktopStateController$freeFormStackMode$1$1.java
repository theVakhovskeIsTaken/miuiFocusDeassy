/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  U0.a
 *  kotlin.jvm.internal.p
 *  miui.app.IFreeformCallback
 *  miui.app.MiuiFreeFormManager
 */
package miui.systemui.dynamicisland.window;

import U0.a;
import kotlin.jvm.internal.p;
import miui.app.IFreeformCallback;
import miui.app.MiuiFreeFormManager;
import miui.systemui.dynamicisland.window.DynamicIslandDesktopStateController;

public static final class DynamicIslandDesktopStateController.freeFormStackMode.1
extends p
implements a {
    final DynamicIslandDesktopStateController.freeFormStackMode.callback.1 $callback;

    public DynamicIslandDesktopStateController.freeFormStackMode.1(DynamicIslandDesktopStateController.freeFormStackMode.callback.1 var1_1) {
        this.$callback = var1_1;
        super(0);
    }

    public final void invoke() {
        MiuiFreeFormManager.unregisterFreeformCallback((IFreeformCallback)this.$callback);
    }
}
