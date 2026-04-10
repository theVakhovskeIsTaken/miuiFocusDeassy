/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  U0.a
 *  android.widget.LinearLayout
 *  kotlin.jvm.internal.p
 */
package miui.systemui.dynamicisland.window.content;

import U0.a;
import android.widget.LinearLayout;
import kotlin.jvm.internal.p;
import miui.systemui.dynamicisland.R;
import miui.systemui.dynamicisland.view.DynamicIslandBigIslandView;
import miui.systemui.dynamicisland.window.content.DynamicIslandContentView;

public static final class DynamicIslandContentView.inheritWidth.1
extends p
implements a {
    final DynamicIslandContentView this$0;

    public DynamicIslandContentView.inheritWidth.1(DynamicIslandContentView dynamicIslandContentView) {
        this.this$0 = dynamicIslandContentView;
        super(0);
    }

    public final LinearLayout invoke() {
        DynamicIslandBigIslandView dynamicIslandBigIslandView = this.this$0.getBigIslandView();
        dynamicIslandBigIslandView = dynamicIslandBigIslandView != null ? (LinearLayout)dynamicIslandBigIslandView.findViewById(R.id.big_container) : null;
        return dynamicIslandBigIslandView;
    }
}
