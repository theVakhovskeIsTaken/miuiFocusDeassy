/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  U0.a
 *  kotlin.jvm.internal.p
 */
package miui.systemui.notification.focus;

import U0.a;
import java.util.Set;
import kotlin.jvm.internal.p;
import miui.systemui.notification.focus.SignatureChecker;

public static final class SignatureChecker.sysUISignature.2
extends p
implements a {
    final SignatureChecker this$0;

    public SignatureChecker.sysUISignature.2(SignatureChecker signatureChecker) {
        this.this$0 = signatureChecker;
        super(0);
    }

    public final Set<String> invoke() {
        SignatureChecker signatureChecker = this.this$0;
        return signatureChecker.getSysUISignatures(signatureChecker.getPackageManager());
    }
}
