/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.ViewTreeObserver$OnGlobalLayoutListener
 */
package miui.systemui.dynamicisland.window;

import android.view.ViewTreeObserver;
import miui.systemui.dynamicisland.window.DynamicIslandWindowView;

public final class n
implements ViewTreeObserver.OnGlobalLayoutListener {
    public final DynamicIslandWindowView a;

    public /* synthetic */ n(DynamicIslandWindowView dynamicIslandWindowView) {
        this.a = dynamicIslandWindowView;
    }

    public final void onGlobalLayout() {
        DynamicIslandWindowView.c(this.a);
    }
}
