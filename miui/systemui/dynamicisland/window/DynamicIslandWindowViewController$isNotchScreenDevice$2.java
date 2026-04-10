/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  U0.a
 *  kotlin.jvm.internal.p
 */
package miui.systemui.dynamicisland.window;

import U0.a;
import kotlin.jvm.internal.p;
import miui.systemui.dynamicisland.window.DynamicIslandWindowViewController;

public static final class DynamicIslandWindowViewController.isNotchScreenDevice.2
extends p
implements a {
    final DynamicIslandWindowViewController this$0;

    public DynamicIslandWindowViewController.isNotchScreenDevice.2(DynamicIslandWindowViewController dynamicIslandWindowViewController) {
        this.this$0 = dynamicIslandWindowViewController;
        super(0);
    }

    public final Boolean invoke() {
        return this.this$0.devicesUtils.isNotchScreenDevice();
    }
}
