/*
 * Decompiled with CFR 0.152.
 */
package miui.systemui.dynamicisland.window.content;

import miui.systemui.dynamicisland.window.content.DynamicIslandContentFakeView;

public final class a
implements Runnable {
    public final DynamicIslandContentFakeView a;

    public /* synthetic */ a(DynamicIslandContentFakeView dynamicIslandContentFakeView) {
        this.a = dynamicIslandContentFakeView;
    }

    @Override
    public final void run() {
        DynamicIslandContentFakeView.b(this.a);
    }
}
