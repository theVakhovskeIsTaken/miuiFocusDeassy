/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  H0.i
 *  android.content.Context
 *  android.os.Build
 *  android.util.Log
 *  kotlin.jvm.internal.o
 */
package miui.systemui.dynamicisland;

import H0.i;
import android.content.Context;
import android.os.Build;
import android.util.Log;
import kotlin.jvm.internal.o;
import miui.systemui.dynamicisland.dagger.DynamicIslandScope;

@DynamicIslandScope
public final class DynamicIslandDevicesUtils {
    private final String TAG;
    private final Context context;

    public DynamicIslandDevicesUtils(Context context) {
        o.g((Object)context, (String)"context");
        this.context = context;
        this.TAG = "DynamicIslandDevicesUtils";
    }

    public final boolean isNotchScreenDevice() {
        String string = Build.DEVICE;
        Object[] objectArray = this.TAG;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("currentDevice: ");
        stringBuilder.append(string);
        Log.d((String)objectArray, (String)stringBuilder.toString());
        objectArray = this.context.getResources();
        int n = objectArray.getIdentifier("notch_screen_devices", "array", this.context.getPackageName());
        if (n == 0) {
            Log.w((String)this.TAG, (String)"notch_screen_devices array not found");
            return false;
        }
        objectArray = objectArray.getStringArray(n);
        o.d((Object)objectArray);
        return i.w((Object[])objectArray, (Object)string);
    }

    public final boolean isRealCutoutHeightDevice() {
        String string = Build.DEVICE;
        Object[] objectArray = this.context.getResources();
        int n = objectArray.getIdentifier("real_cutout_height_devices", "array", this.context.getPackageName());
        if (n == 0) {
            Log.w((String)this.TAG, (String)"real_cutout_height_devices array not found");
            return false;
        }
        objectArray = objectArray.getStringArray(n);
        o.d((Object)objectArray);
        return i.w((Object[])objectArray, (Object)string);
    }
}
