/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.ViewTreeObserver$OnPreDrawListener
 */
package miui.systemui.dynamicisland.window.content;

import android.view.ViewTreeObserver;
import miui.systemui.dynamicisland.window.content.DynamicIslandContentView;
import miui.systemui.dynamicisland.window.content.DynamicIslandContentViewController;

public static final class DynamicIslandContentView.exposeListener.1
implements ViewTreeObserver.OnPreDrawListener {
    final DynamicIslandContentView this$0;

    public DynamicIslandContentView.exposeListener.1(DynamicIslandContentView dynamicIslandContentView) {
        this.this$0 = dynamicIslandContentView;
    }

    public boolean onPreDraw() {
        ((DynamicIslandContentViewController)this.this$0.getController()).onPreDraw();
        return true;
    }
}
