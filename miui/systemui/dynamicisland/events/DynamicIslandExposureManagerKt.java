/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.internal.o
 */
package miui.systemui.dynamicisland.events;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import kotlin.jvm.internal.o;

public final class DynamicIslandExposureManagerKt {
    public static final String toDateTime(long l, String string) {
        o.g((Object)string, (String)"pattern");
        string = new SimpleDateFormat(string, Locale.getDefault()).format(new Date(l));
        o.f((Object)string, (String)"format(...)");
        return string;
    }

    public static /* synthetic */ String toDateTime$default(long l, String string, int n, Object object) {
        if ((n & 1) != 0) {
            string = "yyyy-MM-dd HH:mm:ss";
        }
        return DynamicIslandExposureManagerKt.toDateTime(l, string);
    }
}
