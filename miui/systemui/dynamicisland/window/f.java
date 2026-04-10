/*
 * Decompiled with CFR 0.152.
 */
package miui.systemui.dynamicisland.window;

import miui.systemui.dynamicisland.window.DynamicIslandSafeguardsController;

public final class f
implements Runnable {
    public final DynamicIslandSafeguardsController a;

    public /* synthetic */ f(DynamicIslandSafeguardsController dynamicIslandSafeguardsController) {
        this.a = dynamicIslandSafeguardsController;
    }

    @Override
    public final void run() {
        DynamicIslandSafeguardsController.a(this.a);
    }
}
