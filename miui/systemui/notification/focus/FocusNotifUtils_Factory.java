/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  E0.e
 *  F0.a
 *  com.android.systemui.plugins.miui.settings.SuperSaveModeController
 */
package miui.systemui.notification.focus;

import E0.e;
import F0.a;
import com.android.systemui.plugins.miui.settings.SuperSaveModeController;
import miui.systemui.notification.focus.FocusNotifUtils;

public final class FocusNotifUtils_Factory
implements e {
    private final a superSaveModeControllerProvider;

    public FocusNotifUtils_Factory(a a2) {
        this.superSaveModeControllerProvider = a2;
    }

    public static FocusNotifUtils_Factory create(a a2) {
        return new FocusNotifUtils_Factory(a2);
    }

    public static FocusNotifUtils newInstance(SuperSaveModeController superSaveModeController) {
        return new FocusNotifUtils(superSaveModeController);
    }

    public FocusNotifUtils get() {
        return FocusNotifUtils_Factory.newInstance((SuperSaveModeController)this.superSaveModeControllerProvider.get());
    }
}
