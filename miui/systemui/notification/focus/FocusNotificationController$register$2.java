/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.p
 *  miui.systemui.autodensity.AutoDensityController$OnDensityChangeListener
 */
package miui.systemui.notification.focus;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.p;
import miui.systemui.autodensity.AutoDensityController;
import miui.systemui.notification.focus.FocusNotificationController;

public static final class FocusNotificationController.register.2
extends p
implements Function1 {
    final FocusNotificationController.register.densityChangeListener.1 $densityChangeListener;
    final FocusNotificationController this$0;

    public FocusNotificationController.register.2(FocusNotificationController focusNotificationController, FocusNotificationController.register.densityChangeListener.1 var2_2) {
        this.this$0 = focusNotificationController;
        this.$densityChangeListener = var2_2;
        super(1);
    }

    public final void invoke(Throwable throwable) {
        this.this$0.autoDensityController.removeOnDensityChangeListener((AutoDensityController.OnDensityChangeListener)this.$densityChangeListener);
    }
}
