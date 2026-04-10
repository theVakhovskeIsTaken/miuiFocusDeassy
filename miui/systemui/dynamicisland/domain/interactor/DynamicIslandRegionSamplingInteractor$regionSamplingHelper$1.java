/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.graphics.Rect
 *  android.view.View
 *  kotlin.jvm.functions.Function1
 *  kotlin.jvm.internal.o
 *  kotlin.jvm.internal.p
 */
package miui.systemui.dynamicisland.domain.interactor;

import android.graphics.Rect;
import android.view.View;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.o;
import kotlin.jvm.internal.p;
import miui.systemui.dynamicisland.domain.interactor.DynamicIslandRegionSamplingInteractor;

public static final class DynamicIslandRegionSamplingInteractor.regionSamplingHelper.1
extends p
implements Function1 {
    final DynamicIslandRegionSamplingInteractor this$0;

    public DynamicIslandRegionSamplingInteractor.regionSamplingHelper.1(DynamicIslandRegionSamplingInteractor dynamicIslandRegionSamplingInteractor) {
        this.this$0 = dynamicIslandRegionSamplingInteractor;
        super(1);
    }

    public final Rect invoke(View view) {
        o.g((Object)view, (String)"$this$create");
        return (Rect)this.this$0.statusBarAreaRepository.getStatusBarArea().getValue();
    }
}
