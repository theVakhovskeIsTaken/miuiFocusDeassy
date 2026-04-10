/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  E0.e
 *  F0.a
 *  android.content.Context
 */
package miui.systemui.dynamicisland;

import E0.e;
import F0.a;
import android.content.Context;
import miui.systemui.dynamicisland.DynamicIslandDevicesUtils;

public final class DynamicIslandDevicesUtils_Factory
implements e {
    private final a contextProvider;

    public DynamicIslandDevicesUtils_Factory(a a2) {
        this.contextProvider = a2;
    }

    public static DynamicIslandDevicesUtils_Factory create(a a2) {
        return new DynamicIslandDevicesUtils_Factory(a2);
    }

    public static DynamicIslandDevicesUtils newInstance(Context context) {
        return new DynamicIslandDevicesUtils(context);
    }

    public DynamicIslandDevicesUtils get() {
        return DynamicIslandDevicesUtils_Factory.newInstance((Context)this.contextProvider.get());
    }
}
