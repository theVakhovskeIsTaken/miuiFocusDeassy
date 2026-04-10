/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.view.View$AccessibilityDelegate
 *  android.view.accessibility.AccessibilityNodeInfo
 *  com.android.systemui.plugins.miui.dynamicisland.DynamicIslandData
 *  kotlin.jvm.internal.o
 */
package miui.systemui.dynamicisland.window.content;

import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import com.android.systemui.plugins.miui.dynamicisland.DynamicIslandData;
import kotlin.jvm.internal.o;
import miui.systemui.dynamicisland.window.content.DynamicIslandBaseContentView;
import miui.systemui.dynamicisland.window.content.DynamicIslandContentView;

public static final class DynamicIslandContentView.updateAccessibility.2
extends View.AccessibilityDelegate {
    final DynamicIslandData $islandData;
    final DynamicIslandContentView this$0;

    public DynamicIslandContentView.updateAccessibility.2(DynamicIslandContentView dynamicIslandContentView, DynamicIslandData dynamicIslandData) {
        this.this$0 = dynamicIslandContentView;
        this.$islandData = dynamicIslandData;
    }

    public void onInitializeAccessibilityNodeInfo(View object, AccessibilityNodeInfo accessibilityNodeInfo) {
        o.g((Object)object, (String)"host");
        o.g((Object)accessibilityNodeInfo, (String)"info");
        super.onInitializeAccessibilityNodeInfo((View)object, accessibilityNodeInfo);
        accessibilityNodeInfo.setClickable(true);
        object = this.this$0;
        ((DynamicIslandContentView)((Object)object)).updateContentDescriptionIfNeed((View)((DynamicIslandBaseContentView)((Object)object)).getBigIslandView(), this.$islandData);
    }
}
