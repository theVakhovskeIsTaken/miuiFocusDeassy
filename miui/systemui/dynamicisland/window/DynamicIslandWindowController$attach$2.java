/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.p
 */
package miui.systemui.dynamicisland.window;

import android.view.View;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.p;
import miui.systemui.dynamicisland.window.DynamicIslandWindowController;

public static final class DynamicIslandWindowController.attach.2
extends p
implements Function1 {
    final DynamicIslandWindowController this$0;

    public DynamicIslandWindowController.attach.2(DynamicIslandWindowController dynamicIslandWindowController) {
        this.this$0 = dynamicIslandWindowController;
        super(1);
    }

    public final void invoke(Throwable throwable) {
        this.this$0.windowManager.removeView((View)this.this$0.windowView);
    }
}
