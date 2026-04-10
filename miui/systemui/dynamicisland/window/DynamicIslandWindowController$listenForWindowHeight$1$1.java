/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  G0.s
 *  K0.d
 *  android.util.Log
 *  i1.g
 *  miui.systemui.util.CommonUtils
 */
package miui.systemui.dynamicisland.window;

import G0.s;
import K0.d;
import android.util.Log;
import i1.g;
import miui.systemui.dynamicisland.window.DynamicIslandWindowController;
import miui.systemui.util.CommonUtils;

public static final class DynamicIslandWindowController.listenForWindowHeight.1<T>
implements g {
    final DynamicIslandWindowController this$0;

    public DynamicIslandWindowController.listenForWindowHeight.1(DynamicIslandWindowController dynamicIslandWindowController) {
        this.this$0 = dynamicIslandWindowController;
    }

    public final Object emit(int n, d object) {
        object = new StringBuilder();
        ((StringBuilder)object).append("update window height ");
        ((StringBuilder)object).append(n);
        Log.d((String)"DynamicIslandWindowController", (String)((StringBuilder)object).toString());
        if (CommonUtils.INSTANCE.getIS_TABLET() && ((Boolean)this.this$0.dynamicIslandWindowState.getNotificationPanelSwipeToAppearance().getValue()).booleanValue() && ((Boolean)this.this$0.dynamicIslandWindowState.getControlCenterPanelSwipeToAppearance().getValue()).booleanValue()) {
            ((DynamicIslandWindowController)this.this$0).lpChanged.height = 0;
        } else {
            ((DynamicIslandWindowController)this.this$0).lpChanged.height = n;
            this.this$0.apply();
        }
        return s.a;
    }
}
