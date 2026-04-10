/*
 * Decompiled with CFR 0.152.
 */
package miui.systemui.dynamicisland.window;

import miui.systemui.dynamicisland.window.DynamicIslandSafeguardsController;

public final class d
implements Runnable {
    public final DynamicIslandSafeguardsController a;
    public final String b;

    public /* synthetic */ d(DynamicIslandSafeguardsController dynamicIslandSafeguardsController, String string) {
        this.a = dynamicIslandSafeguardsController;
        this.b = string;
    }

    @Override
    public final void run() {
        DynamicIslandSafeguardsController.b(this.a, this.b);
    }
}
