/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  D0.a
 *  E0.d
 *  E0.e
 *  F0.a
 *  android.content.Context
 *  android.os.Handler
 *  f1.E
 *  miui.systemui.autodensity.AutoDensityController
 *  miui.systemui.notification.NotificationSettingsManager
 */
package miui.systemui.notification.focus;

import D0.a;
import E0.d;
import E0.e;
import android.content.Context;
import android.os.Handler;
import f1.E;
import miui.systemui.autodensity.AutoDensityController;
import miui.systemui.notification.NotificationSettingsManager;
import miui.systemui.notification.focus.FocusNotifPreHandler;
import miui.systemui.notification.focus.FocusNotifUtils;
import miui.systemui.notification.focus.FocusNotificationController;
import miui.systemui.notification.focus.HideDeletedFocusController;
import miui.systemui.notification.focus.SignatureChecker;

public final class FocusNotificationController_Factory
implements e {
    private final F0.a autoDensityControllerProvider;
    private final F0.a contextProvider;
    private final F0.a focusNotifPreHandlerProvider;
    private final F0.a focusNotifUtilsProvider;
    private final F0.a hideDeletedFocusControllerProvider;
    private final F0.a lottieProgressManagerProvider;
    private final F0.a mainHandlerProvider;
    private final F0.a notificationChronometerManagerProvider;
    private final F0.a notificationSettingsManagerProvider;
    private final F0.a scopeProvider;
    private final F0.a signatureCheckerProvider;
    private final F0.a windowViewCreatorProvider;

    public FocusNotificationController_Factory(F0.a a2, F0.a a3, F0.a a4, F0.a a5, F0.a a6, F0.a a7, F0.a a8, F0.a a9, F0.a a10, F0.a a11, F0.a a12, F0.a a13) {
        this.scopeProvider = a2;
        this.contextProvider = a3;
        this.mainHandlerProvider = a4;
        this.windowViewCreatorProvider = a5;
        this.hideDeletedFocusControllerProvider = a6;
        this.notificationChronometerManagerProvider = a7;
        this.notificationSettingsManagerProvider = a8;
        this.focusNotifPreHandlerProvider = a9;
        this.lottieProgressManagerProvider = a10;
        this.focusNotifUtilsProvider = a11;
        this.signatureCheckerProvider = a12;
        this.autoDensityControllerProvider = a13;
    }

    public static FocusNotificationController_Factory create(F0.a a2, F0.a a3, F0.a a4, F0.a a5, F0.a a6, F0.a a7, F0.a a8, F0.a a9, F0.a a10, F0.a a11, F0.a a12, F0.a a13) {
        return new FocusNotificationController_Factory(a2, a3, a4, a5, a6, a7, a8, a9, a10, a11, a12, a13);
    }

    public static FocusNotificationController newInstance(E e2, Context context, Handler handler, a a2, HideDeletedFocusController hideDeletedFocusController, a a3, NotificationSettingsManager notificationSettingsManager, FocusNotifPreHandler focusNotifPreHandler, a a4, FocusNotifUtils focusNotifUtils, SignatureChecker signatureChecker, AutoDensityController autoDensityController) {
        return new FocusNotificationController(e2, context, handler, a2, hideDeletedFocusController, a3, notificationSettingsManager, focusNotifPreHandler, a4, focusNotifUtils, signatureChecker, autoDensityController);
    }

    public FocusNotificationController get() {
        return FocusNotificationController_Factory.newInstance((E)this.scopeProvider.get(), (Context)this.contextProvider.get(), (Handler)this.mainHandlerProvider.get(), d.a((F0.a)this.windowViewCreatorProvider), (HideDeletedFocusController)this.hideDeletedFocusControllerProvider.get(), d.a((F0.a)this.notificationChronometerManagerProvider), (NotificationSettingsManager)this.notificationSettingsManagerProvider.get(), (FocusNotifPreHandler)this.focusNotifPreHandlerProvider.get(), d.a((F0.a)this.lottieProgressManagerProvider), (FocusNotifUtils)this.focusNotifUtilsProvider.get(), (SignatureChecker)this.signatureCheckerProvider.get(), (AutoDensityController)this.autoDensityControllerProvider.get());
    }
}
