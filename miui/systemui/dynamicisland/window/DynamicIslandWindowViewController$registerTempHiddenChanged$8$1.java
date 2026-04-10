/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  G0.s
 *  K0.d
 *  android.util.Log
 *  i1.g
 */
package miui.systemui.dynamicisland.window;

import G0.s;
import K0.d;
import android.util.Log;
import i1.g;
import miui.systemui.dynamicisland.window.DynamicIslandWindowViewController;

public static final class DynamicIslandWindowViewController.registerTempHiddenChanged.1<T>
implements g {
    final DynamicIslandWindowViewController this$0;

    public DynamicIslandWindowViewController.registerTempHiddenChanged.1(DynamicIslandWindowViewController dynamicIslandWindowViewController) {
        this.this$0 = dynamicIslandWindowViewController;
    }

    public final Object emit(boolean bl, d object) {
        object = this.this$0.getWindowState().getTempHidden().getValue();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("collect isDeviceInteractive:");
        stringBuilder.append(bl);
        stringBuilder.append(", windowState.tempHidden.value=");
        stringBuilder.append(object);
        Log.d((String)"DynamicIslandWindowViewController", (String)stringBuilder.toString());
        object = this.this$0;
        ((DynamicIslandWindowViewController)object).lockScreen((Boolean)((DynamicIslandWindowViewController)object).getWindowState().getScreenLocked().getValue());
        this.this$0.getWindowState().setDeviceInteractive(bl);
        if (bl) {
            this.this$0.dynamicIslandDesktopStateController.getMiniWindowDataRepo().resetData();
        }
        return s.a;
    }
}
