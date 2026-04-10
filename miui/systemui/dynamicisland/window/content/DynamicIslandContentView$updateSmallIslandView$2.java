/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  U0.o
 *  android.service.notification.StatusBarNotification
 *  android.util.Log
 *  com.android.systemui.plugins.miui.dynamicisland.DynamicIslandData
 *  kotlin.jvm.internal.d
 *  kotlin.jvm.internal.m
 *  kotlin.jvm.internal.o
 */
package miui.systemui.dynamicisland.window.content;

import android.service.notification.StatusBarNotification;
import android.util.Log;
import com.android.systemui.plugins.miui.dynamicisland.DynamicIslandData;
import kotlin.jvm.internal.d;
import kotlin.jvm.internal.m;
import kotlin.jvm.internal.o;
import miui.systemui.dynamicisland.event.DynamicIslandEvent;
import miui.systemui.dynamicisland.event.DynamicIslandEventCoordinator;
import miui.systemui.dynamicisland.window.DynamicIslandWindowView;
import miui.systemui.dynamicisland.window.DynamicIslandWindowViewController;
import miui.systemui.dynamicisland.window.content.DynamicIslandBaseContentView;
import miui.systemui.dynamicisland.window.content.DynamicIslandContentView;

public final class DynamicIslandContentView.updateSmallIslandView.2
extends m
implements U0.o {
    public DynamicIslandContentView.updateSmallIslandView.2(Object object) {
        super(2, object, DynamicIslandContentView.class, "emitEvent", "emitEvent(Lcom/android/systemui/plugins/miui/dynamicisland/DynamicIslandData;Lmiui/systemui/dynamicisland/event/DynamicIslandEvent;)Z", 0);
    }

    public final Boolean invoke(DynamicIslandData object, DynamicIslandEvent object2) {
        boolean bl;
        o.g((Object)object2, (String)"p1");
        Object object3 = (DynamicIslandContentView)((Object)((d)this).receiver);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("emitEvent ");
        stringBuilder.append(object2);
        Log.d((String)"DynamicIslandContentView", (String)stringBuilder.toString());
        if (object2 instanceof DynamicIslandEvent.DeletedDynamicIsland) {
            object2 = ((DynamicIslandBaseContentView)((Object)object3)).getDynamicIslandEventCoordinator();
            if (object2 != null && (object2 = ((DynamicIslandEventCoordinator)object2).getWindowView()) != null) {
                DynamicIslandWindowView.removeDynamicIslandData$default((DynamicIslandWindowView)((Object)object2), object, false, false, 6, null);
            }
            if ((object = object != null && (object = object.getExtras()) != null ? (StatusBarNotification)object.getParcelable("miui.sbn", StatusBarNotification.class) : null) != null && (object2 = ((DynamicIslandBaseContentView)((Object)object3)).getDynamicIslandEventCoordinator()) != null && (object2 = ((DynamicIslandEventCoordinator)object2).getWindowView()) != null) {
                ((DynamicIslandWindowView)((Object)object2)).removeNotification((StatusBarNotification)object);
            }
            bl = true;
        } else {
            if (object2 instanceof DynamicIslandEvent.UpdateDynamicIsland && object != null && (object2 = ((DynamicIslandBaseContentView)((Object)object3)).getDynamicIslandEventCoordinator()) != null && (object2 = ((DynamicIslandEventCoordinator)object2).getWindowView()) != null) {
                float f = (object3 = ((DynamicIslandBaseContentView)((Object)object3)).getDynamicIslandEventCoordinator()) != null && (object3 = ((DynamicIslandEventCoordinator)object3).getWindowView()) != null && (object3 = ((DynamicIslandWindowView)((Object)object3)).getWindowViewController()) != null ? ((DynamicIslandWindowViewController)object3).getIslandMaxWidth() : 0.0f;
                DynamicIslandWindowView.updateDynamicIslandView$default((DynamicIslandWindowView)((Object)object2), object, false, f, false, 8, null);
            }
            bl = false;
        }
        return bl;
    }
}
