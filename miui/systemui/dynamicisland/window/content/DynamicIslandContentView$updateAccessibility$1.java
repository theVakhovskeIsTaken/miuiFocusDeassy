/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.view.View$AccessibilityDelegate
 *  android.view.accessibility.AccessibilityNodeInfo
 *  kotlin.jvm.internal.o
 */
package miui.systemui.dynamicisland.window.content;

import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import kotlin.jvm.internal.o;

public static final class DynamicIslandContentView.updateAccessibility.1
extends View.AccessibilityDelegate {
    public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfo accessibilityNodeInfo) {
        o.g((Object)view, (String)"host");
        o.g((Object)accessibilityNodeInfo, (String)"info");
        super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfo);
        accessibilityNodeInfo.setClickable(true);
    }
}
