/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.ContentResolver
 *  android.database.ContentObserver
 *  android.os.Handler
 *  android.provider.Settings$Secure
 *  android.util.Log
 */
package miui.systemui.dynamicisland.window;

import android.content.ContentResolver;
import android.database.ContentObserver;
import android.os.Handler;
import android.provider.Settings;
import android.util.Log;
import miui.systemui.dynamicisland.window.DynamicIslandWindowViewController;

public static final class DynamicIslandWindowViewController.settingsObserver.1
extends ContentObserver {
    final DynamicIslandWindowViewController this$0;

    public DynamicIslandWindowViewController.settingsObserver.1(DynamicIslandWindowViewController dynamicIslandWindowViewController, Handler handler) {
        this.this$0 = dynamicIslandWindowViewController;
        super(handler);
    }

    public void onChange(boolean bl) {
        if (bl) {
            return;
        }
        Object object = this.this$0.contentResolver;
        boolean bl2 = false;
        bl = Settings.Secure.getInt((ContentResolver)object, (String)"full_screen_aod_on", (int)0) == 1;
        if (Settings.Secure.getInt((ContentResolver)this.this$0.contentResolver, (String)"doze_always_on", (int)0) == 1) {
            bl2 = true;
        }
        this.this$0.isFullAodOn = bl;
        this.this$0.isAodOn = bl2;
        bl = this.this$0.isFullAodOn;
        bl2 = this.this$0.isAodOn;
        object = new StringBuilder();
        ((StringBuilder)object).append("isFullAodOn: ");
        ((StringBuilder)object).append(bl);
        ((StringBuilder)object).append(" isAodOn: ");
        ((StringBuilder)object).append(bl2);
        Log.d((String)"DynamicIslandWindowViewController", (String)((StringBuilder)object).toString());
    }
}
