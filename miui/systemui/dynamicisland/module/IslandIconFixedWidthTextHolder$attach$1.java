/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.util.Log
 *  android.view.View
 *  android.view.View$OnAttachStateChangeListener
 *  kotlin.jvm.internal.o
 *  miui.systemui.animation.FolmeKt
 *  miuix.animation.FolmeObject
 */
package miui.systemui.dynamicisland.module;

import android.util.Log;
import android.view.View;
import kotlin.jvm.internal.o;
import miui.systemui.animation.FolmeKt;
import miui.systemui.dynamicisland.module.IslandIconFixedWidthTextHolder;
import miuix.animation.FolmeObject;

public static final class IslandIconFixedWidthTextHolder.attach.1
implements View.OnAttachStateChangeListener {
    final IslandIconFixedWidthTextHolder this$0;

    public IslandIconFixedWidthTextHolder.attach.1(IslandIconFixedWidthTextHolder islandIconFixedWidthTextHolder) {
        this.this$0 = islandIconFixedWidthTextHolder;
    }

    public void onViewAttachedToWindow(View view) {
        o.g((Object)view, (String)"p0");
        Log.d((String)"IslandIconFixedWidthTextHolder", (String)"onViewAttachedToWindow");
    }

    public void onViewDetachedFromWindow(View view) {
        o.g((Object)view, (String)"p0");
        Log.d((String)"IslandIconFixedWidthTextHolder", (String)"onViewDetachedFromWindow");
        FolmeKt.getFolme((FolmeObject)this.this$0).end(new Object[]{"dynamic_title_trans_x", "dynamic_content_trans_x", "dynamic_content_trans_y", "dynamic_title_scale_x", "dynamic_title_scale_y"});
        FolmeKt.getFolme((FolmeObject)this.this$0).clean();
        this.this$0.titleScheduleUpdate();
        this.this$0.contentScheduleUpdate();
    }
}
