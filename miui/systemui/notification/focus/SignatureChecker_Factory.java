/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  E0.e
 *  F0.a
 *  android.content.Context
 */
package miui.systemui.notification.focus;

import E0.e;
import F0.a;
import android.content.Context;
import miui.systemui.notification.focus.SignatureChecker;

public final class SignatureChecker_Factory
implements e {
    private final a sysUiContextProvider;

    public SignatureChecker_Factory(a a2) {
        this.sysUiContextProvider = a2;
    }

    public static SignatureChecker_Factory create(a a2) {
        return new SignatureChecker_Factory(a2);
    }

    public static SignatureChecker newInstance(Context context) {
        return new SignatureChecker(context);
    }

    public SignatureChecker get() {
        return SignatureChecker_Factory.newInstance((Context)this.sysUiContextProvider.get());
    }
}
