/*
 * Decompiled with CFR 0.152.
 */
package miui.systemui.notification.focus;

import java.util.LinkedHashMap;
import java.util.Map;
import miui.systemui.notification.focus.HideDeletedFocusController;

public static final class HideDeletedFocusController.mDeletedNotifs.1
extends LinkedHashMap<String, Boolean> {
    final HideDeletedFocusController this$0;

    public HideDeletedFocusController.mDeletedNotifs.1(HideDeletedFocusController hideDeletedFocusController) {
        this.this$0 = hideDeletedFocusController;
    }

    @Override
    public boolean removeEldestEntry(Map.Entry<String, Boolean> entry) {
        String string;
        boolean bl = this.size() > 50;
        if (bl && (string = entry != null ? entry.getKey() : null) != null) {
            this.this$0.cancelAlarm(entry.getKey());
        }
        return bl;
    }
}
