/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.widget.Button
 *  androidx.core.view.AccessibilityDelegateCompat
 *  androidx.core.view.accessibility.AccessibilityNodeInfoCompat
 *  kotlin.jvm.internal.o
 */
package miui.systemui.notification.focus.moduleV3;

import android.view.View;
import android.widget.Button;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import kotlin.jvm.internal.o;

public static final class ModuleViewHolder.setButtonAccessibilityDelegate.1.1
extends AccessibilityDelegateCompat {
    public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        o.g((Object)view, (String)"host");
        o.g((Object)accessibilityNodeInfoCompat, (String)"info");
        super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
        accessibilityNodeInfoCompat.setClassName((CharSequence)Button.class.getName());
    }
}
