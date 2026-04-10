/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  G0.s
 *  K0.d
 *  android.graphics.Region
 *  android.os.Bundle
 *  android.os.Parcelable
 *  android.util.Log
 *  i1.g
 */
package miui.systemui.dynamicisland.window;

import G0.s;
import K0.d;
import android.graphics.Region;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import i1.g;
import miui.systemui.dynamicisland.window.DynamicIslandWindowView;

public static final class DynamicIslandWindowView.initEventCoordinator.1<T>
implements g {
    final DynamicIslandWindowView this$0;

    public DynamicIslandWindowView.initEventCoordinator.1(DynamicIslandWindowView dynamicIslandWindowView) {
        this.this$0 = dynamicIslandWindowView;
    }

    public final Object emit(Region region, d object) {
        boolean bl = this.this$0.getWindowViewController().getWindowState().isToScreenLockNoAnimation();
        object = new StringBuilder();
        ((StringBuilder)object).append("islandRegion ");
        ((StringBuilder)object).append(region);
        ((StringBuilder)object).append(" ");
        ((StringBuilder)object).append(bl);
        Log.e((String)"DynamicIslandWindowViewImpl", (String)((StringBuilder)object).toString());
        object = new Bundle();
        object.putString("action_key", "action_back_island_width_changed");
        object.putBoolean("extra_back_change_island_region_no_anim", bl);
        object.putParcelable("extra_back_island_region", (Parcelable)region);
        region = this.this$0.listener;
        if (region != null) {
            region.onIslandViewChanged((Bundle)object);
        }
        return s.a;
    }
}
