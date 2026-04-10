/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.p
 */
package miui.systemui.dynamicisland.window;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.p;
import miui.systemui.dynamicisland.window.AppLockController;

public static final class AppLockController.init.2
extends p
implements Function1 {
    final AppLockController this$0;

    public AppLockController.init.2(AppLockController appLockController) {
        this.this$0 = appLockController;
        super(1);
    }

    public final void invoke(Throwable throwable) {
        this.this$0.close();
        this.this$0.provider.close();
    }
}
