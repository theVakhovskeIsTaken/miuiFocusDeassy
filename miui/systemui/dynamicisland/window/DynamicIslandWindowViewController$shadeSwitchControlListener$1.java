/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.util.Log
 *  com.android.systemui.plugins.miui.shade.ShadeSwitchController$OnShadeSwitchChangedListener
 *  miui.systemui.util.CommonUtils
 */
package miui.systemui.dynamicisland.window;

import android.util.Log;
import com.android.systemui.plugins.miui.shade.ShadeSwitchController;
import miui.systemui.dynamicisland.window.DynamicIslandWindowView;
import miui.systemui.dynamicisland.window.DynamicIslandWindowViewController;
import miui.systemui.util.CommonUtils;

public static final class DynamicIslandWindowViewController.shadeSwitchControlListener.1
implements ShadeSwitchController.OnShadeSwitchChangedListener {
    final DynamicIslandWindowView $view;
    final DynamicIslandWindowViewController this$0;

    public DynamicIslandWindowViewController.shadeSwitchControlListener.1(DynamicIslandWindowView dynamicIslandWindowView, DynamicIslandWindowViewController dynamicIslandWindowViewController) {
        this.$view = dynamicIslandWindowView;
        this.this$0 = dynamicIslandWindowViewController;
    }

    public void onSwitchingChanged(boolean bl) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("shade controlCenter switching changed to ");
        stringBuilder.append(bl);
        Log.d((String)"DynamicIslandWindowViewController", (String)stringBuilder.toString());
        if (CommonUtils.INSTANCE.getIS_TABLET() && bl) {
            this.$view.onIslandTempHide(true, this.this$0.getWindowState().getTempHiddenType());
        }
    }
}
