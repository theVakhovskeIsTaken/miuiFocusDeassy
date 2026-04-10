/*
 * Decompiled with CFR 0.152.
 */
package miui.systemui.dynamicisland.window;

import miui.systemui.dynamicisland.window.DynamicIslandWindowView;

public final class l
implements Runnable {
    public final DynamicIslandWindowView a;

    public /* synthetic */ l(DynamicIslandWindowView dynamicIslandWindowView) {
        this.a = dynamicIslandWindowView;
    }

    @Override
    public final void run() {
        DynamicIslandWindowView.a(this.a);
    }
}
