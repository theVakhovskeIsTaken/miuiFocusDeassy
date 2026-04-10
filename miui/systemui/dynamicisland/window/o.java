/*
 * Decompiled with CFR 0.152.
 */
package miui.systemui.dynamicisland.window;

import miui.systemui.dynamicisland.window.DynamicIslandWindowView;
import miui.systemui.dynamicisland.window.content.DynamicIslandBaseContentView;
import miui.systemui.dynamicisland.window.content.DynamicIslandContentView;

public final class o
implements Runnable {
    public final DynamicIslandBaseContentView a;
    public final DynamicIslandContentView b;
    public final float c;

    public /* synthetic */ o(DynamicIslandBaseContentView dynamicIslandBaseContentView, DynamicIslandContentView dynamicIslandContentView, float f) {
        this.a = dynamicIslandBaseContentView;
        this.b = dynamicIslandContentView;
        this.c = f;
    }

    @Override
    public final void run() {
        DynamicIslandWindowView.d(this.a, this.b, this.c);
    }
}
