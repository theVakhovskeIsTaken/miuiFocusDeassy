/*
 * Decompiled with CFR 0.152.
 */
package miui.systemui.dynamicisland.window;

import miui.systemui.dynamicisland.window.DynamicIslandWindowController;

public final class k
implements Runnable {
    public final DynamicIslandWindowController a;

    public /* synthetic */ k(DynamicIslandWindowController dynamicIslandWindowController) {
        this.a = dynamicIslandWindowController;
    }

    @Override
    public final void run() {
        DynamicIslandWindowController.a(this.a);
    }
}
