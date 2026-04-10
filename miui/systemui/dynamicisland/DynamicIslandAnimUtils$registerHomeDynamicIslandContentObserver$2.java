/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.ContentResolver
 *  android.content.Context
 *  android.database.ContentObserver
 *  android.os.Handler
 *  android.provider.MiuiSettings$Global
 *  android.util.Log
 */
package miui.systemui.dynamicisland;

import android.content.ContentResolver;
import android.content.Context;
import android.database.ContentObserver;
import android.os.Handler;
import android.provider.MiuiSettings;
import android.util.Log;
import miui.systemui.dynamicisland.DynamicIslandAnimUtils;

public static final class DynamicIslandAnimUtils.registerHomeDynamicIslandContentObserver.2
extends ContentObserver {
    final Context $context;

    public DynamicIslandAnimUtils.registerHomeDynamicIslandContentObserver.2(Context context, Handler handler) {
        this.$context = context;
        super(handler);
    }

    public void onChange(boolean bl) {
        Object object = DynamicIslandAnimUtils.INSTANCE;
        sHomeSupportedDynamicIslandForMiddle = MiuiSettings.Global.getBoolean((ContentResolver)this.$context.getContentResolver(), (String)"support_dynamic_island_middle");
        bl = sHomeSupportedDynamicIslandForMiddle;
        object = new StringBuilder();
        ((StringBuilder)object).append("onChange: sHomeSupportedDynamicIslandForMiddle: ");
        ((StringBuilder)object).append(bl);
        Log.d((String)"DynamicIslandAnimUtils", (String)((StringBuilder)object).toString());
    }
}
