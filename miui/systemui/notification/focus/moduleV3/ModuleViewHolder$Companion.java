/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.text.TextUtils
 *  kotlin.jvm.internal.h
 */
package miui.systemui.notification.focus.moduleV3;

import android.text.TextUtils;
import kotlin.jvm.internal.h;

public static final class ModuleViewHolder.Companion {
    private ModuleViewHolder.Companion() {
    }

    public /* synthetic */ ModuleViewHolder.Companion(h h2) {
        this();
    }

    public final boolean isContinuousClick(String string) {
        if (string == null) {
            return true;
        }
        long l = System.currentTimeMillis();
        long l2 = l - lastClickTime;
        if (0L <= l2 && l2 < 100L && TextUtils.equals((CharSequence)lastClickNotif, (CharSequence)string)) {
            return true;
        }
        lastClickNotif = string;
        lastClickTime = l;
        return false;
    }
}
