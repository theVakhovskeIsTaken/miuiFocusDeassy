/*
 * Decompiled with CFR 0.152.
 */
package miui.systemui.dynamicisland.window;

import miui.systemui.dynamicisland.window.DynamicIslandSafeguardsController;

public final class g
implements Runnable {
    public final String a;
    public final DynamicIslandSafeguardsController b;

    public /* synthetic */ g(String string, DynamicIslandSafeguardsController dynamicIslandSafeguardsController) {
        this.a = string;
        this.b = dynamicIslandSafeguardsController;
    }

    @Override
    public final void run() {
        DynamicIslandSafeguardsController.f(this.a, this.b);
    }
}
