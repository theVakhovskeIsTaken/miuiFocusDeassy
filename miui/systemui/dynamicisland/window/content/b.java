/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.Choreographer$FrameCallback
 */
package miui.systemui.dynamicisland.window.content;

import android.view.Choreographer;
import miui.systemui.dynamicisland.window.content.DynamicIslandContentFakeView;

public final class b
implements Choreographer.FrameCallback {
    public final DynamicIslandContentFakeView a;

    public /* synthetic */ b(DynamicIslandContentFakeView dynamicIslandContentFakeView) {
        this.a = dynamicIslandContentFakeView;
    }

    public final void doFrame(long l) {
        DynamicIslandContentFakeView.a(this.a, l);
    }
}
