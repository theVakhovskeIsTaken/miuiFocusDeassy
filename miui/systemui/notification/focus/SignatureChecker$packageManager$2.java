/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  U0.a
 *  android.content.Context
 *  android.content.pm.PackageManager
 *  kotlin.jvm.internal.p
 */
package miui.systemui.notification.focus;

import U0.a;
import android.content.Context;
import android.content.pm.PackageManager;
import kotlin.jvm.internal.p;

public static final class SignatureChecker.packageManager.2
extends p
implements a {
    final Context $sysUiContext;

    public SignatureChecker.packageManager.2(Context context) {
        this.$sysUiContext = context;
        super(0);
    }

    public final PackageManager invoke() {
        return this.$sysUiContext.getPackageManager();
    }
}
