/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.o
 *  kotlin.jvm.internal.p
 */
package miui.systemui.notification.focus;

import java.util.Arrays;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.o;
import kotlin.jvm.internal.p;

public static final class SignatureChecker.toSHA256.1
extends p
implements Function1 {
    public static final SignatureChecker.toSHA256.1 INSTANCE = new /* invalid duplicate definition of identical inner class */;

    public final CharSequence invoke(byte by) {
        String string = String.format("%02x", Arrays.copyOf(new Object[]{by}, 1));
        o.f((Object)string, (String)"format(...)");
        return string;
    }
}
