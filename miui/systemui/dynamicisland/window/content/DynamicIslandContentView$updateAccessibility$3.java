/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  G0.j
 *  G0.j$a
 *  G0.k
 *  android.os.Bundle
 *  android.util.Log
 *  android.view.View
 *  android.view.View$AccessibilityDelegate
 *  android.view.accessibility.AccessibilityNodeInfo
 *  android.view.accessibility.AccessibilityNodeInfo$AccessibilityAction
 *  kotlin.jvm.internal.o
 */
package miui.systemui.dynamicisland.window.content;

import G0.j;
import G0.k;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import kotlin.jvm.internal.o;
import miui.systemui.dynamicisland.window.content.DynamicIslandContentView;

public static final class DynamicIslandContentView.updateAccessibility.3
extends View.AccessibilityDelegate {
    final DynamicIslandContentView this$0;

    public DynamicIslandContentView.updateAccessibility.3(DynamicIslandContentView dynamicIslandContentView) {
        this.this$0 = dynamicIslandContentView;
    }

    public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfo accessibilityNodeInfo) {
        o.g((Object)view, (String)"host");
        o.g((Object)accessibilityNodeInfo, (String)"info");
        super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfo);
        accessibilityNodeInfo.setClickable(true);
        accessibilityNodeInfo.addAction(AccessibilityNodeInfo.AccessibilityAction.ACTION_CLICK);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public boolean performAccessibilityAction(View object, int n, Bundle object2) {
        block6: {
            Throwable throwable2;
            block5: {
                boolean bl;
                block4: {
                    block3: {
                        o.g((Object)object, (String)"host");
                        DynamicIslandContentView dynamicIslandContentView = this.this$0;
                        try {
                            j.a a2 = j.a;
                            if (n != 16) break block3;
                            dynamicIslandContentView.onIslandClick();
                            bl = true;
                            break block4;
                        }
                        catch (Throwable throwable2) {
                            break block5;
                        }
                    }
                    bl = super.performAccessibilityAction((View)object, n, object2);
                }
                object = j.a((Object)bl);
                break block6;
            }
            object = j.a;
            object = j.a((Object)k.a((Throwable)throwable2));
        }
        object2 = j.b((Object)object);
        if (object2 == null) {
            return (Boolean)object;
        }
        object = new StringBuilder();
        ((StringBuilder)object).append("performAccessibilityAction error: action=");
        ((StringBuilder)object).append(n);
        Log.e((String)"DynamicIslandContentView", (String)((StringBuilder)object).toString(), (Throwable)object2);
        object = Boolean.FALSE;
        return (Boolean)object;
    }
}
