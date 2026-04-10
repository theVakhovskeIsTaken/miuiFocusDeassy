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
import miui.systemui.dynamicisland.view.DynamicIslandBigIslandView;
import miui.systemui.dynamicisland.window.content.DynamicIslandContentView;

public static final class DynamicIslandContentView.inheritWidth.3
extends p
implements a {
    final DynamicIslandContentView this$0;

    public DynamicIslandContentView.inheritWidth.3(DynamicIslandContentView dynamicIslandContentView) {
        this.this$0 = dynamicIslandContentView;
        super(0);
    }

    public final FrameLayout invoke() {
        DynamicIslandBigIslandView dynamicIslandBigIslandView = this.this$0.getBigIslandView();
        dynamicIslandBigIslandView = dynamicIslandBigIslandView != null ? (FrameLayout)dynamicIslandBigIslandView.findViewById(R.id.area_left) : null;
        return dynamicIslandBigIslandView;
    }
}
