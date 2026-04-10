/*
 * Decompiled with CFR 0.152.
 */
package miui.systemui.dynamicisland.view;

import miui.systemui.dynamicisland.view.DynamicIslandExpandedView;

public final class b
implements Runnable {
    public final DynamicIslandExpandedView a;
    public final String b;

    public /* synthetic */ b(DynamicIslandExpandedView dynamicIslandExpandedView, String string) {
        this.a = dynamicIslandExpandedView;
        this.b = string;
    }

    @Override
    public final void run() {
        DynamicIslandExpandedView.b(this.a, this.b);
    }
}
