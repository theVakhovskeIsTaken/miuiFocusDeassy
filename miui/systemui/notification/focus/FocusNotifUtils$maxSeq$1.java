/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.jvm.internal.o
 */
package miui.systemui.notification.focus;

import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.o;

public static final class FocusNotifUtils.maxSeq.1
extends LinkedHashMap<String, Long> {
    @Override
    public boolean removeEldestEntry(Map.Entry<String, Long> entry) {
        o.g(entry, (String)"eldest");
        boolean bl = this.size() > 50;
        return bl;
    }
}
