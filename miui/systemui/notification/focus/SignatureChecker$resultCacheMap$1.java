/*
 * Decompiled with CFR 0.152.
 */
package miui.systemui.notification.focus;

import java.util.LinkedHashMap;
import java.util.Map;

public static final class SignatureChecker.resultCacheMap.1
extends LinkedHashMap<String, Boolean> {
    @Override
    public boolean removeEldestEntry(Map.Entry<String, Boolean> entry) {
        boolean bl = this.size() > 50;
        return bl;
    }
}
