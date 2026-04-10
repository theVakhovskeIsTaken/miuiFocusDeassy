/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  com.android.systemui.plugins.miui.dynamicisland.DynamicIslandData
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.o
 *  kotlin.jvm.internal.p
 */
package miui.systemui.dynamicisland.window;

import android.view.View;
import com.android.systemui.plugins.miui.dynamicisland.DynamicIslandData;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.o;
import kotlin.jvm.internal.p;
import miui.systemui.dynamicisland.window.DynamicIslandWindowView;
import miui.systemui.dynamicisland.window.content.DynamicIslandContentView;

public static final class DynamicIslandWindowView.buildDynamicIslandContentView.2
extends p
implements Function1 {
    final DynamicIslandData $dynamicIslandData;
    final DynamicIslandWindowView this$0;

    public DynamicIslandWindowView.buildDynamicIslandContentView.2(DynamicIslandData dynamicIslandData, DynamicIslandWindowView dynamicIslandWindowView) {
        this.$dynamicIslandData = dynamicIslandData;
        this.this$0 = dynamicIslandWindowView;
        super(1);
    }

    public final Boolean invoke(DynamicIslandContentView dynamicIslandContentView) {
        Object object = dynamicIslandContentView.getCurrentIslandData();
        object = object != null ? object.getKey() : null;
        boolean bl = o.c((Object)object, (Object)this.$dynamicIslandData.getKey());
        if (bl) {
            this.this$0.removeView((View)dynamicIslandContentView.getBackgroundView());
            dynamicIslandContentView.getController().destroy();
        }
        return bl;
    }
}
