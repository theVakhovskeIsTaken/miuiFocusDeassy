/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.BroadcastReceiver
 *  android.content.Context
 *  android.content.Intent
 *  android.util.Log
 */
package miui.systemui.dynamicisland.window;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import miui.systemui.dynamicisland.window.DynamicIslandDesktopStateController;
import miui.systemui.dynamicisland.window.DynamicIslandWindowState;
import miui.systemui.dynamicisland.window.DynamicIslandWindowView;
import miui.systemui.dynamicisland.window.DynamicIslandWindowViewController;

public static final class DynamicIslandDesktopStateController.desktopReceiver.1
extends BroadcastReceiver {
    final DynamicIslandDesktopStateController this$0;

    public DynamicIslandDesktopStateController.desktopReceiver.1(DynamicIslandDesktopStateController dynamicIslandDesktopStateController) {
        this.this$0 = dynamicIslandDesktopStateController;
    }

    /*
     * Enabled aggressive block sorting
     */
    public void onReceive(Context object, Intent object2) {
        Object object3;
        String string = null;
        String string2 = null;
        if (object != null && ((object3 = (DynamicIslandWindowView)((Object)this.this$0.windowViewWeakReference.get())) == null || (object3 = ((DynamicIslandWindowView)((Object)object3)).getWindowViewController()) == null || (object3 = ((DynamicIslandWindowViewController)object3).getWindowState()) == null || ((DynamicIslandWindowState)object3).isAdaptDesktopAnimation((Context)object))) {
            object = object2 != null ? object2.getStringExtra("state") : null;
            string = this.this$0.TAG;
            if (object2 != null) {
                string2 = object2.getAction();
            }
            object2 = new StringBuilder();
            ((StringBuilder)object2).append("onReceive : ");
            ((StringBuilder)object2).append(string2);
            ((StringBuilder)object2).append(" state : ");
            ((StringBuilder)object2).append((String)object);
            Log.d((String)string, (String)((StringBuilder)object2).toString());
            if (object != null) {
                int n = -1;
                switch (((String)object).hashCode()) {
                    case 1100051139: {
                        if (!((String)object).equals("toCurrentApp")) break;
                        n = 1;
                        break;
                    }
                    case 277236744: {
                        if (!((String)object).equals("closeWindow")) break;
                        n = 2;
                        break;
                    }
                    case -39374310: {
                        if (!((String)object).equals("crossSafeArea")) break;
                        n = 3;
                        break;
                    }
                    case -580919683: {
                        if (!((String)object).equals("toRecents")) break;
                        n = 4;
                        break;
                    }
                    case -869219846: {
                        if (!((String)object).equals("toHome")) break;
                        n = 5;
                        break;
                    }
                    case -1315693975: {
                        if (!((String)object).equals("taskSnapshot")) break;
                        n = 3;
                        break;
                    }
                    case -1546330858: {
                        if (!((String)object).equals("startControlAppWindow")) break;
                        n = 3;
                        break;
                    }
                    case -2115549959: {
                        if (!((String)object).equals("toAnotherApp")) break;
                        n = 6;
                        break;
                    }
                }
                switch (n) {
                    default: {
                        break;
                    }
                    case 1: {
                        this.this$0.runDesktopAnim(false);
                        return;
                    }
                    case 2: {
                        this.this$0.runDesktopAnim(true);
                        this.this$0.runDesktopAnim(false);
                        return;
                    }
                    case 4: {
                        this.this$0.runDesktopAnim(false);
                        return;
                    }
                    case 5: {
                        this.this$0.runDesktopAnim(false);
                        return;
                    }
                    case 3: {
                        this.this$0.runDesktopAnim(true);
                        return;
                    }
                    case 6: {
                        this.this$0.runDesktopAnim(false);
                        return;
                    }
                }
            }
            this.this$0.runDesktopAnim(false);
            return;
        }
        object2 = (DynamicIslandWindowView)((Object)this.this$0.windowViewWeakReference.get());
        object = string;
        if (object2 != null) {
            object2 = ((DynamicIslandWindowView)((Object)object2)).getWindowViewController();
            object = string;
            if (object2 != null) {
                object2 = ((DynamicIslandWindowViewController)object2).getWindowState();
                object = string;
                if (object2 != null) {
                    object = ((DynamicIslandWindowState)object2).getDeskTopAnimating();
                }
            }
        }
        if (object == null) {
            return;
        }
        object.setValue((Object)Boolean.FALSE);
    }
}
