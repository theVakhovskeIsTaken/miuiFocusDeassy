/*
 * Decompiled with CFR 0.152.
 */
package miui.systemui.dynamicisland.window;

import java.util.function.Consumer;
import miui.systemui.dynamicisland.window.DynamicIslandWindowViewController;

public final class q
implements Consumer {
    public final DynamicIslandWindowViewController a;

    public /* synthetic */ q(DynamicIslandWindowViewController dynamicIslandWindowViewController) {
        this.a = dynamicIslandWindowViewController;
    }

    public final void accept(Object object) {
        DynamicIslandWindowViewController.a(this.a, (Boolean)object);
    }
}
