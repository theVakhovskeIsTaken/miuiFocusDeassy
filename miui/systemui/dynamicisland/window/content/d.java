/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.MotionEvent
 *  android.view.View
 *  android.view.View$OnHoverListener
 */
package miui.systemui.dynamicisland.window.content;

import android.view.MotionEvent;
import android.view.View;
import miui.systemui.dynamicisland.window.content.DynamicIslandContentView;

public final class d
implements View.OnHoverListener {
    public final DynamicIslandContentView a;

    public /* synthetic */ d(DynamicIslandContentView dynamicIslandContentView) {
        this.a = dynamicIslandContentView;
    }

    public final boolean onHover(View view, MotionEvent motionEvent) {
        return DynamicIslandContentView.a(this.a, view, motionEvent);
    }
}
