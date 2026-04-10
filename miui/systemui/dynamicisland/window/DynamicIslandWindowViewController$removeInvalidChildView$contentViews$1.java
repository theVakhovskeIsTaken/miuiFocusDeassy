/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.widget.FrameLayout
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.o
 *  kotlin.jvm.internal.p
 */
package miui.systemui.dynamicisland.window;

import android.view.View;
import android.widget.FrameLayout;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.o;
import kotlin.jvm.internal.p;
import miui.systemui.dynamicisland.DynamicIslandBackgroundView;
import miui.systemui.dynamicisland.window.content.DynamicIslandContentView;

public static final class DynamicIslandWindowViewController.removeInvalidChildView.contentViews.1
extends p
implements Function1 {
    public static final DynamicIslandWindowViewController.removeInvalidChildView.contentViews.1 INSTANCE = new /* invalid duplicate definition of identical inner class */;

    public final DynamicIslandContentView invoke(View object) {
        o.g((Object)object, (String)"children");
        boolean bl = object instanceof DynamicIslandBackgroundView;
        Object var5_3 = null;
        FrameLayout frameLayout = bl ? (DynamicIslandBackgroundView)((Object)object) : null;
        int n = frameLayout != null ? frameLayout.getChildCount() : 0;
        frameLayout = var5_3;
        if (n > 0) {
            object = bl ? (DynamicIslandBackgroundView)((Object)object) : null;
            object = object != null ? object.getChildAt(0) : null;
            frameLayout = var5_3;
            if (object instanceof DynamicIslandContentView) {
                frameLayout = (DynamicIslandContentView)((Object)object);
            }
        }
        return frameLayout;
    }
}
