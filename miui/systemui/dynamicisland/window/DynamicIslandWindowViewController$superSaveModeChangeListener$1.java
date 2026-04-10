/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.android.systemui.plugins.miui.settings.SuperSaveModeController$SuperSaveModeChangeListener
 */
package miui.systemui.dynamicisland.window;

import com.android.systemui.plugins.miui.settings.SuperSaveModeController;
import miui.systemui.dynamicisland.window.DynamicIslandWindowViewController;

public static final class DynamicIslandWindowViewController.superSaveModeChangeListener.1
implements SuperSaveModeController.SuperSaveModeChangeListener {
    final DynamicIslandWindowViewController this$0;

    public DynamicIslandWindowViewController.superSaveModeChangeListener.1(DynamicIslandWindowViewController dynamicIslandWindowViewController) {
        this.this$0 = dynamicIslandWindowViewController;
    }

    public void onSuperSaveModeChange(boolean bl) {
        this.this$0.getWindowState().isSuperSaveMode().setValue((Object)bl);
    }
}
