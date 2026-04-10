/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  U0.a
 *  android.widget.FrameLayout
 *  kotlin.jvm.internal.p
 */
package miui.systemui.dynamicisland.window.content;

import U0.a;
import android.widget.FrameLayout;
import kotlin.jvm.internal.p;
import miui.systemui.dynamicisland.R;
import miui.systemui.dynamicisland.window.content.DynamicIslandContentView;

public static final class DynamicIslandContentView.inheritWidth.2
extends p
implements a {
    final DynamicIslandContentView this$0;

    public DynamicIslandContentView.inheritWidth.2(DynamicIslandContentView dynamicIslandContentView) {
        this.this$0 = dynamicIslandContentView;
        super(0);
    }

    public final FrameLayout invoke() {
        Object object = this.this$0.getSmallIslandView();
        object = object != null ? (FrameLayout)object.findViewById(R.id.small_container) : null;
        return object;
    }
}
