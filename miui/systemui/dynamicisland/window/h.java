/*
 * Decompiled with CFR 0.152.
 */
package miui.systemui.dynamicisland.window;

import miui.systemui.dynamicisland.window.DynamicIslandSafeguardsController;

public final class h
implements Runnable {
    public final DynamicIslandSafeguardsController a;

    public /* synthetic */ h(DynamicIslandSafeguardsController dynamicIslandSafeguardsController) {
        this.a = dynamicIslandSafeguardsController;
    }

    @Override
    public final void run() {
        DynamicIslandSafeguardsController.g(this.a);
    }
}
